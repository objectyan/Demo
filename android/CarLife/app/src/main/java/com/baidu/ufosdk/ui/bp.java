package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.ufosdk.C5167a;

/* compiled from: FeedbackInputActivity */
final class bp implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackInputActivity f21584a;

    bp(FeedbackInputActivity feedbackInputActivity) {
        this.f21584a = feedbackInputActivity;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.f21584a, FeedbackListActivity.class);
        intent.putExtra("feedback_channel", C5167a.f21362h);
        this.f21584a.startActivity(intent);
    }
}
