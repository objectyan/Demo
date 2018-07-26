package com.indooratlas.android.sdk._internal;

import android.support.annotation.NonNull;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocation.Builder;
import com.indooratlas.android.sdk.IARegion;
import com.indooratlas.android.sdk._internal.ex.C5877a;
import com.indooratlas.android.sdk._internal.fc.C5891c;
import java.util.Collection;
import java.util.Comparator;

public final class co {
    /* renamed from: g */
    public static Comparator<C5842a> f23337g = new C58411();
    /* renamed from: a */
    public C5891c f23338a = null;
    /* renamed from: b */
    public IARegion f23339b = null;
    /* renamed from: c */
    public IARegion f23340c = null;
    /* renamed from: d */
    public IARegion f23341d = null;
    /* renamed from: e */
    public IARegion f23342e = null;
    /* renamed from: f */
    public IALocation f23343f = null;
    /* renamed from: h */
    private final bi f23344h;

    /* renamed from: com.indooratlas.android.sdk._internal.co$1 */
    static class C58411 implements Comparator<C5842a> {
        C58411() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((C5842a) obj).f23336c - ((C5842a) obj2).f23336c;
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.co$a */
    public static class C5842a {
        /* renamed from: a */
        public boolean f23334a;
        /* renamed from: b */
        public IARegion f23335b;
        /* renamed from: c */
        final int f23336c;

        C5842a(boolean z, IARegion iARegion) {
            this.f23334a = z;
            this.f23335b = iARegion;
            if (this.f23335b == null) {
                if (this.f23334a) {
                    this.f23336c = 2;
                } else {
                    this.f23336c = 1;
                }
            } else if (this.f23334a) {
                this.f23336c = 3;
            } else {
                this.f23336c = 4;
            }
        }
    }

    public co(@NonNull bi biVar) {
        eg.m20413a((Object) biVar, "listener cannot be null", new Object[0]);
        this.f23344h = biVar;
    }

    /* renamed from: a */
    public final void m20235a(double d, double d2, double d3, double d4) {
        IARegion iARegion;
        float f = (float) d4;
        if (this.f23342e != null) {
            iARegion = this.f23342e;
        } else if (this.f23341d != null) {
            iARegion = this.f23341d;
        } else {
            iARegion = null;
        }
        C5891c c5891c = this.f23338a;
        Builder withTime = new Builder("IndoorAtlas").withLatitude(d).withLongitude(d2).withAccuracy(f).withRegion(iARegion).withTime(System.currentTimeMillis());
        if (d3 != 0.0d) {
            withTime.withBearing((float) d3);
        }
        if (cp.m20240a(c5891c)) {
            C5877a c5877a = c5891c.f23625b.f23623b;
            if (c5877a.f23575g != null) {
                withTime.withFloorLevel(c5877a.f23575g.f24067b);
            }
            if (c5877a.f23580l != null) {
                withTime.withFloorCertainty(c5877a.f23580l.f23832b);
            }
            if (c5877a.f23574f != null) {
                withTime.withAltitude((double) c5877a.f23574f.f23832b);
            }
        }
        IALocation build = withTime.build();
        this.f23343f = build;
        this.f23344h.mo4564a(build);
    }

    /* renamed from: a */
    public static void m20234a(IARegion iARegion, IARegion iARegion2, Collection<C5842a> collection, boolean z) {
        if (iARegion == null) {
            if (iARegion2 != null) {
                collection.add(new C5842a(z, iARegion2));
            }
        } else if (iARegion2 == null) {
            collection.add(new C5842a(z, null));
        } else if (!iARegion.equals(iARegion2)) {
            collection.add(new C5842a(z, null));
            collection.add(new C5842a(z, iARegion2));
        }
    }
}
