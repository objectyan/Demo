package com.baidu.navisdk.ui.widget;

import android.graphics.Bitmap;
import android.os.Message;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.navisdk.util.common.LogUtil;

public abstract class BNWebViewClient extends WebViewClient {
    public static final int MSG_BN_CLOSE = 0;
    public static final int MSG_ON_OVERRIDE_URL_LOADING = 1;
    public static final int MSG_ON_PAGE_FINISHED = 3;
    public static final int MSG_ON_PAGE_STARTED = 2;
    public static final int MSG_ON_RECEIVED_ERROR = 4;
    public static final String URL_BN_CLOSE = "bdnavi://close";
    public static final String URL_BN_PREFIX = "bdnavi://";
    public static final String URL_HTTPS_PREFIX = "https://";
    public static final String URL_HTTP_PREFIX = "http://";

    public abstract boolean onEventAndroid(int i, WebView webView, String str, Message message);

    public abstract boolean onEventBNavi(int i, WebView webView, String str, Message message);

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        LogUtil.m15791e("BNWebViewClient", "OverrideUrlLoading:" + url);
        if (!(view == null || url == null)) {
            if (url.startsWith("http://") || url.startsWith("https://")) {
                view.loadUrl(url);
                onEventAndroid(1, view, url, null);
            } else if (url.startsWith("bdnavi://")) {
                handleBNUrlProtocol(view, url);
            }
        }
        return true;
    }

    private void handleBNUrlProtocol(WebView view, String url) {
        if (url.startsWith(URL_BN_CLOSE)) {
            onEventBNavi(0, view, url, null);
        }
    }

    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        onEventAndroid(2, view, url, null);
    }

    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        onEventAndroid(3, view, url, null);
    }

    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        LogUtil.m15791e("BNWebViewClient", "onReceivedError:" + failingUrl);
        onEventAndroid(4, view, failingUrl, null);
    }

    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
    }
}
