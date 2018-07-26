package com.baidu.navisdk.comapi.poisearch;

import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.debug.NavSDKDebug;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.jni.nativeif.JNISearchControl;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.CommandConstants;
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
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Locale;

public class BNPoiSearcher implements JNISearchConst, CommandConst {
    private static final String SEARCH_FACTORY_MODE_SECRET = "最好用的导航";
    private static final String SEARCH_FACTORY_MODE_TTS = "最好用的tts";
    private static final String SEARCH_FACTORY_MODE_USER_KEY_LOG = "最好用的百度地图";
    private static final String TAG = BNPoiSearcher.class.getSimpleName();
    private static BNPoiSearcher mInstance;

    private BNPoiSearcher() {
    }

    public static BNPoiSearcher getInstance() {
        if (mInstance == null) {
            mInstance = new BNPoiSearcher();
        }
        return mInstance;
    }

    public int setNetMode(int netmode) {
        try {
            return JNISearchControl.sInstance.SetNetMode(netmode);
        } catch (Throwable th) {
            return 0;
        }
    }

    public int getNetMode() {
        return JNISearchControl.sInstance.GetNetMode();
    }

    public int getNetModeOfLastResult() {
        return JNISearchControl.sInstance.GetNetModeOfLastResult();
    }

    public void cancelQuery() {
        CommandCenter.getInstance().cancelRequestBySubSystem(1);
    }

    public boolean asynNameSearchByKey(String key, int districtId, int poiCount, int netMode, int timeout, Handler handler) {
        if (key == null) {
            return false;
        }
        String trimKey = key.trim();
        if (trimKey.length() <= 0) {
            return false;
        }
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_SEARCH_BYKEY, 1, handler, 1001, timeout);
        CmdSearchByKey.packetParams(reqdata, trimKey, districtId, poiCount, netMode);
        CommandCenter.getInstance().sendRequest(reqdata);
        return true;
    }

    public boolean asynSearchWithPager(SearchPoiPager searchPoiPager, int timeout, Handler handler) {
        if (searchPoiPager == null) {
            return false;
        }
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_SEARCH_WITH_PAGER, 1, handler, 1005, timeout);
        CmdSearchWithPager.packetParams(reqdata, searchPoiPager);
        CommandCenter.getInstance().sendRequest(reqdata);
        return true;
    }

    public boolean asynSearchWithPager(SearchPoiPager searchPoiPager, Handler handler) {
        if (searchPoiPager == null || checkFactoryMode(searchPoiPager.getSearchKey())) {
            return false;
        }
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_SEARCH_WITH_PAGER, 1, handler, 1005);
        CmdSearchWithPager.packetParams(reqdata, searchPoiPager);
        CommandCenter.getInstance().sendRequest(reqdata);
        return true;
    }

    public boolean asynNameSearchByKeyWithPager(String key, int districtId, int poiCount, int netMode, int pagerNum, int timeout, Handler handler) {
        if (key == null) {
            return false;
        }
        String trimKey = key.trim();
        if (trimKey.length() <= 0) {
            return false;
        }
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_SEARCH_BYKEY, 1, handler, 1001, timeout);
        CmdSearchByKey.packetParams(reqdata, trimKey, districtId, poiCount, netMode);
        CommandCenter.getInstance().sendRequest(reqdata);
        return true;
    }

    public boolean asynSpaceSearchByKey(String key, int districtId, SearchCircle circle, int poiCount, int netMode, int timeout, Handler handler) {
        if (key == null || circle == null) {
            return false;
        }
        String trimKey = key.trim();
        if (trimKey.length() <= 0) {
            return false;
        }
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_SEARCH_NEAREST, 1, handler, 1002, timeout);
        CmdSearchNearest.packetParams(reqdata, trimKey, districtId, circle, poiCount, netMode);
        CommandCenter.getInstance().sendRequest(reqdata);
        return true;
    }

    public boolean asynSpaceSearchByKey(String key, SearchCircle circle, int poiCount, int netMode, int timeout, Handler handler) {
        if (key == null || circle == null) {
            return false;
        }
        String trimKey = key.trim();
        if (trimKey.length() <= 0) {
            return false;
        }
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_SEARCH_NEAREST, 1, handler, 1002, timeout);
        CmdSearchNearest.packetParams(reqdata, trimKey, circle, poiCount, netMode);
        CommandCenter.getInstance().sendRequest(reqdata);
        return true;
    }

    public boolean asynSpaceSearchByCatalog(int catalogId, int districtId, SearchCircle circle, int poiCount, int netMode, int timeout, Handler handler) {
        if (circle == null) {
            return false;
        }
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_SEARCH_NEAREST, 1, handler, 1002, timeout);
        CmdSearchNearest.packetParams(reqdata, catalogId, districtId, circle, poiCount, netMode);
        CommandCenter.getInstance().sendRequest(reqdata);
        return true;
    }

    public boolean asynSpaceSearchByCatalog(int catalogId, SearchCircle circle, int poiCount, int netMode, int timeout, Handler handler) {
        if (circle == null) {
            return false;
        }
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_SEARCH_NEAREST, 1, handler, 1002, timeout);
        CmdSearchNearest.packetParams(reqdata, catalogId, circle, poiCount, netMode);
        CommandCenter.getInstance().sendRequest(reqdata);
        return true;
    }

    public boolean initInputSug(int provinceId, int netMode) {
        boolean z = true;
        if (provinceId < 1 && provinceId > 33) {
            return false;
        }
        int ret = JNISearchControl.sInstance.initSugSubSys(provinceId);
        LogUtil.m15791e(TAG, "initSugSubSys ret " + ret);
        if (ret != 0) {
            z = false;
        }
        return z;
    }

    public boolean initInputSug(DistrictInfo districtInfo) {
        int ret = JNISearchControl.sInstance.initSugSubSys(JNISearchControl.sInstance.getCompDistrictId(districtInfo));
        LogUtil.m15791e(TAG, "initSugSubSys ret " + ret);
        return ret == 0;
    }

    public boolean releaseInputSug(int netMode) {
        return JNISearchControl.sInstance.releaseSugSubSys() == 0;
    }

    public boolean asynGetInputSug(String prefix, int netMode, int timeout, Handler handler) {
        if (prefix == null) {
            return false;
        }
        String trimPrefix = prefix.trim();
        if (trimPrefix.length() <= 0) {
            return false;
        }
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_SEARCH_GETSUG, 1, handler, 1004, timeout);
        CmdSearchGetSug.packetParams(reqdata, trimPrefix, netMode);
        CommandCenter.getInstance().sendRequest(reqdata);
        return true;
    }

    public DistrictInfo getDistrictByPoint(GeoPoint point, int netMode) {
        LogUtil.m15791e(ModuleName.POISEARCH, "getDistrictByPoint");
        return JNISearchControl.sInstance.getDistrictByPoint(point, netMode);
    }

    public boolean asynGetPoiByPoint(GeoPoint point, int netMode, int timeout, Handler handler) {
        if (point == null) {
            return false;
        }
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_SEARCH_BYPOINT, 1, handler, 1003, timeout);
        CmdSearchByPoint.packetParams(reqdata, 1, point, netMode);
        CommandCenter.getInstance().sendRequest(reqdata);
        return true;
    }

    public boolean asynGetPoiByPoint(GeoPoint point, int timeout, Handler handler) {
        if (point == null) {
            return false;
        }
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_SEARCH_BYPOINT, 1, handler, 1003, timeout);
        CmdSearchByPoint.packetParams(reqdata, 1, point);
        CommandCenter.getInstance().sendRequest(reqdata);
        return true;
    }

    public DistrictInfo getProvinceDistrictByPoint(GeoPoint point) {
        DistrictInfo[] districts = JNISearchControl.sInstance.getDistrictsByPoint(point);
        if (districts == null || districts.length <= 1) {
            return null;
        }
        return districts[1];
    }

    public boolean asynGetDistrictByPoint(GeoPoint point, int timeout, Handler handler) {
        if (point == null || !point.isValid()) {
            return false;
        }
        if (BNaviEngineManager.getInstance().isEngineInitSucc()) {
            ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_SEARCH_BYPOINT, 1, handler, 1003, timeout);
            CmdSearchByPoint.packetParams(reqdata, 2, point);
            CommandCenter.getInstance().sendRequest(reqdata);
            return true;
        }
        LogUtil.m15791e(ModuleName.POISEARCH, "engine is not init succ...");
        return false;
    }

    public DistrictInfo getTopDistrict() {
        return JNISearchControl.sInstance.getTopDistrict();
    }

    public DistrictInfo getParentDistrict(int childDistrictId) {
        return JNISearchControl.sInstance.getParentDistrict(childDistrictId);
    }

    public int getChildDistrict(int parentDistrictId, ArrayList<DistrictInfo> childDistrict) {
        return JNISearchControl.sInstance.getChildDistrictAndParse(parentDistrictId, childDistrict);
    }

    public DistrictInfo getDistrictById(int districtId) {
        return JNISearchControl.sInstance.getDistrictById(districtId);
    }

    public boolean updatePoiCache(GeoPoint point) {
        return JNISearchControl.sInstance.updatePoiCache(point);
    }

    public boolean updateBkgPoiCache(GeoPoint point, boolean isMadian, int poiIndex) {
        return JNISearchControl.sInstance.updateBkgPoiCache(point, isMadian, poiIndex);
    }

    public boolean updatePoiCacheWithList(ArrayList<SearchPoi> poiList) {
        if (poiList == null) {
            return false;
        }
        ArrayList<Bundle> bundleList = new ArrayList();
        for (int index = 0; index < poiList.size(); index++) {
            SearchPoi poi = (SearchPoi) poiList.get(index);
            Bundle bundle = new Bundle();
            bundle.putInt("Id", 0);
            bundle.putString("Name", JNISearchConst.LAYER_POI);
            bundle.putInt(JNISearchConst.JNI_LONGITUDE, poi.mViewPoint.getLongitudeE6());
            bundle.putInt("Latitude", poi.mViewPoint.getLatitudeE6());
            bundleList.add(bundle);
        }
        LogUtil.m15791e(TAG, "updatePoiCache bundleList size=: " + bundleList.size());
        if (JNISearchControl.sInstance.updatePoiCacheWithList(bundleList) == 0) {
            return true;
        }
        return false;
    }

    public boolean clearPoiCache() {
        return JNISearchControl.sInstance.clearPoiCache() == 0;
    }

    public boolean updateFavPoiCache(ArrayList<GeoPoint> pointList, ArrayList<String> favNameList, ArrayList<String> favAddressList) {
        if (pointList == null || favNameList == null || favNameList == null) {
            return false;
        }
        ArrayList<Bundle> inputList = new ArrayList();
        int count = pointList.size();
        for (int i = 0; i < count; i++) {
            GeoPoint point = (GeoPoint) pointList.get(i);
            Bundle bundle = new Bundle();
            bundle.putInt("Id", i);
            bundle.putInt(JNISearchConst.JNI_LONGITUDE, point.getLongitudeE6());
            bundle.putInt("Latitude", point.getLatitudeE6());
            bundle.putString("Name", (String) favNameList.get(i));
            bundle.putString(JNISearchConst.JNI_ADDRESS, (String) favAddressList.get(i));
            inputList.add(bundle);
        }
        return JNISearchControl.sInstance.UpdateFavPoiCache(inputList, count) == 0;
    }

    public boolean clearFavPoiCache() {
        return JNISearchControl.sInstance.clearFavPoiCache() == 0;
    }

    public boolean updateBkgCache(ArrayList<GeoPoint> pointList, int type) {
        if (pointList == null) {
            return false;
        }
        ArrayList<Bundle> inputList = new ArrayList();
        int count = pointList.size();
        for (int i = 0; i < count; i++) {
            GeoPoint point = (GeoPoint) pointList.get(i);
            Bundle bundle = new Bundle();
            bundle.putInt("Id", i);
            bundle.putInt(JNISearchConst.JNI_LONGITUDE, point.getLongitudeE6());
            bundle.putInt("Latitude", point.getLatitudeE6());
            inputList.add(bundle);
        }
        if (JNISearchControl.sInstance.updateBkgCache(inputList, type) == 0) {
            return true;
        }
        return false;
    }

    public boolean clearBkgCache() {
        return JNISearchControl.sInstance.clearBkgCache() == 0;
    }

    public int parseBkgLayerId(String layerId) {
        if (layerId == null) {
            return -1;
        }
        String[] parts = layerId.split(JNISearchConst.LAYER_ID_DIVIDER);
        if (parts.length != 3) {
            return -2;
        }
        int ret = -1;
        try {
            return Integer.parseInt(parts[0]);
        } catch (Exception e) {
            return ret;
        }
    }

    public void quickSortByDistance(GeoPoint center, ArrayList<SearchPoi> poiList) {
        if (poiList != null && poiList.size() > 0) {
            ArrayList<Double> distanceList = new ArrayList();
            int size = poiList.size();
            for (int i = 0; i < size; i++) {
                int longitude = ((SearchPoi) poiList.get(i)).mViewPoint.getLongitudeE6();
                int latitude = ((SearchPoi) poiList.get(i)).mViewPoint.getLatitudeE6();
                distanceList.add(Double.valueOf(Math.sqrt((((double) (longitude - center.getLongitudeE6())) * ((double) (longitude - center.getLongitudeE6()))) + (((double) (latitude - center.getLatitudeE6())) * ((double) (latitude - center.getLatitudeE6()))))));
            }
            quickSortByDistance(distanceList, 0, size - 1, poiList);
        }
    }

    private void quickSortByDistance(ArrayList<Double> distanceList, int from, int to, ArrayList<SearchPoi> poiList) {
        if (from < to && from >= 0 && distanceList != null && poiList != null && to < distanceList.size() && to < poiList.size()) {
            int newFrom = from;
            int newTo = to;
            double distance = ((Double) distanceList.get(from)).doubleValue();
            SearchPoi poi = (SearchPoi) poiList.get(from);
            while (newFrom < newTo) {
                while (newFrom < newTo && ((Double) distanceList.get(newTo)).doubleValue() >= distance) {
                    newTo--;
                }
                distanceList.set(newFrom, distanceList.get(newTo));
                poiList.set(newFrom, poiList.get(newTo));
                while (newFrom < newTo && ((Double) distanceList.get(newFrom)).doubleValue() < distance) {
                    newFrom++;
                }
                distanceList.set(newTo, distanceList.get(newFrom));
                poiList.set(newTo, poiList.get(newFrom));
            }
            distanceList.set(newFrom, Double.valueOf(distance));
            poiList.set(newFrom, poi);
            quickSortByDistance(distanceList, from, newFrom - 1, poiList);
            quickSortByDistance(distanceList, newFrom + 1, to, poiList);
        }
    }

    public int searchSubPoi(int poiId, int type, int districtId, ArrayList<Integer> typeNumList, ArrayList<SearchPoi> poiList) {
        Bundle input = new Bundle();
        input.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(districtId));
        input.putInt("Id", poiId);
        input.putInt("PoiCount", 32);
        input.putInt("Type", type);
        int[] typeNum = new int[8];
        ArrayList<Bundle> outputList = new ArrayList();
        int ret = JNISearchControl.sInstance.searchByFather(input, typeNum, outputList);
        LogUtil.m15791e(TAG, "searchByFather() ret: " + ret);
        LogUtil.m15791e(TAG, "outputList count: " + outputList.size());
        if (ret < 0) {
            return -2;
        }
        int i;
        for (i = 0; i < 8; i++) {
            typeNumList.add(Integer.valueOf(typeNum[i]));
        }
        int outputSize = outputList.size();
        for (i = 0; i < outputSize; i++) {
            ArrayList<SearchPoi> arrayList = poiList;
            arrayList.add(JNISearchControl.sInstance.parsePoiBundle((Bundle) outputList.get(i)));
        }
        return outputSize;
    }

    public boolean inputIndex(String key, int districtID, int poiID) {
        if (key == null || districtID == 0 || poiID == 0 || key.length() <= 0) {
            return false;
        }
        LogUtil.m15791e(TAG, "inputIndex() ditrict ID: " + districtID);
        Bundle input = new Bundle();
        input.putString("Name", key.toUpperCase(Locale.getDefault()));
        input.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(districtID));
        input.putInt(JNISearchConst.JNI_POI_ID, poiID);
        int ret = JNISearchControl.sInstance.inputIndex(input);
        LogUtil.m15791e(TAG, "inputIndex() ret: " + ret);
        if (ret == 0) {
            return true;
        }
        return false;
    }

    public boolean asynSearchAroudPark(String name, SearchCircle circle, int netMode, int poiCount, int timeout, Handler handler) {
        if (circle == null) {
            return false;
        }
        if (TextUtils.isEmpty(name)) {
            name = "";
        }
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_SEARCH_AROUND_PARK, 1, handler, 1006, timeout);
        CmdSearchAroundPark.packetParams(reqdata, name, circle, netMode, poiCount);
        CommandCenter.getInstance().sendRequest(reqdata);
        return true;
    }

    public boolean asynSearchAroudPark(String name, SearchCircle circle, int netMode, int poiCount, Handler handler) {
        if (circle == null) {
            return false;
        }
        if (TextUtils.isEmpty(name)) {
            name = "";
        }
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_SEARCH_AROUND_PARK, 1, handler, 1006);
        CmdSearchAroundPark.packetParams(reqdata, name, circle, netMode, poiCount);
        CommandCenter.getInstance().sendRequest(reqdata);
        return true;
    }

    public boolean asynSearchByKeyForMapRPNodePoiResultPB(String key, int districtId, int poiCount, int netMode, int rpNodeCount, int searchRouteNodeType, int viaRouteNodeIndex, Handler handler) {
        if (key == null) {
            return false;
        }
        String trimKey = key.trim();
        if (trimKey.length() <= 0) {
            return false;
        }
        if (checkFactoryMode(trimKey)) {
            return false;
        }
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_SEARCH_BY_KEY_FOR_MAP_RP_NODE_POI_RESULT_PB, 1, handler, 1007);
        CmdSearchByKeyForMapRPNodePoiResultPB.packetParams(reqdata, key, districtId, poiCount, netMode, rpNodeCount, searchRouteNodeType, viaRouteNodeIndex);
        CommandCenter.getInstance().sendRequest(reqdata);
        return true;
    }

    public boolean asynSearchByNameForMapPoiResultPB(String name, int districtID, SearchCircle circle, int poiCount, int pageNumber, Handler handler) {
        if (TextUtils.isEmpty(name)) {
            return false;
        }
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_SEARCH_BY_KEY_FOR_MAP_POI_RESULT_PB, 1, handler, 1008);
        CmdSearchByKeyForMapPoiResultPB.packetParams(reqdata, name, districtID, circle, poiCount, pageNumber);
        CommandCenter.getInstance().sendRequest(reqdata);
        return true;
    }

    public boolean asynSearchByCircleForMapPoiResultPB(String name, int districtID, SearchCircle circle, int poiCount, int pageNumber, Handler handler) {
        if (TextUtils.isEmpty(name)) {
            return false;
        }
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_SEARCH_BY_CIRCLE_FOR_MAP_POI_RESULT_PB, 1, handler, 1009);
        CmdSearchByCircleForMapPoiResultPB.packetParams(reqdata, name, districtID, circle, poiCount, pageNumber);
        CommandCenter.getInstance().sendRequest(reqdata);
        return true;
    }

    public boolean asynRouteSearchForMapPoiResultPB(int routeSearchMode, String searchWord, int searchRange, int sortType, String mrsl, int poiCount, int pageNumber, Handler handler) {
        if (searchWord == null) {
            return false;
        }
        if (searchWord.trim().length() <= 0) {
            return false;
        }
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_ROUTE_SEARCH_FOR_MAP_POI_RESULT_PB, 1, handler, 1010);
        CmdRouteSearchForMapPoiResultPB.packetParams(reqdata, routeSearchMode, searchWord, searchRange, sortType, mrsl, poiCount, pageNumber);
        CommandCenter.getInstance().sendRequest(reqdata);
        return true;
    }

    @SuppressLint({"NewApi"})
    public boolean checkFactoryMode(String key) {
        LogUtil.m15791e(TAG, "checkFactoryMode key = " + key);
        if (key != null && SEARCH_FACTORY_MODE_SECRET.equals(key.trim())) {
            NavSDKDebug.sSDKFactoryMode = true;
            ((ClipboardManager) BNaviModuleManager.getContext().getSystemService("clipboard")).setText("CUID:" + PackageUtil.getCuid());
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "CUID已经复制到粘贴板，进入导航设置中查看工程模式！");
            final String rgCloudStr = JNIGuidanceControl.getInstance().isRouteGuideCloud();
            if (!StringUtils.isEmpty(rgCloudStr)) {
                BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("CheckFactoryMode-" + getClass().getSimpleName(), null) {
                    protected String execute() {
                        TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), rgCloudStr);
                        return null;
                    }
                }, new BNWorkerConfig(100, 0), 3000);
            }
            BNDebugModelDialog debugDialog = new BNDebugModelDialog(BNaviModuleManager.getContext());
            BNDrivingToolManager.getInstance().setDebugModeDialog(debugDialog);
            debugDialog.show();
            return true;
        } else if (key != null && SEARCH_FACTORY_MODE_TTS.equals(key.trim())) {
            TTSTestCenter.getInstance().init();
            TTSTestCenter.getInstance().test();
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "开始进入TTS测试模式");
            return true;
        } else if (key == null || !SEARCH_FACTORY_MODE_USER_KEY_LOG.equals(key.trim())) {
            return false;
        } else {
            new BNUserKeyLogDialog(BNaviModuleManager.getContext()).show();
            return true;
        }
    }

    public void mtjStatSearch(int netMode, boolean success) {
        if (success) {
            switch (netMode) {
                case 1:
                    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_SRARCH_ONLINE, NaviStatConstants.NAVI_SRARCH_ONLINE);
                    return;
                case 2:
                    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_SRARCH_OFFLINE, NaviStatConstants.NAVI_SRARCH_OFFLINE);
                    return;
                case 3:
                    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_SRARCH_OFF_TO_ONLINE, NaviStatConstants.NAVI_SRARCH_OFF_TO_ONLINE);
                    return;
                case 4:
                    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_SRARCH_ON_TO_OFFLINE, NaviStatConstants.NAVI_SRARCH_ON_TO_OFFLINE);
                    return;
                default:
                    return;
            }
        }
        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_SRARCH_FAILURE, NaviStatConstants.NAVI_SRARCH_FAILURE);
    }

    public int getSearchNetworkMode() {
        if (BNSettingManager.getPrefSearchMode() == 3) {
            if (getInstance().getNetModeOfLastResult() == 2 || getInstance().getNetModeOfLastResult() == 0) {
                return 3;
            }
            return 1;
        } else if (BNSettingManager.getPrefSearchMode() == 2) {
            return (getInstance().getNetModeOfLastResult() == 3 || getInstance().getNetModeOfLastResult() == 1) ? 4 : 2;
        } else {
            return 1;
        }
    }
}
