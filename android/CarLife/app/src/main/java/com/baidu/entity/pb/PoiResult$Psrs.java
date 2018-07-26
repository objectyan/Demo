package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PoiResult$Psrs extends MessageMicro {
    public static final int SENUM_FIELD_NUMBER = 1;
    public static final int SERESULT_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f14153a;
    /* renamed from: b */
    private int f14154b = 0;
    /* renamed from: c */
    private List<String> f14155c = Collections.emptyList();
    /* renamed from: d */
    private int f14156d = -1;

    public static PoiResult$Psrs parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new PoiResult$Psrs().mergeFrom(codedInputStreamMicro);
    }

    public static PoiResult$Psrs parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (PoiResult$Psrs) new PoiResult$Psrs().mergeFrom(bArr);
    }

    public PoiResult$Psrs addSEResult(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        if (this.f14155c.isEmpty()) {
            this.f14155c = new ArrayList();
        }
        this.f14155c.add(str);
        return this;
    }

    public final PoiResult$Psrs clear() {
        clearSENum();
        clearSEResult();
        this.f14156d = -1;
        return this;
    }

    public PoiResult$Psrs clearSENum() {
        this.f14153a = false;
        this.f14154b = 0;
        return this;
    }

    public PoiResult$Psrs clearSEResult() {
        this.f14155c = Collections.emptyList();
        return this;
    }

    public int getCachedSize() {
        if (this.f14156d < 0) {
            getSerializedSize();
        }
        return this.f14156d;
    }

    public int getSENum() {
        return this.f14154b;
    }

    public String getSEResult(int i) {
        return (String) this.f14155c.get(i);
    }

    public int getSEResultCount() {
        return this.f14155c.size();
    }

    public List<String> getSEResultList() {
        return this.f14155c;
    }

    public int getSerializedSize() {
        int i = 0;
        int computeInt32Size = hasSENum() ? CodedOutputStreamMicro.computeInt32Size(1, getSENum()) + 0 : 0;
        for (String computeStringSizeNoTag : getSEResultList()) {
            i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag);
        }
        int size = (computeInt32Size + i) + (getSEResultList().size() * 1);
        this.f14156d = size;
        return size;
    }

    public boolean hasSENum() {
        return this.f14153a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public PoiResult$Psrs mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    setSENum(codedInputStreamMicro.readInt32());
                    continue;
                case 18:
                    addSEResult(codedInputStreamMicro.readString());
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

    public PoiResult$Psrs setSENum(int i) {
        this.f14153a = true;
        this.f14154b = i;
        return this;
    }

    public PoiResult$Psrs setSEResult(int i, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f14155c.set(i, str);
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasSENum()) {
            codedOutputStreamMicro.writeInt32(1, getSENum());
        }
        for (String writeString : getSEResultList()) {
            codedOutputStreamMicro.writeString(2, writeString);
        }
    }
}
