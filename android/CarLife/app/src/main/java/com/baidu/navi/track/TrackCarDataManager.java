package com.baidu.navi.track;

import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.core.i;
import com.baidu.navi.track.database.DataBaseConstants.TrackQueryType;
import com.baidu.navi.track.datashop.TrackDataShop;
import com.baidu.navi.track.datashop.TrackShopEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TrackCarDataManager
{
  private static final String TAG = TrackCarDataManager.class.getSimpleName();
  private static TrackCarDataManager mInstance;
  private List<OnTrackShopListener> listenerList = new ArrayList();
  private MyHandler mHandler = new MyHandler(null);
  
  public static TrackCarDataManager getInstance()
  {
    if (mInstance == null) {
      mInstance = new TrackCarDataManager();
    }
    return mInstance;
  }
  
  private void notifyTrackShop(TrackShopEvent paramTrackShopEvent)
  {
    synchronized (this.listenerList)
    {
      if (this.listenerList != null)
      {
        Iterator localIterator = this.listenerList.iterator();
        if (localIterator.hasNext()) {
          ((OnTrackShopListener)localIterator.next()).callBack(paramTrackShopEvent);
        }
      }
    }
  }
  
  public void addRecord(Object paramObject, boolean paramBoolean)
  {
    TrackDataShop.getInstance().addRecord(paramObject, paramBoolean);
  }
  
  public void clearTrackReacords(String paramString)
  {
    TrackDataShop.getInstance().clearTrackReacords(paramString);
  }
  
  public void deleteRecord(Object paramObject)
  {
    TrackDataShop.getInstance().deleteRecord(this.mHandler, paramObject);
  }
  
  public void fetchStatistics(int paramInt)
  {
    TrackDataShop.getInstance().fetchStatistics(this.mHandler, paramInt);
  }
  
  public void fetchTrackList(String paramString, int paramInt, DataBaseConstants.TrackQueryType paramTrackQueryType)
  {
    TrackDataShop.getInstance().fetchTrackList(this.mHandler, paramString, paramInt, paramTrackQueryType);
  }
  
  public void registerListener(OnTrackShopListener paramOnTrackShopListener)
  {
    synchronized (this.listenerList)
    {
      if ((this.listenerList != null) && (paramOnTrackShopListener != null)) {
        this.listenerList.add(paramOnTrackShopListener);
      }
      return;
    }
  }
  
  public void unRegisterListener(OnTrackShopListener paramOnTrackShopListener)
  {
    synchronized (this.listenerList)
    {
      if ((this.listenerList != null) && (paramOnTrackShopListener != null)) {
        this.listenerList.remove(paramOnTrackShopListener);
      }
      return;
    }
  }
  
  private class MyHandler
    extends Handler
  {
    private MyHandler() {}
    
    public void handleMessage(Message paramMessage)
    {
      i.b(TrackCarDataManager.TAG, paramMessage.toString());
    }
  }
  
  public static abstract interface OnTrackShopListener
  {
    public abstract void callBack(TrackShopEvent paramTrackShopEvent);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/TrackCarDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */