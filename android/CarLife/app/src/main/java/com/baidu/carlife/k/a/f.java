package com.baidu.carlife.k.a;

public class f
{
  public static boolean a = true;
  public static final String b = "https://vehicle.baidu.com/";
  public static final String c = "http://sandbox.carlife.baidu.com/";
  public static final String d = "https://appnavi.baidu.com/";
  public static final String e = "http://sandbox.carlife.baidu.com/";
  public static final String f = "http://navimon.baidu.com/hunter/log/post";
  public static final String g = "http://cp01-rdqa-dev168.cp01.baidu.com:8180/hunter/log/post";
  public static final String h = "http://api.soargift.com:8998/parkApi/";
  public static final String i = "queryNearbyParkInfoList";
  public static final String j = "http://api.mwee.cn/";
  public static final String k = "baiduCarlife";
  public static final String l = "76646ec3a3d2c05957a44f59bf4978c76ab80b92";
  public static final String m = "http://st01-rdqa-dev398-daiziming.epc.baidu.com:8556/?m=Index&a=";
  public static final String n = "http://ufosdk.baidu.com?m=Index&a=";
  
  public static String a()
  {
    if (a) {
      return "http://navimon.baidu.com/hunter/log/post";
    }
    return "http://cp01-rdqa-dev168.cp01.baidu.com:8180/hunter/log/post";
  }
  
  public static String a(a parama)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (a) {}
    for (String str = "https://vehicle.baidu.com/";; str = "http://sandbox.carlife.baidu.com/") {
      return str + parama.a();
    }
  }
  
  public static String a(b paramb)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (a) {}
    for (String str = "http://ufosdk.baidu.com?m=Index&a=";; str = "http://st01-rdqa-dev398-daiziming.epc.baidu.com:8556/?m=Index&a=") {
      return str + paramb.a();
    }
  }
  
  public static String a(c paramc)
  {
    return "http://api.mwee.cn/" + paramc.a();
  }
  
  public static String a(d paramd)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (a) {}
    for (String str = "https://appnavi.baidu.com/";; str = "http://sandbox.carlife.baidu.com/") {
      return str + paramd.a();
    }
  }
  
  public static enum a
  {
    private String h;
    
    private a(String paramString)
    {
      this.h = paramString;
    }
    
    public String a()
    {
      return this.h;
    }
  }
  
  public static enum b
  {
    private String c;
    
    private b(String paramString)
    {
      this.c = paramString;
    }
    
    public String a()
    {
      return this.c;
    }
  }
  
  public static enum c
  {
    private String f;
    
    private c(String paramString)
    {
      this.f = paramString;
    }
    
    public String a()
    {
      return this.f;
    }
  }
  
  public static enum d
  {
    private String e;
    
    private d(String paramString)
    {
      this.e = paramString;
    }
    
    public String a()
    {
      return this.e;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */