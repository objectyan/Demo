package com.baidu.navi.track;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.baidunavis.control.NavTrajectoryController;
import com.baidu.baidunavis.model.TrajectoryGPSData;
import com.baidu.baidunavis.model.TrajectorySummaryInfo;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.protobuf.CarlifeStatisticsInfoProto.CarlifeStatisticsInfo;
import com.baidu.navi.track.common.TrackConfig;
import com.baidu.navi.track.database.DataBaseConstants;
import com.baidu.navi.track.datashop.TrackDataShop;
import com.baidu.navi.track.model.CarNavi;
import com.baidu.navi.track.model.CarNaviModel;
import com.baidu.navi.track.model.NaviPoint;
import com.baidu.navi.track.util.TrackFileUtil;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;

public class TrackCarDataSolveModel {
    private static final int CAR_DISTANCE_MIN_LIMIT = 200;
    private static final String CRASH_NAVI_GUID = "1111111111";
    private static final String TAG = TrackCarDataSolveModel.class.getSimpleName();
    public static String carCUID;
    public static String carChannel;
    public static String carVersion;
    public static boolean isConnect;
    public static GeoPoint mFinalGeoPoint = null;
    public static GeoPoint mFirstGeoPoint = null;

    /* renamed from: com.baidu.navi.track.TrackCarDataSolveModel$1 */
    class C39621 extends Thread {
        C39621() {
        }

        public void run() {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            TrackCarDataSolveModel.this.transCarNaviData();
            Looper.loop();
        }
    }

    private class TrackSolveData {
        CarNaviModel model;

        private TrackSolveData() {
        }
    }

    public static void setCarlifeStatisticsInfo(CarlifeStatisticsInfo info) {
        if (info != null) {
            carCUID = info.getCuid();
            carVersion = info.getVersionName();
            carChannel = C1253f.jx.a();
            isConnect = true;
            return;
        }
        isConnect = false;
        carCUID = "";
        carChannel = "";
        carVersion = "";
    }

    public void process() {
        if (TrackConfig.getInstance().isOpenNavigateRecord()) {
            new C39621().start();
        }
    }

    private void transCarNaviData() {
        TrajectorySummaryInfo info = NavTrajectoryController.getInstance().getCurrentTrajectorySummaryInfo();
        if (info == null) {
            dataError();
            return;
        }
        Bundle bundle = info.toBundle();
        String strNaviGuid = bundle.getString("guid");
        boolean hasMockGps = bundle.getBoolean("has_mock_gps", true);
        TrackSolveData solveData = getTrackSolveData(bundle, strNaviGuid);
        if (solveData == null) {
            dataError();
            return;
        }
        if (!C1663a.a().N()) {
            setCarlifeStatisticsInfo(null);
        }
        endDataProcess(solveData.model, hasMockGps);
    }

    private TrackSolveData getTrackSolveData(Bundle bundle, String strNavGuid) {
        if (bundle == null || TextUtils.isEmpty(strNavGuid)) {
            return null;
        }
        try {
            ArrayList<TrajectoryGPSData> gpsList = NavTrajectoryController.getInstance().getTrajectoryGPSList(strNavGuid);
            String strStartAddr = bundle.getString(DataBaseConstants.START_ADDR);
            String strEndAddr = bundle.getString(DataBaseConstants.END_ADDR);
            int iDistance = Integer.valueOf(bundle.getString("distance")).intValue();
            int iCtime = Integer.valueOf(bundle.getString("c_time")).intValue();
            int iDuratime = Integer.valueOf(bundle.getString("duration")).intValue();
            double dAveSpeed = Double.valueOf(bundle.getString("ave_speed")).doubleValue();
            if (gpsList == null || gpsList.size() < 2 || TextUtils.isEmpty(strStartAddr) || TextUtils.isEmpty(strEndAddr) || iDistance < 200 || iCtime == 0 || iDuratime == 0 || dAveSpeed == 0.0d) {
                return null;
            }
            double dMaxSpeed = 0.0d;
            Iterator it = gpsList.iterator();
            while (it.hasNext()) {
                TrajectoryGPSData data = (TrajectoryGPSData) it.next();
                if (data != null && dMaxSpeed < ((double) data.mSpeed)) {
                    dMaxSpeed = (double) data.mSpeed;
                }
            }
            if (dMaxSpeed == 0.0d) {
                return null;
            }
            if (!mFirstGeoPoint.isValid() || !mFinalGeoPoint.isValid()) {
                return null;
            }
            CarNaviModel model = new CarNaviModel();
            String sign = TrackFileUtil.trackFileSign(model.getSDcardPath(), strNavGuid);
            model.setSyncState(3);
            CarNavi carNavi = new CarNavi();
            carNavi.setSid("");
            carNavi.setGuid(strNavGuid);
            GeoPoint startGeoPoint = CoordinateTransformUtil.transferGCJ02ToBD09(((double) mFirstGeoPoint.getLongitudeE6()) / 100000.0d, ((double) mFirstGeoPoint.getLatitudeE6()) / 100000.0d);
            GeoPoint endGeoPoint = CoordinateTransformUtil.transferGCJ02ToBD09(((double) mFinalGeoPoint.getLongitudeE6()) / 100000.0d, ((double) mFinalGeoPoint.getLatitudeE6()) / 100000.0d);
            NaviPoint point = new NaviPoint();
            point.setAddr(strStartAddr);
            point.setLng(((double) startGeoPoint.getLongitudeE6()) / 100000.0d);
            point.setLat(((double) startGeoPoint.getLatitudeE6()) / 100000.0d);
            carNavi.setStartPoint(point);
            point = new NaviPoint();
            point.setAddr(strEndAddr);
            point.setLng(((double) endGeoPoint.getLongitudeE6()) / 100000.0d);
            point.setLat(((double) endGeoPoint.getLatitudeE6()) / 100000.0d);
            carNavi.setEndPoint(point);
            carNavi.setType(DataBaseConstants.TYPE_CAR);
            carNavi.setCtime(iCtime);
            carNavi.setModifyTime(iCtime);
            carNavi.setSign(sign);
            carNavi.setAvgSpeed(((double) Math.round(1000.0d * dAveSpeed)) / 1000.0d);
            carNavi.setMaxSpeed(((double) Math.round(1000.0d * dMaxSpeed)) / 1000.0d);
            carNavi.setDuration(iDuratime);
            carNavi.setDistance(iDistance);
            model.setPBData(carNavi);
            TrackSolveData trackSolveData = new TrackSolveData();
            trackSolveData.model = model;
            return trackSolveData;
        } catch (Exception e) {
            return null;
        }
    }

    private void endDataProcess(CarNaviModel model, boolean hasMockGps) {
        TrackDataShop.getInstance().addRecord(model, true);
    }

    private void dataError() {
        C1260i.b(TAG, "dataError");
    }
}
