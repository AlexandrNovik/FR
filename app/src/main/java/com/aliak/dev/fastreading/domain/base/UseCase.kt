package com.aliak.dev.fastreading.domain.base

import com.aliak.dev.fastreading.domain.executor.PostExecutionThread
import rx.Observable
import rx.Scheduler
import rx.Subscriber
import rx.Subscription
import rx.observers.Subscribers
import rx.schedulers.Schedulers
import rx.subscriptions.Subscriptions
import timber.log.Timber
import java.util.concurrent.Executor

/**
 * @author Aliaksandr Novik
 */
abstract class UseCase<in ParamType, ResultType> protected constructor(
        protected val scheduler: Scheduler,
        protected val postExecutionThread: Scheduler) {

    constructor(threadExecutor: Executor, postExecutionThread: PostExecutionThread)
            : this(Schedulers.from(threadExecutor), postExecutionThread.getScheduler())

    constructor(threadExecutor: Scheduler, postExecutionThread: PostExecutionThread)
            : this(threadExecutor, postExecutionThread.getScheduler())

    protected var subscription: Subscription = Subscriptions.empty()

    /**
     * Builds an [rx.Observable] which will be used when executing the current [UseCase].
     */
    abstract fun buildUseCaseObservable(param: ParamType): Observable<ResultType>

    /**
     * Executes the current use case.

     * @param useCaseSubscriber The guy who will be listen to the observable getRetrofit
     * * with [.buildUseCaseObservable].
     */
    open fun execute(param: ParamType, useCaseSubscriber: Subscriber<ResultType> = Subscribers.empty()) {
        subscription = buildUseCaseObservable(param)
                .subscribeOn(scheduler)
                .observeOn(postExecutionThread)
                .subscribe(useCaseSubscriber)
    }

    /**
     * Unsubscribes getViewTypeFrom current [rx.Subscription].
     */
    open fun unsubscribe() {
        if (!subscription.isUnsubscribed) {
            subscription.unsubscribe()
        }
    }

    class UseCaseSubscriber<ResultType>(private val next: (value: ResultType) -> Unit,
                                        private val error: (e: Throwable) -> Unit =
                                        {
                                            Timber.e(it.message)
                                        },
                                        private val complete: () -> Unit = {})
        : Subscriber<ResultType>() {
        override fun onNext(t: ResultType) {
            next(t)
        }

        override fun onCompleted() {
            complete()
        }

        override fun onError(e: Throwable?) {
            e?.let { error(it) }
        }
    }

}
