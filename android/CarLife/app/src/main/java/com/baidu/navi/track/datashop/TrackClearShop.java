package com.baidu.navi.track.datashop;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.core.a;
import com.baidu.carlife.core.i;
import com.baidu.navi.track.database.DataCache;
import com.baidu.navi.track.database.DataService;
import com.baidu.navi.track.database.DataService.Action;
import com.baidu.navi.track.model.TrackDBEvent;

public class TrackClearShop
{
  private static final String TAG = "TrackClearShop";
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what != 4) {}
      TrackDBEvent localTrackDBEvent;
      do
      {
        do
        {
          return;
          i.b("TrackClearShop", "handleMessage msg = " + paramAnonymousMessage);
          localTrackDBEvent = null;
          if ((paramAnonymousMessage.obj instanceof TrackDBEvent)) {
            localTrackDBEvent = (TrackDBEvent)paramAnonymousMessage.obj;
          }
        } while (localTrackDBEvent == null);
        i.b("TrackClearShop", "dbEvent.type = " + localTrackDBEvent.type);
      } while (localTrackDBEvent.type != 12);
      i.b("TrackClearShop", "dbEvent.status = " + localTrackDBEvent.status);
    }
  };
  private String useId;
  
  private void cleanTrackRecordsFromDb(String paramString)
  {
    a locala = a.a();
    Intent localIntent = new Intent(locala, DataService.class);
    localIntent.putExtra("handler", DataCache.getInstance().addCache(this.mHandler));
    localIntent.putExtra("useid", paramString);
    localIntent.setAction(DataService.Action.ACTION_CLEAR_TRACK_BY_BDUID.toString());
    locala.startService(localIntent);
  }
  
  public void clearTrack(String paramString)
  {
    this.useId = paramString;
    cleanTrackRecordsFromDb(paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/datashop/TrackClearShop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */