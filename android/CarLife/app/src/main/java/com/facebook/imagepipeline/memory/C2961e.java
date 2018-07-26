package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@VisibleForTesting
@NotThreadSafe
/* compiled from: Bucket */
/* renamed from: com.facebook.imagepipeline.memory.e */
class C2961e<V> {
    /* renamed from: a */
    public final int f13210a;
    /* renamed from: b */
    public final int f13211b;
    /* renamed from: c */
    final Queue f13212c;
    /* renamed from: d */
    private int f13213d;

    public C2961e(int itemSize, int maxLength, int inUseLength) {
        boolean z;
        boolean z2 = true;
        C5350k.b(itemSize > 0);
        if (maxLength >= 0) {
            z = true;
        } else {
            z = false;
        }
        C5350k.b(z);
        if (inUseLength < 0) {
            z2 = false;
        }
        C5350k.b(z2);
        this.f13210a = itemSize;
        this.f13211b = maxLength;
        this.f13212c = new LinkedList();
        this.f13213d = inUseLength;
    }

    /* renamed from: a */
    public boolean m11960a() {
        return this.f13213d + m11961b() > this.f13211b;
    }

    /* renamed from: b */
    int m11961b() {
        return this.f13212c.size();
    }

    @Nullable
    /* renamed from: c */
    public V m11963c() {
        V value = m11964d();
        if (value != null) {
            this.f13213d++;
        }
        return value;
    }

    @Nullable
    /* renamed from: d */
    public V m11964d() {
        return this.f13212c.poll();
    }

    /* renamed from: e */
    public void m11965e() {
        this.f13213d++;
    }

    /* renamed from: a */
    public void m11959a(V value) {
        C5350k.a(value);
        C5350k.b(this.f13213d > 0);
        this.f13213d--;
        m11962b(value);
    }

    /* renamed from: b */
    void m11962b(V value) {
        this.f13212c.add(value);
    }

    /* renamed from: f */
    public void m11966f() {
        C5350k.b(this.f13213d > 0);
        this.f13213d--;
    }

    /* renamed from: g */
    public int m11967g() {
        return this.f13213d;
    }
}
