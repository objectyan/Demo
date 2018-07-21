package com.baidu.carlife.view.recyclingviewpager;

import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.View;

class a
{
  private View[] a = new View[0];
  private int[] b = new int[0];
  private SparseArray<View>[] c;
  private int d;
  private SparseArray<View> e;
  
  static View a(SparseArray<View> paramSparseArray, int paramInt)
  {
    int j = paramSparseArray.size();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        int k = paramSparseArray.keyAt(i);
        localView = (View)paramSparseArray.get(k);
        if (k == paramInt)
        {
          paramSparseArray.remove(k);
          return localView;
        }
        i += 1;
      }
      paramInt = j - 1;
      View localView = (View)paramSparseArray.valueAt(paramInt);
      paramSparseArray.remove(paramSparseArray.keyAt(paramInt));
      return localView;
    }
    return null;
  }
  
  private void b()
  {
    int m = this.a.length;
    int n = this.d;
    SparseArray[] arrayOfSparseArray = this.c;
    int i = 0;
    while (i < n)
    {
      SparseArray localSparseArray = arrayOfSparseArray[i];
      int i1 = localSparseArray.size();
      int k = 0;
      int j = i1 - 1;
      while (k < i1 - m)
      {
        localSparseArray.remove(localSparseArray.keyAt(j));
        k += 1;
        j -= 1;
      }
      i += 1;
    }
  }
  
  View a(int paramInt1, int paramInt2)
  {
    if (this.d == 1) {
      return a(this.e, paramInt1);
    }
    if ((paramInt2 >= 0) && (paramInt2 < this.c.length)) {
      return a(this.c[paramInt2], paramInt1);
    }
    return null;
  }
  
  void a()
  {
    int i = 1;
    View[] arrayOfView = this.a;
    int[] arrayOfInt = this.b;
    Object localObject1;
    int j;
    label34:
    View localView;
    Object localObject2;
    int k;
    if (this.d > 1)
    {
      localObject1 = this.e;
      j = arrayOfView.length - 1;
      if (j < 0) {
        break label141;
      }
      localView = arrayOfView[j];
      localObject2 = localObject1;
      if (localView != null)
      {
        k = arrayOfInt[j];
        arrayOfView[j] = null;
        arrayOfInt[j] = -1;
        if (b(k)) {
          break label96;
        }
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      j -= 1;
      localObject1 = localObject2;
      break label34;
      i = 0;
      break;
      label96:
      if (i != 0) {
        localObject1 = this.c[k];
      }
      ((SparseArray)localObject1).put(j, localView);
      localObject2 = localObject1;
      if (Build.VERSION.SDK_INT >= 14)
      {
        localView.setAccessibilityDelegate(null);
        localObject2 = localObject1;
      }
    }
    label141:
    b();
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
    }
    SparseArray[] arrayOfSparseArray = new SparseArray[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfSparseArray[i] = new SparseArray();
      i += 1;
    }
    this.d = paramInt;
    this.e = arrayOfSparseArray[0];
    this.c = arrayOfSparseArray;
  }
  
  void a(View paramView, int paramInt1, int paramInt2)
  {
    if (this.d == 1) {
      this.e.put(paramInt1, paramView);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        paramView.setAccessibilityDelegate(null);
      }
      return;
      this.c[paramInt2].put(paramInt1, paramView);
    }
  }
  
  protected boolean b(int paramInt)
  {
    return paramInt >= 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/recyclingviewpager/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */