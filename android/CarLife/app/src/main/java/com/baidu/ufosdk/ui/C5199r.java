package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p248b.C5171d;

/* compiled from: FeedbackFacePageActivity */
/* renamed from: com.baidu.ufosdk.ui.r */
final class C5199r implements OnItemClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackFacePageActivity f21676a;

    C5199r(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f21676a = feedbackFacePageActivity;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = C5167a.ak + "?m=Web&a=getnfaqa&faq_id=" + ((dc) this.f21676a.f21434y.get(i)).f21660a + "&appid=" + UfoSDK.appid + "devid=" + UfoSDK.devid + "clientid=" + UfoSDK.clientid + "&os=android&uid=" + C5167a.f21357c + "&channel_id=" + ((dc) this.f21676a.f21434y.get(i)).f21662c + "appvn=" + C5171d.m17561c();
        Intent intent = new Intent();
        intent.setClass(this.f21676a, FeedbackHotActivity.class);
        intent.putExtra("hoturl", str);
        this.f21676a.startActivity(intent);
    }
}
