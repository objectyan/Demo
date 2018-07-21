package com.baidu.navisdk.vi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;

public class EnvDrawText
{
  public static boolean bBmpChange;
  public static Bitmap bmp;
  public static int[] buffer = null;
  public static Canvas canvasTemp;
  public static int iWordHightMax;
  public static int iWordWidthMax;
  public static Paint pt = null;
  
  static
  {
    iWordWidthMax = 0;
    iWordHightMax = 0;
    bBmpChange = false;
    bmp = null;
    canvasTemp = null;
  }
  
  public static int[] drawText(String paramString, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (pt == null) {
      pt = new Paint();
    }
    Paint.FontMetrics localFontMetrics;
    int j;
    int i;
    for (;;)
    {
      pt.setSubpixelText(true);
      pt.setAntiAlias(true);
      pt.setTextSize(paramInt1);
      paramInt1 = paramString.indexOf('\\', 0);
      if (paramInt1 != -1) {
        break label464;
      }
      localFontMetrics = pt.getFontMetrics();
      j = (int)pt.measureText(paramString);
      i = (int)Math.ceil(localFontMetrics.descent - localFontMetrics.ascent);
      paramArrayOfInt[0] = j;
      paramArrayOfInt[1] = i;
      double d = Math.log(2.0D);
      if (d <= 1.0E-7D)
      {
        paramInt2 = i;
        paramInt1 = j;
        if (d >= -1.0E-7D) {}
      }
      else
      {
        paramInt1 = (int)Math.pow(2.0D, (int)Math.ceil(Math.log(j) / d));
        paramInt2 = (int)Math.pow(2.0D, (int)Math.ceil(Math.log(i) / d));
      }
      if ((iWordWidthMax < paramInt1) || (iWordHightMax < paramInt2))
      {
        bBmpChange = true;
        iWordWidthMax = paramInt1;
        iWordHightMax = paramInt2;
      }
      paramArrayOfInt[2] = iWordWidthMax;
      paramArrayOfInt[3] = iWordHightMax;
      if (bBmpChange != true) {
        break label443;
      }
      if ((iWordWidthMax > 0) && (iWordHightMax > 0)) {
        break;
      }
      bBmpChange = false;
      return null;
      pt.reset();
    }
    bmp = Bitmap.createBitmap(iWordWidthMax, iWordHightMax, Bitmap.Config.ARGB_8888);
    canvasTemp = new Canvas(bmp);
    if ((0xFF000000 & paramInt5) == 0)
    {
      canvasTemp.drawColor(33554431);
      label289:
      if (paramInt6 != 0)
      {
        pt.setStrokeWidth(paramInt6);
        pt.setStrokeCap(Paint.Cap.ROUND);
        pt.setStrokeJoin(Paint.Join.ROUND);
        pt.setStyle(Paint.Style.STROKE);
        pt.setColor(paramInt4);
        canvasTemp.drawText(paramString, 0.0F, 0.0F - localFontMetrics.ascent, pt);
      }
      pt.setStyle(Paint.Style.FILL);
      pt.setColor(paramInt3);
      canvasTemp.drawText(paramString, 0.0F, 0.0F - localFontMetrics.ascent, pt);
    }
    for (;;)
    {
      paramInt1 = iWordWidthMax;
      paramInt2 = iWordHightMax;
      if (bBmpChange == true) {
        buffer = new int[paramInt1 * paramInt2];
      }
      bmp.getPixels(buffer, 0, iWordWidthMax, 0, 0, iWordWidthMax, iWordHightMax);
      bBmpChange = false;
      return buffer;
      label443:
      bmp.eraseColor(0);
      break;
      canvasTemp.drawColor(paramInt5);
      break label289;
      label464:
      i = paramInt1 + 1;
      paramInt2 = 2;
      paramInt1 = (int)pt.measureText(paramString.substring(0, paramInt1));
      for (;;)
      {
        int k = paramString.indexOf('\\', i);
        if (k <= 0) {
          break;
        }
        j = (int)pt.measureText(paramString.substring(i, k));
        i = paramInt1;
        if (j > paramInt1) {
          i = j;
        }
        j = k + 1;
        paramInt2 += 1;
        paramInt1 = i;
        i = j;
      }
      j = paramInt1;
      if (i != paramString.length())
      {
        i = (int)pt.measureText(paramString.substring(i, paramString.length()));
        j = paramInt1;
        if (i > paramInt1) {
          j = i;
        }
      }
      localFontMetrics = pt.getFontMetrics();
      i = (int)Math.ceil(localFontMetrics.descent - localFontMetrics.ascent);
      paramInt1 = i * paramInt2;
      paramArrayOfInt[0] = j;
      paramArrayOfInt[1] = paramInt1;
      paramInt2 = (int)Math.pow(2.0D, (int)Math.ceil(Math.log(j) / Math.log(2.0D)));
      paramInt1 = (int)Math.pow(2.0D, (int)Math.ceil(Math.log(paramInt1) / Math.log(2.0D)));
      if ((iWordWidthMax < paramInt2) || (iWordHightMax < paramInt1))
      {
        if ((iWordWidthMax <= 0) || (iWordHightMax <= 0))
        {
          bBmpChange = false;
          return null;
        }
        bBmpChange = true;
        iWordWidthMax = paramInt2;
        iWordHightMax = paramInt1;
      }
      paramArrayOfInt[2] = iWordWidthMax;
      paramArrayOfInt[3] = iWordHightMax;
      if (bBmpChange == true) {}
      for (;;)
      {
        try
        {
          bmp = Bitmap.createBitmap(iWordWidthMax, iWordHightMax, Bitmap.Config.ARGB_8888);
          canvasTemp = new Canvas(bmp);
          if ((0xFF000000 & paramInt5) != 0) {
            break label989;
          }
          canvasTemp.drawColor(33554431);
          paramInt2 = 0;
          paramInt1 = 0;
          paramInt5 = paramString.indexOf('\\', paramInt2);
          if (paramInt5 <= 0) {
            break;
          }
          String str = paramString.substring(paramInt2, paramInt5);
          j = (int)pt.measureText(str);
          paramInt2 = paramInt5 + 1;
          if (paramInt6 != 0)
          {
            pt.setStrokeWidth(paramInt6);
            pt.setStrokeCap(Paint.Cap.ROUND);
            pt.setStrokeJoin(Paint.Join.ROUND);
            pt.setStyle(Paint.Style.STROKE);
            pt.setColor(paramInt4);
            canvasTemp.drawText(str, (paramArrayOfInt[0] - j) / 2, paramInt1 * i - localFontMetrics.ascent, pt);
          }
          pt.setStyle(Paint.Style.FILL);
          pt.setColor(paramInt3);
          canvasTemp.drawText(str, (paramArrayOfInt[0] - j) / 2, paramInt1 * i - localFontMetrics.ascent, pt);
          paramInt1 += 1;
          continue;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          bmp = null;
          continue;
        }
        bmp.eraseColor(0);
        continue;
        label989:
        canvasTemp.drawColor(paramInt5);
      }
      if (paramInt2 != paramString.length())
      {
        paramString = paramString.substring(paramInt2, paramString.length());
        paramInt2 = (int)pt.measureText(paramString);
        if (paramInt6 != 0)
        {
          pt.setStrokeWidth(paramInt6);
          pt.setStrokeCap(Paint.Cap.ROUND);
          pt.setStrokeJoin(Paint.Join.ROUND);
          pt.setStyle(Paint.Style.STROKE);
          pt.setColor(paramInt4);
          canvasTemp.drawText(paramString, (paramArrayOfInt[0] - paramInt2) / 2, paramInt1 * i - localFontMetrics.ascent, pt);
        }
        pt.setStyle(Paint.Style.FILL);
        pt.setColor(paramInt3);
        canvasTemp.drawText(paramString, (paramArrayOfInt[0] - paramInt2) / 2, paramInt1 * i - localFontMetrics.ascent, pt);
      }
    }
  }
  
  public static short[] getTextSize(String paramString, int paramInt)
  {
    int i = paramString.length();
    Object localObject;
    if (i == 0)
    {
      localObject = null;
      return (short[])localObject;
    }
    Paint localPaint = new Paint();
    localPaint.setSubpixelText(true);
    localPaint.setAntiAlias(true);
    localPaint.setTextSize(paramInt);
    short[] arrayOfShort = new short[i];
    paramInt = 0;
    for (;;)
    {
      localObject = arrayOfShort;
      if (paramInt >= i) {
        break;
      }
      if ((i > 0) && (paramInt + 1 <= i)) {
        arrayOfShort[paramInt] = ((short)(int)localPaint.measureText(paramString.substring(0, paramInt + 1)));
      }
      paramInt += 1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/vi/EnvDrawText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */