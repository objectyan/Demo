package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.sdk.p081a.C2595h;
import com.baidu.che.codriver.sdk.p081a.C2595h.C1878b;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2673m.C2837c;
import com.baidu.che.codriver.vr.C2848p;

/* compiled from: NavigationCommand */
/* renamed from: com.baidu.che.codriver.vr.a.o */
public class C2780o extends C2747a {
    /* renamed from: f */
    private static final String f9105f = "OperatorCommand";
    /* renamed from: e */
    boolean f9106e = false;
    /* renamed from: g */
    private String f9107g;
    /* renamed from: h */
    private String f9108h;
    /* renamed from: i */
    private String f9109i;
    /* renamed from: j */
    private String f9110j;
    /* renamed from: k */
    private NLPResponseData f9111k = null;
    /* renamed from: l */
    private C1878b f9112l = C2595h.m9801a().m9803b();

    public C2780o(C2848p data, C2673m callback, Context context) {
        super(data, callback, context);
    }

    /* renamed from: j */
    protected void mo1958j() {
    }

    /* renamed from: a */
    public void mo1959a(C2747a newCommand) {
        C2725h.m10207b(f9105f, "NaviGationCommand ------merge()------------");
    }

    /* renamed from: h */
    public void mo1957h() {
        if (this.f9112l != null) {
            C2549b model = new C2549b();
            if (this.f9112l.mo1699a()) {
                model.f8464f = C2695a.TYPE_NORMAL_REQ;
                model.f8468j = 1;
                model.f8469k = true;
                model.f8465g = this.d.getString(C0965R.string.navi_command_set_where_going);
                this.c.mo1930a(C2837c.STATE_WHERE_GOING);
                this.c.mo1928a(model);
                return;
            }
            model.f8464f = C2695a.TYPE_NORMAL_REQ;
            model.f8468j = 2;
            model.f8465g = this.d.getString(C0965R.string.no_this_ability);
            this.c.mo1930a(C2837c.STATE_WHERE_GOING);
            this.c.mo1928a(model);
        }
    }
}
