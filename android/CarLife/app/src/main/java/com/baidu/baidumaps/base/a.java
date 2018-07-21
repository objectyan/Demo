package com.baidu.baidumaps.base;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.widget.ListAdapter;

public abstract class a
  implements ListAdapter
{
  private final DataSetObservable a = new DataSetObservable();
  
  public void a()
  {
    this.a.notifyChanged();
  }
  
  public boolean areAllItemsEnabled()
  {
    return true;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isEmpty()
  {
    return getCount() == 0;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return true;
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.a.registerObserver(paramDataSetObserver);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.a.unregisterObserver(paramDataSetObserver);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidumaps/base/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */