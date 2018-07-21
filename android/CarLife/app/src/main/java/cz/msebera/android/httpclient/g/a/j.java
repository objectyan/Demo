package cz.msebera.android.httpclient.g.a;

import cz.msebera.android.httpclient.g.a.a.c;
import cz.msebera.android.httpclient.n;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class j
{
  private static final char[] a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  private static final String b = "form-data";
  private String c = "form-data";
  private e d = e.a;
  private String e = null;
  private Charset f = null;
  private List<b> g = null;
  
  public static j a()
  {
    return new j();
  }
  
  private String a(String paramString, Charset paramCharset)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("multipart/form-data; boundary=");
    localStringBuilder.append(paramString);
    if (paramCharset != null)
    {
      localStringBuilder.append("; charset=");
      localStringBuilder.append(paramCharset.name());
    }
    return localStringBuilder.toString();
  }
  
  private String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Random localRandom = new Random();
    int j = localRandom.nextInt(11);
    int i = 0;
    while (i < j + 30)
    {
      localStringBuilder.append(a[localRandom.nextInt(a.length)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  j a(b paramb)
  {
    if (paramb == null) {
      return this;
    }
    if (this.g == null) {
      this.g = new ArrayList();
    }
    this.g.add(paramb);
    return this;
  }
  
  public j a(e parame)
  {
    this.d = parame;
    return this;
  }
  
  public j a(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public j a(String paramString, c paramc)
  {
    cz.msebera.android.httpclient.o.a.a(paramString, "Name");
    cz.msebera.android.httpclient.o.a.a(paramc, "Content body");
    return a(new b(paramString, paramc));
  }
  
  public j a(String paramString, File paramFile)
  {
    cz.msebera.android.httpclient.g.g localg = cz.msebera.android.httpclient.g.g.n;
    if (paramFile != null) {}
    for (String str = paramFile.getName();; str = null) {
      return a(paramString, paramFile, localg, str);
    }
  }
  
  public j a(String paramString1, File paramFile, cz.msebera.android.httpclient.g.g paramg, String paramString2)
  {
    return a(paramString1, new cz.msebera.android.httpclient.g.a.a.e(paramFile, paramg, paramString2));
  }
  
  public j a(String paramString, InputStream paramInputStream)
  {
    return a(paramString, paramInputStream, cz.msebera.android.httpclient.g.g.n, null);
  }
  
  public j a(String paramString1, InputStream paramInputStream, cz.msebera.android.httpclient.g.g paramg, String paramString2)
  {
    return a(paramString1, new cz.msebera.android.httpclient.g.a.a.f(paramInputStream, paramg, paramString2));
  }
  
  public j a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, cz.msebera.android.httpclient.g.g.m);
  }
  
  public j a(String paramString1, String paramString2, cz.msebera.android.httpclient.g.g paramg)
  {
    return a(paramString1, new cz.msebera.android.httpclient.g.a.a.g(paramString2, paramg));
  }
  
  public j a(String paramString, byte[] paramArrayOfByte)
  {
    return a(paramString, paramArrayOfByte, cz.msebera.android.httpclient.g.g.n, null);
  }
  
  public j a(String paramString1, byte[] paramArrayOfByte, cz.msebera.android.httpclient.g.g paramg, String paramString2)
  {
    return a(paramString1, new cz.msebera.android.httpclient.g.a.a.b(paramArrayOfByte, paramg, paramString2));
  }
  
  public j a(Charset paramCharset)
  {
    this.f = paramCharset;
    return this;
  }
  
  public j b()
  {
    this.d = e.b;
    return this;
  }
  
  public j c()
  {
    this.d = e.a;
    return this;
  }
  
  k d()
  {
    Object localObject1;
    Charset localCharset;
    String str;
    label30:
    Object localObject2;
    label49:
    e locale;
    if (this.c != null)
    {
      localObject1 = this.c;
      localCharset = this.f;
      if (this.e == null) {
        break label131;
      }
      str = this.e;
      if (this.g == null) {
        break label139;
      }
      localObject2 = new ArrayList(this.g);
      if (this.d == null) {
        break label146;
      }
      locale = this.d;
      label62:
      switch (1.a[locale.ordinal()])
      {
      default: 
        localObject1 = new g((String)localObject1, localCharset, str, (List)localObject2);
      }
    }
    for (;;)
    {
      return new k((a)localObject1, a(str, localCharset), ((a)localObject1).e());
      localObject1 = "form-data";
      break;
      label131:
      str = f();
      break label30;
      label139:
      localObject2 = Collections.emptyList();
      break label49;
      label146:
      locale = e.a;
      break label62;
      localObject1 = new d((String)localObject1, localCharset, str, (List)localObject2);
      continue;
      localObject1 = new f((String)localObject1, localCharset, str, (List)localObject2);
    }
  }
  
  public n e()
  {
    return d();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/g/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */