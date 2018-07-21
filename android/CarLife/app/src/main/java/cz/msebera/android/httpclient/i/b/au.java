package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.u;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Immutable
public class au
  extends t
{
  private final Map<String, Boolean> b = new ConcurrentHashMap();
  
  public au()
  {
    this(3, false);
  }
  
  public au(int paramInt, boolean paramBoolean)
  {
    super(paramInt, paramBoolean);
    this.b.put("GET", Boolean.TRUE);
    this.b.put("HEAD", Boolean.TRUE);
    this.b.put("PUT", Boolean.TRUE);
    this.b.put("DELETE", Boolean.TRUE);
    this.b.put("OPTIONS", Boolean.TRUE);
    this.b.put("TRACE", Boolean.TRUE);
  }
  
  protected boolean a(u paramu)
  {
    paramu = paramu.getRequestLine().a().toUpperCase(Locale.ENGLISH);
    paramu = (Boolean)this.b.get(paramu);
    return (paramu != null) && (paramu.booleanValue());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */