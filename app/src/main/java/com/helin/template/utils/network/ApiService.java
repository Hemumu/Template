package com.helin.template.utils.network;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author helin
 * create by 2018-05-17
 */
public interface  ApiService {
    /**
     * 获取配置信息
     * @return
     */
    @GET("/App_Config/appConfig/getAppCinfig")
    Observable<BaseEntity<AppConfigBean>> getAppConfig(@Query("siteId") String siteId, @Query("tagName") String tagName);
}
