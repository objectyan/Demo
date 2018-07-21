package com.facebook.common.d;

import java.io.File;

public class a
{
  public static void a(File paramFile, b paramb)
  {
    paramb.a(paramFile);
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      if (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile.isDirectory()) {
          a(localFile, paramb);
        }
        for (;;)
        {
          i += 1;
          break;
          paramb.b(localFile);
        }
      }
    }
    paramb.c(paramFile);
  }
  
  public static boolean a(File paramFile)
  {
    paramFile = paramFile.listFiles();
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramFile != null)
    {
      int j = paramFile.length;
      int i = 0;
      for (;;)
      {
        bool2 = bool1;
        if (i >= j) {
          break;
        }
        bool1 &= b(paramFile[i]);
        i += 1;
      }
    }
    return bool2;
  }
  
  public static boolean b(File paramFile)
  {
    if (paramFile.isDirectory()) {
      a(paramFile);
    }
    return paramFile.delete();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */