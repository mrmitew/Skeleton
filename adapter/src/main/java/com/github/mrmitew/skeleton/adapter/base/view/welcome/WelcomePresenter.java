package com.github.mrmitew.skeleton.adapter.base.view.welcome;

import com.github.mrmitew.skeleton.adapter.base.view.base.BasePresenter;
import com.github.mrmitew.skeleton.adapter.base.view.welcome.interactor.GetRepoListUseCaseDecorator;
import com.github.mrmitew.skeleton.domain.executor.UseCaseExecutor;

public class WelcomePresenter extends BasePresenter {
    private final RepoSearchView mRepoSearchView;
    private final GetRepoListUseCaseDecorator mGetRepoListUseCaseDecorator;

    public WelcomePresenter(RepoSearchView repoSearchView,
                            GetRepoListUseCaseDecorator getRepoListUseCaseDecorator) {
        mRepoSearchView = repoSearchView;
        mGetRepoListUseCaseDecorator = getRepoListUseCaseDecorator;
    }

    @Override
    public void bindIntents() {
        getCompositeDisposable().add(
                UseCaseExecutor.execute(
                        mRepoSearchView.getSearchIntent()
                                .switchMap(text ->
                                        mGetRepoListUseCaseDecorator.buildUseCase(text.toString())),
                        mRepoSearchView::render,
                        Throwable::printStackTrace));
    }
}
