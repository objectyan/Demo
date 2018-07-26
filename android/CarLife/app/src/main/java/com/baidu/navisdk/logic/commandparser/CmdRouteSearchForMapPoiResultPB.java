package com.baidu.navisdk.logic.commandparser;

import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.jni.nativeif.JNISearchControl;
import com.baidu.navisdk.logic.CommandBase;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.SearchStatItem;
import java.util.Locale;

public class CmdRouteSearchForMapPoiResultPB extends CommandBase implements JNISearchConst {
    Bundle mDataBundle = null;
    String mMrsl = null;
    int mPageNumber;
    int mPoiCount;
    int mRouteSearchMode = -1;
    int mSearchRange = 500;
    String mSearchWord = null;
    int mSortType;

    public static void packetParams(ReqData reqdata, int routeSearchMode, String searchWord, int searchRange, int sortType, String mrsl, int poiCount, int pageNumber) {
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_ROUTE_SEARCH_MODE, Integer.valueOf(routeSearchMode));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_KEY, searchWord);
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_RANGE, Integer.valueOf(searchRange));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_SORT_TYPE, Integer.valueOf(sortType));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_MRSL, mrsl);
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_POICNT, Integer.valueOf(poiCount));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_PAGERNUM, Integer.valueOf(pageNumber));
    }

    protected void unpacketParams(ReqData reqdata) {
        this.mRouteSearchMode = ((Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_ROUTE_SEARCH_MODE)).intValue();
        this.mSearchWord = (String) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_KEY);
        this.mSearchRange = ((Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_RANGE)).intValue();
        this.mSortType = ((Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_SORT_TYPE)).intValue();
        this.mMrsl = (String) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_MRSL);
        this.mPoiCount = ((Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_POICNT)).intValue();
        this.mPageNumber = ((Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_PAGERNUM)).intValue();
    }

    protected CommandResult exec() {
        this.mDataBundle = new Bundle();
        long startTime = SystemClock.elapsedRealtime();
        int ret = routeSearchForMapPoiResultPB(this.mRouteSearchMode, this.mSearchWord, this.mSearchRange, this.mSortType, this.mMrsl, this.mPoiCount, this.mPageNumber, this.mDataBundle);
        if (ret == 0) {
            this.mRet.setSuccess();
        } else {
            this.mRet.set(ret);
        }
        SearchStatItem statItem = SearchStatItem.getInstance();
        statItem.mSearchSucc = ret >= 0;
        statItem.setSearchType(BNPoiSearcher.getInstance().getSearchNetworkMode());
        statItem.setResponseTime(SystemClock.elapsedRealtime() - startTime);
        statItem.onEvent();
        return this.mRet;
    }

    protected void handleSuccess() {
        if (!this.mReqData.mHasMsgSent) {
            Message msg = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
            msg.arg1 = 0;
            msg.obj = new RspData(this.mReqData, this.mDataBundle);
            msg.sendToTarget();
            this.mReqData.mHasMsgSent = true;
        }
    }

    protected void handleError() {
        super.handleError();
        if (!this.mReqData.mHasMsgSent) {
            Message msg = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
            msg.arg1 = -1;
            msg.obj = new RspData(this.mReqData, this.mDataBundle);
            msg.sendToTarget();
            this.mReqData.mHasMsgSent = true;
        }
    }

    public int routeSearchForMapPoiResultPB(int routeSearchMode, String searchWord, int searchRange, int sortType, String mrsl, int poiCount, int pageNumber, Bundle data) {
        if (searchWord == null) {
            return -1;
        }
        if (searchWord.length() <= 0) {
            return -2;
        }
        Bundle input = new Bundle();
        input.putInt(JNISearchConst.JNI_ROUTE_SEARCH_MODE, routeSearchMode);
        input.putString("Name", searchWord.toUpperCase(Locale.getDefault()));
        input.putInt("Range", searchRange);
        input.putInt(JNISearchConst.JNI_SORT, sortType);
        input.putString(JNISearchConst.JNI_ROUTE_MRSL, mrsl);
        input.putInt("PoiCount", poiCount);
        input.putInt(JNISearchConst.JNI_POI_PAGERNUM, pageNumber);
        int ret = JNISearchControl.sInstance.RouteSearchForMapPoiResultPB(input, data);
        LogUtil.m15791e("", "routeSearchForMapPoiResultPB() ret: " + ret);
        if (ret < 0) {
            return -4;
        }
        return ret;
    }
}
