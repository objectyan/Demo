package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ReverseGeocoding extends MessageMicro {
    public static final int ADDRESS_DETAIL_FIELD_NUMBER = 6;
    public static final int ADDRESS_FIELD_NUMBER = 1;
    public static final int AREA_FIELD_NUMBER = 13;
    public static final int BUILDID_FIELD_NUMBER = 3;
    public static final int BUSINESS_FIELD_NUMBER = 7;
    public static final int FLOOR_FIELD_NUMBER = 2;
    public static final int NEARBY_FIELD_NUMBER = 11;
    public static final int PANO_FIELD_NUMBER = 4;
    public static final int POINT_FIELD_NUMBER = 9;
    public static final int POI_DESC_FIELD_NUMBER = 8;
    public static final int STREETSCAPEID_FIELD_NUMBER = 5;
    public static final int SURROUND_POI_FIELD_NUMBER = 10;
    public static final int TAIL_BAR_TEXT_FIELD_NUMBER = 12;
    /* renamed from: a */
    private boolean f14247a;
    /* renamed from: b */
    private String f14248b = "";
    /* renamed from: c */
    private boolean f14249c;
    /* renamed from: d */
    private String f14250d = "";
    /* renamed from: e */
    private boolean f14251e;
    /* renamed from: f */
    private String f14252f = "";
    /* renamed from: g */
    private boolean f14253g;
    /* renamed from: h */
    private int f14254h = 0;
    /* renamed from: i */
    private boolean f14255i;
    /* renamed from: j */
    private String f14256j = "";
    /* renamed from: k */
    private boolean f14257k;
    /* renamed from: l */
    private AddressDetail f14258l = null;
    /* renamed from: m */
    private boolean f14259m;
    /* renamed from: n */
    private String f14260n = "";
    /* renamed from: o */
    private boolean f14261o;
    /* renamed from: p */
    private String f14262p = "";
    /* renamed from: q */
    private boolean f14263q;
    /* renamed from: r */
    private Point f14264r = null;
    /* renamed from: s */
    private List<SurroundPoi> f14265s = Collections.emptyList();
    /* renamed from: t */
    private boolean f14266t;
    /* renamed from: u */
    private String f14267u = "";
    /* renamed from: v */
    private boolean f14268v;
    /* renamed from: w */
    private String f14269w = "";
    /* renamed from: x */
    private boolean f14270x;
    /* renamed from: y */
    private String f14271y = "";
    /* renamed from: z */
    private int f14272z = -1;

    public static final class AddressDetail extends MessageMicro {
        public static final int CITY_CODE_FIELD_NUMBER = 2;
        public static final int CITY_FIELD_NUMBER = 1;
        public static final int COUNTRY_CODE_FIELD_NUMBER = 4;
        public static final int COUNTRY_FIELD_NUMBER = 3;
        public static final int DISTRICT_FIELD_NUMBER = 5;
        public static final int PROVINCE_FIELD_NUMBER = 6;
        public static final int STREET_FIELD_NUMBER = 7;
        public static final int STREET_NUMBER_FIELD_NUMBER = 8;
        /* renamed from: a */
        private boolean f14209a;
        /* renamed from: b */
        private String f14210b = "";
        /* renamed from: c */
        private boolean f14211c;
        /* renamed from: d */
        private int f14212d = 0;
        /* renamed from: e */
        private boolean f14213e;
        /* renamed from: f */
        private String f14214f = "";
        /* renamed from: g */
        private boolean f14215g;
        /* renamed from: h */
        private int f14216h = 0;
        /* renamed from: i */
        private boolean f14217i;
        /* renamed from: j */
        private String f14218j = "";
        /* renamed from: k */
        private boolean f14219k;
        /* renamed from: l */
        private String f14220l = "";
        /* renamed from: m */
        private boolean f14221m;
        /* renamed from: n */
        private String f14222n = "";
        /* renamed from: o */
        private boolean f14223o;
        /* renamed from: p */
        private String f14224p = "";
        /* renamed from: q */
        private int f14225q = -1;

        public static AddressDetail parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new AddressDetail().mergeFrom(codedInputStreamMicro);
        }

        public static AddressDetail parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (AddressDetail) new AddressDetail().mergeFrom(bArr);
        }

        public final AddressDetail clear() {
            clearCity();
            clearCityCode();
            clearCountry();
            clearCountryCode();
            clearDistrict();
            clearProvince();
            clearStreet();
            clearStreetNumber();
            this.f14225q = -1;
            return this;
        }

        public AddressDetail clearCity() {
            this.f14209a = false;
            this.f14210b = "";
            return this;
        }

        public AddressDetail clearCityCode() {
            this.f14211c = false;
            this.f14212d = 0;
            return this;
        }

        public AddressDetail clearCountry() {
            this.f14213e = false;
            this.f14214f = "";
            return this;
        }

        public AddressDetail clearCountryCode() {
            this.f14215g = false;
            this.f14216h = 0;
            return this;
        }

        public AddressDetail clearDistrict() {
            this.f14217i = false;
            this.f14218j = "";
            return this;
        }

        public AddressDetail clearProvince() {
            this.f14219k = false;
            this.f14220l = "";
            return this;
        }

        public AddressDetail clearStreet() {
            this.f14221m = false;
            this.f14222n = "";
            return this;
        }

        public AddressDetail clearStreetNumber() {
            this.f14223o = false;
            this.f14224p = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f14225q < 0) {
                getSerializedSize();
            }
            return this.f14225q;
        }

        public String getCity() {
            return this.f14210b;
        }

        public int getCityCode() {
            return this.f14212d;
        }

        public String getCountry() {
            return this.f14214f;
        }

        public int getCountryCode() {
            return this.f14216h;
        }

        public String getDistrict() {
            return this.f14218j;
        }

        public String getProvince() {
            return this.f14220l;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasCity()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCity());
            }
            if (hasCityCode()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getCityCode());
            }
            if (hasCountry()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getCountry());
            }
            if (hasCountryCode()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, getCountryCode());
            }
            if (hasDistrict()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getDistrict());
            }
            if (hasProvince()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getProvince());
            }
            if (hasStreet()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getStreet());
            }
            if (hasStreetNumber()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getStreetNumber());
            }
            this.f14225q = i;
            return i;
        }

        public String getStreet() {
            return this.f14222n;
        }

        public String getStreetNumber() {
            return this.f14224p;
        }

        public boolean hasCity() {
            return this.f14209a;
        }

        public boolean hasCityCode() {
            return this.f14211c;
        }

        public boolean hasCountry() {
            return this.f14213e;
        }

        public boolean hasCountryCode() {
            return this.f14215g;
        }

        public boolean hasDistrict() {
            return this.f14217i;
        }

        public boolean hasProvince() {
            return this.f14219k;
        }

        public boolean hasStreet() {
            return this.f14221m;
        }

        public boolean hasStreetNumber() {
            return this.f14223o;
        }

        public final boolean isInitialized() {
            return true;
        }

        public AddressDetail mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setCity(codedInputStreamMicro.readString());
                        continue;
                    case 16:
                        setCityCode(codedInputStreamMicro.readInt32());
                        continue;
                    case 26:
                        setCountry(codedInputStreamMicro.readString());
                        continue;
                    case 32:
                        setCountryCode(codedInputStreamMicro.readInt32());
                        continue;
                    case 42:
                        setDistrict(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setProvince(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setStreet(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setStreetNumber(codedInputStreamMicro.readString());
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

        public AddressDetail setCity(String str) {
            this.f14209a = true;
            this.f14210b = str;
            return this;
        }

        public AddressDetail setCityCode(int i) {
            this.f14211c = true;
            this.f14212d = i;
            return this;
        }

        public AddressDetail setCountry(String str) {
            this.f14213e = true;
            this.f14214f = str;
            return this;
        }

        public AddressDetail setCountryCode(int i) {
            this.f14215g = true;
            this.f14216h = i;
            return this;
        }

        public AddressDetail setDistrict(String str) {
            this.f14217i = true;
            this.f14218j = str;
            return this;
        }

        public AddressDetail setProvince(String str) {
            this.f14219k = true;
            this.f14220l = str;
            return this;
        }

        public AddressDetail setStreet(String str) {
            this.f14221m = true;
            this.f14222n = str;
            return this;
        }

        public AddressDetail setStreetNumber(String str) {
            this.f14223o = true;
            this.f14224p = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasCity()) {
                codedOutputStreamMicro.writeString(1, getCity());
            }
            if (hasCityCode()) {
                codedOutputStreamMicro.writeInt32(2, getCityCode());
            }
            if (hasCountry()) {
                codedOutputStreamMicro.writeString(3, getCountry());
            }
            if (hasCountryCode()) {
                codedOutputStreamMicro.writeInt32(4, getCountryCode());
            }
            if (hasDistrict()) {
                codedOutputStreamMicro.writeString(5, getDistrict());
            }
            if (hasProvince()) {
                codedOutputStreamMicro.writeString(6, getProvince());
            }
            if (hasStreet()) {
                codedOutputStreamMicro.writeString(7, getStreet());
            }
            if (hasStreetNumber()) {
                codedOutputStreamMicro.writeString(8, getStreetNumber());
            }
        }
    }

    public static final class SurroundPoi extends MessageMicro {
        public static final int ADDR_FIELD_NUMBER = 1;
        public static final int BUILDINGID_FIELD_NUMBER = 7;
        public static final int DISTANCE_FIELD_NUMBER = 10;
        public static final int FLOORID_FIELD_NUMBER = 6;
        public static final int INDOORPANO_FIELD_NUMBER = 9;
        public static final int NAME_FIELD_NUMBER = 4;
        public static final int PANO_FIELD_NUMBER = 8;
        public static final int POINT_FIELD_NUMBER = 2;
        public static final int TAG_FIELD_NUMBER = 5;
        public static final int UID_FIELD_NUMBER = 3;
        /* renamed from: a */
        private boolean f14226a;
        /* renamed from: b */
        private String f14227b = "";
        /* renamed from: c */
        private boolean f14228c;
        /* renamed from: d */
        private Point f14229d = null;
        /* renamed from: e */
        private boolean f14230e;
        /* renamed from: f */
        private String f14231f = "";
        /* renamed from: g */
        private boolean f14232g;
        /* renamed from: h */
        private String f14233h = "";
        /* renamed from: i */
        private boolean f14234i;
        /* renamed from: j */
        private String f14235j = "";
        /* renamed from: k */
        private boolean f14236k;
        /* renamed from: l */
        private String f14237l = "";
        /* renamed from: m */
        private boolean f14238m;
        /* renamed from: n */
        private String f14239n = "";
        /* renamed from: o */
        private boolean f14240o;
        /* renamed from: p */
        private int f14241p = 0;
        /* renamed from: q */
        private boolean f14242q;
        /* renamed from: r */
        private String f14243r = "";
        /* renamed from: s */
        private boolean f14244s;
        /* renamed from: t */
        private double f14245t = 0.0d;
        /* renamed from: u */
        private int f14246u = -1;

        public static SurroundPoi parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new SurroundPoi().mergeFrom(codedInputStreamMicro);
        }

        public static SurroundPoi parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (SurroundPoi) new SurroundPoi().mergeFrom(bArr);
        }

        public final SurroundPoi clear() {
            clearAddr();
            clearPoint();
            clearUid();
            clearName();
            clearTag();
            clearFloorId();
            clearBuildingId();
            clearPano();
            clearIndoorPano();
            clearDistance();
            this.f14246u = -1;
            return this;
        }

        public SurroundPoi clearAddr() {
            this.f14226a = false;
            this.f14227b = "";
            return this;
        }

        public SurroundPoi clearBuildingId() {
            this.f14238m = false;
            this.f14239n = "";
            return this;
        }

        public SurroundPoi clearDistance() {
            this.f14244s = false;
            this.f14245t = 0.0d;
            return this;
        }

        public SurroundPoi clearFloorId() {
            this.f14236k = false;
            this.f14237l = "";
            return this;
        }

        public SurroundPoi clearIndoorPano() {
            this.f14242q = false;
            this.f14243r = "";
            return this;
        }

        public SurroundPoi clearName() {
            this.f14232g = false;
            this.f14233h = "";
            return this;
        }

        public SurroundPoi clearPano() {
            this.f14240o = false;
            this.f14241p = 0;
            return this;
        }

        public SurroundPoi clearPoint() {
            this.f14228c = false;
            this.f14229d = null;
            return this;
        }

        public SurroundPoi clearTag() {
            this.f14234i = false;
            this.f14235j = "";
            return this;
        }

        public SurroundPoi clearUid() {
            this.f14230e = false;
            this.f14231f = "";
            return this;
        }

        public String getAddr() {
            return this.f14227b;
        }

        public String getBuildingId() {
            return this.f14239n;
        }

        public int getCachedSize() {
            if (this.f14246u < 0) {
                getSerializedSize();
            }
            return this.f14246u;
        }

        public double getDistance() {
            return this.f14245t;
        }

        public String getFloorId() {
            return this.f14237l;
        }

        public String getIndoorPano() {
            return this.f14243r;
        }

        public String getName() {
            return this.f14233h;
        }

        public int getPano() {
            return this.f14241p;
        }

        public Point getPoint() {
            return this.f14229d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasAddr()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getAddr());
            }
            if (hasPoint()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getPoint());
            }
            if (hasUid()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getUid());
            }
            if (hasName()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getName());
            }
            if (hasTag()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getTag());
            }
            if (hasFloorId()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getFloorId());
            }
            if (hasBuildingId()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getBuildingId());
            }
            if (hasPano()) {
                i += CodedOutputStreamMicro.computeInt32Size(8, getPano());
            }
            if (hasIndoorPano()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getIndoorPano());
            }
            if (hasDistance()) {
                i += CodedOutputStreamMicro.computeDoubleSize(10, getDistance());
            }
            this.f14246u = i;
            return i;
        }

        public String getTag() {
            return this.f14235j;
        }

        public String getUid() {
            return this.f14231f;
        }

        public boolean hasAddr() {
            return this.f14226a;
        }

        public boolean hasBuildingId() {
            return this.f14238m;
        }

        public boolean hasDistance() {
            return this.f14244s;
        }

        public boolean hasFloorId() {
            return this.f14236k;
        }

        public boolean hasIndoorPano() {
            return this.f14242q;
        }

        public boolean hasName() {
            return this.f14232g;
        }

        public boolean hasPano() {
            return this.f14240o;
        }

        public boolean hasPoint() {
            return this.f14228c;
        }

        public boolean hasTag() {
            return this.f14234i;
        }

        public boolean hasUid() {
            return this.f14230e;
        }

        public final boolean isInitialized() {
            return true;
        }

        public SurroundPoi mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setAddr(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        MessageMicro point = new Point();
                        codedInputStreamMicro.readMessage(point);
                        setPoint(point);
                        continue;
                    case 26:
                        setUid(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setName(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setTag(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setFloorId(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setBuildingId(codedInputStreamMicro.readString());
                        continue;
                    case 64:
                        setPano(codedInputStreamMicro.readInt32());
                        continue;
                    case 74:
                        setIndoorPano(codedInputStreamMicro.readString());
                        continue;
                    case 81:
                        setDistance(codedInputStreamMicro.readDouble());
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

        public SurroundPoi setAddr(String str) {
            this.f14226a = true;
            this.f14227b = str;
            return this;
        }

        public SurroundPoi setBuildingId(String str) {
            this.f14238m = true;
            this.f14239n = str;
            return this;
        }

        public SurroundPoi setDistance(double d) {
            this.f14244s = true;
            this.f14245t = d;
            return this;
        }

        public SurroundPoi setFloorId(String str) {
            this.f14236k = true;
            this.f14237l = str;
            return this;
        }

        public SurroundPoi setIndoorPano(String str) {
            this.f14242q = true;
            this.f14243r = str;
            return this;
        }

        public SurroundPoi setName(String str) {
            this.f14232g = true;
            this.f14233h = str;
            return this;
        }

        public SurroundPoi setPano(int i) {
            this.f14240o = true;
            this.f14241p = i;
            return this;
        }

        public SurroundPoi setPoint(Point point) {
            if (point == null) {
                return clearPoint();
            }
            this.f14228c = true;
            this.f14229d = point;
            return this;
        }

        public SurroundPoi setTag(String str) {
            this.f14234i = true;
            this.f14235j = str;
            return this;
        }

        public SurroundPoi setUid(String str) {
            this.f14230e = true;
            this.f14231f = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasAddr()) {
                codedOutputStreamMicro.writeString(1, getAddr());
            }
            if (hasPoint()) {
                codedOutputStreamMicro.writeMessage(2, getPoint());
            }
            if (hasUid()) {
                codedOutputStreamMicro.writeString(3, getUid());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(4, getName());
            }
            if (hasTag()) {
                codedOutputStreamMicro.writeString(5, getTag());
            }
            if (hasFloorId()) {
                codedOutputStreamMicro.writeString(6, getFloorId());
            }
            if (hasBuildingId()) {
                codedOutputStreamMicro.writeString(7, getBuildingId());
            }
            if (hasPano()) {
                codedOutputStreamMicro.writeInt32(8, getPano());
            }
            if (hasIndoorPano()) {
                codedOutputStreamMicro.writeString(9, getIndoorPano());
            }
            if (hasDistance()) {
                codedOutputStreamMicro.writeDouble(10, getDistance());
            }
        }
    }

    public static ReverseGeocoding parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new ReverseGeocoding().mergeFrom(codedInputStreamMicro);
    }

    public static ReverseGeocoding parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (ReverseGeocoding) new ReverseGeocoding().mergeFrom(bArr);
    }

    public ReverseGeocoding addSurroundPoi(SurroundPoi surroundPoi) {
        if (surroundPoi != null) {
            if (this.f14265s.isEmpty()) {
                this.f14265s = new ArrayList();
            }
            this.f14265s.add(surroundPoi);
        }
        return this;
    }

    public final ReverseGeocoding clear() {
        clearAddress();
        clearFloor();
        clearBuildId();
        clearPano();
        clearStreetScapeID();
        clearAddressDetail();
        clearBusiness();
        clearPoiDesc();
        clearPoint();
        clearSurroundPoi();
        clearNearby();
        clearTailBarText();
        clearArea();
        this.f14272z = -1;
        return this;
    }

    public ReverseGeocoding clearAddress() {
        this.f14247a = false;
        this.f14248b = "";
        return this;
    }

    public ReverseGeocoding clearAddressDetail() {
        this.f14257k = false;
        this.f14258l = null;
        return this;
    }

    public ReverseGeocoding clearArea() {
        this.f14270x = false;
        this.f14271y = "";
        return this;
    }

    public ReverseGeocoding clearBuildId() {
        this.f14251e = false;
        this.f14252f = "";
        return this;
    }

    public ReverseGeocoding clearBusiness() {
        this.f14259m = false;
        this.f14260n = "";
        return this;
    }

    public ReverseGeocoding clearFloor() {
        this.f14249c = false;
        this.f14250d = "";
        return this;
    }

    public ReverseGeocoding clearNearby() {
        this.f14266t = false;
        this.f14267u = "";
        return this;
    }

    public ReverseGeocoding clearPano() {
        this.f14253g = false;
        this.f14254h = 0;
        return this;
    }

    public ReverseGeocoding clearPoiDesc() {
        this.f14261o = false;
        this.f14262p = "";
        return this;
    }

    public ReverseGeocoding clearPoint() {
        this.f14263q = false;
        this.f14264r = null;
        return this;
    }

    public ReverseGeocoding clearStreetScapeID() {
        this.f14255i = false;
        this.f14256j = "";
        return this;
    }

    public ReverseGeocoding clearSurroundPoi() {
        this.f14265s = Collections.emptyList();
        return this;
    }

    public ReverseGeocoding clearTailBarText() {
        this.f14268v = false;
        this.f14269w = "";
        return this;
    }

    public String getAddress() {
        return this.f14248b;
    }

    public AddressDetail getAddressDetail() {
        return this.f14258l;
    }

    public String getArea() {
        return this.f14271y;
    }

    public String getBuildId() {
        return this.f14252f;
    }

    public String getBusiness() {
        return this.f14260n;
    }

    public int getCachedSize() {
        if (this.f14272z < 0) {
            getSerializedSize();
        }
        return this.f14272z;
    }

    public String getFloor() {
        return this.f14250d;
    }

    public String getNearby() {
        return this.f14267u;
    }

    public int getPano() {
        return this.f14254h;
    }

    public String getPoiDesc() {
        return this.f14262p;
    }

    public Point getPoint() {
        return this.f14264r;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasAddress()) {
            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getAddress());
        }
        if (hasFloor()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getFloor());
        }
        if (hasBuildId()) {
            i += CodedOutputStreamMicro.computeStringSize(3, getBuildId());
        }
        if (hasPano()) {
            i += CodedOutputStreamMicro.computeInt32Size(4, getPano());
        }
        if (hasStreetScapeID()) {
            i += CodedOutputStreamMicro.computeStringSize(5, getStreetScapeID());
        }
        if (hasAddressDetail()) {
            i += CodedOutputStreamMicro.computeMessageSize(6, getAddressDetail());
        }
        if (hasBusiness()) {
            i += CodedOutputStreamMicro.computeStringSize(7, getBusiness());
        }
        if (hasPoiDesc()) {
            i += CodedOutputStreamMicro.computeStringSize(8, getPoiDesc());
        }
        if (hasPoint()) {
            i += CodedOutputStreamMicro.computeMessageSize(9, getPoint());
        }
        int i2 = i;
        for (SurroundPoi computeMessageSize : getSurroundPoiList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(10, computeMessageSize) + i2;
        }
        if (hasNearby()) {
            i2 += CodedOutputStreamMicro.computeStringSize(11, getNearby());
        }
        if (hasTailBarText()) {
            i2 += CodedOutputStreamMicro.computeStringSize(12, getTailBarText());
        }
        if (hasArea()) {
            i2 += CodedOutputStreamMicro.computeStringSize(13, getArea());
        }
        this.f14272z = i2;
        return i2;
    }

    public String getStreetScapeID() {
        return this.f14256j;
    }

    public SurroundPoi getSurroundPoi(int i) {
        return (SurroundPoi) this.f14265s.get(i);
    }

    public int getSurroundPoiCount() {
        return this.f14265s.size();
    }

    public List<SurroundPoi> getSurroundPoiList() {
        return this.f14265s;
    }

    public String getTailBarText() {
        return this.f14269w;
    }

    public boolean hasAddress() {
        return this.f14247a;
    }

    public boolean hasAddressDetail() {
        return this.f14257k;
    }

    public boolean hasArea() {
        return this.f14270x;
    }

    public boolean hasBuildId() {
        return this.f14251e;
    }

    public boolean hasBusiness() {
        return this.f14259m;
    }

    public boolean hasFloor() {
        return this.f14249c;
    }

    public boolean hasNearby() {
        return this.f14266t;
    }

    public boolean hasPano() {
        return this.f14253g;
    }

    public boolean hasPoiDesc() {
        return this.f14261o;
    }

    public boolean hasPoint() {
        return this.f14263q;
    }

    public boolean hasStreetScapeID() {
        return this.f14255i;
    }

    public boolean hasTailBarText() {
        return this.f14268v;
    }

    public final boolean isInitialized() {
        return true;
    }

    public ReverseGeocoding mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro addressDetail;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    setAddress(codedInputStreamMicro.readString());
                    continue;
                case 18:
                    setFloor(codedInputStreamMicro.readString());
                    continue;
                case 26:
                    setBuildId(codedInputStreamMicro.readString());
                    continue;
                case 32:
                    setPano(codedInputStreamMicro.readInt32());
                    continue;
                case 42:
                    setStreetScapeID(codedInputStreamMicro.readString());
                    continue;
                case 50:
                    addressDetail = new AddressDetail();
                    codedInputStreamMicro.readMessage(addressDetail);
                    setAddressDetail(addressDetail);
                    continue;
                case 58:
                    setBusiness(codedInputStreamMicro.readString());
                    continue;
                case 66:
                    setPoiDesc(codedInputStreamMicro.readString());
                    continue;
                case 74:
                    addressDetail = new Point();
                    codedInputStreamMicro.readMessage(addressDetail);
                    setPoint(addressDetail);
                    continue;
                case 82:
                    addressDetail = new SurroundPoi();
                    codedInputStreamMicro.readMessage(addressDetail);
                    addSurroundPoi(addressDetail);
                    continue;
                case 90:
                    setNearby(codedInputStreamMicro.readString());
                    continue;
                case 98:
                    setTailBarText(codedInputStreamMicro.readString());
                    continue;
                case 106:
                    setArea(codedInputStreamMicro.readString());
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

    public ReverseGeocoding setAddress(String str) {
        this.f14247a = true;
        this.f14248b = str;
        return this;
    }

    public ReverseGeocoding setAddressDetail(AddressDetail addressDetail) {
        if (addressDetail == null) {
            return clearAddressDetail();
        }
        this.f14257k = true;
        this.f14258l = addressDetail;
        return this;
    }

    public ReverseGeocoding setArea(String str) {
        this.f14270x = true;
        this.f14271y = str;
        return this;
    }

    public ReverseGeocoding setBuildId(String str) {
        this.f14251e = true;
        this.f14252f = str;
        return this;
    }

    public ReverseGeocoding setBusiness(String str) {
        this.f14259m = true;
        this.f14260n = str;
        return this;
    }

    public ReverseGeocoding setFloor(String str) {
        this.f14249c = true;
        this.f14250d = str;
        return this;
    }

    public ReverseGeocoding setNearby(String str) {
        this.f14266t = true;
        this.f14267u = str;
        return this;
    }

    public ReverseGeocoding setPano(int i) {
        this.f14253g = true;
        this.f14254h = i;
        return this;
    }

    public ReverseGeocoding setPoiDesc(String str) {
        this.f14261o = true;
        this.f14262p = str;
        return this;
    }

    public ReverseGeocoding setPoint(Point point) {
        if (point == null) {
            return clearPoint();
        }
        this.f14263q = true;
        this.f14264r = point;
        return this;
    }

    public ReverseGeocoding setStreetScapeID(String str) {
        this.f14255i = true;
        this.f14256j = str;
        return this;
    }

    public ReverseGeocoding setSurroundPoi(int i, SurroundPoi surroundPoi) {
        if (surroundPoi != null) {
            this.f14265s.set(i, surroundPoi);
        }
        return this;
    }

    public ReverseGeocoding setTailBarText(String str) {
        this.f14268v = true;
        this.f14269w = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasAddress()) {
            codedOutputStreamMicro.writeString(1, getAddress());
        }
        if (hasFloor()) {
            codedOutputStreamMicro.writeString(2, getFloor());
        }
        if (hasBuildId()) {
            codedOutputStreamMicro.writeString(3, getBuildId());
        }
        if (hasPano()) {
            codedOutputStreamMicro.writeInt32(4, getPano());
        }
        if (hasStreetScapeID()) {
            codedOutputStreamMicro.writeString(5, getStreetScapeID());
        }
        if (hasAddressDetail()) {
            codedOutputStreamMicro.writeMessage(6, getAddressDetail());
        }
        if (hasBusiness()) {
            codedOutputStreamMicro.writeString(7, getBusiness());
        }
        if (hasPoiDesc()) {
            codedOutputStreamMicro.writeString(8, getPoiDesc());
        }
        if (hasPoint()) {
            codedOutputStreamMicro.writeMessage(9, getPoint());
        }
        for (SurroundPoi writeMessage : getSurroundPoiList()) {
            codedOutputStreamMicro.writeMessage(10, writeMessage);
        }
        if (hasNearby()) {
            codedOutputStreamMicro.writeString(11, getNearby());
        }
        if (hasTailBarText()) {
            codedOutputStreamMicro.writeString(12, getTailBarText());
        }
        if (hasArea()) {
            codedOutputStreamMicro.writeString(13, getArea());
        }
    }
}
