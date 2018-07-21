package com.baidu.carlife.logic;

import android.app.KeyguardManager;
import android.content.Context;
import com.baidu.carlife.core.i;

public class r
{
  public static String a = r.class.getSimpleName();
  private static final Object b = new Object();
  private static r c;
  private Context d;
  private KeyguardManager e;
  
  public static r a()
  {
    if (c == null) {}
    synchronized (b)
    {
      if (c == null) {
        c = new r();
      }
      return c;
    }
  }
  
  public void a(Context paramContext)
  {
    this.d = paramContext;
  }
  
  public boolean b()
  {
    this.e = ((KeyguardManager)this.d.getSystemService("keyguard"));
    if (this.e.inKeyguardRestrictedInputMode())
    {
      i.b(a, "getKeyGuardState:keyguard on !");
      return true;
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */