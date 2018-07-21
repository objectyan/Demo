package com.baidu.navisdk.ui.voice.controller;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.jni.nativeif.JNIVoicePersonalityControl;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.ui.voice.model.VoiceDataStatus;
import com.baidu.navisdk.ui.voice.model.VoiceInfo;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SDCardUtils;
import com.baidu.navisdk.util.listener.NetworkListener;
import com.baidu.navisdk.util.listener.SDCardListener;
import com.baidu.navisdk.vi.VMsgDispatcher;
import java.util.ArrayList;
import java.util.Iterator;

public class VoiceDownloadController
{
  private static Object mCallbackListLock = new Object();
  private ArrayList<Handler> mCallbackHandlerList = new ArrayList();
  private MsgHandler mHandler = new MsgHandler(Looper.getMainLooper())
  {
    public void careAbout()
    {
      observe(4164);
      observe(4165);
      observe(4167);
      observe(4166);
      observe(4163);
      observe(4176);
      observe(4177);
      observe(4178);
      observe(4183);
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      String str = VoiceDownloadStatus.getInstance().getCurrentDownTaskId();
      int i;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 4164: 
        LogUtil.e("BNVoice", "down handleMessage failed ");
        VoiceDownloadStatus.getInstance().pauseDownload();
        VoiceDownloadController.this.sendDownloadStatusChange(3, -1, -1, str);
        return;
      case 4165: 
        LogUtil.e("BNVoice", "down handleMessage finish ");
        VoiceDownloadStatus.getInstance().finishDownload();
        VoiceDownloadController.this.sendDownloadStatusChange(4, -1, -1, str);
        return;
      case 4167: 
        LogUtil.e("BNVoice", "down handleMessage md5error ");
        VoiceDownloadStatus.getInstance().failDownload(18);
        VoiceDownloadController.this.sendDownloadStatusChange(3, -1, -1, str);
        return;
      case 4166: 
        i = paramAnonymousMessage.arg2;
        LogUtil.e("BNVoice", "down handleMessage start totalSize = " + i);
        if (!VoiceDownloadController.this.checkSDCardStatus(i))
        {
          VoiceDownloadStatus.getInstance().pauseDownload();
          return;
        }
        VoiceDownloadStatus.getInstance().setSizeinfo(i);
        return;
      case 4163: 
        i = paramAnonymousMessage.arg2;
        LogUtil.e("BNVoice", "down handleMessage update downloadsize = " + i);
        VoiceDownloadStatus.getInstance().updateDownload(i);
        return;
      case 5555: 
        i = paramAnonymousMessage.arg1;
        int j = paramAnonymousMessage.arg2;
        LogUtil.e("BNVoice", " voice download in case NetworkListener.MSG_TYPE_NET_WORK_CHANGE wifiStatus " + i + " connectStatus = " + j);
        if (j != 1) {
          VoiceDownloadStatus.getInstance().pauseAllDownload(261);
        }
        for (;;)
        {
          BNVoice.getInstance().notifyObservers(7, paramAnonymousMessage.arg2, null);
          return;
          if (i != 1) {
            VoiceDownloadStatus.getInstance().pauseFullDoseDownload(262);
          }
        }
      case 5565: 
        LogUtil.e("Handler", " in case SDCardListener.MSG_TYPE_SDCARD_CHANGE");
        return;
      case 4176: 
        LogUtil.e("BNVoice", "Voice MSG_NAVI_VoiceData_UploadMsg arg1 = " + paramAnonymousMessage.arg1);
        BNVoice.getInstance().notifyObservers(4, paramAnonymousMessage.arg1, null);
        return;
      case 4177: 
        LogUtil.e("BNVoice", "Voice BuildTTS arg1 = " + paramAnonymousMessage.arg1);
        BNVoice.getInstance().notifyObservers(5, paramAnonymousMessage.arg1, null);
        return;
      case 4178: 
        BNVoice.getInstance().notifyObservers(3, 0, null);
        return;
      }
      LogUtil.e("BNVoice", "Voice NewTaskInfo arg1 = " + paramAnonymousMessage.arg1);
      BNVoice.getInstance().notifyObservers(6, paramAnonymousMessage.arg1, null);
      VoiceDownloadStatus.getInstance().addJinShaToSharedVoiceInfo();
    }
  };
  private ArrayList<VoiceInfo> mSharedVoiceInfo = new ArrayList();
  
  private VoiceDownloadController()
  {
    VMsgDispatcher.registerMsgHandler(this.mHandler);
    NetworkListener.registerMessageHandler(this.mHandler);
    SDCardListener.registerMessageHandler(this.mHandler);
  }
  
  private boolean checkSDCardStatus(int paramInt)
  {
    boolean bool = true;
    if (paramInt < 0) {
      return false;
    }
    if (SDCardUtils.handleSdcardError(paramInt, true) == 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static VoiceDownloadController getInstance()
  {
    return LazyHolder.INSTANCE;
  }
  
  private void sendDownloadStatusChange(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    synchronized (mCallbackListLock)
    {
      ArrayList localArrayList = new ArrayList(this.mCallbackHandlerList);
      try
      {
        ??? = localArrayList.iterator();
        while (((Iterator)???).hasNext()) {
          ((Handler)((Iterator)???).next()).obtainMessage(paramInt1, paramInt2, paramInt3, paramString).sendToTarget();
        }
        return;
      }
      catch (Exception paramString)
      {
        LogUtil.e("BNVoice", "sendMsgChange:" + paramString.getMessage());
      }
    }
  }
  
  public void addSharedVoiceInfo(VoiceInfo paramVoiceInfo)
  {
    if (!this.mSharedVoiceInfo.contains(paramVoiceInfo)) {
      this.mSharedVoiceInfo.add(paramVoiceInfo);
    }
  }
  
  public void dipose()
  {
    VMsgDispatcher.unregisterMsgHandler(this.mHandler);
    NetworkListener.unRegisterMessageHandler(this.mHandler);
    SDCardListener.unRegisterMessageHandler(this.mHandler);
  }
  
  public ArrayList<VoiceInfo> getDownloadVoiceTask()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      JNIVoicePersonalityControl.sInstance.getDownloadVoiceTask(localArrayList);
      localArrayList = JNIVoicePersonalityControl.sInstance.parseVoiceInfoListBundle(localArrayList);
      return localArrayList;
    }
    catch (Throwable localThrowable) {}
    return new ArrayList();
  }
  
  public ArrayList<VoiceInfo> getRecommendVoiceTask()
  {
    ArrayList localArrayList = new ArrayList();
    JNIVoicePersonalityControl.sInstance.getRecommendVoiceTask(localArrayList);
    return JNIVoicePersonalityControl.sInstance.parseVoiceInfoListBundle(localArrayList);
  }
  
  public ArrayList<VoiceInfo> getSharedVoiceInfos()
  {
    return this.mSharedVoiceInfo;
  }
  
  public VoiceDataStatus getTaskDownStausFromEngine(String paramString)
  {
    VoiceDataStatus localVoiceDataStatus = new VoiceDataStatus();
    JNIVoicePersonalityControl.sInstance.isTaskDowned(paramString, localVoiceDataStatus);
    return localVoiceDataStatus;
  }
  
  public boolean hasInSharedVoice(String paramString)
  {
    Iterator localIterator = this.mSharedVoiceInfo.iterator();
    while (localIterator.hasNext()) {
      if (((VoiceInfo)localIterator.next()).equals(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public void pauseAllDownload()
  {
    VoiceDownloadStatus.getInstance().pauseAllDownload(0);
  }
  
  public void pauseDownload(String paramString)
  {
    VoiceDownloadStatus.getInstance().pauseDownload(paramString);
  }
  
  public void registCallbackHandler(Handler paramHandler)
  {
    synchronized (mCallbackListLock)
    {
      if (!this.mCallbackHandlerList.contains(paramHandler)) {
        this.mCallbackHandlerList.add(paramHandler);
      }
      return;
    }
  }
  
  public void removeDownload(String paramString)
  {
    VoiceDownloadStatus.getInstance().removeDownload(paramString);
  }
  
  public void removeSharedVoieInfo(String paramString)
  {
    int i = 0;
    for (;;)
    {
      if (i < this.mSharedVoiceInfo.size())
      {
        if (((VoiceInfo)this.mSharedVoiceInfo.get(i)).equals(paramString)) {
          this.mSharedVoiceInfo.remove(i);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public boolean startDownload(String paramString)
  {
    return VoiceDownloadStatus.getInstance().startDownload(paramString);
  }
  
  public void unregistCallbackHandler(Handler paramHandler)
  {
    synchronized (mCallbackListLock)
    {
      if (this.mCallbackHandlerList.contains(paramHandler)) {
        this.mCallbackHandlerList.remove(paramHandler);
      }
      return;
    }
  }
  
  private static class LazyHolder
  {
    private static final VoiceDownloadController INSTANCE = new VoiceDownloadController(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/voice/controller/VoiceDownloadController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */