package com.baidu.che.codriver.sdk.p081a;

import android.view.KeyEvent;
import com.baidu.che.codriver.util.C2725h;

/* compiled from: CdHardKeyManager */
/* renamed from: com.baidu.che.codriver.sdk.a.d */
public class C2583d {
    /* renamed from: a */
    private C2581a f8578a;

    /* compiled from: CdHardKeyManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.d$a */
    public interface C2581a {
        /* renamed from: a */
        void mo1890a(int i);

        /* renamed from: a */
        void mo1891a(int i, KeyEvent keyEvent);

        /* renamed from: b */
        void mo1892b(int i);

        /* renamed from: b */
        void mo1893b(int i, KeyEvent keyEvent);
    }

    /* compiled from: CdHardKeyManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.d$b */
    private static class C2582b {
        /* renamed from: a */
        private static C2583d f8577a = new C2583d();

        private C2582b() {
        }
    }

    /* renamed from: a */
    public static C2583d m9763a() {
        return C2582b.f8577a;
    }

    /* renamed from: b */
    public C2581a m9766b() {
        return this.f8578a;
    }

    /* renamed from: a */
    public void m9764a(C2581a mHardKeyTool) {
        this.f8578a = mHardKeyTool;
    }

    /* renamed from: a */
    public void m9765a(String param, String data) {
        C2725h.m10214e("CdHardKeyManager", "param:" + param + ";data:" + data);
        C2606l.m9828a().m9829a(C2606l.f8623i, param, data);
    }
}
