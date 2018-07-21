package com.tencent.mm.sdk.b;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

final class c
  implements b.a
{
  private Handler handler = new Handler(Looper.getMainLooper());
  
  public final void f(String paramString1, String paramString2)
  {
    if (b.t() <= 2) {
      Log.i(paramString1, paramString2);
    }
  }
  
  public final void g(String paramString1, String paramString2)
  {
    if (b.t() <= 1) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public final int getLogLevel()
  {
    return b.t();
  }
  
  public final void h(String paramString1, String paramString2)
  {
    if (b.t() <= 3) {
      Log.w(paramString1, paramString2);
    }
  }
  
  public final void i(String paramString1, String paramString2)
  {
    if (b.t() <= 4) {
      Log.e(paramString1, paramString2);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/mm/sdk/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */