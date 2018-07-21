package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.a.k;
import cz.msebera.android.httpclient.b.a.l;
import cz.msebera.android.httpclient.b.a.m;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Immutable
public class ac
  implements m
{
  public l a(String paramString, l paraml)
    throws IOException
  {
    if ((paraml instanceof ab)) {}
    for (paramString = ((ab)paraml).d();; paramString = paramString.toByteArray())
    {
      return a(paramString);
      paramString = new ByteArrayOutputStream();
      ae.b(paraml.a(), paramString);
    }
  }
  
  public l a(String paramString, InputStream paramInputStream, k paramk)
    throws IOException
  {
    paramString = new ByteArrayOutputStream();
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
    return a(paramString.toByteArray());
  }
  
  l a(byte[] paramArrayOfByte)
  {
    return new ab(paramArrayOfByte);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */