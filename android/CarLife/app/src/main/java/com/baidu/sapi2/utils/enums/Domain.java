package com.baidu.sapi2.utils.enums;

public enum Domain {
    DOMAIN_ONLINE("http://passport.baidu.com", "http://wappass.baidu.com", "https://openapi.baidu.com", "http://wappass.bdimg.com", "http://himg.baidu.com"),
    DOMAIN_RD("http://passport.rdtest.baidu.com", "http://passport.rdtest.baidu.com:8000", "http://dbl-dev-rd23.vm.baidu.com:8080", "http://passport.rdtest.baidu.com:8000", "http://passport.baidu.com"),
    DOMAIN_QA("http://passport.qatest.baidu.com", "http://wappass.qatest.baidu.com", "http://db-infbk-online-17.db01.baidu.com:8080", "http://wappass.qatest.baidu.com", "http://passport.baidu.com");
    
    /* renamed from: a */
    private String f20560a;
    /* renamed from: b */
    private String f20561b;
    /* renamed from: c */
    private String f20562c;
    /* renamed from: d */
    private String f20563d;
    /* renamed from: e */
    private String f20564e;
    /* renamed from: f */
    private boolean f20565f;

    private Domain(String url, String wap, String deviceUrl, String configUrl, String portraitUrl) {
        this.f20560a = url;
        this.f20561b = wap;
        this.f20562c = deviceUrl;
        this.f20563d = configUrl;
        this.f20564e = portraitUrl;
    }

    public String getURL() {
        if (this.f20565f) {
            return this.f20560a.replace("http://", "https://");
        }
        return this.f20560a;
    }

    public String getWap() {
        if (this.f20565f) {
            return this.f20561b.replace("http://", "https://");
        }
        return this.f20561b;
    }

    public String getDeviceUrl() {
        return this.f20562c;
    }

    public String getConfigUrl() {
        return this.f20563d;
    }

    public String getPortraitUrl() {
        return this.f20564e;
    }

    public Domain forceHttps(boolean forceHttps) {
        this.f20565f = forceHttps;
        return this;
    }
}
