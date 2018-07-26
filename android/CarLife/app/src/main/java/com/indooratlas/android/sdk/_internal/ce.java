package com.indooratlas.android.sdk._internal;

import android.os.ParcelUuid;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.media.session.PlaybackStateCompat;
import com.indooratlas.android.sdk._internal.eu.C5872a;
import com.indooratlas.android.sdk._internal.eu.C5872a.C5871a;
import com.indooratlas.android.sdk._internal.ff.C5897c;
import com.indooratlas.android.sdk._internal.ff.C5902h;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ce extends ds {
    /* renamed from: b */
    protected final cl f23099b;

    public ce(bf bfVar) {
        this.f23099b = new cl(bfVar.f23177v);
    }

    /* renamed from: a */
    public final void m20019a(@Nullable C5872a c5872a) {
        cl clVar = this.f23099b;
        clVar.f23321c = c5872a;
        clVar.f23322d = null;
        if (c5872a != null && c5872a.f23551g != null && c5872a.f23551g.length > 0) {
            clVar.f23322d = new HashMap();
            for (C5871a c5871a : c5872a.f23551g) {
                if (c5871a != null) {
                    Object obj;
                    byte[] bArr = c5871a.f23545b;
                    if (bArr == null) {
                        obj = null;
                    } else {
                        long j;
                        long j2;
                        if (bArr.length == 2) {
                            j = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM + ((((long) (bArr[1] & 255)) << 32) + (((long) (bArr[0] & 255)) << 40));
                            j2 = -9223371485494954757L;
                        } else if (bArr.length == 16) {
                            ByteBuffer wrap = ByteBuffer.wrap(bArr);
                            j = wrap.getLong();
                            j2 = wrap.getLong();
                        } else {
                            obj = null;
                        }
                        ParcelUuid parcelUuid = new ParcelUuid(new UUID(j, j2));
                    }
                    if (obj != null) {
                        if (clVar.f23322d.containsKey(obj)) {
                            new StringBuilder("Duplicate uuid ").append(obj).append(" from server");
                        }
                        clVar.f23322d.put(obj, c5871a);
                    } else {
                        new StringBuilder("Cannot convert bytes from server ").append(Arrays.toString(c5871a.f23545b)).append(" to valid service id.");
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo4616a(cx cxVar, dd ddVar) {
        if (cxVar.m20276a()) {
            Collection collection;
            if (cxVar.m20276a()) {
                collection = (List) cxVar.f23360c;
            } else {
                collection = null;
            }
            cl clVar = this.f23099b;
            if (r0 != null) {
                clVar.f23324f = clVar.f23323e.mo4654a();
                clVar.f23325g = SystemClock.elapsedRealtime();
                new StringBuilder("received ").append(r0.size()).append(" ble events at clientTime: %d, systemTime: %d");
                Object[] objArr = new Object[]{Long.valueOf(clVar.f23324f), Long.valueOf(clVar.f23325g)};
                for (dh dhVar : r0) {
                    if (dhVar != null) {
                        clVar.m20226a(dhVar);
                    }
                }
            }
            if (this.f23099b.m20225a() > 0) {
                cl clVar2 = this.f23099b;
                C5902h c5902h = new C5902h();
                c5902h.f23661b = clVar2.f23324f;
                c5902h.f23665g = new C5897c();
                c5902h.f23665g.f23645d = clVar2.m20227a(clVar2.f23319a);
                c5902h.f23665g.f23644b = cl.m20224b(clVar2.f23320b);
                clVar2 = this.f23099b;
                clVar2.f23319a.clear();
                clVar2.f23320b.clear();
                mo4619a(c5902h);
            }
        }
        super.mo4616a(cxVar, ddVar);
    }

    /* renamed from: a */
    public void mo4619a(C5902h c5902h) {
    }
}
