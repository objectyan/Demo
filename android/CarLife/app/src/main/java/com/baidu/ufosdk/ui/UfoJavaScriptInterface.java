package com.baidu.ufosdk.ui;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import com.baidu.ufosdk.util.C5210c;

public class UfoJavaScriptInterface {
    public static void clickOnAndroid(WebView webView, String str) {
        Context context = webView.getContext();
        Intent intent = new Intent();
        intent.setClass(context, FeedbackHotActivity.class);
        intent.putExtra("hoturl", str);
        C5210c.m17734b("hoturl---->" + str);
        context.startActivity(intent);
    }
}
