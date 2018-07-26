package com.baidu.tts.loopj;

import android.os.Looper;
import java.lang.ref.WeakReference;

public class RequestHandle {
    private final WeakReference<AsyncHttpRequest> request;

    public RequestHandle(AsyncHttpRequest request) {
        this.request = new WeakReference(request);
    }

    public boolean cancel(final boolean mayInterruptIfRunning) {
        final AsyncHttpRequest asyncHttpRequest = (AsyncHttpRequest) this.request.get();
        if (asyncHttpRequest == null) {
            return false;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return asyncHttpRequest.cancel(mayInterruptIfRunning);
        }
        new Thread(new Runnable() {
            public void run() {
                asyncHttpRequest.cancel(mayInterruptIfRunning);
            }
        }).start();
        return true;
    }

    public boolean isFinished() {
        AsyncHttpRequest asyncHttpRequest = (AsyncHttpRequest) this.request.get();
        return asyncHttpRequest == null || asyncHttpRequest.isDone();
    }

    public boolean isCancelled() {
        AsyncHttpRequest asyncHttpRequest = (AsyncHttpRequest) this.request.get();
        return asyncHttpRequest == null || asyncHttpRequest.isCancelled();
    }

    public boolean shouldBeGarbageCollected() {
        boolean z = isCancelled() || isFinished();
        if (z) {
            this.request.clear();
        }
        return z;
    }

    public RequestHandle setTag(Object tag) {
        AsyncHttpRequest asyncHttpRequest = (AsyncHttpRequest) this.request.get();
        if (asyncHttpRequest != null) {
            asyncHttpRequest.setRequestTag(tag);
        }
        return this;
    }

    public Object getTag() {
        AsyncHttpRequest asyncHttpRequest = (AsyncHttpRequest) this.request.get();
        return asyncHttpRequest == null ? null : asyncHttpRequest.getTag();
    }
}
