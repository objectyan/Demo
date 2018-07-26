package com.baidu.android.pushservice.p026e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.C0430a;
import com.baidu.android.pushservice.C0554h;
import com.baidu.android.pushservice.C0580j;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.p022i.C0420c;
import com.baidu.android.pushservice.p022i.C0559d;
import com.baidu.android.pushservice.p028g.C0527a;
import com.baidu.android.pushservice.p029h.C0536b;
import com.baidu.android.pushservice.p029h.C0543i;
import com.baidu.android.pushservice.p029h.C0544j;
import com.baidu.android.pushservice.p029h.C0553q;
import com.baidu.android.pushservice.p029h.p030a.C0532b;
import com.baidu.android.pushservice.p031j.C0572k;
import com.baidu.android.pushservice.p031j.C0577o;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.speech.asr.SpeechConstant;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.e.a */
public abstract class C0485a extends C0420c {
    /* renamed from: a */
    protected Context f1589a;
    /* renamed from: b */
    protected C0496l f1590b;
    /* renamed from: c */
    protected String f1591c = C0554h.m2382e();
    /* renamed from: d */
    private C0484a f1592d = new C0484a(this);

    /* renamed from: com.baidu.android.pushservice.e.a$a */
    public class C0484a {
        /* renamed from: a */
        final /* synthetic */ C0485a f1588a;

        public C0484a(C0485a c0485a) {
            this.f1588a = c0485a;
        }

        /* renamed from: a */
        public void m2062a(Boolean bool) {
            C0578p.m2546b("RequetChannelListener#isGetChannelToken#isSucceed=" + bool, this.f1588a.f1589a);
            if (bool.booleanValue()) {
                C0527a.m2219c("AbstractProcessor", "netWorkConnect connectResult: " + this.f1588a.mo1283c(), this.f1588a.f1589a);
            } else if (!C0580j.m2614a(this.f1588a.f1589a).m2619c()) {
                this.f1588a.m2068a(10002);
                C0578p.m2546b("RequetChannelListener#isGetChannelToken#isSucceed=false, errorcode=10002", this.f1588a.f1589a);
            }
        }
    }

    public C0485a(C0496l c0496l, Context context) {
        this.f1590b = c0496l;
        this.f1589a = context.getApplicationContext();
        m1793a((short) 100);
        m1794c("http-" + c0496l.f1603a);
    }

    /* renamed from: a */
    private void m2063a(String str, int i) {
        final String str2 = str;
        final int i2 = i;
        C0559d.m2387a().m2388a(new C0420c(this, "insertHttpBehavior", (short) 95) {
            /* renamed from: c */
            final /* synthetic */ C0485a f1587c;

            /* renamed from: a */
            public void mo1272a() {
                try {
                    C0543i c0543i = new C0543i();
                    c0543i.d = str2;
                    c0543i.e = System.currentTimeMillis();
                    c0543i.f = C0532b.m2255b(this.f1587c.f1589a);
                    c0543i.g = i2;
                    if (str2.equals("030403")) {
                        c0543i.i = C0578p.m2604w(this.f1587c.f1589a);
                    } else if (str2.equals("030401")) {
                        c0543i.i = C0578p.m2606x(this.f1587c.f1589a);
                    }
                    C0553q.m2363b(this.f1587c.f1589a, c0543i);
                } catch (Exception e) {
                }
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private int m2064b(int r9) {
        /*
        r8 = this;
        r3 = 10002; // 0x2712 float:1.4016E-41 double:4.9416E-320;
        r1 = 1;
        r2 = 0;
        if (r9 <= 0) goto L_0x007a;
    L_0x0006:
        r4 = r8.f1589a;
        if (r9 != r1) goto L_0x0012;
    L_0x000a:
        r0 = r1;
    L_0x000b:
        r0 = com.baidu.android.pushservice.C0554h.m2375b(r4, r0);
        if (r0 != 0) goto L_0x0014;
    L_0x0011:
        return r3;
    L_0x0012:
        r0 = r2;
        goto L_0x000b;
    L_0x0014:
        r4 = r8.f1591c;
        r5 = "http://";
        r4 = r4.startsWith(r5);
        if (r4 == 0) goto L_0x007a;
    L_0x001f:
        r4 = r8.f1591c;
        r5 = "http://";
        r6 = "";
        r4 = r4.replace(r5, r6);
        r8.f1591c = r4;
        r4 = r8.f1591c;
        r5 = "/";
        r4 = r4.indexOf(r5);
        if (r4 <= 0) goto L_0x0040;
    L_0x0038:
        r5 = r8.f1591c;
        r4 = r5.substring(r4);
        r8.f1591c = r4;
    L_0x0040:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "http://";
        r4 = r4.append(r5);
        r0 = r4.append(r0);
        r4 = r8.f1591c;
        r0 = r0.append(r4);
        r0 = r0.toString();
        r8.f1591c = r0;
        r0 = "AbstractProcessor";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = " --- abstract request URL: ";
        r4 = r4.append(r5);
        r5 = r8.f1591c;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r5 = r8.f1589a;
        com.baidu.android.pushservice.p028g.C0527a.m2216a(r0, r4, r5);
    L_0x007a:
        r4 = 0;
        r0 = new java.util.HashMap;	 Catch:{ Exception -> 0x00cf, all -> 0x012e }
        r0.<init>();	 Catch:{ Exception -> 0x00cf, all -> 0x012e }
        r8.mo1286a(r0);	 Catch:{ Exception -> 0x00cf, all -> 0x012e }
        r5 = r8.f1591c;	 Catch:{ Exception -> 0x00cf, all -> 0x012e }
        r6 = "POST";
        r0 = com.baidu.android.pushservice.p027f.C0521b.m2163a(r5, r6, r0);	 Catch:{ Exception -> 0x00cf, all -> 0x012e }
        r6 = r0.m2162b();	 Catch:{ Exception -> 0x00cf, all -> 0x012e }
        r4 = r0.m2159a();	 Catch:{ Exception -> 0x00cf, all -> 0x012e }
        r0 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r6 != r0) goto L_0x00c1;
    L_0x0098:
        r0 = com.baidu.android.pushservice.p029h.p030a.C0532b.m2252a(r4);	 Catch:{ Exception -> 0x0134, all -> 0x0131 }
        r0 = r8.mo1284b(r0);	 Catch:{ Exception -> 0x0134, all -> 0x0131 }
        r5 = 0;
        r0 = r0.getBytes();	 Catch:{ Exception -> 0x0134, all -> 0x0131 }
        r8.mo1287a(r5, r0);	 Catch:{ Exception -> 0x0134, all -> 0x0131 }
        r5 = r2;
        r0 = r2;
    L_0x00aa:
        if (r4 == 0) goto L_0x00ae;
    L_0x00ac:
        if (r6 != 0) goto L_0x00b7;
    L_0x00ae:
        r0 = 2;
        if (r9 < r0) goto L_0x00b6;
    L_0x00b1:
        r0 = 10002; // 0x2712 float:1.4016E-41 double:4.9416E-320;
        r8.m2068a(r0);	 Catch:{ Exception -> 0x0138, all -> 0x0131 }
    L_0x00b6:
        r0 = r3;
    L_0x00b7:
        r1 = new java.io.Closeable[r1];
        r1[r2] = r4;
        com.baidu.android.pushservice.p027f.C0521b.m2169a(r1);
    L_0x00be:
        r3 = r0;
        goto L_0x0011;
    L_0x00c1:
        r0 = 503; // 0x1f7 float:7.05E-43 double:2.485E-321;
        if (r6 != r0) goto L_0x013c;
    L_0x00c5:
        r5 = r1;
    L_0x00c6:
        r0 = com.baidu.android.pushservice.p029h.p030a.C0532b.m2252a(r4);	 Catch:{ Exception -> 0x0138, all -> 0x0131 }
        r8.m2071a(r0);	 Catch:{ Exception -> 0x0138, all -> 0x0131 }
        r0 = r6;
        goto L_0x00aa;
    L_0x00cf:
        r0 = move-exception;
        r3 = r4;
        r4 = r2;
    L_0x00d2:
        r5 = "AbstractProcessor";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0125 }
        r6.<init>();	 Catch:{ all -> 0x0125 }
        r7 = "error : ";
        r6 = r6.append(r7);	 Catch:{ all -> 0x0125 }
        r7 = r0.getMessage();	 Catch:{ all -> 0x0125 }
        r6 = r6.append(r7);	 Catch:{ all -> 0x0125 }
        r6 = r6.toString();	 Catch:{ all -> 0x0125 }
        r7 = r8.f1589a;	 Catch:{ all -> 0x0125 }
        com.baidu.android.pushservice.p028g.C0527a.m2218b(r5, r6, r7);	 Catch:{ all -> 0x0125 }
        if (r4 == 0) goto L_0x0102;
    L_0x00f4:
        r0 = 10003; // 0x2713 float:1.4017E-41 double:4.942E-320;
        r8.m2068a(r0);	 Catch:{ all -> 0x0125 }
    L_0x00f9:
        r0 = -1;
        r1 = new java.io.Closeable[r1];
        r1[r2] = r3;
        com.baidu.android.pushservice.p027f.C0521b.m2169a(r1);
        goto L_0x00be;
    L_0x0102:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0125 }
        r4.<init>();	 Catch:{ all -> 0x0125 }
        r5 = "tryConnect failed setResult UnKnown ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0125 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0125 }
        r0 = r4.append(r0);	 Catch:{ all -> 0x0125 }
        r0 = r0.toString();	 Catch:{ all -> 0x0125 }
        r4 = r8.f1589a;	 Catch:{ all -> 0x0125 }
        com.baidu.android.pushservice.p031j.C0578p.m2546b(r0, r4);	 Catch:{ all -> 0x0125 }
        r0 = 20001; // 0x4e21 float:2.8027E-41 double:9.882E-320;
        r8.m2068a(r0);	 Catch:{ all -> 0x0125 }
        goto L_0x00f9;
    L_0x0125:
        r0 = move-exception;
    L_0x0126:
        r1 = new java.io.Closeable[r1];
        r1[r2] = r3;
        com.baidu.android.pushservice.p027f.C0521b.m2169a(r1);
        throw r0;
    L_0x012e:
        r0 = move-exception;
        r3 = r4;
        goto L_0x0126;
    L_0x0131:
        r0 = move-exception;
        r3 = r4;
        goto L_0x0126;
    L_0x0134:
        r0 = move-exception;
        r3 = r4;
        r4 = r2;
        goto L_0x00d2;
    L_0x0138:
        r0 = move-exception;
        r3 = r4;
        r4 = r5;
        goto L_0x00d2;
    L_0x013c:
        r5 = r2;
        goto L_0x00c6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.e.a.b(int):int");
    }

    /* renamed from: b */
    private void m2065b(int i, byte[] bArr) {
        Intent intent = new Intent("com.baidu.android.pushservice.action.internal.RECEIVE");
        intent.putExtra("method", this.f1590b.f1603a);
        intent.putExtra(PushConstants.EXTRA_ERROR_CODE, i);
        intent.putExtra("content", bArr);
        intent.putExtra(SpeechConstant.APP_ID, this.f1590b.f1608f);
        intent.setFlags(32);
        mo1285a(intent);
        this.f1589a.sendBroadcast(intent);
    }

    /* renamed from: d */
    private boolean m2066d(String str) {
        for (String equals : new String[]{"method_deal_lapp_bind_intent", "method_lapp_unbind", "method_set_lapp_tags", "method_del_lapp_tags", "method_list_lapp_tags"}) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo1272a() {
        m2074b();
    }

    /* renamed from: a */
    protected void m2068a(int i) {
        mo1287a(i, PushConstants.m1741a(i).getBytes());
    }

    /* renamed from: a */
    protected void mo1287a(int i, byte[] bArr) {
        if (!TextUtils.isEmpty(this.f1590b.f1604b) && this.f1590b.f1604b.equals("internal")) {
            m2065b(i, bArr);
        } else if (this.f1590b.f1615m) {
            Intent intent = new Intent();
            if (this.f1590b.f1603a.equals("method_lapp_unbind") || this.f1590b.f1603a.equals("method_list_lapp_tags")) {
                intent.setAction("com.baidu.android.pushservice.action.lapp.RECEIVE");
            } else if (this.f1590b.f1603a.equals("method_sdk_bind")) {
                intent.setAction("com.baidu.android.pushservice.action.sdk.RECEIVE");
            } else {
                intent.setAction(PushConstants.ACTION_RECEIVE);
            }
            intent.putExtra("method", this.f1590b.f1603a);
            intent.putExtra(PushConstants.EXTRA_ERROR_CODE, i);
            intent.putExtra("content", bArr);
            intent.setFlags(32);
            mo1285a(intent);
            C0536b c0536b = new C0536b();
            c0536b.g = i;
            c0536b.h = this.f1590b.f1608f;
            c0536b.j = this.f1590b.f1607e;
            c0536b.e = System.currentTimeMillis();
            c0536b.f = C0532b.m2255b(this.f1589a);
            if (this.f1590b.f1603a.equals(PushConstants.METHOD_BIND)) {
                intent.putExtra("access_token", this.f1590b.f1606d);
                intent.putExtra("secret_key", this.f1590b.f1611i);
                intent.putExtra("real_bind", "real_bind");
                c0536b.d = "020101";
                C0544j c0544j = new C0544j();
                c0544j.m2269b(this.f1590b.f1607e);
                c0544j = C0578p.m2517a(c0544j, this.f1589a, this.f1590b.f1607e);
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    c0536b.f1756b = jSONObject.getString("request_id");
                    if (i != 0) {
                        c0536b.f1755a = jSONObject.getString(PushConstants.EXTRA_ERROR_CODE);
                    }
                    String string = jSONObject.getJSONObject("response_params").getString(SpeechConstant.APP_ID);
                    c0536b.h = string;
                    c0544j.m2266a(string);
                } catch (JSONException e) {
                }
                try {
                    C0553q.m2352a(this.f1589a, c0536b);
                    C0553q.m2355a(this.f1589a, c0544j);
                } catch (Exception e2) {
                    C0527a.m2218b("AbstractProcessor", "error " + e2.getMessage(), this.f1589a);
                }
                if (C0430a.m1857b() > 0) {
                    C0543i c0543i = new C0543i();
                    c0543i.j = this.f1590b.f1607e;
                    c0543i.e = System.currentTimeMillis();
                    c0543i.f = C0532b.m2255b(this.f1589a);
                    c0543i.d = "039904";
                    c0543i.g = i;
                    if (bArr.length > 0) {
                        c0543i.i = new String(bArr);
                    }
                    C0553q.m2354a(this.f1589a, c0543i);
                }
            } else if (bArr != null && (this.f1590b.f1603a.equals("method_unbind") || this.f1590b.f1603a.equals("com.baidu.android.pushservice.action.UNBINDAPP"))) {
                if (this.f1590b.f1603a.equals("method_unbind")) {
                    c0536b.d = "020301";
                } else {
                    c0536b.d = "020601";
                }
                try {
                    c0536b.f1756b = new JSONObject(new String(bArr)).getString("request_id");
                } catch (JSONException e3) {
                    C0527a.m2218b("AbstractProcessor", "unbind failed msg: " + new String(bArr), this.f1589a);
                    c0536b.f1755a = new String(bArr);
                }
                try {
                    C0553q.m2352a(this.f1589a, c0536b);
                } catch (Exception e22) {
                    C0527a.m2218b("AbstractProcessor", "error " + e22.getMessage(), this.f1589a);
                }
            }
            if (!TextUtils.isEmpty(this.f1590b.f1607e) || m2066d(this.f1590b.f1603a)) {
                if (!m2066d(this.f1590b.f1603a)) {
                    intent.setPackage(this.f1590b.f1607e);
                }
                C0578p.m2546b("> sendResult to " + this.f1590b.f1611i + ", method:" + this.f1590b.f1603a + ", errorCode : " + i + ", content : " + new String(bArr), this.f1589a);
                if (!this.f1590b.f1603a.equals("com.baidu.android.pushservice.action.UNBINDAPP") && TextUtils.isEmpty(this.f1590b.f1612j)) {
                    C0578p.m2545b(this.f1589a, intent, intent.getAction(), this.f1590b.f1607e);
                }
            }
        }
    }

    /* renamed from: a */
    protected void mo1285a(Intent intent) {
    }

    /* renamed from: a */
    protected void m2071a(String str) {
        if (str != null) {
            if (!str.startsWith("{\"")) {
                str = str.substring(str.indexOf("{\""));
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i = jSONObject.getInt("error_code");
                String string = jSONObject.getString(PushConstants.EXTRA_ERROR_CODE);
                String string2 = jSONObject.getString("request_id");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(PushConstants.EXTRA_ERROR_CODE, string);
                jSONObject2.put("request_id", string2);
                mo1287a(i, jSONObject2.toString().getBytes());
            } catch (JSONException e) {
                C0527a.m2218b("AbstractProcessor", "error : " + e.getMessage(), this.f1589a);
            }
        }
    }

    /* renamed from: a */
    protected void mo1286a(HashMap<String, String> hashMap) {
        C0486b.m2078a((HashMap) hashMap);
        Object obj = this.f1590b.f1603a;
        if (TextUtils.isEmpty(obj) || !obj.equalsIgnoreCase(PushConstants.METHOD_BIND)) {
            if (!TextUtils.isEmpty(this.f1590b.f1610h)) {
                hashMap.put("bduss", this.f1590b.f1610h);
                hashMap.put(SpeechConstant.APP_ID, this.f1590b.f1608f);
            } else if (!TextUtils.isEmpty(this.f1590b.f1606d)) {
                hashMap.put("access_token", this.f1590b.f1606d);
            } else if (!TextUtils.isEmpty(this.f1590b.f1611i)) {
                hashMap.put("apikey", this.f1590b.f1611i);
            }
        } else if (!TextUtils.isEmpty(this.f1590b.f1610h)) {
            if (this.f1590b.f1607e.equals(this.f1589a.getPackageName())) {
                hashMap.put("pure_bduss", this.f1590b.f1610h);
            } else {
                hashMap.put("rsa_bduss", this.f1590b.f1610h);
            }
            hashMap.put(SpeechConstant.APP_ID, this.f1590b.f1608f);
        } else if (TextUtils.isEmpty(this.f1590b.f1606d)) {
            if (!TextUtils.isEmpty(this.f1590b.f1611i)) {
                hashMap.put("apikey", this.f1590b.f1611i);
            }
        } else if (this.f1590b.f1607e.equals(this.f1589a.getPackageName())) {
            hashMap.put("pure_access_token", this.f1590b.f1606d);
        } else {
            hashMap.put("rsa_access_token", this.f1590b.f1606d);
        }
    }

    /* renamed from: b */
    protected String mo1284b(String str) {
        return str;
    }

    /* renamed from: b */
    protected void m2074b() {
        if (this.f1590b == null || TextUtils.isEmpty(this.f1590b.f1603a)) {
            C0578p.m2546b("AbstractProcessor#execute#mEvent = null or mEvent.method = null", this.f1589a);
        } else if (!this.f1590b.f1603a.equals("com.baidu.android.pushservice.action.UNBIND") && !this.f1590b.f1603a.equals("method_sdk_unbind") && !this.f1590b.f1603a.equals("method_del_lapp_tags") && !this.f1590b.f1603a.equals("method_list_lapp_tags") && TextUtils.isEmpty(this.f1590b.f1607e) && !this.f1590b.f1603a.equals("com.baidu.android.pushservice.action.UNBINDAPP")) {
            C0578p.m2546b("AbstractProcessor#execute#Unknown method", this.f1589a);
        } else if (C0572k.m2461e(this.f1589a)) {
            if (C0430a.m1857b() > 0) {
                C0553q.m2360a(this.f1589a, "039914");
            }
            C0580j a = C0580j.m2614a(this.f1589a);
            synchronized (a) {
                if (a.m2620d() || !a.m2619c()) {
                    a.m2616a(this.f1589a, false, this.f1592d);
                    C0578p.m2546b("AbstractProcessor#requestToken#" + this.f1590b.toString(), this.f1589a);
                } else {
                    C0527a.m2219c("AbstractProcessor", "netWorkConnect connectResult: " + mo1283c(), this.f1589a);
                }
            }
        } else {
            C0527a.m2218b("AbstractProcessor", "Network is not useful!", this.f1589a);
            C0578p.m2546b("AbstractProcessor#execute#Network is unuseful!", this.f1589a);
            if (C0430a.m1857b() > 0) {
                C0553q.m2360a(this.f1589a, "039912");
            }
            m2068a(10001);
            C0577o.m2484a(this.f1589a, new Intent());
        }
    }

    /* renamed from: c */
    public boolean mo1283c() {
        boolean z = false;
        if (!TextUtils.isEmpty(this.f1591c)) {
            int i = 0;
            while (i <= 2) {
                int b = m2064b(i);
                if (b != 0) {
                    if (b != 10002) {
                        break;
                    }
                    if (i > 0) {
                        m2063a("030403", b);
                    } else {
                        m2063a("030401", b);
                    }
                    i++;
                } else {
                    z = true;
                    if (i > 0) {
                        m2063a("030402", b);
                    }
                }
            }
        } else {
            C0527a.m2218b("AbstractProcessor", "mUrl is null", this.f1589a);
        }
        return z;
    }
}
