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
import com.baidu.navisdk.util.common.LogUtil;
import java.util.HashMap;
import java.util.Locale;

public class CmdSearchByKeyForMapRPNodePoiResultPB
  extends CommandBase
  implements JNISearchConst
{
  int mDistrictID;
  String mName;
  int mNetMode;
  int mPoiCount;
  HashMap<String, Object> mRetData = null;
  int mRouteNodeCount;
  int mRouteNodeType;
  int mViaRouteNodeIndex;
  
  public static void packetParams(ReqData paramReqData, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    paramReqData.mParams.put("param.search.key", paramString);
    paramReqData.mParams.put("param.search.districtid", Integer.valueOf(paramInt1));
    paramReqData.mParams.put("param.search.poicount", Integer.valueOf(paramInt2));
    paramReqData.mParams.put("param.search.netmode", Integer.valueOf(paramInt3));
    paramReqData.mParams.put("route_node_count", Integer.valueOf(paramInt4));
    paramReqData.mParams.put("route_node_type", Integer.valueOf(paramInt5));
    paramReqData.mParams.put("param.search.via_route_node_index", Integer.valueOf(paramInt6));
  }
  
  protected CommandResult exec()
  {
    Object localObject = new Bundle();
    int i = nameSearchByKeyForPBData(this.mName, this.mDistrictID, this.mPoiCount, this.mNetMode, this.mRouteNodeCount, this.mRouteNodeType, (Bundle)localObject);
    this.mRetData = new HashMap();
    boolean bool = false;
    this.mRetData.put("route_node_type", new Integer(this.mRouteNodeType));
    this.mRetData.put("param.search.via_route_node_index", new Integer(this.mViaRouteNodeIndex));
    if (((Bundle)localObject).containsKey("search_jump_to_rp"))
    {
      if (((Bundle)localObject).getInt("search_jump_to_rp") == 1) {
        bool = true;
      }
    }
    else
    {
      this.mRetData.put("search_jump_to_rp", new Boolean(bool));
      if (!bool) {
        break label176;
      }
      localObject = JNISearchControl.sInstance.parsePoiBundle((Bundle)localObject);
      this.mRetData.put("search_poi", localObject);
      label155:
      if (i < 0) {
        break label206;
      }
      this.mRet.setSuccess();
    }
    for (;;)
    {
      return this.mRet;
      bool = false;
      break;
      label176:
      if (!((Bundle)localObject).containsKey("pb_data")) {
        break label155;
      }
      localObject = ((Bundle)localObject).getByteArray("pb_data");
      this.mRetData.put("pb_data", localObject);
      break label155;
      label206:
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
      localMessage.obj = new RspData(this.mReqData, this.mRetData);
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
      localMessage.obj = new RspData(this.mReqData, this.mRetData);
      localMessage.sendToTarget();
      this.mReqData.mHasMsgSent = true;
    }
  }
  
  public int nameSearchByKeyForPBData(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Bundle paramBundle)
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
      if (paramInt3 == 1) {}
      for (paramInt1 = Math.min(paramInt2, 20);; paramInt1 = Math.min(paramInt2, 100))
      {
        localBundle.putInt("PoiCount", paramInt1);
        localBundle.putInt("SearchRouteNodeCount", paramInt4);
        localBundle.putInt("SearchRouteNodeType", paramInt5);
        paramInt2 = JNISearchControl.sInstance.searchByNameForPBData(localBundle, paramBundle);
        LogUtil.e("", "searchByName() ret: " + paramInt2);
        if (paramInt2 >= 0) {
          break;
        }
        return -4;
      }
      paramInt1 = paramInt2;
    } while (paramInt2 <= 0);
    return -paramInt2;
  }
  
  protected void unpacketParams(ReqData paramReqData)
  {
    this.mName = ((String)paramReqData.mParams.get("param.search.key"));
    this.mDistrictID = ((Integer)paramReqData.mParams.get("param.search.districtid")).intValue();
    this.mPoiCount = ((Integer)paramReqData.mParams.get("param.search.poicount")).intValue();
    this.mNetMode = ((Integer)paramReqData.mParams.get("param.search.netmode")).intValue();
    this.mRouteNodeCount = ((Integer)paramReqData.mParams.get("route_node_count")).intValue();
    this.mRouteNodeType = ((Integer)paramReqData.mParams.get("route_node_type")).intValue();
    this.mViaRouteNodeIndex = ((Integer)paramReqData.mParams.get("param.search.via_route_node_index")).intValue();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/commandparser/CmdSearchByKeyForMapRPNodePoiResultPB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */