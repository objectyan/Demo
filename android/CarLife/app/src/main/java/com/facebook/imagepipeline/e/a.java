package com.facebook.imagepipeline.e;

import java.util.Locale;
import javax.annotation.concurrent.Immutable;

@Immutable
public class a
{
  private static final a h = b().h();
  public final int a;
  public final int b;
  public final boolean c;
  public final boolean d;
  public final boolean e;
  public final boolean f;
  public final boolean g;
  
  public a(b paramb)
  {
    this.a = paramb.a();
    this.b = paramb.b();
    this.c = paramb.c();
    this.d = paramb.d();
    this.e = paramb.e();
    this.f = paramb.f();
    this.g = paramb.g();
  }
  
  public static a a()
  {
    return h;
  }
  
  public static b b()
  {
    return new b();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (a)paramObject;
      if (this.b != ((a)paramObject).b) {
        return false;
      }
      if (this.c != ((a)paramObject).c) {
        return false;
      }
      if (this.d != ((a)paramObject).d) {
        return false;
      }
      if (this.e != ((a)paramObject).e) {
        return false;
      }
      if (this.f != ((a)paramObject).f) {
        return false;
      }
    } while (this.g == ((a)paramObject).g);
    return false;
  }
  
  public int hashCode()
  {
    int j = this.b;
    if (this.c) {}
    for (int i = 1;; i = 0) {
      return j * 31 + i;
    }
  }
  
  public String toString()
  {
    return String.format((Locale)null, "%d-%d-%b-%b-%b-%b-%b", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b), Boolean.valueOf(this.c), Boolean.valueOf(this.d), Boolean.valueOf(this.e), Boolean.valueOf(this.f), Boolean.valueOf(this.g) });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */