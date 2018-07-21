package com.indooratlas.android.sdk._internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class gd
{
  public final String[] a;
  
  private gd(a parama)
  {
    this.a = ((String[])parama.a.toArray(new String[parama.a.size()]));
  }
  
  public final a a()
  {
    a locala = new a();
    Collections.addAll(locala.a, this.a);
    return locala;
  }
  
  public final String a(int paramInt)
  {
    return this.a[(paramInt * 2)];
  }
  
  public final String a(String paramString)
  {
    String[] arrayOfString = this.a;
    int i = arrayOfString.length - 2;
    while (i >= 0)
    {
      if (paramString.equalsIgnoreCase(arrayOfString[i])) {
        return arrayOfString[(i + 1)];
      }
      i -= 2;
    }
    return null;
  }
  
  public final String b(int paramInt)
  {
    return this.a[(paramInt * 2 + 1)];
  }
  
  public final Date b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return hu.a(paramString);
    }
    return null;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = this.a.length / 2;
    while (i < j)
    {
      localStringBuilder.append(a(i)).append(": ").append(b(i)).append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    final List<String> a = new ArrayList(20);
    
    private static void d(String paramString1, String paramString2)
    {
      if (paramString1 == null) {
        throw new IllegalArgumentException("name == null");
      }
      if (paramString1.isEmpty()) {
        throw new IllegalArgumentException("name is empty");
      }
      int j = paramString1.length();
      int i = 0;
      int k;
      while (i < j)
      {
        k = paramString1.charAt(i);
        if ((k <= 31) || (k >= 127)) {
          throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString1 }));
        }
        i += 1;
      }
      if (paramString2 == null) {
        throw new IllegalArgumentException("value == null");
      }
      j = paramString2.length();
      i = 0;
      while (i < j)
      {
        k = paramString2.charAt(i);
        if ((k <= 31) || (k >= 127)) {
          throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in %s value: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString1, paramString2 }));
        }
        i += 1;
      }
    }
    
    public final a a(String paramString)
    {
      int j;
      for (int i = 0; i < this.a.size(); i = j + 2)
      {
        j = i;
        if (paramString.equalsIgnoreCase((String)this.a.get(i)))
        {
          this.a.remove(i);
          this.a.remove(i);
          j = i - 2;
        }
      }
      return this;
    }
    
    public final a a(String paramString1, String paramString2)
    {
      d(paramString1, paramString2);
      return b(paramString1, paramString2);
    }
    
    public final gd a()
    {
      return new gd(this, (byte)0);
    }
    
    final a b(String paramString1, String paramString2)
    {
      this.a.add(paramString1);
      this.a.add(paramString2.trim());
      return this;
    }
    
    public final a c(String paramString1, String paramString2)
    {
      d(paramString1, paramString2);
      a(paramString1);
      b(paramString1, paramString2);
      return this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/gd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */