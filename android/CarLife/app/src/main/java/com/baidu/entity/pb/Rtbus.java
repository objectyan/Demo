package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Rtbus extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 2;
    public static final int OPTION_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f14375a;
    /* renamed from: b */
    private Option f14376b = null;
    /* renamed from: c */
    private boolean f14377c;
    /* renamed from: d */
    private Content f14378d = null;
    /* renamed from: e */
    private int f14379e = -1;

    public static final class Content extends MessageMicro {
        public static final int RTBUS_NU_FIELD_NUMBER = 1;
        public static final int RTBUS_UPDATE_TIME_FIELD_NUMBER = 2;
        public static final int RTBUS_VERSION_FIELD_NUMBER = 3;
        public static final int STATIONS_FIELD_NUMBER = 4;
        /* renamed from: a */
        private boolean f14364a;
        /* renamed from: b */
        private int f14365b = 0;
        /* renamed from: c */
        private boolean f14366c;
        /* renamed from: d */
        private int f14367d = 0;
        /* renamed from: e */
        private boolean f14368e;
        /* renamed from: f */
        private int f14369f = 0;
        /* renamed from: g */
        private List<Station> f14370g = Collections.emptyList();
        /* renamed from: h */
        private int f14371h = -1;

        public static final class Station extends MessageMicro {
            public static final int IMAGE_TIP_RTBUS_FIELD_NUMBER = 6;
            public static final int LINE_FIELD_NUMBER = 4;
            public static final int NAME_FIELD_NUMBER = 2;
            public static final int NEXT_BUS_INFO_FIELD_NUMBER = 5;
            public static final int TIP_RTBUS_FIELD_NUMBER = 3;
            public static final int UID_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f14351a;
            /* renamed from: b */
            private String f14352b = "";
            /* renamed from: c */
            private boolean f14353c;
            /* renamed from: d */
            private String f14354d = "";
            /* renamed from: e */
            private boolean f14355e;
            /* renamed from: f */
            private String f14356f = "";
            /* renamed from: g */
            private boolean f14357g;
            /* renamed from: h */
            private Line f14358h = null;
            /* renamed from: i */
            private boolean f14359i;
            /* renamed from: j */
            private NextBusInfo f14360j = null;
            /* renamed from: k */
            private boolean f14361k;
            /* renamed from: l */
            private String f14362l = "";
            /* renamed from: m */
            private int f14363m = -1;

            public static final class Line extends MessageMicro {
                public static final int NAME_FIELD_NUMBER = 2;
                public static final int RAW_NAME_FIELD_NUMBER = 3;
                public static final int UID_FIELD_NUMBER = 1;
                /* renamed from: a */
                private boolean f14332a;
                /* renamed from: b */
                private String f14333b = "";
                /* renamed from: c */
                private boolean f14334c;
                /* renamed from: d */
                private String f14335d = "";
                /* renamed from: e */
                private boolean f14336e;
                /* renamed from: f */
                private String f14337f = "";
                /* renamed from: g */
                private int f14338g = -1;

                public static Line parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Line().mergeFrom(codedInputStreamMicro);
                }

                public static Line parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Line) new Line().mergeFrom(bArr);
                }

                public final Line clear() {
                    clearUid();
                    clearName();
                    clearRawName();
                    this.f14338g = -1;
                    return this;
                }

                public Line clearName() {
                    this.f14334c = false;
                    this.f14335d = "";
                    return this;
                }

                public Line clearRawName() {
                    this.f14336e = false;
                    this.f14337f = "";
                    return this;
                }

                public Line clearUid() {
                    this.f14332a = false;
                    this.f14333b = "";
                    return this;
                }

                public int getCachedSize() {
                    if (this.f14338g < 0) {
                        getSerializedSize();
                    }
                    return this.f14338g;
                }

                public String getName() {
                    return this.f14335d;
                }

                public String getRawName() {
                    return this.f14337f;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasUid()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUid());
                    }
                    if (hasName()) {
                        i += CodedOutputStreamMicro.computeStringSize(2, getName());
                    }
                    if (hasRawName()) {
                        i += CodedOutputStreamMicro.computeStringSize(3, getRawName());
                    }
                    this.f14338g = i;
                    return i;
                }

                public String getUid() {
                    return this.f14333b;
                }

                public boolean hasName() {
                    return this.f14334c;
                }

                public boolean hasRawName() {
                    return this.f14336e;
                }

                public boolean hasUid() {
                    return this.f14332a;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Line mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                                setRawName(codedInputStreamMicro.readString());
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

                public Line setName(String str) {
                    this.f14334c = true;
                    this.f14335d = str;
                    return this;
                }

                public Line setRawName(String str) {
                    this.f14336e = true;
                    this.f14337f = str;
                    return this;
                }

                public Line setUid(String str) {
                    this.f14332a = true;
                    this.f14333b = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasUid()) {
                        codedOutputStreamMicro.writeString(1, getUid());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(2, getName());
                    }
                    if (hasRawName()) {
                        codedOutputStreamMicro.writeString(3, getRawName());
                    }
                }
            }

            public static final class NextBusInfo extends MessageMicro {
                public static final int REMAIN_DIST_FIELD_NUMBER = 1;
                public static final int REMAIN_STOPS_FIELD_NUMBER = 2;
                public static final int REMAIN_TIME_FIELD_NUMBER = 3;
                public static final int SPATH_FIELD_NUMBER = 6;
                public static final int X_FIELD_NUMBER = 4;
                public static final int Y_FIELD_NUMBER = 5;
                /* renamed from: a */
                private boolean f14339a;
                /* renamed from: b */
                private int f14340b = 0;
                /* renamed from: c */
                private boolean f14341c;
                /* renamed from: d */
                private int f14342d = 0;
                /* renamed from: e */
                private boolean f14343e;
                /* renamed from: f */
                private int f14344f = 0;
                /* renamed from: g */
                private boolean f14345g;
                /* renamed from: h */
                private int f14346h = 0;
                /* renamed from: i */
                private boolean f14347i;
                /* renamed from: j */
                private int f14348j = 0;
                /* renamed from: k */
                private List<Integer> f14349k = Collections.emptyList();
                /* renamed from: l */
                private int f14350l = -1;

                public static NextBusInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new NextBusInfo().mergeFrom(codedInputStreamMicro);
                }

                public static NextBusInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (NextBusInfo) new NextBusInfo().mergeFrom(bArr);
                }

                public NextBusInfo addSpath(int i) {
                    if (this.f14349k.isEmpty()) {
                        this.f14349k = new ArrayList();
                    }
                    this.f14349k.add(Integer.valueOf(i));
                    return this;
                }

                public final NextBusInfo clear() {
                    clearRemainDist();
                    clearRemainStops();
                    clearRemainTime();
                    clearX();
                    clearY();
                    clearSpath();
                    this.f14350l = -1;
                    return this;
                }

                public NextBusInfo clearRemainDist() {
                    this.f14339a = false;
                    this.f14340b = 0;
                    return this;
                }

                public NextBusInfo clearRemainStops() {
                    this.f14341c = false;
                    this.f14342d = 0;
                    return this;
                }

                public NextBusInfo clearRemainTime() {
                    this.f14343e = false;
                    this.f14344f = 0;
                    return this;
                }

                public NextBusInfo clearSpath() {
                    this.f14349k = Collections.emptyList();
                    return this;
                }

                public NextBusInfo clearX() {
                    this.f14345g = false;
                    this.f14346h = 0;
                    return this;
                }

                public NextBusInfo clearY() {
                    this.f14347i = false;
                    this.f14348j = 0;
                    return this;
                }

                public int getCachedSize() {
                    if (this.f14350l < 0) {
                        getSerializedSize();
                    }
                    return this.f14350l;
                }

                public int getRemainDist() {
                    return this.f14340b;
                }

                public int getRemainStops() {
                    return this.f14342d;
                }

                public int getRemainTime() {
                    return this.f14344f;
                }

                public int getSerializedSize() {
                    int i = 0;
                    int computeInt32Size = hasRemainDist() ? CodedOutputStreamMicro.computeInt32Size(1, getRemainDist()) + 0 : 0;
                    if (hasRemainStops()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getRemainStops());
                    }
                    if (hasRemainTime()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getRemainTime());
                    }
                    if (hasX()) {
                        computeInt32Size += CodedOutputStreamMicro.computeSInt32Size(4, getX());
                    }
                    int computeSInt32Size = hasY() ? computeInt32Size + CodedOutputStreamMicro.computeSInt32Size(5, getY()) : computeInt32Size;
                    for (Integer intValue : getSpathList()) {
                        i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue());
                    }
                    computeInt32Size = (computeSInt32Size + i) + (getSpathList().size() * 1);
                    this.f14350l = computeInt32Size;
                    return computeInt32Size;
                }

                public int getSpath(int i) {
                    return ((Integer) this.f14349k.get(i)).intValue();
                }

                public int getSpathCount() {
                    return this.f14349k.size();
                }

                public List<Integer> getSpathList() {
                    return this.f14349k;
                }

                public int getX() {
                    return this.f14346h;
                }

                public int getY() {
                    return this.f14348j;
                }

                public boolean hasRemainDist() {
                    return this.f14339a;
                }

                public boolean hasRemainStops() {
                    return this.f14341c;
                }

                public boolean hasRemainTime() {
                    return this.f14343e;
                }

                public boolean hasX() {
                    return this.f14345g;
                }

                public boolean hasY() {
                    return this.f14347i;
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
                                setRemainDist(codedInputStreamMicro.readInt32());
                                continue;
                            case 16:
                                setRemainStops(codedInputStreamMicro.readInt32());
                                continue;
                            case 24:
                                setRemainTime(codedInputStreamMicro.readInt32());
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

                public NextBusInfo setRemainDist(int i) {
                    this.f14339a = true;
                    this.f14340b = i;
                    return this;
                }

                public NextBusInfo setRemainStops(int i) {
                    this.f14341c = true;
                    this.f14342d = i;
                    return this;
                }

                public NextBusInfo setRemainTime(int i) {
                    this.f14343e = true;
                    this.f14344f = i;
                    return this;
                }

                public NextBusInfo setSpath(int i, int i2) {
                    this.f14349k.set(i, Integer.valueOf(i2));
                    return this;
                }

                public NextBusInfo setX(int i) {
                    this.f14345g = true;
                    this.f14346h = i;
                    return this;
                }

                public NextBusInfo setY(int i) {
                    this.f14347i = true;
                    this.f14348j = i;
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

            public static Station parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Station().mergeFrom(codedInputStreamMicro);
            }

            public static Station parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Station) new Station().mergeFrom(bArr);
            }

            public final Station clear() {
                clearUid();
                clearName();
                clearTipRtbus();
                clearLine();
                clearNextBusInfo();
                clearImageTipRtbus();
                this.f14363m = -1;
                return this;
            }

            public Station clearImageTipRtbus() {
                this.f14361k = false;
                this.f14362l = "";
                return this;
            }

            public Station clearLine() {
                this.f14357g = false;
                this.f14358h = null;
                return this;
            }

            public Station clearName() {
                this.f14353c = false;
                this.f14354d = "";
                return this;
            }

            public Station clearNextBusInfo() {
                this.f14359i = false;
                this.f14360j = null;
                return this;
            }

            public Station clearTipRtbus() {
                this.f14355e = false;
                this.f14356f = "";
                return this;
            }

            public Station clearUid() {
                this.f14351a = false;
                this.f14352b = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f14363m < 0) {
                    getSerializedSize();
                }
                return this.f14363m;
            }

            public String getImageTipRtbus() {
                return this.f14362l;
            }

            public Line getLine() {
                return this.f14358h;
            }

            public String getName() {
                return this.f14354d;
            }

            public NextBusInfo getNextBusInfo() {
                return this.f14360j;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasUid()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUid());
                }
                if (hasName()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getName());
                }
                if (hasTipRtbus()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getTipRtbus());
                }
                if (hasLine()) {
                    i += CodedOutputStreamMicro.computeMessageSize(4, getLine());
                }
                if (hasNextBusInfo()) {
                    i += CodedOutputStreamMicro.computeMessageSize(5, getNextBusInfo());
                }
                if (hasImageTipRtbus()) {
                    i += CodedOutputStreamMicro.computeStringSize(6, getImageTipRtbus());
                }
                this.f14363m = i;
                return i;
            }

            public String getTipRtbus() {
                return this.f14356f;
            }

            public String getUid() {
                return this.f14352b;
            }

            public boolean hasImageTipRtbus() {
                return this.f14361k;
            }

            public boolean hasLine() {
                return this.f14357g;
            }

            public boolean hasName() {
                return this.f14353c;
            }

            public boolean hasNextBusInfo() {
                return this.f14359i;
            }

            public boolean hasTipRtbus() {
                return this.f14355e;
            }

            public boolean hasUid() {
                return this.f14351a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Station mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    MessageMicro line;
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
                            setTipRtbus(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            line = new Line();
                            codedInputStreamMicro.readMessage(line);
                            setLine(line);
                            continue;
                        case 42:
                            line = new NextBusInfo();
                            codedInputStreamMicro.readMessage(line);
                            setNextBusInfo(line);
                            continue;
                        case 50:
                            setImageTipRtbus(codedInputStreamMicro.readString());
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

            public Station setImageTipRtbus(String str) {
                this.f14361k = true;
                this.f14362l = str;
                return this;
            }

            public Station setLine(Line line) {
                if (line == null) {
                    return clearLine();
                }
                this.f14357g = true;
                this.f14358h = line;
                return this;
            }

            public Station setName(String str) {
                this.f14353c = true;
                this.f14354d = str;
                return this;
            }

            public Station setNextBusInfo(NextBusInfo nextBusInfo) {
                if (nextBusInfo == null) {
                    return clearNextBusInfo();
                }
                this.f14359i = true;
                this.f14360j = nextBusInfo;
                return this;
            }

            public Station setTipRtbus(String str) {
                this.f14355e = true;
                this.f14356f = str;
                return this;
            }

            public Station setUid(String str) {
                this.f14351a = true;
                this.f14352b = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(1, getUid());
                }
                if (hasName()) {
                    codedOutputStreamMicro.writeString(2, getName());
                }
                if (hasTipRtbus()) {
                    codedOutputStreamMicro.writeString(3, getTipRtbus());
                }
                if (hasLine()) {
                    codedOutputStreamMicro.writeMessage(4, getLine());
                }
                if (hasNextBusInfo()) {
                    codedOutputStreamMicro.writeMessage(5, getNextBusInfo());
                }
                if (hasImageTipRtbus()) {
                    codedOutputStreamMicro.writeString(6, getImageTipRtbus());
                }
            }
        }

        public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Content().mergeFrom(codedInputStreamMicro);
        }

        public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Content) new Content().mergeFrom(bArr);
        }

        public Content addStations(Station station) {
            if (station != null) {
                if (this.f14370g.isEmpty()) {
                    this.f14370g = new ArrayList();
                }
                this.f14370g.add(station);
            }
            return this;
        }

        public final Content clear() {
            clearRtbusNu();
            clearRtbusUpdateTime();
            clearRtbusVersion();
            clearStations();
            this.f14371h = -1;
            return this;
        }

        public Content clearRtbusNu() {
            this.f14364a = false;
            this.f14365b = 0;
            return this;
        }

        public Content clearRtbusUpdateTime() {
            this.f14366c = false;
            this.f14367d = 0;
            return this;
        }

        public Content clearRtbusVersion() {
            this.f14368e = false;
            this.f14369f = 0;
            return this;
        }

        public Content clearStations() {
            this.f14370g = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f14371h < 0) {
                getSerializedSize();
            }
            return this.f14371h;
        }

        public int getRtbusNu() {
            return this.f14365b;
        }

        public int getRtbusUpdateTime() {
            return this.f14367d;
        }

        public int getRtbusVersion() {
            return this.f14369f;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasRtbusNu()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getRtbusNu());
            }
            if (hasRtbusUpdateTime()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getRtbusUpdateTime());
            }
            if (hasRtbusVersion()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getRtbusVersion());
            }
            int i2 = i;
            for (Station computeMessageSize : getStationsList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(4, computeMessageSize) + i2;
            }
            this.f14371h = i2;
            return i2;
        }

        public Station getStations(int i) {
            return (Station) this.f14370g.get(i);
        }

        public int getStationsCount() {
            return this.f14370g.size();
        }

        public List<Station> getStationsList() {
            return this.f14370g;
        }

        public boolean hasRtbusNu() {
            return this.f14364a;
        }

        public boolean hasRtbusUpdateTime() {
            return this.f14366c;
        }

        public boolean hasRtbusVersion() {
            return this.f14368e;
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
                        setRtbusNu(codedInputStreamMicro.readInt32());
                        continue;
                    case 16:
                        setRtbusUpdateTime(codedInputStreamMicro.readInt32());
                        continue;
                    case 24:
                        setRtbusVersion(codedInputStreamMicro.readInt32());
                        continue;
                    case 34:
                        MessageMicro station = new Station();
                        codedInputStreamMicro.readMessage(station);
                        addStations(station);
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

        public Content setRtbusNu(int i) {
            this.f14364a = true;
            this.f14365b = i;
            return this;
        }

        public Content setRtbusUpdateTime(int i) {
            this.f14366c = true;
            this.f14367d = i;
            return this;
        }

        public Content setRtbusVersion(int i) {
            this.f14368e = true;
            this.f14369f = i;
            return this;
        }

        public Content setStations(int i, Station station) {
            if (station != null) {
                this.f14370g.set(i, station);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasRtbusNu()) {
                codedOutputStreamMicro.writeInt32(1, getRtbusNu());
            }
            if (hasRtbusUpdateTime()) {
                codedOutputStreamMicro.writeInt32(2, getRtbusUpdateTime());
            }
            if (hasRtbusVersion()) {
                codedOutputStreamMicro.writeInt32(3, getRtbusVersion());
            }
            for (Station writeMessage : getStationsList()) {
                codedOutputStreamMicro.writeMessage(4, writeMessage);
            }
        }
    }

    public static final class Option extends MessageMicro {
        public static final int HAS_RTBUS_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f14372a;
        /* renamed from: b */
        private int f14373b = 0;
        /* renamed from: c */
        private int f14374c = -1;

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }

        public final Option clear() {
            clearHasRtbus();
            this.f14374c = -1;
            return this;
        }

        public Option clearHasRtbus() {
            this.f14372a = false;
            this.f14373b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f14374c < 0) {
                getSerializedSize();
            }
            return this.f14374c;
        }

        public int getHasRtbus() {
            return this.f14373b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasHasRtbus()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getHasRtbus());
            }
            this.f14374c = i;
            return i;
        }

        public boolean hasHasRtbus() {
            return this.f14372a;
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
                    default:
                        if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public Option setHasRtbus(int i) {
            this.f14372a = true;
            this.f14373b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasHasRtbus()) {
                codedOutputStreamMicro.writeInt32(1, getHasRtbus());
            }
        }
    }

    public static Rtbus parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Rtbus().mergeFrom(codedInputStreamMicro);
    }

    public static Rtbus parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Rtbus) new Rtbus().mergeFrom(bArr);
    }

    public final Rtbus clear() {
        clearOption();
        clearContent();
        this.f14379e = -1;
        return this;
    }

    public Rtbus clearContent() {
        this.f14377c = false;
        this.f14378d = null;
        return this;
    }

    public Rtbus clearOption() {
        this.f14375a = false;
        this.f14376b = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f14379e < 0) {
            getSerializedSize();
        }
        return this.f14379e;
    }

    public Content getContent() {
        return this.f14378d;
    }

    public Option getOption() {
        return this.f14376b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasOption()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
        }
        if (hasContent()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getContent());
        }
        this.f14379e = i;
        return i;
    }

    public boolean hasContent() {
        return this.f14377c;
    }

    public boolean hasOption() {
        return this.f14375a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Rtbus mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                default:
                    if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public Rtbus setContent(Content content) {
        if (content == null) {
            return clearContent();
        }
        this.f14377c = true;
        this.f14378d = content;
        return this;
    }

    public Rtbus setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f14375a = true;
        this.f14376b = option;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(1, getOption());
        }
        if (hasContent()) {
            codedOutputStreamMicro.writeMessage(2, getContent());
        }
    }
}
