package com.baidu.che.codriver.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;

public class ExpandableLayout
  extends ViewGroup
{
  private int a = 10;
  private a b;
  private int c;
  private int d;
  private View e;
  private AdapterView.OnItemClickListener f;
  
  public ExpandableLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ExpandableLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ExpandableLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    this.d = Math.min(this.c, this.a);
  }
  
  public void a(View paramView)
  {
    this.e = paramView;
    addView(this.e, 0);
    invalidate();
    requestLayout();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < getChildCount())
    {
      View localView = getChildAt(paramInt1);
      localView.layout(0, paramInt2, paramInt3, localView.getMeasuredHeight() + paramInt2);
      paramInt2 += localView.getMeasuredHeight();
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    measureChildren(paramInt1, paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < getChildCount())
    {
      paramInt2 += getChildAt(paramInt1).getMeasuredHeight();
      paramInt1 += 1;
    }
    setMeasuredDimension(i, paramInt2);
  }
  
  public void setAdapter(a parama)
  {
    this.b = parama;
    this.c = this.b.a();
    removeAllViews();
    a();
    int i = 0;
    while (i < this.d)
    {
      addView(this.b.a(i));
      i += 1;
    }
    invalidate();
    requestLayout();
  }
  
  public void setMaxShowNum(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract int a();
    
    public abstract View a(int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/widget/ExpandableLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */