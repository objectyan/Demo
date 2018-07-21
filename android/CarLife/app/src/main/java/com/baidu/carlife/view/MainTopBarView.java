package com.baidu.carlife.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.carlife.d.b.c;
import com.baidu.carlife.d.b.e;
import com.baidu.carlife.d.b.f;
import com.baidu.carlife.d.b.g;
import com.baidu.carlife.d.b.l;
import com.baidu.carlife.l.a;

public class MainTopBarView
  extends RelativeLayout
{
  public static final int a = 0;
  public static final int b = 1;
  private int c = 0;
  
  public MainTopBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MainTopBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(b.g.main_comm_top_bar, this, true);
    paramContext = (BatteryView)findViewById(b.f.view_battery);
    TimeTextView localTimeTextView = (TimeTextView)findViewById(b.f.view_time);
    b(a.a().N());
    if (this.c == 1)
    {
      paramContext.setType(1);
      localTimeTextView.setTextColor(getResources().getColor(b.c.text_navi_black_title));
      return;
    }
    paramContext.setType(0);
    localTimeTextView.setTextColor(getResources().getColor(b.c.text_def_white_title));
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return;
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.l.TopBarView);
    this.c = paramContext.getInt(b.l.TopBarView_TopBarType, 0);
    paramContext.recycle();
  }
  
  public void a(boolean paramBoolean)
  {
    BatteryView localBatteryView = (BatteryView)findViewById(b.f.view_battery);
    TimeTextView localTimeTextView = (TimeTextView)findViewById(b.f.view_time);
    if (paramBoolean)
    {
      localBatteryView.setType(1);
      localTimeTextView.setTextColor(getResources().getColor(b.c.text_navi_black_title));
      return;
    }
    localBatteryView.setType(0);
    localTimeTextView.setTextColor(getResources().getColor(b.c.text_def_white_title));
  }
  
  public void b(boolean paramBoolean)
  {
    ImageView localImageView = (ImageView)findViewById(b.f.iv_connect);
    if (localImageView == null) {
      return;
    }
    if (paramBoolean) {
      localImageView.setImageResource(b.e.statusbaric_ic_connect);
    }
    for (;;)
    {
      localImageView.setVisibility(0);
      return;
      localImageView.setImageResource(b.e.statusbaric_ic_disconnect);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/MainTopBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */