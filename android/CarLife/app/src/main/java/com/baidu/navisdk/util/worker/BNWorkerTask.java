package com.baidu.navisdk.util.worker;

import com.baidu.navisdk.util.common.LogUtil;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public abstract class BNWorkerTask<K, T> implements Callable<T> {
    public static final String TAG = BNWorkerCenter.TAG;
    protected K inData = null;
    protected K[] inDatas = null;
    volatile boolean isCancelled = false;
    private String taskName = "CarNavi-poly";

    protected abstract T execute();

    protected abstract void notifyResult(T t);

    protected K getInData() {
        return this.inData;
    }

    protected K[] getInDatas() {
        return this.inDatas;
    }

    protected BNWorkerTask(String taskName, K pInData) {
        if (taskName != null) {
            this.taskName = "CarNavi-" + taskName;
        }
        this.inData = pInData;
    }

    protected BNWorkerTask(String taskName, K[] pInDatas) {
        if (taskName != null) {
            this.taskName = "CarNavi-" + taskName;
        }
        this.inDatas = pInDatas;
    }

    public final String getTaskName() {
        return this.taskName;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    protected final T executeWrapper() {
        long curTime = 0;
        if (LogUtil.LOGGABLE) {
            LogUtil.m15791e(TAG, "start task execute. task=" + getTaskName());
            curTime = System.currentTimeMillis();
        }
        T t = null;
        try {
            if (isCancelled()) {
                BNWorkerCenter.getInstance().removeTask(this);
                LogUtil.m15791e(TAG, "not execute for the task has been cancelled. task=" + getTaskName());
            } else {
                t = execute();
                Future<?> future = BNWorkerCenter.getInstance().removeTask(this);
                if (future != null && (isCancelled() || future.isCancelled())) {
                    LogUtil.m15791e(TAG, "task has been cancelled. task=" + getTaskName());
                } else if (future != null) {
                    notifyResult(t);
                } else {
                    LogUtil.m15791e(TAG, "task not found. task=" + getTaskName());
                }
            }
        } catch (Exception e) {
            LogUtil.m15791e(TAG, "task execute exception. ex=" + e.getMessage());
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
            }
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.m15791e(TAG, "end task execute. task=" + getTaskName() + ", executeTime=" + (System.currentTimeMillis() - curTime));
        }
        return t;
    }

    public final T call() throws Exception {
        return executeWrapper();
    }
}
