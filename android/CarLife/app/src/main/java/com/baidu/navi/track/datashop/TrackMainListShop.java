package com.baidu.navi.track.datashop;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.core.a;
import com.baidu.carlife.core.i;
import com.baidu.navi.track.database.DataBaseConstants.TrackQueryType;
import com.baidu.navi.track.database.DataCache;
import com.baidu.navi.track.database.DataService;
import com.baidu.navi.track.database.DataService.Action;
import com.baidu.navi.track.model.CarNavi;
import com.baidu.navi.track.model.CarNaviModel;
import com.baidu.navi.track.model.TrackDBEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TrackMainListShop
{
  public static final int DEFAULT_REQ_COUNT = 20;
  private static final String TAG = TrackMainListShop.class.getSimpleName();
  private List<Object> dataList;
  private List<Object> geoList = new ArrayList();
  private boolean isClean;
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      i.b(TrackMainListShop.TAG, "handleMessage msg = " + paramAnonymousMessage);
      if (paramAnonymousMessage.what != 1) {}
      Object localObject1;
      do
      {
        do
        {
          return;
          localObject1 = null;
          if ((paramAnonymousMessage.obj instanceof TrackDBEvent)) {
            localObject1 = (TrackDBEvent)paramAnonymousMessage.obj;
          }
        } while (localObject1 == null);
        i.b(TrackMainListShop.TAG, ((TrackDBEvent)localObject1).toString());
      } while (((TrackDBEvent)localObject1).type != 3);
      TrackMainListShop.access$102(TrackMainListShop.this, ((TrackDBEvent)localObject1).list);
      TrackMainListShop.access$202(TrackMainListShop.this, ((TrackDBEvent)localObject1).queryType);
      if (TrackMainListShop.this.isClean)
      {
        if (TrackMainListShop.this.dataList != null)
        {
          paramAnonymousMessage = new ArrayList();
          localObject1 = TrackMainListShop.this.dataList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = ((Iterator)localObject1).next();
            if ((localObject2 instanceof CarNaviModel)) {
              paramAnonymousMessage.add(((CarNaviModel)localObject2).getPBData().getGuid());
            }
          }
          new DeleteFileThread(paramAnonymousMessage).start();
        }
        TrackMainListShop.access$302(TrackMainListShop.this, false);
        return;
      }
      if ((TrackMainListShop.this.dataList == null) || (TrackMainListShop.this.dataList.isEmpty()))
      {
        TrackMainListShop.this.notifyTrackListOk(Collections.EMPTY_LIST);
        return;
      }
      TrackMainListShop.this.notifyTrackListOk(TrackMainListShop.this.dataList);
    }
  };
  private Handler requestHandler;
  private DataBaseConstants.TrackQueryType trackListQueryType = DataBaseConstants.TrackQueryType.CAR;
  private ArrayList<Object> updateList = new ArrayList();
  
  public TrackMainListShop(Handler paramHandler)
  {
    this.requestHandler = paramHandler;
  }
  
  public void clearBeforSixMonthGPSFile(String paramString)
  {
    new TrackFileCleanThread().start();
    this.isClean = true;
    fetchTrackList(paramString, (int)(System.currentTimeMillis() / 1000L - 15552000L), 2000, DataBaseConstants.TrackQueryType.CAR);
  }
  
  public void fetchTrackList(String paramString, int paramInt1, int paramInt2, DataBaseConstants.TrackQueryType paramTrackQueryType)
  {
    fetchTrackList(paramString, paramInt1, paramTrackQueryType, paramInt2);
  }
  
  public void fetchTrackList(String paramString, int paramInt, DataBaseConstants.TrackQueryType paramTrackQueryType)
  {
    fetchTrackList(paramString, paramInt, paramTrackQueryType, 20);
  }
  
  public void fetchTrackList(String paramString, int paramInt1, DataBaseConstants.TrackQueryType paramTrackQueryType, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < 1) {
      i = Integer.MAX_VALUE;
    }
    a locala = a.a();
    Intent localIntent = new Intent(locala, DataService.class);
    localIntent.putExtra("startTime", i);
    localIntent.putExtra("limit", paramInt2);
    if (paramString == null) {
      localIntent.putExtra("bduid", "");
    }
    for (;;)
    {
      localIntent.putExtra("query_type", paramTrackQueryType.toString());
      localIntent.putExtra("handler", DataCache.getInstance().addCache(this.mHandler));
      localIntent.setAction(DataService.Action.ACTION_READ_TRACK_AFTER_TIME.toString());
      locala.startService(localIntent);
      return;
      localIntent.putExtra("bduid", paramString);
    }
  }
  
  public void notifyTrackListOk(List<Object> paramList)
  {
    if (this.requestHandler != null)
    {
      TrackShopEvent localTrackShopEvent = new TrackShopEvent();
      localTrackShopEvent.type = 3;
      localTrackShopEvent.status = 0;
      localTrackShopEvent.list = paramList;
      localTrackShopEvent.trackQueryType = this.trackListQueryType;
      this.requestHandler.obtainMessage(1, localTrackShopEvent).sendToTarget();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/datashop/TrackMainListShop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */