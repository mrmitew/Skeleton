package com.github.mrmitew.skeleton.repository.di;

import com.github.mrmitew.skeleton.data.repository.github.GithubRestApi;
import com.github.mrmitew.skeleton.domain.repository.Repository;
import com.github.mrmitew.skeleton.repository.github.GithubRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    @Provides
    @Singleton
    Repository providesRepository(GithubRestApi githubRestApi) {
        return new GithubRepository(githubRestApi);
    }
}