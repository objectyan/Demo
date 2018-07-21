package cz.msebera.android.httpclient.b.g;

import cz.msebera.android.httpclient.b.j;
import cz.msebera.android.httpclient.o.g;
import cz.msebera.android.httpclient.x;
import java.io.Closeable;
import java.io.IOException;

public class c
{
  public static void a(cz.msebera.android.httpclient.b.d.c paramc)
  {
    if (paramc != null) {
      try
      {
        g.b(paramc.b());
        return;
      }
      finally
      {
        try
        {
          paramc.close();
          return;
        }
        catch (IOException paramc) {}
        localObject = finally;
        paramc.close();
      }
    }
  }
  
  public static void a(j paramj)
  {
    if ((paramj != null) && ((paramj instanceof Closeable))) {}
    try
    {
      ((Closeable)paramj).close();
      return;
    }
    catch (IOException paramj) {}
  }
  
  public static void a(x paramx)
  {
    if (paramx != null)
    {
      paramx = paramx.b();
      if (paramx == null) {}
    }
    try
    {
      g.b(paramx);
      return;
    }
    catch (IOException paramx) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/g/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */