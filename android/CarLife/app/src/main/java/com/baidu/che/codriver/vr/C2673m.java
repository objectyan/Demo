package com.baidu.che.codriver.vr;

import android.view.View;
import com.baidu.che.codriver.ui.p124d.C2549b;

/* compiled from: UICallBack */
/* renamed from: com.baidu.che.codriver.vr.m */
public interface C2673m {

    /* compiled from: UICallBack */
    /* renamed from: com.baidu.che.codriver.vr.m$b */
    public interface C2749b {
        /* renamed from: a */
        void mo1962a();
    }

    /* compiled from: UICallBack */
    /* renamed from: com.baidu.che.codriver.vr.m$a */
    public interface C2752a {
        /* renamed from: a */
        void mo1964a();
    }

    /* compiled from: UICallBack */
    /* renamed from: com.baidu.che.codriver.vr.m$c */
    public enum C2837c {
        STATE_NORMAL,
        STATE_WECHAT_RECEIVE_CONTENT,
        STATE_SET_HOME,
        STATE_SET_COMPANY,
        STATE_WHERE_GOING
    }

    /* renamed from: a */
    void mo1926a(View view);

    /* renamed from: a */
    void mo1928a(C2549b c2549b);

    /* renamed from: a */
    void mo1929a(C2549b c2549b, C2752a c2752a, C2749b c2749b);

    /* renamed from: a */
    void mo1930a(C2837c c2837c);

    /* renamed from: d */
    void mo1936d();

    /* renamed from: d */
    void mo1937d(String str);

    /* renamed from: e */
    void mo1938e();

    /* renamed from: f */
    void mo1939f();

    /* renamed from: p */
    void mo1944p();

    /* renamed from: s */
    C2837c mo1945s();
}
