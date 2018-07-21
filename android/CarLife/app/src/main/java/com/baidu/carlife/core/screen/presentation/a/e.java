package com.baidu.carlife.core.screen.presentation.a;

import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.core.screen.d;
import com.baidu.carlife.core.screen.i;

public class e
  implements i
{
  private static e b = new e();
  private i a = null;
  
  public static e a()
  {
    return b;
  }
  
  public void a(i parami)
  {
    this.a = parami;
  }
  
  public void a(String paramString, b paramb)
  {
    this.a.a(paramString, paramb);
  }
  
  public void a(String paramString, b paramb, d paramd)
  {
    this.a.a(paramString, paramb, paramd);
  }
  
  public void b(String paramString)
  {
    this.a.b(paramString);
  }
  
  public void c()
  {
    this.a.c();
  }
  
  public boolean d()
  {
    return this.a.d();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/presentation/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */