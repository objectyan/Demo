package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2847o;
import com.baidu.che.codriver.vr.C2848p;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OfflineCustomCommand */
/* renamed from: com.baidu.che.codriver.vr.a.r */
public class C2783r extends C2747a {
    /* renamed from: e */
    private String f9124e;

    public C2783r(C2848p data, C2673m callback, Context context) {
        super(data, callback, context);
    }

    /* renamed from: h */
    public void mo1957h() {
        C2847o.m10687a().m10740a(this.f9124e);
    }

    /* renamed from: j */
    protected void mo1958j() {
        try {
            this.f9124e = new JSONObject(mo1956g()).optString("words");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
