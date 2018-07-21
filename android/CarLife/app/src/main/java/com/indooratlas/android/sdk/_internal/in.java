package com.indooratlas.android.sdk._internal;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class in
  implements io, ip, Cloneable
{
  private static final byte[] c = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  ja a;
  public long b;
  
  private String a(long paramLong, Charset paramCharset)
    throws EOFException
  {
    jf.a(this.b, 0L, paramLong);
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    }
    if (paramLong == 0L) {
      paramCharset = "";
    }
    ja localja;
    String str;
    do
    {
      return paramCharset;
      localja = this.a;
      if (localja.b + paramLong > localja.c) {
        return new String(e(paramLong), paramCharset);
      }
      str = new String(localja.a, localja.b, (int)paramLong, paramCharset);
      localja.b = ((int)(localja.b + paramLong));
      this.b -= paramLong;
      paramCharset = str;
    } while (localja.b != localja.c);
    this.a = localja.a();
    jb.a(localja);
    return str;
  }
  
  private void c(byte[] paramArrayOfByte)
    throws EOFException
  {
    int j;
    for (int i = 0; i < paramArrayOfByte.length; i = j + i)
    {
      j = paramArrayOfByte.length - i;
      jf.a(paramArrayOfByte.length, i, j);
      ja localja = this.a;
      if (localja == null) {
        j = -1;
      }
      while (j == -1)
      {
        throw new EOFException();
        int k = Math.min(j, localja.c - localja.b);
        System.arraycopy(localja.a, localja.b, paramArrayOfByte, i, k);
        localja.b += k;
        this.b -= k;
        j = k;
        if (localja.b == localja.c)
        {
          this.a = localja.a();
          jb.a(localja);
          j = k;
        }
      }
    }
  }
  
  private String k(long paramLong)
    throws EOFException
  {
    return a(paramLong, jf.a);
  }
  
  private in q()
  {
    in localin = new in();
    if (this.b == 0L) {
      return localin;
    }
    localin.a = new ja(this.a);
    ja localja1 = localin.a;
    ja localja2 = localin.a;
    ja localja3 = localin.a;
    localja2.g = localja3;
    localja1.f = localja3;
    for (localja1 = this.a.f; localja1 != this.a; localja1 = localja1.f) {
      localin.a.g.a(new ja(localja1));
    }
    localin.b = this.b;
    return localin;
  }
  
  public final long a(byte paramByte)
  {
    return a(paramByte, 0L);
  }
  
  public final long a(byte paramByte, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("fromIndex < 0");
    }
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return -1L;
    }
    long l = 0L;
    int j = ((ja)localObject1).c - ((ja)localObject1).b;
    if (paramLong >= j) {}
    for (paramLong -= j;; paramLong = 0L)
    {
      l += j;
      Object localObject2 = ((ja)localObject1).f;
      localObject1 = localObject2;
      if (localObject2 != this.a) {
        break;
      }
      return -1L;
      localObject2 = ((ja)localObject1).a;
      int i = (int)(((ja)localObject1).b + paramLong);
      int k = ((ja)localObject1).c;
      while (i < k)
      {
        if (localObject2[i] == paramByte) {
          return l + i - ((ja)localObject1).b;
        }
        i += 1;
      }
    }
  }
  
  public final long a(in paramin, long paramLong)
  {
    if (paramin == null) {
      throw new IllegalArgumentException("sink == null");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.b == 0L) {
      return -1L;
    }
    long l = paramLong;
    if (paramLong > this.b) {
      l = this.b;
    }
    paramin.a_(this, l);
    return l;
  }
  
  public final long a(jd paramjd)
    throws IOException
  {
    if (paramjd == null) {
      throw new IllegalArgumentException("source == null");
    }
    long l2;
    for (long l1 = 0L;; l1 += l2)
    {
      l2 = paramjd.a(this, 2048L);
      if (l2 == -1L) {
        break;
      }
    }
    return l1;
  }
  
  public final in a(int paramInt)
  {
    if (paramInt < 128)
    {
      b(paramInt);
      return this;
    }
    if (paramInt < 2048)
    {
      b(paramInt >> 6 | 0xC0);
      b(paramInt & 0x3F | 0x80);
      return this;
    }
    if (paramInt < 65536)
    {
      if ((paramInt >= 55296) && (paramInt <= 57343)) {
        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(paramInt));
      }
      b(paramInt >> 12 | 0xE0);
      b(paramInt >> 6 & 0x3F | 0x80);
      b(paramInt & 0x3F | 0x80);
      return this;
    }
    if (paramInt <= 1114111)
    {
      b(paramInt >> 18 | 0xF0);
      b(paramInt >> 12 & 0x3F | 0x80);
      b(paramInt >> 6 & 0x3F | 0x80);
      b(paramInt & 0x3F | 0x80);
      return this;
    }
    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(paramInt));
  }
  
  public final in a(in paramin, long paramLong1, long paramLong2)
  {
    if (paramin == null) {
      throw new IllegalArgumentException("out == null");
    }
    jf.a(this.b, paramLong1, paramLong2);
    if (paramLong2 == 0L) {
      return this;
    }
    paramin.b += paramLong2;
    ja localja2;
    long l1;
    long l2;
    for (ja localja1 = this.a;; localja1 = localja1.f)
    {
      localja2 = localja1;
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramLong1 < localja1.c - localja1.b) {
        break;
      }
      paramLong1 -= localja1.c - localja1.b;
    }
    label103:
    if (l2 > 0L)
    {
      localja1 = new ja(localja2);
      localja1.b = ((int)(localja1.b + l1));
      localja1.c = Math.min(localja1.b + (int)l2, localja1.c);
      if (paramin.a != null) {
        break label215;
      }
      localja1.g = localja1;
      localja1.f = localja1;
      paramin.a = localja1;
    }
    for (;;)
    {
      l2 -= localja1.c - localja1.b;
      localja2 = localja2.f;
      l1 = 0L;
      break label103;
      break;
      label215:
      paramin.a.g.a(localja1);
    }
  }
  
  public final in a(iq paramiq)
  {
    if (paramiq == null) {
      throw new IllegalArgumentException("byteString == null");
    }
    a(paramiq.c, 0, paramiq.c.length);
    return this;
  }
  
  public final in a(String paramString)
  {
    return a(paramString, 0, paramString.length());
  }
  
  public final in a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("string == null");
    }
    if (paramInt1 < 0) {
      throw new IllegalAccessError("beginIndex < 0: " + paramInt1);
    }
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("endIndex < beginIndex: " + paramInt2 + " < " + paramInt1);
    }
    int k;
    ja localja;
    int i;
    if (paramInt2 > paramString.length())
    {
      throw new IllegalArgumentException("endIndex > string.length: " + paramInt2 + " > " + paramString.length());
      i = paramInt1 + k - localja.c;
      localja.c += i;
      this.b += i;
    }
    for (;;)
    {
      if (paramInt1 >= paramInt2) {
        return this;
      }
      int j = paramString.charAt(paramInt1);
      if (j < 128)
      {
        localja = f(1);
        byte[] arrayOfByte = localja.a;
        k = localja.c - paramInt1;
        int m = Math.min(paramInt2, 2048 - k);
        i = paramInt1 + 1;
        arrayOfByte[(k + paramInt1)] = ((byte)j);
        paramInt1 = i;
        for (;;)
        {
          if (paramInt1 >= m) {
            break label270;
          }
          i = paramString.charAt(paramInt1);
          if (i >= 128) {
            break;
          }
          arrayOfByte[(paramInt1 + k)] = ((byte)i);
          paramInt1 += 1;
        }
        label270:
        break;
      }
      if (j < 2048)
      {
        b(j >> 6 | 0xC0);
        b(j & 0x3F | 0x80);
        paramInt1 += 1;
      }
      else if ((j < 55296) || (j > 57343))
      {
        b(j >> 12 | 0xE0);
        b(j >> 6 & 0x3F | 0x80);
        b(j & 0x3F | 0x80);
        paramInt1 += 1;
      }
      else
      {
        if (paramInt1 + 1 < paramInt2) {}
        for (i = paramString.charAt(paramInt1 + 1);; i = 0)
        {
          if ((j <= 56319) && (i >= 56320) && (i <= 57343)) {
            break label438;
          }
          b(63);
          paramInt1 += 1;
          break;
        }
        label438:
        i = (i & 0xFFFF23FF | (j & 0xFFFF27FF) << 10) + 65536;
        b(i >> 18 | 0xF0);
        b(i >> 12 & 0x3F | 0x80);
        b(i >> 6 & 0x3F | 0x80);
        b(i & 0x3F | 0x80);
        paramInt1 += 2;
      }
    }
    return this;
  }
  
  public final in a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("source == null");
    }
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final in a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("source == null");
    }
    jf.a(paramArrayOfByte.length, paramInt1, paramInt2);
    int i = paramInt1 + paramInt2;
    while (paramInt1 < i)
    {
      ja localja = f(1);
      int j = Math.min(i - paramInt1, 2048 - localja.c);
      System.arraycopy(paramArrayOfByte, paramInt1, localja.a, localja.c, j);
      paramInt1 += j;
      localja.c = (j + localja.c);
    }
    this.b += paramInt2;
    return this;
  }
  
  public final je a()
  {
    return je.b;
  }
  
  public final void a(long paramLong)
    throws EOFException
  {
    if (this.b < paramLong) {
      throw new EOFException();
    }
  }
  
  public final void a_(in paramin, long paramLong)
  {
    if (paramin == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramin == this) {
      throw new IllegalArgumentException("source == this");
    }
    jf.a(paramin.b, 0L, paramLong);
    if (paramLong > 0L)
    {
      if (paramLong >= paramin.a.c - paramin.a.b) {
        break label269;
      }
      if (this.a == null) {
        break label160;
      }
      localja1 = this.a.g;
      if ((localja1 == null) || (!localja1.e)) {
        break label176;
      }
      l = localja1.c;
      if (!localja1.d) {
        break label166;
      }
    }
    label160:
    label166:
    for (int i = 0;; i = localja1.b)
    {
      if (l + paramLong - i > 2048L) {
        break label176;
      }
      paramin.a.a(localja1, (int)paramLong);
      paramin.b -= paramLong;
      this.b += paramLong;
      return;
      localja1 = null;
      break;
    }
    label176:
    ja localja1 = paramin.a;
    i = (int)paramLong;
    if ((i <= 0) || (i > localja1.c - localja1.b)) {
      throw new IllegalArgumentException();
    }
    ja localja2 = new ja(localja1);
    localja2.c = (localja2.b + i);
    localja1.b = (i + localja1.b);
    localja1.g.a(localja2);
    paramin.a = localja2;
    label269:
    localja1 = paramin.a;
    long l = localja1.c - localja1.b;
    paramin.a = localja1.a();
    if (this.a == null)
    {
      this.a = localja1;
      localja1 = this.a;
      localja2 = this.a;
      ja localja3 = this.a;
      localja2.g = localja3;
      localja1.f = localja3;
    }
    label504:
    for (;;)
    {
      paramin.b -= l;
      this.b += l;
      paramLong -= l;
      break;
      localja1 = this.a.g.a(localja1);
      if (localja1.g == localja1) {
        throw new IllegalStateException();
      }
      if (localja1.g.e)
      {
        int j = localja1.c - localja1.b;
        int k = localja1.g.c;
        if (localja1.g.d) {}
        for (i = 0;; i = localja1.g.b)
        {
          if (j > i + (2048 - k)) {
            break label504;
          }
          localja1.a(localja1.g, j);
          localja1.a();
          jb.a(localja1);
          break;
        }
      }
    }
  }
  
  public final byte b(long paramLong)
  {
    jf.a(this.b, paramLong, 1L);
    for (ja localja = this.a;; localja = localja.f)
    {
      int i = localja.c - localja.b;
      if (paramLong < i) {
        return localja.a[(localja.b + (int)paramLong)];
      }
      paramLong -= i;
    }
  }
  
  public final in b()
  {
    return this;
  }
  
  public final in b(int paramInt)
  {
    ja localja = f(1);
    byte[] arrayOfByte = localja.a;
    int i = localja.c;
    localja.c = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    this.b += 1L;
    return this;
  }
  
  public final in c(int paramInt)
  {
    ja localja = f(2);
    byte[] arrayOfByte = localja.a;
    int i = localja.c;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
    localja.c = (j + 1);
    this.b += 2L;
    return this;
  }
  
  public final io c()
  {
    return this;
  }
  
  public final iq c(long paramLong)
    throws EOFException
  {
    return new iq(e(paramLong));
  }
  
  public final void close() {}
  
  public final in d(int paramInt)
  {
    ja localja = f(4);
    byte[] arrayOfByte = localja.a;
    int j = localja.c;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    localja.c = (i + 1);
    this.b += 4L;
    return this;
  }
  
  final String d(long paramLong)
    throws EOFException
  {
    if ((paramLong > 0L) && (b(paramLong - 1L) == 13))
    {
      str = k(paramLong - 1L);
      f(2L);
      return str;
    }
    String str = k(paramLong);
    f(1L);
    return str;
  }
  
  public final boolean d()
  {
    return this.b == 0L;
  }
  
  public final byte e()
  {
    if (this.b == 0L) {
      throw new IllegalStateException("size == 0");
    }
    ja localja = this.a;
    int i = localja.b;
    int j = localja.c;
    byte[] arrayOfByte = localja.a;
    int k = i + 1;
    byte b1 = arrayOfByte[i];
    this.b -= 1L;
    if (k == j)
    {
      this.a = localja.a();
      jb.a(localja);
      return b1;
    }
    localja.b = k;
    return b1;
  }
  
  public final in e(int paramInt)
  {
    return d(jf.a(paramInt));
  }
  
  public final byte[] e(long paramLong)
    throws EOFException
  {
    jf.a(this.b, 0L, paramLong);
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    }
    byte[] arrayOfByte = new byte[(int)paramLong];
    c(arrayOfByte);
    return arrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    long l1 = 0L;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof in)) {
      return false;
    }
    paramObject = (in)paramObject;
    if (this.b != ((in)paramObject).b) {
      return false;
    }
    if (this.b == 0L) {
      return true;
    }
    Object localObject2 = this.a;
    paramObject = ((in)paramObject).a;
    int j = ((ja)localObject2).b;
    int i = ((ja)paramObject).b;
    while (l1 < this.b)
    {
      long l2 = Math.min(((ja)localObject2).c - j, ((ja)paramObject).c - i);
      int k = 0;
      while (k < l2)
      {
        if (localObject2.a[j] != paramObject.a[i]) {
          return false;
        }
        k += 1;
        i += 1;
        j += 1;
      }
      k = j;
      Object localObject1 = localObject2;
      if (j == ((ja)localObject2).c)
      {
        localObject1 = ((ja)localObject2).f;
        k = ((ja)localObject1).b;
      }
      j = i;
      Object localObject3 = paramObject;
      if (i == ((ja)paramObject).c)
      {
        localObject3 = ((ja)paramObject).f;
        j = ((ja)localObject3).b;
      }
      l1 += l2;
      i = j;
      j = k;
      localObject2 = localObject1;
      paramObject = localObject3;
    }
    return true;
  }
  
  final ja f(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > 2048)) {
      throw new IllegalArgumentException();
    }
    ja localja2;
    ja localja1;
    if (this.a == null)
    {
      this.a = jb.a();
      localja2 = this.a;
      ja localja3 = this.a;
      localja1 = this.a;
      localja3.g = localja1;
      localja2.f = localja1;
    }
    do
    {
      return localja1;
      localja2 = this.a.g;
      if (localja2.c + paramInt > 2048) {
        break;
      }
      localja1 = localja2;
    } while (localja2.e);
    return localja2.a(jb.a());
  }
  
  public final short f()
  {
    if (this.b < 2L) {
      throw new IllegalStateException("size < 2: " + this.b);
    }
    ja localja = this.a;
    int k = localja.b;
    int i = localja.c;
    if (i - k < 2) {
      return (short)((e() & 0xFF) << 8 | e() & 0xFF);
    }
    byte[] arrayOfByte = localja.a;
    int j = k + 1;
    k = arrayOfByte[k];
    int m = j + 1;
    j = arrayOfByte[j];
    this.b -= 2L;
    if (m == i)
    {
      this.a = localja.a();
      jb.a(localja);
    }
    for (;;)
    {
      return (short)((k & 0xFF) << 8 | j & 0xFF);
      localja.b = m;
    }
  }
  
  public final void f(long paramLong)
    throws EOFException
  {
    while (paramLong > 0L)
    {
      if (this.a == null) {
        throw new EOFException();
      }
      int i = (int)Math.min(paramLong, this.a.c - this.a.b);
      this.b -= i;
      long l = paramLong - i;
      ja localja = this.a;
      localja.b = (i + localja.b);
      paramLong = l;
      if (this.a.b == this.a.c)
      {
        localja = this.a;
        this.a = localja.a();
        jb.a(localja);
        paramLong = l;
      }
    }
  }
  
  public final void flush() {}
  
  public final int g()
  {
    if (this.b < 4L) {
      throw new IllegalStateException("size < 4: " + this.b);
    }
    ja localja = this.a;
    int j = localja.b;
    int i = localja.c;
    if (i - j < 4) {
      return (e() & 0xFF) << 24 | (e() & 0xFF) << 16 | (e() & 0xFF) << 8 | e() & 0xFF;
    }
    byte[] arrayOfByte = localja.a;
    int k = j + 1;
    j = arrayOfByte[j];
    int n = k + 1;
    k = arrayOfByte[k];
    int m = n + 1;
    int i1 = arrayOfByte[n];
    n = m + 1;
    j = (j & 0xFF) << 24 | (k & 0xFF) << 16 | (i1 & 0xFF) << 8 | arrayOfByte[m] & 0xFF;
    this.b -= 4L;
    if (n == i)
    {
      this.a = localja.a();
      jb.a(localja);
      return j;
    }
    localja.b = n;
    return j;
  }
  
  public final in g(long paramLong)
  {
    if (paramLong == 0L) {
      return b(48);
    }
    if (paramLong < 0L)
    {
      paramLong = -paramLong;
      if (paramLong < 0L) {
        return a("-9223372036854775808");
      }
    }
    for (int j = 1;; j = 0)
    {
      int i;
      if (paramLong < 100000000L) {
        if (paramLong < 10000L) {
          if (paramLong < 100L) {
            if (paramLong < 10L) {
              i = 1;
            }
          }
        }
      }
      int k;
      ja localja;
      byte[] arrayOfByte;
      for (;;)
      {
        k = i;
        if (j != 0) {
          k = i + 1;
        }
        localja = f(k);
        arrayOfByte = localja.a;
        i = localja.c + k;
        while (paramLong != 0L)
        {
          int m = (int)(paramLong % 10L);
          i -= 1;
          arrayOfByte[i] = c[m];
          paramLong /= 10L;
        }
        i = 2;
        continue;
        if (paramLong < 1000L)
        {
          i = 3;
        }
        else
        {
          i = 4;
          continue;
          if (paramLong < 1000000L)
          {
            if (paramLong < 100000L) {
              i = 5;
            } else {
              i = 6;
            }
          }
          else if (paramLong < 10000000L)
          {
            i = 7;
          }
          else
          {
            i = 8;
            continue;
            if (paramLong < 1000000000000L)
            {
              if (paramLong < 10000000000L)
              {
                if (paramLong < 1000000000L) {
                  i = 9;
                } else {
                  i = 10;
                }
              }
              else if (paramLong < 100000000000L) {
                i = 11;
              } else {
                i = 12;
              }
            }
            else if (paramLong < 1000000000000000L)
            {
              if (paramLong < 10000000000000L) {
                i = 13;
              } else if (paramLong < 100000000000000L) {
                i = 14;
              } else {
                i = 15;
              }
            }
            else if (paramLong < 100000000000000000L)
            {
              if (paramLong < 10000000000000000L) {
                i = 16;
              } else {
                i = 17;
              }
            }
            else if (paramLong < 1000000000000000000L) {
              i = 18;
            } else {
              i = 19;
            }
          }
        }
      }
      if (j != 0) {
        arrayOfByte[(i - 1)] = 45;
      }
      localja.c += k;
      paramLong = this.b;
      this.b = (k + paramLong);
      return this;
    }
  }
  
  public final in h(long paramLong)
  {
    if (paramLong == 0L) {
      return b(48);
    }
    int j = Long.numberOfTrailingZeros(Long.highestOneBit(paramLong)) / 4 + 1;
    ja localja = f(j);
    byte[] arrayOfByte = localja.a;
    int i = localja.c + j - 1;
    int k = localja.c;
    while (i >= k)
    {
      arrayOfByte[i] = c[((int)(0xF & paramLong))];
      paramLong >>>= 4;
      i -= 1;
    }
    localja.c += j;
    paramLong = this.b;
    this.b = (j + paramLong);
    return this;
  }
  
  public final short h()
  {
    return jf.a(f());
  }
  
  public final int hashCode()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return 0;
    }
    int j = 1;
    int i;
    ja localja;
    do
    {
      int k = ((ja)localObject).b;
      int m = ((ja)localObject).c;
      for (i = j; k < m; i = j + i * 31)
      {
        j = localObject.a[k];
        k += 1;
      }
      localja = ((ja)localObject).f;
      j = i;
      localObject = localja;
    } while (localja != this.a);
    return i;
  }
  
  public final int i()
  {
    return jf.a(g());
  }
  
  public final long j()
  {
    if (this.b == 0L) {
      throw new IllegalStateException("size == 0");
    }
    long l2 = 0L;
    int i = 0;
    int j = 0;
    Object localObject = this.a;
    byte[] arrayOfByte = ((ja)localObject).a;
    int m = ((ja)localObject).b;
    int n = ((ja)localObject).c;
    long l1 = l2;
    int k = i;
    label60:
    i = j;
    if (m < n)
    {
      int i1 = arrayOfByte[m];
      if ((i1 >= 48) && (i1 <= 57)) {
        i = i1 - 48;
      }
      for (;;)
      {
        if ((0xF000000000000000 & l1) == 0L) {
          break label296;
        }
        localObject = new in().h(l1).b(i1);
        throw new NumberFormatException("Number too large: " + ((in)localObject).l());
        if ((i1 >= 97) && (i1 <= 102))
        {
          i = i1 - 97 + 10;
        }
        else
        {
          if ((i1 < 65) || (i1 > 70)) {
            break;
          }
          i = i1 - 65 + 10;
        }
      }
      if (k == 0) {
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(i1));
      }
      i = 1;
    }
    if (m == n)
    {
      this.a = ((ja)localObject).a();
      jb.a((ja)localObject);
    }
    for (;;)
    {
      if (i == 0)
      {
        j = i;
        i = k;
        l2 = l1;
        if (this.a != null) {
          break;
        }
      }
      this.b -= k;
      return l1;
      label296:
      l2 = i;
      k += 1;
      m += 1;
      l1 = l2 | l1 << 4;
      break label60;
      ((ja)localObject).b = m;
    }
  }
  
  public final iq k()
  {
    return new iq(n());
  }
  
  public final String l()
  {
    try
    {
      String str = a(this.b, jf.a);
      return str;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public final String m()
    throws EOFException
  {
    long l = a((byte)10, 0L);
    if (l == -1L)
    {
      in localin = new in();
      a(localin, 0L, Math.min(32L, this.b));
      throw new EOFException("\\n not found: size=" + this.b + " content=" + localin.k().b() + "...");
    }
    return d(l);
  }
  
  public final byte[] n()
  {
    try
    {
      byte[] arrayOfByte = e(this.b);
      return arrayOfByte;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public final void o()
  {
    try
    {
      f(this.b);
      return;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public final String toString()
  {
    if (this.b == 0L) {
      return "Buffer[size=0]";
    }
    Object localObject;
    if (this.b <= 16L)
    {
      localObject = q().k();
      return String.format("Buffer[size=%s data=%s]", new Object[] { Long.valueOf(this.b), ((iq)localObject).b() });
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(this.a.a, this.a.b, this.a.c - this.a.b);
      for (localObject = this.a.f; localObject != this.a; localObject = ((ja)localObject).f) {
        localMessageDigest.update(((ja)localObject).a, ((ja)localObject).b, ((ja)localObject).c - ((ja)localObject).b);
      }
      localObject = String.format("Buffer[size=%s md5=%s]", new Object[] { Long.valueOf(this.b), iq.a(localMessageDigest.digest()).b() });
      return (String)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new AssertionError();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/in.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */