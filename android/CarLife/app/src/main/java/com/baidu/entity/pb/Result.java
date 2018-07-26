package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class Result extends MessageMicro {
    public static final int ERROR_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f14204a;
    /* renamed from: b */
    private int f14205b = 0;
    /* renamed from: c */
    private boolean f14206c;
    /* renamed from: d */
    private int f14207d = 0;
    /* renamed from: e */
    private int f14208e = -1;

    public static Result parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Result().mergeFrom(codedInputStreamMicro);
    }

    public static Result parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Result) new Result().mergeFrom(bArr);
    }

    public final Result clear() {
        clearType();
        clearError();
        this.f14208e = -1;
        return this;
    }

    public Result clearError() {
        this.f14206c = false;
        this.f14207d = 0;
        return this;
    }

    public Result clearType() {
        this.f14204a = false;
        this.f14205b = 0;
        return this;
    }

    public int getCachedSize() {
        if (this.f14208e < 0) {
            getSerializedSize();
        }
        return this.f14208e;
    }

    public int getError() {
        return this.f14207d;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasType()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getType());
        }
        if (hasError()) {
            i += CodedOutputStreamMicro.computeSInt32Size(2, getError());
        }
        this.f14208e = i;
        return i;
    }

    public int getType() {
        return this.f14205b;
    }

    public boolean hasError() {
        return this.f14206c;
    }

    public boolean hasType() {
        return this.f14204a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Result mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    setType(codedInputStreamMicro.readInt32());
                    continue;
                case 16:
                    setError(codedInputStreamMicro.readSInt32());
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

    public Result setError(int i) {
        this.f14206c = true;
        this.f14207d = i;
        return this;
    }

    public Result setType(int i) {
        this.f14204a = true;
        this.f14205b = i;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasType()) {
            codedOutputStreamMicro.writeInt32(1, getType());
        }
        if (hasError()) {
            codedOutputStreamMicro.writeSInt32(2, getError());
        }
    }
}
