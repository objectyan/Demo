package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class Position_Info extends MessageMicro {
    public static final int CITYID_FIELD_NUMBER = 4;
    public static final int CNAME_FIELD_NUMBER = 5;
    public static final int EXT_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 7;
    public static final int SHOWYX_FIELD_NUMBER = 6;
    public static final int UID_FIELD_NUMBER = 2;
    public static final int YX_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f14176a;
    /* renamed from: b */
    private ByteStringMicro f14177b = ByteStringMicro.EMPTY;
    /* renamed from: c */
    private boolean f14178c;
    /* renamed from: d */
    private ByteStringMicro f14179d = ByteStringMicro.EMPTY;
    /* renamed from: e */
    private boolean f14180e;
    /* renamed from: f */
    private String f14181f = "";
    /* renamed from: g */
    private boolean f14182g;
    /* renamed from: h */
    private int f14183h = 0;
    /* renamed from: i */
    private boolean f14184i;
    /* renamed from: j */
    private String f14185j = "";
    /* renamed from: k */
    private boolean f14186k;
    /* renamed from: l */
    private ByteStringMicro f14187l = ByteStringMicro.EMPTY;
    /* renamed from: m */
    private boolean f14188m;
    /* renamed from: n */
    private ByteStringMicro f14189n = ByteStringMicro.EMPTY;
    /* renamed from: o */
    private int f14190o = -1;

    public static Position_Info parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Position_Info().mergeFrom(codedInputStreamMicro);
    }

    public static Position_Info parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Position_Info) new Position_Info().mergeFrom(bArr);
    }

    public final Position_Info clear() {
        clearYx();
        clearUid();
        clearExt();
        clearCityid();
        clearCname();
        clearShowyx();
        clearName();
        this.f14190o = -1;
        return this;
    }

    public Position_Info clearCityid() {
        this.f14182g = false;
        this.f14183h = 0;
        return this;
    }

    public Position_Info clearCname() {
        this.f14184i = false;
        this.f14185j = "";
        return this;
    }

    public Position_Info clearExt() {
        this.f14180e = false;
        this.f14181f = "";
        return this;
    }

    public Position_Info clearName() {
        this.f14188m = false;
        this.f14189n = ByteStringMicro.EMPTY;
        return this;
    }

    public Position_Info clearShowyx() {
        this.f14186k = false;
        this.f14187l = ByteStringMicro.EMPTY;
        return this;
    }

    public Position_Info clearUid() {
        this.f14178c = false;
        this.f14179d = ByteStringMicro.EMPTY;
        return this;
    }

    public Position_Info clearYx() {
        this.f14176a = false;
        this.f14177b = ByteStringMicro.EMPTY;
        return this;
    }

    public int getCachedSize() {
        if (this.f14190o < 0) {
            getSerializedSize();
        }
        return this.f14190o;
    }

    public int getCityid() {
        return this.f14183h;
    }

    public String getCname() {
        return this.f14185j;
    }

    public String getExt() {
        return this.f14181f;
    }

    public ByteStringMicro getName() {
        return this.f14189n;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasYx()) {
            i = 0 + CodedOutputStreamMicro.computeBytesSize(1, getYx());
        }
        if (hasUid()) {
            i += CodedOutputStreamMicro.computeBytesSize(2, getUid());
        }
        if (hasExt()) {
            i += CodedOutputStreamMicro.computeStringSize(3, getExt());
        }
        if (hasCityid()) {
            i += CodedOutputStreamMicro.computeInt32Size(4, getCityid());
        }
        if (hasCname()) {
            i += CodedOutputStreamMicro.computeStringSize(5, getCname());
        }
        if (hasShowyx()) {
            i += CodedOutputStreamMicro.computeBytesSize(6, getShowyx());
        }
        if (hasName()) {
            i += CodedOutputStreamMicro.computeBytesSize(7, getName());
        }
        this.f14190o = i;
        return i;
    }

    public ByteStringMicro getShowyx() {
        return this.f14187l;
    }

    public ByteStringMicro getUid() {
        return this.f14179d;
    }

    public ByteStringMicro getYx() {
        return this.f14177b;
    }

    public boolean hasCityid() {
        return this.f14182g;
    }

    public boolean hasCname() {
        return this.f14184i;
    }

    public boolean hasExt() {
        return this.f14180e;
    }

    public boolean hasName() {
        return this.f14188m;
    }

    public boolean hasShowyx() {
        return this.f14186k;
    }

    public boolean hasUid() {
        return this.f14178c;
    }

    public boolean hasYx() {
        return this.f14176a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Position_Info mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    setYx(codedInputStreamMicro.readBytes());
                    continue;
                case 18:
                    setUid(codedInputStreamMicro.readBytes());
                    continue;
                case 26:
                    setExt(codedInputStreamMicro.readString());
                    continue;
                case 32:
                    setCityid(codedInputStreamMicro.readInt32());
                    continue;
                case 42:
                    setCname(codedInputStreamMicro.readString());
                    continue;
                case 50:
                    setShowyx(codedInputStreamMicro.readBytes());
                    continue;
                case 58:
                    setName(codedInputStreamMicro.readBytes());
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

    public Position_Info setCityid(int i) {
        this.f14182g = true;
        this.f14183h = i;
        return this;
    }

    public Position_Info setCname(String str) {
        this.f14184i = true;
        this.f14185j = str;
        return this;
    }

    public Position_Info setExt(String str) {
        this.f14180e = true;
        this.f14181f = str;
        return this;
    }

    public Position_Info setName(ByteStringMicro byteStringMicro) {
        this.f14188m = true;
        this.f14189n = byteStringMicro;
        return this;
    }

    public Position_Info setShowyx(ByteStringMicro byteStringMicro) {
        this.f14186k = true;
        this.f14187l = byteStringMicro;
        return this;
    }

    public Position_Info setUid(ByteStringMicro byteStringMicro) {
        this.f14178c = true;
        this.f14179d = byteStringMicro;
        return this;
    }

    public Position_Info setYx(ByteStringMicro byteStringMicro) {
        this.f14176a = true;
        this.f14177b = byteStringMicro;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasYx()) {
            codedOutputStreamMicro.writeBytes(1, getYx());
        }
        if (hasUid()) {
            codedOutputStreamMicro.writeBytes(2, getUid());
        }
        if (hasExt()) {
            codedOutputStreamMicro.writeString(3, getExt());
        }
        if (hasCityid()) {
            codedOutputStreamMicro.writeInt32(4, getCityid());
        }
        if (hasCname()) {
            codedOutputStreamMicro.writeString(5, getCname());
        }
        if (hasShowyx()) {
            codedOutputStreamMicro.writeBytes(6, getShowyx());
        }
        if (hasName()) {
            codedOutputStreamMicro.writeBytes(7, getName());
        }
    }
}
