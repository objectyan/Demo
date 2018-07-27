package com.baidu.carlife.core.audio;

/* compiled from: Pair */
/* renamed from: com.baidu.carlife.core.audio.p */
public class Pair {
    /* renamed from: a */
    private byte[] mData;
    /* renamed from: b */
    private int mSize;

    Pair() {
    }

    Pair(byte[] data, int size) {
        this.mData = data;
        this.mSize = size;
    }

    /* renamed from: a */
    public void setData(byte[] data) {
        this.mData = data;
    }

    /* renamed from: a */
    public byte[] getData() {
        return this.mData;
    }

    /* renamed from: a */
    public void setSize(int size) {
        this.mSize = size;
    }

    /* renamed from: b */
    public int getSize() {
        return this.mSize;
    }

}
