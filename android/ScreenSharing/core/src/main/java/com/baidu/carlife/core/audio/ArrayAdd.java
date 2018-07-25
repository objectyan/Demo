package com.baidu.carlife.core.audio;

/* compiled from: ArrayAdd */
/* renamed from: com.baidu.carlife.core.audio.c */
public class ArrayAdd {
    /* renamed from: a */
    private static final int len = 20480;
    /* renamed from: b */
    private byte[] mBytes = new byte[len];

    /* renamed from: a */
    public void merge(byte[] array1, int len1, byte[] array2, int len2, Pair p) {
        if (this.mBytes.length < len1 + len2) {
            this.mBytes = new byte[(len1 + len2)];
        }
        System.arraycopy(array1, 0, this.mBytes, 0, len1);
        System.arraycopy(array2, 0, this.mBytes, len1, len2);
        p.setData(this.mBytes);
        p.setSize(len1 + len2);
    }
}
