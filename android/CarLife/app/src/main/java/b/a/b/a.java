package b.a.b;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import okio.Buffer;

final class a
{
  private static final int a = 8192;
  private final byte[] b = new byte[' '];
  private final ByteBuffer c = ByteBuffer.wrap(this.b);
  private final FileChannel d;
  
  public a(FileChannel paramFileChannel)
  {
    this.d = paramFileChannel;
  }
  
  public void a(long paramLong1, Buffer paramBuffer, long paramLong2)
    throws IOException
  {
    long l;
    if (paramLong2 >= 0L)
    {
      l = paramLong2;
      if (paramLong2 <= paramBuffer.size()) {}
    }
    else
    {
      throw new IndexOutOfBoundsException();
    }
    while (l > 0L) {
      try
      {
        int i = (int)Math.min(8192L, l);
        paramBuffer.read(this.b, 0, i);
        this.c.limit(i);
        paramLong2 = paramLong1;
        boolean bool;
        do
        {
          paramLong1 = paramLong2 + this.d.write(this.c, paramLong2);
          bool = this.c.hasRemaining();
          paramLong2 = paramLong1;
        } while (bool);
        l -= i;
        this.c.clear();
      }
      finally
      {
        this.c.clear();
      }
    }
  }
  
  public void b(long paramLong1, Buffer paramBuffer, long paramLong2)
    throws IOException
  {
    long l = paramLong1;
    paramLong1 = paramLong2;
    if (paramLong2 < 0L) {
      throw new IndexOutOfBoundsException();
    }
    try
    {
      do
      {
        int i = this.c.position();
        paramBuffer.write(this.b, 0, i);
        l += i;
        paramLong1 -= i;
        this.c.clear();
        if (paramLong1 <= 0L) {
          break;
        }
        this.c.limit((int)Math.min(8192L, paramLong1));
      } while (this.d.read(this.c, l) != -1);
      throw new EOFException();
    }
    finally
    {
      this.c.clear();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */