package com.baidu.navisdk.logic.commandparser;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.jni.nativeif.JNISearchControl;
import com.baidu.navisdk.logic.CommandBase;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.datastruct.SearchCircle;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.HashMap;
import java.util.Locale;

public class CmdSearchByKeyForMapPoiResultPB
  extends CommandBase
  implements JNISearchConst
{
  SearchCircle mCircle;
  Bundle mDataBundle = null;
  int mDistrictID;
  String mName;
  int mPageNumber;
  int mPoiCount;
  
  public static void packetParams(ReqData paramReqData, String paramString, int paramInt1, SearchCircle paramSearchCircle, int paramInt2, int paramInt3)
  {
    paramReqData.mParams.put("param.search.key", paramString);
    paramReqData.mParams.put("param.search.districtid", Integer.valueOf(paramInt1));
    if (paramSearchCircle != null) {
      paramReqData.mParams.put("param.search.circle", paramSearchCircle);
    }
    paramReqData.mParams.put("param.search.poicount", Integer.valueOf(paramInt2));
    paramReqData.mParams.put("param.search.pagernum", Integer.valueOf(paramInt3));
  }
  
  protected CommandResult exec()
  {
    this.mDataBundle = new Bundle();
    int i = nameSearchByKeyForMapPoiResultPB(this.mName, this.mDistrictID, this.mCircle, this.mPoiCount, this.mPageNumber, this.mDataBundle);
    if (i >= 0) {
      this.mRet.setSuccess();
    }
    for (;;)
    {
      return this.mRet;
      this.mRet.set(i);
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
  
  public int nameSearchByKeyForMapPoiResultPB(String paramString, int paramInt1, SearchCircle paramSearchCircle, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if (paramString == null) {
      paramInt1 = -1;
    }
    do
    {
      return paramInt1;
      if (paramString.length() <= 0) {
        return -2;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("Name", paramString.toUpperCase(Locale.getDefault()));
      localBundle.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(paramInt1));
      if (paramSearchCircle != null)
      {
        localBundle.putInt("HasCircle", 1);
        localBundle.putInt("CenterX", paramSearchCircle.mCenter.getLongitudeE6());
        localBundle.putInt("CenterY", paramSearchCircle.mCenter.getLatitudeE6());
        localBundle.putInt("Radius", paramSearchCircle.mRadius);
      }
      localBundle.putInt("PoiCount", paramInt2);
      localBundle.putInt("PoiPagerNum", paramInt3);
      paramInt2 = JNISearchControl.sInstance.searchByNameForMapPoiResultPB(localBundle, paramBundle);
      LogUtil.e("", "nameSearchByKeyForMapPoiResultPB() ret: " + paramInt2);
      paramInt1 = paramInt2;
    } while (paramInt2 >= 0);
    return -4;
  }
  
  protected void unpacketParams(ReqData paramReqData)
  {
    this.mName = ((String)paramReqData.mParams.get("param.search.key"));
    this.mDistrictID = ((Integer)paramReqData.mParams.get("param.search.districtid")).intValue();
    if (paramReqData.mParams.containsKey("param.search.circle")) {}
    for (this.mCircle = ((SearchCircle)paramReqData.mParams.get("param.search.circle"));; this.mCircle = null)
    {
      this.mPoiCount = ((Integer)paramReqData.mParams.get("param.search.poicount")).intValue();
      this.mPageNumber = ((Integer)paramReqData.mParams.get("param.search.pagernum")).intValue();
      return;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/commandparser/CmdSearchByKeyForMapPoiResultPB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */