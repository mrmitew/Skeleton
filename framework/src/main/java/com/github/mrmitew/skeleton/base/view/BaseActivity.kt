package com.github.mrmitew.skeleton.base.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import icepick.Icepick
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity: InjectableActivity() {

    private val TAG : String = BaseActivity::class.java.simpleName

    protected val mCompositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupActivityComponent()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Icepick.restoreInstanceState(this, outState)
    }

    override fun onDestroy() {
        super.onDestroy()
        mCompositeDisposable.dispose()
    }

}

