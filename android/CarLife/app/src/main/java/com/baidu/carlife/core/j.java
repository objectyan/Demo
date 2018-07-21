package com.baidu.carlife.core;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class j
  extends Handler
  implements h
{
  private ArrayList<Integer> mInterests = new ArrayList();
  
  public j()
  {
    careAbout();
  }
  
  public j(Looper paramLooper)
  {
    super(paramLooper);
    careAbout();
  }
  
  public void addMsg(int paramInt)
  {
    Iterator localIterator = this.mInterests.iterator();
    while (localIterator.hasNext()) {
      if (((Integer)localIterator.next()).intValue() == paramInt) {
        return;
      }
    }
    this.mInterests.add(Integer.valueOf(paramInt));
  }
  
  public abstract void careAbout();
  
  public boolean isAdded(int paramInt)
  {
    if (this.mInterests == null) {
      return false;
    }
    return this.mInterests.contains(Integer.valueOf(paramInt));
  }
  
  public void removeMsg(int paramInt)
  {
    Iterator localIterator = this.mInterests.iterator();
    while (localIterator.hasNext()) {
      if (((Integer)localIterator.next()).intValue() == paramInt) {
        localIterator.remove();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */