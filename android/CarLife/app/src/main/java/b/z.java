package b;

import java.io.IOException;

public enum z
{
  private final String e;
  
  private z(String paramString)
  {
    this.e = paramString;
  }
  
  public static z a(String paramString)
    throws IOException
  {
    if (paramString.equals(a.e)) {
      return a;
    }
    if (paramString.equals(b.e)) {
      return b;
    }
    if (paramString.equals(d.e)) {
      return d;
    }
    if (paramString.equals(c.e)) {
      return c;
    }
    throw new IOException("Unexpected protocol: " + paramString);
  }
  
  public String toString()
  {
    return this.e;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */