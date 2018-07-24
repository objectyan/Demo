package com.baidu.carlife.p054k.p055a;

import android.content.Context;
import android.os.Environment;
import com.baidu.carlife.BaiduNaviApplication;
import java.io.File;

/* compiled from: NetWorkDownloadRequest */
/* renamed from: com.baidu.carlife.k.a.h */
public class C1635h {
    /* renamed from: a */
    public static final String f5024a = C1635h.class.getSimpleName();
    /* renamed from: b */
    private C1489c f5025b;
    /* renamed from: c */
    private C1632g f5026c;
    /* renamed from: d */
    private C1638i f5027d;
    /* renamed from: e */
    private String f5028e;
    /* renamed from: f */
    private Context f5029f;

    /* compiled from: NetWorkDownloadRequest */
    /* renamed from: com.baidu.carlife.k.a.h$c */
    public interface C1489c {
        /* renamed from: a */
        void mo1560a(long j, int i);

        /* renamed from: a */
        void mo1561a(C1634b c1634b, C1633a c1633a);
    }

    /* compiled from: NetWorkDownloadRequest */
    /* renamed from: com.baidu.carlife.k.a.h$a */
    public enum C1633a {
        NO_ERROR,
        ERROR_NONETWORK,
        ERROR_SDCARD_UNUSE,
        ERROR_MAKE_FILE,
        ERROR_HTTP
    }

    /* compiled from: NetWorkDownloadRequest */
    /* renamed from: com.baidu.carlife.k.a.h$b */
    public enum C1634b {
        WAITING,
        START,
        LOADING,
        CANCEL,
        SUCESS,
        ERROR
    }

    public C1635h(String downloadUrl, String fileName, C1489c callback) {
        this(null, downloadUrl, fileName, null, callback, true, 0);
    }

    public C1635h(Context context, String downloadUrl, String fileName, String directoryPath, C1489c callback, boolean isReLoad, int priority) {
        this.f5026c = new C1632g();
        this.f5026c.f5010g = isReLoad;
        this.f5026c.f5006c = downloadUrl;
        this.f5026c.f5007d = fileName;
        this.f5026c.f5005b = priority;
        this.f5028e = directoryPath;
        this.f5025b = callback;
        this.f5029f = context;
        if (this.f5029f == null) {
            this.f5029f = BaiduNaviApplication.getInstance();
        }
    }

    /* renamed from: a */
    public void m5920a(long size) {
        if (this.f5026c != null) {
            this.f5026c.f5009f = size;
        }
    }

    /* renamed from: a */
    public void m5921a(C1489c callBack) {
        this.f5025b = callBack;
        if (this.f5027d != null) {
            this.f5027d.m5936a(callBack);
        }
    }

    /* renamed from: a */
    public void m5919a() {
        this.f5025b = null;
        if (this.f5027d != null) {
            this.f5027d.m5935a();
        }
    }

    /* renamed from: b */
    public File m5922b() {
        if (this.f5027d != null) {
            return this.f5027d.m5937b();
        }
        return null;
    }

    /* renamed from: c */
    public static String m5918c() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return Environment.getExternalStorageDirectory().toString() + File.separator + "BaiduCarlife" + File.separator + C1638i.f5033a + File.separator;
        }
        return null;
    }

    /* renamed from: d */
    public void m5923d() {
        if (this.f5027d != null) {
            this.f5027d.m5940e();
        }
    }

    /* renamed from: e */
    public void m5924e() {
        this.f5027d = new C1638i(this.f5029f, this.f5026c, this.f5025b, this.f5028e);
        C1639j.m5944a().m5945a(this.f5027d);
    }
}
