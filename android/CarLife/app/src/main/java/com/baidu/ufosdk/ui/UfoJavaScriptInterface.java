package com.baidu.ufosdk.ui;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import com.baidu.ufosdk.util.c;

public class UfoJavaScriptInterface
{
  public static void clickOnAndroid(WebView paramWebView, String paramString)
  {
    paramWebView = paramWebView.getContext();
    Intent localIntent = new Intent();
    localIntent.setClass(paramWebView, FeedbackHotActivity.class);
    localIntent.putExtra("hoturl", paramString);
    c.b("hoturl---->" + paramString);
    paramWebView.startActivity(localIntent);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/UfoJavaScriptInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */