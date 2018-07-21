package com.baidu.baidunavis.control;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.model.NavRoutePlanModel;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlanObserver.FailArg;
import com.baidu.navisdk.ui.widget.RoutePlanObserver;
import com.baidu.navisdk.ui.widget.RoutePlanObserver.IJumpToDownloadListener;

public class NavRoutePlanObserver
  extends RoutePlanObserver
{
  private static final String TAG = NavRoutePlanObserver.class.getSimpleName();
  public boolean isDirectlyEnterNavPage = false;
  
  public NavRoutePlanObserver(Activity paramActivity, RoutePlanObserver.IJumpToDownloadListener paramIJumpToDownloadListener)
  {
    super(paramActivity, paramIJumpToDownloadListener);
  }
  
  public void update(BNSubject paramBNSubject, int paramInt1, int paramInt2, Object paramObject)
  {
    if ((paramInt1 == 1) && (paramInt2 == 1) && (this.isDirectlyEnterNavPage)) {
      NavLogUtils.e(TAG, "update()  isDirectlyEnterNavPage true");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!NavSearchController.getInstance().isFromMap()) {
              super.update(paramBNSubject, paramInt1, paramInt2, paramObject);
            }
          } while (paramInt1 != 1);
          switch (paramInt2)
          {
          case 22: 
          case 23: 
          default: 
            return;
          case 3: 
            NavLogUtils.e(TAG, "update()  EVENT_RP_FAIL");
            NavCommonFuncModel.getInstance().mNaviEndTime = SystemClock.elapsedRealtime();
            NavLogUtils.e("route_plan_time", "failed.navi_time=" + (NavCommonFuncModel.getInstance().mNaviEndTime - NavCommonFuncModel.getInstance().mNaviStartTime) + "ms");
            if ((paramObject != null) && ((paramObject instanceof BNRoutePlanObserver.FailArg))) {
              NavRoutePlanModel.getInstance().mRoutePlanResultFailedType = ((BNRoutePlanObserver.FailArg)paramObject).mFailType;
            }
            break;
          }
        } while (BaiduNaviManager.getInstance().getMapHandler() == null);
        BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1031).sendToTarget();
        return;
        NavLogUtils.e(TAG, "update()  EVENT_GENERAL_FAIL");
        NavCommonFuncModel.getInstance().mNaviEndTime = SystemClock.elapsedRealtime();
        NavLogUtils.e("route_plan_time", "failed.navi_time=" + (NavCommonFuncModel.getInstance().mNaviEndTime - NavCommonFuncModel.getInstance().mNaviStartTime) + "ms");
        paramInt2 = -1;
        paramInt1 = paramInt2;
        if (paramObject != null)
        {
          paramInt1 = paramInt2;
          if ((paramObject instanceof BNRoutePlanObserver.FailArg))
          {
            paramInt1 = ((BNRoutePlanObserver.FailArg)paramObject).mFailType;
            NavRoutePlanModel.getInstance().mRoutePlanResultFailedType = paramInt1;
          }
        }
      } while ((paramInt1 < 0) || (BaiduNaviManager.getInstance().getMapHandler() == null));
      paramBNSubject = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1003);
      paramBNSubject.arg1 = paramInt1;
      paramBNSubject.sendToTarget();
      return;
      NavLogUtils.e(TAG, "update()  EVENT_ENGINE_FAIL");
      NavCommonFuncModel.getInstance().mNaviEndTime = SystemClock.elapsedRealtime();
      NavLogUtils.e("route_plan_time", "failed.navi_time=" + (NavCommonFuncModel.getInstance().mNaviEndTime - NavCommonFuncModel.getInstance().mNaviStartTime) + "ms");
      paramInt2 = -1;
      paramInt1 = paramInt2;
      if (paramObject != null)
      {
        paramInt1 = paramInt2;
        if ((paramObject instanceof BNRoutePlanObserver.FailArg))
        {
          paramInt1 = ((BNRoutePlanObserver.FailArg)paramObject).mFailType;
          NavRoutePlanModel.getInstance().mRoutePlanResultFailedType = paramInt1;
        }
      }
    } while ((paramInt1 < 0) || (BaiduNaviManager.getInstance().getMapHandler() == null));
    paramBNSubject = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1003);
    paramBNSubject.arg1 = paramInt1;
    paramBNSubject.sendToTarget();
    return;
    NavCommonFuncModel.getInstance().mNaviEndTime = SystemClock.elapsedRealtime();
    NavLogUtils.e("route_plan_time", "failed.navi_time=" + (NavCommonFuncModel.getInstance().mNaviEndTime - NavCommonFuncModel.getInstance().mNaviStartTime) + "ms");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/NavRoutePlanObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */