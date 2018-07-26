package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.message.C0626k;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.message.p033a.C0596c;
import com.baidu.android.pushservice.message.p033a.C0597a;
import com.baidu.android.pushservice.p022i.C0559d;
import com.baidu.android.pushservice.p023b.C0431a;
import com.baidu.android.pushservice.p023b.C0432b;
import com.baidu.android.pushservice.p023b.C0437f;
import com.baidu.android.pushservice.p023b.C0438g;
import com.baidu.android.pushservice.p023b.C0439h;
import com.baidu.android.pushservice.p025d.C0463a;
import com.baidu.android.pushservice.p026e.C0485a;
import com.baidu.android.pushservice.p026e.C0490f;
import com.baidu.android.pushservice.p026e.C0492h;
import com.baidu.android.pushservice.p026e.C0493i;
import com.baidu.android.pushservice.p026e.C0494j;
import com.baidu.android.pushservice.p026e.C0495k;
import com.baidu.android.pushservice.p026e.C0496l;
import com.baidu.android.pushservice.p026e.C0497m;
import com.baidu.android.pushservice.p026e.C0498n;
import com.baidu.android.pushservice.p026e.C0499o;
import com.baidu.android.pushservice.p026e.C0500p;
import com.baidu.android.pushservice.p026e.C0501q;
import com.baidu.android.pushservice.p026e.C0502r;
import com.baidu.android.pushservice.p026e.C0503s;
import com.baidu.android.pushservice.p026e.C0504t;
import com.baidu.android.pushservice.p026e.C0505u;
import com.baidu.android.pushservice.p026e.C0506v;
import com.baidu.android.pushservice.p026e.C0507w;
import com.baidu.android.pushservice.p026e.C0510y;
import com.baidu.android.pushservice.p026e.C0511z;
import com.baidu.android.pushservice.p028g.C0527a;
import com.baidu.android.pushservice.p029h.C0546l;
import com.baidu.android.pushservice.p029h.C0553q;
import com.baidu.android.pushservice.p031j.C0578p;

/* renamed from: com.baidu.android.pushservice.i */
public class C0560i {
    /* renamed from: c */
    private static C0560i f1845c;
    /* renamed from: a */
    private Context f1846a;
    /* renamed from: b */
    private C0553q f1847b;

    private C0560i(Context context) {
        this.f1846a = context;
        C0432b.m1870a(context);
        C0580j.m2614a(context);
        C0559d.m2387a();
    }

    /* renamed from: a */
    public static C0560i m2390a(Context context) {
        if (f1845c == null) {
            f1845c = new C0560i(context);
        }
        return f1845c;
    }

    /* renamed from: b */
    private void m2391b(Intent intent) {
        C0496l c0496l = new C0496l(intent);
        int intExtra = intent.getIntExtra("bind_status", 0);
        int intExtra2 = intent.getIntExtra("push_sdk_version", 0);
        C0527a.m2216a("RegistrationService", "<<< METHOD_BIND ", this.f1846a);
        C0578p.m2546b("RegistrationService#handleBind#METHOD_BIND request arrive at " + System.currentTimeMillis(), this.f1846a);
        String f = C0432b.m1870a(this.f1846a).m1887f(c0496l.f1607e);
        if (TextUtils.isEmpty(c0496l.f1611i) || !C0432b.m1870a(this.f1846a).m1884b(c0496l.f1607e, c0496l.f1611i) || TextUtils.isEmpty(f)) {
            boolean a;
            C0578p.m2546b("RegistrationService#handleBind#METHOD_BIND request start at " + System.currentTimeMillis(), this.f1846a);
            if (C0430a.m1857b() > 0) {
                C0553q.m2357a(this.f1846a, "039902", 0, f);
            }
            if (intent.hasExtra("bind_notify_status")) {
                a = m2416a(new C0490f(c0496l, this.f1846a, intExtra, intExtra2, intent.getStringExtra("bind_notify_status")));
                C0578p.m2546b("submitApiProcessor for bind=" + c0496l.toString(), this.f1846a);
            } else {
                a = m2416a(new C0490f(c0496l, this.f1846a, intExtra, intExtra2));
                C0578p.m2546b("submitApiProcessor for bind=" + c0496l.toString(), this.f1846a);
            }
            if (!a) {
                new Thread(new C0490f(c0496l, this.f1846a, intExtra, intExtra2)).start();
                C0578p.m2546b("submitApiProcessor failed bind " + c0496l.toString(), this.f1846a);
                return;
            }
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("method", c0496l.f1603a);
        intent2.putExtra(PushConstants.EXTRA_ERROR_CODE, 0);
        intent2.putExtra("content", f.getBytes());
        intent2.putExtra("bind_status", intExtra);
        if (C0430a.m1857b() > 0) {
            C0553q.m2357a(this.f1846a, "039902", 2, f);
        }
        C0578p.m2545b(this.f1846a, intent2, PushConstants.ACTION_RECEIVE, c0496l.f1607e);
        C0578p.m2546b("RegistrationService#handleBind#returned by cacheContent = " + f, this.f1846a);
    }

    /* renamed from: c */
    private void m2392c(Intent intent) {
        C0496l c0496l = new C0496l(intent);
        int intExtra = intent.getIntExtra("bind_status", 0);
        int intExtra2 = intent.getIntExtra("push_sdk_version", 0);
        int intExtra3 = intent.getIntExtra("sdk_client_version", 0);
        C0431a c0438g = new C0438g(c0496l.f1611i, c0496l.f1607e);
        c0438g.m1862a(intExtra3);
        C0439h.m1902a(this.f1846a).m1893a(c0438g, true);
        C0527a.m2216a("RegistrationService", "<<< METHOD_SDK_BIND ", this.f1846a);
        m2416a(new C0490f(c0496l, this.f1846a, intExtra, intExtra2));
    }

    /* renamed from: d */
    private void m2393d(Intent intent) {
        C0496l c0496l = new C0496l(intent);
        C0527a.m2216a("RegistrationService", "<<< METHOD_UNBIND ", this.f1846a);
        if (!(TextUtils.isEmpty(c0496l.f1607e) || TextUtils.isEmpty(c0496l.f1611i))) {
            C0437f c = C0432b.m1870a(this.f1846a).m1885c(c0496l.f1607e);
            if (!(c == null || TextUtils.isEmpty(c.m1861a()))) {
                c0496l.f1608f = c.m1861a();
            }
            C0432b.m1870a(this.f1846a).m1888g(c0496l.f1607e);
        }
        m2416a(new C0510y(c0496l, this.f1846a));
    }

    /* renamed from: e */
    private void m2394e(Intent intent) {
        C0496l c0496l = new C0496l(intent);
        C0527a.m2216a("RegistrationService", "<<< METHOD_SDK_UNBIND ", this.f1846a);
        m2416a(new C0510y(c0496l, this.f1846a));
    }

    /* renamed from: f */
    private void m2395f(Intent intent) {
        m2416a(new C0510y(new C0496l(intent), this.f1846a));
    }

    /* renamed from: g */
    private boolean m2396g(Intent intent) {
        Object stringExtra = intent.getStringExtra("package_name");
        Object stringExtra2 = intent.getStringExtra("app_id");
        if (TextUtils.isEmpty(stringExtra2)) {
            C0437f c = C0432b.m1870a(this.f1846a).m1885c(stringExtra);
            if (c != null) {
                stringExtra2 = c.m1861a();
            }
        }
        Object stringExtra3 = intent.getStringExtra("user_id");
        PushSettings.m1826c(this.f1846a, stringExtra);
        C0496l c0496l = new C0496l();
        c0496l.f1603a = "com.baidu.android.pushservice.action.UNBINDAPP";
        if (!TextUtils.isEmpty(stringExtra)) {
            c0496l.f1607e = stringExtra;
        }
        if (!(TextUtils.isEmpty(stringExtra2) || "null".equals(stringExtra2))) {
            c0496l.f1608f = stringExtra2;
        }
        if (!(TextUtils.isEmpty(stringExtra3) || "null".equals(stringExtra3))) {
            c0496l.f1609g = stringExtra3;
        }
        if (!TextUtils.isEmpty(c0496l.f1607e)) {
            C0437f c2 = C0432b.m1870a(this.f1846a).m1885c(c0496l.f1607e);
            if (!(c2 == null || TextUtils.isEmpty(c2.m1861a()))) {
                c0496l.f1608f = c2.m1861a();
            }
            C0432b.m1870a(this.f1846a).m1888g(c0496l.f1607e);
        }
        return m2416a(new C0511z(c0496l, this.f1846a));
    }

    /* renamed from: h */
    private void m2397h(Intent intent) {
        C0496l c0496l = new C0496l(intent);
        int intExtra = intent.getIntExtra("fetch_type", 1);
        int intExtra2 = intent.getIntExtra("fetch_num", 1);
        C0527a.m2216a("RegistrationService", "<<< METHOD_FETCH ", this.f1846a);
        m2416a(new C0497m(c0496l, this.f1846a, intExtra, intExtra2));
    }

    /* renamed from: i */
    private void m2398i(Intent intent) {
        C0496l c0496l = new C0496l(intent);
        C0527a.m2216a("RegistrationService", "<<< METHOD_COUNT ", this.f1846a);
        m2416a(new C0492h(c0496l, this.f1846a));
    }

    /* renamed from: j */
    private void m2399j(Intent intent) {
        C0496l c0496l = new C0496l(intent);
        String[] stringArrayExtra = intent.getStringArrayExtra("msg_ids");
        C0527a.m2216a("RegistrationService", "<<< METHOD_DELETE ", this.f1846a);
        m2416a(new C0495k(c0496l, this.f1846a, stringArrayExtra));
    }

    /* renamed from: k */
    private void m2400k(Intent intent) {
        C0496l c0496l = new C0496l(intent);
        String stringExtra = intent.getStringExtra("gid");
        C0527a.m2216a("RegistrationService", "<<< ACTION_GBIND ", this.f1846a);
        m2416a(new C0499o(c0496l, this.f1846a, stringExtra));
    }

    /* renamed from: l */
    private void m2401l(Intent intent) {
        C0496l c0496l = new C0496l(intent);
        String stringExtra = intent.getStringExtra("tags");
        C0527a.m2216a("RegistrationService", "<<< ACTION_SET_TAGS ", this.f1846a);
        m2416a(new C0507w(c0496l, this.f1846a, stringExtra));
    }

    /* renamed from: m */
    private void m2402m(Intent intent) {
        C0496l c0496l = new C0496l(intent);
        String stringExtra = intent.getStringExtra("tags");
        C0527a.m2216a("RegistrationService", "<<< ACTION_GBIND ", this.f1846a);
        m2416a(new C0494j(c0496l, this.f1846a, stringExtra));
    }

    /* renamed from: n */
    private void m2403n(Intent intent) {
        C0496l c0496l = new C0496l(intent);
        String stringExtra = intent.getStringExtra("gid");
        C0527a.m2216a("RegistrationService", "<<< ACTION_GUNBIND ", this.f1846a);
        m2416a(new C0502r(c0496l, this.f1846a, stringExtra));
    }

    /* renamed from: o */
    private void m2404o(Intent intent) {
        C0496l c0496l = new C0496l(intent);
        String stringExtra = intent.getStringExtra("gid");
        C0527a.m2216a("RegistrationService", "<<< METHOD_GINFO ", this.f1846a);
        m2416a(new C0500p(c0496l, this.f1846a, stringExtra));
    }

    /* renamed from: p */
    private void m2405p(Intent intent) {
        C0496l c0496l = new C0496l(intent);
        C0527a.m2216a("RegistrationService", "<<< METHOD_LISTTAGS ", this.f1846a);
        m2416a(new C0503s(c0496l, this.f1846a));
    }

    /* renamed from: q */
    private void m2406q(Intent intent) {
        C0496l c0496l = new C0496l(intent);
        C0527a.m2216a("RegistrationService", "<<< METHOD_GLIST ", this.f1846a);
        m2416a(new C0501q(c0496l, this.f1846a));
    }

    /* renamed from: r */
    private void m2407r(Intent intent) {
        C0496l c0496l = new C0496l(intent);
        String stringExtra = intent.getStringExtra("gid");
        int intExtra = intent.getIntExtra("group_fetch_type", 1);
        int intExtra2 = intent.getIntExtra("group_fetch_num", 1);
        C0527a.m2216a("RegistrationService", "<<< METHOD_FETCHGMSG ", this.f1846a);
        m2416a(new C0498n(c0496l, this.f1846a, stringExtra, intExtra, intExtra2));
    }

    /* renamed from: s */
    private void m2408s(Intent intent) {
        C0496l c0496l = new C0496l(intent);
        String stringExtra = intent.getStringExtra("gid");
        C0527a.m2216a("RegistrationService", "<<< METHOD_COUNTGMSG ", this.f1846a);
        m2416a(new C0493i(c0496l, this.f1846a, stringExtra));
    }

    /* renamed from: t */
    private void m2409t(Intent intent) {
        C0496l c0496l = new C0496l(intent);
        C0527a.m2216a("RegistrationService", "<<< METHOD_ONLINE ", this.f1846a);
        m2416a(new C0504t(c0496l, this.f1846a));
    }

    /* renamed from: u */
    private void m2410u(Intent intent) {
        C0496l c0496l = new C0496l(intent);
        C0527a.m2216a("RegistrationService", "<<< METHOD_SEND ", this.f1846a);
        m2416a(new C0505u(c0496l, this.f1846a, intent.getStringExtra("push_ msg")));
    }

    /* renamed from: v */
    private void m2411v(Intent intent) {
        C0496l c0496l = new C0496l(intent);
        C0527a.m2216a("RegistrationService", "<<< METHOD_SEND_MSG_TO_USER ", this.f1846a);
        m2416a(new C0506v(c0496l, this.f1846a, intent.getStringExtra("app_id"), intent.getStringExtra("user_id"), intent.getStringExtra("push_ msg_key"), intent.getStringExtra("push_ msg")));
    }

    /* renamed from: w */
    private void m2412w(Intent intent) {
        if (this.f1847b == null) {
            this.f1847b = new C0553q(this.f1846a);
        }
        this.f1847b.m2367a();
        this.f1847b.m2368a(false, null);
    }

    /* renamed from: x */
    private void m2413x(Intent intent) {
        if (this.f1847b == null) {
            this.f1847b = new C0553q(this.f1846a);
        }
        this.f1847b.m2368a(intent.getBooleanExtra("force_send", false), null);
    }

    /* renamed from: y */
    private void m2414y(Intent intent) {
        PushSettings.m1817a(this.f1846a, 0);
    }

    /* renamed from: a */
    public boolean m2415a(Intent intent) {
        String str = null;
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            return false;
        }
        String action = intent.getAction();
        C0578p.m2546b("handleIntent#action = " + action, this.f1846a);
        if ("com.baidu.android.pushservice.action.OPENDEBUGMODE".equals(action)) {
            PushSettings.enableDebugMode(this.f1846a, true);
            C0527a.m2216a("RegistrationService", "<<<debugMode is open", this.f1846a);
            return true;
        } else if ("com.baidu.android.pushservice.action.CLOSEDEBUGMODE".equals(action)) {
            PushSettings.enableDebugMode(this.f1846a, false);
            C0527a.m2216a("RegistrationService", "<<<debugMode is close", this.f1846a);
            return true;
        } else if ("com.baidu.pushservice.action.publicmsg.CLICK_V2".equals(action) || "com.baidu.pushservice.action.publicmsg.DELETE_V2".equals(action)) {
            ((PublicMsg) intent.getParcelableExtra("public_msg")).handle(this.f1846a, action, intent.getData().getHost());
            return true;
        } else if ("com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) || "com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
            PublicMsg publicMsg = (PublicMsg) intent.getParcelableExtra("public_msg");
            if (!C0578p.m2548b(this.f1846a, publicMsg)) {
                return true;
            }
            publicMsg.handlePrivateNotification(this.f1846a, action, intent.getStringExtra("msg_id"), intent.getStringExtra("app_id"), intent.getByteArrayExtra("baidu_message_secur_info"), intent.getByteArrayExtra("baidu_message_body"));
            return true;
        } else if ("com.baidu.android.pushservice.action.passthrough.notification.CLICK".equals(action) || "com.baidu.android.pushservice.action.passthrough.notification.DELETE".equals(action) || "com.baidu.android.pushservice.action.passthrough.notification.NOTIFIED".equals(action)) {
            C0578p.m2546b("push_passthrough: receive  click delete and notified action", this.f1846a);
            r0 = intent.hasExtra("app_id") ? intent.getStringExtra("app_id") : null;
            if (intent.hasExtra("msg_id")) {
                str = intent.getStringExtra("msg_id");
            }
            C0546l.m2333a(this.f1846a, str, r0, action);
            return true;
        } else if ("com.baidu.android.pushservice.action.media.CLICK".equals(action) || "com.baidu.android.pushservice.action.media.DELETE".equals(action)) {
            ((PublicMsg) intent.getParcelableExtra("public_msg")).handleRichMediaNotification(this.f1846a, action, intent.getStringExtra("app_id"));
            return true;
        } else if ("com.baidu.android.pushservice.action.lightapp.notification.CLICK".equals(action) || "com.baidu.android.pushservice.action.lightapp.notification.DELETE".equals(action)) {
            return true;
        } else {
            if ("com.baidu.android.pushservice.action.alarm.message".equals(action)) {
                C0626k c0626k = (C0626k) intent.getSerializableExtra("tinyMessageHead");
                byte[] byteArrayExtra = intent.getByteArrayExtra("msgBody");
                c0626k.m2756a(false);
                if (C0463a.m2008c(this.f1846a, c0626k.m2769h()).f1736f == 0) {
                    C0463a.m2011d(this.f1846a, c0626k.m2769h());
                    return true;
                }
                C0596c c0597a = new C0597a(this.f1846a);
                if (c0597a != null) {
                    c0597a.mo1294a(c0626k, byteArrayExtra);
                }
            }
            if ("com.baidu.pushservice.action.TOKEN".equals(action)) {
                C0527a.m2216a("RegistrationService", "<<< ACTION_TOKEN ", this.f1846a);
                if (C0580j.m2614a(this.f1846a).m2619c()) {
                    return true;
                }
                C0580j.m2614a(this.f1846a).m2616a(this.f1846a, true, null);
                return true;
            } else if (!PushConstants.ACTION_METHOD.equals(action)) {
                return false;
            } else {
                boolean z;
                r0 = intent.getStringExtra("method");
                if (PushConstants.METHOD_BIND.equals(r0)) {
                    m2391b(intent);
                    z = true;
                } else if ("method_webapp_bind_from_deeplink".equals(r0)) {
                    z = true;
                } else if ("method_deal_webapp_bind_intent".equals(r0)) {
                    z = true;
                } else if ("method_deal_lapp_bind_intent".equals(r0)) {
                    z = true;
                } else if ("method_get_lapp_bind_state".equals(r0)) {
                    z = true;
                } else if ("method_sdk_bind".equals(r0)) {
                    m2392c(intent);
                    z = true;
                } else if ("method_unbind".equals(r0)) {
                    m2393d(intent);
                    z = true;
                } else if ("method_sdk_unbind".equals(r0)) {
                    m2394e(intent);
                    z = true;
                } else if ("method_lapp_unbind".equals(r0)) {
                    m2395f(intent);
                    z = true;
                } else if ("com.baidu.android.pushservice.action.UNBINDAPP".equals(r0)) {
                    m2396g(intent);
                    z = true;
                } else if ("method_fetch".equals(r0)) {
                    m2397h(intent);
                    z = true;
                } else if ("method_count".equals(r0)) {
                    m2398i(intent);
                    z = true;
                } else if ("method_delete".equals(r0)) {
                    m2399j(intent);
                    z = true;
                } else if ("method_gbind".equals(r0)) {
                    m2400k(intent);
                    z = true;
                } else if ("method_set_tags".equals(r0) || "method_set_sdk_tags".equals(r0) || "method_set_lapp_tags".equals(r0)) {
                    m2401l(intent);
                    z = true;
                } else if ("method_del_tags".equals(r0) || "method_del_sdk_tags".equals(r0) || "method_del_lapp_tags".equals(r0)) {
                    m2402m(intent);
                    z = true;
                } else if ("method_gunbind".equals(r0)) {
                    m2403n(intent);
                    z = true;
                } else if ("method_ginfo".equals(r0)) {
                    m2404o(intent);
                    z = true;
                } else if ("method_glist".equals(r0)) {
                    m2406q(intent);
                    z = true;
                } else if ("method_listtags".equals(r0) || "method_list_sdk_tags".equals(r0) || "method_list_lapp_tags".equals(r0)) {
                    m2405p(intent);
                    z = true;
                } else if ("method_fetchgmsg".equals(r0)) {
                    m2407r(intent);
                    z = true;
                } else if ("method_countgmsg".equals(r0)) {
                    m2408s(intent);
                    z = true;
                } else if ("method_online".equals(r0)) {
                    m2409t(intent);
                    z = true;
                } else if ("method_send".equals(r0)) {
                    m2410u(intent);
                    z = true;
                } else if ("com.baidu.android.pushservice.action.SEND_APPSTAT".equals(r0)) {
                    m2412w(intent);
                    z = true;
                } else if ("com.baidu.android.pushservice.action.SEND_LBS".equals(r0)) {
                    m2413x(intent);
                    z = true;
                } else if ("com.baidu.android.pushservice.action.ENBALE_APPSTAT".equals(r0)) {
                    m2414y(intent);
                    z = true;
                } else if ("method_send_msg_to_user".equals(r0)) {
                    m2411v(intent);
                    z = true;
                } else {
                    z = false;
                }
                return z;
            }
        }
    }

    /* renamed from: a */
    public boolean m2416a(C0485a c0485a) {
        try {
            C0559d.m2387a().m2388a(c0485a);
            return true;
        } catch (Throwable e) {
            C0527a.m2217a("RegistrationService", e, this.f1846a);
            return false;
        }
    }
}
