package com.baidu.navisdk.model;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.HashMap;
import java.util.Map;

public class VMsgDataCache
{
  private static final String TAG = VMsgDataCache.class.getSimpleName();
  @SuppressLint({"UseSparseArrays"})
  private static final Map<Integer, Bundle> sMsgDataCache = new HashMap();
  
  public static void clear()
  {
    try
    {
      sMsgDataCache.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static Bundle get(int paramInt)
  {
    Bundle localBundle = getData(paramInt);
    if (localBundle != null)
    {
      LogUtil.e(TAG, "get data cache succ, msgId=" + paramInt);
      return localBundle;
    }
    LogUtil.e(TAG, "get data cache failed, msgId=" + paramInt);
    return null;
  }
  
  private static Bundle getData(int paramInt)
  {
    try
    {
      Bundle localBundle = (Bundle)sMsgDataCache.get(Integer.valueOf(paramInt));
      return localBundle;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static Bundle getDataOfMsg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 4100: 
    case 4108: 
    case 4608: 
    case 4609: 
    case 4610: 
    case 4101: 
    case 4102: 
    case 4103: 
    case 4109: 
    case 4110: 
    case 4111: 
    case 4146: 
    case 4147: 
    case 4148: 
    case 4406: 
    case 4407: 
    case 4408: 
    case 4409: 
    case 4410: 
    case 4411: 
    case 4104: 
    case 4105: 
    case 4106: 
      Integer localInteger;
      do
      {
        return null;
        localBundle1 = new Bundle();
        BNRouteGuider.getInstance().getSimpleMapInfo(localBundle1);
        return localBundle1;
        localBundle1 = new Bundle();
        BNRouteGuider.getInstance().getCurRoadName(localBundle1);
        return localBundle1;
        localBundle1 = new Bundle();
        localBundle1.putInt("get_image", 1);
        BNRouteGuider.getInstance().getVectorExpandMapInfo(localBundle1);
        return localBundle1;
        localBundle1 = new Bundle();
        localBundle1.putInt("get_image", 0);
        BNRouteGuider.getInstance().getVectorExpandMapInfo(localBundle1);
        return localBundle1;
        localBundle1 = new Bundle();
        BNRouteGuider.getInstance().getVectorExpandMapInfo(localBundle1);
        return localBundle1;
        localBundle1 = new Bundle();
        BNRouteGuider.getInstance().getRasterExpandMapInfo(localBundle1);
        return localBundle1;
        localBundle1 = new Bundle();
        BNRouteGuider.getInstance().getDirectBoardInfo(localBundle1);
        return localBundle1;
        localBundle1 = new Bundle();
        BNRouteGuider.getInstance().getHighWayInfo(localBundle1);
        return localBundle1;
        localBundle1 = new Bundle();
        BNRouteGuider.getInstance().getInHighWay(localBundle1);
        return localBundle1;
        localBundle1 = new Bundle();
        BNRouteGuider.getInstance().getEixtFastway(localBundle1);
        return localBundle1;
        localBundle1 = BNRouteGuider.getInstance().getAssistRemainDist();
        localInteger = Integer.valueOf(localBundle1.getInt("remainDist"));
      } while (localInteger == null);
      Bundle localBundle2 = new Bundle();
      LogUtil.e(TAG, "~~~ msgId=" + paramInt + ", remain dist=" + localInteger);
      localBundle2.putInt("remain_dist", localInteger.intValue());
      localBundle2.putString("description", localBundle1.getString("description"));
      return localBundle2;
    }
    Bundle localBundle1 = new Bundle();
    BNRouteGuider.getInstance().getDestStreetViewInfo(localBundle1);
    return localBundle1;
  }
  
  public static int getInt(int paramInt, String paramString)
  {
    if (paramString != null)
    {
      Bundle localBundle = getData(paramInt);
      if (localBundle != null) {
        return localBundle.getInt(paramString);
      }
    }
    return 0;
  }
  
  public static String getString(int paramInt, String paramString)
  {
    if (paramString != null)
    {
      Bundle localBundle = getData(paramInt);
      if (localBundle != null) {
        return localBundle.getString(paramString);
      }
    }
    return null;
  }
  
  private static void putData(int paramInt, Bundle paramBundle)
  {
    try
    {
      sMsgDataCache.put(Integer.valueOf(paramInt), paramBundle);
      return;
    }
    finally
    {
      paramBundle = finally;
      throw paramBundle;
    }
  }
  
  public static void remove(int paramInt)
  {
    try
    {
      sMsgDataCache.remove(Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static Bundle update(int paramInt)
  {
    Bundle localBundle = getDataOfMsg(paramInt);
    if (localBundle != null) {
      putData(paramInt, localBundle);
    }
    return localBundle;
  }
  
  public static void update(int paramInt, Bundle paramBundle)
  {
    if (paramBundle != null) {
      putData(paramInt, paramBundle);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/VMsgDataCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */