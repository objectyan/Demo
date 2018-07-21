package com.baidu.location.a;

import android.content.Context;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.location.h.a;
import org.json.JSONObject;

public class g
  implements LBSAuthManagerListener
{
  private static Object a = new Object();
  private static g b = null;
  private int c = 0;
  private Context d = null;
  private long e = 0L;
  private String f = null;
  
  public static g a()
  {
    synchronized (a)
    {
      if (b == null) {
        b = new g();
      }
      g localg = b;
      return localg;
    }
  }
  
  public void a(Context paramContext) {}
  
  public boolean b()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.c != 0)
    {
      bool1 = bool2;
      if (this.c != 602)
      {
        bool1 = bool2;
        if (this.c != 601)
        {
          bool1 = bool2;
          if (this.c != -10)
          {
            bool1 = bool2;
            if (this.c != -11) {
              bool1 = false;
            }
          }
        }
      }
    }
    long l;
    if (this.d != null)
    {
      l = System.currentTimeMillis() - this.e;
      if (!bool1) {
        break label112;
      }
      if (l > 86400000L)
      {
        com.baidu.lbsapi.auth.g.a(this.d).a(false, "lbs_locsdk", null, this);
        this.e = System.currentTimeMillis();
      }
    }
    label112:
    while ((l >= 0L) && (l <= 10000L)) {
      return bool1;
    }
    com.baidu.lbsapi.auth.g.a(this.d).a(false, "lbs_locsdk", null, this);
    this.e = System.currentTimeMillis();
    return bool1;
  }
  
  public void onAuthResult(int paramInt, String paramString)
  {
    this.c = paramInt;
    Log.i(a.a, "LocationAuthManager Authentication Error errorcode = " + paramInt + " , msg = " + paramString);
    if (paramString != null) {}
    try
    {
      paramString = new JSONObject(paramString);
      if ((paramString != null) && (paramString.getString("token") != null)) {
        this.f = paramString.getString("token");
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */