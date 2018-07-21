package com.tencent.mm.sdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.Log;
import com.tencent.mm.sdk.diffdev.IDiffDevOAuth;
import com.tencent.mm.sdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements IDiffDevOAuth
{
  private com.tencent.mm.sdk.b.d ac = null;
  private List<OAuthListener> ad = new ArrayList();
  private d ae;
  private OAuthListener af = new b(this);
  
  public final void addListener(OAuthListener paramOAuthListener)
  {
    if (!this.ad.contains(paramOAuthListener)) {
      this.ad.add(paramOAuthListener);
    }
  }
  
  public final boolean auth(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, OAuthListener paramOAuthListener)
  {
    Log.i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = " + paramString1);
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramString2 == null) || (paramString2.length() <= 0))
    {
      Log.d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", new Object[] { paramString1, paramString2 }));
      return false;
    }
    if (this.ac == null) {
      this.ac = new com.tencent.mm.sdk.b.d(Looper.getMainLooper());
    }
    addListener(paramOAuthListener);
    if (this.ae != null)
    {
      Log.d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
      return true;
    }
    this.ae = new d(paramString1, paramString2, paramString3, paramString4, paramString5, this.af);
    paramString1 = this.ae;
    if (Build.VERSION.SDK_INT >= 11) {
      paramString1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
    for (;;)
    {
      return true;
      paramString1.execute(new Void[0]);
    }
  }
  
  public final void detach()
  {
    Log.i("MicroMsg.SDK.DiffDevOAuth", "detach");
    this.ad.clear();
    stopAuth();
  }
  
  public final void removeAllListeners()
  {
    this.ad.clear();
  }
  
  public final void removeListener(OAuthListener paramOAuthListener)
  {
    this.ad.remove(paramOAuthListener);
  }
  
  public final boolean stopAuth()
  {
    Log.i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
    for (;;)
    {
      try
      {
        d locald = this.ae;
        if (locald != null) {
          continue;
        }
        bool = true;
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.SDK.DiffDevOAuth", "stopAuth fail, ex = " + localException.getMessage());
        boolean bool = false;
        continue;
      }
      this.ae = null;
      return bool;
      bool = this.ae.q();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/mm/sdk/diffdev/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */