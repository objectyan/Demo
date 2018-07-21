package com.facebook.b.b;

import com.facebook.a.a;
import com.facebook.b.a.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract interface d
{
  public abstract long a(c paramc)
    throws IOException;
  
  public abstract d a(String paramString, Object paramObject)
    throws IOException;
  
  public abstract boolean a();
  
  public abstract long b(String paramString)
    throws IOException;
  
  public abstract a b(String paramString, Object paramObject)
    throws IOException;
  
  public abstract String b();
  
  public abstract void c();
  
  public abstract boolean c(String paramString, Object paramObject)
    throws IOException;
  
  public abstract void d()
    throws IOException;
  
  public abstract boolean d(String paramString, Object paramObject)
    throws IOException;
  
  public abstract a e()
    throws IOException;
  
  public abstract Collection<c> g()
    throws IOException;
  
  public static class a
  {
    public List<d.b> a = new ArrayList();
    public Map<String, Integer> b = new HashMap();
  }
  
  public static class b
  {
    public final String a;
    public final String b;
    public final float c;
    public final String d;
    
    protected b(String paramString1, String paramString2, float paramFloat, String paramString3)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramFloat;
      this.d = paramString3;
    }
  }
  
  public static abstract interface c
  {
    public abstract String a();
    
    public abstract long b();
    
    public abstract long d();
    
    public abstract a e();
  }
  
  public static abstract interface d
  {
    public abstract a a(Object paramObject)
      throws IOException;
    
    public abstract void a(j paramj, Object paramObject)
      throws IOException;
    
    public abstract boolean a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/b/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */