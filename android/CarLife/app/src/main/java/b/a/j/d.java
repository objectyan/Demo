package b.a.j;

import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

final class d
{
  final boolean a;
  final Random b;
  final BufferedSink c;
  boolean d;
  final Buffer e = new Buffer();
  final a f = new a();
  boolean g;
  final byte[] h;
  final byte[] i;
  
  static
  {
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      j = bool;
      return;
    }
  }
  
  d(boolean paramBoolean, BufferedSink paramBufferedSink, Random paramRandom)
  {
    if (paramBufferedSink == null) {
      throw new NullPointerException("sink == null");
    }
    if (paramRandom == null) {
      throw new NullPointerException("random == null");
    }
    this.a = paramBoolean;
    this.c = paramBufferedSink;
    this.b = paramRandom;
    if (paramBoolean) {}
    for (paramBufferedSink = new byte[4];; paramBufferedSink = null)
    {
      this.h = paramBufferedSink;
      paramBufferedSink = (BufferedSink)localObject;
      if (paramBoolean) {
        paramBufferedSink = new byte[' '];
      }
      this.i = paramBufferedSink;
      return;
    }
  }
  
  private void b(int paramInt, ByteString paramByteString)
    throws IOException
  {
    if ((!j) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    if (this.d) {
      throw new IOException("closed");
    }
    int k = paramByteString.size();
    if (k > 125L) {
      throw new IllegalArgumentException("Payload size must be less than or equal to 125");
    }
    this.c.writeByte(paramInt | 0x80);
    if (this.a)
    {
      this.c.writeByte(k | 0x80);
      this.b.nextBytes(this.h);
      this.c.write(this.h);
      paramByteString = paramByteString.toByteArray();
      b.a(paramByteString, paramByteString.length, this.h, 0L);
      this.c.write(paramByteString);
    }
    for (;;)
    {
      this.c.flush();
      return;
      this.c.writeByte(k);
      this.c.write(paramByteString);
    }
  }
  
  Sink a(int paramInt, long paramLong)
  {
    if (this.g) {
      throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }
    this.g = true;
    this.f.a = paramInt;
    this.f.b = paramLong;
    this.f.c = true;
    this.f.d = false;
    return this.f;
  }
  
  void a(int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    if ((!j) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    if (this.d) {
      throw new IOException("closed");
    }
    if (paramBoolean1)
    {
      int k = paramInt;
      if (paramBoolean2) {
        k = paramInt | 0x80;
      }
      this.c.writeByte(k);
      paramInt = 0;
      if (this.a) {
        paramInt = 0x0 | 0x80;
      }
      if (paramLong > 125L) {
        break label197;
      }
      k = (int)paramLong;
      this.c.writeByte(paramInt | k);
      label111:
      if (!this.a) {
        break label303;
      }
      this.b.nextBytes(this.h);
      this.c.write(this.h);
    }
    for (long l = 0L;; l += paramInt)
    {
      if (l >= paramLong) {
        break label317;
      }
      paramInt = (int)Math.min(paramLong, this.i.length);
      paramInt = this.e.read(this.i, 0, paramInt);
      if (paramInt == -1)
      {
        throw new AssertionError();
        paramInt = 0;
        break;
        label197:
        if (paramLong <= 65535L)
        {
          this.c.writeByte(paramInt | 0x7E);
          this.c.writeShort((int)paramLong);
          break label111;
        }
        this.c.writeByte(paramInt | 0x7F);
        this.c.writeLong(paramLong);
        break label111;
      }
      b.a(this.i, paramInt, this.h, l);
      this.c.write(this.i, 0, paramInt);
    }
    label303:
    this.c.write(this.e, paramLong);
    label317:
    this.c.emit();
  }
  
  /* Error */
  void a(int paramInt, ByteString paramByteString)
    throws IOException
  {
    // Byte code:
    //   0: getstatic 179	okio/ByteString:EMPTY	Lokio/ByteString;
    //   3: astore_3
    //   4: iload_1
    //   5: ifne +7 -> 12
    //   8: aload_2
    //   9: ifnull +40 -> 49
    //   12: iload_1
    //   13: ifeq +7 -> 20
    //   16: iload_1
    //   17: invokestatic 182	b/a/j/b:b	(I)V
    //   20: new 39	okio/Buffer
    //   23: dup
    //   24: invokespecial 40	okio/Buffer:<init>	()V
    //   27: astore_3
    //   28: aload_3
    //   29: iload_1
    //   30: invokevirtual 185	okio/Buffer:writeShort	(I)Lokio/Buffer;
    //   33: pop
    //   34: aload_2
    //   35: ifnull +9 -> 44
    //   38: aload_3
    //   39: aload_2
    //   40: invokevirtual 188	okio/Buffer:write	(Lokio/ByteString;)Lokio/Buffer;
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 192	okio/Buffer:readByteString	()Lokio/ByteString;
    //   48: astore_3
    //   49: aload_0
    //   50: monitorenter
    //   51: aload_0
    //   52: bipush 8
    //   54: aload_3
    //   55: invokespecial 194	b/a/j/d:b	(ILokio/ByteString;)V
    //   58: aload_0
    //   59: iconst_1
    //   60: putfield 80	b/a/j/d:d	Z
    //   63: aload_0
    //   64: monitorexit
    //   65: return
    //   66: astore_2
    //   67: aload_0
    //   68: iconst_1
    //   69: putfield 80	b/a/j/d:d	Z
    //   72: aload_2
    //   73: athrow
    //   74: astore_2
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_2
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	d
    //   0	79	1	paramInt	int
    //   0	79	2	paramByteString	ByteString
    //   3	52	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   51	58	66	finally
    //   58	65	74	finally
    //   67	74	74	finally
    //   75	77	74	finally
  }
  
  void a(ByteString paramByteString)
    throws IOException
  {
    try
    {
      b(9, paramByteString);
      return;
    }
    finally {}
  }
  
  void b(ByteString paramByteString)
    throws IOException
  {
    try
    {
      b(10, paramByteString);
      return;
    }
    finally {}
  }
  
  final class a
    implements Sink
  {
    int a;
    long b;
    boolean c;
    boolean d;
    
    a() {}
    
    public void close()
      throws IOException
    {
      if (this.d) {
        throw new IOException("closed");
      }
      synchronized (d.this)
      {
        d.this.a(this.a, d.this.e.size(), this.c, true);
        this.d = true;
        d.this.g = false;
        return;
      }
    }
    
    public void flush()
      throws IOException
    {
      if (this.d) {
        throw new IOException("closed");
      }
      synchronized (d.this)
      {
        d.this.a(this.a, d.this.e.size(), this.c, false);
        this.c = false;
        return;
      }
    }
    
    public Timeout timeout()
    {
      return d.this.c.timeout();
    }
    
    public void write(Buffer arg1, long paramLong)
      throws IOException
    {
      if (this.d) {
        throw new IOException("closed");
      }
      d.this.e.write(???, paramLong);
      int i;
      if ((this.c) && (this.b != -1L) && (d.this.e.size() > this.b - 8192L)) {
        i = 1;
      }
      for (;;)
      {
        paramLong = d.this.e.completeSegmentByteCount();
        if ((paramLong > 0L) && (i == 0)) {}
        synchronized (d.this)
        {
          d.this.a(this.a, paramLong, this.c, false);
          this.c = false;
          return;
          i = 0;
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/j/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */