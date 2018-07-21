package com.baidu.navisdk.naviresult;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class OnSizeChangedRelativeLayout
  extends RelativeLayout
{
  private OnSizeChangedListener listener;
  
  public OnSizeChangedRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public OnSizeChangedRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public OnSizeChangedListener getListener()
  {
    return this.listener;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.listener != null) {
      this.listener.OnSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setListener(OnSizeChangedListener paramOnSizeChangedListener)
  {
    this.listener = paramOnSizeChangedListener;
  }
  
  public static abstract interface OnSizeChangedListener
  {
    public abstract void OnSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/naviresult/OnSizeChangedRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */