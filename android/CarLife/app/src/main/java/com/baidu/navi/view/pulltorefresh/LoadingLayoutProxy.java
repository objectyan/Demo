package com.baidu.navi.view.pulltorefresh;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.baidu.navi.view.pulltorefresh.internal.LoadingLayout;
import java.util.HashSet;
import java.util.Iterator;

public class LoadingLayoutProxy
  implements ILoadingLayout
{
  private final HashSet<LoadingLayout> mLoadingLayouts = new HashSet();
  
  public void addLayout(LoadingLayout paramLoadingLayout)
  {
    if (paramLoadingLayout != null) {
      this.mLoadingLayouts.add(paramLoadingLayout);
    }
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.mLoadingLayouts.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setLastUpdatedLabel(paramCharSequence);
    }
  }
  
  public void setLoadingDrawable(Drawable paramDrawable)
  {
    Iterator localIterator = this.mLoadingLayouts.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setLoadingDrawable(paramDrawable);
    }
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.mLoadingLayouts.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setPullLabel(paramCharSequence);
    }
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.mLoadingLayouts.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setRefreshingLabel(paramCharSequence);
    }
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.mLoadingLayouts.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setReleaseLabel(paramCharSequence);
    }
  }
  
  public void setTextTypeface(Typeface paramTypeface)
  {
    Iterator localIterator = this.mLoadingLayouts.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setTextTypeface(paramTypeface);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/pulltorefresh/LoadingLayoutProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */