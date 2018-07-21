package com.baidu.carlife.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.core.d;
import com.baidu.carlife.core.e;
import com.baidu.carlife.logic.music.h;
import com.baidu.carlife.util.r;
import com.baidu.carlife.view.MultiImageView;
import java.util.ArrayList;
import java.util.List;

public class i
  extends BaseAdapter
{
  protected static int a = 4;
  private Context b = BaiduNaviApplication.getInstance().getApplicationContext();
  private List<com.baidu.carlife.model.i> c = new ArrayList();
  
  public void a(List<com.baidu.carlife.model.i> paramList)
  {
    this.c.clear();
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.c.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    try
    {
      Object localObject = this.c.get(paramInt);
      return localObject;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}
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
      paramViewGroup = LayoutInflater.from(this.b).inflate(2130968932, null);
      paramView = new a(null);
      paramView.b = ((TextView)paramViewGroup.findViewById(2131625652));
      paramView.a = ((MultiImageView)paramViewGroup.findViewById(2131625651));
      paramViewGroup.setTag(paramView);
    }
    paramView = (a)paramViewGroup.getTag();
    try
    {
      com.baidu.carlife.model.i locali = (com.baidu.carlife.model.i)this.c.get(paramInt);
      paramView.a(locali.a);
      if (locali.d > 0) {
        paramView.b(locali.d);
      }
      while (locali.c.equals(h.b().j()))
      {
        paramView.a(r.a(2131558648));
        return paramViewGroup;
        paramView.b(locali.b);
      }
      paramView.a(r.a(2131558702));
      return paramViewGroup;
    }
    catch (IndexOutOfBoundsException paramView) {}
    return null;
  }
  
  private static class a
  {
    public MultiImageView a;
    public TextView b;
    
    public void a(int paramInt)
    {
      this.b.setTextColor(paramInt);
    }
    
    public void a(String paramString)
    {
      this.b.setText(paramString);
    }
    
    public void b(int paramInt)
    {
      int i = e.a().n();
      i = d.a().c(100) - i / i.a;
      ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      this.a.setLayoutParams(localLayoutParams);
      this.a.setDefaultDrawable(r.b(paramInt));
      this.a.setImageUrl(null);
    }
    
    public void b(String paramString)
    {
      int i = e.a().n();
      i = d.a().c(100) - i / i.a;
      ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      this.a.setLayoutParams(localLayoutParams);
      this.a.setDefaultDrawable(r.b(2130838954));
      this.a.setImageUrl(paramString);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/adpter/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */