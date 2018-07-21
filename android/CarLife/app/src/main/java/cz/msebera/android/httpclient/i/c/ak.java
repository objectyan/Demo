package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.e.l;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ak
  implements l
{
  public static final ak a = new ak();
  
  public InetAddress[] a(String paramString)
    throws UnknownHostException
  {
    return InetAddress.getAllByName(paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/c/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */