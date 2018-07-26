package com.baidu.tts.loopj;

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
    private static final String LOG_TAG = "RangeFileAsyncHttpRH";
    private boolean append = false;
    private long current = 0;

    public RangeFileAsyncHttpResponseHandler(File file) {
        super(file);
    }

    public void sendResponseMessage(HttpResponse response) throws IOException {
        if (!Thread.currentThread().isInterrupted()) {
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == 416) {
                if (!Thread.currentThread().isInterrupted()) {
                    sendSuccessMessage(statusLine.getStatusCode(), response.getAllHeaders(), null);
                }
            } else if (statusLine.getStatusCode() >= 300) {
                if (!Thread.currentThread().isInterrupted()) {
                    sendFailureMessage(statusLine.getStatusCode(), response.getAllHeaders(), null, new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()));
                }
            } else if (!Thread.currentThread().isInterrupted()) {
                Header firstHeader = response.getFirstHeader("Content-Range");
                if (firstHeader == null) {
                    this.append = false;
                    this.current = 0;
                } else {
                    AsyncHttpClient.log.mo3905v(LOG_TAG, "Content-Range: " + firstHeader.getValue());
                }
                sendSuccessMessage(statusLine.getStatusCode(), response.getAllHeaders(), getResponseData(response.getEntity()));
            }
        }
    }

    protected byte[] getResponseData(HttpEntity entity) throws IOException {
        if (entity != null) {
            InputStream content = entity.getContent();
            long contentLength = entity.getContentLength() + this.current;
            FileOutputStream fileOutputStream = new FileOutputStream(getTargetFile(), this.append);
            if (content != null) {
                try {
                    byte[] bArr = new byte[4096];
                    while (this.current < contentLength) {
                        int read = content.read(bArr);
                        if (read == -1 || Thread.currentThread().isInterrupted()) {
                            break;
                        }
                        this.current += (long) read;
                        fileOutputStream.write(bArr, 0, read);
                        sendProgressMessage(this.current, contentLength);
                    }
                    content.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (Throwable th) {
                    content.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            }
        }
        return null;
    }

    public void updateRequestHeaders(HttpUriRequest uriRequest) {
        if (this.file.exists() && this.file.canWrite()) {
            this.current = this.file.length();
        }
        if (this.current > 0) {
            this.append = true;
            uriRequest.setHeader("Range", "bytes=" + this.current + "-");
        }
    }
}
