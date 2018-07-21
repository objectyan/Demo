package cz.msebera.android.httpclient.g.a.a;

import cz.msebera.android.httpclient.g.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class e
  extends a
{
  private final File a;
  private final String b;
  
  public e(File paramFile) {}
  
  public e(File paramFile, g paramg)
  {
    this(paramFile, paramg, null);
  }
  
  public e(File paramFile, g paramg, String paramString)
  {
    super(paramg);
    cz.msebera.android.httpclient.o.a.a(paramFile, "File");
    this.a = paramFile;
    this.b = paramString;
  }
  
  @Deprecated
  public e(File paramFile, String paramString)
  {
    this(paramFile, g.b(paramString), null);
  }
  
  @Deprecated
  public e(File paramFile, String paramString1, String paramString2)
  {
    this(paramFile, null, paramString1, paramString2);
  }
  
  @Deprecated
  public e(File paramFile, String paramString1, String paramString2, String paramString3)
  {
    this(paramFile, g.a(paramString2, paramString3), paramString1);
  }
  
  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramOutputStream, "Output stream");
    FileInputStream localFileInputStream = new FileInputStream(this.a);
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
  
  public String f()
  {
    return this.b;
  }
  
  public String g()
  {
    return "binary";
  }
  
  public long h()
  {
    return this.a.length();
  }
  
  public InputStream i()
    throws IOException
  {
    return new FileInputStream(this.a);
  }
  
  public File j()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/g/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */