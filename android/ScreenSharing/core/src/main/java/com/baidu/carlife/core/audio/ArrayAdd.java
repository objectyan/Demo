package com.baidu.carlife.core.audio;

/* compiled from: ArrayAdd */
/* renamed from: com.baidu.carlife.core.audio.c */
public class ArrayAdd {
    /* renamed from: a */
    private static final int f3029a = 20480;
    /* renamed from: b */
    private byte[] f3030b = new byte[20480];

    /* renamed from: a */
    public void m3909a(byte[] array1, int len1, byte[] array2, int len2, Pair p) {
        if (this.f3030b.length < len1 + len2) {
            this.f3030b = new byte[(len1 + len2)];
        }
        System.arraycopy(array1, 0, this.f3030b, 0, len1);
        System.arraycopy(array2, 0, this.f3030b, len1, len2);
        p.m4056a(this.f3030b);
        p.m4055a(len1 + len2);
    }
}
