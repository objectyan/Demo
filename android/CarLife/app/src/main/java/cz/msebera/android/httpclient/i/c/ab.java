package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.c;
import cz.msebera.android.httpclient.j.b;
import cz.msebera.android.httpclient.j.g;
import cz.msebera.android.httpclient.j.h;
import cz.msebera.android.httpclient.o.d;
import java.io.IOException;
import java.nio.charset.Charset;

@Deprecated
@Immutable
public class ab
  implements b, h
{
  private final h a;
  private final b b;
  private final am c;
  private final String d;
  
  public ab(h paramh, am paramam)
  {
    this(paramh, paramam, null);
  }
  
  public ab(h paramh, am paramam, String paramString)
  {
    this.a = paramh;
    if ((paramh instanceof b))
    {
      paramh = (b)paramh;
      this.b = paramh;
      this.c = paramam;
      if (paramString == null) {
        break label46;
      }
    }
    for (;;)
    {
      this.d = paramString;
      return;
      paramh = null;
      break;
      label46:
      paramString = c.f.name();
    }
  }
  
  public int a()
    throws IOException
  {
    int i = this.a.a();
    if ((this.c.a()) && (i != -1)) {
      this.c.b(i);
    }
    return i;
  }
  
  public int a(d paramd)
    throws IOException
  {
    int i = this.a.a(paramd);
    if ((this.c.a()) && (i >= 0))
    {
      int j = paramd.e();
      paramd = new String(paramd.c(), j - i, i);
      paramd = paramd + "\r\n";
      this.c.b(paramd.getBytes(this.d));
    }
    return i;
  }
  
  public int a(byte[] paramArrayOfByte)
    throws IOException
  {
    int i = this.a.a(paramArrayOfByte);
    if ((this.c.a()) && (i > 0)) {
      this.c.b(paramArrayOfByte, 0, i);
    }
    return i;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt2 = this.a.a(paramArrayOfByte, paramInt1, paramInt2);
    if ((this.c.a()) && (paramInt2 > 0)) {
      this.c.b(paramArrayOfByte, paramInt1, paramInt2);
    }
    return paramInt2;
  }
  
  public boolean a(int paramInt)
    throws IOException
  {
    return this.a.a(paramInt);
  }
  
  public String b()
    throws IOException
  {
    String str1 = this.a.b();
    if ((this.c.a()) && (str1 != null))
    {
      String str2 = str1 + "\r\n";
      this.c.b(str2.getBytes(this.d));
    }
    return str1;
  }
  
  public g c()
  {
    return this.a.c();
  }
  
  public boolean d()
  {
    if (this.b != null) {
      return this.b.d();
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */