package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.baidu.navisdk.ui.util.BNStyleManager;

@Deprecated
public class o
  extends m
{
  private TextView e;
  
  public o(Context paramContext)
  {
    super(paramContext);
  }
  
  protected View a()
  {
    return LayoutInflater.from(this.c).inflate(2130968959, null);
  }
  
  protected void b()
  {
    this.e = ((TextView)findViewById(2131624273));
    this.e.setTextColor(BNStyleManager.getColor(1711800514));
  }
  
  public o c(View paramView)
  {
    super.a(paramView);
    return this;
  }
  
  public o c(m.a parama)
  {
    super.a(parama);
    return this;
  }
  
  public o c(boolean paramBoolean)
  {
    super.a(paramBoolean);
    return this;
  }
  
  public o d(m.a parama)
  {
    super.b(parama);
    return this;
  }
  
  public o d(boolean paramBoolean)
  {
    super.b(paramBoolean);
    return this;
  }
  
  public o f(int paramInt)
  {
    return f(getContext().getString(paramInt));
  }
  
  public o f(String paramString)
  {
    this.e.setText(paramString, TextView.BufferType.SPANNABLE);
    return this;
  }
  
  public o g(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.e.getLayoutParams();
    localLayoutParams.width = paramInt;
    this.e.setLayoutParams(localLayoutParams);
    return this;
  }
  
  public o g(String paramString)
  {
    super.b(paramString);
    return this;
  }
  
  public o h(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.e.getLayoutParams();
    localLayoutParams.height = paramInt;
    this.e.setLayoutParams(localLayoutParams);
    return this;
  }
  
  public o h(String paramString)
  {
    super.c(paramString);
    return this;
  }
  
  public o i(int paramInt)
  {
    super.a(paramInt);
    return this;
  }
  
  public o i(String paramString)
  {
    super.d(paramString);
    return this;
  }
  
  public o j(int paramInt)
  {
    super.b(paramInt);
    return this;
  }
  
  public o k(int paramInt)
  {
    super.c(paramInt);
    return this;
  }
  
  public o l()
  {
    super.i();
    return this;
  }
  
  public o l(int paramInt)
  {
    super.d(paramInt);
    return this;
  }
  
  public o m()
  {
    super.j();
    return this;
  }
  
  public o m(int paramInt)
  {
    super.e(paramInt);
    return this;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/dialog/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */