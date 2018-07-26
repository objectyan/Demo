package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.p121g.C2536a;
import com.baidu.che.codriver.p122h.C2539c;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2848p;
import org.json.JSONObject;

/* compiled from: NullCommand */
/* renamed from: com.baidu.che.codriver.vr.a.q */
public class C2782q extends C2747a {
    public C2782q(C2848p data, C2673m callback, Context context) {
        super(data, callback, context);
    }

    /* renamed from: h */
    public void mo1957h() {
        C2716c.m10143a(this.d, C2536a.f8322w);
        C2549b model = new C2549b();
        model.f8464f = C2695a.TYPE_NORMAL_REQ;
        model.f8468j = 1;
        model.f8465g = this.d.getString(C0965R.string.xiaodu_doudi_hint);
        model.f8466h = C2539c.f8383y;
        this.c.mo1928a(model);
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
