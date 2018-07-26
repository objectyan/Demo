package com.baidu.cloudsdk.common.http;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

class MultipartEntity implements HttpEntity {
    private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private String mBoundary;
    private byte[] mBoundaryLineBytes;
    private boolean mIsSetFirst = false;
    private boolean mIsSetLast = false;
    private ByteArrayOutputStream mOut = new ByteArrayOutputStream();

    public MultipartEntity() {
        StringBuilder builder = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 30; i++) {
            builder.append(MULTIPART_CHARS[rand.nextInt(MULTIPART_CHARS.length)]);
        }
        this.mBoundary = builder.toString();
        this.mBoundaryLineBytes = ("\r\n--" + this.mBoundary + "\r\n").getBytes();
    }

    protected void addPart(String key, String value) {
        try {
            writeBoundaryLine();
            this.mOut.write(("Content-Disposition: form-data; name=\"" + key + "\"\r\n\r\n").getBytes());
            this.mOut.write(value.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void addPart(String key, String filename, InputStream in, String contentType, boolean isLast) {
        try {
            writeBoundaryLine();
            this.mOut.write(("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"" + filename + "\"\r\n").getBytes());
            if (contentType != null) {
                this.mOut.write(("Content-Type: " + contentType + "\r\n\r\n").getBytes());
            } else {
                this.mOut.write("Content-Type: application/octet-stream\r\n\r\n".getBytes());
            }
            byte[] buffer = new byte[4096];
            while (true) {
                int len = in.read(buffer);
                if (len != -1) {
                    this.mOut.write(buffer, 0, len);
                } else {
                    this.mOut.flush();
                    try {
                        in.close();
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            try {
                in.close();
            } catch (IOException e22) {
                e22.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                in.close();
            } catch (IOException e222) {
                e222.printStackTrace();
            }
            throw th;
        }
    }

    public void consumeContent() throws IOException {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public InputStream getContent() throws IOException, IllegalStateException {
        return new ByteArrayInputStream(this.mOut.toByteArray());
    }

    public Header getContentEncoding() {
        return null;
    }

    public long getContentLength() {
        writeLastBoundaryIfNeeds();
        return (long) this.mOut.toByteArray().length;
    }

    public Header getContentType() {
        return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.mBoundary);
    }

    public boolean isChunked() {
        return false;
    }

    public boolean isRepeatable() {
        return false;
    }

    public boolean isStreaming() {
        return false;
    }

    public void writeTo(OutputStream outputstream) throws IOException {
        outputstream.write(this.mOut.toByteArray());
    }

    private void writeBoundaryLine() throws IOException {
        if (this.mIsSetFirst) {
            this.mOut.write(this.mBoundaryLineBytes);
            return;
        }
        this.mIsSetFirst = true;
        this.mOut.write(("--" + this.mBoundary + "\r\n").getBytes());
    }

    private void writeLastBoundaryIfNeeds() {
        if (!this.mIsSetLast) {
            try {
                this.mOut.write(("\r\n--" + this.mBoundary + "--\r\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.mIsSetLast = true;
        }
    }
}
