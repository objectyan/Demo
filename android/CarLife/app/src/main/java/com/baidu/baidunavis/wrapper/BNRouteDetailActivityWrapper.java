package com.baidu.baidunavis.wrapper;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavLocationManager;
import com.baidu.baidunavis.control.NavDayNightController;
import com.baidu.baidunavis.control.NavDayNightController.OnDayNightChangedListener;
import com.baidu.baidunavis.control.NavRouteGuideController;
import com.baidu.baidunavis.control.NavRoutePlanController;
import com.baidu.baidunavis.model.NavRoutePlanModel;
import com.baidu.baidunavis.stat.NavUserBehaviourDef.NavUserBehaviourNaviEnter;
import com.baidu.baidunavis.ui.BNRouteDetailFragment;
import com.baidu.baidunavis.ui.widget.RoutePlanObserver;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.navi.routedetails.proxy.BNRouteDetail;
import com.baidu.navi.routedetails.proxy.BNRouteDetail.BNRouteDetailNavListener;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.ui.routedetails.proxy.BNRouteDetailConfig;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNRouteDetailActivityWrapper {
    private boolean mBackFromAnologNavi = false;
    private BNRouteDetailFragment mFragment = null;
    private boolean mIsAnologNavi = false;
    private C1443g mLeftArea;
    private OnDayNightChangedListener mOnDayNightChangedListener = new C09132();
    private C1443g mRightArea;
    private BNRouteDetailNavListener mRouteDetailNavListener = new C09121();
    private RoutePlanObserver mRoutePlanObserver = null;
    private boolean needUpdate = true;

    /* renamed from: com.baidu.baidunavis.wrapper.BNRouteDetailActivityWrapper$1 */
    class C09121 implements BNRouteDetailNavListener {
        C09121() {
        }

        public void onStartNavi(Bundle bundle, boolean isAnologNavi) {
            BNRouteDetailActivityWrapper.this.mIsAnologNavi = isAnologNavi;
            NavRouteGuideController.getInstance().setLocateMode(!isAnologNavi ? 1 : 2);
            NavRoutePlanModel.getInstance().setmNavEnter(NavUserBehaviourNaviEnter.BEHAVIOUR_NAVI_ENTER_NAV_NAV);
            BaiduNaviManager.getInstance().sendNaviStatistics(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), "navi", NavUserBehaviourNaviEnter.BEHAVIOUR_NAVI_ENTER_NAV_NAV);
            NavRouteGuideController.getInstance().startRouteGuideView(false, NavRoutePlanController.getInstance().createNaviParam(NavRouteGuideController.getInstance().getLocateMode(), false));
        }

        public void onJumpBack() {
            if (BNRouteDetailActivityWrapper.this.mFragment.getNaviFragmentManager() != null) {
                BNRouteDetailActivityWrapper.this.mFragment.getNaviFragmentManager().back(null);
            }
        }

        public void onJumpHome() {
            if (BNRouteDetailActivityWrapper.this.mFragment.getNaviFragmentManager() != null) {
                BNRouteDetailActivityWrapper.this.mFragment.getNaviFragmentManager().back(null);
            }
        }

        public void onUpdate() {
            BNRouteDetailActivityWrapper.this.reInitFocus();
        }
    }

    /* renamed from: com.baidu.baidunavis.wrapper.BNRouteDetailActivityWrapper$2 */
    class C09132 implements OnDayNightChangedListener {
        C09132() {
        }

        public void onDayNightChanged(boolean isDay) {
            BNRouteDetail.getInstance().onUpdateStyle(isDay);
        }
    }

    public BNRouteDetailActivityWrapper(BNRouteDetailFragment frag) {
        this.mFragment = frag;
    }

    public View onCreateContentView(C1277e listener) {
        boolean z = true;
        if (JarUtils.getAsJar()) {
            Bundle bundle = this.mFragment.getArguments();
            if (bundle != null && bundle.containsKey(BNRouteDetailFragment.BACK_FROM_ANOLOG_NAVI)) {
                this.mBackFromAnologNavi = bundle.getBoolean(BNRouteDetailFragment.BACK_FROM_ANOLOG_NAVI, false);
            }
            this.mRoutePlanObserver = new RoutePlanObserver(null);
            BNRouteDetailConfig.pRGViewMode = 1;
            BNRouteDetail instance = BNRouteDetail.getInstance();
            BNRouteDetailFragment bNRouteDetailFragment = this.mFragment;
            View view = instance.init(BNRouteDetailFragment.mActivity, listener);
            if (view == null) {
                return null;
            }
            BNMapController instance2 = BNMapController.getInstance();
            if (BNStyleManager.getRealDayStyle()) {
                z = false;
            }
            instance2.setNightMode(z);
            if (this.mBackFromAnologNavi) {
                BNRouteDetail.getInstance().cancleCountDownTask();
            }
            BNRouteDetail.getInstance().setNaviListener(this.mRouteDetailNavListener);
            NavDayNightController.getInstance().registerDayNightListener(this.mOnDayNightChangedListener);
            try {
                BNRoutePlaner.getInstance().setComeFrom(3);
            } catch (Throwable th) {
                LogUtil.e("BNRoutePlaner", "BNRoutePlaner.getInstance().setComeFrom MethodError");
            }
            StatisticManager.onEvent(StatisticConstants.NAVI_0001, StatisticConstants.NAVI_0001);
            return view;
        }
        this.mFragment.back();
        return null;
    }

    public void onResume() {
        BNRoutePlaner.getInstance().setObserver(this.mRoutePlanObserver);
        BNRouteDetail.getInstance().onResume();
        BNMapController.getInstance().setNightMode(!BNStyleManager.getRealDayStyle());
        NavLocationManager.getInstance().enterRouteDetailPage();
    }

    public void onPause() {
        BNRoutePlaner.getInstance().setObserver(null);
        BNRouteDetail.getInstance().onPause();
        NavLocationManager.getInstance().exitRouteDetailPage();
    }

    public void onDestroy() {
        NavDayNightController.getInstance().unregisterDayNightListener(this.mOnDayNightChangedListener);
        BNRouteDetail.getInstance().onDestory();
        try {
            BNMapController.getInstance().setNightMode(!BNStyleManager.getRealDayStyle());
        } catch (Exception e) {
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
    }

    public boolean onBackPressed() {
        return BNRouteDetail.getInstance().onBackPressed();
    }

    public void onInitFocus() {
        BNRouteDetail.getInstance().initFocus(this.mLeftArea, this.mRightArea, false);
    }

    public void reInitFocus() {
        BNRouteDetail.getInstance().initFocus(this.mLeftArea, this.mRightArea, true);
    }

    public boolean onVoiceCommand(int type, int subType, int arg1, Object arg2, boolean needResponse) {
        return BNRouteDetail.getInstance().onVoiceCommand(type, subType, arg1, arg2, needResponse);
    }
}
