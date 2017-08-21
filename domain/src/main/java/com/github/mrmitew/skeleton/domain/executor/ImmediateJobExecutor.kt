package com.github.mrmitew.skeleton.domain.executor

class ImmediateJobExecutor: ThreadExecutor {

    override fun execute(p0: Runnable?) {
        check(p0 != null){
            "Runnable cannot be null for execution"
        }
        p0?.run()
    }
}