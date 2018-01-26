package com.aliak.dev.fastreading.domain.executor

import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Singleton

/**
 * @author Aliaksandr Novik
 */
@Singleton
class UIThread : PostExecutionThread {
    override fun getScheduler(): Scheduler = AndroidSchedulers.mainThread()
}