package com.baidu.carlife.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.model.n;
import java.util.ArrayList;
import java.util.List;

public class s
  extends BaseAdapter
{
  private Context a;
  private List b = new ArrayList();
  private a c;
  
  public s(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == a.a.ordinal()) {
      return 0;
    }
    if (paramInt == a.b.ordinal()) {
      return 2;
    }
    return -1;
  }
  
  private boolean b(int paramInt)
  {
    n localn1 = (n)getItem(paramInt - 1);
    n localn2 = (n)getItem(paramInt);
    if (localn1 == null) {}
    while (!localn1.a.equals(localn2.a)) {
      return false;
    }
    return true;
  }
  
  public void a(List paramList, a parama)
  {
    this.c = parama;
    this.b.clear();
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.b.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    try
    {
      Object localObject = this.b.get(paramInt);
      return localObject;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.c.ordinal();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    b localb = new b(null);
    View localView = paramView;
    if (paramView == null) {}
    switch (1.a[this.c.ordinal()])
    {
    default: 
      paramView.setTag(localb);
      localView = paramView;
      paramView = (b)localView.getTag();
      switch (1.a[this.c.ordinal()])
      {
      }
      break;
    }
    do
    {
      return localView;
      paramView = LayoutInflater.from(this.a).inflate(2130969063, paramViewGroup, false);
      localb.a = ((TextView)paramView.findViewById(2131626187));
      localb.b = ((TextView)paramView.findViewById(2131626188));
      break;
      paramView = LayoutInflater.from(this.a).inflate(2130969064, paramViewGroup, false);
      localb.a = ((TextView)paramView.findViewById(2131624906));
      localb.b = ((TextView)paramView.findViewById(2131624187));
      break;
      paramViewGroup = (n)getItem(paramInt);
    } while (paramViewGroup == null);
    if (b(paramInt)) {
      paramView.a("");
    }
    for (;;)
    {
      paramView.b(paramViewGroup.b);
      return localView;
      paramView.a(paramViewGroup.a);
    }
    paramViewGroup = (MusicSongModel)getItem(paramInt);
    paramView.a(paramViewGroup.b);
    paramView.b(paramViewGroup.f);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return a.values().length;
  }
  
  public static enum a
  {
    private a() {}
  }
  
  private static class b
  {
    TextView a;
    TextView b;
    
    public void a(String paramString)
    {
      this.a.setText(paramString);
    }
    
    public void b(String paramString)
    {
      this.b.setText(paramString);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/adpter/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */