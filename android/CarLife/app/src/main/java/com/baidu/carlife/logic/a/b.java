package com.baidu.carlife.logic.a;

import java.util.HashMap;

public abstract class b<T>
{
  private HashMap<String, T> a = new HashMap();
  
  public T a(String paramString)
  {
    if ((this.a == null) || (this.a.isEmpty())) {
      return null;
    }
    return (T)this.a.get(paramString);
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(String paramString, T paramT)
  {
    this.a.put(paramString, paramT);
  }
  
  public void b(String paramString)
  {
    this.a.remove(paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */