package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class PoiResult$PreviousCity extends MessageMicro {
    public static final int CODE_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f14148a;
    /* renamed from: b */
    private int f14149b = 0;
    /* renamed from: c */
    private boolean f14150c;
    /* renamed from: d */
    private String f14151d = "";
    /* renamed from: e */
    private int f14152e = -1;

    public static PoiResult$PreviousCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new PoiResult$PreviousCity().mergeFrom(codedInputStreamMicro);
    }

    public static PoiResult$PreviousCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (PoiResult$PreviousCity) new PoiResult$PreviousCity().mergeFrom(bArr);
    }

    public final PoiResult$PreviousCity clear() {
        clearCode();
        clearName();
        this.f14152e = -1;
        return this;
    }

    public PoiResult$PreviousCity clearCode() {
        this.f14148a = false;
        this.f14149b = 0;
        return this;
    }

    public PoiResult$PreviousCity clearName() {
        this.f14150c = false;
        this.f14151d = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f14152e < 0) {
            getSerializedSize();
        }
        return this.f14152e;
    }

    public int getCode() {
        return this.f14149b;
    }

    public String getName() {
        return this.f14151d;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasCode()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
        }
        if (hasName()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getName());
        }
        this.f14152e = i;
        return i;
    }

    public boolean hasCode() {
        return this.f14148a;
    }

    public boolean hasName() {
        return this.f14150c;
    }

    public final boolean isInitialized() {
        return true;
    }

    public PoiResult$PreviousCity mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    setCode(codedInputStreamMicro.readInt32());
                    continue;
                case 18:
                    setName(codedInputStreamMicro.readString());
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

    public PoiResult$PreviousCity setCode(int i) {
        this.f14148a = true;
        this.f14149b = i;
        return this;
    }

    public PoiResult$PreviousCity setName(String str) {
        this.f14150c = true;
        this.f14151d = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasCode()) {
            codedOutputStreamMicro.writeInt32(1, getCode());
        }
        if (hasName()) {
            codedOutputStreamMicro.writeString(2, getName());
        }
    }
}
