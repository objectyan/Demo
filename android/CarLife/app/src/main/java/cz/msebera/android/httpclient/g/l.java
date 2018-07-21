package cz.msebera.android.httpclient.g;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

@NotThreadSafe
public class l
  extends a
{
  private byte[] e;
  private Serializable f;
  
  public l(Serializable paramSerializable)
  {
    cz.msebera.android.httpclient.o.a.a(paramSerializable, "Source object");
    this.f = paramSerializable;
  }
  
  public l(Serializable paramSerializable, boolean paramBoolean)
    throws IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramSerializable, "Source object");
    if (paramBoolean)
    {
      a(paramSerializable);
      return;
    }
    this.f = paramSerializable;
  }
  
  private void a(Serializable paramSerializable)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
    localObjectOutputStream.writeObject(paramSerializable);
    localObjectOutputStream.flush();
    this.e = localByteArrayOutputStream.toByteArray();
  }
  
  public InputStream getContent()
    throws IOException, IllegalStateException
  {
    if (this.e == null) {
      a(this.f);
    }
    return new ByteArrayInputStream(this.e);
  }
  
  public long getContentLength()
  {
    if (this.e == null) {
      return -1L;
    }
    return this.e.length;
  }
  
  public boolean isRepeatable()
  {
    return true;
  }
  
  public boolean isStreaming()
  {
    return this.e == null;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramOutputStream, "Output stream");
    if (this.e == null)
    {
      paramOutputStream = new ObjectOutputStream(paramOutputStream);
      paramOutputStream.writeObject(this.f);
      paramOutputStream.flush();
      return;
    }
    paramOutputStream.write(this.e);
    paramOutputStream.flush();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/g/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */