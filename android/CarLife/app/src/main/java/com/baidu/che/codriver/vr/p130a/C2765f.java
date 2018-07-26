package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData.Result;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2704g;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.ImageSearchData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/* compiled from: ImageSearchCommand */
/* renamed from: com.baidu.che.codriver.vr.a.f */
public class C2765f extends C2747a {
    /* renamed from: e */
    ImageSearchData f9078e;
    /* renamed from: f */
    String f9079f;
    /* renamed from: g */
    private NLPResponseData f9080g;

    /* compiled from: ImageSearchCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.f$1 */
    class C27641 extends TypeToken<ImageSearchData> {
        /* renamed from: a */
        final /* synthetic */ C2765f f9077a;

        C27641(C2765f this$0) {
            this.f9077a = this$0;
        }
    }

    public C2765f(NLPResponseData data, C2673m callback, Context context) {
        super(null, callback, context);
        this.f9080g = data;
        this.d = context;
        mo1958j();
    }

    /* renamed from: a */
    public void mo1959a(C2747a cmd) {
        super.mo1959a(cmd);
    }

    /* renamed from: h */
    public void mo1957h() {
        m10492a();
    }

    /* renamed from: a */
    private void m10492a() {
        C2725h.m10207b(C2747a.f9028a, "---存在多个相关地点，再次发起语音识别------");
        C2761c.m10463a().m10475b(this);
        C2549b imageSearchConversationModel = new C2766g(this.f9078e);
        imageSearchConversationModel.g = this.f9079f;
        this.c.mo1928a(imageSearchConversationModel);
    }

    /* renamed from: j */
    protected void mo1958j() {
        if (this.f9080g != null) {
            Result result = C2704g.m10120a(this.f9080g);
            this.f9079f = result.ttsStatus.tts;
            try {
                this.f9078e = (ImageSearchData) new Gson().fromJson(result.data, new C27641(this).getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
