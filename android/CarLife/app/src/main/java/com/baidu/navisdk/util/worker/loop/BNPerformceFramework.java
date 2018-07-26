package com.baidu.navisdk.util.worker.loop;

import android.os.Message;
import com.baidu.navisdk.util.common.LogUtil;

public class BNPerformceFramework implements IBNPerformceFramework {
    public static final String TAG = BNPerformceFramework.class.getSimpleName();
    private static BNPerformceFramework sInstance = null;
    private static final Object sInstanceLock = new Object();
    private IBNPerformceFramework mFramework = null;

    private BNPerformceFramework() {
    }

    public static BNPerformceFramework getInstance() {
        if (sInstance == null) {
            synchronized (sInstanceLock) {
                if (sInstance == null) {
                    sInstance = new BNPerformceFramework();
                }
            }
        }
        return sInstance;
    }

    public static void init(IBNPerformceFramework framework) {
        getInstance().setFramework(framework);
    }

    private void setFramework(IBNPerformceFramework framework) {
        if (this.mFramework != null) {
            LogUtil.m15791e(TAG, "setFramework() framework is not null.");
        } else if (framework == null) {
            LogUtil.m15791e(TAG, "setFramework() framework is null.");
        } else {
            this.mFramework = framework;
        }
    }

    public void runInLooperBuffer(Runnable runnable) {
        if (runnable == null) {
            LogUtil.m15791e(TAG, "runInLooperBuffer() runnable is null.");
        } else if (this.mFramework != null) {
            this.mFramework.runInLooperBuffer(runnable);
        } else {
            LogUtil.m15791e(TAG, "runInLooperBuffer() framework is null.");
        }
    }

    public void markSubmit(Message message) {
        if (this.mFramework != null) {
            this.mFramework.markSubmit(message);
        } else {
            LogUtil.m15791e(TAG, "markSubmit() framework is null.");
        }
    }

    public void markRunning(Message message) {
        if (message == null) {
            LogUtil.m15791e(TAG, "markRunning() message is null.");
        } else if (this.mFramework != null) {
            this.mFramework.markRunning(message);
        } else {
            LogUtil.m15791e(TAG, "markRunning() framework is null.");
        }
    }

    public void markFinish(Message message) {
        if (message == null) {
            LogUtil.m15791e(TAG, "markFinish() message is null.");
        } else if (this.mFramework != null) {
            this.mFramework.markFinish(message);
        } else {
            LogUtil.m15791e(TAG, "markFinish() framework is null.");
        }
    }
}
