package com.baidu.ufosdk.ui;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.baidu.ufosdk.util.c;
import com.baidu.ufosdk.util.i;
import java.util.Timer;

final class z
  extends WebViewClient
{
  private z(FeedbackFacePageActivity paramFeedbackFacePageActivity) {}
  
  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    c.b("UfoWebViewClient-->onLoadResource");
    super.onLoadResource(paramWebView, paramString);
  }
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    FeedbackFacePageActivity.h(this.a).setVisibility(8);
    if (FeedbackFacePageActivity.p(this.a) != null)
    {
      FeedbackFacePageActivity.p(this.a).cancel();
      FeedbackFacePageActivity.p(this.a).purge();
    }
  }
  
  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    c.b("UfoWebViewClient-->onPageStarted");
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    FeedbackFacePageActivity.h(this.a).setVisibility(0);
    FeedbackFacePageActivity.a(this.a, new Timer());
    paramWebView = new aa(this);
    FeedbackFacePageActivity.p(this.a).schedule(paramWebView, 30000L);
  }
  
  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    c.d("onReceivedError-->errorCode:" + paramInt + ",description:" + paramString1 + ",failingUrl:" + paramString2);
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    i.a(this.a.getApplicationContext(), FeedbackFacePageActivity.i(this.a));
    FeedbackFacePageActivity.j(this.a).setVisibility(0);
    FeedbackFacePageActivity.e(this.a).setVisibility(8);
    FeedbackFacePageActivity.h(this.a).setVisibility(8);
  }
  
  public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    c.d("UfoWebViewClient-->onReceivedSslError");
    paramSslErrorHandler.proceed();
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    c.b("UfoWebViewClient-->shouldOverrideUrlLoading:" + paramString);
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */