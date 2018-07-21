package com.baidu.navisdk.ui.cruise;

import com.baidu.navisdk.model.datastruct.LocData;

public abstract interface IBCruiserListener
{
  public static final int PAGE_JUMP_TO_OFFLINE_DOWNLOAD = 2;
  public static final int PAGE_JUMP_TO_WHEN_QUIT = 1;
  
  public abstract void notifyLoacteData(LocData paramLocData);
  
  public abstract void notifyQuitCruiser();
  
  public abstract void notifyStartCruiser();
  
  public abstract void onPageJump(int paramInt, Object paramObject);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/cruise/IBCruiserListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */