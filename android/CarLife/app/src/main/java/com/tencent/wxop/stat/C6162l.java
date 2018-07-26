package com.tencent.wxop.stat;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.baidumaps.common.network.NetworkListener;
import com.baidu.mobstat.Config;
import com.tencent.wxop.stat.p291b.C6132a;
import com.tencent.wxop.stat.p291b.C6133b;
import com.tencent.wxop.stat.p291b.C6138g;
import com.tencent.wxop.stat.p291b.C6144m;
import com.tencent.wxop.stat.p291b.C6150s;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.l */
public class C6162l {
    /* renamed from: g */
    private static C6162l f25113g = null;
    /* renamed from: a */
    private List<String> f25114a = null;
    /* renamed from: b */
    private volatile int f25115b = 2;
    /* renamed from: c */
    private volatile String f25116c = "";
    /* renamed from: d */
    private volatile HttpHost f25117d = null;
    /* renamed from: e */
    private C6138g f25118e = null;
    /* renamed from: f */
    private int f25119f = 0;
    /* renamed from: h */
    private Context f25120h = null;
    /* renamed from: i */
    private C6133b f25121i = null;

    private C6162l(Context context) {
        this.f25120h = context.getApplicationContext();
        this.f25118e = new C6138g();
        aw.m21811a(context);
        this.f25121i = C6144m.m21872b();
        m22166l();
        m22163i();
        m22174g();
    }

    /* renamed from: a */
    public static C6162l m22161a(Context context) {
        if (f25113g == null) {
            synchronized (C6162l.class) {
                if (f25113g == null) {
                    f25113g = new C6162l(context);
                }
            }
        }
        return f25113g;
    }

    /* renamed from: b */
    private boolean m22162b(String str) {
        return Pattern.compile("(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})").matcher(str).matches();
    }

    /* renamed from: i */
    private void m22163i() {
        this.f25114a = new ArrayList(10);
        this.f25114a.add("117.135.169.101");
        this.f25114a.add("140.207.54.125");
        this.f25114a.add("180.153.8.53");
        this.f25114a.add("120.198.203.175");
        this.f25114a.add("14.17.43.18");
        this.f25114a.add("163.177.71.186");
        this.f25114a.add("111.30.131.31");
        this.f25114a.add("123.126.121.167");
        this.f25114a.add("123.151.152.111");
        this.f25114a.add("113.142.45.79");
        this.f25114a.add("123.138.162.90");
        this.f25114a.add("103.7.30.94");
    }

    /* renamed from: j */
    private String m22164j() {
        try {
            String str = C6132a.f24874b;
            if (!m22162b(str)) {
                return InetAddress.getByName(str).getHostAddress();
            }
        } catch (Throwable e) {
            this.f25121i.m21826b(e);
        }
        return "";
    }

    /* renamed from: k */
    private void m22165k() {
        String j = m22164j();
        if (C6156f.m21997b()) {
            this.f25121i.m21825b("remoteIp ip is " + j);
        }
        if (C6144m.m21876c(j)) {
            String str;
            if (this.f25114a.contains(j)) {
                str = j;
            } else {
                str = (String) this.f25114a.get(this.f25119f);
                if (C6156f.m21997b()) {
                    this.f25121i.m21830f(j + " not in ip list, change to:" + str);
                }
            }
            C6156f.m22008d("http://" + str + ":80/mstat/report");
        }
    }

    /* renamed from: l */
    private void m22166l() {
        this.f25115b = 0;
        this.f25117d = null;
        this.f25116c = null;
    }

    /* renamed from: a */
    public HttpHost m22167a() {
        return this.f25117d;
    }

    /* renamed from: a */
    public void m22168a(String str) {
        if (C6156f.m21997b()) {
            this.f25121i.m21825b("updateIpList " + str);
        }
        try {
            if (C6144m.m21876c(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() > 0) {
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String string = jSONObject.getString((String) keys.next());
                        if (C6144m.m21876c(string)) {
                            for (String str2 : string.split(";")) {
                                String str22;
                                if (C6144m.m21876c(str22)) {
                                    String[] split = str22.split(Config.TRACE_TODAY_VISIT_SPLIT);
                                    if (split.length > 1) {
                                        str22 = split[0];
                                        if (m22162b(str22) && !this.f25114a.contains(str22)) {
                                            if (C6156f.m21997b()) {
                                                this.f25121i.m21825b("add new ip:" + str22);
                                            }
                                            this.f25114a.add(str22);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable e) {
            this.f25121i.m21826b(e);
        }
        this.f25119f = new Random().nextInt(this.f25114a.size());
    }

    /* renamed from: b */
    public String m22169b() {
        return this.f25116c;
    }

    /* renamed from: c */
    public int m22170c() {
        return this.f25115b;
    }

    /* renamed from: d */
    public void m22171d() {
        this.f25119f = (this.f25119f + 1) % this.f25114a.size();
    }

    /* renamed from: e */
    public boolean m22172e() {
        return this.f25115b == 1;
    }

    /* renamed from: f */
    public boolean m22173f() {
        return this.f25115b != 0;
    }

    /* renamed from: g */
    void m22174g() {
        if (C6150s.m21927f(this.f25120h)) {
            if (C6156f.f25056g) {
                m22165k();
            }
            this.f25116c = C6144m.m21890l(this.f25120h);
            if (C6156f.m21997b()) {
                this.f25121i.m21825b("NETWORK name:" + this.f25116c);
            }
            if (C6144m.m21876c(this.f25116c)) {
                if ("WIFI".equalsIgnoreCase(this.f25116c)) {
                    this.f25115b = 1;
                } else {
                    this.f25115b = 2;
                }
                this.f25117d = C6144m.m21867a(this.f25120h);
            }
            if (C6160j.m22109a()) {
                C6160j.m22139g(this.f25120h);
                return;
            }
            return;
        }
        if (C6156f.m21997b()) {
            this.f25121i.m21825b((Object) "NETWORK TYPE: network is close.");
        }
        m22166l();
    }

    /* renamed from: h */
    public void m22175h() {
        this.f25120h.getApplicationContext().registerReceiver(new C6152b(this), new IntentFilter(NetworkListener.f2257d));
    }
}
