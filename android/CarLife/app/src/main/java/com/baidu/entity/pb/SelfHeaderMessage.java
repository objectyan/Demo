package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class SelfHeaderMessage extends MessageMicro {
    public static final int DYNAMIC_PB_RES_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f14458a;
    /* renamed from: b */
    private ByteStringMicro f14459b = ByteStringMicro.EMPTY;
    /* renamed from: c */
    private int f14460c = -1;

    public static SelfHeaderMessage parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new SelfHeaderMessage().mergeFrom(codedInputStreamMicro);
    }

    public static SelfHeaderMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (SelfHeaderMessage) new SelfHeaderMessage().mergeFrom(bArr);
    }

    public final SelfHeaderMessage clear() {
        clearDynamicPbRes();
        this.f14460c = -1;
        return this;
    }

    public SelfHeaderMessage clearDynamicPbRes() {
        this.f14458a = false;
        this.f14459b = ByteStringMicro.EMPTY;
        return this;
    }

    public int getCachedSize() {
        if (this.f14460c < 0) {
            getSerializedSize();
        }
        return this.f14460c;
    }

    public ByteStringMicro getDynamicPbRes() {
        return this.f14459b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasDynamicPbRes()) {
            i = 0 + CodedOutputStreamMicro.computeBytesSize(1, getDynamicPbRes());
        }
        this.f14460c = i;
        return i;
    }

    public boolean hasDynamicPbRes() {
        return this.f14458a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public SelfHeaderMessage mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    setDynamicPbRes(codedInputStreamMicro.readBytes());
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

    public SelfHeaderMessage setDynamicPbRes(ByteStringMicro byteStringMicro) {
        this.f14458a = true;
        this.f14459b = byteStringMicro;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasDynamicPbRes()) {
            codedOutputStreamMicro.writeBytes(1, getDynamicPbRes());
        }
    }
}
