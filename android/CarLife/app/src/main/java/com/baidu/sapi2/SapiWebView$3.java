package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import com.baidu.navisdk.hudsdk.BNRemoteConstants;
import com.baidu.sapi2.utils.C4913L;

class SapiWebView$3 extends WebChromeClient {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20087a;

    SapiWebView$3(SapiWebView sapiWebView) {
        this.f20087a = sapiWebView;
    }

    public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
        Builder builder = new Builder(this.f20087a.getContext()).setTitle("JavaScript Message").setMessage(message).setPositiveButton(BNRemoteConstants.ERROR_DEFAULT_STR, new OnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ SapiWebView$3 f20082b;

            public void onClick(DialogInterface dialog, int which) {
                result.confirm();
            }
        });
        builder.setCancelable(false);
        builder.create();
        builder.show();
        return true;
    }

    public void onConsoleMessage(String message, int lineNumber, String sourceID) {
        C4913L.m16372d(message + " -- From line " + lineNumber + " of " + sourceID, new Object[0]);
    }

    public void onProgressChanged(WebView view, int newProgress) {
        if (SapiWebView.l(this.f20087a) != null) {
            if (newProgress == 100) {
                SapiWebView.l(this.f20087a).setVisibility(8);
            } else {
                if (SapiWebView.l(this.f20087a).getVisibility() == 8) {
                    SapiWebView.l(this.f20087a).setVisibility(0);
                }
                SapiWebView.l(this.f20087a).setProgress(newProgress);
            }
        }
        super.onProgressChanged(view, newProgress);
    }

    @TargetApi(5)
    public void onReachedMaxAppCacheSize(long requiredStorage, long quota, QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(2 * requiredStorage);
    }

    public boolean onJsPrompt(WebView view, String url, final String message, String defaultValue, final JsPromptResult result) {
        final String[] interpretResult = new String[]{""};
        this.f20087a.post(new Runnable(this) {
            /* renamed from: d */
            final /* synthetic */ SapiWebView$3 f20086d;

            public void run() {
                SapiWebView$Command command = SapiWebView$Command.parse(message);
                if (!(command == null || TextUtils.isEmpty(command.getActionName()) || SapiWebView.m(this.f20086d.f20087a).get(command.getActionName()) == null)) {
                    interpretResult[0] = ((SapiWebView$AbstractInterpreter) SapiWebView.m(this.f20086d.f20087a).get(command.getActionName())).interpret(command);
                }
                result.confirm(interpretResult[0]);
            }
        });
        return true;
    }
}
