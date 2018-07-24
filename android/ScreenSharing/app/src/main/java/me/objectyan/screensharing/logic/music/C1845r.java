package com.baidu.carlife.logic.music;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.screen.presentation.FragmentManagerCallbackProxy;
import com.baidu.carlife.core.screen.presentation.view.CarlifeViewContainer;
import com.baidu.carlife.logic.p088a.C1689k;
import com.baidu.carlife.logic.p088a.C1694g;
import com.baidu.carlife.logic.p088a.C1702j;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.p052m.C1915a;
import com.baidu.carlife.radio.p079c.C2139a;
import com.baidu.carlife.radio.p079c.C2139a.C1491a;
import com.baidu.carlife.radio.p079c.C2142b;
import com.baidu.carlife.radio.p080b.C1843u;
import com.baidu.carlife.radio.p080b.C2110a;
import com.baidu.carlife.radio.p080b.C2124l.C2123a;
import com.baidu.carlife.radio.p102a.C2105a;
import com.baidu.carlife.util.C2186p;
import com.baidu.carlife.util.C2201w;
import com.baidu.che.codriver.p099f.C2535a;
import com.baidu.che.codriver.p099f.C2535a.C1840a;
import com.baidu.che.codriver.sdk.p081a.C1695n.C2608a;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: RadioDataManager */
/* renamed from: com.baidu.carlife.logic.music.r */
public class C1845r extends C1790b {
    /* renamed from: T */
    private String f5715T;
    /* renamed from: U */
    private MusicSongModel f5716U;

    /* compiled from: RadioDataManager */
    /* renamed from: com.baidu.carlife.logic.music.r$2 */
    class C18412 implements C1840a {
        /* renamed from: a */
        final /* synthetic */ C1845r f5709a;

        C18412(C1845r this$0) {
            this.f5709a = this$0;
        }

        /* renamed from: a */
        public void mo1691a(String s) {
        }

        /* renamed from: b */
        public void mo1692b(String s) {
            this.f5709a.m6997b(s, null);
        }
    }

    public C1845r(Context context, int type, String packageName) {
        this.C = context;
        this.E = "CarLifeRadio";
        this.F = 101;
        this.I = new ArrayList();
        C2186p.m8304a().m8319b(CommonParams.ic, "");
        m7010l("");
    }

    /* renamed from: b */
    public void m6996b(MusicSongModel musicSong) {
        this.f5716U = musicSong;
    }

    /* renamed from: d */
    public void mo1657d(int type) {
    }

    /* renamed from: e */
    public boolean mo1658e(int type) {
        return true;
    }

    /* renamed from: b */
    public void mo1655b(boolean isManual) {
    }

    @Deprecated
    /* renamed from: h */
    public void mo1660h() {
    }

    /* renamed from: d */
    public Bitmap mo1656d(String url) {
        return null;
    }

    /* renamed from: g */
    public List<MusicSongModel> mo1659g() {
        List<MusicSongModel> list = m6625f(m6644n());
        if (list == null || list.isEmpty()) {
            mo1654a(0, m6644n());
        }
        return list;
    }

    /* renamed from: p */
    public MusicSongModel mo1696p() {
        if (this.f5716U != null) {
            return this.f5716U;
        }
        List<MusicSongModel> playList = mo1659g();
        if (playList == null || playList.isEmpty()) {
            return null;
        }
        if (m6643m() >= playList.size()) {
            m6627f(playList.size());
            mo1654a(0, m6644n());
            return null;
        }
        try {
            return (MusicSongModel) playList.get(m6643m());
        } catch (IndexOutOfBoundsException e) {
            m6627f(0);
            return (MusicSongModel) playList.get(m6643m());
        }
    }

    /* renamed from: z */
    public void mo1661z() {
        if (C1818h.m6730b().m6834v()) {
            C1795c.m6660a().m6666a(4, (C1790b) this);
        }
        if (C1818h.m6730b().m6829q()) {
            C1818h.m6730b().m6807e(true);
        } else {
            C1818h.m6730b().m6836x();
        }
    }

    /* renamed from: j */
    public void mo1687j(String listId) {
        if (!TextUtils.isEmpty(listId)) {
            this.S.add(listId);
        }
    }

    /* renamed from: i */
    public boolean mo1686i(String listId) {
        if (!TextUtils.isEmpty(listId) && this.S.contains(listId)) {
            return true;
        }
        return false;
    }

