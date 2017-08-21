package com.github.mrmitew.skeleton.domain.executor

import java.util.concurrent.*

class JobExecutor : ThreadExecutor {

    private val INITIAL_POOL_SIZE= 3
    private val MAX_POOL_SIZE = 5
    private val KEEP_ALIVE_TIME : Long = 10
    private val KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS

    private val workQueue by lazy { LinkedBlockingQueue<Runnable>() }
    private val threadFactory : ThreadFactory by lazy { JobThreadFactory() }

    private val threadPoolExecutor by lazy {
        ThreadPoolExecutor(INITIAL_POOL_SIZE,MAX_POOL_SIZE,KEEP_ALIVE_TIME,
                KEEP_ALIVE_TIME_UNIT,workQueue,threadFactory) }

    override fun execute(p0: Runnable?) {
        threadPoolExecutor.execute(p0)
    }

    private class JobThreadFactory : ThreadFactory {
        private var counter = 0
        private val THREAD_NAME = "android"

        override fun newThread(runnable: Runnable): Thread {
            return Thread(runnable, String.format("%s_%s",THREAD_NAME, counter++))
        }
    }
}