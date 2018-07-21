package com.baidu.carlife.c.d;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class i
{
  private final HashMap<String, f> a = new HashMap();
  
  final f a(String paramString)
  {
    return (f)this.a.get(paramString);
  }
  
  public final void a()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).b();
    }
    this.a.clear();
  }
  
  final void a(String paramString, f paramf)
  {
    f localf = (f)this.a.get(paramString);
    if (localf != null) {
      localf.b();
    }
    this.a.put(paramString, paramf);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/c/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */