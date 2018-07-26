package com.baidu.location.indoor;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.baidu.android.bbalbs.common.security.Base64;
import com.baidu.android.bbalbs.common.security.C0409b;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3381b;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.baidu.location.indoor.a */
public class C3406a extends C3186e {
    /* renamed from: a */
    private static HashMap<String, Long> f18450a = new HashMap();
    /* renamed from: b */
    private final String f18451b = "http://loc.map.baidu.com/indoorlocbuildinginfo.php";
    /* renamed from: c */
    private final SimpleDateFormat f18452c = new SimpleDateFormat("yyyyMM");
    /* renamed from: d */
    private Context f18453d;
    /* renamed from: e */
    private boolean f18454e;
    /* renamed from: f */
    private String f18455f;
    /* renamed from: p */
    private HashSet<String> f18456p;
    /* renamed from: q */
    private C3394a f18457q;
    /* renamed from: r */
    private String f18458r = null;
    /* renamed from: s */
    private Handler f18459s;
    /* renamed from: t */
    private Runnable f18460t;

    /* renamed from: com.baidu.location.indoor.a$1 */
    class C33921 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3406a f18400a;

        C33921(C3406a c3406a) {
            this.f18400a = c3406a;
        }

        public void run() {
            if (this.f18400a.f18458r != null) {
                this.f18400a.f18455f = this.f18400a.f18458r;
                this.f18400a.m13301i();
            }
        }
    }

    /* renamed from: com.baidu.location.indoor.a$a */
    public interface C3394a {
        /* renamed from: a */
        void m14459a(boolean z);
    }

    public C3406a(Context context) {
        this.f18453d = context;
        this.f18456p = new HashSet();
        this.f18454e = false;
        this.k = new HashMap();
        this.f18459s = new Handler();
        this.f18460t = new C33921(this);
    }

    /* renamed from: a */
    private String m14514a(Date date) {
        File file = new File(this.f18453d.getCacheDir(), C0409b.a((this.f18455f + this.f18452c.format(date)).getBytes(), false));
        if (!file.isFile()) {
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                str = str + readLine + "\n";
            }
            bufferedReader.close();
            return !str.equals("") ? new String(Base64.decode(str.getBytes())) : null;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: d */
    private void m14515d(String str) {
        for (String toLowerCase : str.split(",")) {
            this.f18456p.add(toLowerCase.toLowerCase());
        }
    }

    /* renamed from: e */
    private Date m14516e() {
        Calendar instance = Calendar.getInstance();
        instance.add(2, -1);
        return instance.getTime();
    }

    /* renamed from: e */
    private void m14517e(String str) {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.f18453d.getCacheDir(), C0409b.a((this.f18455f + this.f18452c.format(new Date())).getBytes(), false)));
            fileWriter.write(Base64.encode(str.getBytes(), "UTF-8"));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
        }
    }

    /* renamed from: f */
    private void m14518f() {
        try {
            File file = new File(this.f18453d.getCacheDir(), C0409b.a((this.f18455f + this.f18452c.format(m14516e())).getBytes(), false));
            if (file.isFile()) {
                file.delete();
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: f */
    private void m14519f(String str) {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.f18453d.getCacheDir(), "buildings"), true);
            fileWriter.write(str + "\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo2494a() {
        this.h = "http://loc.map.baidu.com/indoorlocbuildinginfo.php";
        this.k.clear();
        this.k.put("bid", BNavConfig.INVALID_STRING_VALUE);
        this.k.put("bldg", this.f18455f);
        this.k.put("mb", Build.MODEL);
        this.k.put("msdk", "2.0");
        this.k.put("cuid", C3381b.m14398a().f18317b);
        this.k.put("anchors", "v1");
    }

    /* renamed from: a */
    public void mo2495a(boolean z) {
        boolean z2;
        String a;
        if (z && this.j != null) {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(this.j.toString().getBytes())));
                if (jSONObject.has("anchorinfo")) {
                    String optString = jSONObject.optString("anchorinfo");
                    if (!(optString == null || optString.equals(""))) {
                        this.f18456p.clear();
                        m14515d(optString);
                        m14517e(optString);
                        try {
                            m14518f();
                            z2 = true;
                        } catch (Exception e) {
                            z2 = true;
                        }
                        if (z2 && this.f18458r == null) {
                            this.f18458r = this.f18455f;
                            this.f18459s.postDelayed(this.f18460t, 60000);
                        } else if (z2) {
                            m14519f(this.f18458r);
                            this.f18458r = null;
                            a = m14514a(m14516e());
                            if (a != null) {
                                m14515d(a);
                                if (this.f18457q != null) {
                                    this.f18457q.m14459a(true);
                                }
                            }
                        } else {
                            this.f18458r = null;
                        }
                        this.f18454e = false;
                        if (this.f18457q != null) {
                            this.f18457q.m14459a(z2);
                        }
                    }
                }
            } catch (Exception e2) {
                z2 = false;
            }
        }
        z2 = false;
        if (z2) {
        }
        if (z2) {
            m14519f(this.f18458r);
            this.f18458r = null;
            a = m14514a(m14516e());
            if (a != null) {
                m14515d(a);
                if (this.f18457q != null) {
                    this.f18457q.m14459a(true);
                }
            }
        } else {
            this.f18458r = null;
        }
        this.f18454e = false;
        if (this.f18457q != null) {
            this.f18457q.m14459a(z2);
        }
    }

    /* renamed from: a */
    public boolean m14522a(String str) {
        return (this.f18455f == null || !this.f18455f.equalsIgnoreCase(str) || this.f18456p.isEmpty()) ? false : true;
    }

    /* renamed from: a */
    public boolean m14523a(String str, C3394a c3394a) {
        if (!this.f18454e) {
            this.f18457q = c3394a;
            this.f18454e = true;
            this.f18455f = str;
            try {
                String a = m14514a(new Date());
                if (a == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (f18450a.get(str) == null || currentTimeMillis - ((Long) f18450a.get(str)).longValue() > 86400000) {
                        f18450a.put(str, Long.valueOf(currentTimeMillis));
                        m13301i();
                    }
                } else {
                    m14515d(a);
                    if (this.f18457q != null) {
                        this.f18457q.m14459a(true);
                    }
                    this.f18454e = false;
                }
            } catch (Exception e) {
                this.f18454e = false;
            }
        }
        return false;
    }

    /* renamed from: b */
    public boolean mo2500b() {
        return (this.f18456p == null || this.f18456p.isEmpty()) ? false : true;
    }

    /* renamed from: b */
    public boolean m14525b(String str) {
        return (this.f18455f == null || this.f18456p == null || this.f18456p.isEmpty() || !this.f18456p.contains(str)) ? false : true;
    }

    /* renamed from: c */
    public void mo2499c() {
        this.f18455f = null;
        this.f18456p.clear();
    }

    /* renamed from: d */
    public boolean m14527d() {
        File file = new File(this.f18453d.getCacheDir(), "buildings");
        if (!file.exists()) {
            return false;
        }
        final HashSet hashSet = new HashSet();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    hashSet.add(readLine.trim());
                } else {
                    bufferedReader.close();
                    file.delete();
                    new Thread(new Runnable(this) {
                        /* renamed from: b */
                        final /* synthetic */ C3406a f18402b;

                        public void run() {
                            Iterator it = hashSet.iterator();
                            while (it.hasNext()) {
                                this.f18402b.f18455f = (String) it.next();
                                String str = null;
                                try {
                                    str = this.f18402b.m14514a(new Date());
                                } catch (Exception e) {
                                }
                                if (str == null || str.equals("")) {
                                    this.f18402b.m13301i();
                                    try {
                                        Thread.sleep(BNOffScreenParams.MIN_ENTER_INTERVAL);
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                        }
                    }).start();
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
    }
}
