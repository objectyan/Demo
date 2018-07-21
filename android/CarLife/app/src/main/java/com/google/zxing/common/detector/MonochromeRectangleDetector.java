package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class MonochromeRectangleDetector
{
  private static final int MAX_MODULES = 32;
  private final BitMatrix image;
  
  public MonochromeRectangleDetector(BitMatrix paramBitMatrix)
  {
    this.image = paramBitMatrix;
  }
  
  private int[] blackWhiteRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int k = paramInt3 + paramInt4 >> 1;
    int j = k;
    label104:
    do
    {
      i = j;
      j = i;
      if (i < paramInt3) {
        break label127;
      }
      if (paramBoolean)
      {
        if (!this.image.get(i, paramInt1)) {}
      }
      else {
        while (this.image.get(paramInt1, i))
        {
          j = i - 1;
          break;
        }
      }
      j = i;
      do
      {
        m = j - 1;
        if (m < paramInt3) {
          break;
        }
        if (!paramBoolean) {
          break label174;
        }
        j = m;
      } while (!this.image.get(m, paramInt1));
      if (m < paramInt3) {
        break;
      }
      j = m;
    } while (i - m <= paramInt2);
    j = i;
    label127:
    int m = j + 1;
    int i = k;
    label137:
    paramInt3 = i;
    i = paramInt3;
    if (paramInt3 < paramInt4)
    {
      if (paramBoolean)
      {
        if (!this.image.get(paramInt3, paramInt1)) {}
      }
      else {
        label174:
        while (this.image.get(paramInt1, paramInt3))
        {
          i = paramInt3 + 1;
          break label137;
          j = m;
          if (!this.image.get(paramInt1, m)) {
            break;
          }
          break label104;
        }
      }
      i = paramInt3;
      label209:
      do
      {
        j = i + 1;
        if (j >= paramInt4) {
          break;
        }
        if (!paramBoolean) {
          break label290;
        }
        i = j;
      } while (!this.image.get(j, paramInt1));
    }
    for (;;)
    {
      if (j < paramInt4)
      {
        i = j;
        if (j - paramInt3 <= paramInt2) {
          break;
        }
      }
      i = paramInt3;
      paramInt1 = i - 1;
      if (paramInt1 <= m) {
        break label310;
      }
      return new int[] { m, paramInt1 };
      label290:
      i = j;
      if (!this.image.get(paramInt1, j)) {
        break label209;
      }
    }
    label310:
    return null;
  }
  
  private ResultPoint findCornerFromCenter(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
    throws NotFoundException
  {
    Object localObject = null;
    int j = paramInt5;
    int i = paramInt1;
    while ((j < paramInt8) && (j >= paramInt7) && (i < paramInt4) && (i >= paramInt3))
    {
      int[] arrayOfInt;
      if (paramInt2 == 0) {
        arrayOfInt = blackWhiteRange(j, paramInt9, paramInt3, paramInt4, true);
      }
      while (arrayOfInt == null) {
        if (localObject == null)
        {
          throw NotFoundException.getNotFoundInstance();
          arrayOfInt = blackWhiteRange(i, paramInt9, paramInt7, paramInt8, false);
        }
        else
        {
          float f1;
          if (paramInt2 == 0)
          {
            paramInt2 = j - paramInt6;
            if (localObject[0] < paramInt1)
            {
              if (localObject[1] > paramInt1)
              {
                if (paramInt6 > 0) {}
                for (f1 = localObject[0];; f1 = localObject[1]) {
                  return new ResultPoint(f1, paramInt2);
                }
              }
              return new ResultPoint(localObject[0], paramInt2);
            }
            return new ResultPoint(localObject[1], paramInt2);
          }
          paramInt1 = i - paramInt2;
          if (localObject[0] < paramInt5)
          {
            if (localObject[1] > paramInt5)
            {
              float f2 = paramInt1;
              if (paramInt2 < 0) {}
              for (f1 = localObject[0];; f1 = localObject[1]) {
                return new ResultPoint(f2, f1);
              }
            }
            return new ResultPoint(paramInt1, localObject[0]);
          }
          return new ResultPoint(paramInt1, localObject[1]);
        }
      }
      j += paramInt6;
      i += paramInt2;
      localObject = arrayOfInt;
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  public ResultPoint[] detect()
    throws NotFoundException
  {
    int i1 = this.image.getHeight();
    int i2 = this.image.getWidth();
    int i = i1 >> 1;
    int j = i2 >> 1;
    int k = Math.max(1, i1 / 256);
    int i3 = Math.max(1, i2 / 256);
    int m = (int)findCornerFromCenter(j, 0, 0, i2, i, -k, 0, i1, j >> 1).getY() - 1;
    ResultPoint localResultPoint1 = findCornerFromCenter(j, -i3, 0, i2, i, 0, m, i1, i >> 1);
    int n = (int)localResultPoint1.getX() - 1;
    ResultPoint localResultPoint2 = findCornerFromCenter(j, i3, n, i2, i, 0, m, i1, i >> 1);
    i2 = (int)localResultPoint2.getX() + 1;
    ResultPoint localResultPoint3 = findCornerFromCenter(j, 0, n, i2, i, k, m, i1, j >> 1);
    i1 = (int)localResultPoint3.getY();
    return new ResultPoint[] { findCornerFromCenter(j, 0, n, i2, i, -k, m, i1 + 1, j >> 2), localResultPoint1, localResultPoint2, localResultPoint3 };
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/zxing/common/detector/MonochromeRectangleDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */