package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class Ckuserphone extends MessageMicro {
    public static final int STATUS_FIELD_NUMBER = 1;
    public static final int URL_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f11052a;
    /* renamed from: b */
    private int f11053b = 0;
    /* renamed from: c */
    private boolean f11054c;
    /* renamed from: d */
    private String f11055d = "";
    /* renamed from: e */
    private int f11056e = -1;

    public static Ckuserphone parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Ckuserphone().mergeFrom(codedInputStreamMicro);
    }

    public static Ckuserphone parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Ckuserphone) new Ckuserphone().mergeFrom(bArr);
    }

    public final Ckuserphone clear() {
        clearStatus();
        clearUrl();
        this.f11056e = -1;
        return this;
    }

    public Ckuserphone clearStatus() {
        this.f11052a = false;
        this.f11053b = 0;
        return this;
    }

    public Ckuserphone clearUrl() {
        this.f11054c = false;
        this.f11055d = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f11056e < 0) {
            getSerializedSize();
        }
        return this.f11056e;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasStatus()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getStatus());
        }
        if (hasUrl()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getUrl());
        }
        this.f11056e = i;
        return i;
    }

    public int getStatus() {
        return this.f11053b;
    }

    public String getUrl() {
        return this.f11055d;
    }

    public boolean hasStatus() {
        return this.f11052a;
    }

    public boolean hasUrl() {
        return this.f11054c;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Ckuserphone mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    setStatus(codedInputStreamMicro.readInt32());
                    continue;
                case 18:
                    setUrl(codedInputStreamMicro.readString());
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

    public Ckuserphone setStatus(int i) {
        this.f11052a = true;
        this.f11053b = i;
        return this;
    }

    public Ckuserphone setUrl(String str) {
        this.f11054c = true;
        this.f11055d = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasStatus()) {
            codedOutputStreamMicro.writeInt32(1, getStatus());
        }
        if (hasUrl()) {
            codedOutputStreamMicro.writeString(2, getUrl());
        }
    }
}
