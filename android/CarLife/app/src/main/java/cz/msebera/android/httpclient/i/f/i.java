package cz.msebera.android.httpclient.i.f;

import cz.msebera.android.httpclient.annotation.Immutable;
import java.io.InterruptedIOException;

@Immutable
public class i
  extends InterruptedIOException
{
  private static final long a = 4973849966012490112L;
  
  public i(String paramString)
  {
    super(paramString);
  }
  
  public i(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    if (paramThrowable != null) {
      initCause(paramThrowable);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/f/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */