package cz.msebera.android.httpclient.e.b;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.r;
import java.net.InetAddress;

@Immutable
public class a
  implements c
{
  protected int a(e parame)
  {
    int i = 1;
    if (parame.d() > 1) {
      i = 2;
    }
    return i;
  }
  
  public int a(e parame1, e parame2)
  {
    cz.msebera.android.httpclient.o.a.a(parame1, "Planned route");
    if ((parame2 == null) || (parame2.d() < 1)) {
      return a(parame1);
    }
    if (parame1.d() > 1) {
      return c(parame1, parame2);
    }
    return b(parame1, parame2);
  }
  
  protected int b(e parame1, e parame2)
  {
    if (parame2.d() > 1) {}
    while ((!parame1.a().equals(parame2.a())) || (parame1.j() != parame2.j()) || ((parame1.b() != null) && (!parame1.b().equals(parame2.b())))) {
      return -1;
    }
    return 0;
  }
  
  protected int c(e parame1, e parame2)
  {
    if (parame2.d() <= 1) {}
    label90:
    do
    {
      do
      {
        int j;
        int k;
        do
        {
          do
          {
            return -1;
          } while (!parame1.a().equals(parame2.a()));
          j = parame1.d();
          k = parame2.d();
        } while (j < k);
        int i = 0;
        for (;;)
        {
          if (i >= k - 1) {
            break label90;
          }
          if (!parame1.a(i).equals(parame2.a(i))) {
            break;
          }
          i += 1;
        }
        if (j > k) {
          return 4;
        }
      } while (((parame2.g()) && (!parame1.g())) || ((parame2.i()) && (!parame1.i())));
      if ((parame1.g()) && (!parame2.g())) {
        return 3;
      }
      if ((parame1.i()) && (!parame2.i())) {
        return 5;
      }
    } while (parame1.j() != parame2.j());
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/e/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */