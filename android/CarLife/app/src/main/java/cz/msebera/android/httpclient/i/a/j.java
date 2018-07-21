package cz.msebera.android.httpclient.i.a;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.h.a;
import cz.msebera.android.httpclient.o.f;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

@NotThreadSafe
final class j
  implements h
{
  protected static final int a = 1;
  protected static final int b = 4;
  protected static final int c = 16;
  protected static final int d = 32;
  protected static final int e = 128;
  protected static final int f = 512;
  protected static final int g = 4096;
  protected static final int h = 8192;
  protected static final int i = 32768;
  protected static final int j = 524288;
  protected static final int k = 33554432;
  protected static final int l = 8388608;
  protected static final int m = 536870912;
  protected static final int n = 1073741824;
  protected static final int o = Integer.MIN_VALUE;
  static final String p = "ASCII";
  private static final SecureRandom q;
  private static final byte[] s;
  private String r = "ASCII";
  
  static
  {
    Object localObject = null;
    try
    {
      SecureRandom localSecureRandom = SecureRandom.getInstance("SHA1PRNG");
      localObject = localSecureRandom;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    q = (SecureRandom)localObject;
    localObject = f.a("NTLMSSP", "ASCII");
    s = new byte[localObject.length + 1];
    System.arraycopy(localObject, 0, s, 0, localObject.length);
    s[localObject.length] = 0;
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 << paramInt2 | paramInt1 >>> 32 - paramInt2;
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt2 | (paramInt1 ^ 0xFFFFFFFF) & paramInt3;
  }
  
  private static void a(byte[] paramArrayOfByte)
  {
    int i1 = 0;
    if (i1 < paramArrayOfByte.length)
    {
      int i2 = paramArrayOfByte[i1];
      if (((i2 >>> 7 ^ i2 >>> 6 ^ i2 >>> 5 ^ i2 >>> 4 ^ i2 >>> 3 ^ i2 >>> 2 ^ i2 >>> 1) & 0x1) == 0)
      {
        i2 = 1;
        label48:
        if (i2 == 0) {
          break label73;
        }
        paramArrayOfByte[i1] = ((byte)(paramArrayOfByte[i1] | 0x1));
      }
      for (;;)
      {
        i1 += 1;
        break;
        i2 = 0;
        break label48;
        label73:
        paramArrayOfByte[i1] = ((byte)(paramArrayOfByte[i1] & 0xFFFFFFFE));
      }
    }
  }
  
  static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 & 0xFF));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 8 & 0xFF));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 16 & 0xFF));
    paramArrayOfByte[(paramInt2 + 3)] = ((byte)(paramInt1 >> 24 & 0xFF));
  }
  
  static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws i
  {
    paramArrayOfByte2 = new b(paramArrayOfByte2);
    paramArrayOfByte2.a(paramArrayOfByte1);
    return paramArrayOfByte2.a();
  }
  
  static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
    throws i
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte2);
      localMessageDigest.update(paramArrayOfByte3);
      paramArrayOfByte2 = localMessageDigest.digest();
      paramArrayOfByte3 = new byte[8];
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, 0, 8);
      paramArrayOfByte1 = d(paramArrayOfByte1, paramArrayOfByte3);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      if ((paramArrayOfByte1 instanceof i)) {
        throw ((i)paramArrayOfByte1);
      }
      throw new i(paramArrayOfByte1.getMessage(), paramArrayOfByte1);
    }
  }
  
  static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt2 | paramInt1 & paramInt3 | paramInt2 & paramInt3;
  }
  
  static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws i
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramArrayOfByte2, "RC4"));
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      throw new i(paramArrayOfByte1.getMessage(), paramArrayOfByte1);
    }
  }
  
  static int c(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 ^ paramInt2 ^ paramInt3;
  }
  
  private static byte[] c(String paramString1, String paramString2, byte[] paramArrayOfByte)
    throws i
  {
    try
    {
      paramArrayOfByte = new b(paramArrayOfByte);
      paramArrayOfByte.a(paramString2.toUpperCase(Locale.ENGLISH).getBytes("UnicodeLittleUnmarked"));
      if (paramString1 != null) {
        paramArrayOfByte.a(paramString1.toUpperCase(Locale.ENGLISH).getBytes("UnicodeLittleUnmarked"));
      }
      paramString1 = paramArrayOfByte.a();
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new i("Unicode not supported! " + paramString1.getMessage(), paramString1);
    }
  }
  
  private static byte[] d(String paramString1, String paramString2, byte[] paramArrayOfByte)
    throws i
  {
    try
    {
      paramArrayOfByte = new b(paramArrayOfByte);
      paramArrayOfByte.a(paramString2.toUpperCase(Locale.ENGLISH).getBytes("UnicodeLittleUnmarked"));
      if (paramString1 != null) {
        paramArrayOfByte.a(paramString1.getBytes("UnicodeLittleUnmarked"));
      }
      paramString1 = paramArrayOfByte.a();
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new i("Unicode not supported! " + paramString1.getMessage(), paramString1);
    }
  }
  
  private static byte[] d(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws i
  {
    try
    {
      Object localObject2 = new byte[21];
      System.arraycopy(paramArrayOfByte1, 0, localObject2, 0, 16);
      paramArrayOfByte1 = h((byte[])localObject2, 0);
      Object localObject1 = h((byte[])localObject2, 7);
      localObject2 = h((byte[])localObject2, 14);
      Cipher localCipher = Cipher.getInstance("DES/ECB/NoPadding");
      localCipher.init(1, paramArrayOfByte1);
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte2);
      localCipher.init(1, (Key)localObject1);
      localObject1 = localCipher.doFinal(paramArrayOfByte2);
      localCipher.init(1, (Key)localObject2);
      paramArrayOfByte2 = localCipher.doFinal(paramArrayOfByte2);
      localObject2 = new byte[24];
      System.arraycopy(paramArrayOfByte1, 0, localObject2, 0, 8);
      System.arraycopy(localObject1, 0, localObject2, 8, 8);
      System.arraycopy(paramArrayOfByte2, 0, localObject2, 16, 8);
      return (byte[])localObject2;
    }
    catch (Exception paramArrayOfByte1)
    {
      throw new i(paramArrayOfByte1.getMessage(), paramArrayOfByte1);
    }
  }
  
  private static byte[] d(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
    throws i
  {
    paramArrayOfByte1 = new b(paramArrayOfByte1);
    paramArrayOfByte1.a(paramArrayOfByte2);
    paramArrayOfByte1.a(paramArrayOfByte3);
    paramArrayOfByte1 = paramArrayOfByte1.a();
    paramArrayOfByte2 = new byte[paramArrayOfByte1.length + paramArrayOfByte3.length];
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte2, paramArrayOfByte1.length, paramArrayOfByte3.length);
    return paramArrayOfByte2;
  }
  
  private static int e(byte[] paramArrayOfByte, int paramInt)
    throws i
  {
    if (paramArrayOfByte.length < paramInt + 4) {
      throw new i("NTLM authentication - buffer too small for DWORD");
    }
    return paramArrayOfByte[paramInt] & 0xFF | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24;
  }
  
  private static byte[] e()
    throws i
  {
    if (q == null) {
      throw new i("Random generator not available");
    }
    byte[] arrayOfByte = new byte[8];
    synchronized (q)
    {
      q.nextBytes(arrayOfByte);
      return arrayOfByte;
    }
  }
  
  private static byte[] e(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    byte[] arrayOfByte1 = new byte[4];
    byte[] tmp7_5 = arrayOfByte1;
    tmp7_5[0] = 1;
    byte[] tmp12_7 = tmp7_5;
    tmp12_7[1] = 1;
    byte[] tmp17_12 = tmp12_7;
    tmp17_12[2] = 0;
    byte[] tmp22_17 = tmp17_12;
    tmp22_17[3] = 0;
    tmp22_17;
    byte[] arrayOfByte2 = new byte[4];
    byte[] tmp35_33 = arrayOfByte2;
    tmp35_33[0] = 0;
    byte[] tmp40_35 = tmp35_33;
    tmp40_35[1] = 0;
    byte[] tmp45_40 = tmp40_35;
    tmp45_40[2] = 0;
    byte[] tmp50_45 = tmp45_40;
    tmp50_45[3] = 0;
    tmp50_45;
    byte[] arrayOfByte3 = new byte[4];
    byte[] tmp63_61 = arrayOfByte3;
    tmp63_61[0] = 0;
    byte[] tmp68_63 = tmp63_61;
    tmp68_63[1] = 0;
    byte[] tmp73_68 = tmp68_63;
    tmp73_68[2] = 0;
    byte[] tmp78_73 = tmp73_68;
    tmp78_73[3] = 0;
    tmp78_73;
    byte[] arrayOfByte4 = new byte[4];
    byte[] tmp91_89 = arrayOfByte4;
    tmp91_89[0] = 0;
    byte[] tmp96_91 = tmp91_89;
    tmp96_91[1] = 0;
    byte[] tmp101_96 = tmp96_91;
    tmp101_96[2] = 0;
    byte[] tmp106_101 = tmp101_96;
    tmp106_101[3] = 0;
    tmp106_101;
    byte[] arrayOfByte5 = new byte[arrayOfByte1.length + arrayOfByte2.length + paramArrayOfByte3.length + 8 + arrayOfByte3.length + paramArrayOfByte2.length + arrayOfByte4.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte5, 0, arrayOfByte1.length);
    int i1 = 0 + arrayOfByte1.length;
    System.arraycopy(arrayOfByte2, 0, arrayOfByte5, i1, arrayOfByte2.length);
    i1 += arrayOfByte2.length;
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte5, i1, paramArrayOfByte3.length);
    i1 += paramArrayOfByte3.length;
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte5, i1, 8);
    i1 += 8;
    System.arraycopy(arrayOfByte3, 0, arrayOfByte5, i1, arrayOfByte3.length);
    i1 += arrayOfByte3.length;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte5, i1, paramArrayOfByte2.length);
    i1 += paramArrayOfByte2.length;
    System.arraycopy(arrayOfByte4, 0, arrayOfByte5, i1, arrayOfByte4.length);
    i1 = arrayOfByte4.length;
    return arrayOfByte5;
  }
  
  private static int f(byte[] paramArrayOfByte, int paramInt)
    throws i
  {
    if (paramArrayOfByte.length < paramInt + 2) {
      throw new i("NTLM authentication - buffer too small for WORD");
    }
    return paramArrayOfByte[paramInt] & 0xFF | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8;
  }
  
  private static String f(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    int i1;
    do
    {
      return str;
      i1 = paramString.indexOf(".");
      str = paramString;
    } while (i1 == -1);
    return paramString.substring(0, i1);
  }
  
  private static byte[] f()
    throws i
  {
    if (q == null) {
      throw new i("Random generator not available");
    }
    byte[] arrayOfByte = new byte[16];
    synchronized (q)
    {
      q.nextBytes(arrayOfByte);
      return arrayOfByte;
    }
  }
  
  private static String g(String paramString)
  {
    return f(paramString);
  }
  
  private static byte[] g(byte[] paramArrayOfByte, int paramInt)
    throws i
  {
    int i1 = f(paramArrayOfByte, paramInt);
    paramInt = e(paramArrayOfByte, paramInt + 4);
    if (paramArrayOfByte.length < paramInt + i1) {
      throw new i("NTLM authentication - buffer too small for data item");
    }
    byte[] arrayOfByte = new byte[i1];
    System.arraycopy(paramArrayOfByte, paramInt, arrayOfByte, 0, i1);
    return arrayOfByte;
  }
  
  private static String h(String paramString)
  {
    return f(paramString);
  }
  
  private static Key h(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[7];
    System.arraycopy(paramArrayOfByte, paramInt, arrayOfByte, 0, 7);
    paramArrayOfByte = new byte[8];
    paramArrayOfByte[0] = arrayOfByte[0];
    paramArrayOfByte[1] = ((byte)(arrayOfByte[0] << 7 | (arrayOfByte[1] & 0xFF) >>> 1));
    paramArrayOfByte[2] = ((byte)(arrayOfByte[1] << 6 | (arrayOfByte[2] & 0xFF) >>> 2));
    paramArrayOfByte[3] = ((byte)(arrayOfByte[2] << 5 | (arrayOfByte[3] & 0xFF) >>> 3));
    paramArrayOfByte[4] = ((byte)(arrayOfByte[3] << 4 | (arrayOfByte[4] & 0xFF) >>> 4));
    paramArrayOfByte[5] = ((byte)(arrayOfByte[4] << 3 | (arrayOfByte[5] & 0xFF) >>> 5));
    paramArrayOfByte[6] = ((byte)(arrayOfByte[5] << 2 | (arrayOfByte[6] & 0xFF) >>> 6));
    paramArrayOfByte[7] = ((byte)(arrayOfByte[6] << 1));
    a(paramArrayOfByte);
    return new SecretKeySpec(paramArrayOfByte, "DES");
  }
  
  private static byte[] i(String paramString)
    throws i
  {
    try
    {
      paramString = paramString.toUpperCase(Locale.ENGLISH).getBytes("US-ASCII");
      int i1 = Math.min(paramString.length, 14);
      Object localObject = new byte[14];
      System.arraycopy(paramString, 0, localObject, 0, i1);
      paramString = h((byte[])localObject, 0);
      localObject = h((byte[])localObject, 7);
      byte[] arrayOfByte = "KGS!@#$%".getBytes("US-ASCII");
      Cipher localCipher = Cipher.getInstance("DES/ECB/NoPadding");
      localCipher.init(1, paramString);
      paramString = localCipher.doFinal(arrayOfByte);
      localCipher.init(1, (Key)localObject);
      localObject = localCipher.doFinal(arrayOfByte);
      arrayOfByte = new byte[16];
      System.arraycopy(paramString, 0, arrayOfByte, 0, 8);
      System.arraycopy(localObject, 0, arrayOfByte, 8, 8);
      return arrayOfByte;
    }
    catch (Exception paramString)
    {
      throw new i(paramString.getMessage(), paramString);
    }
  }
  
  private static byte[] j(String paramString)
    throws i
  {
    try
    {
      paramString = paramString.getBytes("UnicodeLittleUnmarked");
      c localc = new c();
      localc.a(paramString);
      paramString = localc.a();
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new i("Unicode not supported: " + paramString.getMessage(), paramString);
    }
  }
  
  String a()
  {
    return this.r;
  }
  
  public String a(String paramString1, String paramString2)
    throws i
  {
    return b(paramString2, paramString1);
  }
  
  public String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws i
  {
    paramString5 = new f(paramString5);
    return a(paramString1, paramString2, paramString4, paramString3, paramString5.d(), paramString5.g(), paramString5.e(), paramString5.f());
  }
  
  String a(String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte1, int paramInt, String paramString5, byte[] paramArrayOfByte2)
    throws i
  {
    return new g(paramString4, paramString3, paramString1, paramString2, paramArrayOfByte1, paramInt, paramString5, paramArrayOfByte2).c();
  }
  
  void a(String paramString)
  {
    this.r = paramString;
  }
  
  String b(String paramString1, String paramString2)
    throws i
  {
    return new e(paramString2, paramString1).c();
  }
  
  final String b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws i
  {
    if ((paramString1 == null) || (paramString1.trim().equals(""))) {
      return b(paramString4, paramString5);
    }
    paramString1 = new f(paramString1);
    return a(paramString2, paramString3, paramString4, paramString5, paramString1.d(), paramString1.g(), paramString1.e(), paramString1.f());
  }
  
  protected static class a
  {
    protected final String a;
    protected final String b;
    protected final String c;
    protected final byte[] d;
    protected final String e;
    protected final byte[] f;
    protected byte[] g;
    protected byte[] h;
    protected byte[] i;
    protected byte[] j;
    protected byte[] k = null;
    protected byte[] l = null;
    protected byte[] m = null;
    protected byte[] n = null;
    protected byte[] o = null;
    protected byte[] p = null;
    protected byte[] q = null;
    protected byte[] r = null;
    protected byte[] s = null;
    protected byte[] t = null;
    protected byte[] u = null;
    protected byte[] v = null;
    protected byte[] w = null;
    protected byte[] x = null;
    protected byte[] y = null;
    protected byte[] z = null;
    
    public a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte1, String paramString4, byte[] paramArrayOfByte2)
    {
      this(paramString1, paramString2, paramString3, paramArrayOfByte1, paramString4, paramArrayOfByte2, null, null, null, null);
    }
    
    public a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte1, String paramString4, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6)
    {
      this.a = paramString1;
      this.e = paramString4;
      this.b = paramString2;
      this.c = paramString3;
      this.d = paramArrayOfByte1;
      this.f = paramArrayOfByte2;
      this.g = paramArrayOfByte3;
      this.h = paramArrayOfByte4;
      this.i = paramArrayOfByte5;
      this.j = paramArrayOfByte6;
    }
    
    public byte[] a()
      throws i
    {
      if (this.g == null) {
        this.g = j.b();
      }
      return this.g;
    }
    
    public byte[] b()
      throws i
    {
      if (this.h == null) {
        this.h = j.b();
      }
      return this.h;
    }
    
    public byte[] c()
      throws i
    {
      if (this.i == null) {
        this.i = j.c();
      }
      return this.i;
    }
    
    public byte[] d()
      throws i
    {
      if (this.k == null) {
        this.k = j.b(this.c);
      }
      return this.k;
    }
    
    public byte[] e()
      throws i
    {
      if (this.l == null) {
        this.l = j.c(d(), this.d);
      }
      return this.l;
    }
    
    public byte[] f()
      throws i
    {
      if (this.m == null) {
        this.m = j.c(this.c);
      }
      return this.m;
    }
    
    public byte[] g()
      throws i
    {
      if (this.n == null) {
        this.n = j.c(f(), this.d);
      }
      return this.n;
    }
    
    public byte[] h()
      throws i
    {
      if (this.p == null) {
        this.p = j.a(this.a, this.b, f());
      }
      return this.p;
    }
    
    public byte[] i()
      throws i
    {
      if (this.o == null) {
        this.o = j.b(this.a, this.b, f());
      }
      return this.o;
    }
    
    public byte[] j()
    {
      if (this.j == null)
      {
        long l1 = (System.currentTimeMillis() + 11644473600000L) * 10000L;
        this.j = new byte[8];
        int i1 = 0;
        while (i1 < 8)
        {
          this.j[i1] = ((byte)(int)l1);
          l1 >>>= 8;
          i1 += 1;
        }
      }
      return this.j;
    }
    
    public byte[] k()
      throws i
    {
      if (this.r == null) {
        this.r = j.b(b(), this.f, j());
      }
      return this.r;
    }
    
    public byte[] l()
      throws i
    {
      if (this.s == null) {
        this.s = j.c(i(), this.d, k());
      }
      return this.s;
    }
    
    public byte[] m()
      throws i
    {
      if (this.q == null) {
        this.q = j.c(h(), this.d, a());
      }
      return this.q;
    }
    
    public byte[] n()
      throws i
    {
      if (this.t == null) {
        this.t = j.a(f(), this.d, a());
      }
      return this.t;
    }
    
    public byte[] o()
      throws i
    {
      if (this.u == null)
      {
        byte[] arrayOfByte = a();
        this.u = new byte[24];
        System.arraycopy(arrayOfByte, 0, this.u, 0, arrayOfByte.length);
        Arrays.fill(this.u, arrayOfByte.length, this.u.length, (byte)0);
      }
      return this.u;
    }
    
    public byte[] p()
      throws i
    {
      if (this.v == null)
      {
        this.v = new byte[16];
        System.arraycopy(d(), 0, this.v, 0, 8);
        Arrays.fill(this.v, 8, 16, (byte)0);
      }
      return this.v;
    }
    
    public byte[] q()
      throws i
    {
      if (this.w == null)
      {
        j.c localc = new j.c();
        localc.a(f());
        this.w = localc.a();
      }
      return this.w;
    }
    
    public byte[] r()
      throws i
    {
      if (this.x == null)
      {
        byte[] arrayOfByte1 = i();
        byte[] arrayOfByte2 = new byte[16];
        System.arraycopy(l(), 0, arrayOfByte2, 0, 16);
        this.x = j.a(arrayOfByte2, arrayOfByte1);
      }
      return this.x;
    }
    
    public byte[] s()
      throws i
    {
      if (this.y == null)
      {
        byte[] arrayOfByte1 = o();
        byte[] arrayOfByte2 = new byte[this.d.length + arrayOfByte1.length];
        System.arraycopy(this.d, 0, arrayOfByte2, 0, this.d.length);
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, this.d.length, arrayOfByte1.length);
        this.y = j.a(arrayOfByte2, q());
      }
      return this.y;
    }
    
    public byte[] t()
      throws i
    {
      if (this.z == null) {}
      try
      {
        Object localObject1 = new byte[14];
        System.arraycopy(d(), 0, localObject1, 0, 8);
        Arrays.fill((byte[])localObject1, 8, localObject1.length, (byte)-67);
        Object localObject2 = j.a((byte[])localObject1, 0);
        localObject1 = j.a((byte[])localObject1, 7);
        byte[] arrayOfByte = new byte[8];
        System.arraycopy(e(), 0, arrayOfByte, 0, arrayOfByte.length);
        Cipher localCipher = Cipher.getInstance("DES/ECB/NoPadding");
        localCipher.init(1, (Key)localObject2);
        localObject2 = localCipher.doFinal(arrayOfByte);
        localCipher = Cipher.getInstance("DES/ECB/NoPadding");
        localCipher.init(1, (Key)localObject1);
        localObject1 = localCipher.doFinal(arrayOfByte);
        this.z = new byte[16];
        System.arraycopy(localObject2, 0, this.z, 0, localObject2.length);
        System.arraycopy(localObject1, 0, this.z, localObject2.length, localObject1.length);
        return this.z;
      }
      catch (Exception localException)
      {
        throw new i(localException.getMessage(), localException);
      }
    }
  }
  
  static class b
  {
    protected byte[] a;
    protected byte[] b;
    protected MessageDigest c;
    
    b(byte[] paramArrayOfByte)
      throws i
    {
      int k;
      try
      {
        this.c = MessageDigest.getInstance("MD5");
        this.a = new byte[64];
        this.b = new byte[64];
        int i = paramArrayOfByte.length;
        byte[] arrayOfByte = paramArrayOfByte;
        int j = i;
        if (i > 64)
        {
          this.c.update(paramArrayOfByte);
          arrayOfByte = this.c.digest();
          j = arrayOfByte.length;
        }
        i = 0;
        for (;;)
        {
          k = i;
          if (i >= j) {
            break;
          }
          this.a[i] = ((byte)(arrayOfByte[i] ^ 0x36));
          this.b[i] = ((byte)(arrayOfByte[i] ^ 0x5C));
          i += 1;
        }
        if (k >= 64) {
          break label175;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        throw new i("Error getting md5 message digest implementation: " + paramArrayOfByte.getMessage(), paramArrayOfByte);
      }
      for (;;)
      {
        this.a[k] = 54;
        this.b[k] = 92;
        k += 1;
      }
      label175:
      this.c.reset();
      this.c.update(this.a);
    }
    
    void a(byte[] paramArrayOfByte)
    {
      this.c.update(paramArrayOfByte);
    }
    
    void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.c.update(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    byte[] a()
    {
      byte[] arrayOfByte = this.c.digest();
      this.c.update(this.b);
      return this.c.digest(arrayOfByte);
    }
  }
  
  static class c
  {
    protected int a = 1732584193;
    protected int b = -271733879;
    protected int c = -1732584194;
    protected int d = 271733878;
    protected long e = 0L;
    protected byte[] f = new byte[64];
    
    void a(byte[] paramArrayOfByte)
    {
      int j = (int)(this.e & 0x3F);
      int i = 0;
      int k;
      while (paramArrayOfByte.length - i + j >= this.f.length)
      {
        k = this.f.length - j;
        System.arraycopy(paramArrayOfByte, i, this.f, j, k);
        this.e += k;
        j = 0;
        i += k;
        b();
      }
      if (i < paramArrayOfByte.length)
      {
        k = paramArrayOfByte.length - i;
        System.arraycopy(paramArrayOfByte, i, this.f, j, k);
        this.e += k;
      }
    }
    
    protected void a(int[] paramArrayOfInt)
    {
      this.a = j.a(this.a + j.a(this.b, this.c, this.d) + paramArrayOfInt[0], 3);
      this.d = j.a(this.d + j.a(this.a, this.b, this.c) + paramArrayOfInt[1], 7);
      this.c = j.a(this.c + j.a(this.d, this.a, this.b) + paramArrayOfInt[2], 11);
      this.b = j.a(this.b + j.a(this.c, this.d, this.a) + paramArrayOfInt[3], 19);
      this.a = j.a(this.a + j.a(this.b, this.c, this.d) + paramArrayOfInt[4], 3);
      this.d = j.a(this.d + j.a(this.a, this.b, this.c) + paramArrayOfInt[5], 7);
      this.c = j.a(this.c + j.a(this.d, this.a, this.b) + paramArrayOfInt[6], 11);
      this.b = j.a(this.b + j.a(this.c, this.d, this.a) + paramArrayOfInt[7], 19);
      this.a = j.a(this.a + j.a(this.b, this.c, this.d) + paramArrayOfInt[8], 3);
      this.d = j.a(this.d + j.a(this.a, this.b, this.c) + paramArrayOfInt[9], 7);
      this.c = j.a(this.c + j.a(this.d, this.a, this.b) + paramArrayOfInt[10], 11);
      this.b = j.a(this.b + j.a(this.c, this.d, this.a) + paramArrayOfInt[11], 19);
      this.a = j.a(this.a + j.a(this.b, this.c, this.d) + paramArrayOfInt[12], 3);
      this.d = j.a(this.d + j.a(this.a, this.b, this.c) + paramArrayOfInt[13], 7);
      this.c = j.a(this.c + j.a(this.d, this.a, this.b) + paramArrayOfInt[14], 11);
      this.b = j.a(this.b + j.a(this.c, this.d, this.a) + paramArrayOfInt[15], 19);
    }
    
    byte[] a()
    {
      int i = (int)(this.e & 0x3F);
      if (i < 56) {}
      for (i = 56 - i;; i = 120 - i)
      {
        arrayOfByte = new byte[i + 8];
        arrayOfByte[0] = Byte.MIN_VALUE;
        int j = 0;
        while (j < 8)
        {
          arrayOfByte[(i + j)] = ((byte)(int)(this.e * 8L >>> j * 8));
          j += 1;
        }
      }
      a(arrayOfByte);
      byte[] arrayOfByte = new byte[16];
      j.a(arrayOfByte, this.a, 0);
      j.a(arrayOfByte, this.b, 4);
      j.a(arrayOfByte, this.c, 8);
      j.a(arrayOfByte, this.d, 12);
      return arrayOfByte;
    }
    
    protected void b()
    {
      int[] arrayOfInt = new int[16];
      int i = 0;
      while (i < 16)
      {
        arrayOfInt[i] = ((this.f[(i * 4)] & 0xFF) + ((this.f[(i * 4 + 1)] & 0xFF) << 8) + ((this.f[(i * 4 + 2)] & 0xFF) << 16) + ((this.f[(i * 4 + 3)] & 0xFF) << 24));
        i += 1;
      }
      i = this.a;
      int j = this.b;
      int k = this.c;
      int m = this.d;
      a(arrayOfInt);
      b(arrayOfInt);
      c(arrayOfInt);
      this.a += i;
      this.b += j;
      this.c += k;
      this.d += m;
    }
    
    protected void b(int[] paramArrayOfInt)
    {
      this.a = j.a(this.a + j.b(this.b, this.c, this.d) + paramArrayOfInt[0] + 1518500249, 3);
      this.d = j.a(this.d + j.b(this.a, this.b, this.c) + paramArrayOfInt[4] + 1518500249, 5);
      this.c = j.a(this.c + j.b(this.d, this.a, this.b) + paramArrayOfInt[8] + 1518500249, 9);
      this.b = j.a(this.b + j.b(this.c, this.d, this.a) + paramArrayOfInt[12] + 1518500249, 13);
      this.a = j.a(this.a + j.b(this.b, this.c, this.d) + paramArrayOfInt[1] + 1518500249, 3);
      this.d = j.a(this.d + j.b(this.a, this.b, this.c) + paramArrayOfInt[5] + 1518500249, 5);
      this.c = j.a(this.c + j.b(this.d, this.a, this.b) + paramArrayOfInt[9] + 1518500249, 9);
      this.b = j.a(this.b + j.b(this.c, this.d, this.a) + paramArrayOfInt[13] + 1518500249, 13);
      this.a = j.a(this.a + j.b(this.b, this.c, this.d) + paramArrayOfInt[2] + 1518500249, 3);
      this.d = j.a(this.d + j.b(this.a, this.b, this.c) + paramArrayOfInt[6] + 1518500249, 5);
      this.c = j.a(this.c + j.b(this.d, this.a, this.b) + paramArrayOfInt[10] + 1518500249, 9);
      this.b = j.a(this.b + j.b(this.c, this.d, this.a) + paramArrayOfInt[14] + 1518500249, 13);
      this.a = j.a(this.a + j.b(this.b, this.c, this.d) + paramArrayOfInt[3] + 1518500249, 3);
      this.d = j.a(this.d + j.b(this.a, this.b, this.c) + paramArrayOfInt[7] + 1518500249, 5);
      this.c = j.a(this.c + j.b(this.d, this.a, this.b) + paramArrayOfInt[11] + 1518500249, 9);
      this.b = j.a(this.b + j.b(this.c, this.d, this.a) + paramArrayOfInt[15] + 1518500249, 13);
    }
    
    protected void c(int[] paramArrayOfInt)
    {
      this.a = j.a(this.a + j.c(this.b, this.c, this.d) + paramArrayOfInt[0] + 1859775393, 3);
      this.d = j.a(this.d + j.c(this.a, this.b, this.c) + paramArrayOfInt[8] + 1859775393, 9);
      this.c = j.a(this.c + j.c(this.d, this.a, this.b) + paramArrayOfInt[4] + 1859775393, 11);
      this.b = j.a(this.b + j.c(this.c, this.d, this.a) + paramArrayOfInt[12] + 1859775393, 15);
      this.a = j.a(this.a + j.c(this.b, this.c, this.d) + paramArrayOfInt[2] + 1859775393, 3);
      this.d = j.a(this.d + j.c(this.a, this.b, this.c) + paramArrayOfInt[10] + 1859775393, 9);
      this.c = j.a(this.c + j.c(this.d, this.a, this.b) + paramArrayOfInt[6] + 1859775393, 11);
      this.b = j.a(this.b + j.c(this.c, this.d, this.a) + paramArrayOfInt[14] + 1859775393, 15);
      this.a = j.a(this.a + j.c(this.b, this.c, this.d) + paramArrayOfInt[1] + 1859775393, 3);
      this.d = j.a(this.d + j.c(this.a, this.b, this.c) + paramArrayOfInt[9] + 1859775393, 9);
      this.c = j.a(this.c + j.c(this.d, this.a, this.b) + paramArrayOfInt[5] + 1859775393, 11);
      this.b = j.a(this.b + j.c(this.c, this.d, this.a) + paramArrayOfInt[13] + 1859775393, 15);
      this.a = j.a(this.a + j.c(this.b, this.c, this.d) + paramArrayOfInt[3] + 1859775393, 3);
      this.d = j.a(this.d + j.c(this.a, this.b, this.c) + paramArrayOfInt[11] + 1859775393, 9);
      this.c = j.a(this.c + j.c(this.d, this.a, this.b) + paramArrayOfInt[7] + 1859775393, 11);
      this.b = j.a(this.b + j.c(this.c, this.d, this.a) + paramArrayOfInt[15] + 1859775393, 15);
    }
  }
  
  static class d
  {
    private byte[] a = null;
    private int b = 0;
    
    d() {}
    
    d(String paramString, int paramInt)
      throws i
    {
      this.a = a.a(f.a(paramString, "ASCII"), 2);
      if (this.a.length < j.d().length) {
        throw new i("NTLM message decoding error - packet too short");
      }
      int i = 0;
      while (i < j.d().length)
      {
        if (this.a[i] != j.d()[i]) {
          throw new i("NTLM message expected - instead got unrecognized bytes");
        }
        i += 1;
      }
      i = c(j.d().length);
      if (i != paramInt) {
        throw new i("NTLM type " + Integer.toString(paramInt) + " message expected - instead got type " + Integer.toString(i));
      }
      this.b = this.a.length;
    }
    
    protected byte a(int paramInt)
      throws i
    {
      if (this.a.length < paramInt + 1) {
        throw new i("NTLM: Message too short");
      }
      return this.a[paramInt];
    }
    
    protected int a()
    {
      return j.d().length + 4;
    }
    
    protected void a(byte paramByte)
    {
      this.a[this.b] = paramByte;
      this.b += 1;
    }
    
    protected void a(int paramInt1, int paramInt2)
    {
      this.a = new byte[paramInt1];
      this.b = 0;
      a(j.d());
      f(paramInt2);
    }
    
    protected void a(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte == null) {}
      for (;;)
      {
        return;
        int k = paramArrayOfByte.length;
        int j = 0;
        while (j < k)
        {
          int i = paramArrayOfByte[j];
          this.a[this.b] = i;
          this.b += 1;
          j += 1;
        }
      }
    }
    
    protected void a(byte[] paramArrayOfByte, int paramInt)
      throws i
    {
      if (this.a.length < paramArrayOfByte.length + paramInt) {
        throw new i("NTLM: Message too short");
      }
      System.arraycopy(this.a, paramInt, paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    protected int b()
    {
      return this.b;
    }
    
    protected int b(int paramInt)
      throws i
    {
      return j.b(this.a, paramInt);
    }
    
    protected int c(int paramInt)
      throws i
    {
      return j.c(this.a, paramInt);
    }
    
    String c()
    {
      byte[] arrayOfByte;
      if (this.a.length > this.b)
      {
        arrayOfByte = new byte[this.b];
        System.arraycopy(this.a, 0, arrayOfByte, 0, this.b);
      }
      for (;;)
      {
        return f.a(a.c(arrayOfByte, 2));
        arrayOfByte = this.a;
      }
    }
    
    protected byte[] d(int paramInt)
      throws i
    {
      return j.d(this.a, paramInt);
    }
    
    protected void e(int paramInt)
    {
      a((byte)(paramInt & 0xFF));
      a((byte)(paramInt >> 8 & 0xFF));
    }
    
    protected void f(int paramInt)
    {
      a((byte)(paramInt & 0xFF));
      a((byte)(paramInt >> 8 & 0xFF));
      a((byte)(paramInt >> 16 & 0xFF));
      a((byte)(paramInt >> 24 & 0xFF));
    }
  }
  
  static class e
    extends j.d
  {
    protected byte[] a;
    protected byte[] b;
    
    /* Error */
    e(String paramString1, String paramString2)
      throws i
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: aload_0
      //   3: invokespecial 19	cz/msebera/android/httpclient/i/a/j$d:<init>	()V
      //   6: aload_2
      //   7: invokestatic 23	cz/msebera/android/httpclient/i/a/j:d	(Ljava/lang/String;)Ljava/lang/String;
      //   10: astore 4
      //   12: aload_1
      //   13: invokestatic 25	cz/msebera/android/httpclient/i/a/j:e	(Ljava/lang/String;)Ljava/lang/String;
      //   16: astore_2
      //   17: aload 4
      //   19: ifnull +41 -> 60
      //   22: aload 4
      //   24: ldc 27
      //   26: invokevirtual 33	java/lang/String:getBytes	(Ljava/lang/String;)[B
      //   29: astore_1
      //   30: aload_0
      //   31: aload_1
      //   32: putfield 35	cz/msebera/android/httpclient/i/a/j$e:a	[B
      //   35: aload_3
      //   36: astore_1
      //   37: aload_2
      //   38: ifnull +16 -> 54
      //   41: aload_2
      //   42: getstatic 41	java/util/Locale:ENGLISH	Ljava/util/Locale;
      //   45: invokevirtual 45	java/lang/String:toUpperCase	(Ljava/util/Locale;)Ljava/lang/String;
      //   48: ldc 27
      //   50: invokevirtual 33	java/lang/String:getBytes	(Ljava/lang/String;)[B
      //   53: astore_1
      //   54: aload_0
      //   55: aload_1
      //   56: putfield 47	cz/msebera/android/httpclient/i/a/j$e:b	[B
      //   59: return
      //   60: aconst_null
      //   61: astore_1
      //   62: goto -32 -> 30
      //   65: astore_1
      //   66: new 14	cz/msebera/android/httpclient/i/a/i
      //   69: dup
      //   70: new 49	java/lang/StringBuilder
      //   73: dup
      //   74: invokespecial 50	java/lang/StringBuilder:<init>	()V
      //   77: ldc 52
      //   79: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   82: aload_1
      //   83: invokevirtual 60	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
      //   86: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   89: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   92: aload_1
      //   93: invokespecial 66	cz/msebera/android/httpclient/i/a/i:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   96: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	97	0	this	e
      //   0	97	1	paramString1	String
      //   0	97	2	paramString2	String
      //   1	35	3	localObject	Object
      //   10	13	4	str	String
      // Exception table:
      //   from	to	target	type
      //   6	17	65	java/io/UnsupportedEncodingException
      //   22	30	65	java/io/UnsupportedEncodingException
      //   30	35	65	java/io/UnsupportedEncodingException
      //   41	54	65	java/io/UnsupportedEncodingException
      //   54	59	65	java/io/UnsupportedEncodingException
    }
    
    String c()
    {
      a(40, 1);
      f(-1576500735);
      e(0);
      e(0);
      f(40);
      e(0);
      e(0);
      f(40);
      e(261);
      f(2600);
      e(3840);
      return super.c();
    }
  }
  
  static class f
    extends j.d
  {
    protected byte[] a = new byte[8];
    protected String b;
    protected byte[] c;
    protected int d;
    
    f(String paramString)
      throws i
    {
      super(2);
      a(this.a, 24);
      this.d = c(20);
      if ((this.d & 0x1) == 0) {
        throw new i("NTLM type 2 message indicates no support for Unicode. Flags are: " + Integer.toString(this.d));
      }
      this.b = null;
      if (b() >= 20)
      {
        paramString = d(12);
        if (paramString.length == 0) {}
      }
      try
      {
        this.b = new String(paramString, "UnicodeLittleUnmarked");
        this.c = null;
        if (b() >= 48)
        {
          paramString = d(40);
          if (paramString.length != 0) {
            this.c = paramString;
          }
        }
        return;
      }
      catch (UnsupportedEncodingException paramString)
      {
        throw new i(paramString.getMessage(), paramString);
      }
    }
    
    byte[] d()
    {
      return this.a;
    }
    
    String e()
    {
      return this.b;
    }
    
    byte[] f()
    {
      return this.c;
    }
    
    int g()
    {
      return this.d;
    }
  }
  
  static class g
    extends j.d
  {
    protected int a;
    protected byte[] b;
    protected byte[] c;
    protected byte[] d;
    protected byte[] e;
    protected byte[] f;
    protected byte[] g;
    
    /* Error */
    g(String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte1, int paramInt, String paramString5, byte[] paramArrayOfByte2)
      throws i
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 24	cz/msebera/android/httpclient/i/a/j$d:<init>	()V
      //   4: aload_0
      //   5: iload 6
      //   7: putfield 26	cz/msebera/android/httpclient/i/a/j$g:a	I
      //   10: aload_2
      //   11: invokestatic 29	cz/msebera/android/httpclient/i/a/j:d	(Ljava/lang/String;)Ljava/lang/String;
      //   14: astore 9
      //   16: aload_1
      //   17: invokestatic 31	cz/msebera/android/httpclient/i/a/j:e	(Ljava/lang/String;)Ljava/lang/String;
      //   20: astore_2
      //   21: new 33	cz/msebera/android/httpclient/i/a/j$a
      //   24: dup
      //   25: aload_2
      //   26: aload_3
      //   27: aload 4
      //   29: aload 5
      //   31: aload 7
      //   33: aload 8
      //   35: invokespecial 36	cz/msebera/android/httpclient/i/a/j$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BLjava/lang/String;[B)V
      //   38: astore 4
      //   40: ldc 37
      //   42: iload 6
      //   44: iand
      //   45: ifeq +135 -> 180
      //   48: aload 8
      //   50: ifnull +130 -> 180
      //   53: aload 7
      //   55: ifnull +125 -> 180
      //   58: aload_0
      //   59: aload 4
      //   61: invokevirtual 41	cz/msebera/android/httpclient/i/a/j$a:l	()[B
      //   64: putfield 43	cz/msebera/android/httpclient/i/a/j$g:f	[B
      //   67: aload_0
      //   68: aload 4
      //   70: invokevirtual 46	cz/msebera/android/httpclient/i/a/j$a:m	()[B
      //   73: putfield 48	cz/msebera/android/httpclient/i/a/j$g:e	[B
      //   76: iload 6
      //   78: sipush 128
      //   81: iand
      //   82: ifeq +89 -> 171
      //   85: aload 4
      //   87: invokevirtual 51	cz/msebera/android/httpclient/i/a/j$a:t	()[B
      //   90: astore_1
      //   91: iload 6
      //   93: bipush 16
      //   95: iand
      //   96: ifeq +234 -> 330
      //   99: ldc 52
      //   101: iload 6
      //   103: iand
      //   104: ifeq +218 -> 322
      //   107: aload_0
      //   108: aload 4
      //   110: invokevirtual 54	cz/msebera/android/httpclient/i/a/j$a:c	()[B
      //   113: aload_1
      //   114: invokestatic 57	cz/msebera/android/httpclient/i/a/j:b	([B[B)[B
      //   117: putfield 59	cz/msebera/android/httpclient/i/a/j$g:g	[B
      //   120: aload 9
      //   122: ifnull +216 -> 338
      //   125: aload 9
      //   127: ldc 61
      //   129: invokevirtual 67	java/lang/String:getBytes	(Ljava/lang/String;)[B
      //   132: astore_1
      //   133: aload_0
      //   134: aload_1
      //   135: putfield 69	cz/msebera/android/httpclient/i/a/j$g:c	[B
      //   138: aload_2
      //   139: ifnull +204 -> 343
      //   142: aload_2
      //   143: getstatic 75	java/util/Locale:ENGLISH	Ljava/util/Locale;
      //   146: invokevirtual 79	java/lang/String:toUpperCase	(Ljava/util/Locale;)Ljava/lang/String;
      //   149: ldc 61
      //   151: invokevirtual 67	java/lang/String:getBytes	(Ljava/lang/String;)[B
      //   154: astore_1
      //   155: aload_0
      //   156: aload_1
      //   157: putfield 81	cz/msebera/android/httpclient/i/a/j$g:b	[B
      //   160: aload_0
      //   161: aload_3
      //   162: ldc 61
      //   164: invokevirtual 67	java/lang/String:getBytes	(Ljava/lang/String;)[B
      //   167: putfield 83	cz/msebera/android/httpclient/i/a/j$g:d	[B
      //   170: return
      //   171: aload 4
      //   173: invokevirtual 86	cz/msebera/android/httpclient/i/a/j$a:r	()[B
      //   176: astore_1
      //   177: goto -86 -> 91
      //   180: ldc 87
      //   182: iload 6
      //   184: iand
      //   185: ifeq +48 -> 233
      //   188: aload_0
      //   189: aload 4
      //   191: invokevirtual 90	cz/msebera/android/httpclient/i/a/j$a:n	()[B
      //   194: putfield 43	cz/msebera/android/httpclient/i/a/j$g:f	[B
      //   197: aload_0
      //   198: aload 4
      //   200: invokevirtual 93	cz/msebera/android/httpclient/i/a/j$a:o	()[B
      //   203: putfield 48	cz/msebera/android/httpclient/i/a/j$g:e	[B
      //   206: iload 6
      //   208: sipush 128
      //   211: iand
      //   212: ifeq +12 -> 224
      //   215: aload 4
      //   217: invokevirtual 51	cz/msebera/android/httpclient/i/a/j$a:t	()[B
      //   220: astore_1
      //   221: goto -130 -> 91
      //   224: aload 4
      //   226: invokevirtual 96	cz/msebera/android/httpclient/i/a/j$a:s	()[B
      //   229: astore_1
      //   230: goto -139 -> 91
      //   233: aload_0
      //   234: aload 4
      //   236: invokevirtual 98	cz/msebera/android/httpclient/i/a/j$a:g	()[B
      //   239: putfield 43	cz/msebera/android/httpclient/i/a/j$g:f	[B
      //   242: aload_0
      //   243: aload 4
      //   245: invokevirtual 100	cz/msebera/android/httpclient/i/a/j$a:e	()[B
      //   248: putfield 48	cz/msebera/android/httpclient/i/a/j$g:e	[B
      //   251: iload 6
      //   253: sipush 128
      //   256: iand
      //   257: ifeq +12 -> 269
      //   260: aload 4
      //   262: invokevirtual 51	cz/msebera/android/httpclient/i/a/j$a:t	()[B
      //   265: astore_1
      //   266: goto -175 -> 91
      //   269: aload 4
      //   271: invokevirtual 103	cz/msebera/android/httpclient/i/a/j$a:q	()[B
      //   274: astore_1
      //   275: goto -184 -> 91
      //   278: astore_1
      //   279: aload_0
      //   280: iconst_0
      //   281: newarray <illegal type>
      //   283: putfield 43	cz/msebera/android/httpclient/i/a/j$g:f	[B
      //   286: aload_0
      //   287: aload 4
      //   289: invokevirtual 100	cz/msebera/android/httpclient/i/a/j$a:e	()[B
      //   292: putfield 48	cz/msebera/android/httpclient/i/a/j$g:e	[B
      //   295: iload 6
      //   297: sipush 128
      //   300: iand
      //   301: ifeq +12 -> 313
      //   304: aload 4
      //   306: invokevirtual 51	cz/msebera/android/httpclient/i/a/j$a:t	()[B
      //   309: astore_1
      //   310: goto -219 -> 91
      //   313: aload 4
      //   315: invokevirtual 106	cz/msebera/android/httpclient/i/a/j$a:p	()[B
      //   318: astore_1
      //   319: goto -228 -> 91
      //   322: aload_0
      //   323: aload_1
      //   324: putfield 59	cz/msebera/android/httpclient/i/a/j$g:g	[B
      //   327: goto -207 -> 120
      //   330: aload_0
      //   331: aconst_null
      //   332: putfield 59	cz/msebera/android/httpclient/i/a/j$g:g	[B
      //   335: goto -215 -> 120
      //   338: aconst_null
      //   339: astore_1
      //   340: goto -207 -> 133
      //   343: aconst_null
      //   344: astore_1
      //   345: goto -190 -> 155
      //   348: astore_1
      //   349: new 19	cz/msebera/android/httpclient/i/a/i
      //   352: dup
      //   353: new 108	java/lang/StringBuilder
      //   356: dup
      //   357: invokespecial 109	java/lang/StringBuilder:<init>	()V
      //   360: ldc 111
      //   362: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   365: aload_1
      //   366: invokevirtual 119	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
      //   369: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   372: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   375: aload_1
      //   376: invokespecial 125	cz/msebera/android/httpclient/i/a/i:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   379: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	380	0	this	g
      //   0	380	1	paramString1	String
      //   0	380	2	paramString2	String
      //   0	380	3	paramString3	String
      //   0	380	4	paramString4	String
      //   0	380	5	paramArrayOfByte1	byte[]
      //   0	380	6	paramInt	int
      //   0	380	7	paramString5	String
      //   0	380	8	paramArrayOfByte2	byte[]
      //   14	112	9	str	String
      // Exception table:
      //   from	to	target	type
      //   58	76	278	cz/msebera/android/httpclient/i/a/i
      //   85	91	278	cz/msebera/android/httpclient/i/a/i
      //   171	177	278	cz/msebera/android/httpclient/i/a/i
      //   188	206	278	cz/msebera/android/httpclient/i/a/i
      //   215	221	278	cz/msebera/android/httpclient/i/a/i
      //   224	230	278	cz/msebera/android/httpclient/i/a/i
      //   233	251	278	cz/msebera/android/httpclient/i/a/i
      //   260	266	278	cz/msebera/android/httpclient/i/a/i
      //   269	275	278	cz/msebera/android/httpclient/i/a/i
      //   125	133	348	java/io/UnsupportedEncodingException
      //   133	138	348	java/io/UnsupportedEncodingException
      //   142	155	348	java/io/UnsupportedEncodingException
      //   155	170	348	java/io/UnsupportedEncodingException
    }
    
    String c()
    {
      int m = this.f.length;
      int n = this.e.length;
      int i;
      int j;
      label40:
      int i1;
      if (this.b != null)
      {
        i = this.b.length;
        if (this.c == null) {
          break label392;
        }
        j = this.c.length;
        i1 = this.d.length;
        if (this.g == null) {
          break label397;
        }
      }
      label392:
      label397:
      for (int k = this.g.length;; k = 0)
      {
        int i2 = n + 72;
        int i3 = i2 + m;
        int i4 = i3 + i;
        int i5 = i4 + i1;
        int i6 = i5 + j;
        a(i6 + k, 3);
        e(n);
        e(n);
        f(72);
        e(m);
        e(m);
        f(i2);
        e(i);
        e(i);
        f(i3);
        e(i1);
        e(i1);
        f(i4);
        e(j);
        e(j);
        f(i5);
        e(k);
        e(k);
        f(i6);
        f(this.a & 0x80 | this.a & 0x200 | this.a & 0x80000 | 0x2000000 | this.a & 0x8000 | this.a & 0x20 | this.a & 0x10 | this.a & 0x20000000 | this.a & 0x80000000 | this.a & 0x40000000 | this.a & 0x800000 | this.a & 0x1 | this.a & 0x4);
        e(261);
        f(2600);
        e(3840);
        a(this.e);
        a(this.f);
        a(this.b);
        a(this.d);
        a(this.c);
        if (this.g != null) {
          a(this.g);
        }
        return super.c();
        i = 0;
        break;
        j = 0;
        break label40;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */