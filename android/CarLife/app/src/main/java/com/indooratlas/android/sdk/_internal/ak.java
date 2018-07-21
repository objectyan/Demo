package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class ak
  implements gf
{
  private static final String a = ee.a(ak.class);
  private volatile long b = -1L;
  private long c;
  
  private static long a(gm paramgm)
  {
    paramgm = paramgm.a("Date");
    if (!af.a(paramgm)) {
      try
      {
        long l = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US).parse(paramgm).getTime();
        return l;
      }
      catch (ParseException paramgm)
      {
        ee.a(a, "parsing server date failed, retry conditions not handled", new Object[0]);
      }
    }
    for (;;)
    {
      return -1L;
      ee.a(a, "no date header from server, retry conditions not handled", new Object[0]);
    }
  }
  
  private gm b(gf.a parama)
    throws IOException
  {
    long l1 = this.b;
    long l2 = v.d().a();
    long l3 = this.c;
    gk localgk1 = parama.a();
    gk localgk2 = localgk1.e().a("Date", new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US).format(new Date(l1 + (l2 - l3)))).a();
    if (ee.a(a, 2))
    {
      localgk1.a("Date");
      localgk2.a("Date");
    }
    return parama.a(localgk2);
  }
  
  public final gm a(gf.a parama)
    throws IOException
  {
    v localv = v.d();
    if (this.b != -1L) {
      localObject = b(parama);
    }
    long l;
    do
    {
      gm localgm;
      do
      {
        do
        {
          return (gm)localObject;
          localgm = parama.a(parama.a());
          if (localgm == null) {
            return null;
          }
          this.b = a(localgm);
          localObject = localgm;
        } while (this.b == -1L);
        this.c = localv.a();
        l = Math.abs(this.b - localv.c());
        localObject = localgm;
      } while (localgm.b() < 400);
      localObject = localgm;
    } while (l < 6000000L);
    Object localObject = an.d;
    new Date().toString();
    new Date(this.b).toString();
    return b(parama);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */