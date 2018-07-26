package com.baidu.mapframework.commonlib.asynchttp;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

class RetryHandler implements HttpRequestRetryHandler {
    /* renamed from: a */
    private static final HashSet<Class<?>> f18907a = new HashSet();
    /* renamed from: b */
    private static final HashSet<Class<?>> f18908b = new HashSet();
    /* renamed from: c */
    private final int f18909c;
    /* renamed from: d */
    private final int f18910d;

    static {
        f18907a.add(NoHttpResponseException.class);
        f18907a.add(UnknownHostException.class);
        f18907a.add(SocketException.class);
        f18908b.add(InterruptedIOException.class);
        f18908b.add(SSLException.class);
    }

    public RetryHandler(int maxRetries, int retrySleepTimeMS) {
        this.f18909c = maxRetries;
        this.f18910d = retrySleepTimeMS;
    }

    /* renamed from: a */
    static void m14968a(Class<?> cls) {
        f18907a.add(cls);
    }

    /* renamed from: b */
    static void m14969b(Class<?> cls) {
        f18908b.add(cls);
    }

    public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
        boolean sent;
        boolean retry = true;
        Boolean b = (Boolean) context.getAttribute("http.request_sent");
        if (b == null || !b.booleanValue()) {
            sent = false;
        } else {
            sent = true;
        }
        if (executionCount > this.f18909c) {
            retry = false;
        } else if (isInList(f18907a, exception)) {
            retry = true;
        } else if (isInList(f18908b, exception)) {
            retry = false;
        } else if (!sent) {
            retry = true;
        }
        if (retry && ((HttpUriRequest) context.getAttribute("http.request")) == null) {
            return false;
        }
        if (retry) {
            SystemClock.sleep((long) this.f18910d);
        } else {
            exception.printStackTrace();
        }
        return retry;
    }

    protected boolean isInList(HashSet<Class<?>> list, Throwable error) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((Class) it.next()).isInstance(error)) {
                return true;
            }
        }
        return false;
    }
}
