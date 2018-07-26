package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import com.baidu.ufosdk.util.C5211d;
import com.baidu.ufosdk.util.C5216i;
import java.util.List;
import java.util.Map;

/* compiled from: FeedbackListActivity */
final class cg extends Handler {
    /* renamed from: a */
    final /* synthetic */ FeedbackListActivity f21615a;

    cg(FeedbackListActivity feedbackListActivity) {
        this.f21615a = feedbackListActivity;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 0) {
            C5211d c5211d = new C5211d(this.f21615a);
            c5211d.m17746d(c5211d.m17745d() + 1);
            this.f21615a.f21513c.setVisibility(0);
            this.f21615a.f21515e = (List) message.obj;
            for (int i = 0; i < this.f21615a.f21515e.size(); i++) {
                if (!((String) ((Map) this.f21615a.f21515e.get(i)).get("newmsg")).equals("0")) {
                    this.f21615a.f21509B.obtainMessage(2, Integer.valueOf(i)).sendToTarget();
                    break;
                }
            }
            if (this.f21615a.f21515e.size() == 0) {
                this.f21615a.f21530t.setVisibility(0);
            } else {
                this.f21615a.f21530t.setVisibility(8);
            }
            this.f21615a.f21532v.notifyDataSetChanged();
        }
        if (message.what == 1) {
            this.f21615a.f21513c.setVisibility(8);
            C5216i.m17762a(this.f21615a.getApplicationContext(), this.f21615a.f21514d);
            this.f21615a.f21512b.setVisibility(0);
            this.f21615a.f21533w.setVisibility(8);
        }
        if (message.what == 2) {
            this.f21615a.f21531u.setSelection(Integer.parseInt(message.obj.toString()));
        }
    }
}
