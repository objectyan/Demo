package com.facebook.a;

import com.facebook.common.internal.e;
import com.facebook.common.internal.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class c
  implements a
{
  private final File a;
  
  private c(File paramFile)
  {
    this.a = ((File)k.a(paramFile));
  }
  
  public static c a(File paramFile)
  {
    if (paramFile != null) {
      return new c(paramFile);
    }
    return null;
  }
  
  public InputStream a()
    throws IOException
  {
    return new FileInputStream(this.a);
  }
  
  public byte[] b()
    throws IOException
  {
    return e.a(this.a);
  }
  
  public long c()
  {
    return this.a.length();
  }
  
  public File d()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof c))) {
      return false;
    }
    paramObject = (c)paramObject;
    return this.a.equals(((c)paramObject).a);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */