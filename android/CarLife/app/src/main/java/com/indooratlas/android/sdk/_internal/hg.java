package com.indooratlas.android.sdk._internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class hg
{
  private static final he[] a;
  private static final Map<iq, Integer> b;
  
  static
  {
    int i = 0;
    a = new he[] { new he(he.e, ""), new he(he.b, "GET"), new he(he.b, "POST"), new he(he.c, "/"), new he(he.c, "/index.html"), new he(he.d, "http"), new he(he.d, "https"), new he(he.a, "200"), new he(he.a, "204"), new he(he.a, "206"), new he(he.a, "304"), new he(he.a, "400"), new he(he.a, "404"), new he(he.a, "500"), new he("accept-charset", ""), new he("accept-encoding", "gzip, deflate"), new he("accept-language", ""), new he("accept-ranges", ""), new he("accept", ""), new he("access-control-allow-origin", ""), new he("age", ""), new he("allow", ""), new he("authorization", ""), new he("cache-control", ""), new he("content-disposition", ""), new he("content-encoding", ""), new he("content-language", ""), new he("content-length", ""), new he("content-location", ""), new he("content-range", ""), new he("content-type", ""), new he("cookie", ""), new he("date", ""), new he("etag", ""), new he("expect", ""), new he("expires", ""), new he("from", ""), new he("host", ""), new he("if-match", ""), new he("if-modified-since", ""), new he("if-none-match", ""), new he("if-range", ""), new he("if-unmodified-since", ""), new he("last-modified", ""), new he("link", ""), new he("location", ""), new he("max-forwards", ""), new he("proxy-authenticate", ""), new he("proxy-authorization", ""), new he("range", ""), new he("referer", ""), new he("refresh", ""), new he("retry-after", ""), new he("server", ""), new he("set-cookie", ""), new he("strict-transport-security", ""), new he("transfer-encoding", ""), new he("user-agent", ""), new he("vary", ""), new he("via", ""), new he("www-authenticate", "") };
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(a.length);
    while (i < a.length)
    {
      if (!localLinkedHashMap.containsKey(a[i].h)) {
        localLinkedHashMap.put(a[i].h, Integer.valueOf(i));
      }
      i += 1;
    }
    b = Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  static final class a
  {
    final List<he> a = new ArrayList();
    final ip b;
    int c = 4096;
    int d = 4096;
    he[] e = new he[8];
    int f = this.e.length - 1;
    int g = 0;
    int h = 0;
    
    a(jd paramjd)
    {
      this.b = ix.a(paramjd);
    }
    
    private void c()
    {
      this.a.clear();
      Arrays.fill(this.e, null);
      this.f = (this.e.length - 1);
      this.g = 0;
      this.h = 0;
    }
    
    static boolean c(int paramInt)
    {
      return (paramInt >= 0) && (paramInt <= hg.a().length - 1);
    }
    
    private int d()
      throws IOException
    {
      return this.b.e() & 0xFF;
    }
    
    private int d(int paramInt)
    {
      int i = 0;
      int k = 0;
      if (paramInt > 0)
      {
        i = this.e.length - 1;
        int j = paramInt;
        paramInt = k;
        while ((i >= this.f) && (j > 0))
        {
          j -= this.e[i].j;
          this.h -= this.e[i].j;
          this.g -= 1;
          paramInt += 1;
          i -= 1;
        }
        System.arraycopy(this.e, this.f + 1, this.e, this.f + 1 + paramInt, this.g);
        this.f += paramInt;
        i = paramInt;
      }
      return i;
    }
    
    final int a(int paramInt)
    {
      return this.f + 1 + paramInt;
    }
    
    final int a(int paramInt1, int paramInt2)
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
        i = d();
        if ((i & 0x80) == 0) {
          break;
        }
        paramInt2 += ((i & 0x7F) << paramInt1);
        paramInt1 += 7;
      }
      return (i << paramInt1) + paramInt2;
    }
    
    final void a()
    {
      if (this.d < this.h)
      {
        if (this.d == 0) {
          c();
        }
      }
      else {
        return;
      }
      d(this.h - this.d);
    }
    
    final void a(he paramhe)
    {
      this.a.add(paramhe);
      int i = paramhe.j;
      if (i > this.d)
      {
        c();
        return;
      }
      d(this.h + i - this.d);
      if (this.g + 1 > this.e.length)
      {
        he[] arrayOfhe = new he[this.e.length * 2];
        System.arraycopy(this.e, 0, arrayOfhe, this.e.length, this.e.length);
        this.f = (this.e.length - 1);
        this.e = arrayOfhe;
      }
      int j = this.f;
      this.f = (j - 1);
      this.e[j] = paramhe;
      this.g += 1;
      this.h = (i + this.h);
    }
    
    final iq b()
      throws IOException
    {
      int j = 0;
      int k = d();
      int i;
      hi localhi;
      byte[] arrayOfByte;
      ByteArrayOutputStream localByteArrayOutputStream;
      hi.a locala1;
      if ((k & 0x80) == 128)
      {
        i = 1;
        k = a(k, 127);
        if (i != 0)
        {
          localhi = hi.a();
          arrayOfByte = this.b.e(k);
          localByteArrayOutputStream = new ByteArrayOutputStream();
          locala1 = localhi.a;
          k = 0;
          i = 0;
        }
      }
      else
      {
        int m;
        hi.a locala2;
        for (;;)
        {
          m = i;
          locala2 = locala1;
          if (j >= arrayOfByte.length) {
            break label183;
          }
          k = k << 8 | arrayOfByte[j] & 0xFF;
          i += 8;
          for (;;)
          {
            if (i < 8) {
              break label176;
            }
            locala1 = locala1.a[(k >>> i - 8 & 0xFF)];
            if (locala1.a == null)
            {
              localByteArrayOutputStream.write(locala1.b);
              i -= locala1.c;
              locala1 = localhi.a;
              continue;
              i = 0;
              break;
            }
            i -= 8;
          }
          label176:
          j += 1;
        }
        label183:
        while (m > 0)
        {
          locala1 = locala2.a[(k << 8 - m & 0xFF)];
          if ((locala1.a != null) || (locala1.c > m)) {
            break;
          }
          localByteArrayOutputStream.write(locala1.b);
          m -= locala1.c;
          locala2 = localhi.a;
        }
        return iq.a(localByteArrayOutputStream.toByteArray());
      }
      return this.b.c(k);
    }
    
    final iq b(int paramInt)
    {
      if (c(paramInt)) {
        return hg.a()[paramInt].h;
      }
      return this.e[a(paramInt - hg.a().length)].h;
    }
  }
  
  static final class b
  {
    private final in a;
    
    b(in paramin)
    {
      this.a = paramin;
    }
    
    private void a(int paramInt1, int paramInt2)
      throws IOException
    {
      if (paramInt1 < paramInt2)
      {
        this.a.b(paramInt1 | 0x0);
        return;
      }
      this.a.b(paramInt2 | 0x0);
      paramInt1 -= paramInt2;
      while (paramInt1 >= 128)
      {
        this.a.b(paramInt1 & 0x7F | 0x80);
        paramInt1 >>>= 7;
      }
      this.a.b(paramInt1);
    }
    
    private void a(iq paramiq)
      throws IOException
    {
      a(paramiq.c.length, 127);
      this.a.a(paramiq);
    }
    
    final void a(List<he> paramList)
      throws IOException
    {
      int j = paramList.size();
      int i = 0;
      if (i < j)
      {
        iq localiq = ((he)paramList.get(i)).h.c();
        Integer localInteger = (Integer)hg.b().get(localiq);
        if (localInteger != null)
        {
          a(localInteger.intValue() + 1, 15);
          a(((he)paramList.get(i)).i);
        }
        for (;;)
        {
          i += 1;
          break;
          this.a.b(0);
          a(localiq);
          a(((he)paramList.get(i)).i);
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/hg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */