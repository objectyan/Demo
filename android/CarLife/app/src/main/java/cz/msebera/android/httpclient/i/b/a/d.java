package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.b.a.h;
import cz.msebera.android.httpclient.b.a.i;
import java.io.IOException;

@ThreadSafe
public class d
  implements h
{
  private final k a;
  
  public d(f paramf)
  {
    this.a = new k(paramf.d());
  }
  
  public cz.msebera.android.httpclient.b.a.d a(String paramString)
    throws IOException
  {
    try
    {
      paramString = (cz.msebera.android.httpclient.b.a.d)this.a.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, cz.msebera.android.httpclient.b.a.d paramd)
    throws IOException
  {
    try
    {
      this.a.put(paramString, paramd);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, i parami)
    throws IOException
  {
    try
    {
      cz.msebera.android.httpclient.b.a.d locald = (cz.msebera.android.httpclient.b.a.d)this.a.get(paramString);
      this.a.put(paramString, parami.a(locald));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void b(String paramString)
    throws IOException
  {
    try
    {
      this.a.remove(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */