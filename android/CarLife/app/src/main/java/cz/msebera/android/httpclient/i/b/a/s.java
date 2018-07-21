package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.b.a.l;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;

@NotThreadSafe
class s
  extends cz.msebera.android.httpclient.g.a
{
  private final l e;
  private final InputStream f;
  
  s(l paraml, InputStream paramInputStream)
    throws IOException
  {
    this.e = paraml;
    this.f = new SequenceInputStream(new a(paraml.a()), paramInputStream);
  }
  
  private void a()
  {
    this.e.c();
  }
  
  public InputStream getContent()
    throws IOException, IllegalStateException
  {
    return this.f;
  }
  
  public long getContentLength()
  {
    return -1L;
  }
  
  public boolean isRepeatable()
  {
    return false;
  }
  
  public boolean isStreaming()
  {
    return true;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramOutputStream, "Output stream");
    InputStream localInputStream = getContent();
    try
    {
      byte[] arrayOfByte = new byte['ࠀ'];
      for (;;)
      {
        int i = localInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
    }
    finally
    {
      localInputStream.close();
    }
  }
  
  class a
    extends FilterInputStream
  {
    protected a(InputStream paramInputStream)
    {
      super();
    }
    
    public void close()
      throws IOException
    {
      try
      {
        super.close();
        return;
      }
      finally
      {
        s.a(s.this);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */