package com.github.mrmitew.skeleton.domain.common;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public abstract class UseCase<I, O> {
    protected abstract Observable<O> buildUseCase(I input);

    public Disposable execute(
            Observable<O> observable,
            Consumer<O> onNext,
            Consumer<Throwable> onError) {
        return observable
                .subscribe(onNext, onError);
    }
}
