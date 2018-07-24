package com.baidu.carlife.core.screen.presentation.view;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import com.baidu.baidunavis.control.NavPoiController;
import com.baidu.carlife.protobuf.R;
import com.baidu.carlife.protobuf.bluetooth.BtManager;
import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.CarLifeSettings;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.connect.CarlifeCmdMessage;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;
import com.baidu.carlife.core.screen.OnBtnClickListener;
import com.baidu.carlife.core.screen.CarLifeSearchPoi;
import com.baidu.carlife.core.screen.presentation.FragmentManagerCallbackProxy;
import com.baidu.carlife.protobuf.fragment.HomeFragment;
import com.baidu.carlife.protobuf.fragment.PhoneFragment;
import com.baidu.carlife.protobuf.logic.music.C1790b;
import com.baidu.carlife.protobuf.logic.music.C1818h;
import com.baidu.carlife.protobuf.logic.voice.C1912n;
import com.baidu.carlife.protobuf.p087l.C1663a;
import com.baidu.carlife.protobuf.util.C2201w;
import com.baidu.carlife.protobuf.view.C2342g;
import com.baidu.carlife.protobuf.view.dialog.C1953c;
import com.baidu.carlife.protobuf.wechat.p108b.C2398k;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.cruise.BCruiser;
import com.baidu.navi.cruise.control.EnterQuitLogicManager;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragmentManager;
import com.baidu.navi.fragment.MapFragment;
import com.baidu.navi.fragment.NameSearchFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.voice.MapVoiceCommandController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener.ActionTypeSearchParams;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import java.util.List;

/* compiled from: CarlifePresenter */
/* renamed from: com.baidu.carlife.core.screen.presentation.a.d */
public class CarlifePresenter {
    /* renamed from: a */
    private static final String f3755a = "CarlifePresenter";
    /* renamed from: b */
    private IModel f3756b;
    /* renamed from: c */
    private CarlifeView f3757c;
    /* renamed from: d */
    private FragmentManagerCallbackProxy f3758d;
    /* renamed from: e */
    private boolean f3759e = false;
    /* renamed from: f */
    private MapFragment f3760f;
    /* renamed from: g */
    private boolean f3761g = false;
    /* renamed from: h */
    private boolean f3762h = true;
    /* renamed from: i */
    private Context f3763i;
    /* renamed from: j */
    private C1305a f3764j;

    /* compiled from: CarlifePresenter */
    /* renamed from: com.baidu.carlife.core.screen.presentation.a.d$a */
    private class C1305a extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ CarlifePresenter f3754a;

        public C1305a(CarlifePresenter carlifePresenter, Looper looper) {
            this.f3754a = carlifePresenter;
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1002:
                    this.f3754a.f3762h = true;
                    return;
                case CommonParams.fk /*1038*/:
                    this.f3754a.f3757c.mo1483f();
                    return;
                case CommonParams.fV /*2029*/:
                    LogUtil.d(CarlifePresenter.f3755a, "MSG_TELE_BT_DISCONNECT");
                    this.f3754a.m4667t();
                    return;
                case 4001:
                    if (msg.arg1 == CommonParams.iy) {
                        this.f3754a.m4673a(true);
                    } else {
                        this.f3754a.m4673a(false);
                    }
                    C1912n.m7270a().m7310i();
                    return;
                case 4002:
                    this.f3754a.m4660m();
                    C1912n.m7270a().m7310i();
                    return;
                case 4003:
                    this.f3754a.m4680e();
                    C1912n.m7270a().m7310i();
                    return;
                case 4004:
                    this.f3754a.m4661n();
                    C1912n.m7270a().m7310i();
                    return;
                default:
                    return;
            }
        }

        public void careAbout() {
            addMsg(4001);
            addMsg(4002);
            addMsg(4004);
            addMsg(4003);
            addMsg(CommonParams.fk);
            addMsg(CommonParams.fV);
            addMsg(1002);
        }
    }

    public CarlifePresenter(CarlifeView view) {
        this.f3757c = view;
        this.f3756b = new CarlifeModel();
        this.f3763i = view.mo1482e();
        this.f3758d = FragmentManagerCallbackProxy.m4757a();
        this.f3758d.getNaviFragmentManager().setUIListener(view);
        this.f3764j = new C1305a(this, Looper.getMainLooper());
        MsgHandlerCenter.m4460a(this.f3764j);
        m4658k();
    }

    /* renamed from: k */
    private void m4658k() {
        BNVoiceCommandController.getInstance().setAPPVoiceFuncCallback(new APPVoiceFuncCallbackImpl(this, this.f3757c));
        MapVoiceCommandController.getInstance().setCarlifePresenter(this);
        C2398k.m9160a().m9174a(this);
    }

    /* renamed from: a */
    public void m4668a() {
        m4666s();
        m4664q();
        m4673a(false);
    }

    /* renamed from: b */
    public void m4674b() {
        m4666s();
        m4664q();
        m4660m();
    }

    /* renamed from: c */
    public void m4678c() {
        m4666s();
        m4664q();
        m4661n();
    }

    /* renamed from: d */
    public void m4679d() {
        m4664q();
        m4680e();
    }

    /* renamed from: l */
    private void m4659l() {
        LogUtil.d("yftech", "CarlifeActiviy notifyFragmentUpdateForDriving");
        if (FragmentManagerCallbackProxy.m4757a().getNaviFragmentManager() == null) {
            return;
        }
        if (FragmentManagerCallbackProxy.m4757a().getNaviFragmentManager().isDriving()) {
            FragmentManagerCallbackProxy.m4757a().getNaviFragmentManager().driving();
        } else {
            FragmentManagerCallbackProxy.m4757a().getNaviFragmentManager().stopDriving();
        }
    }

    /* renamed from: a */
    public void m4673a(boolean flag) {
        if (flag || !this.f3758d.m4769d(m4683h())) {
            LogUtil.m4428a(HomeFragment.f4452a);
            if (flag) {
                this.f3758d.m4779k();
            } else {
                this.f3758d.showLatestHomeFragment();
            }
            MsgHandlerCenter.m4461b((int) CommonParams.gR);
            m4659l();
        }
    }

    /* renamed from: m */
    private void m4660m() {
        if (m4683h() != 519) {
            LogUtil.m4428a(PhoneFragment.f4685a);
            this.f3758d.showFragment(519, null);
            this.f3757c.updateMainDisplayStatus(4002);
            MsgHandlerCenter.m4461b((int) CommonParams.gR);
            C2342g.m8864e().m8893c();
            C2342g.m8864e().m8894d();
            if (C1663a.m5979a().m5993N() && !CarLifeSettings.m4069a().m4093k()) {
                MsgHandlerCenter.m4453a((int) CommonParams.fV, 200);
            }
        }
    }

    /* renamed from: n */
    private void m4661n() {
        if (!this.f3758d.m4765b(m4683h())) {
            LogUtil.m4428a(C1818h.f5590a);
            MsgHandlerCenter.m4461b((int) CommonParams.gR);
            m4662o();
            this.f3757c.updateMainDisplayStatus(4004);
            if (C1663a.m5979a().m5993N() && this.f3762h) {
                this.f3762h = false;
                m4665r();
            }
        }
    }

    /* renamed from: o */
    private void m4662o() {
        int type = this.f3758d.m4774g().getType();
        this.f3758d.showLatestMusicFragment();
        C1790b dataManager = C1818h.m6730b().m6830r();
        if (type == NaviFragmentManager.TYPE_MUSIC_ALBUMLIST) {
            if (dataManager.m6652v() == 1) {
                this.f3758d.showFragment(NaviFragmentManager.TYPE_MUSIC_PLAYER, null);
            }
        } else if (type == NaviFragmentManager.TYPE_MUSIC_PLAYER && dataManager.m6652v() == 0) {
            this.f3758d.showFragment(NaviFragmentManager.TYPE_MUSIC_ALBUMLIST, null);
        }
    }

    /* renamed from: e */
    public void m4680e() {
        if (m4683h() >= 512) {
            if (CarLifeSettings.m4069a().m4080d()) {
                LogUtil.m4428a("BNRouteGuideFragment");
                if (this.f3758d.m4773f()) {
                    this.f3758d.showLatestNaviFragment();
                } else {
                    if (!this.f3759e) {
                        m4663p();
                    }
                    this.f3758d.showFragment(17, null);
                }
                this.f3757c.updateMainDisplayStatus(4003);
                MsgHandlerCenter.m4461b((int) CommonParams.gR);
                StatisticManager.onEvent(StatisticConstants.MAP_USAGE, StatisticConstants.MAP_BAIDU_MAP);
                m4659l();
                return;
            }
            m4653b("请等待导航初始化成功");
        }
    }

    /* renamed from: a */
    public void m4670a(Bundle bundle) {
        if (m4683h() >= 512) {
            if (CarLifeSettings.m4069a().m4080d()) {
                LogUtil.m4428a("BNRouteGuideFragment");
                if (this.f3758d.m4773f()) {
                    this.f3758d.m4759a(bundle);
                } else {
                    if (!this.f3759e) {
                        m4663p();
                    }
                    this.f3758d.showFragment(17, bundle);
                }
                this.f3757c.updateMainDisplayStatus(4003);
                MsgHandlerCenter.m4461b((int) CommonParams.gR);
                StatisticManager.onEvent(StatisticConstants.MAP_USAGE, StatisticConstants.MAP_BAIDU_MAP);
                m4659l();
                return;
            }
            m4653b("请等待导航初始化成功");
        }
    }

    /* renamed from: p */
    private void m4663p() {
        boolean z = true;
        if (this.f3760f == null) {
            this.f3759e = true;
            this.f3761g = true;
            MapViewFactory.getInstance().getMapView().getController().importMapTheme(17);
            this.f3760f = new MapFragment();
            if (!this.f3760f.isAdded()) {
                FragmentTransaction ft = this.f3758d.getNaviFragmentManager().getFragmentManager().beginTransaction();
                ft.add((int) R.id.map_frame, this.f3760f);
                ft.commitAllowingStateLoss();
            }
            try {
                BNMapController instance = BNMapController.getInstance();
                if (StyleManager.getRealDayStyle()) {
                    z = false;
                }
                instance.setNightMode(z);
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: f */
    public void m4681f() {
        if (this.f3760f != null && this.f3761g) {
            FragmentTransaction ft = this.f3758d.getNaviFragmentManager().getFragmentManager().beginTransaction();
            ft.hide(this.f3760f);
            ft.commitAllowingStateLoss();
            this.f3761g = false;
            LogUtil.d(f3755a, "hideMapFragment");
        }
    }

    /* renamed from: g */
    public void m4682g() {
        if ((BaseFragment.mActivity == null || VERSION.SDK_INT <= 16 || !BaseFragment.mActivity.isDestroyed()) && this.f3760f != null) {
            FragmentTransaction ft = this.f3758d.getNaviFragmentManager().getFragmentManager().beginTransaction();
            ft.show(this.f3760f);
            ft.commitAllowingStateLoss();
            this.f3761g = true;
            LogUtil.d(f3755a, "showMapFragment");
        }
    }

    /* renamed from: q */
    private void m4664q() {
        if (C1663a.m5979a().m5993N()) {
            CarlifeCmdMessage command = new CarlifeCmdMessage(true);
            command.setServiceType(CommonParams.aG);
            C1663a.m5979a().m6017a(Message.obtain(null, command.getServiceType(), 1001, 0, command));
        }
    }

    /* renamed from: r */
    private void m4665r() {
        C1790b qqMusicDataManager = C1818h.m6730b().m6815h(1);
        if (qqMusicDataManager != null && qqMusicDataManager.m6654x() == 1) {
            qqMusicDataManager.mo1655b(false);
        }
    }

    /* renamed from: s */
    private void m4666s() {
        if (BNavigator.getInstance().isNaviBegin() && RGMapModeViewController.getInstance().ismIsShowColladaView()) {
            RGMapModeViewController.getInstance().setmIsShowColladaView(false);
            RouteGuideFSM.getInstance().run(FsmEvent.MSG_COLLADA_HIDE);
            RGViewController.getInstance().resetColladaView();
        }
    }

    /* renamed from: h */
    public int m4683h() {
        return this.f3758d.getCurrentFragmentType();
    }

    /* renamed from: b */
    private void m4653b(String msg) {
        C2201w.m8372a(msg);
    }

    /* renamed from: a */
    public void m4669a(int type, Bundle bundle) {
        this.f3758d.showFragment(type, bundle);
    }

    /* renamed from: b */
    public void m4675b(final int type, final Bundle bundle) {
        if (!this.f3758d.isCarlifeFragment(type)) {
            if (type == NaviFragmentManager.TYPE_OFFLINE_DATA || type == 81 || type == 304) {
                int msg = R.string.dialog_quit_naviing_to_favorite;
                if (type == NaviFragmentManager.TYPE_OFFLINE_DATA) {
                    msg = R.string.dialog_quit_naviing_to_data;
                } else if (type == 304) {
                    msg = R.string.dialog_quit_naviing_to_favorite_dest;
                }
                if (BNavigator.getInstance().isNaviBegin()) {
                    C1953c commonDialog = new C1953c(this.f3763i).m7435a(msg).m7447c((int) R.string.alert_confirm).m7450d((int) R.string.alert_cancel);
                    commonDialog.m7438a(new OnBtnClickListener(this) {
                        /* renamed from: c */
                        final /* synthetic */ CarlifePresenter f3749c;

                        public void onClick() {
                            this.f3749c.m4680e();
                            if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
                                BaiduNaviSDKManager.getInstance().quitNavi();
                            }
                            if (this.f3749c.f3758d.getCurrentFragmentType() != type) {
                                this.f3749c.f3758d.showFragment(type, bundle);
                            }
                        }
                    });
                    this.f3757c.showDialog(commonDialog, C1265a.Center);
                    return;
                }
                m4680e();
                if (this.f3758d.getCurrentFragmentType() != type) {
                    if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
                        BaiduNaviSDKManager.getInstance().quitCruise();
                    }
                    this.f3758d.showFragment(type, bundle);
                    return;
                }
                return;
            }
            m4680e();
            if (this.f3758d.getCurrentFragmentType() != type) {
                this.f3758d.showFragment(type, bundle);
            }
        }
    }

    /* renamed from: a */
    public void m4671a(CarLifeSearchPoi cPoi) {
        m4646a(cPoi, true);
    }

    /* renamed from: b */
    public void m4676b(CarLifeSearchPoi cPoi) {
        m4646a(cPoi, false);
    }

    /* renamed from: a */
    private void m4646a(CarLifeSearchPoi cPoi, boolean isAllways) {
        if (CarLifeSettings.m4069a().m4080d()) {
            if (!this.f3759e) {
                m4663p();
            }
            final SearchPoi poi = new SearchPoi();
            poi.mGuidePoint = CoordinateTransformUtil.transferBD09ToGCJ02(cPoi.m4505a(), cPoi.m4506b());
            if (isAllways || !BNavigator.getInstance().isNaviBegin()) {
                m4650a(poi);
                return;
            }
            C1953c commonDialog = new C1953c(this.f3763i).m7435a((int) R.string.dialog_quit_naviing_to_navi).m7447c((int) R.string.alert_confirm).m7450d((int) R.string.alert_cancel);
            commonDialog.m7438a(new OnBtnClickListener(this) {
                /* renamed from: b */
                final /* synthetic */ CarlifePresenter f3751b;

                public void onClick() {
                    this.f3751b.m4650a(poi);
                }
            });
            this.f3757c.showDialog(commonDialog, C1265a.Center);
            return;
        }
        m4653b("请等待导航初始化成功");
    }

    /* renamed from: a */
    private void m4650a(SearchPoi poi) {
        m4680e();
        if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
            BaiduNaviSDKManager.getInstance().quitNavi();
        } else if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
            BaiduNaviSDKManager.getInstance().quitCruise();
        } else if (BCruiser.getInstance().isCruiseBegin()) {
            EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
        }
        m4680e();
        this.f3758d.backTo(17, null);
        NavPoiController.getInstance().startCalcRoute(poi);
    }

    /* renamed from: a */
    public void m4672a(final String key) {
        if (CarLifeSettings.m4069a().m4080d()) {
            if (!this.f3759e) {
                m4663p();
            }
            if (BNavigator.getInstance().isNaviBegin()) {
                C1953c commonDialog = new C1953c(this.f3763i).m7435a((int) R.string.dialog_quit_naviing).m7447c((int) R.string.alert_confirm).m7450d((int) R.string.alert_cancel);
                commonDialog.m7438a(new OnBtnClickListener(this) {
                    /* renamed from: b */
                    final /* synthetic */ CarlifePresenter f3753b;

                    public void onClick() {
                        this.f3753b.m4680e();
                        if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
                            BaiduNaviSDKManager.getInstance().quitNavi();
                        }
                        this.f3753b.m4655c(key);
                    }
                });
                this.f3757c.showDialog(commonDialog, C1265a.Center);
                return;
            }
            m4680e();
            if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
                BaiduNaviSDKManager.getInstance().quitCruise();
            }
            m4655c(key);
            return;
        }
        m4653b("请等待导航初始化成功");
    }

    /* renamed from: c */
    private void m4655c(String key) {
        if (!TextUtils.isEmpty(key)) {
            this.f3758d.backTo(17, null);
            Bundle bundle = new Bundle();
            bundle.putInt("incoming_type", 3);
            bundle.putString(NameSearchFragment.VOICE_SEARCH_KEY, key);
            bundle.putBoolean("poi_center_mode", true);
            bundle.putInt(ContentFragmentManager.MODULE_FROM, 1);
            if (ActionTypeSearchParams.Gas_Station.equals(key)) {
                bundle.putInt(NameSearchFragment.COME_FROM, 8);
            }
            this.f3758d.showFragment(34, bundle);
        }
    }

    /* renamed from: i */
    public int m4684i() {
        return this.f3758d.m4768d();
    }

    /* renamed from: j */
    public void m4685j() {
        this.f3758d.showFragment(m4683h(), null);
    }

    /* renamed from: b */
    public void m4677b(boolean dayStyle) {
        if (this.f3760f != null) {
            this.f3760f.updateStyle(dayStyle);
        }
    }

    /* renamed from: t */
    private void m4667t() {
        C1953c btTipDialog = new C1953c(this.f3763i).m7442b((int) R.string.phone_dialog_bt_title).m7435a((int) R.string.phone_dialog_bt_content).m7447c((int) R.string.alert_close).m7458q().m7455f(1);
        List<BluetoothDevice> deviceList = BtManager.m3470a().m3532j();
        if (deviceList == null || deviceList.size() == 0) {
            CarLifeSettings.m4069a().m4087h(true);
            this.f3757c.showDialog(btTipDialog);
            StatisticManager.onEvent(StatisticConstants.PHONE_001);
        }
    }
}
