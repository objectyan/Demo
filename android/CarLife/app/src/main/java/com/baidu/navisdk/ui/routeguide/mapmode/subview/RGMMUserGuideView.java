package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Message;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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

public class RGMMUserGuideView
  extends BNBaseView
{
  private static final String TAG = RGMMUserGuideView.class.getSimpleName();
  private static final String URL_USER_GUIDE = "http://webpage.navi.baidu.com/static/webpage/NoviceNavigation/";
  private ViewGroup mGuideViewContails = null;
  private WebView mWebView = null;
  
  public RGMMUserGuideView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    try
    {
      initViews();
      loadWebData();
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e(TAG, "init exception:" + paramContext.getMessage());
    }
  }
  
  private void initViews()
  {
    this.mWebView = new WebView(this.mContext);
    this.mWebView.setBackgroundColor(0);
    setWebViewSettings(this.mWebView);
    setWebViewClient(this.mWebView);
  }
  
  private void loadWebData()
  {
    this.mWebView.loadUrl("http://webpage.navi.baidu.com/static/webpage/NoviceNavigation/");
  }
  
  private void setWebViewClient(WebView paramWebView)
  {
    paramWebView.setWebViewClient(new BNWebViewClient()
    {
      public boolean onEventAndroid(int paramAnonymousInt, WebView paramAnonymousWebView, String paramAnonymousString, Message paramAnonymousMessage)
      {
        switch (paramAnonymousInt)
        {
        default: 
        case 2: 
        case 3: 
          do
          {
            do
            {
              return true;
            } while ((paramAnonymousString == null) || (!"http://webpage.navi.baidu.com/static/webpage/NoviceNavigation/".startsWith(paramAnonymousString)));
            RGUserGuideModel.getInstance().mReceivError = false;
            RGUserGuideModel.getInstance().mLoadStartTime = SystemClock.elapsedRealtime();
            return true;
          } while ((paramAnonymousString == null) || (!"http://webpage.navi.baidu.com/static/webpage/NoviceNavigation/".startsWith(paramAnonymousString)));
          RGUserGuideModel.getInstance().mLoadEndTime = SystemClock.elapsedRealtime();
          RGMMUserGuideView.this.show();
          return true;
        }
        RGUserGuideModel.getInstance().mReceivError = true;
        return true;
      }
      
      public boolean onEventBNavi(int paramAnonymousInt, WebView paramAnonymousWebView, String paramAnonymousString, Message paramAnonymousMessage)
      {
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          return true;
          RGMMUserGuideView.this.hide();
        }
      }
    });
  }
  
  private void setWebViewSettings(WebView paramWebView)
  {
    paramWebView = paramWebView.getSettings();
    paramWebView.setJavaScriptEnabled(true);
    paramWebView.setBuiltInZoomControls(true);
    paramWebView.setLoadWithOverviewMode(true);
    paramWebView.setCacheMode(-1);
    paramWebView.setJavaScriptCanOpenWindowsAutomatically(true);
    paramWebView.setLoadsImagesAutomatically(true);
    paramWebView.setUseWideViewPort(true);
    paramWebView.setSupportZoom(false);
    paramWebView.setUseWideViewPort(true);
    paramWebView.setSupportMultipleWindows(true);
  }
  
  public void dispose()
  {
    if (this.mWebView != null) {}
    try
    {
      ViewGroup localViewGroup = (ViewGroup)this.mWebView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this.mWebView);
      }
      if (Build.VERSION.SDK_INT >= 11) {
        this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
      }
      this.mWebView.removeAllViews();
      this.mWebView.destroy();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtil.e(TAG, "webview dispose exception");
      }
    }
    this.mWebView = null;
    this.mSubViewListener = null;
    this.mGuideViewContails = null;
    this.mContext = null;
  }
  
  public void hide()
  {
    super.hide();
    if (this.mGuideViewContails != null) {
      this.mGuideViewContails.setVisibility(8);
    }
    RGUserGuideModel.getInstance().isShowing = false;
    dispose();
  }
  
  public void show()
  {
    if (this.mWebView == null)
    {
      LogUtil.e(TAG, "webview is null");
      return;
    }
    if (!RGUserGuideModel.getInstance().satisfyCondition())
    {
      LogUtil.e(TAG, "not satisfyCondition");
      return;
    }
    this.mGuideViewContails = RGMapModeViewController.getInstance().getUserGuideViewContails();
    if (this.mGuideViewContails == null)
    {
      LogUtil.e(TAG, "viewContails is null");
      return;
    }
    super.show();
    Object localObject = (ViewGroup)this.mWebView.getParent();
    if (localObject != null) {
      ((ViewGroup)localObject).removeView(this.mWebView);
    }
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.mGuideViewContails.addView(this.mWebView, (ViewGroup.LayoutParams)localObject);
    this.mGuideViewContails.setVisibility(0);
    RGUserGuideModel.getInstance().isShowing = true;
    BNSettingManager.setHasShowUserGuide(true);
  }
  
  public void updateOrientation()
  {
    show();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMUserGuideView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */