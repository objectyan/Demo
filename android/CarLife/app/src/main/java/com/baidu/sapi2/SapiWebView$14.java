package com.baidu.sapi2;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.sapi2.utils.C4913L;

class SapiWebView$14 implements DownloadListener {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20044a;

    SapiWebView$14(SapiWebView sapiWebView) {
        this.f20044a = sapiWebView;
    }

    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
            intent.setFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
            this.f20044a.getContext().startActivity(intent);
        } catch (Throwable e) {
            C4913L.m16375e(e, e.getMessage(), new Object[0]);
        }
    }
}
