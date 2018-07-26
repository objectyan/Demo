package com.baidu.location.indoor.p197b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import com.baidu.location.C3377f;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3391g;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.ParamKey;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.baidu.location.indoor.b.a */
final class C3409a extends C3186e {
    /* renamed from: p */
    private static C3409a f18463p = null;
    /* renamed from: a */
    private String f18464a;
    /* renamed from: b */
    private String f18465b;
    /* renamed from: c */
    private String f18466c;
    /* renamed from: d */
    private String f18467d;
    /* renamed from: e */
    private SharedPreferences f18468e;
    /* renamed from: f */
    private Handler f18469f;

    /* renamed from: com.baidu.location.indoor.b.a$1 */
    class C34071 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3409a f18461a;

        C34071(C3409a c3409a) {
            this.f18461a = c3409a;
        }

        public void run() {
            this.f18461a.m13301i();
        }
    }

    /* renamed from: com.baidu.location.indoor.b.a$2 */
    class C34082 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3409a f18462a;

        C34082(C3409a c3409a) {
            this.f18462a = c3409a;
        }

        public void run() {
            this.f18462a.m14532e();
        }
    }

    private C3409a() {
        this.f18464a = null;
        this.f18469f = null;
        this.f18469f = new Handler();
        this.k = new HashMap();
    }

    /* renamed from: a */
    private boolean m14529a(String str, String str2) {
        File file = new File(str2);
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
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    httpURLConnection.disconnect();
                    fileOutputStream.close();
                    bufferedInputStream.close();
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: b */
    static C3409a m14530b() {
        if (f18463p == null) {
            f18463p = new C3409a();
        }
        return f18463p;
    }

    /* renamed from: d */
    private Handler m14531d() {
        return this.f18469f;
    }

    /* renamed from: e */
    private boolean m14532e() {
        if (this.f18466c == null || this.f18464a == null) {
            return false;
        }
        String str = C3391g.m14456l() + File.separator + "download" + File.separator + this.f18464a;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!m14529a(this.f18466c, str + File.separator + "data.zip")) {
            return false;
        }
        file = new File(C3391g.m14456l() + File.separator + "indoorinfo" + File.separator + this.f18464a + "/");
        if (file.exists()) {
            file.delete();
            file.mkdirs();
        } else {
            file.mkdirs();
        }
        try {
            new C3416d().m14594a(str + File.separator + "data.zip", C3391g.m14456l() + File.separator + "indoorinfo" + File.separator + this.f18464a + "/");
            Editor edit = this.f18468e.edit();
            edit.putString("indoor_roadnet_" + this.f18464a, this.f18467d);
            edit.commit();
            C3414b.m14575a().m14589b();
            return true;
        } catch (Exception e) {
            file.delete();
            return false;
        }
    }

    /* renamed from: a */
    public void mo2494a() {
        this.k.clear();
        this.k.put("bldg", this.f18464a);
        this.k.put("vernum", this.f18465b);
        this.k.put("mb", Build.MODEL);
        this.k.put("cuid", C3381b.m14398a().f18317b);
        this.h = "http://loc.map.baidu.com/apigetindoordata.php";
    }

    /* renamed from: a */
    void m14534a(String str) {
        this.f18468e = PreferenceManager.getDefaultSharedPreferences(C3377f.getServiceContext());
        this.f18464a = str;
        this.f18465b = this.f18468e.getString("indoor_roadnet_" + str, "null");
        m14531d().postDelayed(new C34071(this), 1000);
    }

    /* renamed from: a */
    public void mo2495a(boolean z) {
        if (z) {
            try {
                JSONObject jSONObject = new JSONObject(this.j);
                int i = jSONObject.getInt(ParamKey.KEY_MSG_ERRORS);
                if (i == 0) {
                    this.f18466c = jSONObject.getString("downloadlink");
                    if (jSONObject.has("vernum")) {
                        this.f18467d = jSONObject.getString("vernum");
                    }
                    m14531d().post(new C34082(this));
                }
                if (i == 1) {
                    C3414b.m14575a().m14589b();
                }
                if (i == -1 || i != -2) {
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: c */
    void mo2499c() {
        Editor edit = this.f18468e.edit();
        edit.putString("indoor_roadnet_" + this.f18464a, "0");
        edit.commit();
    }
}
