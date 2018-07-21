package com.baidu.baidumaps.base.localmap;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.carlife.core.screen.BaseDialog;
import com.baidu.carlife.core.screen.presentation.a.g;
import com.baidu.mapframework.common.config.GlobalConfig;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.mapframework.common.util.StorageSettings;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentManager;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentTask;
import com.baidu.mapframework.nirvana.concurrent.QueueToken;
import com.baidu.mapframework.nirvana.concurrent.ScheduleTask;
import com.baidu.mapframework.nirvana.looper.MainLooperHandler;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.mapframework.widget.MToast;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.listener.NetworkListener;
import com.baidu.platform.comapi.e.a;
import com.baidu.platform.comapi.map.LocalMapListener;
import com.baidu.platform.comapi.map.LocalMapManager;
import com.baidu.platform.comapi.map.LocalMapResource;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.util.BMEventBus;
import com.baidu.platform.comapi.util.BMEventBus.OnEvent;
import com.baidu.platform.comapi.util.NetworkUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.Set;

public final class f
  extends Observable
  implements LocalMapListener, BMEventBus.OnEvent
{
  public static final String a = "local_map_sd_card";
  public static final String b = "local_map_download_error";
  public static final String c = "local_map_storage_changed";
  public static final String d = "local_map_storage_info";
  public static final String e = "local_map_copy_fail";
  public static final String f = "local_map_download_auto";
  public static final String g = "local_map_download_user";
  public static final String h = "local_map_download_user_with_dialog";
  public static boolean i = true;
  private static final String l = f.class.getCanonicalName();
  private static final long m = 1000L;
  private static final long n = 15728640L;
  private static volatile f o;
  private boolean A = false;
  private List<LocalMapResource> B = new ArrayList();
  private List<LocalMapResource> C = new ArrayList();
  private final List<LocalMapResource> D = new ArrayList();
  private final Comparator<LocalMapResource> E = new Comparator()
  {
    public int a(LocalMapResource paramAnonymousLocalMapResource1, LocalMapResource paramAnonymousLocalMapResource2)
    {
      return paramAnonymousLocalMapResource1.pinyin.compareTo(paramAnonymousLocalMapResource2.pinyin);
    }
  };
  private MsgHandler F = new MsgHandler(Looper.getMainLooper())
  {
    public void careAbout() {}
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      LogUtil.e("Handler", " in case NetworkListener.MSG_TYPE_NET_WORK_CHANGE");
      int i = paramAnonymousMessage.arg1;
      if ((paramAnonymousMessage.arg2 != 0) && (i == 0)) {}
      f.a(f.this);
    }
  };
  private MainLooperHandler G = new MainLooperHandler(Module.LOCAL_MAP_MODULE, ScheduleConfig.forData())
  {
    public void onMessage(Message paramAnonymousMessage)
    {
      f.g(f.this);
      f.this.notifyObservers();
    }
  };
  private QueueToken H = ConcurrentManager.obtainTaskQueue(Module.LOCAL_MAP_MODULE);
  public boolean j = false;
  public boolean k = false;
  private boolean p = false;
  private boolean q = true;
  private LocalMapManager r;
  private long s = System.currentTimeMillis() - 1000L;
  private int t = 0;
  private int u = 0;
  private boolean v = false;
  private boolean w = false;
  private com.baidu.carlife.view.dialog.c x;
  private boolean y = false;
  private boolean z = false;
  
  public static f a()
  {
    if (o == null) {}
    try
    {
      if (o == null) {
        o = new f();
      }
      return o;
    }
    finally {}
  }
  
  private void a(final boolean paramBoolean1, final boolean paramBoolean2, final boolean paramBoolean3, final int paramInt)
  {
    ConcurrentTask local2 = new ConcurrentTask()
    {
      public void run()
      {
        Object localObject1;
        int k;
        int i;
        int m;
        if ((paramBoolean1) && (f.h(f.this) != null))
        {
          Object localObject3 = f.h(f.this).getUserResources();
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          Object localObject2 = null;
          localObject1 = null;
          k = 0;
          i = 0;
          m = 0;
          int j = 0;
          if (localObject3 != null)
          {
            localObject3 = ((List)localObject3).iterator();
            for (;;)
            {
              k = i;
              localObject2 = localObject1;
              m = j;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              localObject2 = (LocalMapResource)((Iterator)localObject3).next();
              if (((((LocalMapResource)localObject2).downloadStatus == 9) || (((LocalMapResource)localObject2).updateStatus == 4)) && (f.b(f.this)))
              {
                if (!GlobalConfig.getInstance().isAutoDownload()) {
                  break label183;
                }
                BMEventBus.getInstance().post(new h());
              }
              for (;;)
              {
                if (!d.a((LocalMapResource)localObject2)) {
                  break label205;
                }
                localArrayList1.add(localObject2);
                i += 1;
                break;
                label183:
                BMEventBus.getInstance().post(new e(true, ((LocalMapResource)localObject2).formatVersion));
              }
              label205:
              if (d.b((LocalMapResource)localObject2))
              {
                localArrayList1.add(localObject2);
                k = i;
                if (((LocalMapResource)localObject2).downloadStatus == 1) {
                  k = i + 1;
                }
                localObject1 = localObject2;
                i = k;
              }
              else if (d.c((LocalMapResource)localObject2))
              {
                localArrayList1.add(localObject2);
                j += 1;
              }
              else if (d.d((LocalMapResource)localObject2))
              {
                localArrayList2.add(localObject2);
              }
            }
          }
          f.a(f.this, System.currentTimeMillis());
          f.a(f.this, localArrayList1);
          f.b(f.this, localArrayList2);
          f.i(f.this).obtainMessage().sendToTarget();
          if (k <= 0) {
            break label451;
          }
          if (localObject2 == null) {
            break label439;
          }
          localObject1 = ((LocalMapResource)localObject2).name;
          if (localObject2 == null) {
            break label446;
          }
          i = ((LocalMapResource)localObject2).downloadProgress;
          label364:
          localObject1 = String.format(Locale.getDefault(), "[离线地图包]正在下载%s（未下载%d个）", new Object[] { localObject1, Integer.valueOf(k) });
          b.a(c.a(false)).a((String)localObject1, i);
        }
        for (;;)
        {
          if (paramBoolean2) {
            f.k(f.this);
          }
          if ((paramInt != 102) && (paramInt != 101)) {
            c.d();
          }
          return;
          label439:
          localObject1 = "";
          break;
          label446:
          i = 0;
          break label364;
          label451:
          if ((m > 0) && (paramBoolean2))
          {
            localObject1 = String.format(Locale.getDefault(), "[离线地图包]下载已暂停（未完成%d个）", new Object[] { Integer.valueOf(m) });
            b.a(c.a(false)).a((String)localObject1);
          }
          else if (paramBoolean3)
          {
            b.a(c.a(false)).b("[离线地图包]已完成所有下载");
            if (f.j(f.this)) {
              BMEventBus.getInstance().post(new com.baidu.baidumaps.common.a.d());
            }
          }
          else if ((k == 0) && (m == 0))
          {
            b.a(c.a(false)).b();
          }
        }
      }
    };
    local2.setQueueToken(this.H);
    ConcurrentManager.executeTask(Module.LOCAL_MAP_MODULE, local2, ScheduleConfig.forData());
  }
  
  private void i(int paramInt)
  {
    boolean bool = true;
    com.baidu.platform.comapi.util.f.b(l, "onFirstLocated");
    if (this.t <= 1)
    {
      this.t = paramInt;
      if (this.u <= 0) {
        break label82;
      }
    }
    for (;;)
    {
      this.v = bool;
      com.baidu.platform.comapi.util.f.b(l, "onFirstLocated：cfg=" + this.w);
      if ((!this.v) && (this.w)) {
        s();
      }
      return;
      label82:
      bool = false;
    }
  }
  
  private int j(int paramInt)
  {
    if (NetworkUtil.isWifiConnected(com.baidu.platform.comapi.c.f()))
    {
      this.A = true;
      return q().autoDownloadRoadNetworkViaWifi(paramInt);
    }
    return 0;
  }
  
  private void o()
  {
    ConcurrentManager.scheduleTask(Module.LOCAL_MAP_MODULE, new ScheduleTask(2000L)
    {
      public void run()
      {
        try
        {
          Set localSet = GlobalConfig.getInstance().getLocalMapAutoResumeCityIds();
          long l = c.f();
          if ((f.b(f.this)) && ((l > 3145728L) || (l == -1L)))
          {
            Iterator localIterator = f.c(f.this).iterator();
            while (localIterator.hasNext())
            {
              LocalMapResource localLocalMapResource = (LocalMapResource)localIterator.next();
              if ((d.c(localLocalMapResource)) && (localSet.contains(Integer.valueOf(localLocalMapResource.id)))) {
                f.this.b(localLocalMapResource.id);
              }
            }
          }
          return;
        }
        catch (Exception localException) {}
      }
    }, ScheduleConfig.forData());
  }
  
  private void onEventMainThread(h paramh)
  {
    j();
  }
  
  private void onEventMainThread(com.baidu.baidumaps.common.a.b paramb)
  {
    this.j = false;
    if (paramb == null) {
      return;
    }
    v();
  }
  
  private void onEventMainThread(com.baidu.baidumaps.common.a.c paramc)
  {
    if (paramc == null) {
      return;
    }
    GlobalConfig.getInstance().setLastLocationCityName(paramc.b());
    i(paramc.a());
  }
  
  private void p()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.B.iterator();
    while (localIterator.hasNext())
    {
      LocalMapResource localLocalMapResource = (LocalMapResource)localIterator.next();
      if ((d.a(localLocalMapResource)) || (d.b(localLocalMapResource))) {
        localHashSet.add(Integer.valueOf(localLocalMapResource.id));
      }
    }
    GlobalConfig.getInstance().setLocalMapAutoResumeCityIds(localHashSet);
  }
  
  private LocalMapManager q()
  {
    if (this.r == null)
    {
      this.r = LocalMapManager.getInstance();
      this.r.init(MapViewFactory.getInstance().getMapView().getController());
    }
    return this.r;
  }
  
  private boolean r()
  {
    long l1 = c.f();
    if (l1 == -1L) {}
    while (l1 >= 3145728L) {
      return true;
    }
    if (this.y) {
      return false;
    }
    Object localObject = (Activity)c.a(true);
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      localObject = new com.baidu.carlife.view.dialog.c((Context)localObject).c("提醒").b("检测到当前您的SD卡空间不足，为保证软件的正常使用，建议您腾出空间后再进行下载。").d("确定").a(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          f.a(f.this, false);
        }
      });
      g.a().showDialog((BaseDialog)localObject);
      this.y = true;
    }
    return false;
  }
  
  private void s()
  {
    if ((!StorageSettings.getInstance().isExternalStorageEnabled()) || (!StorageSettings.getInstance().isHasExternalStoragePermission())) {
      return;
    }
    t();
  }
  
  private void t()
  {
    int i5 = 1;
    int i2 = 1;
    int i6 = 1;
    int i1 = 1;
    long l1 = c.f();
    Object localObject;
    int i3;
    int i4;
    if ((u()) && ((l1 > 15728640L) || (l1 == -1L)))
    {
      com.baidu.platform.comapi.util.f.b(l, "startDefaultDownload:发起下载");
      localObject = this.r.getUserResources();
      i3 = i5;
      i4 = i6;
      if (localObject != null)
      {
        i3 = i5;
        i4 = i6;
        if (((List)localObject).size() > 0)
        {
          localObject = ((List)localObject).iterator();
          for (;;)
          {
            i3 = i2;
            i4 = i1;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            LocalMapResource localLocalMapResource = (LocalMapResource)((Iterator)localObject).next();
            i4 = localLocalMapResource.id;
            i5 = localLocalMapResource.downloadStatus;
            i6 = localLocalMapResource.updateStatus;
            i3 = i2;
            if (i4 == this.t)
            {
              i3 = i2;
              if (i5 != 9)
              {
                i3 = i2;
                if (i6 != 4) {
                  i3 = 0;
                }
              }
            }
            i2 = i3;
            if (i4 == 1)
            {
              i2 = i3;
              if (i5 != 9)
              {
                i2 = i3;
                if (i6 != 4)
                {
                  i1 = 0;
                  i2 = i3;
                }
              }
            }
          }
        }
      }
      if ((i3 != 1) || (i4 != 1)) {
        break label261;
      }
      a(this.t);
      a(1);
      MToast.show(com.baidu.platform.comapi.c.f(), "当前为WiFi网络，正在为您下载当前城市离线包");
    }
    for (;;)
    {
      localObject = GlobalConfig.getInstance();
      if (localObject != null) {
        ((GlobalConfig)localObject).setLMFirstLocateCityId(this.t);
      }
      return;
      label261:
      if ((i3 == 1) && (i4 == 0))
      {
        a(this.t);
        MToast.show(com.baidu.platform.comapi.c.f(), "当前为WiFi网络，正在为您下载当前城市离线包");
      }
      else if ((i3 == 0) && (i4 == 1))
      {
        a(1);
        MToast.show(com.baidu.platform.comapi.c.f(), "当前为WiFi网络，正在为您下载全国离线包");
      }
    }
  }
  
  private boolean u()
  {
    return NetworkUtil.isWifiConnected(com.baidu.platform.comapi.c.f());
  }
  
  private void v()
  {
    ConcurrentManager.executeTask(Module.LOCAL_MAP_MODULE, new ConcurrentTask()
    {
      public void run()
      {
        long l = c.f();
        if ((l <= 3145728L) && (l != -1L)) {
          f.this.e(2);
        }
        if (f.b(f.this))
        {
          if (!f.d(f.this))
          {
            int i = GlobalConfig.getInstance().getLastLocationCityCode();
            if (i > 1)
            {
              f.e(f.this).autoDownloadRoadNetworkViaWifi(i);
              f.b(f.this, true);
            }
          }
          f.this.c(2);
          f.this.c(3);
        }
        for (;;)
        {
          if ((f.b(f.this)) && (GlobalConfig.getInstance().isAutoDownload())) {
            c.b();
          }
          f.f(f.this);
          f.this.notifyObservers();
          return;
          if (!f.this.j) {
            f.this.e(1);
          }
        }
      }
    }, ScheduleConfig.forData());
  }
  
  private void w()
  {
    if ((!u()) && (!this.j)) {
      e(1);
    }
    try
    {
      Activity localActivity = (Activity)c.a(true);
      if ((localActivity != null) && (!localActivity.isFinishing()) && (this.x == null))
      {
        this.x = new com.baidu.carlife.view.dialog.c(localActivity).c("提示").a(2131296730).d("确定").e("取消").r().a(new com.baidu.carlife.core.screen.b()
        {
          public void onClick()
          {
            f.this.j = true;
            f.this.k = false;
            f.this.c(2);
            f.this.c(3);
          }
        }).b(new com.baidu.carlife.core.screen.b()
        {
          public void onClick()
          {
            f.this.j = false;
            f.this.k = false;
          }
        });
        this.x.setOnDialogCancelListener(new com.baidu.carlife.core.screen.d()
        {
          public void onCancel()
          {
            f.a(f.this, null);
          }
        });
        g.a().showDialog(this.x);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public List<LocalMapResource> a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return q().getCitiesByName(paramString);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    b(paramInt, paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    c.a(paramBoolean1, paramBoolean2);
    n();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    c.a(paramBoolean1, paramBoolean2);
    q().importMap(paramBoolean3, paramBoolean4);
  }
  
  public boolean a(int paramInt)
  {
    if (!r()) {
      return false;
    }
    BaiduNaviManager.getInstance().downLoadCityMapData(paramInt);
    return q().start(paramInt);
  }
  
  public void b()
  {
    if (this.p) {}
    while ((!StorageSettings.getInstance().isExternalStorageEnabled()) || (!StorageSettings.getInstance().isHasExternalStoragePermission())) {
      return;
    }
    this.p = true;
    this.t = GlobalConfig.getInstance().getLMFirstLocateCityId();
    BMEventBus.getInstance().regist(this, Module.LOCAL_MAP_MODULE, h.class, new Class[] { com.baidu.baidumaps.common.a.b.class, com.baidu.baidumaps.common.a.c.class });
    NetworkListener.registerMessageHandler(this.F);
    q().registerListener(this);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if (u()) {
      if (!GlobalConfig.getInstance().isAutoDownload()) {}
    }
    while (!c.a(paramInt))
    {
      j();
      do
      {
        return;
      } while (!c.a(paramInt));
      return;
    }
  }
  
  public boolean b(int paramInt)
  {
    if (!r()) {
      return false;
    }
    return q().resume(paramInt);
  }
  
  public void c()
  {
    if ((!this.p) || (!this.q)) {
      return;
    }
    this.q = false;
    o();
  }
  
  public boolean c(int paramInt)
  {
    if (!r()) {
      return false;
    }
    return q().resumeAll(paramInt);
  }
  
  public void d()
  {
    if ((!this.p) || (this.q)) {
      return;
    }
    this.q = true;
  }
  
  public boolean d(int paramInt)
  {
    return q().pause(paramInt);
  }
  
  public void e()
  {
    BMEventBus.getInstance().unregist(this);
    if (this.r != null)
    {
      this.r.pauseAll(0);
      this.r.pauseAll(2);
      this.r.removeListener(this);
      this.r.destroy();
      this.r = null;
    }
    b.a(c.a(false)).b();
    this.p = false;
    NetworkListener.unRegisterMessageHandler(this.F);
  }
  
  public boolean e(int paramInt)
  {
    return q().pauseAll(paramInt);
  }
  
  public List<LocalMapResource> f()
  {
    return this.B;
  }
  
  public boolean f(int paramInt)
  {
    return q().delete(paramInt);
  }
  
  public boolean g()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.B != null)
    {
      bool1 = bool2;
      if (this.B.size() > 0)
      {
        Iterator localIterator = this.B.iterator();
        LocalMapResource localLocalMapResource;
        do
        {
          bool1 = bool2;
          if (!localIterator.hasNext()) {
            break;
          }
          localLocalMapResource = (LocalMapResource)localIterator.next();
        } while ((!d.b(localLocalMapResource)) && (!d.a(localLocalMapResource)));
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean g(int paramInt)
  {
    i = false;
    if (!r()) {
      return false;
    }
    return q().update(paramInt);
  }
  
  public LocalMapResource h(int paramInt)
  {
    return q().getCityById(paramInt);
  }
  
  public List<LocalMapResource> h()
  {
    return this.C;
  }
  
  public boolean i()
  {
    return q().deleteAll();
  }
  
  public boolean j()
  {
    i = false;
    if (!r()) {
      return false;
    }
    return q().updateAll();
  }
  
  public LocalMapResource k()
  {
    Object localObject = GeoLocateModel.getInstance().getCurCityName();
    if ((localObject != null) && (((String)localObject).trim().length() > 0))
    {
      localObject = a((String)localObject);
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        return (LocalMapResource)((List)localObject).get(0);
      }
    }
    return null;
  }
  
  public List<LocalMapResource> l()
  {
    return q().getHotCities();
  }
  
  public List<LocalMapResource> m()
  {
    if ((this.D.size() == 0) && (q().getAllCities() != null)) {
      this.D.addAll(q().getAllCities());
    }
    return this.D;
  }
  
  public void n()
  {
    if (this.p)
    {
      q().importMap(true, false);
      if (!this.z)
      {
        a(true, false, false, 0);
        this.z = true;
      }
    }
  }
  
  public void onEvent(Object paramObject)
  {
    if ((paramObject instanceof h)) {
      onEventMainThread((h)paramObject);
    }
    do
    {
      return;
      if ((paramObject instanceof com.baidu.baidumaps.common.a.b))
      {
        onEventMainThread((com.baidu.baidumaps.common.a.b)paramObject);
        return;
      }
    } while (!(paramObject instanceof com.baidu.baidumaps.common.a.c));
    onEventMainThread((com.baidu.baidumaps.common.a.c)paramObject);
  }
  
  public void onGetLocalMapState(int paramInt1, int paramInt2)
  {
    boolean bool4 = true;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool3 = bool5;
    boolean bool1 = bool6;
    boolean bool2 = bool4;
    switch (paramInt1)
    {
    default: 
      bool2 = bool4;
      bool1 = bool6;
      bool3 = bool5;
    }
    for (;;)
    {
      a(bool2, bool1, bool3, paramInt1);
      this.z = true;
      return;
      a(paramInt2, GlobalConfig.getInstance().isAutoDownload());
      bool3 = bool5;
      bool1 = bool6;
      bool2 = bool4;
      continue;
      this.u = paramInt2;
      Context localContext = c.a(false);
      MToast.show(localContext, "正在导入离线地图包");
      if (c.c) {
        b.a(localContext).a(0, this.u, 0);
      }
      a.a().a("offlinemap_import_number");
      bool3 = bool5;
      bool1 = bool6;
      bool2 = bool4;
      continue;
      if (c.c) {
        b.a(c.a(false)).a(paramInt2, this.u, 0);
      }
      bool2 = false;
      bool3 = bool5;
      bool1 = bool6;
      continue;
      c.a(this.u, paramInt2);
      bool3 = bool5;
      bool1 = bool6;
      bool2 = bool4;
      if (this.v)
      {
        bool3 = bool5;
        bool1 = bool6;
        bool2 = bool4;
        if (this.t > 1)
        {
          s();
          this.v = false;
          bool3 = bool5;
          bool1 = bool6;
          bool2 = bool4;
          continue;
          com.baidu.platform.comapi.util.f.b(l, "getCfgMsg:cityid=" + this.t);
          this.w = true;
          bool3 = bool5;
          bool1 = bool6;
          bool2 = bool4;
          if (this.t > 1)
          {
            bool3 = bool5;
            bool1 = bool6;
            bool2 = bool4;
            if (GlobalConfig.getInstance().getLMFirstLocateCityId() <= 1)
            {
              s();
              bool3 = bool5;
              bool1 = bool6;
              bool2 = bool4;
              continue;
              bool1 = true;
              bool3 = bool5;
              bool2 = bool4;
              continue;
              bool3 = bool5;
              bool1 = bool6;
              bool2 = bool4;
              if (System.currentTimeMillis() - this.s <= 1000L)
              {
                bool3 = bool5;
                bool1 = bool6;
                bool2 = bool4;
                if ((0xFFFF & paramInt2) != 100)
                {
                  bool2 = false;
                  bool3 = bool5;
                  bool1 = bool6;
                  continue;
                  NavMapAdapter.getInstance().ReleaseSharedMapData();
                  q().importMap(true, false);
                  NavMapAdapter.getInstance().updateShareMapData();
                  bool3 = true;
                  bool1 = true;
                  bool2 = bool4;
                  continue;
                  bool1 = true;
                  bool3 = bool5;
                  bool2 = bool4;
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidumaps/base/localmap/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */