package com.baidu.android.pushservice.richmedia;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;

public class MediaViewActivity
  extends Activity
{
  public WebView a;
  private RelativeLayout b;
  private WebChromeClient c = new WebChromeClient()
  {
    public void onHideCustomView() {}
    
    public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt) {}
    
    public void onShowCustomView(View paramAnonymousView, WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback) {}
  };
  private WebViewClient d = new WebViewClient()
  {
    public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
    }
    
    public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
    {
      super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
    }
    
    /* Error */
    public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      // Byte code:
      //   0: aload_2
      //   1: ldc 30
      //   3: invokevirtual 36	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   6: ifeq +70 -> 76
      //   9: new 38	android/content/Intent
      //   12: dup
      //   13: ldc 40
      //   15: invokespecial 43	android/content/Intent:<init>	(Ljava/lang/String;)V
      //   18: astore 4
      //   20: aload 4
      //   22: aload_2
      //   23: invokestatic 49	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   26: invokevirtual 53	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
      //   29: pop
      //   30: aload_0
      //   31: getfield 12	com/baidu/android/pushservice/richmedia/MediaViewActivity$2:a	Lcom/baidu/android/pushservice/richmedia/MediaViewActivity;
      //   34: aload 4
      //   36: invokevirtual 57	com/baidu/android/pushservice/richmedia/MediaViewActivity:startActivity	(Landroid/content/Intent;)V
      //   39: getstatic 63	android/os/Build$VERSION:SDK_INT	I
      //   42: bipush 17
      //   44: if_icmple +285 -> 329
      //   47: new 38	android/content/Intent
      //   50: dup
      //   51: ldc 65
      //   53: invokespecial 43	android/content/Intent:<init>	(Ljava/lang/String;)V
      //   56: astore_1
      //   57: aload_1
      //   58: aload_2
      //   59: invokestatic 49	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   62: invokevirtual 53	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
      //   65: pop
      //   66: aload_0
      //   67: getfield 12	com/baidu/android/pushservice/richmedia/MediaViewActivity$2:a	Lcom/baidu/android/pushservice/richmedia/MediaViewActivity;
      //   70: aload_1
      //   71: invokevirtual 57	com/baidu/android/pushservice/richmedia/MediaViewActivity:startActivity	(Landroid/content/Intent;)V
      //   74: iconst_1
      //   75: ireturn
      //   76: aload_2
      //   77: ldc 67
      //   79: invokevirtual 36	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   82: ifeq +41 -> 123
      //   85: new 38	android/content/Intent
      //   88: dup
      //   89: ldc 65
      //   91: invokespecial 43	android/content/Intent:<init>	(Ljava/lang/String;)V
      //   94: astore 4
      //   96: aload 4
      //   98: aload_2
      //   99: invokestatic 49	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   102: invokevirtual 53	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
      //   105: pop
      //   106: aload_0
      //   107: getfield 12	com/baidu/android/pushservice/richmedia/MediaViewActivity$2:a	Lcom/baidu/android/pushservice/richmedia/MediaViewActivity;
      //   110: aload 4
      //   112: invokevirtual 57	com/baidu/android/pushservice/richmedia/MediaViewActivity:startActivity	(Landroid/content/Intent;)V
      //   115: goto -76 -> 39
      //   118: astore 4
      //   120: goto -81 -> 39
      //   123: aload_2
      //   124: ldc 69
      //   126: invokevirtual 36	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   129: ifeq +41 -> 170
      //   132: new 38	android/content/Intent
      //   135: dup
      //   136: ldc 65
      //   138: invokespecial 43	android/content/Intent:<init>	(Ljava/lang/String;)V
      //   141: astore 4
      //   143: aload 4
      //   145: aload_2
      //   146: invokestatic 49	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   149: invokevirtual 53	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
      //   152: pop
      //   153: aload_0
      //   154: getfield 12	com/baidu/android/pushservice/richmedia/MediaViewActivity$2:a	Lcom/baidu/android/pushservice/richmedia/MediaViewActivity;
      //   157: aload 4
      //   159: invokevirtual 57	com/baidu/android/pushservice/richmedia/MediaViewActivity:startActivity	(Landroid/content/Intent;)V
      //   162: goto -123 -> 39
      //   165: astore 4
      //   167: goto -128 -> 39
      //   170: aload_2
      //   171: ldc 71
      //   173: invokevirtual 36	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   176: ifeq -137 -> 39
      //   179: new 38	android/content/Intent
      //   182: dup
      //   183: ldc 65
      //   185: invokespecial 43	android/content/Intent:<init>	(Ljava/lang/String;)V
      //   188: astore 6
      //   190: aload_2
      //   191: bipush 63
      //   193: invokevirtual 75	java/lang/String:indexOf	(I)I
      //   196: istore_3
      //   197: iload_3
      //   198: iconst_m1
      //   199: if_icmpne +69 -> 268
      //   202: aload_2
      //   203: iconst_4
      //   204: invokevirtual 79	java/lang/String:substring	(I)Ljava/lang/String;
      //   207: astore 4
      //   209: aload 6
      //   211: new 81	java/lang/StringBuilder
      //   214: dup
      //   215: invokespecial 82	java/lang/StringBuilder:<init>	()V
      //   218: ldc 71
      //   220: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   223: aload 4
      //   225: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   228: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   231: invokestatic 49	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   234: invokevirtual 53	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
      //   237: pop
      //   238: aload 6
      //   240: ldc 92
      //   242: aload 4
      //   244: invokevirtual 96	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   247: pop
      //   248: aload 6
      //   250: ldc 98
      //   252: invokevirtual 102	android/content/Intent:setType	(Ljava/lang/String;)Landroid/content/Intent;
      //   255: pop
      //   256: aload_0
      //   257: getfield 12	com/baidu/android/pushservice/richmedia/MediaViewActivity$2:a	Lcom/baidu/android/pushservice/richmedia/MediaViewActivity;
      //   260: aload 6
      //   262: invokevirtual 57	com/baidu/android/pushservice/richmedia/MediaViewActivity:startActivity	(Landroid/content/Intent;)V
      //   265: goto -226 -> 39
      //   268: aload_2
      //   269: iconst_4
      //   270: iload_3
      //   271: invokevirtual 105	java/lang/String:substring	(II)Ljava/lang/String;
      //   274: astore 5
      //   276: aload_2
      //   277: invokestatic 49	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   280: invokevirtual 108	android/net/Uri:getQuery	()Ljava/lang/String;
      //   283: astore 7
      //   285: aload 5
      //   287: astore 4
      //   289: aload 7
      //   291: ifnull -82 -> 209
      //   294: aload 5
      //   296: astore 4
      //   298: aload 7
      //   300: ldc 110
      //   302: invokevirtual 36	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   305: ifeq -96 -> 209
      //   308: aload 6
      //   310: ldc 112
      //   312: aload 7
      //   314: iconst_5
      //   315: invokevirtual 79	java/lang/String:substring	(I)Ljava/lang/String;
      //   318: invokevirtual 96	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   321: pop
      //   322: aload 5
      //   324: astore 4
      //   326: goto -117 -> 209
      //   329: aload_1
      //   330: aload_2
      //   331: invokevirtual 117	android/webkit/WebView:loadUrl	(Ljava/lang/String;)V
      //   334: goto -260 -> 74
      //   337: astore_1
      //   338: goto -264 -> 74
      //   341: astore 4
      //   343: goto -304 -> 39
      //   346: astore 4
      //   348: goto -309 -> 39
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	351	0	this	2
      //   0	351	1	paramAnonymousWebView	WebView
      //   0	351	2	paramAnonymousString	String
      //   196	75	3	i	int
      //   18	93	4	localIntent1	Intent
      //   118	1	4	localActivityNotFoundException1	android.content.ActivityNotFoundException
      //   141	17	4	localIntent2	Intent
      //   165	1	4	localActivityNotFoundException2	android.content.ActivityNotFoundException
      //   207	118	4	localObject	Object
      //   341	1	4	localActivityNotFoundException3	android.content.ActivityNotFoundException
      //   346	1	4	localActivityNotFoundException4	android.content.ActivityNotFoundException
      //   274	49	5	str1	String
      //   188	121	6	localIntent3	Intent
      //   283	30	7	str2	String
      // Exception table:
      //   from	to	target	type
      //   85	115	118	android/content/ActivityNotFoundException
      //   132	162	165	android/content/ActivityNotFoundException
      //   47	74	337	android/content/ActivityNotFoundException
      //   9	39	341	android/content/ActivityNotFoundException
      //   179	197	346	android/content/ActivityNotFoundException
      //   202	209	346	android/content/ActivityNotFoundException
      //   209	265	346	android/content/ActivityNotFoundException
      //   268	285	346	android/content/ActivityNotFoundException
      //   298	322	346	android/content/ActivityNotFoundException
    }
  };
  
  @TargetApi(11)
  private void a()
  {
    this.a.removeJavascriptInterface("searchBoxJavaBridge_");
    this.a.removeJavascriptInterface("accessibility");
    this.a.removeJavascriptInterface("accessibilityTraversal");
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(1);
    paramBundle = new LinearLayout.LayoutParams(-1, -1, 0.0F);
    this.b = new RelativeLayout(this);
    this.b.setLayoutParams(paramBundle);
    this.b.setGravity(1);
    this.a = new WebView(this);
    if (Build.VERSION.SDK_INT >= 11) {
      a();
    }
    this.a.requestFocusFromTouch();
    this.a.setLongClickable(true);
    paramBundle = this.a.getSettings();
    paramBundle.setCacheMode(1);
    paramBundle.setDatabaseEnabled(true);
    paramBundle.setDomStorageEnabled(true);
    paramBundle.setAllowFileAccess(true);
    paramBundle.setAppCacheEnabled(true);
    paramBundle.setJavaScriptEnabled(true);
    paramBundle.setLightTouchEnabled(true);
    paramBundle.setDefaultTextEncodingName("utf-8");
    paramBundle.setSavePassword(false);
    this.a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.a.setWebChromeClient(this.c);
    this.a.setWebViewClient(this.d);
    this.b.addView(this.a);
    setContentView(this.b);
    if ((this.b == null) || (this.a == null)) {
      finish();
    }
    paramBundle = getIntent().getData();
    if (paramBundle != null) {
      this.a.loadUrl(paramBundle.toString());
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    paramIntent = paramIntent.getData();
    if (paramIntent != null) {
      this.a.loadUrl(paramIntent.toString());
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/richmedia/MediaViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */