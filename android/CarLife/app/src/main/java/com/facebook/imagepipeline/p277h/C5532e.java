package com.facebook.imagepipeline.p277h;

import com.facebook.common.internal.C5350k;
import com.facebook.imagepipeline.p152i.C5537g;
import com.facebook.imagepipeline.p152i.C5538f;
import java.util.Collections;
import java.util.List;

/* compiled from: SimpleProgressiveJpegConfig */
/* renamed from: com.facebook.imagepipeline.h.e */
public class C5532e implements C5527c {
    /* renamed from: a */
    private final C5530b f22451a;

    /* compiled from: SimpleProgressiveJpegConfig */
    /* renamed from: com.facebook.imagepipeline.h.e$b */
    public interface C5530b {
        /* renamed from: a */
        List<Integer> mo4093a();

        /* renamed from: b */
        int mo4094b();
    }

    /* compiled from: SimpleProgressiveJpegConfig */
    /* renamed from: com.facebook.imagepipeline.h.e$a */
    private static class C5531a implements C5530b {
        private C5531a() {
        }

        /* renamed from: a */
        public List<Integer> mo4093a() {
            return Collections.EMPTY_LIST;
        }

        /* renamed from: b */
        public int mo4094b() {
            return 0;
        }
    }

    public C5532e() {
        this(new C5531a());
    }

    public C5532e(C5530b dynamicValueConfig) {
        this.f22451a = (C5530b) C5350k.m18310a((Object) dynamicValueConfig);
    }

    /* renamed from: a */
    public int mo4095a(int scanNumber) {
        List<Integer> scansToDecode = this.f22451a.mo4093a();
        if (scansToDecode == null || scansToDecode.isEmpty()) {
            return scanNumber + 1;
        }
        for (int i = 0; i < scansToDecode.size(); i++) {
            if (((Integer) scansToDecode.get(i)).intValue() > scanNumber) {
                return ((Integer) scansToDecode.get(i)).intValue();
            }
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: b */
    public C5537g mo4096b(int scanNumber) {
        boolean z;
        if (scanNumber >= this.f22451a.mo4094b()) {
            z = true;
        } else {
            z = false;
        }
        return C5538f.m19064a(scanNumber, z, false);
    }
}
