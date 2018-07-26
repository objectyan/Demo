package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.p121g.C2536a;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.platform.PlatformManager;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2673m.C2752a;
import com.baidu.che.codriver.vr.C2746e;
import com.baidu.che.codriver.vr.C2848p;
import org.json.JSONObject;

/* compiled from: NaviInstructionCommand */
/* renamed from: com.baidu.che.codriver.vr.a.n */
public class C2779n extends C2747a {

    /* compiled from: NaviInstructionCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.n$1 */
    class C27771 implements C2752a {
        /* renamed from: a */
        final /* synthetic */ C2779n f9103a;

        C27771(C2779n this$0) {
            this.f9103a = this$0;
        }

        /* renamed from: a */
        public void mo1964a() {
            PlatformManager.getInstance().sendNaviCommand(NaviCmdConstants.KEY_NAVI_START_TASK, Boolean.valueOf(false));
        }
    }

    /* compiled from: NaviInstructionCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.n$2 */
    class C27782 implements C2752a {
        /* renamed from: a */
        final /* synthetic */ C2779n f9104a;

        C27782(C2779n this$0) {
            this.f9104a = this$0;
        }

        /* renamed from: a */
        public void mo1964a() {
            PlatformManager.getInstance().sendNaviCommand(NaviCmdConstants.KEY_NAVI_EXIT_APP, Boolean.valueOf(false));
        }
    }

    public C2779n(C2848p data, C2673m callback, Context context) {
        super(data, callback, context);
    }

    /* renamed from: h */
    public void mo1957h() {
        C2549b model = new C2549b();
        C2716c.m10143a(this.d, C2536a.f8311l);
        if ("navigate".equals(mo1954e()) || C2848p.ac.equals(mo1954e())) {
            model.f8468j = 2;
            model.f8465g = this.d.getString(C0965R.string.navi_command_start_navi);
            this.c.mo1929a(model, new C27771(this), null);
        } else if ("quit".equals(mo1954e())) {
            model.f8468j = 1;
            model.f8465g = this.d.getString(C0965R.string.navi_command_quit_app);
            this.c.mo1929a(model, new C27782(this), null);
        } else {
            C2761c.m10463a().m10471a((C2746e) this);
            model.f8468j = 2;
            this.c.mo1928a(model);
        }
    }

    /* renamed from: a */
    public void mo1959a(C2747a cmd) {
    }

    /* renamed from: i */
    protected void mo1960i() {
    }

    /* renamed from: j */
    protected void mo1958j() {
    }

    /* renamed from: k */
    protected JSONObject mo1961k() {
        return null;
    }
}
