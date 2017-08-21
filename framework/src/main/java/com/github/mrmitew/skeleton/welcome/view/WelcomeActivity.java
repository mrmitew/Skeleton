package com.github.mrmitew.skeleton.welcome.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.github.mrmitew.skeleton.R;
import com.github.mrmitew.skeleton.base.view.BaseActivity;
import com.github.mrmitew.skeleton.di.activity.HasActivitySubcomponentBuilders;
import com.github.mrmitew.skeleton.welcome.di.WelcomeActivityComponent;
import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;

public class WelcomeActivity extends BaseActivity implements RepoSearchView {
    private static final String TAG = "WelcomeActivity";

    @BindView(R.id.tv_welcome_message)
    TextView mTvWelcomeMessage;

    @BindView(R.id.et_username)
    EditText mEtUsername;

    @Inject
    WelcomePresenter mBasePresenter;

    RepoListViewState.RenderVisitor mRenderVisitor = new RepoListViewState.RenderVisitor() {
        @Override
        public void visit(final RepoListViewState.SearchNotStartedYet state) {
            // TODO: 8/21/17  render
            Log.d(TAG, "render: SearchNotStartedYet");
        }

        @Override
        public void visit(final RepoListViewState.Loading state) {
            // TODO: 8/21/17  render
            Log.d(TAG, "render: Loading");
        }

        @Override
        public void visit(final RepoListViewState.EmptyResult state) {
            // TODO: 8/21/17  render
            Log.d(TAG, "render: EmptyResult");
        }

        @Override
        public void visit(final RepoListViewState.SearchResult state) {
            // TODO: 8/21/17  render
            Log.d(TAG, "render: SearchResult");
        }

        @Override
        public void visit(final RepoListViewState.Error state) {
            // TODO: 8/21/17  render
            Log.e(TAG, "render: ", state.getError());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        mCompositeDisposable.add(mBasePresenter);
        mBasePresenter.bindIntents();
    }

    @Override
    protected void injectMembers(final HasActivitySubcomponentBuilders hasActivitySubcomponentBuilders) {
        ((WelcomeActivityComponent.Builder) hasActivitySubcomponentBuilders.getActivityComponentBuilder(WelcomeActivity.class))
                .activityModule(new WelcomeActivityComponent.WelcomeActivityModule(this))
                .build()
                .injectMembers(this);
    }

    @Override
    public void render(final RepoListViewState repoListViewState) {
        repoListViewState.accept(mRenderVisitor);
    }

    @Override
    public Observable<CharSequence> getSearchIntent() {
        return RxTextView.textChanges(mEtUsername)
                .filter(queryString -> queryString.length() > 3 || queryString.length() == 0)
                .debounce(500, TimeUnit.MILLISECONDS)
                .startWith("");
    }

    @OnClick(R.id.btn_submit)
    protected void onSubmitClicked() {
        // TODO: 8/18/17
    }
}