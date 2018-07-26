package com.baidu.navisdk.ui.ugc.control;

import android.content.Context;
import android.os.Bundle;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.UgcPointInfo;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.module.base.LocationUtils;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.tencent.qplayauto.device.QPlayAutoJNI;

public class UgcFeedbackController {
    private static final String TAG = UgcFeedbackController.class.getName();
    private static String URL_UGC_YAW_DESTINATION = null;
    private static String URL_UGC_YAW_ROUTEADDED = null;
    private static String URL_UGC_YAW_ROUTEBLOCK_OR_ROUTEBAD = null;
    private static String URL_UGC_YAW_TRAFICFLAGERROR = null;
    private Context mContext;
    private UgcFeedbackController mSyncHandler;
    private UgcFeedbackCallback mUgcFeedbackCallback;

    public interface UgcFeedbackCallback {
        void onDataRequireFinish();
    }

    private static class LazyHolder {
        private static UgcFeedbackController sInstance = new UgcFeedbackController();

        private LazyHolder() {
        }
    }

    public interface UGCYAWParamConstans {
        public static final int DESERROR_PROBLEM_CAR_BLOCK = 8198;
        public static final int DESERROR_PROBLEM_CAR_FORBIDDEN = 8199;
        public static final int DESERROR_PROBLEM_GUIDE = 8197;
        public static final int DESERROR_PROBLEM_NOT_FOUND = 8196;
        public static final int DESERROR_PROBLEM_OTHERS = 8200;
        public static final int MSG_UGC_YAW_ROUTEADDED = 8195;
        public static final int MSG_UGC_YAW_ROUTEBAD = 8194;
        public static final int MSG_UGC_YAW_ROUTEBLOCK = 8192;
        public static final int MSG_UGC_YAW_TRAFICFLAGERROR = 8193;
        public static final int NAVI_FINISH_POI_TRIGGER = 6;
        public static final int NAVI_FINISH_TRIGGER = 4;
        public static final int NAVI_IN_TRIGGER = 1;
        public static final int PAGE_TYPE_DESTINATION_CAR_BLOCK = 103;
        public static final int PAGE_TYPE_DESTINATION_CAR_FORBIDDEN = 104;
        public static final int PAGE_TYPE_DESTINATION_GUIDE = 102;
        public static final int PAGE_TYPE_DESTINATION_NOT_FOUND = 101;
        public static final int PAGE_TYPE_DESTINATION_OTHERS = 105;
        public static final int PAGE_TYPE_ROUTEBAD = 203;
        public static final int PAGE_TYPE_ROUTEBLOCK = 202;
        public static final String URL_UGC_YAW_DESTINATION_OFFLINE = "http://cp01-rdqa-dev112.cp01.baidu.com:8086/api/page/poicorrect/destinationerror";
        public static final String URL_UGC_YAW_DESTINATION_ONLINE = (HttpURLManager.getInstance().getScheme() + "i.map.baidu.com/api/page/poicorrect/destinationerror");
        public static final String URL_UGC_YAW_ROUTEADDED_OFFLINE = "http://cp01-rdqa-dev112.cp01.baidu.com:8086/api/page/road/addroad";
        public static final String URL_UGC_YAW_ROUTEADDED_ONLINE = (HttpURLManager.getInstance().getScheme() + "i.map.baidu.com/api/page/road/addroad");
        public static final String URL_UGC_YAW_ROUTEBLOCK_OR_ROUTEBAD_OFFLINE = "http://cp01-rdqa-dev112.cp01.baidu.com:8086/api/page/road/roadobstructedorbad";
        public static final String URL_UGC_YAW_ROUTEBLOCK_OR_ROUTEBAD_ONLINE = (HttpURLManager.getInstance().getScheme() + "i.map.baidu.com/api/page/road/roadobstructedorbad");
        public static final String URL_UGC_YAW_TRAFICFLAGERROR_OFFLINE = "http://cp01-rdqa-dev112.cp01.baidu.com:8086/api/page/road/trafficsignswrong";
        public static final String URL_UGC_YAW_TRAFICFLAGERROR_ONLINE = (HttpURLManager.getInstance().getScheme() + "i.map.baidu.com/api/page/road/trafficsignswrong");
        public static final String busTrigger = "business_trigger";
        public static final String cityID = "city_id";
        public static final String fromCoordinate = "from_point";
        public static final String fromName = "from_name";
        public static final String fromUid = "from_uid";
        public static final String locCoordinate = "user_point";
        public static final String pageType = "page_type";
        public static final String toCoordinate = "to_point";
        public static final String toName = "to_name";
        public static final String toUid = "to_uid";
    }

    private UgcFeedbackController() {
        this.mContext = null;
        this.mUgcFeedbackCallback = null;
        initUgcUrl();
    }

    private void initUgcUrl() {
        if (BNSettingManager.isShowJavaLog()) {
            URL_UGC_YAW_ROUTEBLOCK_OR_ROUTEBAD = UGCYAWParamConstans.URL_UGC_YAW_ROUTEBLOCK_OR_ROUTEBAD_OFFLINE;
            URL_UGC_YAW_TRAFICFLAGERROR = UGCYAWParamConstans.URL_UGC_YAW_TRAFICFLAGERROR_OFFLINE;
            URL_UGC_YAW_ROUTEADDED = UGCYAWParamConstans.URL_UGC_YAW_ROUTEADDED_OFFLINE;
            URL_UGC_YAW_DESTINATION = UGCYAWParamConstans.URL_UGC_YAW_DESTINATION_OFFLINE;
            return;
        }
        URL_UGC_YAW_ROUTEBLOCK_OR_ROUTEBAD = UGCYAWParamConstans.URL_UGC_YAW_ROUTEBLOCK_OR_ROUTEBAD_ONLINE;
        URL_UGC_YAW_TRAFICFLAGERROR = UGCYAWParamConstans.URL_UGC_YAW_TRAFICFLAGERROR_ONLINE;
        URL_UGC_YAW_ROUTEADDED = UGCYAWParamConstans.URL_UGC_YAW_ROUTEADDED_ONLINE;
        URL_UGC_YAW_DESTINATION = UGCYAWParamConstans.URL_UGC_YAW_DESTINATION_ONLINE;
    }

    public static UgcFeedbackController getInstance() {
        return LazyHolder.sInstance;
    }

    public void initUgcFeedbakController(Context mContext, UgcFeedbackCallback mUgcFeedbackCallback) {
        this.mContext = mContext;
        this.mUgcFeedbackCallback = mUgcFeedbackCallback;
    }

    public void uninitUgcFeedbakController() {
        this.mContext = null;
        this.mUgcFeedbackCallback = null;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public String getNaviUgcURLString(int urlType, int actionTrigger) {
        String urlStr = getUGCURLAddr(urlType, actionTrigger);
        if (urlStr == null) {
            return null;
        }
        String urlParam;
        if (urlType == 8195 && actionTrigger == 4) {
            urlParam = getUGCParamInRouteAdded(actionTrigger);
        } else {
            urlParam = getUGCParamInNavi(actionTrigger);
        }
        if (urlParam == null) {
            return null;
        }
        urlStr = urlStr + urlParam;
        LogUtil.m15791e(TAG, "UGCUrlStr:" + urlStr);
        return urlStr;
    }

    private String getUGCURLAddr(int urlType, int actionTrigger) {
        switch (urlType) {
            case 8192:
                return URL_UGC_YAW_ROUTEBLOCK_OR_ROUTEBAD + "?" + getKeyValueStringWithNoPrefix(UGCYAWParamConstans.pageType, 202) + "&";
            case 8193:
                return URL_UGC_YAW_TRAFICFLAGERROR + "?";
            case 8194:
                return URL_UGC_YAW_ROUTEBLOCK_OR_ROUTEBAD + "?" + getKeyValueStringWithNoPrefix(UGCYAWParamConstans.pageType, 203) + "&";
            case 8195:
                return URL_UGC_YAW_ROUTEADDED + "?";
            case UGCYAWParamConstans.DESERROR_PROBLEM_NOT_FOUND /*8196*/:
                return URL_UGC_YAW_DESTINATION + "?" + getKeyValueStringWithNoPrefix(UGCYAWParamConstans.pageType, 101) + "&";
            case UGCYAWParamConstans.DESERROR_PROBLEM_GUIDE /*8197*/:
                return URL_UGC_YAW_DESTINATION + "?" + getKeyValueStringWithNoPrefix(UGCYAWParamConstans.pageType, 102) + "&";
            case UGCYAWParamConstans.DESERROR_PROBLEM_CAR_BLOCK /*8198*/:
                return URL_UGC_YAW_DESTINATION + "?" + getKeyValueStringWithNoPrefix(UGCYAWParamConstans.pageType, 103) + "&";
            case UGCYAWParamConstans.DESERROR_PROBLEM_CAR_FORBIDDEN /*8199*/:
                return URL_UGC_YAW_DESTINATION + "?" + getKeyValueStringWithNoPrefix(UGCYAWParamConstans.pageType, 104) + "&";
            case UGCYAWParamConstans.DESERROR_PROBLEM_OTHERS /*8200*/:
                return URL_UGC_YAW_DESTINATION + "?" + getKeyValueStringWithNoPrefix(UGCYAWParamConstans.pageType, 105) + "&";
            default:
                return null;
        }
    }

    private String getUGCParamInRouteAdded(int actionTrigger) {
        LocData curLoaction = BNSysLocationManager.getInstance().getCurLocation();
        if (curLoaction == null) {
            curLoaction = BNavigator.getInstance().getLocDataCache();
        }
        if (curLoaction == null) {
            return null;
        }
        String urlStr;
        Bundle mBundle = CoordinateTransformUtil.LL2MC(curLoaction.longitude, curLoaction.latitude);
        if (mBundle != null) {
            urlStr = getKeyValueStringWithNoPrefix("user_point", mBundle.getInt("MCx") + "," + mBundle.getInt("MCy"));
        } else {
            urlStr = getKeyValueStringWithNoPrefix("user_point", " , ");
        }
        return (urlStr + getKeyValueString("city_id", LocationUtils.getCurrentCityId())) + getKeyValueString("business_trigger", actionTrigger);
    }

    private String getUGCParamInNavi(int actionTrigger) {
        LocData curLoaction = BNSysLocationManager.getInstance().getCurLocation();
        if (curLoaction == null && (actionTrigger == 4 || actionTrigger == 6)) {
            curLoaction = BNavigator.getInstance().getLocDataCache();
        }
        if (curLoaction != null) {
            String urlStr;
            GeoPoint mGeoPoint;
            Bundle mBundle = CoordinateTransformUtil.LL2MC(curLoaction.longitude, curLoaction.latitude);
            if (mBundle != null) {
                urlStr = getKeyValueStringWithNoPrefix("user_point", mBundle.getInt("MCx") + "," + mBundle.getInt("MCy"));
            } else {
                urlStr = getKeyValueStringWithNoPrefix("user_point", " , ");
            }
            urlStr = urlStr + getKeyValueString("city_id", LocationUtils.getCurrentCityId());
            RoutePlanModel rpm = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
            if (rpm != null) {
                mGeoPoint = rpm.getStartNode().getGeoPoint();
                mBundle = CoordinateTransformUtil.LLE62MC(mGeoPoint.getLongitudeE6(), mGeoPoint.getLatitudeE6());
                urlStr = urlStr + getKeyValueString("from_point", mBundle.getInt("MCx") + "," + mBundle.getInt("MCy"));
            } else {
                urlStr = urlStr + getKeyValueString("from_point", " , ");
            }
            String uid = "";
            if (rpm != null) {
                uid = rpm.getStartNode().getUID();
                if (uid == null) {
                    uid = "";
                }
                urlStr = urlStr + getKeyValueString("from_uid", uid);
            } else {
                urlStr = urlStr + getKeyValueString("from_uid", "");
            }
            String fromName = "";
            if (rpm != null) {
                fromName = rpm.getStartNode().getDescription();
                if (fromName.equals("")) {
                    fromName = rpm.getStartNode().getName();
                }
                urlStr = urlStr + getKeyValueString("from_name", fromName);
            }
            if (rpm != null) {
                mGeoPoint = rpm.getEndNode().getGeoPoint();
                mBundle = CoordinateTransformUtil.LLE62MC(mGeoPoint.getLongitudeE6(), mGeoPoint.getLatitudeE6());
                urlStr = urlStr + getKeyValueString("to_point", mBundle.getInt("MCx") + "," + mBundle.getInt("MCy"));
            } else {
                urlStr = urlStr + getKeyValueString("to_point", " , ");
            }
            if (rpm != null) {
                uid = rpm.getEndNode().getUID();
                if (uid == null) {
                    uid = "";
                }
                urlStr = urlStr + getKeyValueString("to_uid", uid);
            } else {
                urlStr = urlStr + getKeyValueString("to_uid", "");
            }
            String toName = "";
            if (rpm != null) {
                toName = rpm.getEndNode().getDescription();
                if (toName.equals("")) {
                    toName = rpm.getEndNode().getName();
                }
                urlStr = urlStr + getKeyValueString("to_name", toName);
            }
            return urlStr + getKeyValueString("business_trigger", actionTrigger);
        }
        if (this.mContext != null) {
            TipTool.onCreateToastDialog(this.mContext, "GPS定位中，请在定位成功后报错");
        }
        return null;
    }

    public String getURLStringFinishNavi(int urlType, UgcPointInfo mUgcPointInfo) {
        String urlStr = getUGCURLAddr(urlType, 4);
        if (urlStr == null) {
            return null;
        }
        urlStr = urlStr + getUGCParamFinishNavi(mUgcPointInfo);
        LogUtil.m15791e(TAG, "UGCUrlStr:" + urlStr);
        return urlStr;
    }

    private String getUGCParamFinishNavi(UgcPointInfo mUgcPointInfo) {
        String urlStr;
        GeoPoint mGeoPoint = mUgcPointInfo.mViewPoint;
        if (mGeoPoint != null) {
            Bundle mBundle = CoordinateTransformUtil.LLE62MC(mGeoPoint.getLongitudeE6(), mGeoPoint.getLatitudeE6());
            urlStr = getKeyValueStringWithNoPrefix("user_point", mBundle.getInt("MCx") + "," + mBundle.getInt("MCy"));
        } else {
            urlStr = getKeyValueStringWithNoPrefix("user_point", " , ");
        }
        DistrictInfo mCurrentDistrict = BNPoiSearcher.getInstance().getDistrictByPoint(mGeoPoint, 0);
        if (mCurrentDistrict != null) {
            urlStr = urlStr + getKeyValueString("city_id", mCurrentDistrict.mId);
        } else {
            urlStr = urlStr + getKeyValueString("city_id", QPlayAutoJNI.SONG_LIST_ROOT_ID);
        }
        RoutePlanModel rpm = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
        if (rpm != null) {
            mGeoPoint = rpm.getStartNode().getGeoPoint();
            mBundle = CoordinateTransformUtil.LLE62MC(mGeoPoint.getLongitudeE6(), mGeoPoint.getLatitudeE6());
            urlStr = urlStr + getKeyValueString("from_point", mBundle.getInt("MCx") + "," + mBundle.getInt("MCy"));
        } else {
            urlStr = urlStr + getKeyValueString("from_point", " , ");
        }
        String uid = null;
        if (rpm != null) {
            uid = rpm.getStartNode().getUID();
        }
        if (uid == null) {
            uid = "";
        }
        urlStr = urlStr + getKeyValueString("from_uid", uid);
        if (rpm != null) {
            mGeoPoint = rpm.getEndNode().getGeoPoint();
            mBundle = CoordinateTransformUtil.LLE62MC(mGeoPoint.getLongitudeE6(), mGeoPoint.getLatitudeE6());
            urlStr = urlStr + getKeyValueString("to_point", mBundle.getInt("MCx") + "," + mBundle.getInt("MCy"));
        } else {
            urlStr = urlStr + getKeyValueString("to_point", " , ");
        }
        uid = null;
        if (rpm != null) {
            uid = rpm.getEndNode().getUID();
        }
        if (uid == null) {
            uid = "";
        }
        return (urlStr + getKeyValueString("to_uid", uid)) + getKeyValueString("business_trigger", 4);
    }

    private String getKeyValueString(String key, String value) {
        return "&" + key + "=" + value;
    }

    private String getKeyValueString(String key, int value) {
        return "&" + key + "=" + value;
    }

    private String getKeyValueStringWithNoPrefix(String key, String value) {
        return key + "=" + value;
    }

    private String getKeyValueStringWithNoPrefix(String key, int value) {
        return key + "=" + value;
    }
}
