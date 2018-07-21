package com.baidu.carlife.k;

import com.baidu.carlife.k.a.e;
import com.baidu.carlife.k.a.f;
import com.baidu.carlife.k.a.f.a;
import java.util.List;
import org.json.JSONException;

public class b
  extends e
{
  private String a = "android";
  private List<com.baidu.carlife.model.d> b;
  
  public List<com.baidu.carlife.model.d> a()
  {
    return this.b;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(List<com.baidu.carlife.model.d> paramList)
  {
    this.b = paramList;
  }
  
  public String b()
  {
    return this.a;
  }
  
  protected String getUrl()
  {
    return f.a(f.a.c);
  }
  
  protected com.baidu.carlife.k.a.d getUrlParams()
  {
    com.baidu.carlife.k.a.d locald = new com.baidu.carlife.k.a.d();
    locald.put("type", this.a);
    return locald;
  }
  
  protected int responseSuccessCallBack(String paramString)
    throws JSONException
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return -3;
    }
    this.b = com.baidu.carlife.model.d.a(paramString);
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */