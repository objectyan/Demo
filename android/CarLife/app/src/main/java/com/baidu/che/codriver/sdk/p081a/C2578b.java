package com.baidu.che.codriver.sdk.p081a;

import com.baidu.che.codriver.util.C2725h;

/* compiled from: CdBuleToothManager */
/* renamed from: com.baidu.che.codriver.sdk.a.b */
public class C2578b {
    /* renamed from: a */
    public static final String f8562a = "0";
    /* renamed from: b */
    public static final String f8563b = "1";
    /* renamed from: c */
    public static final String f8564c = "2";
    /* renamed from: d */
    public static final String f8565d = "3";
    /* renamed from: e */
    public static final String f8566e = "4";
    /* renamed from: f */
    public static final String f8567f = "5";
    /* renamed from: g */
    public static final String f8568g = "6";
    /* renamed from: h */
    public static final String f8569h = "7";
    /* renamed from: i */
    private C2576a f8570i = C2576a.DISCONNECTED;
    /* renamed from: j */
    private int f8571j = 0;

    /* compiled from: CdBuleToothManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.b$a */
    public enum C2576a {
        CONNECTED,
        DISCONNECTED,
        DISABLED,
        CONNECTING,
        DISCONNECTING,
        CANCELLING,
        CANCELLED,
        PAIRED,
        NOPAIR
    }

    /* compiled from: CdBuleToothManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.b$b */
    private static class C2577b {
        /* renamed from: a */
        private static C2578b f8561a = new C2578b();

        private C2577b() {
        }
    }

    /* renamed from: a */
    public static C2578b m9741a() {
        return C2577b.f8561a;
    }

    /* renamed from: a */
    public void m9742a(int driver) {
        this.f8571j = driver;
    }

    /* renamed from: b */
    public int m9745b() {
        return this.f8571j;
    }

    /* renamed from: c */
    public C2576a m9746c() {
        return this.f8570i;
    }

    /* renamed from: a */
    public void m9743a(C2576a mBTState) {
        this.f8570i = mBTState;
    }

    /* renamed from: a */
    public void m9744a(String param, String data) {
        C2725h.m10214e("CdBuleToothManager", "param:" + param + ";data:" + data);
        C2606l.m9828a().m9829a(C2606l.f8622h, param, data);
    }

    /* renamed from: d */
    public void m9747d() {
        m9744a("bt_view", null);
    }

    /* renamed from: e */
    public void m9748e() {
        m9744a("bt_contract_down_view", null);
    }
}
