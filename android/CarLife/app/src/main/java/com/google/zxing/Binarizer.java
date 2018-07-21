package com.google.zxing;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;

public abstract class Binarizer
{
  private final LuminanceSource source;
  
  protected Binarizer(LuminanceSource paramLuminanceSource)
  {
    this.source = paramLuminanceSource;
  }
  
  public abstract Binarizer createBinarizer(LuminanceSource paramLuminanceSource);
  
  public abstract BitMatrix getBlackMatrix()
    throws NotFoundException;
  
  public abstract BitArray getBlackRow(int paramInt, BitArray paramBitArray)
    throws NotFoundException;
  
  public int getHeight()
  {
    return this.source.getHeight();
  }
  
  public LuminanceSource getLuminanceSource()
  {
    return this.source;
  }
  
  public int getWidth()
  {
    return this.source.getWidth();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/zxing/Binarizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */