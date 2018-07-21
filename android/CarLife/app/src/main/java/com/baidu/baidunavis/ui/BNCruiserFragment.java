package com.baidu.baidunavis.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.control.BNCruiseDialogManager;
import com.baidu.baidunavis.control.NavTrajectoryController;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.f.a;
import com.baidu.carlife.logic.k;
import com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.voicecommand.VoiceCommandHelper;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.ui.cruise.BCruiser;
import com.baidu.navisdk.ui.cruise.IBCruiserListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.nplatform.comjni.map.basemap.LocationCallback;

public class BNCruiserFragment
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
        if (BNCruiserFragment.this.mJumpType == -1)
        {
          BCruiser.getInstance().quitCruise();
          if ((!com.baidu.carlife.l.a.a().N()) || (com.baidu.carlife.logic.d.a().d() == null)) {
            break label158;
          }
          if (com.baidu.carlife.logic.d.a().d().getMajorVersion() < 2) {
            break label132;
          }
          k.a().a(8, 0);
        }
      }
      label132:
      label158:
      while (2 != paramAnonymousInt)
      {
        for (;;)
        {
          StatisticManager.onEventEnd(com.baidu.carlife.core.a.a(), "1066", "电子狗使用时长");
          BNCruiserFragment.access$002(BNCruiserFragment.this, paramAnonymousInt);
          BNCruiserFragment.access$102(BNCruiserFragment.this, paramAnonymousObject);
          if (!BNCruiserFragment.this.getNaviFragmentManager().isCarlifeFragment(BNCruiserFragment.this.getNaviFragmentManager().getCurrentFragmentType())) {
            break;
          }
          BNCruiserFragment.access$002(BNCruiserFragment.this, paramAnonymousInt);
          BNCruiserFragment.access$102(BNCruiserFragment.this, paramAnonymousObject);
          return;
          if (k.a().b(f.jx.a()))
          {
            k.a().a(2, 0);
            continue;
            k.a().a(8, 0);
            k.a().a(2, 0);
          }
        }
        BNCruiserFragment.access$002(BNCruiserFragment.this, -1);
        BNCruiserFragment.access$102(BNCruiserFragment.this, null);
        BNCruiserFragment.this.goBack();
        return;
      }
      if (((Boolean)paramAnonymousObject).booleanValue())
      {
        BaiduNaviManager.getInstance().launchDownloadActivity(BaseFragment.mActivity, "KEY_FROM_CRUISER");
        return;
      }
      BNCruiserFragment.this.goBack();
    }
  };
  private BNCruiseDialogManager mCruiseDialogManager;
  private com.baidu.carlife.f.g mFocusArea;
  private final Handler mHandler = new Handler();
  private View mItsButton;
  private View mItsVoiceButton;
  private int mJumpType = -1;
  private View mLocationView;
  private View mQuitBtn;
  private View mZoomInBtnView;
  private View mZoomOutBtnView;
  
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
    return BNCruiserFragment.class.getName();
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
    Object localObject = CoordinateTransformUtil.MC2LL((int)paramLayoutInflater.longitude, (int)paramLayoutInflater.latitude);
    LocData localLocData = new LocData();
    localLocData.longitude = ((Bundle)localObject).getDouble("LLx");
    localLocData.latitude = ((Bundle)localObject).getDouble("LLy");
    LocationCallback.setData(localLocData.toLocationOverlayJsonString(PreferenceHelper.getInstance(mActivity).getBoolean("SP_Last_Cruise_Map_Status", true)));
    localObject = new Bundle();
    ((Bundle)localObject).putInt("cruiser_view_mode", 1);
    this.mCruiseDialogManager = new BNCruiseDialogManager(mActivity, this);
    BCruiser.getInstance().setCruiseDialogManagerInterface(this.mCruiseDialogManager.getCruiseDialogManagerInterface());
    localObject = BCruiser.getInstance().init(mActivity, (Bundle)localObject, null);
    if (localObject == null)
    {
      super.goBack();
      return null;
    }
    BCruiser.getInstance().setListener(this.mBCruiserListener);
    if (paramLayoutInflater != null) {
      BCruiser.getInstance().updateInitLocation((int)paramLayoutInflater.longitude, (int)paramLayoutInflater.latitude);
    }
    BCruiser.getInstance().startCruise();
    BaiduNaviManager.getInstance().notifyNaviBeginChanged("1");
    NavTrajectoryController.getInstance().startRecord("", "我的位置", 3, true, true);
    UserOPController.getInstance().add("8.2.1", "3", null, null);
    SDKDebugFileUtil.end("RouteBottomEmpty");
    if ((com.baidu.carlife.l.a.a().N()) && (com.baidu.carlife.logic.d.a().d() != null)) {
      if (com.baidu.carlife.logic.d.a().d().getMajorVersion() >= 2) {
        k.a().a(8, 1);
      }
    }
    for (;;)
    {
      StatisticManager.onEventStart(com.baidu.carlife.core.a.a(), "1066", "电子狗使用时长");
      return (View)localObject;
      if (k.a().b(f.jx.a()))
      {
        k.a().a(2, 1);
        continue;
        k.a().a(8, 1);
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
    NavTrajectoryController.getInstance().endRecord("目的地", false, 2);
    UserOPController.getInstance().add("8.2.2", "3", null, null);
  }
  
  public void onInitFocusAreas()
  {
    if (this.mContentView == null) {}
    do
    {
      do
      {
        return;
        if (this.mFocusArea != null) {
          break;
        }
        this.mQuitBtn = this.mContentView.findViewById(1711865939);
        this.mItsVoiceButton = this.mContentView.findViewById(1711865966);
        this.mItsButton = this.mContentView.findViewById(1711865960);
        this.mLocationView = this.mContentView.findViewById(1711865948);
        this.mZoomInBtnView = this.mContentView.findViewById(1711865957);
        this.mZoomOutBtnView = this.mContentView.findViewById(1711865959);
      } while ((this.mQuitBtn == null) || (this.mItsVoiceButton == null) || (this.mItsButton == null) || (this.mLocationView == null) || (this.mZoomOutBtnView == null) || (this.mZoomInBtnView == null));
      this.mFocusArea = new com.baidu.carlife.f.g(this.mContentView, 4, true);
      this.mFocusArea.d(this.mQuitBtn).d(this.mLocationView).d(this.mItsVoiceButton).d(this.mItsButton).d(this.mZoomInBtnView).d(this.mZoomOutBtnView);
      com.baidu.carlife.f.d.a().b(new com.baidu.carlife.f.a[] { this.mFocusArea });
    } while (com.baidu.carlife.core.screen.presentation.a.g.a().isDialogShown());
    com.baidu.carlife.f.d.a().h(this.mFocusArea);
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/ui/BNCruiserFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */