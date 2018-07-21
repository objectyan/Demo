package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.m;
import com.facebook.imagepipeline.d.p;
import com.facebook.imagepipeline.i.b;
import java.util.concurrent.Executor;

public class f
{
  private Resources a;
  private com.facebook.drawee.b.a b;
  private com.facebook.imagepipeline.a.a.a c;
  private Executor d;
  private p<com.facebook.b.a.d, b> e;
  
  public f(Resources paramResources, com.facebook.drawee.b.a parama, com.facebook.imagepipeline.a.a.a parama1, Executor paramExecutor, p<com.facebook.b.a.d, b> paramp)
  {
    this.a = paramResources;
    this.b = parama;
    this.c = parama1;
    this.d = paramExecutor;
    this.e = paramp;
  }
  
  public c a(m<com.facebook.c.d<com.facebook.common.h.a<b>>> paramm, String paramString, com.facebook.b.a.d paramd, Object paramObject)
  {
    return new c(this.a, this.b, this.c, this.d, this.e, paramm, paramString, paramd, paramObject);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */