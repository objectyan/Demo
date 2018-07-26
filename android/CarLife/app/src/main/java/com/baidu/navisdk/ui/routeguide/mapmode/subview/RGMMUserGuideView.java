package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Message;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout.LayoutParams;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGUserGuideModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.ui.widget.BNWebViewClient;
import com.baidu.navisdk.util.common.LogUtil;

public class RGMMUserGuideView extends BNBaseView {
    private static final String TAG = RGMMUserGuideView.class.getSimpleName();
    private static final String URL_USER_GUIDE = "http://webpage.navi.baidu.com/static/webpage/NoviceNavigation/";
    private ViewGroup mGuideViewContails = null;
    private WebView mWebView = null;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMUserGuideView$1 */
    class C44411 extends BNWebViewClient {
        C44411() {
        }

        public boolean onEventBNavi(int msgType, WebView webview, String url, Message msg) {
            switch (msgType) {
                case 0:
                    RGMMUserGuideView.this.hide();
                    break;
            }
            return true;
        }

        public boolean onEventAndroid(int msgType, WebView webview, String url, Message msg) {
            switch (msgType) {
                case 2:
                    if (url != null && RGMMUserGuideView.URL_USER_GUIDE.startsWith(url)) {
                        RGUserGuideModel.getInstance().mReceivError = false;
                        RGUserGuideModel.getInstance().mLoadStartTime = SystemClock.elapsedRealtime();
                        break;
                    }
                case 3:
                    if (url != null && RGMMUserGuideView.URL_USER_GUIDE.startsWith(url)) {
                        RGUserGuideModel.getInstance().mLoadEndTime = SystemClock.elapsedRealtime();
                        RGMMUserGuideView.this.show();
                        break;
                    }
                case 4:
                    RGUserGuideModel.getInstance().mReceivError = true;
                    break;
            }
            return true;
        }
    }

    public RGMMUserGuideView(Context context, ViewGroup viewGroup, OnRGSubViewListener listener) {
        super(context, viewGroup, listener);
        try {
            initViews();
            loadWebData();
        } catch (Exception e) {
            LogUtil.m15791e(TAG, "init exception:" + e.getMessage());
        }
    }

    private void initViews() {
        this.mWebView = new WebView(this.mContext);
        this.mWebView.setBackgroundColor(0);
        setWebViewSettings(this.mWebView);
        setWebViewClient(this.mWebView);
    }

    private void setWebViewSettings(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setLoadWithOverviewMode(true);
        settings.setCacheMode(-1);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(false);
        settings.setUseWideViewPort(true);
        settings.setSupportMultipleWindows(true);
    }

    private void setWebViewClient(WebView webView) {
        webView.setWebViewClient(new C44411());
    }

    private void loadWebData() {
        this.mWebView.loadUrl(URL_USER_GUIDE);
    }

    public void updateOrientation() {
        show();
    }

    public void show() {
        if (this.mWebView == null) {
            LogUtil.m15791e(TAG, "webview is null");
        } else if (RGUserGuideModel.getInstance().satisfyCondition()) {
            this.mGuideViewContails = RGMapModeViewController.getInstance().getUserGuideViewContails();
            if (this.mGuideViewContails == null) {
                LogUtil.m15791e(TAG, "viewContails is null");
                return;
            }
            super.show();
            ViewGroup viewGroup = (ViewGroup) this.mWebView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.mWebView);
            }
            this.mGuideViewContails.addView(this.mWebView, new LayoutParams(-1, -1));
            this.mGuideViewContails.setVisibility(0);
            RGUserGuideModel.getInstance().isShowing = true;
            BNSettingManager.setHasShowUserGuide(true);
        } else {
            LogUtil.m15791e(TAG, "not satisfyCondition");
        }
    }

    public void hide() {
        super.hide();
        if (this.mGuideViewContails != null) {
            this.mGuideViewContails.setVisibility(8);
        }
        RGUserGuideModel.getInstance().isShowing = false;
        dispose();
    }

    public void dispose() {
        if (this.mWebView != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) this.mWebView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.mWebView);
                }
                if (VERSION.SDK_INT >= 11) {
                    this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
                }
                this.mWebView.removeAllViews();
                this.mWebView.destroy();
            } catch (Exception e) {
                LogUtil.m15791e(TAG, "webview dispose exception");
            }
        }
        this.mWebView = null;
        this.mSubViewListener = null;
        this.mGuideViewContails = null;
        this.mContext = null;
    }
}
