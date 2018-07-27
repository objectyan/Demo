package me.objectyan.screensharing.core.screen.presentation.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import me.objectyan.screensharing.core.CarLifeSettings;
import me.objectyan.screensharing.core.CommonParams;
import me.objectyan.screensharing.core.LogUtil;
import me.objectyan.screensharing.core.MsgBaseHandler;
import me.objectyan.screensharing.core.MsgHandlerCenter;
import me.objectyan.screensharing.core.connect.CarlifeCmdMessage;
import me.objectyan.screensharing.core.screen.CarLifeSearchPoi;
import me.objectyan.screensharing.core.screen.presentation.FragmentManagerCallbackProxy;
import me.objectyan.screensharing.util.CarlifeCoreSDK;


public class CarlifePresenter {

    private static final String Tag = "CarlifePresenter";

    private IModel mIModel;

    private CarlifeView mCarlifeView;

    private FragmentManagerCallbackProxy mFragmentManagerCallbackProxy;

    private boolean f3759e = false;

//    private MapFragment f3760f;

    private boolean f3761g = false;

    private boolean f3762h = true;

    private Context f3763i;

    private CarlifePresenterHandler mCarlifePresenterHandler;


    private class CarlifePresenterHandler extends MsgBaseHandler {

        final  CarlifePresenter mCarlifePresenter;

        public CarlifePresenterHandler(CarlifePresenter carlifePresenter, Looper looper) {
            super(looper);
            this.mCarlifePresenter = carlifePresenter;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1002:
                    this.mCarlifePresenter.f3762h = true;
                    return;
                case 1038:
                    this.mCarlifePresenter.mCarlifeView.mo1483f();
                    return;
                case 2029:
                    Log.d(CarlifePresenter.Tag, "MSG_TELE_BT_DISCONNECT");
                    this.mCarlifePresenter.firmwareUpdateDialog();
                    return;
                case 4001:
                    if (msg.arg1 == CommonParams.iy) {
                        this.mCarlifePresenter.m4673a(true);
                    } else {
                        this.mCarlifePresenter.m4673a(false);
                    }
//                    C1912n.m7270a().m7310i();
                    return;
                case 4002:
                    this.mCarlifePresenter.m4660m();
//                    C1912n.m7270a().m7310i();
                    return;
                case 4003:
                    this.mCarlifePresenter.initNavi1();
//                    C1912n.m7270a().m7310i();
                    return;
                case 4004:
                    this.mCarlifePresenter.m4661n();
//                    C1912n.m7270a().m7310i();
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
            addMsg(1038);
            addMsg(2029);
            addMsg(1002);
        }
    }

    public CarlifePresenter(CarlifeView view) {
        this.mCarlifeView = view;
        this.mIModel = new CarlifeModel();
        this.f3763i = view.mo1482e();
        this.mFragmentManagerCallbackProxy = FragmentManagerCallbackProxy.m4757a();
//        this.mFragmentManagerCallbackProxy.getNaviFragmentManager().setUIListener(view);
        this.mCarlifePresenterHandler = new CarlifePresenterHandler(this, Looper.getMainLooper());
        MsgHandlerCenter.registerMessageHandler(this.mCarlifePresenterHandler);
//        m4658k();
    }


    private void m4658k() {
//        BNVoiceCommandController.getInstance().setAPPVoiceFuncCallback(new APPVoiceFuncCallbackImpl(this, this.mCarlifeView));
//        MapVoiceCommandController.getInstance().setCarlifePresenter(this);
//        C2398k.m9160a().m9174a(this);
    }


    public void m4668a() {
        m4666s();
        m4664q();
        m4673a(false);
    }


    public void m4674b() {
        m4666s();
        m4664q();
        m4660m();
    }


    public void m4678c() {
        m4666s();
        m4664q();
        m4661n();
    }


    public void m4679d() {
        m4664q();
        initNavi1();
    }


    private void notifyFragmentUpdateForDriving() {
//        Log.d("yftech", "CarlifeActiviy notifyFragmentUpdateForDriving");
//        if (FragmentManagerCallbackProxy.m4757a().getNaviFragmentManager() == null) {
//            return;
//        }
//        if (FragmentManagerCallbackProxy.m4757a().getNaviFragmentManager().isDriving()) {
//            FragmentManagerCallbackProxy.m4757a().getNaviFragmentManager().driving();
//        } else {
//            FragmentManagerCallbackProxy.m4757a().getNaviFragmentManager().stopDriving();
//        }
    }


    public void m4673a(boolean flag) {
//        if (flag || !this.mFragmentManagerCallbackProxy.m4769d(getCurrentFragmentType())) {
////            LogUtil.m4428a(HomeFragment.f4452a);
//            if (flag) {
////                this.mFragmentManagerCallbackProxy.m4779k();
//            } else {
//                this.mFragmentManagerCallbackProxy.showLatestHomeFragment();
//            }
//            MsgHandlerCenter.dispatchMessage((int) 4022);
//            notifyFragmentUpdateForDriving();
//        }
    }


    private void m4660m() {
        if (getCurrentFragmentType() != 519) {
//            LogUtil.m4428a(PhoneFragment.f4685a);
            this.mFragmentManagerCallbackProxy.showFragment(519, null);
            this.mCarlifeView.updateMainDisplayStatus(4002);
            MsgHandlerCenter.dispatchMessage((int) CommonParams.gR);
//            C2342g.m8864e().m8893c();
//            C2342g.m8864e().m8894d();
            if (CarlifeCoreSDK.newInstance().getISConn() && !CarLifeSettings.m4069a().m4093k()) {
                MsgHandlerCenter.dispatchMessageDelay((int) CommonParams.fV, 200);
            }
        }
    }


    private void m4661n() {
//        if (!this.mFragmentManagerCallbackProxy.m4765b(getCurrentFragmentType())) {
////            LogUtil.m4428a(C1818h.f5590a);
//            MsgHandlerCenter.dispatchMessage((int) CommonParams.gR);
//            m4662o();
//            this.mCarlifeView.updateMainDisplayStatus(4004);
//            if (CarlifeCoreSDK.newInstance().getISConn() && this.f3762h) {
//                this.f3762h = false;
//                m4665r();
//            }
//        }
    }


    private void m4662o() {
//        int type = this.mFragmentManagerCallbackProxy.m4774g().getType();
//        this.mFragmentManagerCallbackProxy.showLatestMusicFragment();
//        C1790b dataManager = C1818h.m6730b().m6830r();
//        if (type == NaviFragmentManager.TYPE_MUSIC_ALBUMLIST) {
//            if (dataManager.m6652v() == 1) {
//                this.mFragmentManagerCallbackProxy.showFragment(NaviFragmentManager.TYPE_MUSIC_PLAYER, null);
//            }
//        } else if (type == NaviFragmentManager.TYPE_MUSIC_PLAYER && dataManager.m6652v() == 0) {
//            this.mFragmentManagerCallbackProxy.showFragment(NaviFragmentManager.TYPE_MUSIC_ALBUMLIST, null);
//        }
    }


    public void initNavi1() {
        if (getCurrentFragmentType() >= 512) {
            if (CarLifeSettings.m4069a().m4080d()) {
                LogUtil.m4428a("BNRouteGuideFragment");
//                if (this.mFragmentManagerCallbackProxy.m4773f()) {
//                    this.mFragmentManagerCallbackProxy.showLatestNaviFragment();
//                } else {
//                    if (!this.f3759e) {
//                        m4663p();
//                    }
//                    this.mFragmentManagerCallbackProxy.showFragment(17, null);
//                }
                this.mCarlifeView.updateMainDisplayStatus(4003);
                MsgHandlerCenter.dispatchMessage(4022);
//                StatisticManager.onEvent(StatisticConstants.MAP_USAGE, StatisticConstants.MAP_BAIDU_MAP);
                notifyFragmentUpdateForDriving();
                return;
            }
            m4653b("请等待导航初始化成功");
        }
    }


    public void initNavi(Bundle bundle) {
        if (getCurrentFragmentType() >= 512) {
            if (CarLifeSettings.m4069a().m4080d()) {
                LogUtil.m4428a("BNRouteGuideFragment");
//                if (this.mFragmentManagerCallbackProxy.m4773f()) {
//                    this.mFragmentManagerCallbackProxy.m4759a(bundle);
//                } else {
//                    if (!this.f3759e) {
//                        m4663p();
//                    }
//                    this.mFragmentManagerCallbackProxy.showFragment(17, bundle);
//                }
                this.mCarlifeView.updateMainDisplayStatus(4003);
                MsgHandlerCenter.dispatchMessage((int) CommonParams.gR);
//                StatisticManager.onEvent(StatisticConstants.MAP_USAGE, StatisticConstants.MAP_BAIDU_MAP);
                notifyFragmentUpdateForDriving();
                return;
            }
            m4653b("请等待导航初始化成功");
        }
    }


    private void m4663p() {
//        boolean z = true;
//        if (this.f3760f == null) {
//            this.f3759e = true;
//            this.f3761g = true;
//            MapViewFactory.getInstance().getMapView().getController().importMapTheme(17);
//            this.f3760f = new MapFragment();
//            if (!this.f3760f.isAdded()) {
//                FragmentTransaction ft = this.mFragmentManagerCallbackProxy.getNaviFragmentManager().getFragmentManager().beginTransaction();
//                ft.add((int) R.id.map_frame, this.f3760f);
//                ft.commitAllowingStateLoss();
//            }
//            try {
//                BNMapController instance = BNMapController.getInstance();
//                if (StyleManager.getRealDayStyle()) {
//                    z = false;
//                }
//                instance.setNightMode(z);
//            } catch (Exception e) {
//            }
//        }
    }


    public void hideMapFragment() {
//        if (this.f3760f != null && this.f3761g) {
//            FragmentTransaction ft = this.mFragmentManagerCallbackProxy.getNaviFragmentManager().getFragmentManager().beginTransaction();
////            ft.hide(this.f3760f);
//            ft.commitAllowingStateLoss();
//            this.f3761g = false;
//            Log.d(Tag, "hideMapFragment");
//        }
    }


    public void showMapFragment() {
//        if ((BaseFragment.mActivity == null || VERSION.SDK_INT <= 16 || !BaseFragment.mActivity.isDestroyed()) && this.f3760f != null) {
//            FragmentTransaction ft = this.mFragmentManagerCallbackProxy.getNaviFragmentManager().getFragmentManager().beginTransaction();
//            ft.show(this.f3760f);
//            ft.commitAllowingStateLoss();
//            this.f3761g = true;
//            Log.d(Tag, "showMapFragment");
//        }
    }


    private void m4664q() {
        if (CarlifeCoreSDK.newInstance().getISConn()) {
            CarlifeCmdMessage command = new CarlifeCmdMessage(true);
            command.setServiceType(CommonParams.aG);
            CarlifeCoreSDK.newInstance().sendMsgToService(Message.obtain(null, command.getServiceType(), 1001, 0, command));
        }
    }


    private void m4665r() {
//        C1790b qqMusicDataManager = C1818h.m6730b().m6815h(1);
//        if (qqMusicDataManager != null && qqMusicDataManager.m6654x() == 1) {
//            qqMusicDataManager.mo1655b(false);
//        }
    }


    private void m4666s() {
//        if (BNavigator.getInstance().isNaviBegin() && RGMapModeViewController.getInstance().ismIsShowColladaView()) {
//            RGMapModeViewController.getInstance().setmIsShowColladaView(false);
//            RouteGuideFSM.getInstance().run(FsmEvent.MSG_COLLADA_HIDE);
//            RGViewController.getInstance().resetColladaView();
//        }
    }


    public int getCurrentFragmentType() {
        return this.mFragmentManagerCallbackProxy.getCurrentFragmentType();
    }


    private void m4653b(String msg) {
//        C2201w.m8372a(msg);
    }


    public void showFragment(int type, Bundle bundle) {
        this.mFragmentManagerCallbackProxy.showFragment(type, bundle);
    }


    public void m4675b(final int type, final Bundle bundle) {
        if (!this.mFragmentManagerCallbackProxy.isCarlifeFragment(type)) {
//            if (type == NaviFragmentManager.TYPE_OFFLINE_DATA || type == 81 || type == 304) {
//                int msg = R.string.dialog_quit_naviing_to_favorite;
//                if (type == NaviFragmentManager.TYPE_OFFLINE_DATA) {
//                    msg = R.string.dialog_quit_naviing_to_data;
//                } else if (type == 304) {
//                    msg = R.string.dialog_quit_naviing_to_favorite_dest;
//                }
//                if (BNavigator.getInstance().isNaviBegin()) {
//                    C1953c commonDialog = new C1953c(this.f3763i).m7435a(msg).m7447c((int) R.string.alert_confirm).m7450d((int) R.string.alert_cancel);
//                    commonDialog.m7438a(new OnBtnClickListener(this) {
//
//                        final  CarlifePresenter f3749c;
//
//                        public void onClick() {
//                            this.f3749c.initNavi1();
//                            if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
//                                BaiduNaviSDKManager.getInstance().quitNavi();
//                            }
//                            if (this.f3749c.mFragmentManagerCallbackProxy.getCurrentFragmentType() != type) {
//                                this.f3749c.mFragmentManagerCallbackProxy.showFragment(type, bundle);
//                            }
//                        }
//                    });
//                    this.mCarlifeView.showDialog(commonDialog, C1265a.Center);
//                    return;
//                }
//                initNavi1();
//                if (this.mFragmentManagerCallbackProxy.getCurrentFragmentType() != type) {
//                    if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
//                        BaiduNaviSDKManager.getInstance().quitCruise();
//                    }
//                    this.mFragmentManagerCallbackProxy.showFragment(type, bundle);
//                    return;
//                }
//                return;
//            }
            initNavi1();
            if (this.mFragmentManagerCallbackProxy.getCurrentFragmentType() != type) {
                this.mFragmentManagerCallbackProxy.showFragment(type, bundle);
            }
        }
    }


    public void m4671a(CarLifeSearchPoi cPoi) {
        m4646a(cPoi, true);
    }


    public void m4676b(CarLifeSearchPoi cPoi) {
        m4646a(cPoi, false);
    }


    private void m4646a(CarLifeSearchPoi cPoi, boolean isAllways) {
//        if (CarLifeSettings.m4069a().m4080d()) {
//            if (!this.f3759e) {
//                m4663p();
//            }
//            final SearchPoi poi = new SearchPoi();
//            poi.mGuidePoint = CoordinateTransformUtil.transferBD09ToGCJ02(cPoi.m4505a(), cPoi.m4506b());
//            if (isAllways || !BNavigator.getInstance().isNaviBegin()) {
//                m4650a(poi);
//                return;
//            }
//            C1953c commonDialog = new C1953c(this.f3763i).m7435a((int) R.string.dialog_quit_naviing_to_navi).m7447c((int) R.string.alert_confirm).m7450d((int) R.string.alert_cancel);
//            commonDialog.m7438a(new OnBtnClickListener(this) {
//
//                final  CarlifePresenter f3751b;
//
//                public void onClick() {
//                    this.f3751b.m4650a(poi);
//                }
//            });
//            this.mCarlifeView.showDialog(commonDialog, C1265a.Center);
//            return;
//        }
        m4653b("请等待导航初始化成功");
    }


//    private void m4650a(SearchPoi poi) {
//        initNavi1();
//        if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
//            BaiduNaviSDKManager.getInstance().quitNavi();
//        } else if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
//            BaiduNaviSDKManager.getInstance().quitCruise();
//        } else if (BCruiser.getInstance().isCruiseBegin()) {
//            EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
//        }
//        initNavi1();
//        this.mFragmentManagerCallbackProxy.backTo(17, null);
//        NavPoiController.getInstance().startCalcRoute(poi);
//    }


    public void m4672a(final String key) {
//        if (CarLifeSettings.m4069a().m4080d()) {
//            if (!this.f3759e) {
//                m4663p();
//            }
//            if (BNavigator.getInstance().isNaviBegin()) {
//                C1953c commonDialog = new C1953c(this.f3763i).m7435a((int) R.string.dialog_quit_naviing).m7447c((int) R.string.alert_confirm).m7450d((int) R.string.alert_cancel);
//                commonDialog.m7438a(new OnBtnClickListener(this) {
//
//                    final  CarlifePresenter f3753b;
//
//                    public void onClick() {
//                        this.f3753b.initNavi1();
//                        if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
//                            BaiduNaviSDKManager.getInstance().quitNavi();
//                        }
//                        this.f3753b.m4655c(key);
//                    }
//                });
//                this.mCarlifeView.showDialog(commonDialog, C1265a.Center);
//                return;
//            }
//            initNavi1();
//            if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
//                BaiduNaviSDKManager.getInstance().quitCruise();
//            }
//            m4655c(key);
//            return;
//        }
        m4653b("请等待导航初始化成功");
    }


    private void m4655c(String key) {
        if (!TextUtils.isEmpty(key)) {
            this.mFragmentManagerCallbackProxy.backTo(17, null);
            Bundle bundle = new Bundle();
//            bundle.putInt("incoming_type", 3);
//            bundle.putString("voice_key", key);
//            bundle.putBoolean("poi_center_mode", true);
//            bundle.putInt("module_from", 1);
//            if (ActionTypeSearchParams.Gas_Station.equals(key)) {
//                bundle.putInt(NameSearchFragment.COME_FROM, 8);
//            }
            this.mFragmentManagerCallbackProxy.showFragment(34, bundle);
        }
    }


    public int m4684i() {
        return 0;//this.mFragmentManagerCallbackProxy.m4768d();
    }


    public void showFragment() {
        this.mFragmentManagerCallbackProxy.showFragment(getCurrentFragmentType(), null);
    }


    public void m4677b(boolean dayStyle) {
//        if (this.f3760f != null) {
//            this.f3760f.updateStyle(dayStyle);
//        }
    }


    private void firmwareUpdateDialog() {
//        C1953c btTipDialog = new C1953c(this.f3763i).m7442b((int) R.string.phone_dialog_bt_title).m7435a((int) R.string.phone_dialog_bt_content).m7447c((int) R.string.alert_close).m7458q().m7455f(1);
//        List<BluetoothDevice> deviceList = BtManager.m3470a().m3532j();
//        if (deviceList == null || deviceList.size() == 0) {
//            CarLifeSettings.m4069a().m4087h(true);
//            this.mCarlifeView.showDialog(btTipDialog);
//            StatisticManager.onEvent(StatisticConstants.PHONE_001);
//        }
    }
}
