package com.baidu.navi.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.control.NavTrajectoryController;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.baidunavis.ui.CarNaviMapPage;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.f.a;
import com.baidu.carlife.f.g;
import com.baidu.carlife.logic.k;
import com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion;
import com.baidu.navi.cruise.BCruiser;
import com.baidu.navi.cruise.control.BNCruiseDialogManager;
import com.baidu.navi.cruise.control.EnterQuitLogicManager;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.voicecommand.VoiceCommandHelper;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.ui.cruise.IBCruiserListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.nplatform.comjni.map.basemap.LocationCallback;

public class CruiseFollowFragment
  extends CarNaviMapPage
{
  private Object mArg = null;
  private IBCruiserListener mBCruiserListener = new IBCruiserListener()
  {
    public void notifyLoacteData(LocData paramAnonymousLocData) {}
    
    public void notifyQuitCruiser() {}
    
    public void notifyStartCruiser() {}
    
    public void onPageJump(int paramAnonymousInt, Object paramAnonymousObject)
    {
      if (1 == paramAnonymousInt) {
        if (CruiseFollowFragment.this.mJumpType == -1)
        {
          BCruiser.getInstance().quitCruise();
          if ((!com.baidu.carlife.l.a.a().N()) || (com.baidu.carlife.logic.d.a().d() == null)) {
            break label181;
          }
          if (com.baidu.carlife.logic.d.a().d().getMajorVersion() < 2) {
            break label155;
          }
          k.a().a(9, 0);
        }
      }
      label155:
      label181:
      while (2 != paramAnonymousInt)
      {
        for (;;)
        {
          long l = System.currentTimeMillis() - CruiseFollowFragment.this.mNaviStartTime;
          StatisticManager.onEventDuration(com.baidu.carlife.core.a.a(), "NAVI_0011", "巡航模式使用时长", (int)l);
          if (l >= 18000000L) {
            StatisticManager.onEvent("NAVI_0012", "NAVI_0012");
          }
          CruiseFollowFragment.access$002(CruiseFollowFragment.this, paramAnonymousInt);
          CruiseFollowFragment.access$202(CruiseFollowFragment.this, paramAnonymousObject);
          if (!CruiseFollowFragment.this.isCarlifeFragment(CruiseFollowFragment.this.getCurrentFragmentType())) {
            break;
          }
          CruiseFollowFragment.access$002(CruiseFollowFragment.this, paramAnonymousInt);
          CruiseFollowFragment.access$202(CruiseFollowFragment.this, paramAnonymousObject);
          return;
          if (k.a().b(f.jx.a()))
          {
            k.a().a(2, 0);
            continue;
            k.a().a(9, 0);
            k.a().a(2, 0);
          }
        }
        CruiseFollowFragment.access$002(CruiseFollowFragment.this, -1);
        CruiseFollowFragment.access$202(CruiseFollowFragment.this, null);
        CruiseFollowFragment.this.goBack();
        return;
      }
      if (((Boolean)paramAnonymousObject).booleanValue())
      {
        BaiduNaviManager.getInstance().launchDownloadActivity(BaseFragment.mActivity, "KEY_FROM_CRUISER");
        return;
      }
      CruiseFollowFragment.this.goBack();
    }
  };
  private BNCruiseDialogManager mCruiseDialogManager;
  private g mFocusArea;
  private View mItsButton;
  private View mItsVoiceButton;
  private int mJumpType = -1;
  private View mLocationView;
  private long mNaviStartTime;
  private View mQuitBtn;
  private View mZoomInBtnView;
  private View mZoomOutBtnView;
  private View view;
  
  private void setFocusListener(View paramView)
  {
    paramView.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          CruiseFollowFragment.this.showQuitBtn();
        }
      }
    });
  }
  
  private void showQuitBtn()
  {
    if (this.mQuitBtn != null) {
      this.mQuitBtn.setVisibility(0);
    }
  }
  
  private void turnOffUnexpectPrompt()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("CloseSpeedCamera", 1);
    localBundle.putInt("CloseTrafficLightCamera", 1);
    localBundle.putInt("ClosePeccanryCamera", 1);
    localBundle.putInt("CloseTrafficSign", 1);
    BNRouteGuider.getInstance().SetCruiseSetting(localBundle);
  }
  
  private void turnOnUnexpectPrompt()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("CloseSpeedCamera", 0);
    localBundle.putInt("CloseTrafficLightCamera", 0);
    localBundle.putInt("ClosePeccanryCamera", 0);
    localBundle.putInt("CloseTrafficSign", 1);
    BNRouteGuider.getInstance().SetCruiseSetting(localBundle);
  }
  
  public boolean forbidsConfigurationChange()
  {
    return false;
  }
  
  public boolean forceResetModeWhenBack()
  {
    return true;
  }
  
  public String getPageClsName()
  {
    return CruiseFollowFragment.class.getName();
  }
  
  public int getPageType()
  {
    return 3;
  }
  
  public boolean is3DGestureEnable()
  {
    return true;
  }
  
  public boolean isMapPage()
  {
    return true;
  }
  
  public boolean onBackPressed()
  {
    BCruiser.getInstance().onBackPressed();
    return true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    BCruiser.getInstance().onConfigurationChanged(paramConfiguration);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    BaseTTSPlayer.getInstance().setEnableTimeOut(true);
    paramLayoutInflater = LocationManager.getInstance().getCurLocation(LocationChangeListener.CoordType.CoordType_BD09);
    Bundle localBundle = CoordinateTransformUtil.MC2LL((int)paramLayoutInflater.longitude, (int)paramLayoutInflater.latitude);
    LocData localLocData = new LocData();
    localLocData.longitude = localBundle.getDouble("LLx");
    localLocData.latitude = localBundle.getDouble("LLy");
    LocationCallback.setData(localLocData.toLocationOverlayJsonString(PreferenceHelper.getInstance(mActivity).getBoolean("SP_Last_Cruise_Map_Status", true)));
    localBundle = new Bundle();
    localBundle.putInt("cruiser_view_mode", 1);
    this.mCruiseDialogManager = new BNCruiseDialogManager(mActivity, this);
    BCruiser.getInstance().setCruiseDialogManagerInterface(this.mCruiseDialogManager.getCruiseDialogManagerInterface());
    this.view = BCruiser.getInstance().init(mActivity, localBundle, null);
    if (this.view == null)
    {
      super.goBack();
      return null;
    }
    BCruiser.getInstance().setListener(this.mBCruiserListener);
    EnterQuitLogicManager.getmInstance().setListener(this.mBCruiserListener);
    if (paramLayoutInflater != null) {
      BCruiser.getInstance().updateInitLocation((int)paramLayoutInflater.longitude, (int)paramLayoutInflater.latitude);
    }
    BCruiser.getInstance().startCruise();
    BaiduNaviManager.getInstance().notifyNaviBeginChanged("1");
    NavTrajectoryController.getInstance().startRecord("", "我的位置", 3, true, true);
    if ((com.baidu.carlife.l.a.a().N()) && (com.baidu.carlife.logic.d.a().d() != null)) {
      if (com.baidu.carlife.logic.d.a().d().getMajorVersion() >= 2) {
        k.a().a(9, 1);
      }
    }
    for (;;)
    {
      this.mNaviStartTime = System.currentTimeMillis();
      return this.view;
      if (k.a().b(f.jx.a()))
      {
        k.a().a(2, 1);
        continue;
        k.a().a(9, 1);
        k.a().a(2, 1);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    BaseTTSPlayer.getInstance().setEnableTimeOut(false);
    BaiduNaviManager.getInstance().notifyNaviBeginChanged("0");
    BCruiser.getInstance().quitCruise();
    BCruiser.destory();
    com.baidu.baidunavis.model.NavCommonFuncModel.sIsAnologNavi = false;
    BNRouteGuider.getInstance().setRotateMode(0);
    NavTrajectoryController.getInstance().endRecord("目的地", false, 3);
  }
  
  public void onInitFocus()
  {
    if (this.view == null) {}
    do
    {
      return;
      if (this.mFocusArea != null) {
        break;
      }
      this.mItsVoiceButton = this.view.findViewById(2131625922);
      setFocusListener(this.mItsVoiceButton);
      this.mLocationView = this.view.findViewById(2131625904);
      setFocusListener(this.mLocationView);
      this.mQuitBtn = this.view.findViewById(2131625895);
      this.mZoomOutBtnView = this.view.findViewById(2131625912);
      setFocusListener(this.mZoomOutBtnView);
      this.mZoomInBtnView = this.view.findViewById(2131625911);
      setFocusListener(this.mZoomInBtnView);
      this.mItsButton = this.view.findViewById(2131625913);
      setFocusListener(this.mItsButton);
    } while ((this.mQuitBtn == null) || (this.mItsVoiceButton == null) || (this.mItsButton == null) || (this.mLocationView == null) || (this.mZoomOutBtnView == null) || (this.mZoomInBtnView == null));
    this.mFocusArea = new g(this.view, 4, true);
    this.mFocusArea.d(this.mItsVoiceButton).d(this.mItsButton).d(this.mZoomInBtnView).d(this.mZoomOutBtnView).d(this.mQuitBtn).d(this.mLocationView);
    com.baidu.carlife.f.d.a().b(new com.baidu.carlife.f.a[] { this.mFocusArea });
    com.baidu.carlife.f.d.a().h(this.mFocusArea);
  }
  
  public void onInitFocusAreas()
  {
    onInitFocus();
  }
  
  protected void onInitView()
  {
    if ((this.mJumpType != -1) && (this.mBCruiserListener != null)) {
      this.mBCruiserListener.onPageJump(this.mJumpType, this.mArg);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    BCruiser.getInstance().onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    BNMapController localBNMapController = BNMapController.getInstance();
    if (!BNStyleManager.getRealDayStyle()) {}
    for (boolean bool = true;; bool = false)
    {
      localBNMapController.setNightMode(bool);
      BCruiser.getInstance().onUpdateStyle(BNStyleManager.getRealDayStyle());
      BCruiser.getInstance().onResume();
      if ((this.mJumpType != -1) && (this.mBCruiserListener != null)) {
        this.mBCruiserListener.onPageJump(this.mJumpType, this.mArg);
      }
      if (!com.baidu.carlife.l.a.a().N()) {
        break;
      }
      com.baidu.carlife.m.a.a().a(true);
      return;
    }
    com.baidu.carlife.m.a.a().a(false);
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean)
  {
    BCruiser.getInstance().onUpdateStyle(paramBoolean);
  }
  
  public boolean onVoiceCommand(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean)
  {
    if (paramInt1 == 2) {}
    switch (paramInt2)
    {
    default: 
      return false;
    case 2: 
      BNMapController.getInstance().zoomOut();
      replyVoiceCommand(paramInt1, 1, paramBoolean);
      return true;
    case 3: 
      BNMapController.getInstance().zoomIn();
      replyVoiceCommand(paramInt1, 1, paramBoolean);
      return true;
    case 29: 
    case 53: 
      BCruiser.getInstance().changeToNorth2DView();
      return true;
    case 30: 
      BCruiser.getInstance().changeToCar3DView();
      return true;
    case 8: 
      VoiceCommandHelper.onITSChanged(false);
      BCruiser.getInstance().updateItsBtn();
      return true;
    }
    VoiceCommandHelper.onITSChanged(true);
    BCruiser.getInstance().updateItsBtn();
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/CruiseFollowFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */