package com.baidu.navisdk.comapi.commontool;

import android.os.Handler;
import android.os.Looper;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.commontool.sunrisedown.BNSunRiseDownTimeHelper;
import com.baidu.navisdk.comapi.commontool.sunrisedown.BNSunRiseDownTimeHelper.SunRiseDownHM;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.naviresult.BNNaviResultController;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.subview.util.RightHandResourcesProvider;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class BNAutoDayNightHelper
  extends BNSubject
{
  private static Timer mDayNightTimer = null;
  private static BNAutoDayNightHelper mInstance;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private boolean mIsTimerStart;
  private Object mRunLock = new Object();
  
  private boolean getDayNightMode()
  {
    Object localObject2 = BNSunRiseDownTimeHelper.getIntanse().calulatetm(39.92D, 116.46D);
    GeoPoint localGeoPoint = GeoLocateModel.getInstance().getLastGeoPoint();
    Object localObject1;
    if (RightHandResourcesProvider.getEnNaviType() == 1)
    {
      localObject1 = localObject2;
      if (localGeoPoint != null)
      {
        localObject1 = BNSunRiseDownTimeHelper.getIntanse().calulatetm(localGeoPoint.getLatitudeE6() / 100000, localGeoPoint.getLongitudeE6() / 100000);
        BNSunRiseDownTimeHelper.getIntanse().updateInternationalTimeZone((BNSunRiseDownTimeHelper.SunRiseDownHM)localObject1);
      }
    }
    for (;;)
    {
      long l1 = System.currentTimeMillis();
      localObject2 = Calendar.getInstance();
      ((Calendar)localObject2).set(11, ((BNSunRiseDownTimeHelper.SunRiseDownHM)localObject1).getDownHour());
      ((Calendar)localObject2).set(12, ((BNSunRiseDownTimeHelper.SunRiseDownHM)localObject1).getDownMin());
      long l2 = ((Calendar)localObject2).getTimeInMillis();
      ((Calendar)localObject2).set(11, ((BNSunRiseDownTimeHelper.SunRiseDownHM)localObject1).getRiseHour());
      ((Calendar)localObject2).set(12, ((BNSunRiseDownTimeHelper.SunRiseDownHM)localObject1).getRiseMin());
      if ((l1 <= ((Calendar)localObject2).getTimeInMillis()) || (l1 >= l2)) {
        break;
      }
      return true;
      localObject1 = localObject2;
      if (localGeoPoint != null)
      {
        localObject1 = localObject2;
        if (localGeoPoint.getLatitudeE6() > 0)
        {
          localObject1 = localObject2;
          if (localGeoPoint.getLongitudeE6() > 0) {
            localObject1 = BNSunRiseDownTimeHelper.getIntanse().calulatetm(localGeoPoint.getLatitudeE6() / 100000, localGeoPoint.getLongitudeE6() / 100000);
          }
        }
      }
    }
    return false;
  }
  
  private boolean getDayNightModeFinal()
  {
    int i = BNSettingManager.getNaviDayAndNightMode();
    if ((i == 2) || (i == 4)) {
      if (isTimerStart()) {
        stopDayNightTimer();
      }
    }
    do
    {
      return true;
      if ((i == 3) || (i == 5))
      {
        if (isTimerStart()) {
          stopDayNightTimer();
        }
        return false;
      }
    } while (i != 1);
    if (!isTimerStart()) {
      startDayNightTimer();
    }
    return getDayNightMode();
  }
  
  public static BNAutoDayNightHelper getInstance()
  {
    if (mInstance == null) {
      mInstance = new BNAutoDayNightHelper();
    }
    return mInstance;
  }
  
  private void notifyDayNightObservers(final int paramInt1, final int paramInt2, final Object paramObject)
  {
    synchronized (this.mRunLock)
    {
      this.mRunLock.notifyAll();
      BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("notifyDayNightObservers-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNAutoDayNightHelper.this.notifyObservers(paramInt1, paramInt2, paramObject);
          return null;
        }
      }, new BNWorkerConfig(100, 0));
      return;
    }
  }
  
  public boolean isTimerStart()
  {
    return this.mIsTimerStart;
  }
  
  public void startDayNightTimer()
  {
    if (mDayNightTimer == null) {}
    try
    {
      mDayNightTimer = new Timer(getClass().getSimpleName() + "_daynight", true);
      mDayNightTimer.schedule(new TimerTask()
      {
        public void run()
        {
          LogUtil.e("TIMER", "Timer task get time to set navi mode");
          BNAutoDayNightHelper.this.switchDayNightMode();
        }
      }, 0L, 600000L);
      this.mIsTimerStart = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      mDayNightTimer = null;
    }
  }
  
  public void stopDayNightTimer()
  {
    if (mDayNightTimer == null) {
      return;
    }
    mDayNightTimer.cancel();
    mDayNightTimer = null;
    this.mIsTimerStart = false;
  }
  
  public void switchDayNightMode()
  {
    Object localObject2 = BNSunRiseDownTimeHelper.getIntanse().calulatetm(39.92D, 116.46D);
    GeoPoint localGeoPoint = GeoLocateModel.getInstance().getLastGeoPoint();
    Object localObject1;
    if (RightHandResourcesProvider.getEnNaviType() == 1)
    {
      localObject1 = localObject2;
      if (localGeoPoint != null)
      {
        localObject1 = BNSunRiseDownTimeHelper.getIntanse().calulatetm(localGeoPoint.getLatitudeE6() / 100000, localGeoPoint.getLongitudeE6() / 100000);
        BNSunRiseDownTimeHelper.getIntanse().updateInternationalTimeZone((BNSunRiseDownTimeHelper.SunRiseDownHM)localObject1);
      }
    }
    for (;;)
    {
      long l1 = System.currentTimeMillis();
      localObject2 = Calendar.getInstance();
      ((Calendar)localObject2).set(11, ((BNSunRiseDownTimeHelper.SunRiseDownHM)localObject1).getDownHour());
      ((Calendar)localObject2).set(12, ((BNSunRiseDownTimeHelper.SunRiseDownHM)localObject1).getDownMin());
      long l2 = ((Calendar)localObject2).getTimeInMillis();
      ((Calendar)localObject2).set(11, ((BNSunRiseDownTimeHelper.SunRiseDownHM)localObject1).getRiseHour());
      ((Calendar)localObject2).set(12, ((BNSunRiseDownTimeHelper.SunRiseDownHM)localObject1).getRiseMin());
      if ((l1 <= ((Calendar)localObject2).getTimeInMillis()) || (l1 >= l2)) {
        break;
      }
      i = 2;
      if (BNavigator.getInstance().isNaviBegin()) {
        i = 4;
      }
      try
      {
        boolean bool = BNNaviResultController.getInstance().isNaviResultShowing();
        if (bool) {
          i = 2;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;) {}
      }
      notifyDayNightObservers(1, i, null);
      return;
      localObject1 = localObject2;
      if (localGeoPoint != null)
      {
        localObject1 = localObject2;
        if (localGeoPoint.getLatitudeE6() > 0)
        {
          localObject1 = localObject2;
          if (localGeoPoint.getLongitudeE6() > 0) {
            localObject1 = BNSunRiseDownTimeHelper.getIntanse().calulatetm(localGeoPoint.getLatitudeE6() / 100000, localGeoPoint.getLongitudeE6() / 100000);
          }
        }
      }
    }
    int i = 3;
    if (BNavigator.getInstance().isNaviBegin()) {
      i = 5;
    }
    if (BNNaviResultController.getInstance().isNaviResultShowing()) {
      i = 2;
    }
    notifyDayNightObservers(1, i, null);
  }
  
  public void updateDayNightMode()
  {
    if (getDayNightModeFinal())
    {
      i = 2;
      if (BNavigator.getInstance().isNaviBegin()) {
        i = 4;
      }
      if (BNNaviResultController.getInstance().isNaviResultShowing()) {
        i = 2;
      }
      notifyDayNightObservers(1, i, null);
      return;
    }
    int i = 3;
    if (BNavigator.getInstance().isNaviBegin()) {
      i = 5;
    }
    if (BNNaviResultController.getInstance().isNaviResultShowing()) {
      i = 2;
    }
    notifyDayNightObservers(1, i, null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/commontool/BNAutoDayNightHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */