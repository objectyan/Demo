package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.navi.style.StyleManager;

public class e
  extends BaseDialog
{
  private TextView e;
  private ImageView f;
  private ImageView g;
  private Animation h;
  private b i = null;
  private g j;
  
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  protected View a()
  {
    return LayoutInflater.from(this.c).inflate(2130968714, null);
  }
  
  public void a(com.baidu.carlife.core.screen.e parame)
  {
    super.a(parame);
    this.g.startAnimation(this.h);
  }
  
  public e b(String paramString)
  {
    this.e.setText(paramString);
    return this;
  }
  
  protected void b()
  {
    this.e = ((TextView)findViewById(2131624652));
    this.f = ((ImageView)findViewById(2131624653));
    this.g = ((ImageView)findViewById(2131624239));
    this.e.setTextColor(StyleManager.getDayColor(2131558462));
    this.h = AnimationUtils.loadAnimation(this.c, 2131034118);
    this.f.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (e.a(e.this) != null) {
          e.a(e.this).onClick();
        }
        e.this.d();
      }
    });
  }
  
  public void d()
  {
    super.d();
    this.g.clearAnimation();
  }
  
  public void f()
  {
    if (this.j == null)
    {
      this.j = new g(findViewById(2131624651), 12);
      this.j.d(findViewById(2131624653));
    }
    d.a().c(this.j);
  }
  
  public void g()
  {
    d.a().c();
  }
  
  public void setOnCancelListener(b paramb)
  {
    this.i = paramb;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/dialog/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */