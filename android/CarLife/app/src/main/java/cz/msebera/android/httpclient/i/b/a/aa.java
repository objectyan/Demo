package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.a.k;
import cz.msebera.android.httpclient.b.a.l;
import cz.msebera.android.httpclient.b.a.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Immutable
public class aa
  implements m
{
  private final File a;
  private final e b;
  
  public aa(File paramFile)
  {
    this.a = paramFile;
    this.b = new e();
  }
  
  private File a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    this.b.a(localStringBuilder);
    localStringBuilder.append('.');
    int j = Math.min(paramString.length(), 100);
    int i = 0;
    if (i < j)
    {
      char c = paramString.charAt(i);
      if ((Character.isLetterOrDigit(c)) || (c == '.')) {
        localStringBuilder.append(c);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append('-');
      }
    }
    return new File(this.a, localStringBuilder.toString());
  }
  
  public l a(String paramString, l paraml)
    throws IOException
  {
    paramString = a(paramString);
    if ((paraml instanceof z)) {
      ae.a(((z)paraml).d(), paramString);
    }
    for (;;)
    {
      return new z(paramString);
      FileOutputStream localFileOutputStream = new FileOutputStream(paramString);
      ae.b(paraml.a(), localFileOutputStream);
    }
  }
  
  public l a(String paramString, InputStream paramInputStream, k paramk)
    throws IOException
  {
    File localFile = a(paramString);
    paramString = new FileOutputStream(localFile);
    try
    {
      byte[] arrayOfByte = new byte['ࠀ'];
      long l1 = 0L;
      long l2;
      do
      {
        do
        {
          int i = paramInputStream.read(arrayOfByte);
          if (i == -1) {
            break;
          }
          paramString.write(arrayOfByte, 0, i);
          l2 = l1 + i;
          l1 = l2;
        } while (paramk == null);
        l1 = l2;
      } while (l2 <= paramk.a());
      paramk.b();
      return new z(localFile);
    }
    finally
    {
      paramString.close();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */