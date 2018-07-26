package com.baidu.entity.pb;

import com.baidu.carlife.core.C1253f;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class PoiResult$Option extends MessageMicro {
    public static final int CITY_REGION_FIELD_NUMBER = 18;
    public static final int DISP_ATTR_FIELD_NUMBER = 16;
    public static final int LANDMARK_FLAG_FIELD_NUMBER = 13;
    public static final int LBS_DIRECT_FLAG_FIELD_NUMBER = 15;
    public static final int LDATA_FIELD_NUMBER = 14;
    public static final int LIST_THIRDKING_FLAG_FIELD_NUMBER = 12;
    public static final int LOC_ATTR_FIELD_NUMBER = 2;
    public static final int OP_ADDR_FIELD_NUMBER = 4;
    public static final int OP_GEL_FIELD_NUMBER = 3;
    public static final int QID_FIELD_NUMBER = 6;
    public static final int REGION_TYPE_FIELD_NUMBER = 17;
    public static final int RES_BOUND_ACC_FIELD_NUMBER = 9;
    public static final int RES_BOUND_FIELD_NUMBER = 8;
    public static final int RES_X_FIELD_NUMBER = 10;
    public static final int RES_Y_FIELD_NUMBER = 11;
    public static final int RP_STRATEGY_FIELD_NUMBER = 5;
    public static final int TOTAL_BUSLINE_NUM_FIELD_NUMBER = 7;
    public static final int TOTAL_FIELD_NUMBER = 1;
    /* renamed from: A */
    private boolean f14064A;
    /* renamed from: B */
    private String f14065B = "";
    /* renamed from: C */
    private boolean f14066C;
    /* renamed from: D */
    private String f14067D = "";
    /* renamed from: E */
    private boolean f14068E;
    /* renamed from: F */
    private int f14069F = 0;
    /* renamed from: G */
    private boolean f14070G;
    /* renamed from: H */
    private String f14071H = "";
    /* renamed from: I */
    private boolean f14072I;
    /* renamed from: J */
    private String f14073J = "";
    /* renamed from: K */
    private int f14074K = -1;
    /* renamed from: a */
    private boolean f14075a;
    /* renamed from: b */
    private int f14076b = 0;
    /* renamed from: c */
    private boolean f14077c;
    /* renamed from: d */
    private int f14078d = 0;
    /* renamed from: e */
    private boolean f14079e;
    /* renamed from: f */
    private boolean f14080f = false;
    /* renamed from: g */
    private boolean f14081g;
    /* renamed from: h */
    private boolean f14082h = false;
    /* renamed from: i */
    private boolean f14083i;
    /* renamed from: j */
    private int f14084j = 0;
    /* renamed from: k */
    private boolean f14085k;
    /* renamed from: l */
    private String f14086l = "";
    /* renamed from: m */
    private boolean f14087m;
    /* renamed from: n */
    private int f14088n = 0;
    /* renamed from: o */
    private boolean f14089o;
    /* renamed from: p */
    private String f14090p = "";
    /* renamed from: q */
    private boolean f14091q;
    /* renamed from: r */
    private String f14092r = "";
    /* renamed from: s */
    private boolean f14093s;
    /* renamed from: t */
    private String f14094t = "";
    /* renamed from: u */
    private boolean f14095u;
    /* renamed from: v */
    private String f14096v = "";
    /* renamed from: w */
    private boolean f14097w;
    /* renamed from: x */
    private int f14098x = 0;
    /* renamed from: y */
    private boolean f14099y;
    /* renamed from: z */
    private String f14100z = "";

    public static PoiResult$Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new PoiResult$Option().mergeFrom(codedInputStreamMicro);
    }

    public static PoiResult$Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (PoiResult$Option) new PoiResult$Option().mergeFrom(bArr);
    }

    public final PoiResult$Option clear() {
        clearTotal();
        clearLocAttr();
        clearOpGel();
        clearOpAddr();
        clearRpStrategy();
        clearQid();
        clearTotalBuslineNum();
        clearResBound();
        clearResBoundAcc();
        clearResX();
        clearResY();
        clearListThirdkingFlag();
        clearLandmarkFlag();
        clearLdata();
        clearLbsDirectFlag();
        clearDispAttr();
        clearRegionType();
        clearCityRegion();
        this.f14074K = -1;
        return this;
    }

    public PoiResult$Option clearCityRegion() {
        this.f14072I = false;
        this.f14073J = "";
        return this;
    }

    public PoiResult$Option clearDispAttr() {
        this.f14068E = false;
        this.f14069F = 0;
        return this;
    }

    public PoiResult$Option clearLandmarkFlag() {
        this.f14099y = false;
        this.f14100z = "";
        return this;
    }

    public PoiResult$Option clearLbsDirectFlag() {
        this.f14066C = false;
        this.f14067D = "";
        return this;
    }

    public PoiResult$Option clearLdata() {
        this.f14064A = false;
        this.f14065B = "";
        return this;
    }

    public PoiResult$Option clearListThirdkingFlag() {
        this.f14097w = false;
        this.f14098x = 0;
        return this;
    }

    public PoiResult$Option clearLocAttr() {
        this.f14077c = false;
        this.f14078d = 0;
        return this;
    }

    public PoiResult$Option clearOpAddr() {
        this.f14081g = false;
        this.f14082h = false;
        return this;
    }

    public PoiResult$Option clearOpGel() {
        this.f14079e = false;
        this.f14080f = false;
        return this;
    }

    public PoiResult$Option clearQid() {
        this.f14085k = false;
        this.f14086l = "";
        return this;
    }

    public PoiResult$Option clearRegionType() {
        this.f14070G = false;
        this.f14071H = "";
        return this;
    }

    public PoiResult$Option clearResBound() {
        this.f14089o = false;
        this.f14090p = "";
        return this;
    }

    public PoiResult$Option clearResBoundAcc() {
        this.f14091q = false;
        this.f14092r = "";
        return this;
    }

    public PoiResult$Option clearResX() {
        this.f14093s = false;
        this.f14094t = "";
        return this;
    }

    public PoiResult$Option clearResY() {
        this.f14095u = false;
        this.f14096v = "";
        return this;
    }

    public PoiResult$Option clearRpStrategy() {
        this.f14083i = false;
        this.f14084j = 0;
        return this;
    }

    public PoiResult$Option clearTotal() {
        this.f14075a = false;
        this.f14076b = 0;
        return this;
    }

    public PoiResult$Option clearTotalBuslineNum() {
        this.f14087m = false;
        this.f14088n = 0;
        return this;
    }

    public int getCachedSize() {
        if (this.f14074K < 0) {
            getSerializedSize();
        }
        return this.f14074K;
    }

    public String getCityRegion() {
        return this.f14073J;
    }

    public int getDispAttr() {
        return this.f14069F;
    }

    public String getLandmarkFlag() {
        return this.f14100z;
    }

    public String getLbsDirectFlag() {
        return this.f14067D;
    }

    public String getLdata() {
        return this.f14065B;
    }

    public int getListThirdkingFlag() {
        return this.f14098x;
    }

    public int getLocAttr() {
        return this.f14078d;
    }

    public boolean getOpAddr() {
        return this.f14082h;
    }

    public boolean getOpGel() {
        return this.f14080f;
    }

    public String getQid() {
        return this.f14086l;
    }

    public String getRegionType() {
        return this.f14071H;
    }

    public String getResBound() {
        return this.f14090p;
    }

    public String getResBoundAcc() {
        return this.f14092r;
    }

    public String getResX() {
        return this.f14094t;
    }

    public String getResY() {
        return this.f14096v;
    }

    public int getRpStrategy() {
        return this.f14084j;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasTotal()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getTotal());
        }
        if (hasLocAttr()) {
            i += CodedOutputStreamMicro.computeInt32Size(2, getLocAttr());
        }
        if (hasOpGel()) {
            i += CodedOutputStreamMicro.computeBoolSize(3, getOpGel());
        }
        if (hasOpAddr()) {
            i += CodedOutputStreamMicro.computeBoolSize(4, getOpAddr());
        }
        if (hasRpStrategy()) {
            i += CodedOutputStreamMicro.computeInt32Size(5, getRpStrategy());
        }
        if (hasQid()) {
            i += CodedOutputStreamMicro.computeStringSize(6, getQid());
        }
        if (hasTotalBuslineNum()) {
            i += CodedOutputStreamMicro.computeInt32Size(7, getTotalBuslineNum());
        }
        if (hasResBound()) {
            i += CodedOutputStreamMicro.computeStringSize(8, getResBound());
        }
        if (hasResBoundAcc()) {
            i += CodedOutputStreamMicro.computeStringSize(9, getResBoundAcc());
        }
        if (hasResX()) {
            i += CodedOutputStreamMicro.computeStringSize(10, getResX());
        }
        if (hasResY()) {
            i += CodedOutputStreamMicro.computeStringSize(11, getResY());
        }
        if (hasListThirdkingFlag()) {
            i += CodedOutputStreamMicro.computeInt32Size(12, getListThirdkingFlag());
        }
        if (hasLandmarkFlag()) {
            i += CodedOutputStreamMicro.computeStringSize(13, getLandmarkFlag());
        }
        if (hasLdata()) {
            i += CodedOutputStreamMicro.computeStringSize(14, getLdata());
        }
        if (hasLbsDirectFlag()) {
            i += CodedOutputStreamMicro.computeStringSize(15, getLbsDirectFlag());
        }
        if (hasDispAttr()) {
            i += CodedOutputStreamMicro.computeInt32Size(16, getDispAttr());
        }
        if (hasRegionType()) {
            i += CodedOutputStreamMicro.computeStringSize(17, getRegionType());
        }
        if (hasCityRegion()) {
            i += CodedOutputStreamMicro.computeStringSize(18, getCityRegion());
        }
        this.f14074K = i;
        return i;
    }

    public int getTotal() {
        return this.f14076b;
    }

    public int getTotalBuslineNum() {
        return this.f14088n;
    }

    public boolean hasCityRegion() {
        return this.f14072I;
    }

    public boolean hasDispAttr() {
        return this.f14068E;
    }

    public boolean hasLandmarkFlag() {
        return this.f14099y;
    }

    public boolean hasLbsDirectFlag() {
        return this.f14066C;
    }

    public boolean hasLdata() {
        return this.f14064A;
    }

    public boolean hasListThirdkingFlag() {
        return this.f14097w;
    }

    public boolean hasLocAttr() {
        return this.f14077c;
    }

    public boolean hasOpAddr() {
        return this.f14081g;
    }

    public boolean hasOpGel() {
        return this.f14079e;
    }

    public boolean hasQid() {
        return this.f14085k;
    }

    public boolean hasRegionType() {
        return this.f14070G;
    }

    public boolean hasResBound() {
        return this.f14089o;
    }

    public boolean hasResBoundAcc() {
        return this.f14091q;
    }

    public boolean hasResX() {
        return this.f14093s;
    }

    public boolean hasResY() {
        return this.f14095u;
    }

    public boolean hasRpStrategy() {
        return this.f14083i;
    }

    public boolean hasTotal() {
        return this.f14075a;
    }

    public boolean hasTotalBuslineNum() {
        return this.f14087m;
    }

    public final boolean isInitialized() {
        return true;
    }

    public PoiResult$Option mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    setTotal(codedInputStreamMicro.readInt32());
                    continue;
                case 16:
                    setLocAttr(codedInputStreamMicro.readInt32());
                    continue;
                case 24:
                    setOpGel(codedInputStreamMicro.readBool());
                    continue;
                case 32:
                    setOpAddr(codedInputStreamMicro.readBool());
                    continue;
                case 40:
                    setRpStrategy(codedInputStreamMicro.readInt32());
                    continue;
                case 50:
                    setQid(codedInputStreamMicro.readString());
                    continue;
                case 56:
                    setTotalBuslineNum(codedInputStreamMicro.readInt32());
                    continue;
                case 66:
                    setResBound(codedInputStreamMicro.readString());
                    continue;
                case 74:
                    setResBoundAcc(codedInputStreamMicro.readString());
                    continue;
                case 82:
                    setResX(codedInputStreamMicro.readString());
                    continue;
                case 90:
                    setResY(codedInputStreamMicro.readString());
                    continue;
                case 96:
                    setListThirdkingFlag(codedInputStreamMicro.readInt32());
                    continue;
                case 106:
                    setLandmarkFlag(codedInputStreamMicro.readString());
                    continue;
                case 114:
                    setLdata(codedInputStreamMicro.readString());
                    continue;
                case C1253f.df /*122*/:
                    setLbsDirectFlag(codedInputStreamMicro.readString());
                    continue;
                case 128:
                    setDispAttr(codedInputStreamMicro.readInt32());
                    continue;
                case 138:
                    setRegionType(codedInputStreamMicro.readString());
                    continue;
                case 146:
                    setCityRegion(codedInputStreamMicro.readString());
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

    public PoiResult$Option setCityRegion(String str) {
        this.f14072I = true;
        this.f14073J = str;
        return this;
    }

    public PoiResult$Option setDispAttr(int i) {
        this.f14068E = true;
        this.f14069F = i;
        return this;
    }

    public PoiResult$Option setLandmarkFlag(String str) {
        this.f14099y = true;
        this.f14100z = str;
        return this;
    }

    public PoiResult$Option setLbsDirectFlag(String str) {
        this.f14066C = true;
        this.f14067D = str;
        return this;
    }

    public PoiResult$Option setLdata(String str) {
        this.f14064A = true;
        this.f14065B = str;
        return this;
    }

    public PoiResult$Option setListThirdkingFlag(int i) {
        this.f14097w = true;
        this.f14098x = i;
        return this;
    }

    public PoiResult$Option setLocAttr(int i) {
        this.f14077c = true;
        this.f14078d = i;
        return this;
    }

    public PoiResult$Option setOpAddr(boolean z) {
        this.f14081g = true;
        this.f14082h = z;
        return this;
    }

    public PoiResult$Option setOpGel(boolean z) {
        this.f14079e = true;
        this.f14080f = z;
        return this;
    }

    public PoiResult$Option setQid(String str) {
        this.f14085k = true;
        this.f14086l = str;
        return this;
    }

    public PoiResult$Option setRegionType(String str) {
        this.f14070G = true;
        this.f14071H = str;
        return this;
    }

    public PoiResult$Option setResBound(String str) {
        this.f14089o = true;
        this.f14090p = str;
        return this;
    }

    public PoiResult$Option setResBoundAcc(String str) {
        this.f14091q = true;
        this.f14092r = str;
        return this;
    }

    public PoiResult$Option setResX(String str) {
        this.f14093s = true;
        this.f14094t = str;
        return this;
    }

    public PoiResult$Option setResY(String str) {
        this.f14095u = true;
        this.f14096v = str;
        return this;
    }

    public PoiResult$Option setRpStrategy(int i) {
        this.f14083i = true;
        this.f14084j = i;
        return this;
    }

    public PoiResult$Option setTotal(int i) {
        this.f14075a = true;
        this.f14076b = i;
        return this;
    }

    public PoiResult$Option setTotalBuslineNum(int i) {
        this.f14087m = true;
        this.f14088n = i;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasTotal()) {
            codedOutputStreamMicro.writeInt32(1, getTotal());
        }
        if (hasLocAttr()) {
            codedOutputStreamMicro.writeInt32(2, getLocAttr());
        }
        if (hasOpGel()) {
            codedOutputStreamMicro.writeBool(3, getOpGel());
        }
        if (hasOpAddr()) {
            codedOutputStreamMicro.writeBool(4, getOpAddr());
        }
        if (hasRpStrategy()) {
            codedOutputStreamMicro.writeInt32(5, getRpStrategy());
        }
        if (hasQid()) {
            codedOutputStreamMicro.writeString(6, getQid());
        }
        if (hasTotalBuslineNum()) {
            codedOutputStreamMicro.writeInt32(7, getTotalBuslineNum());
        }
        if (hasResBound()) {
            codedOutputStreamMicro.writeString(8, getResBound());
        }
        if (hasResBoundAcc()) {
            codedOutputStreamMicro.writeString(9, getResBoundAcc());
        }
        if (hasResX()) {
            codedOutputStreamMicro.writeString(10, getResX());
        }
        if (hasResY()) {
            codedOutputStreamMicro.writeString(11, getResY());
        }
        if (hasListThirdkingFlag()) {
            codedOutputStreamMicro.writeInt32(12, getListThirdkingFlag());
        }
        if (hasLandmarkFlag()) {
            codedOutputStreamMicro.writeString(13, getLandmarkFlag());
        }
        if (hasLdata()) {
            codedOutputStreamMicro.writeString(14, getLdata());
        }
        if (hasLbsDirectFlag()) {
            codedOutputStreamMicro.writeString(15, getLbsDirectFlag());
        }
        if (hasDispAttr()) {
            codedOutputStreamMicro.writeInt32(16, getDispAttr());
        }
        if (hasRegionType()) {
            codedOutputStreamMicro.writeString(17, getRegionType());
        }
        if (hasCityRegion()) {
            codedOutputStreamMicro.writeString(18, getCityRegion());
        }
    }
}
