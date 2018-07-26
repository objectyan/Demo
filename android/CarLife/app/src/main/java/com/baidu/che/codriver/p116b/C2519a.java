package com.baidu.che.codriver.p116b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.C2731l;
import com.baidu.che.codriver.vr.C2840n;
import com.baidu.che.codriver.vr.C2848p;
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
import java.util.Map;

/* compiled from: VRTestUtils */
/* renamed from: com.baidu.che.codriver.b.a */
public class C2519a {
    /* renamed from: a */
    public static final boolean f8228a = false;
    /* renamed from: b */
    public static boolean f8229b = C2731l.m10228a(C2716c.m10141a(), "support_aec", false);
    /* renamed from: d */
    private static final String f8230d = "CoDriverTestUtils";
    /* renamed from: e */
    private static Map<String, Long> f8231e = new HashMap();
    /* renamed from: f */
    private static C2519a f8232f;
    /* renamed from: g */
    private static long f8233g = 0;
    /* renamed from: h */
    private static long f8234h = 0;
    /* renamed from: i */
    private static long f8235i = 0;
    /* renamed from: j */
    private static long f8236j = 0;
    /* renamed from: k */
    private static long f8237k = 0;
    /* renamed from: l */
    private static long f8238l = 0;
    /* renamed from: m */
    private static long f8239m = 0;
    /* renamed from: n */
    private static long f8240n = 0;
    /* renamed from: o */
    private static long f8241o = 0;
    /* renamed from: p */
    private static long f8242p = 0;
    /* renamed from: q */
    private static long f8243q = 0;
    /* renamed from: r */
    private static C2515a f8244r;
    /* renamed from: c */
    public C2518b f8245c;

    /* compiled from: VRTestUtils */
    /* renamed from: com.baidu.che.codriver.b.a$a */
    interface C2515a {
        /* renamed from: a */
        void m9530a(String str);
    }

    /* compiled from: VRTestUtils */
    /* renamed from: com.baidu.che.codriver.b.a$b */
    private class C2518b extends Thread {
        /* renamed from: a */
        final /* synthetic */ C2519a f8215a;
        /* renamed from: b */
        private final long f8216b;
        /* renamed from: c */
        private final long f8217c;
        /* renamed from: d */
        private final long f8218d;
        /* renamed from: e */
        private final String f8219e;
        /* renamed from: f */
        private final SimpleDateFormat f8220f;
        /* renamed from: g */
        private final SimpleDateFormat f8221g;
        /* renamed from: h */
        private Handler f8222h;
        /* renamed from: i */
        private Looper f8223i;
        /* renamed from: j */
        private File f8224j;
        /* renamed from: k */
        private File f8225k;
        /* renamed from: l */
        private FileWriter f8226l;
        /* renamed from: m */
        private Comparator<File> f8227m;

        /* compiled from: VRTestUtils */
        /* renamed from: com.baidu.che.codriver.b.a$b$1 */
        class C25161 implements Comparator<File> {
            /* renamed from: a */
            final /* synthetic */ C2518b f8213a;

            C25161(C2518b this$1) {
                this.f8213a = this$1;
            }

            public /* synthetic */ int compare(Object obj, Object obj2) {
                return m9531a((File) obj, (File) obj2);
            }

            /* renamed from: a */
            public int m9531a(File f1, File f2) {
                return (int) (f2.lastModified() - f1.lastModified());
            }
        }

        private C2518b(C2519a c2519a) {
            this.f8215a = c2519a;
            this.f8216b = 5242880;
            this.f8217c = 86400000;
            this.f8218d = 20;
            this.f8219e = C2716c.m10141a().getExternalFilesDir("log") + File.separator;
            this.f8220f = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
            this.f8221g = new SimpleDateFormat("MM-dd_HH_mm_ss.SS");
            this.f8227m = new C25161(this);
        }

        /* renamed from: a */
        public File m9540a() {
            return this.f8225k;
        }

        public void run() {
            this.f8224j = new File(this.f8219e);
            if (!this.f8224j.exists()) {
                this.f8224j.mkdirs();
            }
            File tempFile = null;
            File[] files = this.f8224j.listFiles();
            Arrays.sort(files, this.f8227m);
            if (files != null && files.length > 0) {
                tempFile = files[0];
            }
            if (tempFile != null) {
                long fileCreateTime = 0;
                try {
                    fileCreateTime = this.f8220f.parse(tempFile.getName().substring(0, tempFile.getName().length() - 4)).getTime();
                } catch (ParseException e) {
                    tempFile.delete();
                }
                if (fileCreateTime > 0 && new Date().getTime() - fileCreateTime < 86400000) {
                    this.f8225k = tempFile;
                    try {
                        this.f8226l = new FileWriter(this.f8225k, true);
                    } catch (IOException e2) {
                    }
                }
            }
            Looper.prepare();
            this.f8223i = Looper.myLooper();
            this.f8222h = new Handler(this, this.f8223i) {
                /* renamed from: a */
                final /* synthetic */ C2518b f8214a;

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
                    r3 = r12.f8214a;
                    r3 = r3.f8225k;
                    if (r3 != 0) goto L_0x008d;
                L_0x0012:
                    r3 = r12.f8214a;
                    r3 = r3.f8224j;
                    r1 = r3.listFiles();
                    if (r1 == 0) goto L_0x003c;
                L_0x001e:
                    r3 = r1.length;
                    r4 = (long) r3;
                    r6 = 20;
                    r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
                    if (r3 < 0) goto L_0x003c;
                L_0x0026:
                    r3 = r12.f8214a;
                    r3 = r3.f8227m;
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
                    r3 = r12.f8214a;
                    r4 = new java.io.File;
                    r5 = new java.lang.StringBuilder;
                    r5.<init>();
                    r6 = r12.f8214a;
                    r6 = r6.f8219e;
                    r5 = r5.append(r6);
                    r6 = r12.f8214a;
                    r6 = r6.f8220f;
                    r7 = new java.util.Date;
                    r7.<init>();
                    r6 = r6.format(r7);
                    r5 = r5.append(r6);
                    r6 = ".txt";
                    r5 = r5.append(r6);
                    r5 = r5.toString();
                    r4.<init>(r5);
                    r3.f8225k = r4;
                    r3 = r12.f8214a;	 Catch:{ IOException -> 0x00c7 }
                    r3 = r3.f8225k;	 Catch:{ IOException -> 0x00c7 }
                    r3.createNewFile();	 Catch:{ IOException -> 0x00c7 }
                    r3 = r12.f8214a;	 Catch:{ IOException -> 0x00c7 }
                    r4 = new java.io.FileWriter;	 Catch:{ IOException -> 0x00c7 }
                    r5 = r12.f8214a;	 Catch:{ IOException -> 0x00c7 }
                    r5 = r5.f8225k;	 Catch:{ IOException -> 0x00c7 }
                    r6 = 1;	 Catch:{ IOException -> 0x00c7 }
                    r4.<init>(r5, r6);	 Catch:{ IOException -> 0x00c7 }
                    r3.f8226l = r4;	 Catch:{ IOException -> 0x00c7 }
                L_0x008d:
                    r3 = r12.f8214a;	 Catch:{ IOException -> 0x00cc, all -> 0x00e9 }
                    r3 = r3.f8226l;	 Catch:{ IOException -> 0x00cc, all -> 0x00e9 }
                    if (r3 == 0) goto L_0x00ab;	 Catch:{ IOException -> 0x00cc, all -> 0x00e9 }
                L_0x0095:
                    r3 = r12.f8214a;	 Catch:{ IOException -> 0x00cc, all -> 0x00e9 }
                    r4 = r3.f8226l;	 Catch:{ IOException -> 0x00cc, all -> 0x00e9 }
                    r3 = r13.obj;	 Catch:{ IOException -> 0x00cc, all -> 0x00e9 }
                    r3 = (java.lang.String) r3;	 Catch:{ IOException -> 0x00cc, all -> 0x00e9 }
                    r4.write(r3);	 Catch:{ IOException -> 0x00cc, all -> 0x00e9 }
                    r3 = r12.f8214a;	 Catch:{ IOException -> 0x00cc, all -> 0x00e9 }
                    r3 = r3.f8226l;	 Catch:{ IOException -> 0x00cc, all -> 0x00e9 }
                    r3.flush();	 Catch:{ IOException -> 0x00cc, all -> 0x00e9 }
                L_0x00ab:
                    r3 = r12.f8214a;
                    r3 = r3.f8225k;
                    if (r3 == 0) goto L_0x00c6;
                L_0x00b3:
                    r3 = r12.f8214a;
                    r3 = r3.f8225k;
                    r4 = r3.length();
                    r3 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
                    if (r3 <= 0) goto L_0x00c6;
                L_0x00c1:
                    r3 = r12.f8214a;
                    r3.f8225k = r8;
                L_0x00c6:
                    return;
                L_0x00c7:
                    r0 = move-exception;
                    r0.printStackTrace();
                    goto L_0x008d;
                L_0x00cc:
                    r3 = move-exception;
                    r3 = r12.f8214a;
                    r3 = r3.f8225k;
                    if (r3 == 0) goto L_0x00c6;
                L_0x00d5:
                    r3 = r12.f8214a;
                    r3 = r3.f8225k;
                    r4 = r3.length();
                    r3 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
                    if (r3 <= 0) goto L_0x00c6;
                L_0x00e3:
                    r3 = r12.f8214a;
                    r3.f8225k = r8;
                    goto L_0x00c6;
                L_0x00e9:
                    r3 = move-exception;
                    r4 = r12.f8214a;
                    r4 = r4.f8225k;
                    if (r4 == 0) goto L_0x0105;
                L_0x00f2:
                    r4 = r12.f8214a;
                    r4 = r4.f8225k;
                    r4 = r4.length();
                    r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
                    if (r4 <= 0) goto L_0x0105;
                L_0x0100:
                    r4 = r12.f8214a;
                    r4.f8225k = r8;
                L_0x0105:
                    throw r3;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.che.codriver.b.a.b.2.handleMessage(android.os.Message):void");
                }
            };
            Looper.loop();
        }

        /* renamed from: b */
        public void m9543b() {
            if (this.f8226l != null) {
                try {
                    this.f8226l.close();
                } catch (IOException e) {
                }
            }
            if (this.f8223i != null) {
                this.f8223i.quit();
            }
        }

        /* renamed from: a */
        public void m9542a(Throwable throwable) {
            if (this.f8222h != null) {
                String log = this.f8221g.format(new Date()) + "/CoDriver Crash!\n";
                Message msg = Message.obtain();
                msg.obj = log + Log.getStackTraceString(throwable);
                this.f8222h.sendMessage(msg);
            }
        }

        /* renamed from: a */
        public void m9541a(String level, String tag, String format) {
            if (this.f8222h != null) {
                String log = this.f8221g.format(new Date()) + " " + level + "/" + tag + Config.TRACE_TODAY_VISIT_SPLIT + format + "\n";
                Message msg = Message.obtain();
                msg.obj = log;
                this.f8222h.sendMessage(msg);
            }
        }
    }

    /* renamed from: a */
    public static C2519a m9544a() {
        if (f8232f == null) {
            f8232f = new C2519a();
        }
        return f8232f;
    }

    /* renamed from: b */
    public static void m9551b() {
        if (C2840n.m10672a()) {
            f8233g = SystemClock.elapsedRealtime();
            C2519a.m9560f("---语音引擎Ready---");
        }
    }

    /* renamed from: a */
    public static void m9548a(String params) {
        if (C2840n.m10672a()) {
            f8234h = SystemClock.elapsedRealtime();
            C2519a.m9560f("---语音识别返回时间---" + (f8234h - f8236j) + "ms");
            C2519a.m9560f("---语音识别返回结果---" + params);
        }
    }

    /* renamed from: b */
    public static void m9552b(String params) {
        if (C2840n.m10672a()) {
            f8235i = SystemClock.elapsedRealtime();
            C2519a.m9560f("---NLP语义返回时间---" + (f8235i - f8234h) + "ms");
            C2519a.m9560f("---NLP语义返回结果---" + params);
            C2519a.m9560f("---NLP访问URL---" + C2840n.m10676c());
            C2519a.m9560f("---NLP访问CUID---" + C2716c.m10168n());
        }
    }

    /* renamed from: c */
    public static void m9553c() {
        if (C2840n.m10672a()) {
            f8236j = SystemClock.elapsedRealtime();
            f8242p = f8236j - f8237k;
            C2519a.m9560f("---尾点检测时长---" + f8242p + "ms");
        }
    }

    /* renamed from: d */
    public static void m9555d() {
        if (C2840n.m10672a()) {
            f8237k = SystemClock.elapsedRealtime();
            C2519a.m9560f("---手动记录语音尾点时间---");
        }
    }

    /* renamed from: e */
    public static void m9557e() {
        if (C2840n.m10672a()) {
            f8238l = SystemClock.elapsedRealtime();
            C2519a.m9560f("---检测到语音起点---");
        }
    }

    /* renamed from: f */
    public static void m9559f() {
        if (C2840n.m10672a()) {
            C2519a.m9560f("---识别成功---");
        }
    }

    /* renamed from: g */
    public static void m9561g() {
        if (C2840n.m10672a()) {
            C2519a.m9560f("---识别失败---");
        }
    }

    /* renamed from: h */
    public static void m9562h() {
        if (C2840n.m10672a()) {
            f8240n = SystemClock.elapsedRealtime();
            C2519a.m9560f("---唤醒语音结束---");
        }
    }

    /* renamed from: i */
    public static void m9563i() {
        if (C2840n.m10672a()) {
            f8241o = SystemClock.elapsedRealtime();
            C2519a.m9560f("---唤醒时间---" + (f8241o - f8240n) + "ms");
        }
    }

    /* renamed from: j */
    public static void m9564j() {
        if (C2840n.m10672a()) {
            C2519a.m9560f("---唤醒界面展现时间---" + (SystemClock.elapsedRealtime() - f8241o) + "ms");
        }
    }

    /* renamed from: c */
    public static void m9554c(String text) {
        C2519a.m9560f("---RawText---" + text);
    }

    /* renamed from: a */
    public static void m9547a(C2848p model) {
        if (model == null || !"route".equals(model.m10787c())) {
            C2519a.m9560f("---NLP解析结果---" + (model != null ? model.toString() : null));
        } else {
            C2519a.m9560f("---NLP解析结果---" + model.m10791e() + "---domain:" + model.m10785b() + "---intent:" + model.m10787c());
        }
    }

    /* renamed from: a */
    public static void m9546a(NLPResponseData model) {
        C2519a.m9560f("---NLP访问URL---" + C2840n.m10676c());
        C2519a.m9560f("---CUID---" + C2716c.m10168n());
        C2519a.m9560f("---NLP兜底解析结果---" + (model != null ? model.toString() : null));
    }

    /* renamed from: a */
    public static void m9545a(C2515a printor) {
        f8244r = printor;
    }

    /* renamed from: f */
    private static void m9560f(String text) {
        if (f8244r != null) {
            f8244r.m9530a(text);
        }
        C2725h.m10207b(f8230d, text);
    }

    /* renamed from: k */
    public void m9565k() {
        if (!C2840n.m10672a()) {
        }
    }

    /* renamed from: l */
    public void m9566l() {
        if (this.f8245c != null) {
            this.f8245c.m9543b();
        }
    }

    /* renamed from: a */
    private void m9549a(String level, String tag, String format) {
        if (this.f8245c != null && !C2840n.m10672a()) {
        }
    }

    /* renamed from: a */
    private void m9550a(Throwable throwable) {
        if (this.f8245c != null && !C2840n.m10672a()) {
        }
    }

    /* renamed from: d */
    public static void m9556d(String tagName) {
        if (C2840n.m10672a() && !TextUtils.isEmpty(tagName)) {
            f8231e.put(tagName, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* renamed from: e */
    public static void m9558e(String tagName) {
        if (C2840n.m10672a() && !TextUtils.isEmpty(tagName) && f8231e.containsKey(tagName)) {
            Log.d(f8230d, tagName + Config.TRACE_TODAY_VISIT_SPLIT + (System.currentTimeMillis() - ((Long) f8231e.get(tagName)).longValue()) + "ms");
            f8231e.remove(tagName);
        }
    }
}
