package com.baidu.carlife.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.baidu.baidumaps.base.localmap.C0692f;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.R;
import com.baidu.carlife.KeyboardService;
import com.baidu.carlife.bluetooth.BtDeviceManager;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.CarLifeSettings;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.screen.OnBtnClickListener;
import com.baidu.carlife.core.screen.lightness.LightnessControlManager;
import com.baidu.carlife.logic.C1710a;
import com.baidu.carlife.logic.C1856o;
import com.baidu.carlife.logic.C1868q;
import com.baidu.carlife.logic.C1872t;
import com.baidu.carlife.logic.C1872t.C1318b;
import com.baidu.carlife.logic.music.C1818h;
import com.baidu.carlife.logic.voice.C1912n;
import com.baidu.carlife.p052m.C1917b;
import com.baidu.carlife.service.PhoneStateService;
import com.baidu.carlife.util.C2177h;
import com.baidu.carlife.util.C2186p;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.C2256c;
import com.baidu.carlife.view.C2342g;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.carlife.view.dialog.C2278e;
import com.baidu.carlife.view.dialog.C2308q;
import com.baidu.carlife.view.dialog.C2308q.C1518a;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.navi.ActivityStack;
import com.baidu.navi.adapter.DistrictAdapter;
import com.baidu.navi.common.util.StorageInformation;
import com.baidu.navi.common.util.StorageSettings;
import com.baidu.navi.controller.HomeController;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.fragment.carmode.CarModeOfflineDataFragment;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navi.track.datashop.TrackDataShop;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.voice.NaviState;
import com.baidu.navisdk.CommonParams.Key;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.ui.ugc.model.BNRCEventDetailsModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.AudioUtils;
import com.baidu.navisdk.util.common.FileUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.SDCardUtils;
import com.baidu.navisdk.util.db.DBManager;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class LaunchFragment extends ContentFragment {
    /* renamed from: a */
    public static String f4526a = LaunchFragment.class.getSimpleName();
    /* renamed from: b */
    protected static final int f4527b = 9002;
    /* renamed from: c */
    private static final int f4528c = 2;
    /* renamed from: d */
    private static final int f4529d = 9007;
    /* renamed from: e */
    private static final int f4530e = 9005;
    /* renamed from: f */
    private static final int f4531f = 9004;
    /* renamed from: g */
    private static final int f4532g = 9003;
    /* renamed from: h */
    private static final int f4533h = 9001;
    /* renamed from: i */
    private C2278e f4534i;
    /* renamed from: j */
    private String f4535j = null;
    /* renamed from: k */
    private int[] f4536k = new int[36];
    /* renamed from: l */
    private int[] f4537l = new int[1];
    /* renamed from: m */
    private Handler f4538m = null;
    /* renamed from: n */
    private ViewGroup f4539n = null;
    /* renamed from: o */
    private boolean f4540o;
    /* renamed from: p */
    private volatile int f4541p = 0;
    /* renamed from: q */
    private C1318b f4542q = new C1523b();

    /* renamed from: com.baidu.carlife.fragment.LaunchFragment$1 */
    class C15141 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ LaunchFragment f4510a;

        C15141(LaunchFragment this$0) {
            this.f4510a = this$0;
        }

        public void run() {
            try {
                TrackDataShop.getInstance().clearBeforSixMonthGPSFile(NaviAccountUtils.getInstance().getUid());
            } catch (Exception e) {
                LogUtil.d(LaunchFragment.f4526a, "SapiAccountManager have not been initialized");
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.LaunchFragment$2 */
    class C15152 implements OnBtnClickListener {
        /* renamed from: a */
        final /* synthetic */ LaunchFragment f4511a;

        C15152(LaunchFragment this$0) {
            this.f4511a = this$0;
        }

        public void onClick() {
            ActivityStack.exitApp(false);
        }
    }

    /* renamed from: com.baidu.carlife.fragment.LaunchFragment$3 */
    class C15163 implements OnBtnClickListener {
        /* renamed from: a */
        final /* synthetic */ LaunchFragment f4512a;

        C15163(LaunchFragment this$0) {
            this.f4512a = this$0;
        }

        public void onClick() {
            ActivityStack.exitApp(false);
        }
    }

    /* renamed from: com.baidu.carlife.fragment.LaunchFragment$4 */
    class C15174 implements OnBtnClickListener {
        /* renamed from: a */
        final /* synthetic */ LaunchFragment f4513a;

        C15174(LaunchFragment this$0) {
            this.f4513a = this$0;
        }

        public void onClick() {
            ActivityStack.exitApp(false);
        }
    }

    /* renamed from: com.baidu.carlife.fragment.LaunchFragment$a */
    private static class C1522a extends Handler {
        /* renamed from: a */
        private final WeakReference<LaunchFragment> f4524a;

        public C1522a(LaunchFragment launchFragment) {
            this.f4524a = new WeakReference(launchFragment);
        }

        public void handleMessage(Message msg) {
            LaunchFragment launchFragment = (LaunchFragment) this.f4524a.get();
            if (launchFragment != null) {
                switch (msg.what) {
                    case 1301:
                        if (msg.arg1 == 0) {
                            launchFragment.f4541p = launchFragment.f4541p + 1;
                            LogUtil.m4434b("initEngine");
                            launchFragment.m5535a();
                            return;
                        }
                        launchFragment.f4538m.sendMessage(launchFragment.f4538m.obtainMessage(9002));
                        return;
                    case 9001:
                        launchFragment.m5537a(launchFragment.f4535j);
                        return;
                    case 9002:
                        CarLifeSettings.m4069a().m4077c(false);
                        launchFragment.m5552i();
                        return;
                    case 9004:
                        CarLifeSettings.m4069a().m4077c(true);
                        launchFragment.m5541c();
                        return;
                    case 9005:
                        C2201w.m8373a("请等待导航初始化成功", 0);
                        return;
                    case 9007:
                        launchFragment.m5551h();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.baidu.carlife.fragment.LaunchFragment$b */
    private class C1523b implements C1318b {
        /* renamed from: a */
        final /* synthetic */ LaunchFragment f4525a;

        private C1523b(LaunchFragment launchFragment) {
            this.f4525a = launchFragment;
        }

        /* renamed from: b */
        public void mo1481b(boolean isSuccess) {
            this.f4525a.f4541p = this.f4525a.f4541p + 1;
            this.f4525a.m5535a();
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.m4428a(f4526a + " show");
        this.f4538m = new C1522a(this);
    }

    /* renamed from: a */
    private void m5535a() {
        if (this.f4541p >= 2) {
            this.f4538m.sendEmptyMessage(9004);
            this.f4541p = 0;
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.f4539n = (ViewGroup) inflater.inflate(R.layout.frag_launch, null);
        return this.f4539n;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        m5539b();
        LogUtil.m4428a("initEngine");
        m5553j();
    }

    public void onResume() {
        super.onResume();
        LogUtil.m4434b(f4526a);
    }

    public boolean onBackPressed() {
        return true;
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public void onDestroyView() {
        super.onDestroyView();
        C1872t.m7136a().m7158b(this.f4542q);
        if (VERSION.SDK_INT <= 16) {
            removeAllFragmentByType(514);
            mActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        } else if (mActivity != null && !mActivity.isDestroyed()) {
            removeAllFragmentByType(514);
            mActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    public void onDetach() {
        LogUtil.m4434b(f4526a + " show");
        super.onDetach();
    }

    /* renamed from: b */
    private void m5539b() {
        KeyboardService.getInstance().init(mActivity, mActivity.m3125u());
        LogUtil.m4428a(C1872t.f5804a);
        C1872t.m7136a().m7150a(mActivity);
        C1872t.m7136a().m7151a(this.f4542q);
        C1868q.m7089f().m7121g();
        PhoneStateService.m8212a(mActivity);
        CarlifeUtil.m4385w();
        PackageUtil.strChannel = CommonParams.sChannel;
        StatisticManager.setAppChannel(CommonParams.sChannel);
        LightnessControlManager.m4481b().m4484a();
        BtDeviceManager.m3360a().m3375a(mActivity);
        push(createFragment(NaviFragmentManager.TYPE_HOME));
        push(createFragment(519));
        push(createFragment(NaviFragmentManager.TYPE_MUSIC_PLAYER));
        C1912n.m7270a().m7294a(mActivity);
        C1818h.m6730b().m6782a();
    }

    /* renamed from: c */
    private void m5541c() {
        LogUtil.m4428a("after initEngine");
        m5543d();
        C2342g.m8864e().m8885a();
        DBManager.init(BaiduNaviApplication.getInstance());
        C1856o.m7042a().m7046c();
        NaviState.getInstance().registerCustomCmd();
        m5554k();
        BNSettingManager.setPowerSaveMode(2);
        BNSettingManager.setPushMode(false);
        BNSettingManager.setUgcShow(false);
        AudioUtils.init();
        GeoLocateModel.getInstance().asyncGetCurrentDistricts();
        mActivity.m3111g();
        C2256c.m8570a().m8572a(mActivity, mActivity.m3125u());
        C1710a.m6207a().m6253a(mActivity, mActivity.m3125u());
        C1710a.m6207a().m6255a(true);
        m5545e();
        BNVoiceCommandController.getInstance().init();
        UIModel.syncAddressToCoDriverForAppStart();
        if (m5555l()) {
            m5550g();
        } else if (CarLifeSettings.m4069a().m4078c()) {
            m5551h();
        } else {
            showFragment(515, null);
        }
        CarLifeSettings.m4069a().m4079d(true);
        m5548f();
        LogUtil.m4434b("after initEngine");
    }

    /* renamed from: d */
    private void m5543d() {
        FileUtils.copyAssetsFile(AppContext.m3876a().getAssets(), "cfg/a/mode_17/map.rs", SysOSAPIv2.getInstance().getOutputDirPath() + File.separator + "cfg/a/mode_17", "map.rs");
        FileUtils.copyAssetsFile(AppContext.m3876a().getAssets(), "cfg/a/mode_17/map.sty", SysOSAPIv2.getInstance().getOutputDirPath() + File.separator + "cfg/a/mode_17", "map.sty");
    }

    /* renamed from: e */
    private void m5545e() {
        new HomeController(mActivity, mActivity.m3125u()).checkNewVerDataAndUpgrade();
    }

    /* renamed from: f */
    private void m5548f() {
        if (this.f4538m != null) {
            this.f4538m.postDelayed(new C15141(this), 3000);
        }
    }

    /* renamed from: g */
    private void m5550g() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("firstEnter", true);
        showFragment(516, bundle);
    }

    /* renamed from: h */
    private void m5551h() {
        LogUtil.m4428a(HomeFragment.f4452a);
        showFragment(NaviFragmentManager.TYPE_HOME, null);
    }

    /* renamed from: i */
    private void m5552i() {
        C1953c commonDialog = new C1953c(getContext()).m7442b((int) R.string.alert_notification).m7435a((int) R.string.alert_engine_init_failed).m7447c((int) R.string.alert_confirm).m7458q();
        commonDialog.m7438a(new C15152(this));
        showDialog(commonDialog);
    }

    /* renamed from: j */
    private void m5553j() {
        final StorageInformation currentStorage = StorageSettings.getInstance().getCurrentStorage();
        final List<StorageInformation> allStorages = StorageSettings.getInstance().getAllStorages();
        final ArrayList<HashMap<String, Object>> choiceData = new ArrayList();
        C1953c commonDialog;
        if (allStorages.size() == 0) {
            commonDialog = new C1953c(getContext()).m7442b((int) R.string.alert_notification).m7435a((int) R.string.alert_no_sdcard).m7447c((int) R.string.quit).m7457g(17).m7458q();
            commonDialog.m7438a((OnBtnClickListener) new C15163(this));
            showDialog(commonDialog);
        } else if (allStorages.size() < 2) {
            this.f4535j = currentStorage.getRootPath();
            if (SDCardUtils.writeTestFileToSdcard(this.f4535j)) {
                m5537a(this.f4535j);
                return;
            }
            commonDialog = new C1953c(getContext()).m7442b((int) R.string.alert_notification).m7435a((int) R.string.alert_no_sdcard).m7447c((int) R.string.quit).m7457g(17).m7458q();
            commonDialog.m7438a((OnBtnClickListener) new C15174(this));
            showDialog(commonDialog);
        } else {
            String choosePath = PreferenceHelper.getInstance(getContext()).getString(Key.SP_COMMON_CHOOSED_SDCARD_PATH, "null");
            if (!choosePath.equals("null") && choosePath.equals(currentStorage.getRootPath())) {
                this.f4535j = choosePath;
                if (SDCardUtils.writeTestFileToSdcard(this.f4535j)) {
                    m5537a(this.f4535j);
                    return;
                }
            }
            for (StorageInformation storage : allStorages) {
                HashMap<String, Object> data = new HashMap();
                if (storage.getAvailableBytes() == -1) {
                    data.put(C1981b.f6362b, storage.getRootPath() + " 剩余空间:未知");
                } else {
                    data.put(C1981b.f6362b, storage.getRootPath() + " 剩余空间:" + m5534a(storage.getAvailableBytes()));
                }
                data.put(BNRCEventDetailsModel.BN_RC_KEY_LABEL, storage.getLabel());
                data.put(DistrictAdapter.CURRENT_LOCATION, storage.equals(currentStorage) ? "(当前使用)" : "");
                data.put("check", SysOSAPIv2.getInstance().checkExistsOfflineData(storage.getRootPath()).booleanValue() ? Boolean.TRUE : Boolean.FALSE);
                choiceData.add(data);
            }
            final C2308q chooseSDcardDialog = new C2308q(getContext(), choiceData);
            showDialog(chooseSDcardDialog);
            final ListView mListView = chooseSDcardDialog.getListView();
            chooseSDcardDialog.m8784a((C1518a) new C1518a(this) {
                /* renamed from: d */
                final /* synthetic */ LaunchFragment f4517d;

                /* renamed from: a */
                public void mo1574a() {
                    int pos = chooseSDcardDialog.getmCheckedPosition();
                    if (pos < 0 || pos >= allStorages.size()) {
                        TipTool.onCreateToastDialog(this.f4517d.getContext(), R.string.alert_sdcard_no_choose);
                        return;
                    }
                    StorageInformation newStorage = (StorageInformation) allStorages.get(pos);
                    this.f4517d.f4535j = newStorage.getRootPath();
                    if (this.f4517d.f4535j == null || !SDCardUtils.writeTestFileToSdcard(this.f4517d.f4535j)) {
                        TipTool.onCreateToastDialog(this.f4517d.getContext(), R.string.alert_sdcard_cannot_use);
                        return;
                    }
                    if (!currentStorage.getRootPath().equals(newStorage.getRootPath())) {
                        StorageSettings.getInstance().setPreferredStorage(AppContext.m3876a(), newStorage);
                        StorageSettings.getInstance().reInitialize(AppContext.m3876a());
                    }
                    this.f4517d.f4535j = StorageSettings.getInstance().getCurrentStorage().getRootPath();
                    PreferenceHelper.getInstance(this.f4517d.getContext()).putString(Key.SP_COMMON_CHOOSED_SDCARD_PATH, this.f4517d.f4535j);
                    this.f4517d.m5537a(this.f4517d.f4535j);
                    this.f4517d.dismissDialog(chooseSDcardDialog);
                }
            });
            mListView.setOnItemClickListener(new OnItemClickListener(this) {
                /* renamed from: d */
                final /* synthetic */ LaunchFragment f4521d;

                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    for (int i = 0; i < choiceData.size(); i++) {
                        if (i == position) {
                            ((HashMap) choiceData.get(i)).put("check", Boolean.TRUE);
                        } else {
                            ((HashMap) choiceData.get(i)).put("check", Boolean.FALSE);
                        }
                    }
                    chooseSDcardDialog.setmCheckedPosition(position);
                    ((BaseAdapter) mListView.getAdapter()).notifyDataSetChanged();
                }
            });
        }
    }

    /* renamed from: a */
    private String m5534a(long size) {
        if (size < 0) {
            size = 0;
        }
        if (size < 1048576) {
            return String.format(Locale.getDefault(), "%.1fK", new Object[]{Double.valueOf(((double) size) / 1024.0d)});
        } else if (size < 1073741824) {
            return String.format(Locale.getDefault(), "%.1fM", new Object[]{Double.valueOf((((double) size) / 1024.0d) / 1024.0d)});
        } else {
            return String.format(Locale.getDefault(), "%.1fG", new Object[]{Double.valueOf(((((double) size) / 1024.0d) / 1024.0d) / 1024.0d)});
        }
    }

    /* renamed from: a */
    private void m5537a(final String sdcardPath) {
        if (C2186p.m8304a().m8312a(CarModeOfflineDataFragment.NEED_DELETE_DATA, true)) {
            new Thread(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ LaunchFragment f4523b;

                public void run() {
                    try {
                        File file = new File(sdcardPath + File.separator + CommonParams.hM + File.separator + "tmp");
                        LogUtil.d("LaunchFragmet", "file : " + file.getAbsolutePath());
                        if (file.exists()) {
                            C2177h.m8270a(file);
                        }
                    } catch (Exception e) {
                    }
                    C2186p.m8304a().m8323c(CarModeOfflineDataFragment.NEED_DELETE_DATA, false);
                    this.f4523b.f4538m.sendEmptyMessage(9001);
                }
            }).start();
            return;
        }
        C1917b.m7339a();
        NaviAccountUtils.getInstance().initAccount(BaiduNaviApplication.getInstance());
        LocationManager.getInstance().init(BaiduNaviApplication.getInstance());
        LocationManager.getInstance().onResume();
        mActivity.m3118n();
        NavMapAdapter.getInstance().initNaviEngine(mActivity, this.f4538m);
        C0692f.m2894a().m2928b();
        C0692f.m2894a().m2948n();
    }

    /* renamed from: k */
    private void m5554k() {
        BNSettingManager.setDefaultLaunchMode(1);
        int launchMode = BNSettingManager.getDefaultLaunchMode();
        if (launchMode == 0) {
            BNSettingManager.setCurrentUsingMode(1);
        } else if (1 == launchMode) {
            BNSettingManager.setCurrentUsingMode(1);
        } else {
            BNSettingManager.setCurrentUsingMode(2);
        }
    }

    /* renamed from: l */
    private boolean m5555l() {
        return CarLifeSettings.m4069a().m4076b();
    }
}
