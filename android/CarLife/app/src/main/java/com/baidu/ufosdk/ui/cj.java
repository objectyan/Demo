package com.baidu.ufosdk.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;

/* compiled from: FeedbackListActivity */
final class cj extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ FeedbackListActivity f21622a;

    cj(FeedbackListActivity feedbackListActivity) {
        this.f21622a = feedbackListActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.baidu.ufosdk.gethistorylist")) {
            this.f21622a.f21534x.setVisibility(8);
            this.f21622a.f21509B.obtainMessage(0, (ArrayList) intent.getSerializableExtra("msgList")).sendToTarget();
            FeedbackListActivity.m17701k(this.f21622a);
        }
        if (intent.getAction().equals("com.baidu.ufosdk.getnewhistoryflag")) {
            this.f21622a.f21535z.execute(new ck(this));
        }
        if (intent.getAction().equals("com.baidu.ufosdk.getappkeysuccess_getnewhistoryflag")) {
            this.f21622a.f21535z.execute(new cl(this));
        }
        if (intent.getAction().equals("com.baidu.ufosdk.deletemsg_dialogdismiss")) {
            this.f21622a.f21533w.setVisibility(8);
            this.f21622a.f21534x.setVisibility(8);
        }
        if (intent.getAction().equals("com.baidu.ufosdk.reload")) {
            this.f21622a.f21509B.obtainMessage(1, null).sendToTarget();
        }
    }
}
