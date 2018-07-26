package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class BzInfo extends MessageMicro {
    public static final int CIRCLE_FIELD_NUMBER = 2;
    public static final int ERRNO_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f10431a;
    /* renamed from: b */
    private String f10432b = "";
    /* renamed from: c */
    private boolean f10433c;
    /* renamed from: d */
    private String f10434d = "";
    /* renamed from: e */
    private int f10435e = -1;

    public static BzInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new BzInfo().mergeFrom(codedInputStreamMicro);
    }

    public static BzInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (BzInfo) new BzInfo().mergeFrom(bArr);
    }

    public final BzInfo clear() {
        clearErrno();
        clearCircle();
        this.f10435e = -1;
        return this;
    }

    public BzInfo clearCircle() {
        this.f10433c = false;
        this.f10434d = "";
        return this;
    }

    public BzInfo clearErrno() {
        this.f10431a = false;
        this.f10432b = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f10435e < 0) {
            getSerializedSize();
        }
        return this.f10435e;
    }

    public String getCircle() {
        return this.f10434d;
    }

    public String getErrno() {
        return this.f10432b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasErrno()) {
            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getErrno());
        }
        if (hasCircle()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getCircle());
        }
        this.f10435e = i;
        return i;
    }

    public boolean hasCircle() {
        return this.f10433c;
    }

    public boolean hasErrno() {
        return this.f10431a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public BzInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    setErrno(codedInputStreamMicro.readString());
                    continue;
                case 18:
                    setCircle(codedInputStreamMicro.readString());
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

    public BzInfo setCircle(String str) {
        this.f10433c = true;
        this.f10434d = str;
        return this;
    }

    public BzInfo setErrno(String str) {
        this.f10431a = true;
        this.f10432b = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasErrno()) {
            codedOutputStreamMicro.writeString(1, getErrno());
        }
        if (hasCircle()) {
            codedOutputStreamMicro.writeString(2, getCircle());
        }
    }
}
