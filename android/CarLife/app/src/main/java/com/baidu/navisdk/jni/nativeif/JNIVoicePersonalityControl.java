package com.baidu.navisdk.jni.nativeif;

import android.os.Bundle;
import com.baidu.navisdk.ui.voice.model.OrgVoiceItem;
import com.baidu.navisdk.ui.voice.model.VoiceDataStatus;
import com.baidu.navisdk.ui.voice.model.VoiceInfo;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class JNIVoicePersonalityControl
{
  public static JNIVoicePersonalityControl sInstance = new JNIVoicePersonalityControl();
  
  public native boolean CopyMaiDouPath(String paramString);
  
  public native boolean appendTaskToTaskArray(String paramString, boolean paramBoolean);
  
  public native boolean getDownloadVoiceTask(ArrayList<Bundle> paramArrayList);
  
  public native boolean getRecommendVoiceTask(ArrayList<Bundle> paramArrayList);
  
  public native boolean getRecordVoiceItems(String paramString, ArrayList<Bundle> paramArrayList);
  
  public native String getTaskFilePath(String paramString, boolean paramBoolean);
  
  public native String getTaskFilePathWithWord(String paramString1, String paramString2);
  
  public native boolean getVoiceInfo(String paramString, Bundle paramBundle);
  
  public native boolean isTaskDowned(String paramString, VoiceDataStatus paramVoiceDataStatus);
  
  public ArrayList<VoiceInfo> parseVoiceInfoListBundle(ArrayList<Bundle> paramArrayList)
  {
    LogUtil.e("JNIVoicePersonalityControl", "parseVoiceInfoListBundle size = " + paramArrayList.size());
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        VoiceInfo localVoiceInfo = VoiceInfo.getVoiceInfo((Bundle)paramArrayList.next());
        LogUtil.e("JNIVoicePersonalityControl", "parse info:" + localVoiceInfo.toString());
        localArrayList.add(localVoiceInfo);
      }
    }
    return localArrayList;
  }
  
  public native boolean pauseTask(String paramString);
  
  public native boolean recordVoiceData(ArrayList<OrgVoiceItem> paramArrayList, int paramInt, String paramString);
  
  public boolean removeTask(String paramString)
  {
    return removeTask(paramString, 0);
  }
  
  public native boolean removeTask(String paramString, int paramInt);
  
  public boolean removeUpdateTask(String paramString)
  {
    return removeTask(paramString, 1);
  }
  
  public native boolean resumeTask(String paramString);
  
  public native boolean saveRecordVoiceData(boolean paramBoolean, Bundle paramBundle);
  
  public native boolean updateTaskToServer(String paramString1, String paramString2);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/jni/nativeif/JNIVoicePersonalityControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */