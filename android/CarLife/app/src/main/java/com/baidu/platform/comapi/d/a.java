package com.baidu.platform.comapi.d;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class a
{
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  public static void a(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    if ((paramInputStream == null) || (paramOutputStream == null) || (paramArrayOfByte == null)) {
      throw new IOException("copyStream : outputStream or inputStream is null");
    }
    Object localObject1 = paramInputStream;
    Object localObject2 = paramInputStream;
    Object localObject3 = paramOutputStream;
    try
    {
      if (!(paramInputStream instanceof BufferedInputStream))
      {
        localObject2 = paramInputStream;
        localObject3 = paramOutputStream;
        localObject1 = new BufferedInputStream(paramInputStream);
      }
      paramInputStream = paramOutputStream;
      localObject2 = localObject1;
      localObject3 = paramOutputStream;
      if (!(paramOutputStream instanceof BufferedOutputStream))
      {
        localObject2 = localObject1;
        localObject3 = paramOutputStream;
        paramInputStream = new BufferedOutputStream(paramOutputStream);
      }
      for (;;)
      {
        localObject2 = localObject1;
        localObject3 = paramInputStream;
        int i = ((InputStream)localObject1).read(paramArrayOfByte);
        if (i == -1) {
          break;
        }
        localObject2 = localObject1;
        localObject3 = paramInputStream;
        paramInputStream.write(paramArrayOfByte, 0, i);
      }
      localObject2 = localObject1;
    }
    finally
    {
      a((Closeable)localObject2);
      a((Closeable)localObject3);
    }
    localObject3 = paramInputStream;
    paramInputStream.flush();
    a((Closeable)localObject1);
    a(paramInputStream);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */