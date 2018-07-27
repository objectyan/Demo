package com.baidu.carlife.util;

import android.os.Environment;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.LogUtil;
import java.io.File;

/* compiled from: CarlifeFile */
/* renamed from: com.baidu.carlife.util.d */
public class C2173d {
    /* renamed from: a */
    private static final String f6924a = "CarlifeFile";
    /* renamed from: b */
    private static final String f6925b = "BaiduCarlife";
    /* renamed from: c */
    private static final String f6926c = "bnav";
    /* renamed from: d */
    private static final String f6927d = "public.der";
    /* renamed from: e */
    private static final String f6928e = "NetWorkDownload";
    /* renamed from: f */
    private static final String f6929f = "music";
    /* renamed from: g */
    private static final String f6930g = "keyboard";
    /* renamed from: h */
    private static final String f6931h = "debugAudioData";
    /* renamed from: i */
    private static final String f6932i = "debugLog";
    /* renamed from: j */
    private static final String f6933j = "vehicle";
    /* renamed from: k */
    private static final String f6934k = "keyboardlib_v4.sqlite";
    /* renamed from: n */
    private static C2173d f6935n = new C2173d();
    /* renamed from: l */
    private File f6936l = new File(m8226m(), "BaiduCarlife");
    /* renamed from: m */
    private File f6937m;

    private C2173d() {
        if (!this.f6936l.exists()) {
            this.f6936l.mkdir();
        }
        this.f6937m = new File(this.f6936l, f6926c);
        LogUtil.d(f6924a, "mCarLifeRootDir=" + this.f6936l + ", mCarLifeNaviDir=" + this.f6937m);
    }

    /* renamed from: a */
    public static C2173d m8225a() {
        return f6935n;
    }

    /* renamed from: m */
    private File m8226m() {
        try {
            File rootDir;
            if (Environment.getExternalStorageState().equals("mounted")) {
                rootDir = Environment.getExternalStorageDirectory();
            } else {
                rootDir = AppContext.m3876a().getFilesDir();
            }
            return rootDir;
        } catch (Exception e) {
            LogUtil.e(f6924a, "Get SD Path Failed");
            return null;
        }
    }

    /* renamed from: b */
    public File m8228b() {
        return AppContext.m3876a().getDir("h5_database", 0);
    }

    /* renamed from: c */
    public File m8229c() {
        return AppContext.m3876a().getDir("h5_cache", 0);
    }

    /* renamed from: d */
    public File m8230d() {
        return this.f6936l;
    }

    /* renamed from: e */
    public File m8231e() {
        return this.f6937m;
    }

    /* renamed from: a */
    public File m8227a(String fileName) {
        return new File(this.f6936l, fileName);
    }

    /* renamed from: f */
    public File m8232f() {
        return m8227a(f6927d);
    }

    /* renamed from: g */
    public File m8233g() {
        return m8227a("NetWorkDownload");
    }

    /* renamed from: h */
    public File m8234h() {
        return m8227a(f6930g);
    }

    /* renamed from: i */
    public File m8235i() {
        File dir = m8234h();
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return new File(dir, "keyboardlib_v4.sqlite");
    }

    /* renamed from: j */
    public File m8236j() {
        return m8227a(f6931h);
    }

    /* renamed from: k */
    public File m8237k() {
        return m8227a(f6932i);
    }

    /* renamed from: l */
    public File m8238l() {
        return m8227a(f6933j);
    }
}
