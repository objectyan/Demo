package com.baidu.navisdk.util.task;

import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

public abstract class TaskRunnable<K, T> extends BNWorkerNormalTask<K, T> {
    public static final int TYPE_BG = 1;
    public static final int TYPE_MAIN = 0;
    private OnRunListener mRunListener;
    public int mType;

    public interface OnRunListener {
        void onComplete(TaskRunnable<?, ?> taskRunnable);
    }

    public abstract void doTask();

    public TaskRunnable(String taskName, K pInData, int type) {
        super(taskName, pInData);
        this.mType = type;
    }

    public T execute() {
        doTask();
        if (this.mRunListener != null) {
            this.mRunListener.onComplete(this);
        }
        return null;
    }

    public void setOnRunListener(OnRunListener listener) {
        this.mRunListener = listener;
    }
}
