package com.baidu.ufosdk.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.ufosdk.ResumeCallBack;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.a;
import com.baidu.ufosdk.a.b;
import com.baidu.ufosdk.util.i;
import com.baidu.ufosdk.util.p;
import com.baidu.ufosdk.util.r;
import com.baidu.ufosdk.util.u;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressLint({"HandlerLeak", "InlinedApi"})
@TargetApi(8)
public class FeedbackListActivity
  extends Activity
{
  private static b y;
  private PopupWindow A;
  private Handler B = new cg(this);
  private BroadcastReceiver C = new cj(this);
  private RelativeLayout a;
  private LinearLayout b;
  private LinearLayout c;
  private TextView d;
  private List e;
  private final int f = 2132344833;
  private final int g = 2132344834;
  private final int h = 2132344836;
  private final int i = 2132344837;
  private final int j = 2132344838;
  private final int k = 2132344839;
  private final int l = 2132344840;
  private final int m = 2132344842;
  private final int n = 2132344844;
  private final int o = 2132344845;
  private final int p = 2132344846;
  private int q = -1;
  private Button r;
  private ImageView s;
  private TextView t;
  private ListView u;
  private cw v;
  private View w;
  private View x;
  private ExecutorService z;
  
  private View a(Context paramContext, String paramString1, String paramString2)
  {
    RelativeLayout localRelativeLayout1 = new RelativeLayout(paramContext);
    RelativeLayout localRelativeLayout2 = new RelativeLayout(paramContext);
    localRelativeLayout2.setBackgroundDrawable(null);
    try
    {
      localRelativeLayout1.setBackgroundDrawable(r.a(paramContext, "ufo_delete_bg.9.png"));
      Object localObject = new RelativeLayout.LayoutParams(i.a(paramContext, 19.0F), i.a(paramContext, 23.0F));
      localRelativeLayout2.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ImageView localImageView = new ImageView(paramContext);
      localImageView.setId(2132345067);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setAdjustViewBounds(true);
      localImageView.setImageBitmap(p.a(paramContext, "ufo_delete_btn_icon.png"));
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localRelativeLayout2.addView(localImageView, (ViewGroup.LayoutParams)localObject);
      localObject = new TextView(paramContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(0, i.a(paramContext, 5.0F), 0, 0);
      ((TextView)localObject).setTextColor(-1);
      ((TextView)localObject).setText(paramString1);
      ((TextView)localObject).setTextSize(a.ab);
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(3, localImageView.getId());
      localRelativeLayout2.addView((View)localObject, localLayoutParams);
      paramString1 = new RelativeLayout.LayoutParams(-2, -2);
      paramString1.setMargins(0, 0, 0, 0);
      localRelativeLayout2.setPadding(0, 0, 0, 0);
      paramString1.addRule(13);
      localRelativeLayout1.addView(localRelativeLayout2, paramString1);
      localRelativeLayout1.setOnClickListener(new ch(this, paramContext, paramString2));
      return localRelativeLayout1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  @SuppressLint({"SimpleDateFormat"})
  public static String a(String paramString)
  {
    Object localObject = new SimpleDateFormat("EEEE");
    paramString = new Date(Long.parseLong(paramString));
    localObject = ((SimpleDateFormat)localObject).format(paramString).replace("星期", "周");
    return new SimpleDateFormat("dd").format(paramString) + "\n" + (String)localObject;
  }
  
  @SuppressLint({"SimpleDateFormat"})
  public static boolean a(String paramString1, String paramString2)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月");
    paramString1 = localSimpleDateFormat.format(new Date(Long.parseLong(paramString1)));
    return localSimpleDateFormat.format(new Date(Long.parseLong(paramString2))).equals(paramString1);
  }
  
  @SuppressLint({"SimpleDateFormat"})
  public static String b(String paramString)
  {
    return new SimpleDateFormat("yyyy年MM月").format(new Date(Long.parseLong(paramString)));
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
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setRequestedOrientation(1);
    a.h = getIntent().getIntExtra("feedback_channel", 0);
    this.z = Executors.newSingleThreadExecutor();
    this.q = i.a(getApplicationContext(), 10.0F);
    this.e = new ArrayList();
    this.a = new RelativeLayout(this);
    this.a.setId(2132344836);
    this.a.setBackgroundColor(a.y);
    Object localObject1 = new RelativeLayout(this);
    ((RelativeLayout)localObject1).setId(2132344837);
    try
    {
      ((RelativeLayout)localObject1).setBackgroundDrawable(new BitmapDrawable(p.a(getApplicationContext(), "ufo_nav_bg.png")));
      localObject2 = new LinearLayout(this);
      ((LinearLayout)localObject2).setId(2132344838);
      this.c = new LinearLayout(this);
      this.c.setId(2132344839);
      new RelativeLayout.LayoutParams(-2, -2);
      paramBundle = new LinearLayout(this);
      paramBundle.setOrientation(0);
      paramBundle.setGravity(16);
      paramBundle.setBackgroundDrawable(p.a(getApplicationContext(), null, "ufo_back_layout_press.png"));
      localObject3 = new LinearLayout.LayoutParams(i.a(getApplicationContext(), 18.0F), i.a(getApplicationContext(), 50.0F));
      ((LinearLayout.LayoutParams)localObject3).setMargins(i.a(getApplicationContext(), 10.0F), 0, 0, 0);
      this.s = new ImageView(this);
      this.s.setId(2132344833);
      this.s.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.s.setBackgroundDrawable(new BitmapDrawable(p.a(getApplicationContext(), "ufo_back_icon.png")));
      paramBundle.addView(this.s, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this);
      ((TextView)localObject3).setText(a.g);
      ((TextView)localObject3).setTextSize(a.K);
      ((TextView)localObject3).setTextColor(a.D);
      ((TextView)localObject3).setGravity(16);
      Object localObject4 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject4).setMargins(0, 0, i.a(getApplicationContext(), 8.0F), 0);
      paramBundle.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(9);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15);
      ((RelativeLayout)localObject1).addView(paramBundle, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this);
      ((TextView)localObject3).setId(2132344834);
      ((TextView)localObject3).setText(u.a("17"));
      ((TextView)localObject3).setTextSize(a.W);
      ((TextView)localObject3).setGravity(17);
      ((TextView)localObject3).setTextColor(a.s);
      ((TextView)localObject3).setBackgroundDrawable(null);
      localObject4 = new RelativeLayout.LayoutParams(-2, -1);
      ((RelativeLayout.LayoutParams)localObject4).addRule(13);
      ((RelativeLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      new LinearLayout.LayoutParams(-2, -2).setMargins(0, 0, this.q, 0);
      ((LinearLayout)localObject2).setOrientation(1);
      ((LinearLayout)localObject2).setBackgroundColor(-1);
      this.u = new ListView(this);
      this.u.setSelector(new ColorDrawable(0));
      this.u.setCacheColorHint(-1);
      this.u.setDivider(new ColorDrawable(a.C));
      this.u.setDividerHeight(1);
      localObject3 = new LinearLayout.LayoutParams(-1, -1);
      this.c.addView(this.u, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(3, ((RelativeLayout)localObject1).getId());
      ((RelativeLayout.LayoutParams)localObject3).addRule(2, ((LinearLayout)localObject2).getId());
      this.a.addView(this.c, (ViewGroup.LayoutParams)localObject3);
      this.t = new TextView(this);
      this.t.setText(u.a("20"));
      this.t.setTextSize(a.X);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      this.a.addView(this.t, (ViewGroup.LayoutParams)localObject2);
      this.t.setVisibility(8);
      this.b = new LinearLayout(this);
      this.b.setOrientation(1);
      new LinearLayout.LayoutParams(-2, -2);
      localObject2 = new ImageView(this);
      localObject3 = new LinearLayout.LayoutParams(i.a(getApplicationContext(), 115.0F), i.a(getApplicationContext(), 101.0F));
    }
    catch (Exception localException2)
    {
      try
      {
        Object localObject3;
        ((ImageView)localObject2).setBackgroundDrawable(r.a(getApplicationContext(), "ufo_no_netwrok.png"));
        this.b.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        this.d = new TextView(this);
        this.d.setTextColor(-10066330);
        this.d.setPadding(i.a(getApplicationContext(), 10.0F), i.a(getApplicationContext(), 18.0F), i.a(getApplicationContext(), 10.0F), i.a(getApplicationContext(), 11.0F));
        this.d.setTextSize(a.M);
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        i.a(getApplicationContext(), this.d);
        this.b.addView(this.d, (ViewGroup.LayoutParams)localObject2);
        this.r = new Button(this);
        this.r.setText(u.a("22"));
        this.r.setTextSize(a.N);
        this.r.setTextColor(-13421773);
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            this.r.setBackgroundDrawable(p.a(getApplicationContext(), "ufo_reload_btn_defult.9.png", "ufo_reload_btn_press.9.png"));
            Object localObject2 = new LinearLayout.LayoutParams(i.a(getApplicationContext(), 122.0F), i.a(getApplicationContext(), 40.0F));
            this.b.addView(this.r, (ViewGroup.LayoutParams)localObject2);
            localObject2 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject2).addRule(13);
            this.a.addView(this.b, (ViewGroup.LayoutParams)localObject2);
            this.b.setGravity(17);
            this.b.setVisibility(8);
            localObject2 = new RelativeLayout.LayoutParams(-1, i.a(getApplicationContext(), 50.0F));
            ((RelativeLayout.LayoutParams)localObject2).addRule(10);
            this.a.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            localObject1 = new ViewGroup.LayoutParams(-1, -1);
            setContentView(this.a, (ViewGroup.LayoutParams)localObject1);
            this.w = i.b(this, u.a("13"));
            localObject1 = new RelativeLayout.LayoutParams(i.a(getApplicationContext(), 114.0F), i.a(getApplicationContext(), 39.0F));
            ((RelativeLayout.LayoutParams)localObject1).addRule(13);
            this.a.addView(this.w, (ViewGroup.LayoutParams)localObject1);
            this.x = i.b(this, u.a("4"));
            localObject1 = new RelativeLayout.LayoutParams(i.a(getApplicationContext(), 114.0F), i.a(getApplicationContext(), 39.0F));
            ((RelativeLayout.LayoutParams)localObject1).addRule(13);
            this.x.setVisibility(8);
            this.a.addView(this.x, (ViewGroup.LayoutParams)localObject1);
            paramBundle.setOnClickListener(new cm(this));
            this.r.setOnClickListener(new cn(this));
            this.v = new cw(this, this);
            this.u.setAdapter(this.v);
            this.u.setFocusable(false);
            this.u.setCacheColorHint(-1);
            this.u.setDividerHeight(1);
            this.u.setRecyclerListener(new cq(this));
            this.u.setOnItemClickListener(new cr(this));
            this.u.setOnItemLongClickListener(new cs(this));
            return;
            paramBundle = paramBundle;
            paramBundle.printStackTrace();
          }
          localException2 = localException2;
          localException2.printStackTrace();
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            localException1.printStackTrace();
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      if (y != null)
      {
        y.a();
        y = null;
      }
      this.x.setVisibility(8);
      unregisterReceiver(this.C);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void onRestart()
  {
    super.onRestart();
  }
  
  public void onResume()
  {
    super.onResume();
    if (a.ah != null) {
      a.ah.onResumeCallback();
    }
    this.t.setText(u.a("20"));
    ((TextView)findViewById(2132344834)).setText((CharSequence)a.ag.get("17"));
    this.r.setText(u.a("22"));
    i.a((RelativeLayout)this.w, u.a("13"));
    i.a((RelativeLayout)this.x, u.a("4"));
    int i1 = 0;
    for (;;)
    {
      if (i1 >= this.e.size()) {}
      for (;;)
      {
        if (UfoSDK.clientid.length() != 0) {
          break label201;
        }
        new Thread(new ct(this)).start();
        return;
        if (((String)((Map)this.e.get(i1)).get("newmsg")).equals("0")) {
          break;
        }
        this.B.obtainMessage(2, Integer.valueOf(i1)).sendToTarget();
      }
      i1 += 1;
    }
    label201:
    this.z.execute(new cu(this));
  }
  
  public void onStart()
  {
    super.onStart();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.baidu.ufosdk.gethistorylist");
    localIntentFilter.addAction("com.baidu.ufosdk.getnewhistoryflag");
    localIntentFilter.addAction("com.baidu.ufosdk.getappkeysuccess_getnewhistoryflag");
    localIntentFilter.addAction("com.baidu.ufosdk.deletemsg_dialogdismiss");
    localIntentFilter.addAction("com.baidu.ufosdk.reload");
    registerReceiver(this.C, localIntentFilter);
  }
  
  public void onStop()
  {
    super.onStop();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/FeedbackListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */