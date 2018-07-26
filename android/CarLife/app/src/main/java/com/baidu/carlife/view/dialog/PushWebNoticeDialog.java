package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.presentation.p071a.C1307e;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.push.C2103a;
import com.baidu.carlife.util.C2173d;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.view.CommonTipView;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.util.common.PackageUtil;

public class PushWebNoticeDialog extends BaseDialog {
    /* renamed from: A */
    private static final String f7381A = "/getLocation";
    /* renamed from: B */
    private static final String f7382B = "product";
    /* renamed from: C */
    private static final String f7383C = "longitude";
    /* renamed from: D */
    private static final String f7384D = "latitude";
    /* renamed from: E */
    private static final String f7385E = "eventID";
    /* renamed from: F */
    private static final String f7386F = "label";
    /* renamed from: e */
    public static final String f7387e = "PushWebNoticeDialog";
    /* renamed from: f */
    public static CarlifeActivity f7388f = null;
    /* renamed from: g */
    public static final String f7389g = "carlife://";
    /* renamed from: h */
    public static final String f7390h = "找不到网页|服务器内部错误";
    /* renamed from: i */
    public static final String f7391i = "scheme=alipays";
    /* renamed from: j */
    public static final String f7392j = "tel:";
    /* renamed from: k */
    public static final String f7393k = "intent://";
    /* renamed from: l */
    public static final String f7394l = "http://carlife.baidu.com/static/carlifeweb/problems/android.html";
    /* renamed from: w */
    private static final String f7395w = "exit";
    /* renamed from: x */
    private static final String f7396x = "navi";
    /* renamed from: y */
    private static final String f7397y = "mtj";
    /* renamed from: z */
    private static final String f7398z = "registerJSFunction";
    /* renamed from: G */
    private String f7399G;
    /* renamed from: m */
    private String f7400m;
    /* renamed from: n */
    private WebView f7401n;
    /* renamed from: o */
    private boolean f7402o;
    /* renamed from: p */
    private boolean f7403p;
    /* renamed from: q */
    private CommonTipView f7404q;
    /* renamed from: r */
    private View f7405r;
    /* renamed from: s */
    private TextView f7406s;
    /* renamed from: t */
    private View f7407t;
    /* renamed from: u */
    private C1443g f7408u;
    /* renamed from: v */
    private TextView f7409v;

    /* renamed from: com.baidu.carlife.view.dialog.PushWebNoticeDialog$1 */
    class C22591 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ PushWebNoticeDialog f7375a;

        C22591(PushWebNoticeDialog this$0) {
            this.f7375a = this$0;
        }

        public void onClick(View v) {
            if (this.f7375a.f7401n.canGoBack()) {
                this.f7375a.f7401n.goBack();
                return;
            }
            this.f7375a.mo1526d();
            C1260i.m4435b(PushWebNoticeDialog.f7387e, "####### btn back dismiss");
        }
    }

    /* renamed from: com.baidu.carlife.view.dialog.PushWebNoticeDialog$2 */
    class C22602 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ PushWebNoticeDialog f7376a;

        C22602(PushWebNoticeDialog this$0) {
            this.f7376a = this$0;
        }

        public void onClick(View v) {
            if (this.f7376a.f7401n.canGoBack()) {
                this.f7376a.f7401n.goBack();
                return;
            }
            this.f7376a.mo1526d();
            C1260i.m4435b(PushWebNoticeDialog.f7387e, "####### hide back dismiss");
        }
    }

    /* renamed from: com.baidu.carlife.view.dialog.PushWebNoticeDialog$3 */
    class C22613 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ PushWebNoticeDialog f7377a;

        C22613(PushWebNoticeDialog this$0) {
            this.f7377a = this$0;
        }

        public void run() {
            C1307e.m4686a().mo1467b(StyleManager.getString(C0965R.string.plugin_loading));
        }
    }

    /* renamed from: com.baidu.carlife.view.dialog.PushWebNoticeDialog$4 */
    class C22624 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ PushWebNoticeDialog f7378a;

        C22624(PushWebNoticeDialog this$0) {
            this.f7378a = this$0;
        }

        public void run() {
            C1307e.m4686a().mo1468c();
        }
    }

    /* renamed from: com.baidu.carlife.view.dialog.PushWebNoticeDialog$a */
    public class C2263a extends WebChromeClient {
        /* renamed from: a */
        final /* synthetic */ PushWebNoticeDialog f7379a;

        public C2263a(PushWebNoticeDialog this$0) {
            this.f7379a = this$0;
        }

        public void onGeolocationPermissionsHidePrompt() {
            super.onGeolocationPermissionsHidePrompt();
        }

        public void onGeolocationPermissionsShowPrompt(String origin, Callback callback) {
            super.onGeolocationPermissionsShowPrompt(origin, callback);
            callback.invoke(origin, true, false);
        }

        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            if (!TextUtils.isEmpty(title)) {
                this.f7379a.m8581b(title);
            }
            C1260i.m4435b(PushWebNoticeDialog.f7387e, "onReceivedTitle title=" + title);
            if (TextUtils.isEmpty(view.getUrl()) || this.f7379a.f7403p) {
                this.f7379a.m8591n();
                return;
            }
            this.f7379a.f7405r.setVisibility(8);
            this.f7379a.f7401n.setVisibility(0);
        }
    }

    /* renamed from: com.baidu.carlife.view.dialog.PushWebNoticeDialog$b */
    public class C2264b extends WebViewClient {
        /* renamed from: a */
        final /* synthetic */ PushWebNoticeDialog f7380a;

        public C2264b(PushWebNoticeDialog this$0) {
            this.f7380a = this$0;
        }

        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.cancel();
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.startsWith("carlife://") && this.f7380a.m8585c(url)) {
                view.stopLoading();
            } else {
                C1260i.m4435b(PushWebNoticeDialog.f7387e, "shouldOverrideUrlLoading：" + url);
                if (TextUtils.isEmpty(url)) {
                    view.loadUrl(url);
                }
            }
            return true;
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            C1260i.m4435b(PushWebNoticeDialog.f7387e, "onPageStarted url=" + url);
            this.f7380a.f7403p = false;
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            C1260i.m4435b(PushWebNoticeDialog.f7387e, "onPageFinished url=" + url);
            this.f7380a.m8589l();
            if (!this.f7380a.f7403p && this.f7380a.f7405r != null) {
                this.f7380a.f7405r.setVisibility(8);
                this.f7380a.f7401n.setVisibility(0);
            }
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            C1260i.m4435b(PushWebNoticeDialog.f7387e, "onReceivedError errorCode=" + errorCode + ", description=" + description);
            view.stopLoading();
            this.f7380a.m8589l();
            this.f7380a.m8591n();
        }
    }

    public PushWebNoticeDialog(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PushWebNoticeDialog(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f7402o = true;
        this.f7403p = false;
        this.f7399G = "http://carlife.baidu.com/static/carlifeweb/problems/android.html";
        this.c = context;
    }

    public PushWebNoticeDialog(Context context) {
        super(context, null, 0);
        this.f7402o = true;
        this.f7403p = false;
        this.f7399G = "http://carlife.baidu.com/static/carlifeweb/problems/android.html";
        this.c = context;
    }

    /* renamed from: a */
    protected View mo1528a() {
        return LayoutInflater.from(this.c).inflate(C0965R.layout.dialog_web_view, null);
    }

    /* renamed from: b */
    protected void mo1529b() {
        this.f7404q = (CommonTipView) findViewById(C0965R.id.common_tip_view);
        this.f7404q.setVisibility(8);
        this.f7400m = getResources().getString(C0965R.string.setting_help);
        this.f7401n = (WebView) findViewById(C0965R.id.web_view);
        this.f7401n.removeJavascriptInterface("searchBoxJavaBridge_");
        this.f7401n.removeJavascriptInterface("accessibility");
        this.f7401n.removeJavascriptInterface("accessibilityTraversal");
        this.f7401n.setBackgroundColor(getResources().getColor(C0965R.color.cl_bg_c_main));
        C1260i.m4435b(f7387e, "Web dialog: " + this.f7399G);
        mo1630i();
        m8588k();
        setWebviewSettings(this.f7401n);
        m8596j();
        this.f7399G = C2103a.m7883b();
        if (this.f7399G == null || this.f7399G.isEmpty()) {
            C1260i.m4435b(f7387e, "Web dialog: " + this.f7399G);
            m8591n();
        }
        this.f7401n.loadUrl(this.f7399G);
    }

    /* renamed from: i */
    protected void mo1630i() {
        ImageButton btnBack = (ImageButton) findViewById(C0965R.id.ib_left);
        if (btnBack != null) {
            btnBack.setImageDrawable(C2188r.m8331b(C0965R.drawable.com_ic_back));
            btnBack.setBackground(C2251b.m8527a(this.c));
        }
        TextView titleTV = (TextView) findViewById(C0965R.id.tv_title);
        if (titleTV != null) {
            titleTV.setTextColor(C2188r.m8328a((int) C0965R.color.cl_text_a4_title));
        }
    }

    /* renamed from: k */
    private void m8588k() {
        this.f7405r = findViewById(C0965R.id.common_top_title);
        this.f7405r.setVisibility(8);
        ImageButton btnBack = (ImageButton) findViewById(C0965R.id.ib_left);
        if (btnBack != null) {
            btnBack.setOnClickListener(new C22591(this));
        }
        View hide = findViewById(C0965R.id.view_hide);
        if (hide != null) {
            hide.setOnClickListener(new C22602(this));
        }
        this.f7409v = (TextView) findViewById(C0965R.id.tv_title);
        m8581b(this.f7400m);
    }

    /* renamed from: b */
    private void m8581b(String title) {
        if (this.f7409v != null && !TextUtils.isEmpty(title)) {
            this.f7409v.setText(title);
        }
    }

    /* renamed from: f */
    public void mo1530f() {
    }

    public void setWebviewSettings(WebView mWebView) {
        WebSettings settings = mWebView.getSettings();
        settings.setCacheMode(-1);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(false);
        settings.setUseWideViewPort(true);
        settings.setBlockNetworkImage(false);
        String dir = C2173d.m8225a().m8228b().getPath();
        settings.setSupportMultipleWindows(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(dir);
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(dir);
        settings.setAppCacheEnabled(true);
        settings.setAppCachePath(C2173d.m8225a().m8229c().getPath());
        settings.setAppCacheMaxSize(8388608);
        settings.setAllowFileAccess(true);
        settings.setUserAgentString(settings.getUserAgentString() + " baiduNavi_ANDR(" + PackageUtil.getVersionName() + ")");
        if (VERSION.SDK_INT >= 11) {
            settings.setAllowContentAccess(true);
        }
        mWebView.setScrollBarStyle(0);
        mWebView.setVerticalFadingEdgeEnabled(false);
        mWebView.setFadingEdgeLength(0);
        mWebView.setLayerType(1, null);
        mWebView.setWebChromeClient(new C2263a(this));
        mWebView.setWebViewClient(new C2264b(this));
    }

    /* renamed from: j */
    public void m8596j() {
        if (f7388f != null) {
            f7388f.runOnUiThread(new C22613(this));
        }
    }

    /* renamed from: l */
    private void m8589l() {
        if (f7388f != null) {
            f7388f.runOnUiThread(new C22624(this));
        }
    }

    /* renamed from: m */
    private void m8590m() {
        mo1526d();
    }

    /* renamed from: c */
    private boolean m8585c(String url) {
        Uri uri = Uri.parse(url);
        String authority = uri.getAuthority();
        C1260i.m4445e(f7387e, "dispatchJsMethod: authority=" + authority);
        if (!TextUtils.isEmpty(authority)) {
            String product = uri.getQueryParameter(f7382B);
            C1260i.m4445e(f7387e, "dispatchJsMethod: product=" + product);
            if (TextUtils.isEmpty(product)) {
                C1260i.m4445e(f7387e, "Js invoke parameter product should not be empty.");
            } else if ("exit".equalsIgnoreCase(authority)) {
                C1260i.m4445e(f7387e, "Js method: exit");
                m8590m();
            } else if (f7397y.equalsIgnoreCase(authority)) {
                C1260i.m4445e(f7387e, "Js method: mtj");
                String eventID = uri.getQueryParameter(f7385E);
                C1260i.m4435b(f7387e, "mtj eventID=" + eventID + " label=" + uri.getQueryParameter("label"));
            }
        }
        return true;
    }

    /* renamed from: n */
    private void m8591n() {
        C1260i.m4435b(f7387e, "showErrorPage !!!");
        this.f7403p = true;
        if (this.f7404q != null) {
            this.f7404q.m8397a(1);
            this.f7404q.setVisibility(0);
        }
        this.f7401n.setVisibility(8);
        if (this.f7405r != null) {
            this.f7405r.setVisibility(0);
        }
    }
}
