package com.baidu.navi.track.datashop;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.navi.track.database.DataBaseConstants.TrackQueryType;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams;

public class TrackDataShop {
    public static final String[] INVALID_ARRDS = new String[]{RoutePlanParams.MY_LOCATION, "地图上的点", "未知路", "当前道路"};
    public static final int MAX_INT_VALUE = Integer.MAX_VALUE;
    public static final String SPECIAL_ADDR_IN_TRACK = "无名路";

    static class Holder {
        static final TrackDataShop sInstance = new TrackDataShop();

        Holder() {
        }
    }

    public static boolean isAddrValid(String addr) {
        if (TextUtils.isEmpty(addr)) {
            return false;
        }
        for (String equals : INVALID_ARRDS) {
            if (equals.equals(addr)) {
                return false;
            }
        }
        return true;
    }

    public static TrackDataShop getInstance() {
        return Holder.sInstance;
    }

    public void addRecord(Object item, boolean isSync) {
        new TrackAddShop().addRecord(item, isSync);
    }

    public void fetchTrackList(Handler handler, String bduid, int ctime, TrackQueryType type) {
        new TrackMainListShop(handler).fetchTrackList(bduid, ctime, type);
    }

    public void fetchTrackList(Handler handler, String bduid, int ctime, int reqCount, TrackQueryType type) {
        new TrackMainListShop(handler).fetchTrackList(bduid, ctime, reqCount, type);
    }

    public void fetchStatistics(Handler handler, int monthLimint) {
        new TrackStatisticShop(handler).fetchStatistic(monthLimint);
    }

    public void deleteRecord(Handler handler, Object trackItem) {
        new TrackDeleteShop(handler).deleteTrackRecord(trackItem);
    }

    public void clearBeforSixMonthGPSFile(String bduid) {
        new TrackMainListShop(null).clearBeforSixMonthGPSFile(bduid);
    }

    public void clearTrackReacords(String useId) {
        new TrackClearShop().clearTrack(useId);
    }

    public void updateNotLoginTracksBduis(String useId) {
        new TrackModifyShop().updateNotLoginTracksBduis(useId);
    }

    private TrackDataShop() {
    }
}
