package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CurrentCity extends MessageMicro {
    public static final int CODE_FIELD_NUMBER = 1;
    public static final int GEO_FIELD_NUMBER = 2;
    public static final int LEVEL_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int SGEO_FIELD_NUMBER = 8;
    public static final int SUP_LUKUANG_FIELD_NUMBER = 6;
    public static final int SUP_SUBWAY_FIELD_NUMBER = 5;
    public static final int UID_FIELD_NUMBER = 7;
    /* renamed from: a */
    private boolean f11057a;
    /* renamed from: b */
    private int f11058b = 0;
    /* renamed from: c */
    private boolean f11059c;
    /* renamed from: d */
    private String f11060d = "";
    /* renamed from: e */
    private boolean f11061e;
    /* renamed from: f */
    private int f11062f = 0;
    /* renamed from: g */
    private boolean f11063g;
    /* renamed from: h */
    private String f11064h = "";
    /* renamed from: i */
    private boolean f11065i;
    /* renamed from: j */
    private boolean f11066j = false;
    /* renamed from: k */
    private boolean f11067k;
    /* renamed from: l */
    private boolean f11068l = false;
    /* renamed from: m */
    private boolean f11069m;
    /* renamed from: n */
    private String f11070n = "";
    /* renamed from: o */
    private List<Integer> f11071o = Collections.emptyList();
    /* renamed from: p */
    private int f11072p = -1;

    public static CurrentCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new CurrentCity().mergeFrom(codedInputStreamMicro);
    }

    public static CurrentCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (CurrentCity) new CurrentCity().mergeFrom(bArr);
    }

    public CurrentCity addSgeo(int i) {
        if (this.f11071o.isEmpty()) {
            this.f11071o = new ArrayList();
        }
        this.f11071o.add(Integer.valueOf(i));
        return this;
    }

    public final CurrentCity clear() {
        clearCode();
        clearGeo();
        clearLevel();
        clearName();
        clearSupSubway();
        clearSupLukuang();
        clearUid();
        clearSgeo();
        this.f11072p = -1;
        return this;
    }

    public CurrentCity clearCode() {
        this.f11057a = false;
        this.f11058b = 0;
        return this;
    }

    public CurrentCity clearGeo() {
        this.f11059c = false;
        this.f11060d = "";
        return this;
    }

    public CurrentCity clearLevel() {
        this.f11061e = false;
        this.f11062f = 0;
        return this;
    }

    public CurrentCity clearName() {
        this.f11063g = false;
        this.f11064h = "";
        return this;
    }

    public CurrentCity clearSgeo() {
        this.f11071o = Collections.emptyList();
        return this;
    }

    public CurrentCity clearSupLukuang() {
        this.f11067k = false;
        this.f11068l = false;
        return this;
    }

    public CurrentCity clearSupSubway() {
        this.f11065i = false;
        this.f11066j = false;
        return this;
    }

    public CurrentCity clearUid() {
        this.f11069m = false;
        this.f11070n = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f11072p < 0) {
            getSerializedSize();
        }
        return this.f11072p;
    }

    public int getCode() {
        return this.f11058b;
    }

    public String getGeo() {
        return this.f11060d;
    }

    public int getLevel() {
        return this.f11062f;
    }

    public String getName() {
        return this.f11064h;
    }

    public int getSerializedSize() {
        int i = 0;
        int computeInt32Size = hasCode() ? CodedOutputStreamMicro.computeInt32Size(1, getCode()) + 0 : 0;
        if (hasGeo()) {
            computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getGeo());
        }
        if (hasLevel()) {
            computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getLevel());
        }
        if (hasName()) {
            computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getName());
        }
        if (hasSupSubway()) {
            computeInt32Size += CodedOutputStreamMicro.computeBoolSize(5, getSupSubway());
        }
        if (hasSupLukuang()) {
            computeInt32Size += CodedOutputStreamMicro.computeBoolSize(6, getSupLukuang());
        }
        int computeStringSize = hasUid() ? computeInt32Size + CodedOutputStreamMicro.computeStringSize(7, getUid()) : computeInt32Size;
        for (Integer intValue : getSgeoList()) {
            i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue());
        }
        computeInt32Size = (computeStringSize + i) + (getSgeoList().size() * 1);
        this.f11072p = computeInt32Size;
        return computeInt32Size;
    }

    public int getSgeo(int i) {
        return ((Integer) this.f11071o.get(i)).intValue();
    }

    public int getSgeoCount() {
        return this.f11071o.size();
    }

    public List<Integer> getSgeoList() {
        return this.f11071o;
    }

    public boolean getSupLukuang() {
        return this.f11068l;
    }

    public boolean getSupSubway() {
        return this.f11066j;
    }

    public String getUid() {
        return this.f11070n;
    }

    public boolean hasCode() {
        return this.f11057a;
    }

    public boolean hasGeo() {
        return this.f11059c;
    }

    public boolean hasLevel() {
        return this.f11061e;
    }

    public boolean hasName() {
        return this.f11063g;
    }

    public boolean hasSupLukuang() {
        return this.f11067k;
    }

    public boolean hasSupSubway() {
        return this.f11065i;
    }

    public boolean hasUid() {
        return this.f11069m;
    }

    public final boolean isInitialized() {
        return true;
    }

    public CurrentCity mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    setCode(codedInputStreamMicro.readInt32());
                    continue;
                case 18:
                    setGeo(codedInputStreamMicro.readString());
                    continue;
                case 24:
                    setLevel(codedInputStreamMicro.readInt32());
                    continue;
                case 34:
                    setName(codedInputStreamMicro.readString());
                    continue;
                case 40:
                    setSupSubway(codedInputStreamMicro.readBool());
                    continue;
                case 48:
                    setSupLukuang(codedInputStreamMicro.readBool());
                    continue;
                case 58:
                    setUid(codedInputStreamMicro.readString());
                    continue;
                case 64:
                    addSgeo(codedInputStreamMicro.readSInt32());
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

    public CurrentCity setCode(int i) {
        this.f11057a = true;
        this.f11058b = i;
        return this;
    }

    public CurrentCity setGeo(String str) {
        this.f11059c = true;
        this.f11060d = str;
        return this;
    }

    public CurrentCity setLevel(int i) {
        this.f11061e = true;
        this.f11062f = i;
        return this;
    }

    public CurrentCity setName(String str) {
        this.f11063g = true;
        this.f11064h = str;
        return this;
    }

    public CurrentCity setSgeo(int i, int i2) {
        this.f11071o.set(i, Integer.valueOf(i2));
        return this;
    }

    public CurrentCity setSupLukuang(boolean z) {
        this.f11067k = true;
        this.f11068l = z;
        return this;
    }

    public CurrentCity setSupSubway(boolean z) {
        this.f11065i = true;
        this.f11066j = z;
        return this;
    }

    public CurrentCity setUid(String str) {
        this.f11069m = true;
        this.f11070n = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasCode()) {
            codedOutputStreamMicro.writeInt32(1, getCode());
        }
        if (hasGeo()) {
            codedOutputStreamMicro.writeString(2, getGeo());
        }
        if (hasLevel()) {
            codedOutputStreamMicro.writeInt32(3, getLevel());
        }
        if (hasName()) {
            codedOutputStreamMicro.writeString(4, getName());
        }
        if (hasSupSubway()) {
            codedOutputStreamMicro.writeBool(5, getSupSubway());
        }
        if (hasSupLukuang()) {
            codedOutputStreamMicro.writeBool(6, getSupLukuang());
        }
        if (hasUid()) {
            codedOutputStreamMicro.writeString(7, getUid());
        }
        for (Integer intValue : getSgeoList()) {
            codedOutputStreamMicro.writeSInt32(8, intValue.intValue());
        }
    }
}
