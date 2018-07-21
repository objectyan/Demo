package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.b.a.d;
import cz.msebera.android.httpclient.b.d.g;
import cz.msebera.android.httpclient.b.d.o;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.x;
import java.io.IOException;

class a
  implements Runnable
{
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  private final b b;
  private final p c;
  private final cz.msebera.android.httpclient.e.b.b d;
  private final o e;
  private final cz.msebera.android.httpclient.b.f.c f;
  private final g g;
  private final d h;
  private final String i;
  private final int j;
  
  a(b paramb, p paramp, cz.msebera.android.httpclient.e.b.b paramb1, o paramo, cz.msebera.android.httpclient.b.f.c paramc, g paramg, d paramd, String paramString, int paramInt)
  {
    this.b = paramb;
    this.c = paramp;
    this.d = paramb1;
    this.e = paramo;
    this.f = paramc;
    this.g = paramg;
    this.h = paramd;
    this.i = paramString;
    this.j = paramInt;
  }
  
  private boolean a(int paramInt)
  {
    return paramInt < 500;
  }
  
  private boolean a(x paramx)
  {
    paramx = paramx.getHeaders("Warning");
    if (paramx != null)
    {
      int m = paramx.length;
      int k = 0;
      while (k < m)
      {
        String str = paramx[k].d();
        if ((str.startsWith("110")) || (str.startsWith("111"))) {
          return false;
        }
        k += 1;
      }
    }
    return true;
  }
  
  protected boolean a()
  {
    for (;;)
    {
      try
      {
        cz.msebera.android.httpclient.b.d.c localc = this.c.a(this.d, this.e, this.f, this.g, this.h);
        try
        {
          if (a(localc.a().b()))
          {
            bool = a(localc);
            if (bool)
            {
              bool = true;
              return bool;
            }
          }
        }
        finally
        {
          localc.close();
        }
        boolean bool = false;
      }
      catch (IOException localIOException)
      {
        this.a.a("Asynchronous revalidation failed due to I/O error", localIOException);
        return false;
      }
      catch (cz.msebera.android.httpclient.p localp)
      {
        this.a.b("HTTP protocol exception during asynchronous revalidation", localp);
        return false;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.a.b("RuntimeException thrown during asynchronous revalidation: " + localRuntimeException);
        return false;
      }
    }
  }
  
  String b()
  {
    return this.i;
  }
  
  public int c()
  {
    return this.j;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 144	cz/msebera/android/httpclient/i/b/a/a:a	()Z
    //   4: ifeq +26 -> 30
    //   7: aload_0
    //   8: getfield 44	cz/msebera/android/httpclient/i/b/a/a:b	Lcz/msebera/android/httpclient/i/b/a/b;
    //   11: aload_0
    //   12: getfield 58	cz/msebera/android/httpclient/i/b/a/a:i	Ljava/lang/String;
    //   15: invokevirtual 149	cz/msebera/android/httpclient/i/b/a/b:b	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: getfield 44	cz/msebera/android/httpclient/i/b/a/a:b	Lcz/msebera/android/httpclient/i/b/a/b;
    //   22: aload_0
    //   23: getfield 58	cz/msebera/android/httpclient/i/b/a/a:i	Ljava/lang/String;
    //   26: invokevirtual 151	cz/msebera/android/httpclient/i/b/a/b:a	(Ljava/lang/String;)V
    //   29: return
    //   30: aload_0
    //   31: getfield 44	cz/msebera/android/httpclient/i/b/a/a:b	Lcz/msebera/android/httpclient/i/b/a/b;
    //   34: aload_0
    //   35: getfield 58	cz/msebera/android/httpclient/i/b/a/a:i	Ljava/lang/String;
    //   38: invokevirtual 153	cz/msebera/android/httpclient/i/b/a/b:c	(Ljava/lang/String;)V
    //   41: goto -23 -> 18
    //   44: astore_1
    //   45: aload_0
    //   46: getfield 44	cz/msebera/android/httpclient/i/b/a/a:b	Lcz/msebera/android/httpclient/i/b/a/b;
    //   49: aload_0
    //   50: getfield 58	cz/msebera/android/httpclient/i/b/a/a:i	Ljava/lang/String;
    //   53: invokevirtual 151	cz/msebera/android/httpclient/i/b/a/b:a	(Ljava/lang/String;)V
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	a
    //   44	13	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	18	44	finally
    //   30	41	44	finally
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */