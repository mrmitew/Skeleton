package com.github.mrmitew.skeleton.welcome.interactor;

import android.support.annotation.NonNull;

import com.github.mrmitew.skeleton.domain.common.UseCaseDecorator;
import com.github.mrmitew.skeleton.domain.repository.entity.Repo;
import com.github.mrmitew.skeleton.domain.welcome.search.interactor.GetRepoListUseCase;
import com.github.mrmitew.skeleton.welcome.view.RepoListViewState;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;

public class GetRepoListUseCaseDecorator extends UseCaseDecorator<String, RepoListViewState> {
    private GetRepoListUseCase mGetRepoListUseCase;

    @Inject
    GetRepoListUseCaseDecorator(GetRepoListUseCase getRepoListUseCase) {
        mGetRepoListUseCase = getRepoListUseCase;
    }

    public Observable<RepoListViewState> buildUseCase(String searchString) {
        return mGetRepoListUseCase
                .buildUseCase(searchString, getTransformation(searchString));
    }

    @NonNull
    private ObservableTransformer<List<Repo>, RepoListViewState> getTransformation(final String searchString) {
        return upstream -> {
            if (searchString.isEmpty()) {
                return Observable.just(new RepoListViewState.SearchNotStartedYet());
            }
            return upstream
                    .map(repoList -> {
                        if (repoList.isEmpty()) {
                            return RepoListViewState.EmptyResult.create(searchString);
                        }
                        return RepoListViewState.SearchResult.create(searchString, repoList);
                    })
                    .startWith(new RepoListViewState.Loading())
                    .onErrorReturn(error -> RepoListViewState.Error.create(searchString, error));
        };
    }
}
