package com.baidu.ufosdk.ui;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.navisdk.util.common.HttpsClient;
import com.baidu.ufosdk.util.C5210c;
import com.baidu.ufosdk.util.C5216i;
import java.util.Timer;

/* compiled from: FeedbackFacePageActivity */
/* renamed from: com.baidu.ufosdk.ui.z */
final class C5207z extends WebViewClient {
    /* renamed from: a */
    final /* synthetic */ FeedbackFacePageActivity f21686a;

    private C5207z(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f21686a = feedbackFacePageActivity;
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        C5210c.m17734b("UfoWebViewClient-->onPageStarted");
        super.onPageStarted(webView, str, bitmap);
        this.f21686a.f21424o.setVisibility(0);
        this.f21686a.f21426q = new Timer();
        this.f21686a.f21426q.schedule(new aa(this), HttpsClient.CONN_MGR_TIMEOUT);
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f21686a.f21424o.setVisibility(8);
        if (this.f21686a.f21426q != null) {
            this.f21686a.f21426q.cancel();
            this.f21686a.f21426q.purge();
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        C5210c.m17736d("onReceivedError-->errorCode:" + i + ",description:" + str + ",failingUrl:" + str2);
        super.onReceivedError(webView, i, str, str2);
        C5216i.m17762a(this.f21686a.getApplicationContext(), this.f21686a.f21427r);
        this.f21686a.f21417h.setVisibility(0);
        this.f21686a.f21425p.setVisibility(8);
        this.f21686a.f21424o.setVisibility(8);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        C5210c.m17736d("UfoWebViewClient-->onReceivedSslError");
        sslErrorHandler.proceed();
    }

    public final void onLoadResource(WebView webView, String str) {
        C5210c.m17734b("UfoWebViewClient-->onLoadResource");
        super.onLoadResource(webView, str);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C5210c.m17734b("UfoWebViewClient-->shouldOverrideUrlLoading:" + str);
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
