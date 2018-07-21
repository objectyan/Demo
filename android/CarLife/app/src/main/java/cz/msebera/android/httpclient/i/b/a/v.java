package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.a.d;
import cz.msebera.android.httpclient.b.a.e;
import cz.msebera.android.httpclient.b.a.f;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

@Immutable
public class v
  implements f
{
  public d a(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = new ObjectInputStream(paramInputStream);
    try
    {
      d locald = (d)paramInputStream.readObject();
      return locald;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new e("Class not found: " + localClassNotFoundException.getMessage(), localClassNotFoundException);
    }
    finally
    {
      paramInputStream.close();
    }
  }
  
  public void a(d paramd, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream = new ObjectOutputStream(paramOutputStream);
    try
    {
      paramOutputStream.writeObject(paramd);
      return;
    }
    finally
    {
      paramOutputStream.close();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */