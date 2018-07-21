package com.facebook.common.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

public class e
{
  public static byte[] a(File paramFile)
    throws IOException
  {
    Object localObject3 = null;
    try
    {
      paramFile = new FileInputStream(paramFile);
      byte[] arrayOfByte;
      if (paramFile == null) {
        break label44;
      }
    }
    finally
    {
      try
      {
        arrayOfByte = a(paramFile, paramFile.getChannel().size());
        if (paramFile != null) {
          paramFile.close();
        }
        return arrayOfByte;
      }
      finally {}
      localObject1 = finally;
      paramFile = (File)localObject3;
    }
    paramFile.close();
    label44:
    throw ((Throwable)localObject1);
  }
  
  static byte[] a(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    if (paramLong > 2147483647L) {
      throw new OutOfMemoryError("file is too large to fit in a byte array: " + paramLong + " bytes");
    }
    if (paramLong == 0L) {
      return b.a(paramInputStream);
    }
    return b.a(paramInputStream, (int)paramLong);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/internal/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */