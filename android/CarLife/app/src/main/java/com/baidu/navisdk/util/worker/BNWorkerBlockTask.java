package com.baidu.navisdk.util.worker;

public abstract class BNWorkerBlockTask<K, T> extends BNWorkerTask<K, T> {
    protected BNWorkerBlockTask(String taskName, K pInData) {
        super(taskName, (Object) pInData);
    }

    protected final void notifyResult(T t) {
    }
}
