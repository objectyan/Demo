package com.baidu.location.indoor.p196a;

import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.location.C3377f;
import com.baidu.location.Jni;
import com.baidu.location.p187a.C3192e;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p191d.C3304i;
import com.baidu.location.p194f.C3376f;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.util.common.HttpsClient;
import com.baidu.platform.comapi.map.MapBundleKey.OfflineMapKey;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.baidu.location.indoor.a.a */
public class C3398a extends C3186e {
    /* renamed from: d */
    private static C3398a f18406d = null;
    /* renamed from: e */
    private static Object f18407e = new Object();
    /* renamed from: a */
    String f18408a = null;
    /* renamed from: b */
    String f18409b = null;
    /* renamed from: c */
    String f18410c = null;
    /* renamed from: f */
    private String f18411f = null;
    /* renamed from: p */
    private String f18412p = null;
    /* renamed from: q */
    private long f18413q = 0;
    /* renamed from: r */
    private String f18414r = null;
    /* renamed from: s */
    private Handler f18415s = null;
    /* renamed from: t */
    private int f18416t = -1;

    /* renamed from: com.baidu.location.indoor.a.a$1 */
    class C33951 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3398a f18403a;

        C33951(C3398a c3398a) {
            this.f18403a = c3398a;
        }

        public void run() {
            if (C3192e.m13329a().m13341d() == 0 && this.f18403a.f18414r != null) {
                this.f18403a.f18413q = System.currentTimeMillis();
                C3304i.m13904a().m13909b("tt", this.f18403a.f18413q);
                if (VERSION.SDK_INT >= 14) {
                    this.f18403a.m13299c("https://loc.map.baidu.com/cfgs/geomag/geomagloccfg");
                }
            }
        }
    }

    /* renamed from: com.baidu.location.indoor.a.a$2 */
    class C33962 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3398a f18404a;

        C33962(C3398a c3398a) {
            this.f18404a = c3398a;
        }

        public void run() {
            this.f18404a.m14470g();
        }
    }

    /* renamed from: com.baidu.location.indoor.a.a$3 */
    class C33973 extends Thread {
        /* renamed from: a */
        final /* synthetic */ C3398a f18405a;

        C33973(C3398a c3398a) {
            this.f18405a = c3398a;
        }

        public void run() {
            if (this.f18405a.m14471k()) {
                this.f18405a.m14472l();
            }
        }
    }

    public C3398a() {
        try {
            this.f18411f = C3304i.m13904a().m13907a("jar", null);
            this.f18412p = C3304i.m13904a().m13907a("so", null);
            this.f18413q = C3304i.m13904a().m13906a("tt", 0);
            this.f18414r = C3304i.m13904a().m13907a(NaviStatConstants.K_NSC_KEY_FINISHNAVI_CITY, null);
            this.f18416t = C3304i.m13904a().m13905a("enable", 1);
        } catch (Exception e) {
            this.f18411f = null;
            this.f18412p = null;
            this.f18413q = System.currentTimeMillis();
        }
    }

    /* renamed from: a */
    public static void m14462a(File file, File file2) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream = null;
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
    public static boolean m14463a(String str, String str2) {
        File file = new File(C3391g.m14456l() + File.separator + "tmplocdata");
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[4096];
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setReadTimeout(300000);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            httpURLConnection.disconnect();
            fileOutputStream.flush();
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
    public static C3398a m14465b() {
        C3398a c3398a;
        synchronized (f18407e) {
            if (f18406d == null) {
                f18406d = new C3398a();
            }
            c3398a = f18406d;
        }
        return c3398a;
    }

    /* renamed from: f */
    private boolean m14469f() {
        SensorManager sensorManager = (SensorManager) C3377f.getServiceContext().getSystemService("sensor");
        return (sensorManager.getDefaultSensor(4) == null || sensorManager.getDefaultSensor(1) == null || sensorManager.getDefaultSensor(2) == null) ? false : true;
    }

    /* renamed from: g */
    private void m14470g() {
        if (this.f18408a != null) {
            new C33973(this).start();
        }
    }

    /* renamed from: k */
    private boolean m14471k() {
        if (this.f18410c == null) {
            return true;
        }
        File file = new File(C3391g.m14456l() + File.separator + this.f18410c);
        if (!file.exists() && !C3398a.m14463a("http://" + this.f18408a + "/" + this.f18410c, this.f18410c)) {
            return false;
        }
        if (!file.exists()) {
            return false;
        }
        String a = C3391g.m14435a(file, "SHA-256");
        if (this.f18412p == null || a == null || !C3391g.m14443b(a, this.f18412p, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB")) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (Exception e) {
                }
            }
            return false;
        }
        File file2 = new File(C3391g.m14458n() + File.separator + "repiaso.so");
        if (file2.exists()) {
            file2.delete();
        }
        try {
            C3398a.m14462a(file, file2);
            return true;
        } catch (Exception e2) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (Exception e3) {
                    return false;
                }
            }
            if (file2 != null && file2.exists()) {
                file2.delete();
            }
            return false;
        }
    }

    /* renamed from: l */
    private boolean m14472l() {
        if (this.f18409b == null) {
            return true;
        }
        File file = new File(C3391g.m14456l() + File.separator + this.f18409b);
        if (!file.exists() && !C3398a.m14463a("http://" + this.f18408a + "/" + this.f18409b, this.f18409b)) {
            return false;
        }
        if (!file.exists()) {
            return false;
        }
        String a = C3391g.m14435a(file, "SHA-256");
        if (this.f18411f == null || a == null || !C3391g.m14443b(a, this.f18411f, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB")) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (Exception e) {
                }
            }
            return false;
        }
        File file2 = new File(C3391g.m14458n() + File.separator + "repiall.jar");
        if (file2.exists()) {
            file2.delete();
        }
        try {
            C3398a.m14462a(file, file2);
            return true;
        } catch (Exception e2) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (Exception e3) {
                    return false;
                }
            }
            if (file2 != null && file2.exists()) {
                file2.delete();
            }
            return false;
        }
    }

    /* renamed from: a */
    public void mo2494a() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&sdk=");
        stringBuffer.append(7.32f);
        stringBuffer.append("&fw=");
        stringBuffer.append(C3377f.getFrameVersion());
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
        stringBuffer.append("&pack=");
        stringBuffer.append(C3381b.f18311d);
        stringBuffer.append("&city=");
        stringBuffer.append(this.f18414r);
        str = null;
        File file = new File(C3391g.m14458n() + File.separator + "iaso.so");
        if (file.exists()) {
            str = C3391g.m14435a(file, "MD5");
        } else {
            file = new File(C3391g.m14458n() + File.separator + "repiaso.so");
            if (file.exists()) {
                str = C3391g.m14435a(file, "MD5");
            }
        }
        stringBuffer.append("&somd5=");
        stringBuffer.append(str);
        this.h = "http://loc.map.baidu.com/cfgs/geomag/geomagloccfg";
        if (this.k == null) {
            this.k = new HashMap();
        }
        if (this.k != null) {
            this.k.clear();
        }
        this.k.put("it", Jni.en1(stringBuffer.toString()));
    }

    /* renamed from: a */
    public void m14474a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f18414r = str;
            C3304i.m13904a().m13910b(NaviStatConstants.K_NSC_KEY_FINISHNAVI_CITY, this.f18414r);
        }
    }

    /* renamed from: a */
    public void mo2495a(boolean z) {
        if (z && this.j != null) {
            try {
                JSONObject jSONObject = new JSONObject(this.j);
                if (OfflineMapKey.OFFLINE_UPDATE.equals(jSONObject.getString("ret"))) {
                    this.f18408a = jSONObject.getString("upath");
                    if (jSONObject.has("u1")) {
                        this.f18409b = jSONObject.getString("u1");
                    }
                    if (jSONObject.has("u2")) {
                        this.f18410c = jSONObject.getString("u2");
                    }
                    if (jSONObject.has("u1_rsa")) {
                        this.f18411f = jSONObject.getString("u1_rsa");
                        C3304i.m13904a().m13910b("jar", this.f18411f);
                    }
                    if (jSONObject.has("u2_rsa")) {
                        this.f18412p = jSONObject.getString("u2_rsa");
                        C3304i.m13904a().m13910b("so", this.f18412p);
                    }
                    this.f18415s.post(new C33962(this));
                }
                if (jSONObject.has("ison")) {
                    this.f18416t = jSONObject.getInt("ison");
                    C3304i.m13904a().m13908b("enable", this.f18416t);
                }
                if (jSONObject.has("saron")) {
                    C3304i.m13904a().m13908b("saron", jSONObject.getInt("saron"));
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: c */
    public boolean mo2499c() {
        boolean z = true;
        if (this.f18416t != 1) {
            return false;
        }
        try {
            File file = new File(C3391g.m14458n() + File.separator + "repiaso.so");
            File file2 = new File(C3377f.getServiceContext().getFilesDir() + File.separator + "iaso.so");
            if (file != null && file.exists()) {
                String a = C3391g.m14435a(file, "SHA-256");
                if (this.f18412p == null || a == null || !C3391g.m14443b(a, this.f18412p, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB")) {
                    file.delete();
                } else {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    C3398a.m14462a(file, file2);
                }
            }
            String str = "Xywq2kG6dffoAjv04PWM3QMMECGCdrLBFFmp6xMqZQGUH4UE4Cv4c6NQthpl3y5s0RlPP3J80bPIOqzbwogMtei1Ax61yZDPuWbhxdByZKISkRsXvd0ALCPAcuz6xhwZZ+VQFoRlrm5cZeC9M2/LkS3H460Mg9fGys5zZMVoZLM=";
            if (this.f18412p == null || !this.f18412p.equals(str)) {
                z = false;
            }
            if (!file2.exists() || !r1) {
                return false;
            }
            return (this.f18412p == null || !C3391g.m14443b(C3391g.m14435a(file2, "SHA-256"), this.f18412p, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB")) ? false : m14477d();
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: d */
    public boolean m14477d() {
        try {
            System.load(C3377f.getServiceContext().getFileStreamPath("iaso.so").getAbsolutePath());
            return true;
        } catch (Error e) {
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: e */
    public void m14478e() {
        if (this.f18415s == null) {
            this.f18415s = new Handler();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f18413q;
        Object obj = (currentTimeMillis <= 86400000 || !C3376f.m14363j()) ? null : 1;
        if (currentTimeMillis > 86400000) {
            if (!(obj == null || m14469f())) {
                this.f18413q = System.currentTimeMillis();
                C3304i.m13904a().m13909b("tt", this.f18413q);
                obj = null;
            }
            if (obj != null && this.f18415s != null) {
                this.f18415s.postDelayed(new C33951(this), HttpsClient.CONN_MGR_TIMEOUT);
                return;
            }
        }
        this.f18413q = System.currentTimeMillis();
        C3304i.m13904a().m13909b("tt", this.f18413q);
        obj = null;
        if (obj != null) {
        }
    }
}
