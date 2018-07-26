package com.baidu.navisdk.util.worker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class BNInnerWorkerCenter extends BNWorkerCenterAbs {
    private static final int THREADPOOL_COUNT = 3;
    private static IBNWorkerCenter sInstance = null;
    private static final Object sInstanceLock = new Object();
    private ExecutorService executorService = null;

    private BNInnerWorkerCenter() {
        init();
    }

    public static IBNWorkerCenter getInstance() {
        if (sInstance == null) {
            synchronized (sInstanceLock) {
                if (sInstance == null) {
                    sInstance = new BNInnerWorkerCenter();
                }
            }
        }
        return sInstance;
    }

    private void init() {
        this.executorService = Executors.newFixedThreadPool(3);
    }

    public <K, T> Future<?> submitTask(BNWorkerTask<K, T> task, BNWorkerConfig config) {
        Future<?> future = null;
        if (checkTask(task) && this.executorService != null) {
            future = this.executorService.submit(task);
            if (future != null) {
                this.taskFutures.put(task, future);
            }
        }
        return future;
    }

    public <K, T> void submitMainThreadTask(BNWorkerNormalTask<K, T> bNWorkerNormalTask, BNWorkerConfig config) {
    }
}
