package com.baidu.mapframework.commonlib.asynchttp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;

public class SpecialMutipartEntity extends SimpleMultipartEntity {
    public /* bridge */ /* synthetic */ void addPartWithCharset(String str, String str2, String str3) {
        super.addPartWithCharset(str, str2, str3);
    }

    public /* bridge */ /* synthetic */ void consumeContent() throws IOException, UnsupportedOperationException {
        super.consumeContent();
    }

    public /* bridge */ /* synthetic */ InputStream getContent() throws IOException, UnsupportedOperationException {
        return super.getContent();
    }

    public /* bridge */ /* synthetic */ Header getContentEncoding() {
        return super.getContentEncoding();
    }

    public /* bridge */ /* synthetic */ long getContentLength() {
        return super.getContentLength();
    }

    public /* bridge */ /* synthetic */ Header getContentType() {
        return super.getContentType();
    }

    public /* bridge */ /* synthetic */ boolean isChunked() {
        return super.isChunked();
    }

    public /* bridge */ /* synthetic */ boolean isRepeatable() {
        return super.isRepeatable();
    }

    public /* bridge */ /* synthetic */ boolean isStreaming() {
        return super.isStreaming();
    }

    public /* bridge */ /* synthetic */ void setIsRepeatable(boolean z) {
        super.setIsRepeatable(z);
    }

    public /* bridge */ /* synthetic */ void writeTo(OutputStream outputStream) throws IOException {
        super.writeTo(outputStream);
    }

    public SpecialMutipartEntity(ResponseHandlerInterface progressHandler) {
        super(progressHandler);
    }

    public void addSpecialPart(String key, InputStream inputStream) throws IOException {
        this.out.write(this.boundaryLine);
        this.out.write(createContentDisposition(key));
        this.out.write(CR_LF);
        byte[] tmp = new byte[4096];
        while (true) {
            int l = inputStream.read(tmp);
            if (l != -1) {
                this.out.write(tmp, 0, l);
            } else {
                this.out.write(CR_LF);
                this.out.flush();
                AsyncHttpClient.silentCloseOutputStream(this.out);
                return;
            }
        }
    }
}
