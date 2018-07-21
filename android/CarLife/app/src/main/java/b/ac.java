package b;

import b.a.c;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;

public abstract class ac
{
  public static ac a(w paramw, final File paramFile)
  {
    if (paramFile == null) {
      throw new NullPointerException("content == null");
    }
    new ac()
    {
      public void a(BufferedSink paramAnonymousBufferedSink)
        throws IOException
      {
        Object localObject = null;
        try
        {
          Source localSource = Okio.source(paramFile);
          localObject = localSource;
          paramAnonymousBufferedSink.writeAll(localSource);
          c.a(localSource);
          return;
        }
        finally
        {
          c.a((Closeable)localObject);
        }
      }
      
      public w b()
      {
        return this.a;
      }
      
      public long c()
      {
        return paramFile.length();
      }
    };
  }
  
  public static ac a(w paramw, String paramString)
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
    return a(localw, paramString.getBytes((Charset)localObject));
  }
  
  public static ac a(w paramw, final ByteString paramByteString)
  {
    new ac()
    {
      public void a(BufferedSink paramAnonymousBufferedSink)
        throws IOException
      {
        paramAnonymousBufferedSink.write(paramByteString);
      }
      
      public w b()
      {
        return this.a;
      }
      
      public long c()
        throws IOException
      {
        return paramByteString.size();
      }
    };
  }
  
  public static ac a(w paramw, byte[] paramArrayOfByte)
  {
    return a(paramw, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static ac a(w paramw, final byte[] paramArrayOfByte, final int paramInt1, final int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("content == null");
    }
    c.a(paramArrayOfByte.length, paramInt1, paramInt2);
    new ac()
    {
      public void a(BufferedSink paramAnonymousBufferedSink)
        throws IOException
      {
        paramAnonymousBufferedSink.write(paramArrayOfByte, paramInt1, paramInt2);
      }
      
      public w b()
      {
        return this.a;
      }
      
      public long c()
      {
        return paramInt2;
      }
    };
  }
  
  public abstract void a(BufferedSink paramBufferedSink)
    throws IOException;
  
  public abstract w b();
  
  public long c()
    throws IOException
  {
    return -1L;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */