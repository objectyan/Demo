package com.baidu.carlife.logic;

import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.util.C2186p;
import com.baidu.carlife.util.C2188r;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SkinPackageManager */
/* renamed from: com.baidu.carlife.logic.t */
public class C1872t {
    /* renamed from: a */
    public static final String f5804a = C1872t.class.getSimpleName();
    /* renamed from: b */
    public static final String f5805b = "DefaultSkin";
    /* renamed from: c */
    public static final int f5806c = -1;
    /* renamed from: d */
    public static final String f5807d = "com.baidu.carlife.skin";
    /* renamed from: e */
    public static final String f5808e = ".cls";
    /* renamed from: f */
    private static final String f5809f = "CurrentSkinName";
    /* renamed from: g */
    private static C1872t f5810g;
    /* renamed from: h */
    private List<C1318b> f5811h = new ArrayList();
    /* renamed from: i */
    private CarlifeActivity f5812i;
    /* renamed from: j */
    private String f5813j;
    /* renamed from: k */
    private boolean f5814k;

    /* compiled from: SkinPackageManager */
    /* renamed from: com.baidu.carlife.logic.t$b */
    public interface C1318b {
        /* renamed from: b */
        void mo1481b(boolean z);
    }

    /* compiled from: SkinPackageManager */
    /* renamed from: com.baidu.carlife.logic.t$a */
    private class C1871a extends AsyncTask<Void, Void, Resources> {
        /* renamed from: a */
        final /* synthetic */ C1872t f5799a;
        /* renamed from: b */
        private File f5800b;
        /* renamed from: c */
        private String f5801c;
        /* renamed from: d */
        private InputStream f5802d;
        /* renamed from: e */
        private int f5803e;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m7133a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m7134a((Resources) obj);
        }

        C1871a(C1872t c1872t, InputStream rawIn, String skinName, int versionCode) {
            this.f5799a = c1872t;
            this.f5802d = rawIn;
            this.f5801c = skinName;
            this.f5803e = versionCode;
        }

        /* renamed from: a */
        protected Resources m7133a(Void... params) {
            this.f5801c = null;
            if (this.f5799a.f5812i == null || this.f5802d == null || this.f5801c == null || !this.f5801c.contains(C1872t.f5808e)) {
                return null;
            }
            this.f5800b = this.f5799a.m7144b(this.f5802d, this.f5801c, this.f5803e);
            if (this.f5800b == null) {
                return null;
            }
            try {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                assetManager.getClass().getMethod("addAssetPath", new Class[]{String.class}).invoke(assetManager, new Object[]{this.f5800b.getAbsolutePath()});
                Resources superRes = this.f5799a.f5812i.getResources();
                return new Resources(assetManager, superRes.getDisplayMetrics(), superRes.getConfiguration());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /* renamed from: a */
        protected void m7134a(Resources result) {
            super.onPostExecute(result);
            if (this.f5802d != null) {
                try {
                    this.f5802d.close();
                } catch (IOException e) {
                }
            }
            if (result != null) {
                C2188r.m8329a().clear();
                C2188r.m8330a(result);
                this.f5799a.m7149g(this.f5800b.getName());
                this.f5799a.m7142a(true);
            } else if (this.f5799a.f5814k) {
                this.f5799a.m7149g(C1872t.f5805b);
                this.f5799a.m7142a(true);
            } else {
                this.f5799a.m7142a(false);
            }
            C1260i.m4434b(C1872t.f5804a);
        }
    }

    /* renamed from: a */
    public static C1872t m7136a() {
        if (f5810g == null) {
            f5810g = new C1872t();
        }
        return f5810g;
    }

    /* renamed from: a */
    public void m7150a(CarlifeActivity activity) {
        this.f5812i = activity;
        this.f5813j = BaiduNaviApplication.getInstance().getFilesDir().getAbsolutePath() + File.separator + "skin";
        File directory = new File(this.f5813j);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        String currentName = m7159c();
        if (m7147e(currentName)) {
            m7149g(f5805b);
            File deprecatedSkin = new File(this.f5813j + File.separator + currentName);
            if (deprecatedSkin.exists()) {
                deprecatedSkin.delete();
            }
        }
        currentName = m7159c();
        InputStream rawIn = null;
        if (m7146d(currentName)) {
            try {
                rawIn = activity.getResources().getAssets().open(currentName);
            } catch (IOException e) {
            }
        } else {
            File rawFile = new File(this.f5813j + File.separator + currentName);
            if (rawFile.isFile()) {
                try {
                    rawIn = new FileInputStream(rawFile);
                } catch (FileNotFoundException e2) {
                }
            }
        }
        m7141a(rawIn, currentName, m7148f(currentName), true);
    }

    /* renamed from: d */
    private boolean m7146d(String currentName) {
        if (C1253f.jk.equals(currentName)) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    private boolean m7147e(String currentName) {
        if ("CLS_Black.cls".equals(currentName)) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    private int m7148f(String currentName) {
        if (C1253f.jk.equals(currentName)) {
            return 3;
        }
        return -1;
    }

    /* renamed from: b */
    public String m7157b() {
        return this.f5813j;
    }

    /* renamed from: a */
    public void m7152a(File rawFile, int versionCode) {
        InputStream inputStream;
        FileNotFoundException e;
        try {
            InputStream rawIn = new FileInputStream(rawFile);
            try {
                m7144b(rawIn, rawFile.getName(), versionCode);
                if (rawIn != null) {
                    try {
                        rawIn.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                inputStream = rawIn;
            } catch (FileNotFoundException e3) {
                e = e3;
                inputStream = rawIn;
                e.printStackTrace();
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public boolean m7155a(String skinName) {
        File[] skinFiles = new File(this.f5813j).listFiles();
        if (skinFiles != null) {
            for (File name : skinFiles) {
                if (name.getName().equals(skinName)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public String m7159c() {
        return C2186p.m8304a().m8309a(f5809f, f5805b);
    }

    /* renamed from: g */
    private void m7149g(String skinName) {
        if (skinName != null) {
            C2186p.m8304a().m8319b(f5809f, skinName);
        }
    }

    /* renamed from: a */
    private void m7141a(InputStream rawIn, String skinName, int versionCode, boolean initFlag) {
        this.f5814k = initFlag;
        new C1871a(this, rawIn, skinName, versionCode).execute(new Void[0]);
    }

    /* renamed from: a */
    public void m7154a(String skinName, int versionCode) {
        InputStream rawIn = null;
        try {
            rawIn = new FileInputStream(new File(this.f5813j + File.separator + skinName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        m7141a(rawIn, skinName, versionCode, false);
    }

    /* renamed from: a */
    public void m7153a(InputStream rawIn, String skinName, int versionCode) {
        m7141a(rawIn, skinName, versionCode, false);
    }

    /* renamed from: a */
    public void m7151a(C1318b skinListener) {
        if (skinListener != null && !this.f5811h.contains(skinListener)) {
            this.f5811h.add(skinListener);
        }
    }

    /* renamed from: b */
    public void m7158b(C1318b skinListener) {
        if (this.f5811h.contains(skinListener)) {
            this.f5811h.remove(skinListener);
        }
    }

    /* renamed from: d */
    public void m7161d() {
        m7149g(f5805b);
        C2188r.m8332b();
        m7142a(true);
    }

    /* renamed from: b */
    public int m7156b(String skinName) {
        if (!(TextUtils.isEmpty(skinName) || f5805b.equals(skinName))) {
            File skinFile = new File(this.f5813j + File.separator + skinName);
            if (skinFile.exists()) {
                PackageInfo info = this.f5812i.getPackageManager().getPackageArchiveInfo(skinFile.getAbsolutePath(), 1);
                if (info != null && f5807d.equals(info.packageName)) {
                    return info.versionCode;
                }
            }
        }
        return -1;
    }

    /* renamed from: c */
    public void m7160c(String testSkinName) {
        if (!TextUtils.isEmpty(testSkinName)) {
            File skinFile = new File(this.f5813j + File.separator + testSkinName);
            if (skinFile.exists()) {
                skinFile.delete();
            }
        }
    }

    /* renamed from: a */
    private void m7142a(boolean isSuccess) {
        for (C1318b listener : this.f5811h) {
            listener.mo1481b(isSuccess);
        }
    }

    /* renamed from: b */
    private File m7144b(InputStream rawIn, String skinName, int versionCode) {
        if (rawIn == null || TextUtils.isEmpty(skinName)) {
            return null;
        }
        File skinFile = new File(this.f5813j + File.separator + skinName);
        int temp = m7156b(skinName);
        C1260i.m4435b(f5804a, "data皮肤包:" + skinName + ",版本号:" + temp);
        if (versionCode > temp) {
            C1260i.m4435b(f5804a, "data皮肤包:" + skinName + ",升级为版本:" + versionCode);
            m7140a(skinFile);
        }
        if (!skinFile.exists()) {
            try {
                skinFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        if (skinFile.length() >= 1 || m7143a(rawIn, skinFile)) {
            return skinFile;
        }
        m7140a(skinFile);
        return null;
    }

    /* renamed from: a */
    private boolean m7143a(InputStream rawIn, File skinFile) {
        Throwable th;
        FileOutputStream out = null;
        try {
            FileOutputStream out2 = new FileOutputStream(skinFile);
            try {
                byte[] buf = new byte[1024];
                while (true) {
                    int length = rawIn.read(buf);
                    if (length == -1) {
                        break;
                    }
                    out2.write(buf, 0, length);
                }
                out2.flush();
                if (out2 != null) {
                    try {
                        out2.close();
                    } catch (IOException e) {
                        out = out2;
                        return false;
                    }
                }
                C1260i.m4435b(f5804a, "写入本地皮肤:" + skinFile.getName());
                out = out2;
                return true;
            } catch (IOException e2) {
                out = out2;
                if (out != null) {
                    return false;
                }
                try {
                    out.close();
                    return false;
                } catch (IOException e3) {
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                out = out2;
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e4) {
                        return false;
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            if (out != null) {
                return false;
            }
            out.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            if (out != null) {
                out.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private void m7140a(File file) {
        if (file != null && file.exists()) {
            file.delete();
        }
    }
}
