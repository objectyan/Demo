package com.baidu.carlife.core.connect;

import android.net.wifi.p2p.WifiP2pManager.ActionListener;

public class i
{
  private static final String a = "[WifiDirect]";
  private static i i = null;
  private WifiP2pManager.ActionListener b = new g();
  private WifiP2pManager.ActionListener c = new c();
  private WifiP2pManager.ActionListener d = new d();
  private WifiP2pManager.ActionListener e = new h();
  private WifiP2pManager.ActionListener f = new a();
  private WifiP2pManager.ActionListener g = new b();
  private WifiP2pManager.ActionListener h = new f();
  
  public static i a()
  {
    if (i == null) {}
    try
    {
      if (i == null) {
        i = new i();
      }
      return i;
    }
    finally {}
  }
  
  public WifiP2pManager.ActionListener a(String paramString, boolean paramBoolean)
  {
    return new e(paramString, paramBoolean);
  }
  
  public WifiP2pManager.ActionListener b()
  {
    return this.b;
  }
  
  public WifiP2pManager.ActionListener c()
  {
    return this.c;
  }
  
  public WifiP2pManager.ActionListener d()
  {
    return this.d;
  }
  
  public WifiP2pManager.ActionListener e()
  {
    return this.e;
  }
  
  public WifiP2pManager.ActionListener f()
  {
    return this.f;
  }
  
  public WifiP2pManager.ActionListener g()
  {
    return this.g;
  }
  
  public WifiP2pManager.ActionListener h()
  {
    return this.h;
  }
  
  class a
    implements WifiP2pManager.ActionListener
  {
    a() {}
    
    public void onFailure(int paramInt)
    {
      com.baidu.carlife.core.i.b("[WifiDirect]", ": onFailure");
    }
    
    public void onSuccess()
    {
      com.baidu.carlife.core.i.b("[WifiDirect]", ": Added Local Service onSuccess");
    }
  }
  
  class b
    implements WifiP2pManager.ActionListener
  {
    b() {}
    
    public void onFailure(int paramInt)
    {
      com.baidu.carlife.core.i.b("[WifiDirect]", ": addServiceRequest onFailure");
    }
    
    public void onSuccess()
    {
      com.baidu.carlife.core.i.b("[WifiDirect]", ": addServiceRequest onSuccess");
    }
  }
  
  class c
    implements WifiP2pManager.ActionListener
  {
    c() {}
    
    public void onFailure(int paramInt) {}
    
    public void onSuccess() {}
  }
  
  class d
    implements WifiP2pManager.ActionListener
  {
    d() {}
    
    public void onFailure(int paramInt) {}
    
    public void onSuccess() {}
  }
  
  class e
    implements WifiP2pManager.ActionListener
  {
    private String b = "Action";
    private boolean c = false;
    
    public e(String paramString, boolean paramBoolean)
    {
      this.b = paramString;
      this.c = paramBoolean;
    }
    
    public void onFailure(int paramInt)
    {
      com.baidu.carlife.core.i.b("[WifiDirect]", this.b + " : onFailure");
    }
    
    public void onSuccess()
    {
      if (this.c) {
        com.baidu.carlife.core.i.b("[WifiDirect]", this.b + " : onSuccess");
      }
    }
  }
  
  class f
    implements WifiP2pManager.ActionListener
  {
    f() {}
    
    public void onFailure(int paramInt)
    {
      com.baidu.carlife.core.i.b("[WifiDirect]", ": Service discovery initiated onFailure");
    }
    
    public void onSuccess()
    {
      com.baidu.carlife.core.i.b("[WifiDirect]", ": Service discovery initiated onSuccess");
    }
  }
  
  class g
    implements WifiP2pManager.ActionListener
  {
    g() {}
    
    public void onFailure(int paramInt) {}
    
    public void onSuccess() {}
  }
  
  class h
    implements WifiP2pManager.ActionListener
  {
    h() {}
    
    public void onFailure(int paramInt) {}
    
    public void onSuccess() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/connect/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */