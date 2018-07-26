package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.util.C5215h;

/* compiled from: FeedbackInputActivity */
final class bx implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ br f21593a;

    bx(br brVar) {
        this.f21593a = brVar;
    }

    public final void onClick(View view) {
        String charSequence = ((TextView) view).getText().toString();
        if (!C5215h.m17755a() && this.f21593a.f21586a.f21484d && charSequence.contains("我的反馈")) {
            this.f21593a.f21586a.f21483c = true;
            Intent intent = new Intent(this.f21593a.f21586a, FeedbackListActivity.class);
            intent.putExtra("feedback_channel", C5167a.f21362h);
            this.f21593a.f21586a.startActivity(intent);
            this.f21593a.f21586a.finish();
        }
    }
}
