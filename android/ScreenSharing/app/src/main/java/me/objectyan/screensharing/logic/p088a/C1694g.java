package com.baidu.carlife.logic.p088a;

import com.baidu.carlife.R;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.logic.music.C1845r;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.p080b.C2110a;
import com.baidu.carlife.radio.p080b.C2124l.C2123a;
import com.baidu.carlife.radio.p080b.C2130s;
import com.baidu.carlife.radio.p080b.C2131t;
import com.baidu.carlife.radio.p080b.C2134x;
import com.baidu.carlife.radio.p080b.C2135y;
import com.baidu.carlife.util.C2201w;
import java.util.List;

/* compiled from: NewsRadio */
/* renamed from: com.baidu.carlife.logic.a.g */
public class C1694g extends C1689k {
    /* renamed from: a */
    private C2110a f5193a = new C2131t();
    /* renamed from: b */
    private C2110a f5194b = new C2135y();
    /* renamed from: c */
    private C2110a f5195c = new C2134x();

    /* renamed from: a */
    public static C1694g m6169a() {
        return new C1694g();
    }

    private C1694g() {
    }

    /* renamed from: b */
    public C2110a mo1614b() {
        return this.f5194b;
    }

    /* renamed from: c */
    public C2110a mo1615c() {
        return this.f5193a;
    }

    /* renamed from: a */
    public MusicSongModel mo1613a(boolean isNext, C1845r radioDataManager) {
        List<MusicSongModel> list = radioDataManager.mo1659g();
        if (list == null || list.isEmpty()) {
            return null;
        }
        int songIndex = radioDataManager.m6643m();
        if (isNext) {
            songIndex++;
            if (songIndex >= list.size()) {
                radioDataManager.mo1654a(0, radioDataManager.m6644n());
                return null;
            }
        }
        songIndex--;
        if (songIndex < 0) {
            C2201w.m8373a(AppContext.m3876a().getString(R.string.module_music_first_radio_hint), 1);
            return null;
        }
        radioDataManager.m6627f(songIndex);
        return (MusicSongModel) list.get(songIndex);
    }

    /* renamed from: a */
    public void m6171a(C1845r radioDataManager, String channelId, String songlId) {
        this.f5195c.mo1775a(C2123a.m7996a().m8000b(channelId).m7998a(songlId).m7997a(C2130s.m8027a(radioDataManager)).m8002c());
    }
}
