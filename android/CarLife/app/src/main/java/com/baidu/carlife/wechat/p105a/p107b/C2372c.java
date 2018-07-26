package com.baidu.carlife.wechat.p105a.p107b;

import android.text.TextUtils;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* compiled from: Log */
/* renamed from: com.baidu.carlife.wechat.a.b.c */
public final class C2372c {
    /* renamed from: a */
    private static final String f7845a = "wechat";
    /* renamed from: b */
    private static final boolean f7846b = true;
    /* renamed from: c */
    private static final int f7847c = 6;

    private C2372c() {
    }

    /* renamed from: a */
    public static int m9022a(String msg) {
        return C2372c.m9020a(2, "", msg, 2);
    }

    /* renamed from: a */
    public static int m9023a(String tag, String msg) {
        return C2372c.m9020a(2, tag, msg, 2);
    }

    /* renamed from: a */
    public static int m9024a(String tag, String msg, Throwable tr) {
        return C2372c.m9021a(2, tag, msg, tr);
    }

    /* renamed from: b */
    public static int m9026b(String msg) {
        return C2372c.m9020a(3, "", msg, 2);
    }

    /* renamed from: b */
    public static int m9027b(String tag, String msg) {
        return C2372c.m9020a(3, tag, msg, 2);
    }

    /* renamed from: b */
    public static int m9028b(String tag, String msg, Throwable tr) {
        return C2372c.m9021a(3, tag, msg, tr);
    }

    /* renamed from: c */
    public static int m9030c(String msg) {
        return C2372c.m9020a(4, "", msg, 2);
    }

    /* renamed from: c */
    public static int m9031c(String tag, String msg) {
        return C2372c.m9020a(4, tag, msg, 2);
    }

    /* renamed from: c */
    public static int m9032c(String tag, String msg, Throwable tr) {
        return C2372c.m9021a(4, tag, msg, tr);
    }

    /* renamed from: d */
    public static int m9033d(String msg) {
        return C2372c.m9020a(5, "", msg, 2);
    }

    /* renamed from: d */
    public static int m9034d(String tag, String msg) {
        return C2372c.m9020a(5, tag, msg, 2);
    }

    /* renamed from: d */
    public static int m9035d(String tag, String msg, Throwable tr) {
        return C2372c.m9021a(5, tag, msg, tr);
    }

    /* renamed from: e */
    public static int m9036e(String msg) {
        return C2372c.m9020a(6, "", msg, 2);
    }

    /* renamed from: e */
    public static int m9037e(String tag, String msg) {
        return C2372c.m9020a(6, tag, msg, 2);
    }

    /* renamed from: e */
    public static int m9038e(String tag, String msg, Throwable tr) {
        return C2372c.m9021a(6, tag, msg, tr);
    }

    /* renamed from: a */
    public static int m9025a(Throwable tr) {
        return C2372c.m9020a(6, "", C2372c.m9029b(tr), 2);
    }

    /* renamed from: a */
    private static int m9021a(int priority, String tag, String msg, Throwable tr) {
        return C2372c.m9020a(priority, tag, msg + '\n' + C2372c.m9029b(tr), 3);
    }

    /* renamed from: a */
    private static int m9020a(int priority, String tag, String msg, int stackLevel) {
        if (priority < 6) {
            return -1;
        }
        tag = TextUtils.isEmpty(tag) ? "wechat" : "wechat_" + tag;
        StackTraceElement stackTrace = new Throwable().getStackTrace()[stackLevel];
        String fileName = stackTrace.getFileName();
        String methodName = stackTrace.getMethodName();
        int lineNumber = stackTrace.getLineNumber();
        if (fileName != null && fileName.contains(".java")) {
            fileName = fileName.replace(".java", "");
        }
        return Log.println(priority, tag, String.format("[%s.%s(): %d] %s", new Object[]{fileName, methodName, Integer.valueOf(lineNumber), msg}));
    }

    /* renamed from: b */
    public static String m9029b(Throwable tr) {
        if (tr == null) {
            return "";
        }
        for (Throwable t = tr; t != null; t = t.getCause()) {
            if (t instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        tr.printStackTrace(pw);
        pw.flush();
        return sw.toString();
    }
}
