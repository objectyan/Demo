package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.x;
import cz.msebera.android.httpclient.z;
import java.io.IOException;

@Immutable
public class ae
  implements z
{
  private final String a;
  
  public ae()
  {
    this(null);
  }
  
  public ae(String paramString)
  {
    this.a = paramString;
  }
  
  public void process(x paramx, g paramg)
    throws p, IOException
  {
    a.a(paramx, "HTTP response");
    if ((!paramx.containsHeader("Server")) && (this.a != null)) {
      paramx.addHeader("Server", this.a);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/n/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */