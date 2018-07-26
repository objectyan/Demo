package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TrackRgc extends MessageMicro {
    public static final int LOC_INFO_FIELD_NUMBER = 1;
    /* renamed from: a */
    private List<LocInfo> f16370a = Collections.emptyList();
    /* renamed from: b */
    private int f16371b = -1;

    public static final class LocInfo extends MessageMicro {
        public static final int BUSINESS_FIELD_NUMBER = 7;
        public static final int CITY_FIELD_NUMBER = 3;
        public static final int DETAIL_FIELD_NUMBER = 9;
        public static final int DISTRICT_FIELD_NUMBER = 4;
        public static final int LAT_FIELD_NUMBER = 2;
        public static final int LNG_FIELD_NUMBER = 1;
        public static final int NEAR_POI_NAME_FIELD_NUMBER = 8;
        public static final int STREET_FIELD_NUMBER = 5;
        public static final int STREET_NUM_FIELD_NUMBER = 6;
        /* renamed from: a */
        private boolean f16351a;
        /* renamed from: b */
        private String f16352b = "";
        /* renamed from: c */
        private boolean f16353c;
        /* renamed from: d */
        private String f16354d = "";
        /* renamed from: e */
        private boolean f16355e;
        /* renamed from: f */
        private String f16356f = "";
        /* renamed from: g */
        private boolean f16357g;
        /* renamed from: h */
        private String f16358h = "";
        /* renamed from: i */
        private boolean f16359i;
        /* renamed from: j */
        private String f16360j = "";
        /* renamed from: k */
        private boolean f16361k;
        /* renamed from: l */
        private String f16362l = "";
        /* renamed from: m */
        private boolean f16363m;
        /* renamed from: n */
        private String f16364n = "";
        /* renamed from: o */
        private boolean f16365o;
        /* renamed from: p */
        private String f16366p = "";
        /* renamed from: q */
        private boolean f16367q;
        /* renamed from: r */
        private String f16368r = "";
        /* renamed from: s */
        private int f16369s = -1;

        public static LocInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new LocInfo().mergeFrom(codedInputStreamMicro);
        }

        public static LocInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (LocInfo) new LocInfo().mergeFrom(bArr);
        }

        public final LocInfo clear() {
            clearLng();
            clearLat();
            clearCity();
            clearDistrict();
            clearStreet();
            clearStreetNum();
            clearBusiness();
            clearNearPoiName();
            clearDetail();
            this.f16369s = -1;
            return this;
        }

        public LocInfo clearBusiness() {
            this.f16363m = false;
            this.f16364n = "";
            return this;
        }

        public LocInfo clearCity() {
            this.f16355e = false;
            this.f16356f = "";
            return this;
        }

        public LocInfo clearDetail() {
            this.f16367q = false;
            this.f16368r = "";
            return this;
        }

        public LocInfo clearDistrict() {
            this.f16357g = false;
            this.f16358h = "";
            return this;
        }

        public LocInfo clearLat() {
            this.f16353c = false;
            this.f16354d = "";
            return this;
        }

        public LocInfo clearLng() {
            this.f16351a = false;
            this.f16352b = "";
            return this;
        }

        public LocInfo clearNearPoiName() {
            this.f16365o = false;
            this.f16366p = "";
            return this;
        }

        public LocInfo clearStreet() {
            this.f16359i = false;
            this.f16360j = "";
            return this;
        }

        public LocInfo clearStreetNum() {
            this.f16361k = false;
            this.f16362l = "";
            return this;
        }

        public String getBusiness() {
            return this.f16364n;
        }

        public int getCachedSize() {
            if (this.f16369s < 0) {
                getSerializedSize();
            }
            return this.f16369s;
        }

        public String getCity() {
            return this.f16356f;
        }

        public String getDetail() {
            return this.f16368r;
        }

        public String getDistrict() {
            return this.f16358h;
        }

        public String getLat() {
            return this.f16354d;
        }

        public String getLng() {
            return this.f16352b;
        }

        public String getNearPoiName() {
            return this.f16366p;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasLng()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getLng());
            }
            if (hasLat()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getLat());
            }
            if (hasCity()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getCity());
            }
            if (hasDistrict()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getDistrict());
            }
            if (hasStreet()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getStreet());
            }
            if (hasStreetNum()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getStreetNum());
            }
            if (hasBusiness()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getBusiness());
            }
            if (hasNearPoiName()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getNearPoiName());
            }
            if (hasDetail()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getDetail());
            }
            this.f16369s = i;
            return i;
        }

        public String getStreet() {
            return this.f16360j;
        }

        public String getStreetNum() {
            return this.f16362l;
        }

        public boolean hasBusiness() {
            return this.f16363m;
        }

        public boolean hasCity() {
            return this.f16355e;
        }

        public boolean hasDetail() {
            return this.f16367q;
        }

        public boolean hasDistrict() {
            return this.f16357g;
        }

        public boolean hasLat() {
            return this.f16353c;
        }

        public boolean hasLng() {
            return this.f16351a;
        }

        public boolean hasNearPoiName() {
            return this.f16365o;
        }

        public boolean hasStreet() {
            return this.f16359i;
        }

        public boolean hasStreetNum() {
            return this.f16361k;
        }

        public final boolean isInitialized() {
            return true;
        }

        public LocInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setLng(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setLat(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setCity(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setDistrict(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setStreet(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setStreetNum(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setBusiness(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setNearPoiName(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setDetail(codedInputStreamMicro.readString());
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

        public LocInfo setBusiness(String str) {
            this.f16363m = true;
            this.f16364n = str;
            return this;
        }

        public LocInfo setCity(String str) {
            this.f16355e = true;
            this.f16356f = str;
            return this;
        }

        public LocInfo setDetail(String str) {
            this.f16367q = true;
            this.f16368r = str;
            return this;
        }

        public LocInfo setDistrict(String str) {
            this.f16357g = true;
            this.f16358h = str;
            return this;
        }

        public LocInfo setLat(String str) {
            this.f16353c = true;
            this.f16354d = str;
            return this;
        }

        public LocInfo setLng(String str) {
            this.f16351a = true;
            this.f16352b = str;
            return this;
        }

        public LocInfo setNearPoiName(String str) {
            this.f16365o = true;
            this.f16366p = str;
            return this;
        }

        public LocInfo setStreet(String str) {
            this.f16359i = true;
            this.f16360j = str;
            return this;
        }

        public LocInfo setStreetNum(String str) {
            this.f16361k = true;
            this.f16362l = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasLng()) {
                codedOutputStreamMicro.writeString(1, getLng());
            }
            if (hasLat()) {
                codedOutputStreamMicro.writeString(2, getLat());
            }
            if (hasCity()) {
                codedOutputStreamMicro.writeString(3, getCity());
            }
            if (hasDistrict()) {
                codedOutputStreamMicro.writeString(4, getDistrict());
            }
            if (hasStreet()) {
                codedOutputStreamMicro.writeString(5, getStreet());
            }
            if (hasStreetNum()) {
                codedOutputStreamMicro.writeString(6, getStreetNum());
            }
            if (hasBusiness()) {
                codedOutputStreamMicro.writeString(7, getBusiness());
            }
            if (hasNearPoiName()) {
                codedOutputStreamMicro.writeString(8, getNearPoiName());
            }
            if (hasDetail()) {
                codedOutputStreamMicro.writeString(9, getDetail());
            }
        }
    }

    public static TrackRgc parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new TrackRgc().mergeFrom(codedInputStreamMicro);
    }

    public static TrackRgc parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (TrackRgc) new TrackRgc().mergeFrom(bArr);
    }

    public TrackRgc addLocInfo(LocInfo locInfo) {
        if (locInfo != null) {
            if (this.f16370a.isEmpty()) {
                this.f16370a = new ArrayList();
            }
            this.f16370a.add(locInfo);
        }
        return this;
    }

    public final TrackRgc clear() {
        clearLocInfo();
        this.f16371b = -1;
        return this;
    }

    public TrackRgc clearLocInfo() {
        this.f16370a = Collections.emptyList();
        return this;
    }

    public int getCachedSize() {
        if (this.f16371b < 0) {
            getSerializedSize();
        }
        return this.f16371b;
    }

    public LocInfo getLocInfo(int i) {
        return (LocInfo) this.f16370a.get(i);
    }

    public int getLocInfoCount() {
        return this.f16370a.size();
    }

    public List<LocInfo> getLocInfoList() {
        return this.f16370a;
    }

    public int getSerializedSize() {
        int i = 0;
        for (LocInfo computeMessageSize : getLocInfoList()) {
            i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
        }
        this.f16371b = i;
        return i;
    }

    public final boolean isInitialized() {
        return true;
    }

    public TrackRgc mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    MessageMicro locInfo = new LocInfo();
                    codedInputStreamMicro.readMessage(locInfo);
                    addLocInfo(locInfo);
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

    public TrackRgc setLocInfo(int i, LocInfo locInfo) {
        if (locInfo != null) {
            this.f16370a.set(i, locInfo);
        }
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (LocInfo writeMessage : getLocInfoList()) {
            codedOutputStreamMicro.writeMessage(1, writeMessage);
        }
    }
}
