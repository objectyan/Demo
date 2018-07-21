package com.google.zxing;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;

public final class BinaryBitmap
{
  private final Binarizer binarizer;
  private BitMatrix matrix;
  
  public BinaryBitmap(Binarizer paramBinarizer)
  {
    if (paramBinarizer == null) {
      throw new IllegalArgumentException("Binarizer must be non-null.");
    }
    this.binarizer = paramBinarizer;
  }
  
  public BinaryBitmap crop(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LuminanceSource localLuminanceSource = this.binarizer.getLuminanceSource().crop(paramInt1, paramInt2, paramInt3, paramInt4);
    return new BinaryBitmap(this.binarizer.createBinarizer(localLuminanceSource));
  }
  
  public BitMatrix getBlackMatrix()
    throws NotFoundException
  {
    if (this.matrix == null) {
      this.matrix = this.binarizer.getBlackMatrix();
    }
    return this.matrix;
  }
  
  public BitArray getBlackRow(int paramInt, BitArray paramBitArray)
    throws NotFoundException
  {
    return this.binarizer.getBlackRow(paramInt, paramBitArray);
  }
  
  public int getHeight()
  {
    return this.binarizer.getHeight();
  }
  
  public int getWidth()
  {
    return this.binarizer.getWidth();
  }
  
  public boolean isCropSupported()
  {
    return this.binarizer.getLuminanceSource().isCropSupported();
  }
  
  public boolean isRotateSupported()
  {
    return this.binarizer.getLuminanceSource().isRotateSupported();
  }
  
  public BinaryBitmap rotateCounterClockwise()
  {
    LuminanceSource localLuminanceSource = this.binarizer.getLuminanceSource().rotateCounterClockwise();
    return new BinaryBitmap(this.binarizer.createBinarizer(localLuminanceSource));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/zxing/BinaryBitmap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */