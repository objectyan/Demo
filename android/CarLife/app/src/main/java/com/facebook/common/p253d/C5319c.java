package com.facebook.common.p253d;

import com.facebook.common.internal.C5350k;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: FileUtils */
/* renamed from: com.facebook.common.d.c */
public class C5319c {

    /* compiled from: FileUtils */
    /* renamed from: com.facebook.common.d.c$a */
    public static class C5315a extends IOException {
        public C5315a(String message) {
            super(message);
        }

        public C5315a(String message, Throwable innerException) {
            super(message);
            initCause(innerException);
        }
    }

    /* compiled from: FileUtils */
    /* renamed from: com.facebook.common.d.c$b */
    public static class C5316b extends IOException {
        public C5316b(String message) {
            super(message);
        }
    }

    /* compiled from: FileUtils */
    /* renamed from: com.facebook.common.d.c$c */
    public static class C5317c extends FileNotFoundException {
        public C5317c(String message) {
            super(message);
        }
    }

    /* compiled from: FileUtils */
    /* renamed from: com.facebook.common.d.c$d */
    public static class C5318d extends IOException {
        public C5318d(String message) {
            super(message);
        }

        public C5318d(String message, Throwable innerException) {
            super(message);
            initCause(innerException);
        }
    }

    /* renamed from: a */
    public static void m18116a(File directory) throws C5315a {
        if (directory.exists()) {
            if (!directory.isDirectory()) {
                if (!directory.delete()) {
                    throw new C5315a(directory.getAbsolutePath(), new C5316b(directory.getAbsolutePath()));
                }
            }
            return;
        }
        if (!directory.mkdirs() && !directory.isDirectory()) {
            throw new C5315a(directory.getAbsolutePath());
        }
    }

    /* renamed from: a */
    public static void m18117a(File source, File target) throws C5318d {
        C5350k.m18310a((Object) source);
        C5350k.m18310a((Object) target);
        target.delete();
        if (!source.renameTo(target)) {
            Throwable innerException = null;
            if (target.exists()) {
                innerException = new C5316b(target.getAbsolutePath());
            } else if (!source.getParentFile().exists()) {
                innerException = new C5317c(source.getAbsolutePath());
            } else if (!source.exists()) {
                innerException = new FileNotFoundException(source.getAbsolutePath());
            }
            throw new C5318d("Unknown error renaming " + source.getAbsolutePath() + " to " + target.getAbsolutePath(), innerException);
        }
    }
}
