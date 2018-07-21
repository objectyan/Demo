package com.baidu.ufosdk.ui;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.baidu.ufosdk.a;
import com.baidu.ufosdk.util.c;
import com.baidu.ufosdk.util.i;
import com.baidu.ufosdk.util.u;
import java.util.Timer;

final class ag
  extends WebViewClient
{
  private ag(FeedbackHotActivity paramFeedbackHotActivity) {}
  
  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    super.onLoadResource(paramWebView, paramString);
  }
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    FeedbackHotActivity.b(this.a).setVisibility(8);
    paramWebView.requestFocus();
    if (FeedbackHotActivity.g(this.a) != null)
    {
      FeedbackHotActivity.g(this.a).cancel();
      FeedbackHotActivity.g(this.a).purge();
    }
  }
  
  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    paramWebView.clearView();
    FeedbackHotActivity.b(this.a).setVisibility(0);
    FeedbackHotActivity.a(this.a, new Timer());
    paramWebView = new ai(this);
    FeedbackHotActivity.g(this.a).schedule(paramWebView, 30000L);
  }
  
  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    i.a(this.a.getApplicationContext(), FeedbackHotActivity.c(this.a));
    FeedbackHotActivity.d(this.a).setVisibility(0);
    FeedbackHotActivity.a(this.a).setVisibility(8);
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    c.b("UfoWebViewClient-->shouldOverrideUrlLoading:" + paramString);
    if (paramString.startsWith("feedback://")) {
      FeedbackHotActivity.e(this.a);
    }
    for (;;)
    {
      return true;
      if (paramString.startsWith("solve://"))
      {
        i.a(this.a, u.a("26"), a.q);
        new Handler().postDelayed(new ah(this), a.q);
      }
      else if (paramString.startsWith("backtoufo://"))
      {
        this.a.finish();
      }
      else
      {
        paramWebView.loadUrl(paramString);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */