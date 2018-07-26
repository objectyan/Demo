package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p248b.C5170c;
import com.baidu.ufosdk.util.C5215h;
import com.baidu.ufosdk.util.C5216i;
import com.baidu.ufosdk.util.C5228u;

/* compiled from: FeedbackFacePageActivity */
/* renamed from: com.baidu.ufosdk.ui.g */
final class C5188g implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackFacePageActivity f21665a;

    C5188g(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f21665a = feedbackFacePageActivity;
    }

    public final void onClick(View view) {
        if (!C5215h.m17755a()) {
            try {
                this.f21665a.f21424o.setVisibility(0);
                this.f21665a.f21417h.setVisibility(8);
                this.f21665a.f21425p.setVisibility(0);
                String b = C5170c.m17557b(this.f21665a.getApplicationContext());
                boolean contains = b.contains("UNKNOWN");
                boolean contains2 = b.contains("NONE");
                if (contains || contains2) {
                    this.f21665a.f21425p.setVisibility(8);
                    this.f21665a.f21424o.setVisibility(8);
                    C5216i.m17762a(this.f21665a.getApplicationContext(), this.f21665a.f21427r);
                    this.f21665a.f21417h.setVisibility(0);
                    Toast.makeText(this.f21665a, C5228u.m17794a("18"), 1).show();
                } else if (UfoSDK.clientid.length() == 0) {
                    new Thread(new C5189h(this)).start();
                } else {
                    this.f21665a.f21425p.loadDataWithBaseURL(null, null, "text/html", "utf-8", null);
                    this.f21665a.f21417h.setVisibility(8);
                    this.f21665a.f21425p.setVisibility(0);
                    this.f21665a.f21435z.obtainMessage(1, null).sendToTarget();
                    new Thread(new C5190i(this)).start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
