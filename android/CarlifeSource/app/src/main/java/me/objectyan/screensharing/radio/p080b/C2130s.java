package com.baidu.carlife.radio.p080b;

import com.baidu.carlife.logic.music.C1818h;
import com.baidu.carlife.logic.music.C1845r;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.util.C2201w;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: RecommendDetailCallback */
/* renamed from: com.baidu.carlife.radio.b.s */
public class C2130s implements C1843u {
    /* renamed from: a */
    private WeakReference<C1845r> f6791a;

    /* renamed from: a */
    public static C1843u m8027a(C1845r radioDataManager) {
        return new C2130s(radioDataManager);
    }

    private C2130s(C1845r radioDataManager) {
        this.f6791a = new WeakReference(radioDataManager);
    }

    /* renamed from: a */
    public void mo1694a(String recvListId, List<MusicSongModel> songList) {
        C1845r radioDataManager = (C1845r) this.f6791a.get();
        if (radioDataManager != null && songList != null && songList.size() > 0) {
            radioDataManager.m6991a((MusicSongModel) songList.get(0), recvListId);
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
