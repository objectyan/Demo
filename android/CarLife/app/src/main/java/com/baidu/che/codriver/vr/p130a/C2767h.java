package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.sdk.p081a.C2595h;
import com.baidu.che.codriver.sdk.p081a.C2595h.C1878b;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2673m.C2837c;
import com.baidu.che.codriver.vr.C2848p;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InstructionCommand */
/* renamed from: com.baidu.che.codriver.vr.a.h */
public class C2767h extends C2747a {
    /* renamed from: f */
    private static final String f9082f = "InstructionCommand";
    /* renamed from: e */
    public NLPResponseData f9083e;
    /* renamed from: g */
    private C1878b f9084g;

    public C2767h(C2848p data, C2673m callback, Context context) {
        super(data, callback, context);
        this.f9084g = C2595h.m9801a().m9803b();
    }

    public C2767h(NLPResponseData data, C2673m callback, Context context) {
        super(null, callback, context);
        this.f9083e = data;
    }

    /* renamed from: h */
    public void mo1957h() {
        C2549b model = new C2549b();
        if (this.c.mo1945s() == C2837c.STATE_WECHAT_RECEIVE_CONTENT) {
            C2761c.m10463a().m10477c(this);
        } else if (m10412p()) {
            if (C2848p.f9292S.equals(mo1954e())) {
                C2761c.m10463a().m10477c(this);
            } else if (C2848p.f9291R.equals(mo1954e())) {
                C2761c.m10463a().m10477c(this);
            } else {
                model.f8465g = this.d.getString(C0965R.string.command_error_please_retry);
                model.f8468j = 1;
                this.c.mo1928a(model);
            }
        } else if (C2848p.f9278E.equals(mo1954e())) {
            if (C2761c.m10463a().m10480e()) {
                C2761c.m10463a().m10477c(this);
            } else if (!m10497a()) {
                model.f8465g = this.d.getString(C0965R.string.phone_command_no_any_option);
                this.c.mo1928a(model);
            }
        } else if (C2848p.f9292S.equals(mo1954e())) {
            mo1960i();
        } else if ("quit".equals(mo1954e())) {
            model.f8465g = this.d.getString(C0965R.string.tts_record_end_hint_1);
            model.f8468j = 2;
            this.c.mo1928a(model);
        } else if (C2848p.f9291R.equals(mo1954e())) {
            if (C2761c.m10463a().m10480e()) {
                C2761c.m10463a().m10477c(this);
            } else {
                mo1960i();
            }
        } else if (C2848p.f9295V.equals(mo1954e())) {
            this.c.mo1938e();
        } else if (C2848p.f9294U.equals(mo1954e())) {
            this.c.mo1939f();
        } else {
            mo1960i();
        }
    }

    /* renamed from: a */
    public boolean m10497a() {
        try {
            int selectIndex = C2747a.m10395a(new JSONObject(mo1956g()).optString("option"), 0);
            C2725h.m10207b(f9082f, "voice selectIndex:" + selectIndex);
            if (this.f9084g == null) {
                C2725h.m10207b(f9082f, "voice selectIndex operate error ");
                return false;
            }
            C2761c.m10463a().m10478d();
            C2549b baseModel = new C2549b();
            baseModel.f8468j = 2;
            baseModel.f8465g = "";
            if (selectIndex == -1 || !this.f9084g.mo1700a(selectIndex)) {
                return false;
            }
            this.c.mo1929a(baseModel, null, null);
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public void mo1959a(C2747a cmd) {
    }

    /* renamed from: j */
    protected void mo1958j() {
    }

    /* renamed from: k */
    protected JSONObject mo1961k() {
        return null;
    }
}
