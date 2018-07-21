package com.baidu.carlife.view.pinnedheaderlistview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class PinnedHeaderListView
  extends ListView
  implements AbsListView.OnScrollListener
{
  private AbsListView.OnScrollListener a;
  private b b;
  private View c;
  private int d = 0;
  private float e;
  private boolean f = true;
  private int g = 0;
  private int h;
  private int i;
  private int j = 0;
  private int k = 0;
  
  public PinnedHeaderListView(Context paramContext)
  {
    super(paramContext);
    super.setOnScrollListener(this);
  }
  
  public PinnedHeaderListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOnScrollListener(this);
  }
  
  public PinnedHeaderListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setOnScrollListener(this);
  }
  
  private View a(int paramInt, View paramView)
  {
    if ((paramInt != this.g) || (paramView == null)) {}
    for (int m = 1;; m = 0)
    {
      paramView = this.b.a(paramInt, paramView, this);
      if (m != 0)
      {
        a(paramView);
        this.g = paramInt;
      }
      return paramView;
    }
  }
  
  private void a(View paramView)
  {
    int n;
    ViewGroup.LayoutParams localLayoutParams;
    if (paramView.isLayoutRequested())
    {
      n = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - this.j - this.k, this.h);
      localLayoutParams = paramView.getLayoutParams();
      if ((localLayoutParams == null) || (localLayoutParams.height <= 0)) {
        break label80;
      }
    }
    label80:
    for (int m = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);; m = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(n, m);
      paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
      return;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.b == null) || (!this.f) || (this.c == null)) {
      return;
    }
    int m = paramCanvas.save();
    paramCanvas.translate(this.j, this.e);
    paramCanvas.clipRect(0, 0, getWidth(), this.c.getMeasuredHeight());
    this.c.draw(paramCanvas);
    paramCanvas.restoreToCount(m);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.h = View.MeasureSpec.getMode(paramInt1);
    this.i = View.MeasureSpec.getMode(paramInt2);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = null;
    if (this.a != null) {
      this.a.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if ((this.b == null) || (this.b.getCount() == 0) || (!this.f) || (paramInt1 < getHeaderViewsCount()))
    {
      this.c = null;
      this.e = 0.0F;
      paramInt3 = paramInt1;
    }
    while (paramInt3 < paramInt1 + paramInt2)
    {
      paramAbsListView = getChildAt(paramInt3);
      if (paramAbsListView != null) {
        paramAbsListView.setVisibility(0);
      }
      paramInt3 += 1;
      continue;
      paramInt3 = paramInt1 - getHeaderViewsCount();
      paramInt1 = this.b.d(paramInt3);
      int m = this.b.e(paramInt1);
      label180:
      float f1;
      if (this.d != m)
      {
        paramAbsListView = (AbsListView)localObject;
        this.c = a(paramInt1, paramAbsListView);
        a(this.c);
        this.d = m;
        this.e = 0.0F;
        paramInt1 = paramInt3;
        if (paramInt1 >= paramInt3 + paramInt2) {
          break label289;
        }
        if (this.b.c(paramInt1))
        {
          paramAbsListView = getChildAt(paramInt1 - paramInt3);
          f1 = paramAbsListView.getTop();
          float f2 = this.c.getMeasuredHeight();
          paramAbsListView.setVisibility(0);
          if ((f2 < f1) || (f1 <= 0.0F)) {
            break label274;
          }
          this.e = (f1 - paramAbsListView.getHeight());
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        break label180;
        paramAbsListView = this.c;
        break;
        label274:
        if (f1 <= 0.0F) {
          paramAbsListView.setVisibility(4);
        }
      }
      label289:
      invalidate();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.a != null) {
      this.a.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    this.c = null;
    this.b = ((b)paramListAdapter);
    super.setAdapter(paramListAdapter);
  }
  
  public void setHorizontalMargin(int paramInt1, int paramInt2)
  {
    this.j = paramInt1;
    this.k = paramInt2;
  }
  
  public void setOnItemClickListener(a parama)
  {
    super.setOnItemClickListener(parama);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.a = paramOnScrollListener;
  }
  
  public void setPinHeaders(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public static abstract class a
    implements AdapterView.OnItemClickListener
  {
    public abstract void a(AdapterView<?> paramAdapterView, View paramView, int paramInt1, int paramInt2, long paramLong);
    
    public abstract void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong);
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      if (paramAdapterView.getAdapter().getClass().equals(HeaderViewListAdapter.class)) {}
      int i;
      for (b localb = (b)((HeaderViewListAdapter)paramAdapterView.getAdapter()).getWrappedAdapter();; localb = (b)paramAdapterView.getAdapter())
      {
        i = localb.d(paramInt);
        paramInt = localb.f(paramInt);
        if (paramInt != -1) {
          break;
        }
        a(paramAdapterView, paramView, i, paramLong);
        return;
      }
      a(paramAdapterView, paramView, i, paramInt, paramLong);
    }
  }
  
  public static abstract interface b
  {
    public abstract View a(int paramInt, View paramView, ViewGroup paramViewGroup);
    
    public abstract boolean c(int paramInt);
    
    public abstract int d(int paramInt);
    
    public abstract int e(int paramInt);
    
    public abstract int getCount();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/pinnedheaderlistview/PinnedHeaderListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */