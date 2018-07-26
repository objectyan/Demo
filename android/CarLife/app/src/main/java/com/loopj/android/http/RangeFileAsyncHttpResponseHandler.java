package com.loopj.android.http;

import cz.msebera.android.httpclient.C3008n;
import cz.msebera.android.httpclient.C6228x;
import cz.msebera.android.httpclient.C6327f;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.p158b.C6266l;
import cz.msebera.android.httpclient.p158b.p159d.C6034q;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class RangeFileAsyncHttpResponseHandler extends FileAsyncHttpResponseHandler {
    private static final String LOG_TAG = "RangeFileAsyncHttpRH";
    private boolean append = false;
    private long current = 0;

    public RangeFileAsyncHttpResponseHandler(File file) {
        super(file);
    }

    public void sendResponseMessage(C6228x response) throws IOException {
        if (!Thread.currentThread().isInterrupted()) {
            an status = response.mo5067a();
            if (status.mo5266b() == 416) {
                if (!Thread.currentThread().isInterrupted()) {
                    sendSuccessMessage(status.mo5266b(), response.getAllHeaders(), null);
                }
            } else if (status.mo5266b() >= 300) {
                if (!Thread.currentThread().isInterrupted()) {
                    sendFailureMessage(status.mo5266b(), response.getAllHeaders(), null, new C6266l(status.mo5266b(), status.mo5267c()));
                }
            } else if (!Thread.currentThread().isInterrupted()) {
                C6327f header = response.getFirstHeader("Content-Range");
                if (header == null) {
                    this.append = false;
                    this.current = 0;
                } else {
                    AsyncHttpClient.log.mo4889v(LOG_TAG, "Content-Range: " + header.mo5248d());
                }
                sendSuccessMessage(status.mo5266b(), response.getAllHeaders(), getResponseData(response.mo5075b()));
            }
        }
    }

    protected byte[] getResponseData(C3008n entity) throws IOException {
        if (entity != null) {
            InputStream instream = entity.getContent();
            long contentLength = entity.getContentLength() + this.current;
            FileOutputStream buffer = new FileOutputStream(getTargetFile(), this.append);
            if (instream != null) {
                try {
                    byte[] tmp = new byte[4096];
                    while (this.current < contentLength) {
                        int l = instream.read(tmp);
                        if (l == -1 || Thread.currentThread().isInterrupted()) {
                            break;
                        }
                        this.current += (long) l;
                        buffer.write(tmp, 0, l);
                        sendProgressMessage(this.current, contentLength);
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

    public void updateRequestHeaders(C6034q uriRequest) {
        if (this.file.exists() && this.file.canWrite()) {
            this.current = this.file.length();
        }
        if (this.current > 0) {
            this.append = true;
            uriRequest.setHeader("Range", "bytes=" + this.current + "-");
        }
    }
}
