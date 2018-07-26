package com.baidu.mapframework.commonlib.asynchttp;

import android.os.Looper;
import java.lang.ref.WeakReference;

public class RequestHandle {
    /* renamed from: a */
    private final WeakReference<AsyncHttpRequest> f18904a;

    public RequestHandle(AsyncHttpRequest request) {
        this.f18904a = new WeakReference(request);
    }

    public boolean cancel(final boolean mayInterruptIfRunning) {
        final AsyncHttpRequest _request = (AsyncHttpRequest) this.f18904a.get();
        if (_request == null) {
            return false;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return _request.cancel(mayInterruptIfRunning);
        }
        new Thread(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ RequestHandle f18903c;

            public void run() {
                _request.cancel(mayInterruptIfRunning);
            }
        }).start();
        return true;
    }

    public boolean isFinished() {
        AsyncHttpRequest _request = (AsyncHttpRequest) this.f18904a.get();
        return _request == null || _request.isDone();
    }

    public boolean isCancelled() {
        AsyncHttpRequest _request = (AsyncHttpRequest) this.f18904a.get();
        return _request == null || _request.isCancelled();
    }

    public boolean shouldBeGarbageCollected() {
        boolean should = isCancelled() || isFinished();
        if (should) {
            this.f18904a.clear();
        }
        return should;
    }

    public Object getTag() {
        AsyncHttpRequest _request = (AsyncHttpRequest) this.f18904a.get();
        return _request == null ? null : _request.getTag();
    }

    public RequestHandle setTag(Object tag) {
        AsyncHttpRequest _request = (AsyncHttpRequest) this.f18904a.get();
        if (_request != null) {
            _request.setRequestTag(tag);
        }
        return this;
    }
}
