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
class PickSchulteCellUseCase
@Inject constructor(threadExecutor: ThreadExecutor,
                    postExecutionThread: PostExecutionThread,
                    private val schulteManager: SchulteManager)
    : UseCase<Int, Unit>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(param: Int): Observable<Unit> {
        return Observable.fromCallable { schulteManager.pickNumber(param) }
    }
}