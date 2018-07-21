package b;

import b.a.d.e;
import java.util.concurrent.TimeUnit;

public final class d
{
  public static final d a = new a().a().e();
  public static final d b = new a().c().b(Integer.MAX_VALUE, TimeUnit.SECONDS).e();
  String c;
  private final boolean d;
  private final boolean e;
  private final int f;
  private final int g;
  private final boolean h;
  private final boolean i;
  private final boolean j;
  private final int k;
  private final int l;
  private final boolean m;
  private final boolean n;
  
  d(a parama)
  {
    this.d = parama.a;
    this.e = parama.b;
    this.f = parama.c;
    this.g = -1;
    this.h = false;
    this.i = false;
    this.j = false;
    this.k = parama.d;
    this.l = parama.e;
    this.m = parama.f;
    this.n = parama.g;
  }
  
  private d(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt3, int paramInt4, boolean paramBoolean6, boolean paramBoolean7, String paramString)
  {
    this.d = paramBoolean1;
    this.e = paramBoolean2;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramBoolean3;
    this.i = paramBoolean4;
    this.j = paramBoolean5;
    this.k = paramInt3;
    this.l = paramInt4;
    this.m = paramBoolean6;
    this.n = paramBoolean7;
    this.c = paramString;
  }
  
  public static d a(t paramt)
  {
    boolean bool7 = false;
    boolean bool6 = false;
    int i6 = -1;
    int i5 = -1;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    int i4 = -1;
    int i3 = -1;
    boolean bool2 = false;
    boolean bool1 = false;
    int i1 = 1;
    Object localObject1 = null;
    int i7 = 0;
    int i13 = paramt.a();
    while (i7 < i13)
    {
      String str2 = paramt.a(i7);
      String str1 = paramt.b(i7);
      int i8;
      if (str2.equalsIgnoreCase("Cache-Control")) {
        if (localObject1 != null)
        {
          i1 = 0;
          i8 = 0;
        }
      }
      label89:
      boolean bool8;
      boolean bool9;
      int i2;
      int i9;
      boolean bool10;
      boolean bool11;
      boolean bool12;
      int i10;
      int i11;
      boolean bool13;
      boolean bool14;
      Object localObject2;
      int i12;
      for (;;)
      {
        bool8 = bool7;
        bool9 = bool6;
        i2 = i6;
        i9 = i5;
        bool10 = bool5;
        bool11 = bool4;
        bool12 = bool3;
        i10 = i4;
        i11 = i3;
        bool13 = bool2;
        bool14 = bool1;
        localObject2 = localObject1;
        i12 = i1;
        if (i8 >= str1.length()) {
          break label603;
        }
        i2 = e.a(str1, i8, "=,;");
        str2 = str1.substring(i8, i2).trim();
        if ((i2 == str1.length()) || (str1.charAt(i2) == ',') || (str1.charAt(i2) == ';'))
        {
          i2 += 1;
          localObject2 = null;
        }
        for (;;)
        {
          if (!"no-cache".equalsIgnoreCase(str2)) {
            break label390;
          }
          bool7 = true;
          i8 = i2;
          break label89;
          localObject1 = str1;
          break;
          bool8 = bool7;
          bool9 = bool6;
          i2 = i6;
          i9 = i5;
          bool10 = bool5;
          bool11 = bool4;
          bool12 = bool3;
          i10 = i4;
          i11 = i3;
          bool13 = bool2;
          bool14 = bool1;
          localObject2 = localObject1;
          i12 = i1;
          if (!str2.equalsIgnoreCase("Pragma")) {
            break label603;
          }
          i1 = 0;
          break;
          i8 = e.a(str1, i2 + 1);
          if ((i8 < str1.length()) && (str1.charAt(i8) == '"'))
          {
            i2 = i8 + 1;
            i8 = e.a(str1, i2, "\"");
            localObject2 = str1.substring(i2, i8);
            i2 = i8 + 1;
          }
          else
          {
            i2 = e.a(str1, i8, ",;");
            localObject2 = str1.substring(i8, i2).trim();
          }
        }
        label390:
        if ("no-store".equalsIgnoreCase(str2))
        {
          bool6 = true;
          i8 = i2;
        }
        else if ("max-age".equalsIgnoreCase(str2))
        {
          i6 = e.b((String)localObject2, -1);
          i8 = i2;
        }
        else if ("s-maxage".equalsIgnoreCase(str2))
        {
          i5 = e.b((String)localObject2, -1);
          i8 = i2;
        }
        else if ("private".equalsIgnoreCase(str2))
        {
          bool5 = true;
          i8 = i2;
        }
        else if ("public".equalsIgnoreCase(str2))
        {
          bool4 = true;
          i8 = i2;
        }
        else if ("must-revalidate".equalsIgnoreCase(str2))
        {
          bool3 = true;
          i8 = i2;
        }
        else if ("max-stale".equalsIgnoreCase(str2))
        {
          i4 = e.b((String)localObject2, Integer.MAX_VALUE);
          i8 = i2;
        }
        else if ("min-fresh".equalsIgnoreCase(str2))
        {
          i3 = e.b((String)localObject2, -1);
          i8 = i2;
        }
        else if ("only-if-cached".equalsIgnoreCase(str2))
        {
          bool2 = true;
          i8 = i2;
        }
        else
        {
          i8 = i2;
          if ("no-transform".equalsIgnoreCase(str2))
          {
            bool1 = true;
            i8 = i2;
          }
        }
      }
      label603:
      i7 += 1;
      bool7 = bool8;
      bool6 = bool9;
      i6 = i2;
      i5 = i9;
      bool5 = bool10;
      bool4 = bool11;
      bool3 = bool12;
      i4 = i10;
      i3 = i11;
      bool2 = bool13;
      bool1 = bool14;
      localObject1 = localObject2;
      i1 = i12;
    }
    if (i1 == 0) {
      localObject1 = null;
    }
    return new d(bool7, bool6, i6, i5, bool5, bool4, bool3, i4, i3, bool2, bool1, (String)localObject1);
  }
  
