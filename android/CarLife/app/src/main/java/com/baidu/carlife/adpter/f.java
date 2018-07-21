package com.baidu.carlife.adpter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.carlife.model.l;
import com.baidu.carlife.view.SkinItemView;
import java.util.List;

public class f
  extends BaseAdapter
{
  private Context a;
  private List<l> b;
  
  public f(Context paramContext, List paramList)
  {
    this.b = paramList;
    this.a = paramContext;
  }
  
  public l a(int paramInt)
  {
    return (l)this.b.get(paramInt);
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    l locall = a(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = new SkinItemView(this.a);
    }
    ((SkinItemView)paramViewGroup).setData(locall);
    return paramViewGroup;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/adpter/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */