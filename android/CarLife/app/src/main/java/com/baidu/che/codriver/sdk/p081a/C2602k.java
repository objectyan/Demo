package com.baidu.che.codriver.sdk.p081a;

import com.baidu.che.codriver.util.C2725h;

/* compiled from: CdSystemManager */
/* renamed from: com.baidu.che.codriver.sdk.a.k */
public class C2602k {
    /* renamed from: a */
    private C1981b f8613a;

    /* compiled from: CdSystemManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.k$b */
    public interface C1981b {
        /* renamed from: b */
        public static final String f6362b = "volume";
        /* renamed from: c */
        public static final String f6363c = "bluetooth";
        /* renamed from: d */
        public static final String f6364d = "light";
        /* renamed from: e */
        public static final String f6365e = "wifi";
        /* renamed from: f */
        public static final String f6366f = "radio";
        /* renamed from: g */
        public static final String f6367g = "network";
        /* renamed from: h */
        public static final String f6368h = "system_setting";
        /* renamed from: i */
        public static final String f6369i = "picture";
        /* renamed from: j */
        public static final String f6370j = "media_player";
        /* renamed from: k */
        public static final String f6371k = "telephone";
        /* renamed from: l */
        public static final String f6372l = "home";
        /* renamed from: m */
        public static final String f6373m = "map";
        /* renamed from: n */
        public static final String f6374n = "take_picture";

        /* renamed from: a */
        void mo1727a(String str);

        /* renamed from: a */
        void mo1728a(String str, boolean z);

        /* renamed from: b */
        void mo1729b(String str);

        /* renamed from: c */
        void mo1730c(String str);

        /* renamed from: d */
        void mo1731d(String str);

        /* renamed from: e */
        void mo1732e(String str);

        /* renamed from: f */
        void mo1733f(String str);
    }

    /* compiled from: CdSystemManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.k$a */
    private static class C2601a {
        /* renamed from: a */
        private static C2602k f8612a = new C2602k();

        private C2601a() {
        }
    }

    /* renamed from: a */
    public static C2602k m9819a() {
        return C2601a.f8612a;
    }

    /* renamed from: b */
    public C1981b m9822b() {
        return this.f8613a;
    }

    /* renamed from: a */
    public void m9820a(C1981b mSystemTool) {
        this.f8613a = mSystemTool;
    }

    /* renamed from: a */
    public void m9821a(String param, String data) {
        C2725h.m10214e("CdSystemManager", "param:" + param + ";data:" + data);
        C2606l.m9828a().m9829a(C2606l.f8619e, param, data);
    }
}
