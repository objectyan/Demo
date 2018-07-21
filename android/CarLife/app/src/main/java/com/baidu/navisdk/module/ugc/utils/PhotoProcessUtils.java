package com.baidu.navisdk.module.ugc.utils;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PhotoProcessUtils
{
  public static final int COMPRESSED_HEIGHT = 800;
  public static final int COMPRESSED_WIDTH = 640;
  
  private Bitmap compressBitmap(ContentResolver paramContentResolver, Uri paramUri)
    throws IOException
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    InputStream localInputStream = paramContentResolver.openInputStream(paramUri);
    BitmapFactory.decodeStream(localInputStream, null, localOptions);
    localOptions.inJustDecodeBounds = false;
    int i = localOptions.outWidth;
    int m = localOptions.outHeight;
    int k = m;
    int j = i;
    if (i > m)
    {
      j = localOptions.outHeight;
      k = localOptions.outWidth;
    }
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    m = 1;
    i = m;
    if (j > 640)
    {
      i = m;
      if (k > 800) {
        i = Math.min((int)Math.round(j * 1.0D / 640.0D), (int)Math.round(k * 1.0D / 800.0D));
      }
    }
    LogUtil.e("UGC", "compressBitmap() be=" + i);
    j = i;
    if (i <= 0) {
      j = 1;
    }
    if (localInputStream != null) {
      localInputStream.close();
    }
    localOptions.inSampleSize = j;
    paramContentResolver = paramContentResolver.openInputStream(paramUri);
    paramUri = BitmapFactory.decodeStream(paramContentResolver, null, localOptions);
    if (paramContentResolver != null) {
      paramContentResolver.close();
    }
    return paramUri;
  }
  
  private int getBitmapDegree(String paramString)
  {
    try
    {
      int i = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      switch (i)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      case 6: 
        return 90;
      case 3: 
        return 180;
      }
      return 270;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private String getUniqueFilePath()
  {
    return SysOSAPI.getInstance().GetSDCardCachePath() + "/" + new Object().hashCode();
  }
  
  private Bitmap rotateBitmapByDegree(Bitmap paramBitmap, int paramInt)
  {
    if (paramInt == 0) {
      return paramBitmap;
    }
    Object localObject1 = null;
    Object localObject2 = new Matrix();
    ((Matrix)localObject2).postRotate(paramInt);
    try
    {
      localObject2 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject2, true);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramBitmap;
    }
    if (paramBitmap != localObject2) {
      paramBitmap.recycle();
    }
    return (Bitmap)localObject2;
  }
  
  public Bitmap compress(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramBitmap == null) {
      localObject = null;
    }
    int i;
    int j;
    do
    {
      return (Bitmap)localObject;
      i = paramBitmap.getHeight();
      j = paramBitmap.getWidth();
      if (i >= paramInt1) {
        break;
      }
      localObject = paramBitmap;
    } while (j < paramInt2);
    float f1;
    if (i > j) {
      f1 = paramInt1 / i;
    }
    for (float f2 = paramInt1 / i;; f2 = paramInt2 / j)
    {
      localObject = new Matrix();
      ((Matrix)localObject).postScale(f2, f1);
      return Bitmap.createBitmap(paramBitmap, 0, 0, j, i, (Matrix)localObject, true);
      f1 = paramInt2 / j;
    }
  }
  
  public PicProcessResInfo processAlbumPic(ContentResolver paramContentResolver, Uri paramUri)
    throws Exception
  {
    PicProcessResInfo localPicProcessResInfo = new PicProcessResInfo();
    paramContentResolver = compressBitmap(paramContentResolver, paramUri);
    paramUri = setBitmapToFile(paramContentResolver);
    localPicProcessResInfo.bitmap = paramContentResolver;
    localPicProcessResInfo.filePath = paramUri;
    return localPicProcessResInfo;
  }
  
  public PicProcessResInfo processCameraPic(ContentResolver paramContentResolver, Uri paramUri, String paramString)
    throws Exception
  {
    PicProcessResInfo localPicProcessResInfo = new PicProcessResInfo();
    paramContentResolver = rotateBitmapByDegree(compressBitmap(paramContentResolver, paramUri), getBitmapDegree(paramString));
    paramUri = setBitmapToFile(paramContentResolver);
    localPicProcessResInfo.bitmap = paramContentResolver;
    localPicProcessResInfo.filePath = paramUri;
    return localPicProcessResInfo;
  }
  
  public String setBitmapToFile(Bitmap paramBitmap)
    throws IOException
  {
    String str = getUniqueFilePath();
    if ((paramBitmap == null) || (str == null)) {
      return null;
    }
    Object localObject = new File(str);
    if (!((File)localObject).exists()) {
      ((File)localObject).createNewFile();
    }
    localObject = new FileOutputStream((File)localObject);
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject);
    ((FileOutputStream)localObject).flush();
    ((FileOutputStream)localObject).close();
    return str;
  }
  
  public static class PicProcessResInfo
  {
    public Bitmap bitmap = null;
    public String filePath = null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/utils/PhotoProcessUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */