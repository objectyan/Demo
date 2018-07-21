package com.baidu.navisdk.comapi.commontool;

import android.content.Context;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.db.DBManager;
import com.baidu.navisdk.util.db.DBManager.DBOperateResultCallback;
import com.baidu.navisdk.util.db.model.NaviCurRoutePoiModel;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

public class BNRecoverNaviHelper
{
  private static final String NAVI_FLAG_PREF = "pref_navi_flag";
  private static final String NAVI_KILL_TIME_PREF = "navi_kill_time_pref";
  private static final String TAG = "RecoverNaviHelper";
  private DBManager.DBOperateResultCallback callback = new DBManager.DBOperateResultCallback()
  {
    public void onAddOrDeleteSuccess() {}
    
    public void onQuerySuccess()
    {
      ArrayList localArrayList = NaviCurRoutePoiModel.getInstance().getLastNaviNodesList();
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        RoutePlanNode localRoutePlanNode = null;
        GeoPoint localGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
        if (localGeoPoint != null) {
          localRoutePlanNode = new RoutePlanNode(localGeoPoint, 3, null, null);
        }
        if (localRoutePlanNode != null)
        {
          localArrayList.add(0, localRoutePlanNode);
          if (BNRecoverNaviHelper.this.mStatusListener != null) {
            BNRecoverNaviHelper.this.mStatusListener.onGetNodeList(localArrayList);
          }
        }
      }
      while (BNRecoverNaviHelper.this.mStatusListener == null) {
        return;
      }
      BNRecoverNaviHelper.this.mStatusListener.onGetNodeList(null);
    }
  };
  private boolean mHasInit = false;
  private LastNaviStatusListener mStatusListener = null;
  
  public static BNRecoverNaviHelper getInstance()
  {
    return LazyHolder.sInstance;
  }
  
  public void addLastNaviPointsToDB(ArrayList<RoutePlanNode> paramArrayList)
  {
    if (!this.mHasInit) {
      init();
    }
    LogUtil.e("RecoverNaviHelper", "addLastNaviPointsToDB");
    DBManager.addLastNaviPointsToDB(paramArrayList);
  }
  
  public void checkLastNaviStatus(LastNaviStatusListener paramLastNaviStatusListener)
  {
    if (!this.mHasInit) {
      init();
    }
    this.mStatusListener = paramLastNaviStatusListener;
    DBManager.getLastNaviPointsFromDB(this.callback);
  }
  
  public void clearLastNaviInfo()
  {
    if (!this.mHasInit) {
      init();
    }
    DBManager.clearLastnaviPoints();
  }
  
  public long geKilledTime(Context paramContext)
  {
    if (paramContext == null) {
      return 0L;
    }
    return PreferenceHelper.getInstance(paramContext).getLong("navi_kill_time_pref", 0L);
  }
  
  public boolean getNaviFlag(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    return PreferenceHelper.getInstance(paramContext).getBoolean("pref_navi_flag", false);
  }
  
  public void init()
  {
    try
    {
      boolean bool = this.mHasInit;
      if (!bool) {}
      try
      {
        DBManager.init(BNaviModuleManager.getContext().getApplicationContext());
        this.mHasInit = true;
        LogUtil.e("RecoverNaviHelper", "init db");
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
      }
      return;
    }
    finally {}
  }
  
  public void setKilledTime(Context paramContext, long paramLong)
  {
    if (paramContext == null) {
      return;
    }
    PreferenceHelper.getInstance(paramContext).putLong("navi_kill_time_pref", paramLong);
  }
  
  public void setNaviFlag(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      return;
    }
    PreferenceHelper.getInstance(paramContext).putBoolean("pref_navi_flag", paramBoolean);
  }
  
  public static abstract interface LastNaviStatusListener
  {
    public abstract void onGetNodeList(ArrayList<RoutePlanNode> paramArrayList);
  }
  
  private static class LazyHolder
  {
    private static BNRecoverNaviHelper sInstance = new BNRecoverNaviHelper(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/commontool/BNRecoverNaviHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */