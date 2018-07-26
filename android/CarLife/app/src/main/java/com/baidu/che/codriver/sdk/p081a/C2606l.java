package com.baidu.che.codriver.sdk.p081a;

import com.baidu.che.codriver.sdk.handler.C2621a;
import com.baidu.che.codriver.sdk.handler.C2622b;
import com.baidu.che.codriver.sdk.handler.C2624c;
import com.baidu.che.codriver.sdk.handler.C2626d;
import com.baidu.che.codriver.sdk.handler.C2627e;
import com.baidu.che.codriver.sdk.handler.C2630f;
import com.baidu.che.codriver.sdk.handler.C2633g;
import com.baidu.che.codriver.sdk.handler.C2635h;
import com.baidu.che.codriver.sdk.handler.C2637i;
import com.baidu.che.codriver.sdk.handler.C2639j;
import com.baidu.che.codriver.sdk.handler.MusicCommandHandler;
import com.baidu.che.codriver.util.C2716c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CustomManager */
/* renamed from: com.baidu.che.codriver.sdk.a.l */
public class C2606l {
    /* renamed from: a */
    public static final String f8615a = "music.tool";
    /* renamed from: b */
    public static final String f8616b = "player.tool";
    /* renamed from: c */
    public static final String f8617c = "phone.tool";
    /* renamed from: d */
    public static final String f8618d = "tts.tool";
    /* renamed from: e */
    public static final String f8619e = "system.tool";
    /* renamed from: f */
    public static final String f8620f = "media.tool";
    /* renamed from: g */
    public static final String f8621g = "asr.tool";
    /* renamed from: h */
    public static final String f8622h = "bt.tool";
    /* renamed from: i */
    public static final String f8623i = "hardkey.tool";
    /* renamed from: j */
    public static final String f8624j = "nlp.tool";
    /* renamed from: k */
    public static final String f8625k = "private_radio.tool";
    /* renamed from: l */
    private C2604b f8626l;
    /* renamed from: m */
    private Map<String, C2603a> f8627m = new HashMap();

    /* compiled from: CustomManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.l$a */
    public interface C2603a {
        /* renamed from: a */
        String mo1889a(String str, String str2, String str3, String str4);
    }

    /* compiled from: CustomManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.l$b */
    public interface C2604b {
        /* renamed from: a */
        void mo1886a(String str, String str2);

        /* renamed from: a */
        boolean mo1887a(String str);

        /* renamed from: b */
        String mo1888b(String str, String str2, String str3, String str4);
    }

    /* compiled from: CustomManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.l$c */
    private static class C2605c {
        /* renamed from: a */
        private static C2606l f8614a = new C2606l();

        private C2605c() {
        }
    }

    /* renamed from: a */
    public static C2606l m9828a() {
        return C2605c.f8614a;
    }

    public C2606l() {
        this.f8627m.put(f8615a, new MusicCommandHandler());
        this.f8627m.put(f8616b, new C2633g());
        this.f8627m.put(f8617c, new C2630f());
        this.f8627m.put(f8618d, new C2639j());
        this.f8627m.put(f8619e, new C2637i());
        this.f8627m.put(f8620f, new C2626d());
        this.f8627m.put(f8621g, new C2621a());
        this.f8627m.put(f8622h, new C2622b());
        this.f8627m.put(f8623i, new C2624c());
        this.f8627m.put(f8624j, new C2627e());
        this.f8627m.put(f8625k, new C2635h());
    }

    /* renamed from: a */
    public void m9830a(C2604b commandSender) {
        this.f8626l = commandSender;
    }

    /* renamed from: a */
    public String m9829a(String cmdType, String param, String data) {
        if (this.f8626l != null) {
            this.f8626l.mo1888b(C2716c.m10141a().getPackageName(), cmdType, param, data);
        }
        return null;
    }

    /* renamed from: a */
    public void m9832a(String pkg, String cmdType, String param, String data) {
        if (this.f8627m.get(cmdType) != null && this.f8626l != null) {
            ((C2603a) this.f8627m.get(cmdType)).mo1889a(pkg, cmdType, param, data);
        }
    }

    /* renamed from: a */
    public void m9831a(String pkg, String cmdType) {
        if (this.f8626l != null) {
            this.f8626l.mo1886a(pkg, cmdType);
        }
    }
}
