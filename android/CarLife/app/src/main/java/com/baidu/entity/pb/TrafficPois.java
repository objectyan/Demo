package com.baidu.entity.pb;

import com.baidu.baidunavis.model.NavCarInfo;
import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TrafficPois extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 3;
    public static final int CURRENT_CITY_FIELD_NUMBER = 2;
    public static final int IMGE_SHOW_FIELD_NUMBER = 6;
    public static final int OPTION_FIELD_NUMBER = 1;
    public static final int SUGGEST_QUERY_FIELD_NUMBER = 4;
    public static final int SUGGEST_QUERY_FLAG_FIELD_NUMBER = 5;
    /* renamed from: a */
    private boolean f16563a;
    /* renamed from: b */
    private Option f16564b = null;
    /* renamed from: c */
    private boolean f16565c;
    /* renamed from: d */
    private CurrentCity f16566d = null;
    /* renamed from: e */
    private boolean f16567e;
    /* renamed from: f */
    private Content f16568f = null;
    /* renamed from: g */
    private List<SuggestQuery> f16569g = Collections.emptyList();
    /* renamed from: h */
    private boolean f16570h;
    /* renamed from: i */
    private int f16571i = 0;
    /* renamed from: j */
    private boolean f16572j;
    /* renamed from: k */
    private ImageShow f16573k = null;
    /* renamed from: l */
    private int f16574l = -1;

    public static final class Content extends MessageMicro {
        public static final int END_FIELD_NUMBER = 2;
        public static final int MULTI_WAYPOINTS_FIELD_NUMBER = 4;
        public static final int START_FIELD_NUMBER = 1;
        public static final int WAY_POINTS_FIELD_NUMBER = 3;
        /* renamed from: a */
        private List<Start> f16528a = Collections.emptyList();
        /* renamed from: b */
        private List<End> f16529b = Collections.emptyList();
        /* renamed from: c */
        private List<WayPoints> f16530c = Collections.emptyList();
        /* renamed from: d */
        private List<MultiWaypoints> f16531d = Collections.emptyList();
        /* renamed from: e */
        private int f16532e = -1;

        public static final class End extends MessageMicro {
            public static final int ADDR_FIELD_NUMBER = 5;
            public static final int CODE_FIELD_NUMBER = 1;
            public static final int DESCRIBE_FIELD_NUMBER = 13;
            public static final int DIRECTION_FIELD_NUMBER = 12;
            public static final int DIST_FIELD_NUMBER = 11;
            public static final int EXT_FIELD_NUMBER = 7;
            public static final int GEO_FIELD_NUMBER = 6;
            public static final int INDOOR_FLOOR_FIELD_NUMBER = 9;
            public static final int INDOOR_PARENT_UID_FIELD_NUMBER = 10;
            public static final int NAME_FIELD_NUMBER = 2;
            public static final int NUM_FIELD_NUMBER = 3;
            public static final int POITYPE_FIELD_NUMBER = 8;
            public static final int UID_FIELD_NUMBER = 4;
            /* renamed from: A */
            private int f16444A = -1;
            /* renamed from: a */
            private boolean f16445a;
            /* renamed from: b */
            private int f16446b = 0;
            /* renamed from: c */
            private boolean f16447c;
            /* renamed from: d */
            private String f16448d = "";
            /* renamed from: e */
            private boolean f16449e;
            /* renamed from: f */
            private int f16450f = 0;
            /* renamed from: g */
            private boolean f16451g;
            /* renamed from: h */
            private String f16452h = "";
            /* renamed from: i */
            private boolean f16453i;
            /* renamed from: j */
            private String f16454j = "";
            /* renamed from: k */
            private boolean f16455k;
            /* renamed from: l */
            private String f16456l = "";
            /* renamed from: m */
            private boolean f16457m;
            /* renamed from: n */
            private String f16458n = "";
            /* renamed from: o */
            private boolean f16459o;
            /* renamed from: p */
            private int f16460p = 0;
            /* renamed from: q */
            private boolean f16461q;
            /* renamed from: r */
            private String f16462r = "";
            /* renamed from: s */
            private boolean f16463s;
            /* renamed from: t */
            private String f16464t = "";
            /* renamed from: u */
            private boolean f16465u;
            /* renamed from: v */
            private int f16466v = 0;
            /* renamed from: w */
            private boolean f16467w;
            /* renamed from: x */
            private int f16468x = 0;
            /* renamed from: y */
            private boolean f16469y;
            /* renamed from: z */
            private String f16470z = "";

            public static End parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new End().mergeFrom(codedInputStreamMicro);
            }

            public static End parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (End) new End().mergeFrom(bArr);
            }

            public final End clear() {
                clearCode();
                clearName();
                clearNum();
                clearUid();
                clearAddr();
                clearGeo();
                clearExt();
                clearPoiType();
                clearIndoorFloor();
                clearIndoorParentUid();
                clearDist();
                clearDirection();
                clearDescribe();
                this.f16444A = -1;
                return this;
            }

            public End clearAddr() {
                this.f16453i = false;
                this.f16454j = "";
                return this;
            }

            public End clearCode() {
                this.f16445a = false;
                this.f16446b = 0;
                return this;
            }

            public End clearDescribe() {
                this.f16469y = false;
                this.f16470z = "";
                return this;
            }

            public End clearDirection() {
                this.f16467w = false;
                this.f16468x = 0;
                return this;
            }

            public End clearDist() {
                this.f16465u = false;
                this.f16466v = 0;
                return this;
            }

            public End clearExt() {
                this.f16457m = false;
                this.f16458n = "";
                return this;
            }

            public End clearGeo() {
                this.f16455k = false;
                this.f16456l = "";
                return this;
            }

            public End clearIndoorFloor() {
                this.f16461q = false;
                this.f16462r = "";
                return this;
            }

            public End clearIndoorParentUid() {
                this.f16463s = false;
                this.f16464t = "";
                return this;
            }

            public End clearName() {
                this.f16447c = false;
                this.f16448d = "";
                return this;
            }

            public End clearNum() {
                this.f16449e = false;
                this.f16450f = 0;
                return this;
            }

            public End clearPoiType() {
                this.f16459o = false;
                this.f16460p = 0;
                return this;
            }

            public End clearUid() {
                this.f16451g = false;
                this.f16452h = "";
                return this;
            }

            public String getAddr() {
                return this.f16454j;
            }

            public int getCachedSize() {
                if (this.f16444A < 0) {
                    getSerializedSize();
                }
                return this.f16444A;
            }

            public int getCode() {
                return this.f16446b;
            }

            public String getDescribe() {
                return this.f16470z;
            }

            public int getDirection() {
                return this.f16468x;
            }

            public int getDist() {
                return this.f16466v;
            }

            public String getExt() {
                return this.f16458n;
            }

            public String getGeo() {
                return this.f16456l;
            }

            public String getIndoorFloor() {
                return this.f16462r;
            }

            public String getIndoorParentUid() {
                return this.f16464t;
            }

            public String getName() {
                return this.f16448d;
            }

            public int getNum() {
                return this.f16450f;
            }

            public int getPoiType() {
                return this.f16460p;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasCode()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
                }
                if (hasName()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getName());
                }
                if (hasNum()) {
                    i += CodedOutputStreamMicro.computeInt32Size(3, getNum());
                }
                if (hasUid()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getUid());
                }
                if (hasAddr()) {
                    i += CodedOutputStreamMicro.computeStringSize(5, getAddr());
                }
                if (hasGeo()) {
                    i += CodedOutputStreamMicro.computeStringSize(6, getGeo());
                }
                if (hasExt()) {
                    i += CodedOutputStreamMicro.computeStringSize(7, getExt());
                }
                if (hasPoiType()) {
                    i += CodedOutputStreamMicro.computeInt32Size(8, getPoiType());
                }
                if (hasIndoorFloor()) {
                    i += CodedOutputStreamMicro.computeStringSize(9, getIndoorFloor());
                }
                if (hasIndoorParentUid()) {
                    i += CodedOutputStreamMicro.computeStringSize(10, getIndoorParentUid());
                }
                if (hasDist()) {
                    i += CodedOutputStreamMicro.computeInt32Size(11, getDist());
                }
                if (hasDirection()) {
                    i += CodedOutputStreamMicro.computeInt32Size(12, getDirection());
                }
                if (hasDescribe()) {
                    i += CodedOutputStreamMicro.computeStringSize(13, getDescribe());
                }
                this.f16444A = i;
                return i;
            }

            public String getUid() {
                return this.f16452h;
            }

            public boolean hasAddr() {
                return this.f16453i;
            }

            public boolean hasCode() {
                return this.f16445a;
            }

            public boolean hasDescribe() {
                return this.f16469y;
            }

            public boolean hasDirection() {
                return this.f16467w;
            }

            public boolean hasDist() {
                return this.f16465u;
            }

            public boolean hasExt() {
                return this.f16457m;
            }

            public boolean hasGeo() {
                return this.f16455k;
            }

            public boolean hasIndoorFloor() {
                return this.f16461q;
            }

            public boolean hasIndoorParentUid() {
                return this.f16463s;
            }

            public boolean hasName() {
                return this.f16447c;
            }

            public boolean hasNum() {
                return this.f16449e;
            }

            public boolean hasPoiType() {
                return this.f16459o;
            }

            public boolean hasUid() {
                return this.f16451g;
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
                        case 8:
                            setCode(codedInputStreamMicro.readInt32());
                            continue;
                        case 18:
                            setName(codedInputStreamMicro.readString());
                            continue;
                        case 24:
                            setNum(codedInputStreamMicro.readInt32());
                            continue;
                        case 34:
                            setUid(codedInputStreamMicro.readString());
                            continue;
                        case 42:
                            setAddr(codedInputStreamMicro.readString());
                            continue;
                        case 50:
                            setGeo(codedInputStreamMicro.readString());
                            continue;
                        case 58:
                            setExt(codedInputStreamMicro.readString());
                            continue;
                        case 64:
                            setPoiType(codedInputStreamMicro.readInt32());
                            continue;
                        case 74:
                            setIndoorFloor(codedInputStreamMicro.readString());
                            continue;
                        case 82:
                            setIndoorParentUid(codedInputStreamMicro.readString());
                            continue;
                        case 88:
                            setDist(codedInputStreamMicro.readInt32());
                            continue;
                        case 96:
                            setDirection(codedInputStreamMicro.readInt32());
                            continue;
                        case 106:
                            setDescribe(codedInputStreamMicro.readString());
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

            public End setAddr(String str) {
                this.f16453i = true;
                this.f16454j = str;
                return this;
            }

            public End setCode(int i) {
                this.f16445a = true;
                this.f16446b = i;
                return this;
            }

            public End setDescribe(String str) {
                this.f16469y = true;
                this.f16470z = str;
                return this;
            }

            public End setDirection(int i) {
                this.f16467w = true;
                this.f16468x = i;
                return this;
            }

            public End setDist(int i) {
                this.f16465u = true;
                this.f16466v = i;
                return this;
            }

            public End setExt(String str) {
                this.f16457m = true;
                this.f16458n = str;
                return this;
            }

            public End setGeo(String str) {
                this.f16455k = true;
                this.f16456l = str;
                return this;
            }

            public End setIndoorFloor(String str) {
                this.f16461q = true;
                this.f16462r = str;
                return this;
            }

            public End setIndoorParentUid(String str) {
                this.f16463s = true;
                this.f16464t = str;
                return this;
            }

            public End setName(String str) {
                this.f16447c = true;
                this.f16448d = str;
                return this;
            }

            public End setNum(int i) {
                this.f16449e = true;
                this.f16450f = i;
                return this;
            }

            public End setPoiType(int i) {
                this.f16459o = true;
                this.f16460p = i;
                return this;
            }

            public End setUid(String str) {
                this.f16451g = true;
                this.f16452h = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasCode()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (hasName()) {
                    codedOutputStreamMicro.writeString(2, getName());
                }
                if (hasNum()) {
                    codedOutputStreamMicro.writeInt32(3, getNum());
                }
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(4, getUid());
                }
                if (hasAddr()) {
                    codedOutputStreamMicro.writeString(5, getAddr());
                }
                if (hasGeo()) {
                    codedOutputStreamMicro.writeString(6, getGeo());
                }
                if (hasExt()) {
                    codedOutputStreamMicro.writeString(7, getExt());
                }
                if (hasPoiType()) {
                    codedOutputStreamMicro.writeInt32(8, getPoiType());
                }
                if (hasIndoorFloor()) {
                    codedOutputStreamMicro.writeString(9, getIndoorFloor());
                }
                if (hasIndoorParentUid()) {
                    codedOutputStreamMicro.writeString(10, getIndoorParentUid());
                }
                if (hasDist()) {
                    codedOutputStreamMicro.writeInt32(11, getDist());
                }
                if (hasDirection()) {
                    codedOutputStreamMicro.writeInt32(12, getDirection());
                }
                if (hasDescribe()) {
                    codedOutputStreamMicro.writeString(13, getDescribe());
                }
            }
        }

        public static final class MultiWaypoints extends MessageMicro {
            public static final int WAY_POINTS_FIELD_NUMBER = 1;
            /* renamed from: a */
            private List<WayPoints> f16484a = Collections.emptyList();
            /* renamed from: b */
            private int f16485b = -1;

            public static final class WayPoints extends MessageMicro {
                public static final int ADDR_FIELD_NUMBER = 5;
                public static final int CODE_FIELD_NUMBER = 1;
                public static final int GEO_FIELD_NUMBER = 6;
                public static final int NAME_FIELD_NUMBER = 2;
                public static final int NUM_FIELD_NUMBER = 3;
                public static final int UID_FIELD_NUMBER = 4;
                /* renamed from: a */
                private boolean f16471a;
                /* renamed from: b */
                private int f16472b = 0;
                /* renamed from: c */
                private boolean f16473c;
                /* renamed from: d */
                private String f16474d = "";
                /* renamed from: e */
                private boolean f16475e;
                /* renamed from: f */
                private int f16476f = 0;
                /* renamed from: g */
                private boolean f16477g;
                /* renamed from: h */
                private String f16478h = "";
                /* renamed from: i */
                private boolean f16479i;
                /* renamed from: j */
                private String f16480j = "";
                /* renamed from: k */
                private boolean f16481k;
                /* renamed from: l */
                private String f16482l = "";
                /* renamed from: m */
                private int f16483m = -1;

                public static WayPoints parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new WayPoints().mergeFrom(codedInputStreamMicro);
                }

                public static WayPoints parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (WayPoints) new WayPoints().mergeFrom(bArr);
                }

                public final WayPoints clear() {
                    clearCode();
                    clearName();
                    clearNum();
                    clearUid();
                    clearAddr();
                    clearGeo();
                    this.f16483m = -1;
                    return this;
                }

                public WayPoints clearAddr() {
                    this.f16479i = false;
                    this.f16480j = "";
                    return this;
                }

                public WayPoints clearCode() {
                    this.f16471a = false;
                    this.f16472b = 0;
                    return this;
                }

                public WayPoints clearGeo() {
                    this.f16481k = false;
                    this.f16482l = "";
                    return this;
                }

                public WayPoints clearName() {
                    this.f16473c = false;
                    this.f16474d = "";
                    return this;
                }

                public WayPoints clearNum() {
                    this.f16475e = false;
                    this.f16476f = 0;
                    return this;
                }

                public WayPoints clearUid() {
                    this.f16477g = false;
                    this.f16478h = "";
                    return this;
                }

                public String getAddr() {
                    return this.f16480j;
                }

                public int getCachedSize() {
                    if (this.f16483m < 0) {
                        getSerializedSize();
                    }
                    return this.f16483m;
                }

                public int getCode() {
                    return this.f16472b;
                }

                public String getGeo() {
                    return this.f16482l;
                }

                public String getName() {
                    return this.f16474d;
                }

                public int getNum() {
                    return this.f16476f;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasCode()) {
                        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
                    }
                    if (hasName()) {
                        i += CodedOutputStreamMicro.computeStringSize(2, getName());
                    }
                    if (hasNum()) {
                        i += CodedOutputStreamMicro.computeInt32Size(3, getNum());
                    }
                    if (hasUid()) {
                        i += CodedOutputStreamMicro.computeStringSize(4, getUid());
                    }
                    if (hasAddr()) {
                        i += CodedOutputStreamMicro.computeStringSize(5, getAddr());
                    }
                    if (hasGeo()) {
                        i += CodedOutputStreamMicro.computeStringSize(6, getGeo());
                    }
                    this.f16483m = i;
                    return i;
                }

                public String getUid() {
                    return this.f16478h;
                }

                public boolean hasAddr() {
                    return this.f16479i;
                }

                public boolean hasCode() {
                    return this.f16471a;
                }

                public boolean hasGeo() {
                    return this.f16481k;
                }

                public boolean hasName() {
                    return this.f16473c;
                }

                public boolean hasNum() {
                    return this.f16475e;
                }

                public boolean hasUid() {
                    return this.f16477g;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public WayPoints mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                            case 24:
                                setNum(codedInputStreamMicro.readInt32());
                                continue;
                            case 34:
                                setUid(codedInputStreamMicro.readString());
                                continue;
                            case 42:
                                setAddr(codedInputStreamMicro.readString());
                                continue;
                            case 50:
                                setGeo(codedInputStreamMicro.readString());
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

                public WayPoints setAddr(String str) {
                    this.f16479i = true;
                    this.f16480j = str;
                    return this;
                }

                public WayPoints setCode(int i) {
                    this.f16471a = true;
                    this.f16472b = i;
                    return this;
                }

                public WayPoints setGeo(String str) {
                    this.f16481k = true;
                    this.f16482l = str;
                    return this;
                }

                public WayPoints setName(String str) {
                    this.f16473c = true;
                    this.f16474d = str;
                    return this;
                }

                public WayPoints setNum(int i) {
                    this.f16475e = true;
                    this.f16476f = i;
                    return this;
                }

                public WayPoints setUid(String str) {
                    this.f16477g = true;
                    this.f16478h = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasCode()) {
                        codedOutputStreamMicro.writeInt32(1, getCode());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(2, getName());
                    }
                    if (hasNum()) {
                        codedOutputStreamMicro.writeInt32(3, getNum());
                    }
                    if (hasUid()) {
                        codedOutputStreamMicro.writeString(4, getUid());
                    }
                    if (hasAddr()) {
                        codedOutputStreamMicro.writeString(5, getAddr());
                    }
                    if (hasGeo()) {
                        codedOutputStreamMicro.writeString(6, getGeo());
                    }
                }
            }

            public static MultiWaypoints parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new MultiWaypoints().mergeFrom(codedInputStreamMicro);
            }

            public static MultiWaypoints parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (MultiWaypoints) new MultiWaypoints().mergeFrom(bArr);
            }

            public MultiWaypoints addWayPoints(WayPoints wayPoints) {
                if (wayPoints != null) {
                    if (this.f16484a.isEmpty()) {
                        this.f16484a = new ArrayList();
                    }
                    this.f16484a.add(wayPoints);
                }
                return this;
            }

            public final MultiWaypoints clear() {
                clearWayPoints();
                this.f16485b = -1;
                return this;
            }

            public MultiWaypoints clearWayPoints() {
                this.f16484a = Collections.emptyList();
                return this;
            }

            public int getCachedSize() {
                if (this.f16485b < 0) {
                    getSerializedSize();
                }
                return this.f16485b;
            }

            public int getSerializedSize() {
                int i = 0;
                for (WayPoints computeMessageSize : getWayPointsList()) {
                    i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
                }
                this.f16485b = i;
                return i;
            }

            public WayPoints getWayPoints(int i) {
                return (WayPoints) this.f16484a.get(i);
            }

            public int getWayPointsCount() {
                return this.f16484a.size();
            }

            public List<WayPoints> getWayPointsList() {
                return this.f16484a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public MultiWaypoints mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            MessageMicro wayPoints = new WayPoints();
                            codedInputStreamMicro.readMessage(wayPoints);
                            addWayPoints(wayPoints);
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

            public MultiWaypoints setWayPoints(int i, WayPoints wayPoints) {
                if (wayPoints != null) {
                    this.f16484a.set(i, wayPoints);
                }
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                for (WayPoints writeMessage : getWayPointsList()) {
                    codedOutputStreamMicro.writeMessage(1, writeMessage);
                }
            }
        }

        public static final class Start extends MessageMicro {
            public static final int ADDR_FIELD_NUMBER = 5;
            public static final int CODE_FIELD_NUMBER = 1;
            public static final int DESCRIBE_FIELD_NUMBER = 9;
            public static final int GEO_FIELD_NUMBER = 6;
            public static final int INDOOR_FLOOR_FIELD_NUMBER = 7;
            public static final int INDOOR_PARENT_UID_FIELD_NUMBER = 8;
            public static final int NAME_FIELD_NUMBER = 2;
            public static final int NUM_FIELD_NUMBER = 3;
            public static final int UID_FIELD_NUMBER = 4;
            /* renamed from: a */
            private boolean f16486a;
            /* renamed from: b */
            private int f16487b = 0;
            /* renamed from: c */
            private boolean f16488c;
            /* renamed from: d */
            private String f16489d = "";
            /* renamed from: e */
            private boolean f16490e;
            /* renamed from: f */
            private int f16491f = 0;
            /* renamed from: g */
            private boolean f16492g;
            /* renamed from: h */
            private String f16493h = "";
            /* renamed from: i */
            private boolean f16494i;
            /* renamed from: j */
            private String f16495j = "";
            /* renamed from: k */
            private boolean f16496k;
            /* renamed from: l */
            private String f16497l = "";
            /* renamed from: m */
            private boolean f16498m;
            /* renamed from: n */
            private String f16499n = "";
            /* renamed from: o */
            private boolean f16500o;
            /* renamed from: p */
            private String f16501p = "";
            /* renamed from: q */
            private boolean f16502q;
            /* renamed from: r */
            private String f16503r = "";
            /* renamed from: s */
            private int f16504s = -1;

            public static Start parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Start().mergeFrom(codedInputStreamMicro);
            }

            public static Start parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Start) new Start().mergeFrom(bArr);
            }

            public final Start clear() {
                clearCode();
                clearName();
                clearNum();
                clearUid();
                clearAddr();
                clearGeo();
                clearIndoorFloor();
                clearIndoorParentUid();
                clearDescribe();
                this.f16504s = -1;
                return this;
            }

            public Start clearAddr() {
                this.f16494i = false;
                this.f16495j = "";
                return this;
            }

            public Start clearCode() {
                this.f16486a = false;
                this.f16487b = 0;
                return this;
            }

            public Start clearDescribe() {
                this.f16502q = false;
                this.f16503r = "";
                return this;
            }

            public Start clearGeo() {
                this.f16496k = false;
                this.f16497l = "";
                return this;
            }

            public Start clearIndoorFloor() {
                this.f16498m = false;
                this.f16499n = "";
                return this;
            }

            public Start clearIndoorParentUid() {
                this.f16500o = false;
                this.f16501p = "";
                return this;
            }

            public Start clearName() {
                this.f16488c = false;
                this.f16489d = "";
                return this;
            }

            public Start clearNum() {
                this.f16490e = false;
                this.f16491f = 0;
                return this;
            }

            public Start clearUid() {
                this.f16492g = false;
                this.f16493h = "";
                return this;
            }

            public String getAddr() {
                return this.f16495j;
            }

            public int getCachedSize() {
                if (this.f16504s < 0) {
                    getSerializedSize();
                }
                return this.f16504s;
            }

            public int getCode() {
                return this.f16487b;
            }

            public String getDescribe() {
                return this.f16503r;
            }

            public String getGeo() {
                return this.f16497l;
            }

            public String getIndoorFloor() {
                return this.f16499n;
            }

            public String getIndoorParentUid() {
                return this.f16501p;
            }

            public String getName() {
                return this.f16489d;
            }

            public int getNum() {
                return this.f16491f;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasCode()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
                }
                if (hasName()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getName());
                }
                if (hasNum()) {
                    i += CodedOutputStreamMicro.computeInt32Size(3, getNum());
                }
                if (hasUid()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getUid());
                }
                if (hasAddr()) {
                    i += CodedOutputStreamMicro.computeStringSize(5, getAddr());
                }
                if (hasGeo()) {
                    i += CodedOutputStreamMicro.computeStringSize(6, getGeo());
                }
                if (hasIndoorFloor()) {
                    i += CodedOutputStreamMicro.computeStringSize(7, getIndoorFloor());
                }
                if (hasIndoorParentUid()) {
                    i += CodedOutputStreamMicro.computeStringSize(8, getIndoorParentUid());
                }
                if (hasDescribe()) {
                    i += CodedOutputStreamMicro.computeStringSize(9, getDescribe());
                }
                this.f16504s = i;
                return i;
            }

            public String getUid() {
                return this.f16493h;
            }

            public boolean hasAddr() {
                return this.f16494i;
            }

            public boolean hasCode() {
                return this.f16486a;
            }

            public boolean hasDescribe() {
                return this.f16502q;
            }

            public boolean hasGeo() {
                return this.f16496k;
            }

            public boolean hasIndoorFloor() {
                return this.f16498m;
            }

            public boolean hasIndoorParentUid() {
                return this.f16500o;
            }

            public boolean hasName() {
                return this.f16488c;
            }

            public boolean hasNum() {
                return this.f16490e;
            }

            public boolean hasUid() {
                return this.f16492g;
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
                        case 8:
                            setCode(codedInputStreamMicro.readInt32());
                            continue;
                        case 18:
                            setName(codedInputStreamMicro.readString());
                            continue;
                        case 24:
                            setNum(codedInputStreamMicro.readInt32());
                            continue;
                        case 34:
                            setUid(codedInputStreamMicro.readString());
                            continue;
                        case 42:
                            setAddr(codedInputStreamMicro.readString());
                            continue;
                        case 50:
                            setGeo(codedInputStreamMicro.readString());
                            continue;
                        case 58:
                            setIndoorFloor(codedInputStreamMicro.readString());
                            continue;
                        case 66:
                            setIndoorParentUid(codedInputStreamMicro.readString());
                            continue;
                        case 74:
                            setDescribe(codedInputStreamMicro.readString());
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

            public Start setAddr(String str) {
                this.f16494i = true;
                this.f16495j = str;
                return this;
            }

            public Start setCode(int i) {
                this.f16486a = true;
                this.f16487b = i;
                return this;
            }

            public Start setDescribe(String str) {
                this.f16502q = true;
                this.f16503r = str;
                return this;
            }

            public Start setGeo(String str) {
                this.f16496k = true;
                this.f16497l = str;
                return this;
            }

            public Start setIndoorFloor(String str) {
                this.f16498m = true;
                this.f16499n = str;
                return this;
            }

            public Start setIndoorParentUid(String str) {
                this.f16500o = true;
                this.f16501p = str;
                return this;
            }

            public Start setName(String str) {
                this.f16488c = true;
                this.f16489d = str;
                return this;
            }

            public Start setNum(int i) {
                this.f16490e = true;
                this.f16491f = i;
                return this;
            }

            public Start setUid(String str) {
                this.f16492g = true;
                this.f16493h = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasCode()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (hasName()) {
                    codedOutputStreamMicro.writeString(2, getName());
                }
                if (hasNum()) {
                    codedOutputStreamMicro.writeInt32(3, getNum());
                }
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(4, getUid());
                }
                if (hasAddr()) {
                    codedOutputStreamMicro.writeString(5, getAddr());
                }
                if (hasGeo()) {
                    codedOutputStreamMicro.writeString(6, getGeo());
                }
                if (hasIndoorFloor()) {
                    codedOutputStreamMicro.writeString(7, getIndoorFloor());
                }
                if (hasIndoorParentUid()) {
                    codedOutputStreamMicro.writeString(8, getIndoorParentUid());
                }
                if (hasDescribe()) {
                    codedOutputStreamMicro.writeString(9, getDescribe());
                }
            }
        }

        public static final class WayPoints extends MessageMicro {
            public static final int ADDR_FIELD_NUMBER = 5;
            public static final int CODE_FIELD_NUMBER = 1;
            public static final int DESCRIBE_FIELD_NUMBER = 11;
            public static final int DIRECTION_FIELD_NUMBER = 10;
            public static final int DIST_FIELD_NUMBER = 9;
            public static final int GEO_FIELD_NUMBER = 6;
            public static final int INDOOR_FLOOR_FIELD_NUMBER = 7;
            public static final int INDOOR_PARENT_UID_FIELD_NUMBER = 8;
            public static final int NAME_FIELD_NUMBER = 2;
            public static final int NUM_FIELD_NUMBER = 3;
            public static final int UID_FIELD_NUMBER = 4;
            /* renamed from: a */
            private boolean f16505a;
            /* renamed from: b */
            private int f16506b = 0;
            /* renamed from: c */
            private boolean f16507c;
            /* renamed from: d */
            private String f16508d = "";
            /* renamed from: e */
            private boolean f16509e;
            /* renamed from: f */
            private int f16510f = 0;
            /* renamed from: g */
            private boolean f16511g;
            /* renamed from: h */
            private String f16512h = "";
            /* renamed from: i */
            private boolean f16513i;
            /* renamed from: j */
            private String f16514j = "";
            /* renamed from: k */
            private boolean f16515k;
            /* renamed from: l */
            private String f16516l = "";
            /* renamed from: m */
            private boolean f16517m;
            /* renamed from: n */
            private String f16518n = "";
            /* renamed from: o */
            private boolean f16519o;
            /* renamed from: p */
            private String f16520p = "";
            /* renamed from: q */
            private boolean f16521q;
            /* renamed from: r */
            private int f16522r = 0;
            /* renamed from: s */
            private boolean f16523s;
            /* renamed from: t */
            private int f16524t = 0;
            /* renamed from: u */
            private boolean f16525u;
            /* renamed from: v */
            private String f16526v = "";
            /* renamed from: w */
            private int f16527w = -1;

            public static WayPoints parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new WayPoints().mergeFrom(codedInputStreamMicro);
            }

            public static WayPoints parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (WayPoints) new WayPoints().mergeFrom(bArr);
            }

            public final WayPoints clear() {
                clearCode();
                clearName();
                clearNum();
                clearUid();
                clearAddr();
                clearGeo();
                clearIndoorFloor();
                clearIndoorParentUid();
                clearDist();
                clearDirection();
                clearDescribe();
                this.f16527w = -1;
                return this;
            }

            public WayPoints clearAddr() {
                this.f16513i = false;
                this.f16514j = "";
                return this;
            }

            public WayPoints clearCode() {
                this.f16505a = false;
                this.f16506b = 0;
                return this;
            }

            public WayPoints clearDescribe() {
                this.f16525u = false;
                this.f16526v = "";
                return this;
            }

            public WayPoints clearDirection() {
                this.f16523s = false;
                this.f16524t = 0;
                return this;
            }

            public WayPoints clearDist() {
                this.f16521q = false;
                this.f16522r = 0;
                return this;
            }

            public WayPoints clearGeo() {
                this.f16515k = false;
                this.f16516l = "";
                return this;
            }

            public WayPoints clearIndoorFloor() {
                this.f16517m = false;
                this.f16518n = "";
                return this;
            }

            public WayPoints clearIndoorParentUid() {
                this.f16519o = false;
                this.f16520p = "";
                return this;
            }

            public WayPoints clearName() {
                this.f16507c = false;
                this.f16508d = "";
                return this;
            }

            public WayPoints clearNum() {
                this.f16509e = false;
                this.f16510f = 0;
                return this;
            }

            public WayPoints clearUid() {
                this.f16511g = false;
                this.f16512h = "";
                return this;
            }

            public String getAddr() {
                return this.f16514j;
            }

            public int getCachedSize() {
                if (this.f16527w < 0) {
                    getSerializedSize();
                }
                return this.f16527w;
            }

            public int getCode() {
                return this.f16506b;
            }

            public String getDescribe() {
                return this.f16526v;
            }

            public int getDirection() {
                return this.f16524t;
            }

            public int getDist() {
                return this.f16522r;
            }

            public String getGeo() {
                return this.f16516l;
            }

            public String getIndoorFloor() {
                return this.f16518n;
            }

            public String getIndoorParentUid() {
                return this.f16520p;
            }

            public String getName() {
                return this.f16508d;
            }

            public int getNum() {
                return this.f16510f;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasCode()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
                }
                if (hasName()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getName());
                }
                if (hasNum()) {
                    i += CodedOutputStreamMicro.computeInt32Size(3, getNum());
                }
                if (hasUid()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getUid());
                }
                if (hasAddr()) {
                    i += CodedOutputStreamMicro.computeStringSize(5, getAddr());
                }
                if (hasGeo()) {
                    i += CodedOutputStreamMicro.computeStringSize(6, getGeo());
                }
                if (hasIndoorFloor()) {
                    i += CodedOutputStreamMicro.computeStringSize(7, getIndoorFloor());
                }
                if (hasIndoorParentUid()) {
                    i += CodedOutputStreamMicro.computeStringSize(8, getIndoorParentUid());
                }
                if (hasDist()) {
                    i += CodedOutputStreamMicro.computeInt32Size(9, getDist());
                }
                if (hasDirection()) {
                    i += CodedOutputStreamMicro.computeInt32Size(10, getDirection());
                }
                if (hasDescribe()) {
                    i += CodedOutputStreamMicro.computeStringSize(11, getDescribe());
                }
                this.f16527w = i;
                return i;
            }

            public String getUid() {
                return this.f16512h;
            }

            public boolean hasAddr() {
                return this.f16513i;
            }

            public boolean hasCode() {
                return this.f16505a;
            }

            public boolean hasDescribe() {
                return this.f16525u;
            }

            public boolean hasDirection() {
                return this.f16523s;
            }

            public boolean hasDist() {
                return this.f16521q;
            }

            public boolean hasGeo() {
                return this.f16515k;
            }

            public boolean hasIndoorFloor() {
                return this.f16517m;
            }

            public boolean hasIndoorParentUid() {
                return this.f16519o;
            }

            public boolean hasName() {
                return this.f16507c;
            }

            public boolean hasNum() {
                return this.f16509e;
            }

            public boolean hasUid() {
                return this.f16511g;
            }

            public final boolean isInitialized() {
                return true;
            }

            public WayPoints mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                        case 24:
                            setNum(codedInputStreamMicro.readInt32());
                            continue;
                        case 34:
                            setUid(codedInputStreamMicro.readString());
                            continue;
                        case 42:
                            setAddr(codedInputStreamMicro.readString());
                            continue;
                        case 50:
                            setGeo(codedInputStreamMicro.readString());
                            continue;
                        case 58:
                            setIndoorFloor(codedInputStreamMicro.readString());
                            continue;
                        case 66:
                            setIndoorParentUid(codedInputStreamMicro.readString());
                            continue;
                        case NavCarInfo.CarType_57L /*72*/:
                            setDist(codedInputStreamMicro.readInt32());
                            continue;
                        case 80:
                            setDirection(codedInputStreamMicro.readInt32());
                            continue;
                        case 90:
                            setDescribe(codedInputStreamMicro.readString());
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

            public WayPoints setAddr(String str) {
                this.f16513i = true;
                this.f16514j = str;
                return this;
            }

            public WayPoints setCode(int i) {
                this.f16505a = true;
                this.f16506b = i;
                return this;
            }

            public WayPoints setDescribe(String str) {
                this.f16525u = true;
                this.f16526v = str;
                return this;
            }

            public WayPoints setDirection(int i) {
                this.f16523s = true;
                this.f16524t = i;
                return this;
            }

            public WayPoints setDist(int i) {
                this.f16521q = true;
                this.f16522r = i;
                return this;
            }

            public WayPoints setGeo(String str) {
                this.f16515k = true;
                this.f16516l = str;
                return this;
            }

            public WayPoints setIndoorFloor(String str) {
                this.f16517m = true;
                this.f16518n = str;
                return this;
            }

            public WayPoints setIndoorParentUid(String str) {
                this.f16519o = true;
                this.f16520p = str;
                return this;
            }

            public WayPoints setName(String str) {
                this.f16507c = true;
                this.f16508d = str;
                return this;
            }

            public WayPoints setNum(int i) {
                this.f16509e = true;
                this.f16510f = i;
                return this;
            }

            public WayPoints setUid(String str) {
                this.f16511g = true;
                this.f16512h = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasCode()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (hasName()) {
                    codedOutputStreamMicro.writeString(2, getName());
                }
                if (hasNum()) {
                    codedOutputStreamMicro.writeInt32(3, getNum());
                }
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(4, getUid());
                }
                if (hasAddr()) {
                    codedOutputStreamMicro.writeString(5, getAddr());
                }
                if (hasGeo()) {
                    codedOutputStreamMicro.writeString(6, getGeo());
                }
                if (hasIndoorFloor()) {
                    codedOutputStreamMicro.writeString(7, getIndoorFloor());
                }
                if (hasIndoorParentUid()) {
                    codedOutputStreamMicro.writeString(8, getIndoorParentUid());
                }
                if (hasDist()) {
                    codedOutputStreamMicro.writeInt32(9, getDist());
                }
                if (hasDirection()) {
                    codedOutputStreamMicro.writeInt32(10, getDirection());
                }
                if (hasDescribe()) {
                    codedOutputStreamMicro.writeString(11, getDescribe());
                }
            }
        }

        public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Content().mergeFrom(codedInputStreamMicro);
        }

        public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Content) new Content().mergeFrom(bArr);
        }

        public Content addEnd(End end) {
            if (end != null) {
                if (this.f16529b.isEmpty()) {
                    this.f16529b = new ArrayList();
                }
                this.f16529b.add(end);
            }
            return this;
        }

        public Content addMultiWaypoints(MultiWaypoints multiWaypoints) {
            if (multiWaypoints != null) {
                if (this.f16531d.isEmpty()) {
                    this.f16531d = new ArrayList();
                }
                this.f16531d.add(multiWaypoints);
            }
            return this;
        }

        public Content addStart(Start start) {
            if (start != null) {
                if (this.f16528a.isEmpty()) {
                    this.f16528a = new ArrayList();
                }
                this.f16528a.add(start);
            }
            return this;
        }

        public Content addWayPoints(WayPoints wayPoints) {
            if (wayPoints != null) {
                if (this.f16530c.isEmpty()) {
                    this.f16530c = new ArrayList();
                }
                this.f16530c.add(wayPoints);
            }
            return this;
        }

        public final Content clear() {
            clearStart();
            clearEnd();
            clearWayPoints();
            clearMultiWaypoints();
            this.f16532e = -1;
            return this;
        }

        public Content clearEnd() {
            this.f16529b = Collections.emptyList();
            return this;
        }

        public Content clearMultiWaypoints() {
            this.f16531d = Collections.emptyList();
            return this;
        }

        public Content clearStart() {
            this.f16528a = Collections.emptyList();
            return this;
        }

        public Content clearWayPoints() {
            this.f16530c = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f16532e < 0) {
                getSerializedSize();
            }
            return this.f16532e;
        }

        public End getEnd(int i) {
            return (End) this.f16529b.get(i);
        }

        public int getEndCount() {
            return this.f16529b.size();
        }

        public List<End> getEndList() {
            return this.f16529b;
        }

        public MultiWaypoints getMultiWaypoints(int i) {
            return (MultiWaypoints) this.f16531d.get(i);
        }

        public int getMultiWaypointsCount() {
            return this.f16531d.size();
        }

        public List<MultiWaypoints> getMultiWaypointsList() {
            return this.f16531d;
        }

        public int getSerializedSize() {
            int i = 0;
            for (Start computeMessageSize : getStartList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            for (End computeMessageSize2 : getEndList()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize2);
            }
            for (WayPoints computeMessageSize3 : getWayPointsList()) {
                i += CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize3);
            }
            for (MultiWaypoints computeMessageSize4 : getMultiWaypointsList()) {
                i += CodedOutputStreamMicro.computeMessageSize(4, computeMessageSize4);
            }
            this.f16532e = i;
            return i;
        }

        public Start getStart(int i) {
            return (Start) this.f16528a.get(i);
        }

        public int getStartCount() {
            return this.f16528a.size();
        }

        public List<Start> getStartList() {
            return this.f16528a;
        }

        public WayPoints getWayPoints(int i) {
            return (WayPoints) this.f16530c.get(i);
        }

        public int getWayPointsCount() {
            return this.f16530c.size();
        }

        public List<WayPoints> getWayPointsList() {
            return this.f16530c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Content mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro start;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        start = new Start();
                        codedInputStreamMicro.readMessage(start);
                        addStart(start);
                        continue;
                    case 18:
                        start = new End();
                        codedInputStreamMicro.readMessage(start);
                        addEnd(start);
                        continue;
                    case 26:
                        start = new WayPoints();
                        codedInputStreamMicro.readMessage(start);
                        addWayPoints(start);
                        continue;
                    case 34:
                        start = new MultiWaypoints();
                        codedInputStreamMicro.readMessage(start);
                        addMultiWaypoints(start);
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

        public Content setEnd(int i, End end) {
            if (end != null) {
                this.f16529b.set(i, end);
            }
            return this;
        }

        public Content setMultiWaypoints(int i, MultiWaypoints multiWaypoints) {
            if (multiWaypoints != null) {
                this.f16531d.set(i, multiWaypoints);
            }
            return this;
        }

        public Content setStart(int i, Start start) {
            if (start != null) {
                this.f16528a.set(i, start);
            }
            return this;
        }

        public Content setWayPoints(int i, WayPoints wayPoints) {
            if (wayPoints != null) {
                this.f16530c.set(i, wayPoints);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (Start writeMessage : getStartList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
            for (End writeMessage2 : getEndList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage2);
            }
            for (WayPoints writeMessage3 : getWayPointsList()) {
                codedOutputStreamMicro.writeMessage(3, writeMessage3);
            }
            for (MultiWaypoints writeMessage4 : getMultiWaypointsList()) {
                codedOutputStreamMicro.writeMessage(4, writeMessage4);
            }
        }
    }

    public static final class ImageShow extends MessageMicro {
        public static final int IMAGE_EXT_FIELD_NUMBER = 1;
        public static final int RES_BOUND_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f16533a;
        /* renamed from: b */
        private ByteStringMicro f16534b = ByteStringMicro.EMPTY;
        /* renamed from: c */
        private boolean f16535c;
        /* renamed from: d */
        private String f16536d = "";
        /* renamed from: e */
        private int f16537e = -1;

        public static ImageShow parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ImageShow().mergeFrom(codedInputStreamMicro);
        }

        public static ImageShow parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ImageShow) new ImageShow().mergeFrom(bArr);
        }

        public final ImageShow clear() {
            clearImageExt();
            clearResBound();
            this.f16537e = -1;
            return this;
        }

        public ImageShow clearImageExt() {
            this.f16533a = false;
            this.f16534b = ByteStringMicro.EMPTY;
            return this;
        }

        public ImageShow clearResBound() {
            this.f16535c = false;
            this.f16536d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f16537e < 0) {
                getSerializedSize();
            }
            return this.f16537e;
        }

        public ByteStringMicro getImageExt() {
            return this.f16534b;
        }

        public String getResBound() {
            return this.f16536d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasImageExt()) {
                i = 0 + CodedOutputStreamMicro.computeBytesSize(1, getImageExt());
            }
            if (hasResBound()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getResBound());
            }
            this.f16537e = i;
            return i;
        }

        public boolean hasImageExt() {
            return this.f16533a;
        }

        public boolean hasResBound() {
            return this.f16535c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ImageShow mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setImageExt(codedInputStreamMicro.readBytes());
                        continue;
                    case 18:
                        setResBound(codedInputStreamMicro.readString());
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

        public ImageShow setImageExt(ByteStringMicro byteStringMicro) {
            this.f16533a = true;
            this.f16534b = byteStringMicro;
            return this;
        }

        public ImageShow setResBound(String str) {
            this.f16535c = true;
            this.f16536d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasImageExt()) {
                codedOutputStreamMicro.writeBytes(1, getImageExt());
            }
            if (hasResBound()) {
                codedOutputStreamMicro.writeString(2, getResBound());
            }
        }
    }

    public static final class Option extends MessageMicro {
        public static final int CITY_LIST_FIELD_NUMBER = 1;
        public static final int END_CITY_FIELD_NUMBER = 8;
        public static final int E_WD_FIELD_NUMBER = 5;
        public static final int IF_NAV_FIELD_NUMBER = 6;
        public static final int PRIO_FLAG_FIELD_NUMBER = 2;
        public static final int START_CITY_FIELD_NUMBER = 7;
        public static final int S_WD_FIELD_NUMBER = 4;
        public static final int WP_WD_FIELD_NUMBER = 3;
        /* renamed from: a */
        private List<String> f16548a = Collections.emptyList();
        /* renamed from: b */
        private List<String> f16549b = Collections.emptyList();
        /* renamed from: c */
        private List<String> f16550c = Collections.emptyList();
        /* renamed from: d */
        private boolean f16551d;
        /* renamed from: e */
        private String f16552e = "";
        /* renamed from: f */
        private List<String> f16553f = Collections.emptyList();
        /* renamed from: g */
        private boolean f16554g;
        /* renamed from: h */
        private boolean f16555h = false;
        /* renamed from: i */
        private boolean f16556i;
        /* renamed from: j */
        private StartCity f16557j = null;
        /* renamed from: k */
        private List<EndCity> f16558k = Collections.emptyList();
        /* renamed from: l */
        private int f16559l = -1;

        public static final class EndCity extends MessageMicro {
            public static final int CNAME_FIELD_NUMBER = 2;
            public static final int CODE_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f16538a;
            /* renamed from: b */
            private int f16539b = 0;
            /* renamed from: c */
            private boolean f16540c;
            /* renamed from: d */
            private String f16541d = "";
            /* renamed from: e */
            private int f16542e = -1;

            public static EndCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new EndCity().mergeFrom(codedInputStreamMicro);
            }

            public static EndCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (EndCity) new EndCity().mergeFrom(bArr);
            }

            public final EndCity clear() {
                clearCode();
                clearCname();
                this.f16542e = -1;
                return this;
            }

            public EndCity clearCname() {
                this.f16540c = false;
                this.f16541d = "";
                return this;
            }

            public EndCity clearCode() {
                this.f16538a = false;
                this.f16539b = 0;
                return this;
            }

            public int getCachedSize() {
                if (this.f16542e < 0) {
                    getSerializedSize();
                }
                return this.f16542e;
            }

            public String getCname() {
                return this.f16541d;
            }

            public int getCode() {
                return this.f16539b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasCode()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
                }
                if (hasCname()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.f16542e = i;
                return i;
            }

            public boolean hasCname() {
                return this.f16540c;
            }

            public boolean hasCode() {
                return this.f16538a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public EndCity mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            setCode(codedInputStreamMicro.readInt32());
                            continue;
                        case 18:
                            setCname(codedInputStreamMicro.readString());
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

            public EndCity setCname(String str) {
                this.f16540c = true;
                this.f16541d = str;
                return this;
            }

            public EndCity setCode(int i) {
                this.f16538a = true;
                this.f16539b = i;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasCode()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (hasCname()) {
                    codedOutputStreamMicro.writeString(2, getCname());
                }
            }
        }

        public static final class StartCity extends MessageMicro {
            public static final int CNAME_FIELD_NUMBER = 2;
            public static final int CODE_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f16543a;
            /* renamed from: b */
            private int f16544b = 0;
            /* renamed from: c */
            private boolean f16545c;
            /* renamed from: d */
            private String f16546d = "";
            /* renamed from: e */
            private int f16547e = -1;

            public static StartCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new StartCity().mergeFrom(codedInputStreamMicro);
            }

            public static StartCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (StartCity) new StartCity().mergeFrom(bArr);
            }

            public final StartCity clear() {
                clearCode();
                clearCname();
                this.f16547e = -1;
                return this;
            }

            public StartCity clearCname() {
                this.f16545c = false;
                this.f16546d = "";
                return this;
            }

            public StartCity clearCode() {
                this.f16543a = false;
                this.f16544b = 0;
                return this;
            }

            public int getCachedSize() {
                if (this.f16547e < 0) {
                    getSerializedSize();
                }
                return this.f16547e;
            }

            public String getCname() {
                return this.f16546d;
            }

            public int getCode() {
                return this.f16544b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasCode()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
                }
                if (hasCname()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.f16547e = i;
                return i;
            }

            public boolean hasCname() {
                return this.f16545c;
            }

            public boolean hasCode() {
                return this.f16543a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public StartCity mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            setCode(codedInputStreamMicro.readInt32());
                            continue;
                        case 18:
                            setCname(codedInputStreamMicro.readString());
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

            public StartCity setCname(String str) {
                this.f16545c = true;
                this.f16546d = str;
                return this;
            }

            public StartCity setCode(int i) {
                this.f16543a = true;
                this.f16544b = i;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasCode()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (hasCname()) {
                    codedOutputStreamMicro.writeString(2, getCname());
                }
            }
        }

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }

        public Option addCityList(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f16548a.isEmpty()) {
                this.f16548a = new ArrayList();
            }
            this.f16548a.add(str);
            return this;
        }

        public Option addEWd(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f16553f.isEmpty()) {
                this.f16553f = new ArrayList();
            }
            this.f16553f.add(str);
            return this;
        }

        public Option addEndCity(EndCity endCity) {
            if (endCity != null) {
                if (this.f16558k.isEmpty()) {
                    this.f16558k = new ArrayList();
                }
                this.f16558k.add(endCity);
            }
            return this;
        }

        public Option addPrioFlag(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f16549b.isEmpty()) {
                this.f16549b = new ArrayList();
            }
            this.f16549b.add(str);
            return this;
        }

        public Option addWpWd(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f16550c.isEmpty()) {
                this.f16550c = new ArrayList();
            }
            this.f16550c.add(str);
            return this;
        }

        public final Option clear() {
            clearCityList();
            clearPrioFlag();
            clearWpWd();
            clearSWd();
            clearEWd();
            clearIfNav();
            clearStartCity();
            clearEndCity();
            this.f16559l = -1;
            return this;
        }

        public Option clearCityList() {
            this.f16548a = Collections.emptyList();
            return this;
        }

        public Option clearEWd() {
            this.f16553f = Collections.emptyList();
            return this;
        }

        public Option clearEndCity() {
            this.f16558k = Collections.emptyList();
            return this;
        }

        public Option clearIfNav() {
            this.f16554g = false;
            this.f16555h = false;
            return this;
        }

        public Option clearPrioFlag() {
            this.f16549b = Collections.emptyList();
            return this;
        }

        public Option clearSWd() {
            this.f16551d = false;
            this.f16552e = "";
            return this;
        }

        public Option clearStartCity() {
            this.f16556i = false;
            this.f16557j = null;
            return this;
        }

        public Option clearWpWd() {
            this.f16550c = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f16559l < 0) {
                getSerializedSize();
            }
            return this.f16559l;
        }

        public String getCityList(int i) {
            return (String) this.f16548a.get(i);
        }

        public int getCityListCount() {
            return this.f16548a.size();
        }

        public List<String> getCityListList() {
            return this.f16548a;
        }

        public String getEWd(int i) {
            return (String) this.f16553f.get(i);
        }

        public int getEWdCount() {
            return this.f16553f.size();
        }

        public List<String> getEWdList() {
            return this.f16553f;
        }

        public EndCity getEndCity(int i) {
            return (EndCity) this.f16558k.get(i);
        }

        public int getEndCityCount() {
            return this.f16558k.size();
        }

        public List<EndCity> getEndCityList() {
            return this.f16558k;
        }

        public boolean getIfNav() {
            return this.f16555h;
        }

        public String getPrioFlag(int i) {
            return (String) this.f16549b.get(i);
        }

        public int getPrioFlagCount() {
            return this.f16549b.size();
        }

        public List<String> getPrioFlagList() {
            return this.f16549b;
        }

        public String getSWd() {
            return this.f16552e;
        }

        public int getSerializedSize() {
            int i = 0;
            int i2 = 0;
            for (String computeStringSizeNoTag : getCityListList()) {
                i2 = CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag) + i2;
            }
            int size = (0 + i2) + (getCityListList().size() * 1);
            i2 = 0;
            for (String computeStringSizeNoTag2 : getPrioFlagList()) {
                i2 = CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag2) + i2;
            }
            size = (size + i2) + (getPrioFlagList().size() * 1);
            i2 = 0;
            for (String computeStringSizeNoTag22 : getWpWdList()) {
                i2 = CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag22) + i2;
            }
            int size2 = (size + i2) + (getWpWdList().size() * 1);
            i2 = hasSWd() ? size2 + CodedOutputStreamMicro.computeStringSize(4, getSWd()) : size2;
            for (String computeStringSizeNoTag222 : getEWdList()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag222);
            }
            size2 = (i2 + i) + (getEWdList().size() * 1);
            if (hasIfNav()) {
                size2 += CodedOutputStreamMicro.computeBoolSize(6, getIfNav());
            }
            if (hasStartCity()) {
                size2 += CodedOutputStreamMicro.computeMessageSize(7, getStartCity());
            }
            i2 = size2;
            for (EndCity computeMessageSize : getEndCityList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(8, computeMessageSize) + i2;
            }
            this.f16559l = i2;
            return i2;
        }

        public StartCity getStartCity() {
            return this.f16557j;
        }

        public String getWpWd(int i) {
            return (String) this.f16550c.get(i);
        }

        public int getWpWdCount() {
            return this.f16550c.size();
        }

        public List<String> getWpWdList() {
            return this.f16550c;
        }

        public boolean hasIfNav() {
            return this.f16554g;
        }

        public boolean hasSWd() {
            return this.f16551d;
        }

        public boolean hasStartCity() {
            return this.f16556i;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Option mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro startCity;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        addCityList(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        addPrioFlag(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        addWpWd(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setSWd(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        addEWd(codedInputStreamMicro.readString());
                        continue;
                    case 48:
                        setIfNav(codedInputStreamMicro.readBool());
                        continue;
                    case 58:
                        startCity = new StartCity();
                        codedInputStreamMicro.readMessage(startCity);
                        setStartCity(startCity);
                        continue;
                    case 66:
                        startCity = new EndCity();
                        codedInputStreamMicro.readMessage(startCity);
                        addEndCity(startCity);
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

        public Option setCityList(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f16548a.set(i, str);
            return this;
        }

        public Option setEWd(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f16553f.set(i, str);
            return this;
        }

        public Option setEndCity(int i, EndCity endCity) {
            if (endCity != null) {
                this.f16558k.set(i, endCity);
            }
            return this;
        }

        public Option setIfNav(boolean z) {
            this.f16554g = true;
            this.f16555h = z;
            return this;
        }

        public Option setPrioFlag(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f16549b.set(i, str);
            return this;
        }

        public Option setSWd(String str) {
            this.f16551d = true;
            this.f16552e = str;
            return this;
        }

        public Option setStartCity(StartCity startCity) {
            if (startCity == null) {
                return clearStartCity();
            }
            this.f16556i = true;
            this.f16557j = startCity;
            return this;
        }

        public Option setWpWd(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f16550c.set(i, str);
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (String writeString : getCityListList()) {
                codedOutputStreamMicro.writeString(1, writeString);
            }
            for (String writeString2 : getPrioFlagList()) {
                codedOutputStreamMicro.writeString(2, writeString2);
            }
            for (String writeString22 : getWpWdList()) {
                codedOutputStreamMicro.writeString(3, writeString22);
            }
            if (hasSWd()) {
                codedOutputStreamMicro.writeString(4, getSWd());
            }
            for (String writeString222 : getEWdList()) {
                codedOutputStreamMicro.writeString(5, writeString222);
            }
            if (hasIfNav()) {
                codedOutputStreamMicro.writeBool(6, getIfNav());
            }
            if (hasStartCity()) {
                codedOutputStreamMicro.writeMessage(7, getStartCity());
            }
            for (EndCity writeMessage : getEndCityList()) {
                codedOutputStreamMicro.writeMessage(8, writeMessage);
            }
        }
    }

    public static final class SuggestQuery extends MessageMicro {
        public static final int QUERY_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f16560a;
        /* renamed from: b */
        private String f16561b = "";
        /* renamed from: c */
        private int f16562c = -1;

        public static SuggestQuery parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new SuggestQuery().mergeFrom(codedInputStreamMicro);
        }

        public static SuggestQuery parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (SuggestQuery) new SuggestQuery().mergeFrom(bArr);
        }

        public final SuggestQuery clear() {
            clearQuery();
            this.f16562c = -1;
            return this;
        }

        public SuggestQuery clearQuery() {
            this.f16560a = false;
            this.f16561b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f16562c < 0) {
                getSerializedSize();
            }
            return this.f16562c;
        }

        public String getQuery() {
            return this.f16561b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasQuery()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getQuery());
            }
            this.f16562c = i;
            return i;
        }

        public boolean hasQuery() {
            return this.f16560a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public SuggestQuery mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setQuery(codedInputStreamMicro.readString());
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

        public SuggestQuery setQuery(String str) {
            this.f16560a = true;
            this.f16561b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasQuery()) {
                codedOutputStreamMicro.writeString(1, getQuery());
            }
        }
    }

    public static TrafficPois parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new TrafficPois().mergeFrom(codedInputStreamMicro);
    }

    public static TrafficPois parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (TrafficPois) new TrafficPois().mergeFrom(bArr);
    }

    public TrafficPois addSuggestQuery(SuggestQuery suggestQuery) {
        if (suggestQuery != null) {
            if (this.f16569g.isEmpty()) {
                this.f16569g = new ArrayList();
            }
            this.f16569g.add(suggestQuery);
        }
        return this;
    }

    public final TrafficPois clear() {
        clearOption();
        clearCurrentCity();
        clearContent();
        clearSuggestQuery();
        clearSuggestQueryFlag();
        clearImgeShow();
        this.f16574l = -1;
        return this;
    }

    public TrafficPois clearContent() {
        this.f16567e = false;
        this.f16568f = null;
        return this;
    }

    public TrafficPois clearCurrentCity() {
        this.f16565c = false;
        this.f16566d = null;
        return this;
    }

    public TrafficPois clearImgeShow() {
        this.f16572j = false;
        this.f16573k = null;
        return this;
    }

    public TrafficPois clearOption() {
        this.f16563a = false;
        this.f16564b = null;
        return this;
    }

    public TrafficPois clearSuggestQuery() {
        this.f16569g = Collections.emptyList();
        return this;
    }

    public TrafficPois clearSuggestQueryFlag() {
        this.f16570h = false;
        this.f16571i = 0;
        return this;
    }

    public int getCachedSize() {
        if (this.f16574l < 0) {
            getSerializedSize();
        }
        return this.f16574l;
    }

    public Content getContent() {
        return this.f16568f;
    }

    public CurrentCity getCurrentCity() {
        return this.f16566d;
    }

    public ImageShow getImgeShow() {
        return this.f16573k;
    }

    public Option getOption() {
        return this.f16564b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasOption()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
        }
        if (hasCurrentCity()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getCurrentCity());
        }
        if (hasContent()) {
            i += CodedOutputStreamMicro.computeMessageSize(3, getContent());
        }
        int i2 = i;
        for (SuggestQuery computeMessageSize : getSuggestQueryList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(4, computeMessageSize) + i2;
        }
        if (hasSuggestQueryFlag()) {
            i2 += CodedOutputStreamMicro.computeInt32Size(5, getSuggestQueryFlag());
        }
        if (hasImgeShow()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(6, getImgeShow());
        }
        this.f16574l = i2;
        return i2;
    }

    public SuggestQuery getSuggestQuery(int i) {
        return (SuggestQuery) this.f16569g.get(i);
    }

    public int getSuggestQueryCount() {
        return this.f16569g.size();
    }

    public int getSuggestQueryFlag() {
        return this.f16571i;
    }

    public List<SuggestQuery> getSuggestQueryList() {
        return this.f16569g;
    }

    public boolean hasContent() {
        return this.f16567e;
    }

    public boolean hasCurrentCity() {
        return this.f16565c;
    }

    public boolean hasImgeShow() {
        return this.f16572j;
    }

    public boolean hasOption() {
        return this.f16563a;
    }

    public boolean hasSuggestQueryFlag() {
        return this.f16570h;
    }

    public final boolean isInitialized() {
        return true;
    }

    public TrafficPois mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                    option = new CurrentCity();
                    codedInputStreamMicro.readMessage(option);
                    setCurrentCity(option);
                    continue;
                case 26:
                    option = new Content();
                    codedInputStreamMicro.readMessage(option);
                    setContent(option);
                    continue;
                case 34:
                    option = new SuggestQuery();
                    codedInputStreamMicro.readMessage(option);
                    addSuggestQuery(option);
                    continue;
                case 40:
                    setSuggestQueryFlag(codedInputStreamMicro.readInt32());
                    continue;
                case 50:
                    option = new ImageShow();
                    codedInputStreamMicro.readMessage(option);
                    setImgeShow(option);
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

    public TrafficPois setContent(Content content) {
        if (content == null) {
            return clearContent();
        }
        this.f16567e = true;
        this.f16568f = content;
        return this;
    }

    public TrafficPois setCurrentCity(CurrentCity currentCity) {
        if (currentCity == null) {
            return clearCurrentCity();
        }
        this.f16565c = true;
        this.f16566d = currentCity;
        return this;
    }

    public TrafficPois setImgeShow(ImageShow imageShow) {
        if (imageShow == null) {
            return clearImgeShow();
        }
        this.f16572j = true;
        this.f16573k = imageShow;
        return this;
    }

    public TrafficPois setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f16563a = true;
        this.f16564b = option;
        return this;
    }

    public TrafficPois setSuggestQuery(int i, SuggestQuery suggestQuery) {
        if (suggestQuery != null) {
            this.f16569g.set(i, suggestQuery);
        }
        return this;
    }

    public TrafficPois setSuggestQueryFlag(int i) {
        this.f16570h = true;
        this.f16571i = i;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(1, getOption());
        }
        if (hasCurrentCity()) {
            codedOutputStreamMicro.writeMessage(2, getCurrentCity());
        }
        if (hasContent()) {
            codedOutputStreamMicro.writeMessage(3, getContent());
        }
        for (SuggestQuery writeMessage : getSuggestQueryList()) {
            codedOutputStreamMicro.writeMessage(4, writeMessage);
        }
        if (hasSuggestQueryFlag()) {
            codedOutputStreamMicro.writeInt32(5, getSuggestQueryFlag());
        }
        if (hasImgeShow()) {
            codedOutputStreamMicro.writeMessage(6, getImgeShow());
        }
    }
}
