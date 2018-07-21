package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.f.g;
import com.baidu.carlife.util.p;

public class j
  extends BaseDialog
  implements View.OnClickListener
{
  private static final int e = 8000;
  private static final int f = 0;
  private static final int g = 1;
  private static final int h = 2;
  private g i;
  private RelativeLayout j;
  private RelativeLayout k;
  private RelativeLayout l;
  private ImageView m;
  private ImageView n;
  private Runnable o = new Runnable()
  {
    public void run()
    {
      j.a(j.this);
    }
  };
  private int p = 0;
  
  public j(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.k.setVisibility(0);
      this.l.setVisibility(8);
      this.m.setVisibility(0);
      this.n.setVisibility(8);
      return;
    }
    this.l.setVisibility(0);
    this.k.setVisibility(8);
    this.m.setVisibility(8);
    this.n.setVisibility(0);
    this.n.requestFocus();
  }
  
  private void i()
  {
    if (this.p < 2)
    {
      a(this.p);
      this.b.postDelayed(this.o, 8000L);
    }
    for (;;)
    {
      this.p += 1;
      return;
      k();
    }
  }
  
  private void j()
  {
    this.b.removeCallbacks(this.o);
    i();
  }
  
  private void k()
  {
    this.b.removeCallbacks(this.o);
    p.a().c("show_guide_for_home_5_0_0", false);
    d();
  }
  
  protected View a()
  {
    return LayoutInflater.from(this.c).inflate(2130968725, null);
  }
  
  public void a(e parame)
  {
    super.a(parame);
    i();
  }
  
  public void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt1 == null) || (paramArrayOfInt1.length < 2)) {}
    while ((paramArrayOfInt2 == null) || (paramArrayOfInt2.length < 2)) {
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(this.k.getLayoutParams());
    localMarginLayoutParams.setMargins(paramArrayOfInt1[0], paramArrayOfInt1[1], 0, paramArrayOfInt1[1] + localMarginLayoutParams.height);
    paramArrayOfInt1 = new RelativeLayout.LayoutParams(localMarginLayoutParams);
    this.k.setLayoutParams(paramArrayOfInt1);
    paramArrayOfInt1 = new ViewGroup.MarginLayoutParams(this.l.getLayoutParams());
    paramArrayOfInt1.setMargins(paramArrayOfInt2[0], paramArrayOfInt2[1], 0, paramArrayOfInt2[1] + paramArrayOfInt1.height);
    paramArrayOfInt1 = new RelativeLayout.LayoutParams(paramArrayOfInt1);
    this.l.setLayoutParams(paramArrayOfInt1);
  }
  
  protected void b()
  {
    this.j = ((RelativeLayout)findViewById(2131624705));
    this.k = ((RelativeLayout)findViewById(2131624706));
    this.l = ((RelativeLayout)findViewById(2131624709));
    this.m = ((ImageView)findViewById(2131624712));
    this.n = ((ImageView)findViewById(2131624713));
    this.j.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void f()
  {
    if ((this.m == null) || (this.n == null)) {
      return;
    }
    if (this.i == null)
    {
      this.i = new g(findViewById(2131624705), 12);
      this.i.d(this.m).d(this.n);
    }
    this.i.a(true);
    com.baidu.carlife.f.d.a().c(this.i);
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
    j();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/dialog/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */