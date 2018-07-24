package com.baidu.carlife.fragment;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.SslErrorHandler;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;
import com.baidu.baidunavis.control.NavRouteGuideController;
import com.baidu.baidunavis.control.NavRouteGuideController.BNavigatorListener;
import com.baidu.carlife.R;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.screen.OnBtnClickListener;
import com.baidu.carlife.core.screen.CarLifeSearchPoi;
import com.baidu.carlife.core.screen.presentation.view.CarlifeProgressDialogContainer;
import com.baidu.carlife.core.screen.presentation.view.CarlifeViewContainer;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.custom.C1343b;
import com.baidu.carlife.logic.C1856o;
import com.baidu.carlife.logic.C1868q;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.util.C2173d;
import com.baidu.carlife.util.C2183m;
import com.baidu.carlife.util.C2183m.C2182a;
import com.baidu.carlife.view.CommonTipView;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.WebviewUtils;
import java.util.ArrayList;
import java.util.List;

public class WebViewFragment extends ContentFragment {
    /* renamed from: A */
    private static final String f4858A = "eventID";
    /* renamed from: B */
    private static final String f4859B = "label";
    /* renamed from: C */
    private static List<String> f4860C = new ArrayList();
    /* renamed from: a */
    public static final String f4861a = "bundle_title_key";
    /* renamed from: b */
    public static final String f4862b = "bundle_url_key";
    /* renamed from: c */
    public static final String f4863c = "bundle_type";
    /* renamed from: d */
    public static final int f4864d = 0;
    /* renamed from: e */
    public static final int f4865e = 1;
    /* renamed from: f */
    public static final int f4866f = 2;
    /* renamed from: g */
    public static final int f4867g = 3;
    /* renamed from: h */
    public static final int f4868h = 4;
    /* renamed from: i */
    public static final String f4869i = "https://jyb.jyblife.com/buy/clBuyPage";
    /* renamed from: j */
    public static final String f4870j = "http://carlife.etcp.cn/index/index";
    /* renamed from: k */
    public static final String f4871k = "http://carlife.baidu.com/carlife/act";
    /* renamed from: l */
    public static final String f4872l = "http://119.147.84.47:886/baidu/login.html";
    /* renamed from: m */
    public static final String f4873m = "http://carlife.baidu.com/static/carlifeweb/problems/android.html";
    /* renamed from: n */
    public static final String f4874n = "找不到网页|服务器内部错误";
    /* renamed from: o */
    public static final String f4875o = "scheme=alipays";
    /* renamed from: p */
    public static final String f4876p = "tel:";
    /* renamed from: q */
    public static final String f4877q = "intent://";
    /* renamed from: r */
    public static final String f4878r = "carlife://";
    /* renamed from: s */
    private static final String f4879s = "exit";
    /* renamed from: t */
    private static final String f4880t = "navi";
    /* renamed from: u */
    private static final String f4881u = "mtj";
    /* renamed from: v */
    private static final String f4882v = "registerJSFunction";
    /* renamed from: w */
    private static final String f4883w = "/getLocation";
    /* renamed from: x */
    private static final String f4884x = "product";
    /* renamed from: y */
    private static final String f4885y = "longitude";
    /* renamed from: z */
    private static final String f4886z = "latitude";
    /* renamed from: D */
    private int f4887D = 0;
    /* renamed from: E */
    private String f4888E;
    /* renamed from: F */
    private WebView f4889F;
    /* renamed from: G */
    private boolean f4890G = true;
    /* renamed from: H */
    private boolean f4891H = false;
    /* renamed from: I */
    private String f4892I;
    /* renamed from: J */
    private CommonTipView f4893J;
    /* renamed from: K */
    private View f4894K;
    /* renamed from: L */
    private TextView f4895L;

    /* renamed from: com.baidu.carlife.fragment.WebViewFragment$1 */
    class C15901 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ WebViewFragment f4845a;

        C15901(WebViewFragment this$0) {
            this.f4845a = this$0;
        }

        public void onClick(View v) {
            if (!this.f4845a.f4889F.canGoBack() || this.f4845a.m5846d()) {
                Bundle bundle;
                if (this.f4845a.f4887D == 1) {
                    bundle = new Bundle();
                    bundle.putInt(WebViewFragment.f4863c, this.f4845a.f4887D);
                    this.f4845a.back(bundle);
                } else {
                    this.f4845a.back(null);
                }
                if (this.f4845a.f4887D == 2) {
                    bundle = new Bundle();
                    bundle.putInt(WebViewFragment.f4863c, this.f4845a.f4887D);
                    this.f4845a.openNavi(bundle);
                    return;
                }
                return;
            }
            this.f4845a.f4889F.goBack();
        }
    }

    /* renamed from: com.baidu.carlife.fragment.WebViewFragment$2 */
    class C15912 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ WebViewFragment f4846a;

        C15912(WebViewFragment this$0) {
            this.f4846a = this$0;
        }

        public void onClick(View v) {
            if (!this.f4846a.f4889F.canGoBack() || this.f4846a.m5846d()) {
                Bundle bundle;
                if (this.f4846a.f4887D == 1) {
                    bundle = new Bundle();
                    bundle.putInt(WebViewFragment.f4863c, this.f4846a.f4887D);
                    this.f4846a.back(bundle);
                } else {
                    this.f4846a.back(null);
                }
                if (this.f4846a.f4887D == 2) {
                    bundle = new Bundle();
                    bundle.putInt(WebViewFragment.f4863c, this.f4846a.f4887D);
                    this.f4846a.openNavi(bundle);
                    return;
                }
                return;
            }
            this.f4846a.f4889F.goBack();
        }
    }

    /* renamed from: com.baidu.carlife.fragment.WebViewFragment$5 */
    class C15945 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ WebViewFragment f4851a;

        C15945(WebViewFragment this$0) {
            this.f4851a = this$0;
        }

        public void run() {
            CarlifeProgressDialogContainer.m4686a().mo1467b(StyleManager.getString(R.string.plugin_loading));
        }
    }

    /* renamed from: com.baidu.carlife.fragment.WebViewFragment$6 */
    class C15956 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ WebViewFragment f4852a;

        C15956(WebViewFragment this$0) {
            this.f4852a = this$0;
        }

        public void run() {
            CarlifeProgressDialogContainer.m4686a().mo1468c();
        }
    }

    /* renamed from: com.baidu.carlife.fragment.WebViewFragment$8 */
    class C15978 implements BNavigatorListener {
        /* renamed from: a */
        final /* synthetic */ WebViewFragment f4855a;

        C15978(WebViewFragment this$0) {
            this.f4855a = this$0;
        }

        public void onPageJump(int jumpTiming, Object arg) {
            if (!NavRouteGuideController.getInstance().newGuideIsThirdServer()) {
                CarlifeViewContainer.m4699a().m4701b().performOpenHome();
                NavRouteGuideController.getInstance().setBNavigatorListener(null);
            }
            NavRouteGuideController.getInstance().setNewGuideIsThirdServer(false);
        }
    }

    /* renamed from: com.baidu.carlife.fragment.WebViewFragment$a */
    public class C1598a extends WebChromeClient {
        /* renamed from: a */
        final /* synthetic */ WebViewFragment f4856a;

        public C1598a(WebViewFragment this$0) {
            this.f4856a = this$0;
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
            LogUtil.d("Framework", "onReceivedTitle title=" + title);
            if (this.f4856a.m5839b(title) || this.f4856a.f4887D != 3) {
                this.f4856a.m5832a(title);
            }
            String url = view.getUrl();
            if ((TextUtils.isEmpty(url) || url.startsWith("carlife://") || !this.f4856a.m5839b(title)) && !this.f4856a.f4891H) {
                if (this.f4856a.f4887D != 3) {
                    this.f4856a.f4894K.setVisibility(8);
                }
                this.f4856a.f4889F.setVisibility(0);
                return;
            }
            this.f4856a.m5848e();
        }
    }

    /* renamed from: com.baidu.carlife.fragment.WebViewFragment$b */
    public class C1599b extends WebViewClient {
        /* renamed from: a */
        final /* synthetic */ WebViewFragment f4857a;

        public C1599b(WebViewFragment this$0) {
            this.f4857a = this$0;
        }

        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.cancel();
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            LogUtil.d("Framework", "shouldOverrideUrlLoading：" + url);
            if (!TextUtils.isEmpty(url)) {
                if (url.startsWith("intent://") || (this.f4857a.f4887D == 1 && url.contains("scheme=alipays"))) {
                    try {
                        Intent intent = Intent.parseUri(url, 1);
                        intent.addCategory("android.intent.category.BROWSABLE");
                        intent.setComponent(null);
                        this.f4857a.startActivityForResult(intent, 2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return true;
                }
                if (url.startsWith("carlife://") && this.f4857a.m5847d(url)) {
                    view.stopLoading();
                    return true;
                } else if (url.startsWith("tel:")) {
                    String number = url.replace("tel:", "");
                    if (!TextUtils.isEmpty(number)) {
                        this.f4857a.m5842c(number);
                    }
                    return true;
                }
            }
            view.loadUrl(url);
            return true;
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            LogUtil.d("Framework", "onPageStarted url=" + url);
            this.f4857a.f4891H = false;
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            LogUtil.d("Framework", "onPageFinished url=" + url);
            this.f4857a.m5851f();
            if (!((this.f4857a.f4887D != 1 && this.f4857a.f4887D != 4 && this.f4857a.f4887D != 2 && this.f4857a.f4887D != 3) || this.f4857a.f4891H || this.f4857a.f4894K == null)) {
                if (this.f4857a.f4887D != 3) {
                    this.f4857a.f4894K.setVisibility(8);
                }
                this.f4857a.f4889F.setVisibility(0);
            }
            if (this.f4857a.f4887D == 3 && C1856o.m7042a().m7045b()) {
                C1856o.m7042a().m7047d();
            }
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            LogUtil.d("Framework", "onReceivedError errorCode=" + errorCode + ", description=" + description);
            view.stopLoading();
            this.f4857a.m5851f();
            this.f4857a.m5848e();
        }
    }

    static {
        f4860C.add("http://carlife.etcp.cn/index/parkingFee");
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mContentView = inflater.inflate(R.layout.about_web_view, null);
        if (this.mShowBundle != null) {
            this.f4888E = this.mShowBundle.getString(f4861a);
            this.f4887D = this.mShowBundle.getInt(f4863c, 0);
            this.f4892I = this.mShowBundle.getString(f4862b);
        }
        this.f4893J = (CommonTipView) this.mContentView.findViewById(R.id.common_tip_view);
        this.f4893J.setVisibility(8);
        this.f4889F = (WebView) this.mContentView.findViewById(R.id.web_view);
        this.f4889F.removeJavascriptInterface("searchBoxJavaBridge_");
        this.f4889F.removeJavascriptInterface("accessibility");
        this.f4889F.removeJavascriptInterface("accessibilityTraversal");
        m5836b();
        m5855a(this.f4889F);
        onUpdateStyle(true);
        return this.mContentView;
    }

    /* renamed from: b */
    private void m5836b() {
        this.f4894K = this.mContentView.findViewById(R.id.common_top_title);
        this.f4894K.setVisibility(8);
        ImageButton btnBack = (ImageButton) this.mContentView.findViewById(R.id.ib_left);
        if (btnBack != null) {
            btnBack.setOnClickListener(new C15901(this));
        }
        View hide = this.mContentView.findViewById(R.id.view_hide);
        if (hide != null) {
            hide.setOnClickListener(new C15912(this));
        }
        this.f4895L = (TextView) this.mContentView.findViewById(R.id.tv_title);
        m5832a(this.f4888E);
    }

    /* renamed from: a */
    private void m5832a(String title) {
        if (this.f4895L != null && !TextUtils.isEmpty(title)) {
            this.f4895L.setText(title);
        }
    }

    protected void onInitView() {
        m5841c();
    }

    /* renamed from: c */
    private void m5841c() {
        if (!TextUtils.isEmpty(this.f4892I)) {
            LogUtil.d("Framework", "loadUrl mUrl=" + this.f4892I);
            if (this.f4890G || this.f4891H) {
                if (this.f4894K != null) {
                    if (this.f4887D == 1 || this.f4887D == 2 || this.f4887D == 3 || this.f4887D == 4) {
                        this.f4894K.setVisibility(0);
                        this.f4889F.setVisibility(8);
                    } else {
                        this.f4894K.setVisibility(8);
                    }
                }
                m5854a();
                this.f4889F.loadUrl(this.f4892I);
            }
            this.f4890G = false;
        }
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
        updateCommonSkin();
        this.f4889F.setBackgroundColor(getResources().getColor(R.color.cl_bg_c_main));
    }

    public void onResume() {
        super.onResume();
        WebviewUtils.resumeWebview(this.f4889F);
    }

    public void onPause() {
        super.onPause();
        WebviewUtils.pauseWebview(this.f4889F);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onDestroy() {
        super.onDestroy();
        NavRouteGuideController.getInstance().setBNavigatorListener(null);
    }

    public void back() {
        if (this.f4887D == 2) {
            super.back();
            showLatestNaviFragment();
            return;
        }
        super.back();
    }

    public boolean onBackPressed() {
        if (this.f4889F.canGoBack() && !m5846d()) {
            this.f4889F.goBack();
            return true;
        } else if (this.f4887D == 1) {
            bundle = new Bundle();
            bundle.putInt(f4863c, this.f4887D);
            back(bundle);
            return true;
        } else if (this.f4887D != 2) {
            return false;
        } else {
            back();
            bundle = new Bundle();
            bundle.putInt(f4863c, this.f4887D);
            openNavi(bundle);
            return true;
        }
    }

    public void onHiddenChanged(boolean hidden) {
        if (!hidden) {
            setBottomBarStatus(false);
        }
        super.onHiddenChanged(hidden);
        if (!hidden && C1663a.m5979a().m5993N()) {
            m5852g();
        }
    }

    /* renamed from: d */
    private boolean m5846d() {
        String currentUrl = this.f4889F.getUrl();
        WebBackForwardList backForwardList = this.f4889F.copyBackForwardList();
        if (TextUtils.isEmpty(currentUrl) || !f4860C.contains(currentUrl) || backForwardList.getSize() <= 1) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public void m5855a(WebView mWebView) {
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
        mWebView.setWebChromeClient(new C1598a(this));
        mWebView.setWebViewClient(new C1599b(this));
    }

    /* renamed from: a */
    private void m5831a(WebView view, SslErrorHandler handler, SslError error) {
        final SslErrorHandler handlerFinal = handler;
        LogUtil.m4445e("Framework", "onReceivedSslError：error" + error);
        Builder builder = new Builder(getContext());
        error.getPrimaryError();
        builder.setMessage(R.string.web_view_ssl_error);
        builder.setPositiveButton("continue", new DialogInterface.OnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ WebViewFragment f4848b;

            public void onClick(DialogInterface dialog, int which) {
                handlerFinal.proceed();
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ WebViewFragment f4850b;

            public void onClick(DialogInterface dialog, int which) {
                handlerFinal.cancel();
            }
        });
        builder.create().show();
    }

    /* renamed from: e */
    private void m5848e() {
        this.f4891H = true;
        this.f4893J.m8397a(1);
        this.f4893J.setVisibility(0);
        this.f4889F.setVisibility(8);
        this.f4894K.setVisibility(0);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            this.f4889F.loadUrl(this.f4892I);
        }
    }

    /* renamed from: b */
    private boolean m5839b(String title) {
        if (TextUtils.isEmpty(title) || !"找不到网页|服务器内部错误".contains(title)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public void m5854a() {
        mActivity.runOnUiThread(new C15945(this));
    }

    /* renamed from: f */
    private void m5851f() {
        mActivity.runOnUiThread(new C15956(this));
    }

    /* renamed from: c */
    private void m5842c(final String number) {
        showDialog(new C1953c(getContext()).m7444b(number).m7450d((int) R.string.alert_cancel).m7458q().m7438a(new OnBtnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ WebViewFragment f4854b;

            public void onClick() {
                C1868q.m7089f().m7107a(this.f4854b.getContext(), number);
            }
        }));
    }

    /* renamed from: d */
    private boolean m5847d(String url) {
        Uri uri = Uri.parse(url);
        String authority = uri.getAuthority();
        LogUtil.m4445e("Framework", "dispatchJsMethod: authority=" + authority);
        if (!TextUtils.isEmpty(authority)) {
            String product = uri.getQueryParameter(f4884x);
            LogUtil.m4445e("Framework", "dispatchJsMethod: product=" + product);
            if (TextUtils.isEmpty(product)) {
                LogUtil.m4445e("Framework", "Js invoke parameter product should not be empty.");
            } else if ("exit".equalsIgnoreCase(authority)) {
                LogUtil.m4445e("Framework", "Js method: exit");
                m5852g();
            } else if ("navi".equalsIgnoreCase(authority)) {
                LogUtil.m4445e("Framework", "Js method: navi");
                String longitude = uri.getQueryParameter("longitude");
                String latitude = uri.getQueryParameter("latitude");
                LogUtil.d("Framework", "navi longitude=" + longitude + ", latitude=" + latitude);
                m5830a(Double.valueOf(longitude).doubleValue(), Double.valueOf(latitude).doubleValue());
            } else if (f4882v.equalsIgnoreCase(authority)) {
                LogUtil.m4445e("Framework", "Js method: registerJSFunction");
                String path = uri.getPath();
                LogUtil.d("Framework", "path=" + path);
                if (f4883w.equalsIgnoreCase(path)) {
                    C2182a positionInfo = C2183m.m8293a().m8294b();
                    if (positionInfo == null) {
                        return true;
                    }
                    String jsFun = "javascript:getLocation('{\"longitude\":" + positionInfo.m8289a() + ",\"latitude\":" + positionInfo.m8291b() + "}')";
                    LogUtil.d("Framework", "jsFun=" + jsFun);
                    this.f4889F.loadUrl(jsFun);
                }
            } else if (f4881u.equalsIgnoreCase(authority)) {
                LogUtil.m4445e("Framework", "Js method: mtj");
                String eventID = uri.getQueryParameter(f4858A);
                String label = uri.getQueryParameter("label");
                LogUtil.d("Framework", "mtj eventID=" + eventID + " label=" + label);
                m5833a(eventID, label);
            }
        }
        return true;
    }

    /* renamed from: a */
    private void m5833a(String eventID, String label) {
        StatisticManager.onEvent(eventID, label);
    }

    /* renamed from: g */
    private void m5852g() {
        mActivity.m3117m();
        if (this.f4887D == 1) {
            Bundle bundle = new Bundle();
            bundle.putInt(f4863c, this.f4887D);
            back(bundle);
        } else {
            back(null);
        }
        if (this.f4887D == 2) {
            bundle = new Bundle();
            bundle.putInt(f4863c, this.f4887D);
            openNavi(bundle);
        }
    }

    /* renamed from: a */
    private void m5830a(double longitude, double latitude) {
        if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
            NavRouteGuideController.getInstance().setNewGuideIsThirdServer(true);
        } else {
            NavRouteGuideController.getInstance().setNewGuideIsThirdServer(false);
        }
        NavRouteGuideController.getInstance().setBNavigatorListener(new C15978(this));
        LogUtil.d("Framework", "handleJsNavi navi longitude=" + longitude + ", latitude=" + latitude);
        startCalcRoute(new CarLifeSearchPoi(longitude, latitude));
        if (this.f4887D == 1) {
            StatisticManager.onEvent(StatisticConstants.DISCOVER_ETCP_0004);
        }
    }

    public void driving() {
        LogUtil.d("yftech", "WebViewFragment driving");
        m5851f();
        if (this.f4887D == 1) {
            Bundle bundle = new Bundle();
            bundle.putInt(f4863c, this.f4887D);
            back(bundle);
        } else {
            back(null);
            if (C1343b.m4932a().m4935b()) {
                back(null);
            }
        }
        if (this.f4887D == 2) {
            bundle = new Bundle();
            bundle.putInt(f4863c, this.f4887D);
            openNavi(bundle);
        }
        C1342a.m4926a().m4931d();
    }

    public void stopDriving() {
        LogUtil.d("yftech", "WebViewFragment stopDriving");
    }
}
