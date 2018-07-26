package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class TrackShare extends MessageMicro {
    public static final int URL_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f16372a;
    /* renamed from: b */
    private String f16373b = "";
    /* renamed from: c */
    private int f16374c = -1;

    public static TrackShare parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new TrackShare().mergeFrom(codedInputStreamMicro);
    }

    public static TrackShare parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (TrackShare) new TrackShare().mergeFrom(bArr);
    }

    public final TrackShare clear() {
        clearUrl();
        this.f16374c = -1;
        return this;
    }

    public TrackShare clearUrl() {
        this.f16372a = false;
        this.f16373b = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f16374c < 0) {
            getSerializedSize();
        }
        return this.f16374c;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasUrl()) {
            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUrl());
        }
        this.f16374c = i;
        return i;
    }

    public String getUrl() {
        return this.f16373b;
    }

    public boolean hasUrl() {
        return this.f16372a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public TrackShare mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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

    public TrackShare setUrl(String str) {
        this.f16372a = true;
        this.f16373b = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasUrl()) {
            codedOutputStreamMicro.writeString(1, getUrl());
        }
    }
}
