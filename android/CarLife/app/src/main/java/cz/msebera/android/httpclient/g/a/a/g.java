package cz.msebera.android.httpclient.g.a.a;

import cz.msebera.android.httpclient.c;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class g
  extends a
{
  private final byte[] a;
  
  @Deprecated
  public g(String paramString)
    throws UnsupportedEncodingException
  {
    this(paramString, "text/plain", c.f);
  }
  
  public g(String paramString, cz.msebera.android.httpclient.g.g paramg)
  {
    super(paramg);
    cz.msebera.android.httpclient.o.a.a(paramString, "Text");
    paramg = paramg.b();
    if (paramg != null) {}
    for (paramg = paramg.name();; paramg = c.f.name()) {
      try
      {
        this.a = paramString.getBytes(paramg);
        return;
      }
      catch (UnsupportedEncodingException paramString)
      {
        throw new UnsupportedCharsetException(paramg);
      }
    }
  }
  
  @Deprecated
  public g(String paramString1, String paramString2, Charset paramCharset)
    throws UnsupportedEncodingException
  {
    this(paramString1, cz.msebera.android.httpclient.g.g.a(paramString2, paramCharset));
  }
  
  @Deprecated
  public g(String paramString, Charset paramCharset)
    throws UnsupportedEncodingException
  {
    this(paramString, "text/plain", paramCharset);
  }
  
  @Deprecated
  public static g a(String paramString)
    throws IllegalArgumentException
  {
    return a(paramString, null, null);
  }
  
  @Deprecated
  public static g a(String paramString1, String paramString2, Charset paramCharset)
    throws IllegalArgumentException
  {
    try
    {
      paramString1 = new g(paramString1, paramString2, paramCharset);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new IllegalArgumentException("Charset " + paramCharset + " is not supported", paramString1);
    }
  }
  
  @Deprecated
  public static g a(String paramString, Charset paramCharset)
    throws IllegalArgumentException
  {
    return a(paramString, null, paramCharset);
  }
  
  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramOutputStream, "Output stream");
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.a);
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      int i = localByteArrayInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    paramOutputStream.flush();
  }
  
  public String f()
  {
    return null;
  }
  
  public String g()
  {
    return "8bit";
  }
  
  public long h()
  {
    return this.a.length;
  }
  
  public Reader i()
  {
    Charset localCharset = a().b();
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.a);
    if (localCharset != null) {}
    for (;;)
    {
      return new InputStreamReader(localByteArrayInputStream, localCharset);
      localCharset = c.f;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/g/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */