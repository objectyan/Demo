package b;

import b.a.c;
import b.a.i.b;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

public final class g
{
  public static final g a = new a().a();
  private final Set<b> b;
  private final b c;
  
  g(Set<b> paramSet, b paramb)
  {
    this.b = paramSet;
    this.c = paramb;
  }
  
  public static String a(Certificate paramCertificate)
  {
    if (!(paramCertificate instanceof X509Certificate)) {
      throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }
    return "sha256/" + b((X509Certificate)paramCertificate).base64();
  }
  
  static ByteString a(X509Certificate paramX509Certificate)
  {
    return ByteString.of(paramX509Certificate.getPublicKey().getEncoded()).sha1();
  }
  
  static ByteString b(X509Certificate paramX509Certificate)
  {
    return ByteString.of(paramX509Certificate.getPublicKey().getEncoded()).sha256();
  }
  
  g a(b paramb)
  {
    if (c.a(this.c, paramb)) {
      return this;
    }
    return new g(this.b, paramb);
  }
  
  List<b> a(String paramString)
  {
    Object localObject1 = Collections.emptyList();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.a(paramString))
      {
        Object localObject2 = localObject1;
        if (((List)localObject1).isEmpty()) {
          localObject2 = new ArrayList();
        }
        ((List)localObject2).add(localb);
        localObject1 = localObject2;
      }
    }
    return (List<b>)localObject1;
  }
  
  public void a(String paramString, List<Certificate> paramList)
    throws SSLPeerUnverifiedException
  {
    List localList = a(paramString);
    if (localList.isEmpty()) {
      return;
    }
    Object localObject3 = paramList;
    if (this.c != null) {
      localObject3 = this.c.a(paramList, paramString);
    }
    int i = 0;
    int k = ((List)localObject3).size();
    Object localObject1;
    for (;;)
    {
      if (i >= k) {
        break label221;
      }
      X509Certificate localX509Certificate = (X509Certificate)((List)localObject3).get(i);
      localObject1 = null;
      paramList = null;
      j = 0;
      int m = localList.size();
      if (j < m)
      {
        b localb = (b)localList.get(j);
        Object localObject2;
        if (localb.c.equals("sha256/"))
        {
          localObject2 = paramList;
          if (paramList == null) {
            localObject2 = b(localX509Certificate);
          }
          if (localb.d.equals(localObject2)) {
            break;
          }
          paramList = (List<Certificate>)localObject2;
        }
        do
        {
          j += 1;
          break;
          if (!localb.c.equals("sha1/")) {
            break label206;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = a(localX509Certificate);
          }
          localObject1 = localObject2;
        } while (!localb.d.equals(localObject2));
        return;
        label206:
        throw new AssertionError();
      }
      i += 1;
    }
    label221:
    paramList = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
    i = 0;
    int j = ((List)localObject3).size();
    while (i < j)
    {
      localObject1 = (X509Certificate)((List)localObject3).get(i);
      paramList.append("\n    ").append(a((Certificate)localObject1)).append(": ").append(((X509Certificate)localObject1).getSubjectDN().getName());
      i += 1;
    }
    paramList.append("\n  Pinned certificates for ").append(paramString).append(":");
    i = 0;
    j = localList.size();
    while (i < j)
    {
      paramString = (b)localList.get(i);
      paramList.append("\n    ").append(paramString);
      i += 1;
    }
    throw new SSLPeerUnverifiedException(paramList.toString());
  }
  
  public void a(String paramString, Certificate... paramVarArgs)
    throws SSLPeerUnverifiedException
  {
    a(paramString, Arrays.asList(paramVarArgs));
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (((paramObject instanceof g)) && (c.a(this.c, ((g)paramObject).c)) && (this.b.equals(((g)paramObject).b))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int hashCode()
  {
    if (this.c != null) {}
    for (int i = this.c.hashCode();; i = 0) {
      return i * 31 + this.b.hashCode();
    }
  }
  
  public static final class a
  {
    private final List<g.b> a = new ArrayList();
    
    public a a(String paramString, String... paramVarArgs)
    {
      if (paramString == null) {
        throw new NullPointerException("pattern == null");
      }
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        this.a.add(new g.b(paramString, str));
        i += 1;
      }
      return this;
    }
    
    public g a()
    {
      return new g(new LinkedHashSet(this.a), null);
    }
  }
  
  static final class b
  {
    private static final String e = "*.";
    final String a;
    final String b;
    final String c;
    final ByteString d;
    
    b(String paramString1, String paramString2)
    {
      this.a = paramString1;
      if (paramString1.startsWith("*."))
      {
        paramString1 = u.g("http://" + paramString1.substring("*.".length())).i();
        this.b = paramString1;
        if (!paramString2.startsWith("sha1/")) {
          break label151;
        }
        this.c = "sha1/";
        this.d = ByteString.decodeBase64(paramString2.substring("sha1/".length()));
      }
      for (;;)
      {
        if (this.d == null)
        {
          throw new IllegalArgumentException("pins must be base64: " + paramString2);
          paramString1 = u.g("http://" + paramString1).i();
          break;
          label151:
          if (paramString2.startsWith("sha256/"))
          {
            this.c = "sha256/";
            this.d = ByteString.decodeBase64(paramString2.substring("sha256/".length()));
          }
          else
          {
            throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + paramString2);
          }
        }
      }
    }
    
    boolean a(String paramString)
    {
      if (this.a.startsWith("*.")) {
        return paramString.regionMatches(false, paramString.indexOf('.') + 1, this.b, 0, this.b.length());
      }
      return paramString.equals(this.b);
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof b)) && (this.a.equals(((b)paramObject).a)) && (this.c.equals(((b)paramObject).c)) && (this.d.equals(((b)paramObject).d));
    }
    
    public int hashCode()
    {
      return ((this.a.hashCode() + 527) * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
    }
    
    public String toString()
    {
      return this.c + this.d.base64();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */