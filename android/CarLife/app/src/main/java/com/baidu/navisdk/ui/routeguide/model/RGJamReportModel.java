package com.baidu.navisdk.ui.routeguide.model;

import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMNotificationBaseView.NotificationDisplayListener;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView.NotificationClickListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.UserOPController;

public class RGJamReportModel
{
  private static final String TAG = RGJamReportModel.class.getSimpleName();
  public static final int TIME_AUTO_HIDE = 10000;
  private boolean hasJamReportShown = false;
  private boolean isJamming = false;
  public boolean isViewCanShow = false;
  
  public static RGJamReportModel getInstance()
  {
    return LazyLoader.sInstance;
  }
  
  private void onConfirmClick(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      UserOPController.getInstance().add("3.u", "4", null, null);
      BNavigator.getInstance().onUGCMenuActionOuter();
      return;
    }
    BNavigator.getInstance().hideJamReport();
  }
  
  public RGMMOperableNotificationView getNotificationView()
  {
    RGMMOperableNotificationView localRGMMOperableNotificationView = RGViewController.getInstance().newOperableNotification(108).setPriority(100).setAutoHideTime(10000).setMainTitleText("路况异常拥堵,上报原因").setSubTitleText("上报帮助其他车友提前避让").setConfirmText("上报").setCancelText("关闭").setShowMasking(true).setOnClick(new RGMMOperableNotificationView.NotificationClickListener()
    {
      public void onAutoHideWithoutClick()
      {
        RGJamReportModel.this.isViewCanShow = false;
        RGJamReportModel.this.onConfirmClick(false);
      }
      
      public void onCancelBtnClick()
      {
        RGJamReportModel.this.isViewCanShow = false;
        RGJamReportModel.this.onConfirmClick(false);
      }
      
      public void onConfirmBtnClick()
      {
        RGJamReportModel.this.isViewCanShow = false;
        RGJamReportModel.this.onConfirmClick(true);
      }
    }).setDisplayListener(new RGMMNotificationBaseView.NotificationDisplayListener()
    {
      public void onHideWithAnim()
      {
        if (RGHighwayModel.getInstance().isSimpleBoardCanShow()) {
          RGViewController.getInstance().showHighWayServiceView();
        }
      }
      
      public void onHideWithOutAnim() {}
      
      public void onShowWithAnim()
      {
        RGViewController.getInstance().hideHighWayServiceView();
      }
      
      public void onShowWithOutAnim()
      {
        RGViewController.getInstance().hideHighWayServiceView();
      }
    });
    localRGMMOperableNotificationView.setNotificationIcon(BNStyleManager.getDrawable(1711408111));
    return localRGMMOperableNotificationView;
  }
  
  public boolean isHasJamReportShown()
  {
    return this.hasJamReportShown;
  }
  
  public boolean isJamming()
  {
    return this.isJamming;
  }
  
  public void setHasJamReportShown(boolean paramBoolean)
  {
    this.hasJamReportShown = paramBoolean;
  }
  
  public void setJamming(boolean paramBoolean)
  {
    this.isJamming = paramBoolean;
  }
  
  public boolean speedCheck(float paramFloat)
  {
    LogUtil.e(TAG, "speedCheck: speed --> " + paramFloat * 3.6D);
    return paramFloat * 3.6D < 20.0D;
  }
  
  private static class LazyLoader
  {
    private static final RGJamReportModel sInstance = new RGJamReportModel(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGJamReportModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */