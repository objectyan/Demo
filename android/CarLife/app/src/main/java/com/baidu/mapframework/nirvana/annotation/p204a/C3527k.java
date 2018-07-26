package com.baidu.mapframework.nirvana.annotation.p204a;

import com.baidu.mapframework.nirvana.annotation.SignToken.SignTokenType;
import com.baidu.navi.track.database.DataService;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;

/* compiled from: Utils */
/* renamed from: com.baidu.mapframework.nirvana.annotation.a.k */
class C3527k {
    /* renamed from: a */
    static String[] f19108a = new String[]{"mb", "os", "sv", "net", "resid", "cuid", DataService.EXTRA_BDUID, "channel", "oem", "screen", "dpi", "ver", "sinan", NaviStatConstants.K_NSC_KEY_CUR_TIME};
    /* renamed from: b */
    public static final String f19109b = "PHPUI";
    /* renamed from: c */
    public static final String f19110c = "bduss";

    C3527k() {
    }

    /* renamed from: a */
    public static void m15124a(String key, SignTokenType signTokenType) {
        C3527k.m15125b(key);
        if (SignTokenType.MAP_PHPUI.equals(signTokenType)) {
            C3527k.m15123a(key);
        }
        C3527k.m15127c(key);
    }

    /* renamed from: b */
    public static void m15126b(String key, SignTokenType signTokenType) {
        C3527k.m15125b(key);
        if (SignTokenType.MAP_PHPUI.equals(signTokenType)) {
            C3527k.m15123a(key);
        }
    }

    /* renamed from: a */
    private static void m15123a(String key) {
        for (String phone : f19108a) {
            if (key.equals(phone)) {
                throw new RuntimeException(key + " is repeated, phoneinfo has contained the key");
            }
        }
    }

    /* renamed from: b */
    private static void m15125b(String key) {
        if (key == null || key.trim().isEmpty()) {
            throw new RuntimeException("key cant't be empty");
        }
    }

    /* renamed from: c */
    private static void m15127c(String key) {
        if ("bduss".equals(key)) {
            throw new RuntimeException("bduss must be @PostParam");
        }
    }
}
