package com.baidu.navisdk.logic.commandparser;

import android.os.Handler;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.ReqData;
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

public class CmdDebugModeGetURL
{
  public static String errorMsg;
  public static List<DebugModeMessageBean> mGuideMsg = new ArrayList();
  
  private static boolean parseJSON(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    LogUtil.e("wangyang", "parselightJSON json=" + paramJSONObject.toString());
    for (;;)
    {
      int i;
      int j;
      try
      {
        i = paramJSONObject.getInt("errno");
        errorMsg = paramJSONObject.getString("errmsg");
        if (i != 0) {
          break label298;
        }
        paramJSONObject = paramJSONObject.getJSONObject("data").getJSONArray("scene_list");
        if (mGuideMsg == null) {
          break label296;
        }
        mGuideMsg.clear();
        i = 0;
        if (i >= paramJSONObject.length()) {
          break label296;
        }
        Object localObject = paramJSONObject.getJSONObject(i);
        DebugModeMessageBean localDebugModeMessageBean = new DebugModeMessageBean();
        localDebugModeMessageBean.mId = ((JSONObject)localObject).getInt("id");
        localDebugModeMessageBean.mSceneName = ((JSONObject)localObject).getString("scene_name");
        localObject = ((JSONObject)localObject).getJSONArray("serlist");
        j = 0;
        if (j < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
          DebugModeMessageSerBean localDebugModeMessageSerBean = new DebugModeMessageSerBean();
          String str = localJSONObject.getString("key");
          if (str == null) {
            break label300;
          }
          if (str.startsWith("0"))
          {
            localDebugModeMessageSerBean.type = 0;
            localDebugModeMessageSerBean.key = localJSONObject.getString("key").substring(2, str.length());
            localDebugModeMessageSerBean.value = localJSONObject.getString("host");
            if (localDebugModeMessageSerBean.key.equals(HttpURLManager.ULRParam.URL_INIT_CLOUD_CONFIG)) {
              localDebugModeMessageSerBean.flag = BNSettingManager.getInitCloudCfg();
            }
            localDebugModeMessageBean.serList.add(localDebugModeMessageSerBean);
            break label300;
          }
          localDebugModeMessageSerBean.type = 1;
          continue;
        }
        mGuideMsg.add(localDebugModeMessageBean);
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return false;
      }
      i += 1;
      continue;
      label296:
      return true;
      label298:
      return false;
      label300:
      j += 1;
    }
  }
  
  public static boolean requestDebugModeUrl(Handler paramHandler)
  {
    paramHandler = new ReqData("cmd.general.http.post.func", 7, paramHandler, 1405, 10000);
    CmdGeneralHttpPostFunc.addFunc(paramHandler, new CmdGeneralHttpPostFunc.Callback()
    {
      public List<NameValuePair> getRequestParams()
      {
        try
        {
          StringBuffer localStringBuffer = new StringBuffer();
          ArrayList localArrayList = new ArrayList();
          String str = String.valueOf(System.currentTimeMillis());
          localArrayList.add(new BasicNameValuePair("ct", str));
          localStringBuffer.append("ct=");
          localStringBuffer.append(URLEncoder.encode(str, "utf-8"));
          localArrayList.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
          localStringBuffer.append("&cuid=");
          localStringBuffer.append(URLEncoder.encode(PackageUtil.getCuid(), "utf-8"));
          localArrayList.add(new BasicNameValuePair("mb", PackageUtil.strPhoneType));
          localStringBuffer.append("&mb=");
          localStringBuffer.append(URLEncoder.encode(PackageUtil.strPhoneType, "utf-8"));
          localArrayList.add(new BasicNameValuePair("os", "0"));
          localStringBuffer.append("&os=");
          localStringBuffer.append(URLEncoder.encode("0", "utf-8"));
          localArrayList.add(new BasicNameValuePair("p", "1"));
          localStringBuffer.append("&p=");
          localStringBuffer.append(URLEncoder.encode("1", "utf-8"));
          localArrayList.add(new BasicNameValuePair("sv", PackageUtil.getVersionName()));
          localStringBuffer.append("&sv=");
          localStringBuffer.append(URLEncoder.encode(PackageUtil.getVersionName(), "utf-8"));
          LogUtil.e("wangyang", "getRequestParams()=" + localStringBuffer.toString());
          localArrayList.add(new BasicNameValuePair("sign", MD5.toMD5("emode" + localStringBuffer.toString() + "093ca827bf3645b106fb26246bcdb43f").toLowerCase()));
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
        return HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_DEBUG_MODE_GET_URL);
      }
      
      public boolean parseResponseJSON(JSONObject paramAnonymousJSONObject)
      {
        return CmdDebugModeGetURL.parseJSON(paramAnonymousJSONObject);
      }
      
      public void responseImage(byte[] paramAnonymousArrayOfByte) {}
    });
    CommandCenter.getInstance().sendRequest(paramHandler);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/commandparser/CmdDebugModeGetURL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */