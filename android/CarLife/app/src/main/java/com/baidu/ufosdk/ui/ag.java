package com.baidu.ufosdk.ui;

import android.graphics.Bitmap;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.navisdk.util.common.HttpsClient;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.util.C5210c;
import com.baidu.ufosdk.util.C5216i;
import com.baidu.ufosdk.util.C5228u;
import java.util.Timer;

/* compiled from: FeedbackHotActivity */
final class ag extends WebViewClient {
    /* renamed from: a */
    final /* synthetic */ FeedbackHotActivity f21543a;

    private ag(FeedbackHotActivity feedbackHotActivity) {
        this.f21543a = feedbackHotActivity;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C5210c.m17734b("UfoWebViewClient-->shouldOverrideUrlLoading:" + str);
        if (str.startsWith("feedback://")) {
            FeedbackHotActivity.m17617e(this.f21543a);
        } else if (str.startsWith("solve://")) {
            C5216i.m17761a(this.f21543a, C5228u.m17794a("26"), C5167a.f21371q);
            new Handler().postDelayed(new ah(this), C5167a.f21371q);
        } else if (str.startsWith("backtoufo://")) {
            this.f21543a.finish();
        } else {
            webView.loadUrl(str);
        }
        return true;
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        webView.clearView();
        this.f21543a.f21446k.setVisibility(0);
        this.f21543a.f21451p = new Timer();
        this.f21543a.f21451p.schedule(new ai(this), HttpsClient.CONN_MGR_TIMEOUT);
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f21543a.f21446k.setVisibility(8);
        webView.requestFocus();
        if (this.f21543a.f21451p != null) {
            this.f21543a.f21451p.cancel();
            this.f21543a.f21451p.purge();
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        C5216i.m17762a(this.f21543a.getApplicationContext(), this.f21543a.f21447l);
        this.f21543a.f21442g.setVisibility(0);
        this.f21543a.f21444i.setVisibility(8);
    }

    public final void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }
}
