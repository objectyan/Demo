package com.baidu.android.pushservice.message;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.message.p033a.C0596c;
import com.baidu.android.pushservice.message.p033a.C0611k;
import com.baidu.android.pushservice.message.p033a.C0612l;
import com.baidu.android.pushservice.p022i.C0420c;
import com.baidu.android.pushservice.p022i.C0559d;
import com.baidu.android.pushservice.p025d.C0463a;
import com.baidu.android.pushservice.p025d.C0472c;
import com.baidu.android.pushservice.p028g.C0527a;
import com.baidu.android.pushservice.p029h.C0544j;
import com.baidu.android.pushservice.p029h.C0546l;
import com.baidu.android.pushservice.p031j.C0569h;
import com.baidu.android.pushservice.p031j.C0578p;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.message.j */
public class C0625j extends C0616c {
    /* renamed from: b */
    private Context f1968b;

    public C0625j(Context context) {
        super(context);
        this.f1968b = context.getApplicationContext();
    }

    /* renamed from: a */
    private String m2751a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        int i = 0;
        while (i < bArr.length) {
            if (bArr[i] == (byte) 0) {
                break;
            }
            i++;
        }
        i = 0;
        return new String(bArr, 0, i);
    }

    /* renamed from: a */
    public C0621g mo1295a(C0619e c0619e) {
        c0619e.f1937e = true;
        C0621g c0621g = new C0621g();
        int i = -1;
        c0621g.m2740a(-1);
        Object obj = c0619e.f1935c;
        if (obj == null) {
            return c0621g;
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(obj);
        C0569h c0569h = new C0569h(byteArrayInputStream);
        try {
            C0626k c0626k = new C0626k();
            byte[] bArr = new byte[128];
            c0569h.m2447a(bArr);
            c0626k.m2755a(m2751a(bArr));
            c0626k.m2765d(c0569h.m2450d());
            int c = c0569h.m2449c();
            c0626k.m2753a(c);
            i = c0569h.m2449c();
            byte[] bArr2 = new byte[64];
            c0569h.m2447a(bArr2);
            c0626k.m2757a(bArr2);
            if (i > 0) {
                String str = "";
                bArr2 = new byte[i];
                c0569h.m2447a(bArr2);
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr2));
                    if (!jSONObject.isNull("package_name")) {
                        String string = jSONObject.getString("package_name");
                        if (!TextUtils.isEmpty(string)) {
                            c0626k.m2761b(string);
                        }
                    }
                    if (!jSONObject.isNull("expiretime")) {
                        c0626k.m2763c(jSONObject.getLong("expiretime"));
                    }
                    if (C0612l.MSG_TYPE_ALARM_NOTIFICATION.m2706a() == c || C0612l.MSG_TYPE_ALARM_MESSAGE.m2706a() == c || C0612l.MSG_TYPE_ALARM_AD_NOTIFICATION.m2706a() == c) {
                        c0626k.m2756a(true);
                        C0559d.m2387a().m2388a(new C0420c(this, "deleteInvalidAlarmMsg", (short) 95) {
                            /* renamed from: a */
                            final /* synthetic */ C0625j f1967a;

                            /* renamed from: a */
                            public void mo1272a() {
                                C0463a.m2009c(this.f1967a.a);
                            }
                        });
                        if (!jSONObject.isNull("alarmmsgid")) {
                            String string2 = jSONObject.getString("alarmmsgid");
                            if (!jSONObject.isNull("alarmmsgenable")) {
                                c = C0463a.m1985a(this.a, string2, jSONObject.getInt("alarmmsgenable"));
                                c0619e.m2720a(c0626k);
                                c0621g.m2740a(c < 0 ? 3 : 0);
                                return c0621g;
                            }
                        }
                        if (!jSONObject.isNull("sendtime")) {
                            c0626k.m2754a(jSONObject.getLong("sendtime"));
                        }
                        if (!jSONObject.isNull("showtime")) {
                            c0626k.m2760b(jSONObject.getLong("showtime"));
                        }
                    } else {
                        c0626k.m2756a(false);
                    }
                } catch (JSONException e) {
                }
            } else {
                c0626k.m2756a(false);
            }
            byteArrayInputStream.close();
            c0569h.m2446a();
            c0619e.m2720a(c0626k);
            if (i <= 0) {
                i = 0;
            }
            c = i + 204;
            i = obj.length - c;
            if (i <= 0) {
                i = 0;
            }
            Object obj2 = new byte[i];
            System.arraycopy(obj, c, obj2, 0, i);
            C0578p.m2546b("New MSG: " + c0626k.toString(), this.a);
            if (C0472c.m2034c(this.a, c0626k.m2768g())) {
                C0527a.m2216a("PushMessageHandler", "Message ID(" + c0626k.m2769h() + ") received duplicated, ack success to server directly.", this.f1968b);
                C0546l.m2332a(this.a, c0626k.m2766e(), c0626k.m2769h(), c0626k.m2770i(), obj2, 4, C0544j.f1797a);
                c0621g.m2740a(4);
                return c0621g;
            }
            C0621g a;
            C0612l a2 = C0612l.m2705a(c0626k.m2770i());
            C0596c a3 = new C0611k(this.a).m2704a(a2);
            if (a3 != null) {
                a = a3.mo1294a(c0626k, obj2);
            } else {
                c0621g.m2740a(2);
                a = c0621g;
            }
            if (a2 == C0612l.MSG_TYPE_SINGLE_PRIVATE || a2 == C0612l.MSG_TYPE_MULTI_PRIVATE || a2 == C0612l.MSG_TYPE_PRIVATE_MESSAGE) {
                C0472c.m2025a(this.a, c0626k.m2766e(), c0626k.m2770i(), c0626k.m2768g(), obj2, c0626k.m2771j(), c0626k.m2764d(), a.m2739a());
            } else {
                C0472c.m2025a(this.a, c0626k.m2766e(), c0626k.m2770i(), c0626k.m2768g(), null, null, 0, a.m2739a());
            }
            String str2;
            if (C0578p.m2502F(this.a)) {
                str2 = "V3";
            } else {
                str2 = "V2";
            }
            C0546l.m2332a(this.a, c0626k.m2766e(), c0626k.m2769h(), c0626k.m2770i(), obj2, a.m2739a(), C0544j.f1797a);
            return a;
        } catch (IOException e2) {
            return c0621g;
        }
    }
}
