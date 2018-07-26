package com.baidu.mapframework.nirvana.concurrent;

import com.baidu.mapframework.nirvana.C3480g;
import java.util.concurrent.Callable;

public abstract class ConcurrentCallable<T> extends C3480g implements Callable<T> {
    private QueueToken queueToken = null;

    QueueToken getQueueToken() {
        return this.queueToken;
    }

    public void setQueueToken(QueueToken queueToken) {
        this.queueToken = queueToken;
    }
}
