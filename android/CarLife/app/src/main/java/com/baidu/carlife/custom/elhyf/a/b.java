package com.baidu.carlife.custom.elhyf.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.view.dialog.BaseDialog;

public class b
  extends BaseDialog
{
  private Context e;
  private TextView f;
  private RelativeLayout g;
  private RelativeLayout h;
  private a i;
  private b j;
  private c k;
  
  public b(Context paramContext)
  {
    super(paramContext);
    this.e = paramContext;
  }
  
  protected View a()
  {
    return View.inflate(getContext(), 2130969014, null);
  }
  
  public b a(a parama)
  {
    this.i = parama;
    return this;
  }
  
  public b a(b paramb)
  {
    this.j = paramb;
    return this;
  }
  
  public b a(c paramc)
  {
    this.k = paramc;
    return this;
  }
  
  protected void b()
  {
    this.f = ((TextView)findViewById(2131626056));
    this.g = ((RelativeLayout)findViewById(2131626050));
    this.h = ((RelativeLayout)findViewById(2131626053));
    this.g.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (b.a(b.this) != null) {
          b.a(b.this).a();
        }
        b.this.d();
      }
    });
    this.h.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (b.b(b.this) != null) {
          b.b(b.this).a();
        }
        b.this.d();
      }
    });
    this.f.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (b.c(b.this) != null) {
          b.c(b.this).a();
        }
        b.this.d();
      }
    });
  }
  
  public void f() {}
  
  public static abstract interface a
  {
    public abstract void a();
  }
  
  public static abstract interface b
  {
    public abstract void a();
  }
  
  public static abstract interface c
  {
    public abstract void a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/custom/elhyf/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */