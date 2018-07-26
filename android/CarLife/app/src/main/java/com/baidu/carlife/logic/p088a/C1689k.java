package com.baidu.carlife.logic.p088a;

import com.baidu.carlife.logic.music.C1845r;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.p080b.C2110a;
import com.baidu.carlife.radio.p080b.C2124l.C2123a;
import com.baidu.carlife.radio.p080b.C2129r;

/* compiled from: RadioType */
/* renamed from: com.baidu.carlife.logic.a.k */
public abstract class C1689k {
    /* renamed from: a */
    public abstract MusicSongModel mo1613a(boolean z, C1845r c1845r);

    /* renamed from: b */
    public abstract C2110a mo1614b();

    /* renamed from: c */
    public abstract C2110a mo1615c();

    /* renamed from: d */
    public static C1689k m6149d() {
        return C1703l.m6193a();
    }

    /* renamed from: e */
    public static C1689k m6150e() {
        return C1693f.m6163a();
    }

    /* renamed from: f */
    public static C1689k m6151f() {
        return C1690e.m6158a();
    }

    /* renamed from: g */
    public static C1689k m6152g() {
        return C1694g.m6169a();
    }

    /* renamed from: a */
    public void mo1617a(C1845r radioDataManager, String channelId) {
        mo1614b().mo1775a(C2123a.m7996a().m8000b(channelId).m7997a(C2129r.m8024a(radioDataManager)).m8002c());
    }

    /* renamed from: a */
    public void mo1616a(C1845r radioDataManager) {
        radioDataManager.mo1695l(radioDataManager.m6643m());
        radioDataManager.m6626f();
    }
}
