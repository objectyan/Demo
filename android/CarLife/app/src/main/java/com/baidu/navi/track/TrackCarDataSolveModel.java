package com.baidu.navi.track;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.baidunavis.control.NavTrajectoryController;
import com.baidu.baidunavis.model.TrajectoryGPSData;
import com.baidu.baidunavis.model.TrajectorySummaryInfo;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.f.a;
import com.baidu.carlife.core.i;
import com.baidu.carlife.l.a;
import com.baidu.carlife.protobuf.CarlifeStatisticsInfoProto.CarlifeStatisticsInfo;
import com.baidu.navi.track.common.TrackConfig;
import com.baidu.navi.track.datashop.TrackDataShop;
import com.baidu.navi.track.model.CarNavi;
import com.baidu.navi.track.model.CarNaviModel;
import com.baidu.navi.track.model.NaviPoint;
import com.baidu.navi.track.util.TrackFileUtil;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;

public class TrackCarDataSolveModel
{
  private static final int CAR_DISTANCE_MIN_LIMIT = 200;
  private static final String CRASH_NAVI_GUID = "1111111111";
  private static final String TAG = TrackCarDataSolveModel.class.getSimpleName();
  public static String carCUID;
  public static String carChannel;
  public static String carVersion;
  public static boolean isConnect;
  public static GeoPoint mFinalGeoPoint = null;
  public static GeoPoint mFirstGeoPoint = null;
  
  private void dataError()
  {
    i.b(TAG, "dataError");
  }
  
  private void endDataProcess(CarNaviModel paramCarNaviModel, boolean paramBoolean)
  {
    TrackDataShop.getInstance().addRecord(paramCarNaviModel, true);
  }
  
  private TrackSolveData getTrackSolveData(Bundle paramBundle, String paramString)
  {
    if ((paramBundle == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    double d1;
    do
    {
      try
      {
        Object localObject2 = NavTrajectoryController.getInstance().getTrajectoryGPSList(paramString);
        Object localObject1 = paramBundle.getString("start_addr");
        String str = paramBundle.getString("end_addr");
        int i = Integer.valueOf(paramBundle.getString("distance")).intValue();
        int j = Integer.valueOf(paramBundle.getString("c_time")).intValue();
        int k = Integer.valueOf(paramBundle.getString("duration")).intValue();
        double d2 = Double.valueOf(paramBundle.getString("ave_speed")).doubleValue();
        if ((localObject2 != null) && (((ArrayList)localObject2).size() >= 2) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str)) && (i >= 200) && (j != 0) && (k != 0) && (d2 != 0.0D))
        {
          d1 = 0.0D;
          paramBundle = ((ArrayList)localObject2).iterator();
          while (paramBundle.hasNext())
          {
            localObject2 = (TrajectoryGPSData)paramBundle.next();
            if ((localObject2 != null) && (d1 < ((TrajectoryGPSData)localObject2).mSpeed)) {
              d1 = ((TrajectoryGPSData)localObject2).mSpeed;
            }
          }
          if ((!mFirstGeoPoint.isValid()) || (!mFinalGeoPoint.isValid())) {
            break;
          }
          paramBundle = new CarNaviModel();
          localObject2 = TrackFileUtil.trackFileSign(paramBundle.getSDcardPath(), paramString);
          paramBundle.setSyncState(3);
          CarNavi localCarNavi = new CarNavi();
          localCarNavi.setSid("");
          localCarNavi.setGuid(paramString);
          GeoPoint localGeoPoint = CoordinateTransformUtil.transferGCJ02ToBD09(mFirstGeoPoint.getLongitudeE6() / 100000.0D, mFirstGeoPoint.getLatitudeE6() / 100000.0D);
          paramString = CoordinateTransformUtil.transferGCJ02ToBD09(mFinalGeoPoint.getLongitudeE6() / 100000.0D, mFinalGeoPoint.getLatitudeE6() / 100000.0D);
          NaviPoint localNaviPoint = new NaviPoint();
          localNaviPoint.setAddr((String)localObject1);
          localNaviPoint.setLng(localGeoPoint.getLongitudeE6() / 100000.0D);
          localNaviPoint.setLat(localGeoPoint.getLatitudeE6() / 100000.0D);
          localCarNavi.setStartPoint(localNaviPoint);
          localObject1 = new NaviPoint();
          ((NaviPoint)localObject1).setAddr(str);
          ((NaviPoint)localObject1).setLng(paramString.getLongitudeE6() / 100000.0D);
          ((NaviPoint)localObject1).setLat(paramString.getLatitudeE6() / 100000.0D);
          localCarNavi.setEndPoint((NaviPoint)localObject1);
          localCarNavi.setType("car_navi");
          localCarNavi.setCtime(j);
          localCarNavi.setModifyTime(j);
          localCarNavi.setSign((String)localObject2);
          localCarNavi.setAvgSpeed(Math.round(1000.0D * d2) / 1000.0D);
          localCarNavi.setMaxSpeed(Math.round(1000.0D * d1) / 1000.0D);
          localCarNavi.setDuration(k);
          localCarNavi.setDistance(i);
          paramBundle.setPBData(localCarNavi);
          paramString = new TrackSolveData(null);
          paramString.model = paramBundle;
          return paramString;
        }
      }
      catch (Exception paramBundle)
      {
        return null;
      }
      return null;
    } while (d1 != 0.0D);
    return null;
    return null;
  }
  
  public static void setCarlifeStatisticsInfo(CarlifeStatisticsInfoProto.CarlifeStatisticsInfo paramCarlifeStatisticsInfo)
  {
    if (paramCarlifeStatisticsInfo != null)
    {
      carCUID = paramCarlifeStatisticsInfo.getCuid();
      carVersion = paramCarlifeStatisticsInfo.getVersionName();
      carChannel = f.jx.a();
      isConnect = true;
      return;
    }
    isConnect = false;
    carCUID = "";
    carChannel = "";
    carVersion = "";
  }
  
  private void transCarNaviData()
  {
    Object localObject = NavTrajectoryController.getInstance().getCurrentTrajectorySummaryInfo();
    if (localObject == null)
    {
      dataError();
      return;
    }
    localObject = ((TrajectorySummaryInfo)localObject).toBundle();
    String str = ((Bundle)localObject).getString("guid");
    boolean bool = ((Bundle)localObject).getBoolean("has_mock_gps", true);
    localObject = getTrackSolveData((Bundle)localObject, str);
    if (localObject == null)
    {
      dataError();
      return;
    }
    if (!a.a().N()) {
      setCarlifeStatisticsInfo(null);
    }
    endDataProcess(((TrackSolveData)localObject).model, bool);
  }
  
  public void process()
  {
    if (!TrackConfig.getInstance().isOpenNavigateRecord()) {
      return;
    }
    new Thread()
    {
      public void run()
      {
        if (Looper.myLooper() == null) {
          Looper.prepare();
        }
        TrackCarDataSolveModel.this.transCarNaviData();
        Looper.loop();
      }
    }.start();
  }
  
  private class TrackSolveData
  {
    CarNaviModel model;
    
    private TrackSolveData() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/TrackCarDataSolveModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */