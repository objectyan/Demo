package com.baidu.navisdk.util.statistic.datacheck;

import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataCheckCenter {
    public static final boolean OPEN_RELEASE = false;
    public static final String TAG = DataCheckCenter.class.getSimpleName();
    private static DataCheckCenter sInstance = null;
    private static Object sSyncObj = new Object();
    private List<GeneralRegularData> mGeneralRegularDatas = new ArrayList();
    private boolean mIsInitOK = false;

    public static DataCheckCenter getInstance() {
        if (sInstance == null) {
            synchronized (sSyncObj) {
                if (sInstance == null) {
                    sInstance = new DataCheckCenter();
                }
            }
        }
        return sInstance;
    }

    private DataCheckCenter() {
    }

    private void init() {
        DataCheckLogCenter.getInstance();
        this.mIsInitOK = loadRegular();
    }

    public void uninit() {
        DataCheckLogCenter.getInstance().uninit();
    }

    public boolean loadRegular() {
        this.mGeneralRegularDatas.clear();
        boolean isok = true;
        try {
            InputStream is = JarUtils.getResources().getAssets().open("datacheck.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            while (true) {
                String line = reader.readLine();
                if (line != null) {
                    GeneralRegularData grd = new GeneralRegularData();
                    isok &= grd.loadRegular(line);
                    this.mGeneralRegularDatas.add(grd);
                } else {
                    is.close();
                    reader.close();
                    log("success to load regular file.");
                    return true;
                }
            }
        } catch (Exception e) {
            log("failed to load regular file.");
            return false;
        }
    }

    private GeneralRegularData getGeneralRegularData(String id) {
        if (id == null || id.length() == 0 || this.mGeneralRegularDatas.size() == 0) {
            return null;
        }
        for (int i = 0; i < this.mGeneralRegularDatas.size(); i++) {
            if (id.equals(((GeneralRegularData) this.mGeneralRegularDatas.get(i)).id)) {
                return (GeneralRegularData) this.mGeneralRegularDatas.get(i);
            }
        }
        return null;
    }

    public boolean check(StatisitcsDataCheck checkData) {
        return false;
    }

    public static void toastTip(String info) {
        TipTool.onCreateToastDialog(BNaviModuleManager.getActivity(), info);
    }

    public static void log(String info) {
        LogUtil.m15791e(TAG, info);
    }
}
