package com.baidu.carlife.wechat.p105a.p106a;

import android.os.Handler;
import android.os.Looper;
import com.baidu.carlife.wechat.p105a.p107b.C2372c;
import com.baidu.carlife.wechat.p105a.p107b.C2373d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import p003b.C0281f;
import p003b.C0297e;
import p003b.C0329m;
import p003b.C0330n;
import p003b.C0337r.C0336a;
import p003b.C0344u;
import p003b.C0345w;
import p003b.C0351y;
import p003b.C0351y.C0350a;
import p003b.ab;
import p003b.ab.C0298a;
import p003b.ac;
import p003b.ad;

/* compiled from: OKHttp3Manager */
/* renamed from: com.baidu.carlife.wechat.a.a.c */
public final class C2368c {
    /* renamed from: a */
    private C0351y f7826a;
    /* renamed from: b */
    private Handler f7827b;
    /* renamed from: c */
    private final ConcurrentHashMap<String, List<C0329m>> f7828c;

    /* compiled from: OKHttp3Manager */
    /* renamed from: com.baidu.carlife.wechat.a.a.c$1 */
    class C23601 implements C0330n {
        /* renamed from: a */
        final /* synthetic */ C2368c f7810a;

        C23601(C2368c this$0) {
            this.f7810a = this$0;
        }

        /* renamed from: a */
        public void mo1138a(C0344u url, List<C0329m> cookies) {
            if (this.f7810a.m9009d(url.m1206i())) {
                this.f7810a.f7828c.put("webwx_cookie", cookies);
            }
        }

        /* renamed from: a */
        public List<C0329m> mo1137a(C0344u url) {
            if (!this.f7810a.m9009d(url.m1206i())) {
                return new ArrayList();
            }
            List<C0329m> cookies = (List) this.f7810a.f7828c.get("webwx_cookie");
            if (cookies != null) {
                return cookies;
            }
            return new ArrayList();
        }
    }

    /* compiled from: OKHttp3Manager */
    /* renamed from: com.baidu.carlife.wechat.a.a.c$a */
    private static class C2365a {
        /* renamed from: a */
        public static final C2368c f7823a = new C2368c();

        private C2365a() {
        }
    }

    /* compiled from: OKHttp3Manager */
    /* renamed from: com.baidu.carlife.wechat.a.a.c$b */
    private static final class C2366b {
        /* renamed from: a */
        String f7824a;
        /* renamed from: b */
        String f7825b;

        C2366b(String key, String value) {
            this.f7824a = key;
            this.f7825b = value;
        }
    }

    /* compiled from: OKHttp3Manager */
    /* renamed from: com.baidu.carlife.wechat.a.a.c$c */
    public interface C2367c {
        /* renamed from: a */
        void mo1826a(C2358a c2358a);

        /* renamed from: a */
        void mo1827a(Exception exception);
    }

    private C2368c() {
        this.f7828c = new ConcurrentHashMap();
        this.f7826a = new C0350a().m1265a(new C23601(this)).m1260a(10, TimeUnit.SECONDS).m1285c(30, TimeUnit.SECONDS).m1279b(30, TimeUnit.SECONDS).m1287c();
        this.f7827b = new Handler(Looper.getMainLooper());
    }

    /* renamed from: b */
    private static C2368c m9001b() {
        return C2365a.f7823a;
    }

    /* renamed from: a */
    public static C0351y m8985a() {
        return C2368c.m9001b().f7826a;
    }

    /* renamed from: a */
    public static void m8998a(boolean clearCookie) {
        C2372c.m9030c("clearCookie = " + clearCookie);
        C2368c.m9001b().f7826a.m1313u().m1083d();
        if (clearCookie) {
            C2368c.m9001b().f7828c.clear();
        }
    }

    /* renamed from: a */
    public static void m8994a(String url, C2367c callback) {
        C2368c.m9001b().m9004b(url, callback);
    }

    /* renamed from: a */
    public static void m8995a(String url, C2367c callback, String json) {
        C2368c.m9001b().m9005b(url, callback, json);
    }

    /* renamed from: a */
    public static void m8996a(String url, C2367c callback, Map<String, String> params) {
        C2368c.m9001b().m9006b(url, callback, (Map) params);
    }

    /* renamed from: a */
    public static void m8997a(String url, String destDir, C2367c callback) {
        C2368c.m9001b().m9007b(url, destDir, callback);
    }

    /* renamed from: a */
    private ad m8984a(String url) throws IOException {
        return this.f7826a.mo1152a(m9008c(url)).mo1120b();
    }

    /* renamed from: b */
    private void m9004b(String url, C2367c callback) {
        m8989a(m9008c(url), callback);
    }

    /* renamed from: b */
    private void m9006b(String url, C2367c callback, Map<String, String> params) {
        m8989a(m8983a(url, m9000a((Map) params)), callback);
    }

    /* renamed from: b */
    private void m9005b(String url, C2367c callback, String json) {
        m8989a(m8982a(url, json), callback);
    }

    /* renamed from: b */
    private void m9007b(final String url, final String destFileDir, final C2367c callback) {
        this.f7826a.mo1152a(m9008c(url)).mo1119a(new C0281f(this) {
            /* renamed from: d */
            final /* synthetic */ C2368c f7814d;

            /* renamed from: a */
            public void mo1106a(C0297e call, IOException e) {
                this.f7814d.m8993a((Exception) e, callback);
            }

            /* renamed from: a */
            public void mo1105a(C0297e call, ad response) {
                Exception e;
                Throwable th;
                InputStream is = null;
                byte[] buf = new byte[2048];
                FileOutputStream fileOutputStream = null;
                try {
                    is = response.m906h().m408d();
                    File file = new File(destFileDir, this.f7814d.m9003b(url));
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    C2372c.m9030c("cacheFile = " + file.getAbsolutePath());
                    FileOutputStream fos = new FileOutputStream(file);
                    while (true) {
                        try {
                            int len = is.read(buf);
                            if (len == -1) {
                                break;
                            }
                            fos.write(buf, 0, len);
                        } catch (IOException e2) {
                            e = e2;
                            fileOutputStream = fos;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fos;
                        }
                    }
                    fos.flush();
                    C2358a httpResult = new C2358a();
                    httpResult.m8966b(file.getAbsolutePath());
                    this.f7814d.m8990a(httpResult, callback);
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e32) {
                            e32.printStackTrace();
                        }
                    }
                    response.close();
                    fileOutputStream = fos;
                } catch (IOException e4) {
                    e = e4;
                    try {
                        e.printStackTrace();
                        this.f7814d.m8993a(e, callback);
                        if (is != null) {
                            try {
                                is.close();
                            } catch (IOException e322) {
                                e322.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e3222) {
                                e3222.printStackTrace();
                            }
                        }
                        response.close();
                    } catch (Throwable th3) {
                        th = th3;
                        if (is != null) {
                            try {
                                is.close();
                            } catch (IOException e32222) {
                                e32222.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e322222) {
                                e322222.printStackTrace();
                            }
                        }
                        response.close();
                        throw th;
                    }
                }
            }
        });
    }

    /* renamed from: b */
    private String m9003b(String path) {
        try {
            return C2373d.m9039a(path) + ".dat";
        } catch (Exception e) {
            e.printStackTrace();
            return System.currentTimeMillis() + ".dat";
        }
    }

    /* renamed from: a */
    private void m8989a(ab request, final C2367c callback) {
        this.f7826a.mo1152a(request).mo1119a(new C0281f(this) {
            /* renamed from: b */
            final /* synthetic */ C2368c f7816b;

            /* renamed from: a */
            public void mo1106a(C0297e call, IOException e) {
                this.f7816b.m8993a((Exception) e, callback);
            }

            /* renamed from: a */
            public void mo1105a(C0297e call, ad response) {
                C2358a httpResult = new C2358a();
                try {
                    httpResult.m8962a(response.m901c());
                    httpResult.m8963a(response.m906h().m411g());
                    httpResult.m8964a(this.f7816b.m8986a(response));
                    this.f7816b.m8990a(httpResult, callback);
                } catch (Exception e) {
                    this.f7816b.m8993a(e, callback);
                } finally {
                    response.close();
                }
            }
        });
    }

    /* renamed from: c */
    private ab m9008c(String url) {
        C2372c.m9030c("get request  url = \n" + url);
        return new C0298a().m838a(url).m845b("User-Agent", C2359b.f7809a).m849d();
    }

    /* renamed from: a */
    private ab m8983a(String url, C2366b[] params) {
        int i = 0;
        C2372c.m9030c("post request  url = \n" + url);
        if (params == null) {
            params = new C2366b[0];
        }
        C0336a builder = new C0336a();
        int length = params.length;
        while (i < length) {
            C2366b param = params[i];
            builder.m1090a(param.f7824a, param.f7825b);
            i++;
        }
        return new C0298a().m838a(url).m845b("User-Agent", C2359b.f7809a).m833a(builder.m1091a()).m849d();
    }

    /* renamed from: a */
    private ab m8982a(String url, String json) {
        C2372c.m9030c("post request  url = \n" + url);
        return new C0298a().m838a(url).m845b("User-Agent", C2359b.f7809a).m833a(ac.m861a(C0345w.m1220a("application/json; charset=utf-8"), json)).m849d();
    }

    /* renamed from: a */
    private C2366b[] m9000a(Map<String, String> params) {
        if (params == null) {
            return new C2366b[0];
        }
        C2366b[] res = new C2366b[params.size()];
        int i = 0;
        for (Entry<String, String> entry : params.entrySet()) {
            int i2 = i + 1;
            res[i] = new C2366b((String) entry.getKey(), (String) entry.getValue());
            i = i2;
        }
        return res;
    }

    /* renamed from: a */
    private void m8993a(final Exception e, final C2367c callback) {
        this.f7827b.post(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C2368c f7819c;

            public void run() {
                if (callback != null) {
                    callback.mo1827a(e);
                }
            }
        });
    }

    /* renamed from: a */
    private void m8990a(final C2358a httpResult, final C2367c callback) {
        this.f7827b.post(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C2368c f7822c;

            public void run() {
                if (callback != null) {
                    callback.mo1826a(httpResult);
                }
            }
        });
    }

    /* renamed from: a */
    private Map<String, String> m8986a(ad response) {
        Map<String, String> cookieMap = new HashMap();
        try {
            List<String> cookies = response.m898a("Set-Cookie");
            int len = cookies.size();
            for (int i = 0; i < len; i++) {
                String cookie = ((String) cookies.get(i)).split(";")[0].trim();
                cookieMap.put(cookie.split("=")[0], cookie.split("=")[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cookieMap;
    }

    /* renamed from: d */
    private boolean m9009d(String host) {
        return Pattern.compile("wechat.com|(wx[0-9]*|weixin).qq.com").matcher(host).find();
    }
}
