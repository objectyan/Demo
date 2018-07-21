package com.baidu.navi.track.datashop;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.carlife.core.a;
import com.baidu.carlife.core.i;
import com.baidu.navi.track.common.TrackConfig;
import com.baidu.navi.track.database.DataCache;
import com.baidu.navi.track.database.DataService;
import com.baidu.navi.track.database.DataService.Action;
import com.baidu.navi.track.model.TrackAcmp;
import com.baidu.navi.track.model.TrackDBEvent;
import com.baidu.navi.util.NaviAccountUtils;

public class TrackStatisticShop
{
  private static final String TAG = TrackStatisticShop.class.getSimpleName();
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      i.b(TrackStatisticShop.TAG, "handleMessage msg = " + paramAnonymousMessage);
      if (paramAnonymousMessage.what != 5) {}
      TrackDBEvent localTrackDBEvent;
      do
      {
        do
        {
          return;
          localTrackDBEvent = null;
          if ((paramAnonymousMessage.obj instanceof TrackDBEvent)) {
            localTrackDBEvent = (TrackDBEvent)paramAnonymousMessage.obj;
          }
        } while (localTrackDBEvent == null);
        i.b(TrackStatisticShop.TAG, localTrackDBEvent.toString());
      } while (localTrackDBEvent.type != 5);
      paramAnonymousMessage = new TrackShopEvent();
      paramAnonymousMessage.type = 5;
      if (localTrackDBEvent.statistic != null)
      {
        paramAnonymousMessage.status = 0;
        paramAnonymousMessage.statistic = localTrackDBEvent.statistic;
      }
      for (;;)
      {
        TrackStatisticShop.this.postShopEvent(paramAnonymousMessage);
        return;
        paramAnonymousMessage.status = -2;
      }
    }
  };
  private Handler requestHandler;
  
  public TrackStatisticShop(Handler paramHandler)
  {
    this.requestHandler = paramHandler;
  }
  
  private void fetchStatisticFromDb(int paramInt)
  {
    a locala = a.a();
    String str = NavMapAdapter.getInstance().getUid();
    Intent localIntent = new Intent(locala, DataService.class);
    localIntent.putExtra("bduid", str);
    localIntent.putExtra("limit", paramInt);
    localIntent.putExtra("handler", DataCache.getInstance().addCache(this.mHandler));
    localIntent.setAction(DataService.Action.ACTION_GET_TRACK_STATISTICS.toString());
    locala.startService(localIntent);
  }
  
  private boolean hasCacheStatistic()
  {
    boolean bool2 = false;
    int i = TrackConfig.getInstance().getTotalDistanse();
    int j = TrackConfig.getInstance().getMaxTime();
    int k = TrackConfig.getInstance().getWeekDistanse();
    boolean bool1 = bool2;
    if (i > 0)
    {
      bool1 = bool2;
      if (j > 0)
      {
        TrackAcmp localTrackAcmp = new TrackAcmp();
        localTrackAcmp.setCarNaviDistance(i);
        localTrackAcmp.setCarWeekMileage(k);
        localTrackAcmp.setCarMaxDuration(j);
        TrackShopEvent localTrackShopEvent = new TrackShopEvent();
        localTrackShopEvent.type = 5;
        localTrackShopEvent.status = 0;
        localTrackShopEvent.statistic = localTrackAcmp;
        postShopEvent(localTrackShopEvent);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void postShopEvent(TrackShopEvent paramTrackShopEvent)
  {
    i.b(TAG, paramTrackShopEvent.toString());
    i.b(TAG, paramTrackShopEvent.statistic.toString());
    if (this.requestHandler != null) {
      this.requestHandler.obtainMessage(5, paramTrackShopEvent).sendToTarget();
    }
  }
  
  public void fetchStatistic(int paramInt)
  {
    if ((NaviAccountUtils.getInstance().isLogin()) && (hasCacheStatistic())) {
      return;
    }
    fetchStatisticFromDb(paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/datashop/TrackStatisticShop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */