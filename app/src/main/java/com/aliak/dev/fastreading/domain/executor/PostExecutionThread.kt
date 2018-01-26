package com.aliak.dev.fastreading.domain.executor

import rx.Scheduler

/**
 * @author Aliaksandr Novik
 */
interface PostExecutionThread {
    fun getScheduler() : Scheduler
}