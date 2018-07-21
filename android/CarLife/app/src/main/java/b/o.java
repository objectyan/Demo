package b;

import java.io.UnsupportedEncodingException;
import okio.ByteString;

public final class o
{
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = ByteString.of((paramString1 + ":" + paramString2).getBytes("ISO-8859-1")).base64();
      paramString1 = "Basic " + paramString1;
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new AssertionError();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */