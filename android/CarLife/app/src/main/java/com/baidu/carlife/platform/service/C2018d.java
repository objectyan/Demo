package com.baidu.carlife.platform.service;

import android.text.TextUtils;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.platform.communication.CLPackage;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: DownloadSongHelper */
/* renamed from: com.baidu.carlife.platform.service.d */
class C2018d {
    /* renamed from: a */
    private static C2018d f6524a = null;
    /* renamed from: b */
    private static final Object f6525b = new Object();
    /* renamed from: j */
    private static final int f6526j = 2;
    /* renamed from: c */
    private String f6527c;
    /* renamed from: d */
    private C2015a f6528d;
    /* renamed from: e */
    private RandomAccessFile f6529e;
    /* renamed from: f */
    private String f6530f;
    /* renamed from: g */
    private long f6531g;
    /* renamed from: h */
    private long f6532h;
    /* renamed from: i */
    private long f6533i;
    /* renamed from: k */
    private double f6534k;

    /* compiled from: DownloadSongHelper */
    /* renamed from: com.baidu.carlife.platform.service.d$a */
    public interface C2015a {
        /* renamed from: a */
        void mo1756a(int i, String str, String str2, long j, long j2, boolean z);
    }

    private C2018d() {
    }

    /* renamed from: a */
    public static C2018d m7726a() {
        if (f6524a == null) {
            synchronized (f6525b) {
                if (f6524a == null) {
                    f6524a = new C2018d();
                }
            }
        }
        return f6524a;
    }

    /* renamed from: a */
    public void m7733a(long totalSize) {
        this.f6531g = totalSize;
        if (this.f6529e != null && this.f6531g > 0) {
            try {
                this.f6529e.setLength(totalSize);
            } catch (Throwable e) {
                C1260i.m4432a("PlatformManager", e);
            }
        }
    }

    /* renamed from: b */
    public boolean m7737b(long requestId) {
        return requestId == this.f6532h;
    }

    /* renamed from: a */
    public void m7735a(String appName, C2015a listener, String songId, long totalSize, long requestId) {
        C1260i.m4435b("CarLifePlatform", "startDownloadSong() requestId=" + requestId + " totalSize=" + totalSize);
        this.f6527c = appName;
        this.f6528d = listener;
        this.f6530f = songId;
        this.f6531g = totalSize;
        this.f6532h = requestId;
        this.f6533i = 0;
        this.f6534k = 30000.0d;
        this.f6529e = m7727a(this.f6530f, this.f6531g);
        if (this.f6529e == null) {
            m7729a(this.f6530f, this.f6533i, this.f6531g, true);
            m7730c();
        }
    }

    /* renamed from: a */
    private RandomAccessFile m7727a(String songId, long totalSize) {
        Throwable e;
        String savePath = C1253f.jm + "/" + songId + ".mp3";
        File f = new File(savePath);
        if (f.exists()) {
            f.delete();
        }
        try {
            RandomAccessFile raf = new RandomAccessFile(savePath, "rwd");
            if (totalSize > 0) {
                try {
                    raf.setLength(totalSize);
                } catch (IOException e2) {
                    e = e2;
                    RandomAccessFile randomAccessFile = raf;
                    C1260i.m4432a("PlatformManager", e);
                    return null;
                }
            }
            return raf;
        } catch (IOException e3) {
            e = e3;
            C1260i.m4432a("PlatformManager", e);
            return null;
        }
    }

    /* renamed from: c */
    private void m7730c() {
        this.f6527c = null;
        this.f6528d = null;
        this.f6530f = null;
        this.f6531g = -1;
        this.f6532h = -1;
        this.f6533i = 0;
        if (this.f6529e != null) {
            try {
                this.f6529e.close();
            } catch (Throwable e) {
                C1260i.m4432a("PlatformManager", e);
            } finally {
                this.f6529e = null;
            }
        }
    }

    /* renamed from: a */
    public void m7734a(String appName) {
        if (!TextUtils.isEmpty(appName) && appName.equals(this.f6527c)) {
            m7732a(0, "");
        }
    }

    /* renamed from: b */
    public void m7736b() {
        m7732a(0, "");
    }

    /* renamed from: a */
    public void m7732a(int errorNo, String errorMsg) {
        C1260i.m4435b("CarLifePlatform", "stopDownloadSong() songId=" + this.f6530f + " appName=" + this.f6527c);
        m7728a(errorNo, errorMsg, this.f6530f, this.f6533i, this.f6531g, true);
        m7730c();
    }

    /* renamed from: a */
    public CLPackage m7731a(CLPackage pack) {
        if (!(pack == null || pack.dataId != this.f6532h || pack.getData() == null || pack.getDataLength() <= 0 || this.f6529e == null)) {
            try {
                this.f6529e.write(pack.getData(), 0, pack.length);
                this.f6533i += (long) pack.length;
                if (((double) this.f6533i) > this.f6534k) {
                    if (this.f6534k <= 120000.0d) {
                        this.f6534k *= 2.0d;
                    } else {
                        this.f6534k += 120000.0d;
                    }
                    m7729a(this.f6530f, this.f6533i, this.f6531g, false);
                }
                if (this.f6533i >= this.f6531g) {
                    m7729a(this.f6530f, this.f6533i, this.f6531g, true);
                    m7730c();
                }
            } catch (Throwable e) {
                C1260i.m4432a("PlatformManager", e);
                m7729a(this.f6530f, this.f6533i, this.f6531g, true);
                m7730c();
            }
        }
        return pack;
    }

    /* renamed from: a */
    private void m7729a(String songId, long downloadSize, long totalSize, boolean stop) {
        m7728a(0, "", songId, downloadSize, totalSize, stop);
    }

    /* renamed from: a */
    private void m7728a(int errorNo, String errorMsg, String songId, long downloadSize, long totalSize, boolean stop) {
        if (this.f6528d != null && songId != null) {
            this.f6528d.mo1756a(errorNo, errorMsg, songId, downloadSize, totalSize, stop);
        }
    }
}
