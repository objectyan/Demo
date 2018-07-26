package com.baidu.sapi2.utils.enums;

public enum SocialType {
    UNKNOWN(0, "未知"),
    RENREN(1, "人人"),
    SINA_WEIBO(2, "新浪微博"),
    SINA_WEIBO_SSO(2, "新浪微博SSO"),
    TENCENT_WEIBO(4, "腾讯微博"),
    QZONE(15, "QQ空间"),
    QQ(15, "QQ"),
    WEIXIN(42, "微信"),
    HUAWEI(45, "华为"),
    WANDA_FEIFAN(46, "万达飞凡"),
    IQIYI(47, "爱奇艺");
    
    /* renamed from: a */
    private int f20573a;
    /* renamed from: b */
    private String f20574b;

    private SocialType(int type, String name) {
        this.f20573a = type;
        this.f20574b = name;
    }

    public int getType() {
        return this.f20573a;
    }

    public String getName() {
        return this.f20574b;
    }

    public static SocialType getSocialType(int type) {
        switch (type) {
            case 1:
                return RENREN;
            case 2:
                return SINA_WEIBO;
            case 4:
                return TENCENT_WEIBO;
            case 15:
                return QQ;
            case 42:
                return WEIXIN;
            case 45:
                return HUAWEI;
            case 46:
                return WANDA_FEIFAN;
            case 47:
                return IQIYI;
            default:
                return UNKNOWN;
        }
    }
}
