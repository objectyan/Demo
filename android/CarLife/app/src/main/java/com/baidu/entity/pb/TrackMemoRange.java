package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TrackMemoRange extends MessageMicro {
    public static final int DATE_FIELD_NUMBER = 1;
    /* renamed from: a */
    private List<String> f16307a = Collections.emptyList();
    /* renamed from: b */
    private int f16308b = -1;

    public static TrackMemoRange parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new TrackMemoRange().mergeFrom(codedInputStreamMicro);
    }

    public static TrackMemoRange parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (TrackMemoRange) new TrackMemoRange().mergeFrom(bArr);
    }

    public TrackMemoRange addDate(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        if (this.f16307a.isEmpty()) {
            this.f16307a = new ArrayList();
        }
        this.f16307a.add(str);
        return this;
    }

    public final TrackMemoRange clear() {
        clearDate();
        this.f16308b = -1;
        return this;
    }

    public TrackMemoRange clearDate() {
        this.f16307a = Collections.emptyList();
        return this;
    }

    public int getCachedSize() {
        if (this.f16308b < 0) {
            getSerializedSize();
        }
        return this.f16308b;
    }

    public String getDate(int i) {
        return (String) this.f16307a.get(i);
    }

    public int getDateCount() {
        return this.f16307a.size();
    }

    public List<String> getDateList() {
        return this.f16307a;
    }

    public int getSerializedSize() {
        int i = 0;
        for (String computeStringSizeNoTag : getDateList()) {
            i = CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag) + i;
        }
        int size = (0 + i) + (getDateList().size() * 1);
        this.f16308b = size;
        return size;
    }

    public final boolean isInitialized() {
        return true;
    }

    public TrackMemoRange mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    addDate(codedInputStreamMicro.readString());
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

    public TrackMemoRange setDate(int i, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f16307a.set(i, str);
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (String writeString : getDateList()) {
            codedOutputStreamMicro.writeString(1, writeString);
        }
    }
}
