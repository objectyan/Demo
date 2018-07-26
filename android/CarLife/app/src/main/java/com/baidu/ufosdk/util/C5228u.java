package com.baidu.ufosdk.util;

import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.UfoSDK;

/* compiled from: UfoCustomText */
/* renamed from: com.baidu.ufosdk.util.u */
public final class C5228u {
    /* renamed from: a */
    public static String m17794a(String str) {
        if (C5167a.ag == null) {
            C5167a.ag = UfoSDK.getChineseMap();
        }
        return C5167a.ag.containsKey(str) ? (String) C5167a.ag.get(str) : "";
    }
}
