package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class RouteItem extends MessageMicro {
    public static final int IDX_FIELD_NUMBER = 1;
    public static final int RECOMDATA_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f14273a;
    /* renamed from: b */
    private int f14274b = 0;
    /* renamed from: c */
    private boolean f14275c;
    /* renamed from: d */
    private ByteStringMicro f14276d = ByteStringMicro.EMPTY;
    /* renamed from: e */
    private int f14277e = -1;

    public static RouteItem parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new RouteItem().mergeFrom(codedInputStreamMicro);
    }

    public static RouteItem parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (RouteItem) new RouteItem().mergeFrom(bArr);
    }

    public final RouteItem clear() {
        clearIdx();
        clearRecomdata();
        this.f14277e = -1;
        return this;
    }

    public RouteItem clearIdx() {
        this.f14273a = false;
        this.f14274b = 0;
        return this;
    }

    public RouteItem clearRecomdata() {
        this.f14275c = false;
        this.f14276d = ByteStringMicro.EMPTY;
        return this;
    }

    public int getCachedSize() {
        if (this.f14277e < 0) {
            getSerializedSize();
        }
        return this.f14277e;
    }

    public int getIdx() {
        return this.f14274b;
    }

    public ByteStringMicro getRecomdata() {
        return this.f14276d;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasIdx()) {
            i = 0 + CodedOutputStreamMicro.computeUInt32Size(1, getIdx());
        }
        if (hasRecomdata()) {
            i += CodedOutputStreamMicro.computeBytesSize(2, getRecomdata());
        }
        this.f14277e = i;
        return i;
    }

    public boolean hasIdx() {
        return this.f14273a;
    }

    public boolean hasRecomdata() {
        return this.f14275c;
    }

    public final boolean isInitialized() {
        return true;
    }

    public RouteItem mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    setIdx(codedInputStreamMicro.readUInt32());
                    continue;
                case 18:
                    setRecomdata(codedInputStreamMicro.readBytes());
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

    public RouteItem setIdx(int i) {
        this.f14273a = true;
        this.f14274b = i;
        return this;
    }

    public RouteItem setRecomdata(ByteStringMicro byteStringMicro) {
        this.f14275c = true;
        this.f14276d = byteStringMicro;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasIdx()) {
            codedOutputStreamMicro.writeUInt32(1, getIdx());
        }
        if (hasRecomdata()) {
            codedOutputStreamMicro.writeBytes(2, getRecomdata());
        }
    }
}
