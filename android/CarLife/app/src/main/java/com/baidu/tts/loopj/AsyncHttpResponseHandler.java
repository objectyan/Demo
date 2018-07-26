package com.baidu.tts.loopj;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.ByteArrayBuffer;

public abstract class AsyncHttpResponseHandler implements ResponseHandlerInterface {
    protected static final int BUFFER_SIZE = 4096;
    protected static final int CANCEL_MESSAGE = 6;
    public static final String DEFAULT_CHARSET = "UTF-8";
    protected static final int FAILURE_MESSAGE = 1;
    protected static final int FINISH_MESSAGE = 3;
    private static final String LOG_TAG = "AsyncHttpRH";
    protected static final int PROGRESS_MESSAGE = 4;
    protected static final int RETRY_MESSAGE = 5;
    protected static final int START_MESSAGE = 2;
    protected static final int SUCCESS_MESSAGE = 0;
    public static final String UTF8_BOM = "﻿";
    private WeakReference<Object> TAG;
    private Handler handler;
    private Looper looper;
    private Header[] requestHeaders;
    private URI requestURI;
    private String responseCharset;
    private boolean usePoolThread;
    private boolean useSynchronousMode;

    private static class ResponderHandler extends Handler {
        private final AsyncHttpResponseHandler mResponder;

        ResponderHandler(AsyncHttpResponseHandler mResponder, Looper looper) {
            super(looper);
            this.mResponder = mResponder;
        }

        public void handleMessage(Message msg) {
            this.mResponder.handleMessage(msg);
        }
    }

    public abstract void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th);

    public abstract void onSuccess(int i, Header[] headerArr, byte[] bArr);

    public AsyncHttpResponseHandler() {
        this(null);
    }

    public AsyncHttpResponseHandler(Looper looper) {
        this.responseCharset = "UTF-8";
        this.requestURI = null;
        this.requestHeaders = null;
        this.looper = null;
        this.TAG = new WeakReference(null);
        if (looper == null) {
            looper = Looper.myLooper();
        }
        this.looper = looper;
        setUseSynchronousMode(false);
        setUsePoolThread(false);
    }

    public AsyncHttpResponseHandler(boolean usePoolThread) {
        this.responseCharset = "UTF-8";
        this.requestURI = null;
        this.requestHeaders = null;
        this.looper = null;
        this.TAG = new WeakReference(null);
        setUsePoolThread(usePoolThread);
        if (!getUsePoolThread()) {
            this.looper = Looper.myLooper();
            setUseSynchronousMode(false);
        }
    }

    public void setTag(Object TAG) {
        this.TAG = new WeakReference(TAG);
    }

    public Object getTag() {
        return this.TAG.get();
    }

    public URI getRequestURI() {
        return this.requestURI;
    }

    public Header[] getRequestHeaders() {
        return this.requestHeaders;
    }

    public void setRequestURI(URI requestURI) {
        this.requestURI = requestURI;
    }

    public void setRequestHeaders(Header[] requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public boolean getUseSynchronousMode() {
        return this.useSynchronousMode;
    }

    public void setUseSynchronousMode(boolean sync) {
        if (!sync && this.looper == null) {
            sync = true;
            AsyncHttpClient.log.mo3907w(LOG_TAG, "Current thread has not called Looper.prepare(). Forcing synchronous mode.");
        }
        if (!sync && this.handler == null) {
            this.handler = new ResponderHandler(this, this.looper);
        } else if (sync && this.handler != null) {
            this.handler = null;
        }
        this.useSynchronousMode = sync;
    }

    public boolean getUsePoolThread() {
        return this.usePoolThread;
    }

    public void setUsePoolThread(boolean pool) {
        if (pool) {
            this.looper = null;
            this.handler = null;
        }
        this.usePoolThread = pool;
    }

    public void setCharset(String charset) {
        this.responseCharset = charset;
    }

    public String getCharset() {
        return this.responseCharset == null ? "UTF-8" : this.responseCharset;
    }

    public void onProgress(long bytesWritten, long totalSize) {
        LogInterface logInterface = AsyncHttpClient.log;
        String str = LOG_TAG;
        String str2 = "Progress %d from %d (%2.0f%%)";
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(bytesWritten);
        objArr[1] = Long.valueOf(totalSize);
        objArr[2] = Double.valueOf(totalSize > 0 ? ((((double) bytesWritten) * 1.0d) / ((double) totalSize)) * 100.0d : -1.0d);
        logInterface.mo3905v(str, String.format(str2, objArr));
    }

    public void onStart() {
    }

    public void onFinish() {
    }

    public void onPreProcessResponse(ResponseHandlerInterface instance, HttpResponse response) {
    }

    public void onPostProcessResponse(ResponseHandlerInterface instance, HttpResponse response) {
    }

    public void onRetry(int retryNo) {
        AsyncHttpClient.log.mo3894d(LOG_TAG, String.format("Request retry no. %d", new Object[]{Integer.valueOf(retryNo)}));
    }

    public void onCancel() {
        AsyncHttpClient.log.mo3894d(LOG_TAG, "Request got cancelled");
    }

    public void onUserException(Throwable error) {
        AsyncHttpClient.log.mo3897e(LOG_TAG, "User-space exception detected!", error);
        throw new RuntimeException(error);
    }

    public final void sendProgressMessage(long bytesWritten, long bytesTotal) {
        sendMessage(obtainMessage(4, new Object[]{Long.valueOf(bytesWritten), Long.valueOf(bytesTotal)}));
    }

    public final void sendSuccessMessage(int statusCode, Header[] headers, byte[] responseBytes) {
        sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(statusCode), headers, responseBytes}));
    }

    public final void sendFailureMessage(int statusCode, Header[] headers, byte[] responseBody, Throwable throwable) {
        sendMessage(obtainMessage(1, new Object[]{Integer.valueOf(statusCode), headers, responseBody, throwable}));
    }

    public final void sendStartMessage() {
        sendMessage(obtainMessage(2, null));
    }

    public final void sendFinishMessage() {
        sendMessage(obtainMessage(3, null));
    }

    public final void sendRetryMessage(int retryNo) {
        sendMessage(obtainMessage(5, new Object[]{Integer.valueOf(retryNo)}));
    }

    public final void sendCancelMessage() {
        sendMessage(obtainMessage(6, null));
    }

    protected void handleMessage(Message message) {
        try {
            Object[] objArr;
            switch (message.what) {
                case 0:
                    objArr = (Object[]) message.obj;
                    if (objArr == null || objArr.length < 3) {
                        AsyncHttpClient.log.mo3896e(LOG_TAG, "SUCCESS_MESSAGE didn't got enough params");
                        return;
                    } else {
                        onSuccess(((Integer) objArr[0]).intValue(), (Header[]) objArr[1], (byte[]) objArr[2]);
                        return;
                    }
                case 1:
                    objArr = (Object[]) message.obj;
                    if (objArr == null || objArr.length < 4) {
                        AsyncHttpClient.log.mo3896e(LOG_TAG, "FAILURE_MESSAGE didn't got enough params");
                        return;
                    } else {
                        onFailure(((Integer) objArr[0]).intValue(), (Header[]) objArr[1], (byte[]) objArr[2], (Throwable) objArr[3]);
                        return;
                    }
                case 2:
                    onStart();
                    return;
                case 3:
                    onFinish();
                    return;
                case 4:
                    objArr = (Object[]) message.obj;
                    if (objArr == null || objArr.length < 2) {
                        AsyncHttpClient.log.mo3896e(LOG_TAG, "PROGRESS_MESSAGE didn't got enough params");
                        return;
                    } else {
                        onProgress(((Long) objArr[0]).longValue(), ((Long) objArr[1]).longValue());
                        return;
                    }
                case 5:
                    objArr = (Object[]) message.obj;
                    if (objArr == null || objArr.length != 1) {
                        AsyncHttpClient.log.mo3896e(LOG_TAG, "RETRY_MESSAGE didn't get enough params");
                        return;
                    } else {
                        onRetry(((Integer) objArr[0]).intValue());
                        return;
                    }
                case 6:
                    onCancel();
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            onUserException(th);
        }
        onUserException(th);
    }

    protected void sendMessage(Message msg) {
        if (getUseSynchronousMode() || this.handler == null) {
            handleMessage(msg);
        } else if (!Thread.currentThread().isInterrupted()) {
            Utils.asserts(this.handler != null, "handler should not be null!");
            this.handler.sendMessage(msg);
        }
    }

    protected void postRunnable(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (getUseSynchronousMode() || this.handler == null) {
            runnable.run();
        } else {
            this.handler.post(runnable);
        }
    }

    protected Message obtainMessage(int responseMessageId, Object responseMessageData) {
        return Message.obtain(this.handler, responseMessageId, responseMessageData);
    }

    public void sendResponseMessage(HttpResponse response) throws IOException {
        if (!Thread.currentThread().isInterrupted()) {
            StatusLine statusLine = response.getStatusLine();
            byte[] responseData = getResponseData(response.getEntity());
            if (!Thread.currentThread().isInterrupted()) {
                if (statusLine.getStatusCode() >= 300) {
                    sendFailureMessage(statusLine.getStatusCode(), response.getAllHeaders(), responseData, new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()));
                } else {
                    sendSuccessMessage(statusLine.getStatusCode(), response.getAllHeaders(), responseData);
                }
            }
        }
    }

    byte[] getResponseData(HttpEntity entity) throws IOException {
        int i = 4096;
        if (entity != null) {
            InputStream content = entity.getContent();
            if (content != null) {
                long contentLength = entity.getContentLength();
                if (contentLength > 2147483647L) {
                    throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
                }
                if (contentLength > 0) {
                    i = (int) contentLength;
                }
                try {
                    ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(i);
                    byte[] bArr = new byte[4096];
                    long j = 0;
                    while (true) {
                        int read = content.read(bArr);
                        if (read == -1 || Thread.currentThread().isInterrupted()) {
                            break;
                        }
                        long j2 = ((long) read) + j;
                        byteArrayBuffer.append(bArr, 0, read);
                        if (contentLength <= 0) {
                            j = 1;
                        } else {
                            j = contentLength;
                        }
                        sendProgressMessage(j2, j);
                        j = j2;
                    }
                    AsyncHttpClient.silentCloseInputStream(content);
                    AsyncHttpClient.endEntityViaReflection(entity);
                    return byteArrayBuffer.toByteArray();
                } catch (OutOfMemoryError e) {
                    System.gc();
                    throw new IOException("File too large to fit into available memory");
                } catch (Throwable th) {
                    AsyncHttpClient.silentCloseInputStream(content);
                    AsyncHttpClient.endEntityViaReflection(entity);
                }
            }
        }
        return null;
    }
}
