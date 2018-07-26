package com.baidu.navisdk.util.statistic;

import android.util.Log;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONObject;

public class PerformStatisticsController {
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
    public static long sPoiToNaviTime1 = 0;
    public static long sPoiToNaviTime2 = 0;
    public static long sPoiToNaviTime3 = 0;
    public static long sPoiToNaviTime4 = 0;
    public static long sPoiToNaviTime5 = 0;
    public static long sPoiToNaviTime6 = 0;
    public static long sRoutePageToNaviTime1 = 0;
    public static long sRoutePageToNaviTime10 = 0;
    public static long sRoutePageToNaviTime11 = 0;
    public static long sRoutePageToNaviTime12 = 0;
    public static long sRoutePageToNaviTime2 = 0;
    public static long sRoutePageToNaviTime3 = 0;
    public static long sRoutePageToNaviTime4 = 0;
    public static long sRoutePageToNaviTime8 = 0;
    public static long sRoutePageToNaviTime9 = 0;
    private File mBatchCoordsFile = null;
    private BufferedReader mBatchCoordsFileReader = null;
    private File mBatchTestResultFile = null;
    private FileWriter mBatchTestResultFileWriter = null;
    private int mCurNo = -1;
    private double mEndLa = -1.0d;
    private double mEndLo = -1.0d;
    private boolean mIsFirst = true;
    private IBNPerformStatListener mListener;
    private double mStartLa = -1.0d;
    private double mStartLo = -1.0d;

    public static PerformStatisticsController getInstance() {
        if (sInstance == null) {
            synchronized (PerformStatisticsController.class) {
                if (sInstance == null) {
                    sInstance = new PerformStatisticsController();
                }
            }
        }
        return sInstance;
    }

    public void setPerformStatListener(IBNPerformStatListener lis) {
        this.mListener = lis;
    }

    public boolean addTimeLogForPoiGoToNavi(String step, String stepName, String moduleName, long startTime, long endTime) {
        return addTimeLog(2110, 1, PerformStatItem.POICARNAVITIME_ACTION_TAG, step, moduleName, stepName, startTime, endTime);
    }

    public boolean addTimeLogForRoutePageGoToNavi(String step, String stepName, String moduleName, long startTime, long endTime) {
        return addTimeLog(2110, 1, PerformStatItem.ROUTEPAGECARNAVITIME_ACTION_TAG, step, moduleName, stepName, startTime, endTime);
    }

    public boolean addTimeLog(int type, int level, String strAction, String step, String moduleName, String stepName, long startTime, long endTime) {
        if (this.mListener == null) {
            return false;
        }
        String actionParam = step + "-" + moduleName + "-" + stepName + JNISearchConst.LAYER_ID_DIVIDER + startTime + JNISearchConst.LAYER_ID_DIVIDER + endTime + "=" + (endTime - startTime);
        JSONObject ret = new JSONObject();
        try {
            ret.put(strAction, actionParam);
        } catch (Exception e) {
        }
        LogUtil.m15791e(TAG, "ret.toString() = " + ret.toString());
        return this.mListener.onLogRecord(type, level, strAction, ret.toString());
    }

    public boolean addDataLog(int type, int level, String strAction, String step, String moduleName, String stepName, long dataSize) {
        if (this.mListener == null) {
            return false;
        }
        String actionParam = step + "-" + moduleName + "-" + stepName + "=" + dataSize;
        JSONObject ret = new JSONObject();
        try {
            ret.put(strAction, actionParam);
        } catch (Exception e) {
        }
        LogUtil.m15791e(TAG, "ret.toString() = " + ret.toString());
        return this.mListener.onLogRecord(type, level, strAction, ret.toString());
    }

    public void addRoutePlanSuccessLog(long endTime) {
        addTimeLog(2110, 1, PerformStatItem.TIME_ACTION_TAG, PerformStatItem.RP_SUCCESS_NORMAL_STEP_INDEX, PerformStatItem.MAP_MODULE_NAME, PerformStatItem.RP_SUCCESS_NORMAL_STEP_NAME, PerformStatItem.sRoutePlanSuccessNormalStart, endTime);
    }

    public static void peByType(int type, String itemKey, long time) {
        if (itemKey != null) {
            PerformStatItem.sTimeMap.put(itemKey, Long.valueOf(time));
        }
        if (PerformStatItem.sUserTest && type >= 0 && type < PerformStatItem.P_LOGGABLE.length && PerformStatItem.P_LOGGABLE[type]) {
            Log.e(PERFORMANCE_TAG, "[T" + type + "]-" + itemKey + "-" + time);
        }
    }

    public static void peDiffByType(final int type) {
        if (PerformStatItem.sUserTest) {
            BNWorkerCenter.getInstance().submitNormalTaskDelay(new BNWorkerNormalTask<String, String>("peDiffByType-" + PerformStatisticsController.class.getSimpleName(), null) {
                protected String execute() {
                    PerformStatisticsController.peDiffByTypeInner(type);
                    return null;
                }
            }, new BNWorkerConfig(100, 0), 100);
        }
    }

    private static void peDiffByTypeInner(int type) {
        switch (type) {
            case 1:
                Log.e(PERFORMANCE_TAG, "[T" + type + "]-poi算路总耗时：" + (getTimeByKey("sdk_routeguide_refresh_firstinfo") - getTimeByKey("map_poi_click_start")));
                Log.e(PERFORMANCE_TAG, "[T" + type + "]-poi算路上层耗时：" + (getTimeByKey("sdk_routeguide_resume_end") - getTimeByKey("map_poi_click_start")));
                Log.e(PERFORMANCE_TAG, "[T" + type + "]-poi算路引擎耗时：" + (getTimeByKey("sdk_routeguide_refresh_firstinfo") - getTimeByKey("sdk_start_lib_routeplan")));
                Log.e(PERFORMANCE_TAG, "[T" + type + "]-poi算路网络耗时：" + getTimeByKey("lib_network_server"));
                SDKDebugFileUtil.get(SDKDebugFileUtil.PERFORMANCE_LOG_FILENAME, false, true).forceAdd("[T" + type + "]-poi算路总耗时：" + (getTimeByKey("sdk_routeguide_refresh_firstinfo") - getTimeByKey("map_poi_click_start")));
                SDKDebugFileUtil.get(SDKDebugFileUtil.PERFORMANCE_LOG_FILENAME, false, true).forceAdd("[T" + type + "]-poi算路上层耗时：" + (getTimeByKey("sdk_routeguide_resume_end") - getTimeByKey("map_poi_click_start")));
                SDKDebugFileUtil.get(SDKDebugFileUtil.PERFORMANCE_LOG_FILENAME, false, true).forceAdd("[T" + type + "]-poi算路引擎耗时：" + (getTimeByKey("sdk_routeguide_refresh_firstinfo") - getTimeByKey("sdk_start_lib_routeplan")));
                SDKDebugFileUtil.get(SDKDebugFileUtil.PERFORMANCE_LOG_FILENAME, false, true).forceAdd("[T" + type + "]-poi算路网络耗时：" + getTimeByKey("lib_network_server"));
                return;
            case 3:
                Log.e(PERFORMANCE_TAG, "[T" + type + "]-导航初始化总耗时：" + (getTimeByKey("ad_init_ok") - getTimeByKey("ad_init_start")));
                Log.e(PERFORMANCE_TAG, "[T" + type + "]-导航初始化引擎耗时：" + (getTimeByKey("sdk_initEngineBySync_lib_end") - getTimeByKey("sdk_initEngineBySync_lib_start")));
                SDKDebugFileUtil.get(SDKDebugFileUtil.PERFORMANCE_LOG_FILENAME, false, true).forceAdd("[T" + type + "]-导航初始化总耗时：" + (getTimeByKey("ad_init_ok") - getTimeByKey("ad_init_start")));
                SDKDebugFileUtil.get(SDKDebugFileUtil.PERFORMANCE_LOG_FILENAME, false, true).forceAdd("[T" + type + "]-导航初始化引擎耗时：" + (getTimeByKey("sdk_initEngineBySync_lib_end") - getTimeByKey("sdk_initEngineBySync_lib_start")));
                return;
            case 7:
                Log.e(PERFORMANCE_TAG, "[T" + type + "]-quitNav动画结束时间：" + (getTimeByKey("on_quit_nav_anim_end") - getTimeByKey("on_quit_nav_click")));
                Log.e(PERFORMANCE_TAG, "[T" + type + "]-quitNav接口耗时：" + (getTimeByKey("on_quit_nav_end") - getTimeByKey("on_quit_nav_click")));
                Log.e(PERFORMANCE_TAG, "[T" + type + "]-quitNav页面destory：" + (getTimeByKey("on_quit_nav_destory") - getTimeByKey("on_quit_nav_click")));
                SDKDebugFileUtil.get(SDKDebugFileUtil.PERFORMANCE_LOG_FILENAME, false, true).forceAdd("[T" + type + "]-quitNav接口耗时：" + (getTimeByKey("on_quit_nav_end") - getTimeByKey("on_quit_nav_click")));
                SDKDebugFileUtil.get(SDKDebugFileUtil.PERFORMANCE_LOG_FILENAME, false, true).forceAdd("[T" + type + "]-quitNav页面destory：" + (getTimeByKey("on_quit_nav_destory") - getTimeByKey("on_quit_nav_click")));
                return;
            case 8:
                Log.e(PERFORMANCE_TAG, "[T" + type + "]-导航结束页创建耗时：" + (getTimeByKey("nav_result_resume_time") - getTimeByKey("nav_result_create_time")));
                Log.e(PERFORMANCE_TAG, "[T" + type + "]-导航结束页+退出导航总体耗时：" + (getTimeByKey("nav_result_resume_time") - getTimeByKey("on_quit_nav_click")));
                SDKDebugFileUtil.get(SDKDebugFileUtil.PERFORMANCE_LOG_FILENAME, false, true).forceAdd("[T" + type + "]-导航结束页创建耗时：" + (getTimeByKey("nav_result_resume_time") - getTimeByKey("nav_result_create_time")));
                SDKDebugFileUtil.get(SDKDebugFileUtil.PERFORMANCE_LOG_FILENAME, false, true).forceAdd("[T" + type + "]-导航结束页+退出导航总体耗时：" + (getTimeByKey("nav_result_resume_time") - getTimeByKey("on_quit_nav_click")));
                return;
            default:
                return;
        }
    }

    public static long getTimeByKey(String itemKey) {
        if (itemKey == null || !PerformStatItem.sTimeMap.containsKey(itemKey)) {
            return 0;
        }
        return ((Long) PerformStatItem.sTimeMap.get(itemKey)).longValue();
    }

    public void startBatchTestNetworkAndServer() {
        if (PerformStatItem.sBatchTestNetworkAndServerTime) {
            this.mBatchCoordsFile = new File(SysOSAPI.getInstance().GetSDCardPath() + "/batch_test_coords.txt");
            if (this.mBatchCoordsFile.exists()) {
                this.mBatchTestResultFile = new File(SysOSAPI.getInstance().GetSDCardPath() + "/batch_test_result.txt");
                try {
                    if (this.mBatchTestResultFile.exists()) {
                        this.mBatchTestResultFile.delete();
                        this.mBatchTestResultFile = new File(SysOSAPI.getInstance().GetSDCardPath() + "/batch_test_result.txt");
                    }
                    this.mBatchTestResultFile.createNewFile();
                    this.mBatchTestResultFileWriter = new FileWriter(this.mBatchTestResultFile);
                    this.mBatchCoordsFileReader = new BufferedReader(new FileReader(this.mBatchCoordsFile));
                    nextBatchTestNetworkAndServer(-1, -1, false);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
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

    public void nextBatchTestNetworkAndServer(long time, int dist, boolean isOK) {
        final long j = time;
        final int i = dist;
        final boolean z = isOK;
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("nextBatchTestNetworkAndServer-" + getClass().getSimpleName(), null) {
            protected String execute() {
                PerformStatisticsController.this.nextBatchTestNetworkAndServerInner(j, i, z);
                return null;
            }
        }, new BNWorkerConfig(100, 0), 2000);
    }

    public void nextBatchTestNetworkAndServerInner(long time, int dist, boolean isOK) {
        if (PerformStatItem.sBatchTestNetworkAndServerTime) {
            if (!this.mIsFirst) {
                try {
                    if (this.mBatchTestResultFileWriter != null) {
                        this.mBatchTestResultFileWriter.write("" + this.mCurNo + "\t" + time + "\t" + (isOK ? 1 : 0) + "\n");
                        this.mBatchTestResultFileWriter.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            this.mIsFirst = false;
            if (this.mBatchCoordsFileReader != null) {
                try {
                    String aLine = this.mBatchCoordsFileReader.readLine();
                    Log.e(PERFORMANCE_TAG, "batch:" + aLine);
                    if (aLine == null || aLine.length() <= 0) {
                        if (this.mBatchCoordsFileReader != null) {
                            this.mBatchCoordsFileReader.close();
                        }
                        if (this.mBatchTestResultFileWriter != null) {
                            this.mBatchTestResultFileWriter.flush();
                            this.mBatchTestResultFileWriter.close();
                            return;
                        }
                        return;
                    }
                    String[] strings = aLine.split("\\|");
                    if (strings.length == 3) {
                        this.mCurNo = Integer.parseInt(strings[0]);
                        GeoPoint start = null;
                        GeoPoint end = null;
                        String[] starts = strings[1].split(",");
                        if (starts.length == 2) {
                            this.mStartLo = Double.parseDouble(starts[0]);
                            this.mStartLa = Double.parseDouble(starts[1]);
                            start = CoordinateTransformUtil.transferWGS84ToGCJ02(this.mStartLo, this.mStartLa);
                        }
                        String[] ends = strings[2].split(",");
                        if (ends.length == 2) {
                            this.mEndLo = Double.parseDouble(ends[0]);
                            this.mEndLa = Double.parseDouble(ends[1]);
                            end = CoordinateTransformUtil.transferWGS84ToGCJ02(this.mEndLo, this.mEndLa);
                        }
                        if (start != null && end != null) {
                            ArrayList<RoutePlanNode> rpNodeLists = new ArrayList();
                            RoutePlanNode startNode = new RoutePlanNode();
                            startNode.setGeoPoint(start);
                            startNode.setFrom(1);
                            RoutePlanNode endNode = new RoutePlanNode();
                            endNode.setGeoPoint(end);
                            endNode.setFrom(1);
                            rpNodeLists.add(startNode);
                            rpNodeLists.add(endNode);
                            BNRoutePlaner.getInstance().triggerGPSStatus(2);
                            BNRoutePlaner.getInstance().setCalcPrference(1);
                            BNRoutePlaner.getInstance().setEntry(5);
                            BNRoutePlaner.getInstance().setPointsToCalcRoute(rpNodeLists, -1, false, null, 0);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
