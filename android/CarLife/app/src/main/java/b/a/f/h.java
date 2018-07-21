package b.a.f;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

final class h
  implements Closeable
{
  static final Logger a = Logger.getLogger(e.class.getName());
  final d.a b;
  private final BufferedSource c;
  private final a d;
  private final boolean e;
  
  public h(BufferedSource paramBufferedSource, boolean paramBoolean)
  {
    this.c = paramBufferedSource;
    this.e = paramBoolean;
    this.d = new a(this.c);
    this.b = new d.a(4096, this.d);
  }
  
  static int a(int paramInt, byte paramByte, short paramShort)
    throws IOException
  {
    short s = paramInt;
    if ((paramByte & 0x8) != 0) {
      s = paramInt - 1;
    }
    if (paramShort > s) {
      throw e.b("PROTOCOL_ERROR padding %s > remaining length %s", new Object[] { Short.valueOf(paramShort), Integer.valueOf(s) });
    }
    return (short)(s - paramShort);
  }
  
  static int a(BufferedSource paramBufferedSource)
    throws IOException
  {
    return (paramBufferedSource.readByte() & 0xFF) << 16 | (paramBufferedSource.readByte() & 0xFF) << 8 | paramBufferedSource.readByte() & 0xFF;
  }
  
  private List<c> a(int paramInt1, short paramShort, byte paramByte, int paramInt2)
    throws IOException
  {
    a locala = this.d;
    this.d.d = paramInt1;
    locala.a = paramInt1;
    this.d.e = paramShort;
    this.d.b = paramByte;
    this.d.c = paramInt2;
    this.b.b();
    return this.b.c();
  }
  
  private void a(b paramb, int paramInt)
    throws IOException
  {
    int i = this.c.readInt();
    if ((0x80000000 & i) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramb.a(paramInt, i & 0x7FFFFFFF, (this.c.readByte() & 0xFF) + 1, bool);
      return;
    }
  }
  
  private void a(b paramb, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    short s = 0;
    if (paramInt2 == 0) {
      throw e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }
    if ((paramByte & 0x1) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((paramByte & 0x8) != 0) {
        s = (short)(this.c.readByte() & 0xFF);
      }
      int i = paramInt1;
      if ((paramByte & 0x20) != 0)
      {
        a(paramb, paramInt2);
        i = paramInt1 - 5;
      }
      paramb.a(bool, paramInt2, -1, a(a(i, paramByte, s), s, paramByte, paramInt2));
      return;
    }
  }
  
  private void b(b paramb, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    int i = 1;
    short s = 0;
    boolean bool;
    if ((paramByte & 0x1) != 0)
    {
      bool = true;
      if ((paramByte & 0x20) == 0) {
        break label43;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label49;
      }
      throw e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
      bool = false;
      break;
      label43:
      i = 0;
    }
    label49:
    if ((paramByte & 0x8) != 0) {
      s = (short)(this.c.readByte() & 0xFF);
    }
    paramInt1 = a(paramInt1, paramByte, s);
    paramb.a(bool, paramInt2, this.c, paramInt1);
    this.c.skip(s);
  }
  
  private void c(b paramb, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    if (paramInt1 != 5) {
      throw e.b("TYPE_PRIORITY length: %d != 5", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (paramInt2 == 0) {
      throw e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
    }
    a(paramb, paramInt2);
  }
  
  private void d(b paramb, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    if (paramInt1 != 4) {
      throw e.b("TYPE_RST_STREAM length: %d != 4", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (paramInt2 == 0) {
      throw e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
    }
    paramInt1 = this.c.readInt();
    b localb = b.a(paramInt1);
    if (localb == null) {
      throw e.b("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(paramInt1) });
    }
    paramb.a(paramInt2, localb);
  }
  
  private void e(b paramb, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    if (paramInt2 != 0) {
      throw e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
    }
    if ((paramByte & 0x1) != 0)
    {
      if (paramInt1 != 0) {
        throw e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
      }
      paramb.a();
      return;
    }
    if (paramInt1 % 6 != 0) {
      throw e.b("TYPE_SETTINGS length %% 6 != 0: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    n localn = new n();
    paramInt2 = 0;
    if (paramInt2 < paramInt1)
    {
      byte b1 = this.c.readShort();
      int i = this.c.readInt();
      paramByte = b1;
      switch (b1)
      {
      default: 
        paramByte = b1;
      }
      do
      {
        do
        {
          for (;;)
          {
            localn.a(paramByte, i);
            paramInt2 += 6;
            break;
            paramByte = b1;
            if (i != 0)
            {
              paramByte = b1;
              if (i != 1)
              {
                throw e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                paramByte = 4;
              }
            }
          }
          paramByte = 7;
        } while (i >= 0);
        throw e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
        if (i < 16384) {
          break label238;
        }
        paramByte = b1;
      } while (i <= 16777215);
      label238:
      throw e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[] { Integer.valueOf(i) });
    }
    paramb.a(false, localn);
  }
  
  private void f(b paramb, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    short s = 0;
    if (paramInt2 == 0) {
      throw e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }
    if ((paramByte & 0x8) != 0) {
      s = (short)(this.c.readByte() & 0xFF);
    }
    paramb.a(paramInt2, this.c.readInt() & 0x7FFFFFFF, a(a(paramInt1 - 4, paramByte, s), s, paramByte, paramInt2));
  }
  
  private void g(b paramb, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    boolean bool = true;
    if (paramInt1 != 8) {
      throw e.b("TYPE_PING length != 8: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (paramInt2 != 0) {
      throw e.b("TYPE_PING streamId != 0", new Object[0]);
    }
    paramInt1 = this.c.readInt();
    paramInt2 = this.c.readInt();
    if ((paramByte & 0x1) != 0) {}
    for (;;)
    {
      paramb.a(bool, paramInt1, paramInt2);
      return;
      bool = false;
    }
  }
  
  private void h(b paramb, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    if (paramInt1 < 8) {
      throw e.b("TYPE_GOAWAY length < 8: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (paramInt2 != 0) {
      throw e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
    }
    paramByte = this.c.readInt();
    paramInt2 = this.c.readInt();
    paramInt1 -= 8;
    b localb = b.a(paramInt2);
    if (localb == null) {
      throw e.b("TYPE_GOAWAY unexpected error code: %d", new Object[] { Integer.valueOf(paramInt2) });
    }
    ByteString localByteString = ByteString.EMPTY;
    if (paramInt1 > 0) {
      localByteString = this.c.readByteString(paramInt1);
    }
    paramb.a(paramByte, localb, localByteString);
  }
  
  private void i(b paramb, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    if (paramInt1 != 4) {
      throw e.b("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    long l = this.c.readInt() & 0x7FFFFFFF;
    if (l == 0L) {
      throw e.b("windowSizeIncrement was 0", new Object[] { Long.valueOf(l) });
    }
    paramb.a(paramInt2, l);
  }
  
  public void a()
    throws IOException
  {
    if (this.e) {}
    ByteString localByteString;
    do
    {
      return;
      localByteString = this.c.readByteString(e.a.size());
      if (a.isLoggable(Level.FINE)) {
        a.fine(b.a.c.a("<< CONNECTION %s", new Object[] { localByteString.hex() }));
      }
    } while (e.a.equals(localByteString));
    throw e.b("Expected a connection header but was %s", new Object[] { localByteString.utf8() });
  }
  
  public boolean a(b paramb)
    throws IOException
  {
    int i;
    try
    {
      this.c.require(9L);
      i = a(this.c);
      if ((i < 0) || (i > 16384)) {
        throw e.b("FRAME_SIZE_ERROR: %s", new Object[] { Integer.valueOf(i) });
      }
    }
    catch (IOException paramb)
    {
      return false;
    }
    byte b1 = (byte)(this.c.readByte() & 0xFF);
    byte b2 = (byte)(this.c.readByte() & 0xFF);
    int j = this.c.readInt() & 0x7FFFFFFF;
    if (a.isLoggable(Level.FINE)) {
      a.fine(e.a(true, j, i, b1, b2));
    }
    switch (b1)
    {
    default: 
      this.c.skip(i);
      return true;
    case 0: 
      b(paramb, i, b2, j);
      return true;
    case 1: 
      a(paramb, i, b2, j);
      return true;
    case 2: 
      c(paramb, i, b2, j);
      return true;
    case 3: 
      d(paramb, i, b2, j);
      return true;
    case 4: 
      e(paramb, i, b2, j);
      return true;
    case 5: 
      f(paramb, i, b2, j);
      return true;
    case 6: 
      g(paramb, i, b2, j);
      return true;
    case 7: 
      h(paramb, i, b2, j);
      return true;
    }
    i(paramb, i, b2, j);
    return true;
  }
  
  public void close()
    throws IOException
  {
    this.c.close();
  }
  
  static final class a
    implements Source
  {
    int a;
    byte b;
    int c;
    int d;
    short e;
    private final BufferedSource f;
    
    public a(BufferedSource paramBufferedSource)
    {
      this.f = paramBufferedSource;
    }
    
    private void a()
      throws IOException
    {
      int i = this.c;
      int j = h.a(this.f);
      this.d = j;
      this.a = j;
      byte b1 = (byte)(this.f.readByte() & 0xFF);
      this.b = ((byte)(this.f.readByte() & 0xFF));
      if (h.a.isLoggable(Level.FINE)) {
        h.a.fine(e.a(true, this.c, this.a, b1, this.b));
      }
      this.c = (this.f.readInt() & 0x7FFFFFFF);
      if (b1 != 9) {
        throw e.b("%s != TYPE_CONTINUATION", new Object[] { Byte.valueOf(b1) });
      }
      if (this.c != i) {
        throw e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
      }
    }
    
    public void close()
      throws IOException
    {}
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      while (this.d == 0)
      {
        this.f.skip(this.e);
        this.e = 0;
        if ((this.b & 0x4) != 0) {
          return -1L;
        }
        a();
      }
      paramLong = this.f.read(paramBuffer, Math.min(paramLong, this.d));
      if (paramLong == -1L) {
        return -1L;
      }
      this.d = ((int)(this.d - paramLong));
      return paramLong;
    }
    
    public Timeout timeout()
    {
      return this.f.timeout();
    }
  }
  
  static abstract interface b
  {
    public abstract void a();
    
    public abstract void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
    
    public abstract void a(int paramInt1, int paramInt2, List<c> paramList)
      throws IOException;
    
    public abstract void a(int paramInt, long paramLong);
    
    public abstract void a(int paramInt, b paramb);
    
    public abstract void a(int paramInt, b paramb, ByteString paramByteString);
    
    public abstract void a(int paramInt1, String paramString1, ByteString paramByteString, String paramString2, int paramInt2, long paramLong);
    
    public abstract void a(boolean paramBoolean, int paramInt1, int paramInt2);
    
    public abstract void a(boolean paramBoolean, int paramInt1, int paramInt2, List<c> paramList);
    
    public abstract void a(boolean paramBoolean, int paramInt1, BufferedSource paramBufferedSource, int paramInt2)
      throws IOException;
    
    public abstract void a(boolean paramBoolean, n paramn);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/f/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */