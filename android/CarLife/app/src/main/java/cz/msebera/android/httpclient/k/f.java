package cz.msebera.android.httpclient.k;

import cz.msebera.android.httpclient.ag;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.g;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.d;

@Immutable
public class f
  implements t
{
  @Deprecated
  public static final f a = new f();
  public static final f b = new f();
  public static final String c = " ;,:@()<>\\\"/[]?={}\t";
  public static final String d = "\"\\";
  
  public static String a(ag paramag, boolean paramBoolean, t paramt)
  {
    if (paramt != null) {}
    for (;;)
    {
      return paramt.a(null, paramag, paramBoolean).toString();
      paramt = b;
    }
  }
  
  public static String a(g paramg, boolean paramBoolean, t paramt)
  {
    if (paramt != null) {}
    for (;;)
    {
      return paramt.a(null, paramg, paramBoolean).toString();
      paramt = b;
    }
  }
  
  public static String a(ag[] paramArrayOfag, boolean paramBoolean, t paramt)
  {
    if (paramt != null) {}
    for (;;)
    {
      return paramt.a(null, paramArrayOfag, paramBoolean).toString();
      paramt = b;
    }
  }
  
  public static String a(g[] paramArrayOfg, boolean paramBoolean, t paramt)
  {
    if (paramt != null) {}
    for (;;)
    {
      return paramt.a(null, paramArrayOfg, paramBoolean).toString();
      paramt = b;
    }
  }
  
  protected int a(ag paramag)
  {
    int i;
    if (paramag == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = paramag.a().length();
      paramag = paramag.b();
      i = j;
    } while (paramag == null);
    return j + (paramag.length() + 3);
  }
  
  protected int a(g paramg)
  {
    int j;
    if (paramg == null) {
      j = 0;
    }
    int i;
    int m;
    do
    {
      return j;
      j = paramg.a().length();
      String str = paramg.b();
      i = j;
      if (str != null) {
        i = j + (str.length() + 3);
      }
      m = paramg.d();
      j = i;
    } while (m <= 0);
    int k = 0;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      i += a(paramg.a(k)) + 2;
      k += 1;
    }
  }
  
  protected int a(ag[] paramArrayOfag)
  {
    int j = 0;
    int k;
    if ((paramArrayOfag == null) || (paramArrayOfag.length < 1))
    {
      k = 0;
      return k;
    }
    int i = (paramArrayOfag.length - 1) * 2;
    int m = paramArrayOfag.length;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      i += a(paramArrayOfag[j]);
      j += 1;
    }
  }
  
  protected int a(g[] paramArrayOfg)
  {
    int j = 0;
    int k;
    if ((paramArrayOfg == null) || (paramArrayOfg.length < 1))
    {
      k = 0;
      return k;
    }
    int i = (paramArrayOfg.length - 1) * 2;
    int m = paramArrayOfg.length;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      i += a(paramArrayOfg[j]);
      j += 1;
    }
  }
  
  public d a(d paramd, ag paramag, boolean paramBoolean)
  {
    a.a(paramag, "Name / value pair");
    int i = a(paramag);
    if (paramd == null) {
      paramd = new d(i);
    }
    for (;;)
    {
      paramd.a(paramag.a());
      paramag = paramag.b();
      if (paramag != null)
      {
        paramd.a('=');
        a(paramd, paramag, paramBoolean);
      }
      return paramd;
      paramd.b(i);
    }
  }
  
  public d a(d paramd, g paramg, boolean paramBoolean)
  {
    a.a(paramg, "Header element");
    int i = a(paramg);
    if (paramd == null) {
      paramd = new d(i);
    }
    for (;;)
    {
      paramd.a(paramg.a());
      String str = paramg.b();
      if (str != null)
      {
        paramd.a('=');
        a(paramd, str, paramBoolean);
      }
      int j = paramg.d();
      if (j <= 0) {
        break;
      }
      i = 0;
      while (i < j)
      {
        paramd.a("; ");
        a(paramd, paramg.a(i), paramBoolean);
        i += 1;
      }
      paramd.b(i);
    }
    return paramd;
  }
  
  public d a(d paramd, ag[] paramArrayOfag, boolean paramBoolean)
  {
    a.a(paramArrayOfag, "Header parameter array");
    int i = a(paramArrayOfag);
    if (paramd == null) {
      paramd = new d(i);
    }
    for (;;)
    {
      i = 0;
      while (i < paramArrayOfag.length)
      {
        if (i > 0) {
          paramd.a("; ");
        }
        a(paramd, paramArrayOfag[i], paramBoolean);
        i += 1;
      }
      paramd.b(i);
    }
    return paramd;
  }
  
  public d a(d paramd, g[] paramArrayOfg, boolean paramBoolean)
  {
    a.a(paramArrayOfg, "Header element array");
    int i = a(paramArrayOfg);
    if (paramd == null) {
      paramd = new d(i);
    }
    for (;;)
    {
      i = 0;
      while (i < paramArrayOfg.length)
      {
        if (i > 0) {
          paramd.a(", ");
        }
        a(paramd, paramArrayOfg[i], paramBoolean);
        i += 1;
      }
      paramd.b(i);
    }
    return paramd;
  }
  
  protected void a(d paramd, String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      i = 0;
      for (;;)
      {
        bool = paramBoolean;
        if (i >= paramString.length()) {
          break;
        }
        bool = paramBoolean;
        if (paramBoolean) {
          break;
        }
        paramBoolean = a(paramString.charAt(i));
        i += 1;
      }
    }
    if (bool) {
      paramd.a('"');
    }
    int i = 0;
    while (i < paramString.length())
    {
      char c1 = paramString.charAt(i);
      if (b(c1)) {
        paramd.a('\\');
      }
      paramd.a(c1);
      i += 1;
    }
    if (bool) {
      paramd.a('"');
    }
  }
  
  protected boolean a(char paramChar)
  {
    return " ;,:@()<>\\\"/[]?={}\t".indexOf(paramChar) >= 0;
  }
  
  protected boolean b(char paramChar)
  {
    return "\"\\".indexOf(paramChar) >= 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/k/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */