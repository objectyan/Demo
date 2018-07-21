package com.baidu.navisdk.logic.commandparser;

import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.verify.BNKeyVerify;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.HttpPostBase;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.http.HttpURLManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class CmdSDKVerify
  extends HttpPostBase
{
  private static final String K_LBS_SERVICE_NAVI_SDK = "lbs_navsdk";
  private static final String URL = HttpURLManager.getInstance().getScheme() + "sapi.map.baidu.com/sdkcs/verify";
  String mAccessKey;
  String mCode;
  int mVerifiedUID;
  
  public static void packetParams(ReqData paramReqData, String paramString)
  {
    paramReqData.mParams.put("param.sdkop.verifyaccesskey", paramString);
  }
  
  protected List<NameValuePair> generateParams()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("ak", this.mAccessKey));
    localArrayList.add(new BasicNameValuePair("mcode", PackageUtil.getAuthString(BNaviModuleManager.getContext())));
    localArrayList.add(new BasicNameValuePair("from", "lbs_navsdk"));
    localArrayList.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
    return localArrayList;
  }
  
  protected String getUrl()
  {
    return URL;
  }
  
  protected void parseJson()
  {
    try
    {
      int i = this.mJson.optInt("status", -1);
      long l = this.mJson.optLong("uid", -1L);
      this.mJson.optString("message");
      if (i == 0)
      {
        BNKeyVerify.getInstance().setVerifiedUID(l);
        this.mRet.setSuccess();
        return;
      }
      this.mRet.setSDKError(5);
      return;
    }
    catch (Exception localException)
    {
      this.mRet.setSDKError(3);
    }
  }
  
  protected void unpacketParams(ReqData paramReqData)
  {
    this.mAccessKey = ((String)paramReqData.mParams.get("param.sdkop.verifyaccesskey"));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/commandparser/CmdSDKVerify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */