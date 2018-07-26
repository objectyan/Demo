package com.baidu.carlife.p054k.p055a;

/* compiled from: NetWorkConstant */
/* renamed from: com.baidu.carlife.k.a.f */
public class C1631f {
    /* renamed from: a */
    public static boolean f4990a = true;
    /* renamed from: b */
    public static final String f4991b = "https://vehicle.baidu.com/";
    /* renamed from: c */
    public static final String f4992c = "http://sandbox.carlife.baidu.com/";
    /* renamed from: d */
    public static final String f4993d = "https://appnavi.baidu.com/";
    /* renamed from: e */
    public static final String f4994e = "http://sandbox.carlife.baidu.com/";
    /* renamed from: f */
    public static final String f4995f = "http://navimon.baidu.com/hunter/log/post";
    /* renamed from: g */
    public static final String f4996g = "http://cp01-rdqa-dev168.cp01.baidu.com:8180/hunter/log/post";
    /* renamed from: h */
    public static final String f4997h = "http://api.soargift.com:8998/parkApi/";
    /* renamed from: i */
    public static final String f4998i = "queryNearbyParkInfoList";
    /* renamed from: j */
    public static final String f4999j = "http://api.mwee.cn/";
    /* renamed from: k */
    public static final String f5000k = "baiduCarlife";
    /* renamed from: l */
    public static final String f5001l = "76646ec3a3d2c05957a44f59bf4978c76ab80b92";
    /* renamed from: m */
    public static final String f5002m = "http://st01-rdqa-dev398-daiziming.epc.baidu.com:8556/?m=Index&a=";
    /* renamed from: n */
    public static final String f5003n = "http://ufosdk.baidu.com?m=Index&a=";

    /* compiled from: NetWorkConstant */
    /* renamed from: com.baidu.carlife.k.a.f$a */
    public enum C1627a {
        MUSIC_THIRDPARTY("carlife/platform/getappinwhitelist"),
        SKIN_PKG_LIST("carlife/api/getskins"),
        CAR_SERVICE("carlife/getcarfactorylist"),
        OPEN_NAVI("carlife/getswitchflag"),
        VEHICLE_LOGO("carlife/vehicle/getlogo"),
        VEHICLE_CONFIG("carlife/vehicle/getblack"),
        CARLIFE_CONFIG("carlife/api/getCarlifeConfig");
        
        /* renamed from: h */
        private String f4972h;

        private C1627a(String module) {
            this.f4972h = module;
        }

        /* renamed from: a */
        public String m5909a() {
            return this.f4972h;
        }
    }

    /* compiled from: NetWorkConstant */
    /* renamed from: com.baidu.carlife.k.a.f$b */
    public enum C1628b {
        REGISTER("postclientinfo"),
        FEEDBACK("postmsg");
        
        /* renamed from: c */
        private String f4976c;

        private C1628b(String module) {
            this.f4976c = module;
        }

        /* renamed from: a */
        public String m5910a() {
            return this.f4976c;
        }
    }

    /* compiled from: NetWorkConstant */
    /* renamed from: com.baidu.carlife.k.a.f$c */
    public enum C1629c {
        CAFE_NEAR("api/queue/near/"),
        CAFE_DETAIL("api/queue/detail/"),
        QUEUE_REQ("api/queue/req/"),
        QUEUE_USER("api/queue/user/"),
        QUEUE_CANCEL("api/queue/cancel/");
        
        /* renamed from: f */
        private String f4983f;

        private C1629c(String module) {
            this.f4983f = module;
        }

        /* renamed from: a */
        public String m5911a() {
            return this.f4983f;
        }
    }

    /* compiled from: NetWorkConstant */
    /* renamed from: com.baidu.carlife.k.a.f$d */
    public enum C1630d {
        STATISTICS_VEHICLE("statistics/sendcarlife"),
        WEATHER("weather/get"),
        FEEDBACK("feedback/v2/post"),
        APP_UPDATE("plugin/carlife/update");
        
        /* renamed from: e */
        private String f4989e;

        private C1630d(String module) {
            this.f4989e = module;
        }

        /* renamed from: a */
        public String m5912a() {
            return this.f4989e;
        }
    }

    /* renamed from: a */
    public static String m5914a(C1627a carlifeUrl) {
        return (f4990a ? f4991b : "http://sandbox.carlife.baidu.com/") + carlifeUrl.m5909a();
    }

    /* renamed from: a */
    public static String m5917a(C1630d naviUrl) {
        return (f4990a ? "https://appnavi.baidu.com/" : "http://sandbox.carlife.baidu.com/") + naviUrl.m5912a();
    }

    /* renamed from: a */
    public static String m5915a(C1628b feedbackUrl) {
        return (f4990a ? f5003n : f5002m) + feedbackUrl.m5910a();
    }

    /* renamed from: a */
    public static String m5913a() {
        return f4990a ? f4995f : f4996g;
    }

    /* renamed from: a */
    public static String m5916a(C1629c foodUrl) {
        return f4999j + foodUrl.m5911a();
    }
}
