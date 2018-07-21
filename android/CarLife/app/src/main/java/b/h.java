package b;

import b.a.c;

public final class h
{
  private final String a;
  private final String b;
  
  public h(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof h)) && (c.a(this.a, ((h)paramObject).a)) && (c.a(this.b, ((h)paramObject).b));
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.b != null) {}
    for (int i = this.b.hashCode();; i = 0)
    {
      if (this.a != null) {
        j = this.a.hashCode();
      }
      return (i + 899) * 31 + j;
    }
  }
  
  public String toString()
  {
    return this.a + " realm=\"" + this.b + "\"";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */