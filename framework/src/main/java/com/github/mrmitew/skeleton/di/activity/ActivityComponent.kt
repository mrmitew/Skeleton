package com.github.mrmitew.skeleton.di.activity

import android.support.v4.app.FragmentActivity
import dagger.MembersInjector

interface ActivityComponent<A>:MembersInjector<A> where A:FragmentActivity {
}