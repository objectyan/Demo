package com.baidu.carlife.view.recyclingviewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public abstract class RecyclingPagerAdapter
  extends PagerAdapter
{
  static final int a = -1;
  private final a b;
  
  public RecyclingPagerAdapter()
  {
    this(new a());
  }
  
  RecyclingPagerAdapter(a parama)
  {
    this.b = parama;
    parama.a(b());
  }
  
  public abstract View a(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public int b()
  {
    return 1;
  }
  
  public int b(int paramInt)
  {
    return 0;
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    paramViewGroup.removeView((View)paramObject);
    int i = b(paramInt);
    if (i != -1) {
      this.b.a((View)paramObject, paramInt, i);
    }
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    int i = b(paramInt);
    View localView = null;
    if (i != -1) {
      localView = this.b.a(paramInt, i);
    }
    localView = a(paramInt, localView, paramViewGroup);
    paramViewGroup.addView(localView);
    return localView;
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void notifyDataSetChanged()
  {
    this.b.a();
    super.notifyDataSetChanged();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/recyclingviewpager/RecyclingPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */