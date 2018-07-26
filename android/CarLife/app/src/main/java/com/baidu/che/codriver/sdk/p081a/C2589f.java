package com.baidu.che.codriver.sdk.p081a;

import com.baidu.che.codriver.p117c.C2523a;
import java.util.List;

/* compiled from: CdMusicManager */
/* renamed from: com.baidu.che.codriver.sdk.a.f */
public class C2589f {
    /* renamed from: a */
    private C1821a f8582a;
    /* renamed from: b */
    private C1821a f8583b;

    /* compiled from: CdMusicManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.f$a */
    public interface C1821a {

        /* compiled from: CdMusicManager */
        /* renamed from: com.baidu.che.codriver.sdk.a.f$a$a */
        public interface C2587a {
            /* renamed from: a */
            void mo1969a(String str);

            /* renamed from: a */
            void mo1970a(List<C2523a> list);
        }

        /* renamed from: a */
        void mo1675a(C2523a c2523a, int i);

        /* renamed from: a */
        void mo1676a(String str, String str2, String str3, String str4, C2587a c2587a);

        /* renamed from: a */
        void mo1677a(List<C2523a> list, int i);
    }

    /* compiled from: CdMusicManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.f$b */
    private static class C2588b {
        /* renamed from: a */
        private static C2589f f8581a = new C2589f();

        private C2588b() {
        }
    }

    /* renamed from: a */
    public static C2589f m9787a() {
        return C2588b.f8581a;
    }

    /* renamed from: a */
    public void m9788a(C1821a tool) {
        this.f8583b = tool;
    }

    /* renamed from: b */
    public void m9790b(C1821a tool) {
        this.f8582a = tool;
    }

    /* renamed from: b */
    public C1821a m9789b() {
        if (this.f8582a == null) {
            return this.f8583b;
        }
        return this.f8582a;
    }
}
