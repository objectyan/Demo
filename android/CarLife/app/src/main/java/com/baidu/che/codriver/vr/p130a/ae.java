package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.sdk.p081a.C2575a;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2673m.C2749b;
import com.baidu.che.codriver.vr.C2848p;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: WakeUpCommand */
/* renamed from: com.baidu.che.codriver.vr.a.ae */
public class ae extends C2747a {
    /* renamed from: e */
    private String f9045e;
    /* renamed from: f */
    private boolean f9046f = false;

    public ae(C2848p data, C2673m callback, Context context) {
        super(data, callback, context);
    }

    /* renamed from: h */
    public void mo1957h() {
        if (mo1954e().equals(C2848p.f9296W)) {
            m10428a();
        } else if (!mo1954e().equals(C2848p.f9297X)) {
        }
    }

    /* renamed from: j */
    protected void mo1958j() {
        try {
            this.f9045e = new JSONObject(mo1956g()).optString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m10428a() {
        C2549b uiModel;
        if (!this.f9046f) {
            uiModel = new C2549b();
            uiModel.f8465g = this.d.getString(C0965R.string.xiaodu_is_not_understand);
            this.c.mo1928a(uiModel);
        } else if (TextUtils.isEmpty(this.f9045e) || this.f9045e.length() < 2) {
            uiModel = new C2549b();
            uiModel.f8465g = "这个名字太短啦，换个长一点的吧！";
            this.c.mo1928a(uiModel);
        } else if (this.f9045e.length() > 6) {
            uiModel = new C2549b();
            uiModel.f8465g = "这个名字太长啦，换个短一点的吧！";
            this.c.mo1928a(uiModel);
        } else {
            C2725h.m10207b("WakeUpCommand", "mWakeupWord=" + this.f9045e + " length=" + this.f9045e.length());
            final String word = this.f9045e + "你好,你好" + this.f9045e;
            uiModel = new C2549b();
            uiModel.f8465g = "您可以说" + (this.f9045e + "你好，你好" + this.f9045e) + "，来唤醒我啦！";
            this.c.mo1929a(uiModel, null, new C2749b(this) {
                /* renamed from: b */
                final /* synthetic */ ae f9044b;

                /* renamed from: a */
                public void mo1962a() {
                    C2575a.m9709a().m9731a(word, true);
                }
            });
        }
    }
}
