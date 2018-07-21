package cz.msebera.android.httpclient.g;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@NotThreadSafe
public class i
  extends a
  implements Cloneable
{
  protected final File e;
  
  public i(File paramFile)
  {
    this.e = ((File)cz.msebera.android.httpclient.o.a.a(paramFile, "File"));
  }
  
  public i(File paramFile, g paramg)
  {
    this.e = ((File)cz.msebera.android.httpclient.o.a.a(paramFile, "File"));
    if (paramg != null) {
      a(paramg.toString());
    }
  }
  
  @Deprecated
  public i(File paramFile, String paramString)
  {
    this.e = ((File)cz.msebera.android.httpclient.o.a.a(paramFile, "File"));
    a(paramString);
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public InputStream getContent()
    throws IOException
  {
    return new FileInputStream(this.e);
  }
  
  public long getContentLength()
  {
    return this.e.length();
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
    FileInputStream localFileInputStream = new FileInputStream(this.e);
    try
    {
      byte[] arrayOfByte = new byte['က'];
      for (;;)
      {
        int i = localFileInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
    }
    finally
    {
      localFileInputStream.close();
    }
    localFileInputStream.close();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/g/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */