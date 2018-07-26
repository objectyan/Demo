package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.p099f.C2535a;
import com.baidu.che.codriver.p099f.C2535a.C1840a;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.ui.p124d.C2704g;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2848p;
import com.google.gson.Gson;

/* compiled from: NLPCommand */
/* renamed from: com.baidu.che.codriver.vr.a.l */
public class C2773l extends C2747a {
    /* renamed from: e */
    public static final String f9099e = "NLPCommand";
    /* renamed from: f */
    private NLPResponseData f9100f;

    /* compiled from: NLPCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.l$1 */
    class C27721 implements C1840a {
        /* renamed from: a */
        final /* synthetic */ C2773l f9098a;

        C27721(C2773l this$0) {
            this.f9098a = this$0;
        }

        /* renamed from: a */
        public void mo1691a(String errMsg) {
            C2549b model = new C2549b();
            model.f8467i = 5;
            this.f9098a.c.mo1928a(model);
        }

        /* renamed from: b */
        public void mo1692b(String response) {
            this.f9098a.m10520a((NLPResponseData) new Gson().fromJson(response, NLPResponseData.class));
        }
    }

    public C2773l(C2848p data, C2673m callback, Context context) {
        super(data, callback, context);
    }

    public C2773l(NLPResponseData nlpData, C2673m callback, Context context) {
        super(null, callback, context);
        this.f9100f = nlpData;
    }

    /* renamed from: h */
    public void mo1957h() {
        if (this.f9100f != null) {
            m10520a(this.f9100f);
            return;
        }
        C2725h.m10207b(f9099e, "NlpCommand excute mNlpResponseData is null");
        new C2535a(new C27721(this)).m9619a(this.b.m10791e());
    }

    /* renamed from: a */
    private void m10520a(NLPResponseData result) {
        C2549b model = C2704g.m10123b(result);
        if (model.f8464f == C2695a.TYPE_NLP_MULTIMOVIE || model.f8464f == C2695a.TYPE_IMAGE_SEARCH) {
            C2761c.m10463a().m10475b(this);
        }
        this.c.mo1928a(model);
    }

    /* renamed from: j */
    protected void mo1958j() {
    }

    /* renamed from: a */
    public void mo1959a(C2747a cmd) {
        if (C2747a.m10396b(cmd)) {
            C2549b model = new C2549b();
            model.f8468j = 1;
            model.f8465g = this.d.getString(C0965R.string.phone_command_no_any_option);
            this.c.mo1928a(model);
        }
    }
}
