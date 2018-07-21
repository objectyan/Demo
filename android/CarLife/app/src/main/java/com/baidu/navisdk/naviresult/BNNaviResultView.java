package com.baidu.navisdk.naviresult;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.modelfactory.BusinessActivityModel;
import com.baidu.navisdk.model.modelfactory.BusinessActivityModel.NaviEndPrivilege;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcNaviDynamicMarkRespository;
import com.baidu.navisdk.ui.routeguide.subview.util.RightHandResourcesProvider;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNDialog;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.nplatform.comapi.map.MapGLSurfaceView;
import java.util.ArrayList;
import org.json.JSONObject;

public class BNNaviResultView
{
  private static final int MSG_SHARE_DATA = 291;
  private static final String TAG = BNNaviResultView.class.getSimpleName();
  public static boolean theLastBannerShowTime = false;
  private View achievementsCardZone;
  private TextView achievementsGoalTv;
  private View achievementsRightsEnterIc;
  private TextView achievementsRightsTv;
  private View assuranceView;
  private TextView averageSpeedTv;
  private View back;
  private boolean findViewsFinished = false;
  private ImageView guideIv1;
  private ImageView guideIv2;
  private View guideView1;
  private View guideView2;
  private View historyView;
  private boolean isActivityLogoBitmap = false;
  private boolean isNavigateBack;
  private Activity mActivity;
  private BNMapObserver mBNMapObserver = new BNMapObserver()
  {
    public void update(BNSubject paramAnonymousBNSubject, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
    {
      if ((paramAnonymousInt1 == 1) && (paramAnonymousInt2 == 256)) {
        BNNaviResultView.this.updateMapViewVisibleArea();
      }
    }
  };
  private BNDialog mCompleteReportDialog;
  private Context mContext;
  public boolean mIsMapstart = false;
  private RelativeLayout mMapParentView;
  private MapGLSurfaceView mNMapView;
  private Handler mShareHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      boolean bool2;
      label197:
      RspData localRspData;
      do
      {
        return;
        if ((BusinessActivityManager.getInstance().getModel().shareRespErrNo == 0) && (!TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().shareContentLink)))
        {
          BNNaviResultController.getInstance().shareNavi(BusinessActivityManager.getInstance().getModel().shareContentLink, BusinessActivityManager.getInstance().getModel().sharePicLink, BusinessActivityManager.getInstance().getModel().shareTitle, BusinessActivityManager.getInstance().getModel().shareDesc);
          return;
        }
        TipTool.onCreateToastDialog(BNNaviResultView.this.mContext, "数据错误，分享失败");
        LogUtil.e(BNNaviResultView.TAG, "mShareHandler: 服务端返回 -->> errno: " + BusinessActivityManager.getInstance().getModel().shareRespErrNo + ", errmsg: " + BusinessActivityManager.getInstance().getModel().shareRespMsg);
        return;
        if (BNNaviResultView.this.getYellowBanner() != null) {
          BNNaviResultView.this.getYellowBanner().setClickable(true);
        }
        if (paramAnonymousMessage.arg1 != 0) {
          break;
        }
        bool2 = true;
        localRspData = (RspData)paramAnonymousMessage.obj;
      } while (localRspData == null);
      boolean bool1 = true;
      try
      {
        if ((JSONObject)localRspData.mData == null) {
          break label422;
        }
        i = ((JSONObject)localRspData.mData).getInt("errno");
        if (i != 0) {
          break label422;
        }
        bool1 = true;
      }
      catch (Exception paramAnonymousMessage)
      {
        int i;
        label244:
        for (;;) {}
      }
      paramAnonymousMessage = null;
      if (localRspData.mReq != null) {
        paramAnonymousMessage = (Bundle)localRspData.mReq.getObj();
      }
      i = 1;
      if (paramAnonymousMessage != null) {
        i = paramAnonymousMessage.getInt("FROM");
      }
      LogUtil.e(BNNaviResultView.TAG, "   MSG_NAV_END_MARK_TRAJECTORY_RET  msg.arg1: " + bool2 + "  from: " + i + "  errno: " + bool1);
      switch (i)
      {
      }
      for (;;)
      {
        if ((!bool2) || (!bool1)) {
          break label468;
        }
        TipTool.onCreateToastDialog(BNNaviResultView.this.mContext, "已保存");
        BNNaviResultController.getInstance().isMarkFavourite = true;
        if (BNNaviResultView.this.getYellowBanner() != null) {
          BNNaviResultView.this.getYellowBanner().setVisibility(8);
        }
        if (!BNSettingManager.isNavEndYellowBannerFirstClick()) {
          break;
        }
        BNSettingManager.setNavEndYellowBannerFirstClick(false);
        BNNaviResultView.this.showGuideView2();
        return;
        bool2 = false;
        break label197;
        label422:
        bool1 = false;
        break label244;
        if ((BNNaviResultView.this.isActivityLogoBitmap) && (BNNaviResultView.this.getYellowBanner() != null)) {
          BNNaviResultView.this.getYellowBanner().setVisibility(0);
        }
        BNNaviResultView.this.hideGuideView1();
      }
      label468:
      TipTool.onCreateToastDialog(BNNaviResultView.this.mContext, "网络异常，请检查网络并重试");
    }
  };
  private TrackStatisticBar mTrackStatisticBar;
  private View mapviewCover;
  private TextView maxSpeedTv;
  private BNNaviResultModel model = BNNaviResultModel.getInstance();
  private View naviResultRootView = null;
  private PrivilegeView privilegeView1;
  private PrivilegeView privilegeView2;
  private LinearLayout privilegesArea;
  private RightsProgressAnimateBar progressArea;
  private View reportView;
  private TextView savedTimeIv;
  private TextView savedTimeTv;
  private TextView savedTimeTypeTv;
  private View savedTimeView;
  private boolean setupViewOnTxtDataArrivedFinish = false;
  private View share;
  private View titleContainer;
  private TextView totalTimeTv;
  private TextView walkNaviTv;
  private View walkNaviView;
  private LinearLayout yellowBannerContainer;
  private LinearLayout yellowBannerContainer_bak;
  
  private void addMapView()
  {
    this.mMapParentView = ((RelativeLayout)this.naviResultRootView.findViewById(1711866244));
    this.mapviewCover = this.naviResultRootView.findViewById(1711866245);
    if ((this.mMapParentView == null) || (this.mapviewCover == null)) {}
    do
    {
      return;
      this.mapviewCover.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
      this.mMapParentView.removeAllViews();
    } while ((BNNaviResultController.pRGViewMode == 0) && (this.mNMapView == null));
    try
    {
      localObject = (ViewGroup)this.mNMapView.getParent();
      if (localObject != null) {
        ((ViewGroup)localObject).removeAllViews();
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = new LinearLayout.LayoutParams(-1, -1);
    this.mMapParentView.addView(this.mNMapView, (ViewGroup.LayoutParams)localObject);
    this.mMapParentView.requestLayout();
    for (;;)
    {
      BNMapController.getInstance().showTrafficMap(false);
      BNMapController.getInstance().setNightMode(false);
      return;
      BNNaviResultController.pRGViewMode = 1;
    }
  }
  
  private int convertStringToColor(String paramString)
  {
    int i = -16777216;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        i = Color.parseColor(paramString);
      }
      return i;
    }
    catch (Exception localException)
    {
      LogUtil.e(TAG, "convertStringToColor: colorStr -->> " + paramString);
    }
    return -16777216;
  }
  
  private void dismissProgressingDialog()
  {
    BNNaviResultController.getInstance().onLoadingEnd();
  }
  
  private void findViews()
  {
    this.walkNaviView = this.naviResultRootView.findViewById(1711866251);
    this.walkNaviTv = ((TextView)this.naviResultRootView.findViewById(1711866252));
    this.mTrackStatisticBar = ((TrackStatisticBar)this.naviResultRootView.findViewById(1711866253));
    this.titleContainer = this.naviResultRootView.findViewById(1711866246);
    this.back = this.naviResultRootView.findViewById(1711866247);
    this.share = this.naviResultRootView.findViewById(1711866248);
    this.yellowBannerContainer = ((LinearLayout)this.naviResultRootView.findViewById(1711865876));
    this.yellowBannerContainer_bak = ((LinearLayout)this.naviResultRootView.findViewById(1711866250));
    this.achievementsCardZone = this.naviResultRootView.findViewById(1711866267);
    this.progressArea = ((RightsProgressAnimateBar)this.naviResultRootView.findViewById(1711866269));
    this.achievementsGoalTv = ((TextView)this.naviResultRootView.findViewById(1711866283));
    this.achievementsRightsTv = ((TextView)this.naviResultRootView.findViewById(1711866284));
    this.achievementsRightsEnterIc = this.naviResultRootView.findViewById(1711866285);
    this.privilegesArea = ((LinearLayout)this.naviResultRootView.findViewById(1711866286));
    this.savedTimeView = this.naviResultRootView.findViewById(1711866289);
    this.savedTimeIv = ((TextView)this.naviResultRootView.findViewById(1711866290));
    this.savedTimeTv = ((TextView)this.naviResultRootView.findViewById(1711866291));
    this.savedTimeTypeTv = ((TextView)this.naviResultRootView.findViewById(1711866292));
    this.totalTimeTv = ((TextView)this.naviResultRootView.findViewById(1711866294));
    this.maxSpeedTv = ((TextView)this.naviResultRootView.findViewById(1711866298));
    this.averageSpeedTv = ((TextView)this.naviResultRootView.findViewById(1711866296));
    this.historyView = this.naviResultRootView.findViewById(1711866303);
    this.assuranceView = this.naviResultRootView.findViewById(1711866301);
    this.reportView = this.naviResultRootView.findViewById(1711866299);
    setFindViewsFinished(true);
  }
  
  private int getBottomHeight()
  {
    int j = ScreenUtil.getInstance().dip2px(72) + ScreenUtil.getInstance().dip2px(49);
    int i = j;
    if (this.achievementsCardZone != null)
    {
      i = j;
      if (this.achievementsCardZone.getVisibility() == 0) {
        i = j + ScreenUtil.getInstance().dip2px(225);
      }
    }
    return i;
  }
  
  private int getRight()
  {
    int i = 0;
    if (this.model.getAccelerateNum() + this.model.getBrakeNum() + this.model.getTurnNum() + this.model.getSpeedNum() > 0) {
      i = 0 + ScreenUtil.getInstance().dip2px(48);
    }
    return i;
  }
  
  private int getTopHeight()
  {
    int j = ScreenUtil.getInstance().dip2px(59) + 35;
    int i = j;
    if (this.walkNaviView.getVisibility() == 0) {
      i = j + ScreenUtil.getInstance().dip2px(42);
    }
    return i;
  }
  
  private LinearLayout getYellowBanner()
  {
    if (this.isActivityLogoBitmap)
    {
      if (this.yellowBannerContainer_bak != null) {
        return this.yellowBannerContainer_bak;
      }
    }
    else if (this.yellowBannerContainer != null) {
      return this.yellowBannerContainer;
    }
    return null;
  }
  
  private void hideGuideView1()
  {
    if (this.guideView1 != null) {
      this.guideView1.setVisibility(8);
    }
  }
  
  private void hideGuideView2()
  {
    if (this.guideView2 != null) {
      this.guideView2.setVisibility(8);
    }
  }
  
  private void initListeners()
  {
    if (this.back != null) {
      this.back.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          UserOPController.getInstance().add("1.5", "2", null, null);
          BNNaviResultController.getInstance().onBackPressedTitleBar();
        }
      });
    }
    if (this.share != null) {
      this.share.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          UserOPController.getInstance().add("6.4");
          if (!NetworkUtils.isNetworkAvailable(BNNaviResultView.this.mContext))
          {
            TipTool.onCreateToastDialog(BNNaviResultView.this.mContext, "网络未连接");
            return;
          }
          TipTool.onCreateToastDialog(BNNaviResultView.this.mContext, "数据整理中");
          if (BNNaviResultView.this.mShareHandler != null)
          {
            BNNaviResultController.getInstance().getShareData(BNNaviResultView.this.mShareHandler, 291);
            return;
          }
          TipTool.onCreateToastDialog(BNNaviResultView.this.mContext, "数据错误，分享失败");
        }
      });
    }
    if (this.historyView != null) {
      this.historyView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (RightHandResourcesProvider.isInternationalWithToast(BNNaviResultView.this.mContext)) {
            return;
          }
          UserOPController.getInstance().add("6.6");
          BNNaviResultController.getInstance().jumpToHistoryPage();
        }
      });
    }
    if (this.reportView != null) {
      this.reportView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (RightHandResourcesProvider.isInternationalWithToast(BNNaviResultView.this.mContext)) {
            return;
          }
          UserOPController.getInstance().add("2.e", "2", null, null);
          BNNaviResultController.getInstance().jumpToReportFragment();
        }
      });
    }
    if (this.yellowBannerContainer != null) {
      this.yellowBannerContainer.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (ForbidDaulClickUtils.isFastDoubleClick()) {}
          do
          {
            return;
            if (BNNaviResultView.this.mShareHandler != null) {
              BNNaviResultController.getInstance().markFavouriteTrajectory(BNNaviResultView.this.mShareHandler, 1);
            }
          } while (BNNaviResultView.this.yellowBannerContainer == null);
          BNNaviResultView.this.yellowBannerContainer.setClickable(false);
        }
      });
    }
    if (this.yellowBannerContainer_bak != null) {
      this.yellowBannerContainer_bak.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (ForbidDaulClickUtils.isFastDoubleClick()) {}
          do
          {
            return;
            if (BNNaviResultView.this.mShareHandler != null) {
              BNNaviResultController.getInstance().markFavouriteTrajectory(BNNaviResultView.this.mShareHandler, 1);
            }
          } while (BNNaviResultView.this.yellowBannerContainer_bak == null);
          BNNaviResultView.this.yellowBannerContainer_bak.setClickable(false);
        }
      });
    }
    BNMapController.getInstance().addObserver(this.mBNMapObserver);
  }
  
  private void initNetworkDataView()
  {
    LogUtil.e(TAG, "initNetworkDataView: textDataState -->> " + BNNaviResultController.getInstance().getTextDataState());
    if (BNNaviResultController.getInstance().getTextDataState() == BNNaviResultController.DataDownloadState.DOWNLOAD_FINISH)
    {
      setupViewAfterDownloadFinish();
      LogUtil.e(TAG, "initNetworkDataView: imgDataState -->> " + BNNaviResultController.getInstance().getImgDataState());
      if (BNNaviResultController.getInstance().getImgDataState() != BNNaviResultController.DataDownloadState.DOWNLOAD_FINISH) {
        break label102;
      }
      updateViewOnRightsLabelIconDataArrived();
    }
    label102:
    while (BNNaviResultController.getInstance().getImgDataState() != BNNaviResultController.DataDownloadState.DOWNLOAD_CANCEL)
    {
      return;
      initViewBeforeDownloadFinish();
      break;
    }
    BNNaviResultController.getInstance().notifyServerDataDownloadState(BNNaviResultController.DataDownloadType.IMG_DATA, BNNaviResultController.DataDownloadState.DOWNLOADING);
    BusinessActivityManager.getInstance().requestBitmap(1539);
  }
  
  private void initTrackStatisticsBar()
  {
    if (this.mTrackStatisticBar != null)
    {
      this.mTrackStatisticBar.setBarClickListener(new TrackStatisticBar.IBarClickListener()
      {
        public void onAccelerate()
        {
          BNMapController.getInstance().mapClickEvent(1);
        }
        
        public void onBrake()
        {
          BNMapController.getInstance().mapClickEvent(2);
        }
        
        public void onSpeed()
        {
          BNMapController.getInstance().mapClickEvent(4);
        }
        
        public void onTurn()
        {
          BNMapController.getInstance().mapClickEvent(3);
        }
      });
      this.mTrackStatisticBar.init(this.model.getSpeedNum(), this.model.getBrakeNum(), this.model.getTurnNum(), this.model.getAccelerateNum());
    }
  }
  
  private void initViewBeforeDownloadFinish()
  {
    LogUtil.e(TAG, "initViewBeforeDownloadFinish: -->> ");
    if (BNNaviResultController.getInstance().getTextDataState() == BNNaviResultController.DataDownloadState.DOWNLOADING) {
      showProgressingDialog();
    }
    updateMapViewVisibleArea();
  }
  
  private void initViews()
  {
    if (this.yellowBannerContainer != null) {
      ((TextView)this.yellowBannerContainer.getChildAt(0)).setText(Html.fromHtml("<font color=\"#703a04\">保存轨迹用于再次导航? </font><font color=\"#3385ff\">点击保存</font>"));
    }
    if (this.yellowBannerContainer_bak != null) {
      ((TextView)this.yellowBannerContainer_bak.getChildAt(0)).setText(Html.fromHtml("<font color=\"#703a04\">保存轨迹用于再次导航? </font><font color=\"#3385ff\">点击保存</font>"));
    }
    updateAssuranceView();
    updatePushingMarketingAreaView();
    showWalkNaviView(this.model.isShowWalkNavi(), this.model.getWalkNaviRemainDist());
    int i;
    if (this.share != null)
    {
      View localView = this.share;
      if (BNaviModuleManager.isGooglePlayChannel())
      {
        i = 8;
        localView.setVisibility(i);
      }
    }
    else if ((this.savedTimeView != null) && (this.savedTimeIv != null) && (this.savedTimeTv != null) && (this.savedTimeTypeTv != null))
    {
      if (BNNaviResultController.getInstance().setSavedTime(this.savedTimeIv, this.savedTimeTv, this.savedTimeTypeTv)) {
        break label301;
      }
      this.savedTimeView.setVisibility(8);
    }
    for (;;)
    {
      if (this.totalTimeTv != null) {
        this.totalTimeTv.setText(this.model.getTotalTimeFormatedStr());
      }
      if (this.maxSpeedTv != null) {
        this.maxSpeedTv.setText((int)this.model.getMaxSpeed() + "km/h");
      }
      if (this.averageSpeedTv != null) {
        this.averageSpeedTv.setText((int)this.model.getAverageSpeed() + "km/h");
      }
      if (this.progressArea != null) {
        this.progressArea.init();
      }
      initNetworkDataView();
      initTrackStatisticsBar();
      return;
      i = 0;
      break;
      label301:
      this.savedTimeView.setVisibility(0);
    }
  }
  
  private void initYellowBanner()
  {
    LogUtil.e(TAG, "initYellowBanner: yellowBanner -->> " + BusinessActivityManager.getInstance().getModel().yellowBanner);
    LinearLayout localLinearLayout;
    if ((getYellowBanner() != null) && (!BNNaviResultController.getInstance().isMarkFavourite))
    {
      localLinearLayout = getYellowBanner();
      if (BusinessActivityManager.getInstance().getModel().yellowBanner != 1) {
        break label126;
      }
    }
    label126:
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      if ((BNSettingManager.isNavEndYellowBannerFirstShow()) && (BusinessActivityManager.getInstance().getModel().yellowBanner == 1))
      {
        BNSettingManager.setNavEndYellowBannerFirstShow(false);
        if ((this.isActivityLogoBitmap) && (getYellowBanner() != null)) {
          getYellowBanner().setVisibility(8);
        }
        showGuideView1();
      }
      return;
    }
  }
  
  private void onCheckRightsClick()
  {
    UserOPController.getInstance().add("6.7");
    if (BNNaviResultController.getInstance().isLoggedIn())
    {
      BNNaviResultController.getInstance().openWithOpenAPINoTitleBar(BusinessActivityManager.getInstance().getModel().userRightEnterLink);
      return;
    }
    BNNaviResultController.getInstance().jumpToLoginPage(true);
  }
  
  private void onMapPause()
  {
    if (this.mIsMapstart)
    {
      BNMapController.getInstance().onPause();
      this.mIsMapstart = false;
    }
  }
  
  private void onMapResume()
  {
    if (!this.mIsMapstart)
    {
      BNMapController.getInstance().onResume();
      this.mIsMapstart = true;
    }
  }
  
  private void setUpPrivilegesView()
  {
    if (this.privilegesArea == null) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = BusinessActivityManager.getInstance().getModel().naviEndPrivilegesList;
      if ((localObject1 == null) || (((ArrayList)localObject1).size() < 2)) {
        break;
      }
      this.privilegesArea.setVisibility(0);
      this.privilegeView1 = new PrivilegeView(this.mActivity, (BusinessActivityModel.NaviEndPrivilege)((ArrayList)localObject1).get(0));
      localObject2 = this.privilegeView1.getView();
      if (localObject2 != null)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.height = ScreenUtil.getInstance().dip2px(102);
        localLayoutParams.weight = 1.0F;
        this.privilegesArea.addView((View)localObject2, localLayoutParams);
      }
      this.privilegeView2 = new PrivilegeView(this.mActivity, (BusinessActivityModel.NaviEndPrivilege)((ArrayList)localObject1).get(1));
      localObject1 = this.privilegeView2.getView();
    } while (localObject1 == null);
    Object localObject2 = new LinearLayout.LayoutParams(0, -2);
    ((LinearLayout.LayoutParams)localObject2).height = ScreenUtil.getInstance().dip2px(102);
    ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
    ((LinearLayout.LayoutParams)localObject2).leftMargin = ScreenUtil.getInstance().dip2px(12);
    this.privilegesArea.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    return;
    this.privilegesArea.setVisibility(8);
  }
  
  private void showAchievementsCardZone(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (this.achievementsCardZone != null)
    {
      if (paramBoolean2)
      {
        localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
        ((TranslateAnimation)localObject).setDuration(500L);
        this.achievementsCardZone.startAnimation((Animation)localObject);
      }
      localObject = this.achievementsCardZone;
      if (!paramBoolean1) {
        break label64;
      }
    }
    label64:
    for (int i = 0;; i = 4)
    {
      ((View)localObject).setVisibility(i);
      return;
    }
  }
  
  private void showGuideView1()
  {
    if (this.guideView1 == null)
    {
      this.guideView1 = ((ViewStub)this.naviResultRootView.findViewById(1711866305)).inflate();
      this.guideIv1 = ((ImageView)this.naviResultRootView.findViewById(1711865882));
      if (this.guideIv1 != null) {
        this.guideIv1.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (ForbidDaulClickUtils.isFastDoubleClick()) {}
            do
            {
              return;
              if (BNNaviResultView.this.mShareHandler != null) {
                BNNaviResultController.getInstance().markFavouriteTrajectory(BNNaviResultView.this.mShareHandler, 2);
              }
            } while (BNNaviResultView.this.getYellowBanner() == null);
            BNNaviResultView.this.getYellowBanner().setClickable(false);
          }
        });
      }
      if (this.guideView1 != null) {
        this.guideView1.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if ((BNNaviResultView.this.isActivityLogoBitmap) && (BNNaviResultView.this.getYellowBanner() != null)) {
              BNNaviResultView.this.getYellowBanner().setVisibility(0);
            }
            BNNaviResultView.this.hideGuideView1();
          }
        });
      }
    }
    this.guideView1.setVisibility(0);
  }
  
  private void showGuideView2()
  {
    if (this.guideView2 == null)
    {
      this.guideView2 = ((ViewStub)this.naviResultRootView.findViewById(1711866306)).inflate();
      this.guideIv2 = ((ImageView)this.naviResultRootView.findViewById(1711865884));
      if (this.guideIv2 != null) {
        this.guideIv2.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            BNNaviResultView.this.hideGuideView2();
          }
        });
      }
      if (this.guideView2 != null) {
        this.guideView2.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            BNNaviResultView.this.hideGuideView2();
          }
        });
      }
    }
    this.guideView2.setVisibility(0);
  }
  
  private void showProgressingDialog()
  {
    BNNaviResultController.getInstance().onLoadingStart();
  }
  
  private void showWalkNaviView(boolean paramBoolean, int paramInt)
  {
    if ((this.walkNaviView != null) && (this.walkNaviTv != null))
    {
      if ((paramBoolean) && (paramInt > 0) && (!this.isActivityLogoBitmap))
      {
        UserOPController.getInstance().add("6.2");
        this.walkNaviTv.setText("步行" + paramInt + "米，跟我走");
        this.walkNaviView.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            UserOPController.getInstance().add("6.3");
            BNNaviResultController.getInstance().startWalkNavi();
          }
        });
        this.walkNaviView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.walkNaviView.setVisibility(8);
  }
  
  private void updateAssuranceView()
  {
    if ((this.assuranceView != null) && (BusinessActivityManager.getInstance().getModel().compensationTitle != null) && (BusinessActivityManager.getInstance().getModel().compensationLink != null))
    {
      this.assuranceView.setVisibility(0);
      this.assuranceView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (RightHandResourcesProvider.isInternationalWithToast(BNNaviResultView.this.mContext)) {
            return;
          }
          UserOPController.getInstance().add("6.a");
          BNNaviResultController.getInstance().openWithOpenAPI(BusinessActivityManager.getInstance().getModel().compensationLink);
        }
      });
    }
  }
  
  private void updateMapViewVisibleArea()
  {
    try
    {
      Bundle localBundle = new Bundle();
      int i = getTopHeight();
      int j = getBottomHeight();
      int k = getRight();
      localBundle.putInt("widthP", BNMapController.getInstance().getScreenWidth());
      localBundle.putInt("heightP", BNMapController.getInstance().getScreenHeight());
      localBundle.putInt("unTopHeight", i);
      localBundle.putInt("unBottomHeight", j);
      localBundle.putInt("unLeftHeight", 0);
      localBundle.putInt("unRightHeight", k);
      BNMapController.getInstance().sendCommandToMapEngine(1, localBundle);
      LogUtil.e(TAG, "updateMapViewVisibleArea: sendCommandToMapEngine --> " + localBundle.toString());
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void updatePushingMarketingAreaView()
  {
    int j;
    boolean bool;
    if (this.titleContainer != null)
    {
      if (BusinessActivityManager.getInstance().getModel().operationActivityId <= 0) {
        break label408;
      }
      int i = BusinessActivityManager.getInstance().getModel().operationActivityId;
      if (BNNaviResultController.getInstance().getLocalMarketingDialogId(this.mActivity) != i)
      {
        BNNaviResultController.getInstance().setLocalMarketingDialogId(this.mContext, i);
        BNNaviResultController.getInstance().resetLocalMarketingDialogShowedTimes(this.mContext);
      }
      i = BNNaviResultController.getInstance().getLocalMarketingDialogShowedTimes(this.mContext);
      j = BusinessActivityManager.getInstance().getModel().operationActivityTime;
      if (!theLastBannerShowTime)
      {
        if ((!this.isNavigateBack) || (i != j)) {
          break label379;
        }
        bool = true;
        theLastBannerShowTime = bool;
      }
      LogUtil.e(TAG, "updatePushingMarketingAreaView: --> localShowedTimes: " + i + ", allocatedShowTimes: " + j + ", isNavigateBack: " + this.isNavigateBack + ", theLastBannerShowTime: " + theLastBannerShowTime);
      if ((i < j) || (theLastBannerShowTime))
      {
        Object localObject1 = BusinessActivityManager.getInstance().getModel().operationActivityLogoBitmap;
        Object localObject2 = BNNaviResultController.getInstance().getDrawableFromBitmap((Bitmap)localObject1);
        if ((localObject1 != null) && (localObject2 != null) && (!((Bitmap)localObject1).isRecycled()))
        {
          this.isActivityLogoBitmap = true;
          this.titleContainer.setBackgroundDrawable((Drawable)localObject2);
          this.titleContainer.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              UserOPController.getInstance().add("6.b");
              BNNaviResultController.getInstance().openWithOpenAPI(BusinessActivityManager.getInstance().getModel().operationActivityLink);
            }
          });
          double d = 0.22916666666666666D;
          float f1 = ((Bitmap)localObject1).getHeight();
          float f2 = ((Bitmap)localObject1).getWidth();
          if (f2 != 0.0F) {
            d = f1 / f2;
          }
          localObject2 = (RelativeLayout.LayoutParams)this.titleContainer.getLayoutParams();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new RelativeLayout.LayoutParams(-1, -2);
          }
          ((RelativeLayout.LayoutParams)localObject1).width = -1;
          ((RelativeLayout.LayoutParams)localObject1).height = ((int)(ScreenUtil.getInstance().getWindowWidthPixels() * d));
          this.titleContainer.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          if (this.isNavigateBack) {
            break label385;
          }
          BNNaviResultController.getInstance().setLocalMarketingDialogShowedTimes(this.mContext, i + 1);
        }
      }
    }
    label379:
    label385:
    while (!theLastBannerShowTime)
    {
      return;
      bool = false;
      break;
    }
    BNNaviResultController.getInstance().setLocalMarketingDialogShowedTimes(this.mContext, j + 1000);
    return;
    label408:
    BNNaviResultController.getInstance().resetLocalMarketingData(this.mContext);
  }
  
  private void updateRightInfoView()
  {
    if ((this.mContext != null) && (this.achievementsGoalTv != null) && (this.achievementsRightsTv != null) && (this.achievementsRightsEnterIc != null))
    {
      if (BusinessActivityManager.getInstance().getModel().userRightTipsEnd != null)
      {
        localObject = Html.fromHtml(BusinessActivityManager.getInstance().getModel().userRightTipsEnd);
        if (localObject != null) {
          this.achievementsGoalTv.setText((CharSequence)localObject);
        }
      }
      Object localObject = BusinessActivityManager.getInstance().getModel().userRightEnterTips;
      if (localObject == null) {
        break label134;
      }
      this.achievementsRightsTv.setText((CharSequence)localObject);
      this.achievementsRightsTv.setVisibility(0);
      this.achievementsRightsEnterIc.setVisibility(0);
    }
    for (;;)
    {
      this.achievementsRightsTv.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNNaviResultView.this.onCheckRightsClick();
        }
      });
      this.achievementsRightsEnterIc.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNNaviResultView.this.onCheckRightsClick();
        }
      });
      return;
      label134:
      this.achievementsRightsTv.setVisibility(8);
      this.achievementsRightsEnterIc.setVisibility(8);
    }
  }
  
  public void creatView(Activity paramActivity, MapGLSurfaceView paramMapGLSurfaceView, boolean paramBoolean)
  {
    if (paramActivity == null) {}
    boolean bool;
    do
    {
      do
      {
        return;
        this.mActivity = paramActivity;
        this.mContext = this.mActivity.getApplicationContext();
        this.mNMapView = paramMapGLSurfaceView;
        this.isNavigateBack = paramBoolean;
        LogUtil.e(TAG, "time: BNNaviResultView inflate -->> start ");
        preloadView(this.mActivity);
        LogUtil.e(TAG, "time: BNNaviResultView inflate -->> end ");
      } while (this.naviResultRootView == null);
      LogUtil.e(TAG, "BNNaviResultView: NaviResultModel -->> " + this.model.toString());
      BNNaviResultController.getInstance().setNaviResultShowing(true);
      UserOPController.getInstance().add("6.1");
      setFindViewsFinished(false);
      this.setupViewOnTxtDataArrivedFinish = false;
      addMapView();
      findViews();
      initViews();
      initListeners();
      LogUtil.e(TAG, "BNNaviResultView: isNavigateBack --> " + paramBoolean);
      bool = UgcNaviDynamicMarkRespository.getInstance().hasContainUgcDynamicMark();
      LogUtil.e(TAG, "BNNaviResultView: hasContainUgcDynamicMark --> " + bool);
    } while ((paramBoolean) || (!bool));
    showCompleteReportDialog();
  }
  
  /* Error */
  public void dismissCompleteReportDialog()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 902	com/baidu/navisdk/naviresult/BNNaviResultView:mCompleteReportDialog	Lcom/baidu/navisdk/ui/widget/BNDialog;
    //   6: ifnull +45 -> 51
    //   9: aload_0
    //   10: getfield 637	com/baidu/navisdk/naviresult/BNNaviResultView:mActivity	Landroid/app/Activity;
    //   13: ifnull +38 -> 51
    //   16: aload_0
    //   17: getfield 637	com/baidu/navisdk/naviresult/BNNaviResultView:mActivity	Landroid/app/Activity;
    //   20: invokevirtual 905	android/app/Activity:isFinishing	()Z
    //   23: ifne +28 -> 51
    //   26: aload_0
    //   27: getfield 902	com/baidu/navisdk/naviresult/BNNaviResultView:mCompleteReportDialog	Lcom/baidu/navisdk/ui/widget/BNDialog;
    //   30: invokevirtual 910	com/baidu/navisdk/ui/widget/BNDialog:isShowing	()Z
    //   33: ifeq +10 -> 43
    //   36: aload_0
    //   37: getfield 902	com/baidu/navisdk/naviresult/BNNaviResultView:mCompleteReportDialog	Lcom/baidu/navisdk/ui/widget/BNDialog;
    //   40: invokevirtual 913	com/baidu/navisdk/ui/widget/BNDialog:dismiss	()V
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 902	com/baidu/navisdk/naviresult/BNNaviResultView:mCompleteReportDialog	Lcom/baidu/navisdk/ui/widget/BNDialog;
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 902	com/baidu/navisdk/naviresult/BNNaviResultView:mCompleteReportDialog	Lcom/baidu/navisdk/ui/widget/BNDialog;
    //   56: goto -8 -> 48
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	BNNaviResultView
    //   59	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	43	59	finally
    //   43	48	59	finally
    //   51	56	59	finally
  }
  
  public View getRootView()
  {
    return this.naviResultRootView;
  }
  
  public boolean hasPreloaded()
  {
    return this.naviResultRootView != null;
  }
  
  public boolean isFindViewsFinished()
  {
    return this.findViewsFinished;
  }
  
  public boolean onBackPressed()
  {
    if ((this.guideView1 != null) && (this.guideView1.getVisibility() == 0))
    {
      if ((this.isActivityLogoBitmap) && (getYellowBanner() != null)) {
        getYellowBanner().setVisibility(0);
      }
      hideGuideView1();
      return true;
    }
    if ((this.guideView2 != null) && (this.guideView2.getVisibility() == 0))
    {
      hideGuideView2();
      return true;
    }
    UserOPController.getInstance().add("1.5", "1", null, null);
    dismissProgressingDialog();
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onDestroy()
  {
    this.isActivityLogoBitmap = false;
    BNNaviResultController.getInstance().setNaviResultShowing(false);
    if (this.mShareHandler != null)
    {
      this.mShareHandler.removeCallbacksAndMessages(null);
      this.mShareHandler = null;
    }
    if (this.progressArea != null) {
      this.progressArea.destroy();
    }
    if (this.privilegeView1 != null) {
      this.privilegeView1.clearImgData();
    }
    if (this.privilegeView2 != null) {
      this.privilegeView2.clearImgData();
    }
    if (this.titleContainer != null)
    {
      this.titleContainer.setBackgroundResource(17170445);
      this.titleContainer.setBackgroundDrawable(null);
    }
    BNMapController.getInstance().deleteObserver(this.mBNMapObserver);
  }
  
  public void onPause()
  {
    onMapPause();
  }
  
  public void onResume()
  {
    onMapResume();
    BNMapController.getInstance().setNightMode(false);
  }
  
  public boolean preloadView(Activity paramActivity)
  {
    if (paramActivity == null) {
      return false;
    }
    if (this.naviResultRootView != null) {
      return true;
    }
    LogUtil.e(TAG, "time: preloadView inflate -->> start ");
    try
    {
      this.naviResultRootView = ((ViewGroup)JarUtils.inflate(paramActivity, 1711472686, null));
      LogUtil.e(TAG, "time: preloadView inflate -->> end ");
      if (this.naviResultRootView == null) {
        return false;
      }
    }
    catch (Exception paramActivity)
    {
      this.naviResultRootView = null;
      return false;
    }
    return true;
  }
  
  public void setFindViewsFinished(boolean paramBoolean)
  {
    this.findViewsFinished = paramBoolean;
  }
  
  public void setupViewAfterDownloadFinish()
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        LogUtil.e(TAG, "setupViewAfterDownloadFinish: setupViewOnTxtDataArrivedFinish -->> " + this.setupViewOnTxtDataArrivedFinish);
        dismissProgressingDialog();
        bool1 = this.setupViewOnTxtDataArrivedFinish;
        if (bool1) {
          return;
        }
        this.setupViewOnTxtDataArrivedFinish = true;
        initYellowBanner();
        if (BusinessActivityManager.getInstance().getModel().uploadRespErrNo != 0) {
          break label289;
        }
        LogUtil.e(TAG, "setupViewAfterDownloadFinish: download -->> success");
        if (!this.isNavigateBack)
        {
          bool1 = true;
          showAchievementsCardZone(true, bool1);
          String str2 = TAG;
          StringBuilder localStringBuilder = new StringBuilder().append("setupViewAfterDownloadFinish: showProgressBar -->> progressArea: ");
          if (this.progressArea != null) {
            break label281;
          }
          Object localObject1 = "null";
          LogUtil.e(str2, (String)localObject1 + ", from: " + BusinessActivityManager.getInstance().getModel().userRightUpgradeFrom + ", to: " + BusinessActivityManager.getInstance().getModel().userRightUpgradeTo);
          if ((this.progressArea != null) && (BusinessActivityManager.getInstance().getModel().userRightUpgradeFrom >= 0) && (BusinessActivityManager.getInstance().getModel().userRightUpgradeTo >= 0))
          {
            localObject1 = this.progressArea;
            int i = BusinessActivityManager.getInstance().getModel().userRightUpgradeFrom;
            int j = BusinessActivityManager.getInstance().getModel().userRightUpgradeTo;
            if (this.isNavigateBack) {
              break label350;
            }
            bool1 = bool2;
            ((RightsProgressAnimateBar)localObject1).updateProgress(i, j, bool1, false);
          }
          updateRightInfoView();
          setUpPrivilegesView();
          updateMapViewVisibleArea();
          continue;
        }
        bool1 = false;
      }
      finally {}
      continue;
      label281:
      String str1 = "not null";
      continue;
      label289:
      LogUtil.e(TAG, "setupViewAfterDownloadFinish: download -->> fail (errono: " + BusinessActivityManager.getInstance().getModel().uploadRespErrNo + ", errmsg: " + BusinessActivityManager.getInstance().getModel().uploadRespMsg + ")");
      continue;
      label350:
      boolean bool1 = false;
    }
  }
  
  public void showCompleteReportDialog()
  {
    try
    {
      if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
      {
        if (this.mCompleteReportDialog == null) {
          this.mCompleteReportDialog = new BNDialog(this.mActivity).setTitleText(null).setContentMessage("您有上报的道路问题\n是否现在补充?").setContentCenter().setFirstBtnText(Html.fromHtml("<font color=\"#333333\">取消</font>")).setOnFirstBtnClickListener(new BNDialog.OnNaviClickListener()
          {
            public void onClick()
            {
              BNNaviResultView.this.dismissCompleteReportDialog();
              UgcNaviDynamicMarkRespository.getInstance().clear();
            }
          }).setSecondBtnText(Html.fromHtml("<font color=\"#3385ff\">去补充</font>")).setOnSecondBtnClickListener(new BNDialog.OnNaviClickListener()
          {
            public void onClick()
            {
              BNNaviResultView.this.dismissCompleteReportDialog();
              BNNaviResultController.getInstance().goToUgcCompletePage();
            }
          });
        }
        this.mCompleteReportDialog.show();
      }
      return;
    }
    finally {}
  }
  
  public void updateViewOnRightsLabelIconDataArrived()
  {
    if (this.progressArea != null)
    {
      this.progressArea.updateRightsLabelIc();
      return;
    }
    LogUtil.e(TAG, "updateViewOnRightsLabelIconDataArrived: progressArea -->> null");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/naviresult/BNNaviResultView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */