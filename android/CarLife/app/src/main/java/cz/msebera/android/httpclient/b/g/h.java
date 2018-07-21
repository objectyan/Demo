package cz.msebera.android.httpclient.b.g;

import cz.msebera.android.httpclient.ag;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.c;
import cz.msebera.android.httpclient.e.f.a;
import cz.msebera.android.httpclient.k.n;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@NotThreadSafe
public class h
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private int g;
  private String h;
  private String i;
  private String j;
  private List<ag> k;
  private String l;
  private String m;
  private String n;
  
  public h()
  {
    this.g = -1;
  }
  
  public h(String paramString)
    throws URISyntaxException
  {
    a(new URI(paramString));
  }
  
  public h(URI paramURI)
  {
    a(paramURI);
  }
  
  private List<ag> a(String paramString, Charset paramCharset)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return j.a(paramString, paramCharset);
    }
    return null;
  }
  
  private void a(URI paramURI)
  {
    this.a = paramURI.getScheme();
    this.b = paramURI.getRawSchemeSpecificPart();
    this.c = paramURI.getRawAuthority();
    this.f = paramURI.getHost();
    this.g = paramURI.getPort();
    this.e = paramURI.getRawUserInfo();
    this.d = paramURI.getUserInfo();
    this.i = paramURI.getRawPath();
    this.h = paramURI.getPath();
    this.j = paramURI.getRawQuery();
    this.k = a(paramURI.getRawQuery(), c.e);
    this.n = paramURI.getRawFragment();
    this.m = paramURI.getFragment();
  }
  
  private String c(List<ag> paramList)
  {
    return j.a(paramList, c.e);
  }
  
  private String h(String paramString)
  {
    return j.b(paramString, c.e);
  }
  
  private String i(String paramString)
  {
    return j.d(paramString, c.e);
  }
  
  private String j(String paramString)
  {
    return j.c(paramString, c.e);
  }
  
  private static String k(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i1 = 0;
    for (;;)
    {
      if ((i1 >= paramString.length()) || (paramString.charAt(i1) != '/'))
      {
        String str = paramString;
        if (i1 > 1) {
          str = paramString.substring(i1 - 1);
        }
        return str;
      }
      i1 += 1;
    }
  }
  
  private String m()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.a != null) {
      localStringBuilder.append(this.a).append(':');
    }
    if (this.b != null)
    {
      localStringBuilder.append(this.b);
      if (this.n == null) {
        break label345;
      }
      localStringBuilder.append("#").append(this.n);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (this.c != null)
      {
        localStringBuilder.append("//").append(this.c);
        label92:
        if (this.i == null) {
          break label263;
        }
        localStringBuilder.append(k(this.i));
      }
      for (;;)
      {
        if (this.j == null) {
          break label289;
        }
        localStringBuilder.append("?").append(this.j);
        break;
        if (this.f == null) {
          break label92;
        }
        localStringBuilder.append("//");
        if (this.e != null)
        {
          localStringBuilder.append(this.e).append("@");
          label170:
          if (!a.e(this.f)) {
            break label251;
          }
          localStringBuilder.append("[").append(this.f).append("]");
        }
        for (;;)
        {
          if (this.g < 0) {
            break label261;
          }
          localStringBuilder.append(":").append(this.g);
          break;
          if (this.d == null) {
            break label170;
          }
          localStringBuilder.append(h(this.d)).append("@");
          break label170;
          label251:
          localStringBuilder.append(this.f);
        }
        label261:
        break label92;
        label263:
        if (this.h != null) {
          localStringBuilder.append(i(k(this.h)));
        }
      }
      label289:
      if (this.k != null)
      {
        localStringBuilder.append("?").append(c(this.k));
        break;
      }
      if (this.l == null) {
        break;
      }
      localStringBuilder.append("?").append(j(this.l));
      break;
      label345:
      if (this.m != null) {
        localStringBuilder.append("#").append(j(this.m));
      }
    }
  }
  
  public h a(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = -1;
    }
    this.g = i1;
    this.b = null;
    this.c = null;
    return this;
  }
  
  public h a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public h a(String paramString1, String paramString2)
  {
    return b(paramString1 + ':' + paramString2);
  }
  
  public h a(List<ag> paramList)
  {
    if (this.k == null) {
      this.k = new ArrayList();
    }
    for (;;)
    {
      this.k.addAll(paramList);
      this.j = null;
      this.b = null;
      this.l = null;
      return this;
      this.k.clear();
    }
  }
  
  public h a(ag... paramVarArgs)
  {
    if (this.k == null) {
      this.k = new ArrayList();
    }
    for (;;)
    {
      int i2 = paramVarArgs.length;
      int i1 = 0;
      while (i1 < i2)
      {
        ag localag = paramVarArgs[i1];
        this.k.add(localag);
        i1 += 1;
      }
      this.k.clear();
    }
    this.j = null;
    this.b = null;
    this.l = null;
    return this;
  }
  
  public URI a()
    throws URISyntaxException
  {
    return new URI(m());
  }
  
  public h b()
  {
    this.k = null;
    this.l = null;
    this.j = null;
    this.b = null;
    return this;
  }
  
  public h b(String paramString)
  {
    this.d = paramString;
    this.b = null;
    this.c = null;
    this.e = null;
    return this;
  }
  
  public h b(String paramString1, String paramString2)
  {
    if (this.k == null) {
      this.k = new ArrayList();
    }
    this.k.add(new n(paramString1, paramString2));
    this.j = null;
    this.b = null;
    this.l = null;
    return this;
  }
  
  public h b(List<ag> paramList)
  {
    if (this.k == null) {
      this.k = new ArrayList();
    }
    this.k.addAll(paramList);
    this.j = null;
    this.b = null;
    this.l = null;
    return this;
  }
  
  public h c()
  {
    this.k = null;
    this.j = null;
    this.b = null;
    return this;
  }
  
  public h c(String paramString)
  {
    this.f = paramString;
    this.b = null;
    this.c = null;
    return this;
  }
  
  public h c(String paramString1, String paramString2)
  {
    if (this.k == null) {
      this.k = new ArrayList();
    }
    if (!this.k.isEmpty())
    {
      Iterator localIterator = this.k.iterator();
      while (localIterator.hasNext()) {
        if (((ag)localIterator.next()).a().equals(paramString1)) {
          localIterator.remove();
        }
      }
    }
    this.k.add(new n(paramString1, paramString2));
    this.j = null;
    this.b = null;
    this.l = null;
    return this;
  }
  
  public h d(String paramString)
  {
    this.h = paramString;
    this.b = null;
    this.i = null;
    return this;
  }
  
  public boolean d()
  {
    return this.a != null;
  }
  
  @Deprecated
  public h e(String paramString)
  {
    this.k = a(paramString, c.e);
    this.l = null;
    this.j = null;
    this.b = null;
    return this;
  }
  
  public boolean e()
  {
    return this.h == null;
  }
  
  public h f(String paramString)
  {
    this.l = paramString;
    this.j = null;
    this.b = null;
    this.k = null;
    return this;
  }
  
  public String f()
  {
    return this.a;
  }
  
  public h g(String paramString)
  {
    this.m = paramString;
    this.n = null;
    return this;
  }
  
  public String g()
  {
    return this.d;
  }
  
  public String h()
  {
    return this.f;
  }
  
  public int i()
  {
    return this.g;
  }
  
  public String j()
  {
    return this.h;
  }
  
  public List<ag> k()
  {
    if (this.k != null) {
      return new ArrayList(this.k);
    }
    return new ArrayList();
  }
  
  public String l()
  {
    return this.m;
  }
  
  public String toString()
  {
    return m();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/b/g/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */