package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class hh
  implements ho
{
  private static final Logger a = Logger.getLogger(b.class.getName());
  private static final iq b = iq.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
  
  private static IOException c(String paramString, Object... paramVarArgs)
    throws IOException
  {
    throw new IOException(String.format(paramString, paramVarArgs));
  }
  
  public final ha a(ip paramip, boolean paramBoolean)
  {
    return new c(paramip, paramBoolean);
  }
  
  public final hb a(io paramio, boolean paramBoolean)
  {
    return new d(paramio, paramBoolean);
  }
  
  static final class a
    implements jd
  {
    int a;
    byte b;
    int c;
    int d;
    short e;
    private final ip f;
    
    public a(ip paramip)
    {
      this.f = paramip;
    }
    
    public final long a(in paramin, long paramLong)
      throws IOException
    {
      if (this.d == 0)
      {
        this.f.f(this.e);
        this.e = 0;
        if ((this.b & 0x4) == 0) {}
      }
      do
      {
        return -1L;
        int i = this.c;
        int j = hh.a(this.f);
        this.d = j;
        this.a = j;
        byte b1 = (byte)(this.f.e() & 0xFF);
        this.b = ((byte)(this.f.e() & 0xFF));
        if (hh.b().isLoggable(Level.FINE)) {
          hh.b().fine(hh.b.a(true, this.c, this.a, b1, this.b));
        }
        this.c = (this.f.g() & 0x7FFFFFFF);
        if (b1 != 9) {
          throw hh.a("%s != TYPE_CONTINUATION", new Object[] { Byte.valueOf(b1) });
        }
        if (this.c == i) {
          break;
        }
        throw hh.a("TYPE_CONTINUATION streamId changed", new Object[0]);
        paramLong = this.f.a(paramin, Math.min(paramLong, this.d));
      } while (paramLong == -1L);
      this.d = ((int)(this.d - paramLong));
      return paramLong;
    }
    
    public final je a()
    {
      return this.f.a();
    }
    
    public final void close()
      throws IOException
    {}
  }
  
  static final class b
  {
    private static final String[] a;
    private static final String[] b;
    private static final String[] c;
    
    static
    {
      int k = 0;
      a = new String[] { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION" };
      b = new String[64];
      c = new String['Ā'];
      int i = 0;
      while (i < c.length)
      {
        c[i] = String.format("%8s", new Object[] { Integer.toBinaryString(i) }).replace(' ', '0');
        i += 1;
      }
      b[0] = "";
      b[1] = "END_STREAM";
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = 1;
      b[8] = "PADDED";
      i = 0;
      int j;
      while (i <= 0)
      {
        j = arrayOfInt[i];
        b[(j | 0x8)] = (b[j] + "|PADDED");
        i += 1;
      }
      b[4] = "END_HEADERS";
      b[32] = "PRIORITY";
      b[36] = "END_HEADERS|PRIORITY";
      i = 0;
      for (;;)
      {
        j = k;
        if (i >= 3) {
          break;
        }
        int m = new int[] { 4, 32, 36 }[i];
        j = 0;
        while (j <= 0)
        {
          int n = arrayOfInt[j];
          b[(n | m)] = (b[n] + '|' + b[m]);
          b[(n | m | 0x8)] = (b[n] + '|' + b[m] + "|PADDED");
          j += 1;
        }
        i += 1;
      }
      while (j < b.length)
      {
        if (b[j] == null) {
          b[j] = c[j];
        }
        j += 1;
      }
    }
    
    static String a(boolean paramBoolean, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
    {
      String str2;
      Object localObject;
      if (paramByte1 < a.length)
      {
        str2 = a[paramByte1];
        if (paramByte2 != 0) {
          break label92;
        }
        localObject = "";
        label24:
        if (!paramBoolean) {
          break label259;
        }
      }
      label92:
      label225:
      label259:
      for (String str1 = "<<";; str1 = ">>")
      {
        return String.format("%s 0x%08x %5d %-13s %s", new Object[] { str1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str2, localObject });
        str2 = String.format("0x%02x", new Object[] { Byte.valueOf(paramByte1) });
        break;
        switch (paramByte1)
        {
        case 5: 
        default: 
          if (paramByte2 >= b.length) {
            break;
          }
        }
        for (str1 = b[paramByte2];; str1 = c[paramByte2])
        {
          if ((paramByte1 != 5) || ((paramByte2 & 0x4) == 0)) {
            break label225;
          }
          localObject = str1.replace("HEADERS", "PUSH_PROMISE");
          break;
          if (paramByte2 == 1)
          {
            localObject = "ACK";
            break;
          }
          localObject = c[paramByte2];
          break;
          localObject = c[paramByte2];
          break;
        }
        localObject = str1;
        if (paramByte1 != 0) {
          break label24;
        }
        localObject = str1;
        if ((paramByte2 & 0x20) == 0) {
          break label24;
        }
        localObject = str1.replace("PRIORITY", "COMPRESSED");
        break label24;
      }
    }
  }
  
  static final class c
    implements ha
  {
    final hg.a a;
    private final ip b;
    private final hh.a c;
    private final boolean d;
    
    c(ip paramip, boolean paramBoolean)
    {
      this.b = paramip;
      this.d = paramBoolean;
      this.c = new hh.a(this.b);
      this.a = new hg.a(this.c);
    }
    
    private List<he> a(int paramInt1, short paramShort, byte paramByte, int paramInt2)
      throws IOException
    {
      Object localObject1 = this.c;
      this.c.d = paramInt1;
      ((hh.a)localObject1).a = paramInt1;
      this.c.e = paramShort;
      this.c.b = paramByte;
      this.c.c = paramInt2;
      localObject1 = this.a;
      while (!((hg.a)localObject1).b.d())
      {
        paramInt1 = ((hg.a)localObject1).b.e() & 0xFF;
        if (paramInt1 == 128) {
          throw new IOException("index == 0");
        }
        if ((paramInt1 & 0x80) == 128)
        {
          paramInt1 = ((hg.a)localObject1).a(paramInt1, 127) - 1;
          if (hg.a.c(paramInt1))
          {
            localObject2 = hg.a()[paramInt1];
            ((hg.a)localObject1).a.add(localObject2);
          }
          else
          {
            paramInt2 = ((hg.a)localObject1).a(paramInt1 - hg.a().length);
            if ((paramInt2 < 0) || (paramInt2 > ((hg.a)localObject1).e.length - 1)) {
              throw new IOException("Header index too large " + (paramInt1 + 1));
            }
            ((hg.a)localObject1).a.add(localObject1.e[paramInt2]);
          }
        }
        else if (paramInt1 == 64)
        {
          ((hg.a)localObject1).a(new he(hg.a(((hg.a)localObject1).b()), ((hg.a)localObject1).b()));
        }
        else if ((paramInt1 & 0x40) == 64)
        {
          ((hg.a)localObject1).a(new he(((hg.a)localObject1).b(((hg.a)localObject1).a(paramInt1, 63) - 1), ((hg.a)localObject1).b()));
        }
        else if ((paramInt1 & 0x20) == 32)
        {
          ((hg.a)localObject1).d = ((hg.a)localObject1).a(paramInt1, 31);
          if ((((hg.a)localObject1).d < 0) || (((hg.a)localObject1).d > ((hg.a)localObject1).c)) {
            throw new IOException("Invalid dynamic table size update " + ((hg.a)localObject1).d);
          }
          ((hg.a)localObject1).a();
        }
        else
        {
          iq localiq;
          if ((paramInt1 == 16) || (paramInt1 == 0))
          {
            localObject2 = hg.a(((hg.a)localObject1).b());
            localiq = ((hg.a)localObject1).b();
            ((hg.a)localObject1).a.add(new he((iq)localObject2, localiq));
          }
          else
          {
            localObject2 = ((hg.a)localObject1).b(((hg.a)localObject1).a(paramInt1, 15) - 1);
            localiq = ((hg.a)localObject1).b();
            ((hg.a)localObject1).a.add(new he((iq)localObject2, localiq));
          }
        }
      }
      localObject1 = this.a;
      Object localObject2 = new ArrayList(((hg.a)localObject1).a);
      ((hg.a)localObject1).a.clear();
      return (List<he>)localObject2;
    }
    
    private void b()
      throws IOException
    {
      this.b.g();
      this.b.e();
    }
    
    public final void a()
      throws IOException
    {
      if (this.d) {}
      iq localiq;
      do
      {
        return;
        localiq = this.b.c(hh.a().c.length);
        if (hh.b().isLoggable(Level.FINE)) {
          hh.b().fine(String.format("<< CONNECTION %s", new Object[] { localiq.b() }));
        }
      } while (hh.a().equals(localiq));
      throw hh.a("Expected a connection header but was %s", new Object[] { localiq.a() });
    }
    
    public final boolean a(ha.a parama)
      throws IOException
    {
      boolean bool1 = true;
      int j = 0;
      boolean bool2 = false;
      int i = 0;
      int n;
      byte b2;
      label250:
      label256:
      label426:
      label608:
      label833:
      do
      {
        do
        {
          try
          {
            this.b.a(9L);
            n = hh.a(this.b);
            if ((n < 0) || (n > 16384)) {
              throw hh.a("FRAME_SIZE_ERROR: %s", new Object[] { Integer.valueOf(n) });
            }
          }
          catch (IOException parama)
          {
            bool1 = false;
            return bool1;
          }
          byte b1 = (byte)(this.b.e() & 0xFF);
          b2 = (byte)(this.b.e() & 0xFF);
          m = this.b.g() & 0x7FFFFFFF;
          if (hh.b().isLoggable(Level.FINE)) {
            hh.b().fine(hh.b.a(true, m, n, b1, b2));
          }
          switch (b1)
          {
          default: 
            this.b.f(n);
            return true;
          case 0: 
            if ((b2 & 0x1) != 0)
            {
              bool1 = true;
              if ((b2 & 0x20) == 0) {
                break label250;
              }
            }
            for (k = 1;; k = 0)
            {
              if (k == 0) {
                break label256;
              }
              throw hh.a("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
              bool1 = false;
              break;
            }
            if ((b2 & 0x8) != 0) {
              i = (short)(this.b.e() & 0xFF);
            }
            k = hh.a(n, b2, i);
            parama.a(bool1, m, this.b, k);
            this.b.f(i);
            return true;
          case 1: 
            if (m == 0) {
              throw hh.a("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            }
            if ((b2 & 0x1) != 0)
            {
              bool1 = true;
              if ((b2 & 0x8) == 0) {
                break label426;
              }
            }
            for (i = (short)(this.b.e() & 0xFF);; i = 0)
            {
              k = n;
              if ((b2 & 0x20) != 0)
              {
                b();
                k = n - 5;
              }
              parama.a(false, bool1, m, a(hh.a(k, b2, i), i, b2, m), hf.d);
              return true;
              bool1 = false;
              break;
            }
          case 2: 
            if (n != 5) {
              throw hh.a("TYPE_PRIORITY length: %d != 5", new Object[] { Integer.valueOf(n) });
            }
            if (m == 0) {
              throw hh.a("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
            b();
            return true;
          case 3: 
            if (n != 4) {
              throw hh.a("TYPE_RST_STREAM length: %d != 4", new Object[] { Integer.valueOf(n) });
            }
            if (m == 0) {
              throw hh.a("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
            k = this.b.g();
            localObject = gz.b(k);
            if (localObject == null) {
              throw hh.a("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(k) });
            }
            parama.a(m, (gz)localObject);
            return true;
          case 4: 
            if (m != 0) {
              throw hh.a("TYPE_SETTINGS streamId != 0", new Object[0]);
            }
            if ((b2 & 0x1) == 0) {
              break label608;
            }
          }
        } while (n == 0);
        throw hh.a("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        if (n % 6 != 0) {
          throw hh.a("TYPE_SETTINGS length %% 6 != 0: %s", new Object[] { Integer.valueOf(n) });
        }
        localObject = new hm();
        k = 0;
        if (k < n)
        {
          i = this.b.f();
          int i1 = this.b.g();
          m = i;
          switch (i)
          {
          default: 
            throw hh.a("PROTOCOL_ERROR invalid settings id: %s", new Object[] { Short.valueOf(i) });
          case 2: 
            m = i;
            if (i1 != 0)
            {
              m = i;
              if (i1 != 1) {
                throw hh.a("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
              }
            }
            break;
          case 3: 
            m = 4;
          }
          do
          {
            do
            {
              ((hm)localObject).a(m, 0, i1);
              k += 6;
              break;
              m = 7;
            } while (i1 >= 0);
            throw hh.a("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
            if (i1 < 16384) {
              break label833;
            }
            m = i;
          } while (i1 <= 16777215);
          throw hh.a("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[] { Integer.valueOf(i1) });
        }
        parama.a(false, (hm)localObject);
      } while (((hm)localObject).a() < 0);
      parama = this.a;
      int k = ((hm)localObject).a();
      parama.c = k;
      parama.d = k;
      parama.a();
      return true;
      if (m == 0) {
        throw hh.a("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
      }
      i = j;
      if ((b2 & 0x8) != 0) {
        i = (short)(this.b.e() & 0xFF);
      }
      parama.a(this.b.g() & 0x7FFFFFFF, a(hh.a(n - 4, b2, i), i, b2, m));
      return true;
      if (n != 8) {
        throw hh.a("TYPE_PING length != 8: %s", new Object[] { Integer.valueOf(n) });
      }
      if (m != 0) {
        throw hh.a("TYPE_PING streamId != 0", new Object[0]);
      }
      k = this.b.g();
      int m = this.b.g();
      bool1 = bool2;
      if ((b2 & 0x1) != 0) {
        bool1 = true;
      }
      parama.a(bool1, k, m);
      return true;
      if (n < 8) {
        throw hh.a("TYPE_GOAWAY length < 8: %s", new Object[] { Integer.valueOf(n) });
      }
      if (m != 0) {
        throw hh.a("TYPE_GOAWAY streamId != 0", new Object[0]);
      }
      k = this.b.g();
      m = this.b.g();
      n -= 8;
      if (gz.b(m) == null) {
        throw hh.a("TYPE_GOAWAY unexpected error code: %d", new Object[] { Integer.valueOf(m) });
      }
      Object localObject = iq.b;
      if (n > 0) {
        localObject = this.b.c(n);
      }
      parama.a(k, (iq)localObject);
      return true;
      if (n != 4) {
        throw hh.a("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] { Integer.valueOf(n) });
      }
      long l = this.b.g() & 0x7FFFFFFF;
      if (l == 0L) {
        throw hh.a("windowSizeIncrement was 0", new Object[] { Long.valueOf(l) });
      }
      parama.a(m, l);
      return true;
    }
    
    public final void close()
      throws IOException
    {
      this.b.close();
    }
  }
  
  static final class d
    implements hb
  {
    private final io a;
    private final boolean b;
    private final in c;
    private final hg.b d;
    private int e;
    private boolean f;
    
    d(io paramio, boolean paramBoolean)
    {
      this.a = paramio;
      this.b = paramBoolean;
      this.c = new in();
      this.d = new hg.b(this.c);
      this.e = 16384;
    }
    
    private void a(int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
      throws IOException
    {
      if (hh.b().isLoggable(Level.FINE)) {
        hh.b().fine(hh.b.a(false, paramInt1, paramInt2, paramByte1, paramByte2));
      }
      if (paramInt2 > this.e) {
        throw hh.b("FRAME_SIZE_ERROR length > %d: %d", new Object[] { Integer.valueOf(this.e), Integer.valueOf(paramInt2) });
      }
      if ((0x80000000 & paramInt1) != 0) {
        throw hh.b("reserved bit set: %s", new Object[] { Integer.valueOf(paramInt1) });
      }
      hh.a(this.a, paramInt2);
      this.a.j(paramByte1 & 0xFF);
      this.a.j(paramByte2 & 0xFF);
      this.a.h(0x7FFFFFFF & paramInt1);
    }
    
    private void b(int paramInt, long paramLong)
      throws IOException
    {
      if (paramLong > 0L)
      {
        int i = (int)Math.min(this.e, paramLong);
        paramLong -= i;
        if (paramLong == 0L) {}
        for (byte b1 = 4;; b1 = 0)
        {
          a(paramInt, i, (byte)9, b1);
          this.a.a_(this.c, i);
          break;
        }
      }
    }
    
    public final void a()
      throws IOException
    {
      try
      {
        if (this.f) {
          throw new IOException("closed");
        }
      }
      finally {}
      boolean bool = this.b;
      if (!bool) {}
      for (;;)
      {
        return;
        if (hh.b().isLoggable(Level.FINE)) {
          hh.b().fine(String.format(">> CONNECTION %s", new Object[] { hh.a().b() }));
        }
        this.a.b(hh.a().d());
        this.a.flush();
      }
    }
    
    public final void a(int paramInt, long paramLong)
      throws IOException
    {
      try
      {
        if (this.f) {
          throw new IOException("closed");
        }
      }
      finally {}
      if ((paramLong == 0L) || (paramLong > 2147483647L)) {
        throw hh.b("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[] { Long.valueOf(paramLong) });
      }
      a(paramInt, 4, (byte)8, (byte)0);
      this.a.h((int)paramLong);
      this.a.flush();
    }
    
    public final void a(int paramInt, gz paramgz)
      throws IOException
    {
      try
      {
        if (this.f) {
          throw new IOException("closed");
        }
      }
      finally {}
      if (paramgz.s == -1) {
        throw new IllegalArgumentException();
      }
      a(paramInt, 4, (byte)3, (byte)0);
      this.a.h(paramgz.s);
      this.a.flush();
    }
    
    public final void a(int paramInt, gz paramgz, byte[] paramArrayOfByte)
      throws IOException
    {
      try
      {
        if (this.f) {
          throw new IOException("closed");
        }
      }
      finally {}
      if (paramgz.s == -1) {
        throw hh.b("errorCode.httpCode == -1", new Object[0]);
      }
      a(0, paramArrayOfByte.length + 8, (byte)7, (byte)0);
      this.a.h(paramInt);
      this.a.h(paramgz.s);
      if (paramArrayOfByte.length > 0) {
        this.a.b(paramArrayOfByte);
      }
      this.a.flush();
    }
    
    public final void a(hm paramhm)
      throws IOException
    {
      try
      {
        if (this.f) {
          throw new IOException("closed");
        }
      }
      finally {}
      int i = this.e;
      if ((paramhm.a & 0x20) != 0) {
        i = paramhm.d[5];
      }
      this.e = i;
      a(0, 0, (byte)4, (byte)1);
      this.a.flush();
    }
    
    public final void a(boolean paramBoolean, int paramInt1, int paramInt2)
      throws IOException
    {
      byte b1 = 0;
      try
      {
        if (this.f) {
          throw new IOException("closed");
        }
      }
      finally {}
      if (paramBoolean) {
        b1 = 1;
      }
      a(0, 8, (byte)6, b1);
      this.a.h(paramInt1);
      this.a.h(paramInt2);
      this.a.flush();
    }
    
    public final void a(boolean paramBoolean, int paramInt1, in paramin, int paramInt2)
      throws IOException
    {
      byte b1 = 0;
      try
      {
        if (this.f) {
          throw new IOException("closed");
        }
      }
      finally {}
      if (paramBoolean) {
        b1 = 1;
      }
      a(paramInt1, paramInt2, (byte)0, b1);
      if (paramInt2 > 0) {
        this.a.a_(paramin, paramInt2);
      }
    }
    
    public final void a(boolean paramBoolean, int paramInt, List<he> paramList)
      throws IOException
    {
      try
      {
        if (this.f) {
          throw new IOException("closed");
        }
      }
      finally {}
      if (this.f) {
        throw new IOException("closed");
      }
      this.d.a(paramList);
      long l = this.c.b;
      int i = (int)Math.min(this.e, l);
      byte b1;
      if (l == i) {
        b1 = 4;
      }
      for (;;)
      {
        a(paramInt, i, (byte)1, b2);
        this.a.a_(this.c, i);
        if (l > i) {
          b(paramInt, l - i);
        }
        return;
        b1 = 0;
        byte b2 = b1;
        if (paramBoolean) {
          b2 = (byte)(b1 | 0x1);
        }
      }
    }
    
    public final void b()
      throws IOException
    {
      try
      {
        if (this.f) {
          throw new IOException("closed");
        }
      }
      finally {}
      this.a.flush();
    }
    
    public final void b(hm paramhm)
      throws IOException
    {
      int i = 0;
      try
      {
        if (this.f) {
          throw new IOException("closed");
        }
      }
      finally {}
      a(0, Integer.bitCount(paramhm.a) * 6, (byte)4, (byte)0);
      int j;
      if (i < 10)
      {
        if (!paramhm.a(i)) {
          break label111;
        }
        if (i != 4) {
          break label118;
        }
        j = 3;
      }
      for (;;)
      {
        label64:
        this.a.i(j);
        this.a.h(paramhm.d[i]);
        break label111;
        this.a.flush();
        return;
        label111:
        label118:
        do
        {
          j = i;
          break label64;
          i += 1;
          break;
        } while (i != 7);
        j = 4;
      }
    }
    
    public final int c()
    {
      return this.e;
    }
    
    public final void close()
      throws IOException
    {
      try
      {
        this.f = true;
        this.a.close();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/hh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */