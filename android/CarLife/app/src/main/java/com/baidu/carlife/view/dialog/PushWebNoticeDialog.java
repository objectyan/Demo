package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.content.res.Resources;
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
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.presentation.a.e;
import com.baidu.carlife.f.g;
import com.baidu.carlife.push.a;
import com.baidu.carlife.util.d;
import com.baidu.carlife.util.r;
import com.baidu.carlife.view.CommonTipView;
import com.baidu.carlife.view.a.b;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.util.common.PackageUtil;
import java.io.File;

public class PushWebNoticeDialog
  extends BaseDialog
{
  private static final String A = "/getLocation";
  private static final String B = "product";
  private static final String C = "longitude";
  private static final String D = "latitude";
  private static final String E = "eventID";
  private static final String F = "label";
  public static final String e = "PushWebNoticeDialog";
  public static CarlifeActivity f;
  public static final String g = "carlife://";
  public static final String h = "找不到网页|服务器内部错误";
  public static final String i = "scheme=alipays";
  public static final String j = "tel:";
  public static final String k = "intent://";
  public static final String l = "http://carlife.baidu.com/static/carlifeweb/problems/android.html";
  private static final String w = "exit";
  private static final String x = "navi";
  private static final String y = "mtj";
  private static final String z = "registerJSFunction";
  private String G = "http://carlife.baidu.com/static/carlifeweb/problems/android.html";
  private String m;
  private WebView n;
  private boolean o = true;
  private boolean p = false;
  private CommonTipView q;
  private View r;
  private TextView s;
  private View t;
  private g u;
  private TextView v;
  
  public PushWebNoticeDialog(Context paramContext)
  {
    super(paramContext, null, 0);
    this.c = paramContext;
  }
  
  public PushWebNoticeDialog(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PushWebNoticeDialog(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
  }
  
  private void b(String paramString)
  {
    if ((this.v != null) && (!TextUtils.isEmpty(paramString))) {
      this.v.setText(paramString);
    }
  }
  
  private boolean c(String paramString)
  {
    paramString = Uri.parse(paramString);
    String str1 = paramString.getAuthority();
    i.e("PushWebNoticeDialog", "dispatchJsMethod: authority=" + str1);
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = paramString.getQueryParameter("product");
      i.e("PushWebNoticeDialog", "dispatchJsMethod: product=" + str2);
      if (TextUtils.isEmpty(str2)) {
        break label167;
      }
      if (!"exit".equalsIgnoreCase(str1)) {
        break label101;
      }
      i.e("PushWebNoticeDialog", "Js method: exit");
      m();
    }
    for (;;)
    {
      return true;
      label101:
      if ("mtj".equalsIgnoreCase(str1))
      {
        i.e("PushWebNoticeDialog", "Js method: mtj");
        str1 = paramString.getQueryParameter("eventID");
        paramString = paramString.getQueryParameter("label");
        i.b("PushWebNoticeDialog", "mtj eventID=" + str1 + " label=" + paramString);
        continue;
        label167:
        i.e("PushWebNoticeDialog", "Js invoke parameter product should not be empty.");
      }
    }
  }
  
  private void k()
  {
    this.r = findViewById(2131624260);
    this.r.setVisibility(8);
    Object localObject = (ImageButton)findViewById(2131624258);
    if (localObject != null) {
      ((ImageButton)localObject).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (PushWebNoticeDialog.a(PushWebNoticeDialog.this).canGoBack())
          {
            PushWebNoticeDialog.a(PushWebNoticeDialog.this).goBack();
            return;
          }
          PushWebNoticeDialog.this.d();
          i.b("PushWebNoticeDialog", "####### btn back dismiss");
        }
      });
    }
    localObject = findViewById(2131624261);
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (PushWebNoticeDialog.a(PushWebNoticeDialog.this).canGoBack())
          {
            PushWebNoticeDialog.a(PushWebNoticeDialog.this).goBack();
            return;
          }
          PushWebNoticeDialog.this.d();
          i.b("PushWebNoticeDialog", "####### hide back dismiss");
        }
      });
    }
    this.v = ((TextView)findViewById(2131624059));
    b(this.m);
  }
  
  private void l()
  {
    if (f == null) {
      return;
    }
    f.runOnUiThread(new Runnable()
    {
      public void run()
      {
        e.a().c();
      }
    });
  }
  
  private void m()
  {
    d();
  }
  
  private void n()
  {
    i.b("PushWebNoticeDialog", "showErrorPage !!!");
    this.p = true;
    if (this.q != null)
    {
      this.q.a(1);
      this.q.setVisibility(0);
    }
    this.n.setVisibility(8);
    if (this.r != null) {
      this.r.setVisibility(0);
    }
  }
  
  protected View a()
  {
    return LayoutInflater.from(this.c).inflate(2130968727, null);
  }
  
  protected void b()
  {
    this.q = ((CommonTipView)findViewById(2131623981));
    this.q.setVisibility(8);
    this.m = getResources().getString(2131297144);
    this.n = ((WebView)findViewById(2131623982));
    this.n.removeJavascriptInterface("searchBoxJavaBridge_");
    this.n.removeJavascriptInterface("accessibility");
    this.n.removeJavascriptInterface("accessibilityTraversal");
    this.n.setBackgroundColor(getResources().getColor(2131558598));
    i.b("PushWebNoticeDialog", "Web dialog: " + this.G);
    i();
    k();
    setWebviewSettings(this.n);
    j();
    this.G = a.b();
    if ((this.G == null) || (this.G.isEmpty()))
    {
      i.b("PushWebNoticeDialog", "Web dialog: " + this.G);
      n();
    }
    this.n.loadUrl(this.G);
  }
  
  public void f() {}
  
  protected void i()
  {
    Object localObject = (ImageButton)findViewById(2131624258);
    if (localObject != null)
    {
      ((ImageButton)localObject).setImageDrawable(r.b(2130838256));
      ((ImageButton)localObject).setBackground(b.a(this.c));
    }
    localObject = (TextView)findViewById(2131624059);
    if (localObject != null) {
      ((TextView)localObject).setTextColor(r.a(2131558699));
    }
  }
  
  public void j()
  {
    if (f == null) {
      return;
    }
    f.runOnUiThread(new Runnable()
    {
      public void run()
      {
        e.a().b(StyleManager.getString(2131296850));
      }
    });
  }
  
  public void setWebviewSettings(WebView paramWebView)
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
      if (!TextUtils.isEmpty(paramString)) {
        PushWebNoticeDialog.a(PushWebNoticeDialog.this, paramString);
      }
      i.b("PushWebNoticeDialog", "onReceivedTitle title=" + paramString);
      if ((TextUtils.isEmpty(paramWebView.getUrl())) || (PushWebNoticeDialog.b(PushWebNoticeDialog.this)))
      {
        PushWebNoticeDialog.c(PushWebNoticeDialog.this);
        return;
      }
      PushWebNoticeDialog.d(PushWebNoticeDialog.this).setVisibility(8);
      PushWebNoticeDialog.a(PushWebNoticeDialog.this).setVisibility(0);
    }
  }
  
  public class b
    extends WebViewClient
  {
    public b() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      i.b("PushWebNoticeDialog", "onPageFinished url=" + paramString);
      PushWebNoticeDialog.e(PushWebNoticeDialog.this);
      if ((!PushWebNoticeDialog.b(PushWebNoticeDialog.this)) && (PushWebNoticeDialog.d(PushWebNoticeDialog.this) != null))
      {
        PushWebNoticeDialog.d(PushWebNoticeDialog.this).setVisibility(8);
        PushWebNoticeDialog.a(PushWebNoticeDialog.this).setVisibility(0);
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      i.b("PushWebNoticeDialog", "onPageStarted url=" + paramString);
      PushWebNoticeDialog.a(PushWebNoticeDialog.this, false);
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      i.b("PushWebNoticeDialog", "onReceivedError errorCode=" + paramInt + ", description=" + paramString1);
      paramWebView.stopLoading();
      PushWebNoticeDialog.e(PushWebNoticeDialog.this);
      PushWebNoticeDialog.c(PushWebNoticeDialog.this);
    }
    
    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      paramSslErrorHandler.cancel();
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if ((paramString.startsWith("carlife://")) && (PushWebNoticeDialog.b(PushWebNoticeDialog.this, paramString))) {
        paramWebView.stopLoading();
      }
      do
      {
        return true;
        i.b("PushWebNoticeDialog", "shouldOverrideUrlLoading：" + paramString);
      } while (!TextUtils.isEmpty(paramString));
      paramWebView.loadUrl(paramString);
      return true;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/dialog/PushWebNoticeDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */