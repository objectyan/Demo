package com.baidu.baidunavis.control;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.baidu.android.common.util.CommonParam;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.model.NavGeoPoint;
import com.baidu.baidunavis.model.NavModelHelper;
import com.baidu.baidunavis.model.NavRoutePlanModel;
import com.baidu.baidunavis.model.RouteNode;
import com.baidu.baidunavis.stat.NavUserBehaviour;
import com.baidu.baidunavis.stat.NavUserBehaviourDef;
import com.baidu.baidunavis.stat.NavUserBehaviourDef.NavUserBehaviourNaviAction;
import com.baidu.baidunavis.stat.NavUserBehaviourDef.NavUserBehaviourNaviEnter;
import com.baidu.baidunavis.stat.NavUserBehaviourDef.NavUserBehaviourNaviNet;
import com.baidu.baidunavis.ui.BNCruiserFragment;
import com.baidu.baidunavis.ui.BNRouteGuideFragment;
import com.baidu.baidunavis.ui.NavFragmentManager;
import com.baidu.baidunavis.ui.widget.BNLoadingView;
import com.baidu.baidunavis.ui.widget.NavTipTool;
import com.baidu.baidunavis.wrapper.LogUtil;
import com.baidu.baidunavis.wrapper.NaviEngineInitListener;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.MainActivity;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.radio.p079c.C2142b;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.cruise.BCruiser;
import com.baidu.navisdk.ui.cruise.BCruiserConfig;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.BNavigator$NavUserBehaviourCallback;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.ugc.control.BNRCEventDetailsViewController;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNLoadingViewProxy.LoadingProxy;
import com.baidu.navisdk.ui.widget.BNLoadingViewProxy.ViewActionListener;
import com.baidu.navisdk.ui.widget.RoutePlanObserver;
import com.baidu.navisdk.ui.widget.RoutePlanObserver.IJumpToDownloadListener;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.loop.BNMainLooperHandler;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.C2907c;
import java.util.ArrayList;
import java.util.List;

public class NavRouteGuideController {
    public static final int MSG_PRELOAD_ROUTEGUIDE_VIEW = 1;
    public static final String TAG = NavRouteGuideController.class.getSimpleName();
    private static NavRouteGuideController sInstance = null;
    private Boolean hasSetPreference = Boolean.valueOf(false);
    private BNavigatorListener mBNavigatorListener = null;
    private Handler mHandler = new C08358();
    private boolean mIsThirdServer = false;
    private LoadingProxy mLoadingProxy;
    private BNLoadingView mLoadingView;
    private BNavigator$NavUserBehaviourCallback mNavUserBehaviourCallback = new C08262();
    private boolean mNewGuideIsThirdServer = false;
    private int mRouteGuideLocateMode = 1;
    private int mRouteGuidePreference = 1;
    private RoutePlanObserver mRoutePlanObserver = null;

    /* renamed from: com.baidu.baidunavis.control.NavRouteGuideController$1 */
    class C08231 implements Runnable {
        C08231() {
        }

        public void run() {
            try {
                RGViewController.getInstance().preloadViews(NavCommonFuncModel.getInstance().getActivity());
            } catch (Throwable e) {
                LogUtil.m3004e("onRoutePlan", "system.err preloadRouteGuideView err:" + e.getMessage());
            }
        }
    }

    /* renamed from: com.baidu.baidunavis.control.NavRouteGuideController$2 */
    class C08262 implements BNavigator$NavUserBehaviourCallback {

        /* renamed from: com.baidu.baidunavis.control.NavRouteGuideController$2$1 */
        class C08251 implements LoadingProxy {
            C08251() {
            }

            public void onLoadingStart(int type, ViewGroup container) {
                if (type == 1) {
                    RGMapModeViewController.getInstance().showUgcDetailViewShowProgressDialog();
                } else if (container != null) {
                    container.removeAllViews();
                    LayoutParams params = new LayoutParams(-1, -1);
                    NavRouteGuideController.this.mLoadingView = new BNLoadingView(NavCommonFuncModel.getInstance().getActivity());
                    NavRouteGuideController.this.mLoadingView.resetBottomLoadtab(1);
                    container.addView(NavRouteGuideController.this.mLoadingView, params);
                }
            }

            public void onLoadingEnd(int type, boolean success, ViewGroup container, final ViewActionListener viewActionListener) {
                if (type == 1) {
                    RGMapModeViewController.getInstance().dismissUgcDetailViewShowProgressDialog();
                } else if (!success && NavRouteGuideController.this.mLoadingView != null) {
                    NavRouteGuideController.this.mLoadingView.resetBottomLoadtab(3);
                    NavRouteGuideController.this.mLoadingView.setLoadFailAction("加载失败, ", new OnClickListener() {
                        public void onClick(View v) {
                            viewActionListener.onAction(1);
                        }
                    });
                }
            }

            public View getLoadingView() {
                if (NavRouteGuideController.this.mLoadingView == null) {
                    NavRouteGuideController.this.mLoadingView = new BNLoadingView(NavCommonFuncModel.getInstance().getActivity());
                    NavRouteGuideController.this.mLoadingView.resetBottomLoadtab(1);
                }
                return NavRouteGuideController.this.mLoadingView;
            }
        }

        C08262() {
        }

        public void onRoutePlan() {
            LogUtil.m3004e("onRoutePlan", "NavUserBehaviourCallback   onRoutePlan====");
            BaiduNaviManager.getInstance().sendNaviStatistics(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), NavUserBehaviourNaviAction.BEHAVIOUR_NAVI_ACTION_RPLAN, NavRoutePlanModel.getInstance().getmNavEnter());
        }

        public void onYawing() {
            LogUtil.m3004e("onYawing", "NavUserBehaviourCallback   onYawing====");
            BaiduNaviManager.getInstance().sendNaviStatistics(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), NavUserBehaviourNaviAction.BEHAVIOUR_NAVI_ACTION_YAW, NavRoutePlanModel.getInstance().getmNavEnter());
        }

        public void onShowMenu() {
            LogUtil.m3004e("onShowMenu", "NavUserBehaviourCallback   onShowMenu====");
            BaiduNaviManager.getInstance().sendNaviStatistics(null, null, NavUserBehaviourNaviAction.BEHAVIOUR_NAVI_ACTION_SET, NavUserBehaviourNaviEnter.BEHAVIOUR_NAVI_ENTER_NAVING_SET);
        }

        public boolean onFellowCreateLCS() {
            LogUtil.m3004e("onFellowCreateLCS", "NavUserBehaviourCallback   onFellowCreateLCS====");
            return NavLongLinkController.getInstance().createLCS();
        }

        public boolean onFellowCloseLCS() {
            LogUtil.m3004e("onFellowCloseLCS", "NavUserBehaviourCallback   onFellowCloseLCS====");
            return NavLongLinkController.getInstance().CloseLCS();
        }

        public Bundle onFellowSendData(int reqId, byte[] data, String queryStr, String fileName) {
            LogUtil.m3004e("onFellowSendData", "NavUserBehaviourCallback   onFellowSendData====");
            return NavLongLinkController.getInstance().SendData(reqId, data, queryStr, fileName);
        }

        public boolean onFellowRegisterLCS() {
            LogUtil.m3004e("onFellowRegisterLCS", "NavUserBehaviourCallback   onFellowRegisterLCS====");
            return NavLongLinkController.getInstance().registerLCS();
        }

        public boolean onFellowUnregisterLCS() {
            LogUtil.m3004e("onFellowUnregisterLCS", "NavUserBehaviourCallback   onFellowUnregisterLCS====");
            return NavLongLinkController.getInstance().unRegisterLCS();
        }

        public int onFellowGetReqId() {
            LogUtil.m3004e("onFellowGetReqId", "NavUserBehaviourCallback   onFellowGetReqId====");
            return NavLongLinkController.getInstance().GetReqId();
        }

        public void onUgcPageShow(int pageType, String urlStr) {
            LogUtil.m3004e("onUgcPageShow", "pageType urlStr " + pageType + " " + urlStr);
        }

        public void onCarLogoPageShow() {
            NavMapAdapter.getInstance().navigateToCarLogoPage();
        }

        public boolean isShouldShowNaviResult() {
            int ret = NavTrajectoryController.getInstance().endRecord(((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).getEndName(NavCommonFuncModel.getInstance().getActivity(), true), true, 1);
            UserOPController.getInstance().add(UserOPParams.RECORD_END_8_2_2, "1", "" + ret, null);
            if (ret == 0) {
                return true;
            }
            return false;
        }

        public void registerLoadingProxy() {
            NavRouteGuideController.this.mLoadingProxy = new C08251();
            BNRCEventDetailsViewController.getInstance().setLoadingProxy(NavRouteGuideController.this.mLoadingProxy);
        }

        public void unRegisterLoadingProxy() {
            BNRCEventDetailsViewController.getInstance().setLoadingProxy(null);
            NavRouteGuideController.this.mLoadingProxy = null;
            NavRouteGuideController.this.mLoadingView = null;
        }
    }

    /* renamed from: com.baidu.baidunavis.control.NavRouteGuideController$3 */
    class C08273 implements IJumpToDownloadListener {
        C08273() {
        }

        public void onJumpToDownloadOfflineData() {
            BaiduNaviManager.getInstance().launchDownloadActivity(NavMapAdapter.getInstance().getContext(), null);
        }
    }

    /* renamed from: com.baidu.baidunavis.control.NavRouteGuideController$5 */
    class C08295 implements IJumpToDownloadListener {
        C08295() {
        }

        public void onJumpToDownloadOfflineData() {
            BaiduNaviManager.getInstance().launchDownloadActivity(NavMapAdapter.getInstance().getContext(), null);
        }
    }

    /* renamed from: com.baidu.baidunavis.control.NavRouteGuideController$7 */
    class C08347 implements NaviEngineInitListener {
        C08347() {
        }

        public void engineInitSuccess() {
            LogUtil.m3004e("SDKHelper", "engineInitSuccess");
            BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("InitBESuc-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    NavMapAdapter.getInstance().dismissMProgressDialog();
                    BaiduNaviManager.getInstance().launchNavigator(BNaviModuleManager.getActivity(), new NavGeoPoint(11394118, 2254282), RoutePlanParams.MY_LOCATION, new NavGeoPoint(11396185, 2256679), "地图上的点", 1, true, 2);
                    return null;
                }
            }, new BNWorkerConfig(100, 0));
        }

        public void engineInitStart() {
            BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("InitBEStart-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    return null;
                }
            }, new BNWorkerConfig(100, 0));
        }

        public void engineInitFail() {
            BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("InitBEFail-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    NavMapAdapter.getInstance().showMToast(C2907c.m10977f(), (int) C0965R.string.nav_can_not_use);
                    NavMapAdapter.getInstance().dismissMProgressDialog();
                    return null;
                }
            }, new BNWorkerConfig(100, 0));
        }
    }

    /* renamed from: com.baidu.baidunavis.control.NavRouteGuideController$8 */
    class C08358 extends BNMainLooperHandler {
        C08358() {
        }

        public void onMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    RGViewController.getInstance().preloadViews(NavCommonFuncModel.getInstance().getActivity());
                    return;
                default:
                    return;
            }
        }
    }

    public interface BNavigatorListener {
        void onPageJump(int i, Object obj);
    }

    private NavRouteGuideController() {
    }

    public static NavRouteGuideController getInstance() {
        if (sInstance == null) {
            sInstance = new NavRouteGuideController();
        }
        return sInstance;
    }

    public void setNavUserBehaviourCallback() {
        BNavigator.getInstance().setmNavUserBehaviourCallback(this.mNavUserBehaviourCallback);
    }

    public void UnSetNavUserBehaviourCallback() {
        BNavigator.getInstance().setmNavUserBehaviourCallback(null);
    }

    public void setLocateMode(int locateMode) {
        this.mRouteGuideLocateMode = locateMode;
    }

    public int getLocateMode() {
        return this.mRouteGuideLocateMode;
    }

    public void preloadRouteGuideView() {
        CommonHandlerThread.getInstance().getHandler().post(new C08231());
    }

    public void releasePreloadRouteGuideView() {
        RGMapModeViewController.getInstance().releasePreloadSubViews();
    }

    public boolean startRouteGuideView(boolean isFromNavActivity, Bundle bundle) {
        Activity activity = NavCommonFuncModel.getInstance().getActivity();
        if (!(isFromNavActivity || activity == null)) {
            NavMapAdapter.getInstance().purgeMapDataForNavi(activity);
        }
        if (activity == null || BaiduNaviManager.getInstance().hasGPSPermission(activity)) {
            try {
                if (PerformStatItem.sUserTest) {
                    PerformStatisticsController.peByType(0, "ad_start_show_routeguide", System.currentTimeMillis());
                    PerformStatItem.sPoiToNaviTime10 = System.currentTimeMillis();
                    PerformStatisticsController.getInstance().addTimeLogForPoiGoToNavi(C2142b.f6818b, PerformStatItem.PoiToNaviStep10, PerformStatItem.NAVI_MODULE_NAME, PerformStatItem.sPoiToNaviTime9, PerformStatItem.sPoiToNaviTime10);
                    PerformStatItem.sRoutePageToNaviTime4 = System.currentTimeMillis();
                    PerformStatisticsController.getInstance().addTimeLogForRoutePageGoToNavi("4", "创建导航页面UI前的操作", PerformStatItem.NAVI_MODULE_NAME, PerformStatItem.sRoutePageToNaviTime3, PerformStatItem.sRoutePageToNaviTime4);
                }
                C1328h.m4757a().showFragment(113, bundle);
                return true;
            } catch (Exception e) {
                NavMapAdapter.getInstance().exceptionLog(e);
                return false;
            }
        }
        TipTool.onCreateToastDialog(activity, JarUtils.getResources().getString(C4048R.string.nsdk_string_gps_permission_disabled));
        return false;
    }

    @Deprecated
    public void launchNavigator(Activity activity, NavGeoPoint startNode, String startName, NavGeoPoint endNode, String endName, int nRPPolicy, boolean isGPSNav, int strategy) {
        launchNavigator(activity, startNode, startName, endNode, endName, nRPPolicy, isGPSNav, strategy, false);
    }

    @Deprecated
    public void launchNavigator(Activity activity, NavGeoPoint startNode, String startName, NavGeoPoint endNode, String endName, int nRPPolicy, boolean isGPSNav, int strategy, boolean isRedirector) {
        NavLogUtils.m3003e(TAG, "launchNavigator2() ");
        if (activity != null) {
            if (NavCommonFuncController.getInstance().hasGPSPermission(activity)) {
                NavRoutePlanModel.getInstance().setStartRouteNode(NavMapAdapter.getInstance().getRouteNode(startNode, startName, null));
                NavRoutePlanModel.getInstance().setEndRouteNode(NavMapAdapter.getInstance().getRouteNode(endNode, endName, null));
                NavRoutePlanModel.getInstance().setPreference(nRPPolicy);
                NavRoutePlanModel.getInstance().setStrategy(strategy);
                ArrayList<RoutePlanNode> rpNodeLists = new ArrayList();
                RoutePlanNode startRPNode = new RoutePlanNode();
                startRPNode.setGeoPoint(NavModelHelper.convertNavGeoPoint(startNode));
                startRPNode.setName(startName);
                rpNodeLists.add(startRPNode);
                RoutePlanNode endRPNode = new RoutePlanNode();
                endRPNode.setGeoPoint(NavModelHelper.convertNavGeoPoint(endNode));
                if (!(TextUtils.isEmpty(endName) || "地图上的点".equals(endName))) {
                    endRPNode.setName(endName);
                }
                rpNodeLists.add(endRPNode);
                this.mRoutePlanObserver = null;
                this.mRoutePlanObserver = new RoutePlanObserver(activity, new C08273());
                BNRoutePlaner.getInstance().setObserver(this.mRoutePlanObserver);
                String mrsl = NavMapAdapter.getInstance().getCarRoutePlanMrsl();
                final Activity activity2 = activity;
                final NavGeoPoint navGeoPoint = startNode;
                final String str = startName;
                final NavGeoPoint navGeoPoint2 = endNode;
                final String str2 = endName;
                final int i = nRPPolicy;
                final boolean z = isGPSNav;
                final boolean z2 = isRedirector;
                BNRoutePlaner.getInstance().addRouteResultHandler(new BNMainLooperHandler() {
                    public void onMessage(Message msg) {
                        switch (msg.what) {
                            case 4:
                                NavMapAdapter.getInstance().purgeMapDataForNavi(activity2);
                                NavRouteGuideController.this.startRGActivity(activity2.getApplicationContext(), NavModelHelper.convertNavGeoPoint(navGeoPoint), str, NavModelHelper.convertNavGeoPoint(navGeoPoint2), str2, i, z, z2);
                                BNRoutePlaner.getInstance().removeRouteResultHandler(this);
                                return;
                            case 7:
                                BNRoutePlaner.getInstance().removeRouteResultHandler(this);
                                return;
                            default:
                                return;
                        }
                    }
                });
                int gpsState = NavMapAdapter.getInstance().isGpsEnabled() ? NavMapAdapter.getInstance().isGPSLocationValid() ? 1 : 2 : 0;
                BNRoutePlaner.getInstance().triggerGPSStatus(gpsState);
                NavLogUtils.m3003e(TAG, "launchNavigator2() mrsl=" + mrsl + ", nRPPolicy=" + nRPPolicy + ", strategy=" + strategy);
                switch (strategy) {
                    case 1:
                        BNRoutePlaner.getInstance().setPointsToCalcRoute(rpNodeLists, 3, true, mrsl, 0);
                        return;
                    case 2:
                        BNRoutePlaner.getInstance().setPointsToCalcRoute(rpNodeLists, -1, true, mrsl, 0);
                        return;
                    default:
                        BNRoutePlaner.getInstance().setPointsToCalcRoute(rpNodeLists, -1, true, mrsl, 0);
                        return;
                }
            }
            TipTool.onCreateToastDialog(activity, JarUtils.getResources().getString(C4048R.string.nsdk_string_gps_permission_disabled));
        }
    }

    @Deprecated
    public void launchNavigator(Activity activity, RouteNode startNode, RouteNode endNode, List<RouteNode> viaNodes, int nRPPolicy, boolean isGPSNav, int strategy) {
        launchNavigator(activity, startNode, endNode, (List) viaNodes, nRPPolicy, isGPSNav, strategy, false);
    }

    @Deprecated
    public void launchNavigator(Activity activity, RouteNode startNode, RouteNode endNode, List<RouteNode> viaNodes, int nRPPolicy, boolean isGPSNav, int strategy, boolean isRedirector) {
        NavLogUtils.m3003e(TAG, "launchNavigator4()  nRPPolicy=" + nRPPolicy + ", strategy=" + strategy + ", cuid=" + CommonParam.getCUID(activity));
        if (activity != null) {
            if (NavCommonFuncController.getInstance().hasGPSPermission(activity)) {
                NavRoutePlanModel.getInstance().setStartRouteNode(startNode);
                NavRoutePlanModel.getInstance().setEndRouteNode(endNode);
                NavRoutePlanModel.getInstance().setPreference(nRPPolicy);
                NavRoutePlanModel.getInstance().setStrategy(strategy);
                ArrayList<RoutePlanNode> rpNodeLists = new ArrayList();
                RoutePlanNode startRPNode = new RoutePlanNode();
                startRPNode.setGeoPoint(NavModelHelper.convertNavGeoPoint(startNode.mGeoPoint));
                startRPNode.setName(startNode.mName);
                startRPNode.setUID(startNode.mUID);
                rpNodeLists.add(startRPNode);
                if (viaNodes != null && viaNodes.size() > 0) {
                    for (int i = 0; i < viaNodes.size(); i++) {
                        RouteNode tNode = (RouteNode) viaNodes.get(i);
                        if (tNode != null) {
                            RoutePlanNode tRPNode = new RoutePlanNode();
                            tRPNode.setGeoPoint(NavModelHelper.convertNavGeoPoint(tNode.mGeoPoint));
                            tRPNode.setName(tNode.mName);
                            tRPNode.setUID(tNode.mUID);
                            rpNodeLists.add(tRPNode);
                        }
                    }
                }
                RoutePlanNode endRPNode = new RoutePlanNode();
                endRPNode.setGeoPoint(NavModelHelper.convertNavGeoPoint(endNode.mGeoPoint));
                if (!(TextUtils.isEmpty(endNode.mName) || "地图上的点".equals(endNode.mName))) {
                    endRPNode.setName(endNode.mName);
                }
                endRPNode.setUID(endNode.mUID);
                rpNodeLists.add(endRPNode);
                this.mRoutePlanObserver = null;
                this.mRoutePlanObserver = new RoutePlanObserver(activity, new C08295());
                BNRoutePlaner.getInstance().setObserver(this.mRoutePlanObserver);
                String mrsl = NavMapAdapter.getInstance().getCarRoutePlanMrsl();
                final Activity activity2 = activity;
                final RouteNode routeNode = startNode;
                final RouteNode routeNode2 = endNode;
                final int i2 = nRPPolicy;
                final boolean z = isGPSNav;
                final boolean z2 = isRedirector;
                BNRoutePlaner.getInstance().addRouteResultHandler(new BNMainLooperHandler() {
                    public void onMessage(Message msg) {
                        switch (msg.what) {
                            case 4:
                                NavMapAdapter.getInstance().purgeMapDataForNavi(activity2);
                                BNRoutePlaner.getInstance().selectRoute(0);
                                NavRouteGuideController.this.startRGActivity(activity2.getApplicationContext(), NavModelHelper.convertNavGeoPoint(routeNode.mGeoPoint), routeNode.mName, NavModelHelper.convertNavGeoPoint(routeNode2.mGeoPoint), routeNode2.mName, i2, z, z2);
                                BNRoutePlaner.getInstance().removeRouteResultHandler(this);
                                return;
                            case 7:
                                BNRoutePlaner.getInstance().removeRouteResultHandler(this);
                                return;
                            default:
                                return;
                        }
                    }
                });
                int gpsState = NavMapAdapter.getInstance().isGpsEnabled() ? NavMapAdapter.getInstance().isGPSLocationValid() ? 1 : 2 : 0;
                BNRoutePlaner.getInstance().triggerGPSStatus(gpsState);
                NavLogUtils.m3003e(TAG, "launchNavigator4() mRouteGuidePreference= " + this.mRouteGuidePreference + " hasSetPreference " + this.hasSetPreference);
                if (this.hasSetPreference.booleanValue()) {
                    this.hasSetPreference = Boolean.valueOf(false);
                    BNRoutePlaner.getInstance().setCalcPrference(this.mRouteGuidePreference);
                }
                NavLogUtils.m3003e(TAG, "launchNavigator4() mrsl=" + mrsl + ", nRPPolicy=" + nRPPolicy + ", strategy=" + strategy);
                switch (strategy) {
                    case 1:
                        BNRoutePlaner.getInstance().setPointsToCalcRoute(rpNodeLists, 3, true, mrsl, 0);
                        return;
                    case 2:
                        BNRoutePlaner.getInstance().setPointsToCalcRoute(rpNodeLists, -1, true, mrsl, 0);
                        return;
                    default:
                        BNRoutePlaner.getInstance().setPointsToCalcRoute(rpNodeLists, -1, true, mrsl, 0);
                        return;
                }
            }
            TipTool.onCreateToastDialog(activity, JarUtils.getResources().getString(C4048R.string.nsdk_string_gps_permission_disabled));
        }
    }

    public void launchCruiser(Activity activity) {
        if (activity != null) {
            if (NavCommonFuncController.getInstance().hasGPSPermission(activity)) {
                NavUserBehaviour.getInstance().sendBehaviourLog(NavUserBehaviourDef.NAVI_MAPPAGE_ENTER_EDOG);
                Bundle launchParams = new Bundle();
                launchParams.putInt(BCruiserConfig.KEY_CRUISER_VIEW_MODE, 0);
                NavMapAdapter.getInstance().purgeMapDataForNavi(activity);
                if (JarUtils.getAsJar()) {
                    BaiduNaviManager.getInstance().showNavPage(BNCruiserFragment.class.getName(), launchParams);
                    return;
                } else {
                    NavTipTool.onCreateToastDialog((Context) activity, (int) C0965R.string.nav_can_not_use);
                    return;
                }
            }
            TipTool.onCreateToastDialog(activity, JarUtils.getResources().getString(C4048R.string.nsdk_string_gps_permission_disabled_for_cruiser));
        }
    }

    public void launchCruiser(Activity activity, Boolean from) {
        if (activity != null) {
            if (NavCommonFuncController.getInstance().hasGPSPermission(activity)) {
                Bundle launchParams = new Bundle();
                launchParams.putInt(BCruiserConfig.KEY_CRUISER_VIEW_MODE, 0);
                NavMapAdapter.getInstance().purgeMapDataForNavi(activity);
                if (JarUtils.getAsJar()) {
                    if (from.booleanValue()) {
                        NavUserBehaviour.getInstance().sendNaviStatistics(null, null, NavUserBehaviourNaviAction.BEHAVIOUR_NAVI_ACTION_EDOG, NavMapAdapter.getInstance().hasCurMapLocationCityOfflineData() ? NavUserBehaviourNaviNet.BEHAVIOUR_NAVI_NET_OFFLINE : NavUserBehaviourNaviNet.BEHAVIOUR_NAVI_NET_ONLINE, NavUserBehaviourNaviEnter.BEHAVIOUR_NAVI_ENTER_NAV_EDOG);
                    } else {
                        NavUserBehaviour.getInstance().sendNaviStatistics(null, null, NavUserBehaviourNaviAction.BEHAVIOUR_NAVI_ACTION_EDOG, NavMapAdapter.getInstance().hasCurMapLocationCityOfflineData() ? NavUserBehaviourNaviNet.BEHAVIOUR_NAVI_NET_OFFLINE : NavUserBehaviourNaviNet.BEHAVIOUR_NAVI_NET_ONLINE, NavUserBehaviourNaviEnter.BEHAVIOUR_NAVI_ENTER_MAP_EDOG);
                    }
                    MainActivity.m3142a(new BNCruiserFragment(), launchParams);
                    return;
                }
                NavTipTool.onCreateToastDialog((Context) activity, (int) C0965R.string.nav_can_not_use);
                return;
            }
            TipTool.onCreateToastDialog(activity, JarUtils.getResources().getString(C4048R.string.nsdk_string_gps_permission_disabled_for_cruiser));
        }
    }

    public void backToCruiser(Activity activity) {
        if (activity != null) {
            NavMapAdapter.getInstance().purgeMapDataForNavi(activity);
            if (JarUtils.getAsJar()) {
                BaiduNaviManager.getInstance().showNavPage(BNCruiserFragment.class.getName(), null);
            } else {
                NavTipTool.onCreateToastDialog((Context) activity, (int) C0965R.string.nav_can_not_use);
            }
        }
    }

    private void startRGActivity(Context context, GeoPoint startNode, String startName, GeoPoint endNode, String endName, int nRPPolicy, boolean isGPSNav, boolean isRedirector) {
        if (isGPSNav) {
            if (isRedirector) {
                NavRoutePlanModel.getInstance().setmNavEnter(NavUserBehaviourNaviEnter.BEHAVIOUR_NAVI_ENTER_NAV_NAV);
                NavUserBehaviour.getInstance().sendNaviStatistics(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), "navi", NavRoutePlanModel.getInstance().getStrategyForUserBeh(), NavUserBehaviourNaviEnter.BEHAVIOUR_NAVI_ENTER_NAV_NAV);
            } else {
                NavRoutePlanModel.getInstance().setmNavEnter(NavUserBehaviourNaviEnter.BEHAVIOUR_NAVI_ENTER_ROUTE_NAV);
                NavUserBehaviour.getInstance().sendNaviStatistics(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), "navi", NavRoutePlanModel.getInstance().getStrategyForUserBeh(), NavUserBehaviourNaviEnter.BEHAVIOUR_NAVI_ENTER_ROUTE_NAV);
            }
        }
        BNRoutePlaner.getInstance().EnableRoadCondition(true);
        Bundle launchParams = new Bundle();
        launchParams.putInt(BNavConfig.KEY_ROUTEGUIDE_VIEW_MODE, 0);
        launchParams.putInt(BNavConfig.KEY_ROUTEGUIDE_CALCROUTE_DONE, 0);
        launchParams.putInt(BNavConfig.KEY_ROUTEGUIDE_START_X, startNode.getLongitudeE6());
        launchParams.putInt(BNavConfig.KEY_ROUTEGUIDE_START_Y, startNode.getLatitudeE6());
        launchParams.putInt(BNavConfig.KEY_ROUTEGUIDE_END_X, endNode.getLongitudeE6());
        launchParams.putInt(BNavConfig.KEY_ROUTEGUIDE_END_Y, endNode.getLatitudeE6());
        launchParams.putString("start_name", startName);
        launchParams.putString("end_name", endName);
        if (isGPSNav) {
            launchParams.putInt(BNavConfig.KEY_ROUTEGUIDE_LOCATE_MODE, 1);
        } else {
            launchParams.putInt(BNavConfig.KEY_ROUTEGUIDE_LOCATE_MODE, 2);
        }
        launchParams.putBoolean(BNavConfig.KEY_ROUTEGUIDE_NET_FRESH_ENABLE, true);
        if (JarUtils.getAsJar()) {
            try {
                NavLogUtils.m3003e(TAG, "startRGActivity() ok");
                NavFragmentManager.getInstance().showNavMapMapPage(BNRouteGuideFragment.class.getName(), launchParams);
                return;
            } catch (Exception e) {
                NavLogUtils.m3003e(TAG, "startRGActivity() error");
                NavMapAdapter.getInstance().exceptionLog(e);
                return;
            }
        }
        NavTipTool.onCreateToastDialog(context, (int) C0965R.string.nav_can_not_use);
    }

    public void dismissWaitProgressDialog() {
        if (this.mRoutePlanObserver != null) {
            this.mRoutePlanObserver.dismissWaitProgressDialog();
        }
    }

    public void setCalcPrference(int preference) {
        this.hasSetPreference = Boolean.valueOf(true);
        this.mRouteGuidePreference = preference;
    }

    public void runMonkey() {
        if (NavMapAdapter.sMonkey && BaiduNaviManager.isNaviSoLoadSuccess()) {
            Activity activity = NavCommonFuncModel.getInstance().getActivity();
            if (BaiduNaviManager.sIsBaseEngineInitialized) {
                BaiduNaviManager.getInstance().launchNavigator(BNaviModuleManager.getActivity(), new NavGeoPoint(11394118, 2254282), RoutePlanParams.MY_LOCATION, new NavGeoPoint(11396185, 2256679), "地图上的点", 1, true, 2);
            } else if (activity != null) {
                BaiduNaviManager.getInstance().initBaseEngine(activity, new C08347());
            }
        }
    }

    public boolean resetEndNodeInNavi(RouteNode newEndNode) {
        return RGEngineControl.getInstance().setEndPtToCalcRoute(NavModelHelper.convertNavGeoPoint(newEndNode.mGeoPoint));
    }

    public void setVoiceModeInNavi(int voiceMode) {
        BNSettingManager.setVoiceMode(voiceMode);
        BNRouteGuider.getInstance().setVoiceMode(voiceMode);
        if (2 == voiceMode) {
            BNRouteGuider.getInstance().setElecCameraSpeak(false);
            BNRouteGuider.getInstance().setSpeedCameraSpeak(false);
            BNRouteGuider.getInstance().setSaftyDriveSpeak(false);
            BNRouteGuider.getInstance().setRoadConditionSpeak(false);
            BNRouteGuider.getInstance().setStraightDirectSpeak(false);
        } else {
            BNRouteGuider.getInstance().setElecCameraSpeak(BNSettingManager.isElecCameraSpeakEnable());
            BNRouteGuider.getInstance().setSpeedCameraSpeak(BNSettingManager.isSpeedCameraSpeakEnable());
            BNRouteGuider.getInstance().setSaftyDriveSpeak(BNSettingManager.isSaftyDriveSpeakEnable());
            BNRouteGuider.getInstance().setRoadConditionSpeak(BNSettingManager.isRoadConditionSpeakEnable());
            BNRouteGuider.getInstance().setStraightDirectSpeak(BNSettingManager.isStraightDirectSpeakEnable());
        }
        if (BNavigator.getInstance().isNaviBegin()) {
            BNavigator.getInstance().onVoiceCommand(2, 33, 0, null, false);
        }
    }

    public void forceQuitWithoutDialog() {
        if (BNavigator.getInstance().isNaviBegin()) {
            NavTrajectoryController.getInstance().setEndNaviByOpenApi(true);
            BNavigator.getInstance().forceQuitWithoutDialog();
        } else if (BCruiser.getInstance().isRouteCruiseBegin()) {
            BCruiser.getInstance().quitCruise();
        }
    }

    public boolean setUserChooseRouteBit(int nBit) {
        return BNRouteGuider.getInstance().setUserChooseRouteBit(nBit);
    }

    public void onPageJump(int jumpTiming, Object arg) {
        if (this.mBNavigatorListener != null) {
            this.mBNavigatorListener.onPageJump(jumpTiming, arg);
        }
    }

    public void setBNavigatorListener(BNavigatorListener bNavigatorListener) {
        this.mBNavigatorListener = bNavigatorListener;
        if (bNavigatorListener != null) {
            setIsThirdServer(true);
        }
    }

    public BNavigatorListener getBNavigatorListener() {
        return this.mBNavigatorListener;
    }

    public boolean isThirdServer() {
        return this.mIsThirdServer;
    }

    public void setIsThirdServer(boolean isThirdServer) {
        this.mIsThirdServer = isThirdServer;
    }

    public boolean newGuideIsThirdServer() {
        return this.mNewGuideIsThirdServer;
    }

    public void setNewGuideIsThirdServer(boolean newGuideIsThirdServer) {
        this.mNewGuideIsThirdServer = newGuideIsThirdServer;
    }
}
