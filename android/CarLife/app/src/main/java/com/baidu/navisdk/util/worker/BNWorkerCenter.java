package com.baidu.navisdk.util.worker;

import com.baidu.navisdk.util.common.LogUtil;
import java.util.concurrent.Future;

public class BNWorkerCenter implements IBNWorkerCenter {
    public static final String TAG = BNWorkerCenter.class.getSimpleName();
    private static BNWorkerCenter sInstance = null;
    private static final Object sInstanceLock = new Object();
    private IBNWorkerCenter mCurWorkerCenter = null;

    private BNWorkerCenter() {
    }

    public static void init(IBNWorkerCenter center) {
        if (sInstance == null) {
            synchronized (sInstanceLock) {
                if (sInstance == null) {
                    sInstance = new BNWorkerCenter();
                }
            }
        }
        if (center != null) {
            sInstance.setWorkerCenter(center);
            LogUtil.m15791e(TAG, "use the outer worker cetner.");
            return;
        }
        sInstance.setWorkerCenter(BNInnerWorkerCenter.getInstance());
        LogUtil.m15791e(TAG, "use the inner worker cetner.");
    }

    private void setWorkerCenter(IBNWorkerCenter center) {
        if (center == null) {
            LogUtil.m15791e(TAG, "setWorkerCenter() worker center is null !!!");
        } else if (this.mCurWorkerCenter != null) {
            LogUtil.m15791e(TAG, "setWorkerCenter() return for cur workder center is not null !!!");
        } else {
            this.mCurWorkerCenter = center;
        }
    }

    public static IBNWorkerCenter getInstance() {
        if (sInstance == null) {
            synchronized (sInstanceLock) {
                if (sInstance == null) {
                    sInstance = new BNWorkerCenter();
                }
            }
        }
        return sInstance;
    }

    public <K, T> Future<?> submitTask(BNWorkerTask<K, T> task, BNWorkerConfig config) {
        if (this.mCurWorkerCenter != null) {
            task.isCancelled = false;
            return this.mCurWorkerCenter.submitTask(task, config);
        }
        LogUtil.m15791e(TAG, "worker center is null.");
        return null;
    }

    public <K, T> void submitNormalTask(BNWorkerNormalTask<K, T> task, BNWorkerConfig config) {
        if (this.mCurWorkerCenter != null) {
            task.isCancelled = false;
            this.mCurWorkerCenter.submitNormalTask(task, config);
            return;
        }
        LogUtil.m15791e(TAG, "worker center is null.");
    }

    public <K, T> void submitNormalTaskDelay(BNWorkerNormalTask<K, T> task, BNWorkerConfig config, long delayMS) {
        if (this.mCurWorkerCenter != null) {
            task.isCancelled = false;
            this.mCurWorkerCenter.submitNormalTaskDelay(task, config, delayMS);
            return;
        }
        LogUtil.m15791e(TAG, "worker center is null.");
    }

    public <K, T> void submitCallbackTask(BNWorkerCallbackTask<K, T> task, BNWorkerConfig config) {
        if (this.mCurWorkerCenter != null) {
            task.isCancelled = false;
            this.mCurWorkerCenter.submitCallbackTask(task, config);
            return;
        }
        LogUtil.m15791e(TAG, "worker center is null.");
    }

    public <K, T> void submitHandlerTask(BNWorkerHandlerTask<K, T> task, BNWorkerConfig config) {
        if (this.mCurWorkerCenter != null) {
            task.isCancelled = false;
            this.mCurWorkerCenter.submitHandlerTask(task, config);
            return;
        }
        LogUtil.m15791e(TAG, "worker center is null.");
    }

    public <K, T> void submitBlockTask(BNWorkerBlockTask<K, T> task, BNWorkerConfig config) {
        if (this.mCurWorkerCenter != null) {
            task.isCancelled = false;
            this.mCurWorkerCenter.submitBlockTask(task, config);
            return;
        }
        LogUtil.m15791e(TAG, "worker center is null.");
    }

    public <K, T> void submitQueneTask(BNWorkerNormalTask<K, T> task, BNWorkerConfig config) {
        if (this.mCurWorkerCenter != null) {
            task.isCancelled = false;
            this.mCurWorkerCenter.submitQueneTask(task, config);
            return;
        }
        LogUtil.m15791e(TAG, "worker center is null.");
    }

    public <K, T> void submitQueneTaskDelay(BNWorkerNormalTask<K, T> task, BNWorkerConfig config, long delayMS) {
        if (this.mCurWorkerCenter != null) {
            task.isCancelled = false;
            this.mCurWorkerCenter.submitQueneTaskDelay(task, config, delayMS);
            return;
        }
        LogUtil.m15791e(TAG, "worker center is null.");
    }

    public <K, T> void submitMainThreadTask(BNWorkerNormalTask<K, T> task, BNWorkerConfig config) {
        if (this.mCurWorkerCenter != null) {
            task.isCancelled = false;
            this.mCurWorkerCenter.submitMainThreadTask(task, config);
            return;
        }
        LogUtil.m15791e(TAG, "worker center is null.");
    }

    public <K, T> void submitMainThreadTaskDelay(BNWorkerNormalTask<K, T> task, BNWorkerConfig config, long delayMS) {
        if (this.mCurWorkerCenter != null) {
            task.isCancelled = false;
            this.mCurWorkerCenter.submitMainThreadTaskDelay(task, config, delayMS);
            return;
        }
        LogUtil.m15791e(TAG, "worker center is null.");
    }

    public <K, T> void submitLooperChildThreadTask(BNWorkerNormalTask<K, T> task, BNWorkerConfig config) {
        if (this.mCurWorkerCenter != null) {
            task.isCancelled = false;
            this.mCurWorkerCenter.submitLooperChildThreadTask(task, config);
            return;
        }
        LogUtil.m15791e(TAG, "worker center is null.");
    }

    public <K, T> Future<?> removeTask(BNWorkerTask<K, T> task) {
        if (this.mCurWorkerCenter != null) {
            return this.mCurWorkerCenter.removeTask(task);
        }
        LogUtil.m15791e(TAG, "worker center is null.");
        return null;
    }

    public <K, T> boolean cancelTask(BNWorkerTask<K, T> task, boolean force) {
        if (this.mCurWorkerCenter != null) {
            return this.mCurWorkerCenter.cancelTask(task, force);
        }
        LogUtil.m15791e(TAG, "worker center is null.");
        return false;
    }
}
