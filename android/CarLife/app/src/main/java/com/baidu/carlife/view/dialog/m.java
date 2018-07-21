package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.baidu.carlife.f.a;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;

@Deprecated
public class m
  extends BaseDialog
{
  private TextView e;
  private FrameLayout f;
  private FrameLayout g;
  private LinearLayout h;
  protected View i;
  private TextView j;
  private TextView k;
  private LinearLayout l;
  private TextView m;
  private a n;
  private a o;
  private boolean p;
  private boolean q;
  private g r;
  
  public m(Context paramContext)
  {
    super(paramContext);
  }
  
  private void l()
  {
    this.e.setTextColor(BNStyleManager.getColor(1711800514));
    this.h.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407509));
    this.j.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407372));
    this.k.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407375));
    this.j.setTextColor(JarUtils.getResources().getColor(1711800514));
    this.k.setTextColor(JarUtils.getResources().getColor(1711800514));
  }
  
  private void setBtnVisible()
  {
    if (!this.p)
    {
      this.j.setVisibility(8);
      this.k.setVisibility(8);
      return;
    }
    if (!this.q)
    {
      this.j.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407371));
      this.j.setVisibility(0);
      this.k.setVisibility(8);
      return;
    }
    this.j.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407372));
    this.j.setVisibility(0);
    this.k.setVisibility(0);
  }
  
  protected View a()
  {
    return LayoutInflater.from(this.c).inflate(2130968951, null);
  }
  
  public m a(int paramInt)
  {
    return b(getContext().getString(paramInt));
  }
  
  public m a(View paramView)
  {
    this.f.removeAllViews();
    this.f.addView(paramView);
    return this;
  }
  
  public m a(View paramView, int paramInt1, int paramInt2)
  {
    this.f.removeAllViews();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.f.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      this.f.setLayoutParams(localLayoutParams);
    }
    this.f.addView(paramView);
    return this;
  }
  
  public m a(a parama)
  {
    this.n = parama;
    return this;
  }
  
  public m a(boolean paramBoolean)
  {
    this.j.setEnabled(paramBoolean);
    return this;
  }
  
  public m b(int paramInt)
  {
    return c(getContext().getString(paramInt));
  }
  
  public m b(View paramView)
  {
    this.h.setBackgroundResource(StyleManager.getDayColor(2130839578));
    this.l.setVisibility(0);
    this.g.removeAllViews();
    this.g.addView(paramView);
    return this;
  }
  
  public m b(a parama)
  {
    this.o = parama;
    return this;
  }
  
  public m b(String paramString)
  {
    if (paramString == null)
    {
      this.e.setVisibility(8);
      this.e.setText("", TextView.BufferType.SPANNABLE);
      return this;
    }
    this.e.setVisibility(0);
    this.e.setText(paramString, TextView.BufferType.SPANNABLE);
    return this;
  }
  
  public m b(boolean paramBoolean)
  {
    this.k.setEnabled(paramBoolean);
    return this;
  }
  
  protected void b()
  {
    this.e = ((TextView)findViewById(2131624146));
    this.h = ((LinearLayout)findViewById(2131625828));
    this.f = ((FrameLayout)findViewById(2131624267));
    this.l = ((LinearLayout)findViewById(2131624928));
    this.g = ((FrameLayout)findViewById(2131625830));
    this.m = ((TextView)findViewById(2131625829));
    this.j = ((TextView)findViewById(2131624270));
    this.k = ((TextView)findViewById(2131624271));
    this.i = findViewById(2131624268);
    this.j.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (m.a(m.this) != null) {
          m.a(m.this).onClick();
        }
        m.this.d();
      }
    });
    this.k.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (m.b(m.this) != null) {
          m.b(m.this).onClick();
        }
        m.this.d();
      }
    });
    this.p = false;
    this.q = false;
    l();
    this.e.setVisibility(8);
    this.j.setVisibility(8);
    this.k.setVisibility(8);
  }
  
  public m c(int paramInt)
  {
    return d(getContext().getString(paramInt));
  }
  
  public m c(String paramString)
  {
    if (paramString == null)
    {
      this.p = false;
      this.j.setText("", TextView.BufferType.SPANNABLE);
    }
    for (;;)
    {
      setBtnVisible();
      return this;
      this.p = true;
      this.j.setText(paramString, TextView.BufferType.SPANNABLE);
    }
  }
  
  public m d(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.f.getLayoutParams();
    localLayoutParams.width = paramInt;
    this.f.setLayoutParams(localLayoutParams);
    return this;
  }
  
  public m d(String paramString)
  {
    if (paramString == null)
    {
      this.q = false;
      this.k.setText("", TextView.BufferType.SPANNABLE);
    }
    for (;;)
    {
      setBtnVisible();
      return this;
      this.q = true;
      this.k.setText(paramString, TextView.BufferType.SPANNABLE);
    }
  }
  
  public m e(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.f.getLayoutParams();
    localLayoutParams.height = paramInt;
    this.f.setLayoutParams(localLayoutParams);
    return this;
  }
  
  public m e(String paramString)
  {
    if (paramString == null)
    {
      this.m.setVisibility(8);
      this.m.setText("", TextView.BufferType.SPANNABLE);
    }
    for (;;)
    {
      this.m.setTextColor(StyleManager.getDayColor(2131558860));
      this.m.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407509));
      return this;
      this.m.setVisibility(0);
      this.m.setText(paramString, TextView.BufferType.SPANNABLE);
    }
  }
  
  public void f()
  {
    if (this.r == null)
    {
      this.r = new g(this.i, 9);
      this.r.d(this.j).d(this.k);
    }
    this.r.a(true);
    d.a().a(new a[] { this.r });
  }
  
  public void g()
  {
    d.a().e();
  }
  
  public m i()
  {
    this.j.setTextColor(StyleManager.getDayColor(2131558860));
    return this;
  }
  
  public m j()
  {
    this.k.setTextColor(StyleManager.getDayColor(2131558860));
    return this;
  }
  
  public m k()
  {
    this.k.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (m.b(m.this) != null) {
          m.b(m.this).onClick();
        }
      }
    });
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void onClick();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/dialog/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */