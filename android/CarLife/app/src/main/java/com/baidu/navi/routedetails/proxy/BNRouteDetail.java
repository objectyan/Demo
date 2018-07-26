package com.baidu.navi.routedetails.proxy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.navisdk.CommonParams.Key;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;

public class BNRouteDetail {
    private static volatile BNRouteDetail me = null;
    private Activity mActivity;
    private Context mContext;
    private FrameLayout mParentView = null;

    public interface BNRouteDetailNavListener {
        void onJumpBack();

        void onJumpHome();

        void onStartNavi(Bundle bundle, boolean z);

        void onUpdate();
    }

    private BNRouteDetail() {
    }

    public static BNRouteDetail getInstance() {
        if (me == null) {
            synchronized (BNRouteDetail.class) {
                if (me == null) {
                    me = new BNRouteDetail();
                }
            }
        }
        return me;
    }

    public static void destory() {
        if (me != null) {
            synchronized (BNRouteDetail.class) {
                if (me != null) {
                    me.dispose();
                }
            }
        }
        me = null;
    }

    private void dispose() {
    }

    public View init(Activity activity, C1277e listener) {
        this.mActivity = activity;
        this.mContext = activity.getApplicationContext();
        try {
            this.mParentView = (FrameLayout) this.mActivity.getLayoutInflater().inflate(C0965R.layout.layout_route_detail_main_layout, null);
            setupUI(listener);
            boolean isFirstShow = PreferenceHelper.getInstance(this.mActivity).getBoolean(Key.SP_KEY_SHOW_TOAST_FOR_LINKID, false);
            LogUtil.m15791e("", "BNDownloadUIManager: isFirstShow " + isFirstShow);
            int rpNetMode = BNSettingManager.getPrefRoutPlanMode();
            if (isFirstShow && (rpNetMode == 2 || rpNetMode == 0)) {
                PreferenceHelper.getInstance(this.mActivity).putBoolean(Key.SP_KEY_SHOW_TOAST_FOR_LINKID, false);
            }
            return this.mParentView;
        } catch (Exception e) {
            return null;
        }
    }

    private void setupUI(C1277e listener) {
        if (this.mParentView != null) {
            this.mParentView.removeAllViews();
            RGRouteDetailsViewController.getInstance().initView(this.mActivity, this.mParentView, listener);
        }
    }

    public void cancleCountDownTask() {
        RGRouteDetailsViewController.getInstance().cancleCountDownTask();
    }

    public void onResume() {
        RGRouteDetailsViewController.getInstance().onResume();
    }

    public void onPause() {
        RGRouteDetailsViewController.getInstance().onPause();
    }

    public void onUpdateStyle(boolean dayStyle) {
        RGRouteDetailsViewController.getInstance().onUpdateStyle(dayStyle);
    }

    public void onUpdateOrientation(int orientation) {
        RGRouteDetailsViewController.getInstance().onUpdateOrientation(orientation);
    }

    public void onDestory() {
        if (this.mParentView != null) {
            this.mParentView.removeAllViews();
        }
        RGRouteDetailsViewController.getInstance().onDestory();
        this.mActivity = null;
    }

    public boolean onBackPressed() {
        return RGRouteDetailsViewController.getInstance().onBackPressed();
    }

    public void setNaviListener(BNRouteDetailNavListener listener) {
        RGRouteDetailsViewController.getInstance().setNaviListener(listener);
    }

    public void initFocus(C1443g leftArea, C1443g rightArea, boolean isReSet) {
        RGRouteDetailsViewController.getInstance().initFocus(leftArea, rightArea, isReSet);
    }

    public boolean onVoiceCommand(int type, int subType, int arg1, Object arg2, boolean needResponse) {
        return RGRouteDetailsViewController.getInstance().onVoiceCommand(type, subType, arg1, arg2, needResponse);
    }
}
