package com.baidu.entity.pb;

import com.baidu.baidunavis.model.NavCarInfo;
import com.baidu.carlife.core.C1253f;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver;
import com.baidu.navisdk.ui.routeguide.model.RGHUDDataModel;
import com.baidu.platform.comapi.map.provider.RouteLineResConst;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Bus extends MessageMicro {
    public static final int CURRENT_CITY_FIELD_NUMBER = 2;
    public static final int CYCLE_FIELD_NUMBER = 9;
    public static final int EMERGENCY_TIP_FIELD_NUMBER = 6;
    public static final int OPTION_FIELD_NUMBER = 4;
    public static final int REDIS_KEY_FIELD_NUMBER = 7;
    public static final int ROUTES_FIELD_NUMBER = 3;
    public static final int TAXI_FIELD_NUMBER = 1;
    public static final int WALK_FIELD_NUMBER = 8;
    public static final int ZHUANCHE_FIELD_NUMBER = 5;
    /* renamed from: a */
    private boolean f10343a;
    /* renamed from: b */
    private Taxi f10344b = null;
    /* renamed from: c */
    private boolean f10345c;
    /* renamed from: d */
    private CurrentCity f10346d = null;
    /* renamed from: e */
    private List<Routes> f10347e = Collections.emptyList();
    /* renamed from: f */
    private boolean f10348f;
    /* renamed from: g */
    private Option f10349g = null;
    /* renamed from: h */
    private boolean f10350h;
    /* renamed from: i */
    private Zhuanche f10351i = null;
    /* renamed from: j */
    private boolean f10352j;
    /* renamed from: k */
    private String f10353k = "";
    /* renamed from: l */
    private boolean f10354l;
    /* renamed from: m */
    private String f10355m = "";
    /* renamed from: n */
    private boolean f10356n;
    /* renamed from: o */
    private Walk f10357o = null;
    /* renamed from: p */
    private boolean f10358p;
    /* renamed from: q */
    private Cycle f10359q = null;
    /* renamed from: r */
    private int f10360r = -1;

    public static final class Cycle extends MessageMicro {
        public static final int DISTANCE_FIELD_NUMBER = 3;
        public static final int IS_BETTER_FIELD_NUMBER = 1;
        public static final int TIME_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f9828a;
        /* renamed from: b */
        private int f9829b = 0;
        /* renamed from: c */
        private boolean f9830c;
        /* renamed from: d */
        private String f9831d = "";
        /* renamed from: e */
        private boolean f9832e;
        /* renamed from: f */
        private String f9833f = "";
        /* renamed from: g */
        private int f9834g = -1;

        public static Cycle parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Cycle().mergeFrom(codedInputStreamMicro);
        }

        public static Cycle parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Cycle) new Cycle().mergeFrom(bArr);
        }

        public final Cycle clear() {
            clearIsBetter();
            clearTime();
            clearDistance();
            this.f9834g = -1;
            return this;
        }

        public Cycle clearDistance() {
            this.f9832e = false;
            this.f9833f = "";
            return this;
        }

        public Cycle clearIsBetter() {
            this.f9828a = false;
            this.f9829b = 0;
            return this;
        }

        public Cycle clearTime() {
            this.f9830c = false;
            this.f9831d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f9834g < 0) {
                getSerializedSize();
            }
            return this.f9834g;
        }

        public String getDistance() {
            return this.f9833f;
        }

        public int getIsBetter() {
            return this.f9829b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasIsBetter()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIsBetter());
            }
            if (hasTime()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getTime());
            }
            if (hasDistance()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getDistance());
            }
            this.f9834g = i;
            return i;
        }

        public String getTime() {
            return this.f9831d;
        }

        public boolean hasDistance() {
            return this.f9832e;
        }

        public boolean hasIsBetter() {
            return this.f9828a;
        }

        public boolean hasTime() {
            return this.f9830c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Cycle mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setIsBetter(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setTime(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setDistance(codedInputStreamMicro.readString());
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

        public Cycle setDistance(String str) {
            this.f9832e = true;
            this.f9833f = str;
            return this;
        }

        public Cycle setIsBetter(int i) {
            this.f9828a = true;
            this.f9829b = i;
            return this;
        }

        public Cycle setTime(String str) {
            this.f9830c = true;
            this.f9831d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIsBetter()) {
                codedOutputStreamMicro.writeInt32(1, getIsBetter());
            }
            if (hasTime()) {
                codedOutputStreamMicro.writeString(2, getTime());
            }
            if (hasDistance()) {
                codedOutputStreamMicro.writeString(3, getDistance());
            }
        }
    }

    public static final class Option extends MessageMicro {
        public static final int CITY_INFO_FIELD_NUMBER = 17;
        public static final int CSY_FIELD_NUMBER = 6;
        public static final int CTY_FIELD_NUMBER = 7;
        public static final int DATA_PROVIDER_FIELD_NUMBER = 14;
        public static final int END_FIELD_NUMBER = 5;
        public static final int EXPTIME_FIELD_NUMBER = 2;
        public static final int FY_FIELD_NUMBER = 11;
        public static final int IC_START_FIELD_NUMBER = 13;
        public static final int INTER_CITY_FIELD_NUMBER = 8;
        public static final int PN_FIELD_NUMBER = 9;
        public static final int RN_FIELD_NUMBER = 10;
        public static final int RTBUS_UPDATE_INTERVAL_FIELD_NUMBER = 16;
        public static final int SESSION_IN_FIELD_NUMBER = 15;
        public static final int START_FIELD_NUMBER = 4;
        public static final int START_TIMES_FIELD_NUMBER = 12;
        public static final int SY_FIELD_NUMBER = 3;
        public static final int TOTAL_FIELD_NUMBER = 1;
        /* renamed from: A */
        private boolean f9877A;
        /* renamed from: B */
        private String f9878B = "";
        /* renamed from: C */
        private boolean f9879C;
        /* renamed from: D */
        private int f9880D = 0;
        /* renamed from: E */
        private boolean f9881E;
        /* renamed from: F */
        private CityInfo f9882F = null;
        /* renamed from: G */
        private int f9883G = -1;
        /* renamed from: a */
        private boolean f9884a;
        /* renamed from: b */
        private int f9885b = 0;
        /* renamed from: c */
        private boolean f9886c;
        /* renamed from: d */
        private String f9887d = "";
        /* renamed from: e */
        private boolean f9888e;
        /* renamed from: f */
        private int f9889f = 0;
        /* renamed from: g */
        private boolean f9890g;
        /* renamed from: h */
        private Start f9891h = null;
        /* renamed from: i */
        private boolean f9892i;
        /* renamed from: j */
        private End f9893j = null;
        /* renamed from: k */
        private boolean f9894k;
        /* renamed from: l */
        private int f9895l = 0;
        /* renamed from: m */
        private boolean f9896m;
        /* renamed from: n */
        private int f9897n = 0;
        /* renamed from: o */
        private boolean f9898o;
        /* renamed from: p */
        private int f9899p = 0;
        /* renamed from: q */
        private boolean f9900q;
        /* renamed from: r */
        private int f9901r = 0;
        /* renamed from: s */
        private boolean f9902s;
        /* renamed from: t */
        private int f9903t = 0;
        /* renamed from: u */
        private boolean f9904u;
        /* renamed from: v */
        private int f9905v = 0;
        /* renamed from: w */
        private List<String> f9906w = Collections.emptyList();
        /* renamed from: x */
        private boolean f9907x;
        /* renamed from: y */
        private String f9908y = "";
        /* renamed from: z */
        private List<DataProvider> f9909z = Collections.emptyList();

        public static final class CityInfo extends MessageMicro {
            public static final int CITY_ID_FIELD_NUMBER = 1;
            public static final int SUP_CYCLE_FIELD_NUMBER = 4;
            public static final int SUP_RTBUS_FIELD_NUMBER = 3;
            public static final int SUP_SUBWAY_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f9835a;
            /* renamed from: b */
            private int f9836b = 0;
            /* renamed from: c */
            private boolean f9837c;
            /* renamed from: d */
            private int f9838d = 0;
            /* renamed from: e */
            private boolean f9839e;
            /* renamed from: f */
            private int f9840f = 0;
            /* renamed from: g */
            private boolean f9841g;
            /* renamed from: h */
            private int f9842h = 0;
            /* renamed from: i */
            private int f9843i = -1;

            public static CityInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new CityInfo().mergeFrom(codedInputStreamMicro);
            }

            public static CityInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (CityInfo) new CityInfo().mergeFrom(bArr);
            }

            public final CityInfo clear() {
                clearCityId();
                clearSupSubway();
                clearSupRtbus();
                clearSupCycle();
                this.f9843i = -1;
                return this;
            }

            public CityInfo clearCityId() {
                this.f9835a = false;
                this.f9836b = 0;
                return this;
            }

            public CityInfo clearSupCycle() {
                this.f9841g = false;
                this.f9842h = 0;
                return this;
            }

            public CityInfo clearSupRtbus() {
                this.f9839e = false;
                this.f9840f = 0;
                return this;
            }

            public CityInfo clearSupSubway() {
                this.f9837c = false;
                this.f9838d = 0;
                return this;
            }

            public int getCachedSize() {
                if (this.f9843i < 0) {
                    getSerializedSize();
                }
                return this.f9843i;
            }

            public int getCityId() {
                return this.f9836b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasCityId()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCityId());
                }
                if (hasSupSubway()) {
                    i += CodedOutputStreamMicro.computeInt32Size(2, getSupSubway());
                }
                if (hasSupRtbus()) {
                    i += CodedOutputStreamMicro.computeInt32Size(3, getSupRtbus());
                }
                if (hasSupCycle()) {
                    i += CodedOutputStreamMicro.computeInt32Size(4, getSupCycle());
                }
                this.f9843i = i;
                return i;
            }

            public int getSupCycle() {
                return this.f9842h;
            }

            public int getSupRtbus() {
                return this.f9840f;
            }

            public int getSupSubway() {
                return this.f9838d;
            }

            public boolean hasCityId() {
                return this.f9835a;
            }

            public boolean hasSupCycle() {
                return this.f9841g;
            }

            public boolean hasSupRtbus() {
                return this.f9839e;
            }

            public boolean hasSupSubway() {
                return this.f9837c;
            }

            public final boolean isInitialized() {
                return true;
            }

            public CityInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            setCityId(codedInputStreamMicro.readInt32());
                            continue;
                        case 16:
                            setSupSubway(codedInputStreamMicro.readInt32());
                            continue;
                        case 24:
                            setSupRtbus(codedInputStreamMicro.readInt32());
                            continue;
                        case 32:
                            setSupCycle(codedInputStreamMicro.readInt32());
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

            public CityInfo setCityId(int i) {
                this.f9835a = true;
                this.f9836b = i;
                return this;
            }

            public CityInfo setSupCycle(int i) {
                this.f9841g = true;
                this.f9842h = i;
                return this;
            }

            public CityInfo setSupRtbus(int i) {
                this.f9839e = true;
                this.f9840f = i;
                return this;
            }

            public CityInfo setSupSubway(int i) {
                this.f9837c = true;
                this.f9838d = i;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasCityId()) {
                    codedOutputStreamMicro.writeInt32(1, getCityId());
                }
                if (hasSupSubway()) {
                    codedOutputStreamMicro.writeInt32(2, getSupSubway());
                }
                if (hasSupRtbus()) {
                    codedOutputStreamMicro.writeInt32(3, getSupRtbus());
                }
                if (hasSupCycle()) {
                    codedOutputStreamMicro.writeInt32(4, getSupCycle());
                }
            }
        }

        public static final class DataProvider extends MessageMicro {
            public static final int NAME_FIELD_NUMBER = 1;
            public static final int TEL_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f9844a;
            /* renamed from: b */
            private String f9845b = "";
            /* renamed from: c */
            private boolean f9846c;
            /* renamed from: d */
            private String f9847d = "";
            /* renamed from: e */
            private int f9848e = -1;

            public static DataProvider parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new DataProvider().mergeFrom(codedInputStreamMicro);
            }

            public static DataProvider parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (DataProvider) new DataProvider().mergeFrom(bArr);
            }

            public final DataProvider clear() {
                clearName();
                clearTel();
                this.f9848e = -1;
                return this;
            }

            public DataProvider clearName() {
                this.f9844a = false;
                this.f9845b = "";
                return this;
            }

            public DataProvider clearTel() {
                this.f9846c = false;
                this.f9847d = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f9848e < 0) {
                    getSerializedSize();
                }
                return this.f9848e;
            }

            public String getName() {
                return this.f9845b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasName()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
                }
                if (hasTel()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getTel());
                }
                this.f9848e = i;
                return i;
            }

            public String getTel() {
                return this.f9847d;
            }

            public boolean hasName() {
                return this.f9844a;
            }

            public boolean hasTel() {
                return this.f9846c;
            }

            public final boolean isInitialized() {
                return true;
            }

            public DataProvider mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setName(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setTel(codedInputStreamMicro.readString());
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

            public DataProvider setName(String str) {
                this.f9844a = true;
                this.f9845b = str;
                return this;
            }

            public DataProvider setTel(String str) {
                this.f9846c = true;
                this.f9847d = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasName()) {
                    codedOutputStreamMicro.writeString(1, getName());
                }
                if (hasTel()) {
                    codedOutputStreamMicro.writeString(2, getTel());
                }
            }
        }

        public static final class End extends MessageMicro {
            public static final int COUNTY_ID_FIELD_NUMBER = 6;
            public static final int PT_FIELD_NUMBER = 1;
            public static final int RGC_NAME_FIELD_NUMBER = 5;
            public static final int SPT_FIELD_NUMBER = 4;
            public static final int UID_FIELD_NUMBER = 3;
            public static final int WD_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f9849a;
            /* renamed from: b */
            private String f9850b = "";
            /* renamed from: c */
            private boolean f9851c;
            /* renamed from: d */
            private String f9852d = "";
            /* renamed from: e */
            private boolean f9853e;
            /* renamed from: f */
            private String f9854f = "";
            /* renamed from: g */
            private List<Integer> f9855g = Collections.emptyList();
            /* renamed from: h */
            private boolean f9856h;
            /* renamed from: i */
            private String f9857i = "";
            /* renamed from: j */
            private boolean f9858j;
            /* renamed from: k */
            private int f9859k = 0;
            /* renamed from: l */
            private int f9860l = -1;

            public static End parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new End().mergeFrom(codedInputStreamMicro);
            }

            public static End parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (End) new End().mergeFrom(bArr);
            }

            public End addSpt(int i) {
                if (this.f9855g.isEmpty()) {
                    this.f9855g = new ArrayList();
                }
                this.f9855g.add(Integer.valueOf(i));
                return this;
            }

            public final End clear() {
                clearPt();
                clearWd();
                clearUid();
                clearSpt();
                clearRgcName();
                clearCountyId();
                this.f9860l = -1;
                return this;
            }

            public End clearCountyId() {
                this.f9858j = false;
                this.f9859k = 0;
                return this;
            }

            public End clearPt() {
                this.f9849a = false;
                this.f9850b = "";
                return this;
            }

            public End clearRgcName() {
                this.f9856h = false;
                this.f9857i = "";
                return this;
            }

            public End clearSpt() {
                this.f9855g = Collections.emptyList();
                return this;
            }

            public End clearUid() {
                this.f9853e = false;
                this.f9854f = "";
                return this;
            }

            public End clearWd() {
                this.f9851c = false;
                this.f9852d = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f9860l < 0) {
                    getSerializedSize();
                }
                return this.f9860l;
            }

            public int getCountyId() {
                return this.f9859k;
            }

            public String getPt() {
                return this.f9850b;
            }

            public String getRgcName() {
                return this.f9857i;
            }

            public int getSerializedSize() {
                int i = 0;
                int computeStringSize = hasPt() ? CodedOutputStreamMicro.computeStringSize(1, getPt()) + 0 : 0;
                if (hasWd()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getWd());
                }
                int computeStringSize2 = hasUid() ? computeStringSize + CodedOutputStreamMicro.computeStringSize(3, getUid()) : computeStringSize;
                for (Integer intValue : getSptList()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue());
                }
                computeStringSize = (computeStringSize2 + i) + (getSptList().size() * 1);
                if (hasRgcName()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getRgcName());
                }
                if (hasCountyId()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(6, getCountyId());
                }
                this.f9860l = computeStringSize;
                return computeStringSize;
            }

            public int getSpt(int i) {
                return ((Integer) this.f9855g.get(i)).intValue();
            }

            public int getSptCount() {
                return this.f9855g.size();
            }

            public List<Integer> getSptList() {
                return this.f9855g;
            }

            public String getUid() {
                return this.f9854f;
            }

            public String getWd() {
                return this.f9852d;
            }

            public boolean hasCountyId() {
                return this.f9858j;
            }

            public boolean hasPt() {
                return this.f9849a;
            }

            public boolean hasRgcName() {
                return this.f9856h;
            }

            public boolean hasUid() {
                return this.f9853e;
            }

            public boolean hasWd() {
                return this.f9851c;
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
                        case 10:
                            setPt(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setWd(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setUid(codedInputStreamMicro.readString());
                            continue;
                        case 32:
                            addSpt(codedInputStreamMicro.readSInt32());
                            continue;
                        case 42:
                            setRgcName(codedInputStreamMicro.readString());
                            continue;
                        case 48:
                            setCountyId(codedInputStreamMicro.readInt32());
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

            public End setCountyId(int i) {
                this.f9858j = true;
                this.f9859k = i;
                return this;
            }

            public End setPt(String str) {
                this.f9849a = true;
                this.f9850b = str;
                return this;
            }

            public End setRgcName(String str) {
                this.f9856h = true;
                this.f9857i = str;
                return this;
            }

            public End setSpt(int i, int i2) {
                this.f9855g.set(i, Integer.valueOf(i2));
                return this;
            }

            public End setUid(String str) {
                this.f9853e = true;
                this.f9854f = str;
                return this;
            }

            public End setWd(String str) {
                this.f9851c = true;
                this.f9852d = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasPt()) {
                    codedOutputStreamMicro.writeString(1, getPt());
                }
                if (hasWd()) {
                    codedOutputStreamMicro.writeString(2, getWd());
                }
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(3, getUid());
                }
                for (Integer intValue : getSptList()) {
                    codedOutputStreamMicro.writeSInt32(4, intValue.intValue());
                }
                if (hasRgcName()) {
                    codedOutputStreamMicro.writeString(5, getRgcName());
                }
                if (hasCountyId()) {
                    codedOutputStreamMicro.writeInt32(6, getCountyId());
                }
            }
        }

        public static final class Start extends MessageMicro {
            public static final int PT_FIELD_NUMBER = 1;
            public static final int RGC_NAME_FIELD_NUMBER = 5;
            public static final int SPT_FIELD_NUMBER = 4;
            public static final int STATION_LIST_FIELD_NUMBER = 6;
            public static final int UID_FIELD_NUMBER = 3;
            public static final int WD_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f9866a;
            /* renamed from: b */
            private String f9867b = "";
            /* renamed from: c */
            private boolean f9868c;
            /* renamed from: d */
            private String f9869d = "";
            /* renamed from: e */
            private boolean f9870e;
            /* renamed from: f */
            private String f9871f = "";
            /* renamed from: g */
            private List<Integer> f9872g = Collections.emptyList();
            /* renamed from: h */
            private boolean f9873h;
            /* renamed from: i */
            private String f9874i = "";
            /* renamed from: j */
            private List<StationList> f9875j = Collections.emptyList();
            /* renamed from: k */
            private int f9876k = -1;

            public static final class StationList extends MessageMicro {
                public static final int STATION_NAME_FIELD_NUMBER = 1;
                public static final int STATION_UID_FIELD_NUMBER = 2;
                /* renamed from: a */
                private boolean f9861a;
                /* renamed from: b */
                private String f9862b = "";
                /* renamed from: c */
                private boolean f9863c;
                /* renamed from: d */
                private String f9864d = "";
                /* renamed from: e */
                private int f9865e = -1;

                public static StationList parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new StationList().mergeFrom(codedInputStreamMicro);
                }

                public static StationList parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (StationList) new StationList().mergeFrom(bArr);
                }

                public final StationList clear() {
                    clearStationName();
                    clearStationUid();
                    this.f9865e = -1;
                    return this;
                }

                public StationList clearStationName() {
                    this.f9861a = false;
                    this.f9862b = "";
                    return this;
                }

                public StationList clearStationUid() {
                    this.f9863c = false;
                    this.f9864d = "";
                    return this;
                }

                public int getCachedSize() {
                    if (this.f9865e < 0) {
                        getSerializedSize();
                    }
                    return this.f9865e;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasStationName()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getStationName());
                    }
                    if (hasStationUid()) {
                        i += CodedOutputStreamMicro.computeStringSize(2, getStationUid());
                    }
                    this.f9865e = i;
                    return i;
                }

                public String getStationName() {
                    return this.f9862b;
                }

                public String getStationUid() {
                    return this.f9864d;
                }

                public boolean hasStationName() {
                    return this.f9861a;
                }

                public boolean hasStationUid() {
                    return this.f9863c;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public StationList mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                setStationName(codedInputStreamMicro.readString());
                                continue;
                            case 18:
                                setStationUid(codedInputStreamMicro.readString());
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

                public StationList setStationName(String str) {
                    this.f9861a = true;
                    this.f9862b = str;
                    return this;
                }

                public StationList setStationUid(String str) {
                    this.f9863c = true;
                    this.f9864d = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasStationName()) {
                        codedOutputStreamMicro.writeString(1, getStationName());
                    }
                    if (hasStationUid()) {
                        codedOutputStreamMicro.writeString(2, getStationUid());
                    }
                }
            }

            public static Start parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Start().mergeFrom(codedInputStreamMicro);
            }

            public static Start parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Start) new Start().mergeFrom(bArr);
            }

            public Start addSpt(int i) {
                if (this.f9872g.isEmpty()) {
                    this.f9872g = new ArrayList();
                }
                this.f9872g.add(Integer.valueOf(i));
                return this;
            }

            public Start addStationList(StationList stationList) {
                if (stationList != null) {
                    if (this.f9875j.isEmpty()) {
                        this.f9875j = new ArrayList();
                    }
                    this.f9875j.add(stationList);
                }
                return this;
            }

            public final Start clear() {
                clearPt();
                clearWd();
                clearUid();
                clearSpt();
                clearRgcName();
                clearStationList();
                this.f9876k = -1;
                return this;
            }

            public Start clearPt() {
                this.f9866a = false;
                this.f9867b = "";
                return this;
            }

            public Start clearRgcName() {
                this.f9873h = false;
                this.f9874i = "";
                return this;
            }

            public Start clearSpt() {
                this.f9872g = Collections.emptyList();
                return this;
            }

            public Start clearStationList() {
                this.f9875j = Collections.emptyList();
                return this;
            }

            public Start clearUid() {
                this.f9870e = false;
                this.f9871f = "";
                return this;
            }

            public Start clearWd() {
                this.f9868c = false;
                this.f9869d = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f9876k < 0) {
                    getSerializedSize();
                }
                return this.f9876k;
            }

            public String getPt() {
                return this.f9867b;
            }

            public String getRgcName() {
                return this.f9874i;
            }

            public int getSerializedSize() {
                int i = 0;
                int computeStringSize = hasPt() ? CodedOutputStreamMicro.computeStringSize(1, getPt()) + 0 : 0;
                if (hasWd()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getWd());
                }
                int computeStringSize2 = hasUid() ? computeStringSize + CodedOutputStreamMicro.computeStringSize(3, getUid()) : computeStringSize;
                for (Integer intValue : getSptList()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue());
                }
                computeStringSize = (computeStringSize2 + i) + (getSptList().size() * 1);
                if (hasRgcName()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getRgcName());
                }
                i = computeStringSize;
                for (StationList computeMessageSize : getStationListList()) {
                    i = CodedOutputStreamMicro.computeMessageSize(6, computeMessageSize) + i;
                }
                this.f9876k = i;
                return i;
            }

            public int getSpt(int i) {
                return ((Integer) this.f9872g.get(i)).intValue();
            }

            public int getSptCount() {
                return this.f9872g.size();
            }

            public List<Integer> getSptList() {
                return this.f9872g;
            }

            public StationList getStationList(int i) {
                return (StationList) this.f9875j.get(i);
            }

            public int getStationListCount() {
                return this.f9875j.size();
            }

            public List<StationList> getStationListList() {
                return this.f9875j;
            }

            public String getUid() {
                return this.f9871f;
            }

            public String getWd() {
                return this.f9869d;
            }

            public boolean hasPt() {
                return this.f9866a;
            }

            public boolean hasRgcName() {
                return this.f9873h;
            }

            public boolean hasUid() {
                return this.f9870e;
            }

            public boolean hasWd() {
                return this.f9868c;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Start mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setPt(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setWd(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setUid(codedInputStreamMicro.readString());
                            continue;
                        case 32:
                            addSpt(codedInputStreamMicro.readSInt32());
                            continue;
                        case 42:
                            setRgcName(codedInputStreamMicro.readString());
                            continue;
                        case 50:
                            MessageMicro stationList = new StationList();
                            codedInputStreamMicro.readMessage(stationList);
                            addStationList(stationList);
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

            public Start setPt(String str) {
                this.f9866a = true;
                this.f9867b = str;
                return this;
            }

            public Start setRgcName(String str) {
                this.f9873h = true;
                this.f9874i = str;
                return this;
            }

            public Start setSpt(int i, int i2) {
                this.f9872g.set(i, Integer.valueOf(i2));
                return this;
            }

            public Start setStationList(int i, StationList stationList) {
                if (stationList != null) {
                    this.f9875j.set(i, stationList);
                }
                return this;
            }

            public Start setUid(String str) {
                this.f9870e = true;
                this.f9871f = str;
                return this;
            }

            public Start setWd(String str) {
                this.f9868c = true;
                this.f9869d = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasPt()) {
                    codedOutputStreamMicro.writeString(1, getPt());
                }
                if (hasWd()) {
                    codedOutputStreamMicro.writeString(2, getWd());
                }
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(3, getUid());
                }
                for (Integer intValue : getSptList()) {
                    codedOutputStreamMicro.writeSInt32(4, intValue.intValue());
                }
                if (hasRgcName()) {
                    codedOutputStreamMicro.writeString(5, getRgcName());
                }
                for (StationList writeMessage : getStationListList()) {
                    codedOutputStreamMicro.writeMessage(6, writeMessage);
                }
            }
        }

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }

        public Option addDataProvider(DataProvider dataProvider) {
            if (dataProvider != null) {
                if (this.f9909z.isEmpty()) {
                    this.f9909z = new ArrayList();
                }
                this.f9909z.add(dataProvider);
            }
            return this;
        }

        public Option addStartTimes(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f9906w.isEmpty()) {
                this.f9906w = new ArrayList();
            }
            this.f9906w.add(str);
            return this;
        }

        public final Option clear() {
            clearTotal();
            clearExptime();
            clearSy();
            clearStart();
            clearEnd();
            clearCsy();
            clearCty();
            clearInterCity();
            clearPn();
            clearRn();
            clearFy();
            clearStartTimes();
            clearIcStart();
            clearDataProvider();
            clearSessionIn();
            clearRtbusUpdateInterval();
            clearCityInfo();
            this.f9883G = -1;
            return this;
        }

        public Option clearCityInfo() {
            this.f9881E = false;
            this.f9882F = null;
            return this;
        }

        public Option clearCsy() {
            this.f9894k = false;
            this.f9895l = 0;
            return this;
        }

        public Option clearCty() {
            this.f9896m = false;
            this.f9897n = 0;
            return this;
        }

        public Option clearDataProvider() {
            this.f9909z = Collections.emptyList();
            return this;
        }

        public Option clearEnd() {
            this.f9892i = false;
            this.f9893j = null;
            return this;
        }

        public Option clearExptime() {
            this.f9886c = false;
            this.f9887d = "";
            return this;
        }

        public Option clearFy() {
            this.f9904u = false;
            this.f9905v = 0;
            return this;
        }

        public Option clearIcStart() {
            this.f9907x = false;
            this.f9908y = "";
            return this;
        }

        public Option clearInterCity() {
            this.f9898o = false;
            this.f9899p = 0;
            return this;
        }

        public Option clearPn() {
            this.f9900q = false;
            this.f9901r = 0;
            return this;
        }

        public Option clearRn() {
            this.f9902s = false;
            this.f9903t = 0;
            return this;
        }

        public Option clearRtbusUpdateInterval() {
            this.f9879C = false;
            this.f9880D = 0;
            return this;
        }

        public Option clearSessionIn() {
            this.f9877A = false;
            this.f9878B = "";
            return this;
        }

        public Option clearStart() {
            this.f9890g = false;
            this.f9891h = null;
            return this;
        }

        public Option clearStartTimes() {
            this.f9906w = Collections.emptyList();
            return this;
        }

        public Option clearSy() {
            this.f9888e = false;
            this.f9889f = 0;
            return this;
        }

        public Option clearTotal() {
            this.f9884a = false;
            this.f9885b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f9883G < 0) {
                getSerializedSize();
            }
            return this.f9883G;
        }

        public CityInfo getCityInfo() {
            return this.f9882F;
        }

        public int getCsy() {
            return this.f9895l;
        }

        public int getCty() {
            return this.f9897n;
        }

        public DataProvider getDataProvider(int i) {
            return (DataProvider) this.f9909z.get(i);
        }

        public int getDataProviderCount() {
            return this.f9909z.size();
        }

        public List<DataProvider> getDataProviderList() {
            return this.f9909z;
        }

        public End getEnd() {
            return this.f9893j;
        }

        public String getExptime() {
            return this.f9887d;
        }

        public int getFy() {
            return this.f9905v;
        }

        public String getIcStart() {
            return this.f9908y;
        }

        public int getInterCity() {
            return this.f9899p;
        }

        public int getPn() {
            return this.f9901r;
        }

        public int getRn() {
            return this.f9903t;
        }

        public int getRtbusUpdateInterval() {
            return this.f9880D;
        }

        public int getSerializedSize() {
            int i = 0;
            int computeInt32Size = hasTotal() ? CodedOutputStreamMicro.computeInt32Size(1, getTotal()) + 0 : 0;
            if (hasExptime()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getExptime());
            }
            if (hasSy()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getSy());
            }
            if (hasStart()) {
                computeInt32Size += CodedOutputStreamMicro.computeMessageSize(4, getStart());
            }
            if (hasEnd()) {
                computeInt32Size += CodedOutputStreamMicro.computeMessageSize(5, getEnd());
            }
            if (hasCsy()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(6, getCsy());
            }
            if (hasCty()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(7, getCty());
            }
            if (hasInterCity()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(8, getInterCity());
            }
            if (hasPn()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(9, getPn());
            }
            if (hasRn()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(10, getRn());
            }
            int computeInt32Size2 = hasFy() ? computeInt32Size + CodedOutputStreamMicro.computeInt32Size(11, getFy()) : computeInt32Size;
            for (String computeStringSizeNoTag : getStartTimesList()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag);
            }
            computeInt32Size = (computeInt32Size2 + i) + (getStartTimesList().size() * 1);
            if (hasIcStart()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(13, getIcStart());
            }
            i = computeInt32Size;
            for (DataProvider computeMessageSize : getDataProviderList()) {
                i = CodedOutputStreamMicro.computeMessageSize(14, computeMessageSize) + i;
            }
            if (hasSessionIn()) {
                i += CodedOutputStreamMicro.computeStringSize(15, getSessionIn());
            }
            if (hasRtbusUpdateInterval()) {
                i += CodedOutputStreamMicro.computeInt32Size(16, getRtbusUpdateInterval());
            }
            if (hasCityInfo()) {
                i += CodedOutputStreamMicro.computeMessageSize(17, getCityInfo());
            }
            this.f9883G = i;
            return i;
        }

        public String getSessionIn() {
            return this.f9878B;
        }

        public Start getStart() {
            return this.f9891h;
        }

        public String getStartTimes(int i) {
            return (String) this.f9906w.get(i);
        }

        public int getStartTimesCount() {
            return this.f9906w.size();
        }

        public List<String> getStartTimesList() {
            return this.f9906w;
        }

        public int getSy() {
            return this.f9889f;
        }

        public int getTotal() {
            return this.f9885b;
        }

        public boolean hasCityInfo() {
            return this.f9881E;
        }

        public boolean hasCsy() {
            return this.f9894k;
        }

        public boolean hasCty() {
            return this.f9896m;
        }

        public boolean hasEnd() {
            return this.f9892i;
        }

        public boolean hasExptime() {
            return this.f9886c;
        }

        public boolean hasFy() {
            return this.f9904u;
        }

        public boolean hasIcStart() {
            return this.f9907x;
        }

        public boolean hasInterCity() {
            return this.f9898o;
        }

        public boolean hasPn() {
            return this.f9900q;
        }

        public boolean hasRn() {
            return this.f9902s;
        }

        public boolean hasRtbusUpdateInterval() {
            return this.f9879C;
        }

        public boolean hasSessionIn() {
            return this.f9877A;
        }

        public boolean hasStart() {
            return this.f9890g;
        }

        public boolean hasSy() {
            return this.f9888e;
        }

        public boolean hasTotal() {
            return this.f9884a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Option mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro start;
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setTotal(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setExptime(codedInputStreamMicro.readString());
                        continue;
                    case 24:
                        setSy(codedInputStreamMicro.readInt32());
                        continue;
                    case 34:
                        start = new Start();
                        codedInputStreamMicro.readMessage(start);
                        setStart(start);
                        continue;
                    case 42:
                        start = new End();
                        codedInputStreamMicro.readMessage(start);
                        setEnd(start);
                        continue;
                    case 48:
                        setCsy(codedInputStreamMicro.readInt32());
                        continue;
                    case 56:
                        setCty(codedInputStreamMicro.readInt32());
                        continue;
                    case 64:
                        setInterCity(codedInputStreamMicro.readInt32());
                        continue;
                    case NavCarInfo.CarType_57L /*72*/:
                        setPn(codedInputStreamMicro.readInt32());
                        continue;
                    case 80:
                        setRn(codedInputStreamMicro.readInt32());
                        continue;
                    case 88:
                        setFy(codedInputStreamMicro.readInt32());
                        continue;
                    case 98:
                        addStartTimes(codedInputStreamMicro.readString());
                        continue;
                    case 106:
                        setIcStart(codedInputStreamMicro.readString());
                        continue;
                    case 114:
                        start = new DataProvider();
                        codedInputStreamMicro.readMessage(start);
                        addDataProvider(start);
                        continue;
                    case C1253f.df /*122*/:
                        setSessionIn(codedInputStreamMicro.readString());
                        continue;
                    case 128:
                        setRtbusUpdateInterval(codedInputStreamMicro.readInt32());
                        continue;
                    case 138:
                        start = new CityInfo();
                        codedInputStreamMicro.readMessage(start);
                        setCityInfo(start);
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

        public Option setCityInfo(CityInfo cityInfo) {
            if (cityInfo == null) {
                return clearCityInfo();
            }
            this.f9881E = true;
            this.f9882F = cityInfo;
            return this;
        }

        public Option setCsy(int i) {
            this.f9894k = true;
            this.f9895l = i;
            return this;
        }

        public Option setCty(int i) {
            this.f9896m = true;
            this.f9897n = i;
            return this;
        }

        public Option setDataProvider(int i, DataProvider dataProvider) {
            if (dataProvider != null) {
                this.f9909z.set(i, dataProvider);
            }
            return this;
        }

        public Option setEnd(End end) {
            if (end == null) {
                return clearEnd();
            }
            this.f9892i = true;
            this.f9893j = end;
            return this;
        }

        public Option setExptime(String str) {
            this.f9886c = true;
            this.f9887d = str;
            return this;
        }

        public Option setFy(int i) {
            this.f9904u = true;
            this.f9905v = i;
            return this;
        }

        public Option setIcStart(String str) {
            this.f9907x = true;
            this.f9908y = str;
            return this;
        }

        public Option setInterCity(int i) {
            this.f9898o = true;
            this.f9899p = i;
            return this;
        }

        public Option setPn(int i) {
            this.f9900q = true;
            this.f9901r = i;
            return this;
        }

        public Option setRn(int i) {
            this.f9902s = true;
            this.f9903t = i;
            return this;
        }

        public Option setRtbusUpdateInterval(int i) {
            this.f9879C = true;
            this.f9880D = i;
            return this;
        }

        public Option setSessionIn(String str) {
            this.f9877A = true;
            this.f9878B = str;
            return this;
        }

        public Option setStart(Start start) {
            if (start == null) {
                return clearStart();
            }
            this.f9890g = true;
            this.f9891h = start;
            return this;
        }

        public Option setStartTimes(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f9906w.set(i, str);
            return this;
        }

        public Option setSy(int i) {
            this.f9888e = true;
            this.f9889f = i;
            return this;
        }

        public Option setTotal(int i) {
            this.f9884a = true;
            this.f9885b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTotal()) {
                codedOutputStreamMicro.writeInt32(1, getTotal());
            }
            if (hasExptime()) {
                codedOutputStreamMicro.writeString(2, getExptime());
            }
            if (hasSy()) {
                codedOutputStreamMicro.writeInt32(3, getSy());
            }
            if (hasStart()) {
                codedOutputStreamMicro.writeMessage(4, getStart());
            }
            if (hasEnd()) {
                codedOutputStreamMicro.writeMessage(5, getEnd());
            }
            if (hasCsy()) {
                codedOutputStreamMicro.writeInt32(6, getCsy());
            }
            if (hasCty()) {
                codedOutputStreamMicro.writeInt32(7, getCty());
            }
            if (hasInterCity()) {
                codedOutputStreamMicro.writeInt32(8, getInterCity());
            }
            if (hasPn()) {
                codedOutputStreamMicro.writeInt32(9, getPn());
            }
            if (hasRn()) {
                codedOutputStreamMicro.writeInt32(10, getRn());
            }
            if (hasFy()) {
                codedOutputStreamMicro.writeInt32(11, getFy());
            }
            for (String writeString : getStartTimesList()) {
                codedOutputStreamMicro.writeString(12, writeString);
            }
            if (hasIcStart()) {
                codedOutputStreamMicro.writeString(13, getIcStart());
            }
            for (DataProvider writeMessage : getDataProviderList()) {
                codedOutputStreamMicro.writeMessage(14, writeMessage);
            }
            if (hasSessionIn()) {
                codedOutputStreamMicro.writeString(15, getSessionIn());
            }
            if (hasRtbusUpdateInterval()) {
                codedOutputStreamMicro.writeInt32(16, getRtbusUpdateInterval());
            }
            if (hasCityInfo()) {
                codedOutputStreamMicro.writeMessage(17, getCityInfo());
            }
        }
    }

    public static final class Routes extends MessageMicro {
        public static final int LEGS_FIELD_NUMBER = 1;
        /* renamed from: a */
        private List<Legs> f10307a = Collections.emptyList();
        /* renamed from: b */
        private int f10308b = -1;

        public static final class Legs extends MessageMicro {
            public static final int ARRIVE_TIME_FIELD_NUMBER = 8;
            public static final int COMFORT_FIELD_NUMBER = 29;
            public static final int DISCOUNT_FIELD_NUMBER = 17;
            public static final int DISTANCE_FIELD_NUMBER = 1;
            public static final int DURATION_FIELD_NUMBER = 2;
            public static final int END_ADDRESS_FIELD_NUMBER = 13;
            public static final int END_LOCATION_FIELD_NUMBER = 3;
            public static final int END_PANO_FIELD_NUMBER = 27;
            public static final int END_TIME_FIELD_NUMBER = 15;
            public static final int INSTRUCTIONS_FIELD_NUMBER = 18;
            public static final int LINE_PRICE_FIELD_NUMBER = 28;
            public static final int PLAN_STATUS_FIELD_NUMBER = 30;
            public static final int PLAN_TYPE_FIELD_NUMBER = 31;
            public static final int PRICE_FIELD_NUMBER = 16;
            public static final int RTBUS_UPDATE_TIME_FIELD_NUMBER = 24;
            public static final int SEND_LOCATION_FIELD_NUMBER = 19;
            public static final int SSTART_LOCATION_FIELD_NUMBER = 20;
            public static final int START_ADDRESS_FIELD_NUMBER = 12;
            public static final int START_LOCATION_FIELD_NUMBER = 4;
            public static final int START_PANO_FIELD_NUMBER = 26;
            public static final int START_TIME_FIELD_NUMBER = 14;
            public static final int STEPS_FIELD_NUMBER = 11;
            public static final int TIP_BACKGROUND_FIELD_NUMBER = 7;
            public static final int TIP_FIELD_NUMBER = 5;
            public static final int TIP_LABEL_BACKGROUND_FIELD_NUMBER = 22;
            public static final int TIP_LABEL_FIELD_NUMBER = 21;
            public static final int TIP_LABEL_TEXT_FIELD_NUMBER = 32;
            public static final int TIP_RTBUS_FIELD_NUMBER = 23;
            public static final int TIP_TEXT_FIELD_NUMBER = 6;
            public static final int TRAFFIC_TYPE_FIELD_NUMBER = 25;
            /* renamed from: A */
            private String f10255A = "";
            /* renamed from: B */
            private boolean f10256B;
            /* renamed from: C */
            private String f10257C = "";
            /* renamed from: D */
            private boolean f10258D;
            /* renamed from: E */
            private String f10259E = "";
            /* renamed from: F */
            private List<Integer> f10260F = Collections.emptyList();
            /* renamed from: G */
            private List<Integer> f10261G = Collections.emptyList();
            /* renamed from: H */
            private boolean f10262H;
            /* renamed from: I */
            private String f10263I = "";
            /* renamed from: J */
            private boolean f10264J;
            /* renamed from: K */
            private String f10265K = "";
            /* renamed from: L */
            private boolean f10266L;
            /* renamed from: M */
            private String f10267M = "";
            /* renamed from: N */
            private boolean f10268N;
            /* renamed from: O */
            private int f10269O = 0;
            /* renamed from: P */
            private boolean f10270P;
            /* renamed from: Q */
            private int f10271Q = 0;
            /* renamed from: R */
            private boolean f10272R;
            /* renamed from: S */
            private StartPano f10273S = null;
            /* renamed from: T */
            private boolean f10274T;
            /* renamed from: U */
            private EndPano f10275U = null;
            /* renamed from: V */
            private List<LinePrice> f10276V = Collections.emptyList();
            /* renamed from: W */
            private boolean f10277W;
            /* renamed from: X */
            private String f10278X = "";
            /* renamed from: Y */
            private boolean f10279Y;
            /* renamed from: Z */
            private int f10280Z = 0;
            /* renamed from: a */
            private List<Steps> f10281a = Collections.emptyList();
            private boolean aa;
            private int ab = 0;
            private boolean ac;
            private String ad = "";
            private int ae = -1;
            /* renamed from: b */
            private boolean f10282b;
            /* renamed from: c */
            private int f10283c = 0;
            /* renamed from: d */
            private boolean f10284d;
            /* renamed from: e */
            private int f10285e = 0;
            /* renamed from: f */
            private boolean f10286f;
            /* renamed from: g */
            private String f10287g = "";
            /* renamed from: h */
            private boolean f10288h;
            /* renamed from: i */
            private String f10289i = "";
            /* renamed from: j */
            private boolean f10290j;
            /* renamed from: k */
            private int f10291k = 0;
            /* renamed from: l */
            private boolean f10292l;
            /* renamed from: m */
            private String f10293m = "";
            /* renamed from: n */
            private boolean f10294n;
            /* renamed from: o */
            private String f10295o = "";
            /* renamed from: p */
            private boolean f10296p;
            /* renamed from: q */
            private String f10297q = "";
            /* renamed from: r */
            private boolean f10298r;
            /* renamed from: s */
            private String f10299s = "";
            /* renamed from: t */
            private boolean f10300t;
            /* renamed from: u */
            private String f10301u = "";
            /* renamed from: v */
            private boolean f10302v;
            /* renamed from: w */
            private String f10303w = "";
            /* renamed from: x */
            private boolean f10304x;
            /* renamed from: y */
            private String f10305y = "";
            /* renamed from: z */
            private boolean f10306z;

            public static final class EndPano extends MessageMicro {
                public static final int PANO_ID_FIELD_NUMBER = 2;
                public static final int PANO_LOCATION_FIELD_NUMBER = 1;
                /* renamed from: a */
                private List<Integer> f9910a = Collections.emptyList();
                /* renamed from: b */
                private boolean f9911b;
                /* renamed from: c */
                private String f9912c = "";
                /* renamed from: d */
                private int f9913d = -1;

                public static EndPano parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new EndPano().mergeFrom(codedInputStreamMicro);
                }

                public static EndPano parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (EndPano) new EndPano().mergeFrom(bArr);
                }

                public EndPano addPanoLocation(int i) {
                    if (this.f9910a.isEmpty()) {
                        this.f9910a = new ArrayList();
                    }
                    this.f9910a.add(Integer.valueOf(i));
                    return this;
                }

                public final EndPano clear() {
                    clearPanoLocation();
                    clearPanoId();
                    this.f9913d = -1;
                    return this;
                }

                public EndPano clearPanoId() {
                    this.f9911b = false;
                    this.f9912c = "";
                    return this;
                }

                public EndPano clearPanoLocation() {
                    this.f9910a = Collections.emptyList();
                    return this;
                }

                public int getCachedSize() {
                    if (this.f9913d < 0) {
                        getSerializedSize();
                    }
                    return this.f9913d;
                }

                public String getPanoId() {
                    return this.f9912c;
                }

                public int getPanoLocation(int i) {
                    return ((Integer) this.f9910a.get(i)).intValue();
                }

                public int getPanoLocationCount() {
                    return this.f9910a.size();
                }

                public List<Integer> getPanoLocationList() {
                    return this.f9910a;
                }

                public int getSerializedSize() {
                    int i = 0;
                    for (Integer intValue : getPanoLocationList()) {
                        i = CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue()) + i;
                    }
                    int size = (0 + i) + (getPanoLocationList().size() * 1);
                    if (hasPanoId()) {
                        size += CodedOutputStreamMicro.computeStringSize(2, getPanoId());
                    }
                    this.f9913d = size;
                    return size;
                }

                public boolean hasPanoId() {
                    return this.f9911b;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public EndPano mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                addPanoLocation(codedInputStreamMicro.readSInt32());
                                continue;
                            case 18:
                                setPanoId(codedInputStreamMicro.readString());
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

                public EndPano setPanoId(String str) {
                    this.f9911b = true;
                    this.f9912c = str;
                    return this;
                }

                public EndPano setPanoLocation(int i, int i2) {
                    this.f9910a.set(i, Integer.valueOf(i2));
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    for (Integer intValue : getPanoLocationList()) {
                        codedOutputStreamMicro.writeSInt32(1, intValue.intValue());
                    }
                    if (hasPanoId()) {
                        codedOutputStreamMicro.writeString(2, getPanoId());
                    }
                }
            }

            public static final class LinePrice extends MessageMicro {
                public static final int LINE_PRICE_FIELD_NUMBER = 2;
                public static final int LINE_TYPE_FIELD_NUMBER = 1;
                /* renamed from: a */
                private boolean f9914a;
                /* renamed from: b */
                private int f9915b = 0;
                /* renamed from: c */
                private boolean f9916c;
                /* renamed from: d */
                private double f9917d = 0.0d;
                /* renamed from: e */
                private int f9918e = -1;

                public static LinePrice parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new LinePrice().mergeFrom(codedInputStreamMicro);
                }

                public static LinePrice parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (LinePrice) new LinePrice().mergeFrom(bArr);
                }

                public final LinePrice clear() {
                    clearLineType();
                    clearLinePrice();
                    this.f9918e = -1;
                    return this;
                }

                public LinePrice clearLinePrice() {
                    this.f9916c = false;
                    this.f9917d = 0.0d;
                    return this;
                }

                public LinePrice clearLineType() {
                    this.f9914a = false;
                    this.f9915b = 0;
                    return this;
                }

                public int getCachedSize() {
                    if (this.f9918e < 0) {
                        getSerializedSize();
                    }
                    return this.f9918e;
                }

                public double getLinePrice() {
                    return this.f9917d;
                }

                public int getLineType() {
                    return this.f9915b;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasLineType()) {
                        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getLineType());
                    }
                    if (hasLinePrice()) {
                        i += CodedOutputStreamMicro.computeDoubleSize(2, getLinePrice());
                    }
                    this.f9918e = i;
                    return i;
                }

                public boolean hasLinePrice() {
                    return this.f9916c;
                }

                public boolean hasLineType() {
                    return this.f9914a;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public LinePrice mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                setLineType(codedInputStreamMicro.readInt32());
                                continue;
                            case 17:
                                setLinePrice(codedInputStreamMicro.readDouble());
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

                public LinePrice setLinePrice(double d) {
                    this.f9916c = true;
                    this.f9917d = d;
                    return this;
                }

                public LinePrice setLineType(int i) {
                    this.f9914a = true;
                    this.f9915b = i;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasLineType()) {
                        codedOutputStreamMicro.writeInt32(1, getLineType());
                    }
                    if (hasLinePrice()) {
                        codedOutputStreamMicro.writeDouble(2, getLinePrice());
                    }
                }
            }

            public static final class StartPano extends MessageMicro {
                public static final int PANO_ID_FIELD_NUMBER = 2;
                public static final int PANO_LOCATION_FIELD_NUMBER = 1;
                /* renamed from: a */
                private List<Integer> f9919a = Collections.emptyList();
                /* renamed from: b */
                private boolean f9920b;
                /* renamed from: c */
                private String f9921c = "";
                /* renamed from: d */
                private int f9922d = -1;

                public static StartPano parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new StartPano().mergeFrom(codedInputStreamMicro);
                }

                public static StartPano parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (StartPano) new StartPano().mergeFrom(bArr);
                }

                public StartPano addPanoLocation(int i) {
                    if (this.f9919a.isEmpty()) {
                        this.f9919a = new ArrayList();
                    }
                    this.f9919a.add(Integer.valueOf(i));
                    return this;
                }

                public final StartPano clear() {
                    clearPanoLocation();
                    clearPanoId();
                    this.f9922d = -1;
                    return this;
                }

                public StartPano clearPanoId() {
                    this.f9920b = false;
                    this.f9921c = "";
                    return this;
                }

                public StartPano clearPanoLocation() {
                    this.f9919a = Collections.emptyList();
                    return this;
                }

                public int getCachedSize() {
                    if (this.f9922d < 0) {
                        getSerializedSize();
                    }
                    return this.f9922d;
                }

                public String getPanoId() {
                    return this.f9921c;
                }

                public int getPanoLocation(int i) {
                    return ((Integer) this.f9919a.get(i)).intValue();
                }

                public int getPanoLocationCount() {
                    return this.f9919a.size();
                }

                public List<Integer> getPanoLocationList() {
                    return this.f9919a;
                }

                public int getSerializedSize() {
                    int i = 0;
                    for (Integer intValue : getPanoLocationList()) {
                        i = CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue()) + i;
                    }
                    int size = (0 + i) + (getPanoLocationList().size() * 1);
                    if (hasPanoId()) {
                        size += CodedOutputStreamMicro.computeStringSize(2, getPanoId());
                    }
                    this.f9922d = size;
                    return size;
                }

                public boolean hasPanoId() {
                    return this.f9920b;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public StartPano mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                addPanoLocation(codedInputStreamMicro.readSInt32());
                                continue;
                            case 18:
                                setPanoId(codedInputStreamMicro.readString());
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

                public StartPano setPanoId(String str) {
                    this.f9920b = true;
                    this.f9921c = str;
                    return this;
                }

                public StartPano setPanoLocation(int i, int i2) {
                    this.f9919a.set(i, Integer.valueOf(i2));
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    for (Integer intValue : getPanoLocationList()) {
                        codedOutputStreamMicro.writeSInt32(1, intValue.intValue());
                    }
                    if (hasPanoId()) {
                        codedOutputStreamMicro.writeString(2, getPanoId());
                    }
                }
            }

            public static final class Steps extends MessageMicro {
                public static final int STEP_FIELD_NUMBER = 1;
                /* renamed from: a */
                private List<Step> f10253a = Collections.emptyList();
                /* renamed from: b */
                private int f10254b = -1;

                public static final class Step extends MessageMicro {
                    public static final int CAN_RIDE_FIELD_NUMBER = 35;
                    public static final int COMFORT_FIELD_NUMBER = 27;
                    public static final int DICT_INSTRUCTION_FIELD_NUMBER = 23;
                    public static final int DISTANCE_FIELD_NUMBER = 1;
                    public static final int DURATION_FIELD_NUMBER = 2;
                    public static final int END_ADDRESS_FIELD_NUMBER = 18;
                    public static final int END_ADDRESS_SHORT_FIELD_NUMBER = 32;
                    public static final int END_INSTRUCTIONS_FIELD_NUMBER = 15;
                    public static final int END_LOCATION_FIELD_NUMBER = 3;
                    public static final int INSTRUCTIONS_FIELD_NUMBER = 5;
                    public static final int IS_DEPOT_FIELD_NUMBER = 33;
                    public static final int LINE_STOPS_FIELD_NUMBER = 22;
                    public static final int LINK_COLOR_FIELD_NUMBER = 24;
                    public static final int LOWER_STEPS_FIELD_NUMBER = 13;
                    public static final int ORDER_URL_FIELD_NUMBER = 11;
                    public static final int PATH_FIELD_NUMBER = 6;
                    public static final int POIS_FIELD_NUMBER = 16;
                    public static final int PRICE_FIELD_NUMBER = 28;
                    public static final int REMAIN_FIELD_NUMBER = 29;
                    public static final int SEND_LOCATION_FIELD_NUMBER = 19;
                    public static final int SPATH_FIELD_NUMBER = 21;
                    public static final int SSTART_LOCATION_FIELD_NUMBER = 20;
                    public static final int START_ADDRESS_FIELD_NUMBER = 17;
                    public static final int START_ADDRESS_SHORT_FIELD_NUMBER = 31;
                    public static final int START_INSTRUCTIONS_FIELD_NUMBER = 14;
                    public static final int START_LOCATION_FIELD_NUMBER = 4;
                    public static final int STEP_PANO_FIELD_NUMBER = 25;
                    public static final int STOPS_POS_FIELD_NUMBER = 26;
                    public static final int TICKET_FIELD_NUMBER = 30;
                    public static final int TIP_BACKGROUND_FIELD_NUMBER = 10;
                    public static final int TIP_FIELD_NUMBER = 8;
                    public static final int TIP_TEXT_FIELD_NUMBER = 9;
                    public static final int TRANSFER_DICT_FIELD_NUMBER = 34;
                    public static final int TYPE_FIELD_NUMBER = 7;
                    public static final int VEHICLE_FIELD_NUMBER = 12;
                    /* renamed from: A */
                    private String f10201A = "";
                    /* renamed from: B */
                    private boolean f10202B;
                    /* renamed from: C */
                    private String f10203C = "";
                    /* renamed from: D */
                    private boolean f10204D;
                    /* renamed from: E */
                    private String f10205E = "";
                    /* renamed from: F */
                    private boolean f10206F;
                    /* renamed from: G */
                    private String f10207G = "";
                    /* renamed from: H */
                    private boolean f10208H;
                    /* renamed from: I */
                    private String f10209I = "";
                    /* renamed from: J */
                    private boolean f10210J;
                    /* renamed from: K */
                    private String f10211K = "";
                    /* renamed from: L */
                    private List<Integer> f10212L = Collections.emptyList();
                    /* renamed from: M */
                    private List<Integer> f10213M = Collections.emptyList();
                    /* renamed from: N */
                    private List<Integer> f10214N = Collections.emptyList();
                    /* renamed from: O */
                    private List<String> f10215O = Collections.emptyList();
                    /* renamed from: P */
                    private boolean f10216P;
                    /* renamed from: Q */
                    private StepPano f10217Q = null;
                    /* renamed from: R */
                    private List<StopsPos> f10218R = Collections.emptyList();
                    /* renamed from: S */
                    private boolean f10219S;
                    /* renamed from: T */
                    private String f10220T = "";
                    /* renamed from: U */
                    private boolean f10221U;
                    /* renamed from: V */
                    private double f10222V = 0.0d;
                    /* renamed from: W */
                    private boolean f10223W;
                    /* renamed from: X */
                    private int f10224X = 0;
                    /* renamed from: Y */
                    private boolean f10225Y;
                    /* renamed from: Z */
                    private Ticket f10226Z = null;
                    /* renamed from: a */
                    private boolean f10227a;
                    private boolean aa;
                    private String ab = "";
                    private boolean ac;
                    private String ad = "";
                    private boolean ae;
                    private int af = 0;
                    private boolean ag;
                    private TransferDict ah = null;
                    private boolean ai;
                    private int aj = 0;
                    private int ak = -1;
                    /* renamed from: b */
                    private DictInstruction f10228b = null;
                    /* renamed from: c */
                    private boolean f10229c;
                    /* renamed from: d */
                    private Vehicle f10230d = null;
                    /* renamed from: e */
                    private List<LowerSteps> f10231e = Collections.emptyList();
                    /* renamed from: f */
                    private List<Pois> f10232f = Collections.emptyList();
                    /* renamed from: g */
                    private List<LinkColor> f10233g = Collections.emptyList();
                    /* renamed from: h */
                    private boolean f10234h;
                    /* renamed from: i */
                    private int f10235i = 0;
                    /* renamed from: j */
                    private boolean f10236j;
                    /* renamed from: k */
                    private int f10237k = 0;
                    /* renamed from: l */
                    private boolean f10238l;
                    /* renamed from: m */
                    private String f10239m = "";
                    /* renamed from: n */
                    private boolean f10240n;
                    /* renamed from: o */
                    private String f10241o = "";
                    /* renamed from: p */
                    private boolean f10242p;
                    /* renamed from: q */
                    private String f10243q = "";
                    /* renamed from: r */
                    private boolean f10244r;
                    /* renamed from: s */
                    private String f10245s = "";
                    /* renamed from: t */
                    private boolean f10246t;
                    /* renamed from: u */
                    private int f10247u = 0;
                    /* renamed from: v */
                    private boolean f10248v;
                    /* renamed from: w */
                    private int f10249w = 0;
                    /* renamed from: x */
                    private boolean f10250x;
                    /* renamed from: y */
                    private String f10251y = "";
                    /* renamed from: z */
                    private boolean f10252z;

                    public static final class DictInstruction extends MessageMicro {
                        public static final int CYCLE_TEXT_FIELD_NUMBER = 8;
                        public static final int DIRECT_TEXT_FIELD_NUMBER = 4;
                        public static final int END_TEXT_FIELD_NUMBER = 2;
                        public static final int OTHER_LINES_FIELD_NUMBER = 6;
                        public static final int RTBUS_TEXT_FIELD_NUMBER = 3;
                        public static final int RTBUS_TEXT_IMAGE_FIELD_NUMBER = 7;
                        public static final int START_TEXT_FIELD_NUMBER = 1;
                        public static final int WALK_TEXT_FIELD_NUMBER = 5;
                        /* renamed from: a */
                        private boolean f9923a;
                        /* renamed from: b */
                        private String f9924b = "";
                        /* renamed from: c */
                        private boolean f9925c;
                        /* renamed from: d */
                        private String f9926d = "";
                        /* renamed from: e */
                        private boolean f9927e;
                        /* renamed from: f */
                        private String f9928f = "";
                        /* renamed from: g */
                        private boolean f9929g;
                        /* renamed from: h */
                        private String f9930h = "";
                        /* renamed from: i */
                        private boolean f9931i;
                        /* renamed from: j */
                        private String f9932j = "";
                        /* renamed from: k */
                        private boolean f9933k;
                        /* renamed from: l */
                        private String f9934l = "";
                        /* renamed from: m */
                        private boolean f9935m;
                        /* renamed from: n */
                        private String f9936n = "";
                        /* renamed from: o */
                        private boolean f9937o;
                        /* renamed from: p */
                        private String f9938p = "";
                        /* renamed from: q */
                        private int f9939q = -1;

                        public static DictInstruction parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new DictInstruction().mergeFrom(codedInputStreamMicro);
                        }

                        public static DictInstruction parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (DictInstruction) new DictInstruction().mergeFrom(bArr);
                        }

                        public final DictInstruction clear() {
                            clearStartText();
                            clearEndText();
                            clearRtbusText();
                            clearDirectText();
                            clearWalkText();
                            clearOtherLines();
                            clearRtbusTextImage();
                            clearCycleText();
                            this.f9939q = -1;
                            return this;
                        }

                        public DictInstruction clearCycleText() {
                            this.f9937o = false;
                            this.f9938p = "";
                            return this;
                        }

                        public DictInstruction clearDirectText() {
                            this.f9929g = false;
                            this.f9930h = "";
                            return this;
                        }

                        public DictInstruction clearEndText() {
                            this.f9925c = false;
                            this.f9926d = "";
                            return this;
                        }

                        public DictInstruction clearOtherLines() {
                            this.f9933k = false;
                            this.f9934l = "";
                            return this;
                        }

                        public DictInstruction clearRtbusText() {
                            this.f9927e = false;
                            this.f9928f = "";
                            return this;
                        }

                        public DictInstruction clearRtbusTextImage() {
                            this.f9935m = false;
                            this.f9936n = "";
                            return this;
                        }

                        public DictInstruction clearStartText() {
                            this.f9923a = false;
                            this.f9924b = "";
                            return this;
                        }

                        public DictInstruction clearWalkText() {
                            this.f9931i = false;
                            this.f9932j = "";
                            return this;
                        }

                        public int getCachedSize() {
                            if (this.f9939q < 0) {
                                getSerializedSize();
                            }
                            return this.f9939q;
                        }

                        public String getCycleText() {
                            return this.f9938p;
                        }

                        public String getDirectText() {
                            return this.f9930h;
                        }

                        public String getEndText() {
                            return this.f9926d;
                        }

                        public String getOtherLines() {
                            return this.f9934l;
                        }

                        public String getRtbusText() {
                            return this.f9928f;
                        }

                        public String getRtbusTextImage() {
                            return this.f9936n;
                        }

                        public int getSerializedSize() {
                            int i = 0;
                            if (hasStartText()) {
                                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getStartText());
                            }
                            if (hasEndText()) {
                                i += CodedOutputStreamMicro.computeStringSize(2, getEndText());
                            }
                            if (hasRtbusText()) {
                                i += CodedOutputStreamMicro.computeStringSize(3, getRtbusText());
                            }
                            if (hasDirectText()) {
                                i += CodedOutputStreamMicro.computeStringSize(4, getDirectText());
                            }
                            if (hasWalkText()) {
                                i += CodedOutputStreamMicro.computeStringSize(5, getWalkText());
                            }
                            if (hasOtherLines()) {
                                i += CodedOutputStreamMicro.computeStringSize(6, getOtherLines());
                            }
                            if (hasRtbusTextImage()) {
                                i += CodedOutputStreamMicro.computeStringSize(7, getRtbusTextImage());
                            }
                            if (hasCycleText()) {
                                i += CodedOutputStreamMicro.computeStringSize(8, getCycleText());
                            }
                            this.f9939q = i;
                            return i;
                        }

                        public String getStartText() {
                            return this.f9924b;
                        }

                        public String getWalkText() {
                            return this.f9932j;
                        }

                        public boolean hasCycleText() {
                            return this.f9937o;
                        }

                        public boolean hasDirectText() {
                            return this.f9929g;
                        }

                        public boolean hasEndText() {
                            return this.f9925c;
                        }

                        public boolean hasOtherLines() {
                            return this.f9933k;
                        }

                        public boolean hasRtbusText() {
                            return this.f9927e;
                        }

                        public boolean hasRtbusTextImage() {
                            return this.f9935m;
                        }

                        public boolean hasStartText() {
                            return this.f9923a;
                        }

                        public boolean hasWalkText() {
                            return this.f9931i;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public DictInstruction mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                switch (readTag) {
                                    case 0:
                                        break;
                                    case 10:
                                        setStartText(codedInputStreamMicro.readString());
                                        continue;
                                    case 18:
                                        setEndText(codedInputStreamMicro.readString());
                                        continue;
                                    case 26:
                                        setRtbusText(codedInputStreamMicro.readString());
                                        continue;
                                    case 34:
                                        setDirectText(codedInputStreamMicro.readString());
                                        continue;
                                    case 42:
                                        setWalkText(codedInputStreamMicro.readString());
                                        continue;
                                    case 50:
                                        setOtherLines(codedInputStreamMicro.readString());
                                        continue;
                                    case 58:
                                        setRtbusTextImage(codedInputStreamMicro.readString());
                                        continue;
                                    case 66:
                                        setCycleText(codedInputStreamMicro.readString());
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

                        public DictInstruction setCycleText(String str) {
                            this.f9937o = true;
                            this.f9938p = str;
                            return this;
                        }

                        public DictInstruction setDirectText(String str) {
                            this.f9929g = true;
                            this.f9930h = str;
                            return this;
                        }

                        public DictInstruction setEndText(String str) {
                            this.f9925c = true;
                            this.f9926d = str;
                            return this;
                        }

                        public DictInstruction setOtherLines(String str) {
                            this.f9933k = true;
                            this.f9934l = str;
                            return this;
                        }

                        public DictInstruction setRtbusText(String str) {
                            this.f9927e = true;
                            this.f9928f = str;
                            return this;
                        }

                        public DictInstruction setRtbusTextImage(String str) {
                            this.f9935m = true;
                            this.f9936n = str;
                            return this;
                        }

                        public DictInstruction setStartText(String str) {
                            this.f9923a = true;
                            this.f9924b = str;
                            return this;
                        }

                        public DictInstruction setWalkText(String str) {
                            this.f9931i = true;
                            this.f9932j = str;
                            return this;
                        }

                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasStartText()) {
                                codedOutputStreamMicro.writeString(1, getStartText());
                            }
                            if (hasEndText()) {
                                codedOutputStreamMicro.writeString(2, getEndText());
                            }
                            if (hasRtbusText()) {
                                codedOutputStreamMicro.writeString(3, getRtbusText());
                            }
                            if (hasDirectText()) {
                                codedOutputStreamMicro.writeString(4, getDirectText());
                            }
                            if (hasWalkText()) {
                                codedOutputStreamMicro.writeString(5, getWalkText());
                            }
                            if (hasOtherLines()) {
                                codedOutputStreamMicro.writeString(6, getOtherLines());
                            }
                            if (hasRtbusTextImage()) {
                                codedOutputStreamMicro.writeString(7, getRtbusTextImage());
                            }
                            if (hasCycleText()) {
                                codedOutputStreamMicro.writeString(8, getCycleText());
                            }
                        }
                    }

                    public static final class LinkColor extends MessageMicro {
                        public static final int GEO_CNT_FIELD_NUMBER = 2;
                        public static final int STATUS_FIELD_NUMBER = 1;
                        /* renamed from: a */
                        private boolean f9940a;
                        /* renamed from: b */
                        private int f9941b = 0;
                        /* renamed from: c */
                        private boolean f9942c;
                        /* renamed from: d */
                        private int f9943d = 0;
                        /* renamed from: e */
                        private int f9944e = -1;

                        public static LinkColor parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new LinkColor().mergeFrom(codedInputStreamMicro);
                        }

                        public static LinkColor parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (LinkColor) new LinkColor().mergeFrom(bArr);
                        }

                        public final LinkColor clear() {
                            clearStatus();
                            clearGeoCnt();
                            this.f9944e = -1;
                            return this;
                        }

                        public LinkColor clearGeoCnt() {
                            this.f9942c = false;
                            this.f9943d = 0;
                            return this;
                        }

                        public LinkColor clearStatus() {
                            this.f9940a = false;
                            this.f9941b = 0;
                            return this;
                        }

                        public int getCachedSize() {
                            if (this.f9944e < 0) {
                                getSerializedSize();
                            }
                            return this.f9944e;
                        }

                        public int getGeoCnt() {
                            return this.f9943d;
                        }

                        public int getSerializedSize() {
                            int i = 0;
                            if (hasStatus()) {
                                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getStatus());
                            }
                            if (hasGeoCnt()) {
                                i += CodedOutputStreamMicro.computeInt32Size(2, getGeoCnt());
                            }
                            this.f9944e = i;
                            return i;
                        }

                        public int getStatus() {
                            return this.f9941b;
                        }

                        public boolean hasGeoCnt() {
                            return this.f9942c;
                        }

                        public boolean hasStatus() {
                            return this.f9940a;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public LinkColor mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                switch (readTag) {
                                    case 0:
                                        break;
                                    case 8:
                                        setStatus(codedInputStreamMicro.readInt32());
                                        continue;
                                    case 16:
                                        setGeoCnt(codedInputStreamMicro.readInt32());
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

                        public LinkColor setGeoCnt(int i) {
                            this.f9942c = true;
                            this.f9943d = i;
                            return this;
                        }

                        public LinkColor setStatus(int i) {
                            this.f9940a = true;
                            this.f9941b = i;
                            return this;
                        }

                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasStatus()) {
                                codedOutputStreamMicro.writeInt32(1, getStatus());
                            }
                            if (hasGeoCnt()) {
                                codedOutputStreamMicro.writeInt32(2, getGeoCnt());
                            }
                        }
                    }

                    public static final class LowerSteps extends MessageMicro {
                        public static final int LOWER_STEP_FIELD_NUMBER = 1;
                        /* renamed from: a */
                        private List<LowerStep> f10082a = Collections.emptyList();
                        /* renamed from: b */
                        private int f10083b = -1;

                        public static final class LowerStep extends MessageMicro {
                            public static final int ARRIVE_TIME_FIELD_NUMBER = 14;
                            public static final int DICT_INSTRUCTION_FIELD_NUMBER = 21;
                            public static final int DIRECTION_FIELD_NUMBER = 15;
                            public static final int DISTANCE_FIELD_NUMBER = 8;
                            public static final int DURATION_FIELD_NUMBER = 9;
                            public static final int END_INSTRUCTIONS_FIELD_NUMBER = 5;
                            public static final int END_LOCATION_FIELD_NUMBER = 7;
                            public static final int INSTRUCTIONS_FIELD_NUMBER = 3;
                            public static final int LINE_STOPS_FIELD_NUMBER = 20;
                            public static final int PATH_FIELD_NUMBER = 1;
                            public static final int POIS_FIELD_NUMBER = 16;
                            public static final int SEND_LOCATION_FIELD_NUMBER = 18;
                            public static final int SPATH_FIELD_NUMBER = 19;
                            public static final int SSTART_LOCATION_FIELD_NUMBER = 17;
                            public static final int START_INSTRUCTIONS_FIELD_NUMBER = 4;
                            public static final int START_LOCATION_FIELD_NUMBER = 6;
                            public static final int STEP_PANO_FIELD_NUMBER = 22;
                            public static final int TIP_BACKGROUND_FIELD_NUMBER = 13;
                            public static final int TIP_FIELD_NUMBER = 11;
                            public static final int TIP_TEXT_FIELD_NUMBER = 12;
                            public static final int TYPE_FIELD_NUMBER = 2;
                            public static final int VEHICLE_FIELD_NUMBER = 10;
                            /* renamed from: A */
                            private String f10042A = "";
                            /* renamed from: B */
                            private boolean f10043B;
                            /* renamed from: C */
                            private String f10044C = "";
                            /* renamed from: D */
                            private boolean f10045D;
                            /* renamed from: E */
                            private String f10046E = "";
                            /* renamed from: F */
                            private boolean f10047F;
                            /* renamed from: G */
                            private int f10048G = 0;
                            /* renamed from: H */
                            private List<Integer> f10049H = Collections.emptyList();
                            /* renamed from: I */
                            private List<Integer> f10050I = Collections.emptyList();
                            /* renamed from: J */
                            private List<Integer> f10051J = Collections.emptyList();
                            /* renamed from: K */
                            private List<String> f10052K = Collections.emptyList();
                            /* renamed from: L */
                            private boolean f10053L;
                            /* renamed from: M */
                            private StepPano f10054M = null;
                            /* renamed from: N */
                            private int f10055N = -1;
                            /* renamed from: a */
                            private boolean f10056a;
                            /* renamed from: b */
                            private DictInstruction f10057b = null;
                            /* renamed from: c */
                            private boolean f10058c;
                            /* renamed from: d */
                            private Vehicle f10059d = null;
                            /* renamed from: e */
                            private List<Pois> f10060e = Collections.emptyList();
                            /* renamed from: f */
                            private boolean f10061f;
                            /* renamed from: g */
                            private String f10062g = "";
                            /* renamed from: h */
                            private boolean f10063h;
                            /* renamed from: i */
                            private int f10064i = 0;
                            /* renamed from: j */
                            private boolean f10065j;
                            /* renamed from: k */
                            private String f10066k = "";
                            /* renamed from: l */
                            private boolean f10067l;
                            /* renamed from: m */
                            private String f10068m = "";
                            /* renamed from: n */
                            private boolean f10069n;
                            /* renamed from: o */
                            private String f10070o = "";
                            /* renamed from: p */
                            private boolean f10071p;
                            /* renamed from: q */
                            private String f10072q = "";
                            /* renamed from: r */
                            private boolean f10073r;
                            /* renamed from: s */
                            private String f10074s = "";
                            /* renamed from: t */
                            private boolean f10075t;
                            /* renamed from: u */
                            private int f10076u = 0;
                            /* renamed from: v */
                            private boolean f10077v;
                            /* renamed from: w */
                            private int f10078w = 0;
                            /* renamed from: x */
                            private boolean f10079x;
                            /* renamed from: y */
                            private int f10080y = 0;
                            /* renamed from: z */
                            private boolean f10081z;

                            public static final class DictInstruction extends MessageMicro {
                                public static final int CYCLE_TEXT_FIELD_NUMBER = 8;
                                public static final int DIRECT_TEXT_FIELD_NUMBER = 4;
                                public static final int END_TEXT_FIELD_NUMBER = 2;
                                public static final int OTHER_LINES_FIELD_NUMBER = 6;
                                public static final int RTBUS_TEXT_FIELD_NUMBER = 3;
                                public static final int RTBUS_TEXT_IMAGE_FIELD_NUMBER = 7;
                                public static final int START_TEXT_FIELD_NUMBER = 1;
                                public static final int WALK_TEXT_FIELD_NUMBER = 5;
                                /* renamed from: a */
                                private boolean f9945a;
                                /* renamed from: b */
                                private String f9946b = "";
                                /* renamed from: c */
                                private boolean f9947c;
                                /* renamed from: d */
                                private String f9948d = "";
                                /* renamed from: e */
                                private boolean f9949e;
                                /* renamed from: f */
                                private String f9950f = "";
                                /* renamed from: g */
                                private boolean f9951g;
                                /* renamed from: h */
                                private String f9952h = "";
                                /* renamed from: i */
                                private boolean f9953i;
                                /* renamed from: j */
                                private String f9954j = "";
                                /* renamed from: k */
                                private boolean f9955k;
                                /* renamed from: l */
                                private String f9956l = "";
                                /* renamed from: m */
                                private boolean f9957m;
                                /* renamed from: n */
                                private String f9958n = "";
                                /* renamed from: o */
                                private boolean f9959o;
                                /* renamed from: p */
                                private String f9960p = "";
                                /* renamed from: q */
                                private int f9961q = -1;

                                public static DictInstruction parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                                    return new DictInstruction().mergeFrom(codedInputStreamMicro);
                                }

                                public static DictInstruction parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                                    return (DictInstruction) new DictInstruction().mergeFrom(bArr);
                                }

                                public final DictInstruction clear() {
                                    clearStartText();
                                    clearEndText();
                                    clearRtbusText();
                                    clearDirectText();
                                    clearWalkText();
                                    clearOtherLines();
                                    clearRtbusTextImage();
                                    clearCycleText();
                                    this.f9961q = -1;
                                    return this;
                                }

                                public DictInstruction clearCycleText() {
                                    this.f9959o = false;
                                    this.f9960p = "";
                                    return this;
                                }

                                public DictInstruction clearDirectText() {
                                    this.f9951g = false;
                                    this.f9952h = "";
                                    return this;
                                }

                                public DictInstruction clearEndText() {
                                    this.f9947c = false;
                                    this.f9948d = "";
                                    return this;
                                }

                                public DictInstruction clearOtherLines() {
                                    this.f9955k = false;
                                    this.f9956l = "";
                                    return this;
                                }

                                public DictInstruction clearRtbusText() {
                                    this.f9949e = false;
                                    this.f9950f = "";
                                    return this;
                                }

                                public DictInstruction clearRtbusTextImage() {
                                    this.f9957m = false;
                                    this.f9958n = "";
                                    return this;
                                }

                                public DictInstruction clearStartText() {
                                    this.f9945a = false;
                                    this.f9946b = "";
                                    return this;
                                }

                                public DictInstruction clearWalkText() {
                                    this.f9953i = false;
                                    this.f9954j = "";
                                    return this;
                                }

                                public int getCachedSize() {
                                    if (this.f9961q < 0) {
                                        getSerializedSize();
                                    }
                                    return this.f9961q;
                                }

                                public String getCycleText() {
                                    return this.f9960p;
                                }

                                public String getDirectText() {
                                    return this.f9952h;
                                }

                                public String getEndText() {
                                    return this.f9948d;
                                }

                                public String getOtherLines() {
                                    return this.f9956l;
                                }

                                public String getRtbusText() {
                                    return this.f9950f;
                                }

                                public String getRtbusTextImage() {
                                    return this.f9958n;
                                }

                                public int getSerializedSize() {
                                    int i = 0;
                                    if (hasStartText()) {
                                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getStartText());
                                    }
                                    if (hasEndText()) {
                                        i += CodedOutputStreamMicro.computeStringSize(2, getEndText());
                                    }
                                    if (hasRtbusText()) {
                                        i += CodedOutputStreamMicro.computeStringSize(3, getRtbusText());
                                    }
                                    if (hasDirectText()) {
                                        i += CodedOutputStreamMicro.computeStringSize(4, getDirectText());
                                    }
                                    if (hasWalkText()) {
                                        i += CodedOutputStreamMicro.computeStringSize(5, getWalkText());
                                    }
                                    if (hasOtherLines()) {
                                        i += CodedOutputStreamMicro.computeStringSize(6, getOtherLines());
                                    }
                                    if (hasRtbusTextImage()) {
                                        i += CodedOutputStreamMicro.computeStringSize(7, getRtbusTextImage());
                                    }
                                    if (hasCycleText()) {
                                        i += CodedOutputStreamMicro.computeStringSize(8, getCycleText());
                                    }
                                    this.f9961q = i;
                                    return i;
                                }

                                public String getStartText() {
                                    return this.f9946b;
                                }

                                public String getWalkText() {
                                    return this.f9954j;
                                }

                                public boolean hasCycleText() {
                                    return this.f9959o;
                                }

                                public boolean hasDirectText() {
                                    return this.f9951g;
                                }

                                public boolean hasEndText() {
                                    return this.f9947c;
                                }

                                public boolean hasOtherLines() {
                                    return this.f9955k;
                                }

                                public boolean hasRtbusText() {
                                    return this.f9949e;
                                }

                                public boolean hasRtbusTextImage() {
                                    return this.f9957m;
                                }

                                public boolean hasStartText() {
                                    return this.f9945a;
                                }

                                public boolean hasWalkText() {
                                    return this.f9953i;
                                }

                                public final boolean isInitialized() {
                                    return true;
                                }

                                public DictInstruction mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                                    while (true) {
                                        int readTag = codedInputStreamMicro.readTag();
                                        switch (readTag) {
                                            case 0:
                                                break;
                                            case 10:
                                                setStartText(codedInputStreamMicro.readString());
                                                continue;
                                            case 18:
                                                setEndText(codedInputStreamMicro.readString());
                                                continue;
                                            case 26:
                                                setRtbusText(codedInputStreamMicro.readString());
                                                continue;
                                            case 34:
                                                setDirectText(codedInputStreamMicro.readString());
                                                continue;
                                            case 42:
                                                setWalkText(codedInputStreamMicro.readString());
                                                continue;
                                            case 50:
                                                setOtherLines(codedInputStreamMicro.readString());
                                                continue;
                                            case 58:
                                                setRtbusTextImage(codedInputStreamMicro.readString());
                                                continue;
                                            case 66:
                                                setCycleText(codedInputStreamMicro.readString());
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

                                public DictInstruction setCycleText(String str) {
                                    this.f9959o = true;
                                    this.f9960p = str;
                                    return this;
                                }

                                public DictInstruction setDirectText(String str) {
                                    this.f9951g = true;
                                    this.f9952h = str;
                                    return this;
                                }

                                public DictInstruction setEndText(String str) {
                                    this.f9947c = true;
                                    this.f9948d = str;
                                    return this;
                                }

                                public DictInstruction setOtherLines(String str) {
                                    this.f9955k = true;
                                    this.f9956l = str;
                                    return this;
                                }

                                public DictInstruction setRtbusText(String str) {
                                    this.f9949e = true;
                                    this.f9950f = str;
                                    return this;
                                }

                                public DictInstruction setRtbusTextImage(String str) {
                                    this.f9957m = true;
                                    this.f9958n = str;
                                    return this;
                                }

                                public DictInstruction setStartText(String str) {
                                    this.f9945a = true;
                                    this.f9946b = str;
                                    return this;
                                }

                                public DictInstruction setWalkText(String str) {
                                    this.f9953i = true;
                                    this.f9954j = str;
                                    return this;
                                }

                                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                                    if (hasStartText()) {
                                        codedOutputStreamMicro.writeString(1, getStartText());
                                    }
                                    if (hasEndText()) {
                                        codedOutputStreamMicro.writeString(2, getEndText());
                                    }
                                    if (hasRtbusText()) {
                                        codedOutputStreamMicro.writeString(3, getRtbusText());
                                    }
                                    if (hasDirectText()) {
                                        codedOutputStreamMicro.writeString(4, getDirectText());
                                    }
                                    if (hasWalkText()) {
                                        codedOutputStreamMicro.writeString(5, getWalkText());
                                    }
                                    if (hasOtherLines()) {
                                        codedOutputStreamMicro.writeString(6, getOtherLines());
                                    }
                                    if (hasRtbusTextImage()) {
                                        codedOutputStreamMicro.writeString(7, getRtbusTextImage());
                                    }
                                    if (hasCycleText()) {
                                        codedOutputStreamMicro.writeString(8, getCycleText());
                                    }
                                }
                            }

                            public static final class Pois extends MessageMicro {
                                public static final int DETAIL_FIELD_NUMBER = 4;
                                public static final int LOCATION_FIELD_NUMBER = 2;
                                public static final int NAME_FIELD_NUMBER = 1;
                                public static final int SLOCATION_FIELD_NUMBER = 5;
                                public static final int TYPE_FIELD_NUMBER = 3;
                                /* renamed from: a */
                                private boolean f9962a;
                                /* renamed from: b */
                                private String f9963b = "";
                                /* renamed from: c */
                                private boolean f9964c;
                                /* renamed from: d */
                                private String f9965d = "";
                                /* renamed from: e */
                                private boolean f9966e;
                                /* renamed from: f */
                                private int f9967f = 0;
                                /* renamed from: g */
                                private boolean f9968g;
                                /* renamed from: h */
                                private String f9969h = "";
                                /* renamed from: i */
                                private List<Integer> f9970i = Collections.emptyList();
                                /* renamed from: j */
                                private int f9971j = -1;

                                public static Pois parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                                    return new Pois().mergeFrom(codedInputStreamMicro);
                                }

                                public static Pois parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                                    return (Pois) new Pois().mergeFrom(bArr);
                                }

                                public Pois addSlocation(int i) {
                                    if (this.f9970i.isEmpty()) {
                                        this.f9970i = new ArrayList();
                                    }
                                    this.f9970i.add(Integer.valueOf(i));
                                    return this;
                                }

                                public final Pois clear() {
                                    clearName();
                                    clearLocation();
                                    clearType();
                                    clearDetail();
                                    clearSlocation();
                                    this.f9971j = -1;
                                    return this;
                                }

                                public Pois clearDetail() {
                                    this.f9968g = false;
                                    this.f9969h = "";
                                    return this;
                                }

                                public Pois clearLocation() {
                                    this.f9964c = false;
                                    this.f9965d = "";
                                    return this;
                                }

                                public Pois clearName() {
                                    this.f9962a = false;
                                    this.f9963b = "";
                                    return this;
                                }

                                public Pois clearSlocation() {
                                    this.f9970i = Collections.emptyList();
                                    return this;
                                }

                                public Pois clearType() {
                                    this.f9966e = false;
                                    this.f9967f = 0;
                                    return this;
                                }

                                public int getCachedSize() {
                                    if (this.f9971j < 0) {
                                        getSerializedSize();
                                    }
                                    return this.f9971j;
                                }

                                public String getDetail() {
                                    return this.f9969h;
                                }

                                public String getLocation() {
                                    return this.f9965d;
                                }

                                public String getName() {
                                    return this.f9963b;
                                }

                                public int getSerializedSize() {
                                    int i = 0;
                                    int computeStringSize = hasName() ? CodedOutputStreamMicro.computeStringSize(1, getName()) + 0 : 0;
                                    if (hasLocation()) {
                                        computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getLocation());
                                    }
                                    if (hasType()) {
                                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(3, getType());
                                    }
                                    int computeStringSize2 = hasDetail() ? computeStringSize + CodedOutputStreamMicro.computeStringSize(4, getDetail()) : computeStringSize;
                                    for (Integer intValue : getSlocationList()) {
                                        i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue());
                                    }
                                    computeStringSize = (computeStringSize2 + i) + (getSlocationList().size() * 1);
                                    this.f9971j = computeStringSize;
                                    return computeStringSize;
                                }

                                public int getSlocation(int i) {
                                    return ((Integer) this.f9970i.get(i)).intValue();
                                }

                                public int getSlocationCount() {
                                    return this.f9970i.size();
                                }

                                public List<Integer> getSlocationList() {
                                    return this.f9970i;
                                }

                                public int getType() {
                                    return this.f9967f;
                                }

                                public boolean hasDetail() {
                                    return this.f9968g;
                                }

                                public boolean hasLocation() {
                                    return this.f9964c;
                                }

                                public boolean hasName() {
                                    return this.f9962a;
                                }

                                public boolean hasType() {
                                    return this.f9966e;
                                }

                                public final boolean isInitialized() {
                                    return true;
                                }

                                public Pois mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                                    while (true) {
                                        int readTag = codedInputStreamMicro.readTag();
                                        switch (readTag) {
                                            case 0:
                                                break;
                                            case 10:
                                                setName(codedInputStreamMicro.readString());
                                                continue;
                                            case 18:
                                                setLocation(codedInputStreamMicro.readString());
                                                continue;
                                            case 24:
                                                setType(codedInputStreamMicro.readInt32());
                                                continue;
                                            case 34:
                                                setDetail(codedInputStreamMicro.readString());
                                                continue;
                                            case 40:
                                                addSlocation(codedInputStreamMicro.readSInt32());
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

                                public Pois setDetail(String str) {
                                    this.f9968g = true;
                                    this.f9969h = str;
                                    return this;
                                }

                                public Pois setLocation(String str) {
                                    this.f9964c = true;
                                    this.f9965d = str;
                                    return this;
                                }

                                public Pois setName(String str) {
                                    this.f9962a = true;
                                    this.f9963b = str;
                                    return this;
                                }

                                public Pois setSlocation(int i, int i2) {
                                    this.f9970i.set(i, Integer.valueOf(i2));
                                    return this;
                                }

                                public Pois setType(int i) {
                                    this.f9966e = true;
                                    this.f9967f = i;
                                    return this;
                                }

                                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                                    if (hasName()) {
                                        codedOutputStreamMicro.writeString(1, getName());
                                    }
                                    if (hasLocation()) {
                                        codedOutputStreamMicro.writeString(2, getLocation());
                                    }
                                    if (hasType()) {
                                        codedOutputStreamMicro.writeInt32(3, getType());
                                    }
                                    if (hasDetail()) {
                                        codedOutputStreamMicro.writeString(4, getDetail());
                                    }
                                    for (Integer intValue : getSlocationList()) {
                                        codedOutputStreamMicro.writeSInt32(5, intValue.intValue());
                                    }
                                }
                            }

                            public static final class StepPano extends MessageMicro {
                                public static final int PANO_ID_FIELD_NUMBER = 2;
                                public static final int PANO_LOCATION_FIELD_NUMBER = 1;
                                /* renamed from: a */
                                private List<Integer> f9972a = Collections.emptyList();
                                /* renamed from: b */
                                private boolean f9973b;
                                /* renamed from: c */
                                private String f9974c = "";
                                /* renamed from: d */
                                private int f9975d = -1;

                                public static StepPano parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                                    return new StepPano().mergeFrom(codedInputStreamMicro);
                                }

                                public static StepPano parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                                    return (StepPano) new StepPano().mergeFrom(bArr);
                                }

                                public StepPano addPanoLocation(int i) {
                                    if (this.f9972a.isEmpty()) {
                                        this.f9972a = new ArrayList();
                                    }
                                    this.f9972a.add(Integer.valueOf(i));
                                    return this;
                                }

                                public final StepPano clear() {
                                    clearPanoLocation();
                                    clearPanoId();
                                    this.f9975d = -1;
                                    return this;
                                }

                                public StepPano clearPanoId() {
                                    this.f9973b = false;
                                    this.f9974c = "";
                                    return this;
                                }

                                public StepPano clearPanoLocation() {
                                    this.f9972a = Collections.emptyList();
                                    return this;
                                }

                                public int getCachedSize() {
                                    if (this.f9975d < 0) {
                                        getSerializedSize();
                                    }
                                    return this.f9975d;
                                }

                                public String getPanoId() {
                                    return this.f9974c;
                                }

                                public int getPanoLocation(int i) {
                                    return ((Integer) this.f9972a.get(i)).intValue();
                                }

                                public int getPanoLocationCount() {
                                    return this.f9972a.size();
                                }

                                public List<Integer> getPanoLocationList() {
                                    return this.f9972a;
                                }

                                public int getSerializedSize() {
                                    int i = 0;
                                    for (Integer intValue : getPanoLocationList()) {
                                        i = CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue()) + i;
                                    }
                                    int size = (0 + i) + (getPanoLocationList().size() * 1);
                                    if (hasPanoId()) {
                                        size += CodedOutputStreamMicro.computeStringSize(2, getPanoId());
                                    }
                                    this.f9975d = size;
                                    return size;
                                }

                                public boolean hasPanoId() {
                                    return this.f9973b;
                                }

                                public final boolean isInitialized() {
                                    return true;
                                }

                                public StepPano mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                                    while (true) {
                                        int readTag = codedInputStreamMicro.readTag();
                                        switch (readTag) {
                                            case 0:
                                                break;
                                            case 8:
                                                addPanoLocation(codedInputStreamMicro.readSInt32());
                                                continue;
                                            case 18:
                                                setPanoId(codedInputStreamMicro.readString());
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

                                public StepPano setPanoId(String str) {
                                    this.f9973b = true;
                                    this.f9974c = str;
                                    return this;
                                }

                                public StepPano setPanoLocation(int i, int i2) {
                                    this.f9972a.set(i, Integer.valueOf(i2));
                                    return this;
                                }

                                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                                    for (Integer intValue : getPanoLocationList()) {
                                        codedOutputStreamMicro.writeSInt32(1, intValue.intValue());
                                    }
                                    if (hasPanoId()) {
                                        codedOutputStreamMicro.writeString(2, getPanoId());
                                    }
                                }
                            }

                            public static final class Vehicle extends MessageMicro {
                                public static final int AREALINES_FIELD_NUMBER = 12;
                                public static final int CP_FIELD_NUMBER = 16;
                                public static final int DATE_FIELD_NUMBER = 13;
                                public static final int DISCOUNT_FIELD_NUMBER = 14;
                                public static final int END_CITY_UID_FIELD_NUMBER = 19;
                                public static final int END_NAME_FIELD_NUMBER = 7;
                                public static final int END_TIME_FIELD_NUMBER = 5;
                                public static final int LINESTATIONS_FIELD_NUMBER = 20;
                                public static final int LINE_TYPE_FIELD_NUMBER = 17;
                                public static final int NAME_FIELD_NUMBER = 1;
                                public static final int NEXT_BUS_INFO_FIELD_NUMBER = 11;
                                public static final int ORDER_URL_FIELD_NUMBER = 22;
                                public static final int PRICE_FIELD_NUMBER = 15;
                                public static final int START_NAME_FIELD_NUMBER = 23;
                                public static final int START_TIME_FIELD_NUMBER = 4;
                                public static final int START_UID_FIELD_NUMBER = 6;
                                public static final int START_WD_FIELD_NUMBER = 18;
                                public static final int STOP_NUM_FIELD_NUMBER = 8;
                                public static final int TELNUM_FIELD_NUMBER = 21;
                                public static final int TOTAL_PRICE_FIELD_NUMBER = 9;
                                public static final int TYPE_FIELD_NUMBER = 2;
                                public static final int UID_FIELD_NUMBER = 3;
                                public static final int ZONE_PRICE_FIELD_NUMBER = 10;
                                /* renamed from: A */
                                private String f9996A = "";
                                /* renamed from: B */
                                private boolean f9997B;
                                /* renamed from: C */
                                private String f9998C = "";
                                /* renamed from: D */
                                private boolean f9999D;
                                /* renamed from: E */
                                private String f10000E = "";
                                /* renamed from: F */
                                private boolean f10001F;
                                /* renamed from: G */
                                private String f10002G = "";
                                /* renamed from: H */
                                private boolean f10003H;
                                /* renamed from: I */
                                private int f10004I = 0;
                                /* renamed from: J */
                                private boolean f10005J;
                                /* renamed from: K */
                                private String f10006K = "";
                                /* renamed from: L */
                                private boolean f10007L;
                                /* renamed from: M */
                                private String f10008M = "";
                                /* renamed from: N */
                                private boolean f10009N;
                                /* renamed from: O */
                                private String f10010O = "";
                                /* renamed from: P */
                                private boolean f10011P;
                                /* renamed from: Q */
                                private String f10012Q = "";
                                /* renamed from: R */
                                private boolean f10013R;
                                /* renamed from: S */
                                private String f10014S = "";
                                /* renamed from: T */
                                private int f10015T = -1;
                                /* renamed from: a */
                                private boolean f10016a;
                                /* renamed from: b */
                                private NextBusInfo f10017b = null;
                                /* renamed from: c */
                                private List<Linestations> f10018c = Collections.emptyList();
                                /* renamed from: d */
                                private boolean f10019d;
                                /* renamed from: e */
                                private String f10020e = "";
                                /* renamed from: f */
                                private boolean f10021f;
                                /* renamed from: g */
                                private int f10022g = 0;
                                /* renamed from: h */
                                private boolean f10023h;
                                /* renamed from: i */
                                private String f10024i = "";
                                /* renamed from: j */
                                private boolean f10025j;
                                /* renamed from: k */
                                private String f10026k = "";
                                /* renamed from: l */
                                private boolean f10027l;
                                /* renamed from: m */
                                private String f10028m = "";
                                /* renamed from: n */
                                private boolean f10029n;
                                /* renamed from: o */
                                private String f10030o = "";
                                /* renamed from: p */
                                private boolean f10031p;
                                /* renamed from: q */
                                private String f10032q = "";
                                /* renamed from: r */
                                private boolean f10033r;
                                /* renamed from: s */
                                private int f10034s = 0;
                                /* renamed from: t */
                                private boolean f10035t;
                                /* renamed from: u */
                                private int f10036u = 0;
                                /* renamed from: v */
                                private boolean f10037v;
                                /* renamed from: w */
                                private int f10038w = 0;
                                /* renamed from: x */
                                private boolean f10039x;
                                /* renamed from: y */
                                private String f10040y = "";
                                /* renamed from: z */
                                private boolean f10041z;

                                public static final class Linestations extends MessageMicro {
                                    public static final int GEO_FIELD_NUMBER = 3;
                                    public static final int NAME_FIELD_NUMBER = 1;
                                    public static final int SGEO_FIELD_NUMBER = 4;
                                    public static final int START_TIME_FIELD_NUMBER = 2;
                                    /* renamed from: a */
                                    private boolean f9976a;
                                    /* renamed from: b */
                                    private String f9977b = "";
                                    /* renamed from: c */
                                    private boolean f9978c;
                                    /* renamed from: d */
                                    private String f9979d = "";
                                    /* renamed from: e */
                                    private boolean f9980e;
                                    /* renamed from: f */
                                    private String f9981f = "";
                                    /* renamed from: g */
                                    private List<Integer> f9982g = Collections.emptyList();
                                    /* renamed from: h */
                                    private int f9983h = -1;

                                    public static Linestations parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                                        return new Linestations().mergeFrom(codedInputStreamMicro);
                                    }

                                    public static Linestations parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                                        return (Linestations) new Linestations().mergeFrom(bArr);
                                    }

                                    public Linestations addSgeo(int i) {
                                        if (this.f9982g.isEmpty()) {
                                            this.f9982g = new ArrayList();
                                        }
                                        this.f9982g.add(Integer.valueOf(i));
                                        return this;
                                    }

                                    public final Linestations clear() {
                                        clearName();
                                        clearStartTime();
                                        clearGeo();
                                        clearSgeo();
                                        this.f9983h = -1;
                                        return this;
                                    }

                                    public Linestations clearGeo() {
                                        this.f9980e = false;
                                        this.f9981f = "";
                                        return this;
                                    }

                                    public Linestations clearName() {
                                        this.f9976a = false;
                                        this.f9977b = "";
                                        return this;
                                    }

                                    public Linestations clearSgeo() {
                                        this.f9982g = Collections.emptyList();
                                        return this;
                                    }

                                    public Linestations clearStartTime() {
                                        this.f9978c = false;
                                        this.f9979d = "";
                                        return this;
                                    }

                                    public int getCachedSize() {
                                        if (this.f9983h < 0) {
                                            getSerializedSize();
                                        }
                                        return this.f9983h;
                                    }

                                    public String getGeo() {
                                        return this.f9981f;
                                    }

                                    public String getName() {
                                        return this.f9977b;
                                    }

                                    public int getSerializedSize() {
                                        int i = 0;
                                        int computeStringSize = hasName() ? CodedOutputStreamMicro.computeStringSize(1, getName()) + 0 : 0;
                                        if (hasStartTime()) {
                                            computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getStartTime());
                                        }
                                        int computeStringSize2 = hasGeo() ? computeStringSize + CodedOutputStreamMicro.computeStringSize(3, getGeo()) : computeStringSize;
                                        for (Integer intValue : getSgeoList()) {
                                            i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue());
                                        }
                                        computeStringSize = (computeStringSize2 + i) + (getSgeoList().size() * 1);
                                        this.f9983h = computeStringSize;
                                        return computeStringSize;
                                    }

                                    public int getSgeo(int i) {
                                        return ((Integer) this.f9982g.get(i)).intValue();
                                    }

                                    public int getSgeoCount() {
                                        return this.f9982g.size();
                                    }

                                    public List<Integer> getSgeoList() {
                                        return this.f9982g;
                                    }

                                    public String getStartTime() {
                                        return this.f9979d;
                                    }

                                    public boolean hasGeo() {
                                        return this.f9980e;
                                    }

                                    public boolean hasName() {
                                        return this.f9976a;
                                    }

                                    public boolean hasStartTime() {
                                        return this.f9978c;
                                    }

                                    public final boolean isInitialized() {
                                        return true;
                                    }

                                    public Linestations mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                                        while (true) {
                                            int readTag = codedInputStreamMicro.readTag();
                                            switch (readTag) {
                                                case 0:
                                                    break;
                                                case 10:
                                                    setName(codedInputStreamMicro.readString());
                                                    continue;
                                                case 18:
                                                    setStartTime(codedInputStreamMicro.readString());
                                                    continue;
                                                case 26:
                                                    setGeo(codedInputStreamMicro.readString());
                                                    continue;
                                                case 32:
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

                                    public Linestations setGeo(String str) {
                                        this.f9980e = true;
                                        this.f9981f = str;
                                        return this;
                                    }

                                    public Linestations setName(String str) {
                                        this.f9976a = true;
                                        this.f9977b = str;
                                        return this;
                                    }

                                    public Linestations setSgeo(int i, int i2) {
                                        this.f9982g.set(i, Integer.valueOf(i2));
                                        return this;
                                    }

                                    public Linestations setStartTime(String str) {
                                        this.f9978c = true;
                                        this.f9979d = str;
                                        return this;
                                    }

                                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                                        if (hasName()) {
                                            codedOutputStreamMicro.writeString(1, getName());
                                        }
                                        if (hasStartTime()) {
                                            codedOutputStreamMicro.writeString(2, getStartTime());
                                        }
                                        if (hasGeo()) {
                                            codedOutputStreamMicro.writeString(3, getGeo());
                                        }
                                        for (Integer intValue : getSgeoList()) {
                                            codedOutputStreamMicro.writeSInt32(4, intValue.intValue());
                                        }
                                    }
                                }

                                public static final class NextBusInfo extends MessageMicro {
                                    public static final int REMAIN_DIS_FIELD_NUMBER = 2;
                                    public static final int REMAIN_STOPS_FIELD_NUMBER = 3;
                                    public static final int REMAIN_TIME_FIELD_NUMBER = 1;
                                    public static final int SPATH_FIELD_NUMBER = 6;
                                    public static final int X_FIELD_NUMBER = 4;
                                    public static final int Y_FIELD_NUMBER = 5;
                                    /* renamed from: a */
                                    private boolean f9984a;
                                    /* renamed from: b */
                                    private int f9985b = 0;
                                    /* renamed from: c */
                                    private boolean f9986c;
                                    /* renamed from: d */
                                    private int f9987d = 0;
                                    /* renamed from: e */
                                    private boolean f9988e;
                                    /* renamed from: f */
                                    private int f9989f = 0;
                                    /* renamed from: g */
                                    private boolean f9990g;
                                    /* renamed from: h */
                                    private int f9991h = 0;
                                    /* renamed from: i */
                                    private boolean f9992i;
                                    /* renamed from: j */
                                    private int f9993j = 0;
                                    /* renamed from: k */
                                    private List<Integer> f9994k = Collections.emptyList();
                                    /* renamed from: l */
                                    private int f9995l = -1;

                                    public static NextBusInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                                        return new NextBusInfo().mergeFrom(codedInputStreamMicro);
                                    }

                                    public static NextBusInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                                        return (NextBusInfo) new NextBusInfo().mergeFrom(bArr);
                                    }

                                    public NextBusInfo addSpath(int i) {
                                        if (this.f9994k.isEmpty()) {
                                            this.f9994k = new ArrayList();
                                        }
                                        this.f9994k.add(Integer.valueOf(i));
                                        return this;
                                    }

                                    public final NextBusInfo clear() {
                                        clearRemainTime();
                                        clearRemainDis();
                                        clearRemainStops();
                                        clearX();
                                        clearY();
                                        clearSpath();
                                        this.f9995l = -1;
                                        return this;
                                    }

                                    public NextBusInfo clearRemainDis() {
                                        this.f9986c = false;
                                        this.f9987d = 0;
                                        return this;
                                    }

                                    public NextBusInfo clearRemainStops() {
                                        this.f9988e = false;
                                        this.f9989f = 0;
                                        return this;
                                    }

                                    public NextBusInfo clearRemainTime() {
                                        this.f9984a = false;
                                        this.f9985b = 0;
                                        return this;
                                    }

                                    public NextBusInfo clearSpath() {
                                        this.f9994k = Collections.emptyList();
                                        return this;
                                    }

                                    public NextBusInfo clearX() {
                                        this.f9990g = false;
                                        this.f9991h = 0;
                                        return this;
                                    }

                                    public NextBusInfo clearY() {
                                        this.f9992i = false;
                                        this.f9993j = 0;
                                        return this;
                                    }

                                    public int getCachedSize() {
                                        if (this.f9995l < 0) {
                                            getSerializedSize();
                                        }
                                        return this.f9995l;
                                    }

                                    public int getRemainDis() {
                                        return this.f9987d;
                                    }

                                    public int getRemainStops() {
                                        return this.f9989f;
                                    }

                                    public int getRemainTime() {
                                        return this.f9985b;
                                    }

                                    public int getSerializedSize() {
                                        int i = 0;
                                        int computeInt32Size = hasRemainTime() ? CodedOutputStreamMicro.computeInt32Size(1, getRemainTime()) + 0 : 0;
                                        if (hasRemainDis()) {
                                            computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getRemainDis());
                                        }
                                        if (hasRemainStops()) {
                                            computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getRemainStops());
                                        }
                                        if (hasX()) {
                                            computeInt32Size += CodedOutputStreamMicro.computeSInt32Size(4, getX());
                                        }
                                        int computeSInt32Size = hasY() ? computeInt32Size + CodedOutputStreamMicro.computeSInt32Size(5, getY()) : computeInt32Size;
                                        for (Integer intValue : getSpathList()) {
                                            i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue());
                                        }
                                        computeInt32Size = (computeSInt32Size + i) + (getSpathList().size() * 1);
                                        this.f9995l = computeInt32Size;
                                        return computeInt32Size;
                                    }

                                    public int getSpath(int i) {
                                        return ((Integer) this.f9994k.get(i)).intValue();
                                    }

                                    public int getSpathCount() {
                                        return this.f9994k.size();
                                    }

                                    public List<Integer> getSpathList() {
                                        return this.f9994k;
                                    }

                                    public int getX() {
                                        return this.f9991h;
                                    }

                                    public int getY() {
                                        return this.f9993j;
                                    }

                                    public boolean hasRemainDis() {
                                        return this.f9986c;
                                    }

                                    public boolean hasRemainStops() {
                                        return this.f9988e;
                                    }

                                    public boolean hasRemainTime() {
                                        return this.f9984a;
                                    }

                                    public boolean hasX() {
                                        return this.f9990g;
                                    }

                                    public boolean hasY() {
                                        return this.f9992i;
                                    }

                                    public final boolean isInitialized() {
                                        return true;
                                    }

                                    public NextBusInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                                        while (true) {
                                            int readTag = codedInputStreamMicro.readTag();
                                            switch (readTag) {
                                                case 0:
                                                    break;
                                                case 8:
                                                    setRemainTime(codedInputStreamMicro.readInt32());
                                                    continue;
                                                case 16:
                                                    setRemainDis(codedInputStreamMicro.readInt32());
                                                    continue;
                                                case 24:
                                                    setRemainStops(codedInputStreamMicro.readInt32());
                                                    continue;
                                                case 32:
                                                    setX(codedInputStreamMicro.readSInt32());
                                                    continue;
                                                case 40:
                                                    setY(codedInputStreamMicro.readSInt32());
                                                    continue;
                                                case 48:
                                                    addSpath(codedInputStreamMicro.readSInt32());
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

                                    public NextBusInfo setRemainDis(int i) {
                                        this.f9986c = true;
                                        this.f9987d = i;
                                        return this;
                                    }

                                    public NextBusInfo setRemainStops(int i) {
                                        this.f9988e = true;
                                        this.f9989f = i;
                                        return this;
                                    }

                                    public NextBusInfo setRemainTime(int i) {
                                        this.f9984a = true;
                                        this.f9985b = i;
                                        return this;
                                    }

                                    public NextBusInfo setSpath(int i, int i2) {
                                        this.f9994k.set(i, Integer.valueOf(i2));
                                        return this;
                                    }

                                    public NextBusInfo setX(int i) {
                                        this.f9990g = true;
                                        this.f9991h = i;
                                        return this;
                                    }

                                    public NextBusInfo setY(int i) {
                                        this.f9992i = true;
                                        this.f9993j = i;
                                        return this;
                                    }

                                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                                        if (hasRemainTime()) {
                                            codedOutputStreamMicro.writeInt32(1, getRemainTime());
                                        }
                                        if (hasRemainDis()) {
                                            codedOutputStreamMicro.writeInt32(2, getRemainDis());
                                        }
                                        if (hasRemainStops()) {
                                            codedOutputStreamMicro.writeInt32(3, getRemainStops());
                                        }
                                        if (hasX()) {
                                            codedOutputStreamMicro.writeSInt32(4, getX());
                                        }
                                        if (hasY()) {
                                            codedOutputStreamMicro.writeSInt32(5, getY());
                                        }
                                        for (Integer intValue : getSpathList()) {
                                            codedOutputStreamMicro.writeSInt32(6, intValue.intValue());
                                        }
                                    }
                                }

                                public static Vehicle parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                                    return new Vehicle().mergeFrom(codedInputStreamMicro);
                                }

                                public static Vehicle parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                                    return (Vehicle) new Vehicle().mergeFrom(bArr);
                                }

                                public Vehicle addLinestations(Linestations linestations) {
                                    if (linestations != null) {
                                        if (this.f10018c.isEmpty()) {
                                            this.f10018c = new ArrayList();
                                        }
                                        this.f10018c.add(linestations);
                                    }
                                    return this;
                                }

                                public final Vehicle clear() {
                                    clearNextBusInfo();
                                    clearLinestations();
                                    clearName();
                                    clearType();
                                    clearUid();
                                    clearStartTime();
                                    clearEndTime();
                                    clearStartUid();
                                    clearEndName();
                                    clearStopNum();
                                    clearTotalPrice();
                                    clearZonePrice();
                                    clearArealines();
                                    clearDate();
                                    clearDiscount();
                                    clearPrice();
                                    clearCp();
                                    clearLineType();
                                    clearStartWd();
                                    clearEndCityUid();
                                    clearTelnum();
                                    clearOrderUrl();
                                    clearStartName();
                                    this.f10015T = -1;
                                    return this;
                                }

                                public Vehicle clearArealines() {
                                    this.f10039x = false;
                                    this.f10040y = "";
                                    return this;
                                }

                                public Vehicle clearCp() {
                                    this.f10001F = false;
                                    this.f10002G = "";
                                    return this;
                                }

                                public Vehicle clearDate() {
                                    this.f10041z = false;
                                    this.f9996A = "";
                                    return this;
                                }

                                public Vehicle clearDiscount() {
                                    this.f9997B = false;
                                    this.f9998C = "";
                                    return this;
                                }

                                public Vehicle clearEndCityUid() {
                                    this.f10007L = false;
                                    this.f10008M = "";
                                    return this;
                                }

                                public Vehicle clearEndName() {
                                    this.f10031p = false;
                                    this.f10032q = "";
                                    return this;
                                }

                                public Vehicle clearEndTime() {
                                    this.f10027l = false;
                                    this.f10028m = "";
                                    return this;
                                }

                                public Vehicle clearLineType() {
                                    this.f10003H = false;
                                    this.f10004I = 0;
                                    return this;
                                }

                                public Vehicle clearLinestations() {
                                    this.f10018c = Collections.emptyList();
                                    return this;
                                }

                                public Vehicle clearName() {
                                    this.f10019d = false;
                                    this.f10020e = "";
                                    return this;
                                }

                                public Vehicle clearNextBusInfo() {
                                    this.f10016a = false;
                                    this.f10017b = null;
                                    return this;
                                }

                                public Vehicle clearOrderUrl() {
                                    this.f10011P = false;
                                    this.f10012Q = "";
                                    return this;
                                }

                                public Vehicle clearPrice() {
                                    this.f9999D = false;
                                    this.f10000E = "";
                                    return this;
                                }

                                public Vehicle clearStartName() {
                                    this.f10013R = false;
                                    this.f10014S = "";
                                    return this;
                                }

                                public Vehicle clearStartTime() {
                                    this.f10025j = false;
                                    this.f10026k = "";
                                    return this;
                                }

                                public Vehicle clearStartUid() {
                                    this.f10029n = false;
                                    this.f10030o = "";
                                    return this;
                                }

                                public Vehicle clearStartWd() {
                                    this.f10005J = false;
                                    this.f10006K = "";
                                    return this;
                                }

                                public Vehicle clearStopNum() {
                                    this.f10033r = false;
                                    this.f10034s = 0;
                                    return this;
                                }

                                public Vehicle clearTelnum() {
                                    this.f10009N = false;
                                    this.f10010O = "";
                                    return this;
                                }

                                public Vehicle clearTotalPrice() {
                                    this.f10035t = false;
                                    this.f10036u = 0;
                                    return this;
                                }

                                public Vehicle clearType() {
                                    this.f10021f = false;
                                    this.f10022g = 0;
                                    return this;
                                }

                                public Vehicle clearUid() {
                                    this.f10023h = false;
                                    this.f10024i = "";
                                    return this;
                                }

                                public Vehicle clearZonePrice() {
                                    this.f10037v = false;
                                    this.f10038w = 0;
                                    return this;
                                }

                                public String getArealines() {
                                    return this.f10040y;
                                }

                                public int getCachedSize() {
                                    if (this.f10015T < 0) {
                                        getSerializedSize();
                                    }
                                    return this.f10015T;
                                }

                                public String getCp() {
                                    return this.f10002G;
                                }

                                public String getDate() {
                                    return this.f9996A;
                                }

                                public String getDiscount() {
                                    return this.f9998C;
                                }

                                public String getEndCityUid() {
                                    return this.f10008M;
                                }

                                public String getEndName() {
                                    return this.f10032q;
                                }

                                public String getEndTime() {
                                    return this.f10028m;
                                }

                                public int getLineType() {
                                    return this.f10004I;
                                }

                                public Linestations getLinestations(int i) {
                                    return (Linestations) this.f10018c.get(i);
                                }

                                public int getLinestationsCount() {
                                    return this.f10018c.size();
                                }

                                public List<Linestations> getLinestationsList() {
                                    return this.f10018c;
                                }

                                public String getName() {
                                    return this.f10020e;
                                }

                                public NextBusInfo getNextBusInfo() {
                                    return this.f10017b;
                                }

                                public String getOrderUrl() {
                                    return this.f10012Q;
                                }

                                public String getPrice() {
                                    return this.f10000E;
                                }

                                public int getSerializedSize() {
                                    int i = 0;
                                    if (hasName()) {
                                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
                                    }
                                    if (hasType()) {
                                        i += CodedOutputStreamMicro.computeInt32Size(2, getType());
                                    }
                                    if (hasUid()) {
                                        i += CodedOutputStreamMicro.computeStringSize(3, getUid());
                                    }
                                    if (hasStartTime()) {
                                        i += CodedOutputStreamMicro.computeStringSize(4, getStartTime());
                                    }
                                    if (hasEndTime()) {
                                        i += CodedOutputStreamMicro.computeStringSize(5, getEndTime());
                                    }
                                    if (hasStartUid()) {
                                        i += CodedOutputStreamMicro.computeStringSize(6, getStartUid());
                                    }
                                    if (hasEndName()) {
                                        i += CodedOutputStreamMicro.computeStringSize(7, getEndName());
                                    }
                                    if (hasStopNum()) {
                                        i += CodedOutputStreamMicro.computeInt32Size(8, getStopNum());
                                    }
                                    if (hasTotalPrice()) {
                                        i += CodedOutputStreamMicro.computeInt32Size(9, getTotalPrice());
                                    }
                                    if (hasZonePrice()) {
                                        i += CodedOutputStreamMicro.computeInt32Size(10, getZonePrice());
                                    }
                                    if (hasNextBusInfo()) {
                                        i += CodedOutputStreamMicro.computeMessageSize(11, getNextBusInfo());
                                    }
                                    if (hasArealines()) {
                                        i += CodedOutputStreamMicro.computeStringSize(12, getArealines());
                                    }
                                    if (hasDate()) {
                                        i += CodedOutputStreamMicro.computeStringSize(13, getDate());
                                    }
                                    if (hasDiscount()) {
                                        i += CodedOutputStreamMicro.computeStringSize(14, getDiscount());
                                    }
                                    if (hasPrice()) {
                                        i += CodedOutputStreamMicro.computeStringSize(15, getPrice());
                                    }
                                    if (hasCp()) {
                                        i += CodedOutputStreamMicro.computeStringSize(16, getCp());
                                    }
                                    if (hasLineType()) {
                                        i += CodedOutputStreamMicro.computeInt32Size(17, getLineType());
                                    }
                                    if (hasStartWd()) {
                                        i += CodedOutputStreamMicro.computeStringSize(18, getStartWd());
                                    }
                                    if (hasEndCityUid()) {
                                        i += CodedOutputStreamMicro.computeStringSize(19, getEndCityUid());
                                    }
                                    int i2 = i;
                                    for (Linestations computeMessageSize : getLinestationsList()) {
                                        i2 = CodedOutputStreamMicro.computeMessageSize(20, computeMessageSize) + i2;
                                    }
                                    if (hasTelnum()) {
                                        i2 += CodedOutputStreamMicro.computeStringSize(21, getTelnum());
                                    }
                                    if (hasOrderUrl()) {
                                        i2 += CodedOutputStreamMicro.computeStringSize(22, getOrderUrl());
                                    }
                                    if (hasStartName()) {
                                        i2 += CodedOutputStreamMicro.computeStringSize(23, getStartName());
                                    }
                                    this.f10015T = i2;
                                    return i2;
                                }

                                public String getStartName() {
                                    return this.f10014S;
                                }

                                public String getStartTime() {
                                    return this.f10026k;
                                }

                                public String getStartUid() {
                                    return this.f10030o;
                                }

                                public String getStartWd() {
                                    return this.f10006K;
                                }

                                public int getStopNum() {
                                    return this.f10034s;
                                }

                                public String getTelnum() {
                                    return this.f10010O;
                                }

                                public int getTotalPrice() {
                                    return this.f10036u;
                                }

                                public int getType() {
                                    return this.f10022g;
                                }

                                public String getUid() {
                                    return this.f10024i;
                                }

                                public int getZonePrice() {
                                    return this.f10038w;
                                }

                                public boolean hasArealines() {
                                    return this.f10039x;
                                }

                                public boolean hasCp() {
                                    return this.f10001F;
                                }

                                public boolean hasDate() {
                                    return this.f10041z;
                                }

                                public boolean hasDiscount() {
                                    return this.f9997B;
                                }

                                public boolean hasEndCityUid() {
                                    return this.f10007L;
                                }

                                public boolean hasEndName() {
                                    return this.f10031p;
                                }

                                public boolean hasEndTime() {
                                    return this.f10027l;
                                }

                                public boolean hasLineType() {
                                    return this.f10003H;
                                }

                                public boolean hasName() {
                                    return this.f10019d;
                                }

                                public boolean hasNextBusInfo() {
                                    return this.f10016a;
                                }

                                public boolean hasOrderUrl() {
                                    return this.f10011P;
                                }

                                public boolean hasPrice() {
                                    return this.f9999D;
                                }

                                public boolean hasStartName() {
                                    return this.f10013R;
                                }

                                public boolean hasStartTime() {
                                    return this.f10025j;
                                }

                                public boolean hasStartUid() {
                                    return this.f10029n;
                                }

                                public boolean hasStartWd() {
                                    return this.f10005J;
                                }

                                public boolean hasStopNum() {
                                    return this.f10033r;
                                }

                                public boolean hasTelnum() {
                                    return this.f10009N;
                                }

                                public boolean hasTotalPrice() {
                                    return this.f10035t;
                                }

                                public boolean hasType() {
                                    return this.f10021f;
                                }

                                public boolean hasUid() {
                                    return this.f10023h;
                                }

                                public boolean hasZonePrice() {
                                    return this.f10037v;
                                }

                                public final boolean isInitialized() {
                                    return true;
                                }

                                public Vehicle mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                                    while (true) {
                                        int readTag = codedInputStreamMicro.readTag();
                                        MessageMicro nextBusInfo;
                                        switch (readTag) {
                                            case 0:
                                                break;
                                            case 10:
                                                setName(codedInputStreamMicro.readString());
                                                continue;
                                            case 16:
                                                setType(codedInputStreamMicro.readInt32());
                                                continue;
                                            case 26:
                                                setUid(codedInputStreamMicro.readString());
                                                continue;
                                            case 34:
                                                setStartTime(codedInputStreamMicro.readString());
                                                continue;
                                            case 42:
                                                setEndTime(codedInputStreamMicro.readString());
                                                continue;
                                            case 50:
                                                setStartUid(codedInputStreamMicro.readString());
                                                continue;
                                            case 58:
                                                setEndName(codedInputStreamMicro.readString());
                                                continue;
                                            case 64:
                                                setStopNum(codedInputStreamMicro.readInt32());
                                                continue;
                                            case NavCarInfo.CarType_57L /*72*/:
                                                setTotalPrice(codedInputStreamMicro.readInt32());
                                                continue;
                                            case 80:
                                                setZonePrice(codedInputStreamMicro.readInt32());
                                                continue;
                                            case 90:
                                                nextBusInfo = new NextBusInfo();
                                                codedInputStreamMicro.readMessage(nextBusInfo);
                                                setNextBusInfo(nextBusInfo);
                                                continue;
                                            case 98:
                                                setArealines(codedInputStreamMicro.readString());
                                                continue;
                                            case 106:
                                                setDate(codedInputStreamMicro.readString());
                                                continue;
                                            case 114:
                                                setDiscount(codedInputStreamMicro.readString());
                                                continue;
                                            case C1253f.df /*122*/:
                                                setPrice(codedInputStreamMicro.readString());
                                                continue;
                                            case 130:
                                                setCp(codedInputStreamMicro.readString());
                                                continue;
                                            case RouteLineResConst.LINE_DARK_RED_NORMAL /*136*/:
                                                setLineType(codedInputStreamMicro.readInt32());
                                                continue;
                                            case 146:
                                                setStartWd(codedInputStreamMicro.readString());
                                                continue;
                                            case 154:
                                                setEndCityUid(codedInputStreamMicro.readString());
                                                continue;
                                            case 162:
                                                nextBusInfo = new Linestations();
                                                codedInputStreamMicro.readMessage(nextBusInfo);
                                                addLinestations(nextBusInfo);
                                                continue;
                                            case 170:
                                                setTelnum(codedInputStreamMicro.readString());
                                                continue;
                                            case 178:
                                                setOrderUrl(codedInputStreamMicro.readString());
                                                continue;
                                            case 186:
                                                setStartName(codedInputStreamMicro.readString());
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

                                public Vehicle setArealines(String str) {
                                    this.f10039x = true;
                                    this.f10040y = str;
                                    return this;
                                }

                                public Vehicle setCp(String str) {
                                    this.f10001F = true;
                                    this.f10002G = str;
                                    return this;
                                }

                                public Vehicle setDate(String str) {
                                    this.f10041z = true;
                                    this.f9996A = str;
                                    return this;
                                }

                                public Vehicle setDiscount(String str) {
                                    this.f9997B = true;
                                    this.f9998C = str;
                                    return this;
                                }

                                public Vehicle setEndCityUid(String str) {
                                    this.f10007L = true;
                                    this.f10008M = str;
                                    return this;
                                }

                                public Vehicle setEndName(String str) {
                                    this.f10031p = true;
                                    this.f10032q = str;
                                    return this;
                                }

                                public Vehicle setEndTime(String str) {
                                    this.f10027l = true;
                                    this.f10028m = str;
                                    return this;
                                }

                                public Vehicle setLineType(int i) {
                                    this.f10003H = true;
                                    this.f10004I = i;
                                    return this;
                                }

                                public Vehicle setLinestations(int i, Linestations linestations) {
                                    if (linestations != null) {
                                        this.f10018c.set(i, linestations);
                                    }
                                    return this;
                                }

                                public Vehicle setName(String str) {
                                    this.f10019d = true;
                                    this.f10020e = str;
                                    return this;
                                }

                                public Vehicle setNextBusInfo(NextBusInfo nextBusInfo) {
                                    if (nextBusInfo == null) {
                                        return clearNextBusInfo();
                                    }
                                    this.f10016a = true;
                                    this.f10017b = nextBusInfo;
                                    return this;
                                }

                                public Vehicle setOrderUrl(String str) {
                                    this.f10011P = true;
                                    this.f10012Q = str;
                                    return this;
                                }

                                public Vehicle setPrice(String str) {
                                    this.f9999D = true;
                                    this.f10000E = str;
                                    return this;
                                }

                                public Vehicle setStartName(String str) {
                                    this.f10013R = true;
                                    this.f10014S = str;
                                    return this;
                                }

                                public Vehicle setStartTime(String str) {
                                    this.f10025j = true;
                                    this.f10026k = str;
                                    return this;
                                }

                                public Vehicle setStartUid(String str) {
                                    this.f10029n = true;
                                    this.f10030o = str;
                                    return this;
                                }

                                public Vehicle setStartWd(String str) {
                                    this.f10005J = true;
                                    this.f10006K = str;
                                    return this;
                                }

                                public Vehicle setStopNum(int i) {
                                    this.f10033r = true;
                                    this.f10034s = i;
                                    return this;
                                }

                                public Vehicle setTelnum(String str) {
                                    this.f10009N = true;
                                    this.f10010O = str;
                                    return this;
                                }

                                public Vehicle setTotalPrice(int i) {
                                    this.f10035t = true;
                                    this.f10036u = i;
                                    return this;
                                }

                                public Vehicle setType(int i) {
                                    this.f10021f = true;
                                    this.f10022g = i;
                                    return this;
                                }

                                public Vehicle setUid(String str) {
                                    this.f10023h = true;
                                    this.f10024i = str;
                                    return this;
                                }

                                public Vehicle setZonePrice(int i) {
                                    this.f10037v = true;
                                    this.f10038w = i;
                                    return this;
                                }

                                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                                    if (hasName()) {
                                        codedOutputStreamMicro.writeString(1, getName());
                                    }
                                    if (hasType()) {
                                        codedOutputStreamMicro.writeInt32(2, getType());
                                    }
                                    if (hasUid()) {
                                        codedOutputStreamMicro.writeString(3, getUid());
                                    }
                                    if (hasStartTime()) {
                                        codedOutputStreamMicro.writeString(4, getStartTime());
                                    }
                                    if (hasEndTime()) {
                                        codedOutputStreamMicro.writeString(5, getEndTime());
                                    }
                                    if (hasStartUid()) {
                                        codedOutputStreamMicro.writeString(6, getStartUid());
                                    }
                                    if (hasEndName()) {
                                        codedOutputStreamMicro.writeString(7, getEndName());
                                    }
                                    if (hasStopNum()) {
                                        codedOutputStreamMicro.writeInt32(8, getStopNum());
                                    }
                                    if (hasTotalPrice()) {
                                        codedOutputStreamMicro.writeInt32(9, getTotalPrice());
                                    }
                                    if (hasZonePrice()) {
                                        codedOutputStreamMicro.writeInt32(10, getZonePrice());
                                    }
                                    if (hasNextBusInfo()) {
                                        codedOutputStreamMicro.writeMessage(11, getNextBusInfo());
                                    }
                                    if (hasArealines()) {
                                        codedOutputStreamMicro.writeString(12, getArealines());
                                    }
                                    if (hasDate()) {
                                        codedOutputStreamMicro.writeString(13, getDate());
                                    }
                                    if (hasDiscount()) {
                                        codedOutputStreamMicro.writeString(14, getDiscount());
                                    }
                                    if (hasPrice()) {
                                        codedOutputStreamMicro.writeString(15, getPrice());
                                    }
                                    if (hasCp()) {
                                        codedOutputStreamMicro.writeString(16, getCp());
                                    }
                                    if (hasLineType()) {
                                        codedOutputStreamMicro.writeInt32(17, getLineType());
                                    }
                                    if (hasStartWd()) {
                                        codedOutputStreamMicro.writeString(18, getStartWd());
                                    }
                                    if (hasEndCityUid()) {
                                        codedOutputStreamMicro.writeString(19, getEndCityUid());
                                    }
                                    for (Linestations writeMessage : getLinestationsList()) {
                                        codedOutputStreamMicro.writeMessage(20, writeMessage);
                                    }
                                    if (hasTelnum()) {
                                        codedOutputStreamMicro.writeString(21, getTelnum());
                                    }
                                    if (hasOrderUrl()) {
                                        codedOutputStreamMicro.writeString(22, getOrderUrl());
                                    }
                                    if (hasStartName()) {
                                        codedOutputStreamMicro.writeString(23, getStartName());
                                    }
                                }
                            }

                            public static LowerStep parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                                return new LowerStep().mergeFrom(codedInputStreamMicro);
                            }

                            public static LowerStep parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                                return (LowerStep) new LowerStep().mergeFrom(bArr);
                            }

                            public LowerStep addLineStops(String str) {
                                if (str == null) {
                                    throw new NullPointerException();
                                }
                                if (this.f10052K.isEmpty()) {
                                    this.f10052K = new ArrayList();
                                }
                                this.f10052K.add(str);
                                return this;
                            }

                            public LowerStep addPois(Pois pois) {
                                if (pois != null) {
                                    if (this.f10060e.isEmpty()) {
                                        this.f10060e = new ArrayList();
                                    }
                                    this.f10060e.add(pois);
                                }
                                return this;
                            }

                            public LowerStep addSendLocation(int i) {
                                if (this.f10050I.isEmpty()) {
                                    this.f10050I = new ArrayList();
                                }
                                this.f10050I.add(Integer.valueOf(i));
                                return this;
                            }

                            public LowerStep addSpath(int i) {
                                if (this.f10051J.isEmpty()) {
                                    this.f10051J = new ArrayList();
                                }
                                this.f10051J.add(Integer.valueOf(i));
                                return this;
                            }

                            public LowerStep addSstartLocation(int i) {
                                if (this.f10049H.isEmpty()) {
                                    this.f10049H = new ArrayList();
                                }
                                this.f10049H.add(Integer.valueOf(i));
                                return this;
                            }

                            public final LowerStep clear() {
                                clearDictInstruction();
                                clearVehicle();
                                clearPois();
                                clearPath();
                                clearType();
                                clearInstructions();
                                clearStartInstructions();
                                clearEndInstructions();
                                clearStartLocation();
                                clearEndLocation();
                                clearDistance();
                                clearDuration();
                                clearTip();
                                clearTipText();
                                clearTipBackground();
                                clearArriveTime();
                                clearDirection();
                                clearSstartLocation();
                                clearSendLocation();
                                clearSpath();
                                clearLineStops();
                                clearStepPano();
                                this.f10055N = -1;
                                return this;
                            }

                            public LowerStep clearArriveTime() {
                                this.f10045D = false;
                                this.f10046E = "";
                                return this;
                            }

                            public LowerStep clearDictInstruction() {
                                this.f10056a = false;
                                this.f10057b = null;
                                return this;
                            }

                            public LowerStep clearDirection() {
                                this.f10047F = false;
                                this.f10048G = 0;
                                return this;
                            }

                            public LowerStep clearDistance() {
                                this.f10075t = false;
                                this.f10076u = 0;
                                return this;
                            }

                            public LowerStep clearDuration() {
                                this.f10077v = false;
                                this.f10078w = 0;
                                return this;
                            }

                            public LowerStep clearEndInstructions() {
                                this.f10069n = false;
                                this.f10070o = "";
                                return this;
                            }

                            public LowerStep clearEndLocation() {
                                this.f10073r = false;
                                this.f10074s = "";
                                return this;
                            }

                            public LowerStep clearInstructions() {
                                this.f10065j = false;
                                this.f10066k = "";
                                return this;
                            }

                            public LowerStep clearLineStops() {
                                this.f10052K = Collections.emptyList();
                                return this;
                            }

                            public LowerStep clearPath() {
                                this.f10061f = false;
                                this.f10062g = "";
                                return this;
                            }

                            public LowerStep clearPois() {
                                this.f10060e = Collections.emptyList();
                                return this;
                            }

                            public LowerStep clearSendLocation() {
                                this.f10050I = Collections.emptyList();
                                return this;
                            }

                            public LowerStep clearSpath() {
                                this.f10051J = Collections.emptyList();
                                return this;
                            }

                            public LowerStep clearSstartLocation() {
                                this.f10049H = Collections.emptyList();
                                return this;
                            }

                            public LowerStep clearStartInstructions() {
                                this.f10067l = false;
                                this.f10068m = "";
                                return this;
                            }

                            public LowerStep clearStartLocation() {
                                this.f10071p = false;
                                this.f10072q = "";
                                return this;
                            }

                            public LowerStep clearStepPano() {
                                this.f10053L = false;
                                this.f10054M = null;
                                return this;
                            }

                            public LowerStep clearTip() {
                                this.f10079x = false;
                                this.f10080y = 0;
                                return this;
                            }

                            public LowerStep clearTipBackground() {
                                this.f10043B = false;
                                this.f10044C = "";
                                return this;
                            }

                            public LowerStep clearTipText() {
                                this.f10081z = false;
                                this.f10042A = "";
                                return this;
                            }

                            public LowerStep clearType() {
                                this.f10063h = false;
                                this.f10064i = 0;
                                return this;
                            }

                            public LowerStep clearVehicle() {
                                this.f10058c = false;
                                this.f10059d = null;
                                return this;
                            }

                            public String getArriveTime() {
                                return this.f10046E;
                            }

                            public int getCachedSize() {
                                if (this.f10055N < 0) {
                                    getSerializedSize();
                                }
                                return this.f10055N;
                            }

                            public DictInstruction getDictInstruction() {
                                return this.f10057b;
                            }

                            public int getDirection() {
                                return this.f10048G;
                            }

                            public int getDistance() {
                                return this.f10076u;
                            }

                            public int getDuration() {
                                return this.f10078w;
                            }

                            public String getEndInstructions() {
                                return this.f10070o;
                            }

                            public String getEndLocation() {
                                return this.f10074s;
                            }

                            public String getInstructions() {
                                return this.f10066k;
                            }

                            public String getLineStops(int i) {
                                return (String) this.f10052K.get(i);
                            }

                            public int getLineStopsCount() {
                                return this.f10052K.size();
                            }

                            public List<String> getLineStopsList() {
                                return this.f10052K;
                            }

                            public String getPath() {
                                return this.f10062g;
                            }

                            public Pois getPois(int i) {
                                return (Pois) this.f10060e.get(i);
                            }

                            public int getPoisCount() {
                                return this.f10060e.size();
                            }

                            public List<Pois> getPoisList() {
                                return this.f10060e;
                            }

                            public int getSendLocation(int i) {
                                return ((Integer) this.f10050I.get(i)).intValue();
                            }

                            public int getSendLocationCount() {
                                return this.f10050I.size();
                            }

                            public List<Integer> getSendLocationList() {
                                return this.f10050I;
                            }

                            public int getSerializedSize() {
                                int i = 0;
                                int computeStringSize = hasPath() ? CodedOutputStreamMicro.computeStringSize(1, getPath()) + 0 : 0;
                                if (hasType()) {
                                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getType());
                                }
                                if (hasInstructions()) {
                                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getInstructions());
                                }
                                if (hasStartInstructions()) {
                                    computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getStartInstructions());
                                }
                                if (hasEndInstructions()) {
                                    computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getEndInstructions());
                                }
                                if (hasStartLocation()) {
                                    computeStringSize += CodedOutputStreamMicro.computeStringSize(6, getStartLocation());
                                }
                                if (hasEndLocation()) {
                                    computeStringSize += CodedOutputStreamMicro.computeStringSize(7, getEndLocation());
                                }
                                if (hasDistance()) {
                                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(8, getDistance());
                                }
                                if (hasDuration()) {
                                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(9, getDuration());
                                }
                                if (hasVehicle()) {
                                    computeStringSize += CodedOutputStreamMicro.computeMessageSize(10, getVehicle());
                                }
                                if (hasTip()) {
                                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(11, getTip());
                                }
                                if (hasTipText()) {
                                    computeStringSize += CodedOutputStreamMicro.computeStringSize(12, getTipText());
                                }
                                if (hasTipBackground()) {
                                    computeStringSize += CodedOutputStreamMicro.computeStringSize(13, getTipBackground());
                                }
                                if (hasArriveTime()) {
                                    computeStringSize += CodedOutputStreamMicro.computeStringSize(14, getArriveTime());
                                }
                                if (hasDirection()) {
                                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(15, getDirection());
                                }
                                int i2 = computeStringSize;
                                for (Pois computeMessageSize : getPoisList()) {
                                    i2 = CodedOutputStreamMicro.computeMessageSize(16, computeMessageSize) + i2;
                                }
                                int i3 = 0;
                                for (Integer intValue : getSstartLocationList()) {
                                    i3 = CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue()) + i3;
                                }
                                i3 = (i2 + i3) + (getSstartLocationList().size() * 2);
                                i2 = 0;
                                for (Integer intValue2 : getSendLocationList()) {
                                    i2 = CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue2.intValue()) + i2;
                                }
                                i3 = (i3 + i2) + (getSendLocationList().size() * 2);
                                i2 = 0;
                                for (Integer intValue22 : getSpathList()) {
                                    i2 = CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue22.intValue()) + i2;
                                }
                                i2 = (getSpathList().size() * 2) + (i3 + i2);
                                for (String computeStringSizeNoTag : getLineStopsList()) {
                                    i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag);
                                }
                                computeStringSize = (i2 + i) + (getLineStopsList().size() * 2);
                                if (hasDictInstruction()) {
                                    computeStringSize += CodedOutputStreamMicro.computeMessageSize(21, getDictInstruction());
                                }
                                if (hasStepPano()) {
                                    computeStringSize += CodedOutputStreamMicro.computeMessageSize(22, getStepPano());
                                }
                                this.f10055N = computeStringSize;
                                return computeStringSize;
                            }

                            public int getSpath(int i) {
                                return ((Integer) this.f10051J.get(i)).intValue();
                            }

                            public int getSpathCount() {
                                return this.f10051J.size();
                            }

                            public List<Integer> getSpathList() {
                                return this.f10051J;
                            }

                            public int getSstartLocation(int i) {
                                return ((Integer) this.f10049H.get(i)).intValue();
                            }

                            public int getSstartLocationCount() {
                                return this.f10049H.size();
                            }

                            public List<Integer> getSstartLocationList() {
                                return this.f10049H;
                            }

                            public String getStartInstructions() {
                                return this.f10068m;
                            }

                            public String getStartLocation() {
                                return this.f10072q;
                            }

                            public StepPano getStepPano() {
                                return this.f10054M;
                            }

                            public int getTip() {
                                return this.f10080y;
                            }

                            public String getTipBackground() {
                                return this.f10044C;
                            }

                            public String getTipText() {
                                return this.f10042A;
                            }

                            public int getType() {
                                return this.f10064i;
                            }

                            public Vehicle getVehicle() {
                                return this.f10059d;
                            }

                            public boolean hasArriveTime() {
                                return this.f10045D;
                            }

                            public boolean hasDictInstruction() {
                                return this.f10056a;
                            }

                            public boolean hasDirection() {
                                return this.f10047F;
                            }

                            public boolean hasDistance() {
                                return this.f10075t;
                            }

                            public boolean hasDuration() {
                                return this.f10077v;
                            }

                            public boolean hasEndInstructions() {
                                return this.f10069n;
                            }

                            public boolean hasEndLocation() {
                                return this.f10073r;
                            }

                            public boolean hasInstructions() {
                                return this.f10065j;
                            }

                            public boolean hasPath() {
                                return this.f10061f;
                            }

                            public boolean hasStartInstructions() {
                                return this.f10067l;
                            }

                            public boolean hasStartLocation() {
                                return this.f10071p;
                            }

                            public boolean hasStepPano() {
                                return this.f10053L;
                            }

                            public boolean hasTip() {
                                return this.f10079x;
                            }

                            public boolean hasTipBackground() {
                                return this.f10043B;
                            }

                            public boolean hasTipText() {
                                return this.f10081z;
                            }

                            public boolean hasType() {
                                return this.f10063h;
                            }

                            public boolean hasVehicle() {
                                return this.f10058c;
                            }

                            public final boolean isInitialized() {
                                return true;
                            }

                            public LowerStep mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                                while (true) {
                                    int readTag = codedInputStreamMicro.readTag();
                                    MessageMicro vehicle;
                                    switch (readTag) {
                                        case 0:
                                            break;
                                        case 10:
                                            setPath(codedInputStreamMicro.readString());
                                            continue;
                                        case 16:
                                            setType(codedInputStreamMicro.readInt32());
                                            continue;
                                        case 26:
                                            setInstructions(codedInputStreamMicro.readString());
                                            continue;
                                        case 34:
                                            setStartInstructions(codedInputStreamMicro.readString());
                                            continue;
                                        case 42:
                                            setEndInstructions(codedInputStreamMicro.readString());
                                            continue;
                                        case 50:
                                            setStartLocation(codedInputStreamMicro.readString());
                                            continue;
                                        case 58:
                                            setEndLocation(codedInputStreamMicro.readString());
                                            continue;
                                        case 64:
                                            setDistance(codedInputStreamMicro.readInt32());
                                            continue;
                                        case NavCarInfo.CarType_57L /*72*/:
                                            setDuration(codedInputStreamMicro.readInt32());
                                            continue;
                                        case 82:
                                            vehicle = new Vehicle();
                                            codedInputStreamMicro.readMessage(vehicle);
                                            setVehicle(vehicle);
                                            continue;
                                        case 88:
                                            setTip(codedInputStreamMicro.readInt32());
                                            continue;
                                        case 98:
                                            setTipText(codedInputStreamMicro.readString());
                                            continue;
                                        case 106:
                                            setTipBackground(codedInputStreamMicro.readString());
                                            continue;
                                        case 114:
                                            setArriveTime(codedInputStreamMicro.readString());
                                            continue;
                                        case 120:
                                            setDirection(codedInputStreamMicro.readInt32());
                                            continue;
                                        case 130:
                                            vehicle = new Pois();
                                            codedInputStreamMicro.readMessage(vehicle);
                                            addPois(vehicle);
                                            continue;
                                        case RouteLineResConst.LINE_DARK_RED_NORMAL /*136*/:
                                            addSstartLocation(codedInputStreamMicro.readSInt32());
                                            continue;
                                        case 144:
                                            addSendLocation(codedInputStreamMicro.readSInt32());
                                            continue;
                                        case 152:
                                            addSpath(codedInputStreamMicro.readSInt32());
                                            continue;
                                        case 162:
                                            addLineStops(codedInputStreamMicro.readString());
                                            continue;
                                        case 170:
                                            vehicle = new DictInstruction();
                                            codedInputStreamMicro.readMessage(vehicle);
                                            setDictInstruction(vehicle);
                                            continue;
                                        case 178:
                                            vehicle = new StepPano();
                                            codedInputStreamMicro.readMessage(vehicle);
                                            setStepPano(vehicle);
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

                            public LowerStep setArriveTime(String str) {
                                this.f10045D = true;
                                this.f10046E = str;
                                return this;
                            }

                            public LowerStep setDictInstruction(DictInstruction dictInstruction) {
                                if (dictInstruction == null) {
                                    return clearDictInstruction();
                                }
                                this.f10056a = true;
                                this.f10057b = dictInstruction;
                                return this;
                            }

                            public LowerStep setDirection(int i) {
                                this.f10047F = true;
                                this.f10048G = i;
                                return this;
                            }

                            public LowerStep setDistance(int i) {
                                this.f10075t = true;
                                this.f10076u = i;
                                return this;
                            }

                            public LowerStep setDuration(int i) {
                                this.f10077v = true;
                                this.f10078w = i;
                                return this;
                            }

                            public LowerStep setEndInstructions(String str) {
                                this.f10069n = true;
                                this.f10070o = str;
                                return this;
                            }

                            public LowerStep setEndLocation(String str) {
                                this.f10073r = true;
                                this.f10074s = str;
                                return this;
                            }

                            public LowerStep setInstructions(String str) {
                                this.f10065j = true;
                                this.f10066k = str;
                                return this;
                            }

                            public LowerStep setLineStops(int i, String str) {
                                if (str == null) {
                                    throw new NullPointerException();
                                }
                                this.f10052K.set(i, str);
                                return this;
                            }

                            public LowerStep setPath(String str) {
                                this.f10061f = true;
                                this.f10062g = str;
                                return this;
                            }

                            public LowerStep setPois(int i, Pois pois) {
                                if (pois != null) {
                                    this.f10060e.set(i, pois);
                                }
                                return this;
                            }

                            public LowerStep setSendLocation(int i, int i2) {
                                this.f10050I.set(i, Integer.valueOf(i2));
                                return this;
                            }

                            public LowerStep setSpath(int i, int i2) {
                                this.f10051J.set(i, Integer.valueOf(i2));
                                return this;
                            }

                            public LowerStep setSstartLocation(int i, int i2) {
                                this.f10049H.set(i, Integer.valueOf(i2));
                                return this;
                            }

                            public LowerStep setStartInstructions(String str) {
                                this.f10067l = true;
                                this.f10068m = str;
                                return this;
                            }

                            public LowerStep setStartLocation(String str) {
                                this.f10071p = true;
                                this.f10072q = str;
                                return this;
                            }

                            public LowerStep setStepPano(StepPano stepPano) {
                                if (stepPano == null) {
                                    return clearStepPano();
                                }
                                this.f10053L = true;
                                this.f10054M = stepPano;
                                return this;
                            }

                            public LowerStep setTip(int i) {
                                this.f10079x = true;
                                this.f10080y = i;
                                return this;
                            }

                            public LowerStep setTipBackground(String str) {
                                this.f10043B = true;
                                this.f10044C = str;
                                return this;
                            }

                            public LowerStep setTipText(String str) {
                                this.f10081z = true;
                                this.f10042A = str;
                                return this;
                            }

                            public LowerStep setType(int i) {
                                this.f10063h = true;
                                this.f10064i = i;
                                return this;
                            }

                            public LowerStep setVehicle(Vehicle vehicle) {
                                if (vehicle == null) {
                                    return clearVehicle();
                                }
                                this.f10058c = true;
                                this.f10059d = vehicle;
                                return this;
                            }

                            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                                if (hasPath()) {
                                    codedOutputStreamMicro.writeString(1, getPath());
                                }
                                if (hasType()) {
                                    codedOutputStreamMicro.writeInt32(2, getType());
                                }
                                if (hasInstructions()) {
                                    codedOutputStreamMicro.writeString(3, getInstructions());
                                }
                                if (hasStartInstructions()) {
                                    codedOutputStreamMicro.writeString(4, getStartInstructions());
                                }
                                if (hasEndInstructions()) {
                                    codedOutputStreamMicro.writeString(5, getEndInstructions());
                                }
                                if (hasStartLocation()) {
                                    codedOutputStreamMicro.writeString(6, getStartLocation());
                                }
                                if (hasEndLocation()) {
                                    codedOutputStreamMicro.writeString(7, getEndLocation());
                                }
                                if (hasDistance()) {
                                    codedOutputStreamMicro.writeInt32(8, getDistance());
                                }
                                if (hasDuration()) {
                                    codedOutputStreamMicro.writeInt32(9, getDuration());
                                }
                                if (hasVehicle()) {
                                    codedOutputStreamMicro.writeMessage(10, getVehicle());
                                }
                                if (hasTip()) {
                                    codedOutputStreamMicro.writeInt32(11, getTip());
                                }
                                if (hasTipText()) {
                                    codedOutputStreamMicro.writeString(12, getTipText());
                                }
                                if (hasTipBackground()) {
                                    codedOutputStreamMicro.writeString(13, getTipBackground());
                                }
                                if (hasArriveTime()) {
                                    codedOutputStreamMicro.writeString(14, getArriveTime());
                                }
                                if (hasDirection()) {
                                    codedOutputStreamMicro.writeInt32(15, getDirection());
                                }
                                for (Pois writeMessage : getPoisList()) {
                                    codedOutputStreamMicro.writeMessage(16, writeMessage);
                                }
                                for (Integer intValue : getSstartLocationList()) {
                                    codedOutputStreamMicro.writeSInt32(17, intValue.intValue());
                                }
                                for (Integer intValue2 : getSendLocationList()) {
                                    codedOutputStreamMicro.writeSInt32(18, intValue2.intValue());
                                }
                                for (Integer intValue22 : getSpathList()) {
                                    codedOutputStreamMicro.writeSInt32(19, intValue22.intValue());
                                }
                                for (String writeString : getLineStopsList()) {
                                    codedOutputStreamMicro.writeString(20, writeString);
                                }
                                if (hasDictInstruction()) {
                                    codedOutputStreamMicro.writeMessage(21, getDictInstruction());
                                }
                                if (hasStepPano()) {
                                    codedOutputStreamMicro.writeMessage(22, getStepPano());
                                }
                            }
                        }

                        public static LowerSteps parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new LowerSteps().mergeFrom(codedInputStreamMicro);
                        }

                        public static LowerSteps parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (LowerSteps) new LowerSteps().mergeFrom(bArr);
                        }

                        public LowerSteps addLowerStep(LowerStep lowerStep) {
                            if (lowerStep != null) {
                                if (this.f10082a.isEmpty()) {
                                    this.f10082a = new ArrayList();
                                }
                                this.f10082a.add(lowerStep);
                            }
                            return this;
                        }

                        public final LowerSteps clear() {
                            clearLowerStep();
                            this.f10083b = -1;
                            return this;
                        }

                        public LowerSteps clearLowerStep() {
                            this.f10082a = Collections.emptyList();
                            return this;
                        }

                        public int getCachedSize() {
                            if (this.f10083b < 0) {
                                getSerializedSize();
                            }
                            return this.f10083b;
                        }

                        public LowerStep getLowerStep(int i) {
                            return (LowerStep) this.f10082a.get(i);
                        }

                        public int getLowerStepCount() {
                            return this.f10082a.size();
                        }

                        public List<LowerStep> getLowerStepList() {
                            return this.f10082a;
                        }

                        public int getSerializedSize() {
                            int i = 0;
                            for (LowerStep computeMessageSize : getLowerStepList()) {
                                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
                            }
                            this.f10083b = i;
                            return i;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public LowerSteps mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                switch (readTag) {
                                    case 0:
                                        break;
                                    case 10:
                                        MessageMicro lowerStep = new LowerStep();
                                        codedInputStreamMicro.readMessage(lowerStep);
                                        addLowerStep(lowerStep);
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

                        public LowerSteps setLowerStep(int i, LowerStep lowerStep) {
                            if (lowerStep != null) {
                                this.f10082a.set(i, lowerStep);
                            }
                            return this;
                        }

                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            for (LowerStep writeMessage : getLowerStepList()) {
                                codedOutputStreamMicro.writeMessage(1, writeMessage);
                            }
                        }
                    }

                    public static final class Pois extends MessageMicro {
                        public static final int DETAIL_FIELD_NUMBER = 4;
                        public static final int LOCATION_FIELD_NUMBER = 2;
                        public static final int NAME_FIELD_NUMBER = 1;
                        public static final int SLOCATION_FIELD_NUMBER = 5;
                        public static final int TYPE_FIELD_NUMBER = 3;
                        /* renamed from: a */
                        private boolean f10084a;
                        /* renamed from: b */
                        private String f10085b = "";
                        /* renamed from: c */
                        private boolean f10086c;
                        /* renamed from: d */
                        private String f10087d = "";
                        /* renamed from: e */
                        private boolean f10088e;
                        /* renamed from: f */
                        private int f10089f = 0;
                        /* renamed from: g */
                        private boolean f10090g;
                        /* renamed from: h */
                        private String f10091h = "";
                        /* renamed from: i */
                        private List<Integer> f10092i = Collections.emptyList();
                        /* renamed from: j */
                        private int f10093j = -1;

                        public static Pois parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new Pois().mergeFrom(codedInputStreamMicro);
                        }

                        public static Pois parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (Pois) new Pois().mergeFrom(bArr);
                        }

                        public Pois addSlocation(int i) {
                            if (this.f10092i.isEmpty()) {
                                this.f10092i = new ArrayList();
                            }
                            this.f10092i.add(Integer.valueOf(i));
                            return this;
                        }

                        public final Pois clear() {
                            clearName();
                            clearLocation();
                            clearType();
                            clearDetail();
                            clearSlocation();
                            this.f10093j = -1;
                            return this;
                        }

                        public Pois clearDetail() {
                            this.f10090g = false;
                            this.f10091h = "";
                            return this;
                        }

                        public Pois clearLocation() {
                            this.f10086c = false;
                            this.f10087d = "";
                            return this;
                        }

                        public Pois clearName() {
                            this.f10084a = false;
                            this.f10085b = "";
                            return this;
                        }

                        public Pois clearSlocation() {
                            this.f10092i = Collections.emptyList();
                            return this;
                        }

                        public Pois clearType() {
                            this.f10088e = false;
                            this.f10089f = 0;
                            return this;
                        }

                        public int getCachedSize() {
                            if (this.f10093j < 0) {
                                getSerializedSize();
                            }
                            return this.f10093j;
                        }

                        public String getDetail() {
                            return this.f10091h;
                        }

                        public String getLocation() {
                            return this.f10087d;
                        }

                        public String getName() {
                            return this.f10085b;
                        }

                        public int getSerializedSize() {
                            int i = 0;
                            int computeStringSize = hasName() ? CodedOutputStreamMicro.computeStringSize(1, getName()) + 0 : 0;
                            if (hasLocation()) {
                                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getLocation());
                            }
                            if (hasType()) {
                                computeStringSize += CodedOutputStreamMicro.computeInt32Size(3, getType());
                            }
                            int computeStringSize2 = hasDetail() ? computeStringSize + CodedOutputStreamMicro.computeStringSize(4, getDetail()) : computeStringSize;
                            for (Integer intValue : getSlocationList()) {
                                i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue());
                            }
                            computeStringSize = (computeStringSize2 + i) + (getSlocationList().size() * 1);
                            this.f10093j = computeStringSize;
                            return computeStringSize;
                        }

                        public int getSlocation(int i) {
                            return ((Integer) this.f10092i.get(i)).intValue();
                        }

                        public int getSlocationCount() {
                            return this.f10092i.size();
                        }

                        public List<Integer> getSlocationList() {
                            return this.f10092i;
                        }

                        public int getType() {
                            return this.f10089f;
                        }

                        public boolean hasDetail() {
                            return this.f10090g;
                        }

                        public boolean hasLocation() {
                            return this.f10086c;
                        }

                        public boolean hasName() {
                            return this.f10084a;
                        }

                        public boolean hasType() {
                            return this.f10088e;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public Pois mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                switch (readTag) {
                                    case 0:
                                        break;
                                    case 10:
                                        setName(codedInputStreamMicro.readString());
                                        continue;
                                    case 18:
                                        setLocation(codedInputStreamMicro.readString());
                                        continue;
                                    case 24:
                                        setType(codedInputStreamMicro.readInt32());
                                        continue;
                                    case 34:
                                        setDetail(codedInputStreamMicro.readString());
                                        continue;
                                    case 40:
                                        addSlocation(codedInputStreamMicro.readSInt32());
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

                        public Pois setDetail(String str) {
                            this.f10090g = true;
                            this.f10091h = str;
                            return this;
                        }

                        public Pois setLocation(String str) {
                            this.f10086c = true;
                            this.f10087d = str;
                            return this;
                        }

                        public Pois setName(String str) {
                            this.f10084a = true;
                            this.f10085b = str;
                            return this;
                        }

                        public Pois setSlocation(int i, int i2) {
                            this.f10092i.set(i, Integer.valueOf(i2));
                            return this;
                        }

                        public Pois setType(int i) {
                            this.f10088e = true;
                            this.f10089f = i;
                            return this;
                        }

                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasName()) {
                                codedOutputStreamMicro.writeString(1, getName());
                            }
                            if (hasLocation()) {
                                codedOutputStreamMicro.writeString(2, getLocation());
                            }
                            if (hasType()) {
                                codedOutputStreamMicro.writeInt32(3, getType());
                            }
                            if (hasDetail()) {
                                codedOutputStreamMicro.writeString(4, getDetail());
                            }
                            for (Integer intValue : getSlocationList()) {
                                codedOutputStreamMicro.writeSInt32(5, intValue.intValue());
                            }
                        }
                    }

                    public static final class StepPano extends MessageMicro {
                        public static final int PANO_ID_FIELD_NUMBER = 2;
                        public static final int PANO_LOCATION_FIELD_NUMBER = 1;
                        /* renamed from: a */
                        private List<Integer> f10094a = Collections.emptyList();
                        /* renamed from: b */
                        private boolean f10095b;
                        /* renamed from: c */
                        private String f10096c = "";
                        /* renamed from: d */
                        private int f10097d = -1;

                        public static StepPano parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new StepPano().mergeFrom(codedInputStreamMicro);
                        }

                        public static StepPano parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (StepPano) new StepPano().mergeFrom(bArr);
                        }

                        public StepPano addPanoLocation(int i) {
                            if (this.f10094a.isEmpty()) {
                                this.f10094a = new ArrayList();
                            }
                            this.f10094a.add(Integer.valueOf(i));
                            return this;
                        }

                        public final StepPano clear() {
                            clearPanoLocation();
                            clearPanoId();
                            this.f10097d = -1;
                            return this;
                        }

                        public StepPano clearPanoId() {
                            this.f10095b = false;
                            this.f10096c = "";
                            return this;
                        }

                        public StepPano clearPanoLocation() {
                            this.f10094a = Collections.emptyList();
                            return this;
                        }

                        public int getCachedSize() {
                            if (this.f10097d < 0) {
                                getSerializedSize();
                            }
                            return this.f10097d;
                        }

                        public String getPanoId() {
                            return this.f10096c;
                        }

                        public int getPanoLocation(int i) {
                            return ((Integer) this.f10094a.get(i)).intValue();
                        }

                        public int getPanoLocationCount() {
                            return this.f10094a.size();
                        }

                        public List<Integer> getPanoLocationList() {
                            return this.f10094a;
                        }

                        public int getSerializedSize() {
                            int i = 0;
                            for (Integer intValue : getPanoLocationList()) {
                                i = CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue()) + i;
                            }
                            int size = (0 + i) + (getPanoLocationList().size() * 1);
                            if (hasPanoId()) {
                                size += CodedOutputStreamMicro.computeStringSize(2, getPanoId());
                            }
                            this.f10097d = size;
                            return size;
                        }

                        public boolean hasPanoId() {
                            return this.f10095b;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public StepPano mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                switch (readTag) {
                                    case 0:
                                        break;
                                    case 8:
                                        addPanoLocation(codedInputStreamMicro.readSInt32());
                                        continue;
                                    case 18:
                                        setPanoId(codedInputStreamMicro.readString());
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

                        public StepPano setPanoId(String str) {
                            this.f10095b = true;
                            this.f10096c = str;
                            return this;
                        }

                        public StepPano setPanoLocation(int i, int i2) {
                            this.f10094a.set(i, Integer.valueOf(i2));
                            return this;
                        }

                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            for (Integer intValue : getPanoLocationList()) {
                                codedOutputStreamMicro.writeSInt32(1, intValue.intValue());
                            }
                            if (hasPanoId()) {
                                codedOutputStreamMicro.writeString(2, getPanoId());
                            }
                        }
                    }

                    public static final class StopsPos extends MessageMicro {
                        public static final int X_FIELD_NUMBER = 1;
                        public static final int Y_FIELD_NUMBER = 2;
                        /* renamed from: a */
                        private boolean f10098a;
                        /* renamed from: b */
                        private double f10099b = 0.0d;
                        /* renamed from: c */
                        private boolean f10100c;
                        /* renamed from: d */
                        private double f10101d = 0.0d;
                        /* renamed from: e */
                        private int f10102e = -1;

                        public static StopsPos parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new StopsPos().mergeFrom(codedInputStreamMicro);
                        }

                        public static StopsPos parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (StopsPos) new StopsPos().mergeFrom(bArr);
                        }

                        public final StopsPos clear() {
                            clearX();
                            clearY();
                            this.f10102e = -1;
                            return this;
                        }

                        public StopsPos clearX() {
                            this.f10098a = false;
                            this.f10099b = 0.0d;
                            return this;
                        }

                        public StopsPos clearY() {
                            this.f10100c = false;
                            this.f10101d = 0.0d;
                            return this;
                        }

                        public int getCachedSize() {
                            if (this.f10102e < 0) {
                                getSerializedSize();
                            }
                            return this.f10102e;
                        }

                        public int getSerializedSize() {
                            int i = 0;
                            if (hasX()) {
                                i = 0 + CodedOutputStreamMicro.computeDoubleSize(1, getX());
                            }
                            if (hasY()) {
                                i += CodedOutputStreamMicro.computeDoubleSize(2, getY());
                            }
                            this.f10102e = i;
                            return i;
                        }

                        public double getX() {
                            return this.f10099b;
                        }

                        public double getY() {
                            return this.f10101d;
                        }

                        public boolean hasX() {
                            return this.f10098a;
                        }

                        public boolean hasY() {
                            return this.f10100c;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public StopsPos mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                switch (readTag) {
                                    case 0:
                                        break;
                                    case 9:
                                        setX(codedInputStreamMicro.readDouble());
                                        continue;
                                    case 17:
                                        setY(codedInputStreamMicro.readDouble());
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

                        public StopsPos setX(double d) {
                            this.f10098a = true;
                            this.f10099b = d;
                            return this;
                        }

                        public StopsPos setY(double d) {
                            this.f10100c = true;
                            this.f10101d = d;
                            return this;
                        }

                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasX()) {
                                codedOutputStreamMicro.writeDouble(1, getX());
                            }
                            if (hasY()) {
                                codedOutputStreamMicro.writeDouble(2, getY());
                            }
                        }
                    }

                    public static final class Ticket extends MessageMicro {
                        public static final int BUY_STATUS_FIELD_NUMBER = 2;
                        public static final int SEATS_FIELD_NUMBER = 3;
                        public static final int URL_FIELD_NUMBER = 1;
                        /* renamed from: a */
                        private boolean f10112a;
                        /* renamed from: b */
                        private String f10113b = "";
                        /* renamed from: c */
                        private boolean f10114c;
                        /* renamed from: d */
                        private String f10115d = "";
                        /* renamed from: e */
                        private List<Seats> f10116e = Collections.emptyList();
                        /* renamed from: f */
                        private int f10117f = -1;

                        public static final class Seats extends MessageMicro {
                            public static final int NAME_FIELD_NUMBER = 1;
                            public static final int PRICE_FIELD_NUMBER = 2;
                            public static final int REMAIN_FIELD_NUMBER = 3;
                            public static final int URL_FIELD_NUMBER = 4;
                            /* renamed from: a */
                            private boolean f10103a;
                            /* renamed from: b */
                            private String f10104b = "";
                            /* renamed from: c */
                            private boolean f10105c;
                            /* renamed from: d */
                            private double f10106d = 0.0d;
                            /* renamed from: e */
                            private boolean f10107e;
                            /* renamed from: f */
                            private int f10108f = 0;
                            /* renamed from: g */
                            private boolean f10109g;
                            /* renamed from: h */
                            private String f10110h = "";
                            /* renamed from: i */
                            private int f10111i = -1;

                            public static Seats parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                                return new Seats().mergeFrom(codedInputStreamMicro);
                            }

                            public static Seats parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                                return (Seats) new Seats().mergeFrom(bArr);
                            }

                            public final Seats clear() {
                                clearName();
                                clearPrice();
                                clearRemain();
                                clearUrl();
                                this.f10111i = -1;
                                return this;
                            }

                            public Seats clearName() {
                                this.f10103a = false;
                                this.f10104b = "";
                                return this;
                            }

                            public Seats clearPrice() {
                                this.f10105c = false;
                                this.f10106d = 0.0d;
                                return this;
                            }

                            public Seats clearRemain() {
                                this.f10107e = false;
                                this.f10108f = 0;
                                return this;
                            }

                            public Seats clearUrl() {
                                this.f10109g = false;
                                this.f10110h = "";
                                return this;
                            }

                            public int getCachedSize() {
                                if (this.f10111i < 0) {
                                    getSerializedSize();
                                }
                                return this.f10111i;
                            }

                            public String getName() {
                                return this.f10104b;
                            }

                            public double getPrice() {
                                return this.f10106d;
                            }

                            public int getRemain() {
                                return this.f10108f;
                            }

                            public int getSerializedSize() {
                                int i = 0;
                                if (hasName()) {
                                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
                                }
                                if (hasPrice()) {
                                    i += CodedOutputStreamMicro.computeDoubleSize(2, getPrice());
                                }
                                if (hasRemain()) {
                                    i += CodedOutputStreamMicro.computeInt32Size(3, getRemain());
                                }
                                if (hasUrl()) {
                                    i += CodedOutputStreamMicro.computeStringSize(4, getUrl());
                                }
                                this.f10111i = i;
                                return i;
                            }

                            public String getUrl() {
                                return this.f10110h;
                            }

                            public boolean hasName() {
                                return this.f10103a;
                            }

                            public boolean hasPrice() {
                                return this.f10105c;
                            }

                            public boolean hasRemain() {
                                return this.f10107e;
                            }

                            public boolean hasUrl() {
                                return this.f10109g;
                            }

                            public final boolean isInitialized() {
                                return true;
                            }

                            public Seats mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                                while (true) {
                                    int readTag = codedInputStreamMicro.readTag();
                                    switch (readTag) {
                                        case 0:
                                            break;
                                        case 10:
                                            setName(codedInputStreamMicro.readString());
                                            continue;
                                        case 17:
                                            setPrice(codedInputStreamMicro.readDouble());
                                            continue;
                                        case 24:
                                            setRemain(codedInputStreamMicro.readInt32());
                                            continue;
                                        case 34:
                                            setUrl(codedInputStreamMicro.readString());
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

                            public Seats setName(String str) {
                                this.f10103a = true;
                                this.f10104b = str;
                                return this;
                            }

                            public Seats setPrice(double d) {
                                this.f10105c = true;
                                this.f10106d = d;
                                return this;
                            }

                            public Seats setRemain(int i) {
                                this.f10107e = true;
                                this.f10108f = i;
                                return this;
                            }

                            public Seats setUrl(String str) {
                                this.f10109g = true;
                                this.f10110h = str;
                                return this;
                            }

                            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                                if (hasName()) {
                                    codedOutputStreamMicro.writeString(1, getName());
                                }
                                if (hasPrice()) {
                                    codedOutputStreamMicro.writeDouble(2, getPrice());
                                }
                                if (hasRemain()) {
                                    codedOutputStreamMicro.writeInt32(3, getRemain());
                                }
                                if (hasUrl()) {
                                    codedOutputStreamMicro.writeString(4, getUrl());
                                }
                            }
                        }

                        public static Ticket parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new Ticket().mergeFrom(codedInputStreamMicro);
                        }

                        public static Ticket parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (Ticket) new Ticket().mergeFrom(bArr);
                        }

                        public Ticket addSeats(Seats seats) {
                            if (seats != null) {
                                if (this.f10116e.isEmpty()) {
                                    this.f10116e = new ArrayList();
                                }
                                this.f10116e.add(seats);
                            }
                            return this;
                        }

                        public final Ticket clear() {
                            clearUrl();
                            clearBuyStatus();
                            clearSeats();
                            this.f10117f = -1;
                            return this;
                        }

                        public Ticket clearBuyStatus() {
                            this.f10114c = false;
                            this.f10115d = "";
                            return this;
                        }

                        public Ticket clearSeats() {
                            this.f10116e = Collections.emptyList();
                            return this;
                        }

                        public Ticket clearUrl() {
                            this.f10112a = false;
                            this.f10113b = "";
                            return this;
                        }

                        public String getBuyStatus() {
                            return this.f10115d;
                        }

                        public int getCachedSize() {
                            if (this.f10117f < 0) {
                                getSerializedSize();
                            }
                            return this.f10117f;
                        }

                        public Seats getSeats(int i) {
                            return (Seats) this.f10116e.get(i);
                        }

                        public int getSeatsCount() {
                            return this.f10116e.size();
                        }

                        public List<Seats> getSeatsList() {
                            return this.f10116e;
                        }

                        public int getSerializedSize() {
                            int i = 0;
                            if (hasUrl()) {
                                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUrl());
                            }
                            if (hasBuyStatus()) {
                                i += CodedOutputStreamMicro.computeStringSize(2, getBuyStatus());
                            }
                            int i2 = i;
                            for (Seats computeMessageSize : getSeatsList()) {
                                i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
                            }
                            this.f10117f = i2;
                            return i2;
                        }

                        public String getUrl() {
                            return this.f10113b;
                        }

                        public boolean hasBuyStatus() {
                            return this.f10114c;
                        }

                        public boolean hasUrl() {
                            return this.f10112a;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public Ticket mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                switch (readTag) {
                                    case 0:
                                        break;
                                    case 10:
                                        setUrl(codedInputStreamMicro.readString());
                                        continue;
                                    case 18:
                                        setBuyStatus(codedInputStreamMicro.readString());
                                        continue;
                                    case 26:
                                        MessageMicro seats = new Seats();
                                        codedInputStreamMicro.readMessage(seats);
                                        addSeats(seats);
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

                        public Ticket setBuyStatus(String str) {
                            this.f10114c = true;
                            this.f10115d = str;
                            return this;
                        }

                        public Ticket setSeats(int i, Seats seats) {
                            if (seats != null) {
                                this.f10116e.set(i, seats);
                            }
                            return this;
                        }

                        public Ticket setUrl(String str) {
                            this.f10112a = true;
                            this.f10113b = str;
                            return this;
                        }

                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasUrl()) {
                                codedOutputStreamMicro.writeString(1, getUrl());
                            }
                            if (hasBuyStatus()) {
                                codedOutputStreamMicro.writeString(2, getBuyStatus());
                            }
                            for (Seats writeMessage : getSeatsList()) {
                                codedOutputStreamMicro.writeMessage(3, writeMessage);
                            }
                        }
                    }

                    public static final class TransferDict extends MessageMicro {
                        public static final int DATE_FIELD_NUMBER = 5;
                        public static final int END_ADDRESS_FIELD_NUMBER = 4;
                        public static final int PROVIDER_FIELD_NUMBER = 1;
                        public static final int START_ADDRESS_FIELD_NUMBER = 3;
                        public static final int TYPE_FIELD_NUMBER = 2;
                        /* renamed from: a */
                        private boolean f10118a;
                        /* renamed from: b */
                        private String f10119b = "";
                        /* renamed from: c */
                        private boolean f10120c;
                        /* renamed from: d */
                        private int f10121d = 0;
                        /* renamed from: e */
                        private boolean f10122e;
                        /* renamed from: f */
                        private String f10123f = "";
                        /* renamed from: g */
                        private boolean f10124g;
                        /* renamed from: h */
                        private String f10125h = "";
                        /* renamed from: i */
                        private boolean f10126i;
                        /* renamed from: j */
                        private String f10127j = "";
                        /* renamed from: k */
                        private int f10128k = -1;

                        public static TransferDict parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new TransferDict().mergeFrom(codedInputStreamMicro);
                        }

                        public static TransferDict parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (TransferDict) new TransferDict().mergeFrom(bArr);
                        }

                        public final TransferDict clear() {
                            clearProvider();
                            clearType();
                            clearStartAddress();
                            clearEndAddress();
                            clearDate();
                            this.f10128k = -1;
                            return this;
                        }

                        public TransferDict clearDate() {
                            this.f10126i = false;
                            this.f10127j = "";
                            return this;
                        }

                        public TransferDict clearEndAddress() {
                            this.f10124g = false;
                            this.f10125h = "";
                            return this;
                        }

                        public TransferDict clearProvider() {
                            this.f10118a = false;
                            this.f10119b = "";
                            return this;
                        }

                        public TransferDict clearStartAddress() {
                            this.f10122e = false;
                            this.f10123f = "";
                            return this;
                        }

                        public TransferDict clearType() {
                            this.f10120c = false;
                            this.f10121d = 0;
                            return this;
                        }

                        public int getCachedSize() {
                            if (this.f10128k < 0) {
                                getSerializedSize();
                            }
                            return this.f10128k;
                        }

                        public String getDate() {
                            return this.f10127j;
                        }

                        public String getEndAddress() {
                            return this.f10125h;
                        }

                        public String getProvider() {
                            return this.f10119b;
                        }

                        public int getSerializedSize() {
                            int i = 0;
                            if (hasProvider()) {
                                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getProvider());
                            }
                            if (hasType()) {
                                i += CodedOutputStreamMicro.computeInt32Size(2, getType());
                            }
                            if (hasStartAddress()) {
                                i += CodedOutputStreamMicro.computeStringSize(3, getStartAddress());
                            }
                            if (hasEndAddress()) {
                                i += CodedOutputStreamMicro.computeStringSize(4, getEndAddress());
                            }
                            if (hasDate()) {
                                i += CodedOutputStreamMicro.computeStringSize(5, getDate());
                            }
                            this.f10128k = i;
                            return i;
                        }

                        public String getStartAddress() {
                            return this.f10123f;
                        }

                        public int getType() {
                            return this.f10121d;
                        }

                        public boolean hasDate() {
                            return this.f10126i;
                        }

                        public boolean hasEndAddress() {
                            return this.f10124g;
                        }

                        public boolean hasProvider() {
                            return this.f10118a;
                        }

                        public boolean hasStartAddress() {
                            return this.f10122e;
                        }

                        public boolean hasType() {
                            return this.f10120c;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public TransferDict mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                switch (readTag) {
                                    case 0:
                                        break;
                                    case 10:
                                        setProvider(codedInputStreamMicro.readString());
                                        continue;
                                    case 16:
                                        setType(codedInputStreamMicro.readInt32());
                                        continue;
                                    case 26:
                                        setStartAddress(codedInputStreamMicro.readString());
                                        continue;
                                    case 34:
                                        setEndAddress(codedInputStreamMicro.readString());
                                        continue;
                                    case 42:
                                        setDate(codedInputStreamMicro.readString());
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

                        public TransferDict setDate(String str) {
                            this.f10126i = true;
                            this.f10127j = str;
                            return this;
                        }

                        public TransferDict setEndAddress(String str) {
                            this.f10124g = true;
                            this.f10125h = str;
                            return this;
                        }

                        public TransferDict setProvider(String str) {
                            this.f10118a = true;
                            this.f10119b = str;
                            return this;
                        }

                        public TransferDict setStartAddress(String str) {
                            this.f10122e = true;
                            this.f10123f = str;
                            return this;
                        }

                        public TransferDict setType(int i) {
                            this.f10120c = true;
                            this.f10121d = i;
                            return this;
                        }

                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasProvider()) {
                                codedOutputStreamMicro.writeString(1, getProvider());
                            }
                            if (hasType()) {
                                codedOutputStreamMicro.writeInt32(2, getType());
                            }
                            if (hasStartAddress()) {
                                codedOutputStreamMicro.writeString(3, getStartAddress());
                            }
                            if (hasEndAddress()) {
                                codedOutputStreamMicro.writeString(4, getEndAddress());
                            }
                            if (hasDate()) {
                                codedOutputStreamMicro.writeString(5, getDate());
                            }
                        }
                    }

                    public static final class Vehicle extends MessageMicro {
                        public static final int AREALINES_FIELD_NUMBER = 12;
                        public static final int CP_FIELD_NUMBER = 16;
                        public static final int DATE_FIELD_NUMBER = 13;
                        public static final int DISCOUNT_FIELD_NUMBER = 14;
                        public static final int END_CITY_NAME_FIELD_NUMBER = 35;
                        public static final int END_CITY_UID_FIELD_NUMBER = 19;
                        public static final int END_NAME_FIELD_NUMBER = 7;
                        public static final int END_STATION_TYPE_FIELD_NUMBER = 25;
                        public static final int END_TIME_FIELD_NUMBER = 5;
                        public static final int END_UID_FIELD_NUMBER = 24;
                        public static final int HEADWAY_FIELD_NUMBER = 33;
                        public static final int IS_RTBUS_FIELD_NUMBER = 34;
                        public static final int IS_SUPPORT_TICKET_FIELD_NUMBER = 29;
                        public static final int LINESTATIONS_FIELD_NUMBER = 20;
                        public static final int LINE_COLOR_FIELD_NUMBER = 32;
                        public static final int LINE_TYPE_FIELD_NUMBER = 17;
                        public static final int NAME_FIELD_NUMBER = 1;
                        public static final int NEXT_BUS_INFO_FIELD_NUMBER = 11;
                        public static final int ORDER_URL_FIELD_NUMBER = 22;
                        public static final int PRICE_FIELD_NUMBER = 15;
                        public static final int PROVIDER_NAME_FIELD_NUMBER = 26;
                        public static final int PROVIDER_URL_FIELD_NUMBER = 27;
                        public static final int START_CITY_NAME_FIELD_NUMBER = 28;
                        public static final int START_NAME_FIELD_NUMBER = 23;
                        public static final int START_TIME_FIELD_NUMBER = 4;
                        public static final int START_UID_FIELD_NUMBER = 6;
                        public static final int START_WD_FIELD_NUMBER = 18;
                        public static final int STOP_NUM_FIELD_NUMBER = 8;
                        public static final int TELNUM_FIELD_NUMBER = 21;
                        public static final int TICKET_URL_FIELD_NUMBER = 31;
                        public static final int TOTAL_PRICE_FIELD_NUMBER = 9;
                        public static final int TYPE_FIELD_NUMBER = 2;
                        public static final int UID_FIELD_NUMBER = 3;
                        public static final int ZONE_PRICE_FIELD_NUMBER = 10;
                        /* renamed from: A */
                        private String f10149A = "";
                        /* renamed from: B */
                        private boolean f10150B;
                        /* renamed from: C */
                        private String f10151C = "";
                        /* renamed from: D */
                        private boolean f10152D;
                        /* renamed from: E */
                        private String f10153E = "";
                        /* renamed from: F */
                        private boolean f10154F;
                        /* renamed from: G */
                        private String f10155G = "";
                        /* renamed from: H */
                        private boolean f10156H;
                        /* renamed from: I */
                        private int f10157I = 0;
                        /* renamed from: J */
                        private boolean f10158J;
                        /* renamed from: K */
                        private String f10159K = "";
                        /* renamed from: L */
                        private boolean f10160L;
                        /* renamed from: M */
                        private String f10161M = "";
                        /* renamed from: N */
                        private boolean f10162N;
                        /* renamed from: O */
                        private String f10163O = "";
                        /* renamed from: P */
                        private boolean f10164P;
                        /* renamed from: Q */
                        private String f10165Q = "";
                        /* renamed from: R */
                        private boolean f10166R;
                        /* renamed from: S */
                        private String f10167S = "";
                        /* renamed from: T */
                        private boolean f10168T;
                        /* renamed from: U */
                        private String f10169U = "";
                        /* renamed from: V */
                        private boolean f10170V;
                        /* renamed from: W */
                        private int f10171W = 0;
                        /* renamed from: X */
                        private boolean f10172X;
                        /* renamed from: Y */
                        private String f10173Y = "";
                        /* renamed from: Z */
                        private boolean f10174Z;
                        /* renamed from: a */
                        private boolean f10175a;
                        private String aa = "";
                        private boolean ab;
                        private String ac = "";
                        private boolean ad;
                        private int ae = 0;
                        private boolean af;
                        private String ag = "";
                        private boolean ah;
                        private String ai = "";
                        private boolean aj;
                        private String ak = "";
                        private boolean al;
                        private int am = 0;
                        private boolean an;
                        private String ao = "";
                        private int ap = -1;
                        /* renamed from: b */
                        private NextBusInfo f10176b = null;
                        /* renamed from: c */
                        private List<Linestations> f10177c = Collections.emptyList();
                        /* renamed from: d */
                        private boolean f10178d;
                        /* renamed from: e */
                        private String f10179e = "";
                        /* renamed from: f */
                        private boolean f10180f;
                        /* renamed from: g */
                        private int f10181g = 0;
                        /* renamed from: h */
                        private boolean f10182h;
                        /* renamed from: i */
                        private String f10183i = "";
                        /* renamed from: j */
                        private boolean f10184j;
                        /* renamed from: k */
                        private String f10185k = "";
                        /* renamed from: l */
                        private boolean f10186l;
                        /* renamed from: m */
                        private String f10187m = "";
                        /* renamed from: n */
                        private boolean f10188n;
                        /* renamed from: o */
                        private String f10189o = "";
                        /* renamed from: p */
                        private boolean f10190p;
                        /* renamed from: q */
                        private String f10191q = "";
                        /* renamed from: r */
                        private boolean f10192r;
                        /* renamed from: s */
                        private int f10193s = 0;
                        /* renamed from: t */
                        private boolean f10194t;
                        /* renamed from: u */
                        private int f10195u = 0;
                        /* renamed from: v */
                        private boolean f10196v;
                        /* renamed from: w */
                        private int f10197w = 0;
                        /* renamed from: x */
                        private boolean f10198x;
                        /* renamed from: y */
                        private String f10199y = "";
                        /* renamed from: z */
                        private boolean f10200z;

                        public static final class Linestations extends MessageMicro {
                            public static final int GEO_FIELD_NUMBER = 3;
                            public static final int NAME_FIELD_NUMBER = 1;
                            public static final int SGEO_FIELD_NUMBER = 4;
                            public static final int START_TIME_FIELD_NUMBER = 2;
                            /* renamed from: a */
                            private boolean f10129a;
                            /* renamed from: b */
                            private String f10130b = "";
                            /* renamed from: c */
                            private boolean f10131c;
                            /* renamed from: d */
                            private String f10132d = "";
                            /* renamed from: e */
                            private boolean f10133e;
                            /* renamed from: f */
                            private String f10134f = "";
                            /* renamed from: g */
                            private List<Integer> f10135g = Collections.emptyList();
                            /* renamed from: h */
                            private int f10136h = -1;

                            public static Linestations parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                                return new Linestations().mergeFrom(codedInputStreamMicro);
                            }

                            public static Linestations parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                                return (Linestations) new Linestations().mergeFrom(bArr);
                            }

                            public Linestations addSgeo(int i) {
                                if (this.f10135g.isEmpty()) {
                                    this.f10135g = new ArrayList();
                                }
                                this.f10135g.add(Integer.valueOf(i));
                                return this;
                            }

                            public final Linestations clear() {
                                clearName();
                                clearStartTime();
                                clearGeo();
                                clearSgeo();
                                this.f10136h = -1;
                                return this;
                            }

                            public Linestations clearGeo() {
                                this.f10133e = false;
                                this.f10134f = "";
                                return this;
                            }

                            public Linestations clearName() {
                                this.f10129a = false;
                                this.f10130b = "";
                                return this;
                            }

                            public Linestations clearSgeo() {
                                this.f10135g = Collections.emptyList();
                                return this;
                            }

                            public Linestations clearStartTime() {
                                this.f10131c = false;
                                this.f10132d = "";
                                return this;
                            }

                            public int getCachedSize() {
                                if (this.f10136h < 0) {
                                    getSerializedSize();
                                }
                                return this.f10136h;
                            }

                            public String getGeo() {
                                return this.f10134f;
                            }

                            public String getName() {
                                return this.f10130b;
                            }

                            public int getSerializedSize() {
                                int i = 0;
                                int computeStringSize = hasName() ? CodedOutputStreamMicro.computeStringSize(1, getName()) + 0 : 0;
                                if (hasStartTime()) {
                                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getStartTime());
                                }
                                int computeStringSize2 = hasGeo() ? computeStringSize + CodedOutputStreamMicro.computeStringSize(3, getGeo()) : computeStringSize;
                                for (Integer intValue : getSgeoList()) {
                                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue());
                                }
                                computeStringSize = (computeStringSize2 + i) + (getSgeoList().size() * 1);
                                this.f10136h = computeStringSize;
                                return computeStringSize;
                            }

                            public int getSgeo(int i) {
                                return ((Integer) this.f10135g.get(i)).intValue();
                            }

                            public int getSgeoCount() {
                                return this.f10135g.size();
                            }

                            public List<Integer> getSgeoList() {
                                return this.f10135g;
                            }

                            public String getStartTime() {
                                return this.f10132d;
                            }

                            public boolean hasGeo() {
                                return this.f10133e;
                            }

                            public boolean hasName() {
                                return this.f10129a;
                            }

                            public boolean hasStartTime() {
                                return this.f10131c;
                            }

                            public final boolean isInitialized() {
                                return true;
                            }

                            public Linestations mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                                while (true) {
                                    int readTag = codedInputStreamMicro.readTag();
                                    switch (readTag) {
                                        case 0:
                                            break;
                                        case 10:
                                            setName(codedInputStreamMicro.readString());
                                            continue;
                                        case 18:
                                            setStartTime(codedInputStreamMicro.readString());
                                            continue;
                                        case 26:
                                            setGeo(codedInputStreamMicro.readString());
                                            continue;
                                        case 32:
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

                            public Linestations setGeo(String str) {
                                this.f10133e = true;
                                this.f10134f = str;
                                return this;
                            }

                            public Linestations setName(String str) {
                                this.f10129a = true;
                                this.f10130b = str;
                                return this;
                            }

                            public Linestations setSgeo(int i, int i2) {
                                this.f10135g.set(i, Integer.valueOf(i2));
                                return this;
                            }

                            public Linestations setStartTime(String str) {
                                this.f10131c = true;
                                this.f10132d = str;
                                return this;
                            }

                            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                                if (hasName()) {
                                    codedOutputStreamMicro.writeString(1, getName());
                                }
                                if (hasStartTime()) {
                                    codedOutputStreamMicro.writeString(2, getStartTime());
                                }
                                if (hasGeo()) {
                                    codedOutputStreamMicro.writeString(3, getGeo());
                                }
                                for (Integer intValue : getSgeoList()) {
                                    codedOutputStreamMicro.writeSInt32(4, intValue.intValue());
                                }
                            }
                        }

                        public static final class NextBusInfo extends MessageMicro {
                            public static final int REMAIN_DIS_FIELD_NUMBER = 2;
                            public static final int REMAIN_STOPS_FIELD_NUMBER = 3;
                            public static final int REMAIN_TIME_FIELD_NUMBER = 1;
                            public static final int SPATH_FIELD_NUMBER = 6;
                            public static final int X_FIELD_NUMBER = 4;
                            public static final int Y_FIELD_NUMBER = 5;
                            /* renamed from: a */
                            private boolean f10137a;
                            /* renamed from: b */
                            private int f10138b = 0;
                            /* renamed from: c */
                            private boolean f10139c;
                            /* renamed from: d */
                            private int f10140d = 0;
                            /* renamed from: e */
                            private boolean f10141e;
                            /* renamed from: f */
                            private int f10142f = 0;
                            /* renamed from: g */
                            private boolean f10143g;
                            /* renamed from: h */
                            private int f10144h = 0;
                            /* renamed from: i */
                            private boolean f10145i;
                            /* renamed from: j */
                            private int f10146j = 0;
                            /* renamed from: k */
                            private List<Integer> f10147k = Collections.emptyList();
                            /* renamed from: l */
                            private int f10148l = -1;

                            public static NextBusInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                                return new NextBusInfo().mergeFrom(codedInputStreamMicro);
                            }

                            public static NextBusInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                                return (NextBusInfo) new NextBusInfo().mergeFrom(bArr);
                            }

                            public NextBusInfo addSpath(int i) {
                                if (this.f10147k.isEmpty()) {
                                    this.f10147k = new ArrayList();
                                }
                                this.f10147k.add(Integer.valueOf(i));
                                return this;
                            }

                            public final NextBusInfo clear() {
                                clearRemainTime();
                                clearRemainDis();
                                clearRemainStops();
                                clearX();
                                clearY();
                                clearSpath();
                                this.f10148l = -1;
                                return this;
                            }

                            public NextBusInfo clearRemainDis() {
                                this.f10139c = false;
                                this.f10140d = 0;
                                return this;
                            }

                            public NextBusInfo clearRemainStops() {
                                this.f10141e = false;
                                this.f10142f = 0;
                                return this;
                            }

                            public NextBusInfo clearRemainTime() {
                                this.f10137a = false;
                                this.f10138b = 0;
                                return this;
                            }

                            public NextBusInfo clearSpath() {
                                this.f10147k = Collections.emptyList();
                                return this;
                            }

                            public NextBusInfo clearX() {
                                this.f10143g = false;
                                this.f10144h = 0;
                                return this;
                            }

                            public NextBusInfo clearY() {
                                this.f10145i = false;
                                this.f10146j = 0;
                                return this;
                            }

                            public int getCachedSize() {
                                if (this.f10148l < 0) {
                                    getSerializedSize();
                                }
                                return this.f10148l;
                            }

                            public int getRemainDis() {
                                return this.f10140d;
                            }

                            public int getRemainStops() {
                                return this.f10142f;
                            }

                            public int getRemainTime() {
                                return this.f10138b;
                            }

                            public int getSerializedSize() {
                                int i = 0;
                                int computeInt32Size = hasRemainTime() ? CodedOutputStreamMicro.computeInt32Size(1, getRemainTime()) + 0 : 0;
                                if (hasRemainDis()) {
                                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getRemainDis());
                                }
                                if (hasRemainStops()) {
                                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getRemainStops());
                                }
                                if (hasX()) {
                                    computeInt32Size += CodedOutputStreamMicro.computeSInt32Size(4, getX());
                                }
                                int computeSInt32Size = hasY() ? computeInt32Size + CodedOutputStreamMicro.computeSInt32Size(5, getY()) : computeInt32Size;
                                for (Integer intValue : getSpathList()) {
                                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue());
                                }
                                computeInt32Size = (computeSInt32Size + i) + (getSpathList().size() * 1);
                                this.f10148l = computeInt32Size;
                                return computeInt32Size;
                            }

                            public int getSpath(int i) {
                                return ((Integer) this.f10147k.get(i)).intValue();
                            }

                            public int getSpathCount() {
                                return this.f10147k.size();
                            }

                            public List<Integer> getSpathList() {
                                return this.f10147k;
                            }

                            public int getX() {
                                return this.f10144h;
                            }

                            public int getY() {
                                return this.f10146j;
                            }

                            public boolean hasRemainDis() {
                                return this.f10139c;
                            }

                            public boolean hasRemainStops() {
                                return this.f10141e;
                            }

                            public boolean hasRemainTime() {
                                return this.f10137a;
                            }

                            public boolean hasX() {
                                return this.f10143g;
                            }

                            public boolean hasY() {
                                return this.f10145i;
                            }

                            public final boolean isInitialized() {
                                return true;
                            }

                            public NextBusInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                                while (true) {
                                    int readTag = codedInputStreamMicro.readTag();
                                    switch (readTag) {
                                        case 0:
                                            break;
                                        case 8:
                                            setRemainTime(codedInputStreamMicro.readInt32());
                                            continue;
                                        case 16:
                                            setRemainDis(codedInputStreamMicro.readInt32());
                                            continue;
                                        case 24:
                                            setRemainStops(codedInputStreamMicro.readInt32());
                                            continue;
                                        case 32:
                                            setX(codedInputStreamMicro.readSInt32());
                                            continue;
                                        case 40:
                                            setY(codedInputStreamMicro.readSInt32());
                                            continue;
                                        case 48:
                                            addSpath(codedInputStreamMicro.readSInt32());
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

                            public NextBusInfo setRemainDis(int i) {
                                this.f10139c = true;
                                this.f10140d = i;
                                return this;
                            }

                            public NextBusInfo setRemainStops(int i) {
                                this.f10141e = true;
                                this.f10142f = i;
                                return this;
                            }

                            public NextBusInfo setRemainTime(int i) {
                                this.f10137a = true;
                                this.f10138b = i;
                                return this;
                            }

                            public NextBusInfo setSpath(int i, int i2) {
                                this.f10147k.set(i, Integer.valueOf(i2));
                                return this;
                            }

                            public NextBusInfo setX(int i) {
                                this.f10143g = true;
                                this.f10144h = i;
                                return this;
                            }

                            public NextBusInfo setY(int i) {
                                this.f10145i = true;
                                this.f10146j = i;
                                return this;
                            }

                            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                                if (hasRemainTime()) {
                                    codedOutputStreamMicro.writeInt32(1, getRemainTime());
                                }
                                if (hasRemainDis()) {
                                    codedOutputStreamMicro.writeInt32(2, getRemainDis());
                                }
                                if (hasRemainStops()) {
                                    codedOutputStreamMicro.writeInt32(3, getRemainStops());
                                }
                                if (hasX()) {
                                    codedOutputStreamMicro.writeSInt32(4, getX());
                                }
                                if (hasY()) {
                                    codedOutputStreamMicro.writeSInt32(5, getY());
                                }
                                for (Integer intValue : getSpathList()) {
                                    codedOutputStreamMicro.writeSInt32(6, intValue.intValue());
                                }
                            }
                        }

                        public static Vehicle parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new Vehicle().mergeFrom(codedInputStreamMicro);
                        }

                        public static Vehicle parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (Vehicle) new Vehicle().mergeFrom(bArr);
                        }

                        public Vehicle addLinestations(Linestations linestations) {
                            if (linestations != null) {
                                if (this.f10177c.isEmpty()) {
                                    this.f10177c = new ArrayList();
                                }
                                this.f10177c.add(linestations);
                            }
                            return this;
                        }

                        public final Vehicle clear() {
                            clearNextBusInfo();
                            clearLinestations();
                            clearName();
                            clearType();
                            clearUid();
                            clearStartTime();
                            clearEndTime();
                            clearStartUid();
                            clearEndName();
                            clearStopNum();
                            clearTotalPrice();
                            clearZonePrice();
                            clearArealines();
                            clearDate();
                            clearDiscount();
                            clearPrice();
                            clearCp();
                            clearLineType();
                            clearStartWd();
                            clearEndCityUid();
                            clearTelnum();
                            clearOrderUrl();
                            clearStartName();
                            clearEndUid();
                            clearEndStationType();
                            clearProviderName();
                            clearProviderUrl();
                            clearStartCityName();
                            clearIsSupportTicket();
                            clearTicketUrl();
                            clearLineColor();
                            clearHeadway();
                            clearIsRtbus();
                            clearEndCityName();
                            this.ap = -1;
                            return this;
                        }

                        public Vehicle clearArealines() {
                            this.f10198x = false;
                            this.f10199y = "";
                            return this;
                        }

                        public Vehicle clearCp() {
                            this.f10154F = false;
                            this.f10155G = "";
                            return this;
                        }

                        public Vehicle clearDate() {
                            this.f10200z = false;
                            this.f10149A = "";
                            return this;
                        }

                        public Vehicle clearDiscount() {
                            this.f10150B = false;
                            this.f10151C = "";
                            return this;
                        }

                        public Vehicle clearEndCityName() {
                            this.an = false;
                            this.ao = "";
                            return this;
                        }

                        public Vehicle clearEndCityUid() {
                            this.f10160L = false;
                            this.f10161M = "";
                            return this;
                        }

                        public Vehicle clearEndName() {
                            this.f10190p = false;
                            this.f10191q = "";
                            return this;
                        }

                        public Vehicle clearEndStationType() {
                            this.f10170V = false;
                            this.f10171W = 0;
                            return this;
                        }

                        public Vehicle clearEndTime() {
                            this.f10186l = false;
                            this.f10187m = "";
                            return this;
                        }

                        public Vehicle clearEndUid() {
                            this.f10168T = false;
                            this.f10169U = "";
                            return this;
                        }

                        public Vehicle clearHeadway() {
                            this.aj = false;
                            this.ak = "";
                            return this;
                        }

                        public Vehicle clearIsRtbus() {
                            this.al = false;
                            this.am = 0;
                            return this;
                        }

                        public Vehicle clearIsSupportTicket() {
                            this.ad = false;
                            this.ae = 0;
                            return this;
                        }

                        public Vehicle clearLineColor() {
                            this.ah = false;
                            this.ai = "";
                            return this;
                        }

                        public Vehicle clearLineType() {
                            this.f10156H = false;
                            this.f10157I = 0;
                            return this;
                        }

                        public Vehicle clearLinestations() {
                            this.f10177c = Collections.emptyList();
                            return this;
                        }

                        public Vehicle clearName() {
                            this.f10178d = false;
                            this.f10179e = "";
                            return this;
                        }

                        public Vehicle clearNextBusInfo() {
                            this.f10175a = false;
                            this.f10176b = null;
                            return this;
                        }

                        public Vehicle clearOrderUrl() {
                            this.f10164P = false;
                            this.f10165Q = "";
                            return this;
                        }

                        public Vehicle clearPrice() {
                            this.f10152D = false;
                            this.f10153E = "";
                            return this;
                        }

                        public Vehicle clearProviderName() {
                            this.f10172X = false;
                            this.f10173Y = "";
                            return this;
                        }

                        public Vehicle clearProviderUrl() {
                            this.f10174Z = false;
                            this.aa = "";
                            return this;
                        }

                        public Vehicle clearStartCityName() {
                            this.ab = false;
                            this.ac = "";
                            return this;
                        }

                        public Vehicle clearStartName() {
                            this.f10166R = false;
                            this.f10167S = "";
                            return this;
                        }

                        public Vehicle clearStartTime() {
                            this.f10184j = false;
                            this.f10185k = "";
                            return this;
                        }

                        public Vehicle clearStartUid() {
                            this.f10188n = false;
                            this.f10189o = "";
                            return this;
                        }

                        public Vehicle clearStartWd() {
                            this.f10158J = false;
                            this.f10159K = "";
                            return this;
                        }

                        public Vehicle clearStopNum() {
                            this.f10192r = false;
                            this.f10193s = 0;
                            return this;
                        }

                        public Vehicle clearTelnum() {
                            this.f10162N = false;
                            this.f10163O = "";
                            return this;
                        }

                        public Vehicle clearTicketUrl() {
                            this.af = false;
                            this.ag = "";
                            return this;
                        }

                        public Vehicle clearTotalPrice() {
                            this.f10194t = false;
                            this.f10195u = 0;
                            return this;
                        }

                        public Vehicle clearType() {
                            this.f10180f = false;
                            this.f10181g = 0;
                            return this;
                        }

                        public Vehicle clearUid() {
                            this.f10182h = false;
                            this.f10183i = "";
                            return this;
                        }

                        public Vehicle clearZonePrice() {
                            this.f10196v = false;
                            this.f10197w = 0;
                            return this;
                        }

                        public String getArealines() {
                            return this.f10199y;
                        }

                        public int getCachedSize() {
                            if (this.ap < 0) {
                                getSerializedSize();
                            }
                            return this.ap;
                        }

                        public String getCp() {
                            return this.f10155G;
                        }

                        public String getDate() {
                            return this.f10149A;
                        }

                        public String getDiscount() {
                            return this.f10151C;
                        }

                        public String getEndCityName() {
                            return this.ao;
                        }

                        public String getEndCityUid() {
                            return this.f10161M;
                        }

                        public String getEndName() {
                            return this.f10191q;
                        }

                        public int getEndStationType() {
                            return this.f10171W;
                        }

                        public String getEndTime() {
                            return this.f10187m;
                        }

                        public String getEndUid() {
                            return this.f10169U;
                        }

                        public String getHeadway() {
                            return this.ak;
                        }

                        public int getIsRtbus() {
                            return this.am;
                        }

                        public int getIsSupportTicket() {
                            return this.ae;
                        }

                        public String getLineColor() {
                            return this.ai;
                        }

                        public int getLineType() {
                            return this.f10157I;
                        }

                        public Linestations getLinestations(int i) {
                            return (Linestations) this.f10177c.get(i);
                        }

                        public int getLinestationsCount() {
                            return this.f10177c.size();
                        }

                        public List<Linestations> getLinestationsList() {
                            return this.f10177c;
                        }

                        public String getName() {
                            return this.f10179e;
                        }

                        public NextBusInfo getNextBusInfo() {
                            return this.f10176b;
                        }

                        public String getOrderUrl() {
                            return this.f10165Q;
                        }

                        public String getPrice() {
                            return this.f10153E;
                        }

                        public String getProviderName() {
                            return this.f10173Y;
                        }

                        public String getProviderUrl() {
                            return this.aa;
                        }

                        public int getSerializedSize() {
                            int i = 0;
                            if (hasName()) {
                                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
                            }
                            if (hasType()) {
                                i += CodedOutputStreamMicro.computeInt32Size(2, getType());
                            }
                            if (hasUid()) {
                                i += CodedOutputStreamMicro.computeStringSize(3, getUid());
                            }
                            if (hasStartTime()) {
                                i += CodedOutputStreamMicro.computeStringSize(4, getStartTime());
                            }
                            if (hasEndTime()) {
                                i += CodedOutputStreamMicro.computeStringSize(5, getEndTime());
                            }
                            if (hasStartUid()) {
                                i += CodedOutputStreamMicro.computeStringSize(6, getStartUid());
                            }
                            if (hasEndName()) {
                                i += CodedOutputStreamMicro.computeStringSize(7, getEndName());
                            }
                            if (hasStopNum()) {
                                i += CodedOutputStreamMicro.computeInt32Size(8, getStopNum());
                            }
                            if (hasTotalPrice()) {
                                i += CodedOutputStreamMicro.computeInt32Size(9, getTotalPrice());
                            }
                            if (hasZonePrice()) {
                                i += CodedOutputStreamMicro.computeInt32Size(10, getZonePrice());
                            }
                            if (hasNextBusInfo()) {
                                i += CodedOutputStreamMicro.computeMessageSize(11, getNextBusInfo());
                            }
                            if (hasArealines()) {
                                i += CodedOutputStreamMicro.computeStringSize(12, getArealines());
                            }
                            if (hasDate()) {
                                i += CodedOutputStreamMicro.computeStringSize(13, getDate());
                            }
                            if (hasDiscount()) {
                                i += CodedOutputStreamMicro.computeStringSize(14, getDiscount());
                            }
                            if (hasPrice()) {
                                i += CodedOutputStreamMicro.computeStringSize(15, getPrice());
                            }
                            if (hasCp()) {
                                i += CodedOutputStreamMicro.computeStringSize(16, getCp());
                            }
                            if (hasLineType()) {
                                i += CodedOutputStreamMicro.computeInt32Size(17, getLineType());
                            }
                            if (hasStartWd()) {
                                i += CodedOutputStreamMicro.computeStringSize(18, getStartWd());
                            }
                            if (hasEndCityUid()) {
                                i += CodedOutputStreamMicro.computeStringSize(19, getEndCityUid());
                            }
                            int i2 = i;
                            for (Linestations computeMessageSize : getLinestationsList()) {
                                i2 = CodedOutputStreamMicro.computeMessageSize(20, computeMessageSize) + i2;
                            }
                            if (hasTelnum()) {
                                i2 += CodedOutputStreamMicro.computeStringSize(21, getTelnum());
                            }
                            if (hasOrderUrl()) {
                                i2 += CodedOutputStreamMicro.computeStringSize(22, getOrderUrl());
                            }
                            if (hasStartName()) {
                                i2 += CodedOutputStreamMicro.computeStringSize(23, getStartName());
                            }
                            if (hasEndUid()) {
                                i2 += CodedOutputStreamMicro.computeStringSize(24, getEndUid());
                            }
                            if (hasEndStationType()) {
                                i2 += CodedOutputStreamMicro.computeInt32Size(25, getEndStationType());
                            }
                            if (hasProviderName()) {
                                i2 += CodedOutputStreamMicro.computeStringSize(26, getProviderName());
                            }
                            if (hasProviderUrl()) {
                                i2 += CodedOutputStreamMicro.computeStringSize(27, getProviderUrl());
                            }
                            if (hasStartCityName()) {
                                i2 += CodedOutputStreamMicro.computeStringSize(28, getStartCityName());
                            }
                            if (hasIsSupportTicket()) {
                                i2 += CodedOutputStreamMicro.computeInt32Size(29, getIsSupportTicket());
                            }
                            if (hasTicketUrl()) {
                                i2 += CodedOutputStreamMicro.computeStringSize(31, getTicketUrl());
                            }
                            if (hasLineColor()) {
                                i2 += CodedOutputStreamMicro.computeStringSize(32, getLineColor());
                            }
                            if (hasHeadway()) {
                                i2 += CodedOutputStreamMicro.computeStringSize(33, getHeadway());
                            }
                            if (hasIsRtbus()) {
                                i2 += CodedOutputStreamMicro.computeInt32Size(34, getIsRtbus());
                            }
                            if (hasEndCityName()) {
                                i2 += CodedOutputStreamMicro.computeStringSize(35, getEndCityName());
                            }
                            this.ap = i2;
                            return i2;
                        }

                        public String getStartCityName() {
                            return this.ac;
                        }

                        public String getStartName() {
                            return this.f10167S;
                        }

                        public String getStartTime() {
                            return this.f10185k;
                        }

                        public String getStartUid() {
                            return this.f10189o;
                        }

                        public String getStartWd() {
                            return this.f10159K;
                        }

                        public int getStopNum() {
                            return this.f10193s;
                        }

                        public String getTelnum() {
                            return this.f10163O;
                        }

                        public String getTicketUrl() {
                            return this.ag;
                        }

                        public int getTotalPrice() {
                            return this.f10195u;
                        }

                        public int getType() {
                            return this.f10181g;
                        }

                        public String getUid() {
                            return this.f10183i;
                        }

                        public int getZonePrice() {
                            return this.f10197w;
                        }

                        public boolean hasArealines() {
                            return this.f10198x;
                        }

                        public boolean hasCp() {
                            return this.f10154F;
                        }

                        public boolean hasDate() {
                            return this.f10200z;
                        }

                        public boolean hasDiscount() {
                            return this.f10150B;
                        }

                        public boolean hasEndCityName() {
                            return this.an;
                        }

                        public boolean hasEndCityUid() {
                            return this.f10160L;
                        }

                        public boolean hasEndName() {
                            return this.f10190p;
                        }

                        public boolean hasEndStationType() {
                            return this.f10170V;
                        }

                        public boolean hasEndTime() {
                            return this.f10186l;
                        }

                        public boolean hasEndUid() {
                            return this.f10168T;
                        }

                        public boolean hasHeadway() {
                            return this.aj;
                        }

                        public boolean hasIsRtbus() {
                            return this.al;
                        }

                        public boolean hasIsSupportTicket() {
                            return this.ad;
                        }

                        public boolean hasLineColor() {
                            return this.ah;
                        }

                        public boolean hasLineType() {
                            return this.f10156H;
                        }

                        public boolean hasName() {
                            return this.f10178d;
                        }

                        public boolean hasNextBusInfo() {
                            return this.f10175a;
                        }

                        public boolean hasOrderUrl() {
                            return this.f10164P;
                        }

                        public boolean hasPrice() {
                            return this.f10152D;
                        }

                        public boolean hasProviderName() {
                            return this.f10172X;
                        }

                        public boolean hasProviderUrl() {
                            return this.f10174Z;
                        }

                        public boolean hasStartCityName() {
                            return this.ab;
                        }

                        public boolean hasStartName() {
                            return this.f10166R;
                        }

                        public boolean hasStartTime() {
                            return this.f10184j;
                        }

                        public boolean hasStartUid() {
                            return this.f10188n;
                        }

                        public boolean hasStartWd() {
                            return this.f10158J;
                        }

                        public boolean hasStopNum() {
                            return this.f10192r;
                        }

                        public boolean hasTelnum() {
                            return this.f10162N;
                        }

                        public boolean hasTicketUrl() {
                            return this.af;
                        }

                        public boolean hasTotalPrice() {
                            return this.f10194t;
                        }

                        public boolean hasType() {
                            return this.f10180f;
                        }

                        public boolean hasUid() {
                            return this.f10182h;
                        }

                        public boolean hasZonePrice() {
                            return this.f10196v;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public Vehicle mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                MessageMicro nextBusInfo;
                                switch (readTag) {
                                    case 0:
                                        break;
                                    case 10:
                                        setName(codedInputStreamMicro.readString());
                                        continue;
                                    case 16:
                                        setType(codedInputStreamMicro.readInt32());
                                        continue;
                                    case 26:
                                        setUid(codedInputStreamMicro.readString());
                                        continue;
                                    case 34:
                                        setStartTime(codedInputStreamMicro.readString());
                                        continue;
                                    case 42:
                                        setEndTime(codedInputStreamMicro.readString());
                                        continue;
                                    case 50:
                                        setStartUid(codedInputStreamMicro.readString());
                                        continue;
                                    case 58:
                                        setEndName(codedInputStreamMicro.readString());
                                        continue;
                                    case 64:
                                        setStopNum(codedInputStreamMicro.readInt32());
                                        continue;
                                    case NavCarInfo.CarType_57L /*72*/:
                                        setTotalPrice(codedInputStreamMicro.readInt32());
                                        continue;
                                    case 80:
                                        setZonePrice(codedInputStreamMicro.readInt32());
                                        continue;
                                    case 90:
                                        nextBusInfo = new NextBusInfo();
                                        codedInputStreamMicro.readMessage(nextBusInfo);
                                        setNextBusInfo(nextBusInfo);
                                        continue;
                                    case 98:
                                        setArealines(codedInputStreamMicro.readString());
                                        continue;
                                    case 106:
                                        setDate(codedInputStreamMicro.readString());
                                        continue;
                                    case 114:
                                        setDiscount(codedInputStreamMicro.readString());
                                        continue;
                                    case C1253f.df /*122*/:
                                        setPrice(codedInputStreamMicro.readString());
                                        continue;
                                    case 130:
                                        setCp(codedInputStreamMicro.readString());
                                        continue;
                                    case RouteLineResConst.LINE_DARK_RED_NORMAL /*136*/:
                                        setLineType(codedInputStreamMicro.readInt32());
                                        continue;
                                    case 146:
                                        setStartWd(codedInputStreamMicro.readString());
                                        continue;
                                    case 154:
                                        setEndCityUid(codedInputStreamMicro.readString());
                                        continue;
                                    case 162:
                                        nextBusInfo = new Linestations();
                                        codedInputStreamMicro.readMessage(nextBusInfo);
                                        addLinestations(nextBusInfo);
                                        continue;
                                    case 170:
                                        setTelnum(codedInputStreamMicro.readString());
                                        continue;
                                    case 178:
                                        setOrderUrl(codedInputStreamMicro.readString());
                                        continue;
                                    case 186:
                                        setStartName(codedInputStreamMicro.readString());
                                        continue;
                                    case RouteLineResConst.LINE_INTERNAL_NORMAL /*194*/:
                                        setEndUid(codedInputStreamMicro.readString());
                                        continue;
                                    case 200:
                                        setEndStationType(codedInputStreamMicro.readInt32());
                                        continue;
                                    case C1253f.ds /*210*/:
                                        setProviderName(codedInputStreamMicro.readString());
                                        continue;
                                    case 218:
                                        setProviderUrl(codedInputStreamMicro.readString());
                                        continue;
                                    case C1253f.dG /*226*/:
                                        setStartCityName(codedInputStreamMicro.readString());
                                        continue;
                                    case NaviCmdConstants.ACTION_TYPE_NAVI_MODE_DAY /*232*/:
                                        setIsSupportTicket(codedInputStreamMicro.readInt32());
                                        continue;
                                    case 250:
                                        setTicketUrl(codedInputStreamMicro.readString());
                                        continue;
                                    case 258:
                                        setLineColor(codedInputStreamMicro.readString());
                                        continue;
                                    case BNOfflineDataObserver.EVENT_UPDATE_PROGRESS /*266*/:
                                        setHeadway(codedInputStreamMicro.readString());
                                        continue;
                                    case 272:
                                        setIsRtbus(codedInputStreamMicro.readInt32());
                                        continue;
                                    case 282:
                                        setEndCityName(codedInputStreamMicro.readString());
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

                        public Vehicle setArealines(String str) {
                            this.f10198x = true;
                            this.f10199y = str;
                            return this;
                        }

                        public Vehicle setCp(String str) {
                            this.f10154F = true;
                            this.f10155G = str;
                            return this;
                        }

                        public Vehicle setDate(String str) {
                            this.f10200z = true;
                            this.f10149A = str;
                            return this;
                        }

                        public Vehicle setDiscount(String str) {
                            this.f10150B = true;
                            this.f10151C = str;
                            return this;
                        }

                        public Vehicle setEndCityName(String str) {
                            this.an = true;
                            this.ao = str;
                            return this;
                        }

                        public Vehicle setEndCityUid(String str) {
                            this.f10160L = true;
                            this.f10161M = str;
                            return this;
                        }

                        public Vehicle setEndName(String str) {
                            this.f10190p = true;
                            this.f10191q = str;
                            return this;
                        }

                        public Vehicle setEndStationType(int i) {
                            this.f10170V = true;
                            this.f10171W = i;
                            return this;
                        }

                        public Vehicle setEndTime(String str) {
                            this.f10186l = true;
                            this.f10187m = str;
                            return this;
                        }

                        public Vehicle setEndUid(String str) {
                            this.f10168T = true;
                            this.f10169U = str;
                            return this;
                        }

                        public Vehicle setHeadway(String str) {
                            this.aj = true;
                            this.ak = str;
                            return this;
                        }

                        public Vehicle setIsRtbus(int i) {
                            this.al = true;
                            this.am = i;
                            return this;
                        }

                        public Vehicle setIsSupportTicket(int i) {
                            this.ad = true;
                            this.ae = i;
                            return this;
                        }

                        public Vehicle setLineColor(String str) {
                            this.ah = true;
                            this.ai = str;
                            return this;
                        }

                        public Vehicle setLineType(int i) {
                            this.f10156H = true;
                            this.f10157I = i;
                            return this;
                        }

                        public Vehicle setLinestations(int i, Linestations linestations) {
                            if (linestations != null) {
                                this.f10177c.set(i, linestations);
                            }
                            return this;
                        }

                        public Vehicle setName(String str) {
                            this.f10178d = true;
                            this.f10179e = str;
                            return this;
                        }

                        public Vehicle setNextBusInfo(NextBusInfo nextBusInfo) {
                            if (nextBusInfo == null) {
                                return clearNextBusInfo();
                            }
                            this.f10175a = true;
                            this.f10176b = nextBusInfo;
                            return this;
                        }

                        public Vehicle setOrderUrl(String str) {
                            this.f10164P = true;
                            this.f10165Q = str;
                            return this;
                        }

                        public Vehicle setPrice(String str) {
                            this.f10152D = true;
                            this.f10153E = str;
                            return this;
                        }

                        public Vehicle setProviderName(String str) {
                            this.f10172X = true;
                            this.f10173Y = str;
                            return this;
                        }

                        public Vehicle setProviderUrl(String str) {
                            this.f10174Z = true;
                            this.aa = str;
                            return this;
                        }

                        public Vehicle setStartCityName(String str) {
                            this.ab = true;
                            this.ac = str;
                            return this;
                        }

                        public Vehicle setStartName(String str) {
                            this.f10166R = true;
                            this.f10167S = str;
                            return this;
                        }

                        public Vehicle setStartTime(String str) {
                            this.f10184j = true;
                            this.f10185k = str;
                            return this;
                        }

                        public Vehicle setStartUid(String str) {
                            this.f10188n = true;
                            this.f10189o = str;
                            return this;
                        }

                        public Vehicle setStartWd(String str) {
                            this.f10158J = true;
                            this.f10159K = str;
                            return this;
                        }

                        public Vehicle setStopNum(int i) {
                            this.f10192r = true;
                            this.f10193s = i;
                            return this;
                        }

                        public Vehicle setTelnum(String str) {
                            this.f10162N = true;
                            this.f10163O = str;
                            return this;
                        }

                        public Vehicle setTicketUrl(String str) {
                            this.af = true;
                            this.ag = str;
                            return this;
                        }

                        public Vehicle setTotalPrice(int i) {
                            this.f10194t = true;
                            this.f10195u = i;
                            return this;
                        }

                        public Vehicle setType(int i) {
                            this.f10180f = true;
                            this.f10181g = i;
                            return this;
                        }

                        public Vehicle setUid(String str) {
                            this.f10182h = true;
                            this.f10183i = str;
                            return this;
                        }

                        public Vehicle setZonePrice(int i) {
                            this.f10196v = true;
                            this.f10197w = i;
                            return this;
                        }

                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasName()) {
                                codedOutputStreamMicro.writeString(1, getName());
                            }
                            if (hasType()) {
                                codedOutputStreamMicro.writeInt32(2, getType());
                            }
                            if (hasUid()) {
                                codedOutputStreamMicro.writeString(3, getUid());
                            }
                            if (hasStartTime()) {
                                codedOutputStreamMicro.writeString(4, getStartTime());
                            }
                            if (hasEndTime()) {
                                codedOutputStreamMicro.writeString(5, getEndTime());
                            }
                            if (hasStartUid()) {
                                codedOutputStreamMicro.writeString(6, getStartUid());
                            }
                            if (hasEndName()) {
                                codedOutputStreamMicro.writeString(7, getEndName());
                            }
                            if (hasStopNum()) {
                                codedOutputStreamMicro.writeInt32(8, getStopNum());
                            }
                            if (hasTotalPrice()) {
                                codedOutputStreamMicro.writeInt32(9, getTotalPrice());
                            }
                            if (hasZonePrice()) {
                                codedOutputStreamMicro.writeInt32(10, getZonePrice());
                            }
                            if (hasNextBusInfo()) {
                                codedOutputStreamMicro.writeMessage(11, getNextBusInfo());
                            }
                            if (hasArealines()) {
                                codedOutputStreamMicro.writeString(12, getArealines());
                            }
                            if (hasDate()) {
                                codedOutputStreamMicro.writeString(13, getDate());
                            }
                            if (hasDiscount()) {
                                codedOutputStreamMicro.writeString(14, getDiscount());
                            }
                            if (hasPrice()) {
                                codedOutputStreamMicro.writeString(15, getPrice());
                            }
                            if (hasCp()) {
                                codedOutputStreamMicro.writeString(16, getCp());
                            }
                            if (hasLineType()) {
                                codedOutputStreamMicro.writeInt32(17, getLineType());
                            }
                            if (hasStartWd()) {
                                codedOutputStreamMicro.writeString(18, getStartWd());
                            }
                            if (hasEndCityUid()) {
                                codedOutputStreamMicro.writeString(19, getEndCityUid());
                            }
                            for (Linestations writeMessage : getLinestationsList()) {
                                codedOutputStreamMicro.writeMessage(20, writeMessage);
                            }
                            if (hasTelnum()) {
                                codedOutputStreamMicro.writeString(21, getTelnum());
                            }
                            if (hasOrderUrl()) {
                                codedOutputStreamMicro.writeString(22, getOrderUrl());
                            }
                            if (hasStartName()) {
                                codedOutputStreamMicro.writeString(23, getStartName());
                            }
                            if (hasEndUid()) {
                                codedOutputStreamMicro.writeString(24, getEndUid());
                            }
                            if (hasEndStationType()) {
                                codedOutputStreamMicro.writeInt32(25, getEndStationType());
                            }
                            if (hasProviderName()) {
                                codedOutputStreamMicro.writeString(26, getProviderName());
                            }
                            if (hasProviderUrl()) {
                                codedOutputStreamMicro.writeString(27, getProviderUrl());
                            }
                            if (hasStartCityName()) {
                                codedOutputStreamMicro.writeString(28, getStartCityName());
                            }
                            if (hasIsSupportTicket()) {
                                codedOutputStreamMicro.writeInt32(29, getIsSupportTicket());
                            }
                            if (hasTicketUrl()) {
                                codedOutputStreamMicro.writeString(31, getTicketUrl());
                            }
                            if (hasLineColor()) {
                                codedOutputStreamMicro.writeString(32, getLineColor());
                            }
                            if (hasHeadway()) {
                                codedOutputStreamMicro.writeString(33, getHeadway());
                            }
                            if (hasIsRtbus()) {
                                codedOutputStreamMicro.writeInt32(34, getIsRtbus());
                            }
                            if (hasEndCityName()) {
                                codedOutputStreamMicro.writeString(35, getEndCityName());
                            }
                        }
                    }

                    public static Step parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Step().mergeFrom(codedInputStreamMicro);
                    }

                    public static Step parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Step) new Step().mergeFrom(bArr);
                    }

                    public Step addLineStops(String str) {
                        if (str == null) {
                            throw new NullPointerException();
                        }
                        if (this.f10215O.isEmpty()) {
                            this.f10215O = new ArrayList();
                        }
                        this.f10215O.add(str);
                        return this;
                    }

                    public Step addLinkColor(LinkColor linkColor) {
                        if (linkColor != null) {
                            if (this.f10233g.isEmpty()) {
                                this.f10233g = new ArrayList();
                            }
                            this.f10233g.add(linkColor);
                        }
                        return this;
                    }

                    public Step addLowerSteps(LowerSteps lowerSteps) {
                        if (lowerSteps != null) {
                            if (this.f10231e.isEmpty()) {
                                this.f10231e = new ArrayList();
                            }
                            this.f10231e.add(lowerSteps);
                        }
                        return this;
                    }

                    public Step addPois(Pois pois) {
                        if (pois != null) {
                            if (this.f10232f.isEmpty()) {
                                this.f10232f = new ArrayList();
                            }
                            this.f10232f.add(pois);
                        }
                        return this;
                    }

                    public Step addSendLocation(int i) {
                        if (this.f10212L.isEmpty()) {
                            this.f10212L = new ArrayList();
                        }
                        this.f10212L.add(Integer.valueOf(i));
                        return this;
                    }

                    public Step addSpath(int i) {
                        if (this.f10214N.isEmpty()) {
                            this.f10214N = new ArrayList();
                        }
                        this.f10214N.add(Integer.valueOf(i));
                        return this;
                    }

                    public Step addSstartLocation(int i) {
                        if (this.f10213M.isEmpty()) {
                            this.f10213M = new ArrayList();
                        }
                        this.f10213M.add(Integer.valueOf(i));
                        return this;
                    }

                    public Step addStopsPos(StopsPos stopsPos) {
                        if (stopsPos != null) {
                            if (this.f10218R.isEmpty()) {
                                this.f10218R = new ArrayList();
                            }
                            this.f10218R.add(stopsPos);
                        }
                        return this;
                    }

                    public final Step clear() {
                        clearDictInstruction();
                        clearVehicle();
                        clearLowerSteps();
                        clearPois();
                        clearLinkColor();
                        clearDistance();
                        clearDuration();
                        clearEndLocation();
                        clearStartLocation();
                        clearInstructions();
                        clearPath();
                        clearType();
                        clearTip();
                        clearTipText();
                        clearTipBackground();
                        clearOrderUrl();
                        clearStartInstructions();
                        clearEndInstructions();
                        clearStartAddress();
                        clearEndAddress();
                        clearSendLocation();
                        clearSstartLocation();
                        clearSpath();
                        clearLineStops();
                        clearStepPano();
                        clearStopsPos();
                        clearComfort();
                        clearPrice();
                        clearRemain();
                        clearTicket();
                        clearStartAddressShort();
                        clearEndAddressShort();
                        clearIsDepot();
                        clearTransferDict();
                        clearCanRide();
                        this.ak = -1;
                        return this;
                    }

                    public Step clearCanRide() {
                        this.ai = false;
                        this.aj = 0;
                        return this;
                    }

                    public Step clearComfort() {
                        this.f10219S = false;
                        this.f10220T = "";
                        return this;
                    }

                    public Step clearDictInstruction() {
                        this.f10227a = false;
                        this.f10228b = null;
                        return this;
                    }

                    public Step clearDistance() {
                        this.f10234h = false;
                        this.f10235i = 0;
                        return this;
                    }

                    public Step clearDuration() {
                        this.f10236j = false;
                        this.f10237k = 0;
                        return this;
                    }

                    public Step clearEndAddress() {
                        this.f10210J = false;
                        this.f10211K = "";
                        return this;
                    }

                    public Step clearEndAddressShort() {
                        this.ac = false;
                        this.ad = "";
                        return this;
                    }

                    public Step clearEndInstructions() {
                        this.f10206F = false;
                        this.f10207G = "";
                        return this;
                    }

                    public Step clearEndLocation() {
                        this.f10238l = false;
                        this.f10239m = "";
                        return this;
                    }

                    public Step clearInstructions() {
                        this.f10242p = false;
                        this.f10243q = "";
                        return this;
                    }

                    public Step clearIsDepot() {
                        this.ae = false;
                        this.af = 0;
                        return this;
                    }

                    public Step clearLineStops() {
                        this.f10215O = Collections.emptyList();
                        return this;
                    }

                    public Step clearLinkColor() {
                        this.f10233g = Collections.emptyList();
                        return this;
                    }

                    public Step clearLowerSteps() {
                        this.f10231e = Collections.emptyList();
                        return this;
                    }

                    public Step clearOrderUrl() {
                        this.f10202B = false;
                        this.f10203C = "";
                        return this;
                    }

                    public Step clearPath() {
                        this.f10244r = false;
                        this.f10245s = "";
                        return this;
                    }

                    public Step clearPois() {
                        this.f10232f = Collections.emptyList();
                        return this;
                    }

                    public Step clearPrice() {
                        this.f10221U = false;
                        this.f10222V = 0.0d;
                        return this;
                    }

                    public Step clearRemain() {
                        this.f10223W = false;
                        this.f10224X = 0;
                        return this;
                    }

                    public Step clearSendLocation() {
                        this.f10212L = Collections.emptyList();
                        return this;
                    }

                    public Step clearSpath() {
                        this.f10214N = Collections.emptyList();
                        return this;
                    }

                    public Step clearSstartLocation() {
                        this.f10213M = Collections.emptyList();
                        return this;
                    }

                    public Step clearStartAddress() {
                        this.f10208H = false;
                        this.f10209I = "";
                        return this;
                    }

                    public Step clearStartAddressShort() {
                        this.aa = false;
                        this.ab = "";
                        return this;
                    }

                    public Step clearStartInstructions() {
                        this.f10204D = false;
                        this.f10205E = "";
                        return this;
                    }

                    public Step clearStartLocation() {
                        this.f10240n = false;
                        this.f10241o = "";
                        return this;
                    }

                    public Step clearStepPano() {
                        this.f10216P = false;
                        this.f10217Q = null;
                        return this;
                    }

                    public Step clearStopsPos() {
                        this.f10218R = Collections.emptyList();
                        return this;
                    }

                    public Step clearTicket() {
                        this.f10225Y = false;
                        this.f10226Z = null;
                        return this;
                    }

                    public Step clearTip() {
                        this.f10248v = false;
                        this.f10249w = 0;
                        return this;
                    }

                    public Step clearTipBackground() {
                        this.f10252z = false;
                        this.f10201A = "";
                        return this;
                    }

                    public Step clearTipText() {
                        this.f10250x = false;
                        this.f10251y = "";
                        return this;
                    }

                    public Step clearTransferDict() {
                        this.ag = false;
                        this.ah = null;
                        return this;
                    }

                    public Step clearType() {
                        this.f10246t = false;
                        this.f10247u = 0;
                        return this;
                    }

                    public Step clearVehicle() {
                        this.f10229c = false;
                        this.f10230d = null;
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.ak < 0) {
                            getSerializedSize();
                        }
                        return this.ak;
                    }

                    public int getCanRide() {
                        return this.aj;
                    }

                    public String getComfort() {
                        return this.f10220T;
                    }

                    public DictInstruction getDictInstruction() {
                        return this.f10228b;
                    }

                    public int getDistance() {
                        return this.f10235i;
                    }

                    public int getDuration() {
                        return this.f10237k;
                    }

                    public String getEndAddress() {
                        return this.f10211K;
                    }

                    public String getEndAddressShort() {
                        return this.ad;
                    }

                    public String getEndInstructions() {
                        return this.f10207G;
                    }

                    public String getEndLocation() {
                        return this.f10239m;
                    }

                    public String getInstructions() {
                        return this.f10243q;
                    }

                    public int getIsDepot() {
                        return this.af;
                    }

                    public String getLineStops(int i) {
                        return (String) this.f10215O.get(i);
                    }

                    public int getLineStopsCount() {
                        return this.f10215O.size();
                    }

                    public List<String> getLineStopsList() {
                        return this.f10215O;
                    }

                    public LinkColor getLinkColor(int i) {
                        return (LinkColor) this.f10233g.get(i);
                    }

                    public int getLinkColorCount() {
                        return this.f10233g.size();
                    }

                    public List<LinkColor> getLinkColorList() {
                        return this.f10233g;
                    }

                    public LowerSteps getLowerSteps(int i) {
                        return (LowerSteps) this.f10231e.get(i);
                    }

                    public int getLowerStepsCount() {
                        return this.f10231e.size();
                    }

                    public List<LowerSteps> getLowerStepsList() {
                        return this.f10231e;
                    }

                    public String getOrderUrl() {
                        return this.f10203C;
                    }

                    public String getPath() {
                        return this.f10245s;
                    }

                    public Pois getPois(int i) {
                        return (Pois) this.f10232f.get(i);
                    }

                    public int getPoisCount() {
                        return this.f10232f.size();
                    }

                    public List<Pois> getPoisList() {
                        return this.f10232f;
                    }

                    public double getPrice() {
                        return this.f10222V;
                    }

                    public int getRemain() {
                        return this.f10224X;
                    }

                    public int getSendLocation(int i) {
                        return ((Integer) this.f10212L.get(i)).intValue();
                    }

                    public int getSendLocationCount() {
                        return this.f10212L.size();
                    }

                    public List<Integer> getSendLocationList() {
                        return this.f10212L;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        int computeInt32Size = hasDistance() ? CodedOutputStreamMicro.computeInt32Size(1, getDistance()) + 0 : 0;
                        if (hasDuration()) {
                            computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getDuration());
                        }
                        if (hasEndLocation()) {
                            computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getEndLocation());
                        }
                        if (hasStartLocation()) {
                            computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getStartLocation());
                        }
                        if (hasInstructions()) {
                            computeInt32Size += CodedOutputStreamMicro.computeStringSize(5, getInstructions());
                        }
                        if (hasPath()) {
                            computeInt32Size += CodedOutputStreamMicro.computeStringSize(6, getPath());
                        }
                        if (hasType()) {
                            computeInt32Size += CodedOutputStreamMicro.computeInt32Size(7, getType());
                        }
                        if (hasTip()) {
                            computeInt32Size += CodedOutputStreamMicro.computeInt32Size(8, getTip());
                        }
                        if (hasTipText()) {
                            computeInt32Size += CodedOutputStreamMicro.computeStringSize(9, getTipText());
                        }
                        if (hasTipBackground()) {
                            computeInt32Size += CodedOutputStreamMicro.computeStringSize(10, getTipBackground());
                        }
                        if (hasOrderUrl()) {
                            computeInt32Size += CodedOutputStreamMicro.computeStringSize(11, getOrderUrl());
                        }
                        if (hasVehicle()) {
                            computeInt32Size += CodedOutputStreamMicro.computeMessageSize(12, getVehicle());
                        }
                        int i2 = computeInt32Size;
                        for (LowerSteps computeMessageSize : getLowerStepsList()) {
                            i2 = CodedOutputStreamMicro.computeMessageSize(13, computeMessageSize) + i2;
                        }
                        if (hasStartInstructions()) {
                            i2 += CodedOutputStreamMicro.computeStringSize(14, getStartInstructions());
                        }
                        if (hasEndInstructions()) {
                            i2 += CodedOutputStreamMicro.computeStringSize(15, getEndInstructions());
                        }
                        for (Pois computeMessageSize2 : getPoisList()) {
                            i2 += CodedOutputStreamMicro.computeMessageSize(16, computeMessageSize2);
                        }
                        if (hasStartAddress()) {
                            i2 += CodedOutputStreamMicro.computeStringSize(17, getStartAddress());
                        }
                        if (hasEndAddress()) {
                            i2 += CodedOutputStreamMicro.computeStringSize(18, getEndAddress());
                        }
                        int i3 = 0;
                        for (Integer intValue : getSendLocationList()) {
                            i3 = CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue()) + i3;
                        }
                        i3 = (i2 + i3) + (getSendLocationList().size() * 2);
                        i2 = 0;
                        for (Integer intValue2 : getSstartLocationList()) {
                            i2 = CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue2.intValue()) + i2;
                        }
                        i3 = (i3 + i2) + (getSstartLocationList().size() * 2);
                        i2 = 0;
                        for (Integer intValue22 : getSpathList()) {
                            i2 = CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue22.intValue()) + i2;
                        }
                        i2 = (getSpathList().size() * 2) + (i3 + i2);
                        for (String computeStringSizeNoTag : getLineStopsList()) {
                            i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag);
                        }
                        computeInt32Size = (i2 + i) + (getLineStopsList().size() * 2);
                        if (hasDictInstruction()) {
                            computeInt32Size += CodedOutputStreamMicro.computeMessageSize(23, getDictInstruction());
                        }
                        i = computeInt32Size;
                        for (LinkColor computeMessageSize3 : getLinkColorList()) {
                            i = CodedOutputStreamMicro.computeMessageSize(24, computeMessageSize3) + i;
                        }
                        if (hasStepPano()) {
                            i += CodedOutputStreamMicro.computeMessageSize(25, getStepPano());
                        }
                        for (StopsPos computeMessageSize4 : getStopsPosList()) {
                            i += CodedOutputStreamMicro.computeMessageSize(26, computeMessageSize4);
                        }
                        if (hasComfort()) {
                            i += CodedOutputStreamMicro.computeStringSize(27, getComfort());
                        }
                        if (hasPrice()) {
                            i += CodedOutputStreamMicro.computeDoubleSize(28, getPrice());
                        }
                        if (hasRemain()) {
                            i += CodedOutputStreamMicro.computeInt32Size(29, getRemain());
                        }
                        if (hasTicket()) {
                            i += CodedOutputStreamMicro.computeMessageSize(30, getTicket());
                        }
                        if (hasStartAddressShort()) {
                            i += CodedOutputStreamMicro.computeStringSize(31, getStartAddressShort());
                        }
                        if (hasEndAddressShort()) {
                            i += CodedOutputStreamMicro.computeStringSize(32, getEndAddressShort());
                        }
                        if (hasIsDepot()) {
                            i += CodedOutputStreamMicro.computeInt32Size(33, getIsDepot());
                        }
                        if (hasTransferDict()) {
                            i += CodedOutputStreamMicro.computeMessageSize(34, getTransferDict());
                        }
                        if (hasCanRide()) {
                            i += CodedOutputStreamMicro.computeInt32Size(35, getCanRide());
                        }
                        this.ak = i;
                        return i;
                    }

                    public int getSpath(int i) {
                        return ((Integer) this.f10214N.get(i)).intValue();
                    }

                    public int getSpathCount() {
                        return this.f10214N.size();
                    }

                    public List<Integer> getSpathList() {
                        return this.f10214N;
                    }

                    public int getSstartLocation(int i) {
                        return ((Integer) this.f10213M.get(i)).intValue();
                    }

                    public int getSstartLocationCount() {
                        return this.f10213M.size();
                    }

                    public List<Integer> getSstartLocationList() {
                        return this.f10213M;
                    }

                    public String getStartAddress() {
                        return this.f10209I;
                    }

                    public String getStartAddressShort() {
                        return this.ab;
                    }

                    public String getStartInstructions() {
                        return this.f10205E;
                    }

                    public String getStartLocation() {
                        return this.f10241o;
                    }

                    public StepPano getStepPano() {
                        return this.f10217Q;
                    }

                    public StopsPos getStopsPos(int i) {
                        return (StopsPos) this.f10218R.get(i);
                    }

                    public int getStopsPosCount() {
                        return this.f10218R.size();
                    }

                    public List<StopsPos> getStopsPosList() {
                        return this.f10218R;
                    }

                    public Ticket getTicket() {
                        return this.f10226Z;
                    }

                    public int getTip() {
                        return this.f10249w;
                    }

                    public String getTipBackground() {
                        return this.f10201A;
                    }

                    public String getTipText() {
                        return this.f10251y;
                    }

                    public TransferDict getTransferDict() {
                        return this.ah;
                    }

                    public int getType() {
                        return this.f10247u;
                    }

                    public Vehicle getVehicle() {
                        return this.f10230d;
                    }

                    public boolean hasCanRide() {
                        return this.ai;
                    }

                    public boolean hasComfort() {
                        return this.f10219S;
                    }

                    public boolean hasDictInstruction() {
                        return this.f10227a;
                    }

                    public boolean hasDistance() {
                        return this.f10234h;
                    }

                    public boolean hasDuration() {
                        return this.f10236j;
                    }

                    public boolean hasEndAddress() {
                        return this.f10210J;
                    }

                    public boolean hasEndAddressShort() {
                        return this.ac;
                    }

                    public boolean hasEndInstructions() {
                        return this.f10206F;
                    }

                    public boolean hasEndLocation() {
                        return this.f10238l;
                    }

                    public boolean hasInstructions() {
                        return this.f10242p;
                    }

                    public boolean hasIsDepot() {
                        return this.ae;
                    }

                    public boolean hasOrderUrl() {
                        return this.f10202B;
                    }

                    public boolean hasPath() {
                        return this.f10244r;
                    }

                    public boolean hasPrice() {
                        return this.f10221U;
                    }

                    public boolean hasRemain() {
                        return this.f10223W;
                    }

                    public boolean hasStartAddress() {
                        return this.f10208H;
                    }

                    public boolean hasStartAddressShort() {
                        return this.aa;
                    }

                    public boolean hasStartInstructions() {
                        return this.f10204D;
                    }

                    public boolean hasStartLocation() {
                        return this.f10240n;
                    }

                    public boolean hasStepPano() {
                        return this.f10216P;
                    }

                    public boolean hasTicket() {
                        return this.f10225Y;
                    }

                    public boolean hasTip() {
                        return this.f10248v;
                    }

                    public boolean hasTipBackground() {
                        return this.f10252z;
                    }

                    public boolean hasTipText() {
                        return this.f10250x;
                    }

                    public boolean hasTransferDict() {
                        return this.ag;
                    }

                    public boolean hasType() {
                        return this.f10246t;
                    }

                    public boolean hasVehicle() {
                        return this.f10229c;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Step mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            MessageMicro vehicle;
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    setDistance(codedInputStreamMicro.readInt32());
                                    continue;
                                case 16:
                                    setDuration(codedInputStreamMicro.readInt32());
                                    continue;
                                case 26:
                                    setEndLocation(codedInputStreamMicro.readString());
                                    continue;
                                case 34:
                                    setStartLocation(codedInputStreamMicro.readString());
                                    continue;
                                case 42:
                                    setInstructions(codedInputStreamMicro.readString());
                                    continue;
                                case 50:
                                    setPath(codedInputStreamMicro.readString());
                                    continue;
                                case 56:
                                    setType(codedInputStreamMicro.readInt32());
                                    continue;
                                case 64:
                                    setTip(codedInputStreamMicro.readInt32());
                                    continue;
                                case 74:
                                    setTipText(codedInputStreamMicro.readString());
                                    continue;
                                case 82:
                                    setTipBackground(codedInputStreamMicro.readString());
                                    continue;
                                case 90:
                                    setOrderUrl(codedInputStreamMicro.readString());
                                    continue;
                                case 98:
                                    vehicle = new Vehicle();
                                    codedInputStreamMicro.readMessage(vehicle);
                                    setVehicle(vehicle);
                                    continue;
                                case 106:
                                    vehicle = new LowerSteps();
                                    codedInputStreamMicro.readMessage(vehicle);
                                    addLowerSteps(vehicle);
                                    continue;
                                case 114:
                                    setStartInstructions(codedInputStreamMicro.readString());
                                    continue;
                                case C1253f.df /*122*/:
                                    setEndInstructions(codedInputStreamMicro.readString());
                                    continue;
                                case 130:
                                    vehicle = new Pois();
                                    codedInputStreamMicro.readMessage(vehicle);
                                    addPois(vehicle);
                                    continue;
                                case 138:
                                    setStartAddress(codedInputStreamMicro.readString());
                                    continue;
                                case 146:
                                    setEndAddress(codedInputStreamMicro.readString());
                                    continue;
                                case 152:
                                    addSendLocation(codedInputStreamMicro.readSInt32());
                                    continue;
                                case 160:
                                    addSstartLocation(codedInputStreamMicro.readSInt32());
                                    continue;
                                case 168:
                                    addSpath(codedInputStreamMicro.readSInt32());
                                    continue;
                                case 178:
                                    addLineStops(codedInputStreamMicro.readString());
                                    continue;
                                case 186:
                                    vehicle = new DictInstruction();
                                    codedInputStreamMicro.readMessage(vehicle);
                                    setDictInstruction(vehicle);
                                    continue;
                                case RouteLineResConst.LINE_INTERNAL_NORMAL /*194*/:
                                    vehicle = new LinkColor();
                                    codedInputStreamMicro.readMessage(vehicle);
                                    addLinkColor(vehicle);
                                    continue;
                                case 202:
                                    vehicle = new StepPano();
                                    codedInputStreamMicro.readMessage(vehicle);
                                    setStepPano(vehicle);
                                    continue;
                                case C1253f.ds /*210*/:
                                    vehicle = new StopsPos();
                                    codedInputStreamMicro.readMessage(vehicle);
                                    addStopsPos(vehicle);
                                    continue;
                                case 218:
                                    setComfort(codedInputStreamMicro.readString());
                                    continue;
                                case 225:
                                    setPrice(codedInputStreamMicro.readDouble());
                                    continue;
                                case NaviCmdConstants.ACTION_TYPE_NAVI_MODE_DAY /*232*/:
                                    setRemain(codedInputStreamMicro.readInt32());
                                    continue;
                                case C1253f.dM /*242*/:
                                    vehicle = new Ticket();
                                    codedInputStreamMicro.readMessage(vehicle);
                                    setTicket(vehicle);
                                    continue;
                                case 250:
                                    setStartAddressShort(codedInputStreamMicro.readString());
                                    continue;
                                case 258:
                                    setEndAddressShort(codedInputStreamMicro.readString());
                                    continue;
                                case 264:
                                    setIsDepot(codedInputStreamMicro.readInt32());
                                    continue;
                                case 274:
                                    vehicle = new TransferDict();
                                    codedInputStreamMicro.readMessage(vehicle);
                                    setTransferDict(vehicle);
                                    continue;
                                case 280:
                                    setCanRide(codedInputStreamMicro.readInt32());
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

                    public Step setCanRide(int i) {
                        this.ai = true;
                        this.aj = i;
                        return this;
                    }

                    public Step setComfort(String str) {
                        this.f10219S = true;
                        this.f10220T = str;
                        return this;
                    }

                    public Step setDictInstruction(DictInstruction dictInstruction) {
                        if (dictInstruction == null) {
                            return clearDictInstruction();
                        }
                        this.f10227a = true;
                        this.f10228b = dictInstruction;
                        return this;
                    }

                    public Step setDistance(int i) {
                        this.f10234h = true;
                        this.f10235i = i;
                        return this;
                    }

                    public Step setDuration(int i) {
                        this.f10236j = true;
                        this.f10237k = i;
                        return this;
                    }

                    public Step setEndAddress(String str) {
                        this.f10210J = true;
                        this.f10211K = str;
                        return this;
                    }

                    public Step setEndAddressShort(String str) {
                        this.ac = true;
                        this.ad = str;
                        return this;
                    }

                    public Step setEndInstructions(String str) {
                        this.f10206F = true;
                        this.f10207G = str;
                        return this;
                    }

                    public Step setEndLocation(String str) {
                        this.f10238l = true;
                        this.f10239m = str;
                        return this;
                    }

                    public Step setInstructions(String str) {
                        this.f10242p = true;
                        this.f10243q = str;
                        return this;
                    }

                    public Step setIsDepot(int i) {
                        this.ae = true;
                        this.af = i;
                        return this;
                    }

                    public Step setLineStops(int i, String str) {
                        if (str == null) {
                            throw new NullPointerException();
                        }
                        this.f10215O.set(i, str);
                        return this;
                    }

                    public Step setLinkColor(int i, LinkColor linkColor) {
                        if (linkColor != null) {
                            this.f10233g.set(i, linkColor);
                        }
                        return this;
                    }

                    public Step setLowerSteps(int i, LowerSteps lowerSteps) {
                        if (lowerSteps != null) {
                            this.f10231e.set(i, lowerSteps);
                        }
                        return this;
                    }

                    public Step setOrderUrl(String str) {
                        this.f10202B = true;
                        this.f10203C = str;
                        return this;
                    }

                    public Step setPath(String str) {
                        this.f10244r = true;
                        this.f10245s = str;
                        return this;
                    }

                    public Step setPois(int i, Pois pois) {
                        if (pois != null) {
                            this.f10232f.set(i, pois);
                        }
                        return this;
                    }

                    public Step setPrice(double d) {
                        this.f10221U = true;
                        this.f10222V = d;
                        return this;
                    }

                    public Step setRemain(int i) {
                        this.f10223W = true;
                        this.f10224X = i;
                        return this;
                    }

                    public Step setSendLocation(int i, int i2) {
                        this.f10212L.set(i, Integer.valueOf(i2));
                        return this;
                    }

                    public Step setSpath(int i, int i2) {
                        this.f10214N.set(i, Integer.valueOf(i2));
                        return this;
                    }

                    public Step setSstartLocation(int i, int i2) {
                        this.f10213M.set(i, Integer.valueOf(i2));
                        return this;
                    }

                    public Step setStartAddress(String str) {
                        this.f10208H = true;
                        this.f10209I = str;
                        return this;
                    }

                    public Step setStartAddressShort(String str) {
                        this.aa = true;
                        this.ab = str;
                        return this;
                    }

                    public Step setStartInstructions(String str) {
                        this.f10204D = true;
                        this.f10205E = str;
                        return this;
                    }

                    public Step setStartLocation(String str) {
                        this.f10240n = true;
                        this.f10241o = str;
                        return this;
                    }

                    public Step setStepPano(StepPano stepPano) {
                        if (stepPano == null) {
                            return clearStepPano();
                        }
                        this.f10216P = true;
                        this.f10217Q = stepPano;
                        return this;
                    }

                    public Step setStopsPos(int i, StopsPos stopsPos) {
                        if (stopsPos != null) {
                            this.f10218R.set(i, stopsPos);
                        }
                        return this;
                    }

                    public Step setTicket(Ticket ticket) {
                        if (ticket == null) {
                            return clearTicket();
                        }
                        this.f10225Y = true;
                        this.f10226Z = ticket;
                        return this;
                    }

                    public Step setTip(int i) {
                        this.f10248v = true;
                        this.f10249w = i;
                        return this;
                    }

                    public Step setTipBackground(String str) {
                        this.f10252z = true;
                        this.f10201A = str;
                        return this;
                    }

                    public Step setTipText(String str) {
                        this.f10250x = true;
                        this.f10251y = str;
                        return this;
                    }

                    public Step setTransferDict(TransferDict transferDict) {
                        if (transferDict == null) {
                            return clearTransferDict();
                        }
                        this.ag = true;
                        this.ah = transferDict;
                        return this;
                    }

                    public Step setType(int i) {
                        this.f10246t = true;
                        this.f10247u = i;
                        return this;
                    }

                    public Step setVehicle(Vehicle vehicle) {
                        if (vehicle == null) {
                            return clearVehicle();
                        }
                        this.f10229c = true;
                        this.f10230d = vehicle;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasDistance()) {
                            codedOutputStreamMicro.writeInt32(1, getDistance());
                        }
                        if (hasDuration()) {
                            codedOutputStreamMicro.writeInt32(2, getDuration());
                        }
                        if (hasEndLocation()) {
                            codedOutputStreamMicro.writeString(3, getEndLocation());
                        }
                        if (hasStartLocation()) {
                            codedOutputStreamMicro.writeString(4, getStartLocation());
                        }
                        if (hasInstructions()) {
                            codedOutputStreamMicro.writeString(5, getInstructions());
                        }
                        if (hasPath()) {
                            codedOutputStreamMicro.writeString(6, getPath());
                        }
                        if (hasType()) {
                            codedOutputStreamMicro.writeInt32(7, getType());
                        }
                        if (hasTip()) {
                            codedOutputStreamMicro.writeInt32(8, getTip());
                        }
                        if (hasTipText()) {
                            codedOutputStreamMicro.writeString(9, getTipText());
                        }
                        if (hasTipBackground()) {
                            codedOutputStreamMicro.writeString(10, getTipBackground());
                        }
                        if (hasOrderUrl()) {
                            codedOutputStreamMicro.writeString(11, getOrderUrl());
                        }
                        if (hasVehicle()) {
                            codedOutputStreamMicro.writeMessage(12, getVehicle());
                        }
                        for (LowerSteps writeMessage : getLowerStepsList()) {
                            codedOutputStreamMicro.writeMessage(13, writeMessage);
                        }
                        if (hasStartInstructions()) {
                            codedOutputStreamMicro.writeString(14, getStartInstructions());
                        }
                        if (hasEndInstructions()) {
                            codedOutputStreamMicro.writeString(15, getEndInstructions());
                        }
                        for (Pois writeMessage2 : getPoisList()) {
                            codedOutputStreamMicro.writeMessage(16, writeMessage2);
                        }
                        if (hasStartAddress()) {
                            codedOutputStreamMicro.writeString(17, getStartAddress());
                        }
                        if (hasEndAddress()) {
                            codedOutputStreamMicro.writeString(18, getEndAddress());
                        }
                        for (Integer intValue : getSendLocationList()) {
                            codedOutputStreamMicro.writeSInt32(19, intValue.intValue());
                        }
                        for (Integer intValue2 : getSstartLocationList()) {
                            codedOutputStreamMicro.writeSInt32(20, intValue2.intValue());
                        }
                        for (Integer intValue22 : getSpathList()) {
                            codedOutputStreamMicro.writeSInt32(21, intValue22.intValue());
                        }
                        for (String writeString : getLineStopsList()) {
                            codedOutputStreamMicro.writeString(22, writeString);
                        }
                        if (hasDictInstruction()) {
                            codedOutputStreamMicro.writeMessage(23, getDictInstruction());
                        }
                        for (LinkColor writeMessage3 : getLinkColorList()) {
                            codedOutputStreamMicro.writeMessage(24, writeMessage3);
                        }
                        if (hasStepPano()) {
                            codedOutputStreamMicro.writeMessage(25, getStepPano());
                        }
                        for (StopsPos writeMessage4 : getStopsPosList()) {
                            codedOutputStreamMicro.writeMessage(26, writeMessage4);
                        }
                        if (hasComfort()) {
                            codedOutputStreamMicro.writeString(27, getComfort());
                        }
                        if (hasPrice()) {
                            codedOutputStreamMicro.writeDouble(28, getPrice());
                        }
                        if (hasRemain()) {
                            codedOutputStreamMicro.writeInt32(29, getRemain());
                        }
                        if (hasTicket()) {
                            codedOutputStreamMicro.writeMessage(30, getTicket());
                        }
                        if (hasStartAddressShort()) {
                            codedOutputStreamMicro.writeString(31, getStartAddressShort());
                        }
                        if (hasEndAddressShort()) {
                            codedOutputStreamMicro.writeString(32, getEndAddressShort());
                        }
                        if (hasIsDepot()) {
                            codedOutputStreamMicro.writeInt32(33, getIsDepot());
                        }
                        if (hasTransferDict()) {
                            codedOutputStreamMicro.writeMessage(34, getTransferDict());
                        }
                        if (hasCanRide()) {
                            codedOutputStreamMicro.writeInt32(35, getCanRide());
                        }
                    }
                }

                public static Steps parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Steps().mergeFrom(codedInputStreamMicro);
                }

                public static Steps parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Steps) new Steps().mergeFrom(bArr);
                }

                public Steps addStep(Step step) {
                    if (step != null) {
                        if (this.f10253a.isEmpty()) {
                            this.f10253a = new ArrayList();
                        }
                        this.f10253a.add(step);
                    }
                    return this;
                }

                public final Steps clear() {
                    clearStep();
                    this.f10254b = -1;
                    return this;
                }

                public Steps clearStep() {
                    this.f10253a = Collections.emptyList();
                    return this;
                }

                public int getCachedSize() {
                    if (this.f10254b < 0) {
                        getSerializedSize();
                    }
                    return this.f10254b;
                }

                public int getSerializedSize() {
                    int i = 0;
                    for (Step computeMessageSize : getStepList()) {
                        i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
                    }
                    this.f10254b = i;
                    return i;
                }

                public Step getStep(int i) {
                    return (Step) this.f10253a.get(i);
                }

                public int getStepCount() {
                    return this.f10253a.size();
                }

                public List<Step> getStepList() {
                    return this.f10253a;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Steps mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                MessageMicro step = new Step();
                                codedInputStreamMicro.readMessage(step);
                                addStep(step);
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

                public Steps setStep(int i, Step step) {
                    if (step != null) {
                        this.f10253a.set(i, step);
                    }
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    for (Step writeMessage : getStepList()) {
                        codedOutputStreamMicro.writeMessage(1, writeMessage);
                    }
                }
            }

            public static Legs parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Legs().mergeFrom(codedInputStreamMicro);
            }

            public static Legs parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Legs) new Legs().mergeFrom(bArr);
            }

            public Legs addLinePrice(LinePrice linePrice) {
                if (linePrice != null) {
                    if (this.f10276V.isEmpty()) {
                        this.f10276V = new ArrayList();
                    }
                    this.f10276V.add(linePrice);
                }
                return this;
            }

            public Legs addSendLocation(int i) {
                if (this.f10260F.isEmpty()) {
                    this.f10260F = new ArrayList();
                }
                this.f10260F.add(Integer.valueOf(i));
                return this;
            }

            public Legs addSstartLocation(int i) {
                if (this.f10261G.isEmpty()) {
                    this.f10261G = new ArrayList();
                }
                this.f10261G.add(Integer.valueOf(i));
                return this;
            }

            public Legs addSteps(Steps steps) {
                if (steps != null) {
                    if (this.f10281a.isEmpty()) {
                        this.f10281a = new ArrayList();
                    }
                    this.f10281a.add(steps);
                }
                return this;
            }

            public final Legs clear() {
                clearSteps();
                clearDistance();
                clearDuration();
                clearEndLocation();
                clearStartLocation();
                clearTip();
                clearTipText();
                clearTipBackground();
                clearArriveTime();
                clearStartAddress();
                clearEndAddress();
                clearStartTime();
                clearEndTime();
                clearPrice();
                clearDiscount();
                clearInstructions();
                clearSendLocation();
                clearSstartLocation();
                clearTipLabel();
                clearTipLabelBackground();
                clearTipRtbus();
                clearRtbusUpdateTime();
                clearTrafficType();
                clearStartPano();
                clearEndPano();
                clearLinePrice();
                clearComfort();
                clearPlanStatus();
                clearPlanType();
                clearTipLabelText();
                this.ae = -1;
                return this;
            }

            public Legs clearArriveTime() {
                this.f10296p = false;
                this.f10297q = "";
                return this;
            }

            public Legs clearComfort() {
                this.f10277W = false;
                this.f10278X = "";
                return this;
            }

            public Legs clearDiscount() {
                this.f10256B = false;
                this.f10257C = "";
                return this;
            }

            public Legs clearDistance() {
                this.f10282b = false;
                this.f10283c = 0;
                return this;
            }

            public Legs clearDuration() {
                this.f10284d = false;
                this.f10285e = 0;
                return this;
            }

            public Legs clearEndAddress() {
                this.f10300t = false;
                this.f10301u = "";
                return this;
            }

            public Legs clearEndLocation() {
                this.f10286f = false;
                this.f10287g = "";
                return this;
            }

            public Legs clearEndPano() {
                this.f10274T = false;
                this.f10275U = null;
                return this;
            }

            public Legs clearEndTime() {
                this.f10304x = false;
                this.f10305y = "";
                return this;
            }

            public Legs clearInstructions() {
                this.f10258D = false;
                this.f10259E = "";
                return this;
            }

            public Legs clearLinePrice() {
                this.f10276V = Collections.emptyList();
                return this;
            }

            public Legs clearPlanStatus() {
                this.f10279Y = false;
                this.f10280Z = 0;
                return this;
            }

            public Legs clearPlanType() {
                this.aa = false;
                this.ab = 0;
                return this;
            }

            public Legs clearPrice() {
                this.f10306z = false;
                this.f10255A = "";
                return this;
            }

            public Legs clearRtbusUpdateTime() {
                this.f10268N = false;
                this.f10269O = 0;
                return this;
            }

            public Legs clearSendLocation() {
                this.f10260F = Collections.emptyList();
                return this;
            }

            public Legs clearSstartLocation() {
                this.f10261G = Collections.emptyList();
                return this;
            }

            public Legs clearStartAddress() {
                this.f10298r = false;
                this.f10299s = "";
                return this;
            }

            public Legs clearStartLocation() {
                this.f10288h = false;
                this.f10289i = "";
                return this;
            }

            public Legs clearStartPano() {
                this.f10272R = false;
                this.f10273S = null;
                return this;
            }

            public Legs clearStartTime() {
                this.f10302v = false;
                this.f10303w = "";
                return this;
            }

            public Legs clearSteps() {
                this.f10281a = Collections.emptyList();
                return this;
            }

            public Legs clearTip() {
                this.f10290j = false;
                this.f10291k = 0;
                return this;
            }

            public Legs clearTipBackground() {
                this.f10294n = false;
                this.f10295o = "";
                return this;
            }

            public Legs clearTipLabel() {
                this.f10262H = false;
                this.f10263I = "";
                return this;
            }

            public Legs clearTipLabelBackground() {
                this.f10264J = false;
                this.f10265K = "";
                return this;
            }

            public Legs clearTipLabelText() {
                this.ac = false;
                this.ad = "";
                return this;
            }

            public Legs clearTipRtbus() {
                this.f10266L = false;
                this.f10267M = "";
                return this;
            }

            public Legs clearTipText() {
                this.f10292l = false;
                this.f10293m = "";
                return this;
            }

            public Legs clearTrafficType() {
                this.f10270P = false;
                this.f10271Q = 0;
                return this;
            }

            public String getArriveTime() {
                return this.f10297q;
            }

            public int getCachedSize() {
                if (this.ae < 0) {
                    getSerializedSize();
                }
                return this.ae;
            }

            public String getComfort() {
                return this.f10278X;
            }

            public String getDiscount() {
                return this.f10257C;
            }

            public int getDistance() {
                return this.f10283c;
            }

            public int getDuration() {
                return this.f10285e;
            }

            public String getEndAddress() {
                return this.f10301u;
            }

            public String getEndLocation() {
                return this.f10287g;
            }

            public EndPano getEndPano() {
                return this.f10275U;
            }

            public String getEndTime() {
                return this.f10305y;
            }

            public String getInstructions() {
                return this.f10259E;
            }

            public LinePrice getLinePrice(int i) {
                return (LinePrice) this.f10276V.get(i);
            }

            public int getLinePriceCount() {
                return this.f10276V.size();
            }

            public List<LinePrice> getLinePriceList() {
                return this.f10276V;
            }

            public int getPlanStatus() {
                return this.f10280Z;
            }

            public int getPlanType() {
                return this.ab;
            }

            public String getPrice() {
                return this.f10255A;
            }

            public int getRtbusUpdateTime() {
                return this.f10269O;
            }

            public int getSendLocation(int i) {
                return ((Integer) this.f10260F.get(i)).intValue();
            }

            public int getSendLocationCount() {
                return this.f10260F.size();
            }

            public List<Integer> getSendLocationList() {
                return this.f10260F;
            }

            public int getSerializedSize() {
                int i = 0;
                int computeInt32Size = hasDistance() ? CodedOutputStreamMicro.computeInt32Size(1, getDistance()) + 0 : 0;
                if (hasDuration()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getDuration());
                }
                if (hasEndLocation()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getEndLocation());
                }
                if (hasStartLocation()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getStartLocation());
                }
                if (hasTip()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(5, getTip());
                }
                if (hasTipText()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(6, getTipText());
                }
                if (hasTipBackground()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(7, getTipBackground());
                }
                if (hasArriveTime()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(8, getArriveTime());
                }
                int i2 = computeInt32Size;
                for (Steps computeMessageSize : getStepsList()) {
                    i2 = CodedOutputStreamMicro.computeMessageSize(11, computeMessageSize) + i2;
                }
                if (hasStartAddress()) {
                    i2 += CodedOutputStreamMicro.computeStringSize(12, getStartAddress());
                }
                if (hasEndAddress()) {
                    i2 += CodedOutputStreamMicro.computeStringSize(13, getEndAddress());
                }
                if (hasStartTime()) {
                    i2 += CodedOutputStreamMicro.computeStringSize(14, getStartTime());
                }
                if (hasEndTime()) {
                    i2 += CodedOutputStreamMicro.computeStringSize(15, getEndTime());
                }
                if (hasPrice()) {
                    i2 += CodedOutputStreamMicro.computeStringSize(16, getPrice());
                }
                if (hasDiscount()) {
                    i2 += CodedOutputStreamMicro.computeStringSize(17, getDiscount());
                }
                if (hasInstructions()) {
                    i2 += CodedOutputStreamMicro.computeStringSize(18, getInstructions());
                }
                int i3 = 0;
                for (Integer intValue : getSendLocationList()) {
                    i3 = CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue()) + i3;
                }
                i2 = (getSendLocationList().size() * 2) + (i2 + i3);
                for (Integer intValue2 : getSstartLocationList()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue2.intValue());
                }
                computeInt32Size = (i2 + i) + (getSstartLocationList().size() * 2);
                if (hasTipLabel()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(21, getTipLabel());
                }
                if (hasTipLabelBackground()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(22, getTipLabelBackground());
                }
                if (hasTipRtbus()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(23, getTipRtbus());
                }
                if (hasRtbusUpdateTime()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(24, getRtbusUpdateTime());
                }
                if (hasTrafficType()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(25, getTrafficType());
                }
                if (hasStartPano()) {
                    computeInt32Size += CodedOutputStreamMicro.computeMessageSize(26, getStartPano());
                }
                if (hasEndPano()) {
                    computeInt32Size += CodedOutputStreamMicro.computeMessageSize(27, getEndPano());
                }
                i = computeInt32Size;
                for (LinePrice computeMessageSize2 : getLinePriceList()) {
                    i = CodedOutputStreamMicro.computeMessageSize(28, computeMessageSize2) + i;
                }
                if (hasComfort()) {
                    i += CodedOutputStreamMicro.computeStringSize(29, getComfort());
                }
                if (hasPlanStatus()) {
                    i += CodedOutputStreamMicro.computeInt32Size(30, getPlanStatus());
                }
                if (hasPlanType()) {
                    i += CodedOutputStreamMicro.computeInt32Size(31, getPlanType());
                }
                if (hasTipLabelText()) {
                    i += CodedOutputStreamMicro.computeStringSize(32, getTipLabelText());
                }
                this.ae = i;
                return i;
            }

            public int getSstartLocation(int i) {
                return ((Integer) this.f10261G.get(i)).intValue();
            }

            public int getSstartLocationCount() {
                return this.f10261G.size();
            }

            public List<Integer> getSstartLocationList() {
                return this.f10261G;
            }

            public String getStartAddress() {
                return this.f10299s;
            }

            public String getStartLocation() {
                return this.f10289i;
            }

            public StartPano getStartPano() {
                return this.f10273S;
            }

            public String getStartTime() {
                return this.f10303w;
            }

            public Steps getSteps(int i) {
                return (Steps) this.f10281a.get(i);
            }

            public int getStepsCount() {
                return this.f10281a.size();
            }

            public List<Steps> getStepsList() {
                return this.f10281a;
            }

            public int getTip() {
                return this.f10291k;
            }

            public String getTipBackground() {
                return this.f10295o;
            }

            public String getTipLabel() {
                return this.f10263I;
            }

            public String getTipLabelBackground() {
                return this.f10265K;
            }

            public String getTipLabelText() {
                return this.ad;
            }

            public String getTipRtbus() {
                return this.f10267M;
            }

            public String getTipText() {
                return this.f10293m;
            }

            public int getTrafficType() {
                return this.f10271Q;
            }

            public boolean hasArriveTime() {
                return this.f10296p;
            }

            public boolean hasComfort() {
                return this.f10277W;
            }

            public boolean hasDiscount() {
                return this.f10256B;
            }

            public boolean hasDistance() {
                return this.f10282b;
            }

            public boolean hasDuration() {
                return this.f10284d;
            }

            public boolean hasEndAddress() {
                return this.f10300t;
            }

            public boolean hasEndLocation() {
                return this.f10286f;
            }

            public boolean hasEndPano() {
                return this.f10274T;
            }

            public boolean hasEndTime() {
                return this.f10304x;
            }

            public boolean hasInstructions() {
                return this.f10258D;
            }

            public boolean hasPlanStatus() {
                return this.f10279Y;
            }

            public boolean hasPlanType() {
                return this.aa;
            }

            public boolean hasPrice() {
                return this.f10306z;
            }

            public boolean hasRtbusUpdateTime() {
                return this.f10268N;
            }

            public boolean hasStartAddress() {
                return this.f10298r;
            }

            public boolean hasStartLocation() {
                return this.f10288h;
            }

            public boolean hasStartPano() {
                return this.f10272R;
            }

            public boolean hasStartTime() {
                return this.f10302v;
            }

            public boolean hasTip() {
                return this.f10290j;
            }

            public boolean hasTipBackground() {
                return this.f10294n;
            }

            public boolean hasTipLabel() {
                return this.f10262H;
            }

            public boolean hasTipLabelBackground() {
                return this.f10264J;
            }

            public boolean hasTipLabelText() {
                return this.ac;
            }

            public boolean hasTipRtbus() {
                return this.f10266L;
            }

            public boolean hasTipText() {
                return this.f10292l;
            }

            public boolean hasTrafficType() {
                return this.f10270P;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Legs mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    MessageMicro steps;
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            setDistance(codedInputStreamMicro.readInt32());
                            continue;
                        case 16:
                            setDuration(codedInputStreamMicro.readInt32());
                            continue;
                        case 26:
                            setEndLocation(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setStartLocation(codedInputStreamMicro.readString());
                            continue;
                        case 40:
                            setTip(codedInputStreamMicro.readInt32());
                            continue;
                        case 50:
                            setTipText(codedInputStreamMicro.readString());
                            continue;
                        case 58:
                            setTipBackground(codedInputStreamMicro.readString());
                            continue;
                        case 66:
                            setArriveTime(codedInputStreamMicro.readString());
                            continue;
                        case 90:
                            steps = new Steps();
                            codedInputStreamMicro.readMessage(steps);
                            addSteps(steps);
                            continue;
                        case 98:
                            setStartAddress(codedInputStreamMicro.readString());
                            continue;
                        case 106:
                            setEndAddress(codedInputStreamMicro.readString());
                            continue;
                        case 114:
                            setStartTime(codedInputStreamMicro.readString());
                            continue;
                        case C1253f.df /*122*/:
                            setEndTime(codedInputStreamMicro.readString());
                            continue;
                        case 130:
                            setPrice(codedInputStreamMicro.readString());
                            continue;
                        case 138:
                            setDiscount(codedInputStreamMicro.readString());
                            continue;
                        case 146:
                            setInstructions(codedInputStreamMicro.readString());
                            continue;
                        case 152:
                            addSendLocation(codedInputStreamMicro.readSInt32());
                            continue;
                        case 160:
                            addSstartLocation(codedInputStreamMicro.readSInt32());
                            continue;
                        case 170:
                            setTipLabel(codedInputStreamMicro.readString());
                            continue;
                        case 178:
                            setTipLabelBackground(codedInputStreamMicro.readString());
                            continue;
                        case 186:
                            setTipRtbus(codedInputStreamMicro.readString());
                            continue;
                        case 192:
                            setRtbusUpdateTime(codedInputStreamMicro.readInt32());
                            continue;
                        case 200:
                            setTrafficType(codedInputStreamMicro.readInt32());
                            continue;
                        case C1253f.ds /*210*/:
                            steps = new StartPano();
                            codedInputStreamMicro.readMessage(steps);
                            setStartPano(steps);
                            continue;
                        case 218:
                            steps = new EndPano();
                            codedInputStreamMicro.readMessage(steps);
                            setEndPano(steps);
                            continue;
                        case C1253f.dG /*226*/:
                            steps = new LinePrice();
                            codedInputStreamMicro.readMessage(steps);
                            addLinePrice(steps);
                            continue;
                        case NaviCmdConstants.ACTION_TYPE_NAVI_TTS_MODE_EXPERT /*234*/:
                            setComfort(codedInputStreamMicro.readString());
                            continue;
                        case RGHUDDataModel.MAX_CAR_SPEED /*240*/:
                            setPlanStatus(codedInputStreamMicro.readInt32());
                            continue;
                        case C1253f.dQ /*248*/:
                            setPlanType(codedInputStreamMicro.readInt32());
                            continue;
                        case 258:
                            setTipLabelText(codedInputStreamMicro.readString());
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

            public Legs setArriveTime(String str) {
                this.f10296p = true;
                this.f10297q = str;
                return this;
            }

            public Legs setComfort(String str) {
                this.f10277W = true;
                this.f10278X = str;
                return this;
            }

            public Legs setDiscount(String str) {
                this.f10256B = true;
                this.f10257C = str;
                return this;
            }

            public Legs setDistance(int i) {
                this.f10282b = true;
                this.f10283c = i;
                return this;
            }

            public Legs setDuration(int i) {
                this.f10284d = true;
                this.f10285e = i;
                return this;
            }

            public Legs setEndAddress(String str) {
                this.f10300t = true;
                this.f10301u = str;
                return this;
            }

            public Legs setEndLocation(String str) {
                this.f10286f = true;
                this.f10287g = str;
                return this;
            }

            public Legs setEndPano(EndPano endPano) {
                if (endPano == null) {
                    return clearEndPano();
                }
                this.f10274T = true;
                this.f10275U = endPano;
                return this;
            }

            public Legs setEndTime(String str) {
                this.f10304x = true;
                this.f10305y = str;
                return this;
            }

            public Legs setInstructions(String str) {
                this.f10258D = true;
                this.f10259E = str;
                return this;
            }

            public Legs setLinePrice(int i, LinePrice linePrice) {
                if (linePrice != null) {
                    this.f10276V.set(i, linePrice);
                }
                return this;
            }

            public Legs setPlanStatus(int i) {
                this.f10279Y = true;
                this.f10280Z = i;
                return this;
            }

            public Legs setPlanType(int i) {
                this.aa = true;
                this.ab = i;
                return this;
            }

            public Legs setPrice(String str) {
                this.f10306z = true;
                this.f10255A = str;
                return this;
            }

            public Legs setRtbusUpdateTime(int i) {
                this.f10268N = true;
                this.f10269O = i;
                return this;
            }

            public Legs setSendLocation(int i, int i2) {
                this.f10260F.set(i, Integer.valueOf(i2));
                return this;
            }

            public Legs setSstartLocation(int i, int i2) {
                this.f10261G.set(i, Integer.valueOf(i2));
                return this;
            }

            public Legs setStartAddress(String str) {
                this.f10298r = true;
                this.f10299s = str;
                return this;
            }

            public Legs setStartLocation(String str) {
                this.f10288h = true;
                this.f10289i = str;
                return this;
            }

            public Legs setStartPano(StartPano startPano) {
                if (startPano == null) {
                    return clearStartPano();
                }
                this.f10272R = true;
                this.f10273S = startPano;
                return this;
            }

            public Legs setStartTime(String str) {
                this.f10302v = true;
                this.f10303w = str;
                return this;
            }

            public Legs setSteps(int i, Steps steps) {
                if (steps != null) {
                    this.f10281a.set(i, steps);
                }
                return this;
            }

            public Legs setTip(int i) {
                this.f10290j = true;
                this.f10291k = i;
                return this;
            }

            public Legs setTipBackground(String str) {
                this.f10294n = true;
                this.f10295o = str;
                return this;
            }

            public Legs setTipLabel(String str) {
                this.f10262H = true;
                this.f10263I = str;
                return this;
            }

            public Legs setTipLabelBackground(String str) {
                this.f10264J = true;
                this.f10265K = str;
                return this;
            }

            public Legs setTipLabelText(String str) {
                this.ac = true;
                this.ad = str;
                return this;
            }

            public Legs setTipRtbus(String str) {
                this.f10266L = true;
                this.f10267M = str;
                return this;
            }

            public Legs setTipText(String str) {
                this.f10292l = true;
                this.f10293m = str;
                return this;
            }

            public Legs setTrafficType(int i) {
                this.f10270P = true;
                this.f10271Q = i;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasDistance()) {
                    codedOutputStreamMicro.writeInt32(1, getDistance());
                }
                if (hasDuration()) {
                    codedOutputStreamMicro.writeInt32(2, getDuration());
                }
                if (hasEndLocation()) {
                    codedOutputStreamMicro.writeString(3, getEndLocation());
                }
                if (hasStartLocation()) {
                    codedOutputStreamMicro.writeString(4, getStartLocation());
                }
                if (hasTip()) {
                    codedOutputStreamMicro.writeInt32(5, getTip());
                }
                if (hasTipText()) {
                    codedOutputStreamMicro.writeString(6, getTipText());
                }
                if (hasTipBackground()) {
                    codedOutputStreamMicro.writeString(7, getTipBackground());
                }
                if (hasArriveTime()) {
                    codedOutputStreamMicro.writeString(8, getArriveTime());
                }
                for (Steps writeMessage : getStepsList()) {
                    codedOutputStreamMicro.writeMessage(11, writeMessage);
                }
                if (hasStartAddress()) {
                    codedOutputStreamMicro.writeString(12, getStartAddress());
                }
                if (hasEndAddress()) {
                    codedOutputStreamMicro.writeString(13, getEndAddress());
                }
                if (hasStartTime()) {
                    codedOutputStreamMicro.writeString(14, getStartTime());
                }
                if (hasEndTime()) {
                    codedOutputStreamMicro.writeString(15, getEndTime());
                }
                if (hasPrice()) {
                    codedOutputStreamMicro.writeString(16, getPrice());
                }
                if (hasDiscount()) {
                    codedOutputStreamMicro.writeString(17, getDiscount());
                }
                if (hasInstructions()) {
                    codedOutputStreamMicro.writeString(18, getInstructions());
                }
                for (Integer intValue : getSendLocationList()) {
                    codedOutputStreamMicro.writeSInt32(19, intValue.intValue());
                }
                for (Integer intValue2 : getSstartLocationList()) {
                    codedOutputStreamMicro.writeSInt32(20, intValue2.intValue());
                }
                if (hasTipLabel()) {
                    codedOutputStreamMicro.writeString(21, getTipLabel());
                }
                if (hasTipLabelBackground()) {
                    codedOutputStreamMicro.writeString(22, getTipLabelBackground());
                }
                if (hasTipRtbus()) {
                    codedOutputStreamMicro.writeString(23, getTipRtbus());
                }
                if (hasRtbusUpdateTime()) {
                    codedOutputStreamMicro.writeInt32(24, getRtbusUpdateTime());
                }
                if (hasTrafficType()) {
                    codedOutputStreamMicro.writeInt32(25, getTrafficType());
                }
                if (hasStartPano()) {
                    codedOutputStreamMicro.writeMessage(26, getStartPano());
                }
                if (hasEndPano()) {
                    codedOutputStreamMicro.writeMessage(27, getEndPano());
                }
                for (LinePrice writeMessage2 : getLinePriceList()) {
                    codedOutputStreamMicro.writeMessage(28, writeMessage2);
                }
                if (hasComfort()) {
                    codedOutputStreamMicro.writeString(29, getComfort());
                }
                if (hasPlanStatus()) {
                    codedOutputStreamMicro.writeInt32(30, getPlanStatus());
                }
                if (hasPlanType()) {
                    codedOutputStreamMicro.writeInt32(31, getPlanType());
                }
                if (hasTipLabelText()) {
                    codedOutputStreamMicro.writeString(32, getTipLabelText());
                }
            }
        }

        public static Routes parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Routes().mergeFrom(codedInputStreamMicro);
        }

        public static Routes parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Routes) new Routes().mergeFrom(bArr);
        }

        public Routes addLegs(Legs legs) {
            if (legs != null) {
                if (this.f10307a.isEmpty()) {
                    this.f10307a = new ArrayList();
                }
                this.f10307a.add(legs);
            }
            return this;
        }

        public final Routes clear() {
            clearLegs();
            this.f10308b = -1;
            return this;
        }

        public Routes clearLegs() {
            this.f10307a = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f10308b < 0) {
                getSerializedSize();
            }
            return this.f10308b;
        }

        public Legs getLegs(int i) {
            return (Legs) this.f10307a.get(i);
        }

        public int getLegsCount() {
            return this.f10307a.size();
        }

        public List<Legs> getLegsList() {
            return this.f10307a;
        }

        public int getSerializedSize() {
            int i = 0;
            for (Legs computeMessageSize : getLegsList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            this.f10308b = i;
            return i;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Routes mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        MessageMicro legs = new Legs();
                        codedInputStreamMicro.readMessage(legs);
                        addLegs(legs);
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

        public Routes setLegs(int i, Legs legs) {
            if (legs != null) {
                this.f10307a.set(i, legs);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (Legs writeMessage : getLegsList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
        }
    }

    public static final class Taxi extends MessageMicro {
        public static final int DETAIL_FIELD_NUMBER = 4;
        public static final int DISTANCE_FIELD_NUMBER = 1;
        public static final int DURATION_FIELD_NUMBER = 2;
        public static final int REMARK_FIELD_NUMBER = 3;
        /* renamed from: a */
        private boolean f10318a;
        /* renamed from: b */
        private int f10319b = 0;
        /* renamed from: c */
        private boolean f10320c;
        /* renamed from: d */
        private int f10321d = 0;
        /* renamed from: e */
        private boolean f10322e;
        /* renamed from: f */
        private String f10323f = "";
        /* renamed from: g */
        private List<Detail> f10324g = Collections.emptyList();
        /* renamed from: h */
        private int f10325h = -1;

        public static final class Detail extends MessageMicro {
            public static final int DESC_FIELD_NUMBER = 1;
            public static final int KM_PRICE_FIELD_NUMBER = 2;
            public static final int START_PRICE_FIELD_NUMBER = 3;
            public static final int TOTAL_PRICE_FIELD_NUMBER = 4;
            /* renamed from: a */
            private boolean f10309a;
            /* renamed from: b */
            private String f10310b = "";
            /* renamed from: c */
            private boolean f10311c;
            /* renamed from: d */
            private String f10312d = "";
            /* renamed from: e */
            private boolean f10313e;
            /* renamed from: f */
            private String f10314f = "";
            /* renamed from: g */
            private boolean f10315g;
            /* renamed from: h */
            private String f10316h = "";
            /* renamed from: i */
            private int f10317i = -1;

            public static Detail parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Detail().mergeFrom(codedInputStreamMicro);
            }

            public static Detail parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Detail) new Detail().mergeFrom(bArr);
            }

            public final Detail clear() {
                clearDesc();
                clearKmPrice();
                clearStartPrice();
                clearTotalPrice();
                this.f10317i = -1;
                return this;
            }

            public Detail clearDesc() {
                this.f10309a = false;
                this.f10310b = "";
                return this;
            }

            public Detail clearKmPrice() {
                this.f10311c = false;
                this.f10312d = "";
                return this;
            }

            public Detail clearStartPrice() {
                this.f10313e = false;
                this.f10314f = "";
                return this;
            }

            public Detail clearTotalPrice() {
                this.f10315g = false;
                this.f10316h = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f10317i < 0) {
                    getSerializedSize();
                }
                return this.f10317i;
            }

            public String getDesc() {
                return this.f10310b;
            }

            public String getKmPrice() {
                return this.f10312d;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasDesc()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getDesc());
                }
                if (hasKmPrice()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getKmPrice());
                }
                if (hasStartPrice()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getStartPrice());
                }
                if (hasTotalPrice()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getTotalPrice());
                }
                this.f10317i = i;
                return i;
            }

            public String getStartPrice() {
                return this.f10314f;
            }

            public String getTotalPrice() {
                return this.f10316h;
            }

            public boolean hasDesc() {
                return this.f10309a;
            }

            public boolean hasKmPrice() {
                return this.f10311c;
            }

            public boolean hasStartPrice() {
                return this.f10313e;
            }

            public boolean hasTotalPrice() {
                return this.f10315g;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Detail mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setDesc(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setKmPrice(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setStartPrice(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setTotalPrice(codedInputStreamMicro.readString());
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

            public Detail setDesc(String str) {
                this.f10309a = true;
                this.f10310b = str;
                return this;
            }

            public Detail setKmPrice(String str) {
                this.f10311c = true;
                this.f10312d = str;
                return this;
            }

            public Detail setStartPrice(String str) {
                this.f10313e = true;
                this.f10314f = str;
                return this;
            }

            public Detail setTotalPrice(String str) {
                this.f10315g = true;
                this.f10316h = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasDesc()) {
                    codedOutputStreamMicro.writeString(1, getDesc());
                }
                if (hasKmPrice()) {
                    codedOutputStreamMicro.writeString(2, getKmPrice());
                }
                if (hasStartPrice()) {
                    codedOutputStreamMicro.writeString(3, getStartPrice());
                }
                if (hasTotalPrice()) {
                    codedOutputStreamMicro.writeString(4, getTotalPrice());
                }
            }
        }

        public static Taxi parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Taxi().mergeFrom(codedInputStreamMicro);
        }

        public static Taxi parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Taxi) new Taxi().mergeFrom(bArr);
        }

        public Taxi addDetail(Detail detail) {
            if (detail != null) {
                if (this.f10324g.isEmpty()) {
                    this.f10324g = new ArrayList();
                }
                this.f10324g.add(detail);
            }
            return this;
        }

        public final Taxi clear() {
            clearDistance();
            clearDuration();
            clearRemark();
            clearDetail();
            this.f10325h = -1;
            return this;
        }

        public Taxi clearDetail() {
            this.f10324g = Collections.emptyList();
            return this;
        }

        public Taxi clearDistance() {
            this.f10318a = false;
            this.f10319b = 0;
            return this;
        }

        public Taxi clearDuration() {
            this.f10320c = false;
            this.f10321d = 0;
            return this;
        }

        public Taxi clearRemark() {
            this.f10322e = false;
            this.f10323f = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f10325h < 0) {
                getSerializedSize();
            }
            return this.f10325h;
        }

        public Detail getDetail(int i) {
            return (Detail) this.f10324g.get(i);
        }

        public int getDetailCount() {
            return this.f10324g.size();
        }

        public List<Detail> getDetailList() {
            return this.f10324g;
        }

        public int getDistance() {
            return this.f10319b;
        }

        public int getDuration() {
            return this.f10321d;
        }

        public String getRemark() {
            return this.f10323f;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasDistance()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getDistance());
            }
            if (hasDuration()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getDuration());
            }
            if (hasRemark()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getRemark());
            }
            int i2 = i;
            for (Detail computeMessageSize : getDetailList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(4, computeMessageSize) + i2;
            }
            this.f10325h = i2;
            return i2;
        }

        public boolean hasDistance() {
            return this.f10318a;
        }

        public boolean hasDuration() {
            return this.f10320c;
        }

        public boolean hasRemark() {
            return this.f10322e;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Taxi mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setDistance(codedInputStreamMicro.readInt32());
                        continue;
                    case 16:
                        setDuration(codedInputStreamMicro.readInt32());
                        continue;
                    case 26:
                        setRemark(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        MessageMicro detail = new Detail();
                        codedInputStreamMicro.readMessage(detail);
                        addDetail(detail);
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

        public Taxi setDetail(int i, Detail detail) {
            if (detail != null) {
                this.f10324g.set(i, detail);
            }
            return this;
        }

        public Taxi setDistance(int i) {
            this.f10318a = true;
            this.f10319b = i;
            return this;
        }

        public Taxi setDuration(int i) {
            this.f10320c = true;
            this.f10321d = i;
            return this;
        }

        public Taxi setRemark(String str) {
            this.f10322e = true;
            this.f10323f = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasDistance()) {
                codedOutputStreamMicro.writeInt32(1, getDistance());
            }
            if (hasDuration()) {
                codedOutputStreamMicro.writeInt32(2, getDuration());
            }
            if (hasRemark()) {
                codedOutputStreamMicro.writeString(3, getRemark());
            }
            for (Detail writeMessage : getDetailList()) {
                codedOutputStreamMicro.writeMessage(4, writeMessage);
            }
        }
    }

    public static final class Walk extends MessageMicro {
        public static final int DISTANCE_FIELD_NUMBER = 3;
        public static final int IS_BETTER_FIELD_NUMBER = 1;
        public static final int TIME_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f10326a;
        /* renamed from: b */
        private int f10327b = 0;
        /* renamed from: c */
        private boolean f10328c;
        /* renamed from: d */
        private String f10329d = "";
        /* renamed from: e */
        private boolean f10330e;
        /* renamed from: f */
        private String f10331f = "";
        /* renamed from: g */
        private int f10332g = -1;

        public static Walk parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Walk().mergeFrom(codedInputStreamMicro);
        }

        public static Walk parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Walk) new Walk().mergeFrom(bArr);
        }

        public final Walk clear() {
            clearIsBetter();
            clearTime();
            clearDistance();
            this.f10332g = -1;
            return this;
        }

        public Walk clearDistance() {
            this.f10330e = false;
            this.f10331f = "";
            return this;
        }

        public Walk clearIsBetter() {
            this.f10326a = false;
            this.f10327b = 0;
            return this;
        }

        public Walk clearTime() {
            this.f10328c = false;
            this.f10329d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f10332g < 0) {
                getSerializedSize();
            }
            return this.f10332g;
        }

        public String getDistance() {
            return this.f10331f;
        }

        public int getIsBetter() {
            return this.f10327b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasIsBetter()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIsBetter());
            }
            if (hasTime()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getTime());
            }
            if (hasDistance()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getDistance());
            }
            this.f10332g = i;
            return i;
        }

        public String getTime() {
            return this.f10329d;
        }

        public boolean hasDistance() {
            return this.f10330e;
        }

        public boolean hasIsBetter() {
            return this.f10326a;
        }

        public boolean hasTime() {
            return this.f10328c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Walk mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setIsBetter(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setTime(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setDistance(codedInputStreamMicro.readString());
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

        public Walk setDistance(String str) {
            this.f10330e = true;
            this.f10331f = str;
            return this;
        }

        public Walk setIsBetter(int i) {
            this.f10326a = true;
            this.f10327b = i;
            return this;
        }

        public Walk setTime(String str) {
            this.f10328c = true;
            this.f10329d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIsBetter()) {
                codedOutputStreamMicro.writeInt32(1, getIsBetter());
            }
            if (hasTime()) {
                codedOutputStreamMicro.writeString(2, getTime());
            }
            if (hasDistance()) {
                codedOutputStreamMicro.writeString(3, getDistance());
            }
        }
    }

    public static final class Zhuanche extends MessageMicro {
        public static final int BUTTON_FIELD_NUMBER = 2;
        public static final int FEE_DESC_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f10338a;
        /* renamed from: b */
        private String f10339b = "";
        /* renamed from: c */
        private boolean f10340c;
        /* renamed from: d */
        private Button f10341d = null;
        /* renamed from: e */
        private int f10342e = -1;

        public static final class Button extends MessageMicro {
            public static final int PARAMS_FIELD_NUMBER = 2;
            public static final int TEXT_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f10333a;
            /* renamed from: b */
            private String f10334b = "";
            /* renamed from: c */
            private boolean f10335c;
            /* renamed from: d */
            private String f10336d = "";
            /* renamed from: e */
            private int f10337e = -1;

            public static Button parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Button().mergeFrom(codedInputStreamMicro);
            }

            public static Button parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Button) new Button().mergeFrom(bArr);
            }

            public final Button clear() {
                clearText();
                clearParams();
                this.f10337e = -1;
                return this;
            }

            public Button clearParams() {
                this.f10335c = false;
                this.f10336d = "";
                return this;
            }

            public Button clearText() {
                this.f10333a = false;
                this.f10334b = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f10337e < 0) {
                    getSerializedSize();
                }
                return this.f10337e;
            }

            public String getParams() {
                return this.f10336d;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasText()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getText());
                }
                if (hasParams()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getParams());
                }
                this.f10337e = i;
                return i;
            }

            public String getText() {
                return this.f10334b;
            }

            public boolean hasParams() {
                return this.f10335c;
            }

            public boolean hasText() {
                return this.f10333a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Button mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setText(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setParams(codedInputStreamMicro.readString());
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

            public Button setParams(String str) {
                this.f10335c = true;
                this.f10336d = str;
                return this;
            }

            public Button setText(String str) {
                this.f10333a = true;
                this.f10334b = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasText()) {
                    codedOutputStreamMicro.writeString(1, getText());
                }
                if (hasParams()) {
                    codedOutputStreamMicro.writeString(2, getParams());
                }
            }
        }

        public static Zhuanche parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Zhuanche().mergeFrom(codedInputStreamMicro);
        }

        public static Zhuanche parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Zhuanche) new Zhuanche().mergeFrom(bArr);
        }

        public final Zhuanche clear() {
            clearFeeDesc();
            clearButton();
            this.f10342e = -1;
            return this;
        }

        public Zhuanche clearButton() {
            this.f10340c = false;
            this.f10341d = null;
            return this;
        }

        public Zhuanche clearFeeDesc() {
            this.f10338a = false;
            this.f10339b = "";
            return this;
        }

        public Button getButton() {
            return this.f10341d;
        }

        public int getCachedSize() {
            if (this.f10342e < 0) {
                getSerializedSize();
            }
            return this.f10342e;
        }

        public String getFeeDesc() {
            return this.f10339b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasFeeDesc()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getFeeDesc());
            }
            if (hasButton()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getButton());
            }
            this.f10342e = i;
            return i;
        }

        public boolean hasButton() {
            return this.f10340c;
        }

        public boolean hasFeeDesc() {
            return this.f10338a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Zhuanche mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setFeeDesc(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        MessageMicro button = new Button();
                        codedInputStreamMicro.readMessage(button);
                        setButton(button);
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

        public Zhuanche setButton(Button button) {
            if (button == null) {
                return clearButton();
            }
            this.f10340c = true;
            this.f10341d = button;
            return this;
        }

        public Zhuanche setFeeDesc(String str) {
            this.f10338a = true;
            this.f10339b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasFeeDesc()) {
                codedOutputStreamMicro.writeString(1, getFeeDesc());
            }
            if (hasButton()) {
                codedOutputStreamMicro.writeMessage(2, getButton());
            }
        }
    }

    public static Bus parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Bus().mergeFrom(codedInputStreamMicro);
    }

    public static Bus parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Bus) new Bus().mergeFrom(bArr);
    }

    public Bus addRoutes(Routes routes) {
        if (routes != null) {
            if (this.f10347e.isEmpty()) {
                this.f10347e = new ArrayList();
            }
            this.f10347e.add(routes);
        }
        return this;
    }

    public final Bus clear() {
        clearTaxi();
        clearCurrentCity();
        clearRoutes();
        clearOption();
        clearZhuanche();
        clearEmergencyTip();
        clearRedisKey();
        clearWalk();
        clearCycle();
        this.f10360r = -1;
        return this;
    }

    public Bus clearCurrentCity() {
        this.f10345c = false;
        this.f10346d = null;
        return this;
    }

    public Bus clearCycle() {
        this.f10358p = false;
        this.f10359q = null;
        return this;
    }

    public Bus clearEmergencyTip() {
        this.f10352j = false;
        this.f10353k = "";
        return this;
    }

    public Bus clearOption() {
        this.f10348f = false;
        this.f10349g = null;
        return this;
    }

    public Bus clearRedisKey() {
        this.f10354l = false;
        this.f10355m = "";
        return this;
    }

    public Bus clearRoutes() {
        this.f10347e = Collections.emptyList();
        return this;
    }

    public Bus clearTaxi() {
        this.f10343a = false;
        this.f10344b = null;
        return this;
    }

    public Bus clearWalk() {
        this.f10356n = false;
        this.f10357o = null;
        return this;
    }

    public Bus clearZhuanche() {
        this.f10350h = false;
        this.f10351i = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f10360r < 0) {
            getSerializedSize();
        }
        return this.f10360r;
    }

    public CurrentCity getCurrentCity() {
        return this.f10346d;
    }

    public Cycle getCycle() {
        return this.f10359q;
    }

    public String getEmergencyTip() {
        return this.f10353k;
    }

    public Option getOption() {
        return this.f10349g;
    }

    public String getRedisKey() {
        return this.f10355m;
    }

    public Routes getRoutes(int i) {
        return (Routes) this.f10347e.get(i);
    }

    public int getRoutesCount() {
        return this.f10347e.size();
    }

    public List<Routes> getRoutesList() {
        return this.f10347e;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasTaxi()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getTaxi());
        }
        if (hasCurrentCity()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getCurrentCity());
        }
        int i2 = i;
        for (Routes computeMessageSize : getRoutesList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
        }
        if (hasOption()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(4, getOption());
        }
        if (hasZhuanche()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(5, getZhuanche());
        }
        if (hasEmergencyTip()) {
            i2 += CodedOutputStreamMicro.computeStringSize(6, getEmergencyTip());
        }
        if (hasRedisKey()) {
            i2 += CodedOutputStreamMicro.computeStringSize(7, getRedisKey());
        }
        if (hasWalk()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(8, getWalk());
        }
        if (hasCycle()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(9, getCycle());
        }
        this.f10360r = i2;
        return i2;
    }

    public Taxi getTaxi() {
        return this.f10344b;
    }

    public Walk getWalk() {
        return this.f10357o;
    }

    public Zhuanche getZhuanche() {
        return this.f10351i;
    }

    public boolean hasCurrentCity() {
        return this.f10345c;
    }

    public boolean hasCycle() {
        return this.f10358p;
    }

    public boolean hasEmergencyTip() {
        return this.f10352j;
    }

    public boolean hasOption() {
        return this.f10348f;
    }

    public boolean hasRedisKey() {
        return this.f10354l;
    }

    public boolean hasTaxi() {
        return this.f10343a;
    }

    public boolean hasWalk() {
        return this.f10356n;
    }

    public boolean hasZhuanche() {
        return this.f10350h;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Bus mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro taxi;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    taxi = new Taxi();
                    codedInputStreamMicro.readMessage(taxi);
                    setTaxi(taxi);
                    continue;
                case 18:
                    taxi = new CurrentCity();
                    codedInputStreamMicro.readMessage(taxi);
                    setCurrentCity(taxi);
                    continue;
                case 26:
                    taxi = new Routes();
                    codedInputStreamMicro.readMessage(taxi);
                    addRoutes(taxi);
                    continue;
                case 34:
                    taxi = new Option();
                    codedInputStreamMicro.readMessage(taxi);
                    setOption(taxi);
                    continue;
                case 42:
                    taxi = new Zhuanche();
                    codedInputStreamMicro.readMessage(taxi);
                    setZhuanche(taxi);
                    continue;
                case 50:
                    setEmergencyTip(codedInputStreamMicro.readString());
                    continue;
                case 58:
                    setRedisKey(codedInputStreamMicro.readString());
                    continue;
                case 66:
                    taxi = new Walk();
                    codedInputStreamMicro.readMessage(taxi);
                    setWalk(taxi);
                    continue;
                case 74:
                    taxi = new Cycle();
                    codedInputStreamMicro.readMessage(taxi);
                    setCycle(taxi);
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

    public Bus setCurrentCity(CurrentCity currentCity) {
        if (currentCity == null) {
            return clearCurrentCity();
        }
        this.f10345c = true;
        this.f10346d = currentCity;
        return this;
    }

    public Bus setCycle(Cycle cycle) {
        if (cycle == null) {
            return clearCycle();
        }
        this.f10358p = true;
        this.f10359q = cycle;
        return this;
    }

    public Bus setEmergencyTip(String str) {
        this.f10352j = true;
        this.f10353k = str;
        return this;
    }

    public Bus setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f10348f = true;
        this.f10349g = option;
        return this;
    }

    public Bus setRedisKey(String str) {
        this.f10354l = true;
        this.f10355m = str;
        return this;
    }

    public Bus setRoutes(int i, Routes routes) {
        if (routes != null) {
            this.f10347e.set(i, routes);
        }
        return this;
    }

    public Bus setTaxi(Taxi taxi) {
        if (taxi == null) {
            return clearTaxi();
        }
        this.f10343a = true;
        this.f10344b = taxi;
        return this;
    }

    public Bus setWalk(Walk walk) {
        if (walk == null) {
            return clearWalk();
        }
        this.f10356n = true;
        this.f10357o = walk;
        return this;
    }

    public Bus setZhuanche(Zhuanche zhuanche) {
        if (zhuanche == null) {
            return clearZhuanche();
        }
        this.f10350h = true;
        this.f10351i = zhuanche;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasTaxi()) {
            codedOutputStreamMicro.writeMessage(1, getTaxi());
        }
        if (hasCurrentCity()) {
            codedOutputStreamMicro.writeMessage(2, getCurrentCity());
        }
        for (Routes writeMessage : getRoutesList()) {
            codedOutputStreamMicro.writeMessage(3, writeMessage);
        }
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(4, getOption());
        }
        if (hasZhuanche()) {
            codedOutputStreamMicro.writeMessage(5, getZhuanche());
        }
        if (hasEmergencyTip()) {
            codedOutputStreamMicro.writeString(6, getEmergencyTip());
        }
        if (hasRedisKey()) {
            codedOutputStreamMicro.writeString(7, getRedisKey());
        }
        if (hasWalk()) {
            codedOutputStreamMicro.writeMessage(8, getWalk());
        }
        if (hasCycle()) {
            codedOutputStreamMicro.writeMessage(9, getCycle());
        }
    }
}
