package com.baidu.carlife;

import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.hardware.usb.UsbAccessory;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.ActionListener;
import android.net.wifi.p2p.WifiP2pManager.Channel;
import android.net.wifi.p2p.WifiP2pManager.ConnectionInfoListener;
import android.net.wifi.p2p.WifiP2pManager.DnsSdServiceResponseListener;
import android.net.wifi.p2p.WifiP2pManager.DnsSdTxtRecordListener;
import android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceInfo;
import android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceRequest;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PersistableBundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout.LayoutParams;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.carlife.adpter.q.b;
import com.baidu.carlife.connect.UsbStateReceiver;
import com.baidu.carlife.core.connect.WifiDirectBroadReceiver;
import com.baidu.carlife.core.d.a;
import com.baidu.carlife.core.f.a;
import com.baidu.carlife.core.screen.presentation.CarlifeActivityService;
import com.baidu.carlife.i.a.a;
import com.baidu.carlife.k.a.e.a;
import com.baidu.carlife.logic.voice.n;
import com.baidu.carlife.m.a.b;
import com.baidu.carlife.protobuf.CarlifeAuthenRequestProto.CarlifeAuthenRequest;
import com.baidu.carlife.protobuf.CarlifeAuthenResultProto.CarlifeAuthenResult;
import com.baidu.carlife.protobuf.CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection;
import com.baidu.carlife.protobuf.CarlifeCarGpsProto.CarlifeCarGps;
import com.baidu.carlife.protobuf.CarlifeCarSpeedProto.CarlifeCarSpeed;
import com.baidu.carlife.protobuf.CarlifeConStatisticProto.CarlifeConnectStatistics;
import com.baidu.carlife.protobuf.CarlifeDeviceInfoProto.CarlifeDeviceInfo;
import com.baidu.carlife.protobuf.CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo;
import com.baidu.carlife.protobuf.CarlifeErrorCodeProto.CarlifeErrorCode;
import com.baidu.carlife.protobuf.CarlifeModuleStatusProto.CarlifeModuleStatus;
import com.baidu.carlife.protobuf.CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus;
import com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion;
import com.baidu.carlife.protobuf.CarlifeStatisticsInfoProto.CarlifeStatisticsInfo;
import com.baidu.carlife.protobuf.CarlifeTouchActionProto.CarlifeTouchAction;
import com.baidu.carlife.protobuf.CarlifeVehicleInfoListProto.CarlifeVehicleInfoList;
import com.baidu.carlife.service.PhoneStateService;
import com.baidu.carlife.util.p;
import com.baidu.carlife.util.q;
import com.baidu.carlife.util.s;
import com.baidu.carlife.util.u;
import com.baidu.carlife.util.v;
import com.baidu.carlife.util.w;
import com.baidu.carlife.util.x;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navi.ActivityStack;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.ForegroundService;
import com.baidu.navi.controller.LaunchIntentHelper;
import com.baidu.navi.cruise.BCruiser;
import com.baidu.navi.cruise.control.EnterQuitLogicManager;
import com.baidu.navi.driveanalysis.TrackDataUpload;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.fragment.carmode.CarModeMapFragment;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.track.TrackCarDataSolveModel;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.view.DownNotifManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.commontool.BNAutoDayNightHelper;
import com.baidu.navisdk.comapi.commontool.BNDayNightChangedObserver;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.model.MainMapModel;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGPickPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarlifeActivity
  extends BaseActivity
  implements WifiP2pManager.ConnectionInfoListener, com.baidu.carlife.core.screen.a.b, com.baidu.carlife.core.screen.j
{
  public static String c = CarlifeActivity.class.getSimpleName();
  public static String d = "[WifiDirect]";
  public static final long f = -1L;
  public static final String g = "_ClfWfd";
  public static final String h = "_Clf._Wifi";
  public static final String i = "available";
  private boolean A = false;
  private VelocityTracker B;
  private boolean C = false;
  private com.baidu.carlife.k.r D;
  private com.baidu.carlife.view.dialog.t E;
  private boolean F;
  private com.baidu.carlife.core.screen.presentation.h G;
  private com.baidu.carlife.core.screen.presentation.a.h H;
  private String I = "";
  private WifiP2pManager J;
  private WifiP2pManager.Channel K;
  private WifiP2pDnsSdServiceRequest L;
  private WifiP2pDnsSdServiceInfo M = null;
  private WifiP2pDevice N = null;
  private com.baidu.carlife.core.connect.i O = null;
  private WifiDirectBroadReceiver P = null;
  private IntentFilter Q = new IntentFilter();
  private BNOfflineDataObserver R = new BNOfflineDataObserver()
  {
    public void update(BNSubject paramAnonymousBNSubject, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
    {
      switch (paramAnonymousInt1)
      {
      }
      do
      {
        return;
      } while (paramAnonymousInt2 != 277);
      CarlifeActivity.this.a(1);
    }
  };
  private boolean S = false;
  private boolean T = true;
  private a.a U = new a.a();
  private BNDayNightChangedObserver V = new BNDayNightChangedObserver()
  {
    public void update(BNSubject paramAnonymousBNSubject, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
    {
      if (paramAnonymousInt1 == 1) {}
      switch (paramAnonymousInt2)
      {
      default: 
        return;
      case 2: 
      case 4: 
      case 6: 
      case 8: 
      case 10: 
      case 12: 
        BNMapController.getInstance().setNightMode(false);
        CarlifeActivity.this.a(true);
        return;
      }
      BNMapController.getInstance().setNightMode(true);
      CarlifeActivity.this.a(false);
    }
  };
  protected boolean e = true;
  private com.baidu.carlife.view.dialog.c j = null;
  private ScreenListener k = null;
  private com.baidu.carlife.view.dialog.c l = null;
  private com.baidu.carlife.view.dialog.c m = null;
  private LaunchIntentHelper n;
  private Context o = null;
  private boolean p = false;
  private int q = 0;
  private Notification.Builder r = null;
  private NotificationManager s = null;
  private com.baidu.carlife.core.j t = null;
  private q.b u;
  private List<b> v = null;
  private boolean w = false;
  private int x = 0;
  private long y = 0L;
  private long z = 0L;
  
  private void A()
  {
    if (com.baidu.carlife.core.b.a.a())
    {
      com.baidu.carlife.view.a.a = false;
      new com.baidu.carlife.view.dialog.i(this.o).show();
    }
  }
  
  private void B()
  {
    if (this.S)
    {
      if (!BaiduNaviSDKManager.getInstance().isNaviBegin()) {
        break label85;
      }
      if (!this.S) {
        break label76;
      }
      BaiduNaviSDKManager.getInstance().closeNaviInstant();
      BaiduNaviSDKManager.getInstance().enterNavState();
      if ((RGRouteSearchModel.getInstance().isRouteSearchMode()) || (RGPickPointModel.getInstance().isPickPointShow())) {
        RGViewController.getInstance().onEmptyPoiAction();
      }
      RouteGuideFSM.getInstance().run("触碰地图");
    }
    label76:
    label85:
    while ((this.G.getCurrentFragmentType() != 17) || (!(this.G.getCurrentFragment() instanceof CarModeMapFragment))) {
      for (;;)
      {
        return;
        BNSettingManager.setIsShowMapSwitch(0);
        break;
        BaiduNaviSDKManager.getInstance().updateNaviInstant();
      }
    }
    ((CarModeMapFragment)this.G.getCurrentFragment()).showMapFocusView(this.S);
  }
  
  private void C()
  {
    if (com.baidu.carlife.core.b.a.a())
    {
      com.baidu.carlife.core.i.b(c, " sendPhoneStatusMsg internal screen capture ");
      b(true);
    }
    for (;;)
    {
      if (this.k != null) {
        this.k.b();
      }
      return;
      com.baidu.carlife.core.i.b(c, " sendPhoneStatusMsg fullscreen capture ");
      b(com.baidu.carlife.core.c.a().m());
    }
  }
  
  private void D()
  {
    if (this.k != null) {
      return;
    }
    this.k = new ScreenListener(this);
    this.k.a(new ScreenListener.a()
    {
      public void a()
      {
        com.baidu.carlife.core.i.e(CarlifeActivity.c, "onScreenOn");
        Object localObject = new com.baidu.carlife.core.connect.c(true);
        ((com.baidu.carlife.core.connect.c)localObject).c(65560);
        localObject = Message.obtain(null, ((com.baidu.carlife.core.connect.c)localObject).d(), 1001, 0, localObject);
        com.baidu.carlife.l.a.a().a((Message)localObject);
      }
      
      public void b()
      {
        com.baidu.carlife.core.i.e(CarlifeActivity.c, "onScreenOff");
        if (!com.baidu.carlife.core.b.a.a())
        {
          Object localObject = new com.baidu.carlife.core.connect.c(true);
          ((com.baidu.carlife.core.connect.c)localObject).c(65561);
          localObject = Message.obtain(null, ((com.baidu.carlife.core.connect.c)localObject).d(), 1001, 0, localObject);
          com.baidu.carlife.l.a.a().a((Message)localObject);
        }
      }
      
      public void c()
      {
        com.baidu.carlife.core.i.e(CarlifeActivity.c, "onUserPresent");
        Object localObject = new com.baidu.carlife.core.connect.c(true);
        ((com.baidu.carlife.core.connect.c)localObject).c(65562);
        localObject = Message.obtain(null, ((com.baidu.carlife.core.connect.c)localObject).d(), 1001, 0, localObject);
        com.baidu.carlife.l.a.a().a((Message)localObject);
      }
    });
  }
  
  private void E()
  {
    if (this.k != null)
    {
      this.k.a();
      this.k = null;
    }
  }
  
  private int F()
  {
    return this.G.getCurrentFragmentType();
  }
  
  private void G()
  {
    if (this.H.isDialogShown()) {
      this.H.dismissDialog(this.E);
    }
  }
  
  private void H()
  {
    this.D = new com.baidu.carlife.k.r(com.baidu.carlife.core.f.jx.a());
    this.D.toGetRequest();
    this.D.registerResponseListener(new e.a()
    {
      public void onNetWorkResponse(int paramAnonymousInt)
      {
        if (!CarlifeActivity.this.b) {
          return;
        }
        CarlifeActivity.B(CarlifeActivity.this);
      }
    });
  }
  
  private void I()
  {
    if (this.E == null) {
      this.E = new com.baidu.carlife.view.dialog.t(this);
    }
    if ((this.D.a()) && (com.baidu.carlife.l.a.a().N())) {
      this.H.showDialog(this.E);
    }
    while (!this.H.isDialogShown()) {
      return;
    }
    this.H.dismissDialog(this.E);
  }
  
  private void J()
  {
    this.J.stopPeerDiscovery(this.K, this.O.a("Activity: stop discovery ", true));
    this.J.removeGroup(this.K, this.O.a("Main: remove group", true));
    com.baidu.carlife.core.i.b(d, "Activity: stopDiscoverServices");
  }
  
  private void K()
  {
    if (this.M != null)
    {
      this.J.removeLocalService(this.K, this.M, this.O.b());
      this.J.clearLocalServices(this.K, this.O.c());
      this.M = null;
    }
    if (this.L != null)
    {
      this.J.removeServiceRequest(this.K, this.L, this.O.e());
      this.J.clearServiceRequests(this.K, this.O.d());
      this.L = null;
    }
  }
  
  private void L()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("available", "visible");
    this.M = WifiP2pDnsSdServiceInfo.newInstance("_ClfWfd", "_Clf._Wifi", localHashMap);
    this.J.addLocalService(this.K, this.M, this.O.f());
    com.baidu.carlife.core.i.b(d, "Activity: create as group owner!");
    this.J.createGroup(this.K, new WifiP2pManager.ActionListener()
    {
      public void onFailure(int paramAnonymousInt)
      {
        com.baidu.carlife.core.i.b(CarlifeActivity.d, "Activity: create group owner failure");
      }
      
      public void onSuccess()
      {
        com.baidu.carlife.core.i.b(CarlifeActivity.d, "Activity: create group owner success");
      }
    });
    t();
  }
  
  private void a(Message paramMessage)
  {
    if (!BaiduNaviManager.sIsBaseEngineInitialized) {}
    for (;;)
    {
      return;
      paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
      try
      {
        paramMessage = CarlifeCarGpsProto.CarlifeCarGps.parseFrom(paramMessage.f());
        this.U.a = paramMessage.getLatitude();
        this.U.b = paramMessage.getLongitude();
        this.U.c = paramMessage.getSpeed();
        this.U.d = paramMessage.getHeading();
        this.U.e = paramMessage.getHeight();
        this.U.h = (paramMessage.getPdop() / 10.0F);
        this.U.f = paramMessage.getSatsUsed();
        this.U.g = System.currentTimeMillis();
        com.baidu.carlife.i.a.a(this.U);
        if (this.T)
        {
          com.baidu.carlife.core.i.b(c, "firstGpsComing updateGpsInfo start");
          MainMapModel.getInstance().bFirstLoc = true;
          LocationManager.getInstance().onPause();
          com.baidu.carlife.i.a.a().a(true);
          com.baidu.carlife.i.a.a().b(true);
          EnterQuitLogicManager.getmInstance().reInitLocationService();
          BaiduNaviSDKManager.getInstance().reInitTrackLocationService();
          if (BCruiser.getInstance().isCruiseBegin()) {
            BCruiser.getInstance().reInitLocationService();
          }
          if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
            BaiduNaviSDKManager.getInstance().reInitCruiseLocationService();
          }
          if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
            BaiduNaviSDKManager.getInstance().reInitNaviLocationService(5);
          }
          com.baidu.carlife.i.a.a(this.U);
          com.baidu.carlife.i.a.a().b(true);
          this.T = false;
          com.baidu.carlife.core.i.b(c, "firstGpsComing updateGpsInfo end");
          return;
        }
      }
      catch (InvalidProtocolBufferException paramMessage)
      {
        com.baidu.carlife.core.i.e(c, "Get MSG_CMD_CAR_GPS Error");
        paramMessage.printStackTrace();
      }
    }
  }
  
  private void a(String paramString)
  {
    w.a(paramString, 0);
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    float f1;
    if (com.baidu.carlife.l.a.a().N())
    {
      if (!com.baidu.carlife.core.screen.a.a.b().g()) {
        break label149;
      }
      if (!com.baidu.carlife.core.screen.a.a.b().e()) {
        com.baidu.carlife.core.screen.a.a.b().j();
      }
      bool1 = bool2;
      if (com.baidu.carlife.core.c.a().h())
      {
        bool1 = bool2;
        if (!com.baidu.carlife.core.screen.a.a.b().e())
        {
          f1 = 0.0F;
          switch (paramMotionEvent.getAction())
          {
          }
        }
      }
    }
    for (;;)
    {
      if ((f1 > 1000.0F) && (this.H.m()))
      {
        this.H.a(false);
        com.baidu.carlife.core.screen.a.a.b().l();
      }
      bool1 = bool2;
      if (this.H.m()) {
        bool1 = true;
      }
      return bool1;
      label149:
      if (com.baidu.carlife.core.screen.a.a.b().c()) {
        break;
      }
      com.baidu.carlife.core.screen.a.a.b().a(4200, false, 0);
      break;
      if (this.B != null)
      {
        this.B.addMovement(paramMotionEvent);
        this.B.computeCurrentVelocity(1000);
        f1 = this.B.getXVelocity();
        continue;
        if (this.B == null) {
          this.B = VelocityTracker.obtain();
        }
        for (;;)
        {
          this.B.addMovement(paramMotionEvent);
          com.baidu.carlife.core.screen.a.a.b().k();
          break;
          this.B.clear();
        }
        com.baidu.carlife.core.screen.a.a.b().l();
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    com.baidu.carlife.core.i.b(c, "####### adaptScreen: [" + paramInt1 + " : " + paramInt2 + " ]");
    this.H.g().setLayoutParams(new FrameLayout.LayoutParams(paramInt2, paramInt1));
    this.H.g().invalidate();
    com.baidu.carlife.core.d.a().b(paramInt1);
    com.baidu.carlife.core.d.a().a(paramInt2);
    Configuration localConfiguration = getResources().getConfiguration();
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    localDisplayMetrics.heightPixels = paramInt1;
    localDisplayMetrics.widthPixels = paramInt2;
    getResources().updateConfiguration(localConfiguration, localDisplayMetrics);
    ScreenUtil.getInstance().init(this);
    if ((com.baidu.carlife.core.d.m()) && (this.G.getCurrentFragmentType() == 594)) {
      this.G.back();
    }
  }
  
  private void b(Message paramMessage)
  {
    paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
    for (;;)
    {
      try
      {
        paramMessage = CarlifeCarSpeedProto.CarlifeCarSpeed.parseFrom(paramMessage.f());
        com.baidu.carlife.core.i.b(c, "MSG_CMD_CAR_VELOCITY: speed = " + paramMessage.getSpeed() + ", timeStamp = " + paramMessage.getTimeStamp());
        int i1 = paramMessage.getSpeed();
        com.baidu.carlife.core.e.b(i1);
        if (com.baidu.carlife.logic.g.a().d())
        {
          if (i1 >= 5)
          {
            com.baidu.carlife.view.a.a().a(true);
            com.baidu.carlife.core.k.b(5151, i1);
          }
        }
        else {
          return;
        }
      }
      catch (InvalidProtocolBufferException paramMessage)
      {
        com.baidu.carlife.core.i.e(c, "Get MSG_CMD_CAR_VELOCITY Error");
        paramMessage.printStackTrace();
        return;
      }
      com.baidu.carlife.view.a.a().a(false);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (!com.baidu.carlife.l.a.a().m()) {
      return;
    }
    Object localObject = new com.baidu.carlife.core.connect.c(true);
    if (paramBoolean)
    {
      com.baidu.carlife.core.i.b(c, "send foreground message");
      ((com.baidu.carlife.core.connect.c)localObject).c(65563);
    }
    for (;;)
    {
      localObject = Message.obtain(null, ((com.baidu.carlife.core.connect.c)localObject).d(), 1001, 0, localObject);
      com.baidu.carlife.l.a.a().a((Message)localObject);
      return;
      com.baidu.carlife.core.i.b(c, "send background message");
      ((com.baidu.carlife.core.connect.c)localObject).c(65564);
    }
  }
  
  private void v()
  {
    int i1;
    if ((com.baidu.carlife.core.e.a().p()) && (com.baidu.carlife.core.e.a().o())) {
      i1 = 1;
    }
    for (;;)
    {
      if (i1 != 0) {
        StatisticManager.onEvent("1027", "1027");
      }
      com.baidu.carlife.logic.l.c().d();
      try
      {
        if (NavMapAdapter.getInstance().isLogin()) {
          StatisticManager.onEvent("1055", "已登入");
        }
        for (;;)
        {
          s.a(s.n, false, true, false);
          com.baidu.carlife.logic.music.h.b().c();
          com.baidu.carlife.core.e.b(com.baidu.carlife.core.f.jm, ".mp3");
          E();
          com.baidu.carlife.core.k.a();
          BNAutoDayNightHelper.getInstance().deleteObserver(this.V);
          BNaviModuleManager.setActivity(null);
          ForegroundService.stop(this);
          DownNotifManager.getInstance(this.o).clearAllNotifs();
          com.baidu.carlife.bluetooth.a.a().b();
          PhoneStateService.a(this);
          this.p = true;
          com.baidu.carlife.l.a.a().l();
          if (this.s != null) {
            this.s.cancelAll();
          }
          com.baidu.carlife.l.a.a().L();
          UsbStateReceiver.a().c();
          com.baidu.carlife.logic.a.a().b();
          f();
          h();
          BaseTTSPlayer.destory();
          com.baidu.carlife.util.r.b();
          new Thread(new Runnable()
          {
            public void run()
            {
              try
              {
                Thread.sleep(200L);
                BaiduNaviApplication.getInstance().exitApp(com.baidu.carlife.core.c.a().d());
                return;
              }
              catch (InterruptedException localInterruptedException)
              {
                for (;;)
                {
                  localInterruptedException.printStackTrace();
                }
              }
            }
          }).start();
          this.H.a(true);
          if (this.B != null) {
            this.B.recycle();
          }
          TipTool.setToastinInterface(null);
          com.baidu.carlife.view.g.e().a(null);
          TrackDataUpload.getInstance().stopTrackDataUpload();
          return;
          i1 = 0;
          break;
          StatisticManager.onEvent("1055", "未登入");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void w()
  {
    if (this.m == null) {
      this.m = new com.baidu.carlife.view.dialog.c(this.o).c("授权提示").b("为了正常使用此功能，请在手机上选择始终允许该权限").d("我知道了").q().a(1, 10);
    }
    if (!isFinishing()) {
      this.H.showDialog(this.m);
    }
  }
  
  private void x()
  {
    com.baidu.carlife.core.i.b(c, "++++++++++++++++++++Baidu Carlife Begin++++++++++++++++++++");
    com.baidu.carlife.core.f.jm = com.baidu.carlife.core.e.a().m() + "/" + "BaiduCarlife";
    Object localObject = new File(com.baidu.carlife.core.f.jm);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    com.baidu.carlife.core.i.a().b();
    com.baidu.carlife.l.a.a().a(this, CarlifeActivityService.class, this, com.baidu.carlife.util.r.b(2130838261), 2130838698);
    com.baidu.carlife.l.a.a().s();
    com.baidu.carlife.core.c.a().a(0);
    com.baidu.carlife.bluetooth.b.a().a(new com.baidu.carlife.bluetooth.e());
    ScreenUtil.getInstance().init(this);
    com.baidu.carlife.core.screen.a.a.b().a(this);
    com.baidu.carlife.logic.c.a().b();
    com.baidu.carlife.logic.d.a().b();
    com.baidu.carlife.l.a.a().b(this);
    UsbStateReceiver.a().a(this);
    y();
    this.t.postDelayed(new Runnable()
    {
      public void run() {}
    }, 5000L);
    setRequestedOrientation(0);
    com.baidu.carlife.m.a.a().a(u.a().b());
    com.baidu.carlife.m.a.a().a(new a.b()
    {
      public boolean a()
      {
        return com.baidu.carlife.l.a.a().J();
      }
    });
    TipTool.setToastinInterface(new v());
    this.s = ((NotificationManager)getSystemService("notification"));
    this.r = new Notification.Builder(this);
    localObject = PendingIntent.getActivity(this, 0, new Intent(this, CarlifeActivity.class), 134217728);
    this.r.setContentIntent((PendingIntent)localObject).setAutoCancel(true).setContentTitle(getString(2131297198));
    this.p = false;
    com.baidu.carlife.logic.r.a().a(this.o);
    D();
    com.baidu.carlife.logic.g.a().a(this.o);
    com.baidu.carlife.e.a.a().b();
    EnterQuitLogicManager.getmInstance().setActivity(this);
    TrackDataUpload.getInstance().startTrackDataUpload();
    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
    com.baidu.carlife.logic.g.a().c(true);
    com.baidu.carlife.logic.l.c().a(this.t);
    x.a();
    com.baidu.che.codriver.util.c.a(com.baidu.carlife.core.f.jx.a());
    if (Build.VERSION.SDK_INT >= 21) {
      r();
    }
    com.baidu.carlife.push.a.a().a(this.o);
    com.baidu.carlife.n.e.a().a(this, u());
    com.baidu.carlife.core.k.a(1009, 10000);
  }
  
  private void y()
  {
    com.baidu.carlife.l.a.a().a(com.baidu.carlife.core.a.a().getResources().getDimensionPixelOffset(2131361989), new com.baidu.carlife.core.screen.b.c()
    {
      public boolean a(int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        default: 
          return false;
        case 15: 
          if (n.a().l())
          {
            com.baidu.carlife.core.i.b(CarlifeActivity.c, "-----KEYCODE_SEEK_SUB-----VRShow return");
            return true;
          }
          com.baidu.carlife.logic.music.h.b().a(false);
          return true;
        case 16: 
          if (n.a().l())
          {
            com.baidu.carlife.core.i.b(CarlifeActivity.c, "-----KEYCODE_SEEK_ADD-----VRShow return");
            return true;
          }
          com.baidu.carlife.logic.music.h.b().a(true);
          return true;
        case 30: 
          com.baidu.carlife.core.k.a(98333, 0, 0, null);
          return true;
        case 29: 
          com.baidu.carlife.core.k.a(98334, 0, 0, null);
          return true;
        case 11: 
          com.baidu.carlife.core.k.a(98335, 0, 0, null);
          return true;
        case 9: 
          com.baidu.carlife.core.k.a(98336, 0, 0, null);
          return true;
        case 33: 
          new Handler(Looper.getMainLooper()).post(new Runnable()
          {
            public void run()
            {
              n.a().f();
            }
          });
          return true;
        case 34: 
          com.baidu.carlife.core.k.b(4160);
          return true;
        case 31: 
          if (n.a().l())
          {
            com.baidu.carlife.core.i.b(CarlifeActivity.c, "-----KEYCODE_MEDIA_START----- return");
            return true;
          }
          com.baidu.carlife.logic.music.h.b().C();
          return true;
        }
        com.baidu.carlife.core.i.b("CarLifeMusic", "-----KEYCODE_MEDIA_STOP---pause(true)---");
        com.baidu.carlife.logic.music.h.b().D();
        return true;
      }
    });
  }
  
  private void z()
  {
    int i1 = this.G.getCurrentFragmentType();
    if ((i1 == 548) || (i1 == 561)) {
      this.G.getCurrentFragment().back();
    }
    while ((i1 != 537) && (i1 != 548) && (i1 != 551) && (i1 != 561) && (i1 != 562) && (i1 != 566) && (i1 != 532)) {
      return;
    }
    this.G.back();
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    if (paramBoolean) {
      localLayoutParams.flags |= 0x80;
    }
    localWindow.setAttributes(localLayoutParams);
  }
  
  public void a(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(Intent paramIntent, int paramInt)
  {
    startActivityForResult(paramIntent, paramInt);
  }
  
  public void a(WifiP2pDevice paramWifiP2pDevice)
  {
    WifiP2pConfig localWifiP2pConfig = new WifiP2pConfig();
    localWifiP2pConfig.deviceAddress = paramWifiP2pDevice.deviceAddress;
    localWifiP2pConfig.wps.setup = 0;
    com.baidu.carlife.core.i.b(d, "---------------connectP2p : " + paramWifiP2pDevice.deviceAddress + " | " + paramWifiP2pDevice.deviceName);
    if (this.L != null) {
      this.J.removeServiceRequest(this.K, this.L, this.O.a("Activity: connecting remove request", true));
    }
    this.J.connect(this.K, localWifiP2pConfig, this.O.a("Activity: connectP2p ", true));
  }
  
  public void a(b paramb)
  {
    if (paramb == null) {}
    do
    {
      return;
      if (this.v == null) {
        this.v = new ArrayList();
      }
    } while (this.v.contains(paramb));
    this.v.add(paramb);
  }
  
  public void a(q.b paramb)
  {
    this.u = paramb;
  }
  
  public void a(boolean paramBoolean)
  {
    StyleManager.setDayStyle(paramBoolean);
    BNStyleManager.setDayStyle(paramBoolean);
    this.H.c(paramBoolean);
    ContentFragment localContentFragment = this.G.getCurrentFragment();
    if (localContentFragment != null)
    {
      com.baidu.carlife.core.i.b("style", "fragment " + localContentFragment.getClass().getSimpleName());
      localContentFragment.updateStyle(paramBoolean);
    }
    if ((localContentFragment != null) && (this.G.isCarlifeFragment(localContentFragment.getType())) && (this.G.j() != null))
    {
      localContentFragment = (ContentFragment)this.G.j();
      if (localContentFragment != null)
      {
        com.baidu.carlife.core.i.b("style", "map mdule fragment " + localContentFragment.getClass().getSimpleName());
        localContentFragment.updateStyle(paramBoolean);
      }
    }
    this.e = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    if (this.r == null) {
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.r.setWhen(System.currentTimeMillis());
      this.s.notify(5000, this.r.build());
      return;
      this.r.setSmallIcon(2130838679);
      this.r.setTicker(getString(2131297195));
      this.r.setContentText(getString(2131297195));
      continue;
      this.r.setSmallIcon(2130838679);
      this.r.setTicker(getString(2131297194));
      this.r.setContentText(getString(2131297194));
      continue;
      this.r.setSmallIcon(2130838676);
      this.r.setTicker(getString(2131297193));
      this.r.setContentText(getString(2131297193));
      continue;
      this.r.setSmallIcon(2130838679);
      this.r.setTicker(getString(2131297197));
      this.r.setContentText(getString(2131297197));
      continue;
      this.r.setSmallIcon(2130838676);
      this.r.setTicker(getString(2131297196));
      this.r.setContentText(getString(2131297196));
    }
  }
  
  public void b(b paramb)
  {
    if ((paramb != null) && (this.v != null) && (this.v.contains(paramb))) {
      this.v.remove(paramb);
    }
  }
  
  public void c()
  {
    if (this.n != null) {
      this.n.handleLaunchIntent();
    }
  }
  
  public void d()
  {
    if ((x.b()) && (com.baidu.carlife.l.a.a().N())) {}
    do
    {
      return;
      com.baidu.carlife.core.i.b(c, "Open Exit app dialog");
      if (this.j == null)
      {
        this.j = new com.baidu.carlife.view.dialog.c(this).b(2131296286).a(2131296287).g(17).c(2131296264).q().d(2131296259);
        this.j.a(new com.baidu.carlife.core.screen.b()
        {
          public void onClick()
          {
            if (-1L != CarlifeActivity.b(CarlifeActivity.this))
            {
              long l1 = System.currentTimeMillis();
              long l2 = CarlifeActivity.b(CarlifeActivity.this);
              StatisticManager.onEventDuration(com.baidu.carlife.core.a.a(), "COMMON_0005", "单次使用时长", (int)(l1 - l2));
              CarlifeActivity.a(CarlifeActivity.this, -1L);
            }
            com.baidu.carlife.core.e.l();
            ActivityStack.exitApp(com.baidu.carlife.core.c.a().d());
          }
        });
        this.j.setOnDialogCancelListener(new com.baidu.carlife.core.screen.d()
        {
          public void onCancel()
          {
            if (com.baidu.carlife.core.screen.a.a.b().g())
            {
              com.baidu.carlife.core.screen.a.a.b().a(4201, true, 30000);
              com.baidu.carlife.core.screen.a.a.b().l();
            }
          }
        });
      }
    } while (this.H.isDialogShown());
    this.H.showDialog(this.j);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (a(paramMotionEvent)) {
      return true;
    }
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return true;
  }
  
  public boolean e()
  {
    return (this.j != null) && (this.H.isDialogShown());
  }
  
  public void f()
  {
    BNRoutePlaner.getInstance().setObserver(null);
  }
  
  public void g()
  {
    if (this.R != null) {
      BNOfflineDataManager.getInstance().addObserver(this.R);
    }
  }
  
  public void h()
  {
    if (this.R != null) {
      BNOfflineDataManager.getInstance().deleteObserver(this.R);
    }
  }
  
  public int i()
  {
    return this.q;
  }
  
  public void j()
  {
    if (this.l == null) {
      if (this.q != 1) {
        break label111;
      }
    }
    label111:
    for (int i1 = 2131296408;; i1 = 2131296819)
    {
      this.l = new com.baidu.carlife.view.dialog.c(this).a(i1).c(2131296406).q().d(2131296407);
      this.l.a(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          PreferenceHelper.getInstance(BaiduNaviApplication.getInstance().getApplicationContext()).putBoolean("NAVI_SHOW_ONLINE_USE", false);
          CarlifeActivity.a(CarlifeActivity.this).showFragment(554, null);
        }
      });
      this.l.b(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          PreferenceHelper.getInstance(BaiduNaviApplication.getInstance().getApplicationContext()).putBoolean("NAVI_SHOW_ONLINE_USE", false);
        }
      });
      if ((!this.H.isDialogShown()) && (!isFinishing())) {
        this.H.showDialog(this.l);
      }
      return;
    }
  }
  
  public void k()
  {
    if ((this.l != null) && (this.H.isDialogShown())) {
      this.H.dismissDialog(this.l);
    }
  }
  
  public void l()
  {
    try
    {
      com.baidu.carlife.core.i.b(c, "go to foreground");
      Intent localIntent = new Intent("android.intent.action.MAIN");
      localIntent.addCategory("android.intent.category.LAUNCHER");
      localIntent.setClass(this, CarlifeActivity.class);
      localIntent.setFlags(335544320);
      startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      com.baidu.carlife.core.i.b(c, "go to foreground fail");
      localException.printStackTrace();
    }
  }
  
  public void m()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    View localView = getCurrentFocus();
    if (localView != null) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 2);
    }
  }
  
  public void n()
  {
    BNAutoDayNightHelper.getInstance().addObserver(this.V);
  }
  
  public void o()
  {
    com.baidu.carlife.core.i.b(c, "onVehicleConnected() ");
    setVehicleConnected(true);
    if ((com.baidu.carlife.core.b.a.a()) && (com.baidu.carlife.logic.r.a().b()))
    {
      Intent localIntent = new Intent("com.baidu.carlife.Action.StartActivityBroadReceiver");
      BaseFragment.getNaviActivity().sendBroadcast(localIntent);
    }
    if (this.A) {
      super.onResume();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.baidu.carlife.core.i.e("zzt", "requestCode:  " + paramInt1 + " resultCode:  " + paramInt2 + "  data: " + paramIntent);
    if ((paramInt1 == 4353) && (paramInt2 == -1))
    {
      com.baidu.carlife.logic.g.a();
      com.baidu.carlife.logic.g.g();
    }
    com.baidu.carlife.l.a.a().a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed() {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    com.baidu.carlife.core.i.b("BtTelephoneSwitchHelper", "onConfigurationChanged");
    super.onConfigurationChanged(paramConfiguration);
    b.a().a(paramConfiguration);
  }
  
  public void onConnectionInfoAvailable(WifiP2pInfo paramWifiP2pInfo)
  {
    if (paramWifiP2pInfo.isGroupOwner) {
      com.baidu.carlife.core.i.b(d, "-------------- Connected as group owner");
    }
    for (;;)
    {
      com.baidu.carlife.core.i.b(d, "Group Owner IP : " + paramWifiP2pInfo.groupOwnerAddress);
      return;
      com.baidu.carlife.core.i.b(d, "-------------- Connected as peer");
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    com.baidu.carlife.l.a.a().T();
    com.baidu.carlife.core.i.b(c, "onCreate");
    this.y = System.currentTimeMillis();
    com.baidu.carlife.core.i.a(c);
    getWindow().addFlags(128);
    getWindow().addFlags(1024);
    requestWindowFeature(1);
    com.baidu.carlife.core.screen.presentation.h.a(new NaviFragmentManager(this));
    super.onCreate(paramBundle);
    this.G = com.baidu.carlife.core.screen.presentation.h.a();
    this.o = this;
    this.t = new a(getMainLooper());
    com.baidu.carlife.core.k.a(this.t);
    BaseFragment.initBeforeAll(this);
    this.H = new com.baidu.carlife.core.screen.presentation.a.h(this);
    setContentView(this.H.g());
    this.H.a(514, null);
    this.H.a(getWindow());
    x();
    this.n = new LaunchIntentHelper(this, getIntent(), this.H);
    try
    {
      if ("android.hardware.usb.action.USB_ACCESSORY_ATTACHED".equals(getIntent().getAction()))
      {
        com.baidu.carlife.core.i.b(c, "USB Accessory attached onCreate");
        paramBundle = (UsbAccessory)getIntent().getParcelableExtra("accessory");
        com.baidu.carlife.l.a.a().a(this, paramBundle);
      }
      b.a().b();
      com.baidu.carlife.custom.elhyf.b.a().a(this);
      this.H.a(2130838204);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        com.baidu.carlife.core.i.b(c, "start usb accessory attached fail");
        paramBundle.printStackTrace();
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    com.baidu.carlife.push.a.a().c();
    if (this.P != null)
    {
      unregisterReceiver(this.P);
      J();
      K();
      this.P = null;
    }
    com.baidu.carlife.core.i.b(c, "onDestroy");
    if (-1L != this.y)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.y;
      StatisticManager.onEventDuration(com.baidu.carlife.core.a.a(), "COMMON_0005", "单次使用时长", (int)(l1 - l2));
      this.y = -1L;
    }
    b.a().g();
    v();
    super.onDestroy();
    com.baidu.carlife.core.i.a().c();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (com.baidu.carlife.core.screen.a.a.b().g()) {
      if (paramInt == 82)
      {
        com.baidu.carlife.core.i.b("fangsheng", "======phone====KEYCODE_MENU=========");
        com.baidu.carlife.core.screen.a.a.b().j();
      }
    }
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      if (paramInt == 4)
      {
        com.baidu.carlife.core.i.b("fangsheng", "======phone====KEYCODE_BACK=========");
        if (!com.baidu.carlife.core.screen.a.a.b().c()) {
          com.baidu.carlife.core.screen.a.a.b().a(com.baidu.carlife.core.screen.a.a.b().h());
        }
      }
      else if (paramInt == 25)
      {
        com.baidu.carlife.core.i.b(c, "KeyEvent.KEYCODE_VOLUME_DOWN is detected!");
        com.baidu.carlife.l.a.a().a(this);
      }
      else if (paramInt == 85)
      {
        com.baidu.carlife.l.a.a().I();
        continue;
        if ((this.v != null) && (this.v.size() > 0))
        {
          int i1 = 0;
          while (i1 < this.v.size())
          {
            if (((b)this.v.get(i1)).a(paramInt, paramKeyEvent)) {
              return true;
            }
            i1 += 1;
          }
        }
      }
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    com.baidu.carlife.core.i.b(c, "onNewIntent");
    super.onNewIntent(paramIntent);
    String str;
    if (paramIntent != null)
    {
      this.I = paramIntent.getAction();
      if (TextUtils.equals("com.baidu.carlife.Action.WECHAT", this.I))
      {
        b.a().a(paramIntent);
        return;
      }
      this.I = null;
      str = paramIntent.getStringExtra("OpenDownloadManager");
      if ((str == null) || (!str.equals("open"))) {
        break label218;
      }
      if (this.G.getCurrentFragmentType() != 554) {
        this.H.a(554, null);
      }
      label98:
      setIntent(paramIntent);
      str = paramIntent.getStringExtra("thirdparty_package");
      if (TextUtils.isEmpty(str)) {
        break label282;
      }
      getIntent().putExtra("thirdparty_package", str);
      com.baidu.carlife.core.i.b("ouyang", "---onNewIntent----");
    }
    for (;;)
    {
      b.a().a(paramIntent);
      try
      {
        if ((!"android.hardware.usb.action.USB_ACCESSORY_ATTACHED".equals(getIntent().getAction())) || (com.baidu.carlife.l.a.a().N())) {
          break;
        }
        com.baidu.carlife.core.i.b(c, "USB Accessory attached onNewIntent");
        paramIntent = (UsbAccessory)getIntent().getParcelableExtra("accessory");
        com.baidu.carlife.l.a.a().a(this, paramIntent);
        return;
      }
      catch (Exception paramIntent)
      {
        com.baidu.carlife.core.i.b(c, "start usb accessory attached fail");
        paramIntent.printStackTrace();
        return;
      }
      label218:
      if ((str == null) || (!str.equals("openmap"))) {
        break label98;
      }
      if (this.G.getCurrentFragmentType() == 555)
      {
        this.G.back();
        break label98;
      }
      if (this.G.getCurrentFragmentType() == 556) {
        break label98;
      }
      this.H.a(556, null);
      break label98;
      label282:
      com.baidu.carlife.core.i.b("ouyang", "---onNewIntent--null--");
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    com.baidu.carlife.core.i.b(c, "SEND: ONPAUSE()");
    this.A = true;
    MapViewFactory.getInstance().saveMapCache();
    MapViewFactory.getInstance().saveMapStatus();
    n.a().p();
    com.baidu.carlife.l.a.a().k();
    b.a().e();
    this.H.o();
  }
  
  protected void onRestart()
  {
    super.onRestart();
  }
  
  protected void onResume()
  {
    super.onResume();
    com.baidu.carlife.core.i.b(c, "SEND: ONRESUME()");
    this.H.l();
    ForegroundService.stop(this);
    if ((this.A) && (com.baidu.carlife.logic.g.a().c())) {
      this.t.postDelayed(new Runnable()
      {
        public void run()
        {
          ContentFragment localContentFragment = CarlifeActivity.a(CarlifeActivity.this).getCurrentFragment();
          com.baidu.carlife.core.i.b(CarlifeActivity.c, "CurrentFragment = " + localContentFragment.getClass().toString());
          if ((com.baidu.carlife.f.d.a().h()) && (localContentFragment != null)) {
            localContentFragment.onInitFocusAreas();
          }
        }
      }, 1000L);
    }
    com.baidu.carlife.core.c.a().j(true);
    this.A = false;
    com.baidu.carlife.l.a.a().g();
    b.a().d();
    this.H.n();
    n.a().q();
    if (TextUtils.equals(this.I, "com.baidu.carlife.Action.WECHAT"))
    {
      com.baidu.carlife.wechat.a.b.c.c("start activity by wechat msg");
      this.I = null;
      com.baidu.carlife.wechat.c.a.a().f();
    }
    com.baidu.carlife.core.i.b(c);
    com.baidu.carlife.logic.l.c().a(true);
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onSaveInstanceState(Bundle paramBundle, PersistableBundle paramPersistableBundle) {}
  
  protected void onStart()
  {
    super.onStart();
    String str = getIntent().getStringExtra("thirdparty_package");
    if (TextUtils.isEmpty(str)) {
      com.baidu.carlife.core.i.b("ouyang", "---isfromthirdparty--null--");
    }
    for (;;)
    {
      b.a().c();
      com.baidu.baidumaps.base.localmap.f.a().c();
      return;
      this.t.sendMessage(Message.obtain(this.t, 4013, str));
      getIntent().putExtra("thirdparty_package", "");
    }
  }
  
  public void onStateNotSaved() {}
  
  protected void onStop()
  {
    super.onStop();
    com.baidu.carlife.core.i.b(c, "SEND: ONSTOP()");
    if ((com.baidu.carlife.core.b.a.a()) && (com.baidu.carlife.l.a.a().N())) {
      com.baidu.carlife.core.i.b(c, " onStop internal screen capture ");
    }
    for (;;)
    {
      com.baidu.carlife.core.c.a().j(false);
      b.a().f();
      if ((!com.baidu.carlife.logic.g.a().f()) || (Build.VERSION.SDK_INT < 19)) {
        EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
      }
      com.baidu.carlife.logic.l.c().a(false);
      com.baidu.baidumaps.base.localmap.f.a().d();
      com.baidu.carlife.e.a.a().n();
      com.baidu.carlife.e.a.c();
      return;
      com.baidu.carlife.core.i.b(c, " onStop fullscreen capture, Invoke ForegroundService.start ");
      ForegroundService.start(this);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    boolean bool = true;
    super.onWindowFocusChanged(paramBoolean);
    com.baidu.carlife.core.i.b("Bt", "onWindowFocusChanged = " + paramBoolean);
    com.baidu.carlife.core.screen.presentation.a.h localh = this.H;
    if (!paramBoolean)
    {
      paramBoolean = true;
      if (this.A) {
        break label63;
      }
    }
    for (;;)
    {
      localh.a(paramBoolean, bool);
      return;
      paramBoolean = false;
      break;
      label63:
      bool = false;
    }
  }
  
  public void p()
  {
    com.baidu.carlife.core.i.b(c, "onVehicleDisconnect");
    setVehicleConnected(false);
    if (com.baidu.carlife.l.a.a().n() != null) {
      attachHost();
    }
    com.baidu.carlife.core.screen.presentation.h.a().a(this);
    this.H.h();
  }
  
  public boolean q()
  {
    return this.A;
  }
  
  public void r()
  {
    com.baidu.carlife.core.i.b(d, "Activity: initWifiDirect ");
    this.J = ((WifiP2pManager)getSystemService("wifip2p"));
    this.K = this.J.initialize(this, getMainLooper(), null);
    if ((this.J == null) || (this.K == null)) {
      com.baidu.carlife.core.i.e(d, "Activity: InitWifiP2pManager error!");
    }
    this.O = com.baidu.carlife.core.connect.i.a();
    K();
    s();
    L();
  }
  
  public void s()
  {
    if (this.Q == null) {
      this.Q = new IntentFilter();
    }
    this.Q.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    this.Q.addAction("android.net.wifi.p2p.STATE_CHANGED");
    this.Q.addAction("android.net.wifi.p2p.PEERS_CHANGED");
    this.Q.addAction("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");
    this.Q.addAction("android.net.wifi.p2p.THIS_DEVICE_CHANGED");
    this.Q.addAction("android.net.wifi.p2p.DISCOVERY_STATE_CHANGE");
    this.P = new WifiDirectBroadReceiver(this.J, this.K, this);
    registerReceiver(this.P, this.Q);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    if (getRequestedOrientation() == paramInt) {
      return;
    }
    super.setRequestedOrientation(paramInt);
  }
  
  public void t()
  {
    com.baidu.carlife.core.i.b(d, "------------------- Start Discover--------------------------");
    com.baidu.carlife.core.i.b(d, "Activity: discoverService");
    this.J.setDnsSdResponseListeners(this.K, new WifiP2pManager.DnsSdServiceResponseListener()new WifiP2pManager.DnsSdTxtRecordListener
    {
      public void onDnsSdServiceAvailable(String paramAnonymousString1, String paramAnonymousString2, WifiP2pDevice paramAnonymousWifiP2pDevice)
      {
        com.baidu.carlife.core.i.b(CarlifeActivity.d, "Activity: p2p Service Available : " + paramAnonymousString1);
        if (paramAnonymousString1.equalsIgnoreCase("_ClfWfd"))
        {
          com.baidu.carlife.core.i.b(CarlifeActivity.d, "Activity: onDnsSdServiceAvailable");
          if (CarlifeActivity.C(CarlifeActivity.this) == null) {
            CarlifeActivity.a(CarlifeActivity.this, new WifiP2pDevice());
          }
          CarlifeActivity.a(CarlifeActivity.this, paramAnonymousWifiP2pDevice);
        }
      }
    }, new WifiP2pManager.DnsSdTxtRecordListener()
    {
      public void onDnsSdTxtRecordAvailable(String paramAnonymousString, Map<String, String> paramAnonymousMap, WifiP2pDevice paramAnonymousWifiP2pDevice)
      {
        com.baidu.carlife.core.i.b(CarlifeActivity.d, "Activity: --------------------- onDnsSdTxtRecordAvailable");
        com.baidu.carlife.core.i.b(CarlifeActivity.d, paramAnonymousWifiP2pDevice.deviceName + " is " + (String)paramAnonymousMap.get("available"));
      }
    });
    this.L = WifiP2pDnsSdServiceRequest.newInstance();
    this.J.addServiceRequest(this.K, this.L, this.O.g());
    this.J.discoverServices(this.K, this.O.h());
  }
  
  public com.baidu.carlife.core.screen.presentation.a.h u()
  {
    return this.H;
  }
  
  private class a
    extends com.baidu.carlife.core.j
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void careAbout()
    {
      addMsg(1004);
      addMsg(1003);
      addMsg(1002);
      addMsg(1009);
      addMsg(4027);
      addMsg(4028);
      addMsg(4010);
      addMsg(98333);
      addMsg(98334);
      addMsg(98335);
      addMsg(98336);
      addMsg(65538);
      addMsg(98305);
      addMsg(98307);
      addMsg(98320);
      addMsg(98319);
      addMsg(98341);
      addMsg(98309);
      addMsg(98343);
      addMsg(98344);
      addMsg(1037);
      addMsg(1039);
      addMsg(1060);
      addMsg(4251);
      addMsg(98311);
      addMsg(1040);
      addMsg(98370);
      addMsg(2004);
      addMsg(98389);
      addMsg(98376);
      addMsg(98378);
      addMsg(2147418113);
      addMsg(4303);
      addMsg(1007);
      addMsg(98354);
      addMsg(98400);
      addMsg(98371);
      addMsg(98373);
      addMsg(98374);
      addMsg(52480);
      addMsg(98345);
      addMsg(65640);
      addMsg(1070);
      addMsg(1071);
      addMsg(427);
      addMsg(428);
      addMsg(1072);
    }
    
    public void handleMessage(Message paramMessage)
    {
      boolean bool1;
      try
      {
        com.baidu.carlife.core.i.c(CarlifeActivity.c, "handleMessage=" + paramMessage.what);
        bool1 = com.baidu.carlife.core.c.a().e();
        switch (paramMessage.what)
        {
        case 1004: 
          CarlifeActivity.b(CarlifeActivity.this, System.currentTimeMillis());
          com.baidu.baidunavis.control.NavTrajectoryController.hasConnected = true;
          CarlifeActivity.c(CarlifeActivity.this);
          CarlifeActivity.this.m();
          com.baidu.carlife.core.i.e(CarlifeActivity.c, "---------CONNECT_STATUS_CONNECTED---------");
          CarlifeActivity.a(CarlifeActivity.this, CarlifeActivity.d(CarlifeActivity.this).getString(2131297199));
          com.baidu.carlife.l.a.a().P();
          UsbStateReceiver.a().d();
          CarlifeActivity.this.b(1004);
          com.baidu.carlife.core.f.jv = false;
          com.baidu.carlife.core.k.b(4010);
          if (CarlifeActivity.e(CarlifeActivity.this))
          {
            CarlifeActivity.a(CarlifeActivity.this, false);
            StatisticManager.onEventEnd(CarlifeActivity.d(CarlifeActivity.this), "1002", "HU_CONNECT_MOBILE_AVG_TIME");
          }
          StatisticManager.onEvent("COMMON_0002");
          StatisticManager.onEvent("1001", "1001");
          s.m = System.currentTimeMillis();
          s.n = true;
          com.baidu.carlife.core.l.a().postDelayed(new Runnable()
          {
            public void run()
            {
              boolean bool = com.baidu.carlife.bluetooth.f.a().k();
              StatisticManager.onEvent("1058", "1058_" + bool);
            }
          }, 60000L);
          com.baidu.carlife.logic.l.c().d();
          com.baidu.carlife.push.a.a().c();
          return;
        }
      }
      catch (Exception paramMessage)
      {
        com.baidu.carlife.core.i.e(CarlifeActivity.c, "handle message exception");
        paramMessage.printStackTrace();
        return;
      }
      com.baidu.carlife.core.i.e(CarlifeActivity.c, "---------CONNECT_STATUS_CONNECTING---------");
      com.baidu.carlife.l.a.a().e(false);
      CarlifeActivity.f(CarlifeActivity.this);
      CarlifeActivity.this.sendBroadcast(new Intent("com.baidu.carlife.connecting"));
      com.baidu.carlife.core.k.b(3008);
      if (!CarlifeActivity.e(CarlifeActivity.this))
      {
        StatisticManager.onEventStart(CarlifeActivity.d(CarlifeActivity.this), "1002", "HU_CONNECT_MOBILE_AVG_TIME");
        CarlifeActivity.a(CarlifeActivity.this, true);
        return;
        com.baidu.carlife.core.i.e(CarlifeActivity.c, "---------CONNECT_STATUS_DISCONNECTED---------");
        com.baidu.carlife.core.e.b(-1);
        com.baidu.carlife.view.a.a().a(false);
        com.baidu.carlife.core.k.a(1040);
        if ((com.baidu.carlife.core.d.a().b() == d.a.a) || (com.baidu.carlife.core.d.m()))
        {
          CarlifeActivity.a(CarlifeActivity.this, com.baidu.carlife.core.d.a().e(), com.baidu.carlife.core.d.a().d());
          CarlifeActivity.g(CarlifeActivity.this);
          com.baidu.carlife.core.d.a().f();
        }
        long l1 = System.currentTimeMillis();
        long l2 = CarlifeActivity.h(CarlifeActivity.this);
        StatisticManager.onEventDuration(com.baidu.carlife.core.a.a(), "COMMON_0006", "用户单次联机使用时长", (int)(l1 - l2));
        com.baidu.carlife.custom.a.a().c();
        com.baidu.carlife.custom.b.a().c();
        com.baidu.carlife.core.e.b(null);
        com.baidu.carlife.view.a.a().d();
        com.baidu.carlife.l.a.a().e(false);
        com.baidu.carlife.logic.g.a().b(false);
        com.baidu.carlife.l.a.a().M();
        com.baidu.carlife.logic.g.a().e();
        CarlifeActivity.f(CarlifeActivity.this);
        if (!CarlifeActivity.i(CarlifeActivity.this))
        {
          com.baidu.carlife.core.i.b(CarlifeActivity.c, "!firstGpsComing disconnected start");
          MainMapModel.getInstance().bFirstLoc = true;
          if (BCruiser.getInstance().isCruiseBegin())
          {
            com.baidu.carlife.i.a.a().b(false);
            BCruiser.getInstance().reInitLocationService();
          }
          if (BaiduNaviSDKManager.getInstance().isCruiseBegin())
          {
            com.baidu.carlife.i.a.a().b(false);
            BaiduNaviSDKManager.getInstance().reInitCruiseLocationService();
          }
          if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
            BaiduNaviSDKManager.getInstance().reInitNaviLocationService(1);
          }
          com.baidu.carlife.i.a.a().b(false);
          com.baidu.carlife.i.a.a().a(false);
          EnterQuitLogicManager.getmInstance().reInitLocationService();
          BaiduNaviSDKManager.getInstance().reInitTrackLocationService();
          LocationManager.getInstance().onResume();
          CarlifeActivity.b(CarlifeActivity.this, true);
          com.baidu.carlife.core.i.b(CarlifeActivity.c, "!firstGpsComing disconnected end");
        }
        com.baidu.carlife.i.a.a().a(false);
        CarlifeActivity.a(CarlifeActivity.this, CarlifeActivity.d(CarlifeActivity.this).getString(2131297200));
        com.baidu.carlife.l.a.a().Q();
        com.baidu.carlife.m.a.a().a(false);
        CarlifeActivity.this.b(1002);
        com.baidu.carlife.core.f.jv = true;
        com.baidu.carlife.core.k.b(3008);
        com.baidu.carlife.core.screen.a.a.b().a(4200, false, 0);
        com.baidu.carlife.core.screen.a.a.b().e(false);
        com.baidu.carlife.core.screen.a.a.b().b(4201);
        com.baidu.carlife.core.screen.a.a.b().b(4202);
        com.baidu.carlife.logic.k.a().a(6, 0);
        com.baidu.carlife.util.t.a();
        if (!com.baidu.carlife.core.c.a().h()) {
          com.baidu.carlife.core.l.a().postDelayed(new Runnable()
          {
            public void run() {}
          }, 2000L);
        }
        com.baidu.carlife.core.c.a().e(false);
        com.baidu.carlife.core.c.a().f(false);
        CarlifeActivity.j(CarlifeActivity.this).a(false);
        com.baidu.carlife.core.screen.a.a.b().k();
        s.a(true, true, false, false);
        s.n = false;
        s.a(null);
        if (CarlifeActivity.k(CarlifeActivity.this) != null) {
          CarlifeActivity.k(CarlifeActivity.this).a();
        }
        com.baidu.carlife.core.e.c("");
        com.baidu.carlife.core.e.d("");
        if (!BNavigator.getInstance().isNaviBegin()) {
          TrackCarDataSolveModel.setCarlifeStatisticsInfo(null);
        }
        com.baidu.carlife.core.c.a().h(false);
        com.baidu.carlife.j.a.a().b(false);
        com.baidu.carlife.b.a.a().c();
        if (CarlifeActivity.l(CarlifeActivity.this))
        {
          CarlifeActivity.c(CarlifeActivity.this, false);
          CarlifeActivity.m(CarlifeActivity.this);
        }
        CarlifeActivity.n(CarlifeActivity.this);
        com.baidu.carlife.logic.l.c().a(CarlifeActivity.o(CarlifeActivity.this));
        com.baidu.carlife.push.a.a().a(CarlifeActivity.d(CarlifeActivity.this));
        com.baidu.carlife.l.a.a().W();
        com.baidu.che.codriver.util.c.a(com.baidu.carlife.core.f.jx.a());
        return;
        com.baidu.carlife.connect.a.b();
        return;
        paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
        int i;
        try
        {
          paramMessage = CarlifeProtocolVersionProto.CarlifeProtocolVersion.parseFrom(paramMessage.f());
          com.baidu.carlife.logic.d.a().a(paramMessage);
          com.baidu.carlife.logic.d.a().f();
          com.baidu.carlife.logic.d.a().h();
          i = com.baidu.carlife.logic.d.a().g().getMatchStatus();
          com.baidu.carlife.core.i.e(CarlifeActivity.c, "Protocol Version Match Version: " + i);
          if (i == 1)
          {
            com.baidu.carlife.util.t.a(CarlifeActivity.this, CarlifeActivity.j(CarlifeActivity.this));
            com.baidu.carlife.l.a.a().e(true);
            com.baidu.carlife.logic.c.a().e();
            postDelayed(new Runnable()
            {
              public void run()
              {
                com.baidu.carlife.logic.k.a().b();
              }
            }, 500L);
            if (com.baidu.carlife.logic.music.h.b().p()) {
              com.baidu.carlife.core.k.b(407);
            }
            com.baidu.carlife.m.a.a().a(true);
            com.baidu.carlife.core.screen.a.a.b().e(true);
            com.baidu.carlife.core.screen.a.a.b().a(4201, true, 10000);
            CarlifeActivity.p(CarlifeActivity.this);
            n.a().r();
            com.baidu.carlife.custom.elhyf.b.b();
            return;
          }
        }
        catch (InvalidProtocolBufferException paramMessage)
        {
          com.baidu.carlife.core.i.e(CarlifeActivity.c, "Get Car Protocol Version Info Error");
          paramMessage.printStackTrace();
          return;
        }
        com.baidu.carlife.l.a.a().e(false);
        com.baidu.carlife.core.l.a().postDelayed(new Runnable()
        {
          public void run()
          {
            com.baidu.carlife.l.a.a().O();
          }
        }, 500L);
        return;
        com.baidu.carlife.util.t.a();
        Object localObject1 = (com.baidu.carlife.core.connect.c)paramMessage.obj;
        paramMessage = null;
        try
        {
          localObject1 = CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.parseFrom(((com.baidu.carlife.core.connect.c)localObject1).f());
          paramMessage = (Message)localObject1;
          com.baidu.carlife.core.i.b(CarlifeActivity.c, "Vehicle CUID = " + ((CarlifeStatisticsInfoProto.CarlifeStatisticsInfo)localObject1).getCuid());
          paramMessage = (Message)localObject1;
          com.baidu.carlife.core.i.b(CarlifeActivity.c, "Vehicle versionName = " + ((CarlifeStatisticsInfoProto.CarlifeStatisticsInfo)localObject1).getVersionName());
          paramMessage = (Message)localObject1;
          com.baidu.carlife.core.i.b(CarlifeActivity.c, "Vehicle versionCode = " + ((CarlifeStatisticsInfoProto.CarlifeStatisticsInfo)localObject1).getVersionCode());
          paramMessage = (Message)localObject1;
          com.baidu.carlife.core.i.b(CarlifeActivity.c, "Vehicle Channel = " + ((CarlifeStatisticsInfoProto.CarlifeStatisticsInfo)localObject1).getChannel());
          paramMessage = (Message)localObject1;
          com.baidu.carlife.core.i.b(CarlifeActivity.c, "Vehicle Connect Count = " + ((CarlifeStatisticsInfoProto.CarlifeStatisticsInfo)localObject1).getConnectCount());
          paramMessage = (Message)localObject1;
          com.baidu.carlife.core.i.b(CarlifeActivity.c, "Vehicle Connect Success Count = " + ((CarlifeStatisticsInfoProto.CarlifeStatisticsInfo)localObject1).getConnectSuccessCount());
          paramMessage = (Message)localObject1;
          com.baidu.carlife.core.i.b(CarlifeActivity.c, "Vehicle Connect Time = " + ((CarlifeStatisticsInfoProto.CarlifeStatisticsInfo)localObject1).getConnectTime());
          paramMessage = (Message)localObject1;
          com.baidu.carlife.core.i.b(CarlifeActivity.c, "Vehicle Crash Log = " + ((CarlifeStatisticsInfoProto.CarlifeStatisticsInfo)localObject1).getCrashLog());
          paramMessage = (Message)localObject1;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            boolean bool2;
            localException1.printStackTrace();
            continue;
            bool1 = false;
          }
        }
        bool1 = x.a(CarlifeActivity.this, paramMessage.getChannel(), CarlifeActivity.j(CarlifeActivity.this));
        com.baidu.carlife.core.e.b(paramMessage.getChannel());
        com.baidu.carlife.core.e.c(paramMessage.getCuid());
        com.baidu.carlife.core.e.d(paramMessage.getVersionName());
        TrackCarDataSolveModel.setCarlifeStatisticsInfo(paramMessage);
        p.a().b("carlifevehicle_channel", paramMessage.getChannel());
        com.baidu.carlife.connect.a.a();
        bool2 = q.a(CarlifeActivity.d(CarlifeActivity.this), CarlifeActivity.j(CarlifeActivity.this));
        localObject1 = com.baidu.carlife.a.a.a();
        if ((bool1) && (bool2))
        {
          bool1 = true;
          ((com.baidu.carlife.a.a)localObject1).a(bool1);
          CarlifeActivity.q(CarlifeActivity.this);
          s.a(paramMessage);
          com.baidu.carlife.util.t.a(paramMessage);
          sendEmptyMessage(4007);
          com.baidu.carlife.bluetooth.a.a().d();
          com.baidu.carlife.logic.g.a().b();
          com.baidu.che.codriver.util.c.a(com.baidu.carlife.core.f.jx.a());
          com.baidu.carlife.b.a.a().b();
          return;
        }
        try
        {
          paramMessage = CarlifeDeviceInfoProto.CarlifeDeviceInfo.parseFrom(((com.baidu.carlife.core.connect.c)paramMessage.obj).f());
          com.baidu.carlife.logic.c.a().a(paramMessage);
          com.baidu.carlife.core.i.b(CarlifeActivity.c, paramMessage.toString());
          if (!paramMessage.getDevice().equals("iRTOS")) {
            break label4553;
          }
          com.baidu.carlife.l.a.a().a(true);
          return;
        }
        catch (Exception paramMessage)
        {
          com.baidu.carlife.core.i.e(CarlifeActivity.c, "get hu info error");
          paramMessage.printStackTrace();
          return;
        }
        if (bool1)
        {
          com.baidu.carlife.core.k.a(4001, 43992, 0, null);
          return;
        }
        com.baidu.carlife.core.k.a(98333, 0, 0, null, 200);
        return;
        if (com.baidu.carlife.core.c.a().e())
        {
          com.baidu.carlife.core.k.a(4002, 0, 0, null);
          return;
        }
        com.baidu.carlife.core.k.a(98334, 0, 0, null, 200);
        return;
        if (com.baidu.carlife.core.c.a().e())
        {
          com.baidu.carlife.core.k.a(4003, 0, 0, null);
          return;
        }
        com.baidu.carlife.core.k.a(98335, 0, 0, null, 200);
        return;
        if (com.baidu.carlife.core.c.a().e())
        {
          com.baidu.carlife.core.i.b(CarlifeActivity.c, "MSG_CMD_LAUNCH_MODE_MUSIC 1");
          com.baidu.carlife.core.k.a(4004, 0, 0, null);
          return;
        }
        com.baidu.carlife.core.i.b(CarlifeActivity.c, "MSG_CMD_LAUNCH_MODE_MUSIC 2");
        com.baidu.carlife.core.k.a(98336, 0, 0, null, 200);
        return;
        if (bool1)
        {
          com.baidu.carlife.core.i.b(CarlifeActivity.c, "MSG_MAIN_CHANGE_CONNECT_BUTTON 1");
          com.baidu.carlife.core.k.a(3008, 0, 0, null);
          return;
        }
        com.baidu.carlife.core.i.b(CarlifeActivity.c, "MSG_MAIN_CHANGE_CONNECT_BUTTON 2");
        com.baidu.carlife.core.k.a(4010, 0, 0, null, 200);
        return;
        if (bool1)
        {
          com.baidu.carlife.core.k.b(3007);
          return;
        }
        sendEmptyMessageDelayed(4007, 200L);
        return;
        CarlifeActivity.this.l();
        return;
        paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
        if (paramMessage != null)
        {
          int j;
          try
          {
            paramMessage = CarlifeModuleStatusProto.CarlifeModuleStatus.parseFrom(paramMessage.f());
            if (paramMessage == null) {
              break label4553;
            }
            i = paramMessage.getModuleID();
            j = paramMessage.getStatusID();
            com.baidu.carlife.core.i.c(CarlifeActivity.c, "moduleId=" + i + ",statusId=" + j);
            switch (i)
            {
            case 1: 
              if (j == 0) {
                break label2623;
              }
              com.baidu.carlife.core.k.a(2026, 0, 0, null);
              return;
            }
          }
          catch (InvalidProtocolBufferException paramMessage)
          {
            paramMessage.printStackTrace();
            return;
          }
          if (j == 1)
          {
            com.baidu.carlife.logic.music.h.b().C();
            return;
          }
          if (j == 0)
          {
            com.baidu.carlife.core.i.b("CarLifeMusic", "-----MSG_CMD_MODULE_CONTROL---pause(true)---");
            com.baidu.carlife.logic.music.h.b().D();
            return;
            if (j == 1)
            {
              n.a().f();
              return;
            }
            if (j == 0)
            {
              n.a().j();
              return;
            }
            if (j == 2)
            {
              com.baidu.carlife.logic.k.a().a(6, 2);
              return;
              if (j == 0)
              {
                if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
                  BaiduNaviSDKManager.getInstance().quitNavi();
                }
                paramMessage = com.baidu.carlife.logic.d.a().d();
                if ((paramMessage != null) && (paramMessage.getMajorVersion() == 1))
                {
                  if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
                    BaiduNaviSDKManager.getInstance().quitCruise();
                  }
                  if (BCruiser.getInstance().isCruiseBegin())
                  {
                    EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
                    return;
                    if ((j == 0) && (BaiduNaviSDKManager.getInstance().isCruiseBegin()))
                    {
                      BaiduNaviSDKManager.getInstance().quitCruise();
                      return;
                      if ((j == 0) && (BCruiser.getInstance().isCruiseBegin()))
                      {
                        EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
                        return;
                        label2623:
                        com.baidu.carlife.core.k.a(2027, 0, 0, null);
                        return;
                        com.baidu.carlife.logic.k.a().a(6, j);
                        n.a().r();
                        return;
                        Object localObject2 = (String)paramMessage.obj;
                        if (!TextUtils.isEmpty((CharSequence)localObject2))
                        {
                          localObject2 = com.baidu.carlife.logic.music.h.b().b((String)localObject2);
                          if (localObject2 == null)
                          {
                            CarlifeActivity.a(CarlifeActivity.this, CarlifeActivity.this.getResources().getString(2131296629));
                            return;
                          }
                          if (p.a().a("show_guide_for_home_5_0_0", true))
                          {
                            com.baidu.carlife.core.i.b("ouyang", "-MSG_MAIN_THIRDPARTY_CONNECT--UserGuiding--");
                            sendMessageDelayed(Message.obtain(paramMessage), 500L);
                            return;
                          }
                          if ((localObject2 != null) && (bool1))
                          {
                            com.baidu.carlife.logic.music.h.b().l(((com.baidu.carlife.logic.music.b)localObject2).s());
                            paramMessage = CarlifeActivity.a(CarlifeActivity.this).getCurrentFragment();
                            if (paramMessage != null)
                            {
                              if (CarlifeActivity.r(CarlifeActivity.this) == 745) {
                                paramMessage.onStart();
                              }
                              for (;;)
                              {
                                paramMessage = ((com.baidu.carlife.logic.music.b)localObject2).r();
                                if ((paramMessage == null) || (paramMessage.isEmpty())) {
                                  ((com.baidu.carlife.logic.music.b)localObject2).j();
                                }
                                CarlifeActivity.a(CarlifeActivity.this, 0);
                                com.baidu.carlife.core.i.b("ouyang", "-MSG_MAIN_THIRDPARTY_CONNECT--OK--");
                                return;
                                CarlifeActivity.a(CarlifeActivity.this).showFragment(745, null);
                              }
                            }
                          }
                          else
                          {
                            if (CarlifeActivity.s(CarlifeActivity.this) < 10)
                            {
                              com.baidu.carlife.core.i.b("ouyang", "-MSG_MAIN_THIRDPARTY_CONNECT--NetWork_Unreturn--");
                              CarlifeActivity.a(CarlifeActivity.this, CarlifeActivity.this.getResources().getString(2131296628));
                              sendMessageDelayed(Message.obtain(paramMessage), 500L);
                              CarlifeActivity.t(CarlifeActivity.this);
                              return;
                            }
                            com.baidu.carlife.core.i.b("ouyang", "-MSG_MAIN_THIRDPARTY_CONNECT--NetWork_FailReturn--");
                            CarlifeActivity.a(CarlifeActivity.this, 0);
                            CarlifeActivity.a(CarlifeActivity.this, CarlifeActivity.this.getResources().getString(2131296627));
                            return;
                            if (paramMessage.obj != null)
                            {
                              CarlifeActivity.a(CarlifeActivity.this, paramMessage.obj.toString());
                              return;
                              com.baidu.carlife.logic.music.h.b().G();
                              return;
                              CarlifeActivity.a(CarlifeActivity.this, CarlifeActivity.this.getString(2131296301));
                              return;
                              CarlifeActivity.a(CarlifeActivity.this, paramMessage);
                              return;
                              CarlifeActivity.b(CarlifeActivity.this, paramMessage);
                              return;
                              paramMessage = (ArrayList)paramMessage.obj;
                              localObject2 = new Bundle();
                              ((Bundle)localObject2).putInt("module_from", 1);
                              ((Bundle)localObject2).putSerializable("poi_data", paramMessage);
                              CarlifeActivity.j(CarlifeActivity.this).openNaviFromOutSide(35, (Bundle)localObject2);
                              return;
                              if (com.baidu.carlife.l.a.a().N())
                              {
                                com.baidu.carlife.core.c.a().e(true);
                                CarlifeActivity.j(CarlifeActivity.this).b();
                                if (CarlifeActivity.u(CarlifeActivity.this))
                                {
                                  com.baidu.carlife.core.c.a().f(true);
                                  return;
                                  paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
                                  try
                                  {
                                    if ((CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.parseFrom(paramMessage.f()).getState() == 2) || (com.baidu.carlife.core.f.jx != f.a.t) || (CarlifeActivity.v(CarlifeActivity.this))) {
                                      break label4553;
                                    }
                                    CarlifeActivity.d(CarlifeActivity.this, true);
                                    CarlifeActivity.a(CarlifeActivity.this, CarlifeActivity.this.getString(2131297170));
                                    return;
                                  }
                                  catch (InvalidProtocolBufferException paramMessage)
                                  {
                                    paramMessage.printStackTrace();
                                    return;
                                  }
                                  i = paramMessage.arg1;
                                  j = paramMessage.arg2;
                                  if (i != j)
                                  {
                                    if (j == 0)
                                    {
                                      com.baidu.carlife.core.c.a().h(false);
                                      return;
                                    }
                                    if ((j == 2) && (CarlifeActivity.j(CarlifeActivity.this).isDialogShown()))
                                    {
                                      CarlifeActivity.j(CarlifeActivity.this).dismissDialog();
                                      return;
                                      if (!com.baidu.carlife.bluetooth.b.a().z)
                                      {
                                        CarlifeActivity.j(CarlifeActivity.this).a(false);
                                        if (!CarlifeActivity.u(CarlifeActivity.this)) {
                                          com.baidu.carlife.core.screen.a.a.b().l();
                                        }
                                        com.baidu.carlife.core.screen.a.a.b().j();
                                        return;
                                        paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
                                        if (paramMessage != null)
                                        {
                                          try
                                          {
                                            paramMessage = CarlifeTouchActionProto.CarlifeTouchAction.parseFrom(paramMessage.f());
                                            if ((com.baidu.carlife.l.a.a().o() <= 0) || (com.baidu.carlife.l.a.a().p() <= 0)) {
                                              break label4553;
                                            }
                                            i = paramMessage.getX() * com.baidu.carlife.l.a.a().q() / com.baidu.carlife.l.a.a().o();
                                            j = paramMessage.getY() * com.baidu.carlife.l.a.a().r() / com.baidu.carlife.l.a.a().p();
                                            localObject2 = "x = " + i + ", y = " + j + ", action = " + paramMessage.getAction();
                                            com.baidu.carlife.core.i.b(CarlifeActivity.c, "MSG_CMD_TOUCH_ACTION: " + (String)localObject2);
                                            l1 = SystemClock.uptimeMillis();
                                            paramMessage = MotionEvent.obtain(l1, l1, paramMessage.getAction(), i, j, 0);
                                            CarlifeActivity.this.dispatchTouchEvent(paramMessage);
                                            return;
                                          }
                                          catch (InvalidProtocolBufferException paramMessage)
                                          {
                                            com.baidu.carlife.core.i.e(CarlifeActivity.c, "MSG_CMD_TOUCH_ACTION Error");
                                            paramMessage.printStackTrace();
                                            return;
                                          }
                                        }
                                        else
                                        {
                                          com.baidu.carlife.core.i.e(CarlifeActivity.c, "MSG_CMD_TOUCH_ACTION CarlifeCmdMessage is null");
                                          return;
                                          com.baidu.carlife.core.i.a(CarlifeActivity.c, "MSG_CMD_ERROR_CODE");
                                          paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
                                          try
                                          {
                                            paramMessage = CarlifeErrorCodeProto.CarlifeErrorCode.parseFrom(paramMessage.f());
                                            com.baidu.carlife.core.i.a(CarlifeActivity.c, "error Code = " + paramMessage.getErrorCode());
                                            s.a(paramMessage.getErrorCode(), CarlifeActivity.w(CarlifeActivity.this));
                                            CarlifeActivity.e(CarlifeActivity.this, true);
                                            return;
                                          }
                                          catch (Exception paramMessage)
                                          {
                                            paramMessage.printStackTrace();
                                            return;
                                          }
                                          paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
                                          try
                                          {
                                            paramMessage = CarlifeAuthenRequestProto.CarlifeAuthenRequest.parseFrom(paramMessage.f());
                                            com.baidu.carlife.core.i.b(CarlifeActivity.c, "MSG_CMD_HU_AUTHEN_REQUEST= " + paramMessage.getRandomValue());
                                            com.baidu.carlife.a.a.a().a(paramMessage.getRandomValue());
                                            return;
                                          }
                                          catch (Exception paramMessage)
                                          {
                                            paramMessage.printStackTrace();
                                            return;
                                          }
                                          paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
                                          try
                                          {
                                            if (CarlifeAuthenResultProto.CarlifeAuthenResult.parseFrom(paramMessage.f()).getAuthenResult())
                                            {
                                              com.baidu.carlife.core.i.e(CarlifeActivity.c, "MSG_CMD_HU_AUTHEN_RESULT= true");
                                              return;
                                            }
                                          }
                                          catch (Exception paramMessage)
                                          {
                                            paramMessage.printStackTrace();
                                            return;
                                          }
                                          com.baidu.carlife.core.i.e(CarlifeActivity.c, "MSG_CMD_HU_AUTHEN_RESULT= false");
                                          return;
                                          com.baidu.carlife.core.i.a().d();
                                          return;
                                          if (com.baidu.carlife.logic.g.a().c())
                                          {
                                            CarlifeActivity.c(CarlifeActivity.this, true);
                                            CarlifeActivity.m(CarlifeActivity.this);
                                            CarlifeActivity.o(CarlifeActivity.this).postDelayed(new Runnable()
                                            {
                                              public void run()
                                              {
                                                com.baidu.carlife.f.d.a().j();
                                              }
                                            }, 500L);
                                            return;
                                            if (com.baidu.carlife.l.a.a().N())
                                            {
                                              com.baidu.carlife.core.screen.a.a.b().j();
                                              CarlifeActivity.x(CarlifeActivity.this);
                                              return;
                                              if (CarlifeActivity.y(CarlifeActivity.this) != null)
                                              {
                                                CarlifeActivity.j(CarlifeActivity.this).dismissDialog(CarlifeActivity.y(CarlifeActivity.this));
                                                return;
                                                if (CarlifeActivity.k(CarlifeActivity.this) != null) {
                                                  CarlifeActivity.k(CarlifeActivity.this).a();
                                                }
                                                if (com.baidu.carlife.core.d.m())
                                                {
                                                  com.baidu.carlife.core.i.b(CarlifeActivity.c, "before adaptScreen: [" + ScreenUtil.getInstance().getWidthPixels() + ":" + ScreenUtil.getInstance().getHeightPixels());
                                                  i = ScreenUtil.getInstance().getWidthPixels();
                                                  j = (int)(i * com.baidu.carlife.core.d.a().b().a());
                                                  CarlifeActivity.a(CarlifeActivity.this, i, j);
                                                  CarlifeActivity.g(CarlifeActivity.this);
                                                  return;
                                                  paramMessage = CarlifeVehicleInfoListProto.CarlifeVehicleInfoList.parseFrom(((com.baidu.carlife.core.connect.c)paramMessage.obj).f());
                                                  com.baidu.carlife.b.a.a().a(paramMessage);
                                                  return;
                                                  localObject2 = (com.baidu.carlife.core.connect.c)paramMessage.obj;
                                                  paramMessage = null;
                                                  com.baidu.carlife.core.i.b(CarlifeActivity.c, "---------   wince connect statistic ---------");
                                                  try
                                                  {
                                                    localObject2 = CarlifeConStatisticProto.CarlifeConnectStatistics.parseFrom(((com.baidu.carlife.core.connect.c)localObject2).f());
                                                    paramMessage = (Message)localObject2;
                                                    com.baidu.carlife.core.i.b(CarlifeActivity.c, "Connect Total = " + ((CarlifeConStatisticProto.CarlifeConnectStatistics)localObject2).getContotal());
                                                    paramMessage = (Message)localObject2;
                                                    com.baidu.carlife.core.i.b(CarlifeActivity.c, "Connect Success = " + ((CarlifeConStatisticProto.CarlifeConnectStatistics)localObject2).getConsuccess());
                                                    paramMessage = (Message)localObject2;
                                                    com.baidu.carlife.core.i.b(CarlifeActivity.c, "Connect Failed = " + ((CarlifeConStatisticProto.CarlifeConnectStatistics)localObject2).getConfailed());
                                                    paramMessage = (Message)localObject2;
                                                    com.baidu.carlife.core.i.b(CarlifeActivity.c, "Connect Time = " + ((CarlifeConStatisticProto.CarlifeConnectStatistics)localObject2).getContime());
                                                    paramMessage = (Message)localObject2;
                                                    com.baidu.carlife.core.i.b(CarlifeActivity.c, "Connect errorcount = " + ((CarlifeConStatisticProto.CarlifeConnectStatistics)localObject2).getNerrorcount());
                                                    paramMessage = (Message)localObject2;
                                                    com.baidu.carlife.core.i.b(CarlifeActivity.c, "Connect ErrorTypeCount = " + ((CarlifeConStatisticProto.CarlifeConnectStatistics)localObject2).getErrorTypeCount());
                                                    paramMessage = (Message)localObject2;
                                                  }
                                                  catch (Exception localException2)
                                                  {
                                                    for (;;)
                                                    {
                                                      localException2.printStackTrace();
                                                    }
                                                    StatisticManager.onEvent("CONNECT_0002");
                                                    if (paramMessage.getConfailed() > 100) {
                                                      break label4232;
                                                    }
                                                    i = 0;
                                                    while (i < paramMessage.getConfailed())
                                                    {
                                                      StatisticManager.onEvent("CONNECT_0003");
                                                      i += 1;
                                                    }
                                                    StatisticManager.onEventDuration(com.baidu.carlife.core.a.a(), "CONNECT_0004", "CONNECT_0004", paramMessage.getContime());
                                                    if (paramMessage.getNerrorcount() > 100) {
                                                      break label4553;
                                                    }
                                                  }
                                                  if (paramMessage.getContotal() <= 100) {
                                                    i = 0;
                                                  }
                                                  for (;;)
                                                  {
                                                    if (i < paramMessage.getContotal())
                                                    {
                                                      StatisticManager.onEvent("CONNECT_0001");
                                                      i += 1;
                                                    }
                                                    else
                                                    {
                                                      label4232:
                                                      i = 0;
                                                      while ((i < paramMessage.getNerrorcount()) && (i < paramMessage.getErrorTypeCount()))
                                                      {
                                                        StatisticManager.onEvent("CONNECT_0005", paramMessage.getErrorType(i));
                                                        i += 1;
                                                        continue;
                                                        StatisticManager.onEvent("CONNECT_0006");
                                                        com.baidu.carlife.core.i.b(CarlifeActivity.c, "---------   MSG_PORT_ESTABLISH ---------");
                                                        return;
                                                        com.baidu.carlife.core.i.b(CarlifeActivity.c, "---------MSG_CMD_CAR_DATA_GEAR---------");
                                                        if (com.baidu.carlife.custom.a.a().b())
                                                        {
                                                          com.baidu.carlife.core.i.b(CarlifeActivity.c, "---------VEHICLE_CHANNEL_GUANGFENG_LEVIN---------");
                                                          com.baidu.carlife.custom.a.a().a(paramMessage);
                                                          return;
                                                        }
                                                        if (com.baidu.carlife.custom.b.a().b())
                                                        {
                                                          com.baidu.carlife.core.i.b(CarlifeActivity.c, "---------VEHICLE_CHANNEL_YIQIFENGTIAN_COROLLA---------");
                                                          com.baidu.carlife.custom.b.a().a(paramMessage);
                                                          return;
                                                          paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
                                                          try
                                                          {
                                                            paramMessage = CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo.parseFrom(paramMessage.f());
                                                            com.baidu.carlife.custom.elhyf.b.a().a(paramMessage.getDeviceName().trim(), paramMessage.getVersionCode().trim());
                                                            return;
                                                          }
                                                          catch (Exception paramMessage)
                                                          {
                                                            paramMessage.printStackTrace();
                                                            return;
                                                          }
                                                          if (paramMessage.obj != null)
                                                          {
                                                            com.baidu.carlife.b.a.a(paramMessage.obj);
                                                            return;
                                                            if (paramMessage.obj != null)
                                                            {
                                                              com.baidu.carlife.b.a.a(paramMessage.obj, true);
                                                              return;
                                                              if (paramMessage.obj != null)
                                                              {
                                                                com.baidu.carlife.b.a.a(paramMessage.obj, false);
                                                                return;
                                                                CarlifeActivity.this.t();
                                                                return;
                                                                CarlifeActivity.z(CarlifeActivity.this);
                                                                CarlifeActivity.A(CarlifeActivity.this);
                                                                return;
                                                                CarlifeActivity.j(CarlifeActivity.this).a(2130838204);
                                                                return;
                                                                CarlifeActivity.j(CarlifeActivity.this).a((Drawable)paramMessage.obj);
                                                                return;
                                                                paramMessage = (String)paramMessage.obj;
                                                                com.baidu.carlife.core.i.b(CarlifeActivity.c, "-------MSG_PUSH_MESSSAGE_SHOW: " + paramMessage);
                                                                com.baidu.carlife.connect.a.c();
                                                                return;
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label4553:
      return;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean a(int paramInt, KeyEvent paramKeyEvent);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/CarlifeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */