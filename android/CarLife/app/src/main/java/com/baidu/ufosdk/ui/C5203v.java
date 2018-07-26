package com.baidu.ufosdk.ui;

import android.text.TextUtils;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p251e.C5181b;
import com.baidu.ufosdk.util.C5210c;
import org.json.JSONObject;

/* compiled from: FeedbackFacePageActivity */
/* renamed from: com.baidu.ufosdk.ui.v */
final class C5203v implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C5202u f21680a;

    C5203v(C5202u c5202u) {
        this.f21680a = c5202u;
    }

    public final void run() {
        try {
            Object a = C5181b.m17578a(C5167a.am, "appid=" + UfoSDK.appid);
            if (!TextUtils.isEmpty(a)) {
                JSONObject jSONObject = new JSONObject(a);
                C5210c.m17732a(jSONObject.toString());
                FeedbackFacePageActivity.m17582a(this.f21680a.f21679a, jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
