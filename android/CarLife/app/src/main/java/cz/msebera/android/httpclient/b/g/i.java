package cz.msebera.android.httpclient.b.g;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.k;
import cz.msebera.android.httpclient.r;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Stack;

@Immutable
public class i
{
  @Deprecated
  public static URI a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
    throws URISyntaxException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString2 != null)
    {
      if (paramString1 != null)
      {
        localStringBuilder.append(paramString1);
        localStringBuilder.append("://");
      }
      localStringBuilder.append(paramString2);
      if (paramInt > 0)
      {
        localStringBuilder.append(':');
        localStringBuilder.append(paramInt);
      }
    }
    if ((paramString3 == null) || (!paramString3.startsWith("/"))) {
      localStringBuilder.append('/');
    }
    if (paramString3 != null) {
      localStringBuilder.append(paramString3);
    }
    if (paramString4 != null)
    {
      localStringBuilder.append('?');
      localStringBuilder.append(paramString4);
    }
    if (paramString5 != null)
    {
      localStringBuilder.append('#');
      localStringBuilder.append(paramString5);
    }
    return new URI(localStringBuilder.toString());
  }
  
  public static URI a(URI paramURI)
    throws URISyntaxException
  {
    a.a(paramURI, "URI");
    if (paramURI.isOpaque()) {
      return paramURI;
    }
    paramURI = new h(paramURI);
    if (paramURI.g() != null) {
      paramURI.b(null);
    }
    if (k.a(paramURI.j())) {
      paramURI.d("/");
    }
    if (paramURI.h() != null) {
      paramURI.c(paramURI.h().toLowerCase(Locale.ENGLISH));
    }
    paramURI.g(null);
    return paramURI.a();
  }
  
  public static URI a(URI paramURI, r paramr)
    throws URISyntaxException
  {
    return a(paramURI, paramr, false);
  }
  
  public static URI a(URI paramURI, r paramr, List<URI> paramList)
    throws URISyntaxException
  {
    a.a(paramURI, "Request URI");
    if ((paramList == null) || (paramList.isEmpty())) {}
    h localh;
    for (paramList = new h(paramURI);; paramList = localh)
    {
      if (paramList.l() == null) {
        paramList.g(paramURI.getFragment());
      }
      if ((paramr != null) && (!paramList.d()))
      {
        paramList.a(paramr.c());
        paramList.c(paramr.a());
        paramList.a(paramr.b());
      }
      return paramList.a();
      localh = new h((URI)paramList.get(paramList.size() - 1));
      String str = localh.l();
      int i = paramList.size() - 1;
      while ((str == null) && (i >= 0))
      {
        str = ((URI)paramList.get(i)).getFragment();
        i -= 1;
      }
      localh.g(str);
    }
  }
  
  public static URI a(URI paramURI, r paramr, boolean paramBoolean)
    throws URISyntaxException
  {
    a.a(paramURI, "URI");
    if (paramURI.isOpaque()) {
      return paramURI;
    }
    paramURI = new h(paramURI);
    if (paramr != null)
    {
      paramURI.a(paramr.c());
      paramURI.c(paramr.a());
      paramURI.a(paramr.b());
    }
    for (;;)
    {
      if (paramBoolean) {
        paramURI.g(null);
      }
      if (k.a(paramURI.j())) {
        paramURI.d("/");
      }
      return paramURI.a();
      paramURI.a(null);
      paramURI.c(null);
      paramURI.a(-1);
    }
  }
  
  public static URI a(URI paramURI, String paramString)
  {
    return a(paramURI, URI.create(paramString));
  }
  
  public static URI a(URI paramURI1, URI paramURI2)
  {
    a.a(paramURI1, "Base URI");
    a.a(paramURI2, "Reference URI");
    String str = paramURI2.toString();
    if (str.startsWith("?")) {
      return b(paramURI1, paramURI2);
    }
    if (str.length() == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramURI2 = URI.create("#");
      }
      paramURI2 = paramURI1.resolve(paramURI2);
      paramURI1 = paramURI2;
      if (i != 0)
      {
        paramURI1 = paramURI2.toString();
        paramURI1 = URI.create(paramURI1.substring(0, paramURI1.indexOf('#')));
      }
      return c(paramURI1);
    }
  }
  
  public static r b(URI paramURI)
  {
    if (paramURI == null) {}
    for (;;)
    {
      return null;
      if (!paramURI.isAbsolute()) {
        continue;
      }
      int j = paramURI.getPort();
      Object localObject2 = paramURI.getHost();
      Object localObject1 = localObject2;
      int i = j;
      int n;
      int m;
      int k;
      if (localObject2 == null)
      {
        String str = paramURI.getAuthority();
        localObject1 = str;
        i = j;
        if (str != null)
        {
          i = str.indexOf('@');
          localObject2 = str;
          if (i >= 0) {
            if (str.length() <= i + 1) {
              break label163;
            }
          }
          label163:
          for (localObject2 = str.substring(i + 1);; localObject2 = null)
          {
            localObject1 = localObject2;
            i = j;
            if (localObject2 == null) {
              break label200;
            }
            n = ((String)localObject2).indexOf(':');
            localObject1 = localObject2;
            i = j;
            if (n < 0) {
              break label200;
            }
            m = n + 1;
            k = 0;
            i = m;
            while ((i < ((String)localObject2).length()) && (Character.isDigit(((String)localObject2).charAt(i))))
            {
              k += 1;
              i += 1;
            }
          }
          i = j;
          if (k <= 0) {}
        }
      }
      try
      {
        i = Integer.parseInt(((String)localObject2).substring(m, m + k));
        localObject1 = ((String)localObject2).substring(0, n);
        label200:
        paramURI = paramURI.getScheme();
        if (k.b((CharSequence)localObject1)) {
          continue;
        }
        return new r((String)localObject1, i, paramURI);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          i = j;
        }
      }
    }
  }
  
  private static URI b(URI paramURI1, URI paramURI2)
  {
    String str = paramURI1.toString();
    paramURI1 = str;
    if (str.indexOf('?') > -1) {
      paramURI1 = str.substring(0, str.indexOf('?'));
    }
    return URI.create(paramURI1 + paramURI2.toString());
  }
  
  private static URI c(URI paramURI)
  {
    Object localObject1;
    if ((paramURI.isOpaque()) || (paramURI.getAuthority() == null)) {
      localObject1 = paramURI;
    }
    for (;;)
    {
      return (URI)localObject1;
      a.a(paramURI.isAbsolute(), "Base URI must be absolute");
      int i;
      label60:
      Object localObject4;
      if (paramURI.getPath() == null)
      {
        localObject1 = "";
        localObject3 = ((String)localObject1).split("/");
        localObject2 = new Stack();
        int j = localObject3.length;
        i = 0;
        if (i >= j) {
          break label142;
        }
        localObject4 = localObject3[i];
        if ((((String)localObject4).length() != 0) && (!".".equals(localObject4))) {
          break label104;
        }
      }
      for (;;)
      {
        i += 1;
        break label60;
        localObject1 = paramURI.getPath();
        break;
        label104:
        if ("..".equals(localObject4))
        {
          if (!((Stack)localObject2).isEmpty()) {
            ((Stack)localObject2).pop();
          }
        }
        else {
          ((Stack)localObject2).push(localObject4);
        }
      }
      label142:
      Object localObject3 = new StringBuilder();
      Object localObject2 = ((Stack)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (String)((Iterator)localObject2).next();
        ((StringBuilder)localObject3).append('/').append((String)localObject4);
      }
      if (((String)localObject1).lastIndexOf('/') == ((String)localObject1).length() - 1) {
        ((StringBuilder)localObject3).append('/');
      }
      try
      {
        localObject2 = new URI(paramURI.getScheme().toLowerCase(Locale.ENGLISH), paramURI.getAuthority().toLowerCase(Locale.ENGLISH), ((StringBuilder)localObject3).toString(), null, null);
        if (paramURI.getQuery() == null)
        {
          localObject1 = localObject2;
          if (paramURI.getFragment() == null) {
            continue;
          }
        }
        localObject1 = new StringBuilder(((URI)localObject2).toASCIIString());
        if (paramURI.getQuery() != null) {
          ((StringBuilder)localObject1).append('?').append(paramURI.getRawQuery());
        }
        if (paramURI.getFragment() != null) {
          ((StringBuilder)localObject1).append('#').append(paramURI.getRawFragment());
        }
        paramURI = URI.create(((StringBuilder)localObject1).toString());
        return paramURI;
      }
      catch (URISyntaxException paramURI)
      {
        throw new IllegalArgumentException(paramURI);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/b/g/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */