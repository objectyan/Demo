package com.baidu.navisdk.util.worker;

public abstract class BNWorkerCallbackTask<K, T> extends BNWorkerTask<K, T> {
    public abstract void callback(T t);

    public BNWorkerCallbackTask(String taskName, K pInData) {
        super(taskName, (Object) pInData);
    }

    protected final void notifyResult(T result) {
        callback(result);
    }
}