    /* renamed from: y */
    public void mo1690y() {
        m6623e(null);
        this.I.clear();
        this.x.clear();
        super.mo1690y();
    }

    /* renamed from: a */
    public void m6994a(final String channelId, String channelName) {
        new C2139a(this.C).m8066a(CarlifeViewContainer.m4699a().m4701b(), new C1491a(this) {
            /* renamed from: b */
            final /* synthetic */ C1845r f5708b;

            /* renamed from: a */
            public void mo1562a() {
                if (channelId != null) {
                    C1818h.m6730b().m6798c(channelId);
                    return;
                }
                C2105a channelModel = C2142b.m8067a().m8078d();
                if (channelModel != null) {
                    C1818h.m6730b().m6798c(channelModel.m7893a());
                }
            }
        });
    }

    /* renamed from: b */
    public void m6998b(String channelId, String channelName) {
        if (channelId == null) {
            C2105a channelModel = C2142b.m8067a().m8078d();
            if (channelModel != null) {
                channelId = channelModel.m7893a();
                channelName = channelModel.m7895b();
            } else {
                return;
            }
        }
        Bundle arg = new Bundle();
        arg.putString("album_id", channelId);
        arg.putString(C1790b.f5464g, channelName);
        if (m6649s() > 100) {
            FragmentManagerCallbackProxy.m4757a().showFragment(NaviFragmentManager.TYPE_RADIO_PLAYER, arg);
        } else if (m6649s() > 0) {
            FragmentManagerCallbackProxy.m4757a().showFragment(NaviFragmentManager.TYPE_MUSIC_PLAYER, arg);
        }
    }

    /* renamed from: A */
    public void m6987A() {
        this.F = 101;
        this.E = "CarLifeRadio";
    }

    /* renamed from: a */
    public void m6995a(List<MusicSongModel> newList, String songListId, int pn, int rn, int total) {
        this.f5716U = null;
        if (songListId != null && songListId.equals(m6644n())) {
            if (newList == null || newList.isEmpty()) {
                List<MusicSongModel> oldList = m6625f(songListId);
                if (oldList == null || oldList.isEmpty()) {
                    LogUtil.d(C1818h.f5590a, "PlatformManager.onGetSongList() - FAIL");
                    m6613b(songListId);
                }
                MsgHandlerCenter.m4462b(CommonParams.dR, m6649s());
            } else if (m6630g(songListId)) {
                List oldList2 = m6625f(songListId);
                if (m6986m(songListId)) {
                    int size = newList.size();
                    int i = 0;
                    while (i < size) {
                        if (((MusicSongModel) newList.get(i)).f5926r == 999) {
                            newList.remove(i);
                            size--;
                        } else {
                            i++;
                        }
                    }
                }
                m6985a(oldList2, (List) newList);
                MsgHandlerCenter.m4458a(218, m6649s(), new Pair(songListId, newList));
                if (this.G == null) {
                    m6608a(songListId, (List) newList);
                }
            } else {
                this.x.clear();
                MsgHandlerCenter.m4458a(218, m6649s(), new Pair(songListId, newList));
                if (this.G == null) {
                    m6623e(songListId);
                    m6608a(songListId, (List) newList);
                    C1818h.m6730b().m6806e(mo1696p());
                }
            }
        }
    }

    /* renamed from: a */
    public void m6991a(MusicSongModel songModel, String songListId) {
        m6992a(songListId, songModel);
        C1818h.m6730b().m6806e(m6631h(songModel.f5909a));
    }

    /* renamed from: a */
    public void m6992a(String key, MusicSongModel songModel) {
        if (!TextUtils.isEmpty(key) && songModel != null && m6630g(key) && m6625f(key) != null) {
            for (MusicSongModel song : m6625f(key)) {
                if (song.m7342a().equals(songModel.m7342a())) {
                    song.m7367i(songModel.m7371l());
                }
            }
        }
    }

    /* renamed from: m */
    private boolean m6986m(String songListId) {
        if (songListId.equals(String.valueOf(1)) || songListId.equals(String.valueOf(4))) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void m6985a(List<MusicSongModel> oldList, List<MusicSongModel> newList) {
        if (oldList != null && newList != null) {
            int oldListSize = oldList.size();
            int newListSize = newList.size();
            if (oldListSize > 0 && newListSize > 0) {
                int i;
                MusicSongModel oldTemp;
                if (oldListSize < newListSize) {
                    for (MusicSongModel oldTemp2 : oldList) {
                        i = 0;
                        while (i < newList.size()) {
                            if (oldTemp2.f5909a.equals(((MusicSongModel) newList.get(i)).f5909a)) {
                                newList.remove(i);
                                i--;
                            }
                            i++;
                        }
                    }
                    return;
                }
                for (int index = oldListSize - newListSize; index < oldListSize; index++) {
                    oldTemp2 = (MusicSongModel) oldList.get(index);
                    i = 0;
                    while (i < newList.size()) {
                        if (oldTemp2.f5909a.equals(((MusicSongModel) newList.get(i)).f5909a)) {
                            newList.remove(i);
                            i--;
                        }
                        i++;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public int mo1654a(int albumType, String listId) {
        m6623e(listId);
        if (C2142b.m8067a().m8073a(listId)) {
            m6997b(m6989C(), null);
        } else {
            C1702j.m6181a().m6191f().mo1617a(this, listId);
        }
        return 0;
    }

    /* renamed from: k */
    public void m7008k(String queryString) {
        new C2535a(new C18412(this)).m9619a(queryString);
    }

    /* renamed from: c */
    public int m7000c(String channelId, String songId) {
        C1689k radioType = C1702j.m6181a().m6191f();
        if (radioType instanceof C1694g) {
            ((C1694g) radioType).m6171a(this, channelId, songId);
        }
        return 0;
    }

    /* renamed from: l */
    public void mo1695l(int index) {
        if (index >= 0) {
            List<MusicSongModel> playlist = mo1659g();
            if (playlist == null) {
                return;
            }
            if (index == 0) {
                playlist.clear();
            } else if (playlist.size() > index) {
                Iterator iterator = playlist.iterator();
                int i = 0;
                while (iterator.hasNext()) {
                    iterator.next();
                    if (i >= index) {
                        iterator.remove();
                    }
                    i++;
                }
            }
        }
    }

    /* renamed from: a */
    public void m6993a(final String query, final C2608a listener) {
        new C2139a(this.C).m8066a(CarlifeViewContainer.m4699a().m4701b(), new C1491a(this) {
            /* renamed from: c */
            final /* synthetic */ C1845r f5712c;

            /* renamed from: a */
            public void mo1562a() {
                this.f5712c.m6997b(query, listener);
            }
        });
    }

    /* renamed from: b */
    public void m6997b(String query, final C2608a listener) {
        StatisticManager.onEvent(StatisticConstants.VOICE_0019);
        if (!TextUtils.equals(m6989C(), query)) {
            m7010l(query);
            m6627f(0);
            this.x.clear();
            C1818h.m6730b().m6811f(true);
        }
        String queryListId = C2142b.f6818b;
        if (!queryListId.equals(m6644n())) {
            C1818h.m6730b().m6811f(true);
        }
        m6623e(queryListId);
        m6988B().mo1775a(C2123a.m7996a().m8003d(query).m7997a(new C1843u(this) {
            /* renamed from: b */
            final /* synthetic */ C1845r f5714b;

            /* renamed from: a */
            public void mo1694a(String recvListId, List<MusicSongModel> songList) {
                if (listener != null) {
                    listener.mo1973a();
                }
                if (!TextUtils.isEmpty(this.f5714b.m6989C())) {
                    C2186p.m8304a().m8319b(CommonParams.ic, this.f5714b.m6989C());
                }
                this.f5714b.m6995a(songList, recvListId, 0, 0, 0);
                if (recvListId.equals(this.f5714b.m6644n())) {
                    MsgHandlerCenter.m4461b(230);
                }
            }

            /* renamed from: a */
            public void mo1693a(String error) {
                if (listener != null) {
                    listener.mo1974b();
                }
                if (C1818h.m6730b().m6829q()) {
                    C1818h.m6730b().m6811f(true);
                    C2201w.m8372a("未搜索到结果，请尝试其他节目");
                    C1915a.m7321a().m7322a("未搜索到结果，请尝试其他节目", 0);
                }
            }
        }).m8002c());
    }

    /* renamed from: B */
    public C2110a m6988B() {
        return C1702j.m6181a().m6191f().mo1615c();
    }

    /* renamed from: C */
    public String m6989C() {
        return this.f5715T;
    }

    /* renamed from: l */
    public void m7010l(String mQuery) {
        this.f5715T = mQuery;
    }
}
