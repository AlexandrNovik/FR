package com.aliak.dev.fastreading.domain.interaction

import com.aliak.dev.fastreading.domain.base.UseCase
import com.aliak.dev.fastreading.domain.executor.PostExecutionThread
import com.aliak.dev.fastreading.domain.executor.ThreadExecutor
import com.aliak.dev.fastreading.domain.training.schulte.SchulteManager
import rx.Observable
import javax.inject.Inject

/**
 * @author Aliaksandr Novik
 */
class SchulteResetUseCase @Inject constructor(threadExecutor: ThreadExecutor,
                                              postExecutionThread: PostExecutionThread,
                                              private val schulteManager: SchulteManager)
    : UseCase<Unit, Unit>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(param: Unit): Observable<Unit> {
        return Observable.fromCallable { schulteManager.reset() }
    }
}