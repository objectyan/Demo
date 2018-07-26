package com.baidu.navi.controller;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.carlife.C0965R;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.verify.BNKeyVerify;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class LaunchController {
    private static final String ACCESS_KEY = "1Z7v3O9UhsHdUt6iA2GaQaoG";
    private static final String TAG = LaunchController.class.getSimpleName();
    private boolean mIsDelayedInitDone;
    public Handler mUIHandler;

    private static class LazyHolder {
        private static final LaunchController instance = new LaunchController();

        private LazyHolder() {
        }
    }

    public static LaunchController getInstance() {
        return LazyHolder.instance;
    }

    private LaunchController() {
        this.mIsDelayedInitDone = false;
        this.mUIHandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case CommandConst.K_MSG_SDKOP_VERIFY /*1302*/:
                        if (msg.arg1 == 0) {
                            LogUtil.m15791e("NaviActivity", StyleManager.getString(C0965R.string.key_verify_succ));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public synchronized void asyncDelayedInit(final Handler handler, long delayedMillis) {
        if (handler != null) {
            if (!this.mIsDelayedInitDone) {
                handler.postDelayed(new Runnable() {
                    public void run() {
                        NaviAccountUtils.getInstance().initAccount(BaseFragment.getNaviActivity());
                        LaunchController.this.delayedInit();
                        UserCenterController.getInstance().setDataUpdate(handler);
                        if (NaviAccountUtils.getInstance().isLogin()) {
                            UserCenterController.getInstance().startUpdateUserInfo(1, handler);
                        } else {
                            UserCenterController.getInstance().startUpdateUserInfo(0, handler);
                        }
                        LaunchController.this.mIsDelayedInitDone = true;
                    }
                }, delayedMillis);
            }
        }
    }

    public boolean getInitFinished() {
        return this.mIsDelayedInitDone;
    }

    private void delayedInit() {
        BNSettingManager.initEngine();
        GeoPoint point = BNLocationManagerProxy.getInstance().getLastValidLocation();
        verifySDK();
    }

    private void verifySDK() {
        BNKeyVerify.getInstance().asyncVerify(ACCESS_KEY, this.mUIHandler);
    }
}
