package com.baidu.ufosdk.p250d;

import android.webkit.WebView;
import java.lang.ref.WeakReference;

/* compiled from: JsCallback */
/* renamed from: com.baidu.ufosdk.d.c */
public class C5178c {
    /* renamed from: a */
    private int f21397a;
    /* renamed from: b */
    private boolean f21398b = true;
    /* renamed from: c */
    private WeakReference f21399c;
    /* renamed from: d */
    private String f21400d;

    public C5178c(WebView webView, String str, int i) {
        this.f21399c = new WeakReference(webView);
        this.f21400d = str;
        this.f21397a = i;
    }
}
