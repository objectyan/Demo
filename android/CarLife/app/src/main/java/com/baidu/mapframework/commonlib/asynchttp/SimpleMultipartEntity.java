package com.baidu.mapframework.commonlib.asynchttp;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

class SimpleMultipartEntity implements HttpEntity {
    protected static final byte[] CR_LF = STR_CR_LF.getBytes();
    protected static final String STR_CR_LF = "\r\n";
    /* renamed from: a */
    private static final String f18917a = "SimpleMultipartEntity";
    /* renamed from: b */
    private static final byte[] f18918b = "Content-Transfer-Encoding: binary\r\n".getBytes();
    /* renamed from: c */
    private static final char[] f18919c = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    protected final String boundary;
    protected final byte[] boundaryEnd;
    protected final byte[] boundaryLine;
    /* renamed from: d */
    private final List<FilePart> f18920d = new ArrayList();
    /* renamed from: e */
    private final ResponseHandlerInterface f18921e;
    /* renamed from: f */
    private boolean f18922f;
    /* renamed from: g */
    private long f18923g;
    /* renamed from: h */
    private long f18924h;
    protected final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private class FilePart {
        /* renamed from: a */
        final /* synthetic */ SimpleMultipartEntity f18916a;
        public File file;
        public byte[] header;

        public FilePart(SimpleMultipartEntity simpleMultipartEntity, String key, File file, String type, String customFileName) {
            this.f18916a = simpleMultipartEntity;
            if (TextUtils.isEmpty(customFileName)) {
                customFileName = file.getName();
            }
            this.header = m14972a(key, customFileName, type);
            this.file = file;
        }

        public FilePart(SimpleMultipartEntity simpleMultipartEntity, String key, File file, String type) {
            this.f18916a = simpleMultipartEntity;
            this.header = m14972a(key, file.getName(), type);
            this.file = file;
        }

        /* renamed from: a */
        private byte[] m14972a(String key, String filename, String type) {
            ByteArrayOutputStream headerStream = new ByteArrayOutputStream();
            try {
                headerStream.write(this.f18916a.boundaryLine);
                headerStream.write(this.f18916a.m14979a(key, filename));
                headerStream.write(this.f18916a.m14980b(type));
                headerStream.write(SimpleMultipartEntity.f18918b);
                headerStream.write(SimpleMultipartEntity.CR_LF);
            } catch (IOException e) {
                AsyncHttpClient.log.mo2626e(SimpleMultipartEntity.f18917a, "createHeader ByteArrayOutputStream exception", e);
            }
            return headerStream.toByteArray();
        }

        public long getTotalLength() {
            return ((long) this.header.length) + (this.file.length() + ((long) SimpleMultipartEntity.CR_LF.length));
        }

        public void writeTo(OutputStream out) throws IOException {
            out.write(this.header);
            this.f18916a.m14974a((long) this.header.length);
            FileInputStream inputStream = new FileInputStream(this.file);
            byte[] tmp = new byte[4096];
            while (true) {
                int bytesRead = inputStream.read(tmp);
                if (bytesRead != -1) {
                    out.write(tmp, 0, bytesRead);
                    this.f18916a.m14974a((long) bytesRead);
                } else {
                    out.write(SimpleMultipartEntity.CR_LF);
                    this.f18916a.m14974a((long) SimpleMultipartEntity.CR_LF.length);
                    out.flush();
                    AsyncHttpClient.silentCloseInputStream(inputStream);
                    return;
                }
            }
        }
    }

    public SimpleMultipartEntity(ResponseHandlerInterface progressHandler) {
        StringBuilder buf = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 30; i++) {
            buf.append(f18919c[rand.nextInt(f18919c.length)]);
        }
        this.boundary = buf.toString();
        this.boundaryLine = ("--" + this.boundary + STR_CR_LF).getBytes();
        this.boundaryEnd = ("--" + this.boundary + "--" + STR_CR_LF).getBytes();
        this.f18921e = progressHandler;
    }

    public void addPart(String key, String value, String contentType) {
        try {
            this.out.write(this.boundaryLine);
            this.out.write(createContentDisposition(key));
            this.out.write(m14980b(contentType));
            this.out.write(CR_LF);
            this.out.write(value.getBytes());
            this.out.write(CR_LF);
        } catch (IOException e) {
            AsyncHttpClient.log.mo2626e(f18917a, "addPart ByteArrayOutputStream exception", e);
        }
    }

    public void addPartWithCharset(String key, String value, String charset) {
        if (charset == null) {
            charset = "UTF-8";
        }
        addPart(key, value, "text/plain; charset=" + charset);
    }

    public void addPart(String key, String value) {
        addPartWithCharset(key, value, null);
    }

    public void addPart(String key, File file) {
        addPart(key, file, null);
    }

    public void addPart(String key, File file, String type) {
        this.f18920d.add(new FilePart(this, key, file, m14973a(type)));
    }

    public void addPart(String key, File file, String type, String customFileName) {
        this.f18920d.add(new FilePart(this, key, file, m14973a(type), customFileName));
    }

    public void addPart(String key, String streamName, InputStream inputStream, String type) throws IOException {
        this.out.write(this.boundaryLine);
        this.out.write(m14979a(key, streamName));
        this.out.write(m14980b(type));
        this.out.write(f18918b);
        this.out.write(CR_LF);
        byte[] tmp = new byte[4096];
        while (true) {
            int l = inputStream.read(tmp);
            if (l != -1) {
                this.out.write(tmp, 0, l);
            } else {
                this.out.write(CR_LF);
                this.out.flush();
                return;
            }
        }
    }

    /* renamed from: a */
    private String m14973a(String type) {
        return type == null ? "application/octet-stream" : type;
    }

    /* renamed from: b */
    private byte[] m14980b(String type) {
        return ("Content-Type: " + m14973a(type) + STR_CR_LF).getBytes();
    }

    protected byte[] createContentDisposition(String key) {
        return ("Content-Disposition: form-data; name=\"" + key + "\"" + STR_CR_LF).getBytes();
    }

    /* renamed from: a */
    private byte[] m14979a(String key, String fileName) {
        return ("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"" + fileName + "\"" + STR_CR_LF).getBytes();
    }

    /* renamed from: a */
    private void m14974a(long count) {
        this.f18923g += count;
        this.f18921e.sendProgressMessage(this.f18923g, this.f18924h);
    }

    public long getContentLength() {
        long contentLen = (long) this.out.size();
        for (FilePart filePart : this.f18920d) {
            long len = filePart.getTotalLength();
            if (len < 0) {
                return -1;
            }
            contentLen += len;
        }
        return contentLen + ((long) this.boundaryEnd.length);
    }

    public Header getContentType() {
        return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.boundary);
    }

    public boolean isChunked() {
        return false;
    }

    public void setIsRepeatable(boolean isRepeatable) {
        this.f18922f = isRepeatable;
    }

    public boolean isRepeatable() {
        return this.f18922f;
    }

    public boolean isStreaming() {
        return false;
    }

    public void writeTo(OutputStream outstream) throws IOException {
        this.f18923g = 0;
        this.f18924h = (long) ((int) getContentLength());
        this.out.writeTo(outstream);
        m14974a((long) this.out.size());
        for (FilePart filePart : this.f18920d) {
            filePart.writeTo(outstream);
        }
        outstream.write(this.boundaryEnd);
        m14974a((long) this.boundaryEnd.length);
    }

    public Header getContentEncoding() {
        return null;
    }

    public void consumeContent() throws IOException, UnsupportedOperationException {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public InputStream getContent() throws IOException, UnsupportedOperationException {
        throw new UnsupportedOperationException("getContent() is not supported. Use writeTo() instead.");
    }
}
