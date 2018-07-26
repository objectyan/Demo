package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class cz {
    /* renamed from: a */
    public static String f23362a = ee.m20406a(cz.class);
    /* renamed from: c */
    private static cz f23363c;
    /* renamed from: b */
    public final ArrayList<db> f23364b = new ArrayList();

    private cz(Context context) {
        this.f23364b.add(new dm(context));
        this.f23364b.add(new eb(context));
        this.f23364b.add(new dg(context));
        this.f23364b.add(new dr(context));
    }

    /* renamed from: a */
    public static cz m20279a(Context context) {
        cz czVar;
        synchronized (cz.class) {
            if (f23363c == null) {
                f23363c = new cz(context);
            }
            czVar = f23363c;
        }
        return czVar;
    }

    /* renamed from: a */
    public final cw m20283a(int i) {
        cw cwVar;
        synchronized (this.f23364b) {
            cwVar = null;
            Iterator it = this.f23364b.iterator();
            while (it.hasNext()) {
                cw a = ((db) it.next()).mo4660a(i);
                if (a == null) {
                    a = cwVar;
                }
                cwVar = a;
            }
        }
        return cwVar;
    }

    /* renamed from: a */
    public final List<cw> m20284a() {
        List arrayList;
        synchronized (this.f23364b) {
            arrayList = new ArrayList();
            Iterator it = this.f23364b.iterator();
            while (it.hasNext()) {
                arrayList.addAll(((db) it.next()).mo4661a());
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final void m20287a(@NonNull cy cyVar, @NonNull cw cwVar, @NonNull da daVar) {
        m20282c(cwVar).mo4665a(cyVar, cwVar, daVar);
    }

    /* renamed from: a */
    public final void m20286a(@NonNull cy cyVar, @NonNull cw cwVar) {
        m20282c(cwVar).mo4664a(cyVar, cwVar);
    }

    /* renamed from: a */
    public static void m20280a(@NonNull String str) {
        f23362a = eg.m20414a(str, "log tag must be non null", new Object[0]);
    }

    /* renamed from: b */
    private db m20281b(cw cwVar) {
        db dbVar;
        synchronized (this.f23364b) {
            dbVar = null;
            Iterator it = this.f23364b.iterator();
            while (it.hasNext()) {
                db dbVar2 = (db) it.next();
                if (dbVar2.mo4660a(cwVar.mo4658a()) == null) {
                    dbVar2 = dbVar;
                }
                dbVar = dbVar2;
            }
        }
        return dbVar;
    }

    @NonNull
    /* renamed from: a */
    public final List<cx> m20285a(cw cwVar) {
        List<cx> a = m20282c(cwVar).mo4662a(cwVar);
        if (a == null) {
            return new ArrayList(0);
        }
        return a;
    }

    /* renamed from: c */
    private db m20282c(cw cwVar) {
        return (db) eg.m20413a(m20281b(cwVar), "no provider found for sensor: " + cwVar, new Object[0]);
    }
}
