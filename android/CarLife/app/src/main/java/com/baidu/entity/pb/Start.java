package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class Start extends MessageMicro {
    public static final int ADDR_FIELD_NUMBER = 5;
    public static final int CODE_FIELD_NUMBER = 1;
    public static final int DESCRIBE_FIELD_NUMBER = 9;
    public static final int GEO_FIELD_NUMBER = 6;
    public static final int INDOOR_FLOOR_FIELD_NUMBER = 7;
    public static final int INDOOR_PARENT_UID_FIELD_NUMBER = 8;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int NUM_FIELD_NUMBER = 3;
    public static final int UID_FIELD_NUMBER = 4;
    /* renamed from: a */
    private boolean f14652a;
    /* renamed from: b */
    private int f14653b = 0;
    /* renamed from: c */
    private boolean f14654c;
    /* renamed from: d */
    private String f14655d = "";
    /* renamed from: e */
    private boolean f14656e;
    /* renamed from: f */
    private int f14657f = 0;
    /* renamed from: g */
    private boolean f14658g;
    /* renamed from: h */
    private String f14659h = "";
    /* renamed from: i */
    private boolean f14660i;
    /* renamed from: j */
    private String f14661j = "";
    /* renamed from: k */
    private boolean f14662k;
    /* renamed from: l */
    private String f14663l = "";
    /* renamed from: m */
    private boolean f14664m;
    /* renamed from: n */
    private String f14665n = "";
    /* renamed from: o */
    private boolean f14666o;
    /* renamed from: p */
    private String f14667p = "";
    /* renamed from: q */
    private boolean f14668q;
    /* renamed from: r */
    private String f14669r = "";
    /* renamed from: s */
    private int f14670s = -1;

    public static Start parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Start().mergeFrom(codedInputStreamMicro);
    }

    public static Start parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Start) new Start().mergeFrom(bArr);
    }

    public final Start clear() {
        clearCode();
        clearName();
        clearNum();
        clearUid();
        clearAddr();
        clearGeo();
        clearIndoorFloor();
        clearIndoorParentUid();
        clearDescribe();
        this.f14670s = -1;
        return this;
    }

    public Start clearAddr() {
        this.f14660i = false;
        this.f14661j = "";
        return this;
    }

    public Start clearCode() {
        this.f14652a = false;
        this.f14653b = 0;
        return this;
    }

    public Start clearDescribe() {
        this.f14668q = false;
        this.f14669r = "";
        return this;
    }

    public Start clearGeo() {
        this.f14662k = false;
        this.f14663l = "";
        return this;
    }

    public Start clearIndoorFloor() {
        this.f14664m = false;
        this.f14665n = "";
        return this;
    }

    public Start clearIndoorParentUid() {
        this.f14666o = false;
        this.f14667p = "";
        return this;
    }

    public Start clearName() {
        this.f14654c = false;
        this.f14655d = "";
        return this;
    }

    public Start clearNum() {
        this.f14656e = false;
        this.f14657f = 0;
        return this;
    }

    public Start clearUid() {
        this.f14658g = false;
        this.f14659h = "";
        return this;
    }

    public String getAddr() {
        return this.f14661j;
    }

    public int getCachedSize() {
        if (this.f14670s < 0) {
            getSerializedSize();
        }
        return this.f14670s;
    }

    public int getCode() {
        return this.f14653b;
    }

    public String getDescribe() {
        return this.f14669r;
    }

    public String getGeo() {
        return this.f14663l;
    }

    public String getIndoorFloor() {
        return this.f14665n;
    }

    public String getIndoorParentUid() {
        return this.f14667p;
    }

    public String getName() {
        return this.f14655d;
    }

    public int getNum() {
        return this.f14657f;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasCode()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
        }
        if (hasName()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getName());
        }
        if (hasNum()) {
            i += CodedOutputStreamMicro.computeInt32Size(3, getNum());
        }
        if (hasUid()) {
            i += CodedOutputStreamMicro.computeStringSize(4, getUid());
        }
        if (hasAddr()) {
            i += CodedOutputStreamMicro.computeStringSize(5, getAddr());
        }
        if (hasGeo()) {
            i += CodedOutputStreamMicro.computeStringSize(6, getGeo());
        }
        if (hasIndoorFloor()) {
            i += CodedOutputStreamMicro.computeStringSize(7, getIndoorFloor());
        }
        if (hasIndoorParentUid()) {
            i += CodedOutputStreamMicro.computeStringSize(8, getIndoorParentUid());
        }
        if (hasDescribe()) {
            i += CodedOutputStreamMicro.computeStringSize(9, getDescribe());
        }
        this.f14670s = i;
        return i;
    }

    public String getUid() {
        return this.f14659h;
    }

    public boolean hasAddr() {
        return this.f14660i;
    }

    public boolean hasCode() {
        return this.f14652a;
    }

    public boolean hasDescribe() {
        return this.f14668q;
    }

    public boolean hasGeo() {
        return this.f14662k;
    }

    public boolean hasIndoorFloor() {
        return this.f14664m;
    }

    public boolean hasIndoorParentUid() {
        return this.f14666o;
    }

    public boolean hasName() {
        return this.f14654c;
    }

    public boolean hasNum() {
        return this.f14656e;
    }

    public boolean hasUid() {
        return this.f14658g;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Start mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                case 24:
                    setNum(codedInputStreamMicro.readInt32());
                    continue;
                case 34:
                    setUid(codedInputStreamMicro.readString());
                    continue;
                case 42:
                    setAddr(codedInputStreamMicro.readString());
                    continue;
                case 50:
                    setGeo(codedInputStreamMicro.readString());
                    continue;
                case 58:
                    setIndoorFloor(codedInputStreamMicro.readString());
                    continue;
                case 66:
                    setIndoorParentUid(codedInputStreamMicro.readString());
                    continue;
                case 74:
                    setDescribe(codedInputStreamMicro.readString());
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

    public Start setAddr(String str) {
        this.f14660i = true;
        this.f14661j = str;
        return this;
    }

    public Start setCode(int i) {
        this.f14652a = true;
        this.f14653b = i;
        return this;
    }

    public Start setDescribe(String str) {
        this.f14668q = true;
        this.f14669r = str;
        return this;
    }

    public Start setGeo(String str) {
        this.f14662k = true;
        this.f14663l = str;
        return this;
    }

    public Start setIndoorFloor(String str) {
        this.f14664m = true;
        this.f14665n = str;
        return this;
    }

    public Start setIndoorParentUid(String str) {
        this.f14666o = true;
        this.f14667p = str;
        return this;
    }

    public Start setName(String str) {
        this.f14654c = true;
        this.f14655d = str;
        return this;
    }

    public Start setNum(int i) {
        this.f14656e = true;
        this.f14657f = i;
        return this;
    }

    public Start setUid(String str) {
        this.f14658g = true;
        this.f14659h = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasCode()) {
            codedOutputStreamMicro.writeInt32(1, getCode());
        }
        if (hasName()) {
            codedOutputStreamMicro.writeString(2, getName());
        }
        if (hasNum()) {
            codedOutputStreamMicro.writeInt32(3, getNum());
        }
        if (hasUid()) {
            codedOutputStreamMicro.writeString(4, getUid());
        }
        if (hasAddr()) {
            codedOutputStreamMicro.writeString(5, getAddr());
        }
        if (hasGeo()) {
            codedOutputStreamMicro.writeString(6, getGeo());
        }
        if (hasIndoorFloor()) {
            codedOutputStreamMicro.writeString(7, getIndoorFloor());
        }
        if (hasIndoorParentUid()) {
            codedOutputStreamMicro.writeString(8, getIndoorParentUid());
        }
        if (hasDescribe()) {
            codedOutputStreamMicro.writeString(9, getDescribe());
        }
    }
}
