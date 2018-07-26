package com.baidu.entity.pb;

import com.baidu.baidunavis.model.NavCarInfo;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class WayPoints extends MessageMicro {
    public static final int ADDR_FIELD_NUMBER = 5;
    public static final int CODE_FIELD_NUMBER = 1;
    public static final int DESCRIBE_FIELD_NUMBER = 11;
    public static final int DIRECTION_FIELD_NUMBER = 10;
    public static final int DIST_FIELD_NUMBER = 9;
    public static final int GEO_FIELD_NUMBER = 6;
    public static final int INDOOR_FLOOR_FIELD_NUMBER = 7;
    public static final int INDOOR_PARENT_UID_FIELD_NUMBER = 8;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int NUM_FIELD_NUMBER = 3;
    public static final int UID_FIELD_NUMBER = 4;
    /* renamed from: a */
    private boolean f17083a;
    /* renamed from: b */
    private int f17084b = 0;
    /* renamed from: c */
    private boolean f17085c;
    /* renamed from: d */
    private String f17086d = "";
    /* renamed from: e */
    private boolean f17087e;
    /* renamed from: f */
    private int f17088f = 0;
    /* renamed from: g */
    private boolean f17089g;
    /* renamed from: h */
    private String f17090h = "";
    /* renamed from: i */
    private boolean f17091i;
    /* renamed from: j */
    private String f17092j = "";
    /* renamed from: k */
    private boolean f17093k;
    /* renamed from: l */
    private String f17094l = "";
    /* renamed from: m */
    private boolean f17095m;
    /* renamed from: n */
    private String f17096n = "";
    /* renamed from: o */
    private boolean f17097o;
    /* renamed from: p */
    private String f17098p = "";
    /* renamed from: q */
    private boolean f17099q;
    /* renamed from: r */
    private int f17100r = 0;
    /* renamed from: s */
    private boolean f17101s;
    /* renamed from: t */
    private int f17102t = 0;
    /* renamed from: u */
    private boolean f17103u;
    /* renamed from: v */
    private String f17104v = "";
    /* renamed from: w */
    private int f17105w = -1;

    public static WayPoints parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new WayPoints().mergeFrom(codedInputStreamMicro);
    }

    public static WayPoints parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (WayPoints) new WayPoints().mergeFrom(bArr);
    }

    public final WayPoints clear() {
        clearCode();
        clearName();
        clearNum();
        clearUid();
        clearAddr();
        clearGeo();
        clearIndoorFloor();
        clearIndoorParentUid();
        clearDist();
        clearDirection();
        clearDescribe();
        this.f17105w = -1;
        return this;
    }

    public WayPoints clearAddr() {
        this.f17091i = false;
        this.f17092j = "";
        return this;
    }

    public WayPoints clearCode() {
        this.f17083a = false;
        this.f17084b = 0;
        return this;
    }

    public WayPoints clearDescribe() {
        this.f17103u = false;
        this.f17104v = "";
        return this;
    }

    public WayPoints clearDirection() {
        this.f17101s = false;
        this.f17102t = 0;
        return this;
    }

    public WayPoints clearDist() {
        this.f17099q = false;
        this.f17100r = 0;
        return this;
    }

    public WayPoints clearGeo() {
        this.f17093k = false;
        this.f17094l = "";
        return this;
    }

    public WayPoints clearIndoorFloor() {
        this.f17095m = false;
        this.f17096n = "";
        return this;
    }

    public WayPoints clearIndoorParentUid() {
        this.f17097o = false;
        this.f17098p = "";
        return this;
    }

    public WayPoints clearName() {
        this.f17085c = false;
        this.f17086d = "";
        return this;
    }

    public WayPoints clearNum() {
        this.f17087e = false;
        this.f17088f = 0;
        return this;
    }

    public WayPoints clearUid() {
        this.f17089g = false;
        this.f17090h = "";
        return this;
    }

    public String getAddr() {
        return this.f17092j;
    }

    public int getCachedSize() {
        if (this.f17105w < 0) {
            getSerializedSize();
        }
        return this.f17105w;
    }

    public int getCode() {
        return this.f17084b;
    }

    public String getDescribe() {
        return this.f17104v;
    }

    public int getDirection() {
        return this.f17102t;
    }

    public int getDist() {
        return this.f17100r;
    }

    public String getGeo() {
        return this.f17094l;
    }

    public String getIndoorFloor() {
        return this.f17096n;
    }

    public String getIndoorParentUid() {
        return this.f17098p;
    }

    public String getName() {
        return this.f17086d;
    }

    public int getNum() {
        return this.f17088f;
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
        if (hasDist()) {
            i += CodedOutputStreamMicro.computeInt32Size(9, getDist());
        }
        if (hasDirection()) {
            i += CodedOutputStreamMicro.computeInt32Size(10, getDirection());
        }
        if (hasDescribe()) {
            i += CodedOutputStreamMicro.computeStringSize(11, getDescribe());
        }
        this.f17105w = i;
        return i;
    }

    public String getUid() {
        return this.f17090h;
    }

    public boolean hasAddr() {
        return this.f17091i;
    }

    public boolean hasCode() {
        return this.f17083a;
    }

    public boolean hasDescribe() {
        return this.f17103u;
    }

    public boolean hasDirection() {
        return this.f17101s;
    }

    public boolean hasDist() {
        return this.f17099q;
    }

    public boolean hasGeo() {
        return this.f17093k;
    }

    public boolean hasIndoorFloor() {
        return this.f17095m;
    }

    public boolean hasIndoorParentUid() {
        return this.f17097o;
    }

    public boolean hasName() {
        return this.f17085c;
    }

    public boolean hasNum() {
        return this.f17087e;
    }

    public boolean hasUid() {
        return this.f17089g;
    }

    public final boolean isInitialized() {
        return true;
    }

    public WayPoints mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                case NavCarInfo.CarType_57L /*72*/:
                    setDist(codedInputStreamMicro.readInt32());
                    continue;
                case 80:
                    setDirection(codedInputStreamMicro.readInt32());
                    continue;
                case 90:
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

    public WayPoints setAddr(String str) {
        this.f17091i = true;
        this.f17092j = str;
        return this;
    }

    public WayPoints setCode(int i) {
        this.f17083a = true;
        this.f17084b = i;
        return this;
    }

    public WayPoints setDescribe(String str) {
        this.f17103u = true;
        this.f17104v = str;
        return this;
    }

    public WayPoints setDirection(int i) {
        this.f17101s = true;
        this.f17102t = i;
        return this;
    }

    public WayPoints setDist(int i) {
        this.f17099q = true;
        this.f17100r = i;
        return this;
    }

    public WayPoints setGeo(String str) {
        this.f17093k = true;
        this.f17094l = str;
        return this;
    }

    public WayPoints setIndoorFloor(String str) {
        this.f17095m = true;
        this.f17096n = str;
        return this;
    }

    public WayPoints setIndoorParentUid(String str) {
        this.f17097o = true;
        this.f17098p = str;
        return this;
    }

    public WayPoints setName(String str) {
        this.f17085c = true;
        this.f17086d = str;
        return this;
    }

    public WayPoints setNum(int i) {
        this.f17087e = true;
        this.f17088f = i;
        return this;
    }

    public WayPoints setUid(String str) {
        this.f17089g = true;
        this.f17090h = str;
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
        if (hasDist()) {
            codedOutputStreamMicro.writeInt32(9, getDist());
        }
        if (hasDirection()) {
            codedOutputStreamMicro.writeInt32(10, getDirection());
        }
        if (hasDescribe()) {
            codedOutputStreamMicro.writeString(11, getDescribe());
        }
    }
}
