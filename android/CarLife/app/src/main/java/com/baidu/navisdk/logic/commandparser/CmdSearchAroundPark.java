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
import java.util.HashMap;
import java.util.Locale;

public class CmdSearchAroundPark
  extends CommandBase
  implements JNISearchConst
{
  SearchCircle mCircle;
  String mName;
  int mNetMode;
  int mPoiCount;
  ArrayList<SearchParkPoi> poiList = new ArrayList();
  
  public static void packetParams(ReqData paramReqData, String paramString, SearchCircle paramSearchCircle, int paramInt1, int paramInt2)
  {
    paramReqData.mParams.put("param.search.key", paramString);
    paramReqData.mParams.put("param.search.circle", paramSearchCircle);
    paramReqData.mParams.put("param.search.netmode", Integer.valueOf(paramInt1));
    paramReqData.mParams.put("param.search.poicount", Integer.valueOf(paramInt2));
  }
  
  private SearchParkPoi parseParkPoiBundle(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    SearchParkPoi localSearchParkPoi = new SearchParkPoi();
    localSearchParkPoi.mName = StringUtils.trimString(paramBundle.getString("Name"));
    localSearchParkPoi.mAddress = StringUtils.trimString(paramBundle.getString("Address"));
    localSearchParkPoi.mPhone = paramBundle.getString("Phone");
    localSearchParkPoi.mGuidePoint = new GeoPoint(paramBundle.getInt("GuideLongitude", Integer.MIN_VALUE), paramBundle.getInt("GuideLatitude", Integer.MIN_VALUE));
    localSearchParkPoi.mViewPoint = new GeoPoint(paramBundle.getInt("ViewLongitude", Integer.MIN_VALUE), paramBundle.getInt("ViewLatitude", Integer.MIN_VALUE));
    localSearchParkPoi.mDistrictId = paramBundle.getInt("DistrictId", 0);
    localSearchParkPoi.mId = paramBundle.getInt("Id", 0);
    localSearchParkPoi.mTotalCnt = paramBundle.getInt("TotalCnt");
    localSearchParkPoi.mLeftCnt = paramBundle.getInt("LeftCnt");
    localSearchParkPoi.mDistance = paramBundle.getInt("Distance");
    localSearchParkPoi.mParkKind = SearchParkPoi.SearchParkKindEnum.valueOf(paramBundle.getInt("ParkKind"));
    localSearchParkPoi.mParkType = SearchParkPoi.SearchParkTypeEnum.valueOf(paramBundle.getInt("ParkType"));
    localSearchParkPoi.mTollText = StringUtils.trimString(paramBundle.getString("TollText"));
    localSearchParkPoi.mOpenTime = StringUtils.trimString(paramBundle.getString("OpenTime"));
    localSearchParkPoi.mDbPriceDay = paramBundle.getDouble("DbPriceNight");
    localSearchParkPoi.mDbPriceNight = paramBundle.getDouble("DbPriceNight");
    return localSearchParkPoi;
  }
  
  protected CommandResult exec()
  {
    SearchStatItem localSearchStatItem = SearchStatItem.getInstance();
    localSearchStatItem.init();
    long l = SystemClock.elapsedRealtime();
    int i = searchAroundParks(this.mName, this.mCircle, this.mNetMode, this.mPoiCount, this.poiList);
    if (i >= 0)
    {
      this.mRet.setSuccess();
      if (i < 0) {
        break label106;
      }
    }
    label106:
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
      localMessage.obj = new RspData(this.mReqData, null);
      localMessage.sendToTarget();
      this.mReqData.mHasMsgSent = true;
    }
  }
  
  protected void handleSuccess()
  {
    ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).setSearchParkPoi(this.poiList);
    if (!this.mReqData.mHasMsgSent)
    {
      Message localMessage = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
      localMessage.arg1 = 0;
      localMessage.obj = new RspData(this.mReqData, this.poiList);
      localMessage.sendToTarget();
      this.mReqData.mHasMsgSent = true;
    }
  }
  
  public int searchAroundParks(String paramString, SearchCircle paramSearchCircle, int paramInt1, int paramInt2, ArrayList<SearchParkPoi> paramArrayList)
  {
    if ((paramString == null) || (paramArrayList == null) || (paramSearchCircle == null) || (paramSearchCircle.mCenter == null))
    {
      paramInt1 = -1;
      return paramInt1;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("Name", paramString.toUpperCase(Locale.getDefault()));
    localBundle.putInt("CenterX", paramSearchCircle.mCenter.getLongitudeE6());
    localBundle.putInt("CenterY", paramSearchCircle.mCenter.getLatitudeE6());
    localBundle.putInt("Radius", paramSearchCircle.mRadius);
    localBundle.putInt("PoiCount", paramInt2);
    paramString = new ArrayList();
    paramInt1 = JNISearchControl.sInstance.searchAroundParks(localBundle, paramString);
    LogUtil.e("", "searchAroundParks() ret: " + paramInt1);
    LogUtil.e("", "outputList count: " + paramString.size());
    if (paramInt1 < 0) {
      return -4;
    }
    int i = paramString.size();
    paramInt2 = 0;
    for (;;)
    {
      paramInt1 = i;
      if (paramInt2 >= i) {
        break;
      }
      paramArrayList.add(parseParkPoiBundle((Bundle)paramString.get(paramInt2)));
      paramInt2 += 1;
    }
  }
  
  protected void unpacketParams(ReqData paramReqData)
  {
    this.mName = ((String)paramReqData.mParams.get("param.search.key"));
    this.mCircle = ((SearchCircle)paramReqData.mParams.get("param.search.circle"));
    this.mNetMode = ((Integer)paramReqData.mParams.get("param.search.netmode")).intValue();
    this.mPoiCount = ((Integer)paramReqData.mParams.get("param.search.poicount")).intValue();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/commandparser/CmdSearchAroundPark.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */