package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.baidu.carlife.core.c;
import com.baidu.carlife.f.g;
import com.baidu.navisdk.util.common.ScreenUtil;

public class p
  extends BaseDialog
  implements View.OnClickListener
{
  private g e;
  private ImageView f;
  private ImageView g;
  private Button h;
  private String i;
  
  public p(Context paramContext)
  {
    super(paramContext);
  }
  
  protected View a()
  {
    return LayoutInflater.from(this.c).inflate(2130968963, null);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.i = "VOICE";
    this.f.setX(0.0F);
    this.f.setY(0.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(ScreenUtil.getInstance().dip2px(48), ScreenUtil.getInstance().dip2px(48));
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(11);
    localLayoutParams.topMargin = ScreenUtil.getInstance().dip2px(8);
    this.f.setImageResource(paramInt1);
    this.f.setLayoutParams(localLayoutParams);
    this.g.setX(0.0F);
    this.g.setY(0.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(ScreenUtil.getInstance().dip2px(240), ScreenUtil.getInstance().dip2px(64));
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(11);
    localLayoutParams.rightMargin = ScreenUtil.getInstance().dip2px(16);
    localLayoutParams.topMargin = ScreenUtil.getInstance().dip2px(48);
    this.g.setImageResource(paramInt2);
    this.g.setLayoutParams(localLayoutParams);
  }
  
  public void a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    this.i = "HOME";
    this.f.setX(paramArrayOfInt[0]);
    this.f.setY(paramArrayOfInt[1]);
    this.f.setImageResource(paramInt1);
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    paramArrayOfInt[0] -= ScreenUtil.getInstance().dip2px(48);
    paramArrayOfInt[1] += ScreenUtil.getInstance().dip2px(72);
    arrayOfInt2[0] = ScreenUtil.getInstance().dip2px(356);
    arrayOfInt2[1] = ScreenUtil.getInstance().dip2px(88);
    this.g.setX(arrayOfInt1[0]);
    this.g.setY(arrayOfInt1[1]);
    this.g.setImageResource(paramInt2);
    this.g.setLayoutParams(new RelativeLayout.LayoutParams(arrayOfInt2[0], arrayOfInt2[1]));
  }
  
  protected void b()
  {
    this.f = ((ImageView)findViewById(2131625854));
    this.g = ((ImageView)findViewById(2131625855));
    this.h = ((Button)findViewById(2131625856));
    this.h.setOnClickListener(this);
    setOnClickListener(null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(ScreenUtil.getInstance().dip2px(136), ScreenUtil.getInstance().dip2px(44));
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = ScreenUtil.getInstance().dip2px(24);
    this.h.setLayoutParams(localLayoutParams);
  }
  
  public void d()
  {
    super.d();
    if ("VOICE".equals(this.i)) {
      c.a().g(false);
    }
    while (!"HOME".equals(this.i)) {
      return;
    }
    com.baidu.carlife.util.p.a().c("isFristVoiceInHome", false);
  }
  
  public void f()
  {
    if (this.e == null)
    {
      this.e = new g(findViewById(2131625853), 12);
      this.e.d(findViewById(2131625856));
    }
    this.e.a(true);
    com.baidu.carlife.f.d.a().c(this.e);
  }
  
  public void g()
  {
    com.baidu.carlife.f.d.a().c();
  }
  
  public int getCustomHeight()
  {
    return com.baidu.carlife.core.d.a().i();
  }
  
  protected int getCustomWidth()
  {
    return com.baidu.carlife.core.d.a().h();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    d();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/dialog/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */