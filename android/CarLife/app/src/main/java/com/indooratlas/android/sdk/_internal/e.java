package com.indooratlas.android.sdk._internal;

public final class e
  implements Cloneable
{
  static final f a = new f();
  boolean b = false;
  int[] c;
  f[] d;
  int e;
  
  e()
  {
    this(10);
  }
  
  private e(int paramInt)
  {
    paramInt = b(paramInt);
    this.c = new int[paramInt];
    this.d = new f[paramInt];
    this.e = 0;
  }
  
  static int b(int paramInt)
  {
    int j = paramInt * 4;
    paramInt = 4;
    for (;;)
    {
      int i = j;
      if (paramInt < 32)
      {
        if (j <= (1 << paramInt) - 12) {
          i = (1 << paramInt) - 12;
        }
      }
      else {
        return i / 4;
      }
      paramInt += 1;
    }
  }
  
  final f a(int paramInt)
  {
    if (this.b) {
      a();
    }
    return this.d[paramInt];
  }
  
  final void a()
  {
    int m = this.e;
    int[] arrayOfInt = this.c;
    f[] arrayOff = this.d;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      f localf = arrayOff[i];
      k = j;
      if (localf != a)
      {
        if (i != j)
        {
          arrayOfInt[j] = arrayOfInt[i];
          arrayOff[j] = localf;
          arrayOff[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    this.b = false;
    this.e = j;
  }
  
  final int b()
  {
    if (this.b) {
      a();
    }
    return this.e;
  }
  
  final int c(int paramInt)
  {
    int j = this.e;
    int i = 0;
    j -= 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = this.c[k];
      if (m < paramInt)
      {
        i = k + 1;
      }
      else
      {
        j = k;
        if (m <= paramInt) {
          return j;
        }
        j = k - 1;
      }
    }
    j = i ^ 0xFFFFFFFF;
    return j;
  }
  
  public final e c()
  {
    int i = 0;
    int j = b();
    e locale = new e(j);
    System.arraycopy(this.c, 0, locale.c, 0, j);
    while (i < j)
    {
      if (this.d[i] != null) {
        locale.d[i] = this.d[i].b();
      }
      i += 1;
    }
    locale.e = j;
    return locale;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    label71:
    label93:
    label131:
    label138:
    label141:
    for (;;)
    {
      return true;
      if (!(paramObject instanceof e)) {
        return false;
      }
      paramObject = (e)paramObject;
      if (b() != ((e)paramObject).b()) {
        return false;
      }
      Object localObject = this.c;
      int[] arrayOfInt = ((e)paramObject).c;
      int j = this.e;
      int i = 0;
      if (i < j) {
        if (localObject[i] != arrayOfInt[i])
        {
          i = 0;
          if (i != 0)
          {
            localObject = this.d;
            paramObject = ((e)paramObject).d;
            j = this.e;
            i = 0;
            if (i >= j) {
              break label138;
            }
            if (localObject[i].equals(paramObject[i])) {
              break label131;
            }
          }
        }
      }
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label141;
        }
        return false;
        i += 1;
        break;
        i = 1;
        break label71;
        i += 1;
        break label93;
      }
    }
  }
  
  public final int hashCode()
  {
    if (this.b) {
      a();
    }
    int j = 17;
    int i = 0;
    while (i < this.e)
    {
      j = (j * 31 + this.c[i]) * 31 + this.d[i].hashCode();
      i += 1;
    }
    return j;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */