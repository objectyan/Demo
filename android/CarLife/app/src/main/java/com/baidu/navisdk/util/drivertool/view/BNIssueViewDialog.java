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
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.WebviewUtils;
import com.baidu.navisdk.util.drivertool.BNDrivingToolManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNIssueViewDialog
  extends Dialog
{
  private static final String URL = "http://webpage.navi.baidu.com/static/webpage/shareFunction/issuesList.html";
  private boolean isInSharePage = false;
  private View mIssueView = null;
  private Button mShareBtn = null;
  private String mUrl = null;
  private WebView mWebView = null;
  
  public BNIssueViewDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    initView(paramContext);
  }
  
  private void addCookie()
  {
    CookieSyncManager.createInstance(BNaviModuleManager.getContext());
    CookieManager localCookieManager = CookieManager.getInstance();
    localCookieManager.setAcceptCookie(true);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("BDUSS=");
    ((StringBuffer)localObject).append(BNaviModuleManager.getBduss());
    ((StringBuffer)localObject).append(";domain=.baidu.com;path=/");
    localObject = ((StringBuffer)localObject).toString();
    LogUtil.e("drivingTool", "issue view addcookie " + (String)localObject);
    localCookieManager.setCookie(getLoadUrl(), (String)localObject);
    CookieSyncManager.getInstance().sync();
  }
  
  private String getLoadUrl()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("http://webpage.navi.baidu.com/static/webpage/shareFunction/issuesList.html");
    localStringBuffer.append("?taskid=");
    localStringBuffer.append(BNDrivingToolManager.getInstance().mTaskID);
    return localStringBuffer.toString();
  }
  
  private String getShareUrl()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.mUrl);
    localStringBuffer.append("&share=yes");
    return localStringBuffer.toString();
  }
  
  private void initView(Context paramContext)
  {
    this.mIssueView = JarUtils.inflate((Activity)paramContext, 1711472675, null);
    if (this.mIssueView == null) {
      return;
    }
    paramContext = (ImageView)this.mIssueView.findViewById(1711866115);
    if (paramContext != null) {
      paramContext.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if ((BNIssueViewDialog.this.mWebView != null) && (BNIssueViewDialog.this.mWebView.canGoBack()))
          {
            BNIssueViewDialog.this.mWebView.goBack();
            BNIssueViewDialog.access$102(BNIssueViewDialog.this, false);
            BNIssueViewDialog.this.setShareView(8);
            return;
          }
          BNIssueViewDialog.this.dismiss();
        }
      });
    }
    this.mShareBtn = ((Button)this.mIssueView.findViewById(1711866117));
    if (this.mShareBtn != null) {
      this.mShareBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (BNIssueViewDialog.this.isInSharePage) {
            BNaviModuleManager.shareDrivingToolUrl(BNIssueViewDialog.this.getShareUrl());
          }
        }
      });
    }
    setShareView(8);
    initWebView();
    setContentView(this.mIssueView);
  }
  
  private void initWebView()
  {
    this.mWebView = ((WebView)this.mIssueView.findViewById(1711866118));
    this.mWebView.setWebViewClient(new MyWebViewClient(null));
    WebSettings localWebSettings = this.mWebView.getSettings();
    localWebSettings.setSupportZoom(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setJavaScriptEnabled(true);
    WebviewUtils.disableJsInterface(this.mWebView);
    addCookie();
    CookieManager.getInstance().setAcceptCookie(true);
    this.mWebView.loadUrl(getLoadUrl());
  }
  
  private void setShareView(int paramInt)
  {
    if (this.mShareBtn != null)
    {
      this.mShareBtn.setVisibility(paramInt);
      if (BNaviModuleManager.isGooglePlayChannel()) {
        this.mShareBtn.setVisibility(8);
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.mWebView.canGoBack()))
    {
      this.mWebView.goBack();
      this.isInSharePage = false;
      setShareView(8);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void releaseResource()
  {
    if (this.mWebView != null)
    {
      this.mWebView.removeAllViews();
      this.mWebView.destroy();
      this.mWebView = null;
    }
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
      BNIssueViewDialog.access$102(BNIssueViewDialog.this, true);
      BNIssueViewDialog.access$502(BNIssueViewDialog.this, paramString);
      BNIssueViewDialog.this.setShareView(0);
      return true;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/drivertool/view/BNIssueViewDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */