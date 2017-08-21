package com.github.mrmitew.skeleton.base.view

import android.os.Bundle
import android.support.v4.app.Fragment
import com.github.mrmitew.skeleton.di.fragment.HasFragmentSubComponentBuilders

abstract class InjectableFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupFragmentComponent()
    }

    protected fun setupFragmentComponent() {
        injectMembers(activity as HasFragmentSubComponentBuilders)
    }

    protected abstract fun injectMembers(hasFragmentSubcomponentBuilders: HasFragmentSubComponentBuilders)


}