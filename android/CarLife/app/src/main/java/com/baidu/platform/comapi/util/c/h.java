package com.baidu.platform.comapi.util.c;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;

public class h
  implements g
{
  private LinkedList<g> a = new LinkedList();
  
  public h a(g paramg)
  {
    this.a.add(paramg);
    return this;
  }
  
  public void a(Context paramContext)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).a(paramContext);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */