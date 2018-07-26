package com.baidu.entity.pb;

import com.baidu.baidunavis.model.NavCarInfo;
import com.baidu.carlife.core.C1253f;
import com.baidu.che.codriver.p123i.C2546c;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams.NE_RoutePlan_Result;
import com.baidu.navisdk.ui.routeguide.model.RGHUDDataModel;
import com.baidu.platform.comapi.map.provider.BusRouteProvider;
import com.baidu.platform.comapi.map.provider.RouteLineResConst;
import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Inf extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 2;
    public static final int CURRENT_CITY_FIELD_NUMBER = 3;
    public static final int OFFLINE_FIELD_NUMBER = 4;
    public static final int OPTION_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f11833a;
    /* renamed from: b */
    private Option f11834b = null;
    /* renamed from: c */
    private boolean f11835c;
    /* renamed from: d */
    private Content f11836d = null;
    /* renamed from: e */
    private boolean f11837e;
    /* renamed from: f */
    private CurrentCity f11838f = null;
    /* renamed from: g */
    private boolean f11839g;
    /* renamed from: h */
    private int f11840h = 0;
    /* renamed from: i */
    private int f11841i = -1;

    public static final class Content extends MessageMicro {
        public static final int ADDR_FIELD_NUMBER = 1;
        public static final int ALIAS_FIELD_NUMBER = 18;
        public static final int AOI_FIELD_NUMBER = 19;
        public static final int AREA_FIELD_NUMBER = 14;
        public static final int BAR_TEMPLATE_FIELD_NUMBER = 46;
        public static final int BLINFO_FIELD_NUMBER = 17;
        public static final int BUTTON_FIELD_NUMBER = 42;
        public static final int CITY_ID_FIELD_NUMBER = 2;
        public static final int CLOUD_TEMPLATE_FIELD_NUMBER = 38;
        public static final int CP_FIELD_NUMBER = 20;
        public static final int DETAIL_FIELD_NUMBER = 21;
        public static final int DYNAMICCLICK_FIELD_NUMBER = 45;
        public static final int EXT_FIELD_NUMBER = 3;
        public static final int EXT_TYPE_FIELD_NUMBER = 4;
        public static final int GEO_FIELD_NUMBER = 5;
        public static final int HEAD_ICON_FIELD_NUMBER = 50;
        public static final int HEAT_MAP_FIELD_NUMBER = 33;
        public static final int ICON_ID_FIELD_NUMBER = 40;
        public static final int INDOOR_FLOOR_FIELD_NUMBER = 36;
        public static final int INDOOR_OVER_LOOKING_FIELD_NUMBER = 51;
        public static final int INDOOR_PANO_FIELD_NUMBER = 22;
        public static final int INDOOR_PARENT_UID_FIELD_NUMBER = 37;
        public static final int ISMODIFIED_FIELD_NUMBER = 44;
        public static final int NAME_FIELD_NUMBER = 6;
        public static final int NEW_CATALOG_ID_FIELD_NUMBER = 23;
        public static final int ORIGIN_ID_FIELD_NUMBER = 24;
        public static final int OTHER_STATIONS_FIELD_NUMBER = 39;
        public static final int PANO_FIELD_NUMBER = 25;
        public static final int PHONE_FIELD_NUMBER = 15;
        public static final int PHOTO_LIST_FIELD_NUMBER = 49;
        public static final int POITYPE_FIELD_NUMBER = 7;
        public static final int POI_TYPE_TEXT_FIELD_NUMBER = 32;
        public static final int PRIMARY_UID_FIELD_NUMBER = 8;
        public static final int RP_DES_FIELD_NUMBER = 26;
        public static final int RP_DES_TYPE_FIELD_NUMBER = 9;
        public static final int RTBUS_UPDATE_TIME_FIELD_NUMBER = 31;
        public static final int SERVICE_TAG_FIELD_NUMBER = 48;
        public static final int STATION_NUM_FIELD_NUMBER = 41;
        public static final int STATUS_FIELD_NUMBER = 10;
        public static final int STD_TAG_FIELD_NUMBER = 47;
        public static final int STORAGE_SRC_FIELD_NUMBER = 11;
        public static final int STREET_ID_FIELD_NUMBER = 27;
        public static final int SUSPECTED_FLAG_FIELD_NUMBER = 12;
        public static final int TAG_FIELD_NUMBER = 28;
        public static final int TEL_FIELD_NUMBER = 29;
        public static final int TY_FIELD_NUMBER = 30;
        public static final int UID_FIELD_NUMBER = 13;
        public static final int VISTA_FIELD_NUMBER = 16;
        /* renamed from: A */
        private String f11750A = "";
        /* renamed from: B */
        private boolean f11751B;
        /* renamed from: C */
        private int f11752C = 0;
        /* renamed from: D */
        private boolean f11753D;
        /* renamed from: E */
        private String f11754E = "";
        /* renamed from: F */
        private boolean f11755F;
        /* renamed from: G */
        private int f11756G = 0;
        /* renamed from: H */
        private boolean f11757H;
        /* renamed from: I */
        private String f11758I = "";
        /* renamed from: J */
        private boolean f11759J;
        /* renamed from: K */
        private String f11760K = "";
        /* renamed from: L */
        private List<String> f11761L = Collections.emptyList();
        /* renamed from: M */
        private boolean f11762M;
        /* renamed from: N */
        private String f11763N = "";
        /* renamed from: O */
        private boolean f11764O;
        /* renamed from: P */
        private String f11765P = "";
        /* renamed from: Q */
        private boolean f11766Q;
        /* renamed from: R */
        private int f11767R = 0;
        /* renamed from: S */
        private boolean f11768S;
        /* renamed from: T */
        private String f11769T = "";
        /* renamed from: U */
        private boolean f11770U;
        /* renamed from: V */
        private String f11771V = "";
        /* renamed from: W */
        private boolean f11772W;
        /* renamed from: X */
        private int f11773X = 0;
        /* renamed from: Y */
        private boolean f11774Y;
        /* renamed from: Z */
        private String f11775Z = "";
        /* renamed from: a */
        private boolean f11776a;
        private int aA = 0;
        private boolean aB;
        private ByteStringMicro aC = ByteStringMicro.EMPTY;
        private boolean aD;
        private ByteStringMicro aE = ByteStringMicro.EMPTY;
        private boolean aF;
        private String aG = "";
        private boolean aH;
        private String aI = "";
        private boolean aJ;
        private String aK = "";
        private boolean aL;
        private HeadIcon aM = null;
        private boolean aN;
        private int aO = 0;
        private int aP = -1;
        private boolean aa;
        private String ab = "";
        private boolean ac;
        private String ad = "";
        private boolean ae;
        private String af = "";
        private boolean ag;
        private int ah = 0;
        private boolean ai;
        private int aj = 0;
        private boolean ak;
        private String al = "";
        private boolean am;
        private String an = "";
        private boolean ao;
        private String ap = "";
        private boolean aq;
        private ByteStringMicro ar = ByteStringMicro.EMPTY;
        private List<OtherStations> as = Collections.emptyList();
        private boolean at;
        private int au = 0;
        private boolean av;
        private String aw = "";
        private boolean ax;
        private Button ay = null;
        private boolean az;
        /* renamed from: b */
        private Ext f11777b = null;
        /* renamed from: c */
        private List<Blinfo> f11778c = Collections.emptyList();
        /* renamed from: d */
        private boolean f11779d;
        /* renamed from: e */
        private OriginId f11780e = null;
        /* renamed from: f */
        private boolean f11781f;
        /* renamed from: g */
        private HeatMap f11782g = null;
        /* renamed from: h */
        private boolean f11783h;
        /* renamed from: i */
        private String f11784i = "";
        /* renamed from: j */
        private boolean f11785j;
        /* renamed from: k */
        private int f11786k = 0;
        /* renamed from: l */
        private boolean f11787l;
        /* renamed from: m */
        private int f11788m = 0;
        /* renamed from: n */
        private boolean f11789n;
        /* renamed from: o */
        private String f11790o = "";
        /* renamed from: p */
        private boolean f11791p;
        /* renamed from: q */
        private String f11792q = "";
        /* renamed from: r */
        private boolean f11793r;
        /* renamed from: s */
        private int f11794s = 0;
        /* renamed from: t */
        private boolean f11795t;
        /* renamed from: u */
        private String f11796u = "";
        /* renamed from: v */
        private boolean f11797v;
        /* renamed from: w */
        private int f11798w = 0;
        /* renamed from: x */
        private boolean f11799x;
        /* renamed from: y */
        private int f11800y = 0;
        /* renamed from: z */
        private boolean f11801z;

        public static final class Blinfo extends MessageMicro {
            public static final int ADDR_FIELD_NUMBER = 1;
            public static final int ICON_ID_FIELD_NUMBER = 7;
            public static final int NAME_FIELD_NUMBER = 2;
            public static final int NEXT_STATION_FIELD_NUMBER = 6;
            public static final int PAIR_UID_FIELD_NUMBER = 5;
            public static final int RT_INFO_FIELD_NUMBER = 3;
            public static final int SON_UID_FIELD_NUMBER = 8;
            public static final int UID_FIELD_NUMBER = 4;
            /* renamed from: a */
            private boolean f11311a;
            /* renamed from: b */
            private RtInfo f11312b = null;
            /* renamed from: c */
            private boolean f11313c;
            /* renamed from: d */
            private String f11314d = "";
            /* renamed from: e */
            private boolean f11315e;
            /* renamed from: f */
            private String f11316f = "";
            /* renamed from: g */
            private boolean f11317g;
            /* renamed from: h */
            private String f11318h = "";
            /* renamed from: i */
            private boolean f11319i;
            /* renamed from: j */
            private String f11320j = "";
            /* renamed from: k */
            private boolean f11321k;
            /* renamed from: l */
            private String f11322l = "";
            /* renamed from: m */
            private boolean f11323m;
            /* renamed from: n */
            private int f11324n = 0;
            /* renamed from: o */
            private boolean f11325o;
            /* renamed from: p */
            private String f11326p = "";
            /* renamed from: q */
            private int f11327q = -1;

            public static final class RtInfo extends MessageMicro {
                public static final int NEXT_VEHICLE_FIELD_NUMBER = 1;
                public static final int TIP_RTBUS_FIELD_NUMBER = 2;
                /* renamed from: a */
                private boolean f11306a;
                /* renamed from: b */
                private NextVehicle f11307b = null;
                /* renamed from: c */
                private boolean f11308c;
                /* renamed from: d */
                private String f11309d = "";
                /* renamed from: e */
                private int f11310e = -1;

                public static final class NextVehicle extends MessageMicro {
                    public static final int REMAIN_DIST_FIELD_NUMBER = 1;
                    public static final int REMAIN_STOPS_FIELD_NUMBER = 2;
                    public static final int REMAIN_TIME_FIELD_NUMBER = 3;
                    /* renamed from: a */
                    private boolean f11299a;
                    /* renamed from: b */
                    private int f11300b = 0;
                    /* renamed from: c */
                    private boolean f11301c;
                    /* renamed from: d */
                    private int f11302d = 0;
                    /* renamed from: e */
                    private boolean f11303e;
                    /* renamed from: f */
                    private int f11304f = 0;
                    /* renamed from: g */
                    private int f11305g = -1;

                    public static NextVehicle parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new NextVehicle().mergeFrom(codedInputStreamMicro);
                    }

                    public static NextVehicle parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (NextVehicle) new NextVehicle().mergeFrom(bArr);
                    }

                    public final NextVehicle clear() {
                        clearRemainDist();
                        clearRemainStops();
                        clearRemainTime();
                        this.f11305g = -1;
                        return this;
                    }

                    public NextVehicle clearRemainDist() {
                        this.f11299a = false;
                        this.f11300b = 0;
                        return this;
                    }

                    public NextVehicle clearRemainStops() {
                        this.f11301c = false;
                        this.f11302d = 0;
                        return this;
                    }

                    public NextVehicle clearRemainTime() {
                        this.f11303e = false;
                        this.f11304f = 0;
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f11305g < 0) {
                            getSerializedSize();
                        }
                        return this.f11305g;
                    }

                    public int getRemainDist() {
                        return this.f11300b;
                    }

                    public int getRemainStops() {
                        return this.f11302d;
                    }

                    public int getRemainTime() {
                        return this.f11304f;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasRemainDist()) {
                            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getRemainDist());
                        }
                        if (hasRemainStops()) {
                            i += CodedOutputStreamMicro.computeInt32Size(2, getRemainStops());
                        }
                        if (hasRemainTime()) {
                            i += CodedOutputStreamMicro.computeInt32Size(3, getRemainTime());
                        }
                        this.f11305g = i;
                        return i;
                    }

                    public boolean hasRemainDist() {
                        return this.f11299a;
                    }

                    public boolean hasRemainStops() {
                        return this.f11301c;
                    }

                    public boolean hasRemainTime() {
                        return this.f11303e;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public NextVehicle mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    setRemainDist(codedInputStreamMicro.readInt32());
                                    continue;
                                case 16:
                                    setRemainStops(codedInputStreamMicro.readInt32());
                                    continue;
                                case 24:
                                    setRemainTime(codedInputStreamMicro.readInt32());
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

                    public NextVehicle setRemainDist(int i) {
                        this.f11299a = true;
                        this.f11300b = i;
                        return this;
                    }

                    public NextVehicle setRemainStops(int i) {
                        this.f11301c = true;
                        this.f11302d = i;
                        return this;
                    }

                    public NextVehicle setRemainTime(int i) {
                        this.f11303e = true;
                        this.f11304f = i;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasRemainDist()) {
                            codedOutputStreamMicro.writeInt32(1, getRemainDist());
                        }
                        if (hasRemainStops()) {
                            codedOutputStreamMicro.writeInt32(2, getRemainStops());
                        }
                        if (hasRemainTime()) {
                            codedOutputStreamMicro.writeInt32(3, getRemainTime());
                        }
                    }
                }

                public static RtInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new RtInfo().mergeFrom(codedInputStreamMicro);
                }

                public static RtInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (RtInfo) new RtInfo().mergeFrom(bArr);
                }

                public final RtInfo clear() {
                    clearNextVehicle();
                    clearTipRtbus();
                    this.f11310e = -1;
                    return this;
                }

                public RtInfo clearNextVehicle() {
                    this.f11306a = false;
                    this.f11307b = null;
                    return this;
                }

                public RtInfo clearTipRtbus() {
                    this.f11308c = false;
                    this.f11309d = "";
                    return this;
                }

                public int getCachedSize() {
                    if (this.f11310e < 0) {
                        getSerializedSize();
                    }
                    return this.f11310e;
                }

                public NextVehicle getNextVehicle() {
                    return this.f11307b;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasNextVehicle()) {
                        i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getNextVehicle());
                    }
                    if (hasTipRtbus()) {
                        i += CodedOutputStreamMicro.computeStringSize(2, getTipRtbus());
                    }
                    this.f11310e = i;
                    return i;
                }

                public String getTipRtbus() {
                    return this.f11309d;
                }

                public boolean hasNextVehicle() {
                    return this.f11306a;
                }

                public boolean hasTipRtbus() {
                    return this.f11308c;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public RtInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                MessageMicro nextVehicle = new NextVehicle();
                                codedInputStreamMicro.readMessage(nextVehicle);
                                setNextVehicle(nextVehicle);
                                continue;
                            case 18:
                                setTipRtbus(codedInputStreamMicro.readString());
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

                public RtInfo setNextVehicle(NextVehicle nextVehicle) {
                    if (nextVehicle == null) {
                        return clearNextVehicle();
                    }
                    this.f11306a = true;
                    this.f11307b = nextVehicle;
                    return this;
                }

                public RtInfo setTipRtbus(String str) {
                    this.f11308c = true;
                    this.f11309d = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasNextVehicle()) {
                        codedOutputStreamMicro.writeMessage(1, getNextVehicle());
                    }
                    if (hasTipRtbus()) {
                        codedOutputStreamMicro.writeString(2, getTipRtbus());
                    }
                }
            }

            public static Blinfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Blinfo().mergeFrom(codedInputStreamMicro);
            }

            public static Blinfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Blinfo) new Blinfo().mergeFrom(bArr);
            }

            public final Blinfo clear() {
                clearRtInfo();
                clearAddr();
                clearName();
                clearUid();
                clearPairUid();
                clearNextStation();
                clearIconId();
                clearSonUid();
                this.f11327q = -1;
                return this;
            }

            public Blinfo clearAddr() {
                this.f11313c = false;
                this.f11314d = "";
                return this;
            }

            public Blinfo clearIconId() {
                this.f11323m = false;
                this.f11324n = 0;
                return this;
            }

            public Blinfo clearName() {
                this.f11315e = false;
                this.f11316f = "";
                return this;
            }

            public Blinfo clearNextStation() {
                this.f11321k = false;
                this.f11322l = "";
                return this;
            }

            public Blinfo clearPairUid() {
                this.f11319i = false;
                this.f11320j = "";
                return this;
            }

            public Blinfo clearRtInfo() {
                this.f11311a = false;
                this.f11312b = null;
                return this;
            }

            public Blinfo clearSonUid() {
                this.f11325o = false;
                this.f11326p = "";
                return this;
            }

            public Blinfo clearUid() {
                this.f11317g = false;
                this.f11318h = "";
                return this;
            }

            public String getAddr() {
                return this.f11314d;
            }

            public int getCachedSize() {
                if (this.f11327q < 0) {
                    getSerializedSize();
                }
                return this.f11327q;
            }

            public int getIconId() {
                return this.f11324n;
            }

            public String getName() {
                return this.f11316f;
            }

            public String getNextStation() {
                return this.f11322l;
            }

            public String getPairUid() {
                return this.f11320j;
            }

            public RtInfo getRtInfo() {
                return this.f11312b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasAddr()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getAddr());
                }
                if (hasName()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getName());
                }
                if (hasRtInfo()) {
                    i += CodedOutputStreamMicro.computeMessageSize(3, getRtInfo());
                }
                if (hasUid()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getUid());
                }
                if (hasPairUid()) {
                    i += CodedOutputStreamMicro.computeStringSize(5, getPairUid());
                }
                if (hasNextStation()) {
                    i += CodedOutputStreamMicro.computeStringSize(6, getNextStation());
                }
                if (hasIconId()) {
                    i += CodedOutputStreamMicro.computeInt32Size(7, getIconId());
                }
                if (hasSonUid()) {
                    i += CodedOutputStreamMicro.computeStringSize(8, getSonUid());
                }
                this.f11327q = i;
                return i;
            }

            public String getSonUid() {
                return this.f11326p;
            }

            public String getUid() {
                return this.f11318h;
            }

            public boolean hasAddr() {
                return this.f11313c;
            }

            public boolean hasIconId() {
                return this.f11323m;
            }

            public boolean hasName() {
                return this.f11315e;
            }

            public boolean hasNextStation() {
                return this.f11321k;
            }

            public boolean hasPairUid() {
                return this.f11319i;
            }

            public boolean hasRtInfo() {
                return this.f11311a;
            }

            public boolean hasSonUid() {
                return this.f11325o;
            }

            public boolean hasUid() {
                return this.f11317g;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Blinfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setAddr(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setName(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            MessageMicro rtInfo = new RtInfo();
                            codedInputStreamMicro.readMessage(rtInfo);
                            setRtInfo(rtInfo);
                            continue;
                        case 34:
                            setUid(codedInputStreamMicro.readString());
                            continue;
                        case 42:
                            setPairUid(codedInputStreamMicro.readString());
                            continue;
                        case 50:
                            setNextStation(codedInputStreamMicro.readString());
                            continue;
                        case 56:
                            setIconId(codedInputStreamMicro.readInt32());
                            continue;
                        case 66:
                            setSonUid(codedInputStreamMicro.readString());
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

            public Blinfo setAddr(String str) {
                this.f11313c = true;
                this.f11314d = str;
                return this;
            }

            public Blinfo setIconId(int i) {
                this.f11323m = true;
                this.f11324n = i;
                return this;
            }

            public Blinfo setName(String str) {
                this.f11315e = true;
                this.f11316f = str;
                return this;
            }

            public Blinfo setNextStation(String str) {
                this.f11321k = true;
                this.f11322l = str;
                return this;
            }

            public Blinfo setPairUid(String str) {
                this.f11319i = true;
                this.f11320j = str;
                return this;
            }

            public Blinfo setRtInfo(RtInfo rtInfo) {
                if (rtInfo == null) {
                    return clearRtInfo();
                }
                this.f11311a = true;
                this.f11312b = rtInfo;
                return this;
            }

            public Blinfo setSonUid(String str) {
                this.f11325o = true;
                this.f11326p = str;
                return this;
            }

            public Blinfo setUid(String str) {
                this.f11317g = true;
                this.f11318h = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasAddr()) {
                    codedOutputStreamMicro.writeString(1, getAddr());
                }
                if (hasName()) {
                    codedOutputStreamMicro.writeString(2, getName());
                }
                if (hasRtInfo()) {
                    codedOutputStreamMicro.writeMessage(3, getRtInfo());
                }
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(4, getUid());
                }
                if (hasPairUid()) {
                    codedOutputStreamMicro.writeString(5, getPairUid());
                }
                if (hasNextStation()) {
                    codedOutputStreamMicro.writeString(6, getNextStation());
                }
                if (hasIconId()) {
                    codedOutputStreamMicro.writeInt32(7, getIconId());
                }
                if (hasSonUid()) {
                    codedOutputStreamMicro.writeString(8, getSonUid());
                }
            }
        }

        public static final class Button extends MessageMicro {
            public static final int CONTENT_FIELD_NUMBER = 1;
            public static final int ICON_URL_FIELD_NUMBER = 4;
            public static final int TITLE_FIELD_NUMBER = 2;
            public static final int TYPE_FIELD_NUMBER = 3;
            /* renamed from: a */
            private boolean f11328a;
            /* renamed from: b */
            private String f11329b = "";
            /* renamed from: c */
            private boolean f11330c;
            /* renamed from: d */
            private String f11331d = "";
            /* renamed from: e */
            private boolean f11332e;
            /* renamed from: f */
            private String f11333f = "";
            /* renamed from: g */
            private boolean f11334g;
            /* renamed from: h */
            private String f11335h = "";
            /* renamed from: i */
            private int f11336i = -1;

            public static Button parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Button().mergeFrom(codedInputStreamMicro);
            }

            public static Button parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Button) new Button().mergeFrom(bArr);
            }

            public final Button clear() {
                clearContent();
                clearTitle();
                clearType();
                clearIconUrl();
                this.f11336i = -1;
                return this;
            }

            public Button clearContent() {
                this.f11328a = false;
                this.f11329b = "";
                return this;
            }

            public Button clearIconUrl() {
                this.f11334g = false;
                this.f11335h = "";
                return this;
            }

            public Button clearTitle() {
                this.f11330c = false;
                this.f11331d = "";
                return this;
            }

            public Button clearType() {
                this.f11332e = false;
                this.f11333f = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f11336i < 0) {
                    getSerializedSize();
                }
                return this.f11336i;
            }

            public String getContent() {
                return this.f11329b;
            }

            public String getIconUrl() {
                return this.f11335h;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasContent()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getContent());
                }
                if (hasTitle()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getTitle());
                }
                if (hasType()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getType());
                }
                if (hasIconUrl()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getIconUrl());
                }
                this.f11336i = i;
                return i;
            }

            public String getTitle() {
                return this.f11331d;
            }

            public String getType() {
                return this.f11333f;
            }

            public boolean hasContent() {
                return this.f11328a;
            }

            public boolean hasIconUrl() {
                return this.f11334g;
            }

            public boolean hasTitle() {
                return this.f11330c;
            }

            public boolean hasType() {
                return this.f11332e;
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
                            setContent(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setTitle(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setType(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setIconUrl(codedInputStreamMicro.readString());
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

            public Button setContent(String str) {
                this.f11328a = true;
                this.f11329b = str;
                return this;
            }

            public Button setIconUrl(String str) {
                this.f11334g = true;
                this.f11335h = str;
                return this;
            }

            public Button setTitle(String str) {
                this.f11330c = true;
                this.f11331d = str;
                return this;
            }

            public Button setType(String str) {
                this.f11332e = true;
                this.f11333f = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasContent()) {
                    codedOutputStreamMicro.writeString(1, getContent());
                }
                if (hasTitle()) {
                    codedOutputStreamMicro.writeString(2, getTitle());
                }
                if (hasType()) {
                    codedOutputStreamMicro.writeString(3, getType());
                }
                if (hasIconUrl()) {
                    codedOutputStreamMicro.writeString(4, getIconUrl());
                }
            }
        }

        public static final class Ext extends MessageMicro {
            public static final int DETAIL_INFO_FIELD_NUMBER = 1;
            public static final int EXT_TYPE_FIELD_NUMBER = 7;
            public static final int IMAGE_FIELD_NUMBER = 5;
            public static final int LINE_INFO_FIELD_NUMBER = 6;
            public static final int REVIEW_FIELD_NUMBER = 2;
            public static final int RICH_INFO_FIELD_NUMBER = 3;
            public static final int SRC_NAME_FIELD_NUMBER = 4;
            /* renamed from: a */
            private boolean f11702a;
            /* renamed from: b */
            private DetailInfo f11703b = null;
            /* renamed from: c */
            private List<Review> f11704c = Collections.emptyList();
            /* renamed from: d */
            private boolean f11705d;
            /* renamed from: e */
            private RichInfo f11706e = null;
            /* renamed from: f */
            private boolean f11707f;
            /* renamed from: g */
            private Image f11708g = null;
            /* renamed from: h */
            private List<LineInfo> f11709h = Collections.emptyList();
            /* renamed from: i */
            private boolean f11710i;
            /* renamed from: j */
            private String f11711j = "";
            /* renamed from: k */
            private boolean f11712k;
            /* renamed from: l */
            private int f11713l = 0;
            /* renamed from: m */
            private int f11714m = -1;

            public static final class DetailInfo extends MessageMicro {
                public static final int ALLCARDEXTENSION_FIELD_NUMBER = 66;
                public static final int AREAID_FIELD_NUMBER = 1;
                public static final int BID_FIELD_NUMBER = 2;
                public static final int BOOK_INFO_FIELD_NUMBER = 61;
                public static final int CHECKIN_NUM_FIELD_NUMBER = 3;
                public static final int COLLECT_NUM_FIELD_NUMBER = 4;
                public static final int COMMENT_NUM_FIELD_NUMBER = 5;
                public static final int FACILITY_RATING_FIELD_NUMBER = 6;
                public static final int FLAG_FIELD_NUMBER = 53;
                public static final int FROM_PDS_FIELD_NUMBER = 7;
                public static final int GROUPON_FIELD_NUMBER = 8;
                public static final int GROUPON_FLAG_FIELD_NUMBER = 54;
                public static final int GROUPON_NUM_FIELD_NUMBER = 9;
                public static final int GROUPON_TOTAL_FIELD_NUMBER = 55;
                public static final int GUIDE_FIELD_NUMBER = 58;
                public static final int HOTEL_ORI_INFO_FIELD_NUMBER = 10;
                public static final int HYGIENE_RATING_FIELD_NUMBER = 11;
                public static final int IMAGE_FIELD_NUMBER = 12;
                public static final int IMAGE_FROM_FIELD_NUMBER = 13;
                public static final int IMAGE_NUM_FIELD_NUMBER = 14;
                public static final int IS_GWJ_FIELD_NUMBER = 56;
                public static final int LATEST_NUM_FIELD_NUMBER = 15;
                public static final int LBC_BUSINESS_VIP_FIELD_NUMBER = 62;
                public static final int LINK_FIELD_NUMBER = 16;
                public static final int MBC_FIELD_NUMBER = 65;
                public static final int MEISHIPAIHAO_FIELD_NUMBER = 59;
                public static final int MINING_LOW_PRICE_FLAG_FIELD_NUMBER = 17;
                public static final int NAME_FIELD_NUMBER = 18;
                public static final int NEW_CATALOG_ID_FIELD_NUMBER = 19;
                public static final int ORIGIN_PRICE_FIELD_NUMBER = 20;
                public static final int OTA_INFO_FIELD_NUMBER = 21;
                public static final int OTA_URL_FIELD_NUMBER = 22;
                public static final int OVERALL_RATING_FIELD_NUMBER = 23;
                public static final int PC_BOOKABLE_FIELD_NUMBER = 24;
                public static final int PC_REALTIME_PRICE_FIELD_NUMBER = 25;
                public static final int PHONE_FIELD_NUMBER = 26;
                public static final int POINT_FIELD_NUMBER = 27;
                public static final int POI_ADDRESS_FIELD_NUMBER = 28;
                public static final int PREMIUM_FLAG_FIELD_NUMBER = 29;
                public static final int PRICE_FIELD_NUMBER = 30;
                public static final int PRICE_TEXT_FIELD_NUMBER = 57;
                public static final int RECOMMAND_INDEX_FIELD_NUMBER = 32;
                public static final int REC_REASON_FIELD_NUMBER = 31;
                public static final int REVIEW_FLAG_FIELD_NUMBER = 33;
                public static final int SERVICE_RATING_FIELD_NUMBER = 34;
                public static final int SHORT_COMM_FIELD_NUMBER = 35;
                public static final int SPECIAL_SERVICE_FIELD_NUMBER = 36;
                public static final int STATUS_FIELD_NUMBER = 38;
                public static final int STORAGE_SRC_FIELD_NUMBER = 39;
                public static final int S_TIME_FIELD_NUMBER = 37;
                public static final int TAG_FIELD_NUMBER = 40;
                public static final int TONIGHT_PRICE_FIELD_NUMBER = 41;
                public static final int TONIGHT_SALE_FLAG_FIELD_NUMBER = 42;
                public static final int TOPLIST_FIELD_NUMBER = 44;
                public static final int TOTAL_NUM_FIELD_NUMBER = 43;
                public static final int UPPERLEFTCORNER_FIELD_NUMBER = 64;
                public static final int VALIDATE_FIELD_NUMBER = 63;
                public static final int WAP_BOOKABLE_FIELD_NUMBER = 45;
                public static final int WISE_FULLROOM_FIELD_NUMBER = 46;
                public static final int WISE_HOTEL_TYPE_FIELD_NUMBER = 47;
                public static final int WISE_HOTEL_TYPE_NAME_FIELD_NUMBER = 48;
                public static final int WISE_LOW_PRICE_FIELD_NUMBER = 49;
                public static final int WISE_PRICE_FIELD_NUMBER = 50;
                public static final int WISE_REALTIME_PRICE_FIELD_NUMBER = 51;
                public static final int WISE_REALTIME_PRICE_FLAG_FIELD_NUMBER = 52;
                /* renamed from: A */
                private String f11481A = "";
                /* renamed from: B */
                private boolean f11482B;
                /* renamed from: C */
                private String f11483C = "";
                /* renamed from: D */
                private boolean f11484D;
                /* renamed from: E */
                private String f11485E = "";
                /* renamed from: F */
                private boolean f11486F;
                /* renamed from: G */
                private String f11487G = "";
                /* renamed from: H */
                private boolean f11488H;
                /* renamed from: I */
                private String f11489I = "";
                /* renamed from: J */
                private boolean f11490J;
                /* renamed from: K */
                private String f11491K = "";
                /* renamed from: L */
                private boolean f11492L;
                /* renamed from: M */
                private String f11493M = "";
                /* renamed from: N */
                private boolean f11494N;
                /* renamed from: O */
                private String f11495O = "";
                /* renamed from: P */
                private boolean f11496P;
                /* renamed from: Q */
                private String f11497Q = "";
                /* renamed from: R */
                private boolean f11498R;
                /* renamed from: S */
                private String f11499S = "";
                /* renamed from: T */
                private boolean f11500T;
                /* renamed from: U */
                private String f11501U = "";
                /* renamed from: V */
                private boolean f11502V;
                /* renamed from: W */
                private String f11503W = "";
                /* renamed from: X */
                private boolean f11504X;
                /* renamed from: Y */
                private String f11505Y = "";
                /* renamed from: Z */
                private boolean f11506Z;
                /* renamed from: a */
                private List<Groupon> f11507a = Collections.emptyList();
                private String aA = "";
                private boolean aB;
                private String aC = "";
                private boolean aD;
                private String aE = "";
                private boolean aF;
                private String aG = "";
                private boolean aH;
                private String aI = "";
                private boolean aJ;
                private String aK = "";
                private boolean aL;
                private String aM = "";
                private boolean aN;
                private String aO = "";
                private boolean aP;
                private String aQ = "";
                private boolean aR;
                private String aS = "";
                private boolean aT;
                private String aU = "";
                private List<String> aV = Collections.emptyList();
                private boolean aW;
                private int aX = 0;
                private boolean aY;
                private int aZ = 0;
                private String aa = "";
                private boolean ab;
                private int ac = 0;
                private boolean ad;
                private String ae = "";
                private boolean af;
                private String ag = "";
                private boolean ah;
                private String ai = "";
                private boolean aj;
                private int ak = 0;
                private boolean al;
                private String am = "";
                private boolean an;
                private String ao = "";
                private boolean ap;
                private String aq = "";
                private boolean ar;
                private int as = 0;
                private boolean at;
                private String au = "";
                private boolean av;
                private String aw = "";
                private boolean ax;
                private String ay = "";
                private boolean az;
                /* renamed from: b */
                private List<HotelOriInfo> f11508b = Collections.emptyList();
                private boolean ba;
                private int bb = 0;
                private boolean bc;
                private String bd = "";
                private boolean be;
                private String bf = "";
                private boolean bg;
                private Meishipaihao bh = null;
                private boolean bi;
                private BookInfo bj = null;
                private boolean bk;
                private LbcBusinessVip bl = null;
                private boolean bm;
                private String bn = "";
                private boolean bo;
                private Upperleftcorner bp = null;
                private boolean bq;
                private Mbc br = null;
                private boolean bs;
                private Allcardextension bt = null;
                private int bu = -1;
                /* renamed from: c */
                private List<Link> f11509c = Collections.emptyList();
                /* renamed from: d */
                private List<OtaInfo> f11510d = Collections.emptyList();
                /* renamed from: e */
                private List<OtaUrl> f11511e = Collections.emptyList();
                /* renamed from: f */
                private boolean f11512f;
                /* renamed from: g */
                private Point f11513g = null;
                /* renamed from: h */
                private boolean f11514h;
                /* renamed from: i */
                private Toplist f11515i = null;
                /* renamed from: j */
                private boolean f11516j;
                /* renamed from: k */
                private int f11517k = 0;
                /* renamed from: l */
                private boolean f11518l;
                /* renamed from: m */
                private String f11519m = "";
                /* renamed from: n */
                private boolean f11520n;
                /* renamed from: o */
                private String f11521o = "";
                /* renamed from: p */
                private boolean f11522p;
                /* renamed from: q */
                private String f11523q = "";
                /* renamed from: r */
                private boolean f11524r;
                /* renamed from: s */
                private String f11525s = "";
                /* renamed from: t */
                private boolean f11526t;
                /* renamed from: u */
                private String f11527u = "";
                /* renamed from: v */
                private boolean f11528v;
                /* renamed from: w */
                private String f11529w = "";
                /* renamed from: x */
                private boolean f11530x;
                /* renamed from: y */
                private int f11531y = 0;
                /* renamed from: z */
                private boolean f11532z;

                public static final class Allcardextension extends MessageMicro {
                    public static final int IMAGE_URL_FIELD_NUMBER = 1;
                    public static final int LANDING_URL_FIELD_NUMBER = 2;
                    /* renamed from: a */
                    private boolean f11337a;
                    /* renamed from: b */
                    private String f11338b = "";
                    /* renamed from: c */
                    private boolean f11339c;
                    /* renamed from: d */
                    private String f11340d = "";
                    /* renamed from: e */
                    private int f11341e = -1;

                    public static Allcardextension parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Allcardextension().mergeFrom(codedInputStreamMicro);
                    }

                    public static Allcardextension parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Allcardextension) new Allcardextension().mergeFrom(bArr);
                    }

                    public final Allcardextension clear() {
                        clearImageUrl();
                        clearLandingUrl();
                        this.f11341e = -1;
                        return this;
                    }

                    public Allcardextension clearImageUrl() {
                        this.f11337a = false;
                        this.f11338b = "";
                        return this;
                    }

                    public Allcardextension clearLandingUrl() {
                        this.f11339c = false;
                        this.f11340d = "";
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f11341e < 0) {
                            getSerializedSize();
                        }
                        return this.f11341e;
                    }

                    public String getImageUrl() {
                        return this.f11338b;
                    }

                    public String getLandingUrl() {
                        return this.f11340d;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasImageUrl()) {
                            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getImageUrl());
                        }
                        if (hasLandingUrl()) {
                            i += CodedOutputStreamMicro.computeStringSize(2, getLandingUrl());
                        }
                        this.f11341e = i;
                        return i;
                    }

                    public boolean hasImageUrl() {
                        return this.f11337a;
                    }

                    public boolean hasLandingUrl() {
                        return this.f11339c;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Allcardextension mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    setImageUrl(codedInputStreamMicro.readString());
                                    continue;
                                case 18:
                                    setLandingUrl(codedInputStreamMicro.readString());
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

                    public Allcardextension setImageUrl(String str) {
                        this.f11337a = true;
                        this.f11338b = str;
                        return this;
                    }

                    public Allcardextension setLandingUrl(String str) {
                        this.f11339c = true;
                        this.f11340d = str;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasImageUrl()) {
                            codedOutputStreamMicro.writeString(1, getImageUrl());
                        }
                        if (hasLandingUrl()) {
                            codedOutputStreamMicro.writeString(2, getLandingUrl());
                        }
                    }
                }

                public static final class BookInfo extends MessageMicro {
                    public static final int COMS_FIELD_NUMBER = 3;
                    public static final int TEL_FIELD_NUMBER = 1;
                    public static final int WEB_FIELD_NUMBER = 2;
                    /* renamed from: a */
                    private boolean f11359a;
                    /* renamed from: b */
                    private Tel f11360b = null;
                    /* renamed from: c */
                    private boolean f11361c;
                    /* renamed from: d */
                    private Web f11362d = null;
                    /* renamed from: e */
                    private boolean f11363e;
                    /* renamed from: f */
                    private Coms f11364f = null;
                    /* renamed from: g */
                    private int f11365g = -1;

                    public static final class Coms extends MessageMicro {
                        public static final int CONTENT_FIELD_NUMBER = 1;
                        public static final int TITLE_FIELD_NUMBER = 2;
                        public static final int TYPE_FIELD_NUMBER = 3;
                        /* renamed from: a */
                        private boolean f11342a;
                        /* renamed from: b */
                        private String f11343b = "";
                        /* renamed from: c */
                        private boolean f11344c;
                        /* renamed from: d */
                        private String f11345d = "";
                        /* renamed from: e */
                        private boolean f11346e;
                        /* renamed from: f */
                        private String f11347f = "";
                        /* renamed from: g */
                        private int f11348g = -1;

                        public static Coms parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new Coms().mergeFrom(codedInputStreamMicro);
                        }

                        public static Coms parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (Coms) new Coms().mergeFrom(bArr);
                        }

                        public final Coms clear() {
                            clearContent();
                            clearTitle();
                            clearType();
                            this.f11348g = -1;
                            return this;
                        }

                        public Coms clearContent() {
                            this.f11342a = false;
                            this.f11343b = "";
                            return this;
                        }

                        public Coms clearTitle() {
                            this.f11344c = false;
                            this.f11345d = "";
                            return this;
                        }

                        public Coms clearType() {
                            this.f11346e = false;
                            this.f11347f = "";
                            return this;
                        }

                        public int getCachedSize() {
                            if (this.f11348g < 0) {
                                getSerializedSize();
                            }
                            return this.f11348g;
                        }

                        public String getContent() {
                            return this.f11343b;
                        }

                        public int getSerializedSize() {
                            int i = 0;
                            if (hasContent()) {
                                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getContent());
                            }
                            if (hasTitle()) {
                                i += CodedOutputStreamMicro.computeStringSize(2, getTitle());
                            }
                            if (hasType()) {
                                i += CodedOutputStreamMicro.computeStringSize(3, getType());
                            }
                            this.f11348g = i;
                            return i;
                        }

                        public String getTitle() {
                            return this.f11345d;
                        }

                        public String getType() {
                            return this.f11347f;
                        }

                        public boolean hasContent() {
                            return this.f11342a;
                        }

                        public boolean hasTitle() {
                            return this.f11344c;
                        }

                        public boolean hasType() {
                            return this.f11346e;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public Coms mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                switch (readTag) {
                                    case 0:
                                        break;
                                    case 10:
                                        setContent(codedInputStreamMicro.readString());
                                        continue;
                                    case 18:
                                        setTitle(codedInputStreamMicro.readString());
                                        continue;
                                    case 26:
                                        setType(codedInputStreamMicro.readString());
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

                        public Coms setContent(String str) {
                            this.f11342a = true;
                            this.f11343b = str;
                            return this;
                        }

                        public Coms setTitle(String str) {
                            this.f11344c = true;
                            this.f11345d = str;
                            return this;
                        }

                        public Coms setType(String str) {
                            this.f11346e = true;
                            this.f11347f = str;
                            return this;
                        }

                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasContent()) {
                                codedOutputStreamMicro.writeString(1, getContent());
                            }
                            if (hasTitle()) {
                                codedOutputStreamMicro.writeString(2, getTitle());
                            }
                            if (hasType()) {
                                codedOutputStreamMicro.writeString(3, getType());
                            }
                        }
                    }

                    public static final class Tel extends MessageMicro {
                        public static final int CONTENT_FIELD_NUMBER = 2;
                        public static final int TITLE_FIELD_NUMBER = 1;
                        /* renamed from: a */
                        private boolean f11349a;
                        /* renamed from: b */
                        private String f11350b = "";
                        /* renamed from: c */
                        private boolean f11351c;
                        /* renamed from: d */
                        private String f11352d = "";
                        /* renamed from: e */
                        private int f11353e = -1;

                        public static Tel parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new Tel().mergeFrom(codedInputStreamMicro);
                        }

                        public static Tel parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (Tel) new Tel().mergeFrom(bArr);
                        }

                        public final Tel clear() {
                            clearTitle();
                            clearContent();
                            this.f11353e = -1;
                            return this;
                        }

                        public Tel clearContent() {
                            this.f11351c = false;
                            this.f11352d = "";
                            return this;
                        }

                        public Tel clearTitle() {
                            this.f11349a = false;
                            this.f11350b = "";
                            return this;
                        }

                        public int getCachedSize() {
                            if (this.f11353e < 0) {
                                getSerializedSize();
                            }
                            return this.f11353e;
                        }

                        public String getContent() {
                            return this.f11352d;
                        }

                        public int getSerializedSize() {
                            int i = 0;
                            if (hasTitle()) {
                                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
                            }
                            if (hasContent()) {
                                i += CodedOutputStreamMicro.computeStringSize(2, getContent());
                            }
                            this.f11353e = i;
                            return i;
                        }

                        public String getTitle() {
                            return this.f11350b;
                        }

                        public boolean hasContent() {
                            return this.f11351c;
                        }

                        public boolean hasTitle() {
                            return this.f11349a;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public Tel mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                switch (readTag) {
                                    case 0:
                                        break;
                                    case 10:
                                        setTitle(codedInputStreamMicro.readString());
                                        continue;
                                    case 18:
                                        setContent(codedInputStreamMicro.readString());
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

                        public Tel setContent(String str) {
                            this.f11351c = true;
                            this.f11352d = str;
                            return this;
                        }

                        public Tel setTitle(String str) {
                            this.f11349a = true;
                            this.f11350b = str;
                            return this;
                        }

                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasTitle()) {
                                codedOutputStreamMicro.writeString(1, getTitle());
                            }
                            if (hasContent()) {
                                codedOutputStreamMicro.writeString(2, getContent());
                            }
                        }
                    }

                    public static final class Web extends MessageMicro {
                        public static final int CONTENT_FIELD_NUMBER = 2;
                        public static final int TITLE_FIELD_NUMBER = 1;
                        /* renamed from: a */
                        private boolean f11354a;
                        /* renamed from: b */
                        private String f11355b = "";
                        /* renamed from: c */
                        private boolean f11356c;
                        /* renamed from: d */
                        private String f11357d = "";
                        /* renamed from: e */
                        private int f11358e = -1;

                        public static Web parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new Web().mergeFrom(codedInputStreamMicro);
                        }

                        public static Web parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (Web) new Web().mergeFrom(bArr);
                        }

                        public final Web clear() {
                            clearTitle();
                            clearContent();
                            this.f11358e = -1;
                            return this;
                        }

                        public Web clearContent() {
                            this.f11356c = false;
                            this.f11357d = "";
                            return this;
                        }

                        public Web clearTitle() {
                            this.f11354a = false;
                            this.f11355b = "";
                            return this;
                        }

                        public int getCachedSize() {
                            if (this.f11358e < 0) {
                                getSerializedSize();
                            }
                            return this.f11358e;
                        }

                        public String getContent() {
                            return this.f11357d;
                        }

                        public int getSerializedSize() {
                            int i = 0;
                            if (hasTitle()) {
                                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
                            }
                            if (hasContent()) {
                                i += CodedOutputStreamMicro.computeStringSize(2, getContent());
                            }
                            this.f11358e = i;
                            return i;
                        }

                        public String getTitle() {
                            return this.f11355b;
                        }

                        public boolean hasContent() {
                            return this.f11356c;
                        }

                        public boolean hasTitle() {
                            return this.f11354a;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public Web mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                switch (readTag) {
                                    case 0:
                                        break;
                                    case 10:
                                        setTitle(codedInputStreamMicro.readString());
                                        continue;
                                    case 18:
                                        setContent(codedInputStreamMicro.readString());
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

                        public Web setContent(String str) {
                            this.f11356c = true;
                            this.f11357d = str;
                            return this;
                        }

                        public Web setTitle(String str) {
                            this.f11354a = true;
                            this.f11355b = str;
                            return this;
                        }

                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasTitle()) {
                                codedOutputStreamMicro.writeString(1, getTitle());
                            }
                            if (hasContent()) {
                                codedOutputStreamMicro.writeString(2, getContent());
                            }
                        }
                    }

                    public static BookInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new BookInfo().mergeFrom(codedInputStreamMicro);
                    }

                    public static BookInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (BookInfo) new BookInfo().mergeFrom(bArr);
                    }

                    public final BookInfo clear() {
                        clearTel();
                        clearWeb();
                        clearComs();
                        this.f11365g = -1;
                        return this;
                    }

                    public BookInfo clearComs() {
                        this.f11363e = false;
                        this.f11364f = null;
                        return this;
                    }

                    public BookInfo clearTel() {
                        this.f11359a = false;
                        this.f11360b = null;
                        return this;
                    }

                    public BookInfo clearWeb() {
                        this.f11361c = false;
                        this.f11362d = null;
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f11365g < 0) {
                            getSerializedSize();
                        }
                        return this.f11365g;
                    }

                    public Coms getComs() {
                        return this.f11364f;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasTel()) {
                            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getTel());
                        }
                        if (hasWeb()) {
                            i += CodedOutputStreamMicro.computeMessageSize(2, getWeb());
                        }
                        if (hasComs()) {
                            i += CodedOutputStreamMicro.computeMessageSize(3, getComs());
                        }
                        this.f11365g = i;
                        return i;
                    }

                    public Tel getTel() {
                        return this.f11360b;
                    }

                    public Web getWeb() {
                        return this.f11362d;
                    }

                    public boolean hasComs() {
                        return this.f11363e;
                    }

                    public boolean hasTel() {
                        return this.f11359a;
                    }

                    public boolean hasWeb() {
                        return this.f11361c;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public BookInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            MessageMicro tel;
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    tel = new Tel();
                                    codedInputStreamMicro.readMessage(tel);
                                    setTel(tel);
                                    continue;
                                case 18:
                                    tel = new Web();
                                    codedInputStreamMicro.readMessage(tel);
                                    setWeb(tel);
                                    continue;
                                case 26:
                                    tel = new Coms();
                                    codedInputStreamMicro.readMessage(tel);
                                    setComs(tel);
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

                    public BookInfo setComs(Coms coms) {
                        if (coms == null) {
                            return clearComs();
                        }
                        this.f11363e = true;
                        this.f11364f = coms;
                        return this;
                    }

                    public BookInfo setTel(Tel tel) {
                        if (tel == null) {
                            return clearTel();
                        }
                        this.f11359a = true;
                        this.f11360b = tel;
                        return this;
                    }

                    public BookInfo setWeb(Web web) {
                        if (web == null) {
                            return clearWeb();
                        }
                        this.f11361c = true;
                        this.f11362d = web;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasTel()) {
                            codedOutputStreamMicro.writeMessage(1, getTel());
                        }
                        if (hasWeb()) {
                            codedOutputStreamMicro.writeMessage(2, getWeb());
                        }
                        if (hasComs()) {
                            codedOutputStreamMicro.writeMessage(3, getComs());
                        }
                    }
                }

                public static final class Groupon extends MessageMicro {
                    public static final int CN_NAME_FIELD_NUMBER = 8;
                    public static final int GROUPON_END_FIELD_NUMBER = 13;
                    public static final int GROUPON_ID_FIELD_NUMBER = 6;
                    public static final int GROUPON_IMAGE_FIELD_NUMBER = 10;
                    public static final int GROUPON_NUM_FIELD_NUMBER = 3;
                    public static final int GROUPON_PRICE_FIELD_NUMBER = 4;
                    public static final int GROUPON_REBATE_FIELD_NUMBER = 11;
                    public static final int GROUPON_SITE_FIELD_NUMBER = 12;
                    public static final int GROUPON_START_FIELD_NUMBER = 1;
                    public static final int GROUPON_TITLE_FIELD_NUMBER = 14;
                    public static final int GROUPON_TYPE_FIELD_NUMBER = 5;
                    public static final int GROUPON_URL_MOBILE_FIELD_NUMBER = 7;
                    public static final int GROUPON_URL_PC_FIELD_NUMBER = 9;
                    public static final int GROUPON_WEBAPP_URL_FIELD_NUMBER = 15;
                    public static final int REGULAR_PRICE_FIELD_NUMBER = 2;
                    /* renamed from: A */
                    private boolean f11366A;
                    /* renamed from: B */
                    private String f11367B = "";
                    /* renamed from: C */
                    private boolean f11368C;
                    /* renamed from: D */
                    private String f11369D = "";
                    /* renamed from: E */
                    private int f11370E = -1;
                    /* renamed from: a */
                    private boolean f11371a;
                    /* renamed from: b */
                    private String f11372b = "";
                    /* renamed from: c */
                    private boolean f11373c;
                    /* renamed from: d */
                    private String f11374d = "";
                    /* renamed from: e */
                    private boolean f11375e;
                    /* renamed from: f */
                    private String f11376f = "";
                    /* renamed from: g */
                    private boolean f11377g;
                    /* renamed from: h */
                    private String f11378h = "";
                    /* renamed from: i */
                    private boolean f11379i;
                    /* renamed from: j */
                    private String f11380j = "";
                    /* renamed from: k */
                    private boolean f11381k;
                    /* renamed from: l */
                    private int f11382l = 0;
                    /* renamed from: m */
                    private boolean f11383m;
                    /* renamed from: n */
                    private String f11384n = "";
                    /* renamed from: o */
                    private boolean f11385o;
                    /* renamed from: p */
                    private String f11386p = "";
                    /* renamed from: q */
                    private boolean f11387q;
                    /* renamed from: r */
                    private String f11388r = "";
                    /* renamed from: s */
                    private boolean f11389s;
                    /* renamed from: t */
                    private String f11390t = "";
                    /* renamed from: u */
                    private boolean f11391u;
                    /* renamed from: v */
                    private String f11392v = "";
                    /* renamed from: w */
                    private boolean f11393w;
                    /* renamed from: x */
                    private String f11394x = "";
                    /* renamed from: y */
                    private boolean f11395y;
                    /* renamed from: z */
                    private String f11396z = "";

                    public static Groupon parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Groupon().mergeFrom(codedInputStreamMicro);
                    }

                    public static Groupon parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Groupon) new Groupon().mergeFrom(bArr);
                    }

                    public final Groupon clear() {
                        clearGrouponStart();
                        clearRegularPrice();
                        clearGrouponNum();
                        clearGrouponPrice();
                        clearGrouponType();
                        clearGrouponId();
                        clearGrouponUrlMobile();
                        clearCnName();
                        clearGrouponUrlPc();
                        clearGrouponImage();
                        clearGrouponRebate();
                        clearGrouponSite();
                        clearGrouponEnd();
                        clearGrouponTitle();
                        clearGrouponWebappUrl();
                        this.f11370E = -1;
                        return this;
                    }

                    public Groupon clearCnName() {
                        this.f11385o = false;
                        this.f11386p = "";
                        return this;
                    }

                    public Groupon clearGrouponEnd() {
                        this.f11395y = false;
                        this.f11396z = "";
                        return this;
                    }

                    public Groupon clearGrouponId() {
                        this.f11381k = false;
                        this.f11382l = 0;
                        return this;
                    }

                    public Groupon clearGrouponImage() {
                        this.f11389s = false;
                        this.f11390t = "";
                        return this;
                    }

                    public Groupon clearGrouponNum() {
                        this.f11375e = false;
                        this.f11376f = "";
                        return this;
                    }

                    public Groupon clearGrouponPrice() {
                        this.f11377g = false;
                        this.f11378h = "";
                        return this;
                    }

                    public Groupon clearGrouponRebate() {
                        this.f11391u = false;
                        this.f11392v = "";
                        return this;
                    }

                    public Groupon clearGrouponSite() {
                        this.f11393w = false;
                        this.f11394x = "";
                        return this;
                    }

                    public Groupon clearGrouponStart() {
                        this.f11371a = false;
                        this.f11372b = "";
                        return this;
                    }

                    public Groupon clearGrouponTitle() {
                        this.f11366A = false;
                        this.f11367B = "";
                        return this;
                    }

                    public Groupon clearGrouponType() {
                        this.f11379i = false;
                        this.f11380j = "";
                        return this;
                    }

                    public Groupon clearGrouponUrlMobile() {
                        this.f11383m = false;
                        this.f11384n = "";
                        return this;
                    }

                    public Groupon clearGrouponUrlPc() {
                        this.f11387q = false;
                        this.f11388r = "";
                        return this;
                    }

                    public Groupon clearGrouponWebappUrl() {
                        this.f11368C = false;
                        this.f11369D = "";
                        return this;
                    }

                    public Groupon clearRegularPrice() {
                        this.f11373c = false;
                        this.f11374d = "";
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f11370E < 0) {
                            getSerializedSize();
                        }
                        return this.f11370E;
                    }

                    public String getCnName() {
                        return this.f11386p;
                    }

                    public String getGrouponEnd() {
                        return this.f11396z;
                    }

                    public int getGrouponId() {
                        return this.f11382l;
                    }

                    public String getGrouponImage() {
                        return this.f11390t;
                    }

                    public String getGrouponNum() {
                        return this.f11376f;
                    }

                    public String getGrouponPrice() {
                        return this.f11378h;
                    }

                    public String getGrouponRebate() {
                        return this.f11392v;
                    }

                    public String getGrouponSite() {
                        return this.f11394x;
                    }

                    public String getGrouponStart() {
                        return this.f11372b;
                    }

                    public String getGrouponTitle() {
                        return this.f11367B;
                    }

                    public String getGrouponType() {
                        return this.f11380j;
                    }

                    public String getGrouponUrlMobile() {
                        return this.f11384n;
                    }

                    public String getGrouponUrlPc() {
                        return this.f11388r;
                    }

                    public String getGrouponWebappUrl() {
                        return this.f11369D;
                    }

                    public String getRegularPrice() {
                        return this.f11374d;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasGrouponStart()) {
                            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getGrouponStart());
                        }
                        if (hasRegularPrice()) {
                            i += CodedOutputStreamMicro.computeStringSize(2, getRegularPrice());
                        }
                        if (hasGrouponNum()) {
                            i += CodedOutputStreamMicro.computeStringSize(3, getGrouponNum());
                        }
                        if (hasGrouponPrice()) {
                            i += CodedOutputStreamMicro.computeStringSize(4, getGrouponPrice());
                        }
                        if (hasGrouponType()) {
                            i += CodedOutputStreamMicro.computeStringSize(5, getGrouponType());
                        }
                        if (hasGrouponId()) {
                            i += CodedOutputStreamMicro.computeInt32Size(6, getGrouponId());
                        }
                        if (hasGrouponUrlMobile()) {
                            i += CodedOutputStreamMicro.computeStringSize(7, getGrouponUrlMobile());
                        }
                        if (hasCnName()) {
                            i += CodedOutputStreamMicro.computeStringSize(8, getCnName());
                        }
                        if (hasGrouponUrlPc()) {
                            i += CodedOutputStreamMicro.computeStringSize(9, getGrouponUrlPc());
                        }
                        if (hasGrouponImage()) {
                            i += CodedOutputStreamMicro.computeStringSize(10, getGrouponImage());
                        }
                        if (hasGrouponRebate()) {
                            i += CodedOutputStreamMicro.computeStringSize(11, getGrouponRebate());
                        }
                        if (hasGrouponSite()) {
                            i += CodedOutputStreamMicro.computeStringSize(12, getGrouponSite());
                        }
                        if (hasGrouponEnd()) {
                            i += CodedOutputStreamMicro.computeStringSize(13, getGrouponEnd());
                        }
                        if (hasGrouponTitle()) {
                            i += CodedOutputStreamMicro.computeStringSize(14, getGrouponTitle());
                        }
                        if (hasGrouponWebappUrl()) {
                            i += CodedOutputStreamMicro.computeStringSize(15, getGrouponWebappUrl());
                        }
                        this.f11370E = i;
                        return i;
                    }

                    public boolean hasCnName() {
                        return this.f11385o;
                    }

                    public boolean hasGrouponEnd() {
                        return this.f11395y;
                    }

                    public boolean hasGrouponId() {
                        return this.f11381k;
                    }

                    public boolean hasGrouponImage() {
                        return this.f11389s;
                    }

                    public boolean hasGrouponNum() {
                        return this.f11375e;
                    }

                    public boolean hasGrouponPrice() {
                        return this.f11377g;
                    }

                    public boolean hasGrouponRebate() {
                        return this.f11391u;
                    }

                    public boolean hasGrouponSite() {
                        return this.f11393w;
                    }

                    public boolean hasGrouponStart() {
                        return this.f11371a;
                    }

                    public boolean hasGrouponTitle() {
                        return this.f11366A;
                    }

                    public boolean hasGrouponType() {
                        return this.f11379i;
                    }

                    public boolean hasGrouponUrlMobile() {
                        return this.f11383m;
                    }

                    public boolean hasGrouponUrlPc() {
                        return this.f11387q;
                    }

                    public boolean hasGrouponWebappUrl() {
                        return this.f11368C;
                    }

                    public boolean hasRegularPrice() {
                        return this.f11373c;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Groupon mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    setGrouponStart(codedInputStreamMicro.readString());
                                    continue;
                                case 18:
                                    setRegularPrice(codedInputStreamMicro.readString());
                                    continue;
                                case 26:
                                    setGrouponNum(codedInputStreamMicro.readString());
                                    continue;
                                case 34:
                                    setGrouponPrice(codedInputStreamMicro.readString());
                                    continue;
                                case 42:
                                    setGrouponType(codedInputStreamMicro.readString());
                                    continue;
                                case 48:
                                    setGrouponId(codedInputStreamMicro.readInt32());
                                    continue;
                                case 58:
                                    setGrouponUrlMobile(codedInputStreamMicro.readString());
                                    continue;
                                case 66:
                                    setCnName(codedInputStreamMicro.readString());
                                    continue;
                                case 74:
                                    setGrouponUrlPc(codedInputStreamMicro.readString());
                                    continue;
                                case 82:
                                    setGrouponImage(codedInputStreamMicro.readString());
                                    continue;
                                case 90:
                                    setGrouponRebate(codedInputStreamMicro.readString());
                                    continue;
                                case 98:
                                    setGrouponSite(codedInputStreamMicro.readString());
                                    continue;
                                case 106:
                                    setGrouponEnd(codedInputStreamMicro.readString());
                                    continue;
                                case 114:
                                    setGrouponTitle(codedInputStreamMicro.readString());
                                    continue;
                                case C1253f.df /*122*/:
                                    setGrouponWebappUrl(codedInputStreamMicro.readString());
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

                    public Groupon setCnName(String str) {
                        this.f11385o = true;
                        this.f11386p = str;
                        return this;
                    }

                    public Groupon setGrouponEnd(String str) {
                        this.f11395y = true;
                        this.f11396z = str;
                        return this;
                    }

                    public Groupon setGrouponId(int i) {
                        this.f11381k = true;
                        this.f11382l = i;
                        return this;
                    }

                    public Groupon setGrouponImage(String str) {
                        this.f11389s = true;
                        this.f11390t = str;
                        return this;
                    }

                    public Groupon setGrouponNum(String str) {
                        this.f11375e = true;
                        this.f11376f = str;
                        return this;
                    }

                    public Groupon setGrouponPrice(String str) {
                        this.f11377g = true;
                        this.f11378h = str;
                        return this;
                    }

                    public Groupon setGrouponRebate(String str) {
                        this.f11391u = true;
                        this.f11392v = str;
                        return this;
                    }

                    public Groupon setGrouponSite(String str) {
                        this.f11393w = true;
                        this.f11394x = str;
                        return this;
                    }

                    public Groupon setGrouponStart(String str) {
                        this.f11371a = true;
                        this.f11372b = str;
                        return this;
                    }

                    public Groupon setGrouponTitle(String str) {
                        this.f11366A = true;
                        this.f11367B = str;
                        return this;
                    }

                    public Groupon setGrouponType(String str) {
                        this.f11379i = true;
                        this.f11380j = str;
                        return this;
                    }

                    public Groupon setGrouponUrlMobile(String str) {
                        this.f11383m = true;
                        this.f11384n = str;
                        return this;
                    }

                    public Groupon setGrouponUrlPc(String str) {
                        this.f11387q = true;
                        this.f11388r = str;
                        return this;
                    }

                    public Groupon setGrouponWebappUrl(String str) {
                        this.f11368C = true;
                        this.f11369D = str;
                        return this;
                    }

                    public Groupon setRegularPrice(String str) {
                        this.f11373c = true;
                        this.f11374d = str;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasGrouponStart()) {
                            codedOutputStreamMicro.writeString(1, getGrouponStart());
                        }
                        if (hasRegularPrice()) {
                            codedOutputStreamMicro.writeString(2, getRegularPrice());
                        }
                        if (hasGrouponNum()) {
                            codedOutputStreamMicro.writeString(3, getGrouponNum());
                        }
                        if (hasGrouponPrice()) {
                            codedOutputStreamMicro.writeString(4, getGrouponPrice());
                        }
                        if (hasGrouponType()) {
                            codedOutputStreamMicro.writeString(5, getGrouponType());
                        }
                        if (hasGrouponId()) {
                            codedOutputStreamMicro.writeInt32(6, getGrouponId());
                        }
                        if (hasGrouponUrlMobile()) {
                            codedOutputStreamMicro.writeString(7, getGrouponUrlMobile());
                        }
                        if (hasCnName()) {
                            codedOutputStreamMicro.writeString(8, getCnName());
                        }
                        if (hasGrouponUrlPc()) {
                            codedOutputStreamMicro.writeString(9, getGrouponUrlPc());
                        }
                        if (hasGrouponImage()) {
                            codedOutputStreamMicro.writeString(10, getGrouponImage());
                        }
                        if (hasGrouponRebate()) {
                            codedOutputStreamMicro.writeString(11, getGrouponRebate());
                        }
                        if (hasGrouponSite()) {
                            codedOutputStreamMicro.writeString(12, getGrouponSite());
                        }
                        if (hasGrouponEnd()) {
                            codedOutputStreamMicro.writeString(13, getGrouponEnd());
                        }
                        if (hasGrouponTitle()) {
                            codedOutputStreamMicro.writeString(14, getGrouponTitle());
                        }
                        if (hasGrouponWebappUrl()) {
                            codedOutputStreamMicro.writeString(15, getGrouponWebappUrl());
                        }
                    }
                }

                public static final class HotelOriInfo extends MessageMicro {
                    public static final int HOTEL_FLAG_FIELD_NUMBER = 3;
                    public static final int HOTEL_ID_FIELD_NUMBER = 2;
                    public static final int SRC_FIELD_NUMBER = 1;
                    /* renamed from: a */
                    private boolean f11397a;
                    /* renamed from: b */
                    private String f11398b = "";
                    /* renamed from: c */
                    private boolean f11399c;
                    /* renamed from: d */
                    private String f11400d = "";
                    /* renamed from: e */
                    private boolean f11401e;
                    /* renamed from: f */
                    private String f11402f = "";
                    /* renamed from: g */
                    private int f11403g = -1;

                    public static HotelOriInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new HotelOriInfo().mergeFrom(codedInputStreamMicro);
                    }

                    public static HotelOriInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (HotelOriInfo) new HotelOriInfo().mergeFrom(bArr);
                    }

                    public final HotelOriInfo clear() {
                        clearSrc();
                        clearHotelId();
                        clearHotelFlag();
                        this.f11403g = -1;
                        return this;
                    }

                    public HotelOriInfo clearHotelFlag() {
                        this.f11401e = false;
                        this.f11402f = "";
                        return this;
                    }

                    public HotelOriInfo clearHotelId() {
                        this.f11399c = false;
                        this.f11400d = "";
                        return this;
                    }

                    public HotelOriInfo clearSrc() {
                        this.f11397a = false;
                        this.f11398b = "";
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f11403g < 0) {
                            getSerializedSize();
                        }
                        return this.f11403g;
                    }

                    public String getHotelFlag() {
                        return this.f11402f;
                    }

                    public String getHotelId() {
                        return this.f11400d;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasSrc()) {
                            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getSrc());
                        }
                        if (hasHotelId()) {
                            i += CodedOutputStreamMicro.computeStringSize(2, getHotelId());
                        }
                        if (hasHotelFlag()) {
                            i += CodedOutputStreamMicro.computeStringSize(3, getHotelFlag());
                        }
                        this.f11403g = i;
                        return i;
                    }

                    public String getSrc() {
                        return this.f11398b;
                    }

                    public boolean hasHotelFlag() {
                        return this.f11401e;
                    }

                    public boolean hasHotelId() {
                        return this.f11399c;
                    }

                    public boolean hasSrc() {
                        return this.f11397a;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public HotelOriInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    setSrc(codedInputStreamMicro.readString());
                                    continue;
                                case 18:
                                    setHotelId(codedInputStreamMicro.readString());
                                    continue;
                                case 26:
                                    setHotelFlag(codedInputStreamMicro.readString());
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

                    public HotelOriInfo setHotelFlag(String str) {
                        this.f11401e = true;
                        this.f11402f = str;
                        return this;
                    }

                    public HotelOriInfo setHotelId(String str) {
                        this.f11399c = true;
                        this.f11400d = str;
                        return this;
                    }

                    public HotelOriInfo setSrc(String str) {
                        this.f11397a = true;
                        this.f11398b = str;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasSrc()) {
                            codedOutputStreamMicro.writeString(1, getSrc());
                        }
                        if (hasHotelId()) {
                            codedOutputStreamMicro.writeString(2, getHotelId());
                        }
                        if (hasHotelFlag()) {
                            codedOutputStreamMicro.writeString(3, getHotelFlag());
                        }
                    }
                }

                public static final class LbcBusinessVip extends MessageMicro {
                    public static final int AMOUNT_FIELD_NUMBER = 3;
                    public static final int COMMENT_FIELD_NUMBER = 2;
                    public static final int LISTS_FIELD_NUMBER = 4;
                    public static final int TYPE_FIELD_NUMBER = 1;
                    /* renamed from: a */
                    private boolean f11404a;
                    /* renamed from: b */
                    private int f11405b = 0;
                    /* renamed from: c */
                    private boolean f11406c;
                    /* renamed from: d */
                    private String f11407d = "";
                    /* renamed from: e */
                    private boolean f11408e;
                    /* renamed from: f */
                    private String f11409f = "";
                    /* renamed from: g */
                    private boolean f11410g;
                    /* renamed from: h */
                    private String f11411h = "";
                    /* renamed from: i */
                    private int f11412i = -1;

                    public static LbcBusinessVip parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new LbcBusinessVip().mergeFrom(codedInputStreamMicro);
                    }

                    public static LbcBusinessVip parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (LbcBusinessVip) new LbcBusinessVip().mergeFrom(bArr);
                    }

                    public final LbcBusinessVip clear() {
                        clearType();
                        clearComment();
                        clearAmount();
                        clearLists();
                        this.f11412i = -1;
                        return this;
                    }

                    public LbcBusinessVip clearAmount() {
                        this.f11408e = false;
                        this.f11409f = "";
                        return this;
                    }

                    public LbcBusinessVip clearComment() {
                        this.f11406c = false;
                        this.f11407d = "";
                        return this;
                    }

                    public LbcBusinessVip clearLists() {
                        this.f11410g = false;
                        this.f11411h = "";
                        return this;
                    }

                    public LbcBusinessVip clearType() {
                        this.f11404a = false;
                        this.f11405b = 0;
                        return this;
                    }

                    public String getAmount() {
                        return this.f11409f;
                    }

                    public int getCachedSize() {
                        if (this.f11412i < 0) {
                            getSerializedSize();
                        }
                        return this.f11412i;
                    }

                    public String getComment() {
                        return this.f11407d;
                    }

                    public String getLists() {
                        return this.f11411h;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasType()) {
                            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getType());
                        }
                        if (hasComment()) {
                            i += CodedOutputStreamMicro.computeStringSize(2, getComment());
                        }
                        if (hasAmount()) {
                            i += CodedOutputStreamMicro.computeStringSize(3, getAmount());
                        }
                        if (hasLists()) {
                            i += CodedOutputStreamMicro.computeStringSize(4, getLists());
                        }
                        this.f11412i = i;
                        return i;
                    }

                    public int getType() {
                        return this.f11405b;
                    }

                    public boolean hasAmount() {
                        return this.f11408e;
                    }

                    public boolean hasComment() {
                        return this.f11406c;
                    }

                    public boolean hasLists() {
                        return this.f11410g;
                    }

                    public boolean hasType() {
                        return this.f11404a;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public LbcBusinessVip mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    setType(codedInputStreamMicro.readInt32());
                                    continue;
                                case 18:
                                    setComment(codedInputStreamMicro.readString());
                                    continue;
                                case 26:
                                    setAmount(codedInputStreamMicro.readString());
                                    continue;
                                case 34:
                                    setLists(codedInputStreamMicro.readString());
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

                    public LbcBusinessVip setAmount(String str) {
                        this.f11408e = true;
                        this.f11409f = str;
                        return this;
                    }

                    public LbcBusinessVip setComment(String str) {
                        this.f11406c = true;
                        this.f11407d = str;
                        return this;
                    }

                    public LbcBusinessVip setLists(String str) {
                        this.f11410g = true;
                        this.f11411h = str;
                        return this;
                    }

                    public LbcBusinessVip setType(int i) {
                        this.f11404a = true;
                        this.f11405b = i;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasType()) {
                            codedOutputStreamMicro.writeInt32(1, getType());
                        }
                        if (hasComment()) {
                            codedOutputStreamMicro.writeString(2, getComment());
                        }
                        if (hasAmount()) {
                            codedOutputStreamMicro.writeString(3, getAmount());
                        }
                        if (hasLists()) {
                            codedOutputStreamMicro.writeString(4, getLists());
                        }
                    }
                }

                public static final class Link extends MessageMicro {
                    public static final int CN_NAME_FIELD_NUMBER = 4;
                    public static final int NAME_FIELD_NUMBER = 5;
                    public static final int SRC_FIELD_NUMBER = 1;
                    public static final int URL_FIELD_NUMBER = 2;
                    public static final int URL_MOBILEPHONE_FIELD_NUMBER = 3;
                    /* renamed from: a */
                    private boolean f11413a;
                    /* renamed from: b */
                    private String f11414b = "";
                    /* renamed from: c */
                    private boolean f11415c;
                    /* renamed from: d */
                    private String f11416d = "";
                    /* renamed from: e */
                    private boolean f11417e;
                    /* renamed from: f */
                    private String f11418f = "";
                    /* renamed from: g */
                    private boolean f11419g;
                    /* renamed from: h */
                    private String f11420h = "";
                    /* renamed from: i */
                    private boolean f11421i;
                    /* renamed from: j */
                    private String f11422j = "";
                    /* renamed from: k */
                    private int f11423k = -1;

                    public static Link parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Link().mergeFrom(codedInputStreamMicro);
                    }

                    public static Link parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Link) new Link().mergeFrom(bArr);
                    }

                    public final Link clear() {
                        clearSrc();
                        clearUrl();
                        clearUrlMobilephone();
                        clearCnName();
                        clearName();
                        this.f11423k = -1;
                        return this;
                    }

                    public Link clearCnName() {
                        this.f11419g = false;
                        this.f11420h = "";
                        return this;
                    }

                    public Link clearName() {
                        this.f11421i = false;
                        this.f11422j = "";
                        return this;
                    }

                    public Link clearSrc() {
                        this.f11413a = false;
                        this.f11414b = "";
                        return this;
                    }

                    public Link clearUrl() {
                        this.f11415c = false;
                        this.f11416d = "";
                        return this;
                    }

                    public Link clearUrlMobilephone() {
                        this.f11417e = false;
                        this.f11418f = "";
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f11423k < 0) {
                            getSerializedSize();
                        }
                        return this.f11423k;
                    }

                    public String getCnName() {
                        return this.f11420h;
                    }

                    public String getName() {
                        return this.f11422j;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasSrc()) {
                            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getSrc());
                        }
                        if (hasUrl()) {
                            i += CodedOutputStreamMicro.computeStringSize(2, getUrl());
                        }
                        if (hasUrlMobilephone()) {
                            i += CodedOutputStreamMicro.computeStringSize(3, getUrlMobilephone());
                        }
                        if (hasCnName()) {
                            i += CodedOutputStreamMicro.computeStringSize(4, getCnName());
                        }
                        if (hasName()) {
                            i += CodedOutputStreamMicro.computeStringSize(5, getName());
                        }
                        this.f11423k = i;
                        return i;
                    }

                    public String getSrc() {
                        return this.f11414b;
                    }

                    public String getUrl() {
                        return this.f11416d;
                    }

                    public String getUrlMobilephone() {
                        return this.f11418f;
                    }

                    public boolean hasCnName() {
                        return this.f11419g;
                    }

                    public boolean hasName() {
                        return this.f11421i;
                    }

                    public boolean hasSrc() {
                        return this.f11413a;
                    }

                    public boolean hasUrl() {
                        return this.f11415c;
                    }

                    public boolean hasUrlMobilephone() {
                        return this.f11417e;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Link mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    setSrc(codedInputStreamMicro.readString());
                                    continue;
                                case 18:
                                    setUrl(codedInputStreamMicro.readString());
                                    continue;
                                case 26:
                                    setUrlMobilephone(codedInputStreamMicro.readString());
                                    continue;
                                case 34:
                                    setCnName(codedInputStreamMicro.readString());
                                    continue;
                                case 42:
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

                    public Link setCnName(String str) {
                        this.f11419g = true;
                        this.f11420h = str;
                        return this;
                    }

                    public Link setName(String str) {
                        this.f11421i = true;
                        this.f11422j = str;
                        return this;
                    }

                    public Link setSrc(String str) {
                        this.f11413a = true;
                        this.f11414b = str;
                        return this;
                    }

                    public Link setUrl(String str) {
                        this.f11415c = true;
                        this.f11416d = str;
                        return this;
                    }

                    public Link setUrlMobilephone(String str) {
                        this.f11417e = true;
                        this.f11418f = str;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasSrc()) {
                            codedOutputStreamMicro.writeString(1, getSrc());
                        }
                        if (hasUrl()) {
                            codedOutputStreamMicro.writeString(2, getUrl());
                        }
                        if (hasUrlMobilephone()) {
                            codedOutputStreamMicro.writeString(3, getUrlMobilephone());
                        }
                        if (hasCnName()) {
                            codedOutputStreamMicro.writeString(4, getCnName());
                        }
                        if (hasName()) {
                            codedOutputStreamMicro.writeString(5, getName());
                        }
                    }
                }

                public static final class Mbc extends MessageMicro {
                    public static final int MARKV_FIELD_NUMBER = 1;
                    /* renamed from: a */
                    private boolean f11424a;
                    /* renamed from: b */
                    private String f11425b = "";
                    /* renamed from: c */
                    private int f11426c = -1;

                    public static Mbc parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Mbc().mergeFrom(codedInputStreamMicro);
                    }

                    public static Mbc parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Mbc) new Mbc().mergeFrom(bArr);
                    }

                    public final Mbc clear() {
                        clearMarkv();
                        this.f11426c = -1;
                        return this;
                    }

                    public Mbc clearMarkv() {
                        this.f11424a = false;
                        this.f11425b = "";
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f11426c < 0) {
                            getSerializedSize();
                        }
                        return this.f11426c;
                    }

                    public String getMarkv() {
                        return this.f11425b;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasMarkv()) {
                            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getMarkv());
                        }
                        this.f11426c = i;
                        return i;
                    }

                    public boolean hasMarkv() {
                        return this.f11424a;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Mbc mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    setMarkv(codedInputStreamMicro.readString());
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

                    public Mbc setMarkv(String str) {
                        this.f11424a = true;
                        this.f11425b = str;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasMarkv()) {
                            codedOutputStreamMicro.writeString(1, getMarkv());
                        }
                    }
                }

                public static final class Meishipaihao extends MessageMicro {
                    public static final int IS_OK_FIELD_NUMBER = 1;
                    public static final int MAIN_FIELD_NUMBER = 2;
                    /* renamed from: a */
                    private boolean f11432a;
                    /* renamed from: b */
                    private int f11433b = 0;
                    /* renamed from: c */
                    private boolean f11434c;
                    /* renamed from: d */
                    private Main f11435d = null;
                    /* renamed from: e */
                    private int f11436e = -1;

                    public static final class Main extends MessageMicro {
                        public static final int THIRD_FROM_FIELD_NUMBER = 1;
                        public static final int THIRD_ID_FIELD_NUMBER = 2;
                        /* renamed from: a */
                        private boolean f11427a;
                        /* renamed from: b */
                        private String f11428b = "";
                        /* renamed from: c */
                        private boolean f11429c;
                        /* renamed from: d */
                        private String f11430d = "";
                        /* renamed from: e */
                        private int f11431e = -1;

                        public static Main parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new Main().mergeFrom(codedInputStreamMicro);
                        }

                        public static Main parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (Main) new Main().mergeFrom(bArr);
                        }

                        public final Main clear() {
                            clearThirdFrom();
                            clearThirdId();
                            this.f11431e = -1;
                            return this;
                        }

                        public Main clearThirdFrom() {
                            this.f11427a = false;
                            this.f11428b = "";
                            return this;
                        }

                        public Main clearThirdId() {
                            this.f11429c = false;
                            this.f11430d = "";
                            return this;
                        }

                        public int getCachedSize() {
                            if (this.f11431e < 0) {
                                getSerializedSize();
                            }
                            return this.f11431e;
                        }

                        public int getSerializedSize() {
                            int i = 0;
                            if (hasThirdFrom()) {
                                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getThirdFrom());
                            }
                            if (hasThirdId()) {
                                i += CodedOutputStreamMicro.computeStringSize(2, getThirdId());
                            }
                            this.f11431e = i;
                            return i;
                        }

                        public String getThirdFrom() {
                            return this.f11428b;
                        }

                        public String getThirdId() {
                            return this.f11430d;
                        }

                        public boolean hasThirdFrom() {
                            return this.f11427a;
                        }

                        public boolean hasThirdId() {
                            return this.f11429c;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public Main mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                switch (readTag) {
                                    case 0:
                                        break;
                                    case 10:
                                        setThirdFrom(codedInputStreamMicro.readString());
                                        continue;
                                    case 18:
                                        setThirdId(codedInputStreamMicro.readString());
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

                        public Main setThirdFrom(String str) {
                            this.f11427a = true;
                            this.f11428b = str;
                            return this;
                        }

                        public Main setThirdId(String str) {
                            this.f11429c = true;
                            this.f11430d = str;
                            return this;
                        }

                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasThirdFrom()) {
                                codedOutputStreamMicro.writeString(1, getThirdFrom());
                            }
                            if (hasThirdId()) {
                                codedOutputStreamMicro.writeString(2, getThirdId());
                            }
                        }
                    }

                    public static Meishipaihao parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Meishipaihao().mergeFrom(codedInputStreamMicro);
                    }

                    public static Meishipaihao parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Meishipaihao) new Meishipaihao().mergeFrom(bArr);
                    }

                    public final Meishipaihao clear() {
                        clearIsOk();
                        clearMain();
                        this.f11436e = -1;
                        return this;
                    }

                    public Meishipaihao clearIsOk() {
                        this.f11432a = false;
                        this.f11433b = 0;
                        return this;
                    }

                    public Meishipaihao clearMain() {
                        this.f11434c = false;
                        this.f11435d = null;
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f11436e < 0) {
                            getSerializedSize();
                        }
                        return this.f11436e;
                    }

                    public int getIsOk() {
                        return this.f11433b;
                    }

                    public Main getMain() {
                        return this.f11435d;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasIsOk()) {
                            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIsOk());
                        }
                        if (hasMain()) {
                            i += CodedOutputStreamMicro.computeMessageSize(2, getMain());
                        }
                        this.f11436e = i;
                        return i;
                    }

                    public boolean hasIsOk() {
                        return this.f11432a;
                    }

                    public boolean hasMain() {
                        return this.f11434c;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Meishipaihao mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    setIsOk(codedInputStreamMicro.readInt32());
                                    continue;
                                case 18:
                                    MessageMicro main = new Main();
                                    codedInputStreamMicro.readMessage(main);
                                    setMain(main);
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

                    public Meishipaihao setIsOk(int i) {
                        this.f11432a = true;
                        this.f11433b = i;
                        return this;
                    }

                    public Meishipaihao setMain(Main main) {
                        if (main == null) {
                            return clearMain();
                        }
                        this.f11434c = true;
                        this.f11435d = main;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasIsOk()) {
                            codedOutputStreamMicro.writeInt32(1, getIsOk());
                        }
                        if (hasMain()) {
                            codedOutputStreamMicro.writeMessage(2, getMain());
                        }
                    }
                }

                public static final class OtaInfo extends MessageMicro {
                    public static final int EN_NAME_FIELD_NUMBER = 1;
                    public static final int OTA_PHONE_FIELD_NUMBER = 2;
                    public static final int OTA_TIPS_FIELD_NUMBER = 3;
                    /* renamed from: a */
                    private boolean f11437a;
                    /* renamed from: b */
                    private String f11438b = "";
                    /* renamed from: c */
                    private boolean f11439c;
                    /* renamed from: d */
                    private String f11440d = "";
                    /* renamed from: e */
                    private boolean f11441e;
                    /* renamed from: f */
                    private String f11442f = "";
                    /* renamed from: g */
                    private int f11443g = -1;

                    public static OtaInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new OtaInfo().mergeFrom(codedInputStreamMicro);
                    }

                    public static OtaInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (OtaInfo) new OtaInfo().mergeFrom(bArr);
                    }

                    public final OtaInfo clear() {
                        clearEnName();
                        clearOtaPhone();
                        clearOtaTips();
                        this.f11443g = -1;
                        return this;
                    }

                    public OtaInfo clearEnName() {
                        this.f11437a = false;
                        this.f11438b = "";
                        return this;
                    }

                    public OtaInfo clearOtaPhone() {
                        this.f11439c = false;
                        this.f11440d = "";
                        return this;
                    }

                    public OtaInfo clearOtaTips() {
                        this.f11441e = false;
                        this.f11442f = "";
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f11443g < 0) {
                            getSerializedSize();
                        }
                        return this.f11443g;
                    }

                    public String getEnName() {
                        return this.f11438b;
                    }

                    public String getOtaPhone() {
                        return this.f11440d;
                    }

                    public String getOtaTips() {
                        return this.f11442f;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasEnName()) {
                            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getEnName());
                        }
                        if (hasOtaPhone()) {
                            i += CodedOutputStreamMicro.computeStringSize(2, getOtaPhone());
                        }
                        if (hasOtaTips()) {
                            i += CodedOutputStreamMicro.computeStringSize(3, getOtaTips());
                        }
                        this.f11443g = i;
                        return i;
                    }

                    public boolean hasEnName() {
                        return this.f11437a;
                    }

                    public boolean hasOtaPhone() {
                        return this.f11439c;
                    }

                    public boolean hasOtaTips() {
                        return this.f11441e;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public OtaInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    setEnName(codedInputStreamMicro.readString());
                                    continue;
                                case 18:
                                    setOtaPhone(codedInputStreamMicro.readString());
                                    continue;
                                case 26:
                                    setOtaTips(codedInputStreamMicro.readString());
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

                    public OtaInfo setEnName(String str) {
                        this.f11437a = true;
                        this.f11438b = str;
                        return this;
                    }

                    public OtaInfo setOtaPhone(String str) {
                        this.f11439c = true;
                        this.f11440d = str;
                        return this;
                    }

                    public OtaInfo setOtaTips(String str) {
                        this.f11441e = true;
                        this.f11442f = str;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasEnName()) {
                            codedOutputStreamMicro.writeString(1, getEnName());
                        }
                        if (hasOtaPhone()) {
                            codedOutputStreamMicro.writeString(2, getOtaPhone());
                        }
                        if (hasOtaTips()) {
                            codedOutputStreamMicro.writeString(3, getOtaTips());
                        }
                    }
                }

                public static final class OtaUrl extends MessageMicro {
                    public static final int SRC_FIELD_NUMBER = 1;
                    public static final int URL_FIELD_NUMBER = 2;
                    /* renamed from: a */
                    private boolean f11444a;
                    /* renamed from: b */
                    private String f11445b = "";
                    /* renamed from: c */
                    private boolean f11446c;
                    /* renamed from: d */
                    private String f11447d = "";
                    /* renamed from: e */
                    private int f11448e = -1;

                    public static OtaUrl parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new OtaUrl().mergeFrom(codedInputStreamMicro);
                    }

                    public static OtaUrl parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (OtaUrl) new OtaUrl().mergeFrom(bArr);
                    }

                    public final OtaUrl clear() {
                        clearSrc();
                        clearUrl();
                        this.f11448e = -1;
                        return this;
                    }

                    public OtaUrl clearSrc() {
                        this.f11444a = false;
                        this.f11445b = "";
                        return this;
                    }

                    public OtaUrl clearUrl() {
                        this.f11446c = false;
                        this.f11447d = "";
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f11448e < 0) {
                            getSerializedSize();
                        }
                        return this.f11448e;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasSrc()) {
                            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getSrc());
                        }
                        if (hasUrl()) {
                            i += CodedOutputStreamMicro.computeStringSize(2, getUrl());
                        }
                        this.f11448e = i;
                        return i;
                    }

                    public String getSrc() {
                        return this.f11445b;
                    }

                    public String getUrl() {
                        return this.f11447d;
                    }

                    public boolean hasSrc() {
                        return this.f11444a;
                    }

                    public boolean hasUrl() {
                        return this.f11446c;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public OtaUrl mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    setSrc(codedInputStreamMicro.readString());
                                    continue;
                                case 18:
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

                    public OtaUrl setSrc(String str) {
                        this.f11444a = true;
                        this.f11445b = str;
                        return this;
                    }

                    public OtaUrl setUrl(String str) {
                        this.f11446c = true;
                        this.f11447d = str;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasSrc()) {
                            codedOutputStreamMicro.writeString(1, getSrc());
                        }
                        if (hasUrl()) {
                            codedOutputStreamMicro.writeString(2, getUrl());
                        }
                    }
                }

                public static final class Point extends MessageMicro {
                    public static final int X_FIELD_NUMBER = 1;
                    public static final int Y_FIELD_NUMBER = 2;
                    /* renamed from: a */
                    private boolean f11449a;
                    /* renamed from: b */
                    private double f11450b = 0.0d;
                    /* renamed from: c */
                    private boolean f11451c;
                    /* renamed from: d */
                    private double f11452d = 0.0d;
                    /* renamed from: e */
                    private int f11453e = -1;

                    public static Point parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Point().mergeFrom(codedInputStreamMicro);
                    }

                    public static Point parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Point) new Point().mergeFrom(bArr);
                    }

                    public final Point clear() {
                        clearX();
                        clearY();
                        this.f11453e = -1;
                        return this;
                    }

                    public Point clearX() {
                        this.f11449a = false;
                        this.f11450b = 0.0d;
                        return this;
                    }

                    public Point clearY() {
                        this.f11451c = false;
                        this.f11452d = 0.0d;
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f11453e < 0) {
                            getSerializedSize();
                        }
                        return this.f11453e;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasX()) {
                            i = 0 + CodedOutputStreamMicro.computeDoubleSize(1, getX());
                        }
                        if (hasY()) {
                            i += CodedOutputStreamMicro.computeDoubleSize(2, getY());
                        }
                        this.f11453e = i;
                        return i;
                    }

                    public double getX() {
                        return this.f11450b;
                    }

                    public double getY() {
                        return this.f11452d;
                    }

                    public boolean hasX() {
                        return this.f11449a;
                    }

                    public boolean hasY() {
                        return this.f11451c;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Point mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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

                    public Point setX(double d) {
                        this.f11449a = true;
                        this.f11450b = d;
                        return this;
                    }

                    public Point setY(double d) {
                        this.f11451c = true;
                        this.f11452d = d;
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

                public static final class Toplist extends MessageMicro {
                    public static final int TOP_FIELD_NUMBER = 1;
                    /* renamed from: a */
                    private boolean f11473a;
                    /* renamed from: b */
                    private Top f11474b = null;
                    /* renamed from: c */
                    private int f11475c = -1;

                    public static final class Top extends MessageMicro {
                        public static final int COMMENT_NUM_FIELD_NUMBER = 9;
                        public static final int NAME_FIELD_NUMBER = 2;
                        public static final int OVERALL_RATING_FIELD_NUMBER = 8;
                        public static final int RANK_FIELD_NUMBER = 5;
                        public static final int REGION_FIELD_NUMBER = 3;
                        public static final int TAG_FIELD_NUMBER = 4;
                        public static final int TITLE_FIELD_NUMBER = 6;
                        public static final int UID_FIELD_NUMBER = 1;
                        public static final int WEEK_VISIT_FIELD_NUMBER = 7;
                        /* renamed from: a */
                        private boolean f11454a;
                        /* renamed from: b */
                        private String f11455b = "";
                        /* renamed from: c */
                        private boolean f11456c;
                        /* renamed from: d */
                        private String f11457d = "";
                        /* renamed from: e */
                        private boolean f11458e;
                        /* renamed from: f */
                        private String f11459f = "";
                        /* renamed from: g */
                        private boolean f11460g;
                        /* renamed from: h */
                        private String f11461h = "";
                        /* renamed from: i */
                        private boolean f11462i;
                        /* renamed from: j */
                        private String f11463j = "";
                        /* renamed from: k */
                        private boolean f11464k;
                        /* renamed from: l */
                        private String f11465l = "";
                        /* renamed from: m */
                        private boolean f11466m;
                        /* renamed from: n */
                        private String f11467n = "";
                        /* renamed from: o */
                        private boolean f11468o;
                        /* renamed from: p */
                        private String f11469p = "";
                        /* renamed from: q */
                        private boolean f11470q;
                        /* renamed from: r */
                        private String f11471r = "";
                        /* renamed from: s */
                        private int f11472s = -1;

                        public static Top parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new Top().mergeFrom(codedInputStreamMicro);
                        }

                        public static Top parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (Top) new Top().mergeFrom(bArr);
                        }

                        public final Top clear() {
                            clearUid();
                            clearName();
                            clearRegion();
                            clearTag();
                            clearRank();
                            clearTitle();
                            clearWeekVisit();
                            clearOverallRating();
                            clearCommentNum();
                            this.f11472s = -1;
                            return this;
                        }

                        public Top clearCommentNum() {
                            this.f11470q = false;
                            this.f11471r = "";
                            return this;
                        }

                        public Top clearName() {
                            this.f11456c = false;
                            this.f11457d = "";
                            return this;
                        }

                        public Top clearOverallRating() {
                            this.f11468o = false;
                            this.f11469p = "";
                            return this;
                        }

                        public Top clearRank() {
                            this.f11462i = false;
                            this.f11463j = "";
                            return this;
                        }

                        public Top clearRegion() {
                            this.f11458e = false;
                            this.f11459f = "";
                            return this;
                        }

                        public Top clearTag() {
                            this.f11460g = false;
                            this.f11461h = "";
                            return this;
                        }

                        public Top clearTitle() {
                            this.f11464k = false;
                            this.f11465l = "";
                            return this;
                        }

                        public Top clearUid() {
                            this.f11454a = false;
                            this.f11455b = "";
                            return this;
                        }

                        public Top clearWeekVisit() {
                            this.f11466m = false;
                            this.f11467n = "";
                            return this;
                        }

                        public int getCachedSize() {
                            if (this.f11472s < 0) {
                                getSerializedSize();
                            }
                            return this.f11472s;
                        }

                        public String getCommentNum() {
                            return this.f11471r;
                        }

                        public String getName() {
                            return this.f11457d;
                        }

                        public String getOverallRating() {
                            return this.f11469p;
                        }

                        public String getRank() {
                            return this.f11463j;
                        }

                        public String getRegion() {
                            return this.f11459f;
                        }

                        public int getSerializedSize() {
                            int i = 0;
                            if (hasUid()) {
                                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUid());
                            }
                            if (hasName()) {
                                i += CodedOutputStreamMicro.computeStringSize(2, getName());
                            }
                            if (hasRegion()) {
                                i += CodedOutputStreamMicro.computeStringSize(3, getRegion());
                            }
                            if (hasTag()) {
                                i += CodedOutputStreamMicro.computeStringSize(4, getTag());
                            }
                            if (hasRank()) {
                                i += CodedOutputStreamMicro.computeStringSize(5, getRank());
                            }
                            if (hasTitle()) {
                                i += CodedOutputStreamMicro.computeStringSize(6, getTitle());
                            }
                            if (hasWeekVisit()) {
                                i += CodedOutputStreamMicro.computeStringSize(7, getWeekVisit());
                            }
                            if (hasOverallRating()) {
                                i += CodedOutputStreamMicro.computeStringSize(8, getOverallRating());
                            }
                            if (hasCommentNum()) {
                                i += CodedOutputStreamMicro.computeStringSize(9, getCommentNum());
                            }
                            this.f11472s = i;
                            return i;
                        }

                        public String getTag() {
                            return this.f11461h;
                        }

                        public String getTitle() {
                            return this.f11465l;
                        }

                        public String getUid() {
                            return this.f11455b;
                        }

                        public String getWeekVisit() {
                            return this.f11467n;
                        }

                        public boolean hasCommentNum() {
                            return this.f11470q;
                        }

                        public boolean hasName() {
                            return this.f11456c;
                        }

                        public boolean hasOverallRating() {
                            return this.f11468o;
                        }

                        public boolean hasRank() {
                            return this.f11462i;
                        }

                        public boolean hasRegion() {
                            return this.f11458e;
                        }

                        public boolean hasTag() {
                            return this.f11460g;
                        }

                        public boolean hasTitle() {
                            return this.f11464k;
                        }

                        public boolean hasUid() {
                            return this.f11454a;
                        }

                        public boolean hasWeekVisit() {
                            return this.f11466m;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public Top mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                switch (readTag) {
                                    case 0:
                                        break;
                                    case 10:
                                        setUid(codedInputStreamMicro.readString());
                                        continue;
                                    case 18:
                                        setName(codedInputStreamMicro.readString());
                                        continue;
                                    case 26:
                                        setRegion(codedInputStreamMicro.readString());
                                        continue;
                                    case 34:
                                        setTag(codedInputStreamMicro.readString());
                                        continue;
                                    case 42:
                                        setRank(codedInputStreamMicro.readString());
                                        continue;
                                    case 50:
                                        setTitle(codedInputStreamMicro.readString());
                                        continue;
                                    case 58:
                                        setWeekVisit(codedInputStreamMicro.readString());
                                        continue;
                                    case 66:
                                        setOverallRating(codedInputStreamMicro.readString());
                                        continue;
                                    case 74:
                                        setCommentNum(codedInputStreamMicro.readString());
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

                        public Top setCommentNum(String str) {
                            this.f11470q = true;
                            this.f11471r = str;
                            return this;
                        }

                        public Top setName(String str) {
                            this.f11456c = true;
                            this.f11457d = str;
                            return this;
                        }

                        public Top setOverallRating(String str) {
                            this.f11468o = true;
                            this.f11469p = str;
                            return this;
                        }

                        public Top setRank(String str) {
                            this.f11462i = true;
                            this.f11463j = str;
                            return this;
                        }

                        public Top setRegion(String str) {
                            this.f11458e = true;
                            this.f11459f = str;
                            return this;
                        }

                        public Top setTag(String str) {
                            this.f11460g = true;
                            this.f11461h = str;
                            return this;
                        }

                        public Top setTitle(String str) {
                            this.f11464k = true;
                            this.f11465l = str;
                            return this;
                        }

                        public Top setUid(String str) {
                            this.f11454a = true;
                            this.f11455b = str;
                            return this;
                        }

                        public Top setWeekVisit(String str) {
                            this.f11466m = true;
                            this.f11467n = str;
                            return this;
                        }

                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasUid()) {
                                codedOutputStreamMicro.writeString(1, getUid());
                            }
                            if (hasName()) {
                                codedOutputStreamMicro.writeString(2, getName());
                            }
                            if (hasRegion()) {
                                codedOutputStreamMicro.writeString(3, getRegion());
                            }
                            if (hasTag()) {
                                codedOutputStreamMicro.writeString(4, getTag());
                            }
                            if (hasRank()) {
                                codedOutputStreamMicro.writeString(5, getRank());
                            }
                            if (hasTitle()) {
                                codedOutputStreamMicro.writeString(6, getTitle());
                            }
                            if (hasWeekVisit()) {
                                codedOutputStreamMicro.writeString(7, getWeekVisit());
                            }
                            if (hasOverallRating()) {
                                codedOutputStreamMicro.writeString(8, getOverallRating());
                            }
                            if (hasCommentNum()) {
                                codedOutputStreamMicro.writeString(9, getCommentNum());
                            }
                        }
                    }

                    public static Toplist parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Toplist().mergeFrom(codedInputStreamMicro);
                    }

                    public static Toplist parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Toplist) new Toplist().mergeFrom(bArr);
                    }

                    public final Toplist clear() {
                        clearTop();
                        this.f11475c = -1;
                        return this;
                    }

                    public Toplist clearTop() {
                        this.f11473a = false;
                        this.f11474b = null;
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f11475c < 0) {
                            getSerializedSize();
                        }
                        return this.f11475c;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasTop()) {
                            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getTop());
                        }
                        this.f11475c = i;
                        return i;
                    }

                    public Top getTop() {
                        return this.f11474b;
                    }

                    public boolean hasTop() {
                        return this.f11473a;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Toplist mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    MessageMicro top = new Top();
                                    codedInputStreamMicro.readMessage(top);
                                    setTop(top);
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

                    public Toplist setTop(Top top) {
                        if (top == null) {
                            return clearTop();
                        }
                        this.f11473a = true;
                        this.f11474b = top;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasTop()) {
                            codedOutputStreamMicro.writeMessage(1, getTop());
                        }
                    }
                }

                public static final class Upperleftcorner extends MessageMicro {
                    public static final int RESOURCE_ID_FIELD_NUMBER = 1;
                    public static final int RESOURCE_URL_FIELD_NUMBER = 2;
                    /* renamed from: a */
                    private boolean f11476a;
                    /* renamed from: b */
                    private int f11477b = 0;
                    /* renamed from: c */
                    private boolean f11478c;
                    /* renamed from: d */
                    private String f11479d = "";
                    /* renamed from: e */
                    private int f11480e = -1;

                    public static Upperleftcorner parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Upperleftcorner().mergeFrom(codedInputStreamMicro);
                    }

                    public static Upperleftcorner parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Upperleftcorner) new Upperleftcorner().mergeFrom(bArr);
                    }

                    public final Upperleftcorner clear() {
                        clearResourceId();
                        clearResourceUrl();
                        this.f11480e = -1;
                        return this;
                    }

                    public Upperleftcorner clearResourceId() {
                        this.f11476a = false;
                        this.f11477b = 0;
                        return this;
                    }

                    public Upperleftcorner clearResourceUrl() {
                        this.f11478c = false;
                        this.f11479d = "";
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f11480e < 0) {
                            getSerializedSize();
                        }
                        return this.f11480e;
                    }

                    public int getResourceId() {
                        return this.f11477b;
                    }

                    public String getResourceUrl() {
                        return this.f11479d;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasResourceId()) {
                            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getResourceId());
                        }
                        if (hasResourceUrl()) {
                            i += CodedOutputStreamMicro.computeStringSize(2, getResourceUrl());
                        }
                        this.f11480e = i;
                        return i;
                    }

                    public boolean hasResourceId() {
                        return this.f11476a;
                    }

                    public boolean hasResourceUrl() {
                        return this.f11478c;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Upperleftcorner mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    setResourceId(codedInputStreamMicro.readInt32());
                                    continue;
                                case 18:
                                    setResourceUrl(codedInputStreamMicro.readString());
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

                    public Upperleftcorner setResourceId(int i) {
                        this.f11476a = true;
                        this.f11477b = i;
                        return this;
                    }

                    public Upperleftcorner setResourceUrl(String str) {
                        this.f11478c = true;
                        this.f11479d = str;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasResourceId()) {
                            codedOutputStreamMicro.writeInt32(1, getResourceId());
                        }
                        if (hasResourceUrl()) {
                            codedOutputStreamMicro.writeString(2, getResourceUrl());
                        }
                    }
                }

                public static DetailInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new DetailInfo().mergeFrom(codedInputStreamMicro);
                }

                public static DetailInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (DetailInfo) new DetailInfo().mergeFrom(bArr);
                }

                public DetailInfo addFlag(String str) {
                    if (str == null) {
                        throw new NullPointerException();
                    }
                    if (this.aV.isEmpty()) {
                        this.aV = new ArrayList();
                    }
                    this.aV.add(str);
                    return this;
                }

                public DetailInfo addGroupon(Groupon groupon) {
                    if (groupon != null) {
                        if (this.f11507a.isEmpty()) {
                            this.f11507a = new ArrayList();
                        }
                        this.f11507a.add(groupon);
                    }
                    return this;
                }

                public DetailInfo addHotelOriInfo(HotelOriInfo hotelOriInfo) {
                    if (hotelOriInfo != null) {
                        if (this.f11508b.isEmpty()) {
                            this.f11508b = new ArrayList();
                        }
                        this.f11508b.add(hotelOriInfo);
                    }
                    return this;
                }

                public DetailInfo addLink(Link link) {
                    if (link != null) {
                        if (this.f11509c.isEmpty()) {
                            this.f11509c = new ArrayList();
                        }
                        this.f11509c.add(link);
                    }
                    return this;
                }

                public DetailInfo addOtaInfo(OtaInfo otaInfo) {
                    if (otaInfo != null) {
                        if (this.f11510d.isEmpty()) {
                            this.f11510d = new ArrayList();
                        }
                        this.f11510d.add(otaInfo);
                    }
                    return this;
                }

                public DetailInfo addOtaUrl(OtaUrl otaUrl) {
                    if (otaUrl != null) {
                        if (this.f11511e.isEmpty()) {
                            this.f11511e = new ArrayList();
                        }
                        this.f11511e.add(otaUrl);
                    }
                    return this;
                }

                public final DetailInfo clear() {
                    clearGroupon();
                    clearHotelOriInfo();
                    clearLink();
                    clearOtaInfo();
                    clearOtaUrl();
                    clearPoint();
                    clearToplist();
                    clearAreaid();
                    clearBid();
                    clearCheckinNum();
                    clearCollectNum();
                    clearCommentNum();
                    clearFacilityRating();
                    clearFromPds();
                    clearGrouponNum();
                    clearHygieneRating();
                    clearImage();
                    clearImageFrom();
                    clearImageNum();
                    clearLatestNum();
                    clearMiningLowPriceFlag();
                    clearName();
                    clearNewCatalogId();
                    clearOriginPrice();
                    clearOverallRating();
                    clearPcBookable();
                    clearPcRealtimePrice();
                    clearPhone();
                    clearPoiAddress();
                    clearPremiumFlag();
                    clearPrice();
                    clearRecReason();
                    clearRecommandIndex();
                    clearReviewFlag();
                    clearServiceRating();
                    clearShortComm();
                    clearSpecialService();
                    clearSTime();
                    clearStatus();
                    clearStorageSrc();
                    clearTag();
                    clearTonightPrice();
                    clearTonightSaleFlag();
                    clearTotalNum();
                    clearWapBookable();
                    clearWiseFullroom();
                    clearWiseHotelType();
                    clearWiseHotelTypeName();
                    clearWiseLowPrice();
                    clearWisePrice();
                    clearWiseRealtimePrice();
                    clearWiseRealtimePriceFlag();
                    clearFlag();
                    clearGrouponFlag();
                    clearGrouponTotal();
                    clearIsGwj();
                    clearPriceText();
                    clearGuide();
                    clearMeishipaihao();
                    clearBookInfo();
                    clearLbcBusinessVip();
                    clearValidate();
                    clearUpperleftcorner();
                    clearMbc();
                    clearAllcardextension();
                    this.bu = -1;
                    return this;
                }

                public DetailInfo clearAllcardextension() {
                    this.bs = false;
                    this.bt = null;
                    return this;
                }

                public DetailInfo clearAreaid() {
                    this.f11516j = false;
                    this.f11517k = 0;
                    return this;
                }

                public DetailInfo clearBid() {
                    this.f11518l = false;
                    this.f11519m = "";
                    return this;
                }

                public DetailInfo clearBookInfo() {
                    this.bi = false;
                    this.bj = null;
                    return this;
                }

                public DetailInfo clearCheckinNum() {
                    this.f11520n = false;
                    this.f11521o = "";
                    return this;
                }

                public DetailInfo clearCollectNum() {
                    this.f11522p = false;
                    this.f11523q = "";
                    return this;
                }

                public DetailInfo clearCommentNum() {
                    this.f11524r = false;
                    this.f11525s = "";
                    return this;
                }

                public DetailInfo clearFacilityRating() {
                    this.f11526t = false;
                    this.f11527u = "";
                    return this;
                }

                public DetailInfo clearFlag() {
                    this.aV = Collections.emptyList();
                    return this;
                }

                public DetailInfo clearFromPds() {
                    this.f11528v = false;
                    this.f11529w = "";
                    return this;
                }

                public DetailInfo clearGroupon() {
                    this.f11507a = Collections.emptyList();
                    return this;
                }

                public DetailInfo clearGrouponFlag() {
                    this.aW = false;
                    this.aX = 0;
                    return this;
                }

                public DetailInfo clearGrouponNum() {
                    this.f11530x = false;
                    this.f11531y = 0;
                    return this;
                }

                public DetailInfo clearGrouponTotal() {
                    this.aY = false;
                    this.aZ = 0;
                    return this;
                }

                public DetailInfo clearGuide() {
                    this.be = false;
                    this.bf = "";
                    return this;
                }

                public DetailInfo clearHotelOriInfo() {
                    this.f11508b = Collections.emptyList();
                    return this;
                }

                public DetailInfo clearHygieneRating() {
                    this.f11532z = false;
                    this.f11481A = "";
                    return this;
                }

                public DetailInfo clearImage() {
                    this.f11482B = false;
                    this.f11483C = "";
                    return this;
                }

                public DetailInfo clearImageFrom() {
                    this.f11484D = false;
                    this.f11485E = "";
                    return this;
                }

                public DetailInfo clearImageNum() {
                    this.f11486F = false;
                    this.f11487G = "";
                    return this;
                }

                public DetailInfo clearIsGwj() {
                    this.ba = false;
                    this.bb = 0;
                    return this;
                }

                public DetailInfo clearLatestNum() {
                    this.f11488H = false;
                    this.f11489I = "";
                    return this;
                }

                public DetailInfo clearLbcBusinessVip() {
                    this.bk = false;
                    this.bl = null;
                    return this;
                }

                public DetailInfo clearLink() {
                    this.f11509c = Collections.emptyList();
                    return this;
                }

                public DetailInfo clearMbc() {
                    this.bq = false;
                    this.br = null;
                    return this;
                }

                public DetailInfo clearMeishipaihao() {
                    this.bg = false;
                    this.bh = null;
                    return this;
                }

                public DetailInfo clearMiningLowPriceFlag() {
                    this.f11490J = false;
                    this.f11491K = "";
                    return this;
                }

                public DetailInfo clearName() {
                    this.f11492L = false;
                    this.f11493M = "";
                    return this;
                }

                public DetailInfo clearNewCatalogId() {
                    this.f11494N = false;
                    this.f11495O = "";
                    return this;
                }

                public DetailInfo clearOriginPrice() {
                    this.f11496P = false;
                    this.f11497Q = "";
                    return this;
                }

                public DetailInfo clearOtaInfo() {
                    this.f11510d = Collections.emptyList();
                    return this;
                }

                public DetailInfo clearOtaUrl() {
                    this.f11511e = Collections.emptyList();
                    return this;
                }

                public DetailInfo clearOverallRating() {
                    this.f11498R = false;
                    this.f11499S = "";
                    return this;
                }

                public DetailInfo clearPcBookable() {
                    this.f11500T = false;
                    this.f11501U = "";
                    return this;
                }

                public DetailInfo clearPcRealtimePrice() {
                    this.f11502V = false;
                    this.f11503W = "";
                    return this;
                }

                public DetailInfo clearPhone() {
                    this.f11504X = false;
                    this.f11505Y = "";
                    return this;
                }

                public DetailInfo clearPoiAddress() {
                    this.f11506Z = false;
                    this.aa = "";
                    return this;
                }

                public DetailInfo clearPoint() {
                    this.f11512f = false;
                    this.f11513g = null;
                    return this;
                }

                public DetailInfo clearPremiumFlag() {
                    this.ab = false;
                    this.ac = 0;
                    return this;
                }

                public DetailInfo clearPrice() {
                    this.ad = false;
                    this.ae = "";
                    return this;
                }

                public DetailInfo clearPriceText() {
                    this.bc = false;
                    this.bd = "";
                    return this;
                }

                public DetailInfo clearRecReason() {
                    this.af = false;
                    this.ag = "";
                    return this;
                }

                public DetailInfo clearRecommandIndex() {
                    this.ah = false;
                    this.ai = "";
                    return this;
                }

                public DetailInfo clearReviewFlag() {
                    this.aj = false;
                    this.ak = 0;
                    return this;
                }

                public DetailInfo clearSTime() {
                    this.ar = false;
                    this.as = 0;
                    return this;
                }

                public DetailInfo clearServiceRating() {
                    this.al = false;
                    this.am = "";
                    return this;
                }

                public DetailInfo clearShortComm() {
                    this.an = false;
                    this.ao = "";
                    return this;
                }

                public DetailInfo clearSpecialService() {
                    this.ap = false;
                    this.aq = "";
                    return this;
                }

                public DetailInfo clearStatus() {
                    this.at = false;
                    this.au = "";
                    return this;
                }

                public DetailInfo clearStorageSrc() {
                    this.av = false;
                    this.aw = "";
                    return this;
                }

                public DetailInfo clearTag() {
                    this.ax = false;
                    this.ay = "";
                    return this;
                }

                public DetailInfo clearTonightPrice() {
                    this.az = false;
                    this.aA = "";
                    return this;
                }

                public DetailInfo clearTonightSaleFlag() {
                    this.aB = false;
                    this.aC = "";
                    return this;
                }

                public DetailInfo clearToplist() {
                    this.f11514h = false;
                    this.f11515i = null;
                    return this;
                }

                public DetailInfo clearTotalNum() {
                    this.aD = false;
                    this.aE = "";
                    return this;
                }

                public DetailInfo clearUpperleftcorner() {
                    this.bo = false;
                    this.bp = null;
                    return this;
                }

                public DetailInfo clearValidate() {
                    this.bm = false;
                    this.bn = "";
                    return this;
                }

                public DetailInfo clearWapBookable() {
                    this.aF = false;
                    this.aG = "";
                    return this;
                }

                public DetailInfo clearWiseFullroom() {
                    this.aH = false;
                    this.aI = "";
                    return this;
                }

                public DetailInfo clearWiseHotelType() {
                    this.aJ = false;
                    this.aK = "";
                    return this;
                }

                public DetailInfo clearWiseHotelTypeName() {
                    this.aL = false;
                    this.aM = "";
                    return this;
                }

                public DetailInfo clearWiseLowPrice() {
                    this.aN = false;
                    this.aO = "";
                    return this;
                }

                public DetailInfo clearWisePrice() {
                    this.aP = false;
                    this.aQ = "";
                    return this;
                }

                public DetailInfo clearWiseRealtimePrice() {
                    this.aR = false;
                    this.aS = "";
                    return this;
                }

                public DetailInfo clearWiseRealtimePriceFlag() {
                    this.aT = false;
                    this.aU = "";
                    return this;
                }

                public Allcardextension getAllcardextension() {
                    return this.bt;
                }

                public int getAreaid() {
                    return this.f11517k;
                }

                public String getBid() {
                    return this.f11519m;
                }

                public BookInfo getBookInfo() {
                    return this.bj;
                }

                public int getCachedSize() {
                    if (this.bu < 0) {
                        getSerializedSize();
                    }
                    return this.bu;
                }

                public String getCheckinNum() {
                    return this.f11521o;
                }

                public String getCollectNum() {
                    return this.f11523q;
                }

                public String getCommentNum() {
                    return this.f11525s;
                }

                public String getFacilityRating() {
                    return this.f11527u;
                }

                public String getFlag(int i) {
                    return (String) this.aV.get(i);
                }

                public int getFlagCount() {
                    return this.aV.size();
                }

                public List<String> getFlagList() {
                    return this.aV;
                }

                public String getFromPds() {
                    return this.f11529w;
                }

                public Groupon getGroupon(int i) {
                    return (Groupon) this.f11507a.get(i);
                }

                public int getGrouponCount() {
                    return this.f11507a.size();
                }

                public int getGrouponFlag() {
                    return this.aX;
                }

                public List<Groupon> getGrouponList() {
                    return this.f11507a;
                }

                public int getGrouponNum() {
                    return this.f11531y;
                }

                public int getGrouponTotal() {
                    return this.aZ;
                }

                public String getGuide() {
                    return this.bf;
                }

                public HotelOriInfo getHotelOriInfo(int i) {
                    return (HotelOriInfo) this.f11508b.get(i);
                }

                public int getHotelOriInfoCount() {
                    return this.f11508b.size();
                }

                public List<HotelOriInfo> getHotelOriInfoList() {
                    return this.f11508b;
                }

                public String getHygieneRating() {
                    return this.f11481A;
                }

                public String getImage() {
                    return this.f11483C;
                }

                public String getImageFrom() {
                    return this.f11485E;
                }

                public String getImageNum() {
                    return this.f11487G;
                }

                public int getIsGwj() {
                    return this.bb;
                }

                public String getLatestNum() {
                    return this.f11489I;
                }

                public LbcBusinessVip getLbcBusinessVip() {
                    return this.bl;
                }

                public Link getLink(int i) {
                    return (Link) this.f11509c.get(i);
                }

                public int getLinkCount() {
                    return this.f11509c.size();
                }

                public List<Link> getLinkList() {
                    return this.f11509c;
                }

                public Mbc getMbc() {
                    return this.br;
                }

                public Meishipaihao getMeishipaihao() {
                    return this.bh;
                }

                public String getMiningLowPriceFlag() {
                    return this.f11491K;
                }

                public String getName() {
                    return this.f11493M;
                }

                public String getNewCatalogId() {
                    return this.f11495O;
                }

                public String getOriginPrice() {
                    return this.f11497Q;
                }

                public OtaInfo getOtaInfo(int i) {
                    return (OtaInfo) this.f11510d.get(i);
                }

                public int getOtaInfoCount() {
                    return this.f11510d.size();
                }

                public List<OtaInfo> getOtaInfoList() {
                    return this.f11510d;
                }

                public OtaUrl getOtaUrl(int i) {
                    return (OtaUrl) this.f11511e.get(i);
                }

                public int getOtaUrlCount() {
                    return this.f11511e.size();
                }

                public List<OtaUrl> getOtaUrlList() {
                    return this.f11511e;
                }

                public String getOverallRating() {
                    return this.f11499S;
                }

                public String getPcBookable() {
                    return this.f11501U;
                }

                public String getPcRealtimePrice() {
                    return this.f11503W;
                }

                public String getPhone() {
                    return this.f11505Y;
                }

                public String getPoiAddress() {
                    return this.aa;
                }

                public Point getPoint() {
                    return this.f11513g;
                }

                public int getPremiumFlag() {
                    return this.ac;
                }

                public String getPrice() {
                    return this.ae;
                }

                public String getPriceText() {
                    return this.bd;
                }

                public String getRecReason() {
                    return this.ag;
                }

                public String getRecommandIndex() {
                    return this.ai;
                }

                public int getReviewFlag() {
                    return this.ak;
                }

                public int getSTime() {
                    return this.as;
                }

                public int getSerializedSize() {
                    int i = 0;
                    int computeInt32Size = hasAreaid() ? CodedOutputStreamMicro.computeInt32Size(1, getAreaid()) + 0 : 0;
                    if (hasBid()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getBid());
                    }
                    if (hasCheckinNum()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getCheckinNum());
                    }
                    if (hasCollectNum()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getCollectNum());
                    }
                    if (hasCommentNum()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(5, getCommentNum());
                    }
                    if (hasFacilityRating()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(6, getFacilityRating());
                    }
                    if (hasFromPds()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(7, getFromPds());
                    }
                    int i2 = computeInt32Size;
                    for (Groupon computeMessageSize : getGrouponList()) {
                        i2 = CodedOutputStreamMicro.computeMessageSize(8, computeMessageSize) + i2;
                    }
                    if (hasGrouponNum()) {
                        i2 += CodedOutputStreamMicro.computeInt32Size(9, getGrouponNum());
                    }
                    for (HotelOriInfo computeMessageSize2 : getHotelOriInfoList()) {
                        i2 += CodedOutputStreamMicro.computeMessageSize(10, computeMessageSize2);
                    }
                    if (hasHygieneRating()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(11, getHygieneRating());
                    }
                    if (hasImage()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(12, getImage());
                    }
                    if (hasImageFrom()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(13, getImageFrom());
                    }
                    if (hasImageNum()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(14, getImageNum());
                    }
                    if (hasLatestNum()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(15, getLatestNum());
                    }
                    for (Link computeMessageSize3 : getLinkList()) {
                        i2 += CodedOutputStreamMicro.computeMessageSize(16, computeMessageSize3);
                    }
                    if (hasMiningLowPriceFlag()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(17, getMiningLowPriceFlag());
                    }
                    if (hasName()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(18, getName());
                    }
                    if (hasNewCatalogId()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(19, getNewCatalogId());
                    }
                    if (hasOriginPrice()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(20, getOriginPrice());
                    }
                    for (OtaInfo computeMessageSize4 : getOtaInfoList()) {
                        i2 += CodedOutputStreamMicro.computeMessageSize(21, computeMessageSize4);
                    }
                    for (OtaUrl computeMessageSize5 : getOtaUrlList()) {
                        i2 += CodedOutputStreamMicro.computeMessageSize(22, computeMessageSize5);
                    }
                    if (hasOverallRating()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(23, getOverallRating());
                    }
                    if (hasPcBookable()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(24, getPcBookable());
                    }
                    if (hasPcRealtimePrice()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(25, getPcRealtimePrice());
                    }
                    if (hasPhone()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(26, getPhone());
                    }
                    if (hasPoint()) {
                        i2 += CodedOutputStreamMicro.computeMessageSize(27, getPoint());
                    }
                    if (hasPoiAddress()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(28, getPoiAddress());
                    }
                    if (hasPremiumFlag()) {
                        i2 += CodedOutputStreamMicro.computeInt32Size(29, getPremiumFlag());
                    }
                    if (hasPrice()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(30, getPrice());
                    }
                    if (hasRecReason()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(31, getRecReason());
                    }
                    if (hasRecommandIndex()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(32, getRecommandIndex());
                    }
                    if (hasReviewFlag()) {
                        i2 += CodedOutputStreamMicro.computeInt32Size(33, getReviewFlag());
                    }
                    if (hasServiceRating()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(34, getServiceRating());
                    }
                    if (hasShortComm()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(35, getShortComm());
                    }
                    if (hasSpecialService()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(36, getSpecialService());
                    }
                    if (hasSTime()) {
                        i2 += CodedOutputStreamMicro.computeInt32Size(37, getSTime());
                    }
                    if (hasStatus()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(38, getStatus());
                    }
                    if (hasStorageSrc()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(39, getStorageSrc());
                    }
                    if (hasTag()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(40, getTag());
                    }
                    if (hasTonightPrice()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(41, getTonightPrice());
                    }
                    if (hasTonightSaleFlag()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(42, getTonightSaleFlag());
                    }
                    if (hasTotalNum()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(43, getTotalNum());
                    }
                    if (hasToplist()) {
                        i2 += CodedOutputStreamMicro.computeMessageSize(44, getToplist());
                    }
                    if (hasWapBookable()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(45, getWapBookable());
                    }
                    if (hasWiseFullroom()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(46, getWiseFullroom());
                    }
                    if (hasWiseHotelType()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(47, getWiseHotelType());
                    }
                    if (hasWiseHotelTypeName()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(48, getWiseHotelTypeName());
                    }
                    if (hasWiseLowPrice()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(49, getWiseLowPrice());
                    }
                    if (hasWisePrice()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(50, getWisePrice());
                    }
                    if (hasWiseRealtimePrice()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(51, getWiseRealtimePrice());
                    }
                    if (hasWiseRealtimePriceFlag()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(52, getWiseRealtimePriceFlag());
                    }
                    for (String computeStringSizeNoTag : getFlagList()) {
                        i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag);
                    }
                    computeInt32Size = (i2 + i) + (getFlagList().size() * 2);
                    if (hasGrouponFlag()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(54, getGrouponFlag());
                    }
                    if (hasGrouponTotal()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(55, getGrouponTotal());
                    }
                    if (hasIsGwj()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(56, getIsGwj());
                    }
                    if (hasPriceText()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(57, getPriceText());
                    }
                    if (hasGuide()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(58, getGuide());
                    }
                    if (hasMeishipaihao()) {
                        computeInt32Size += CodedOutputStreamMicro.computeMessageSize(59, getMeishipaihao());
                    }
                    if (hasBookInfo()) {
                        computeInt32Size += CodedOutputStreamMicro.computeMessageSize(61, getBookInfo());
                    }
                    if (hasLbcBusinessVip()) {
                        computeInt32Size += CodedOutputStreamMicro.computeMessageSize(62, getLbcBusinessVip());
                    }
                    if (hasValidate()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(63, getValidate());
                    }
                    if (hasUpperleftcorner()) {
                        computeInt32Size += CodedOutputStreamMicro.computeMessageSize(64, getUpperleftcorner());
                    }
                    if (hasMbc()) {
                        computeInt32Size += CodedOutputStreamMicro.computeMessageSize(65, getMbc());
                    }
                    if (hasAllcardextension()) {
                        computeInt32Size += CodedOutputStreamMicro.computeMessageSize(66, getAllcardextension());
                    }
                    this.bu = computeInt32Size;
                    return computeInt32Size;
                }

                public String getServiceRating() {
                    return this.am;
                }

                public String getShortComm() {
                    return this.ao;
                }

                public String getSpecialService() {
                    return this.aq;
                }

                public String getStatus() {
                    return this.au;
                }

                public String getStorageSrc() {
                    return this.aw;
                }

                public String getTag() {
                    return this.ay;
                }

                public String getTonightPrice() {
                    return this.aA;
                }

                public String getTonightSaleFlag() {
                    return this.aC;
                }

                public Toplist getToplist() {
                    return this.f11515i;
                }

                public String getTotalNum() {
                    return this.aE;
                }

                public Upperleftcorner getUpperleftcorner() {
                    return this.bp;
                }

                public String getValidate() {
                    return this.bn;
                }

                public String getWapBookable() {
                    return this.aG;
                }

                public String getWiseFullroom() {
                    return this.aI;
                }

                public String getWiseHotelType() {
                    return this.aK;
                }

                public String getWiseHotelTypeName() {
                    return this.aM;
                }

                public String getWiseLowPrice() {
                    return this.aO;
                }

                public String getWisePrice() {
                    return this.aQ;
                }

                public String getWiseRealtimePrice() {
                    return this.aS;
                }

                public String getWiseRealtimePriceFlag() {
                    return this.aU;
                }

                public boolean hasAllcardextension() {
                    return this.bs;
                }

                public boolean hasAreaid() {
                    return this.f11516j;
                }

                public boolean hasBid() {
                    return this.f11518l;
                }

                public boolean hasBookInfo() {
                    return this.bi;
                }

                public boolean hasCheckinNum() {
                    return this.f11520n;
                }

                public boolean hasCollectNum() {
                    return this.f11522p;
                }

                public boolean hasCommentNum() {
                    return this.f11524r;
                }

                public boolean hasFacilityRating() {
                    return this.f11526t;
                }

                public boolean hasFromPds() {
                    return this.f11528v;
                }

                public boolean hasGrouponFlag() {
                    return this.aW;
                }

                public boolean hasGrouponNum() {
                    return this.f11530x;
                }

                public boolean hasGrouponTotal() {
                    return this.aY;
                }

                public boolean hasGuide() {
                    return this.be;
                }

                public boolean hasHygieneRating() {
                    return this.f11532z;
                }

                public boolean hasImage() {
                    return this.f11482B;
                }

                public boolean hasImageFrom() {
                    return this.f11484D;
                }

                public boolean hasImageNum() {
                    return this.f11486F;
                }

                public boolean hasIsGwj() {
                    return this.ba;
                }

                public boolean hasLatestNum() {
                    return this.f11488H;
                }

                public boolean hasLbcBusinessVip() {
                    return this.bk;
                }

                public boolean hasMbc() {
                    return this.bq;
                }

                public boolean hasMeishipaihao() {
                    return this.bg;
                }

                public boolean hasMiningLowPriceFlag() {
                    return this.f11490J;
                }

                public boolean hasName() {
                    return this.f11492L;
                }

                public boolean hasNewCatalogId() {
                    return this.f11494N;
                }

                public boolean hasOriginPrice() {
                    return this.f11496P;
                }

                public boolean hasOverallRating() {
                    return this.f11498R;
                }

                public boolean hasPcBookable() {
                    return this.f11500T;
                }

                public boolean hasPcRealtimePrice() {
                    return this.f11502V;
                }

                public boolean hasPhone() {
                    return this.f11504X;
                }

                public boolean hasPoiAddress() {
                    return this.f11506Z;
                }

                public boolean hasPoint() {
                    return this.f11512f;
                }

                public boolean hasPremiumFlag() {
                    return this.ab;
                }

                public boolean hasPrice() {
                    return this.ad;
                }

                public boolean hasPriceText() {
                    return this.bc;
                }

                public boolean hasRecReason() {
                    return this.af;
                }

                public boolean hasRecommandIndex() {
                    return this.ah;
                }

                public boolean hasReviewFlag() {
                    return this.aj;
                }

                public boolean hasSTime() {
                    return this.ar;
                }

                public boolean hasServiceRating() {
                    return this.al;
                }

                public boolean hasShortComm() {
                    return this.an;
                }

                public boolean hasSpecialService() {
                    return this.ap;
                }

                public boolean hasStatus() {
                    return this.at;
                }

                public boolean hasStorageSrc() {
                    return this.av;
                }

                public boolean hasTag() {
                    return this.ax;
                }

                public boolean hasTonightPrice() {
                    return this.az;
                }

                public boolean hasTonightSaleFlag() {
                    return this.aB;
                }

                public boolean hasToplist() {
                    return this.f11514h;
                }

                public boolean hasTotalNum() {
                    return this.aD;
                }

                public boolean hasUpperleftcorner() {
                    return this.bo;
                }

                public boolean hasValidate() {
                    return this.bm;
                }

                public boolean hasWapBookable() {
                    return this.aF;
                }

                public boolean hasWiseFullroom() {
                    return this.aH;
                }

                public boolean hasWiseHotelType() {
                    return this.aJ;
                }

                public boolean hasWiseHotelTypeName() {
                    return this.aL;
                }

                public boolean hasWiseLowPrice() {
                    return this.aN;
                }

                public boolean hasWisePrice() {
                    return this.aP;
                }

                public boolean hasWiseRealtimePrice() {
                    return this.aR;
                }

                public boolean hasWiseRealtimePriceFlag() {
                    return this.aT;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public DetailInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        MessageMicro groupon;
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                setAreaid(codedInputStreamMicro.readInt32());
                                continue;
                            case 18:
                                setBid(codedInputStreamMicro.readString());
                                continue;
                            case 26:
                                setCheckinNum(codedInputStreamMicro.readString());
                                continue;
                            case 34:
                                setCollectNum(codedInputStreamMicro.readString());
                                continue;
                            case 42:
                                setCommentNum(codedInputStreamMicro.readString());
                                continue;
                            case 50:
                                setFacilityRating(codedInputStreamMicro.readString());
                                continue;
                            case 58:
                                setFromPds(codedInputStreamMicro.readString());
                                continue;
                            case 66:
                                groupon = new Groupon();
                                codedInputStreamMicro.readMessage(groupon);
                                addGroupon(groupon);
                                continue;
                            case NavCarInfo.CarType_57L /*72*/:
                                setGrouponNum(codedInputStreamMicro.readInt32());
                                continue;
                            case 82:
                                groupon = new HotelOriInfo();
                                codedInputStreamMicro.readMessage(groupon);
                                addHotelOriInfo(groupon);
                                continue;
                            case 90:
                                setHygieneRating(codedInputStreamMicro.readString());
                                continue;
                            case 98:
                                setImage(codedInputStreamMicro.readString());
                                continue;
                            case 106:
                                setImageFrom(codedInputStreamMicro.readString());
                                continue;
                            case 114:
                                setImageNum(codedInputStreamMicro.readString());
                                continue;
                            case C1253f.df /*122*/:
                                setLatestNum(codedInputStreamMicro.readString());
                                continue;
                            case 130:
                                groupon = new Link();
                                codedInputStreamMicro.readMessage(groupon);
                                addLink(groupon);
                                continue;
                            case 138:
                                setMiningLowPriceFlag(codedInputStreamMicro.readString());
                                continue;
                            case 146:
                                setName(codedInputStreamMicro.readString());
                                continue;
                            case 154:
                                setNewCatalogId(codedInputStreamMicro.readString());
                                continue;
                            case 162:
                                setOriginPrice(codedInputStreamMicro.readString());
                                continue;
                            case 170:
                                groupon = new OtaInfo();
                                codedInputStreamMicro.readMessage(groupon);
                                addOtaInfo(groupon);
                                continue;
                            case 178:
                                groupon = new OtaUrl();
                                codedInputStreamMicro.readMessage(groupon);
                                addOtaUrl(groupon);
                                continue;
                            case 186:
                                setOverallRating(codedInputStreamMicro.readString());
                                continue;
                            case RouteLineResConst.LINE_INTERNAL_NORMAL /*194*/:
                                setPcBookable(codedInputStreamMicro.readString());
                                continue;
                            case 202:
                                setPcRealtimePrice(codedInputStreamMicro.readString());
                                continue;
                            case C1253f.ds /*210*/:
                                setPhone(codedInputStreamMicro.readString());
                                continue;
                            case 218:
                                groupon = new Point();
                                codedInputStreamMicro.readMessage(groupon);
                                setPoint(groupon);
                                continue;
                            case C1253f.dG /*226*/:
                                setPoiAddress(codedInputStreamMicro.readString());
                                continue;
                            case NaviCmdConstants.ACTION_TYPE_NAVI_MODE_DAY /*232*/:
                                setPremiumFlag(codedInputStreamMicro.readInt32());
                                continue;
                            case C1253f.dM /*242*/:
                                setPrice(codedInputStreamMicro.readString());
                                continue;
                            case 250:
                                setRecReason(codedInputStreamMicro.readString());
                                continue;
                            case 258:
                                setRecommandIndex(codedInputStreamMicro.readString());
                                continue;
                            case 264:
                                setReviewFlag(codedInputStreamMicro.readInt32());
                                continue;
                            case 274:
                                setServiceRating(codedInputStreamMicro.readString());
                                continue;
                            case 282:
                                setShortComm(codedInputStreamMicro.readString());
                                continue;
                            case 290:
                                setSpecialService(codedInputStreamMicro.readString());
                                continue;
                            case 296:
                                setSTime(codedInputStreamMicro.readInt32());
                                continue;
                            case 306:
                                setStatus(codedInputStreamMicro.readString());
                                continue;
                            case C1253f.eb /*314*/:
                                setStorageSrc(codedInputStreamMicro.readString());
                                continue;
                            case NaviFragmentManager.TYPE_VOICE_SQUARE /*322*/:
                                setTag(codedInputStreamMicro.readString());
                                continue;
                            case 330:
                                setTonightPrice(codedInputStreamMicro.readString());
                                continue;
                            case 338:
                                setTonightSaleFlag(codedInputStreamMicro.readString());
                                continue;
                            case 346:
                                setTotalNum(codedInputStreamMicro.readString());
                                continue;
                            case BusRouteProvider.START_NODE_STYLE /*354*/:
                                groupon = new Toplist();
                                codedInputStreamMicro.readMessage(groupon);
                                setToplist(groupon);
                                continue;
                            case 362:
                                setWapBookable(codedInputStreamMicro.readString());
                                continue;
                            case 370:
                                setWiseFullroom(codedInputStreamMicro.readString());
                                continue;
                            case 378:
                                setWiseHotelType(codedInputStreamMicro.readString());
                                continue;
                            case 386:
                                setWiseHotelTypeName(codedInputStreamMicro.readString());
                                continue;
                            case 394:
                                setWiseLowPrice(codedInputStreamMicro.readString());
                                continue;
                            case 402:
                                setWisePrice(codedInputStreamMicro.readString());
                                continue;
                            case 410:
                                setWiseRealtimePrice(codedInputStreamMicro.readString());
                                continue;
                            case NE_RoutePlan_Result.ROUTEPLAN_RESULT_FAIL_DEST5_DEVIATE /*418*/:
                                setWiseRealtimePriceFlag(codedInputStreamMicro.readString());
                                continue;
                            case C1253f.ew /*426*/:
                                addFlag(codedInputStreamMicro.readString());
                                continue;
                            case 432:
                                setGrouponFlag(codedInputStreamMicro.readInt32());
                                continue;
                            case 440:
                                setGrouponTotal(codedInputStreamMicro.readInt32());
                                continue;
                            case 448:
                                setIsGwj(codedInputStreamMicro.readInt32());
                                continue;
                            case 458:
                                setPriceText(codedInputStreamMicro.readString());
                                continue;
                            case 466:
                                setGuide(codedInputStreamMicro.readString());
                                continue;
                            case 474:
                                groupon = new Meishipaihao();
                                codedInputStreamMicro.readMessage(groupon);
                                setMeishipaihao(groupon);
                                continue;
                            case C2546c.f8411G /*490*/:
                                groupon = new BookInfo();
                                codedInputStreamMicro.readMessage(groupon);
                                setBookInfo(groupon);
                                continue;
                            case 498:
                                groupon = new LbcBusinessVip();
                                codedInputStreamMicro.readMessage(groupon);
                                setLbcBusinessVip(groupon);
                                continue;
                            case 506:
                                setValidate(codedInputStreamMicro.readString());
                                continue;
                            case 514:
                                groupon = new Upperleftcorner();
                                codedInputStreamMicro.readMessage(groupon);
                                setUpperleftcorner(groupon);
                                continue;
                            case 522:
                                groupon = new Mbc();
                                codedInputStreamMicro.readMessage(groupon);
                                setMbc(groupon);
                                continue;
                            case 530:
                                groupon = new Allcardextension();
                                codedInputStreamMicro.readMessage(groupon);
                                setAllcardextension(groupon);
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

                public DetailInfo setAllcardextension(Allcardextension allcardextension) {
                    if (allcardextension == null) {
                        return clearAllcardextension();
                    }
                    this.bs = true;
                    this.bt = allcardextension;
                    return this;
                }

                public DetailInfo setAreaid(int i) {
                    this.f11516j = true;
                    this.f11517k = i;
                    return this;
                }

                public DetailInfo setBid(String str) {
                    this.f11518l = true;
                    this.f11519m = str;
                    return this;
                }

                public DetailInfo setBookInfo(BookInfo bookInfo) {
                    if (bookInfo == null) {
                        return clearBookInfo();
                    }
                    this.bi = true;
                    this.bj = bookInfo;
                    return this;
                }

                public DetailInfo setCheckinNum(String str) {
                    this.f11520n = true;
                    this.f11521o = str;
                    return this;
                }

                public DetailInfo setCollectNum(String str) {
                    this.f11522p = true;
                    this.f11523q = str;
                    return this;
                }

                public DetailInfo setCommentNum(String str) {
                    this.f11524r = true;
                    this.f11525s = str;
                    return this;
                }

                public DetailInfo setFacilityRating(String str) {
                    this.f11526t = true;
                    this.f11527u = str;
                    return this;
                }

                public DetailInfo setFlag(int i, String str) {
                    if (str == null) {
                        throw new NullPointerException();
                    }
                    this.aV.set(i, str);
                    return this;
                }

                public DetailInfo setFromPds(String str) {
                    this.f11528v = true;
                    this.f11529w = str;
                    return this;
                }

                public DetailInfo setGroupon(int i, Groupon groupon) {
                    if (groupon != null) {
                        this.f11507a.set(i, groupon);
                    }
                    return this;
                }

                public DetailInfo setGrouponFlag(int i) {
                    this.aW = true;
                    this.aX = i;
                    return this;
                }

                public DetailInfo setGrouponNum(int i) {
                    this.f11530x = true;
                    this.f11531y = i;
                    return this;
                }

                public DetailInfo setGrouponTotal(int i) {
                    this.aY = true;
                    this.aZ = i;
                    return this;
                }

                public DetailInfo setGuide(String str) {
                    this.be = true;
                    this.bf = str;
                    return this;
                }

                public DetailInfo setHotelOriInfo(int i, HotelOriInfo hotelOriInfo) {
                    if (hotelOriInfo != null) {
                        this.f11508b.set(i, hotelOriInfo);
                    }
                    return this;
                }

                public DetailInfo setHygieneRating(String str) {
                    this.f11532z = true;
                    this.f11481A = str;
                    return this;
                }

                public DetailInfo setImage(String str) {
                    this.f11482B = true;
                    this.f11483C = str;
                    return this;
                }

                public DetailInfo setImageFrom(String str) {
                    this.f11484D = true;
                    this.f11485E = str;
                    return this;
                }

                public DetailInfo setImageNum(String str) {
                    this.f11486F = true;
                    this.f11487G = str;
                    return this;
                }

                public DetailInfo setIsGwj(int i) {
                    this.ba = true;
                    this.bb = i;
                    return this;
                }

                public DetailInfo setLatestNum(String str) {
                    this.f11488H = true;
                    this.f11489I = str;
                    return this;
                }

                public DetailInfo setLbcBusinessVip(LbcBusinessVip lbcBusinessVip) {
                    if (lbcBusinessVip == null) {
                        return clearLbcBusinessVip();
                    }
                    this.bk = true;
                    this.bl = lbcBusinessVip;
                    return this;
                }

                public DetailInfo setLink(int i, Link link) {
                    if (link != null) {
                        this.f11509c.set(i, link);
                    }
                    return this;
                }

                public DetailInfo setMbc(Mbc mbc) {
                    if (mbc == null) {
                        return clearMbc();
                    }
                    this.bq = true;
                    this.br = mbc;
                    return this;
                }

                public DetailInfo setMeishipaihao(Meishipaihao meishipaihao) {
                    if (meishipaihao == null) {
                        return clearMeishipaihao();
                    }
                    this.bg = true;
                    this.bh = meishipaihao;
                    return this;
                }

                public DetailInfo setMiningLowPriceFlag(String str) {
                    this.f11490J = true;
                    this.f11491K = str;
                    return this;
                }

                public DetailInfo setName(String str) {
                    this.f11492L = true;
                    this.f11493M = str;
                    return this;
                }

                public DetailInfo setNewCatalogId(String str) {
                    this.f11494N = true;
                    this.f11495O = str;
                    return this;
                }

                public DetailInfo setOriginPrice(String str) {
                    this.f11496P = true;
                    this.f11497Q = str;
                    return this;
                }

                public DetailInfo setOtaInfo(int i, OtaInfo otaInfo) {
                    if (otaInfo != null) {
                        this.f11510d.set(i, otaInfo);
                    }
                    return this;
                }

                public DetailInfo setOtaUrl(int i, OtaUrl otaUrl) {
                    if (otaUrl != null) {
                        this.f11511e.set(i, otaUrl);
                    }
                    return this;
                }

                public DetailInfo setOverallRating(String str) {
                    this.f11498R = true;
                    this.f11499S = str;
                    return this;
                }

                public DetailInfo setPcBookable(String str) {
                    this.f11500T = true;
                    this.f11501U = str;
                    return this;
                }

                public DetailInfo setPcRealtimePrice(String str) {
                    this.f11502V = true;
                    this.f11503W = str;
                    return this;
                }

                public DetailInfo setPhone(String str) {
                    this.f11504X = true;
                    this.f11505Y = str;
                    return this;
                }

                public DetailInfo setPoiAddress(String str) {
                    this.f11506Z = true;
                    this.aa = str;
                    return this;
                }

                public DetailInfo setPoint(Point point) {
                    if (point == null) {
                        return clearPoint();
                    }
                    this.f11512f = true;
                    this.f11513g = point;
                    return this;
                }

                public DetailInfo setPremiumFlag(int i) {
                    this.ab = true;
                    this.ac = i;
                    return this;
                }

                public DetailInfo setPrice(String str) {
                    this.ad = true;
                    this.ae = str;
                    return this;
                }

                public DetailInfo setPriceText(String str) {
                    this.bc = true;
                    this.bd = str;
                    return this;
                }

                public DetailInfo setRecReason(String str) {
                    this.af = true;
                    this.ag = str;
                    return this;
                }

                public DetailInfo setRecommandIndex(String str) {
                    this.ah = true;
                    this.ai = str;
                    return this;
                }

                public DetailInfo setReviewFlag(int i) {
                    this.aj = true;
                    this.ak = i;
                    return this;
                }

                public DetailInfo setSTime(int i) {
                    this.ar = true;
                    this.as = i;
                    return this;
                }

                public DetailInfo setServiceRating(String str) {
                    this.al = true;
                    this.am = str;
                    return this;
                }

                public DetailInfo setShortComm(String str) {
                    this.an = true;
                    this.ao = str;
                    return this;
                }

                public DetailInfo setSpecialService(String str) {
                    this.ap = true;
                    this.aq = str;
                    return this;
                }

                public DetailInfo setStatus(String str) {
                    this.at = true;
                    this.au = str;
                    return this;
                }

                public DetailInfo setStorageSrc(String str) {
                    this.av = true;
                    this.aw = str;
                    return this;
                }

                public DetailInfo setTag(String str) {
                    this.ax = true;
                    this.ay = str;
                    return this;
                }

                public DetailInfo setTonightPrice(String str) {
                    this.az = true;
                    this.aA = str;
                    return this;
                }

                public DetailInfo setTonightSaleFlag(String str) {
                    this.aB = true;
                    this.aC = str;
                    return this;
                }

                public DetailInfo setToplist(Toplist toplist) {
                    if (toplist == null) {
                        return clearToplist();
                    }
                    this.f11514h = true;
                    this.f11515i = toplist;
                    return this;
                }

                public DetailInfo setTotalNum(String str) {
                    this.aD = true;
                    this.aE = str;
                    return this;
                }

                public DetailInfo setUpperleftcorner(Upperleftcorner upperleftcorner) {
                    if (upperleftcorner == null) {
                        return clearUpperleftcorner();
                    }
                    this.bo = true;
                    this.bp = upperleftcorner;
                    return this;
                }

                public DetailInfo setValidate(String str) {
                    this.bm = true;
                    this.bn = str;
                    return this;
                }

                public DetailInfo setWapBookable(String str) {
                    this.aF = true;
                    this.aG = str;
                    return this;
                }

                public DetailInfo setWiseFullroom(String str) {
                    this.aH = true;
                    this.aI = str;
                    return this;
                }

                public DetailInfo setWiseHotelType(String str) {
                    this.aJ = true;
                    this.aK = str;
                    return this;
                }

                public DetailInfo setWiseHotelTypeName(String str) {
                    this.aL = true;
                    this.aM = str;
                    return this;
                }

                public DetailInfo setWiseLowPrice(String str) {
                    this.aN = true;
                    this.aO = str;
                    return this;
                }

                public DetailInfo setWisePrice(String str) {
                    this.aP = true;
                    this.aQ = str;
                    return this;
                }

                public DetailInfo setWiseRealtimePrice(String str) {
                    this.aR = true;
                    this.aS = str;
                    return this;
                }

                public DetailInfo setWiseRealtimePriceFlag(String str) {
                    this.aT = true;
                    this.aU = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasAreaid()) {
                        codedOutputStreamMicro.writeInt32(1, getAreaid());
                    }
                    if (hasBid()) {
                        codedOutputStreamMicro.writeString(2, getBid());
                    }
                    if (hasCheckinNum()) {
                        codedOutputStreamMicro.writeString(3, getCheckinNum());
                    }
                    if (hasCollectNum()) {
                        codedOutputStreamMicro.writeString(4, getCollectNum());
                    }
                    if (hasCommentNum()) {
                        codedOutputStreamMicro.writeString(5, getCommentNum());
                    }
                    if (hasFacilityRating()) {
                        codedOutputStreamMicro.writeString(6, getFacilityRating());
                    }
                    if (hasFromPds()) {
                        codedOutputStreamMicro.writeString(7, getFromPds());
                    }
                    for (Groupon writeMessage : getGrouponList()) {
                        codedOutputStreamMicro.writeMessage(8, writeMessage);
                    }
                    if (hasGrouponNum()) {
                        codedOutputStreamMicro.writeInt32(9, getGrouponNum());
                    }
                    for (HotelOriInfo writeMessage2 : getHotelOriInfoList()) {
                        codedOutputStreamMicro.writeMessage(10, writeMessage2);
                    }
                    if (hasHygieneRating()) {
                        codedOutputStreamMicro.writeString(11, getHygieneRating());
                    }
                    if (hasImage()) {
                        codedOutputStreamMicro.writeString(12, getImage());
                    }
                    if (hasImageFrom()) {
                        codedOutputStreamMicro.writeString(13, getImageFrom());
                    }
                    if (hasImageNum()) {
                        codedOutputStreamMicro.writeString(14, getImageNum());
                    }
                    if (hasLatestNum()) {
                        codedOutputStreamMicro.writeString(15, getLatestNum());
                    }
                    for (Link writeMessage3 : getLinkList()) {
                        codedOutputStreamMicro.writeMessage(16, writeMessage3);
                    }
                    if (hasMiningLowPriceFlag()) {
                        codedOutputStreamMicro.writeString(17, getMiningLowPriceFlag());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(18, getName());
                    }
                    if (hasNewCatalogId()) {
                        codedOutputStreamMicro.writeString(19, getNewCatalogId());
                    }
                    if (hasOriginPrice()) {
                        codedOutputStreamMicro.writeString(20, getOriginPrice());
                    }
                    for (OtaInfo writeMessage4 : getOtaInfoList()) {
                        codedOutputStreamMicro.writeMessage(21, writeMessage4);
                    }
                    for (OtaUrl writeMessage5 : getOtaUrlList()) {
                        codedOutputStreamMicro.writeMessage(22, writeMessage5);
                    }
                    if (hasOverallRating()) {
                        codedOutputStreamMicro.writeString(23, getOverallRating());
                    }
                    if (hasPcBookable()) {
                        codedOutputStreamMicro.writeString(24, getPcBookable());
                    }
                    if (hasPcRealtimePrice()) {
                        codedOutputStreamMicro.writeString(25, getPcRealtimePrice());
                    }
                    if (hasPhone()) {
                        codedOutputStreamMicro.writeString(26, getPhone());
                    }
                    if (hasPoint()) {
                        codedOutputStreamMicro.writeMessage(27, getPoint());
                    }
                    if (hasPoiAddress()) {
                        codedOutputStreamMicro.writeString(28, getPoiAddress());
                    }
                    if (hasPremiumFlag()) {
                        codedOutputStreamMicro.writeInt32(29, getPremiumFlag());
                    }
                    if (hasPrice()) {
                        codedOutputStreamMicro.writeString(30, getPrice());
                    }
                    if (hasRecReason()) {
                        codedOutputStreamMicro.writeString(31, getRecReason());
                    }
                    if (hasRecommandIndex()) {
                        codedOutputStreamMicro.writeString(32, getRecommandIndex());
                    }
                    if (hasReviewFlag()) {
                        codedOutputStreamMicro.writeInt32(33, getReviewFlag());
                    }
                    if (hasServiceRating()) {
                        codedOutputStreamMicro.writeString(34, getServiceRating());
                    }
                    if (hasShortComm()) {
                        codedOutputStreamMicro.writeString(35, getShortComm());
                    }
                    if (hasSpecialService()) {
                        codedOutputStreamMicro.writeString(36, getSpecialService());
                    }
                    if (hasSTime()) {
                        codedOutputStreamMicro.writeInt32(37, getSTime());
                    }
                    if (hasStatus()) {
                        codedOutputStreamMicro.writeString(38, getStatus());
                    }
                    if (hasStorageSrc()) {
                        codedOutputStreamMicro.writeString(39, getStorageSrc());
                    }
                    if (hasTag()) {
                        codedOutputStreamMicro.writeString(40, getTag());
                    }
                    if (hasTonightPrice()) {
                        codedOutputStreamMicro.writeString(41, getTonightPrice());
                    }
                    if (hasTonightSaleFlag()) {
                        codedOutputStreamMicro.writeString(42, getTonightSaleFlag());
                    }
                    if (hasTotalNum()) {
                        codedOutputStreamMicro.writeString(43, getTotalNum());
                    }
                    if (hasToplist()) {
                        codedOutputStreamMicro.writeMessage(44, getToplist());
                    }
                    if (hasWapBookable()) {
                        codedOutputStreamMicro.writeString(45, getWapBookable());
                    }
                    if (hasWiseFullroom()) {
                        codedOutputStreamMicro.writeString(46, getWiseFullroom());
                    }
                    if (hasWiseHotelType()) {
                        codedOutputStreamMicro.writeString(47, getWiseHotelType());
                    }
                    if (hasWiseHotelTypeName()) {
                        codedOutputStreamMicro.writeString(48, getWiseHotelTypeName());
                    }
                    if (hasWiseLowPrice()) {
                        codedOutputStreamMicro.writeString(49, getWiseLowPrice());
                    }
                    if (hasWisePrice()) {
                        codedOutputStreamMicro.writeString(50, getWisePrice());
                    }
                    if (hasWiseRealtimePrice()) {
                        codedOutputStreamMicro.writeString(51, getWiseRealtimePrice());
                    }
                    if (hasWiseRealtimePriceFlag()) {
                        codedOutputStreamMicro.writeString(52, getWiseRealtimePriceFlag());
                    }
                    for (String writeString : getFlagList()) {
                        codedOutputStreamMicro.writeString(53, writeString);
                    }
                    if (hasGrouponFlag()) {
                        codedOutputStreamMicro.writeInt32(54, getGrouponFlag());
                    }
                    if (hasGrouponTotal()) {
                        codedOutputStreamMicro.writeInt32(55, getGrouponTotal());
                    }
                    if (hasIsGwj()) {
                        codedOutputStreamMicro.writeInt32(56, getIsGwj());
                    }
                    if (hasPriceText()) {
                        codedOutputStreamMicro.writeString(57, getPriceText());
                    }
                    if (hasGuide()) {
                        codedOutputStreamMicro.writeString(58, getGuide());
                    }
                    if (hasMeishipaihao()) {
                        codedOutputStreamMicro.writeMessage(59, getMeishipaihao());
                    }
                    if (hasBookInfo()) {
                        codedOutputStreamMicro.writeMessage(61, getBookInfo());
                    }
                    if (hasLbcBusinessVip()) {
                        codedOutputStreamMicro.writeMessage(62, getLbcBusinessVip());
                    }
                    if (hasValidate()) {
                        codedOutputStreamMicro.writeString(63, getValidate());
                    }
                    if (hasUpperleftcorner()) {
                        codedOutputStreamMicro.writeMessage(64, getUpperleftcorner());
                    }
                    if (hasMbc()) {
                        codedOutputStreamMicro.writeMessage(65, getMbc());
                    }
                    if (hasAllcardextension()) {
                        codedOutputStreamMicro.writeMessage(66, getAllcardextension());
                    }
                }
            }

            public static final class Image extends MessageMicro {
                public static final int RECOMMEND_FIELD_NUMBER = 1;
                public static final int TOP_FIELD_NUMBER = 2;
                /* renamed from: a */
                private List<Recommend> f11575a = Collections.emptyList();
                /* renamed from: b */
                private List<Top> f11576b = Collections.emptyList();
                /* renamed from: c */
                private int f11577c = -1;

                public static final class Recommend extends MessageMicro {
                    public static final int CN_NAME_FIELD_NUMBER = 1;
                    public static final int IMGURL_BAK_FIELD_NUMBER = 2;
                    public static final int IMGURL_FIELD_NUMBER = 3;
                    public static final int LINK_FIELD_NUMBER = 5;
                    public static final int LINK_MOBILEPHONE_FIELD_NUMBER = 4;
                    public static final int NAME_FIELD_NUMBER = 6;
                    public static final int PHOTOID_FIELD_NUMBER = 7;
                    public static final int PHOTO_NUM_FIELD_NUMBER = 8;
                    public static final int PHOTO_PAGEVIEW_FIELD_NUMBER = 9;
                    public static final int PRIORITY_FIELD_NUMBER = 10;
                    /* renamed from: a */
                    private boolean f11533a;
                    /* renamed from: b */
                    private String f11534b = "";
                    /* renamed from: c */
                    private boolean f11535c;
                    /* renamed from: d */
                    private String f11536d = "";
                    /* renamed from: e */
                    private boolean f11537e;
                    /* renamed from: f */
                    private String f11538f = "";
                    /* renamed from: g */
                    private boolean f11539g;
                    /* renamed from: h */
                    private String f11540h = "";
                    /* renamed from: i */
                    private boolean f11541i;
                    /* renamed from: j */
                    private String f11542j = "";
                    /* renamed from: k */
                    private boolean f11543k;
                    /* renamed from: l */
                    private String f11544l = "";
                    /* renamed from: m */
                    private boolean f11545m;
                    /* renamed from: n */
                    private int f11546n = 0;
                    /* renamed from: o */
                    private boolean f11547o;
                    /* renamed from: p */
                    private int f11548p = 0;
                    /* renamed from: q */
                    private boolean f11549q;
                    /* renamed from: r */
                    private int f11550r = 0;
                    /* renamed from: s */
                    private boolean f11551s;
                    /* renamed from: t */
                    private double f11552t = 0.0d;
                    /* renamed from: u */
                    private int f11553u = -1;

                    public static Recommend parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Recommend().mergeFrom(codedInputStreamMicro);
                    }

                    public static Recommend parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Recommend) new Recommend().mergeFrom(bArr);
                    }

                    public final Recommend clear() {
                        clearCnName();
                        clearImgUrlBak();
                        clearImgUrl();
                        clearLinkMobilephone();
                        clearLink();
                        clearName();
                        clearPhotoid();
                        clearPhotoNum();
                        clearPhotoPageview();
                        clearPriority();
                        this.f11553u = -1;
                        return this;
                    }

                    public Recommend clearCnName() {
                        this.f11533a = false;
                        this.f11534b = "";
                        return this;
                    }

                    public Recommend clearImgUrl() {
                        this.f11537e = false;
                        this.f11538f = "";
                        return this;
                    }

                    public Recommend clearImgUrlBak() {
                        this.f11535c = false;
                        this.f11536d = "";
                        return this;
                    }

                    public Recommend clearLink() {
                        this.f11541i = false;
                        this.f11542j = "";
                        return this;
                    }

                    public Recommend clearLinkMobilephone() {
                        this.f11539g = false;
                        this.f11540h = "";
                        return this;
                    }

                    public Recommend clearName() {
                        this.f11543k = false;
                        this.f11544l = "";
                        return this;
                    }

                    public Recommend clearPhotoNum() {
                        this.f11547o = false;
                        this.f11548p = 0;
                        return this;
                    }

                    public Recommend clearPhotoPageview() {
                        this.f11549q = false;
                        this.f11550r = 0;
                        return this;
                    }

                    public Recommend clearPhotoid() {
                        this.f11545m = false;
                        this.f11546n = 0;
                        return this;
                    }

                    public Recommend clearPriority() {
                        this.f11551s = false;
                        this.f11552t = 0.0d;
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f11553u < 0) {
                            getSerializedSize();
                        }
                        return this.f11553u;
                    }

                    public String getCnName() {
                        return this.f11534b;
                    }

                    public String getImgUrl() {
                        return this.f11538f;
                    }

                    public String getImgUrlBak() {
                        return this.f11536d;
                    }

                    public String getLink() {
                        return this.f11542j;
                    }

                    public String getLinkMobilephone() {
                        return this.f11540h;
                    }

                    public String getName() {
                        return this.f11544l;
                    }

                    public int getPhotoNum() {
                        return this.f11548p;
                    }

                    public int getPhotoPageview() {
                        return this.f11550r;
                    }

                    public int getPhotoid() {
                        return this.f11546n;
                    }

                    public double getPriority() {
                        return this.f11552t;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasCnName()) {
                            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCnName());
                        }
                        if (hasImgUrlBak()) {
                            i += CodedOutputStreamMicro.computeStringSize(2, getImgUrlBak());
                        }
                        if (hasImgUrl()) {
                            i += CodedOutputStreamMicro.computeStringSize(3, getImgUrl());
                        }
                        if (hasLinkMobilephone()) {
                            i += CodedOutputStreamMicro.computeStringSize(4, getLinkMobilephone());
                        }
                        if (hasLink()) {
                            i += CodedOutputStreamMicro.computeStringSize(5, getLink());
                        }
                        if (hasName()) {
                            i += CodedOutputStreamMicro.computeStringSize(6, getName());
                        }
                        if (hasPhotoid()) {
                            i += CodedOutputStreamMicro.computeInt32Size(7, getPhotoid());
                        }
                        if (hasPhotoNum()) {
                            i += CodedOutputStreamMicro.computeInt32Size(8, getPhotoNum());
                        }
                        if (hasPhotoPageview()) {
                            i += CodedOutputStreamMicro.computeInt32Size(9, getPhotoPageview());
                        }
                        if (hasPriority()) {
                            i += CodedOutputStreamMicro.computeDoubleSize(10, getPriority());
                        }
                        this.f11553u = i;
                        return i;
                    }

                    public boolean hasCnName() {
                        return this.f11533a;
                    }

                    public boolean hasImgUrl() {
                        return this.f11537e;
                    }

                    public boolean hasImgUrlBak() {
                        return this.f11535c;
                    }

                    public boolean hasLink() {
                        return this.f11541i;
                    }

                    public boolean hasLinkMobilephone() {
                        return this.f11539g;
                    }

                    public boolean hasName() {
                        return this.f11543k;
                    }

                    public boolean hasPhotoNum() {
                        return this.f11547o;
                    }

                    public boolean hasPhotoPageview() {
                        return this.f11549q;
                    }

                    public boolean hasPhotoid() {
                        return this.f11545m;
                    }

                    public boolean hasPriority() {
                        return this.f11551s;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Recommend mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    setCnName(codedInputStreamMicro.readString());
                                    continue;
                                case 18:
                                    setImgUrlBak(codedInputStreamMicro.readString());
                                    continue;
                                case 26:
                                    setImgUrl(codedInputStreamMicro.readString());
                                    continue;
                                case 34:
                                    setLinkMobilephone(codedInputStreamMicro.readString());
                                    continue;
                                case 42:
                                    setLink(codedInputStreamMicro.readString());
                                    continue;
                                case 50:
                                    setName(codedInputStreamMicro.readString());
                                    continue;
                                case 56:
                                    setPhotoid(codedInputStreamMicro.readInt32());
                                    continue;
                                case 64:
                                    setPhotoNum(codedInputStreamMicro.readInt32());
                                    continue;
                                case NavCarInfo.CarType_57L /*72*/:
                                    setPhotoPageview(codedInputStreamMicro.readInt32());
                                    continue;
                                case 81:
                                    setPriority(codedInputStreamMicro.readDouble());
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

                    public Recommend setCnName(String str) {
                        this.f11533a = true;
                        this.f11534b = str;
                        return this;
                    }

                    public Recommend setImgUrl(String str) {
                        this.f11537e = true;
                        this.f11538f = str;
                        return this;
                    }

                    public Recommend setImgUrlBak(String str) {
                        this.f11535c = true;
                        this.f11536d = str;
                        return this;
                    }

                    public Recommend setLink(String str) {
                        this.f11541i = true;
                        this.f11542j = str;
                        return this;
                    }

                    public Recommend setLinkMobilephone(String str) {
                        this.f11539g = true;
                        this.f11540h = str;
                        return this;
                    }

                    public Recommend setName(String str) {
                        this.f11543k = true;
                        this.f11544l = str;
                        return this;
                    }

                    public Recommend setPhotoNum(int i) {
                        this.f11547o = true;
                        this.f11548p = i;
                        return this;
                    }

                    public Recommend setPhotoPageview(int i) {
                        this.f11549q = true;
                        this.f11550r = i;
                        return this;
                    }

                    public Recommend setPhotoid(int i) {
                        this.f11545m = true;
                        this.f11546n = i;
                        return this;
                    }

                    public Recommend setPriority(double d) {
                        this.f11551s = true;
                        this.f11552t = d;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasCnName()) {
                            codedOutputStreamMicro.writeString(1, getCnName());
                        }
                        if (hasImgUrlBak()) {
                            codedOutputStreamMicro.writeString(2, getImgUrlBak());
                        }
                        if (hasImgUrl()) {
                            codedOutputStreamMicro.writeString(3, getImgUrl());
                        }
                        if (hasLinkMobilephone()) {
                            codedOutputStreamMicro.writeString(4, getLinkMobilephone());
                        }
                        if (hasLink()) {
                            codedOutputStreamMicro.writeString(5, getLink());
                        }
                        if (hasName()) {
                            codedOutputStreamMicro.writeString(6, getName());
                        }
                        if (hasPhotoid()) {
                            codedOutputStreamMicro.writeInt32(7, getPhotoid());
                        }
                        if (hasPhotoNum()) {
                            codedOutputStreamMicro.writeInt32(8, getPhotoNum());
                        }
                        if (hasPhotoPageview()) {
                            codedOutputStreamMicro.writeInt32(9, getPhotoPageview());
                        }
                        if (hasPriority()) {
                            codedOutputStreamMicro.writeDouble(10, getPriority());
                        }
                    }
                }

                public static final class Top extends MessageMicro {
                    public static final int CN_NAME_FIELD_NUMBER = 1;
                    public static final int IMGURL_BAK_FIELD_NUMBER = 2;
                    public static final int IMGURL_FIELD_NUMBER = 3;
                    public static final int LINK_FIELD_NUMBER = 5;
                    public static final int LINK_MOBILEPHONE_FIELD_NUMBER = 4;
                    public static final int NAME_FIELD_NUMBER = 6;
                    public static final int PHOTOID_FIELD_NUMBER = 7;
                    public static final int PHOTO_NUM_FIELD_NUMBER = 8;
                    public static final int PHOTO_PAGEVIEW_FIELD_NUMBER = 9;
                    public static final int PRIORITY_FIELD_NUMBER = 10;
                    /* renamed from: a */
                    private boolean f11554a;
                    /* renamed from: b */
                    private String f11555b = "";
                    /* renamed from: c */
                    private boolean f11556c;
                    /* renamed from: d */
                    private String f11557d = "";
                    /* renamed from: e */
                    private boolean f11558e;
                    /* renamed from: f */
                    private String f11559f = "";
                    /* renamed from: g */
                    private boolean f11560g;
                    /* renamed from: h */
                    private String f11561h = "";
                    /* renamed from: i */
                    private boolean f11562i;
                    /* renamed from: j */
                    private String f11563j = "";
                    /* renamed from: k */
                    private boolean f11564k;
                    /* renamed from: l */
                    private String f11565l = "";
                    /* renamed from: m */
                    private boolean f11566m;
                    /* renamed from: n */
                    private int f11567n = 0;
                    /* renamed from: o */
                    private boolean f11568o;
                    /* renamed from: p */
                    private int f11569p = 0;
                    /* renamed from: q */
                    private boolean f11570q;
                    /* renamed from: r */
                    private int f11571r = 0;
                    /* renamed from: s */
                    private boolean f11572s;
                    /* renamed from: t */
                    private double f11573t = 0.0d;
                    /* renamed from: u */
                    private int f11574u = -1;

                    public static Top parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Top().mergeFrom(codedInputStreamMicro);
                    }

                    public static Top parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Top) new Top().mergeFrom(bArr);
                    }

                    public final Top clear() {
                        clearCnName();
                        clearImgUrlBak();
                        clearImgUrl();
                        clearLinkMobilephone();
                        clearLink();
                        clearName();
                        clearPhotoid();
                        clearPhotoNum();
                        clearPhotoPageview();
                        clearPriority();
                        this.f11574u = -1;
                        return this;
                    }

                    public Top clearCnName() {
                        this.f11554a = false;
                        this.f11555b = "";
                        return this;
                    }

                    public Top clearImgUrl() {
                        this.f11558e = false;
                        this.f11559f = "";
                        return this;
                    }

                    public Top clearImgUrlBak() {
                        this.f11556c = false;
                        this.f11557d = "";
                        return this;
                    }

                    public Top clearLink() {
                        this.f11562i = false;
                        this.f11563j = "";
                        return this;
                    }

                    public Top clearLinkMobilephone() {
                        this.f11560g = false;
                        this.f11561h = "";
                        return this;
                    }

                    public Top clearName() {
                        this.f11564k = false;
                        this.f11565l = "";
                        return this;
                    }

                    public Top clearPhotoNum() {
                        this.f11568o = false;
                        this.f11569p = 0;
                        return this;
                    }

                    public Top clearPhotoPageview() {
                        this.f11570q = false;
                        this.f11571r = 0;
                        return this;
                    }

                    public Top clearPhotoid() {
                        this.f11566m = false;
                        this.f11567n = 0;
                        return this;
                    }

                    public Top clearPriority() {
                        this.f11572s = false;
                        this.f11573t = 0.0d;
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f11574u < 0) {
                            getSerializedSize();
                        }
                        return this.f11574u;
                    }

                    public String getCnName() {
                        return this.f11555b;
                    }

                    public String getImgUrl() {
                        return this.f11559f;
                    }

                    public String getImgUrlBak() {
                        return this.f11557d;
                    }

                    public String getLink() {
                        return this.f11563j;
                    }

                    public String getLinkMobilephone() {
                        return this.f11561h;
                    }

                    public String getName() {
                        return this.f11565l;
                    }

                    public int getPhotoNum() {
                        return this.f11569p;
                    }

                    public int getPhotoPageview() {
                        return this.f11571r;
                    }

                    public int getPhotoid() {
                        return this.f11567n;
                    }

                    public double getPriority() {
                        return this.f11573t;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasCnName()) {
                            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCnName());
                        }
                        if (hasImgUrlBak()) {
                            i += CodedOutputStreamMicro.computeStringSize(2, getImgUrlBak());
                        }
                        if (hasImgUrl()) {
                            i += CodedOutputStreamMicro.computeStringSize(3, getImgUrl());
                        }
                        if (hasLinkMobilephone()) {
                            i += CodedOutputStreamMicro.computeStringSize(4, getLinkMobilephone());
                        }
                        if (hasLink()) {
                            i += CodedOutputStreamMicro.computeStringSize(5, getLink());
                        }
                        if (hasName()) {
                            i += CodedOutputStreamMicro.computeStringSize(6, getName());
                        }
                        if (hasPhotoid()) {
                            i += CodedOutputStreamMicro.computeInt32Size(7, getPhotoid());
                        }
                        if (hasPhotoNum()) {
                            i += CodedOutputStreamMicro.computeInt32Size(8, getPhotoNum());
                        }
                        if (hasPhotoPageview()) {
                            i += CodedOutputStreamMicro.computeInt32Size(9, getPhotoPageview());
                        }
                        if (hasPriority()) {
                            i += CodedOutputStreamMicro.computeDoubleSize(10, getPriority());
                        }
                        this.f11574u = i;
                        return i;
                    }

                    public boolean hasCnName() {
                        return this.f11554a;
                    }

                    public boolean hasImgUrl() {
                        return this.f11558e;
                    }

                    public boolean hasImgUrlBak() {
                        return this.f11556c;
                    }

                    public boolean hasLink() {
                        return this.f11562i;
                    }

                    public boolean hasLinkMobilephone() {
                        return this.f11560g;
                    }

                    public boolean hasName() {
                        return this.f11564k;
                    }

                    public boolean hasPhotoNum() {
                        return this.f11568o;
                    }

                    public boolean hasPhotoPageview() {
                        return this.f11570q;
                    }

                    public boolean hasPhotoid() {
                        return this.f11566m;
                    }

                    public boolean hasPriority() {
                        return this.f11572s;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Top mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    setCnName(codedInputStreamMicro.readString());
                                    continue;
                                case 18:
                                    setImgUrlBak(codedInputStreamMicro.readString());
                                    continue;
                                case 26:
                                    setImgUrl(codedInputStreamMicro.readString());
                                    continue;
                                case 34:
                                    setLinkMobilephone(codedInputStreamMicro.readString());
                                    continue;
                                case 42:
                                    setLink(codedInputStreamMicro.readString());
                                    continue;
                                case 50:
                                    setName(codedInputStreamMicro.readString());
                                    continue;
                                case 56:
                                    setPhotoid(codedInputStreamMicro.readInt32());
                                    continue;
                                case 64:
                                    setPhotoNum(codedInputStreamMicro.readInt32());
                                    continue;
                                case NavCarInfo.CarType_57L /*72*/:
                                    setPhotoPageview(codedInputStreamMicro.readInt32());
                                    continue;
                                case 81:
                                    setPriority(codedInputStreamMicro.readDouble());
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

                    public Top setCnName(String str) {
                        this.f11554a = true;
                        this.f11555b = str;
                        return this;
                    }

                    public Top setImgUrl(String str) {
                        this.f11558e = true;
                        this.f11559f = str;
                        return this;
                    }

                    public Top setImgUrlBak(String str) {
                        this.f11556c = true;
                        this.f11557d = str;
                        return this;
                    }

                    public Top setLink(String str) {
                        this.f11562i = true;
                        this.f11563j = str;
                        return this;
                    }

                    public Top setLinkMobilephone(String str) {
                        this.f11560g = true;
                        this.f11561h = str;
                        return this;
                    }

                    public Top setName(String str) {
                        this.f11564k = true;
                        this.f11565l = str;
                        return this;
                    }

                    public Top setPhotoNum(int i) {
                        this.f11568o = true;
                        this.f11569p = i;
                        return this;
                    }

                    public Top setPhotoPageview(int i) {
                        this.f11570q = true;
                        this.f11571r = i;
                        return this;
                    }

                    public Top setPhotoid(int i) {
                        this.f11566m = true;
                        this.f11567n = i;
                        return this;
                    }

                    public Top setPriority(double d) {
                        this.f11572s = true;
                        this.f11573t = d;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasCnName()) {
                            codedOutputStreamMicro.writeString(1, getCnName());
                        }
                        if (hasImgUrlBak()) {
                            codedOutputStreamMicro.writeString(2, getImgUrlBak());
                        }
                        if (hasImgUrl()) {
                            codedOutputStreamMicro.writeString(3, getImgUrl());
                        }
                        if (hasLinkMobilephone()) {
                            codedOutputStreamMicro.writeString(4, getLinkMobilephone());
                        }
                        if (hasLink()) {
                            codedOutputStreamMicro.writeString(5, getLink());
                        }
                        if (hasName()) {
                            codedOutputStreamMicro.writeString(6, getName());
                        }
                        if (hasPhotoid()) {
                            codedOutputStreamMicro.writeInt32(7, getPhotoid());
                        }
                        if (hasPhotoNum()) {
                            codedOutputStreamMicro.writeInt32(8, getPhotoNum());
                        }
                        if (hasPhotoPageview()) {
                            codedOutputStreamMicro.writeInt32(9, getPhotoPageview());
                        }
                        if (hasPriority()) {
                            codedOutputStreamMicro.writeDouble(10, getPriority());
                        }
                    }
                }

                public static Image parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Image().mergeFrom(codedInputStreamMicro);
                }

                public static Image parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Image) new Image().mergeFrom(bArr);
                }

                public Image addRecommend(Recommend recommend) {
                    if (recommend != null) {
                        if (this.f11575a.isEmpty()) {
                            this.f11575a = new ArrayList();
                        }
                        this.f11575a.add(recommend);
                    }
                    return this;
                }

                public Image addTop(Top top) {
                    if (top != null) {
                        if (this.f11576b.isEmpty()) {
                            this.f11576b = new ArrayList();
                        }
                        this.f11576b.add(top);
                    }
                    return this;
                }

                public final Image clear() {
                    clearRecommend();
                    clearTop();
                    this.f11577c = -1;
                    return this;
                }

                public Image clearRecommend() {
                    this.f11575a = Collections.emptyList();
                    return this;
                }

                public Image clearTop() {
                    this.f11576b = Collections.emptyList();
                    return this;
                }

                public int getCachedSize() {
                    if (this.f11577c < 0) {
                        getSerializedSize();
                    }
                    return this.f11577c;
                }

                public Recommend getRecommend(int i) {
                    return (Recommend) this.f11575a.get(i);
                }

                public int getRecommendCount() {
                    return this.f11575a.size();
                }

                public List<Recommend> getRecommendList() {
                    return this.f11575a;
                }

                public int getSerializedSize() {
                    int i = 0;
                    for (Recommend computeMessageSize : getRecommendList()) {
                        i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
                    }
                    for (Top computeMessageSize2 : getTopList()) {
                        i += CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize2);
                    }
                    this.f11577c = i;
                    return i;
                }

                public Top getTop(int i) {
                    return (Top) this.f11576b.get(i);
                }

                public int getTopCount() {
                    return this.f11576b.size();
                }

                public List<Top> getTopList() {
                    return this.f11576b;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Image mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        MessageMicro recommend;
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                recommend = new Recommend();
                                codedInputStreamMicro.readMessage(recommend);
                                addRecommend(recommend);
                                continue;
                            case 18:
                                recommend = new Top();
                                codedInputStreamMicro.readMessage(recommend);
                                addTop(recommend);
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

                public Image setRecommend(int i, Recommend recommend) {
                    if (recommend != null) {
                        this.f11575a.set(i, recommend);
                    }
                    return this;
                }

                public Image setTop(int i, Top top) {
                    if (top != null) {
                        this.f11576b.set(i, top);
                    }
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    for (Recommend writeMessage : getRecommendList()) {
                        codedOutputStreamMicro.writeMessage(1, writeMessage);
                    }
                    for (Top writeMessage2 : getTopList()) {
                        codedOutputStreamMicro.writeMessage(2, writeMessage2);
                    }
                }
            }

            public static final class LineInfo extends MessageMicro {
                public static final int ABB_FIELD_NUMBER = 1;
                public static final int CLR_FIELD_NUMBER = 2;
                public static final int FIRST_TIME_FIELD_NUMBER = 3;
                public static final int LAST_TIME_FIELD_NUMBER = 4;
                public static final int LINE_TIME_FIELD_NUMBER = 5;
                public static final int TERMINALS_FIELD_NUMBER = 6;
                public static final int UID_FIELD_NUMBER = 7;
                /* renamed from: a */
                private boolean f11578a;
                /* renamed from: b */
                private String f11579b = "";
                /* renamed from: c */
                private boolean f11580c;
                /* renamed from: d */
                private String f11581d = "";
                /* renamed from: e */
                private boolean f11582e;
                /* renamed from: f */
                private String f11583f = "";
                /* renamed from: g */
                private boolean f11584g;
                /* renamed from: h */
                private String f11585h = "";
                /* renamed from: i */
                private boolean f11586i;
                /* renamed from: j */
                private String f11587j = "";
                /* renamed from: k */
                private boolean f11588k;
                /* renamed from: l */
                private String f11589l = "";
                /* renamed from: m */
                private boolean f11590m;
                /* renamed from: n */
                private String f11591n = "";
                /* renamed from: o */
                private int f11592o = -1;

                public static LineInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new LineInfo().mergeFrom(codedInputStreamMicro);
                }

                public static LineInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (LineInfo) new LineInfo().mergeFrom(bArr);
                }

                public final LineInfo clear() {
                    clearAbb();
                    clearClr();
                    clearFirstTime();
                    clearLastTime();
                    clearLineTime();
                    clearTerminals();
                    clearUid();
                    this.f11592o = -1;
                    return this;
                }

                public LineInfo clearAbb() {
                    this.f11578a = false;
                    this.f11579b = "";
                    return this;
                }

                public LineInfo clearClr() {
                    this.f11580c = false;
                    this.f11581d = "";
                    return this;
                }

                public LineInfo clearFirstTime() {
                    this.f11582e = false;
                    this.f11583f = "";
                    return this;
                }

                public LineInfo clearLastTime() {
                    this.f11584g = false;
                    this.f11585h = "";
                    return this;
                }

                public LineInfo clearLineTime() {
                    this.f11586i = false;
                    this.f11587j = "";
                    return this;
                }

                public LineInfo clearTerminals() {
                    this.f11588k = false;
                    this.f11589l = "";
                    return this;
                }

                public LineInfo clearUid() {
                    this.f11590m = false;
                    this.f11591n = "";
                    return this;
                }

                public String getAbb() {
                    return this.f11579b;
                }

                public int getCachedSize() {
                    if (this.f11592o < 0) {
                        getSerializedSize();
                    }
                    return this.f11592o;
                }

                public String getClr() {
                    return this.f11581d;
                }

                public String getFirstTime() {
                    return this.f11583f;
                }

                public String getLastTime() {
                    return this.f11585h;
                }

                public String getLineTime() {
                    return this.f11587j;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasAbb()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getAbb());
                    }
                    if (hasClr()) {
                        i += CodedOutputStreamMicro.computeStringSize(2, getClr());
                    }
                    if (hasFirstTime()) {
                        i += CodedOutputStreamMicro.computeStringSize(3, getFirstTime());
                    }
                    if (hasLastTime()) {
                        i += CodedOutputStreamMicro.computeStringSize(4, getLastTime());
                    }
                    if (hasLineTime()) {
                        i += CodedOutputStreamMicro.computeStringSize(5, getLineTime());
                    }
                    if (hasTerminals()) {
                        i += CodedOutputStreamMicro.computeStringSize(6, getTerminals());
                    }
                    if (hasUid()) {
                        i += CodedOutputStreamMicro.computeStringSize(7, getUid());
                    }
                    this.f11592o = i;
                    return i;
                }

                public String getTerminals() {
                    return this.f11589l;
                }

                public String getUid() {
                    return this.f11591n;
                }

                public boolean hasAbb() {
                    return this.f11578a;
                }

                public boolean hasClr() {
                    return this.f11580c;
                }

                public boolean hasFirstTime() {
                    return this.f11582e;
                }

                public boolean hasLastTime() {
                    return this.f11584g;
                }

                public boolean hasLineTime() {
                    return this.f11586i;
                }

                public boolean hasTerminals() {
                    return this.f11588k;
                }

                public boolean hasUid() {
                    return this.f11590m;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public LineInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                setAbb(codedInputStreamMicro.readString());
                                continue;
                            case 18:
                                setClr(codedInputStreamMicro.readString());
                                continue;
                            case 26:
                                setFirstTime(codedInputStreamMicro.readString());
                                continue;
                            case 34:
                                setLastTime(codedInputStreamMicro.readString());
                                continue;
                            case 42:
                                setLineTime(codedInputStreamMicro.readString());
                                continue;
                            case 50:
                                setTerminals(codedInputStreamMicro.readString());
                                continue;
                            case 58:
                                setUid(codedInputStreamMicro.readString());
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

                public LineInfo setAbb(String str) {
                    this.f11578a = true;
                    this.f11579b = str;
                    return this;
                }

                public LineInfo setClr(String str) {
                    this.f11580c = true;
                    this.f11581d = str;
                    return this;
                }

                public LineInfo setFirstTime(String str) {
                    this.f11582e = true;
                    this.f11583f = str;
                    return this;
                }

                public LineInfo setLastTime(String str) {
                    this.f11584g = true;
                    this.f11585h = str;
                    return this;
                }

                public LineInfo setLineTime(String str) {
                    this.f11586i = true;
                    this.f11587j = str;
                    return this;
                }

                public LineInfo setTerminals(String str) {
                    this.f11588k = true;
                    this.f11589l = str;
                    return this;
                }

                public LineInfo setUid(String str) {
                    this.f11590m = true;
                    this.f11591n = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasAbb()) {
                        codedOutputStreamMicro.writeString(1, getAbb());
                    }
                    if (hasClr()) {
                        codedOutputStreamMicro.writeString(2, getClr());
                    }
                    if (hasFirstTime()) {
                        codedOutputStreamMicro.writeString(3, getFirstTime());
                    }
                    if (hasLastTime()) {
                        codedOutputStreamMicro.writeString(4, getLastTime());
                    }
                    if (hasLineTime()) {
                        codedOutputStreamMicro.writeString(5, getLineTime());
                    }
                    if (hasTerminals()) {
                        codedOutputStreamMicro.writeString(6, getTerminals());
                    }
                    if (hasUid()) {
                        codedOutputStreamMicro.writeString(7, getUid());
                    }
                }
            }

            public static final class Review extends MessageMicro {
                public static final int CN_NAME_FIELD_NUMBER = 1;
                public static final int CONTENT_FIELD_NUMBER = 8;
                public static final int DATE_FIELD_NUMBER = 9;
                public static final int ENVIRONMENT_RATING_FIELD_NUMBER = 10;
                public static final int FROM_FIELD_NUMBER = 2;
                public static final int INFO_FIELD_NUMBER = 3;
                public static final int NAME_FIELD_NUMBER = 4;
                public static final int ONE_URL_FIELD_NUMBER = 12;
                public static final int ONE_URL_MOBILE_FIELD_NUMBER = 11;
                public static final int OVERALL_RATING_FIELD_NUMBER = 13;
                public static final int PRICE_FIELD_NUMBER = 14;
                public static final int PRIORITY_FIELD_NUMBER = 15;
                public static final int REVIEW_NUM_FIELD_NUMBER = 7;
                public static final int SERVICE_RATING_FIELD_NUMBER = 16;
                public static final int TASTE_RATING_FIELD_NUMBER = 17;
                public static final int TIME_STAMP_FIELD_NUMBER = 18;
                public static final int URL_FIELD_NUMBER = 6;
                public static final int URL_MOBILEPHONE_FIELD_NUMBER = 5;
                public static final int USER_LOGO_FIELD_NUMBER = 19;
                public static final int USER_NAME_FIELD_NUMBER = 20;
                /* renamed from: A */
                private String f11612A = "";
                /* renamed from: B */
                private boolean f11613B;
                /* renamed from: C */
                private int f11614C = 0;
                /* renamed from: D */
                private boolean f11615D;
                /* renamed from: E */
                private String f11616E = "";
                /* renamed from: F */
                private boolean f11617F;
                /* renamed from: G */
                private String f11618G = "";
                /* renamed from: H */
                private boolean f11619H;
                /* renamed from: I */
                private String f11620I = "";
                /* renamed from: J */
                private boolean f11621J;
                /* renamed from: K */
                private String f11622K = "";
                /* renamed from: L */
                private boolean f11623L;
                /* renamed from: M */
                private String f11624M = "";
                /* renamed from: N */
                private int f11625N = -1;
                /* renamed from: a */
                private List<Info> f11626a = Collections.emptyList();
                /* renamed from: b */
                private boolean f11627b;
                /* renamed from: c */
                private String f11628c = "";
                /* renamed from: d */
                private boolean f11629d;
                /* renamed from: e */
                private String f11630e = "";
                /* renamed from: f */
                private boolean f11631f;
                /* renamed from: g */
                private String f11632g = "";
                /* renamed from: h */
                private boolean f11633h;
                /* renamed from: i */
                private String f11634i = "";
                /* renamed from: j */
                private boolean f11635j;
                /* renamed from: k */
                private String f11636k = "";
                /* renamed from: l */
                private boolean f11637l;
                /* renamed from: m */
                private String f11638m = "";
                /* renamed from: n */
                private boolean f11639n;
                /* renamed from: o */
                private String f11640o = "";
                /* renamed from: p */
                private boolean f11641p;
                /* renamed from: q */
                private String f11642q = "";
                /* renamed from: r */
                private boolean f11643r;
                /* renamed from: s */
                private String f11644s = "";
                /* renamed from: t */
                private boolean f11645t;
                /* renamed from: u */
                private String f11646u = "";
                /* renamed from: v */
                private boolean f11647v;
                /* renamed from: w */
                private String f11648w = "";
                /* renamed from: x */
                private boolean f11649x;
                /* renamed from: y */
                private String f11650y = "";
                /* renamed from: z */
                private boolean f11651z;

                public static final class Info extends MessageMicro {
                    public static final int CONTENT_FIELD_NUMBER = 2;
                    public static final int DATE_FIELD_NUMBER = 3;
                    public static final int NAME_FIELD_NUMBER = 9;
                    public static final int NICK_USER_RECOMMEND_FIELD_NUMBER = 4;
                    public static final int ONE_URL_FIELD_NUMBER = 1;
                    public static final int OVERALL_RATING_FIELD_NUMBER = 8;
                    public static final int PRICE_FIELD_NUMBER = 7;
                    public static final int USER_LOGO_FIELD_NUMBER = 6;
                    public static final int USER_NAME_FIELD_NUMBER = 5;
                    /* renamed from: a */
                    private boolean f11593a;
                    /* renamed from: b */
                    private String f11594b = "";
                    /* renamed from: c */
                    private boolean f11595c;
                    /* renamed from: d */
                    private String f11596d = "";
                    /* renamed from: e */
                    private boolean f11597e;
                    /* renamed from: f */
                    private String f11598f = "";
                    /* renamed from: g */
                    private boolean f11599g;
                    /* renamed from: h */
                    private String f11600h = "";
                    /* renamed from: i */
                    private boolean f11601i;
                    /* renamed from: j */
                    private String f11602j = "";
                    /* renamed from: k */
                    private boolean f11603k;
                    /* renamed from: l */
                    private String f11604l = "";
                    /* renamed from: m */
                    private boolean f11605m;
                    /* renamed from: n */
                    private int f11606n = 0;
                    /* renamed from: o */
                    private boolean f11607o;
                    /* renamed from: p */
                    private int f11608p = 0;
                    /* renamed from: q */
                    private boolean f11609q;
                    /* renamed from: r */
                    private String f11610r = "";
                    /* renamed from: s */
                    private int f11611s = -1;

                    public static Info parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Info().mergeFrom(codedInputStreamMicro);
                    }

                    public static Info parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Info) new Info().mergeFrom(bArr);
                    }

                    public final Info clear() {
                        clearOneUrl();
                        clearContent();
                        clearDate();
                        clearNickUserRecommend();
                        clearUserName();
                        clearUserLogo();
                        clearPrice();
                        clearOverallRating();
                        clearName();
                        this.f11611s = -1;
                        return this;
                    }

                    public Info clearContent() {
                        this.f11595c = false;
                        this.f11596d = "";
                        return this;
                    }

                    public Info clearDate() {
                        this.f11597e = false;
                        this.f11598f = "";
                        return this;
                    }

                    public Info clearName() {
                        this.f11609q = false;
                        this.f11610r = "";
                        return this;
                    }

                    public Info clearNickUserRecommend() {
                        this.f11599g = false;
                        this.f11600h = "";
                        return this;
                    }

                    public Info clearOneUrl() {
                        this.f11593a = false;
                        this.f11594b = "";
                        return this;
                    }

                    public Info clearOverallRating() {
                        this.f11607o = false;
                        this.f11608p = 0;
                        return this;
                    }

                    public Info clearPrice() {
                        this.f11605m = false;
                        this.f11606n = 0;
                        return this;
                    }

                    public Info clearUserLogo() {
                        this.f11603k = false;
                        this.f11604l = "";
                        return this;
                    }

                    public Info clearUserName() {
                        this.f11601i = false;
                        this.f11602j = "";
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f11611s < 0) {
                            getSerializedSize();
                        }
                        return this.f11611s;
                    }

                    public String getContent() {
                        return this.f11596d;
                    }

                    public String getDate() {
                        return this.f11598f;
                    }

                    public String getName() {
                        return this.f11610r;
                    }

                    public String getNickUserRecommend() {
                        return this.f11600h;
                    }

                    public String getOneUrl() {
                        return this.f11594b;
                    }

                    public int getOverallRating() {
                        return this.f11608p;
                    }

                    public int getPrice() {
                        return this.f11606n;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasOneUrl()) {
                            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getOneUrl());
                        }
                        if (hasContent()) {
                            i += CodedOutputStreamMicro.computeStringSize(2, getContent());
                        }
                        if (hasDate()) {
                            i += CodedOutputStreamMicro.computeStringSize(3, getDate());
                        }
                        if (hasNickUserRecommend()) {
                            i += CodedOutputStreamMicro.computeStringSize(4, getNickUserRecommend());
                        }
                        if (hasUserName()) {
                            i += CodedOutputStreamMicro.computeStringSize(5, getUserName());
                        }
                        if (hasUserLogo()) {
                            i += CodedOutputStreamMicro.computeStringSize(6, getUserLogo());
                        }
                        if (hasPrice()) {
                            i += CodedOutputStreamMicro.computeInt32Size(7, getPrice());
                        }
                        if (hasOverallRating()) {
                            i += CodedOutputStreamMicro.computeInt32Size(8, getOverallRating());
                        }
                        if (hasName()) {
                            i += CodedOutputStreamMicro.computeStringSize(9, getName());
                        }
                        this.f11611s = i;
                        return i;
                    }

                    public String getUserLogo() {
                        return this.f11604l;
                    }

                    public String getUserName() {
                        return this.f11602j;
                    }

                    public boolean hasContent() {
                        return this.f11595c;
                    }

                    public boolean hasDate() {
                        return this.f11597e;
                    }

                    public boolean hasName() {
                        return this.f11609q;
                    }

                    public boolean hasNickUserRecommend() {
                        return this.f11599g;
                    }

                    public boolean hasOneUrl() {
                        return this.f11593a;
                    }

                    public boolean hasOverallRating() {
                        return this.f11607o;
                    }

                    public boolean hasPrice() {
                        return this.f11605m;
                    }

                    public boolean hasUserLogo() {
                        return this.f11603k;
                    }

                    public boolean hasUserName() {
                        return this.f11601i;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Info mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    setOneUrl(codedInputStreamMicro.readString());
                                    continue;
                                case 18:
                                    setContent(codedInputStreamMicro.readString());
                                    continue;
                                case 26:
                                    setDate(codedInputStreamMicro.readString());
                                    continue;
                                case 34:
                                    setNickUserRecommend(codedInputStreamMicro.readString());
                                    continue;
                                case 42:
                                    setUserName(codedInputStreamMicro.readString());
                                    continue;
                                case 50:
                                    setUserLogo(codedInputStreamMicro.readString());
                                    continue;
                                case 56:
                                    setPrice(codedInputStreamMicro.readInt32());
                                    continue;
                                case 64:
                                    setOverallRating(codedInputStreamMicro.readInt32());
                                    continue;
                                case 74:
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

                    public Info setContent(String str) {
                        this.f11595c = true;
                        this.f11596d = str;
                        return this;
                    }

                    public Info setDate(String str) {
                        this.f11597e = true;
                        this.f11598f = str;
                        return this;
                    }

                    public Info setName(String str) {
                        this.f11609q = true;
                        this.f11610r = str;
                        return this;
                    }

                    public Info setNickUserRecommend(String str) {
                        this.f11599g = true;
                        this.f11600h = str;
                        return this;
                    }

                    public Info setOneUrl(String str) {
                        this.f11593a = true;
                        this.f11594b = str;
                        return this;
                    }

                    public Info setOverallRating(int i) {
                        this.f11607o = true;
                        this.f11608p = i;
                        return this;
                    }

                    public Info setPrice(int i) {
                        this.f11605m = true;
                        this.f11606n = i;
                        return this;
                    }

                    public Info setUserLogo(String str) {
                        this.f11603k = true;
                        this.f11604l = str;
                        return this;
                    }

                    public Info setUserName(String str) {
                        this.f11601i = true;
                        this.f11602j = str;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasOneUrl()) {
                            codedOutputStreamMicro.writeString(1, getOneUrl());
                        }
                        if (hasContent()) {
                            codedOutputStreamMicro.writeString(2, getContent());
                        }
                        if (hasDate()) {
                            codedOutputStreamMicro.writeString(3, getDate());
                        }
                        if (hasNickUserRecommend()) {
                            codedOutputStreamMicro.writeString(4, getNickUserRecommend());
                        }
                        if (hasUserName()) {
                            codedOutputStreamMicro.writeString(5, getUserName());
                        }
                        if (hasUserLogo()) {
                            codedOutputStreamMicro.writeString(6, getUserLogo());
                        }
                        if (hasPrice()) {
                            codedOutputStreamMicro.writeInt32(7, getPrice());
                        }
                        if (hasOverallRating()) {
                            codedOutputStreamMicro.writeInt32(8, getOverallRating());
                        }
                        if (hasName()) {
                            codedOutputStreamMicro.writeString(9, getName());
                        }
                    }
                }

                public static Review parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Review().mergeFrom(codedInputStreamMicro);
                }

                public static Review parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Review) new Review().mergeFrom(bArr);
                }

                public Review addInfo(Info info) {
                    if (info != null) {
                        if (this.f11626a.isEmpty()) {
                            this.f11626a = new ArrayList();
                        }
                        this.f11626a.add(info);
                    }
                    return this;
                }

                public final Review clear() {
                    clearInfo();
                    clearCnName();
                    clearFrom();
                    clearName();
                    clearUrlMobilephone();
                    clearUrl();
                    clearReviewNum();
                    clearContent();
                    clearDate();
                    clearEnvironmentRating();
                    clearOneUrlMobile();
                    clearOneUrl();
                    clearOverallRating();
                    clearPrice();
                    clearPriority();
                    clearServiceRating();
                    clearTasteRating();
                    clearTimeStamp();
                    clearUserLogo();
                    clearUserName();
                    this.f11625N = -1;
                    return this;
                }

                public Review clearCnName() {
                    this.f11627b = false;
                    this.f11628c = "";
                    return this;
                }

                public Review clearContent() {
                    this.f11639n = false;
                    this.f11640o = "";
                    return this;
                }

                public Review clearDate() {
                    this.f11641p = false;
                    this.f11642q = "";
                    return this;
                }

                public Review clearEnvironmentRating() {
                    this.f11643r = false;
                    this.f11644s = "";
                    return this;
                }

                public Review clearFrom() {
                    this.f11629d = false;
                    this.f11630e = "";
                    return this;
                }

                public Review clearInfo() {
                    this.f11626a = Collections.emptyList();
                    return this;
                }

                public Review clearName() {
                    this.f11631f = false;
                    this.f11632g = "";
                    return this;
                }

                public Review clearOneUrl() {
                    this.f11647v = false;
                    this.f11648w = "";
                    return this;
                }

                public Review clearOneUrlMobile() {
                    this.f11645t = false;
                    this.f11646u = "";
                    return this;
                }

                public Review clearOverallRating() {
                    this.f11649x = false;
                    this.f11650y = "";
                    return this;
                }

                public Review clearPrice() {
                    this.f11651z = false;
                    this.f11612A = "";
                    return this;
                }

                public Review clearPriority() {
                    this.f11613B = false;
                    this.f11614C = 0;
                    return this;
                }

                public Review clearReviewNum() {
                    this.f11637l = false;
                    this.f11638m = "";
                    return this;
                }

                public Review clearServiceRating() {
                    this.f11615D = false;
                    this.f11616E = "";
                    return this;
                }

                public Review clearTasteRating() {
                    this.f11617F = false;
                    this.f11618G = "";
                    return this;
                }

                public Review clearTimeStamp() {
                    this.f11619H = false;
                    this.f11620I = "";
                    return this;
                }

                public Review clearUrl() {
                    this.f11635j = false;
                    this.f11636k = "";
                    return this;
                }

                public Review clearUrlMobilephone() {
                    this.f11633h = false;
                    this.f11634i = "";
                    return this;
                }

                public Review clearUserLogo() {
                    this.f11621J = false;
                    this.f11622K = "";
                    return this;
                }

                public Review clearUserName() {
                    this.f11623L = false;
                    this.f11624M = "";
                    return this;
                }

                public int getCachedSize() {
                    if (this.f11625N < 0) {
                        getSerializedSize();
                    }
                    return this.f11625N;
                }

                public String getCnName() {
                    return this.f11628c;
                }

                public String getContent() {
                    return this.f11640o;
                }

                public String getDate() {
                    return this.f11642q;
                }

                public String getEnvironmentRating() {
                    return this.f11644s;
                }

                public String getFrom() {
                    return this.f11630e;
                }

                public Info getInfo(int i) {
                    return (Info) this.f11626a.get(i);
                }

                public int getInfoCount() {
                    return this.f11626a.size();
                }

                public List<Info> getInfoList() {
                    return this.f11626a;
                }

                public String getName() {
                    return this.f11632g;
                }

                public String getOneUrl() {
                    return this.f11648w;
                }

                public String getOneUrlMobile() {
                    return this.f11646u;
                }

                public String getOverallRating() {
                    return this.f11650y;
                }

                public String getPrice() {
                    return this.f11612A;
                }

                public int getPriority() {
                    return this.f11614C;
                }

                public String getReviewNum() {
                    return this.f11638m;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasCnName()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCnName());
                    }
                    if (hasFrom()) {
                        i += CodedOutputStreamMicro.computeStringSize(2, getFrom());
                    }
                    int i2 = i;
                    for (Info computeMessageSize : getInfoList()) {
                        i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
                    }
                    if (hasName()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(4, getName());
                    }
                    if (hasUrlMobilephone()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(5, getUrlMobilephone());
                    }
                    if (hasUrl()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(6, getUrl());
                    }
                    if (hasReviewNum()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(7, getReviewNum());
                    }
                    if (hasContent()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(8, getContent());
                    }
                    if (hasDate()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(9, getDate());
                    }
                    if (hasEnvironmentRating()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(10, getEnvironmentRating());
                    }
                    if (hasOneUrlMobile()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(11, getOneUrlMobile());
                    }
                    if (hasOneUrl()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(12, getOneUrl());
                    }
                    if (hasOverallRating()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(13, getOverallRating());
                    }
                    if (hasPrice()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(14, getPrice());
                    }
                    if (hasPriority()) {
                        i2 += CodedOutputStreamMicro.computeInt32Size(15, getPriority());
                    }
                    if (hasServiceRating()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(16, getServiceRating());
                    }
                    if (hasTasteRating()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(17, getTasteRating());
                    }
                    if (hasTimeStamp()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(18, getTimeStamp());
                    }
                    if (hasUserLogo()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(19, getUserLogo());
                    }
                    if (hasUserName()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(20, getUserName());
                    }
                    this.f11625N = i2;
                    return i2;
                }

                public String getServiceRating() {
                    return this.f11616E;
                }

                public String getTasteRating() {
                    return this.f11618G;
                }

                public String getTimeStamp() {
                    return this.f11620I;
                }

                public String getUrl() {
                    return this.f11636k;
                }

                public String getUrlMobilephone() {
                    return this.f11634i;
                }

                public String getUserLogo() {
                    return this.f11622K;
                }

                public String getUserName() {
                    return this.f11624M;
                }

                public boolean hasCnName() {
                    return this.f11627b;
                }

                public boolean hasContent() {
                    return this.f11639n;
                }

                public boolean hasDate() {
                    return this.f11641p;
                }

                public boolean hasEnvironmentRating() {
                    return this.f11643r;
                }

                public boolean hasFrom() {
                    return this.f11629d;
                }

                public boolean hasName() {
                    return this.f11631f;
                }

                public boolean hasOneUrl() {
                    return this.f11647v;
                }

                public boolean hasOneUrlMobile() {
                    return this.f11645t;
                }

                public boolean hasOverallRating() {
                    return this.f11649x;
                }

                public boolean hasPrice() {
                    return this.f11651z;
                }

                public boolean hasPriority() {
                    return this.f11613B;
                }

                public boolean hasReviewNum() {
                    return this.f11637l;
                }

                public boolean hasServiceRating() {
                    return this.f11615D;
                }

                public boolean hasTasteRating() {
                    return this.f11617F;
                }

                public boolean hasTimeStamp() {
                    return this.f11619H;
                }

                public boolean hasUrl() {
                    return this.f11635j;
                }

                public boolean hasUrlMobilephone() {
                    return this.f11633h;
                }

                public boolean hasUserLogo() {
                    return this.f11621J;
                }

                public boolean hasUserName() {
                    return this.f11623L;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Review mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                setCnName(codedInputStreamMicro.readString());
                                continue;
                            case 18:
                                setFrom(codedInputStreamMicro.readString());
                                continue;
                            case 26:
                                MessageMicro info = new Info();
                                codedInputStreamMicro.readMessage(info);
                                addInfo(info);
                                continue;
                            case 34:
                                setName(codedInputStreamMicro.readString());
                                continue;
                            case 42:
                                setUrlMobilephone(codedInputStreamMicro.readString());
                                continue;
                            case 50:
                                setUrl(codedInputStreamMicro.readString());
                                continue;
                            case 58:
                                setReviewNum(codedInputStreamMicro.readString());
                                continue;
                            case 66:
                                setContent(codedInputStreamMicro.readString());
                                continue;
                            case 74:
                                setDate(codedInputStreamMicro.readString());
                                continue;
                            case 82:
                                setEnvironmentRating(codedInputStreamMicro.readString());
                                continue;
                            case 90:
                                setOneUrlMobile(codedInputStreamMicro.readString());
                                continue;
                            case 98:
                                setOneUrl(codedInputStreamMicro.readString());
                                continue;
                            case 106:
                                setOverallRating(codedInputStreamMicro.readString());
                                continue;
                            case 114:
                                setPrice(codedInputStreamMicro.readString());
                                continue;
                            case 120:
                                setPriority(codedInputStreamMicro.readInt32());
                                continue;
                            case 130:
                                setServiceRating(codedInputStreamMicro.readString());
                                continue;
                            case 138:
                                setTasteRating(codedInputStreamMicro.readString());
                                continue;
                            case 146:
                                setTimeStamp(codedInputStreamMicro.readString());
                                continue;
                            case 154:
                                setUserLogo(codedInputStreamMicro.readString());
                                continue;
                            case 162:
                                setUserName(codedInputStreamMicro.readString());
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

                public Review setCnName(String str) {
                    this.f11627b = true;
                    this.f11628c = str;
                    return this;
                }

                public Review setContent(String str) {
                    this.f11639n = true;
                    this.f11640o = str;
                    return this;
                }

                public Review setDate(String str) {
                    this.f11641p = true;
                    this.f11642q = str;
                    return this;
                }

                public Review setEnvironmentRating(String str) {
                    this.f11643r = true;
                    this.f11644s = str;
                    return this;
                }

                public Review setFrom(String str) {
                    this.f11629d = true;
                    this.f11630e = str;
                    return this;
                }

                public Review setInfo(int i, Info info) {
                    if (info != null) {
                        this.f11626a.set(i, info);
                    }
                    return this;
                }

                public Review setName(String str) {
                    this.f11631f = true;
                    this.f11632g = str;
                    return this;
                }

                public Review setOneUrl(String str) {
                    this.f11647v = true;
                    this.f11648w = str;
                    return this;
                }

                public Review setOneUrlMobile(String str) {
                    this.f11645t = true;
                    this.f11646u = str;
                    return this;
                }

                public Review setOverallRating(String str) {
                    this.f11649x = true;
                    this.f11650y = str;
                    return this;
                }

                public Review setPrice(String str) {
                    this.f11651z = true;
                    this.f11612A = str;
                    return this;
                }

                public Review setPriority(int i) {
                    this.f11613B = true;
                    this.f11614C = i;
                    return this;
                }

                public Review setReviewNum(String str) {
                    this.f11637l = true;
                    this.f11638m = str;
                    return this;
                }

                public Review setServiceRating(String str) {
                    this.f11615D = true;
                    this.f11616E = str;
                    return this;
                }

                public Review setTasteRating(String str) {
                    this.f11617F = true;
                    this.f11618G = str;
                    return this;
                }

                public Review setTimeStamp(String str) {
                    this.f11619H = true;
                    this.f11620I = str;
                    return this;
                }

                public Review setUrl(String str) {
                    this.f11635j = true;
                    this.f11636k = str;
                    return this;
                }

                public Review setUrlMobilephone(String str) {
                    this.f11633h = true;
                    this.f11634i = str;
                    return this;
                }

                public Review setUserLogo(String str) {
                    this.f11621J = true;
                    this.f11622K = str;
                    return this;
                }

                public Review setUserName(String str) {
                    this.f11623L = true;
                    this.f11624M = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasCnName()) {
                        codedOutputStreamMicro.writeString(1, getCnName());
                    }
                    if (hasFrom()) {
                        codedOutputStreamMicro.writeString(2, getFrom());
                    }
                    for (Info writeMessage : getInfoList()) {
                        codedOutputStreamMicro.writeMessage(3, writeMessage);
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(4, getName());
                    }
                    if (hasUrlMobilephone()) {
                        codedOutputStreamMicro.writeString(5, getUrlMobilephone());
                    }
                    if (hasUrl()) {
                        codedOutputStreamMicro.writeString(6, getUrl());
                    }
                    if (hasReviewNum()) {
                        codedOutputStreamMicro.writeString(7, getReviewNum());
                    }
                    if (hasContent()) {
                        codedOutputStreamMicro.writeString(8, getContent());
                    }
                    if (hasDate()) {
                        codedOutputStreamMicro.writeString(9, getDate());
                    }
                    if (hasEnvironmentRating()) {
                        codedOutputStreamMicro.writeString(10, getEnvironmentRating());
                    }
                    if (hasOneUrlMobile()) {
                        codedOutputStreamMicro.writeString(11, getOneUrlMobile());
                    }
                    if (hasOneUrl()) {
                        codedOutputStreamMicro.writeString(12, getOneUrl());
                    }
                    if (hasOverallRating()) {
                        codedOutputStreamMicro.writeString(13, getOverallRating());
                    }
                    if (hasPrice()) {
                        codedOutputStreamMicro.writeString(14, getPrice());
                    }
                    if (hasPriority()) {
                        codedOutputStreamMicro.writeInt32(15, getPriority());
                    }
                    if (hasServiceRating()) {
                        codedOutputStreamMicro.writeString(16, getServiceRating());
                    }
                    if (hasTasteRating()) {
                        codedOutputStreamMicro.writeString(17, getTasteRating());
                    }
                    if (hasTimeStamp()) {
                        codedOutputStreamMicro.writeString(18, getTimeStamp());
                    }
                    if (hasUserLogo()) {
                        codedOutputStreamMicro.writeString(19, getUserLogo());
                    }
                    if (hasUserName()) {
                        codedOutputStreamMicro.writeString(20, getUserName());
                    }
                }
            }

            public static final class RichInfo extends MessageMicro {
                public static final int ALIAS_FIELD_NUMBER = 13;
                public static final int ATMOSPHERE_FIELD_NUMBER = 15;
                public static final int BRAND_FIELD_NUMBER = 4;
                public static final int CATEGORY_FIELD_NUMBER = 3;
                public static final int COMMENT_NO_NUM_FIELD_NUMBER = 2;
                public static final int COMMENT_YES_NUM_FIELD_NUMBER = 1;
                public static final int DESCRIPTION_CN_NAME_FIELD_NUMBER = 16;
                public static final int DESCRIPTION_FIELD_NUMBER = 6;
                public static final int DESCRIPTION_NAME_FIELD_NUMBER = 17;
                public static final int DESCRIPTION_URL_FIELD_NUMBER = 19;
                public static final int DESCRIPTION_URL_MOBILE_FIELD_NUMBER = 18;
                public static final int ENVIRONMENT_EXTERIOR_FIELD_NUMBER = 8;
                public static final int HOTEL_FACILITY_FIELD_NUMBER = 10;
                public static final int HOTEL_SERVICE_FIELD_NUMBER = 11;
                public static final int INNER_FACILITY_FIELD_NUMBER = 9;
                public static final int LEVEL_FIELD_NUMBER = 5;
                public static final int MORE_REVIEWS_FIELD_NUMBER = 20;
                public static final int PAYMENT_TYPE_FIELD_NUMBER = 12;
                public static final int SHOP_HOURS_FIELD_NUMBER = 7;
                /* renamed from: A */
                private String f11664A = "";
                /* renamed from: B */
                private boolean f11665B;
                /* renamed from: C */
                private String f11666C = "";
                /* renamed from: D */
                private boolean f11667D;
                /* renamed from: E */
                private String f11668E = "";
                /* renamed from: F */
                private boolean f11669F;
                /* renamed from: G */
                private String f11670G = "";
                /* renamed from: H */
                private boolean f11671H;
                /* renamed from: I */
                private String f11672I = "";
                /* renamed from: J */
                private boolean f11673J;
                /* renamed from: K */
                private String f11674K = "";
                /* renamed from: L */
                private int f11675L = -1;
                /* renamed from: a */
                private List<MoreReviews> f11676a = Collections.emptyList();
                /* renamed from: b */
                private boolean f11677b;
                /* renamed from: c */
                private String f11678c = "";
                /* renamed from: d */
                private boolean f11679d;
                /* renamed from: e */
                private String f11680e = "";
                /* renamed from: f */
                private boolean f11681f;
                /* renamed from: g */
                private String f11682g = "";
                /* renamed from: h */
                private boolean f11683h;
                /* renamed from: i */
                private String f11684i = "";
                /* renamed from: j */
                private boolean f11685j;
                /* renamed from: k */
                private String f11686k = "";
                /* renamed from: l */
                private boolean f11687l;
                /* renamed from: m */
                private String f11688m = "";
                /* renamed from: n */
                private boolean f11689n;
                /* renamed from: o */
                private String f11690o = "";
                /* renamed from: p */
                private boolean f11691p;
                /* renamed from: q */
                private String f11692q = "";
                /* renamed from: r */
                private boolean f11693r;
                /* renamed from: s */
                private String f11694s = "";
                /* renamed from: t */
                private boolean f11695t;
                /* renamed from: u */
                private String f11696u = "";
                /* renamed from: v */
                private boolean f11697v;
                /* renamed from: w */
                private String f11698w = "";
                /* renamed from: x */
                private boolean f11699x;
                /* renamed from: y */
                private String f11700y = "";
                /* renamed from: z */
                private boolean f11701z;

                public static final class MoreReviews extends MessageMicro {
                    public static final int DIANPING_FIELD_NUMBER = 1;
                    /* renamed from: a */
                    private boolean f11661a;
                    /* renamed from: b */
                    private Dianping f11662b = null;
                    /* renamed from: c */
                    private int f11663c = -1;

                    public static final class Dianping extends MessageMicro {
                        public static final int CN_NAME_FIELD_NUMBER = 1;
                        public static final int COMMENT_URL_FIELD_NUMBER = 3;
                        public static final int COMMENT_URL_MOBILE_FIELD_NUMBER = 2;
                        public static final int COUNT_FIELD_NUMBER = 4;
                        /* renamed from: a */
                        private boolean f11652a;
                        /* renamed from: b */
                        private String f11653b = "";
                        /* renamed from: c */
                        private boolean f11654c;
                        /* renamed from: d */
                        private String f11655d = "";
                        /* renamed from: e */
                        private boolean f11656e;
                        /* renamed from: f */
                        private String f11657f = "";
                        /* renamed from: g */
                        private boolean f11658g;
                        /* renamed from: h */
                        private String f11659h = "";
                        /* renamed from: i */
                        private int f11660i = -1;

                        public static Dianping parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new Dianping().mergeFrom(codedInputStreamMicro);
                        }

                        public static Dianping parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (Dianping) new Dianping().mergeFrom(bArr);
                        }

                        public final Dianping clear() {
                            clearCnName();
                            clearCommentUrlMobile();
                            clearCommentUrl();
                            clearCount();
                            this.f11660i = -1;
                            return this;
                        }

                        public Dianping clearCnName() {
                            this.f11652a = false;
                            this.f11653b = "";
                            return this;
                        }

                        public Dianping clearCommentUrl() {
                            this.f11656e = false;
                            this.f11657f = "";
                            return this;
                        }

                        public Dianping clearCommentUrlMobile() {
                            this.f11654c = false;
                            this.f11655d = "";
                            return this;
                        }

                        public Dianping clearCount() {
                            this.f11658g = false;
                            this.f11659h = "";
                            return this;
                        }

                        public int getCachedSize() {
                            if (this.f11660i < 0) {
                                getSerializedSize();
                            }
                            return this.f11660i;
                        }

                        public String getCnName() {
                            return this.f11653b;
                        }

                        public String getCommentUrl() {
                            return this.f11657f;
                        }

                        public String getCommentUrlMobile() {
                            return this.f11655d;
                        }

                        public String getCount() {
                            return this.f11659h;
                        }

                        public int getSerializedSize() {
                            int i = 0;
                            if (hasCnName()) {
                                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCnName());
                            }
                            if (hasCommentUrlMobile()) {
                                i += CodedOutputStreamMicro.computeStringSize(2, getCommentUrlMobile());
                            }
                            if (hasCommentUrl()) {
                                i += CodedOutputStreamMicro.computeStringSize(3, getCommentUrl());
                            }
                            if (hasCount()) {
                                i += CodedOutputStreamMicro.computeStringSize(4, getCount());
                            }
                            this.f11660i = i;
                            return i;
                        }

                        public boolean hasCnName() {
                            return this.f11652a;
                        }

                        public boolean hasCommentUrl() {
                            return this.f11656e;
                        }

                        public boolean hasCommentUrlMobile() {
                            return this.f11654c;
                        }

                        public boolean hasCount() {
                            return this.f11658g;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public Dianping mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                switch (readTag) {
                                    case 0:
                                        break;
                                    case 10:
                                        setCnName(codedInputStreamMicro.readString());
                                        continue;
                                    case 18:
                                        setCommentUrlMobile(codedInputStreamMicro.readString());
                                        continue;
                                    case 26:
                                        setCommentUrl(codedInputStreamMicro.readString());
                                        continue;
                                    case 34:
                                        setCount(codedInputStreamMicro.readString());
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

                        public Dianping setCnName(String str) {
                            this.f11652a = true;
                            this.f11653b = str;
                            return this;
                        }

                        public Dianping setCommentUrl(String str) {
                            this.f11656e = true;
                            this.f11657f = str;
                            return this;
                        }

                        public Dianping setCommentUrlMobile(String str) {
                            this.f11654c = true;
                            this.f11655d = str;
                            return this;
                        }

                        public Dianping setCount(String str) {
                            this.f11658g = true;
                            this.f11659h = str;
                            return this;
                        }

                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasCnName()) {
                                codedOutputStreamMicro.writeString(1, getCnName());
                            }
                            if (hasCommentUrlMobile()) {
                                codedOutputStreamMicro.writeString(2, getCommentUrlMobile());
                            }
                            if (hasCommentUrl()) {
                                codedOutputStreamMicro.writeString(3, getCommentUrl());
                            }
                            if (hasCount()) {
                                codedOutputStreamMicro.writeString(4, getCount());
                            }
                        }
                    }

                    public static MoreReviews parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new MoreReviews().mergeFrom(codedInputStreamMicro);
                    }

                    public static MoreReviews parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (MoreReviews) new MoreReviews().mergeFrom(bArr);
                    }

                    public final MoreReviews clear() {
                        clearDianping();
                        this.f11663c = -1;
                        return this;
                    }

                    public MoreReviews clearDianping() {
                        this.f11661a = false;
                        this.f11662b = null;
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f11663c < 0) {
                            getSerializedSize();
                        }
                        return this.f11663c;
                    }

                    public Dianping getDianping() {
                        return this.f11662b;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasDianping()) {
                            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getDianping());
                        }
                        this.f11663c = i;
                        return i;
                    }

                    public boolean hasDianping() {
                        return this.f11661a;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public MoreReviews mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    MessageMicro dianping = new Dianping();
                                    codedInputStreamMicro.readMessage(dianping);
                                    setDianping(dianping);
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

                    public MoreReviews setDianping(Dianping dianping) {
                        if (dianping == null) {
                            return clearDianping();
                        }
                        this.f11661a = true;
                        this.f11662b = dianping;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasDianping()) {
                            codedOutputStreamMicro.writeMessage(1, getDianping());
                        }
                    }
                }

                public static RichInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new RichInfo().mergeFrom(codedInputStreamMicro);
                }

                public static RichInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (RichInfo) new RichInfo().mergeFrom(bArr);
                }

                public RichInfo addMoreReviews(MoreReviews moreReviews) {
                    if (moreReviews != null) {
                        if (this.f11676a.isEmpty()) {
                            this.f11676a = new ArrayList();
                        }
                        this.f11676a.add(moreReviews);
                    }
                    return this;
                }

                public final RichInfo clear() {
                    clearMoreReviews();
                    clearCommentYesNum();
                    clearCommentNoNum();
                    clearCategory();
                    clearBrand();
                    clearLevel();
                    clearDescription();
                    clearShopHours();
                    clearEnvironmentExterior();
                    clearInnerFacility();
                    clearHotelFacility();
                    clearHotelService();
                    clearPaymentType();
                    clearAlias();
                    clearAtmosphere();
                    clearDescriptionCnName();
                    clearDescriptionName();
                    clearDescriptionUrlMobile();
                    clearDescriptionUrl();
                    this.f11675L = -1;
                    return this;
                }

                public RichInfo clearAlias() {
                    this.f11701z = false;
                    this.f11664A = "";
                    return this;
                }

                public RichInfo clearAtmosphere() {
                    this.f11665B = false;
                    this.f11666C = "";
                    return this;
                }

                public RichInfo clearBrand() {
                    this.f11683h = false;
                    this.f11684i = "";
                    return this;
                }

                public RichInfo clearCategory() {
                    this.f11681f = false;
                    this.f11682g = "";
                    return this;
                }

                public RichInfo clearCommentNoNum() {
                    this.f11679d = false;
                    this.f11680e = "";
                    return this;
                }

                public RichInfo clearCommentYesNum() {
                    this.f11677b = false;
                    this.f11678c = "";
                    return this;
                }

                public RichInfo clearDescription() {
                    this.f11687l = false;
                    this.f11688m = "";
                    return this;
                }

                public RichInfo clearDescriptionCnName() {
                    this.f11667D = false;
                    this.f11668E = "";
                    return this;
                }

                public RichInfo clearDescriptionName() {
                    this.f11669F = false;
                    this.f11670G = "";
                    return this;
                }

                public RichInfo clearDescriptionUrl() {
                    this.f11673J = false;
                    this.f11674K = "";
                    return this;
                }

                public RichInfo clearDescriptionUrlMobile() {
                    this.f11671H = false;
                    this.f11672I = "";
                    return this;
                }

                public RichInfo clearEnvironmentExterior() {
                    this.f11691p = false;
                    this.f11692q = "";
                    return this;
                }

                public RichInfo clearHotelFacility() {
                    this.f11695t = false;
                    this.f11696u = "";
                    return this;
                }

                public RichInfo clearHotelService() {
                    this.f11697v = false;
                    this.f11698w = "";
                    return this;
                }

                public RichInfo clearInnerFacility() {
                    this.f11693r = false;
                    this.f11694s = "";
                    return this;
                }

                public RichInfo clearLevel() {
                    this.f11685j = false;
                    this.f11686k = "";
                    return this;
                }

                public RichInfo clearMoreReviews() {
                    this.f11676a = Collections.emptyList();
                    return this;
                }

                public RichInfo clearPaymentType() {
                    this.f11699x = false;
                    this.f11700y = "";
                    return this;
                }

                public RichInfo clearShopHours() {
                    this.f11689n = false;
                    this.f11690o = "";
                    return this;
                }

                public String getAlias() {
                    return this.f11664A;
                }

                public String getAtmosphere() {
                    return this.f11666C;
                }

                public String getBrand() {
                    return this.f11684i;
                }

                public int getCachedSize() {
                    if (this.f11675L < 0) {
                        getSerializedSize();
                    }
                    return this.f11675L;
                }

                public String getCategory() {
                    return this.f11682g;
                }

                public String getCommentNoNum() {
                    return this.f11680e;
                }

                public String getCommentYesNum() {
                    return this.f11678c;
                }

                public String getDescription() {
                    return this.f11688m;
                }

                public String getDescriptionCnName() {
                    return this.f11668E;
                }

                public String getDescriptionName() {
                    return this.f11670G;
                }

                public String getDescriptionUrl() {
                    return this.f11674K;
                }

                public String getDescriptionUrlMobile() {
                    return this.f11672I;
                }

                public String getEnvironmentExterior() {
                    return this.f11692q;
                }

                public String getHotelFacility() {
                    return this.f11696u;
                }

                public String getHotelService() {
                    return this.f11698w;
                }

                public String getInnerFacility() {
                    return this.f11694s;
                }

                public String getLevel() {
                    return this.f11686k;
                }

                public MoreReviews getMoreReviews(int i) {
                    return (MoreReviews) this.f11676a.get(i);
                }

                public int getMoreReviewsCount() {
                    return this.f11676a.size();
                }

                public List<MoreReviews> getMoreReviewsList() {
                    return this.f11676a;
                }

                public String getPaymentType() {
                    return this.f11700y;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasCommentYesNum()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCommentYesNum());
                    }
                    if (hasCommentNoNum()) {
                        i += CodedOutputStreamMicro.computeStringSize(2, getCommentNoNum());
                    }
                    if (hasCategory()) {
                        i += CodedOutputStreamMicro.computeStringSize(3, getCategory());
                    }
                    if (hasBrand()) {
                        i += CodedOutputStreamMicro.computeStringSize(4, getBrand());
                    }
                    if (hasLevel()) {
                        i += CodedOutputStreamMicro.computeStringSize(5, getLevel());
                    }
                    if (hasDescription()) {
                        i += CodedOutputStreamMicro.computeStringSize(6, getDescription());
                    }
                    if (hasShopHours()) {
                        i += CodedOutputStreamMicro.computeStringSize(7, getShopHours());
                    }
                    if (hasEnvironmentExterior()) {
                        i += CodedOutputStreamMicro.computeStringSize(8, getEnvironmentExterior());
                    }
                    if (hasInnerFacility()) {
                        i += CodedOutputStreamMicro.computeStringSize(9, getInnerFacility());
                    }
                    if (hasHotelFacility()) {
                        i += CodedOutputStreamMicro.computeStringSize(10, getHotelFacility());
                    }
                    if (hasHotelService()) {
                        i += CodedOutputStreamMicro.computeStringSize(11, getHotelService());
                    }
                    if (hasPaymentType()) {
                        i += CodedOutputStreamMicro.computeStringSize(12, getPaymentType());
                    }
                    if (hasAlias()) {
                        i += CodedOutputStreamMicro.computeStringSize(13, getAlias());
                    }
                    if (hasAtmosphere()) {
                        i += CodedOutputStreamMicro.computeStringSize(15, getAtmosphere());
                    }
                    if (hasDescriptionCnName()) {
                        i += CodedOutputStreamMicro.computeStringSize(16, getDescriptionCnName());
                    }
                    if (hasDescriptionName()) {
                        i += CodedOutputStreamMicro.computeStringSize(17, getDescriptionName());
                    }
                    if (hasDescriptionUrlMobile()) {
                        i += CodedOutputStreamMicro.computeStringSize(18, getDescriptionUrlMobile());
                    }
                    if (hasDescriptionUrl()) {
                        i += CodedOutputStreamMicro.computeStringSize(19, getDescriptionUrl());
                    }
                    int i2 = i;
                    for (MoreReviews computeMessageSize : getMoreReviewsList()) {
                        i2 = CodedOutputStreamMicro.computeMessageSize(20, computeMessageSize) + i2;
                    }
                    this.f11675L = i2;
                    return i2;
                }

                public String getShopHours() {
                    return this.f11690o;
                }

                public boolean hasAlias() {
                    return this.f11701z;
                }

                public boolean hasAtmosphere() {
                    return this.f11665B;
                }

                public boolean hasBrand() {
                    return this.f11683h;
                }

                public boolean hasCategory() {
                    return this.f11681f;
                }

                public boolean hasCommentNoNum() {
                    return this.f11679d;
                }

                public boolean hasCommentYesNum() {
                    return this.f11677b;
                }

                public boolean hasDescription() {
                    return this.f11687l;
                }

                public boolean hasDescriptionCnName() {
                    return this.f11667D;
                }

                public boolean hasDescriptionName() {
                    return this.f11669F;
                }

                public boolean hasDescriptionUrl() {
                    return this.f11673J;
                }

                public boolean hasDescriptionUrlMobile() {
                    return this.f11671H;
                }

                public boolean hasEnvironmentExterior() {
                    return this.f11691p;
                }

                public boolean hasHotelFacility() {
                    return this.f11695t;
                }

                public boolean hasHotelService() {
                    return this.f11697v;
                }

                public boolean hasInnerFacility() {
                    return this.f11693r;
                }

                public boolean hasLevel() {
                    return this.f11685j;
                }

                public boolean hasPaymentType() {
                    return this.f11699x;
                }

                public boolean hasShopHours() {
                    return this.f11689n;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public RichInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                setCommentYesNum(codedInputStreamMicro.readString());
                                continue;
                            case 18:
                                setCommentNoNum(codedInputStreamMicro.readString());
                                continue;
                            case 26:
                                setCategory(codedInputStreamMicro.readString());
                                continue;
                            case 34:
                                setBrand(codedInputStreamMicro.readString());
                                continue;
                            case 42:
                                setLevel(codedInputStreamMicro.readString());
                                continue;
                            case 50:
                                setDescription(codedInputStreamMicro.readString());
                                continue;
                            case 58:
                                setShopHours(codedInputStreamMicro.readString());
                                continue;
                            case 66:
                                setEnvironmentExterior(codedInputStreamMicro.readString());
                                continue;
                            case 74:
                                setInnerFacility(codedInputStreamMicro.readString());
                                continue;
                            case 82:
                                setHotelFacility(codedInputStreamMicro.readString());
                                continue;
                            case 90:
                                setHotelService(codedInputStreamMicro.readString());
                                continue;
                            case 98:
                                setPaymentType(codedInputStreamMicro.readString());
                                continue;
                            case 106:
                                setAlias(codedInputStreamMicro.readString());
                                continue;
                            case C1253f.df /*122*/:
                                setAtmosphere(codedInputStreamMicro.readString());
                                continue;
                            case 130:
                                setDescriptionCnName(codedInputStreamMicro.readString());
                                continue;
                            case 138:
                                setDescriptionName(codedInputStreamMicro.readString());
                                continue;
                            case 146:
                                setDescriptionUrlMobile(codedInputStreamMicro.readString());
                                continue;
                            case 154:
                                setDescriptionUrl(codedInputStreamMicro.readString());
                                continue;
                            case 162:
                                MessageMicro moreReviews = new MoreReviews();
                                codedInputStreamMicro.readMessage(moreReviews);
                                addMoreReviews(moreReviews);
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

                public RichInfo setAlias(String str) {
                    this.f11701z = true;
                    this.f11664A = str;
                    return this;
                }

                public RichInfo setAtmosphere(String str) {
                    this.f11665B = true;
                    this.f11666C = str;
                    return this;
                }

                public RichInfo setBrand(String str) {
                    this.f11683h = true;
                    this.f11684i = str;
                    return this;
                }

                public RichInfo setCategory(String str) {
                    this.f11681f = true;
                    this.f11682g = str;
                    return this;
                }

                public RichInfo setCommentNoNum(String str) {
                    this.f11679d = true;
                    this.f11680e = str;
                    return this;
                }

                public RichInfo setCommentYesNum(String str) {
                    this.f11677b = true;
                    this.f11678c = str;
                    return this;
                }

                public RichInfo setDescription(String str) {
                    this.f11687l = true;
                    this.f11688m = str;
                    return this;
                }

                public RichInfo setDescriptionCnName(String str) {
                    this.f11667D = true;
                    this.f11668E = str;
                    return this;
                }

                public RichInfo setDescriptionName(String str) {
                    this.f11669F = true;
                    this.f11670G = str;
                    return this;
                }

                public RichInfo setDescriptionUrl(String str) {
                    this.f11673J = true;
                    this.f11674K = str;
                    return this;
                }

                public RichInfo setDescriptionUrlMobile(String str) {
                    this.f11671H = true;
                    this.f11672I = str;
                    return this;
                }

                public RichInfo setEnvironmentExterior(String str) {
                    this.f11691p = true;
                    this.f11692q = str;
                    return this;
                }

                public RichInfo setHotelFacility(String str) {
                    this.f11695t = true;
                    this.f11696u = str;
                    return this;
                }

                public RichInfo setHotelService(String str) {
                    this.f11697v = true;
                    this.f11698w = str;
                    return this;
                }

                public RichInfo setInnerFacility(String str) {
                    this.f11693r = true;
                    this.f11694s = str;
                    return this;
                }

                public RichInfo setLevel(String str) {
                    this.f11685j = true;
                    this.f11686k = str;
                    return this;
                }

                public RichInfo setMoreReviews(int i, MoreReviews moreReviews) {
                    if (moreReviews != null) {
                        this.f11676a.set(i, moreReviews);
                    }
                    return this;
                }

                public RichInfo setPaymentType(String str) {
                    this.f11699x = true;
                    this.f11700y = str;
                    return this;
                }

                public RichInfo setShopHours(String str) {
                    this.f11689n = true;
                    this.f11690o = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasCommentYesNum()) {
                        codedOutputStreamMicro.writeString(1, getCommentYesNum());
                    }
                    if (hasCommentNoNum()) {
                        codedOutputStreamMicro.writeString(2, getCommentNoNum());
                    }
                    if (hasCategory()) {
                        codedOutputStreamMicro.writeString(3, getCategory());
                    }
                    if (hasBrand()) {
                        codedOutputStreamMicro.writeString(4, getBrand());
                    }
                    if (hasLevel()) {
                        codedOutputStreamMicro.writeString(5, getLevel());
                    }
                    if (hasDescription()) {
                        codedOutputStreamMicro.writeString(6, getDescription());
                    }
                    if (hasShopHours()) {
                        codedOutputStreamMicro.writeString(7, getShopHours());
                    }
                    if (hasEnvironmentExterior()) {
                        codedOutputStreamMicro.writeString(8, getEnvironmentExterior());
                    }
                    if (hasInnerFacility()) {
                        codedOutputStreamMicro.writeString(9, getInnerFacility());
                    }
                    if (hasHotelFacility()) {
                        codedOutputStreamMicro.writeString(10, getHotelFacility());
                    }
                    if (hasHotelService()) {
                        codedOutputStreamMicro.writeString(11, getHotelService());
                    }
                    if (hasPaymentType()) {
                        codedOutputStreamMicro.writeString(12, getPaymentType());
                    }
                    if (hasAlias()) {
                        codedOutputStreamMicro.writeString(13, getAlias());
                    }
                    if (hasAtmosphere()) {
                        codedOutputStreamMicro.writeString(15, getAtmosphere());
                    }
                    if (hasDescriptionCnName()) {
                        codedOutputStreamMicro.writeString(16, getDescriptionCnName());
                    }
                    if (hasDescriptionName()) {
                        codedOutputStreamMicro.writeString(17, getDescriptionName());
                    }
                    if (hasDescriptionUrlMobile()) {
                        codedOutputStreamMicro.writeString(18, getDescriptionUrlMobile());
                    }
                    if (hasDescriptionUrl()) {
                        codedOutputStreamMicro.writeString(19, getDescriptionUrl());
                    }
                    for (MoreReviews writeMessage : getMoreReviewsList()) {
                        codedOutputStreamMicro.writeMessage(20, writeMessage);
                    }
                }
            }

            public static Ext parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Ext().mergeFrom(codedInputStreamMicro);
            }

            public static Ext parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Ext) new Ext().mergeFrom(bArr);
            }

            public Ext addLineInfo(LineInfo lineInfo) {
                if (lineInfo != null) {
                    if (this.f11709h.isEmpty()) {
                        this.f11709h = new ArrayList();
                    }
                    this.f11709h.add(lineInfo);
                }
                return this;
            }

            public Ext addReview(Review review) {
                if (review != null) {
                    if (this.f11704c.isEmpty()) {
                        this.f11704c = new ArrayList();
                    }
                    this.f11704c.add(review);
                }
                return this;
            }

            public final Ext clear() {
                clearDetailInfo();
                clearReview();
                clearRichInfo();
                clearImage();
                clearLineInfo();
                clearSrcName();
                clearExtType();
                this.f11714m = -1;
                return this;
            }

            public Ext clearDetailInfo() {
                this.f11702a = false;
                this.f11703b = null;
                return this;
            }

            public Ext clearExtType() {
                this.f11712k = false;
                this.f11713l = 0;
                return this;
            }

            public Ext clearImage() {
                this.f11707f = false;
                this.f11708g = null;
                return this;
            }

            public Ext clearLineInfo() {
                this.f11709h = Collections.emptyList();
                return this;
            }

            public Ext clearReview() {
                this.f11704c = Collections.emptyList();
                return this;
            }

            public Ext clearRichInfo() {
                this.f11705d = false;
                this.f11706e = null;
                return this;
            }

            public Ext clearSrcName() {
                this.f11710i = false;
                this.f11711j = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f11714m < 0) {
                    getSerializedSize();
                }
                return this.f11714m;
            }

            public DetailInfo getDetailInfo() {
                return this.f11703b;
            }

            public int getExtType() {
                return this.f11713l;
            }

            public Image getImage() {
                return this.f11708g;
            }

            public LineInfo getLineInfo(int i) {
                return (LineInfo) this.f11709h.get(i);
            }

            public int getLineInfoCount() {
                return this.f11709h.size();
            }

            public List<LineInfo> getLineInfoList() {
                return this.f11709h;
            }

            public Review getReview(int i) {
                return (Review) this.f11704c.get(i);
            }

            public int getReviewCount() {
                return this.f11704c.size();
            }

            public List<Review> getReviewList() {
                return this.f11704c;
            }

            public RichInfo getRichInfo() {
                return this.f11706e;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasDetailInfo()) {
                    i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getDetailInfo());
                }
                int i2 = i;
                for (Review computeMessageSize : getReviewList()) {
                    i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
                }
                if (hasRichInfo()) {
                    i2 += CodedOutputStreamMicro.computeMessageSize(3, getRichInfo());
                }
                if (hasSrcName()) {
                    i2 += CodedOutputStreamMicro.computeStringSize(4, getSrcName());
                }
                if (hasImage()) {
                    i2 += CodedOutputStreamMicro.computeMessageSize(5, getImage());
                }
                for (LineInfo computeMessageSize2 : getLineInfoList()) {
                    i2 += CodedOutputStreamMicro.computeMessageSize(6, computeMessageSize2);
                }
                if (hasExtType()) {
                    i2 += CodedOutputStreamMicro.computeInt32Size(7, getExtType());
                }
                this.f11714m = i2;
                return i2;
            }

            public String getSrcName() {
                return this.f11711j;
            }

            public boolean hasDetailInfo() {
                return this.f11702a;
            }

            public boolean hasExtType() {
                return this.f11712k;
            }

            public boolean hasImage() {
                return this.f11707f;
            }

            public boolean hasRichInfo() {
                return this.f11705d;
            }

            public boolean hasSrcName() {
                return this.f11710i;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Ext mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    MessageMicro detailInfo;
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            detailInfo = new DetailInfo();
                            codedInputStreamMicro.readMessage(detailInfo);
                            setDetailInfo(detailInfo);
                            continue;
                        case 18:
                            detailInfo = new Review();
                            codedInputStreamMicro.readMessage(detailInfo);
                            addReview(detailInfo);
                            continue;
                        case 26:
                            detailInfo = new RichInfo();
                            codedInputStreamMicro.readMessage(detailInfo);
                            setRichInfo(detailInfo);
                            continue;
                        case 34:
                            setSrcName(codedInputStreamMicro.readString());
                            continue;
                        case 42:
                            detailInfo = new Image();
                            codedInputStreamMicro.readMessage(detailInfo);
                            setImage(detailInfo);
                            continue;
                        case 50:
                            detailInfo = new LineInfo();
                            codedInputStreamMicro.readMessage(detailInfo);
                            addLineInfo(detailInfo);
                            continue;
                        case 56:
                            setExtType(codedInputStreamMicro.readInt32());
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

            public Ext setDetailInfo(DetailInfo detailInfo) {
                if (detailInfo == null) {
                    return clearDetailInfo();
                }
                this.f11702a = true;
                this.f11703b = detailInfo;
                return this;
            }

            public Ext setExtType(int i) {
                this.f11712k = true;
                this.f11713l = i;
                return this;
            }

            public Ext setImage(Image image) {
                if (image == null) {
                    return clearImage();
                }
                this.f11707f = true;
                this.f11708g = image;
                return this;
            }

            public Ext setLineInfo(int i, LineInfo lineInfo) {
                if (lineInfo != null) {
                    this.f11709h.set(i, lineInfo);
                }
                return this;
            }

            public Ext setReview(int i, Review review) {
                if (review != null) {
                    this.f11704c.set(i, review);
                }
                return this;
            }

            public Ext setRichInfo(RichInfo richInfo) {
                if (richInfo == null) {
                    return clearRichInfo();
                }
                this.f11705d = true;
                this.f11706e = richInfo;
                return this;
            }

            public Ext setSrcName(String str) {
                this.f11710i = true;
                this.f11711j = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasDetailInfo()) {
                    codedOutputStreamMicro.writeMessage(1, getDetailInfo());
                }
                for (Review writeMessage : getReviewList()) {
                    codedOutputStreamMicro.writeMessage(2, writeMessage);
                }
                if (hasRichInfo()) {
                    codedOutputStreamMicro.writeMessage(3, getRichInfo());
                }
                if (hasSrcName()) {
                    codedOutputStreamMicro.writeString(4, getSrcName());
                }
                if (hasImage()) {
                    codedOutputStreamMicro.writeMessage(5, getImage());
                }
                for (LineInfo writeMessage2 : getLineInfoList()) {
                    codedOutputStreamMicro.writeMessage(6, writeMessage2);
                }
                if (hasExtType()) {
                    codedOutputStreamMicro.writeInt32(7, getExtType());
                }
            }
        }

        public static final class HeadIcon extends MessageMicro {
            public static final int LINKS_FIELD_NUMBER = 3;
            public static final int PID_FIELD_NUMBER = 4;
            public static final int TYPE_FIELD_NUMBER = 2;
            public static final int URL_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f11715a;
            /* renamed from: b */
            private String f11716b = "";
            /* renamed from: c */
            private boolean f11717c;
            /* renamed from: d */
            private int f11718d = 0;
            /* renamed from: e */
            private boolean f11719e;
            /* renamed from: f */
            private String f11720f = "";
            /* renamed from: g */
            private boolean f11721g;
            /* renamed from: h */
            private String f11722h = "";
            /* renamed from: i */
            private int f11723i = -1;

            public static HeadIcon parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new HeadIcon().mergeFrom(codedInputStreamMicro);
            }

            public static HeadIcon parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (HeadIcon) new HeadIcon().mergeFrom(bArr);
            }

            public final HeadIcon clear() {
                clearUrl();
                clearType();
                clearLinks();
                clearPid();
                this.f11723i = -1;
                return this;
            }

            public HeadIcon clearLinks() {
                this.f11719e = false;
                this.f11720f = "";
                return this;
            }

            public HeadIcon clearPid() {
                this.f11721g = false;
                this.f11722h = "";
                return this;
            }

            public HeadIcon clearType() {
                this.f11717c = false;
                this.f11718d = 0;
                return this;
            }

            public HeadIcon clearUrl() {
                this.f11715a = false;
                this.f11716b = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f11723i < 0) {
                    getSerializedSize();
                }
                return this.f11723i;
            }

            public String getLinks() {
                return this.f11720f;
            }

            public String getPid() {
                return this.f11722h;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasUrl()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUrl());
                }
                if (hasType()) {
                    i += CodedOutputStreamMicro.computeInt32Size(2, getType());
                }
                if (hasLinks()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getLinks());
                }
                if (hasPid()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getPid());
                }
                this.f11723i = i;
                return i;
            }

            public int getType() {
                return this.f11718d;
            }

            public String getUrl() {
                return this.f11716b;
            }

            public boolean hasLinks() {
                return this.f11719e;
            }

            public boolean hasPid() {
                return this.f11721g;
            }

            public boolean hasType() {
                return this.f11717c;
            }

            public boolean hasUrl() {
                return this.f11715a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public HeadIcon mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setUrl(codedInputStreamMicro.readString());
                            continue;
                        case 16:
                            setType(codedInputStreamMicro.readInt32());
                            continue;
                        case 26:
                            setLinks(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setPid(codedInputStreamMicro.readString());
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

            public HeadIcon setLinks(String str) {
                this.f11719e = true;
                this.f11720f = str;
                return this;
            }

            public HeadIcon setPid(String str) {
                this.f11721g = true;
                this.f11722h = str;
                return this;
            }

            public HeadIcon setType(int i) {
                this.f11717c = true;
                this.f11718d = i;
                return this;
            }

            public HeadIcon setUrl(String str) {
                this.f11715a = true;
                this.f11716b = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasUrl()) {
                    codedOutputStreamMicro.writeString(1, getUrl());
                }
                if (hasType()) {
                    codedOutputStreamMicro.writeInt32(2, getType());
                }
                if (hasLinks()) {
                    codedOutputStreamMicro.writeString(3, getLinks());
                }
                if (hasPid()) {
                    codedOutputStreamMicro.writeString(4, getPid());
                }
            }
        }

        public static final class HeatMap extends MessageMicro {
            public static final int POINTS_FIELD_NUMBER = 2;
            public static final int RANKSTR_FIELD_NUMBER = 1;
            public static final int TYPE_FIELD_NUMBER = 3;
            /* renamed from: a */
            private boolean f11731a;
            /* renamed from: b */
            private Points f11732b = null;
            /* renamed from: c */
            private boolean f11733c;
            /* renamed from: d */
            private String f11734d = "";
            /* renamed from: e */
            private boolean f11735e;
            /* renamed from: f */
            private int f11736f = 0;
            /* renamed from: g */
            private int f11737g = -1;

            public static final class Points extends MessageMicro {
                public static final int BOUND_FIELD_NUMBER = 1;
                public static final int GEO_ELEMENTS_FIELD_NUMBER = 3;
                public static final int TYPE_FIELD_NUMBER = 2;
                /* renamed from: a */
                private List<Integer> f11726a = Collections.emptyList();
                /* renamed from: b */
                private boolean f11727b;
                /* renamed from: c */
                private int f11728c = 0;
                /* renamed from: d */
                private List<GeoElements> f11729d = Collections.emptyList();
                /* renamed from: e */
                private int f11730e = -1;

                public static final class GeoElements extends MessageMicro {
                    public static final int POINT_FIELD_NUMBER = 1;
                    /* renamed from: a */
                    private List<Integer> f11724a = Collections.emptyList();
                    /* renamed from: b */
                    private int f11725b = -1;

                    public static GeoElements parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new GeoElements().mergeFrom(codedInputStreamMicro);
                    }

                    public static GeoElements parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (GeoElements) new GeoElements().mergeFrom(bArr);
                    }

                    public GeoElements addPoint(int i) {
                        if (this.f11724a.isEmpty()) {
                            this.f11724a = new ArrayList();
                        }
                        this.f11724a.add(Integer.valueOf(i));
                        return this;
                    }

                    public final GeoElements clear() {
                        clearPoint();
                        this.f11725b = -1;
                        return this;
                    }

                    public GeoElements clearPoint() {
                        this.f11724a = Collections.emptyList();
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f11725b < 0) {
                            getSerializedSize();
                        }
                        return this.f11725b;
                    }

                    public int getPoint(int i) {
                        return ((Integer) this.f11724a.get(i)).intValue();
                    }

                    public int getPointCount() {
                        return this.f11724a.size();
                    }

                    public List<Integer> getPointList() {
                        return this.f11724a;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        for (Integer intValue : getPointList()) {
                            i = CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue()) + i;
                        }
                        int size = (0 + i) + (getPointList().size() * 1);
                        this.f11725b = size;
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
                                case 8:
                                    addPoint(codedInputStreamMicro.readSInt32());
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

                    public GeoElements setPoint(int i, int i2) {
                        this.f11724a.set(i, Integer.valueOf(i2));
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        for (Integer intValue : getPointList()) {
                            codedOutputStreamMicro.writeSInt32(1, intValue.intValue());
                        }
                    }
                }

                public static Points parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Points().mergeFrom(codedInputStreamMicro);
                }

                public static Points parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Points) new Points().mergeFrom(bArr);
                }

                public Points addBound(int i) {
                    if (this.f11726a.isEmpty()) {
                        this.f11726a = new ArrayList();
                    }
                    this.f11726a.add(Integer.valueOf(i));
                    return this;
                }

                public Points addGeoElements(GeoElements geoElements) {
                    if (geoElements != null) {
                        if (this.f11729d.isEmpty()) {
                            this.f11729d = new ArrayList();
                        }
                        this.f11729d.add(geoElements);
                    }
                    return this;
                }

                public final Points clear() {
                    clearBound();
                    clearType();
                    clearGeoElements();
                    this.f11730e = -1;
                    return this;
                }

                public Points clearBound() {
                    this.f11726a = Collections.emptyList();
                    return this;
                }

                public Points clearGeoElements() {
                    this.f11729d = Collections.emptyList();
                    return this;
                }

                public Points clearType() {
                    this.f11727b = false;
                    this.f11728c = 0;
                    return this;
                }

                public int getBound(int i) {
                    return ((Integer) this.f11726a.get(i)).intValue();
                }

                public int getBoundCount() {
                    return this.f11726a.size();
                }

                public List<Integer> getBoundList() {
                    return this.f11726a;
                }

                public int getCachedSize() {
                    if (this.f11730e < 0) {
                        getSerializedSize();
                    }
                    return this.f11730e;
                }

                public GeoElements getGeoElements(int i) {
                    return (GeoElements) this.f11729d.get(i);
                }

                public int getGeoElementsCount() {
                    return this.f11729d.size();
                }

                public List<GeoElements> getGeoElementsList() {
                    return this.f11729d;
                }

                public int getSerializedSize() {
                    int i = 0;
                    for (Integer intValue : getBoundList()) {
                        i = CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue()) + i;
                    }
                    int size = (0 + i) + (getBoundList().size() * 1);
                    if (hasType()) {
                        size += CodedOutputStreamMicro.computeInt32Size(2, getType());
                    }
                    i = size;
                    for (GeoElements computeMessageSize : getGeoElementsList()) {
                        i = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i;
                    }
                    this.f11730e = i;
                    return i;
                }

                public int getType() {
                    return this.f11728c;
                }

                public boolean hasType() {
                    return this.f11727b;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Points mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                addBound(codedInputStreamMicro.readSInt32());
                                continue;
                            case 16:
                                setType(codedInputStreamMicro.readInt32());
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

                public Points setBound(int i, int i2) {
                    this.f11726a.set(i, Integer.valueOf(i2));
                    return this;
                }

                public Points setGeoElements(int i, GeoElements geoElements) {
                    if (geoElements != null) {
                        this.f11729d.set(i, geoElements);
                    }
                    return this;
                }

                public Points setType(int i) {
                    this.f11727b = true;
                    this.f11728c = i;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    for (Integer intValue : getBoundList()) {
                        codedOutputStreamMicro.writeSInt32(1, intValue.intValue());
                    }
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(2, getType());
                    }
                    for (GeoElements writeMessage : getGeoElementsList()) {
                        codedOutputStreamMicro.writeMessage(3, writeMessage);
                    }
                }
            }

            public static HeatMap parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new HeatMap().mergeFrom(codedInputStreamMicro);
            }

            public static HeatMap parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (HeatMap) new HeatMap().mergeFrom(bArr);
            }

            public final HeatMap clear() {
                clearPoints();
                clearRankstr();
                clearType();
                this.f11737g = -1;
                return this;
            }

            public HeatMap clearPoints() {
                this.f11731a = false;
                this.f11732b = null;
                return this;
            }

            public HeatMap clearRankstr() {
                this.f11733c = false;
                this.f11734d = "";
                return this;
            }

            public HeatMap clearType() {
                this.f11735e = false;
                this.f11736f = 0;
                return this;
            }

            public int getCachedSize() {
                if (this.f11737g < 0) {
                    getSerializedSize();
                }
                return this.f11737g;
            }

            public Points getPoints() {
                return this.f11732b;
            }

            public String getRankstr() {
                return this.f11734d;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasRankstr()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getRankstr());
                }
                if (hasPoints()) {
                    i += CodedOutputStreamMicro.computeMessageSize(2, getPoints());
                }
                if (hasType()) {
                    i += CodedOutputStreamMicro.computeInt32Size(3, getType());
                }
                this.f11737g = i;
                return i;
            }

            public int getType() {
                return this.f11736f;
            }

            public boolean hasPoints() {
                return this.f11731a;
            }

            public boolean hasRankstr() {
                return this.f11733c;
            }

            public boolean hasType() {
                return this.f11735e;
            }

            public final boolean isInitialized() {
                return true;
            }

            public HeatMap mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setRankstr(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            MessageMicro points = new Points();
                            codedInputStreamMicro.readMessage(points);
                            setPoints(points);
                            continue;
                        case 24:
                            setType(codedInputStreamMicro.readInt32());
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

            public HeatMap setPoints(Points points) {
                if (points == null) {
                    return clearPoints();
                }
                this.f11731a = true;
                this.f11732b = points;
                return this;
            }

            public HeatMap setRankstr(String str) {
                this.f11733c = true;
                this.f11734d = str;
                return this;
            }

            public HeatMap setType(int i) {
                this.f11735e = true;
                this.f11736f = i;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasRankstr()) {
                    codedOutputStreamMicro.writeString(1, getRankstr());
                }
                if (hasPoints()) {
                    codedOutputStreamMicro.writeMessage(2, getPoints());
                }
                if (hasType()) {
                    codedOutputStreamMicro.writeInt32(3, getType());
                }
            }
        }

        public static final class OriginId extends MessageMicro {
            public static final int LBC_UID_FIELD_NUMBER = 1;
            public static final int OVERVIEW_GUID_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f11738a;
            /* renamed from: b */
            private String f11739b = "";
            /* renamed from: c */
            private boolean f11740c;
            /* renamed from: d */
            private String f11741d = "";
            /* renamed from: e */
            private int f11742e = -1;

            public static OriginId parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new OriginId().mergeFrom(codedInputStreamMicro);
            }

            public static OriginId parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (OriginId) new OriginId().mergeFrom(bArr);
            }

            public final OriginId clear() {
                clearLbcUid();
                clearOverviewGuid();
                this.f11742e = -1;
                return this;
            }

            public OriginId clearLbcUid() {
                this.f11738a = false;
                this.f11739b = "";
                return this;
            }

            public OriginId clearOverviewGuid() {
                this.f11740c = false;
                this.f11741d = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f11742e < 0) {
                    getSerializedSize();
                }
                return this.f11742e;
            }

            public String getLbcUid() {
                return this.f11739b;
            }

            public String getOverviewGuid() {
                return this.f11741d;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasLbcUid()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getLbcUid());
                }
                if (hasOverviewGuid()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getOverviewGuid());
                }
                this.f11742e = i;
                return i;
            }

            public boolean hasLbcUid() {
                return this.f11738a;
            }

            public boolean hasOverviewGuid() {
                return this.f11740c;
            }

            public final boolean isInitialized() {
                return true;
            }

            public OriginId mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setLbcUid(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setOverviewGuid(codedInputStreamMicro.readString());
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

            public OriginId setLbcUid(String str) {
                this.f11738a = true;
                this.f11739b = str;
                return this;
            }

            public OriginId setOverviewGuid(String str) {
                this.f11740c = true;
                this.f11741d = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasLbcUid()) {
                    codedOutputStreamMicro.writeString(1, getLbcUid());
                }
                if (hasOverviewGuid()) {
                    codedOutputStreamMicro.writeString(2, getOverviewGuid());
                }
            }
        }

        public static final class OtherStations extends MessageMicro {
            public static final int ADDR_FIELD_NUMBER = 2;
            public static final int ICON_ID_FIELD_NUMBER = 3;
            public static final int UID_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f11743a;
            /* renamed from: b */
            private String f11744b = "";
            /* renamed from: c */
            private boolean f11745c;
            /* renamed from: d */
            private String f11746d = "";
            /* renamed from: e */
            private boolean f11747e;
            /* renamed from: f */
            private int f11748f = 0;
            /* renamed from: g */
            private int f11749g = -1;

            public static OtherStations parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new OtherStations().mergeFrom(codedInputStreamMicro);
            }

            public static OtherStations parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (OtherStations) new OtherStations().mergeFrom(bArr);
            }

            public final OtherStations clear() {
                clearUid();
                clearAddr();
                clearIconId();
                this.f11749g = -1;
                return this;
            }

            public OtherStations clearAddr() {
                this.f11745c = false;
                this.f11746d = "";
                return this;
            }

            public OtherStations clearIconId() {
                this.f11747e = false;
                this.f11748f = 0;
                return this;
            }

            public OtherStations clearUid() {
                this.f11743a = false;
                this.f11744b = "";
                return this;
            }

            public String getAddr() {
                return this.f11746d;
            }

            public int getCachedSize() {
                if (this.f11749g < 0) {
                    getSerializedSize();
                }
                return this.f11749g;
            }

            public int getIconId() {
                return this.f11748f;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasUid()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUid());
                }
                if (hasAddr()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getAddr());
                }
                if (hasIconId()) {
                    i += CodedOutputStreamMicro.computeInt32Size(3, getIconId());
                }
                this.f11749g = i;
                return i;
            }

            public String getUid() {
                return this.f11744b;
            }

            public boolean hasAddr() {
                return this.f11745c;
            }

            public boolean hasIconId() {
                return this.f11747e;
            }

            public boolean hasUid() {
                return this.f11743a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public OtherStations mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setUid(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setAddr(codedInputStreamMicro.readString());
                            continue;
                        case 24:
                            setIconId(codedInputStreamMicro.readInt32());
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

            public OtherStations setAddr(String str) {
                this.f11745c = true;
                this.f11746d = str;
                return this;
            }

            public OtherStations setIconId(int i) {
                this.f11747e = true;
                this.f11748f = i;
                return this;
            }

            public OtherStations setUid(String str) {
                this.f11743a = true;
                this.f11744b = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(1, getUid());
                }
                if (hasAddr()) {
                    codedOutputStreamMicro.writeString(2, getAddr());
                }
                if (hasIconId()) {
                    codedOutputStreamMicro.writeInt32(3, getIconId());
                }
            }
        }

        public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Content().mergeFrom(codedInputStreamMicro);
        }

        public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Content) new Content().mergeFrom(bArr);
        }

        public Content addAlias(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f11761L.isEmpty()) {
                this.f11761L = new ArrayList();
            }
            this.f11761L.add(str);
            return this;
        }

        public Content addBlinfo(Blinfo blinfo) {
            if (blinfo != null) {
                if (this.f11778c.isEmpty()) {
                    this.f11778c = new ArrayList();
                }
                this.f11778c.add(blinfo);
            }
            return this;
        }

        public Content addOtherStations(OtherStations otherStations) {
            if (otherStations != null) {
                if (this.as.isEmpty()) {
                    this.as = new ArrayList();
                }
                this.as.add(otherStations);
            }
            return this;
        }

        public final Content clear() {
            clearExt();
            clearBlinfo();
            clearOriginId();
            clearHeatMap();
            clearAddr();
            clearCityId();
            clearExtType();
            clearGeo();
            clearName();
            clearPoiType();
            clearPrimaryUid();
            clearRpDesType();
            clearStatus();
            clearStorageSrc();
            clearSuspectedFlag();
            clearUid();
            clearArea();
            clearPhone();
            clearVista();
            clearAlias();
            clearAoi();
            clearCp();
            clearDetail();
            clearIndoorPano();
            clearNewCatalogId();
            clearPano();
            clearRpDes();
            clearStreetId();
            clearTag();
            clearTel();
            clearTy();
            clearRtbusUpdateTime();
            clearPoiTypeText();
            clearIndoorFloor();
            clearIndoorParentUid();
            clearCloudTemplate();
            clearOtherStations();
            clearIconId();
            clearStationNum();
            clearButton();
            clearIsmodified();
            clearDynamicclick();
            clearBarTemplate();
            clearStdTag();
            clearServiceTag();
            clearPhotoList();
            clearHeadIcon();
            clearIndoorOverLooking();
            this.aP = -1;
            return this;
        }

        public Content clearAddr() {
            this.f11783h = false;
            this.f11784i = "";
            return this;
        }

        public Content clearAlias() {
            this.f11761L = Collections.emptyList();
            return this;
        }

        public Content clearAoi() {
            this.f11762M = false;
            this.f11763N = "";
            return this;
        }

        public Content clearArea() {
            this.f11755F = false;
            this.f11756G = 0;
            return this;
        }

        public Content clearBarTemplate() {
            this.aD = false;
            this.aE = ByteStringMicro.EMPTY;
            return this;
        }

        public Content clearBlinfo() {
            this.f11778c = Collections.emptyList();
            return this;
        }

        public Content clearButton() {
            this.ax = false;
            this.ay = null;
            return this;
        }

        public Content clearCityId() {
            this.f11785j = false;
            this.f11786k = 0;
            return this;
        }

        public Content clearCloudTemplate() {
            this.aq = false;
            this.ar = ByteStringMicro.EMPTY;
            return this;
        }

        public Content clearCp() {
            this.f11764O = false;
            this.f11765P = "";
            return this;
        }

        public Content clearDetail() {
            this.f11766Q = false;
            this.f11767R = 0;
            return this;
        }

        public Content clearDynamicclick() {
            this.aB = false;
            this.aC = ByteStringMicro.EMPTY;
            return this;
        }

        public Content clearExt() {
            this.f11776a = false;
            this.f11777b = null;
            return this;
        }

        public Content clearExtType() {
            this.f11787l = false;
            this.f11788m = 0;
            return this;
        }

        public Content clearGeo() {
            this.f11789n = false;
            this.f11790o = "";
            return this;
        }

        public Content clearHeadIcon() {
            this.aL = false;
            this.aM = null;
            return this;
        }

        public Content clearHeatMap() {
            this.f11781f = false;
            this.f11782g = null;
            return this;
        }

        public Content clearIconId() {
            this.at = false;
            this.au = 0;
            return this;
        }

        public Content clearIndoorFloor() {
            this.am = false;
            this.an = "";
            return this;
        }

        public Content clearIndoorOverLooking() {
            this.aN = false;
            this.aO = 0;
            return this;
        }

        public Content clearIndoorPano() {
            this.f11768S = false;
            this.f11769T = "";
            return this;
        }

        public Content clearIndoorParentUid() {
            this.ao = false;
            this.ap = "";
            return this;
        }

        public Content clearIsmodified() {
            this.az = false;
            this.aA = 0;
            return this;
        }

        public Content clearName() {
            this.f11791p = false;
            this.f11792q = "";
            return this;
        }

        public Content clearNewCatalogId() {
            this.f11770U = false;
            this.f11771V = "";
            return this;
        }

        public Content clearOriginId() {
            this.f11779d = false;
            this.f11780e = null;
            return this;
        }

        public Content clearOtherStations() {
            this.as = Collections.emptyList();
            return this;
        }

        public Content clearPano() {
            this.f11772W = false;
            this.f11773X = 0;
            return this;
        }

        public Content clearPhone() {
            this.f11757H = false;
            this.f11758I = "";
            return this;
        }

        public Content clearPhotoList() {
            this.aJ = false;
            this.aK = "";
            return this;
        }

        public Content clearPoiType() {
            this.f11793r = false;
            this.f11794s = 0;
            return this;
        }

        public Content clearPoiTypeText() {
            this.ak = false;
            this.al = "";
            return this;
        }

        public Content clearPrimaryUid() {
            this.f11795t = false;
            this.f11796u = "";
            return this;
        }

        public Content clearRpDes() {
            this.f11774Y = false;
            this.f11775Z = "";
            return this;
        }

        public Content clearRpDesType() {
            this.f11797v = false;
            this.f11798w = 0;
            return this;
        }

        public Content clearRtbusUpdateTime() {
            this.ai = false;
            this.aj = 0;
            return this;
        }

        public Content clearServiceTag() {
            this.aH = false;
            this.aI = "";
            return this;
        }

        public Content clearStationNum() {
            this.av = false;
            this.aw = "";
            return this;
        }

        public Content clearStatus() {
            this.f11799x = false;
            this.f11800y = 0;
            return this;
        }

        public Content clearStdTag() {
            this.aF = false;
            this.aG = "";
            return this;
        }

        public Content clearStorageSrc() {
            this.f11801z = false;
            this.f11750A = "";
            return this;
        }

        public Content clearStreetId() {
            this.aa = false;
            this.ab = "";
            return this;
        }

        public Content clearSuspectedFlag() {
            this.f11751B = false;
            this.f11752C = 0;
            return this;
        }

        public Content clearTag() {
            this.ac = false;
            this.ad = "";
            return this;
        }

        public Content clearTel() {
            this.ae = false;
            this.af = "";
            return this;
        }

        public Content clearTy() {
            this.ag = false;
            this.ah = 0;
            return this;
        }

        public Content clearUid() {
            this.f11753D = false;
            this.f11754E = "";
            return this;
        }

        public Content clearVista() {
            this.f11759J = false;
            this.f11760K = "";
            return this;
        }

        public String getAddr() {
            return this.f11784i;
        }

        public String getAlias(int i) {
            return (String) this.f11761L.get(i);
        }

        public int getAliasCount() {
            return this.f11761L.size();
        }

        public List<String> getAliasList() {
            return this.f11761L;
        }

        public String getAoi() {
            return this.f11763N;
        }

        public int getArea() {
            return this.f11756G;
        }

        public ByteStringMicro getBarTemplate() {
            return this.aE;
        }

        public Blinfo getBlinfo(int i) {
            return (Blinfo) this.f11778c.get(i);
        }

        public int getBlinfoCount() {
            return this.f11778c.size();
        }

        public List<Blinfo> getBlinfoList() {
            return this.f11778c;
        }

        public Button getButton() {
            return this.ay;
        }

        public int getCachedSize() {
            if (this.aP < 0) {
                getSerializedSize();
            }
            return this.aP;
        }

        public int getCityId() {
            return this.f11786k;
        }

        public ByteStringMicro getCloudTemplate() {
            return this.ar;
        }

        public String getCp() {
            return this.f11765P;
        }

        public int getDetail() {
            return this.f11767R;
        }

        public ByteStringMicro getDynamicclick() {
            return this.aC;
        }

        public Ext getExt() {
            return this.f11777b;
        }

        public int getExtType() {
            return this.f11788m;
        }

        public String getGeo() {
            return this.f11790o;
        }

        public HeadIcon getHeadIcon() {
            return this.aM;
        }

        public HeatMap getHeatMap() {
            return this.f11782g;
        }

        public int getIconId() {
            return this.au;
        }

        public String getIndoorFloor() {
            return this.an;
        }

        public int getIndoorOverLooking() {
            return this.aO;
        }

        public String getIndoorPano() {
            return this.f11769T;
        }

        public String getIndoorParentUid() {
            return this.ap;
        }

        public int getIsmodified() {
            return this.aA;
        }

        public String getName() {
            return this.f11792q;
        }

        public String getNewCatalogId() {
            return this.f11771V;
        }

        public OriginId getOriginId() {
            return this.f11780e;
        }

        public OtherStations getOtherStations(int i) {
            return (OtherStations) this.as.get(i);
        }

        public int getOtherStationsCount() {
            return this.as.size();
        }

        public List<OtherStations> getOtherStationsList() {
            return this.as;
        }

        public int getPano() {
            return this.f11773X;
        }

        public String getPhone() {
            return this.f11758I;
        }

        public String getPhotoList() {
            return this.aK;
        }

        public int getPoiType() {
            return this.f11794s;
        }

        public String getPoiTypeText() {
            return this.al;
        }

        public String getPrimaryUid() {
            return this.f11796u;
        }

        public String getRpDes() {
            return this.f11775Z;
        }

        public int getRpDesType() {
            return this.f11798w;
        }

        public int getRtbusUpdateTime() {
            return this.aj;
        }

        public int getSerializedSize() {
            int i = 0;
            int computeStringSize = hasAddr() ? CodedOutputStreamMicro.computeStringSize(1, getAddr()) + 0 : 0;
            if (hasCityId()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getCityId());
            }
            if (hasExt()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(3, getExt());
            }
            if (hasExtType()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, getExtType());
            }
            if (hasGeo()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getGeo());
            }
            if (hasName()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(6, getName());
            }
            if (hasPoiType()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(7, getPoiType());
            }
            if (hasPrimaryUid()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(8, getPrimaryUid());
            }
            if (hasRpDesType()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(9, getRpDesType());
            }
            if (hasStatus()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(10, getStatus());
            }
            if (hasStorageSrc()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(11, getStorageSrc());
            }
            if (hasSuspectedFlag()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(12, getSuspectedFlag());
            }
            if (hasUid()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(13, getUid());
            }
            if (hasArea()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(14, getArea());
            }
            if (hasPhone()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(15, getPhone());
            }
            if (hasVista()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(16, getVista());
            }
            int i2 = computeStringSize;
            for (Blinfo computeMessageSize : getBlinfoList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(17, computeMessageSize) + i2;
            }
            for (String computeStringSizeNoTag : getAliasList()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag);
            }
            computeStringSize = (i2 + i) + (getAliasList().size() * 2);
            if (hasAoi()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(19, getAoi());
            }
            if (hasCp()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(20, getCp());
            }
            if (hasDetail()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(21, getDetail());
            }
            if (hasIndoorPano()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(22, getIndoorPano());
            }
            if (hasNewCatalogId()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(23, getNewCatalogId());
            }
            if (hasOriginId()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(24, getOriginId());
            }
            if (hasPano()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(25, getPano());
            }
            if (hasRpDes()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(26, getRpDes());
            }
            if (hasStreetId()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(27, getStreetId());
            }
            if (hasTag()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(28, getTag());
            }
            if (hasTel()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(29, getTel());
            }
            if (hasTy()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(30, getTy());
            }
            if (hasRtbusUpdateTime()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(31, getRtbusUpdateTime());
            }
            if (hasPoiTypeText()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(32, getPoiTypeText());
            }
            if (hasHeatMap()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(33, getHeatMap());
            }
            if (hasIndoorFloor()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(36, getIndoorFloor());
            }
            if (hasIndoorParentUid()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(37, getIndoorParentUid());
            }
            if (hasCloudTemplate()) {
                computeStringSize += CodedOutputStreamMicro.computeBytesSize(38, getCloudTemplate());
            }
            i = computeStringSize;
            for (OtherStations computeMessageSize2 : getOtherStationsList()) {
                i = CodedOutputStreamMicro.computeMessageSize(39, computeMessageSize2) + i;
            }
            if (hasIconId()) {
                i += CodedOutputStreamMicro.computeInt32Size(40, getIconId());
            }
            if (hasStationNum()) {
                i += CodedOutputStreamMicro.computeStringSize(41, getStationNum());
            }
            if (hasButton()) {
                i += CodedOutputStreamMicro.computeMessageSize(42, getButton());
            }
            if (hasIsmodified()) {
                i += CodedOutputStreamMicro.computeInt32Size(44, getIsmodified());
            }
            if (hasDynamicclick()) {
                i += CodedOutputStreamMicro.computeBytesSize(45, getDynamicclick());
            }
            if (hasBarTemplate()) {
                i += CodedOutputStreamMicro.computeBytesSize(46, getBarTemplate());
            }
            if (hasStdTag()) {
                i += CodedOutputStreamMicro.computeStringSize(47, getStdTag());
            }
            if (hasServiceTag()) {
                i += CodedOutputStreamMicro.computeStringSize(48, getServiceTag());
            }
            if (hasPhotoList()) {
                i += CodedOutputStreamMicro.computeStringSize(49, getPhotoList());
            }
            if (hasHeadIcon()) {
                i += CodedOutputStreamMicro.computeMessageSize(50, getHeadIcon());
            }
            if (hasIndoorOverLooking()) {
                i += CodedOutputStreamMicro.computeInt32Size(51, getIndoorOverLooking());
            }
            this.aP = i;
            return i;
        }

        public String getServiceTag() {
            return this.aI;
        }

        public String getStationNum() {
            return this.aw;
        }

        public int getStatus() {
            return this.f11800y;
        }

        public String getStdTag() {
            return this.aG;
        }

        public String getStorageSrc() {
            return this.f11750A;
        }

        public String getStreetId() {
            return this.ab;
        }

        public int getSuspectedFlag() {
            return this.f11752C;
        }

        public String getTag() {
            return this.ad;
        }

        public String getTel() {
            return this.af;
        }

        public int getTy() {
            return this.ah;
        }

        public String getUid() {
            return this.f11754E;
        }

        public String getVista() {
            return this.f11760K;
        }

        public boolean hasAddr() {
            return this.f11783h;
        }

        public boolean hasAoi() {
            return this.f11762M;
        }

        public boolean hasArea() {
            return this.f11755F;
        }

        public boolean hasBarTemplate() {
            return this.aD;
        }

        public boolean hasButton() {
            return this.ax;
        }

        public boolean hasCityId() {
            return this.f11785j;
        }

        public boolean hasCloudTemplate() {
            return this.aq;
        }

        public boolean hasCp() {
            return this.f11764O;
        }

        public boolean hasDetail() {
            return this.f11766Q;
        }

        public boolean hasDynamicclick() {
            return this.aB;
        }

        public boolean hasExt() {
            return this.f11776a;
        }

        public boolean hasExtType() {
            return this.f11787l;
        }

        public boolean hasGeo() {
            return this.f11789n;
        }

        public boolean hasHeadIcon() {
            return this.aL;
        }

        public boolean hasHeatMap() {
            return this.f11781f;
        }

        public boolean hasIconId() {
            return this.at;
        }

        public boolean hasIndoorFloor() {
            return this.am;
        }

        public boolean hasIndoorOverLooking() {
            return this.aN;
        }

        public boolean hasIndoorPano() {
            return this.f11768S;
        }

        public boolean hasIndoorParentUid() {
            return this.ao;
        }

        public boolean hasIsmodified() {
            return this.az;
        }

        public boolean hasName() {
            return this.f11791p;
        }

        public boolean hasNewCatalogId() {
            return this.f11770U;
        }

        public boolean hasOriginId() {
            return this.f11779d;
        }

        public boolean hasPano() {
            return this.f11772W;
        }

        public boolean hasPhone() {
            return this.f11757H;
        }

        public boolean hasPhotoList() {
            return this.aJ;
        }

        public boolean hasPoiType() {
            return this.f11793r;
        }

        public boolean hasPoiTypeText() {
            return this.ak;
        }

        public boolean hasPrimaryUid() {
            return this.f11795t;
        }

        public boolean hasRpDes() {
            return this.f11774Y;
        }

        public boolean hasRpDesType() {
            return this.f11797v;
        }

        public boolean hasRtbusUpdateTime() {
            return this.ai;
        }

        public boolean hasServiceTag() {
            return this.aH;
        }

        public boolean hasStationNum() {
            return this.av;
        }

        public boolean hasStatus() {
            return this.f11799x;
        }

        public boolean hasStdTag() {
            return this.aF;
        }

        public boolean hasStorageSrc() {
            return this.f11801z;
        }

        public boolean hasStreetId() {
            return this.aa;
        }

        public boolean hasSuspectedFlag() {
            return this.f11751B;
        }

        public boolean hasTag() {
            return this.ac;
        }

        public boolean hasTel() {
            return this.ae;
        }

        public boolean hasTy() {
            return this.ag;
        }

        public boolean hasUid() {
            return this.f11753D;
        }

        public boolean hasVista() {
            return this.f11759J;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Content mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro ext;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setAddr(codedInputStreamMicro.readString());
                        continue;
                    case 16:
                        setCityId(codedInputStreamMicro.readInt32());
                        continue;
                    case 26:
                        ext = new Ext();
                        codedInputStreamMicro.readMessage(ext);
                        setExt(ext);
                        continue;
                    case 32:
                        setExtType(codedInputStreamMicro.readInt32());
                        continue;
                    case 42:
                        setGeo(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setName(codedInputStreamMicro.readString());
                        continue;
                    case 56:
                        setPoiType(codedInputStreamMicro.readInt32());
                        continue;
                    case 66:
                        setPrimaryUid(codedInputStreamMicro.readString());
                        continue;
                    case NavCarInfo.CarType_57L /*72*/:
                        setRpDesType(codedInputStreamMicro.readInt32());
                        continue;
                    case 80:
                        setStatus(codedInputStreamMicro.readInt32());
                        continue;
                    case 90:
                        setStorageSrc(codedInputStreamMicro.readString());
                        continue;
                    case 96:
                        setSuspectedFlag(codedInputStreamMicro.readInt32());
                        continue;
                    case 106:
                        setUid(codedInputStreamMicro.readString());
                        continue;
                    case 112:
                        setArea(codedInputStreamMicro.readInt32());
                        continue;
                    case C1253f.df /*122*/:
                        setPhone(codedInputStreamMicro.readString());
                        continue;
                    case 130:
                        setVista(codedInputStreamMicro.readString());
                        continue;
                    case 138:
                        ext = new Blinfo();
                        codedInputStreamMicro.readMessage(ext);
                        addBlinfo(ext);
                        continue;
                    case 146:
                        addAlias(codedInputStreamMicro.readString());
                        continue;
                    case 154:
                        setAoi(codedInputStreamMicro.readString());
                        continue;
                    case 162:
                        setCp(codedInputStreamMicro.readString());
                        continue;
                    case 168:
                        setDetail(codedInputStreamMicro.readInt32());
                        continue;
                    case 178:
                        setIndoorPano(codedInputStreamMicro.readString());
                        continue;
                    case 186:
                        setNewCatalogId(codedInputStreamMicro.readString());
                        continue;
                    case RouteLineResConst.LINE_INTERNAL_NORMAL /*194*/:
                        ext = new OriginId();
                        codedInputStreamMicro.readMessage(ext);
                        setOriginId(ext);
                        continue;
                    case 200:
                        setPano(codedInputStreamMicro.readInt32());
                        continue;
                    case C1253f.ds /*210*/:
                        setRpDes(codedInputStreamMicro.readString());
                        continue;
                    case 218:
                        setStreetId(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.dG /*226*/:
                        setTag(codedInputStreamMicro.readString());
                        continue;
                    case NaviCmdConstants.ACTION_TYPE_NAVI_TTS_MODE_EXPERT /*234*/:
                        setTel(codedInputStreamMicro.readString());
                        continue;
                    case RGHUDDataModel.MAX_CAR_SPEED /*240*/:
                        setTy(codedInputStreamMicro.readInt32());
                        continue;
                    case C1253f.dQ /*248*/:
                        setRtbusUpdateTime(codedInputStreamMicro.readInt32());
                        continue;
                    case 258:
                        setPoiTypeText(codedInputStreamMicro.readString());
                        continue;
                    case BNOfflineDataObserver.EVENT_UPDATE_PROGRESS /*266*/:
                        ext = new HeatMap();
                        codedInputStreamMicro.readMessage(ext);
                        setHeatMap(ext);
                        continue;
                    case 290:
                        setIndoorFloor(codedInputStreamMicro.readString());
                        continue;
                    case 298:
                        setIndoorParentUid(codedInputStreamMicro.readString());
                        continue;
                    case 306:
                        setCloudTemplate(codedInputStreamMicro.readBytes());
                        continue;
                    case C1253f.eb /*314*/:
                        ext = new OtherStations();
                        codedInputStreamMicro.readMessage(ext);
                        addOtherStations(ext);
                        continue;
                    case NaviFragmentManager.TYPE_VOICE_MAIN /*320*/:
                        setIconId(codedInputStreamMicro.readInt32());
                        continue;
                    case 330:
                        setStationNum(codedInputStreamMicro.readString());
                        continue;
                    case 338:
                        ext = new Button();
                        codedInputStreamMicro.readMessage(ext);
                        setButton(ext);
                        continue;
                    case 352:
                        setIsmodified(codedInputStreamMicro.readInt32());
                        continue;
                    case 362:
                        setDynamicclick(codedInputStreamMicro.readBytes());
                        continue;
                    case 370:
                        setBarTemplate(codedInputStreamMicro.readBytes());
                        continue;
                    case 378:
                        setStdTag(codedInputStreamMicro.readString());
                        continue;
                    case 386:
                        setServiceTag(codedInputStreamMicro.readString());
                        continue;
                    case 394:
                        setPhotoList(codedInputStreamMicro.readString());
                        continue;
                    case 402:
                        ext = new HeadIcon();
                        codedInputStreamMicro.readMessage(ext);
                        setHeadIcon(ext);
                        continue;
                    case 408:
                        setIndoorOverLooking(codedInputStreamMicro.readInt32());
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

        public Content setAddr(String str) {
            this.f11783h = true;
            this.f11784i = str;
            return this;
        }

        public Content setAlias(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f11761L.set(i, str);
            return this;
        }

        public Content setAoi(String str) {
            this.f11762M = true;
            this.f11763N = str;
            return this;
        }

        public Content setArea(int i) {
            this.f11755F = true;
            this.f11756G = i;
            return this;
        }

        public Content setBarTemplate(ByteStringMicro byteStringMicro) {
            this.aD = true;
            this.aE = byteStringMicro;
            return this;
        }

        public Content setBlinfo(int i, Blinfo blinfo) {
            if (blinfo != null) {
                this.f11778c.set(i, blinfo);
            }
            return this;
        }

        public Content setButton(Button button) {
            if (button == null) {
                return clearButton();
            }
            this.ax = true;
            this.ay = button;
            return this;
        }

        public Content setCityId(int i) {
            this.f11785j = true;
            this.f11786k = i;
            return this;
        }

        public Content setCloudTemplate(ByteStringMicro byteStringMicro) {
            this.aq = true;
            this.ar = byteStringMicro;
            return this;
        }

        public Content setCp(String str) {
            this.f11764O = true;
            this.f11765P = str;
            return this;
        }

        public Content setDetail(int i) {
            this.f11766Q = true;
            this.f11767R = i;
            return this;
        }

        public Content setDynamicclick(ByteStringMicro byteStringMicro) {
            this.aB = true;
            this.aC = byteStringMicro;
            return this;
        }

        public Content setExt(Ext ext) {
            if (ext == null) {
                return clearExt();
            }
            this.f11776a = true;
            this.f11777b = ext;
            return this;
        }

        public Content setExtType(int i) {
            this.f11787l = true;
            this.f11788m = i;
            return this;
        }

        public Content setGeo(String str) {
            this.f11789n = true;
            this.f11790o = str;
            return this;
        }

        public Content setHeadIcon(HeadIcon headIcon) {
            if (headIcon == null) {
                return clearHeadIcon();
            }
            this.aL = true;
            this.aM = headIcon;
            return this;
        }

        public Content setHeatMap(HeatMap heatMap) {
            if (heatMap == null) {
                return clearHeatMap();
            }
            this.f11781f = true;
            this.f11782g = heatMap;
            return this;
        }

        public Content setIconId(int i) {
            this.at = true;
            this.au = i;
            return this;
        }

        public Content setIndoorFloor(String str) {
            this.am = true;
            this.an = str;
            return this;
        }

        public Content setIndoorOverLooking(int i) {
            this.aN = true;
            this.aO = i;
            return this;
        }

        public Content setIndoorPano(String str) {
            this.f11768S = true;
            this.f11769T = str;
            return this;
        }

        public Content setIndoorParentUid(String str) {
            this.ao = true;
            this.ap = str;
            return this;
        }

        public Content setIsmodified(int i) {
            this.az = true;
            this.aA = i;
            return this;
        }

        public Content setName(String str) {
            this.f11791p = true;
            this.f11792q = str;
            return this;
        }

        public Content setNewCatalogId(String str) {
            this.f11770U = true;
            this.f11771V = str;
            return this;
        }

        public Content setOriginId(OriginId originId) {
            if (originId == null) {
                return clearOriginId();
            }
            this.f11779d = true;
            this.f11780e = originId;
            return this;
        }

        public Content setOtherStations(int i, OtherStations otherStations) {
            if (otherStations != null) {
                this.as.set(i, otherStations);
            }
            return this;
        }

        public Content setPano(int i) {
            this.f11772W = true;
            this.f11773X = i;
            return this;
        }

        public Content setPhone(String str) {
            this.f11757H = true;
            this.f11758I = str;
            return this;
        }

        public Content setPhotoList(String str) {
            this.aJ = true;
            this.aK = str;
            return this;
        }

        public Content setPoiType(int i) {
            this.f11793r = true;
            this.f11794s = i;
            return this;
        }

        public Content setPoiTypeText(String str) {
            this.ak = true;
            this.al = str;
            return this;
        }

        public Content setPrimaryUid(String str) {
            this.f11795t = true;
            this.f11796u = str;
            return this;
        }

        public Content setRpDes(String str) {
            this.f11774Y = true;
            this.f11775Z = str;
            return this;
        }

        public Content setRpDesType(int i) {
            this.f11797v = true;
            this.f11798w = i;
            return this;
        }

        public Content setRtbusUpdateTime(int i) {
            this.ai = true;
            this.aj = i;
            return this;
        }

        public Content setServiceTag(String str) {
            this.aH = true;
            this.aI = str;
            return this;
        }

        public Content setStationNum(String str) {
            this.av = true;
            this.aw = str;
            return this;
        }

        public Content setStatus(int i) {
            this.f11799x = true;
            this.f11800y = i;
            return this;
        }

        public Content setStdTag(String str) {
            this.aF = true;
            this.aG = str;
            return this;
        }

        public Content setStorageSrc(String str) {
            this.f11801z = true;
            this.f11750A = str;
            return this;
        }

        public Content setStreetId(String str) {
            this.aa = true;
            this.ab = str;
            return this;
        }

        public Content setSuspectedFlag(int i) {
            this.f11751B = true;
            this.f11752C = i;
            return this;
        }

        public Content setTag(String str) {
            this.ac = true;
            this.ad = str;
            return this;
        }

        public Content setTel(String str) {
            this.ae = true;
            this.af = str;
            return this;
        }

        public Content setTy(int i) {
            this.ag = true;
            this.ah = i;
            return this;
        }

        public Content setUid(String str) {
            this.f11753D = true;
            this.f11754E = str;
            return this;
        }

        public Content setVista(String str) {
            this.f11759J = true;
            this.f11760K = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasAddr()) {
                codedOutputStreamMicro.writeString(1, getAddr());
            }
            if (hasCityId()) {
                codedOutputStreamMicro.writeInt32(2, getCityId());
            }
            if (hasExt()) {
                codedOutputStreamMicro.writeMessage(3, getExt());
            }
            if (hasExtType()) {
                codedOutputStreamMicro.writeInt32(4, getExtType());
            }
            if (hasGeo()) {
                codedOutputStreamMicro.writeString(5, getGeo());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(6, getName());
            }
            if (hasPoiType()) {
                codedOutputStreamMicro.writeInt32(7, getPoiType());
            }
            if (hasPrimaryUid()) {
                codedOutputStreamMicro.writeString(8, getPrimaryUid());
            }
            if (hasRpDesType()) {
                codedOutputStreamMicro.writeInt32(9, getRpDesType());
            }
            if (hasStatus()) {
                codedOutputStreamMicro.writeInt32(10, getStatus());
            }
            if (hasStorageSrc()) {
                codedOutputStreamMicro.writeString(11, getStorageSrc());
            }
            if (hasSuspectedFlag()) {
                codedOutputStreamMicro.writeInt32(12, getSuspectedFlag());
            }
            if (hasUid()) {
                codedOutputStreamMicro.writeString(13, getUid());
            }
            if (hasArea()) {
                codedOutputStreamMicro.writeInt32(14, getArea());
            }
            if (hasPhone()) {
                codedOutputStreamMicro.writeString(15, getPhone());
            }
            if (hasVista()) {
                codedOutputStreamMicro.writeString(16, getVista());
            }
            for (Blinfo writeMessage : getBlinfoList()) {
                codedOutputStreamMicro.writeMessage(17, writeMessage);
            }
            for (String writeString : getAliasList()) {
                codedOutputStreamMicro.writeString(18, writeString);
            }
            if (hasAoi()) {
                codedOutputStreamMicro.writeString(19, getAoi());
            }
            if (hasCp()) {
                codedOutputStreamMicro.writeString(20, getCp());
            }
            if (hasDetail()) {
                codedOutputStreamMicro.writeInt32(21, getDetail());
            }
            if (hasIndoorPano()) {
                codedOutputStreamMicro.writeString(22, getIndoorPano());
            }
            if (hasNewCatalogId()) {
                codedOutputStreamMicro.writeString(23, getNewCatalogId());
            }
            if (hasOriginId()) {
                codedOutputStreamMicro.writeMessage(24, getOriginId());
            }
            if (hasPano()) {
                codedOutputStreamMicro.writeInt32(25, getPano());
            }
            if (hasRpDes()) {
                codedOutputStreamMicro.writeString(26, getRpDes());
            }
            if (hasStreetId()) {
                codedOutputStreamMicro.writeString(27, getStreetId());
            }
            if (hasTag()) {
                codedOutputStreamMicro.writeString(28, getTag());
            }
            if (hasTel()) {
                codedOutputStreamMicro.writeString(29, getTel());
            }
            if (hasTy()) {
                codedOutputStreamMicro.writeInt32(30, getTy());
            }
            if (hasRtbusUpdateTime()) {
                codedOutputStreamMicro.writeInt32(31, getRtbusUpdateTime());
            }
            if (hasPoiTypeText()) {
                codedOutputStreamMicro.writeString(32, getPoiTypeText());
            }
            if (hasHeatMap()) {
                codedOutputStreamMicro.writeMessage(33, getHeatMap());
            }
            if (hasIndoorFloor()) {
                codedOutputStreamMicro.writeString(36, getIndoorFloor());
            }
            if (hasIndoorParentUid()) {
                codedOutputStreamMicro.writeString(37, getIndoorParentUid());
            }
            if (hasCloudTemplate()) {
                codedOutputStreamMicro.writeBytes(38, getCloudTemplate());
            }
            for (OtherStations writeMessage2 : getOtherStationsList()) {
                codedOutputStreamMicro.writeMessage(39, writeMessage2);
            }
            if (hasIconId()) {
                codedOutputStreamMicro.writeInt32(40, getIconId());
            }
            if (hasStationNum()) {
                codedOutputStreamMicro.writeString(41, getStationNum());
            }
            if (hasButton()) {
                codedOutputStreamMicro.writeMessage(42, getButton());
            }
            if (hasIsmodified()) {
                codedOutputStreamMicro.writeInt32(44, getIsmodified());
            }
            if (hasDynamicclick()) {
                codedOutputStreamMicro.writeBytes(45, getDynamicclick());
            }
            if (hasBarTemplate()) {
                codedOutputStreamMicro.writeBytes(46, getBarTemplate());
            }
            if (hasStdTag()) {
                codedOutputStreamMicro.writeString(47, getStdTag());
            }
            if (hasServiceTag()) {
                codedOutputStreamMicro.writeString(48, getServiceTag());
            }
            if (hasPhotoList()) {
                codedOutputStreamMicro.writeString(49, getPhotoList());
            }
            if (hasHeadIcon()) {
                codedOutputStreamMicro.writeMessage(50, getHeadIcon());
            }
            if (hasIndoorOverLooking()) {
                codedOutputStreamMicro.writeInt32(51, getIndoorOverLooking());
            }
        }
    }

    public static final class Option extends MessageMicro {
        public static final int CHANNEL_FIELD_NUMBER = 3;
        public static final int CLIENTSV_FIELD_NUMBER = 4;
        public static final int HAS_RTBUS_FIELD_NUMBER = 1;
        public static final int IM_FIELD_NUMBER = 5;
        public static final int LDATA_FIELD_NUMBER = 14;
        public static final int MB_FIELD_NUMBER = 6;
        public static final int NEWMAP_FIELD_NUMBER = 7;
        public static final int OS_FIELD_NUMBER = 8;
        public static final int QID_FIELD_NUMBER = 2;
        public static final int QT_FIELD_NUMBER = 9;
        public static final int REGION_TYPE_FIELD_NUMBER = 15;
        public static final int RESID_FIELD_NUMBER = 10;
        public static final int SV_FIELD_NUMBER = 11;
        public static final int TIME_FIELD_NUMBER = 12;
        public static final int WD_FIELD_NUMBER = 13;
        /* renamed from: A */
        private boolean f11802A;
        /* renamed from: B */
        private String f11803B = "";
        /* renamed from: C */
        private boolean f11804C;
        /* renamed from: D */
        private String f11805D = "";
        /* renamed from: E */
        private int f11806E = -1;
        /* renamed from: a */
        private boolean f11807a;
        /* renamed from: b */
        private int f11808b = 0;
        /* renamed from: c */
        private boolean f11809c;
        /* renamed from: d */
        private String f11810d = "";
        /* renamed from: e */
        private boolean f11811e;
        /* renamed from: f */
        private String f11812f = "";
        /* renamed from: g */
        private boolean f11813g;
        /* renamed from: h */
        private String f11814h = "";
        /* renamed from: i */
        private boolean f11815i;
        /* renamed from: j */
        private String f11816j = "";
        /* renamed from: k */
        private boolean f11817k;
        /* renamed from: l */
        private String f11818l = "";
        /* renamed from: m */
        private boolean f11819m;
        /* renamed from: n */
        private String f11820n = "";
        /* renamed from: o */
        private boolean f11821o;
        /* renamed from: p */
        private String f11822p = "";
        /* renamed from: q */
        private boolean f11823q;
        /* renamed from: r */
        private String f11824r = "";
        /* renamed from: s */
        private boolean f11825s;
        /* renamed from: t */
        private String f11826t = "";
        /* renamed from: u */
        private boolean f11827u;
        /* renamed from: v */
        private String f11828v = "";
        /* renamed from: w */
        private boolean f11829w;
        /* renamed from: x */
        private int f11830x = 0;
        /* renamed from: y */
        private boolean f11831y;
        /* renamed from: z */
        private String f11832z = "";

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }

        public final Option clear() {
            clearHasRtbus();
            clearQid();
            clearChannel();
            clearClientsv();
            clearIm();
            clearMb();
            clearNewmap();
            clearOs();
            clearQt();
            clearResid();
            clearSv();
            clearTime();
            clearWd();
            clearLdata();
            clearRegionType();
            this.f11806E = -1;
            return this;
        }

        public Option clearChannel() {
            this.f11811e = false;
            this.f11812f = "";
            return this;
        }

        public Option clearClientsv() {
            this.f11813g = false;
            this.f11814h = "";
            return this;
        }

        public Option clearHasRtbus() {
            this.f11807a = false;
            this.f11808b = 0;
            return this;
        }

        public Option clearIm() {
            this.f11815i = false;
            this.f11816j = "";
            return this;
        }

        public Option clearLdata() {
            this.f11802A = false;
            this.f11803B = "";
            return this;
        }

        public Option clearMb() {
            this.f11817k = false;
            this.f11818l = "";
            return this;
        }

        public Option clearNewmap() {
            this.f11819m = false;
            this.f11820n = "";
            return this;
        }

        public Option clearOs() {
            this.f11821o = false;
            this.f11822p = "";
            return this;
        }

        public Option clearQid() {
            this.f11809c = false;
            this.f11810d = "";
            return this;
        }

        public Option clearQt() {
            this.f11823q = false;
            this.f11824r = "";
            return this;
        }

        public Option clearRegionType() {
            this.f11804C = false;
            this.f11805D = "";
            return this;
        }

        public Option clearResid() {
            this.f11825s = false;
            this.f11826t = "";
            return this;
        }

        public Option clearSv() {
            this.f11827u = false;
            this.f11828v = "";
            return this;
        }

        public Option clearTime() {
            this.f11829w = false;
            this.f11830x = 0;
            return this;
        }

        public Option clearWd() {
            this.f11831y = false;
            this.f11832z = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f11806E < 0) {
                getSerializedSize();
            }
            return this.f11806E;
        }

        public String getChannel() {
            return this.f11812f;
        }

        public String getClientsv() {
            return this.f11814h;
        }

        public int getHasRtbus() {
            return this.f11808b;
        }

        public String getIm() {
            return this.f11816j;
        }

        public String getLdata() {
            return this.f11803B;
        }

        public String getMb() {
            return this.f11818l;
        }

        public String getNewmap() {
            return this.f11820n;
        }

        public String getOs() {
            return this.f11822p;
        }

        public String getQid() {
            return this.f11810d;
        }

        public String getQt() {
            return this.f11824r;
        }

        public String getRegionType() {
            return this.f11805D;
        }

        public String getResid() {
            return this.f11826t;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasHasRtbus()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getHasRtbus());
            }
            if (hasQid()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getQid());
            }
            if (hasChannel()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getChannel());
            }
            if (hasClientsv()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getClientsv());
            }
            if (hasIm()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getIm());
            }
            if (hasMb()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getMb());
            }
            if (hasNewmap()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getNewmap());
            }
            if (hasOs()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getOs());
            }
            if (hasQt()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getQt());
            }
            if (hasResid()) {
                i += CodedOutputStreamMicro.computeStringSize(10, getResid());
            }
            if (hasSv()) {
                i += CodedOutputStreamMicro.computeStringSize(11, getSv());
            }
            if (hasTime()) {
                i += CodedOutputStreamMicro.computeInt32Size(12, getTime());
            }
            if (hasWd()) {
                i += CodedOutputStreamMicro.computeStringSize(13, getWd());
            }
            if (hasLdata()) {
                i += CodedOutputStreamMicro.computeStringSize(14, getLdata());
            }
            if (hasRegionType()) {
                i += CodedOutputStreamMicro.computeStringSize(15, getRegionType());
            }
            this.f11806E = i;
            return i;
        }

        public String getSv() {
            return this.f11828v;
        }

        public int getTime() {
            return this.f11830x;
        }

        public String getWd() {
            return this.f11832z;
        }

        public boolean hasChannel() {
            return this.f11811e;
        }

        public boolean hasClientsv() {
            return this.f11813g;
        }

        public boolean hasHasRtbus() {
            return this.f11807a;
        }

        public boolean hasIm() {
            return this.f11815i;
        }

        public boolean hasLdata() {
            return this.f11802A;
        }

        public boolean hasMb() {
            return this.f11817k;
        }

        public boolean hasNewmap() {
            return this.f11819m;
        }

        public boolean hasOs() {
            return this.f11821o;
        }

        public boolean hasQid() {
            return this.f11809c;
        }

        public boolean hasQt() {
            return this.f11823q;
        }

        public boolean hasRegionType() {
            return this.f11804C;
        }

        public boolean hasResid() {
            return this.f11825s;
        }

        public boolean hasSv() {
            return this.f11827u;
        }

        public boolean hasTime() {
            return this.f11829w;
        }

        public boolean hasWd() {
            return this.f11831y;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Option mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setHasRtbus(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setQid(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setChannel(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setClientsv(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setIm(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setMb(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setNewmap(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setOs(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setQt(codedInputStreamMicro.readString());
                        continue;
                    case 82:
                        setResid(codedInputStreamMicro.readString());
                        continue;
                    case 90:
                        setSv(codedInputStreamMicro.readString());
                        continue;
                    case 96:
                        setTime(codedInputStreamMicro.readInt32());
                        continue;
                    case 106:
                        setWd(codedInputStreamMicro.readString());
                        continue;
                    case 114:
                        setLdata(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.df /*122*/:
                        setRegionType(codedInputStreamMicro.readString());
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

        public Option setChannel(String str) {
            this.f11811e = true;
            this.f11812f = str;
            return this;
        }

        public Option setClientsv(String str) {
            this.f11813g = true;
            this.f11814h = str;
            return this;
        }

        public Option setHasRtbus(int i) {
            this.f11807a = true;
            this.f11808b = i;
            return this;
        }

        public Option setIm(String str) {
            this.f11815i = true;
            this.f11816j = str;
            return this;
        }

        public Option setLdata(String str) {
            this.f11802A = true;
            this.f11803B = str;
            return this;
        }

        public Option setMb(String str) {
            this.f11817k = true;
            this.f11818l = str;
            return this;
        }

        public Option setNewmap(String str) {
            this.f11819m = true;
            this.f11820n = str;
            return this;
        }

        public Option setOs(String str) {
            this.f11821o = true;
            this.f11822p = str;
            return this;
        }

        public Option setQid(String str) {
            this.f11809c = true;
            this.f11810d = str;
            return this;
        }

        public Option setQt(String str) {
            this.f11823q = true;
            this.f11824r = str;
            return this;
        }

        public Option setRegionType(String str) {
            this.f11804C = true;
            this.f11805D = str;
            return this;
        }

        public Option setResid(String str) {
            this.f11825s = true;
            this.f11826t = str;
            return this;
        }

        public Option setSv(String str) {
            this.f11827u = true;
            this.f11828v = str;
            return this;
        }

        public Option setTime(int i) {
            this.f11829w = true;
            this.f11830x = i;
            return this;
        }

        public Option setWd(String str) {
            this.f11831y = true;
            this.f11832z = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasHasRtbus()) {
                codedOutputStreamMicro.writeInt32(1, getHasRtbus());
            }
            if (hasQid()) {
                codedOutputStreamMicro.writeString(2, getQid());
            }
            if (hasChannel()) {
                codedOutputStreamMicro.writeString(3, getChannel());
            }
            if (hasClientsv()) {
                codedOutputStreamMicro.writeString(4, getClientsv());
            }
            if (hasIm()) {
                codedOutputStreamMicro.writeString(5, getIm());
            }
            if (hasMb()) {
                codedOutputStreamMicro.writeString(6, getMb());
            }
            if (hasNewmap()) {
                codedOutputStreamMicro.writeString(7, getNewmap());
            }
            if (hasOs()) {
                codedOutputStreamMicro.writeString(8, getOs());
            }
            if (hasQt()) {
                codedOutputStreamMicro.writeString(9, getQt());
            }
            if (hasResid()) {
                codedOutputStreamMicro.writeString(10, getResid());
            }
            if (hasSv()) {
                codedOutputStreamMicro.writeString(11, getSv());
            }
            if (hasTime()) {
                codedOutputStreamMicro.writeInt32(12, getTime());
            }
            if (hasWd()) {
                codedOutputStreamMicro.writeString(13, getWd());
            }
            if (hasLdata()) {
                codedOutputStreamMicro.writeString(14, getLdata());
            }
            if (hasRegionType()) {
                codedOutputStreamMicro.writeString(15, getRegionType());
            }
        }
    }

    public static Inf parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Inf().mergeFrom(codedInputStreamMicro);
    }

    public static Inf parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Inf) new Inf().mergeFrom(bArr);
    }

    public final Inf clear() {
        clearOption();
        clearContent();
        clearCurrentCity();
        clearOffline();
        this.f11841i = -1;
        return this;
    }

    public Inf clearContent() {
        this.f11835c = false;
        this.f11836d = null;
        return this;
    }

    public Inf clearCurrentCity() {
        this.f11837e = false;
        this.f11838f = null;
        return this;
    }

    public Inf clearOffline() {
        this.f11839g = false;
        this.f11840h = 0;
        return this;
    }

    public Inf clearOption() {
        this.f11833a = false;
        this.f11834b = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f11841i < 0) {
            getSerializedSize();
        }
        return this.f11841i;
    }

    public Content getContent() {
        return this.f11836d;
    }

    public CurrentCity getCurrentCity() {
        return this.f11838f;
    }

    public int getOffline() {
        return this.f11840h;
    }

    public Option getOption() {
        return this.f11834b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasOption()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
        }
        if (hasContent()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getContent());
        }
        if (hasCurrentCity()) {
            i += CodedOutputStreamMicro.computeMessageSize(3, getCurrentCity());
        }
        if (hasOffline()) {
            i += CodedOutputStreamMicro.computeInt32Size(4, getOffline());
        }
        this.f11841i = i;
        return i;
    }

    public boolean hasContent() {
        return this.f11835c;
    }

    public boolean hasCurrentCity() {
        return this.f11837e;
    }

    public boolean hasOffline() {
        return this.f11839g;
    }

    public boolean hasOption() {
        return this.f11833a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Inf mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro option;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    option = new Option();
                    codedInputStreamMicro.readMessage(option);
                    setOption(option);
                    continue;
                case 18:
                    option = new Content();
                    codedInputStreamMicro.readMessage(option);
                    setContent(option);
                    continue;
                case 26:
                    option = new CurrentCity();
                    codedInputStreamMicro.readMessage(option);
                    setCurrentCity(option);
                    continue;
                case 32:
                    setOffline(codedInputStreamMicro.readInt32());
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

    public Inf setContent(Content content) {
        if (content == null) {
            return clearContent();
        }
        this.f11835c = true;
        this.f11836d = content;
        return this;
    }

    public Inf setCurrentCity(CurrentCity currentCity) {
        if (currentCity == null) {
            return clearCurrentCity();
        }
        this.f11837e = true;
        this.f11838f = currentCity;
        return this;
    }

    public Inf setOffline(int i) {
        this.f11839g = true;
        this.f11840h = i;
        return this;
    }

    public Inf setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f11833a = true;
        this.f11834b = option;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(1, getOption());
        }
        if (hasContent()) {
            codedOutputStreamMicro.writeMessage(2, getContent());
        }
        if (hasCurrentCity()) {
            codedOutputStreamMicro.writeMessage(3, getCurrentCity());
        }
        if (hasOffline()) {
            codedOutputStreamMicro.writeInt32(4, getOffline());
        }
    }
}
