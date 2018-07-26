package com.facebook.p135b.p137b;

import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.facebook.common.internal.C5343d;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p253d.C5257b;
import com.facebook.common.p253d.C5314a;
import com.facebook.common.p253d.C5319c;
import com.facebook.common.p253d.C5319c.C5315a;
import com.facebook.common.p253d.C5319c.C5317c;
import com.facebook.common.p253d.C5319c.C5318d;
import com.facebook.common.p262l.C5361b;
import com.facebook.common.p262l.C5364f;
import com.facebook.p135b.p136a.C5244a;
import com.facebook.p135b.p136a.C5244a.C5243a;
import com.facebook.p135b.p136a.C5252j;
import com.facebook.p135b.p137b.C5266d.C5259c;
import com.facebook.p135b.p137b.C5266d.C5263d;
import com.facebook.p135b.p137b.C5266d.C5275a;
import com.facebook.p135b.p137b.C5266d.C5276b;
import com.facebook.p252a.C5240a;
import com.facebook.p252a.C5242c;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: DefaultDiskStorage */
/* renamed from: com.facebook.b.b.a */
public class C5267a implements C5266d {
    /* renamed from: a */
    static final long f21784a = TimeUnit.MINUTES.toMillis(30);
    /* renamed from: b */
    private static final Class<?> f21785b = C5267a.class;
    /* renamed from: c */
    private static final String f21786c = ".cnt";
    /* renamed from: d */
    private static final String f21787d = ".tmp";
    /* renamed from: e */
    private static final String f21788e = "v2";
    /* renamed from: f */
    private static final int f21789f = 100;
    /* renamed from: g */
    private final File f21790g;
    /* renamed from: h */
    private final File f21791h;
    /* renamed from: i */
    private final C5244a f21792i;
    /* renamed from: j */
    private final C5361b f21793j = C5364f.m18362b();

    /* compiled from: DefaultDiskStorage */
    /* renamed from: com.facebook.b.b.a$a */
    private class C5258a implements C5257b {
        /* renamed from: a */
        final /* synthetic */ C5267a f21767a;
        /* renamed from: b */
        private final List<C5259c> f21768b;

        private C5258a(C5267a c5267a) {
            this.f21767a = c5267a;
            this.f21768b = new ArrayList();
        }

        /* renamed from: a */
        public void mo3946a(File directory) {
        }

        /* renamed from: b */
        public void mo3947b(File file) {
            a$c info = this.f21767a.m17904b(file);
            if (info != null && info.f12844a == C5261d.CONTENT) {
                this.f21768b.add(new C5260b(info.f12845b, file));
            }
        }

        /* renamed from: c */
        public void mo3948c(File directory) {
        }

        /* renamed from: a */
        public List<C5259c> m17860a() {
            return Collections.unmodifiableList(this.f21768b);
        }
    }

    @VisibleForTesting
    /* compiled from: DefaultDiskStorage */
    /* renamed from: com.facebook.b.b.a$b */
    static class C5260b implements C5259c {
        /* renamed from: a */
        private final String f21769a;
        /* renamed from: b */
        private final C5242c f21770b;
        /* renamed from: c */
        private long f21771c;
        /* renamed from: d */
        private long f21772d;

        /* renamed from: e */
        public /* synthetic */ C5240a mo3952e() {
            return m17870c();
        }

        private C5260b(String id, File cachedFile) {
            C5350k.m18310a((Object) cachedFile);
            this.f21769a = (String) C5350k.m18310a((Object) id);
            this.f21770b = C5242c.m17825a(cachedFile);
            this.f21771c = -1;
            this.f21772d = -1;
        }

        /* renamed from: a */
        public String mo3949a() {
            return this.f21769a;
        }

        /* renamed from: b */
        public long mo3950b() {
            if (this.f21772d < 0) {
                this.f21772d = this.f21770b.m17829d().lastModified();
            }
            return this.f21772d;
        }

        /* renamed from: c */
        public C5242c m17870c() {
            return this.f21770b;
        }

        /* renamed from: d */
        public long mo3951d() {
            if (this.f21771c < 0) {
                this.f21771c = this.f21770b.mo3932c();
            }
            return this.f21771c;
        }
    }

    /* compiled from: DefaultDiskStorage */
    /* renamed from: com.facebook.b.b.a$d */
    private enum C5261d {
        CONTENT(C5267a.f21786c),
        TEMP(C5267a.f21787d);
        
        /* renamed from: c */
        public final String f21776c;

        private C5261d(String extension) {
            this.f21776c = extension;
        }

        /* renamed from: a */
        public static C5261d m17873a(String extension) {
            if (C5267a.f21786c.equals(extension)) {
                return CONTENT;
            }
            if (C5267a.f21787d.equals(extension)) {
                return TEMP;
            }
            return null;
        }
    }

    /* compiled from: DefaultDiskStorage */
    /* renamed from: com.facebook.b.b.a$e */
    private static class C5262e extends IOException {
        /* renamed from: a */
        public final long f21777a;
        /* renamed from: b */
        public final long f21778b;

        public C5262e(long expected, long actual) {
            super("File was not written completely. Expected: " + expected + ", found: " + actual);
            this.f21777a = expected;
            this.f21778b = actual;
        }
    }

    @VisibleForTesting
    /* compiled from: DefaultDiskStorage */
    /* renamed from: com.facebook.b.b.a$f */
    class C5264f implements C5263d {
        @VisibleForTesting
        /* renamed from: a */
        final File f21779a;
        /* renamed from: b */
        final /* synthetic */ C5267a f21780b;
        /* renamed from: c */
        private final String f21781c;

        public C5264f(C5267a this$0, String resourceId, File temporaryFile) {
            this.f21780b = this$0;
            this.f21781c = resourceId;
            this.f21779a = temporaryFile;
        }

        /* renamed from: a */
        public void mo3954a(C5252j callback, Object debugInfo) throws IOException {
            try {
                FileOutputStream fileStream = new FileOutputStream(this.f21779a);
                try {
                    C5343d countingStream = new C5343d(fileStream);
                    callback.mo3945a(countingStream);
                    countingStream.flush();
                    long length = countingStream.m18276a();
                    if (this.f21779a.length() != length) {
                        throw new C5262e(length, this.f21779a.length());
                    }
                } finally {
                    fileStream.close();
                }
            } catch (FileNotFoundException fne) {
                this.f21780b.f21792i.mo3937a(C5243a.WRITE_UPDATE_FILE_NOT_FOUND, C5267a.f21785b, "updateResource", fne);
                throw fne;
            }
        }

        /* renamed from: a */
        public C5240a mo3953a(Object debugInfo) throws IOException {
            File targetFile = this.f21780b.m17916a(this.f21781c);
            try {
                C5319c.m18117a(this.f21779a, targetFile);
                if (targetFile.exists()) {
                    targetFile.setLastModified(this.f21780b.f21793j.mo4020a());
                }
                return C5242c.m17825a(targetFile);
            } catch (C5318d re) {
                C5243a category;
                Throwable cause = re.getCause();
                if (cause == null) {
                    category = C5243a.WRITE_RENAME_FILE_OTHER;
                } else if (cause instanceof C5317c) {
                    category = C5243a.WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
                } else if (cause instanceof FileNotFoundException) {
                    category = C5243a.WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
                } else {
                    category = C5243a.WRITE_RENAME_FILE_OTHER;
                }
                this.f21780b.f21792i.mo3937a(category, C5267a.f21785b, "commit", re);
                throw re;
            }
        }

        /* renamed from: a */
        public boolean mo3955a() {
            return !this.f21779a.exists() || this.f21779a.delete();
        }
    }

    /* compiled from: DefaultDiskStorage */
    /* renamed from: com.facebook.b.b.a$g */
    private class C5265g implements C5257b {
        /* renamed from: a */
        final /* synthetic */ C5267a f21782a;
        /* renamed from: b */
        private boolean f21783b;

        private C5265g(C5267a c5267a) {
            this.f21782a = c5267a;
        }

        /* renamed from: a */
        public void mo3946a(File directory) {
            if (!this.f21783b && directory.equals(this.f21782a.f21791h)) {
                this.f21783b = true;
            }
        }

        /* renamed from: b */
        public void mo3947b(File file) {
            if (!this.f21783b || !m17880d(file)) {
                file.delete();
            }
        }

        /* renamed from: c */
        public void mo3948c(File directory) {
            if (!(this.f21782a.f21790g.equals(directory) || this.f21783b)) {
                directory.delete();
            }
            if (this.f21783b && directory.equals(this.f21782a.f21791h)) {
                this.f21783b = false;
            }
        }

        /* renamed from: d */
        private boolean m17880d(File file) {
            boolean z = false;
            a$c info = this.f21782a.m17904b(file);
            if (info == null) {
                return false;
            }
            if (info.f12844a == C5261d.TEMP) {
                return m17881e(file);
            }
            if (info.f12844a == C5261d.CONTENT) {
                z = true;
            }
            C5350k.m18321b(z);
            return true;
        }

        /* renamed from: e */
        private boolean m17881e(File file) {
            return file.lastModified() > this.f21782a.f21793j.mo4020a() - C5267a.f21784a;
        }
    }

    /* renamed from: g */
    public /* synthetic */ Collection mo3967g() throws IOException {
        return m17926f();
    }

    public C5267a(File rootDirectory, int version, C5244a cacheErrorLogger) {
        C5350k.m18310a((Object) rootDirectory);
        this.f21790g = rootDirectory;
        this.f21791h = new File(this.f21790g, C5267a.m17900a(version));
        this.f21792i = cacheErrorLogger;
        m17913i();
    }

    @VisibleForTesting
    /* renamed from: a */
    static String m17900a(int version) {
        return String.format((Locale) null, "%s.ols%d.%d", new Object[]{f21788e, Integer.valueOf(100), Integer.valueOf(version)});
    }

    /* renamed from: a */
    public boolean mo3958a() {
        return true;
    }

    /* renamed from: b */
    public String mo3961b() {
        String directoryName = this.f21790g.getAbsolutePath();
        return JNISearchConst.LAYER_ID_DIVIDER + directoryName.substring(directoryName.lastIndexOf(47) + 1, directoryName.length()) + JNISearchConst.LAYER_ID_DIVIDER + directoryName.hashCode();
    }

    /* renamed from: i */
    private void m17913i() {
        boolean recreateBase = false;
        if (!this.f21790g.exists()) {
            recreateBase = true;
        } else if (!this.f21791h.exists()) {
            recreateBase = true;
            C5314a.m18115b(this.f21790g);
        }
        if (recreateBase) {
            try {
                C5319c.m18116a(this.f21791h);
            } catch (C5315a e) {
                this.f21792i.mo3937a(C5243a.WRITE_CREATE_DIR, f21785b, "version directory could not be created: " + this.f21791h, null);
            }
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    File m17916a(String resourceId) {
        return new File(m17911e(resourceId));
    }

    /* renamed from: c */
    private String m17908c(String resourceId) {
        return this.f21791h + File.separator + String.valueOf(Math.abs(resourceId.hashCode() % 100));
    }

    /* renamed from: d */
    private File m17910d(String resourceId) {
        return new File(m17908c(resourceId));
    }

    /* renamed from: c */
    public void mo3962c() {
        C5314a.m18113a(this.f21790g, new C5265g());
    }

    /* renamed from: a */
    private void m17902a(File directory, String message) throws IOException {
        try {
            C5319c.m18116a(directory);
        } catch (C5315a cde) {
            this.f21792i.mo3937a(C5243a.WRITE_CREATE_DIR, f21785b, message, cde);
            throw cde;
        }
    }

    /* renamed from: a */
    public C5263d mo3957a(String resourceId, Object debugInfo) throws IOException {
        a$c info = new a$c(C5261d.TEMP, resourceId, null);
        File parent = m17910d(info.f12845b);
        if (!parent.exists()) {
            m17902a(parent, "insert");
        }
        try {
            return new C5264f(this, resourceId, info.a(parent));
        } catch (IOException ioe) {
            this.f21792i.mo3937a(C5243a.WRITE_CREATE_TEMPFILE, f21785b, "insert", ioe);
            throw ioe;
        }
    }

    /* renamed from: b */
    public C5240a mo3960b(String resourceId, Object debugInfo) {
        File file = m17916a(resourceId);
        if (!file.exists()) {
            return null;
        }
        file.setLastModified(this.f21793j.mo4020a());
        return C5242c.m17825a(file);
    }

    /* renamed from: e */
    private String m17911e(String resourceId) {
        a$c fileInfo = new a$c(C5261d.CONTENT, resourceId, null);
        return fileInfo.a(m17908c(fileInfo.f12845b));
    }

    /* renamed from: c */
    public boolean mo3963c(String resourceId, Object debugInfo) {
        return m17903a(resourceId, false);
    }

    /* renamed from: d */
    public boolean mo3965d(String resourceId, Object debugInfo) {
        return m17903a(resourceId, true);
    }

    /* renamed from: a */
    private boolean m17903a(String resourceId, boolean touch) {
        File contentFile = m17916a(resourceId);
        boolean exists = contentFile.exists();
        if (touch && exists) {
            contentFile.setLastModified(this.f21793j.mo4020a());
        }
        return exists;
    }

    /* renamed from: a */
    public long mo3956a(C5259c entry) {
        return m17897a(((C5260b) entry).m17870c().m17829d());
    }

    /* renamed from: b */
    public long mo3959b(String resourceId) {
        return m17897a(m17916a(resourceId));
    }

    /* renamed from: a */
    private long m17897a(File contentFile) {
        if (!contentFile.exists()) {
            return 0;
        }
        return !contentFile.delete() ? -1 : contentFile.length();
    }

    /* renamed from: d */
    public void mo3964d() {
        C5314a.m18114a(this.f21790g);
    }

    /* renamed from: e */
    public C5275a mo3966e() throws IOException {
        List<C5259c> entries = m17926f();
        C5275a dumpInfo = new C5275a();
        for (C5259c entry : entries) {
            C5276b infoEntry = m17905b(entry);
            String type = infoEntry.f21810b;
            if (!dumpInfo.f21808b.containsKey(type)) {
                dumpInfo.f21808b.put(type, Integer.valueOf(0));
            }
            dumpInfo.f21808b.put(type, Integer.valueOf(((Integer) dumpInfo.f21808b.get(type)).intValue() + 1));
            dumpInfo.f21807a.add(infoEntry);
        }
        return dumpInfo;
    }

    /* renamed from: b */
    private C5276b m17905b(C5259c entry) throws IOException {
        C5260b entryImpl = (C5260b) entry;
        String firstBits = "";
        byte[] bytes = entryImpl.m17870c().mo3931b();
        String type = m17901a(bytes);
        if (type.equals("undefined") && bytes.length >= 4) {
            firstBits = String.format((Locale) null, "0x%02X 0x%02X 0x%02X 0x%02X", new Object[]{Byte.valueOf(bytes[0]), Byte.valueOf(bytes[1]), Byte.valueOf(bytes[2]), Byte.valueOf(bytes[3])});
        }
        return new C5276b(entryImpl.m17870c().m17829d().getPath(), type, (float) entryImpl.mo3951d(), firstBits);
    }

    /* renamed from: a */
    private String m17901a(byte[] bytes) {
        if (bytes.length >= 2) {
            if (bytes[0] == (byte) -1 && bytes[1] == (byte) -40) {
                return "jpg";
            }
            if (bytes[0] == (byte) -119 && bytes[1] == (byte) 80) {
                return "png";
            }
            if (bytes[0] == (byte) 82 && bytes[1] == (byte) 73) {
                return "webp";
            }
            if (bytes[0] == (byte) 71 && bytes[1] == (byte) 73) {
                return "gif";
            }
        }
        return "undefined";
    }

    /* renamed from: f */
    public List<C5259c> m17926f() throws IOException {
        C5258a collector = new C5258a();
        C5314a.m18113a(this.f21791h, collector);
        return collector.m17860a();
    }

    /* renamed from: b */
    private a$c m17904b(File file) {
        a$c info = a$c.b(file);
        if (info == null) {
            return null;
        }
        if (!m17910d(info.f12845b).equals(file.getParentFile())) {
            info = null;
        }
        return info;
    }
}
