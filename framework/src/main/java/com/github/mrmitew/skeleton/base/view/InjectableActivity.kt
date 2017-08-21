package com.github.mrmitew.skeleton.base.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.github.mrmitew.skeleton.AndroidApplication
import com.github.mrmitew.skeleton.di.activity.HasActivitySubcomponentBuilders

abstract class InjectableActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupActivityComponent()
    }

    protected fun setupActivityComponent() {
        injectMembers(AndroidApplication[this])
    }

    protected abstract fun injectMembers(
            hasActivitySubcomponentBuilders: HasActivitySubcomponentBuilders)

}