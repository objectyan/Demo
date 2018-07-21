package com.baidu.carlife.platform.communication;

import android.net.LocalSocket;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.carlife.core.i;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

public class b
{
  private static final String a = b.class.getSimpleName();
  private String b;
  private LocalSocket c;
  private b d;
  private d e;
  private a f;
  private c g;
  
  public b(LocalSocket paramLocalSocket, String paramString)
  {
    this.c = paramLocalSocket;
    this.b = paramString;
    this.d = new b();
    this.e = new d();
    this.f = new a();
    this.d.start();
    this.f.start();
  }
  
  private CLPackage c(CLPackage paramCLPackage)
  {
    if (paramCLPackage == null) {}
    do
    {
      do
      {
        return paramCLPackage;
        if (1 != paramCLPackage.service) {
          break;
        }
      } while ((this.e == null) || (paramCLPackage.type != 1));
      CLPackage localCLPackage = new CLPackage();
      localCLPackage.service = 1;
      localCLPackage.type = 2;
      this.e.a(localCLPackage);
      return paramCLPackage;
    } while (this.g == null);
    return this.g.a(paramCLPackage);
  }
  
  public void a()
  {
    this.g = null;
    this.e = null;
    if (this.d != null)
    {
      this.d.a();
      this.d = null;
    }
    if (this.f != null)
    {
      this.f.b();
      this.f = null;
    }
    if (this.c != null) {}
    try
    {
      this.c.close();
      this.c = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        i.a(a, localIOException);
      }
    }
  }
  
  public void a(c paramc)
  {
    this.g = paramc;
  }
  
  public boolean a(CLPackage paramCLPackage)
  {
    if (this.e != null) {
      return this.e.b(paramCLPackage);
    }
    return false;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(CLPackage paramCLPackage)
  {
    if (this.e != null) {
      this.e.a(paramCLPackage);
    }
  }
  
  private class a
    extends Thread
  {
    private static final int b = 10000;
    private AtomicLong c = new AtomicLong(System.currentTimeMillis());
    private boolean d = false;
    
    public a()
    {
      setName("Carlife HeartBeatThread");
    }
    
    private void c()
    {
      if (b.d(b.this) != null)
      {
        CLPackage localCLPackage = new CLPackage();
        localCLPackage.service = 1;
        localCLPackage.type = 1;
        b.d(b.this).a(localCLPackage);
      }
    }
    
    public void a()
    {
      this.c.set(System.currentTimeMillis());
    }
    
    public void b()
    {
      this.d = true;
      interrupt();
    }
    
    public void run()
    {
      long l;
      if ((!this.d) && (!isInterrupted()))
      {
        l = System.currentTimeMillis() - this.c.get();
        if (l <= 30000L) {
          break label67;
        }
        if (b.b(b.this) != null) {
          b.b(b.this).a(this, new TimeoutException("remote client dead!"));
        }
      }
      label67:
      do
      {
        return;
        if (l > 10000L) {
          c();
        }
        try
        {
          sleep(10000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          i.a(b.c(), localInterruptedException);
        }
      } while (b.b(b.this) == null);
      b.b(b.this).a(this, localInterruptedException);
    }
  }
  
  private class b
    extends Thread
  {
    private InputStream b;
    private boolean c = false;
    private byte[] d = new byte[16];
    private CLPackage e = CLPackage.getLargestPackage();
    
    public b()
    {
      setName("Carlife ReadThread");
    }
    
    public void a()
    {
      this.c = true;
      interrupt();
    }
    
    public void run()
    {
      int i;
      try
      {
        this.b = b.a(b.this).getInputStream();
        try
        {
          if ((interrupted()) || (this.c)) {
            break label247;
          }
          i = this.b.read(this.d, 0, this.d.length);
          if (i == -1) {
            break label247;
          }
          if (i == this.d.length) {
            break label141;
          }
          throw new IOException("wrong header length");
        }
        catch (IOException localIOException)
        {
          i.a(b.c(), localIOException);
          if (b.b(b.this) != null) {
            b.b(b.this).a(this, localIOException);
          }
        }
        label104:
        return;
      }
      catch (Exception localException)
      {
        do
        {
          i.a(b.c(), localException);
        } while (b.b(b.this) == null);
        b.b(b.this).a(this, localException);
        return;
      }
      label141:
      this.e.setHeader(this.d);
      int j;
      if (this.e.length > 0)
      {
        j = this.e.length;
        i = 0;
      }
      for (;;)
      {
        int k;
        if (j > 0)
        {
          k = this.b.read(this.e.data, i, j);
          if (k == -1) {
            throw new IOException("wrong data length");
          }
        }
        else
        {
          if (b.c(b.this) != null) {
            b.c(b.this).a();
          }
          this.e = b.a(b.this, this.e);
          break;
          label247:
          if (b.b(b.this) == null) {
            break label104;
          }
          b.b(b.this).a(this, null);
          return;
        }
        j -= k;
        i += k;
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract CLPackage a(CLPackage paramCLPackage);
    
    public abstract void a(Thread paramThread, Exception paramException);
  }
  
  private class d
  {
    private OutputStream b;
    private Handler c;
    
    public d()
    {
      HandlerThread localHandlerThread = new HandlerThread("WriteHelperAsync");
      localHandlerThread.start();
      this.c = new Handler(localHandlerThread.getLooper());
      try
      {
        this.b = b.a(b.this).getOutputStream();
        return;
      }
      catch (Exception this$1)
      {
        i.b(b.c(), b.this);
        this.b = null;
      }
    }
    
    public void a(final CLPackage paramCLPackage)
    {
      this.c.post(new Runnable()
      {
        public void run()
        {
          b.d.this.b(paramCLPackage);
        }
      });
    }
    
    public boolean b(CLPackage paramCLPackage)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramCLPackage != null) {}
      for (;;)
      {
        try
        {
          OutputStream localOutputStream = this.b;
          bool1 = bool2;
          if (localOutputStream != null) {
            try
            {
              this.b.write(paramCLPackage.getHeader());
              if (paramCLPackage.length <= 0) {
                continue;
              }
              if ((paramCLPackage.data != null) && (paramCLPackage.data.length >= paramCLPackage.length)) {
                continue;
              }
              throw new IOException("package with null data & not zero length");
            }
            catch (IOException paramCLPackage)
            {
              i.a(b.c(), paramCLPackage);
              bool1 = bool2;
            }
          } else {
            return bool1;
          }
        }
        finally {}
        this.b.write(paramCLPackage.data, 0, paramCLPackage.length);
        bool1 = true;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/platform/communication/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */