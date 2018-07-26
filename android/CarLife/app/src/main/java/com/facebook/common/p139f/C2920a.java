package com.facebook.common.p139f;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.C5346g;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: MediaUtils */
/* renamed from: com.facebook.common.f.a */
public class C2920a {
    /* renamed from: a */
    public static final Map<String, String> f12879a = C5346g.a("mkv", "video/x-matroska");

    /* renamed from: a */
    public static boolean m11248a(@Nullable String mimeType) {
        return mimeType != null && mimeType.startsWith("image/");
    }

    /* renamed from: b */
    public static boolean m11249b(@Nullable String mimeType) {
        return mimeType != null && mimeType.startsWith("video/");
    }

    @Nullable
    /* renamed from: c */
    public static String m11250c(String path) {
        String extension = C2920a.m11252e(path);
        if (extension == null) {
            return null;
        }
        extension = extension.toLowerCase(Locale.US);
        String mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
        if (mimeType == null) {
            return (String) f12879a.get(extension);
        }
        return mimeType;
    }

    @Nullable
    /* renamed from: e */
    private static String m11252e(String path) {
        int pos = path.lastIndexOf(46);
        if (pos < 0 || pos == path.length() - 1) {
            return null;
        }
        return path.substring(pos + 1);
    }

    /* renamed from: d */
    public static boolean m11251d(String mimeType) {
        return f12879a.containsValue(mimeType);
    }
}
