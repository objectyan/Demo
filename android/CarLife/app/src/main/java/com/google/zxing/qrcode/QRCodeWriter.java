package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.util.Map;

public final class QRCodeWriter
  implements Writer
{
  private static final int QUIET_ZONE_SIZE = 4;
  
  private static BitMatrix renderResult(QRCode paramQRCode, int paramInt1, int paramInt2)
  {
    paramQRCode = paramQRCode.getMatrix();
    if (paramQRCode == null) {
      throw new IllegalStateException();
    }
    int m = paramQRCode.getWidth();
    int n = paramQRCode.getHeight();
    int j = m + 8;
    int k = n + 8;
    int i = Math.max(paramInt1, j);
    paramInt2 = Math.max(paramInt2, k);
    int i1 = Math.min(i / j, paramInt2 / k);
    k = (i - m * i1) / 2;
    paramInt1 = (paramInt2 - n * i1) / 2;
    BitMatrix localBitMatrix = new BitMatrix(i, paramInt2);
    paramInt2 = 0;
    while (paramInt2 < n)
    {
      j = 0;
      i = k;
      while (j < m)
      {
        if (paramQRCode.get(j, paramInt2) == 1) {
          localBitMatrix.setRegion(i, paramInt1, i1, i1);
        }
        j += 1;
        i += i1;
      }
      paramInt2 += 1;
      paramInt1 += i1;
    }
    return localBitMatrix;
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2)
    throws WriterException
  {
    return encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, null);
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
    throws WriterException
  {
    if (paramString.length() == 0) {
      throw new IllegalArgumentException("Found empty contents");
    }
    if (paramBarcodeFormat != BarcodeFormat.QR_CODE) {
      throw new IllegalArgumentException("Can only encode QR_CODE, but got " + paramBarcodeFormat);
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IllegalArgumentException("Requested dimensions are too small: " + paramInt1 + 'x' + paramInt2);
    }
    Object localObject = ErrorCorrectionLevel.L;
    paramBarcodeFormat = (BarcodeFormat)localObject;
    if (paramMap != null)
    {
      ErrorCorrectionLevel localErrorCorrectionLevel = (ErrorCorrectionLevel)paramMap.get(EncodeHintType.ERROR_CORRECTION);
      paramBarcodeFormat = (BarcodeFormat)localObject;
      if (localErrorCorrectionLevel != null) {
        paramBarcodeFormat = localErrorCorrectionLevel;
      }
    }
    localObject = new QRCode();
    Encoder.encode(paramString, paramBarcodeFormat, paramMap, (QRCode)localObject);
    return renderResult((QRCode)localObject, paramInt1, paramInt2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/zxing/qrcode/QRCodeWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */