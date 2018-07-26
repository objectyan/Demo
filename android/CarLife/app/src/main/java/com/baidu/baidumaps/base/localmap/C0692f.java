package com.baidu.baidumaps.base.localmap;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import com.baidu.baidumaps.common.p039a.C0697b;
import com.baidu.baidumaps.common.p039a.C0698c;
import com.baidu.baidumaps.common.p039a.C0699d;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C0690d;
import com.baidu.carlife.core.screen.presentation.p071a.C1309g;
import com.baidu.carlife.view.dialog.C1953c;
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
import com.baidu.platform.comapi.C2907c;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.platform.comapi.map.LocalMapListener;
import com.baidu.platform.comapi.map.LocalMapManager;
import com.baidu.platform.comapi.map.LocalMapResource;
import com.baidu.platform.comapi.p209e.C4770a;
import com.baidu.platform.comapi.util.BMEventBus;
import com.baidu.platform.comapi.util.BMEventBus$OnEvent;
import com.baidu.platform.comapi.util.C2911f;
import com.baidu.platform.comapi.util.NetworkUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.Set;

/* compiled from: LocalMapModel */
/* renamed from: com.baidu.baidumaps.base.localmap.f */
public final class C0692f extends Observable implements LocalMapListener, BMEventBus$OnEvent {
    /* renamed from: a */
    public static final String f2209a = "local_map_sd_card";
    /* renamed from: b */
    public static final String f2210b = "local_map_download_error";
    /* renamed from: c */
    public static final String f2211c = "local_map_storage_changed";
    /* renamed from: d */
    public static final String f2212d = "local_map_storage_info";
    /* renamed from: e */
    public static final String f2213e = "local_map_copy_fail";
    /* renamed from: f */
    public static final String f2214f = "local_map_download_auto";
    /* renamed from: g */
    public static final String f2215g = "local_map_download_user";
    /* renamed from: h */
    public static final String f2216h = "local_map_download_user_with_dialog";
    /* renamed from: i */
    public static boolean f2217i = true;
    /* renamed from: l */
    private static final String f2218l = C0692f.class.getCanonicalName();
    /* renamed from: m */
    private static final long f2219m = 1000;
    /* renamed from: n */
    private static final long f2220n = 15728640;
    /* renamed from: o */
    private static volatile C0692f f2221o;
    /* renamed from: A */
    private boolean f2222A = false;
    /* renamed from: B */
    private List<LocalMapResource> f2223B = new ArrayList();
    /* renamed from: C */
    private List<LocalMapResource> f2224C = new ArrayList();
    /* renamed from: D */
    private final List<LocalMapResource> f2225D = new ArrayList();
    /* renamed from: E */
    private final Comparator<LocalMapResource> f2226E = new C06811(this);
    /* renamed from: F */
    private MsgHandler f2227F = new MsgHandler(this, Looper.getMainLooper()) {
        /* renamed from: a */
        final /* synthetic */ C0692f f2202a;

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case NetworkListener.MSG_TYPE_NET_WORK_CHANGE /*5555*/:
                    LogUtil.e("Handler", " in case NetworkListener.MSG_TYPE_NET_WORK_CHANGE");
                    int wifiStatus = msg.arg1;
                    if (msg.arg2 == 0 || wifiStatus == 0) {
                        this.f2202a.m2921v();
                    } else {
                        this.f2202a.m2921v();
                    }
                    return;
                default:
                    return;
            }
        }

        public void careAbout() {
        }
    };
    /* renamed from: G */
    private MainLooperHandler f2228G = new MainLooperHandler(this, Module.LOCAL_MAP_MODULE, ScheduleConfig.forData()) {
        /* renamed from: a */
        final /* synthetic */ C0692f f2195a;

        public void onMessage(Message msg) {
            this.f2195a.setChanged();
            this.f2195a.notifyObservers();
        }
    };
    /* renamed from: H */
    private QueueToken f2229H = ConcurrentManager.obtainTaskQueue(Module.LOCAL_MAP_MODULE);
    /* renamed from: j */
    public boolean f2230j = false;
    /* renamed from: k */
    public boolean f2231k = false;
    /* renamed from: p */
    private boolean f2232p = false;
    /* renamed from: q */
    private boolean f2233q = true;
    /* renamed from: r */
    private LocalMapManager f2234r;
    /* renamed from: s */
    private long f2235s = (System.currentTimeMillis() - f2219m);
    /* renamed from: t */
    private int f2236t = 0;
    /* renamed from: u */
    private int f2237u = 0;
    /* renamed from: v */
    private boolean f2238v = false;
    /* renamed from: w */
    private boolean f2239w = false;
    /* renamed from: x */
    private C1953c f2240x;
    /* renamed from: y */
    private boolean f2241y = false;
    /* renamed from: z */
    private boolean f2242z = false;

    /* compiled from: LocalMapModel */
    /* renamed from: com.baidu.baidumaps.base.localmap.f$1 */
    class C06811 implements Comparator<LocalMapResource> {
        /* renamed from: a */
        final /* synthetic */ C0692f f2196a;

        C06811(C0692f this$0) {
            this.f2196a = this$0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m2892a((LocalMapResource) obj, (LocalMapResource) obj2);
        }

        /* renamed from: a */
        public int m2892a(LocalMapResource first, LocalMapResource second) {
            return first.pinyin.compareTo(second.pinyin);
        }
    }

    /* compiled from: LocalMapModel */
    /* renamed from: com.baidu.baidumaps.base.localmap.f$5 */
    class C06855 implements C0672b {
        /* renamed from: a */
        final /* synthetic */ C0692f f2204a;

        C06855(C0692f this$0) {
            this.f2204a = this$0;
        }

        public void onClick() {
            this.f2204a.f2241y = false;
        }
    }

    /* compiled from: LocalMapModel */
    /* renamed from: com.baidu.baidumaps.base.localmap.f$6 */
    class C06866 extends ConcurrentTask {
        /* renamed from: a */
        final /* synthetic */ C0692f f2205a;

        C06866(C0692f this$0) {
            this.f2205a = this$0;
        }

        public void run() {
            long sdcardFreeSize = C0676c.m2874f();
            if (sdcardFreeSize <= 3145728 && sdcardFreeSize != -1) {
                this.f2205a.m2936e(2);
            }
            if (this.f2205a.m2920u()) {
                if (!this.f2205a.f2222A) {
                    int cityId = GlobalConfig.getInstance().getLastLocationCityCode();
                    if (cityId > 1) {
                        this.f2205a.m2916q().autoDownloadRoadNetworkViaWifi(cityId);
                        this.f2205a.f2222A = true;
                    }
                }
                this.f2205a.m2932c(2);
                this.f2205a.m2932c(3);
            } else if (!this.f2205a.f2230j) {
                this.f2205a.m2936e(1);
            }
            if (this.f2205a.m2920u() && GlobalConfig.getInstance().isAutoDownload()) {
                C0676c.m2869b();
            }
            this.f2205a.setChanged();
            this.f2205a.notifyObservers();
        }
    }

    /* compiled from: LocalMapModel */
    /* renamed from: com.baidu.baidumaps.base.localmap.f$7 */
    class C06877 implements C0672b {
        /* renamed from: a */
        final /* synthetic */ C0692f f2206a;

        C06877(C0692f this$0) {
            this.f2206a = this$0;
        }

        public void onClick() {
            this.f2206a.f2230j = false;
            this.f2206a.f2231k = false;
        }
    }

    /* compiled from: LocalMapModel */
    /* renamed from: com.baidu.baidumaps.base.localmap.f$8 */
    class C06888 implements C0672b {
        /* renamed from: a */
        final /* synthetic */ C0692f f2207a;

        C06888(C0692f this$0) {
            this.f2207a = this$0;
        }

        public void onClick() {
            this.f2207a.f2230j = true;
            this.f2207a.f2231k = false;
            this.f2207a.m2932c(2);
            this.f2207a.m2932c(3);
        }
    }

    /* compiled from: LocalMapModel */
    /* renamed from: com.baidu.baidumaps.base.localmap.f$9 */
    class C06919 implements C0690d {
        /* renamed from: a */
        final /* synthetic */ C0692f f2208a;

        C06919(C0692f this$0) {
            this.f2208a = this$0;
        }

        public void onCancel() {
            this.f2208a.f2240x = null;
        }
    }

    /* renamed from: a */
    public static C0692f m2894a() {
        if (f2221o == null) {
            synchronized (C0692f.class) {
                if (f2221o == null) {
                    f2221o = new C0692f();
                }
            }
        }
        return f2221o;
    }

    /* renamed from: b */
    public void m2928b() {
        if (!this.f2232p && StorageSettings.getInstance().isExternalStorageEnabled() && StorageSettings.getInstance().isHasExternalStoragePermission()) {
            this.f2232p = true;
            this.f2236t = GlobalConfig.getInstance().getLMFirstLocateCityId();
            BMEventBus.getInstance().regist(this, Module.LOCAL_MAP_MODULE, C0694h.class, C0697b.class, C0698c.class);
            NetworkListener.registerMessageHandler(this.f2227F);
            m2916q().registerListener(this);
        }
    }

    /* renamed from: c */
    public void m2931c() {
        if (this.f2232p && this.f2233q) {
            this.f2233q = false;
            m2914o();
        }
    }

    /* renamed from: o */
    private void m2914o() {
        ConcurrentManager.scheduleTask(Module.LOCAL_MAP_MODULE, new ScheduleTask(this, 2000) {
            /* renamed from: a */
            final /* synthetic */ C0692f f2203a;

            public void run() {
                try {
                    Set<Integer> autoResumeCityIds = GlobalConfig.getInstance().getLocalMapAutoResumeCityIds();
                    long sdcardFreeSize = C0676c.m2874f();
                    if (!this.f2203a.m2920u()) {
                        return;
                    }
                    if (sdcardFreeSize > 3145728 || sdcardFreeSize == -1) {
                        for (LocalMapResource resource : this.f2203a.f2223B) {
                            if (C0679d.m2881c(resource) && autoResumeCityIds.contains(Integer.valueOf(resource.id))) {
                                this.f2203a.m2930b(resource.id);
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
        }, ScheduleConfig.forData());
    }

    /* renamed from: d */
    public void m2933d() {
        if (this.f2232p && !this.f2233q) {
            this.f2233q = true;
        }
    }

    /* renamed from: e */
    public void m2935e() {
        BMEventBus.getInstance().unregist(this);
        if (this.f2234r != null) {
            this.f2234r.pauseAll(0);
            this.f2234r.pauseAll(2);
            this.f2234r.removeListener(this);
            this.f2234r.destroy();
            this.f2234r = null;
        }
        C0669b.m2851a(C0676c.m2863a(false)).m2861b();
        this.f2232p = false;
        NetworkListener.unRegisterMessageHandler(this.f2227F);
    }

    /* renamed from: p */
    private void m2915p() {
        Set<Integer> autoResumeCityIds = new HashSet();
        for (LocalMapResource resource : this.f2223B) {
            if (C0679d.m2879a(resource) || C0679d.m2880b(resource)) {
                autoResumeCityIds.add(Integer.valueOf(resource.id));
            }
        }
        GlobalConfig.getInstance().setLocalMapAutoResumeCityIds(autoResumeCityIds);
    }

    /* renamed from: q */
    private LocalMapManager m2916q() {
        if (this.f2234r == null) {
            this.f2234r = LocalMapManager.getInstance();
            this.f2234r.init(MapViewFactory.getInstance().getMapView().getController());
        }
        return this.f2234r;
    }

    /* renamed from: r */
    private boolean m2917r() {
        long sdcardFreeSize = C0676c.m2874f();
        if (sdcardFreeSize == -1 || sdcardFreeSize >= 3145728) {
            return true;
        }
        if (this.f2241y) {
            return false;
        }
        Activity activity = (Activity) C0676c.m2863a(true);
        if (!(activity == null || activity.isFinishing())) {
            C1309g.m4699a().showDialog(new C1953c(activity).m7448c("提醒").m7444b(UIMsg.UI_TIP_SDCARD_NO_SPACE).m7451d("确定").m7438a(new C06855(this)));
            this.f2241y = true;
        }
        return false;
    }

    /* renamed from: f */
    public List<LocalMapResource> m2937f() {
        return this.f2223B;
    }

    /* renamed from: g */
    public boolean m2939g() {
        if (this.f2223B == null || this.f2223B.size() <= 0) {
            return false;
        }
        for (LocalMapResource resource : this.f2223B) {
            if (!C0679d.m2880b(resource)) {
                if (C0679d.m2879a(resource)) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: h */
    public List<LocalMapResource> m2942h() {
        return this.f2224C;
    }

    /* renamed from: a */
    public boolean m2927a(int cityId) {
        if (!m2917r()) {
            return false;
        }
        BaiduNaviManager.getInstance().downLoadCityMapData(cityId);
        return m2916q().start(cityId);
    }

    /* renamed from: b */
    public boolean m2930b(int cityId) {
        if (m2917r()) {
            return m2916q().resume(cityId);
        }
        return false;
    }

    /* renamed from: c */
    public boolean m2932c(int type) {
        if (m2917r()) {
            return m2916q().resumeAll(type);
        }
        return false;
    }

    /* renamed from: d */
    public boolean m2934d(int cityId) {
        return m2916q().pause(cityId);
    }

    /* renamed from: e */
    public boolean m2936e(int type) {
        return m2916q().pauseAll(type);
    }

    /* renamed from: f */
    public boolean m2938f(int cityId) {
        return m2916q().delete(cityId);
    }

    /* renamed from: i */
    public boolean m2943i() {
        return m2916q().deleteAll();
    }

    /* renamed from: g */
    public boolean m2940g(int cityId) {
        f2217i = false;
        if (m2917r()) {
            return m2916q().update(cityId);
        }
        return false;
    }

    /* renamed from: j */
    public boolean m2944j() {
        f2217i = false;
        if (m2917r()) {
            return m2916q().updateAll();
        }
        return false;
    }

    /* renamed from: a */
    public List<LocalMapResource> m2923a(String strKey) {
        if (strKey == null) {
            return null;
        }
        return m2916q().getCitiesByName(strKey);
    }

    /* renamed from: h */
    public LocalMapResource m2941h(int ncityid) {
        return m2916q().getCityById(ncityid);
    }

    /* renamed from: k */
    public LocalMapResource m2945k() {
        String cityName = GeoLocateModel.getInstance().getCurCityName();
        if (cityName != null && cityName.trim().length() > 0) {
            List<LocalMapResource> cities = m2923a(cityName);
            if (cities != null && cities.size() > 0) {
                return (LocalMapResource) cities.get(0);
            }
        }
        return null;
    }

    /* renamed from: l */
    public List<LocalMapResource> m2946l() {
        return m2916q().getHotCities();
    }

    /* renamed from: m */
    public List<LocalMapResource> m2947m() {
        if (this.f2225D.size() == 0 && m2916q().getAllCities() != null) {
            this.f2225D.addAll(m2916q().getAllCities());
        }
        return this.f2225D;
    }

    /* renamed from: s */
    private void m2918s() {
        if (StorageSettings.getInstance().isExternalStorageEnabled() && StorageSettings.getInstance().isHasExternalStoragePermission()) {
            m2919t();
        }
    }

    /* renamed from: t */
    private void m2919t() {
        boolean isNeedStartLocateCityDownload = true;
        boolean isNeedStartWholeCountryDownload = true;
        long sdcardFreeSize = C0676c.m2874f();
        if (!m2920u()) {
            return;
        }
        if (sdcardFreeSize > f2220n || sdcardFreeSize == -1) {
            C2911f.m11015b(f2218l, "startDefaultDownload:发起下载");
            List<LocalMapResource> userResources = this.f2234r.getUserResources();
            if (userResources != null && userResources.size() > 0) {
                for (LocalMapResource localMapResource : userResources) {
                    int id = localMapResource.id;
                    int status = localMapResource.downloadStatus;
                    int updateStatus = localMapResource.updateStatus;
                    if (!(id != this.f2236t || status == 9 || updateStatus == 4)) {
                        isNeedStartLocateCityDownload = false;
                    }
                    if (!(id != 1 || status == 9 || updateStatus == 4)) {
                        isNeedStartWholeCountryDownload = false;
                    }
                }
            }
            if (isNeedStartLocateCityDownload && isNeedStartWholeCountryDownload) {
                m2927a(this.f2236t);
                m2927a(1);
                MToast.show(C2907c.m10977f(), "当前为WiFi网络，正在为您下载当前城市离线包");
            } else if (isNeedStartLocateCityDownload && !isNeedStartWholeCountryDownload) {
                m2927a(this.f2236t);
                MToast.show(C2907c.m10977f(), "当前为WiFi网络，正在为您下载当前城市离线包");
            } else if (!isNeedStartLocateCityDownload && isNeedStartWholeCountryDownload) {
                m2927a(1);
                MToast.show(C2907c.m10977f(), "当前为WiFi网络，正在为您下载全国离线包");
            }
            GlobalConfig config = GlobalConfig.getInstance();
            if (config != null) {
                config.setLMFirstLocateCityId(this.f2236t);
            }
        }
    }

    /* renamed from: i */
    private void m2910i(int cityId) {
        boolean z = true;
        C2911f.m11015b(f2218l, "onFirstLocated");
        if (this.f2236t <= 1) {
            this.f2236t = cityId;
            if (this.f2237u <= 0) {
                z = false;
            }
            this.f2238v = z;
            C2911f.m11015b(f2218l, "onFirstLocated：cfg=" + this.f2239w);
            if (!this.f2238v && this.f2239w) {
                m2918s();
            }
        }
    }

    /* renamed from: n */
    public void m2948n() {
        if (this.f2232p) {
            m2916q().importMap(true, false);
            if (!this.f2242z) {
                m2898a(true, false, false, 0);
                this.f2242z = true;
            }
        }
    }

    /* renamed from: a */
    public void m2925a(boolean haveToShowDialog, boolean haveToShowNotification) {
        C0676c.m2866a(haveToShowDialog, haveToShowNotification);
        m2948n();
    }

    /* renamed from: a */
    public void m2926a(boolean haveToShowDialog, boolean haveToShowNotification, boolean deleteFailed, boolean offImport) {
        C0676c.m2866a(haveToShowDialog, haveToShowNotification);
        m2916q().importMap(deleteFailed, offImport);
    }

    /* renamed from: u */
    private boolean m2920u() {
        return NetworkUtil.isWifiConnected(C2907c.m10977f());
    }

    private void onEventMainThread(C0698c event) {
        if (event != null) {
            GlobalConfig.getInstance().setLastLocationCityName(event.m2950b());
            m2910i(event.m2949a());
        }
    }

    private void onEventMainThread(C0697b event) {
        this.f2230j = false;
        if (event != null) {
            m2921v();
        }
    }

    /* renamed from: v */
    private void m2921v() {
        ConcurrentManager.executeTask(Module.LOCAL_MAP_MODULE, new C06866(this), ScheduleConfig.forData());
    }

    /* renamed from: a */
    public void m2924a(int time, boolean isAutoDownload) {
        m2929b(time, isAutoDownload);
    }

    /* renamed from: b */
    public void m2929b(int time, boolean isAutoDownload) {
        if (m2920u()) {
            if (GlobalConfig.getInstance().isAutoDownload()) {
                m2944j();
            } else if (!C0676c.m2867a(time)) {
            }
        } else if (!C0676c.m2867a(time)) {
        }
    }

    public void onGetLocalMapState(int type, int state) {
        boolean reloadDataAndNotifyObservers = true;
        boolean notifyFinished = false;
        boolean recordDownloading = false;
        int progress;
        switch (type) {
            case 0:
                recordDownloading = true;
                break;
            case 4:
                m2924a(state, GlobalConfig.getInstance().isAutoDownload());
                break;
            case 6:
                C0676c.m2865a(this.f2237u, state);
                if (this.f2238v && this.f2236t > 1) {
                    m2918s();
                    this.f2238v = false;
                    break;
                }
            case 8:
                progress = 65535 & state;
                if (System.currentTimeMillis() - this.f2235s <= f2219m && progress != 100) {
                    reloadDataAndNotifyObservers = false;
                    break;
                }
            case 9:
                recordDownloading = true;
                break;
            case 12:
                NavMapAdapter.getInstance().ReleaseSharedMapData();
                m2916q().importMap(true, false);
                NavMapAdapter.getInstance().updateShareMapData();
                notifyFinished = true;
                recordDownloading = true;
                break;
            case 101:
                this.f2237u = state;
                Context context = C0676c.m2863a(false);
                MToast.show(context, "正在导入离线地图包");
                if (C0676c.f2183c) {
                    C0669b.m2851a(context).m2857a(0, this.f2237u, 0);
                }
                C4770a.a().a(C0668a.f2129E);
                break;
            case 102:
                progress = state;
                if (C0676c.f2183c) {
                    C0669b.m2851a(C0676c.m2863a(false)).m2857a(progress, this.f2237u, 0);
                }
                reloadDataAndNotifyObservers = false;
                break;
            case 201:
                C2911f.m11015b(f2218l, "getCfgMsg:cityid=" + this.f2236t);
                this.f2239w = true;
                if (this.f2236t > 1 && GlobalConfig.getInstance().getLMFirstLocateCityId() <= 1) {
                    m2918s();
                    break;
                }
        }
        m2898a(reloadDataAndNotifyObservers, recordDownloading, notifyFinished, type);
        this.f2242z = true;
    }

    /* renamed from: w */
    private void m2922w() {
        if (!m2920u() && !this.f2230j) {
            m2936e(1);
            try {
                Activity activity = (Activity) C0676c.m2863a(true);
                if (activity != null && !activity.isFinishing() && this.f2240x == null) {
                    this.f2240x = new C1953c(activity).m7448c("提示").m7435a((int) C0965R.string.not_wifi_network).m7451d("确定").m7454e("取消").m7459r().m7438a(new C06888(this)).m7443b(new C06877(this));
                    this.f2240x.setOnDialogCancelListener(new C06919(this));
                    C1309g.m4699a().showDialog(this.f2240x);
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    private void m2898a(boolean reloadDataAndNotifyObservers, boolean recordDownloading, boolean notifyFinished, int type) {
        final boolean z = reloadDataAndNotifyObservers;
        final boolean z2 = recordDownloading;
        final boolean z3 = notifyFinished;
        final int i = type;
        ConcurrentTask task = new ConcurrentTask(this) {
            /* renamed from: e */
            final /* synthetic */ C0692f f2201e;

            public void run() {
                if (z && this.f2201e.f2234r != null) {
                    List<LocalMapResource> userResources = this.f2201e.f2234r.getUserResources();
                    List downloadResources = new ArrayList();
                    List finishedResources = new ArrayList();
                    LocalMapResource downloadingResource = null;
                    int downloadCount = 0;
                    int stopedCount = 0;
                    if (userResources != null) {
                        for (LocalMapResource resource : userResources) {
                            if ((resource.downloadStatus == 9 || resource.updateStatus == 4) && this.f2201e.m2920u()) {
                                if (GlobalConfig.getInstance().isAutoDownload()) {
                                    BMEventBus.getInstance().post(new C0694h());
                                } else {
                                    BMEventBus.getInstance().post(new C0680e(true, resource.formatVersion));
                                }
                            }
                            if (C0679d.m2879a(resource)) {
                                downloadResources.add(resource);
                                downloadCount++;
                            } else if (C0679d.m2880b(resource)) {
                                downloadResources.add(resource);
                                if (resource.downloadStatus == 1) {
                                    downloadCount++;
                                }
                                downloadingResource = resource;
                            } else if (C0679d.m2881c(resource)) {
                                downloadResources.add(resource);
                                stopedCount++;
                            } else if (C0679d.m2882d(resource)) {
                                finishedResources.add(resource);
                            }
                        }
                    }
                    this.f2201e.f2235s = System.currentTimeMillis();
                    this.f2201e.f2223B = downloadResources;
                    this.f2201e.f2224C = finishedResources;
                    this.f2201e.f2228G.obtainMessage().sendToTarget();
                    if (downloadCount > 0) {
                        String downloadingName = downloadingResource != null ? downloadingResource.name : "";
                        C0669b.m2851a(C0676c.m2863a(false)).m2859a(String.format(Locale.getDefault(), "[离线地图包]正在下载%s（未下载%d个）", new Object[]{downloadingName, Integer.valueOf(downloadCount)}), downloadingResource != null ? downloadingResource.downloadProgress : 0);
                    } else if (stopedCount > 0 && z2) {
                        C0669b.m2851a(C0676c.m2863a(false)).m2858a(String.format(Locale.getDefault(), "[离线地图包]下载已暂停（未完成%d个）", new Object[]{Integer.valueOf(stopedCount)}));
                    } else if (z3) {
                        C0669b.m2851a(C0676c.m2863a(false)).m2862b("[离线地图包]已完成所有下载");
                        if (this.f2201e.f2233q) {
                            BMEventBus.getInstance().post(new C0699d());
                        }
                    } else if (downloadCount == 0 && stopedCount == 0) {
                        C0669b.m2851a(C0676c.m2863a(false)).m2861b();
                    }
                }
                if (z2) {
                    this.f2201e.m2915p();
                }
                if (i != 102 && i != 101) {
                    C0676c.m2872d();
                }
            }
        };
        task.setQueueToken(this.f2229H);
        ConcurrentManager.executeTask(Module.LOCAL_MAP_MODULE, task, ScheduleConfig.forData());
    }

    public void onEvent(Object obj) {
        if (obj instanceof C0694h) {
            onEventMainThread((C0694h) obj);
        } else if (obj instanceof C0697b) {
            onEventMainThread((C0697b) obj);
        } else if (obj instanceof C0698c) {
            onEventMainThread((C0698c) obj);
        }
    }

    private void onEventMainThread(C0694h event) {
        m2944j();
    }

    /* renamed from: j */
    private int m2911j(int cityId) {
        if (!NetworkUtil.isWifiConnected(C2907c.m10977f())) {
            return 0;
        }
        this.f2222A = true;
        return m2916q().autoDownloadRoadNetworkViaWifi(cityId);
    }
}
