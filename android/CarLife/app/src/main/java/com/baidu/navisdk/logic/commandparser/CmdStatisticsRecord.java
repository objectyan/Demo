package com.baidu.navisdk.logic.commandparser;

import android.text.TextUtils;
import com.baidu.navisdk.logic.CommandBase;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.NameValuePair;

public class CmdStatisticsRecord
  extends CommandBase
{
  private static final String JSONKEY_ACTION = "\"act\":";
  private static final String JSONKEY_ACTPARAM = "\"ActParam\":";
  private static final String JSONKEY_BUPARAM = "\"bu\":";
  private static final String JSONKEY_LT = "\"lt\":";
  private static final String JSONKEY_TM = "\"tm\":";
  private static final String TAG = "CmdStatisticsRecord";
  ArrayList<NameValuePair> mActParams;
  int mActionTime;
  ArrayList<NameValuePair> mBuParams;
  Integer mEventId;
  String mLabel;
  String mValue;
  
  private String getParam(ArrayList<NameValuePair> paramArrayList)
  {
    Object localObject = "";
    if (paramArrayList == null) {
      return "";
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(new ArrayList(paramArrayList));
    int i = 0;
    paramArrayList = (ArrayList<NameValuePair>)localObject;
    while (i < localArrayList.size())
    {
      localObject = ((NameValuePair)localArrayList.get(i)).getValue().trim();
      localObject = paramArrayList + "\"" + ((NameValuePair)localArrayList.get(i)).getName() + "\":\"" + (String)localObject + "\"";
      paramArrayList = (ArrayList<NameValuePair>)localObject;
      if (i < localArrayList.size() - 1) {
        paramArrayList = (String)localObject + ",";
      }
      i += 1;
    }
    localObject = paramArrayList;
    if (paramArrayList.endsWith(",")) {
      localObject = paramArrayList.substring(0, paramArrayList.length() - 1);
    }
    return (String)localObject;
  }
  
  private String getStatsStr()
  {
    Object localObject = getParam(this.mActParams);
    String str = getParam(this.mBuParams);
    int i = (int)(System.currentTimeMillis() / 1000L);
    this.mActionTime = i;
    localObject = new StringBuilder().append("{\"lt\":").append(this.mValue).append(",").append("\"tm\":").append(i).append(",").append("\"act\":").append("\"").append(this.mEventId).append("\",").append("\"ActParam\":").append("{").append((String)localObject).append("}");
    if (!TextUtils.isEmpty(str)) {}
    for (str = ",\"bu\":{" + str + "}";; str = "") {
      return str + "}";
    }
  }
  
  private boolean isNaviSessionStat()
    throws IllegalArgumentException
  {
    if (this.mEventId == null) {
      throw new IllegalArgumentException();
    }
    switch (this.mEventId.intValue())
    {
    case 50004: 
    case 50005: 
    default: 
      return false;
    }
    return true;
  }
  
  public static void packetParams(ReqData paramReqData, int paramInt, String paramString, ArrayList<NameValuePair> paramArrayList1, ArrayList<NameValuePair> paramArrayList2)
  {
    paramReqData.mParams.put("param.statistics.eventid", Integer.valueOf(paramInt));
    paramReqData.mParams.put("param.statistics.value", paramString);
    paramString = new HashMap();
    if ((paramArrayList1 != null) && (!paramArrayList1.isEmpty())) {
      paramString.put("act", paramArrayList1);
    }
    if ((paramArrayList2 != null) && (!paramArrayList2.isEmpty())) {
      paramString.put("bu", paramArrayList2);
    }
    paramReqData.mParams.put("param.statistics.pairs", paramString);
  }
  
  protected CommandResult exec()
  {
    if (this.mValue == null) {
      this.mValue = "1";
    }
    if (this.mEventId == null) {
      return this.mRet;
    }
    getStatsStr();
    this.mRet.setSuccess();
    return this.mRet;
  }
  
  protected void unpacketParams(ReqData paramReqData)
  {
    this.mEventId = ((Integer)paramReqData.mParams.get("param.statistics.eventid"));
    this.mValue = ((String)paramReqData.mParams.get("param.statistics.value"));
    paramReqData = paramReqData.mParams.get("param.statistics.pairs");
    if ((paramReqData != null) && ((paramReqData instanceof HashMap)))
    {
      paramReqData = (HashMap)paramReqData;
      this.mActParams = ((ArrayList)paramReqData.get("act"));
      this.mBuParams = ((ArrayList)paramReqData.get("bu"));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/commandparser/CmdStatisticsRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */