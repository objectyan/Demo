package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.es.C5870a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public final class en<K, V> {
    /* renamed from: a */
    public HashMap<et, Collection<C5869a<V>>> f23522a = new HashMap();
    /* renamed from: b */
    public HashMap<K, Collection<C5869a<V>>> f23523b = new HashMap();

    /* renamed from: com.indooratlas.android.sdk._internal.en$a */
    public static class C5869a<V> {
        /* renamed from: a */
        final em f23520a;
        /* renamed from: b */
        final V f23521b;

        public C5869a(em emVar, V v) {
            this.f23520a = emVar;
            this.f23521b = v;
        }
    }

    /* renamed from: a */
    public final Collection<V> m20425a(ep epVar) {
        Collection<V> arrayList = new ArrayList();
        for (int i = 15; i <= 19; i++) {
            Collection<C5869a> collection = (Collection) this.f23522a.get(et.m20429a(epVar.f23525a, epVar.f23526b, i));
            if (collection != null) {
                for (C5869a c5869a : collection) {
                    if (c5869a.f23520a.m20423a(epVar)) {
                        arrayList.add(c5869a.f23521b);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final void m20426a(K k, em emVar, V v) {
        C5869a c5869a = new C5869a(emVar, v);
        for (et etVar : m20424a(emVar)) {
            Collection collection = (Collection) this.f23522a.get(etVar);
            if (collection == null) {
                collection = new ArrayList();
                this.f23522a.put(etVar, collection);
            }
            collection.add(c5869a);
        }
        Collection collection2 = (Collection) this.f23523b.get(k);
        if (collection2 == null) {
            collection2 = new ArrayList();
            this.f23523b.put(k, collection2);
        }
        collection2.add(c5869a);
    }

    /* renamed from: a */
    public final boolean m20427a(K k) {
        Collection<C5869a> collection = (Collection) this.f23523b.remove(k);
        if (collection == null) {
            return false;
        }
        for (C5869a c5869a : collection) {
            for (et etVar : m20424a(c5869a.f23520a)) {
                Collection collection2 = (Collection) this.f23522a.get(etVar);
                collection2.remove(c5869a);
                if (collection2.isEmpty()) {
                    this.f23522a.remove(etVar);
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    private static Collection<et> m20424a(em emVar) {
        int i;
        er erVar = emVar.f23518a.f23529b;
        C5870a c5870a = null;
        for (i = 19; i >= 15; i--) {
            c5870a = new C5870a(erVar, i);
            if (((long) ((c5870a.f23535b - c5870a.f23534a) + 1)) * ((long) ((c5870a.f23537d - c5870a.f23536c) + 1)) <= 4) {
                break;
            }
        }
        Collection arrayList = new ArrayList();
        for (i = c5870a.f23534a; i < c5870a.f23535b + 1; i++) {
            for (int i2 = c5870a.f23536c; i2 < c5870a.f23537d + 1; i2++) {
                et etVar = new et((c5870a.f23539f + i) % c5870a.f23539f, i2, c5870a.f23538e);
                if (!arrayList.contains(etVar)) {
                    arrayList.add(etVar);
                }
            }
        }
        return arrayList;
    }
}
