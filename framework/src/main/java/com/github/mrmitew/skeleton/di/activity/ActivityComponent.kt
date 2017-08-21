package com.github.mrmitew.skeleton.di.activity

import android.app.Activity
import dagger.MembersInjector


interface ActivityComponent<A : Activity> : MembersInjector<A>