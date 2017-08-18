package com.github.mrmitew.skeleton.di.activity;

import android.app.Activity;

public interface HasActivitySubcomponentBuilders {
    ActivityComponentBuilder getActivityComponentBuilder(Class<? extends Activity> activityClass);
}