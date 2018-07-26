package com.baidu.navisdk.util.http.center;

import com.baidu.navisdk.util.common.LogUtil;
import java.util.HashMap;

public class BNHttpCenter implements IBNHttpCenter {
    public static final String TAG = BNHttpCenter.class.getSimpleName();
    private static BNHttpCenter sInstance = null;
    private static final Object sInstanceLock = new Object();
    private IBNHttpCenter mCurHttpCenter = null;

    private BNHttpCenter() {
    }

    public static void init(IBNHttpCenter center) {
        if (sInstance == null) {
            synchronized (sInstanceLock) {
                if (sInstance == null) {
                    sInstance = new BNHttpCenter();
                }
            }
        }
        if (center != null) {
            sInstance.setHttpCenter(center);
            LogUtil.m15791e(TAG, "use the outer http cetner.");
            return;
        }
        sInstance.setHttpCenter(BNInnerHttpCenter.getInstance());
        LogUtil.m15791e(TAG, "use the inner http cetner.");
    }

    private void setHttpCenter(IBNHttpCenter center) {
        if (center == null) {
            LogUtil.m15791e(TAG, "setHttpCenter() http center is null !!!");
        } else if (this.mCurHttpCenter != null) {
            LogUtil.m15791e(TAG, "setHttpCenter() return for cur http center is not null !!!");
        } else {
            this.mCurHttpCenter = center;
        }
    }

    public static IBNHttpCenter getInstance() {
        if (sInstance == null) {
            synchronized (sInstanceLock) {
                if (sInstance == null) {
                    sInstance = new BNHttpCenter();
                }
            }
        }
        return sInstance;
    }

    public void get(String url, HashMap<String, String> getMethodParams, IBNHttpResponseHandler handler, BNHttpParams moreParams) {
        if (this.mCurHttpCenter != null) {
            this.mCurHttpCenter.get(url, getMethodParams, handler, moreParams);
        } else {
            LogUtil.m15791e(TAG, "get() the http center is null.");
        }
    }

    public void post(String url, HashMap<String, String> postMethodParams, IBNHttpResponseHandler handler, BNHttpParams moreParams) {
        if (this.mCurHttpCenter != null) {
            this.mCurHttpCenter.post(url, postMethodParams, handler, moreParams);
        } else {
            LogUtil.m15791e(TAG, "post() the http center is null.");
        }
    }
}
