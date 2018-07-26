package com.baidu.entity.pb;

import com.baidu.baidunavis.model.NavCarInfo;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CityResult extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 2;
    public static final int CURRENT_CITY_FIELD_NUMBER = 1;
    public static final int PREVIOUS_CITY_FIELD_NUMBER = 3;
    /* renamed from: a */
    private boolean f10972a;
    /* renamed from: b */
    private Content f10973b = null;
    /* renamed from: c */
    private boolean f10974c;
    /* renamed from: d */
    private CurrentCity f10975d = null;
    /* renamed from: e */
    private boolean f10976e;
    /* renamed from: f */
    private PreviousCity f10977f = null;
    /* renamed from: g */
    private int f10978g = -1;

    public static final class Content extends MessageMicro {
        public static final int CITY_TYPE_FIELD_NUMBER = 1;
        public static final int CNAME_FIELD_NUMBER = 3;
        public static final int CODE_FIELD_NUMBER = 2;
        public static final int GEO_FIELD_NUMBER = 4;
        public static final int LEVEL_FIELD_NUMBER = 8;
        public static final int PCCODE_FIELD_NUMBER = 6;
        public static final int PCNAME_FIELD_NUMBER = 7;
        public static final int SGEO_FIELD_NUMBER = 10;
        public static final int SUP_LUKUANG_FIELD_NUMBER = 9;
        public static final int UID_FIELD_NUMBER = 5;
        /* renamed from: a */
        private boolean f10946a;
        /* renamed from: b */
        private int f10947b = 0;
        /* renamed from: c */
        private boolean f10948c;
        /* renamed from: d */
        private int f10949d = 0;
        /* renamed from: e */
        private boolean f10950e;
        /* renamed from: f */
        private String f10951f = "";
        /* renamed from: g */
        private boolean f10952g;
        /* renamed from: h */
        private String f10953h = "";
        /* renamed from: i */
        private boolean f10954i;
        /* renamed from: j */
        private String f10955j = "";
        /* renamed from: k */
        private boolean f10956k;
        /* renamed from: l */
        private int f10957l = 0;
        /* renamed from: m */
        private boolean f10958m;
        /* renamed from: n */
        private String f10959n = "";
        /* renamed from: o */
        private boolean f10960o;
        /* renamed from: p */
        private int f10961p = 0;
        /* renamed from: q */
        private boolean f10962q;
        /* renamed from: r */
        private boolean f10963r = false;
        /* renamed from: s */
        private boolean f10964s;
        /* renamed from: t */
        private Sgeo f10965t = null;
        /* renamed from: u */
        private int f10966u = -1;

        public static final class Sgeo extends MessageMicro {
            public static final int BOUND_FIELD_NUMBER = 1;
            public static final int GEO_ELEMENTS_FIELD_NUMBER = 3;
            public static final int TYPE_FIELD_NUMBER = 2;
            /* renamed from: a */
            private List<String> f10941a = Collections.emptyList();
            /* renamed from: b */
            private boolean f10942b;
            /* renamed from: c */
            private String f10943c = "";
            /* renamed from: d */
            private List<GeoElements> f10944d = Collections.emptyList();
            /* renamed from: e */
            private int f10945e = -1;

            public static final class GeoElements extends MessageMicro {
                public static final int POINT_FIELD_NUMBER = 1;
                /* renamed from: a */
                private List<String> f10939a = Collections.emptyList();
                /* renamed from: b */
                private int f10940b = -1;

                public static GeoElements parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new GeoElements().mergeFrom(codedInputStreamMicro);
                }

                public static GeoElements parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (GeoElements) new GeoElements().mergeFrom(bArr);
                }

                public GeoElements addPoint(String str) {
                    if (str == null) {
                        throw new NullPointerException();
                    }
                    if (this.f10939a.isEmpty()) {
                        this.f10939a = new ArrayList();
                    }
                    this.f10939a.add(str);
                    return this;
                }

                public final GeoElements clear() {
                    clearPoint();
                    this.f10940b = -1;
                    return this;
                }

                public GeoElements clearPoint() {
                    this.f10939a = Collections.emptyList();
                    return this;
                }

                public int getCachedSize() {
                    if (this.f10940b < 0) {
                        getSerializedSize();
                    }
                    return this.f10940b;
                }

                public String getPoint(int i) {
                    return (String) this.f10939a.get(i);
                }

                public int getPointCount() {
                    return this.f10939a.size();
                }

                public List<String> getPointList() {
                    return this.f10939a;
                }

                public int getSerializedSize() {
                    int i = 0;
                    for (String computeStringSizeNoTag : getPointList()) {
                        i = CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag) + i;
                    }
                    int size = (0 + i) + (getPointList().size() * 1);
                    this.f10940b = size;
                    return size;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public GeoElements mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                addPoint(codedInputStreamMicro.readString());
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

                public GeoElements setPoint(int i, String str) {
                    if (str == null) {
                        throw new NullPointerException();
                    }
                    this.f10939a.set(i, str);
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    for (String writeString : getPointList()) {
                        codedOutputStreamMicro.writeString(1, writeString);
                    }
                }
            }

            public static Sgeo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Sgeo().mergeFrom(codedInputStreamMicro);
            }

            public static Sgeo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Sgeo) new Sgeo().mergeFrom(bArr);
            }

            public Sgeo addBound(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                if (this.f10941a.isEmpty()) {
                    this.f10941a = new ArrayList();
                }
                this.f10941a.add(str);
                return this;
            }

            public Sgeo addGeoElements(GeoElements geoElements) {
                if (geoElements != null) {
                    if (this.f10944d.isEmpty()) {
                        this.f10944d = new ArrayList();
                    }
                    this.f10944d.add(geoElements);
                }
                return this;
            }

            public final Sgeo clear() {
                clearBound();
                clearType();
                clearGeoElements();
                this.f10945e = -1;
                return this;
            }

            public Sgeo clearBound() {
                this.f10941a = Collections.emptyList();
                return this;
            }

            public Sgeo clearGeoElements() {
                this.f10944d = Collections.emptyList();
                return this;
            }

            public Sgeo clearType() {
                this.f10942b = false;
                this.f10943c = "";
                return this;
            }

            public String getBound(int i) {
                return (String) this.f10941a.get(i);
            }

            public int getBoundCount() {
                return this.f10941a.size();
            }

            public List<String> getBoundList() {
                return this.f10941a;
            }

            public int getCachedSize() {
                if (this.f10945e < 0) {
                    getSerializedSize();
                }
                return this.f10945e;
            }

            public GeoElements getGeoElements(int i) {
                return (GeoElements) this.f10944d.get(i);
            }

            public int getGeoElementsCount() {
                return this.f10944d.size();
            }

            public List<GeoElements> getGeoElementsList() {
                return this.f10944d;
            }

            public int getSerializedSize() {
                int i = 0;
                for (String computeStringSizeNoTag : getBoundList()) {
                    i = CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag) + i;
                }
                int size = (0 + i) + (getBoundList().size() * 1);
                if (hasType()) {
                    size += CodedOutputStreamMicro.computeStringSize(2, getType());
                }
                i = size;
                for (GeoElements computeMessageSize : getGeoElementsList()) {
                    i = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i;
                }
                this.f10945e = i;
                return i;
            }

            public String getType() {
                return this.f10943c;
            }

            public boolean hasType() {
                return this.f10942b;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Sgeo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            addBound(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setType(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            MessageMicro geoElements = new GeoElements();
                            codedInputStreamMicro.readMessage(geoElements);
                            addGeoElements(geoElements);
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

            public Sgeo setBound(int i, String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f10941a.set(i, str);
                return this;
            }

            public Sgeo setGeoElements(int i, GeoElements geoElements) {
                if (geoElements != null) {
                    this.f10944d.set(i, geoElements);
                }
                return this;
            }

            public Sgeo setType(String str) {
                this.f10942b = true;
                this.f10943c = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                for (String writeString : getBoundList()) {
                    codedOutputStreamMicro.writeString(1, writeString);
                }
                if (hasType()) {
                    codedOutputStreamMicro.writeString(2, getType());
                }
                for (GeoElements writeMessage : getGeoElementsList()) {
                    codedOutputStreamMicro.writeMessage(3, writeMessage);
                }
            }
        }

        public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Content().mergeFrom(codedInputStreamMicro);
        }

        public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Content) new Content().mergeFrom(bArr);
        }

        public final Content clear() {
            clearCityType();
            clearCode();
            clearCname();
            clearGeo();
            clearUid();
            clearPccode();
            clearPcname();
            clearLevel();
            clearSupLukuang();
            clearSgeo();
            this.f10966u = -1;
            return this;
        }

        public Content clearCityType() {
            this.f10946a = false;
            this.f10947b = 0;
            return this;
        }

        public Content clearCname() {
            this.f10950e = false;
            this.f10951f = "";
            return this;
        }

        public Content clearCode() {
            this.f10948c = false;
            this.f10949d = 0;
            return this;
        }

        public Content clearGeo() {
            this.f10952g = false;
            this.f10953h = "";
            return this;
        }

        public Content clearLevel() {
            this.f10960o = false;
            this.f10961p = 0;
            return this;
        }

        public Content clearPccode() {
            this.f10956k = false;
            this.f10957l = 0;
            return this;
        }

        public Content clearPcname() {
            this.f10958m = false;
            this.f10959n = "";
            return this;
        }

        public Content clearSgeo() {
            this.f10964s = false;
            this.f10965t = null;
            return this;
        }

        public Content clearSupLukuang() {
            this.f10962q = false;
            this.f10963r = false;
            return this;
        }

        public Content clearUid() {
            this.f10954i = false;
            this.f10955j = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f10966u < 0) {
                getSerializedSize();
            }
            return this.f10966u;
        }

        public int getCityType() {
            return this.f10947b;
        }

        public String getCname() {
            return this.f10951f;
        }

        public int getCode() {
            return this.f10949d;
        }

        public String getGeo() {
            return this.f10953h;
        }

        public int getLevel() {
            return this.f10961p;
        }

        public int getPccode() {
            return this.f10957l;
        }

        public String getPcname() {
            return this.f10959n;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasCityType()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCityType());
            }
            if (hasCode()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getCode());
            }
            if (hasCname()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getCname());
            }
            if (hasGeo()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getGeo());
            }
            if (hasUid()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getUid());
            }
            if (hasPccode()) {
                i += CodedOutputStreamMicro.computeInt32Size(6, getPccode());
            }
            if (hasPcname()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getPcname());
            }
            if (hasLevel()) {
                i += CodedOutputStreamMicro.computeInt32Size(8, getLevel());
            }
            if (hasSupLukuang()) {
                i += CodedOutputStreamMicro.computeBoolSize(9, getSupLukuang());
            }
            if (hasSgeo()) {
                i += CodedOutputStreamMicro.computeMessageSize(10, getSgeo());
            }
            this.f10966u = i;
            return i;
        }

        public Sgeo getSgeo() {
            return this.f10965t;
        }

        public boolean getSupLukuang() {
            return this.f10963r;
        }

        public String getUid() {
            return this.f10955j;
        }

        public boolean hasCityType() {
            return this.f10946a;
        }

        public boolean hasCname() {
            return this.f10950e;
        }

        public boolean hasCode() {
            return this.f10948c;
        }

        public boolean hasGeo() {
            return this.f10952g;
        }

        public boolean hasLevel() {
            return this.f10960o;
        }

        public boolean hasPccode() {
            return this.f10956k;
        }

        public boolean hasPcname() {
            return this.f10958m;
        }

        public boolean hasSgeo() {
            return this.f10964s;
        }

        public boolean hasSupLukuang() {
            return this.f10962q;
        }

        public boolean hasUid() {
            return this.f10954i;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Content mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setCityType(codedInputStreamMicro.readInt32());
                        continue;
                    case 16:
                        setCode(codedInputStreamMicro.readInt32());
                        continue;
                    case 26:
                        setCname(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setGeo(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setUid(codedInputStreamMicro.readString());
                        continue;
                    case 48:
                        setPccode(codedInputStreamMicro.readInt32());
                        continue;
                    case 58:
                        setPcname(codedInputStreamMicro.readString());
                        continue;
                    case 64:
                        setLevel(codedInputStreamMicro.readInt32());
                        continue;
                    case NavCarInfo.CarType_57L /*72*/:
                        setSupLukuang(codedInputStreamMicro.readBool());
                        continue;
                    case 82:
                        MessageMicro sgeo = new Sgeo();
                        codedInputStreamMicro.readMessage(sgeo);
                        setSgeo(sgeo);
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

        public Content setCityType(int i) {
            this.f10946a = true;
            this.f10947b = i;
            return this;
        }

        public Content setCname(String str) {
            this.f10950e = true;
            this.f10951f = str;
            return this;
        }

        public Content setCode(int i) {
            this.f10948c = true;
            this.f10949d = i;
            return this;
        }

        public Content setGeo(String str) {
            this.f10952g = true;
            this.f10953h = str;
            return this;
        }

        public Content setLevel(int i) {
            this.f10960o = true;
            this.f10961p = i;
            return this;
        }

        public Content setPccode(int i) {
            this.f10956k = true;
            this.f10957l = i;
            return this;
        }

        public Content setPcname(String str) {
            this.f10958m = true;
            this.f10959n = str;
            return this;
        }

        public Content setSgeo(Sgeo sgeo) {
            if (sgeo == null) {
                return clearSgeo();
            }
            this.f10964s = true;
            this.f10965t = sgeo;
            return this;
        }

        public Content setSupLukuang(boolean z) {
            this.f10962q = true;
            this.f10963r = z;
            return this;
        }

        public Content setUid(String str) {
            this.f10954i = true;
            this.f10955j = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasCityType()) {
                codedOutputStreamMicro.writeInt32(1, getCityType());
            }
            if (hasCode()) {
                codedOutputStreamMicro.writeInt32(2, getCode());
            }
            if (hasCname()) {
                codedOutputStreamMicro.writeString(3, getCname());
            }
            if (hasGeo()) {
                codedOutputStreamMicro.writeString(4, getGeo());
            }
            if (hasUid()) {
                codedOutputStreamMicro.writeString(5, getUid());
            }
            if (hasPccode()) {
                codedOutputStreamMicro.writeInt32(6, getPccode());
            }
            if (hasPcname()) {
                codedOutputStreamMicro.writeString(7, getPcname());
            }
            if (hasLevel()) {
                codedOutputStreamMicro.writeInt32(8, getLevel());
            }
            if (hasSupLukuang()) {
                codedOutputStreamMicro.writeBool(9, getSupLukuang());
            }
            if (hasSgeo()) {
                codedOutputStreamMicro.writeMessage(10, getSgeo());
            }
        }
    }

    public static final class PreviousCity extends MessageMicro {
        public static final int CODE_FIELD_NUMBER = 1;
        public static final int NAME_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f10967a;
        /* renamed from: b */
        private int f10968b = 0;
        /* renamed from: c */
        private boolean f10969c;
        /* renamed from: d */
        private String f10970d = "";
        /* renamed from: e */
        private int f10971e = -1;

        public static PreviousCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new PreviousCity().mergeFrom(codedInputStreamMicro);
        }

        public static PreviousCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (PreviousCity) new PreviousCity().mergeFrom(bArr);
        }

        public final PreviousCity clear() {
            clearCode();
            clearName();
            this.f10971e = -1;
            return this;
        }

        public PreviousCity clearCode() {
            this.f10967a = false;
            this.f10968b = 0;
            return this;
        }

        public PreviousCity clearName() {
            this.f10969c = false;
            this.f10970d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f10971e < 0) {
                getSerializedSize();
            }
            return this.f10971e;
        }

        public int getCode() {
            return this.f10968b;
        }

        public String getName() {
            return this.f10970d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasCode()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
            }
            if (hasName()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getName());
            }
            this.f10971e = i;
            return i;
        }

        public boolean hasCode() {
            return this.f10967a;
        }

        public boolean hasName() {
            return this.f10969c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public PreviousCity mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                    default:
                        if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public PreviousCity setCode(int i) {
            this.f10967a = true;
            this.f10968b = i;
            return this;
        }

        public PreviousCity setName(String str) {
            this.f10969c = true;
            this.f10970d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasCode()) {
                codedOutputStreamMicro.writeInt32(1, getCode());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(2, getName());
            }
        }
    }

    public static CityResult parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new CityResult().mergeFrom(codedInputStreamMicro);
    }

    public static CityResult parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (CityResult) new CityResult().mergeFrom(bArr);
    }

    public final CityResult clear() {
        clearContent();
        clearCurrentCity();
        clearPreviousCity();
        this.f10978g = -1;
        return this;
    }

    public CityResult clearContent() {
        this.f10972a = false;
        this.f10973b = null;
        return this;
    }

    public CityResult clearCurrentCity() {
        this.f10974c = false;
        this.f10975d = null;
        return this;
    }

    public CityResult clearPreviousCity() {
        this.f10976e = false;
        this.f10977f = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f10978g < 0) {
            getSerializedSize();
        }
        return this.f10978g;
    }

    public Content getContent() {
        return this.f10973b;
    }

    public CurrentCity getCurrentCity() {
        return this.f10975d;
    }

    public PreviousCity getPreviousCity() {
        return this.f10977f;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasCurrentCity()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getCurrentCity());
        }
        if (hasContent()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getContent());
        }
        if (hasPreviousCity()) {
            i += CodedOutputStreamMicro.computeMessageSize(3, getPreviousCity());
        }
        this.f10978g = i;
        return i;
    }

    public boolean hasContent() {
        return this.f10972a;
    }

    public boolean hasCurrentCity() {
        return this.f10974c;
    }

    public boolean hasPreviousCity() {
        return this.f10976e;
    }

    public final boolean isInitialized() {
        return true;
    }

    public CityResult mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro currentCity;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    currentCity = new CurrentCity();
                    codedInputStreamMicro.readMessage(currentCity);
                    setCurrentCity(currentCity);
                    continue;
                case 18:
                    currentCity = new Content();
                    codedInputStreamMicro.readMessage(currentCity);
                    setContent(currentCity);
                    continue;
                case 26:
                    currentCity = new PreviousCity();
                    codedInputStreamMicro.readMessage(currentCity);
                    setPreviousCity(currentCity);
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

    public CityResult setContent(Content content) {
        if (content == null) {
            return clearContent();
        }
        this.f10972a = true;
        this.f10973b = content;
        return this;
    }

    public CityResult setCurrentCity(CurrentCity currentCity) {
        if (currentCity == null) {
            return clearCurrentCity();
        }
        this.f10974c = true;
        this.f10975d = currentCity;
        return this;
    }

    public CityResult setPreviousCity(PreviousCity previousCity) {
        if (previousCity == null) {
            return clearPreviousCity();
        }
        this.f10976e = true;
        this.f10977f = previousCity;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasCurrentCity()) {
            codedOutputStreamMicro.writeMessage(1, getCurrentCity());
        }
        if (hasContent()) {
            codedOutputStreamMicro.writeMessage(2, getContent());
        }
        if (hasPreviousCity()) {
            codedOutputStreamMicro.writeMessage(3, getPreviousCity());
        }
    }
}
