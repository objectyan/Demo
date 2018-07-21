package com.baidu.carlife.util;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public class a
{
  private static final Uri a = Uri.parse("content://media/external/audio/albumart");
  private static final BitmapFactory.Options b = new BitmapFactory.Options();
  
  private static Bitmap a(Context paramContext)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    return BitmapFactory.decodeStream(paramContext.getResources().openRawResource(2130838954), null, localOptions);
  }
  
  private static Bitmap a(Context paramContext, long paramLong1, long paramLong2)
  {
    if ((paramLong2 < 0L) && (paramLong1 < 0L)) {
      throw new IllegalArgumentException("Must specify an album or a song id");
    }
    if (paramLong2 < 0L) {}
    try
    {
      localUri = Uri.parse("content://media/external/audio/media/" + paramLong1 + "/albumart");
      paramContext = paramContext.getContentResolver().openFileDescriptor(localUri, "r");
      if (paramContext == null) {
        break label120;
      }
      return BitmapFactory.decodeFileDescriptor(paramContext.getFileDescriptor());
    }
    catch (IllegalStateException paramContext)
    {
      Uri localUri;
      return null;
    }
    catch (FileNotFoundException paramContext) {}
    localUri = ContentUris.withAppendedId(a, paramLong2);
    paramContext = paramContext.getContentResolver().openFileDescriptor(localUri, "r");
    if (paramContext != null)
    {
      paramContext = BitmapFactory.decodeFileDescriptor(paramContext.getFileDescriptor());
      return paramContext;
    }
    label120:
    return null;
  }
  
  public static Bitmap a(Context paramContext, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramLong2 < 0L) {
      if (paramLong1 < 0L) {}
    }
    label283:
    Object localObject3;
    for (;;)
    {
      try
      {
        localObject1 = a(paramContext, paramLong1, -1L);
        if (localObject1 != null)
        {
          paramContext = (Context)localObject1;
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        return null;
      }
      if (paramBoolean) {
        return a(paramContext);
      }
      return null;
      Object localObject6 = paramContext.getContentResolver();
      Object localObject7 = ContentUris.withAppendedId(a, paramLong2);
      if (localObject7 == null) {
        break label368;
      }
      Object localObject4 = null;
      Object localObject1 = null;
      Object localObject5 = null;
      try
      {
        localObject6 = ((ContentResolver)localObject6).openInputStream((Uri)localObject7);
        localObject5 = localObject6;
        localObject4 = localObject6;
        localObject1 = localObject6;
        localObject7 = BitmapFactory.decodeStream((InputStream)localObject6, null, b);
        localObject1 = localObject7;
        if (localObject7 == null)
        {
          localObject5 = localObject6;
          localObject4 = localObject6;
          localObject1 = localObject6;
          localObject7 = a(paramContext);
          localObject1 = localObject7;
        }
        if (localObject6 != null) {}
        try
        {
          ((InputStream)localObject6).close();
          return (Bitmap)localObject1;
        }
        catch (IOException paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
          }
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Object localObject2 = localObject5;
        localObject6 = a(paramContext, paramLong1, paramLong2);
        if (localObject6 != null)
        {
          localObject4 = localObject6;
          localObject2 = localObject5;
          if (((Bitmap)localObject6).getConfig() != null) {
            break label283;
          }
          localObject2 = localObject5;
          localObject6 = ((Bitmap)localObject6).copy(Bitmap.Config.RGB_565, false);
          localObject4 = localObject6;
          if (localObject6 != null) {
            break label283;
          }
          localObject4 = localObject6;
          if (!paramBoolean) {
            break label283;
          }
          localObject2 = localObject5;
          paramContext = a(paramContext);
          localObject2 = paramContext;
          paramContext = (Context)localObject2;
          if (localObject5 == null) {
            continue;
          }
          try
          {
            ((InputStream)localObject5).close();
            return (Bitmap)localObject2;
          }
          catch (IOException paramContext)
          {
            paramContext.printStackTrace();
            return (Bitmap)localObject2;
          }
        }
        localObject4 = localObject6;
        if (paramBoolean)
        {
          localObject2 = localObject5;
          localObject4 = a(paramContext);
        }
        paramContext = (Context)localObject4;
        if (localObject5 != null) {
          try
          {
            ((InputStream)localObject5).close();
            return (Bitmap)localObject4;
          }
          catch (IOException paramContext)
          {
            paramContext.printStackTrace();
            return (Bitmap)localObject4;
          }
        }
      }
      catch (SecurityException localSecurityException)
      {
        localObject3 = localObject4;
        paramContext = a(paramContext);
        localObject3 = paramContext;
        paramContext = (Context)localObject3;
        if (localObject4 != null) {
          try
          {
            ((InputStream)localObject4).close();
            return (Bitmap)localObject3;
          }
          catch (IOException paramContext)
          {
            paramContext.printStackTrace();
            return (Bitmap)localObject3;
          }
        }
      }
      finally
      {
        if (localObject3 == null) {}
      }
    }
    try
    {
      ((InputStream)localObject3).close();
      throw paramContext;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
    label368:
    return null;
  }
  
  public static boolean a()
  {
    return com.baidu.carlife.core.a.a().getApplicationContext().getResources().getConfiguration().locale.getLanguage().endsWith("zh");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/util/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */