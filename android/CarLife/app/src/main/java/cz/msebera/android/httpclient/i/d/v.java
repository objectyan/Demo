package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.ag;
import cz.msebera.android.httpclient.ai;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.g;
import cz.msebera.android.httpclient.k.c;
import cz.msebera.android.httpclient.k.n;
import cz.msebera.android.httpclient.k.x;
import cz.msebera.android.httpclient.n.f;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.d;
import java.util.ArrayList;
import java.util.List;

@Immutable
public class v
{
  public static final v a = new v();
  
  private ag b(d paramd, x paramx)
  {
    int k = 0;
    int i = paramx.c();
    int m = paramx.c();
    int n = paramx.b();
    int j = k;
    label48:
    String str;
    if (i < n)
    {
      j = paramd.a(i);
      if (j == 61) {
        j = k;
      }
    }
    else
    {
      if (i != n) {
        break label108;
      }
      j = 1;
      str = paramd.b(m, n);
    }
    for (;;)
    {
      if (j == 0) {
        break label124;
      }
      paramx.a(i);
      return new n(str, null);
      if (j == 59)
      {
        j = 1;
        break label48;
      }
      i += 1;
      break;
      label108:
      str = paramd.b(m, i);
      i += 1;
    }
    label124:
    m = i;
    for (;;)
    {
      k = j;
      if (i < n)
      {
        if (paramd.a(i) == ';') {
          k = 1;
        }
      }
      else
      {
        j = i;
        for (;;)
        {
          n = j;
          if (m >= j) {
            break;
          }
          n = j;
          if (!f.a(paramd.a(m))) {
            break;
          }
          m += 1;
        }
      }
      i += 1;
    }
    while ((n > m) && (f.a(paramd.a(n - 1)))) {
      n -= 1;
    }
    paramd = paramd.a(m, n);
    j = i;
    if (k != 0) {
      j = i + 1;
    }
    paramx.a(j);
    return new n(str, paramd);
  }
  
  public g a(d paramd, x paramx)
    throws ai
  {
    a.a(paramd, "Char array buffer");
    a.a(paramx, "Parser cursor");
    ag localag = b(paramd, paramx);
    ArrayList localArrayList = new ArrayList();
    while (!paramx.d()) {
      localArrayList.add(b(paramd, paramx));
    }
    return new c(localag.a(), localag.b(), (ag[])localArrayList.toArray(new ag[localArrayList.size()]));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */