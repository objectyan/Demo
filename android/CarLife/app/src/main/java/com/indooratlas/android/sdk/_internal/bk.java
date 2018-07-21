package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.net.ConnectivityManager;
import com.indooratlas.algorithm.ClientProcessingManager;
import com.indooratlas.android.sdk.internal.DeviceWatchdog;
import java.io.IOException;
import java.net.URI;
import org.json.JSONObject;

public final class bk
{
  private static cr a = new cr.a();
  
  public static ClientProcessingManager a(t paramt)
  {
    return new ClientProcessingManager(paramt);
  }
  
  public static ac a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = new ao(paramString1, paramString4);
    paramString1.a(paramString2, paramString3);
    paramString1.a("IAWire");
    return paramString1;
  }
  
  public static bb a(JSONObject paramJSONObject)
  {
    return new bb(paramJSONObject);
  }
  
  public static bm a()
  {
    return new bm();
  }
  
  public static bt a(bf parambf, bt.a parama)
  {
    return new bt(parambf.v, parama);
  }
  
  public static bx a(bf parambf, URI paramURI, String paramString, int paramInt)
    throws IOException
  {
    return new bu(parambf, paramURI, paramString, paramInt);
  }
  
  public static cz a(bf parambf)
  {
    return cz.a(parambf.o);
  }
  
  public static ConnectivityManager b(bf parambf)
  {
    return (ConnectivityManager)parambf.o.getSystemService("connectivity");
  }
  
  public static cr b()
  {
    return a;
  }
  
  public static bn c(bf parambf)
  {
    return new bn(parambf, parambf.e, parambf.b);
  }
  
  public static ca d(bf parambf)
  {
    return new ca(new by(parambf.t));
  }
  
  public static cj e(bf parambf)
  {
    return cj.a(parambf.o);
  }
  
  public static DeviceWatchdog f(bf parambf)
  {
    return new DeviceWatchdog(parambf);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */