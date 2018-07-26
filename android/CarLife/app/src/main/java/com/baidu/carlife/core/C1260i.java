package com.baidu.carlife.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: LogUtil */
/* renamed from: com.baidu.carlife.core.i */
public class C1260i implements C0689h {
    /* renamed from: a */
    public static final boolean f3619a = false;
    /* renamed from: b */
    public static final String f3620b = "_Carlife.log";
    /* renamed from: c */
    public static final SimpleDateFormat f3621c = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.getDefault());
    /* renamed from: e */
    private static final String f3622e = "com.baidu.carlife#";
    /* renamed from: f */
    private static Map<String, Long> f3623f = new HashMap();
    /* renamed from: g */
    private static C1260i f3624g;
    /* renamed from: d */
    public C1259a f3625d;

    /* compiled from: LogUtil */
    /* renamed from: com.baidu.carlife.core.i$a */
    private class C1259a extends Thread {
        /* renamed from: a */
        final /* synthetic */ C1260i f3606a;
        /* renamed from: b */
        private final long f3607b;
        /* renamed from: c */
        private final long f3608c;
        /* renamed from: d */
        private final long f3609d;
        /* renamed from: e */
        private final String f3610e;
        /* renamed from: f */
        private final SimpleDateFormat f3611f;
        /* renamed from: g */
        private final SimpleDateFormat f3612g;
        /* renamed from: h */
        private Handler f3613h;
        /* renamed from: i */
        private Looper f3614i;
        /* renamed from: j */
        private File f3615j;
        /* renamed from: k */
        private File f3616k;
        /* renamed from: l */
        private FileWriter f3617l;
        /* renamed from: m */
        private Comparator<File> f3618m;

        /* compiled from: LogUtil */
        /* renamed from: com.baidu.carlife.core.i$a$1 */
        class C12571 implements Comparator<File> {
            /* renamed from: a */
            final /* synthetic */ C1259a f3604a;

            C12571(C1259a this$1) {
                this.f3604a = this$1;
            }

            public /* synthetic */ int compare(Object obj, Object obj2) {
                return m4412a((File) obj, (File) obj2);
            }

            /* renamed from: a */
            public int m4412a(File f1, File f2) {
                return (int) (f2.lastModified() - f1.lastModified());
            }
        }

        private C1259a(C1260i c1260i) {
            this.f3606a = c1260i;
            this.f3607b = 5242880;
            this.f3608c = 86400000;
            this.f3609d = 20;
            this.f3610e = C1253f.jm + File.separator + "debugLog" + File.separator;
            this.f3611f = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
            this.f3612g = new SimpleDateFormat("MM-dd_HH_mm_ss.SS");
            this.f3618m = new C12571(this);
        }

        /* renamed from: a */
        public File m4421a() {
            return this.f3616k;
        }

        public void run() {
            this.f3615j = new File(this.f3610e);
            if (!this.f3615j.exists()) {
                this.f3615j.mkdirs();
            }
            File tempFile = null;
            File[] files = this.f3615j.listFiles();
            Arrays.sort(files, this.f3618m);
            if (files != null && files.length > 0) {
                tempFile = files[0];
            }
            if (tempFile != null) {
                long fileCreateTime = 0;
                try {
                    fileCreateTime = this.f3611f.parse(tempFile.getName().substring(0, tempFile.getName().length() - 4)).getTime();
                } catch (ParseException e) {
                    tempFile.delete();
                }
                if (fileCreateTime > 0 && new Date().getTime() - fileCreateTime < 86400000) {
                    this.f3616k = tempFile;
                    try {
                        this.f3617l = new FileWriter(this.f3616k, true);
                    } catch (IOException e2) {
                    }
                }
            }
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            this.f3614i = Looper.myLooper();
            this.f3613h = new Handler(this, this.f3614i) {
                /* renamed from: a */
                final /* synthetic */ C1259a f3605a;

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void handleMessage(android.os.Message r13) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x00c6 in list [B:21:0x00b3]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
                    /*
                    r12 = this;
                    r10 = 5242880; // 0x500000 float:7.34684E-39 double:2.590327E-317;
                    r8 = 0;
                    r3 = r13.obj;
                    r3 = r3 instanceof java.lang.String;
                    if (r3 == 0) goto L_0x00c6;
                L_0x000a:
                    r3 = r12.f3605a;
                    r3 = r3.f3616k;
                    if (r3 != 0) goto L_0x008d;
                L_0x0012:
                    r3 = r12.f3605a;
                    r3 = r3.f3615j;
                    r1 = r3.listFiles();
                    if (r1 == 0) goto L_0x003c;
                L_0x001e:
                    r3 = r1.length;
                    r4 = (long) r3;
                    r6 = 20;
                    r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
                    if (r3 < 0) goto L_0x003c;
                L_0x0026:
                    r3 = r12.f3605a;
                    r3 = r3.f3618m;
                    java.util.Arrays.sort(r1, r3);
                    r2 = 19;
                L_0x0031:
                    r3 = r1.length;
                    if (r2 >= r3) goto L_0x003c;
                L_0x0034:
                    r3 = r1[r2];
                    r3.delete();
                    r2 = r2 + 1;
                    goto L_0x0031;
                L_0x003c:
                    r3 = r12.f3605a;
                    r4 = new java.io.File;
                    r5 = new java.lang.StringBuilder;
                    r5.<init>();
                    r6 = r12.f3605a;
                    r6 = r6.f3610e;
                    r5 = r5.append(r6);
                    r6 = r12.f3605a;
                    r6 = r6.f3611f;
                    r7 = new java.util.Date;
                    r7.<init>();
                    r6 = r6.format(r7);
                    r5 = r5.append(r6);
                    r6 = ".txt";
                    r5 = r5.append(r6);
                    r5 = r5.toString();
                    r4.<init>(r5);
                    r3.f3616k = r4;
                    r3 = r12.f3605a;	 Catch:{ IOException -> 0x00c7 }
                    r3 = r3.f3616k;	 Catch:{ IOException -> 0x00c7 }
                    r3.createNewFile();	 Catch:{ IOException -> 0x00c7 }
                    r3 = r12.f3605a;	 Catch:{ IOException -> 0x00c7 }
                    r4 = new java.io.FileWriter;	 Catch:{ IOException -> 0x00c7 }
                    r5 = r12.f3605a;	 Catch:{ IOException -> 0x00c7 }
                    r5 = r5.f3616k;	 Catch:{ IOException -> 0x00c7 }
                    r6 = 1;	 Catch:{ IOException -> 0x00c7 }
                    r4.<init>(r5, r6);	 Catch:{ IOException -> 0x00c7 }
                    r3.f3617l = r4;	 Catch:{ IOException -> 0x00c7 }
                L_0x008d:
                    r3 = r12.f3605a;	 Catch:{ IOException -> 0x00cc, all -> 0x00e9 }
                    r3 = r3.f3617l;	 Catch:{ IOException -> 0x00cc, all -> 0x00e9 }
                    if (r3 == 0) goto L_0x00ab;	 Catch:{ IOException -> 0x00cc, all -> 0x00e9 }
                L_0x0095:
                    r3 = r12.f3605a;	 Catch:{ IOException -> 0x00cc, all -> 0x00e9 }
                    r4 = r3.f3617l;	 Catch:{ IOException -> 0x00cc, all -> 0x00e9 }
                    r3 = r13.obj;	 Catch:{ IOException -> 0x00cc, all -> 0x00e9 }
                    r3 = (java.lang.String) r3;	 Catch:{ IOException -> 0x00cc, all -> 0x00e9 }
                    r4.write(r3);	 Catch:{ IOException -> 0x00cc, all -> 0x00e9 }
                    r3 = r12.f3605a;	 Catch:{ IOException -> 0x00cc, all -> 0x00e9 }
                    r3 = r3.f3617l;	 Catch:{ IOException -> 0x00cc, all -> 0x00e9 }
                    r3.flush();	 Catch:{ IOException -> 0x00cc, all -> 0x00e9 }
                L_0x00ab:
                    r3 = r12.f3605a;
                    r3 = r3.f3616k;
                    if (r3 == 0) goto L_0x00c6;
                L_0x00b3:
                    r3 = r12.f3605a;
                    r3 = r3.f3616k;
                    r4 = r3.length();
                    r3 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
                    if (r3 <= 0) goto L_0x00c6;
                L_0x00c1:
                    r3 = r12.f3605a;
                    r3.f3616k = r8;
                L_0x00c6:
                    return;
                L_0x00c7:
                    r0 = move-exception;
                    r0.printStackTrace();
                    goto L_0x008d;
                L_0x00cc:
                    r3 = move-exception;
                    r3 = r12.f3605a;
                    r3 = r3.f3616k;
                    if (r3 == 0) goto L_0x00c6;
                L_0x00d5:
                    r3 = r12.f3605a;
                    r3 = r3.f3616k;
                    r4 = r3.length();
                    r3 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
                    if (r3 <= 0) goto L_0x00c6;
                L_0x00e3:
                    r3 = r12.f3605a;
                    r3.f3616k = r8;
                    goto L_0x00c6;
                L_0x00e9:
                    r3 = move-exception;
                    r4 = r12.f3605a;
                    r4 = r4.f3616k;
                    if (r4 == 0) goto L_0x0105;
                L_0x00f2:
                    r4 = r12.f3605a;
                    r4 = r4.f3616k;
                    r4 = r4.length();
                    r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
                    if (r4 <= 0) goto L_0x0105;
                L_0x0100:
                    r4 = r12.f3605a;
                    r4.f3616k = r8;
                L_0x0105:
                    throw r3;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.carlife.core.i.a.2.handleMessage(android.os.Message):void");
                }
            };
            Looper.loop();
        }

        /* renamed from: a */
        public void m4422a(File file) {
            C1260i.m4435b(C1260i.f3622e, "insertDivider not impl.");
        }

        /* renamed from: b */
        public void m4425b() {
            if (this.f3617l != null) {
                try {
                    this.f3617l.close();
                    this.f3617l = null;
                } catch (IOException e) {
                }
            }
            if (this.f3614i != null) {
                this.f3614i.quit();
                this.f3613h = null;
            }
        }

        /* renamed from: a */
        public void m4424a(Throwable throwable) {
            if (this.f3613h != null) {
                String log = this.f3612g.format(new Date()) + "/CarLife Crash!\n";
                Message msg = Message.obtain();
                msg.obj = log + Log.getStackTraceString(throwable);
                this.f3613h.sendMessage(msg);
            }
        }

        /* renamed from: a */
        public void m4423a(String level, String tag, String format) {
            if (this.f3613h != null) {
                String log = this.f3612g.format(new Date()) + " " + level + "/" + tag + Config.TRACE_TODAY_VISIT_SPLIT + format + "\n";
                Message msg = Message.obtain();
                msg.obj = log;
                this.f3613h.sendMessage(msg);
            }
        }
    }

    /* renamed from: a */
    public static C1260i m4426a() {
        if (f3624g == null) {
            f3624g = new C1260i();
        }
        return f3624g;
    }

    /* renamed from: b */
    public void m4448b() {
        if (C1251e.m4382t() && C1253f.ju && this.f3625d == null) {
            this.f3625d = new C1259a();
            this.f3625d.start();
        }
    }

    /* renamed from: c */
    public void m4449c() {
        if (this.f3625d != null) {
            this.f3625d.m4425b();
        }
    }

    /* renamed from: d */
    public void m4450d() {
        if (this.f3625d != null && this.f3625d.m4421a() != null) {
            this.f3625d.m4422a(this.f3625d.m4421a());
        }
    }

    /* renamed from: b */
    private void m4436b(String level, String tag, String format) {
        if (this.f3625d != null && C1251e.m4382t() && C1253f.ju) {
            this.f3625d.m4423a(level, tag, format);
        }
    }

    /* renamed from: c */
    private void m4442c(Throwable throwable) {
        if (this.f3625d != null && C1251e.m4382t() && C1253f.ju) {
            this.f3625d.m4424a(throwable);
        }
    }

    /* renamed from: a */
    public static void m4430a(String level, String tag, String format) {
        if (f3624g != null) {
            f3624g.m4436b(level, tag, format);
        }
    }

    /* renamed from: a */
    public static void m4433a(Throwable t) {
        if (C1253f.jp <= 5) {
            StringBuilder err = new StringBuilder(256);
            err.append("Got exception: ");
            err.append(t.toString());
            err.append("\n");
            System.out.println(err.toString());
            t.printStackTrace(System.out);
        }
    }

    /* renamed from: a */
    public static void m4431a(String tag, String format, Object... args) {
        C1260i.m4427a(2, tag, format, args);
        if (f3624g != null) {
            f3624g.m4436b("V", tag, format);
        }
    }

    /* renamed from: a */
    public static void m4429a(String tag, String format) {
        if (C1253f.jp <= 2) {
            Log.v(f3622e + tag, format);
        }
        if (f3624g != null) {
            f3624g.m4436b("V", tag, format);
        }
    }

    /* renamed from: b */
    public static void m4437b(String tag, String format, Object... args) {
        C1260i.m4427a(3, tag, format, args);
        if (f3624g != null) {
            f3624g.m4436b("D", tag, format);
        }
    }

    /* renamed from: b */
    public static void m4435b(String tag, String format) {
        if (C1253f.jp <= 3) {
            Log.d(f3622e + tag, format);
        }
        if (f3624g != null) {
            f3624g.m4436b("D", tag, format);
        }
    }

    /* renamed from: c */
    public static void m4441c(String tag, String format, Object... args) {
        C1260i.m4427a(4, tag, format, args);
        if (f3624g != null) {
            f3624g.m4436b("I", tag, format);
        }
    }

    /* renamed from: c */
    public static void m4440c(String tag, String format) {
        if (C1253f.jp <= 4) {
            Log.i(f3622e + tag, format);
        }
        if (f3624g != null) {
            f3624g.m4436b("I", tag, format);
        }
    }

    /* renamed from: d */
    public static void m4444d(String tag, String format, Object... args) {
        C1260i.m4427a(5, tag, format, args);
        if (f3624g != null) {
            f3624g.m4436b("W", tag, format);
        }
    }

    /* renamed from: d */
    public static void m4443d(String tag, String format) {
        if (C1253f.jp <= 5) {
            Log.w(f3622e + tag, format);
        }
        if (f3624g != null) {
            f3624g.m4436b("W", tag, format);
        }
    }

    /* renamed from: a */
    public static void m4432a(String tag, Throwable throwable) {
        if (C1253f.jp <= 6) {
            Log.w(f3622e + tag, "CarLife Exception!", throwable);
        }
        if (f3624g != null) {
            f3624g.m4442c(throwable);
        }
    }

    /* renamed from: e */
    public static void m4446e(String tag, String format, Object... args) {
        C1260i.m4427a(6, tag, format, args);
        if (f3624g != null) {
            f3624g.m4436b("E", tag, format);
        }
    }

    /* renamed from: e */
    public static void m4445e(String tag, String format) {
        if (C1253f.jp <= 6) {
            Log.e(f3622e + tag, format);
        }
        if (f3624g != null) {
            f3624g.m4436b("E", tag, format);
        }
    }

    /* renamed from: b */
    public static void m4439b(Throwable throwable) {
        if (C1253f.jp <= 6) {
            Log.e(f3622e, "CarLife Crash!", throwable);
        }
        if (f3624g != null) {
            f3624g.m4442c(throwable);
        }
    }

    /* renamed from: b */
    public static void m4438b(String tag, Throwable throwable) {
        if (C1253f.jp <= 6) {
            Log.e(f3622e + tag, "CarLife Exception!", throwable);
        }
        if (f3624g != null) {
            f3624g.m4442c(throwable);
        }
    }

    /* renamed from: a */
    private static void m4427a(int level, String tag, String format, Object... args) {
        if (C1253f.jp <= level && tag != null && format != null) {
            Log.println(level, f3622e + tag, String.format(format, args));
        }
    }

    /* renamed from: f */
    public static void m4447f(String tag, String format) {
        if (tag != null && format != null) {
            try {
                int len = format.length();
                int max = 120;
                if (len <= 120) {
                    max = len;
                }
                String tformat = format.substring(0, max);
                String date = f3621c.format(new Date());
                String log = "[" + date + "]" + tformat + "\r\n";
                if (date != null && date.length() >= 10) {
                    FileWriter fw = new FileWriter(C1253f.jm + "/" + date.substring(0, 10) + f3620b, true);
                    fw.write(log);
                    fw.flush();
                    fw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m4428a(String tagName) {
        if (C1251e.m4382t() && !TextUtils.isEmpty(tagName)) {
            f3623f.put(tagName, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* renamed from: b */
    public static void m4434b(String tagName) {
        if (C1251e.m4382t() && !TextUtils.isEmpty(tagName) && f3623f.containsKey(tagName)) {
            Log.d(f3622e + tagName, "QA time is:" + (System.currentTimeMillis() - ((Long) f3623f.get(tagName)).longValue()) + "ms");
            f3623f.remove(tagName);
        }
    }
}
