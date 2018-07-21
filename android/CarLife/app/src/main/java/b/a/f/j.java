package b.a.f;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

final class j
  implements Closeable
{
  private static final Logger b = Logger.getLogger(e.class.getName());
  final d.b a;
  private final BufferedSink c;
  private final boolean d;
  private final Buffer e;
  private int f;
  private boolean g;
  
  public j(BufferedSink paramBufferedSink, boolean paramBoolean)
  {
    this.c = paramBufferedSink;
    this.d = paramBoolean;
    this.e = new Buffer();
    this.a = new d.b(this.e);
    this.f = 16384;
  }
  
  private static void a(BufferedSink paramBufferedSink, int paramInt)
    throws IOException
  {
    paramBufferedSink.writeByte(paramInt >>> 16 & 0xFF);
    paramBufferedSink.writeByte(paramInt >>> 8 & 0xFF);
    paramBufferedSink.writeByte(paramInt & 0xFF);
  }
  
  private void b(int paramInt, long paramLong)
    throws IOException
  {
    if (paramLong > 0L)
    {
      int i = (int)Math.min(this.f, paramLong);
      paramLong -= i;
      if (paramLong == 0L) {}
      for (byte b1 = 4;; b1 = 0)
      {
        a(paramInt, i, (byte)9, b1);
        this.c.write(this.e, i);
        break;
      }
    }
  }
  
  public void a()
    throws IOException
  {
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    boolean bool = this.d;
    if (!bool) {}
    for (;;)
    {
      return;
      if (b.isLoggable(Level.FINE)) {
        b.fine(b.a.c.a(">> CONNECTION %s", new Object[] { e.a.hex() }));
      }
      this.c.write(e.a.toByteArray());
      this.c.flush();
    }
  }
  
  void a(int paramInt1, byte paramByte, Buffer paramBuffer, int paramInt2)
    throws IOException
  {
    a(paramInt1, paramInt2, (byte)0, paramByte);
    if (paramInt2 > 0) {
      this.c.write(paramBuffer, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
    throws IOException
  {
    if (b.isLoggable(Level.FINE)) {
      b.fine(e.a(false, paramInt1, paramInt2, paramByte1, paramByte2));
    }
    if (paramInt2 > this.f) {
      throw e.a("FRAME_SIZE_ERROR length > %d: %d", new Object[] { Integer.valueOf(this.f), Integer.valueOf(paramInt2) });
    }
    if ((0x80000000 & paramInt1) != 0) {
      throw e.a("reserved bit set: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    a(this.c, paramInt2);
    this.c.writeByte(paramByte1 & 0xFF);
    this.c.writeByte(paramByte2 & 0xFF);
    this.c.writeInt(0x7FFFFFFF & paramInt1);
  }
  
  public void a(int paramInt1, int paramInt2, List<c> paramList)
    throws IOException
  {
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    this.a.a(paramList);
    long l = this.e.size();
    int i = (int)Math.min(this.f - 4, l);
    if (l == i) {}
    for (byte b1 = 4;; b1 = 0)
    {
      a(paramInt1, i + 4, (byte)5, b1);
      this.c.writeInt(0x7FFFFFFF & paramInt2);
      this.c.write(this.e, i);
      if (l > i) {
        b(paramInt1, l - i);
      }
      return;
    }
  }
  
  public void a(int paramInt, long paramLong)
    throws IOException
  {
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    if ((paramLong == 0L) || (paramLong > 2147483647L)) {
      throw e.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[] { Long.valueOf(paramLong) });
    }
    a(paramInt, 4, (byte)8, (byte)0);
    this.c.writeInt((int)paramLong);
    this.c.flush();
  }
  
  public void a(int paramInt, b paramb)
    throws IOException
  {
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    if (paramb.g == -1) {
      throw new IllegalArgumentException();
    }
    a(paramInt, 4, (byte)3, (byte)0);
    this.c.writeInt(paramb.g);
    this.c.flush();
  }
  
  public void a(int paramInt, b paramb, byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    if (paramb.g == -1) {
      throw e.a("errorCode.httpCode == -1", new Object[0]);
    }
    a(0, paramArrayOfByte.length + 8, (byte)7, (byte)0);
    this.c.writeInt(paramInt);
    this.c.writeInt(paramb.g);
    if (paramArrayOfByte.length > 0) {
      this.c.write(paramArrayOfByte);
    }
    this.c.flush();
  }
  
  public void a(int paramInt, List<c> paramList)
    throws IOException
  {
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    b(false, paramInt, paramList);
  }
  
  public void a(n paramn)
    throws IOException
  {
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    this.f = paramn.d(this.f);
    if (paramn.c() != -1) {
      this.a.a(paramn.c());
    }
    a(0, 0, (byte)4, (byte)1);
    this.c.flush();
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    if (paramBoolean) {}
    for (byte b1 = 1;; b1 = 0)
    {
      a(0, 8, (byte)6, b1);
      this.c.writeInt(paramInt1);
      this.c.writeInt(paramInt2);
      this.c.flush();
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, List<c> paramList)
    throws IOException
  {
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    b(paramBoolean, paramInt1, paramList);
  }
  
  public void a(boolean paramBoolean, int paramInt, List<c> paramList)
    throws IOException
  {
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    b(paramBoolean, paramInt, paramList);
  }
  
  public void a(boolean paramBoolean, int paramInt1, Buffer paramBuffer, int paramInt2)
    throws IOException
  {
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    byte b1 = 0;
    if (paramBoolean) {
      b1 = (byte)1;
    }
    a(paramInt1, b1, paramBuffer, paramInt2);
  }
  
  public void b()
    throws IOException
  {
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    this.c.flush();
  }
  
  public void b(n paramn)
    throws IOException
  {
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    a(0, paramn.b() * 6, (byte)4, (byte)0);
    int i = 0;
    if (i < 10) {
      if (paramn.a(i)) {
        break label105;
      }
    }
    for (;;)
    {
      int j;
      this.c.writeShort(j);
      this.c.writeInt(paramn.b(i));
      break label98;
      this.c.flush();
      return;
      label98:
      i += 1;
      break;
      label105:
      int k = i;
      if (k == 4)
      {
        j = 3;
      }
      else
      {
        j = k;
        if (k == 7) {
          j = 4;
        }
      }
    }
  }
  
  void b(boolean paramBoolean, int paramInt, List<c> paramList)
    throws IOException
  {
    if (this.g) {
      throw new IOException("closed");
    }
    this.a.a(paramList);
    long l = this.e.size();
    int i = (int)Math.min(this.f, l);
    if (l == i) {}
    for (byte b1 = 4;; b1 = 0)
    {
      byte b2 = b1;
      if (paramBoolean) {
        b2 = (byte)(b1 | 0x1);
      }
      a(paramInt, i, (byte)1, b2);
      this.c.write(this.e, i);
      if (l > i) {
        b(paramInt, l - i);
      }
      return;
    }
  }
  
  public int c()
  {
    return this.f;
  }
  
  public void close()
    throws IOException
  {
    try
    {
      this.g = true;
      this.c.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/f/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */