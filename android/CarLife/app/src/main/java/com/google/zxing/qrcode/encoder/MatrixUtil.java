package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

final class MatrixUtil
{
  private static final int[][] HORIZONTAL_SEPARATION_PATTERN;
  private static final int[][] POSITION_ADJUSTMENT_PATTERN;
  private static final int[][] POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE;
  private static final int[][] POSITION_DETECTION_PATTERN;
  private static final int[][] TYPE_INFO_COORDINATES;
  private static final int TYPE_INFO_MASK_PATTERN = 21522;
  private static final int TYPE_INFO_POLY = 1335;
  private static final int VERSION_INFO_POLY = 7973;
  private static final int[][] VERTICAL_SEPARATION_PATTERN;
  
  static
  {
    int[] arrayOfInt1 = { 1, 1, 1, 1, 1, 1, 1 };
    int[] arrayOfInt2 = { 1, 0, 1, 1, 1, 0, 1 };
    int[] arrayOfInt3 = { 1, 0, 1, 1, 1, 0, 1 };
    int[] arrayOfInt4 = { 1, 0, 1, 1, 1, 0, 1 };
    int[] arrayOfInt5 = { 1, 0, 0, 0, 0, 0, 1 };
    int[] arrayOfInt6 = { 1, 1, 1, 1, 1, 1, 1 };
    POSITION_DETECTION_PATTERN = new int[][] { arrayOfInt1, { 1, 0, 0, 0, 0, 0, 1 }, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6 };
    HORIZONTAL_SEPARATION_PATTERN = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0 } };
    arrayOfInt1 = new int[] { 0 };
    arrayOfInt2 = new int[] { 0 };
    arrayOfInt3 = new int[] { 0 };
    arrayOfInt4 = new int[] { 0 };
    arrayOfInt5 = new int[] { 0 };
    VERTICAL_SEPARATION_PATTERN = new int[][] { { 0 }, arrayOfInt1, arrayOfInt2, arrayOfInt3, { 0 }, arrayOfInt4, arrayOfInt5 };
    arrayOfInt1 = new int[] { 1, 0, 0, 0, 1 };
    POSITION_ADJUSTMENT_PATTERN = new int[][] { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, arrayOfInt1, { 1, 1, 1, 1, 1 } };
    arrayOfInt1 = new int[] { -1, -1, -1, -1, -1, -1, -1 };
    arrayOfInt2 = new int[] { 6, 22, 38, -1, -1, -1, -1 };
    arrayOfInt3 = new int[] { 6, 26, 46, -1, -1, -1, -1 };
    arrayOfInt4 = new int[] { 6, 32, 58, -1, -1, -1, -1 };
    arrayOfInt5 = new int[] { 6, 26, 50, 74, -1, -1, -1 };
    arrayOfInt6 = new int[] { 6, 30, 56, 82, -1, -1, -1 };
    int[] arrayOfInt7 = { 6, 30, 58, 86, -1, -1, -1 };
    int[] arrayOfInt8 = { 6, 34, 62, 90, -1, -1, -1 };
    int[] arrayOfInt9 = { 6, 26, 50, 74, 98, -1, -1 };
    int[] arrayOfInt10 = { 6, 30, 54, 78, 102, -1, -1 };
    int[] arrayOfInt11 = { 6, 28, 54, 80, 106, -1, -1 };
    int[] arrayOfInt12 = { 6, 32, 58, 84, 110, -1, -1 };
    int[] arrayOfInt13 = { 6, 34, 62, 90, 118, -1, -1 };
    int[] arrayOfInt14 = { 6, 30, 54, 78, 102, 126, -1 };
    int[] arrayOfInt15 = { 6, 26, 52, 78, 104, 130, -1 };
    int[] arrayOfInt16 = { 6, 34, 60, 86, 112, 138, -1 };
    int[] arrayOfInt17 = { 6, 30, 58, 86, 114, 142, -1 };
    int[] arrayOfInt18 = { 6, 26, 54, 82, 110, 138, 166 };
    int[] arrayOfInt19 = { 6, 30, 58, 86, 114, 142, 170 };
    POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = new int[][] { arrayOfInt1, { 6, 18, -1, -1, -1, -1, -1 }, { 6, 22, -1, -1, -1, -1, -1 }, { 6, 26, -1, -1, -1, -1, -1 }, { 6, 30, -1, -1, -1, -1, -1 }, { 6, 34, -1, -1, -1, -1, -1 }, arrayOfInt2, { 6, 24, 42, -1, -1, -1, -1 }, arrayOfInt3, { 6, 28, 50, -1, -1, -1, -1 }, { 6, 30, 54, -1, -1, -1, -1 }, arrayOfInt4, { 6, 34, 62, -1, -1, -1, -1 }, { 6, 26, 46, 66, -1, -1, -1 }, { 6, 26, 48, 70, -1, -1, -1 }, arrayOfInt5, { 6, 30, 54, 78, -1, -1, -1 }, arrayOfInt6, arrayOfInt7, arrayOfInt8, { 6, 28, 50, 72, 94, -1, -1 }, arrayOfInt9, arrayOfInt10, arrayOfInt11, arrayOfInt12, { 6, 30, 58, 86, 114, -1, -1 }, arrayOfInt13, { 6, 26, 50, 74, 98, 122, -1 }, arrayOfInt14, arrayOfInt15, { 6, 30, 56, 82, 108, 134, -1 }, arrayOfInt16, arrayOfInt17, { 6, 34, 62, 90, 118, 146, -1 }, { 6, 30, 54, 78, 102, 126, 150 }, { 6, 24, 50, 76, 102, 128, 154 }, { 6, 28, 54, 80, 106, 132, 158 }, { 6, 32, 58, 84, 110, 136, 162 }, arrayOfInt18, arrayOfInt19 };
    arrayOfInt1 = new int[] { 8, 0 };
    arrayOfInt2 = new int[] { 8, 1 };
    arrayOfInt3 = new int[] { 8, 2 };
    arrayOfInt4 = new int[] { 8, 3 };
    arrayOfInt5 = new int[] { 8, 4 };
    arrayOfInt6 = new int[] { 8, 5 };
    arrayOfInt7 = new int[] { 8, 7 };
    arrayOfInt8 = new int[] { 8, 8 };
    arrayOfInt9 = new int[] { 7, 8 };
    arrayOfInt10 = new int[] { 5, 8 };
    arrayOfInt11 = new int[] { 3, 8 };
    arrayOfInt12 = new int[] { 2, 8 };
    arrayOfInt13 = new int[] { 1, 8 };
    arrayOfInt14 = new int[] { 0, 8 };
    TYPE_INFO_COORDINATES = new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, arrayOfInt10, { 4, 8 }, arrayOfInt11, arrayOfInt12, arrayOfInt13, arrayOfInt14 };
  }
  
  static void buildMatrix(BitArray paramBitArray, ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    clearMatrix(paramByteMatrix);
    embedBasicPatterns(paramInt1, paramByteMatrix);
    embedTypeInfo(paramErrorCorrectionLevel, paramInt2, paramByteMatrix);
    maybeEmbedVersionInfo(paramInt1, paramByteMatrix);
    embedDataBits(paramBitArray, paramInt2, paramByteMatrix);
  }
  
  static int calculateBCHCode(int paramInt1, int paramInt2)
  {
    int i = findMSBSet(paramInt2);
    paramInt1 <<= i - 1;
    while (findMSBSet(paramInt1) >= i) {
      paramInt1 ^= paramInt2 << findMSBSet(paramInt1) - i;
    }
    return paramInt1;
  }
  
  static void clearMatrix(ByteMatrix paramByteMatrix)
  {
    paramByteMatrix.clear((byte)-1);
  }
  
  static void embedBasicPatterns(int paramInt, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    embedPositionDetectionPatternsAndSeparators(paramByteMatrix);
    embedDarkDotAtLeftBottomCorner(paramByteMatrix);
    maybeEmbedPositionAdjustmentPatterns(paramInt, paramByteMatrix);
    embedTimingPatterns(paramByteMatrix);
  }
  
  private static void embedDarkDotAtLeftBottomCorner(ByteMatrix paramByteMatrix)
    throws WriterException
  {
    if (paramByteMatrix.get(8, paramByteMatrix.getHeight() - 8) == 0) {
      throw new WriterException();
    }
    paramByteMatrix.set(8, paramByteMatrix.getHeight() - 8, 1);
  }
  
  static void embedDataBits(BitArray paramBitArray, int paramInt, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    int i2 = 0;
    int k = -1;
    int j = paramByteMatrix.getWidth() - 1;
    int i = paramByteMatrix.getHeight() - 1;
    while (j > 0)
    {
      int i1 = i2;
      int m = j;
      int n = i;
      if (j == 6)
      {
        m = j - 1;
        n = i;
      }
      for (i1 = i2; (n >= 0) && (n < paramByteMatrix.getHeight()); i1 = i)
      {
        j = 0;
        i = i1;
        while (j < 2)
        {
          i1 = m - j;
          if (!isEmpty(paramByteMatrix.get(i1, n)))
          {
            j += 1;
          }
          else
          {
            boolean bool1;
            if (i < paramBitArray.getSize())
            {
              bool1 = paramBitArray.get(i);
              i += 1;
              label132:
              bool2 = bool1;
              if (paramInt != -1)
              {
                bool2 = bool1;
                if (MaskUtil.getDataMaskBit(paramInt, i1, n)) {
                  if (bool1) {
                    break label183;
                  }
                }
              }
            }
            label183:
            for (boolean bool2 = true;; bool2 = false)
            {
              paramByteMatrix.set(i1, n, bool2);
              break;
              bool1 = false;
              break label132;
            }
          }
        }
        n += k;
      }
      k = -k;
      i = n + k;
      j = m - 2;
      i2 = i1;
    }
    if (i2 != paramBitArray.getSize()) {
      throw new WriterException("Not all bits consumed: " + i2 + '/' + paramBitArray.getSize());
    }
  }
  
  private static void embedHorizontalSeparationPattern(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    if ((HORIZONTAL_SEPARATION_PATTERN[0].length != 8) || (HORIZONTAL_SEPARATION_PATTERN.length != 1)) {
      throw new WriterException("Bad horizontal separation pattern");
    }
    int i = 0;
    while (i < 8)
    {
      if (!isEmpty(paramByteMatrix.get(paramInt1 + i, paramInt2))) {
        throw new WriterException();
      }
      paramByteMatrix.set(paramInt1 + i, paramInt2, HORIZONTAL_SEPARATION_PATTERN[0][i]);
      i += 1;
    }
  }
  
  private static void embedPositionAdjustmentPattern(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    if ((POSITION_ADJUSTMENT_PATTERN[0].length != 5) || (POSITION_ADJUSTMENT_PATTERN.length != 5)) {
      throw new WriterException("Bad position adjustment");
    }
    int i = 0;
    while (i < 5)
    {
      int j = 0;
      while (j < 5)
      {
        if (!isEmpty(paramByteMatrix.get(paramInt1 + j, paramInt2 + i))) {
          throw new WriterException();
        }
        paramByteMatrix.set(paramInt1 + j, paramInt2 + i, POSITION_ADJUSTMENT_PATTERN[i][j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void embedPositionDetectionPattern(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    if ((POSITION_DETECTION_PATTERN[0].length != 7) || (POSITION_DETECTION_PATTERN.length != 7)) {
      throw new WriterException("Bad position detection pattern");
    }
    int i = 0;
    while (i < 7)
    {
      int j = 0;
      while (j < 7)
      {
        if (!isEmpty(paramByteMatrix.get(paramInt1 + j, paramInt2 + i))) {
          throw new WriterException();
        }
        paramByteMatrix.set(paramInt1 + j, paramInt2 + i, POSITION_DETECTION_PATTERN[i][j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void embedPositionDetectionPatternsAndSeparators(ByteMatrix paramByteMatrix)
    throws WriterException
  {
    int i = POSITION_DETECTION_PATTERN[0].length;
    embedPositionDetectionPattern(0, 0, paramByteMatrix);
    embedPositionDetectionPattern(paramByteMatrix.getWidth() - i, 0, paramByteMatrix);
    embedPositionDetectionPattern(0, paramByteMatrix.getWidth() - i, paramByteMatrix);
    i = HORIZONTAL_SEPARATION_PATTERN[0].length;
    embedHorizontalSeparationPattern(0, i - 1, paramByteMatrix);
    embedHorizontalSeparationPattern(paramByteMatrix.getWidth() - i, i - 1, paramByteMatrix);
    embedHorizontalSeparationPattern(0, paramByteMatrix.getWidth() - i, paramByteMatrix);
    i = VERTICAL_SEPARATION_PATTERN.length;
    embedVerticalSeparationPattern(i, 0, paramByteMatrix);
    embedVerticalSeparationPattern(paramByteMatrix.getHeight() - i - 1, 0, paramByteMatrix);
    embedVerticalSeparationPattern(i, paramByteMatrix.getHeight() - i, paramByteMatrix);
  }
  
  private static void embedTimingPatterns(ByteMatrix paramByteMatrix)
    throws WriterException
  {
    int i = 8;
    while (i < paramByteMatrix.getWidth() - 8)
    {
      int j = (i + 1) % 2;
      if (!isValidValue(paramByteMatrix.get(i, 6))) {
        throw new WriterException();
      }
      if (isEmpty(paramByteMatrix.get(i, 6))) {
        paramByteMatrix.set(i, 6, j);
      }
      if (!isValidValue(paramByteMatrix.get(6, i))) {
        throw new WriterException();
      }
      if (isEmpty(paramByteMatrix.get(6, i))) {
        paramByteMatrix.set(6, i, j);
      }
      i += 1;
    }
  }
  
  static void embedTypeInfo(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    BitArray localBitArray = new BitArray();
    makeTypeInfoBits(paramErrorCorrectionLevel, paramInt, localBitArray);
    paramInt = 0;
    if (paramInt < localBitArray.getSize())
    {
      boolean bool = localBitArray.get(localBitArray.getSize() - 1 - paramInt);
      paramByteMatrix.set(TYPE_INFO_COORDINATES[paramInt][0], TYPE_INFO_COORDINATES[paramInt][1], bool);
      if (paramInt < 8) {
        paramByteMatrix.set(paramByteMatrix.getWidth() - paramInt - 1, 8, bool);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        paramByteMatrix.set(8, paramByteMatrix.getHeight() - 7 + (paramInt - 8), bool);
      }
    }
  }
  
  private static void embedVerticalSeparationPattern(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    if ((VERTICAL_SEPARATION_PATTERN[0].length != 1) || (VERTICAL_SEPARATION_PATTERN.length != 7)) {
      throw new WriterException("Bad vertical separation pattern");
    }
    int i = 0;
    while (i < 7)
    {
      if (!isEmpty(paramByteMatrix.get(paramInt1, paramInt2 + i))) {
        throw new WriterException();
      }
      paramByteMatrix.set(paramInt1, paramInt2 + i, VERTICAL_SEPARATION_PATTERN[i][0]);
      i += 1;
    }
  }
  
  static int findMSBSet(int paramInt)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (i != 0)
    {
      i >>>= 1;
      paramInt += 1;
    }
    return paramInt;
  }
  
  private static boolean isEmpty(int paramInt)
  {
    return paramInt == -1;
  }
  
  private static boolean isValidValue(int paramInt)
  {
    return (paramInt == -1) || (paramInt == 0) || (paramInt == 1);
  }
  
  static void makeTypeInfoBits(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, BitArray paramBitArray)
    throws WriterException
  {
    if (!QRCode.isValidMaskPattern(paramInt)) {
      throw new WriterException("Invalid mask pattern");
    }
    paramInt = paramErrorCorrectionLevel.getBits() << 3 | paramInt;
    paramBitArray.appendBits(paramInt, 5);
    paramBitArray.appendBits(calculateBCHCode(paramInt, 1335), 10);
    paramErrorCorrectionLevel = new BitArray();
    paramErrorCorrectionLevel.appendBits(21522, 15);
    paramBitArray.xor(paramErrorCorrectionLevel);
    if (paramBitArray.getSize() != 15) {
      throw new WriterException("should not happen but we got: " + paramBitArray.getSize());
    }
  }
  
  static void makeVersionInfoBits(int paramInt, BitArray paramBitArray)
    throws WriterException
  {
    paramBitArray.appendBits(paramInt, 6);
    paramBitArray.appendBits(calculateBCHCode(paramInt, 7973), 12);
    if (paramBitArray.getSize() != 18) {
      throw new WriterException("should not happen but we got: " + paramBitArray.getSize());
    }
  }
  
  private static void maybeEmbedPositionAdjustmentPatterns(int paramInt, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    if (paramInt < 2) {}
    for (;;)
    {
      return;
      paramInt -= 1;
      int[] arrayOfInt = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE[paramInt];
      int j = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE[paramInt].length;
      paramInt = 0;
      while (paramInt < j)
      {
        int i = 0;
        if (i < j)
        {
          int k = arrayOfInt[paramInt];
          int m = arrayOfInt[i];
          if ((m == -1) || (k == -1)) {}
          for (;;)
          {
            i += 1;
            break;
            if (isEmpty(paramByteMatrix.get(m, k))) {
              embedPositionAdjustmentPattern(m - 2, k - 2, paramByteMatrix);
            }
          }
        }
        paramInt += 1;
      }
    }
  }
  
  static void maybeEmbedVersionInfo(int paramInt, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    if (paramInt < 7) {}
    for (;;)
    {
      return;
      BitArray localBitArray = new BitArray();
      makeVersionInfoBits(paramInt, localBitArray);
      int i = 17;
      paramInt = 0;
      while (paramInt < 6)
      {
        int j = 0;
        while (j < 3)
        {
          boolean bool = localBitArray.get(i);
          i -= 1;
          paramByteMatrix.set(paramInt, paramByteMatrix.getHeight() - 11 + j, bool);
          paramByteMatrix.set(paramByteMatrix.getHeight() - 11 + j, paramInt, bool);
          j += 1;
        }
        paramInt += 1;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/zxing/qrcode/encoder/MatrixUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */