package com.baidu.navisdk.ui.voice.model;

import android.os.Bundle;

public class VoiceInfo
{
  private static final String BUNDLE_VOICEINFO_DOWNLOAD_CNT = "DOWNLOAD_CNT";
  private static final String BUNDLE_VOICEINFO_IMAGE_URL = "IMAGE_URL";
  private static final String BUNDLE_VOICEINFO_NAME = "NAME";
  private static final String BUNDLE_VOICEINFO_SIZE = "SIZE";
  private static final String BUNDLE_VOICEINFO_STATUS = "STATUS";
  private static final String BUNDLE_VOICEINFO_TAG = "TAG";
  private static final String BUNDLE_VOICEINFO_TASKID = "TASKID";
  private static final String BUNDLE_VOICEINFO_VOICE_URL = "VOICE_URL";
  public static final int VOICE_INFO_STATUS_CLOUD_CONFIG = 4;
  public static final int VOICE_INFO_STATUS_DOWNLOAD = 2;
  public static final int VOICE_INFO_STATUS_INVALID = -1;
  public static final int VOICE_INFO_STATUS_LOCAL = 0;
  public static final int VOICE_INFO_STATUS_SYNC = 1;
  public static final int VOICE_INFO_STATUS_UNDOWNLOAD = 3;
  public int downloadCnt = 0;
  public String imageUrl = null;
  public String name = null;
  public long size = 0L;
  public int status = -1;
  public String tag = null;
  public String taskId = null;
  public String voiceUrl = null;
  
  public static VoiceInfo getVoiceInfo(Bundle paramBundle)
  {
    VoiceInfo localVoiceInfo = new VoiceInfo();
    localVoiceInfo.taskId = paramBundle.getString("TASKID");
    localVoiceInfo.size = paramBundle.getLong("SIZE");
    localVoiceInfo.downloadCnt = paramBundle.getInt("DOWNLOAD_CNT");
    localVoiceInfo.status = paramBundle.getInt("STATUS");
    localVoiceInfo.name = paramBundle.getString("NAME");
    localVoiceInfo.tag = paramBundle.getString("TAG");
    localVoiceInfo.voiceUrl = paramBundle.getString("VOICE_URL");
    localVoiceInfo.imageUrl = paramBundle.getString("IMAGE_URL");
    return localVoiceInfo;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof VoiceInfo))
    {
      VoiceInfo localVoiceInfo = (VoiceInfo)paramObject;
      if ((this.taskId != null) && (localVoiceInfo.taskId != null)) {
        return this.taskId.equals(localVoiceInfo.taskId);
      }
    }
    return super.equals(paramObject);
  }
  
  public boolean equals(String paramString)
  {
    if ((paramString != null) && (this.taskId != null)) {
      return this.taskId.equals(paramString);
    }
    return false;
  }
  
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("TASKID", this.taskId);
    localBundle.putLong("SIZE", this.size);
    localBundle.putInt("DOWNLOAD_CNT", this.downloadCnt);
    localBundle.putInt("STATUS", this.status);
    localBundle.putString("NAME", this.name);
    localBundle.putString("TAG", this.tag);
    localBundle.putString("VOICE_URL", this.voiceUrl);
    localBundle.putString("IMAGE_URL", this.imageUrl);
    return localBundle;
  }
  
  public String toString()
  {
    return "[voiceInfo] taskId : " + this.taskId + " size : " + this.size + " downCnt : " + this.downloadCnt + " status : " + this.status + " name : " + this.name + " tag : " + this.tag + " voiceUrl : " + this.voiceUrl + " imageUrl : " + this.imageUrl;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/voice/model/VoiceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */