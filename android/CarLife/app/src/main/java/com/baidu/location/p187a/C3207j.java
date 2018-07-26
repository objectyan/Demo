package com.baidu.location.p187a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import com.baidu.location.C3377f;
import com.baidu.location.Jni;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3382c;
import com.baidu.location.p188h.C3390f;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p193e.C3349d;
import com.baidu.location.p194f.C3364b;
import com.baidu.location.p194f.C3365c;
import com.baidu.location.p194f.C3376f;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.baidu.platform.comapi.map.MapBundleKey.OfflineMapKey;
import com.facebook.common.p141m.C2924g;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* renamed from: com.baidu.location.a.j */
public class C3207j extends C3186e {
    /* renamed from: p */
    private static C3207j f17434p = null;
    /* renamed from: a */
    String f17435a;
    /* renamed from: b */
    String f17436b;
    /* renamed from: c */
    String f17437c;
    /* renamed from: d */
    String f17438d;
    /* renamed from: e */
    int f17439e;
    /* renamed from: f */
    Handler f17440f;

    /* renamed from: com.baidu.location.a.j$1 */
    class C32031 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3207j f17430a;

        C32031(C3207j c3207j) {
            this.f17430a = c3207j;
        }

        public void run() {
            if (C3376f.m14363j() || this.f17430a.m13414a(C3377f.getServiceContext())) {
                this.f17430a.m13300h();
            }
        }
    }

    /* renamed from: com.baidu.location.a.j$2 */
    class C32042 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3207j f17431a;

        C32042(C3207j c3207j) {
            this.f17431a = c3207j;
        }

        public void run() {
            if (C3376f.m14363j()) {
                C3349d.m14171a().m14196n();
            }
        }
    }

    /* renamed from: com.baidu.location.a.j$3 */
    class C32053 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3207j f17432a;

        C32053(C3207j c3207j) {
            this.f17432a = c3207j;
        }

        public void run() {
            this.f17432a.m13422f();
        }
    }

    /* renamed from: com.baidu.location.a.j$4 */
    class C32064 extends Thread {
        /* renamed from: a */
        final /* synthetic */ C3207j f17433a;

        C32064(C3207j c3207j) {
            this.f17433a = c3207j;
        }

        public void run() {
            if (this.f17433a.m13423g()) {
                this.f17433a.m13424k();
            }
        }
    }

    private C3207j() {
        this.f17435a = null;
        this.f17436b = null;
        this.f17437c = null;
        this.f17438d = null;
        this.f17439e = 1;
        this.f17440f = null;
        this.f17440f = new Handler();
    }

    /* renamed from: a */
    public static void m13413a(File file, File file2) throws IOException {
        Throwable th;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION];
                while (true) {
                    int read = bufferedInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                }
                bufferedOutputStream.flush();
                file.delete();
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private boolean m13414a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                String a = C3365c.m14283a(C3364b.m14262a().m14279e());
                if (a.equals("3G") || a.equals("4G")) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m13416a(String str, String str2) {
        File file = new File(C3391g.m14456l() + File.separator + "tmp");
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[4096];
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            httpURLConnection.disconnect();
            fileOutputStream.close();
            bufferedInputStream.close();
            if (file.length() < 10240) {
                file.delete();
                return false;
            }
            file.renameTo(new File(C3391g.m14456l() + File.separator + str2));
            return true;
        } catch (Exception e) {
            file.delete();
            return false;
        }
    }

    /* renamed from: b */
    public static C3207j m13417b() {
        if (f17434p == null) {
            f17434p = new C3207j();
        }
        return f17434p;
    }

    /* renamed from: d */
    private Handler m13420d() {
        return this.f17440f;
    }

    /* renamed from: e */
    private void m13421e() {
        try {
            RandomAccessFile randomAccessFile;
            File file = new File(C3391g.m14456l() + "/grtcfrsa.dat");
            if (!file.exists()) {
                File file2 = new File(C3390f.f18346a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (file.createNewFile()) {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(2);
                    randomAccessFile.writeInt(0);
                    randomAccessFile.seek(8);
                    byte[] bytes = "1980_01_01:0".getBytes();
                    randomAccessFile.writeInt(bytes.length);
                    randomAccessFile.write(bytes);
                    randomAccessFile.seek(200);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.seek(800);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.close();
                } else {
                    return;
                }
            }
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(200);
            randomAccessFile.writeBoolean(true);
            if (this.f17439e == 1) {
                randomAccessFile.writeBoolean(true);
            } else {
                randomAccessFile.writeBoolean(false);
            }
            if (this.f17438d != null) {
                byte[] bytes2 = this.f17438d.getBytes();
                randomAccessFile.writeInt(bytes2.length);
                randomAccessFile.write(bytes2);
            } else if (Math.abs(C3377f.getFrameVersion() - 7.32f) < 1.0E-8f) {
                randomAccessFile.writeInt(0);
            }
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    /* renamed from: f */
    private void m13422f() {
        if (this.f17435a != null) {
            new C32064(this).start();
        }
    }

    /* renamed from: g */
    private boolean m13423g() {
        return (this.f17437c == null || new File(C3391g.m14456l() + File.separator + this.f17437c).exists()) ? true : C3207j.m13416a("http://" + this.f17435a + "/" + this.f17437c, this.f17437c);
    }

    /* renamed from: k */
    private void m13424k() {
        if (this.f17436b != null) {
            File file = new File(C3391g.m14456l() + File.separator + this.f17436b);
            if (!file.exists() && C3207j.m13416a("http://" + this.f17435a + "/" + this.f17436b, this.f17436b)) {
                String a = C3391g.m14435a(file, "SHA-256");
                if (this.f17438d != null && a != null && C3391g.m14443b(a, this.f17438d, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB")) {
                    File file2 = new File(C3391g.m14456l() + File.separator + C3377f.replaceFileName);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    try {
                        C3207j.m13413a(file, file2);
                    } catch (Exception e) {
                        file2.delete();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo2494a() {
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&sdk=");
        stringBuffer.append(7.32f);
        stringBuffer.append("&fw=");
        stringBuffer.append(C3377f.getFrameVersion());
        stringBuffer.append("&suit=");
        stringBuffer.append(1);
        if (C3381b.m14398a().f18317b == null) {
            stringBuffer.append("&im=");
            stringBuffer.append(C3381b.m14398a().f18316a);
        } else {
            stringBuffer.append("&cu=");
            stringBuffer.append(C3381b.m14398a().f18317b);
        }
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&sv=");
        String str = VERSION.RELEASE;
        if (str != null && str.length() > 10) {
            str = str.substring(0, 10);
        }
        stringBuffer.append(str);
        try {
            if (VERSION.SDK_INT > 20) {
                String[] strArr = Build.SUPPORTED_ABIS;
                str = null;
                while (i < strArr.length) {
                    str = i == 0 ? strArr[i] + ";" : str + strArr[i] + ";";
                    i++;
                }
            } else {
                str = Build.CPU_ABI2;
            }
        } catch (Error e) {
            str = null;
        } catch (Exception e2) {
            str = null;
        }
        if (str != null) {
            stringBuffer.append("&cpuabi=");
            stringBuffer.append(str);
        }
        stringBuffer.append("&pack=");
        stringBuffer.append(C3381b.f18311d);
        this.h = C3391g.m14450f() + "?&it=" + Jni.en1(stringBuffer.toString());
    }

    /* renamed from: a */
    public void mo2495a(boolean z) {
        if (z) {
            try {
                JSONObject jSONObject = new JSONObject(this.j);
                if (OfflineMapKey.OFFLINE_UPDATE.equals(jSONObject.getString(C2924g.f12892f))) {
                    this.f17435a = jSONObject.getString("upath");
                    if (jSONObject.has("u1")) {
                        this.f17436b = jSONObject.getString("u1");
                    }
                    if (jSONObject.has("u2")) {
                        this.f17437c = jSONObject.getString("u2");
                    }
                    if (jSONObject.has("u1_rsa")) {
                        this.f17438d = jSONObject.getString("u1_rsa");
                    }
                    m13420d().post(new C32053(this));
                }
                if (jSONObject.has("ison")) {
                    this.f17439e = jSONObject.getInt("ison");
                }
                m13421e();
            } catch (Exception e) {
            }
        }
        C3382c.m14410a().m14412a(System.currentTimeMillis());
    }

    /* renamed from: c */
    public void mo2499c() {
        if (System.currentTimeMillis() - C3382c.m14410a().m14413b() > 86400000) {
            m13420d().postDelayed(new C32031(this), BNOffScreenParams.MIN_ENTER_INTERVAL);
            m13420d().postDelayed(new C32042(this), Config.BPLUS_DELAY_TIME);
        }
    }
}
