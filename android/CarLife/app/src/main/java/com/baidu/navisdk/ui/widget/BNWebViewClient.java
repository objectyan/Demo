package com.baidu.navisdk.ui.widget;

import android.graphics.Bitmap;
import android.os.Message;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.navisdk.util.common.LogUtil;

public abstract class BNWebViewClient
  extends WebViewClient
{
  public static final int MSG_BN_CLOSE = 0;
  public static final int MSG_ON_OVERRIDE_URL_LOADING = 1;
  public static final int MSG_ON_PAGE_FINISHED = 3;
  public static final int MSG_ON_PAGE_STARTED = 2;
  public static final int MSG_ON_RECEIVED_ERROR = 4;
  public static final String URL_BN_CLOSE = "bdnavi://close";
  public static final String URL_BN_PREFIX = "bdnavi://";
  public static final String URL_HTTPS_PREFIX = "https://";
  public static final String URL_HTTP_PREFIX = "http://";
  
  private void handleBNUrlProtocol(WebView paramWebView, String paramString)
  {
    if (paramString.startsWith("bdnavi://close")) {
      onEventBNavi(0, paramWebView, paramString, null);
    }
  }
  
  public abstract boolean onEventAndroid(int paramInt, WebView paramWebView, String paramString, Message paramMessage);
  
  public abstract boolean onEventBNavi(int paramInt, WebView paramWebView, String paramString, Message paramMessage);
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    super.onLoadResource(paramWebView, paramString);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    onEventAndroid(3, paramWebView, paramString, null);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    onEventAndroid(2, paramWebView, paramString, null);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    LogUtil.e("BNWebViewClient", "onReceivedError:" + paramString2);
    onEventAndroid(4, paramWebView, paramString2, null);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    LogUtil.e("BNWebViewClient", "OverrideUrlLoading:" + paramString);
    if ((paramWebView == null) || (paramString == null)) {}
    do
    {
      return true;
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        paramWebView.loadUrl(paramString);
        onEventAndroid(1, paramWebView, paramString, null);
        return true;
      }
    } while (!paramString.startsWith("bdnavi://"));
    handleBNUrlProtocol(paramWebView, paramString);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */