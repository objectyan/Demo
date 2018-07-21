package cz.msebera.android.httpclient.i.g;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.j.b;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.o.a;
import java.io.IOException;
import java.net.Socket;

@Deprecated
@NotThreadSafe
public class z
  extends c
  implements b
{
  private final Socket a;
  private boolean b;
  
  public z(Socket paramSocket, int paramInt, j paramj)
    throws IOException
  {
    a.a(paramSocket, "Socket");
    this.a = paramSocket;
    this.b = false;
    int i = paramInt;
    paramInt = i;
    if (i < 0) {
      paramInt = paramSocket.getReceiveBufferSize();
    }
    i = paramInt;
    if (paramInt < 1024) {
      i = 1024;
    }
    a(paramSocket.getInputStream(), i, paramj);
  }
  
  public boolean a(int paramInt)
    throws IOException
  {
    boolean bool2 = j();
    boolean bool1 = bool2;
    int i;
    if (!bool2) {
      i = this.a.getSoTimeout();
    }
    try
    {
      this.a.setSoTimeout(paramInt);
      i();
      bool1 = j();
      return bool1;
    }
    finally
    {
      this.a.setSoTimeout(i);
    }
  }
  
  public boolean d()
  {
    return this.b;
  }
  
  protected int i()
    throws IOException
  {
    int i = super.i();
    if (i == -1) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      return i;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/g/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */