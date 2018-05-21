package com.helin.template.utils.network;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AppConfigBean  {


    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private AppConfig data;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AppConfig getData() {
        return data;
    }

    public void setData(AppConfig data) {
        this.data = data;
    }

    class  AppConfig implements Serializable{
        /**
         *
         */
        private String appName;
        // 开屏广告
        private int appColor;
        private int sectionId;
        private int siteId;
        private String advUrl;
        private String sectionName;
        private int minComment;
        private int bannerNum;
        /**
         * 底部菜单
         */
        /**
         * 二级菜单
         */
        private int minLike;
        /**
         * 乡镇栏目ID
         */
        private String ruralSection;
        /**
         * 别称
         */
        private String tagName;
        /**
         * 新闻样式
         */
        private String newsStyle;
        /**
         * 新的开屏广告
         */
        /**
         * 开屏广告样式
         */
        private String advStyle;
        /**
         * Logo图片
         */
        private String appLogo;
        /**
         * 首页布局样式
         */
        private String homeStyle;
        /**
         * app标题栏图片
         */
        private String appTitleLogo;

        private String cmsUrl;
        private String shopUrl;
        private String circelUrl;
        private String userUrl;
        private int sectionBannerNum;
        /**
         *分享视频视频开启播放时长限制
         */
        private int shareLimit;
        /**
         * Ios标题栏iphoneX适配图
         */
        private String appTitleLogoX;
        /**
         * 下载地址
         */
        private String downloadUrl;
        /**
         * 三级菜单
         */

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        public int getAppColor() {
            return appColor;
        }

        public void setAppColor(int appColor) {
            this.appColor = appColor;
        }

        public int getSectionId() {
            return sectionId;
        }

        public void setSectionId(int sectionId) {
            this.sectionId = sectionId;
        }

        public int getSiteId() {
            return siteId;
        }

        public void setSiteId(int siteId) {
            this.siteId = siteId;
        }

        public String getAdvUrl() {
            return advUrl;
        }

        public void setAdvUrl(String advUrl) {
            this.advUrl = advUrl;
        }

        public String getSectionName() {
            return sectionName;
        }

        public void setSectionName(String sectionName) {
            this.sectionName = sectionName;
        }

        public int getMinComment() {
            return minComment;
        }

        public void setMinComment(int minComment) {
            this.minComment = minComment;
        }

        public int getBannerNum() {
            return bannerNum;
        }

        public void setBannerNum(int bannerNum) {
            this.bannerNum = bannerNum;
        }

        public int getMinLike() {
            return minLike;
        }

        public void setMinLike(int minLike) {
            this.minLike = minLike;
        }

        public String getRuralSection() {
            return ruralSection;
        }

        public void setRuralSection(String ruralSection) {
            this.ruralSection = ruralSection;
        }

        public String getTagName() {
            return tagName;
        }

        public void setTagName(String tagName) {
            this.tagName = tagName;
        }

        public String getNewsStyle() {
            return newsStyle;
        }

        public void setNewsStyle(String newsStyle) {
            this.newsStyle = newsStyle;
        }

        public String getAdvStyle() {
            return advStyle;
        }

        public void setAdvStyle(String advStyle) {
            this.advStyle = advStyle;
        }

        public String getAppLogo() {
            return appLogo;
        }

        public void setAppLogo(String appLogo) {
            this.appLogo = appLogo;
        }

        public String getHomeStyle() {
            return homeStyle;
        }

        public void setHomeStyle(String homeStyle) {
            this.homeStyle = homeStyle;
        }

        public String getAppTitleLogo() {
            return appTitleLogo;
        }

        public void setAppTitleLogo(String appTitleLogo) {
            this.appTitleLogo = appTitleLogo;
        }

        public String getCmsUrl() {
            return cmsUrl;
        }

        public void setCmsUrl(String cmsUrl) {
            this.cmsUrl = cmsUrl;
        }

        public String getShopUrl() {
            return shopUrl;
        }

        public void setShopUrl(String shopUrl) {
            this.shopUrl = shopUrl;
        }

        public String getCircelUrl() {
            return circelUrl;
        }

        public void setCircelUrl(String circelUrl) {
            this.circelUrl = circelUrl;
        }

        public String getUserUrl() {
            return userUrl;
        }

        public void setUserUrl(String userUrl) {
            this.userUrl = userUrl;
        }

        public int getSectionBannerNum() {
            return sectionBannerNum;
        }

        public void setSectionBannerNum(int sectionBannerNum) {
            this.sectionBannerNum = sectionBannerNum;
        }

        public int getShareLimit() {
            return shareLimit;
        }

        public void setShareLimit(int shareLimit) {
            this.shareLimit = shareLimit;
        }

        public String getAppTitleLogoX() {
            return appTitleLogoX;
        }

        public void setAppTitleLogoX(String appTitleLogoX) {
            this.appTitleLogoX = appTitleLogoX;
        }

        public String getDownloadUrl() {
            return downloadUrl;
        }

        public void setDownloadUrl(String downloadUrl) {
            this.downloadUrl = downloadUrl;
        }
    }

}
