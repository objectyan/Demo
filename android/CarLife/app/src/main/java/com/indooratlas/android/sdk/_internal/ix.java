package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ix
{
  private static final Logger a = Logger.getLogger(ix.class.getName());
  
  public static io a(jc paramjc)
  {
    if (paramjc == null) {
      throw new IllegalArgumentException("sink == null");
    }
    return new iy(paramjc);
  }
  
  public static ip a(jd paramjd)
  {
    if (paramjd == null) {
      throw new IllegalArgumentException("source == null");
    }
    return new iz(paramjd);
  }
  
  public static jc a(final Socket paramSocket)
    throws IOException
  {
    if (paramSocket == null) {
      throw new IllegalArgumentException("socket == null");
    }
    il localil = c(paramSocket);
    paramSocket = paramSocket.getOutputStream();
    if (paramSocket == null) {
      throw new IllegalArgumentException("out == null");
    }
    new il.1(localil, new jc()
    {
      public final je a()
      {
        return this.a;
      }
      
      public final void a_(in paramAnonymousin, long paramAnonymousLong)
        throws IOException
      {
        jf.a(paramAnonymousin.b, 0L, paramAnonymousLong);
        while (paramAnonymousLong > 0L)
        {
          this.a.f();
          ja localja = paramAnonymousin.a;
          int i = (int)Math.min(paramAnonymousLong, localja.c - localja.b);
          paramSocket.write(localja.a, localja.b, i);
          localja.b += i;
          long l = paramAnonymousLong - i;
          paramAnonymousin.b -= i;
          paramAnonymousLong = l;
          if (localja.b == localja.c)
          {
            paramAnonymousin.a = localja.a();
            jb.a(localja);
            paramAnonymousLong = l;
          }
        }
      }
      
      public final void close()
        throws IOException
      {
        paramSocket.close();
      }
      
      public final void flush()
        throws IOException
      {
        paramSocket.flush();
      }
      
      public final String toString()
      {
        return "sink(" + paramSocket + ")";
      }
    });
  }
  
  public static jd b(final Socket paramSocket)
    throws IOException
  {
    if (paramSocket == null) {
      throw new IllegalArgumentException("socket == null");
    }
    il localil = c(paramSocket);
    paramSocket = paramSocket.getInputStream();
    if (paramSocket == null) {
      throw new IllegalArgumentException("in == null");
    }
    new il.2(localil, new jd()
    {
      public final long a(in paramAnonymousin, long paramAnonymousLong)
        throws IOException
      {
        if (paramAnonymousLong < 0L) {
          throw new IllegalArgumentException("byteCount < 0: " + paramAnonymousLong);
        }
        if (paramAnonymousLong == 0L) {
          return 0L;
        }
        this.a.f();
        ja localja = paramAnonymousin.f(1);
        int i = (int)Math.min(paramAnonymousLong, 2048 - localja.c);
        i = paramSocket.read(localja.a, localja.c, i);
        if (i == -1) {
          return -1L;
        }
        localja.c += i;
        paramAnonymousin.b += i;
        return i;
      }
      
      public final je a()
      {
        return this.a;
      }
      
      public final void close()
        throws IOException
      {
        paramSocket.close();
      }
      
      public final String toString()
      {
        return "source(" + paramSocket + ")";
      }
    });
  }
  
  private static il c(Socket paramSocket)
  {
    new il()
    {
      protected final IOException a(IOException paramAnonymousIOException)
      {
        SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
        if (paramAnonymousIOException != null) {
          localSocketTimeoutException.initCause(paramAnonymousIOException);
        }
        return localSocketTimeoutException;
      }
      
      protected final void a()
      {
        try
        {
          this.a.close();
          return;
        }
        catch (Exception localException)
        {
          ix.a().log(Level.WARNING, "Failed to close timed out socket " + this.a, localException);
          return;
        }
        catch (AssertionError localAssertionError)
        {
          if ((localAssertionError.getCause() != null) && (localAssertionError.getMessage() != null) && (localAssertionError.getMessage().contains("getsockname failed")))
          {
            ix.a().log(Level.WARNING, "Failed to close timed out socket " + this.a, localAssertionError);
            return;
          }
          throw localAssertionError;
        }
      }
    };
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */