package com.facebook.imagepipeline.l;

import android.util.Pair;
import com.facebook.b.a.d;
import com.facebook.common.h.a;
import com.facebook.imagepipeline.d.f;
import com.facebook.imagepipeline.i.b;
import com.facebook.imagepipeline.m.c.b;

public class g
  extends ac<Pair<d, c.b>, a<b>>
{
  private final f b;
  
  public g(f paramf, ai paramai)
  {
    super(paramai);
    this.b = paramf;
  }
  
  protected Pair<d, c.b> a(aj paramaj)
  {
    return Pair.create(this.b.a(paramaj.a(), paramaj.d()), paramaj.e());
  }
  
  public a<b> a(a<b> parama)
  {
    return a.b(parama);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */