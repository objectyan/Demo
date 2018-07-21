package com.baidu.mapframework.common.a;

import android.util.Log;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

class k
  implements a
{
  private boolean a = false;
  
  private void b(i parami)
  {
    String str = String.format(Locale.getDefault(), "[%d] [%s] [%s] [%s] [%s] [%s]\n", new Object[] { Long.valueOf(parami.d), parami.a.format(new Date(parami.d)), parami.c, parami.b, parami.f, parami.e });
    switch (1.a[parami.b.ordinal()])
    {
    default: 
      return;
    case 1: 
      Log.d(parami.c, str);
      return;
    case 2: 
      Log.i(parami.c, str);
      return;
    case 3: 
      Log.w(parami.c, str);
      return;
    }
    Log.e(parami.c, str);
  }
  
  public void a()
  {
    this.a = true;
  }
  
  public void a(i parami)
  {
    if (!this.a) {
      b(parami);
    }
  }
  
  public a.a b()
  {
    return a.a.b;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/common/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */