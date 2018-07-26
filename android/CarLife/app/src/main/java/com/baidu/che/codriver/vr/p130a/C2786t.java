package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.sdk.p081a.C2595h;
import com.baidu.che.codriver.sdk.p081a.C2595h.C1878b;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.ui.p128b.C2674b;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2673m.C2752a;
import com.baidu.che.codriver.vr.C2848p;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OperatorCommand */
/* renamed from: com.baidu.che.codriver.vr.a.t */
public class C2786t extends C2747a {
    /* renamed from: e */
    private static final String f9126e = "OperatorCommand";
    /* renamed from: f */
    private String f9127f;
    /* renamed from: g */
    private String f9128g;
    /* renamed from: h */
    private String f9129h;
    /* renamed from: i */
    private String f9130i;
    /* renamed from: j */
    private String f9131j;
    /* renamed from: k */
    private NLPResponseData f9132k;
    /* renamed from: l */
    private C1878b f9133l;

    /* compiled from: OperatorCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.t$1 */
    class C27851 implements C2752a {
        /* renamed from: a */
        final /* synthetic */ C2786t f9125a;

        C27851(C2786t this$0) {
            this.f9125a = this$0;
        }

        /* renamed from: a */
        public void mo1964a() {
        }
    }

    public C2786t(NLPResponseData data, C2673m callback, Context context) {
        super(null, callback, context);
        this.f9132k = null;
        this.f9132k = data;
        this.f9133l = C2595h.m9801a().m9803b();
    }

    public C2786t(C2848p data, C2673m callback, Context context) {
        super(data, callback, context);
        this.f9132k = null;
        this.f9133l = C2595h.m9801a().m9803b();
    }

    /* renamed from: j */
    protected void mo1958j() {
        try {
            this.f9131j = new JSONObject(mo1956g()).optString("item");
            C2725h.m10207b(C2747a.f9028a, "Goto Cmd Item: " + this.f9131j);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo1959a(C2747a newCommand) {
        C2725h.m10207b(f9126e, "OperatorCommand ------merge()------------");
    }

    /* renamed from: h */
    public void mo1957h() {
        C2725h.m10207b(f9126e, "OperatorCommand ------excute()------------");
        if (this.f9133l == null) {
            m10560a(this.d.getString(C0965R.string.voice_current_no_control));
            return;
        }
        C2761c.m10463a().m10478d();
        C2549b baseModel = new C2549b();
        baseModel.f8468j = 2;
        baseModel.f8465g = "";
        String strCommand = this.f9132k != null ? this.f9132k.rawText : this.b != null ? this.b.m10791e() : null;
        if (C2674b.m9985b().m10040q()) {
            m10560a(this.d.getString(C0965R.string.voice_current_no_control));
        } else if ("download".equals(mo1954e()) || "sync".equals(mo1954e()) || "login".equals(mo1954e())) {
            if (this.f9133l.mo1701a(strCommand, mo1954e())) {
                this.c.mo1929a(baseModel, null, null);
            } else {
                m10560a(this.d.getString(C0965R.string.voice_current_no_control));
            }
        } else if (this.f9133l.mo1701a(strCommand, this.f9131j)) {
            this.c.mo1929a(baseModel, new C27851(this), null);
        } else {
            m10560a(this.d.getString(C0965R.string.voice_current_no_control));
        }
    }

    /* renamed from: a */
    private void m10560a(String content) {
        C2549b conversationModel = new C2549b();
        conversationModel.f8468j = 1;
        conversationModel.f8465g = content;
        conversationModel.f8464f = C2695a.TYPE_NORMAL_REQ;
        this.c.mo1928a(conversationModel);
    }

    /* renamed from: i */
    protected void mo1960i() {
    }

    /* renamed from: k */
    protected JSONObject mo1961k() {
        return null;
    }
}
