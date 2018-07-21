package com.baidu.navisdk.lightnavi.utils;

import android.os.Handler;
import com.baidu.navisdk.lightnavi.model.LightNaviGuideBean;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc.Callback;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.MD5;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CmdLightNaviGetGuideInfo
{
  public static String errorMsg;
  public static List<LightNaviGuideBean> mGuideMsg = new ArrayList();
  
  private static boolean parseJSON(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    LogUtil.e("wangyang", "parselightJSON json=" + paramJSONObject.toString());
    for (;;)
    {
      int i;
      try
      {
        i = paramJSONObject.getInt("errno");
        errorMsg = paramJSONObject.getString("errmsg");
        if (i != 0) {
          break;
        }
        paramJSONObject = paramJSONObject.getJSONArray("data");
        if (paramJSONObject != null)
        {
          mGuideMsg.clear();
          i = 0;
          if (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
            LightNaviGuideBean localLightNaviGuideBean = new LightNaviGuideBean();
            localLightNaviGuideBean.type = localJSONObject.getInt("type");
            if (localLightNaviGuideBean.type != 1) {
              break label209;
            }
            localLightNaviGuideBean.cityCode = localJSONObject.getInt("cityCode");
            localLightNaviGuideBean.title = localJSONObject.getString("title");
            localLightNaviGuideBean.content = localJSONObject.getString("content");
            if (localJSONObject.has("play"))
            {
              if (localJSONObject.getInt("play") != 1) {
                break label216;
              }
              bool = true;
              localLightNaviGuideBean.isPlay = bool;
              mGuideMsg.add(localLightNaviGuideBean);
              break label209;
            }
            localLightNaviGuideBean.isPlay = true;
            continue;
          }
        }
        return true;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return false;
      }
      label209:
      i += 1;
      continue;
      label216:
      boolean bool = false;
    }
  }
  
  public static boolean requestLightNaviInfo(Handler paramHandler)
  {
    paramHandler = new ReqData("cmd.general.httprequest.func", 7, paramHandler, 1404, 10000);
    CmdGeneralHttpRequestFunc.addFunc(paramHandler, new CmdGeneralHttpRequestFunc.Callback()
    {
      public List<NameValuePair> getRequestParams()
      {
        try
        {
          StringBuffer localStringBuffer = new StringBuffer();
          ArrayList localArrayList = new ArrayList();
          int i = 0;
          if (GeoLocateModel.getInstance().getCurrentDistrict() != null) {
            i = GeoLocateModel.getInstance().getCurrentDistrict().mId;
          }
          localArrayList.add(new BasicNameValuePair("cityCode", "" + i));
          localStringBuffer.append("cityCode=");
          localStringBuffer.append(URLEncoder.encode("" + i, "utf-8"));
          localArrayList.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
          localStringBuffer.append("&cuid=");
          localStringBuffer.append(URLEncoder.encode(PackageUtil.getCuid(), "utf-8"));
          localArrayList.add(new BasicNameValuePair("os", "0"));
          localStringBuffer.append("&os=");
          localStringBuffer.append(URLEncoder.encode("0", "utf-8"));
          localArrayList.add(new BasicNameValuePair("qtv", "1"));
          localStringBuffer.append("&qtv=");
          localStringBuffer.append(URLEncoder.encode("1", "utf-8"));
          localArrayList.add(new BasicNameValuePair("sid", "1"));
          localStringBuffer.append("&sid=");
          localStringBuffer.append(URLEncoder.encode("1", "utf-8"));
          localArrayList.add(new BasicNameValuePair("sv", PackageUtil.getVersionName()));
          localStringBuffer.append("&sv=");
          localStringBuffer.append(URLEncoder.encode(PackageUtil.getVersionName(), "utf-8"));
          LogUtil.e("wangyang", "getRequestParams()=" + localStringBuffer.toString());
          localArrayList.add(new BasicNameValuePair("sign", MD5.toMD5("mop" + localStringBuffer.toString() + "6456bc093ca827bf3db43fb106fb2624").toLowerCase()));
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
        return HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_IPO_GET_GUIDE_MSG);
      }
      
      public boolean parseResponseJSON(JSONObject paramAnonymousJSONObject)
      {
        return CmdLightNaviGetGuideInfo.parseJSON(paramAnonymousJSONObject);
      }
      
      public void responseImage(byte[] paramAnonymousArrayOfByte) {}
    });
    CommandCenter.getInstance().sendRequest(paramHandler);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/utils/CmdLightNaviGetGuideInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */