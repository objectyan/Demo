package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TrafficFCPois extends MessageMicro {
    public static final int FC_POI_INFO_FIELD_NUMBER = 1;
    /* renamed from: a */
    private List<FCPoiInfo> f16442a = Collections.emptyList();
    /* renamed from: b */
    private int f16443b = -1;

    public static final class FCPoiInfo extends MessageMicro {
        public static final int CITY_LIST_FIELD_NUMBER = 2;
        public static final int C_POIS_FIELD_NUMBER = 6;
        public static final int C_POIS_GEO_FIELD_NUMBER = 7;
        public static final int F_POIS_FIELD_NUMBER = 4;
        public static final int F_POIS_GEO_FIELD_NUMBER = 5;
        public static final int KEY_WD_FIELD_NUMBER = 3;
        public static final int PRIO_FLAG_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f16429a;
        /* renamed from: b */
        private boolean f16430b = false;
        /* renamed from: c */
        private boolean f16431c;
        /* renamed from: d */
        private boolean f16432d = false;
        /* renamed from: e */
        private boolean f16433e;
        /* renamed from: f */
        private ByteStringMicro f16434f = ByteStringMicro.EMPTY;
        /* renamed from: g */
        private List<FCPoi> f16435g = Collections.emptyList();
        /* renamed from: h */
        private boolean f16436h;
        /* renamed from: i */
        private ByteStringMicro f16437i = ByteStringMicro.EMPTY;
        /* renamed from: j */
        private List<FCPoi> f16438j = Collections.emptyList();
        /* renamed from: k */
        private boolean f16439k;
        /* renamed from: l */
        private ByteStringMicro f16440l = ByteStringMicro.EMPTY;
        /* renamed from: m */
        private int f16441m = -1;

        public static final class FCPoi extends MessageMicro {
            public static final int ADDR_FIELD_NUMBER = 3;
            public static final int ALIAS_NAME_FIELD_NUMBER = 4;
            public static final int CHILD_NUM_FIELD_NUMBER = 7;
            public static final int CODE_FIELD_NUMBER = 5;
            public static final int EXT_FIELD_NUMBER = 6;
            public static final int NAME_FIELD_NUMBER = 1;
            public static final int SHOW_TYPE_FIELD_NUMBER = 8;
            public static final int UID_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f16412a;
            /* renamed from: b */
            private ByteStringMicro f16413b = ByteStringMicro.EMPTY;
            /* renamed from: c */
            private boolean f16414c;
            /* renamed from: d */
            private String f16415d = "";
            /* renamed from: e */
            private boolean f16416e;
            /* renamed from: f */
            private ByteStringMicro f16417f = ByteStringMicro.EMPTY;
            /* renamed from: g */
            private boolean f16418g;
            /* renamed from: h */
            private ByteStringMicro f16419h = ByteStringMicro.EMPTY;
            /* renamed from: i */
            private boolean f16420i;
            /* renamed from: j */
            private int f16421j = 0;
            /* renamed from: k */
            private boolean f16422k;
            /* renamed from: l */
            private String f16423l = "";
            /* renamed from: m */
            private boolean f16424m;
            /* renamed from: n */
            private int f16425n = 0;
            /* renamed from: o */
            private boolean f16426o;
            /* renamed from: p */
            private int f16427p = 0;
            /* renamed from: q */
            private int f16428q = -1;

            public static FCPoi parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new FCPoi().mergeFrom(codedInputStreamMicro);
            }

            public static FCPoi parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (FCPoi) new FCPoi().mergeFrom(bArr);
            }

            public final FCPoi clear() {
                clearName();
                clearUid();
                clearAddr();
                clearAliasName();
                clearCode();
                clearExt();
                clearChildNum();
                clearShowType();
                this.f16428q = -1;
                return this;
            }

            public FCPoi clearAddr() {
                this.f16416e = false;
                this.f16417f = ByteStringMicro.EMPTY;
                return this;
            }

            public FCPoi clearAliasName() {
                this.f16418g = false;
                this.f16419h = ByteStringMicro.EMPTY;
                return this;
            }

            public FCPoi clearChildNum() {
                this.f16424m = false;
                this.f16425n = 0;
                return this;
            }

            public FCPoi clearCode() {
                this.f16420i = false;
                this.f16421j = 0;
                return this;
            }

            public FCPoi clearExt() {
                this.f16422k = false;
                this.f16423l = "";
                return this;
            }

            public FCPoi clearName() {
                this.f16412a = false;
                this.f16413b = ByteStringMicro.EMPTY;
                return this;
            }

            public FCPoi clearShowType() {
                this.f16426o = false;
                this.f16427p = 0;
                return this;
            }

            public FCPoi clearUid() {
                this.f16414c = false;
                this.f16415d = "";
                return this;
            }

            public ByteStringMicro getAddr() {
                return this.f16417f;
            }

            public ByteStringMicro getAliasName() {
                return this.f16419h;
            }

            public int getCachedSize() {
                if (this.f16428q < 0) {
                    getSerializedSize();
                }
                return this.f16428q;
            }

            public int getChildNum() {
                return this.f16425n;
            }

            public int getCode() {
                return this.f16421j;
            }

            public String getExt() {
                return this.f16423l;
            }

            public ByteStringMicro getName() {
                return this.f16413b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasName()) {
                    i = 0 + CodedOutputStreamMicro.computeBytesSize(1, getName());
                }
                if (hasUid()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getUid());
                }
                if (hasAddr()) {
                    i += CodedOutputStreamMicro.computeBytesSize(3, getAddr());
                }
                if (hasAliasName()) {
                    i += CodedOutputStreamMicro.computeBytesSize(4, getAliasName());
                }
                if (hasCode()) {
                    i += CodedOutputStreamMicro.computeInt32Size(5, getCode());
                }
                if (hasExt()) {
                    i += CodedOutputStreamMicro.computeStringSize(6, getExt());
                }
                if (hasChildNum()) {
                    i += CodedOutputStreamMicro.computeInt32Size(7, getChildNum());
                }
                if (hasShowType()) {
                    i += CodedOutputStreamMicro.computeInt32Size(8, getShowType());
                }
                this.f16428q = i;
                return i;
            }

            public int getShowType() {
                return this.f16427p;
            }

            public String getUid() {
                return this.f16415d;
            }

            public boolean hasAddr() {
                return this.f16416e;
            }

            public boolean hasAliasName() {
                return this.f16418g;
            }

            public boolean hasChildNum() {
                return this.f16424m;
            }

            public boolean hasCode() {
                return this.f16420i;
            }

            public boolean hasExt() {
                return this.f16422k;
            }

            public boolean hasName() {
                return this.f16412a;
            }

            public boolean hasShowType() {
                return this.f16426o;
            }

            public boolean hasUid() {
                return this.f16414c;
            }

            public final boolean isInitialized() {
                return true;
            }

            public FCPoi mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setName(codedInputStreamMicro.readBytes());
                            continue;
                        case 18:
                            setUid(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setAddr(codedInputStreamMicro.readBytes());
                            continue;
                        case 34:
                            setAliasName(codedInputStreamMicro.readBytes());
                            continue;
                        case 40:
                            setCode(codedInputStreamMicro.readInt32());
                            continue;
                        case 50:
                            setExt(codedInputStreamMicro.readString());
                            continue;
                        case 56:
                            setChildNum(codedInputStreamMicro.readInt32());
                            continue;
                        case 64:
                            setShowType(codedInputStreamMicro.readInt32());
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

            public FCPoi setAddr(ByteStringMicro byteStringMicro) {
                this.f16416e = true;
                this.f16417f = byteStringMicro;
                return this;
            }

            public FCPoi setAliasName(ByteStringMicro byteStringMicro) {
                this.f16418g = true;
                this.f16419h = byteStringMicro;
                return this;
            }

            public FCPoi setChildNum(int i) {
                this.f16424m = true;
                this.f16425n = i;
                return this;
            }

            public FCPoi setCode(int i) {
                this.f16420i = true;
                this.f16421j = i;
                return this;
            }

            public FCPoi setExt(String str) {
                this.f16422k = true;
                this.f16423l = str;
                return this;
            }

            public FCPoi setName(ByteStringMicro byteStringMicro) {
                this.f16412a = true;
                this.f16413b = byteStringMicro;
                return this;
            }

            public FCPoi setShowType(int i) {
                this.f16426o = true;
                this.f16427p = i;
                return this;
            }

            public FCPoi setUid(String str) {
                this.f16414c = true;
                this.f16415d = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasName()) {
                    codedOutputStreamMicro.writeBytes(1, getName());
                }
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(2, getUid());
                }
                if (hasAddr()) {
                    codedOutputStreamMicro.writeBytes(3, getAddr());
                }
                if (hasAliasName()) {
                    codedOutputStreamMicro.writeBytes(4, getAliasName());
                }
                if (hasCode()) {
                    codedOutputStreamMicro.writeInt32(5, getCode());
                }
                if (hasExt()) {
                    codedOutputStreamMicro.writeString(6, getExt());
                }
                if (hasChildNum()) {
                    codedOutputStreamMicro.writeInt32(7, getChildNum());
                }
                if (hasShowType()) {
                    codedOutputStreamMicro.writeInt32(8, getShowType());
                }
            }
        }

        public static FCPoiInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new FCPoiInfo().mergeFrom(codedInputStreamMicro);
        }

        public static FCPoiInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (FCPoiInfo) new FCPoiInfo().mergeFrom(bArr);
        }

        public FCPoiInfo addCPois(FCPoi fCPoi) {
            if (fCPoi != null) {
                if (this.f16438j.isEmpty()) {
                    this.f16438j = new ArrayList();
                }
                this.f16438j.add(fCPoi);
            }
            return this;
        }

        public FCPoiInfo addFPois(FCPoi fCPoi) {
            if (fCPoi != null) {
                if (this.f16435g.isEmpty()) {
                    this.f16435g = new ArrayList();
                }
                this.f16435g.add(fCPoi);
            }
            return this;
        }

        public final FCPoiInfo clear() {
            clearPrioFlag();
            clearCityList();
            clearKeyWd();
            clearFPois();
            clearFPoisGeo();
            clearCPois();
            clearCPoisGeo();
            this.f16441m = -1;
            return this;
        }

        public FCPoiInfo clearCPois() {
            this.f16438j = Collections.emptyList();
            return this;
        }

        public FCPoiInfo clearCPoisGeo() {
            this.f16439k = false;
            this.f16440l = ByteStringMicro.EMPTY;
            return this;
        }

        public FCPoiInfo clearCityList() {
            this.f16431c = false;
            this.f16432d = false;
            return this;
        }

        public FCPoiInfo clearFPois() {
            this.f16435g = Collections.emptyList();
            return this;
        }

        public FCPoiInfo clearFPoisGeo() {
            this.f16436h = false;
            this.f16437i = ByteStringMicro.EMPTY;
            return this;
        }

        public FCPoiInfo clearKeyWd() {
            this.f16433e = false;
            this.f16434f = ByteStringMicro.EMPTY;
            return this;
        }

        public FCPoiInfo clearPrioFlag() {
            this.f16429a = false;
            this.f16430b = false;
            return this;
        }

        public FCPoi getCPois(int i) {
            return (FCPoi) this.f16438j.get(i);
        }

        public int getCPoisCount() {
            return this.f16438j.size();
        }

        public ByteStringMicro getCPoisGeo() {
            return this.f16440l;
        }

        public List<FCPoi> getCPoisList() {
            return this.f16438j;
        }

        public int getCachedSize() {
            if (this.f16441m < 0) {
                getSerializedSize();
            }
            return this.f16441m;
        }

        public boolean getCityList() {
            return this.f16432d;
        }

        public FCPoi getFPois(int i) {
            return (FCPoi) this.f16435g.get(i);
        }

        public int getFPoisCount() {
            return this.f16435g.size();
        }

        public ByteStringMicro getFPoisGeo() {
            return this.f16437i;
        }

        public List<FCPoi> getFPoisList() {
            return this.f16435g;
        }

        public ByteStringMicro getKeyWd() {
            return this.f16434f;
        }

        public boolean getPrioFlag() {
            return this.f16430b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasPrioFlag()) {
                i = 0 + CodedOutputStreamMicro.computeBoolSize(1, getPrioFlag());
            }
            if (hasCityList()) {
                i += CodedOutputStreamMicro.computeBoolSize(2, getCityList());
            }
            if (hasKeyWd()) {
                i += CodedOutputStreamMicro.computeBytesSize(3, getKeyWd());
            }
            int i2 = i;
            for (FCPoi computeMessageSize : getFPoisList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(4, computeMessageSize) + i2;
            }
            if (hasFPoisGeo()) {
                i2 += CodedOutputStreamMicro.computeBytesSize(5, getFPoisGeo());
            }
            for (FCPoi computeMessageSize2 : getCPoisList()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(6, computeMessageSize2);
            }
            if (hasCPoisGeo()) {
                i2 += CodedOutputStreamMicro.computeBytesSize(7, getCPoisGeo());
            }
            this.f16441m = i2;
            return i2;
        }

        public boolean hasCPoisGeo() {
            return this.f16439k;
        }

        public boolean hasCityList() {
            return this.f16431c;
        }

        public boolean hasFPoisGeo() {
            return this.f16436h;
        }

        public boolean hasKeyWd() {
            return this.f16433e;
        }

        public boolean hasPrioFlag() {
            return this.f16429a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public FCPoiInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro fCPoi;
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setPrioFlag(codedInputStreamMicro.readBool());
                        continue;
                    case 16:
                        setCityList(codedInputStreamMicro.readBool());
                        continue;
                    case 26:
                        setKeyWd(codedInputStreamMicro.readBytes());
                        continue;
                    case 34:
                        fCPoi = new FCPoi();
                        codedInputStreamMicro.readMessage(fCPoi);
                        addFPois(fCPoi);
                        continue;
                    case 42:
                        setFPoisGeo(codedInputStreamMicro.readBytes());
                        continue;
                    case 50:
                        fCPoi = new FCPoi();
                        codedInputStreamMicro.readMessage(fCPoi);
                        addCPois(fCPoi);
                        continue;
                    case 58:
                        setCPoisGeo(codedInputStreamMicro.readBytes());
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

        public FCPoiInfo setCPois(int i, FCPoi fCPoi) {
            if (fCPoi != null) {
                this.f16438j.set(i, fCPoi);
            }
            return this;
        }

        public FCPoiInfo setCPoisGeo(ByteStringMicro byteStringMicro) {
            this.f16439k = true;
            this.f16440l = byteStringMicro;
            return this;
        }

        public FCPoiInfo setCityList(boolean z) {
            this.f16431c = true;
            this.f16432d = z;
            return this;
        }

        public FCPoiInfo setFPois(int i, FCPoi fCPoi) {
            if (fCPoi != null) {
                this.f16435g.set(i, fCPoi);
            }
            return this;
        }

        public FCPoiInfo setFPoisGeo(ByteStringMicro byteStringMicro) {
            this.f16436h = true;
            this.f16437i = byteStringMicro;
            return this;
        }

        public FCPoiInfo setKeyWd(ByteStringMicro byteStringMicro) {
            this.f16433e = true;
            this.f16434f = byteStringMicro;
            return this;
        }

        public FCPoiInfo setPrioFlag(boolean z) {
            this.f16429a = true;
            this.f16430b = z;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasPrioFlag()) {
                codedOutputStreamMicro.writeBool(1, getPrioFlag());
            }
            if (hasCityList()) {
                codedOutputStreamMicro.writeBool(2, getCityList());
            }
            if (hasKeyWd()) {
                codedOutputStreamMicro.writeBytes(3, getKeyWd());
            }
            for (FCPoi writeMessage : getFPoisList()) {
                codedOutputStreamMicro.writeMessage(4, writeMessage);
            }
            if (hasFPoisGeo()) {
                codedOutputStreamMicro.writeBytes(5, getFPoisGeo());
            }
            for (FCPoi writeMessage2 : getCPoisList()) {
                codedOutputStreamMicro.writeMessage(6, writeMessage2);
            }
            if (hasCPoisGeo()) {
                codedOutputStreamMicro.writeBytes(7, getCPoisGeo());
            }
        }
    }

    public static TrafficFCPois parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new TrafficFCPois().mergeFrom(codedInputStreamMicro);
    }

    public static TrafficFCPois parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (TrafficFCPois) new TrafficFCPois().mergeFrom(bArr);
    }

    public TrafficFCPois addFcPoiInfo(FCPoiInfo fCPoiInfo) {
        if (fCPoiInfo != null) {
            if (this.f16442a.isEmpty()) {
                this.f16442a = new ArrayList();
            }
            this.f16442a.add(fCPoiInfo);
        }
        return this;
    }

    public final TrafficFCPois clear() {
        clearFcPoiInfo();
        this.f16443b = -1;
        return this;
    }

    public TrafficFCPois clearFcPoiInfo() {
        this.f16442a = Collections.emptyList();
        return this;
    }

    public int getCachedSize() {
        if (this.f16443b < 0) {
            getSerializedSize();
        }
        return this.f16443b;
    }

    public FCPoiInfo getFcPoiInfo(int i) {
        return (FCPoiInfo) this.f16442a.get(i);
    }

    public int getFcPoiInfoCount() {
        return this.f16442a.size();
    }

    public List<FCPoiInfo> getFcPoiInfoList() {
        return this.f16442a;
    }

    public int getSerializedSize() {
        int i = 0;
        for (FCPoiInfo computeMessageSize : getFcPoiInfoList()) {
            i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
        }
        this.f16443b = i;
        return i;
    }

    public final boolean isInitialized() {
        return true;
    }

    public TrafficFCPois mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    MessageMicro fCPoiInfo = new FCPoiInfo();
                    codedInputStreamMicro.readMessage(fCPoiInfo);
                    addFcPoiInfo(fCPoiInfo);
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

    public TrafficFCPois setFcPoiInfo(int i, FCPoiInfo fCPoiInfo) {
        if (fCPoiInfo != null) {
            this.f16442a.set(i, fCPoiInfo);
        }
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (FCPoiInfo writeMessage : getFcPoiInfoList()) {
            codedOutputStreamMicro.writeMessage(1, writeMessage);
        }
    }
}
