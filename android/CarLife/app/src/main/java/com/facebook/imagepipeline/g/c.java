package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import com.facebook.c.d;
import com.facebook.imagepipeline.i.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class c
  extends com.facebook.c.c<List<com.facebook.common.h.a<b>>>
{
  protected abstract void a(List<Bitmap> paramList);
  
  public void e(d<List<com.facebook.common.h.a<b>>> paramd)
  {
    if (!paramd.b()) {
      return;
    }
    paramd = (List)paramd.d();
    if (paramd == null)
    {
      a(null);
      return;
    }
    try
    {
      ArrayList localArrayList = new ArrayList(paramd.size());
      Iterator localIterator = paramd.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label151;
        }
        com.facebook.common.h.a locala = (com.facebook.common.h.a)localIterator.next();
        if ((locala == null) || (!(locala.a() instanceof com.facebook.imagepipeline.i.a))) {
          break;
        }
        localArrayList.add(((com.facebook.imagepipeline.i.a)locala.a()).a());
      }
    }
    finally
    {
      for (;;)
      {
        paramd = paramd.iterator();
        while (paramd.hasNext()) {
          com.facebook.common.h.a.c((com.facebook.common.h.a)paramd.next());
        }
        localList.add(null);
      }
      label151:
      a(localList);
      paramd = paramd.iterator();
      while (paramd.hasNext()) {
        com.facebook.common.h.a.c((com.facebook.common.h.a)paramd.next());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/g/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */