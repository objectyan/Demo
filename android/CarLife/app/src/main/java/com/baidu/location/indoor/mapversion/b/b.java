package com.baidu.location.indoor.mapversion.b;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class b
{
  public static boolean a(File paramFile, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    for (;;)
    {
      Object localObject;
      BufferedOutputStream localBufferedOutputStream;
      try
      {
        paramFile = new ZipFile(paramFile);
        Enumeration localEnumeration = paramFile.entries();
        if (!localEnumeration.hasMoreElements()) {
          break;
        }
        localObject = (ZipEntry)localEnumeration.nextElement();
        if (((ZipEntry)localObject).isDirectory()) {
          continue;
        }
        localObject = new BufferedInputStream(paramFile.getInputStream((ZipEntry)localObject));
        localBufferedOutputStream = new BufferedOutputStream(paramByteArrayOutputStream, 2048);
        byte[] arrayOfByte = new byte['ࠀ'];
        int i = ((BufferedInputStream)localObject).read(arrayOfByte, 0, 2048);
        if (i != -1)
        {
          localBufferedOutputStream.write(arrayOfByte, 0, i);
          continue;
        }
        localBufferedOutputStream.flush();
      }
      catch (Exception paramFile)
      {
        paramFile.printStackTrace();
        return false;
      }
      localBufferedOutputStream.close();
      ((BufferedInputStream)localObject).close();
    }
    paramFile.close();
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/indoor/mapversion/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */