package com.baidu.navisdk.logic.commandparser;

import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.jni.nativeif.JNISearchControl;
import com.baidu.navisdk.logic.CommandBase;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.datastruct.SearchCircle;
import com.baidu.navisdk.model.datastruct.SearchParkPoi;
import com.baidu.navisdk.model.datastruct.SearchParkPoi.SearchParkKindEnum;
import com.baidu.navisdk.model.datastruct.SearchParkPoi.SearchParkTypeEnum;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.statistic.SearchStatItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Locale;

public class CmdSearchAroundPark extends CommandBase implements JNISearchConst {
    SearchCircle mCircle;
    String mName;
    int mNetMode;
    int mPoiCount;
    ArrayList<SearchParkPoi> poiList = new ArrayList();

    public static void packetParams(ReqData reqdata, String name, SearchCircle circle, int netMode, int poiCount) {
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_KEY, name);
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_CIRCLE, circle);
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_NETMODE, Integer.valueOf(netMode));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_POICNT, Integer.valueOf(poiCount));
    }

    protected void unpacketParams(ReqData reqdata) {
        this.mName = (String) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_KEY);
        this.mCircle = (SearchCircle) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_CIRCLE);
        this.mNetMode = ((Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_NETMODE)).intValue();
        this.mPoiCount = ((Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_POICNT)).intValue();
    }

    protected CommandResult exec() {
        SearchStatItem statItem = SearchStatItem.getInstance();
        statItem.init();
        long startTime = SystemClock.elapsedRealtime();
        int ret = searchAroundParks(this.mName, this.mCircle, this.mNetMode, this.mPoiCount, this.poiList);
        if (ret >= 0) {
            this.mRet.setSuccess();
        } else {
            this.mRet.set(ret);
        }
        statItem.mSearchSucc = ret >= 0;
        statItem.setSearchType(BNPoiSearcher.getInstance().getSearchNetworkMode());
        statItem.setResponseTime(SystemClock.elapsedRealtime() - startTime);
        statItem.onEvent();
        return this.mRet;
    }

    protected void handleSuccess() {
        ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).setSearchParkPoi(this.poiList);
        if (!this.mReqData.mHasMsgSent) {
            Message msg = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
            msg.arg1 = 0;
            msg.obj = new RspData(this.mReqData, this.poiList);
            msg.sendToTarget();
            this.mReqData.mHasMsgSent = true;
        }
    }

    protected void handleError() {
        super.handleError();
        if (!this.mReqData.mHasMsgSent) {
            Message msg = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
            msg.arg1 = -1;
            msg.obj = new RspData(this.mReqData, null);
            msg.sendToTarget();
            this.mReqData.mHasMsgSent = true;
        }
    }

    public int searchAroundParks(String name, SearchCircle circle, int netMode, int poiCount, ArrayList<SearchParkPoi> poiList) {
        if (name == null || poiList == null || circle == null || circle.mCenter == null) {
            return -1;
        }
        Bundle input = new Bundle();
        input.putString("Name", name.toUpperCase(Locale.getDefault()));
        input.putInt("CenterX", circle.mCenter.getLongitudeE6());
        input.putInt("CenterY", circle.mCenter.getLatitudeE6());
        input.putInt("Radius", circle.mRadius);
        input.putInt("PoiCount", poiCount);
        ArrayList<Bundle> outputList = new ArrayList();
        int ret = JNISearchControl.sInstance.searchAroundParks(input, outputList);
        LogUtil.m15791e("", "searchAroundParks() ret: " + ret);
        LogUtil.m15791e("", "outputList count: " + outputList.size());
        if (ret < 0) {
            return -4;
        }
        int outputSize = outputList.size();
        for (int i = 0; i < outputSize; i++) {
            poiList.add(parseParkPoiBundle((Bundle) outputList.get(i)));
        }
        return outputSize;
    }

    private SearchParkPoi parseParkPoiBundle(Bundle poiBundle) {
        if (poiBundle == null) {
            return null;
        }
        SearchParkPoi poi = new SearchParkPoi();
        poi.mName = StringUtils.trimString(poiBundle.getString("Name"));
        poi.mAddress = StringUtils.trimString(poiBundle.getString(JNISearchConst.JNI_ADDRESS));
        poi.mPhone = poiBundle.getString(JNISearchConst.JNI_PHONE);
        poi.mGuidePoint = new GeoPoint(poiBundle.getInt(JNISearchConst.JNI_GUIDE_LONGITUDE, Integer.MIN_VALUE), poiBundle.getInt(JNISearchConst.JNI_GUIDE_LATITUDE, Integer.MIN_VALUE));
        poi.mViewPoint = new GeoPoint(poiBundle.getInt(JNISearchConst.JNI_VIEW_LONGITUDE, Integer.MIN_VALUE), poiBundle.getInt(JNISearchConst.JNI_VIEW_LATITUDE, Integer.MIN_VALUE));
        poi.mDistrictId = poiBundle.getInt("DistrictId", 0);
        poi.mId = poiBundle.getInt("Id", 0);
        poi.mTotalCnt = poiBundle.getInt(JNISearchConst.JNI_TOTALCNT);
        poi.mLeftCnt = poiBundle.getInt(JNISearchConst.JNI_LEFTCNT);
        poi.mDistance = poiBundle.getInt(JNISearchConst.JNI_DISTANCE);
        poi.mParkKind = SearchParkKindEnum.valueOf(poiBundle.getInt(JNISearchConst.JNI_PARKKINE));
        poi.mParkType = SearchParkTypeEnum.valueOf(poiBundle.getInt(JNISearchConst.JNI_PARKTYPE));
        poi.mTollText = StringUtils.trimString(poiBundle.getString(JNISearchConst.JNI_TOOLTEXT));
        poi.mOpenTime = StringUtils.trimString(poiBundle.getString(JNISearchConst.JNI_OPENTIME));
        poi.mDbPriceDay = poiBundle.getDouble(JNISearchConst.JNI_DBPRICENIGHT);
        poi.mDbPriceNight = poiBundle.getDouble(JNISearchConst.JNI_DBPRICENIGHT);
        return poi;
    }
}
