package com.baidu.mapframework.nirvana.concurrent;

import com.baidu.mapframework.nirvana.C3480g;

public abstract class ConcurrentTask extends C3480g implements Runnable {
    private QueueToken queueToken = null;

    QueueToken getQueueToken() {
        return this.queueToken;
    }

    public void setQueueToken(QueueToken queueToken) {
        this.queueToken = queueToken;
    }
}
