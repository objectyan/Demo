package com.baidu.carlife.logic.music;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.R;
import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.model.C1929i;
import com.baidu.carlife.model.C1931j;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.platform.C1995c;
import com.baidu.carlife.platform.model.CLAlbum;
import com.baidu.carlife.util.C2201w;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ThirdDataManager */
/* renamed from: com.baidu.carlife.logic.music.s */
public class C1849s extends C1790b {
    /* renamed from: T */
    private static final int f5720T = 20;
    /* renamed from: U */
    private MusicSongModel f5721U = null;
    /* renamed from: V */
    private Thread f5722V = null;
    /* renamed from: W */
    private long f5723W = 0;
    /* renamed from: X */
    private MsgBaseHandler f5724X = new MsgBaseHandler(this, BaiduNaviApplication.getInstance().getMainLooper()) {
        /* renamed from: a */
        final /* synthetic */ C1849s f5719a;

        public void careAbout() {
            addMsg(CommonParams.gQ);
            addMsg(412);
        }

        public void handleMessage(Message msg) {
            try {
                String packageName = msg.obj;
                if (!TextUtils.isEmpty(packageName) && packageName.equals(this.f5719a.m6647q())) {
                    switch (msg.what) {
                        case 412:
                            if (this.f5719a.m6652v() == 1) {
                                this.f5719a.m6651u();
                                this.f5719a.m6599a(0);
                            }
                            this.f5719a.m6638j(1);
                            this.f5719a.m6623e(null);
                            this.f5719a.I.clear();
                            this.f5719a.x.clear();
                            this.f5719a.H.mo1578a(packageName);
                            this.f5719a.S.clear();
                            return;
                        case CommonParams.gQ /*4014*/:
                            if (msg.arg1 == CommonParams.iw) {
                                this.f5719a.m6638j(1);
                                return;
                            } else if (msg.arg1 == CommonParams.ix) {
                                this.f5719a.m6638j(0);
                                return;
                            } else {
                                return;
                            }
                        default:
                            return;
                    }
                    ex.printStackTrace();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    };

    /* compiled from: ThirdDataManager */
    /* renamed from: com.baidu.carlife.logic.music.s$1 */
    class C18471 extends Thread {
        /* renamed from: a */
        final /* synthetic */ C1849s f5718a;

        /* compiled from: ThirdDataManager */
        /* renamed from: com.baidu.carlife.logic.music.s$1$1 */
        class C18461 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C18471 f5717a;

            C18461(C18471 this$1) {
                this.f5717a = this$1;
            }

            public void run() {
                this.f5717a.f5718a.m6638j(0);
            }
        }

        C18471(C1849s this$0) {
            this.f5718a = this$0;
        }

        public void run() {
            int n;
            LogUtil.d(C1818h.f5590a, "---startSync-2--");
            C1931j model = C1818h.m6730b().m6824m(this.f5718a.m6649s());
            boolean isAboveAndroidM = VERSION.SDK_INT >= 23;
            if (model != null && !TextUtils.isEmpty(model.m7398a())) {
                if (isAboveAndroidM) {
                    try {
                        this.f5718a.m6618c(model.m);
                        Thread.sleep(4000);
                    } catch (ActivityNotFoundException e) {
                        LogUtil.e(C1818h.f5590a, "AboveAndroidM ActivityNotFoundException");
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                Intent launchIntent = new Intent(model.m7398a());
                launchIntent.putExtra("fromwhere", "baidu_CarLife");
                launchIntent.setPackage(model.m);
                ComponentName componentName = null;
                try {
                    componentName = this.f5718a.C.startService(launchIntent);
                    if (componentName == null) {
                        try {
                            this.f5718a.m6618c(model.m);
                            for (n = 0; n < 10 && componentName == null; n++) {
                                Thread.sleep(1000);
                                componentName = this.f5718a.C.startService(launchIntent);
                            }
                        } catch (ActivityNotFoundException e3) {
                            C2201w.m8371a((int) R.string.module_music_thirdparty_sync_fail, 0);
                            this.f5718a.f5724X.postDelayed(new C18461(this), 100);
                            this.f5718a.m6620d();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                } catch (Exception e42) {
                    e42.printStackTrace();
                    if (componentName == null) {
                        try {
                            this.f5718a.m6618c(model.m);
                            for (n = 0; n < 10 && componentName == null; n++) {
                                Thread.sleep(1000);
                                componentName = this.f5718a.C.startService(launchIntent);
                            }
                        } catch (ActivityNotFoundException e5) {
                            C2201w.m8371a((int) R.string.module_music_thirdparty_sync_fail, 0);
                            this.f5718a.f5724X.postDelayed(new C18461(this), 100);
                            this.f5718a.m6620d();
                        } catch (Exception e422) {
                            e422.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    if (componentName == null) {
                        try {
                            this.f5718a.m6618c(model.m);
                            for (n = 0; n < 10 && componentName == null; n++) {
                                Thread.sleep(1000);
                                componentName = this.f5718a.C.startService(launchIntent);
                            }
                        } catch (ActivityNotFoundException e6) {
                            C2201w.m8371a((int) R.string.module_music_thirdparty_sync_fail, 0);
                            this.f5718a.f5724X.postDelayed(new C18461(this), 100);
                            this.f5718a.m6620d();
                        } catch (Exception e4222) {
                            e4222.printStackTrace();
                        }
                    }
                }
                this.f5718a.f5722V = null;
            }
        }
    }

    public C1849s(Context context, int type, String packageName) {
        this.C = context;
        this.E = packageName;
        this.F = type;
        m7015B();
        this.I = new ArrayList();
        MsgHandlerCenter.m4460a(this.f5724X);
    }

    /* renamed from: d */
    public void mo1657d(int type) {
        if (mo1658e(m6653w())) {
            if (this.H != null) {
                this.H.mo1577a(type);
            }
        } else if (CarlifeUtil.m4358a().m4401r()) {
            m6616c();
            if (!C1995c.m7602a().m7619a(m6647q())) {
                m7019z();
            }
        } else {
            m6638j(3);
            m6620d();
        }
    }

    /* renamed from: a */
    public int mo1654a(int albumType, String listId) {
        m6623e(listId);
        if (CarlifeUtil.m4358a().m4401r()) {
            int size = m6625f(listId) == null ? 0 : m6625f(listId).size();
            if (mo1686i(listId)) {
                C2201w.m8373a(this.C.getString(R.string.module_music_thirdparty_load_all_list), 1);
                return 1;
            }
            if (size == 0) {
                m6616c();
            }
            if (TextUtils.isEmpty(listId)) {
                return 0;
            }
            C1995c.m7602a().m7618a(m6647q(), listId, size, 20);
            return 0;
        }
        m6634i(3);
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
        if (m6654x() == 1) {
            if (isManual) {
                switch (this.F) {
                    case 3:
                        StatisticManager.onEvent(StatisticConstants.MUSIC_XMLY_0007);
                        break;
                    case 4:
                        StatisticManager.onEvent(StatisticConstants.MUSIC_KAOLA_0007);
                        break;
                    case 5:
                        StatisticManager.onEvent(StatisticConstants.MUSIC_CYB_0007);
                        break;
                }
            }
            m6616c();
            m7019z();
        } else if (m6654x() == 0) {
            if (isManual) {
                switch (this.F) {
                    case 3:
                        StatisticManager.onEvent(StatisticConstants.MUSIC_XMLY_0006);
                        break;
                    case 4:
                        StatisticManager.onEvent(StatisticConstants.MUSIC_KAOLA_0006);
                        break;
                    case 5:
                        StatisticManager.onEvent(StatisticConstants.MUSIC_CYB_0006);
                        break;
                }
            }
            m7014A();
        } else if (m6654x() != 3) {
        } else {
            if (!CarlifeUtil.m4358a().m4401r()) {
                C2201w.m8373a(this.C.getString(R.string.carlife_update_no_network), 0);
            } else if (m6652v() == 0) {
                m6609a(false);
                m6637j();
            } else {
                m6610b();
            }
        }
    }

    @Deprecated
    /* renamed from: h */
    public void mo1660h() {
    }

    /* renamed from: d */
    public Bitmap mo1656d(String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        return CarlifeUtil.m4357a(url);
    }

    /* renamed from: g */
    public List<MusicSongModel> mo1659g() {
        return m6625f(m6644n());
    }

    /* renamed from: a */
    public void m7022a(List<CLAlbum> list) {
        LogUtil.d("CarLifePlatform", "PlatformManager.onGetAlbumList() --2");
        this.I.clear();
        for (CLAlbum clAlbum : list) {
            this.I.add(new C1929i(clAlbum));
        }
        if (this.I.isEmpty()) {
            MsgHandlerCenter.m4454a((int) CommonParams.dQ, m6649s(), 1000);
            return;
        }
        C1929i albumModel = (C1929i) this.I.get(0);
        if (albumModel.f6053a.equals("下载听")) {
            this.A = albumModel.f6055c;
        }
        MsgHandlerCenter.m4463b(206, 1, m6649s());
        int syncCostTime = (int) (System.currentTimeMillis() - this.f5723W);
        switch (this.F) {
            case 3:
                StatisticManager.onEventDuration(this.C, StatisticConstants.MUSIC_XMLY_0008, "喜马拉雅FM同步时长", syncCostTime);
                return;
            case 4:
                StatisticManager.onEventDuration(this.C, StatisticConstants.MUSIC_KAOLA_0008, "考拉FM同步时长", syncCostTime);
                return;
            case 5:
                StatisticManager.onEventDuration(this.C, StatisticConstants.MUSIC_CYB_0008, "车悦宝同步时长", syncCostTime);
                return;
            default:
                return;
        }
    }

    /* renamed from: y */
    public void mo1690y() {
        C1995c.m7602a().m7622c(m6647q());
        m6623e(null);
        this.I.clear();
        this.x.clear();
        MsgHandlerCenter.m4464b(this.f5724X);
        this.f5724X = null;
        super.mo1690y();
    }

    /* renamed from: a */
    public void m7021a(String songId, long downloadSize, long totalSize, boolean stop) {
        if (this.f5721U == null || !this.f5721U.f5909a.equals(songId)) {
            this.f5721U = m6631h(songId);
        }
        if (this.f5721U == null) {
            LogUtil.e(C1818h.f5590a, "---onGetSong--songId:" + songId);
            return;
        }
        this.f5721U.f5922n = downloadSize;
        this.f5721U.f5923o = totalSize;
        if (stop && downloadSize >= totalSize && downloadSize > 0) {
            LogUtil.d(C1818h.f5590a, "----MSG_MUSIC_THIRDPARTY_DOWNLOAD_COMPLETE---");
            MsgHandlerCenter.m4459a(217, this.f5721U);
        }
        if (stop) {
            this.f5721U = null;
        }
    }

    /* renamed from: a */
    public void m7023a(List<MusicSongModel> newList, String songListId, int pn, int rn, int total) {
        if (newList == null || newList.isEmpty()) {
            List<MusicSongModel> oldList = m6625f(songListId);
            if (oldList == null || oldList.isEmpty()) {
                LogUtil.d(C1818h.f5590a, "PlatformManager.onGetSongList() - FAIL");
                m6613b(songListId);
            }
            if (this.I == null || this.I.size() == 0 || this.A == null || !this.A.equals(songListId)) {
                MsgHandlerCenter.m4462b(CommonParams.dR, m6649s());
                return;
            }
            m6613b(songListId);
            MsgHandlerCenter.m4463b(CommonParams.dR, m6649s(), -1);
            return;
        }
        MsgHandlerCenter.m4458a(218, m6649s(), new Pair(songListId, newList));
        int offset;
        if (rn <= 0) {
            offset = newList.size();
        } else {
            offset = rn;
        }
        if (total > 0 && total <= pn + offset) {
            LogUtil.d(C1818h.f5590a, "PlatformManager.onGetSongList() - ALL");
            mo1687j(songListId);
        }
    }

    /* renamed from: k */
    private boolean m7018k(String packagename) {
        PackageInfo packageInfo = null;
        try {
            if (this.C.getPackageManager().getPackageInfo(packagename, 0) == null) {
                return false;
            }
            return true;
        } catch (NameNotFoundException e) {
            if (packageInfo != null) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            if (packageInfo != null) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: z */
    private void m7019z() {
        this.f5723W = System.currentTimeMillis();
        if (this.f5724X != null && this.f5722V == null) {
            this.f5722V = new C18471(this);
            this.f5722V.start();
        }
    }

    /* renamed from: A */
    private void m7014A() {
        if (CarlifeUtil.m4358a().m4401r()) {
            C1931j model = C1818h.m6730b().m6824m(m6649s());
            String address = model == null ? null : model.i;
            if (TextUtils.isEmpty(address)) {
                C2201w.m8373a("非法URL" + address, 1);
                return;
            }
            if (!address.startsWith("http")) {
                address = "http://" + address;
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(address));
                intent.addFlags(268435456);
                this.C.startActivity(intent);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        C2201w.m8373a(this.C.getString(R.string.carlife_update_no_network), 0);
    }

    /* renamed from: B */
    private void m7015B() {
        if (m7018k(this.E)) {
            List<MusicSongModel> list = mo1659g();
            if (list == null || list.isEmpty()) {
                m6617c(1);
                return;
            } else {
                m6617c(2);
                return;
            }
        }
        m6617c(0);
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
}
