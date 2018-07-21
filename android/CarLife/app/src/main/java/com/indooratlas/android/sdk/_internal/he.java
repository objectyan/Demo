package com.indooratlas.android.sdk._internal;

public final class he
{
  public static final iq a = iq.a(":status");
  public static final iq b = iq.a(":method");
  public static final iq c = iq.a(":path");
  public static final iq d = iq.a(":scheme");
  public static final iq e = iq.a(":authority");
  public static final iq f = iq.a(":host");
  public static final iq g = iq.a(":version");
  public final iq h;
  public final iq i;
  final int j;
  
  public he(iq paramiq1, iq paramiq2)
  {
    this.h = paramiq1;
    this.i = paramiq2;
    this.j = (paramiq1.c.length + 32 + paramiq2.c.length);
  }
  
  public he(iq paramiq, String paramString)
  {
    this(paramiq, iq.a(paramString));
  }
  
  public he(String paramString1, String paramString2)
  {
    this(iq.a(paramString1), iq.a(paramString2));
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof he))
    {
      paramObject = (he)paramObject;
      bool1 = bool2;
      if (this.h.equals(((he)paramObject).h))
      {
        bool1 = bool2;
        if (this.i.equals(((he)paramObject).i)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return (this.h.hashCode() + 527) * 31 + this.i.hashCode();
  }
  
  public final String toString()
  {
    return String.format("%s: %s", new Object[] { this.h.a(), this.i.a() });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/he.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */