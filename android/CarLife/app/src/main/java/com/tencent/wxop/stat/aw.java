package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.p280a.p281a.p282a.p283a.C6084g;
import com.tencent.p280a.p281a.p282a.p283a.C6085h;
import com.tencent.wxop.stat.p290a.C6119e;
import com.tencent.wxop.stat.p291b.C6133b;
import com.tencent.wxop.stat.p291b.C6138g;
import com.tencent.wxop.stat.p291b.C6139h;
import com.tencent.wxop.stat.p291b.C6144m;
import cz.msebera.android.httpclient.C6591q;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

class aw {
    /* renamed from: d */
    private static C6133b f24861d = C6144m.m21872b();
    /* renamed from: e */
    private static aw f24862e = null;
    /* renamed from: f */
    private static Context f24863f = null;
    /* renamed from: a */
    DefaultHttpClient f24864a = null;
    /* renamed from: b */
    C6138g f24865b = null;
    /* renamed from: c */
    StringBuilder f24866c = new StringBuilder(4096);
    /* renamed from: g */
    private long f24867g = 0;

    private aw(Context context) {
        try {
            f24863f = context.getApplicationContext();
            this.f24867g = System.currentTimeMillis() / 1000;
            this.f24865b = new C6138g();
            if (C6156f.m21997b()) {
                try {
                    Logger.getLogger("org.apache.http.wire").setLevel(Level.FINER);
                    Logger.getLogger("org.apache.http.headers").setLevel(Level.FINER);
                    System.setProperty(LogFactoryImpl.LOG_PROPERTY, "org.apache.commons.logging.impl.SimpleLog");
                    System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
                    System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "debug");
                    System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "debug");
                    System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.headers", "debug");
                } catch (Throwable th) {
                }
            }
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
            this.f24864a = new DefaultHttpClient(basicHttpParams);
            this.f24864a.setKeepAliveStrategy(new ax(this));
        } catch (Throwable th2) {
            f24861d.m21826b(th2);
        }
    }

    /* renamed from: a */
    static Context m21810a() {
        return f24863f;
    }

    /* renamed from: a */
    static void m21811a(Context context) {
        f24863f = context.getApplicationContext();
    }

    /* renamed from: a */
    private void m21812a(JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("mid");
            if (C6085h.m21668b(optString)) {
                if (C6156f.m21997b()) {
                    f24861d.m21825b("update mid:" + optString);
                }
                C6084g.m21659a(f24863f).m21661a(optString);
            }
            if (!jSONObject.isNull("cfg")) {
                C6156f.m21981a(f24863f, jSONObject.getJSONObject("cfg"));
            }
            if (!jSONObject.isNull("ncts")) {
                int i = jSONObject.getInt("ncts");
                int currentTimeMillis = (int) (((long) i) - (System.currentTimeMillis() / 1000));
                if (C6156f.m21997b()) {
                    f24861d.m21825b("server time:" + i + ", diff time:" + currentTimeMillis);
                }
                C6144m.m21904z(f24863f);
                C6144m.m21868a(f24863f, currentTimeMillis);
            }
        } catch (Throwable th) {
            f24861d.m21830f(th);
        }
    }

    /* renamed from: b */
    static aw m21813b(Context context) {
        if (f24862e == null) {
            synchronized (aw.class) {
                if (f24862e == null) {
                    f24862e = new aw(context);
                }
            }
        }
        return f24862e;
    }

    /* renamed from: a */
    void m21814a(C6119e c6119e, av avVar) {
        m21816b(Arrays.asList(new String[]{c6119e.m21717g()}), avVar);
    }

    /* renamed from: a */
    void m21815a(List<?> list, av avVar) {
        int i = 0;
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            list.get(0);
            Throwable th;
            try {
                String str;
                this.f24866c.delete(0, this.f24866c.length());
                this.f24866c.append("[");
                String str2 = "rc4";
                for (int i2 = 0; i2 < size; i2++) {
                    this.f24866c.append(list.get(i2).toString());
                    if (i2 != size - 1) {
                        this.f24866c.append(",");
                    }
                }
                this.f24866c.append("]");
                String stringBuilder = this.f24866c.toString();
                size = stringBuilder.length();
                String str3 = C6156f.m22041q() + "/?index=" + this.f24867g;
                this.f24867g++;
                if (C6156f.m21997b()) {
                    f24861d.m21825b("[" + str3 + "]Send request(" + size + "bytes), content:" + stringBuilder);
                }
                HttpPost httpPost = new HttpPost(str3);
                httpPost.addHeader("Accept-Encoding", "gzip");
                httpPost.setHeader("Connection", "Keep-Alive");
                httpPost.removeHeaders("Cache-Control");
                HttpHost a = C6162l.m22161a(f24863f).m22167a();
                httpPost.addHeader("Content-Encoding", str2);
                if (a == null) {
                    this.f24864a.getParams().removeParameter("http.route.default-proxy");
                } else {
                    if (C6156f.m21997b()) {
                        f24861d.m21834j("proxy:" + a.toHostString());
                    }
                    httpPost.addHeader("X-Content-Encoding", str2);
                    this.f24864a.getParams().setParameter("http.route.default-proxy", a);
                    httpPost.addHeader("X-Online-Host", C6156f.f25061l);
                    httpPost.addHeader(C6591q.f26544a, "*/*");
                    httpPost.addHeader("Content-Type", "json");
                }
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream(size);
                byte[] bytes = stringBuilder.getBytes("UTF-8");
                int length = bytes.length;
                if (size > C6156f.f25065p) {
                    i = 1;
                }
                if (i != 0) {
                    httpPost.removeHeaders("Content-Encoding");
                    str = str2 + ",gzip";
                    httpPost.addHeader("Content-Encoding", str);
                    if (a != null) {
                        httpPost.removeHeaders("X-Content-Encoding");
                        httpPost.addHeader("X-Content-Encoding", str);
                    }
                    byteArrayOutputStream.write(new byte[4]);
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(bytes);
                    gZIPOutputStream.close();
                    bytes = byteArrayOutputStream.toByteArray();
                    ByteBuffer.wrap(bytes, 0, 4).putInt(length);
                    if (C6156f.m21997b()) {
                        f24861d.m21834j("before Gzip:" + length + " bytes, after Gzip:" + bytes.length + " bytes");
                    }
                }
                httpPost.setEntity(new ByteArrayEntity(C6139h.m21846a(bytes)));
                HttpResponse execute = this.f24864a.execute(httpPost);
                HttpEntity entity = execute.getEntity();
                size = execute.getStatusLine().getStatusCode();
                long contentLength = entity.getContentLength();
                if (C6156f.m21997b()) {
                    f24861d.m21825b("http recv response status code:" + size + ", content length:" + contentLength);
                }
                if (contentLength <= 0) {
                    f24861d.m21832h("Server response no data.");
                    if (avVar != null) {
                        avVar.mo5018b();
                    }
                    EntityUtils.toString(entity);
                    return;
                }
                if (contentLength > 0) {
                    InputStream content = entity.getContent();
                    DataInputStream dataInputStream = new DataInputStream(content);
                    bytes = new byte[((int) entity.getContentLength())];
                    dataInputStream.readFully(bytes);
                    content.close();
                    dataInputStream.close();
                    Header firstHeader = execute.getFirstHeader("Content-Encoding");
                    if (firstHeader != null) {
                        if (firstHeader.getValue().equalsIgnoreCase("gzip,rc4")) {
                            bytes = C6139h.m21848b(C6144m.m21870a(bytes));
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4,gzip")) {
                            bytes = C6144m.m21870a(C6139h.m21848b(bytes));
                        } else if (firstHeader.getValue().equalsIgnoreCase("gzip")) {
                            bytes = C6144m.m21870a(bytes);
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4")) {
                            bytes = C6139h.m21848b(bytes);
                        }
                    }
                    str = new String(bytes, "UTF-8");
                    if (C6156f.m21997b()) {
                        f24861d.m21825b("http get response data:" + str);
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    if (size == 200) {
                        m21812a(jSONObject);
                        if (avVar != null) {
                            if (jSONObject.optInt("ret") == 0) {
                                avVar.mo5017a();
                            } else {
                                f24861d.m21831g("response error data.");
                                avVar.mo5018b();
                            }
                        }
                    } else {
                        f24861d.m21831g("Server response error code:" + size + ", error:" + new String(bytes, "UTF-8"));
                        if (avVar != null) {
                            avVar.mo5018b();
                        }
                    }
                    content.close();
                } else {
                    EntityUtils.toString(entity);
                }
                byteArrayOutputStream.close();
                th = null;
                if (th != null) {
                    f24861d.m21821a(th);
                    if (avVar != null) {
                        try {
                            avVar.mo5018b();
                        } catch (Throwable th2) {
                            f24861d.m21826b(th2);
                        }
                    }
                    if (th instanceof OutOfMemoryError) {
                        System.gc();
                        this.f24866c = null;
                        this.f24866c = new StringBuilder(2048);
                    }
                    C6162l.m22161a(f24863f).m22171d();
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* renamed from: b */
    void m21816b(List<?> list, av avVar) {
        if (this.f24865b != null) {
            this.f24865b.m21844a(new ay(this, list, avVar));
        }
    }
}
