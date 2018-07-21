package com.baidu.carlife.logic.voice;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class f
  extends InputStream
{
  private PipedInputStream a = new PipedInputStream();
  private PipedOutputStream b;
  private boolean c = false;
  
  public f()
  {
    try
    {
      this.b = new PipedOutputStream(this.a);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (this.b == null)) {
      return -1;
    }
    try
    {
      this.b.write(paramArrayOfByte, paramInt1, paramInt2);
      return paramInt2;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return -1;
  }
  
  public void a()
  {
    if (this.b != null) {}
    try
    {
      this.b.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public void close()
  {
    this.c = true;
    if (this.a != null) {}
    try
    {
      this.a.close();
      if (this.b == null) {}
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          this.b.close();
          return;
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
        }
        localIOException1 = localIOException1;
        localIOException1.printStackTrace();
      }
    }
  }
  
  public int read()
    throws IOException
  {
    if ((this.c) || (this.a == null)) {
      return -1;
    }
    return this.a.read();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/voice/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */