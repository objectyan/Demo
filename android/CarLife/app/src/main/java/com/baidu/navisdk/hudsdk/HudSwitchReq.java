package com.baidu.navisdk.hudsdk;

import android.os.Bundle;
import android.os.Handler;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc.Callback;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.MD5;
import com.baidu.navisdk.util.common.PackageUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class HudSwitchReq
{
  public static void asyncHudAuth(int paramInt, Bundle paramBundle, Handler paramHandler)
  {
    paramHandler = new ReqData("cmd.general.httprequest.func", 7, paramHandler, paramInt, 10000);
    CmdGeneralHttpRequestFunc.addFunc(paramHandler, new CmdGeneralHttpRequestFunc.Callback()
    {
      public List<NameValuePair> getRequestParams()
      {
        ArrayList localArrayList = new ArrayList();
        StringBuffer localStringBuffer = new StringBuffer();
        try
        {
          int i = HudSwitchReq.access$000();
          localArrayList.add(new BasicNameValuePair("city_id", String.valueOf(i)));
          localStringBuffer.append("city_id=");
          localStringBuffer.append(URLEncoder.encode(String.valueOf(i), "utf-8"));
          localArrayList.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
          localStringBuffer.append("&cuid=");
          localStringBuffer.append(URLEncoder.encode(PackageUtil.getCuid(), "utf-8"));
          localArrayList.add(new BasicNameValuePair("os", String.valueOf(0)));
          localStringBuffer.append("&os=");
          localStringBuffer.append(URLEncoder.encode(String.valueOf(0), "utf-8"));
          if (this.val$bundle != null)
          {
            String str1 = this.val$bundle.getString("hudAppPkg");
            String str2 = this.val$bundle.getString("hudVer");
            localArrayList.add(new BasicNameValuePair("pcn", str1));
            localStringBuffer.append("&pcn=");
            localStringBuffer.append(URLEncoder.encode(str1, "utf-8"));
            localArrayList.add(new BasicNameValuePair("sdk_sv", str2));
            localStringBuffer.append("&sdk_sv=");
            localStringBuffer.append(URLEncoder.encode(str2, "utf-8"));
          }
          localArrayList.add(new BasicNameValuePair("sv", PackageUtil.getVersionName()));
          localStringBuffer.append("&sv=");
          localStringBuffer.append(URLEncoder.encode(PackageUtil.getVersionName(), "utf-8"));
          localArrayList.add(new BasicNameValuePair("sign", MD5.toMD5("hud" + localStringBuffer.toString() + "1d51214e51fe24490ae78dc8ed8b5114").toLowerCase()));
          LogUtil.e("BNRemote", "asynPullRoadList getRequestParams= " + localArrayList.toString());
          return localArrayList;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
        return null;
      }
      
      public int getRequestType()
      {
        return 1;
      }
      
      public String getUrl()
      {
        return BNRemoteConstants.HUDSDK_SWITCH_URL_ONLINE;
      }
      
      public boolean parseResponseJSON(JSONObject paramAnonymousJSONObject)
      {
        return false;
      }
      
      public void responseImage(byte[] paramAnonymousArrayOfByte) {}
    });
    CommandCenter.getInstance().sendRequest(paramHandler);
  }
  
  private static int getCityID()
  {
    int i = 131;
    DistrictInfo localDistrictInfo = GeoLocateModel.getInstance().getCurrentDistrict();
    if (localDistrictInfo != null) {
      i = localDistrictInfo.mId;
    }
    return i;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/hudsdk/HudSwitchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */