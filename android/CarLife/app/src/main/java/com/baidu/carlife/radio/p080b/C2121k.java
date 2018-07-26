package com.baidu.carlife.radio.p080b;

import com.baidu.carlife.logic.music.C1818h;
import com.baidu.carlife.logic.music.C1845r;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.util.C2201w;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: MusicRadioCallback */
/* renamed from: com.baidu.carlife.radio.b.k */
public class C2121k implements C1843u {
    /* renamed from: a */
    private WeakReference<C1845r> f6722a;

    /* renamed from: a */
    public static C2121k m7993a(C1845r radioDataManager) {
        return new C2121k(radioDataManager);
    }

    private C2121k(C1845r radioDataManager) {
        this.f6722a = new WeakReference(radioDataManager);
    }

    /* renamed from: a */
    public void mo1694a(String channelId, List<MusicSongModel> songList) {
        if (songList != null && !songList.isEmpty()) {
            C1845r radioDataManager = (C1845r) this.f6722a.get();
            if (radioDataManager != null) {
                radioDataManager.m6996b((MusicSongModel) songList.get(0));
            }
            C1818h.m6730b().m6806e((MusicSongModel) songList.get(0));
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
