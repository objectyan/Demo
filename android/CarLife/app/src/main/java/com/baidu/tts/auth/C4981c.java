package com.baidu.tts.auth;

import android.text.TextUtils;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.loopj.AsyncHttpResponseHandler;
import com.baidu.tts.loopj.SyncHttpClient;
import com.baidu.tts.p221k.C4975a;
import com.baidu.tts.p221k.C4977b;
import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.p236h.p237a.C5105c;
import com.baidu.tts.tools.StringTool;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OnlineAuth */
/* renamed from: com.baidu.tts.auth.c */
public class C4981c implements C4977b<C4981c, C4980a> {
    /* renamed from: a */
    private String f20690a;
    /* renamed from: b */
    private String f20691b;
    /* renamed from: c */
    private String f20692c;

    /* compiled from: OnlineAuth */
    /* renamed from: com.baidu.tts.auth.c$a */
    public static class C4980a implements C4975a {
        /* renamed from: a */
        private String f20686a;
        /* renamed from: b */
        private String f20687b;
        /* renamed from: c */
        private long f20688c;
        /* renamed from: d */
        private TtsError f20689d;

        /* renamed from: a */
        public void m16597a(String str) {
            this.f20686a = str;
        }

        /* renamed from: a */
        public String m16594a() {
            return this.f20687b;
        }

        /* renamed from: b */
        public void m16599b(String str) {
            this.f20687b = str;
        }

        /* renamed from: a */
        public void m16595a(long j) {
            this.f20688c = j;
        }

        /* renamed from: b */
        public TtsError m16598b() {
            return this.f20689d;
        }

        /* renamed from: a */
        public void m16596a(TtsError ttsError) {
            if (ttsError != null) {
                LoggerProxy.m17001d("OnlineAuth", "this=" + this + "--error=" + ttsError.getDetailMessage());
            }
            this.f20689d = ttsError;
        }

        /* renamed from: g */
        public boolean mo3801g() {
            if (!StringTool.isEmpty(this.f20686a)) {
                return true;
            }
            if (this.f20687b != null && System.currentTimeMillis() < this.f20688c) {
                return true;
            }
            return false;
        }
    }

    public /* synthetic */ Object call() throws Exception {
        return m16610d();
    }

    public /* synthetic */ int compareTo(Object x0) {
        return m16603a((C4981c) x0);
    }

    /* renamed from: a */
    public String m16604a() {
        return this.f20690a;
    }

    /* renamed from: a */
    public void m16605a(String str) {
        this.f20690a = str;
    }

    /* renamed from: b */
    public String m16606b() {
        return this.f20691b;
    }

    /* renamed from: b */
    public void m16607b(String str) {
        this.f20691b = str;
    }

    /* renamed from: c */
    public String m16608c() {
        return this.f20692c;
    }

    /* renamed from: c */
    public void m16609c(String str) {
        this.f20692c = str;
    }

    /* renamed from: a */
    public int m16603a(C4981c c4981c) {
        String a = c4981c.m16604a();
        if (StringTool.isEmpty(this.f20690a)) {
            a = c4981c.m16606b();
            String c = c4981c.m16608c();
            LoggerProxy.m17001d("OnlineAuth", "mAK=" + this.f20691b + "--mSK=" + this.f20692c + "--ak2=" + a + "--sk2=" + c);
            if (StringTool.isEqual(this.f20691b, a) && StringTool.isEqual(this.f20692c, c)) {
                return 0;
            }
            return 1;
        }
        LoggerProxy.m17001d("OnlineAuth", "mProductId=" + this.f20690a + "--productId2=" + a);
        if (a != null) {
            return this.f20690a.compareTo(a);
        }
        return 1;
    }

    /* renamed from: d */
    public C4980a m16610d() throws Exception {
        LoggerProxy.m17001d("OnlineAuth", "enter online auth");
        final C4980a c4980a = new C4980a();
        if (StringTool.isEmpty(this.f20690a)) {
            try {
                if (m16601a(this.f20691b, this.f20692c)) {
                    String b = m16602b(this.f20691b, this.f20692c);
                    LoggerProxy.m17001d("OnlineAuth", "url=" + b);
                    new SyncHttpClient(true, 80, 443).post(null, b, null, null, new AsyncHttpResponseHandler(this) {
                        /* renamed from: b */
                        final /* synthetic */ C4981c f20685b;

                        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                            Object str = new String(responseBody);
                            LoggerProxy.m17001d("OnlineAuth", "body=" + str + "--code=" + statusCode);
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    JSONObject jSONObject = new JSONObject(str);
                                    if (jSONObject.has("access_token")) {
                                        c4980a.m16599b(jSONObject.getString("access_token"));
                                    } else {
                                        c4980a.m16596a(C5105c.m17295a().m17302b(C5097n.ONLINE_ENGINE_AUTH_FAILURE));
                                    }
                                    if (jSONObject.has("expires_in")) {
                                        int i = jSONObject.getInt("expires_in");
                                        c4980a.m16595a((Math.min((long) i, 86400) * 1000000000) + System.nanoTime());
                                    }
                                } catch (JSONException e) {
                                    LoggerProxy.m17001d("OnlineAuth", "parse:" + e.toString());
                                } catch (Exception e2) {
                                    LoggerProxy.m17001d("OnlineAuth", "parse:" + e2.toString());
                                }
                            }
                        }

                        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                            c4980a.m16596a(C5105c.m17295a().m17302b(C5097n.ONLINE_ENGINE_AUTH_FAILURE));
                        }
                    });
                } else {
                    c4980a.m16596a(C5105c.m17295a().m17302b(C5097n.TTS_PARAMETER_INVALID));
                }
            } catch (Throwable e) {
                c4980a.m16596a(C5105c.m17295a().m17300a(C5097n.ONLINE_ENGINE_AUTH_FAILURE, e));
            }
        } else {
            c4980a.m16597a(this.f20690a);
        }
        LoggerProxy.m17001d("OnlineAuth", "end online auth");
        return c4980a;
    }

    /* renamed from: a */
    private boolean m16601a(String str, String str2) {
        return (StringTool.isEmpty(str) || StringTool.isEmpty(str2)) ? false : true;
    }

    /* renamed from: b */
    private String m16602b(String str, String str2) {
        List linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("grant_type", "client_credentials"));
        linkedList.add(new BasicNameValuePair("client_id", str));
        linkedList.add(new BasicNameValuePair("client_secret", str2));
        return "https://openapi.baidu.com/oauth/2.0/token?" + URLEncodedUtils.format(linkedList, "utf-8");
    }
}
