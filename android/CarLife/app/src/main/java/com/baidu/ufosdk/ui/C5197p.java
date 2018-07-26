package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p248b.C5170c;
import com.baidu.ufosdk.util.C5215h;
import com.baidu.ufosdk.util.C5216i;
import com.baidu.ufosdk.util.C5228u;

/* compiled from: FeedbackFacePageActivity */
/* renamed from: com.baidu.ufosdk.ui.p */
final class C5197p implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackFacePageActivity f21674a;

    C5197p(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f21674a = feedbackFacePageActivity;
    }

    public final void onClick(View view) {
        if (UfoSDK.clientid.length() == 0) {
            Toast.makeText(this.f21674a.getApplicationContext(), C5228u.m17794a("18"), 1).show();
            if (!C5170c.m17557b(this.f21674a.getApplicationContext()).contains("UNKNOWN") && !C5170c.m17557b(this.f21674a.getApplicationContext()).contains("NONE")) {
                new Thread(new C5198q(this)).start();
                return;
            }
            return;
        }
        try {
            if (!C5215h.m17755a()) {
                Intent intent = new Intent();
                intent.setClass(this.f21674a, FeedbackInputActivity.class);
                intent.putExtra("msgid", this.f21674a.f21428s);
                intent.putExtra("feedback_channel", C5167a.f21362h);
                String editable = this.f21674a.f21402A.getText().toString();
                if (editable == null) {
                    intent.putExtra("no_result", "");
                } else {
                    intent.putExtra("no_result", editable);
                }
                this.f21674a.startActivity(intent);
                try {
                    this.f21674a.overridePendingTransition(C5216i.m17758a(this.f21674a.getApplicationContext(), "ufo_slide_in_from_right"), 0);
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
