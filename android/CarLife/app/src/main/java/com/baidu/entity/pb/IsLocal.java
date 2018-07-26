package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class IsLocal extends MessageMicro {
    public static final int IS_LOCAL_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f11842a;
    /* renamed from: b */
    private boolean f11843b = false;
    /* renamed from: c */
    private int f11844c = -1;

    public static IsLocal parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new IsLocal().mergeFrom(codedInputStreamMicro);
    }

    public static IsLocal parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (IsLocal) new IsLocal().mergeFrom(bArr);
    }

    public final IsLocal clear() {
        clearIsLocal();
        this.f11844c = -1;
        return this;
    }

    public IsLocal clearIsLocal() {
        this.f11842a = false;
        this.f11843b = false;
        return this;
    }

    public int getCachedSize() {
        if (this.f11844c < 0) {
            getSerializedSize();
        }
        return this.f11844c;
    }

    public boolean getIsLocal() {
        return this.f11843b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasIsLocal()) {
            i = 0 + CodedOutputStreamMicro.computeBoolSize(1, getIsLocal());
        }
        this.f11844c = i;
        return i;
    }

    public boolean hasIsLocal() {
        return this.f11842a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public IsLocal mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    setIsLocal(codedInputStreamMicro.readBool());
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

    public IsLocal setIsLocal(boolean z) {
        this.f11842a = true;
        this.f11843b = z;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasIsLocal()) {
            codedOutputStreamMicro.writeBool(1, getIsLocal());
        }
    }
}
