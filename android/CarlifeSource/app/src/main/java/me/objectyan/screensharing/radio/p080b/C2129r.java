package com.baidu.carlife.radio.p080b;

import com.baidu.carlife.logic.music.C1818h;
import com.baidu.carlife.logic.music.C1845r;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.util.C2201w;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: RecommendClickCallback */
/* renamed from: com.baidu.carlife.radio.b.r */
public class C2129r implements C1843u {
    /* renamed from: a */
    private WeakReference<C1845r> f6790a;

    /* renamed from: a */
    public static C1843u m8024a(C1845r radioDataManager) {
        return new C2129r(radioDataManager);
    }

    private C2129r(C1845r radioDataManager) {
        this.f6790a = new WeakReference(radioDataManager);
    }

    /* renamed from: a */
    public void mo1694a(String recvListId, List<MusicSongModel> songList) {
        C1845r radioDataManager = (C1845r) this.f6790a.get();
        if (radioDataManager != null) {
            radioDataManager.m6995a(songList, recvListId, 0, 0, 0);
        }
    }

    /* renamed from: a */
    public void mo1693a(String error) {
        if (C1818h.m6730b().m6829q()) {
            C1818h.m6730b().m6811f(true);
            C2201w.m8372a("节目加载失败，请稍后重试");
        }
    }
}
