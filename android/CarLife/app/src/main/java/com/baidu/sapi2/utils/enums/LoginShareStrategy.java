package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;

public enum LoginShareStrategy {
    DISABLED("disabled"),
    SILENT("silent"),
    CHOICE("choice");
    
    /* renamed from: a */
    private String f20567a;

    public static LoginShareStrategy mapStrToValue(String v) {
        if (TextUtils.isEmpty(v)) {
            return getDefault();
        }
        for (LoginShareStrategy value : values()) {
            if (v.equals(value.getStrValue())) {
                return value;
            }
        }
        return getDefault();
    }

    public static LoginShareStrategy getDefault() {
        return SILENT;
    }

    private LoginShareStrategy(String strValue) {
        this.f20567a = strValue;
    }

    public String getStrValue() {
        return this.f20567a;
    }
}
