package com.baidu.navisdk.model.datastruct;

import com.baidu.navisdk.util.common.StringUtils;

public class OfflineDataInfo
{
  public boolean isFakeUpdate = false;
  public String mDownloadRatio = "";
  public int mDownloadSize;
  public int mDownloadUpSize;
  public String mFistLetters;
  public boolean mIsChecked = false;
  public boolean mIsNewVer = false;
  public boolean mIsRequest = false;
  public boolean mIsSuspendByNetChange = false;
  public boolean mIsSuspendByPhoneChange = false;
  public String mName;
  public int mProgress;
  public int mProgressBy10;
  public int mProvinceId;
  public int mSize;
  public int mStatus;
  public int mStatusColor;
  public String mStatusTips;
  public String mStrSize;
  public int mTaskStatus;
  public int mUpProgress;
  public int mUpProgressBy10;
  public int mUpSize;
  public String mUpdateRatio = "";
  
  public OfflineDataInfo() {}
  
  public OfflineDataInfo(OfflineDataInfo paramOfflineDataInfo)
  {
    if (paramOfflineDataInfo == null) {
      return;
    }
    this.mName = paramOfflineDataInfo.mName;
    this.mProvinceId = paramOfflineDataInfo.mProvinceId;
    this.mStatus = paramOfflineDataInfo.mStatus;
    this.mSize = paramOfflineDataInfo.mSize;
    this.mProgress = paramOfflineDataInfo.mProgress;
    this.mTaskStatus = paramOfflineDataInfo.mTaskStatus;
    this.mStatusColor = paramOfflineDataInfo.mStatusColor;
    this.mStatusTips = paramOfflineDataInfo.mStatusTips;
    this.mStrSize = paramOfflineDataInfo.mStrSize;
    this.mIsChecked = paramOfflineDataInfo.mIsChecked;
    this.mIsNewVer = paramOfflineDataInfo.mIsNewVer;
    this.mFistLetters = paramOfflineDataInfo.mFistLetters;
    this.mUpSize = paramOfflineDataInfo.mUpSize;
    this.mUpProgress = paramOfflineDataInfo.mUpProgress;
    this.mIsRequest = paramOfflineDataInfo.mIsRequest;
    this.mDownloadRatio = paramOfflineDataInfo.mDownloadRatio;
    this.mUpdateRatio = paramOfflineDataInfo.mUpdateRatio;
    this.mDownloadSize = paramOfflineDataInfo.mDownloadSize;
    this.mDownloadUpSize = paramOfflineDataInfo.mDownloadUpSize;
    this.mUpProgressBy10 = paramOfflineDataInfo.mUpProgressBy10;
    this.mProgressBy10 = paramOfflineDataInfo.mProgressBy10;
  }
  
  public void copy(OfflineDataInfo paramOfflineDataInfo)
  {
    if (paramOfflineDataInfo == null) {
      return;
    }
    this.mName = paramOfflineDataInfo.mName;
    this.mProvinceId = paramOfflineDataInfo.mProvinceId;
    this.mStatus = paramOfflineDataInfo.mStatus;
    this.mSize = paramOfflineDataInfo.mSize;
    this.mProgress = paramOfflineDataInfo.mProgress;
    this.mTaskStatus = paramOfflineDataInfo.mTaskStatus;
    this.mStatusColor = paramOfflineDataInfo.mStatusColor;
    this.mStatusTips = paramOfflineDataInfo.mStatusTips;
    this.mStrSize = paramOfflineDataInfo.mStrSize;
    this.mIsChecked = paramOfflineDataInfo.mIsChecked;
    this.mIsNewVer = paramOfflineDataInfo.mIsNewVer;
    this.mFistLetters = paramOfflineDataInfo.mFistLetters;
    this.mUpSize = paramOfflineDataInfo.mUpSize;
    this.mUpProgress = paramOfflineDataInfo.mUpProgress;
    this.mIsRequest = paramOfflineDataInfo.mIsRequest;
    this.mDownloadRatio = paramOfflineDataInfo.mDownloadRatio;
    this.mUpdateRatio = paramOfflineDataInfo.mUpdateRatio;
    this.mDownloadSize = paramOfflineDataInfo.mDownloadSize;
    this.mDownloadUpSize = paramOfflineDataInfo.mDownloadUpSize;
    this.mUpProgressBy10 = paramOfflineDataInfo.mUpProgressBy10;
    this.mProgressBy10 = paramOfflineDataInfo.mProgressBy10;
  }
  
  public void formatStatusTips()
  {
    this.mStatusColor = -7879352;
    this.mDownloadUpSize = ((int)(this.mUpSize * (this.mUpProgressBy10 / 1000.0D)));
    Object localObject = StringUtils.ByteSizeToString(this.mDownloadUpSize);
    String str2 = StringUtils.ByteSizeToString(this.mUpSize);
    this.mDownloadSize = ((int)(this.mSize * (this.mProgressBy10 / 1000.0D)));
    String str3 = StringUtils.ByteSizeToString(this.mDownloadSize);
    String str1 = StringUtils.ByteSizeToString(this.mSize);
    this.mDownloadRatio = (str3 + "/" + str1);
    this.mUpdateRatio = ((String)localObject + "/" + str2);
    if (this.mIsNewVer)
    {
      localObject = this.mUpdateRatio;
      switch (this.mTaskStatus)
      {
      case 7: 
      case 14: 
      case 15: 
      case 18: 
      default: 
        this.mStatusTips = "";
      }
    }
    for (;;)
    {
      if (this.mIsRequest)
      {
        this.mStatusTips = "下载请求中...";
        this.mStatusColor = -14375169;
      }
      return;
      localObject = this.mDownloadRatio;
      break;
      this.mStatusTips = str1;
      this.mStatusColor = -9866377;
      continue;
      this.mStatusTips = ("下载中\r\n" + this.mDownloadRatio);
      this.mStatusColor = -14375169;
      continue;
      this.mStatusTips = ("等待下载\r\n" + this.mDownloadRatio);
      this.mStatusColor = -14375169;
      continue;
      this.mStatusTips = ("已暂停\r\n" + this.mDownloadRatio);
      this.mStatusColor = -1658089;
      continue;
      localObject = StringUtils.ByteSizeToString(this.mUpSize);
      if (!this.isFakeUpdate) {}
      for (this.mStatusTips = ("有更新\r\n" + (String)localObject);; this.mStatusTips = "有更新\r\n")
      {
        this.mStatusColor = -7879352;
        break;
      }
      this.mStatusTips = ("等待更新\r\n" + this.mUpdateRatio);
      this.mStatusColor = -14375169;
      continue;
      this.mStatusTips = ("更新中\r\n" + this.mUpdateRatio);
      this.mStatusColor = -14375169;
      continue;
      this.mStatusTips = ("暂停更新\r\n" + this.mUpdateRatio);
      this.mStatusColor = -1658089;
      continue;
      localObject = str1;
      if (this.mUpProgress == 100) {
        localObject = StringUtils.ByteSizeToString(this.mSize);
      }
      this.mStatusTips = ((String)localObject);
      this.mStatusColor = -9866377;
      this.mIsRequest = false;
      continue;
      this.mStatusTips = ("网络异常\r\n" + (String)localObject);
      this.mStatusColor = -1658089;
      continue;
      this.mStatusTips = ("WIFI断开\r\n" + (String)localObject);
      this.mStatusColor = -1658089;
      continue;
      this.mStatusTips = ("SD卡异常\r\n" + (String)localObject);
      this.mStatusColor = -1658089;
      continue;
      this.mStatusTips = "正在准备数据中";
      this.mStatusColor = -14375169;
      continue;
      this.mStatusTips = "等待中";
      this.mStatusColor = -14375169;
      continue;
      this.mStatusTips = "数据更新失败，请重启";
      this.mStatusColor = -1658089;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/datastruct/OfflineDataInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */