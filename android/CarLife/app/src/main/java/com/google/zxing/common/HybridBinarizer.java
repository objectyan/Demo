package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;

public final class HybridBinarizer
  extends GlobalHistogramBinarizer
{
  private static final int BLOCK_SIZE = 8;
  private static final int BLOCK_SIZE_MASK = 7;
  private static final int BLOCK_SIZE_POWER = 3;
  private static final int MINIMUM_DIMENSION = 40;
  private BitMatrix matrix;
  
  public HybridBinarizer(LuminanceSource paramLuminanceSource)
  {
    super(paramLuminanceSource);
  }
  
  private static int[][] calculateBlackPoints(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { paramInt2, paramInt1 });
    int j = 0;
    while (j < paramInt2)
    {
      int i = j << 3;
      int k = i;
      if (i + 8 >= paramInt4) {
        k = paramInt4 - 8;
      }
      int m = 0;
      while (m < paramInt1)
      {
        int n = m << 3;
        i = n;
        if (n + 8 >= paramInt3) {
          i = paramInt3 - 8;
        }
        int i5 = 0;
        int i1 = 255;
        int i3 = 0;
        int i2 = 0;
        n = k * paramInt3 + i;
        i = i2;
        while (i < 8)
        {
          i2 = 0;
          int i4 = i1;
          i1 = i3;
          while (i2 < 8)
          {
            i3 = paramArrayOfByte[(n + i2)] & 0xFF;
            int i6 = i5 + i3;
            i5 = i4;
            if (i3 < i4) {
              i5 = i3;
            }
            i4 = i1;
            if (i3 > i1) {
              i4 = i3;
            }
            i2 += 1;
            i1 = i4;
            i4 = i5;
            i5 = i6;
          }
          i += 1;
          n += paramInt3;
          i3 = i1;
          i1 = i4;
        }
        i = i5 >> 6;
        if (i3 - i1 <= 24)
        {
          n = i1 >> 1;
          i = n;
          if (j > 0)
          {
            i = n;
            if (m > 0)
            {
              i2 = arrayOfInt[(j - 1)][m] + arrayOfInt[j][(m - 1)] * 2 + arrayOfInt[(j - 1)][(m - 1)] >> 2;
              i = n;
              if (i1 < i2) {
                i = i2;
              }
            }
          }
        }
        arrayOfInt[j][m] = i;
        m += 1;
      }
      j += 1;
    }
    return arrayOfInt;
  }
  
  private static void calculateThresholdForBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[][] paramArrayOfInt, BitMatrix paramBitMatrix)
  {
    int i = 0;
    while (i < paramInt2)
    {
      int j = i << 3;
      int m = j;
      if (j + 8 >= paramInt4) {
        m = paramInt4 - 8;
      }
      j = 0;
      while (j < paramInt1)
      {
        int k = j << 3;
        int n = k;
        if (k + 8 >= paramInt3) {
          n = paramInt3 - 8;
        }
        int i1;
        if (j > 1)
        {
          k = j;
          if (k >= paramInt1 - 2) {
            break label190;
          }
          i1 = k;
          label92:
          if (i <= 1) {
            break label198;
          }
          k = i;
          label102:
          if (k >= paramInt2 - 2) {
            break label204;
          }
        }
        int i3;
        for (;;)
        {
          i3 = 0;
          int i2 = -2;
          while (i2 <= 2)
          {
            int[] arrayOfInt = paramArrayOfInt[(k + i2)];
            i3 += arrayOfInt[(i1 - 2)] + arrayOfInt[(i1 - 1)] + arrayOfInt[i1] + arrayOfInt[(i1 + 1)] + arrayOfInt[(i1 + 2)];
            i2 += 1;
          }
          k = 2;
          break;
          label190:
          i1 = paramInt1 - 3;
          break label92;
          label198:
          k = 2;
          break label102;
          label204:
          k = paramInt2 - 3;
        }
        threshold8x8Block(paramArrayOfByte, n, m, i3 / 25, paramInt3, paramBitMatrix);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void threshold8x8Block(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, BitMatrix paramBitMatrix)
  {
    int j = 0;
    int i = paramInt2 * paramInt4 + paramInt1;
    while (j < 8)
    {
      int k = 0;
      while (k < 8)
      {
        if ((paramArrayOfByte[(i + k)] & 0xFF) <= paramInt3) {
          paramBitMatrix.set(paramInt1 + k, paramInt2 + j);
        }
        k += 1;
      }
      j += 1;
      i += paramInt4;
    }
  }
  
  public Binarizer createBinarizer(LuminanceSource paramLuminanceSource)
  {
    return new HybridBinarizer(paramLuminanceSource);
  }
  
  public BitMatrix getBlackMatrix()
    throws NotFoundException
  {
    if (this.matrix != null) {
      return this.matrix;
    }
    Object localObject = getLuminanceSource();
    BitMatrix localBitMatrix;
    if ((((LuminanceSource)localObject).getWidth() >= 40) && (((LuminanceSource)localObject).getHeight() >= 40))
    {
      byte[] arrayOfByte = ((LuminanceSource)localObject).getMatrix();
      int m = ((LuminanceSource)localObject).getWidth();
      int n = ((LuminanceSource)localObject).getHeight();
      int j = m >> 3;
      int i = j;
      if ((m & 0x7) != 0) {
        i = j + 1;
      }
      int k = n >> 3;
      j = k;
      if ((n & 0x7) != 0) {
        j = k + 1;
      }
      localObject = calculateBlackPoints(arrayOfByte, i, j, m, n);
      localBitMatrix = new BitMatrix(m, n);
      calculateThresholdForBlock(arrayOfByte, i, j, m, n, (int[][])localObject, localBitMatrix);
    }
    for (this.matrix = localBitMatrix;; this.matrix = super.getBlackMatrix()) {
      return this.matrix;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/zxing/common/HybridBinarizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */