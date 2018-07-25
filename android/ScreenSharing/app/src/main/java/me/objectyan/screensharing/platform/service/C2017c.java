package com.baidu.carlife.platform.service;

import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.platform.communication.C2002b;
import com.baidu.carlife.platform.communication.C2002b.C1999c;
import com.baidu.carlife.platform.communication.CLPackage;
import com.baidu.carlife.platform.model.CLSong;
import com.baidu.carlife.platform.request.CLGetAlbumListReq;
import com.baidu.carlife.platform.request.CLGetSongDataReq;
import com.baidu.carlife.platform.request.CLGetSongListReq;
import com.baidu.carlife.platform.response.CLGetAlbumListResp;
import com.baidu.carlife.platform.response.CLGetSongDataResp;
import com.baidu.carlife.platform.response.CLGetSongListResp;
import com.baidu.carlife.platform.service.C2018d.C2015a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CLSDKClient */
/* renamed from: com.baidu.carlife.platform.service.c */
public class C2017c implements C1999c, C2015a, C2016h {
    /* renamed from: e */
    private static final Object f6518e = new Object();
    /* renamed from: a */
    private RemoteCallbackList<C2016h> f6519a;
    /* renamed from: b */
    private String f6520b;
    /* renamed from: c */
    private C2002b f6521c;
    /* renamed from: d */
    private boolean f6522d;
    /* renamed from: f */
    private C2018d f6523f;

    public C2017c(String name) {
        this.f6519a = new RemoteCallbackList();
        this.f6522d = true;
        this.f6522d = false;
        this.f6520b = name;
        this.f6523f = C2018d.m7726a();
    }

    /* renamed from: a */
    public boolean m7722a(C2016h callback) {
        return this.f6519a.register(callback);
    }

    /* renamed from: a */
    public void m7718a(C2002b client) {
        this.f6521c = client;
        this.f6521c.m7639a((C1999c) this);
    }

    /* renamed from: a */
    public String m7715a() {
        return this.f6520b;
    }

    public IBinder asBinder() {
        return null;
    }

    /* renamed from: a */
    public void mo1755a(int errorNo, String errorMsg) throws RemoteException {
        if (this.f6519a != null) {
            int callbackCount = this.f6519a.beginBroadcast();
            for (int i = 0; i < callbackCount; i++) {
                ((C2016h) this.f6519a.getBroadcastItem(i)).mo1755a(errorNo, errorMsg);
            }
            this.f6519a.finishBroadcast();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m7712a(com.baidu.carlife.platform.response.CLGetSongDataResp r7) {
        /*
        r6 = this;
        r1 = f6518e;
        monitor-enter(r1);
        if (r7 == 0) goto L_0x0042;
    L_0x0005:
        r0 = r6.f6523f;	 Catch:{ all -> 0x0044 }
        if (r0 == 0) goto L_0x0042;
    L_0x0009:
        r0 = r7.songData;	 Catch:{ all -> 0x0044 }
        if (r0 == 0) goto L_0x0042;
    L_0x000d:
        r0 = r6.f6523f;	 Catch:{ all -> 0x0044 }
        r2 = r7.requestId;	 Catch:{ all -> 0x0044 }
        r0 = r0.m7737b(r2);	 Catch:{ all -> 0x0044 }
        if (r0 == 0) goto L_0x0042;
    L_0x0017:
        r0 = r7.errorNo;	 Catch:{ all -> 0x0044 }
        if (r0 == 0) goto L_0x001d;
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x0044 }
    L_0x001c:
        return;
    L_0x001d:
        r0 = r7.songData;	 Catch:{ all -> 0x0044 }
        r0 = r0.tag;	 Catch:{ all -> 0x0044 }
        switch(r0) {
            case 0: goto L_0x0047;
            case 1: goto L_0x0024;
            case 2: goto L_0x0064;
            default: goto L_0x0024;
        };	 Catch:{ all -> 0x0044 }
    L_0x0024:
        r0 = "CarLifePlatform";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0044 }
        r2.<init>();	 Catch:{ all -> 0x0044 }
        r3 = "songData.tag == ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0044 }
        r3 = r7.songData;	 Catch:{ all -> 0x0044 }
        r3 = r3.tag;	 Catch:{ all -> 0x0044 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x0044 }
        r2 = r2.toString();	 Catch:{ all -> 0x0044 }
        com.baidu.carlife.core.LogUtil.e(r0, r2);	 Catch:{ all -> 0x0044 }
    L_0x0042:
        monitor-exit(r1);	 Catch:{ all -> 0x0044 }
        goto L_0x001c;
    L_0x0044:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0044 }
        throw r0;
    L_0x0047:
        r0 = "CarLifePlatform";
        r2 = "songData.tag == CLSongData.TAG_START";
        com.baidu.carlife.core.LogUtil.d(r0, r2);	 Catch:{ all -> 0x0044 }
        r0 = r7.songData;	 Catch:{ all -> 0x0044 }
        r2 = r0.totalSize;	 Catch:{ all -> 0x0044 }
        r4 = 0;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x0042;
    L_0x005a:
        r0 = r6.f6523f;	 Catch:{ all -> 0x0044 }
        r2 = r7.songData;	 Catch:{ all -> 0x0044 }
        r2 = r2.totalSize;	 Catch:{ all -> 0x0044 }
        r0.m7733a(r2);	 Catch:{ all -> 0x0044 }
        goto L_0x0042;
    L_0x0064:
        r0 = "CarLifePlatform";
        r2 = "songData.tag == CLSongData.TAG_END";
        com.baidu.carlife.core.LogUtil.d(r0, r2);	 Catch:{ all -> 0x0044 }
        r0 = r6.f6523f;	 Catch:{ all -> 0x0044 }
        r2 = r6.f6520b;	 Catch:{ all -> 0x0044 }
        r0.m7734a(r2);	 Catch:{ all -> 0x0044 }
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.carlife.platform.service.c.a(com.baidu.carlife.platform.response.CLGetSongDataResp):void");
    }

    /* renamed from: a */
    public CLPackage mo1754a(CLPackage pack) {
        if (pack == null || pack.service <= 1 || pack.service > 5 || pack.type != 2) {
            return pack;
        }
        C2014b localClient = C2013a.m7695a().m7697b();
        int errorNo;
        String errorMsg;
        switch (pack.service) {
            case 2:
                CLGetSongListResp getSongListFromCarlifeResp = CLGetSongListResp.fromJson(pack.getDataInString());
                List<MusicSongModel> songList = new ArrayList();
                errorNo = 0;
                errorMsg = null;
                if (getSongListFromCarlifeResp == null) {
                    errorNo = 3;
                } else if (getSongListFromCarlifeResp.errorNo != 0) {
                    errorNo = getSongListFromCarlifeResp.errorNo;
                    errorMsg = getSongListFromCarlifeResp.errorMsg;
                } else if (getSongListFromCarlifeResp.songList != null) {
                    for (int i = 0; i < getSongListFromCarlifeResp.songList.size(); i++) {
                        CLSong song = (CLSong) getSongListFromCarlifeResp.songList.get(i);
                        if (song != null) {
                            songList.add(new MusicSongModel(song));
                        }
                    }
                }
                try {
                    localClient.mo1736a(errorNo, errorMsg, this.f6520b, getSongListFromCarlifeResp.songListId, songList, getSongListFromCarlifeResp.pn, getSongListFromCarlifeResp.rn, getSongListFromCarlifeResp.total);
                    return pack;
                } catch (Throwable e) {
                    LogUtil.m4432a("PlatformManager", e);
                    return pack;
                }
            case 3:
                m7712a(CLGetSongDataResp.fromJson(pack.getDataInString()));
                return pack;
            case 4:
                if (pack.getData() == null || pack.getDataLength() <= 0) {
                    return pack;
                }
                return m7713b(pack);
            case 5:
                CLGetAlbumListResp getAlbumListResp = CLGetAlbumListResp.fromJson(pack.getDataInString());
                errorNo = 0;
                errorMsg = null;
                if (getAlbumListResp == null) {
                    errorNo = 3;
                } else if (getAlbumListResp.errorNo != 0) {
                    errorNo = getAlbumListResp.errorNo;
                    errorMsg = getAlbumListResp.errorMsg;
                }
                try {
                    localClient.mo1737a(errorNo, errorMsg, this.f6520b, getAlbumListResp.albumList);
                    return pack;
                } catch (Throwable e2) {
                    LogUtil.m4432a("PlatformManager", e2);
                    return pack;
                }
            default:
                return pack;
        }
    }

    /* renamed from: b */
    public void m7723b() throws IllegalArgumentException {
        LogUtil.d("CarLifePlatform", "getAlbumList");
        CLGetAlbumListReq req = new CLGetAlbumListReq();
        CLPackage pack = new CLPackage();
        pack.type = 1;
        pack.service = 5;
        pack.setData(req.toJson());
        if (this.f6521c != null) {
            this.f6521c.m7640a(pack);
        }
    }

    /* renamed from: a */
    public void m7719a(String songListId, int pn, int rn) throws IllegalArgumentException {
        LogUtil.d("CarLifePlatform", "getSongList songListId=" + songListId);
        CLGetSongListReq req = new CLGetSongListReq();
        req.songListId = songListId;
        req.pn = pn;
        req.rn = rn;
        CLPackage pack = new CLPackage();
        pack.type = 1;
        pack.service = 2;
        pack.setData(req.toJson());
        if (this.f6521c != null) {
            this.f6521c.m7640a(pack);
        }
    }

    /* renamed from: a */
    public void m7720a(String songId, long totalSize) throws IllegalArgumentException {
        LogUtil.d("CarLifePlatform", "getSong songId=" + songId);
        CLGetSongDataReq req = new CLGetSongDataReq();
        req.songId = songId;
        CLPackage pack = new CLPackage();
        pack.type = 1;
        pack.service = 3;
        pack.setData(req.toJson());
        synchronized (f6518e) {
            if (this.f6523f != null) {
                this.f6523f.m7736b();
                this.f6523f.m7735a(this.f6520b, this, songId, totalSize, req.requestId);
            }
        }
        if (this.f6521c != null) {
            this.f6521c.m7640a(pack);
        }
    }

    /* renamed from: c */
    public void m7724c() {
        LogUtil.d("CarLifePlatform", "stopDownloadSong appName=" + this.f6520b);
        synchronized (f6518e) {
            if (this.f6523f != null) {
                this.f6523f.m7734a(this.f6520b);
            }
        }
    }

    /* renamed from: b */
    private CLPackage m7713b(CLPackage pack) {
        synchronized (f6518e) {
            if (this.f6523f != null) {
                pack = this.f6523f.m7731a(pack);
            }
        }
        return pack;
    }

    /* renamed from: a */
    public void mo1756a(int errorNo, String errorMsg, String songId, long downloadSize, long totalSize, boolean stop) {
        try {
            C2013a.m7695a().m7697b().mo1735a(errorNo, errorMsg, this.f6520b, songId, downloadSize, totalSize, stop);
        } catch (Throwable e) {
            LogUtil.m4432a("PlatformManager", e);
        }
    }

    /* renamed from: d */
    public void m7725d() {
        if (!this.f6522d) {
            this.f6522d = true;
            LogUtil.d("CarLifePlatform", "destroy appName=" + this.f6520b);
            this.f6519a = null;
            synchronized (f6518e) {
                if (this.f6523f != null) {
                    this.f6523f.m7734a(this.f6520b);
                    this.f6523f = null;
                }
            }
            if (this.f6521c != null) {
                this.f6521c.m7638a();
                this.f6521c = null;
            }
            C2013a.m7695a().m7702d(this.f6520b);
        }
    }

    /* renamed from: a */
    public void mo1757a(Thread thread, Exception e) {
        if (thread != null) {
            LogUtil.d("CarLifePlatform", "onThreadQuit() " + thread.getName());
        }
        m7725d();
    }
}
