package com.baidu.android.pushservice.p029h;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.C0580j;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.p022i.C0420c;
import com.baidu.android.pushservice.p022i.C0559d;
import com.baidu.android.pushservice.p026e.C0486b;
import com.baidu.android.pushservice.p027f.C0520a;
import com.baidu.android.pushservice.p027f.C0521b;
import com.baidu.android.pushservice.p029h.p030a.C0532b;
import com.baidu.android.pushservice.p031j.C0572k;
import com.baidu.navi.track.sync.SyncChannelConstant.Key;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import java.io.Closeable;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.h.m */
public abstract class C0540m {
    /* renamed from: a */
    protected Context f1784a;
    /* renamed from: b */
    protected String f1785b;
    /* renamed from: c */
    private boolean f1786c = false;
    /* renamed from: d */
    private boolean f1787d;

    public C0540m(Context context) {
        this.f1784a = context.getApplicationContext();
        this.f1787d = false;
    }

    /* renamed from: c */
    private void m2307c(boolean z) {
        Throwable th;
        Closeable closeable;
        Throwable th2;
        if (!TextUtils.isEmpty(this.f1785b)) {
            Closeable closeable2 = null;
            long j = 1000;
            try {
                String a = mo1289a(z);
                if (!TextUtils.isEmpty(a)) {
                    if (!mo1293b()) {
                        this.f1785b += C0580j.m2614a(this.f1784a).m2615a();
                    }
                    HashMap hashMap = new HashMap();
                    C0486b.m2078a(hashMap);
                    mo1291a(a, hashMap);
                    int i = 0;
                    while (i < 2) {
                        try {
                            C0520a a2 = C0521b.m2163a(this.f1785b, "POST", hashMap);
                            int b = a2.m2162b();
                            closeable2 = a2.m2159a();
                            String a3 = C0532b.m2252a((InputStream) closeable2);
                            if (b == 200) {
                                m2312b(a3);
                                break;
                            } else if (b == 201) {
                                m2315c(a3);
                                break;
                            } else if (b == 403) {
                                m2317d(a3);
                                break;
                            } else {
                                j += (long) (i * 300);
                                Thread.sleep(j);
                                i++;
                            }
                        } catch (Exception e) {
                            C0521b.m2169a(closeable2);
                        } catch (Throwable th3) {
                            th = th3;
                            closeable = closeable2;
                            th2 = th;
                        }
                    }
                }
                C0521b.m2169a(r0);
            } catch (Exception e2) {
                C0521b.m2169a(closeable2);
            } catch (Throwable th32) {
                th = th32;
                Object obj = null;
                th2 = th;
                C0521b.m2169a(closeable);
                throw th2;
            }
        }
    }

    /* renamed from: a */
    abstract String mo1289a(boolean z);

    /* renamed from: a */
    abstract void mo1290a(String str);

    /* renamed from: a */
    abstract void mo1291a(String str, HashMap<String, String> hashMap);

    /* renamed from: a */
    abstract boolean mo1292a();

    /* renamed from: b */
    public void m2312b(String str) {
        mo1290a(str);
    }

    /* renamed from: b */
    public synchronized void m2313b(final boolean z) {
        if (!this.f1786c) {
            if (mo1292a() && C0580j.m2614a(this.f1784a).m2619c()) {
                this.f1786c = true;
                C0559d.m2387a().m2388a(new C0420c(this, "PushService-stats-sender", (short) 90) {
                    /* renamed from: b */
                    final /* synthetic */ C0540m f1808b;

                    /* renamed from: a */
                    public void mo1272a() {
                        if (C0572k.m2461e(this.f1808b.f1784a)) {
                            this.f1808b.m2307c(z);
                            this.f1808b.f1786c = false;
                        }
                    }
                });
            }
        }
    }

    /* renamed from: b */
    abstract boolean mo1293b();

    /* renamed from: c */
    public void m2315c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i = jSONObject.getInt("config_type");
                int i2 = jSONObject.getInt(Key.INTERVAL);
                if (i == 0) {
                    if (i2 > 0) {
                        PushSettings.m1822b(this.f1784a, i2);
                    }
                } else if (i != 1 && i == 2) {
                }
            } catch (JSONException e) {
            }
        }
    }

    /* renamed from: c */
    public boolean m2316c() {
        return this.f1787d;
    }

    /* renamed from: d */
    public void m2317d(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i = jSONObject.getInt("error_code");
                jSONObject.getString(PushConstants.EXTRA_ERROR_CODE);
                if (i == NaviStatConstants.K_NSC_ACTION_BEHAVIOUR_EDOG) {
                    PushSettings.m1834j(this.f1784a);
                }
            } catch (JSONException e) {
            }
        }
    }
}
