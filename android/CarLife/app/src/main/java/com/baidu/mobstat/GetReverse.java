package com.baidu.mobstat;

import android.content.Context;

public class GetReverse {
    /* renamed from: a */
    private static ICooperService f19371a;

    private GetReverse() {
    }

    public static ICooperService getCooperService(Context context) {
        if (f19371a == null) {
            f19371a = CooperService.m15264a();
        }
        return f19371a;
    }
}
