package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;

public enum FastLoginFeature {
    TX_WEIXIN_SSO("tweixin_sso"),
    SINA_WEIBO_SSO("tsina_sso"),
    SINA_WEIBO_WEBVIEW("tsina"),
    TX_WEIBO_WEBVIEW("tqq"),
    TX_QQ_WEBVIEW("qzone"),
    RENREN_WEBVIEW("renren"),
    DEVICE_LOGIN("device_login"),
    QR_LOGIN("qr_app_login"),
    NM_LOGIN("nuomi_login"),
    VOICE_LOGIN("voice_login"),
    HUAWEI_LOGIN("huawei_login"),
    WANDA_FEIFAN_LOGIN("feifan");
    
    /* renamed from: a */
    private String f12841a;

    public static FastLoginFeature mapStrToValue(String v) {
        if (TextUtils.isEmpty(v)) {
            return getDefault();
        }
        for (FastLoginFeature value : values()) {
            if (v.equals(value.getStrValue())) {
                return value;
            }
        }
        return getDefault();
    }

    public static FastLoginFeature getDefault() {
        return SINA_WEIBO_SSO;
    }

    private FastLoginFeature(String strValue) {
        this.f12841a = strValue;
    }

    public String getStrValue() {
        return this.f12841a;
    }
}
