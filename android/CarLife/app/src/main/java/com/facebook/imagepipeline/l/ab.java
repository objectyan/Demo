package com.facebook.imagepipeline.l;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import com.facebook.common.h.a;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.i.b;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Executor;

public class ab
  implements ai<a<b>>
{
  @VisibleForTesting
  static final String a = "VideoThumbnailProducer";
  @VisibleForTesting
  static final String b = "createdThumbnail";
  private final Executor c;
  
  public ab(Executor paramExecutor)
  {
    this.c = paramExecutor;
  }
  
  private static int b(com.facebook.imagepipeline.m.c paramc)
  {
    if ((paramc.c() > 96) || (paramc.d() > 96)) {
      return 1;
    }
    return 3;
  }
  
  public void a(final j<a<b>> paramj, aj paramaj)
  {
    paramj = new ap(paramj, paramaj.c(), "VideoThumbnailProducer", paramaj.b())
    {
      protected Map<String, String> a(a<b> paramAnonymousa)
      {
        if (paramAnonymousa != null) {}
        for (boolean bool = true;; bool = false) {
          return g.a("createdThumbnail", String.valueOf(bool));
        }
      }
      
      protected void b(a<b> paramAnonymousa)
      {
        a.c(paramAnonymousa);
      }
      
      protected a<b> d()
        throws Exception
      {
        Bitmap localBitmap = ThumbnailUtils.createVideoThumbnail(this.g.m().getPath(), ab.a(this.g));
        if (localBitmap == null) {
          return null;
        }
        return a.a(new com.facebook.imagepipeline.i.c(localBitmap, com.facebook.imagepipeline.c.f.a(), com.facebook.imagepipeline.i.f.a, 0));
      }
    };
    paramaj.a(new e()
    {
      public void a()
      {
        paramj.a();
      }
    });
    this.c.execute(paramj);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */