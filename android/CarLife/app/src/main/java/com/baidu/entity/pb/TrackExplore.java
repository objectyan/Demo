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

public final class TrackExplore extends MessageMicro {
    public static final int ACROSS_NORTH_TO_SOUTH_FIELD_NUMBER = 7;
    public static final int ACROSS_WEST_TO_EAST_FIELD_NUMBER = 6;
    public static final int ARRIVED_CITY_LIST_FIELD_NUMBER = 5;
    public static final int CITY_NUM_FIELD_NUMBER = 3;
    public static final int DISTANCE_FIELD_NUMBER = 2;
    public static final int HOMECITY_DISTRICT_LIST_FIELD_NUMBER = 11;
    public static final int HOMECITY_DISTRICT_NUM_FIELD_NUMBER = 10;
    public static final int HOMECITY_FIELD_NUMBER = 8;
    public static final int POINT_NUM_FIELD_NUMBER = 1;
    public static final int POINT_PERCENT_AT_HOMECITY_FIELD_NUMBER = 9;
    public static final int POINT_PERCENT_AT_TRADEAREA_FIELD_NUMBER = 13;
    public static final int PROVINCE_NUM_FIELD_NUMBER = 4;
    public static final int TRADEAREA_FIELD_NUMBER = 12;
    /* renamed from: a */
    private boolean f16270a;
    /* renamed from: b */
    private int f16271b = 0;
    /* renamed from: c */
    private boolean f16272c;
    /* renamed from: d */
    private String f16273d = "";
    /* renamed from: e */
    private boolean f16274e;
    /* renamed from: f */
    private int f16275f = 0;
    /* renamed from: g */
    private boolean f16276g;
    /* renamed from: h */
    private int f16277h = 0;
    /* renamed from: i */
    private List<ArrivedCity> f16278i = Collections.emptyList();
    /* renamed from: j */
    private boolean f16279j;
    /* renamed from: k */
    private AcrossWestToEast f16280k = null;
    /* renamed from: l */
    private boolean f16281l;
    /* renamed from: m */
    private AcrossNorthToSouth f16282m = null;
    /* renamed from: n */
    private boolean f16283n;
    /* renamed from: o */
    private String f16284o = "";
    /* renamed from: p */
    private boolean f16285p;
    /* renamed from: q */
    private int f16286q = 0;
    /* renamed from: r */
    private boolean f16287r;
    /* renamed from: s */
    private int f16288s = 0;
    /* renamed from: t */
    private List<HomecityDirstrict> f16289t = Collections.emptyList();
    /* renamed from: u */
    private boolean f16290u;
    /* renamed from: v */
    private String f16291v = "";
    /* renamed from: w */
    private boolean f16292w;
    /* renamed from: x */
    private String f16293x = "";
    /* renamed from: y */
    private int f16294y = -1;

    public static final class AcrossNorthToSouth extends MessageMicro {
        public static final int AMOUNT_DESC_FIELD_NUMBER = 4;
        public static final int DISTANCE_FIELD_NUMBER = 3;
        public static final int NORTH_CITY_FIELD_NUMBER = 1;
        public static final int SOUTH_CITY_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f16236a;
        /* renamed from: b */
        private String f16237b = "";
        /* renamed from: c */
        private boolean f16238c;
        /* renamed from: d */
        private String f16239d = "";
        /* renamed from: e */
        private boolean f16240e;
        /* renamed from: f */
        private String f16241f = "";
        /* renamed from: g */
        private boolean f16242g;
        /* renamed from: h */
        private String f16243h = "";
        /* renamed from: i */
        private int f16244i = -1;

        public static AcrossNorthToSouth parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new AcrossNorthToSouth().mergeFrom(codedInputStreamMicro);
        }

        public static AcrossNorthToSouth parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (AcrossNorthToSouth) new AcrossNorthToSouth().mergeFrom(bArr);
        }

        public final AcrossNorthToSouth clear() {
            clearNorthCity();
            clearSouthCity();
            clearDistance();
            clearAmountDesc();
            this.f16244i = -1;
            return this;
        }

        public AcrossNorthToSouth clearAmountDesc() {
            this.f16242g = false;
            this.f16243h = "";
            return this;
        }

        public AcrossNorthToSouth clearDistance() {
            this.f16240e = false;
            this.f16241f = "";
            return this;
        }

        public AcrossNorthToSouth clearNorthCity() {
            this.f16236a = false;
            this.f16237b = "";
            return this;
        }

        public AcrossNorthToSouth clearSouthCity() {
            this.f16238c = false;
            this.f16239d = "";
            return this;
        }

        public String getAmountDesc() {
            return this.f16243h;
        }

        public int getCachedSize() {
            if (this.f16244i < 0) {
                getSerializedSize();
            }
            return this.f16244i;
        }

        public String getDistance() {
            return this.f16241f;
        }

        public String getNorthCity() {
            return this.f16237b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasNorthCity()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getNorthCity());
            }
            if (hasSouthCity()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getSouthCity());
            }
            if (hasDistance()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getDistance());
            }
            if (hasAmountDesc()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getAmountDesc());
            }
            this.f16244i = i;
            return i;
        }

        public String getSouthCity() {
            return this.f16239d;
        }

        public boolean hasAmountDesc() {
            return this.f16242g;
        }

        public boolean hasDistance() {
            return this.f16240e;
        }

        public boolean hasNorthCity() {
            return this.f16236a;
        }

        public boolean hasSouthCity() {
            return this.f16238c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public AcrossNorthToSouth mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setNorthCity(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setSouthCity(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setDistance(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setAmountDesc(codedInputStreamMicro.readString());
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

        public AcrossNorthToSouth setAmountDesc(String str) {
            this.f16242g = true;
            this.f16243h = str;
            return this;
        }

        public AcrossNorthToSouth setDistance(String str) {
            this.f16240e = true;
            this.f16241f = str;
            return this;
        }

        public AcrossNorthToSouth setNorthCity(String str) {
            this.f16236a = true;
            this.f16237b = str;
            return this;
        }

        public AcrossNorthToSouth setSouthCity(String str) {
            this.f16238c = true;
            this.f16239d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasNorthCity()) {
                codedOutputStreamMicro.writeString(1, getNorthCity());
            }
            if (hasSouthCity()) {
                codedOutputStreamMicro.writeString(2, getSouthCity());
            }
            if (hasDistance()) {
                codedOutputStreamMicro.writeString(3, getDistance());
            }
            if (hasAmountDesc()) {
                codedOutputStreamMicro.writeString(4, getAmountDesc());
            }
        }
    }

    public static final class AcrossWestToEast extends MessageMicro {
        public static final int AMOUNT_DESC_FIELD_NUMBER = 4;
        public static final int DISTANCE_FIELD_NUMBER = 3;
        public static final int EAST_CITY_FIELD_NUMBER = 2;
        public static final int WEST_CITY_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f16245a;
        /* renamed from: b */
        private String f16246b = "";
        /* renamed from: c */
        private boolean f16247c;
        /* renamed from: d */
        private String f16248d = "";
        /* renamed from: e */
        private boolean f16249e;
        /* renamed from: f */
        private String f16250f = "";
        /* renamed from: g */
        private boolean f16251g;
        /* renamed from: h */
        private String f16252h = "";
        /* renamed from: i */
        private int f16253i = -1;

        public static AcrossWestToEast parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new AcrossWestToEast().mergeFrom(codedInputStreamMicro);
        }

        public static AcrossWestToEast parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (AcrossWestToEast) new AcrossWestToEast().mergeFrom(bArr);
        }

        public final AcrossWestToEast clear() {
            clearWestCity();
            clearEastCity();
            clearDistance();
            clearAmountDesc();
            this.f16253i = -1;
            return this;
        }

        public AcrossWestToEast clearAmountDesc() {
            this.f16251g = false;
            this.f16252h = "";
            return this;
        }

        public AcrossWestToEast clearDistance() {
            this.f16249e = false;
            this.f16250f = "";
            return this;
        }

        public AcrossWestToEast clearEastCity() {
            this.f16247c = false;
            this.f16248d = "";
            return this;
        }

        public AcrossWestToEast clearWestCity() {
            this.f16245a = false;
            this.f16246b = "";
            return this;
        }

        public String getAmountDesc() {
            return this.f16252h;
        }

        public int getCachedSize() {
            if (this.f16253i < 0) {
                getSerializedSize();
            }
            return this.f16253i;
        }

        public String getDistance() {
            return this.f16250f;
        }

        public String getEastCity() {
            return this.f16248d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasWestCity()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getWestCity());
            }
            if (hasEastCity()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getEastCity());
            }
            if (hasDistance()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getDistance());
            }
            if (hasAmountDesc()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getAmountDesc());
            }
            this.f16253i = i;
            return i;
        }

        public String getWestCity() {
            return this.f16246b;
        }

        public boolean hasAmountDesc() {
            return this.f16251g;
        }

        public boolean hasDistance() {
            return this.f16249e;
        }

        public boolean hasEastCity() {
            return this.f16247c;
        }

        public boolean hasWestCity() {
            return this.f16245a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public AcrossWestToEast mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setWestCity(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setEastCity(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setDistance(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setAmountDesc(codedInputStreamMicro.readString());
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

        public AcrossWestToEast setAmountDesc(String str) {
            this.f16251g = true;
            this.f16252h = str;
            return this;
        }

        public AcrossWestToEast setDistance(String str) {
            this.f16249e = true;
            this.f16250f = str;
            return this;
        }

        public AcrossWestToEast setEastCity(String str) {
            this.f16247c = true;
            this.f16248d = str;
            return this;
        }

        public AcrossWestToEast setWestCity(String str) {
            this.f16245a = true;
            this.f16246b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasWestCity()) {
                codedOutputStreamMicro.writeString(1, getWestCity());
            }
            if (hasEastCity()) {
                codedOutputStreamMicro.writeString(2, getEastCity());
            }
            if (hasDistance()) {
                codedOutputStreamMicro.writeString(3, getDistance());
            }
            if (hasAmountDesc()) {
                codedOutputStreamMicro.writeString(4, getAmountDesc());
            }
        }
    }

    public static final class ArrivedCity extends MessageMicro {
        public static final int CITY_NAME_FIELD_NUMBER = 1;
        public static final int DATE_FIELD_NUMBER = 2;
        public static final int IS_HOMECITY_FIELD_NUMBER = 4;
        public static final int TIMES_FIELD_NUMBER = 3;
        /* renamed from: a */
        private boolean f16254a;
        /* renamed from: b */
        private String f16255b = "";
        /* renamed from: c */
        private boolean f16256c;
        /* renamed from: d */
        private int f16257d = 0;
        /* renamed from: e */
        private boolean f16258e;
        /* renamed from: f */
        private int f16259f = 0;
        /* renamed from: g */
        private boolean f16260g;
        /* renamed from: h */
        private int f16261h = 0;
        /* renamed from: i */
        private int f16262i = -1;

        public static ArrivedCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ArrivedCity().mergeFrom(codedInputStreamMicro);
        }

        public static ArrivedCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ArrivedCity) new ArrivedCity().mergeFrom(bArr);
        }

        public final ArrivedCity clear() {
            clearCityName();
            clearDate();
            clearTimes();
            clearIsHomecity();
            this.f16262i = -1;
            return this;
        }

        public ArrivedCity clearCityName() {
            this.f16254a = false;
            this.f16255b = "";
            return this;
        }

        public ArrivedCity clearDate() {
            this.f16256c = false;
            this.f16257d = 0;
            return this;
        }

        public ArrivedCity clearIsHomecity() {
            this.f16260g = false;
            this.f16261h = 0;
            return this;
        }

        public ArrivedCity clearTimes() {
            this.f16258e = false;
            this.f16259f = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f16262i < 0) {
                getSerializedSize();
            }
            return this.f16262i;
        }

        public String getCityName() {
            return this.f16255b;
        }

        public int getDate() {
            return this.f16257d;
        }

        public int getIsHomecity() {
            return this.f16261h;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasCityName()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCityName());
            }
            if (hasDate()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getDate());
            }
            if (hasTimes()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getTimes());
            }
            if (hasIsHomecity()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, getIsHomecity());
            }
            this.f16262i = i;
            return i;
        }

        public int getTimes() {
            return this.f16259f;
        }

        public boolean hasCityName() {
            return this.f16254a;
        }

        public boolean hasDate() {
            return this.f16256c;
        }

        public boolean hasIsHomecity() {
            return this.f16260g;
        }

        public boolean hasTimes() {
            return this.f16258e;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ArrivedCity mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setCityName(codedInputStreamMicro.readString());
                        continue;
                    case 16:
                        setDate(codedInputStreamMicro.readInt32());
                        continue;
                    case 24:
                        setTimes(codedInputStreamMicro.readInt32());
                        continue;
                    case 32:
                        setIsHomecity(codedInputStreamMicro.readInt32());
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

        public ArrivedCity setCityName(String str) {
            this.f16254a = true;
            this.f16255b = str;
            return this;
        }

        public ArrivedCity setDate(int i) {
            this.f16256c = true;
            this.f16257d = i;
            return this;
        }

        public ArrivedCity setIsHomecity(int i) {
            this.f16260g = true;
            this.f16261h = i;
            return this;
        }

        public ArrivedCity setTimes(int i) {
            this.f16258e = true;
            this.f16259f = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasCityName()) {
                codedOutputStreamMicro.writeString(1, getCityName());
            }
            if (hasDate()) {
                codedOutputStreamMicro.writeInt32(2, getDate());
            }
            if (hasTimes()) {
                codedOutputStreamMicro.writeInt32(3, getTimes());
            }
            if (hasIsHomecity()) {
                codedOutputStreamMicro.writeInt32(4, getIsHomecity());
            }
        }
    }

    public static final class HomecityDirstrict extends MessageMicro {
        public static final int DATE_FIELD_NUMBER = 2;
        public static final int DISTRICT_NAME_FIELD_NUMBER = 1;
        public static final int TIMES_FIELD_NUMBER = 3;
        /* renamed from: a */
        private boolean f16263a;
        /* renamed from: b */
        private String f16264b = "";
        /* renamed from: c */
        private boolean f16265c;
        /* renamed from: d */
        private int f16266d = 0;
        /* renamed from: e */
        private boolean f16267e;
        /* renamed from: f */
        private int f16268f = 0;
        /* renamed from: g */
        private int f16269g = -1;

        public static HomecityDirstrict parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new HomecityDirstrict().mergeFrom(codedInputStreamMicro);
        }

        public static HomecityDirstrict parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (HomecityDirstrict) new HomecityDirstrict().mergeFrom(bArr);
        }

        public final HomecityDirstrict clear() {
            clearDistrictName();
            clearDate();
            clearTimes();
            this.f16269g = -1;
            return this;
        }

        public HomecityDirstrict clearDate() {
            this.f16265c = false;
            this.f16266d = 0;
            return this;
        }

        public HomecityDirstrict clearDistrictName() {
            this.f16263a = false;
            this.f16264b = "";
            return this;
        }

        public HomecityDirstrict clearTimes() {
            this.f16267e = false;
            this.f16268f = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f16269g < 0) {
                getSerializedSize();
            }
            return this.f16269g;
        }

        public int getDate() {
            return this.f16266d;
        }

        public String getDistrictName() {
            return this.f16264b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasDistrictName()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getDistrictName());
            }
            if (hasDate()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getDate());
            }
            if (hasTimes()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getTimes());
            }
            this.f16269g = i;
            return i;
        }

        public int getTimes() {
            return this.f16268f;
        }

        public boolean hasDate() {
            return this.f16265c;
        }

        public boolean hasDistrictName() {
            return this.f16263a;
        }

        public boolean hasTimes() {
            return this.f16267e;
        }

        public final boolean isInitialized() {
            return true;
        }

        public HomecityDirstrict mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setDistrictName(codedInputStreamMicro.readString());
                        continue;
                    case 16:
                        setDate(codedInputStreamMicro.readInt32());
                        continue;
                    case 24:
                        setTimes(codedInputStreamMicro.readInt32());
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

        public HomecityDirstrict setDate(int i) {
            this.f16265c = true;
            this.f16266d = i;
            return this;
        }

        public HomecityDirstrict setDistrictName(String str) {
            this.f16263a = true;
            this.f16264b = str;
            return this;
        }

        public HomecityDirstrict setTimes(int i) {
            this.f16267e = true;
            this.f16268f = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasDistrictName()) {
                codedOutputStreamMicro.writeString(1, getDistrictName());
            }
            if (hasDate()) {
                codedOutputStreamMicro.writeInt32(2, getDate());
            }
            if (hasTimes()) {
                codedOutputStreamMicro.writeInt32(3, getTimes());
            }
        }
    }

    public static TrackExplore parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new TrackExplore().mergeFrom(codedInputStreamMicro);
    }

    public static TrackExplore parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (TrackExplore) new TrackExplore().mergeFrom(bArr);
    }

    public TrackExplore addArrivedCityList(ArrivedCity arrivedCity) {
        if (arrivedCity != null) {
            if (this.f16278i.isEmpty()) {
                this.f16278i = new ArrayList();
            }
            this.f16278i.add(arrivedCity);
        }
        return this;
    }

    public TrackExplore addHomecityDistrictList(HomecityDirstrict homecityDirstrict) {
        if (homecityDirstrict != null) {
            if (this.f16289t.isEmpty()) {
                this.f16289t = new ArrayList();
            }
            this.f16289t.add(homecityDirstrict);
        }
        return this;
    }

    public final TrackExplore clear() {
        clearPointNum();
        clearDistance();
        clearCityNum();
        clearProvinceNum();
        clearArrivedCityList();
        clearAcrossWestToEast();
        clearAcrossNorthToSouth();
        clearHomecity();
        clearPointPercentAtHomecity();
        clearHomecityDistrictNum();
        clearHomecityDistrictList();
        clearTradearea();
        clearPointPercentAtTradearea();
        this.f16294y = -1;
        return this;
    }

    public TrackExplore clearAcrossNorthToSouth() {
        this.f16281l = false;
        this.f16282m = null;
        return this;
    }

    public TrackExplore clearAcrossWestToEast() {
        this.f16279j = false;
        this.f16280k = null;
        return this;
    }

    public TrackExplore clearArrivedCityList() {
        this.f16278i = Collections.emptyList();
        return this;
    }

    public TrackExplore clearCityNum() {
        this.f16274e = false;
        this.f16275f = 0;
        return this;
    }

    public TrackExplore clearDistance() {
        this.f16272c = false;
        this.f16273d = "";
        return this;
    }

    public TrackExplore clearHomecity() {
        this.f16283n = false;
        this.f16284o = "";
        return this;
    }

    public TrackExplore clearHomecityDistrictList() {
        this.f16289t = Collections.emptyList();
        return this;
    }

    public TrackExplore clearHomecityDistrictNum() {
        this.f16287r = false;
        this.f16288s = 0;
        return this;
    }

    public TrackExplore clearPointNum() {
        this.f16270a = false;
        this.f16271b = 0;
        return this;
    }

    public TrackExplore clearPointPercentAtHomecity() {
        this.f16285p = false;
        this.f16286q = 0;
        return this;
    }

    public TrackExplore clearPointPercentAtTradearea() {
        this.f16292w = false;
        this.f16293x = "";
        return this;
    }

    public TrackExplore clearProvinceNum() {
        this.f16276g = false;
        this.f16277h = 0;
        return this;
    }

    public TrackExplore clearTradearea() {
        this.f16290u = false;
        this.f16291v = "";
        return this;
    }

    public AcrossNorthToSouth getAcrossNorthToSouth() {
        return this.f16282m;
    }

    public AcrossWestToEast getAcrossWestToEast() {
        return this.f16280k;
    }

    public ArrivedCity getArrivedCityList(int i) {
        return (ArrivedCity) this.f16278i.get(i);
    }

    public int getArrivedCityListCount() {
        return this.f16278i.size();
    }

    public List<ArrivedCity> getArrivedCityListList() {
        return this.f16278i;
    }

    public int getCachedSize() {
        if (this.f16294y < 0) {
            getSerializedSize();
        }
        return this.f16294y;
    }

    public int getCityNum() {
        return this.f16275f;
    }

    public String getDistance() {
        return this.f16273d;
    }

    public String getHomecity() {
        return this.f16284o;
    }

    public HomecityDirstrict getHomecityDistrictList(int i) {
        return (HomecityDirstrict) this.f16289t.get(i);
    }

    public int getHomecityDistrictListCount() {
        return this.f16289t.size();
    }

    public List<HomecityDirstrict> getHomecityDistrictListList() {
        return this.f16289t;
    }

    public int getHomecityDistrictNum() {
        return this.f16288s;
    }

    public int getPointNum() {
        return this.f16271b;
    }

    public int getPointPercentAtHomecity() {
        return this.f16286q;
    }

    public String getPointPercentAtTradearea() {
        return this.f16293x;
    }

    public int getProvinceNum() {
        return this.f16277h;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasPointNum()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getPointNum());
        }
        if (hasDistance()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getDistance());
        }
        if (hasCityNum()) {
            i += CodedOutputStreamMicro.computeInt32Size(3, getCityNum());
        }
        if (hasProvinceNum()) {
            i += CodedOutputStreamMicro.computeInt32Size(4, getProvinceNum());
        }
        int i2 = i;
        for (ArrivedCity computeMessageSize : getArrivedCityListList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(5, computeMessageSize) + i2;
        }
        if (hasAcrossWestToEast()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(6, getAcrossWestToEast());
        }
        if (hasAcrossNorthToSouth()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(7, getAcrossNorthToSouth());
        }
        if (hasHomecity()) {
            i2 += CodedOutputStreamMicro.computeStringSize(8, getHomecity());
        }
        if (hasPointPercentAtHomecity()) {
            i2 += CodedOutputStreamMicro.computeInt32Size(9, getPointPercentAtHomecity());
        }
        if (hasHomecityDistrictNum()) {
            i2 += CodedOutputStreamMicro.computeInt32Size(10, getHomecityDistrictNum());
        }
        for (HomecityDirstrict computeMessageSize2 : getHomecityDistrictListList()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(11, computeMessageSize2);
        }
        if (hasTradearea()) {
            i2 += CodedOutputStreamMicro.computeStringSize(12, getTradearea());
        }
        if (hasPointPercentAtTradearea()) {
            i2 += CodedOutputStreamMicro.computeStringSize(13, getPointPercentAtTradearea());
        }
        this.f16294y = i2;
        return i2;
    }

    public String getTradearea() {
        return this.f16291v;
    }

    public boolean hasAcrossNorthToSouth() {
        return this.f16281l;
    }

    public boolean hasAcrossWestToEast() {
        return this.f16279j;
    }

    public boolean hasCityNum() {
        return this.f16274e;
    }

    public boolean hasDistance() {
        return this.f16272c;
    }

    public boolean hasHomecity() {
        return this.f16283n;
    }

    public boolean hasHomecityDistrictNum() {
        return this.f16287r;
    }

    public boolean hasPointNum() {
        return this.f16270a;
    }

    public boolean hasPointPercentAtHomecity() {
        return this.f16285p;
    }

    public boolean hasPointPercentAtTradearea() {
        return this.f16292w;
    }

    public boolean hasProvinceNum() {
        return this.f16276g;
    }

    public boolean hasTradearea() {
        return this.f16290u;
    }

    public final boolean isInitialized() {
        return true;
    }

    public TrackExplore mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro arrivedCity;
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    setPointNum(codedInputStreamMicro.readInt32());
                    continue;
                case 18:
                    setDistance(codedInputStreamMicro.readString());
                    continue;
                case 24:
                    setCityNum(codedInputStreamMicro.readInt32());
                    continue;
                case 32:
                    setProvinceNum(codedInputStreamMicro.readInt32());
                    continue;
                case 42:
                    arrivedCity = new ArrivedCity();
                    codedInputStreamMicro.readMessage(arrivedCity);
                    addArrivedCityList(arrivedCity);
                    continue;
                case 50:
                    arrivedCity = new AcrossWestToEast();
                    codedInputStreamMicro.readMessage(arrivedCity);
                    setAcrossWestToEast(arrivedCity);
                    continue;
                case 58:
                    arrivedCity = new AcrossNorthToSouth();
                    codedInputStreamMicro.readMessage(arrivedCity);
                    setAcrossNorthToSouth(arrivedCity);
                    continue;
                case 66:
                    setHomecity(codedInputStreamMicro.readString());
                    continue;
                case NavCarInfo.CarType_57L /*72*/:
                    setPointPercentAtHomecity(codedInputStreamMicro.readInt32());
                    continue;
                case 80:
                    setHomecityDistrictNum(codedInputStreamMicro.readInt32());
                    continue;
                case 90:
                    arrivedCity = new HomecityDirstrict();
                    codedInputStreamMicro.readMessage(arrivedCity);
                    addHomecityDistrictList(arrivedCity);
                    continue;
                case 98:
                    setTradearea(codedInputStreamMicro.readString());
                    continue;
                case 106:
                    setPointPercentAtTradearea(codedInputStreamMicro.readString());
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

    public TrackExplore setAcrossNorthToSouth(AcrossNorthToSouth acrossNorthToSouth) {
        if (acrossNorthToSouth == null) {
            return clearAcrossNorthToSouth();
        }
        this.f16281l = true;
        this.f16282m = acrossNorthToSouth;
        return this;
    }

    public TrackExplore setAcrossWestToEast(AcrossWestToEast acrossWestToEast) {
        if (acrossWestToEast == null) {
            return clearAcrossWestToEast();
        }
        this.f16279j = true;
        this.f16280k = acrossWestToEast;
        return this;
    }

    public TrackExplore setArrivedCityList(int i, ArrivedCity arrivedCity) {
        if (arrivedCity != null) {
            this.f16278i.set(i, arrivedCity);
        }
        return this;
    }

    public TrackExplore setCityNum(int i) {
        this.f16274e = true;
        this.f16275f = i;
        return this;
    }

    public TrackExplore setDistance(String str) {
        this.f16272c = true;
        this.f16273d = str;
        return this;
    }

    public TrackExplore setHomecity(String str) {
        this.f16283n = true;
        this.f16284o = str;
        return this;
    }

    public TrackExplore setHomecityDistrictList(int i, HomecityDirstrict homecityDirstrict) {
        if (homecityDirstrict != null) {
            this.f16289t.set(i, homecityDirstrict);
        }
        return this;
    }

    public TrackExplore setHomecityDistrictNum(int i) {
        this.f16287r = true;
        this.f16288s = i;
        return this;
    }

    public TrackExplore setPointNum(int i) {
        this.f16270a = true;
        this.f16271b = i;
        return this;
    }

    public TrackExplore setPointPercentAtHomecity(int i) {
        this.f16285p = true;
        this.f16286q = i;
        return this;
    }

    public TrackExplore setPointPercentAtTradearea(String str) {
        this.f16292w = true;
        this.f16293x = str;
        return this;
    }

    public TrackExplore setProvinceNum(int i) {
        this.f16276g = true;
        this.f16277h = i;
        return this;
    }

    public TrackExplore setTradearea(String str) {
        this.f16290u = true;
        this.f16291v = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasPointNum()) {
            codedOutputStreamMicro.writeInt32(1, getPointNum());
        }
        if (hasDistance()) {
            codedOutputStreamMicro.writeString(2, getDistance());
        }
        if (hasCityNum()) {
            codedOutputStreamMicro.writeInt32(3, getCityNum());
        }
        if (hasProvinceNum()) {
            codedOutputStreamMicro.writeInt32(4, getProvinceNum());
        }
        for (ArrivedCity writeMessage : getArrivedCityListList()) {
            codedOutputStreamMicro.writeMessage(5, writeMessage);
        }
        if (hasAcrossWestToEast()) {
            codedOutputStreamMicro.writeMessage(6, getAcrossWestToEast());
        }
        if (hasAcrossNorthToSouth()) {
            codedOutputStreamMicro.writeMessage(7, getAcrossNorthToSouth());
        }
        if (hasHomecity()) {
            codedOutputStreamMicro.writeString(8, getHomecity());
        }
        if (hasPointPercentAtHomecity()) {
            codedOutputStreamMicro.writeInt32(9, getPointPercentAtHomecity());
        }
        if (hasHomecityDistrictNum()) {
            codedOutputStreamMicro.writeInt32(10, getHomecityDistrictNum());
        }
        for (HomecityDirstrict writeMessage2 : getHomecityDistrictListList()) {
            codedOutputStreamMicro.writeMessage(11, writeMessage2);
        }
        if (hasTradearea()) {
            codedOutputStreamMicro.writeString(12, getTradearea());
        }
        if (hasPointPercentAtTradearea()) {
            codedOutputStreamMicro.writeString(13, getPointPercentAtTradearea());
        }
    }
}
