package com.baidu.mapframework.commonlib.asynchttp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpUriRequest;

public abstract class RangeFileAsyncHttpResponseHandler extends FileAsyncHttpResponseHandler {
    /* renamed from: a */
    private static final String f18898a = "RangeFileAsyncHttpRH";
    /* renamed from: b */
    private long f18899b = 0;
    /* renamed from: c */
    private boolean f18900c = false;

    public RangeFileAsyncHttpResponseHandler(File file) {
        super(file);
    }

    public void sendResponseMessage(HttpResponse response) throws IOException {
        if (!Thread.currentThread().isInterrupted()) {
            StatusLine status = response.getStatusLine();
            if (status.getStatusCode() == 416) {
                if (!Thread.currentThread().isInterrupted()) {
                    sendSuccessMessage(status.getStatusCode(), response.getAllHeaders(), null);
                }
            } else if (status.getStatusCode() >= 300) {
                if (!Thread.currentThread().isInterrupted()) {
                    sendFailureMessage(status.getStatusCode(), response.getAllHeaders(), null, new HttpResponseException(status.getStatusCode(), status.getReasonPhrase()));
                }
            } else if (!Thread.currentThread().isInterrupted()) {
                Header header = response.getFirstHeader("Content-Range");
                if (header == null) {
                    this.f18900c = false;
                    this.f18899b = 0;
                } else {
                    AsyncHttpClient.log.mo2634v(f18898a, "Content-Range: " + header.getValue());
                }
                sendSuccessMessage(status.getStatusCode(), response.getAllHeaders(), getResponseData(response.getEntity()));
            }
        }
    }

    protected byte[] getResponseData(HttpEntity entity) throws IOException {
        if (entity != null) {
            InputStream instream = entity.getContent();
            long contentLength = entity.getContentLength() + this.f18899b;
            FileOutputStream buffer = new FileOutputStream(getTargetFile(), this.f18900c);
            if (instream != null) {
                try {
                    byte[] tmp = new byte[4096];
                    while (this.f18899b < contentLength) {
                        int l = instream.read(tmp);
                        if (l == -1 || Thread.currentThread().isInterrupted()) {
                            break;
                        }
                        this.f18899b += (long) l;
                        buffer.write(tmp, 0, l);
                        sendProgressMessage(this.f18899b, contentLength);
                    }
                    instream.close();
                    buffer.flush();
                    buffer.close();
                } catch (Throwable th) {
                    instream.close();
                    buffer.flush();
                    buffer.close();
                }
            }
        }
        return null;
    }

    public void updateRequestHeaders(HttpUriRequest uriRequest) {
        if (this.file.exists() && this.file.canWrite()) {
            this.f18899b = this.file.length();
        }
        if (this.f18899b > 0) {
            this.f18900c = true;
            uriRequest.setHeader("Range", "bytes=" + this.f18899b + "-");
        }
    }
}
