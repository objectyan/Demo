package com.baidu.carlife.view.pinnedheaderlistview;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class b
  extends BaseAdapter
  implements PinnedHeaderListView.b
{
  private static int a = 0;
  private static int b = 0;
  private SparseArray<Integer> c = new SparseArray();
  private SparseArray<Integer> d = new SparseArray();
  private SparseArray<Integer> e = new SparseArray();
  private int f = -1;
  private int g = -1;
  
  private int a(int paramInt)
  {
    Integer localInteger = (Integer)this.e.get(paramInt);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    int i = b(paramInt);
    this.e.put(paramInt, Integer.valueOf(i));
    return i;
  }
  
  private int d()
  {
    if (this.g >= 0) {
      return this.g;
    }
    this.g = a();
    return this.g;
  }
  
  public abstract int a();
  
  public abstract View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup);
  
  public abstract View a(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public int b()
  {
    return 1;
  }
  
  public abstract int b(int paramInt);
  
  public abstract long b(int paramInt1, int paramInt2);
  
  public int c()
  {
    return 1;
  }
  
  public abstract Object c(int paramInt1, int paramInt2);
  
  public final boolean c(int paramInt)
  {
    boolean bool2 = false;
    int j = 0;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < d())
      {
        if (paramInt != j) {
          break label30;
        }
        bool1 = true;
      }
      label30:
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramInt < j);
      j += a(i) + 1;
      i += 1;
    }
  }
  
  public final int d(int paramInt)
  {
    Integer localInteger = (Integer)this.d.get(paramInt);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    int j = 0;
    int i = 0;
    while (i < d())
    {
      int k = j + a(i) + 1;
      if ((paramInt >= j) && (paramInt < k))
      {
        this.d.put(paramInt, Integer.valueOf(i));
        return i;
      }
      j = k;
      i += 1;
    }
    return 0;
  }
  
  public int d(int paramInt1, int paramInt2)
  {
    return b;
  }
  
  public int e(int paramInt)
  {
    return a;
  }
  
  public int f(int paramInt)
  {
    Integer localInteger = (Integer)this.c.get(paramInt);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    int j = 0;
    int i = 0;
    while (i < d())
    {
      int k = j + a(i) + 1;
      if ((paramInt >= j) && (paramInt < k))
      {
        i = paramInt - j - 1;
        this.c.put(paramInt, Integer.valueOf(i));
        return i;
      }
      j = k;
      i += 1;
    }
    return 0;
  }
  
  public final int getCount()
  {
    if (this.f >= 0) {
      return this.f;
    }
    int j = 0;
    int i = 0;
    while (i < d())
    {
      j = j + a(i) + 1;
      i += 1;
    }
    this.f = j;
    return j;
  }
  
  public final Object getItem(int paramInt)
  {
    return c(d(paramInt), f(paramInt));
  }
  
  public final long getItemId(int paramInt)
  {
    return b(d(paramInt), f(paramInt));
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (c(paramInt)) {
      return b() + e(d(paramInt));
    }
    return d(d(paramInt), f(paramInt));
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (c(paramInt)) {
      return a(d(paramInt), paramView, paramViewGroup);
    }
    return a(d(paramInt), f(paramInt), paramView, paramViewGroup);
  }
  
  public final int getViewTypeCount()
  {
    return b() + c();
  }
  
  public void notifyDataSetChanged()
  {
    this.d.clear();
    this.c.clear();
    this.e.clear();
    this.f = -1;
    this.g = -1;
    super.notifyDataSetChanged();
  }
  
  public void notifyDataSetInvalidated()
  {
    this.d.clear();
    this.c.clear();
    this.e.clear();
    this.f = -1;
    this.g = -1;
    super.notifyDataSetInvalidated();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/pinnedheaderlistview/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */