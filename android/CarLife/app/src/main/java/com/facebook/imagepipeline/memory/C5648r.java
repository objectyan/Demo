package com.facebook.imagepipeline.memory;

import com.facebook.common.p140h.C2922b;
import java.util.LinkedList;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: OOMSoftReferenceBucket */
/* renamed from: com.facebook.imagepipeline.memory.r */
class C5648r<V> extends C2961e<V> {
    /* renamed from: d */
    private LinkedList<C2922b<V>> f22791d = new LinkedList();

    public C5648r(int itemSize, int maxLength, int inUseLength) {
        super(itemSize, maxLength, inUseLength);
    }

    /* renamed from: d */
    public V m19597d() {
        C2922b<V> ref = (C2922b) this.c.poll();
        V value = ref.a();
        ref.b();
        this.f22791d.add(ref);
        return value;
    }

    /* renamed from: b */
    void m19596b(V value) {
        C2922b<V> ref = (C2922b) this.f22791d.poll();
        if (ref == null) {
            ref = new C2922b();
        }
        ref.a(value);
        this.c.add(ref);
    }
}
