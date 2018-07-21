package com.baidu.location.indoor.b;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class d
{
  private byte[] a;
  private int b;
  
  public d()
  {
    this(512);
  }
  
  private d(int paramInt)
  {
    this.b = paramInt;
    this.a = new byte[this.b];
  }
  
  public void a(String paramString1, String paramString2)
  {
    for (;;)
    {
      String str;
      try
      {
        paramString1 = new ZipInputStream(new BufferedInputStream(new FileInputStream(paramString1)));
        localObject = paramString1.getNextEntry();
        if (localObject == null) {
          break;
        }
        str = ((ZipEntry)localObject).getName();
        if ((str != null) && (str.contains("../"))) {
          continue;
        }
        str = paramString2 + ((ZipEntry)localObject).getName();
        File localFile = new File(str);
        if (((ZipEntry)localObject).isDirectory())
        {
          localFile.mkdirs();
          paramString1.closeEntry();
          continue;
        }
        localObject = localFile.getParentFile();
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      if ((localObject != null) && (!((File)localObject).exists())) {
        ((File)localObject).mkdirs();
      }
      Object localObject = new FileOutputStream(str);
      for (;;)
      {
        int i = paramString1.read(this.a);
        if (i <= 0) {
          break;
        }
        ((FileOutputStream)localObject).write(this.a, 0, i);
      }
      ((FileOutputStream)localObject).close();
    }
    paramString1.close();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/indoor/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */