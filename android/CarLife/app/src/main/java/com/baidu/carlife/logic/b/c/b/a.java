package com.baidu.carlife.logic.b.c.b;

import com.baidu.carlife.c.d;
import com.baidu.carlife.c.f.a.a;
import com.baidu.carlife.logic.b.c.a.c;
import com.baidu.navi.fragment.ContentFragment;

public class a
  extends com.baidu.carlife.c.e.b<com.baidu.carlife.logic.b.b.a>
{
  private static final int a = 0;
  private static final int b = 1;
  private static final int c = 2;
  private static final int d = 3;
  private ContentFragment e;
  
  public a(ContentFragment paramContentFragment)
  {
    this.e = paramContentFragment;
  }
  
  public a.a d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("position out of bound");
    case 0: 
      new c()
      {
        protected d<Void, Void> f()
        {
          new d()
          {
            public void a(Void paramAnonymous2Void)
            {
              com.baidu.carlife.c.g.b.a().a(new Runnable()
              {
                public void run()
                {
                  new com.baidu.che.codriver.ui.a(a.a(a.this).getContext()).a(false);
                }
              });
            }
          };
        }
      };
    case 1: 
      new c()
      {
        protected d<Void, Void> f()
        {
          return new com.baidu.carlife.logic.b.d.b(547, null);
        }
      };
    case 2: 
      new c()
      {
        protected d<Void, Void> f()
        {
          new d()
          {
            public void a(Void paramAnonymous2Void)
            {
              a.a(a.this).openWebView(0, 567, a.a(a.this).getStringUtil(2131296517), "http://carlife.baidu.com/static/carlifeweb/problems/android.html");
            }
          };
        }
      };
    }
    new c()
    {
      protected d<Void, Void> f()
      {
        return new com.baidu.carlife.logic.b.d.b(537, null);
      }
    };
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/b/c/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */