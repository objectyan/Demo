package com.baidu.mapframework.commonlib.asynchttp;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Base64OutputStream
  extends FilterOutputStream
{
  private static byte[] a = new byte[0];
  private final Base64.Coder b;
  private final int c;
  private byte[] d = null;
  private int e = 0;
  
  public Base64OutputStream(OutputStream paramOutputStream, int paramInt)
  {
    this(paramOutputStream, paramInt, true);
  }
  
  public Base64OutputStream(OutputStream paramOutputStream, int paramInt, boolean paramBoolean)
  {
    super(paramOutputStream);
    this.c = paramInt;
    if (paramBoolean)
    {
      this.b = new Base64.Encoder(paramInt, null);
      return;
    }
    this.b = new Base64.Decoder(paramInt, null);
  }
  
  private void a()
    throws IOException
  {
    if (this.e > 0)
    {
      a(this.d, 0, this.e, false);
      this.e = 0;
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    this.b.output = a(this.b.output, this.b.maxOutputSize(paramInt2));
    if (!this.b.process(paramArrayOfByte, paramInt1, paramInt2, paramBoolean)) {
      throw new Base64DataException("bad base-64");
    }
    this.out.write(this.b.output, 0, this.b.op);
  }
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte;
    if (paramArrayOfByte != null)
    {
      arrayOfByte = paramArrayOfByte;
      if (paramArrayOfByte.length >= paramInt) {}
    }
    else
    {
      arrayOfByte = new byte[paramInt];
    }
    return arrayOfByte;
  }
  
  public void close()
    throws IOException
  {
    Object localObject1 = null;
    try
    {
      a();
      a(a, 0, 0, true);
      try
      {
        if ((this.c & 0x10) != 0) {
          break label45;
        }
        this.out.close();
        localObject2 = localObject1;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          Object localObject2 = localIOException1;
          if (localIOException1 != null) {
            localObject2 = localIOException2;
          }
        }
      }
      if (localObject2 != null) {
        throw ((Throwable)localObject2);
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        continue;
        label45:
        this.out.flush();
        localObject2 = localIOException1;
      }
    }
  }
  
  public void write(int paramInt)
    throws IOException
  {
    if (this.d == null) {
      this.d = new byte['Ѐ'];
    }
    if (this.e >= this.d.length)
    {
      a(this.d, 0, this.e, false);
      this.e = 0;
    }
    byte[] arrayOfByte = this.d;
    int i = this.e;
    this.e = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 <= 0) {
      return;
    }
    a();
    a(paramArrayOfByte, paramInt1, paramInt2, false);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/asynchttp/Base64OutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */