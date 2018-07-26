package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class PoiResult$SuggestQuery extends MessageMicro {
    public static final int QUERY_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f14168a;
    /* renamed from: b */
    private String f14169b = "";
    /* renamed from: c */
    private int f14170c = -1;

    public static PoiResult$SuggestQuery parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new PoiResult$SuggestQuery().mergeFrom(codedInputStreamMicro);
    }

    public static PoiResult$SuggestQuery parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (PoiResult$SuggestQuery) new PoiResult$SuggestQuery().mergeFrom(bArr);
    }

    public final PoiResult$SuggestQuery clear() {
        clearQuery();
        this.f14170c = -1;
        return this;
    }

    public PoiResult$SuggestQuery clearQuery() {
        this.f14168a = false;
        this.f14169b = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f14170c < 0) {
            getSerializedSize();
        }
        return this.f14170c;
    }

    public String getQuery() {
        return this.f14169b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasQuery()) {
            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getQuery());
        }
        this.f14170c = i;
        return i;
    }

    public boolean hasQuery() {
        return this.f14168a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public PoiResult$SuggestQuery mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    setQuery(codedInputStreamMicro.readString());
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

    public PoiResult$SuggestQuery setQuery(String str) {
        this.f14168a = true;
        this.f14169b = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasQuery()) {
            codedOutputStreamMicro.writeString(1, getQuery());
        }
    }
}
