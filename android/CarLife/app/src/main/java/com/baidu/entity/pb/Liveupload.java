package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class Liveupload extends MessageMicro {
    public static final int ERROR_FIELD_NUMBER = 1;
    public static final int MSG_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f12061a;
    /* renamed from: b */
    private int f12062b = 0;
    /* renamed from: c */
    private boolean f12063c;
    /* renamed from: d */
    private String f12064d = "";
    /* renamed from: e */
    private int f12065e = -1;

    public static Liveupload parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Liveupload().mergeFrom(codedInputStreamMicro);
    }

    public static Liveupload parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Liveupload) new Liveupload().mergeFrom(bArr);
    }

    public final Liveupload clear() {
        clearError();
        clearMsg();
        this.f12065e = -1;
        return this;
    }

    public Liveupload clearError() {
        this.f12061a = false;
        this.f12062b = 0;
        return this;
    }

    public Liveupload clearMsg() {
        this.f12063c = false;
        this.f12064d = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f12065e < 0) {
            getSerializedSize();
        }
        return this.f12065e;
    }

    public int getError() {
        return this.f12062b;
    }

    public String getMsg() {
        return this.f12064d;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasError()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
        }
        if (hasMsg()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getMsg());
        }
        this.f12065e = i;
        return i;
    }

    public boolean hasError() {
        return this.f12061a;
    }

    public boolean hasMsg() {
        return this.f12063c;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Liveupload mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    setError(codedInputStreamMicro.readInt32());
                    continue;
                case 18:
                    setMsg(codedInputStreamMicro.readString());
                    continue;
                default:
                    if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public Liveupload setError(int i) {
        this.f12061a = true;
        this.f12062b = i;
        return this;
    }

    public Liveupload setMsg(String str) {
        this.f12063c = true;
        this.f12064d = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasError()) {
            codedOutputStreamMicro.writeInt32(1, getError());
        }
        if (hasMsg()) {
            codedOutputStreamMicro.writeString(2, getMsg());
        }
    }
}
