package com.baidu.ufosdk.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.baidu.ufosdk.p247a.C5165a;
import com.baidu.ufosdk.util.C5228u;

/* compiled from: FeedbackInputActivity */
final class be extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ FeedbackInputActivity f21571a;

    be(FeedbackInputActivity feedbackInputActivity) {
        this.f21571a = feedbackInputActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.baidu.ufosdk.getchat")) {
            this.f21571a.ak.obtainMessage(2, intent.getExtras().getParcelableArrayList("msgList")).sendToTarget();
        }
        if (intent.getAction().equals("com.baidu.ufosdk.getmsgid")) {
            this.f21571a.f21468L = intent.getStringExtra("msgid");
            if (this.f21571a.f21470N == null) {
                this.f21571a.f21470N = new C5165a(this.f21571a.getApplicationContext(), this.f21571a.f21468L);
            }
            this.f21571a.f21470N.m17552b();
            if (!this.f21571a.f21470N.isAlive()) {
                this.f21571a.f21470N.start();
            }
        }
        if (intent.getAction().equals("com.baidu.ufosdk.deletemsg_dialogdismiss")) {
            this.f21571a.f21474R.setVisibility(8);
        }
        if (intent.getAction().equals("com.baidu.ufosdk.reload")) {
            Toast.makeText(this.f21571a.getApplicationContext(), C5228u.m17794a("18"), 1).show();
        }
    }
}
