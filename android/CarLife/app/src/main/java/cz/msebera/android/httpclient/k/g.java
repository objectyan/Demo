package cz.msebera.android.httpclient.k;

import cz.msebera.android.httpclient.ag;
import cz.msebera.android.httpclient.ai;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.n.f;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.d;
import java.util.ArrayList;
import java.util.List;

@Immutable
public class g
  implements u
{
  @Deprecated
  public static final g a = new g();
  public static final g b = new g();
  private static final char c = ';';
  private static final char d = ',';
  private static final char[] e = { 59, 44 };
  
  private static boolean a(char paramChar, char[] paramArrayOfChar)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    int i;
    if (paramArrayOfChar != null)
    {
      j = paramArrayOfChar.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (paramChar == paramArrayOfChar[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static cz.msebera.android.httpclient.g[] a(String paramString, u paramu)
    throws ai
  {
    a.a(paramString, "Value");
    d locald = new d(paramString.length());
    locald.a(paramString);
    paramString = new x(0, paramString.length());
    if (paramu != null) {}
    for (;;)
    {
      return paramu.a(locald, paramString);
      paramu = b;
    }
  }
  
  public static cz.msebera.android.httpclient.g b(String paramString, u paramu)
    throws ai
  {
    a.a(paramString, "Value");
    d locald = new d(paramString.length());
    locald.a(paramString);
    paramString = new x(0, paramString.length());
    if (paramu != null) {}
    for (;;)
    {
      return paramu.b(locald, paramString);
      paramu = b;
    }
  }
  
  public static ag[] c(String paramString, u paramu)
    throws ai
  {
    a.a(paramString, "Value");
    d locald = new d(paramString.length());
    locald.a(paramString);
    paramString = new x(0, paramString.length());
    if (paramu != null) {}
    for (;;)
    {
      return paramu.c(locald, paramString);
      paramu = b;
    }
  }
  
  public static ag d(String paramString, u paramu)
    throws ai
  {
    a.a(paramString, "Value");
    d locald = new d(paramString.length());
    locald.a(paramString);
    paramString = new x(0, paramString.length());
    if (paramu != null) {}
    for (;;)
    {
      return paramu.d(locald, paramString);
      paramu = b;
    }
  }
  
  public ag a(d paramd, x paramx, char[] paramArrayOfChar)
  {
    a.a(paramd, "Char array buffer");
    a.a(paramx, "Parser cursor");
    int k = 0;
    int i = paramx.c();
    int m = paramx.c();
    int i3 = paramx.b();
    int j = k;
    char c1;
    label65:
    String str;
    if (i < i3)
    {
      c1 = paramd.a(i);
      if (c1 == '=') {
        j = k;
      }
    }
    else
    {
      if (i != i3) {
        break label128;
      }
      j = 1;
      str = paramd.b(m, i3);
    }
    for (;;)
    {
      if (j == 0) {
        break label147;
      }
      paramx.a(i);
      return a(str, null);
      if (a(c1, paramArrayOfChar))
      {
        j = 1;
        break label65;
      }
      i += 1;
      break;
      label128:
      str = paramd.b(m, i);
      i += 1;
    }
    label147:
    int n = i;
    int i2 = 0;
    int i1 = 0;
    for (;;)
    {
      m = j;
      if (i < i3)
      {
        c1 = paramd.a(i);
        k = i2;
        if (c1 == '"')
        {
          k = i2;
          if (i1 == 0) {
            if (i2 != 0) {
              break label270;
            }
          }
        }
      }
      label270:
      for (k = 1; (k == 0) && (i1 == 0) && (a(c1, paramArrayOfChar)); k = 0)
      {
        m = 1;
        i1 = i;
        j = n;
        for (;;)
        {
          k = i1;
          if (j >= i1) {
            break;
          }
          k = i1;
          if (!f.a(paramd.a(j))) {
            break;
          }
          j += 1;
        }
      }
      if (i1 == 0) {
        break;
      }
      m = 0;
      i += 1;
      i1 = m;
      i2 = k;
    }
    if ((k != 0) && (c1 == '\\')) {}
    for (m = 1;; m = 0) {
      break;
    }
    while ((k > j) && (f.a(paramd.a(k - 1)))) {
      k -= 1;
    }
    i1 = j;
    n = k;
    if (k - j >= 2)
    {
      i1 = j;
      n = k;
      if (paramd.a(j) == '"')
      {
        i1 = j;
        n = k;
        if (paramd.a(k - 1) == '"')
        {
          i1 = j + 1;
          n = k - 1;
        }
      }
    }
    paramd = paramd.a(i1, n);
    j = i;
    if (m != 0) {
      j = i + 1;
    }
    paramx.a(j);
    return a(str, paramd);
  }
  
  protected ag a(String paramString1, String paramString2)
  {
    return new n(paramString1, paramString2);
  }
  
  protected cz.msebera.android.httpclient.g a(String paramString1, String paramString2, ag[] paramArrayOfag)
  {
    return new c(paramString1, paramString2, paramArrayOfag);
  }
  
  public cz.msebera.android.httpclient.g[] a(d paramd, x paramx)
  {
    a.a(paramd, "Char array buffer");
    a.a(paramx, "Parser cursor");
    ArrayList localArrayList = new ArrayList();
    while (!paramx.d())
    {
      cz.msebera.android.httpclient.g localg = b(paramd, paramx);
      if ((localg.a().length() != 0) || (localg.b() != null)) {
        localArrayList.add(localg);
      }
    }
    return (cz.msebera.android.httpclient.g[])localArrayList.toArray(new cz.msebera.android.httpclient.g[localArrayList.size()]);
  }
  
  public cz.msebera.android.httpclient.g b(d paramd, x paramx)
  {
    a.a(paramd, "Char array buffer");
    a.a(paramx, "Parser cursor");
    ag localag = d(paramd, paramx);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!paramx.d())
    {
      localObject1 = localObject2;
      if (paramd.a(paramx.c() - 1) != ',') {
        localObject1 = c(paramd, paramx);
      }
    }
    return a(localag.a(), localag.b(), (ag[])localObject1);
  }
  
  public ag[] c(d paramd, x paramx)
  {
    a.a(paramd, "Char array buffer");
    a.a(paramx, "Parser cursor");
    int i = paramx.c();
    int j = paramx.b();
    while ((i < j) && (f.a(paramd.a(i)))) {
      i += 1;
    }
    paramx.a(i);
    if (paramx.d()) {
      return new ag[0];
    }
    ArrayList localArrayList = new ArrayList();
    do
    {
      if (paramx.d()) {
        break;
      }
      localArrayList.add(d(paramd, paramx));
    } while (paramd.a(paramx.c() - 1) != ',');
    return (ag[])localArrayList.toArray(new ag[localArrayList.size()]);
  }
  
  public ag d(d paramd, x paramx)
  {
    return a(paramd, paramx, e);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/k/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */