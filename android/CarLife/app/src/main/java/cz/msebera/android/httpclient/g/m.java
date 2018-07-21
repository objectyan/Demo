package cz.msebera.android.httpclient.g;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.n.f;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

@NotThreadSafe
public class m
  extends a
  implements Cloneable
{
  protected final byte[] e;
  
  public m(String paramString)
    throws UnsupportedEncodingException
  {
    this(paramString, g.m);
  }
  
  public m(String paramString, g paramg)
    throws UnsupportedCharsetException
  {
    cz.msebera.android.httpclient.o.a.a(paramString, "Source string");
    if (paramg != null) {}
    for (Charset localCharset1 = paramg.b();; localCharset1 = null)
    {
      Charset localCharset2 = localCharset1;
      if (localCharset1 == null) {
        localCharset2 = f.t;
      }
      try
      {
        this.e = paramString.getBytes(localCharset2.name());
        if (paramg != null) {
          a(paramg.toString());
        }
        return;
      }
      catch (UnsupportedEncodingException paramString)
      {
        throw new UnsupportedCharsetException(localCharset2.name());
      }
    }
  }
  
  public m(String paramString1, String paramString2)
    throws UnsupportedCharsetException
  {
    this(paramString1, g.a(g.j.a(), paramString2));
  }
  
  @Deprecated
  public m(String paramString1, String paramString2, String paramString3)
    throws UnsupportedEncodingException
  {
    cz.msebera.android.httpclient.o.a.a(paramString1, "Source string");
    if (paramString2 != null) {
      if (paramString3 == null) {
        break label62;
      }
    }
    for (;;)
    {
      this.e = paramString1.getBytes(paramString3);
      a(paramString2 + "; charset=" + paramString3);
      return;
      paramString2 = "text/plain";
      break;
      label62:
      paramString3 = "ISO-8859-1";
    }
  }
  
  public m(String paramString, Charset paramCharset)
  {
    this(paramString, g.a(g.j.a(), paramCharset));
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public InputStream getContent()
    throws IOException
  {
    return new ByteArrayInputStream(this.e);
  }
  
  public long getContentLength()
  {
    return this.e.length;
  }
  
  public boolean isRepeatable()
  {
    return true;
  }
  
  public boolean isStreaming()
  {
    return false;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramOutputStream, "Output stream");
    paramOutputStream.write(this.e);
    paramOutputStream.flush();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/g/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */