package com.baidu.carlife.logic.music;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.screen.presentation.FragmentManagerCallbackProxy;
import com.baidu.carlife.model.C1929i;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragmentManager;
import com.baidu.navi.fragment.NaviFragmentManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: BaseMusicDataManager */
/* renamed from: com.baidu.carlife.logic.music.b */
public abstract class C1790b {
    /* renamed from: R */
    protected static boolean f5458R = false;
    /* renamed from: b */
    public static final int f5459b = 0;
    /* renamed from: c */
    public static final int f5460c = 1;
    /* renamed from: d */
    public static final int f5461d = 1;
    /* renamed from: e */
    public static final int f5462e = 2;
    /* renamed from: f */
    public static final String f5463f = "album_type";
    /* renamed from: g */
    public static final String f5464g = "album_name";
    /* renamed from: h */
    public static final String f5465h = "album_id";
    /* renamed from: i */
    public static final String f5466i = "music_type_changed";
    /* renamed from: j */
    public static final String f5467j = "music_playing_icon";
    /* renamed from: k */
    public static final int f5468k = 0;
    /* renamed from: l */
    public static final int f5469l = 1;
    /* renamed from: m */
    public static final int f5470m = 2;
    /* renamed from: n */
    public static final int f5471n = 3;
    /* renamed from: o */
    public static final int f5472o = 4;
    /* renamed from: p */
    public static final int f5473p = 5;
    /* renamed from: q */
    public static final int f5474q = 6;
    /* renamed from: r */
    public static final int f5475r = 7;
    /* renamed from: s */
    public static final int f5476s = -1;
    /* renamed from: t */
    public static final int f5477t = -101;
    /* renamed from: u */
    public static final int f5478u = 110;
    /* renamed from: A */
    protected String f5479A;
    /* renamed from: B */
    protected int f5480B;
    /* renamed from: C */
    protected Context f5481C;
    /* renamed from: D */
    protected MusicSongModel f5482D;
    /* renamed from: E */
    protected String f5483E;
    /* renamed from: F */
    protected int f5484F;
    /* renamed from: G */
    protected C1539c f5485G;
    /* renamed from: H */
    protected C1529a f5486H;
    /* renamed from: I */
    protected List<C1929i> f5487I;
    /* renamed from: J */
    protected List<C1929i> f5488J;
    /* renamed from: K */
    protected String f5489K;
    /* renamed from: L */
    protected String f5490L;
    /* renamed from: M */
    protected boolean f5491M;
    /* renamed from: N */
    protected int f5492N;
    /* renamed from: O */
    protected String f5493O;
    /* renamed from: P */
    protected String f5494P;
    /* renamed from: Q */
    protected boolean f5495Q;
    /* renamed from: S */
    protected ArrayList<String> f5496S;
    /* renamed from: T */
    private int f5497T;
    /* renamed from: U */
    private int f5498U;
    /* renamed from: V */
    private boolean f5499V;
    /* renamed from: a */
    public final String f5500a;
    /* renamed from: v */
    protected int f5501v;
    /* renamed from: w */
    protected int f5502w;
    /* renamed from: x */
    protected HashMap<String, List<MusicSongModel>> f5503x;
    /* renamed from: y */
    protected String f5504y;
    /* renamed from: z */
    protected String f5505z;

    /* compiled from: BaseMusicDataManager */
    /* renamed from: com.baidu.carlife.logic.music.b$a */
    public interface C1529a {
        /* renamed from: a */
        void mo1576a();

        /* renamed from: a */
        void mo1577a(int i);

        /* renamed from: a */
        void mo1578a(String str);

        /* renamed from: b */
        void mo1579b();

        /* renamed from: b */
        void mo1580b(int i);

        /* renamed from: c */
        void mo1581c();
    }

    /* compiled from: BaseMusicDataManager */
    /* renamed from: com.baidu.carlife.logic.music.b$b */
    public interface C1535b {
        /* renamed from: a */
        void mo1583a(String str, int i);
    }

    /* compiled from: BaseMusicDataManager */
    /* renamed from: com.baidu.carlife.logic.music.b$c */
    public interface C1539c {
        /* renamed from: a */
        void mo1584a();

        /* renamed from: a */
        void mo1585a(int i);

        /* renamed from: a */
        void mo1586a(String str);

        /* renamed from: b */
        void mo1587b();

        /* renamed from: c */
        void mo1588c();

        /* renamed from: d */
        void mo1589d();

        /* renamed from: e */
        void mo1590e();
    }

    /* renamed from: a */
    public abstract int mo1654a(int i, String str);

    /* renamed from: b */
    public abstract void mo1655b(boolean z);

    /* renamed from: d */
    public abstract Bitmap mo1656d(String str);

    /* renamed from: d */
    public abstract void mo1657d(int i);

    /* renamed from: e */
    public abstract boolean mo1658e(int i);

    /* renamed from: g */
    public abstract List<MusicSongModel> mo1659g();

    /* renamed from: h */
    public abstract void mo1660h();

    public C1790b() {
        this.f5500a = C1818h.f5590a;
        this.f5501v = 2;
        this.f5502w = 2;
        this.f5503x = null;
        this.f5504y = null;
        this.f5505z = null;
        this.f5479A = null;
        this.f5480B = 0;
        this.f5482D = null;
        this.f5483E = null;
        this.f5484F = 0;
        this.f5487I = null;
        this.f5488J = null;
        this.f5491M = false;
        this.f5492N = 0;
        this.f5495Q = false;
        this.f5497T = 0;
        this.f5498U = 1;
        this.f5496S = new ArrayList();
        this.f5503x = new HashMap();
    }

    /* renamed from: l */
    private void mo1695l(int value) {
        this.f5498U = value;
    }

    /* renamed from: b */
    private void m6593b(C1539c callBack) {
        this.f5485G = callBack;
    }

    /* renamed from: b */
    private void m6592b(C1529a callBack) {
        this.f5486H = callBack;
    }

    /* renamed from: z */
    private int mo1661z() {
        return C1818h.m6730b().m6812g();
    }

    /* renamed from: m */
    private String m6595m(int pos) {
        try {
            return ((C1929i) m6648r().get(pos)).f6055c;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    protected void m6599a(int value) {
        this.f5497T = value;
    }

    /* renamed from: a */
    protected void m6598a() {
        if (mo1661z() == m6649s()) {
            if (m6652v() == 0) {
                if (this.f5486H != null) {
                    this.f5486H.mo1580b(m6654x());
                }
            } else if (m6652v() == 1 && this.f5485G != null) {
                this.f5485G.mo1585a(m6654x());
            }
        }
    }

    /* renamed from: a */
    protected void m6600a(int albumType, List<C1929i> list) {
        if (list != null && !list.isEmpty()) {
            if (albumType == 2) {
                this.f5488J.addAll(list);
            } else if (albumType == 1) {
                this.f5487I.addAll(list);
            }
        }
    }

    /* renamed from: a */
    protected void m6606a(String name) {
        this.f5505z = name;
    }

    /* renamed from: b */
    protected void m6610b() {
        if (this.f5485G != null) {
            m6634i(2);
            this.f5485G.mo1587b();
        }
    }

    /* renamed from: b */
    protected void m6613b(String songListId) {
        if (this.f5485G != null) {
            this.f5485G.mo1586a(songListId);
        }
    }

    /* renamed from: c */
    protected void m6616c() {
        if (m6652v() == 0) {
            if (this.f5486H != null) {
                this.f5486H.mo1576a();
            }
        } else if (m6652v() == 1 && this.f5485G != null) {
            this.f5485G.mo1584a();
        }
    }

    /* renamed from: d */
    protected void m6620d() {
        if (m6652v() == 0) {
            if (this.f5486H != null) {
                this.f5486H.mo1579b();
            }
        } else if (m6652v() == 1 && this.f5485G != null) {
            this.f5485G.mo1588c();
        }
    }

    /* renamed from: e */
    protected void m6622e() {
        if (this.f5485G != null) {
            this.f5485G.mo1590e();
        }
    }

    /* renamed from: b */
    protected void m6611b(int status) {
        this.f5502w = status;
    }

    /* renamed from: c */
    protected void m6617c(int status) {
        boolean isAboveAndroidM = true;
        if ((this.f5501v == 1 || this.f5501v == 7) && status == 2 && this.f5484F >= 3) {
            if (VERSION.SDK_INT < 23) {
                isAboveAndroidM = false;
            }
            if (isAboveAndroidM) {
                BaseFragment.getNaviActivity().sendBroadcast(new Intent("com.baidu.carlife.Action.StartActivityBroadReceiver"));
            }
        }
        this.f5501v = status;
    }

    /* renamed from: c */
    protected void m6618c(String packageName) {
        PackageManager pm = this.f5481C.getPackageManager();
        try {
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            Intent resolveIntent = new Intent("android.intent.action.MAIN", null);
            resolveIntent.addCategory("android.intent.category.LAUNCHER");
            resolveIntent.setPackage(pi.packageName);
            List<ResolveInfo> apps = pm.queryIntentActivities(resolveIntent, 0);
            if (apps.iterator().hasNext()) {
                ResolveInfo ri = (ResolveInfo) apps.iterator().next();
                if (ri != null) {
                    String className = ri.activityInfo.name;
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");
                    intent.setFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
                    intent.setComponent(new ComponentName(packageName, className));
                    try {
                        BaseFragment.getNaviActivity().startActivity(intent);
                        return;
                    } catch (Exception e) {
                        LogUtil.d(C1818h.f5590a, "startActivity error:" + e.getMessage());
                        return;
                    }
                }
                return;
            }
            LogUtil.e(C1818h.f5590a, "openApp " + packageName + " fail, can't find ResolveInfo");
        } catch (NameNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: f */
    public void m6626f() {
        mo1654a(m6653w(), m6644n());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1790b) {
            C1790b dataManager = (C1790b) obj;
            if (!TextUtils.isEmpty(dataManager.m6647q()) && dataManager.m6647q().equals(this.f5483E)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    public boolean m6635i() {
        return this.f5499V;
    }

    /* renamed from: a */
    public void m6609a(boolean flag) {
        this.f5499V = flag;
    }

    /* renamed from: j */
    public void m6637j() {
        mo1657d(m6653w());
    }

    /* renamed from: a */
    public void mo1685a(String singer, String songName, boolean coDriverMode) {
    }

    /* renamed from: k */
    public int mo1688k() {
        return 1;
    }

    /* renamed from: l */
    public void m6642l() {
        this.f5489K = this.f5493O;
        this.f5490L = this.f5494P;
        this.f5491M = this.f5495Q;
        this.f5492N = 0;
        if (this.f5491M) {
            this.f5496S.remove(C1799f.f5533C);
        } else if (!this.f5496S.contains(C1799f.f5533C)) {
            this.f5496S.add(C1799f.f5533C);
        }
    }

    /* renamed from: b */
    public void m6614b(String searchKeySinger, String searchKeySongName, boolean hasMore) {
        this.f5489K = searchKeySinger;
        this.f5490L = searchKeySongName;
        this.f5491M = hasMore;
        this.f5492N = 0;
    }

    /* renamed from: m */
    public int m6643m() {
        return this.f5480B;
    }

    /* renamed from: f */
    public void m6627f(int index) {
        if (index < 0) {
            index = 0;
        }
        this.f5480B = index;
    }

    /* renamed from: e */
    public void m6623e(String id) {
        if (id == null) {
            this.f5504y = null;
        } else if (!id.equals(this.f5504y)) {
            m6627f(0);
            this.f5504y = id;
        }
    }

    /* renamed from: n */
    public String m6644n() {
        return this.f5504y;
    }

    /* renamed from: o */
    public String m6645o() {
        return this.f5505z;
    }

    /* renamed from: p */
    public MusicSongModel mo1696p() {
        List<MusicSongModel> list = mo1659g();
        if (list == null || list.isEmpty()) {
            return null;
        }
        try {
            return (MusicSongModel) list.get(m6643m());
        } catch (IndexOutOfBoundsException e) {
            m6627f(0);
            return (MusicSongModel) list.get(m6643m());
        }
    }

    /* renamed from: f */
    public List<MusicSongModel> m6625f(String key) {
        if (TextUtils.isEmpty(key) || this.f5503x == null || this.f5503x.isEmpty()) {
            return null;
        }
        return (List) this.f5503x.get(key);
    }

    /* renamed from: a */
    public void m6608a(String key, List<MusicSongModel> list) {
        if (!TextUtils.isEmpty(key) && list != null) {
            if (!m6630g(key)) {
                this.f5503x.put(key, list);
            } else if (m6625f(key) != null) {
                m6625f(key).addAll(list);
            }
        }
    }

    /* renamed from: a */
    public void m6605a(MusicSongModel deletedSong) {
        List<MusicSongModel> list = m6625f(m6644n());
        if (list != null && !list.isEmpty() && deletedSong != null) {
            for (MusicSongModel song : list) {
                if (deletedSong.equals(song)) {
                    list.remove(song);
                    m6627f(m6643m() - 1);
                    m6613b(m6644n());
                    return;
                }
            }
        }
    }

    /* renamed from: g */
    public boolean m6630g(String listId) {
        return this.f5503x.get(listId) != null;
    }

    /* renamed from: q */
    public String m6647q() {
        return this.f5483E;
    }

    /* renamed from: h */
    public MusicSongModel m6631h(String id) {
        if (TextUtils.isEmpty(id) || mo1659g() == null) {
            return null;
        }
        for (MusicSongModel song : mo1659g()) {
            if (id.equals(song.f5909a)) {
                return song;
            }
        }
        return null;
    }

    /* renamed from: r */
    public List<C1929i> m6648r() {
        return m6629g(m6653w());
    }

    /* renamed from: g */
    public List<C1929i> m6629g(int type) {
        if (type == 2) {
            return this.f5488J;
        }
        if (type == 1) {
            return this.f5487I;
        }
        return null;
    }

    /* renamed from: s */
    public int m6649s() {
        return this.f5484F;
    }

    /* renamed from: t */
    public void m6650t() {
        if (m6652v() == 0) {
            if (this.f5486H != null) {
                this.f5486H.mo1581c();
            }
        } else if (this.f5485G != null) {
            this.f5485G.mo1589d();
        }
    }

    /* renamed from: h */
    public void m6633h(int albumPos) {
        if (m6648r() != null && !m6648r().isEmpty()) {
            m6606a(((C1929i) m6648r().get(albumPos)).f6053a);
            String albumId = m6595m(albumPos);
            Bundle arg = new Bundle();
            arg.putString("album_id", albumId);
            arg.putInt(f5463f, m6653w());
            if (m6649s() > 100) {
                FragmentManagerCallbackProxy.m4757a().showFragment(NaviFragmentManager.TYPE_RADIO_PLAYER, arg);
            } else if (m6649s() > 0) {
                FragmentManagerCallbackProxy.m4757a().showFragment(NaviFragmentManager.TYPE_MUSIC_PLAYER, arg);
            }
        }
    }

    /* renamed from: a */
    public void mo1689a(Bundle bundle) {
        if (bundle != null) {
            Bundle arg = bundle.getBundle(ContentFragmentManager.KEY_SHOW_BUNDLE);
            if (arg == null) {
                if (!f5458R) {
                    f5458R = true;
                    m6610b();
                }
            } else if (arg.containsKey("album_id")) {
                String albumId = arg.getString("album_id");
                if (albumId != null) {
                    if (albumId.equals(C1799f.f5533C)) {
                        m6610b();
                    } else if (!m6630g(albumId)) {
                        C1818h.m6730b().m6811f(true);
                        m6622e();
                        mo1654a(m6653w(), albumId);
                    } else if (!albumId.equals(m6644n())) {
                        m6623e(albumId);
                        m6627f(0);
                        m6610b();
                    }
                    arg.remove("album_id");
                }
            } else if (arg.getBoolean(f5466i, false)) {
                m6610b();
                arg.remove(f5466i);
            } else if (arg.getBoolean(f5467j, false)) {
                m6613b(m6644n());
                arg.remove(f5467j);
            }
        }
    }

    /* renamed from: b */
    public void m6612b(Bundle bundle) {
        if (bundle != null) {
            Bundle arg = bundle.getBundle(ContentFragmentManager.KEY_SHOW_BUNDLE);
            if (arg != null) {
                if (arg.getBoolean(f5466i, false) && m6654x() == 1 && m6649s() != 1) {
                    mo1655b(false);
                }
                arg.putBoolean(f5466i, false);
                bundle.putBundle(ContentFragmentManager.KEY_SHOW_BUNDLE, arg);
            }
        }
    }

    /* renamed from: u */
    public void m6651u() {
        FragmentManagerCallbackProxy.m4757a().showFragment(NaviFragmentManager.TYPE_MUSIC_ALBUMLIST, null);
    }

    /* renamed from: v */
    public int m6652v() {
        return this.f5497T;
    }

    /* renamed from: w */
    public int m6653w() {
        return this.f5498U;
    }

    /* renamed from: x */
    public int m6654x() {
        if (m6652v() == 0) {
            return this.f5501v;
        }
        return this.f5502w;
    }

    /* renamed from: i */
    public void m6634i(int status) {
        m6611b(status);
        if (mo1661z() == m6649s() && this.f5485G != null) {
            this.f5485G.mo1585a(m6654x());
        }
    }

    /* renamed from: j */
    public void m6638j(int status) {
        m6617c(status);
        if (mo1661z() == m6649s() && this.f5486H != null) {
            this.f5486H.mo1580b(m6654x());
        }
    }

    /* renamed from: k */
    public void m6641k(int type) {
        mo1695l(type);
        mo1657d(type);
    }

    /* renamed from: a */
    public void m6603a(C1529a callBack) {
        m6592b(callBack);
        m6599a(0);
        m6598a();
        if (m6654x() == 2) {
            m6637j();
        }
    }

    /* renamed from: a */
    public void m6604a(C1539c callBack) {
        m6593b(callBack);
        m6599a(1);
        m6598a();
    }

    /* renamed from: y */
    public void mo1690y() {
        this.f5483E = null;
        this.f5484F = -1;
        this.f5496S.clear();
    }

    /* renamed from: a */
    public void m6602a(Pair<String, List<MusicSongModel>> pair) {
        boolean isContained = m6630g((String) pair.first);
        m6608a((String) pair.first, (List) pair.second);
        m6613b((String) pair.first);
        if (!isContained) {
            m6627f(0);
            m6610b();
        }
    }

    /* renamed from: i */
    public boolean mo1686i(String listId) {
        return true;
    }

    /* renamed from: j */
    public void mo1687j(String listId) {
    }
}
