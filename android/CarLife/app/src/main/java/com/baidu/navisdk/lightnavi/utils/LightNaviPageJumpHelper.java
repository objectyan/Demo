package com.baidu.navisdk.lightnavi.utils;

import android.os.Bundle;
import com.baidu.navisdk.lightnavi.listener.LightNaviListener;

public class LightNaviPageJumpHelper {
    private static volatile LightNaviPageJumpHelper mInstance;
    private LightNaviListener mLightNaviListener;

    private LightNaviPageJumpHelper() {
    }

    public static LightNaviPageJumpHelper getInstance() {
        if (mInstance == null) {
            synchronized (LightNaviPageJumpHelper.class) {
                if (mInstance == null) {
                    mInstance = new LightNaviPageJumpHelper();
                }
            }
        }
        return mInstance;
    }

    public void setPageListener(LightNaviListener mListener) {
        this.mLightNaviListener = mListener;
    }

    public void removePageListener() {
        this.mLightNaviListener = null;
    }

    public void onPageJump(int type, Bundle bundle) {
        if (this.mLightNaviListener != null) {
            this.mLightNaviListener.onPageJump(type, bundle);
        }
    }
}
