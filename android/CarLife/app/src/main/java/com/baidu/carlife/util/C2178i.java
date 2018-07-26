package com.baidu.carlife.util;

import android.os.Handler;
import android.os.Message;
import android.view.View;

/* compiled from: FocusHandler */
/* renamed from: com.baidu.carlife.util.i */
public class C2178i extends Handler {
    /* renamed from: a */
    private static C2178i f6968a;
    /* renamed from: b */
    private static View f6969b;

    /* renamed from: a */
    public static C2178i m8276a(View view) {
        if (f6968a == null) {
            f6968a = new C2178i();
        }
        f6969b = view;
        return f6968a;
    }

    public C2178i(View view) {
        f6969b = view;
    }

    /* renamed from: a */
    public void m8278a(long delayMillis) {
        sendEmptyMessageDelayed(0, delayMillis);
    }

    /* renamed from: a */
    public void m8277a() {
        m8278a(200);
    }

    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if (f6969b != null) {
            f6969b.requestFocus(0);
        }
    }
}
