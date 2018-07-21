package com.facebook.imagepipeline.d;

import android.net.Uri;
import com.facebook.common.internal.j;
import com.facebook.common.internal.k;
import com.facebook.common.l.e;
import com.facebook.common.m.b;
import com.facebook.imagepipeline.e.a;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public class c
  implements com.facebook.b.a.d
{
  private final String a;
  @Nullable
  private final com.facebook.imagepipeline.e.d b;
  private final boolean c;
  private final a d;
  @Nullable
  private final com.facebook.b.a.d e;
  @Nullable
  private final String f;
  private final int g;
  private final Object h;
  private final long i;
  
  public c(String paramString1, @Nullable com.facebook.imagepipeline.e.d paramd, boolean paramBoolean, a parama, @Nullable com.facebook.b.a.d paramd1, @Nullable String paramString2, Object paramObject)
  {
    this.a = ((String)k.a(paramString1));
    this.b = paramd;
    this.c = paramBoolean;
    this.d = parama;
    this.e = paramd1;
    this.f = paramString2;
    int m = paramString1.hashCode();
    int j;
    if (paramd != null)
    {
      j = paramd.hashCode();
      if (!paramBoolean) {
        break label126;
      }
    }
    label126:
    for (int k = Boolean.TRUE.hashCode();; k = Boolean.FALSE.hashCode())
    {
      this.g = b.a(Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k), this.d, this.e, paramString2);
      this.h = paramObject;
      this.i = e.a().b();
      return;
      j = 0;
      break;
    }
  }
  
  public String a()
  {
    return this.a;
  }
  
  public boolean a(Uri paramUri)
  {
    return a().contains(paramUri.toString());
  }
  
  @Nullable
  public String b()
  {
    return this.f;
  }
  
  public Object c()
  {
    return this.h;
  }
  
  public long d()
  {
    return this.i;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof c)) {}
    do
    {
      return false;
      paramObject = (c)paramObject;
    } while ((this.g != ((c)paramObject).g) || (!this.a.equals(((c)paramObject).a)) || (!j.a(this.b, ((c)paramObject).b)) || (this.c != ((c)paramObject).c) || (!j.a(this.d, ((c)paramObject).d)) || (!j.a(this.e, ((c)paramObject).e)) || (!j.a(this.f, ((c)paramObject).f)));
    return true;
  }
  
  public int hashCode()
  {
    return this.g;
  }
  
  public String toString()
  {
    return String.format((Locale)null, "%s_%s_%s_%s_%s_%s_%d", new Object[] { this.a, this.b, Boolean.toString(this.c), this.d, this.e, this.f, Integer.valueOf(this.g) });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/imagepipeline/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */