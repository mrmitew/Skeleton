package com.github.mrmitew.skeleton.repository.github.mapper;

import com.github.mrmitew.skeleton.data.repository.github.entity.GithubRepo;
import com.github.mrmitew.skeleton.domain.repository.entity.Repo;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class RepoMapper implements Function<GithubRepo, ObservableSource<Repo>> {
    @Override
    public ObservableSource<Repo> apply(final GithubRepo githubRepo) throws Exception {
        return Observable.just(Repo.builder()
                .setId(githubRepo.getId())
                .setName(githubRepo.getName())
                .setUrl(githubRepo.getUrl())
                .build());
    }
}
