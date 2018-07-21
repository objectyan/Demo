package com.baidu.navisdk.ui.voice.controller;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNIVoicePersonalityControl;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.ui.voice.BNVoiceParams;
import com.baidu.navisdk.ui.voice.VoiceShareListener;
import com.baidu.navisdk.ui.voice.model.VoiceDataStatus;
import com.baidu.navisdk.ui.voice.model.VoiceInfo;
import com.baidu.navisdk.ui.voice.model.VoiceShareData;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class VoiceHelper
{
  private VoiceInfo mShareVoiceInfo = null;
  
  public static VoiceHelper getInstance()
  {
    return LazyHolder.sInstance;
  }
  
  public boolean cancelUpdateToServer(String paramString)
  {
    return JNIVoicePersonalityControl.sInstance.removeUpdateTask(paramString);
  }
  
  public String generateRandTaskId()
  {
    return UUID.randomUUID().toString();
  }
  
  public String getCurrentUsedTTSId()
  {
    int i = BNSettingManager.getVoicePersonality();
    if (i == 0) {
      return null;
    }
    if (i == 1) {
      return "9999";
    }
    return BNSettingManager.getVoiceTaskId();
  }
  
  public int getDownloadProgress(String paramString)
  {
    VoiceDataStatus localVoiceDataStatus = VoiceDownloadController.getInstance().getTaskDownStausFromEngine(paramString);
    if ("9999".equals(paramString)) {
      LogUtil.e("BNVoice", "getDownloadProgress status = " + localVoiceDataStatus.status + " download = " + localVoiceDataStatus.unDwonloadSize);
    }
    int i = 0;
    if ((localVoiceDataStatus.status == VoiceDataStatus.VOICE_DATA_DOWN_DOWNING) || (localVoiceDataStatus.status == VoiceDataStatus.VOICE_DATA_DOWN_UNSTART))
    {
      j = (int)localVoiceDataStatus.unTotalSize;
      k = (int)localVoiceDataStatus.unDwonloadSize;
      if (j != 0) {
        i = (int)(k / j * 100.0D);
      }
    }
    while (localVoiceDataStatus.status != VoiceDataStatus.VOICE_DATA_DOWN_END)
    {
      int j;
      int k;
      return i;
    }
    return 100;
  }
  
  public Map<String, String> getRecordVoiceDetailInfo(String paramString)
  {
    HashMap localHashMap = new HashMap();
    Object localObject = new ArrayList();
    if (JNIVoicePersonalityControl.sInstance.getRecordVoiceItems(paramString, (ArrayList)localObject))
    {
      paramString = ((ArrayList)localObject).iterator();
      while (paramString.hasNext())
      {
        localObject = (Bundle)paramString.next();
        if ((((Bundle)localObject).containsKey("ORGWORD")) && (((Bundle)localObject).containsKey("VOICEPATH"))) {
          localHashMap.put(((Bundle)localObject).getString("ORGWORD"), ((Bundle)localObject).getString("VOICEPATH"));
        }
      }
    }
    return localHashMap;
  }
  
  public String getSuperStarById(String paramString)
  {
    String str = "未知";
    if ("9998".equals(paramString)) {
      str = "鹿晗";
    }
    do
    {
      return str;
      if ("10001".equals(paramString)) {
        return "陈楚生";
      }
      if ("10002".equals(paramString)) {
        return "何洁";
      }
      if ("10003".equals(paramString)) {
        return "吉克隽逸";
      }
      if ("10004".equals(paramString)) {
        return "金莎";
      }
      if ("10005".equals(paramString)) {
        return "谭维维";
      }
      if ("10006".equals(paramString)) {
        return "杨坤";
      }
    } while (!"10007".equals(paramString));
    return "牛奶咖啡";
  }
  
  public VoiceInfo getVoiceInfo(String paramString)
  {
    Bundle localBundle = new Bundle();
    try
    {
      if (JNIVoicePersonalityControl.sInstance.getVoiceInfo(paramString, localBundle))
      {
        paramString = VoiceInfo.getVoiceInfo(localBundle);
        return paramString;
      }
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public String getVoiceItemPath(String paramString1, String paramString2)
  {
    return JNIVoicePersonalityControl.sInstance.getTaskFilePathWithWord(paramString1, paramString2);
  }
  
  public String getVoiceSetPath(String paramString)
  {
    return JNIVoicePersonalityControl.sInstance.getTaskFilePath(paramString, true);
  }
  
  public String getVoiceSetPath(String paramString, boolean paramBoolean)
  {
    return JNIVoicePersonalityControl.sInstance.getTaskFilePath(paramString, paramBoolean);
  }
  
  public String getVoiceShowDownCnt(int paramInt)
  {
    if (paramInt <= 10000) {
      return "" + paramInt + "次";
    }
    if (paramInt > 10000) {
      return "" + paramInt / 10000 + "万次";
    }
    return "" + paramInt / 100000000 + "亿次";
  }
  
  public String getVoiceShowSize(long paramLong)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat();
    if (paramLong < 1024L) {
      return paramLong + "B";
    }
    if (paramLong < 1048576L)
    {
      localDecimalFormat.applyPattern("0");
      d = paramLong / 1024.0D;
      return localDecimalFormat.format(d) + "K";
    }
    if (paramLong < 1073741824L)
    {
      localDecimalFormat.applyPattern("0.0");
      d = paramLong / 1048576.0D;
      return localDecimalFormat.format(d) + "M";
    }
    localDecimalFormat.applyPattern("0.0");
    double d = paramLong / 1.073741824E9D;
    return localDecimalFormat.format(d) + "G";
  }
  
  public boolean isTaskDownloadFinish(String paramString)
  {
    VoiceDataStatus localVoiceDataStatus = new VoiceDataStatus();
    return (JNIVoicePersonalityControl.sInstance.isTaskDowned(paramString, localVoiceDataStatus)) && (localVoiceDataStatus.status == VoiceDataStatus.VOICE_DATA_DOWN_END);
  }
  
  public boolean share(VoiceInfo paramVoiceInfo)
  {
    if (paramVoiceInfo == null) {
      return false;
    }
    this.mShareVoiceInfo = paramVoiceInfo;
    if (paramVoiceInfo.status == 0)
    {
      String str = BNVoice.getInstance().getBduss();
      return getInstance().updateTaskToServer(paramVoiceInfo.taskId, str);
    }
    shareWithoutUpload(paramVoiceInfo);
    return true;
  }
  
  public void shareFromSquare()
  {
    String str1 = BNStyleManager.getString(1711670150);
    String str2 = BNStyleManager.getString(1711670151);
    ArrayList localArrayList = new ArrayList();
    VoiceShareData localVoiceShareData = new VoiceShareData();
    localVoiceShareData.shareType = 0;
    localVoiceShareData.subject = str1;
    localVoiceShareData.content = str2;
    localVoiceShareData.shareUrl = HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_VOICE_SQUARE);
    localVoiceShareData.imageUrl = BNVoiceParams.VOICE_SQUARE_DEFAULT_IMAGE_URL;
    localArrayList.add(localVoiceShareData);
    localVoiceShareData = new VoiceShareData();
    localVoiceShareData.shareType = 1;
    localVoiceShareData.subject = str1;
    localVoiceShareData.content = str2;
    localVoiceShareData.shareUrl = HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_VOICE_SQUARE);
    localVoiceShareData.imageUrl = BNVoiceParams.VOICE_SQUARE_DEFAULT_IMAGE_URL;
    localArrayList.add(localVoiceShareData);
    localVoiceShareData = new VoiceShareData();
    localVoiceShareData.shareType = 2;
    localVoiceShareData.subject = str2;
    localVoiceShareData.content = str2;
    localVoiceShareData.shareUrl = HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_VOICE_SQUARE);
    localVoiceShareData.imageUrl = BNVoiceParams.VOICE_SQUARE_DEFAULT_IMAGE_URL;
    localArrayList.add(localVoiceShareData);
    localVoiceShareData = new VoiceShareData();
    localVoiceShareData.shareType = 3;
    localVoiceShareData.subject = str1;
    localVoiceShareData.content = (str2 + " " + HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_VOICE_SQUARE));
    localVoiceShareData.shareUrl = HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_VOICE_SQUARE);
    localVoiceShareData.imageUrl = null;
    localArrayList.add(localVoiceShareData);
    if (BNVoice.getInstance().getVoiceShareListener() != null) {
      BNVoice.getInstance().getVoiceShareListener().share(localArrayList);
    }
  }
  
  public void shareTopic(String paramString)
    throws JSONException
  {
    VoiceInfo localVoiceInfo = new VoiceInfo();
    paramString = new JSONObject(paramString);
    localVoiceInfo.imageUrl = paramString.optString("img");
    localVoiceInfo.voiceUrl = paramString.optString("url");
    localVoiceInfo.name = paramString.optString("title");
    localVoiceInfo.status = 3;
    share(localVoiceInfo);
  }
  
  public void shareWithoutUpload(VoiceInfo paramVoiceInfo)
  {
    if (paramVoiceInfo == null) {
      return;
    }
    this.mShareVoiceInfo = paramVoiceInfo;
    label27:
    Object localObject;
    String str;
    int j;
    if ((paramVoiceInfo.status == 0) || (paramVoiceInfo.status == 1))
    {
      i = 1;
      if ((TextUtils.isEmpty(this.mShareVoiceInfo.imageUrl)) || (!this.mShareVoiceInfo.imageUrl.startsWith("http"))) {
        this.mShareVoiceInfo.imageUrl = BNVoiceParams.VOICE_DEFUALT_IMAGE_URL;
      }
      localObject = BNStyleManager.getString(1711670140);
      str = this.mShareVoiceInfo.name;
      if (str != null)
      {
        paramVoiceInfo = str;
        if (str.length() != 0) {}
      }
      else
      {
        paramVoiceInfo = "";
      }
      if (i == 0) {
        break label464;
      }
      j = 1711670146;
      label110:
      str = String.format(BNStyleManager.getString(j), new Object[] { localObject, paramVoiceInfo });
      if (i == 0) {
        break label471;
      }
    }
    label464:
    label471:
    for (int i = 1711670147;; i = 1711670143)
    {
      paramVoiceInfo = String.format(BNStyleManager.getString(i), new Object[] { paramVoiceInfo });
      localObject = new ArrayList();
      VoiceShareData localVoiceShareData = new VoiceShareData();
      localVoiceShareData.shareType = 0;
      localVoiceShareData.subject = str;
      localVoiceShareData.content = paramVoiceInfo;
      localVoiceShareData.shareUrl = this.mShareVoiceInfo.voiceUrl.replace("/voice_market_details/", "/voice_market_details_v2/");
      localVoiceShareData.imageUrl = this.mShareVoiceInfo.imageUrl;
      ((ArrayList)localObject).add(localVoiceShareData);
      localVoiceShareData = new VoiceShareData();
      localVoiceShareData.shareType = 1;
      localVoiceShareData.subject = str;
      localVoiceShareData.content = paramVoiceInfo;
      localVoiceShareData.shareUrl = this.mShareVoiceInfo.voiceUrl;
      localVoiceShareData.imageUrl = this.mShareVoiceInfo.imageUrl;
      ((ArrayList)localObject).add(localVoiceShareData);
      localVoiceShareData = new VoiceShareData();
      localVoiceShareData.shareType = 2;
      localVoiceShareData.subject = paramVoiceInfo;
      localVoiceShareData.content = paramVoiceInfo;
      localVoiceShareData.shareUrl = this.mShareVoiceInfo.voiceUrl;
      localVoiceShareData.imageUrl = this.mShareVoiceInfo.imageUrl;
      ((ArrayList)localObject).add(localVoiceShareData);
      localVoiceShareData = new VoiceShareData();
      localVoiceShareData.shareType = 3;
      localVoiceShareData.subject = str;
      localVoiceShareData.content = (paramVoiceInfo + " " + this.mShareVoiceInfo.voiceUrl);
      localVoiceShareData.shareUrl = this.mShareVoiceInfo.voiceUrl;
      localVoiceShareData.imageUrl = null;
      ((ArrayList)localObject).add(localVoiceShareData);
      if (BNVoice.getInstance().getVoiceShareListener() == null) {
        break;
      }
      BNVoice.getInstance().getVoiceShareListener().share((List)localObject);
      return;
      i = 0;
      break label27;
      j = 1711670142;
      break label110;
    }
  }
  
  public boolean updateTaskToServer(String paramString1, String paramString2)
  {
    return JNIVoicePersonalityControl.sInstance.updateTaskToServer(paramString1, paramString2);
  }
  
  private static class LazyHolder
  {
    public static final VoiceHelper sInstance = new VoiceHelper(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/voice/controller/VoiceHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */