package com.google.zxing;

public final class NotFoundException
  extends ReaderException
{
  private static final NotFoundException instance = new NotFoundException();
  
  public static NotFoundException getNotFoundInstance()
  {
    return instance;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/zxing/NotFoundException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */