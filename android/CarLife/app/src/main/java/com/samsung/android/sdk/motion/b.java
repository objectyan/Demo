package com.samsung.android.sdk.motion;

import android.hardware.scontext.SContext;
import android.hardware.scontext.SContextActivityNotification;
import android.hardware.scontext.SContextEvent;
import android.hardware.scontext.SContextListener;

final class b
  implements SContextListener
{
  b(SmotionActivityNotification paramSmotionActivityNotification, SmotionActivityNotification.ChangeListener paramChangeListener) {}
  
  public final void onSContextChanged(SContextEvent paramSContextEvent)
  {
    if (paramSContextEvent.scontext.getType() == 27)
    {
      paramSContextEvent = paramSContextEvent.getActivityNotificationContext();
      int i = paramSContextEvent.getStatus();
      int j = paramSContextEvent.getAccuracy();
      long l = paramSContextEvent.getTimeStamp();
      paramSContextEvent = SmotionActivityNotification.a(this.a, l, i, j);
      this.b.onChanged(paramSContextEvent);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/samsung/android/sdk/motion/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */