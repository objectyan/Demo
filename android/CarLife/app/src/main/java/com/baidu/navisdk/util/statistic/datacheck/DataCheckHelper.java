package com.baidu.navisdk.util.statistic.datacheck;

import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpCenterHelper;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.http.center.IBNHttpCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

public class DataCheckHelper
{
  private static final int K_TIMEOUT_STATISTICS = 4000;
  public static final String NAVI_URL;
  private static final String NAVI_URL_OFFLINE = "http://cq01-rdqa-pool211.cq01.baidu.com:8282/statistics/sendCheck";
  private static final String NAVI_URL_ONLINE = HttpURLManager.getInstance().getScheme() + "appnavi.baidu.com/statistics/sendCheck";
  public static int eventId = -1;
  private static int pushNaviStatisticsRet;
  private static List<NameValuePair> sStatParamsPrefixs;
  public static JSONObject sUpJson = null;
  public static JSONArray sUpJsonArr = null;
  
  static
  {
    NAVI_URL = NAVI_URL_ONLINE;
    sStatParamsPrefixs = new ArrayList();
    pushNaviStatisticsRet = 0;
  }
  
  public static String getUpJson()
  {
    return sUpJson.toString();
  }
  
  public static void initStatParamsPrefix()
  {
    LogUtil.e("DataCheckHelper", "initStatParamsPrefix start");
    sStatParamsPrefixs.add(new BasicNameValuePair("sv", PackageUtil.getVersionName()));
    sStatParamsPrefixs.add(new BasicNameValuePair("os", "Android"));
    sStatParamsPrefixs.add(new BasicNameValuePair("ov", PackageUtil.strOSVersion));
    sStatParamsPrefixs.add(new BasicNameValuePair("pcn", PackageUtil.getPackageName()));
    sStatParamsPrefixs.add(new BasicNameValuePair("ch", PackageUtil.getChannel()));
    sStatParamsPrefixs.add(new BasicNameValuePair("mb", PackageUtil.strPhoneType));
    sStatParamsPrefixs.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
    LogUtil.e("DataCheckHelper", "initStatParamsPrefix end " + sStatParamsPrefixs.size());
  }
  
  public static boolean pushNaviStatistics(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      LogUtil.e("DataCheckHelper", "upJson is null");
    }
    do
    {
      return false;
      pushNaviStatisticsRet = 0;
      Object localObject = new ArrayList();
      if (sStatParamsPrefixs.isEmpty()) {
        initStatParamsPrefix();
      }
      ((List)localObject).addAll(sStatParamsPrefixs);
      ((List)localObject).add(new BasicNameValuePair("dc", paramString));
      if (LogUtil.LOGGABLE)
      {
        paramString = ((List)localObject).iterator();
        while (paramString.hasNext())
        {
          NameValuePair localNameValuePair = (NameValuePair)paramString.next();
          LogUtil.e("DataCheckHelper", "push pair name = " + localNameValuePair.getName() + " value = " + localNameValuePair.getValue());
        }
      }
      paramString = new BNHttpParams();
      paramString.isAsync = false;
      localObject = BNHttpCenterHelper.formatParams((List)localObject);
      BNHttpCenter.getInstance().post(NAVI_URL, (HashMap)localObject, new BNHttpTextResponseHandler()
      {
        public void onFailure(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          LogUtil.e("DataCheckHelper", "onFailure().statusCode=" + paramAnonymousInt);
          DataCheckHelper.access$002(paramAnonymousInt);
        }
        
        public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          LogUtil.e("DataCheckHelper", "onSuccess().statusCode=" + paramAnonymousInt);
          DataCheckHelper.access$002(paramAnonymousInt);
        }
      }, paramString);
    } while (pushNaviStatisticsRet != 200);
    return true;
  }
  
  public static void reset()
  {
    sUpJson = new JSONObject();
    sUpJsonArr = new JSONArray();
  }
  
  public static void uploadDataCheck(String paramString) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/datacheck/DataCheckHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */