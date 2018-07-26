package com.loopj.android.http;

import android.os.Looper;
import java.lang.ref.WeakReference;

public class RequestHandle {
    private final WeakReference<AsyncHttpRequest> request;

    public RequestHandle(AsyncHttpRequest request) {
        this.request = new WeakReference(request);
    }

    public boolean cancel(final boolean mayInterruptIfRunning) {
        final AsyncHttpRequest _request = (AsyncHttpRequest) this.request.get();
        if (_request == null) {
            return false;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return _request.cancel(mayInterruptIfRunning);
        }
        new Thread(new Runnable() {
            public void run() {
                _request.cancel(mayInterruptIfRunning);
            }
        }).start();
        return true;
    }

    public boolean isFinished() {
        AsyncHttpRequest _request = (AsyncHttpRequest) this.request.get();
        return _request == null || _request.isDone();
    }

    public boolean isCancelled() {
        AsyncHttpRequest _request = (AsyncHttpRequest) this.request.get();
        return _request == null || _request.isCancelled();
    }

    public boolean shouldBeGarbageCollected() {
        boolean should = isCancelled() || isFinished();
        if (should) {
            this.request.clear();
        }
        return should;
    }

    public Object getTag() {
        AsyncHttpRequest _request = (AsyncHttpRequest) this.request.get();
        return _request == null ? null : _request.getTag();
    }

    public RequestHandle setTag(Object tag) {
        AsyncHttpRequest _request = (AsyncHttpRequest) this.request.get();
        if (_request != null) {
            _request.setRequestTag(tag);
        }
        return this;
    }
}
