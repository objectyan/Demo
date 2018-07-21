package com.baidu.navi.track.datashop;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.navi.track.database.DataBaseConstants.TrackQueryType;

public class TrackDataShop
{
  public static final String[] INVALID_ARRDS = { "我的位置", "地图上的点", "未知路", "当前道路" };
  public static final int MAX_INT_VALUE = Integer.MAX_VALUE;
  public static final String SPECIAL_ADDR_IN_TRACK = "无名路";
  
  public static TrackDataShop getInstance()
  {
    return Holder.sInstance;
  }
  
  public static boolean isAddrValid(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= INVALID_ARRDS.length) {
        break label38;
      }
      if (INVALID_ARRDS[i].equals(paramString)) {
        break;
      }
      i += 1;
    }
    label38:
    return true;
  }
  
  public void addRecord(Object paramObject, boolean paramBoolean)
  {
    new TrackAddShop().addRecord(paramObject, paramBoolean);
  }
  
  public void clearBeforSixMonthGPSFile(String paramString)
  {
    new TrackMainListShop(null).clearBeforSixMonthGPSFile(paramString);
  }
  
  public void clearTrackReacords(String paramString)
  {
    new TrackClearShop().clearTrack(paramString);
  }
  
  public void deleteRecord(Handler paramHandler, Object paramObject)
  {
    new TrackDeleteShop(paramHandler).deleteTrackRecord(paramObject);
  }
  
  public void fetchStatistics(Handler paramHandler, int paramInt)
  {
    new TrackStatisticShop(paramHandler).fetchStatistic(paramInt);
  }
  
  public void fetchTrackList(Handler paramHandler, String paramString, int paramInt1, int paramInt2, DataBaseConstants.TrackQueryType paramTrackQueryType)
  {
    new TrackMainListShop(paramHandler).fetchTrackList(paramString, paramInt1, paramInt2, paramTrackQueryType);
  }
  
  public void fetchTrackList(Handler paramHandler, String paramString, int paramInt, DataBaseConstants.TrackQueryType paramTrackQueryType)
  {
    new TrackMainListShop(paramHandler).fetchTrackList(paramString, paramInt, paramTrackQueryType);
  }
  
  public void updateNotLoginTracksBduis(String paramString)
  {
    new TrackModifyShop().updateNotLoginTracksBduis(paramString);
  }
  
  static class Holder
  {
    static final TrackDataShop sInstance = new TrackDataShop(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/datashop/TrackDataShop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */