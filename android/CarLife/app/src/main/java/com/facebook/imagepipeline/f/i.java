package com.facebook.imagepipeline.f;

import com.facebook.common.n.b;

public class i
{
  private final int a;
  private final boolean b;
  private boolean c;
  private final int d;
  
  private i(a parama, h.a parama1)
  {
    this.a = a.a(parama);
    if ((a.b(parama)) && (b.e))
    {
      bool1 = true;
      this.b = bool1;
      if ((!parama1.a()) || (!a.c(parama))) {
        break label71;
      }
    }
    label71:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.c = bool1;
      this.d = a.d(parama);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static a a(h.a parama)
  {
    return new a(parama);
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public boolean c()
  {
    return this.b;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public static class a
  {
    private static final int a = 5;
    private final h.a b;
    private int c = 0;
    private boolean d = false;
    private boolean e = false;
    private int f = 5;
    
    public a(h.a parama)
    {
      this.b = parama;
    }
    
    public h.a a(int paramInt)
    {
      this.c = paramInt;
      return this.b;
    }
    
    public h.a a(boolean paramBoolean)
    {
      this.e = paramBoolean;
      return this.b;
    }
    
    public i a()
    {
      return new i(this, this.b, null);
    }
    
    public h.a b(int paramInt)
    {
      this.f = paramInt;
      return this.b;
    }
    
    public h.a b(boolean paramBoolean)
    {
      this.d = paramBoolean;
      return this.b;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/f/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */