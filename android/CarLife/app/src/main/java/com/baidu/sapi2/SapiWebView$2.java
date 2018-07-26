package com.baidu.sapi2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.mobstat.Config;
import com.baidu.navi.util.SearchParamKey;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.utils.C4913L;
import com.baidu.sapi2.utils.C4923f;
import com.baidu.sapi2.utils.SapiUtils;

class SapiWebView$2 extends WebViewClient {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20080a;

    /* renamed from: com.baidu.sapi2.SapiWebView$2$2 */
    class C48552 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ SapiWebView$2 f20059a;

        C48552(SapiWebView$2 sapiWebView$2) {
            this.f20059a = sapiWebView$2;
        }

        public void run() {
            this.f20059a.f20080a.stopLoading();
            SapiWebView.h(this.f20059a.f20080a).onSuccess();
        }
    }

    /* renamed from: com.baidu.sapi2.SapiWebView$2$3 */
    class C48573 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ SapiWebView$2 f20062a;

        C48573(SapiWebView$2 sapiWebView$2) {
            this.f20062a = sapiWebView$2;
        }

        public void run() {
            this.f20062a.f20080a.stopLoading();
            final String bduss = SapiUtils.getCookieBduss();
            if (TextUtils.isEmpty(bduss)) {
                SapiWebView.h(this.f20062a.f20080a).onSuccess();
            } else {
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback(this) {
                    /* renamed from: b */
                    final /* synthetic */ C48573 f20061b;

                    public void onBdussExpired(GetUserInfoResult result) {
                        SapiWebView.h(this.f20061b.f20062a.f20080a).onSuccess();
                    }

                    public void onSuccess(GetUserInfoResult result) {
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        if (session != null && session.uid.equals(result.uid)) {
                            session.bduss = bduss;
                        }
                        SapiAccountManager.getInstance().validate(session);
                        SapiWebView.h(this.f20061b.f20062a.f20080a).onSuccess();
                    }

                    public void onFailure(GetUserInfoResult result) {
                        SapiWebView.h(this.f20061b.f20062a.f20080a).onSuccess();
                    }

                    public void onStart() {
                        try {
                            SapiWebView.a(this.f20061b.f20062a.f20080a, ProgressDialog.show(this.f20061b.f20062a.f20080a.getContext(), null, "加载中...", true));
                        } catch (Throwable e) {
                            C4913L.m16374e(e);
                        }
                    }

                    public void onFinish() {
                        if (SapiWebView.i(this.f20061b.f20062a.f20080a) != null) {
                            try {
                                SapiWebView.i(this.f20061b.f20062a.f20080a).dismiss();
                            } catch (Throwable e) {
                                C4913L.m16374e(e);
                            }
                        }
                    }
                }, bduss);
            }
        }
    }

    /* renamed from: com.baidu.sapi2.SapiWebView$2$4 */
    class C48584 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ SapiWebView$2 f20063a;

        C48584(SapiWebView$2 sapiWebView$2) {
            this.f20063a = sapiWebView$2;
        }

        public void run() {
            SapiWebView.k(this.f20063a.f20080a).onFailed(-100, "登录失败");
        }
    }

    SapiWebView$2(SapiWebView sapiWebView) {
        this.f20080a = sapiWebView;
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url != null) {
            if (url.startsWith("sms") || url.startsWith(SearchParamKey.TEL) || url.startsWith("bdscenter")) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
                    intent.setFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
                    this.f20080a.getContext().startActivity(intent);
                } catch (Throwable e) {
                    C4913L.m16375e(e, e.getMessage(), new Object[0]);
                }
                return true;
            } else if (url.startsWith("wtloginmqq")) {
                return true;
            } else {
                if (SapiWebView.c(this.f20080a) != null) {
                    Uri uri = Uri.parse(url);
                    if (SapiWebView.d(this.f20080a).environment.getWap().equals(uri.getScheme() + "://" + uri.getHost() + (uri.getPort() == -1 ? "" : Config.TRACE_TODAY_VISIT_SPLIT + uri.getPort())) && C4923f.f20598c.equals(uri.getPath())) {
                        SapiAccountManager.getInstance().getAccountService().a(SapiWebView.c(this.f20080a), url);
                        return true;
                    }
                }
            }
        }
        return super.shouldOverrideUrlLoading(view, url);
    }

    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        SapiWebView.e(this.f20080a).setUrl(url);
        SapiWebView.b(this.f20080a).postDelayed(SapiWebView.e(this.f20080a), SapiWebView.f(this.f20080a));
        if (url != null) {
            if (url.contains("__wp-action=auth-widget")) {
                final String authSid = Uri.parse(url).getQueryParameter("authsid");
                if (!(TextUtils.isEmpty(authSid) || SapiWebView.g(this.f20080a) == null)) {
                    this.f20080a.post(new Runnable(this) {
                        /* renamed from: b */
                        final /* synthetic */ SapiWebView$2 f20058b;

                        public void run() {
                            SapiWebView.g(this.f20058b.f20080a).onSuccess(authSid);
                        }
                    });
                }
            }
            if (url.contains("forget-pwd") || url.contains("modify-pwd")) {
                String action = Uri.parse(url).getQueryParameter("__wp-action");
                if ("forget-pwd".equals(action) && SapiWebView.h(this.f20080a) != null) {
                    this.f20080a.post(new C48552(this));
                }
                if ("modify-pwd".equals(action) && SapiWebView.h(this.f20080a) != null) {
                    this.f20080a.post(new C48573(this));
                }
            }
            if (!url.contains("__wp-action=renren-offline") || !"renren-offline".equals(Uri.parse(url).getQueryParameter("__wp-action"))) {
                return;
            }
            if (SapiWebView.j(this.f20080a) != null) {
                SapiWebView.a(this.f20080a, SapiWebView.j(this.f20080a));
            } else if (SapiWebView.k(this.f20080a) != null) {
                this.f20080a.post(new C48584(this));
            }
        }
    }

    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        if (VERSION.SDK_INT > 7) {
            this.f20080a.getSettings().setBlockNetworkLoads(false);
        }
        this.f20080a.loadUrl("javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.net){Pass.client.net()}}())");
        Uri uriAfterAuth = Uri.parse(SapiAccountManager.getInstance().getAccountService().l());
        Uri uriFinishBind = Uri.parse(SapiAccountManager.getInstance().getAccountService().m());
        Uri uriSSOFinish = Uri.parse(SapiAccountManager.getInstance().getAccountService().k());
        if (url.contains(uriAfterAuth.getHost() + uriAfterAuth.getPath()) || url.contains(uriFinishBind.getHost() + uriFinishBind.getPath()) || url.contains(uriSSOFinish.getHost() + uriSSOFinish.getPath())) {
            this.f20080a.loadUrl("javascript:prompt(JSON.stringify({'action':{'name': 'authorized_response', 'params': [document.getElementsByTagName('html')[0].innerHTML, '1']}}));");
        }
        if (url.contains(SapiAccountManager.getInstance().getAccountService().h())) {
            this.f20080a.loadUrl("javascript:prompt(JSON.stringify({'action':{'name': 'authorized_response', 'params': [document.body.innerHTML, '0']}}));");
        }
        SapiWebView.b(this.f20080a).removeCallbacks(SapiWebView.e(this.f20080a));
    }
}
