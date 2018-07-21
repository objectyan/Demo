package com.baidu.che.codriver.i;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class e
{
  private static final String a = "WriteFileUtils";
  private static e b;
  private DataOutputStream c;
  
  public static e a()
  {
    if (b == null) {
      b = new e();
    }
    return b;
  }
  
  public void a(String paramString)
  {
    paramString = new File(paramString + ".pcm");
    File localFile = paramString.getParentFile();
    if ((localFile != null) && (!localFile.exists())) {
      localFile.mkdirs();
    }
    try
    {
      if (!paramString.exists()) {
        paramString.createNewFile();
      }
      paramString.setWritable(true);
      this.c = new DataOutputStream(new FileOutputStream(paramString, true));
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {}
    for (;;)
    {
      return;
      try
      {
        if (this.c != null)
        {
          this.c.write(paramArrayOfByte, 0, paramArrayOfByte.length);
          return;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public void b()
  {
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
        localIOException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/i/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */