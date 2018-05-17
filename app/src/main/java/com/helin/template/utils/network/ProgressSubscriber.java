package com.helin.template.utils.network;


import android.app.ProgressDialog;
import android.content.Context;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author helin
 * create by 2018-05-17
 */
public  abstract class ProgressSubscriber <T> implements ProgressCancelListener, Observer<T> {


    private ProgressDialog dialogHandler;
    private Disposable dis;

    public ProgressSubscriber(Context context) {
        dialogHandler = new ProgressDialog(context);
    }



    /**
     * 显示Dialog
     */
    public void showProgressDialog(){
        if (dialogHandler != null) {
            dialogHandler.show();
        }
    }


    @Override
    public void onSubscribe(Disposable disposable) {
        this.dis=disposable;
    }

    @Override
    public void onComplete() {
        dismissProgressDialog();
    }


    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    /**
     * 隐藏Dialog
     */
    private void dismissProgressDialog(){
        if (dialogHandler != null) {
            dialogHandler.dismiss();;
            dialogHandler=null;
        }
    }
    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (false) { //这里自行替换判断网络的代码
            _onError("网络不可用");
        } else if (e instanceof ApiException) {
            _onError(e.getMessage());
        } else {
            _onError("请求失败，请稍后再试...");
        }
        dismissProgressDialog();
    }



    @Override
    public void onCancelProgress() {
        if (!dis.isDisposed()) {
            dis.dispose();
        }
    }
    protected abstract void _onNext(T t);
    protected abstract void _onError(String message);
}
