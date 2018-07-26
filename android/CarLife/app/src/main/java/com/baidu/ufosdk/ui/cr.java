package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.util.C5215h;
import com.baidu.ufosdk.util.C5216i;
import java.util.Map;

/* compiled from: FeedbackListActivity */
final class cr implements OnItemClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackListActivity f21630a;

    cr(FeedbackListActivity feedbackListActivity) {
        this.f21630a = feedbackListActivity;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        ((Map) this.f21630a.f21515e.get(i)).put("newmsg", "0");
        this.f21630a.f21532v.notifyDataSetChanged();
        Intent intent = new Intent();
        intent.setClass(this.f21630a, FeedbackInputActivity.class);
        intent.putExtra("msgid", (String) ((Map) this.f21630a.f21515e.get(i)).get("id"));
        intent.putExtra("feedback_channel", C5167a.f21362h);
        if (!C5215h.m17755a()) {
            this.f21630a.startActivity(intent);
            this.f21630a.finish();
            try {
                this.f21630a.overridePendingTransition(C5216i.m17758a(this.f21630a.getApplicationContext(), "ufo_slide_in_from_right"), C5216i.m17758a(this.f21630a.getApplicationContext(), "ufo_slide_out_to_left"));
            } catch (Exception e) {
            }
        }
    }
}
