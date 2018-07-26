package com.facebook.imagepipeline.p153l;

import android.net.Uri;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.p152i.C2952d;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* compiled from: HttpUrlConnectionNetworkFetcher */
/* renamed from: com.facebook.imagepipeline.l.s */
public class C5600s extends C2953c<C5453r> {
    /* renamed from: a */
    public static final int f22667a = 307;
    /* renamed from: b */
    public static final int f22668b = 308;
    /* renamed from: c */
    private static final int f22669c = 3;
    /* renamed from: d */
    private static final int f22670d = 5;
    /* renamed from: e */
    private final ExecutorService f22671e;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.facebook.common.internal.VisibleForTesting
    /* renamed from: b */
    void m19395b(com.facebook.imagepipeline.p153l.C5453r r5, com.facebook.imagepipeline.p153l.ae$a r6) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0019 in list [B:6:0x0016]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
        /*
        r4 = this;
        r0 = 0;
        r2 = r5.m18720e();	 Catch:{ IOException -> 0x001a, all -> 0x0024 }
        r3 = 5;	 Catch:{ IOException -> 0x001a, all -> 0x0024 }
        r0 = r4.m19390a(r2, r3);	 Catch:{ IOException -> 0x001a, all -> 0x0024 }
        if (r0 == 0) goto L_0x0014;	 Catch:{ IOException -> 0x001a, all -> 0x0024 }
    L_0x000c:
        r2 = r0.getInputStream();	 Catch:{ IOException -> 0x001a, all -> 0x0024 }
        r3 = -1;	 Catch:{ IOException -> 0x001a, all -> 0x0024 }
        r6.mo4132a(r2, r3);	 Catch:{ IOException -> 0x001a, all -> 0x0024 }
    L_0x0014:
        if (r0 == 0) goto L_0x0019;
    L_0x0016:
        r0.disconnect();
    L_0x0019:
        return;
    L_0x001a:
        r1 = move-exception;
        r6.mo4133a(r1);	 Catch:{ IOException -> 0x001a, all -> 0x0024 }
        if (r0 == 0) goto L_0x0019;
    L_0x0020:
        r0.disconnect();
        goto L_0x0019;
    L_0x0024:
        r2 = move-exception;
        if (r0 == 0) goto L_0x002a;
    L_0x0027:
        r0.disconnect();
    L_0x002a:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.l.s.b(com.facebook.imagepipeline.l.r, com.facebook.imagepipeline.l.ae$a):void");
    }

    public C5600s() {
        this(Executors.newFixedThreadPool(3));
    }

    @VisibleForTesting
    C5600s(ExecutorService executorService) {
        this.f22671e = executorService;
    }

    /* renamed from: b */
    public C5453r m19394b(C5517j<C2952d> consumer, aj context) {
        return new C5453r(consumer, context);
    }

    /* renamed from: a */
    public void m19393a(final C5453r fetchState, final ae$a callback) {
        final Future<?> future = this.f22671e.submit(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C5600s f22663c;

            public void run() {
                this.f22663c.m19395b(fetchState, callback);
            }
        });
        fetchState.m18717b().m19211a(new C5450e(this) {
            /* renamed from: c */
            final /* synthetic */ C5600s f22666c;

            /* renamed from: a */
            public void mo4052a() {
                if (future.cancel(false)) {
                    callback.mo4131a();
                }
            }
        });
    }

    /* renamed from: a */
    private HttpURLConnection m19390a(Uri uri, int maxRedirects) throws IOException {
        HttpURLConnection connection = C5600s.m19389a(uri);
        int responseCode = connection.getResponseCode();
        if (C5600s.m19391a(responseCode)) {
            return connection;
        }
        if (C5600s.m19392b(responseCode)) {
            String nextUriString = connection.getHeaderField("Location");
            connection.disconnect();
            Uri nextUri = nextUriString == null ? null : Uri.parse(nextUriString);
            String originalScheme = uri.getScheme();
            if (maxRedirects > 0 && nextUri != null && !nextUri.getScheme().equals(originalScheme)) {
                return m19390a(nextUri, maxRedirects - 1);
            }
            String message;
            if (maxRedirects == 0) {
                message = C5600s.m19388a("URL %s follows too many redirects", uri.toString());
            } else {
                message = C5600s.m19388a("URL %s returned %d without a valid redirect", uri.toString(), Integer.valueOf(responseCode));
            }
            throw new IOException(message);
        }
        connection.disconnect();
        throw new IOException(String.format("Image URL %s returned HTTP code %d", new Object[]{uri.toString(), Integer.valueOf(responseCode)}));
    }

    @VisibleForTesting
    /* renamed from: a */
    static HttpURLConnection m19389a(Uri uri) throws IOException {
        return (HttpURLConnection) new URL(uri.toString()).openConnection();
    }

    /* renamed from: a */
    private static boolean m19391a(int responseCode) {
        return responseCode >= 200 && responseCode < 300;
    }

    /* renamed from: b */
    private static boolean m19392b(int responseCode) {
        switch (responseCode) {
            case 300:
            case 301:
            case 302:
            case 303:
            case 307:
            case 308:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    private static String m19388a(String format, Object... args) {
        return String.format(Locale.getDefault(), format, args);
    }
}
