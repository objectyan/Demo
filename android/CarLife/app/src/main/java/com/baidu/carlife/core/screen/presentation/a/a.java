package com.baidu.carlife.core.screen.presentation.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import com.baidu.baidunavis.control.NavPoiController;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.view.dialog.c;
import com.baidu.navi.ActivityStack;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.controller.NameSearchHelper;
import com.baidu.navi.controller.QuickFragmentListener;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.MapContentFragment;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.voicecommand.APPVoiceFuncCallback;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.ui.cruise.BCruiser;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;

public class a
  implements APPVoiceFuncCallback
{
  private d a;
  private Context b;
  private e c;
  private c d = null;
  private QuickFragmentListener e = new QuickFragmentListener()
  {
    public void onRefreshHistoryList() {}
    
    public void showSetCompAddrDialog()
    {
      c localc = new c(a.a(a.this)).b(2131296284).a(2131297134).c(2131296291).q().d(2131296259);
      localc.a(new b()
      {
        public void onClick()
        {
          a.this.a(5);
        }
      });
      a.b(a.this).showDialog(localc);
    }
    
    public void showSetHomeAddrDialog()
    {
      c localc = new c(a.a(a.this)).b(2131296284).a(2131297135).c(2131296291).q().d(2131296259);
      localc.a(new b()
      {
        public void onClick()
        {
          a.this.a(4);
        }
      });
      a.b(a.this).showDialog(localc);
    }
    
    public void showToast(int paramAnonymousInt) {}
  };
  
  public a(d paramd, e parame)
  {
    this.a = paramd;
    this.b = com.baidu.carlife.core.a.a();
    this.c = parame;
  }
  
  public void a(int paramInt)
  {
    h localh = h.a();
    this.a.e();
    Bundle localBundle = new Bundle();
    localBundle.putInt("from_Fragment", localh.getCurrentFragmentType());
    localBundle.putInt("select_point_action", paramInt);
    localBundle.putInt("module_from", 3);
    localh.showFragment(49, localBundle);
  }
  
  public boolean changeLocationMode(int paramInt)
  {
    return true;
  }
  
  public boolean exitAPP()
  {
    ActivityStack.exitApp(true);
    return true;
  }
  
  public int getPageType()
  {
    return h.a().getCurrentFragmentType();
  }
  
  public boolean goHome()
  {
    i.b("CarlifeActivity", "======go home=====");
    if (AddressSettingModel.hasSetHomeAddr(this.b))
    {
      this.a.e();
      if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
        BaiduNaviSDKManager.getInstance().quitNavi();
      }
      if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
        BaiduNaviSDKManager.getInstance().quitCruise();
      }
      h.a().backTo(17, null);
      NavPoiController.getInstance().startCalcRoute(AddressSettingModel.getHomeAddrNode(this.b));
      BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 1);
    }
    for (;;)
    {
      k.b(4160, 43982);
      return true;
      if ((BNavigator.getInstance().isNaviBegin()) || (BCruiser.getInstance().isRouteCruiseBegin())) {
        com.baidu.carlife.m.a.a().b("您未设置家的地址", 1);
      } else {
        this.e.showSetHomeAddrDialog();
      }
    }
  }
  
  public boolean goOffice()
  {
    i.b("CarlifeActivity", "======go office=====");
    if (AddressSettingModel.hasSetCompAddr(this.b))
    {
      this.a.e();
      if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
        BaiduNaviSDKManager.getInstance().quitNavi();
      }
      if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
        BaiduNaviSDKManager.getInstance().quitCruise();
      }
      h.a().backTo(17, null);
      NavPoiController.getInstance().startCalcRoute(AddressSettingModel.getCompAddrNode(this.b));
      BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 1);
    }
    for (;;)
    {
      k.b(4160, 43982);
      return true;
      if ((BNavigator.getInstance().isNaviBegin()) || (BCruiser.getInstance().isRouteCruiseBegin())) {
        com.baidu.carlife.m.a.a().b("您未设置公司的地址", 1);
      } else {
        this.e.showSetCompAddrDialog();
      }
    }
  }
  
  public boolean limitLine()
  {
    return true;
  }
  
  public String myLoc()
  {
    int i = 3;
    ContentFragment localContentFragment = h.a().getCurrentFragment();
    if ((localContentFragment instanceof MapContentFragment))
    {
      ((MapContentFragment)localContentFragment).onVoiceCmdMyLocation();
      i = 1;
    }
    BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), i);
    return "done";
  }
  
  public boolean nameSearch(String paramString)
  {
    i.b("CarlifeActivity", "nameSearch key is " + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putInt("incoming_type", 3);
    localBundle.putBoolean("poi_center_mode", false);
    localBundle.putString("voice_key", paramString);
    localBundle.putInt("Key_Bundle_VC_Top_Type", BNVoiceCommandController.getInstance().getLastestVCTopType());
    localBundle.putInt("Key_Bundle_VC_Sub_Type", BNVoiceCommandController.getInstance().getLastestVCSubType());
    h localh = h.a();
    int i = localh.d();
    if (i == 4001) {
      i = 1;
    }
    for (;;)
    {
      localBundle.putInt("module_from", i);
      if (localh == null) {
        break;
      }
      this.a.e();
      if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
        BaiduNaviSDKManager.getInstance().quitNavi();
      }
      if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
        BaiduNaviSDKManager.getInstance().quitCruise();
      }
      localh.backTo(17, null);
      NameSearchHelper.getInstance().search(BaseFragment.getNaviActivity(), localh.getCurrentFragment(), paramString, i, true, false);
      return true;
      if (i == 4004) {
        i = 4;
      } else if (i == 4002) {
        i = 2;
      } else {
        i = 3;
      }
    }
    return false;
  }
  
  public boolean onFullview()
  {
    RGEngineControl.getInstance().enableManualSound();
    BNRouteGuider.getInstance().SetFullViewState(true);
    BNRouteGuider.getInstance().setBrowseStatus(true);
    if (1 == this.b.getResources().getConfiguration().orientation)
    {
      BNRouteGuider.getInstance().ZoomToFullView(1);
      return true;
    }
    BNRouteGuider.getInstance().ZoomToFullView(3);
    return true;
  }
  
  public boolean onOtherVoiceFunc(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return false;
  }
  
  public void poiDataNotNew() {}
  
  public void showVoiceHelp() {}
  
  public boolean spaceSearch(String paramString)
  {
    i.b("CarlifeActivity", "search around key is " + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putInt("incoming_type", 3);
    localBundle.putBoolean("poi_center_mode", true);
    localBundle.putString("voice_key", paramString);
    localBundle.putInt("Key_Bundle_VC_Top_Type", BNVoiceCommandController.getInstance().getLastestVCTopType());
    localBundle.putInt("Key_Bundle_VC_Sub_Type", BNVoiceCommandController.getInstance().getLastestVCSubType());
    h localh = h.a();
    int i = localh.d();
    if (i == 4001) {
      i = 1;
    }
    for (;;)
    {
      localBundle.putInt("module_from", i);
      if (localh == null) {
        break;
      }
      this.a.e();
      if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
        BaiduNaviSDKManager.getInstance().quitNavi();
      }
      if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
        BaiduNaviSDKManager.getInstance().quitCruise();
      }
      localh.backTo(17, null);
      NameSearchHelper.getInstance().search(BaseFragment.getNaviActivity(), localh.getCurrentFragment(), paramString, i, true, true);
      return true;
      if (i == 4004) {
        i = 4;
      } else if (i == 4002) {
        i = 2;
      } else {
        i = 3;
      }
    }
    return false;
  }
  
  public boolean switchDayNightMode(int paramInt)
  {
    BNSettingManager.setNaviDayAndNightMode(paramInt);
    return true;
  }
  
  public boolean washCar()
  {
    return true;
  }
  
  public boolean weather()
  {
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/presentation/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */