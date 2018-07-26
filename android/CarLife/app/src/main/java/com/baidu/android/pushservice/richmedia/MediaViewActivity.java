package com.baidu.android.pushservice.richmedia;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.che.codriver.platform.NaviCmdConstants;

public class MediaViewActivity extends Activity {
    /* renamed from: a */
    public WebView f2016a;
    /* renamed from: b */
    private RelativeLayout f2017b;
    /* renamed from: c */
    private WebChromeClient f2018c = new C06361(this);
    /* renamed from: d */
    private WebViewClient f2019d = new C06372(this);

    /* renamed from: com.baidu.android.pushservice.richmedia.MediaViewActivity$1 */
    class C06361 extends WebChromeClient {
        /* renamed from: a */
        final /* synthetic */ MediaViewActivity f2014a;

        C06361(MediaViewActivity mediaViewActivity) {
            this.f2014a = mediaViewActivity;
        }

        public void onHideCustomView() {
        }

        public void onProgressChanged(WebView webView, int i) {
        }

        public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        }
    }

    /* renamed from: com.baidu.android.pushservice.richmedia.MediaViewActivity$2 */
    class C06372 extends WebViewClient {
        /* renamed from: a */
        final /* synthetic */ MediaViewActivity f2015a;

        C06372(MediaViewActivity mediaViewActivity) {
            this.f2015a = mediaViewActivity;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Intent intent;
            if (str.startsWith("tel:")) {
                try {
                    intent = new Intent("android.intent.action.DIAL");
                    intent.setData(Uri.parse(str));
                    this.f2015a.startActivity(intent);
                } catch (ActivityNotFoundException e) {
                }
            } else if (str.startsWith("geo:")) {
                try {
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    this.f2015a.startActivity(intent);
                } catch (ActivityNotFoundException e2) {
                }
            } else if (str.startsWith("mailto:")) {
                try {
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    this.f2015a.startActivity(intent);
                } catch (ActivityNotFoundException e3) {
                }
            } else if (str.startsWith("sms:")) {
                try {
                    String substring;
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    int indexOf = str.indexOf(63);
                    if (indexOf == -1) {
                        substring = str.substring(4);
                    } else {
                        substring = str.substring(4, indexOf);
                        String query = Uri.parse(str).getQuery();
                        if (query != null && query.startsWith("body=")) {
                            intent2.putExtra("sms_body", query.substring(5));
                        }
                    }
                    intent2.setData(Uri.parse("sms:" + substring));
                    intent2.putExtra(NaviCmdConstants.KEY_NAVI_CMD_DEST_ADDRESS, substring);
                    intent2.setType("vnd.android-dir/mms-sms");
                    this.f2015a.startActivity(intent2);
                } catch (ActivityNotFoundException e4) {
                }
            }
            if (VERSION.SDK_INT > 17) {
                try {
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    this.f2015a.startActivity(intent);
                } catch (ActivityNotFoundException e5) {
                }
            } else {
                webView.loadUrl(str);
            }
            return true;
        }
    }

    @TargetApi(11)
    /* renamed from: a */
    private void m2792a() {
        this.f2016a.removeJavascriptInterface("searchBoxJavaBridge_");
        this.f2016a.removeJavascriptInterface("accessibility");
        this.f2016a.removeJavascriptInterface("accessibilityTraversal");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().requestFeature(1);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 0.0f);
        this.f2017b = new RelativeLayout(this);
        this.f2017b.setLayoutParams(layoutParams);
        this.f2017b.setGravity(1);
        this.f2016a = new WebView(this);
        if (VERSION.SDK_INT >= 11) {
            m2792a();
        }
        this.f2016a.requestFocusFromTouch();
        this.f2016a.setLongClickable(true);
        WebSettings settings = this.f2016a.getSettings();
        settings.setCacheMode(1);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setLightTouchEnabled(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setSavePassword(false);
        this.f2016a.setLayoutParams(new LayoutParams(-1, -1));
        this.f2016a.setWebChromeClient(this.f2018c);
        this.f2016a.setWebViewClient(this.f2019d);
        this.f2017b.addView(this.f2016a);
        setContentView(this.f2017b);
        if (this.f2017b == null || this.f2016a == null) {
            finish();
        }
        Uri data = getIntent().getData();
        if (data != null) {
            this.f2016a.loadUrl(data.toString());
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        Uri data = intent.getData();
        if (data != null) {
            this.f2016a.loadUrl(data.toString());
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }
}
