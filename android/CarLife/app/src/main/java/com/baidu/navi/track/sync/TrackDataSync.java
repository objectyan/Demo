package com.baidu.navi.track.sync;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.carlife.core.a;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;
import com.baidu.navi.track.common.TrackConfig;
import com.baidu.navi.track.database.DataBaseConstants.TrackQueryType;
import com.baidu.navi.track.database.DataCache;
import com.baidu.navi.track.database.DataService;
import com.baidu.navi.track.database.DataService.Action;
import com.baidu.navi.track.datashop.TrackDataShop;
import com.baidu.navi.track.datashop.TrackShopEvent;
import com.baidu.navi.track.model.CarNavi;
import com.baidu.navi.track.model.CarNaviModel;
import com.baidu.navi.track.model.TrackDBEvent;
import com.baidu.navi.track.model.TrackSyncRequestModel;
import com.baidu.navi.track.model.TrackSyncResponseModel;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.util.common.NetworkUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TrackDataSync
{
  private static final String TAG = TrackDataSync.class.getSimpleName();
  private static TrackDataSync mInstance;
  private ArrayList<Object> cacheAutoSyncDatas = new ArrayList();
  private ArrayList<String> delDirtyGuids = new ArrayList();
  private HandlerThread handlerThread;
  private boolean isAutoSyncing;
  private boolean isManualSyncing;
  public boolean isMergeDataError = false;
  private boolean isSyncSuccessed;
  private boolean isSyncing;
  private HashMap<Integer, TrackSyncResponseModel> mSyncDataBundleMap = new HashMap();
  private SyncManager mSyncDataMgr = SyncManager.getInstance();
  private List<Object> mainListData;
  private Handler myHandler;
  private long time;
  
  private void cleanGetData()
  {
    if (this.mSyncDataMgr == null) {
      return;
    }
    this.mSyncDataMgr.releaseSyncData();
    solveStateAfterSync();
  }
  
  public static TrackDataSync getInstance()
  {
    if (mInstance == null) {
      mInstance = new TrackDataSync();
    }
    return mInstance;
  }
  
  private void getSyncDataFromEngine()
  {
    if (this.mSyncDataMgr == null) {}
    int i;
    do
    {
      TrackSyncResponseModel localTrackSyncResponseModel;
      do
      {
        return;
        localTrackSyncResponseModel = this.mSyncDataMgr.getSyncData();
      } while (localTrackSyncResponseModel == null);
      i = localTrackSyncResponseModel.guidList.size() + localTrackSyncResponseModel.dataList.size();
      i.b(TAG, "syncData count==" + i);
      if (i > 0)
      {
        i = (int)System.currentTimeMillis();
        this.mSyncDataBundleMap.put(Integer.valueOf(i), localTrackSyncResponseModel);
        TrackSyncUtil.checkTrackStatusInDB(this.myHandler, localTrackSyncResponseModel, i);
        return;
      }
    } while (i != 0);
    solveStateAfterSync();
  }
  
  private void init()
  {
    if (this.myHandler == null)
    {
      this.handlerThread = new HandlerThread("TrackDataSyncThread");
      this.handlerThread.start();
      this.myHandler = new MyHandler(this.handlerThread.getLooper());
      this.mSyncDataMgr.registerHandler(this.myHandler);
    }
  }
  
  private void notifySyncRecordsState(TrackShopEvent paramTrackShopEvent)
  {
    k.a(700, paramTrackShopEvent);
  }
  
  private void solveStateAfterSync()
  {
    int i;
    if (this.isSyncing)
    {
      this.isSyncing = false;
      this.isManualSyncing = false;
      TrackShopEvent localTrackShopEvent = new TrackShopEvent();
      localTrackShopEvent.type = 7;
      if (this.isSyncSuccessed)
      {
        i = 0;
        localTrackShopEvent.status = i;
        TrackConfig.getInstance().setMaxTime(0);
        TrackConfig.getInstance().setTotalDistanse(0);
        TrackConfig.getInstance().setWeekDistanse(0);
        TrackConfig.getInstance().setWeekEndTime(0);
        TrackDataShop.getInstance().fetchStatistics(null, 0);
        TrackConfig.getInstance().setLastSyncTime(System.currentTimeMillis());
        notifySyncRecordsState(localTrackShopEvent);
      }
    }
    do
    {
      do
      {
        autoSync(this.cacheAutoSyncDatas);
        return;
        i = -1;
        break;
      } while (!this.isAutoSyncing);
      this.isAutoSyncing = false;
    } while (!this.isManualSyncing);
    manualSync();
  }
  
  private void startSync()
  {
    if (this.myHandler != null) {
      SyncManager.getInstance().startSync();
    }
  }
  
  private void stopSync()
  {
    if (this.myHandler != null) {
      SyncManager.getInstance().stopSync();
    }
  }
  
  public boolean autoSync(Object paramObject)
  {
    if ((!NaviAccountUtils.getInstance().isLogin()) || (!NetworkUtils.isNetworkAvailable(a.a()))) {}
    do
    {
      return false;
      this.cacheAutoSyncDatas.add(paramObject);
    } while ((this.isSyncing) || (this.isAutoSyncing));
    init();
    return autoSync(this.cacheAutoSyncDatas);
  }
  
  public boolean autoSync(ArrayList<Object> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return false;
    }
    init();
    if ((!NaviAccountUtils.getInstance().isLogin()) || (!NetworkUtils.isNetworkAvailable(a.a()))) {
      return false;
    }
    HashMap localHashMap = new HashMap();
    this.delDirtyGuids.clear();
    paramArrayList = TrackSyncUtil.getSyncDataRequestParams(paramArrayList, localHashMap, this.delDirtyGuids);
    this.cacheAutoSyncDatas.clear();
    if (paramArrayList != null)
    {
      i.b(TAG, "syncData.size = " + paramArrayList.size());
      if (SyncManager.getInstance().setSyncData(paramArrayList))
      {
        if (!localHashMap.isEmpty()) {
          TrackSyncUtil.operateDBTransaction(null, DataService.Action.ACTION_UPDATE_TRACK_SYNC_STATE_BY_GUID_LIST.toString(), localHashMap, -1);
        }
        if (this.delDirtyGuids.size() > 0) {
          TrackSyncUtil.operateDBTransaction(null, DataService.Action.ACTION_DELETE_TRACK_BY_GUID_LIST.toString(), this.delDirtyGuids, -1);
        }
      }
    }
    this.isAutoSyncing = true;
    startSync();
    return true;
  }
  
  public boolean isSyncing()
  {
    return this.isManualSyncing;
  }
  
  public boolean manualSync()
  {
    init();
    if (!NaviAccountUtils.getInstance().isLogin()) {
      return false;
    }
    this.isManualSyncing = true;
    if (this.isAutoSyncing) {
      return true;
    }
    this.isSyncing = true;
    this.isSyncSuccessed = true;
    this.mainListData = null;
    TrackDataShop.getInstance().fetchTrackList(this.myHandler, NavMapAdapter.getInstance().getUid(), 0, 3000, DataBaseConstants.TrackQueryType.CAR);
    return true;
  }
  
  private class MyHandler
    extends Handler
  {
    public MyHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      i.b(TrackDataSync.TAG, paramMessage.toString());
      Object localObject3 = null;
      Object localObject1 = null;
      Object localObject4 = null;
      Object localObject2 = null;
      int i;
      if (paramMessage.what == 524)
      {
        i = paramMessage.arg1;
        switch (paramMessage.arg2)
        {
        default: 
          TrackDataSync.access$202(TrackDataSync.this, false);
          localObject4 = localObject2;
          localObject3 = localObject1;
          switch (paramMessage.what)
          {
          }
          break;
        }
      }
      label1076:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      localObject3 = localObject1;
                      localObject4 = localObject2;
                      if (TrackDataSync.this.time >= 1L) {
                        break;
                      }
                      TrackDataSync.access$102(TrackDataSync.this, System.currentTimeMillis());
                      localObject3 = localObject1;
                      localObject4 = localObject2;
                      break;
                      i.b("tag", "CLEAN_DATA_OK");
                      localObject3 = localObject1;
                      localObject4 = localObject2;
                      break;
                      i.b("tag", "CLEAN_DATA_FAIL");
                      localObject3 = localObject1;
                      localObject4 = localObject2;
                      break;
                      localObject3 = TrackDataSync.this;
                      if (i == 0) {}
                      for (boolean bool = true;; bool = false)
                      {
                        TrackDataSync.access$202((TrackDataSync)localObject3, bool);
                        TrackDataSync.this.getSyncDataFromEngine();
                        localObject3 = localObject1;
                        localObject4 = localObject2;
                        break;
                      }
                      TrackDataSync.access$202(TrackDataSync.this, false);
                      TrackDataSync.access$402(TrackDataSync.this, false);
                      localObject3 = new TrackShopEvent();
                      ((TrackShopEvent)localObject3).type = 7;
                      ((TrackShopEvent)localObject3).status = -4;
                      localObject3 = localObject1;
                      localObject4 = localObject2;
                      break;
                      if ((paramMessage.obj instanceof TrackDBEvent))
                      {
                        localObject1 = (TrackDBEvent)paramMessage.obj;
                        localObject2 = localObject4;
                      }
                      for (;;)
                      {
                        localObject3 = localObject1;
                        localObject4 = localObject2;
                        if (localObject1 != null) {
                          break;
                        }
                        localObject3 = localObject1;
                        localObject4 = localObject2;
                        if (localObject2 != null) {
                          break;
                        }
                        return;
                        localObject1 = localObject3;
                        localObject2 = localObject4;
                        if ((paramMessage.obj instanceof TrackShopEvent))
                        {
                          localObject2 = (TrackShopEvent)paramMessage.obj;
                          localObject1 = localObject3;
                        }
                      }
                    } while (((TrackShopEvent)localObject4).type != 3);
                    if (((TrackShopEvent)localObject4).status == 0) {
                      TrackDataSync.access$502(TrackDataSync.this, ((TrackShopEvent)localObject4).list);
                    }
                    paramMessage = a.a();
                    localObject1 = new Intent(paramMessage, DataService.class);
                    ((Intent)localObject1).putExtra("handler", DataCache.getInstance().addCache(TrackDataSync.this.myHandler));
                    ((Intent)localObject1).putExtra("non_ui_evnet", true);
                    ((Intent)localObject1).putExtra("bduid", NavMapAdapter.getInstance().getUid());
                    ((Intent)localObject1).setAction(DataService.Action.ACTION_READ_TRACK_BY_SYNC_STATE.toString());
                    paramMessage.startService((Intent)localObject1);
                    return;
                  } while (((TrackDBEvent)localObject3).type != 4);
                  localObject2 = (ArrayList)((TrackDBEvent)localObject3).list;
                  localObject1 = new TrackSyncRequestModel();
                  ((TrackSyncRequestModel)localObject1).updatePhoneInfo();
                  ((TrackSyncRequestModel)localObject1).uid = NavMapAdapter.getInstance().getUid();
                  ((TrackSyncRequestModel)localObject1).actionType = "4";
                  ((TrackSyncRequestModel)localObject1).isResponse = "1";
                  localObject3 = new StringBuffer("");
                  i = 1;
                  if (TrackDataSync.this.mainListData != null)
                  {
                    localObject4 = TrackDataSync.this.mainListData.iterator();
                    while (((Iterator)localObject4).hasNext())
                    {
                      Object localObject5 = ((Iterator)localObject4).next();
                      if ((localObject5 instanceof CarNaviModel))
                      {
                        StringBuilder localStringBuilder = new StringBuilder();
                        if (i != 0) {}
                        for (paramMessage = "";; paramMessage = ",")
                        {
                          ((StringBuffer)localObject3).append(paramMessage + ((CarNaviModel)localObject5).getPBData().getGuid());
                          i = 0;
                          break;
                        }
                      }
                    }
                    TrackDataSync.this.mainListData.clear();
                  }
                  ((TrackSyncRequestModel)localObject1).guidList = ((StringBuffer)localObject3).toString();
                  if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
                  {
                    paramMessage = new HashMap();
                    TrackDataSync.this.delDirtyGuids.clear();
                    localObject2 = TrackSyncUtil.getSyncDataRequestParams((ArrayList)localObject2, paramMessage, TrackDataSync.this.delDirtyGuids);
                    if (localObject2 != null)
                    {
                      ((ArrayList)localObject2).add(localObject1);
                      i.b(TrackDataSync.TAG, "syncData.size = " + ((ArrayList)localObject2).size());
                      if (SyncManager.getInstance().setSyncData((List)localObject2))
                      {
                        if (!paramMessage.isEmpty()) {
                          TrackSyncUtil.operateDBTransaction(null, DataService.Action.ACTION_UPDATE_TRACK_SYNC_STATE_BY_GUID_LIST.toString(), paramMessage, -1);
                        }
                        if (TrackDataSync.this.delDirtyGuids.size() > 0) {
                          TrackSyncUtil.operateDBTransaction(null, DataService.Action.ACTION_DELETE_TRACK_BY_GUID_LIST.toString(), TrackDataSync.this.delDirtyGuids, -1);
                        }
                      }
                    }
                  }
                  for (;;)
                  {
                    TrackDataSync.this.startSync();
                    return;
                    paramMessage = new TrackShopEvent();
                    paramMessage.type = 7;
                    paramMessage.status = -1;
                    TrackDataSync.this.notifySyncRecordsState(paramMessage);
                    continue;
                    paramMessage = new ArrayList();
                    paramMessage.add(localObject1);
                    SyncManager.getInstance().setSyncData(paramMessage);
                    continue;
                    paramMessage = new ArrayList();
                    paramMessage.add(localObject1);
                    SyncManager.getInstance().setSyncData(paramMessage);
                    i.b(TrackDataSync.TAG, "没有可同步数据");
                  }
                } while (((TrackDBEvent)localObject3).type != 18);
                if (((TrackDBEvent)localObject3).status != 1) {
                  break label1076;
                }
                paramMessage = (HashMap)((TrackDBEvent)localObject3).map;
                i = ((TrackDBEvent)localObject3).token;
              } while ((TrackDataSync.this.mSyncDataBundleMap.isEmpty()) || (i == -1));
              localObject1 = (TrackSyncResponseModel)TrackDataSync.this.mSyncDataBundleMap.get(Integer.valueOf(i));
              TrackSyncUtil.parseSyncDataBundle(TrackDataSync.this.myHandler, (TrackSyncResponseModel)localObject1, paramMessage);
              TrackDataSync.this.mSyncDataBundleMap.remove(Integer.valueOf(i));
              return;
              i.b(TrackDataSync.TAG, "批量查询指定GUID的List轨迹数据同步状态失败");
              return;
            } while (((TrackDBEvent)localObject3).type != 11);
            TrackDataSync.this.delDirtyGuids.size();
            TrackDataSync.this.delDirtyGuids.clear();
          } while ((((TrackDBEvent)localObject3).token != 10001) || (((TrackDBEvent)localObject3).status != 0));
          TrackDataSync.this.isMergeDataError = true;
          return;
        } while ((((TrackDBEvent)localObject3).type != 1) || (((TrackDBEvent)localObject3).token != 10001) || (((TrackDBEvent)localObject3).status != 0));
        TrackDataSync.this.isMergeDataError = true;
        return;
        if ((((TrackDBEvent)localObject3).type == 7) && (((TrackDBEvent)localObject3).token == 10001) && (((TrackDBEvent)localObject3).status == 0)) {
          TrackDataSync.this.isMergeDataError = true;
        }
      } while ((((TrackDBEvent)localObject3).token != 10002) || (((TrackDBEvent)localObject3).status != 1));
      TrackDataSync.this.cleanGetData();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/sync/TrackDataSync.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */