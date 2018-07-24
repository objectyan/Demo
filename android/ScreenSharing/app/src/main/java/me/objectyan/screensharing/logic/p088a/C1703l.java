package com.baidu.carlife.logic.p088a;

import com.baidu.carlife.R;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.logic.music.C1845r;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.p079c.C2142b;
import com.baidu.carlife.radio.p080b.C2110a;
import com.baidu.carlife.radio.p080b.C2131t;
import com.baidu.carlife.radio.p080b.C2133w;
import com.baidu.carlife.util.C2201w;
import com.baidu.navi.util.StatisticConstants;
import java.util.List;

/* compiled from: SoundProgram */
/* renamed from: com.baidu.carlife.logic.a.l */
public class C1703l extends C1689k {
    /* renamed from: a */
    private C2110a f5202a = new C2131t();
    /* renamed from: b */
    private C2110a f5203b = new C2133w();

    /* renamed from: a */
    public static C1703l m6193a() {
        return new C1703l();
    }

    private C1703l() {
    }

    /* renamed from: b */
    public C2110a mo1614b() {
        return this.f5203b;
    }

    /* renamed from: c */
    public C2110a mo1615c() {
        return this.f5202a;
    }

    /* renamed from: b */
    private boolean m6194b(C1845r radioDataManager) {
        if (!C2142b.m8067a().m8073a(radioDataManager.m6644n())) {
            return false;
        }
        String queryString = radioDataManager.m6989C();
        if (queryString == null) {
            return false;
        }
        if (queryString.contains("\"type\":\"新闻\"") || queryString.contains("\"type\":\"\\u65b0\\u95fb\"")) {
            return true;
        }
        return false;
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
                if (m6194b(radioDataManager)) {
                    radioDataManager.m7008k(StatisticConstants.HOME_MUSIC_STATUS_CHANGE_NEXT);
                    return null;
                }
                radioDataManager.mo1654a(0, radioDataManager.m6644n());
                return null;
            }
        }
        songIndex--;
        if (songIndex < 0) {
            if (m6194b(radioDataManager)) {
                radioDataManager.m7008k(StatisticConstants.HOME_MUSIC_STATUS_CHANGE_PRE);
                return null;
            }
            C2201w.m8373a(AppContext.m3876a().getString(R.string.module_music_first_radio_hint), 1);
            return null;
        }
        radioDataManager.m6627f(songIndex);
        return (MusicSongModel) list.get(songIndex);
    }
}
