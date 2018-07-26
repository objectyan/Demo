package com.baidu.navi.controller;

import com.baidu.navi.favorite.FavoritePois;
import com.baidu.navi.logic.AppPreferenceHelperConst;
import com.baidu.navi.track.common.TrackConfig;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.NaviAccountUtils.INaviAccountListener;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.userdata.BNFavoriteManager;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;

public class AccountController {
    public static final int ACCOUNT_STATE_NEWUSER = 1;
    public static final int ACCOUNT_STATE_SWITCHUSER = 2;
    public static final int ACCOUNT_STATE_UNLOGIN = 0;
    public static final int MSG_EVENT_LOGOUT = 100;
    private int mAccoutState;
    private IAccountListener mLogoutListener;

    public interface IAccountListener {
        void onLogResult(boolean z);
    }

    private static class LazyHolder {
        private static AccountController sInstance = new AccountController();

        private LazyHolder() {
        }
    }

    private class NaviAccount implements INaviAccountListener {
        private IAccountListener mListener;

        public NaviAccount(IAccountListener listener) {
            this.mListener = listener;
        }

        public void onReloginSuccess(boolean isSuccess) {
            if (this.mListener != null) {
                this.mListener.onLogResult(isSuccess);
            }
        }

        public void onLoginSuccess() {
            String preUserId = AccountController.this.getPrefUserId();
            if (AccountController.this.updateLoginState() == 2) {
                LogUtil.m15791e("Account", "zyq switchUser");
                JNITrajectoryControl.sInstance.logoutCleanUp();
                BNFavoriteManager.getInstance().cleanAllFavPois();
            }
            if (this.mListener != null) {
                this.mListener.onLogResult(true);
            }
        }
    }

    private AccountController() {
        this.mAccoutState = 0;
    }

    public static AccountController getInstance() {
        return LazyHolder.sInstance;
    }

    public void loginIn(IAccountListener listener) {
        if (!NaviAccountUtils.getInstance().isLogin()) {
            NaviAccountUtils.getInstance().openLoginActivity(BNaviModuleManager.getActivity(), new NaviAccount(listener));
        }
    }

    public void setLogoutListener(IAccountListener listener) {
        this.mLogoutListener = listener;
    }

    public void logout() {
        String uid = NaviAccountUtils.getInstance().getUid();
        NaviAccountUtils.getInstance().logout();
        FavoritePois.getPoiInstance().setBduid(uid);
        FavoritePois.getPoiInstance().logoutCleanUp();
        JNITrajectoryControl.sInstance.logoutCleanUp();
        TrackConfig.getInstance().setTotalDistanse(0);
        setPrefUserId("default");
    }

    public void relogin() {
        NaviAccountUtils.getInstance().openLoginActivity(BNaviModuleManager.getActivity(), new NaviAccount(null));
    }

    private String getPrefUserId() {
        return PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getString(AppPreferenceHelperConst.USER_PRE_UID, "default");
    }

    private String setPrefUserId(String uid) {
        return PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getString(AppPreferenceHelperConst.USER_PRE_UID, uid);
    }

    private int updateLoginState() {
        if (NaviAccountUtils.getInstance().isLogin()) {
            String currentUsername = NaviAccountUtils.getInstance().getUserName();
            String uid = NaviAccountUtils.getInstance().getUid();
            String prefUserId = getPrefUserId();
            if (!(uid == null || uid.equals(prefUserId))) {
                PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putString("PREF_CURRENT_USERNAME", currentUsername);
                setPrefUserId(uid);
                if (prefUserId.equals("default")) {
                    this.mAccoutState = 1;
                } else {
                    this.mAccoutState = 2;
                }
            }
        } else {
            this.mAccoutState = 0;
        }
        return this.mAccoutState;
    }
}
