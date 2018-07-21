package com.baidu.carlife.platform.service;

import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.carlife.core.i;
import com.baidu.carlife.platform.communication.c.b;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class a
  implements c.b
{
  private static a a = null;
  private com.baidu.carlife.platform.communication.c b = com.baidu.carlife.platform.communication.c.a();
  private ConcurrentHashMap<String, c> c = new ConcurrentHashMap();
  private b d;
  
  private a()
  {
    if (this.b != null) {
      this.b.a(this);
    }
  }
  
  public static a a()
  {
    if (a == null) {
      a = new a();
    }
    return a;
  }
  
  public void a(String paramString)
  {
    if (this.b == null) {}
    com.baidu.carlife.platform.communication.b localb;
    c localc;
    do
    {
      return;
      localb = this.b.a(paramString);
      localc = (c)this.c.get(paramString);
    } while (localc == null);
    localc.a(localb);
    try
    {
      b().a(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      i.a("PlatformManager", paramString);
    }
  }
  
  public b b()
  {
    if (this.d == null) {
      this.d = new b();
    }
    return this.d;
  }
  
  public c b(String paramString)
  {
    c localc = new c(paramString);
    this.c.put(paramString, localc);
    return localc;
  }
  
  public c c(String paramString)
  {
    return (c)this.c.get(paramString);
  }
  
  public List<String> c()
  {
    ArrayList localArrayList = new ArrayList();
    Enumeration localEnumeration = this.c.keys();
    while (localEnumeration.hasMoreElements())
    {
      String str = (String)localEnumeration.nextElement();
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
    }
    return localArrayList;
  }
  
  public void d()
  {
    if (this.b != null) {
      this.b.b();
    }
  }
  
  public void d(String paramString)
  {
    if (this.c.containsKey(paramString)) {
      this.c.remove(paramString);
    }
    try
    {
      b().b(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      i.a("PlatformManager", paramString);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/platform/service/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */