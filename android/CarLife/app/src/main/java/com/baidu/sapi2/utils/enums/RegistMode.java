package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;

public enum RegistMode {
    NORMAL("normal"),
    FAST("fast"),
    QUICK_USER("quick_user");
    
    /* renamed from: a */
    private String f20571a;

    public static RegistMode mapStrToValue(String v) {
        if (TextUtils.isEmpty(v)) {
            return getDefault();
        }
        for (RegistMode value : values()) {
            if (v.equals(value.getStrValue())) {
                return value;
            }
        }
        return getDefault();
    }

    public static RegistMode getDefault() {
        return NORMAL;
    }

    private RegistMode(String strValue) {
        this.f20571a = strValue;
    }

    public String getStrValue() {
        return this.f20571a;
    }
}
