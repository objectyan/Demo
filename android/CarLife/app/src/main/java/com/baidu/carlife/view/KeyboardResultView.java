package com.baidu.carlife.view;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import com.baidu.carlife.core.i;

public class KeyboardResultView
  extends ViewGroup
{
  private BaseAdapter a;
  private c b;
  private a c;
  private SparseArray<Integer> d;
  private int e;
  private b f;
  private int g;
  
  public KeyboardResultView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null, 0);
  }
  
  public KeyboardResultView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public KeyboardResultView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.g = paramContext.getResources().getDimensionPixelSize(2131362037);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.d.clear();
      if (this.f != null) {
        this.f.a(false, false, 0);
      }
      this.e = 0;
      this.d.put(0, Integer.valueOf(0));
    }
    removeAllViews();
    int j;
    if (this.a != null)
    {
      j = this.a.getCount();
      if (j != 0) {}
    }
    else
    {
      return;
    }
    final int i = ((Integer)this.d.get(this.e)).intValue();
    while (i < j)
    {
      final View localView = this.a.getView(i, null, null);
      localView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (KeyboardResultView.a(KeyboardResultView.this) != null) {
            KeyboardResultView.a(KeyboardResultView.this).a(i, localView);
          }
        }
      });
      try
      {
        addView(localView);
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          i.e("KeyboardResultView", localException.toString());
        }
      }
    }
  }
  
  public void a()
  {
    if (this.d.get(this.e + 1) != null)
    {
      this.e += 1;
      a(false);
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          KeyboardResultView.this.requestLayout();
        }
      }, 0L);
    }
  }
  
  public void b()
  {
    if ((this.e > 0) && (this.d.get(this.e - 1) != null))
    {
      this.e -= 1;
      a(false);
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          KeyboardResultView.this.requestLayout();
        }
      }, 0L);
    }
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = getPaddingRight();
    paramInt4 = 0;
    paramInt2 = 0;
    View localView;
    label48:
    int m;
    if (paramInt2 < getChildCount())
    {
      localView = getChildAt(paramInt2);
      if (paramInt2 == 0)
      {
        localView.setSelected(true);
        m = localView.getMeasuredWidth();
        localView.layout(paramInt4, j, paramInt4 + m, j + localView.getMeasuredHeight());
        if (i + paramInt4 + m + k <= paramInt3 - paramInt1) {
          break label188;
        }
        this.d.put(this.e + 1, Integer.valueOf(((Integer)this.d.get(this.e)).intValue() + paramInt2));
      }
    }
    else if (this.f != null)
    {
      if (this.e <= 0) {
        break label207;
      }
      paramBoolean = true;
      label146:
      if (this.d.get(this.e + 1) == null) {
        break label212;
      }
    }
    label188:
    label207:
    label212:
    for (boolean bool = true;; bool = false)
    {
      this.f.a(paramBoolean, bool, paramInt2);
      return;
      localView.setSelected(false);
      break label48;
      paramInt4 += this.g + m;
      paramInt2 += 1;
      break;
      paramBoolean = false;
      break label146;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int m = resolveSize(0, paramInt1);
    int n = getPaddingLeft();
    int i1 = getPaddingRight();
    int i2 = getPaddingTop();
    int i3 = getPaddingBottom();
    int k = 0;
    int i = 0;
    int j = 0;
    for (;;)
    {
      int i4;
      if (j < getChildCount())
      {
        View localView = getChildAt(j);
        ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
        localView.measure(getChildMeasureSpec(paramInt1, 0, localLayoutParams.width), getChildMeasureSpec(paramInt2, 0, localLayoutParams.height));
        i4 = localView.getMeasuredWidth();
        i = localView.getMeasuredHeight();
        if (n + k + i4 + i1 <= m) {}
      }
      else
      {
        setMeasuredDimension(m, 0 + (i + i2 + i3));
        return;
      }
      k += this.g + i4;
      j += 1;
    }
  }
  
  public void setAdapter(BaseAdapter paramBaseAdapter)
  {
    if (this.a == null)
    {
      this.a = paramBaseAdapter;
      if (this.c == null)
      {
        this.c = new a();
        this.a.registerDataSetObserver(this.c);
      }
      if (this.d == null) {
        this.d = new SparseArray();
      }
      a(true);
    }
  }
  
  public void setItemClickListener(c paramc)
  {
    this.b = paramc;
  }
  
  public void setPageCallback(b paramb)
  {
    this.f = paramb;
  }
  
  class a
    extends DataSetObserver
  {
    a() {}
    
    public void onChanged()
    {
      KeyboardResultView.a(KeyboardResultView.this, true);
    }
    
    public void onInvalidated()
    {
      super.onInvalidated();
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt, View paramView);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/KeyboardResultView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */