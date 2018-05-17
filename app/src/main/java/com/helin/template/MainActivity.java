package com.helin.template;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.helin.template.utils.network.ActivityLifeCycleEvent;
import com.helin.template.utils.network.HttpUtil;

import io.reactivex.subjects.PublishSubject;

/**
 * @author helin
 * create by 2018-05-17
 */
public class MainActivity extends AppCompatActivity {

    public final PublishSubject<ActivityLifeCycleEvent> lifecycleSubject = PublishSubject.create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lifecycleSubject.onNext(ActivityLifeCycleEvent.CREATE);
        doGet();
    }

    private void doGet() {
        HttpUtil.getInstance().doGet(lifecycleSubject,this);
    }


    @Override
    protected void onPause() {
        lifecycleSubject.onNext(ActivityLifeCycleEvent.PAUSE);
        super.onPause();
    }

    @Override
    protected void onStop() {
        lifecycleSubject.onNext(ActivityLifeCycleEvent.STOP);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifecycleSubject.onNext(ActivityLifeCycleEvent.DESTROY);
    }

}
