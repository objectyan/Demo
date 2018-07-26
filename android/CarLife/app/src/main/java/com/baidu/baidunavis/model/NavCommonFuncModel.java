package com.baidu.baidunavis.model;

import android.app.Activity;
import android.content.Context;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.BNaviModuleManager.GetOuterActivityListener;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.SystemInfoUtils;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class NavCommonFuncModel {
    public static final int NAVI_TIME_TYPE_POI = 2;
    public static final int NAVI_TIME_TYPE_ROUTE_PAGE = 1;
    public static final String TASK_NAVI_BACK = "task_navi_back";
    public static final int WRITING_SETTING_ID = 969;
    public static int mCPUNeonFeature = -1;
    private static NavCommonFuncModel sInstance = null;
    public static boolean sIsAnologNavi = false;
    public static boolean sIsManullyBack = false;
    public static int sNaviTimeType = -1;
    public static long sPoiToNaviTime1 = 0;
    public static long sRoutePageToNaviTime1 = 0;
    private String mBaiduMapAPPFolderName = null;
    public RoutePlanNode mEndNode = new RoutePlanNode();
    public boolean mHasRequestReadPhoneStatePermission = false;
    public boolean mIsAppForeground = true;
    public boolean mIsOnRestoreInstanceData = false;
    public boolean mMapBrightState;
    public long mMapEnd1Time = -1;
    public long mMapEnd2Time = -1;
    public long mMapStartTime = -1;
    public long mNaviEndTime = -1;
    public long mNaviStartTime = -1;
    private String mSDCardBaiduMapBasePath = null;
    private String mSDCardNaviBasePath = null;
    private String mSDCardRootPath = null;
    private Activity sCachedActivity;
    private Context sCachedContext;

    /* renamed from: com.baidu.baidunavis.model.NavCommonFuncModel$1 */
    class C08531 implements GetOuterActivityListener {
        C08531() {
        }

        public Activity getOuterActivity() {
            return NavCommonFuncModel.getInstance().getActivity();
        }

        public Activity getNaviActivity() {
            return NavCommonFuncModel.getInstance().getNaviActivity();
        }
    }

    private NavCommonFuncModel() {
        initPath();
    }

    public static NavCommonFuncModel getInstance() {
        if (sInstance == null) {
            sInstance = new NavCommonFuncModel();
        }
        return sInstance;
    }

    public boolean initParams(Activity a) {
        if (initContextModule(a)) {
            return initPath();
        }
        return false;
    }

    private boolean initContextModule(Activity a) {
        try {
            BNaviModuleManager.setGetOuterActivityListener(new C08531());
            ScreenUtil.getInstance().init(a);
            BNaviModuleManager.setContext(a);
            BNaviModuleManager.setActivity(a);
            BNSettingManager.init(a);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private boolean initPath() {
        try {
            this.mSDCardRootPath = SysOSAPIv2.getInstance().getSdcardPath();
            if (NavMapAdapter.getInstance().getStorageSettingsInstance() == null || NavMapAdapter.getInstance().getCurrentStorage() == null) {
                return false;
            }
            this.mSDCardBaiduMapBasePath = NavMapAdapter.getInstance().getDataPath();
            this.mSDCardNaviBasePath = this.mSDCardBaiduMapBasePath + File.separator + "bnav";
            this.mBaiduMapAPPFolderName = NavMapAdapter.getInstance().getDataFolderName();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Context getContext() {
        if (NavMapAdapter.getInstance().getContainerActivity() != null) {
            return NavMapAdapter.getInstance().getContainerActivity();
        }
        return this.sCachedContext;
    }

    public Activity getActivity() {
        if (NavMapAdapter.getInstance().getContainerActivity() != null) {
            return NavMapAdapter.getInstance().getContainerActivity();
        }
        return this.sCachedActivity;
    }

    public Activity getNaviActivity() {
        return getActivity();
    }

    public String getSDCardRootPath() {
        return this.mSDCardRootPath;
    }

    public String getSDCardBaiduMapBasePath() {
        return this.mSDCardBaiduMapBasePath;
    }

    public String getSDCardNaviBasePath() {
        return this.mSDCardNaviBasePath;
    }

    public static boolean isNeonCpuFeature() {
        String strInfo;
        Exception ex;
        Throwable th;
        if (mCPUNeonFeature == 1) {
            return true;
        }
        if (mCPUNeonFeature == 0) {
            return false;
        }
        RandomAccessFile reader = null;
        try {
            byte[] bs = new byte[1024];
            RandomAccessFile reader2 = new RandomAccessFile("/proc/cpuinfo", "r");
            try {
                reader2.read(bs);
                String ret = new String(bs);
                int index = ret.indexOf(0);
                if (index != -1) {
                    strInfo = ret.substring(0, index);
                } else {
                    strInfo = ret;
                }
                if (reader2 != null) {
                    try {
                        reader2.close();
                        reader = reader2;
                    } catch (IOException e) {
                        reader = reader2;
                    }
                }
            } catch (Exception e2) {
                ex = e2;
                reader = reader2;
                try {
                    strInfo = "";
                    ex.printStackTrace();
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (strInfo != null) {
                    }
                    mCPUNeonFeature = 1;
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                reader = reader2;
                if (reader != null) {
                    reader.close();
                }
                throw th;
            }
        } catch (Exception e5) {
            ex = e5;
            strInfo = "";
            ex.printStackTrace();
            if (reader != null) {
                reader.close();
            }
            if (strInfo != null) {
            }
            mCPUNeonFeature = 1;
            return true;
        }
        if (strInfo != null || strInfo.contains(SystemInfoUtils.K_CPU_FEATURE_NEON)) {
            mCPUNeonFeature = 1;
            return true;
        }
        mCPUNeonFeature = 0;
        return false;
    }
}
