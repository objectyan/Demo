package com.baidu.tts.loopj;

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
    private static final byte[] CR_LF = STR_CR_LF.getBytes();
    private static final String LOG_TAG = "SimpleMultipartEntity";
    private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final String STR_CR_LF = "\r\n";
    private static final byte[] TRANSFER_ENCODING_BINARY = "Content-Transfer-Encoding: binary\r\n".getBytes();
    private final String boundary;
    private final byte[] boundaryEnd;
    private final byte[] boundaryLine;
    private long bytesWritten;
    private final List<FilePart> fileParts = new ArrayList();
    private boolean isRepeatable;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ResponseHandlerInterface progressHandler;
    private long totalSize;

    private class FilePart {
        public File file;
        public byte[] header;

        public FilePart(String key, File file, String type, String customFileName) {
            if (TextUtils.isEmpty(customFileName)) {
                customFileName = file.getName();
            }
            this.header = createHeader(key, customFileName, type);
            this.file = file;
        }

        public FilePart(String key, File file, String type) {
            this.header = createHeader(key, file.getName(), type);
            this.file = file;
        }

        private byte[] createHeader(String key, String filename, String type) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(SimpleMultipartEntity.this.boundaryLine);
                byteArrayOutputStream.write(SimpleMultipartEntity.this.createContentDisposition(key, filename));
                byteArrayOutputStream.write(SimpleMultipartEntity.this.createContentType(type));
                byteArrayOutputStream.write(SimpleMultipartEntity.TRANSFER_ENCODING_BINARY);
                byteArrayOutputStream.write(SimpleMultipartEntity.CR_LF);
            } catch (Throwable e) {
                AsyncHttpClient.log.mo3897e(SimpleMultipartEntity.LOG_TAG, "createHeader ByteArrayOutputStream exception", e);
            }
            return byteArrayOutputStream.toByteArray();
        }

        public long getTotalLength() {
            return (this.file.length() + ((long) SimpleMultipartEntity.CR_LF.length)) + ((long) this.header.length);
        }

        public void writeTo(OutputStream out) throws IOException {
            out.write(this.header);
            SimpleMultipartEntity.this.updateProgress((long) this.header.length);
            InputStream fileInputStream = new FileInputStream(this.file);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    out.write(bArr, 0, read);
                    SimpleMultipartEntity.this.updateProgress((long) read);
                } else {
                    out.write(SimpleMultipartEntity.CR_LF);
                    SimpleMultipartEntity.this.updateProgress((long) SimpleMultipartEntity.CR_LF.length);
                    out.flush();
                    AsyncHttpClient.silentCloseInputStream(fileInputStream);
                    return;
                }
            }
        }
    }

    public SimpleMultipartEntity(ResponseHandlerInterface progressHandler) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            stringBuilder.append(MULTIPART_CHARS[random.nextInt(MULTIPART_CHARS.length)]);
        }
        this.boundary = stringBuilder.toString();
        this.boundaryLine = ("--" + this.boundary + STR_CR_LF).getBytes();
        this.boundaryEnd = ("--" + this.boundary + "--" + STR_CR_LF).getBytes();
        this.progressHandler = progressHandler;
    }

    public void addPart(String key, String value, String contentType) {
        try {
            this.out.write(this.boundaryLine);
            this.out.write(createContentDisposition(key));
            this.out.write(createContentType(contentType));
            this.out.write(CR_LF);
            this.out.write(value.getBytes());
            this.out.write(CR_LF);
        } catch (Throwable e) {
            AsyncHttpClient.log.mo3897e(LOG_TAG, "addPart ByteArrayOutputStream exception", e);
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
        this.fileParts.add(new FilePart(key, file, normalizeContentType(type)));
    }

    public void addPart(String key, File file, String type, String customFileName) {
        this.fileParts.add(new FilePart(key, file, normalizeContentType(type), customFileName));
    }

    public void addPart(String key, String streamName, InputStream inputStream, String type) throws IOException {
        this.out.write(this.boundaryLine);
        this.out.write(createContentDisposition(key, streamName));
        this.out.write(createContentType(type));
        this.out.write(TRANSFER_ENCODING_BINARY);
        this.out.write(CR_LF);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                this.out.write(bArr, 0, read);
            } else {
                this.out.write(CR_LF);
                this.out.flush();
                return;
            }
        }
    }

    private String normalizeContentType(String type) {
        return type == null ? "application/octet-stream" : type;
    }

    private byte[] createContentType(String type) {
        return ("Content-Type: " + normalizeContentType(type) + STR_CR_LF).getBytes();
    }

    private byte[] createContentDisposition(String key) {
        return ("Content-Disposition: form-data; name=\"" + key + "\"" + STR_CR_LF).getBytes();
    }

    private byte[] createContentDisposition(String key, String fileName) {
        return ("Content-Disposition: form-data; name=\"" + key + "\"" + "; filename=\"" + fileName + "\"" + STR_CR_LF).getBytes();
    }

    private void updateProgress(long count) {
        this.bytesWritten += count;
        this.progressHandler.sendProgressMessage(this.bytesWritten, this.totalSize);
    }

    public long getContentLength() {
        long size = (long) this.out.size();
        long j = size;
        for (FilePart totalLength : this.fileParts) {
            size = totalLength.getTotalLength();
            if (size < 0) {
                return -1;
            }
            j = size + j;
        }
        return ((long) this.boundaryEnd.length) + j;
    }

    public Header getContentType() {
        return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.boundary);
    }

    public boolean isChunked() {
        return false;
    }

    public void setIsRepeatable(boolean isRepeatable) {
        this.isRepeatable = isRepeatable;
    }

    public boolean isRepeatable() {
        return this.isRepeatable;
    }

    public boolean isStreaming() {
        return false;
    }

    public void writeTo(OutputStream outstream) throws IOException {
        this.bytesWritten = 0;
        this.totalSize = (long) ((int) getContentLength());
        this.out.writeTo(outstream);
        updateProgress((long) this.out.size());
        for (FilePart writeTo : this.fileParts) {
            writeTo.writeTo(outstream);
        }
        outstream.write(this.boundaryEnd);
        updateProgress((long) this.boundaryEnd.length);
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
