package com.baidu.ufosdk.p250d;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.ufosdk.util.C5210c;

/* compiled from: InjectedChromeClient */
/* renamed from: com.baidu.ufosdk.d.a */
public final class C5176a extends WebChromeClient {
    /* renamed from: a */
    private C5177b f21392a;
    /* renamed from: b */
    private boolean f21393b;

    public C5176a(String str, Class cls) {
        this.f21392a = new C5177b(str, cls);
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        jsResult.confirm();
        return true;
    }

    public final void onProgressChanged(WebView webView, int i) {
        if (i <= 25) {
            this.f21393b = false;
        } else if (!this.f21393b) {
            webView.loadUrl(this.f21392a.m17567a());
            this.f21393b = true;
            C5210c.m17732a(" inject js interface completely on progress " + i);
        }
        super.onProgressChanged(webView, i);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        jsPromptResult.confirm(this.f21392a.m17568a(webView, str2));
        return true;
    }
}
