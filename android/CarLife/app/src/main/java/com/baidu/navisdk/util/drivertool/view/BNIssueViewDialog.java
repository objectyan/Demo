package com.baidu.navisdk.util.drivertool.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.WebviewUtils;
import com.baidu.navisdk.util.drivertool.BNDrivingToolManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNIssueViewDialog extends Dialog {
    private static final String URL = "http://webpage.navi.baidu.com/static/webpage/shareFunction/issuesList.html";
    private boolean isInSharePage = false;
    private View mIssueView = null;
    private Button mShareBtn = null;
    private String mUrl = null;
    private WebView mWebView = null;

    /* renamed from: com.baidu.navisdk.util.drivertool.view.BNIssueViewDialog$1 */
    class C47011 implements OnClickListener {
        C47011() {
        }

        public void onClick(View v) {
            if (BNIssueViewDialog.this.mWebView == null || !BNIssueViewDialog.this.mWebView.canGoBack()) {
                BNIssueViewDialog.this.dismiss();
                return;
            }
            BNIssueViewDialog.this.mWebView.goBack();
            BNIssueViewDialog.this.isInSharePage = false;
            BNIssueViewDialog.this.setShareView(8);
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.view.BNIssueViewDialog$2 */
    class C47022 implements OnClickListener {
        C47022() {
        }

        public void onClick(View v) {
            if (BNIssueViewDialog.this.isInSharePage) {
                BNaviModuleManager.shareDrivingToolUrl(BNIssueViewDialog.this.getShareUrl());
            }
        }
    }

    private class MyWebViewClient extends WebViewClient {
        private MyWebViewClient() {
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            BNIssueViewDialog.this.isInSharePage = true;
            BNIssueViewDialog.this.mUrl = url;
            BNIssueViewDialog.this.setShareView(0);
            return true;
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }

    public BNIssueViewDialog(Context context, int theme) {
        super(context, theme);
        initView(context);
    }

    private void initView(Context ctx) {
        this.mIssueView = JarUtils.inflate((Activity) ctx, C4048R.layout.nsdk_layout_driving_tool_issue_view, null);
        if (this.mIssueView != null) {
            ImageView backView = (ImageView) this.mIssueView.findViewById(C4048R.id.bnav_issue_view_back);
            if (backView != null) {
                backView.setOnClickListener(new C47011());
            }
            this.mShareBtn = (Button) this.mIssueView.findViewById(C4048R.id.share_btn);
            if (this.mShareBtn != null) {
                this.mShareBtn.setOnClickListener(new C47022());
            }
            setShareView(8);
            initWebView();
            setContentView(this.mIssueView);
        }
    }

    private String getShareUrl() {
        StringBuffer buf = new StringBuffer();
        buf.append(this.mUrl);
        buf.append("&share=yes");
        return buf.toString();
    }

    private void setShareView(int visibility) {
        if (this.mShareBtn != null) {
            this.mShareBtn.setVisibility(visibility);
            if (BNaviModuleManager.isGooglePlayChannel()) {
                this.mShareBtn.setVisibility(8);
            }
        }
    }

    private void initWebView() {
        this.mWebView = (WebView) this.mIssueView.findViewById(C4048R.id.bnav_issue_view_webview);
        this.mWebView.setWebViewClient(new MyWebViewClient());
        WebSettings settings = this.mWebView.getSettings();
        settings.setSupportZoom(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        WebviewUtils.disableJsInterface(this.mWebView);
        addCookie();
        CookieManager.getInstance().setAcceptCookie(true);
        this.mWebView.loadUrl(getLoadUrl());
    }

    private void addCookie() {
        CookieSyncManager cookieMng = CookieSyncManager.createInstance(BNaviModuleManager.getContext());
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        StringBuffer buf = new StringBuffer();
        buf.append("BDUSS=");
        buf.append(BNaviModuleManager.getBduss());
        buf.append(";domain=.baidu.com;path=/");
        String cookies = buf.toString();
        LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "issue view addcookie " + cookies);
        cookieManager.setCookie(getLoadUrl(), cookies);
        CookieSyncManager.getInstance().sync();
    }

    private String getLoadUrl() {
        StringBuffer buf = new StringBuffer();
        buf.append(URL);
        buf.append("?taskid=");
        buf.append(BNDrivingToolManager.getInstance().mTaskID);
        return buf.toString();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4 || !this.mWebView.canGoBack()) {
            return super.onKeyDown(keyCode, event);
        }
        this.mWebView.goBack();
        this.isInSharePage = false;
        setShareView(8);
        return true;
    }

    public void releaseResource() {
        if (this.mWebView != null) {
            this.mWebView.removeAllViews();
            this.mWebView.destroy();
            this.mWebView = null;
        }
    }
}
