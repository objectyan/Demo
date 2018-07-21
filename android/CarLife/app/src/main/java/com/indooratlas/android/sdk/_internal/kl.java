package com.indooratlas.android.sdk._internal;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class kl
  implements kh
{
  private byte[] a;
  private TreeMap<String, String> b = new TreeMap(String.CASE_INSENSITIVE_ORDER);
  
  public final void a(String paramString1, String paramString2)
  {
    this.b.put(paramString1, paramString2);
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }
  
  public final String b(String paramString)
  {
    String str = (String)this.b.get(paramString);
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    return paramString;
  }
  
  public final Iterator<String> b()
  {
    return Collections.unmodifiableSet(this.b.keySet()).iterator();
  }
  
  public final boolean c(String paramString)
  {
    return this.b.containsKey(paramString);
  }
  
  public final byte[] c()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/kl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */