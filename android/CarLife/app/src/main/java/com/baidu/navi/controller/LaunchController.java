package com.baidu.navi.controller;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.verify.BNKeyVerify;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;

public class LaunchController
{
  private static final String ACCESS_KEY = "1Z7v3O9UhsHdUt6iA2GaQaoG";
  private static final String TAG = LaunchController.class.getSimpleName();
  private boolean mIsDelayedInitDone = false;
  public Handler mUIHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        return;
      } while (paramAnonymousMessage.arg1 != 0);
      LogUtil.e("NaviActivity", StyleManager.getString(2131296545));
    }
  };
  
  private void delayedInit()
  {
    BNSettingManager.initEngine();
    BNLocationManagerProxy.getInstance().getLastValidLocation();
    verifySDK();
  }
  
  public static LaunchController getInstance()
  {
    return LazyHolder.instance;
  }
  
  private void verifySDK()
  {
    BNKeyVerify.getInstance().asyncVerify("1Z7v3O9UhsHdUt6iA2GaQaoG", this.mUIHandler);
  }
  
  /* Error */
  public void asyncDelayedInit(final Handler paramHandler, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +14 -> 17
    //   6: aload_0
    //   7: getfield 36	com/baidu/navi/controller/LaunchController:mIsDelayedInitDone	Z
    //   10: istore 4
    //   12: iload 4
    //   14: ifeq +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_1
    //   21: new 8	com/baidu/navi/controller/LaunchController$2
    //   24: dup
    //   25: aload_0
    //   26: aload_1
    //   27: invokespecial 92	com/baidu/navi/controller/LaunchController$2:<init>	(Lcom/baidu/navi/controller/LaunchController;Landroid/os/Handler;)V
    //   30: lload_2
    //   31: invokevirtual 98	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   34: pop
    //   35: goto -18 -> 17
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	LaunchController
    //   0	43	1	paramHandler	Handler
    //   0	43	2	paramLong	long
    //   10	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	12	38	finally
    //   20	35	38	finally
  }
  
  public boolean getInitFinished()
  {
    return this.mIsDelayedInitDone;
  }
  
  private static class LazyHolder
  {
    private static final LaunchController instance = new LaunchController(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/controller/LaunchController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */