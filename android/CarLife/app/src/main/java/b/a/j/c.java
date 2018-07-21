package b.a.j;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Timeout;

final class c
{
  final boolean a;
  final BufferedSource b;
  final a c;
  boolean d;
  int e;
  long f;
  long g;
  boolean h;
  boolean i;
  boolean j;
  final byte[] k = new byte[4];
  final byte[] l = new byte[' '];
  
  c(boolean paramBoolean, BufferedSource paramBufferedSource, a parama)
  {
    if (paramBufferedSource == null) {
      throw new NullPointerException("source == null");
    }
    if (parama == null) {
      throw new NullPointerException("frameCallback == null");
    }
    this.a = paramBoolean;
    this.b = paramBufferedSource;
    this.c = parama;
  }
  
  private void a(Buffer paramBuffer)
    throws IOException
  {
    if (this.d) {
      throw new IOException("closed");
    }
    if (this.g == this.f)
    {
      if (this.h) {}
      do
      {
        return;
        b();
        if (this.e != 0) {
          throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.e));
        }
      } while ((this.h) && (this.f == 0L));
    }
    long l1 = this.f - this.g;
    if (this.j)
    {
      l1 = Math.min(l1, this.l.length);
      l1 = this.b.read(this.l, 0, (int)l1);
      if (l1 == -1L) {
        throw new EOFException();
      }
      b.a(this.l, l1, this.k, this.g);
      paramBuffer.write(this.l, 0, (int)l1);
    }
    long l2;
    do
    {
      this.g += l1;
      break;
      l2 = this.b.read(paramBuffer, l1);
      l1 = l2;
    } while (l2 != -1L);
    throw new EOFException();
  }
  
  private void c()
    throws IOException
  {
    boolean bool2 = true;
    if (this.d) {
      throw new IOException("closed");
    }
    long l1 = this.b.timeout().timeoutNanos();
    this.b.timeout().clearTimeout();
    boolean bool1;
    for (;;)
    {
      try
      {
        m = this.b.readByte();
        i1 = m & 0xFF;
        this.b.timeout().timeout(l1, TimeUnit.NANOSECONDS);
        this.e = (i1 & 0xF);
        if ((i1 & 0x80) != 0)
        {
          bool1 = true;
          this.h = bool1;
          if ((i1 & 0x8) == 0) {
            break label175;
          }
          bool1 = true;
          this.i = bool1;
          if ((!this.i) || (this.h)) {
            break;
          }
          throw new ProtocolException("Control frames must be final.");
        }
      }
      finally
      {
        this.b.timeout().timeout(l1, TimeUnit.NANOSECONDS);
      }
      bool1 = false;
      continue;
      label175:
      bool1 = false;
    }
    int n;
    if ((i1 & 0x40) != 0)
    {
      m = 1;
      if ((i1 & 0x20) == 0) {
        break label235;
      }
      n = 1;
      label199:
      if ((i1 & 0x10) == 0) {
        break label240;
      }
    }
    label235:
    label240:
    for (int i1 = 1;; i1 = 0)
    {
      if ((m == 0) && (n == 0) && (i1 == 0)) {
        break label245;
      }
      throw new ProtocolException("Reserved flags are unsupported.");
      m = 0;
      break;
      n = 0;
      break label199;
    }
    label245:
    int m = this.b.readByte() & 0xFF;
    if ((m & 0x80) != 0)
    {
      bool1 = bool2;
      this.j = bool1;
      if (this.j != this.a) {
        break label322;
      }
      if (!this.a) {
        break label315;
      }
    }
    label315:
    for (String str = "Server-sent frames must not be masked.";; str = "Client-sent frames must be masked.")
    {
      throw new ProtocolException(str);
      bool1 = false;
      break;
    }
    label322:
    this.f = (m & 0x7F);
    if (this.f == 126L) {
      this.f = (this.b.readShort() & 0xFFFF);
    }
    do
    {
      do
      {
        this.g = 0L;
        if ((!this.i) || (this.f <= 125L)) {
          break;
        }
        throw new ProtocolException("Control frame must be less than 125B.");
      } while (this.f != 127L);
      this.f = this.b.readLong();
    } while (this.f >= 0L);
    throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f) + " > 0x7FFFFFFFFFFFFFFF");
    if (this.j) {
      this.b.readFully(this.k);
    }
  }
  
  private void d()
    throws IOException
  {
    Object localObject = new Buffer();
    if (this.g < this.f)
    {
      if (!this.a) {
        break label145;
      }
      this.b.readFully((Buffer)localObject, this.f);
    }
    switch (this.e)
    {
    default: 
      throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.e));
      do
      {
        b.a(this.l, m, this.k, this.g);
        ((Buffer)localObject).write(this.l, 0, m);
        this.g += m;
        if (this.g >= this.f) {
          break;
        }
        m = (int)Math.min(this.f - this.g, this.l.length);
        m = this.b.read(this.l, 0, m);
      } while (m != -1);
      throw new EOFException();
    case 9: 
      this.c.c(((Buffer)localObject).readByteString());
      return;
    case 10: 
      label145:
      this.c.d(((Buffer)localObject).readByteString());
      return;
    }
    int m = 1005;
    String str = "";
    long l1 = ((Buffer)localObject).size();
    if (l1 == 1L) {
      throw new ProtocolException("Malformed close payload length of 1.");
    }
    if (l1 != 0L)
    {
      m = ((Buffer)localObject).readShort();
      str = ((Buffer)localObject).readUtf8();
      localObject = b.a(m);
      if (localObject != null) {
        throw new ProtocolException((String)localObject);
      }
    }
    this.c.b(m, str);
    this.d = true;
  }
  
  private void e()
    throws IOException
  {
    int m = this.e;
    if ((m != 1) && (m != 2)) {
      throw new ProtocolException("Unknown opcode: " + Integer.toHexString(m));
    }
    Buffer localBuffer = new Buffer();
    a(localBuffer);
    if (m == 1)
    {
      this.c.b(localBuffer.readUtf8());
      return;
    }
    this.c.b(localBuffer.readByteString());
  }
  
  void a()
    throws IOException
  {
    c();
    if (this.i)
    {
      d();
      return;
    }
    e();
  }
  
  void b()
    throws IOException
  {
    for (;;)
    {
      if (!this.d)
      {
        c();
        if (this.i) {}
      }
      else
      {
        return;
      }
      d();
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(int paramInt, String paramString);
    
    public abstract void b(String paramString)
      throws IOException;
    
    public abstract void b(ByteString paramByteString)
      throws IOException;
    
    public abstract void c(ByteString paramByteString);
    
    public abstract void d(ByteString paramByteString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/j/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */