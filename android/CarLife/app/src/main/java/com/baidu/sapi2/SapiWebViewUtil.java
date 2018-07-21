package com.baidu.sapi2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.ProgressBar;

public class SapiWebViewUtil
{
  public static void addCustomView(Context paramContext, SapiWebView paramSapiWebView)
  {
    setProgressBar(paramContext, paramSapiWebView);
    setNoNetworkView(paramContext, paramSapiWebView);
    setTimeoutView(paramContext, paramSapiWebView);
  }
  
  public static void setNoNetworkView(Context paramContext, SapiWebView paramSapiWebView)
  {
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130968883, null);
    paramContext = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent("android.settings.SETTINGS");
        paramAnonymousView.setFlags(270532608);
        this.val$context.startActivity(paramAnonymousView);
      }
    };
    localView.findViewById(2131625473).setOnClickListener(paramContext);
    paramSapiWebView.setNoNetworkView(localView);
  }
  
  public static void setProgressBar(Context paramContext, SapiWebView paramSapiWebView)
  {
    paramContext = new ProgressBar(paramContext, null, 16842872);
    paramContext.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, 4, 0, 0));
    paramSapiWebView.setProgressBar(paramContext);
  }
  
  public static void setTimeoutView(final Context paramContext, SapiWebView paramSapiWebView)
  {
    paramContext = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130968882, null);
    paramContext.findViewById(2131625472).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$sapiWebView.post(new Runnable()
        {
          public void run()
          {
            SapiWebViewUtil.2.this.val$timeoutView.setVisibility(4);
            SapiWebViewUtil.2.this.val$sapiWebView.loadUrl(SapiWebViewUtil.2.this.val$sapiWebView.getUrl());
          }
        });
      }
    });
    paramSapiWebView.setTimeoutView(paramContext);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/SapiWebViewUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */