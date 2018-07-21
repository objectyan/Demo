package com.baidu.navi.track.datashop;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.core.a;
import com.baidu.carlife.core.i;
import com.baidu.navi.track.common.TrackConfig;
import com.baidu.navi.track.database.DataCache;
import com.baidu.navi.track.database.DataService;
import com.baidu.navi.track.database.DataService.Action;
import com.baidu.navi.track.model.CarNavi;
import com.baidu.navi.track.model.CarNaviModel;
import com.baidu.navi.track.model.NaviPoint;
import com.baidu.navi.track.model.TrackDBEvent;
import com.baidu.navi.track.sync.TrackDataSync;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class TrackAddShop
{
  private static final String DefaultTrackName = "未知路";
  private static final int SEARCH_POI_TIMEOUT = 120000;
  private static final String TAG = "TrackAddShop";
  private int geoSearchCount = 0;
  private boolean isSync = false;
  private Object lockObject = new Object();
  protected HashMap<Handler, String> mEndGeoTrackId = new HashMap();
  private Handler mHandler = new MyHandler(null);
  protected HashMap<Handler, String> mStartGeoTrackId = new HashMap();
  private Object originalObject;
  
  private void addRecord(Object paramObject)
  {
    if (paramObject != null) {}
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramObject);
      paramObject = a.a();
      Intent localIntent = new Intent((Context)paramObject, DataService.class);
      localIntent.putExtra("handler", DataCache.getInstance().addCache(this.mHandler));
      localIntent.setAction(DataService.Action.ACTION_WRITE_TRACK_TO_DB.toString());
      localIntent.putExtra("cache_key", DataCache.getInstance().addCache(localArrayList));
      ((Context)paramObject).startService(localIntent);
      return;
    }
    catch (Exception paramObject) {}
  }
  
  private void checkRecordEndName()
  {
    if ((this.originalObject == null) || (!(this.originalObject instanceof CarNaviModel))) {}
    Object localObject;
    String str;
    do
    {
      return;
      localObject = ((CarNaviModel)this.originalObject).getPBData().getEndPoint();
      localObject = CoordinateTransformUtil.transferBD09ToGCJ02(((NaviPoint)localObject).getLng(), ((NaviPoint)localObject).getLat());
      str = ((CarNaviModel)this.originalObject).getPBData().getGuid();
    } while ((localObject == null) || (TextUtils.isEmpty(str)));
    SearchHandler localSearchHandler = new SearchHandler(Looper.getMainLooper());
    this.mEndGeoTrackId.put(localSearchHandler, str);
    startAntiGeo((GeoPoint)localObject, localSearchHandler);
  }
  
  private void checkRecordStartName()
  {
    if ((this.originalObject == null) || (!(this.originalObject instanceof CarNaviModel))) {}
    Object localObject1;
    GeoPoint localGeoPoint;
    do
    {
      return;
      localObject1 = ((CarNaviModel)this.originalObject).getPBData().getStartPoint();
      localGeoPoint = CoordinateTransformUtil.transferBD09ToGCJ02(((NaviPoint)localObject1).getLng(), ((NaviPoint)localObject1).getLat());
      localObject2 = ((NaviPoint)localObject1).getAddr();
      localObject1 = ((CarNaviModel)this.originalObject).getPBData().getGuid();
    } while ((localGeoPoint == null) || (TextUtils.isEmpty((CharSequence)localObject1)) || ((localObject2 != null) && (((String)localObject2).length() != 0) && (!((String)localObject2).equals("我的位置")) && (!((String)localObject2).equals("地图上的点"))));
    Object localObject2 = new SearchHandler(Looper.getMainLooper());
    this.mStartGeoTrackId.put(localObject2, localObject1);
    startAntiGeo(localGeoPoint, (SearchHandler)localObject2);
  }
  
  private void releaseShop()
  {
    this.originalObject = null;
    this.mStartGeoTrackId.clear();
    this.mEndGeoTrackId.clear();
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
  }
  
  private void startAntiGeo(GeoPoint paramGeoPoint, SearchHandler paramSearchHandler)
  {
    if ((!NetworkUtils.isNetworkAvailable(a.a())) && (!hasCurLocationCityOfflineData(paramGeoPoint))) {
      return;
    }
    this.geoSearchCount += 1;
    BNPoiSearcher.getInstance().asynGetPoiByPoint(paramGeoPoint, 120000, paramSearchHandler);
  }
  
  private void updateRecord(Object paramObject)
  {
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramObject);
      paramObject = a.a();
      Intent localIntent = new Intent((Context)paramObject, DataService.class);
      localIntent.putExtra("handler", DataCache.getInstance().addCache(this.mHandler));
      localIntent.setAction(DataService.Action.ACTION_UPDATE_TRACK_INFO_BY_LIST.toString());
      localIntent.putExtra("cache_key", DataCache.getInstance().addCache(localArrayList));
      ((Context)paramObject).startService(localIntent);
    }
  }
  
  public void addRecord(Object paramObject, boolean paramBoolean)
  {
    if (paramObject == null) {
      return;
    }
    this.originalObject = paramObject;
    this.isSync = paramBoolean;
    addRecord(paramObject);
    checkRecordStartName();
    checkRecordEndName();
  }
  
  public boolean hasCurLocationCityOfflineData(GeoPoint paramGeoPoint)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0))
    {
      for (paramGeoPoint = BNPoiSearcher.getInstance().getDistrictByPoint(paramGeoPoint, 0); (paramGeoPoint != null) && (paramGeoPoint.mType > 2); paramGeoPoint = BNPoiSearcher.getInstance().getParentDistrict(paramGeoPoint.mId)) {}
      bool1 = bool2;
      if (paramGeoPoint != null) {
        bool1 = BNOfflineDataManager.getInstance().isProvinceDataDownload(paramGeoPoint.mId);
      }
    }
    return bool1;
  }
  
  private class MyHandler
    extends Handler
  {
    private MyHandler() {}
    
    public void handleMessage(Message arg1)
    {
      if (???.what != 2) {}
      TrackDBEvent localTrackDBEvent;
      do
      {
        do
        {
          return;
          i.b("TrackAddShop", "handleMessage msg = " + ???);
          localTrackDBEvent = null;
          if ((???.obj instanceof TrackDBEvent)) {
            localTrackDBEvent = (TrackDBEvent)???.obj;
          }
        } while (localTrackDBEvent == null);
        i.b("TrackAddShop", "dbEvent.type = " + localTrackDBEvent.type);
      } while (localTrackDBEvent.type != 1);
      i.b("TrackAddShop", "dbEvent.status = " + localTrackDBEvent.status);
      int i = TrackConfig.getInstance().getTotalDistanse();
      int j = TrackConfig.getInstance().getWeekEndTime();
      int k = TrackConfig.getInstance().getMaxTime();
      int n;
      int i2;
      if ((TrackAddShop.this.originalObject != null) && ((TrackAddShop.this.originalObject instanceof CarNaviModel)) && (i > 0) && (j > 0) && (k > 0))
      {
        int m = TrackConfig.getInstance().getWeekDistanse();
        n = ((CarNaviModel)TrackAddShop.this.originalObject).getPBData().getDistance();
        int i1 = ((CarNaviModel)TrackAddShop.this.originalObject).getPBData().getDuration();
        i2 = ((CarNaviModel)TrackAddShop.this.originalObject).getPBData().getCtime();
        TrackConfig.getInstance().setTotalDistanse(n + i);
        if (k < i1) {
          TrackConfig.getInstance().setMaxTime(i1);
        }
        if ((i2 < j - 604800) || (i2 >= j)) {
          break label410;
        }
        TrackConfig.getInstance().setWeekDistanse(n + m);
      }
      for (;;)
      {
        synchronized (TrackAddShop.this.lockObject)
        {
          if ((TrackAddShop.this.isSync) && (TrackAddShop.this.geoSearchCount == 0) && (TrackAddShop.this.originalObject != null))
          {
            i.b("TrackAddShop", "originalObject : " + TrackAddShop.this.originalObject.toString());
            TrackDataSync.getInstance().autoSync(TrackAddShop.this.originalObject);
          }
          if (TrackAddShop.this.geoSearchCount == 0) {
            TrackAddShop.this.releaseShop();
          }
          return;
        }
        label410:
        if (i2 > j)
        {
          ??? = Calendar.getInstance();
          ???.set(7, 2);
          ???.set(11, 0);
          ???.set(12, 0);
          ???.set(13, 0);
          long l2 = ???.getTimeInMillis() / 1000L + 604800L;
          long l1 = l2;
          if (???.getTimeInMillis() > System.currentTimeMillis()) {
            l1 = l2 - 604800L;
          }
          TrackConfig.getInstance().setWeekDistanse(n);
          TrackConfig.getInstance().setWeekEndTime((int)l1);
        }
      }
    }
  }
  
  class SearchHandler
    extends Handler
  {
    public SearchHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message arg1)
    {
      switch (???.what)
      {
      default: 
        return;
      }
      if (???.arg1 == 0)
      {
        ??? = (SearchPoi)((RspData)???.obj).mData;
        if (??? != null)
        {
          if (!TrackAddShop.this.mStartGeoTrackId.containsKey(this)) {
            break label301;
          }
          String str1 = (String)TrackAddShop.this.mStartGeoTrackId.get(this);
          if (TextUtils.isEmpty(???.mName)) {
            ???.mName = "未知路";
          }
          if ((TrackAddShop.this.originalObject != null) && ((TrackAddShop.this.originalObject instanceof CarNaviModel)) && (((CarNaviModel)TrackAddShop.this.originalObject).getPBData().getGuid().equals(str1))) {
            ((CarNaviModel)TrackAddShop.this.originalObject).getPBData().getStartPoint().setAddr(???.mName);
          }
          ??? = ???.mName;
          i.b("TrackAddShop", "trackStartName:" + ???);
        }
      }
      for (;;)
      {
        if (TrackAddShop.this.mStartGeoTrackId.remove(this) == null) {
          TrackAddShop.this.mEndGeoTrackId.remove(this);
        }
        synchronized (TrackAddShop.this.lockObject)
        {
          TrackAddShop.access$310(TrackAddShop.this);
          if ((TrackAddShop.this.geoSearchCount == 0) && (TrackAddShop.this.originalObject != null))
          {
            TrackAddShop.this.updateRecord(TrackAddShop.this.originalObject);
            TrackDataSync.getInstance().autoSync(TrackAddShop.this.originalObject);
            TrackAddShop.this.releaseShop();
          }
          return;
        }
        label301:
        if (TrackAddShop.this.mEndGeoTrackId.containsKey(this))
        {
          String str2 = (String)TrackAddShop.this.mEndGeoTrackId.get(this);
          if (TextUtils.isEmpty(???.mName)) {
            ???.mName = "未知路";
          }
          if ((TrackAddShop.this.originalObject != null) && ((TrackAddShop.this.originalObject instanceof CarNaviModel)) && (((CarNaviModel)TrackAddShop.this.originalObject).getPBData().getGuid().equals(str2))) {
            ((CarNaviModel)TrackAddShop.this.originalObject).getPBData().getEndPoint().setAddr(???.mName);
          }
          ??? = ???.mName;
          i.b("TrackAddShop", "trackEndName:" + ???);
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/datashop/TrackAddShop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */