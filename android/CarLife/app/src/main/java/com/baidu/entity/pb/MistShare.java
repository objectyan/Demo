package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class MistShare extends MessageMicro {
    public static final int URL_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f12108a;
    /* renamed from: b */
    private String f12109b = "";
    /* renamed from: c */
    private int f12110c = -1;

    public static MistShare parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new MistShare().mergeFrom(codedInputStreamMicro);
    }

    public static MistShare parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (MistShare) new MistShare().mergeFrom(bArr);
    }

    public final MistShare clear() {
        clearUrl();
        this.f12110c = -1;
        return this;
    }

    public MistShare clearUrl() {
        this.f12108a = false;
        this.f12109b = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f12110c < 0) {
            getSerializedSize();
        }
        return this.f12110c;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasUrl()) {
            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUrl());
        }
        this.f12110c = i;
        return i;
    }

    public String getUrl() {
        return this.f12109b;
    }

    public boolean hasUrl() {
        return this.f12108a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public MistShare mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
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

    public MistShare setUrl(String str) {
        this.f12108a = true;
        this.f12109b = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasUrl()) {
            codedOutputStreamMicro.writeString(1, getUrl());
        }
    }
}
