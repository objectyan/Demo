package b.a.f;

public enum b
{
  public final int g;
  
  private b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public static b a(int paramInt)
  {
    b[] arrayOfb = values();
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b localb = arrayOfb[i];
      if (localb.g == paramInt) {
        return localb;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */