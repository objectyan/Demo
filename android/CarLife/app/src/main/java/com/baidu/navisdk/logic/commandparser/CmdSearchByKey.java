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
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.SearchStatItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class CmdSearchByKey
  extends CommandBase
  implements JNISearchConst
{
  Integer mDistrictId;
  String mKey;
  Integer mNetMode;
  Integer mPoiCount;
  ArrayList<SearchPoi> mPoiList = new ArrayList();
  
  public static void packetParams(ReqData paramReqData, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    paramReqData.mParams.put("param.search.key", paramString);
    paramReqData.mParams.put("param.search.districtid", Integer.valueOf(paramInt1));
    paramReqData.mParams.put("param.search.poicount", Integer.valueOf(paramInt2));
    paramReqData.mParams.put("param.search.netmode", Integer.valueOf(paramInt3));
  }
  
  protected CommandResult exec()
  {
    boolean bool2 = true;
    Object localObject = SearchStatItem.getInstance();
    ((SearchStatItem)localObject).init();
    long l = SystemClock.elapsedRealtime();
    int i = nameSearchByKey(this.mKey, this.mDistrictId.intValue(), this.mPoiCount.intValue(), this.mNetMode.intValue(), this.mPoiList);
    label69:
    int j;
    if (i >= 0)
    {
      this.mRet.setSuccess();
      if (i < 0) {
        break label139;
      }
      bool1 = true;
      ((SearchStatItem)localObject).mSearchSucc = bool1;
      j = BNPoiSearcher.getInstance().getSearchNetworkMode();
      ((SearchStatItem)localObject).setSearchType(j);
      ((SearchStatItem)localObject).setResponseTime(SystemClock.elapsedRealtime() - l);
      ((SearchStatItem)localObject).onEvent();
      localObject = BNPoiSearcher.getInstance();
      if (i < 0) {
        break label144;
      }
    }
    label139:
    label144:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((BNPoiSearcher)localObject).mtjStatSearch(j, bool1);
      return this.mRet;
      this.mRet.set(i);
      break;
      bool1 = false;
      break label69;
    }
  }
  
  protected void handleSuccess()
  {
    Object localObject = (PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel");
    if (localObject != null) {
      ((PoiSearchModel)localObject).setPoiList(this.mPoiList);
    }
    if (!this.mReqData.mHasMsgSent)
    {
      localObject = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).obj = new RspData(this.mReqData, this.mPoiList);
      ((Message)localObject).sendToTarget();
      this.mReqData.mHasMsgSent = true;
    }
  }
  
  public int nameSearchByKey(String paramString, int paramInt1, int paramInt2, int paramInt3, ArrayList<SearchPoi> paramArrayList)
  {
    if ((paramString == null) || (paramArrayList == null))
    {
      paramInt1 = -1;
      return paramInt1;
    }
    if (paramString.length() <= 0) {
      return -2;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("Name", paramString.toUpperCase(Locale.getDefault()));
    localBundle.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(paramInt1));
    if (paramInt3 == 1) {}
    for (paramInt1 = Math.min(paramInt2, 20);; paramInt1 = Math.min(paramInt2, 100))
    {
      localBundle.putInt("PoiCount", paramInt1);
      paramString = new ArrayList();
      paramInt1 = JNISearchControl.sInstance.searchByName(localBundle, paramString);
      LogUtil.e("", "searchByName() ret: " + paramInt1);
      LogUtil.e("", "outputList count: " + paramString.size());
      if (paramInt1 >= 0) {
        break;
      }
      return -4;
    }
    paramInt3 = paramString.size();
    paramInt2 = 0;
    for (;;)
    {
      paramInt1 = paramInt3;
      if (paramInt2 >= paramInt3) {
        break;
      }
      localBundle = (Bundle)paramString.get(paramInt2);
      paramArrayList.add(JNISearchControl.sInstance.parsePoiBundle(localBundle));
      paramInt2 += 1;
    }
  }
  
  protected void unpacketParams(ReqData paramReqData)
  {
    this.mKey = ((String)paramReqData.mParams.get("param.search.key"));
    this.mDistrictId = ((Integer)paramReqData.mParams.get("param.search.districtid"));
    this.mPoiCount = ((Integer)paramReqData.mParams.get("param.search.poicount"));
    this.mNetMode = ((Integer)paramReqData.mParams.get("param.search.netmode"));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/commandparser/CmdSearchByKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */