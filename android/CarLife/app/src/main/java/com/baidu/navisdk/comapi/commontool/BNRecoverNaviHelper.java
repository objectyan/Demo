package com.baidu.navisdk.comapi.commontool;

import android.content.Context;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.db.DBManager;
import com.baidu.navisdk.util.db.DBManager$DBOperateResultCallback;
import com.baidu.navisdk.util.db.model.NaviCurRoutePoiModel;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

public class BNRecoverNaviHelper {
    private static final String NAVI_FLAG_PREF = "pref_navi_flag";
    private static final String NAVI_KILL_TIME_PREF = "navi_kill_time_pref";
    private static final String TAG = "RecoverNaviHelper";
    private DBManager$DBOperateResultCallback callback;
    private boolean mHasInit;
    private LastNaviStatusListener mStatusListener;

    /* renamed from: com.baidu.navisdk.comapi.commontool.BNRecoverNaviHelper$1 */
    class C40551 implements DBManager$DBOperateResultCallback {
        C40551() {
        }

        public void onQuerySuccess() {
            ArrayList<RoutePlanNode> nodesList = NaviCurRoutePoiModel.getInstance().getLastNaviNodesList();
            if (nodesList != null && nodesList.size() > 0) {
                RoutePlanNode curPostionNode = null;
                GeoPoint curPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
                if (curPoint != null) {
                    curPostionNode = new RoutePlanNode(curPoint, 3, null, null);
                }
                if (curPostionNode != null) {
                    nodesList.add(0, curPostionNode);
                    if (BNRecoverNaviHelper.this.mStatusListener != null) {
                        BNRecoverNaviHelper.this.mStatusListener.onGetNodeList(nodesList);
                        return;
                    }
                }
            }
            if (BNRecoverNaviHelper.this.mStatusListener != null) {
                BNRecoverNaviHelper.this.mStatusListener.onGetNodeList(null);
            }
        }

        public void onAddOrDeleteSuccess() {
        }
    }

    public interface LastNaviStatusListener {
        void onGetNodeList(ArrayList<RoutePlanNode> arrayList);
    }

    private static class LazyHolder {
        private static BNRecoverNaviHelper sInstance = new BNRecoverNaviHelper();

        private LazyHolder() {
        }
    }

    public static BNRecoverNaviHelper getInstance() {
        return LazyHolder.sInstance;
    }

    private BNRecoverNaviHelper() {
        this.mHasInit = false;
        this.callback = new C40551();
        this.mStatusListener = null;
    }

    public void checkLastNaviStatus(LastNaviStatusListener listener) {
        if (!this.mHasInit) {
            init();
        }
        this.mStatusListener = listener;
        DBManager.getLastNaviPointsFromDB(this.callback);
    }

    public synchronized void init() {
        if (!this.mHasInit) {
            try {
                DBManager.init(BNaviModuleManager.getContext().getApplicationContext());
                this.mHasInit = true;
                LogUtil.m15791e(TAG, "init db");
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public void clearLastNaviInfo() {
        if (!this.mHasInit) {
            init();
        }
        DBManager.clearLastnaviPoints();
    }

    public void addLastNaviPointsToDB(ArrayList<RoutePlanNode> nodes) {
        if (!this.mHasInit) {
            init();
        }
        LogUtil.m15791e(TAG, "addLastNaviPointsToDB");
        DBManager.addLastNaviPointsToDB(nodes);
    }

    public void setNaviFlag(Context context, boolean flag) {
        if (context != null) {
            PreferenceHelper.getInstance(context).putBoolean(NAVI_FLAG_PREF, flag);
        }
    }

    public boolean getNaviFlag(Context context) {
        if (context == null) {
            return false;
        }
        return PreferenceHelper.getInstance(context).getBoolean(NAVI_FLAG_PREF, false);
    }

    public void setKilledTime(Context context, long time) {
        if (context != null) {
            PreferenceHelper.getInstance(context).putLong(NAVI_KILL_TIME_PREF, time);
        }
    }

    public long geKilledTime(Context context) {
        if (context == null) {
            return 0;
        }
        return PreferenceHelper.getInstance(context).getLong(NAVI_KILL_TIME_PREF, 0);
    }
}
