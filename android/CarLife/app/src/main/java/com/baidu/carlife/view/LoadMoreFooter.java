package com.baidu.carlife.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LoadMoreFooter
  extends RelativeLayout
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  private TextView d;
  private View e;
  private int f = 0;
  
  public LoadMoreFooter(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public LoadMoreFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LoadMoreFooter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130968902, this, true);
    this.d = ((TextView)findViewById(2131625538));
    this.e = findViewById(2131625539);
    setVisibility(8);
  }
  
  public boolean a()
  {
    if (this.f == 2) {
      return false;
    }
    setStatus(2);
    return true;
  }
  
  public void b()
  {
    if (this.f == 1) {
      return;
    }
    setStatus(1);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    switch (this.f)
    {
    default: 
      this.f = 1;
      setVisibility(0);
      this.e.setVisibility(8);
      this.d.setVisibility(0);
      return;
    }
    setVisibility(8);
    this.e.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  public void setStatus(int paramInt)
  {
    this.f = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      setVisibility(8);
      this.e.setVisibility(8);
      this.d.setVisibility(8);
      return;
    case 2: 
      setVisibility(0);
      this.e.setVisibility(0);
      this.d.setVisibility(8);
      return;
    }
    setVisibility(0);
    this.e.setVisibility(8);
    this.d.setVisibility(0);
  }
  
  public void setTextContent(String paramString)
  {
    this.d.setText(paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/LoadMoreFooter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */