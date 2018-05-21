package com.helin.template.utils.network;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * @author helin
 * create by 2018-05-17
 */
public class RxHelper {

    /**
     * 利用Observable.takeUntil()停止网络请求
     *
     * @param event
     * @param lifecycleSubject
     * @param <T>
     * @return
     */
    public <T> ObservableTransformer<T, T> bindUntilEvent(final ActivityLifeCycleEvent event, final PublishSubject<ActivityLifeCycleEvent> lifecycleSubject) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                Observable<ActivityLifeCycleEvent> compareLifecycleObservable =
                        lifecycleSubject.filter(new Predicate<ActivityLifeCycleEvent>() {
                            @Override
                            public boolean test(ActivityLifeCycleEvent activityLifeCycleEvent) throws Exception {
                                return activityLifeCycleEvent.equals(event);
                            }
                        });
                return observable.takeUntil(compareLifecycleObservable);
            }
        };
    }

    /**
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<String, T> handleResult(final ActivityLifeCycleEvent event, final PublishSubject<ActivityLifeCycleEvent> lifecycleSubject) {
        return new ObservableTransformer<String, T>() {
            @Override
            public ObservableSource<T> apply(Observable<String> observable) {

                Observable<ActivityLifeCycleEvent> compareLifecycleObservable =
                        lifecycleSubject.filter(new Predicate<ActivityLifeCycleEvent>() {
                            @Override
                            public boolean test(ActivityLifeCycleEvent activityLifeCycleEvent) {
                                return activityLifeCycleEvent.equals(event);
                            }
                        });
                return (ObservableSource<T>) observable.takeUntil(compareLifecycleObservable).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread());
//                return observable.flatMap(new Function<String, Observable<T>>() {
//                    @Override
//                    public Observable<T> apply(final String tBaseEntity)  {
//
//                        return Observable.create(new ObservableOnSubscribe<T>() {
//                            @Override
//                            public void subscribe(ObservableEmitter<T> observableEmitter) throws Exception {
//                                try {
//                                    observableEmitter.onNext((T) tBaseEntity);
//                                    observableEmitter.onComplete();
//                                } catch (Exception e) {
//                                    observableEmitter.onError(e);
//                                }
//                            }
//                        });
//
////                        if (tBaseEntity.getCode() == 200) {
////                            return createData(tBaseEntity.getData());
////                        } else {
////                            return Observable.error(new ApiException(tBaseEntity.getCode()));
////                        }
//                    }
//
//                }).takeUntil(compareLifecycleObservable).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 创建成功的数据
     *
     * @param data
     * @param <T>
     * @return
     */
    private static <T> Observable<T> createData(final T data) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> observableEmitter) throws Exception {
                try {
                    observableEmitter.onNext(data);
                    observableEmitter.onComplete();
                } catch (Exception e) {
                    observableEmitter.onError(e);
                }
            }

        });

    }


}
