package com.baidu.navisdk.logic.commandparser;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.jni.nativeif.JNISearchControl;
import com.baidu.navisdk.logic.CommandBase;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.SearchStatItem;
import java.util.HashMap;
import java.util.Locale;

public class CmdRouteSearchForMapPoiResultPB
  extends CommandBase
  implements JNISearchConst
{
  Bundle mDataBundle = null;
  String mMrsl = null;
  int mPageNumber;
  int mPoiCount;
  int mRouteSearchMode = -1;
  int mSearchRange = 500;
  String mSearchWord = null;
  int mSortType;
  
  public static void packetParams(ReqData paramReqData, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, int paramInt4, int paramInt5)
  {
    paramReqData.mParams.put("param.search.route_search_mode", Integer.valueOf(paramInt1));
    paramReqData.mParams.put("param.search.key", paramString1);
    paramReqData.mParams.put("param.search.range", Integer.valueOf(paramInt2));
    paramReqData.mParams.put("param.search.sort_type", Integer.valueOf(paramInt3));
    paramReqData.mParams.put("param.search.mrsl", paramString2);
    paramReqData.mParams.put("param.search.poicount", Integer.valueOf(paramInt4));
    paramReqData.mParams.put("param.search.pagernum", Integer.valueOf(paramInt5));
  }
  
  protected CommandResult exec()
  {
    this.mDataBundle = new Bundle();
    long l = SystemClock.elapsedRealtime();
    int i = routeSearchForMapPoiResultPB(this.mRouteSearchMode, this.mSearchWord, this.mSearchRange, this.mSortType, this.mMrsl, this.mPoiCount, this.mPageNumber, this.mDataBundle);
    SearchStatItem localSearchStatItem;
    if (i == 0)
    {
      this.mRet.setSuccess();
      localSearchStatItem = SearchStatItem.getInstance();
      if (i < 0) {
        break label124;
      }
    }
    label124:
    for (boolean bool = true;; bool = false)
    {
      localSearchStatItem.mSearchSucc = bool;
      localSearchStatItem.setSearchType(BNPoiSearcher.getInstance().getSearchNetworkMode());
      localSearchStatItem.setResponseTime(SystemClock.elapsedRealtime() - l);
      localSearchStatItem.onEvent();
      return this.mRet;
      this.mRet.set(i);
      break;
    }
  }
  
  protected void handleError()
  {
    super.handleError();
    if (!this.mReqData.mHasMsgSent)
    {
      Message localMessage = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
      localMessage.arg1 = -1;
      localMessage.obj = new RspData(this.mReqData, this.mDataBundle);
      localMessage.sendToTarget();
      this.mReqData.mHasMsgSent = true;
    }
  }
  
  protected void handleSuccess()
  {
    if (!this.mReqData.mHasMsgSent)
    {
      Message localMessage = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
      localMessage.arg1 = 0;
      localMessage.obj = new RspData(this.mReqData, this.mDataBundle);
      localMessage.sendToTarget();
      this.mReqData.mHasMsgSent = true;
    }
  }
  
  public int routeSearchForMapPoiResultPB(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, int paramInt4, int paramInt5, Bundle paramBundle)
  {
    if (paramString1 == null) {
      paramInt1 = -1;
    }
    do
    {
      return paramInt1;
      if (paramString1.length() <= 0) {
        return -2;
      }
      Bundle localBundle = new Bundle();
      localBundle.putInt("RouteSearchMode", paramInt1);
      localBundle.putString("Name", paramString1.toUpperCase(Locale.getDefault()));
      localBundle.putInt("Range", paramInt2);
      localBundle.putInt("Sort", paramInt3);
      localBundle.putString("route_mrsl", paramString2);
      localBundle.putInt("PoiCount", paramInt4);
      localBundle.putInt("PoiPagerNum", paramInt5);
      paramInt2 = JNISearchControl.sInstance.RouteSearchForMapPoiResultPB(localBundle, paramBundle);
      LogUtil.e("", "routeSearchForMapPoiResultPB() ret: " + paramInt2);
      paramInt1 = paramInt2;
    } while (paramInt2 >= 0);
    return -4;
  }
  
  protected void unpacketParams(ReqData paramReqData)
  {
    this.mRouteSearchMode = ((Integer)paramReqData.mParams.get("param.search.route_search_mode")).intValue();
    this.mSearchWord = ((String)paramReqData.mParams.get("param.search.key"));
    this.mSearchRange = ((Integer)paramReqData.mParams.get("param.search.range")).intValue();
    this.mSortType = ((Integer)paramReqData.mParams.get("param.search.sort_type")).intValue();
    this.mMrsl = ((String)paramReqData.mParams.get("param.search.mrsl"));
    this.mPoiCount = ((Integer)paramReqData.mParams.get("param.search.poicount")).intValue();
    this.mPageNumber = ((Integer)paramReqData.mParams.get("param.search.pagernum")).intValue();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/commandparser/CmdRouteSearchForMapPoiResultPB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */