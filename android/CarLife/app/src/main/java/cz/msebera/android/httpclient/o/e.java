package cz.msebera.android.httpclient.o;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class e
{
  public static Charset a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = Charset.forName(paramString);
      return paramString;
    }
    catch (UnsupportedCharsetException paramString) {}
    return null;
  }
  
  public static Charset b(String paramString)
    throws UnsupportedEncodingException
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      Charset localCharset = Charset.forName(paramString);
      return localCharset;
    }
    catch (UnsupportedCharsetException localUnsupportedCharsetException)
    {
      throw new UnsupportedEncodingException(paramString);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/o/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */