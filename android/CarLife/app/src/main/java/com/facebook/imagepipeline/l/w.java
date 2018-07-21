package com.facebook.imagepipeline.l;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import com.facebook.common.e.a;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.m.g;
import com.facebook.h.b;
import com.facebook.imagepipeline.m.c;
import com.facebook.imagepipeline.memory.z;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class w
  extends y
  implements av<com.facebook.imagepipeline.i.d>
{
  @VisibleForTesting
  static final String a = "LocalContentUriThumbnailFetchProducer";
  private static final Class<?> b = w.class;
  private static final String[] c = { "_id", "_data" };
  private static final String[] d = { "_data" };
  private static final Rect e = new Rect(0, 0, 512, 384);
  private static final Rect f = new Rect(0, 0, 96, 96);
  private static final int g = 0;
  private final ContentResolver h;
  
  public w(Executor paramExecutor, z paramz, ContentResolver paramContentResolver, boolean paramBoolean)
  {
    super(paramExecutor, paramz, paramBoolean);
    this.h = paramContentResolver;
  }
  
  private static int a(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    return (int)new File(paramString).length();
  }
  
  @Nullable
  private com.facebook.imagepipeline.i.d a(Uri paramUri, com.facebook.imagepipeline.e.d paramd)
    throws IOException
  {
    paramUri = this.h.query(paramUri, c, null, null, null);
    if (paramUri == null) {
      return null;
    }
    try
    {
      int i = paramUri.getCount();
      if (i == 0) {
        return null;
      }
      paramUri.moveToFirst();
      String str = paramUri.getString(paramUri.getColumnIndex("_data"));
      if (paramd != null)
      {
        paramd = a(paramd, paramUri.getInt(paramUri.getColumnIndex("_id")));
        if (paramd != null)
        {
          paramd.c(b(str));
          return paramd;
        }
      }
      return null;
    }
    finally
    {
      paramUri.close();
    }
  }
  
  private com.facebook.imagepipeline.i.d a(com.facebook.imagepipeline.e.d paramd, int paramInt)
    throws IOException
  {
    com.facebook.imagepipeline.i.d locald = null;
    int i = b(paramd);
    Object localObject;
    if (i == 0) {
      localObject = locald;
    }
    for (;;)
    {
      return (com.facebook.imagepipeline.i.d)localObject;
      localObject = null;
      try
      {
        paramd = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.h, paramInt, i, d);
        if (paramd == null)
        {
          localObject = locald;
          if (paramd == null) {
            continue;
          }
          paramd.close();
          return null;
        }
        localObject = paramd;
        paramd.moveToFirst();
        localObject = paramd;
        if (paramd.getCount() > 0)
        {
          localObject = paramd;
          String str = paramd.getString(paramd.getColumnIndex("_data"));
          localObject = paramd;
          if (new File(str).exists())
          {
            localObject = paramd;
            locald = b(new FileInputStream(str), a(str));
            localObject = locald;
            if (paramd == null) {
              continue;
            }
            paramd.close();
            return locald;
          }
        }
        localObject = locald;
        if (paramd == null) {
          continue;
        }
        paramd.close();
        return null;
      }
      finally
      {
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
  }
  
  private static int b(com.facebook.imagepipeline.e.d paramd)
  {
    if (aw.a(f.width(), f.height(), paramd)) {
      return 3;
    }
    if (aw.a(e.width(), e.height(), paramd)) {
      return 1;
    }
    return 0;
  }
  
  private static int b(String paramString)
  {
    int i = 0;
    if (paramString != null) {}
    try
    {
      i = b.a(new ExifInterface(paramString).getAttributeInt("Orientation", 1));
      return i;
    }
    catch (IOException localIOException)
    {
      a.e(b, localIOException, "Unable to retrieve thumbnail rotation for %s", new Object[] { paramString });
    }
    return 0;
  }
  
  protected com.facebook.imagepipeline.i.d a(c paramc)
    throws IOException
  {
    Uri localUri = paramc.b();
    if (g.e(localUri))
    {
      paramc = a(localUri, paramc.e());
      if (paramc != null) {
        return paramc;
      }
    }
    return null;
  }
  
  protected String a()
  {
    return "LocalContentUriThumbnailFetchProducer";
  }
  
  public boolean a(com.facebook.imagepipeline.e.d paramd)
  {
    return aw.a(e.width(), e.height(), paramd);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/imagepipeline/l/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */