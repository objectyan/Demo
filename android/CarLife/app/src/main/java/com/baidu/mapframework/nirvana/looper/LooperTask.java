package com.baidu.mapframework.nirvana.looper;

public abstract class LooperTask extends BaseLooperTask {
    private long delay = 0;

    public LooperTask(long delay) {
        this.delay = delay;
    }

    public LooperTask(String description) {
        appendDescription(description);
    }

    long getDelay() {
        return this.delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public String toString() {
        return "LooperTask{description=" + getDescription() + ", delay=" + this.delay + ", isCancel=" + isCancel() + '}';
    }
}
