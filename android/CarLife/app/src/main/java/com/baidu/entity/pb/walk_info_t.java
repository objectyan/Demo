package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class walk_info_t extends MessageMicro {
    public static final int DIST_FIELD_NUMBER = 1;
    public static final int PT_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f17201a;
    /* renamed from: b */
    private int f17202b = 0;
    /* renamed from: c */
    private List<Integer> f17203c = Collections.emptyList();
    /* renamed from: d */
    private int f17204d = -1;

    public static walk_info_t parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new walk_info_t().mergeFrom(codedInputStreamMicro);
    }

    public static walk_info_t parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (walk_info_t) new walk_info_t().mergeFrom(bArr);
    }

    public walk_info_t addPt(int i) {
        if (this.f17203c.isEmpty()) {
            this.f17203c = new ArrayList();
        }
        this.f17203c.add(Integer.valueOf(i));
        return this;
    }

    public final walk_info_t clear() {
        clearDist();
        clearPt();
        this.f17204d = -1;
        return this;
    }

    public walk_info_t clearDist() {
        this.f17201a = false;
        this.f17202b = 0;
        return this;
    }

    public walk_info_t clearPt() {
        this.f17203c = Collections.emptyList();
        return this;
    }

    public int getCachedSize() {
        if (this.f17204d < 0) {
            getSerializedSize();
        }
        return this.f17204d;
    }

    public int getDist() {
        return this.f17202b;
    }

    public int getPt(int i) {
        return ((Integer) this.f17203c.get(i)).intValue();
    }

    public int getPtCount() {
        return this.f17203c.size();
    }

    public List<Integer> getPtList() {
        return this.f17203c;
    }

    public int getSerializedSize() {
        int i = 0;
        int computeInt32Size = hasDist() ? CodedOutputStreamMicro.computeInt32Size(1, getDist()) + 0 : 0;
        for (Integer intValue : getPtList()) {
            i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue());
        }
        int size = (computeInt32Size + i) + (getPtList().size() * 1);
        this.f17204d = size;
        return size;
    }

    public boolean hasDist() {
        return this.f17201a;
    }

    public final boolean isInitialized() {
        return this.f17201a;
    }

    public walk_info_t mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    setDist(codedInputStreamMicro.readInt32());
                    continue;
                case 16:
                    addPt(codedInputStreamMicro.readSInt32());
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

    public walk_info_t setDist(int i) {
        this.f17201a = true;
        this.f17202b = i;
        return this;
    }

    public walk_info_t setPt(int i, int i2) {
        this.f17203c.set(i, Integer.valueOf(i2));
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasDist()) {
            codedOutputStreamMicro.writeInt32(1, getDist());
        }
        for (Integer intValue : getPtList()) {
            codedOutputStreamMicro.writeSInt32(2, intValue.intValue());
        }
    }
}
