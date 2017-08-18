package com.github.mrmitew.skeleton.welcome.view;

import android.os.Bundle;
import android.widget.TextView;

import com.github.mrmitew.skeleton.R;
import com.github.mrmitew.skeleton.base.view.BaseActivity;
import com.github.mrmitew.skeleton.di.activity.HasActivitySubcomponentBuilders;
import com.github.mrmitew.skeleton.welcome.di.WelcomeActivityComponent;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends BaseActivity {
    private static final String TAG = "WelcomeActivity";

    @BindView(R.id.tv_welcome_message)
    TextView mTvWelcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
    }

    @Override
    protected void injectMembers(final HasActivitySubcomponentBuilders hasActivitySubcomponentBuilders) {
        ((WelcomeActivityComponent.Builder) hasActivitySubcomponentBuilders.getActivityComponentBuilder(WelcomeActivity.class))
                .activityModule(new WelcomeActivityComponent.WelcomeActivityModule(this))
                .build()
                .injectMembers(this);
    }
}