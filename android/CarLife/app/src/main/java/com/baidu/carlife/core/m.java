package com.baidu.carlife.core;

import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import com.baidu.carlife.core.screen.presentation.i;

public class m
{
  private static final String a = "DisplayUtils";
  private static m b = new m();
  
  public static m a()
  {
    return b;
  }
  
  private VirtualDisplay b(i parami, String paramString)
  {
    if (parami.e() == 0) {
      parami.d(9);
    }
    return ((DisplayManager)a.a().getSystemService("display")).createVirtualDisplay(paramString, parami.a(), parami.b(), parami.c(), parami.d(), parami.e());
  }
  
  public VirtualDisplay a(i parami, String paramString)
  {
    return b(parami, paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */