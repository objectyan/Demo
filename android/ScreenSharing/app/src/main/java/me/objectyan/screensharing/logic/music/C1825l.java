package com.baidu.carlife.logic.music;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.carlife.R;
import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.logic.voice.C1912n;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.util.C2201w;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.netease.cloudmusic.utils.NeteaseMusicUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NeteaseDataManager */
/* renamed from: com.baidu.carlife.logic.music.l */
public class C1825l extends C1790b {
    /* renamed from: T */
    private static final String f5648T = "param=200y200&quality=70";
    /* renamed from: U */
    private HandlerThread f5649U = null;
    /* renamed from: V */
    private MsgBaseHandler f5650V = null;

    /* compiled from: NeteaseDataManager */
    /* renamed from: com.baidu.carlife.logic.music.l$a */
    private class C1824a extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ C1825l f5647a;

        public C1824a(C1825l c1825l, Looper looper) {
            this.f5647a = c1825l;
            super(looper);
        }

        public void careAbout() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Object list = new ArrayList();
                    this.f5647a.Q = NeteaseMusicUtils.getSearchMusicList(this.f5647a.O, this.f5647a.P, list, 0);
                    if (msg.arg1 == 0) {
                        C1912n.m7270a().m7297a((List) list, 2);
                        return;
                    } else {
                        MsgHandlerCenter.m4459a(423, list);
                        return;
                    }
                case 2:
                    List<MusicSongModel> searchedList = this.f5647a.m6625f(C1799f.f5533C);
                    if (searchedList != null && !searchedList.isEmpty()) {
                        C1825l c1825l = this.f5647a;
                        c1825l.N++;
                        List<MusicSongModel> newlist = new ArrayList();
                        this.f5647a.M = NeteaseMusicUtils.getSearchMusicList(this.f5647a.K, this.f5647a.L, newlist, this.f5647a.N);
                        if (!this.f5647a.M) {
                            this.f5647a.mo1687j(C1799f.f5533C);
                        }
                        MsgHandlerCenter.m4458a(218, this.f5647a.m6649s(), new Pair(C1799f.f5533C, newlist));
                        return;
                    }
                    return;
                case 205:
                    switch (msg.arg1) {
                        case 1:
                            this.f5647a.m6600a(1, NeteaseMusicUtils.getTopList());
                            break;
                        case 2:
                            this.f5647a.m6600a(2, NeteaseMusicUtils.getPlayList());
                            break;
                    }
                    if (this.f5647a.mo1658e(msg.arg1)) {
                        MsgHandlerCenter.m4463b(206, msg.arg1, this.f5647a.m6649s());
                        return;
                    }
                    StatisticManager.onEvent(StatisticConstants.MUSIC_NETEASE_0005, "获取歌单失败");
                    MsgHandlerCenter.m4454a((int) CommonParams.dQ, this.f5647a.m6649s(), 1000);
                    return;
                case 222:
                    String id = msg.obj;
                    List<MusicSongModel> list2 = null;
                    if (!this.f5647a.x.containsKey(id)) {
                        switch (msg.arg1) {
                            case 1:
                                list2 = NeteaseMusicUtils.getToplistDetail(id);
                                break;
                            case 2:
                                list2 = NeteaseMusicUtils.getPlaylistDetail(id);
                                break;
                            default:
                                break;
                        }
                    }
                    list2 = (List) this.f5647a.x.get(id);
                    if (list2 == null || list2.size() <= 0) {
                        if (id != null) {
                            StatisticManager.onEvent(StatisticConstants.MUSIC_NETEASE_0005, "获取播放列表失败");
                        }
                        MsgHandlerCenter.m4454a((int) CommonParams.dR, this.f5647a.m6649s(), 1000);
                        return;
                    }
                    MsgHandlerCenter.m4458a(218, this.f5647a.m6649s(), new Pair(id, list2));
                    return;
                default:
                    return;
            }
        }
    }

    public C1825l(Context context) {
        this.C = context;
        this.E = C1785a.f5429a[2];
        this.f5649U = new HandlerThread(C1825l.class.getSimpleName());
        this.f5649U.start();
        this.f5650V = new C1824a(this, this.f5649U.getLooper());
        MsgHandlerCenter.m4460a(this.f5650V);
        this.F = 2;
        this.I = new ArrayList();
        this.J = new ArrayList();
    }

    /* renamed from: d */
    public Bitmap mo1656d(String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        return CarlifeUtil.m4357a(url + "?" + f5648T);
    }

    /* renamed from: g */
    public List<MusicSongModel> mo1659g() {
        return m6625f(m6644n());
    }

    /* renamed from: d */
    public void mo1657d(int type) {
        if (mo1658e(type)) {
            if (this.H != null) {
                this.H.mo1577a(type);
            }
        } else if (CarlifeUtil.m4358a().m4401r()) {
            m6616c();
            this.f5650V.sendMessage(Message.obtain(this.f5650V, 205, type, -1));
        } else {
            m6638j(3);
            m6620d();
        }
    }

    /* renamed from: a */
    public int mo1654a(int albumType, String listId) {
        m6623e(listId);
        if (CarlifeUtil.m4358a().m4401r()) {
            m6616c();
            this.f5650V.sendMessage(Message.obtain(this.f5650V, 222, albumType, -1, listId));
        } else {
            m6634i(3);
        }
        return 1;
    }

    /* renamed from: a */
    public void mo1685a(String singer, String songName, boolean coDriverMode) {
        this.O = singer;
        this.P = songName;
        if (coDriverMode) {
            this.f5650V.sendMessage(Message.obtain(this.f5650V, 1, 1, -1));
        } else {
            this.f5650V.sendMessage(Message.obtain(this.f5650V, 1, 0, -1));
        }
    }

    /* renamed from: k */
    public int mo1688k() {
        if (CarlifeUtil.m4358a().m4401r()) {
            this.f5650V.sendMessage(Message.obtain(this.f5650V, 2, 0, -1));
        } else {
            m6634i(3);
        }
        return 0;
    }

    /* renamed from: e */
    public boolean mo1658e(int type) {
        if (type == 2) {
            if (this.J == null || this.J.isEmpty()) {
                return false;
            }
            return true;
        } else if (type != 1 || this.I == null || this.I.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: b */
    public void mo1655b(boolean isManual) {
        if (!CarlifeUtil.m4358a().m4401r()) {
            C2201w.m8373a(this.C.getString(R.string.carlife_update_no_network), 0);
        } else if (m6652v() == 0) {
            m6609a(false);
            m6637j();
        } else {
            m6610b();
        }
    }

    /* renamed from: i */
    public boolean mo1686i(String listId) {
        if (!TextUtils.isEmpty(listId) && this.S.contains(listId)) {
            return true;
        }
        return false;
    }

    /* renamed from: j */
    public void mo1687j(String listId) {
        if (!TextUtils.isEmpty(listId)) {
            this.S.add(listId);
        }
    }

    @Deprecated
    /* renamed from: h */
    public void mo1660h() {
    }
}
