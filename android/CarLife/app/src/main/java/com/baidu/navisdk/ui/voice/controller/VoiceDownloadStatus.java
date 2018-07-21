package com.baidu.navisdk.ui.voice.controller;

import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNIVoicePersonalityControl;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.ui.voice.BNVoiceParams;
import com.baidu.navisdk.ui.voice.model.VoiceDataStatus;
import com.baidu.navisdk.ui.voice.model.VoiceInfo;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.UserTask;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.http.center.IBNHttpCenter;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class VoiceDownloadStatus
{
  private boolean mAutoDownload = true;
  private int mCurrentDownloadSize = 0;
  private String mCurrentTaskId = null;
  private int mCurrentTaskStatus = 0;
  private int mCurrentTotalSize = 0;
  private NaviTaskListener mNaviTaskListener = null;
  private String mSlienceDownloadTaskId = null;
  private String mSlienceJson = null;
  private LinkedList<String> mTaskQueue = new LinkedList();
  private HashMap<String, Integer> mTaskStatus = new HashMap();
  
  private boolean addToTaskQueue(String paramString)
  {
    if ((this.mTaskQueue.isEmpty()) || ((!this.mTaskQueue.contains(paramString)) && (!paramString.equals(this.mCurrentTaskId))))
    {
      this.mTaskQueue.add(paramString);
      LogUtil.e("BNVoice", "addToTaskQueue taskId :" + paramString);
      int i = VoiceHelper.getInstance().getDownloadProgress(paramString);
      setCurrentDownloadState(paramString, 8, i);
      setCurrentDownloadState(paramString, 1, i);
      return true;
    }
    setCurrentDownloadState(paramString, 8, VoiceHelper.getInstance().getDownloadProgress(paramString));
    return false;
  }
  
  private void autoDownloadTask()
  {
    LogUtil.e("BNVoice", "autoDownloadTask mCurrentTaskId " + this.mCurrentTaskId + " mCurrentTaskStatus = " + this.mCurrentTaskStatus);
    if ((this.mCurrentTaskId == null) && (this.mAutoDownload))
    {
      if (this.mTaskQueue.isEmpty()) {
        break label131;
      }
      this.mCurrentTaskId = ((String)this.mTaskQueue.remove());
      LogUtil.e("BNVoice", "autoDownloadTask taskId =  " + this.mCurrentTaskId);
      if (this.mCurrentTaskId != null)
      {
        this.mCurrentTotalSize = 0;
        this.mCurrentDownloadSize = 0;
        this.mCurrentTaskStatus = 0;
        startDownloadImpl();
      }
    }
    return;
    label131:
    this.mCurrentTaskId = null;
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
  
  public static VoiceDownloadStatus getInstance()
  {
    return LazyHolder.sStatus;
  }
  
  private void setCurrentDownloadState(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString != null)
    {
      this.mTaskStatus.put(paramString, Integer.valueOf(paramInt1));
      BNVoice.getInstance().notifyObservers(1, paramInt1, new VoiceDownObj(paramString, paramInt2));
    }
  }
  
  private void startDownloadImpl()
  {
    LogUtil.e("BNVoice", "startDownloadImpl taskId =  " + this.mCurrentTaskId);
    switch (this.mCurrentTaskStatus)
    {
    default: 
      return;
    case 0: 
      LogUtil.e("BNVoice", "appendTaskToTaskArray taskId =  " + this.mCurrentTaskId);
      JNIVoicePersonalityControl.sInstance.appendTaskToTaskArray(this.mCurrentTaskId, "9999".equals(this.mCurrentTaskId));
      this.mCurrentTaskStatus = 5;
      i = VoiceHelper.getInstance().getDownloadProgress(this.mCurrentTaskId);
      setCurrentDownloadState(this.mCurrentTaskId, 5, i);
      return;
    case 1: 
      LogUtil.e("BNVoice", "appendTaskToTaskArray taskId =  " + this.mCurrentTaskId);
      JNIVoicePersonalityControl.sInstance.appendTaskToTaskArray(this.mCurrentTaskId, "9999".equals(this.mCurrentTaskId));
      this.mCurrentTaskStatus = 1;
      i = VoiceHelper.getInstance().getDownloadProgress(this.mCurrentTaskId);
      setCurrentDownloadState(this.mCurrentTaskId, 1, i);
      return;
    }
    LogUtil.e("BNVoice", "resumeTask taskId =  " + this.mCurrentTaskId);
    JNIVoicePersonalityControl.sInstance.resumeTask(this.mCurrentTaskId);
    int i = VoiceHelper.getInstance().getDownloadProgress(this.mCurrentTaskId);
    this.mCurrentTaskStatus = 1;
    setCurrentDownloadState(this.mCurrentTaskId, 1, i);
  }
  
  public void addJinShaToSharedVoiceInfo()
  {
    if (this.mSlienceDownloadTaskId != null)
    {
      VoiceInfo localVoiceInfo = VoiceHelper.getInstance().getVoiceInfo("2-129798");
      if (localVoiceInfo != null)
      {
        ArrayList localArrayList1 = VoiceDownloadController.getInstance().getSharedVoiceInfos();
        ArrayList localArrayList2 = VoiceDownloadController.getInstance().getDownloadVoiceTask();
        if ((BNSettingManager.getAutoDownloadJinShaTTS()) && (localArrayList1 != null) && (localArrayList2 != null) && (!localArrayList1.contains(localVoiceInfo)) && (!localArrayList2.contains(localVoiceInfo)))
        {
          VoiceDownloadController.getInstance().addSharedVoiceInfo(localVoiceInfo);
          VoiceDownloadController.getInstance().startDownload(this.mSlienceDownloadTaskId);
        }
      }
    }
  }
  
  public void createToast(int paramInt, VoiceInfo paramVoiceInfo)
  {
    if (paramVoiceInfo != null)
    {
      if (paramInt != 5) {
        break label50;
      }
      TipTool.onCreateToastDialog(BNaviModuleManager.getActivity(), "检测到Wi-Fi网络，为您自动下载\"" + paramVoiceInfo.name + '"' + "导航语音");
    }
    label50:
    do
    {
      return;
      if (paramInt == 262)
      {
        TipTool.onCreateToastDialog(BNaviModuleManager.getActivity(), "未检测到Wi-Fi网络，暂停下载\"" + paramVoiceInfo.name + '"' + "导航语音");
        return;
      }
      if (paramInt == 261)
      {
        TipTool.onCreateToastDialog(BNaviModuleManager.getActivity(), "网络连接中断，暂停下载\"" + paramVoiceInfo.name + '"' + "导航语音");
        return;
      }
      if (paramInt == 6)
      {
        TipTool.onCreateToastDialog(BNaviModuleManager.getActivity(), "切换为\"" + paramVoiceInfo.name + '"' + "导航语音");
        return;
      }
    } while (paramInt != 7);
    TipTool.onCreateToastDialog(BNaviModuleManager.getActivity(), "切换\"" + paramVoiceInfo.name + '"' + "导航语音失败");
  }
  
  public void failDownload(int paramInt)
  {
    UserOPController.getInstance().add("5.1", this.mCurrentTaskId, "0", null);
    setCurrentDownloadState(this.mCurrentTaskId, 3, paramInt);
    removeDownload(this.mCurrentTaskId);
  }
  
  public void finishDownload()
  {
    UserOPController.getInstance().add("5.1", this.mCurrentTaskId, "1", null);
    this.mCurrentTaskStatus = 0;
    LogUtil.e("BNVoice", "mCurrentTaskId: " + this.mCurrentTaskId);
    if ((this.mCurrentTaskId != null) && (this.mCurrentTaskId.equals("2-129798"))) {
      BNSettingManager.setHasDownloadJinShaTTS(true);
    }
    setCurrentDownloadState(this.mCurrentTaskId, 4, 100);
    this.mTaskStatus.remove(this.mCurrentTaskId);
    this.mCurrentTaskId = null;
    autoDownloadTask();
  }
  
  public String getCurrentDownTaskId()
  {
    return this.mCurrentTaskId;
  }
  
  public int getDownTaskStatus(String paramString)
  {
    if (this.mTaskStatus.containsKey(paramString)) {
      return ((Integer)this.mTaskStatus.get(paramString)).intValue();
    }
    return 0;
  }
  
  public int getDownloadProgress(int paramInt)
  {
    int i = 0;
    if (this.mCurrentTotalSize != 0) {
      i = (int)(paramInt / this.mCurrentTotalSize * 100.0D);
    }
    return i;
  }
  
  public int getTaskDownloadStatus(String paramString)
  {
    return this.mCurrentTaskStatus;
  }
  
  public LinkedList<String> getTaskQueue()
  {
    return this.mTaskQueue;
  }
  
  public void handleSwitchVoiceData(boolean paramBoolean, String paramString)
  {
    paramString = VoiceHelper.getInstance().getVoiceInfo(paramString);
    if ((paramString != null) && (paramBoolean))
    {
      BNSettingManager.setAutoSwitchJinShaTTS(false);
      createToast(6, paramString);
    }
  }
  
  public boolean hasInTaskQueue(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      if (!this.mTaskQueue.contains(paramString))
      {
        bool1 = bool2;
        if (!paramString.equals(this.mCurrentTaskId)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void pauseAllDownload(int paramInt)
  {
    if ((this.mCurrentTaskId != null) && (this.mCurrentTaskStatus == 1))
    {
      JNIVoicePersonalityControl.sInstance.pauseTask(this.mCurrentTaskId);
      if ((this.mCurrentTaskId.equals("2-129798")) && (VoiceHelper.getInstance().getVoiceInfo(this.mCurrentTaskId) != null)) {}
      LogUtil.e("BNVoice", "voice pause download taskId :" + this.mCurrentTaskId + " cause :" + paramInt);
      this.mCurrentTaskStatus = 2;
      setCurrentDownloadState(this.mCurrentTaskId, 2, paramInt);
    }
    if (!this.mTaskQueue.isEmpty())
    {
      Iterator localIterator = this.mTaskQueue.iterator();
      while (localIterator.hasNext()) {
        setCurrentDownloadState((String)localIterator.next(), 2, paramInt);
      }
      this.mTaskQueue.clear();
    }
    this.mCurrentTaskId = null;
  }
  
  public void pauseDownload()
  {
    if (this.mCurrentTaskId != null)
    {
      JNIVoicePersonalityControl.sInstance.pauseTask(this.mCurrentTaskId);
      this.mCurrentTaskStatus = 2;
      setCurrentDownloadState(this.mCurrentTaskId, 2, 260);
      this.mCurrentTaskId = null;
    }
  }
  
  public void pauseDownload(String paramString)
  {
    if (paramString.equals(this.mCurrentTaskId)) {
      if (this.mCurrentTaskStatus == 1)
      {
        if (this.mCurrentTotalSize - this.mCurrentDownloadSize >= 30000) {
          break label43;
        }
        LogUtil.e("BNVoice", "voice pause download fail progress < 30k");
      }
    }
    label43:
    while (!this.mTaskQueue.contains(paramString))
    {
      return;
      JNIVoicePersonalityControl.sInstance.pauseTask(this.mCurrentTaskId);
      LogUtil.e("BNVoice", "voice pause download taskId :" + this.mCurrentTaskId + " cause :" + 260);
      this.mCurrentTaskStatus = 2;
      setCurrentDownloadState(this.mCurrentTaskId, 2, 260);
      this.mCurrentTaskId = null;
      autoDownloadTask();
      return;
    }
    this.mTaskQueue.remove(paramString);
    setCurrentDownloadState(paramString, 2, 260);
  }
  
  public void pauseFullDoseDownload(int paramInt)
  {
    if ((("9999".equals(this.mCurrentTaskId)) || ("2-129798".equals(this.mCurrentTaskId))) && (this.mCurrentTaskStatus == 1))
    {
      JNIVoicePersonalityControl.sInstance.pauseTask(this.mCurrentTaskId);
      LogUtil.e("BNVoice", "voice pause download taskId :" + this.mCurrentTaskId + " cause :" + paramInt);
      this.mCurrentTaskStatus = 2;
      setCurrentDownloadState(this.mCurrentTaskId, 2, paramInt);
      this.mCurrentTaskId = null;
      autoDownloadTask();
    }
    if (this.mTaskQueue.contains("9999"))
    {
      this.mTaskQueue.remove("9999");
      setCurrentDownloadState("9999", 2, paramInt);
    }
    if (this.mTaskQueue.contains("2-129798"))
    {
      if ((this.mCurrentTaskId != null) && (this.mCurrentTaskId.equals("2-129798")) && (VoiceHelper.getInstance().getVoiceInfo(this.mCurrentTaskId) != null)) {}
      this.mTaskQueue.remove("2-129798");
      setCurrentDownloadState("2-129798", 2, paramInt);
    }
  }
  
  public void removeDownload(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (paramString.equals(this.mCurrentTaskId))
    {
      JNIVoicePersonalityControl.sInstance.removeTask(paramString);
      this.mCurrentTaskStatus = 0;
      setCurrentDownloadState(this.mCurrentTaskId, 0, 0);
      this.mTaskStatus.remove(this.mCurrentTaskId);
      this.mCurrentTaskId = null;
      autoDownloadTask();
      return;
    }
    if (this.mTaskQueue.contains(paramString))
    {
      this.mTaskQueue.remove(paramString);
      setCurrentDownloadState(paramString, 0, 0);
      this.mTaskStatus.remove(paramString);
      JNIVoicePersonalityControl.sInstance.removeTask(paramString);
      return;
    }
    JNIVoicePersonalityControl.sInstance.removeTask(paramString);
    this.mTaskStatus.remove(paramString);
  }
  
  public void setAutoDownload(boolean paramBoolean)
  {
    this.mAutoDownload = paramBoolean;
  }
  
  public void setNaviTaskListener(NaviTaskListener paramNaviTaskListener)
  {
    this.mNaviTaskListener = paramNaviTaskListener;
  }
  
  public void setSizeinfo(int paramInt)
  {
    this.mCurrentTotalSize = paramInt;
  }
  
  public void silenceDownloadVoice()
  {
    ArrayList localArrayList = VoiceDownloadController.getInstance().getDownloadVoiceTask();
    VoiceInfo localVoiceInfo = new VoiceInfo();
    localVoiceInfo.taskId = "2-129798";
    if (localArrayList.contains(localVoiceInfo)) {
      return;
    }
    new HTTPGetTask(null).execute(new Integer[0]);
  }
  
  public boolean startDownload(String paramString)
  {
    UserOPController.getInstance().add("5.1", paramString, null, null);
    boolean bool = false;
    if (VoiceDownloadController.getInstance().getTaskDownStausFromEngine(paramString).status != VoiceDataStatus.VOICE_DATA_DOWN_END) {
      bool = addToTaskQueue(paramString);
    }
    if (!bool) {
      return bool;
    }
    autoDownloadTask();
    return true;
  }
  
  public void updateDownload(int paramInt)
  {
    this.mCurrentTaskStatus = 1;
    this.mCurrentDownloadSize = paramInt;
    paramInt = getInstance().getDownloadProgress(paramInt);
    setCurrentDownloadState(this.mCurrentTaskId, 1, paramInt);
  }
  
  private class HTTPGetTask
    extends UserTask<Integer, Integer, Integer>
  {
    private HTTPGetTask() {}
    
    public Integer doInBackground(Integer... paramVarArgs)
    {
      String str1 = PackageUtil.getVersionName();
      String str2 = PackageUtil.getCuid();
      paramVarArgs = Integer.toString(VoiceDownloadStatus.this.getCurrentCityId());
      HashMap localHashMap = new HashMap();
      if ("1" != null) {
        localHashMap.put("sid", "1");
      }
      if (str1 != null) {
        localHashMap.put("app_version", str1);
      }
      if ("0" != null) {
        localHashMap.put("os", "0");
      }
      if (str2 != null) {}
      try
      {
        localHashMap.put("cuid", URLEncoder.encode(str2, "UTF-8"));
        if (paramVarArgs != null) {
          localHashMap.put("cityCode", "" + paramVarArgs);
        }
        BNHttpCenter.getInstance().get(BNVoiceParams.VOICE_SILENCE_DOWNLOAD_URL, localHashMap, new BNHttpTextResponseHandler()
        {
          public void onFailure(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable) {}
          
          public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
          {
            VoiceDownloadStatus.access$202(VoiceDownloadStatus.this, paramAnonymousString);
          }
        }, null);
        return null;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;) {}
      }
    }
    
    public void onPostExecute(Integer paramInteger)
    {
      if (VoiceDownloadStatus.this.mSlienceJson != null) {}
      try
      {
        paramInteger = new JSONObject(VoiceDownloadStatus.this.mSlienceJson);
        if ((paramInteger != null) && (paramInteger.getInt("errno") == 0) && (paramInteger.getString("errmsg") != null) && (paramInteger.getString("errmsg").equals("success")) && (paramInteger.getString("data") != null))
        {
          paramInteger = new JSONObject(paramInteger.getString("data"));
          if ((paramInteger != null) && (paramInteger.getString("items") != null))
          {
            paramInteger = new JSONObject(paramInteger.getString("items"));
            if ((paramInteger != null) && (paramInteger.getString("tts_default") != null)) {
              VoiceDownloadStatus.access$302(VoiceDownloadStatus.this, paramInteger.getString("tts_default"));
            }
          }
        }
        if ((NetworkUtils.isWifiConnected()) && (VoiceDownloadStatus.this.mSlienceDownloadTaskId != null) && (VoiceDownloadStatus.this.mSlienceDownloadTaskId.length() > 0))
        {
          paramInteger = VoiceHelper.getInstance().getVoiceInfo(VoiceDownloadStatus.this.mSlienceDownloadTaskId);
          if (paramInteger != null)
          {
            ArrayList localArrayList = VoiceDownloadController.getInstance().getSharedVoiceInfos();
            if ((BNSettingManager.getAutoDownloadJinShaTTS()) && (localArrayList != null) && (!localArrayList.contains(paramInteger)))
            {
              VoiceDownloadController.getInstance().addSharedVoiceInfo(paramInteger);
              VoiceDownloadController.getInstance().startDownload(VoiceDownloadStatus.this.mSlienceDownloadTaskId);
            }
          }
        }
        return;
      }
      catch (JSONException paramInteger) {}
    }
  }
  
  private static class LazyHolder
  {
    public static final VoiceDownloadStatus sStatus = new VoiceDownloadStatus(null);
  }
  
  public static abstract interface NaviTaskListener
  {
    public abstract boolean onCheckNaviTask();
  }
  
  public static class VoiceDownObj
  {
    public int arg1;
    public String taskId;
    
    public VoiceDownObj(String paramString, int paramInt)
    {
      this.taskId = paramString;
      this.arg1 = paramInt;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/voice/controller/VoiceDownloadStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */