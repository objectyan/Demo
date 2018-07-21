package com.baidu.navi.cruise.control;

import android.app.Activity;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.i.a;
import com.baidu.carlife.util.w;
import com.baidu.navi.cruise.BCruiser;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.comapi.geolocate.ILocationListener;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.ui.cruise.IBCruiserListener;
import com.baidu.navisdk.ui.cruise.model.CruiseUIModel;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.logic.BNExtGPSLocationManager;
import com.baidu.navisdk.util.logic.BNLocationManager;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import java.util.Timer;
import java.util.TimerTask;

public class EnterQuitLogicManager
{
  private static final float ENTER_CRUISE_COND_SPEED = 10.0F;
  private static int FIRST_DETECT_TIMER_DELAY = 20000;
  public static final int GPS_NETWORK_DETECT_DELAY_TIME = 10000;
  private static final int REPEAT_DETECT_TIMER_DELAY = 1000;
  private static EnterQuitLogicManager mInstance;
  private Activity mActivity;
  private IBCruiserListener mBCruiserListener;
  private NaviFragmentManager mFragmentManager;
  private ILocationListener mLocationListener = new ILocationListener()
  {
    public void onGpsStatusChange(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2) {}
    
    public void onLocationChange(LocData paramAnonymousLocData)
    {
      if ((paramAnonymousLocData != null) && (paramAnonymousLocData.isValid()))
      {
        float f = paramAnonymousLocData.speed * 3600.0F / 1000.0F;
        if (f > EnterQuitLogicManager.this.mMaxSpeed) {
          EnterQuitLogicManager.access$402(EnterQuitLogicManager.this, f);
        }
      }
    }
    
    public void onWGS84LocationChange(LocData paramAnonymousLocData1, LocData paramAnonymousLocData2) {}
  };
  private BNLocationManager mLocationManager;
  private float mMaxSpeed = 0.0F;
  private Timer mTimer;
  private TimerTask mTimerTask;
  
  private void abandonGPS()
  {
    if ((this.mLocationManager != null) && (this.mLocationListener != null)) {
      this.mLocationManager.removeLocationListener(this.mLocationListener);
    }
  }
  
  private void clearSpeed()
  {
    this.mMaxSpeed = 0.0F;
  }
  
  private void enterCruiseFollowFragment()
  {
    if ((this.mFragmentManager == null) || (this.mFragmentManager.getCurrentFragmentType() != 17)) {}
    while (this.mActivity == null) {
      return;
    }
    new Handler(this.mActivity.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        w.a(StyleManager.getString(2131296402), 0);
        StatisticManager.onEvent("NAVI_0007");
        EnterQuitLogicManager.this.mFragmentManager.showFragment(116, null);
      }
    });
  }
  
  public static EnterQuitLogicManager getmInstance()
  {
    if (mInstance == null) {
      mInstance = new EnterQuitLogicManager();
    }
    return mInstance;
  }
  
  private boolean isCarMoving()
  {
    return this.mMaxSpeed >= 10.0F;
  }
  
  private boolean isEnterCriseFollowMode()
  {
    boolean bool2 = true;
    boolean bool1;
    if ((!isGPSDectectingSucess()) || (!isCarMoving())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (isNetworkAvailable());
      bool1 = bool2;
    } while (isOffLineDataAvailable());
    return false;
  }
  
  private void quitCruiseFollowFragment()
  {
    if (h.a().getCurrentFragmentType() == 116)
    {
      abandonGPS();
      if (this.mBCruiserListener != null) {
        this.mBCruiserListener.onPageJump(1, Integer.valueOf(0));
      }
    }
  }
  
  private void startTimer(int paramInt)
  {
    clearSpeed();
    stopTimer();
    reInitLocationService();
    try
    {
      this.mTimer = new Timer();
      this.mTimerTask = new TimerTask()
      {
        public void run()
        {
          if (EnterQuitLogicManager.this.isEnterCriseFollowMode())
          {
            EnterQuitLogicManager.this.stopTimer();
            EnterQuitLogicManager.this.enterCruiseFollowFragment();
            return;
          }
          EnterQuitLogicManager.this.startTimer(1000);
        }
      };
      this.mTimer.schedule(this.mTimerTask, paramInt);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public String cruiseEnterPromptTransfer(String paramString)
  {
    String str = paramString;
    if (h.a().getCurrentFragmentType() == 116)
    {
      str = paramString;
      if (paramString.equals(StyleManager.getString(2131296401))) {
        str = "";
      }
    }
    return str;
  }
  
  public void enterCruiseFollowModeDetect()
  {
    try
    {
      startTimer(FIRST_DETECT_TIMER_DELAY);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isGPSDectectingSucess()
  {
    if ((a.a().b()) && (BNExtGPSLocationManager.getInstance().isGpsEnabled()) && (BNExtGPSLocationManager.getInstance().isGpsAvailable())) {
      return true;
    }
    return BNSysLocationManager.getInstance().isGpsAvailable();
  }
  
  public boolean isNetworkAvailable()
  {
    return NetworkUtils.isNetworkAvailable(this.mActivity);
  }
  
  public boolean isOffLineDataAvailable()
  {
    BCruiser.getInstance().checkCurrentProvinceDataDownloaded();
    return CruiseUIModel.getInstance().isProvinceDataDownloaded();
  }
  
  public void quitCruiseFollowMode()
  {
    try
    {
      stopTimer();
      quitCruiseFollowFragment();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void reInitLocationService()
  {
    abandonGPS();
    if ((a.a().b()) && (BNExtGPSLocationManager.getInstance().isGpsEnabled()) && (BNExtGPSLocationManager.getInstance().isGpsAvailable())) {}
    for (this.mLocationManager = BNExtGPSLocationManager.getInstance();; this.mLocationManager = BNSysLocationManager.getInstance())
    {
      this.mMaxSpeed = 0.0F;
      this.mLocationManager.addLocationListener(this.mLocationListener);
      return;
    }
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public void setListener(IBCruiserListener paramIBCruiserListener)
  {
    this.mBCruiserListener = paramIBCruiserListener;
  }
  
  public void setNaviFragmentManager(NaviFragmentManager paramNaviFragmentManager)
  {
    this.mFragmentManager = paramNaviFragmentManager;
  }
  
  public void showTost(String paramString, int paramInt)
  {
    if (this.mActivity != null) {
      Toast.makeText(this.mActivity, paramString, paramInt).show();
    }
  }
  
  public void stopTimer()
  {
    try
    {
      if (this.mTimer != null)
      {
        this.mTimer.cancel();
        this.mTimer = null;
      }
      if (this.mTimerTask != null)
      {
        this.mTimerTask.cancel();
        this.mTimerTask = null;
      }
      return;
    }
    finally {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/cruise/control/EnterQuitLogicManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */