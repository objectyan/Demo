package cz.msebera.android.httpclient.i.a;

import cz.msebera.android.httpclient.a.j;
import cz.msebera.android.httpclient.a.l;
import cz.msebera.android.httpclient.a.p;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.c;
import cz.msebera.android.httpclient.k.r;
import cz.msebera.android.httpclient.u;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

@NotThreadSafe
public class d
  extends m
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final int c = -1;
  private static final int d = 0;
  private static final int e = 1;
  private static final int f = 2;
  private boolean b;
  private String g;
  private long h;
  private String i;
  private String j;
  private String k;
  
  public d()
  {
    this(c.f);
  }
  
  @Deprecated
  public d(l paraml)
  {
    super(paraml);
  }
  
  public d(Charset paramCharset)
  {
    super(paramCharset);
    this.b = false;
  }
  
  static String a(byte[] paramArrayOfByte)
  {
    int n = paramArrayOfByte.length;
    char[] arrayOfChar = new char[n * 2];
    int m = 0;
    while (m < n)
    {
      int i1 = paramArrayOfByte[m];
      int i2 = paramArrayOfByte[m];
      arrayOfChar[(m * 2)] = a[((i2 & 0xF0) >> 4)];
      arrayOfChar[(m * 2 + 1)] = a[(i1 & 0xF)];
      m += 1;
    }
    return new String(arrayOfChar);
  }
  
  private cz.msebera.android.httpclient.f b(cz.msebera.android.httpclient.a.n paramn, u paramu)
    throws j
  {
    String str2 = a("uri");
    String str3 = a("realm");
    String str4 = a("nonce");
    String str1 = a("opaque");
    String str5 = a("methodname");
    Object localObject2 = a("algorithm");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "MD5";
    }
    HashSet localHashSet = new HashSet(8);
    int m = -1;
    localObject2 = a("qop");
    if (localObject2 != null)
    {
      localObject3 = new StringTokenizer((String)localObject2, ",");
      while (((StringTokenizer)localObject3).hasMoreTokens()) {
        localHashSet.add(((StringTokenizer)localObject3).nextToken().trim().toLowerCase(Locale.ENGLISH));
      }
      if (((paramu instanceof cz.msebera.android.httpclient.o)) && (localHashSet.contains("auth-int"))) {
        m = 1;
      }
    }
    while (m == -1)
    {
      throw new j("None of the qop methods is supported: " + (String)localObject2);
      if (localHashSet.contains("auth"))
      {
        m = 2;
        continue;
        m = 0;
      }
    }
    Object localObject3 = a("charset");
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "ISO-8859-1";
    }
    Object localObject4 = localObject1;
    localObject3 = localObject4;
    if (((String)localObject4).equalsIgnoreCase("MD5-sess")) {
      localObject3 = "MD5";
    }
    for (;;)
    {
      MessageDigest localMessageDigest;
      StringBuilder localStringBuilder;
      String str6;
      int n;
      boolean bool;
      try
      {
        localMessageDigest = b((String)localObject3);
        localObject4 = paramn.a().getName();
        paramn = paramn.b();
        if (str4.equals(this.g))
        {
          this.h += 1L;
          localStringBuilder = new StringBuilder(256);
          localObject3 = new Formatter(localStringBuilder, Locale.US);
          ((Formatter)localObject3).format("%08x", new Object[] { Long.valueOf(this.h) });
          ((Formatter)localObject3).close();
          localObject3 = localStringBuilder.toString();
          if (this.i == null) {
            this.i = j();
          }
          this.j = null;
          this.k = null;
          if (!((String)localObject1).equalsIgnoreCase("MD5-sess")) {
            break label1026;
          }
          localStringBuilder.setLength(0);
          localStringBuilder.append((String)localObject4).append(':').append(str3).append(':').append(paramn);
          paramn = a(localMessageDigest.digest(cz.msebera.android.httpclient.o.f.a(localStringBuilder.toString(), (String)localObject2)));
          localStringBuilder.setLength(0);
          localStringBuilder.append(paramn).append(':').append(str4).append(':').append(this.i);
          this.j = localStringBuilder.toString();
          str6 = a(localMessageDigest.digest(cz.msebera.android.httpclient.o.f.a(this.j, (String)localObject2)));
          if (m != 2) {
            break label1071;
          }
          this.k = (str5 + ':' + str2);
          paramu = a(localMessageDigest.digest(cz.msebera.android.httpclient.o.f.a(this.k, (String)localObject2)));
          if (m != 0) {
            break label1282;
          }
          localStringBuilder.setLength(0);
          localStringBuilder.append(str6).append(':').append(str4).append(':').append(paramu);
          paramn = localStringBuilder.toString();
          paramn = a(localMessageDigest.digest(cz.msebera.android.httpclient.o.f.a(paramn)));
          paramu = new cz.msebera.android.httpclient.o.d(128);
          if (!e()) {
            break label1373;
          }
          paramu.a("Proxy-Authorization");
          paramu.a(": Digest ");
          localObject2 = new ArrayList(20);
          ((List)localObject2).add(new cz.msebera.android.httpclient.k.n("username", (String)localObject4));
          ((List)localObject2).add(new cz.msebera.android.httpclient.k.n("realm", str3));
          ((List)localObject2).add(new cz.msebera.android.httpclient.k.n("nonce", str4));
          ((List)localObject2).add(new cz.msebera.android.httpclient.k.n("uri", str2));
          ((List)localObject2).add(new cz.msebera.android.httpclient.k.n("response", paramn));
          if (m != 0)
          {
            if (m != 1) {
              break label1383;
            }
            paramn = "auth-int";
            ((List)localObject2).add(new cz.msebera.android.httpclient.k.n("qop", paramn));
            ((List)localObject2).add(new cz.msebera.android.httpclient.k.n("nc", (String)localObject3));
            ((List)localObject2).add(new cz.msebera.android.httpclient.k.n("cnonce", this.i));
          }
          ((List)localObject2).add(new cz.msebera.android.httpclient.k.n("algorithm", (String)localObject1));
          if (str1 != null) {
            ((List)localObject2).add(new cz.msebera.android.httpclient.k.n("opaque", str1));
          }
          m = 0;
          if (m >= ((List)localObject2).size()) {
            break;
          }
          paramn = (cz.msebera.android.httpclient.k.n)((List)localObject2).get(m);
          if (m > 0) {
            paramu.a(", ");
          }
          localObject1 = paramn.a();
          if ((!"nc".equals(localObject1)) && (!"qop".equals(localObject1)) && (!"algorithm".equals(localObject1))) {
            break label1389;
          }
          n = 1;
          localObject1 = cz.msebera.android.httpclient.k.f.b;
          if (n != 0) {
            break label1395;
          }
          bool = true;
          ((cz.msebera.android.httpclient.k.f)localObject1).a(paramu, paramn, bool);
          m += 1;
          continue;
        }
        this.h = 1L;
      }
      catch (o paramn)
      {
        throw new j("Unsuppported digest algorithm: " + (String)localObject3);
      }
      this.i = null;
      this.g = str4;
      continue;
      label1026:
      localStringBuilder.setLength(0);
      localStringBuilder.append((String)localObject4).append(':').append(str3).append(':').append(paramn);
      this.j = localStringBuilder.toString();
      continue;
      label1071:
      if (m == 1)
      {
        paramn = null;
        if ((paramu instanceof cz.msebera.android.httpclient.o)) {
          paramn = ((cz.msebera.android.httpclient.o)paramu).getEntity();
        }
        if ((paramn != null) && (!paramn.isRepeatable()))
        {
          if (localHashSet.contains("auth"))
          {
            m = 2;
            this.k = (str5 + ':' + str2);
          }
          else
          {
            throw new j("Qop auth-int cannot be used with a non-repeatable entity");
          }
        }
        else
        {
          paramu = new g(localMessageDigest);
          if (paramn != null) {}
          try
          {
            paramn.writeTo(paramu);
            paramu.close();
            this.k = (str5 + ':' + str2 + ':' + a(paramu.a()));
          }
          catch (IOException paramn)
          {
            throw new j("I/O error reading entity content", paramn);
          }
        }
      }
      else
      {
        this.k = (str5 + ':' + str2);
        continue;
        label1282:
        localStringBuilder.setLength(0);
        localObject2 = localStringBuilder.append(str6).append(':').append(str4).append(':').append((String)localObject3).append(':').append(this.i).append(':');
        if (m == 1) {}
        for (paramn = "auth-int";; paramn = "auth")
        {
          ((StringBuilder)localObject2).append(paramn).append(':').append(paramu);
          paramn = localStringBuilder.toString();
          break;
        }
        label1373:
        paramu.a("Authorization");
        continue;
        label1383:
        paramn = "auth";
        continue;
        label1389:
        n = 0;
        continue;
        label1395:
        bool = false;
      }
    }
    return new r(paramu);
  }
  
  private static MessageDigest b(String paramString)
    throws o
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
      return localMessageDigest;
    }
    catch (Exception localException)
    {
      throw new o("Unsupported algorithm in HTTP Digest authentication: " + paramString);
    }
  }
  
  public static String j()
  {
    SecureRandom localSecureRandom = new SecureRandom();
    byte[] arrayOfByte = new byte[8];
    localSecureRandom.nextBytes(arrayOfByte);
    return a(arrayOfByte);
  }
  
  @Deprecated
  public cz.msebera.android.httpclient.f a(cz.msebera.android.httpclient.a.n paramn, u paramu)
    throws j
  {
    return a(paramn, paramu, new cz.msebera.android.httpclient.n.a());
  }
  
  public cz.msebera.android.httpclient.f a(cz.msebera.android.httpclient.a.n paramn, u paramu, cz.msebera.android.httpclient.n.g paramg)
    throws j
  {
    cz.msebera.android.httpclient.o.a.a(paramn, "Credentials");
    cz.msebera.android.httpclient.o.a.a(paramu, "HTTP request");
    if (a("realm") == null) {
      throw new j("missing realm in challenge");
    }
    if (a("nonce") == null) {
      throw new j("missing nonce in challenge");
    }
    l().put("methodname", paramu.getRequestLine().a());
    l().put("uri", paramu.getRequestLine().c());
    if (a("charset") == null) {
      l().put("charset", a(paramu));
    }
    return b(paramn, paramu);
  }
  
  public String a()
  {
    return "digest";
  }
  
  public void a(cz.msebera.android.httpclient.f paramf)
    throws p
  {
    super.a(paramf);
    this.b = true;
  }
  
  public void a(String paramString1, String paramString2)
  {
    l().put(paramString1, paramString2);
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean d()
  {
    if ("true".equalsIgnoreCase(a("stale"))) {
      return false;
    }
    return this.b;
  }
  
  String g()
  {
    return this.i;
  }
  
  String h()
  {
    return this.j;
  }
  
  String i()
  {
    return this.k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DIGEST [complete=").append(this.b).append(", nonce=").append(this.g).append(", nc=").append(this.h).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */