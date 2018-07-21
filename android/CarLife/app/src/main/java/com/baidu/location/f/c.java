package com.baidu.location.f;

public final class c
{
  public static String a(int paramInt)
  {
    if (f.j()) {
      return "WIFI";
    }
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
      return "2G";
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
      return "3G";
    }
    return "4G";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */