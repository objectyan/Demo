package com.baidu.navisdk.ui.cruise.view;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.navisdk.util.common.WebviewUtils;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class CruiseQADialog
  extends Dialog
{
  private static final String URL = HttpURLManager.getInstance().getScheme() + "appnavi.baidu.com/distance/electroneyes?mid=2&os=android&mobile=i9300&cuid=niubi&channel=baidu&appvercode=4.0";
  private Activity mActivity;
  private WebView mDetailWebView = null;
  private View mQAView;
  
  public CruiseQADialog(Activity paramActivity, int paramInt)
  {
    super(paramActivity, paramInt);
    this.mActivity = paramActivity;
    initView();
  }
  
  private void initWebView()
  {
    this.mDetailWebView = ((WebView)this.mQAView.findViewById(1711865994));
    this.mDetailWebView.setWebViewClient(new MyWebViewClient(null));
    WebSettings localWebSettings = this.mDetailWebView.getSettings();
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setSupportZoom(false);
    localWebSettings.setUseWideViewPort(true);
    this.mDetailWebView.loadUrl(URL);
  }
  
  public void initView()
  {
    this.mQAView = JarUtils.inflate(this.mActivity, 1711472665, null);
    if (this.mQAView == null) {
      return;
    }
    this.mQAView.findViewById(1711865993).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CruiseQADialog.this.dismiss();
        WebviewUtils.pauseWebview(CruiseQADialog.this.mDetailWebView);
      }
    });
    initWebView();
    setContentView(this.mQAView);
  }
  
  private class MyWebViewClient
    extends WebViewClient
  {
    private MyWebViewClient() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      paramWebView.loadUrl(paramString);
      return true;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/cruise/view/CruiseQADialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */