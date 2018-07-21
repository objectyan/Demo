package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.h.b;
import cz.msebera.android.httpclient.o.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Immutable
public class am
{
  public b a;
  private final String b;
  
  public am(b paramb)
  {
    this(paramb, "");
  }
  
  public am(b paramb, String paramString)
  {
    this.a = paramb;
    this.b = paramString;
  }
  
  private void a(String paramString, InputStream paramInputStream)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i = paramInputStream.read();
      if (i == -1) {
        break;
      }
      if (i == 13)
      {
        localStringBuilder.append("[\\r]");
      }
      else if (i == 10)
      {
        localStringBuilder.append("[\\n]\"");
        localStringBuilder.insert(0, "\"");
        localStringBuilder.insert(0, paramString);
        this.a.a(this.b + " " + localStringBuilder.toString());
        localStringBuilder.setLength(0);
      }
      else if ((i < 32) || (i > 127))
      {
        localStringBuilder.append("[0x");
        localStringBuilder.append(Integer.toHexString(i));
        localStringBuilder.append("]");
      }
      else
      {
        localStringBuilder.append((char)i);
      }
    }
    if (localStringBuilder.length() > 0)
    {
      localStringBuilder.append('"');
      localStringBuilder.insert(0, '"');
      localStringBuilder.insert(0, paramString);
      this.a.a(this.b + " " + localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt)
    throws IOException
  {
    a(new byte[] { (byte)paramInt });
  }
  
  public void a(InputStream paramInputStream)
    throws IOException
  {
    a.a(paramInputStream, "Output");
    a(">> ", paramInputStream);
  }
  
  public void a(String paramString)
    throws IOException
  {
    a.a(paramString, "Output");
    a(paramString.getBytes());
  }
  
  public void a(byte[] paramArrayOfByte)
    throws IOException
  {
    a.a(paramArrayOfByte, "Output");
    a(">> ", new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    a.a(paramArrayOfByte, "Output");
    a(">> ", new ByteArrayInputStream(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public boolean a()
  {
    return this.a.a();
  }
  
  public void b(int paramInt)
    throws IOException
  {
    b(new byte[] { (byte)paramInt });
  }
  
  public void b(InputStream paramInputStream)
    throws IOException
  {
    a.a(paramInputStream, "Input");
    a("<< ", paramInputStream);
  }
  
  public void b(String paramString)
    throws IOException
  {
    a.a(paramString, "Input");
    b(paramString.getBytes());
  }
  
  public void b(byte[] paramArrayOfByte)
    throws IOException
  {
    a.a(paramArrayOfByte, "Input");
    a("<< ", new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    a.a(paramArrayOfByte, "Input");
    a("<< ", new ByteArrayInputStream(paramArrayOfByte, paramInt1, paramInt2));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/c/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */