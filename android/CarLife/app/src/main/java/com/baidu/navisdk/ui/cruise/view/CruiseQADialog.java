package com.baidu.navisdk.ui.cruise.view;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.common.WebviewUtils;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class CruiseQADialog extends Dialog {
    private static final String URL = (HttpURLManager.getInstance().getScheme() + "appnavi.baidu.com/distance/electroneyes?mid=2&os=android&mobile=i9300&cuid=niubi&channel=baidu&appvercode=4.0");
    private Activity mActivity;
    private WebView mDetailWebView = null;
    private View mQAView;

    /* renamed from: com.baidu.navisdk.ui.cruise.view.CruiseQADialog$1 */
    class C42911 implements OnClickListener {
        C42911() {
        }

        public void onClick(View v) {
            CruiseQADialog.this.dismiss();
            WebviewUtils.pauseWebview(CruiseQADialog.this.mDetailWebView);
        }
    }

    private class MyWebViewClient extends WebViewClient {
        private MyWebViewClient() {
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }

    public CruiseQADialog(Activity activity, int theme) {
        super(activity, theme);
        this.mActivity = activity;
        initView();
    }

    public void initView() {
        this.mQAView = JarUtils.inflate(this.mActivity, C4048R.layout.nsdk_layout_cruise_qa, null);
        if (this.mQAView != null) {
            this.mQAView.findViewById(C4048R.id.bnav_cruise_qa_back).setOnClickListener(new C42911());
            initWebView();
            setContentView(this.mQAView);
        }
    }

    private void initWebView() {
        this.mDetailWebView = (WebView) this.mQAView.findViewById(C4048R.id.bnav_cruise_qa_webview);
        this.mDetailWebView.setWebViewClient(new MyWebViewClient());
        WebSettings settings = this.mDetailWebView.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(false);
        settings.setUseWideViewPort(true);
        this.mDetailWebView.loadUrl(URL);
    }
}
