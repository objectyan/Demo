package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class PoiResult$Contents$MapPoitag extends MessageMicro {
    public static final int TAG_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f13972a;
    /* renamed from: b */
    private String f13973b = "";
    /* renamed from: c */
    private int f13974c = -1;

    public static PoiResult$Contents$MapPoitag parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new PoiResult$Contents$MapPoitag().mergeFrom(codedInputStreamMicro);
    }

    public static PoiResult$Contents$MapPoitag parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (PoiResult$Contents$MapPoitag) new PoiResult$Contents$MapPoitag().mergeFrom(bArr);
    }

    public final PoiResult$Contents$MapPoitag clear() {
        clearTag();
        this.f13974c = -1;
        return this;
    }

    public PoiResult$Contents$MapPoitag clearTag() {
        this.f13972a = false;
        this.f13973b = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f13974c < 0) {
            getSerializedSize();
        }
        return this.f13974c;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasTag()) {
            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTag());
        }
        this.f13974c = i;
        return i;
    }

    public String getTag() {
        return this.f13973b;
    }

    public boolean hasTag() {
        return this.f13972a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public PoiResult$Contents$MapPoitag mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    setTag(codedInputStreamMicro.readString());
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

    public PoiResult$Contents$MapPoitag setTag(String str) {
        this.f13972a = true;
        this.f13973b = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasTag()) {
            codedOutputStreamMicro.writeString(1, getTag());
        }
    }
}
