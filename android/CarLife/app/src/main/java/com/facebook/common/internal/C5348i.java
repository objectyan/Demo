package com.facebook.common.internal;

/* compiled from: Ints */
/* renamed from: com.facebook.common.internal.i */
public class C5348i {
    private C5348i() {
    }

    /* renamed from: a */
    public static int m18289a(int... array) {
        boolean z;
        if (array.length > 0) {
            z = true;
        } else {
            z = false;
        }
        C5350k.m18315a(z);
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
