package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import com.baidu.che.codriver.p121g.C2536a;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2848p;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CalendarCommand */
/* renamed from: com.baidu.che.codriver.vr.a.b */
public class C2757b extends C2747a {
    public C2757b(C2848p data, C2673m callback, Context context) {
        super(data, callback, context);
    }

    /* renamed from: h */
    public void mo1957h() {
        JSONException e;
        String objectStr = this.b.m10789d();
        if (objectStr == null || objectStr.length() <= 0) {
            this.c.mo1928a(null);
        } else {
            C2549b model = null;
            try {
                JSONObject object = new JSONObject(objectStr);
                C2549b model2 = new C2549b();
                try {
                    model2.f8464f = C2695a.TYPE_NORMAL_REQ;
                    model2.f8468j = 1;
                    model2.f8465g = object.optString("ANSWER");
                    if (model2.f8465g == null || model2.f8465g.length() == 0) {
                        model2.f8465g = object.optString("answer");
                    }
                    model = model2;
                } catch (JSONException e2) {
                    e = e2;
                    model = model2;
                    e.printStackTrace();
                    this.c.mo1928a(model);
                    C2716c.m10143a(this.d, C2536a.f8315p);
                }
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
                this.c.mo1928a(model);
                C2716c.m10143a(this.d, C2536a.f8315p);
            }
            this.c.mo1928a(model);
        }
        C2716c.m10143a(this.d, C2536a.f8315p);
    }

    /* renamed from: j */
    protected void mo1958j() {
    }
}
