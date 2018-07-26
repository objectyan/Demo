package com.baidu.navisdk.util.worker;

public abstract class BNWorkerNormalTask<K, T> extends BNWorkerTask<K, T> {
    protected abstract T execute();

    protected BNWorkerNormalTask(String taskName, K pInData) {
        super(taskName, (Object) pInData);
    }

    public BNWorkerNormalTask(String taskName, K[] pInDatas, boolean no) {
        super(taskName, (Object[]) pInDatas);
    }

    protected final void notifyResult(T t) {
    }
}
