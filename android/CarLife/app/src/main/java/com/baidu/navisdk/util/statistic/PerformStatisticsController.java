package com.baidu.navisdk.util.statistic;

import android.util.Log;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

public class PerformStatisticsController
{
  private static final String PERFORMANCE_TAG = "navi_perf";
  public static final String PoiToNaviStep2 = "基线到适配层";
  public static final String PoiToNaviStep3 = "适配层到SDK";
  public static final String PoiToNaviStep4 = "创建导航页面UI前的操作";
  public static final String PoiToNaviStep5 = "页面周期开始函数";
  public static final String PoiToNaviStep6 = "页面周期显示函数";
  public static final String RoutePageToNaviStep10 = "发起跳转导航界面";
  public static final String RoutePageToNaviStep11 = "导航界面生命周期开始";
  public static final String RoutePageToNaviStep12 = "导航界面生命周期显示";
  public static final String RoutePageToNaviStep2 = "基线到适配层";
  public static final String RoutePageToNaviStep3 = "适配层到SDK";
  public static final String RoutePageToNaviStep4 = "SDK到引擎";
  public static final String RoutePageToNaviStep8 = "引擎算路到SDK收到消息";
  public static final String RoutePageToNaviStep9 = "SDK到适配层";
  public static final String TAG = PerformStatisticsController.class.getSimpleName();
  private static PerformStatisticsController sInstance;
  public static long sPoiToNaviTime1 = 0L;
  public static long sPoiToNaviTime2 = 0L;
  public static long sPoiToNaviTime3 = 0L;
  public static long sPoiToNaviTime4 = 0L;
  public static long sPoiToNaviTime5 = 0L;
  public static long sPoiToNaviTime6 = 0L;
  public static long sRoutePageToNaviTime1 = 0L;
  public static long sRoutePageToNaviTime10;
  public static long sRoutePageToNaviTime11;
  public static long sRoutePageToNaviTime12;
  public static long sRoutePageToNaviTime2 = 0L;
  public static long sRoutePageToNaviTime3 = 0L;
  public static long sRoutePageToNaviTime4 = 0L;
  public static long sRoutePageToNaviTime8 = 0L;
  public static long sRoutePageToNaviTime9 = 0L;
  private File mBatchCoordsFile = null;
  private BufferedReader mBatchCoordsFileReader = null;
  private File mBatchTestResultFile = null;
  private FileWriter mBatchTestResultFileWriter = null;
  private int mCurNo = -1;
  private double mEndLa = -1.0D;
  private double mEndLo = -1.0D;
  private boolean mIsFirst = true;
  private IBNPerformStatListener mListener;
  private double mStartLa = -1.0D;
  private double mStartLo = -1.0D;
  
  static
  {
    sRoutePageToNaviTime10 = 0L;
    sRoutePageToNaviTime11 = 0L;
    sRoutePageToNaviTime12 = 0L;
  }
  
  public static PerformStatisticsController getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new PerformStatisticsController();
      }
      return sInstance;
    }
    finally {}
  }
  
  public static long getTimeByKey(String paramString)
  {
    if ((paramString != null) && (PerformStatItem.sTimeMap.containsKey(paramString))) {
      return ((Long)PerformStatItem.sTimeMap.get(paramString)).longValue();
    }
    return 0L;
  }
  
  public static void peByType(int paramInt, String paramString, long paramLong)
  {
    if (paramString != null) {
      PerformStatItem.sTimeMap.put(paramString, Long.valueOf(paramLong));
    }
    if ((PerformStatItem.sUserTest) && (paramInt >= 0) && (paramInt < PerformStatItem.P_LOGGABLE.length) && (PerformStatItem.P_LOGGABLE[paramInt] != 0)) {
      Log.e("navi_perf", "[T" + paramInt + "]-" + paramString + "-" + paramLong);
    }
  }
  
  public static void peDiffByType(final int paramInt)
  {
    if (!PerformStatItem.sUserTest) {
      return;
    }
    BNWorkerCenter.getInstance().submitNormalTaskDelay(new BNWorkerNormalTask("peDiffByType-" + PerformStatisticsController.class.getSimpleName(), null)new BNWorkerConfig
    {
      protected String execute()
      {
        PerformStatisticsController.peDiffByTypeInner(paramInt);
        return null;
      }
    }, new BNWorkerConfig(100, 0), 100L);
  }
  
  private static void peDiffByTypeInner(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 4: 
    case 5: 
    case 6: 
    default: 
      return;
    case 1: 
      Log.e("navi_perf", "[T" + paramInt + "]-poi算路总耗时：" + (getTimeByKey("sdk_routeguide_refresh_firstinfo") - getTimeByKey("map_poi_click_start")));
      Log.e("navi_perf", "[T" + paramInt + "]-poi算路上层耗时：" + (getTimeByKey("sdk_routeguide_resume_end") - getTimeByKey("map_poi_click_start")));
      Log.e("navi_perf", "[T" + paramInt + "]-poi算路引擎耗时：" + (getTimeByKey("sdk_routeguide_refresh_firstinfo") - getTimeByKey("sdk_start_lib_routeplan")));
      Log.e("navi_perf", "[T" + paramInt + "]-poi算路网络耗时：" + getTimeByKey("lib_network_server"));
      SDKDebugFileUtil.get("navi_perf_log", false, true).forceAdd("[T" + paramInt + "]-poi算路总耗时：" + (getTimeByKey("sdk_routeguide_refresh_firstinfo") - getTimeByKey("map_poi_click_start")));
      SDKDebugFileUtil.get("navi_perf_log", false, true).forceAdd("[T" + paramInt + "]-poi算路上层耗时：" + (getTimeByKey("sdk_routeguide_resume_end") - getTimeByKey("map_poi_click_start")));
      SDKDebugFileUtil.get("navi_perf_log", false, true).forceAdd("[T" + paramInt + "]-poi算路引擎耗时：" + (getTimeByKey("sdk_routeguide_refresh_firstinfo") - getTimeByKey("sdk_start_lib_routeplan")));
      SDKDebugFileUtil.get("navi_perf_log", false, true).forceAdd("[T" + paramInt + "]-poi算路网络耗时：" + getTimeByKey("lib_network_server"));
      return;
    case 3: 
      Log.e("navi_perf", "[T" + paramInt + "]-导航初始化总耗时：" + (getTimeByKey("ad_init_ok") - getTimeByKey("ad_init_start")));
      Log.e("navi_perf", "[T" + paramInt + "]-导航初始化引擎耗时：" + (getTimeByKey("sdk_initEngineBySync_lib_end") - getTimeByKey("sdk_initEngineBySync_lib_start")));
      SDKDebugFileUtil.get("navi_perf_log", false, true).forceAdd("[T" + paramInt + "]-导航初始化总耗时：" + (getTimeByKey("ad_init_ok") - getTimeByKey("ad_init_start")));
      SDKDebugFileUtil.get("navi_perf_log", false, true).forceAdd("[T" + paramInt + "]-导航初始化引擎耗时：" + (getTimeByKey("sdk_initEngineBySync_lib_end") - getTimeByKey("sdk_initEngineBySync_lib_start")));
      return;
    case 7: 
      Log.e("navi_perf", "[T" + paramInt + "]-quitNav动画结束时间：" + (getTimeByKey("on_quit_nav_anim_end") - getTimeByKey("on_quit_nav_click")));
      Log.e("navi_perf", "[T" + paramInt + "]-quitNav接口耗时：" + (getTimeByKey("on_quit_nav_end") - getTimeByKey("on_quit_nav_click")));
      Log.e("navi_perf", "[T" + paramInt + "]-quitNav页面destory：" + (getTimeByKey("on_quit_nav_destory") - getTimeByKey("on_quit_nav_click")));
      SDKDebugFileUtil.get("navi_perf_log", false, true).forceAdd("[T" + paramInt + "]-quitNav接口耗时：" + (getTimeByKey("on_quit_nav_end") - getTimeByKey("on_quit_nav_click")));
      SDKDebugFileUtil.get("navi_perf_log", false, true).forceAdd("[T" + paramInt + "]-quitNav页面destory：" + (getTimeByKey("on_quit_nav_destory") - getTimeByKey("on_quit_nav_click")));
      return;
    }
    Log.e("navi_perf", "[T" + paramInt + "]-导航结束页创建耗时：" + (getTimeByKey("nav_result_resume_time") - getTimeByKey("nav_result_create_time")));
    Log.e("navi_perf", "[T" + paramInt + "]-导航结束页+退出导航总体耗时：" + (getTimeByKey("nav_result_resume_time") - getTimeByKey("on_quit_nav_click")));
    SDKDebugFileUtil.get("navi_perf_log", false, true).forceAdd("[T" + paramInt + "]-导航结束页创建耗时：" + (getTimeByKey("nav_result_resume_time") - getTimeByKey("nav_result_create_time")));
    SDKDebugFileUtil.get("navi_perf_log", false, true).forceAdd("[T" + paramInt + "]-导航结束页+退出导航总体耗时：" + (getTimeByKey("nav_result_resume_time") - getTimeByKey("on_quit_nav_click")));
  }
  
  public boolean addDataLog(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if (this.mListener == null) {
      return false;
    }
    paramString3 = paramString2 + "-" + paramString3 + "-" + paramString4 + "=" + paramLong;
    paramString2 = new JSONObject();
    try
    {
      paramString2.put(paramString1, paramString3);
      LogUtil.e(TAG, "ret.toString() = " + paramString2.toString());
      return this.mListener.onLogRecord(paramInt1, paramInt2, paramString1, paramString2.toString());
    }
    catch (Exception paramString3)
    {
      for (;;) {}
    }
  }
  
  public void addRoutePlanSuccessLog(long paramLong)
  {
    addTimeLog(2110, 1, "CarRoutePlanTime", "17", "MapBaseLine", "RoutePlanSuccess", PerformStatItem.sRoutePlanSuccessNormalStart, paramLong);
  }
  
  public boolean addTimeLog(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    if (this.mListener == null) {
      return false;
    }
    paramString3 = paramString2 + "-" + paramString3 + "-" + paramString4 + "_" + paramLong1 + "_" + paramLong2 + "=" + (paramLong2 - paramLong1);
    paramString2 = new JSONObject();
    try
    {
      paramString2.put(paramString1, paramString3);
      LogUtil.e(TAG, "ret.toString() = " + paramString2.toString());
      return this.mListener.onLogRecord(paramInt1, paramInt2, paramString1, paramString2.toString());
    }
    catch (Exception paramString3)
    {
      for (;;) {}
    }
  }
  
  public boolean addTimeLogForPoiGoToNavi(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    return addTimeLog(2110, 1, "PoiCarNaviTime", paramString1, paramString3, paramString2, paramLong1, paramLong2);
  }
  
  public boolean addTimeLogForRoutePageGoToNavi(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    return addTimeLog(2110, 1, "CarNaviTime", paramString1, paramString3, paramString2, paramLong1, paramLong2);
  }
  
  public void nextBatchTestNetworkAndServer(final long paramLong, int paramInt, final boolean paramBoolean)
  {
    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("nextBatchTestNetworkAndServer-" + getClass().getSimpleName(), null)new BNWorkerConfig
    {
      protected String execute()
      {
        PerformStatisticsController.this.nextBatchTestNetworkAndServerInner(paramLong, paramBoolean, this.val$isOK);
        return null;
      }
    }, new BNWorkerConfig(100, 0), 2000L);
  }
  
  public void nextBatchTestNetworkAndServerInner(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (!PerformStatItem.sBatchTestNetworkAndServerTime) {}
    label452:
    do
    {
      return;
      if (!this.mIsFirst) {}
      for (;;)
      {
        try
        {
          if (this.mBatchTestResultFileWriter != null)
          {
            localObject1 = this.mBatchTestResultFileWriter;
            localObject2 = new StringBuilder().append("").append(this.mCurNo).append("\t").append(paramLong).append("\t");
            if (!paramBoolean) {
              continue;
            }
            paramInt = 1;
            ((FileWriter)localObject1).write(paramInt + "\n");
            this.mBatchTestResultFileWriter.flush();
          }
        }
        catch (IOException localIOException)
        {
          Object localObject1;
          Object localObject2;
          localIOException.printStackTrace();
          continue;
          if (this.mBatchCoordsFileReader == null) {
            break label452;
          }
          this.mBatchCoordsFileReader.close();
        }
        this.mIsFirst = false;
        if (this.mBatchCoordsFileReader == null) {
          break;
        }
        try
        {
          localObject1 = this.mBatchCoordsFileReader.readLine();
          Log.e("navi_perf", "batch:" + (String)localObject1);
          if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
            continue;
          }
          Object localObject3 = ((String)localObject1).split("\\|");
          if (localObject3.length != 3) {
            break;
          }
          this.mCurNo = Integer.parseInt(localObject3[0]);
          localObject1 = null;
          localObject2 = null;
          Object localObject4 = localObject3[1].split(",");
          if (localObject4.length == 2)
          {
            this.mStartLo = Double.parseDouble(localObject4[0]);
            this.mStartLa = Double.parseDouble(localObject4[1]);
            localObject1 = CoordinateTransformUtil.transferWGS84ToGCJ02(this.mStartLo, this.mStartLa);
          }
          localObject3 = localObject3[2].split(",");
          if (localObject3.length == 2)
          {
            this.mEndLo = Double.parseDouble(localObject3[0]);
            this.mEndLa = Double.parseDouble(localObject3[1]);
            localObject2 = CoordinateTransformUtil.transferWGS84ToGCJ02(this.mEndLo, this.mEndLa);
          }
          if ((localObject1 == null) || (localObject2 == null)) {
            break;
          }
          localObject3 = new ArrayList();
          localObject4 = new RoutePlanNode();
          ((RoutePlanNode)localObject4).setGeoPoint((GeoPoint)localObject1);
          ((RoutePlanNode)localObject4).setFrom(1);
          localObject1 = new RoutePlanNode();
          ((RoutePlanNode)localObject1).setGeoPoint((GeoPoint)localObject2);
          ((RoutePlanNode)localObject1).setFrom(1);
          ((ArrayList)localObject3).add(localObject4);
          ((ArrayList)localObject3).add(localObject1);
          BNRoutePlaner.getInstance().triggerGPSStatus(2);
          BNRoutePlaner.getInstance().setCalcPrference(1);
          BNRoutePlaner.getInstance().setEntry(5);
          BNRoutePlaner.getInstance().setPointsToCalcRoute((ArrayList)localObject3, -1, false, null, 0);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        paramInt = 0;
      }
    } while (this.mBatchTestResultFileWriter == null);
    this.mBatchTestResultFileWriter.flush();
    this.mBatchTestResultFileWriter.close();
  }
  
  public void setPerformStatListener(IBNPerformStatListener paramIBNPerformStatListener)
  {
    this.mListener = paramIBNPerformStatListener;
  }
  
  public void startBatchTestNetworkAndServer()
  {
    if (!PerformStatItem.sBatchTestNetworkAndServerTime) {
      return;
    }
    this.mBatchCoordsFile = new File(SysOSAPI.getInstance().GetSDCardPath() + "/batch_test_coords.txt");
    if (this.mBatchCoordsFile.exists())
    {
      this.mBatchTestResultFile = new File(SysOSAPI.getInstance().GetSDCardPath() + "/batch_test_result.txt");
      try
      {
        if (this.mBatchTestResultFile.exists())
        {
          this.mBatchTestResultFile.delete();
          this.mBatchTestResultFile = new File(SysOSAPI.getInstance().GetSDCardPath() + "/batch_test_result.txt");
        }
        this.mBatchTestResultFile.createNewFile();
        this.mBatchTestResultFileWriter = new FileWriter(this.mBatchTestResultFile);
        this.mBatchCoordsFileReader = new BufferedReader(new FileReader(this.mBatchCoordsFile));
        nextBatchTestNetworkAndServer(-1L, -1, false);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.mBatchCoordsFile = null;
        this.mBatchCoordsFileReader = null;
        this.mBatchTestResultFile = null;
        return;
      }
    }
    this.mBatchCoordsFile = null;
    this.mBatchCoordsFileReader = null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/PerformStatisticsController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */