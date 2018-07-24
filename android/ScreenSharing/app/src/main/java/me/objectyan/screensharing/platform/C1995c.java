package com.baidu.carlife.platform;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.platform.model.CLAlbum;
import com.baidu.carlife.platform.service.C1991f.C1992a;
import com.baidu.carlife.platform.service.C2008e;
import com.baidu.carlife.platform.service.C2008e.C2020a;
import com.baidu.carlife.platform.service.CLPlatformService;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PlatformManager */
/* renamed from: com.baidu.carlife.platform.c */
public class C1995c {
    /* renamed from: a */
    public static final int f6429a = 1;
    /* renamed from: b */
    public static final int f6430b = 2;
    /* renamed from: c */
    public static final int f6431c = 3;
    /* renamed from: d */
    public static final int f6432d = 4;
    /* renamed from: e */
    public static final int f6433e = 5;
    /* renamed from: j */
    private static C1995c f6434j = new C1995c();
    /* renamed from: f */
    private HandlerThread f6435f = new HandlerThread("CarLifeThirdParty Thread");
    /* renamed from: g */
    private Handler f6436g;
    /* renamed from: h */
    private Context f6437h = null;
    /* renamed from: i */
    private C2008e f6438i = null;
    /* renamed from: k */
    private Handler f6439k;
    /* renamed from: l */
    private List<String> f6440l;
    /* renamed from: m */
    private C1776b f6441m;
    /* renamed from: n */
    private ServiceConnection f6442n = new C19851(this);
    /* renamed from: o */
    private C1992a f6443o = new C19932(this);

    /* compiled from: PlatformManager */
    /* renamed from: com.baidu.carlife.platform.c$1 */
    class C19851 implements ServiceConnection {
        /* renamed from: a */
        final /* synthetic */ C1995c f6393a;

        C19851(C1995c this$0) {
            this.f6393a = this$0;
        }

        public void onServiceDisconnected(ComponentName className) {
        }

        public void onServiceConnected(ComponentName className, IBinder binder) {
            LogUtil.d("CarLifePlatform", "onServiceConnected()");
            this.f6393a.f6438i = C2020a.m7747a(binder);
            if (this.f6393a.f6438i != null) {
                try {
                    this.f6393a.f6438i.mo1749a(this.f6393a.f6443o);
                    this.f6393a.f6440l = this.f6393a.f6438i.mo1744a();
                } catch (Throwable e) {
                    LogUtil.m4432a("PlatformManager", e);
                }
            }
            if (this.f6393a.f6440l == null) {
                this.f6393a.f6440l = new ArrayList();
            } else if (this.f6393a.f6440l.size() > 0 && this.f6393a.f6440l != null && this.f6393a.f6440l.size() > 0 && !TextUtils.isEmpty((CharSequence) this.f6393a.f6440l.get(0)) && this.f6393a.f6441m != null) {
                this.f6393a.f6441m.mo1653b((String) this.f6393a.f6440l.get(0));
            }
        }
    }

    /* compiled from: PlatformManager */
    /* renamed from: com.baidu.carlife.platform.c$2 */
    class C19932 extends C1992a {
        /* renamed from: a */
        final /* synthetic */ C1995c f6427a;

        C19932(C1995c this$0) {
            this.f6427a = this$0;
        }

        /* renamed from: a */
        public void mo1734a(int errorNo, String errorMsg) throws RemoteException {
        }

        /* renamed from: a */
        public void mo1738a(final String name) throws RemoteException {
            LogUtil.d("CarLifePlatform", "PlatformManager.onRemoteClinetConnected()");
            if (this.f6427a.f6439k != null) {
                this.f6427a.f6439k.post(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C19932 f6395b;

                    public void run() {
                        this.f6395b.f6427a.m7613e(name);
                        if (this.f6395b.f6427a.f6441m != null) {
                            this.f6395b.f6427a.f6441m.mo1653b(name);
                        }
                    }
                });
            }
        }

        /* renamed from: b */
        public void mo1739b(final String packageName) throws RemoteException {
            LogUtil.d("CarLifePlatform", "PlatformManager.onRemoteClientDisconnected()");
            if (this.f6427a.f6439k != null) {
                this.f6427a.f6439k.post(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C19932 f6397b;

                    public void run() {
                        this.f6397b.f6427a.m7614f(packageName);
                        if (this.f6397b.f6427a.f6441m != null) {
                            this.f6397b.f6427a.f6441m.mo1652a(packageName);
                        }
                    }
                });
            }
        }

        /* renamed from: a */
        public void mo1736a(int errorNo, String errorMsg, String packageName, String songListId, List<MusicSongModel> songList, int pn, int rn, int total) throws RemoteException {
            LogUtil.d("CarLifePlatform", "PlatformManager.onGetSongList() error=" + errorNo + " msg=" + errorMsg + " package=" + packageName + " songListId=" + songListId + " pn=" + pn + " rn=" + rn + " total=" + total);
            if (this.f6427a.f6439k != null) {
                final int i = errorNo;
                final String str = errorMsg;
                final String str2 = packageName;
                final String str3 = songListId;
                final List<MusicSongModel> list = songList;
                final int i2 = pn;
                final int i3 = rn;
                final int i4 = total;
                this.f6427a.f6439k.post(new Runnable(this) {
                    /* renamed from: i */
                    final /* synthetic */ C19932 f6406i;

                    public void run() {
                        if (this.f6406i.f6427a.f6441m != null) {
                            this.f6406i.f6427a.f6441m.mo1650a(i, str, str2, str3, list, i2, i3, i4);
                        }
                    }
                });
            }
        }

        /* renamed from: a */
        public void mo1735a(int errorNo, String errorMsg, String packageName, String songId, long downloadSize, long totalSize, boolean stop) throws RemoteException {
            LogUtil.d("CarLifePlatform", "PlatformManager.onGetSong()");
            if (this.f6427a.f6439k != null) {
                final int i = errorNo;
                final String str = errorMsg;
                final String str2 = packageName;
                final String str3 = songId;
                final long j = downloadSize;
                final long j2 = totalSize;
                final boolean z = stop;
                this.f6427a.f6439k.post(new Runnable(this) {
                    /* renamed from: h */
                    final /* synthetic */ C19932 f6414h;

                    public void run() {
                        if (this.f6414h.f6427a.f6441m != null) {
                            this.f6414h.f6427a.f6441m.mo1649a(i, str, str2, str3, j, j2, z);
                        }
                    }
                });
            }
        }

        /* renamed from: a */
        public void mo1737a(int errorNo, String errorMsg, String packageName, List<CLAlbum> albumList) throws RemoteException {
            LogUtil.d("CarLifePlatform", "PlatformManager.onGetAlbumList()");
            if (this.f6427a.f6439k != null) {
                final int i = errorNo;
                final String str = errorMsg;
                final String str2 = packageName;
                final List<CLAlbum> list = albumList;
                this.f6427a.f6439k.post(new Runnable(this) {
                    /* renamed from: e */
                    final /* synthetic */ C19932 f6419e;

                    public void run() {
                        if (this.f6419e.f6427a.f6441m != null) {
                            this.f6419e.f6427a.f6441m.mo1651a(i, str, str2, list);
                        }
                    }
                });
            }
        }
    }

    /* compiled from: PlatformManager */
    /* renamed from: com.baidu.carlife.platform.c$a */
    private class C1994a extends Handler {
        /* renamed from: a */
        final /* synthetic */ C1995c f6428a;

        public C1994a(C1995c c1995c, Looper looper) {
            this.f6428a = c1995c;
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (this.f6428a.f6438i != null) {
                switch (msg.what) {
                    case 1:
                        String appName = msg.obj;
                        if (!TextUtils.isEmpty(appName)) {
                            try {
                                this.f6428a.f6438i.mo1751c(appName);
                                return;
                            } catch (Throwable e) {
                                LogUtil.m4432a("PlatformManager", e);
                                return;
                            }
                        }
                        return;
                    case 2:
                        Object[] args = (Object[]) msg.obj;
                        if (args != null && args.length >= 3) {
                            try {
                                this.f6428a.f6438i.mo1747a(args[0], args[1], ((Integer) args[2]).intValue(), ((Integer) args[3]).intValue());
                                return;
                            } catch (Throwable e2) {
                                LogUtil.m4432a("PlatformManager", e2);
                                return;
                            }
                        }
                        return;
                    case 3:
                        if (msg.obj != null) {
                            Pair<String, MusicSongModel> pair = (Pair) msg.obj;
                            try {
                                this.f6428a.f6438i.mo1748a((String) pair.first, ((MusicSongModel) pair.second).f5909a, ((MusicSongModel) pair.second).f5923o);
                                return;
                            } catch (Throwable e22) {
                                LogUtil.m4432a("PlatformManager", e22);
                                return;
                            }
                        }
                        return;
                    case 4:
                        if (!TextUtils.isEmpty((String) msg.obj)) {
                            try {
                                this.f6428a.f6438i.mo1750b(msg.obj);
                                return;
                            } catch (Throwable e222) {
                                LogUtil.m4432a("PlatformManager", e222);
                                return;
                            }
                        }
                        return;
                    case 5:
                        if (!TextUtils.isEmpty((String) msg.obj)) {
                            try {
                                this.f6428a.f6438i.mo1752d(msg.obj);
                                return;
                            } catch (Throwable e2222) {
                                LogUtil.m4432a("PlatformManager", e2222);
                                return;
                            }
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: a */
    public static C1995c m7602a() {
        return f6434j;
    }

    private C1995c() {
        this.f6435f.start();
        this.f6436g = new C1994a(this, this.f6435f.getLooper());
    }

    /* renamed from: a */
    public void m7615a(Context context, C1776b listener) {
        this.f6437h = context;
        this.f6441m = listener;
        this.f6439k = new Handler(context.getMainLooper());
        this.f6437h.bindService(new Intent(this.f6437h, CLPlatformService.class), this.f6442n, 1);
    }

    /* renamed from: a */
    public void m7616a(C1776b listener) {
        this.f6441m = listener;
    }

    /* renamed from: b */
    public List<String> m7620b() {
        return this.f6440l;
    }

    /* renamed from: a */
    public boolean m7619a(String appName) {
        if (m7611d(appName)) {
            LogUtil.d("CarLifePlatform", "PlatformManager.getAlbumList()");
            Message.obtain(this.f6436g, 1, appName).sendToTarget();
            return true;
        }
        LogUtil.m4445e("CarLifePlatform", "PlatformManager.getAlbumList() invalid appname " + appName);
        return false;
    }

    /* renamed from: a */
    public void m7618a(String appName, String songListId, int pn, int rn) {
        if (m7611d(appName)) {
            LogUtil.d("CarLifePlatform", "PlatformManager.getSongList() app=" + appName + " id=" + songListId + " pn=" + pn + " rn=" + rn);
            if (TextUtils.isEmpty(songListId)) {
                LogUtil.m4445e("CarLifePlatform", "PlatformManager.requestSongList() invalid songListId: " + songListId);
                return;
            }
            Message.obtain(this.f6436g, 2, new Object[]{appName, songListId, Integer.valueOf(pn), Integer.valueOf(rn)}).sendToTarget();
            return;
        }
        LogUtil.m4445e("CarLifePlatform", "PlatformManager.requestSongList() invalid appname " + appName);
    }

    /* renamed from: a */
    public void m7617a(String appName, MusicSongModel song) {
        if (m7611d(appName)) {
            LogUtil.d("CarLifePlatform", "PlatformManager.getDataWithid()");
            Message.obtain(this.f6436g, 3, new Pair(appName, song)).sendToTarget();
            return;
        }
        LogUtil.m4445e("CarLifePlatform", "PlatformManager.getDataWithid() invalid appname " + appName);
    }

    /* renamed from: b */
    public void m7621b(String appName) {
        if (m7611d(appName)) {
            LogUtil.d("CarLifePlatform", "PlatformManager.stopDownload()");
            Message.obtain(this.f6436g, 4, appName).sendToTarget();
            return;
        }
        LogUtil.m4445e("CarLifePlatform", "PlatformManager.stopDownload() invalid appname " + appName);
    }

    /* renamed from: c */
    public void m7622c(String appName) {
        if (m7611d(appName)) {
            LogUtil.d("CarLifePlatform", "PlatformManager.disconnectApp()");
            Message.obtain(this.f6436g, 5, appName).sendToTarget();
            return;
        }
        LogUtil.m4445e("CarLifePlatform", "PlatformManager.disconnectApp() invalid appname " + appName);
    }

    /* renamed from: d */
    private boolean m7611d(String appName) {
        if (this.f6440l == null || TextUtils.isEmpty(appName)) {
            return false;
        }
        return this.f6440l.contains(appName);
    }

    /* renamed from: e */
    private void m7613e(String appName) {
        if (this.f6440l == null) {
            this.f6440l = new ArrayList();
        } else {
            int i = 0;
            while (i < this.f6440l.size()) {
                String client = (String) this.f6440l.get(i);
                if (client == null || !client.equals(appName)) {
                    i++;
                } else {
                    return;
                }
            }
        }
        this.f6440l.add(appName);
    }

    /* renamed from: f */
    private void m7614f(String appName) {
        if (this.f6440l != null || this.f6440l.size() > 0) {
            int i = 0;
            while (i < this.f6440l.size()) {
                String client = (String) this.f6440l.get(i);
                if (client == null || !client.equals(appName)) {
                    i++;
                } else {
                    this.f6440l.remove(i);
                    return;
                }
            }
        }
    }
}
