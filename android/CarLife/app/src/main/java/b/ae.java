package b;

import b.a.c;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okio.Buffer;
import okio.BufferedSource;

public abstract class ae
  implements Closeable
{
  private Reader a;
  
  public static ae a(w paramw, final long paramLong, BufferedSource paramBufferedSource)
  {
    if (paramBufferedSource == null) {
      throw new NullPointerException("source == null");
    }
    new ae()
    {
      public w a()
      {
        return this.a;
      }
      
      public long b()
      {
        return paramLong;
      }
      
      public BufferedSource c()
      {
        return this.c;
      }
    };
  }
  
  public static ae a(w paramw, String paramString)
  {
    Object localObject = c.e;
    w localw = paramw;
    if (paramw != null)
    {
      Charset localCharset = paramw.c();
      localObject = localCharset;
      localw = paramw;
      if (localCharset == null)
      {
        localObject = c.e;
        localw = w.a(paramw + "; charset=utf-8");
      }
    }
    paramw = new Buffer().writeString(paramString, (Charset)localObject);
    return a(localw, paramw.size(), paramw);
  }
  
  public static ae a(w paramw, byte[] paramArrayOfByte)
  {
    Buffer localBuffer = new Buffer().write(paramArrayOfByte);
    return a(paramw, paramArrayOfByte.length, localBuffer);
  }
  
  private Charset h()
  {
    w localw = a();
    if (localw != null) {
      return localw.a(c.e);
    }
    return c.e;
  }
  
  public abstract w a();
  
  public abstract long b();
  
  public abstract BufferedSource c();
  
  public void close()
  {
    c.a(c());
  }
  
  public final InputStream d()
  {
    return c().inputStream();
  }
  
  public final byte[] e()
    throws IOException
  {
    long l = b();
    if (l > 2147483647L) {
      throw new IOException("Cannot buffer entire body for content length: " + l);
    }
    BufferedSource localBufferedSource = c();
    try
    {
      byte[] arrayOfByte1 = localBufferedSource.readByteArray();
      c.a(localBufferedSource);
      if ((l != -1L) && (l != arrayOfByte1.length)) {
        throw new IOException("Content-Length (" + l + ") and stream length (" + arrayOfByte1.length + ") disagree");
      }
    }
    finally
    {
      c.a(localBufferedSource);
    }
    return arrayOfByte2;
  }
  
  public final Reader f()
  {
    Object localObject = this.a;
    if (localObject != null) {
      return (Reader)localObject;
    }
    localObject = new a(c(), h());
    this.a = ((Reader)localObject);
    return (Reader)localObject;
  }
  
  public final String g()
    throws IOException
  {
    BufferedSource localBufferedSource = c();
    try
    {
      String str = localBufferedSource.readString(c.a(localBufferedSource, h()));
      return str;
    }
    finally
    {
      c.a(localBufferedSource);
    }
  }
  
  static final class a
    extends Reader
  {
    private final BufferedSource a;
    private final Charset b;
    private boolean c;
    private Reader d;
    
    a(BufferedSource paramBufferedSource, Charset paramCharset)
    {
      this.a = paramBufferedSource;
      this.b = paramCharset;
    }
    
    public void close()
      throws IOException
    {
      this.c = true;
      if (this.d != null)
      {
        this.d.close();
        return;
      }
      this.a.close();
    }
    
    public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
      throws IOException
    {
      if (this.c) {
        throw new IOException("Stream closed");
      }
      Reader localReader = this.d;
      Object localObject = localReader;
      if (localReader == null)
      {
        localObject = c.a(this.a, this.b);
        localObject = new InputStreamReader(this.a.inputStream(), (Charset)localObject);
        this.d = ((Reader)localObject);
      }
      return ((Reader)localObject).read(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */