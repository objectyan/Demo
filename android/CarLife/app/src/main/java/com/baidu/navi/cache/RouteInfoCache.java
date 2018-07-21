package com.baidu.navi.cache;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.NavRouteGuideController;
import com.baidu.baidunavis.model.NavGeoPoint;
import com.baidu.baidunavis.model.RouteNode;
import com.baidu.entity.pb.Mrtl;
import com.baidu.entity.pb.Mrtl.Content;
import com.baidu.entity.pb.Mrtl.Content.Route;
import com.baidu.entity.pb.MultiNavi;
import com.baidu.entity.pb.NaviContent;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.basic.BMExecutorsManager;
import com.baidu.platform.comjni.tools.ProtobufUtils;
import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

public final class RouteInfoCache
{
  public static final String COMPANY_TYPE = "company";
  public static final String HOME_TYPE = "home";
  private static final double MAX_DISTANCE = 50000.0D;
  public static final int NUM_100 = 100;
  public static final int NUM_1000 = 1000;
  private static final int RETCODE_OK = 0;
  private Handler companyInfoHandler = new Handler(Looper.getMainLooper())
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
          BNRoutePlaner.getInstance().removeRouteResultHandler(RouteInfoCache.this.companyInfoHandler);
          paramAnonymousMessage = (RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel");
          if (paramAnonymousMessage != null)
          {
            RouteInfoCache.access$902(RouteInfoCache.this, paramAnonymousMessage.getTotalTimeInt());
            RouteInfoCache.access$1002(RouteInfoCache.this, paramAnonymousMessage.getTotalDistanceInt());
            RouteInfoCache.access$1302(RouteInfoCache.this, paramAnonymousMessage.getTotalTime());
            RouteInfoCache.access$1402(RouteInfoCache.this, paramAnonymousMessage.getDistance());
            RouteInfoCache.access$1502(RouteInfoCache.this, System.currentTimeMillis());
          }
        } while (RouteInfoCache.this.mCallback == null);
        RouteInfoCache.this.mCallback.onCompanyInfo(RouteInfoCache.this.mCompanyTime, RouteInfoCache.this.mCompanyDistance);
        return;
      }
      BNRoutePlaner.getInstance().removeRouteResultHandler(RouteInfoCache.this.companyInfoHandler);
    }
  };
  private Handler homeInfoHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 4: 
      case 7: 
        do
        {
          do
          {
            return;
            BNRoutePlaner.getInstance().removeRouteResultHandler(RouteInfoCache.this.homeInfoHandler);
            paramAnonymousMessage = (RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel");
            if (paramAnonymousMessage != null)
            {
              RouteInfoCache.access$202(RouteInfoCache.this, paramAnonymousMessage.getTotalTimeInt());
              RouteInfoCache.access$302(RouteInfoCache.this, paramAnonymousMessage.getTotalDistanceInt());
              RouteInfoCache.access$402(RouteInfoCache.this, paramAnonymousMessage.getTotalTime());
              RouteInfoCache.access$502(RouteInfoCache.this, paramAnonymousMessage.getDistance());
              RouteInfoCache.access$602(RouteInfoCache.this, System.currentTimeMillis());
            }
            if (RouteInfoCache.this.mCallback != null) {
              RouteInfoCache.this.mCallback.onHomeInfo(RouteInfoCache.this.mHomeTime, RouteInfoCache.this.mHomeDistance);
            }
          } while ((RouteInfoCache.this.mCompanyNode == null) || ((RouteInfoCache.this.mCompanyTimeInt != 0) && (RouteInfoCache.this.mCompanyDistanceInt != 0)));
          RouteInfoCache.this.asynGetCompanyInfo();
          return;
          BNRoutePlaner.getInstance().removeRouteResultHandler(RouteInfoCache.this.homeInfoHandler);
        } while ((RouteInfoCache.this.mCompanyNode == null) || ((RouteInfoCache.this.mCompanyTimeInt != 0) && (RouteInfoCache.this.mCompanyDistanceInt != 0)));
        RouteInfoCache.this.asynGetCompanyInfo();
        return;
      }
      BNRoutePlaner.getInstance().removeRouteResultHandler(RouteInfoCache.this.homeInfoHandler);
    }
  };
  private Callback mCallback;
  private String mCompanyDistance = "";
  private int mCompanyDistanceInt = 0;
  private RoutePlanNode mCompanyNode = null;
  private String mCompanyTime = "";
  private int mCompanyTimeInt = 0;
  private long mCompanyTimestamp = 0L;
  private GeoPoint mCurrentPoint;
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  private String mHomeDistance = "";
  private int mHomeDistanceInt = 0;
  private RoutePlanNode mHomeNode = null;
  private String mHomeTime = "";
  private int mHomeTimeInt = 0;
  private long mHomeTimestamp = 0L;
  
  private void asynGetCompanyInfo()
  {
    resetCompanyInfo(this.mCompanyNode);
    BMExecutorsManager.SINGLE_EXECUTOR_SERVICE.execute(new Runnable()
    {
      public void run()
      {
        if ((RouteInfoCache.this.mCompanyNode == null) || (RouteInfoCache.this.mCompanyNode.mGeoPoint == null)) {
          return;
        }
        RouteNode localRouteNode = NavMapAdapter.getInstance().getRouteNode(NavMapAdapter.getInstance().getGeoPoint(null, true), "我的位置", null);
        localRouteNode.mFromType = 3;
        RouteInfoCache.this.getRouteTraffic(RouteInfoCache.access$1700(RouteInfoCache.this, "company"), localRouteNode, RouteInfoCache.access$1800(RouteInfoCache.this, RouteInfoCache.this.mCompanyNode), "company");
      }
    });
  }
  
  private void asynGetHomeInfo()
  {
    resetHomeInfo(this.mHomeNode);
    BMExecutorsManager.SINGLE_EXECUTOR_SERVICE.execute(new Runnable()
    {
      public void run()
      {
        if ((RouteInfoCache.this.mHomeNode == null) || (RouteInfoCache.this.mHomeNode.mGeoPoint == null)) {
          return;
        }
        RouteNode localRouteNode = NavMapAdapter.getInstance().getRouteNode(NavMapAdapter.getInstance().getGeoPoint(null, true), "我的位置", null);
        localRouteNode.mFromType = 3;
        RouteInfoCache.this.getRouteTraffic(RouteInfoCache.access$1700(RouteInfoCache.this, "home"), localRouteNode, RouteInfoCache.access$1800(RouteInfoCache.this, RouteInfoCache.this.mHomeNode), "home");
      }
    });
  }
  
  private void asynGetRouteInfo(RoutePlanNode paramRoutePlanNode, Handler paramHandler)
  {
    NavRouteGuideController.getInstance().setBNavigatorListener(null);
    NavRouteGuideController.getInstance().setIsThirdServer(false);
    setDestCalcRoute(paramRoutePlanNode, paramHandler);
  }
  
  private RouteNode coverRoutePlanNodeToRouteNode(RoutePlanNode paramRoutePlanNode)
  {
    NavGeoPoint localNavGeoPoint = new NavGeoPoint(paramRoutePlanNode.mGeoPoint.getLongitudeE6(), paramRoutePlanNode.mGeoPoint.getLatitudeE6());
    return NavMapAdapter.getInstance().getRouteNode(localNavGeoPoint, paramRoutePlanNode.mName, paramRoutePlanNode.mUID);
  }
  
  public static String formatTimeString(int paramInt)
  {
    return formatTimeString(paramInt, false);
  }
  
  public static String formatTimeString(int paramInt, boolean paramBoolean)
  {
    String str2 = "";
    String str3 = "";
    String str1 = "";
    int i = paramInt;
    int j = i / 86400;
    paramInt = i;
    if (j > 0)
    {
      str2 = String.format("%d天", new Object[] { Integer.valueOf(j) });
      paramInt = i % 86400;
    }
    int k = paramInt / 3600;
    i = paramInt;
    if (k > 0)
    {
      str3 = String.format("%d小时", new Object[] { Integer.valueOf(k) });
      i = paramInt % 3600;
    }
    i /= 60;
    paramInt = i;
    if (j == 0)
    {
      paramInt = i;
      if (k == 0)
      {
        paramInt = i;
        if (i == 0) {
          paramInt = 1;
        }
      }
    }
    if (j > 0) {
      paramInt = 0;
    }
    if (paramInt > 0) {
      if ((k <= 0) || (paramBoolean)) {
        break label178;
      }
    }
    label178:
    for (str1 = String.format("%d分", new Object[] { Integer.valueOf(paramInt) });; str1 = String.format("%d分钟", new Object[] { Integer.valueOf(paramInt) })) {
      return str2 + str3 + str1;
    }
  }
  
  private double getDistance(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    double d1 = paramGeoPoint1.getLongitudeE6() - paramGeoPoint2.getLongitudeE6();
    double d2 = paramGeoPoint1.getLatitudeE6() - paramGeoPoint2.getLatitudeE6();
    return Math.sqrt(d1 * d1 + d2 * d2);
  }
  
  public static String getDistanceString(int paramInt)
  {
    if (paramInt < 1000) {
      return String.format("%d米", new Object[] { Integer.valueOf(paramInt) });
    }
    if (paramInt % 1000 == 0) {
      return String.format("%d公里", new Object[] { Integer.valueOf(paramInt / 1000) });
    }
    return String.format("%d.%d公里", new Object[] { Integer.valueOf(paramInt / 1000), Integer.valueOf(paramInt % 1000 / 100) });
  }
  
  private int getFromType(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (TextUtils.equals(paramString, "home")) {
        return 0;
      }
      if (TextUtils.equals(paramString, "company")) {
        return 1;
      }
    }
    return 2;
  }
  
  public static RouteInfoCache getInstance()
  {
    return InstanceHolder.INSTANCE;
  }
  
  private void getRouteTraffic(int paramInt, RouteNode paramRouteNode1, RouteNode paramRouteNode2, String paramString)
  {
    Bundle localBundle = BaiduNaviManager.getInstance().getHomeAndCompanyRouteInfo(paramRouteNode1, paramRouteNode2, paramInt, 1);
    paramRouteNode2 = null;
    paramRouteNode1 = paramRouteNode2;
    if (localBundle != null)
    {
      paramRouteNode1 = paramRouteNode2;
      if (localBundle.containsKey("pb_data")) {
        paramRouteNode1 = parseTrafficResult(localBundle.getByteArray("pb_data"), paramString);
      }
    }
    if ((paramRouteNode1 == null) || (paramRouteNode1.getContentCount() == 0)) {}
    do
    {
      do
      {
        return;
        paramRouteNode1 = paramRouteNode1.getContent(0);
      } while ((paramRouteNode1 == null) || (TextUtils.isEmpty(paramRouteNode1.getLabel())) || (paramRouteNode1.getRetCode() != 0));
      if (paramRouteNode1.getLabel().equals("home"))
      {
        paramRouteNode2 = paramRouteNode1.getRoute();
        this.mHomeDistanceInt = paramRouteNode2.getDistance();
        this.mHomeTimeInt = paramRouteNode2.getDuration();
        this.mHomeDistance = getDistanceString(this.mHomeDistanceInt);
        this.mHomeTime = formatTimeString(this.mHomeTimeInt);
        this.mHomeTimestamp = System.currentTimeMillis();
        this.mHandler.post(new Runnable()
        {
          public void run()
          {
            if (RouteInfoCache.this.mCallback != null) {
              RouteInfoCache.this.mCallback.onHomeInfo(RouteInfoCache.this.mHomeTime, RouteInfoCache.this.mHomeDistance);
            }
          }
        });
      }
    } while (!paramRouteNode1.getLabel().equals("company"));
    paramRouteNode1 = paramRouteNode1.getRoute();
    this.mCompanyDistanceInt = paramRouteNode1.getDistance();
    this.mCompanyTimeInt = paramRouteNode1.getDuration();
    this.mCompanyDistance = getDistanceString(this.mCompanyDistanceInt);
    this.mCompanyTime = formatTimeString(this.mCompanyTimeInt);
    this.mCompanyTimestamp = System.currentTimeMillis();
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (RouteInfoCache.this.mCallback != null) {
          RouteInfoCache.this.mCallback.onCompanyInfo(RouteInfoCache.this.mCompanyTime, RouteInfoCache.this.mCompanyDistance);
        }
      }
    });
  }
  
  private boolean isPointValid()
  {
    GeoPoint localGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
    if ((this.mCurrentPoint != null) && (getDistance(localGeoPoint, this.mCurrentPoint) <= 200.0D)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mCurrentPoint = localGeoPoint;
      return bool;
    }
  }
  
  private Mrtl parseTrafficResult(byte[] paramArrayOfByte, String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Iterator localIterator = null;
    try
    {
      paramArrayOfByte = ProtobufUtils.getMessageLiteList(paramArrayOfByte);
      if (paramArrayOfByte != null)
      {
        localIterator = paramArrayOfByte.iterator();
        paramArrayOfByte = (byte[])localObject2;
        for (;;)
        {
          localObject1 = paramArrayOfByte;
          if (!localIterator.hasNext()) {
            return localObject1;
          }
          localObject1 = (MessageMicro)localIterator.next();
          if ((localObject1 instanceof NaviContent))
          {
            localObject1 = (NaviContent)localObject1;
            if (((NaviContent)localObject1).hasOut()) {
              localObject2 = null;
            }
          }
          try
          {
            localObject1 = MultiNavi.parseFrom(((NaviContent)localObject1).getOut().toByteArray());
            localObject2 = localObject1;
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            for (;;)
            {
              localInvalidProtocolBufferMicroException.printStackTrace();
            }
          }
          if ((localObject2 != null) && (((MultiNavi)localObject2).hasMultianviStream()))
          {
            localObject1 = paramArrayOfByte;
            try
            {
              localObject2 = Mrtl.parseFrom(((MultiNavi)localObject2).getMultianviStream().toByteArray());
              paramArrayOfByte = (byte[])localObject2;
              if (localObject2 != null)
              {
                paramArrayOfByte = (byte[])localObject2;
                localObject1 = localObject2;
                if (!((Mrtl)localObject2).getContentList().isEmpty())
                {
                  localObject1 = localObject2;
                  ((Mrtl)localObject2).getContent(0).setLabel(paramString);
                  paramArrayOfByte = (byte[])localObject2;
                }
              }
            }
            catch (InvalidProtocolBufferMicroException paramArrayOfByte)
            {
              paramArrayOfByte.printStackTrace();
              paramArrayOfByte = (byte[])localObject1;
            }
          }
        }
      }
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = localIterator;
      }
      return localInvalidProtocolBufferMicroException;
    }
  }
  
  private void setDestCalcRoute(RoutePlanNode paramRoutePlanNode, Handler paramHandler)
  {
    BNRoutePlaner.getInstance().cancleCalcRouteRequest();
    BNRoutePlaner.getInstance().clearRouteInfoHandler();
    BNRoutePlaner.getInstance().setObserver(null);
    BNRoutePlaner.getInstance().addRouteResultHandler(paramHandler);
    paramHandler = new ArrayList(2);
    paramHandler.add(BNLocationManagerProxy.getInstance().getCurLocationNode());
    paramHandler.add(paramRoutePlanNode);
    BNRoutePlaner.getInstance().setPointsToCalcRoute(paramHandler, 0);
  }
  
  public void getHomeAndCompanyInfo(RoutePlanNode paramRoutePlanNode1, RoutePlanNode paramRoutePlanNode2, Callback paramCallback)
  {
    long l = System.currentTimeMillis();
    if ((!isPointValid()) || (l - this.mHomeTimestamp > 60000L)) {
      resetHomeInfo(this.mHomeNode);
    }
    if ((!isPointValid()) || (l - this.mCompanyTimestamp > 60000L)) {
      resetCompanyInfo(this.mCompanyNode);
    }
    if ((paramRoutePlanNode1 == null) || (this.mHomeNode == null) || (!paramRoutePlanNode1.getGeoPoint().equals(this.mHomeNode.getGeoPoint()))) {
      resetHomeInfo(paramRoutePlanNode1);
    }
    if ((paramRoutePlanNode2 == null) || (this.mCompanyNode == null) || (!paramRoutePlanNode2.getGeoPoint().equals(this.mCompanyNode.getGeoPoint()))) {
      resetCompanyInfo(paramRoutePlanNode2);
    }
    this.mCallback = paramCallback;
    if ((this.mHomeNode != null) && (this.mHomeTimeInt > 0) && (this.mHomeDistanceInt > 0) && (this.mCallback != null)) {
      this.mCallback.onHomeInfo(this.mHomeTime, this.mHomeDistance);
    }
    if ((this.mCompanyNode != null) && (this.mCompanyTimeInt > 0) && (this.mCompanyDistanceInt > 0) && (this.mCallback != null)) {
      this.mCallback.onCompanyInfo(this.mCompanyTime, this.mCompanyDistance);
    }
    if ((this.mHomeNode != null) && ((this.mHomeTimeInt == 0) || (this.mHomeDistanceInt == 0))) {
      asynGetHomeInfo();
    }
    if ((this.mCompanyNode != null) && ((this.mCompanyTimeInt == 0) || (this.mCompanyDistanceInt == 0))) {
      asynGetCompanyInfo();
    }
  }
  
  public void resetCompanyInfo(RoutePlanNode paramRoutePlanNode)
  {
    this.mCompanyNode = paramRoutePlanNode;
    this.mCompanyTime = "";
    this.mCompanyDistance = "";
    this.mCompanyTimeInt = 0;
    this.mCompanyDistanceInt = 0;
    this.mCompanyTimestamp = 0L;
  }
  
  public void resetHomeInfo(RoutePlanNode paramRoutePlanNode)
  {
    this.mHomeNode = paramRoutePlanNode;
    this.mHomeTime = "";
    this.mHomeDistance = "";
    this.mHomeTimeInt = 0;
    this.mHomeDistanceInt = 0;
    this.mHomeTimestamp = 0L;
  }
  
  public void setCallback(Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  public static abstract interface Callback
  {
    public abstract void onCompanyInfo(String paramString1, String paramString2);
    
    public abstract void onHomeInfo(String paramString1, String paramString2);
  }
  
  private static class InstanceHolder
  {
    static final RouteInfoCache INSTANCE = new RouteInfoCache(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/cache/RouteInfoCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */