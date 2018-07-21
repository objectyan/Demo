package com.android.internal.http.multipart;

import java.io.IOException;
import java.io.InputStream;

public abstract interface PartSource
{
  public abstract InputStream createInputStream()
    throws IOException;
  
  public abstract String getFileName();
  
  public abstract long getLength();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/android/internal/http/multipart/PartSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */