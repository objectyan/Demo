package com.facebook.imagepipeline.h;

import android.graphics.Bitmap.Config;
import com.facebook.imagepipeline.i.f;
import com.facebook.imagepipeline.i.g;
import com.facebook.imagepipeline.k.e;
import java.io.InputStream;

public class b
{
  private final com.facebook.imagepipeline.a.a.d a;
  private final Bitmap.Config b;
  private final e c;
  
  public b(com.facebook.imagepipeline.a.a.d paramd, e parame, Bitmap.Config paramConfig)
  {
    this.a = paramd;
    this.b = paramConfig;
    this.c = parame;
  }
  
  public com.facebook.imagepipeline.i.b a(com.facebook.imagepipeline.i.d paramd, int paramInt, g paramg, com.facebook.imagepipeline.e.a parama)
  {
    com.facebook.f.b localb2 = paramd.e();
    com.facebook.f.b localb1;
    if (localb2 != null)
    {
      localb1 = localb2;
      if (localb2 != com.facebook.f.b.j) {}
    }
    else
    {
      localb1 = com.facebook.f.c.b(paramd.d());
    }
    switch (1.a[localb1.ordinal()])
    {
    default: 
      return a(paramd);
    case 1: 
      throw new IllegalArgumentException("unknown image format");
    case 2: 
      return a(paramd, paramInt, paramg);
    case 3: 
      return a(paramd, parama);
    }
    return b(paramd, parama);
  }
  
  public com.facebook.imagepipeline.i.b a(com.facebook.imagepipeline.i.d paramd, com.facebook.imagepipeline.e.a parama)
  {
    InputStream localInputStream = paramd.d();
    if (localInputStream == null) {
      return null;
    }
    try
    {
      if ((!parama.g) && (this.a != null) && (com.facebook.f.a.a(localInputStream)))
      {
        paramd = this.a.a(paramd, parama, this.b);
        return paramd;
      }
      paramd = a(paramd);
      return paramd;
    }
    finally
    {
      com.facebook.common.internal.c.a(localInputStream);
    }
  }
  
  public com.facebook.imagepipeline.i.c a(com.facebook.imagepipeline.i.d paramd)
  {
    com.facebook.common.h.a locala = this.c.a(paramd, this.b);
    try
    {
      paramd = new com.facebook.imagepipeline.i.c(locala, f.a, paramd.f());
      return paramd;
    }
    finally
    {
      locala.close();
    }
  }
  
  public com.facebook.imagepipeline.i.c a(com.facebook.imagepipeline.i.d paramd, int paramInt, g paramg)
  {
    com.facebook.common.h.a locala = this.c.a(paramd, this.b, paramInt);
    try
    {
      paramd = new com.facebook.imagepipeline.i.c(locala, paramg, paramd.f());
      return paramd;
    }
    finally
    {
      locala.close();
    }
  }
  
  public com.facebook.imagepipeline.i.b b(com.facebook.imagepipeline.i.d paramd, com.facebook.imagepipeline.e.a parama)
  {
    return this.a.b(paramd, parama, this.b);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/h/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */