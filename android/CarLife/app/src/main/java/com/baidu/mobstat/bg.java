package com.baidu.mobstat;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import java.util.HashMap;

class bg
  implements Application.ActivityLifecycleCallbacks
{
  bg(bf parambf) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity arg1)
  {
    String str = ???.getClass().getName();
    synchronized (bf.b(this.a))
    {
      bf.b(this.a).remove(str);
      return;
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    Context localContext = paramActivity.getApplicationContext();
    ch.a().b(localContext, System.currentTimeMillis());
    if (bf.a(this.a)) {
      bf.a(this.a, paramActivity, false);
    }
    ch.a().a(paramActivity.getApplicationContext());
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    Context localContext = paramActivity.getApplicationContext();
    ch.a().a(localContext, System.currentTimeMillis());
    if (bf.a(this.a))
    {
      bf.a(this.a, paramActivity, true);
      bf.a(this.a, paramActivity);
    }
    ch.a().f();
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */