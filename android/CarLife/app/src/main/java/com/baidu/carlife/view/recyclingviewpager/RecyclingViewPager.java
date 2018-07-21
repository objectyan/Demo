package com.baidu.carlife.view.recyclingviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.baidu.carlife.core.d;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class RecyclingViewPager
  extends ViewPager
{
  private a a;
  private HashMap<View, Integer> b = new LinkedHashMap();
  private boolean c = false;
  private float d;
  private float e;
  private boolean f = true;
  private boolean g = false;
  
  public RecyclingViewPager(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public RecyclingViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  private int a(float paramFloat)
  {
    int i = b(this.d);
    int j = b(paramFloat);
    this.e = (paramFloat - this.d);
    if (i != j) {
      return getCurrentItem() + i - j;
    }
    if (Math.abs(this.e) <= 10.0F)
    {
      if ((j == 0) && (this.a != null)) {
        this.a.a(this, getCurrentItem());
      }
      return getCurrentItem() + i;
    }
    return getCurrentItem();
  }
  
  private int b(float paramFloat)
  {
    if (d.m()) {
      return c(paramFloat);
    }
    float f1 = getLeft();
    float f2 = getRight();
    float f3 = f2 - f1;
    if (paramFloat < f1 - 2.0F * f3) {
      return -3;
    }
    if (paramFloat < f1 - 1.15D * f3) {
      return -2;
    }
    if (paramFloat < f1 - 0.3D * f3) {
      return -1;
    }
    if (paramFloat < f2 + 0.3D * f3) {
      return 0;
    }
    if (paramFloat < f2 + 1.15D * f3) {
      return 1;
    }
    if (paramFloat < 2.0F * f3 + f2) {
      return 2;
    }
    return 3;
  }
  
  private int c(float paramFloat)
  {
    float f1 = getLeft();
    float f2 = getRight();
    float f3 = f2 - f1;
    if (paramFloat < f1 - 3.0F * f3) {
      return -4;
    }
    if (paramFloat < f1 - 2.1D * f3) {
      return -3;
    }
    if (paramFloat < f1 - 1.2D * f3) {
      return -2;
    }
    if (paramFloat < f1 - 0.3D * f3) {
      return -1;
    }
    if (paramFloat < f2 + 0.3D * f3) {
      return 0;
    }
    if (paramFloat < f2 + 1.2D * f3) {
      return 1;
    }
    if (paramFloat < f2 + 2.1D * f3) {
      return 2;
    }
    if (paramFloat < 3.0F * f3 + f2) {
      return 3;
    }
    return 4;
  }
  
  private void c()
  {
    setPageTransformer(false, new ScalePageTransformer());
    setSpeedScroller(300);
    setChildrenDrawingOrderEnabled(true);
    this.g = false;
  }
  
  private void setSpeedScroller(int paramInt)
  {
    try
    {
      Field localField = ViewPager.class.getDeclaredField("mScroller");
      localField.setAccessible(true);
      b localb = new b(getContext(), new AccelerateInterpolator());
      localField.set(this, localb);
      localb.a(paramInt);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
  }
  
  public View a(int paramInt)
  {
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (((Integer)this.b.get(localView)).intValue() == paramInt) {
        return localView;
      }
    }
    return null;
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    this.c = true;
    return dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.d = paramMotionEvent.getX();
      if (!this.c) {
        this.d += getLeft();
      }
      this.c = false;
    }
    int i;
    do
    {
      do
      {
        return super.dispatchTouchEvent(paramMotionEvent);
      } while (paramMotionEvent.getAction() != 1);
      float f2 = paramMotionEvent.getX();
      float f1 = f2;
      if (!this.c) {
        f1 = f2 + getLeft();
      }
      this.c = false;
      i = a(f1);
    } while (i < 0);
    if ((i == getCurrentItem()) && (this.e != 0.0F))
    {
      this.f = false;
      setCurrentItem(i - 1);
    }
    this.g = true;
    setCurrentItem(i);
    return true;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = getCurrentItem();
    if (i < 0) {}
    do
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1)
      {
        paramInt1 = i;
        if (i > paramInt2) {
          paramInt1 = paramInt2;
        }
        return paramInt1;
      }
    } while (paramInt2 != i);
    return paramInt1 - 1;
  }
  
  public HashMap<View, Integer> getChildrenViews()
  {
    return this.b;
  }
  
  public void setChildrenView(int paramInt, View paramView)
  {
    this.b.put(paramView, Integer.valueOf(paramInt));
  }
  
  public void setOnItemClickListener(a parama)
  {
    this.a = parama;
  }
  
  public void setSelectEnable(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setTouch(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void a(RecyclingViewPager paramRecyclingViewPager, int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/recyclingviewpager/RecyclingViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */