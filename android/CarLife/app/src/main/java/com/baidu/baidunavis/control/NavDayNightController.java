package com.baidu.baidunavis.control;

import android.os.Message;
import com.baidu.mapframework.nirvana.looper.MainLooperHandler;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.commontool.BNAutoDayNightHelper;
import com.baidu.navisdk.comapi.commontool.BNDayNightChangedObserver;
import com.baidu.navisdk.ui.util.BNStyleManager;
import java.util.ArrayList;
import java.util.List;

public class NavDayNightController
{
  private static final int MSG_Day = 1;
  private static final int MSG_Night = 2;
  private static NavDayNightController sInstance = null;
  private BNDayNightChangedObserver mDayNightChangedObserver = new BNDayNightChangedObserver()
  {
    public void update(BNSubject paramAnonymousBNSubject, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
    {
      if (paramAnonymousInt1 == 1) {}
      switch (paramAnonymousInt2)
      {
      default: 
        return;
      case 2: 
      case 4: 
        NavDayNightController.this.setStyle(true);
        return;
      }
      NavDayNightController.this.setStyle(false);
    }
  };
  private boolean mDayStyle = true;
  private MainLooperHandler mHandler = new MainLooperHandler(Module.NAV_MODULE, ScheduleConfig.forData())
  {
    public void onMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 1) {
        NavDayNightController.this.notifyDayNightChanged(true);
      }
      while (paramAnonymousMessage.what != 2) {
        return;
      }
      NavDayNightController.this.notifyDayNightChanged(false);
    }
  };
  private List<OnDayNightChangedListener> mListeners = new ArrayList();
  
  public static NavDayNightController getInstance()
  {
    if (sInstance == null) {
      sInstance = new NavDayNightController();
    }
    return sInstance;
  }
  
  private void notifyDayNightChanged(boolean paramBoolean)
  {
    int i = 0;
    while (i < this.mListeners.size())
    {
      if (this.mListeners.get(i) != null) {
        ((OnDayNightChangedListener)this.mListeners.get(i)).onDayNightChanged(paramBoolean);
      }
      i += 1;
    }
  }
  
  public void init()
  {
    BNAutoDayNightHelper.getInstance().addObserver(this.mDayNightChangedObserver);
    BNAutoDayNightHelper.getInstance().updateDayNightMode();
  }
  
  public boolean isDay()
  {
    return this.mDayStyle;
  }
  
  public void registerDayNightListener(OnDayNightChangedListener paramOnDayNightChangedListener)
  {
    if ((paramOnDayNightChangedListener != null) && (!this.mListeners.contains(paramOnDayNightChangedListener))) {
      this.mListeners.add(paramOnDayNightChangedListener);
    }
  }
  
  public void setStyle(boolean paramBoolean)
  {
    try
    {
      BNStyleManager.setDayStyle(paramBoolean);
      this.mDayStyle = paramBoolean;
      MainLooperHandler localMainLooperHandler = this.mHandler;
      if (this.mDayStyle) {}
      for (int i = 1;; i = 2)
      {
        localMainLooperHandler.sendEmptyMessage(i);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public void unregisterDayNightListener(OnDayNightChangedListener paramOnDayNightChangedListener)
  {
    if ((paramOnDayNightChangedListener != null) && (this.mListeners.contains(paramOnDayNightChangedListener))) {
      this.mListeners.remove(paramOnDayNightChangedListener);
    }
  }
  
  public static abstract interface OnDayNightChangedListener
  {
    public abstract void onDayNightChanged(boolean paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/NavDayNightController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */