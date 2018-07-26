package com.baidu.navisdk.module.ugc.https;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.model.params.MsgDefine;
import com.baidu.navisdk.module.ugc.data.datastatus.UgcReportInfoUploadPackage;
import com.baidu.navisdk.module.ugc.utils.PhotoProcessUtils;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.vi.VMsgDispatcher;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;

public class UgcHttpsUtils {
    private ScreenShotCallBack callBack = null;
    private JNIBaseMap mJniBaseMap = null;
    private MsgHandler mMsgHandler = new MsgHandler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (msg.what == MsgDefine.MSG_NAVI_TYPE_UGC_SCREENSHOT) {
                try {
                    if (UgcHttpsUtils.this.mJniBaseMap != null) {
                        Bundle bundle = new Bundle();
                        UgcHttpsUtils.this.mJniBaseMap.getScreenShotImage(bundle);
                        Bitmap mLockBitmap = Bitmap.createBitmap(bundle.getIntArray("pbtImageData"), bundle.getInt("unImageWidth"), bundle.getInt("unImageHeight"), Config.ARGB_8888);
                        PhotoProcessUtils mPhotoProcessUtils = new PhotoProcessUtils();
                        if (mLockBitmap != null) {
                            Bitmap mCompressBitmap = mPhotoProcessUtils.compress(mLockBitmap, 600, 800);
                            if (mCompressBitmap != null) {
                                String filePath = mPhotoProcessUtils.setBitmapToFile(mCompressBitmap);
                                if (!(UgcHttpsUtils.this.callBack == null || UgcHttpsUtils.this.mJniBaseMap == null)) {
                                    VMsgDispatcher.unregisterMsgHandler(UgcHttpsUtils.this.mMsgHandler);
                                    UgcHttpsUtils.this.mJniBaseMap = null;
                                    UgcHttpsUtils.this.callBack.onScreenShotCompleted(filePath);
                                    return;
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (UgcHttpsUtils.this.callBack != null && UgcHttpsUtils.this.mJniBaseMap != null) {
                    VMsgDispatcher.unregisterMsgHandler(UgcHttpsUtils.this.mMsgHandler);
                    UgcHttpsUtils.this.mJniBaseMap = null;
                    UgcHttpsUtils.this.callBack.onScreenShotCompleted(null);
                }
            }
        }

        public void careAbout() {
            observe((int) MsgDefine.MSG_NAVI_TYPE_UGC_SCREENSHOT);
        }
    };

    public interface ScreenShotCallBack {
        void onScreenShotCompleted(String str);
    }

    static CookieStore getCookieStore() {
        if (BNaviModuleManager.getBduss() == null) {
            return null;
        }
        BasicClientCookie cookie = new BasicClientCookie("BDUSS", BNaviModuleManager.getBduss());
        CookieStore cookieStore = new BasicCookieStore();
        cookie.setDomain(".baidu.com");
        cookie.setPath("/");
        cookie.setVersion(0);
        cookieStore.addCookie(cookie);
        return cookieStore;
    }

    static int getCurrentCityId() {
        DistrictInfo district = GeoLocateModel.getInstance().getCurrentDistrict();
        if (district != null) {
            return district.mId;
        }
        return -1;
    }

    public String getCurrentLocationPoint() {
        LocData curLoaction = BNSysLocationManager.getInstance().getCurLocation();
        String retStr = "";
        if (curLoaction == null) {
            return retStr;
        }
        GeoPoint mGeoPoint = curLoaction.toGeoPoint();
        Bundle mBundle = CoordinateTransformUtil.LL2MC(curLoaction.longitude, curLoaction.latitude);
        if (mBundle != null) {
            return mBundle.getInt("MCx") + "," + mBundle.getInt("MCy");
        }
        return retStr;
    }

    public void setScreenShotParam(int mOrientation, final ScreenShotCallBack mCallBack) {
        int width;
        int height;
        if (this.mJniBaseMap == null) {
            this.mJniBaseMap = new JNIBaseMap();
        }
        VMsgDispatcher.registerMsgHandler(this.mMsgHandler);
        this.callBack = mCallBack;
        ScreenUtil mScreen = ScreenUtil.getInstance();
        if (mOrientation == 1) {
            width = mScreen.getWidthPixels();
            height = mScreen.getHeightPixels() - ScreenUtil.getInstance().dip2px(120);
        } else {
            width = (mScreen.getWidthPixels() * 2) / 3;
            height = mScreen.getHeightPixels();
        }
        if (new JNIBaseMap().setScreenShotParam(4, width, height, 0, 0, 0) || mCallBack == null) {
            new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message msg) {
                    if (mCallBack != null && UgcHttpsUtils.this.mJniBaseMap != null) {
                        UgcHttpsUtils.this.mJniBaseMap = null;
                        mCallBack.onScreenShotCompleted(null);
                        VMsgDispatcher.unregisterMsgHandler(UgcHttpsUtils.this.mMsgHandler);
                    }
                }
            }.sendEmptyMessageDelayed(16, 1500);
        } else {
            mCallBack.onScreenShotCompleted(null);
        }
    }

    static String transferUploadIntToString(int num) {
        if (num == -1) {
            return "";
        }
        return num + "";
    }

    public void addNaviInfoToPackage(UgcReportInfoUploadPackage mPackage, boolean isDynamic) {
        if (mPackage != null) {
            addCommonInfoToPackage(mPackage);
            Bundle bundle = new Bundle();
            BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl(bundle);
            mPackage.sessionId = bundle.getString("session");
            mPackage.mrsl = bundle.getString(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_MRSL);
            mPackage.guid = JNITrajectoryControl.sInstance.getCurrentUUID();
            mPackage.businessTrigger = 1;
            RoutePlanModel rpm = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
            if (rpm != null) {
                Bundle mBundle;
                GeoPoint mGeoPoint = rpm.getStartNode().getGeoPoint();
                if (mGeoPoint != null) {
                    mBundle = CoordinateTransformUtil.LLE62MC(mGeoPoint.getLongitudeE6(), mGeoPoint.getLatitudeE6());
                    mPackage.fromPoint = mBundle.getInt("MCx") + "," + mBundle.getInt("MCy");
                }
                mPackage.fromUid = rpm.getStartNode().getUID() + "";
                String fromName = rpm.getStartNode().getDescription();
                if (fromName == null || fromName.trim().equals("")) {
                    fromName = rpm.getStartNode().getName() + "";
                }
                mPackage.fromName = fromName;
                mGeoPoint = rpm.getEndNode().getGeoPoint();
                if (mGeoPoint != null) {
                    mBundle = CoordinateTransformUtil.LLE62MC(mGeoPoint.getLongitudeE6(), mGeoPoint.getLatitudeE6());
                    mPackage.toPoint = mBundle.getInt("MCx") + "," + mBundle.getInt("MCy");
                }
                String toUid = rpm.getEndNode().getUID();
                if (toUid == null || toUid.trim().equals("null")) {
                    toUid = "";
                }
                mPackage.toUid = toUid;
                String toName = rpm.getEndNode().getDescription();
                if (toName == null || toName.trim().equals("")) {
                    toName = rpm.getEndNode().getName() + "";
                }
                mPackage.toName = toName;
            }
        }
    }

    public void addMapInfoTopackage(UgcReportInfoUploadPackage mPackage) {
        addCommonInfoToPackage(mPackage);
        mPackage.businessTrigger = 8;
    }

    public void addNaviResultInfoToPackge(UgcReportInfoUploadPackage mPackage) {
        addCommonInfoToPackage(mPackage);
        mPackage.businessTrigger = 11;
        mPackage.supply = 1;
    }

    private void addCommonInfoToPackage(UgcReportInfoUploadPackage mPackage) {
        mPackage.cuid = PackageUtil.getCuid();
        mPackage.os = 0;
        mPackage.osv = PackageUtil.strOSVersion;
        mPackage.sv = PackageUtil.strSoftWareVer;
        mPackage.cityId = getCurrentCityId();
        mPackage.cityName = GeoLocateModel.getInstance().getCurCityName();
    }
}
