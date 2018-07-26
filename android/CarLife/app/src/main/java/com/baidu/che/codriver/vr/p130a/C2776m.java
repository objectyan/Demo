package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.platform.navi.NaviCmdController;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2673m.C2752a;
import com.baidu.che.codriver.vr.C2673m.C2837c;
import com.baidu.che.codriver.vr.C2848p;

/* compiled from: NaviAddressInstructionCommand */
/* renamed from: com.baidu.che.codriver.vr.a.m */
public class C2776m extends C2747a {

    /* compiled from: NaviAddressInstructionCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.m$1 */
    class C27741 implements C2752a {
        /* renamed from: a */
        final /* synthetic */ C2776m f9101a;

        C27741(C2776m this$0) {
            this.f9101a = this$0;
        }

        /* renamed from: a */
        public void mo1964a() {
            C2761c.m10463a().m10471a(this.f9101a);
        }
    }

    /* compiled from: NaviAddressInstructionCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.m$2 */
    class C27752 implements C2752a {
        /* renamed from: a */
        final /* synthetic */ C2776m f9102a;

        C27752(C2776m this$0) {
            this.f9102a = this$0;
        }

        /* renamed from: a */
        public void mo1964a() {
            C2761c.m10463a().m10471a(this.f9102a);
        }
    }

    public C2776m(C2848p data, C2673m callback, Context context) {
        super(data, callback, context);
    }

    /* renamed from: h */
    public void mo1957h() {
        C2549b model = new C2549b();
        if ("set_home".equals(mo1954e()) || "set_work".equals(mo1954e())) {
            model.f8464f = C2695a.TYPE_NORMAL_REQ;
            model.f8468j = 1;
            model.f8469k = true;
            if ("set_home".equals(mo1954e())) {
                model.f8465g = this.d.getString(C0965R.string.navi_command_set_home_address);
                this.c.mo1930a(C2837c.STATE_SET_HOME);
            } else if ("set_work".equals(mo1954e())) {
                model.f8465g = this.d.getString(C0965R.string.navi_command_set_company_address);
                this.c.mo1930a(C2837c.STATE_SET_COMPANY);
            }
            this.c.mo1928a(model);
        } else if ("route_home".equals(mo1954e()) || "route_work".equals(mo1954e())) {
            model.f8464f = C2695a.TYPE_NORMAL_REQ;
            model.f8468j = 2;
            if ("route_home".equals(mo1954e())) {
                if (NaviCmdController.getInstance().isSetHomeAddress()) {
                    model.f8465g = this.d.getString(C0965R.string.navi_command_route_home);
                    this.c.mo1929a(model, new C27741(this), null);
                } else {
                    this.b.m10786b("set_home");
                    mo1957h();
                }
            }
            if (!"route_work".equals(mo1954e())) {
                return;
            }
            if (NaviCmdController.getInstance().isSetCompanyAddress()) {
                model.f8465g = this.d.getString(C0965R.string.navi_command_route_company);
                this.c.mo1929a(model, new C27752(this), null);
                return;
            }
            this.b.m10786b("set_work");
            mo1957h();
        }
    }

    /* renamed from: a */
    public void mo1959a(C2747a cmd) {
        super.mo1959a(cmd);
    }

    /* renamed from: j */
    protected void mo1958j() {
    }
}
