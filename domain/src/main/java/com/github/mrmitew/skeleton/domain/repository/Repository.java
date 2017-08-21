package com.github.mrmitew.skeleton.domain.repository;

import com.github.mrmitew.skeleton.domain.repository.entity.Repo;

import java.util.List;

import io.reactivex.Single;

public interface Repository {
    Single<List<Repo>> getRepoList(String repoOwnerName);
}
