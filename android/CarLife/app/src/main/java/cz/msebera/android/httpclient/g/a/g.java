package cz.msebera.android.httpclient.g.a;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

class g
  extends a
{
  private final List<b> b;
  
  public g(String paramString1, Charset paramCharset, String paramString2, List<b> paramList)
  {
    super(paramString1, paramCharset, paramString2);
    this.b = paramList;
  }
  
  protected void a(b paramb, OutputStream paramOutputStream)
    throws IOException
  {
    paramb = paramb.c().iterator();
    while (paramb.hasNext()) {
      a((i)paramb.next(), paramOutputStream);
    }
  }
  
  public List<b> c()
  {
    return this.b;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/g/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */