package com.baidu.carlife.k;

import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.e;
import com.baidu.carlife.k.a.f;
import com.baidu.carlife.k.a.f.d;

public class p
  extends e
{
  private a a;
  
  public p()
  {
    this.tag = p.class.getSimpleName();
  }
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  protected d getPostRequestParams()
  {
    d locald = new d();
    locald.put("channel", this.a.a);
    locald.put("cuid", this.a.b);
    locald.put("version", this.a.c);
    locald.put("item", this.a.d);
    return locald;
  }
  
  protected String getUrl()
  {
    return f.a(f.d.a);
  }
  
  protected int responseSuccessCallBack(String paramString)
  {
    com.baidu.carlife.util.p.a().c("connectedTime");
    return 0;
  }
  
  public class a
  {
    public String a;
    public String b;
    public String c;
    public String d;
    
    public a() {}
    
    public String a(String paramString)
    {
      return "{\"connectedTime\":[" + paramString + "]}";
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */