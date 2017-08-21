package com.github.mrmitew.skeleton.domain.executor;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class UseCaseExecutor {
    public static <T> Disposable execute(
            Observable<T> observable,
            Consumer<T> onNext,
            Consumer<Throwable> onError) {
        return observable
                .subscribe(onNext, onError);
    }
}
