package com.baidu.ufosdk.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

public final class r
{
  private static int a(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[(paramInt + 0)] | paramArrayOfByte[(paramInt + 1)] << 8 | paramArrayOfByte[(paramInt + 2)] << 16 | paramArrayOfByte[(paramInt + 3)] << 24;
  }
  
  public static Drawable a(Context paramContext, String paramString)
  {
    Object localObject2 = paramContext.getAssets().open("ufo_res/" + paramString);
    Object localObject1 = BitmapFactory.decodeStream((InputStream)localObject2);
    byte[] arrayOfByte = a((Bitmap)localObject1);
    if (NinePatch.isNinePatchChunk(arrayOfByte))
    {
      paramString = Bitmap.createBitmap((Bitmap)localObject1, 1, 1, ((Bitmap)localObject1).getWidth() - 2, ((Bitmap)localObject1).getHeight() - 2);
      ((Bitmap)localObject1).recycle();
      localObject1 = paramString.getClass().getDeclaredField("mNinePatchChunk");
      ((Field)localObject1).setAccessible(true);
      ((Field)localObject1).set(paramString, arrayOfByte);
    }
    for (;;)
    {
      ((InputStream)localObject2).close();
      if (paramString.getNinePatchChunk() != null) {
        break;
      }
      return new BitmapDrawable(paramString);
      paramString = (String)localObject1;
    }
    localObject1 = new Rect();
    localObject2 = paramString.getNinePatchChunk();
    ((Rect)localObject1).left = a((byte[])localObject2, 12);
    ((Rect)localObject1).right = a((byte[])localObject2, 16);
    ((Rect)localObject1).top = a((byte[])localObject2, 20);
    ((Rect)localObject1).bottom = a((byte[])localObject2, 24);
    return new NinePatchDrawable(paramContext.getResources(), paramString, paramString.getNinePatchChunk(), (Rect)localObject1, null);
  }
  
  private static void a(Bitmap paramBitmap, byte[] paramArrayOfByte)
  {
    int j = 0;
    int[] arrayOfInt = new int[paramBitmap.getWidth() - 2];
    paramBitmap.getPixels(arrayOfInt, 0, arrayOfInt.length, 1, paramBitmap.getHeight() - 1, arrayOfInt.length, 1);
    int i = 0;
    if (i >= arrayOfInt.length)
    {
      label42:
      i = arrayOfInt.length - 1;
      label48:
      if (i >= 0) {
        break label127;
      }
      label52:
      arrayOfInt = new int[paramBitmap.getHeight() - 2];
      paramBitmap.getPixels(arrayOfInt, 0, 1, paramBitmap.getWidth() - 1, 0, 1, arrayOfInt.length);
      i = j;
      label83:
      if (i < arrayOfInt.length) {
        break label159;
      }
      label90:
      i = arrayOfInt.length - 1;
    }
    for (;;)
    {
      if (i < 0)
      {
        return;
        if (-16777216 == arrayOfInt[i])
        {
          a(paramArrayOfByte, 12, i);
          break label42;
        }
        i += 1;
        break;
        label127:
        if (-16777216 == arrayOfInt[i])
        {
          a(paramArrayOfByte, 16, arrayOfInt.length - i - 2);
          break label52;
        }
        i -= 1;
        break label48;
        label159:
        if (-16777216 == arrayOfInt[i])
        {
          a(paramArrayOfByte, 20, i);
          break label90;
        }
        i += 1;
        break label83;
      }
      if (-16777216 == arrayOfInt[i])
      {
        a(paramArrayOfByte, 24, arrayOfInt.length - i - 2);
        return;
      }
      i -= 1;
    }
  }
  
  private static void a(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write(paramInt >> 0 & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    paramOutputStream.write(paramInt >> 16 & 0xFF);
    paramOutputStream.write(paramInt >> 24 & 0xFF);
  }
  
  private static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[(paramInt1 + 0)] = ((byte)(paramInt2 >> 0));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 8));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(paramInt2 >> 16));
    paramArrayOfByte[(paramInt1 + 3)] = ((byte)(paramInt2 >> 24));
  }
  
  private static byte[] a(Bitmap paramBitmap)
  {
    int j = paramBitmap.getWidth();
    int i3 = paramBitmap.getHeight();
    Object localObject = new ByteArrayOutputStream();
    int i = 0;
    int[] arrayOfInt;
    int m;
    label61:
    int k;
    label76:
    int i4;
    int i1;
    if (i >= 32)
    {
      arrayOfInt = new int[j - 2];
      paramBitmap.getPixels(arrayOfInt, 0, j, 1, 0, j - 2, 1);
      if (arrayOfInt[0] != -16777216) {
        break label316;
      }
      m = 1;
      if (arrayOfInt[(arrayOfInt.length - 1)] != -16777216) {
        break label322;
      }
      k = 1;
      i4 = arrayOfInt.length;
      j = 0;
      i1 = 0;
      i = 0;
      label88:
      if (j < i4) {
        break label327;
      }
      j = i;
      if (k != 0)
      {
        j = i + 1;
        a((OutputStream)localObject, i4);
      }
      i = j + 1;
      if (m == 0) {
        break label459;
      }
      i -= 1;
    }
    label167:
    label183:
    label196:
    label316:
    label322:
    label327:
    label380:
    label386:
    label451:
    label459:
    for (;;)
    {
      if (k != 0) {}
      for (k = i - 1;; k = i)
      {
        arrayOfInt = new int[i3 - 2];
        paramBitmap.getPixels(arrayOfInt, 0, 1, 0, 1, 1, i3 - 2);
        int n;
        if (arrayOfInt[0] == -16777216)
        {
          n = 1;
          if (arrayOfInt[(arrayOfInt.length - 1)] != -16777216) {
            break label380;
          }
          m = 1;
          int i5 = arrayOfInt.length;
          i1 = 0;
          i3 = 0;
          i = 0;
          if (i1 < i5) {
            break label386;
          }
          i1 = i;
          if (m != 0)
          {
            i1 = i + 1;
            a((OutputStream)localObject, i5);
          }
          i = i1 + 1;
          if (n == 0) {
            break label451;
          }
          i -= 1;
        }
        for (;;)
        {
          n = i;
          if (m != 0) {
            n = i - 1;
          }
          i = 0;
          for (;;)
          {
            if (i >= k * n)
            {
              localObject = ((ByteArrayOutputStream)localObject).toByteArray();
              localObject[0] = 1;
              localObject[1] = ((byte)j);
              localObject[2] = ((byte)i1);
              localObject[3] = ((byte)(n * k));
              a(paramBitmap, (byte[])localObject);
              return (byte[])localObject;
              ((ByteArrayOutputStream)localObject).write(0);
              i += 1;
              break;
              m = 0;
              break label61;
              k = 0;
              break label76;
              int i2 = i1;
              n = i;
              if (i1 != arrayOfInt[j])
              {
                n = i + 1;
                a((OutputStream)localObject, j);
                i2 = arrayOfInt[j];
              }
              j += 1;
              i1 = i2;
              i = n;
              break label88;
              n = 0;
              break label167;
              m = 0;
              break label183;
              i4 = i3;
              i2 = i;
              if (i3 != arrayOfInt[i1])
              {
                i2 = i + 1;
                a((OutputStream)localObject, i1);
                i4 = arrayOfInt[i1];
              }
              i1 += 1;
              i3 = i4;
              i = i2;
              break label196;
            }
            a((OutputStream)localObject, 1);
            i += 1;
          }
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/util/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */