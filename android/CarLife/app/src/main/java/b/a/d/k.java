package b.a.d;

import b.ad;
import b.z;
import java.io.IOException;
import java.net.ProtocolException;

public final class k
{
  public static final int a = 307;
  public static final int b = 308;
  public static final int c = 100;
  public final z d;
  public final int e;
  public final String f;
  
  public k(z paramz, int paramInt, String paramString)
  {
    this.d = paramz;
    this.e = paramInt;
    this.f = paramString;
  }
  
  public static k a(ad paramad)
  {
    return new k(paramad.b(), paramad.c(), paramad.e());
  }
  
  public static k a(String paramString)
    throws IOException
  {
    int j;
    int i;
    z localz;
    if (paramString.startsWith("HTTP/1."))
    {
      if ((paramString.length() < 9) || (paramString.charAt(8) != ' ')) {
        throw new ProtocolException("Unexpected status line: " + paramString);
      }
      j = paramString.charAt(7) - '0';
      i = 9;
      if (j == 0) {
        localz = z.a;
      }
    }
    while (paramString.length() < i + 3)
    {
      throw new ProtocolException("Unexpected status line: " + paramString);
      if (j == 1)
      {
        localz = z.b;
      }
      else
      {
        throw new ProtocolException("Unexpected status line: " + paramString);
        if (paramString.startsWith("ICY "))
        {
          localz = z.a;
          i = 4;
        }
        else
        {
          throw new ProtocolException("Unexpected status line: " + paramString);
        }
      }
    }
    try
    {
      j = Integer.parseInt(paramString.substring(i, i + 3));
      str = "";
      if (paramString.length() <= i + 3) {
        break label300;
      }
      if (paramString.charAt(i + 3) != ' ') {
        throw new ProtocolException("Unexpected status line: " + paramString);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new ProtocolException("Unexpected status line: " + paramString);
    }
    String str = paramString.substring(i + 4);
    label300:
    return new k(localNumberFormatException, j, str);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.d == z.a) {}
    for (String str = "HTTP/1.0";; str = "HTTP/1.1")
    {
      localStringBuilder.append(str);
      localStringBuilder.append(' ').append(this.e);
      if (this.f != null) {
        localStringBuilder.append(' ').append(this.f);
      }
      return localStringBuilder.toString();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/d/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */