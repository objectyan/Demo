package com.baidu.navi.controller;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.baidunavis.control.NavPoiController;
import com.baidu.baidunavis.control.NavRouteGuideController;
import com.baidu.carlife.core.screen.e;
import com.baidu.navi.fragment.ContentFragmentManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.utils.StatisticUtils;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import java.util.ArrayList;

public class QuickRoutePlanController
{
  private static final String TAG = "QuickRoute";
  public static int TYPE_COMPANY_ROUTE_COND = 2;
  public static int TYPE_HOME_AND_COMPANY_ROUTE_COND = 3;
  public static int TYPE_HOME_ROUTE_COND = 1;
  private Handler calcRouteHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 4: 
        do
        {
          return;
          BNRoutePlaner.getInstance().removeRouteResultHandler(QuickRoutePlanController.this.calcRouteHandler);
          paramAnonymousMessage = (RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel");
        } while ((paramAnonymousMessage == null) || (QuickRoutePlanController.this.mRouteInfoCallback == null));
        QuickRoutePlanController.this.mRouteInfoCallback.onSuccess(paramAnonymousMessage.getTotalTime(), paramAnonymousMessage.getDistance());
        return;
      }
      BNRoutePlaner.getInstance().removeRouteResultHandler(QuickRoutePlanController.this.calcRouteHandler);
    }
  };
  public Context mContext;
  private QuickFragmentListener mListener;
  private ContentFragmentManager mNaviFragmentManager;
  private e mOnDialogListener;
  private Handler mRPHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      case 3: 
      case 6: 
      default: 
        return;
      case 4: 
        QuickRoutePlanController.this.mNaviFragmentManager.showFragment(52, null);
        BNRoutePlaner.getInstance().removeRouteResultHandler(QuickRoutePlanController.this.mRPHandler);
        return;
      case 7: 
        BNRoutePlaner.getInstance().removeRouteResultHandler(QuickRoutePlanController.this.mRPHandler);
        QuickRoutePlanController.this.mListener.onRefreshHistoryList();
        return;
      case 36: 
        QuickRoutePlanController.this.mListener.onRefreshHistoryList();
        return;
      }
      BNRoutePlaner.getInstance().removeRouteResultHandler(QuickRoutePlanController.this.mRPHandler);
      QuickRoutePlanController.this.mListener.onRefreshHistoryList();
    }
  };
  private AsyncGetRouteInfoCallback mRouteInfoCallback;
  
  public QuickRoutePlanController(Context paramContext, QuickFragmentListener paramQuickFragmentListener, ContentFragmentManager paramContentFragmentManager, e parame)
  {
    this.mContext = paramContext;
    this.mListener = paramQuickFragmentListener;
    this.mNaviFragmentManager = paramContentFragmentManager;
    this.mOnDialogListener = parame;
  }
  
  public void addRouteResultObserver()
  {
    BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
  }
  
  public void asyncGetRouteInfo(RoutePlanNode paramRoutePlanNode, AsyncGetRouteInfoCallback paramAsyncGetRouteInfoCallback)
  {
    this.mRouteInfoCallback = paramAsyncGetRouteInfoCallback;
    NavRouteGuideController.getInstance().setBNavigatorListener(null);
    NavRouteGuideController.getInstance().setIsThirdServer(false);
    if (paramRoutePlanNode != null) {
      setDestCalcRoute(paramRoutePlanNode, this.calcRouteHandler);
    }
  }
  
  public void delCompAddress()
  {
    if (AddressSettingModel.removeCompAddress(this.mContext))
    {
      this.mListener.showToast(2131296414);
      return;
    }
    this.mListener.showToast(2131296413);
  }
  
  public void delHomeAddress()
  {
    if (AddressSettingModel.removeHomeAddress(this.mContext))
    {
      this.mListener.showToast(2131296416);
      return;
    }
    this.mListener.showToast(2131296415);
  }
  
  public RoutePlanNode getCompAddress()
  {
    return AddressSettingModel.getCompAddrNode(this.mContext);
  }
  
  public int getCompCityId()
  {
    return AddressSettingModel.getCompCityId(this.mContext);
  }
  
  public String getCompDescription()
  {
    return AddressSettingModel.getCompName(this.mContext);
  }
  
  public RoutePlanNode getHomeAddress()
  {
    return AddressSettingModel.getHomeAddrNode(this.mContext);
  }
  
  public int getHomeCityId()
  {
    return AddressSettingModel.getHomeCityId(this.mContext);
  }
  
  public String getHomeDescription()
  {
    return AddressSettingModel.getHomeName(this.mContext);
  }
  
  public void goCompNavi()
  {
    if (hasSetCompAddr())
    {
      startRoutePlan(getCompAddress());
      StatisticUtils.statSetDestFromQuickLink();
      StatisticManager.onEvent("410034", "410034");
      return;
    }
    this.mListener.showSetCompAddrDialog();
    StatisticManager.onEvent("410035", "410035");
  }
  
  public void goHomeNavi()
  {
    if (hasSetHomeAddr())
    {
      startRoutePlan(getHomeAddress());
      StatisticUtils.statSetDestFromQuickLink();
      StatisticManager.onEvent("410031", "410031");
      return;
    }
    this.mListener.showSetHomeAddrDialog();
    StatisticManager.onEvent("410032", "410032");
  }
  
  public void goSettingFragment(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("from_Fragment", 49);
    localBundle.putInt("select_point_action", paramInt);
    this.mNaviFragmentManager.showFragment(51, localBundle);
  }
  
  public boolean hasSetCompAddr()
  {
    return AddressSettingModel.hasSetCompAddr(this.mContext);
  }
  
  public boolean hasSetHomeAddr()
  {
    return AddressSettingModel.hasSetHomeAddr(this.mContext);
  }
  
  public void removeCalcRouteHandler()
  {
    BNRoutePlaner.getInstance().removeRouteResultHandler(this.calcRouteHandler);
  }
  
  public void removeRouteResultObserver()
  {
    BNRoutePlaner.getInstance().removeRouteResultHandler(this.mRPHandler);
  }
  
  public void setCompCityId(int paramInt)
  {
    AddressSettingModel.setCompCityId(this.mContext, paramInt);
  }
  
  public void setDestCalcRoute(RoutePlanNode paramRoutePlanNode, Handler paramHandler)
  {
    BNRoutePlaner.getInstance().cancleCalcRouteRequest();
    BNRoutePlaner.getInstance().clearRouteInfoHandler();
    BNRoutePlaner.getInstance().addRouteResultHandler(paramHandler);
    paramHandler = new ArrayList(2);
    paramHandler.add(BNLocationManagerProxy.getInstance().getCurLocationNode());
    paramHandler.add(paramRoutePlanNode);
    BNRoutePlaner.getInstance().setPointsToCalcRoute(paramHandler, 0);
  }
  
  public void setHomeCityId(int paramInt)
  {
    AddressSettingModel.setHomeCityId(this.mContext, paramInt);
  }
  
  public void startRoutePlan(RoutePlanNode paramRoutePlanNode)
  {
    NavPoiController.getInstance().startCalcRoute(paramRoutePlanNode);
  }
  
  public static abstract interface AsyncGetRouteInfoCallback
  {
    public abstract void onSuccess(String paramString1, String paramString2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/controller/QuickRoutePlanController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */