package com.baidu.navisdk.model;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.ExpandMap;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.SimpleGuideInfo;
import com.baidu.navisdk.model.params.MsgDefine;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.HashMap;
import java.util.Map;

public class VMsgDataCache {
    private static final String TAG = VMsgDataCache.class.getSimpleName();
    @SuppressLint({"UseSparseArrays"})
    private static final Map<Integer, Bundle> sMsgDataCache = new HashMap();

    public static Bundle get(int msgId) {
        Bundle data = getData(msgId);
        if (data != null) {
            LogUtil.m15791e(TAG, "get data cache succ, msgId=" + msgId);
            return data;
        }
        LogUtil.m15791e(TAG, "get data cache failed, msgId=" + msgId);
        return null;
    }

    public static int getInt(int msgId, String key) {
        if (key != null) {
            Bundle data = getData(msgId);
            if (data != null) {
                return data.getInt(key);
            }
        }
        return 0;
    }

    public static String getString(int msgId, String key) {
        if (key != null) {
            Bundle data = getData(msgId);
            if (data != null) {
                return data.getString(key);
            }
        }
        return null;
    }

    public static synchronized void remove(int msgId) {
        synchronized (VMsgDataCache.class) {
            sMsgDataCache.remove(Integer.valueOf(msgId));
        }
    }

    public static synchronized void clear() {
        synchronized (VMsgDataCache.class) {
            sMsgDataCache.clear();
        }
    }

    public static Bundle update(int msgId) {
        Bundle data = getDataOfMsg(msgId);
        if (data != null) {
            putData(msgId, data);
        }
        return data;
    }

    public static void update(int msgId, Bundle data) {
        if (data != null) {
            putData(msgId, data);
        }
    }

    private static Bundle getDataOfMsg(int msgId) {
        Bundle data;
        switch (msgId) {
            case 4100:
                data = new Bundle();
                BNRouteGuider.getInstance().getSimpleMapInfo(data);
                return data;
            case 4101:
            case 4102:
            case 4103:
                data = new Bundle();
                BNRouteGuider.getInstance().getRasterExpandMapInfo(data);
                return data;
            case 4104:
            case 4105:
            case 4106:
                Bundle bundle = BNRouteGuider.getInstance().getAssistRemainDist();
                Integer dist = Integer.valueOf(bundle.getInt("remainDist"));
                if (dist == null) {
                    return null;
                }
                data = new Bundle();
                LogUtil.m15791e(TAG, "~~~ msgId=" + msgId + ", remain dist=" + dist);
                data.putInt(SimpleGuideInfo.RemainDist, dist.intValue());
                data.putString("description", bundle.getString("description"));
                return data;
            case 4108:
                data = new Bundle();
                BNRouteGuider.getInstance().getCurRoadName(data);
                return data;
            case 4109:
            case 4110:
            case 4111:
                data = new Bundle();
                BNRouteGuider.getInstance().getDirectBoardInfo(data);
                return data;
            case MsgDefine.MSG_NAVI_HIGHWAYINFO_SHOW /*4146*/:
            case MsgDefine.MSG_NAVI_HIGHWAYINFO_UPDATE /*4147*/:
            case MsgDefine.MSG_NAVI_HIGHWAYINFO_HIDE /*4148*/:
                data = new Bundle();
                BNRouteGuider.getInstance().getHighWayInfo(data);
                return data;
            case MsgDefine.MSG_NAVI_DEST_STREET_VIEW_SHOW /*4179*/:
            case MsgDefine.MSG_NAVI_DEST_STREET_VIEW_UPDATE /*4180*/:
            case MsgDefine.MSG_NAVI_DEST_STREET_VIEW_HIDE /*4181*/:
                data = new Bundle();
                BNRouteGuider.getInstance().getDestStreetViewInfo(data);
                return data;
            case MsgDefine.MSG_NAVI_IN_HIGHWAY_SHOW /*4406*/:
            case MsgDefine.MSG_NAVI_IN_HIGHWAY_UPDATE /*4407*/:
            case MsgDefine.MSG_NAVI_IN_HIGHWAY_HIDE /*4408*/:
                data = new Bundle();
                BNRouteGuider.getInstance().getInHighWay(data);
                return data;
            case MsgDefine.MSG_NAVI_EXIT_FASTWAY_SHOW /*4409*/:
            case MsgDefine.MSG_NAVI_EXIT_FASTWAY_UPDATE /*4410*/:
            case MsgDefine.MSG_NAVI_EXIT_FASTWAY_HIDE /*4411*/:
                data = new Bundle();
                BNRouteGuider.getInstance().getEixtFastway(data);
                return data;
            case MsgDefine.MSG_NAVI_VECTOR_EXPAND_MAP_SHOW /*4608*/:
                data = new Bundle();
                data.putInt(ExpandMap.GetImage, 1);
                BNRouteGuider.getInstance().getVectorExpandMapInfo(data);
                return data;
            case 4609:
                data = new Bundle();
                data.putInt(ExpandMap.GetImage, 0);
                BNRouteGuider.getInstance().getVectorExpandMapInfo(data);
                return data;
            case 4610:
                data = new Bundle();
                BNRouteGuider.getInstance().getVectorExpandMapInfo(data);
                return data;
            default:
                return null;
        }
    }

    private static synchronized Bundle getData(int msgId) {
        Bundle bundle;
        synchronized (VMsgDataCache.class) {
            bundle = (Bundle) sMsgDataCache.get(Integer.valueOf(msgId));
        }
        return bundle;
    }

    private static synchronized void putData(int msgId, Bundle data) {
        synchronized (VMsgDataCache.class) {
            sMsgDataCache.put(Integer.valueOf(msgId), data);
        }
    }
}
