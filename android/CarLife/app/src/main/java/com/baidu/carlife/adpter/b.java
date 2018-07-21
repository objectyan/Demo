package com.baidu.carlife.adpter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class b
  extends BaseAdapter
{
  private String[] a;
  private Context b;
  
  public b(Context paramContext)
  {
    this.b = paramContext;
    this.a = this.b.getResources().getStringArray(2131230723);
  }
  
  public int getCount()
  {
    return this.a.length;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(this.b).inflate(2130968720, null);
      paramView = new a(null);
      paramView.a = ((TextView)paramViewGroup.findViewById(2131624662));
      paramViewGroup.setTag(paramView);
    }
    ((a)paramViewGroup.getTag()).a.setText(this.a[paramInt]);
    return paramViewGroup;
  }
  
  private static class a
  {
    TextView a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/adpter/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */