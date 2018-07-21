package com.baidu.carlife.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class b
  extends BaseAdapter
{
  private LayoutInflater a;
  private List<String> b;
  
  public b(Context paramContext)
  {
    this.a = LayoutInflater.from(paramContext);
  }
  
  public String a(int paramInt)
  {
    if (this.b == null) {
      return null;
    }
    return (String)this.b.get(paramInt);
  }
  
  public void a(List<String> paramList)
  {
    this.b = paramList;
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
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
      localView = this.a.inflate(2130968877, paramViewGroup, false);
      localView.setFocusable(true);
    }
    paramView = (TextView)localView;
    paramViewGroup = a(paramInt);
    if (!TextUtils.isEmpty(paramViewGroup)) {
      paramView.setText(paramViewGroup);
    }
    return paramView;
  }
  
  static class a
  {
    TextView a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */