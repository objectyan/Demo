package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.util.C5215h;
import java.util.concurrent.Executors;

/* compiled from: FeedbackListActivity */
final class cn implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackListActivity f21626a;

    cn(FeedbackListActivity feedbackListActivity) {
        this.f21626a = feedbackListActivity;
    }

    public final void onClick(View view) {
        if (!C5215h.m17755a()) {
            try {
                this.f21626a.f21512b.setVisibility(8);
                this.f21626a.f21533w.setVisibility(0);
                if (UfoSDK.clientid.length() == 0) {
                    new Thread(new co(this)).start();
                    return;
                }
                this.f21626a.f21535z = Executors.newSingleThreadExecutor();
                this.f21626a.f21535z.execute(new cp(this));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
