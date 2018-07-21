package com.baidu.che.codriver.vr.record;

import android.os.SystemClock;
import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.vr.n;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class c
  extends InputStream
{
  private static final String a = "RecordData";
  private PipedInputStream b = new PipedInputStream();
  private PipedOutputStream c;
  private volatile boolean d = false;
  private a e;
  private long f = 0L;
  
  public c()
  {
    try
    {
      this.c = new PipedOutputStream(this.b);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (this.c == null))
    {
      h.e("RecordData", "mPipedOutputStream == null");
      return -1;
    }
    try
    {
      this.c.write(paramArrayOfByte, paramInt1, paramInt2);
      return paramInt2;
    }
    catch (IOException paramArrayOfByte) {}
    return -1;
  }
  
  public void a(a parama)
  {
    this.e = parama;
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void close()
  {
    h.b("RecordData", "----RecordInputStream----close()-----mClosed:" + this.d);
    if (this.e != null) {
      this.e.onClose();
    }
    if (this.d) {}
    for (;;)
    {
      return;
      this.d = true;
      if (this.b != null) {}
      try
      {
        this.b.close();
        if (this.c == null) {
          continue;
        }
        try
        {
          this.c.close();
          return;
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
          return;
        }
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2.printStackTrace();
        }
      }
    }
  }
  
  @Deprecated
  public int read()
    throws IOException
  {
    if ((this.d) || (this.b == null)) {
      return -1;
    }
    return this.b.read();
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if ((this.d) || (this.b == null))
    {
      h.e("RecordData", "----read mClosed || mPipedInputStream == null------");
      return -1;
    }
    if (n.a()) {
      this.f = SystemClock.elapsedRealtime();
    }
    return this.b.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static abstract interface a
  {
    public abstract void onClose();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/record/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */