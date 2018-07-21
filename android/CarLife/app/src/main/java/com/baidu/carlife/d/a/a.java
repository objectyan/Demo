package com.baidu.carlife.d.a;

import android.text.TextUtils;
import b.m;
import b.m.a;
import b.n;
import b.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class a
  implements n
{
  List<m> a = new ArrayList();
  
  private void a(m paramm)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (TextUtils.equals(localm.a(), paramm.a()))
      {
        this.a.remove(localm);
        this.a.add(paramm);
        return;
      }
    }
    this.a.add(paramm);
  }
  
  public List<m> a(u paramu)
  {
    return this.a;
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(u paramu, List<m> paramList) {}
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    a(new m.a().a(paramString1).b(paramString2).c(paramString3).c());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/d/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */