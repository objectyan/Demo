package com.baidu.navisdk.logic.commandparser;

import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.HttpGetBase;
import com.baidu.navisdk.logic.NaviErrCode;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.http.HttpURLManager;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class CmdRequestResource
  extends HttpGetBase
{
  private static final String SERVER_DOWNRESOURCE_URL_OFFLINE = "http://cp01-rdqa-dev168.cp01.baidu.com:8180/navisdk/checkupdate";
  private static final String SERVER_DOWNRESOURCE_URL_ONLINE = HttpURLManager.getInstance().getScheme() + "appnavi.baidu.com/navisdk/checkupdate";
  private static final String TAG = "CmdRequestResource";
  
  protected String generateParams()
  {
    return formatNameValuePair(getRequestParams());
  }
  
  protected List<NameValuePair> getRequestParams()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("os", "0"));
    localArrayList.add(new BasicNameValuePair("pcn", PackageUtil.getPackageName()));
    localArrayList.add(new BasicNameValuePair("sv", PackageUtil.getBNaviSDKVersion()));
    localArrayList.add(new BasicNameValuePair("cpu", PackageUtil.getCPUType()));
    localArrayList.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
    return localArrayList;
  }
  
  protected String getUrl()
  {
    if (LogUtil.LOGGABLE) {
      return "http://cp01-rdqa-dev168.cp01.baidu.com:8180/navisdk/checkupdate";
    }
    return SERVER_DOWNRESOURCE_URL_ONLINE;
  }
  
  protected void parseJson()
  {
    try
    {
      int i = this.mJson.getInt("errno");
      String str = this.mJson.getString("errmsg").toLowerCase();
      LogUtil.e("CmdRequestResource_info", i + "_" + str);
      if ((i != 0) || (!str.equals("success")))
      {
        this.mRet.setAppError(NaviErrCode.getAppError(5));
        return;
      }
      this.mRet.setSuccess();
      this.mJson = this.mJson.getJSONObject("data");
      return;
    }
    catch (JSONException localJSONException)
    {
      this.mRet.setAppError(3);
    }
  }
  
  protected void unpacketParams(ReqData paramReqData) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/commandparser/CmdRequestResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */