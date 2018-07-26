package com.baidu.che.codriver.sdk.p081a;

import android.text.TextUtils;
import com.baidu.che.codriver.p099f.C2535a;
import com.baidu.che.codriver.p099f.C2535a.C1840a;
import com.baidu.che.codriver.protocol.C2566d.C2565a;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2704g;
import com.baidu.che.codriver.util.C2725h;
import com.google.gson.Gson;

/* compiled from: CdNLPManager */
/* renamed from: com.baidu.che.codriver.sdk.a.g */
public class C2593g {
    /* renamed from: a */
    public static final String f8588a = "CdNLPManager";

    /* compiled from: CdNLPManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.g$a */
    public interface C1499a {
        /* renamed from: a */
        void mo1565a(C2565a c2565a);

        /* renamed from: a */
        void mo1566a(NLPResponseData nLPResponseData);
    }

    /* compiled from: CdNLPManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.g$2 */
    class C25912 implements C1840a {
        /* renamed from: a */
        final /* synthetic */ C2593g f8586a;

        C25912(C2593g this$0) {
            this.f8586a = this$0;
        }

        /* renamed from: a */
        public void mo1691a(String errMsg) {
            C2725h.m10207b(C2593g.f8588a, "errMsg：" + errMsg);
            this.f8586a.m9799a("nlp_error", errMsg);
        }

        /* renamed from: b */
        public void mo1692b(String response) {
            C2725h.m10207b(C2593g.f8588a, "response：" + response);
            C2549b model = C2704g.m10123b((NLPResponseData) new Gson().fromJson(response, NLPResponseData.class));
            this.f8586a.m9799a("nlp_result", "{\"card_type\":\"" + model.f8464f + "\",\"tts\":\"" + model.f8465g + "\"}");
        }
    }

    /* compiled from: CdNLPManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.g$b */
    private static class C2592b {
        /* renamed from: a */
        private static C2593g f8587a = new C2593g();

        private C2592b() {
        }
    }

    /* renamed from: a */
    public static C2593g m9796a() {
        return C2592b.f8587a;
    }

    /* renamed from: a */
    public void m9798a(String rawText, final C1499a nlpTool) {
        if (!TextUtils.isEmpty(rawText) && nlpTool != null) {
            new C2535a(new C1840a(this) {
                /* renamed from: b */
                final /* synthetic */ C2593g f8585b;

                /* renamed from: a */
                public void mo1691a(String errMsg) {
                    if (errMsg != null) {
                        C2725h.m10207b(C2593g.f8588a, "errMsg：" + errMsg);
                        nlpTool.mo1565a(C2565a.EEROR_UNKNOWN);
                    }
                }

                /* renamed from: b */
                public void mo1692b(String response) {
                    C2725h.m10207b(C2593g.f8588a, "nlp_response：" + response);
                    NLPResponseData result = (NLPResponseData) new Gson().fromJson(response, NLPResponseData.class);
                    if (result != null) {
                        C2725h.m10207b(C2593g.f8588a, "nlp_resultcode：" + result.errno);
                        nlpTool.mo1566a(result);
                    }
                }
            }).m9619a(rawText);
        }
    }

    /* renamed from: a */
    public void m9797a(String rawText) {
        new C2535a(new C25912(this)).m9619a(rawText);
    }

    /* renamed from: a */
    public void m9799a(String type, String data) {
        C2725h.m10214e(f8588a, "type:" + type + ";data:" + data);
        C2606l.m9828a().m9829a(C2606l.f8624j, type, data);
    }
}
