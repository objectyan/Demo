package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.b.a.d;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class k
  extends LinkedHashMap<String, d>
{
  private static final long a = -7750025207539768511L;
  private final int b;
  
  k(int paramInt)
  {
    super(20, 0.75F, true);
    this.b = paramInt;
  }
  
  protected boolean removeEldestEntry(Map.Entry<String, d> paramEntry)
  {
    return size() > this.b;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */