package com.baidu.carlife.core.screen.presentation.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import com.baidu.baidunavis.control.NavPoiController;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.screen.BaseDialog.a;
import com.baidu.carlife.fragment.HomeFragment;
import com.baidu.carlife.fragment.PhoneFragment;
import com.baidu.carlife.logic.voice.n;
import com.baidu.carlife.util.w;
import com.baidu.carlife.view.g;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.cruise.BCruiser;
import com.baidu.navi.cruise.control.EnterQuitLogicManager;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.MapFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.voice.MapVoiceCommandController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import java.util.List;

public class d
{
  private static final String a = "CarlifePresenter";
  private i b;
  private f c;
  private com.baidu.carlife.core.screen.presentation.h d;
  private boolean e = false;
  private MapFragment f;
  private boolean g = false;
  private boolean h = true;
  private Context i;
  private a j;
  
  public d(f paramf)
  {
    this.c = paramf;
    this.b = new c();
    this.i = paramf.e();
    this.d = com.baidu.carlife.core.screen.presentation.h.a();
    this.d.getNaviFragmentManager().setUIListener(paramf);
    this.j = new a(Looper.getMainLooper());
    com.baidu.carlife.core.k.a(this.j);
    k();
  }
  
  private void a(com.baidu.carlife.core.screen.a parama, boolean paramBoolean)
  {
    if (!com.baidu.carlife.core.c.a().d())
    {
      b("请等待导航初始化成功");
      return;
    }
    if (!this.e) {
      p();
    }
    final SearchPoi localSearchPoi = new SearchPoi();
    localSearchPoi.mGuidePoint = CoordinateTransformUtil.transferBD09ToGCJ02(parama.a(), parama.b());
    if ((!paramBoolean) && (BNavigator.getInstance().isNaviBegin()))
    {
      parama = new com.baidu.carlife.view.dialog.c(this.i).a(2131296442).c(2131296264).d(2131296259);
      parama.a(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          d.a(d.this, localSearchPoi);
        }
      });
      this.c.showDialog(parama, BaseDialog.a.a);
      return;
    }
    a(localSearchPoi);
  }
  
  private void a(SearchPoi paramSearchPoi)
  {
    e();
    if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
      BaiduNaviSDKManager.getInstance().quitNavi();
    }
    for (;;)
    {
      e();
      this.d.backTo(17, null);
      NavPoiController.getInstance().startCalcRoute(paramSearchPoi);
      return;
      if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
        BaiduNaviSDKManager.getInstance().quitCruise();
      } else if (BCruiser.getInstance().isCruiseBegin()) {
        EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
      }
    }
  }
  
  private void b(String paramString)
  {
    w.a(paramString);
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.d.backTo(17, null);
    Bundle localBundle = new Bundle();
    localBundle.putInt("incoming_type", 3);
    localBundle.putString("voice_key", paramString);
    localBundle.putBoolean("poi_center_mode", true);
    localBundle.putInt("module_from", 1);
    if ("加油站".equals(paramString)) {
      localBundle.putInt("come_from", 8);
    }
    this.d.showFragment(34, localBundle);
  }
  
  private void k()
  {
    BNVoiceCommandController.getInstance().setAPPVoiceFuncCallback(new a(this, this.c));
    MapVoiceCommandController.getInstance().setCarlifePresenter(this);
    com.baidu.carlife.wechat.b.k.a().a(this);
  }
  
  private void l()
  {
    com.baidu.carlife.core.i.b("yftech", "CarlifeActiviy notifyFragmentUpdateForDriving");
    if (com.baidu.carlife.core.screen.presentation.h.a().getNaviFragmentManager() != null)
    {
      if (com.baidu.carlife.core.screen.presentation.h.a().getNaviFragmentManager().isDriving()) {
        com.baidu.carlife.core.screen.presentation.h.a().getNaviFragmentManager().driving();
      }
    }
    else {
      return;
    }
    com.baidu.carlife.core.screen.presentation.h.a().getNaviFragmentManager().stopDriving();
  }
  
  private void m()
  {
    if (h() == 519) {}
    do
    {
      return;
      com.baidu.carlife.core.i.a(PhoneFragment.a);
      this.d.showFragment(519, null);
      this.c.updateMainDisplayStatus(4002);
      com.baidu.carlife.core.k.b(4022);
      g.e().c();
      g.e().d();
    } while ((!com.baidu.carlife.l.a.a().N()) || (com.baidu.carlife.core.c.a().k()));
    com.baidu.carlife.core.k.a(2029, 200);
  }
  
  private void n()
  {
    if (this.d.b(h())) {}
    do
    {
      return;
      com.baidu.carlife.core.i.a("CarLifeMusic");
      com.baidu.carlife.core.k.b(4022);
      o();
      this.c.updateMainDisplayStatus(4004);
    } while ((!com.baidu.carlife.l.a.a().N()) || (!this.h));
    this.h = false;
    r();
  }
  
  private void o()
  {
    int k = this.d.g().getType();
    this.d.showLatestMusicFragment();
    com.baidu.carlife.logic.music.b localb = com.baidu.carlife.logic.music.h.b().r();
    if (k == 745) {
      if (localb.v() == 1) {
        this.d.showFragment(737, null);
      }
    }
    while ((k != 737) || (localb.v() != 0)) {
      return;
    }
    this.d.showFragment(745, null);
  }
  
  private void p()
  {
    boolean bool = true;
    Object localObject;
    if (this.f == null)
    {
      this.e = true;
      this.g = true;
      MapViewFactory.getInstance().getMapView().getController().importMapTheme(17);
      this.f = new MapFragment();
      if (!this.f.isAdded())
      {
        localObject = this.d.getNaviFragmentManager().getFragmentManager().beginTransaction();
        ((FragmentTransaction)localObject).add(2131623984, this.f);
        ((FragmentTransaction)localObject).commitAllowingStateLoss();
      }
    }
    try
    {
      localObject = BNMapController.getInstance();
      if (!StyleManager.getRealDayStyle()) {}
      for (;;)
      {
        ((BNMapController)localObject).setNightMode(bool);
        return;
        bool = false;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void q()
  {
    if (com.baidu.carlife.l.a.a().N())
    {
      Object localObject = new com.baidu.carlife.core.connect.c(true);
      ((com.baidu.carlife.core.connect.c)localObject).c(65593);
      localObject = Message.obtain(null, ((com.baidu.carlife.core.connect.c)localObject).d(), 1001, 0, localObject);
      com.baidu.carlife.l.a.a().a((Message)localObject);
    }
  }
  
  private void r()
  {
    com.baidu.carlife.logic.music.b localb = com.baidu.carlife.logic.music.h.b().h(1);
    if (localb == null) {}
    while (localb.x() != 1) {
      return;
    }
    localb.b(false);
  }
  
  private void s()
  {
    if ((BNavigator.getInstance().isNaviBegin()) && (RGMapModeViewController.getInstance().ismIsShowColladaView()))
    {
      RGMapModeViewController.getInstance().setmIsShowColladaView(false);
      RouteGuideFSM.getInstance().run("收到collada隐藏消息");
      RGViewController.getInstance().resetColladaView();
    }
  }
  
  private void t()
  {
    com.baidu.carlife.view.dialog.c localc = new com.baidu.carlife.view.dialog.c(this.i).b(2131296835).a(2131296834).c(2131296262).q().f(1);
    List localList = com.baidu.carlife.bluetooth.f.a().j();
    if ((localList == null) || (localList.size() == 0))
    {
      com.baidu.carlife.core.c.a().h(true);
      this.c.showDialog(localc);
      StatisticManager.onEvent("PHONE_0001");
    }
  }
  
  public void a()
  {
    s();
    q();
    a(false);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.d.showFragment(paramInt, paramBundle);
  }
  
  public void a(Bundle paramBundle)
  {
    if (h() < 512) {
      return;
    }
    if (!com.baidu.carlife.core.c.a().d())
    {
      b("请等待导航初始化成功");
      return;
    }
    com.baidu.carlife.core.i.a("BNRouteGuideFragment");
    if (this.d.f()) {
      this.d.a(paramBundle);
    }
    for (;;)
    {
      this.c.updateMainDisplayStatus(4003);
      com.baidu.carlife.core.k.b(4022);
      StatisticManager.onEvent("1021", "百度地图");
      l();
      return;
      if (!this.e) {
        p();
      }
      this.d.showFragment(17, paramBundle);
    }
  }
  
  public void a(com.baidu.carlife.core.screen.a parama)
  {
    a(parama, true);
  }
  
  public void a(final String paramString)
  {
    if (!com.baidu.carlife.core.c.a().d())
    {
      b("请等待导航初始化成功");
      return;
    }
    if (!this.e) {
      p();
    }
    if (BNavigator.getInstance().isNaviBegin())
    {
      com.baidu.carlife.view.dialog.c localc = new com.baidu.carlife.view.dialog.c(this.i).a(2131296438).c(2131296264).d(2131296259);
      localc.a(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          d.this.e();
          if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
            BaiduNaviSDKManager.getInstance().quitNavi();
          }
          d.a(d.this, paramString);
        }
      });
      this.c.showDialog(localc, BaseDialog.a.a);
      return;
    }
    e();
    if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
      BaiduNaviSDKManager.getInstance().quitCruise();
    }
    c(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.d.d(h()))) {
      return;
    }
    com.baidu.carlife.core.i.a(HomeFragment.a);
    if (paramBoolean) {
      this.d.k();
    }
    for (;;)
    {
      com.baidu.carlife.core.k.b(4022);
      l();
      return;
      this.d.showLatestHomeFragment();
    }
  }
  
  public void b()
  {
    s();
    q();
    m();
  }
  
  public void b(final int paramInt, final Bundle paramBundle)
  {
    if (this.d.isCarlifeFragment(paramInt)) {}
    do
    {
      do
      {
        return;
        if ((paramInt != 554) && (paramInt != 81) && (paramInt != 304)) {
          break;
        }
        int k = 2131296440;
        if (paramInt == 554) {
          k = 2131296439;
        }
        while (BNavigator.getInstance().isNaviBegin())
        {
          com.baidu.carlife.view.dialog.c localc = new com.baidu.carlife.view.dialog.c(this.i).a(k).c(2131296264).d(2131296259);
          localc.a(new com.baidu.carlife.core.screen.b()
          {
            public void onClick()
            {
              d.this.e();
              if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
                BaiduNaviSDKManager.getInstance().quitNavi();
              }
              if (d.e(d.this).getCurrentFragmentType() != paramInt) {
                d.e(d.this).showFragment(paramInt, paramBundle);
              }
            }
          });
          this.c.showDialog(localc, BaseDialog.a.a);
          return;
          if (paramInt == 304) {
            k = 2131296441;
          }
        }
        e();
      } while (this.d.getCurrentFragmentType() == paramInt);
      if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
        BaiduNaviSDKManager.getInstance().quitCruise();
      }
      this.d.showFragment(paramInt, paramBundle);
      return;
      e();
    } while (this.d.getCurrentFragmentType() == paramInt);
    this.d.showFragment(paramInt, paramBundle);
  }
  
  public void b(com.baidu.carlife.core.screen.a parama)
  {
    a(parama, false);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.f != null) {
      this.f.updateStyle(paramBoolean);
    }
  }
  
  public void c()
  {
    s();
    q();
    n();
  }
  
  public void d()
  {
    q();
    e();
  }
  
  public void e()
  {
    if (h() < 512) {
      return;
    }
    if (!com.baidu.carlife.core.c.a().d())
    {
      b("请等待导航初始化成功");
      return;
    }
    com.baidu.carlife.core.i.a("BNRouteGuideFragment");
    if (this.d.f()) {
      this.d.showLatestNaviFragment();
    }
    for (;;)
    {
      this.c.updateMainDisplayStatus(4003);
      com.baidu.carlife.core.k.b(4022);
      StatisticManager.onEvent("1021", "百度地图");
      l();
      return;
      if (!this.e) {
        p();
      }
      this.d.showFragment(17, null);
    }
  }
  
  public void f()
  {
    if ((this.f != null) && (this.g))
    {
      FragmentTransaction localFragmentTransaction = this.d.getNaviFragmentManager().getFragmentManager().beginTransaction();
      localFragmentTransaction.hide(this.f);
      localFragmentTransaction.commitAllowingStateLoss();
      this.g = false;
      com.baidu.carlife.core.i.b("CarlifePresenter", "hideMapFragment");
    }
  }
  
  public void g()
  {
    if ((BaseFragment.mActivity != null) && (Build.VERSION.SDK_INT > 16) && (BaseFragment.mActivity.isDestroyed())) {}
    while (this.f == null) {
      return;
    }
    FragmentTransaction localFragmentTransaction = this.d.getNaviFragmentManager().getFragmentManager().beginTransaction();
    localFragmentTransaction.show(this.f);
    localFragmentTransaction.commitAllowingStateLoss();
    this.g = true;
    com.baidu.carlife.core.i.b("CarlifePresenter", "showMapFragment");
  }
  
  public int h()
  {
    return this.d.getCurrentFragmentType();
  }
  
  public int i()
  {
    return this.d.d();
  }
  
  public void j()
  {
    this.d.showFragment(h(), null);
  }
  
  private class a
    extends j
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void careAbout()
    {
      addMsg(4001);
      addMsg(4002);
      addMsg(4004);
      addMsg(4003);
      addMsg(1038);
      addMsg(2029);
      addMsg(1002);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      case 4001: 
        if (paramMessage.arg1 == 43992) {
          d.this.a(true);
        }
        for (;;)
        {
          n.a().i();
          return;
          d.this.a(false);
        }
      case 4002: 
        d.a(d.this);
        n.a().i();
        return;
      case 4004: 
        d.b(d.this);
        n.a().i();
        return;
      case 4003: 
        d.this.e();
        n.a().i();
        return;
      case 1038: 
        d.c(d.this).f();
        return;
      case 2029: 
        com.baidu.carlife.core.i.b("CarlifePresenter", "MSG_TELE_BT_DISCONNECT");
        d.d(d.this);
        return;
      }
      d.a(d.this, true);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/presentation/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */