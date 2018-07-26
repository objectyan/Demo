package com.baidu.mapframework.nirvana.looper;

import com.baidu.mapframework.nirvana.C3480g;

public abstract class BaseLooperTask extends C3480g implements Runnable {
    private boolean isCancel = false;
    private Runnable onCancelRunnable = null;

    public synchronized void cancel() {
        this.isCancel = true;
        if (this.onCancelRunnable != null) {
            this.onCancelRunnable.run();
        }
    }

    public synchronized boolean isCancel() {
        return this.isCancel;
    }

    synchronized void setOnCancel(Runnable runnable) {
        this.onCancelRunnable = runnable;
    }
}
