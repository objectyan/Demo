package com.baidu.location.p191d.p192a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import com.baidu.android.bbalbs.common.security.Base64;
import com.baidu.location.C3377f;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3391g;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.location.d.a.f */
public class C3274f {
    /* renamed from: a */
    private static Object f17769a = new Object();
    /* renamed from: b */
    private static C3274f f17770b = null;
    /* renamed from: c */
    private SharedPreferences f17771c = null;
    /* renamed from: d */
    private String f17772d = null;
    /* renamed from: e */
    private String f17773e = null;
    /* renamed from: f */
    private C3271b f17774f = null;
    /* renamed from: g */
    private String f17775g = "0";
    /* renamed from: h */
    private int f17776h = 1;

    /* renamed from: com.baidu.location.d.a.f$a */
    public class C3270a {
        /* renamed from: a */
        public int f17751a = 0;
        /* renamed from: b */
        public List<C3272c> f17752b = new ArrayList();
        /* renamed from: c */
        public int f17753c = 1;
        /* renamed from: d */
        public int f17754d = 1;
        /* renamed from: e */
        public int f17755e = 15;
        /* renamed from: f */
        public int f17756f = 10;
        /* renamed from: g */
        public double f17757g = 0.699999988079071d;
        /* renamed from: h */
        public double f17758h = 0.05000000074505806d;
        /* renamed from: i */
        final /* synthetic */ C3274f f17759i;

        C3270a(C3274f c3274f, boolean z) {
            this.f17759i = c3274f;
            if (z && this.f17752b.isEmpty()) {
                this.f17752b.add(new C3272c(c3274f, 11, 13));
                this.f17752b.add(new C3272c(c3274f, 17, 19));
            }
        }

        /* renamed from: a */
        public void m13688a() {
        }

        /* renamed from: a */
        public boolean m13689a(JSONObject jSONObject) {
            try {
                if (jSONObject.has("level")) {
                    this.f17751a = jSONObject.getInt("level");
                }
                if (jSONObject.has("electricity_uplimit")) {
                    this.f17757g = jSONObject.getDouble("electricity_uplimit");
                }
                if (jSONObject.has("electricity_downlimit")) {
                    this.f17758h = jSONObject.getDouble("electricity_downlimit");
                }
                if (jSONObject.has("collect_times_limit")) {
                    this.f17753c = jSONObject.getInt("collect_times_limit");
                    if (this.f17753c > this.f17759i.f17776h) {
                        this.f17759i.f17776h = this.f17753c;
                    }
                }
                if (jSONObject.has("trace_duration")) {
                    this.f17754d = jSONObject.getInt("trace_duration");
                }
                if (jSONObject.has("stop_check_window")) {
                    this.f17755e = jSONObject.getInt("stop_check_window");
                }
                if (jSONObject.has("area_check_interval")) {
                    this.f17756f = jSONObject.getInt("area_check_interval");
                }
                if (jSONObject.has("alowed_time_slots")) {
                    try {
                        JSONArray jSONArray = jSONObject.getJSONArray("alowed_time_slots");
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            String[] split = jSONArray.getString(i).split("-");
                            if (split.length == 2) {
                                this.f17752b.add(new C3272c(this.f17759i, Integer.parseInt(split[0]), Integer.parseInt(split[1])));
                            }
                        }
                    } catch (Exception e) {
                        return false;
                    }
                }
                m13688a();
                return true;
            } catch (Exception e2) {
                return false;
            }
        }
    }

    /* renamed from: com.baidu.location.d.a.f$b */
    public class C3271b {
        /* renamed from: a */
        public Map<String, C3270a> f17760a = null;
        /* renamed from: b */
        public int f17761b = 0;
        /* renamed from: c */
        public Map<String, String> f17762c = new HashMap();
        /* renamed from: d */
        final /* synthetic */ C3274f f17763d;

        C3271b(C3274f c3274f, String str) {
            this.f17763d = c3274f;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("result")) {
                    JSONArray jSONArray;
                    int length;
                    int i;
                    JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                    if (jSONObject2.has("version")) {
                        this.f17761b = jSONObject2.getInt("version");
                    }
                    if (jSONObject2.has("collect_conf")) {
                        jSONArray = jSONObject2.getJSONArray("collect_conf");
                        length = jSONArray.length();
                        for (i = 0; i < length; i++) {
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                            C3270a c3270a = new C3270a(c3274f, false);
                            if (c3270a.m13689a(jSONObject3)) {
                                if (this.f17760a == null) {
                                    this.f17760a = new HashMap();
                                }
                                this.f17760a.put("" + c3270a.f17751a, c3270a);
                            }
                        }
                    }
                    if (jSONObject2.has("celllist_to_conf")) {
                        jSONArray = jSONObject2.getJSONArray("celllist_to_conf");
                        length = jSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            jSONObject = jSONArray.getJSONObject(i2);
                            if (jSONObject.has("level") && jSONObject.has("cell_list")) {
                                String string = jSONObject.getString("level");
                                JSONArray jSONArray2 = jSONObject.getJSONArray("cell_list");
                                int length2 = jSONArray2.length();
                                for (i = 0; i < length2; i++) {
                                    this.f17762c.put(jSONArray2.getString(i), string);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                this.f17761b = 0;
            }
        }
    }

    /* renamed from: com.baidu.location.d.a.f$c */
    public class C3272c {
        /* renamed from: a */
        public final int f17764a;
        /* renamed from: b */
        public final int f17765b;
        /* renamed from: c */
        final /* synthetic */ C3274f f17766c;

        C3272c(C3274f c3274f, int i, int i2) {
            this.f17766c = c3274f;
            this.f17764a = i;
            this.f17765b = i2;
            m13690a();
        }

        /* renamed from: a */
        private void m13690a() {
        }
    }

    /* renamed from: com.baidu.location.d.a.f$d */
    private class C3273d extends C3186e {
        /* renamed from: a */
        String f17767a;
        /* renamed from: b */
        final /* synthetic */ C3274f f17768b;

        private C3273d(C3274f c3274f) {
            this.f17768b = c3274f;
            this.f17767a = null;
        }

        /* renamed from: a */
        public void mo2494a() {
            this.h = "http://loc.map.baidu.com/slamconfig.php?";
            this.h = String.format(Locale.CHINESE, "%scuid=%s&mb=%s&msdk=12&version=%s&cityid=%s", new Object[]{this.h, C3381b.m14398a().m14403b(), "" + Build.MODEL.replace(" ", JNISearchConst.LAYER_ID_DIVIDER), this.f17768b.f17775g, this.f17767a});
        }

        /* renamed from: a */
        public void m13692a(String str) {
            this.f17767a = str;
            m13300h();
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            if (this.j != null) {
                if (z && this.j != null && this.j.length() > 30 && this.f17768b.f17771c != null) {
                    Editor edit = this.f17768b.f17771c.edit();
                    edit.putString("slamconfig", this.j);
                    edit.commit();
                }
            } else if (z) {
            }
        }
    }

    public C3274f() {
        if (this.f17771c == null) {
            this.f17771c = C3377f.getServiceContext().getSharedPreferences("MapCoreServicePreSlam", 0);
            if (this.f17771c != null) {
                this.f17772d = this.f17771c.getString("lastDay", "null");
                this.f17773e = this.f17771c.getString("slamconfig", "null");
                if (this.f17773e != null && !this.f17773e.equals("null")) {
                    try {
                        this.f17774f = new C3271b(this, new String(Base64.decode(this.f17773e.getBytes())));
                        if (this.f17774f != null && this.f17774f.f17761b > 0) {
                            this.f17775g = "" + this.f17774f.f17761b;
                        }
                    } catch (Exception e) {
                        this.f17774f = null;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static C3274f m13695a() {
        C3274f c3274f;
        synchronized (f17769a) {
            if (f17770b == null) {
                f17770b = new C3274f();
            }
            c3274f = f17770b;
        }
        return c3274f;
    }

    /* renamed from: a */
    public void m13699a(String str) {
        if (this.f17771c == null) {
            this.f17771c = C3377f.getServiceContext().getSharedPreferences("MapCoreServicePreSlam", 0);
        }
        if (this.f17771c != null) {
            String string = this.f17771c.getString("collectDay", "null");
            Editor edit;
            if (string.equals("null")) {
                edit = this.f17771c.edit();
                edit.putString("collectDay", str);
                edit.putInt("collectTime", 1);
                edit.commit();
            } else if (string.equals(str)) {
                int i = this.f17771c.getInt("collectTime", 1) + 1;
                Editor edit2 = this.f17771c.edit();
                edit2.putInt("collectTime", i);
                edit2.commit();
            } else {
                edit = this.f17771c.edit();
                edit.putString("collectDay", str);
                edit.putInt("collectTime", 1);
                edit.commit();
            }
        }
    }

    /* renamed from: b */
    public int m13700b(String str) {
        if (this.f17771c == null) {
            this.f17771c = C3377f.getServiceContext().getSharedPreferences("MapCoreServicePreSlam", 0);
        }
        if (this.f17771c == null) {
            return 0;
        }
        String string = this.f17771c.getString("collectDay", "null");
        return (!string.equals("null") && string.equals(str)) ? this.f17771c.getInt("collectTime", 1) : 0;
    }

    /* renamed from: b */
    public C3271b m13701b() {
        return (this.f17774f == null || this.f17774f.f17761b <= 0) ? null : this.f17774f;
    }

    /* renamed from: c */
    public void m13702c(String str) {
        if (!C3391g.m14445c().equals(this.f17772d)) {
            this.f17772d = C3391g.m14445c();
            if (this.f17771c != null) {
                Editor edit = this.f17771c.edit();
                edit.putString("lastDay", this.f17772d);
                edit.commit();
            }
            new C3273d().m13692a(str);
        }
    }
}
