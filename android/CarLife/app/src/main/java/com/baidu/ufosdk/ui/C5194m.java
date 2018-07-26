package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p248b.C5170c;
import com.baidu.ufosdk.p248b.C5171d;
import com.baidu.ufosdk.util.C5210c;
import com.baidu.ufosdk.util.C5216i;

/* compiled from: FeedbackFacePageActivity */
/* renamed from: com.baidu.ufosdk.ui.m */
final class C5194m extends Handler {
    /* renamed from: a */
    final /* synthetic */ FeedbackFacePageActivity f21671a;

    C5194m(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f21671a = feedbackFacePageActivity;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 0) {
            if (Integer.parseInt((String) message.obj) > 0) {
                this.f21671a.f21422m.setVisibility(0);
            } else {
                this.f21671a.f21422m.setVisibility(8);
            }
        }
        if (message.what == 1) {
            this.f21671a.m17585b();
        }
        if (message.what == 2) {
            String str = C5167a.al + "&" + String.format("os=android&appid=%s&devid=%s&clientid=%s&appvn=%s&sdkvn=%s" + "&baiducuid=%s&nettype=%s&model=%s&osvn=%s&channel_id=%s", new Object[]{UfoSDK.appid, UfoSDK.devid, UfoSDK.clientid, C5171d.m17561c(), "1.7.13", C5167a.f21357c, C5170c.m17556a(this.f21671a.getApplicationContext()), Build.MODEL, VERSION.RELEASE, String.valueOf(C5167a.f21363i)});
            C5210c.m17735c("webview postString is " + str);
            this.f21671a.f21425p.loadUrl(str);
            this.f21671a.f21430u = false;
        }
        if (message.what == 5) {
            str = C5167a.al + "&" + String.format("os=android&appid=%s&devid=%s&clientid=%s&appvn=%s&sdkvn=%s" + "&baiducuid=%s&nettype=%s&model=%s&osvn=%s&channel_id=%s", new Object[]{UfoSDK.appid, UfoSDK.devid, UfoSDK.clientid, C5171d.m17561c(), "1.7.13", C5167a.f21357c, C5170c.m17556a(this.f21671a.getApplicationContext()), Build.MODEL, VERSION.RELEASE, Integer.valueOf(C5167a.f21362h)});
            C5210c.m17735c("webview postString is " + str);
            this.f21671a.f21425p.loadUrl(str);
            C5210c.m17734b("**********-->webView 全部问题： " + str);
            this.f21671a.f21430u = true;
        }
        if (message.what == 3 && this.f21671a.f21425p.getProgress() < 100) {
            this.f21671a.f21425p.stopLoading();
            this.f21671a.f21424o.setVisibility(8);
            C5216i.m17762a(this.f21671a.getApplicationContext(), this.f21671a.f21427r);
            this.f21671a.f21417h.setVisibility(0);
            this.f21671a.f21425p.setVisibility(8);
        }
        if (message.what == 4) {
            this.f21671a.f21424o.setVisibility(8);
            C5216i.m17762a(this.f21671a.getApplicationContext(), this.f21671a.f21427r);
            this.f21671a.f21417h.setVisibility(0);
            this.f21671a.f21425p.setVisibility(8);
        } else if (message.what == 12) {
            if (this.f21671a.f21429t) {
                this.f21671a.f21429t = false;
                return;
            }
            if (!TextUtils.isEmpty(this.f21671a.f21428s) && TextUtils.isEmpty(this.f21671a.f21415f)) {
                this.f21671a.f21411b.putString(this.f21671a.f21428s, "");
            }
            if (!TextUtils.isEmpty(this.f21671a.f21415f)) {
                this.f21671a.f21411b.putString(this.f21671a.f21415f, "");
            }
            this.f21671a.f21411b.commit();
        } else if (message.what == 14) {
            if (this.f21671a.f21429t) {
                this.f21671a.f21429t = false;
                return;
            }
            if (!TextUtils.isEmpty(this.f21671a.f21428s) && TextUtils.isEmpty(this.f21671a.f21415f)) {
                this.f21671a.f21411b.putString(this.f21671a.f21428s, "");
            }
            if (!TextUtils.isEmpty(this.f21671a.f21415f)) {
                this.f21671a.f21411b.putString(this.f21671a.f21415f, "");
            }
            this.f21671a.f21411b.commit();
            Intent intent = new Intent();
            intent.setClass(this.f21671a, FeedbackInputActivity.class);
            intent.putExtra("msgid", (String) message.obj);
            intent.putExtra("feedback_channel", C5167a.f21362h);
            this.f21671a.startActivity(intent);
        } else if (message.what == 15) {
            C5210c.m17734b("msg.what== 15");
        } else if (message.what == 16) {
            if (this.f21671a.getCurrentFocus() != null && this.f21671a.getCurrentFocus().getWindowToken() != null) {
                ((InputMethodManager) this.f21671a.getSystemService("input_method")).hideSoftInputFromWindow(this.f21671a.getCurrentFocus().getWindowToken(), 2);
            }
        } else if (message.what == 17) {
            this.f21671a.f21432w.notifyDataSetChanged();
        }
    }
}
