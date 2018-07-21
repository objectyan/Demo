package com.facebook.imagepipeline.l;

import android.util.Pair;
import com.facebook.imagepipeline.d.f;
import com.facebook.imagepipeline.m.c.b;

public class p
  extends ac<Pair<com.facebook.b.a.d, c.b>, com.facebook.imagepipeline.i.d>
{
  private final f b;
  
  public p(f paramf, ai paramai)
  {
    super(paramai);
    this.b = paramf;
  }
  
  protected Pair<com.facebook.b.a.d, c.b> a(aj paramaj)
  {
    return Pair.create(this.b.c(paramaj.a(), paramaj.d()), paramaj.e());
  }
  
  public com.facebook.imagepipeline.i.d a(com.facebook.imagepipeline.i.d paramd)
  {
    return com.facebook.imagepipeline.i.d.a(paramd);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */