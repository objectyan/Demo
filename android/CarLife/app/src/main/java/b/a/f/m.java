package b.a.f;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

public abstract interface m
{
  public static final m a = new m()
  {
    public void a(int paramAnonymousInt, b paramAnonymousb) {}
    
    public boolean a(int paramAnonymousInt, List<c> paramAnonymousList)
    {
      return true;
    }
    
    public boolean a(int paramAnonymousInt, List<c> paramAnonymousList, boolean paramAnonymousBoolean)
    {
      return true;
    }
    
    public boolean a(int paramAnonymousInt1, BufferedSource paramAnonymousBufferedSource, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      throws IOException
    {
      paramAnonymousBufferedSource.skip(paramAnonymousInt2);
      return true;
    }
  };
  
  public abstract void a(int paramInt, b paramb);
  
  public abstract boolean a(int paramInt, List<c> paramList);
  
  public abstract boolean a(int paramInt, List<c> paramList, boolean paramBoolean);
  
  public abstract boolean a(int paramInt1, BufferedSource paramBufferedSource, int paramInt2, boolean paramBoolean)
    throws IOException;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/f/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */