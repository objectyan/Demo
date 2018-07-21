package com.baidu.carlife.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.carlife.d.b.e;
import com.baidu.carlife.d.b.f;
import com.baidu.carlife.d.b.g;

public class BatteryView
  extends RelativeLayout
{
  private Context a;
  private BatteryReceiver b;
  private View c;
  private ImageView d;
  private View e;
  private int f = 0;
  private int g = -1;
  private boolean h = false;
  private Bitmap i;
  private Bitmap j;
  private Bitmap k;
  private Paint l;
  private int m = 0;
  private int n = 0;
  private int o = 0;
  private int p = 0;
  
  public BatteryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BatteryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a(paramContext);
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void a(int paramInt)
  {
    this.g = paramInt;
    this.h = false;
    if (this.e != null) {
      this.e.setVisibility(8);
    }
    if (this.d != null) {}
    setType(this.f);
    invalidate();
  }
  
  private void a(Context paramContext)
  {
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(b.g.widget_battery_view, this, true);
    this.c = findViewById(b.f.rl_battery);
    this.d = ((ImageView)findViewById(b.f.iv_battery_state));
    if (this.d != null) {
      this.d.setVisibility(8);
    }
    this.e = findViewById(b.f.iv_charge);
    if (this.e != null)
    {
      this.e.setVisibility(8);
      this.m = this.e.getPaddingLeft();
      this.n = this.e.getPaddingRight();
      this.o = this.e.getPaddingBottom();
      this.p = this.e.getPaddingTop();
    }
    paramContext = getResources();
    this.j = BitmapFactory.decodeResource(paramContext, b.e.statusbaric_ic_battery_electricity);
    this.i = BitmapFactory.decodeResource(paramContext, b.e.statusbaric_ic_battery_electricity_black);
    this.l = new Paint();
    this.k = Bitmap.createBitmap(this.j.getWidth(), this.j.getHeight(), Bitmap.Config.ARGB_8888);
    this.k.eraseColor(-65536);
  }
  
  public static int b(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void b(int paramInt)
  {
    this.h = true;
    this.g = paramInt;
    setType(this.f);
    invalidate();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    this.b = new BatteryReceiver(null);
    this.a.registerReceiver(this.b, localIntentFilter);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.a != null) && (this.b != null)) {
      this.a.unregisterReceiver(this.b);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Rect localRect1;
    Rect localRect2;
    if (!this.h)
    {
      int i1 = getHeight() - this.p - this.o;
      int i2 = this.g * i1 / 100;
      int i3 = this.o;
      localRect1 = new Rect(this.m, i1 - i3 - i2, getWidth() - this.n, getHeight() - this.o);
      i1 = this.i.getHeight() * this.g / 100;
      localRect2 = new Rect(0, this.i.getHeight() - i1, this.i.getWidth(), this.i.getHeight());
      if (this.g <= 20) {
        paramCanvas.drawBitmap(this.k, localRect2, localRect1, this.l);
      }
    }
    else
    {
      return;
    }
    if (this.f == 1)
    {
      paramCanvas.drawBitmap(this.i, localRect2, localRect1, this.l);
      return;
    }
    paramCanvas.drawBitmap(this.j, localRect2, localRect1, this.l);
  }
  
  public void setType(int paramInt)
  {
    this.f = paramInt;
    if (this.h)
    {
      if (this.f == 1)
      {
        setBackgroundResource(b.e.statusbaric_ic_battery_charge_black);
        return;
      }
      setBackgroundResource(b.e.statusbaric_ic_battery_charge);
      return;
    }
    if (this.f == 1)
    {
      setBackgroundResource(b.e.statusbaric_ic_battery_bg_black);
      if (this.d != null) {
        this.d.setBackgroundResource(b.e.statusbaric_ic_battery_bg_black);
      }
      if (this.e != null) {
        this.e.setBackgroundResource(b.e.statusbaric_ic_battery_charge_black);
      }
    }
    for (;;)
    {
      invalidate();
      return;
      setBackgroundResource(b.e.statusbaric_ic_battery_bg);
      if (this.d != null) {
        this.d.setBackgroundResource(b.e.statusbaric_ic_battery_bg);
      }
      if (this.e != null) {
        this.e.setBackgroundResource(b.e.statusbaric_ic_battery_charge);
      }
    }
  }
  
  private class BatteryReceiver
    extends BroadcastReceiver
  {
    private BatteryReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int i;
      if ("android.intent.action.BATTERY_CHANGED".equals(paramIntent.getAction())) {
        i = paramIntent.getIntExtra("level", 0);
      }
      switch (paramIntent.getIntExtra("status", 1))
      {
      case 1: 
      default: 
        return;
      case 2: 
        BatteryView.a(BatteryView.this, i);
        return;
      case 3: 
        BatteryView.b(BatteryView.this, i);
        return;
      case 5: 
        BatteryView.a(BatteryView.this, 100);
        return;
      }
      BatteryView.b(BatteryView.this, i);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/BatteryView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */