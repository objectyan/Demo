package com.baidu.navi.utils.http;

import android.os.SystemClock;
import com.baidu.navisdk.util.common.LogUtil;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

class RetryHandler implements HttpRequestRetryHandler {
    private static final int RETRY_SLEEP_TIME_MILLIS = 500;
    private int maxRetries;

    public RetryHandler(int maxRetries) {
        this.maxRetries = maxRetries;
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
        if (executionCount > this.maxRetries) {
            retry = false;
        } else if (exception instanceof InterruptedIOException) {
            retry = false;
        } else if (exception instanceof SSLException) {
            retry = false;
        } else if (exception instanceof NoHttpResponseException) {
            retry = true;
        } else if (exception instanceof SocketException) {
            retry = true;
        } else if (exception instanceof UnknownHostException) {
            retry = true;
        } else if (!sent) {
            retry = true;
        }
        if (retry) {
            if (((HttpRequest) context.getAttribute("http.request")) instanceof HttpEntityEnclosingRequest) {
                retry = false;
            } else {
                retry = true;
            }
        }
        if (retry) {
            SystemClock.sleep(500);
        } else {
            LogUtil.m15791e("plugin", exception == null ? "null poit of retry exception" : exception.getMessage());
        }
        return retry;
    }
}
