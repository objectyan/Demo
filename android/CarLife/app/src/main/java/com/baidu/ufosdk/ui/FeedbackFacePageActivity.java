package com.baidu.ufosdk.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.ufosdk.ResumeCallBack;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.util.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;

@SuppressLint({"SetJavaScriptEnabled"})
@TargetApi(11)
public class FeedbackFacePageActivity
  extends Activity
{
  private EditText A;
  private LinearLayout B;
  private TextView C;
  private TextView D;
  private RelativeLayout E;
  private LinearLayout F;
  private TextView G;
  private LinearLayout H;
  Runnable a = new a(this);
  private SharedPreferences.Editor b;
  private SharedPreferences c;
  private String d = "";
  private String e = "";
  private String f = "";
  private RelativeLayout g;
  private LinearLayout h;
  private ImageView i;
  private Button j;
  private Button k;
  private TextView l;
  private TextView m;
  private RelativeLayout n;
  private View o;
  private WebView p;
  private Timer q;
  private TextView r;
  private String s;
  private boolean t = false;
  private boolean u = false;
  private ListView v;
  private x w;
  private ArrayList x = new ArrayList();
  private ArrayList y = new ArrayList();
  @SuppressLint({"HandlerLeak"})
  private Handler z = new m(this);
  
  private void b()
  {
    if (UfoSDK.clientid.length() == 0) {
      return;
    }
    this.z.obtainMessage(2, null).sendToTarget();
  }
  
  private void c()
  {
    getApplicationContext();
    new w(this).execute(new Void[0]);
  }
  
  public final void a()
  {
    if (UfoSDK.clientid.length() == 0)
    {
      Toast.makeText(getApplicationContext(), com.baidu.ufosdk.util.u.a("18"), 1).show();
      localObject = com.baidu.ufosdk.b.c.b(getApplicationContext());
      boolean bool1 = ((String)localObject).contains("UNKNOWN");
      boolean bool2 = ((String)localObject).contains("NONE");
      if ((!bool1) || (bool2)) {
        new Thread(new l(this)).start();
      }
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).putExtra("url", this.d);
    ((Intent)localObject).putExtra("feedback_channel", com.baidu.ufosdk.a.h);
    ((Intent)localObject).putExtra("extra", this.e);
    ((Intent)localObject).setClass(this, FeedbackListActivity.class);
    startActivity((Intent)localObject);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setRequestedOrientation(1);
    getWindow().setSoftInputMode(32);
    try
    {
      this.c = getSharedPreferences("UfoSharePreference", 0);
      if (this.c != null) {
        this.b = this.c.edit();
      }
      if (this.b != null)
      {
        this.b.putBoolean("ADD_PIC_FLAG", true);
        this.b.commit();
      }
      com.baidu.ufosdk.a.h = getIntent().getIntExtra("feedback_channel", 0);
      com.baidu.ufosdk.a.i = getIntent().getIntExtra("faq_channel", 0);
      this.f = getIntent().getStringExtra("faq_id");
      this.s = getIntent().getStringExtra("msgid");
      if (TextUtils.isEmpty(this.s)) {
        this.s = "newMessage";
      }
      if (TextUtils.isEmpty(this.f)) {
        this.f = "";
      }
    }
    catch (Exception paramBundle)
    {
      try
      {
        ((RelativeLayout)localObject1).setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.util.p.a(getApplicationContext(), "ufo_nav_bg.png")));
        Object localObject2 = new RelativeLayout.LayoutParams(-1, i.a(getApplicationContext(), 50.0F));
        ((RelativeLayout.LayoutParams)localObject2).addRule(10);
        this.g.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new RelativeLayout(this);
        ((RelativeLayout)localObject2).setId(2131296260);
        ((RelativeLayout)localObject2).setBackgroundColor(com.baidu.ufosdk.a.y);
        float f1 = i.a(getApplicationContext(), 4.0F);
        Object localObject3 = new GradientDrawable();
        ((GradientDrawable)localObject3).setColor(-1);
        ((GradientDrawable)localObject3).setCornerRadius(f1);
        ((GradientDrawable)localObject3).setStroke(1, -2500135);
        this.E = new RelativeLayout(this);
        this.E.setId(2131230749);
        this.E.setClickable(true);
        this.E.setVisibility(0);
        this.E.setGravity(17);
        this.E.setBackgroundDrawable((Drawable)localObject3);
        localObject3 = new BitmapDrawable(com.baidu.ufosdk.util.p.a(getApplicationContext(), "ufo_search_icon.png"));
        ((Drawable)localObject3).setBounds(0, 0, i.a(getApplicationContext(), 12.0F), i.a(getApplicationContext(), 12.0F));
        Object localObject4 = new ImageView(this);
        ((ImageView)localObject4).setId(2131230765);
        ((ImageView)localObject4).setBackgroundDrawable((Drawable)localObject3);
        Object localObject5 = new RelativeLayout.LayoutParams(i.a(getApplicationContext(), 12.0F), i.a(getApplicationContext(), 12.0F));
        ((RelativeLayout.LayoutParams)localObject5).addRule(13);
        ((RelativeLayout.LayoutParams)localObject5).setMargins(0, 0, i.a(getApplicationContext(), 5.0F), 0);
        this.E.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
        localObject5 = new TextView(this);
        ((TextView)localObject5).setId(2131230733);
        ((TextView)localObject5).setVisibility(0);
        ((TextView)localObject5).setClickable(true);
        ((TextView)localObject5).setText("搜索");
        ((TextView)localObject5).setTextColor(-10066330);
        ((TextView)localObject5).setTextSize(13.0F);
        ((TextView)localObject5).setGravity(16);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(13);
        localLayoutParams.addRule(1, ((ImageView)localObject4).getId());
        this.E.addView((View)localObject5, localLayoutParams);
        localObject4 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject4).addRule(13);
        ((RelativeLayout)localObject2).addView(this.E, (ViewGroup.LayoutParams)localObject4);
        this.H = new LinearLayout(this);
        this.H.setBackgroundColor(0);
        this.H.setOrientation(0);
        this.H.setGravity(17);
        this.H.setVisibility(8);
        this.A = new EditText(this);
        this.A.setId(2131230734);
        this.A.setHint("请输入内容");
        this.A.setHintTextColor(-3355444);
        this.A.setTextSize(11.0F);
        this.A.setGravity(16);
        this.A.setBackgroundColor(-1);
        this.A.setCompoundDrawables((Drawable)localObject3, null, null, null);
        this.A.setCompoundDrawablePadding(10);
        this.A.setPadding(i.a(getApplicationContext(), 7.0F), 0, 0, 0);
        localObject3 = new GradientDrawable();
        ((GradientDrawable)localObject3).setColor(-1);
        ((GradientDrawable)localObject3).setCornerRadius(f1);
        ((GradientDrawable)localObject3).setStroke(1, -2500135);
        this.A.setBackgroundDrawable((Drawable)localObject3);
        localObject3 = new LinearLayout.LayoutParams(-1, -1);
        ((LinearLayout.LayoutParams)localObject3).weight = 1.0F;
        this.H.addView(this.A, (ViewGroup.LayoutParams)localObject3);
        this.D = new TextView(this);
        this.D.setText("取消");
        this.D.setId(2131296266);
        this.D.setTextColor(com.baidu.ufosdk.a.w);
        this.D.setTextSize(13.0F);
        this.D.setGravity(17);
        this.D.setTextColor(i.a(com.baidu.ufosdk.a.w, com.baidu.ufosdk.a.u, com.baidu.ufosdk.a.w, com.baidu.ufosdk.a.w));
        this.D.setBackgroundColor(0);
        this.D.setPadding(i.a(getApplicationContext(), 5.0F), 0, 0, 0);
        localObject3 = new LinearLayout.LayoutParams(-1, -1);
        ((LinearLayout.LayoutParams)localObject3).weight = 5.0F;
        this.H.addView(this.D, (ViewGroup.LayoutParams)localObject3);
        localObject3 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject3).addRule(13);
        ((RelativeLayout)localObject2).addView(this.H, (ViewGroup.LayoutParams)localObject3);
        this.E.setOnClickListener(new n(this));
        this.D.setOnClickListener(new o(this));
        f1 = 30.0F;
        if (i.a() >= 14) {
          break label1818;
        }
        f1 = 35.0F;
        localObject3 = new RelativeLayout.LayoutParams(-1, i.a(getApplicationContext(), f1));
        ((RelativeLayout.LayoutParams)localObject3).setMargins(i.a(getApplicationContext(), 8.0F), i.a(getApplicationContext(), 5.0F), i.a(getApplicationContext(), 8.0F), i.a(getApplicationContext(), 5.0F));
        ((RelativeLayout.LayoutParams)localObject3).addRule(3, ((RelativeLayout)localObject1).getId());
        this.g.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        localObject1 = new View(this);
        ((View)localObject1).setId(2131296272);
        ((View)localObject1).setBackgroundColor(-3355444);
        localObject3 = new RelativeLayout.LayoutParams(-1, 1);
        ((RelativeLayout.LayoutParams)localObject3).addRule(3, ((RelativeLayout)localObject2).getId());
        this.g.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
        this.B = new LinearLayout(this);
        this.B.setBackgroundColor(-723724);
        this.B.setVisibility(8);
        this.B.setOrientation(1);
        this.v = new ListView(this);
        this.v.setSelector(new ColorDrawable(0));
        this.v.setCacheColorHint(-1);
        this.v.setDivider(new ColorDrawable(-3355444));
        this.v.setDividerHeight(1);
        localObject2 = new LinearLayout.LayoutParams(-1, -1);
        this.B.addView(this.v, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((View)localObject1).getId());
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        this.g.addView(this.B, (ViewGroup.LayoutParams)localObject2);
        this.C = new TextView(this);
        this.C.setVisibility(8);
        this.C.setTextSize(13.0F);
        this.C.setClickable(true);
        this.C.setGravity(17);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(13);
        this.g.addView(this.C, (ViewGroup.LayoutParams)localObject2);
        this.C.setOnClickListener(new p(this));
        this.w = new x(this, this);
        this.v.setAdapter(this.w);
        this.v.setOnItemClickListener(new r(this));
        this.v.setOnScrollListener(new s(this));
        this.A.addTextChangedListener(new t(this));
        this.A.setOnFocusChangeListener(new u(this));
        this.G = new TextView(this);
        this.G.setId(2131230740);
        this.G.setText("常见问题");
        this.G.setTextColor(-10066330);
        this.G.setTextSize(15.0F);
        this.G.setGravity(16);
        this.G.setPadding(i.a(getApplicationContext(), 10.0F), 0, 0, 0);
        localObject2 = new RelativeLayout.LayoutParams(-1, i.a(getApplicationContext(), 35.0F));
        ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((View)localObject1).getId());
        this.g.addView(this.G, (ViewGroup.LayoutParams)localObject2);
        localObject1 = new View(this);
        ((View)localObject1).setId(2131296274);
        ((View)localObject1).setBackgroundColor(-3355444);
        localObject2 = new RelativeLayout.LayoutParams(-1, 1);
        ((RelativeLayout.LayoutParams)localObject2).addRule(3, this.G.getId());
        this.g.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        this.F = new LinearLayout(this);
        this.F.setId(2131296275);
        this.F.setOrientation(0);
        this.F.setBackgroundColor(-526345);
        localObject2 = new LinearLayout(this);
        ((LinearLayout)localObject2).setOrientation(1);
        ((LinearLayout)localObject2).setGravity(1);
        ((LinearLayout)localObject2).setBackgroundDrawable(com.baidu.ufosdk.util.p.a(getApplicationContext(), null, "ufo_back_layout_press.png"));
        ((LinearLayout)localObject2).setClickable(true);
        localObject3 = new TextView(this);
        ((TextView)localObject3).setText("全部问题");
        ((TextView)localObject3).setTextColor(com.baidu.ufosdk.a.u);
        ((TextView)localObject3).setTextSize(com.baidu.ufosdk.a.ac);
        ((TextView)localObject3).setGravity(16);
        localObject4 = new BitmapDrawable(com.baidu.ufosdk.util.p.a(getApplicationContext(), "ufo_all_pro_icon.png"));
        ((Drawable)localObject4).setBounds(0, 0, i.a(getApplicationContext(), 18.0F), i.a(getApplicationContext(), 18.0F));
        ((TextView)localObject3).setCompoundDrawables((Drawable)localObject4, null, null, null);
        ((TextView)localObject3).setCompoundDrawablePadding(i.a(getApplicationContext(), 8.0F));
        ((LinearLayout)localObject2).addView((View)localObject3, new LinearLayout.LayoutParams(-2, -1));
        localObject3 = new LinearLayout(this);
        ((LinearLayout)localObject3).setOrientation(1);
        ((LinearLayout)localObject3).setGravity(1);
        ((LinearLayout)localObject3).setBackgroundDrawable(com.baidu.ufosdk.util.p.a(getApplicationContext(), null, "ufo_back_layout_press.png"));
        ((LinearLayout)localObject3).setClickable(true);
        localObject4 = new TextView(this);
        ((TextView)localObject4).setText("我要反馈");
        ((TextView)localObject4).setTextColor(com.baidu.ufosdk.a.u);
        ((TextView)localObject4).setTextSize(com.baidu.ufosdk.a.ac);
        ((TextView)localObject4).setGravity(16);
        localObject5 = new BitmapDrawable(com.baidu.ufosdk.util.p.a(getApplicationContext(), "ufo_feedback_icon.png"));
        ((Drawable)localObject5).setBounds(0, 0, i.a(getApplicationContext(), 18.0F), i.a(getApplicationContext(), 18.0F));
        ((TextView)localObject4).setCompoundDrawables((Drawable)localObject5, null, null, null);
        ((TextView)localObject4).setCompoundDrawablePadding(i.a(getApplicationContext(), 8.0F));
        ((LinearLayout)localObject3).addView((View)localObject4, new LinearLayout.LayoutParams(-2, -1));
        localObject4 = new LinearLayout.LayoutParams(-1, -1);
        ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
        this.F.addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
        localObject4 = new View(this);
        localObject5 = new LinearLayout.LayoutParams(i.a(getApplicationContext(), 0.8F), -1);
        ((LinearLayout.LayoutParams)localObject5).setMargins(0, i.a(getApplicationContext(), 8.0F), 0, i.a(getApplicationContext(), 8.0F));
        ((View)localObject4).setBackgroundColor(-6710887);
        this.F.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
        localObject4 = new LinearLayout.LayoutParams(-1, -1);
        ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
        this.F.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
        localObject4 = new RelativeLayout.LayoutParams(-1, i.a(getApplicationContext(), 50.0F));
        ((RelativeLayout.LayoutParams)localObject4).addRule(12);
        this.g.addView(this.F, (ViewGroup.LayoutParams)localObject4);
        ((LinearLayout)localObject2).setOnClickListener(new b(this));
        ((LinearLayout)localObject3).setOnClickListener(new c(this));
        paramBundle.setOnClickListener(new e(this));
        this.j.setOnClickListener(new f(this));
        i1 = ((View)localObject1).getId();
        i2 = this.F.getId();
        this.n = new RelativeLayout(this);
        paramBundle = new RelativeLayout.LayoutParams(-1, -1);
        this.n.setLayoutParams(paramBundle);
        this.h = new LinearLayout(this);
        this.h.setOrientation(1);
        this.h.setGravity(17);
        this.h.setVisibility(8);
        new LinearLayout.LayoutParams(-2, -2);
        paramBundle = new ImageView(this);
        localObject1 = new LinearLayout.LayoutParams(i.a(getApplicationContext(), 115.0F), i.a(getApplicationContext(), 101.0F));
      }
      catch (Exception paramBundle)
      {
        try
        {
          paramBundle.setBackgroundDrawable(com.baidu.ufosdk.util.r.a(getApplicationContext(), "ufo_no_netwrok.png"));
          this.h.addView(paramBundle, (ViewGroup.LayoutParams)localObject1);
          this.r = new TextView(this);
          this.r.setPadding(i.a(getApplicationContext(), 10.0F), i.a(getApplicationContext(), 18.0F), i.a(getApplicationContext(), 10.0F), i.a(getApplicationContext(), 11.0F));
          this.r.setTextSize(com.baidu.ufosdk.a.M);
          this.r.setTextColor(-10066330);
          paramBundle = new LinearLayout.LayoutParams(-2, -2);
          i.a(getApplicationContext(), this.r);
          this.h.addView(this.r, paramBundle);
          this.k = new Button(this);
          this.k.setText(com.baidu.ufosdk.util.u.a("22"));
          this.k.setTextSize(com.baidu.ufosdk.a.N);
          this.k.setTextColor(-13421773);
        }
        catch (Exception paramBundle)
        {
          try
          {
            int i1;
            int i2;
            this.k.setBackgroundDrawable(com.baidu.ufosdk.util.p.a(getApplicationContext(), "ufo_reload_btn_defult.9.png", "ufo_reload_btn_press.9.png"));
            paramBundle = new LinearLayout.LayoutParams(i.a(getApplicationContext(), 122.0F), i.a(getApplicationContext(), 40.0F));
            this.h.addView(this.k, paramBundle);
            paramBundle = new RelativeLayout.LayoutParams(-2, -2);
            paramBundle.addRule(13);
            this.n.addView(this.h, paramBundle);
            this.k.setOnClickListener(new g(this));
            paramBundle = new LinearLayout(this);
            paramBundle.setOrientation(0);
            paramBundle.setGravity(16);
            localObject1 = new LinearLayout.LayoutParams(-1, -1);
            this.p = new WebView(this);
            if (Integer.parseInt(Build.VERSION.SDK) < 11) {
              break label3588;
            }
            this.p.setLayerType(1, null);
            paramBundle.addView(this.p, (ViewGroup.LayoutParams)localObject1);
            localObject1 = new RelativeLayout.LayoutParams(-1, -1);
            this.n.addView(paramBundle, (ViewGroup.LayoutParams)localObject1);
            this.o = i.b(this, com.baidu.ufosdk.util.u.a("13"));
            paramBundle = new RelativeLayout.LayoutParams(-2, -2);
            paramBundle.addRule(13);
            this.n.addView(this.o, paramBundle);
            paramBundle = new RelativeLayout.LayoutParams(-1, -1);
            paramBundle.addRule(3, i1);
            paramBundle.addRule(2, i2);
            this.g.addView(this.n, paramBundle);
            this.p.getSettings().setJavaScriptEnabled(true);
            this.p.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
          }
          catch (Exception paramBundle)
          {
            try
            {
              for (;;)
              {
                this.p.getClass().getMethod("removeJavascriptInterface", new Class[] { String.class });
                this.p.removeJavascriptInterface("searchBoxJavaBridge_");
                this.p.removeJavascriptInterface("accessibility");
                this.p.removeJavascriptInterface("accessibilityTraversal");
                if ((!com.baidu.ufosdk.b.c.b(getApplicationContext()).contains("UNKNOWN")) && (!com.baidu.ufosdk.b.c.b(getApplicationContext()).contains("NONE"))) {
                  break;
                }
                this.p.getSettings().setCacheMode(1);
                if (this.c.getBoolean("CHECK_WEBVIEW", true))
                {
                  i.a(getApplicationContext(), this.r);
                  this.h.setVisibility(0);
                  this.p.setVisibility(8);
                }
                this.o.setVisibility(8);
                this.p.getSettings().setAppCacheMaxSize(8388608L);
                paramBundle = getFilesDir().getAbsolutePath() + "/UfoCacheFile";
                Object localObject1 = new File(paramBundle);
                com.baidu.ufosdk.util.c.b("cacheDirPath=" + paramBundle);
                if (!((File)localObject1).exists()) {
                  ((File)localObject1).mkdirs();
                }
                this.p.getSettings().setBlockNetworkImage(false);
                this.p.getSettings().setDatabaseEnabled(true);
                this.p.getSettings().setDomStorageEnabled(true);
                this.p.getSettings().setDatabasePath(paramBundle);
                this.p.getSettings().setAppCachePath(paramBundle);
                this.p.getSettings().setAppCacheEnabled(true);
                this.p.getSettings().setAppCacheMaxSize(10L);
                this.p.getSettings().setAllowFileAccess(true);
                this.p.setWebViewClient(new z(this, (byte)0));
                this.p.setWebChromeClient(new com.baidu.ufosdk.d.a("ufo", UfoJavaScriptInterface.class));
                setContentView(this.g);
                if ((UfoSDK.clientid.length() != 0) || (UfoSDK.clientid == null)) {
                  b();
                }
                return;
                paramBundle = paramBundle;
                paramBundle.printStackTrace();
                continue;
                localException1 = localException1;
                localException1.printStackTrace();
                continue;
                localException2 = localException2;
                localException2.printStackTrace();
              }
              paramBundle = paramBundle;
              paramBundle.printStackTrace();
            }
            catch (Exception paramBundle)
            {
              for (;;)
              {
                com.baidu.ufosdk.util.c.a("webView : This API level do not support `removeJavascriptInterface`");
                continue;
                this.b.putBoolean("CHECK_WEBVIEW", false);
                this.b.commit();
                this.h.setVisibility(8);
                this.p.setVisibility(0);
                this.p.getSettings().setCacheMode(-1);
              }
            }
          }
        }
      }
    }
    this.g = new RelativeLayout(this);
    this.g.setId(2131230724);
    localObject1 = new RelativeLayout(this);
    ((RelativeLayout)localObject1).setId(2131296259);
    this.g.setBackgroundColor(com.baidu.ufosdk.a.y);
    new RelativeLayout.LayoutParams(-1, -1);
    new LinearLayout.LayoutParams(-2, -2);
    paramBundle = new LinearLayout(this);
    paramBundle.setOrientation(0);
    paramBundle.setGravity(16);
    paramBundle.setBackgroundDrawable(com.baidu.ufosdk.util.p.a(getApplicationContext(), null, "ufo_back_layout_press.png"));
    localObject2 = new LinearLayout.LayoutParams(i.a(getApplicationContext(), 18.0F), i.a(getApplicationContext(), 50.0F));
    ((LinearLayout.LayoutParams)localObject2).setMargins(i.a(getApplicationContext(), 10.0F), 0, 0, 0);
    this.i = new ImageView(this);
    this.i.setId(2131230721);
    this.i.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.i.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.util.p.a(getApplicationContext(), "ufo_back_icon.png")));
    paramBundle.addView(this.i, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(this);
    ((TextView)localObject2).setText(com.baidu.ufosdk.a.g);
    ((TextView)localObject2).setTextSize(com.baidu.ufosdk.a.K);
    ((TextView)localObject2).setTextColor(com.baidu.ufosdk.a.D);
    ((TextView)localObject2).setGravity(16);
    localObject3 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject3).setMargins(0, 0, i.a(getApplicationContext(), 8.0F), 0);
    paramBundle.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout)localObject1).addView(paramBundle, (ViewGroup.LayoutParams)localObject2);
    this.l = new TextView(this);
    this.l.setId(2131230722);
    this.l.setText(com.baidu.ufosdk.util.u.a("7"));
    this.l.setTextColor(com.baidu.ufosdk.a.s);
    this.l.setTextSize(com.baidu.ufosdk.a.R);
    this.l.setGravity(17);
    localObject2 = new RelativeLayout.LayoutParams(-2, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(13);
    ((RelativeLayout)localObject1).addView(this.l, (ViewGroup.LayoutParams)localObject2);
    this.j = new Button(this);
    this.j.setText(com.baidu.ufosdk.util.u.a("17"));
    this.j.setId(2131296262);
    this.j.setTextColor(com.baidu.ufosdk.a.t);
    this.j.setTextSize(com.baidu.ufosdk.a.S);
    this.j.setGravity(17);
    this.j.setTextColor(i.a(com.baidu.ufosdk.a.t, com.baidu.ufosdk.a.u, com.baidu.ufosdk.a.t, com.baidu.ufosdk.a.t));
    this.j.setBackgroundColor(16777215);
    this.j.setPadding(i.a(getApplicationContext(), 8.0F), 0, i.a(getApplicationContext(), 8.0F), 0);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 0, i.a(getApplicationContext(), 10.0F), 0);
    ((RelativeLayout)localObject1).addView(this.j, (ViewGroup.LayoutParams)localObject2);
    this.m = new TextView(this);
    localObject2 = new RelativeLayout.LayoutParams(i.a(getApplicationContext(), 9.0F), i.a(getApplicationContext(), 9.0F));
    this.m.setTextColor(-1);
    this.m.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.util.p.a(getApplicationContext(), "ufo_newmsg_flag.png")));
    this.m.setGravity(17);
    this.m.setVisibility(8);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(0, i.a(getApplicationContext(), 13.0F), i.a(getApplicationContext(), 14.0F), 0);
    ((RelativeLayout)localObject1).addView(this.m, (ViewGroup.LayoutParams)localObject2);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.baidu.ufosdk.util.a.a = null;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.t = true;
      if (!this.u) {
        c();
      }
      for (;;)
      {
        return true;
        if (UfoSDK.clientid.length() != 0)
        {
          this.B.setVisibility(8);
          this.H.setVisibility(8);
          this.E.setVisibility(0);
          this.A.setFocusable(false);
          this.A.setFocusableInTouchMode(false);
          if ((getCurrentFocus() != null) && (getCurrentFocus().getWindowToken() != null)) {
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
          }
          this.z.obtainMessage(2, null).sendToTarget();
          this.F.setVisibility(0);
          this.G.setText("常用问题");
          com.baidu.ufosdk.util.c.b("onKeyDown-->handler.obtainMessage(2");
        }
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onRestart()
  {
    super.onRestart();
    this.C.setVisibility(8);
    this.p.setVisibility(0);
  }
  
  protected void onResume()
  {
    super.onResume();
    String str = this.A.getText().toString();
    if ((str == null) || (str.length() == 0)) {
      this.C.setVisibility(8);
    }
    this.p.setVisibility(0);
    if (com.baidu.ufosdk.a.ah != null) {
      com.baidu.ufosdk.a.ah.onResumeCallback();
    }
    this.l.setText(com.baidu.ufosdk.util.u.a("7"));
    this.j.setText(com.baidu.ufosdk.util.u.a("17"));
    i.a(getApplicationContext(), this.r);
    this.k.setText(com.baidu.ufosdk.util.u.a("22"));
    i.a((RelativeLayout)this.o, com.baidu.ufosdk.util.u.a("13"));
    this.j.setTextSize(com.baidu.ufosdk.a.S);
    if (this.s == null) {
      this.s = "newMessage";
    }
    for (;;)
    {
      this.p.resumeTimers();
      if (UfoSDK.clientid.length() != 0) {
        break;
      }
      new Thread(new j(this)).start();
      return;
      if (this.s.length() == 0) {
        this.s = "newMessage";
      }
    }
    new Thread(new k(this)).start();
  }
  
  protected void onStart()
  {
    super.onStart();
    this.C.setVisibility(8);
    this.p.setVisibility(0);
  }
  
  protected void onStop()
  {
    super.onStop();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/FeedbackFacePageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */