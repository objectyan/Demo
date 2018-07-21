package com.facebook.common.d;

import com.facebook.common.internal.k;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class c
{
  public static void a(File paramFile)
    throws c.a
  {
    if (paramFile.exists()) {
      if (!paramFile.isDirectory()) {}
    }
    while ((paramFile.mkdirs()) || (paramFile.isDirectory()))
    {
      return;
      if (!paramFile.delete()) {
        throw new a(paramFile.getAbsolutePath(), new b(paramFile.getAbsolutePath()));
      }
    }
    throw new a(paramFile.getAbsolutePath());
  }
  
  public static void a(File paramFile1, File paramFile2)
    throws c.d
  {
    k.a(paramFile1);
    k.a(paramFile2);
    paramFile2.delete();
    if (paramFile1.renameTo(paramFile2)) {
      return;
    }
    Object localObject = null;
    if (paramFile2.exists()) {
      localObject = new b(paramFile2.getAbsolutePath());
    }
    for (;;)
    {
      throw new d("Unknown error renaming " + paramFile1.getAbsolutePath() + " to " + paramFile2.getAbsolutePath(), (Throwable)localObject);
      if (!paramFile1.getParentFile().exists()) {
        localObject = new c(paramFile1.getAbsolutePath());
      } else if (!paramFile1.exists()) {
        localObject = new FileNotFoundException(paramFile1.getAbsolutePath());
      }
    }
  }
  
  public static class a
    extends IOException
  {
    public a(String paramString)
    {
      super();
    }
    
    public a(String paramString, Throwable paramThrowable)
    {
      super();
      initCause(paramThrowable);
    }
  }
  
  public static class b
    extends IOException
  {
    public b(String paramString)
    {
      super();
    }
  }
  
  public static class c
    extends FileNotFoundException
  {
    public c(String paramString)
    {
      super();
    }
  }
  
  public static class d
    extends IOException
  {
    public d(String paramString)
    {
      super();
    }
    
    public d(String paramString, Throwable paramThrowable)
    {
      super();
      initCause(paramThrowable);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */