package com.github.mrmitew.skeleton.base.view

import android.os.Bundle
import butterknife.Unbinder
import icepick.Icepick

abstract class BaseFragment : InjectableFragment() {
    protected val mUnbinder: Unbinder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Icepick.restoreInstanceState(this, savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Icepick.saveInstanceState(this, outState)
    }

    override fun onDestroy() {
        super.onDestroy()
        mUnbinder?.unbind()
    }

}