package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class NaviContent extends MessageMicro {
    public static final int OUTTYPE_FIELD_NUMBER = 2;
    public static final int OUT_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f12213a;
    /* renamed from: b */
    private ByteStringMicro f12214b = ByteStringMicro.EMPTY;
    /* renamed from: c */
    private boolean f12215c;
    /* renamed from: d */
    private String f12216d = "";
    /* renamed from: e */
    private int f12217e = -1;

    public static NaviContent parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new NaviContent().mergeFrom(codedInputStreamMicro);
    }

    public static NaviContent parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (NaviContent) new NaviContent().mergeFrom(bArr);
    }

    public final NaviContent clear() {
        clearOut();
        clearOuttype();
        this.f12217e = -1;
        return this;
    }

    public NaviContent clearOut() {
        this.f12213a = false;
        this.f12214b = ByteStringMicro.EMPTY;
        return this;
    }

    public NaviContent clearOuttype() {
        this.f12215c = false;
        this.f12216d = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f12217e < 0) {
            getSerializedSize();
        }
        return this.f12217e;
    }

    public ByteStringMicro getOut() {
        return this.f12214b;
    }

    public String getOuttype() {
        return this.f12216d;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasOut()) {
            i = 0 + CodedOutputStreamMicro.computeBytesSize(1, getOut());
        }
        if (hasOuttype()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getOuttype());
        }
        this.f12217e = i;
        return i;
    }

    public boolean hasOut() {
        return this.f12213a;
    }

    public boolean hasOuttype() {
        return this.f12215c;
    }

    public final boolean isInitialized() {
        return true;
    }

    public NaviContent mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    setOut(codedInputStreamMicro.readBytes());
                    continue;
                case 18:
                    setOuttype(codedInputStreamMicro.readString());
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

    public NaviContent setOut(ByteStringMicro byteStringMicro) {
        this.f12213a = true;
        this.f12214b = byteStringMicro;
        return this;
    }

    public NaviContent setOuttype(String str) {
        this.f12215c = true;
        this.f12216d = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasOut()) {
            codedOutputStreamMicro.writeBytes(1, getOut());
        }
        if (hasOuttype()) {
            codedOutputStreamMicro.writeString(2, getOuttype());
        }
    }
}