  private String l()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.d) {
      localStringBuilder.append("no-cache, ");
    }
    if (this.e) {
      localStringBuilder.append("no-store, ");
    }
    if (this.f != -1) {
      localStringBuilder.append("max-age=").append(this.f).append(", ");
    }
    if (this.g != -1) {
      localStringBuilder.append("s-maxage=").append(this.g).append(", ");
    }
    if (this.h) {
      localStringBuilder.append("private, ");
    }
    if (this.i) {
      localStringBuilder.append("public, ");
    }
    if (this.j) {
      localStringBuilder.append("must-revalidate, ");
    }
    if (this.k != -1) {
      localStringBuilder.append("max-stale=").append(this.k).append(", ");
    }
    if (this.l != -1) {
      localStringBuilder.append("min-fresh=").append(this.l).append(", ");
    }
    if (this.m) {
      localStringBuilder.append("only-if-cached, ");
    }
    if (this.n) {
      localStringBuilder.append("no-transform, ");
    }
    if (localStringBuilder.length() == 0) {
      return "";
    }
    localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
    return localStringBuilder.toString();
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public int d()
  {
    return this.g;
  }
  
  public boolean e()
  {
    return this.h;
  }
  
  public boolean f()
  {
    return this.i;
  }
  
  public boolean g()
  {
    return this.j;
  }
  
  public int h()
  {
    return this.k;
  }
  
  public int i()
  {
    return this.l;
  }
  
  public boolean j()
  {
    return this.m;
  }
  
  public boolean k()
  {
    return this.n;
  }
  
  public String toString()
  {
    String str = this.c;
    if (str != null) {
      return str;
    }
    str = l();
    this.c = str;
    return str;
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
    
    public a a()
    {
      this.a = true;
      return this;
    }
    
    public a a(int paramInt, TimeUnit paramTimeUnit)
    {
      if (paramInt < 0) {
        throw new IllegalArgumentException("maxAge < 0: " + paramInt);
      }
      long l = paramTimeUnit.toSeconds(paramInt);
      if (l > 2147483647L) {}
      for (paramInt = Integer.MAX_VALUE;; paramInt = (int)l)
      {
        this.c = paramInt;
        return this;
      }
    }
    
    public a b()
    {
      this.b = true;
      return this;
    }
    
    public a b(int paramInt, TimeUnit paramTimeUnit)
    {
      if (paramInt < 0) {
        throw new IllegalArgumentException("maxStale < 0: " + paramInt);
      }
      long l = paramTimeUnit.toSeconds(paramInt);
      if (l > 2147483647L) {}
      for (paramInt = Integer.MAX_VALUE;; paramInt = (int)l)
      {
        this.d = paramInt;
        return this;
      }
    }
    
    public a c()
    {
      this.f = true;
      return this;
    }
    
    public a c(int paramInt, TimeUnit paramTimeUnit)
    {
      if (paramInt < 0) {
        throw new IllegalArgumentException("minFresh < 0: " + paramInt);
      }
      long l = paramTimeUnit.toSeconds(paramInt);
      if (l > 2147483647L) {}
      for (paramInt = Integer.MAX_VALUE;; paramInt = (int)l)
      {
        this.e = paramInt;
        return this;
      }
    }
    
    public a d()
    {
      this.g = true;
      return this;
    }
    
    public d e()
    {
      return new d(this);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */