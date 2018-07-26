package com.baidu.mobstat;

import android.content.Context;
import android.content.Intent;

enum ap extends ao {
    ap(String str, int i, int i2) {
        super(str, i, i2);
    }

    /* renamed from: a */
    public void mo2725a(Context context) {
        if (au.m15354a(context).mo2731b(context)) {
            try {
                Intent intent = new Intent(context, Class.forName("com.baidu.bottom.service.BottomService"));
                intent.putExtra("SDK_PRODUCT_LY", "MS");
                context.startService(intent);
            } catch (Throwable th) {
                db.m15662b(th);
            }
        }
    }
}
