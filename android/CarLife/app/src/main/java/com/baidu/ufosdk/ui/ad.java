package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.ufosdk.p248b.C5170c;
import com.baidu.ufosdk.util.C5215h;
import com.baidu.ufosdk.util.C5216i;

/* compiled from: FeedbackHotActivity */
final class ad implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackHotActivity f21540a;

    ad(FeedbackHotActivity feedbackHotActivity) {
        this.f21540a = feedbackHotActivity;
    }

    public final void onClick(View view) {
        if (!C5215h.m17755a()) {
            this.f21540a.f21446k.setVisibility(0);
            this.f21540a.f21442g.setVisibility(8);
            if (C5170c.m17557b(this.f21540a.getApplicationContext()).contains("UNKNOWN") || C5170c.m17557b(this.f21540a.getApplicationContext()).contains("NONE")) {
                this.f21540a.f21446k.setVisibility(8);
                C5216i.m17762a(this.f21540a.getApplicationContext(), this.f21540a.f21447l);
                this.f21540a.f21442g.setVisibility(0);
                return;
            }
            this.f21540a.m17612a();
            this.f21540a.f21442g.setVisibility(8);
            this.f21540a.f21444i.setVisibility(0);
        }
    }
}
