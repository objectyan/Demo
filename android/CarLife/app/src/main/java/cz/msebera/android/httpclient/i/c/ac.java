package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.c;
import cz.msebera.android.httpclient.j.g;
import cz.msebera.android.httpclient.j.i;
import cz.msebera.android.httpclient.o.d;
import java.io.IOException;
import java.nio.charset.Charset;

@Deprecated
@Immutable
public class ac
  implements i
{
  private final i a;
  private final am b;
  private final String c;
  
  public ac(i parami, am paramam)
  {
    this(parami, paramam, null);
  }
  
  public ac(i parami, am paramam, String paramString)
  {
    this.a = parami;
    this.b = paramam;
    if (paramString != null) {}
    for (;;)
    {
      this.c = paramString;
      return;
      paramString = c.f.name();
    }
  }
  
  public void a()
    throws IOException
  {
    this.a.a();
  }
  
  public void a(int paramInt)
    throws IOException
  {
    this.a.a(paramInt);
    if (this.b.a()) {
      this.b.a(paramInt);
    }
  }
  
  public void a(d paramd)
    throws IOException
  {
    this.a.a(paramd);
    if (this.b.a())
    {
      paramd = new String(paramd.c(), 0, paramd.e());
      paramd = paramd + "\r\n";
      this.b.a(paramd.getBytes(this.c));
    }
  }
  
  public void a(String paramString)
    throws IOException
  {
    this.a.a(paramString);
    if (this.b.a())
    {
      paramString = paramString + "\r\n";
      this.b.a(paramString.getBytes(this.c));
    }
  }
  
  public void a(byte[] paramArrayOfByte)
    throws IOException
  {
    this.a.a(paramArrayOfByte);
    if (this.b.a()) {
      this.b.a(paramArrayOfByte);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.a.a(paramArrayOfByte, paramInt1, paramInt2);
    if (this.b.a()) {
      this.b.a(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public g b()
  {
    return this.a.b();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */