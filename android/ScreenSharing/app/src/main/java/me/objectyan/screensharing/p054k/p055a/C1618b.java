package com.baidu.carlife.p054k.p055a;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

/* compiled from: MultipartEntity */
/* renamed from: com.baidu.carlife.k.a.b */
public class C1618b implements HttpEntity {
    /* renamed from: d */
    private static final char[] f4948d = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    /* renamed from: a */
    ByteArrayOutputStream f4949a = new ByteArrayOutputStream();
    /* renamed from: b */
    boolean f4950b = false;
    /* renamed from: c */
    boolean f4951c = false;
    /* renamed from: e */
    private String f4952e = null;

    public C1618b() {
        StringBuffer buf = new StringBuffer();
        Random rand = new Random();
        for (int i = 0; i < 30; i++) {
            buf.append(f4948d[rand.nextInt(f4948d.length)]);
        }
        this.f4952e = buf.toString();
    }

    /* renamed from: a */
    public void m5897a() {
        if (!this.f4951c) {
            try {
                this.f4949a.write(("--" + this.f4952e + "\r\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.f4951c = true;
    }

    /* renamed from: b */
    public void m5902b() {
        if (!this.f4950b) {
            try {
                this.f4949a.write(("\r\n--" + this.f4952e + "--\r\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f4950b = true;
        }
    }

    /* renamed from: a */
    public void m5899a(String key, String value) {
        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
            m5897a();
            try {
                this.f4949a.write(("Content-Disposition: form-data; name=\"" + key + "\"\r\n\r\n").getBytes());
                this.f4949a.write(value.getBytes());
                this.f4949a.write(("\r\n--" + this.f4952e + "\r\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void m5901a(String key, String fileName, InputStream fin, boolean isLast) {
        m5900a(key, fileName, fin, "application/octet-stream", isLast);
    }

    /* renamed from: a */
    public void m5900a(String key, String fileName, InputStream fin, String type, boolean isLast) {
        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(fileName) && fin != null) {
            m5897a();
            try {
                type = "Content-Type: " + type + "\r\n";
                this.f4949a.write(("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"" + fileName + "\"\r\n").getBytes());
                this.f4949a.write(type.getBytes());
                this.f4949a.write("Content-Transfer-Encoding: binary\r\n\r\n".getBytes());
                byte[] tmp = new byte[4096];
                while (true) {
                    int l = fin.read(tmp);
                    if (l == -1) {
                        break;
                    }
                    this.f4949a.write(tmp, 0, l);
                }
                if (isLast) {
                    m5902b();
                } else {
                    this.f4949a.write(("\r\n--" + this.f4952e + "\r\n").getBytes());
                }
                this.f4949a.flush();
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                try {
                    fin.close();
                } catch (IOException e22) {
                    e22.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    fin.close();
                } catch (IOException e222) {
                    e222.printStackTrace();
                }
                throw th;
            }
        }
    }

    /* renamed from: a */
    public void m5898a(String key, File value, boolean isLast) {
        if (!TextUtils.isEmpty(key) && value != null) {
            try {
                m5901a(key, value.getName(), new FileInputStream(value), isLast);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public long getContentLength() {
        m5902b();
        return (long) this.f4949a.toByteArray().length;
    }

    public Header getContentType() {
        return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.f4952e);
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

    public void writeTo(OutputStream outstream) throws IOException {
        outstream.write(this.f4949a.toByteArray());
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
        return new ByteArrayInputStream(this.f4949a.toByteArray());
    }
}
