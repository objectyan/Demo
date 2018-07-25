package com.baidu.carlife.logic.music;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
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
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.platform.C1995c;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.carlife.util.C2201w;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragmentManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.ParamKey;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.tencent.qplayauto.device.QPlayAutoJNI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: QQMusicDataManager */
/* renamed from: com.baidu.carlife.logic.music.q */
public class C1838q extends C1790b {
    /* renamed from: T */
    public static final List<MusicSongModel> f5700T = new ArrayList();
    /* renamed from: U */
    public static final String f5701U = "LOCAL_MUSIC";
    /* renamed from: V */
    public static final String f5702V = "LAST_PLAYLIST";
    /* renamed from: W */
    public static final String f5703W = "MY_FOLDER:{\\\"KEY_NAME\\\":\\\"我喜欢\\\",\\\"KEY_TYPE\\\":101,\\\"KEY_ID\\\":201}";
    /* renamed from: Y */
    public static boolean f5704Y = false;
    private static final int aa = -202;
    private static final int ab = 20;
    private static final String ac = "http://dldir1.qq.com/music/clntupate/QQMusic.apk";
    private static final String ad = "com.tencent.qqmusic";
    private static final String ae = "DEFAULT_POP";
    private static final String af = "DEFAULT_HOT";
    /* renamed from: X */
    protected C1535b f5705X;
    /* renamed from: Z */
    public HashMap<String, Integer> f5706Z = new HashMap();
    private boolean ag = false;
    private boolean ah = false;
    private String ai = null;
    private int aj = -1;
    private long ak = 0;
    private long al = 0;
    private HashMap<String, Integer> am = new HashMap();
    private MsgBaseHandler an = new MsgBaseHandler(this, BaiduNaviApplication.getInstance().getMainLooper()) {
        /* renamed from: a */
        final /* synthetic */ C1838q f5688a;

        public void careAbout() {
            addMsg(CommonParams.gQ);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case -202:
                    if (msg.obj != null) {
                        this.f5688a.m6965a(null, msg.obj, 0, 0, msg.arg1);
                        return;
                    }
                    return;
                case 1:
                    if (msg.obj.toString().indexOf("Heartbeat") < 0) {
                        this.f5688a.m6946a((HashMap) msg.obj);
                    } else {
                        this.f5688a.m6946a((HashMap) msg.obj);
                    }
                    return;
                case 2:
                    if (msg.arg1 == 2) {
                        Object bmp = C1838q.m6939a((byte[]) msg.obj);
                        if (bmp != null) {
                            MsgHandlerCenter.m4458a((int) CommonParams.dB, 1, bmp);
                            return;
                        }
                        return;
                    } else if (msg.arg1 != 3) {
                        return;
                    } else {
                        return;
                    }
                case 4:
                    if (msg.arg1 == 0) {
                        LogUtil.m4440c(C1818h.f5590a, "连接成功");
                        this.f5688a.m6937D();
                        if (this.f5688a.ah) {
                            this.f5688a.m6638j(2);
                        }
                        BaseFragment.getNaviActivity().sendBroadcast(new Intent("com.baidu.carlife.Action.StartActivityBroadReceiver"));
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        QPlayAutoJNI.SendRegisterPlayState(0);
                        LogUtil.m4440c(C1818h.f5590a, "连接成功 end");
                        return;
                    }
                    int status = 1;
                    if (msg.arg1 == 1) {
                        LogUtil.e(C1818h.f5590a, "QQMusic:与手机连接失败!");
                    } else if (msg.arg1 == 2) {
                        LogUtil.e(C1818h.f5590a, "QQMusic:与手机连接中断!");
                        status = 7;
                    }
                    if (this.f5688a.m6652v() == 1) {
                        this.f5688a.m6651u();
                        this.f5688a.m6599a(0);
                        this.f5688a.ah = false;
                        this.f5688a.ai = null;
                        this.f5688a.aj = -1;
                    }
                    this.f5688a.m6638j(status);
                    this.f5688a.m6623e(null);
                    this.f5688a.I.clear();
                    this.f5688a.x.clear();
                    if (this.f5688a.H != null) {
                        this.f5688a.H.mo1578a(C1838q.ad);
                    }
                    this.f5688a.S.clear();
                    QPlayAutoJNI.stopConnect();
                    return;
                case 5:
                    if (msg.arg1 == 1) {
                        if (msg.obj != null) {
                            LogUtil.d(C1818h.f5590a, "QQMusic:" + msg.obj.toString());
                            return;
                        }
                        return;
                    } else if (msg.arg1 == 2) {
                        LogUtil.d(C1818h.f5590a, "播放缓冲区大小:" + msg.arg2);
                        return;
                    } else {
                        return;
                    }
                case 6:
                    QPlayAutoJNI.SendInfo(1, C1818h.f5590a, "出现错误:" + msg.obj.toString());
                    return;
                case CommonParams.gQ /*4014*/:
                    String packageName = msg.obj;
                    if (!TextUtils.isEmpty(packageName) && packageName.equals(this.f5688a.m6647q())) {
                        if (msg.arg1 == CommonParams.iw) {
                            this.f5688a.m6638j(1);
                            return;
                        } else if (msg.arg1 == CommonParams.ix) {
                            this.f5688a.m6638j(0);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };

    /* compiled from: QQMusicDataManager */
    /* renamed from: com.baidu.carlife.logic.music.q$a */
    private class C1837a extends Thread {
        /* renamed from: a */
        int f5694a = -1;
        /* renamed from: b */
        boolean f5695b = false;
        /* renamed from: c */
        C1929i f5696c;
        /* renamed from: d */
        C1929i f5697d;
        /* renamed from: e */
        C1929i f5698e;
        /* renamed from: f */
        final /* synthetic */ C1838q f5699f;

        public C1837a(C1838q c1838q, C1929i recentPlayFinal, C1929i rankPopFinal, C1929i rankHotFinal, boolean isNeedSendMsg) {
            this.f5699f = c1838q;
            this.f5696c = recentPlayFinal;
            this.f5697d = rankPopFinal;
            this.f5698e = rankHotFinal;
            this.f5695b = isNeedSendMsg;
        }

        /* renamed from: a */
        private boolean m6933a(ArrayList albumList, String parentID, int pageIndex, int pagePreCount, String target) {
            HashMap hm = QPlayAutoJNI.GetSongLists(albumList, parentID, pageIndex, pagePreCount);
            if (hm == null) {
                hm = QPlayAutoJNI.GetSongLists(albumList, parentID, pageIndex, pagePreCount);
                if (hm == null) {
                    return false;
                }
            }
            if (hm.get(ParamKey.KEY_MSG_ERRORS) != null) {
                return false;
            }
            this.f5694a = 0;
            while (this.f5694a < albumList.size()) {
                if (albumList.get(this.f5694a) instanceof HashMap) {
                    HashMap map = (HashMap) albumList.get(this.f5694a);
                    if (map.containsKey("name") && map.get("name").toString().contains(target)) {
                        break;
                    }
                }
                this.f5694a++;
            }
            if (this.f5694a < albumList.size()) {
                return true;
            }
            return false;
        }

        public void run() {
            ArrayList albumList = new ArrayList();
            if (this.f5696c != null) {
                if (m6933a(albumList, QPlayAutoJNI.SONG_LIST_ROOT_ID, 0, 20, "最近播放")) {
                    albumList.clear();
                    this.f5699f.I.remove(this.f5698e);
                } else if (this.f5698e == null) {
                    this.f5697d.f6055c = C1838q.ae;
                    return;
                } else {
                    albumList.clear();
                    this.f5699f.I.remove(this.f5696c);
                    this.f5696c = null;
                }
            }
            this.f5694a = -1;
            String parentID = "RANK";
            if (m6933a(albumList, parentID, 0, 20, "流行")) {
                if (this.f5694a < albumList.size()) {
                    parentID = ((HashMap) albumList.get(this.f5694a)).get("id").toString().replace("\"", "\\\"");
                }
                albumList.clear();
            } else {
                parentID = C1838q.ae;
                albumList.clear();
            }
            this.f5697d.f6055c = parentID;
            this.f5694a = -1;
            if (this.f5696c == null && this.f5698e != null) {
                parentID = "RANK";
                if (m6933a(albumList, parentID, 0, 20, "热歌")) {
                    if (this.f5694a < albumList.size()) {
                        parentID = ((HashMap) albumList.get(this.f5694a)).get("id").toString().replace("\"", "\\\"");
                    }
                    albumList.clear();
                } else {
                    parentID = C1838q.af;
                    albumList.clear();
                }
                this.f5698e.f6055c = parentID;
            }
            this.f5694a = -1;
            if (this.f5695b) {
                MsgHandlerCenter.m4463b(206, 1, this.f5699f.m6649s());
            }
        }
    }

    public C1838q(Context context, int type, String packageName) {
        this.C = context;
        this.E = packageName;
        this.F = type;
        m6936C();
        this.I = new ArrayList();
        MsgHandlerCenter.m4460a(this.an);
    }

    /* renamed from: d */
    public void mo1657d(int type) {
        if (!mo1658e(m6653w())) {
            m6616c();
            m6954c(true);
        } else if (this.H != null) {
            this.H.mo1577a(type);
        }
    }

    /* renamed from: a */
    public int mo1654a(int albumType, String listId) {
        m6623e(listId);
        if (listId != null && listId.equals(f5701U)) {
            return m6961z();
        }
        if (!CarlifeUtil.m4358a().m4401r()) {
            m6634i(3);
            return 0;
        } else if (m6950a(listId, false)) {
            return 1;
        } else {
            return 0;
        }
    }

    /* renamed from: a */
    public void m6964a(C1535b albumSizeCallBack) {
        this.f5705X = albumSizeCallBack;
        this.f5705X.mo1583a(f5701U, f5700T.size());
        m6950a(f5703W, true);
        m6950a(f5702V, true);
    }

    /* renamed from: a */
    private boolean m6950a(String listId, boolean justSize) {
        int pageIndex;
        int size = m6625f(listId) == null ? 0 : m6625f(listId).size();
        if (this.am.get(listId) == null) {
            pageIndex = 0;
        } else {
            pageIndex = ((Integer) this.am.get(listId)).intValue();
        }
        if (mo1686i(listId)) {
            if (!justSize) {
                C2201w.m8373a(this.C.getString(R.string.module_music_thirdparty_load_all_list), 1);
            }
            if (this.f5705X != null) {
                this.f5705X.mo1583a(listId, size);
            }
            return true;
        }
        if (size == 0 && !justSize) {
            m6616c();
        }
        if (TextUtils.isEmpty(listId)) {
            return false;
        }
        m6945a(listId, 20, pageIndex, justSize);
        return false;
    }

    /* renamed from: z */
    private int m6961z() {
        if (f5700T.size() == 0) {
            m6613b(f5701U);
            MsgHandlerCenter.m4463b(CommonParams.dR, m6649s(), -101);
        } else {
            Object pair = new Pair(f5701U, f5700T);
            mo1687j(f5701U);
            MsgHandlerCenter.m4458a(218, m6649s(), pair);
        }
        return 1;
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

    /* renamed from: a */
    public void mo1689a(Bundle bundle) {
        if (bundle != null) {
            Bundle arg = bundle.getBundle(ContentFragmentManager.KEY_SHOW_BUNDLE);
            if (arg == null) {
                if (!R) {
                    R = true;
                    m6610b();
                }
            } else if (arg.containsKey("album_id")) {
                String albumId = arg.getString("album_id");
                if (albumId != null) {
                    m6958m(albumId);
                    m6957l(albumId);
                    arg.remove("album_id");
                }
            } else if (arg.getBoolean(C1790b.f5466i, false)) {
                m6610b();
                arg.remove(C1790b.f5466i);
            } else if (arg.getBoolean(C1790b.f5467j, false)) {
                m6613b(m6644n());
                arg.remove(C1790b.f5467j);
            }
        }
    }

    /* renamed from: l */
    private void m6957l(String albumId) {
        if (!m6630g(albumId)) {
            C1818h.m6730b().m6811f(true);
            m6622e();
            mo1654a(m6653w(), albumId);
        } else if (!albumId.equals(m6644n())) {
            m6623e(albumId);
            m6627f(0);
            m6610b();
        }
    }

    /* renamed from: m */
    private void m6958m(String albumId) {
        if (!albumId.equals(f5703W) || m6644n() == null) {
            this.x.remove(f5703W);
            this.am.remove(f5703W);
            this.S.remove(f5703W);
        }
    }

    /* renamed from: b */
    public void mo1655b(boolean isManual) {
        if (m6654x() == 1 || m6654x() == 7) {
            if (isManual) {
                StatisticManager.onEvent(StatisticConstants.MUSIC_QQ_0007);
            } else {
                this.al = System.currentTimeMillis();
                StatisticManager.onEvent(StatisticConstants.MUSIC_QQ_0016);
            }
            m6934A();
        } else if (m6654x() == 0) {
            if (isManual) {
                StatisticManager.onEvent(StatisticConstants.MUSIC_QQ_0006);
            }
            m6935B();
        } else if (m6654x() != 3) {
        } else {
            if (m6652v() == 0) {
                m6609a(false);
                m6637j();
                return;
            }
            m6610b();
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

    /* renamed from: y */
    public void mo1690y() {
        C1995c.m7602a().m7622c(m6647q());
        m6623e(null);
        this.I.clear();
        this.x.clear();
        MsgHandlerCenter.m4464b(this.an);
        this.an = null;
        super.mo1690y();
    }

    /* renamed from: a */
    public void m6965a(List<MusicSongModel> newList, String songListId, int pageIndex, int total, int errorCode) {
        if (newList == null || newList.isEmpty()) {
            List<MusicSongModel> oldList = m6625f(songListId);
            if (oldList == null || oldList.isEmpty()) {
                m6944a(songListId, errorCode);
                return;
            }
            return;
        }
        m6947a((List) newList, songListId, pageIndex, total);
    }

    /* renamed from: a */
    private void m6944a(String songListId, int errorCode) {
        LogUtil.d(C1818h.f5590a, "QQMusic.onGetSongList() - FAIL");
        m6613b(songListId);
        if (errorCode == 110) {
            MsgHandlerCenter.m4463b(CommonParams.dR, m6649s(), errorCode);
        } else {
            MsgHandlerCenter.m4463b(CommonParams.dR, m6649s(), -1);
        }
    }

    /* renamed from: a */
    private void m6947a(List<MusicSongModel> newList, String songListId, int pageIndex, int total) {
        MsgHandlerCenter.m4458a(218, m6649s(), new Pair(songListId, newList));
        this.am.put(songListId, Integer.valueOf(pageIndex));
        if (total > 0 && total <= pageIndex * 20) {
            LogUtil.d(C1818h.f5590a, "QQMusic.onGetSongList() - ALL");
            mo1687j(songListId);
        }
    }

    /* renamed from: n */
    private boolean m6959n(String packagename) {
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

    /* renamed from: A */
    private void m6934A() {
        this.f5706Z.clear();
        this.ak = System.currentTimeMillis();
        QPlayAutoJNI.SetHandler(this.an);
        if (QPlayAutoJNI.startConnect() < 0) {
            QPlayAutoJNI.stopConnect();
            LogUtil.e(C1818h.f5590a, "QQ音乐发现线程启动失败!");
        } else if (!C1838q.m6956k(ad)) {
            m6618c(ad);
        }
    }

    /* renamed from: k */
    public static boolean m6956k(String packageName) {
        int processCount = 0;
        for (File file : new File("/proc").listFiles()) {
            if (file.isDirectory()) {
                try {
                    try {
                        if (C1838q.m6960o(String.format("/proc/%d/cmdline", new Object[]{Integer.valueOf(Integer.parseInt(files[r8].getName()))})).contains(packageName)) {
                            processCount++;
                            if (processCount > 1) {
                                return true;
                            }
                        } else {
                            continue;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (NumberFormatException e2) {
                }
            }
        }
        return false;
    }

    /* renamed from: o */
    private static String m6960o(String path) throws IOException {
        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        output.append(reader.readLine());
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            output.append('\n').append(line);
        }
        reader.close();
        return output.toString().trim();
    }

    /* renamed from: B */
    private void m6935B() {
        if (CarlifeUtil.m4358a().m4401r()) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(ac));
                intent.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
                this.C.startActivity(intent);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        C2201w.m8373a(this.C.getString(R.string.carlife_update_no_network), 0);
    }

    /* renamed from: C */
    private void m6936C() {
        if (m6959n(this.E)) {
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

    /* renamed from: D */
    private void m6937D() {
        this.aj = (int) (System.currentTimeMillis() - this.ak);
        int autoSyncCostTime = (int) (System.currentTimeMillis() - this.al);
        if (this.ai != null) {
            StatisticManager.onEventDuration(this.C, StatisticConstants.MUSIC_QQ_0008, "QQ音乐版本号" + this.ai, this.aj);
            this.aj = -1;
        }
        if (autoSyncCostTime < 20000) {
            StatisticManager.onEvent(StatisticConstants.MUSIC_QQ_0017);
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

    /* renamed from: a */
    public static Bitmap m6939a(byte[] b) {
        if (b.length != 0) {
            return BitmapFactory.decodeByteArray(b, 0, b.length);
        }
        return null;
    }

    /* renamed from: a */
    private void m6946a(HashMap hm) {
        if (hm != null && hm.size() >= 1) {
            try {
                if (hm.get("request").toString().equalsIgnoreCase("DeviceInfos")) {
                    QPlayAutoJNI.SendDeviceInfos("Baidu", "CarLife", CommonParams.jb, UserOPParams.LIGHTGUIDE_4_4, QPlayAutoJNI.PCM_BUFFER_LENGTH);
                    HashMap mdInfo = QPlayAutoJNI.GetMobileDeviceInfos();
                    float version = Float.parseFloat(mdInfo.get("ver").toString());
                    if (mdInfo.get("appver") != null) {
                        this.ai = mdInfo.get("appver").toString();
                    } else {
                        this.ai = "unkown";
                    }
                    if (this.aj > 0) {
                        StatisticManager.onEventDuration(this.C, StatisticConstants.MUSIC_QQ_0008, "QQ音乐版本号" + this.ai, this.aj);
                        this.aj = -1;
                    }
                    if (Float.compare(version, 1.2f) >= 0) {
                        LogUtil.m4440c(C1818h.f5590a, "version = " + version);
                        this.ah = true;
                        m6638j(2);
                        m6637j();
                        return;
                    }
                    LogUtil.m4440c(C1818h.f5590a, "version = " + version);
                    this.ah = false;
                    this.ai = null;
                    this.aj = -1;
                    QPlayAutoJNI.stopConnect();
                    LogUtil.e(C1818h.f5590a, "QQ音乐协议版本过低!");
                    StatisticManager.onEvent(StatisticConstants.MUSIC_QQ_0014, "版本不支持");
                    m6620d();
                    m6638j(0);
                    m6623e(null);
                    this.I.clear();
                    this.x.clear();
                    this.am.clear();
                    this.H.mo1578a(this.E);
                    this.S.clear();
                    BaseFragment.getNaviActivity().sendBroadcast(new Intent("com.baidu.carlife.Action.StartActivityBroadReceiver"));
                } else if (hm.get("request").toString().equalsIgnoreCase("Disconnect")) {
                    if (m6652v() == 1) {
                        m6651u();
                        m6599a(0);
                        this.ah = false;
                        this.ai = null;
                        this.aj = -1;
                    }
                    if (this.ah) {
                        m6638j(1);
                    }
                    m6623e(null);
                    this.I.clear();
                    this.x.clear();
                    this.am.clear();
                    this.H.mo1578a(this.E);
                    this.S.clear();
                } else if (hm.get("request").toString().equalsIgnoreCase("DevicePlayStop")) {
                    LogUtil.m4440c(C1818h.f5590a, "DevicePlay = DevicePlayStop");
                } else if (hm.get("request").toString().equalsIgnoreCase("DevicePlayPre")) {
                    LogUtil.m4440c(C1818h.f5590a, "DevicePlay = DevicePlayPre");
                } else if (hm.get("request").toString().equalsIgnoreCase("DevicePlayNext")) {
                    LogUtil.m4440c(C1818h.f5590a, "DevicePlay = DevicePlayNext");
                } else if (hm.get("request").toString().equalsIgnoreCase("DevicePlayPlay")) {
                    if (!(C1818h.m6730b().m6829q() || C1818h.m6730b().m6826n() != 1 || C1818h.m6730b().m6823l())) {
                        C1829n.m6886a(2);
                        C1818h.m6730b().m6803d(false);
                    }
                    LogUtil.m4440c(C1818h.f5590a, "DevicePlay = DevicePlayPlay");
                } else if (hm.get("request").toString().equalsIgnoreCase("DevicePlayPause")) {
                    if (!C1818h.m6730b().m6829q() && C1818h.m6730b().m6826n() == 1 && mo1696p().f5921m == null) {
                        C1829n.m6886a(1);
                        C1818h.m6730b().m6811f(false);
                    }
                    LogUtil.m4440c(C1818h.f5590a, "DevicePlay = DevicePlayPause");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    private void m6954c(boolean isNeedAsync) {
        C1929i recentSongs;
        C1929i rankPop;
        C1929i rankHot = null;
        if (this.I.size() == 4) {
            recentSongs = (C1929i) this.I.get(1);
            if (recentSongs.f6056d == R.drawable.music_ic_qq_recent) {
                rankPop = (C1929i) this.I.get(3);
            } else {
                recentSongs = null;
                rankPop = (C1929i) this.I.get(2);
                rankHot = (C1929i) this.I.get(3);
            }
        } else {
            C1929i downLoadSongs = m6940a(this.C.getString(R.string.module_musicqq_localmusic), f5701U, R.drawable.music_ic_qq_downloadsong);
            recentSongs = m6940a(this.C.getString(R.string.module_musicqq_recent), f5702V, R.drawable.music_ic_qq_recent);
            C1929i myFavoriteSongs = m6940a(this.C.getString(R.string.module_musicqq_myfavourite), f5703W, R.drawable.music_ic_qq_favoriter);
            rankPop = m6940a(this.C.getString(R.string.module_musicqq_poprank), ae, R.drawable.music_ic_qq_popular);
            rankHot = m6940a(this.C.getString(R.string.module_musicqq_hotrank), af, R.drawable.music_ic_qq_hot);
            this.I.add(downLoadSongs);
            this.I.add(recentSongs);
            this.I.add(myFavoriteSongs);
            this.I.add(rankPop);
            this.I.add(rankHot);
        }
        m6948a(isNeedAsync, recentSongs, rankPop, rankHot);
    }

    /* renamed from: a */
    private void m6948a(boolean isNeedAsync, C1929i recentSongs, C1929i rankPop, C1929i rankHot) {
        if (isNeedAsync) {
            new C1837a(this, recentSongs, rankPop, rankHot, true).start();
        } else {
            new C1837a(this, recentSongs, rankPop, rankHot, false).run();
        }
    }

    @NonNull
    /* renamed from: a */
    private C1929i m6940a(String albumName, String id, int resId) {
        C1929i downLoadSongs = new C1929i();
        downLoadSongs.f6053a = albumName;
        downLoadSongs.f6055c = id;
        downLoadSongs.f6056d = resId;
        return downLoadSongs;
    }

    /* renamed from: a */
    private void m6945a(String albumID, int sizeMore, int pageIndex, boolean justSize) {
        if (!justSize) {
            if (!this.ag) {
                this.ag = true;
            } else {
                return;
            }
        }
        final String str = albumID;
        final int i = pageIndex;
        final int i2 = sizeMore;
        final boolean z = justSize;
        new Thread(this) {
            /* renamed from: e */
            final /* synthetic */ C1838q f5693e;

            public void run() {
                String realAlbumID = str;
                if (str.equals(C1838q.af)) {
                    this.f5693e.m6954c(false);
                    realAlbumID = m6931a(realAlbumID, (int) R.drawable.music_ic_qq_hot);
                } else if (str.equals(C1838q.ae)) {
                    this.f5693e.m6954c(false);
                    realAlbumID = m6931a(realAlbumID, (int) R.drawable.music_ic_qq_popular);
                }
                int innerPageIndex = i;
                int errorCode = 0;
                int total = -11;
                boolean result = true;
                ArrayList qqSongList = new ArrayList();
                List songList = new ArrayList();
                while (result && songList.size() < 10 && (total > innerPageIndex * 20 || total == -11)) {
                    HashMap hm = QPlayAutoJNI.GetSongLists(qqSongList, realAlbumID, innerPageIndex, i2);
                    if (hm == null) {
                        hm = QPlayAutoJNI.GetSongLists(qqSongList, realAlbumID, innerPageIndex, i2);
                        if (hm == null) {
                            result = false;
                        }
                    }
                    Object error = hm.get(ParamKey.KEY_MSG_ERRORS);
                    if (error != null) {
                        try {
                            errorCode = Integer.parseInt(error.toString());
                        } catch (NumberFormatException e) {
                            errorCode = -65535;
                        }
                        result = false;
                    }
                    Object val = hm.get("count");
                    if (val == null) {
                        total = 0;
                    } else {
                        try {
                            total = Integer.parseInt(val.toString());
                        } catch (NumberFormatException e2) {
                            total = 0;
                        }
                    }
                    if (!result) {
                        break;
                    }
                    m6932a(qqSongList, songList);
                    qqSongList.clear();
                    innerPageIndex++;
                }
                if (result) {
                    if (C1838q.f5703W == realAlbumID) {
                        C1838q.f5704Y = true;
                    }
                    if (!z) {
                        this.f5693e.m6965a(songList, realAlbumID, innerPageIndex, total, errorCode);
                    } else if (this.f5693e.f5705X != null) {
                        this.f5693e.f5705X.mo1583a(realAlbumID, total);
                    }
                } else {
                    if (!z) {
                        this.f5693e.an.obtainMessage(-202, errorCode, 0, realAlbumID).sendToTarget();
                    }
                    if (C1838q.f5703W == realAlbumID) {
                        C1838q.f5704Y = false;
                    }
                }
                this.f5693e.ag = false;
            }

            /* renamed from: a */
            private void m6932a(ArrayList qqSongList, List<MusicSongModel> songList) {
                for (int i = 0; i < qqSongList.size(); i++) {
                    HashMap tempMap = (HashMap) qqSongList.get(i);
                    if (!tempMap.get("issong").toString().equals("0")) {
                        MusicSongModel temp = new MusicSongModel();
                        temp.f5910b = tempMap.get("name").toString();
                        temp.f5914f = tempMap.get("artist").toString();
                        temp.f5911c = tempMap.get(C2125n.f6756X).toString();
                        temp.f5909a = tempMap.get("id").toString().replace("\"", "\\\"");
                        songList.add(temp);
                    }
                }
            }

            /* renamed from: a */
            private String m6931a(String realAlbumID, int targetResId) {
                int length = this.f5693e.I.size();
                for (int i = 0; i < length; i++) {
                    if (((C1929i) this.f5693e.I.get(i)).f6056d == targetResId) {
                        realAlbumID = ((C1929i) this.f5693e.I.get(i)).f6055c;
                        this.f5693e.m6623e(realAlbumID);
                    }
                }
                return realAlbumID;
            }
        }.start();
    }
}
