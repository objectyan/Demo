package com.baidu.carlife.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public abstract class h
  extends BaseAdapter
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 0;
  public static final int e = 1;
  protected View f;
  protected Context g;
  private TextView h;
  private View i;
  private int j = 0;
  private boolean k = false;
  private a l;
  
  public h(Context paramContext)
  {
    this.g = paramContext;
    this.f = LayoutInflater.from(this.g).inflate(2130968901, null);
    this.h = ((TextView)this.f.findViewById(2131625538));
    this.i = this.f.findViewById(2131625539);
  }
  
  public int a()
  {
    return this.j;
  }
  
  public abstract View a(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public void a(int paramInt)
  {
    this.j = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.f.setVisibility(8);
      this.i.setVisibility(8);
      this.h.setVisibility(8);
      return;
    case 2: 
      this.f.setVisibility(0);
      this.i.setVisibility(0);
      this.h.setVisibility(8);
      return;
    }
    this.f.setVisibility(0);
    this.i.setVisibility(8);
    this.h.setVisibility(0);
  }
  
  public void a(a parama)
  {
    this.l = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
    notifyDataSetChanged();
  }
  
  public boolean b()
  {
    return this.k;
  }
  
  public void c()
  {
    if (this.l != null) {
      this.l.a();
    }
  }
  
  public abstract int d();
  
  public int getCount()
  {
    if (this.k) {
      return d() + 1;
    }
    return d();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (!this.k) {}
    while (paramInt < getCount() - 1) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      return paramView;
    case 1: 
      return this.f;
    }
    return a(paramInt, paramView, paramViewGroup);
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/adpter/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */