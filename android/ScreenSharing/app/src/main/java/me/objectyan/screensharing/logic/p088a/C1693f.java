package com.baidu.carlife.logic.p088a;

import com.baidu.carlife.logic.music.C1845r;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.p080b.C2110a;
import com.baidu.carlife.radio.p080b.C2121k;
import com.baidu.carlife.radio.p080b.C2124l.C2123a;
import com.baidu.carlife.radio.p080b.C2128p;
import com.baidu.carlife.radio.p080b.C2129r;
import com.baidu.carlife.radio.p080b.C2131t;

/* compiled from: MusicRadio */
/* renamed from: com.baidu.carlife.logic.a.f */
public class C1693f extends C1689k {
    /* renamed from: a */
    private static final String f5186a = "0";
    /* renamed from: b */
    private static final String f5187b = "1";
    /* renamed from: c */
    private static final String f5188c = "2";
    /* renamed from: d */
    private static final String f5189d = "3";
    /* renamed from: e */
    private C2110a f5190e;
    /* renamed from: f */
    private C2110a f5191f;
    /* renamed from: g */
    private boolean f5192g;

    /* compiled from: MusicRadio */
    /* renamed from: com.baidu.carlife.logic.a.f$a */
    private static final class C1692a {
        /* renamed from: a */
        private static final C1693f f5185a = new C1693f();

        private C1692a() {
        }
    }

    /* renamed from: a */
    public static C1693f m6163a() {
        return C1692a.f5185a;
    }

    private C1693f() {
        this.f5192g = true;
        this.f5190e = new C2128p();
        this.f5191f = new C2131t();
    }

    /* renamed from: b */
    public C2110a mo1614b() {
        return this.f5190e;
    }

    /* renamed from: c */
    public C2110a mo1615c() {
        return this.f5191f;
    }

    /* renamed from: a */
    public void mo1617a(C1845r radioDataManager, String channelId) {
        String controlState = "1";
        if (this.f5192g) {
            this.f5192g = false;
            controlState = "0";
        }
        this.f5190e.mo1775a(C2123a.m7996a().m8001c(controlState).m8000b(channelId).m7997a(C2129r.m8024a(radioDataManager)).m8002c());
    }

    /* renamed from: a */
    public MusicSongModel mo1613a(boolean isNext, C1845r radioDataManager) {
        this.f5190e.mo1775a(C2123a.m7996a().m8000b(String.valueOf(3)).m8001c(isNext ? "1" : "2").m7997a(C2121k.m7993a(radioDataManager)).m8002c());
        return null;
    }

    /* renamed from: a */
    public void mo1616a(C1845r radioDataManager) {
        this.f5190e.mo1775a(C2123a.m7996a().m8000b(String.valueOf(3)).m8001c("3").m7997a(C2121k.m7993a(radioDataManager)).m8002c());
    }
}
