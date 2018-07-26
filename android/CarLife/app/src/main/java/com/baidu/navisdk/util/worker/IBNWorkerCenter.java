package com.baidu.navisdk.util.worker;

import com.baidu.navisdk.util.common.LogUtil;
import java.util.concurrent.Future;

public interface IBNWorkerCenter {
    public static final boolean MONITOR_TEST = LogUtil.LOGGABLE;

    <K, T> boolean cancelTask(BNWorkerTask<K, T> bNWorkerTask, boolean z);

    <K, T> Future<?> removeTask(BNWorkerTask<K, T> bNWorkerTask);

    <K, T> void submitBlockTask(BNWorkerBlockTask<K, T> bNWorkerBlockTask, BNWorkerConfig bNWorkerConfig);

    <K, T> void submitCallbackTask(BNWorkerCallbackTask<K, T> bNWorkerCallbackTask, BNWorkerConfig bNWorkerConfig);

    <K, T> void submitHandlerTask(BNWorkerHandlerTask<K, T> bNWorkerHandlerTask, BNWorkerConfig bNWorkerConfig);

    <K, T> void submitLooperChildThreadTask(BNWorkerNormalTask<K, T> bNWorkerNormalTask, BNWorkerConfig bNWorkerConfig);

    <K, T> void submitMainThreadTask(BNWorkerNormalTask<K, T> bNWorkerNormalTask, BNWorkerConfig bNWorkerConfig);

    <K, T> void submitMainThreadTaskDelay(BNWorkerNormalTask<K, T> bNWorkerNormalTask, BNWorkerConfig bNWorkerConfig, long j);

    <K, T> void submitNormalTask(BNWorkerNormalTask<K, T> bNWorkerNormalTask, BNWorkerConfig bNWorkerConfig);

    <K, T> void submitNormalTaskDelay(BNWorkerNormalTask<K, T> bNWorkerNormalTask, BNWorkerConfig bNWorkerConfig, long j);

    <K, T> void submitQueneTask(BNWorkerNormalTask<K, T> bNWorkerNormalTask, BNWorkerConfig bNWorkerConfig);

    <K, T> void submitQueneTaskDelay(BNWorkerNormalTask<K, T> bNWorkerNormalTask, BNWorkerConfig bNWorkerConfig, long j);

    <K, T> Future<?> submitTask(BNWorkerTask<K, T> bNWorkerTask, BNWorkerConfig bNWorkerConfig);
}
