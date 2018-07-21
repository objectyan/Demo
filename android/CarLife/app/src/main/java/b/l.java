package b;

import b.a.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class l
{
  public static final l a = new a(true).a(h).a(new ag[] { ag.a, ag.b, ag.c, ag.d }).a(true).c();
  public static final l b = new a(a).a(new ag[] { ag.d }).a(true).c();
  public static final l c = new a(false).c();
  private static final i[] h = { i.aW, i.ba, i.aX, i.bb, i.bh, i.bg, i.ax, i.aH, i.ay, i.aI, i.af, i.ag, i.D, i.H, i.h };
  final boolean d;
  final boolean e;
  final String[] f;
  final String[] g;
  
  l(a parama)
  {
    this.d = parama.a;
    this.f = parama.b;
    this.g = parama.c;
    this.e = parama.d;
  }
  
  private static boolean a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((paramArrayOfString1 == null) || (paramArrayOfString2 == null) || (paramArrayOfString1.length == 0) || (paramArrayOfString2.length == 0)) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        if (c.a(paramArrayOfString2, paramArrayOfString1[i]) != -1) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private l b(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    String[] arrayOfString1;
    if (this.f != null)
    {
      arrayOfString1 = (String[])c.a(String.class, this.f, paramSSLSocket.getEnabledCipherSuites());
      if (this.g == null) {
        break label110;
      }
    }
    label110:
    for (String[] arrayOfString2 = (String[])c.a(String.class, this.g, paramSSLSocket.getEnabledProtocols());; arrayOfString2 = paramSSLSocket.getEnabledProtocols())
    {
      String[] arrayOfString3 = arrayOfString1;
      if (paramBoolean)
      {
        arrayOfString3 = arrayOfString1;
        if (c.a(paramSSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV") != -1) {
          arrayOfString3 = c.a(arrayOfString1, "TLS_FALLBACK_SCSV");
        }
      }
      return new a(this).a(arrayOfString3).b(arrayOfString2).c();
      arrayOfString1 = paramSSLSocket.getEnabledCipherSuites();
      break;
    }
  }
  
  void a(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    l locall = b(paramSSLSocket, paramBoolean);
    if (locall.g != null) {
      paramSSLSocket.setEnabledProtocols(locall.g);
    }
    if (locall.f != null) {
      paramSSLSocket.setEnabledCipherSuites(locall.f);
    }
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public boolean a(SSLSocket paramSSLSocket)
  {
    if (!this.d) {}
    while (((this.g != null) && (!a(this.g, paramSSLSocket.getEnabledProtocols()))) || ((this.f != null) && (!a(this.f, paramSSLSocket.getEnabledCipherSuites())))) {
      return false;
    }
    return true;
  }
  
  public List<i> b()
  {
    if (this.f == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(this.f.length);
    String[] arrayOfString = this.f;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(i.a(arrayOfString[i]));
      i += 1;
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public List<ag> c()
  {
    if (this.g == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(this.g.length);
    String[] arrayOfString = this.g;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(ag.a(arrayOfString[i]));
      i += 1;
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof l)) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
      paramObject = (l)paramObject;
    } while ((this.d != ((l)paramObject).d) || ((this.d) && ((!Arrays.equals(this.f, ((l)paramObject).f)) || (!Arrays.equals(this.g, ((l)paramObject).g)) || (this.e != ((l)paramObject).e))));
    return true;
  }
  
  public int hashCode()
  {
    int i = 17;
    int j;
    int k;
    if (this.d)
    {
      j = Arrays.hashCode(this.f);
      k = Arrays.hashCode(this.g);
      if (!this.e) {
        break label53;
      }
    }
    label53:
    for (i = 0;; i = 1)
    {
      i = ((j + 527) * 31 + k) * 31 + i;
      return i;
    }
  }
  
  public String toString()
  {
    if (!this.d) {
      return "ConnectionSpec()";
    }
    String str1;
    if (this.f != null)
    {
      str1 = b().toString();
      if (this.g == null) {
        break label92;
      }
    }
    label92:
    for (String str2 = c().toString();; str2 = "[all enabled]")
    {
      return "ConnectionSpec(cipherSuites=" + str1 + ", tlsVersions=" + str2 + ", supportsTlsExtensions=" + this.e + ")";
      str1 = "[all enabled]";
      break;
    }
  }
  
  public static final class a
  {
    boolean a;
    String[] b;
    String[] c;
    boolean d;
    
    public a(l paraml)
    {
      this.a = paraml.d;
      this.b = paraml.f;
      this.c = paraml.g;
      this.d = paraml.e;
    }
    
    a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    public a a()
    {
      if (!this.a) {
        throw new IllegalStateException("no cipher suites for cleartext connections");
      }
      this.b = null;
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      if (!this.a) {
        throw new IllegalStateException("no TLS extensions for cleartext connections");
      }
      this.d = paramBoolean;
      return this;
    }
    
    public a a(ag... paramVarArgs)
    {
      if (!this.a) {
        throw new IllegalStateException("no TLS versions for cleartext connections");
      }
      String[] arrayOfString = new String[paramVarArgs.length];
      int i = 0;
      while (i < paramVarArgs.length)
      {
        arrayOfString[i] = paramVarArgs[i].f;
        i += 1;
      }
      return b(arrayOfString);
    }
    
    public a a(i... paramVarArgs)
    {
      if (!this.a) {
        throw new IllegalStateException("no cipher suites for cleartext connections");
      }
      String[] arrayOfString = new String[paramVarArgs.length];
      int i = 0;
      while (i < paramVarArgs.length)
      {
        arrayOfString[i] = paramVarArgs[i].bi;
        i += 1;
      }
      return a(arrayOfString);
    }
    
    public a a(String... paramVarArgs)
    {
      if (!this.a) {
        throw new IllegalStateException("no cipher suites for cleartext connections");
      }
      if (paramVarArgs.length == 0) {
        throw new IllegalArgumentException("At least one cipher suite is required");
      }
      this.b = ((String[])paramVarArgs.clone());
      return this;
    }
    
    public a b()
    {
      if (!this.a) {
        throw new IllegalStateException("no TLS versions for cleartext connections");
      }
      this.c = null;
      return this;
    }
    
    public a b(String... paramVarArgs)
    {
      if (!this.a) {
        throw new IllegalStateException("no TLS versions for cleartext connections");
      }
      if (paramVarArgs.length == 0) {
        throw new IllegalArgumentException("At least one TLS version is required");
      }
      this.c = ((String[])paramVarArgs.clone());
      return this;
    }
    
    public l c()
    {
      return new l(this);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */