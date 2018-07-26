package com.indooratlas.android.sdk._internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.mobstat.Config;
import com.facebook.common.p262l.C5361b;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Array;
import java.net.IDN;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class gy {
    /* renamed from: a */
    public static final byte[] f24040a = new byte[0];
    /* renamed from: b */
    public static final String[] f24041b = new String[0];
    /* renamed from: c */
    public static final Charset f24042c = Charset.forName("UTF-8");
    /* renamed from: d */
    public static final TimeZone f24043d = TimeZone.getTimeZone("GMT");
    /* renamed from: e */
    private static final Pattern f24044e = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    /* renamed from: a */
    public static void m20789a(long j, long j2) {
        if ((0 | j2) < 0 || 0 > j || j - 0 < j2) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* renamed from: a */
    public static boolean m20796a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static void m20790a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: a */
    public static void m20792a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!m20795a(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
            }
        }
    }

    /* renamed from: a */
    public static void m20791a(Closeable closeable, Closeable closeable2) throws IOException {
        Object obj = null;
        try {
            closeable.close();
        } catch (Throwable th) {
            obj = th;
        }
        try {
            closeable2.close();
        } catch (Throwable th2) {
            if (obj == null) {
                Throwable th3 = th2;
            }
        }
        if (obj != null) {
            if (obj instanceof IOException) {
                throw ((IOException) obj);
            } else if (obj instanceof RuntimeException) {
                throw ((RuntimeException) obj);
            } else if (obj instanceof Error) {
                throw ((Error) obj);
            } else {
                throw new AssertionError(obj);
            }
        }
    }

    /* renamed from: a */
    public static boolean m20794a(jd jdVar, TimeUnit timeUnit) {
        try {
            return m20793a(jdVar, 100, timeUnit);
        } catch (IOException e) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m20793a(jd jdVar, int i, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long c = jdVar.a().d_() ? jdVar.a().c() - nanoTime : C5361b.f21945a;
        jdVar.a().a(Math.min(c, timeUnit.toNanos((long) i)) + nanoTime);
        try {
            in inVar = new in();
            while (jdVar.a(inVar, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) != -1) {
                inVar.o();
            }
            if (c == C5361b.f21945a) {
                jdVar.a().e_();
            } else {
                jdVar.a().a(c + nanoTime);
            }
            return true;
        } catch (InterruptedIOException e) {
            if (c == C5361b.f21945a) {
                jdVar.a().e_();
            } else {
                jdVar.a().a(c + nanoTime);
            }
            return false;
        } catch (Throwable th) {
            if (c == C5361b.f21945a) {
                jdVar.a().e_();
            } else {
                jdVar.a().a(c + nanoTime);
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static iq m20782a(iq iqVar) {
        try {
            return iq.a(MessageDigest.getInstance("SHA-1").digest(iqVar.d()));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public static <T> List<T> m20785a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    /* renamed from: a */
    public static <T> List<T> m20786a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    /* renamed from: a */
    public static <K, V> Map<K, V> m20787a(Map<K, V> map) {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    /* renamed from: a */
    public static ThreadFactory m20788a(final String str, final boolean z) {
        return new ThreadFactory() {
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    /* renamed from: a */
    public static boolean m20795a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    /* renamed from: a */
    public static boolean m20797a(String[] strArr, String str) {
        return Arrays.asList(strArr).contains(str);
    }

    /* renamed from: b */
    public static String[] m20801b(String[] strArr, String str) {
        Object obj = new String[(strArr.length + 1)];
        System.arraycopy(strArr, 0, obj, 0, strArr.length);
        obj[obj.length - 1] = str;
        return obj;
    }

    /* renamed from: a */
    public static int m20779a(String str, int i, int i2) {
        int i3 = i;
        while (i3 < i2) {
            switch (str.charAt(i3)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    i3++;
                default:
                    return i3;
            }
        }
        return i2;
    }

    /* renamed from: b */
    public static int m20799b(String str, int i, int i2) {
        int i3 = i2 - 1;
        while (i3 >= i) {
            switch (str.charAt(i3)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    i3--;
                default:
                    return i3 + 1;
            }
        }
        return i;
    }

    /* renamed from: c */
    public static String m20802c(String str, int i, int i2) {
        int a = m20779a(str, i, i2);
        return str.substring(a, m20799b(str, a, i2));
    }

    /* renamed from: a */
    public static int m20781a(String str, int i, int i2, String str2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str2.indexOf(str.charAt(i3)) != -1) {
                return i3;
            }
        }
        return i2;
    }

    /* renamed from: a */
    public static int m20780a(String str, int i, int i2, char c) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str.charAt(i3) == c) {
                return i3;
            }
        }
        return i2;
    }

    /* renamed from: a */
    public static String m20784a(String str) {
        Object obj = 1;
        try {
            String toLowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (toLowerCase.isEmpty()) {
                return null;
            }
            for (int i = 0; i < toLowerCase.length(); i++) {
                char charAt = toLowerCase.charAt(i);
                if (charAt <= '\u001f' || charAt >= '' || " #%/:?@[\\]".indexOf(charAt) != -1) {
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                return toLowerCase;
            }
            return null;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m20800b(String str) {
        return f24044e.matcher(str).matches();
    }

    /* renamed from: a */
    public static <T> T[] m20798a(Class<T> cls, T[] tArr, T[] tArr2) {
        List arrayList = new ArrayList();
        for (Object obj : tArr) {
            for (Object obj2 : tArr2) {
                if (obj.equals(obj2)) {
                    arrayList.add(obj2);
                    break;
                }
            }
        }
        return arrayList.toArray((Object[]) Array.newInstance(cls, arrayList.size()));
    }

    /* renamed from: a */
    public static String m20783a(ge geVar) {
        if (geVar.f23863c != ge.m20631a(geVar.f23861a)) {
            return geVar.f23862b + Config.TRACE_TODAY_VISIT_SPLIT + geVar.f23863c;
        }
        return geVar.f23862b;
    }
}
