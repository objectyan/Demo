package com.baidu.navisdk.util.worker.loop;

import android.os.Message;

public interface IBNPerformceFramework {
    void markFinish(Message message);

    void markRunning(Message message);

    void markSubmit(Message message);

    void runInLooperBuffer(Runnable runnable);
}
