package com.baidu.entity.pb;

import com.baidu.baidunavis.model.NavCarInfo;
import com.baidu.carlife.core.C1253f;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.navi.fragment.NaviFragmentManager;
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

public final class PoiResult extends MessageMicro {
    public static final int ADDRS_FIELD_NUMBER = 2;
    public static final int ADS_EXT_INFO_FIELD_NUMBER = 16;
    public static final int ADS_FIELD_NUMBER = 14;
    public static final int BRAND_BAR_FIELD_NUMBER = 10;
    public static final int CAR_PRELOAD_FIELD_NUMBER = 21;
    public static final int CHILDREN_FIELD_NUMBER = 8;
    public static final int CONTENTS_FIELD_NUMBER = 6;
    public static final int CORRECTION_INFO_FIELD_NUMBER = 20;
    public static final int CURRENT_CITY_FIELD_NUMBER = 7;
    public static final int GUIDE_TAG_FIELD_NUMBER = 13;
    public static final int IMGE_EXT_FIELD_NUMBER = 11;
    public static final int INDUS_INFO_FIELD_NUMBER = 18;
    public static final int OFFLINE_FIELD_NUMBER = 12;
    public static final int OPTION_FIELD_NUMBER = 1;
    public static final int PLACE_INFO_FIELD_NUMBER = 5;
    public static final int PREVIOUS_CITY_FIELD_NUMBER = 9;
    public static final int PSRS_FIELD_NUMBER = 3;
    public static final int RECOMMEND_FIELD_NUMBER = 19;
    public static final int SUGGEST_QUERY_FIELD_NUMBER = 4;
    /* renamed from: A */
    private boolean f12642A;
    /* renamed from: B */
    private PoiResult$Recommend f12643B = null;
    /* renamed from: C */
    private boolean f12644C;
    /* renamed from: D */
    private PoiResult$CorrectionInfo f12645D = null;
    /* renamed from: E */
    private boolean f12646E;
    /* renamed from: F */
    private int f12647F = 0;
    /* renamed from: G */
    private int f12648G = -1;
    /* renamed from: a */
    private boolean f12649a;
    /* renamed from: b */
    private PoiResult$Option f12650b = null;
    /* renamed from: c */
    private List<Addrs> f12651c = Collections.emptyList();
    /* renamed from: d */
    private boolean f12652d;
    /* renamed from: e */
    private PoiResult$Psrs f12653e = null;
    /* renamed from: f */
    private List<PoiResult$SuggestQuery> f12654f = Collections.emptyList();
    /* renamed from: g */
    private boolean f12655g;
    /* renamed from: h */
    private PoiResult$PlaceInfo f12656h = null;
    /* renamed from: i */
    private List<Contents> f12657i = Collections.emptyList();
    /* renamed from: j */
    private List<Children> f12658j = Collections.emptyList();
    /* renamed from: k */
    private boolean f12659k;
    /* renamed from: l */
    private PoiResult$PreviousCity f12660l = null;
    /* renamed from: m */
    private boolean f12661m;
    /* renamed from: n */
    private CurrentCity f12662n = null;
    /* renamed from: o */
    private boolean f12663o;
    /* renamed from: p */
    private BrandBar f12664p = null;
    /* renamed from: q */
    private boolean f12665q;
    /* renamed from: r */
    private ByteStringMicro f12666r = ByteStringMicro.EMPTY;
    /* renamed from: s */
    private boolean f12667s;
    /* renamed from: t */
    private int f12668t = 0;
    /* renamed from: u */
    private List<PoiResult$GuideTag> f12669u = Collections.emptyList();
    /* renamed from: v */
    private List<Ads> f12670v = Collections.emptyList();
    /* renamed from: w */
    private boolean f12671w;
    /* renamed from: x */
    private AdsExtInfo f12672x = null;
    /* renamed from: y */
    private boolean f12673y;
    /* renamed from: z */
    private PoiResult$IndusInfo f12674z = null;

    public static final class Addrs extends MessageMicro {
        public static final int ADDR_FIELD_NUMBER = 1;
        public static final int GEO_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 3;
        public static final int PRECISE_FIELD_NUMBER = 4;
        /* renamed from: a */
        private boolean f12471a;
        /* renamed from: b */
        private String f12472b = "";
        /* renamed from: c */
        private boolean f12473c;
        /* renamed from: d */
        private String f12474d = "";
        /* renamed from: e */
        private boolean f12475e;
        /* renamed from: f */
        private String f12476f = "";
        /* renamed from: g */
        private boolean f12477g;
        /* renamed from: h */
        private int f12478h = 0;
        /* renamed from: i */
        private int f12479i = -1;

        public static Addrs parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Addrs().mergeFrom(codedInputStreamMicro);
        }

        public static Addrs parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Addrs) new Addrs().mergeFrom(bArr);
        }

        public final Addrs clear() {
            clearAddr();
            clearGeo();
            clearName();
            clearPrecise();
            this.f12479i = -1;
            return this;
        }

        public Addrs clearAddr() {
            this.f12471a = false;
            this.f12472b = "";
            return this;
        }

        public Addrs clearGeo() {
            this.f12473c = false;
            this.f12474d = "";
            return this;
        }

        public Addrs clearName() {
            this.f12475e = false;
            this.f12476f = "";
            return this;
        }

        public Addrs clearPrecise() {
            this.f12477g = false;
            this.f12478h = 0;
            return this;
        }

        public String getAddr() {
            return this.f12472b;
        }

        public int getCachedSize() {
            if (this.f12479i < 0) {
                getSerializedSize();
            }
            return this.f12479i;
        }

        public String getGeo() {
            return this.f12474d;
        }

        public String getName() {
            return this.f12476f;
        }

        public int getPrecise() {
            return this.f12478h;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasAddr()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getAddr());
            }
            if (hasGeo()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getGeo());
            }
            if (hasName()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getName());
            }
            if (hasPrecise()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, getPrecise());
            }
            this.f12479i = i;
            return i;
        }

        public boolean hasAddr() {
            return this.f12471a;
        }

        public boolean hasGeo() {
            return this.f12473c;
        }

        public boolean hasName() {
            return this.f12475e;
        }

        public boolean hasPrecise() {
            return this.f12477g;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Addrs mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setAddr(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setGeo(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setName(codedInputStreamMicro.readString());
                        continue;
                    case 32:
                        setPrecise(codedInputStreamMicro.readInt32());
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

        public Addrs setAddr(String str) {
            this.f12471a = true;
            this.f12472b = str;
            return this;
        }

        public Addrs setGeo(String str) {
            this.f12473c = true;
            this.f12474d = str;
            return this;
        }

        public Addrs setName(String str) {
            this.f12475e = true;
            this.f12476f = str;
            return this;
        }

        public Addrs setPrecise(int i) {
            this.f12477g = true;
            this.f12478h = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasAddr()) {
                codedOutputStreamMicro.writeString(1, getAddr());
            }
            if (hasGeo()) {
                codedOutputStreamMicro.writeString(2, getGeo());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(3, getName());
            }
            if (hasPrecise()) {
                codedOutputStreamMicro.writeInt32(4, getPrecise());
            }
        }
    }

    public static final class Ads extends MessageMicro {
        public static final int ADS_DATA_FIELD_NUMBER = 8;
        public static final int ADS_EXT_FIELD_NUMBER = 4;
        public static final int ADS_INFO_FIELD_NUMBER = 3;
        public static final int ADS_POS_FIELD_NUMBER = 6;
        public static final int ADS_TYPE_FIELD_NUMBER = 7;
        public static final int POS_FIELD_NUMBER = 1;
        public static final int TYPE_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f12515a;
        /* renamed from: b */
        private int f12516b = 0;
        /* renamed from: c */
        private boolean f12517c;
        /* renamed from: d */
        private int f12518d = 0;
        /* renamed from: e */
        private boolean f12519e;
        /* renamed from: f */
        private AdsInfo f12520f = null;
        /* renamed from: g */
        private boolean f12521g;
        /* renamed from: h */
        private AdsExt f12522h = null;
        /* renamed from: i */
        private boolean f12523i;
        /* renamed from: j */
        private int f12524j = 0;
        /* renamed from: k */
        private boolean f12525k;
        /* renamed from: l */
        private int f12526l = 0;
        /* renamed from: m */
        private boolean f12527m;
        /* renamed from: n */
        private String f12528n = "";
        /* renamed from: o */
        private int f12529o = -1;

        public static final class AdsExt extends MessageMicro {
            public static final int ADS_LOGS_FIELD_NUMBER = 3;
            public static final int INTIMESIGN_FIELD_NUMBER = 1;
            public static final int PROMOTE_STYLE_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f12480a;
            /* renamed from: b */
            private String f12481b = "";
            /* renamed from: c */
            private boolean f12482c;
            /* renamed from: d */
            private int f12483d = 0;
            /* renamed from: e */
            private boolean f12484e;
            /* renamed from: f */
            private String f12485f = "";
            /* renamed from: g */
            private int f12486g = -1;

            public static AdsExt parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new AdsExt().mergeFrom(codedInputStreamMicro);
            }

            public static AdsExt parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (AdsExt) new AdsExt().mergeFrom(bArr);
            }

            public final AdsExt clear() {
                clearInTimeSign();
                clearPromoteStyle();
                clearAdsLogs();
                this.f12486g = -1;
                return this;
            }

            public AdsExt clearAdsLogs() {
                this.f12484e = false;
                this.f12485f = "";
                return this;
            }

            public AdsExt clearInTimeSign() {
                this.f12480a = false;
                this.f12481b = "";
                return this;
            }

            public AdsExt clearPromoteStyle() {
                this.f12482c = false;
                this.f12483d = 0;
                return this;
            }

            public String getAdsLogs() {
                return this.f12485f;
            }

            public int getCachedSize() {
                if (this.f12486g < 0) {
                    getSerializedSize();
                }
                return this.f12486g;
            }

            public String getInTimeSign() {
                return this.f12481b;
            }

            public int getPromoteStyle() {
                return this.f12483d;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasInTimeSign()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getInTimeSign());
                }
                if (hasPromoteStyle()) {
                    i += CodedOutputStreamMicro.computeInt32Size(2, getPromoteStyle());
                }
                if (hasAdsLogs()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getAdsLogs());
                }
                this.f12486g = i;
                return i;
            }

            public boolean hasAdsLogs() {
                return this.f12484e;
            }

            public boolean hasInTimeSign() {
                return this.f12480a;
            }

            public boolean hasPromoteStyle() {
                return this.f12482c;
            }

            public final boolean isInitialized() {
                return true;
            }

            public AdsExt mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setInTimeSign(codedInputStreamMicro.readString());
                            continue;
                        case 16:
                            setPromoteStyle(codedInputStreamMicro.readInt32());
                            continue;
                        case 26:
                            setAdsLogs(codedInputStreamMicro.readString());
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

            public AdsExt setAdsLogs(String str) {
                this.f12484e = true;
                this.f12485f = str;
                return this;
            }

            public AdsExt setInTimeSign(String str) {
                this.f12480a = true;
                this.f12481b = str;
                return this;
            }

            public AdsExt setPromoteStyle(int i) {
                this.f12482c = true;
                this.f12483d = i;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasInTimeSign()) {
                    codedOutputStreamMicro.writeString(1, getInTimeSign());
                }
                if (hasPromoteStyle()) {
                    codedOutputStreamMicro.writeInt32(2, getPromoteStyle());
                }
                if (hasAdsLogs()) {
                    codedOutputStreamMicro.writeString(3, getAdsLogs());
                }
            }
        }

        public static final class AdsInfo extends MessageMicro {
            public static final int ADS_MAIN_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f12512a;
            /* renamed from: b */
            private AdsMain f12513b = null;
            /* renamed from: c */
            private int f12514c = -1;

            public static final class AdsMain extends MessageMicro {
                public static final int ADDR_FIELD_NUMBER = 9;
                public static final int BRIEF_FIELD_NUMBER = 10;
                public static final int DISTANCE_FIELD_NUMBER = 7;
                public static final int NAME_FIELD_NUMBER = 3;
                public static final int PIC_FIELD_NUMBER = 11;
                public static final int PRIMARY_UID_FIELD_NUMBER = 2;
                public static final int PROMOTE_STYLE_FIELD_NUMBER = 12;
                public static final int SRC_NAME_FIELD_NUMBER = 8;
                public static final int STYLE_FIELD_NUMBER = 1;
                public static final int URL_FIELD_NUMBER = 4;
                public static final int X_FIELD_NUMBER = 5;
                public static final int Y_FIELD_NUMBER = 6;
                /* renamed from: a */
                private boolean f12487a;
                /* renamed from: b */
                private int f12488b = 0;
                /* renamed from: c */
                private boolean f12489c;
                /* renamed from: d */
                private String f12490d = "";
                /* renamed from: e */
                private boolean f12491e;
                /* renamed from: f */
                private String f12492f = "";
                /* renamed from: g */
                private boolean f12493g;
                /* renamed from: h */
                private String f12494h = "";
                /* renamed from: i */
                private boolean f12495i;
                /* renamed from: j */
                private String f12496j = "";
                /* renamed from: k */
                private boolean f12497k;
                /* renamed from: l */
                private String f12498l = "";
                /* renamed from: m */
                private boolean f12499m;
                /* renamed from: n */
                private int f12500n = 0;
                /* renamed from: o */
                private boolean f12501o;
                /* renamed from: p */
                private String f12502p = "";
                /* renamed from: q */
                private boolean f12503q;
                /* renamed from: r */
                private String f12504r = "";
                /* renamed from: s */
                private boolean f12505s;
                /* renamed from: t */
                private String f12506t = "";
                /* renamed from: u */
                private boolean f12507u;
                /* renamed from: v */
                private String f12508v = "";
                /* renamed from: w */
                private boolean f12509w;
                /* renamed from: x */
                private int f12510x = 0;
                /* renamed from: y */
                private int f12511y = -1;

                public static AdsMain parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new AdsMain().mergeFrom(codedInputStreamMicro);
                }

                public static AdsMain parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (AdsMain) new AdsMain().mergeFrom(bArr);
                }

                public final AdsMain clear() {
                    clearStyle();
                    clearPrimaryUid();
                    clearName();
                    clearUrl();
                    clearX();
                    clearY();
                    clearDistance();
                    clearSrcName();
                    clearAddr();
                    clearBrief();
                    clearPic();
                    clearPromoteStyle();
                    this.f12511y = -1;
                    return this;
                }

                public AdsMain clearAddr() {
                    this.f12503q = false;
                    this.f12504r = "";
                    return this;
                }

                public AdsMain clearBrief() {
                    this.f12505s = false;
                    this.f12506t = "";
                    return this;
                }

                public AdsMain clearDistance() {
                    this.f12499m = false;
                    this.f12500n = 0;
                    return this;
                }

                public AdsMain clearName() {
                    this.f12491e = false;
                    this.f12492f = "";
                    return this;
                }

                public AdsMain clearPic() {
                    this.f12507u = false;
                    this.f12508v = "";
                    return this;
                }

                public AdsMain clearPrimaryUid() {
                    this.f12489c = false;
                    this.f12490d = "";
                    return this;
                }

                public AdsMain clearPromoteStyle() {
                    this.f12509w = false;
                    this.f12510x = 0;
                    return this;
                }

                public AdsMain clearSrcName() {
                    this.f12501o = false;
                    this.f12502p = "";
                    return this;
                }

                public AdsMain clearStyle() {
                    this.f12487a = false;
                    this.f12488b = 0;
                    return this;
                }

                public AdsMain clearUrl() {
                    this.f12493g = false;
                    this.f12494h = "";
                    return this;
                }

                public AdsMain clearX() {
                    this.f12495i = false;
                    this.f12496j = "";
                    return this;
                }

                public AdsMain clearY() {
                    this.f12497k = false;
                    this.f12498l = "";
                    return this;
                }

                public String getAddr() {
                    return this.f12504r;
                }

                public String getBrief() {
                    return this.f12506t;
                }

                public int getCachedSize() {
                    if (this.f12511y < 0) {
                        getSerializedSize();
                    }
                    return this.f12511y;
                }

                public int getDistance() {
                    return this.f12500n;
                }

                public String getName() {
                    return this.f12492f;
                }

                public String getPic() {
                    return this.f12508v;
                }

                public String getPrimaryUid() {
                    return this.f12490d;
                }

                public int getPromoteStyle() {
                    return this.f12510x;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasStyle()) {
                        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getStyle());
                    }
                    if (hasPrimaryUid()) {
                        i += CodedOutputStreamMicro.computeStringSize(2, getPrimaryUid());
                    }
                    if (hasName()) {
                        i += CodedOutputStreamMicro.computeStringSize(3, getName());
                    }
                    if (hasUrl()) {
                        i += CodedOutputStreamMicro.computeStringSize(4, getUrl());
                    }
                    if (hasX()) {
                        i += CodedOutputStreamMicro.computeStringSize(5, getX());
                    }
                    if (hasY()) {
                        i += CodedOutputStreamMicro.computeStringSize(6, getY());
                    }
                    if (hasDistance()) {
                        i += CodedOutputStreamMicro.computeInt32Size(7, getDistance());
                    }
                    if (hasSrcName()) {
                        i += CodedOutputStreamMicro.computeStringSize(8, getSrcName());
                    }
                    if (hasAddr()) {
                        i += CodedOutputStreamMicro.computeStringSize(9, getAddr());
                    }
                    if (hasBrief()) {
                        i += CodedOutputStreamMicro.computeStringSize(10, getBrief());
                    }
                    if (hasPic()) {
                        i += CodedOutputStreamMicro.computeStringSize(11, getPic());
                    }
                    if (hasPromoteStyle()) {
                        i += CodedOutputStreamMicro.computeInt32Size(12, getPromoteStyle());
                    }
                    this.f12511y = i;
                    return i;
                }

                public String getSrcName() {
                    return this.f12502p;
                }

                public int getStyle() {
                    return this.f12488b;
                }

                public String getUrl() {
                    return this.f12494h;
                }

                public String getX() {
                    return this.f12496j;
                }

                public String getY() {
                    return this.f12498l;
                }

                public boolean hasAddr() {
                    return this.f12503q;
                }

                public boolean hasBrief() {
                    return this.f12505s;
                }

                public boolean hasDistance() {
                    return this.f12499m;
                }

                public boolean hasName() {
                    return this.f12491e;
                }

                public boolean hasPic() {
                    return this.f12507u;
                }

                public boolean hasPrimaryUid() {
                    return this.f12489c;
                }

                public boolean hasPromoteStyle() {
                    return this.f12509w;
                }

                public boolean hasSrcName() {
                    return this.f12501o;
                }

                public boolean hasStyle() {
                    return this.f12487a;
                }

                public boolean hasUrl() {
                    return this.f12493g;
                }

                public boolean hasX() {
                    return this.f12495i;
                }

                public boolean hasY() {
                    return this.f12497k;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public AdsMain mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                setStyle(codedInputStreamMicro.readInt32());
                                continue;
                            case 18:
                                setPrimaryUid(codedInputStreamMicro.readString());
                                continue;
                            case 26:
                                setName(codedInputStreamMicro.readString());
                                continue;
                            case 34:
                                setUrl(codedInputStreamMicro.readString());
                                continue;
                            case 42:
                                setX(codedInputStreamMicro.readString());
                                continue;
                            case 50:
                                setY(codedInputStreamMicro.readString());
                                continue;
                            case 56:
                                setDistance(codedInputStreamMicro.readInt32());
                                continue;
                            case 66:
                                setSrcName(codedInputStreamMicro.readString());
                                continue;
                            case 74:
                                setAddr(codedInputStreamMicro.readString());
                                continue;
                            case 82:
                                setBrief(codedInputStreamMicro.readString());
                                continue;
                            case 90:
                                setPic(codedInputStreamMicro.readString());
                                continue;
                            case 96:
                                setPromoteStyle(codedInputStreamMicro.readInt32());
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

                public AdsMain setAddr(String str) {
                    this.f12503q = true;
                    this.f12504r = str;
                    return this;
                }

                public AdsMain setBrief(String str) {
                    this.f12505s = true;
                    this.f12506t = str;
                    return this;
                }

                public AdsMain setDistance(int i) {
                    this.f12499m = true;
                    this.f12500n = i;
                    return this;
                }

                public AdsMain setName(String str) {
                    this.f12491e = true;
                    this.f12492f = str;
                    return this;
                }

                public AdsMain setPic(String str) {
                    this.f12507u = true;
                    this.f12508v = str;
                    return this;
                }

                public AdsMain setPrimaryUid(String str) {
                    this.f12489c = true;
                    this.f12490d = str;
                    return this;
                }

                public AdsMain setPromoteStyle(int i) {
                    this.f12509w = true;
                    this.f12510x = i;
                    return this;
                }

                public AdsMain setSrcName(String str) {
                    this.f12501o = true;
                    this.f12502p = str;
                    return this;
                }

                public AdsMain setStyle(int i) {
                    this.f12487a = true;
                    this.f12488b = i;
                    return this;
                }

                public AdsMain setUrl(String str) {
                    this.f12493g = true;
                    this.f12494h = str;
                    return this;
                }

                public AdsMain setX(String str) {
                    this.f12495i = true;
                    this.f12496j = str;
                    return this;
                }

                public AdsMain setY(String str) {
                    this.f12497k = true;
                    this.f12498l = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasStyle()) {
                        codedOutputStreamMicro.writeInt32(1, getStyle());
                    }
                    if (hasPrimaryUid()) {
                        codedOutputStreamMicro.writeString(2, getPrimaryUid());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(3, getName());
                    }
                    if (hasUrl()) {
                        codedOutputStreamMicro.writeString(4, getUrl());
                    }
                    if (hasX()) {
                        codedOutputStreamMicro.writeString(5, getX());
                    }
                    if (hasY()) {
                        codedOutputStreamMicro.writeString(6, getY());
                    }
                    if (hasDistance()) {
                        codedOutputStreamMicro.writeInt32(7, getDistance());
                    }
                    if (hasSrcName()) {
                        codedOutputStreamMicro.writeString(8, getSrcName());
                    }
                    if (hasAddr()) {
                        codedOutputStreamMicro.writeString(9, getAddr());
                    }
                    if (hasBrief()) {
                        codedOutputStreamMicro.writeString(10, getBrief());
                    }
                    if (hasPic()) {
                        codedOutputStreamMicro.writeString(11, getPic());
                    }
                    if (hasPromoteStyle()) {
                        codedOutputStreamMicro.writeInt32(12, getPromoteStyle());
                    }
                }
            }

            public static AdsInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new AdsInfo().mergeFrom(codedInputStreamMicro);
            }

            public static AdsInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (AdsInfo) new AdsInfo().mergeFrom(bArr);
            }

            public final AdsInfo clear() {
                clearAdsMain();
                this.f12514c = -1;
                return this;
            }

            public AdsInfo clearAdsMain() {
                this.f12512a = false;
                this.f12513b = null;
                return this;
            }

            public AdsMain getAdsMain() {
                return this.f12513b;
            }

            public int getCachedSize() {
                if (this.f12514c < 0) {
                    getSerializedSize();
                }
                return this.f12514c;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasAdsMain()) {
                    i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getAdsMain());
                }
                this.f12514c = i;
                return i;
            }

            public boolean hasAdsMain() {
                return this.f12512a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public AdsInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            MessageMicro adsMain = new AdsMain();
                            codedInputStreamMicro.readMessage(adsMain);
                            setAdsMain(adsMain);
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

            public AdsInfo setAdsMain(AdsMain adsMain) {
                if (adsMain == null) {
                    return clearAdsMain();
                }
                this.f12512a = true;
                this.f12513b = adsMain;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasAdsMain()) {
                    codedOutputStreamMicro.writeMessage(1, getAdsMain());
                }
            }
        }

        public static Ads parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Ads().mergeFrom(codedInputStreamMicro);
        }

        public static Ads parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Ads) new Ads().mergeFrom(bArr);
        }

        public final Ads clear() {
            clearPos();
            clearType();
            clearAdsInfo();
            clearAdsExt();
            clearAdsPos();
            clearAdsType();
            clearAdsData();
            this.f12529o = -1;
            return this;
        }

        public Ads clearAdsData() {
            this.f12527m = false;
            this.f12528n = "";
            return this;
        }

        public Ads clearAdsExt() {
            this.f12521g = false;
            this.f12522h = null;
            return this;
        }

        public Ads clearAdsInfo() {
            this.f12519e = false;
            this.f12520f = null;
            return this;
        }

        public Ads clearAdsPos() {
            this.f12523i = false;
            this.f12524j = 0;
            return this;
        }

        public Ads clearAdsType() {
            this.f12525k = false;
            this.f12526l = 0;
            return this;
        }

        public Ads clearPos() {
            this.f12515a = false;
            this.f12516b = 0;
            return this;
        }

        public Ads clearType() {
            this.f12517c = false;
            this.f12518d = 0;
            return this;
        }

        public String getAdsData() {
            return this.f12528n;
        }

        public AdsExt getAdsExt() {
            return this.f12522h;
        }

        public AdsInfo getAdsInfo() {
            return this.f12520f;
        }

        public int getAdsPos() {
            return this.f12524j;
        }

        public int getAdsType() {
            return this.f12526l;
        }

        public int getCachedSize() {
            if (this.f12529o < 0) {
                getSerializedSize();
            }
            return this.f12529o;
        }

        public int getPos() {
            return this.f12516b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasPos()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getPos());
            }
            if (hasType()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getType());
            }
            if (hasAdsInfo()) {
                i += CodedOutputStreamMicro.computeMessageSize(3, getAdsInfo());
            }
            if (hasAdsExt()) {
                i += CodedOutputStreamMicro.computeMessageSize(4, getAdsExt());
            }
            if (hasAdsPos()) {
                i += CodedOutputStreamMicro.computeInt32Size(6, getAdsPos());
            }
            if (hasAdsType()) {
                i += CodedOutputStreamMicro.computeInt32Size(7, getAdsType());
            }
            if (hasAdsData()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getAdsData());
            }
            this.f12529o = i;
            return i;
        }

        public int getType() {
            return this.f12518d;
        }

        public boolean hasAdsData() {
            return this.f12527m;
        }

        public boolean hasAdsExt() {
            return this.f12521g;
        }

        public boolean hasAdsInfo() {
            return this.f12519e;
        }

        public boolean hasAdsPos() {
            return this.f12523i;
        }

        public boolean hasAdsType() {
            return this.f12525k;
        }

        public boolean hasPos() {
            return this.f12515a;
        }

        public boolean hasType() {
            return this.f12517c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Ads mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro adsInfo;
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setPos(codedInputStreamMicro.readInt32());
                        continue;
                    case 16:
                        setType(codedInputStreamMicro.readInt32());
                        continue;
                    case 26:
                        adsInfo = new AdsInfo();
                        codedInputStreamMicro.readMessage(adsInfo);
                        setAdsInfo(adsInfo);
                        continue;
                    case 34:
                        adsInfo = new AdsExt();
                        codedInputStreamMicro.readMessage(adsInfo);
                        setAdsExt(adsInfo);
                        continue;
                    case 48:
                        setAdsPos(codedInputStreamMicro.readInt32());
                        continue;
                    case 56:
                        setAdsType(codedInputStreamMicro.readInt32());
                        continue;
                    case 66:
                        setAdsData(codedInputStreamMicro.readString());
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

        public Ads setAdsData(String str) {
            this.f12527m = true;
            this.f12528n = str;
            return this;
        }

        public Ads setAdsExt(AdsExt adsExt) {
            if (adsExt == null) {
                return clearAdsExt();
            }
            this.f12521g = true;
            this.f12522h = adsExt;
            return this;
        }

        public Ads setAdsInfo(AdsInfo adsInfo) {
            if (adsInfo == null) {
                return clearAdsInfo();
            }
            this.f12519e = true;
            this.f12520f = adsInfo;
            return this;
        }

        public Ads setAdsPos(int i) {
            this.f12523i = true;
            this.f12524j = i;
            return this;
        }

        public Ads setAdsType(int i) {
            this.f12525k = true;
            this.f12526l = i;
            return this;
        }

        public Ads setPos(int i) {
            this.f12515a = true;
            this.f12516b = i;
            return this;
        }

        public Ads setType(int i) {
            this.f12517c = true;
            this.f12518d = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasPos()) {
                codedOutputStreamMicro.writeInt32(1, getPos());
            }
            if (hasType()) {
                codedOutputStreamMicro.writeInt32(2, getType());
            }
            if (hasAdsInfo()) {
                codedOutputStreamMicro.writeMessage(3, getAdsInfo());
            }
            if (hasAdsExt()) {
                codedOutputStreamMicro.writeMessage(4, getAdsExt());
            }
            if (hasAdsPos()) {
                codedOutputStreamMicro.writeInt32(6, getAdsPos());
            }
            if (hasAdsType()) {
                codedOutputStreamMicro.writeInt32(7, getAdsType());
            }
            if (hasAdsData()) {
                codedOutputStreamMicro.writeString(8, getAdsData());
            }
        }
    }

    public static final class AdsExtInfo extends MessageMicro {
        public static final int ADS_PAGE_LOGS_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f12530a;
        /* renamed from: b */
        private String f12531b = "";
        /* renamed from: c */
        private int f12532c = -1;

        public static AdsExtInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new AdsExtInfo().mergeFrom(codedInputStreamMicro);
        }

        public static AdsExtInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (AdsExtInfo) new AdsExtInfo().mergeFrom(bArr);
        }

        public final AdsExtInfo clear() {
            clearAdsPageLogs();
            this.f12532c = -1;
            return this;
        }

        public AdsExtInfo clearAdsPageLogs() {
            this.f12530a = false;
            this.f12531b = "";
            return this;
        }

        public String getAdsPageLogs() {
            return this.f12531b;
        }

        public int getCachedSize() {
            if (this.f12532c < 0) {
                getSerializedSize();
            }
            return this.f12532c;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasAdsPageLogs()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getAdsPageLogs());
            }
            this.f12532c = i;
            return i;
        }

        public boolean hasAdsPageLogs() {
            return this.f12530a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public AdsExtInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setAdsPageLogs(codedInputStreamMicro.readString());
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

        public AdsExtInfo setAdsPageLogs(String str) {
            this.f12530a = true;
            this.f12531b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasAdsPageLogs()) {
                codedOutputStreamMicro.writeString(1, getAdsPageLogs());
            }
        }
    }

    public static final class BrandBar extends MessageMicro {
        public static final int DESC_FIELD_NUMBER = 6;
        public static final int IMG_FIELD_NUMBER = 1;
        public static final int LINK_FIELD_NUMBER = 5;
        public static final int SUBTITLE_FIELD_NUMBER = 3;
        public static final int TEL_FIELD_NUMBER = 4;
        public static final int TITLE_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f12533a;
        /* renamed from: b */
        private String f12534b = "";
        /* renamed from: c */
        private boolean f12535c;
        /* renamed from: d */
        private String f12536d = "";
        /* renamed from: e */
        private boolean f12537e;
        /* renamed from: f */
        private String f12538f = "";
        /* renamed from: g */
        private boolean f12539g;
        /* renamed from: h */
        private String f12540h = "";
        /* renamed from: i */
        private boolean f12541i;
        /* renamed from: j */
        private String f12542j = "";
        /* renamed from: k */
        private boolean f12543k;
        /* renamed from: l */
        private String f12544l = "";
        /* renamed from: m */
        private int f12545m = -1;

        public static BrandBar parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new BrandBar().mergeFrom(codedInputStreamMicro);
        }

        public static BrandBar parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (BrandBar) new BrandBar().mergeFrom(bArr);
        }

        public final BrandBar clear() {
            clearImg();
            clearTitle();
            clearSubtitle();
            clearTel();
            clearLink();
            clearDesc();
            this.f12545m = -1;
            return this;
        }

        public BrandBar clearDesc() {
            this.f12543k = false;
            this.f12544l = "";
            return this;
        }

        public BrandBar clearImg() {
            this.f12533a = false;
            this.f12534b = "";
            return this;
        }

        public BrandBar clearLink() {
            this.f12541i = false;
            this.f12542j = "";
            return this;
        }

        public BrandBar clearSubtitle() {
            this.f12537e = false;
            this.f12538f = "";
            return this;
        }

        public BrandBar clearTel() {
            this.f12539g = false;
            this.f12540h = "";
            return this;
        }

        public BrandBar clearTitle() {
            this.f12535c = false;
            this.f12536d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f12545m < 0) {
                getSerializedSize();
            }
            return this.f12545m;
        }

        public String getDesc() {
            return this.f12544l;
        }

        public String getImg() {
            return this.f12534b;
        }

        public String getLink() {
            return this.f12542j;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasImg()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getImg());
            }
            if (hasTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getTitle());
            }
            if (hasSubtitle()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getSubtitle());
            }
            if (hasTel()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getTel());
            }
            if (hasLink()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getLink());
            }
            if (hasDesc()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getDesc());
            }
            this.f12545m = i;
            return i;
        }

        public String getSubtitle() {
            return this.f12538f;
        }

        public String getTel() {
            return this.f12540h;
        }

        public String getTitle() {
            return this.f12536d;
        }

        public boolean hasDesc() {
            return this.f12543k;
        }

        public boolean hasImg() {
            return this.f12533a;
        }

        public boolean hasLink() {
            return this.f12541i;
        }

        public boolean hasSubtitle() {
            return this.f12537e;
        }

        public boolean hasTel() {
            return this.f12539g;
        }

        public boolean hasTitle() {
            return this.f12535c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public BrandBar mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setImg(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setSubtitle(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setTel(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setLink(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setDesc(codedInputStreamMicro.readString());
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

        public BrandBar setDesc(String str) {
            this.f12543k = true;
            this.f12544l = str;
            return this;
        }

        public BrandBar setImg(String str) {
            this.f12533a = true;
            this.f12534b = str;
            return this;
        }

        public BrandBar setLink(String str) {
            this.f12541i = true;
            this.f12542j = str;
            return this;
        }

        public BrandBar setSubtitle(String str) {
            this.f12537e = true;
            this.f12538f = str;
            return this;
        }

        public BrandBar setTel(String str) {
            this.f12539g = true;
            this.f12540h = str;
            return this;
        }

        public BrandBar setTitle(String str) {
            this.f12535c = true;
            this.f12536d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasImg()) {
                codedOutputStreamMicro.writeString(1, getImg());
            }
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(2, getTitle());
            }
            if (hasSubtitle()) {
                codedOutputStreamMicro.writeString(3, getSubtitle());
            }
            if (hasTel()) {
                codedOutputStreamMicro.writeString(4, getTel());
            }
            if (hasLink()) {
                codedOutputStreamMicro.writeString(5, getLink());
            }
            if (hasDesc()) {
                codedOutputStreamMicro.writeString(6, getDesc());
            }
        }
    }

    public static final class Children extends MessageMicro {
        public static final int CHILDREN_CONTENT_FIELD_NUMBER = 2;
        public static final int FATER_ID_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f12546a;
        /* renamed from: b */
        private String f12547b = "";
        /* renamed from: c */
        private List<Contents> f12548c = Collections.emptyList();
        /* renamed from: d */
        private int f12549d = -1;

        public static Children parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Children().mergeFrom(codedInputStreamMicro);
        }

        public static Children parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Children) new Children().mergeFrom(bArr);
        }

        public Children addChildrenContent(Contents contents) {
            if (contents != null) {
                if (this.f12548c.isEmpty()) {
                    this.f12548c = new ArrayList();
                }
                this.f12548c.add(contents);
            }
            return this;
        }

        public final Children clear() {
            clearFaterId();
            clearChildrenContent();
            this.f12549d = -1;
            return this;
        }

        public Children clearChildrenContent() {
            this.f12548c = Collections.emptyList();
            return this;
        }

        public Children clearFaterId() {
            this.f12546a = false;
            this.f12547b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f12549d < 0) {
                getSerializedSize();
            }
            return this.f12549d;
        }

        public Contents getChildrenContent(int i) {
            return (Contents) this.f12548c.get(i);
        }

        public int getChildrenContentCount() {
            return this.f12548c.size();
        }

        public List<Contents> getChildrenContentList() {
            return this.f12548c;
        }

        public String getFaterId() {
            return this.f12547b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasFaterId()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getFaterId());
            }
            int i2 = i;
            for (Contents computeMessageSize : getChildrenContentList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            this.f12549d = i2;
            return i2;
        }

        public boolean hasFaterId() {
            return this.f12546a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Children mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setFaterId(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        MessageMicro contents = new Contents();
                        codedInputStreamMicro.readMessage(contents);
                        addChildrenContent(contents);
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

        public Children setChildrenContent(int i, Contents contents) {
            if (contents != null) {
                this.f12548c.set(i, contents);
            }
            return this;
        }

        public Children setFaterId(String str) {
            this.f12546a = true;
            this.f12547b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasFaterId()) {
                codedOutputStreamMicro.writeString(1, getFaterId());
            }
            for (Contents writeMessage : getChildrenContentList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
        }
    }

    public static final class Contents extends MessageMicro {
        public static final int ACC_FLAG_FIELD_NUMBER = 4;
        public static final int ADDR_FIELD_NUMBER = 5;
        public static final int AOI_FIELD_NUMBER = 12;
        public static final int AREA_NAME_FIELD_NUMBER = 51;
        public static final int BAR_TEMPLATE_FIELD_NUMBER = 41;
        public static final int BRAND_ICON_ID_FIELD_NUMBER = 32;
        public static final int BUTTON_FIELD_NUMBER = 39;
        public static final int CHILD_CATALOG_FIELD_NUMBER = 24;
        public static final int CLOUD_TEMPLATE_FIELD_NUMBER = 38;
        public static final int DETAIL_FIELD_NUMBER = 6;
        public static final int DISTANCE_FIELD_NUMBER = 48;
        public static final int END_TIME_FIELD_NUMBER = 16;
        public static final int EXT_FIELD_NUMBER = 14;
        public static final int FATHER_SON_FIELD_NUMBER = 20;
        public static final int GEO_FIELD_NUMBER = 1;
        public static final int HAS_RTBUS_FIELD_NUMBER = 17;
        public static final int HEADWAY_FIELD_NUMBER = 43;
        public static final int HEAD_ICON_FIELD_NUMBER = 53;
        public static final int HEAT_MAP_FIELD_NUMBER = 23;
        public static final int ICON_ID_FIELD_NUMBER = 30;
        public static final int INDOOR_FLOOR_FIELD_NUMBER = 36;
        public static final int INDOOR_OVER_LOOKING_FIELD_NUMBER = 54;
        public static final int INDOOR_PANO_FIELD_NUMBER = 11;
        public static final int INDOOR_PARENT_UID_FIELD_NUMBER = 37;
        public static final int INTERVENT_TIPS_FIELD_NUMBER = 44;
        public static final int ISMODIFIED_FIELD_NUMBER = 42;
        public static final int KINDTYPE_FIELD_NUMBER = 31;
        public static final int LIST_SHOW_FIELD_NUMBER = 28;
        public static final int MAP_POITAG_FIELD_NUMBER = 40;
        public static final int MAX_SHOW_LEVEL_FIELD_NUMBER = 35;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int NEW_CATALOG_ID_FIELD_NUMBER = 26;
        public static final int PANO_FIELD_NUMBER = 10;
        public static final int PHOTO_LIST_FIELD_NUMBER = 52;
        public static final int POITYPE_FIELD_NUMBER = 9;
        public static final int POI_CHILD_TEXT_FIELD_NUMBER = 25;
        public static final int POI_REGION_TYPE_FIELD_NUMBER = 45;
        public static final int POI_TYPE_TEXT_FIELD_NUMBER = 22;
        public static final int RANK_FIELD_NUMBER = 34;
        public static final int REC_REASON_FIELD_NUMBER = 7;
        public static final int REGION_TYPE_FIELD_NUMBER = 46;
        public static final int RTBUS_UPDATE_TIME_FIELD_NUMBER = 19;
        public static final int SERVICE_TAG_FIELD_NUMBER = 50;
        public static final int SGEO_FIELD_NUMBER = 21;
        public static final int SHOW_FIELD_NUMBER = 13;
        public static final int SHOW_LEVEL_FIELD_NUMBER = 29;
        public static final int START_TIME_FIELD_NUMBER = 15;
        public static final int STD_TAG_FIELD_NUMBER = 49;
        public static final int TAG_FIELD_NUMBER = 33;
        public static final int TEL_FIELD_NUMBER = 8;
        public static final int TIP_RTBUS_FIELD_NUMBER = 18;
        public static final int UID_FIELD_NUMBER = 3;
        public static final int VIEW_TYPE_FIELD_NUMBER = 27;
        /* renamed from: A */
        private int f12590A = 0;
        /* renamed from: B */
        private boolean f12591B;
        /* renamed from: C */
        private String f12592C = "";
        /* renamed from: D */
        private boolean f12593D;
        /* renamed from: E */
        private String f12594E = "";
        /* renamed from: F */
        private boolean f12595F;
        /* renamed from: G */
        private String f12596G = "";
        /* renamed from: H */
        private boolean f12597H;
        /* renamed from: I */
        private String f12598I = "";
        /* renamed from: J */
        private boolean f12599J;
        /* renamed from: K */
        private int f12600K = 0;
        /* renamed from: L */
        private boolean f12601L;
        /* renamed from: M */
        private String f12602M = "";
        /* renamed from: N */
        private boolean f12603N;
        /* renamed from: O */
        private int f12604O = 0;
        /* renamed from: P */
        private boolean f12605P;
        /* renamed from: Q */
        private int f12606Q = 0;
        /* renamed from: R */
        private boolean f12607R;
        /* renamed from: S */
        private String f12608S = "";
        /* renamed from: T */
        private boolean f12609T;
        /* renamed from: U */
        private String f12610U = "";
        /* renamed from: V */
        private boolean f12611V;
        /* renamed from: W */
        private String f12612W = "";
        /* renamed from: X */
        private boolean f12613X;
        /* renamed from: Y */
        private String f12614Y = "";
        /* renamed from: Z */
        private boolean f12615Z;
        /* renamed from: a */
        private boolean f12616a;
        private PoiResult$Contents$MapPoitag aA = null;
        private boolean aB;
        private ByteStringMicro aC = ByteStringMicro.EMPTY;
        private boolean aD;
        private int aE = 0;
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
        private boolean aV;
        private String aW = "";
        private boolean aX;
        private PoiResult$Contents$HeadIcon aY = null;
        private boolean aZ;
        private int aa = 0;
        private boolean ab;
        private int ac = 0;
        private boolean ad;
        private int ae = 0;
        private boolean af;
        private int ag = 0;
        private boolean ah;
        private int ai = 0;
        private boolean aj;
        private int ak = 0;
        private boolean al;
        private int am = 0;
        private boolean an;
        private int ao = 0;
        private boolean ap;
        private int aq = 0;
        private boolean ar;
        private String as = "";
        private boolean at;
        private String au = "";
        private boolean av;
        private ByteStringMicro aw = ByteStringMicro.EMPTY;
        private boolean ax;
        private Button ay = null;
        private boolean az;
        /* renamed from: b */
        private PoiResult$Contents$Show f12617b = null;
        private int ba = 0;
        private int bb = -1;
        /* renamed from: c */
        private boolean f12618c;
        /* renamed from: d */
        private Ext f12619d = null;
        /* renamed from: e */
        private boolean f12620e;
        /* renamed from: f */
        private PoiResult$Contents$HeatMap f12621f = null;
        /* renamed from: g */
        private boolean f12622g;
        /* renamed from: h */
        private PoiResult$Contents$Sgeo f12623h = null;
        /* renamed from: i */
        private boolean f12624i;
        /* renamed from: j */
        private String f12625j = "";
        /* renamed from: k */
        private boolean f12626k;
        /* renamed from: l */
        private String f12627l = "";
        /* renamed from: m */
        private boolean f12628m;
        /* renamed from: n */
        private String f12629n = "";
        /* renamed from: o */
        private boolean f12630o;
        /* renamed from: p */
        private int f12631p = 0;
        /* renamed from: q */
        private boolean f12632q;
        /* renamed from: r */
        private String f12633r = "";
        /* renamed from: s */
        private boolean f12634s;
        /* renamed from: t */
        private int f12635t = 0;
        /* renamed from: u */
        private List<String> f12636u = Collections.emptyList();
        /* renamed from: v */
        private boolean f12637v;
        /* renamed from: w */
        private String f12638w = "";
        /* renamed from: x */
        private boolean f12639x;
        /* renamed from: y */
        private int f12640y = 0;
        /* renamed from: z */
        private boolean f12641z;

        public static final class Button extends MessageMicro {
            public static final int CONTENT_FIELD_NUMBER = 1;
            public static final int ICON_URL_FIELD_NUMBER = 4;
            public static final int TITLE_FIELD_NUMBER = 2;
            public static final int TYPE_FIELD_NUMBER = 3;
            /* renamed from: a */
            private boolean f12550a;
            /* renamed from: b */
            private String f12551b = "";
            /* renamed from: c */
            private boolean f12552c;
            /* renamed from: d */
            private String f12553d = "";
            /* renamed from: e */
            private boolean f12554e;
            /* renamed from: f */
            private String f12555f = "";
            /* renamed from: g */
            private boolean f12556g;
            /* renamed from: h */
            private String f12557h = "";
            /* renamed from: i */
            private int f12558i = -1;

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
                this.f12558i = -1;
                return this;
            }

            public Button clearContent() {
                this.f12550a = false;
                this.f12551b = "";
                return this;
            }

            public Button clearIconUrl() {
                this.f12556g = false;
                this.f12557h = "";
                return this;
            }

            public Button clearTitle() {
                this.f12552c = false;
                this.f12553d = "";
                return this;
            }

            public Button clearType() {
                this.f12554e = false;
                this.f12555f = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f12558i < 0) {
                    getSerializedSize();
                }
                return this.f12558i;
            }

            public String getContent() {
                return this.f12551b;
            }

            public String getIconUrl() {
                return this.f12557h;
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
                this.f12558i = i;
                return i;
            }

            public String getTitle() {
                return this.f12553d;
            }

            public String getType() {
                return this.f12555f;
            }

            public boolean hasContent() {
                return this.f12550a;
            }

            public boolean hasIconUrl() {
                return this.f12556g;
            }

            public boolean hasTitle() {
                return this.f12552c;
            }

            public boolean hasType() {
                return this.f12554e;
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
                this.f12550a = true;
                this.f12551b = str;
                return this;
            }

            public Button setIconUrl(String str) {
                this.f12556g = true;
                this.f12557h = str;
                return this;
            }

            public Button setTitle(String str) {
                this.f12552c = true;
                this.f12553d = str;
                return this;
            }

            public Button setType(String str) {
                this.f12554e = true;
                this.f12555f = str;
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
            public static final int ADV_INFO_FIELD_NUMBER = 3;
            public static final int DETAIL_INFO_FIELD_NUMBER = 2;
            public static final int SRC_NAME_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f12583a;
            /* renamed from: b */
            private PoiResult$Contents$Ext$DetailInfo f12584b = null;
            /* renamed from: c */
            private boolean f12585c;
            /* renamed from: d */
            private String f12586d = "";
            /* renamed from: e */
            private boolean f12587e;
            /* renamed from: f */
            private AdvInfo f12588f = null;
            /* renamed from: g */
            private int f12589g = -1;

            public static final class AdvInfo extends MessageMicro {
                public static final int OP_INFO_FIELD_NUMBER = 2;
                public static final int TYPE_FIELD_NUMBER = 1;
                /* renamed from: a */
                private boolean f12578a;
                /* renamed from: b */
                private String f12579b = "";
                /* renamed from: c */
                private boolean f12580c;
                /* renamed from: d */
                private OpInfo f12581d = null;
                /* renamed from: e */
                private int f12582e = -1;

                public static final class OpInfo extends MessageMicro {
                    public static final int ADDR_FIELD_NUMBER = 8;
                    public static final int ADVID_FIELD_NUMBER = 5;
                    public static final int CITY_FIELD_NUMBER = 6;
                    public static final int DES_FIELD_NUMBER = 4;
                    public static final int ICON_FIELD_NUMBER = 2;
                    public static final int NAME_FIELD_NUMBER = 7;
                    public static final int PRIMARY_UID_FIELD_NUMBER = 1;
                    public static final int SDES_FIELD_NUMBER = 3;
                    public static final int URL_FIELD_NUMBER = 9;
                    /* renamed from: a */
                    private boolean f12559a;
                    /* renamed from: b */
                    private String f12560b = "";
                    /* renamed from: c */
                    private boolean f12561c;
                    /* renamed from: d */
                    private String f12562d = "";
                    /* renamed from: e */
                    private boolean f12563e;
                    /* renamed from: f */
                    private String f12564f = "";
                    /* renamed from: g */
                    private boolean f12565g;
                    /* renamed from: h */
                    private String f12566h = "";
                    /* renamed from: i */
                    private boolean f12567i;
                    /* renamed from: j */
                    private String f12568j = "";
                    /* renamed from: k */
                    private boolean f12569k;
                    /* renamed from: l */
                    private String f12570l = "";
                    /* renamed from: m */
                    private boolean f12571m;
                    /* renamed from: n */
                    private String f12572n = "";
                    /* renamed from: o */
                    private boolean f12573o;
                    /* renamed from: p */
                    private String f12574p = "";
                    /* renamed from: q */
                    private boolean f12575q;
                    /* renamed from: r */
                    private String f12576r = "";
                    /* renamed from: s */
                    private int f12577s = -1;

                    public static OpInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new OpInfo().mergeFrom(codedInputStreamMicro);
                    }

                    public static OpInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (OpInfo) new OpInfo().mergeFrom(bArr);
                    }

                    public final OpInfo clear() {
                        clearPrimaryUid();
                        clearIcon();
                        clearSdes();
                        clearDes();
                        clearAdvid();
                        clearCity();
                        clearName();
                        clearAddr();
                        clearUrl();
                        this.f12577s = -1;
                        return this;
                    }

                    public OpInfo clearAddr() {
                        this.f12573o = false;
                        this.f12574p = "";
                        return this;
                    }

                    public OpInfo clearAdvid() {
                        this.f12567i = false;
                        this.f12568j = "";
                        return this;
                    }

                    public OpInfo clearCity() {
                        this.f12569k = false;
                        this.f12570l = "";
                        return this;
                    }

                    public OpInfo clearDes() {
                        this.f12565g = false;
                        this.f12566h = "";
                        return this;
                    }

                    public OpInfo clearIcon() {
                        this.f12561c = false;
                        this.f12562d = "";
                        return this;
                    }

                    public OpInfo clearName() {
                        this.f12571m = false;
                        this.f12572n = "";
                        return this;
                    }

                    public OpInfo clearPrimaryUid() {
                        this.f12559a = false;
                        this.f12560b = "";
                        return this;
                    }

                    public OpInfo clearSdes() {
                        this.f12563e = false;
                        this.f12564f = "";
                        return this;
                    }

                    public OpInfo clearUrl() {
                        this.f12575q = false;
                        this.f12576r = "";
                        return this;
                    }

                    public String getAddr() {
                        return this.f12574p;
                    }

                    public String getAdvid() {
                        return this.f12568j;
                    }

                    public int getCachedSize() {
                        if (this.f12577s < 0) {
                            getSerializedSize();
                        }
                        return this.f12577s;
                    }

                    public String getCity() {
                        return this.f12570l;
                    }

                    public String getDes() {
                        return this.f12566h;
                    }

                    public String getIcon() {
                        return this.f12562d;
                    }

                    public String getName() {
                        return this.f12572n;
                    }

                    public String getPrimaryUid() {
                        return this.f12560b;
                    }

                    public String getSdes() {
                        return this.f12564f;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasPrimaryUid()) {
                            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getPrimaryUid());
                        }
                        if (hasIcon()) {
                            i += CodedOutputStreamMicro.computeStringSize(2, getIcon());
                        }
                        if (hasSdes()) {
                            i += CodedOutputStreamMicro.computeStringSize(3, getSdes());
                        }
                        if (hasDes()) {
                            i += CodedOutputStreamMicro.computeStringSize(4, getDes());
                        }
                        if (hasAdvid()) {
                            i += CodedOutputStreamMicro.computeStringSize(5, getAdvid());
                        }
                        if (hasCity()) {
                            i += CodedOutputStreamMicro.computeStringSize(6, getCity());
                        }
                        if (hasName()) {
                            i += CodedOutputStreamMicro.computeStringSize(7, getName());
                        }
                        if (hasAddr()) {
                            i += CodedOutputStreamMicro.computeStringSize(8, getAddr());
                        }
                        if (hasUrl()) {
                            i += CodedOutputStreamMicro.computeStringSize(9, getUrl());
                        }
                        this.f12577s = i;
                        return i;
                    }

                    public String getUrl() {
                        return this.f12576r;
                    }

                    public boolean hasAddr() {
                        return this.f12573o;
                    }

                    public boolean hasAdvid() {
                        return this.f12567i;
                    }

                    public boolean hasCity() {
                        return this.f12569k;
                    }

                    public boolean hasDes() {
                        return this.f12565g;
                    }

                    public boolean hasIcon() {
                        return this.f12561c;
                    }

                    public boolean hasName() {
                        return this.f12571m;
                    }

                    public boolean hasPrimaryUid() {
                        return this.f12559a;
                    }

                    public boolean hasSdes() {
                        return this.f12563e;
                    }

                    public boolean hasUrl() {
                        return this.f12575q;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public OpInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    setPrimaryUid(codedInputStreamMicro.readString());
                                    continue;
                                case 18:
                                    setIcon(codedInputStreamMicro.readString());
                                    continue;
                                case 26:
                                    setSdes(codedInputStreamMicro.readString());
                                    continue;
                                case 34:
                                    setDes(codedInputStreamMicro.readString());
                                    continue;
                                case 42:
                                    setAdvid(codedInputStreamMicro.readString());
                                    continue;
                                case 50:
                                    setCity(codedInputStreamMicro.readString());
                                    continue;
                                case 58:
                                    setName(codedInputStreamMicro.readString());
                                    continue;
                                case 66:
                                    setAddr(codedInputStreamMicro.readString());
                                    continue;
                                case 74:
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

                    public OpInfo setAddr(String str) {
                        this.f12573o = true;
                        this.f12574p = str;
                        return this;
                    }

                    public OpInfo setAdvid(String str) {
                        this.f12567i = true;
                        this.f12568j = str;
                        return this;
                    }

                    public OpInfo setCity(String str) {
                        this.f12569k = true;
                        this.f12570l = str;
                        return this;
                    }

                    public OpInfo setDes(String str) {
                        this.f12565g = true;
                        this.f12566h = str;
                        return this;
                    }

                    public OpInfo setIcon(String str) {
                        this.f12561c = true;
                        this.f12562d = str;
                        return this;
                    }

                    public OpInfo setName(String str) {
                        this.f12571m = true;
                        this.f12572n = str;
                        return this;
                    }

                    public OpInfo setPrimaryUid(String str) {
                        this.f12559a = true;
                        this.f12560b = str;
                        return this;
                    }

                    public OpInfo setSdes(String str) {
                        this.f12563e = true;
                        this.f12564f = str;
                        return this;
                    }

                    public OpInfo setUrl(String str) {
                        this.f12575q = true;
                        this.f12576r = str;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasPrimaryUid()) {
                            codedOutputStreamMicro.writeString(1, getPrimaryUid());
                        }
                        if (hasIcon()) {
                            codedOutputStreamMicro.writeString(2, getIcon());
                        }
                        if (hasSdes()) {
                            codedOutputStreamMicro.writeString(3, getSdes());
                        }
                        if (hasDes()) {
                            codedOutputStreamMicro.writeString(4, getDes());
                        }
                        if (hasAdvid()) {
                            codedOutputStreamMicro.writeString(5, getAdvid());
                        }
                        if (hasCity()) {
                            codedOutputStreamMicro.writeString(6, getCity());
                        }
                        if (hasName()) {
                            codedOutputStreamMicro.writeString(7, getName());
                        }
                        if (hasAddr()) {
                            codedOutputStreamMicro.writeString(8, getAddr());
                        }
                        if (hasUrl()) {
                            codedOutputStreamMicro.writeString(9, getUrl());
                        }
                    }
                }

                public static AdvInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new AdvInfo().mergeFrom(codedInputStreamMicro);
                }

                public static AdvInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (AdvInfo) new AdvInfo().mergeFrom(bArr);
                }

                public final AdvInfo clear() {
                    clearType();
                    clearOpInfo();
                    this.f12582e = -1;
                    return this;
                }

                public AdvInfo clearOpInfo() {
                    this.f12580c = false;
                    this.f12581d = null;
                    return this;
                }

                public AdvInfo clearType() {
                    this.f12578a = false;
                    this.f12579b = "";
                    return this;
                }

                public int getCachedSize() {
                    if (this.f12582e < 0) {
                        getSerializedSize();
                    }
                    return this.f12582e;
                }

                public OpInfo getOpInfo() {
                    return this.f12581d;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasType()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getType());
                    }
                    if (hasOpInfo()) {
                        i += CodedOutputStreamMicro.computeMessageSize(2, getOpInfo());
                    }
                    this.f12582e = i;
                    return i;
                }

                public String getType() {
                    return this.f12579b;
                }

                public boolean hasOpInfo() {
                    return this.f12580c;
                }

                public boolean hasType() {
                    return this.f12578a;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public AdvInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                setType(codedInputStreamMicro.readString());
                                continue;
                            case 18:
                                MessageMicro opInfo = new OpInfo();
                                codedInputStreamMicro.readMessage(opInfo);
                                setOpInfo(opInfo);
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

                public AdvInfo setOpInfo(OpInfo opInfo) {
                    if (opInfo == null) {
                        return clearOpInfo();
                    }
                    this.f12580c = true;
                    this.f12581d = opInfo;
                    return this;
                }

                public AdvInfo setType(String str) {
                    this.f12578a = true;
                    this.f12579b = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasType()) {
                        codedOutputStreamMicro.writeString(1, getType());
                    }
                    if (hasOpInfo()) {
                        codedOutputStreamMicro.writeMessage(2, getOpInfo());
                    }
                }
            }

            public static Ext parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Ext().mergeFrom(codedInputStreamMicro);
            }

            public static Ext parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Ext) new Ext().mergeFrom(bArr);
            }

            public final Ext clear() {
                clearDetailInfo();
                clearSrcName();
                clearAdvInfo();
                this.f12589g = -1;
                return this;
            }

            public Ext clearAdvInfo() {
                this.f12587e = false;
                this.f12588f = null;
                return this;
            }

            public Ext clearDetailInfo() {
                this.f12583a = false;
                this.f12584b = null;
                return this;
            }

            public Ext clearSrcName() {
                this.f12585c = false;
                this.f12586d = "";
                return this;
            }

            public AdvInfo getAdvInfo() {
                return this.f12588f;
            }

            public int getCachedSize() {
                if (this.f12589g < 0) {
                    getSerializedSize();
                }
                return this.f12589g;
            }

            public PoiResult$Contents$Ext$DetailInfo getDetailInfo() {
                return this.f12584b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasSrcName()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getSrcName());
                }
                if (hasDetailInfo()) {
                    i += CodedOutputStreamMicro.computeMessageSize(2, getDetailInfo());
                }
                if (hasAdvInfo()) {
                    i += CodedOutputStreamMicro.computeMessageSize(3, getAdvInfo());
                }
                this.f12589g = i;
                return i;
            }

            public String getSrcName() {
                return this.f12586d;
            }

            public boolean hasAdvInfo() {
                return this.f12587e;
            }

            public boolean hasDetailInfo() {
                return this.f12583a;
            }

            public boolean hasSrcName() {
                return this.f12585c;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Ext mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    MessageMicro poiResult$Contents$Ext$DetailInfo;
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setSrcName(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            poiResult$Contents$Ext$DetailInfo = new PoiResult$Contents$Ext$DetailInfo();
                            codedInputStreamMicro.readMessage(poiResult$Contents$Ext$DetailInfo);
                            setDetailInfo(poiResult$Contents$Ext$DetailInfo);
                            continue;
                        case 26:
                            poiResult$Contents$Ext$DetailInfo = new AdvInfo();
                            codedInputStreamMicro.readMessage(poiResult$Contents$Ext$DetailInfo);
                            setAdvInfo(poiResult$Contents$Ext$DetailInfo);
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

            public Ext setAdvInfo(AdvInfo advInfo) {
                if (advInfo == null) {
                    return clearAdvInfo();
                }
                this.f12587e = true;
                this.f12588f = advInfo;
                return this;
            }

            public Ext setDetailInfo(PoiResult$Contents$Ext$DetailInfo poiResult$Contents$Ext$DetailInfo) {
                if (poiResult$Contents$Ext$DetailInfo == null) {
                    return clearDetailInfo();
                }
                this.f12583a = true;
                this.f12584b = poiResult$Contents$Ext$DetailInfo;
                return this;
            }

            public Ext setSrcName(String str) {
                this.f12585c = true;
                this.f12586d = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasSrcName()) {
                    codedOutputStreamMicro.writeString(1, getSrcName());
                }
                if (hasDetailInfo()) {
                    codedOutputStreamMicro.writeMessage(2, getDetailInfo());
                }
                if (hasAdvInfo()) {
                    codedOutputStreamMicro.writeMessage(3, getAdvInfo());
                }
            }
        }

        public static Contents parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Contents().mergeFrom(codedInputStreamMicro);
        }

        public static Contents parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Contents) new Contents().mergeFrom(bArr);
        }

        public Contents addRecReason(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f12636u.isEmpty()) {
                this.f12636u = new ArrayList();
            }
            this.f12636u.add(str);
            return this;
        }

        public final Contents clear() {
            clearShow();
            clearExt();
            clearHeatMap();
            clearSgeo();
            clearGeo();
            clearName();
            clearUid();
            clearAccFlag();
            clearAddr();
            clearDetail();
            clearRecReason();
            clearTel();
            clearPoiType();
            clearPano();
            clearIndoorPano();
            clearAoi();
            clearStartTime();
            clearEndTime();
            clearHasRtbus();
            clearTipRtbus();
            clearRtbusUpdateTime();
            clearFatherSon();
            clearPoiTypeText();
            clearChildCatalog();
            clearPoiChildText();
            clearNewCatalogId();
            clearViewType();
            clearListShow();
            clearShowLevel();
            clearIconId();
            clearKindtype();
            clearBrandIconId();
            clearTag();
            clearRank();
            clearMaxShowLevel();
            clearIndoorFloor();
            clearIndoorParentUid();
            clearCloudTemplate();
            clearButton();
            clearMapPoitag();
            clearBarTemplate();
            clearIsmodified();
            clearHeadway();
            clearInterventTips();
            clearPoiRegionType();
            clearRegionType();
            clearDistance();
            clearStdTag();
            clearServiceTag();
            clearAreaName();
            clearPhotoList();
            clearHeadIcon();
            clearIndoorOverLooking();
            this.bb = -1;
            return this;
        }

        public Contents clearAccFlag() {
            this.f12630o = false;
            this.f12631p = 0;
            return this;
        }

        public Contents clearAddr() {
            this.f12632q = false;
            this.f12633r = "";
            return this;
        }

        public Contents clearAoi() {
            this.f12593D = false;
            this.f12594E = "";
            return this;
        }

        public Contents clearAreaName() {
            this.aT = false;
            this.aU = "";
            return this;
        }

        public Contents clearBarTemplate() {
            this.aB = false;
            this.aC = ByteStringMicro.EMPTY;
            return this;
        }

        public Contents clearBrandIconId() {
            this.aj = false;
            this.ak = 0;
            return this;
        }

        public Contents clearButton() {
            this.ax = false;
            this.ay = null;
            return this;
        }

        public Contents clearChildCatalog() {
            this.f12609T = false;
            this.f12610U = "";
            return this;
        }

        public Contents clearCloudTemplate() {
            this.av = false;
            this.aw = ByteStringMicro.EMPTY;
            return this;
        }

        public Contents clearDetail() {
            this.f12634s = false;
            this.f12635t = 0;
            return this;
        }

        public Contents clearDistance() {
            this.aN = false;
            this.aO = "";
            return this;
        }

        public Contents clearEndTime() {
            this.f12597H = false;
            this.f12598I = "";
            return this;
        }

        public Contents clearExt() {
            this.f12618c = false;
            this.f12619d = null;
            return this;
        }

        public Contents clearFatherSon() {
            this.f12605P = false;
            this.f12606Q = 0;
            return this;
        }

        public Contents clearGeo() {
            this.f12624i = false;
            this.f12625j = "";
            return this;
        }

        public Contents clearHasRtbus() {
            this.f12599J = false;
            this.f12600K = 0;
            return this;
        }

        public Contents clearHeadIcon() {
            this.aX = false;
            this.aY = null;
            return this;
        }

        public Contents clearHeadway() {
            this.aF = false;
            this.aG = "";
            return this;
        }

        public Contents clearHeatMap() {
            this.f12620e = false;
            this.f12621f = null;
            return this;
        }

        public Contents clearIconId() {
            this.af = false;
            this.ag = 0;
            return this;
        }

        public Contents clearIndoorFloor() {
            this.ar = false;
            this.as = "";
            return this;
        }

        public Contents clearIndoorOverLooking() {
            this.aZ = false;
            this.ba = 0;
            return this;
        }

        public Contents clearIndoorPano() {
            this.f12591B = false;
            this.f12592C = "";
            return this;
        }

        public Contents clearIndoorParentUid() {
            this.at = false;
            this.au = "";
            return this;
        }

        public Contents clearInterventTips() {
            this.aH = false;
            this.aI = "";
            return this;
        }

        public Contents clearIsmodified() {
            this.aD = false;
            this.aE = 0;
            return this;
        }

        public Contents clearKindtype() {
            this.ah = false;
            this.ai = 0;
            return this;
        }

        public Contents clearListShow() {
            this.ab = false;
            this.ac = 0;
            return this;
        }

        public Contents clearMapPoitag() {
            this.az = false;
            this.aA = null;
            return this;
        }

        public Contents clearMaxShowLevel() {
            this.ap = false;
            this.aq = 0;
            return this;
        }

        public Contents clearName() {
            this.f12626k = false;
            this.f12627l = "";
            return this;
        }

        public Contents clearNewCatalogId() {
            this.f12613X = false;
            this.f12614Y = "";
            return this;
        }

        public Contents clearPano() {
            this.f12641z = false;
            this.f12590A = 0;
            return this;
        }

        public Contents clearPhotoList() {
            this.aV = false;
            this.aW = "";
            return this;
        }

        public Contents clearPoiChildText() {
            this.f12611V = false;
            this.f12612W = "";
            return this;
        }

        public Contents clearPoiRegionType() {
            this.aJ = false;
            this.aK = "";
            return this;
        }

        public Contents clearPoiType() {
            this.f12639x = false;
            this.f12640y = 0;
            return this;
        }

        public Contents clearPoiTypeText() {
            this.f12607R = false;
            this.f12608S = "";
            return this;
        }

        public Contents clearRank() {
            this.an = false;
            this.ao = 0;
            return this;
        }

        public Contents clearRecReason() {
            this.f12636u = Collections.emptyList();
            return this;
        }

        public Contents clearRegionType() {
            this.aL = false;
            this.aM = "";
            return this;
        }

        public Contents clearRtbusUpdateTime() {
            this.f12603N = false;
            this.f12604O = 0;
            return this;
        }

        public Contents clearServiceTag() {
            this.aR = false;
            this.aS = "";
            return this;
        }

        public Contents clearSgeo() {
            this.f12622g = false;
            this.f12623h = null;
            return this;
        }

        public Contents clearShow() {
            this.f12616a = false;
            this.f12617b = null;
            return this;
        }

        public Contents clearShowLevel() {
            this.ad = false;
            this.ae = 0;
            return this;
        }

        public Contents clearStartTime() {
            this.f12595F = false;
            this.f12596G = "";
            return this;
        }

        public Contents clearStdTag() {
            this.aP = false;
            this.aQ = "";
            return this;
        }

        public Contents clearTag() {
            this.al = false;
            this.am = 0;
            return this;
        }

        public Contents clearTel() {
            this.f12637v = false;
            this.f12638w = "";
            return this;
        }

        public Contents clearTipRtbus() {
            this.f12601L = false;
            this.f12602M = "";
            return this;
        }

        public Contents clearUid() {
            this.f12628m = false;
            this.f12629n = "";
            return this;
        }

        public Contents clearViewType() {
            this.f12615Z = false;
            this.aa = 0;
            return this;
        }

        public int getAccFlag() {
            return this.f12631p;
        }

        public String getAddr() {
            return this.f12633r;
        }

        public String getAoi() {
            return this.f12594E;
        }

        public String getAreaName() {
            return this.aU;
        }

        public ByteStringMicro getBarTemplate() {
            return this.aC;
        }

        public int getBrandIconId() {
            return this.ak;
        }

        public Button getButton() {
            return this.ay;
        }

        public int getCachedSize() {
            if (this.bb < 0) {
                getSerializedSize();
            }
            return this.bb;
        }

        public String getChildCatalog() {
            return this.f12610U;
        }

        public ByteStringMicro getCloudTemplate() {
            return this.aw;
        }

        public int getDetail() {
            return this.f12635t;
        }

        public String getDistance() {
            return this.aO;
        }

        public String getEndTime() {
            return this.f12598I;
        }

        public Ext getExt() {
            return this.f12619d;
        }

        public int getFatherSon() {
            return this.f12606Q;
        }

        public String getGeo() {
            return this.f12625j;
        }

        public int getHasRtbus() {
            return this.f12600K;
        }

        public PoiResult$Contents$HeadIcon getHeadIcon() {
            return this.aY;
        }

        public String getHeadway() {
            return this.aG;
        }

        public PoiResult$Contents$HeatMap getHeatMap() {
            return this.f12621f;
        }

        public int getIconId() {
            return this.ag;
        }

        public String getIndoorFloor() {
            return this.as;
        }

        public int getIndoorOverLooking() {
            return this.ba;
        }

        public String getIndoorPano() {
            return this.f12592C;
        }

        public String getIndoorParentUid() {
            return this.au;
        }

        public String getInterventTips() {
            return this.aI;
        }

        public int getIsmodified() {
            return this.aE;
        }

        public int getKindtype() {
            return this.ai;
        }

        public int getListShow() {
            return this.ac;
        }

        public PoiResult$Contents$MapPoitag getMapPoitag() {
            return this.aA;
        }

        public int getMaxShowLevel() {
            return this.aq;
        }

        public String getName() {
            return this.f12627l;
        }

        public String getNewCatalogId() {
            return this.f12614Y;
        }

        public int getPano() {
            return this.f12590A;
        }

        public String getPhotoList() {
            return this.aW;
        }

        public String getPoiChildText() {
            return this.f12612W;
        }

        public String getPoiRegionType() {
            return this.aK;
        }

        public int getPoiType() {
            return this.f12640y;
        }

        public String getPoiTypeText() {
            return this.f12608S;
        }

        public int getRank() {
            return this.ao;
        }

        public String getRecReason(int i) {
            return (String) this.f12636u.get(i);
        }

        public int getRecReasonCount() {
            return this.f12636u.size();
        }

        public List<String> getRecReasonList() {
            return this.f12636u;
        }

        public String getRegionType() {
            return this.aM;
        }

        public int getRtbusUpdateTime() {
            return this.f12604O;
        }

        public int getSerializedSize() {
            int i = 0;
            int computeStringSize = hasGeo() ? CodedOutputStreamMicro.computeStringSize(1, getGeo()) + 0 : 0;
            if (hasName()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getName());
            }
            if (hasUid()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getUid());
            }
            if (hasAccFlag()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, getAccFlag());
            }
            if (hasAddr()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getAddr());
            }
            int computeInt32Size = hasDetail() ? computeStringSize + CodedOutputStreamMicro.computeInt32Size(6, getDetail()) : computeStringSize;
            for (String computeStringSizeNoTag : getRecReasonList()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag);
            }
            computeStringSize = (computeInt32Size + i) + (getRecReasonList().size() * 1);
            if (hasTel()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(8, getTel());
            }
            if (hasPoiType()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(9, getPoiType());
            }
            if (hasPano()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(10, getPano());
            }
            if (hasIndoorPano()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(11, getIndoorPano());
            }
            if (hasAoi()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(12, getAoi());
            }
            if (hasShow()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(13, getShow());
            }
            if (hasExt()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(14, getExt());
            }
            if (hasStartTime()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(15, getStartTime());
            }
            if (hasEndTime()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(16, getEndTime());
            }
            if (hasHasRtbus()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(17, getHasRtbus());
            }
            if (hasTipRtbus()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(18, getTipRtbus());
            }
            if (hasRtbusUpdateTime()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(19, getRtbusUpdateTime());
            }
            if (hasFatherSon()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(20, getFatherSon());
            }
            if (hasSgeo()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(21, getSgeo());
            }
            if (hasPoiTypeText()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(22, getPoiTypeText());
            }
            if (hasHeatMap()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(23, getHeatMap());
            }
            if (hasChildCatalog()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(24, getChildCatalog());
            }
            if (hasPoiChildText()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(25, getPoiChildText());
            }
            if (hasNewCatalogId()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(26, getNewCatalogId());
            }
            if (hasViewType()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(27, getViewType());
            }
            if (hasListShow()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(28, getListShow());
            }
            if (hasShowLevel()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(29, getShowLevel());
            }
            if (hasIconId()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(30, getIconId());
            }
            if (hasKindtype()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(31, getKindtype());
            }
            if (hasBrandIconId()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(32, getBrandIconId());
            }
            if (hasTag()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(33, getTag());
            }
            if (hasRank()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(34, getRank());
            }
            if (hasMaxShowLevel()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(35, getMaxShowLevel());
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
            if (hasButton()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(39, getButton());
            }
            if (hasMapPoitag()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(40, getMapPoitag());
            }
            if (hasBarTemplate()) {
                computeStringSize += CodedOutputStreamMicro.computeBytesSize(41, getBarTemplate());
            }
            if (hasIsmodified()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(42, getIsmodified());
            }
            if (hasHeadway()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(43, getHeadway());
            }
            if (hasInterventTips()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(44, getInterventTips());
            }
            if (hasPoiRegionType()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(45, getPoiRegionType());
            }
            if (hasRegionType()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(46, getRegionType());
            }
            if (hasDistance()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(48, getDistance());
            }
            if (hasStdTag()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(49, getStdTag());
            }
            if (hasServiceTag()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(50, getServiceTag());
            }
            if (hasAreaName()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(51, getAreaName());
            }
            if (hasPhotoList()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(52, getPhotoList());
            }
            if (hasHeadIcon()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(53, getHeadIcon());
            }
            if (hasIndoorOverLooking()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(54, getIndoorOverLooking());
            }
            this.bb = computeStringSize;
            return computeStringSize;
        }

        public String getServiceTag() {
            return this.aS;
        }

        public PoiResult$Contents$Sgeo getSgeo() {
            return this.f12623h;
        }

        public PoiResult$Contents$Show getShow() {
            return this.f12617b;
        }

        public int getShowLevel() {
            return this.ae;
        }

        public String getStartTime() {
            return this.f12596G;
        }

        public String getStdTag() {
            return this.aQ;
        }

        public int getTag() {
            return this.am;
        }

        public String getTel() {
            return this.f12638w;
        }

        public String getTipRtbus() {
            return this.f12602M;
        }

        public String getUid() {
            return this.f12629n;
        }

        public int getViewType() {
            return this.aa;
        }

        public boolean hasAccFlag() {
            return this.f12630o;
        }

        public boolean hasAddr() {
            return this.f12632q;
        }

        public boolean hasAoi() {
            return this.f12593D;
        }

        public boolean hasAreaName() {
            return this.aT;
        }

        public boolean hasBarTemplate() {
            return this.aB;
        }

        public boolean hasBrandIconId() {
            return this.aj;
        }

        public boolean hasButton() {
            return this.ax;
        }

        public boolean hasChildCatalog() {
            return this.f12609T;
        }

        public boolean hasCloudTemplate() {
            return this.av;
        }

        public boolean hasDetail() {
            return this.f12634s;
        }

        public boolean hasDistance() {
            return this.aN;
        }

        public boolean hasEndTime() {
            return this.f12597H;
        }

        public boolean hasExt() {
            return this.f12618c;
        }

        public boolean hasFatherSon() {
            return this.f12605P;
        }

        public boolean hasGeo() {
            return this.f12624i;
        }

        public boolean hasHasRtbus() {
            return this.f12599J;
        }

        public boolean hasHeadIcon() {
            return this.aX;
        }

        public boolean hasHeadway() {
            return this.aF;
        }

        public boolean hasHeatMap() {
            return this.f12620e;
        }

        public boolean hasIconId() {
            return this.af;
        }

        public boolean hasIndoorFloor() {
            return this.ar;
        }

        public boolean hasIndoorOverLooking() {
            return this.aZ;
        }

        public boolean hasIndoorPano() {
            return this.f12591B;
        }

        public boolean hasIndoorParentUid() {
            return this.at;
        }

        public boolean hasInterventTips() {
            return this.aH;
        }

        public boolean hasIsmodified() {
            return this.aD;
        }

        public boolean hasKindtype() {
            return this.ah;
        }

        public boolean hasListShow() {
            return this.ab;
        }

        public boolean hasMapPoitag() {
            return this.az;
        }

        public boolean hasMaxShowLevel() {
            return this.ap;
        }

        public boolean hasName() {
            return this.f12626k;
        }

        public boolean hasNewCatalogId() {
            return this.f12613X;
        }

        public boolean hasPano() {
            return this.f12641z;
        }

        public boolean hasPhotoList() {
            return this.aV;
        }

        public boolean hasPoiChildText() {
            return this.f12611V;
        }

        public boolean hasPoiRegionType() {
            return this.aJ;
        }

        public boolean hasPoiType() {
            return this.f12639x;
        }

        public boolean hasPoiTypeText() {
            return this.f12607R;
        }

        public boolean hasRank() {
            return this.an;
        }

        public boolean hasRegionType() {
            return this.aL;
        }

        public boolean hasRtbusUpdateTime() {
            return this.f12603N;
        }

        public boolean hasServiceTag() {
            return this.aR;
        }

        public boolean hasSgeo() {
            return this.f12622g;
        }

        public boolean hasShow() {
            return this.f12616a;
        }

        public boolean hasShowLevel() {
            return this.ad;
        }

        public boolean hasStartTime() {
            return this.f12595F;
        }

        public boolean hasStdTag() {
            return this.aP;
        }

        public boolean hasTag() {
            return this.al;
        }

        public boolean hasTel() {
            return this.f12637v;
        }

        public boolean hasTipRtbus() {
            return this.f12601L;
        }

        public boolean hasUid() {
            return this.f12628m;
        }

        public boolean hasViewType() {
            return this.f12615Z;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Contents mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro poiResult$Contents$Show;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setGeo(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setName(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setUid(codedInputStreamMicro.readString());
                        continue;
                    case 32:
                        setAccFlag(codedInputStreamMicro.readInt32());
                        continue;
                    case 42:
                        setAddr(codedInputStreamMicro.readString());
                        continue;
                    case 48:
                        setDetail(codedInputStreamMicro.readInt32());
                        continue;
                    case 58:
                        addRecReason(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setTel(codedInputStreamMicro.readString());
                        continue;
                    case NavCarInfo.CarType_57L /*72*/:
                        setPoiType(codedInputStreamMicro.readInt32());
                        continue;
                    case 80:
                        setPano(codedInputStreamMicro.readInt32());
                        continue;
                    case 90:
                        setIndoorPano(codedInputStreamMicro.readString());
                        continue;
                    case 98:
                        setAoi(codedInputStreamMicro.readString());
                        continue;
                    case 106:
                        poiResult$Contents$Show = new PoiResult$Contents$Show();
                        codedInputStreamMicro.readMessage(poiResult$Contents$Show);
                        setShow(poiResult$Contents$Show);
                        continue;
                    case 114:
                        poiResult$Contents$Show = new Ext();
                        codedInputStreamMicro.readMessage(poiResult$Contents$Show);
                        setExt(poiResult$Contents$Show);
                        continue;
                    case C1253f.df /*122*/:
                        setStartTime(codedInputStreamMicro.readString());
                        continue;
                    case 130:
                        setEndTime(codedInputStreamMicro.readString());
                        continue;
                    case RouteLineResConst.LINE_DARK_RED_NORMAL /*136*/:
                        setHasRtbus(codedInputStreamMicro.readInt32());
                        continue;
                    case 146:
                        setTipRtbus(codedInputStreamMicro.readString());
                        continue;
                    case 152:
                        setRtbusUpdateTime(codedInputStreamMicro.readInt32());
                        continue;
                    case 160:
                        setFatherSon(codedInputStreamMicro.readInt32());
                        continue;
                    case 170:
                        poiResult$Contents$Show = new PoiResult$Contents$Sgeo();
                        codedInputStreamMicro.readMessage(poiResult$Contents$Show);
                        setSgeo(poiResult$Contents$Show);
                        continue;
                    case 178:
                        setPoiTypeText(codedInputStreamMicro.readString());
                        continue;
                    case 186:
                        poiResult$Contents$Show = new PoiResult$Contents$HeatMap();
                        codedInputStreamMicro.readMessage(poiResult$Contents$Show);
                        setHeatMap(poiResult$Contents$Show);
                        continue;
                    case RouteLineResConst.LINE_INTERNAL_NORMAL /*194*/:
                        setChildCatalog(codedInputStreamMicro.readString());
                        continue;
                    case 202:
                        setPoiChildText(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.ds /*210*/:
                        setNewCatalogId(codedInputStreamMicro.readString());
                        continue;
                    case 216:
                        setViewType(codedInputStreamMicro.readInt32());
                        continue;
                    case C1253f.dE /*224*/:
                        setListShow(codedInputStreamMicro.readInt32());
                        continue;
                    case NaviCmdConstants.ACTION_TYPE_NAVI_MODE_DAY /*232*/:
                        setShowLevel(codedInputStreamMicro.readInt32());
                        continue;
                    case RGHUDDataModel.MAX_CAR_SPEED /*240*/:
                        setIconId(codedInputStreamMicro.readInt32());
                        continue;
                    case C1253f.dQ /*248*/:
                        setKindtype(codedInputStreamMicro.readInt32());
                        continue;
                    case 256:
                        setBrandIconId(codedInputStreamMicro.readInt32());
                        continue;
                    case 264:
                        setTag(codedInputStreamMicro.readInt32());
                        continue;
                    case 272:
                        setRank(codedInputStreamMicro.readInt32());
                        continue;
                    case 280:
                        setMaxShowLevel(codedInputStreamMicro.readInt32());
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
                        poiResult$Contents$Show = new Button();
                        codedInputStreamMicro.readMessage(poiResult$Contents$Show);
                        setButton(poiResult$Contents$Show);
                        continue;
                    case NaviFragmentManager.TYPE_VOICE_SQUARE /*322*/:
                        poiResult$Contents$Show = new PoiResult$Contents$MapPoitag();
                        codedInputStreamMicro.readMessage(poiResult$Contents$Show);
                        setMapPoitag(poiResult$Contents$Show);
                        continue;
                    case 330:
                        setBarTemplate(codedInputStreamMicro.readBytes());
                        continue;
                    case 336:
                        setIsmodified(codedInputStreamMicro.readInt32());
                        continue;
                    case 346:
                        setHeadway(codedInputStreamMicro.readString());
                        continue;
                    case BusRouteProvider.START_NODE_STYLE /*354*/:
                        setInterventTips(codedInputStreamMicro.readString());
                        continue;
                    case 362:
                        setPoiRegionType(codedInputStreamMicro.readString());
                        continue;
                    case 370:
                        setRegionType(codedInputStreamMicro.readString());
                        continue;
                    case 386:
                        setDistance(codedInputStreamMicro.readString());
                        continue;
                    case 394:
                        setStdTag(codedInputStreamMicro.readString());
                        continue;
                    case 402:
                        setServiceTag(codedInputStreamMicro.readString());
                        continue;
                    case 410:
                        setAreaName(codedInputStreamMicro.readString());
                        continue;
                    case NE_RoutePlan_Result.ROUTEPLAN_RESULT_FAIL_DEST5_DEVIATE /*418*/:
                        setPhotoList(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.ew /*426*/:
                        poiResult$Contents$Show = new PoiResult$Contents$HeadIcon();
                        codedInputStreamMicro.readMessage(poiResult$Contents$Show);
                        setHeadIcon(poiResult$Contents$Show);
                        continue;
                    case 432:
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

        public Contents setAccFlag(int i) {
            this.f12630o = true;
            this.f12631p = i;
            return this;
        }

        public Contents setAddr(String str) {
            this.f12632q = true;
            this.f12633r = str;
            return this;
        }

        public Contents setAoi(String str) {
            this.f12593D = true;
            this.f12594E = str;
            return this;
        }

        public Contents setAreaName(String str) {
            this.aT = true;
            this.aU = str;
            return this;
        }

        public Contents setBarTemplate(ByteStringMicro byteStringMicro) {
            this.aB = true;
            this.aC = byteStringMicro;
            return this;
        }

        public Contents setBrandIconId(int i) {
            this.aj = true;
            this.ak = i;
            return this;
        }

        public Contents setButton(Button button) {
            if (button == null) {
                return clearButton();
            }
            this.ax = true;
            this.ay = button;
            return this;
        }

        public Contents setChildCatalog(String str) {
            this.f12609T = true;
            this.f12610U = str;
            return this;
        }

        public Contents setCloudTemplate(ByteStringMicro byteStringMicro) {
            this.av = true;
            this.aw = byteStringMicro;
            return this;
        }

        public Contents setDetail(int i) {
            this.f12634s = true;
            this.f12635t = i;
            return this;
        }

        public Contents setDistance(String str) {
            this.aN = true;
            this.aO = str;
            return this;
        }

        public Contents setEndTime(String str) {
            this.f12597H = true;
            this.f12598I = str;
            return this;
        }

        public Contents setExt(Ext ext) {
            if (ext == null) {
                return clearExt();
            }
            this.f12618c = true;
            this.f12619d = ext;
            return this;
        }

        public Contents setFatherSon(int i) {
            this.f12605P = true;
            this.f12606Q = i;
            return this;
        }

        public Contents setGeo(String str) {
            this.f12624i = true;
            this.f12625j = str;
            return this;
        }

        public Contents setHasRtbus(int i) {
            this.f12599J = true;
            this.f12600K = i;
            return this;
        }

        public Contents setHeadIcon(PoiResult$Contents$HeadIcon poiResult$Contents$HeadIcon) {
            if (poiResult$Contents$HeadIcon == null) {
                return clearHeadIcon();
            }
            this.aX = true;
            this.aY = poiResult$Contents$HeadIcon;
            return this;
        }

        public Contents setHeadway(String str) {
            this.aF = true;
            this.aG = str;
            return this;
        }

        public Contents setHeatMap(PoiResult$Contents$HeatMap poiResult$Contents$HeatMap) {
            if (poiResult$Contents$HeatMap == null) {
                return clearHeatMap();
            }
            this.f12620e = true;
            this.f12621f = poiResult$Contents$HeatMap;
            return this;
        }

        public Contents setIconId(int i) {
            this.af = true;
            this.ag = i;
            return this;
        }

        public Contents setIndoorFloor(String str) {
            this.ar = true;
            this.as = str;
            return this;
        }

        public Contents setIndoorOverLooking(int i) {
            this.aZ = true;
            this.ba = i;
            return this;
        }

        public Contents setIndoorPano(String str) {
            this.f12591B = true;
            this.f12592C = str;
            return this;
        }

        public Contents setIndoorParentUid(String str) {
            this.at = true;
            this.au = str;
            return this;
        }

        public Contents setInterventTips(String str) {
            this.aH = true;
            this.aI = str;
            return this;
        }

        public Contents setIsmodified(int i) {
            this.aD = true;
            this.aE = i;
            return this;
        }

        public Contents setKindtype(int i) {
            this.ah = true;
            this.ai = i;
            return this;
        }

        public Contents setListShow(int i) {
            this.ab = true;
            this.ac = i;
            return this;
        }

        public Contents setMapPoitag(PoiResult$Contents$MapPoitag poiResult$Contents$MapPoitag) {
            if (poiResult$Contents$MapPoitag == null) {
                return clearMapPoitag();
            }
            this.az = true;
            this.aA = poiResult$Contents$MapPoitag;
            return this;
        }

        public Contents setMaxShowLevel(int i) {
            this.ap = true;
            this.aq = i;
            return this;
        }

        public Contents setName(String str) {
            this.f12626k = true;
            this.f12627l = str;
            return this;
        }

        public Contents setNewCatalogId(String str) {
            this.f12613X = true;
            this.f12614Y = str;
            return this;
        }

        public Contents setPano(int i) {
            this.f12641z = true;
            this.f12590A = i;
            return this;
        }

        public Contents setPhotoList(String str) {
            this.aV = true;
            this.aW = str;
            return this;
        }

        public Contents setPoiChildText(String str) {
            this.f12611V = true;
            this.f12612W = str;
            return this;
        }

        public Contents setPoiRegionType(String str) {
            this.aJ = true;
            this.aK = str;
            return this;
        }

        public Contents setPoiType(int i) {
            this.f12639x = true;
            this.f12640y = i;
            return this;
        }

        public Contents setPoiTypeText(String str) {
            this.f12607R = true;
            this.f12608S = str;
            return this;
        }

        public Contents setRank(int i) {
            this.an = true;
            this.ao = i;
            return this;
        }

        public Contents setRecReason(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f12636u.set(i, str);
            return this;
        }

        public Contents setRegionType(String str) {
            this.aL = true;
            this.aM = str;
            return this;
        }

        public Contents setRtbusUpdateTime(int i) {
            this.f12603N = true;
            this.f12604O = i;
            return this;
        }

        public Contents setServiceTag(String str) {
            this.aR = true;
            this.aS = str;
            return this;
        }

        public Contents setSgeo(PoiResult$Contents$Sgeo poiResult$Contents$Sgeo) {
            if (poiResult$Contents$Sgeo == null) {
                return clearSgeo();
            }
            this.f12622g = true;
            this.f12623h = poiResult$Contents$Sgeo;
            return this;
        }

        public Contents setShow(PoiResult$Contents$Show poiResult$Contents$Show) {
            if (poiResult$Contents$Show == null) {
                return clearShow();
            }
            this.f12616a = true;
            this.f12617b = poiResult$Contents$Show;
            return this;
        }

        public Contents setShowLevel(int i) {
            this.ad = true;
            this.ae = i;
            return this;
        }

        public Contents setStartTime(String str) {
            this.f12595F = true;
            this.f12596G = str;
            return this;
        }

        public Contents setStdTag(String str) {
            this.aP = true;
            this.aQ = str;
            return this;
        }

        public Contents setTag(int i) {
            this.al = true;
            this.am = i;
            return this;
        }

        public Contents setTel(String str) {
            this.f12637v = true;
            this.f12638w = str;
            return this;
        }

        public Contents setTipRtbus(String str) {
            this.f12601L = true;
            this.f12602M = str;
            return this;
        }

        public Contents setUid(String str) {
            this.f12628m = true;
            this.f12629n = str;
            return this;
        }

        public Contents setViewType(int i) {
            this.f12615Z = true;
            this.aa = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasGeo()) {
                codedOutputStreamMicro.writeString(1, getGeo());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(2, getName());
            }
            if (hasUid()) {
                codedOutputStreamMicro.writeString(3, getUid());
            }
            if (hasAccFlag()) {
                codedOutputStreamMicro.writeInt32(4, getAccFlag());
            }
            if (hasAddr()) {
                codedOutputStreamMicro.writeString(5, getAddr());
            }
            if (hasDetail()) {
                codedOutputStreamMicro.writeInt32(6, getDetail());
            }
            for (String writeString : getRecReasonList()) {
                codedOutputStreamMicro.writeString(7, writeString);
            }
            if (hasTel()) {
                codedOutputStreamMicro.writeString(8, getTel());
            }
            if (hasPoiType()) {
                codedOutputStreamMicro.writeInt32(9, getPoiType());
            }
            if (hasPano()) {
                codedOutputStreamMicro.writeInt32(10, getPano());
            }
            if (hasIndoorPano()) {
                codedOutputStreamMicro.writeString(11, getIndoorPano());
            }
            if (hasAoi()) {
                codedOutputStreamMicro.writeString(12, getAoi());
            }
            if (hasShow()) {
                codedOutputStreamMicro.writeMessage(13, getShow());
            }
            if (hasExt()) {
                codedOutputStreamMicro.writeMessage(14, getExt());
            }
            if (hasStartTime()) {
                codedOutputStreamMicro.writeString(15, getStartTime());
            }
            if (hasEndTime()) {
                codedOutputStreamMicro.writeString(16, getEndTime());
            }
            if (hasHasRtbus()) {
                codedOutputStreamMicro.writeInt32(17, getHasRtbus());
            }
            if (hasTipRtbus()) {
                codedOutputStreamMicro.writeString(18, getTipRtbus());
            }
            if (hasRtbusUpdateTime()) {
                codedOutputStreamMicro.writeInt32(19, getRtbusUpdateTime());
            }
            if (hasFatherSon()) {
                codedOutputStreamMicro.writeInt32(20, getFatherSon());
            }
            if (hasSgeo()) {
                codedOutputStreamMicro.writeMessage(21, getSgeo());
            }
            if (hasPoiTypeText()) {
                codedOutputStreamMicro.writeString(22, getPoiTypeText());
            }
            if (hasHeatMap()) {
                codedOutputStreamMicro.writeMessage(23, getHeatMap());
            }
            if (hasChildCatalog()) {
                codedOutputStreamMicro.writeString(24, getChildCatalog());
            }
            if (hasPoiChildText()) {
                codedOutputStreamMicro.writeString(25, getPoiChildText());
            }
            if (hasNewCatalogId()) {
                codedOutputStreamMicro.writeString(26, getNewCatalogId());
            }
            if (hasViewType()) {
                codedOutputStreamMicro.writeInt32(27, getViewType());
            }
            if (hasListShow()) {
                codedOutputStreamMicro.writeInt32(28, getListShow());
            }
            if (hasShowLevel()) {
                codedOutputStreamMicro.writeInt32(29, getShowLevel());
            }
            if (hasIconId()) {
                codedOutputStreamMicro.writeInt32(30, getIconId());
            }
            if (hasKindtype()) {
                codedOutputStreamMicro.writeInt32(31, getKindtype());
            }
            if (hasBrandIconId()) {
                codedOutputStreamMicro.writeInt32(32, getBrandIconId());
            }
            if (hasTag()) {
                codedOutputStreamMicro.writeInt32(33, getTag());
            }
            if (hasRank()) {
                codedOutputStreamMicro.writeInt32(34, getRank());
            }
            if (hasMaxShowLevel()) {
                codedOutputStreamMicro.writeInt32(35, getMaxShowLevel());
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
            if (hasButton()) {
                codedOutputStreamMicro.writeMessage(39, getButton());
            }
            if (hasMapPoitag()) {
                codedOutputStreamMicro.writeMessage(40, getMapPoitag());
            }
            if (hasBarTemplate()) {
                codedOutputStreamMicro.writeBytes(41, getBarTemplate());
            }
            if (hasIsmodified()) {
                codedOutputStreamMicro.writeInt32(42, getIsmodified());
            }
            if (hasHeadway()) {
                codedOutputStreamMicro.writeString(43, getHeadway());
            }
            if (hasInterventTips()) {
                codedOutputStreamMicro.writeString(44, getInterventTips());
            }
            if (hasPoiRegionType()) {
                codedOutputStreamMicro.writeString(45, getPoiRegionType());
            }
            if (hasRegionType()) {
                codedOutputStreamMicro.writeString(46, getRegionType());
            }
            if (hasDistance()) {
                codedOutputStreamMicro.writeString(48, getDistance());
            }
            if (hasStdTag()) {
                codedOutputStreamMicro.writeString(49, getStdTag());
            }
            if (hasServiceTag()) {
                codedOutputStreamMicro.writeString(50, getServiceTag());
            }
            if (hasAreaName()) {
                codedOutputStreamMicro.writeString(51, getAreaName());
            }
            if (hasPhotoList()) {
                codedOutputStreamMicro.writeString(52, getPhotoList());
            }
            if (hasHeadIcon()) {
                codedOutputStreamMicro.writeMessage(53, getHeadIcon());
            }
            if (hasIndoorOverLooking()) {
                codedOutputStreamMicro.writeInt32(54, getIndoorOverLooking());
            }
        }
    }

    public static PoiResult parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new PoiResult().mergeFrom(codedInputStreamMicro);
    }

    public static PoiResult parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (PoiResult) new PoiResult().mergeFrom(bArr);
    }

    public PoiResult addAddrs(Addrs addrs) {
        if (addrs != null) {
            if (this.f12651c.isEmpty()) {
                this.f12651c = new ArrayList();
            }
            this.f12651c.add(addrs);
        }
        return this;
    }

    public PoiResult addAds(Ads ads) {
        if (ads != null) {
            if (this.f12670v.isEmpty()) {
                this.f12670v = new ArrayList();
            }
            this.f12670v.add(ads);
        }
        return this;
    }

    public PoiResult addChildren(Children children) {
        if (children != null) {
            if (this.f12658j.isEmpty()) {
                this.f12658j = new ArrayList();
            }
            this.f12658j.add(children);
        }
        return this;
    }

    public PoiResult addContents(Contents contents) {
        if (contents != null) {
            if (this.f12657i.isEmpty()) {
                this.f12657i = new ArrayList();
            }
            this.f12657i.add(contents);
        }
        return this;
    }

    public PoiResult addGuideTag(PoiResult$GuideTag poiResult$GuideTag) {
        if (poiResult$GuideTag != null) {
            if (this.f12669u.isEmpty()) {
                this.f12669u = new ArrayList();
            }
            this.f12669u.add(poiResult$GuideTag);
        }
        return this;
    }

    public PoiResult addSuggestQuery(PoiResult$SuggestQuery poiResult$SuggestQuery) {
        if (poiResult$SuggestQuery != null) {
            if (this.f12654f.isEmpty()) {
                this.f12654f = new ArrayList();
            }
            this.f12654f.add(poiResult$SuggestQuery);
        }
        return this;
    }

    public final PoiResult clear() {
        clearOption();
        clearAddrs();
        clearPsrs();
        clearSuggestQuery();
        clearPlaceInfo();
        clearContents();
        clearChildren();
        clearPreviousCity();
        clearCurrentCity();
        clearBrandBar();
        clearImgeExt();
        clearOffline();
        clearGuideTag();
        clearAds();
        clearAdsExtInfo();
        clearIndusInfo();
        clearRecommend();
        clearCorrectionInfo();
        clearCarPreload();
        this.f12648G = -1;
        return this;
    }

    public PoiResult clearAddrs() {
        this.f12651c = Collections.emptyList();
        return this;
    }

    public PoiResult clearAds() {
        this.f12670v = Collections.emptyList();
        return this;
    }

    public PoiResult clearAdsExtInfo() {
        this.f12671w = false;
        this.f12672x = null;
        return this;
    }

    public PoiResult clearBrandBar() {
        this.f12663o = false;
        this.f12664p = null;
        return this;
    }

    public PoiResult clearCarPreload() {
        this.f12646E = false;
        this.f12647F = 0;
        return this;
    }

    public PoiResult clearChildren() {
        this.f12658j = Collections.emptyList();
        return this;
    }

    public PoiResult clearContents() {
        this.f12657i = Collections.emptyList();
        return this;
    }

    public PoiResult clearCorrectionInfo() {
        this.f12644C = false;
        this.f12645D = null;
        return this;
    }

    public PoiResult clearCurrentCity() {
        this.f12661m = false;
        this.f12662n = null;
        return this;
    }

    public PoiResult clearGuideTag() {
        this.f12669u = Collections.emptyList();
        return this;
    }

    public PoiResult clearImgeExt() {
        this.f12665q = false;
        this.f12666r = ByteStringMicro.EMPTY;
        return this;
    }

    public PoiResult clearIndusInfo() {
        this.f12673y = false;
        this.f12674z = null;
        return this;
    }

    public PoiResult clearOffline() {
        this.f12667s = false;
        this.f12668t = 0;
        return this;
    }

    public PoiResult clearOption() {
        this.f12649a = false;
        this.f12650b = null;
        return this;
    }

    public PoiResult clearPlaceInfo() {
        this.f12655g = false;
        this.f12656h = null;
        return this;
    }

    public PoiResult clearPreviousCity() {
        this.f12659k = false;
        this.f12660l = null;
        return this;
    }

    public PoiResult clearPsrs() {
        this.f12652d = false;
        this.f12653e = null;
        return this;
    }

    public PoiResult clearRecommend() {
        this.f12642A = false;
        this.f12643B = null;
        return this;
    }

    public PoiResult clearSuggestQuery() {
        this.f12654f = Collections.emptyList();
        return this;
    }

    public Addrs getAddrs(int i) {
        return (Addrs) this.f12651c.get(i);
    }

    public int getAddrsCount() {
        return this.f12651c.size();
    }

    public List<Addrs> getAddrsList() {
        return this.f12651c;
    }

    public Ads getAds(int i) {
        return (Ads) this.f12670v.get(i);
    }

    public int getAdsCount() {
        return this.f12670v.size();
    }

    public AdsExtInfo getAdsExtInfo() {
        return this.f12672x;
    }

    public List<Ads> getAdsList() {
        return this.f12670v;
    }

    public BrandBar getBrandBar() {
        return this.f12664p;
    }

    public int getCachedSize() {
        if (this.f12648G < 0) {
            getSerializedSize();
        }
        return this.f12648G;
    }

    public int getCarPreload() {
        return this.f12647F;
    }

    public Children getChildren(int i) {
        return (Children) this.f12658j.get(i);
    }

    public int getChildrenCount() {
        return this.f12658j.size();
    }

    public List<Children> getChildrenList() {
        return this.f12658j;
    }

    public Contents getContents(int i) {
        return (Contents) this.f12657i.get(i);
    }

    public int getContentsCount() {
        return this.f12657i.size();
    }

    public List<Contents> getContentsList() {
        return this.f12657i;
    }

    public PoiResult$CorrectionInfo getCorrectionInfo() {
        return this.f12645D;
    }

    public CurrentCity getCurrentCity() {
        return this.f12662n;
    }

    public PoiResult$GuideTag getGuideTag(int i) {
        return (PoiResult$GuideTag) this.f12669u.get(i);
    }

    public int getGuideTagCount() {
        return this.f12669u.size();
    }

    public List<PoiResult$GuideTag> getGuideTagList() {
        return this.f12669u;
    }

    public ByteStringMicro getImgeExt() {
        return this.f12666r;
    }

    public PoiResult$IndusInfo getIndusInfo() {
        return this.f12674z;
    }

    public int getOffline() {
        return this.f12668t;
    }

    public PoiResult$Option getOption() {
        return this.f12650b;
    }

    public PoiResult$PlaceInfo getPlaceInfo() {
        return this.f12656h;
    }

    public PoiResult$PreviousCity getPreviousCity() {
        return this.f12660l;
    }

    public PoiResult$Psrs getPsrs() {
        return this.f12653e;
    }

    public PoiResult$Recommend getRecommend() {
        return this.f12643B;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasOption()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
        }
        int i2 = i;
        for (Addrs computeMessageSize : getAddrsList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
        }
        if (hasPsrs()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(3, getPsrs());
        }
        for (PoiResult$SuggestQuery computeMessageSize2 : getSuggestQueryList()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(4, computeMessageSize2);
        }
        if (hasPlaceInfo()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(5, getPlaceInfo());
        }
        for (Contents computeMessageSize3 : getContentsList()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(6, computeMessageSize3);
        }
        if (hasCurrentCity()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(7, getCurrentCity());
        }
        for (Children computeMessageSize4 : getChildrenList()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(8, computeMessageSize4);
        }
        if (hasPreviousCity()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(9, getPreviousCity());
        }
        if (hasBrandBar()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(10, getBrandBar());
        }
        if (hasImgeExt()) {
            i2 += CodedOutputStreamMicro.computeBytesSize(11, getImgeExt());
        }
        if (hasOffline()) {
            i2 += CodedOutputStreamMicro.computeInt32Size(12, getOffline());
        }
        for (PoiResult$GuideTag computeMessageSize5 : getGuideTagList()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(13, computeMessageSize5);
        }
        for (Ads computeMessageSize6 : getAdsList()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(14, computeMessageSize6);
        }
        if (hasAdsExtInfo()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(16, getAdsExtInfo());
        }
        if (hasIndusInfo()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(18, getIndusInfo());
        }
        if (hasRecommend()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(19, getRecommend());
        }
        if (hasCorrectionInfo()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(20, getCorrectionInfo());
        }
        if (hasCarPreload()) {
            i2 += CodedOutputStreamMicro.computeInt32Size(21, getCarPreload());
        }
        this.f12648G = i2;
        return i2;
    }

    public PoiResult$SuggestQuery getSuggestQuery(int i) {
        return (PoiResult$SuggestQuery) this.f12654f.get(i);
    }

    public int getSuggestQueryCount() {
        return this.f12654f.size();
    }

    public List<PoiResult$SuggestQuery> getSuggestQueryList() {
        return this.f12654f;
    }

    public boolean hasAdsExtInfo() {
        return this.f12671w;
    }

    public boolean hasBrandBar() {
        return this.f12663o;
    }

    public boolean hasCarPreload() {
        return this.f12646E;
    }

    public boolean hasCorrectionInfo() {
        return this.f12644C;
    }

    public boolean hasCurrentCity() {
        return this.f12661m;
    }

    public boolean hasImgeExt() {
        return this.f12665q;
    }

    public boolean hasIndusInfo() {
        return this.f12673y;
    }

    public boolean hasOffline() {
        return this.f12667s;
    }

    public boolean hasOption() {
        return this.f12649a;
    }

    public boolean hasPlaceInfo() {
        return this.f12655g;
    }

    public boolean hasPreviousCity() {
        return this.f12659k;
    }

    public boolean hasPsrs() {
        return this.f12652d;
    }

    public boolean hasRecommend() {
        return this.f12642A;
    }

    public final boolean isInitialized() {
        return true;
    }

    public PoiResult mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro poiResult$Option;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    poiResult$Option = new PoiResult$Option();
                    codedInputStreamMicro.readMessage(poiResult$Option);
                    setOption(poiResult$Option);
                    continue;
                case 18:
                    poiResult$Option = new Addrs();
                    codedInputStreamMicro.readMessage(poiResult$Option);
                    addAddrs(poiResult$Option);
                    continue;
                case 26:
                    poiResult$Option = new PoiResult$Psrs();
                    codedInputStreamMicro.readMessage(poiResult$Option);
                    setPsrs(poiResult$Option);
                    continue;
                case 34:
                    poiResult$Option = new PoiResult$SuggestQuery();
                    codedInputStreamMicro.readMessage(poiResult$Option);
                    addSuggestQuery(poiResult$Option);
                    continue;
                case 42:
                    poiResult$Option = new PoiResult$PlaceInfo();
                    codedInputStreamMicro.readMessage(poiResult$Option);
                    setPlaceInfo(poiResult$Option);
                    continue;
                case 50:
                    poiResult$Option = new Contents();
                    codedInputStreamMicro.readMessage(poiResult$Option);
                    addContents(poiResult$Option);
                    continue;
                case 58:
                    poiResult$Option = new CurrentCity();
                    codedInputStreamMicro.readMessage(poiResult$Option);
                    setCurrentCity(poiResult$Option);
                    continue;
                case 66:
                    poiResult$Option = new Children();
                    codedInputStreamMicro.readMessage(poiResult$Option);
                    addChildren(poiResult$Option);
                    continue;
                case 74:
                    poiResult$Option = new PoiResult$PreviousCity();
                    codedInputStreamMicro.readMessage(poiResult$Option);
                    setPreviousCity(poiResult$Option);
                    continue;
                case 82:
                    poiResult$Option = new BrandBar();
                    codedInputStreamMicro.readMessage(poiResult$Option);
                    setBrandBar(poiResult$Option);
                    continue;
                case 90:
                    setImgeExt(codedInputStreamMicro.readBytes());
                    continue;
                case 96:
                    setOffline(codedInputStreamMicro.readInt32());
                    continue;
                case 106:
                    poiResult$Option = new PoiResult$GuideTag();
                    codedInputStreamMicro.readMessage(poiResult$Option);
                    addGuideTag(poiResult$Option);
                    continue;
                case 114:
                    poiResult$Option = new Ads();
                    codedInputStreamMicro.readMessage(poiResult$Option);
                    addAds(poiResult$Option);
                    continue;
                case 130:
                    poiResult$Option = new AdsExtInfo();
                    codedInputStreamMicro.readMessage(poiResult$Option);
                    setAdsExtInfo(poiResult$Option);
                    continue;
                case 146:
                    poiResult$Option = new PoiResult$IndusInfo();
                    codedInputStreamMicro.readMessage(poiResult$Option);
                    setIndusInfo(poiResult$Option);
                    continue;
                case 154:
                    poiResult$Option = new PoiResult$Recommend();
                    codedInputStreamMicro.readMessage(poiResult$Option);
                    setRecommend(poiResult$Option);
                    continue;
                case 162:
                    poiResult$Option = new PoiResult$CorrectionInfo();
                    codedInputStreamMicro.readMessage(poiResult$Option);
                    setCorrectionInfo(poiResult$Option);
                    continue;
                case 168:
                    setCarPreload(codedInputStreamMicro.readInt32());
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

    public PoiResult setAddrs(int i, Addrs addrs) {
        if (addrs != null) {
            this.f12651c.set(i, addrs);
        }
        return this;
    }

    public PoiResult setAds(int i, Ads ads) {
        if (ads != null) {
            this.f12670v.set(i, ads);
        }
        return this;
    }

    public PoiResult setAdsExtInfo(AdsExtInfo adsExtInfo) {
        if (adsExtInfo == null) {
            return clearAdsExtInfo();
        }
        this.f12671w = true;
        this.f12672x = adsExtInfo;
        return this;
    }

    public PoiResult setBrandBar(BrandBar brandBar) {
        if (brandBar == null) {
            return clearBrandBar();
        }
        this.f12663o = true;
        this.f12664p = brandBar;
        return this;
    }

    public PoiResult setCarPreload(int i) {
        this.f12646E = true;
        this.f12647F = i;
        return this;
    }

    public PoiResult setChildren(int i, Children children) {
        if (children != null) {
            this.f12658j.set(i, children);
        }
        return this;
    }

    public PoiResult setContents(int i, Contents contents) {
        if (contents != null) {
            this.f12657i.set(i, contents);
        }
        return this;
    }

    public PoiResult setCorrectionInfo(PoiResult$CorrectionInfo poiResult$CorrectionInfo) {
        if (poiResult$CorrectionInfo == null) {
            return clearCorrectionInfo();
        }
        this.f12644C = true;
        this.f12645D = poiResult$CorrectionInfo;
        return this;
    }

    public PoiResult setCurrentCity(CurrentCity currentCity) {
        if (currentCity == null) {
            return clearCurrentCity();
        }
        this.f12661m = true;
        this.f12662n = currentCity;
        return this;
    }

    public PoiResult setGuideTag(int i, PoiResult$GuideTag poiResult$GuideTag) {
        if (poiResult$GuideTag != null) {
            this.f12669u.set(i, poiResult$GuideTag);
        }
        return this;
    }

    public PoiResult setImgeExt(ByteStringMicro byteStringMicro) {
        this.f12665q = true;
        this.f12666r = byteStringMicro;
        return this;
    }

    public PoiResult setIndusInfo(PoiResult$IndusInfo poiResult$IndusInfo) {
        if (poiResult$IndusInfo == null) {
            return clearIndusInfo();
        }
        this.f12673y = true;
        this.f12674z = poiResult$IndusInfo;
        return this;
    }

    public PoiResult setOffline(int i) {
        this.f12667s = true;
        this.f12668t = i;
        return this;
    }

    public PoiResult setOption(PoiResult$Option poiResult$Option) {
        if (poiResult$Option == null) {
            return clearOption();
        }
        this.f12649a = true;
        this.f12650b = poiResult$Option;
        return this;
    }

    public PoiResult setPlaceInfo(PoiResult$PlaceInfo poiResult$PlaceInfo) {
        if (poiResult$PlaceInfo == null) {
            return clearPlaceInfo();
        }
        this.f12655g = true;
        this.f12656h = poiResult$PlaceInfo;
        return this;
    }

    public PoiResult setPreviousCity(PoiResult$PreviousCity poiResult$PreviousCity) {
        if (poiResult$PreviousCity == null) {
            return clearPreviousCity();
        }
        this.f12659k = true;
        this.f12660l = poiResult$PreviousCity;
        return this;
    }

    public PoiResult setPsrs(PoiResult$Psrs poiResult$Psrs) {
        if (poiResult$Psrs == null) {
            return clearPsrs();
        }
        this.f12652d = true;
        this.f12653e = poiResult$Psrs;
        return this;
    }

    public PoiResult setRecommend(PoiResult$Recommend poiResult$Recommend) {
        if (poiResult$Recommend == null) {
            return clearRecommend();
        }
        this.f12642A = true;
        this.f12643B = poiResult$Recommend;
        return this;
    }

    public PoiResult setSuggestQuery(int i, PoiResult$SuggestQuery poiResult$SuggestQuery) {
        if (poiResult$SuggestQuery != null) {
            this.f12654f.set(i, poiResult$SuggestQuery);
        }
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(1, getOption());
        }
        for (Addrs writeMessage : getAddrsList()) {
            codedOutputStreamMicro.writeMessage(2, writeMessage);
        }
        if (hasPsrs()) {
            codedOutputStreamMicro.writeMessage(3, getPsrs());
        }
        for (PoiResult$SuggestQuery writeMessage2 : getSuggestQueryList()) {
            codedOutputStreamMicro.writeMessage(4, writeMessage2);
        }
        if (hasPlaceInfo()) {
            codedOutputStreamMicro.writeMessage(5, getPlaceInfo());
        }
        for (Contents writeMessage3 : getContentsList()) {
            codedOutputStreamMicro.writeMessage(6, writeMessage3);
        }
        if (hasCurrentCity()) {
            codedOutputStreamMicro.writeMessage(7, getCurrentCity());
        }
        for (Children writeMessage4 : getChildrenList()) {
            codedOutputStreamMicro.writeMessage(8, writeMessage4);
        }
        if (hasPreviousCity()) {
            codedOutputStreamMicro.writeMessage(9, getPreviousCity());
        }
        if (hasBrandBar()) {
            codedOutputStreamMicro.writeMessage(10, getBrandBar());
        }
        if (hasImgeExt()) {
            codedOutputStreamMicro.writeBytes(11, getImgeExt());
        }
        if (hasOffline()) {
            codedOutputStreamMicro.writeInt32(12, getOffline());
        }
        for (PoiResult$GuideTag writeMessage5 : getGuideTagList()) {
            codedOutputStreamMicro.writeMessage(13, writeMessage5);
        }
        for (Ads writeMessage6 : getAdsList()) {
            codedOutputStreamMicro.writeMessage(14, writeMessage6);
        }
        if (hasAdsExtInfo()) {
            codedOutputStreamMicro.writeMessage(16, getAdsExtInfo());
        }
        if (hasIndusInfo()) {
            codedOutputStreamMicro.writeMessage(18, getIndusInfo());
        }
        if (hasRecommend()) {
            codedOutputStreamMicro.writeMessage(19, getRecommend());
        }
        if (hasCorrectionInfo()) {
            codedOutputStreamMicro.writeMessage(20, getCorrectionInfo());
        }
        if (hasCarPreload()) {
            codedOutputStreamMicro.writeInt32(21, getCarPreload());
        }
    }
}
