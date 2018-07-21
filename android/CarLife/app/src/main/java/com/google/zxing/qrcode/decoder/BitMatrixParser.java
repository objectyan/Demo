package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

final class BitMatrixParser
{
  private final BitMatrix bitMatrix;
  private FormatInformation parsedFormatInfo;
  private Version parsedVersion;
  
  BitMatrixParser(BitMatrix paramBitMatrix)
    throws FormatException
  {
    int i = paramBitMatrix.getHeight();
    if ((i < 21) || ((i & 0x3) != 1)) {
      throw FormatException.getFormatInstance();
    }
    this.bitMatrix = paramBitMatrix;
  }
  
  private int copyBit(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.bitMatrix.get(paramInt1, paramInt2)) {
      return paramInt3 << 1 | 0x1;
    }
    return paramInt3 << 1;
  }
  
  byte[] readCodewords()
    throws FormatException
  {
    Object localObject = readFormatInformation();
    Version localVersion = readVersion();
    localObject = DataMask.forReference(((FormatInformation)localObject).getDataMask());
    int i6 = this.bitMatrix.getHeight();
    ((DataMask)localObject).unmaskBitMatrix(this.bitMatrix, i6);
    localObject = localVersion.buildFunctionPattern();
    int i2 = 1;
    byte[] arrayOfByte = new byte[localVersion.getTotalCodewords()];
    int i = 0;
    int k = 0;
    int m = 0;
    int j = i6 - 1;
    int i3;
    label93:
    int i4;
    label112:
    int i5;
    label115:
    int i1;
    int n;
    if (j > 0)
    {
      i3 = j;
      if (j == 6) {
        i3 = j - 1;
      }
      j = 0;
      if (j < i6) {
        if (i2 != 0)
        {
          i4 = i6 - 1 - j;
          i5 = 0;
          if (i5 >= 2) {
            break label231;
          }
          i1 = m;
          n = k;
          if (((BitMatrix)localObject).get(i3 - i5, i4)) {
            break label268;
          }
          m += 1;
          n = k << 1;
          k = n;
          if (this.bitMatrix.get(i3 - i5, i4)) {
            k = n | 0x1;
          }
          i1 = m;
          n = k;
          if (m != 8) {
            break label268;
          }
          m = i + 1;
          arrayOfByte[i] = ((byte)k);
          n = 0;
          k = 0;
          i = m;
          m = n;
        }
      }
    }
    for (;;)
    {
      i5 += 1;
      break label115;
      i4 = j;
      break label112;
      label231:
      j += 1;
      break label93;
      i2 ^= 0x1;
      j = i3 - 2;
      break;
      if (i != localVersion.getTotalCodewords()) {
        throw FormatException.getFormatInstance();
      }
      return arrayOfByte;
      label268:
      m = i1;
      k = n;
    }
  }
  
  FormatInformation readFormatInformation()
    throws FormatException
  {
    if (this.parsedFormatInfo != null) {
      return this.parsedFormatInfo;
    }
    int j = 0;
    int i = 0;
    while (i < 6)
    {
      j = copyBit(i, 8, j);
      i += 1;
    }
    j = copyBit(8, 7, copyBit(8, 8, copyBit(7, 8, j)));
    i = 5;
    while (i >= 0)
    {
      j = copyBit(8, i, j);
      i -= 1;
    }
    int m = this.bitMatrix.getHeight();
    i = 0;
    int k = m - 1;
    while (k >= m - 7)
    {
      i = copyBit(8, k, i);
      k -= 1;
    }
    k = m - 8;
    while (k < m)
    {
      i = copyBit(k, 8, i);
      k += 1;
    }
    this.parsedFormatInfo = FormatInformation.decodeFormatInformation(j, i);
    if (this.parsedFormatInfo != null) {
      return this.parsedFormatInfo;
    }
    throw FormatException.getFormatInstance();
  }
  
  Version readVersion()
    throws FormatException
  {
    if (this.parsedVersion != null) {
      return this.parsedVersion;
    }
    int m = this.bitMatrix.getHeight();
    int i = m - 17 >> 2;
    if (i <= 6) {
      return Version.getVersionForNumber(i);
    }
    int j = 0;
    int n = m - 11;
    i = 5;
    int k;
    while (i >= 0)
    {
      k = m - 9;
      while (k >= n)
      {
        j = copyBit(k, i, j);
        k -= 1;
      }
      i -= 1;
    }
    Version localVersion = Version.decodeVersionInformation(j);
    if ((localVersion != null) && (localVersion.getDimensionForVersion() == m))
    {
      this.parsedVersion = localVersion;
      return localVersion;
    }
    j = 0;
    i = 5;
    while (i >= 0)
    {
      k = m - 9;
      while (k >= n)
      {
        j = copyBit(i, k, j);
        k -= 1;
      }
      i -= 1;
    }
    localVersion = Version.decodeVersionInformation(j);
    if ((localVersion != null) && (localVersion.getDimensionForVersion() == m))
    {
      this.parsedVersion = localVersion;
      return localVersion;
    }
    throw FormatException.getFormatInstance();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/zxing/qrcode/decoder/BitMatrixParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */