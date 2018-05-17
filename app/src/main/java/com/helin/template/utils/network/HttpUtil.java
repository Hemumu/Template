package com.helin.template.utils.network;

import android.content.Context;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

/**
 * @author helin
 * create by 2018-05-17
 */
public class HttpUtil {

    private static  final  String TAG ="HttpUtil";

    private HttpUtil(){}
    /**
     * 在访问HttpMethods时创建单例
     */
    private static class SingletonHolder {
        private static final HttpUtil INSTANCE = new HttpUtil();
    }
    /**
     * 获取单例
     */
    public static HttpUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }




    /**
     * 添加线程管理并订阅
     * @param ob
     * @param subscriber
     * @param cacheKey 缓存kay
     * @param event Activity 生命周期
     * @param lifecycleSubject
     * @param isSave 是否缓存
     * @param forceRefresh 是否强制刷新
     */
    public void toSubscribe(Observable ob, final ProgressSubscriber subscriber, String cacheKey, final ActivityLifeCycleEvent event, final PublishSubject<ActivityLifeCycleEvent> lifecycleSubject, boolean isSave, boolean forceRefresh) {
        //数据预处理
        ObservableTransformer<BaseEntity<Object>, Object> result = RxHelper.handleResult(event, lifecycleSubject);
        Observable observable = ob.compose(result)
                .doOnSubscribe(new Consumer() {
                    @Override
                    public void accept(Object o) throws Exception {
                        subscriber.showProgressDialog();
                    }
                });
        RetrofitCache.load(cacheKey, observable, isSave, forceRefresh).subscribe(subscriber);
    }

    public void doGet(PublishSubject<ActivityLifeCycleEvent> lifecycleSubject, Context context){

        Observable ob = Api.getDefault().getAppConfig("127", "sbys");
        HttpUtil.getInstance().toSubscribe(ob, new ProgressSubscriber<AppConfigBean>(context) {
            @Override
            protected void _onError(String message) {
                Log.e(TAG,message);
            }

            @Override
            protected void _onNext(AppConfigBean appConfigBean) {
                Log.e(TAG,appConfigBean.getAppName());
            }

        }, "cacheKey", ActivityLifeCycleEvent.PAUSE, lifecycleSubject, false, false);


//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Url.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
//        ApiService apiService = retrofit.create(ApiService.class);
//
//
//        apiService.getAppConfig("127", "sbys")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<BaseEntity>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "onSubscribe: ");
//                    }
//
//                    @Override
//                    public void onNext(BaseEntity movie) {
//                        Log.d(TAG, movie.getMessage());
//                        AppConfigBean appConfig = (AppConfigBean) movie.getData();
//                        Log.e(TAG, appConfig.getAppName());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "onError: " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete: Over!");
//                    }
//                });

    }


}
