package com.baidu.che.codriver.sdk.a;

import android.content.Context;
import com.baidu.che.codriver.util.c;
import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.vr.m;

public class i
{
  private static final String a = i.class.getSimpleName();
  private b b;
  private Context c = c.a();
  private a d = a.l;
  
  public static i b()
  {
    return c.a();
  }
  
  public a a()
  {
    return this.d;
  }
  
  public void a(b paramb)
  {
    this.b = paramb;
  }
  
  public void a(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        this.d = a.l;
        return;
        if (paramString.equals("0"))
        {
          i = 0;
          continue;
          if (paramString.equals("1"))
          {
            i = 1;
            continue;
            if (paramString.equals("2"))
            {
              i = 2;
              continue;
              if (paramString.equals("3"))
              {
                i = 3;
                continue;
                if (paramString.equals("4"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("5"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("6"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("7"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("8"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("9"))
                          {
                            i = 9;
                            continue;
                            if (paramString.equals("10")) {
                              i = 10;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    this.d = a.a;
    return;
    this.d = a.b;
    return;
    this.d = a.c;
    return;
    this.d = a.d;
    com.baidu.che.codriver.e.b.a().e();
    return;
    this.d = a.e;
    return;
    this.d = a.f;
    return;
    this.d = a.g;
    return;
    this.d = a.h;
    return;
    this.d = a.i;
    return;
    this.d = a.j;
    return;
    this.d = a.k;
  }
  
  public void a(String paramString1, String paramString2)
  {
    h.e("CdPhoneManager", "param:" + paramString1 + ";data:" + paramString2);
    l.a().a("phone.tool", paramString1, paramString2);
  }
  
  public boolean a(int paramInt, m paramm)
  {
    h.b(a, "getBTState:" + b.a().c().toString());
    if (b.a().c() == b.a.c)
    {
      paramm.a(new com.baidu.che.codriver.ui.d.i(this.c.getString(2131298375), "tts_record_bluetooth_disabled", 0, com.baidu.che.codriver.ui.d.b.a.c));
      return true;
    }
    if (b.a().c() == b.a.i)
    {
      if (b.a().b() == 1)
      {
        paramm.a(new com.baidu.che.codriver.ui.d.i(this.c.getString(2131298379), 2, com.baidu.che.codriver.ui.d.b.a.c));
        return true;
      }
      paramm.a(new com.baidu.che.codriver.ui.d.i(this.c.getString(2131298380), 2, com.baidu.che.codriver.ui.d.b.a.c));
      b.a().d();
      return true;
    }
    if ((b.a().c() == b.a.b) || (b.a().c() == b.a.h))
    {
      if (paramInt == 0) {
        paramm.a(new com.baidu.che.codriver.ui.d.i(this.c.getString(2131298376), 2, com.baidu.che.codriver.ui.d.b.a.c));
      }
      for (;;)
      {
        b.a().d();
        return true;
        paramm.a(new com.baidu.che.codriver.ui.d.i(this.c.getString(2131298377), 2, com.baidu.che.codriver.ui.d.b.a.c));
      }
    }
    if (b.a().c() == b.a.d)
    {
      paramm.a(new com.baidu.che.codriver.ui.d.i(this.c.getString(2131298385), 2, com.baidu.che.codriver.ui.d.b.a.c));
      return true;
    }
    return false;
  }
  
  public boolean a(m paramm)
  {
    if ((com.baidu.che.codriver.e.b.a().d() == com.baidu.che.codriver.e.b.a.b) || (com.baidu.che.codriver.e.b.a().d() == com.baidu.che.codriver.e.b.a.e))
    {
      paramm.a(new com.baidu.che.codriver.ui.d.i(this.c.getString(2131298374), 2, com.baidu.che.codriver.ui.d.b.a.c));
      return false;
    }
    if ((com.baidu.che.codriver.e.b.a().d() == com.baidu.che.codriver.e.b.a.a) && (com.baidu.che.codriver.e.b.a().c() == 0))
    {
      paramm.a(new com.baidu.che.codriver.ui.d.i(this.c.getString(2131298378), 2, com.baidu.che.codriver.ui.d.b.a.c));
      b.a().e();
      return false;
    }
    if ((b().a() == a.e) || (b().a() == a.d) || (b().a() == a.c))
    {
      paramm.a(new com.baidu.che.codriver.ui.d.i(this.c.getString(2131298386), 2, com.baidu.che.codriver.ui.d.b.a.c));
      return false;
    }
    return true;
  }
  
  public b c()
  {
    return this.b;
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString);
  }
  
  private static class c
  {
    private static i a = new i();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/sdk/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */