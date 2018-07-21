package com.baidu.navisdk.vi;

import android.os.Bundle;
import android.os.Handler;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.model.VMsgDataCache;
import com.baidu.navisdk.model.modelfactory.OfflineDataMergeMsgModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class VMsgDispatcher
{
  private static final String TAG = VMsgDispatcher.class.getSimpleName();
  public static final int VM_USER_ID = 4096;
  private static Map<Integer, Set<Handler>> sFirtPriorityMsgMap = new HashMap();
  private static Map<Integer, Set<Handler>> sMsgHandlersMap = new HashMap();
  
  public static void dispatchMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 <= 4096) {}
    do
    {
      return;
      if ((4099 == paramInt1) && (PerformStatItem.sUserTest)) {
        PerformStatisticsController.peByType(0, "sdk_routeguide_dispatch_msg_rp_result", System.currentTimeMillis());
      }
      Bundle localBundle = VMsgDataCache.update(paramInt1);
      Object localObject3;
      synchronized (sFirtPriorityMsgMap)
      {
        localObject3 = (Set)sFirtPriorityMsgMap.get(Integer.valueOf(paramInt1));
        if (localObject3 != null)
        {
          localObject3 = ((Set)localObject3).iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext())
            {
              Handler localHandler1 = (Handler)((Iterator)localObject3).next();
              if (localHandler1 == null) {
                continue;
              }
              try
              {
                localHandler1.sendMessage(localHandler1.obtainMessage(paramInt1, paramInt2, paramInt3, localBundle));
              }
              catch (Exception localException1)
              {
                localException1.printStackTrace();
              }
            }
          }
        }
      }
      synchronized (sMsgHandlersMap)
      {
        localObject3 = (Set)sMsgHandlersMap.get(Integer.valueOf(paramInt1));
        if (localObject3 != null)
        {
          localObject3 = ((Set)localObject3).iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext())
            {
              Handler localHandler2 = (Handler)((Iterator)localObject3).next();
              if (localHandler2 == null) {
                continue;
              }
              try
              {
                localHandler2.sendMessage(localHandler2.obtainMessage(paramInt1, paramInt2, paramInt3, localObject1));
              }
              catch (Exception localException2)
              {
                localException2.printStackTrace();
              }
            }
          }
        }
      }
    } while (((paramInt1 != 4184) && (paramInt1 != 4185) && (paramInt1 != 4187) && (paramInt1 != 4186)) || (!OfflineDataMergeMsgModel.getInstance().getIsMergeNeedCache()));
    BNOfflineDataManager.initMergeMessageCache(paramInt1, paramInt2);
  }
  
  public static void dumpList()
  {
    synchronized (sMsgHandlersMap)
    {
      Iterator localIterator = sMsgHandlersMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Integer)localIterator.next();
        Object localObject3 = (Set)sMsgHandlersMap.get(localObject2);
        if (localObject3 != null)
        {
          LogUtil.e(TAG, "### MsgID " + localObject2 + ",  handlers count=" + ((Set)localObject3).size());
          localObject2 = ((Set)localObject3).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Handler)((Iterator)localObject2).next();
            LogUtil.e(TAG, "handler class name: " + localObject3.getClass().getSimpleName());
          }
        }
      }
    }
  }
  
  private static void postMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    dispatchMessage(paramInt1, paramInt2, paramInt3);
  }
  
  public static void registerMsgHandler(Handler paramHandler, Collection<Integer> arg1)
  {
    if ((paramHandler != null) && (??? != null))
    {
      Iterator localIterator = ???.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (localInteger != null) {
          for (;;)
          {
            synchronized (sMsgHandlersMap)
            {
              localObject = (Set)sMsgHandlersMap.get(localInteger);
              if (localObject != null) {
                ((Set)localObject).add(paramHandler);
              }
            }
            Object localObject = new HashSet();
            ((Set)localObject).add(paramHandler);
            sMsgHandlersMap.put(localInteger, localObject);
          }
        }
      }
    }
  }
  
  public static void registerMsgHandler(MsgHandler paramMsgHandler)
  {
    if (paramMsgHandler != null) {
      registerMsgHandler(paramMsgHandler, paramMsgHandler.getInterests());
    }
  }
  
  public static void registerMsgHandler(MsgHandler paramMsgHandler, int paramInt)
  {
    if (paramMsgHandler != null)
    {
      if (paramInt == 0) {
        registerMsgHandlerHighPriority(paramMsgHandler, paramMsgHandler.getInterests());
      }
    }
    else {
      return;
    }
    registerMsgHandler(paramMsgHandler, paramMsgHandler.getInterests());
  }
  
  public static void registerMsgHandlerHighPriority(Handler paramHandler, Collection<Integer> arg1)
  {
    if ((paramHandler == null) || (??? == null)) {}
    Integer localInteger;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = ???.iterator();
      }
      localInteger = (Integer)localIterator.next();
    } while (localInteger == null);
    for (;;)
    {
      synchronized (sFirtPriorityMsgMap)
      {
        localObject = (Set)sFirtPriorityMsgMap.get(localInteger);
        if (localObject != null) {
          ((Set)localObject).add(paramHandler);
        }
      }
      Object localObject = new HashSet();
      ((Set)localObject).add(paramHandler);
      sFirtPriorityMsgMap.put(localInteger, localObject);
    }
  }
  
  public static void unregisterAll()
  {
    synchronized (sMsgHandlersMap)
    {
      sMsgHandlersMap.clear();
    }
    synchronized (sFirtPriorityMsgMap)
    {
      sFirtPriorityMsgMap.clear();
      return;
      localObject1 = finally;
      throw ((Throwable)localObject1);
    }
  }
  
  public static void unregisterMsgHandler(Handler paramHandler, Collection<Integer> paramCollection)
  {
    if ((paramHandler != null) && (paramCollection != null))
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Integer localInteger = (Integer)paramCollection.next();
        if (localInteger != null) {
          synchronized (sMsgHandlersMap)
          {
            Set localSet = (Set)sMsgHandlersMap.get(localInteger);
            if (localSet != null)
            {
              localSet.remove(paramHandler);
              if (localSet.isEmpty()) {
                sMsgHandlersMap.remove(localInteger);
              }
            }
            synchronized (sFirtPriorityMsgMap)
            {
              localSet = (Set)sFirtPriorityMsgMap.get(localInteger);
              if (localSet != null)
              {
                localSet.remove(paramHandler);
                if (localSet.isEmpty()) {
                  sFirtPriorityMsgMap.remove(localInteger);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void unregisterMsgHandler(MsgHandler paramMsgHandler)
  {
    if (paramMsgHandler != null) {
      unregisterMsgHandler(paramMsgHandler, paramMsgHandler.getInterests());
    }
  }
  
  public static class PRIORITY
  {
    public static final int HIGH = 0;
    public static final int NORMAL = 1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/vi/VMsgDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */