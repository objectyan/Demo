package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class DynamicHeaderMessage extends MessageMicro {
    public static final int DYNAMIC_PB_RES_FIELD_NUMBER = 1;
    public static final int SELFMAP_PB_RES_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f11073a;
    /* renamed from: b */
    private ByteStringMicro f11074b = ByteStringMicro.EMPTY;
    /* renamed from: c */
    private boolean f11075c;
    /* renamed from: d */
    private ByteStringMicro f11076d = ByteStringMicro.EMPTY;
    /* renamed from: e */
    private int f11077e = -1;

    public static DynamicHeaderMessage parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new DynamicHeaderMessage().mergeFrom(codedInputStreamMicro);
    }

    public static DynamicHeaderMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (DynamicHeaderMessage) new DynamicHeaderMessage().mergeFrom(bArr);
    }

    public final DynamicHeaderMessage clear() {
        clearDynamicPbRes();
        clearSelfmapPbRes();
        this.f11077e = -1;
        return this;
    }

    public DynamicHeaderMessage clearDynamicPbRes() {
        this.f11073a = false;
        this.f11074b = ByteStringMicro.EMPTY;
        return this;
    }

    public DynamicHeaderMessage clearSelfmapPbRes() {
        this.f11075c = false;
        this.f11076d = ByteStringMicro.EMPTY;
        return this;
    }

    public int getCachedSize() {
        if (this.f11077e < 0) {
            getSerializedSize();
        }
        return this.f11077e;
    }

    public ByteStringMicro getDynamicPbRes() {
        return this.f11074b;
    }

    public ByteStringMicro getSelfmapPbRes() {
        return this.f11076d;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasDynamicPbRes()) {
            i = 0 + CodedOutputStreamMicro.computeBytesSize(1, getDynamicPbRes());
        }
        if (hasSelfmapPbRes()) {
            i += CodedOutputStreamMicro.computeBytesSize(2, getSelfmapPbRes());
        }
        this.f11077e = i;
        return i;
    }

    public boolean hasDynamicPbRes() {
        return this.f11073a;
    }

    public boolean hasSelfmapPbRes() {
        return this.f11075c;
    }

    public final boolean isInitialized() {
        return true;
    }

    public DynamicHeaderMessage mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    setDynamicPbRes(codedInputStreamMicro.readBytes());
                    continue;
                case 18:
                    setSelfmapPbRes(codedInputStreamMicro.readBytes());
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

    public DynamicHeaderMessage setDynamicPbRes(ByteStringMicro byteStringMicro) {
        this.f11073a = true;
        this.f11074b = byteStringMicro;
        return this;
    }

    public DynamicHeaderMessage setSelfmapPbRes(ByteStringMicro byteStringMicro) {
        this.f11075c = true;
        this.f11076d = byteStringMicro;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasDynamicPbRes()) {
            codedOutputStreamMicro.writeBytes(1, getDynamicPbRes());
        }
        if (hasSelfmapPbRes()) {
            codedOutputStreamMicro.writeBytes(2, getSelfmapPbRes());
        }
    }
}
