package com.baidu.che.codriver.d.a;

import com.baidu.carlife.core.i;
import com.baidu.carlife.d.a.c;
import com.baidu.carlife.d.a.e;
import java.util.Map;

public abstract class a
  implements c, b
{
  protected static final String a = "network";
  private String b;
  
  public void a()
  {
    this.b = c();
    e.c(this.b, d(), this);
  }
  
  public void a(int paramInt, String paramString)
  {
    i.b("network", "onSuccess statusCode = " + paramInt + ";response = " + paramString);
    a(this.b, paramInt, paramString);
  }
  
  public abstract void a(String paramString1, int paramInt, String paramString2);
  
  public void a(Map<String, String> paramMap) {}
  
  public void b()
  {
    e.a(this.b);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/d/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */