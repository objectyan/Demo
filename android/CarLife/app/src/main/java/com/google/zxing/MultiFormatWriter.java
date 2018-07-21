package com.google.zxing;

import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.CodaBarWriter;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.oned.EAN8Writer;
import com.google.zxing.oned.ITFWriter;
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.pdf417.encoder.PDF417Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import java.util.Map;

public final class MultiFormatWriter
  implements Writer
{
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2)
    throws WriterException
  {
    return encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, null);
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
    throws WriterException
  {
    Object localObject;
    switch (paramBarcodeFormat)
    {
    default: 
      throw new IllegalArgumentException("No encoder available for format " + paramBarcodeFormat);
    case ???: 
      localObject = new EAN8Writer();
    }
    for (;;)
    {
      return ((Writer)localObject).encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
      localObject = new EAN13Writer();
      continue;
      localObject = new UPCAWriter();
      continue;
      localObject = new QRCodeWriter();
      continue;
      localObject = new Code39Writer();
      continue;
      localObject = new Code128Writer();
      continue;
      localObject = new ITFWriter();
      continue;
      localObject = new PDF417Writer();
      continue;
      localObject = new CodaBarWriter();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/zxing/MultiFormatWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */