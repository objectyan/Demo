package com.indooratlas.android.sdk._internal;

import android.os.Build;
import android.os.Build.VERSION;
import java.util.Iterator;
import java.util.LinkedList;

public class ar
{
  private static ar a = null;
  private LinkedList<as> b = new LinkedList();
  
  private ar()
  {
    this.b.add(new a((byte)0));
  }
  
  public static ar a()
  {
    try
    {
      if (a == null) {
        a = new ar();
      }
      return a;
    }
    finally {}
  }
  
  public final int a(b paramb)
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      if (localIterator.hasNext())
      {
        int i = ((as)localIterator.next()).a(paramb);
        return i;
      }
      return -1;
    }
  }
  
  public final String a(c paramc)
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      if (localIterator.hasNext())
      {
        paramc = ((as)localIterator.next()).a(paramc);
        return paramc;
      }
      return "unknown";
    }
  }
  
  static final class a
    implements as
  {
    public final int a(ar.b paramb)
    {
      switch (ar.1.b[paramb.ordinal()])
      {
      default: 
        throw new RuntimeException("IAEnvironmentManager broken " + paramb);
      }
      return Build.VERSION.SDK_INT;
    }
    
    public final String a(ar.c paramc)
    {
      switch (ar.1.a[paramc.ordinal()])
      {
      default: 
        throw new RuntimeException("IAEnvironmentManager broken: " + paramc);
      case 1: 
        return Build.ID;
      case 2: 
        return Build.DISPLAY;
      case 3: 
        return Build.PRODUCT;
      case 4: 
        return Build.DEVICE;
      case 5: 
        return Build.BOARD;
      case 6: 
        return Build.MANUFACTURER;
      case 7: 
        return Build.BRAND;
      case 8: 
        return Build.MODEL;
      case 9: 
        return Build.BOOTLOADER;
      case 10: 
        return Build.HARDWARE;
      case 11: 
        return Build.SERIAL;
      case 12: 
        return Build.VERSION.INCREMENTAL;
      case 13: 
        return Build.VERSION.RELEASE;
      case 14: 
        if (Build.VERSION.SDK_INT < 23) {
          return "unknown";
        }
        return Build.VERSION.BASE_OS;
      }
      if (Build.VERSION.SDK_INT < 23) {
        return "unknown";
      }
      return Build.VERSION.SECURITY_PATCH;
    }
  }
  
  public static enum b
  {
    private b() {}
  }
  
  public static enum c
  {
    private c() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */