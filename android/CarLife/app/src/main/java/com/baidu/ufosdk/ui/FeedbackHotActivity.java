package com.baidu.ufosdk.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.ufosdk.ResumeCallBack;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.a;
import com.baidu.ufosdk.b.d;
import com.baidu.ufosdk.util.i;
import com.baidu.ufosdk.util.p;
import com.baidu.ufosdk.util.r;
import com.baidu.ufosdk.util.u;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"InlinedApi", "SetJavaScriptEnabled", "JavascriptInterface", "NewApi"})
public class FeedbackHotActivity
  extends Activity
{
  private final int a = 2131296257;
  private final int b = 2131296258;
  private final int c = 2131296259;
  private final int d = 2131296260;
  private final String e = "UfoCacheFile";
  private RelativeLayout f;
  private LinearLayout g;
  private ImageView h;
  private WebView i;
  private Button j;
  private View k;
  private TextView l;
  private TextView m;
  private String n = "";
  private String o = "";
  private Timer p;
  @SuppressLint({"NewApi", "HandlerLeak"})
  private Handler q = new ab(this);
  
  private void a()
  {
    if (UfoSDK.clientid.length() == 0) {}
    do
    {
      return;
      this.n = getIntent().getStringExtra("hoturl");
    } while (TextUtils.isEmpty(this.n));
    com.baidu.ufosdk.util.c.b("****url is " + this.n);
    this.n = this.n.replace("http://ufosdk.baidu.com/", a.ak);
    com.baidu.ufosdk.util.c.b("****url is222" + this.n);
    Object localObject1 = this.n.split("&");
    int i2;
    int i1;
    if (localObject1.length > 0)
    {
      i2 = localObject1.length;
      i1 = 0;
    }
    for (;;)
    {
      Object localObject2;
      if (i1 >= i2)
      {
        if (this.n.contains("uxsurvey.baidu.com")) {
          localObject2 = new JSONObject();
        }
      }
      else {
        try
        {
          ((JSONObject)localObject2).put("os", "android");
          ((JSONObject)localObject2).put("appvn", d.c());
          ((JSONObject)localObject2).put("devid", UfoSDK.devid);
          ((JSONObject)localObject2).put("osvn", Build.VERSION.RELEASE);
          ((JSONObject)localObject2).put("appname", d.a());
          ((JSONObject)localObject2).put("channel_id", a.h);
          ((JSONObject)localObject2).put("nettype", com.baidu.ufosdk.b.c.b(this));
          ((JSONObject)localObject2).put("model", Build.MODEL);
          localObject1 = "";
          if (((JSONObject)localObject2).length() > 0) {
            localObject1 = ((JSONObject)localObject2).toString();
          }
          localObject2 = new HashMap();
          ((Map)localObject2).put("refertype", "mobile");
          ((Map)localObject2).put("newreferer", localObject1);
          if (i.a() >= 8)
          {
            this.i.loadUrl(this.n, (Map)localObject2);
            return;
            localObject2 = localObject1[i1];
            if (((String)localObject2).startsWith("faq_id=")) {
              localObject2 = ((String)localObject2).replace("faq_id=", "");
            }
            try
            {
              Integer.parseInt((String)localObject2);
              this.o = ((String)localObject2);
              i1 += 1;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                this.o = "";
              }
            }
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
          this.i.loadUrl(this.n);
          return;
        }
      }
    }
    if (this.n.contains("http"))
    {
      this.i.loadUrl(this.n);
      return;
    }
    this.i.loadUrl("https://" + this.n);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1)) {
      finish();
    }
    try
    {
      overridePendingTransition(i.a(getApplicationContext(), "ufo_slide_in_from_left"), i.a(getApplicationContext(), "ufo_slide_out_to_right"));
      return super.dispatchKeyEvent(paramKeyEvent);
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  @SuppressLint({"NewApi"})
  protected void onCreate(Bundle paramBundle)
  {
    try
    {
      overridePendingTransition(i.a(getApplicationContext(), "ufo_slide_in_from_right"), i.a(getApplicationContext(), "ufo_slide_out_to_left"));
      super.onCreate(paramBundle);
      requestWindowFeature(1);
      setRequestedOrientation(1);
      this.f = new RelativeLayout(this);
      this.f.setId(2131296260);
      paramBundle = new RelativeLayout(this);
      paramBundle.setId(2131296259);
      this.f.setBackgroundColor(a.y);
      new RelativeLayout.LayoutParams(-1, -1);
      new LinearLayout.LayoutParams(-2, -2);
      this.g = new LinearLayout(this);
      this.g.setOrientation(1);
      new LinearLayout.LayoutParams(-2, -2);
      Object localObject1 = new ImageView(this);
      Object localObject2 = new LinearLayout.LayoutParams(i.a(getApplicationContext(), 115.0F), i.a(getApplicationContext(), 101.0F));
      try
      {
        ((ImageView)localObject1).setBackgroundDrawable(r.a(getApplicationContext(), "ufo_no_netwrok.png"));
        this.g.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        this.l = new TextView(this);
        this.l.setPadding(i.a(getApplicationContext(), 10.0F), i.a(getApplicationContext(), 18.0F), i.a(getApplicationContext(), 10.0F), i.a(getApplicationContext(), 11.0F));
        this.l.setTextSize(a.M);
        this.l.setTextColor(-10066330);
        localObject1 = new LinearLayout.LayoutParams(-2, -2);
        i.a(getApplicationContext(), this.l);
        this.g.addView(this.l, (ViewGroup.LayoutParams)localObject1);
        this.j = new Button(this);
        this.j.setText(u.a("22"));
        this.j.setTextSize(a.N);
        this.j.setTextColor(-13421773);
      }
      catch (Exception localException4)
      {
        try
        {
          this.j.setBackgroundDrawable(p.a(getApplicationContext(), "ufo_reload_btn_defult.9.png", "ufo_reload_btn_press.9.png"));
          localObject1 = new LinearLayout.LayoutParams(i.a(getApplicationContext(), 122.0F), i.a(getApplicationContext(), 40.0F));
          this.g.addView(this.j, (ViewGroup.LayoutParams)localObject1);
          localObject1 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject1).addRule(13);
          this.f.addView(this.g, (ViewGroup.LayoutParams)localObject1);
          this.g.setGravity(17);
          this.g.setVisibility(8);
          localObject1 = new LinearLayout(this);
          ((LinearLayout)localObject1).setOrientation(0);
          ((LinearLayout)localObject1).setGravity(16);
          ((LinearLayout)localObject1).setBackgroundDrawable(p.a(getApplicationContext(), null, "ufo_back_layout_press.png"));
          localObject2 = new LinearLayout.LayoutParams(i.a(getApplicationContext(), 18.0F), i.a(getApplicationContext(), 50.0F));
          ((LinearLayout.LayoutParams)localObject2).setMargins(i.a(getApplicationContext(), 10.0F), 0, 0, 0);
          this.h = new ImageView(this);
          this.h.setId(2131296257);
          this.h.setScaleType(ImageView.ScaleType.CENTER_CROP);
          this.h.setBackgroundDrawable(new BitmapDrawable(p.a(getApplicationContext(), "ufo_back_icon.png")));
          ((LinearLayout)localObject1).addView(this.h, (ViewGroup.LayoutParams)localObject2);
          localObject3 = new TextView(this);
          ((TextView)localObject3).setText(a.g);
          ((TextView)localObject3).setTextSize(a.K);
          ((TextView)localObject3).setTextColor(a.D);
          ((TextView)localObject3).setGravity(16);
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject2).setMargins(0, 0, i.a(getApplicationContext(), 8.0F), 0);
          ((LinearLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
          localObject3 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject3).addRule(9);
          ((RelativeLayout.LayoutParams)localObject3).addRule(15);
          paramBundle.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
          this.m = new TextView(this);
          this.m.setId(2131296258);
          this.m.setText(u.a("8"));
          this.m.setTextColor(a.s);
          this.m.setTextSize(a.Q);
          this.m.setGravity(17);
          localObject3 = new RelativeLayout.LayoutParams(-2, -1);
          ((RelativeLayout.LayoutParams)localObject3).addRule(13);
          paramBundle.addView(this.m, (ViewGroup.LayoutParams)localObject3);
        }
        catch (Exception localException4)
        {
          try
          {
            paramBundle.setBackgroundDrawable(new BitmapDrawable(p.a(getApplicationContext(), "ufo_nav_bg.png")));
            Object localObject3 = new RelativeLayout.LayoutParams(-1, i.a(getApplicationContext(), 50.0F));
            ((RelativeLayout.LayoutParams)localObject3).addRule(10);
            this.f.addView(paramBundle, (ViewGroup.LayoutParams)localObject3);
            this.i = new WebView(this);
            this.i.setBackgroundColor(a.y);
            this.i.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            localObject3 = new RelativeLayout.LayoutParams(-1, -1);
            ((RelativeLayout.LayoutParams)localObject3).addRule(12);
            ((RelativeLayout.LayoutParams)localObject3).addRule(3, paramBundle.getId());
            this.f.addView(this.i, (ViewGroup.LayoutParams)localObject3);
            new RelativeLayout.LayoutParams(-1, -1);
            this.f.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            setContentView(this.f);
            this.k = i.b(this, u.a("13"));
            paramBundle = new RelativeLayout.LayoutParams(i.a(getApplicationContext(), 114.0F), i.a(getApplicationContext(), 39.0F));
            paramBundle.addRule(13);
            this.f.addView(this.k, paramBundle);
            this.i.getSettings().setJavaScriptEnabled(true);
            this.i.getSettings().setBlockNetworkImage(false);
          }
          catch (Exception localException4)
          {
            try
            {
              for (;;)
              {
                this.i.getClass().getMethod("removeJavascriptInterface", new Class[] { String.class });
                this.i.removeJavascriptInterface("searchBoxJavaBridge_");
                this.i.removeJavascriptInterface("accessibility");
                this.i.removeJavascriptInterface("accessibilityTraversal");
                if ((!com.baidu.ufosdk.b.c.b(getApplicationContext()).contains("UNKNOWN")) && (!com.baidu.ufosdk.b.c.b(getApplicationContext()).contains("NONE"))) {
                  break;
                }
                this.i.getSettings().setCacheMode(1);
                this.k.setVisibility(8);
                this.i.getSettings().setAppCacheMaxSize(8388608L);
                paramBundle = getApplicationContext().getFilesDir().getAbsolutePath() + "UfoCacheFile";
                localObject2 = new File(getFilesDir().getAbsolutePath() + "UfoCacheFile");
                if (!((File)localObject2).exists()) {
                  ((File)localObject2).mkdir();
                }
                this.i.getSettings().setDatabaseEnabled(true);
                this.i.getSettings().setDatabasePath(paramBundle);
                this.i.getSettings().setAppCachePath(paramBundle);
                this.i.getSettings().setAppCacheEnabled(true);
                this.i.setWebViewClient(new ag(this, (byte)0));
                ((LinearLayout)localObject1).setOnClickListener(new ac(this));
                this.j.setOnClickListener(new ad(this));
                a();
                return;
                localException3 = localException3;
                localException3.printStackTrace();
                continue;
                localException1 = localException1;
                localException1.printStackTrace();
              }
              localException4 = localException4;
              localException4.printStackTrace();
            }
            catch (Exception paramBundle)
            {
              for (;;)
              {
                com.baidu.ufosdk.util.c.a("webView-->This API level do not support `removeJavascriptInterface`");
                continue;
                this.g.setVisibility(8);
                this.i.setVisibility(0);
                this.i.getSettings().setCacheMode(-1);
              }
            }
          }
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (a.ah != null) {
      a.ah.onResumeCallback();
    }
    this.j.setText(u.a("22"));
    this.m.setText(u.a("8"));
    i.a((RelativeLayout)this.k, u.a("13"));
    this.i.resumeTimers();
    if (UfoSDK.clientid.length() == 0) {
      new Thread(new ae(this)).start();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/FeedbackHotActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */