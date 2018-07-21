package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.zip.Deflater;

public final class hn
  implements ho
{
  static final byte[] a;
  
  static
  {
    try
    {
      a = "\000\000\000\007options\000\000\000\004head\000\000\000\004post\000\000\000\003put\000\000\000\006delete\000\000\000\005trace\000\000\000\006accept\000\000\000\016accept-charset\000\000\000\017accept-encoding\000\000\000\017accept-language\000\000\000\raccept-ranges\000\000\000\003age\000\000\000\005allow\000\000\000\rauthorization\000\000\000\rcache-control\000\000\000\nconnection\000\000\000\fcontent-base\000\000\000\020content-encoding\000\000\000\020content-language\000\000\000\016content-length\000\000\000\020content-location\000\000\000\013content-md5\000\000\000\rcontent-range\000\000\000\fcontent-type\000\000\000\004date\000\000\000\004etag\000\000\000\006expect\000\000\000\007expires\000\000\000\004from\000\000\000\004host\000\000\000\bif-match\000\000\000\021if-modified-since\000\000\000\rif-none-match\000\000\000\bif-range\000\000\000\023if-unmodified-since\000\000\000\rlast-modified\000\000\000\blocation\000\000\000\fmax-forwards\000\000\000\006pragma\000\000\000\022proxy-authenticate\000\000\000\023proxy-authorization\000\000\000\005range\000\000\000\007referer\000\000\000\013retry-after\000\000\000\006server\000\000\000\002te\000\000\000\007trailer\000\000\000\021transfer-encoding\000\000\000\007upgrade\000\000\000\nuser-agent\000\000\000\004vary\000\000\000\003via\000\000\000\007warning\000\000\000\020www-authenticate\000\000\000\006method\000\000\000\003get\000\000\000\006status\000\000\000\006200 OK\000\000\000\007version\000\000\000\bHTTP/1.1\000\000\000\003url\000\000\000\006public\000\000\000\nset-cookie\000\000\000\nkeep-alive\000\000\000\006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(gy.c.name());
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError();
    }
  }
  
  public final ha a(ip paramip, boolean paramBoolean)
  {
    return new a(paramip, paramBoolean);
  }
  
  public final hb a(io paramio, boolean paramBoolean)
  {
    return new b(paramio, paramBoolean);
  }
  
  static final class a
    implements ha
  {
    private final ip a;
    private final boolean b;
    private final hj c;
    
    a(ip paramip, boolean paramBoolean)
    {
      this.a = paramip;
      this.c = new hj(this.a);
      this.b = paramBoolean;
    }
    
    private static IOException a(String paramString, Object... paramVarArgs)
      throws IOException
    {
      throw new IOException(String.format(paramString, paramVarArgs));
    }
    
    private void a(ha.a parama, int paramInt1, int paramInt2)
      throws IOException
    {
      boolean bool = true;
      int i = this.a.g();
      if (paramInt2 != i * 8 + 4) {
        throw a("TYPE_SETTINGS length: %d != 4 + 8 * %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i) });
      }
      hm localhm = new hm();
      paramInt2 = 0;
      while (paramInt2 < i)
      {
        int j = this.a.g();
        localhm.a(j & 0xFFFFFF, (0xFF000000 & j) >>> 24, this.a.g());
        paramInt2 += 1;
      }
      if ((paramInt1 & 0x1) != 0) {}
      for (;;)
      {
        parama.a(bool, localhm);
        return;
        bool = false;
      }
    }
    
    public final void a() {}
    
    public final boolean a(ha.a parama)
      throws IOException
    {
      boolean bool1 = false;
      boolean bool2 = false;
      int j;
      int m;
      int k;
      for (;;)
      {
        try
        {
          j = this.a.g();
          m = this.a.g();
          if ((0x80000000 & j) != 0)
          {
            i = 1;
            k = (0xFF000000 & m) >>> 24;
            m = 0xFFFFFF & m;
            if (i == 0) {
              break label711;
            }
            i = (0x7FFF0000 & j) >>> 16;
            if (i == 3) {
              break;
            }
            throw new ProtocolException("version != 3: " + i);
          }
        }
        catch (IOException parama)
        {
          return false;
        }
        i = 0;
      }
      Object localObject;
      switch (j & 0xFFFF)
      {
      case 5: 
      default: 
        this.a.f(m);
        return true;
      case 1: 
        i = this.a.g();
        this.a.g();
        this.a.f();
        localObject = this.c.a(m - 10);
        if ((k & 0x1) != 0) {}
        for (bool1 = true;; bool1 = false)
        {
          if ((k & 0x2) != 0) {
            bool2 = true;
          }
          parama.a(bool2, bool1, i & 0x7FFFFFFF, (List)localObject, hf.a);
          return true;
        }
      case 2: 
        i = this.a.g();
        localObject = this.c.a(m - 4);
        if ((k & 0x1) != 0) {}
        for (bool1 = true;; bool1 = false)
        {
          parama.a(false, bool1, i & 0x7FFFFFFF, (List)localObject, hf.b);
          return true;
        }
      case 3: 
        if (m != 8) {
          throw a("TYPE_RST_STREAM length: %d != 8", new Object[] { Integer.valueOf(m) });
        }
        i = this.a.g();
        j = this.a.g();
        localObject = gz.a(j);
        if (localObject == null) {
          throw a("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(j) });
        }
        parama.a(i & 0x7FFFFFFF, (gz)localObject);
        return true;
      case 4: 
        a(parama, k, m);
        return true;
      case 6: 
        if (m != 4) {
          throw a("TYPE_PING length: %d != 4", new Object[] { Integer.valueOf(m) });
        }
        i = this.a.g();
        bool2 = this.b;
        if ((i & 0x1) == 1)
        {
          bool1 = true;
          if (bool2 != bool1) {
            break label496;
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          parama.a(bool1, i, 0);
          return true;
          bool1 = false;
          break;
        }
      case 7: 
        if (m != 8) {
          throw a("TYPE_GOAWAY length: %d != 8", new Object[] { Integer.valueOf(m) });
        }
        i = this.a.g();
        j = this.a.g();
        if (gz.c(j) == null) {
          throw a("TYPE_GOAWAY unexpected error code: %d", new Object[] { Integer.valueOf(j) });
        }
        parama.a(i & 0x7FFFFFFF, iq.b);
        return true;
      case 8: 
        label496:
        parama.a(false, false, this.a.g() & 0x7FFFFFFF, this.c.a(m - 4), hf.c);
        return true;
      }
      if (m != 8) {
        throw a("TYPE_WINDOW_UPDATE length: %d != 8", new Object[] { Integer.valueOf(m) });
      }
      int i = this.a.g();
      long l = this.a.g() & 0x7FFFFFFF;
      if (l == 0L) {
        throw a("windowSizeIncrement was 0", new Object[] { Long.valueOf(l) });
      }
      parama.a(i & 0x7FFFFFFF, l);
      return true;
      label711:
      if ((k & 0x1) != 0) {
        bool1 = true;
      }
      parama.a(bool1, j & 0x7FFFFFFF, this.a, m);
      return true;
    }
    
    public final void close()
      throws IOException
    {
      this.c.b.close();
    }
  }
  
  static final class b
    implements hb
  {
    private final io a;
    private final in b;
    private final io c;
    private final boolean d;
    private boolean e;
    
    b(io paramio, boolean paramBoolean)
    {
      this.a = paramio;
      this.d = paramBoolean;
      paramio = new Deflater();
      paramio.setDictionary(hn.a);
      this.b = new in();
      this.c = ix.a(new ir(this.b, paramio));
    }
    
    private void a(List<he> paramList)
      throws IOException
    {
      this.c.h(paramList.size());
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        iq localiq = ((he)paramList.get(i)).h;
        this.c.h(localiq.c.length);
        this.c.b(localiq);
        localiq = ((he)paramList.get(i)).i;
        this.c.h(localiq.c.length);
        this.c.b(localiq);
        i += 1;
      }
      this.c.flush();
    }
    
    public final void a() {}
    
    public final void a(int paramInt, long paramLong)
      throws IOException
    {
      try
      {
        if (this.e) {
          throw new IOException("closed");
        }
      }
      finally {}
      if ((paramLong == 0L) || (paramLong > 2147483647L)) {
        throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + paramLong);
      }
      this.a.h(-2147287031);
      this.a.h(8);
      this.a.h(paramInt);
      this.a.h((int)paramLong);
      this.a.flush();
    }
    
    public final void a(int paramInt, gz paramgz)
      throws IOException
    {
      try
      {
        if (this.e) {
          throw new IOException("closed");
        }
      }
      finally {}
      if (paramgz.t == -1) {
        throw new IllegalArgumentException();
      }
      this.a.h(-2147287037);
      this.a.h(8);
      this.a.h(0x7FFFFFFF & paramInt);
      this.a.h(paramgz.t);
      this.a.flush();
    }
    
    public final void a(int paramInt, gz paramgz, byte[] paramArrayOfByte)
      throws IOException
    {
      try
      {
        if (this.e) {
          throw new IOException("closed");
        }
      }
      finally {}
      if (paramgz.u == -1) {
        throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
      }
      this.a.h(-2147287033);
      this.a.h(8);
      this.a.h(paramInt);
      this.a.h(paramgz.u);
      this.a.flush();
    }
    
    public final void a(hm paramhm) {}
    
    public final void a(boolean paramBoolean, int paramInt1, int paramInt2)
      throws IOException
    {
      boolean bool2 = true;
      try
      {
        if (this.e) {
          throw new IOException("closed");
        }
      }
      finally {}
      boolean bool3 = this.d;
      boolean bool1;
      if ((paramInt1 & 0x1) == 1) {
        bool1 = true;
      }
      for (;;)
      {
        if (paramBoolean != bool1) {
          throw new IllegalArgumentException("payload != reply");
        }
        this.a.h(-2147287034);
        this.a.h(4);
        this.a.h(paramInt1);
        this.a.flush();
        return;
        for (;;)
        {
          if (bool3 == bool1) {
            break label130;
          }
          bool1 = bool2;
          break;
          bool1 = false;
        }
        label130:
        bool1 = false;
      }
    }
    
    public final void a(boolean paramBoolean, int paramInt1, in paramin, int paramInt2)
      throws IOException
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 0) {
        try
        {
          if (!this.e) {
            break;
          }
          throw new IOException("closed");
        }
        finally {}
      }
      if (paramInt2 > 16777215L) {
        throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + paramInt2);
      }
      this.a.h(0x7FFFFFFF & paramInt1);
      this.a.h((i & 0xFF) << 24 | 0xFFFFFF & paramInt2);
      if (paramInt2 > 0) {
        this.a.a_(paramin, paramInt2);
      }
    }
    
    public final void a(boolean paramBoolean, int paramInt, List<he> paramList)
      throws IOException
    {
      int i = 0;
      try
      {
        if (this.e) {
          throw new IOException("closed");
        }
      }
      finally {}
      a(paramList);
      int j = (int)(10L + this.b.b);
      if (paramBoolean) {
        i = 1;
      }
      this.a.h(-2147287039);
      this.a.h(((i | 0x0) & 0xFF) << 24 | j & 0xFFFFFF);
      this.a.h(0x7FFFFFFF & paramInt);
      this.a.h(0);
      this.a.i(0);
      this.a.a(this.b);
      this.a.flush();
    }
    
    public final void b()
      throws IOException
    {
      try
      {
        if (this.e) {
          throw new IOException("closed");
        }
      }
      finally {}
      this.a.flush();
    }
    
    public final void b(hm paramhm)
      throws IOException
    {
      try
      {
        if (this.e) {
          throw new IOException("closed");
        }
      }
      finally {}
      int i = Integer.bitCount(paramhm.a);
      this.a.h(-2147287036);
      this.a.h(i * 8 + 4 & 0xFFFFFF | 0x0);
      this.a.h(i);
      i = 0;
      for (;;)
      {
        if (i <= 10)
        {
          if (paramhm.a(i))
          {
            int j = paramhm.b(i);
            this.a.h((j & 0xFF) << 24 | i & 0xFFFFFF);
            this.a.h(paramhm.d[i]);
          }
        }
        else
        {
          this.a.flush();
          return;
        }
        i += 1;
      }
    }
    
    public final int c()
    {
      return 16383;
    }
    
    public final void close()
      throws IOException
    {
      try
      {
        this.e = true;
        gy.a(this.a, this.c);
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/hn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */