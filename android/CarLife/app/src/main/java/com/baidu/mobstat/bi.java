package com.baidu.mobstat;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

class bi
  extends WebViewClient
{
  private WeakReference<Context> a;
  private WebViewClient b;
  
  public bi(Context paramContext, WebViewClient paramWebViewClient)
  {
    this.a = new WeakReference(paramContext);
    this.b = paramWebViewClient;
  }
  
  private HashMap<String, String> a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    if (paramJSONObject.length() != 0) {}
    for (HashMap localHashMap = new HashMap();; localHashMap = null)
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext()) {
        try
        {
          String str = (String)localIterator.next();
          localHashMap.put(str, paramJSONObject.getString(str));
        }
        catch (Exception localException) {}
      }
      return localHashMap;
    }
  }
  
  private void a(String paramString)
  {
    paramString = new JSONObject(paramString);
    String str1 = paramString.getString("action");
    paramString = paramString.getJSONObject("obj");
    Context localContext = (Context)this.a.get();
    if (localContext == null) {}
    do
    {
      return;
      if ("onPageStart".equals(str1))
      {
        StatService.onPageStart(localContext, paramString.getString("page"));
        return;
      }
      if ("onPageEnd".equals(str1))
      {
        StatService.onPageEnd(localContext, paramString.getString("page"));
        return;
      }
      if ("onEvent".equals(str1))
      {
        str1 = paramString.getString("event_id");
        str2 = paramString.getString("label");
        int i = paramString.getInt("acc");
        try
        {
          paramString = (JSONObject)paramString.get("attributes");
          StatService.onEvent(localContext, str1, str2, i, a(paramString));
          return;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            paramString = null;
          }
        }
      }
      if ("onEventStart".equals(str1))
      {
        StatService.onEventStart(localContext, paramString.getString("event_id"), paramString.getString("label"));
        return;
      }
      if ("onEventEnd".equals(str1))
      {
        str1 = paramString.getString("event_id");
        str2 = paramString.getString("label");
        try
        {
          paramString = (JSONObject)paramString.get("attributes");
          StatService.onEventEnd(localContext, str1, str2, a(paramString));
          return;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            paramString = null;
          }
        }
      }
    } while (!"onEventDuration".equals(str1));
    str1 = paramString.getString("event_id");
    String str2 = paramString.getString("label");
    long l = paramString.getLong("duration");
    try
    {
      paramString = (JSONObject)paramString.get("attributes");
      StatService.onEventDuration(localContext, str1, str2, l, a(paramString));
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
  }
  
  public void doUpdateVisitedHistory(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.doUpdateVisitedHistory(paramWebView, paramString, paramBoolean);
    }
  }
  
  public void onFormResubmission(WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    if (this.b != null) {
      this.b.onFormResubmission(paramWebView, paramMessage1, paramMessage2);
    }
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    if (this.b != null) {
      this.b.onLoadResource(paramWebView, paramString);
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (this.b != null) {
      this.b.onPageFinished(paramWebView, paramString);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if (this.b != null) {
      this.b.onPageStarted(paramWebView, paramString, paramBitmap);
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (this.b != null) {
      this.b.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
  }
  
  public void onReceivedHttpAuthRequest(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    if (this.b != null) {
      this.b.onReceivedHttpAuthRequest(paramWebView, paramHttpAuthHandler, paramString1, paramString2);
    }
  }
  
  public void onReceivedLoginRequest(WebView paramWebView, String paramString1, String paramString2, String paramString3)
  {
    if (this.b != null) {
      this.b.onReceivedLoginRequest(paramWebView, paramString1, paramString2, paramString3);
    }
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if (this.b != null) {
      this.b.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
    }
  }
  
  public void onScaleChanged(WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    if (this.b != null) {
      this.b.onScaleChanged(paramWebView, paramFloat1, paramFloat2);
    }
  }
  
  @Deprecated
  public void onTooManyRedirects(WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    if (this.b != null) {
      this.b.onTooManyRedirects(paramWebView, paramMessage1, paramMessage2);
    }
  }
  
  public void onUnhandledKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    if (this.b != null) {
      this.b.onUnhandledKeyEvent(paramWebView, paramKeyEvent);
    }
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    if (this.b != null) {
      return this.b.shouldInterceptRequest(paramWebView, paramString);
    }
    return null;
  }
  
  public boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    if (this.b != null) {
      return this.b.shouldOverrideKeyEvent(paramWebView, paramKeyEvent);
    }
    return false;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    try
    {
      String str1 = URLDecoder.decode(paramString, "UTF-8");
      paramString = str1;
      str1 = paramString;
      String str2;
      label47:
      String str3;
      return false;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          break label47;
        }
        str1 = paramString;
        if (!paramString.startsWith("bmtj:")) {
          break label47;
        }
        a(paramString.substring(5));
        return true;
      }
      catch (JSONException localJSONException2)
      {
        for (;;) {}
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        for (;;) {}
      }
      localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
      db.b(localUnsupportedEncodingException1);
      str2 = paramString;
      if (this.b != null) {
        return this.b.shouldOverrideUrlLoading(paramWebView, str2);
      }
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        db.b(localJSONException1);
        str3 = paramString;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/mobstat/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */