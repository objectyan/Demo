package com.baidu.mapframework.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RouteErrorView
  extends RelativeLayout
{
  private View a;
  private TextView b;
  private View c;
  
  public RouteErrorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2130968998, this);
    this.a = findViewById(2131626019);
    this.b = ((TextView)findViewById(2131626020));
    this.c = findViewById(2131626021);
  }
  
  public void setRepeatButtonListener(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
  }
  
  public void setText(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void setmRepeatButtonGone()
  {
    if (this.c != null) {
      this.c.setVisibility(8);
    }
  }
  
  public void setmRepeatButtonVisible()
  {
    if (this.c != null) {
      this.c.setVisibility(0);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/widget/RouteErrorView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */