package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class End extends MessageMicro {
    public static final int ADDR_FIELD_NUMBER = 5;
    public static final int CODE_FIELD_NUMBER = 1;
    public static final int DESCRIBE_FIELD_NUMBER = 13;
    public static final int DIRECTION_FIELD_NUMBER = 12;
    public static final int DIST_FIELD_NUMBER = 11;
    public static final int EXT_FIELD_NUMBER = 7;
    public static final int GEO_FIELD_NUMBER = 6;
    public static final int INDOOR_FLOOR_FIELD_NUMBER = 9;
    public static final int INDOOR_PARENT_UID_FIELD_NUMBER = 10;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int NUM_FIELD_NUMBER = 3;
    public static final int POITYPE_FIELD_NUMBER = 8;
    public static final int UID_FIELD_NUMBER = 4;
    /* renamed from: A */
    private int f11078A = -1;
    /* renamed from: a */
    private boolean f11079a;
    /* renamed from: b */
    private int f11080b = 0;
    /* renamed from: c */
    private boolean f11081c;
    /* renamed from: d */
    private String f11082d = "";
    /* renamed from: e */
    private boolean f11083e;
    /* renamed from: f */
    private int f11084f = 0;
    /* renamed from: g */
    private boolean f11085g;
    /* renamed from: h */
    private String f11086h = "";
    /* renamed from: i */
    private boolean f11087i;
    /* renamed from: j */
    private String f11088j = "";
    /* renamed from: k */
    private boolean f11089k;
    /* renamed from: l */
    private String f11090l = "";
    /* renamed from: m */
    private boolean f11091m;
    /* renamed from: n */
    private String f11092n = "";
    /* renamed from: o */
    private boolean f11093o;
    /* renamed from: p */
    private int f11094p = 0;
    /* renamed from: q */
    private boolean f11095q;
    /* renamed from: r */
    private String f11096r = "";
    /* renamed from: s */
    private boolean f11097s;
    /* renamed from: t */
    private String f11098t = "";
    /* renamed from: u */
    private boolean f11099u;
    /* renamed from: v */
    private int f11100v = 0;
    /* renamed from: w */
    private boolean f11101w;
    /* renamed from: x */
    private int f11102x = 0;
    /* renamed from: y */
    private boolean f11103y;
    /* renamed from: z */
    private String f11104z = "";

    public static End parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new End().mergeFrom(codedInputStreamMicro);
    }

    public static End parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (End) new End().mergeFrom(bArr);
    }

    public final End clear() {
        clearCode();
        clearName();
        clearNum();
        clearUid();
        clearAddr();
        clearGeo();
        clearExt();
        clearPoiType();
        clearIndoorFloor();
        clearIndoorParentUid();
        clearDist();
        clearDirection();
        clearDescribe();
        this.f11078A = -1;
        return this;
    }

    public End clearAddr() {
        this.f11087i = false;
        this.f11088j = "";
        return this;
    }

    public End clearCode() {
        this.f11079a = false;
        this.f11080b = 0;
        return this;
    }

    public End clearDescribe() {
        this.f11103y = false;
        this.f11104z = "";
        return this;
    }

    public End clearDirection() {
        this.f11101w = false;
        this.f11102x = 0;
        return this;
    }

    public End clearDist() {
        this.f11099u = false;
        this.f11100v = 0;
        return this;
    }

    public End clearExt() {
        this.f11091m = false;
        this.f11092n = "";
        return this;
    }

    public End clearGeo() {
        this.f11089k = false;
        this.f11090l = "";
        return this;
    }

    public End clearIndoorFloor() {
        this.f11095q = false;
        this.f11096r = "";
        return this;
    }

    public End clearIndoorParentUid() {
        this.f11097s = false;
        this.f11098t = "";
        return this;
    }

    public End clearName() {
        this.f11081c = false;
        this.f11082d = "";
        return this;
    }

    public End clearNum() {
        this.f11083e = false;
        this.f11084f = 0;
        return this;
    }

    public End clearPoiType() {
        this.f11093o = false;
        this.f11094p = 0;
        return this;
    }

    public End clearUid() {
        this.f11085g = false;
        this.f11086h = "";
        return this;
    }

    public String getAddr() {
        return this.f11088j;
    }

    public int getCachedSize() {
        if (this.f11078A < 0) {
            getSerializedSize();
        }
        return this.f11078A;
    }

    public int getCode() {
        return this.f11080b;
    }

    public String getDescribe() {
        return this.f11104z;
    }

    public int getDirection() {
        return this.f11102x;
    }

    public int getDist() {
        return this.f11100v;
    }

    public String getExt() {
        return this.f11092n;
    }

    public String getGeo() {
        return this.f11090l;
    }

    public String getIndoorFloor() {
        return this.f11096r;
    }

    public String getIndoorParentUid() {
        return this.f11098t;
    }

    public String getName() {
        return this.f11082d;
    }

    public int getNum() {
        return this.f11084f;
    }

    public int getPoiType() {
        return this.f11094p;
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
        if (hasExt()) {
            i += CodedOutputStreamMicro.computeStringSize(7, getExt());
        }
        if (hasPoiType()) {
            i += CodedOutputStreamMicro.computeInt32Size(8, getPoiType());
        }
        if (hasIndoorFloor()) {
            i += CodedOutputStreamMicro.computeStringSize(9, getIndoorFloor());
        }
        if (hasIndoorParentUid()) {
            i += CodedOutputStreamMicro.computeStringSize(10, getIndoorParentUid());
        }
        if (hasDist()) {
            i += CodedOutputStreamMicro.computeInt32Size(11, getDist());
        }
        if (hasDirection()) {
            i += CodedOutputStreamMicro.computeInt32Size(12, getDirection());
        }
        if (hasDescribe()) {
            i += CodedOutputStreamMicro.computeStringSize(13, getDescribe());
        }
        this.f11078A = i;
        return i;
    }

    public String getUid() {
        return this.f11086h;
    }

    public boolean hasAddr() {
        return this.f11087i;
    }

    public boolean hasCode() {
        return this.f11079a;
    }

    public boolean hasDescribe() {
        return this.f11103y;
    }

    public boolean hasDirection() {
        return this.f11101w;
    }

    public boolean hasDist() {
        return this.f11099u;
    }

    public boolean hasExt() {
        return this.f11091m;
    }

    public boolean hasGeo() {
        return this.f11089k;
    }

    public boolean hasIndoorFloor() {
        return this.f11095q;
    }

    public boolean hasIndoorParentUid() {
        return this.f11097s;
    }

    public boolean hasName() {
        return this.f11081c;
    }

    public boolean hasNum() {
        return this.f11083e;
    }

    public boolean hasPoiType() {
        return this.f11093o;
    }

    public boolean hasUid() {
        return this.f11085g;
    }

    public final boolean isInitialized() {
        return true;
    }

    public End mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                    setExt(codedInputStreamMicro.readString());
                    continue;
                case 64:
                    setPoiType(codedInputStreamMicro.readInt32());
                    continue;
                case 74:
                    setIndoorFloor(codedInputStreamMicro.readString());
                    continue;
                case 82:
                    setIndoorParentUid(codedInputStreamMicro.readString());
                    continue;
                case 88:
                    setDist(codedInputStreamMicro.readInt32());
                    continue;
                case 96:
                    setDirection(codedInputStreamMicro.readInt32());
                    continue;
                case 106:
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

    public End setAddr(String str) {
        this.f11087i = true;
        this.f11088j = str;
        return this;
    }

    public End setCode(int i) {
        this.f11079a = true;
        this.f11080b = i;
        return this;
    }

    public End setDescribe(String str) {
        this.f11103y = true;
        this.f11104z = str;
        return this;
    }

    public End setDirection(int i) {
        this.f11101w = true;
        this.f11102x = i;
        return this;
    }

    public End setDist(int i) {
        this.f11099u = true;
        this.f11100v = i;
        return this;
    }

    public End setExt(String str) {
        this.f11091m = true;
        this.f11092n = str;
        return this;
    }

    public End setGeo(String str) {
        this.f11089k = true;
        this.f11090l = str;
        return this;
    }

    public End setIndoorFloor(String str) {
        this.f11095q = true;
        this.f11096r = str;
        return this;
    }

    public End setIndoorParentUid(String str) {
        this.f11097s = true;
        this.f11098t = str;
        return this;
    }

    public End setName(String str) {
        this.f11081c = true;
        this.f11082d = str;
        return this;
    }

    public End setNum(int i) {
        this.f11083e = true;
        this.f11084f = i;
        return this;
    }

    public End setPoiType(int i) {
        this.f11093o = true;
        this.f11094p = i;
        return this;
    }

    public End setUid(String str) {
        this.f11085g = true;
        this.f11086h = str;
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
        if (hasExt()) {
            codedOutputStreamMicro.writeString(7, getExt());
        }
        if (hasPoiType()) {
            codedOutputStreamMicro.writeInt32(8, getPoiType());
        }
        if (hasIndoorFloor()) {
            codedOutputStreamMicro.writeString(9, getIndoorFloor());
        }
        if (hasIndoorParentUid()) {
            codedOutputStreamMicro.writeString(10, getIndoorParentUid());
        }
        if (hasDist()) {
            codedOutputStreamMicro.writeInt32(11, getDist());
        }
        if (hasDirection()) {
            codedOutputStreamMicro.writeInt32(12, getDirection());
        }
        if (hasDescribe()) {
            codedOutputStreamMicro.writeString(13, getDescribe());
        }
    }
}
