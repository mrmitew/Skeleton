package com.github.mrmitew.skeleton.adapter.base.view.welcome;

import io.reactivex.Observable;

public interface RepoSearchView {
    void render(RepoListViewState repoListViewState);

    Observable<CharSequence> getSearchIntent();
}
