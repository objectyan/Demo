package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p248b.C5170c;
import com.baidu.ufosdk.util.C5210c;
import com.baidu.ufosdk.util.C5215h;
import com.baidu.ufosdk.util.C5216i;
import com.baidu.ufosdk.util.C5228u;

/* compiled from: FeedbackFacePageActivity */
/* renamed from: com.baidu.ufosdk.ui.c */
final class C5184c implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackFacePageActivity f21596a;

    C5184c(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f21596a = feedbackFacePageActivity;
    }

    public final void onClick(View view) {
        C5210c.m17736d("#######################");
        if (UfoSDK.clientid.length() == 0) {
            Toast.makeText(this.f21596a.getApplicationContext(), C5228u.m17794a("18"), 1).show();
            if (!C5170c.m17557b(this.f21596a.getApplicationContext()).contains("UNKNOWN") && !C5170c.m17557b(this.f21596a.getApplicationContext()).contains("NONE")) {
                new Thread(new C5185d(this)).start();
                return;
            }
            return;
        }
        try {
            if (!C5215h.m17755a()) {
                Intent intent = new Intent();
                intent.setClass(this.f21596a, FeedbackInputActivity.class);
                intent.putExtra("msgid", this.f21596a.f21428s);
                intent.putExtra("fromlist", C2848p.f9292S);
                intent.putExtra("feedback_channel", C5167a.f21362h);
                this.f21596a.startActivity(intent);
                try {
                    this.f21596a.overridePendingTransition(C5216i.m17758a(this.f21596a.getApplicationContext(), "ufo_slide_in_from_right"), C5216i.m17758a(this.f21596a.getApplicationContext(), "ufo_slide_out_to_left"));
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
