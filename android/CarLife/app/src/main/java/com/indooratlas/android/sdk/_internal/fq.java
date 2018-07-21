package com.indooratlas.android.sdk._internal;

import java.util.concurrent.TimeUnit;

public final class fq
{
  public static final fq a;
  public static final fq b;
  public final boolean c;
  public final boolean d;
  public final int e;
  public final boolean f;
  public final boolean g;
  public final boolean h;
  public final int i;
  public final int j;
  public final boolean k;
  String l;
  private final int m;
  private final boolean n;
  
  static
  {
    a locala = new a();
    locala.a = true;
    a = locala.a();
    locala = new a();
    locala.f = true;
    long l1 = TimeUnit.SECONDS.toSeconds(2147483647L);
    if (l1 > 2147483647L) {}
    for (int i1 = Integer.MAX_VALUE;; i1 = (int)l1)
    {
      locala.d = i1;
      b = locala.a();
      return;
    }
  }
  
  private fq(a parama)
  {
    this.c = parama.a;
    this.d = parama.b;
    this.e = parama.c;
    this.m = -1;
    this.f = false;
    this.g = false;
    this.h = false;
    this.i = parama.d;
    this.j = parama.e;
    this.k = parama.f;
    this.n = parama.g;
  }
  
  private fq(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt3, int paramInt4, boolean paramBoolean6, boolean paramBoolean7, String paramString)
  {
    this.c = paramBoolean1;
    this.d = paramBoolean2;
    this.e = paramInt1;
    this.m = paramInt2;
    this.f = paramBoolean3;
    this.g = paramBoolean4;
    this.h = paramBoolean5;
    this.i = paramInt3;
    this.j = paramInt4;
    this.k = paramBoolean6;
    this.n = paramBoolean7;
    this.l = paramString;
  }
  
  public static fq a(gd paramgd)
  {
    boolean bool5 = false;
    int i6 = -1;
    int i5 = -1;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool4 = false;
    int i4 = -1;
    int i3 = -1;
    boolean bool3 = false;
    boolean bool2 = false;
    int i1 = 1;
    int i13 = paramgd.a.length / 2;
    int i7 = 0;
    Object localObject1 = null;
    boolean bool1 = false;
    while (i7 < i13)
    {
      Object localObject2 = paramgd.a(i7);
      String str1 = paramgd.b(i7);
      int i8;
      if (((String)localObject2).equalsIgnoreCase("Cache-Control")) {
        if (localObject1 != null)
        {
          i1 = 0;
          i8 = 0;
        }
      }
      for (;;)
      {
        label92:
        localObject2 = localObject1;
        bool14 = bool5;
        i12 = i6;
        i11 = i5;
        bool13 = bool7;
        bool12 = bool6;
        bool11 = bool4;
        i10 = i4;
        i9 = i3;
        bool10 = bool3;
        bool9 = bool2;
        i2 = i1;
        bool8 = bool1;
        if (i8 >= str1.length()) {
          break label638;
        }
        i2 = hr.a(str1, i8, "=,;");
        String str2 = str1.substring(i8, i2).trim();
        if ((i2 == str1.length()) || (str1.charAt(i2) == ',') || (str1.charAt(i2) == ';'))
        {
          i2 += 1;
          localObject2 = null;
        }
        for (;;)
        {
          if (!"no-cache".equalsIgnoreCase(str2)) {
            break label376;
          }
          bool1 = true;
          i8 = i2;
          break label92;
          localObject1 = str1;
          break;
          if (!((String)localObject2).equalsIgnoreCase("Pragma")) {
            break label589;
          }
          i1 = 0;
          break;
          i2 += 1;
          while (i2 < str1.length())
          {
            i8 = str1.charAt(i2);
            if ((i8 != 32) && (i8 != 9)) {
              break;
            }
            i2 += 1;
          }
          if ((i2 < str1.length()) && (str1.charAt(i2) == '"'))
          {
            i2 += 1;
            i8 = hr.a(str1, i2, "\"");
            localObject2 = str1.substring(i2, i8);
            i2 = i8 + 1;
          }
          else
          {
            i8 = hr.a(str1, i2, ",;");
            localObject2 = str1.substring(i2, i8).trim();
            i2 = i8;
          }
        }
        label376:
        if ("no-store".equalsIgnoreCase(str2))
        {
          bool5 = true;
          i8 = i2;
        }
        else if ("max-age".equalsIgnoreCase(str2))
        {
          i6 = hr.a((String)localObject2, -1);
          i8 = i2;
        }
        else if ("s-maxage".equalsIgnoreCase(str2))
        {
          i5 = hr.a((String)localObject2, -1);
          i8 = i2;
        }
        else if ("private".equalsIgnoreCase(str2))
        {
          bool7 = true;
          i8 = i2;
        }
        else if ("public".equalsIgnoreCase(str2))
        {
          bool6 = true;
          i8 = i2;
        }
        else if ("must-revalidate".equalsIgnoreCase(str2))
        {
          bool4 = true;
          i8 = i2;
        }
        else if ("max-stale".equalsIgnoreCase(str2))
        {
          i4 = hr.a((String)localObject2, Integer.MAX_VALUE);
          i8 = i2;
        }
        else if ("min-fresh".equalsIgnoreCase(str2))
        {
          i3 = hr.a((String)localObject2, -1);
          i8 = i2;
        }
        else if ("only-if-cached".equalsIgnoreCase(str2))
        {
          bool3 = true;
          i8 = i2;
        }
        else
        {
          i8 = i2;
          if ("no-transform".equalsIgnoreCase(str2))
          {
            bool2 = true;
            i8 = i2;
          }
        }
      }
      label589:
      boolean bool8 = bool1;
      int i2 = i1;
      boolean bool9 = bool2;
      boolean bool10 = bool3;
      int i9 = i3;
      int i10 = i4;
      boolean bool11 = bool4;
      boolean bool12 = bool6;
      boolean bool13 = bool7;
      int i11 = i5;
      int i12 = i6;
      boolean bool14 = bool5;
      localObject2 = localObject1;
      label638:
      i7 += 1;
      bool1 = bool8;
      localObject1 = localObject2;
      bool5 = bool14;
      i6 = i12;
      i5 = i11;
      bool7 = bool13;
      bool6 = bool12;
      bool4 = bool11;
      i4 = i10;
      i3 = i9;
      bool3 = bool10;
      bool2 = bool9;
      i1 = i2;
    }
    if (i1 == 0) {}
    for (paramgd = null;; paramgd = (gd)localObject1) {
      return new fq(bool1, bool5, i6, i5, bool7, bool6, bool4, i4, i3, bool3, bool2, paramgd);
    }
  }
  
  public final String toString()
  {
    Object localObject = this.l;
    if (localObject != null) {
      return (String)localObject;
    }
    localObject = new StringBuilder();
    if (this.c) {
      ((StringBuilder)localObject).append("no-cache, ");
    }
    if (this.d) {
      ((StringBuilder)localObject).append("no-store, ");
    }
    if (this.e != -1) {
      ((StringBuilder)localObject).append("max-age=").append(this.e).append(", ");
    }
    if (this.m != -1) {
      ((StringBuilder)localObject).append("s-maxage=").append(this.m).append(", ");
    }
    if (this.f) {
      ((StringBuilder)localObject).append("private, ");
    }
    if (this.g) {
      ((StringBuilder)localObject).append("public, ");
    }
    if (this.h) {
      ((StringBuilder)localObject).append("must-revalidate, ");
    }
    if (this.i != -1) {
      ((StringBuilder)localObject).append("max-stale=").append(this.i).append(", ");
    }
    if (this.j != -1) {
      ((StringBuilder)localObject).append("min-fresh=").append(this.j).append(", ");
    }
    if (this.k) {
      ((StringBuilder)localObject).append("only-if-cached, ");
    }
    if (this.n) {
      ((StringBuilder)localObject).append("no-transform, ");
    }
    if (((StringBuilder)localObject).length() == 0) {}
    for (localObject = "";; localObject = ((StringBuilder)localObject).toString())
    {
      this.l = ((String)localObject);
      return (String)localObject;
      ((StringBuilder)localObject).delete(((StringBuilder)localObject).length() - 2, ((StringBuilder)localObject).length());
    }
  }
  
  public static final class a
  {
    boolean a;
    boolean b;
    int c = -1;
    int d = -1;
    int e = -1;
    boolean f;
    boolean g;
    
    public final fq a()
    {
      return new fq(this, (byte)0);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/fq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */