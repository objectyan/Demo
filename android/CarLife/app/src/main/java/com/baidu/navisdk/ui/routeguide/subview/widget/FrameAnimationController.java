package com.baidu.navisdk.ui.routeguide.subview.widget;

import android.os.Handler;
import android.os.Message;

public class FrameAnimationController
{
  public static final int ANIMATION_FRAME_DURATION = 16;
  private static final int MSG_ANIMATE = 1000;
  private static final Handler mHandler = new AnimationHandler(null);
  
  public static void requestAnimationFrame(Runnable paramRunnable)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1000;
    localMessage.obj = paramRunnable;
    mHandler.sendMessageDelayed(localMessage, 16L);
  }
  
  public static void requestFrameDelay(Runnable paramRunnable, long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1000;
    localMessage.obj = paramRunnable;
    mHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private static class AnimationHandler
    extends Handler
  {
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        return;
      } while (paramMessage.obj == null);
      ((Runnable)paramMessage.obj).run();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/subview/widget/FrameAnimationController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */