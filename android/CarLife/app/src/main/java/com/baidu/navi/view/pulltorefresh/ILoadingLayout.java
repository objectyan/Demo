package com.baidu.navi.view.pulltorefresh;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

public abstract interface ILoadingLayout
{
  public abstract void setLastUpdatedLabel(CharSequence paramCharSequence);
  
  public abstract void setLoadingDrawable(Drawable paramDrawable);
  
  public abstract void setPullLabel(CharSequence paramCharSequence);
  
  public abstract void setRefreshingLabel(CharSequence paramCharSequence);
  
  public abstract void setReleaseLabel(CharSequence paramCharSequence);
  
  public abstract void setTextTypeface(Typeface paramTypeface);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/pulltorefresh/ILoadingLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */