package vi.com.gdi.bgl.android.java;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint.Cap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.TextPaint;
import com.baidu.platform.comapi.util.SysOSAPIv2;

public class EnvDrawText
{
  public static final String DEVICE_VIVOX3L = "vivo X3L";
  public static final int FONT_STYLE_BOLD = 1;
  public static final int FONT_STYLE_ITALIC = 2;
  public static final int FONT_STYLE_NORMAL = 0;
  
  public static int[] drawText(String paramString, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    TextPaint localTextPaint;
    int n;
    int i2;
    int m;
    int k;
    Paint.FontMetrics localFontMetrics2;
    Bitmap localBitmap;
    Paint.FontMetrics localFontMetrics1;
    Object localObject3;
    Object localObject4;
    Object localObject2;
    Object localObject1;
    label273:
    try
    {
      localTextPaint = new TextPaint();
      n = 0;
      i2 = 0;
      m = 0;
      j = 0;
      k = 0;
      i1 = 0;
      localFontMetrics2 = null;
      localBitmap = null;
      localFontMetrics1 = null;
      localObject3 = null;
      localObject4 = null;
      localObject2 = null;
      localObject1 = SysOSAPIv2.getInstance().getPhoneType();
      i = paramInt2;
      if (localObject1 != null)
      {
        i = paramInt2;
        if (((String)localObject1).equals("vivo X3L")) {
          i = 0;
        }
      }
      localTextPaint.reset();
      localTextPaint.setSubpixelText(true);
      localTextPaint.setAntiAlias(true);
      localTextPaint.setTextSize(paramInt1);
      switch (i)
      {
      case 1: 
        localTextPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        paramInt1 = paramString.indexOf('\\', 0);
        if (paramInt1 != -1) {
          break label625;
        }
        localFontMetrics2 = localTextPaint.getFontMetrics();
        k = (int)(Layout.getDesiredWidth(paramString, 0, paramString.length(), localTextPaint) + 0.5D);
        paramInt2 = (int)Math.ceil(localFontMetrics2.descent - localFontMetrics2.ascent);
        paramArrayOfInt[0] = k;
        paramArrayOfInt[1] = paramInt2;
        paramInt1 = paramInt2;
        i = k;
        if (paramArrayOfInt.length != 4) {
          break label1377;
        }
        i = (int)Math.pow(2.0D, (int)Math.ceil(Math.log(k) / Math.log(2.0D)));
        paramInt1 = (int)Math.pow(2.0D, (int)Math.ceil(Math.log(paramInt2) / Math.log(2.0D)));
      }
    }
    finally {}
    if (paramArrayOfInt.length == 4)
    {
      paramArrayOfInt[2] = paramInt2;
      paramArrayOfInt[3] = j;
    }
    if (k != 0)
    {
      if (0 != 0) {
        throw new NullPointerException();
      }
      paramArrayOfInt = localBitmap;
      localObject1 = localFontMetrics1;
      if (paramInt2 > 0)
      {
        paramArrayOfInt = localBitmap;
        localObject1 = localFontMetrics1;
        if (j > 0)
        {
          localObject3 = Bitmap.createBitmap(paramInt2, j, Bitmap.Config.ARGB_8888);
          paramArrayOfInt = (int[])localObject2;
          if (0 == 0) {
            paramArrayOfInt = new Canvas();
          }
          paramArrayOfInt.setBitmap((Bitmap)localObject3);
          localObject1 = paramArrayOfInt;
          paramArrayOfInt = (int[])localObject3;
        }
      }
      label366:
      if (localObject1 != null)
      {
        if ((0xFF000000 & paramInt5) != 0) {
          break label615;
        }
        ((Canvas)localObject1).drawColor(33554431);
      }
    }
    for (;;)
    {
      if ((paramInt6 != 0) && (localObject1 != null))
      {
        localTextPaint.setStrokeWidth(paramInt6);
        localTextPaint.setStrokeCap(Paint.Cap.ROUND);
        localTextPaint.setStrokeJoin(Paint.Join.ROUND);
        localTextPaint.setStyle(Paint.Style.STROKE);
        localTextPaint.setColor(paramInt4);
        ((Canvas)localObject1).drawText(paramString, 0.0F, 0.0F - localFontMetrics2.ascent, localTextPaint);
      }
      localTextPaint.setStyle(Paint.Style.FILL);
      localTextPaint.setColor(paramInt3);
      localObject3 = paramArrayOfInt;
      k = paramInt2;
      i = j;
      if (localObject1 != null)
      {
        ((Canvas)localObject1).drawText(paramString, 0.0F, 0.0F - localFontMetrics2.ascent, localTextPaint);
        i = j;
        k = paramInt2;
        localObject3 = paramArrayOfInt;
      }
      label507:
      paramString = new int[k * i];
      if (localObject3 != null) {
        ((Bitmap)localObject3).getPixels(paramString, 0, k, 0, 0, k, i);
      }
      if ((localObject3 != null) && (!((Bitmap)localObject3).isRecycled())) {
        ((Bitmap)localObject3).recycle();
      }
      return paramString;
      localTextPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
      break;
      localTextPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
      break;
      paramArrayOfInt = localBitmap;
      localObject1 = localFontMetrics1;
      if (0 == 0) {
        break label366;
      }
      throw new NullPointerException();
      label615:
      ((Canvas)localObject1).drawColor(paramInt5);
    }
    label625:
    int j = paramInt1 + 1;
    int i = 2;
    paramInt1 = (int)(Layout.getDesiredWidth(paramString.substring(0, paramInt1), localTextPaint) + 0.5D);
    label651:
    int i1 = paramString.indexOf('\\', j);
    if (i1 > 0)
    {
      j = (int)(Layout.getDesiredWidth(paramString.substring(j, i1), localTextPaint) + 0.5D);
      paramInt2 = paramInt1;
      if (j > paramInt1) {
        paramInt2 = j;
      }
    }
    else
    {
      paramInt2 = paramInt1;
      if (j != paramString.length())
      {
        j = (int)(Layout.getDesiredWidth(paramString.substring(j, paramString.length()), localTextPaint) + 0.5D);
        paramInt2 = paramInt1;
        if (j > paramInt1) {
          paramInt2 = j;
        }
      }
      localFontMetrics1 = localTextPaint.getFontMetrics();
      i1 = (int)Math.ceil(localFontMetrics1.descent - localFontMetrics1.ascent);
      paramInt1 = i1 * i;
      paramArrayOfInt[0] = paramInt2;
      paramArrayOfInt[1] = paramInt1;
      i = paramInt1;
      j = paramInt2;
      if (paramArrayOfInt.length != 4) {
        break label1422;
      }
      j = (int)Math.pow(2.0D, (int)Math.ceil(Math.log(paramInt2) / Math.log(2.0D)));
      i = (int)Math.pow(2.0D, (int)Math.ceil(Math.log(paramInt1) / Math.log(2.0D)));
      break label1422;
      label852:
      if (paramArrayOfInt.length == 4)
      {
        paramArrayOfInt[2] = paramInt1;
        paramArrayOfInt[3] = paramInt2;
      }
      if (k != 0)
      {
        if (0 != 0) {
          throw new NullPointerException();
        }
        localObject1 = localFontMetrics2;
        localObject2 = localObject4;
        if (paramInt1 > 0)
        {
          localObject1 = localFontMetrics2;
          localObject2 = localObject4;
          if (paramInt2 > 0)
          {
            localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
            localObject1 = localObject3;
            if (0 == 0) {
              localObject1 = new Canvas();
            }
            ((Canvas)localObject1).setBitmap(localBitmap);
            localObject2 = localObject1;
            localObject1 = localBitmap;
          }
        }
        label949:
        if (localObject2 == null) {
          break label1450;
        }
        if ((0xFF000000 & paramInt5) != 0) {
          break label1170;
        }
        ((Canvas)localObject2).drawColor(33554431);
        break label1450;
      }
    }
    for (;;)
    {
      k = paramString.indexOf('\\', j);
      if (k > 0)
      {
        localObject3 = paramString.substring(j, k);
        i = (int)(Layout.getDesiredWidth((CharSequence)localObject3, localTextPaint) + 0.5D);
        j = k + 1;
        if ((paramInt6 != 0) && (localObject2 != null))
        {
          localTextPaint.setStrokeWidth(paramInt6);
          localTextPaint.setStrokeCap(Paint.Cap.ROUND);
          localTextPaint.setStrokeJoin(Paint.Join.ROUND);
          localTextPaint.setStyle(Paint.Style.STROKE);
          localTextPaint.setColor(paramInt4);
          ((Canvas)localObject2).drawText((String)localObject3, (paramArrayOfInt[0] - i) / 2, paramInt5 * i1 - localFontMetrics1.ascent, localTextPaint);
        }
        localTextPaint.setStyle(Paint.Style.FILL);
        localTextPaint.setColor(paramInt3);
        if (localObject2 == null) {
          break label1459;
        }
        ((Canvas)localObject2).drawText((String)localObject3, (paramArrayOfInt[0] - i) / 2, paramInt5 * i1 - localFontMetrics1.ascent, localTextPaint);
        break label1459;
        localObject1 = localFontMetrics2;
        localObject2 = localObject4;
        if (0 == 0) {
          break label949;
        }
        throw new NullPointerException();
        label1170:
        ((Canvas)localObject2).drawColor(paramInt5);
        break label1450;
      }
      localObject3 = localObject1;
      k = paramInt1;
      i = paramInt2;
      if (j == paramString.length()) {
        break label507;
      }
      paramString = paramString.substring(j, paramString.length());
      j = (int)(Layout.getDesiredWidth(paramString, localTextPaint) + 0.5D);
      if ((paramInt6 != 0) && (localObject2 != null))
      {
        localTextPaint.setStrokeWidth(paramInt6);
        localTextPaint.setStrokeCap(Paint.Cap.ROUND);
        localTextPaint.setStrokeJoin(Paint.Join.ROUND);
        localTextPaint.setStyle(Paint.Style.STROKE);
        localTextPaint.setColor(paramInt4);
        ((Canvas)localObject2).drawText(paramString, (paramArrayOfInt[0] - j) / 2, paramInt5 * i1 - localFontMetrics1.ascent, localTextPaint);
      }
      localTextPaint.setStyle(Paint.Style.FILL);
      localTextPaint.setColor(paramInt3);
      localObject3 = localObject1;
      k = paramInt1;
      i = paramInt2;
      if (localObject2 == null) {
        break label507;
      }
      ((Canvas)localObject2).drawText(paramString, (paramArrayOfInt[0] - j) / 2, paramInt5 * i1 - localFontMetrics1.ascent, localTextPaint);
      localObject3 = localObject1;
      k = paramInt1;
      i = paramInt2;
      break label507;
      break;
      label1377:
      if (i == 0)
      {
        paramInt2 = i2;
        k = i1;
        if (paramInt1 == 0) {
          break label273;
        }
      }
      k = 1;
      paramInt2 = i;
      j = paramInt1;
      break label273;
      j = i1 + 1;
      i += 1;
      paramInt1 = paramInt2;
      break label651;
      label1422:
      if (j == 0)
      {
        paramInt1 = n;
        paramInt2 = m;
        if (i == 0) {
          break label852;
        }
      }
      k = 1;
      paramInt1 = j;
      paramInt2 = i;
      break label852;
      label1450:
      j = 0;
      paramInt5 = 0;
      continue;
      label1459:
      paramInt5 += 1;
    }
  }
  
  public static short[] getTextSize(String paramString, int paramInt1, int paramInt2)
  {
    int i = paramString.length();
    Object localObject;
    if (i == 0)
    {
      localObject = null;
      return (short[])localObject;
    }
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setSubpixelText(true);
    localTextPaint.setAntiAlias(true);
    localTextPaint.setTextSize(paramInt1);
    switch (paramInt2)
    {
    default: 
      localTextPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
    }
    for (;;)
    {
      short[] arrayOfShort = new short[i];
      paramInt1 = 0;
      for (;;)
      {
        localObject = arrayOfShort;
        if (paramInt1 >= i) {
          break;
        }
        arrayOfShort[paramInt1] = ((short)(int)(Layout.getDesiredWidth(paramString, 0, paramInt1 + 1, localTextPaint) + 0.5D));
        paramInt1 += 1;
      }
      localTextPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
      continue;
      localTextPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/vi/com/gdi/bgl/android/java/EnvDrawText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */