package com.baidu.carlife.core.b;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.carlife.core.connect.d;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.f.a;
import com.baidu.carlife.core.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  implements h
{
  public static final boolean a;
  public static final boolean b = false;
  public static boolean c;
  private static List<a> d;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      c = false;
      d = new ArrayList();
      return;
    }
  }
  
  public static void a(a parama)
  {
    d.add(parama);
  }
  
  public static void a(boolean paramBoolean)
  {
    c = paramBoolean;
  }
  
  public static boolean a()
  {
    return (a) && (!c);
  }
  
  public static void b()
  {
    d.clear();
  }
  
  public static boolean c()
  {
    String str = f.jx.a();
    int j = 0;
    Iterator localIterator = d.iterator();
    do
    {
      i = j;
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!TextUtils.equals(str, ((a)localIterator.next()).a));
    int i = 1;
    return (e.a().r()) && (d.a().c()) && (i != 0);
  }
  
  public static String d()
  {
    String str = f.jx.a();
    Iterator localIterator = d.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (TextUtils.equals(str, locala.a)) {
        return locala.b;
      }
    }
    return "";
  }
  
  public static class a
    implements h
  {
    public String a;
    public String b;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */