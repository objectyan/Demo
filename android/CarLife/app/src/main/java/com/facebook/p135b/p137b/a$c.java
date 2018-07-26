package com.facebook.p135b.p137b;

import com.facebook.p135b.p137b.C5267a.C5261d;
import java.io.File;
import java.io.IOException;
import javax.annotation.Nullable;

/* compiled from: DefaultDiskStorage */
/* renamed from: com.facebook.b.b.a$c */
class a$c {
    /* renamed from: a */
    public final C5261d f12844a;
    /* renamed from: b */
    public final String f12845b;

    private a$c(C5261d type, String resourceId) {
        this.f12844a = type;
        this.f12845b = resourceId;
    }

    public String toString() {
        return this.f12844a + "(" + this.f12845b + ")";
    }

    /* renamed from: a */
    public String m11154a(String parentPath) {
        return parentPath + File.separator + this.f12845b + this.f12844a.f21776c;
    }

    /* renamed from: a */
    public File m11153a(File parent) throws IOException {
        return File.createTempFile(this.f12845b + ".", ".tmp", parent);
    }

    @Nullable
    /* renamed from: b */
    public static a$c m11152b(File file) {
        String name = file.getName();
        int pos = name.lastIndexOf(46);
        if (pos <= 0) {
            return null;
        }
        C5261d type = C5261d.a(name.substring(pos));
        if (type == null) {
            return null;
        }
        String resourceId = name.substring(0, pos);
        if (type.equals(C5261d.f21774b)) {
            int numPos = resourceId.lastIndexOf(46);
            if (numPos <= 0) {
                return null;
            }
            resourceId = resourceId.substring(0, numPos);
        }
        return new a$c(type, resourceId);
    }
}
