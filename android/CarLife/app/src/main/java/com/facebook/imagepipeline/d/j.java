package com.facebook.imagepipeline.d;

import android.net.Uri;
import com.facebook.b.a.d;
import com.facebook.b.a.i;
import com.facebook.imagepipeline.m.e;
import javax.annotation.Nullable;

public class j
  implements f
{
  private static j a = null;
  
  public static j a()
  {
    try
    {
      if (a == null) {
        a = new j();
      }
      j localj = a;
      return localj;
    }
    finally {}
  }
  
  protected Uri a(Uri paramUri)
  {
    return paramUri;
  }
  
  public d a(com.facebook.imagepipeline.m.c paramc, Object paramObject)
  {
    return new c(a(paramc.b()).toString(), paramc.e(), paramc.g(), paramc.f(), null, null, paramObject);
  }
  
  public d b(com.facebook.imagepipeline.m.c paramc, Object paramObject)
  {
    Object localObject = paramc.n();
    d locald;
    if (localObject != null) {
      locald = ((e)localObject).b();
    }
    for (localObject = localObject.getClass().getName();; localObject = null)
    {
      return new c(a(paramc.b()).toString(), paramc.e(), paramc.g(), paramc.f(), locald, (String)localObject, paramObject);
      locald = null;
    }
  }
  
  public d c(com.facebook.imagepipeline.m.c paramc, @Nullable Object paramObject)
  {
    return new i(a(paramc.b()).toString());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/d/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */