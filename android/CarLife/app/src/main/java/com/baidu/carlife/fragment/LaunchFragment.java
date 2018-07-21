package com.baidu.carlife.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.KeyboardService;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.BaseDialog;
import com.baidu.carlife.logic.o;
import com.baidu.carlife.logic.t;
import com.baidu.carlife.logic.t.b;
import com.baidu.carlife.logic.voice.n;
import com.baidu.carlife.service.PhoneStateService;
import com.baidu.carlife.util.p;
import com.baidu.carlife.util.w;
import com.baidu.carlife.view.dialog.q.a;
import com.baidu.carlife.view.g;
import com.baidu.navi.ActivityStack;
import com.baidu.navi.common.util.StorageInformation;
import com.baidu.navi.common.util.StorageSettings;
import com.baidu.navi.controller.HomeController;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navi.track.datashop.TrackDataShop;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.voice.NaviState;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.AudioUtils;
import com.baidu.navisdk.util.common.FileUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.SDCardUtils;
import com.baidu.navisdk.util.db.DBManager;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class LaunchFragment
  extends ContentFragment
{
  public static String a = LaunchFragment.class.getSimpleName();
  protected static final int b = 9002;
  private static final int c = 2;
  private static final int d = 9007;
  private static final int e = 9005;
  private static final int f = 9004;
  private static final int g = 9003;
  private static final int h = 9001;
  private com.baidu.carlife.view.dialog.e i;
  private String j = null;
  private int[] k = new int[36];
  private int[] l = new int[1];
  private Handler m = null;
  private ViewGroup n = null;
  private boolean o;
  private volatile int p = 0;
  private t.b q = new b(null);
  
  private String a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong < 0L) {
      l1 = 0L;
    }
    if (l1 < 1048576L) {
      return String.format(Locale.getDefault(), "%.1fK", new Object[] { Double.valueOf(l1 / 1024.0D) });
    }
    if (l1 < 1073741824L) {
      return String.format(Locale.getDefault(), "%.1fM", new Object[] { Double.valueOf(l1 / 1024.0D / 1024.0D) });
    }
    return String.format(Locale.getDefault(), "%.1fG", new Object[] { Double.valueOf(l1 / 1024.0D / 1024.0D / 1024.0D) });
  }
  
  private void a()
  {
    if (this.p >= 2)
    {
      this.m.sendEmptyMessage(9004);
      this.p = 0;
    }
  }
  
  private void a(final String paramString)
  {
    if (p.a().a("needDeleteOldMapData", true))
    {
      new Thread(new Runnable()
      {
        public void run()
        {
          try
          {
            File localFile = new File(paramString + File.separator + com.baidu.carlife.core.f.hM + File.separator + "tmp");
            i.b("LaunchFragmet", "file : " + localFile.getAbsolutePath());
            if (localFile.exists()) {
              com.baidu.carlife.util.h.a(localFile);
            }
            p.a().c("needDeleteOldMapData", false);
            LaunchFragment.f(LaunchFragment.this).sendEmptyMessage(9001);
            return;
          }
          catch (Exception localException)
          {
            for (;;) {}
          }
        }
      }).start();
      return;
    }
    com.baidu.carlife.m.b.a();
    NaviAccountUtils.getInstance().initAccount(BaiduNaviApplication.getInstance());
    LocationManager.getInstance().init(BaiduNaviApplication.getInstance());
    LocationManager.getInstance().onResume();
    mActivity.n();
    NavMapAdapter.getInstance().initNaviEngine(mActivity, this.m);
    com.baidu.baidumaps.base.localmap.f.a().b();
    com.baidu.baidumaps.base.localmap.f.a().n();
  }
  
  private void b()
  {
    KeyboardService.getInstance().init(mActivity, mActivity.u());
    i.a(t.a);
    t.a().a(mActivity);
    t.a().a(this.q);
    com.baidu.carlife.logic.q.f().g();
    PhoneStateService.a(mActivity);
    com.baidu.carlife.core.e.w();
    com.baidu.navisdk.util.common.PackageUtil.strChannel = com.baidu.carlife.core.f.jt;
    StatisticManager.setAppChannel(com.baidu.carlife.core.f.jt);
    com.baidu.carlife.core.screen.a.a.b().a();
    com.baidu.carlife.bluetooth.a.a().a(mActivity);
    push(createFragment(531));
    push(createFragment(519));
    push(createFragment(737));
    n.a().a(mActivity);
    com.baidu.carlife.logic.music.h.b().a();
  }
  
  private void c()
  {
    i.a("after initEngine");
    d();
    g.e().a();
    DBManager.init(BaiduNaviApplication.getInstance());
    o.a().c();
    NaviState.getInstance().registerCustomCmd();
    k();
    BNSettingManager.setPowerSaveMode(2);
    BNSettingManager.setPushMode(false);
    BNSettingManager.setUgcShow(false);
    AudioUtils.init();
    GeoLocateModel.getInstance().asyncGetCurrentDistricts();
    mActivity.g();
    com.baidu.carlife.view.c.a().a(mActivity, mActivity.u());
    com.baidu.carlife.logic.a.a().a(mActivity, mActivity.u());
    com.baidu.carlife.logic.a.a().a(true);
    e();
    BNVoiceCommandController.getInstance().init();
    UIModel.syncAddressToCoDriverForAppStart();
    if (l()) {
      g();
    }
    for (;;)
    {
      com.baidu.carlife.core.c.a().d(true);
      f();
      i.b("after initEngine");
      return;
      if (com.baidu.carlife.core.c.a().c()) {
        h();
      } else {
        showFragment(515, null);
      }
    }
  }
  
  private void d()
  {
    FileUtils.copyAssetsFile(com.baidu.carlife.core.a.a().getAssets(), "cfg/a/mode_17/map.rs", SysOSAPIv2.getInstance().getOutputDirPath() + File.separator + "cfg/a/mode_17", "map.rs");
    FileUtils.copyAssetsFile(com.baidu.carlife.core.a.a().getAssets(), "cfg/a/mode_17/map.sty", SysOSAPIv2.getInstance().getOutputDirPath() + File.separator + "cfg/a/mode_17", "map.sty");
  }
  
  private void e()
  {
    new HomeController(mActivity, mActivity.u()).checkNewVerDataAndUpgrade();
  }
  
  private void f()
  {
    if (this.m != null) {
      this.m.postDelayed(new Runnable()
      {
        public void run()
        {
          try
          {
            TrackDataShop.getInstance().clearBeforSixMonthGPSFile(NaviAccountUtils.getInstance().getUid());
            return;
          }
          catch (Exception localException)
          {
            i.b(LaunchFragment.a, "SapiAccountManager have not been initialized");
          }
        }
      }, 3000L);
    }
  }
  
  private void g()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("firstEnter", true);
    showFragment(516, localBundle);
  }
  
  private void h()
  {
    i.a(HomeFragment.a);
    showFragment(531, null);
  }
  
  private void i()
  {
    com.baidu.carlife.view.dialog.c localc = new com.baidu.carlife.view.dialog.c(getContext()).b(2131296284).a(2131296274).c(2131296264).q();
    localc.a(new com.baidu.carlife.core.screen.b()
    {
      public void onClick()
      {
        ActivityStack.exitApp(false);
      }
    });
    showDialog(localc);
  }
  
  private void j()
  {
    final StorageInformation localStorageInformation1 = StorageSettings.getInstance().getCurrentStorage();
    final List localList = StorageSettings.getInstance().getAllStorages();
    final ArrayList localArrayList = new ArrayList();
    if (localList.size() == 0)
    {
      localObject1 = new com.baidu.carlife.view.dialog.c(getContext()).b(2131296284).a(2131296282).c(2131296869).g(17).q();
      ((com.baidu.carlife.view.dialog.c)localObject1).a(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          ActivityStack.exitApp(false);
        }
      });
      showDialog((BaseDialog)localObject1);
      return;
    }
    if (localList.size() < 2)
    {
      this.j = localStorageInformation1.getRootPath();
      if (SDCardUtils.writeTestFileToSdcard(this.j))
      {
        a(this.j);
        return;
      }
      localObject1 = new com.baidu.carlife.view.dialog.c(getContext()).b(2131296284).a(2131296282).c(2131296869).g(17).q();
      ((com.baidu.carlife.view.dialog.c)localObject1).a(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          ActivityStack.exitApp(false);
        }
      });
      showDialog((BaseDialog)localObject1);
      return;
    }
    final Object localObject1 = PreferenceHelper.getInstance(getContext()).getString("SP_COMMON_CHOOSED_SDCARD_PATH", "null");
    if ((!((String)localObject1).equals("null")) && (((String)localObject1).equals(localStorageInformation1.getRootPath())))
    {
      this.j = ((String)localObject1);
      if (SDCardUtils.writeTestFileToSdcard(this.j))
      {
        a(this.j);
        return;
      }
    }
    final Object localObject2 = localList.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      StorageInformation localStorageInformation2 = (StorageInformation)((Iterator)localObject2).next();
      HashMap localHashMap = new HashMap();
      if (localStorageInformation2.getAvailableBytes() == -1L)
      {
        localHashMap.put("volume", localStorageInformation2.getRootPath() + " 剩余空间:未知");
        label329:
        localHashMap.put("label", localStorageInformation2.getLabel());
        if (!localStorageInformation2.equals(localStorageInformation1)) {
          break label456;
        }
        localObject1 = "(当前使用)";
        label356:
        localHashMap.put("current", localObject1);
        if (!SysOSAPIv2.getInstance().checkExistsOfflineData(localStorageInformation2.getRootPath()).booleanValue()) {
          break label463;
        }
      }
      label456:
      label463:
      for (localObject1 = Boolean.TRUE;; localObject1 = Boolean.FALSE)
      {
        localHashMap.put("check", localObject1);
        localArrayList.add(localHashMap);
        break;
        localHashMap.put("volume", localStorageInformation2.getRootPath() + " 剩余空间:" + a(localStorageInformation2.getAvailableBytes()));
        break label329;
        localObject1 = "";
        break label356;
      }
    }
    localObject1 = new com.baidu.carlife.view.dialog.q(getContext(), localArrayList);
    showDialog((BaseDialog)localObject1);
    localObject2 = ((com.baidu.carlife.view.dialog.q)localObject1).getListView();
    ((com.baidu.carlife.view.dialog.q)localObject1).a(new q.a()
    {
      public void a()
      {
        int i = localObject1.getmCheckedPosition();
        if ((i < 0) || (i >= localList.size()))
        {
          TipTool.onCreateToastDialog(LaunchFragment.this.getContext(), 2131296290);
          return;
        }
        StorageInformation localStorageInformation = (StorageInformation)localList.get(i);
        LaunchFragment.b(LaunchFragment.this, localStorageInformation.getRootPath());
        if ((LaunchFragment.g(LaunchFragment.this) != null) && (SDCardUtils.writeTestFileToSdcard(LaunchFragment.g(LaunchFragment.this))))
        {
          if (!localStorageInformation1.getRootPath().equals(localStorageInformation.getRootPath()))
          {
            StorageSettings.getInstance().setPreferredStorage(com.baidu.carlife.core.a.a(), localStorageInformation);
            StorageSettings.getInstance().reInitialize(com.baidu.carlife.core.a.a());
          }
          LaunchFragment.b(LaunchFragment.this, StorageSettings.getInstance().getCurrentStorage().getRootPath());
          PreferenceHelper.getInstance(LaunchFragment.this.getContext()).putString("SP_COMMON_CHOOSED_SDCARD_PATH", LaunchFragment.g(LaunchFragment.this));
          LaunchFragment.a(LaunchFragment.this, LaunchFragment.g(LaunchFragment.this));
          LaunchFragment.this.dismissDialog(localObject1);
          return;
        }
        TipTool.onCreateToastDialog(LaunchFragment.this.getContext(), 2131296289);
      }
    });
    ((ListView)localObject2).setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        int i = 0;
        if (i < localArrayList.size())
        {
          if (i == paramAnonymousInt) {
            ((HashMap)localArrayList.get(i)).put("check", Boolean.TRUE);
          }
          for (;;)
          {
            i += 1;
            break;
            ((HashMap)localArrayList.get(i)).put("check", Boolean.FALSE);
          }
        }
        localObject1.setmCheckedPosition(paramAnonymousInt);
        ((BaseAdapter)localObject2.getAdapter()).notifyDataSetChanged();
      }
    });
  }
  
  private void k()
  {
    BNSettingManager.setDefaultLaunchMode(1);
    int i1 = BNSettingManager.getDefaultLaunchMode();
    if (i1 == 0)
    {
      BNSettingManager.setCurrentUsingMode(1);
      return;
    }
    if (1 == i1)
    {
      BNSettingManager.setCurrentUsingMode(1);
      return;
    }
    BNSettingManager.setCurrentUsingMode(2);
  }
  
  private boolean l()
  {
    return com.baidu.carlife.core.c.a().b();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    b();
    i.a("initEngine");
    j();
  }
  
  public boolean onBackPressed()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    i.a(a + " show");
    this.m = new a(this);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.n = ((ViewGroup)paramLayoutInflater.inflate(2130968773, null));
    return this.n;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    t.a().b(this.q);
    if (Build.VERSION.SDK_INT > 16)
    {
      if ((mActivity != null) && (!mActivity.isDestroyed()))
      {
        removeAllFragmentByType(514);
        mActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      }
      return;
    }
    removeAllFragmentByType(514);
    mActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
  }
  
  public void onDetach()
  {
    i.b(a + " show");
    super.onDetach();
  }
  
  protected void onInitView() {}
  
  public void onResume()
  {
    super.onResume();
    i.b(a);
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  private static class a
    extends Handler
  {
    private final WeakReference<LaunchFragment> a;
    
    public a(LaunchFragment paramLaunchFragment)
    {
      this.a = new WeakReference(paramLaunchFragment);
    }
    
    public void handleMessage(Message paramMessage)
    {
      LaunchFragment localLaunchFragment = (LaunchFragment)this.a.get();
      if (localLaunchFragment == null) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1301: 
        if (paramMessage.arg1 == 0)
        {
          LaunchFragment.a(localLaunchFragment);
          i.b("initEngine");
          LaunchFragment.b(localLaunchFragment);
          return;
        }
      case 9007: 
        LaunchFragment.c(localLaunchFragment);
        return;
      case 9005: 
        w.a("请等待导航初始化成功", 0);
        return;
      case 9002: 
        com.baidu.carlife.core.c.a().c(false);
        LaunchFragment.d(localLaunchFragment);
        return;
      case 9004: 
        com.baidu.carlife.core.c.a().c(true);
        LaunchFragment.e(localLaunchFragment);
        return;
        paramMessage = LaunchFragment.f(localLaunchFragment).obtainMessage(9002);
        LaunchFragment.f(localLaunchFragment).sendMessage(paramMessage);
        return;
      }
      LaunchFragment.a(localLaunchFragment, LaunchFragment.g(localLaunchFragment));
    }
  }
  
  private class b
    implements t.b
  {
    private b() {}
    
    public void b(boolean paramBoolean)
    {
      LaunchFragment.a(LaunchFragment.this);
      LaunchFragment.b(LaunchFragment.this);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/LaunchFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */