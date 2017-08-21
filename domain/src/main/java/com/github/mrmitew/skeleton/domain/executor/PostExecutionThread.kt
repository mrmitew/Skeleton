package com.github.mrmitew.skeleton.domain.executor

import io.reactivex.Scheduler

interface PostExecutionThread {
    fun getScheduler() : Scheduler
}