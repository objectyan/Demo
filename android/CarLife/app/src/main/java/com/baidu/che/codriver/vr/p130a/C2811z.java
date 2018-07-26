package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.model.C1942q;
import com.baidu.che.codriver.p121g.C2536a;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.platform.PlatformManager;
import com.baidu.che.codriver.sdk.p081a.C2602k;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.ui.p128b.C2674b;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.C2736p;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2673m.C2752a;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SystemControlCommand */
/* renamed from: com.baidu.che.codriver.vr.a.z */
public class C2811z extends C2747a {
    /* renamed from: e */
    private static final String f9182e = "__";
    /* renamed from: f */
    private String f9183f;
    /* renamed from: g */
    private C1981b f9184g = C2602k.m9819a().m9822b();

    /* compiled from: SystemControlCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.z$1 */
    class C28081 implements C2752a {
        /* renamed from: a */
        final /* synthetic */ C2811z f9178a;

        C28081(C2811z this$0) {
            this.f9178a = this$0;
        }

        /* renamed from: a */
        public void mo1964a() {
            PlatformManager.getInstance().sendNaviCommand(NaviCmdConstants.KEY_NAVI_START_APP, Boolean.valueOf(true));
        }
    }

    /* compiled from: SystemControlCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.z$2 */
    class C28092 implements C2752a {
        /* renamed from: a */
        final /* synthetic */ C2811z f9179a;

        C28092(C2811z this$0) {
            this.f9179a = this$0;
        }

        /* renamed from: a */
        public void mo1964a() {
            PlatformManager.getInstance().sendNaviCommand(NaviCmdConstants.KEY_NAVI_EXIT_APP, Boolean.valueOf(false));
        }
    }

    public C2811z(C2848p data, C2673m callback, Context context) {
        super(data, callback, context);
        C2716c.m10143a(this.d, C2536a.f8314o);
    }

    /* renamed from: h */
    public void mo1957h() {
        C2549b model = new C2549b();
        if ("app".equals(mo1953d()) && (C2736p.f8976f.equals(this.f9183f) || C1942q.f6155w.equals(this.f9183f))) {
            if ("open".equals(mo1954e())) {
                model.f8468j = 2;
                this.c.mo1929a(model, new C28081(this), null);
                return;
            } else if ("close".equals(mo1954e())) {
                String string;
                model.f8468j = 1;
                if (BNavigator.getInstance().isNaviBegin()) {
                    string = this.d.getString(C0965R.string.navi_command_quit_app);
                } else {
                    string = this.d.getString(C0965R.string.navi_command_start_navi_first);
                }
                model.f8465g = string;
                this.c.mo1929a(model, new C28092(this), null);
                return;
            }
        }
        final boolean isVrDialogShow = C2674b.m9985b().m10040q();
        if (this.f9184g != null) {
            model.f8468j = 2;
            this.c.mo1929a(model, new C2752a(this) {
                /* renamed from: b */
                final /* synthetic */ C2811z f9181b;

                /* renamed from: a */
                public void mo1964a() {
                    boolean z = true;
                    String e = this.f9181b.mo1954e();
                    boolean z2 = true;
                    switch (e.hashCode()) {
                        case -2128282144:
                            if (e.equals(C2848p.f9283J)) {
                                z2 = true;
                                break;
                            }
                            break;
                        case -1634172742:
                            if (e.equals(C2848p.f9286M)) {
                                z2 = true;
                                break;
                            }
                            break;
                        case -1263072892:
                            if (e.equals("operate")) {
                                z2 = true;
                                break;
                            }
                            break;
                        case -1099813314:
                            if (e.equals(C2848p.f9289P)) {
                                z2 = true;
                                break;
                            }
                            break;
                        case -905789153:
                            if (e.equals(C2848p.ag)) {
                                z2 = true;
                                break;
                            }
                            break;
                        case -875211097:
                            if (e.equals(C2848p.f9284K)) {
                                z2 = true;
                                break;
                            }
                            break;
                        case -209033685:
                            if (e.equals(C2848p.f9288O)) {
                                z2 = true;
                                break;
                            }
                            break;
                        case 3198448:
                            if (e.equals(C2848p.ah)) {
                                z2 = true;
                                break;
                            }
                            break;
                        case 3417674:
                            if (e.equals("open")) {
                                z2 = true;
                                break;
                            }
                            break;
                        case 3619493:
                            if (e.equals("view")) {
                                z2 = false;
                                break;
                            }
                            break;
                        case 94756344:
                            if (e.equals("close")) {
                                z2 = true;
                                break;
                            }
                            break;
                        case 991960676:
                            if (e.equals(C2848p.f9287N)) {
                                z2 = true;
                                break;
                            }
                            break;
                        case 1222632069:
                            if (e.equals(C2848p.f9285L)) {
                                z2 = true;
                                break;
                            }
                            break;
                        case 1334812983:
                            if (e.equals("back_home")) {
                                z2 = true;
                                break;
                            }
                            break;
                        case 1468997897:
                            if (e.equals(C2848p.f9290Q)) {
                                z2 = true;
                                break;
                            }
                            break;
                    }
                    C1981b a;
                    switch (z2) {
                        case false:
                            a = this.f9181b.f9184g;
                            e = "telephone";
                            if (isVrDialogShow) {
                                z = false;
                            }
                            a.mo1728a(e, z);
                            return;
                        case true:
                            this.f9181b.f9184g.mo1733f(this.f9181b.f9183f);
                            return;
                        case true:
                            a = this.f9181b.f9184g;
                            e = "home";
                            if (isVrDialogShow) {
                                z = false;
                            }
                            a.mo1728a(e, z);
                            return;
                        case true:
                            a = this.f9181b.f9184g;
                            e = this.f9181b.f9183f;
                            if (isVrDialogShow) {
                                z = false;
                            }
                            a.mo1728a(e, z);
                            return;
                        case true:
                            this.f9181b.f9184g.mo1727a(this.f9181b.f9183f);
                            return;
                        case true:
                            try {
                                JSONObject result = new JSONObject(this.f9181b.mo1956g());
                                if (result.has("wind_flow")) {
                                    this.f9181b.f9184g.mo1733f("wind_flow__" + this.f9181b.f9183f);
                                    return;
                                } else if (result.has("wind_direction")) {
                                    this.f9181b.f9184g.mo1733f("wind_direction__" + this.f9181b.f9183f);
                                    return;
                                } else if (result.has("temp")) {
                                    this.f9181b.f9184g.mo1733f("temp__" + this.f9181b.f9183f);
                                    return;
                                } else {
                                    return;
                                }
                            } catch (Exception e2) {
                                C2725h.m10214e(C2747a.f9028a, "parse system command params error");
                                return;
                            }
                        case true:
                            this.f9181b.f9184g.mo1733f("heat_temp__" + this.f9181b.f9183f);
                            return;
                        case true:
                            this.f9181b.f9184g.mo1732e(C1981b.f6364d);
                            return;
                        case true:
                            this.f9181b.f9184g.mo1731d(C1981b.f6364d);
                            return;
                        case true:
                            this.f9181b.f9184g.mo1730c(C1981b.f6364d);
                            return;
                        case true:
                            this.f9181b.f9184g.mo1729b(C1981b.f6364d);
                            return;
                        case true:
                            this.f9181b.f9184g.mo1731d(C1981b.f6362b);
                            return;
                        case true:
                            this.f9181b.f9184g.mo1732e(C1981b.f6362b);
                            return;
                        case true:
                            this.f9181b.f9184g.mo1730c(C1981b.f6362b);
                            return;
                        case true:
                            this.f9181b.f9184g.mo1729b(C1981b.f6362b);
                            return;
                        default:
                            return;
                    }
                }
            }, null);
            return;
        }
        model.f8464f = C2695a.TYPE_NORMAL_REQ;
        model.f8465g = this.d.getString(C0965R.string.no_this_ability);
        model.f8468j = 1;
        this.c.mo1928a(model);
    }

    /* renamed from: a */
    public void mo1959a(C2747a cmd) {
    }

    /* renamed from: i */
    protected void mo1960i() {
    }

    /* renamed from: j */
    protected void mo1958j() {
        try {
            JSONObject json = new JSONObject(mo1956g());
            this.f9183f = json.optString("function", "");
            this.f9183f += json.optString("appname", "");
            this.f9183f += json.optString("item", "");
            this.f9183f += json.optString("wind_flow", "");
            this.f9183f += json.optString("wind_direction", "");
            this.f9183f += json.optString("temp", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: k */
    protected JSONObject mo1961k() {
        return null;
    }
}
