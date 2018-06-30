package com.anshulvyas.domain.executor

import io.reactivex.Scheduler

/**
 * Schedular from RxJava
 * Domain layer knows we use RxJava
 * don't want to have any knowledge of RxAndroid
 */
interface PostExecutionThread {
    val scheduler : Scheduler
}