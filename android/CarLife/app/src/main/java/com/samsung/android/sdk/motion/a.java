package com.samsung.android.sdk.motion;

import android.hardware.scontext.SContext;
import android.hardware.scontext.SContextActivityBatch;
import android.hardware.scontext.SContextActivityTracker;
import android.hardware.scontext.SContextEvent;
import android.hardware.scontext.SContextListener;

final class a
  implements SContextListener
{
  a(SmotionActivity paramSmotionActivity, SmotionActivity.ChangeListener paramChangeListener) {}
  
  public final void onSContextChanged(SContextEvent paramSContextEvent)
  {
    int k = 0;
    Object localObject1 = paramSContextEvent.scontext;
    int j;
    if (((SContext)localObject1).getType() == 25)
    {
      paramSContextEvent = paramSContextEvent.getActivityTrackerContext();
      i = paramSContextEvent.getStatus();
      j = paramSContextEvent.getAccuracy();
      long l = paramSContextEvent.getTimeStamp();
      SmotionActivity.a(this.a, SmotionActivity.a(this.a, l, i, j));
      paramSContextEvent = SmotionActivity.a(this.a);
      this.b.onChanged(1, new SmotionActivity.Info[] { paramSContextEvent });
      if (!SmotionActivity.b(this.a)) {
        SmotionActivity.b(this.a, true);
      }
      SmotionActivity.c(this.a, true);
    }
    Object localObject2;
    do
    {
      do
      {
        return;
      } while (((SContext)localObject1).getType() != 26);
      localObject2 = paramSContextEvent.getActivityBatchContext();
      paramSContextEvent = ((SContextActivityBatch)localObject2).getStatus();
      localObject1 = ((SContextActivityBatch)localObject2).getAccuracy();
      localObject2 = ((SContextActivityBatch)localObject2).getTimeStamp();
    } while ((paramSContextEvent == null) || (localObject1 == null));
    int m = paramSContextEvent.length;
    int i = 0;
    label170:
    SmotionActivity.Info[] arrayOfInfo;
    if (i >= m)
    {
      j = 0;
      m = paramSContextEvent.length - j;
      arrayOfInfo = new SmotionActivity.Info[m];
      i = k;
    }
    for (;;)
    {
      if (i >= m)
      {
        this.b.onChanged(2, arrayOfInfo);
        return;
        j = i;
        if (localObject2[i] > SmotionActivity.c(this.a)) {
          break label170;
        }
        i += 1;
        break;
      }
      arrayOfInfo[i] = SmotionActivity.a(this.a, localObject2[(i + j)], paramSContextEvent[(i + j)], localObject1[(i + j)]);
      i += 1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/samsung/android/sdk/motion/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */