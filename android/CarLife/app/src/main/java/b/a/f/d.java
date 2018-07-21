package b.a.f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

final class d
{
  static final c[] a = { new c(c.f, ""), new c(c.c, "GET"), new c(c.c, "POST"), new c(c.d, "/"), new c(c.d, "/index.html"), new c(c.e, "http"), new c(c.e, "https"), new c(c.b, "200"), new c(c.b, "204"), new c(c.b, "206"), new c(c.b, "304"), new c(c.b, "400"), new c(c.b, "404"), new c(c.b, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "") };
  static final Map<ByteString, Integer> b = a();
  private static final int c = 15;
  private static final int d = 31;
  private static final int e = 63;
  private static final int f = 127;
  
  private static Map<ByteString, Integer> a()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(a.length);
    int i = 0;
    while (i < a.length)
    {
      if (!localLinkedHashMap.containsKey(a[i].g)) {
        localLinkedHashMap.put(a[i].g, Integer.valueOf(i));
      }
      i += 1;
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  static ByteString a(ByteString paramByteString)
    throws IOException
  {
    int i = 0;
    int j = paramByteString.size();
    while (i < j)
    {
      int k = paramByteString.getByte(i);
      if ((k >= 65) && (k <= 90)) {
        throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + paramByteString.utf8());
      }
      i += 1;
    }
    return paramByteString;
  }
  
  static final class a
  {
    c[] a = new c[8];
    int b = this.a.length - 1;
    int c = 0;
    int d = 0;
    private final List<c> e = new ArrayList();
    private final BufferedSource f;
    private final int g;
    private int h;
    
    a(int paramInt1, int paramInt2, Source paramSource)
    {
      this.g = paramInt1;
      this.h = paramInt2;
      this.f = Okio.buffer(paramSource);
    }
    
    a(int paramInt, Source paramSource)
    {
      this(paramInt, paramInt, paramSource);
    }
    
    private int a(int paramInt)
    {
      int i = 0;
      int k = 0;
      if (paramInt > 0)
      {
        i = this.a.length - 1;
        int j = paramInt;
        paramInt = k;
        while ((i >= this.b) && (j > 0))
        {
          j -= this.a[i].i;
          this.d -= this.a[i].i;
          this.c -= 1;
          paramInt += 1;
          i -= 1;
        }
        System.arraycopy(this.a, this.b + 1, this.a, this.b + 1 + paramInt, this.c);
        this.b += paramInt;
        i = paramInt;
      }
      return i;
    }
    
    private void a(int paramInt, c paramc)
    {
      this.e.add(paramc);
      int j = paramc.i;
      int i = j;
      if (paramInt != -1) {
        i = j - this.a[c(paramInt)].i;
      }
      if (i > this.h)
      {
        f();
        return;
      }
      j = a(this.d + i - this.h);
      if (paramInt == -1)
      {
        if (this.c + 1 > this.a.length)
        {
          c[] arrayOfc = new c[this.a.length * 2];
          System.arraycopy(this.a, 0, arrayOfc, this.a.length, this.a.length);
          this.b = (this.a.length - 1);
          this.a = arrayOfc;
        }
        paramInt = this.b;
        this.b = (paramInt - 1);
        this.a[paramInt] = paramc;
        this.c += 1;
      }
      for (;;)
      {
        this.d += i;
        return;
        int k = c(paramInt);
        this.a[(paramInt + (k + j))] = paramc;
      }
    }
    
    private void b(int paramInt)
      throws IOException
    {
      if (g(paramInt))
      {
        c localc = d.a[paramInt];
        this.e.add(localc);
        return;
      }
      int i = c(paramInt - d.a.length);
      if ((i < 0) || (i > this.a.length - 1)) {
        throw new IOException("Header index too large " + (paramInt + 1));
      }
      this.e.add(this.a[i]);
    }
    
    private int c(int paramInt)
    {
      return this.b + 1 + paramInt;
    }
    
    private void d(int paramInt)
      throws IOException
    {
      ByteString localByteString1 = f(paramInt);
      ByteString localByteString2 = d();
      this.e.add(new c(localByteString1, localByteString2));
    }
    
    private void e()
    {
      if (this.h < this.d)
      {
        if (this.h == 0) {
          f();
        }
      }
      else {
        return;
      }
      a(this.d - this.h);
    }
    
    private void e(int paramInt)
      throws IOException
    {
      a(-1, new c(f(paramInt), d()));
    }
    
    private ByteString f(int paramInt)
    {
      if (g(paramInt)) {
        return d.a[paramInt].g;
      }
      return this.a[c(paramInt - d.a.length)].g;
    }
    
    private void f()
    {
      Arrays.fill(this.a, null);
      this.b = (this.a.length - 1);
      this.c = 0;
      this.d = 0;
    }
    
    private void g()
      throws IOException
    {
      ByteString localByteString1 = d.a(d());
      ByteString localByteString2 = d();
      this.e.add(new c(localByteString1, localByteString2));
    }
    
    private boolean g(int paramInt)
    {
      return (paramInt >= 0) && (paramInt <= d.a.length - 1);
    }
    
    private void h()
      throws IOException
    {
      a(-1, new c(d.a(d()), d()));
    }
    
    private int i()
      throws IOException
    {
      return this.f.readByte() & 0xFF;
    }
    
    int a()
    {
      return this.h;
    }
    
    int a(int paramInt1, int paramInt2)
      throws IOException
    {
      paramInt1 &= paramInt2;
      if (paramInt1 < paramInt2) {
        return paramInt1;
      }
      paramInt1 = 0;
      int i;
      for (;;)
      {
        i = i();
        if ((i & 0x80) == 0) {
          break;
        }
        paramInt2 += ((i & 0x7F) << paramInt1);
        paramInt1 += 7;
      }
      return paramInt2 + (i << paramInt1);
    }
    
    void b()
      throws IOException
    {
      while (!this.f.exhausted())
      {
        int i = this.f.readByte() & 0xFF;
        if (i == 128) {
          throw new IOException("index == 0");
        }
        if ((i & 0x80) == 128)
        {
          b(a(i, 127) - 1);
        }
        else if (i == 64)
        {
          h();
        }
        else if ((i & 0x40) == 64)
        {
          e(a(i, 63) - 1);
        }
        else if ((i & 0x20) == 32)
        {
          this.h = a(i, 31);
          if ((this.h < 0) || (this.h > this.g)) {
            throw new IOException("Invalid dynamic table size update " + this.h);
          }
          e();
        }
        else if ((i == 16) || (i == 0))
        {
          g();
        }
        else
        {
          d(a(i, 15) - 1);
        }
      }
    }
    
    public List<c> c()
    {
      ArrayList localArrayList = new ArrayList(this.e);
      this.e.clear();
      return localArrayList;
    }
    
    ByteString d()
      throws IOException
    {
      int j = i();
      if ((j & 0x80) == 128) {}
      for (int i = 1;; i = 0)
      {
        j = a(j, 127);
        if (i == 0) {
          break;
        }
        return ByteString.of(k.a().a(this.f.readByteArray(j)));
      }
      return this.f.readByteString(j);
    }
  }
  
  static final class b
  {
    private static final int g = 4096;
    private static final int h = 16384;
    int a;
    int b;
    c[] c = new c[8];
    int d = this.c.length - 1;
    int e = 0;
    int f = 0;
    private final Buffer i;
    private final boolean j;
    private int k = Integer.MAX_VALUE;
    private boolean l;
    
    b(int paramInt, boolean paramBoolean, Buffer paramBuffer)
    {
      this.a = paramInt;
      this.b = paramInt;
      this.j = paramBoolean;
      this.i = paramBuffer;
    }
    
    b(Buffer paramBuffer)
    {
      this(4096, true, paramBuffer);
    }
    
    private void a()
    {
      Arrays.fill(this.c, null);
      this.d = (this.c.length - 1);
      this.e = 0;
      this.f = 0;
    }
    
    private void a(c paramc)
    {
      int m = paramc.i;
      if (m > this.b)
      {
        a();
        return;
      }
      b(this.f + m - this.b);
      if (this.e + 1 > this.c.length)
      {
        c[] arrayOfc = new c[this.c.length * 2];
        System.arraycopy(this.c, 0, arrayOfc, this.c.length, this.c.length);
        this.d = (this.c.length - 1);
        this.c = arrayOfc;
      }
      int n = this.d;
      this.d = (n - 1);
      this.c[n] = paramc;
      this.e += 1;
      this.f += m;
    }
    
    private int b(int paramInt)
    {
      int m = 0;
      int i1 = 0;
      if (paramInt > 0)
      {
        m = this.c.length - 1;
        int n = paramInt;
        paramInt = i1;
        while ((m >= this.d) && (n > 0))
        {
          n -= this.c[m].i;
          this.f -= this.c[m].i;
          this.e -= 1;
          paramInt += 1;
          m -= 1;
        }
        System.arraycopy(this.c, this.d + 1, this.c, this.d + 1 + paramInt, this.e);
        Arrays.fill(this.c, this.d + 1, this.d + 1 + paramInt, null);
        this.d += paramInt;
        m = paramInt;
      }
      return m;
    }
    
    private void b()
    {
      if (this.b < this.f)
      {
        if (this.b == 0) {
          a();
        }
      }
      else {
        return;
      }
      b(this.f - this.b);
    }
    
    void a(int paramInt)
    {
      this.a = paramInt;
      paramInt = Math.min(paramInt, 16384);
      if (this.b == paramInt) {
        return;
      }
      if (paramInt < this.b) {
        this.k = Math.min(this.k, paramInt);
      }
      this.l = true;
      this.b = paramInt;
      b();
    }
    
    void a(int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt1 < paramInt2)
      {
        this.i.writeByte(paramInt3 | paramInt1);
        return;
      }
      this.i.writeByte(paramInt3 | paramInt2);
      paramInt1 -= paramInt2;
      while (paramInt1 >= 128)
      {
        this.i.writeByte(paramInt1 & 0x7F | 0x80);
        paramInt1 >>>= 7;
      }
      this.i.writeByte(paramInt1);
    }
    
    void a(List<c> paramList)
      throws IOException
    {
      if (this.l)
      {
        if (this.k < this.b) {
          a(this.k, 31, 32);
        }
        this.l = false;
        this.k = Integer.MAX_VALUE;
        a(this.b, 31, 32);
      }
      int i1 = 0;
      int i5 = paramList.size();
      if (i1 < i5)
      {
        c localc = (c)paramList.get(i1);
        ByteString localByteString1 = localc.g.toAsciiLowercase();
        ByteString localByteString2 = localc.h;
        int i3 = -1;
        int n = -1;
        Integer localInteger = (Integer)d.b.get(localByteString1);
        int m = i3;
        int i2;
        if (localInteger != null)
        {
          i2 = localInteger.intValue() + 1;
          m = i3;
          n = i2;
          if (i2 > 1)
          {
            m = i3;
            n = i2;
            if (i2 < 8)
            {
              if (!b.a.c.a(d.a[(i2 - 1)].h, localByteString2)) {
                break label309;
              }
              m = i2;
              n = i2;
            }
          }
        }
        label188:
        int i4 = m;
        i3 = n;
        if (m == -1)
        {
          i2 = this.d + 1;
          int i6 = this.c.length;
          label214:
          i4 = m;
          i3 = n;
          if (i2 < i6)
          {
            i3 = n;
            if (!b.a.c.a(this.c[i2].g, localByteString1)) {
              break label365;
            }
            if (!b.a.c.a(this.c[i2].h, localByteString2)) {
              break label343;
            }
            i4 = i2 - this.d + d.a.length;
            i3 = n;
          }
        }
        if (i4 != -1) {
          a(i4, 127, 128);
        }
        for (;;)
        {
          i1 += 1;
          break;
          label309:
          m = i3;
          n = i2;
          if (!b.a.c.a(d.a[i2].h, localByteString2)) {
            break label188;
          }
          m = i2 + 1;
          n = i2;
          break label188;
          label343:
          i3 = n;
          if (n == -1) {
            i3 = i2 - this.d + d.a.length;
          }
          label365:
          i2 += 1;
          n = i3;
          break label214;
          if (i3 == -1)
          {
            this.i.writeByte(64);
            a(localByteString1);
            a(localByteString2);
            a(localc);
          }
          else if ((localByteString1.startsWith(c.a)) && (!c.f.equals(localByteString1)))
          {
            a(i3, 15, 0);
            a(localByteString2);
          }
          else
          {
            a(i3, 63, 64);
            a(localByteString2);
            a(localc);
          }
        }
      }
    }
    
    void a(ByteString paramByteString)
      throws IOException
    {
      if ((this.j) && (k.a().a(paramByteString) < paramByteString.size()))
      {
        Buffer localBuffer = new Buffer();
        k.a().a(paramByteString, localBuffer);
        paramByteString = localBuffer.readByteString();
        a(paramByteString.size(), 127, 128);
        this.i.write(paramByteString);
        return;
      }
      a(paramByteString.size(), 127, 0);
      this.i.write(paramByteString);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */