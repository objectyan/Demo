package com.baidu.navisdk.module.ugc.https;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc.Callback;
import com.baidu.navisdk.module.cloudconfig.CloudConfigObtainManager;
import com.baidu.navisdk.module.ugc.data.datastatus.UgcReportInfoUploadPackage;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpCenterHelper;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.http.center.IBNHttpCenter;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class UgcHttps
{
  public static final int MSG_RUBPOINT_ADSORB_OBTAIN_RET = 5378;
  public static final int MSG_UGCREPORT_INFO_OBTAIN_RET = 5377;
  public static final int MSG_UGCREPORT_INFO_UPLOAD_RET = 5376;
  private static final String TAG = "UgcHttps";
  private UgcHttpsResultCallBack mCallBack = null;
  private Handler mHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage == null) {}
      label136:
      label317:
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return;
              LogUtil.e("UgcHttps mHandler msg:", paramAnonymousMessage.toString());
              localObject4 = null;
              localObject1 = null;
              try
              {
                localObject2 = (RspData)paramAnonymousMessage.obj;
                localObject1 = localObject2;
                localObject3 = (UgcHttps.UgcHttpsResultCallBack)((RspData)localObject2).mReq.getObj();
                localObject1 = localObject3;
                localObject3 = localObject2;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Object localObject2;
                  Object localObject3 = localObject1;
                  localObject1 = localObject4;
                }
              }
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = UgcHttps.this.mCallBack;
              }
              if (paramAnonymousMessage.what == 5376)
              {
                if (paramAnonymousMessage.arg1 == 0)
                {
                  try
                  {
                    paramAnonymousMessage = (JSONObject)((RspData)localObject3).mData;
                    if (paramAnonymousMessage.getInt("errno") != 0) {
                      break label136;
                    }
                    ((UgcHttps.UgcHttpsResultCallBack)localObject2).onUgcInfoReportUpLoadSuccess(paramAnonymousMessage.getJSONObject("data"));
                    return;
                  }
                  catch (Exception paramAnonymousMessage)
                  {
                    paramAnonymousMessage.printStackTrace();
                  }
                  if (localObject2 != null)
                  {
                    ((UgcHttps.UgcHttpsResultCallBack)localObject2).onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(1711670287));
                    return;
                    ((UgcHttps.UgcHttpsResultCallBack)localObject2).onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(1711670287));
                  }
                }
                else if (localObject2 != null)
                {
                  ((UgcHttps.UgcHttpsResultCallBack)localObject2).onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(1711670288));
                }
              }
              else if (paramAnonymousMessage.what == 5377)
              {
                if (paramAnonymousMessage.arg1 != 0) {
                  continue;
                }
                try
                {
                  paramAnonymousMessage = (JSONObject)((RspData)localObject3).mData;
                  if (paramAnonymousMessage.getInt("errno") == 0)
                  {
                    ((UgcHttps.UgcHttpsResultCallBack)localObject2).onUgcInfoReportUpLoadSuccess(paramAnonymousMessage.getJSONObject("data"));
                    return;
                  }
                }
                catch (Exception paramAnonymousMessage)
                {
                  paramAnonymousMessage.printStackTrace();
                  return;
                }
              }
            }
          } while (paramAnonymousMessage.what != 5378);
          if (paramAnonymousMessage.arg1 != 0) {
            break label317;
          }
          try
          {
            paramAnonymousMessage = (JSONObject)((RspData)localObject3).mData;
            if (paramAnonymousMessage.getInt("errno") != 0) {
              break;
            }
            ((UgcHttps.UgcHttpsResultCallBack)localObject2).onUgcInfoReportUpLoadSuccess(paramAnonymousMessage.getJSONObject("data"));
            return;
          }
          catch (Exception paramAnonymousMessage)
          {
            paramAnonymousMessage.printStackTrace();
          }
        } while (localObject2 == null);
        ((UgcHttps.UgcHttpsResultCallBack)localObject2).onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(1711670287));
        return;
        ((UgcHttps.UgcHttpsResultCallBack)localObject2).onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(1711670287));
        return;
      } while (localObject2 == null);
      ((UgcHttps.UgcHttpsResultCallBack)localObject2).onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(1711670288));
    }
  };
  
  private List<NameValuePair> getRubPointAdsorbParam(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      StringBuffer localStringBuffer;
      String str;
      paramString1.printStackTrace();
    }
    catch (Exception paramString1)
    {
      try
      {
        localStringBuffer = new StringBuffer();
        str = PackageUtil.getCuid() + "";
        localArrayList.add(new BasicNameValuePair("cuid", str));
        localStringBuffer.append("cuid=" + URLEncoder.encode(str, "utf-8"));
        localArrayList.add(new BasicNameValuePair("os", "0"));
        localStringBuffer.append("os=" + URLEncoder.encode("0", "utf-8"));
        str = PackageUtil.getVersionName() + "";
        localArrayList.add(new BasicNameValuePair("sv", str));
        localStringBuffer.append("&sv=" + URLEncoder.encode(str, "utf-8"));
        str = PackageUtil.strOSVersion + "";
        localArrayList.add(new BasicNameValuePair("osv", str));
        localStringBuffer.append("&osv=" + URLEncoder.encode(str, "utf-8"));
        if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals("")))
        {
          localArrayList.add(new BasicNameValuePair("cityid", paramString1));
          localStringBuffer.append("&cityid=" + URLEncoder.encode(paramString1, "utf-8"));
        }
        paramString1 = paramInt + "";
        localArrayList.add(new BasicNameValuePair("source", paramString1));
        localStringBuffer.append("&source=" + URLEncoder.encode(paramString1, "utf-8"));
        localArrayList.add(new BasicNameValuePair("point", paramString2));
        localStringBuffer.append("&point=" + URLEncoder.encode(paramString2, "utf-8"));
        paramString1 = CloudConfigObtainManager.SortSequenceWithAscendingOder(localArrayList);
        LogUtil.e("UgcHttpsunsign str:", paramString1);
        paramString1 = JNITrajectoryControl.sInstance.getUrlParamsSign(paramString1) + "";
        LogUtil.e("UgcHttpshassign sign:", paramString1);
        localArrayList.add(new BasicNameValuePair("sign", paramString1));
        localStringBuffer.append("&sign=" + URLEncoder.encode(paramString1, "utf-8"));
        LogUtil.e("UgcHttpsparams:", localStringBuffer.toString());
        return localArrayList;
      }
      catch (Exception paramString1)
      {
        for (;;) {}
      }
      paramString1 = paramString1;
    }
    return null;
  }
  
  private List<NameValuePair> getUgcReportCountsReqParam()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      StringBuffer localStringBuffer;
      String str;
      localException1.printStackTrace();
    }
    catch (Exception localException1)
    {
      try
      {
        localStringBuffer = new StringBuffer();
        str = PackageUtil.getCuid() + "";
        localArrayList.add(new BasicNameValuePair("cuid", str));
        localStringBuffer.append("cuid=" + URLEncoder.encode(str, "utf-8"));
        str = PackageUtil.getVersionName() + "";
        localArrayList.add(new BasicNameValuePair("sv", str));
        localStringBuffer.append("&sv=" + URLEncoder.encode(str, "utf-8"));
        str = PackageUtil.strOSVersion + "";
        localArrayList.add(new BasicNameValuePair("osv", str));
        localStringBuffer.append("&osv=" + URLEncoder.encode(str, "utf-8"));
        str = CloudConfigObtainManager.SortSequenceWithAscendingOder(localArrayList);
        LogUtil.e("UgcHttpsunsign str:", str);
        str = JNITrajectoryControl.sInstance.getUrlParamsSign(str) + "";
        LogUtil.e("UgcHttpshassign sign:", str);
        localArrayList.add(new BasicNameValuePair("sign", str));
        localStringBuffer.append("&sign=" + URLEncoder.encode(str, "utf-8"));
        LogUtil.e("UgcHttpsparams:", localStringBuffer.toString());
        return localArrayList;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      localException1 = localException1;
    }
    return null;
  }
  
  public void getRubPointAdsorbInfo(final String paramString1, final String paramString2, UgcHttpsResultCallBack paramUgcHttpsResultCallBack, final int paramInt)
  {
    if (paramUgcHttpsResultCallBack == null) {
      return;
    }
    if (paramString2 == null)
    {
      paramUgcHttpsResultCallBack.onUgcInfoReportUpLoadFail("point is null");
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext()))
    {
      paramUgcHttpsResultCallBack.onUgcInfoReportUpLoadFail("no net");
      return;
    }
    this.mCallBack = paramUgcHttpsResultCallBack;
    ReqData localReqData = new ReqData("cmd.general.httprequest.func", 7, this.mHandler, 5378, 1000);
    localReqData.setObj(paramUgcHttpsResultCallBack);
    localReqData.mCookieStore = UgcHttpsUtils.getCookieStore();
    CmdGeneralHttpRequestFunc.addFunc(localReqData, new CmdGeneralHttpRequestFunc.Callback()
    {
      public List<NameValuePair> getRequestParams()
      {
        return UgcHttps.this.getRubPointAdsorbParam(paramString1, paramString2, paramInt);
      }
      
      public int getRequestType()
      {
        return 1;
      }
      
      public String getUrl()
      {
        return HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_RUBPOINT_ADSORB);
      }
      
      public boolean parseResponseJSON(JSONObject paramAnonymousJSONObject)
      {
        return true;
      }
      
      public void responseImage(byte[] paramAnonymousArrayOfByte) {}
    });
    CommandCenter.getInstance().sendRequest(localReqData);
  }
  
  public void getUgcUserInfo(UgcHttpsResultCallBack paramUgcHttpsResultCallBack)
  {
    if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
      return;
    }
    this.mCallBack = paramUgcHttpsResultCallBack;
    ReqData localReqData = new ReqData("cmd.general.httprequest.func", 7, this.mHandler, 5377, 10000);
    localReqData.setObj(paramUgcHttpsResultCallBack);
    localReqData.mCookieStore = UgcHttpsUtils.getCookieStore();
    CmdGeneralHttpRequestFunc.addFunc(localReqData, new CmdGeneralHttpRequestFunc.Callback()
    {
      public List<NameValuePair> getRequestParams()
      {
        return UgcHttps.this.getUgcReportCountsReqParam();
      }
      
      public int getRequestType()
      {
        return 1;
      }
      
      public String getUrl()
      {
        return HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_UGC_RCEVENT_COUNTS);
      }
      
      public boolean parseResponseJSON(JSONObject paramAnonymousJSONObject)
      {
        return true;
      }
      
      public void responseImage(byte[] paramAnonymousArrayOfByte) {}
    });
    CommandCenter.getInstance().sendRequest(localReqData);
  }
  
  public boolean ugcReportInfoUpLoad(UgcReportInfoUploadPackage paramUgcReportInfoUploadPackage, final UgcHttpsResultCallBack paramUgcHttpsResultCallBack)
  {
    if (paramUgcReportInfoUploadPackage == null) {
      return false;
    }
    this.mCallBack = paramUgcHttpsResultCallBack;
    Object localObject = UgcReportInfoUploadPackage.getNewFormatPackage(paramUgcReportInfoUploadPackage);
    paramUgcReportInfoUploadPackage.showLog("upload2");
    ((UgcReportInfoUploadPackage)localObject).showLog("upload3");
    paramUgcReportInfoUploadPackage = new BNHttpParams();
    paramUgcReportInfoUploadPackage.isAsync = true;
    paramUgcReportInfoUploadPackage.postFileMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (((UgcReportInfoUploadPackage)localObject).id != -1) {
        localArrayList.add(new BasicNameValuePair("id", UgcHttpsUtils.transferUploadIntToString(((UgcReportInfoUploadPackage)localObject).id)));
      }
      localArrayList.add(new BasicNameValuePair("user_point", ((UgcReportInfoUploadPackage)localObject).userPoint));
      localArrayList.add(new BasicNameValuePair("point", ((UgcReportInfoUploadPackage)localObject).point));
      localArrayList.add(new BasicNameValuePair("business_trigger", UgcHttpsUtils.transferUploadIntToString(((UgcReportInfoUploadPackage)localObject).businessTrigger)));
      if (!TextUtils.isEmpty(UgcHttpsUtils.transferUploadIntToString(((UgcReportInfoUploadPackage)localObject).parentType))) {
        localArrayList.add(new BasicNameValuePair("parent_type", UgcHttpsUtils.transferUploadIntToString(((UgcReportInfoUploadPackage)localObject).parentType)));
      }
      if (!TextUtils.isEmpty(UgcHttpsUtils.transferUploadIntToString(((UgcReportInfoUploadPackage)localObject).subType))) {
        localArrayList.add(new BasicNameValuePair("sub_type", UgcHttpsUtils.transferUploadIntToString(((UgcReportInfoUploadPackage)localObject).subType)));
      }
      localArrayList.add(new BasicNameValuePair("guid", ((UgcReportInfoUploadPackage)localObject).guid));
      localArrayList.add(new BasicNameValuePair("content", ((UgcReportInfoUploadPackage)localObject).content));
      localArrayList.add(new BasicNameValuePair("photo_point", ((UgcReportInfoUploadPackage)localObject).photoPoint));
      localArrayList.add(new BasicNameValuePair("road_name", ((UgcReportInfoUploadPackage)localObject).roadName));
      if (!TextUtils.isEmpty(UgcHttpsUtils.transferUploadIntToString(((UgcReportInfoUploadPackage)localObject).isChange))) {
        localArrayList.add(new BasicNameValuePair("is_change", UgcHttpsUtils.transferUploadIntToString(((UgcReportInfoUploadPackage)localObject).isChange)));
      }
      localArrayList.add(new BasicNameValuePair("contact", ((UgcReportInfoUploadPackage)localObject).contact));
      localArrayList.add(new BasicNameValuePair("os", UgcHttpsUtils.transferUploadIntToString(((UgcReportInfoUploadPackage)localObject).os)));
      localArrayList.add(new BasicNameValuePair("osv", ((UgcReportInfoUploadPackage)localObject).osv));
      localArrayList.add(new BasicNameValuePair("sv", ((UgcReportInfoUploadPackage)localObject).sv));
      localArrayList.add(new BasicNameValuePair("cuid", ((UgcReportInfoUploadPackage)localObject).cuid));
      localArrayList.add(new BasicNameValuePair("name", ((UgcReportInfoUploadPackage)localObject).name));
      localArrayList.add(new BasicNameValuePair("session_id", ((UgcReportInfoUploadPackage)localObject).sessionId));
      localArrayList.add(new BasicNameValuePair("mrsl", ((UgcReportInfoUploadPackage)localObject).mrsl));
      localArrayList.add(new BasicNameValuePair("from_point", ((UgcReportInfoUploadPackage)localObject).fromPoint));
      localArrayList.add(new BasicNameValuePair("from_name", ((UgcReportInfoUploadPackage)localObject).fromName));
      localArrayList.add(new BasicNameValuePair("from_uid", ((UgcReportInfoUploadPackage)localObject).fromUid));
      localArrayList.add(new BasicNameValuePair("to_point", ((UgcReportInfoUploadPackage)localObject).toPoint));
      localArrayList.add(new BasicNameValuePair("to_name", ((UgcReportInfoUploadPackage)localObject).toName));
      localArrayList.add(new BasicNameValuePair("to_uid", ((UgcReportInfoUploadPackage)localObject).toUid));
      if (!TextUtils.isEmpty(UgcHttpsUtils.transferUploadIntToString(((UgcReportInfoUploadPackage)localObject).cityId))) {
        localArrayList.add(new BasicNameValuePair("cityid", UgcHttpsUtils.transferUploadIntToString(((UgcReportInfoUploadPackage)localObject).cityId)));
      }
      localArrayList.add(new BasicNameValuePair("city_name", ((UgcReportInfoUploadPackage)localObject).cityName));
      if (!TextUtils.isEmpty(UgcHttpsUtils.transferUploadIntToString(((UgcReportInfoUploadPackage)localObject).laneType))) {
        localArrayList.add(new BasicNameValuePair("lane_type", UgcHttpsUtils.transferUploadIntToString(((UgcReportInfoUploadPackage)localObject).laneType)));
      }
      if (!TextUtils.isEmpty(UgcHttpsUtils.transferUploadIntToString(((UgcReportInfoUploadPackage)localObject).detailType))) {
        localArrayList.add(new BasicNameValuePair("detail_type", UgcHttpsUtils.transferUploadIntToString(((UgcReportInfoUploadPackage)localObject).detailType)));
      }
      if (!TextUtils.isEmpty(UgcHttpsUtils.transferUploadIntToString(((UgcReportInfoUploadPackage)localObject).speedLimit))) {
        localArrayList.add(new BasicNameValuePair("speed_limit", UgcHttpsUtils.transferUploadIntToString(((UgcReportInfoUploadPackage)localObject).speedLimit)));
      }
      localArrayList.add(new BasicNameValuePair("start_point", ((UgcReportInfoUploadPackage)localObject).startPoint));
      localArrayList.add(new BasicNameValuePair("start_name", ((UgcReportInfoUploadPackage)localObject).startName));
      localArrayList.add(new BasicNameValuePair("end_point", ((UgcReportInfoUploadPackage)localObject).endPoint));
      localArrayList.add(new BasicNameValuePair("end_name", ((UgcReportInfoUploadPackage)localObject).endName));
      if (!TextUtils.isEmpty(UgcHttpsUtils.transferUploadIntToString(((UgcReportInfoUploadPackage)localObject).mark))) {
        localArrayList.add(new BasicNameValuePair("mark", UgcHttpsUtils.transferUploadIntToString(((UgcReportInfoUploadPackage)localObject).mark)));
      }
      localArrayList.add(new BasicNameValuePair("supply", UgcHttpsUtils.transferUploadIntToString(((UgcReportInfoUploadPackage)localObject).supply)));
      localArrayList.add(new BasicNameValuePair("linkid", ((UgcReportInfoUploadPackage)localObject).linkid));
      if ((((UgcReportInfoUploadPackage)localObject).screenshotPicPath != null) && (!((UgcReportInfoUploadPackage)localObject).screenshotPicPath.trim().equals(""))) {
        paramUgcReportInfoUploadPackage.postFileMap.put("screenshot_pic", new File(((UgcReportInfoUploadPackage)localObject).screenshotPicPath));
      }
      if ((((UgcReportInfoUploadPackage)localObject).photoPicPath != null) && (!((UgcReportInfoUploadPackage)localObject).photoPicPath.trim().equals(""))) {
        paramUgcReportInfoUploadPackage.postFileMap.put("pic", new File(((UgcReportInfoUploadPackage)localObject).photoPicPath));
      }
      if ((((UgcReportInfoUploadPackage)localObject).voicePath != null) && (!((UgcReportInfoUploadPackage)localObject).voicePath.trim().equals(""))) {
        paramUgcReportInfoUploadPackage.postFileMap.put("voice", new File(((UgcReportInfoUploadPackage)localObject).voicePath));
      }
      localObject = CloudConfigObtainManager.SortSequenceWithAscendingOder(localArrayList);
      localArrayList.add(new BasicNameValuePair("sign", JNITrajectoryControl.sInstance.getUrlParamsSign((String)localObject) + ""));
      localObject = BNHttpCenterHelper.formatParams(localArrayList);
      BNHttpCenter.getInstance().post(HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_UGC_OPER_INFO_REPORT), (HashMap)localObject, new BNHttpTextResponseHandler()
      {
        public void onFailure(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          LogUtil.e("UgcHttps", "onFailure() statusCode=" + paramAnonymousInt + ", responseString=" + paramAnonymousString);
          if (paramUgcHttpsResultCallBack != null) {
            paramUgcHttpsResultCallBack.onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(1711670288));
          }
        }
        
        public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          LogUtil.e("UgcHttps", "onSuccess() statusCode=" + paramAnonymousInt + ", responseString=" + paramAnonymousString);
          try
          {
            paramAnonymousString = new JSONObject(paramAnonymousString);
            if (paramAnonymousString.getInt("errno") == 0)
            {
              paramAnonymousString = paramAnonymousString.getJSONObject("data");
              if (paramUgcHttpsResultCallBack != null) {
                paramUgcHttpsResultCallBack.onUgcInfoReportUpLoadSuccess(paramAnonymousString);
              }
            }
            else if (paramUgcHttpsResultCallBack != null)
            {
              paramUgcHttpsResultCallBack.onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(1711670287));
              return;
            }
          }
          catch (Exception paramAnonymousString)
          {
            paramAnonymousString.printStackTrace();
            if (paramUgcHttpsResultCallBack != null) {
              paramUgcHttpsResultCallBack.onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(1711670287));
            }
          }
        }
      }, paramUgcReportInfoUploadPackage);
      return true;
    }
    catch (Exception paramUgcReportInfoUploadPackage)
    {
      paramUgcReportInfoUploadPackage.printStackTrace();
    }
    return true;
  }
  
  public static abstract interface UgcHttpsResultCallBack
  {
    public abstract void onUgcInfoReportUpLoadFail(String paramString);
    
    public abstract void onUgcInfoReportUpLoadSuccess(JSONObject paramJSONObject);
  }
  
  private static abstract interface UgcPostHttpConstans
  {
    public static final String UGC_POST_HTTP_PARAM_BDUSS = "bduss";
    public static final String UGC_POST_HTTP_PARAM_BUSINESS_TRIGGER = "business_trigger";
    public static final String UGC_POST_HTTP_PARAM_CITYID = "cityid";
    public static final String UGC_POST_HTTP_PARAM_CITYNAME = "city_name";
    public static final String UGC_POST_HTTP_PARAM_CONTENT = "content";
    public static final String UGC_POST_HTTP_PARAM_CONTRACT = "contact";
    public static final String UGC_POST_HTTP_PARAM_CUID = "cuid";
    public static final String UGC_POST_HTTP_PARAM_DETAIL_TYPE = "detail_type";
    public static final String UGC_POST_HTTP_PARAM_END_NAME = "end_name";
    public static final String UGC_POST_HTTP_PARAM_END_POINT = "end_point";
    public static final String UGC_POST_HTTP_PARAM_FROM_NAME = "from_name";
    public static final String UGC_POST_HTTP_PARAM_FROM_POINT = "from_point";
    public static final String UGC_POST_HTTP_PARAM_FROM_UID = "from_uid";
    public static final String UGC_POST_HTTP_PARAM_GUID = "guid";
    public static final String UGC_POST_HTTP_PARAM_ID = "id";
    public static final String UGC_POST_HTTP_PARAM_IS_CHANGE = "is_change";
    public static final String UGC_POST_HTTP_PARAM_LANE_TYPE = "lane_type";
    public static final String UGC_POST_HTTP_PARAM_LINKID = "linkid";
    public static final String UGC_POST_HTTP_PARAM_MARK = "mark";
    public static final String UGC_POST_HTTP_PARAM_MRSL = "mrsl";
    public static final String UGC_POST_HTTP_PARAM_NAME = "name";
    public static final String UGC_POST_HTTP_PARAM_OS = "os";
    public static final String UGC_POST_HTTP_PARAM_OSV = "osv";
    public static final String UGC_POST_HTTP_PARAM_PARENT_TYPE = "parent_type";
    public static final String UGC_POST_HTTP_PARAM_PHOTO_POINT = "photo_point";
    public static final String UGC_POST_HTTP_PARAM_PIC = "pic";
    public static final String UGC_POST_HTTP_PARAM_POINT = "point";
    public static final String UGC_POST_HTTP_PARAM_POSITION_TYPE = "position_type";
    public static final String UGC_POST_HTTP_PARAM_ROAD_NAME = "road_name";
    public static final String UGC_POST_HTTP_PARAM_SCREENSHOT_PIC = "screenshot_pic";
    public static final String UGC_POST_HTTP_PARAM_SESSION_ID = "session_id";
    public static final String UGC_POST_HTTP_PARAM_SIGN = "sign";
    public static final String UGC_POST_HTTP_PARAM_SPEED_LIMIT = "speed_limit";
    public static final String UGC_POST_HTTP_PARAM_START_NAME = "start_name";
    public static final String UGC_POST_HTTP_PARAM_START_POINT = "start_point";
    public static final String UGC_POST_HTTP_PARAM_SUB_TYPE = "sub_type";
    public static final String UGC_POST_HTTP_PARAM_SUPPLY = "supply";
    public static final String UGC_POST_HTTP_PARAM_SV = "sv";
    public static final String UGC_POST_HTTP_PARAM_TO_NAME = "to_name";
    public static final String UGC_POST_HTTP_PARAM_TO_POINT = "to_point";
    public static final String UGC_POST_HTTP_PARAM_TO_UID = "to_uid";
    public static final String UGC_POST_HTTP_PARAM_USER_POINT = "user_point";
    public static final String UGC_POST_HTTP_PARAM_VOICE = "voice";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/https/UgcHttps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */