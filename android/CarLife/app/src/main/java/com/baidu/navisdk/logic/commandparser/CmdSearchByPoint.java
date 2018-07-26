package com.baidu.navisdk.logic.commandparser;

import android.os.Bundle;
import android.os.Message;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.jni.nativeif.JNISearchControl;
import com.baidu.navisdk.logic.CommandBase;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.NaviErrCode;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class CmdSearchByPoint extends CommandBase implements JNISearchConst {
    int mCityId = -1;
    DistrictInfo mDistrict;
    Integer mNetmode = Integer.valueOf(3);
    SearchPoi mPOI;
    GeoPoint mPoint;
    int mProviceId = -1;
    Integer mSubType;

    public static void packetParams(ReqData reqdata, int subtype, GeoPoint point) {
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_SUBTYPE, Integer.valueOf(subtype));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_POINT, point);
    }

    public static void packetParams(ReqData reqdata, int subtype, GeoPoint point, int netmode) {
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_SUBTYPE, Integer.valueOf(subtype));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_POINT, point);
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_NETMODE, Integer.valueOf(netmode));
    }

    protected void unpacketParams(ReqData reqdata) {
        this.mPoint = (GeoPoint) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_POINT);
        this.mSubType = (Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_SUBTYPE);
        this.mNetmode = (Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_NETMODE);
    }

    protected CommandResult exec() {
        DistrictInfo[] districts;
        if (this.mSubType.intValue() == 1) {
            if (this.mNetmode != null) {
                this.mPOI = getPoiByPoint(this.mPoint, this.mNetmode.intValue());
            } else {
                districts = JNISearchControl.sInstance.getDistrictsByPoint(this.mPoint);
                if (districts != null && districts.length > 1) {
                    DistrictInfo district = districts[1];
                    if (district == null || (district.mType != 2 && district.mType != 3)) {
                        return this.mRet;
                    }
                    int netMode = 1;
                    if (district.mType == 2 && BNOfflineDataManager.getInstance().isProvinceDataDownload(district.mId)) {
                        netMode = 0;
                    }
                    GeoLocateModel.getInstance().updateDistrict(this.mPoint, districts[0], districts[1]);
                    this.mPOI = getPoiByPoint(this.mPoint, netMode, district.mId);
                }
            }
            if (this.mPOI != null) {
                this.mRet.setSuccess();
            }
        } else if (this.mSubType.intValue() == 2) {
            districts = JNISearchControl.sInstance.getDistrictsByPoint(this.mPoint);
            if (districts == null || districts.length <= 1) {
                this.mRet.set((int) NaviErrCode.RET_BUG);
            } else {
                for (int i = 0; i < 2; i++) {
                    if (districts[i] == null) {
                        return this.mRet;
                    }
                    if (districts[i].mType == 3) {
                        this.mCityId = districts[i].mId;
                    } else if (districts[i].mType == 2) {
                        this.mProviceId = districts[i].mId;
                    }
                }
                GeoLocateModel.getInstance().updateDistrict(this.mPoint, districts[0], districts[1]);
                this.mRet.setSuccess();
            }
        }
        return this.mRet;
    }

    protected void handleSuccess() {
        Message msg;
        if (this.mSubType.intValue() != 2) {
            PoiSearchModel poiSearchModel = (PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH);
            if (poiSearchModel != null) {
                poiSearchModel.setAntiGeoPoi(this.mPOI);
            }
            if (!this.mReqData.mHasMsgSent) {
                msg = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
                msg.arg1 = 0;
                msg.obj = new RspData(this.mReqData, this.mPOI);
                msg.sendToTarget();
                this.mReqData.mHasMsgSent = true;
            }
        } else if (!this.mReqData.mHasMsgSent) {
            msg = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
            msg.arg1 = 0;
            Bundle bundle = new Bundle();
            bundle.putInt(NaviStatConstants.K_NSC_KEY_FINISHNAVI_CITY, this.mCityId);
            bundle.putInt("provice", this.mProviceId);
            bundle.putInt("LatitudeE6", this.mPoint.getLatitudeE6());
            bundle.putInt("LongitudeE6", this.mPoint.getLongitudeE6());
            msg.obj = new RspData(this.mReqData, bundle);
            msg.sendToTarget();
            this.mReqData.mHasMsgSent = true;
        }
    }

    public SearchPoi getPoiByPoint(GeoPoint point, int netMode) {
        if (point == null) {
            return null;
        }
        DistrictInfo district = JNISearchControl.sInstance.getDistrictByPoint(point, netMode);
        if (district == null) {
            return null;
        }
        if (district.mType == 2 || district.mType == 3) {
            return getPoiByPoint(point, netMode, district.mId);
        }
        return null;
    }

    public SearchPoi getPoiByPoint(GeoPoint point, int netMode, int districtId) {
        if (point == null || districtId == 0) {
            LogUtil.m15791e("", "getPoiByPoint: invalid args!");
            return null;
        }
        Bundle input = new Bundle();
        input.putInt("CenterX", point.getLongitudeE6());
        input.putInt("CenterY", point.getLatitudeE6());
        input.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(districtId));
        Bundle poiBundle = new Bundle();
        if (JNISearchControl.sInstance.getNearestPoiByPoint(input, poiBundle) != 0) {
            return null;
        }
        if (!poiBundle.containsKey("DistrictId") || poiBundle.getInt("DistrictId", 0) == 0) {
            poiBundle.putInt("DistrictId", districtId);
        }
        return JNISearchControl.sInstance.parsePoiBundle(poiBundle);
    }
}
