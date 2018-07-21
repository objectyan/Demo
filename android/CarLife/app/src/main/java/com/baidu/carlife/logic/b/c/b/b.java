package com.baidu.carlife.logic.b.c.b;

import android.os.Bundle;
import com.baidu.carlife.c.d;
import com.baidu.carlife.c.f.a.a;
import com.baidu.carlife.util.p;
import com.baidu.navi.util.StatisticManager;

public class b
  extends com.baidu.carlife.c.e.b<com.baidu.carlife.logic.b.b.a>
{
  private static final int a = 0;
  private static final int b = 1;
  private static final int c = 2;
  
  public a.a d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("position out of bound");
    case 2: 
      new com.baidu.carlife.logic.b.c.a.c()
      {
        protected d<Void, Void> f()
        {
          new com.baidu.carlife.logic.b.d.a(532, null)
          {
            protected void b()
            {
              p.a().c("license_plate_rule", false);
              ((com.baidu.carlife.logic.b.b.a)b.1.this.e()).c().b(Boolean.valueOf(false));
            }
          };
        }
      };
    case 0: 
      StatisticManager.onEvent("NAVI_0033", "NAVI_0033");
      new com.baidu.carlife.logic.b.c.a.b()
      {
        protected d<Void, Void> f()
        {
          new com.baidu.carlife.logic.b.d.a(556, null)
          {
            protected void b()
            {
              p.a().c("offline_map", false);
              ((com.baidu.carlife.logic.b.b.a)b.2.this.e()).c().b(Boolean.valueOf(false));
            }
          };
        }
      };
    }
    new com.baidu.carlife.logic.b.c.a.b()
    {
      protected d<Void, Void> f()
      {
        return new com.baidu.carlife.logic.b.d.b(554, null);
      }
    };
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/b/c/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */