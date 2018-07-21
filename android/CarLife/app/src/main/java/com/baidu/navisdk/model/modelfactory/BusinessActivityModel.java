package com.baidu.navisdk.model.modelfactory;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class BusinessActivityModel
{
  public static final int MAX_DIST_FROM_NEXT_TURN = 50;
  public static final int MIN_NAVI_DIST = 200;
  public static final int PARKING_MAX_SPEED = 3;
  public static final int PARKING_MIN_TIME = 5000;
  public static final int TRAFFICJAM_MAX_SPEED = 20;
  public static final int TRAFFICJAM_MIN_DIST = 10;
  public int aid = -1;
  public int anum = 0;
  public int atype = -1;
  public Bitmap bannerBitmap = null;
  public String bannerLink = null;
  public String compensationLink = null;
  public String compensationTitle = null;
  public String detailsLink = null;
  public int envelopeAnim = 0;
  public int envelopeDist = -1;
  public int envelopeId = -1;
  public String envelopePicBtnClicked = null;
  public Bitmap envelopePicBtnClickedBitmap = null;
  public String envelopePicBtnNormal = null;
  public Bitmap envelopePicBtnNormalBitmap = null;
  public String envelopePicMid = null;
  public Bitmap envelopePicMidBitmap = null;
  public String envelopePicPlus = null;
  public Bitmap envelopePicPlusBitmap = null;
  public String envelopePicWindowBG = null;
  public Bitmap envelopePicWindowBGBitmap = null;
  public int envelopeSNum = -1;
  public int envelopeShowTimes = 0;
  public String envelopeSoundEffectLink = null;
  public String envelopeSoundEffectPath = null;
  public String envelopeUnit = "";
  public String envelopeWindowBtnColor = null;
  public String envelopeWindowBtnTextColor = null;
  public String errmsg = null;
  public int errno = -1;
  public int hasClickActivityCount = 0;
  public boolean hasRequestedBusinessData = false;
  public int hasShowActivityCount = 0;
  public boolean isNeedUploadDataFromLocal = true;
  public boolean isOpen = false;
  public boolean isParking = false;
  public boolean isPrizeReceived = false;
  public int isShowUserRight = 0;
  public boolean isTrafficJam = false;
  public int lastRoadConditionItemIndex = -1;
  public Bitmap logoBitmap = null;
  public String logoLink = null;
  public String mCastrolFastRouteIconURL = null;
  public String mCastrolFastRouteText = null;
  public boolean mIsShowVoiceNotificaiton = false;
  public int mVoiceAutoHideTime = 5000;
  public String mVoiceDetailURL = null;
  public String mVoiceIconURL = null;
  public String mVoiceMainTitle = null;
  public int mVoiceShowTime = 1;
  public String mVoiceSubTitle = null;
  public String mVoiceTaskId = null;
  public ArrayList<NaviEndPrivilege> naviEndPrivilegesList = new ArrayList();
  public String naviendClickTips = null;
  public String naviendClickTipsColor = null;
  public int naviendID = -1;
  public String naviendLink = null;
  public int naviendNeedUpload = 0;
  public boolean naviendOpen = false;
  public Bitmap naviendPicBitmap = null;
  public String naviendPicLink = null;
  public String naviendTips = null;
  public int operationActivityId = -1;
  public String operationActivityLink = null;
  public Bitmap operationActivityLogoBitmap = null;
  public String operationActivityLogoLink = null;
  public int operationActivityTime = -1;
  public long parkingStartTime = -1L;
  public Bitmap riconBitmap = null;
  public String riconLink = null;
  public int rnum = 0;
  public int rtime = 0;
  public String rtips = null;
  public String rtitle = null;
  public String ruid = null;
  public String session = null;
  public String shareContentLink = null;
  public String shareDesc = null;
  public Bitmap sharePicBitmap = null;
  public String sharePicLink = null;
  public int shareRespErrNo = -1;
  public String shareRespMsg = null;
  public String shareRespTips = null;
  public String shareTitle = null;
  public int showTime = 0;
  public int showType = -1;
  public String showVoiceLink = null;
  public String showVoicePath = null;
  public String showVoiceText = null;
  public int timestamp = -1;
  public String title = null;
  public Bundle uploadBundleData = null;
  public Bundle uploadBundleDataForNaving = null;
  public int uploadMileageInter = -1;
  public String uploadRespClickTips = null;
  public int uploadRespErrNo = -1;
  public int uploadRespErrNoForNaving = -1;
  public String uploadRespMsg = null;
  public String uploadRespMsgForNaving = null;
  public String uploadRespTips = null;
  public String uploadRespTipsForNaving = null;
  public String userDisTips = null;
  public int userHistoryMileas = 0;
  public Bitmap userPerCarLogoBitmap = null;
  public String userPerCarLogoLink = null;
  public String userRightEnterLink = null;
  public String userRightEnterTips = null;
  public Bitmap userRightIconBitmapEnd = null;
  public String userRightIconLinkEnd = null;
  public String userRightTipsEnd = null;
  public String userRightTitleEnd = null;
  public int userRightUpgradeFrom = -1;
  public String userRightUpgradeTips = null;
  public int userRightUpgradeTo = -1;
  public String voiceLinkOnEndNavi = null;
  public String voiceLinkOnStartNavi = null;
  public String voicePathOnEndNavi = null;
  public String voicePathOnStartNavi = null;
  public int voicePriorityOnEndNavi = 2;
  public int voicePriorityOnStartNavi = 2;
  public String voiceTextOnEndNavi = null;
  public String voiceTextOnStartNavi = null;
  public int yellowBanner = 0;
  
  private void saveBitmap(Bitmap paramBitmap, String paramString)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramString = new File(paramString);
    paramString.deleteOnExit();
    try
    {
      paramString.createNewFile();
      paramString = new FileOutputStream(paramString);
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 50, paramString);
      paramString.flush();
      paramString.close();
      return;
    }
    catch (Exception paramBitmap) {}
  }
  
  public void clear()
  {
    this.errno = -1;
    this.errmsg = null;
    this.voiceTextOnStartNavi = null;
    this.voiceLinkOnStartNavi = null;
    this.voicePriorityOnStartNavi = 2;
    this.voiceTextOnEndNavi = null;
    this.voiceLinkOnEndNavi = null;
    this.voicePriorityOnEndNavi = 2;
    this.isOpen = false;
    this.aid = -1;
    this.title = null;
    this.logoLink = null;
    this.bannerLink = null;
    this.detailsLink = null;
    this.showType = -1;
    this.showTime = 0;
    this.showVoiceText = null;
    this.showVoiceLink = null;
    this.session = null;
    this.ruid = null;
    this.rtitle = null;
    this.riconLink = null;
    this.rtips = null;
    this.rtime = 0;
    this.anum = 0;
    this.rnum = 0;
    this.hasShowActivityCount = 0;
    this.isPrizeReceived = false;
    this.naviendID = -1;
    this.naviendOpen = false;
    this.naviendNeedUpload = 0;
    this.naviendPicLink = null;
    this.naviendTips = null;
    this.naviendLink = null;
    this.envelopeId = -1;
    this.envelopePicBtnNormal = null;
    this.envelopePicBtnClicked = null;
    this.envelopePicMid = null;
    this.envelopePicWindowBG = null;
    this.envelopePicPlus = null;
    this.envelopePicBtnNormalBitmap = null;
    this.envelopePicBtnClickedBitmap = null;
    this.envelopePicMidBitmap = null;
    this.envelopePicWindowBGBitmap = null;
    this.envelopePicPlusBitmap = null;
    this.envelopeWindowBtnColor = null;
    this.envelopeWindowBtnTextColor = null;
    this.envelopeShowTimes = 0;
    this.envelopeSoundEffectLink = null;
    this.envelopeSoundEffectPath = null;
    this.envelopeDist = -1;
    this.envelopeAnim = 0;
    this.envelopeSNum = -1;
    this.envelopeUnit = "";
    this.uploadBundleData = null;
    this.uploadRespErrNo = -1;
    this.uploadRespMsg = null;
    this.uploadRespTips = null;
    this.uploadRespClickTips = null;
    this.isTrafficJam = false;
    this.lastRoadConditionItemIndex = -1;
    this.isParking = false;
    this.parkingStartTime = -1L;
    this.userPerCarLogoLink = null;
    this.userHistoryMileas = 0;
    this.userDisTips = null;
    this.userRightUpgradeTips = null;
    this.uploadMileageInter = -1;
    this.compensationTitle = null;
    this.compensationLink = null;
    this.operationActivityId = -1;
    this.operationActivityLogoLink = null;
    this.operationActivityLink = null;
    this.operationActivityTime = -1;
    this.userRightTitleEnd = null;
    this.userRightIconLinkEnd = null;
    this.userRightTipsEnd = null;
    this.userRightEnterTips = null;
    this.userRightEnterLink = null;
    this.userRightUpgradeFrom = -1;
    this.userRightUpgradeTo = -1;
    this.yellowBanner = 0;
    this.uploadBundleDataForNaving = null;
    this.uploadRespErrNoForNaving = -1;
    this.uploadRespMsgForNaving = null;
    this.uploadRespTipsForNaving = null;
    this.shareTitle = null;
    this.sharePicLink = null;
    this.shareContentLink = null;
    this.shareDesc = null;
    this.mCastrolFastRouteIconURL = null;
    this.mCastrolFastRouteText = null;
    this.mIsShowVoiceNotificaiton = false;
    this.mVoiceDetailURL = null;
    this.mVoiceIconURL = null;
    this.mVoiceMainTitle = null;
    this.mVoiceSubTitle = null;
    this.mVoiceTaskId = null;
    this.mVoiceAutoHideTime = 5000;
    this.mVoiceShowTime = 1;
    this.naviEndPrivilegesList.clear();
    try
    {
      if ((this.logoBitmap != null) && (!this.logoBitmap.isRecycled())) {
        this.logoBitmap.recycle();
      }
      this.logoBitmap = null;
      if ((this.bannerBitmap != null) && (!this.bannerBitmap.isRecycled())) {
        this.bannerBitmap.recycle();
      }
      this.bannerBitmap = null;
      if ((this.riconBitmap != null) && (!this.riconBitmap.isRecycled())) {
        this.riconBitmap.recycle();
      }
      this.riconBitmap = null;
      if ((this.naviendPicBitmap != null) && (!this.naviendPicBitmap.isRecycled())) {
        this.naviendPicBitmap.recycle();
      }
      this.naviendPicBitmap = null;
      if ((this.userPerCarLogoBitmap != null) && (!this.userPerCarLogoBitmap.isRecycled())) {
        this.userPerCarLogoBitmap.recycle();
      }
      this.userPerCarLogoBitmap = null;
      if ((this.operationActivityLogoBitmap != null) && (!this.operationActivityLogoBitmap.isRecycled())) {
        this.operationActivityLogoBitmap.recycle();
      }
      this.operationActivityLogoBitmap = null;
      if ((this.userRightIconBitmapEnd != null) && (!this.userRightIconBitmapEnd.isRecycled())) {
        this.userRightIconBitmapEnd.recycle();
      }
      this.userRightIconBitmapEnd = null;
      if ((this.sharePicBitmap != null) && (!this.sharePicBitmap.isRecycled())) {
        this.sharePicBitmap.recycle();
      }
      this.sharePicBitmap = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      this.logoBitmap = null;
      this.bannerBitmap = null;
      this.riconBitmap = null;
      this.naviendPicBitmap = null;
      this.userPerCarLogoBitmap = null;
      this.operationActivityLogoBitmap = null;
      this.userRightIconBitmapEnd = null;
      this.sharePicBitmap = null;
    }
  }
  
  public boolean isEnvelopeEnabled()
  {
    return this.envelopeId > -1;
  }
  
  public boolean isNeedUpload()
  {
    return (1 == this.naviendNeedUpload) || ((2 == this.naviendNeedUpload) && (this.isPrizeReceived));
  }
  
  public boolean isParkingEnabled()
  {
    return (this.showType == 2) || (this.showType == 3);
  }
  
  public boolean isTrafficJamEnabled()
  {
    return (this.showType == 1) || (this.showType == 3);
  }
  
  public boolean isUploadDataContainsValidBduss()
  {
    return (this.uploadBundleData != null) && (this.uploadBundleData.containsKey("pcBduss")) && (!TextUtils.isEmpty(this.uploadBundleData.getString("pcBduss")));
  }
  
  public boolean isUploadDataContainsValidBdussoForNaving()
  {
    return (this.uploadBundleDataForNaving != null) && (this.uploadBundleDataForNaving.containsKey("pcBduss")) && (!TextUtils.isEmpty(this.uploadBundleDataForNaving.getString("pcBduss")));
  }
  
  public void releaseResOnQuitNavi()
  {
    try
    {
      if ((this.logoBitmap != null) && (!this.logoBitmap.isRecycled())) {
        this.logoBitmap.recycle();
      }
      this.logoBitmap = null;
      if ((this.bannerBitmap != null) && (!this.bannerBitmap.isRecycled())) {
        this.bannerBitmap.recycle();
      }
      this.bannerBitmap = null;
      if ((this.riconBitmap != null) && (!this.riconBitmap.isRecycled())) {
        this.riconBitmap.recycle();
      }
      this.riconBitmap = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      this.logoBitmap = null;
      this.bannerBitmap = null;
      this.riconBitmap = null;
    }
  }
  
  public void resetParking()
  {
    this.isParking = false;
    this.parkingStartTime = -1L;
    LogUtil.e(BusinessActivityManager.TAG, "resetParking() ");
  }
  
  public void resetTrafficJam()
  {
    this.isTrafficJam = false;
    LogUtil.e(BusinessActivityManager.TAG, "resetTrafficJam() ");
  }
  
  public void testSaveBitmap()
  {
    try
    {
      if ((this.logoBitmap != null) && (!this.logoBitmap.isRecycled())) {
        saveBitmap(this.logoBitmap, SysOSAPI.getInstance().GetSDCardPath() + File.separator + "log/navi_logo.jpg");
      }
      if ((this.bannerBitmap != null) && (!this.bannerBitmap.isRecycled())) {
        saveBitmap(this.bannerBitmap, SysOSAPI.getInstance().GetSDCardPath() + File.separator + "log/navi_banner.jpg");
      }
      if ((this.riconBitmap != null) && (!this.riconBitmap.isRecycled())) {
        saveBitmap(this.riconBitmap, SysOSAPI.getInstance().GetSDCardPath() + File.separator + "log/navi_ricon.jpg");
      }
      if ((this.naviendPicBitmap != null) && (!this.naviendPicBitmap.isRecycled())) {
        saveBitmap(this.naviendPicBitmap, SysOSAPI.getInstance().GetSDCardPath() + File.separator + "log/navi_naviendpic.jpg");
      }
      if ((this.envelopePicBtnNormalBitmap != null) && (!this.envelopePicBtnNormalBitmap.isRecycled())) {
        saveBitmap(this.envelopePicBtnNormalBitmap, SysOSAPI.getInstance().GetSDCardPath() + File.separator + "log/navi_envelopePicBtnNormalBitmap.jpg");
      }
      if ((this.envelopePicBtnClickedBitmap != null) && (!this.envelopePicBtnClickedBitmap.isRecycled())) {
        saveBitmap(this.envelopePicBtnClickedBitmap, SysOSAPI.getInstance().GetSDCardPath() + File.separator + "log/navi_envelopePicBtnClickedBitmap.jpg");
      }
      if ((this.envelopePicMidBitmap != null) && (!this.envelopePicMidBitmap.isRecycled())) {
        saveBitmap(this.envelopePicMidBitmap, SysOSAPI.getInstance().GetSDCardPath() + File.separator + "log/navi_envelopePicMidBitmap.jpg");
      }
      if ((this.envelopePicPlusBitmap != null) && (!this.envelopePicPlusBitmap.isRecycled())) {
        saveBitmap(this.envelopePicPlusBitmap, SysOSAPI.getInstance().GetSDCardPath() + File.separator + "log/navi_envelopePicPlusBitmap.jpg");
      }
      if ((this.envelopePicWindowBGBitmap != null) && (!this.envelopePicWindowBGBitmap.isRecycled())) {
        saveBitmap(this.envelopePicWindowBGBitmap, SysOSAPI.getInstance().GetSDCardPath() + File.separator + "log/navi_envelopePicWindowBGBitmap.jpg");
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public static class NaviEndPrivilege
  {
    public String cardType;
    public String hicon;
    public String hint;
    public String hlink;
    public String[] list;
    public String tip;
    public int unlock;
    
    public String toString()
    {
      Object localObject1 = "";
      Object localObject2 = localObject1;
      if (this.list != null)
      {
        int i = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (i >= this.list.length) {
            break;
          }
          localObject2 = (String)localObject1 + this.list[i];
          localObject1 = localObject2;
          if (i < this.list.length - 1) {
            localObject1 = (String)localObject2 + ", ";
          }
          i += 1;
        }
      }
      return "cardType: " + this.cardType + ", hint: " + this.hint + ", unlock: " + this.unlock + ", tip: " + this.tip + ", hlink: " + this.hlink + ", hicon: " + this.hicon + ", list: " + (String)localObject2;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/modelfactory/BusinessActivityModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */