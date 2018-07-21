package com.baidu.ufosdk.d;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.ufosdk.util.c;

public final class a
  extends WebChromeClient
{
  private b a;
  private boolean b;
  
  public a(String paramString, Class paramClass)
  {
    this.a = new b(paramString, paramClass);
  }
  
  public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    paramJsResult.confirm();
    return true;
  }
  
  public final boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    paramJsPromptResult.confirm(this.a.a(paramWebView, paramString2));
    return true;
  }
  
  public final void onProgressChanged(WebView paramWebView, int paramInt)
  {
    if (paramInt <= 25) {
      this.b = false;
    }
    for (;;)
    {
      super.onProgressChanged(paramWebView, paramInt);
      return;
      if (!this.b)
      {
        paramWebView.loadUrl(this.a.a());
        this.b = true;
        c.a(" inject js interface completely on progress " + paramInt);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */