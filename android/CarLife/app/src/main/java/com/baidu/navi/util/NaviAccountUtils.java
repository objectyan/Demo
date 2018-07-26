package com.baidu.navi.util;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.util.C2186p;
import com.baidu.navi.favorite.FavoritePois;
import com.baidu.navi.fragment.ContentFragmentManager;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.logic.drawable.UrlDrawable;
import com.baidu.navi.track.common.TrackConfig;
import com.baidu.navi.track.datashop.TrackDataShop;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration$Builder;
import com.baidu.sapi2.shell.callback.GetUserInfoCallBack;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.GetPortraitResponse;
import com.baidu.sapi2.shell.response.GetUserInfoResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.utils.enums.BindType;
import com.baidu.sapi2.utils.enums.Domain;
import com.tencent.qplayauto.device.QPlayAutoJNI;

public class NaviAccountUtils {
    public static final int BUDSS_CHECK_INTERVAL = 86400000;
    public static final int LOGIN_BUDSS_EXPIRED = 600002;
    public static final int LOGIN_BUDSS_NORMAL = 600001;
    private static final String SP_PHONE_NUMBER = "passportPhone";
    private static final String TAG = "Favorite";
    private SapiAccountManager mAccountManager;
    private boolean mIsAccountInit;
    private INaviAccountListener mListener;
    private int mLoginType;
    private String mPortraitUrl;
    private String mSecurePhoneNum;

    public interface INaviAccountListener {
        void onLoginSuccess();

        void onReloginSuccess(boolean z);
    }

    /* renamed from: com.baidu.navi.util.NaviAccountUtils$1 */
    class C39741 implements SapiCallBack<GetPortraitResponse> {
        C39741() {
        }

        public void onSuccess(GetPortraitResponse response) {
            if (response != null && !TextUtils.isEmpty(response.portrait)) {
                NaviAccountUtils.this.mPortraitUrl = response.portrait;
            }
        }

        public void onNetworkFailed() {
        }

        public void onSystemError(int errorCode) {
        }
    }

    /* renamed from: com.baidu.navi.util.NaviAccountUtils$5 */
    class C39785 extends GetUserInfoCallBack {
        C39785() {
        }

        public void onFinish() {
            C1260i.b("passport", "onFinish");
        }

        public void onBdussInvalid() {
            C1260i.b("passport", "onBdussInvalid");
        }

        public void onSuccess(GetUserInfoResponse getUserInfoResponse) {
            if (getUserInfoResponse != null) {
                NaviAccountUtils.this.mSecurePhoneNum = getUserInfoResponse.secureMobile;
                C2186p.a().b(NaviAccountUtils.SP_PHONE_NUMBER, NaviAccountUtils.this.mSecurePhoneNum);
                FavoritePois.getPoiInstance().setBduid(getUserInfoResponse.uid);
                C1260i.b("passport", "onSuccess phoneNum=" + NaviAccountUtils.this.mSecurePhoneNum + ", uid:" + getUserInfoResponse.uid);
            }
        }

        public void onNetworkFailed() {
            NaviAccountUtils.this.mSecurePhoneNum = C2186p.a().a(NaviAccountUtils.SP_PHONE_NUMBER, null);
            C1260i.b("passport", "onNetworkFailed phoneNum=" + NaviAccountUtils.this.mSecurePhoneNum);
        }

        public void onSystemError(int i) {
            C1260i.b("passport", "onSystemError");
        }
    }

    public interface IBdussListener {
        void onBduss(String str);
    }

    private static class LazyHolder {
        private static final NaviAccountUtils sInstance = new NaviAccountUtils();

        private LazyHolder() {
        }
    }

    private NaviAccountUtils() {
        this.mAccountManager = null;
        this.mPortraitUrl = null;
        this.mLoginType = 0;
        this.mIsAccountInit = false;
        this.mAccountManager = SapiAccountManager.getInstance();
    }

    public static NaviAccountUtils getInstance() {
        return LazyHolder.sInstance;
    }

    public void initAccount(Context context) {
        SapiConfiguration$Builder builder = new SapiConfiguration$Builder(context);
        builder.setProductLineInfo("navi", "1", "74f335623ec2a2cc327f7951e6974f3f");
        if (BNSettingManager.isUserAccountOnline()) {
            builder.setRuntimeEnvironment(Domain.DOMAIN_ONLINE);
        } else {
            builder.setRuntimeEnvironment(Domain.DOMAIN_QA);
        }
        builder.setSocialBindType(BindType.IMPLICIT);
        this.mAccountManager.init(builder.build());
    }

    public String getUserName() {
        return this.mAccountManager.getSession(SapiAccountManager.SESSION_DISPLAYNAME);
    }

    public String getUid() {
        return this.mAccountManager.getSession("uid");
    }

    public String getPToken() {
        return this.mAccountManager.getSession(SapiAccountManager.SESSION_PTOKEN);
    }

    public String getSToken() {
        return this.mAccountManager.getSession(SapiAccountManager.SESSION_STOKEN);
    }

    public String getSecurePhoneNum() {
        return this.mSecurePhoneNum;
    }

    public String getPortraitUrl() {
        return this.mPortraitUrl;
    }

    public boolean isLogin(Handler handler) {
        if (!this.mAccountManager.isLogin()) {
            return false;
        }
        long mlastTimeCheckBudss = BNSettingManager.getLastCheckBudssTime();
        long curTime = System.currentTimeMillis();
        LogUtil.m15791e("wywy", "mlastTimeCheckBudss=" + mlastTimeCheckBudss + " curTime=" + curTime + " diff=" + (curTime - mlastTimeCheckBudss));
        if (curTime - mlastTimeCheckBudss < 86400000) {
            return true;
        }
        BNSettingManager.setLastCheckBudssTime(curTime);
        getUserInfo(handler);
        return false;
    }

    public boolean isLogin() {
        return this.mAccountManager.isLogin();
    }

    public void logout() {
        this.mAccountManager.logout();
        this.mPortraitUrl = null;
        this.mSecurePhoneNum = null;
        C2186p.a().c(SP_PHONE_NUMBER);
    }

    public void asyncGetBduss(IBdussListener listener) {
        if (listener != null) {
            listener.onBduss(this.mAccountManager.getSession("bduss"));
        }
    }

    public void setUserHeadToImageView(ImageView iconView) {
        if (iconView != null) {
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            if (session != null) {
                SapiAccountManager.getInstance().getAccountService().getPortrait(new C39741(), session.bduss, session.ptoken, session.stoken);
            }
        }
    }

    public void asyncSetPortraitToImageView(final ImageView iconView) {
        if (iconView != null) {
            if (this.mPortraitUrl != null) {
                iconView.setImageDrawable(UrlDrawable.getDrawable(this.mPortraitUrl));
                return;
            }
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            SapiAccountManager.getInstance().getAccountService().getPortrait(new SapiCallBack<GetPortraitResponse>() {
                public void onSuccess(GetPortraitResponse response) {
                    if (response != null && !TextUtils.isEmpty(response.portrait)) {
                        NaviAccountUtils.this.mPortraitUrl = response.portrait;
                        iconView.setImageDrawable(UrlDrawable.getDrawable(response.portrait));
                    }
                }

                public void onNetworkFailed() {
                }

                public void onSystemError(int errorCode) {
                }
            }, session.bduss, session.ptoken, session.stoken);
        }
    }

    public void asyncGetProtraitUrl(final SapiCallBack<GetPortraitResponse> callBack) {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        SapiAccountManager.getInstance().getAccountService().getPortrait(new SapiCallBack<GetPortraitResponse>() {
            public void onSuccess(GetPortraitResponse response) {
                if (!(response == null || TextUtils.isEmpty(response.portrait))) {
                    NaviAccountUtils.this.mPortraitUrl = response.portrait;
                }
                if (callBack != null) {
                    callBack.onSuccess(response);
                }
            }

            public void onNetworkFailed() {
                if (callBack != null) {
                    callBack.onNetworkFailed();
                }
            }

            public void onSystemError(int errorCode) {
                if (callBack != null) {
                    callBack.onSystemError(errorCode);
                }
            }
        }, session.bduss, session.ptoken, session.stoken);
    }

    public String syncGetBduss() {
        if (this.mAccountManager == null || !this.mAccountManager.isLogin()) {
            return "";
        }
        return this.mAccountManager.getSession("bduss");
    }

    public void firstLaunch() {
    }

    public void openLoginActivity(Activity activity, INaviAccountListener listener) {
        if (NetworkUtils.isNetworkAvailable(activity.getApplicationContext())) {
            int type = C1328h.a().d();
            if (type == 4001) {
                type = 1;
            } else if (type == 4004) {
                type = 4;
            } else if (type == 4002) {
                type = 2;
            } else {
                type = 3;
            }
            Bundle bundle = new Bundle();
            bundle.putInt(ContentFragmentManager.MODULE_FROM, type);
            C1328h.a().showFragment(NaviFragmentManager.TYPE_LOGIN, bundle);
            this.mListener = listener;
            this.mLoginType = 1;
            return;
        }
        TipTool.onCreateToastDialog((Context) activity, activity.getString(C0965R.string.network_unconnected));
    }

    public void reLogin(Activity activity, final INaviAccountListener listener) {
        SapiAccountManager.getInstance().getAccountService().relogin(new SapiCallBack<SapiResponse>() {
            public void onSuccess(SapiResponse response) {
                String bduss = NaviAccountUtils.this.syncGetBduss();
                String uid = NaviAccountUtils.this.getUid();
                if (!(TextUtils.isEmpty(bduss) || TextUtils.isEmpty(uid))) {
                    LogUtil.m15791e("", "ugc=====NaviAccountUtils11  userId " + uid);
                    if (!uid.equals(QPlayAutoJNI.SONG_LIST_ROOT_ID)) {
                        LogUtil.m15791e("", "ugc=====NaviAccountUtils11  userId " + uid);
                    }
                    JNITrajectoryControl.sInstance.updateUserInfo(bduss, uid, 1);
                }
                listener.onReloginSuccess(true);
            }

            public void onNetworkFailed() {
                listener.onReloginSuccess(false);
            }

            public void onSystemError(int errorCode) {
                listener.onReloginSuccess(false);
            }
        }, SapiAccountManager.getInstance().getSession().getReloginCredentials());
    }

    public void onLoginResult(boolean isSuccess) {
        String bduss = syncGetBduss();
        String uid = getUid();
        if (!(TextUtils.isEmpty(bduss) || TextUtils.isEmpty(uid))) {
            if (isSuccess) {
                LogUtil.m15791e("", "ugc=====NaviAccountUtils22  userId " + uid);
                if (!uid.equals(QPlayAutoJNI.SONG_LIST_ROOT_ID)) {
                    LogUtil.m15791e("", "ugc=====NaviAccountUtils22  userId " + uid);
                }
                JNITrajectoryControl.sInstance.updateUserInfo(bduss, uid, 1);
                TrackDataShop.getInstance().updateNotLoginTracksBduis(uid);
            } else {
                JNITrajectoryControl.sInstance.updateUserInfo(bduss, uid, 0);
            }
            TrackConfig.getInstance().setTotalDistanse(0);
            FavoritePois.getPoiInstance().login(uid);
        }
        switch (this.mLoginType) {
            case 1:
                if (this.mListener != null && isSuccess) {
                    this.mListener.onLoginSuccess();
                }
                this.mListener = null;
                this.mLoginType = 0;
                return;
            case 2:
                if (this.mListener != null) {
                    this.mListener.onReloginSuccess(isSuccess);
                }
                this.mListener = null;
                this.mLoginType = 0;
                return;
            default:
                return;
        }
    }

    private void getUserInfo(Handler handler) {
    }

    public void asyncGetUserInfo() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            SapiAccountManager.getInstance().getAccountService().getUserInfo(new C39785(), session.bduss);
        }
    }
}
