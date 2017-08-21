package com.github.mrmitew.skeleton.welcome.view;

import io.reactivex.Observable;

public interface RepoSearchView {
    void render(RepoListViewState repoListViewState);

    Observable<CharSequence> getSearchIntent();
}
