package com.baidu.navisdk.util.common;

public class RouteGuideThread
  extends CommonHandlerThread
{
  private static final String TAG = RouteGuideThread.class.getSimpleName();
  private static RouteGuideThread sInstance = null;
  
  public static RouteGuideThread getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new RouteGuideThread();
      }
      return sInstance;
    }
    finally {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/RouteGuideThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */