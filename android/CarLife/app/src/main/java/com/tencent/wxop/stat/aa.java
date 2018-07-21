package com.tencent.wxop.stat;

import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.b.b;

class aa
  implements Thread.UncaughtExceptionHandler
{
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if ((!f.c()) || (j.f() == null)) {}
    do
    {
      do
      {
        return;
        if (f.p())
        {
          ag.a(j.f()).a(new d(j.f(), j.a(j.f(), false, null), 2, paramThrowable, paramThread, null), null, false, true);
          j.g().i("MTA has caught the following uncaught exception:");
          j.g().a(paramThrowable);
        }
        j.i(j.f());
      } while (j.h() == null);
      j.g().j("Call the original uncaught exception handler.");
    } while ((j.h() instanceof aa));
    j.h().uncaughtException(paramThread, paramThrowable);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */