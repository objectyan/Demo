package com.baidu.carlife;

import android.app.Activity;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
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
import android.os.StrictMode.ThreadPolicy;
import android.os.SystemClock;
import android.support.v4.app.OnFragmentListener;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout.LayoutParams;
import com.baidu.baidumaps.base.localmap.C0692f;
import com.baidu.baidumaps.common.network.NetworkListener;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.NavTrajectoryController;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.carlife.ScreenListener.C0922a;
import com.baidu.carlife.adpter.C1020q.C1011b;
import com.baidu.carlife.bluetooth.C1043a;
import com.baidu.carlife.bluetooth.C1047b;
import com.baidu.carlife.bluetooth.C1050e;
import com.baidu.carlife.bluetooth.C1058f;
import com.baidu.carlife.connect.C1155a;
import com.baidu.carlife.connect.UsbStateReceiver;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1192c;
import com.baidu.carlife.core.C1249d;
import com.baidu.carlife.core.C1249d.C1248a;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1253f.C1252a;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.C1262l;
import com.baidu.carlife.core.connect.C1212c;
import com.baidu.carlife.core.connect.C1246i;
import com.baidu.carlife.core.connect.WifiDirectBroadReceiver;
import com.baidu.carlife.core.p069b.C1190a;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C0690d;
import com.baidu.carlife.core.screen.C0940j;
import com.baidu.carlife.core.screen.p053b.C0920c;
import com.baidu.carlife.core.screen.p056a.C0939b;
import com.baidu.carlife.core.screen.p056a.C1268a;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.core.screen.presentation.CarlifeActivityService;
import com.baidu.carlife.core.screen.presentation.p071a.C1319h;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.custom.C1343b;
import com.baidu.carlife.custom.elhyf.C1371b;
import com.baidu.carlife.logic.C1710a;
import com.baidu.carlife.logic.C1747c;
import com.baidu.carlife.logic.C1757d;
import com.baidu.carlife.logic.C1765g;
import com.baidu.carlife.logic.C1772k;
import com.baidu.carlife.logic.C1774l;
import com.baidu.carlife.logic.C1869r;
import com.baidu.carlife.logic.music.C1790b;
import com.baidu.carlife.logic.music.C1818h;
import com.baidu.carlife.logic.voice.C1912n;
import com.baidu.carlife.model.C1929i;
import com.baidu.carlife.p052m.C1915a;
import com.baidu.carlife.p052m.C1915a.C0917b;
import com.baidu.carlife.p054k.C1659r;
import com.baidu.carlife.p054k.p055a.C1626e.C0924a;
import com.baidu.carlife.p057a.C0967a;
import com.baidu.carlife.p058b.C1029a;
import com.baidu.carlife.p077e.C1435a;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p085i.C1609a;
import com.baidu.carlife.p085i.C1609a.C1608a;
import com.baidu.carlife.p086j.C1612a;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.p100n.C1977e;
import com.baidu.carlife.platform.C1984a;
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
import com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion;
import com.baidu.carlife.protobuf.CarlifeStatisticsInfoProto.CarlifeStatisticsInfo;
import com.baidu.carlife.protobuf.CarlifeTouchActionProto.CarlifeTouchAction;
import com.baidu.carlife.protobuf.CarlifeVehicleInfoListProto.CarlifeVehicleInfoList;
import com.baidu.carlife.push.C2103a;
import com.baidu.carlife.service.PhoneStateService;
import com.baidu.carlife.util.C2186p;
import com.baidu.carlife.util.C2187q;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.util.C2191s;
import com.baidu.carlife.util.C2195t;
import com.baidu.carlife.util.C2198u;
import com.baidu.carlife.util.C2199v;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.util.C2204x;
import com.baidu.carlife.view.C2252a;
import com.baidu.carlife.view.C2342g;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.carlife.view.dialog.C2289i;
import com.baidu.carlife.view.dialog.C2328t;
import com.baidu.carlife.wechat.p105a.p107b.C2372c;
import com.baidu.carlife.wechat.p109c.C2415a;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.mobstat.Config;
import com.baidu.navi.ActivityStack;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.ForegroundService;
import com.baidu.navi.controller.LaunchIntentHelper;
import com.baidu.navi.cruise.BCruiser;
import com.baidu.navi.cruise.control.EnterQuitLogicManager;
import com.baidu.navi.driveanalysis.TrackDataUpload;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.ContentFragmentManager;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.fragment.carmode.CarModeMapFragment;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.track.TrackCarDataSolveModel;
import com.baidu.navi.util.StatisticConstants;
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
import com.baidu.navisdk.comapi.setting.SettingParams.Key;
import com.baidu.navisdk.model.MainMapModel;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.RGPickPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.platform.comapi.map.MapBundleKey.MapObjKey;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarlifeActivity extends BaseActivity implements ConnectionInfoListener, C0939b, C0940j {
    /* renamed from: c */
    public static String f2351c = CarlifeActivity.class.getSimpleName();
    /* renamed from: d */
    public static String f2352d = "[WifiDirect]";
    /* renamed from: f */
    public static final long f2353f = -1;
    /* renamed from: g */
    public static final String f2354g = "_ClfWfd";
    /* renamed from: h */
    public static final String f2355h = "_Clf._Wifi";
    /* renamed from: i */
    public static final String f2356i = "available";
    /* renamed from: A */
    private boolean f2357A = false;
    /* renamed from: B */
    private VelocityTracker f2358B;
    /* renamed from: C */
    private boolean f2359C = false;
    /* renamed from: D */
    private C1659r f2360D;
    /* renamed from: E */
    private C2328t f2361E;
    /* renamed from: F */
    private boolean f2362F;
    /* renamed from: G */
    private C1328h f2363G;
    /* renamed from: H */
    private C1319h f2364H;
    /* renamed from: I */
    private String f2365I = "";
    /* renamed from: J */
    private WifiP2pManager f2366J;
    /* renamed from: K */
    private Channel f2367K;
    /* renamed from: L */
    private WifiP2pDnsSdServiceRequest f2368L;
    /* renamed from: M */
    private WifiP2pDnsSdServiceInfo f2369M = null;
    /* renamed from: N */
    private WifiP2pDevice f2370N = null;
    /* renamed from: O */
    private C1246i f2371O = null;
    /* renamed from: P */
    private WifiDirectBroadReceiver f2372P = null;
    /* renamed from: Q */
    private IntentFilter f2373Q = new IntentFilter();
    /* renamed from: R */
    private BNOfflineDataObserver f2374R = new BNOfflineDataObserver(this) {
        /* renamed from: a */
        final /* synthetic */ CarlifeActivity f2330a;

        {
            this.f2330a = this$0;
        }

        public void update(BNSubject o, int type, int event, Object arg) {
            switch (type) {
                case 3:
                    if (event == 277) {
                        this.f2330a.m3098a(1);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    /* renamed from: S */
    private boolean f2375S = false;
    /* renamed from: T */
    private boolean f2376T = true;
    /* renamed from: U */
    private C1608a f2377U = new C1608a();
    /* renamed from: V */
    private BNDayNightChangedObserver f2378V = new C09265(this);
    /* renamed from: e */
    protected boolean f2379e = true;
    /* renamed from: j */
    private C1953c f2380j = null;
    /* renamed from: k */
    private ScreenListener f2381k = null;
    /* renamed from: l */
    private C1953c f2382l = null;
    /* renamed from: m */
    private C1953c f2383m = null;
    /* renamed from: n */
    private LaunchIntentHelper f2384n;
    /* renamed from: o */
    private Context f2385o = null;
    /* renamed from: p */
    private boolean f2386p = false;
    /* renamed from: q */
    private int f2387q = 0;
    /* renamed from: r */
    private Builder f2388r = null;
    /* renamed from: s */
    private NotificationManager f2389s = null;
    /* renamed from: t */
    private C0936j f2390t = null;
    /* renamed from: u */
    private C1011b f2391u;
    /* renamed from: v */
    private List<C0938b> f2392v = null;
    /* renamed from: w */
    private boolean f2393w = false;
    /* renamed from: x */
    private int f2394x = 0;
    /* renamed from: y */
    private long f2395y = 0;
    /* renamed from: z */
    private long f2396z = 0;

    /* renamed from: com.baidu.carlife.CarlifeActivity$1 */
    class C09181 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ CarlifeActivity f2335a;

        C09181(CarlifeActivity this$0) {
            this.f2335a = this$0;
        }

        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            BaiduNaviApplication.getInstance().exitApp(C1192c.m4069a().m4080d());
        }
    }

    /* renamed from: com.baidu.carlife.CarlifeActivity$2 */
    class C09212 implements C0920c {
        /* renamed from: a */
        final /* synthetic */ CarlifeActivity f2337a;

        /* renamed from: com.baidu.carlife.CarlifeActivity$2$1 */
        class C09191 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C09212 f2336a;

            C09191(C09212 this$1) {
                this.f2336a = this$1;
            }

            public void run() {
                C1912n.m7270a().m7307f();
            }
        }

        C09212(CarlifeActivity this$0) {
            this.f2337a = this$0;
        }

        /* renamed from: a */
        public boolean mo1339a(int keycode) {
            switch (keycode) {
                case 9:
                    C1261k.m4456a((int) C1253f.at, 0, 0, null);
                    return true;
                case 11:
                    C1261k.m4456a((int) C1253f.as, 0, 0, null);
                    return true;
                case 15:
                    if (C1912n.m7270a().m7313l()) {
                        C1260i.m4435b(CarlifeActivity.f2351c, "-----KEYCODE_SEEK_SUB-----VRShow return");
                        return true;
                    }
                    C1818h.m6730b().m6789a(false);
                    return true;
                case 16:
                    if (C1912n.m7270a().m7313l()) {
                        C1260i.m4435b(CarlifeActivity.f2351c, "-----KEYCODE_SEEK_ADD-----VRShow return");
                        return true;
                    }
                    C1818h.m6730b().m6789a(true);
                    return true;
                case 29:
                    C1261k.m4456a((int) C1253f.ar, 0, 0, null);
                    return true;
                case 30:
                    C1261k.m4456a((int) C1253f.aq, 0, 0, null);
                    return true;
                case 31:
                    if (C1912n.m7270a().m7313l()) {
                        C1260i.m4435b(CarlifeActivity.f2351c, "-----KEYCODE_MEDIA_START----- return");
                        return true;
                    }
                    C1818h.m6730b().m6769C();
                    return true;
                case 32:
                    C1260i.m4435b(C1818h.f5590a, "-----KEYCODE_MEDIA_STOP---pause(true)---");
                    C1818h.m6730b().m6770D();
                    return true;
                case 33:
                    new Handler(Looper.getMainLooper()).post(new C09191(this));
                    return true;
                case 34:
                    C1261k.m4461b(4160);
                    return true;
                default:
                    return false;
            }
        }
    }

    /* renamed from: com.baidu.carlife.CarlifeActivity$3 */
    class C09233 implements C0922a {
        /* renamed from: a */
        final /* synthetic */ CarlifeActivity f2338a;

        C09233(CarlifeActivity this$0) {
            this.f2338a = this$0;
        }

        /* renamed from: a */
        public void mo1340a() {
            C1260i.m4445e(CarlifeActivity.f2351c, "onScreenOn");
            C1212c command = new C1212c(true);
            command.m4201c(C1253f.al);
            C1663a.m5979a().m6017a(Message.obtain(null, command.m4202d(), 1001, 0, command));
        }

        /* renamed from: b */
        public void mo1341b() {
            C1260i.m4445e(CarlifeActivity.f2351c, "onScreenOff");
            if (!C1190a.m4065a()) {
                C1212c command = new C1212c(true);
                command.m4201c(C1253f.am);
                C1663a.m5979a().m6017a(Message.obtain(null, command.m4202d(), 1001, 0, command));
            }
        }

        /* renamed from: c */
        public void mo1342c() {
            C1260i.m4445e(CarlifeActivity.f2351c, "onUserPresent");
            C1212c command = new C1212c(true);
            command.m4201c(C1253f.an);
            C1663a.m5979a().m6017a(Message.obtain(null, command.m4202d(), 1001, 0, command));
        }
    }

    /* renamed from: com.baidu.carlife.CarlifeActivity$4 */
    class C09254 implements C0924a {
        /* renamed from: a */
        final /* synthetic */ CarlifeActivity f2339a;

        C09254(CarlifeActivity this$0) {
            this.f2339a = this$0;
        }

        public void onNetWorkResponse(int responseCode) {
            if (this.f2339a.b) {
                this.f2339a.m3043I();
            }
        }
    }

    /* renamed from: com.baidu.carlife.CarlifeActivity$5 */
    class C09265 implements BNDayNightChangedObserver {
        /* renamed from: a */
        final /* synthetic */ CarlifeActivity f2340a;

        C09265(CarlifeActivity this$0) {
            this.f2340a = this$0;
        }

        public void update(BNSubject o, int type, int event, Object arg) {
            if (type == 1) {
                switch (event) {
                    case 2:
                    case 4:
                    case 6:
                    case 8:
                    case 10:
                    case 12:
                        BNMapController.getInstance().setNightMode(false);
                        this.f2340a.m3104a(true);
                        return;
                    case 3:
                    case 5:
                    case 7:
                    case 9:
                    case 11:
                    case 13:
                        BNMapController.getInstance().setNightMode(true);
                        this.f2340a.m3104a(false);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.baidu.carlife.CarlifeActivity$6 */
    class C09276 implements ActionListener {
        /* renamed from: a */
        final /* synthetic */ CarlifeActivity f2341a;

        C09276(CarlifeActivity this$0) {
            this.f2341a = this$0;
        }

        public void onSuccess() {
            C1260i.m4435b(CarlifeActivity.f2352d, "Activity: create group owner success");
        }

        public void onFailure(int reason) {
            C1260i.m4435b(CarlifeActivity.f2352d, "Activity: create group owner failure");
        }
    }

    /* renamed from: com.baidu.carlife.CarlifeActivity$7 */
    class C09287 implements DnsSdServiceResponseListener {
        /* renamed from: a */
        final /* synthetic */ CarlifeActivity f2342a;

        C09287(CarlifeActivity this$0) {
            this.f2342a = this$0;
        }

        public void onDnsSdServiceAvailable(String instanceName, String registrationType, WifiP2pDevice srcDevice) {
            C1260i.m4435b(CarlifeActivity.f2352d, "Activity: p2p Service Available : " + instanceName);
            if (instanceName.equalsIgnoreCase("_ClfWfd")) {
                C1260i.m4435b(CarlifeActivity.f2352d, "Activity: onDnsSdServiceAvailable");
                if (this.f2342a.f2370N == null) {
                    this.f2342a.f2370N = new WifiP2pDevice();
                }
                this.f2342a.f2370N = srcDevice;
            }
        }
    }

    /* renamed from: com.baidu.carlife.CarlifeActivity$8 */
    class C09298 implements DnsSdTxtRecordListener {
        /* renamed from: a */
        final /* synthetic */ CarlifeActivity f2343a;

        C09298(CarlifeActivity this$0) {
            this.f2343a = this$0;
        }

        public void onDnsSdTxtRecordAvailable(String fullDomainName, Map<String, String> record, WifiP2pDevice device) {
            C1260i.m4435b(CarlifeActivity.f2352d, "Activity: --------------------- onDnsSdTxtRecordAvailable");
            C1260i.m4435b(CarlifeActivity.f2352d, device.deviceName + " is " + ((String) record.get("available")));
        }
    }

    /* renamed from: com.baidu.carlife.CarlifeActivity$9 */
    class C09309 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ CarlifeActivity f2344a;

        C09309(CarlifeActivity this$0) {
            this.f2344a = this$0;
        }

        public void run() {
            ContentFragment fragment = this.f2344a.f2363G.getCurrentFragment();
            C1260i.m4435b(CarlifeActivity.f2351c, "CurrentFragment = " + fragment.getClass().toString());
            if (C1440d.m5251a().m5269h() && fragment != null) {
                fragment.onInitFocusAreas();
            }
        }
    }

    /* renamed from: com.baidu.carlife.CarlifeActivity$a */
    private class C0937a extends C0936j {
        /* renamed from: a */
        final /* synthetic */ CarlifeActivity f2350a;

        /* renamed from: com.baidu.carlife.CarlifeActivity$a$1 */
        class C09311 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C0937a f2345a;

            C09311(C0937a this$1) {
                this.f2345a = this$1;
            }

            public void run() {
                StatisticManager.onEvent(StatisticConstants.HOME_PHONE_BT_CONNECT, "1058_" + C1058f.m3470a().m3533k());
            }
        }

        /* renamed from: com.baidu.carlife.CarlifeActivity$a$2 */
        class C09322 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C0937a f2346a;

            C09322(C0937a this$1) {
                this.f2346a = this$1;
            }

            public void run() {
                C1251e.m4384v();
            }
        }

        /* renamed from: com.baidu.carlife.CarlifeActivity$a$3 */
        class C09333 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C0937a f2347a;

            C09333(C0937a this$1) {
                this.f2347a = this$1;
            }

            public void run() {
                C1772k.m6480a().m6487b();
            }
        }

        /* renamed from: com.baidu.carlife.CarlifeActivity$a$4 */
        class C09344 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C0937a f2348a;

            C09344(C0937a this$1) {
                this.f2348a = this$1;
            }

            public void run() {
                C1663a.m5979a().m5994O();
            }
        }

        /* renamed from: com.baidu.carlife.CarlifeActivity$a$5 */
        class C09355 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C0937a f2349a;

            C09355(C0937a this$1) {
                this.f2349a = this$1;
            }

            public void run() {
                C1440d.m5251a().m5271j();
            }
        }

        public C0937a(CarlifeActivity carlifeActivity, Looper looper) {
            this.f2350a = carlifeActivity;
            super(looper);
        }

        public void handleMessage(Message msg) {
            try {
                C1260i.m4440c(CarlifeActivity.f2351c, "handleMessage=" + msg.what);
                boolean isLaunchInit = C1192c.m4069a().m4082e();
                switch (msg.what) {
                    case 408:
                        C1818h.m6730b().m6773G();
                        return;
                    case C1253f.ex /*427*/:
                        this.f2350a.f2364H.m4718a((Drawable) msg.obj);
                        return;
                    case C1253f.ey /*428*/:
                        this.f2350a.f2364H.m4716a((int) C0965R.drawable.com_bg);
                        return;
                    case 1002:
                        C1260i.m4445e(CarlifeActivity.f2351c, "---------CONNECT_STATUS_DISCONNECTED---------");
                        C1251e.m4360b(-1);
                        C2252a.m8531a().m8563a(false);
                        C1261k.m4452a((int) C1253f.fm);
                        if (C1249d.m4331a().m4340b() == C1248a.W_16_H_9 || C1249d.m4334m()) {
                            this.f2350a.m3060b(C1249d.m4331a().m4348e(), C1249d.m4331a().m4345d());
                            this.f2350a.m3094y();
                            C1249d.m4331a().m4349f();
                        }
                        StatisticManager.onEventDuration(C1157a.m3876a(), StatisticConstants.COMMON_0006, StatisticConstants.COMMON_0006_LABEL, (int) (System.currentTimeMillis() - this.f2350a.f2396z));
                        C1342a.m4926a().m4930c();
                        C1343b.m4932a().m4936c();
                        C1251e.m4361b(null);
                        C2252a.m8531a().m8567d();
                        C1663a.m5979a().m6034e(false);
                        C1765g.m6424a().m6440b(false);
                        C1663a.m5979a().m5992M();
                        C1765g.m6424a().m6444e();
                        this.f2350a.m3041G();
                        if (!this.f2350a.f2376T) {
                            C1260i.m4435b(CarlifeActivity.f2351c, "!firstGpsComing disconnected start");
                            MainMapModel.getInstance().bFirstLoc = true;
                            if (BCruiser.getInstance().isCruiseBegin()) {
                                C1609a.m5871a().m5879b(false);
                                BCruiser.getInstance().reInitLocationService();
                            }
                            if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
                                C1609a.m5871a().m5879b(false);
                                BaiduNaviSDKManager.getInstance().reInitCruiseLocationService();
                            }
                            if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
                                BaiduNaviSDKManager.getInstance().reInitNaviLocationService(1);
                            }
                            C1609a.m5871a().m5879b(false);
                            C1609a.m5871a().m5878a(false);
                            EnterQuitLogicManager.getmInstance().reInitLocationService();
                            BaiduNaviSDKManager.getInstance().reInitTrackLocationService();
                            LocationManager.getInstance().onResume();
                            this.f2350a.f2376T = true;
                            C1260i.m4435b(CarlifeActivity.f2351c, "!firstGpsComing disconnected end");
                        }
                        C1609a.m5871a().m5878a(false);
                        this.f2350a.m3055a(this.f2350a.f2385o.getString(C0965R.string.usb_toast_disconnected));
                        C1663a.m5979a().m5996Q();
                        C1915a.m7321a().m7327a(false);
                        this.f2350a.m3105b(1002);
                        C1253f.jv = true;
                        C1261k.m4461b(3008);
                        C1268a.m4481b().m4486a(4200, false, 0);
                        C1268a.m4481b().m4496e(false);
                        C1268a.m4481b().m4490b(4201);
                        C1268a.m4481b().m4490b(4202);
                        C1772k.m6480a().m6485a(6, 0);
                        C2195t.m8344a();
                        if (!C1192c.m4069a().m4088h()) {
                            C1262l.m4465a().postDelayed(new C09322(this), 2000);
                        }
                        C1192c.m4069a().m4081e(false);
                        C1192c.m4069a().m4083f(false);
                        this.f2350a.f2364H.mo1479a(false);
                        C1268a.m4481b().m4503k();
                        C2191s.m8343a(true, true, false, false);
                        C2191s.f7020n = false;
                        C2191s.m8340a(null);
                        if (this.f2350a.f2391u != null) {
                            this.f2350a.f2391u.mo1377a();
                        }
                        C1251e.m4364c("");
                        C1251e.m4368d("");
                        if (!BNavigator.getInstance().isNaviBegin()) {
                            TrackCarDataSolveModel.setCarlifeStatisticsInfo(null);
                        }
                        C1192c.m4069a().m4087h(false);
                        C1612a.m5884a().m5893b(false);
                        C1029a.m3268a().m3274c();
                        if (this.f2350a.f2375S) {
                            this.f2350a.f2375S = false;
                            this.f2350a.m3034B();
                        }
                        this.f2350a.m3032A();
                        C1774l.m6498c().m6507a(this.f2350a.f2390t);
                        C2103a.m7880a().m7887a(this.f2350a.f2385o);
                        C1663a.m5979a().m6002W();
                        C2716c.m10146a(C1253f.jx.m4403a());
                        return;
                    case 1003:
                        C1260i.m4445e(CarlifeActivity.f2351c, "---------CONNECT_STATUS_CONNECTING---------");
                        C1663a.m5979a().m6034e(false);
                        this.f2350a.m3041G();
                        this.f2350a.sendBroadcast(new Intent(C1253f.ft));
                        C1261k.m4461b(3008);
                        if (!this.f2350a.f2393w) {
                            StatisticManager.onEventStart(this.f2350a.f2385o, StatisticConstants.HU_CONNECT_MOBILE_AVG_TIME, "HU_CONNECT_MOBILE_AVG_TIME");
                            this.f2350a.f2393w = true;
                            return;
                        }
                        return;
                    case 1004:
                        this.f2350a.f2396z = System.currentTimeMillis();
                        NavTrajectoryController.hasConnected = true;
                        this.f2350a.m3095z();
                        this.f2350a.m3117m();
                        C1260i.m4445e(CarlifeActivity.f2351c, "---------CONNECT_STATUS_CONNECTED---------");
                        this.f2350a.m3055a(this.f2350a.f2385o.getString(C0965R.string.usb_toast_connected));
                        C1663a.m5979a().m5995P();
                        UsbStateReceiver.m3857a().m3871d();
                        this.f2350a.m3105b(1004);
                        C1253f.jv = false;
                        C1261k.m4461b((int) C1253f.gN);
                        if (this.f2350a.f2393w) {
                            this.f2350a.f2393w = false;
                            StatisticManager.onEventEnd(this.f2350a.f2385o, StatisticConstants.HU_CONNECT_MOBILE_AVG_TIME, "HU_CONNECT_MOBILE_AVG_TIME");
                        }
                        StatisticManager.onEvent(StatisticConstants.COMMON_002);
                        StatisticManager.onEvent(StatisticConstants.HU_CONNECT_MOBILE, StatisticConstants.HU_CONNECT_MOBILE);
                        C2191s.f7019m = System.currentTimeMillis();
                        C2191s.f7020n = true;
                        C1262l.m4465a().postDelayed(new C09311(this), 60000);
                        C1774l.m6498c().m6510d();
                        C2103a.m7880a().m7888c();
                        return;
                    case 1007:
                        if (C1765g.m6424a().m6442c()) {
                            this.f2350a.f2375S = true;
                            this.f2350a.m3034B();
                            this.f2350a.f2390t.postDelayed(new C09355(this), 500);
                            return;
                        }
                        return;
                    case 1009:
                        C1155a.m3873b();
                        return;
                    case C1253f.fj /*1037*/:
                        if (msg.obj != null) {
                            this.f2350a.m3055a(msg.obj.toString());
                            return;
                        }
                        return;
                    case C1253f.fl /*1039*/:
                        this.f2350a.m3055a(this.f2350a.getString(C0965R.string.bdim_error));
                        return;
                    case C1253f.fm /*1040*/:
                        if (this.f2350a.f2391u != null) {
                            this.f2350a.f2391u.mo1377a();
                        }
                        if (C1249d.m4334m()) {
                            C1260i.m4435b(CarlifeActivity.f2351c, "before adaptScreen: [" + ScreenUtil.getInstance().getWidthPixels() + Config.TRACE_TODAY_VISIT_SPLIT + ScreenUtil.getInstance().getHeightPixels());
                            int height = ScreenUtil.getInstance().getWidthPixels();
                            this.f2350a.m3060b(height, (int) (((double) height) * C1249d.m4331a().m4340b().m4330a()));
                            this.f2350a.m3094y();
                            return;
                        }
                        return;
                    case C1253f.fn /*1060*/:
                        ArrayList<SearchPoi> data = msg.obj;
                        Bundle bundle = new Bundle();
                        bundle.putInt(ContentFragmentManager.MODULE_FROM, 1);
                        bundle.putSerializable("poi_data", data);
                        this.f2350a.f2364H.openNaviFromOutSide(35, bundle);
                        return;
                    case C1253f.fp /*1070*/:
                        this.f2350a.m3124t();
                        return;
                    case C1253f.fq /*1071*/:
                        this.f2350a.m3045K();
                        this.f2350a.m3046L();
                        return;
                    case C1253f.fr /*1072*/:
                        C1260i.m4435b(CarlifeActivity.f2351c, "-------MSG_PUSH_MESSSAGE_SHOW: " + msg.obj);
                        C1155a.m3874c();
                        return;
                    case 2004:
                        if (!C1047b.m3397a().f2738z) {
                            this.f2350a.f2364H.mo1479a(false);
                            if (!this.f2350a.f2357A) {
                                C1268a.m4481b().m4504l();
                            }
                            C1268a.m4481b().m4502j();
                            return;
                        }
                        return;
                    case C1253f.gL /*4007*/:
                        if (isLaunchInit) {
                            C1261k.m4461b(3007);
                            return;
                        } else {
                            sendEmptyMessageDelayed(C1253f.gL, 200);
                            return;
                        }
                    case C1253f.gN /*4010*/:
                        if (isLaunchInit) {
                            C1260i.m4435b(CarlifeActivity.f2351c, "MSG_MAIN_CHANGE_CONNECT_BUTTON 1");
                            C1261k.m4456a(3008, 0, 0, null);
                            return;
                        }
                        C1260i.m4435b(CarlifeActivity.f2351c, "MSG_MAIN_CHANGE_CONNECT_BUTTON 2");
                        C1261k.m4457a(C1253f.gN, 0, 0, null, 200);
                        return;
                    case C1253f.gP /*4013*/:
                        String packageName = msg.obj;
                        if (!TextUtils.isEmpty(packageName)) {
                            C1790b dataManager = C1818h.m6730b().m6792b(packageName);
                            if (dataManager == null) {
                                this.f2350a.m3055a(this.f2350a.getResources().getString(C0965R.string.module_music_toast_thirdparty_connectrefuse));
                                return;
                            } else if (C2186p.m8304a().m8312a(C1253f.ih, true)) {
                                C1260i.m4435b("ouyang", "-MSG_MAIN_THIRDPARTY_CONNECT--UserGuiding--");
                                sendMessageDelayed(Message.obtain(msg), 500);
                                return;
                            } else if (dataManager != null && isLaunchInit) {
                                C1818h.m6730b().m6822l(dataManager.m6649s());
                                ContentFragment curFrag = this.f2350a.f2363G.getCurrentFragment();
                                if (curFrag != null) {
                                    if (this.f2350a.m3040F() == NaviFragmentManager.TYPE_MUSIC_ALBUMLIST) {
                                        curFrag.onStart();
                                    } else {
                                        this.f2350a.f2363G.showFragment(NaviFragmentManager.TYPE_MUSIC_ALBUMLIST, null);
                                    }
                                    List<C1929i> list = dataManager.m6648r();
                                    if (list == null || list.isEmpty()) {
                                        dataManager.m6637j();
                                    }
                                    this.f2350a.f2394x = 0;
                                    C1260i.m4435b("ouyang", "-MSG_MAIN_THIRDPARTY_CONNECT--OK--");
                                    return;
                                }
                                return;
                            } else if (this.f2350a.f2394x < 10) {
                                C1260i.m4435b("ouyang", "-MSG_MAIN_THIRDPARTY_CONNECT--NetWork_Unreturn--");
                                this.f2350a.m3055a(this.f2350a.getResources().getString(C0965R.string.module_music_toast_thirdparty_connecting));
                                sendMessageDelayed(Message.obtain(msg), 500);
                                this.f2350a.f2394x = this.f2350a.f2394x + 1;
                                return;
                            } else {
                                C1260i.m4435b("ouyang", "-MSG_MAIN_THIRDPARTY_CONNECT--NetWork_FailReturn--");
                                this.f2350a.f2394x = 0;
                                this.f2350a.m3055a(this.f2350a.getResources().getString(C0965R.string.module_music_toast_thirdparty_connectfail));
                                return;
                            }
                        }
                        return;
                    case C1253f.gV /*4027*/:
                        if (C1663a.m5979a().m5993N()) {
                            C1268a.m4481b().m4502j();
                            this.f2350a.m3089w();
                            return;
                        }
                        return;
                    case C1253f.gW /*4028*/:
                        if (this.f2350a.f2383m != null) {
                            this.f2350a.f2364H.dismissDialog(this.f2350a.f2383m);
                            return;
                        }
                        return;
                    case C1253f.hx /*4251*/:
                        if (C1663a.m5979a().m5993N()) {
                            C1192c.m4069a().m4081e(true);
                            this.f2350a.f2364H.mo1480b();
                            if (this.f2350a.f2357A) {
                                C1192c.m4069a().m4083f(true);
                                return;
                            }
                            return;
                        }
                        return;
                    case C1253f.hC /*4303*/:
                        int prevState = msg.arg1;
                        int currState = msg.arg2;
                        if (prevState == currState) {
                            return;
                        }
                        if (currState == 0) {
                            C1192c.m4069a().m4087h(false);
                            return;
                        } else if (currState == 2 && this.f2350a.f2364H.isDialogShown()) {
                            this.f2350a.f2364H.dismissDialog();
                            return;
                        } else {
                            return;
                        }
                    case C1253f.jd /*52480*/:
                        StatisticManager.onEvent(StatisticConstants.EVENT_CONNECT_OTHER_APP);
                        C1260i.m4435b(CarlifeActivity.f2351c, "---------   MSG_PORT_ESTABLISH ---------");
                        return;
                    case C1253f.f3543J /*65640*/:
                        try {
                            CarlifeDeviceVersionInfo proto = CarlifeDeviceVersionInfo.parseFrom(msg.obj.m4205f());
                            C1371b.m4996a().m5009a(proto.getDeviceName().trim(), proto.getVersionCode().trim());
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    case C1253f.f3535B /*98305*/:
                        try {
                            C1757d.m6389a().m6390a(CarlifeProtocolVersion.parseFrom(msg.obj.m4205f()));
                            C1757d.m6389a().m6395f();
                            C1757d.m6389a().m6397h();
                            int matchStatus = C1757d.m6389a().m6396g().getMatchStatus();
                            C1260i.m4445e(CarlifeActivity.f2351c, "Protocol Version Match Version: " + matchStatus);
                            if (matchStatus == 1) {
                                C2195t.m8345a(this.f2350a, this.f2350a.f2364H);
                                C1663a.m5979a().m6034e(true);
                                C1747c.m6337a().m6342e();
                                postDelayed(new C09333(this), 500);
                                if (C1818h.m6730b().m6828p()) {
                                    C1261k.m4461b(407);
                                }
                                C1915a.m7321a().m7327a(true);
                                C1268a.m4481b().m4496e(true);
                                C1268a.m4481b().m4486a(4201, true, 10000);
                                this.f2350a.m3037C();
                                C1912n.m7270a().m7319r();
                                C1371b.m4999b();
                                return;
                            }
                            C1663a.m5979a().m6034e(false);
                            C1262l.m4465a().postDelayed(new C09344(this), 500);
                            return;
                        } catch (InvalidProtocolBufferException e2) {
                            C1260i.m4445e(CarlifeActivity.f2351c, "Get Car Protocol Version Info Error");
                            e2.printStackTrace();
                            return;
                        }
                    case C1253f.f3537D /*98307*/:
                        try {
                            CarlifeDeviceInfo info = CarlifeDeviceInfo.parseFrom(msg.obj.m4205f());
                            C1747c.m6337a().m6338a(info);
                            C1260i.m4435b(CarlifeActivity.f2351c, info.toString());
                            if (info.getDevice().equals("iRTOS")) {
                                C1663a.m5979a().m6015a(true);
                                return;
                            }
                            return;
                        } catch (Exception ex) {
                            C1260i.m4445e(CarlifeActivity.f2351c, "get hu info error");
                            ex.printStackTrace();
                            return;
                        }
                    case C1253f.ab /*98319*/:
                        this.f2350a.m3061b(msg);
                        return;
                    case C1253f.ac /*98320*/:
                        this.f2350a.m3051a(msg);
                        return;
                    case C1253f.aq /*98333*/:
                        if (isLaunchInit) {
                            C1261k.m4456a(4001, (int) C1253f.iy, 0, null);
                            return;
                        } else {
                            C1261k.m4457a(C1253f.aq, 0, 0, null, 200);
                            return;
                        }
                    case C1253f.ar /*98334*/:
                        if (C1192c.m4069a().m4082e()) {
                            C1261k.m4456a(4002, 0, 0, null);
                            return;
                        } else {
                            C1261k.m4457a(C1253f.ar, 0, 0, null, 200);
                            return;
                        }
                    case C1253f.as /*98335*/:
                        if (C1192c.m4069a().m4082e()) {
                            C1261k.m4456a(4003, 0, 0, null);
                            return;
                        } else {
                            C1261k.m4457a(C1253f.as, 0, 0, null, 200);
                            return;
                        }
                    case C1253f.at /*98336*/:
                        if (C1192c.m4069a().m4082e()) {
                            C1260i.m4435b(CarlifeActivity.f2351c, "MSG_CMD_LAUNCH_MODE_MUSIC 1");
                            C1261k.m4456a(4004, 0, 0, null);
                            return;
                        }
                        C1260i.m4435b(CarlifeActivity.f2351c, "MSG_CMD_LAUNCH_MODE_MUSIC 2");
                        C1261k.m4457a(C1253f.at, 0, 0, null, 200);
                        return;
                    case C1253f.ay /*98341*/:
                        this.f2350a.m3116l();
                        return;
                    case C1253f.aA /*98343*/:
                        C2195t.m8344a();
                        CarlifeStatisticsInfo statisInfo = null;
                        try {
                            statisInfo = CarlifeStatisticsInfo.parseFrom(msg.obj.m4205f());
                            C1260i.m4435b(CarlifeActivity.f2351c, "Vehicle CUID = " + statisInfo.getCuid());
                            C1260i.m4435b(CarlifeActivity.f2351c, "Vehicle versionName = " + statisInfo.getVersionName());
                            C1260i.m4435b(CarlifeActivity.f2351c, "Vehicle versionCode = " + statisInfo.getVersionCode());
                            C1260i.m4435b(CarlifeActivity.f2351c, "Vehicle Channel = " + statisInfo.getChannel());
                            C1260i.m4435b(CarlifeActivity.f2351c, "Vehicle Connect Count = " + statisInfo.getConnectCount());
                            C1260i.m4435b(CarlifeActivity.f2351c, "Vehicle Connect Success Count = " + statisInfo.getConnectSuccessCount());
                            C1260i.m4435b(CarlifeActivity.f2351c, "Vehicle Connect Time = " + statisInfo.getConnectTime());
                            C1260i.m4435b(CarlifeActivity.f2351c, "Vehicle Crash Log = " + statisInfo.getCrashLog());
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        boolean checkResult = C2204x.m8381a(this.f2350a, statisInfo.getChannel(), this.f2350a.f2364H);
                        C1251e.m4361b(statisInfo.getChannel());
                        C1251e.m4364c(statisInfo.getCuid());
                        C1251e.m4368d(statisInfo.getVersionName());
                        TrackCarDataSolveModel.setCarlifeStatisticsInfo(statisInfo);
                        C2186p.m8304a().m8319b(C1253f.jA, statisInfo.getChannel());
                        C1155a.m3872a();
                        boolean checkSign = C2187q.m8327a(this.f2350a.f2385o, this.f2350a.f2364H);
                        C0967a a = C0967a.m3157a();
                        boolean z = checkResult && checkSign;
                        a.m3163a(z);
                        this.f2350a.m3042H();
                        C2191s.m8340a(statisInfo);
                        C2195t.m8347a(statisInfo);
                        sendEmptyMessage(C1253f.gL);
                        C1043a.m3360a().m3382d();
                        C1765g.m6424a().m6439b();
                        C2716c.m10146a(C1253f.jx.m4403a());
                        C1029a.m3268a().m3273b();
                        return;
                    case C1253f.aB /*98344*/:
                        C1212c carlifeModelueStateM = msg.obj;
                        if (carlifeModelueStateM != null) {
                            try {
                                CarlifeModuleStatus carlifeModuleStatus = CarlifeModuleStatus.parseFrom(carlifeModelueStateM.m4205f());
                                if (carlifeModuleStatus != null) {
                                    int moduleId = carlifeModuleStatus.getModuleID();
                                    int statusId = carlifeModuleStatus.getStatusID();
                                    C1260i.m4440c(CarlifeActivity.f2351c, "moduleId=" + moduleId + ",statusId=" + statusId);
                                    switch (moduleId) {
                                        case 1:
                                            if (statusId != 0) {
                                                C1261k.m4456a((int) C1253f.fS, 0, 0, null);
                                                return;
                                            } else {
                                                C1261k.m4456a((int) C1253f.fT, 0, 0, null);
                                                return;
                                            }
                                        case 2:
                                            if (statusId == 0) {
                                                if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
                                                    BaiduNaviSDKManager.getInstance().quitNavi();
                                                }
                                                CarlifeProtocolVersion version = C1757d.m6389a().m6393d();
                                                if (version != null && version.getMajorVersion() == 1) {
                                                    if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
                                                        BaiduNaviSDKManager.getInstance().quitCruise();
                                                    }
                                                    if (BCruiser.getInstance().isCruiseBegin()) {
                                                        EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        case 3:
                                            if (statusId == 1) {
                                                C1818h.m6730b().m6769C();
                                                return;
                                            } else if (statusId == 0) {
                                                C1260i.m4435b(C1818h.f5590a, "-----MSG_CMD_MODULE_CONTROL---pause(true)---");
                                                C1818h.m6730b().m6770D();
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 4:
                                            if (statusId == 1) {
                                                C1912n.m7270a().m7307f();
                                                return;
                                            } else if (statusId == 0) {
                                                C1912n.m7270a().m7311j();
                                                return;
                                            } else if (statusId == 2) {
                                                C1772k.m6480a().m6485a(6, 2);
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 6:
                                            C1772k.m6480a().m6485a(6, statusId);
                                            C1912n.m7270a().m7319r();
                                            return;
                                        case 8:
                                            if (statusId == 0 && BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
                                                BaiduNaviSDKManager.getInstance().quitCruise();
                                                return;
                                            }
                                            return;
                                        case 9:
                                            if (statusId == 0 && BCruiser.getInstance().isCruiseBegin()) {
                                                EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                    e2.printStackTrace();
                                    return;
                                }
                                return;
                            } catch (InvalidProtocolBufferException e22) {
                                e22.printStackTrace();
                                return;
                            }
                        }
                        return;
                    case C1253f.je /*98345*/:
                        C1260i.m4435b(CarlifeActivity.f2351c, "---------MSG_CMD_CAR_DATA_GEAR---------");
                        if (C1342a.m4926a().m4929b()) {
                            C1260i.m4435b(CarlifeActivity.f2351c, "---------VEHICLE_CHANNEL_GUANGFENG_LEVIN---------");
                            C1342a.m4926a().m4927a(msg);
                            return;
                        } else if (C1343b.m4932a().m4935b()) {
                            C1260i.m4435b(CarlifeActivity.f2351c, "---------VEHICLE_CHANNEL_YIQIFENGTIAN_COROLLA---------");
                            C1343b.m4932a().m4933a(msg);
                            return;
                        } else {
                            return;
                        }
                    case C1253f.f3558Y /*98354*/:
                        C1029a.m3268a().m3272a(CarlifeVehicleInfoList.parseFrom(msg.obj.m4205f()));
                        return;
                    case C1253f.aJ /*98370*/:
                        try {
                            if (CarlifeBTHfpConnection.parseFrom(msg.obj.m4205f()).getState() != 2 && C1253f.jx == C1252a.VEHICLE_CHANNEL_BYD && !this.f2350a.f2359C) {
                                this.f2350a.f2359C = true;
                                this.f2350a.m3055a(this.f2350a.getString(C0965R.string.tip_bt_connect));
                                return;
                            }
                            return;
                        } catch (InvalidProtocolBufferException e222) {
                            e222.printStackTrace();
                            return;
                        }
                    case C1253f.aK /*98371*/:
                        if (msg.obj != null) {
                            C1029a.m3270a(msg.obj);
                            return;
                        }
                        return;
                    case C1253f.aM /*98373*/:
                        if (msg.obj != null) {
                            C1029a.m3271a(msg.obj, true);
                            return;
                        }
                        return;
                    case C1253f.aN /*98374*/:
                        if (msg.obj != null) {
                            C1029a.m3271a(msg.obj, false);
                            return;
                        }
                        return;
                    case C1253f.aP /*98376*/:
                        try {
                            CarlifeAuthenRequest authenRequest = CarlifeAuthenRequest.parseFrom(msg.obj.m4205f());
                            C1260i.m4435b(CarlifeActivity.f2351c, "MSG_CMD_HU_AUTHEN_REQUEST= " + authenRequest.getRandomValue());
                            C0967a.m3157a().m3162a(authenRequest.getRandomValue());
                            return;
                        } catch (Exception e32) {
                            e32.printStackTrace();
                            return;
                        }
                    case C1253f.aR /*98378*/:
                        try {
                            if (CarlifeAuthenResult.parseFrom(msg.obj.m4205f()).getAuthenResult()) {
                                C1260i.m4445e(CarlifeActivity.f2351c, "MSG_CMD_HU_AUTHEN_RESULT= true");
                                return;
                            } else {
                                C1260i.m4445e(CarlifeActivity.f2351c, "MSG_CMD_HU_AUTHEN_RESULT= false");
                                return;
                            }
                        } catch (Exception e322) {
                            e322.printStackTrace();
                            return;
                        }
                    case C1253f.bb /*98389*/:
                        C1260i.m4429a(CarlifeActivity.f2351c, "MSG_CMD_ERROR_CODE");
                        try {
                            CarlifeErrorCode errorId = CarlifeErrorCode.parseFrom(msg.obj.m4205f());
                            C1260i.m4429a(CarlifeActivity.f2351c, "error Code = " + errorId.getErrorCode());
                            C2191s.m8341a(errorId.getErrorCode(), this.f2350a.f2362F);
                            this.f2350a.f2362F = true;
                            return;
                        } catch (Exception e3222) {
                            e3222.printStackTrace();
                            return;
                        }
                    case C1253f.bg /*98400*/:
                        int i;
                        C1212c connstatisInfoMsg = msg.obj;
                        CarlifeConnectStatistics con_statisticInfo = null;
                        C1260i.m4435b(CarlifeActivity.f2351c, "---------   wince connect statistic ---------");
                        try {
                            con_statisticInfo = CarlifeConnectStatistics.parseFrom(connstatisInfoMsg.m4205f());
                            C1260i.m4435b(CarlifeActivity.f2351c, "Connect Total = " + con_statisticInfo.getContotal());
                            C1260i.m4435b(CarlifeActivity.f2351c, "Connect Success = " + con_statisticInfo.getConsuccess());
                            C1260i.m4435b(CarlifeActivity.f2351c, "Connect Failed = " + con_statisticInfo.getConfailed());
                            C1260i.m4435b(CarlifeActivity.f2351c, "Connect Time = " + con_statisticInfo.getContime());
                            C1260i.m4435b(CarlifeActivity.f2351c, "Connect errorcount = " + con_statisticInfo.getNerrorcount());
                            C1260i.m4435b(CarlifeActivity.f2351c, "Connect ErrorTypeCount = " + con_statisticInfo.getErrorTypeCount());
                        } catch (Exception e32222) {
                            e32222.printStackTrace();
                        }
                        if (con_statisticInfo.getContotal() <= 100) {
                            for (i = 0; i < con_statisticInfo.getContotal(); i++) {
                                StatisticManager.onEvent(StatisticConstants.EVENT_CONNECT_COUNT);
                            }
                        }
                        StatisticManager.onEvent("CONNECT_0002");
                        if (con_statisticInfo.getConfailed() <= 100) {
                            for (i = 0; i < con_statisticInfo.getConfailed(); i++) {
                                StatisticManager.onEvent(StatisticConstants.EVENT_CONNECT_FAILED);
                            }
                        }
                        StatisticManager.onEventDuration(C1157a.m3876a(), StatisticConstants.EVENT_CONNECT_TIME, StatisticConstants.EVENT_CONNECT_TIME, con_statisticInfo.getContime());
                        if (con_statisticInfo.getNerrorcount() <= 100) {
                            i = 0;
                            while (i < con_statisticInfo.getNerrorcount() && i < con_statisticInfo.getErrorTypeCount()) {
                                StatisticManager.onEvent(StatisticConstants.EVENT_CONNECT_ERROR, con_statisticInfo.getErrorType(i));
                                i++;
                            }
                            return;
                        }
                        return;
                    case C1253f.bE /*425985*/:
                        C1212c carlifeTouchMsg = msg.obj;
                        if (carlifeTouchMsg != null) {
                            try {
                                CarlifeTouchAction touchAction = CarlifeTouchAction.parseFrom(carlifeTouchMsg.m4205f());
                                if (C1663a.m5979a().m6048o() > 0 && C1663a.m5979a().m6049p() > 0) {
                                    int tx = (touchAction.getX() * C1663a.m5979a().m6050q()) / C1663a.m5979a().m6048o();
                                    int ty = (touchAction.getY() * C1663a.m5979a().m6051r()) / C1663a.m5979a().m6049p();
                                    C1260i.m4435b(CarlifeActivity.f2351c, "MSG_CMD_TOUCH_ACTION: " + ("x = " + tx + ", y = " + ty + ", action = " + touchAction.getAction()));
                                    long time = SystemClock.uptimeMillis();
                                    this.f2350a.dispatchTouchEvent(MotionEvent.obtain(time, time, touchAction.getAction(), (float) tx, (float) ty, 0));
                                    return;
                                }
                                return;
                            } catch (InvalidProtocolBufferException e2222) {
                                C1260i.m4445e(CarlifeActivity.f2351c, "MSG_CMD_TOUCH_ACTION Error");
                                e2222.printStackTrace();
                                return;
                            }
                        }
                        C1260i.m4445e(CarlifeActivity.f2351c, "MSG_CMD_TOUCH_ACTION CarlifeCmdMessage is null");
                        return;
                    case C1253f.f3534A /*2147418113*/:
                        C1260i.m4426a().m4450d();
                        return;
                    default:
                        return;
                }
            } catch (Exception ex2) {
                C1260i.m4445e(CarlifeActivity.f2351c, "handle message exception");
                ex2.printStackTrace();
            }
            C1260i.m4445e(CarlifeActivity.f2351c, "handle message exception");
            ex2.printStackTrace();
        }

        public void careAbout() {
            addMsg(1004);
            addMsg(1003);
            addMsg(1002);
            addMsg(1009);
            addMsg(C1253f.gV);
            addMsg(C1253f.gW);
            addMsg(C1253f.gN);
            addMsg(C1253f.aq);
            addMsg(C1253f.ar);
            addMsg(C1253f.as);
            addMsg(C1253f.at);
            addMsg(C1253f.f3536C);
            addMsg(C1253f.f3535B);
            addMsg(C1253f.f3537D);
            addMsg(C1253f.ac);
            addMsg(C1253f.ab);
            addMsg(C1253f.ay);
            addMsg(C1253f.f3539F);
            addMsg(C1253f.aA);
            addMsg(C1253f.aB);
            addMsg(C1253f.fj);
            addMsg(C1253f.fl);
            addMsg(C1253f.fn);
            addMsg(C1253f.hx);
            addMsg(C1253f.f3549P);
            addMsg(C1253f.fm);
            addMsg(C1253f.aJ);
            addMsg(2004);
            addMsg(C1253f.bb);
            addMsg(C1253f.aP);
            addMsg(C1253f.aR);
            addMsg(C1253f.f3534A);
            addMsg(C1253f.hC);
            addMsg(1007);
            addMsg(C1253f.f3558Y);
            addMsg(C1253f.bg);
            addMsg(C1253f.aK);
            addMsg(C1253f.aM);
            addMsg(C1253f.aN);
            addMsg(C1253f.jd);
            addMsg(C1253f.je);
            addMsg(C1253f.f3543J);
            addMsg(C1253f.fp);
            addMsg(C1253f.fq);
            addMsg(C1253f.ex);
            addMsg(C1253f.ey);
            addMsg(C1253f.fr);
        }
    }

    /* renamed from: com.baidu.carlife.CarlifeActivity$b */
    public interface C0938b {
        /* renamed from: a */
        boolean m3025a(int i, KeyEvent keyEvent);
    }

    protected void onCreate(Bundle savedInstanceState) {
        C1663a.m5979a().m5999T();
        C1260i.m4435b(f2351c, "onCreate");
        this.f2395y = System.currentTimeMillis();
        C1260i.m4428a(f2351c);
        getWindow().addFlags(128);
        getWindow().addFlags(1024);
        requestWindowFeature(1);
        C1328h.m4758a(new NaviFragmentManager(this));
        super.onCreate(savedInstanceState);
        this.f2363G = C1328h.m4757a();
        this.f2385o = this;
        this.f2390t = new C0937a(this, getMainLooper());
        C1261k.m4460a(this.f2390t);
        BaseFragment.initBeforeAll(this);
        this.f2364H = new C1319h(this);
        setContentView(this.f2364H.m4695g());
        this.f2364H.m4717a(514, null);
        this.f2364H.m4719a(getWindow());
        m3091x();
        this.f2384n = new LaunchIntentHelper(this, getIntent(), this.f2364H);
        try {
            if (C1253f.fx.equals(getIntent().getAction())) {
                C1260i.m4435b(f2351c, "USB Accessory attached onCreate");
                C1663a.m5979a().m6010a((Context) this, (UsbAccessory) getIntent().getParcelableExtra("accessory"));
            }
        } catch (Exception ex) {
            C1260i.m4435b(f2351c, "start usb accessory attached fail");
            ex.printStackTrace();
        }
        C1030b.m3276a().m3280b();
        C1371b.m4996a().m5007a((Context) this);
        this.f2364H.m4716a((int) C0965R.drawable.com_bg);
    }

    /* renamed from: c */
    public void m3107c() {
        if (this.f2384n != null) {
            this.f2384n.handleLaunchIntent();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    protected void onStart() {
        super.onStart();
        String packageName = "";
        packageName = getIntent().getStringExtra(C1984a.f6387f);
        if (TextUtils.isEmpty(packageName)) {
            C1260i.m4435b("ouyang", "---isfromthirdparty--null--");
        } else {
            this.f2390t.sendMessage(Message.obtain(this.f2390t, C1253f.gP, packageName));
            getIntent().putExtra(C1984a.f6387f, "");
        }
        C1030b.m3276a().m3282c();
        C0692f.m2894a().m2931c();
    }

    protected void onRestart() {
        super.onRestart();
    }

    protected void onStop() {
        super.onStop();
        C1260i.m4435b(f2351c, "SEND: ONSTOP()");
        if (C1190a.m4065a() && C1663a.m5979a().m5993N()) {
            C1260i.m4435b(f2351c, " onStop internal screen capture ");
        } else {
            C1260i.m4435b(f2351c, " onStop fullscreen capture, Invoke ForegroundService.start ");
            ForegroundService.start(this);
        }
        C1192c.m4069a().m4091j(false);
        C1030b.m3276a().m3285f();
        if (!C1765g.m6424a().m6445f() || VERSION.SDK_INT < 19) {
            EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
        }
        C1774l.m6498c().m6508a(false);
        C0692f.m2894a().m2933d();
        C1435a.m5226a().m5242n();
        C1435a.m5229c();
    }

    protected void onDestroy() {
        C2103a.m7880a().m7888c();
        if (this.f2372P != null) {
            unregisterReceiver(this.f2372P);
            m3044J();
            m3045K();
            this.f2372P = null;
        }
        C1260i.m4435b(f2351c, "onDestroy");
        if (-1 != this.f2395y) {
            StatisticManager.onEventDuration(C1157a.m3876a(), StatisticConstants.COMMON_0005, StatisticConstants.COMMON_0005_LABEL, (int) (System.currentTimeMillis() - this.f2395y));
            this.f2395y = -1;
        }
        C1030b.m3276a().m3286g();
        m3087v();
        super.onDestroy();
        C1260i.m4426a().m4449c();
    }

    /* renamed from: v */
    private void m3087v() {
        boolean wakeupFlag;
        if (C1251e.m4358a().m4399p() && C1251e.m4358a().m4398o()) {
            wakeupFlag = true;
        } else {
            wakeupFlag = false;
        }
        if (wakeupFlag) {
            StatisticManager.onEvent(StatisticConstants.SETTINGS_WAKEUP, StatisticConstants.SETTINGS_WAKEUP);
        }
        C1774l.m6498c().m6510d();
        try {
            if (NavMapAdapter.getInstance().isLogin()) {
                StatisticManager.onEvent(StatisticConstants.HOME_MY_LOGIN_STATUS, StatisticConstants.HOME_MY_LOGIN_STATUS_LOGIN);
            } else {
                StatisticManager.onEvent(StatisticConstants.HOME_MY_LOGIN_STATUS, StatisticConstants.HOME_MY_LOGIN_STATUS_LOGOUT);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        C2191s.m8343a(C2191s.f7020n, false, true, false);
        C1818h.m6730b().m6795c();
        C1251e.m4362b(C1253f.jm, ".mp3");
        m3039E();
        C1261k.m4451a();
        BNAutoDayNightHelper.getInstance().deleteObserver(this.f2378V);
        BNaviModuleManager.setActivity(null);
        ForegroundService.stop(this);
        DownNotifManager.getInstance(this.f2385o).clearAllNotifs();
        C1043a.m3360a().m3379b();
        PhoneStateService.m8212a(this);
        this.f2386p = true;
        C1663a.m5979a().m6045l();
        if (this.f2389s != null) {
            this.f2389s.cancelAll();
        }
        C1663a.m5979a().m5991L();
        UsbStateReceiver.m3857a().m3870c();
        C1710a.m6207a().m6256b();
        m3110f();
        m3112h();
        BaseTTSPlayer.destory();
        C2188r.m8332b();
        new Thread(new C09181(this)).start();
        this.f2364H.mo1479a(true);
        if (this.f2358B != null) {
            this.f2358B.recycle();
        }
        TipTool.setToastinInterface(null);
        C2342g.m8864e().m8887a(null);
        TrackDataUpload.getInstance().stopTrackDataUpload();
    }

    protected void onResume() {
        super.onResume();
        C1260i.m4435b(f2351c, "SEND: ONRESUME()");
        this.f2364H.m4736l();
        ForegroundService.stop(this);
        if (this.f2357A && C1765g.m6424a().m6442c()) {
            this.f2390t.postDelayed(new C09309(this), 1000);
        }
        C1192c.m4069a().m4091j(true);
        this.f2357A = false;
        C1663a.m5979a().m6039g();
        C1030b.m3276a().m3283d();
        this.f2364H.m4738n();
        C1912n.m7270a().m7318q();
        if (TextUtils.equals(this.f2365I, C1984a.f6384c)) {
            C2372c.m9030c("start activity by wechat msg");
            this.f2365I = null;
            C2415a.m9228a().m9246f();
        }
        C1260i.m4434b(f2351c);
        C1774l.m6498c().m6508a(true);
    }

    protected void onPause() {
        super.onPause();
        C1260i.m4435b(f2351c, "SEND: ONPAUSE()");
        this.f2357A = true;
        MapViewFactory.getInstance().saveMapCache();
        MapViewFactory.getInstance().saveMapStatus();
        C1912n.m7270a().m7317p();
        C1663a.m5979a().m6044k();
        C1030b.m3276a().m3284e();
        this.f2364H.m4739o();
    }

    public void onBackPressed() {
        ActivityStack.handleAppBackPressed();
    }

    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        C1260i.m4435b("BtTelephoneSwitchHelper", "onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
        C1030b.m3276a().m3278a(newConfig);
    }

    protected void onNewIntent(Intent intent) {
        C1260i.m4435b(f2351c, "onNewIntent");
        super.onNewIntent(intent);
        String openDownloadManager = "";
        if (intent != null) {
            this.f2365I = intent.getAction();
            if (TextUtils.equals(C1984a.f6384c, this.f2365I)) {
                C1030b.m3276a().m3277a(intent);
                return;
            }
            this.f2365I = null;
            openDownloadManager = intent.getStringExtra("OpenDownloadManager");
            if (openDownloadManager == null || !openDownloadManager.equals("open")) {
                if (openDownloadManager != null && openDownloadManager.equals("openmap")) {
                    if (this.f2363G.getCurrentFragmentType() == NaviFragmentManager.TYPE_LOCAL_MAP_PAGE) {
                        this.f2363G.back();
                    } else if (this.f2363G.getCurrentFragmentType() != NaviFragmentManager.TYPE_LOCAL_MAP_MANAGER) {
                        this.f2364H.m4717a((int) NaviFragmentManager.TYPE_LOCAL_MAP_MANAGER, null);
                    }
                }
            } else if (this.f2363G.getCurrentFragmentType() != NaviFragmentManager.TYPE_OFFLINE_DATA) {
                this.f2364H.m4717a((int) NaviFragmentManager.TYPE_OFFLINE_DATA, null);
            }
            setIntent(intent);
            String packageName = "";
            packageName = intent.getStringExtra(C1984a.f6387f);
            if (TextUtils.isEmpty(packageName)) {
                C1260i.m4435b("ouyang", "---onNewIntent--null--");
            } else {
                getIntent().putExtra(C1984a.f6387f, packageName);
                C1260i.m4435b("ouyang", "---onNewIntent----");
            }
        }
        C1030b.m3276a().m3277a(intent);
        try {
            if (C1253f.fx.equals(getIntent().getAction()) && !C1663a.m5979a().m5993N()) {
                C1260i.m4435b(f2351c, "USB Accessory attached onNewIntent");
                C1663a.m5979a().m6010a((Context) this, (UsbAccessory) getIntent().getParcelableExtra("accessory"));
            }
        } catch (Exception ex) {
            C1260i.m4435b(f2351c, "start usb accessory attached fail");
            ex.printStackTrace();
        }
    }

    public void setRequestedOrientation(int requestedOrientation) {
        if (getRequestedOrientation() != requestedOrientation) {
            super.setRequestedOrientation(requestedOrientation);
        }
    }

    /* renamed from: d */
    public void m3108d() {
        if (!C2204x.m8382b() || !C1663a.m5979a().m5993N()) {
            C1260i.m4435b(f2351c, "Open Exit app dialog");
            if (this.f2380j == null) {
                this.f2380j = new C1953c(this).m7442b((int) C0965R.string.alert_quit).m7435a((int) C0965R.string.alert_quit_app_content).m7457g(17).m7447c((int) C0965R.string.alert_confirm).m7458q().m7450d((int) C0965R.string.alert_cancel);
                this.f2380j.m7438a(new C0672b(this) {
                    /* renamed from: a */
                    final /* synthetic */ CarlifeActivity f2328a;

                    {
                        this.f2328a = this$0;
                    }

                    public void onClick() {
                        if (-1 != this.f2328a.f2395y) {
                            StatisticManager.onEventDuration(C1157a.m3876a(), StatisticConstants.COMMON_0005, StatisticConstants.COMMON_0005_LABEL, (int) (System.currentTimeMillis() - this.f2328a.f2395y));
                            this.f2328a.f2395y = -1;
                        }
                        C1251e.m4380l();
                        ActivityStack.exitApp(C1192c.m4069a().m4080d());
                    }
                });
                this.f2380j.setOnDialogCancelListener(new C0690d(this) {
                    /* renamed from: a */
                    final /* synthetic */ CarlifeActivity f2329a;

                    {
                        this.f2329a = this$0;
                    }

                    public void onCancel() {
                        if (C1268a.m4481b().m4499g()) {
                            C1268a.m4481b().m4486a(4201, true, 30000);
                            C1268a.m4481b().m4504l();
                        }
                    }
                });
            }
            if (!this.f2364H.isDialogShown()) {
                this.f2364H.showDialog(this.f2380j);
            }
        }
    }

    /* renamed from: e */
    public boolean m3109e() {
        if (this.f2380j == null || !this.f2364H.isDialogShown()) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public void m3104a(boolean dayStyle) {
        StyleManager.setDayStyle(dayStyle);
        BNStyleManager.setDayStyle(dayStyle);
        this.f2364H.m4729c(dayStyle);
        ContentFragment fragment = this.f2363G.getCurrentFragment();
        if (fragment != null) {
            C1260i.m4435b(OVERLAY_KEY.AREA_STYLE, "fragment " + fragment.getClass().getSimpleName());
            fragment.updateStyle(dayStyle);
        }
        if (!(fragment == null || !this.f2363G.isCarlifeFragment(fragment.getType()) || this.f2363G.m4778j() == null)) {
            fragment = (ContentFragment) this.f2363G.m4778j();
            if (fragment != null) {
                C1260i.m4435b(OVERLAY_KEY.AREA_STYLE, "map mdule fragment " + fragment.getClass().getSimpleName());
                fragment.updateStyle(dayStyle);
            }
        }
        this.f2379e = dayStyle;
    }

    /* renamed from: f */
    public void m3110f() {
        BNRoutePlaner.getInstance().setObserver(null);
    }

    /* renamed from: g */
    public void m3111g() {
        if (this.f2374R != null) {
            BNOfflineDataManager.getInstance().addObserver(this.f2374R);
        }
    }

    /* renamed from: h */
    public void m3112h() {
        if (this.f2374R != null) {
            BNOfflineDataManager.getInstance().deleteObserver(this.f2374R);
        }
    }

    /* renamed from: a */
    public void m3098a(int flag) {
        this.f2387q = flag;
    }

    /* renamed from: i */
    public int m3113i() {
        return this.f2387q;
    }

    /* renamed from: j */
    public void m3114j() {
        if (this.f2382l == null) {
            this.f2382l = new C1953c(this).m7435a(this.f2387q == 1 ? C0965R.string.data_ver_not_match_tips : C0965R.string.nsdk_string_xijiang_delete).m7447c((int) C0965R.string.data_ver_not_match_download).m7458q().m7450d((int) C0965R.string.data_ver_not_match_online);
            this.f2382l.m7438a(new C0672b(this) {
                /* renamed from: a */
                final /* synthetic */ CarlifeActivity f2331a;

                {
                    this.f2331a = this$0;
                }

                public void onClick() {
                    PreferenceHelper.getInstance(BaiduNaviApplication.getInstance().getApplicationContext()).putBoolean(Key.NAVI_SHOW_ONLINE_USE, false);
                    this.f2331a.f2363G.showFragment(NaviFragmentManager.TYPE_OFFLINE_DATA, null);
                }
            });
            this.f2382l.m7443b(new C0672b(this) {
                /* renamed from: a */
                final /* synthetic */ CarlifeActivity f2332a;

                {
                    this.f2332a = this$0;
                }

                public void onClick() {
                    PreferenceHelper.getInstance(BaiduNaviApplication.getInstance().getApplicationContext()).putBoolean(Key.NAVI_SHOW_ONLINE_USE, false);
                }
            });
        }
        if (!this.f2364H.isDialogShown() && !isFinishing()) {
            this.f2364H.showDialog(this.f2382l);
        }
    }

    /* renamed from: w */
    private void m3089w() {
        if (this.f2383m == null) {
            this.f2383m = new C1953c(this.f2385o).m7448c("授权提示").m7444b("为了正常使用此功能，请在手机上选择始终允许该权限").m7451d("我知道了").m7458q().m7436a(1, 10);
        }
        if (!isFinishing()) {
            this.f2364H.showDialog(this.f2383m);
        }
    }

    /* renamed from: k */
    public void m3115k() {
        if (this.f2382l != null && this.f2364H.isDialogShown()) {
            this.f2364H.dismissDialog(this.f2382l);
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (C1268a.m4481b().m4499g()) {
            if (keyCode == 82) {
                C1260i.m4435b("fangsheng", "======phone====KEYCODE_MENU=========");
                C1268a.m4481b().m4502j();
            } else if (keyCode == 4) {
                C1260i.m4435b("fangsheng", "======phone====KEYCODE_BACK=========");
                if (!C1268a.m4481b().m4493c()) {
                    C1268a.m4481b().m4485a(C1268a.m4481b().m4500h());
                }
            } else if (keyCode == 25) {
                C1260i.m4435b(f2351c, "KeyEvent.KEYCODE_VOLUME_DOWN is detected!");
                C1663a.m5979a().m6009a((Context) this);
            } else if (keyCode == 85) {
                C1663a.m5979a().m5988I();
            }
        } else if (this.f2392v != null && this.f2392v.size() > 0) {
            for (int i = 0; i < this.f2392v.size(); i++) {
                if (((C0938b) this.f2392v.get(i)).m3025a(keyCode, event)) {
                    return true;
                }
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    /* renamed from: a */
    public void m3102a(C0938b lis) {
        if (lis != null) {
            if (this.f2392v == null) {
                this.f2392v = new ArrayList();
            }
            if (!this.f2392v.contains(lis)) {
                this.f2392v.add(lis);
            }
        }
    }

    /* renamed from: b */
    public void m3106b(C0938b lis) {
        if (lis != null && this.f2392v != null && this.f2392v.contains(lis)) {
            this.f2392v.remove(lis);
        }
    }

    /* renamed from: a */
    public void m3103a(C1011b listener) {
        this.f2391u = listener;
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean z = true;
        if (!m3056a(ev)) {
            try {
                z = super.dispatchTouchEvent(ev);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    /* renamed from: a */
    private boolean m3056a(MotionEvent ev) {
        if (!C1663a.m5979a().m5993N()) {
            return false;
        }
        if (C1268a.m4481b().m4499g()) {
            if (!C1268a.m4481b().m4497e()) {
                C1268a.m4481b().m4502j();
            }
        } else if (!C1268a.m4481b().m4493c()) {
            C1268a.m4481b().m4486a(4200, false, 0);
        }
        if (!C1192c.m4069a().m4088h() || C1268a.m4481b().m4497e()) {
            return false;
        }
        float velocity = 0.0f;
        switch (ev.getAction()) {
            case 0:
                if (this.f2358B == null) {
                    this.f2358B = VelocityTracker.obtain();
                } else {
                    this.f2358B.clear();
                }
                this.f2358B.addMovement(ev);
                C1268a.m4481b().m4503k();
                break;
            case 1:
            case 3:
                C1268a.m4481b().m4504l();
                break;
            case 2:
                if (this.f2358B != null) {
                    this.f2358B.addMovement(ev);
                    this.f2358B.computeCurrentVelocity(1000);
                    velocity = this.f2358B.getXVelocity();
                    break;
                }
                break;
        }
        if (velocity > 1000.0f && this.f2364H.m4737m()) {
            this.f2364H.mo1479a(false);
            C1268a.m4481b().m4504l();
        }
        if (this.f2364H.m4737m()) {
            return true;
        }
        return false;
    }

    /* renamed from: x */
    private void m3091x() {
        C1260i.m4435b(f2351c, "++++++++++++++++++++Baidu Carlife Begin++++++++++++++++++++");
        C1253f.jm = C1251e.m4358a().m4396m() + "/" + "BaiduCarlife";
        File file = new File(C1253f.jm);
        if (!file.exists()) {
            file.mkdir();
        }
        C1260i.m4426a().m4448b();
        C1663a.m5979a().m6008a(this, CarlifeActivityService.class, this, C2188r.m8331b(C0965R.drawable.com_ic_carlife_black), C0965R.drawable.ic_launcher);
        C1663a.m5979a().m6052s();
        C1192c.m4069a().m4073a(0);
        C1047b.m3397a().m3413a(new C1050e());
        ScreenUtil.getInstance().init(this);
        C1268a.m4481b().m4487a((C0939b) this);
        C1747c.m6337a().m6339b();
        C1757d.m6389a().m6391b();
        C1663a.m5979a().m6022b((Context) this);
        UsbStateReceiver.m3857a().m3868a((Context) this);
        m3094y();
        this.f2390t.postDelayed(new Runnable(this) {
            /* renamed from: a */
            final /* synthetic */ CarlifeActivity f2333a;

            {
                this.f2333a = this$0;
            }

            public void run() {
                C1251e.m4384v();
            }
        }, Config.BPLUS_DELAY_TIME);
        setRequestedOrientation(0);
        C1915a.m7321a().m7323a(C2198u.m8354a().m8364b());
        C1915a.m7321a().m7326a(new C0917b(this) {
            /* renamed from: a */
            final /* synthetic */ CarlifeActivity f2334a;

            {
                this.f2334a = this$0;
            }

            /* renamed from: a */
            public boolean mo1338a() {
                return C1663a.m5979a().m5989J();
            }
        });
        TipTool.setToastinInterface(new C2199v());
        this.f2389s = (NotificationManager) getSystemService("notification");
        this.f2388r = new Builder(this);
        this.f2388r.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, CarlifeActivity.class), 134217728)).setAutoCancel(true).setContentTitle(getString(C0965R.string.usb_statusbar_title));
        this.f2386p = false;
        C1869r.m7128a().m7129a(this.f2385o);
        m3038D();
        C1765g.m6424a().m6437a(this.f2385o);
        C1435a.m5226a().m5231b();
        EnterQuitLogicManager.getmInstance().setActivity(this);
        TrackDataUpload.getInstance().startTrackDataUpload();
        StrictMode.setThreadPolicy(new ThreadPolicy.Builder().permitNetwork().build());
        C1765g.m6424a().m6441c(true);
        C1774l.m6498c().m6507a(this.f2390t);
        C2204x.m8379a();
        C2716c.m10146a(C1253f.jx.m4403a());
        if (VERSION.SDK_INT >= 21) {
            m3122r();
        }
        C2103a.m7880a().m7887a(this.f2385o);
        C1977e.m7498a().m7551a((Activity) this, m3125u());
        C1261k.m4453a(1009, 10000);
    }

    /* renamed from: b */
    private void m3060b(int height, int width) {
        C1260i.m4435b(f2351c, "####### adaptScreen: [" + height + " : " + width + " ]");
        this.f2364H.m4695g().setLayoutParams(new LayoutParams(width, height));
        this.f2364H.m4695g().invalidate();
        C1249d.m4331a().m4341b(height);
        C1249d.m4331a().m4336a(width);
        Configuration configuration = getResources().getConfiguration();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        displayMetrics.heightPixels = height;
        displayMetrics.widthPixels = width;
        getResources().updateConfiguration(configuration, displayMetrics);
        ScreenUtil.getInstance().init(this);
        if (C1249d.m4334m() && this.f2363G.getCurrentFragmentType() == NaviFragmentManager.TYPE_RADIO_CHANNEL) {
            this.f2363G.back();
        }
    }

    /* renamed from: y */
    private void m3094y() {
        C1663a.m5979a().m6007a(C1157a.m3876a().getResources().getDimensionPixelOffset(C0965R.dimen.frag_main_bottom_bar_height), new C09212(this));
    }

    /* renamed from: z */
    private void m3095z() {
        int fragType = this.f2363G.getCurrentFragmentType();
        if (fragType == NaviFragmentManager.TYPE_LOGIN || fragType == NaviFragmentManager.TYPE_HOME_DISCOVER_JYB) {
            this.f2363G.getCurrentFragment().back();
        } else if (fragType == NaviFragmentManager.TYPE_SETTING_FEEDBACK || fragType == NaviFragmentManager.TYPE_LOGIN || fragType == 551 || fragType == NaviFragmentManager.TYPE_HOME_DISCOVER_JYB || fragType == NaviFragmentManager.TYPE_HOME_DISCOVER_ETCP || fragType == NaviFragmentManager.TYPE_HOME_DISCOVER_CWYD || fragType == NaviFragmentManager.TYPE_SETTING_NAVI) {
            this.f2363G.back();
        }
    }

    /* renamed from: A */
    private void m3032A() {
        if (C1190a.m4065a()) {
            C2252a.f7336a = false;
            new C2289i(this.f2385o).show();
        }
    }

    /* renamed from: B */
    private void m3034B() {
        if (!this.f2375S) {
            BNSettingManager.setIsShowMapSwitch(0);
        }
        if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
            if (this.f2375S) {
                BaiduNaviSDKManager.getInstance().closeNaviInstant();
                BaiduNaviSDKManager.getInstance().enterNavState();
                if (RGRouteSearchModel.getInstance().isRouteSearchMode() || RGPickPointModel.getInstance().isPickPointShow()) {
                    RGViewController.getInstance().onEmptyPoiAction();
                }
            } else {
                BaiduNaviSDKManager.getInstance().updateNaviInstant();
            }
            RouteGuideFSM.getInstance().run(FsmEvent.TOUCH_MAP);
        } else if (this.f2363G.getCurrentFragmentType() == 17 && (this.f2363G.getCurrentFragment() instanceof CarModeMapFragment)) {
            ((CarModeMapFragment) this.f2363G.getCurrentFragment()).showMapFocusView(this.f2375S);
        }
    }

    /* renamed from: a */
    private void m3051a(Message msg) {
        if (BaiduNaviManager.sIsBaseEngineInitialized) {
            try {
                CarlifeCarGps carGps = CarlifeCarGps.parseFrom(msg.obj.m4205f());
                this.f2377U.f4907a = carGps.getLatitude();
                this.f2377U.f4908b = carGps.getLongitude();
                this.f2377U.f4909c = carGps.getSpeed();
                this.f2377U.f4910d = carGps.getHeading();
                this.f2377U.f4911e = carGps.getHeight();
                this.f2377U.f4914h = ((float) carGps.getPdop()) / 10.0f;
                this.f2377U.f4912f = carGps.getSatsUsed();
                this.f2377U.f4913g = System.currentTimeMillis();
                C1609a.m5873a(this.f2377U);
                if (this.f2376T) {
                    C1260i.m4435b(f2351c, "firstGpsComing updateGpsInfo start");
                    MainMapModel.getInstance().bFirstLoc = true;
                    LocationManager.getInstance().onPause();
                    C1609a.m5871a().m5878a(true);
                    C1609a.m5871a().m5879b(true);
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
                    C1609a.m5873a(this.f2377U);
                    C1609a.m5871a().m5879b(true);
                    this.f2376T = false;
                    C1260i.m4435b(f2351c, "firstGpsComing updateGpsInfo end");
                }
            } catch (InvalidProtocolBufferException e) {
                C1260i.m4445e(f2351c, "Get MSG_CMD_CAR_GPS Error");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m3061b(Message msg) {
        try {
            CarlifeCarSpeed carSpeed = CarlifeCarSpeed.parseFrom(msg.obj.m4205f());
            C1260i.m4435b(f2351c, "MSG_CMD_CAR_VELOCITY: speed = " + carSpeed.getSpeed() + ", timeStamp = " + carSpeed.getTimeStamp());
            int nSpeed = carSpeed.getSpeed();
            C1251e.m4360b(nSpeed);
            if (C1765g.m6424a().m6443d()) {
                if (nSpeed >= 5) {
                    C2252a.m8531a().m8563a(true);
                } else {
                    C2252a.m8531a().m8563a(false);
                }
                C1261k.m4462b(C1253f.hJ, nSpeed);
            }
        } catch (InvalidProtocolBufferException e) {
            C1260i.m4445e(f2351c, "Get MSG_CMD_CAR_VELOCITY Error");
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m3063b(boolean isForegroud) {
        if (C1663a.m5979a().m6046m()) {
            C1212c command = new C1212c(true);
            if (isForegroud) {
                C1260i.m4435b(f2351c, "send foreground message");
                command.m4201c(C1253f.ao);
            } else {
                C1260i.m4435b(f2351c, "send background message");
                command.m4201c(C1253f.ap);
            }
            C1663a.m5979a().m6017a(Message.obtain(null, command.m4202d(), 1001, 0, command));
        }
    }

    /* renamed from: C */
    private void m3037C() {
        if (C1190a.m4065a()) {
            C1260i.m4435b(f2351c, " sendPhoneStatusMsg internal screen capture ");
            m3063b(true);
        } else {
            C1260i.m4435b(f2351c, " sendPhoneStatusMsg fullscreen capture ");
            m3063b(C1192c.m4069a().m4095m());
        }
        if (this.f2381k != null) {
            this.f2381k.m3155b();
        }
    }

    /* renamed from: D */
    private void m3038D() {
        if (this.f2381k == null) {
            this.f2381k = new ScreenListener(this);
            this.f2381k.m3154a(new C09233(this));
        }
    }

    /* renamed from: E */
    private void m3039E() {
        if (this.f2381k != null) {
            this.f2381k.m3153a();
            this.f2381k = null;
        }
    }

    /* renamed from: b */
    public void m3105b(int usbStatus) {
        if (this.f2388r != null) {
            switch (usbStatus) {
                case 1002:
                    this.f2388r.setSmallIcon(C0965R.drawable.ib_usbdisconnect_topbar);
                    this.f2388r.setTicker(getString(C0965R.string.usb_statusbar_disconnected));
                    this.f2388r.setContentText(getString(C0965R.string.usb_statusbar_disconnected));
                    break;
                case 1003:
                    this.f2388r.setSmallIcon(C0965R.drawable.ib_usbdisconnect_topbar);
                    this.f2388r.setTicker(getString(C0965R.string.usb_statusbar_connecting));
                    this.f2388r.setContentText(getString(C0965R.string.usb_statusbar_connecting));
                    break;
                case 1004:
                    this.f2388r.setSmallIcon(C0965R.drawable.ib_usbconnect_topbar);
                    this.f2388r.setTicker(getString(C0965R.string.usb_statusbar_connected));
                    this.f2388r.setContentText(getString(C0965R.string.usb_statusbar_connected));
                    break;
                case 1005:
                    this.f2388r.setSmallIcon(C0965R.drawable.ib_usbdisconnect_topbar);
                    this.f2388r.setTicker(getString(C0965R.string.usb_statusbar_reconnecting));
                    this.f2388r.setContentText(getString(C0965R.string.usb_statusbar_reconnecting));
                    break;
                case 1006:
                    this.f2388r.setSmallIcon(C0965R.drawable.ib_usbconnect_topbar);
                    this.f2388r.setTicker(getString(C0965R.string.usb_statusbar_reconnected));
                    this.f2388r.setContentText(getString(C0965R.string.usb_statusbar_reconnected));
                    break;
            }
            this.f2388r.setWhen(System.currentTimeMillis());
            this.f2389s.notify(5000, this.f2388r.build());
        }
    }

    /* renamed from: F */
    private int m3040F() {
        return this.f2363G.getCurrentFragmentType();
    }

    /* renamed from: a */
    private void m3055a(String msg) {
        C2201w.m8373a(msg, 0);
    }

    /* renamed from: l */
    public void m3116l() {
        try {
            C1260i.m4435b(f2351c, "go to foreground");
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setClass(this, CarlifeActivity.class);
            intent.setFlags(335544320);
            startActivity(intent);
        } catch (Exception ex) {
            C1260i.m4435b(f2351c, "go to foreground fail");
            ex.printStackTrace();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        C1260i.m4445e("zzt", "requestCode:  " + requestCode + " resultCode:  " + resultCode + "  data: " + data);
        if (requestCode == 4353 && resultCode == -1) {
            C1765g.m6424a();
            C1765g.m6432g();
        }
        C1663a.m5979a().m6006a(requestCode, resultCode, data);
    }

    /* renamed from: m */
    public void m3117m() {
        InputMethodManager imm = (InputMethodManager) getSystemService("input_method");
        View view = getCurrentFocus();
        if (view != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }

    /* renamed from: G */
    private void m3041G() {
        if (this.f2364H.isDialogShown()) {
            this.f2364H.dismissDialog(this.f2361E);
        }
    }

    /* renamed from: H */
    private void m3042H() {
        this.f2360D = new C1659r(C1253f.jx.m4403a());
        this.f2360D.toGetRequest();
        this.f2360D.registerResponseListener(new C09254(this));
    }

    /* renamed from: I */
    private void m3043I() {
        if (this.f2361E == null) {
            this.f2361E = new C2328t(this);
        }
        if (this.f2360D.m5971a() && C1663a.m5979a().m5993N()) {
            this.f2364H.showDialog(this.f2361E);
        } else if (this.f2364H.isDialogShown()) {
            this.f2364H.dismissDialog(this.f2361E);
        }
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        boolean z;
        boolean z2 = true;
        super.onWindowFocusChanged(hasFocus);
        C1260i.m4435b("Bt", "onWindowFocusChanged = " + hasFocus);
        C1319h c1319h = this.f2364H;
        if (hasFocus) {
            z = false;
        } else {
            z = true;
        }
        if (this.f2357A) {
            z2 = false;
        }
        c1319h.m4724a(z, z2);
    }

    /* renamed from: n */
    public void m3118n() {
        BNAutoDayNightHelper.getInstance().addObserver(this.f2378V);
    }

    /* renamed from: a */
    public void mo1345a(float screenBrightness, boolean screenOn) {
        Window window = getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.screenBrightness = screenBrightness;
        if (screenOn) {
            lp.flags |= 128;
        }
        window.setAttributes(lp);
    }

    /* renamed from: o */
    public void mo1348o() {
        C1260i.m4435b(f2351c, "onVehicleConnected() ");
        setVehicleConnected(true);
        if (C1190a.m4065a() && C1869r.m7128a().m7130b()) {
            BaseFragment.getNaviActivity().sendBroadcast(new Intent("com.baidu.carlife.Action.StartActivityBroadReceiver"));
        }
        if (this.f2357A) {
            super.onResume();
        }
    }

    /* renamed from: p */
    public void mo1355p() {
        C1260i.m4435b(f2351c, "onVehicleDisconnect");
        setVehicleConnected(false);
        if (C1663a.m5979a().m6047n() != null) {
            attachHost();
        }
        C1328h.m4757a().m4761a((OnFragmentListener) this);
        this.f2364H.mo1484h();
    }

    /* renamed from: a */
    public void mo1347a(Intent intent, int requestCode) {
        startActivityForResult(intent, requestCode);
    }

    /* renamed from: q */
    public boolean mo1356q() {
        return this.f2357A;
    }

    /* renamed from: a */
    public void mo1346a(int width, int height) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
    }

    public void onStateNotSaved() {
    }

    /* renamed from: r */
    public void m3122r() {
        C1260i.m4435b(f2352d, "Activity: initWifiDirect ");
        this.f2366J = (WifiP2pManager) getSystemService("wifip2p");
        this.f2367K = this.f2366J.initialize(this, getMainLooper(), null);
        if (this.f2366J == null || this.f2367K == null) {
            C1260i.m4445e(f2352d, "Activity: InitWifiP2pManager error!");
        }
        this.f2371O = C1246i.m4306a();
        m3045K();
        m3123s();
        m3046L();
    }

    /* renamed from: J */
    private void m3044J() {
        this.f2366J.stopPeerDiscovery(this.f2367K, this.f2371O.m4307a("Activity: stop discovery ", true));
        this.f2366J.removeGroup(this.f2367K, this.f2371O.m4307a("Main: remove group", true));
        C1260i.m4435b(f2352d, "Activity: stopDiscoverServices");
    }

    /* renamed from: K */
    private void m3045K() {
        if (this.f2369M != null) {
            this.f2366J.removeLocalService(this.f2367K, this.f2369M, this.f2371O.m4308b());
            this.f2366J.clearLocalServices(this.f2367K, this.f2371O.m4309c());
            this.f2369M = null;
        }
        if (this.f2368L != null) {
            this.f2366J.removeServiceRequest(this.f2367K, this.f2368L, this.f2371O.m4311e());
            this.f2366J.clearServiceRequests(this.f2367K, this.f2371O.m4310d());
            this.f2368L = null;
        }
    }

    /* renamed from: s */
    public void m3123s() {
        if (this.f2373Q == null) {
            this.f2373Q = new IntentFilter();
        }
        this.f2373Q.addAction(NetworkListener.f2258e);
        this.f2373Q.addAction("android.net.wifi.p2p.STATE_CHANGED");
        this.f2373Q.addAction("android.net.wifi.p2p.PEERS_CHANGED");
        this.f2373Q.addAction("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");
        this.f2373Q.addAction("android.net.wifi.p2p.THIS_DEVICE_CHANGED");
        this.f2373Q.addAction("android.net.wifi.p2p.DISCOVERY_STATE_CHANGE");
        this.f2372P = new WifiDirectBroadReceiver(this.f2366J, this.f2367K, (Activity) this);
        registerReceiver(this.f2372P, this.f2373Q);
    }

    /* renamed from: L */
    private void m3046L() {
        Map<String, String> record = new HashMap();
        record.put("available", MapObjKey.OBJ_SL_VISI);
        this.f2369M = WifiP2pDnsSdServiceInfo.newInstance("_ClfWfd", "_Clf._Wifi", record);
        this.f2366J.addLocalService(this.f2367K, this.f2369M, this.f2371O.m4312f());
        C1260i.m4435b(f2352d, "Activity: create as group owner!");
        this.f2366J.createGroup(this.f2367K, new C09276(this));
        m3124t();
    }

    /* renamed from: t */
    public void m3124t() {
        C1260i.m4435b(f2352d, "------------------- Start Discover--------------------------");
        C1260i.m4435b(f2352d, "Activity: discoverService");
        this.f2366J.setDnsSdResponseListeners(this.f2367K, new C09287(this), new C09298(this));
        this.f2368L = WifiP2pDnsSdServiceRequest.newInstance();
        this.f2366J.addServiceRequest(this.f2367K, this.f2368L, this.f2371O.m4313g());
        this.f2366J.discoverServices(this.f2367K, this.f2371O.m4314h());
    }

    /* renamed from: a */
    public void m3101a(WifiP2pDevice device) {
        WifiP2pConfig config = new WifiP2pConfig();
        config.deviceAddress = device.deviceAddress;
        config.wps.setup = 0;
        C1260i.m4435b(f2352d, "---------------connectP2p : " + device.deviceAddress + " | " + device.deviceName);
        if (this.f2368L != null) {
            this.f2366J.removeServiceRequest(this.f2367K, this.f2368L, this.f2371O.m4307a("Activity: connecting remove request", true));
        }
        this.f2366J.connect(this.f2367K, config, this.f2371O.m4307a("Activity: connectP2p ", true));
    }

    public void onConnectionInfoAvailable(WifiP2pInfo p2pInfo) {
        if (p2pInfo.isGroupOwner) {
            C1260i.m4435b(f2352d, "-------------- Connected as group owner");
        } else {
            C1260i.m4435b(f2352d, "-------------- Connected as peer");
        }
        C1260i.m4435b(f2352d, "Group Owner IP : " + p2pInfo.groupOwnerAddress);
    }

    /* renamed from: u */
    public C1319h m3125u() {
        return this.f2364H;
    }
}
