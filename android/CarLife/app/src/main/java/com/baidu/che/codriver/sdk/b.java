package com.baidu.che.codriver.sdk;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.che.codriver.c.a;
import com.baidu.che.codriver.sdk.a.l;
import com.baidu.che.codriver.sdk.a.l.b;
import com.baidu.che.codriver.util.h;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class b
  extends c.a
  implements l.b
{
  public static final String d = "[sdk_server] ICoDriverServiceImpl";
  private Map<IBinder, a> e = new HashMap();
  private Handler f = new Handler();
  private HandlerThread g = new HandlerThread("RequestThread");
  private Handler h;
  
  public b()
  {
    this.g.start();
    this.h = new Handler(this.g.getLooper());
  }
  
  private void b(com.baidu.che.codriver.b paramb)
  {
    if (paramb == null) {}
    for (;;)
    {
      return;
      paramb = paramb.asBinder();
      paramb = (a)this.e.remove(paramb);
      if (paramb == null) {
        break;
      }
      Object localObject = paramb.c;
      if (localObject != null) {
        ((a)localObject).b();
      }
      localObject = paramb.d.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        h.b("[sdk_server] ICoDriverServiceImpl", "reset pkg=" + paramb.a + " cmd=" + str);
        l.a().a(paramb.a, str, "reset", null);
      }
    }
    h.b("[sdk_server] ICoDriverServiceImpl", "already unregistered");
  }
  
  private void b(String paramString, com.baidu.che.codriver.b paramb)
  {
    if (paramb == null) {
      return;
    }
    IBinder localIBinder = paramb.asBinder();
    if (this.e.containsKey(localIBinder))
    {
      h.b("[sdk_server] ICoDriverServiceImpl", "already registered");
      return;
    }
    a locala = new a(this, paramb);
    locala.a();
    a locala1 = new a(null);
    locala1.a = paramString;
    locala1.b = paramb;
    locala1.c = locala;
    locala1.d = new HashSet();
    this.e.put(localIBinder, locala1);
  }
  
  public String a(final String paramString1, final String paramString2, final String paramString3, final String paramString4)
    throws RemoteException
  {
    h.b("[sdk_server] ICoDriverServiceImpl", "sendCommand pkg=" + paramString1 + " cmd=" + paramString2 + " param=" + paramString3);
    this.f.post(new Runnable()
    {
      public void run()
      {
        l.a().a(paramString1, paramString2, paramString3, paramString4);
      }
    });
    return null;
  }
  
  public void a(final com.baidu.che.codriver.b paramb)
    throws RemoteException
  {
    this.f.post(new Runnable()
    {
      public void run()
      {
        b.a(b.this, paramb);
      }
    });
  }
  
  public void a(final String paramString, final com.baidu.che.codriver.b paramb)
    throws RemoteException
  {
    h.b("[sdk_server] ICoDriverServiceImpl", "registerListener pkg=" + paramString);
    this.f.post(new Runnable()
    {
      public void run()
      {
        b.a(b.this, paramString, paramb);
      }
    });
  }
  
  public void a(String paramString1, String paramString2)
  {
    Iterator localIterator = this.e.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.a.equals(paramString1)) {
        locala.d.add(paramString2);
      } else {
        locala.d.remove(paramString2);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    Iterator localIterator = this.e.values().iterator();
    while (localIterator.hasNext()) {
      if (((a)localIterator.next()).d.contains(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public String b(final String paramString1, final String paramString2, final String paramString3, final String paramString4)
  {
    h.b("[sdk_server] ICoDriverServiceImpl", "sendCmdToClient pkg=" + paramString1 + " cmd=" + paramString2 + " param=" + paramString3);
    Iterator localIterator = this.e.values().iterator();
    while (localIterator.hasNext())
    {
      final a locala = (a)localIterator.next();
      if ((locala.d.contains(paramString2)) && (locala.b != null)) {
        this.h.post(new Runnable()
        {
          public void run()
          {
            try
            {
              locala.b.a(paramString1, paramString2, paramString3, paramString4);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              localRemoteException.printStackTrace();
            }
          }
        });
      }
    }
    return null;
  }
  
  private static class a
  {
    String a;
    com.baidu.che.codriver.b b;
    a c;
    Set<String> d;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/sdk/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */