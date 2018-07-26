package com.baidu.carlife.logic.p088a;

import com.baidu.carlife.logic.music.C1845r;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.p080b.C2110a;
import com.baidu.carlife.radio.p080b.C2115e;
import com.baidu.carlife.radio.p080b.C2116f;
import java.util.List;

/* compiled from: FmRadio */
/* renamed from: com.baidu.carlife.logic.a.e */
public class C1690e extends C1689k {
    /* renamed from: a */
    private C2110a f5183a = new C2115e();
    /* renamed from: b */
    private C2110a f5184b = new C2116f();

    /* renamed from: a */
    public static C1690e m6158a() {
        return new C1690e();
    }

    private C1690e() {
    }

    /* renamed from: b */
    public C2110a mo1614b() {
        return this.f5184b;
    }

    /* renamed from: c */
    public C2110a mo1615c() {
        return this.f5183a;
    }

    /* renamed from: a */
    public MusicSongModel mo1613a(boolean isNext, C1845r radioDataManager) {
        List<MusicSongModel> list = radioDataManager.mo1659g();
        if (list == null || list.isEmpty()) {
            return null;
        }
        int curIndex = radioDataManager.m6643m();
        int nextIndex = 0;
        if (list.size() > 0) {
            nextIndex = (curIndex + 1) % list.size();
        }
        int targetIndex = isNext ? nextIndex : curIndex == 0 ? list.size() - 1 : curIndex - 1;
        radioDataManager.m6627f(targetIndex);
        return (MusicSongModel) list.get(targetIndex);
    }
}
