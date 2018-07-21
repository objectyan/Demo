package com.baidu.che.codriver.ui.c;

import android.view.View;
import com.baidu.che.codriver.ui.d.b.a;

public abstract class b
{
  private com.baidu.che.codriver.ui.d.b a;
  
  public static b a(b.a parama)
  {
    switch (1.a[parama.ordinal()])
    {
    default: 
      try
      {
        throw new IllegalArgumentException("not a conversation item type");
      }
      catch (Exception parama)
      {
        parama.printStackTrace();
        return new j();
      }
    case 1: 
      return new j();
    case 2: 
      return new o();
    case 3: 
      return new a();
    case 4: 
      return new k();
    case 5: 
      return new i();
    case 6: 
      return new p();
    case 7: 
      return new f();
    case 8: 
      return new g();
    case 9: 
      return new n();
    case 10: 
      return new h();
    case 11: 
      return new d();
    case 12: 
      return new e();
    case 13: 
      return new q();
    }
    return new m();
  }
  
  public View a(View paramView1, View paramView2)
  {
    View localView = paramView2;
    if (paramView2 == null) {
      localView = b(paramView1);
    }
    a(localView);
    return localView;
  }
  
  abstract b.a a();
  
  abstract void a(View paramView);
  
  public void a(com.baidu.che.codriver.ui.d.b paramb)
  {
    this.a = paramb;
  }
  
  View b(View paramView)
  {
    return paramView;
  }
  
  public com.baidu.che.codriver.ui.d.b b()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/ui/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */