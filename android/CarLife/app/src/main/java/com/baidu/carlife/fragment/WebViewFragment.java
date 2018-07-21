package com.baidu.carlife.fragment;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
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
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.presentation.a.e;
import com.baidu.carlife.core.screen.presentation.a.f;
import com.baidu.carlife.core.screen.presentation.a.g;
import com.baidu.carlife.logic.o;
import com.baidu.carlife.logic.q;
import com.baidu.carlife.util.d;
import com.baidu.carlife.util.m;
import com.baidu.carlife.util.m.a;
import com.baidu.carlife.view.CommonTipView;
import com.baidu.carlife.view.dialog.c;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.WebviewUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WebViewFragment
  extends ContentFragment
{
  private static final String A = "eventID";
  private static final String B = "label";
  private static List<String> C = new ArrayList();
  public static final String a = "bundle_title_key";
  public static final String b = "bundle_url_key";
  public static final String c = "bundle_type";
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 4;
  public static final String i = "https://jyb.jyblife.com/buy/clBuyPage";
  public static final String j = "http://carlife.etcp.cn/index/index";
  public static final String k = "http://carlife.baidu.com/carlife/act";
  public static final String l = "http://119.147.84.47:886/baidu/login.html";
  public static final String m = "http://carlife.baidu.com/static/carlifeweb/problems/android.html";
  public static final String n = "找不到网页|服务器内部错误";
  public static final String o = "scheme=alipays";
  public static final String p = "tel:";
  public static final String q = "intent://";
  public static final String r = "carlife://";
  private static final String s = "exit";
  private static final String t = "navi";
  private static final String u = "mtj";
  private static final String v = "registerJSFunction";
  private static final String w = "/getLocation";
  private static final String x = "product";
  private static final String y = "longitude";
  private static final String z = "latitude";
  private int D = 0;
  private String E;
  private WebView F;
  private boolean G = true;
  private boolean H = false;
  private String I;
  private CommonTipView J;
  private View K;
  private TextView L;
  
  static
  {
    C.add("http://carlife.etcp.cn/index/parkingFee");
  }
  
  private void a(double paramDouble1, double paramDouble2)
  {
    if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
      NavRouteGuideController.getInstance().setNewGuideIsThirdServer(true);
    }
    for (;;)
    {
      NavRouteGuideController.getInstance().setBNavigatorListener(new NavRouteGuideController.BNavigatorListener()
      {
        public void onPageJump(int paramAnonymousInt, Object paramAnonymousObject)
        {
          if (!NavRouteGuideController.getInstance().newGuideIsThirdServer())
          {
            g.a().b().performOpenHome();
            NavRouteGuideController.getInstance().setBNavigatorListener(null);
          }
          NavRouteGuideController.getInstance().setNewGuideIsThirdServer(false);
        }
      });
      i.b("Framework", "handleJsNavi navi longitude=" + paramDouble1 + ", latitude=" + paramDouble2);
      startCalcRoute(new com.baidu.carlife.core.screen.a(paramDouble1, paramDouble2));
      if (this.D == 1) {
        StatisticManager.onEvent("DISCOVER_ETCP_0004");
      }
      return;
      NavRouteGuideController.getInstance().setNewGuideIsThirdServer(false);
    }
  }
  
  private void a(WebView paramWebView, final SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    i.e("Framework", "onReceivedSslError：error" + paramSslError);
    paramWebView = new AlertDialog.Builder(getContext());
    paramSslError.getPrimaryError();
    paramWebView.setMessage(2131297230);
    paramWebView.setPositiveButton("continue", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramSslErrorHandler.proceed();
      }
    });
    paramWebView.setNegativeButton("cancel", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramSslErrorHandler.cancel();
      }
    });
    paramWebView.create().show();
  }
  
  private void a(String paramString)
  {
    if ((this.L != null) && (!TextUtils.isEmpty(paramString))) {
      this.L.setText(paramString);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    StatisticManager.onEvent(paramString1, paramString2);
  }
  
  private void b()
  {
    this.K = this.mContentView.findViewById(2131624260);
    this.K.setVisibility(8);
    Object localObject = (ImageButton)this.mContentView.findViewById(2131624258);
    if (localObject != null) {
      ((ImageButton)localObject).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if ((WebViewFragment.a(WebViewFragment.this).canGoBack()) && (!WebViewFragment.b(WebViewFragment.this))) {
            WebViewFragment.a(WebViewFragment.this).goBack();
          }
          for (;;)
          {
            return;
            if (WebViewFragment.c(WebViewFragment.this) == 1)
            {
              paramAnonymousView = new Bundle();
              paramAnonymousView.putInt("bundle_type", WebViewFragment.c(WebViewFragment.this));
              WebViewFragment.this.back(paramAnonymousView);
            }
            while (WebViewFragment.c(WebViewFragment.this) == 2)
            {
              paramAnonymousView = new Bundle();
              paramAnonymousView.putInt("bundle_type", WebViewFragment.c(WebViewFragment.this));
              WebViewFragment.this.openNavi(paramAnonymousView);
              return;
              WebViewFragment.this.back(null);
            }
          }
        }
      });
    }
    localObject = this.mContentView.findViewById(2131624261);
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if ((WebViewFragment.a(WebViewFragment.this).canGoBack()) && (!WebViewFragment.b(WebViewFragment.this))) {
            WebViewFragment.a(WebViewFragment.this).goBack();
          }
          for (;;)
          {
            return;
            if (WebViewFragment.c(WebViewFragment.this) == 1)
            {
              paramAnonymousView = new Bundle();
              paramAnonymousView.putInt("bundle_type", WebViewFragment.c(WebViewFragment.this));
              WebViewFragment.this.back(paramAnonymousView);
            }
            while (WebViewFragment.c(WebViewFragment.this) == 2)
            {
              paramAnonymousView = new Bundle();
              paramAnonymousView.putInt("bundle_type", WebViewFragment.c(WebViewFragment.this));
              WebViewFragment.this.openNavi(paramAnonymousView);
              return;
              WebViewFragment.this.back(null);
            }
          }
        }
      });
    }
    this.L = ((TextView)this.mContentView.findViewById(2131624059));
    a(this.E);
  }
  
  private boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ("找不到网页|服务器内部错误".contains(paramString));
  }
  
  private void c()
  {
    if (!TextUtils.isEmpty(this.I))
    {
      i.b("Framework", "loadUrl mUrl=" + this.I);
      if ((this.G) || (this.H)) {
        if (this.K != null)
        {
          if ((this.D != 1) && (this.D != 2) && (this.D != 3) && (this.D != 4)) {
            break label129;
          }
          this.K.setVisibility(0);
          this.F.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      a();
      this.F.loadUrl(this.I);
      this.G = false;
      return;
      label129:
      this.K.setVisibility(8);
    }
  }
  
  private void c(final String paramString)
  {
    showDialog(new c(getContext()).b(paramString).d(2131296259).q().a(new com.baidu.carlife.core.screen.b()
    {
      public void onClick()
      {
        q.f().a(WebViewFragment.this.getContext(), paramString);
      }
    }));
  }
  
  private boolean d()
  {
    String str = this.F.getUrl();
    WebBackForwardList localWebBackForwardList = this.F.copyBackForwardList();
    return (!TextUtils.isEmpty(str)) && (C.contains(str)) && (localWebBackForwardList.getSize() > 1);
  }
  
  private boolean d(String paramString)
  {
    paramString = Uri.parse(paramString);
    String str1 = paramString.getAuthority();
    i.e("Framework", "dispatchJsMethod: authority=" + str1);
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = paramString.getQueryParameter("product");
      i.e("Framework", "dispatchJsMethod: product=" + str2);
      if (TextUtils.isEmpty(str2)) {
        break label413;
      }
      if (!"exit".equalsIgnoreCase(str1)) {
        break label104;
      }
      i.e("Framework", "Js method: exit");
      g();
    }
    for (;;)
    {
      return true;
      label104:
      if ("navi".equalsIgnoreCase(str1))
      {
        i.e("Framework", "Js method: navi");
        str1 = paramString.getQueryParameter("longitude");
        paramString = paramString.getQueryParameter("latitude");
        i.b("Framework", "navi longitude=" + str1 + ", latitude=" + paramString);
        a(Double.valueOf(str1).doubleValue(), Double.valueOf(paramString).doubleValue());
      }
      else if ("registerJSFunction".equalsIgnoreCase(str1))
      {
        i.e("Framework", "Js method: registerJSFunction");
        paramString = paramString.getPath();
        i.b("Framework", "path=" + paramString);
        if ("/getLocation".equalsIgnoreCase(paramString))
        {
          paramString = m.a().b();
          if (paramString == null) {
            return true;
          }
          paramString = "javascript:getLocation('{\"longitude\":" + paramString.a() + ",\"latitude\":" + paramString.b() + "}')";
          i.b("Framework", "jsFun=" + paramString);
          this.F.loadUrl(paramString);
        }
      }
      else if ("mtj".equalsIgnoreCase(str1))
      {
        i.e("Framework", "Js method: mtj");
        str1 = paramString.getQueryParameter("eventID");
        paramString = paramString.getQueryParameter("label");
        i.b("Framework", "mtj eventID=" + str1 + " label=" + paramString);
        a(str1, paramString);
        continue;
        label413:
        i.e("Framework", "Js invoke parameter product should not be empty.");
      }
    }
  }
  
  private void e()
  {
    this.H = true;
    this.J.a(1);
    this.J.setVisibility(0);
    this.F.setVisibility(8);
    this.K.setVisibility(0);
  }
  
  private void f()
  {
    mActivity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        e.a().c();
      }
    });
  }
  
  private void g()
  {
    mActivity.m();
    Bundle localBundle;
    if (this.D == 1)
    {
      localBundle = new Bundle();
      localBundle.putInt("bundle_type", this.D);
      back(localBundle);
    }
    for (;;)
    {
      if (this.D == 2)
      {
        localBundle = new Bundle();
        localBundle.putInt("bundle_type", this.D);
        openNavi(localBundle);
      }
      return;
      back(null);
    }
  }
  
  public void a()
  {
    mActivity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        e.a().b(StyleManager.getString(2131296850));
      }
    });
  }
  
  public void a(WebView paramWebView)
  {
    WebSettings localWebSettings = paramWebView.getSettings();
    localWebSettings.setCacheMode(-1);
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    localWebSettings.setLoadsImagesAutomatically(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setSupportZoom(false);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setBlockNetworkImage(false);
    String str = d.a().b().getPath();
    localWebSettings.setSupportMultipleWindows(true);
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setDatabasePath(str);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setGeolocationEnabled(true);
    localWebSettings.setGeolocationDatabasePath(str);
    localWebSettings.setAppCacheEnabled(true);
    localWebSettings.setAppCachePath(d.a().c().getPath());
    localWebSettings.setAppCacheMaxSize(8388608L);
    localWebSettings.setAllowFileAccess(true);
    str = localWebSettings.getUserAgentString();
    localWebSettings.setUserAgentString(str + " baiduNavi_ANDR(" + PackageUtil.getVersionName() + ")");
    if (Build.VERSION.SDK_INT >= 11) {
      localWebSettings.setAllowContentAccess(true);
    }
    paramWebView.setScrollBarStyle(0);
    paramWebView.setVerticalFadingEdgeEnabled(false);
    paramWebView.setFadingEdgeLength(0);
    paramWebView.setLayerType(1, null);
    paramWebView.setWebChromeClient(new a());
    paramWebView.setWebViewClient(new b());
  }
  
  public void back()
  {
    if (this.D == 2)
    {
      super.back();
      showLatestNaviFragment();
      return;
    }
    super.back();
  }
  
  public void driving()
  {
    i.b("yftech", "WebViewFragment driving");
    f();
    Bundle localBundle;
    if (this.D == 1)
    {
      localBundle = new Bundle();
      localBundle.putInt("bundle_type", this.D);
      back(localBundle);
    }
    for (;;)
    {
      if (this.D == 2)
      {
        localBundle = new Bundle();
        localBundle.putInt("bundle_type", this.D);
        openNavi(localBundle);
      }
      com.baidu.carlife.custom.a.a().d();
      return;
      back(null);
      if (com.baidu.carlife.custom.b.a().b()) {
        back(null);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2) {
      this.F.loadUrl(this.I);
    }
  }
  
  public boolean onBackPressed()
  {
    if ((this.F.canGoBack()) && (!d()))
    {
      this.F.goBack();
      return true;
    }
    Bundle localBundle;
    if (this.D == 1)
    {
      localBundle = new Bundle();
      localBundle.putInt("bundle_type", this.D);
      back(localBundle);
      return true;
    }
    if (this.D == 2)
    {
      back();
      localBundle = new Bundle();
      localBundle.putInt("bundle_type", this.D);
      openNavi(localBundle);
      return true;
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mContentView = paramLayoutInflater.inflate(2130968576, null);
    if (this.mShowBundle != null)
    {
      this.E = this.mShowBundle.getString("bundle_title_key");
      this.D = this.mShowBundle.getInt("bundle_type", 0);
      this.I = this.mShowBundle.getString("bundle_url_key");
    }
    this.J = ((CommonTipView)this.mContentView.findViewById(2131623981));
    this.J.setVisibility(8);
    this.F = ((WebView)this.mContentView.findViewById(2131623982));
    this.F.removeJavascriptInterface("searchBoxJavaBridge_");
    this.F.removeJavascriptInterface("accessibility");
    this.F.removeJavascriptInterface("accessibilityTraversal");
    b();
    a(this.F);
    onUpdateStyle(true);
    return this.mContentView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    NavRouteGuideController.getInstance().setBNavigatorListener(null);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    if (!paramBoolean) {
      setBottomBarStatus(false);
    }
    super.onHiddenChanged(paramBoolean);
    if ((!paramBoolean) && (com.baidu.carlife.l.a.a().N())) {
      g();
    }
  }
  
  protected void onInitView()
  {
    c();
  }
  
  public void onPause()
  {
    super.onPause();
    WebviewUtils.pauseWebview(this.F);
  }
  
  public void onResume()
  {
    super.onResume();
    WebviewUtils.resumeWebview(this.F);
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean)
  {
    updateCommonSkin();
    this.F.setBackgroundColor(getResources().getColor(2131558598));
  }
  
  public void stopDriving()
  {
    i.b("yftech", "WebViewFragment stopDriving");
  }
  
  public class a
    extends WebChromeClient
  {
    public a() {}
    
    public void onGeolocationPermissionsHidePrompt()
    {
      super.onGeolocationPermissionsHidePrompt();
    }
    
    public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
    {
      super.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
      paramCallback.invoke(paramString, true, false);
    }
    
    public void onReceivedTitle(WebView paramWebView, String paramString)
    {
      super.onReceivedTitle(paramWebView, paramString);
      i.b("Framework", "onReceivedTitle title=" + paramString);
      if ((WebViewFragment.c(WebViewFragment.this, paramString)) || (WebViewFragment.c(WebViewFragment.this) != 3)) {
        WebViewFragment.d(WebViewFragment.this, paramString);
      }
      paramWebView = paramWebView.getUrl();
      if (((!TextUtils.isEmpty(paramWebView)) && (!paramWebView.startsWith("carlife://")) && (WebViewFragment.c(WebViewFragment.this, paramString))) || (WebViewFragment.e(WebViewFragment.this)))
      {
        WebViewFragment.g(WebViewFragment.this);
        return;
      }
      if (WebViewFragment.c(WebViewFragment.this) != 3) {
        WebViewFragment.f(WebViewFragment.this).setVisibility(8);
      }
      WebViewFragment.a(WebViewFragment.this).setVisibility(0);
    }
  }
  
  public class b
    extends WebViewClient
  {
    public b() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      i.b("Framework", "onPageFinished url=" + paramString);
      WebViewFragment.d(WebViewFragment.this);
      if (((WebViewFragment.c(WebViewFragment.this) == 1) || (WebViewFragment.c(WebViewFragment.this) == 4) || (WebViewFragment.c(WebViewFragment.this) == 2) || (WebViewFragment.c(WebViewFragment.this) == 3)) && (!WebViewFragment.e(WebViewFragment.this)) && (WebViewFragment.f(WebViewFragment.this) != null))
      {
        if (WebViewFragment.c(WebViewFragment.this) != 3) {
          WebViewFragment.f(WebViewFragment.this).setVisibility(8);
        }
        WebViewFragment.a(WebViewFragment.this).setVisibility(0);
      }
      if ((WebViewFragment.c(WebViewFragment.this) == 3) && (o.a().b())) {
        o.a().d();
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      i.b("Framework", "onPageStarted url=" + paramString);
      WebViewFragment.a(WebViewFragment.this, false);
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      i.b("Framework", "onReceivedError errorCode=" + paramInt + ", description=" + paramString1);
      paramWebView.stopLoading();
      WebViewFragment.d(WebViewFragment.this);
      WebViewFragment.g(WebViewFragment.this);
    }
    
    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      paramSslErrorHandler.cancel();
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      i.b("Framework", "shouldOverrideUrlLoading：" + paramString);
      if (!TextUtils.isEmpty(paramString))
      {
        if ((paramString.startsWith("intent://")) || ((WebViewFragment.c(WebViewFragment.this) == 1) && (paramString.contains("scheme=alipays")))) {}
        do
        {
          try
          {
            Intent localIntent = Intent.parseUri(paramString, 1);
            localIntent.addCategory("android.intent.category.BROWSABLE");
            localIntent.setComponent(null);
            WebViewFragment.this.startActivityForResult(localIntent, 2);
            return true;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          if ((paramString.startsWith("carlife://")) && (WebViewFragment.a(WebViewFragment.this, paramString)))
          {
            paramWebView.stopLoading();
            return true;
          }
          if (!paramString.startsWith("tel:")) {
            break;
          }
          paramWebView = paramString.replace("tel:", "");
        } while (TextUtils.isEmpty(paramWebView));
        WebViewFragment.b(WebViewFragment.this, paramWebView);
        return true;
      }
      paramWebView.loadUrl(paramString);
      return true;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/WebViewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */