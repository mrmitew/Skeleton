package com.github.mrmitew.skeleton.repository.github;

import com.github.mrmitew.skeleton.data.repository.github.GithubRestApi;
import com.github.mrmitew.skeleton.domain.repository.Repository;
import com.github.mrmitew.skeleton.domain.repository.entity.Repo;
import com.github.mrmitew.skeleton.repository.github.mapper.RepoMapper;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public class GithubRepository implements Repository {
    private GithubRestApi mGithubRestApi;

    public GithubRepository(GithubRestApi githubRestApi) {
        mGithubRestApi = githubRestApi;
    }

    @Override
    public Single<List<Repo>> getRepoList(final String repoOwnerName) {
        return mGithubRestApi.listRepos(repoOwnerName)
                .toObservable()
                .flatMap(Observable::fromIterable)
                .flatMap(new RepoMapper())
                .toList();
    }
}
