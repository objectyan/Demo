package com.baidu.carlife.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class r
  extends BaseAdapter
{
  public static final int a = -1;
  private LayoutInflater b;
  private String[] c;
  private int d = -1;
  
  public r(Context paramContext, String[] paramArrayOfString)
  {
    this.b = LayoutInflater.from(paramContext);
    this.c = paramArrayOfString;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public String b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.c.length)) {
      return "";
    }
    return this.c[paramInt];
  }
  
  public int getCount()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.length;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.b.inflate(2130968872, paramViewGroup, false);
      paramView = new a(null);
      paramView.a = ((TextView)localView.findViewById(2131625357));
      paramView.b = ((ImageView)localView.findViewById(2131625389));
      localView.setTag(paramView);
    }
    paramView = (a)localView.getTag();
    paramView.a.setText(b(paramInt));
    if (this.d == paramInt)
    {
      paramView.b.setVisibility(0);
      paramView.a.setSelected(true);
      return localView;
    }
    paramView.b.setVisibility(8);
    paramView.a.setSelected(false);
    return localView;
  }
  
  private class a
  {
    TextView a;
    ImageView b;
    
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/adpter/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */