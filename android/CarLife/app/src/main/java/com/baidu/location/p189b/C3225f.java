package com.baidu.location.p189b;

import android.net.wifi.WifiConfiguration;
import android.os.Handler;
import android.os.Message;
import com.baidu.android.bbalbs.common.security.Base64;
import com.baidu.location.Jni;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p194f.C3376f;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.location.b.f */
public class C3225f {
    /* renamed from: a */
    private static Object f17539a = new Object();
    /* renamed from: b */
    private static C3225f f17540b = null;
    /* renamed from: c */
    private Handler f17541c = null;
    /* renamed from: d */
    private String f17542d = null;
    /* renamed from: e */
    private int f17543e = 24;
    /* renamed from: f */
    private C3223a f17544f = null;
    /* renamed from: g */
    private long f17545g = 0;

    /* renamed from: com.baidu.location.b.f$1 */
    class C32221 extends Handler {
        /* renamed from: a */
        final /* synthetic */ C3225f f17530a;

        C32221(C3225f c3225f) {
            this.f17530a = c3225f;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.f17530a.m13532d();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.location.b.f$a */
    private class C3223a extends C3186e {
        /* renamed from: a */
        final /* synthetic */ C3225f f17531a;
        /* renamed from: b */
        private boolean f17532b;
        /* renamed from: c */
        private int f17533c;
        /* renamed from: d */
        private JSONArray f17534d;
        /* renamed from: e */
        private JSONArray f17535e;

        C3223a(C3225f c3225f) {
            this.f17531a = c3225f;
            this.f17532b = false;
            this.f17533c = 0;
            this.f17534d = null;
            this.f17535e = null;
            this.k = new HashMap();
        }

        /* renamed from: a */
        public void mo2494a() {
            this.h = C3391g.m14453i();
            this.k.clear();
            this.k.put("qt", "cltrw");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", this.f17534d);
                jSONObject.put("frt", this.f17533c);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.k.put("cltr[0]", "" + Jni.encodeOfflineLocationUpdateRequest(jSONObject.toString()));
            this.k.put("cfg", Integer.valueOf(1));
            this.k.put("info", Jni.encode(C3381b.m14398a().m14405d()));
            this.k.put("trtm", String.format(Locale.CHINA, "%d", new Object[]{Long.valueOf(System.currentTimeMillis())}));
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            if (z && this.j != null) {
                JSONObject jSONObject;
                boolean z2;
                try {
                    jSONObject = new JSONObject(this.j);
                    z2 = true;
                } catch (Exception e) {
                    jSONObject = null;
                    z2 = false;
                }
                if (z2 && jSONObject != null) {
                    try {
                        jSONObject.put("tt", System.currentTimeMillis());
                        jSONObject.put("data", this.f17535e);
                        try {
                            File file = new File(this.f17531a.f17542d, "wcnf.dat");
                            if (!file.exists()) {
                                file.createNewFile();
                            }
                            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));
                            bufferedWriter.write(Base64.encode(jSONObject.toString().getBytes(), "UTF-8"));
                            bufferedWriter.flush();
                            bufferedWriter.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } catch (Exception e3) {
                    }
                }
            }
            this.f17532b = false;
        }

        /* renamed from: a */
        public void m13525a(boolean z, JSONArray jSONArray, JSONArray jSONArray2) {
            if (!this.f17532b) {
                this.f17532b = true;
                if (z) {
                    this.f17533c = 1;
                } else {
                    this.f17533c = 0;
                }
                this.f17534d = jSONArray;
                this.f17535e = jSONArray2;
                m13299c(C3391g.m14453i());
            }
        }
    }

    /* renamed from: com.baidu.location.b.f$b */
    private class C3224b {
        /* renamed from: a */
        public String f17536a = null;
        /* renamed from: b */
        public int f17537b = 0;
        /* renamed from: c */
        final /* synthetic */ C3225f f17538c;

        C3224b(C3225f c3225f, String str, int i) {
            this.f17538c = c3225f;
            this.f17536a = str;
            this.f17537b = i;
        }
    }

    /* renamed from: a */
    public static C3225f m13526a() {
        C3225f c3225f;
        synchronized (f17539a) {
            if (f17540b == null) {
                f17540b = new C3225f();
            }
            c3225f = f17540b;
        }
        return c3225f;
    }

    /* renamed from: a */
    private Object m13527a(Object obj, String str) throws Exception {
        return obj.getClass().getField(str).get(obj);
    }

    /* renamed from: a */
    private List<C3224b> m13528a(List<WifiConfiguration> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        List<C3224b> arrayList = new ArrayList();
        for (WifiConfiguration wifiConfiguration : list) {
            int intValue;
            String str = wifiConfiguration.SSID;
            try {
                intValue = ((Integer) m13527a(wifiConfiguration, "numAssociation")).intValue();
            } catch (Exception e) {
                e.printStackTrace();
                intValue = 0;
            }
            if (intValue > 0 && str != null) {
                arrayList.add(new C3224b(this, str, intValue));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m13530a(boolean z, JSONArray jSONArray, JSONArray jSONArray2) {
        if (this.f17544f == null) {
            this.f17544f = new C3223a(this);
        }
        this.f17544f.m13525a(z, jSONArray, jSONArray2);
    }

    /* renamed from: d */
    private void m13532d() {
        Object obj;
        Map hashMap;
        Object obj2;
        Exception exception;
        Exception exception2;
        Map map;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        JSONObject jSONObject2;
        if (this.f17542d != null) {
            try {
                List<C3224b> a;
                JSONObject jSONObject3;
                boolean z;
                File file = new File(this.f17542d, "wcnf.dat");
                long currentTimeMillis = System.currentTimeMillis();
                Map map2 = null;
                int i;
                if (file.exists()) {
                    try {
                        long j;
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                        String str = "";
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine);
                        }
                        bufferedReader.close();
                        str = stringBuffer.toString();
                        if (str != null) {
                            JSONObject jSONObject4 = new JSONObject(new String(Base64.decode(str.getBytes())));
                            if (jSONObject4.has("ison") && jSONObject4.getInt("ison") == 0) {
                                obj = null;
                            } else {
                                int i2 = 1;
                            }
                            try {
                                if (jSONObject4.has("cfg")) {
                                    JSONObject jSONObject5 = jSONObject4.getJSONObject("cfg");
                                    if (jSONObject5.has("frq")) {
                                        this.f17543e = jSONObject5.getInt("frq");
                                    }
                                }
                                if (jSONObject4.has("tt")) {
                                    currentTimeMillis = jSONObject4.getLong("tt");
                                }
                                if (jSONObject4.has("data")) {
                                    JSONArray jSONArray5 = jSONObject4.getJSONArray("data");
                                    hashMap = new HashMap();
                                    try {
                                        int length = jSONArray5.length();
                                        for (i = 0; i < length; i++) {
                                            JSONObject jSONObject6 = jSONArray5.getJSONObject(i);
                                            if (jSONObject6.has(NaviStatConstants.K_NSC_KEY_FINISHNAVI_SSID) && jSONObject6.has("num")) {
                                                hashMap.put(jSONObject6.getString(NaviStatConstants.K_NSC_KEY_FINISHNAVI_SSID), new C3224b(this, jSONObject6.getString(NaviStatConstants.K_NSC_KEY_FINISHNAVI_SSID), jSONObject6.getInt("num")));
                                            }
                                        }
                                        obj2 = obj;
                                        j = currentTimeMillis;
                                    } catch (Exception e) {
                                        exception = e;
                                        map2 = hashMap;
                                        exception2 = exception;
                                        exception2.printStackTrace();
                                        map = map2;
                                        obj2 = obj;
                                        if (obj2 == null) {
                                            this.f17543e *= 4;
                                        }
                                        if (System.currentTimeMillis() - currentTimeMillis <= ((long) (((this.f17543e * 60) * 60) * 1000))) {
                                            jSONArray = null;
                                            a = m13528a(C3376f.m14355a().m14369d());
                                            if (currentTimeMillis != 0) {
                                                jSONArray2 = new JSONArray();
                                                for (C3224b c3224b : a) {
                                                    jSONObject = new JSONObject();
                                                    jSONObject.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_SSID, c3224b.f17536a);
                                                    jSONObject.put("num", c3224b.f17537b);
                                                    jSONArray2.put(jSONObject);
                                                    obj2 = map.containsKey(c3224b.f17536a) ? 1 : c3224b.f17537b == ((C3224b) map.get(c3224b.f17536a)).f17537b ? null : 1;
                                                    if (obj2 == null) {
                                                        jSONArray3 = jSONArray;
                                                    } else {
                                                        jSONArray4 = jSONArray != null ? jSONArray : new JSONArray();
                                                        jSONObject3 = new JSONObject();
                                                        jSONObject3.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_SSID, c3224b.f17536a);
                                                        jSONObject3.put("num", c3224b.f17537b);
                                                        jSONArray4.put(jSONObject3);
                                                        jSONArray3 = jSONArray4;
                                                    }
                                                    jSONArray = jSONArray3;
                                                }
                                                z = false;
                                                jSONArray4 = jSONArray2;
                                            } else {
                                                jSONArray = new JSONArray();
                                                jSONArray4 = new JSONArray();
                                                for (C3224b c3224b2 : a) {
                                                    jSONObject2 = new JSONObject();
                                                    jSONObject2.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_SSID, c3224b2.f17536a);
                                                    jSONObject2.put("num", c3224b2.f17537b);
                                                    jSONArray.put(jSONObject2);
                                                    jSONArray4.put(jSONObject2);
                                                }
                                                z = true;
                                            }
                                            if (jSONArray != null) {
                                                return;
                                            }
                                        }
                                    }
                                }
                                hashMap = null;
                                obj2 = obj;
                                j = currentTimeMillis;
                            } catch (Exception e2) {
                                exception2 = e2;
                                exception2.printStackTrace();
                                map = map2;
                                obj2 = obj;
                                if (obj2 == null) {
                                    this.f17543e *= 4;
                                }
                                if (System.currentTimeMillis() - currentTimeMillis <= ((long) (((this.f17543e * 60) * 60) * 1000))) {
                                    jSONArray = null;
                                    a = m13528a(C3376f.m14355a().m14369d());
                                    if (currentTimeMillis != 0) {
                                        jSONArray2 = new JSONArray();
                                        for (C3224b c3224b22 : a) {
                                            jSONObject = new JSONObject();
                                            jSONObject.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_SSID, c3224b22.f17536a);
                                            jSONObject.put("num", c3224b22.f17537b);
                                            jSONArray2.put(jSONObject);
                                            if (map.containsKey(c3224b22.f17536a)) {
                                                if (c3224b22.f17537b == ((C3224b) map.get(c3224b22.f17536a)).f17537b) {
                                                }
                                            }
                                            if (obj2 == null) {
                                                jSONArray3 = jSONArray;
                                            } else {
                                                if (jSONArray != null) {
                                                }
                                                jSONObject3 = new JSONObject();
                                                jSONObject3.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_SSID, c3224b22.f17536a);
                                                jSONObject3.put("num", c3224b22.f17537b);
                                                jSONArray4.put(jSONObject3);
                                                jSONArray3 = jSONArray4;
                                            }
                                            jSONArray = jSONArray3;
                                        }
                                        z = false;
                                        jSONArray4 = jSONArray2;
                                    } else {
                                        jSONArray = new JSONArray();
                                        jSONArray4 = new JSONArray();
                                        for (C3224b c3224b222 : a) {
                                            jSONObject2 = new JSONObject();
                                            jSONObject2.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_SSID, c3224b222.f17536a);
                                            jSONObject2.put("num", c3224b222.f17537b);
                                            jSONArray.put(jSONObject2);
                                            jSONArray4.put(jSONObject2);
                                        }
                                        z = true;
                                    }
                                    if (jSONArray != null) {
                                        return;
                                    }
                                }
                            }
                        }
                        j = currentTimeMillis;
                        hashMap = null;
                        i = 1;
                        map = hashMap;
                        currentTimeMillis = j;
                    } catch (Exception e3) {
                        exception = e3;
                        obj = 1;
                        exception2 = exception;
                        exception2.printStackTrace();
                        map = map2;
                        obj2 = obj;
                        if (obj2 == null) {
                            this.f17543e *= 4;
                        }
                        if (System.currentTimeMillis() - currentTimeMillis <= ((long) (((this.f17543e * 60) * 60) * 1000))) {
                            jSONArray = null;
                            a = m13528a(C3376f.m14355a().m14369d());
                            if (currentTimeMillis != 0) {
                                jSONArray = new JSONArray();
                                jSONArray4 = new JSONArray();
                                for (C3224b c3224b2222 : a) {
                                    jSONObject2 = new JSONObject();
                                    jSONObject2.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_SSID, c3224b2222.f17536a);
                                    jSONObject2.put("num", c3224b2222.f17537b);
                                    jSONArray.put(jSONObject2);
                                    jSONArray4.put(jSONObject2);
                                }
                                z = true;
                            } else {
                                jSONArray2 = new JSONArray();
                                for (C3224b c3224b22222 : a) {
                                    jSONObject = new JSONObject();
                                    jSONObject.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_SSID, c3224b22222.f17536a);
                                    jSONObject.put("num", c3224b22222.f17537b);
                                    jSONArray2.put(jSONObject);
                                    if (map.containsKey(c3224b22222.f17536a)) {
                                        if (c3224b22222.f17537b == ((C3224b) map.get(c3224b22222.f17536a)).f17537b) {
                                        }
                                    }
                                    if (obj2 == null) {
                                        if (jSONArray != null) {
                                        }
                                        jSONObject3 = new JSONObject();
                                        jSONObject3.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_SSID, c3224b22222.f17536a);
                                        jSONObject3.put("num", c3224b22222.f17537b);
                                        jSONArray4.put(jSONObject3);
                                        jSONArray3 = jSONArray4;
                                    } else {
                                        jSONArray3 = jSONArray;
                                    }
                                    jSONArray = jSONArray3;
                                }
                                z = false;
                                jSONArray4 = jSONArray2;
                            }
                            if (jSONArray != null) {
                            }
                            return;
                        }
                    }
                }
                map = null;
                currentTimeMillis = 0;
                i = 1;
                if (obj2 == null) {
                    this.f17543e *= 4;
                }
                if (System.currentTimeMillis() - currentTimeMillis <= ((long) (((this.f17543e * 60) * 60) * 1000))) {
                    jSONArray = null;
                    a = m13528a(C3376f.m14355a().m14369d());
                    if (currentTimeMillis != 0) {
                        if (a != null && a.size() > 0) {
                            jSONArray = new JSONArray();
                            jSONArray4 = new JSONArray();
                            for (C3224b c3224b222222 : a) {
                                jSONObject2 = new JSONObject();
                                jSONObject2.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_SSID, c3224b222222.f17536a);
                                jSONObject2.put("num", c3224b222222.f17537b);
                                jSONArray.put(jSONObject2);
                                jSONArray4.put(jSONObject2);
                            }
                            z = true;
                        }
                        jSONArray4 = null;
                        z = false;
                    } else {
                        if (a != null && a.size() > 0) {
                            jSONArray2 = new JSONArray();
                            if (map != null && map.size() > 0) {
                                for (C3224b c3224b2222222 : a) {
                                    jSONObject = new JSONObject();
                                    jSONObject.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_SSID, c3224b2222222.f17536a);
                                    jSONObject.put("num", c3224b2222222.f17537b);
                                    jSONArray2.put(jSONObject);
                                    if (map.containsKey(c3224b2222222.f17536a)) {
                                        if (c3224b2222222.f17537b == ((C3224b) map.get(c3224b2222222.f17536a)).f17537b) {
                                        }
                                    }
                                    if (obj2 == null) {
                                        if (jSONArray != null) {
                                        }
                                        jSONObject3 = new JSONObject();
                                        jSONObject3.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_SSID, c3224b2222222.f17536a);
                                        jSONObject3.put("num", c3224b2222222.f17537b);
                                        jSONArray4.put(jSONObject3);
                                        jSONArray3 = jSONArray4;
                                    } else {
                                        jSONArray3 = jSONArray;
                                    }
                                    jSONArray = jSONArray3;
                                }
                            }
                            z = false;
                            jSONArray4 = jSONArray2;
                        }
                        jSONArray4 = null;
                        z = false;
                    }
                    if (jSONArray != null && jSONArray4 != null) {
                        m13530a(z, jSONArray, jSONArray4);
                    }
                }
            } catch (Exception exception22) {
                exception22.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public void m13533b() {
        if (this.f17541c == null) {
            this.f17541c = new C32221(this);
        }
        this.f17542d = C3391g.m14455k();
    }

    /* renamed from: c */
    public void m13534c() {
        if (System.currentTimeMillis() - this.f17545g > 3600000 && this.f17541c != null) {
            this.f17541c.sendEmptyMessage(1);
            this.f17545g = System.currentTimeMillis();
        }
    }
}
