package com.baidu.location.d.a;

import android.content.Context;
import com.baidu.location.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g
{
  private static boolean a = false;
  private static b b;
  private static b.a c = new b.a()
  {
    public void a(int paramAnonymousInt)
    {
      if (paramAnonymousInt == 100) {
        g.a(true);
      }
    }
  };
  private static a d;
  private static g e = null;
  private static Context f = null;
  private static c g = null;
  private static List<Integer> h = new ArrayList();
  private static boolean i = false;
  private static c.a j = new c.a()
  {
    public void a(int paramAnonymousInt)
    {
      if (g.c().c())
      {
        g.d().add(Integer.valueOf(paramAnonymousInt));
        if (g.e()) {
          break label333;
        }
        if ((g.d().size() < 2) || (((Integer)g.d().get(g.d().size() - 1)).intValue() != 0) || (((Integer)g.d().get(g.d().size() - 2)).intValue() != 0)) {
          break label161;
        }
        if (g.d().size() != 2) {
          break label130;
        }
        g.d().clear();
        g.f().a(0);
        g.c().b();
      }
      label130:
      label161:
      while (paramAnonymousInt != 888)
      {
        return;
        g.a(false);
        g.b(true);
        g.d().clear();
        g.c().d();
        g.g().a();
        return;
      }
      Iterator localIterator = g.d().iterator();
      int j = 0;
      int i = 0;
      paramAnonymousInt = 0;
      label184:
      Integer localInteger;
      int k;
      if (localIterator.hasNext())
      {
        localInteger = (Integer)localIterator.next();
        if (localInteger.intValue() >= 1000)
        {
          k = j;
          j = paramAnonymousInt + 1;
          paramAnonymousInt = k;
        }
      }
      for (;;)
      {
        k = j;
        j = paramAnonymousInt;
        paramAnonymousInt = k;
        break label184;
        if (localInteger.intValue() == 0)
        {
          i += 1;
          k = paramAnonymousInt;
          paramAnonymousInt = j;
          j = k;
        }
        else
        {
          if (localInteger.intValue() == 1)
          {
            k = j + 1;
            j = paramAnonymousInt;
            paramAnonymousInt = k;
            continue;
            if (paramAnonymousInt >= 5)
            {
              g.f().a(1);
              return;
            }
            if (g.d().size() > 0) {
              g.d().clear();
            }
            g.f().a(0);
            g.c().b();
            return;
            label333:
            if ((!g.e()) || (paramAnonymousInt != 999)) {
              break;
            }
            g.g().b();
            if (g.h() == true)
            {
              paramAnonymousInt = 1;
              if (paramAnonymousInt != 0)
              {
                g.c().b();
                g.d().clear();
                g.b(false);
                g.a(false);
                g.c().a();
              }
            }
            else
            {
              localIterator = g.d().iterator();
              j = 0;
              i = 0;
              paramAnonymousInt = 0;
              label412:
              if (localIterator.hasNext())
              {
                localInteger = (Integer)localIterator.next();
                if (localInteger.intValue() >= 1000)
                {
                  k = j;
                  j = paramAnonymousInt + 1;
                  paramAnonymousInt = k;
                }
              }
            }
            for (;;)
            {
              k = j;
              j = paramAnonymousInt;
              paramAnonymousInt = k;
              break label412;
              if (localInteger.intValue() == 0)
              {
                i += 1;
                k = paramAnonymousInt;
                paramAnonymousInt = j;
                j = k;
              }
              else
              {
                if (localInteger.intValue() == 1)
                {
                  k = j + 1;
                  j = paramAnonymousInt;
                  paramAnonymousInt = k;
                  continue;
                  if (paramAnonymousInt >= 5)
                  {
                    paramAnonymousInt = 1;
                    break;
                    g.c().b();
                    g.d().clear();
                    g.b(false);
                    g.a(false);
                    g.f().a(0);
                    return;
                  }
                  paramAnonymousInt = 0;
                  break;
                }
                k = paramAnonymousInt;
                paramAnonymousInt = j;
                j = k;
              }
            }
          }
          k = paramAnonymousInt;
          paramAnonymousInt = j;
          j = k;
        }
      }
    }
  };
  
  public static g a()
  {
    if (e == null)
    {
      e = new g();
      f = f.getServiceContext();
      g = new c(f, j);
      b = b.a(f, c);
    }
    return e;
  }
  
  public void a(int paramInt)
  {
    a = false;
    i = false;
    if (h.size() > 0) {
      h.clear();
    }
    g.a(paramInt);
  }
  
  public void a(a parama)
  {
    d = parama;
  }
  
  public void b()
  {
    a = false;
    i = false;
    if (h.size() > 0) {
      h.clear();
    }
    g.b();
    b.b();
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/d/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */