package com.indooratlas.android.sdk._internal;

import java.util.Arrays;
import javax.net.ssl.SSLSocket;

public final class fx
{
  public static final fx a;
  public static final fx b = new a(a).a(new gp[] { gp.c }).a().b();
  public static final fx c = new a(false).b();
  private static final fu[] g = { fu.aK, fu.aO, fu.W, fu.am, fu.al, fu.av, fu.aw, fu.F, fu.J, fu.U, fu.D, fu.H, fu.h };
  public final boolean d;
  final String[] e;
  final String[] f;
  private final boolean h;
  
  static
  {
    a locala = new a(true);
    fu[] arrayOffu = g;
    if (!locala.a) {
      throw new IllegalStateException("no cipher suites for cleartext connections");
    }
    String[] arrayOfString = new String[arrayOffu.length];
    int i = 0;
    while (i < arrayOffu.length)
    {
      arrayOfString[i] = arrayOffu[i].aS;
      i += 1;
    }
    a = locala.a(arrayOfString).a(new gp[] { gp.a, gp.b, gp.c }).a().b();
  }
  
  private fx(a parama)
  {
    this.h = parama.a;
    this.e = parama.b;
    this.f = parama.c;
    this.d = parama.d;
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
        if (gy.a(paramArrayOfString2, paramArrayOfString1[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public final boolean a(SSLSocket paramSSLSocket)
  {
    if (!this.h) {}
    while (((this.f != null) && (!a(this.f, paramSSLSocket.getEnabledProtocols()))) || ((this.e != null) && (!a(this.e, paramSSLSocket.getEnabledCipherSuites())))) {
      return false;
    }
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof fx)) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
      paramObject = (fx)paramObject;
    } while ((this.h != ((fx)paramObject).h) || ((this.h) && ((!Arrays.equals(this.e, ((fx)paramObject).e)) || (!Arrays.equals(this.f, ((fx)paramObject).f)) || (this.d != ((fx)paramObject).d))));
    return true;
  }
  
  public final int hashCode()
  {
    int i = 17;
    int j;
    int k;
    if (this.h)
    {
      j = Arrays.hashCode(this.e);
      k = Arrays.hashCode(this.f);
      if (!this.d) {
        break label53;
      }
    }
    label53:
    for (i = 0;; i = 1)
    {
      i += ((j + 527) * 31 + k) * 31;
      return i;
    }
  }
  
  public final String toString()
  {
    Object localObject2 = null;
    int j = 0;
    if (!this.h) {
      return "ConnectionSpec()";
    }
    Object localObject1;
    if (this.e != null) {
      if (this.e == null)
      {
        localObject1 = null;
        localObject1 = localObject1.toString();
        label36:
        if (this.f == null) {
          break label205;
        }
        if (this.f != null) {
          break label154;
        }
      }
    }
    label50:
    label154:
    label205:
    for (localObject2 = localObject2.toString();; localObject2 = "[all enabled]")
    {
      return "ConnectionSpec(cipherSuites=" + (String)localObject1 + ", tlsVersions=" + (String)localObject2 + ", supportsTlsExtensions=" + this.d + ")";
      localObject1 = new fu[this.e.length];
      int i = 0;
      while (i < this.e.length)
      {
        localObject1[i] = fu.a(this.e[i]);
        i += 1;
      }
      localObject1 = gy.a((Object[])localObject1);
      break;
      localObject1 = "[all enabled]";
      break label36;
      localObject2 = new gp[this.f.length];
      i = j;
      while (i < this.f.length)
      {
        localObject2[i] = gp.a(this.f[i]);
        i += 1;
      }
      localObject2 = gy.a((Object[])localObject2);
      break label50;
    }
  }
  
  public static final class a
  {
    boolean a;
    String[] b;
    String[] c;
    boolean d;
    
    public a(fx paramfx)
    {
      this.a = fx.a(paramfx);
      this.b = fx.b(paramfx);
      this.c = fx.c(paramfx);
      this.d = fx.d(paramfx);
    }
    
    a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    public final a a()
    {
      if (!this.a) {
        throw new IllegalStateException("no TLS extensions for cleartext connections");
      }
      this.d = true;
      return this;
    }
    
    public final a a(gp... paramVarArgs)
    {
      if (!this.a) {
        throw new IllegalStateException("no TLS versions for cleartext connections");
      }
      String[] arrayOfString = new String[paramVarArgs.length];
      int i = 0;
      while (i < paramVarArgs.length)
      {
        arrayOfString[i] = paramVarArgs[i].e;
        i += 1;
      }
      return b(arrayOfString);
    }
    
    public final a a(String... paramVarArgs)
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
    
    public final a b(String... paramVarArgs)
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
    
    public final fx b()
    {
      return new fx(this, (byte)0);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/fx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */