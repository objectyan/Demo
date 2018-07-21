package com.baidu.navisdk.module.cloudconfig;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.debug.BNEyeSpyPaperController;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc.Callback;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.module.car.BNYellowBannerTipsModel;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataRepository;
import com.baidu.navisdk.module.ugc.utils.UgcMapsViewConstructor;
import com.baidu.navisdk.ui.routeguide.model.RGMultiRouteModel;
import com.baidu.navisdk.ui.ugc.model.UgcOperationalActModel;
import com.baidu.navisdk.ui.ugc.model.UgcOperationalActModel.UgcBaseDataModel;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.ui.voice.controller.VoiceHelper;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import com.baidu.navisdk.vi.VDeviceAPI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudConfigObtainManager
{
  private static final int ERRNO_RET_NOUPDATE = 304;
  private static final int ERRNO_RET_UPDATE = 0;
  private static final int MSG_CLOUD_CONFIG_DATA_REQUEST_RET = 1;
  private static final int MSG_CLOUD_CONFIG_DATA_UPDATE_RET = 2;
  public static final String TAG = CloudConfigObtainManager.class.getName();
  private DataCacheManager mDataCacheManager;
  private Handler mUgcHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage == null) {}
      do
      {
        return;
        if (paramAnonymousMessage.what == 1)
        {
          if ((paramAnonymousMessage.arg1 == 0) && (CloudlConfigDataModel.getInstance().isWebDataValid) && (UgcOperationalActModel.getInstance().isWebDataValid))
          {
            CloudConfigObtainManager.this.informModulesAftUpdate();
            return;
          }
          CloudConfigObtainManager.this.getUgcDataFromFile();
          CloudConfigObtainManager.this.informModulesAftUpdate();
          return;
        }
      } while (paramAnonymousMessage.what != 2);
      CloudConfigObtainManager.this.informModulesAftUpdate();
    }
  };
  
  public static String SortSequenceWithAscendingOder(List<NameValuePair> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    String[] arrayOfString = new String[paramList.size()];
    int i = 0;
    for (;;)
    {
      if (i < paramList.size()) {
        try
        {
          str = URLEncoder.encode(((NameValuePair)paramList.get(i)).getName(), "utf-8");
          str = str + "=";
        }
        catch (Exception paramList)
        {
          try
          {
            String str = str + URLEncoder.encode(((NameValuePair)paramList.get(i)).getValue(), "utf-8");
            arrayOfString[i] = str;
            i += 1;
          }
          catch (Exception paramList)
          {
            paramList.printStackTrace();
            return null;
          }
          paramList = paramList;
          paramList.printStackTrace();
          return null;
        }
      }
    }
    Arrays.sort(arrayOfString);
    paramList = new StringBuffer();
    int j = arrayOfString.length;
    i = 0;
    while (i < j)
    {
      paramList.append(arrayOfString[i]);
      if (i != j - 1) {
        paramList.append("&");
      }
      i += 1;
    }
    LogUtil.e(TAG + "SortSequenceWithAscendingOder:", paramList.toString());
    return paramList.toString();
  }
  
  private int[] converStringToIntArr(String paramString)
  {
    Object localObject = paramString;
    if (paramString.startsWith("["))
    {
      localObject = paramString;
      if (paramString.endsWith("]")) {
        localObject = paramString.substring(1, paramString.length() - 1);
      }
    }
    String[] arrayOfString = ((String)localObject).split(",");
    int j = arrayOfString.length;
    if (j >= 1)
    {
      localObject = new int[j];
      int i = 0;
      for (;;)
      {
        paramString = (String)localObject;
        if (i < j) {
          try
          {
            localObject[i] = Integer.parseInt(arrayOfString[i]);
            i += 1;
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            paramString = null;
          }
        }
      }
      return paramString;
    }
    return null;
  }
  
  private int getCurrentCityId()
  {
    int i = -1;
    DistrictInfo localDistrictInfo = GeoLocateModel.getInstance().getCurrentDistrict();
    if (localDistrictInfo != null) {
      i = localDistrictInfo.mId;
    }
    return i;
  }
  
  private List<NameValuePair> getServiceReqParam()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      StringBuffer localStringBuffer;
      Object localObject;
      String str;
      localException1.printStackTrace();
    }
    catch (Exception localException1)
    {
      try
      {
        localStringBuffer = new StringBuffer();
        localObject = PackageUtil.getCuid() + "";
        localArrayList.add(new BasicNameValuePair("cuid", (String)localObject));
        localStringBuffer.append("cuid=" + URLEncoder.encode((String)localObject, "utf-8"));
        localArrayList.add(new BasicNameValuePair("sid", "1"));
        localStringBuffer.append("&sid=" + URLEncoder.encode("1", "utf-8"));
        localArrayList.add(new BasicNameValuePair("os", "0"));
        localStringBuffer.append("&os=" + URLEncoder.encode("0", "utf-8"));
        localArrayList.add(new BasicNameValuePair("sv", "10.1.0"));
        localStringBuffer.append("&sv=" + URLEncoder.encode("10.1.0", "utf-8"));
        localObject = PackageUtil.strOSVersion + "";
        localArrayList.add(new BasicNameValuePair("osv", (String)localObject));
        localStringBuffer.append("&osv=" + URLEncoder.encode((String)localObject, "utf-8"));
        localObject = getCurrentCityId() + "";
        localArrayList.add(new BasicNameValuePair("cityCode", (String)localObject));
        localStringBuffer.append("&cityCode=" + URLEncoder.encode((String)localObject, "utf-8"));
        localArrayList.add(new BasicNameValuePair("mb", VDeviceAPI.getPhoneType()));
        localStringBuffer.append("&mb=" + URLEncoder.encode(VDeviceAPI.getPhoneType()));
        str = VoiceHelper.getInstance().getCurrentUsedTTSId();
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = "0";
        }
        localArrayList.add(new BasicNameValuePair("tts_id", (String)localObject));
        localStringBuffer.append("&tts_id=" + URLEncoder.encode((String)localObject, "utf-8"));
        if (this.mDataCacheManager == null) {
          this.mDataCacheManager = new DataCacheManager();
        }
        localObject = this.mDataCacheManager.getEtag() + "";
        localArrayList.add(new BasicNameValuePair("etag", (String)localObject));
        localStringBuffer.append("&etag=" + URLEncoder.encode((String)localObject, "utf-8"));
        localObject = SortSequenceWithAscendingOder(localArrayList);
        LogUtil.e(TAG + "unsign str:", (String)localObject);
        localObject = JNITrajectoryControl.sInstance.getUrlParamsSign(SortSequenceWithAscendingOder(localArrayList)) + "";
        LogUtil.e(TAG + "hassign sign:", (String)localObject);
        localArrayList.add(new BasicNameValuePair("sign", (String)localObject));
        localStringBuffer.append("&sign=" + URLEncoder.encode((String)localObject, "utf-8"));
        LogUtil.e(TAG + "params:", localStringBuffer.toString());
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
  
  private UgcOperationalActModel.UgcBaseDataModel[] getUgcBaseDataModelFromSub(JSONArray paramJSONArray)
  {
    Object localObject;
    if (paramJSONArray == null)
    {
      localObject = null;
      return (UgcOperationalActModel.UgcBaseDataModel[])localObject;
    }
    int j = paramJSONArray.length();
    if (j <= 0) {
      return null;
    }
    UgcOperationalActModel.UgcBaseDataModel[] arrayOfUgcBaseDataModel = new UgcOperationalActModel.UgcBaseDataModel[j];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfUgcBaseDataModel;
      if (i >= j) {
        break;
      }
      try
      {
        localObject = paramJSONArray.getJSONObject(i);
        arrayOfUgcBaseDataModel[i] = new UgcOperationalActModel.UgcBaseDataModel(((JSONObject)localObject).getString("title"), ((JSONObject)localObject).getInt("type"), ((JSONObject)localObject).getString("icon"));
        i += 1;
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
      }
    }
    return null;
  }
  
  private boolean getUgcDataFromFile()
  {
    if (this.mDataCacheManager == null) {
      this.mDataCacheManager = new DataCacheManager();
    }
    try
    {
      JSONObject localJSONObject2 = this.mDataCacheManager.getJSonObjectFromFile();
      JSONObject localJSONObject1 = null;
      if (localJSONObject2 != null) {
        localJSONObject1 = localJSONObject2.getJSONObject("data");
      }
      if ((localJSONObject1 != null) && (parseUgcDataJSON(localJSONObject1)))
      {
        UgcOperationalActModel.getInstance().isWebDataValid = true;
        CloudlConfigDataModel.getInstance().isWebDataValid = true;
        return true;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  private void informModulesAftUpdate()
  {
    RGMultiRouteModel.getInstance().updateMultiRouteParams();
    BNRoutePlaner.getInstance().updateFuncConfigParams();
    UgcMapsViewConstructor.updateUgcReportBtn();
    BNVoice.getInstance().checkCombineVoice();
    UgcDataRepository.getInstance().update();
    BNYellowBannerTipsModel.getInstance().update();
    BNEyeSpyPaperController.getInstance().cloudConfigInitEnd();
    LogUtil.e(TAG + "mCommonConfig.engineStr:", CloudlConfigDataModel.getInstance().mCommonConfig.engineStr);
    if (!TextUtils.isEmpty(CloudlConfigDataModel.getInstance().mCommonConfig.engineStr)) {
      JNIGuidanceControl.getInstance().setCloudControlCommand(CloudlConfigDataModel.getInstance().mCommonConfig.engineStr);
    }
  }
  
  private boolean parseMapOrNaviJSON(JSONArray paramJSONArray, UgcOperationalActModel paramUgcOperationalActModel, boolean paramBoolean)
  {
    if (paramJSONArray == null) {
      return false;
    }
    if (paramUgcOperationalActModel == null) {
      return false;
    }
    int k = paramJSONArray.length();
    int i = 0;
    UgcOperationalActModel.UgcBaseDataModel localUgcBaseDataModel = null;
    for (;;)
    {
      if (i < k) {}
      try
      {
        Object localObject = paramJSONArray.getJSONObject(i);
        localUgcBaseDataModel = new UgcOperationalActModel.UgcBaseDataModel(((JSONObject)localObject).getString("title"), ((JSONObject)localObject).getInt("type"), ((JSONObject)localObject).getString("icon"));
        try
        {
          localObject = ((JSONObject)localObject).getJSONArray("sub");
          if (localObject != null)
          {
            localObject = getUgcBaseDataModelFromSub((JSONArray)localObject);
            if ((localObject != null) && (localObject.length > 0))
            {
              int m = localObject.length;
              int j = 0;
              while (j < m)
              {
                localUgcBaseDataModel.addSubUgcData(localObject[j]);
                j += 1;
              }
            }
          }
          paramJSONArray.printStackTrace();
        }
        catch (Exception localException)
        {
          if (paramBoolean) {}
          try
          {
            paramUgcOperationalActModel.addMapUgcBaseDataModel(localUgcBaseDataModel);
          }
          catch (Exception paramJSONArray) {}
          paramUgcOperationalActModel.addNaviUgcBaseDataModel(localUgcBaseDataModel);
        }
      }
      catch (Exception paramJSONArray)
      {
        for (;;) {}
        i += 1;
      }
      return false;
      return true;
    }
  }
  
  /* Error */
  private boolean parseUgcDataJSON(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: invokestatic 357	com/baidu/navisdk/ui/ugc/model/UgcOperationalActModel:getInstance	()Lcom/baidu/navisdk/ui/ugc/model/UgcOperationalActModel;
    //   9: astore 7
    //   11: aload 7
    //   13: invokevirtual 461	com/baidu/navisdk/ui/ugc/model/UgcOperationalActModel:clearBaseDataModel	()V
    //   16: aconst_null
    //   17: astore 5
    //   19: aload_1
    //   20: ldc_w 463
    //   23: invokevirtual 349	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   26: astore 6
    //   28: aload 6
    //   30: astore 5
    //   32: aload 5
    //   34: ifnonnull +1231 -> 1265
    //   37: aload 7
    //   39: aconst_null
    //   40: invokevirtual 467	com/baidu/navisdk/ui/ugc/model/UgcOperationalActModel:setActBaseDataModel	(Lcom/baidu/navisdk/ui/ugc/model/UgcOperationalActModel$actBaseDataModel;)V
    //   43: aload_1
    //   44: ldc_w 469
    //   47: invokevirtual 349	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   50: astore 5
    //   52: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   55: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   58: aload 5
    //   60: ldc_w 471
    //   63: invokevirtual 334	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   66: putfield 474	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:colladaFlag	I
    //   69: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   72: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   75: aload 5
    //   77: ldc_w 476
    //   80: invokevirtual 334	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   83: putfield 479	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:guidecaseFlag	I
    //   86: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   89: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   92: aload 5
    //   94: invokevirtual 480	org/json/JSONObject:toString	()Ljava/lang/String;
    //   97: putfield 429	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:engineStr	Ljava/lang/String;
    //   100: aload_1
    //   101: ldc_w 482
    //   104: invokevirtual 349	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   107: astore 5
    //   109: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   112: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   115: astore 6
    //   117: aload 5
    //   119: ldc_w 484
    //   122: invokevirtual 334	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   125: iconst_1
    //   126: if_icmpne +1217 -> 1343
    //   129: iconst_1
    //   130: istore 4
    //   132: aload 6
    //   134: iload 4
    //   136: putfield 487	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:colladaComponentDownload	Z
    //   139: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   142: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   145: astore 6
    //   147: aload 5
    //   149: ldc_w 489
    //   152: invokevirtual 334	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   155: iconst_1
    //   156: if_icmpne +1193 -> 1349
    //   159: iconst_1
    //   160: istore 4
    //   162: aload 6
    //   164: iload 4
    //   166: putfield 492	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:colladaComponentInit	Z
    //   169: invokestatic 497	com/baidu/navisdk/BNaviModuleManager:initCollada	()V
    //   172: invokestatic 409	com/baidu/navisdk/module/car/BNYellowBannerTipsModel:getInstance	()Lcom/baidu/navisdk/module/car/BNYellowBannerTipsModel;
    //   175: aload_1
    //   176: invokevirtual 501	com/baidu/navisdk/module/car/BNYellowBannerTipsModel:parseJson	(Lorg/json/JSONObject;)V
    //   179: aload_1
    //   180: ldc_w 503
    //   183: invokevirtual 349	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   186: astore 5
    //   188: aload 5
    //   190: ldc_w 505
    //   193: invokevirtual 508	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   196: ifeq +33 -> 229
    //   199: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   202: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   205: astore 6
    //   207: aload 5
    //   209: ldc_w 505
    //   212: invokevirtual 334	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   215: iconst_1
    //   216: if_icmpne +1139 -> 1355
    //   219: iconst_1
    //   220: istore 4
    //   222: aload 6
    //   224: iload 4
    //   226: putfield 511	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:safetyShow	Z
    //   229: aload 5
    //   231: ldc_w 513
    //   234: invokevirtual 508	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   237: ifeq +33 -> 270
    //   240: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   243: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   246: astore 6
    //   248: aload 5
    //   250: ldc_w 513
    //   253: invokevirtual 334	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   256: iconst_1
    //   257: if_icmpne +1104 -> 1361
    //   260: iconst_1
    //   261: istore 4
    //   263: aload 6
    //   265: iload 4
    //   267: putfield 516	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:safetyNavingShow	Z
    //   270: aload 5
    //   272: ldc_w 324
    //   275: invokevirtual 508	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   278: ifeq +32 -> 310
    //   281: aload 5
    //   283: ldc_w 324
    //   286: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   289: astore 6
    //   291: aload 6
    //   293: invokestatic 520	com/baidu/navisdk/util/common/StringUtils:isEmpty	(Ljava/lang/String;)Z
    //   296: ifne +14 -> 310
    //   299: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   302: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   305: aload 6
    //   307: putfield 523	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:safetyText	Ljava/lang/String;
    //   310: aload 5
    //   312: ldc_w 525
    //   315: invokevirtual 508	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   318: ifeq +20 -> 338
    //   321: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   324: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   327: aload 5
    //   329: ldc_w 525
    //   332: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   335: putfield 528	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:safetyIpoIcon	Ljava/lang/String;
    //   338: aload 5
    //   340: ldc_w 530
    //   343: invokevirtual 508	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   346: ifeq +20 -> 366
    //   349: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   352: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   355: aload 5
    //   357: ldc_w 530
    //   360: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   363: putfield 533	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:safetyNavIcon	Ljava/lang/String;
    //   366: aload 5
    //   368: ldc_w 535
    //   371: invokevirtual 508	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   374: ifeq +20 -> 394
    //   377: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   380: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   383: aload 5
    //   385: ldc_w 535
    //   388: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   391: putfield 538	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:safetyNavNightIcon	Ljava/lang/String;
    //   394: aload 5
    //   396: ldc_w 540
    //   399: invokevirtual 508	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   402: ifeq +20 -> 422
    //   405: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   408: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   411: aload 5
    //   413: ldc_w 540
    //   416: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   419: putfield 543	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:safetyNavingIcon	Ljava/lang/String;
    //   422: ldc_w 545
    //   425: new 77	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   432: ldc_w 547
    //   435: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload 5
    //   440: invokevirtual 480	org/json/JSONObject:toString	()Ljava/lang/String;
    //   443: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokestatic 116	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   452: aload_1
    //   453: ldc_w 549
    //   456: invokevirtual 349	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   459: astore 5
    //   461: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   464: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   467: astore 6
    //   469: aload 5
    //   471: ldc_w 549
    //   474: invokevirtual 334	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   477: iconst_1
    //   478: if_icmpne +889 -> 1367
    //   481: iconst_1
    //   482: istore 4
    //   484: aload 6
    //   486: iload 4
    //   488: putfield 552	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:coreLogRecord	Z
    //   491: aload_1
    //   492: ldc_w 554
    //   495: invokevirtual 349	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   498: astore 5
    //   500: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   503: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   506: astore 6
    //   508: aload 5
    //   510: ldc_w 556
    //   513: invokevirtual 334	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   516: iconst_1
    //   517: if_icmpne +856 -> 1373
    //   520: iconst_1
    //   521: istore 4
    //   523: aload 6
    //   525: iload 4
    //   527: putfield 559	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:httpsControl	Z
    //   530: invokestatic 564	com/baidu/navisdk/util/http/HttpURLManager:getInstance	()Lcom/baidu/navisdk/util/http/HttpURLManager;
    //   533: invokevirtual 567	com/baidu/navisdk/util/http/HttpURLManager:initUrlData	()V
    //   536: invokestatic 570	com/baidu/navisdk/BNaviModuleManager:initUrl	()V
    //   539: aload_1
    //   540: ldc_w 572
    //   543: invokevirtual 349	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   546: astore 5
    //   548: aload_1
    //   549: ldc_w 574
    //   552: invokevirtual 349	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   555: astore 6
    //   557: aload 7
    //   559: new 576	com/baidu/navisdk/ui/ugc/model/UgcOperationalActModel$CommonBaseDataModel
    //   562: dup
    //   563: aload 5
    //   565: ldc_w 324
    //   568: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   571: aload 5
    //   573: ldc_w 336
    //   576: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   579: aload 6
    //   581: ldc_w 324
    //   584: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   587: aload 6
    //   589: ldc_w 336
    //   592: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   595: invokespecial 579	com/baidu/navisdk/ui/ugc/model/UgcOperationalActModel$CommonBaseDataModel:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   598: invokevirtual 583	com/baidu/navisdk/ui/ugc/model/UgcOperationalActModel:setCommonBaseDataModel	(Lcom/baidu/navisdk/ui/ugc/model/UgcOperationalActModel$CommonBaseDataModel;)V
    //   601: aload_1
    //   602: ldc_w 585
    //   605: invokevirtual 349	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   608: astore 5
    //   610: aload 7
    //   612: invokevirtual 589	com/baidu/navisdk/ui/ugc/model/UgcOperationalActModel:getCommonBaseDataModel	()Lcom/baidu/navisdk/ui/ugc/model/UgcOperationalActModel$CommonBaseDataModel;
    //   615: aload 5
    //   617: ldc_w 591
    //   620: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   623: aload 5
    //   625: ldc_w 593
    //   628: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   631: aload 5
    //   633: ldc_w 595
    //   636: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   639: invokevirtual 599	com/baidu/navisdk/ui/ugc/model/UgcOperationalActModel$CommonBaseDataModel:setFeedbackStyle	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   642: invokestatic 401	com/baidu/navisdk/module/ugc/data/datarepository/UgcDataRepository:getInstance	()Lcom/baidu/navisdk/module/ugc/data/datarepository/UgcDataRepository;
    //   645: aload_1
    //   646: invokevirtual 602	com/baidu/navisdk/module/ugc/data/datarepository/UgcDataRepository:parseCloudJson	(Lorg/json/JSONObject;)Z
    //   649: istore 4
    //   651: iload 4
    //   653: ifne +3 -> 656
    //   656: aload_0
    //   657: aload_1
    //   658: ldc_w 604
    //   661: invokevirtual 446	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   664: aload 7
    //   666: iconst_1
    //   667: invokespecial 606	com/baidu/navisdk/module/cloudconfig/CloudConfigObtainManager:parseMapOrNaviJSON	(Lorg/json/JSONArray;Lcom/baidu/navisdk/ui/ugc/model/UgcOperationalActModel;Z)Z
    //   670: istore 4
    //   672: iload 4
    //   674: ifne +3 -> 677
    //   677: aload_0
    //   678: aload_1
    //   679: ldc_w 608
    //   682: invokevirtual 446	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   685: aload 7
    //   687: iconst_0
    //   688: invokespecial 606	com/baidu/navisdk/module/cloudconfig/CloudConfigObtainManager:parseMapOrNaviJSON	(Lorg/json/JSONArray;Lcom/baidu/navisdk/ui/ugc/model/UgcOperationalActModel;Z)Z
    //   691: istore 4
    //   693: iload 4
    //   695: ifne +3 -> 698
    //   698: aload_1
    //   699: ldc_w 610
    //   702: invokevirtual 349	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   705: astore 5
    //   707: aload 5
    //   709: ldc_w 612
    //   712: invokevirtual 334	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   715: ifne +664 -> 1379
    //   718: iconst_0
    //   719: istore 4
    //   721: aload_0
    //   722: aload 5
    //   724: ldc_w 614
    //   727: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   730: invokespecial 616	com/baidu/navisdk/module/cloudconfig/CloudConfigObtainManager:converStringToIntArr	(Ljava/lang/String;)[I
    //   733: astore 6
    //   735: aload 5
    //   737: ldc_w 618
    //   740: bipush 20
    //   742: invokevirtual 622	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   745: istore_2
    //   746: aload 5
    //   748: ldc_w 624
    //   751: iconst_m1
    //   752: invokevirtual 622	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   755: istore_3
    //   756: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   759: new 626	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$MultiRoadConfig
    //   762: dup
    //   763: iload 4
    //   765: aload 6
    //   767: iload_2
    //   768: iload_3
    //   769: invokespecial 629	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$MultiRoadConfig:<init>	(Z[III)V
    //   772: putfield 633	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mMultiRoadConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$MultiRoadConfig;
    //   775: aload_1
    //   776: ldc_w 635
    //   779: invokevirtual 349	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   782: astore 5
    //   784: aload 5
    //   786: ldc_w 612
    //   789: iconst_0
    //   790: invokevirtual 622	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   793: istore_2
    //   794: aload 5
    //   796: ldc_w 637
    //   799: iconst_1
    //   800: invokevirtual 622	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   803: istore_3
    //   804: aload 5
    //   806: ldc_w 639
    //   809: aconst_null
    //   810: invokevirtual 642	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   813: astore 5
    //   815: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   818: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   821: astore 6
    //   823: iload_2
    //   824: iconst_1
    //   825: if_icmpne +560 -> 1385
    //   828: iconst_1
    //   829: istore 4
    //   831: aload 6
    //   833: iload 4
    //   835: putfield 645	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:isXmlyOpen	Z
    //   838: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   841: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   844: astore 6
    //   846: iload_3
    //   847: iconst_1
    //   848: if_icmpne +543 -> 1391
    //   851: iconst_1
    //   852: istore 4
    //   854: aload 6
    //   856: iload 4
    //   858: putfield 648	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:isWifiDownload	Z
    //   861: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   864: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   867: aload 5
    //   869: putfield 651	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:switchTips	Ljava/lang/String;
    //   872: aload_1
    //   873: ldc_w 653
    //   876: invokevirtual 349	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   879: ldc_w 655
    //   882: iconst_0
    //   883: invokevirtual 622	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   886: istore_2
    //   887: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   890: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   893: astore 5
    //   895: iload_2
    //   896: iconst_1
    //   897: if_icmpne +500 -> 1397
    //   900: iconst_1
    //   901: istore 4
    //   903: aload 5
    //   905: iload 4
    //   907: putfield 658	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:isCarNaviRecording	Z
    //   910: getstatic 297	com/baidu/navisdk/jni/nativeif/JNITrajectoryControl:sInstance	Lcom/baidu/navisdk/jni/nativeif/JNITrajectoryControl;
    //   913: iconst_1
    //   914: putfield 661	com/baidu/navisdk/jni/nativeif/JNITrajectoryControl:isCarRecodingFromCLoud	Z
    //   917: ldc_w 663
    //   920: new 77	java/lang/StringBuilder
    //   923: dup
    //   924: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   927: ldc_w 665
    //   930: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: iload_2
    //   934: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   937: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   940: invokestatic 116	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   943: aload_1
    //   944: ldc_w 667
    //   947: invokevirtual 349	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   950: ldc_w 669
    //   953: aconst_null
    //   954: invokevirtual 642	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   957: astore 5
    //   959: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   962: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   965: aload 5
    //   967: putfield 672	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:mixVoiceIds	Ljava/lang/String;
    //   970: aload_1
    //   971: ldc_w 674
    //   974: invokevirtual 446	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   977: astore 5
    //   979: invokestatic 679	com/baidu/navisdk/module/routereport/BNRouteReportController:getInstance	()Lcom/baidu/navisdk/module/routereport/BNRouteReportController;
    //   982: aload 5
    //   984: iconst_1
    //   985: invokevirtual 683	com/baidu/navisdk/module/routereport/BNRouteReportController:parseRouteReportItemJson	(Lorg/json/JSONArray;I)V
    //   988: aload_1
    //   989: ldc_w 685
    //   992: invokevirtual 446	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   995: astore 5
    //   997: invokestatic 679	com/baidu/navisdk/module/routereport/BNRouteReportController:getInstance	()Lcom/baidu/navisdk/module/routereport/BNRouteReportController;
    //   1000: aload 5
    //   1002: iconst_2
    //   1003: invokevirtual 683	com/baidu/navisdk/module/routereport/BNRouteReportController:parseRouteReportItemJson	(Lorg/json/JSONArray;I)V
    //   1006: aload_1
    //   1007: ldc_w 687
    //   1010: invokevirtual 349	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1013: astore 5
    //   1015: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   1018: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   1021: astore 6
    //   1023: aload 5
    //   1025: ldc_w 612
    //   1028: invokevirtual 334	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1031: iconst_1
    //   1032: if_icmpne +371 -> 1403
    //   1035: iconst_1
    //   1036: istore 4
    //   1038: aload 6
    //   1040: iload 4
    //   1042: putfield 690	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:foregroundService	Z
    //   1045: invokestatic 695	com/baidu/navisdk/ui/routeguide/control/RGRouteSortController:getInstance	()Lcom/baidu/navisdk/ui/routeguide/control/RGRouteSortController;
    //   1048: aload_1
    //   1049: invokevirtual 696	com/baidu/navisdk/ui/routeguide/control/RGRouteSortController:parseCloudJson	(Lorg/json/JSONObject;)Z
    //   1052: ifeq +9 -> 1061
    //   1055: invokestatic 695	com/baidu/navisdk/ui/routeguide/control/RGRouteSortController:getInstance	()Lcom/baidu/navisdk/ui/routeguide/control/RGRouteSortController;
    //   1058: invokevirtual 699	com/baidu/navisdk/ui/routeguide/control/RGRouteSortController:checkCloudConfig	()V
    //   1061: aload_1
    //   1062: ldc_w 701
    //   1065: invokevirtual 349	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1068: astore 5
    //   1070: aload 5
    //   1072: ifnull +59 -> 1131
    //   1075: aload 5
    //   1077: ldc_w 336
    //   1080: invokevirtual 508	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1083: ifeq +20 -> 1103
    //   1086: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   1089: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   1092: aload 5
    //   1094: ldc_w 336
    //   1097: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1100: putfield 704	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:mCastrolYellowIconURL	Ljava/lang/String;
    //   1103: aload 5
    //   1105: ldc_w 706
    //   1108: invokevirtual 508	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1111: ifeq +20 -> 1131
    //   1114: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   1117: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   1120: aload 5
    //   1122: ldc_w 706
    //   1125: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1128: putfield 709	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:mCastrolYellowText	Ljava/lang/String;
    //   1131: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   1134: new 711	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$RequestBaseDataConfig
    //   1137: dup
    //   1138: aload_1
    //   1139: ldc_w 285
    //   1142: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1145: aload_1
    //   1146: ldc_w 713
    //   1149: invokevirtual 717	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   1152: invokespecial 720	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$RequestBaseDataConfig:<init>	(Ljava/lang/String;J)V
    //   1155: putfield 724	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mRequestBaseDataConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$RequestBaseDataConfig;
    //   1158: aload_1
    //   1159: ldc_w 726
    //   1162: invokevirtual 349	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1165: astore 5
    //   1167: aload 5
    //   1169: ifnull +20 -> 1189
    //   1172: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   1175: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   1178: aload 5
    //   1180: ldc_w 728
    //   1183: invokevirtual 730	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1186: putfield 733	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:abroadVoice	Ljava/lang/String;
    //   1189: aload_1
    //   1190: ldc_w 735
    //   1193: invokevirtual 349	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1196: astore 5
    //   1198: aload 5
    //   1200: ifnull +21 -> 1221
    //   1203: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   1206: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   1209: aload 5
    //   1211: ldc_w 556
    //   1214: iconst_0
    //   1215: invokevirtual 622	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1218: putfield 738	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:xdVoice	I
    //   1221: aload_1
    //   1222: ldc_w 740
    //   1225: invokevirtual 349	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1228: astore_1
    //   1229: aload_1
    //   1230: ifnull +33 -> 1263
    //   1233: aload_1
    //   1234: ldc_w 612
    //   1237: iconst_0
    //   1238: invokevirtual 622	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1241: istore_2
    //   1242: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   1245: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   1248: astore_1
    //   1249: iload_2
    //   1250: iconst_1
    //   1251: if_icmpne +187 -> 1438
    //   1254: iconst_1
    //   1255: istore 4
    //   1257: aload_1
    //   1258: iload 4
    //   1260: putfield 743	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:isEyespyPagerOpen	Z
    //   1263: iconst_1
    //   1264: ireturn
    //   1265: aload 7
    //   1267: new 745	com/baidu/navisdk/ui/ugc/model/UgcOperationalActModel$actBaseDataModel
    //   1270: dup
    //   1271: aload 5
    //   1273: ldc_w 747
    //   1276: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1279: aload 5
    //   1281: ldc_w 749
    //   1284: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1287: aload 5
    //   1289: ldc_w 751
    //   1292: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1295: aload 5
    //   1297: ldc_w 753
    //   1300: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1303: aload 5
    //   1305: ldc_w 755
    //   1308: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1311: aload 5
    //   1313: ldc_w 757
    //   1316: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1319: aload 5
    //   1321: ldc_w 759
    //   1324: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1327: invokespecial 762	com/baidu/navisdk/ui/ugc/model/UgcOperationalActModel$actBaseDataModel:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1330: invokevirtual 467	com/baidu/navisdk/ui/ugc/model/UgcOperationalActModel:setActBaseDataModel	(Lcom/baidu/navisdk/ui/ugc/model/UgcOperationalActModel$actBaseDataModel;)V
    //   1333: goto -1290 -> 43
    //   1336: astore_1
    //   1337: aload_1
    //   1338: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   1341: iconst_0
    //   1342: ireturn
    //   1343: iconst_0
    //   1344: istore 4
    //   1346: goto -1214 -> 132
    //   1349: iconst_0
    //   1350: istore 4
    //   1352: goto -1190 -> 162
    //   1355: iconst_0
    //   1356: istore 4
    //   1358: goto -1136 -> 222
    //   1361: iconst_0
    //   1362: istore 4
    //   1364: goto -1101 -> 263
    //   1367: iconst_0
    //   1368: istore 4
    //   1370: goto -886 -> 484
    //   1373: iconst_0
    //   1374: istore 4
    //   1376: goto -853 -> 523
    //   1379: iconst_1
    //   1380: istore 4
    //   1382: goto -661 -> 721
    //   1385: iconst_0
    //   1386: istore 4
    //   1388: goto -557 -> 831
    //   1391: iconst_0
    //   1392: istore 4
    //   1394: goto -540 -> 854
    //   1397: iconst_0
    //   1398: istore 4
    //   1400: goto -497 -> 903
    //   1403: iconst_0
    //   1404: istore 4
    //   1406: goto -368 -> 1038
    //   1409: astore 5
    //   1411: invokestatic 366	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:getInstance	()Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel;
    //   1414: getfield 424	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel:mCommonConfig	Lcom/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig;
    //   1417: iconst_0
    //   1418: putfield 690	com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel$CommonConfig:foregroundService	Z
    //   1421: goto -376 -> 1045
    //   1424: astore 5
    //   1426: getstatic 33	com/baidu/navisdk/module/cloudconfig/CloudConfigObtainManager:TAG	Ljava/lang/String;
    //   1429: ldc_w 764
    //   1432: invokestatic 116	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1435: goto -304 -> 1131
    //   1438: iconst_0
    //   1439: istore 4
    //   1441: goto -184 -> 1257
    //   1444: astore_1
    //   1445: goto -182 -> 1263
    //   1448: astore 5
    //   1450: goto -229 -> 1221
    //   1453: astore 5
    //   1455: goto -266 -> 1189
    //   1458: astore 5
    //   1460: goto -454 -> 1006
    //   1463: astore 5
    //   1465: goto -477 -> 988
    //   1468: astore 5
    //   1470: goto -500 -> 970
    //   1473: astore 5
    //   1475: goto -532 -> 943
    //   1478: astore 5
    //   1480: goto -608 -> 872
    //   1483: astore 5
    //   1485: goto -710 -> 775
    //   1488: astore 5
    //   1490: goto -792 -> 698
    //   1493: astore 5
    //   1495: goto -818 -> 677
    //   1498: astore 5
    //   1500: goto -858 -> 642
    //   1503: astore 5
    //   1505: goto -904 -> 601
    //   1508: astore 5
    //   1510: goto -971 -> 539
    //   1513: astore 5
    //   1515: goto -1024 -> 491
    //   1518: astore 5
    //   1520: goto -1068 -> 452
    //   1523: astore 5
    //   1525: goto -1353 -> 172
    //   1528: astore 5
    //   1530: goto -1430 -> 100
    //   1533: astore 6
    //   1535: goto -1503 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1538	0	this	CloudConfigObtainManager
    //   0	1538	1	paramJSONObject	JSONObject
    //   745	507	2	i	int
    //   755	94	3	j	int
    //   130	1310	4	bool	boolean
    //   17	1303	5	localObject1	Object
    //   1409	1	5	localException1	Exception
    //   1424	1	5	localException2	Exception
    //   1448	1	5	localException3	Exception
    //   1453	1	5	localException4	Exception
    //   1458	1	5	localException5	Exception
    //   1463	1	5	localException6	Exception
    //   1468	1	5	localException7	Exception
    //   1473	1	5	localException8	Exception
    //   1478	1	5	localException9	Exception
    //   1483	1	5	localException10	Exception
    //   1488	1	5	localException11	Exception
    //   1493	1	5	localException12	Exception
    //   1498	1	5	localException13	Exception
    //   1503	1	5	localException14	Exception
    //   1508	1	5	localException15	Exception
    //   1513	1	5	localException16	Exception
    //   1518	1	5	localException17	Exception
    //   1523	1	5	localException18	Exception
    //   1528	1	5	localException19	Exception
    //   26	1013	6	localObject2	Object
    //   1533	1	6	localException20	Exception
    //   9	1257	7	localUgcOperationalActModel	UgcOperationalActModel
    // Exception table:
    //   from	to	target	type
    //   37	43	1336	java/lang/Exception
    //   172	179	1336	java/lang/Exception
    //   642	651	1336	java/lang/Exception
    //   1045	1061	1336	java/lang/Exception
    //   1131	1158	1336	java/lang/Exception
    //   1265	1333	1336	java/lang/Exception
    //   1411	1421	1336	java/lang/Exception
    //   1426	1435	1336	java/lang/Exception
    //   1006	1035	1409	java/lang/Exception
    //   1038	1045	1409	java/lang/Exception
    //   1061	1070	1424	java/lang/Exception
    //   1075	1103	1424	java/lang/Exception
    //   1103	1131	1424	java/lang/Exception
    //   1221	1229	1444	java/lang/Exception
    //   1233	1249	1444	java/lang/Exception
    //   1257	1263	1444	java/lang/Exception
    //   1189	1198	1448	java/lang/Exception
    //   1203	1221	1448	java/lang/Exception
    //   1158	1167	1453	java/lang/Exception
    //   1172	1189	1453	java/lang/Exception
    //   988	1006	1458	java/lang/Exception
    //   970	988	1463	java/lang/Exception
    //   943	970	1468	java/lang/Exception
    //   872	895	1473	java/lang/Exception
    //   903	943	1473	java/lang/Exception
    //   775	823	1478	java/lang/Exception
    //   831	846	1478	java/lang/Exception
    //   854	872	1478	java/lang/Exception
    //   698	718	1483	java/lang/Exception
    //   721	775	1483	java/lang/Exception
    //   677	693	1488	java/lang/Exception
    //   656	672	1493	java/lang/Exception
    //   601	642	1498	java/lang/Exception
    //   539	601	1503	java/lang/Exception
    //   491	520	1508	java/lang/Exception
    //   523	539	1508	java/lang/Exception
    //   452	481	1513	java/lang/Exception
    //   484	491	1513	java/lang/Exception
    //   179	219	1518	java/lang/Exception
    //   222	229	1518	java/lang/Exception
    //   229	260	1518	java/lang/Exception
    //   263	270	1518	java/lang/Exception
    //   270	310	1518	java/lang/Exception
    //   310	338	1518	java/lang/Exception
    //   338	366	1518	java/lang/Exception
    //   366	394	1518	java/lang/Exception
    //   394	422	1518	java/lang/Exception
    //   422	452	1518	java/lang/Exception
    //   100	129	1523	java/lang/Exception
    //   132	159	1523	java/lang/Exception
    //   162	172	1523	java/lang/Exception
    //   43	100	1528	java/lang/Exception
    //   19	28	1533	java/lang/Exception
  }
  
  private boolean parseUgcOperationalActJSON(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    int k = 0;
    int i = 0;
    if (paramJSONObject == null) {}
    for (;;)
    {
      return false;
      if (UgcOperationalActModel.getInstance() == null) {
        continue;
      }
      JSONObject localJSONObject1 = null;
      int j = k;
      try
      {
        LogUtil.e("", " parseUgcOperationalActJSON safety errno: " + paramJSONObject.getInt("errno") + " errmsg: " + paramJSONObject.getString("errmsg"));
        j = k;
        if (paramJSONObject.getInt("errno") == 304)
        {
          j = k;
          if (this.mDataCacheManager == null)
          {
            j = k;
            this.mDataCacheManager = new DataCacheManager();
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          boolean bool1;
          try
          {
            localJSONObject1 = this.mDataCacheManager.getJSonObjectFromFile().getJSONObject("data");
            JSONObject localJSONObject2 = localJSONObject1;
            if (localJSONObject1 == null)
            {
              j = k;
              localJSONObject2 = paramJSONObject.getJSONObject("data");
              i = 1;
            }
            j = i;
            if (parseUgcDataJSON(localJSONObject2)) {
              break label250;
            }
            if (i != 0) {
              break label294;
            }
            bool1 = true;
            j = i;
            restartQeqData(bool1);
            return false;
            paramJSONObject = paramJSONObject;
            paramJSONObject.printStackTrace();
            if (j != 0) {
              break label288;
            }
            bool1 = bool2;
            restartQeqData(bool1);
            return false;
          }
          catch (Exception localException)
          {
            j = k;
            localException.printStackTrace();
            Object localObject = null;
            continue;
          }
          j = k;
          if (paramJSONObject.getInt("errno") != 0) {
            break;
          }
          j = k;
          if (!paramJSONObject.getString("errmsg").equals("success"))
          {
            return false;
            label250:
            if (i != 0)
            {
              j = i;
              if (this.mDataCacheManager == null)
              {
                j = i;
                this.mDataCacheManager = new DataCacheManager();
              }
              j = i;
              this.mDataCacheManager.saveJSonObjectToFile(paramJSONObject);
            }
            return true;
            label288:
            bool1 = false;
            continue;
            label294:
            bool1 = false;
          }
        }
      }
    }
  }
  
  private void restartQeqData(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mDataCacheManager == null) {
        this.mDataCacheManager = new DataCacheManager();
      }
      this.mDataCacheManager.clearFileCache();
      initCloudConfigOutline();
    }
  }
  
  public void initCloudConfigOutline()
  {
    if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext()))
    {
      if (getUgcDataFromFile()) {
        UgcOperationalActModel.getInstance().setActBaseDataModel(null);
      }
      if (this.mUgcHandler != null) {
        this.mUgcHandler.sendEmptyMessage(2);
      }
      return;
    }
    if (this.mDataCacheManager == null) {
      this.mDataCacheManager = new DataCacheManager();
    }
    ReqData localReqData = new ReqData("cmd.general.httprequest.func", 7, this.mUgcHandler, 1, 10000);
    CmdGeneralHttpRequestFunc.addFunc(localReqData, new CmdGeneralHttpRequestFunc.Callback()
    {
      public List<NameValuePair> getRequestParams()
      {
        return CloudConfigObtainManager.this.getServiceReqParam();
      }
      
      public int getRequestType()
      {
        return 1;
      }
      
      public String getUrl()
      {
        return HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_INIT_CLOUD_CONFIG);
      }
      
      public boolean parseResponseJSON(JSONObject paramAnonymousJSONObject)
      {
        boolean bool = CloudConfigObtainManager.this.parseUgcOperationalActJSON(paramAnonymousJSONObject);
        if (!bool) {
          LogUtil.e(CloudConfigObtainManager.TAG, "parseResponseJSON failed");
        }
        while (bool)
        {
          UgcOperationalActModel.getInstance().isWebDataValid = true;
          CloudlConfigDataModel.getInstance().isWebDataValid = true;
          return bool;
          if (LogUtil.LOGGABLE) {
            UgcOperationalActModel.getInstance().showSpecificDataLog();
          }
        }
        UgcOperationalActModel.getInstance().isWebDataValid = false;
        CloudlConfigDataModel.getInstance().isWebDataValid = false;
        return bool;
      }
      
      public void responseImage(byte[] paramAnonymousArrayOfByte) {}
    });
    CommandCenter.getInstance().sendRequest(localReqData);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/cloudconfig/CloudConfigObtainManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */