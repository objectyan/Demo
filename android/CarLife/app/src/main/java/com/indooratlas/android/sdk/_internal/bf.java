package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.carlife.core.C1253f;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.baidu.navisdk.util.common.HttpsClient;
import com.baidu.platform.comapi.UIMsg.m_AppUI;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.indooratlas.algorithm.ClientProcessingManager;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocationRequest;
import com.indooratlas.android.sdk.IAOrientationRequest;
import com.indooratlas.android.sdk._internal.ad.C5758a;
import com.indooratlas.android.sdk._internal.av.C5774c;
import com.indooratlas.android.sdk._internal.be.C5789a;
import com.indooratlas.android.sdk._internal.bg.C5819a;
import com.indooratlas.android.sdk._internal.bm.C5797c;
import com.indooratlas.android.sdk._internal.bq.C5793b;
import com.indooratlas.android.sdk._internal.br.C5827a;
import com.indooratlas.android.sdk._internal.bt.C5791a;
import com.indooratlas.android.sdk._internal.cc.C5834a;
import com.indooratlas.android.sdk._internal.co.C5842a;
import com.indooratlas.android.sdk._internal.ct.C58441;
import com.indooratlas.android.sdk._internal.da.C5846a;
import com.indooratlas.android.sdk._internal.ec.C5864b;
import com.indooratlas.android.sdk._internal.ec.C5865a;
import com.indooratlas.android.sdk._internal.eu.C5874c;
import com.indooratlas.android.sdk._internal.ez.C5880a;
import com.indooratlas.android.sdk._internal.fa.C5882a;
import com.indooratlas.android.sdk._internal.fb.C5883a;
import com.indooratlas.android.sdk._internal.fb.C5887e;
import com.indooratlas.android.sdk._internal.fb.C5888f;
import com.indooratlas.android.sdk._internal.fc.C5891c;
import com.indooratlas.android.sdk._internal.fd.C5893a;
import com.indooratlas.android.sdk._internal.fe.C5894a;
import com.indooratlas.android.sdk._internal.ff.C5902h;
import com.indooratlas.android.sdk.internal.DeviceWatchdog;
import com.indooratlas.android.sdk.internal.DeviceWatchdog.C6017a;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

public final class bf {
    /* renamed from: a */
    public C5818b f23156a;
    /* renamed from: b */
    ClientProcessingManager f23157b;
    /* renamed from: c */
    bg f23158c;
    /* renamed from: d */
    bc f23159d;
    /* renamed from: e */
    cz f23160e;
    @NonNull
    /* renamed from: f */
    bi f23161f;
    @NonNull
    /* renamed from: g */
    co f23162g;
    /* renamed from: h */
    bm f23163h;
    /* renamed from: i */
    bn f23164i;
    /* renamed from: j */
    public bb f23165j;
    /* renamed from: k */
    bt f23166k;
    /* renamed from: l */
    bx f23167l;
    /* renamed from: m */
    ac f23168m;
    /* renamed from: n */
    bl f23169n;
    /* renamed from: o */
    public Context f23170o;
    /* renamed from: p */
    volatile boolean f23171p;
    /* renamed from: q */
    ca f23172q;
    /* renamed from: r */
    DeviceWatchdog f23173r;
    /* renamed from: s */
    public ConnectivityManager f23174s;
    /* renamed from: t */
    cj f23175t;
    /* renamed from: u */
    String f23176u;
    /* renamed from: v */
    public cr f23177v;
    /* renamed from: w */
    cf f23178w;
    /* renamed from: x */
    ce f23179x;
    /* renamed from: y */
    cc f23180y;
    /* renamed from: z */
    private bk f23181z;

    /* renamed from: com.indooratlas.android.sdk._internal.bf$a */
    public static class C5790a {
        /* renamed from: a */
        Context f23086a;
        /* renamed from: b */
        Looper f23087b;
        /* renamed from: c */
        bi f23088c;
        /* renamed from: d */
        bk f23089d;
        /* renamed from: e */
        public C5819a f23090e;
        /* renamed from: f */
        public cc f23091f;

        public C5790a(Context context, bi biVar) {
            this.f23086a = context;
            this.f23088c = (bi) eg.m20413a((Object) biVar, "SdkEngineListener must be non empty", new Object[0]);
            this.f23090e = new C5819a(context);
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.bf$b */
    public class C5818b extends av {
        @Nullable
        /* renamed from: A */
        IALocationRequest f23126A;
        /* renamed from: B */
        IAOrientationRequest f23127B;
        /* renamed from: C */
        C5791a f23128C;
        /* renamed from: D */
        bq f23129D;
        /* renamed from: E */
        C6008t f23130E;
        /* renamed from: F */
        final /* synthetic */ bf f23131F;
        /* renamed from: G */
        private boolean f23132G;
        /* renamed from: d */
        IALocation f23133d;
        @Nullable
        /* renamed from: e */
        IALocation[] f23134e;
        /* renamed from: f */
        IALocation f23135f;
        /* renamed from: g */
        boolean f23136g;
        /* renamed from: h */
        boolean f23137h;
        /* renamed from: i */
        C5803j f23138i;
        /* renamed from: j */
        C5803j f23139j;
        /* renamed from: k */
        C5803j f23140k;
        /* renamed from: l */
        C5803j f23141l;
        /* renamed from: m */
        C5803j f23142m;
        /* renamed from: n */
        C5803j f23143n;
        /* renamed from: o */
        C5803j f23144o;
        /* renamed from: p */
        C5803j f23145p;
        /* renamed from: q */
        C5803j f23146q;
        /* renamed from: r */
        C5803j f23147r;
        /* renamed from: s */
        C5803j f23148s;
        /* renamed from: t */
        C5803j f23149t;
        /* renamed from: u */
        C5803j f23150u;
        /* renamed from: v */
        boolean f23151v;
        /* renamed from: w */
        boolean f23152w;
        /* renamed from: x */
        boolean f23153x;
        /* renamed from: y */
        boolean f23154y;
        /* renamed from: z */
        Boolean f23155z;

        /* renamed from: com.indooratlas.android.sdk._internal.bf$b$1 */
        class C57921 extends C5791a {
            /* renamed from: a */
            final /* synthetic */ C5818b f23092a;

            C57921(C5818b c5818b) {
                this.f23092a = c5818b;
            }

            /* renamed from: a */
            public final void mo4607a() {
                this.f23092a.f23131F.f23172q.m20200a("positioning.ssl-negotiated");
            }

            /* renamed from: b */
            public final void mo4614b() {
                if (!this.f23092a.f23131F.f23171p) {
                    this.f23092a.f23131F.f23172q.m20201b("positioning.ssl-negotiated");
                    this.f23092a.f23131F.f23172q.m20201b("positioning.websocket.connected");
                    this.f23092a.m19876a(1002).sendToTarget();
                }
            }

            /* renamed from: a */
            public final void mo4608a(int i, String str, boolean z) {
                if (!this.f23092a.f23131F.f23171p) {
                    this.f23092a.m19877a(1003, i, z ? 1 : 0, str).sendToTarget();
                }
            }

            /* renamed from: a */
            public final void mo4612a(C5882a c5882a) {
                if (!this.f23092a.f23131F.f23171p) {
                    this.f23092a.m19878a(1008, (Object) c5882a).sendToTarget();
                }
            }

            /* renamed from: a */
            public final void mo4613a(C5891c c5891c) {
                if (!this.f23092a.f23131F.f23171p) {
                    this.f23092a.m19885b(C1253f.eY, c5891c);
                }
            }

            /* renamed from: a */
            public final void mo4611a(C5880a c5880a) {
                this.f23092a.m19885b(1012, c5880a);
            }

            /* renamed from: a */
            public final void mo4609a(long j) {
                new Object[1][0] = Long.valueOf(j);
                this.f23092a.m19884b(1020);
            }

            /* renamed from: a */
            public final void mo4610a(C5874c c5874c) {
                this.f23092a.m19885b(1027, c5874c);
            }
        }

        /* renamed from: com.indooratlas.android.sdk._internal.bf$b$2 */
        class C57952 implements C6008t {
            /* renamed from: a */
            final /* synthetic */ C5818b f23094a;

            /* renamed from: com.indooratlas.android.sdk._internal.bf$b$2$1 */
            class C57941 implements C5793b {
                /* renamed from: a */
                final /* synthetic */ C57952 f23093a;

                C57941(C57952 c57952) {
                    this.f23093a = c57952;
                }
            }

            C57952(C5818b c5818b) {
                this.f23094a = c5818b;
            }

            /* renamed from: a */
            public final void m20005a(byte[] bArr) {
                this.f23094a.f23131F.f23156a.m19885b(C1253f.fc, bArr);
            }

            /* renamed from: a */
            public final void m20004a(boolean z) {
                int i;
                new Object[1][0] = Boolean.valueOf(z);
                av avVar = this.f23094a.f23131F.f23156a;
                C5818b c5818b = this.f23094a.f23131F.f23156a;
                if (z) {
                    i = 1014;
                } else {
                    i = 1015;
                }
                avVar.f23023b.sendMessage(c5818b.m19876a(i));
            }

            /* renamed from: a */
            public final void m19998a(double d, int i) {
                Object[] objArr = new Object[]{Double.valueOf(d), Integer.valueOf(i)};
                this.f23094a.f23131F.f23161f.mo4560a(i);
            }

            /* renamed from: a */
            public final void m19999a(int i) {
                new Object[1][0] = Integer.valueOf(i);
                switch (i) {
                    case 0:
                        this.f23094a.f23131F.f23156a.m19884b(2001);
                        return;
                    case 1:
                        this.f23094a.f23131F.f23156a.m19884b(2000);
                        return;
                    default:
                        return;
                }
            }

            /* renamed from: b */
            public final void m20007b(byte[] bArr) {
                this.f23094a.f23131F.f23156a.m19885b(1017, bArr);
            }

            /* renamed from: a */
            public final void m20002a(long j, double d, double d2, double d3, double d4) {
                Object[] objArr = new Object[]{Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)};
                co coVar = this.f23094a.f23131F.f23162g;
                Collection arrayList = new ArrayList(1);
                co.m20234a(coVar.f23341d, coVar.f23339b, arrayList, true);
                co.m20234a(coVar.f23342e, coVar.f23340c, arrayList, false);
                Collections.sort(arrayList, co.f23337g);
                if (arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        C5842a c5842a = (C5842a) it.next();
                        if (c5842a.f23334a) {
                            coVar.f23341d = c5842a.f23335b;
                        } else {
                            coVar.f23342e = c5842a.f23335b;
                        }
                        coVar.m20235a(d, d2, d3, d4);
                    }
                } else {
                    coVar.m20235a(d, d2, d3, d4);
                }
                ArrayList a = this.f23094a.f23131F.f23180y.m20203a(j, this.f23094a.f23131F.f23162g.f23343f);
                if (a.size() > 0) {
                    Iterator it2 = a.iterator();
                    while (it2.hasNext()) {
                        ax axVar = (ax) it2.next();
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.addAll(axVar.f23026b);
                        if (arrayList2.size() > 0) {
                            this.f23094a.f23131F.f23161f.mo4565a(axVar);
                        }
                    }
                }
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: a */
            public final void m20006a(byte[] r13, long r14, long r16, java.lang.String r18) {
                /*
                r12 = this;
                r6 = 0;
                r2 = new java.lang.StringBuilder;
                r3 = "onLogPacket(), uuid: '";
                r2.<init>(r3);
                r0 = r18;
                r2 = r2.append(r0);
                r3 = "', firstIdx: ";
                r2 = r2.append(r3);
                r2 = r2.append(r14);
                r3 = ", lastIdx: ";
                r2 = r2.append(r3);
                r0 = r16;
                r2 = r2.append(r0);
                r3 = ", data length: ";
                r2 = r2.append(r3);
                r3 = r13.length;
                r2.append(r3);
                r2 = r12.f23094a;
                r2 = r2.f23129D;
                if (r2 != 0) goto L_0x0085;
            L_0x0038:
                r2 = r12.f23094a;
                r3 = new com.indooratlas.android.sdk._internal.bq$a;
                r3.<init>();
                r4 = r12.f23094a;
                r4 = r4.f23131F;
                r4 = r4.f23158c;
                r4 = r4.f23190a;
                r3.f23224a = r4;
                r4 = new com.indooratlas.android.sdk._internal.gh;
                r4.<init>();
                r3.f23226c = r4;
                r4 = r12.f23094a;
                r4 = r4.f23131F;
                r4 = r4.f23165j;
                r4 = r4.m19981c();
                r3.f23227d = r4;
                r4 = new com.indooratlas.android.sdk._internal.bf$b$2$1;
                r4.<init>(r12);
                r3.f23225b = r4;
                r4 = new com.indooratlas.android.sdk._internal.bq;
                r5 = r3.f23224a;
                r4.<init>(r5);
                r5 = r3.f23226c;
                r4.f23233a = r5;
                r5 = r3.f23225b;
                r4.f23237e = r5;
                r3 = r3.f23227d;
                if (r3 == 0) goto L_0x007e;
            L_0x0076:
                r5 = r4.f23234b;
                r5 = r3.equals(r5);
                if (r5 != 0) goto L_0x0081;
            L_0x007e:
                r4.m20132b();
            L_0x0081:
                r4.f23234b = r3;
                r2.f23129D = r4;
            L_0x0085:
                r2 = r12.f23094a;
                r4 = r2.f23129D;
                r2 = r12.f23094a;
                r2 = r2.f23131F;
                r2 = r2.f23173r;
                r2 = r2.f24598g;
                if (r13 == 0) goto L_0x00a2;
            L_0x0093:
                r3 = r13.length;
                if (r3 == 0) goto L_0x00a2;
            L_0x0096:
                r6 = 0;
                r3 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1));
                if (r3 < 0) goto L_0x00a2;
            L_0x009c:
                r3 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1));
                if (r3 < 0) goto L_0x00a2;
            L_0x00a0:
                if (r18 != 0) goto L_0x00a3;
            L_0x00a2:
                return;
            L_0x00a3:
                r3 = r4.f23238f;
                if (r3 == 0) goto L_0x00c6;
            L_0x00a7:
                r3 = r4.f23238f;
                r0 = r18;
                r3 = r3.equals(r0);
                if (r3 == 0) goto L_0x00c6;
            L_0x00b1:
                r2 = new java.lang.StringBuilder;
                r3 = "log sending has failed for uuid ";
                r2.<init>(r3);
                r0 = r18;
                r2 = r2.append(r0);
                r3 = ", ignoring";
                r2.append(r3);
                goto L_0x00a2;
            L_0x00c6:
                r3 = new com.indooratlas.android.sdk._internal.bq$c;
                r5 = r13;
                r6 = r14;
                r8 = r16;
                r10 = r18;
                r3.<init>(r4, r5, r6, r8, r10);
                r5 = r4.f23235c;
                monitor-enter(r5);
                r6 = r4.f23235c;	 Catch:{ all -> 0x0101 }
                r6.add(r3);	 Catch:{ all -> 0x0101 }
                r3 = r4.f23235c;	 Catch:{ all -> 0x0101 }
                r3 = r3.size();	 Catch:{ all -> 0x0101 }
                r6 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
                if (r3 != r6) goto L_0x0107;
            L_0x00e3:
                r3 = r4.f23235c;	 Catch:{ all -> 0x0101 }
                monitor-enter(r3);	 Catch:{ all -> 0x0101 }
                r2 = r4.f23235c;	 Catch:{ all -> 0x0104 }
                r2 = r2.isEmpty();	 Catch:{ all -> 0x0104 }
                if (r2 != 0) goto L_0x00fb;
            L_0x00ee:
                r2 = r4.f23235c;	 Catch:{ all -> 0x0104 }
                r6 = 0;
                r2 = r2.get(r6);	 Catch:{ all -> 0x0104 }
                r2 = (com.indooratlas.android.sdk._internal.bq.C5826c) r2;	 Catch:{ all -> 0x0104 }
                r2 = r2.f23231d;	 Catch:{ all -> 0x0104 }
                r4.f23238f = r2;	 Catch:{ all -> 0x0104 }
            L_0x00fb:
                monitor-exit(r3);	 Catch:{ all -> 0x0104 }
                r4.m20132b();	 Catch:{ all -> 0x0101 }
                monitor-exit(r5);	 Catch:{ all -> 0x0101 }
                goto L_0x00a2;
            L_0x0101:
                r2 = move-exception;
                monitor-exit(r5);	 Catch:{ all -> 0x0101 }
                throw r2;
            L_0x0104:
                r2 = move-exception;
                monitor-exit(r3);	 Catch:{ all -> 0x0104 }
                throw r2;	 Catch:{ all -> 0x0101 }
            L_0x0107:
                monitor-exit(r5);	 Catch:{ all -> 0x0101 }
                if (r2 == 0) goto L_0x010d;
            L_0x010a:
                r4.m20131a();
            L_0x010d:
                r3 = new java.lang.StringBuilder;
                r4 = "newCpaLogPacket added, eventRange: ";
                r3.<init>(r4);
                r3 = r3.append(r14);
                r4 = "-";
                r3 = r3.append(r4);
                r0 = r16;
                r3 = r3.append(r0);
                r4 = ", uuid: ";
                r3 = r3.append(r4);
                r0 = r18;
                r3 = r3.append(r0);
                r4 = ", internet active: ";
                r3 = r3.append(r4);
                r3.append(r2);
                goto L_0x00a2;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.indooratlas.android.sdk._internal.bf.b.2.a(byte[], long, long, java.lang.String):void");
            }

            /* renamed from: a */
            public final void m20000a(int i, String str) {
                new StringBuilder("onLogMessage(), logType: ").append(i).append(", message: ").append(str);
            }

            /* renamed from: a */
            public final void m20001a(long j, double d) {
                new StringBuilder("onHeadingChange(), clientTime = ").append(j).append(", heading = ").append(d);
                this.f23094a.f23131F.f23161f.mo4561a(j, d);
            }

            /* renamed from: a */
            public final void m20003a(long j, double[] dArr) {
                new StringBuilder("onOrientationChange(), clientTime = ").append(j).append(", orientation = ").append(Arrays.toString(dArr));
                this.f23094a.f23131F.f23161f.mo4562a(j, dArr);
            }
        }

        /* renamed from: com.indooratlas.android.sdk._internal.bf$b$j */
        abstract class C5803j extends au {
            /* renamed from: b */
            final int f23104b;
            /* renamed from: c */
            final /* synthetic */ C5818b f23105c;

            C5803j(C5818b c5818b, int i) {
                this.f23105c = c5818b;
                this.f23104b = i;
            }

            /* renamed from: a */
            public final void mo4621a() {
                new StringBuilder("==> enter: ").append(m19853c());
                mo4623d();
                this.f23105c.f23131F.f23161f.mo4568a(m19853c());
            }

            /* renamed from: b */
            public final void mo4622b() {
                new StringBuilder("<== exit: ").append(m19853c());
                mo4625e();
                this.f23105c.f23131F.f23161f.mo4571b(m19853c());
            }

            /* renamed from: a */
            public final boolean mo4601a(Message message) {
                Object[] objArr = new Object[]{m19853c(), this.f23105c.m20083d(message.what), Integer.valueOf(message.arg1), Integer.valueOf(message.arg2)};
                if (message.what != 3) {
                    return mo4624b(message);
                }
                C5774c.m19871b(this.f23105c.f23023b);
                return true;
            }

            /* renamed from: b */
            boolean mo4624b(Message message) {
                return false;
            }

            /* renamed from: d */
            void mo4623d() {
            }

            /* renamed from: e */
            void mo4625e() {
            }

            public String toString() {
                return m19853c();
            }
        }

        /* renamed from: com.indooratlas.android.sdk._internal.bf$b$a */
        class C5804a extends C5803j {
            /* renamed from: a */
            final /* synthetic */ C5818b f23106a;

            /* renamed from: com.indooratlas.android.sdk._internal.bf$b$a$1 */
            class C57981 extends C5797c {
                /* renamed from: a */
                final /* synthetic */ C5804a f23095a;

                C57981(C5804a c5804a) {
                    this.f23095a = c5804a;
                }

                /* renamed from: a */
                public final void mo4615a(bp bpVar) {
                    new Object[1][0] = bpVar;
                    this.f23095a.f23106a.f23131F.f23161f.mo4567a(bpVar);
                }
            }

            /* renamed from: com.indooratlas.android.sdk._internal.bf$b$a$5 */
            class C58025 implements C6017a {
                /* renamed from: a */
                final /* synthetic */ C5804a f23103a;

                C58025(C5804a c5804a) {
                    this.f23103a = c5804a;
                }

                /* renamed from: a */
                public final void m20025a(DeviceWatchdog deviceWatchdog) {
                    this.f23103a.f23106a.f23131F.f23163h.m20116a(deviceWatchdog.a(), 0);
                }
            }

            C5804a(C5818b c5818b) {
                this.f23106a = c5818b;
                super(c5818b, 10);
            }

            /* renamed from: d */
            public final void mo4623d() {
                boolean z;
                int i;
                bf bfVar = this.f23106a.f23131F;
                this.f23106a.f23131F.f23165j = bk.m20098a(new JSONObject());
                this.f23106a.f23131F.f23172q = bk.m20106d(bfVar);
                this.f23106a.f23131F.f23169n = new bl(this.f23106a.f23131F.f23170o);
                this.f23106a.f23131F.f23174s = bk.m20103b(bfVar);
                this.f23106a.f23131F.f23163h = bk.m20099a();
                this.f23106a.f23131F.f23163h.f23207b = new C57981(this);
                bl blVar = this.f23106a.f23131F.f23169n;
                String str = this.f23106a.f23131F.f23158c.f23191b;
                String string = blVar.f23201a.getString("api.key", null);
                blVar.f23202b.putString("api.key", str);
                if (string == null || !string.equals(str)) {
                    blVar.f23202b.putString("idauuid", ct.m20255a(str, UUID.randomUUID().toString()));
                }
                blVar.m20111b();
                this.f23106a.f23131F.f23160e = bk.m20102a(bfVar);
                cz.m20280a("IASensor");
                this.f23106a.f23131F.f23157b = bk.m20096a(this.f23106a.f23130E);
                this.f23106a.f23131F.f23158c.f23196g.getInt("com.indooratlas.android.sdk.intent.extras..cpa.log.level", 0);
                this.f23106a.f23131F.f23168m = bk.m20097a(this.f23106a.f23131F.f23158c.f23190a, this.f23106a.f23131F.f23158c.f23191b, this.f23106a.f23131F.f23158c.f23192c, ct.m20253a());
                this.f23106a.f23131F.f23166k = bk.m20100a(bfVar, this.f23106a.f23128C);
                this.f23106a.f23131F.f23164i = bk.m20105c(bfVar);
                bn bnVar = this.f23106a.f23131F.f23164i;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                boolean z2 = false;
                boolean z3 = false;
                boolean z4 = false;
                boolean z5 = false;
                boolean z6 = false;
                boolean z7 = false;
                boolean z8 = false;
                cw a = bnVar.f23211c.m20283a(6);
                if (a != null) {
                    arrayList.add(a);
                    C5846a c5846a = new C5846a();
                    c5846a.f23371c = 3;
                    c5846a.f23369a = bnVar.f23210b.f23156a.f23023b;
                    arrayList2.add(c5846a.m20293b());
                    z6 = true;
                }
                a = bnVar.f23211c.m20283a(1);
                if (a != null) {
                    arrayList.add(a);
                    c5846a = new C5846a();
                    c5846a.f23371c = 0;
                    c5846a.f23369a = bnVar.f23210b.f23156a.f23023b;
                    arrayList2.add(c5846a.m20293b());
                    z2 = true;
                }
                a = bnVar.f23211c.m20283a(4);
                if (a != null) {
                    arrayList.add(a);
                    c5846a = new C5846a();
                    c5846a.f23371c = 0;
                    c5846a.f23369a = bnVar.f23210b.f23156a.f23023b;
                    arrayList2.add(c5846a.m20293b());
                    z3 = true;
                }
                a = bnVar.f23211c.m20283a(2);
                if (a != null) {
                    arrayList.add(a);
                    c5846a = new C5846a();
                    c5846a.f23371c = 0;
                    c5846a.f23369a = bnVar.f23210b.f23156a.f23023b;
                    arrayList2.add(c5846a.m20293b());
                    z5 = true;
                }
                if (VERSION.SDK_INT >= 18) {
                    a = bnVar.f23211c.m20283a(14);
                    if (a != null) {
                        arrayList.add(a);
                        c5846a = new C5846a();
                        c5846a.f23371c = 0;
                        c5846a.f23369a = bnVar.f23210b.f23156a.f23023b;
                        arrayList2.add(c5846a.m20293b());
                        z4 = true;
                    }
                }
                if (VERSION.SDK_INT >= 23 && ct.m20266a(bnVar.f23210b.f23170o, "android.permission.ACCESS_COARSE_LOCATION")) {
                    bnVar.f23214f = bnVar.f23211c.m20283a(-100);
                } else if (VERSION.SDK_INT < 23) {
                    bnVar.f23214f = bnVar.f23211c.m20283a(-100);
                } else {
                    ee.m20409a("IASDK", "no permission to scan wifi", new Object[0]);
                    bnVar.f23214f = null;
                }
                WifiManager wifiManager = (WifiManager) bnVar.f23210b.f23170o.getSystemService(C1981b.f6365e);
                if (wifiManager != null) {
                    boolean z9 = bnVar.f23214f != null && cv.m20273a(wifiManager) && wifiManager.isWifiEnabled();
                    z = z9;
                } else {
                    z = false;
                }
                if (bf.m20086d() && ct.m20265a(bnVar.f23210b.f23170o) && ct.m20269b(bnVar.f23210b.f23170o)) {
                    bnVar.f23215g = bnVar.f23211c.m20283a((int) SapiErrorCode.NETWORK_FAILED);
                    z7 = bnVar.f23215g != null;
                }
                if (ct.m20266a(bnVar.f23210b.f23170o, "android.permission.ACCESS_FINE_LOCATION")) {
                    bnVar.f23216h = bnVar.f23211c.m20283a(-302);
                    if (bnVar.f23216h != null) {
                        z8 = true;
                    }
                }
                be.f23085a = new C5789a(z4, z5, z3, z2, z, z6, z7, z8);
                bnVar.f23212d = new cw[arrayList.size()];
                bnVar.f23212d = (cw[]) arrayList.toArray(bnVar.f23212d);
                bnVar.f23213e = new da[arrayList2.size()];
                bnVar.f23213e = (da[]) arrayList2.toArray(bnVar.f23213e);
                bnVar.f23209a.m20301a(new du(bnVar.f23212d));
                int i2 = z2 ? 1 : 0;
                int i3 = z3 ? 1 : 0;
                if (z5 && z4) {
                    i = 3;
                } else if (z5) {
                    i = 1;
                } else if (z4) {
                    i = 2;
                } else {
                    i = 0;
                }
                bnVar.f23217i.defineAvailableSensors(i2, i3, i, z6 ? 1 : 0);
                dd ddVar = this.f23106a.f23131F.f23164i.f23209a;
                this.f23106a.f23131F.f23178w = new cf(this.f23106a.f23131F.f23157b, this.f23106a.f23131F.f23177v);
                ddVar.m20301a(this.f23106a.f23131F.f23178w);
                ddVar.m20301a(new ch(this, this.f23106a.f23131F) {
                    /* renamed from: a */
                    final /* synthetic */ C5804a f23098a;

                    /* renamed from: a */
                    protected final void mo4618a(C5902h c5902h) {
                        if (!this.f23098a.f23106a.f23131F.f23171p) {
                            this.f23098a.f23106a.m19885b(1018, c5902h);
                        }
                    }
                });
                if (be.f23085a.f23083i) {
                    this.f23106a.f23131F.f23179x = new ce(this, this.f23106a.f23131F) {
                        /* renamed from: a */
                        final /* synthetic */ C5804a f23100a;

                        /* renamed from: a */
                        protected final void mo4619a(C5902h c5902h) {
                            if (!this.f23100a.f23106a.f23131F.f23171p) {
                                this.f23100a.f23106a.m19885b(1018, c5902h);
                            }
                        }
                    };
                    ddVar.m20301a(this.f23106a.f23131F.f23179x);
                }
                if (be.f23085a.f23084j) {
                    ddVar.m20301a(new cg(this, this.f23106a.f23131F.f23177v) {
                        /* renamed from: a */
                        final /* synthetic */ C5804a f23102a;

                        /* renamed from: a */
                        protected final void mo4620a(IALocation... iALocationArr) {
                            if (!this.f23102a.f23106a.f23131F.f23171p) {
                                this.f23102a.f23106a.m19885b(1025, iALocationArr);
                            }
                        }
                    });
                }
                this.f23106a.f23131F.f23173r = bk.m20108f(bfVar);
                DeviceWatchdog deviceWatchdog = this.f23106a.f23131F.f23173r;
                deviceWatchdog.f24593b = new C58025(this);
                deviceWatchdog.f24593b.a(deviceWatchdog.f24594c);
                this.f23106a.f23151v = true;
                if (!be.f23085a.f23080f && this.f23106a.f23131F.f23173r.a() == 10) {
                    this.f23106a.f23131F.f23163h.m20116a(10, (long) BNOffScreenParams.MIN_ENTER_INTERVAL);
                }
                this.f23106a.f23131F.f23172q.m20200a("sdk.positioning-started");
                this.f23106a.m19881a(this.f23106a.f23142m);
            }
        }

        /* renamed from: com.indooratlas.android.sdk._internal.bf$b$b */
        class C5805b extends C5803j {
            /* renamed from: a */
            final /* synthetic */ C5818b f23107a;

            C5805b(C5818b c5818b) {
                this.f23107a = c5818b;
                super(c5818b, 50);
            }

            /* renamed from: d */
            final void mo4623d() {
                C5818b.m20070b(this.f23107a);
            }

            /* renamed from: b */
            final boolean mo4624b(Message message) {
                switch (message.what) {
                    case 1020:
                        Object[] objArr = new Object[]{Integer.valueOf(message.what), Integer.valueOf(message.arg1)};
                        this.f23107a.m19881a(this.f23107a.f23142m);
                        return true;
                    default:
                        return false;
                }
            }

            /* renamed from: e */
            final void mo4625e() {
                this.f23107a.m19886c(104);
                C5818b.m20065a(this.f23107a);
            }
        }

        /* renamed from: com.indooratlas.android.sdk._internal.bf$b$c */
        class C5806c extends C5803j {
            /* renamed from: a */
            final /* synthetic */ C5818b f23108a;

            C5806c(C5818b c5818b) {
                this.f23108a = c5818b;
                super(c5818b, 35);
            }

            /* renamed from: b */
            final boolean mo4624b(Message message) {
                switch (message.what) {
                    case 5:
                        C5818b.m20071c(this.f23108a);
                        this.f23108a.m19881a(this.f23108a.f23145p);
                        break;
                }
                return false;
            }
        }

        /* renamed from: com.indooratlas.android.sdk._internal.bf$b$d */
        class C5807d extends C5803j {
            /* renamed from: a */
            final /* synthetic */ C5818b f23109a;

            C5807d(C5818b c5818b) {
                this.f23109a = c5818b;
                super(c5818b, 110);
            }

            /* renamed from: d */
            final void mo4623d() {
                this.f23109a.f23137h = false;
            }

            /* renamed from: b */
            final boolean mo4624b(Message message) {
                switch (message.what) {
                    case 1021:
                        this.f23109a.m19881a(this.f23109a.f23150u);
                        return true;
                    case C1253f.eY /*1022*/:
                        if (this.f23109a.f23155z == Boolean.FALSE && cp.m20240a((C5891c) message.obj)) {
                            this.f23109a.m19886c(1021);
                            this.f23109a.m19881a(this.f23109a.f23150u);
                        }
                        return false;
                    case 2000:
                        Boolean bool = Boolean.FALSE;
                        this.f23109a.m19886c(1021);
                        return false;
                    case 2001:
                        this.f23109a.f23155z = Boolean.valueOf(false);
                        if (this.f23109a.f23153x) {
                            this.f23109a.m19881a(this.f23109a.f23150u);
                        } else {
                            this.f23109a.m19880a(1021, (long) HttpsClient.CONN_MGR_TIMEOUT);
                        }
                        return false;
                    default:
                        return false;
                }
            }
        }

        /* renamed from: com.indooratlas.android.sdk._internal.bf$b$e */
        class C5808e extends C5803j {
            /* renamed from: a */
            final /* synthetic */ C5818b f23110a;

            C5808e(C5818b c5818b) {
                this.f23110a = c5818b;
                super(c5818b, 105);
            }

            /* renamed from: d */
            final void mo4623d() {
                this.f23110a.f23131F.f23164i.m20123c();
                bn bnVar = this.f23110a.f23131F.f23164i;
                cw a = bnVar.f23211c.m20283a(1);
                cz czVar = bnVar.f23211c;
                cy cyVar = bnVar.f23209a;
                C5846a c5846a = new C5846a();
                c5846a.f23371c = 3;
                c5846a.f23369a = bnVar.f23210b.f23156a.f23023b;
                czVar.m20287a(cyVar, a, c5846a.m20293b());
                a.mo4658a();
                this.f23110a.m19886c(108);
            }

            /* renamed from: e */
            final void mo4625e() {
                this.f23110a.f23131F.f23164i.m20123c();
                this.f23110a.f23131F.f23164i.m20119a();
                C5818b.m20077h(this.f23110a);
            }

            /* renamed from: b */
            final boolean mo4624b(Message message) {
                switch (message.what) {
                    case 1017:
                        return true;
                    case 2000:
                        this.f23110a.f23155z = Boolean.valueOf(true);
                        this.f23110a.m19881a(this.f23110a.f23149t);
                        return true;
                    default:
                        return false;
                }
            }
        }

        /* renamed from: com.indooratlas.android.sdk._internal.bf$b$f */
        class C5809f extends C5803j {
            /* renamed from: a */
            final /* synthetic */ C5818b f23111a;

            C5809f(C5818b c5818b) {
                this.f23111a = c5818b;
                super(c5818b, 100);
            }

            /* renamed from: d */
            final void mo4623d() {
                if (!this.f23111a.f23153x) {
                    this.f23111a.f23131F.f23172q.m20200a("positioning.first-fix");
                }
                this.f23111a.m20080a(false);
                C5818b c5818b = this.f23111a;
                if (c5818b.f23131F.f23158c.f23196g.getBoolean("com.indooratlas.android.sdk.intent.extras.feature_platform_locations", true)) {
                    cw a = c5818b.f23131F.f23160e.m20283a(-300);
                    cw a2 = c5818b.f23131F.f23160e.m20283a(-301);
                    ArrayList arrayList = new ArrayList();
                    if (a != null) {
                        arrayList.addAll(c5818b.f23131F.f23160e.m20285a(a));
                    }
                    if (a2 != null) {
                        arrayList.addAll(c5818b.f23131F.f23160e.m20285a(a2));
                    }
                    if (arrayList.size() > 0) {
                        c5818b.f23134e = new IALocation[arrayList.size()];
                        for (int i = 0; i < arrayList.size(); i++) {
                            c5818b.f23134e[i] = ct.m20252a((cx) arrayList.get(i)).newBuilder().withLongExtra("com.indooratlas.android.sdk.intent.extras.clientTime", c5818b.f23131F.f23177v.mo4654a()).build();
                        }
                        new Object[1][0] = Arrays.toString(c5818b.f23134e);
                    }
                }
                C5818b.m20076g(this.f23111a);
                C5818b c5818b2 = this.f23111a;
                if (c5818b2.f23134e != null) {
                    c5818b2.f23131F.f23166k.m20153a(c5818b2.f23134e);
                    c5818b2.f23134e = null;
                }
            }

            /* renamed from: b */
            final boolean mo4624b(Message message) {
                int i = 0;
                switch (message.what) {
                    case 6:
                        this.f23111a.f23131F.f23166k.m20147a(3, new C5894a());
                        C5818b.m20073d(this.f23111a);
                        this.f23111a.m19881a(this.f23111a.f23147r);
                        return true;
                    case 7:
                        C5818b.m20066a(this.f23111a, message);
                        C5818b.m20076g(this.f23111a);
                        return true;
                    case 108:
                        this.f23111a.f23131F.f23164i.m20127g();
                        return true;
                    case 1008:
                        C5882a c5882a = (C5882a) message.obj;
                        new Object[1][0] = c5882a;
                        if ("setup_required".equals(c5882a.f23601b)) {
                            this.f23111a.m20080a(true);
                            return true;
                        }
                        ee.m20409a("IACore", "error not handled: code %s, msg: %s", c5882a.f23601b, c5882a.f23602d);
                        return false;
                    case 1018:
                        int length;
                        bt btVar = this.f23111a.f23131F.f23166k;
                        C5902h c5902h = (C5902h) message.obj;
                        C6001m e = btVar.m20157e();
                        e.f23611f = c5902h;
                        Object[] objArr = new Object[5];
                        objArr[0] = Integer.valueOf(c5902h.f23662d != null ? c5902h.f23662d.f23660b.length : 0);
                        if (c5902h.f23663e != null) {
                            length = c5902h.f23663e.f23660b.length;
                        } else {
                            length = 0;
                        }
                        objArr[1] = Integer.valueOf(length);
                        if (c5902h.f23665g != null) {
                            length = c5902h.f23665g.f23645d.length;
                        } else {
                            length = 0;
                        }
                        objArr[2] = Integer.valueOf(length);
                        if (c5902h.f23665g != null) {
                            i = c5902h.f23665g.f23644b.length;
                        }
                        objArr[3] = Integer.valueOf(i);
                        objArr[4] = Integer.valueOf(-1);
                        btVar.m20147a(2, e);
                        return true;
                    case C1253f.eZ /*1023*/:
                        this.f23111a.f23131F.f23164i.m20121a(true);
                        C5818b.m20077h(this.f23111a);
                        return true;
                    case 1024:
                        this.f23111a.f23131F.f23164i.m20121a(false);
                        this.f23111a.m19886c(108);
                        return true;
                    case 1025:
                        this.f23111a.f23131F.f23166k.m20153a((IALocation[]) message.obj);
                        return true;
                    case C1253f.fc /*1026*/:
                        this.f23111a.m20080a(false);
                        bt btVar2 = this.f23111a.f23131F.f23166k;
                        byte[] bArr = (byte[]) message.obj;
                        if (bt.f23248a && bArr != null) {
                            Object[] objArr2 = new Object[]{Long.valueOf(bt.m20143a(bArr).f23683b), Long.valueOf(btVar2.f23257i.mo4654a()), Integer.valueOf(bArr.length)};
                            btVar2.f23253e = bt.m20142a(btVar2.f23253e, bt.m20143a(bArr).f23683b);
                            if (btVar2.f23253e < btVar2.f23254f) {
                                ee.m20409a("IAWire", "last track node time < track radio time; %d < %d", Long.valueOf(btVar2.f23253e), Long.valueOf(btVar2.f23254f));
                            }
                        }
                        C6001m e2 = btVar2.m20157e();
                        C5887e c5887e = new C5887e();
                        c5887e.f23618d = new C5888f[]{new C5888f()};
                        c5887e.f23618d[0].f23621d = bArr;
                        c5887e.f23618d[0].f23620b = btVar2.f23257i.mo4654a();
                        e2.f23610e = c5887e;
                        btVar2.m20147a(2, e2);
                        return true;
                    case 1027:
                        C5874c c5874c = (C5874c) message.obj;
                        if (!(c5874c == null || c5874c.f23554b == null)) {
                            this.f23111a.f23131F.f23164i.m20120a((long) (c5874c.f23554b.f23548d * 1000));
                            if (this.f23111a.f23131F.f23179x != null) {
                                this.f23111a.f23131F.f23179x.m20019a(c5874c.f23554b);
                            }
                            C5818b.m20077h(this.f23111a);
                        }
                        return true;
                    default:
                        return false;
                }
            }
        }

        /* renamed from: com.indooratlas.android.sdk._internal.bf$b$g */
        class C5810g extends C5803j {
            /* renamed from: a */
            final /* synthetic */ C5818b f23112a;
            /* renamed from: d */
            private float f23113d;

            C5810g(C5818b c5818b) {
                this.f23112a = c5818b;
                super(c5818b, 90);
            }

            /* renamed from: d */
            final void mo4623d() {
                this.f23113d = 0.0f;
                if (this.f23112a.f23131F.f23158c.f23196g.getBoolean("com.indooratlas.android.sdk.intent.extras.feature_enable_message_buffer", false)) {
                    this.f23112a.f23131F.f23166k.m20152a(false);
                }
                if (this.f23112a.f23131F.f23165j.f23073b.optBoolean("positioningHibernateEnabled", true)) {
                    new StringBuilder("Hibernate enabled, timeout for closing sockets: ").append(this.f23112a.f23131F.f23165j.m19980b());
                    this.f23112a.m19880a(1010, this.f23112a.f23131F.f23165j.m19980b());
                }
                if (this.f23112a.f23137h) {
                    C5818b.m20074e(this.f23112a);
                }
            }

            /* renamed from: b */
            final boolean mo4624b(Message message) {
                switch (message.what) {
                    case 5:
                        C5774c.m19867a(this.f23112a.f23023b, message);
                        this.f23112a.m19881a(this.f23112a.f23149t);
                        return true;
                    case 7:
                        C5818b.m20066a(this.f23112a, message);
                        return true;
                    case 1010:
                        this.f23112a.m19881a(this.f23112a.f23141l);
                        return true;
                    case 1015:
                        C5818b.m20075f(this.f23112a);
                        return false;
                    case 1016:
                        return true;
                    default:
                        return false;
                }
            }

            /* renamed from: e */
            final void mo4625e() {
                this.f23112a.m19886c(1010);
                C5818b.m20075f(this.f23112a);
            }
        }

        /* renamed from: com.indooratlas.android.sdk._internal.bf$b$h */
        class C5811h extends C5803j {
            /* renamed from: a */
            final /* synthetic */ C5818b f23114a;

            C5811h(C5818b c5818b) {
                this.f23114a = c5818b;
                super(c5818b, 30);
            }

            /* renamed from: d */
            final void mo4623d() {
                this.f23114a.f23153x = false;
            }

            /* renamed from: b */
            final boolean mo4624b(Message message) {
                dc dcVar;
                switch (message.what) {
                    case 2:
                        this.f23114a.m19881a(this.f23114a.f23139j);
                        return true;
                    case 5:
                        C5818b c5818b = this.f23114a;
                        c5818b.f23126A = (IALocationRequest) message.obj;
                        c5818b.m20082c();
                        C5818b.m20071c(this.f23114a);
                        return true;
                    case 6:
                        C5818b.m20073d(this.f23114a);
                        return true;
                    case 7:
                        this.f23114a.m20079a((IALocation) message.obj);
                        return true;
                    case 8:
                        this.f23114a.f23127B = (IAOrientationRequest) message.obj;
                        this.f23114a.m20082c();
                        return true;
                    case 104:
                        C5818b.m20070b(this.f23114a);
                        return true;
                    case 105:
                        dcVar = (dc) message.obj;
                        new Object[1][0] = dcVar;
                        this.f23114a.f23131F.f23164i.f23209a.m20301a(dcVar);
                        break;
                    case 106:
                        int length;
                        Object[] objArr;
                        int length2;
                        Object newInstance;
                        dc[] dcVarArr;
                        dcVar = (dc) message.obj;
                        dd ddVar = this.f23114a.f23131F.f23164i.f23209a;
                        Object obj = ddVar.f23376b;
                        C5864b c5865a = new C5865a(dcVar);
                        if (obj != null) {
                            length = obj.length;
                            for (int i = 0; i < length; i++) {
                                if (c5865a.mo4670a(obj[i])) {
                                    length = i;
                                    if (length != -1) {
                                        objArr = obj;
                                    } else {
                                        length2 = obj == null ? obj.length : 0;
                                        if (length < length2) {
                                            throw new IndexOutOfBoundsException("index: " + length + ", length: " + length2);
                                        }
                                        newInstance = Array.newInstance(obj.getClass().getComponentType(), length2 - 1);
                                        System.arraycopy(obj, 0, newInstance, 0, length);
                                        if (length < length2 - 1) {
                                            System.arraycopy(obj, length + 1, newInstance, length, (length2 - length) - 1);
                                        }
                                        objArr = (Object[]) newInstance;
                                    }
                                    dcVarArr = (dc[]) objArr;
                                    if (dcVarArr.length != ddVar.f23375a) {
                                        ddVar.f23376b = dcVarArr;
                                        ddVar.f23375a--;
                                        break;
                                    }
                                }
                            }
                        }
                        length = -1;
                        if (length != -1) {
                            if (obj == null) {
                            }
                            if (length < length2) {
                                newInstance = Array.newInstance(obj.getClass().getComponentType(), length2 - 1);
                                System.arraycopy(obj, 0, newInstance, 0, length);
                                if (length < length2 - 1) {
                                    System.arraycopy(obj, length + 1, newInstance, length, (length2 - length) - 1);
                                }
                                objArr = (Object[]) newInstance;
                            } else {
                                throw new IndexOutOfBoundsException("index: " + length + ", length: " + length2);
                            }
                        }
                        objArr = obj;
                        dcVarArr = (dc[]) objArr;
                        if (dcVarArr.length != ddVar.f23375a) {
                            ddVar.f23376b = dcVarArr;
                            ddVar.f23375a--;
                        }
                        break;
                    case 107:
                        br brVar = (br) message.obj;
                        bt btVar;
                        if ((message.arg1 == 0 ? 1 : null) == null) {
                            btVar = this.f23114a.f23131F.f23166k;
                            if (btVar.f23260l == null) {
                                btVar.f23260l = new C5827a();
                            }
                            btVar.f23260l.m20134a(brVar);
                            break;
                        }
                        btVar = this.f23114a.f23131F.f23166k;
                        if (btVar.f23259k == null) {
                            btVar.f23259k = new C5827a();
                        }
                        btVar.f23259k.m20134a(brVar);
                        break;
                    case 108:
                        this.f23114a.f23131F.f23164i.m20127g();
                        return true;
                    case 109:
                        C5818b.m20067a(this.f23114a, (ay) message.obj);
                        return true;
                    case 110:
                        C5818b.m20068a(this.f23114a, (List) message.obj);
                        return true;
                    case 1012:
                        C5880a c5880a = (C5880a) message.obj;
                        if (c5880a.f23596e != null) {
                            ClientProcessingManager clientProcessingManager = this.f23114a.f23131F.f23157b;
                            byte[] bArr = c5880a.f23596e;
                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
                            allocateDirect.put(bArr);
                            allocateDirect.flip();
                            clientProcessingManager.setParameters(allocateDirect);
                            this.f23114a.m20082c();
                        }
                        return true;
                    case C1253f.eY /*1022*/:
                        C5818b c5818b2 = this.f23114a;
                        C5891c c5891c = (C5891c) message.obj;
                        co coVar = c5818b2.f23131F.f23162g;
                        long currentTimeMillis = System.currentTimeMillis();
                        coVar.f23338a = c5891c;
                        if (!(c5891c == null || c5891c.f23627e == null)) {
                            if (c5891c.f23627e.f23622b != null) {
                                coVar.f23339b = cp.m20236a(c5891c.f23627e, currentTimeMillis);
                            } else {
                                coVar.f23339b = null;
                            }
                        }
                        if (!(c5891c == null || c5891c.f23626d == null)) {
                            if (c5891c.f23626d.f23622b != null) {
                                coVar.f23340c = cp.m20236a(c5891c.f23626d, currentTimeMillis);
                            } else {
                                coVar.f23340c = null;
                            }
                        }
                        if (cp.m20240a(c5891c)) {
                            double[] dArr;
                            if (c5891c.f23625b.f23623b.f23577i.length == 0) {
                                dArr = new double[4];
                                dArr = new double[]{1.0d, 0.0d, 0.0d, 0.0d};
                            } else {
                                dArr = c5891c.f23625b.f23623b.f23577i;
                            }
                            double d = 0.0d;
                            double d2 = 0.0d;
                            boolean z = false;
                            if (c5891c.f23625b.f23624d != null) {
                                d = (double) c5891c.f23625b.f23624d.f23630b;
                                d2 = (double) c5891c.f23625b.f23624d.f23631d;
                                z = true;
                            }
                            c5818b2.f23131F.f23157b.addPosition(c5891c.f23625b.f23623b.f23576h, c5891c.f23625b.f23623b.f23571b.f23581b, c5891c.f23625b.f23623b.f23571b.f23582d, (double) c5891c.f23625b.f23623b.f23579k, (double) c5891c.f23625b.f23623b.f23573e, (double) c5891c.f23625b.f23623b.f23578j, dArr, d, d2, z);
                            if (!c5818b2.f23153x) {
                                c5818b2.f23131F.f23172q.m20201b("positioning.first-fix");
                                c5818b2.f23153x = true;
                                if (c5818b2.f23131F.f23158c.f23196g.getBoolean("com.indooratlas.android.sdk.intent.extras.feature_enable_message_buffer", false)) {
                                    bs b = c5818b2.f23131F.f23166k.m20154b();
                                    b.f23245b = 10;
                                    if (b.f23245b <= b.f23246c.size() && !b.f23246c.isEmpty()) {
                                        b.f23244a.mo4630a();
                                    }
                                    c5818b2.f23131F.f23166k.m20152a(true);
                                }
                            }
                        }
                        return true;
                    case 1025:
                        return false;
                }
                return false;
            }

            /* renamed from: e */
            final void mo4625e() {
                this.f23114a.f23131F.f23164i.m20123c();
                this.f23114a.m19886c(104);
            }
        }

        /* renamed from: com.indooratlas.android.sdk._internal.bf$b$i */
        class C5813i extends C5803j {
            /* renamed from: a */
            final /* synthetic */ C5818b f23118a;
            /* renamed from: d */
            private aa<JSONObject> f23119d;
            /* renamed from: e */
            private long f23120e;

            C5813i(C5818b c5818b) {
                this.f23118a = c5818b;
                super(c5818b, 55);
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: d */
            final void mo4623d() {
                /*
                r8 = this;
                r6 = 0;
                r0 = 1;
                r1 = 0;
                r2 = r8.f23118a;
                com.indooratlas.android.sdk._internal.bf.C5818b.m20065a(r2);
                r2 = r8.f23118a;
                r2 = r2.f23131F;
                r2 = r2.f23177v;
                r2.mo4656c();
                r2 = r8.f23118a;
                r2 = r2.f23131F;
                r2 = r2.f23166k;
                r2.f23255g = r1;
                r2.f23255g = r1;
                r2.f23258j = r1;
                r3 = r2.f23257i;
                r4 = r3.mo4654a();
                r2.f23256h = r4;
                r2.f23252d = r1;
                r2.f23251c = r1;
                r2 = new java.lang.Object[r0];
                r3 = r8.f23118a;
                r3 = r3.f23131F;
                r3 = r3.f23173r;
                r3 = r3.f24598g;
                r3 = java.lang.Boolean.valueOf(r3);
                r2[r1] = r3;
                r2 = r8.f23119d;
                if (r2 == 0) goto L_0x0043;
            L_0x003e:
                r2 = r8.f23119d;
                r2.mo4592a();
            L_0x0043:
                r2 = r8.f23118a;
                r2 = r2.f23131F;
                r2 = r2.f23172q;
                r3 = "sdk.initialized";
                r2.m20200a(r3);
                r2 = r8.f23118a;
                r2 = r2.f23131F;
                r2 = r2.f23170o;
                r2 = com.indooratlas.android.sdk._internal.cz.m20279a(r2);
                r2 = r2.m20284a();
                r2 = com.indooratlas.android.sdk._internal.ct.m20262a(r2);
                if (r2 == 0) goto L_0x00d2;
            L_0x0063:
                r3 = r8.f23118a;
                r3 = r3.f23131F;
                r3 = r3.f23169n;
                java.lang.System.currentTimeMillis();
                r4 = r3.f23201a;
                r5 = "sensorInfoFlag";
                r4 = r4.getBoolean(r5, r1);
                if (r4 != 0) goto L_0x009a;
            L_0x0077:
                r4 = r3.f23201a;
                r5 = "sensorInfoSent";
                r4 = r4.getLong(r5, r6);
                r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
                if (r4 == 0) goto L_0x009a;
            L_0x0084:
                r4 = com.indooratlas.android.sdk._internal.bl.m20109a(r2);
                r3 = r3.f23201a;
                r5 = "sensorInfoSha";
                r6 = "";
                r3 = r3.getString(r5, r6);
                r3 = r4.equals(r3);
                if (r3 != 0) goto L_0x00d0;
            L_0x009a:
                r3 = r0;
            L_0x009b:
                if (r3 == 0) goto L_0x00d2;
            L_0x009d:
                r1 = r8.f23118a;
                r1 = r1.f23131F;
                r3 = r1.f23168m;
                r4 = new com.indooratlas.android.sdk._internal.ai;
                r4.<init>();
                r1 = r8.f23118a;
                r1 = r1.f23131F;
                r5 = r1.f23170o;
                r1 = r8.f23118a;
                r1 = r1.f23131F;
                r1 = r1.f23169n;
                r6 = r1.m20110a();
                if (r0 == 0) goto L_0x00d4;
            L_0x00ba:
                r1 = r2;
            L_0x00bb:
                r1 = com.indooratlas.android.sdk._internal.ct.m20261a(r5, r6, r1);
                r1 = r3.mo4597a(r4, r1);
                r8.f23119d = r1;
                r1 = r8.f23119d;
                r3 = new com.indooratlas.android.sdk._internal.bf$b$i$1;
                r3.<init>(r8, r0, r2);
                r1.mo4593a(r3);
                return;
            L_0x00d0:
                r3 = r1;
                goto L_0x009b;
            L_0x00d2:
                r0 = r1;
                goto L_0x009d;
            L_0x00d4:
                r1 = 0;
                goto L_0x00bb;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.indooratlas.android.sdk._internal.bf.b.i.d():void");
            }

            /* renamed from: b */
            final boolean mo4624b(Message message) {
                Object[] objArr;
                switch (message.what) {
                    case 100:
                        this.f23118a.m19881a(this.f23118a.f23142m);
                        return true;
                    case 1004:
                        this.f23120e = 0;
                        this.f23118a.f23131F.f23172q.m20201b("sdk.initialized");
                        JSONObject jSONObject = (JSONObject) message.obj;
                        if (ct.m20257a(jSONObject) != null) {
                            objArr = new Object[]{ct.m20257a(jSONObject), jSONObject};
                            m20052f();
                            break;
                        }
                        Object[] objArr2 = new Object[]{jSONObject, this.f23118a.f23131F.f23169n.m20110a()};
                        this.f23118a.f23131F.f23165j.m19979a(jSONObject);
                        this.f23118a.f23131F.f23176u = this.f23118a.f23131F.f23165j.m19981c();
                        this.f23118a.f23152w = true;
                        this.f23118a.f23131F.f23161f.mo4569a(jSONObject);
                        C5818b.m20070b(this.f23118a);
                        this.f23118a.m19881a(this.f23118a.f23145p);
                        break;
                    case 1005:
                        ad adVar = (ad) message.obj;
                        C5758a c5758a = adVar.f22924a;
                        objArr = new Object[]{c5758a, adVar};
                        this.f23118a.f23131F.f23172q.f23287d.remove("sdk.initialized");
                        if (c5758a != C5758a.CONVERSION) {
                            if (c5758a == C5758a.HTTP) {
                                switch (adVar.f22925b.b()) {
                                    case 401:
                                        this.f23118a.f23131F.f23163h.m20116a(0, 0);
                                        this.f23118a.f23131F.m20090a(bh.m20095a(1001, null, "SDK initializing failed, unauthorized, please check your api keys", new Object[0]));
                                        this.f23118a.f23131F.m20092b();
                                        return true;
                                }
                            } else if (c5758a != C5758a.NETWORK) {
                                C5758a c5758a2 = C5758a.UNEXPECTED;
                            }
                        }
                        this.f23118a.f23131F.f23163h.m20116a(1, (long) Config.BPLUS_DELAY_TIME);
                        m20052f();
                        break;
                }
                return false;
            }

            /* renamed from: e */
            final void mo4625e() {
                if (this.f23119d != null) {
                    this.f23119d.mo4592a();
                }
            }

            /* renamed from: f */
            private void m20052f() {
                long j = this.f23120e;
                if (j == 0) {
                    j = 1000;
                } else {
                    j = Math.min(HttpsClient.CONN_MGR_TIMEOUT, j * 2);
                }
                this.f23120e = j;
                new Object[1][0] = Long.valueOf(this.f23120e);
                this.f23118a.m19880a(100, this.f23120e);
            }
        }

        /* renamed from: com.indooratlas.android.sdk._internal.bf$b$k */
        class C5814k extends C5803j {
            /* renamed from: a */
            final /* synthetic */ C5818b f23121a;

            C5814k(C5818b c5818b) {
                this.f23121a = c5818b;
                super(c5818b, 65);
            }

            /* renamed from: b */
            public final boolean mo4624b(Message message) {
                switch (message.what) {
                    case 1003:
                        if (!C5818b.m20069a(this.f23121a, message.arg1, (String) message.obj)) {
                            this.f23121a.f23131F.f23163h.m20116a(1, (long) Config.BPLUS_DELAY_TIME);
                            this.f23121a.m19881a(this.f23121a.f23145p);
                        }
                        return true;
                    case 1017:
                        byte[] bArr = (byte[]) message.obj;
                        bt btVar = this.f23121a.f23131F.f23166k;
                        C6001m e = btVar.m20157e();
                        C5883a c5883a = new C5883a();
                        c5883a.f23605d = bArr;
                        c5883a.f23604b = btVar.f23257i.mo4654a();
                        e.f23614i = new C5883a[]{c5883a};
                        btVar.m20147a(2, e);
                        return true;
                    default:
                        return false;
                }
            }

            /* renamed from: e */
            final void mo4625e() {
                C5818b.m20065a(this.f23121a);
            }
        }

        /* renamed from: com.indooratlas.android.sdk._internal.bf$b$l */
        class C5815l extends C5803j {
            /* renamed from: a */
            final /* synthetic */ C5818b f23122a;
            /* renamed from: d */
            private long f23123d;

            C5815l(C5818b c5818b) {
                this.f23122a = c5818b;
                super(c5818b, 60);
            }

            /* renamed from: d */
            final void mo4623d() {
                new Object[1][0] = Boolean.valueOf(this.f23122a.f23131F.f23173r.f24598g);
                this.f23122a.f23131F.f23172q.m20200a("positioning.websocket.connected");
                this.f23122a.m20081b().mo4641a();
            }

            /* renamed from: b */
            public final boolean mo4624b(Message message) {
                switch (message.what) {
                    case 100:
                        this.f23122a.m19881a(this.f23122a.f23142m);
                        return true;
                    case 1002:
                        this.f23122a.f23131F.f23163h.m20116a(this.f23122a.f23131F.f23173r.a(), 0);
                        this.f23123d = 0;
                        if (this.f23122a.f23154y) {
                            this.f23122a.m19881a(this.f23122a.f23149t);
                        } else {
                            this.f23122a.m19881a(this.f23122a.f23147r);
                        }
                        return true;
                    case 1003:
                        boolean a = C5818b.m20069a(this.f23122a, message.arg1, (String) message.obj);
                        if (!a) {
                            this.f23122a.f23131F.f23163h.m20116a(1, (long) Config.BPLUS_DELAY_TIME);
                            this.f23123d = Math.min(HttpsClient.CONN_MGR_TIMEOUT, this.f23123d == 0 ? 500 : this.f23123d * 2);
                            Object[] objArr = new Object[]{r0, Integer.valueOf(r5), Long.valueOf(this.f23123d)};
                            this.f23122a.m19880a(100, this.f23123d);
                        }
                        return a;
                    default:
                        return false;
                }
            }

            /* renamed from: e */
            final void mo4625e() {
                this.f23122a.m19886c(100);
            }
        }

        /* renamed from: com.indooratlas.android.sdk._internal.bf$b$m */
        class C5816m extends C5803j {
            /* renamed from: a */
            final /* synthetic */ C5818b f23124a;

            C5816m(C5818b c5818b) {
                this.f23124a = c5818b;
                super(c5818b, 15);
            }

            /* renamed from: b */
            public final boolean mo4624b(Message message) {
                switch (message.what) {
                    case 1:
                        if (this.f23124a.f23151v) {
                            this.f23124a.m19881a(this.f23124a.f23142m);
                        } else {
                            this.f23124a.m19881a(this.f23124a.f23138i);
                        }
                        return true;
                    default:
                        return false;
                }
            }
        }

        /* renamed from: com.indooratlas.android.sdk._internal.bf$b$n */
        class C5817n extends C5803j {
            /* renamed from: a */
            final /* synthetic */ C5818b f23125a;

            C5817n(C5818b c5818b) {
                this.f23125a = c5818b;
                super(c5818b, 40);
            }

            /* renamed from: d */
            final void mo4623d() {
                int i = 1;
                this.f23125a.f23131F.f23163h.m20116a(1, (long) Config.BPLUS_DELAY_TIME);
                NetworkInfo activeNetworkInfo = this.f23125a.f23131F.f23174s.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                    i = 0;
                }
                if (i != 0) {
                    m20062f();
                }
            }

            /* renamed from: b */
            public final boolean mo4624b(Message message) {
                switch (message.what) {
                    case 1019:
                        m20062f();
                        break;
                }
                return false;
            }

            /* renamed from: f */
            private void m20062f() {
                bm bmVar = this.f23125a.f23131F.f23163h;
                bmVar.f23208c.removeMessages(1);
                synchronized (bmVar.f23206a) {
                    bmVar.f23206a.remove(1);
                }
                if (this.f23125a.f23152w) {
                    this.f23125a.m19881a(this.f23125a.f23145p);
                } else {
                    this.f23125a.m19881a(this.f23125a.f23144o);
                }
            }
        }

        /* renamed from: a */
        static /* synthetic */ void m20065a(C5818b c5818b) {
            bx bxVar = c5818b.f23131F.f23167l;
            if (bxVar != null) {
                bxVar.mo4644b();
                bxVar.mo4642a(null);
            }
            c5818b.f23131F.f23167l = null;
        }

        /* renamed from: b */
        static /* synthetic */ void m20070b(C5818b c5818b) {
            Object obj = c5818b.f23131F.f23176u;
            if (c5818b.f23131F.f23173r.f24598g && !TextUtils.isEmpty(obj)) {
                AsyncTask c58441 = new C58441(c5818b.f23131F.f23175t, c5818b.f23131F.f23168m, obj);
                try {
                    if (VERSION.SDK_INT >= 11) {
                        c58441.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                    } else {
                        c58441.execute(new Object[0]);
                    }
                } catch (Throwable e) {
                    ee.m20410a("IACore", e, "events upload task was rejected", new Object[0]);
                }
            }
            c5818b.m19886c(104);
            c5818b.m19880a(104, (long) HttpsClient.CONN_MGR_TIMEOUT);
        }

        /* renamed from: c */
        static /* synthetic */ void m20071c(C5818b c5818b) {
            if (!c5818b.f23154y) {
                c5818b.f23131F.f23164i.m20119a();
                c5818b.f23154y = true;
                c5818b.f23131F.f23172q.m20201b("sdk.positioning-started");
                Bundle bundle = new Bundle(1);
                bundle.putLong("com.indooratlas.android.sdk.intent.extras.clientTime", c5818b.f23131F.f23177v.mo4654a());
                bundle.putString("com.indooratlas.android.sdk.intent.extras.clientID", c5818b.f23131F.f23169n.m20110a());
                c5818b.f23131F.f23161f.mo4563a(bundle);
            }
        }

        /* renamed from: d */
        static /* synthetic */ void m20073d(C5818b c5818b) {
            ga gaVar = null;
            if (c5818b.f23154y) {
                c5818b.f23131F.f23164i.m20122b();
                Bundle bundle = new Bundle(1);
                bundle.putLong("com.indooratlas.android.sdk.intent.extras.clientTime", c5818b.f23131F.f23177v.mo4654a());
                bundle.putString("com.indooratlas.android.sdk.intent.extras.clientID", c5818b.f23131F.f23169n.m20110a());
                c5818b.f23131F.f23161f.mo4570b(bundle);
                c5818b.f23154y = false;
                c5818b.f23136g = false;
                c5818b.f23133d = null;
                c5818b.f23135f = null;
                c5818b.f23153x = false;
                c5818b.f23126A = null;
                co coVar = c5818b.f23131F.f23162g;
                coVar.f23338a = null;
                coVar.f23339b = null;
                coVar.f23340c = null;
                coVar.f23341d = null;
                coVar.f23342e = null;
                if (c5818b.f23131F.f23158c.f23196g.getBoolean("com.indooratlas.android.sdk.intent.extras.feature_enable_message_buffer", false)) {
                    c5818b.f23131F.f23166k.m20152a(false);
                }
                if (c5818b.f23129D != null) {
                    bq bqVar = c5818b.f23129D;
                    bqVar.m20132b();
                    bqVar.f23238f = null;
                    if (bqVar.f23233a != null) {
                        gaVar = bqVar.f23233a.m20682a();
                    }
                    if (gaVar != null) {
                        gaVar.m20602a();
                    }
                }
            }
        }

        /* renamed from: h */
        static /* synthetic */ void m20077h(C5818b c5818b) {
            long f = c5818b.f23131F.f23164i.m20126f();
            if (f <= 0) {
                f = 0;
            }
            c5818b.m19886c(108);
            c5818b.m19880a(108, f);
        }

        private C5818b(bf bfVar, Looper looper) {
            this.f23131F = bfVar;
            super("IASdkEngineMain", looper);
            this.f23137h = true;
            this.f23138i = new C5804a(this);
            this.f23139j = new C5816m(this);
            this.f23140k = new C5811h(this);
            this.f23141l = new C5806c(this);
            this.f23142m = new C5817n(this);
            this.f23143n = new C5805b(this);
            this.f23144o = new C5813i(this);
            this.f23145p = new C5815l(this);
            this.f23146q = new C5814k(this);
            this.f23147r = new C5810g(this);
            this.f23148s = new C5809f(this);
            this.f23149t = new C5807d(this);
            this.f23150u = new C5808e(this);
            this.f23127B = new IAOrientationRequest(-1.0d, -1.0d);
            this.f23128C = new C57921(this);
            this.f23130E = new C57952(this);
            m20072d();
        }

        private C5818b(bf bfVar) {
            this.f23131F = bfVar;
            super("IASdkEngineMain");
            this.f23137h = true;
            this.f23138i = new C5804a(this);
            this.f23139j = new C5816m(this);
            this.f23140k = new C5811h(this);
            this.f23141l = new C5806c(this);
            this.f23142m = new C5817n(this);
            this.f23143n = new C5805b(this);
            this.f23144o = new C5813i(this);
            this.f23145p = new C5815l(this);
            this.f23146q = new C5814k(this);
            this.f23147r = new C5810g(this);
            this.f23148s = new C5809f(this);
            this.f23149t = new C5807d(this);
            this.f23150u = new C5808e(this);
            this.f23127B = new IAOrientationRequest(-1.0d, -1.0d);
            this.f23128C = new C57921(this);
            this.f23130E = new C57952(this);
            m20072d();
        }

        /* renamed from: d */
        final String m20083d(int i) {
            for (Field field : getClass().getDeclaredFields()) {
                if (field.getGenericType() == Integer.TYPE) {
                    try {
                        if (field.getInt(this) == i) {
                            return field.getName();
                        }
                    } catch (IllegalAccessException e) {
                    }
                }
            }
            return "unknown message: " + i;
        }

        /* renamed from: d */
        private void m20072d() {
            m19882a(this.f23138i);
            m19882a(this.f23139j);
            m19882a(this.f23140k);
            m19883a(this.f23141l, this.f23140k);
            m19883a(this.f23143n, this.f23140k);
            m19883a(this.f23142m, this.f23140k);
            m19883a(this.f23144o, this.f23143n);
            m19883a(this.f23145p, this.f23143n);
            m19883a(this.f23146q, this.f23143n);
            m19883a(this.f23147r, this.f23146q);
            m19883a(this.f23148s, this.f23146q);
            m19883a(this.f23149t, this.f23148s);
            m19883a(this.f23150u, this.f23148s);
            C5774c.m19869a(this.f23023b, this.f23139j);
        }

        /* renamed from: b */
        final bx m20081b() {
            if (this.f23131F.f23167l == null || this.f23131F.f23167l.mo4645c()) {
                Object a = this.f23131F.f23165j.m19978a();
                String str = this.f23131F.f23158c.f23193d;
                int i = this.f23131F.f23158c.f23194e;
                try {
                    this.f23131F.f23167l = bk.m20101a(this.f23131F, new URI(a), str, i);
                    this.f23131F.f23166k.m20149a(this.f23131F.f23167l);
                    return this.f23131F.f23167l;
                } catch (URISyntaxException e) {
                    bf.m20084a(this.f23131F, bh.m20095a(1002, null, "bad positioning endpoint: %s", a));
                } catch (Throwable e2) {
                    bf.m20084a(this.f23131F, bh.m20095a(1001, e2, "unexpected error while creating positioning client: %s", e2));
                }
            }
            return this.f23131F.f23167l;
            this.f23131F.f23166k.m20149a(new bw());
            return this.f23131F.f23167l;
        }

        /* renamed from: c */
        final void m20082c() {
            boolean z = false;
            if (this.f23126A != null) {
                boolean z2 = this.f23126A.getFastestInterval() != -1;
                if (this.f23126A.getSmallestDisplacement() != -1.0f) {
                    z = true;
                }
                double smallestDisplacement = (double) this.f23126A.getSmallestDisplacement();
                double fastestInterval = z2 ? ((double) this.f23126A.getFastestInterval()) / 1000.0d : -1.0d;
                if (z || z2) {
                    this.f23131F.f23157b.configurePredictor(z, smallestDisplacement, z2, fastestInterval);
                }
                this.f23131F.f23157b.configurePredictorHeading(this.f23127B.getHeadingSensitivity());
                this.f23131F.f23157b.configurePredictorOrientation(this.f23127B.getOrientationSensitivity());
            }
        }

        /* renamed from: a */
        final void m20079a(IALocation iALocation) {
            eg.m20413a((Object) iALocation, "location must be non-null", new Object[0]);
            this.f23133d = iALocation;
        }

        /* renamed from: a */
        protected final void mo4628a() {
            if (this.f23131F.f23163h != null) {
                bm bmVar = this.f23131F.f23163h;
                bmVar.f23208c.removeCallbacksAndMessages(null);
                synchronized (bmVar.f23206a) {
                    bmVar.f23206a.clear();
                }
            }
            if (this.f23131F.f23172q != null) {
                ca caVar = this.f23131F.f23172q;
                if (!caVar.f23289f) {
                    caVar.f23290g = new CountDownLatch(1);
                    caVar.f23289f = true;
                    if (caVar.f23288e != null) {
                        caVar.f23288e.interrupt();
                    }
                    caVar.f23284a = null;
                    try {
                        caVar.f23290g.await();
                    } catch (Throwable e) {
                        ee.m20410a("IACore", e, "interrupted while waiting writer thread to close", new Object[0]);
                    }
                }
            }
            if (this.f23131F.f23173r != null) {
                DeviceWatchdog deviceWatchdog = this.f23131F.f23173r;
                deviceWatchdog.f24601j.f23170o.unregisterReceiver(deviceWatchdog.f24592a);
            }
            this.f23131F.f23175t.close();
        }

        /* renamed from: a */
        final void m20080a(boolean z) {
            if (!this.f23136g || z) {
                bt btVar = this.f23131F.f23166k;
                C6001m c5893a = new C5893a();
                c5893a.f23633d = btVar.f23251c;
                int i = btVar.f23252d;
                btVar.f23252d = i + 1;
                c5893a.f23632b = i;
                btVar.m20147a(1, c5893a);
                this.f23136g = true;
            }
        }

        /* renamed from: a */
        static /* synthetic */ void m20067a(C5818b c5818b, ay ayVar) {
            cc ccVar = c5818b.f23131F.f23180y;
            long a = c5818b.f23131F.f23177v.mo4654a();
            List<aw> a2 = ayVar.m19894a();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            IALocation iALocation = ccVar.f23294b;
            for (aw awVar : a2) {
                ccVar.m20204a(awVar.mo4647a());
                ccVar.f23293a.f23524a.m20426a(awVar.mo4647a(), ((cd) awVar).f23298a, new C5834a(a, awVar));
                if (iALocation != null) {
                    if (awVar.mo4648a(iALocation.getLatitude(), iALocation.getLongitude(), iALocation.hasFloorLevel() ? Integer.valueOf(iALocation.getFloorLevel()) : null)) {
                        arrayList.add(awVar);
                    } else {
                        arrayList2.add(awVar);
                    }
                }
            }
            if (arrayList.size() > 0) {
                arrayList3.add(new ax(arrayList, 1, iALocation));
            }
            if (arrayList2.size() > 0) {
                arrayList3.add(new ax(arrayList2, 16, iALocation));
            }
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                ax axVar = (ax) it.next();
                if (ayVar.f23028a == 1 && axVar.f23025a == 1) {
                    c5818b.f23131F.f23161f.mo4565a(axVar);
                } else if (ayVar.f23028a == 16 && axVar.f23025a == 16) {
                    c5818b.f23131F.f23161f.mo4565a(axVar);
                }
            }
        }

        /* renamed from: a */
        static /* synthetic */ void m20068a(C5818b c5818b, List list) {
            for (Object next : list) {
                if (next instanceof String) {
                    c5818b.f23131F.f23180y.m20204a((String) next);
                }
            }
        }

        /* renamed from: a */
        static /* synthetic */ boolean m20069a(C5818b c5818b, int i, String str) {
            if ((i != m_AppUI.MSG_APP_SAVESCREEN || !"init_required".equals(str)) && !"invalid_key".equals(str)) {
                return false;
            }
            if ("invalid_key".equals(str)) {
                String str2 = "IASDK";
                ee.m20409a(str2, "IndoorAtlas service unavailable: %s", str);
            }
            if (i == m_AppUI.MSG_APP_SAVESCREEN) {
                c5818b.f23131F.f23169n.f23202b.putBoolean("sensorInfoFlag", true);
            }
            c5818b.f23152w = false;
            c5818b.f23136g = false;
            c5818b.m19881a(c5818b.f23144o);
            return true;
        }

        /* renamed from: e */
        static /* synthetic */ void m20074e(C5818b c5818b) {
            c5818b.f23132G = true;
            c5818b.f23131F.f23164i.m20124d();
        }

        /* renamed from: a */
        static /* synthetic */ void m20066a(C5818b c5818b, Message message) {
            if (message.obj == null) {
                return;
            }
            if (message.obj instanceof IALocation) {
                c5818b.m20079a((IALocation) message.obj);
                return;
            }
            throw new IllegalArgumentException("obj is not IALocation but " + message.obj);
        }

        /* renamed from: f */
        static /* synthetic */ void m20075f(C5818b c5818b) {
            c5818b.f23132G = false;
            c5818b.f23131F.f23164i.m20125e();
        }

        /* renamed from: g */
        static /* synthetic */ void m20076g(C5818b c5818b) {
            if (c5818b.f23133d != null) {
                c5818b.f23131F.f23166k.m20153a(c5818b.f23133d);
                c5818b.f23135f = c5818b.f23133d;
                c5818b.f23133d = null;
            }
        }
    }

    private bf(C5790a c5790a) {
        bk bkVar;
        cc ccVar;
        this.f23170o = c5790a.f23086a.getApplicationContext();
        this.f23161f = c5790a.f23088c;
        this.f23162g = new co(this.f23161f);
        if (c5790a.f23089d != null) {
            bkVar = c5790a.f23089d;
        } else {
            bkVar = new bk();
        }
        this.f23181z = bkVar;
        this.f23177v = bk.m20104b();
        if (c5790a.f23091f != null) {
            ccVar = c5790a.f23091f;
        } else {
            ccVar = new cc();
        }
        this.f23180y = ccVar;
        try {
            this.f23158c = c5790a.f23090e.m20094a();
            m20087e();
            Log.d("IACore", m20088f());
            this.f23175t = bk.m20107e(this);
            if (c5790a.f23087b != null) {
                this.f23156a = new C5818b(c5790a.f23087b);
            } else {
                this.f23156a = new C5818b();
            }
            C5774c.m19873c(this.f23156a.f23023b);
        } catch (Throwable e) {
            this.f23158c = null;
            this.f23159d = e;
            m20090a(bh.m20095a(1002, e, e.getMessage(), new Object[0]));
        }
    }

    /* renamed from: a */
    public final void m20089a() {
        if (m20093c()) {
            this.f23156a.m19876a(2).sendToTarget();
        }
    }

    /* renamed from: b */
    public final void m20092b() {
        if (m20093c()) {
            m20089a();
            this.f23171p = true;
            this.f23156a.m19876a(3).sendToTarget();
        }
    }

    /* renamed from: a */
    public final void m20091a(br brVar, boolean z) {
        if (m20093c()) {
            this.f23156a.m19877a(107, z ? 0 : 1, -1, brVar);
        }
    }

    /* renamed from: c */
    public final boolean m20093c() {
        return this.f23159d == null && !this.f23171p;
    }

    /* renamed from: d */
    static boolean m20086d() {
        return VERSION.SDK_INT >= 18;
    }

    /* renamed from: e */
    private void m20087e() throws bc {
        try {
            ct.m20255a("", "");
            String[] strArr = new String[]{"android.permission.ACCESS_NETWORK_STATE", "android.permission.INTERNET", "android.permission.CHANGE_WIFI_STATE", "android.permission.ACCESS_WIFI_STATE"};
            for (int i = 0; i < 4; i++) {
                String str = strArr[i];
                if (this.f23170o.checkCallingOrSelfPermission(str) != 0) {
                    throw new bc("permission missing: " + str);
                }
            }
            ArrayList a = ct.m20260a(this.f23170o, "android.hardware.wifi");
            if (!a.isEmpty()) {
                throw new bc("missing mandatory feature: " + ((String) a.get(0)));
            } else if (m20086d() && ct.m20269b(this.f23170o) && !ct.m20265a(this.f23170o)) {
                ee.m20409a("IASDK", "Permissions for Bluetooth scan missing. Add BLUETOOTH, BLUETOOTH_ADMIN, and ACCESS_FINE_LOCATION or ACCESS_COARSE_LOCATION permissions to enable BLE scanning", new Object[0]);
            }
        } catch (IllegalStateException e) {
            throw new bc(e.toString());
        }
    }

    /* renamed from: a */
    final void m20090a(bh bhVar) {
        ee.m20409a("IASDK", "ERROR: " + bhVar.f23197a + ", " + bhVar.f23198b, new Object[0]);
        this.f23161f.mo4566a(bhVar);
    }

    /* renamed from: f */
    private static String m20088f() {
        PrintWriter printWriter = new PrintWriter(new StringWriter());
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(new SimpleTimeZone(2, "UTC"));
            printWriter.println("IndoorAtlas Android SDK");
            printWriter.println(" SDK    : 2.4.2-743");
            printWriter.println(" Android: " + VERSION.RELEASE + "-" + VERSION.SDK_INT);
            printWriter.println(" Date   : " + simpleDateFormat.format(new Date()));
            printWriter.close();
            return printWriter.toString();
        } catch (IOException e) {
            return null;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m20084a(bf bfVar, bh bhVar) {
        bfVar.m20090a(bhVar);
        C5774c.m19871b(bfVar.f23156a.f23023b);
    }
}
