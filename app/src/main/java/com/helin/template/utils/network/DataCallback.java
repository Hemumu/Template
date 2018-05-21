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
        try {
            onResponse(parseNetworkResponse((String) t));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(Throwable e) {
        onErrors(e);
    }

    public  void onBefore(Disposable disposable ){

    };
    public  void onAfter( ){

    };

    public abstract void onErrors( Throwable e);

    public abstract void onResponse(T response);

    public abstract T parseNetworkResponse(String response) throws Exception;


}
