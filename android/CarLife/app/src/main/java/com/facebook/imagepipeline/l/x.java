package com.facebook.imagepipeline.l;

import android.content.ContentResolver;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.Pair;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.m.c;
import com.facebook.imagepipeline.memory.aa;
import com.facebook.imagepipeline.memory.y;
import com.facebook.imagepipeline.memory.z;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;

public class x
  implements av<com.facebook.imagepipeline.i.d>
{
  @VisibleForTesting
  static final String a = "LocalExifThumbnailProducer";
  @VisibleForTesting
  static final String b = "createdThumbnail";
  private static final int c = 512;
  private final Executor d;
  private final z e;
  private final ContentResolver f;
  
  public x(Executor paramExecutor, z paramz, ContentResolver paramContentResolver)
  {
    this.d = paramExecutor;
    this.e = paramz;
    this.f = paramContentResolver;
  }
  
  private int a(ExifInterface paramExifInterface)
  {
    return com.facebook.h.b.a(Integer.parseInt(paramExifInterface.getAttribute("Orientation")));
  }
  
  private com.facebook.imagepipeline.i.d a(y paramy, ExifInterface paramExifInterface)
  {
    int j = -1;
    Pair localPair = com.facebook.h.a.a(new aa(paramy));
    int k = a(paramExifInterface);
    if (localPair != null) {}
    for (int i = ((Integer)localPair.first).intValue();; i = -1)
    {
      if (localPair != null) {
        j = ((Integer)localPair.second).intValue();
      }
      paramy = com.facebook.common.h.a.a(paramy);
      try
      {
        paramExifInterface = new com.facebook.imagepipeline.i.d(paramy);
        com.facebook.common.h.a.c(paramy);
        paramExifInterface.a(com.facebook.f.b.f);
        paramExifInterface.c(k);
        paramExifInterface.b(i);
        return paramExifInterface;
      }
      finally
      {
        com.facebook.common.h.a.c(paramy);
      }
    }
  }
  
  @VisibleForTesting
  ExifInterface a(Uri paramUri)
    throws IOException
  {
    paramUri = com.facebook.common.m.g.a(this.f, paramUri);
    if (a(paramUri)) {
      return new ExifInterface(paramUri);
    }
    return null;
  }
  
  public void a(final j<com.facebook.imagepipeline.i.d> paramj, aj paramaj)
  {
    paramj = new ap(paramj, paramaj.c(), "LocalExifThumbnailProducer", paramaj.b())
    {
      protected void a(com.facebook.imagepipeline.i.d paramAnonymousd)
      {
        com.facebook.imagepipeline.i.d.d(paramAnonymousd);
      }
      
      protected Map<String, String> b(com.facebook.imagepipeline.i.d paramAnonymousd)
      {
        if (paramAnonymousd != null) {}
        for (boolean bool = true;; bool = false) {
          return com.facebook.common.internal.g.a("createdThumbnail", Boolean.toString(bool));
        }
      }
      
      protected com.facebook.imagepipeline.i.d d()
        throws Exception
      {
        Object localObject1 = this.g.b();
        localObject1 = x.this.a((Uri)localObject1);
        if ((localObject1 == null) || (!((ExifInterface)localObject1).hasThumbnail())) {
          return null;
        }
        Object localObject2 = ((ExifInterface)localObject1).getThumbnail();
        localObject2 = x.a(x.this).b((byte[])localObject2);
        return x.a(x.this, (y)localObject2, (ExifInterface)localObject1);
      }
    };
    paramaj.a(new e()
    {
      public void a()
      {
        paramj.a();
      }
    });
    this.d.execute(paramj);
  }
  
  public boolean a(com.facebook.imagepipeline.e.d paramd)
  {
    return aw.a(512, 512, paramd);
  }
  
  @VisibleForTesting
  boolean a(String paramString)
    throws IOException
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (!paramString.canRead()));
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */