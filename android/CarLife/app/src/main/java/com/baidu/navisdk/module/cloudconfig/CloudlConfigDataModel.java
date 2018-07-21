package com.baidu.navisdk.module.cloudconfig;

public class CloudlConfigDataModel
{
  private static volatile CloudlConfigDataModel instance = null;
  public boolean isWebDataValid = false;
  public CommonConfig mCommonConfig = null;
  public MultiRoadConfig mMultiRoadConfig = null;
  public RequestBaseDataConfig mRequestBaseDataConfig = null;
  
  public static CloudlConfigDataModel getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new CloudlConfigDataModel();
      }
      return instance;
    }
    finally {}
  }
  
  public void destroy(boolean paramBoolean)
  {
    if (paramBoolean) {
      instance = null;
    }
    while ((this.mMultiRoadConfig != null) || (this.mRequestBaseDataConfig != null)) {
      return;
    }
    instance = null;
  }
  
  public static class CommonConfig
  {
    public String abroadVoice = null;
    public boolean colladaComponentDownload = true;
    public boolean colladaComponentInit = true;
    public int colladaFlag = -1;
    public boolean coreLogRecord = true;
    public String engineStr = null;
    public boolean foregroundService = false;
    public int guidecaseFlag = -1;
    public boolean httpsControl = true;
    public boolean isCarNaviRecording = false;
    public boolean isEyespyPagerOpen = false;
    public boolean isWifiDownload = true;
    public boolean isXmlyOpen = false;
    public String mCastrolYellowIconURL = null;
    public String mCastrolYellowText = null;
    public String mixVoiceIds = null;
    public String safetyIpoIcon = null;
    public String safetyNavIcon = null;
    public String safetyNavNightIcon = null;
    public String safetyNavingIcon = null;
    public boolean safetyNavingShow = false;
    public boolean safetyShow = false;
    public String safetyText = "迎团圆";
    public String switchTips = null;
    public int xdVoice = 0;
  }
  
  public static class MultiRoadConfig
  {
    private int cardShowTime = 20;
    private int lastMile = -1;
    private boolean multiRoadOpenFlag = false;
    private int[] tagDiatanceArr = null;
    
    public MultiRoadConfig(boolean paramBoolean, int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      this.tagDiatanceArr = paramArrayOfInt;
      this.multiRoadOpenFlag = paramBoolean;
      this.cardShowTime = paramInt1;
      this.lastMile = paramInt2;
    }
    
    public void destroy()
    {
      if (CloudlConfigDataModel.instance != null)
      {
        CloudlConfigDataModel.instance.mMultiRoadConfig = null;
        CloudlConfigDataModel.instance.destroy(false);
      }
    }
    
    public int getCardShowTime()
    {
      return this.cardShowTime;
    }
    
    public int getLastMile()
    {
      return this.lastMile;
    }
    
    public int[] getTagDistance()
    {
      return this.tagDiatanceArr;
    }
    
    public boolean isMultiRoadOpen()
    {
      return this.multiRoadOpenFlag;
    }
  }
  
  public static class RequestBaseDataConfig
  {
    private String etag = null;
    private long serReqTime = 0L;
    
    public RequestBaseDataConfig(String paramString, long paramLong)
    {
      this.etag = paramString;
      this.serReqTime = paramLong;
    }
    
    public void destroy()
    {
      if (CloudlConfigDataModel.instance != null)
      {
        CloudlConfigDataModel.instance.mRequestBaseDataConfig = null;
        CloudlConfigDataModel.instance.destroy(false);
      }
    }
    
    public String getEtag()
    {
      return this.etag;
    }
    
    public long getSerReqTime()
    {
      return this.serReqTime;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/cloudconfig/CloudlConfigDataModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */