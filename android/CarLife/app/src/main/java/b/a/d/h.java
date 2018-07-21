package b.a.d;

import b.ae;
import b.t;
import b.w;
import okio.BufferedSource;

public final class h
  extends ae
{
  private final t a;
  private final BufferedSource b;
  
  public h(t paramt, BufferedSource paramBufferedSource)
  {
    this.a = paramt;
    this.b = paramBufferedSource;
  }
  
  public w a()
  {
    String str = this.a.a("Content-Type");
    if (str != null) {
      return w.a(str);
    }
    return null;
  }
  
  public long b()
  {
    return e.a(this.a);
  }
  
  public BufferedSource c()
  {
    return this.b;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */