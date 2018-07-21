package com.baidu.navi.track.sync;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.carlife.core.a;
import com.baidu.carlife.core.i;
import com.baidu.navi.track.database.DataCache;
import com.baidu.navi.track.database.DataService;
import com.baidu.navi.track.database.DataService.Action;
import com.baidu.navi.track.datashop.DeleteFileThread;
import com.baidu.navi.track.model.BaseTrackModel;
import com.baidu.navi.track.model.CarNavi;
import com.baidu.navi.track.model.CarNaviModel;
import com.baidu.navi.track.model.NaviPoint;
import com.baidu.navi.track.model.TrackSyncRequestModel;
import com.baidu.navi.track.model.TrackSyncResponseModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class TrackSyncUtil
{
  private static final String TAG = TrackSyncUtil.class.getSimpleName();
  
  public static void checkTrackStatusInDB(Handler paramHandler, TrackSyncResponseModel paramTrackSyncResponseModel, int paramInt)
  {
    i.b(TAG, "checkTrackStatusInDB model=" + paramTrackSyncResponseModel);
    if ((paramTrackSyncResponseModel == null) || ((paramTrackSyncResponseModel.guidList.isEmpty()) && (paramTrackSyncResponseModel.dataList.isEmpty()))) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      Object localObject = paramTrackSyncResponseModel.guidList.iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add((String)((Iterator)localObject).next());
      }
      paramTrackSyncResponseModel = paramTrackSyncResponseModel.dataList.iterator();
      while (paramTrackSyncResponseModel.hasNext())
      {
        localObject = (CarNaviModel)paramTrackSyncResponseModel.next();
        if (((CarNaviModel)localObject).getPBData().hasGuid()) {
          localArrayList.add(((CarNaviModel)localObject).getPBData().getGuid());
        }
      }
    } while (localArrayList.size() <= 0);
    operateDBTransaction(paramHandler, DataService.Action.ACTION_GET_TRACK_SYNC_STATE_BY_GUID_LIST.toString(), localArrayList, paramInt);
  }
  
  public static ArrayList<TrackSyncRequestModel> getSyncDataRequestParams(ArrayList<Object> paramArrayList, HashMap<String, Integer> paramHashMap, ArrayList<String> paramArrayList1)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      paramArrayList1 = null;
    }
    ArrayList localArrayList;
    int i;
    do
    {
      return paramArrayList1;
      localArrayList = new ArrayList();
      i = 0;
      paramArrayList1 = localArrayList;
    } while (i >= paramArrayList.size());
    TrackSyncRequestModel localTrackSyncRequestModel = new TrackSyncRequestModel();
    paramArrayList1 = paramArrayList.get(i);
    CarNaviModel localCarNaviModel;
    String str2;
    int j;
    label199:
    String str1;
    if ((paramArrayList1 instanceof CarNaviModel))
    {
      localCarNaviModel = (CarNaviModel)paramArrayList1;
      localTrackSyncRequestModel.isResponse = "0";
      localTrackSyncRequestModel.updateTime = String.valueOf(localCarNaviModel.getPBData().getModifyTime());
      localTrackSyncRequestModel.guid = localCarNaviModel.getPBData().getGuid();
      localTrackSyncRequestModel.uploadTime = String.valueOf(System.currentTimeMillis() / 1000L);
      localTrackSyncRequestModel.uid = localCarNaviModel.getUseId();
      paramArrayList1 = localCarNaviModel.getPBData().getSid();
      localCarNaviModel.getSDcardPath();
      str2 = localCarNaviModel.getPBData().getGuid();
      if ((localCarNaviModel.getSyncState() != 0) && (3 != localCarNaviModel.getSyncState()) && (10 != localCarNaviModel.getSyncState())) {
        break label587;
      }
      j = 10;
      if (!TextUtils.isEmpty(paramArrayList1)) {
        break label567;
      }
      paramArrayList1 = "1";
      localTrackSyncRequestModel.actionType = "1";
      localTrackSyncRequestModel.createTime = String.valueOf(localCarNaviModel.getPBData().getCtime());
      localTrackSyncRequestModel.name = (localCarNaviModel.getPBData().getStartPoint().getAddr() + "_" + localCarNaviModel.getPBData().getEndPoint().getAddr());
      localTrackSyncRequestModel.distance = String.valueOf(localCarNaviModel.getPBData().getDistance());
      localTrackSyncRequestModel.duration = String.valueOf(localCarNaviModel.getPBData().getDuration());
      localTrackSyncRequestModel.speed = String.valueOf(localCarNaviModel.getPBData().getAvgSpeed());
      localTrackSyncRequestModel.maxSpeed = String.valueOf(localCarNaviModel.getPBData().getMaxSpeed());
      localTrackSyncRequestModel.dataVersion = "1";
      localTrackSyncRequestModel.startPosition = (localCarNaviModel.getPBData().getStartPoint().getLng() + "," + localCarNaviModel.getPBData().getStartPoint().getLat());
      localTrackSyncRequestModel.endPosition = (localCarNaviModel.getPBData().getEndPoint().getLng() + "," + localCarNaviModel.getPBData().getEndPoint().getLat());
      localTrackSyncRequestModel.fileSign = localCarNaviModel.getPBData().getSign();
      localTrackSyncRequestModel.trackFilePath = localCarNaviModel.getSDcardPath();
      localTrackSyncRequestModel.type = "2";
      if (!localCarNaviModel.isConnect()) {
        break label580;
      }
      str1 = "1";
      label472:
      localTrackSyncRequestModel.isConn = str1;
      localTrackSyncRequestModel.cuid = localCarNaviModel.getCarCuid();
      localTrackSyncRequestModel.channel = localCarNaviModel.getCarChannel();
      localTrackSyncRequestModel.version = localCarNaviModel.getCarVersion();
    }
    for (;;)
    {
      localTrackSyncRequestModel.updatePhoneInfo();
      i.b(TAG, "track actionType = " + paramArrayList1);
      localArrayList.add(localTrackSyncRequestModel);
      paramHashMap.put(str2, Integer.valueOf(j));
      label567:
      label580:
      label587:
      do
      {
        i += 1;
        break;
        paramArrayList1 = "2";
        localTrackSyncRequestModel.actionType = "2";
        break label199;
        str1 = "0";
        break label472;
      } while ((2 != localCarNaviModel.getSyncState()) && (12 != localCarNaviModel.getSyncState()));
      j = 2;
      paramArrayList1 = "3";
      localTrackSyncRequestModel.actionType = "3";
    }
  }
  
  public static void operateDBTransaction(Handler paramHandler, String paramString, Object paramObject, int paramInt)
  {
    a locala = a.a();
    Intent localIntent = new Intent(locala, DataService.class);
    if (paramHandler != null) {
      localIntent.putExtra("handler", DataCache.getInstance().addCache(paramHandler));
    }
    localIntent.putExtra("cache_key", DataCache.getInstance().addCache(paramObject));
    localIntent.putExtra("non_ui_evnet", true);
    if (paramInt != -1) {
      localIntent.putExtra("token_int_key", paramInt);
    }
    localIntent.setAction(paramString);
    try
    {
      locala.startService(localIntent);
      return;
    }
    catch (Exception paramHandler)
    {
      i.b(TAG, "Unable to find BaiduCarLife app process");
    }
  }
  
  public static void parseSyncDataBundle(Handler paramHandler, TrackSyncResponseModel paramTrackSyncResponseModel, HashMap<String, Integer> paramHashMap)
  {
    if (paramTrackSyncResponseModel == null) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramTrackSyncResponseModel.guidList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((paramHashMap != null) && (paramHashMap.containsKey(str))) {
        if (((Integer)paramHashMap.get(str)).intValue() == 2)
        {
          localHashMap.put(str, Integer.valueOf(1));
          localArrayList1.add(str);
        }
        else if (((Integer)paramHashMap.get(str)).intValue() == 10)
        {
          localHashMap.put(str, Integer.valueOf(1));
          BaseTrackModel localBaseTrackModel = new BaseTrackModel();
          localBaseTrackModel.guid = str;
          localBaseTrackModel.sid = "111";
          localBaseTrackModel.syncState = 1;
          localArrayList3.add(localBaseTrackModel);
        }
      }
    }
    if (paramTrackSyncResponseModel.isResponse == 1)
    {
      paramTrackSyncResponseModel = paramTrackSyncResponseModel.dataList.iterator();
      while (paramTrackSyncResponseModel.hasNext())
      {
        paramHashMap = (CarNaviModel)paramTrackSyncResponseModel.next();
        if (paramHashMap.getSyncState() == 2)
        {
          localHashMap.put(paramHashMap.getPBData().getGuid(), Integer.valueOf(1));
          localArrayList1.add(paramHashMap.getPBData().getGuid());
        }
        else if (paramHashMap.getSyncState() == 3)
        {
          localHashMap.put(paramHashMap.getPBData().getGuid(), Integer.valueOf(1));
          localArrayList4.add(paramHashMap);
        }
      }
    }
    if (localArrayList1.size() > 0)
    {
      operateDBTransaction(paramHandler, DataService.Action.ACTION_DELETE_TRACK_BY_GUID_LIST.toString(), localArrayList1, 10001);
      new DeleteFileThread(localArrayList1).start();
    }
    if (localArrayList2.size() > 0) {
      operateDBTransaction(paramHandler, DataService.Action.ACTION_UPDATE_TRACK_INFO_BY_LIST.toString(), localArrayList2, 10001);
    }
    if (localArrayList3.size() > 0) {
      operateDBTransaction(paramHandler, DataService.Action.ACTION_UPDATE_TRACK_SYNC_STATE_AND_SID_BY_GUID_LIST.toString(), localArrayList3, 10001);
    }
    if (localArrayList4.size() > 0) {
      operateDBTransaction(paramHandler, DataService.Action.ACTION_WRITE_TRACK_TO_DB.toString(), localArrayList4, 10001);
    }
    operateDBTransaction(paramHandler, DataService.Action.ACTION_UPDATE_TRACK_SYNC_STATE_BY_GUID_LIST.toString(), localHashMap, 10002);
    i.b(TAG, "delGuids.size=" + localArrayList1.size());
    i.b(TAG, "addLocalGuids.size=" + localArrayList3.size());
    i.b(TAG, "modifyObjs.size=" + localArrayList2.size());
    i.b(TAG, "addServerObjs.size=" + localArrayList4.size());
    i.b(TAG, "updateStatusMap=" + localHashMap);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/sync/TrackSyncUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */