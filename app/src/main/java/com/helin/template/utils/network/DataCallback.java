package com.helin.template.utils.network;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class DataCallback<T> implements Observer<T> {


    @Override
    public void onComplete() {
        onAfter();
    }

    @Override
    public void onSubscribe(Disposable disposable) {
        onBefore(disposable);
    }


    @Override
    public void onNext(T t) {
        onResponse(t);
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof ApiException) {
            onErrors(e);
        } else {
            onErrors(e);
        }
    }

    public  void onBefore(Disposable disposable ){

    };
    public  void onAfter( ){

    };

    public abstract void onErrors( Throwable e);

    public abstract void onResponse(T response);


}
