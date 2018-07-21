package com.samsung.android.sdk.motion;

import android.hardware.scontext.SContext;
import android.hardware.scontext.SContextEvent;
import android.hardware.scontext.SContextListener;
import android.hardware.scontext.SContextPedometer;

final class d
  implements SContextListener
{
  d(SmotionPedometer paramSmotionPedometer, SmotionPedometer.ChangeListener paramChangeListener) {}
  
  public final void onSContextChanged(SContextEvent paramSContextEvent)
  {
    int i = 3;
    SmotionPedometer.Info localInfo;
    if (paramSContextEvent.scontext.getType() == 2)
    {
      localInfo = new SmotionPedometer.Info();
      long l = System.nanoTime();
      paramSContextEvent = paramSContextEvent.getPedometerContext();
      SmotionPedometer.Info.a(localInfo, l);
      SmotionPedometer.Info.a(localInfo, paramSContextEvent.getCumulativeDistance());
      SmotionPedometer.Info.b(localInfo, paramSContextEvent.getCumulativeCalorie());
      SmotionPedometer.Info.c(localInfo, paramSContextEvent.getSpeed());
      SmotionPedometer.Info.a(localInfo, 0, paramSContextEvent.getCumulativeTotalStepCount());
      SmotionPedometer.Info.a(localInfo, 5, paramSContextEvent.getCumulativeRunDownStepCount());
      SmotionPedometer.Info.a(localInfo, 4, paramSContextEvent.getCumulativeRunUpStepCount());
      SmotionPedometer.Info.a(localInfo, 6, paramSContextEvent.getCumulativeRunStepCount());
      SmotionPedometer.Info.a(localInfo, 2, paramSContextEvent.getCumulativeWalkDownStepCount());
      SmotionPedometer.Info.a(localInfo, 1, paramSContextEvent.getCumulativeWalkUpStepCount());
      SmotionPedometer.Info.a(localInfo, 3, paramSContextEvent.getCumulativeWalkStepCount());
      switch (paramSContextEvent.getStepStatus())
      {
      case 1: 
      case 2: 
      case 5: 
      default: 
        i = -1;
      }
    }
    for (;;)
    {
      SmotionPedometer.Info.a(localInfo, i);
      SmotionPedometer.a(this.a, localInfo);
      SmotionPedometer.b(this.a, true);
      this.b.onChanged(localInfo);
      SmotionPedometer.c(this.a, true);
      return;
      i = 6;
      continue;
      i = 0;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = -1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/samsung/android/sdk/motion/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */