package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public final class al
  implements gf
{
  public final gm a(gf.a parama)
    throws IOException
  {
    Object localObject = parama.a();
    long l2 = System.nanoTime();
    String str = an.d;
    ((gk)localObject).b();
    ((gk)localObject).a();
    if (((gk)localObject).d() != null) {}
    for (long l1 = ((gk)localObject).d().b();; l1 = -1L)
    {
      parama.b();
      ((gk)localObject).c();
      parama = parama.a((gk)localObject);
      if (parama != null)
      {
        l1 = System.nanoTime();
        localObject = an.d;
        parama.a().b();
        parama.a().a();
        parama.b();
        double d = (l1 - l2) / 1000000.0D;
        parama.e();
      }
      return parama;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */