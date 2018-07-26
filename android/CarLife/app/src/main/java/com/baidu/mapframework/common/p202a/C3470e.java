package com.baidu.mapframework.common.p202a;

import com.baidu.mapframework.common.p202a.C3465a.C3464a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileLock;
import java.util.Date;
import java.util.Locale;

/* compiled from: FileAppender */
/* renamed from: com.baidu.mapframework.common.a.e */
class C3470e implements C3465a {
    /* renamed from: a */
    private final File f18746a;
    /* renamed from: b */
    private boolean f18747b;
    /* renamed from: c */
    private FileOutputStream f18748c;

    C3470e(File logPath) {
        if (logPath == null) {
            throw new IllegalArgumentException("The file appender root path is null!");
        }
        if (!(logPath.exists() || logPath.mkdirs())) {
            this.f18747b = false;
        }
        if (logPath.isDirectory()) {
            this.f18746a = new File(logPath, "ui_" + System.currentTimeMillis() + C3473h.f18755a);
            try {
                this.f18747b = this.f18746a.exists();
                if (!this.f18747b) {
                    this.f18747b = this.f18746a.createNewFile();
                    if (this.f18747b) {
                        this.f18748c = new FileOutputStream(this.f18746a, true);
                        return;
                    }
                    return;
                }
                return;
            } catch (IOException e) {
                this.f18747b = false;
                return;
            }
        }
        throw new IllegalArgumentException("The file appender root path is not a directory!");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void mo2545a() {
        /*
        r2 = this;
        r1 = 0;
        r0 = r2.f18748c;	 Catch:{ IOException -> 0x000d, all -> 0x0011 }
        if (r0 == 0) goto L_0x000a;
    L_0x0005:
        r0 = r2.f18748c;	 Catch:{ IOException -> 0x000d, all -> 0x0011 }
        r0.close();	 Catch:{ IOException -> 0x000d, all -> 0x0011 }
    L_0x000a:
        r2.f18747b = r1;
    L_0x000c:
        return;
    L_0x000d:
        r0 = move-exception;
        r2.f18747b = r1;
        goto L_0x000c;
    L_0x0011:
        r0 = move-exception;
        r2.f18747b = r1;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapframework.common.a.e.a():void");
    }

    /* renamed from: b */
    public C3464a mo2547b() {
        return C3464a.FILE;
    }

    /* renamed from: a */
    public void mo2546a(C3474i event) {
        if (this.f18747b) {
            try {
                if (this.f18748c == null) {
                    this.f18748c = new FileOutputStream(this.f18746a, true);
                }
                FileLock lock = this.f18748c.getChannel().lock();
                this.f18748c.write(m14907b(event));
                this.f18748c.flush();
                lock.release();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: b */
    private byte[] m14907b(C3474i event) throws UnsupportedEncodingException {
        return String.format(Locale.getDefault(), "[%d] [%s] [%s] [%s] [%s] [%s]\n", new Object[]{Long.valueOf(event.f18761d), event.f18758a.format(new Date(event.f18761d)), event.f18760c, event.f18759b, event.f18763f, event.f18762e}).getBytes("UTF-8");
    }
}
