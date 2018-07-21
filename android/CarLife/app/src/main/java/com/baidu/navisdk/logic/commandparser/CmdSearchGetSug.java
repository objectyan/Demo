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
import com.baidu.navisdk.model.datastruct.SearchSugData;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class CmdSearchGetSug
  extends CommandBase
  implements JNISearchConst
{
  Integer mNetMode;
  String mPrefix;
  private ArrayList<SearchSugData> mSugList = new ArrayList();
  
  public static void packetParams(ReqData paramReqData, String paramString, int paramInt)
  {
    paramReqData.mParams.put("param.search.sugprefix", paramString);
    paramReqData.mParams.put("param.search.netmode", Integer.valueOf(paramInt));
  }
  
  protected CommandResult exec()
  {
    int i = getInputSug(this.mPrefix, this.mNetMode.intValue(), this.mSugList);
    if (i >= 0) {
      this.mRet.setSuccess();
    }
    for (;;)
    {
      return this.mRet;
      this.mRet.set(i);
    }
  }
  
  public int getInputSug(String paramString, int paramInt, ArrayList<SearchSugData> paramArrayList)
  {
    int j;
    if ((paramString == null) || (paramArrayList == null))
    {
      j = -1;
      return j;
    }
    paramInt = paramString.length();
    if ((paramInt <= 0) || (paramInt > 40)) {
      return -2;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("SugPrefix", paramString.toUpperCase(Locale.getDefault()));
    if (JNISearchControl.sInstance.getInputSug((Bundle)localObject, localArrayList) != 0) {
      return -4;
    }
    int k = localArrayList.size();
    paramInt = 0;
    int i = 0;
    for (;;)
    {
      j = paramInt;
      if (i >= k) {
        break;
      }
      localObject = (Bundle)localArrayList.get(i);
      paramString = ((Bundle)localObject).getString("Sug");
      localObject = ((Bundle)localObject).getString("SugAddr");
      SearchSugData localSearchSugData = new SearchSugData();
      localSearchSugData.setAddress((String)localObject);
      localSearchSugData.setName(paramString);
      j = paramInt;
      if (paramString != null)
      {
        paramArrayList.add(localSearchSugData);
        j = paramInt + 1;
      }
      i += 1;
      paramInt = j;
    }
  }
  
  protected void handleSuccess()
  {
    Object localObject = (PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel");
    if (localObject != null) {
      ((PoiSearchModel)localObject).setSugList(this.mSugList);
    }
    if (!this.mReqData.mHasMsgSent)
    {
      localObject = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).obj = new RspData(this.mReqData, this.mSugList);
      ((Message)localObject).sendToTarget();
      this.mReqData.mHasMsgSent = true;
    }
  }
  
  protected void unpacketParams(ReqData paramReqData)
  {
    this.mPrefix = ((String)paramReqData.mParams.get("param.search.sugprefix"));
    this.mNetMode = ((Integer)paramReqData.mParams.get("param.search.netmode"));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/commandparser/CmdSearchGetSug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */