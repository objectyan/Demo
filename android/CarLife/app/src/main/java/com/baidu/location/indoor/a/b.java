package com.baidu.location.indoor.a;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;

public class b
{
  private static volatile b a;
  private final c b = new c(this);
  private final BDLocationListener c;
  private final BDLocationListener d;
  
  private b(BDLocationListener paramBDLocationListener)
  {
    this.c = paramBDLocationListener;
    this.d = new BDLocationListener()
    {
      public void onConnectHotSpotMessage(String paramAnonymousString, int paramAnonymousInt) {}
      
      public void onReceiveLocation(BDLocation paramAnonymousBDLocation)
      {
        b.a(b.this).b(paramAnonymousBDLocation);
      }
    };
  }
  
  public static b a(BDLocationListener paramBDLocationListener)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new b(paramBDLocationListener);
      }
      return a;
    }
    finally {}
  }
  
  public BDLocation a()
  {
    return this.b.b();
  }
  
  void a(BDLocation paramBDLocation)
  {
    this.c.onReceiveLocation(paramBDLocation);
  }
  
  public BDLocationListener b()
  {
    return this.d;
  }
  
  public void c()
  {
    this.b.a();
  }
  
  public void d()
  {
    this.b.e();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/indoor/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */