package com.baidu.speech.asr;

public class ASRMessage {
    private static final String TAG = "ASRMessage";
    public String mCommand = "";
    public byte[] mData = null;
    public boolean mIsVip = false;
    public int mLength = 0;
    public int mOffset = 0;
    public String mParam = "";

    public ASRMessage(String str, String str2, byte[] bArr, int i, int i2) {
        this.mCommand = str;
        this.mParam = str2;
        this.mData = bArr;
        this.mOffset = i;
        this.mLength = i2;
        this.mIsVip = false;
    }

    public ASRMessage(String str, String str2, byte[] bArr, int i, int i2, boolean z) {
        this.mCommand = str;
        this.mParam = str2;
        this.mData = bArr;
        this.mOffset = i;
        this.mLength = i2;
        this.mIsVip = z;
    }
}
