package com.facebook.imagepipeline.l;

import android.net.Uri;
import com.facebook.imagepipeline.i.d;
import com.facebook.imagepipeline.m.c;

public class r
{
  private final j<d> a;
  private final aj b;
  private long c;
  
  public r(j<d> paramj, aj paramaj)
  {
    this.a = paramj;
    this.b = paramaj;
    this.c = 0L;
  }
  
  public j<d> a()
  {
    return this.a;
  }
  
  public void a(long paramLong)
  {
    this.c = paramLong;
  }
  
  public aj b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.b.b();
  }
  
  public al d()
  {
    return this.b.c();
  }
  
  public Uri e()
  {
    return this.b.a().b();
  }
  
  public long f()
  {
    return this.c;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */