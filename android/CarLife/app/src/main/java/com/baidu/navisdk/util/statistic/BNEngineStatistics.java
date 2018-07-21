package com.baidu.navisdk.util.statistic;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.commandparser.CmdGeneralFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralFunc.Callback;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.listener.NetworkListener;

public class BNEngineStatistics
{
  private static final String TAG = BNEngineStatistics.class.getSimpleName();
  private static volatile BNEngineStatistics mInstance = null;
  private Handler mHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      LogUtil.e("Handler", " in case NetworkListener.MSG_TYPE_NET_WORK_CHANGE");
      int k = paramAnonymousMessage.arg1;
      int m = paramAnonymousMessage.arg2;
      int j = 0;
      final int i = j;
      if (m == 1)
      {
        i = j;
        if (k == 1) {
          i = 2;
        }
      }
      paramAnonymousMessage = new ReqData("cmd.general.func", 7, new Handler(), 1401, 10000);
      CmdGeneralFunc.addFunc(paramAnonymousMessage, new CmdGeneralFunc.Callback()
      {
        public CommandResult exec()
        {
          LogUtil.e(BNEngineStatistics.TAG, "changeNaviStatisticsNetworkStatus toExeStatus=" + i);
          BNaviEngineManager.getInstance().changeNaviStatisticsNetworkStatus(i);
          return null;
        }
      });
      CommandCenter.getInstance().sendRequest(paramAnonymousMessage);
    }
  };
  
  public static void destory()
  {
    if (mInstance != null) {}
    try
    {
      if (mInstance != null)
      {
        mInstance.dispose();
        BNaviEngineManager.getInstance().uninitNaviStatistics();
      }
      mInstance = null;
      return;
    }
    finally {}
  }
  
  private void dispose()
  {
    NetworkListener.unRegisterMessageHandler(this.mHandler);
  }
  
  public static BNEngineStatistics getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new BNEngineStatistics();
      }
      return mInstance;
    }
    finally {}
  }
  
  public void init()
  {
    NetworkListener.registerMessageHandler(this.mHandler);
    BNaviEngineManager.getInstance().initNaviStatistics();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/BNEngineStatistics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */