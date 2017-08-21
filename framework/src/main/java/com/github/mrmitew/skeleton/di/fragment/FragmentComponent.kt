package com.github.mrmitew.skeleton.di.fragment

import android.app.Fragment
import dagger.MembersInjector

interface FragmentComponent<A: Fragment> : MembersInjector<A>