package com.baidu.carlife.logic.music;

import com.baidu.carlife.R;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.screen.presentation.FragmentManagerCallbackProxy;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.util.C2201w;
import com.baidu.che.codriver.p117c.C2523a;
import com.baidu.che.codriver.sdk.p081a.C2589f.C1821a;
import com.baidu.che.codriver.sdk.p081a.C2589f.C1821a.C2587a;
import com.baidu.che.codriver.sdk.p081a.C2600j.C1822a;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: MusicToolImpl */
/* renamed from: com.baidu.carlife.logic.music.k */
public class C1823k implements C1821a, C1822a {
    /* renamed from: a */
    public boolean mo1678a() {
        return C1818h.m6730b().m6828p();
    }

    /* renamed from: b */
    public void mo1679b() {
        if (C1818h.m6730b().m6829q()) {
            C1818h.m6730b().m6836x();
            return;
        }
        if (C1818h.m6730b().m6838z()) {
            m6860h();
        } else {
            C1818h.m6730b().m6778a(null, null);
        }
        StatisticManager.onEvent(StatisticConstants.VOICE_0006);
    }

    /* renamed from: c */
    public void mo1680c() {
        if (C1818h.m6730b().m6829q() || !C1818h.m6730b().m6838z()) {
            C1818h.m6730b().m6811f(true);
        } else {
            m6860h();
        }
        StatisticManager.onEvent(StatisticConstants.VOICE_0006);
    }

    /* renamed from: d */
    public void mo1681d() {
        if (C1818h.m6730b().m6829q() || !C1818h.m6730b().m6838z()) {
            C1818h.m6730b().m6811f(true);
        } else {
            m6860h();
        }
        StatisticManager.onEvent(StatisticConstants.VOICE_0006);
    }

    /* renamed from: e */
    public void mo1682e() {
        C1818h.m6730b().m6793b(false);
        StatisticManager.onEvent(StatisticConstants.VOICE_0006);
    }

    /* renamed from: f */
    public void mo1683f() {
        C1818h.m6730b().m6793b(true);
        StatisticManager.onEvent(StatisticConstants.VOICE_0006);
    }

    /* renamed from: a */
    public void mo1674a(int mode) {
        C1818h.m6730b().m6805e(mode);
        StatisticManager.onEvent(StatisticConstants.VOICE_0006);
        if (mode == 0) {
            StatisticManager.onEvent(StatisticConstants.VOICE_LINK_0003);
        } else if (mode == 1) {
            StatisticManager.onEvent(StatisticConstants.VOICE_LINK_0004);
        }
    }

    /* renamed from: g */
    public void mo1684g() {
        if (C1818h.m6730b().m6826n() == -1) {
            C2201w.m8372a(C2716c.m10141a().getString(R.string.module_music_not_yet_played));
        } else {
            mo1683f();
        }
    }

    /* renamed from: a */
    public void mo1675a(C2523a song, int pos) {
        C1818h.m6730b().m6821k(pos);
        StatisticManager.onEvent(StatisticConstants.VOICE_0006);
    }

    /* renamed from: a */
    public void mo1677a(List<C2523a> musicList, int position) {
        mo1675a((C2523a) musicList.get(position), position);
    }

    /* renamed from: a */
    public void mo1676a(String singer, String song, String tag, String type, C2587a listener) {
        C1818h.m6730b().m6788a(singer, song, listener);
        StatisticManager.onEvent(StatisticConstants.VOICE_0006);
    }

    /* renamed from: a */
    public static void m6859a(ArrayList<MusicSongModel> src, ArrayList<C2523a> dest) {
        if (src != null && src.size() >= 1 && dest != null) {
            Iterator<MusicSongModel> it = src.iterator();
            dest.clear();
            while (it.hasNext()) {
                MusicSongModel musicSongModel = (MusicSongModel) it.next();
                C2523a musicModel = new C2523a();
                musicModel.f8255e = musicSongModel.f5910b;
                musicModel.f8256f = musicSongModel.f5911c;
                musicModel.f8259i = musicSongModel.f5914f;
                dest.add(musicModel);
            }
        }
    }

    /* renamed from: h */
    private void m6860h() {
        FragmentManagerCallbackProxy fragmentManagerCallbackProxy = FragmentManagerCallbackProxy.m4757a();
        if (fragmentManagerCallbackProxy.m4768d() != 4004) {
            MsgHandlerCenter.m4461b(4004);
        }
        if (C1818h.m6730b().m6830r().m6652v() == 0) {
            fragmentManagerCallbackProxy.showFragment(NaviFragmentManager.TYPE_MUSIC_PLAYER, null);
        }
    }
}
