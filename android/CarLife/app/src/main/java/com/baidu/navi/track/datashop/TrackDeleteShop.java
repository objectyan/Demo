package com.baidu.navi.track.datashop;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.core.a;
import com.baidu.carlife.core.i;
import com.baidu.navi.track.common.TrackConfig;
import com.baidu.navi.track.database.DataCache;
import com.baidu.navi.track.database.DataService;
import com.baidu.navi.track.database.DataService.Action;
import com.baidu.navi.track.model.BaseTrackModel;
import com.baidu.navi.track.model.CarNavi;
import com.baidu.navi.track.model.CarNaviModel;
import com.baidu.navi.track.model.TrackDBEvent;
import com.baidu.navi.util.NaviAccountUtils;
import java.util.ArrayList;
import java.util.List;

public class TrackDeleteShop
{
  private static final String TAG = TrackDeleteShop.class.getSimpleName();
  private String guid;
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what != 3) {}
      TrackDBEvent localTrackDBEvent;
      do
      {
        do
        {
          return;
          i.b(TrackDeleteShop.TAG, "handleMessage msg = " + paramAnonymousMessage);
          localTrackDBEvent = null;
          if ((paramAnonymousMessage.obj instanceof TrackDBEvent)) {
            localTrackDBEvent = (TrackDBEvent)paramAnonymousMessage.obj;
          }
        } while (localTrackDBEvent == null);
        i.b(TrackDeleteShop.TAG, "dbEvent.type = " + localTrackDBEvent.type);
      } while (localTrackDBEvent.type != 6);
      if ((localTrackDBEvent.item != null) && (localTrackDBEvent.item.guid.equalsIgnoreCase(TrackDeleteShop.this.guid)))
      {
        if (localTrackDBEvent.status != 1) {
          break label166;
        }
        TrackDeleteShop.this.notifyDeleteSuccess();
      }
      for (;;)
      {
        i.b(TrackDeleteShop.TAG, "dbEvent.status = " + localTrackDBEvent.status);
        return;
        label166:
        TrackDeleteShop.this.notifyDeleteErr(-2);
      }
    }
  };
  private Object originalObject;
  private Handler requestHandler;
  
  public TrackDeleteShop(Handler paramHandler)
  {
    this.requestHandler = paramHandler;
  }
  
  private void deleteRecordAndMarkChange(BaseTrackModel paramBaseTrackModel)
  {
    a locala = a.a();
    Intent localIntent = new Intent(locala, DataService.class);
    localIntent.setAction(DataService.Action.ACTION_UPDATE_TRACK_BY_GUID.toString());
    localIntent.putExtra("cache_key", DataCache.getInstance().addCache(paramBaseTrackModel));
    locala.startService(localIntent);
  }
  
  private void deleteRecordFromLocal(String paramString)
  {
    Object localObject = a.a();
    Intent localIntent = new Intent((Context)localObject, DataService.class);
    localIntent.putExtra("handler", DataCache.getInstance().addCache(this.mHandler));
    localIntent.putExtra("guid", paramString);
    localIntent.setAction(DataService.Action.ACTION_DELETE_TRACK_BY_GUID.toString());
    ((Context)localObject).startService(localIntent);
    localObject = new ArrayList();
    ((List)localObject).add(paramString);
    new DeleteFileThread((List)localObject).start();
  }
  
  private void notifyDeleteErr(int paramInt)
  {
    if (this.requestHandler == null) {
      return;
    }
    BaseTrackModel localBaseTrackModel = new BaseTrackModel();
    localBaseTrackModel.guid = this.guid;
    TrackShopEvent localTrackShopEvent = new TrackShopEvent();
    localTrackShopEvent.type = 6;
    localTrackShopEvent.status = paramInt;
    localTrackShopEvent.item = localBaseTrackModel;
    this.requestHandler.obtainMessage(3, localTrackShopEvent).sendToTarget();
  }
  
  private void notifyDeleteSuccess()
  {
    if (this.requestHandler == null) {
      return;
    }
    BaseTrackModel localBaseTrackModel = new BaseTrackModel();
    localBaseTrackModel.guid = this.guid;
    TrackShopEvent localTrackShopEvent = new TrackShopEvent();
    localTrackShopEvent.type = 6;
    localTrackShopEvent.status = 0;
    localTrackShopEvent.item = localBaseTrackModel;
    this.requestHandler.obtainMessage(3, localTrackShopEvent).sendToTarget();
  }
  
  private BaseTrackModel preDeleteTrackRecord(Object paramObject)
  {
    BaseTrackModel localBaseTrackModel2 = new BaseTrackModel();
    BaseTrackModel localBaseTrackModel1 = localBaseTrackModel2;
    if ((paramObject instanceof CarNaviModel))
    {
      paramObject = (CarNaviModel)paramObject;
      if (((CarNaviModel)paramObject).getPBData() != null) {
        break label38;
      }
      localBaseTrackModel1 = null;
    }
    label38:
    int i;
    int m;
    do
    {
      int j;
      do
      {
        do
        {
          return localBaseTrackModel1;
          localBaseTrackModel2.sid = ((CarNaviModel)paramObject).getPBData().getSid();
          localBaseTrackModel2.guid = ((CarNaviModel)paramObject).getPBData().getGuid();
          localBaseTrackModel2.useId = ((CarNaviModel)paramObject).getUseId();
          localBaseTrackModel2.ctime = ((CarNaviModel)paramObject).getPBData().getCtime();
          localBaseTrackModel2.modifyTime = ((int)(System.currentTimeMillis() / 1000L));
          localBaseTrackModel2.type = ((CarNaviModel)paramObject).getPBData().getType();
          localBaseTrackModel2.syncState = 2;
          this.originalObject = ((CarNaviModel)paramObject).clone();
          ((CarNaviModel)this.originalObject).setSyncState(2);
          i = TrackConfig.getInstance().getTotalDistanse();
          j = TrackConfig.getInstance().getWeekEndTime();
          localBaseTrackModel1 = localBaseTrackModel2;
        } while (j == 0);
        localBaseTrackModel1 = localBaseTrackModel2;
      } while (i == 0);
      int k = TrackConfig.getInstance().getWeekDistanse();
      m = ((CarNaviModel)this.originalObject).getPBData().getDistance();
      int n = TrackConfig.getInstance().getMaxTime();
      if ((i > 0) && (n > 0) && (((CarNaviModel)paramObject).getPBData().getDuration() == n)) {
        TrackConfig.getInstance().setMaxTime(0);
      }
      if ((k >= m) && (localBaseTrackModel2.ctime >= j - 604800) && (localBaseTrackModel2.ctime < j)) {
        TrackConfig.getInstance().setWeekDistanse(k - m);
      }
      localBaseTrackModel1 = localBaseTrackModel2;
    } while (i < m);
    TrackConfig.getInstance().setTotalDistanse(i - m);
    return localBaseTrackModel2;
  }
  
  public void deleteTrackRecord(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      paramObject = preDeleteTrackRecord(paramObject);
    } while ((paramObject == null) || (TextUtils.isEmpty(((BaseTrackModel)paramObject).guid)));
    this.guid = ((BaseTrackModel)paramObject).guid;
    if (NaviAccountUtils.getInstance().isLogin())
    {
      if (!TextUtils.isEmpty(((BaseTrackModel)paramObject).sid))
      {
        deleteRecordAndMarkChange((BaseTrackModel)paramObject);
        return;
      }
      deleteRecordFromLocal(((BaseTrackModel)paramObject).guid);
      return;
    }
    deleteRecordFromLocal(((BaseTrackModel)paramObject).guid);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/datashop/TrackDeleteShop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */