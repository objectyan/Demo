package com.indooratlas.android.sdk._internal;

import java.io.File;
import java.io.IOException;

public abstract interface ih
{
  public static final ih a = new ih()
  {
    public final void a(File paramAnonymousFile)
      throws IOException
    {
      if ((!paramAnonymousFile.delete()) && (paramAnonymousFile.exists())) {
        throw new IOException("failed to delete " + paramAnonymousFile);
      }
    }
  };
  
  public abstract void a(File paramFile)
    throws IOException;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */