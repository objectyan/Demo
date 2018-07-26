package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk._internal.br.C5827a;
import com.indooratlas.android.sdk._internal.bs.C5828a;
import com.indooratlas.android.sdk._internal.bx.C5829a;
import com.indooratlas.android.sdk._internal.el.C5868a;
import com.indooratlas.android.sdk._internal.eu.C5874c;
import com.indooratlas.android.sdk._internal.ez.C5880a;
import com.indooratlas.android.sdk._internal.fa.C5882a;
import com.indooratlas.android.sdk._internal.fb.C5884b;
import com.indooratlas.android.sdk._internal.fb.C5885c;
import com.indooratlas.android.sdk._internal.fc.C5891c;
import com.indooratlas.android.sdk._internal.fg.C5907e;
import com.indooratlas.android.sdk._internal.fm.C5908a;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.Map.Entry;

public final class bt implements C5828a, C5829a {
    /* renamed from: a */
    public static final boolean f23248a = false;
    /* renamed from: b */
    public static final C6003o f23249b = new C6003o();
    /* renamed from: m */
    private static final boolean f23250m = false;
    /* renamed from: c */
    public int f23251c;
    /* renamed from: d */
    public int f23252d = 0;
    /* renamed from: e */
    public long f23253e;
    /* renamed from: f */
    public long f23254f;
    /* renamed from: g */
    public int f23255g;
    /* renamed from: h */
    public long f23256h;
    /* renamed from: i */
    public cr f23257i;
    /* renamed from: j */
    public int f23258j = 0;
    /* renamed from: k */
    public C5827a f23259k;
    /* renamed from: l */
    public C5827a f23260l;
    /* renamed from: n */
    private bx f23261n;
    /* renamed from: o */
    private C5791a f23262o;
    /* renamed from: p */
    private int f23263p;
    /* renamed from: q */
    private bs f23264q;

    /* renamed from: com.indooratlas.android.sdk._internal.bt$a */
    public static abstract class C5791a {
        /* renamed from: a */
        public abstract void mo4608a(int i, String str, boolean z);

        /* renamed from: a */
        public abstract void mo4609a(long j);

        /* renamed from: a */
        public abstract void mo4610a(C5874c c5874c);

        /* renamed from: a */
        public abstract void mo4612a(C5882a c5882a);

        /* renamed from: a */
        public abstract void mo4613a(C5891c c5891c);

        /* renamed from: b */
        public abstract void mo4614b();

        /* renamed from: a */
        public void mo4607a() {
        }

        /* renamed from: a */
        public void mo4611a(C5880a c5880a) {
            if (c5880a.f23595d != null && c5880a.f23595d.f24569b != null) {
                for (Entry entry : c5880a.f23595d.f24569b.entrySet()) {
                    String str;
                    Object[] objArr = new Object[2];
                    objArr[0] = entry.getKey();
                    C6006r c6006r = (C6006r) entry.getValue();
                    if (c6006r.f24574b == 3) {
                        str = (String) c6006r.f24575d;
                    } else {
                        str = "";
                    }
                    objArr[1] = str;
                }
            }
        }
    }

    public bt(cr crVar, C5791a c5791a) {
        this.f23262o = c5791a;
        this.f23257i = crVar;
        this.f23256h = this.f23257i.mo4654a();
    }

    /* renamed from: b */
    public final bs m20154b() {
        if (this.f23264q == null) {
            this.f23264q = new bs(this);
        }
        return this.f23264q;
    }

    /* renamed from: a */
    public final void m20149a(bx bxVar) {
        this.f23261n = bxVar;
        this.f23261n.mo4642a((C5829a) this);
    }

    /* renamed from: a */
    public final void m20152a(boolean z) {
        bs b = m20154b();
        b.f23247d = z;
        if (!b.f23247d && !b.f23246c.isEmpty()) {
            b.f23244a.mo4630a();
        }
    }

    /* renamed from: b */
    private void m20144b(C5868a c5868a) {
        try {
            if (this.f23259k != null) {
                this.f23259k.m20133a();
            }
            this.f23261n.mo4643a(C6001m.a(c5868a));
            this.f23263p++;
        } catch (Throwable th) {
            ee.m20410a("IAWire", th, "error sending, message lost", new Object[0]);
        }
    }

    /* renamed from: a */
    public final void m20153a(IALocation... iALocationArr) {
        if (iALocationArr != null && iALocationArr.length != 0) {
            try {
                C6001m e = m20157e();
                C5884b c5884b = new C5884b();
                IALocation iALocation = iALocationArr[0];
                if (iALocation.getRegion() != null) {
                    c5884b.f23607d = cp.m20237a(iALocation.getRegion());
                }
                c5884b.f23606b = cp.m20241a(iALocationArr);
                e.f23609d = c5884b;
                new Object[1][0] = e;
                m20147a(2, e);
            } catch (Throwable th) {
                new Object[1][0] = th;
            }
        }
    }

    /* renamed from: c */
    public final void mo4635c() {
        this.f23262o.mo4614b();
    }

    /* renamed from: a */
    public final void mo4632a(int i, String str, boolean z) {
        Object[] objArr = new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)};
        this.f23262o.mo4608a(i, str, z);
    }

    /* renamed from: d */
    public final void mo4636d() {
        this.f23262o.mo4607a();
    }

    /* renamed from: a */
    public final void mo4631a(int i) {
        this.f23262o.mo4609a((long) i);
    }

    /* renamed from: a */
    public final void mo4634a(ByteBuffer byteBuffer) {
        this.f23255g++;
        try {
            byte[] array = byteBuffer.array();
            C5868a c5868a = (C5868a) C6001m.a(new C5868a(), array, array.length);
            if (this.f23260l != null) {
                this.f23260l.m20133a();
            }
            int i = c5868a.f23515b;
            int i2 = c5868a.f23516d;
            Object[] objArr = new Object[]{cp.m20238a(i), cp.m20239a(i, i2), Integer.valueOf(byteBuffer.capacity())};
            switch (i) {
                case 1:
                    switch (i2) {
                        case 4:
                            array = c5868a.f23517e;
                            C5880a c5880a = (C5880a) C6001m.a(new C5880a(), array, array.length);
                            this.f23251c = c5880a.f23594b;
                            this.f23262o.mo4611a(c5880a);
                            return;
                        case 5:
                            array = c5868a.f23517e;
                            this.f23262o.mo4613a((C5891c) C6001m.a(new C5891c(), array, array.length));
                            return;
                        case 6:
                            array = c5868a.f23517e;
                            this.f23262o.mo4612a((C5882a) C6001m.a(new C5882a(), array, array.length));
                            return;
                        case 11:
                            array = c5868a.f23517e;
                            this.f23262o.mo4610a((C5874c) C6001m.a(new C5874c(), array, array.length));
                            return;
                        default:
                            return;
                    }
                case 2:
                case 4:
                    return;
                case 3:
                    switch (i2) {
                        case 1:
                            array = c5868a.f23517e;
                            C6001m.a(new C5908a(), array, array.length);
                            return;
                        default:
                            return;
                    }
                default:
                    ee.m20409a("IAWire", "unhandled message, component: %d, type: %d", Integer.valueOf(i), Integer.valueOf(i2));
                    return;
            }
        } catch (Throwable e) {
            ee.m20410a("IAWire", e, "parsing message failed", new Object[0]);
        }
        ee.m20410a("IAWire", e, "parsing message failed", new Object[0]);
    }

    /* renamed from: e */
    public final C5885c m20157e() {
        C5885c c5885c = new C5885c();
        int i = this.f23258j;
        this.f23258j = i + 1;
        c5885c.f23615j = i;
        c5885c.f23608b = this.f23251c;
        return c5885c;
    }

    /* renamed from: a */
    public static long m20142a(long j, long j2) {
        if (j > 0 && j > j2) {
            ee.m20409a("IAWire", String.format(Locale.US, "trackNode clientTime traveling backwards, lastSeen: %d, current: %d", new Object[]{Long.valueOf(j), Long.valueOf(j2)}), new Object[0]);
        }
        return j2;
    }

    /* renamed from: a */
    public static C5907e m20143a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (C5907e) C6001m.a(new C5907e(), bArr, bArr.length);
        } catch (C5987j e) {
            return null;
        }
    }

    /* renamed from: a */
    public final void mo4633a(C5868a c5868a) {
        m20144b(c5868a);
    }

    /* renamed from: a */
    public final void m20147a(int i, C6001m c6001m) {
        C5868a c5868a = new C5868a();
        c5868a.f23515b = 1;
        c5868a.f23516d = i;
        c5868a.f23517e = C6001m.a(c6001m);
        if (ee.m20411a("IAWire", 2)) {
            double a = ((double) (this.f23257i.mo4654a() - this.f23256h)) / 1000.0d;
            Object[] objArr = new Object[]{cp.m20238a(c5868a.f23515b), cp.m20239a(c5868a.f23515b, c5868a.f23516d), Integer.valueOf(c5868a.f23517e.length), Integer.valueOf(this.f23251c), Integer.valueOf(this.f23252d), Integer.valueOf(this.f23258j), Integer.valueOf(this.f23263p), Double.valueOf(((double) this.f23263p) / a), Integer.valueOf(this.f23255g), Double.valueOf(((double) this.f23255g) / a)};
        }
        bs b = m20154b();
        if (!b.f23247d || b.f23245b <= 0) {
            Object[] objArr2 = new Object[]{Boolean.valueOf(b.f23247d), cp.m20238a(c5868a.f23515b), cp.m20239a(c5868a.f23515b, c5868a.f23516d)};
            b.f23244a.mo4633a(c5868a);
            return;
        }
        objArr2 = new Object[]{Integer.valueOf(b.f23246c.size()), Integer.valueOf(b.f23245b)};
        b.f23246c.add(c5868a);
        if (b.f23246c.size() > b.f23245b) {
            b.f23244a.mo4630a();
            if (!b.f23246c.isEmpty()) {
                b.f23246c.remove(0);
            }
        }
    }

    /* renamed from: a */
    public final void mo4630a() {
        m20154b();
        for (C5868a b : this.f23264q.f23246c) {
            m20144b(b);
        }
        this.f23264q.f23246c.clear();
    }
}
