package com.samsung.android.sdk.motion;

import android.hardware.motion.MREvent;
import android.hardware.motion.MRListener;

final class c
  implements MRListener
{
  c(SmotionCall paramSmotionCall, SmotionCall.ChangeListener paramChangeListener) {}
  
  public final void onMotionListener(MREvent paramMREvent)
  {
    SmotionCall.Info localInfo = new SmotionCall.Info();
    long l;
    switch (paramMREvent.getMotion())
    {
    default: 
      return;
    case 101: 
      l = System.nanoTime();
      localInfo.a(0);
    }
    for (;;)
    {
      SmotionCall.Info.a(localInfo, l);
      this.a.onChanged(localInfo);
      return;
      l = System.nanoTime();
      localInfo.a(1);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/samsung/android/sdk/motion/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */