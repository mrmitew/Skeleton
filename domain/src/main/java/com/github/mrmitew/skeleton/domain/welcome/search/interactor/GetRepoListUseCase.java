package com.github.mrmitew.skeleton.domain.welcome.search.interactor;

import com.github.mrmitew.skeleton.domain.common.UseCase;
import com.github.mrmitew.skeleton.domain.executor.PostExecutionThread;
import com.github.mrmitew.skeleton.domain.executor.ThreadExecutor;
import com.github.mrmitew.skeleton.domain.repository.Repository;
import com.github.mrmitew.skeleton.domain.repository.entity.Repo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.schedulers.Schedulers;

public class GetRepoListUseCase extends UseCase<String, List<Repo>> {
    private final ThreadExecutor mThreadExecutor;
    private final PostExecutionThread mPostExecutionThread;
    private final Repository mRepository;

    @Inject
    GetRepoListUseCase(ThreadExecutor threadExecutor,
                       PostExecutionThread postExecutionThread,
                       Repository repository) {
        mThreadExecutor = threadExecutor;
        mPostExecutionThread = postExecutionThread;
        mRepository = repository;
    }

    public <O> Observable<O> buildUseCase(String searchString,
                                          ObservableTransformer<List<Repo>, O> transformer) {
        return getObservable(searchString)
                .compose(transformer)
                .subscribeOn(Schedulers.from(mThreadExecutor))
                .observeOn(mPostExecutionThread.getScheduler());
    }

    @Override
    public Observable<List<Repo>> buildUseCase(String searchString) {
        return getObservable(searchString)
                .subscribeOn(Schedulers.from(mThreadExecutor))
                .observeOn(mPostExecutionThread.getScheduler());
    }

    private Observable<List<Repo>> getObservable(final String searchString) {
        return mRepository.getRepoList(searchString)
                .toObservable();
    }
}
