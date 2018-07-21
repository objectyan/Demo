package com.baidu.navisdk.ui.routeguide.model;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.modelfactory.BusinessActivityModel;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.MultiRoadConfig;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMNotificationBaseView.NotificationDisplayListener;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView.NotificationClickListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.navimageloader.BNDisplayImageOptions.Builder;
import com.baidu.navisdk.util.statistic.userop.UserOPController;

public class RGRouteRecommendModel
{
  public static final int MSG_AUTO_HIDE = 0;
  private static final String TAG = "RGRouteRecommendModel";
  public static final int TIME_AUTO_HIDE = 20000;
  private static RGRouteRecommendModel sInstance = null;
  private RGMMNotificationBaseView.NotificationDisplayListener displayListener = new RGMMNotificationBaseView.NotificationDisplayListener()
  {
    public void onHideWithAnim()
    {
      if (RGHighwayModel.getInstance().isSimpleBoardCanShow()) {
        RGViewController.getInstance().showHighWayServiceView();
      }
      if (RGRouteRecommendModel.this.mVoiceBroadType == 1)
      {
        LogUtil.e("XDVoice", "showRouteRecommend end , xdEnable(true)");
        XDVoiceInstructManager.getInstance().setWakeupEnable(true);
        XDVoiceInstructManager.getInstance().resetLastInstrut();
        XDVoiceInstructManager.getInstance().onStop();
      }
    }
    
    public void onHideWithOutAnim()
    {
      if (RGRouteRecommendModel.this.mVoiceBroadType == 1)
      {
        XDVoiceInstructManager.getInstance().setWakeupEnable(true);
        XDVoiceInstructManager.getInstance().resetLastInstrut();
        XDVoiceInstructManager.getInstance().onStop();
      }
    }
    
    public void onShowWithAnim()
    {
      RGViewController.getInstance().hideHighWayServiceView();
      if (RGRouteRecommendModel.this.mVoiceBroadType == 1) {
        XDVoiceInstructManager.getInstance().onStart();
      }
    }
    
    public void onShowWithOutAnim()
    {
      RGViewController.getInstance().hideHighWayServiceView();
      if (RGRouteRecommendModel.this.mVoiceBroadType == 1) {
        XDVoiceInstructManager.getInstance().onStart();
      }
    }
  };
  public boolean isViewCanShow = false;
  private String mContent = null;
  private int mDisplayDuration = 0;
  private int mIconId = 0;
  private String mInfoId = null;
  private int mPattern = 0;
  private int mPushType = -1;
  private int mRouteId = 0;
  private String mSubContent = null;
  private int mSubType = -1;
  public int mUpdateRouteSource = 0;
  private int mVoiceBroadType = -1;
  private String mVoiceContent = null;
  
  public static RGRouteRecommendModel getInstance()
  {
    if (sInstance == null) {
      sInstance = new RGRouteRecommendModel();
    }
    return sInstance;
  }
  
  private RGMMOperableNotificationView getRouteSwitchNotificationView()
  {
    Object localObject2 = this.mContent;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    String str1 = this.mSubContent;
    localObject2 = str1;
    if (str1 == null) {
      localObject2 = "";
    }
    localObject2 = RGViewController.getInstance().newOperableNotification(103).setPriority(100).setAutoHideTime(getInstance().getAutoHideTime()).setSubTitleText((String)localObject2).setConfirmText(BNStyleManager.getString(1711670303)).setCancelText(BNStyleManager.getString(1711670304)).setShowMasking(true).setOnClick(new RGMMOperableNotificationView.NotificationClickListener()
    {
      public void onAutoHideWithoutClick()
      {
        RGRouteRecommendModel.getInstance().isViewCanShow = false;
        BNavigator.getInstance().actionRouteRecommendClick(false, false);
      }
      
      public void onCancelBtnClick()
      {
        RGRouteRecommendModel.getInstance().isViewCanShow = false;
        BNavigator.getInstance().actionRouteRecommendClick(false, false);
      }
      
      public void onConfirmBtnClick()
      {
        RGRouteRecommendModel.getInstance().isViewCanShow = false;
        BNavigator.getInstance().actionRouteRecommendClick(true, false);
      }
    }).setDisplayListener(this.displayListener);
    if (TextUtils.isEmpty(this.mSubContent)) {
      ((RGMMOperableNotificationView)localObject2).setMainTitleLine(2);
    }
    str1 = BusinessActivityManager.getInstance().getModel().mCastrolFastRouteIconURL;
    String str2 = BusinessActivityManager.getInstance().getModel().mCastrolFastRouteText;
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      UserOPController.getInstance().add("3.s.6", "" + this.mPushType, "1", this.mUpdateRouteSource + "");
      ((RGMMOperableNotificationView)localObject2).setNotificationIcon(str1, new BNDisplayImageOptions.Builder().showImageOnLoading(1711407997).build(), null).setMainTitleText(str2 + (String)localObject1);
    }
    do
    {
      return (RGMMOperableNotificationView)localObject2;
      UserOPController.getInstance().add("3.s.6", "" + this.mPushType, "0", this.mUpdateRouteSource + "");
      ((RGMMOperableNotificationView)localObject2).setNotificationIcon(BNStyleManager.getDrawable(1711407997)).setMainTitleText((String)localObject1);
      localObject1 = ((RGMMOperableNotificationView)localObject2).getNotificationIcon();
    } while (localObject1 == null);
    ((ImageView)localObject1).setTag(Integer.valueOf(1711407997));
    return (RGMMOperableNotificationView)localObject2;
  }
  
  private void parseRouteInfo(Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("parseRouteInfo: bundle --> ");
    if (paramBundle == null) {}
    for (String str = "null";; str = paramBundle.toString())
    {
      LogUtil.e("RGRouteRecommendModel", str);
      if (paramBundle != null) {
        break;
      }
      reset();
      return;
    }
    this.mIconId = paramBundle.getInt("nIconID");
    this.mPattern = paramBundle.getInt("nPattern");
    this.mDisplayDuration = paramBundle.getInt("nDisplayDuation");
    this.mContent = paramBundle.getString("usContent");
    this.mSubContent = paramBundle.getString("usSubContent");
    this.mVoiceContent = paramBundle.getString("usVoiceContent");
    this.mInfoId = paramBundle.getString("usInfoID");
    this.mVoiceBroadType = paramBundle.getInt("enVoiceBroadType");
    this.mPushType = paramBundle.getInt("enPushType");
    this.mUpdateRouteSource = paramBundle.getInt("enUpdateRouteSource");
  }
  
  public int getAutoHideTime()
  {
    int j = 20000;
    CloudlConfigDataModel.MultiRoadConfig localMultiRoadConfig = CloudlConfigDataModel.getInstance().mMultiRoadConfig;
    int i = j;
    if (localMultiRoadConfig != null)
    {
      int k = localMultiRoadConfig.getCardShowTime();
      i = j;
      if (k > 0) {
        i = k * 1000;
      }
    }
    return i;
  }
  
  public RGMMOperableNotificationView getNotificationView()
  {
    switch (this.mSubType)
    {
    default: 
      return null;
    case 7: 
    case 13: 
      return getRouteSwitchNotificationView();
    }
    return getUGCEventNotificationView();
  }
  
  public RGMMOperableNotificationView getUGCEventNotificationView()
  {
    int j = -1;
    RGMMOperableNotificationView localRGMMOperableNotificationView;
    switch (this.mSubType)
    {
    default: 
      localRGMMOperableNotificationView = RGViewController.getInstance().newOperableNotification(107).setPriority(100).setAutoHideTime(getAutoHideTime()).setConfirmText("查看详情").setCancelText(BNStyleManager.getString(1711670304)).setShowMasking(true).setOnClick(new RGMMOperableNotificationView.NotificationClickListener()
      {
        public void onAutoHideWithoutClick()
        {
          RGRouteRecommendModel.this.isViewCanShow = false;
          RGNotificationController.getInstance().hideOperableView(103);
          BNavigator.getInstance().enterNavState();
          JNIGuidanceControl.getInstance().setShowRouteChoose(2);
        }
        
        public void onCancelBtnClick()
        {
          RGRouteRecommendModel.this.isViewCanShow = false;
          RGNotificationController.getInstance().hideOperableView(103);
          BNavigator.getInstance().enterNavState();
          JNIGuidanceControl.getInstance().setShowRouteChoose(2);
          UserOPController.getInstance().add("3.s.7", "" + RGRouteRecommendModel.this.mPushType, "1", "" + RGRouteRecommendModel.this.mUpdateRouteSource);
        }
        
        public void onConfirmBtnClick()
        {
          RGRouteRecommendModel.this.isViewCanShow = false;
          BNavigator.getInstance().showUgcDetailViewSource(RGRouteRecommendModel.this.mInfoId, true, 4);
          UserOPController.getInstance().add("3.s.7", "" + RGRouteRecommendModel.this.mPushType, "5", "" + RGRouteRecommendModel.this.mUpdateRouteSource);
        }
      }).setDisplayListener(this.displayListener);
      if (j != -1)
      {
        localRGMMOperableNotificationView.setNotificationIcon(BNStyleManager.getDrawable(j));
        localRGMMOperableNotificationView.showNotificationIcon(true);
      }
      break;
    }
    for (;;)
    {
      if (TextUtils.isEmpty(this.mSubContent)) {
        localRGMMOperableNotificationView.setMainTitleLine(2);
      }
      if (!TextUtils.isEmpty(this.mContent)) {
        localRGMMOperableNotificationView.setMainTitleText(this.mContent);
      }
      if (!TextUtils.isEmpty(this.mSubContent)) {
        localRGMMOperableNotificationView.setSubTitleText(this.mSubContent);
      }
      UserOPController.getInstance().add("3.s.6", "" + this.mPushType, "0", this.mUpdateRouteSource + "");
      return localRGMMOperableNotificationView;
      int k = -1;
      int i = k;
      switch (this.mIconId)
      {
      default: 
        i = k;
      }
      while (i != -1)
      {
        j = UgcDataProvider.getDrawableIdByType(i);
        break;
        i = 4;
        continue;
        i = 5;
        continue;
        i = 6;
        continue;
        i = 7;
        continue;
        i = 8;
        continue;
        i = 9;
        continue;
        i = 10;
      }
      localRGMMOperableNotificationView.showNotificationIcon(false);
    }
  }
  
  public String getmContent()
  {
    return this.mContent;
  }
  
  public int getmDisplayDuration()
  {
    return this.mDisplayDuration;
  }
  
  public int getmIconId()
  {
    return this.mIconId;
  }
  
  public String getmInfoId()
  {
    return this.mInfoId;
  }
  
  public int getmPattern()
  {
    return this.mPattern;
  }
  
  public int getmPushType()
  {
    return this.mPushType;
  }
  
  public int getmRouteId()
  {
    return this.mRouteId;
  }
  
  public String getmSubContent()
  {
    return this.mSubContent;
  }
  
  public int getmSubType()
  {
    return this.mSubType;
  }
  
  public int getmVoiceBroadType()
  {
    return this.mVoiceBroadType;
  }
  
  public String getmVoiceContent()
  {
    return this.mVoiceContent;
  }
  
  public boolean isParamsCorrect()
  {
    if ((!TextUtils.isEmpty(this.mContent)) || (!TextUtils.isEmpty(this.mSubContent))) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        LogUtil.e("RGRouteRecommendModel", "isParamsCorrect: fail --> mContent: " + this.mContent + ", mSubContent: " + this.mSubContent);
      }
      return bool;
    }
  }
  
  public void reset()
  {
    LogUtil.e("RGRouteRecommendModel", "reset:  --> ");
    this.mInfoId = null;
    this.mIconId = 0;
    this.mContent = null;
    this.mSubContent = null;
    this.mDisplayDuration = 0;
    this.mVoiceContent = null;
    this.mPattern = 0;
    this.mVoiceBroadType = -1;
    this.mPushType = -1;
  }
  
  public void setmContent(String paramString)
  {
    this.mContent = paramString;
  }
  
  public void setmDisplayDuration(int paramInt)
  {
    this.mDisplayDuration = paramInt;
  }
  
  public void setmIconId(int paramInt)
  {
    this.mIconId = paramInt;
  }
  
  public void setmInfoId(String paramString)
  {
    this.mInfoId = paramString;
  }
  
  public void setmPattern(int paramInt)
  {
    this.mPattern = paramInt;
  }
  
  public void setmPushType(int paramInt)
  {
    this.mPushType = paramInt;
  }
  
  public void setmRouteId(int paramInt)
  {
    this.mRouteId = paramInt;
  }
  
  public void setmSubContent(String paramString)
  {
    this.mSubContent = paramString;
  }
  
  public void setmSubType(int paramInt)
  {
    this.mSubType = paramInt;
  }
  
  public void setmVoiceBroadType(int paramInt)
  {
    this.mVoiceBroadType = paramInt;
  }
  
  public void setmVoiceContent(String paramString)
  {
    this.mVoiceContent = paramString;
  }
  
  public void updateEngineNotificationData()
  {
    LogUtil.e("RGRouteRecommendModel", "updateEngineNotificationData: mSubType --> " + this.mSubType);
    int j = 0;
    int i = j;
    switch (this.mSubType)
    {
    }
    for (i = j;; i = 1)
    {
      Bundle localBundle = new Bundle();
      if (!BNRouteGuider.getInstance().getRouteInfoInUniform(i, localBundle)) {
        break;
      }
      parseRouteInfo(localBundle);
      return;
    }
    reset();
  }
  
  public static class RouteInfoType
  {
    public static final int TYPE_DYNAMIC_INFO = 1;
    public static final int TYPE_GET_START_BID = 2;
    public static final int TYPE_INVALID = 0;
  }
  
  public static class RouteVoiceBroadType
  {
    public static final int NE_VoiceBroad_ByClient = 1;
    public static final int NE_VoiceBroad_ByGuide = 2;
    public static final int NE_VoiceBroad_Invalid = -1;
    public static final int NE_VoiceBroad_NoVoice = 0;
  }
  
  public static class UpdateRouteSourceType
  {
    public static final int Invalid = 0;
    public static final int RefRouteByAtjVoice = 1;
    public static final int RefRouteByFastRouteVoice = 2;
    public static final int UpdateRouteByButton = 4;
    public static final int UpdateRouteByDetailPanel = 3;
    public static final int UpdateRouteCondition = 5;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGRouteRecommendModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */