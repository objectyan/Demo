package com.baidu.navisdk.comapi.poisearch;

import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.jni.nativeif.JNISearchControl;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.commandparser.CmdRouteSearchForMapPoiResultPB;
import com.baidu.navisdk.logic.commandparser.CmdSearchAroundPark;
import com.baidu.navisdk.logic.commandparser.CmdSearchByCircleForMapPoiResultPB;
import com.baidu.navisdk.logic.commandparser.CmdSearchByKey;
import com.baidu.navisdk.logic.commandparser.CmdSearchByKeyForMapPoiResultPB;
import com.baidu.navisdk.logic.commandparser.CmdSearchByKeyForMapRPNodePoiResultPB;
import com.baidu.navisdk.logic.commandparser.CmdSearchByPoint;
import com.baidu.navisdk.logic.commandparser.CmdSearchGetSug;
import com.baidu.navisdk.logic.commandparser.CmdSearchNearest;
import com.baidu.navisdk.logic.commandparser.CmdSearchWithPager;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.SearchCircle;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNDebugModelDialog;
import com.baidu.navisdk.ui.widget.BNUserKeyLogDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.drivertool.BNDrivingToolManager;
import com.baidu.navisdk.util.testtts.TTSTestCenter;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Locale;

public class BNPoiSearcher
  implements JNISearchConst, CommandConst
{
  private static final String SEARCH_FACTORY_MODE_SECRET = "最好用的导航";
  private static final String SEARCH_FACTORY_MODE_TTS = "最好用的tts";
  private static final String SEARCH_FACTORY_MODE_USER_KEY_LOG = "最好用的百度地图";
  private static final String TAG = BNPoiSearcher.class.getSimpleName();
  private static BNPoiSearcher mInstance;
  
  public static BNPoiSearcher getInstance()
  {
    if (mInstance == null) {
      mInstance = new BNPoiSearcher();
    }
    return mInstance;
  }
  
  private void quickSortByDistance(ArrayList<Double> paramArrayList, int paramInt1, int paramInt2, ArrayList<SearchPoi> paramArrayList1)
  {
    if ((paramInt1 >= paramInt2) || (paramInt1 < 0) || (paramArrayList == null) || (paramArrayList1 == null) || (paramInt2 >= paramArrayList.size()) || (paramInt2 >= paramArrayList1.size())) {
      return;
    }
    int i = paramInt1;
    int j = paramInt2;
    double d = ((Double)paramArrayList.get(paramInt1)).doubleValue();
    SearchPoi localSearchPoi = (SearchPoi)paramArrayList1.get(paramInt1);
    while (i < j)
    {
      while ((i < j) && (((Double)paramArrayList.get(j)).doubleValue() >= d)) {
        j -= 1;
      }
      paramArrayList.set(i, paramArrayList.get(j));
      paramArrayList1.set(i, paramArrayList1.get(j));
      while ((i < j) && (((Double)paramArrayList.get(i)).doubleValue() < d)) {
        i += 1;
      }
      paramArrayList.set(j, paramArrayList.get(i));
      paramArrayList1.set(j, paramArrayList1.get(i));
    }
    paramArrayList.set(i, Double.valueOf(d));
    paramArrayList1.set(i, localSearchPoi);
    quickSortByDistance(paramArrayList, paramInt1, i - 1, paramArrayList1);
    quickSortByDistance(paramArrayList, i + 1, paramInt2, paramArrayList1);
  }
  
  public boolean asynGetDistrictByPoint(GeoPoint paramGeoPoint, int paramInt, Handler paramHandler)
  {
    if ((paramGeoPoint == null) || (!paramGeoPoint.isValid())) {
      return false;
    }
    if (!BNaviEngineManager.getInstance().isEngineInitSucc())
    {
      LogUtil.e("PoiSearch", "engine is not init succ...");
      return false;
    }
    paramHandler = new ReqData("cmd.search.bypoint", 1, paramHandler, 1003, paramInt);
    CmdSearchByPoint.packetParams(paramHandler, 2, paramGeoPoint);
    CommandCenter.getInstance().sendRequest(paramHandler);
    return true;
  }
  
  public boolean asynGetInputSug(String paramString, int paramInt1, int paramInt2, Handler paramHandler)
  {
    if (paramString == null) {
      return false;
    }
    paramString = paramString.trim();
    if (paramString.length() <= 0) {
      return false;
    }
    paramHandler = new ReqData("cmd.search.getsug", 1, paramHandler, 1004, paramInt2);
    CmdSearchGetSug.packetParams(paramHandler, paramString, paramInt1);
    CommandCenter.getInstance().sendRequest(paramHandler);
    return true;
  }
  
  public boolean asynGetPoiByPoint(GeoPoint paramGeoPoint, int paramInt1, int paramInt2, Handler paramHandler)
  {
    if (paramGeoPoint == null) {
      return false;
    }
    paramHandler = new ReqData("cmd.search.bypoint", 1, paramHandler, 1003, paramInt2);
    CmdSearchByPoint.packetParams(paramHandler, 1, paramGeoPoint, paramInt1);
    CommandCenter.getInstance().sendRequest(paramHandler);
    return true;
  }
  
  public boolean asynGetPoiByPoint(GeoPoint paramGeoPoint, int paramInt, Handler paramHandler)
  {
    if (paramGeoPoint == null) {
      return false;
    }
    paramHandler = new ReqData("cmd.search.bypoint", 1, paramHandler, 1003, paramInt);
    CmdSearchByPoint.packetParams(paramHandler, 1, paramGeoPoint);
    CommandCenter.getInstance().sendRequest(paramHandler);
    return true;
  }
  
  public boolean asynNameSearchByKey(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Handler paramHandler)
  {
    if (paramString == null) {
      return false;
    }
    paramString = paramString.trim();
    if (paramString.length() <= 0) {
      return false;
    }
    paramHandler = new ReqData("cmd.search.bykey", 1, paramHandler, 1001, paramInt4);
    CmdSearchByKey.packetParams(paramHandler, paramString, paramInt1, paramInt2, paramInt3);
    CommandCenter.getInstance().sendRequest(paramHandler);
    return true;
  }
  
  public boolean asynNameSearchByKeyWithPager(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Handler paramHandler)
  {
    if (paramString == null) {
      return false;
    }
    paramString = paramString.trim();
    if (paramString.length() <= 0) {
      return false;
    }
    paramHandler = new ReqData("cmd.search.bykey", 1, paramHandler, 1001, paramInt5);
    CmdSearchByKey.packetParams(paramHandler, paramString, paramInt1, paramInt2, paramInt3);
    CommandCenter.getInstance().sendRequest(paramHandler);
    return true;
  }
  
  public boolean asynRouteSearchForMapPoiResultPB(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, int paramInt4, int paramInt5, Handler paramHandler)
  {
    if (paramString1 == null) {
      return false;
    }
    if (paramString1.trim().length() <= 0) {
      return false;
    }
    paramHandler = new ReqData("cmd.search.routesearch.for.mappoiresult.pb", 1, paramHandler, 1010);
    CmdRouteSearchForMapPoiResultPB.packetParams(paramHandler, paramInt1, paramString1, paramInt2, paramInt3, paramString2, paramInt4, paramInt5);
    CommandCenter.getInstance().sendRequest(paramHandler);
    return true;
  }
  
  public boolean asynSearchAroudPark(String paramString, SearchCircle paramSearchCircle, int paramInt1, int paramInt2, int paramInt3, Handler paramHandler)
  {
    if (paramSearchCircle == null) {
      return false;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    paramString = new ReqData("cmd.search.around.park", 1, paramHandler, 1006, paramInt3);
    CmdSearchAroundPark.packetParams(paramString, str, paramSearchCircle, paramInt1, paramInt2);
    CommandCenter.getInstance().sendRequest(paramString);
    return true;
  }
  
  public boolean asynSearchAroudPark(String paramString, SearchCircle paramSearchCircle, int paramInt1, int paramInt2, Handler paramHandler)
  {
    if (paramSearchCircle == null) {
      return false;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    paramString = new ReqData("cmd.search.around.park", 1, paramHandler, 1006);
    CmdSearchAroundPark.packetParams(paramString, str, paramSearchCircle, paramInt1, paramInt2);
    CommandCenter.getInstance().sendRequest(paramString);
    return true;
  }
  
  public boolean asynSearchByCircleForMapPoiResultPB(String paramString, int paramInt1, SearchCircle paramSearchCircle, int paramInt2, int paramInt3, Handler paramHandler)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramHandler = new ReqData("cmd.search.bycircle.for.mappoiresult.pb", 1, paramHandler, 1009);
    CmdSearchByCircleForMapPoiResultPB.packetParams(paramHandler, paramString, paramInt1, paramSearchCircle, paramInt2, paramInt3);
    CommandCenter.getInstance().sendRequest(paramHandler);
    return true;
  }
  
  public boolean asynSearchByKeyForMapRPNodePoiResultPB(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Handler paramHandler)
  {
    if (paramString == null) {
      return false;
    }
    String str = paramString.trim();
    if (str.length() <= 0) {
      return false;
    }
    if (checkFactoryMode(str)) {
      return false;
    }
    paramHandler = new ReqData("cmd.search.bykey.for.maprpnodepoiresult.pb", 1, paramHandler, 1007);
    CmdSearchByKeyForMapRPNodePoiResultPB.packetParams(paramHandler, paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    CommandCenter.getInstance().sendRequest(paramHandler);
    return true;
  }
  
  public boolean asynSearchByNameForMapPoiResultPB(String paramString, int paramInt1, SearchCircle paramSearchCircle, int paramInt2, int paramInt3, Handler paramHandler)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramHandler = new ReqData("cmd.search.bykey.for.mappoiresult.pb", 1, paramHandler, 1008);
    CmdSearchByKeyForMapPoiResultPB.packetParams(paramHandler, paramString, paramInt1, paramSearchCircle, paramInt2, paramInt3);
    CommandCenter.getInstance().sendRequest(paramHandler);
    return true;
  }
  
  public boolean asynSearchWithPager(SearchPoiPager paramSearchPoiPager, int paramInt, Handler paramHandler)
  {
    if (paramSearchPoiPager == null) {
      return false;
    }
    paramHandler = new ReqData("cmd.search.with.pager", 1, paramHandler, 1005, paramInt);
    CmdSearchWithPager.packetParams(paramHandler, paramSearchPoiPager);
    CommandCenter.getInstance().sendRequest(paramHandler);
    return true;
  }
  
  public boolean asynSearchWithPager(SearchPoiPager paramSearchPoiPager, Handler paramHandler)
  {
    if (paramSearchPoiPager == null) {}
    while (checkFactoryMode(paramSearchPoiPager.getSearchKey())) {
      return false;
    }
    paramHandler = new ReqData("cmd.search.with.pager", 1, paramHandler, 1005);
    CmdSearchWithPager.packetParams(paramHandler, paramSearchPoiPager);
    CommandCenter.getInstance().sendRequest(paramHandler);
    return true;
  }
  
  public boolean asynSpaceSearchByCatalog(int paramInt1, int paramInt2, SearchCircle paramSearchCircle, int paramInt3, int paramInt4, int paramInt5, Handler paramHandler)
  {
    if (paramSearchCircle == null) {
      return false;
    }
    paramHandler = new ReqData("cmd.search.neareast", 1, paramHandler, 1002, paramInt5);
    CmdSearchNearest.packetParams(paramHandler, paramInt1, paramInt2, paramSearchCircle, paramInt3, paramInt4);
    CommandCenter.getInstance().sendRequest(paramHandler);
    return true;
  }
  
  public boolean asynSpaceSearchByCatalog(int paramInt1, SearchCircle paramSearchCircle, int paramInt2, int paramInt3, int paramInt4, Handler paramHandler)
  {
    if (paramSearchCircle == null) {
      return false;
    }
    paramHandler = new ReqData("cmd.search.neareast", 1, paramHandler, 1002, paramInt4);
    CmdSearchNearest.packetParams(paramHandler, paramInt1, paramSearchCircle, paramInt2, paramInt3);
    CommandCenter.getInstance().sendRequest(paramHandler);
    return true;
  }
  
  public boolean asynSpaceSearchByKey(String paramString, int paramInt1, SearchCircle paramSearchCircle, int paramInt2, int paramInt3, int paramInt4, Handler paramHandler)
  {
    if ((paramString == null) || (paramSearchCircle == null)) {
      return false;
    }
    paramString = paramString.trim();
    if (paramString.length() <= 0) {
      return false;
    }
    paramHandler = new ReqData("cmd.search.neareast", 1, paramHandler, 1002, paramInt4);
    CmdSearchNearest.packetParams(paramHandler, paramString, paramInt1, paramSearchCircle, paramInt2, paramInt3);
    CommandCenter.getInstance().sendRequest(paramHandler);
    return true;
  }
  
  public boolean asynSpaceSearchByKey(String paramString, SearchCircle paramSearchCircle, int paramInt1, int paramInt2, int paramInt3, Handler paramHandler)
  {
    if ((paramString == null) || (paramSearchCircle == null)) {
      return false;
    }
    paramString = paramString.trim();
    if (paramString.length() <= 0) {
      return false;
    }
    paramHandler = new ReqData("cmd.search.neareast", 1, paramHandler, 1002, paramInt3);
    CmdSearchNearest.packetParams(paramHandler, paramString, paramSearchCircle, paramInt1, paramInt2);
    CommandCenter.getInstance().sendRequest(paramHandler);
    return true;
  }
  
  public void cancelQuery()
  {
    CommandCenter.getInstance().cancelRequestBySubSystem(1);
  }
  
  @SuppressLint({"NewApi"})
  public boolean checkFactoryMode(final String paramString)
  {
    LogUtil.e(TAG, "checkFactoryMode key = " + paramString);
    if ((paramString != null) && ("最好用的导航".equals(paramString.trim())))
    {
      com.baidu.navisdk.debug.NavSDKDebug.sSDKFactoryMode = true;
      paramString = "CUID:" + PackageUtil.getCuid();
      ((ClipboardManager)BNaviModuleManager.getContext().getSystemService("clipboard")).setText(paramString);
      TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "CUID已经复制到粘贴板，进入导航设置中查看工程模式！");
      paramString = JNIGuidanceControl.getInstance().isRouteGuideCloud();
      if (!StringUtils.isEmpty(paramString)) {
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("CheckFactoryMode-" + getClass().getSimpleName(), null)new BNWorkerConfig
        {
          protected String execute()
          {
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), paramString);
            return null;
          }
        }, new BNWorkerConfig(100, 0), 3000L);
      }
      paramString = new BNDebugModelDialog(BNaviModuleManager.getContext());
      BNDrivingToolManager.getInstance().setDebugModeDialog(paramString);
      paramString.show();
      return true;
    }
    if ((paramString != null) && ("最好用的tts".equals(paramString.trim())))
    {
      TTSTestCenter.getInstance().init();
      TTSTestCenter.getInstance().test();
      TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "开始进入TTS测试模式");
      return true;
    }
    if ((paramString != null) && ("最好用的百度地图".equals(paramString.trim())))
    {
      new BNUserKeyLogDialog(BNaviModuleManager.getContext()).show();
      return true;
    }
    return false;
  }
  
  public boolean clearBkgCache()
  {
    return JNISearchControl.sInstance.clearBkgCache() == 0;
  }
  
  public boolean clearFavPoiCache()
  {
    return JNISearchControl.sInstance.clearFavPoiCache() == 0;
  }
  
  public boolean clearPoiCache()
  {
    return JNISearchControl.sInstance.clearPoiCache() == 0;
  }
  
  public int getChildDistrict(int paramInt, ArrayList<DistrictInfo> paramArrayList)
  {
    return JNISearchControl.sInstance.getChildDistrictAndParse(paramInt, paramArrayList);
  }
  
  public DistrictInfo getDistrictById(int paramInt)
  {
    return JNISearchControl.sInstance.getDistrictById(paramInt);
  }
  
  public DistrictInfo getDistrictByPoint(GeoPoint paramGeoPoint, int paramInt)
  {
    LogUtil.e("PoiSearch", "getDistrictByPoint");
    return JNISearchControl.sInstance.getDistrictByPoint(paramGeoPoint, paramInt);
  }
  
  public int getNetMode()
  {
    return JNISearchControl.sInstance.GetNetMode();
  }
  
  public int getNetModeOfLastResult()
  {
    return JNISearchControl.sInstance.GetNetModeOfLastResult();
  }
  
  public DistrictInfo getParentDistrict(int paramInt)
  {
    return JNISearchControl.sInstance.getParentDistrict(paramInt);
  }
  
  public DistrictInfo getProvinceDistrictByPoint(GeoPoint paramGeoPoint)
  {
    paramGeoPoint = JNISearchControl.sInstance.getDistrictsByPoint(paramGeoPoint);
    if ((paramGeoPoint != null) && (paramGeoPoint.length > 1)) {
      return paramGeoPoint[1];
    }
    return null;
  }
  
  public int getSearchNetworkMode()
  {
    int i = 1;
    if (BNSettingManager.getPrefSearchMode() == 3) {
      if ((getInstance().getNetModeOfLastResult() == 2) || (getInstance().getNetModeOfLastResult() == 0)) {
        i = 3;
      }
    }
    while (BNSettingManager.getPrefSearchMode() != 2) {
      return i;
    }
    if ((getInstance().getNetModeOfLastResult() == 3) || (getInstance().getNetModeOfLastResult() == 1)) {
      return 4;
    }
    return 2;
  }
  
  public DistrictInfo getTopDistrict()
  {
    return JNISearchControl.sInstance.getTopDistrict();
  }
  
  public boolean initInputSug(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if ((paramInt1 < 1) && (paramInt1 > 33)) {
      return false;
    }
    paramInt1 = JNISearchControl.sInstance.initSugSubSys(paramInt1);
    LogUtil.e(TAG, "initSugSubSys ret " + paramInt1);
    if (paramInt1 == 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean initInputSug(DistrictInfo paramDistrictInfo)
  {
    int i = JNISearchControl.sInstance.initSugSubSys(JNISearchControl.sInstance.getCompDistrictId(paramDistrictInfo));
    LogUtil.e(TAG, "initSugSubSys ret " + i);
    return i == 0;
  }
  
  public boolean inputIndex(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (paramInt1 == 0) || (paramInt2 == 0)) {}
    do
    {
      do
      {
        return false;
      } while (paramString.length() <= 0);
      LogUtil.e(TAG, "inputIndex() ditrict ID: " + paramInt1);
      Bundle localBundle = new Bundle();
      localBundle.putString("Name", paramString.toUpperCase(Locale.getDefault()));
      localBundle.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(paramInt1));
      localBundle.putInt("PoiId", paramInt2);
      paramInt1 = JNISearchControl.sInstance.inputIndex(localBundle);
      LogUtil.e(TAG, "inputIndex() ret: " + paramInt1);
    } while (paramInt1 != 0);
    return true;
  }
  
  public void mtjStatSearch(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410311", "410311");
        return;
      case 2: 
        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410312", "410312");
        return;
      case 3: 
        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410314", "410314");
        return;
      }
      BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410313", "410313");
      return;
    }
    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410315", "410315");
  }
  
  public int parseBkgLayerId(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    paramString = paramString.split("_");
    if (paramString.length != 3) {
      return -2;
    }
    try
    {
      int i = Integer.parseInt(paramString[0]);
      return i;
    }
    catch (Exception paramString) {}
    return -1;
  }
  
  public void quickSortByDistance(GeoPoint paramGeoPoint, ArrayList<SearchPoi> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      int k = ((SearchPoi)paramArrayList.get(i)).mViewPoint.getLongitudeE6();
      int m = ((SearchPoi)paramArrayList.get(i)).mViewPoint.getLatitudeE6();
      localArrayList.add(Double.valueOf(Math.sqrt((k - paramGeoPoint.getLongitudeE6()) * (k - paramGeoPoint.getLongitudeE6()) + (m - paramGeoPoint.getLatitudeE6()) * (m - paramGeoPoint.getLatitudeE6()))));
      i += 1;
    }
    quickSortByDistance(localArrayList, 0, j - 1, paramArrayList);
  }
  
  public boolean releaseInputSug(int paramInt)
  {
    return JNISearchControl.sInstance.releaseSugSubSys() == 0;
  }
  
  public int searchSubPoi(int paramInt1, int paramInt2, int paramInt3, ArrayList<Integer> paramArrayList, ArrayList<SearchPoi> paramArrayList1)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(paramInt3));
    localBundle.putInt("Id", paramInt1);
    localBundle.putInt("PoiCount", 32);
    localBundle.putInt("Type", paramInt2);
    int[] arrayOfInt = new int[8];
    ArrayList localArrayList = new ArrayList();
    paramInt1 = JNISearchControl.sInstance.searchByFather(localBundle, arrayOfInt, localArrayList);
    LogUtil.e(TAG, "searchByFather() ret: " + paramInt1);
    LogUtil.e(TAG, "outputList count: " + localArrayList.size());
    if (paramInt1 < 0)
    {
      paramInt1 = -2;
      return paramInt1;
    }
    paramInt1 = 0;
    while (paramInt1 < 8)
    {
      paramArrayList.add(Integer.valueOf(arrayOfInt[paramInt1]));
      paramInt1 += 1;
    }
    paramInt3 = localArrayList.size();
    paramInt2 = 0;
    for (;;)
    {
      paramInt1 = paramInt3;
      if (paramInt2 >= paramInt3) {
        break;
      }
      paramArrayList = (Bundle)localArrayList.get(paramInt2);
      paramArrayList1.add(JNISearchControl.sInstance.parsePoiBundle(paramArrayList));
      paramInt2 += 1;
    }
  }
  
  public int setNetMode(int paramInt)
  {
    try
    {
      paramInt = JNISearchControl.sInstance.SetNetMode(paramInt);
      return paramInt;
    }
    catch (Throwable localThrowable) {}
    return 0;
  }
  
  public boolean updateBkgCache(ArrayList<GeoPoint> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {}
    ArrayList localArrayList;
    do
    {
      return false;
      localArrayList = new ArrayList();
      int j = paramArrayList.size();
      int i = 0;
      while (i < j)
      {
        GeoPoint localGeoPoint = (GeoPoint)paramArrayList.get(i);
        Bundle localBundle = new Bundle();
        localBundle.putInt("Id", i);
        localBundle.putInt("Longitude", localGeoPoint.getLongitudeE6());
        localBundle.putInt("Latitude", localGeoPoint.getLatitudeE6());
        localArrayList.add(localBundle);
        i += 1;
      }
    } while (JNISearchControl.sInstance.updateBkgCache(localArrayList, paramInt) != 0);
    return true;
  }
  
  public boolean updateBkgPoiCache(GeoPoint paramGeoPoint, boolean paramBoolean, int paramInt)
  {
    return JNISearchControl.sInstance.updateBkgPoiCache(paramGeoPoint, paramBoolean, paramInt);
  }
  
  public boolean updateFavPoiCache(ArrayList<GeoPoint> paramArrayList, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    if ((paramArrayList == null) || (paramArrayList1 == null) || (paramArrayList1 == null)) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      GeoPoint localGeoPoint = (GeoPoint)paramArrayList.get(i);
      Bundle localBundle = new Bundle();
      localBundle.putInt("Id", i);
      localBundle.putInt("Longitude", localGeoPoint.getLongitudeE6());
      localBundle.putInt("Latitude", localGeoPoint.getLatitudeE6());
      localBundle.putString("Name", (String)paramArrayList1.get(i));
      localBundle.putString("Address", (String)paramArrayList2.get(i));
      localArrayList.add(localBundle);
      i += 1;
    }
    return JNISearchControl.sInstance.UpdateFavPoiCache(localArrayList, j) == 0;
  }
  
  public boolean updatePoiCache(GeoPoint paramGeoPoint)
  {
    return JNISearchControl.sInstance.updatePoiCache(paramGeoPoint);
  }
  
  public boolean updatePoiCacheWithList(ArrayList<SearchPoi> paramArrayList)
  {
    if (paramArrayList == null) {}
    ArrayList localArrayList;
    do
    {
      return false;
      localArrayList = new ArrayList();
      int i = 0;
      while (i < paramArrayList.size())
      {
        SearchPoi localSearchPoi = (SearchPoi)paramArrayList.get(i);
        Bundle localBundle = new Bundle();
        localBundle.putInt("Id", 0);
        localBundle.putString("Name", "Poi");
        localBundle.putInt("Longitude", localSearchPoi.mViewPoint.getLongitudeE6());
        localBundle.putInt("Latitude", localSearchPoi.mViewPoint.getLatitudeE6());
        localArrayList.add(localBundle);
        i += 1;
      }
      LogUtil.e(TAG, "updatePoiCache bundleList size=: " + localArrayList.size());
    } while (JNISearchControl.sInstance.updatePoiCacheWithList(localArrayList) != 0);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/poisearch/BNPoiSearcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */