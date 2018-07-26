package com.indooratlas.android.sdk._internal;

import android.support.annotation.NonNull;
import com.indooratlas.android.sdk._internal.gk.C5925a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class bq {
    /* renamed from: a */
    public gh f23233a;
    /* renamed from: b */
    public String f23234b;
    /* renamed from: c */
    public final List<C5826c> f23235c;
    /* renamed from: d */
    AtomicBoolean f23236d;
    /* renamed from: e */
    public C5793b f23237e;
    /* renamed from: f */
    public String f23238f;
    /* renamed from: g */
    private final gg f23239g;
    /* renamed from: h */
    private String f23240h;
    /* renamed from: i */
    private final fs f23241i;

    /* renamed from: com.indooratlas.android.sdk._internal.bq$b */
    public interface C5793b {
    }

    /* renamed from: com.indooratlas.android.sdk._internal.bq$1 */
    class C58241 implements fs {
        /* renamed from: a */
        final /* synthetic */ bq f23223a;

        C58241(bq bqVar) {
            this.f23223a = bqVar;
        }

        /* renamed from: a */
        public final void mo4590a(fr frVar, IOException iOException) {
            ee.m20409a("IACore", "Failed to send: ", iOException);
            this.f23223a.f23236d.set(false);
        }

        /* renamed from: a */
        public final void mo4591a(gm gmVar) throws IOException {
            if (gmVar.m20731c()) {
                new StringBuilder("Sent to: ").append(gmVar.m20728a().m20709a()).append("\n\t").append(gmVar.m20728a().m20710a("Authorization")).append("\n\t").append(gmVar.m20728a().m20710a("Content-Range"));
                synchronized (this.f23223a.f23235c) {
                    if (!this.f23223a.f23235c.isEmpty()) {
                        this.f23223a.f23235c.remove(0);
                    }
                }
                this.f23223a.f23236d.set(false);
                this.f23223a.m20131a();
                return;
            }
            new StringBuilder("Failed to send, statusCode: ").append(gmVar.m20730b()).append(", message: ").append(gmVar.m20732d());
            this.f23223a.f23236d.set(false);
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.bq$a */
    public static class C5825a {
        /* renamed from: a */
        public String f23224a;
        /* renamed from: b */
        public C5793b f23225b;
        /* renamed from: c */
        public gh f23226c;
        /* renamed from: d */
        public String f23227d;
    }

    /* renamed from: com.indooratlas.android.sdk._internal.bq$c */
    public class C5826c {
        /* renamed from: a */
        final byte[] f23228a;
        /* renamed from: b */
        final long f23229b;
        /* renamed from: c */
        final long f23230c;
        /* renamed from: d */
        public final String f23231d;
        /* renamed from: e */
        final /* synthetic */ bq f23232e;

        public C5826c(bq bqVar, byte[] bArr, long j, long j2, String str) {
            this.f23232e = bqVar;
            this.f23228a = bArr;
            this.f23229b = j;
            this.f23230c = j2;
            this.f23231d = str;
        }
    }

    private bq(@NonNull String str) {
        this.f23235c = new ArrayList();
        this.f23236d = new AtomicBoolean(false);
        this.f23241i = new C58241(this);
        this.f23240h = str + "/cpa-binlogs/v1/";
        this.f23239g = gg.m20657a("application/x-protobuf");
    }

    /* renamed from: a */
    public final void m20131a() {
        if (!this.f23236d.get()) {
            synchronized (this.f23235c) {
                if (!this.f23235c.isEmpty()) {
                    C5826c c5826c = (C5826c) this.f23235c.get(0);
                    if (this.f23233a != null) {
                        this.f23236d.set(true);
                        Object obj = "events " + c5826c.f23229b + "-" + c5826c.f23230c;
                        this.f23233a.m20681a(new C5925a().m20702a(this.f23240h + c5826c.f23231d).m20700a(gl.m19807a(this.f23239g, c5826c.f23228a)).m20708b("Content-Type", "application/x-protobuf").m20708b("Authorization", "IDA-Key " + this.f23234b).m20708b("Content-Range", obj).m20708b("Content-Length", String.valueOf(c5826c.f23228a.length)).m20701a(obj).m20706a()).mo4694a(this.f23241i);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public final void m20132b() {
        synchronized (this.f23235c) {
            this.f23235c.clear();
        }
    }
}
