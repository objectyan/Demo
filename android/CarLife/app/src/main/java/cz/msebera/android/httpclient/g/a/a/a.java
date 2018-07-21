package cz.msebera.android.httpclient.g.a.a;

import cz.msebera.android.httpclient.g.g;
import java.nio.charset.Charset;

public abstract class a
  implements c
{
  private final g a;
  
  public a(g paramg)
  {
    cz.msebera.android.httpclient.o.a.a(paramg, "Content type");
    this.a = paramg;
  }
  
  @Deprecated
  public a(String paramString)
  {
    this(g.c(paramString));
  }
  
  public g a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.a.a();
  }
  
  public String c()
  {
    String str2 = this.a.a();
    int i = str2.indexOf('/');
    String str1 = str2;
    if (i != -1) {
      str1 = str2.substring(0, i);
    }
    return str1;
  }
  
  public String d()
  {
    String str = this.a.a();
    int i = str.indexOf('/');
    if (i != -1) {
      return str.substring(i + 1);
    }
    return null;
  }
  
  public String e()
  {
    Charset localCharset = this.a.b();
    if (localCharset != null) {
      return localCharset.name();
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/g/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */