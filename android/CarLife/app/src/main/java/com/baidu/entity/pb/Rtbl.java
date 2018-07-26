package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Rtbl extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 2;
    public static final int ERROR_FIELD_NUMBER = 3;
    public static final int OPTION_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f14325a;
    /* renamed from: b */
    private Option f14326b = null;
    /* renamed from: c */
    private boolean f14327c;
    /* renamed from: d */
    private Content f14328d = null;
    /* renamed from: e */
    private boolean f14329e;
    /* renamed from: f */
    private int f14330f = 0;
    /* renamed from: g */
    private int f14331g = -1;

    public static final class Content extends MessageMicro {
        public static final int LINES_FIELD_NUMBER = 1;
        public static final int RECOMMEND_LINES_FIELD_NUMBER = 4;
        public static final int RECOMMEND_UPDATE_INTERVAL_FIELD_NUMBER = 3;
        public static final int STATIONS_FIELD_NUMBER = 2;
        /* renamed from: a */
        private List<Lines> f14314a = Collections.emptyList();
        /* renamed from: b */
        private List<Stations> f14315b = Collections.emptyList();
        /* renamed from: c */
        private boolean f14316c;
        /* renamed from: d */
        private int f14317d = 0;
        /* renamed from: e */
        private List<RecommendLines> f14318e = Collections.emptyList();
        /* renamed from: f */
        private int f14319f = -1;

        public static final class Lines extends MessageMicro {
            public static final int DIRECTION_FIELD_NUMBER = 3;
            public static final int NAME_FIELD_NUMBER = 2;
            public static final int UID_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f14291a;
            /* renamed from: b */
            private String f14292b = "";
            /* renamed from: c */
            private boolean f14293c;
            /* renamed from: d */
            private String f14294d = "";
            /* renamed from: e */
            private List<Direction> f14295e = Collections.emptyList();
            /* renamed from: f */
            private int f14296f = -1;

            public static final class Direction extends MessageMicro {
                public static final int LINE_UID_FIELD_NUMBER = 2;
                public static final int NAME_FIELD_NUMBER = 1;
                public static final int REMAIN_STOPS_FIELD_NUMBER = 3;
                public static final int STATION_UID_FIELD_NUMBER = 4;
                public static final int TIP_RTBUS_FIELD_NUMBER = 5;
                /* renamed from: a */
                private boolean f14280a;
                /* renamed from: b */
                private String f14281b = "";
                /* renamed from: c */
                private boolean f14282c;
                /* renamed from: d */
                private String f14283d = "";
                /* renamed from: e */
                private boolean f14284e;
                /* renamed from: f */
                private int f14285f = 0;
                /* renamed from: g */
                private boolean f14286g;
                /* renamed from: h */
                private String f14287h = "";
                /* renamed from: i */
                private boolean f14288i;
                /* renamed from: j */
                private String f14289j = "";
                /* renamed from: k */
                private int f14290k = -1;

                public static Direction parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Direction().mergeFrom(codedInputStreamMicro);
                }

                public static Direction parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Direction) new Direction().mergeFrom(bArr);
                }

                public final Direction clear() {
                    clearName();
                    clearLineUid();
                    clearRemainStops();
                    clearStationUid();
                    clearTipRtbus();
                    this.f14290k = -1;
                    return this;
                }

                public Direction clearLineUid() {
                    this.f14282c = false;
                    this.f14283d = "";
                    return this;
                }

                public Direction clearName() {
                    this.f14280a = false;
                    this.f14281b = "";
                    return this;
                }

                public Direction clearRemainStops() {
                    this.f14284e = false;
                    this.f14285f = 0;
                    return this;
                }

                public Direction clearStationUid() {
                    this.f14286g = false;
                    this.f14287h = "";
                    return this;
                }

                public Direction clearTipRtbus() {
                    this.f14288i = false;
                    this.f14289j = "";
                    return this;
                }

                public int getCachedSize() {
                    if (this.f14290k < 0) {
                        getSerializedSize();
                    }
                    return this.f14290k;
                }

                public String getLineUid() {
                    return this.f14283d;
                }

                public String getName() {
                    return this.f14281b;
                }

                public int getRemainStops() {
                    return this.f14285f;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasName()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
                    }
                    if (hasLineUid()) {
                        i += CodedOutputStreamMicro.computeStringSize(2, getLineUid());
                    }
                    if (hasRemainStops()) {
                        i += CodedOutputStreamMicro.computeInt32Size(3, getRemainStops());
                    }
                    if (hasStationUid()) {
                        i += CodedOutputStreamMicro.computeStringSize(4, getStationUid());
                    }
                    if (hasTipRtbus()) {
                        i += CodedOutputStreamMicro.computeStringSize(5, getTipRtbus());
                    }
                    this.f14290k = i;
                    return i;
                }

                public String getStationUid() {
                    return this.f14287h;
                }

                public String getTipRtbus() {
                    return this.f14289j;
                }

                public boolean hasLineUid() {
                    return this.f14282c;
                }

                public boolean hasName() {
                    return this.f14280a;
                }

                public boolean hasRemainStops() {
                    return this.f14284e;
                }

                public boolean hasStationUid() {
                    return this.f14286g;
                }

                public boolean hasTipRtbus() {
                    return this.f14288i;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Direction mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                setName(codedInputStreamMicro.readString());
                                continue;
                            case 18:
                                setLineUid(codedInputStreamMicro.readString());
                                continue;
                            case 24:
                                setRemainStops(codedInputStreamMicro.readInt32());
                                continue;
                            case 34:
                                setStationUid(codedInputStreamMicro.readString());
                                continue;
                            case 42:
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

                public Direction setLineUid(String str) {
                    this.f14282c = true;
                    this.f14283d = str;
                    return this;
                }

                public Direction setName(String str) {
                    this.f14280a = true;
                    this.f14281b = str;
                    return this;
                }

                public Direction setRemainStops(int i) {
                    this.f14284e = true;
                    this.f14285f = i;
                    return this;
                }

                public Direction setStationUid(String str) {
                    this.f14286g = true;
                    this.f14287h = str;
                    return this;
                }

                public Direction setTipRtbus(String str) {
                    this.f14288i = true;
                    this.f14289j = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(1, getName());
                    }
                    if (hasLineUid()) {
                        codedOutputStreamMicro.writeString(2, getLineUid());
                    }
                    if (hasRemainStops()) {
                        codedOutputStreamMicro.writeInt32(3, getRemainStops());
                    }
                    if (hasStationUid()) {
                        codedOutputStreamMicro.writeString(4, getStationUid());
                    }
                    if (hasTipRtbus()) {
                        codedOutputStreamMicro.writeString(5, getTipRtbus());
                    }
                }
            }

            public static Lines parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Lines().mergeFrom(codedInputStreamMicro);
            }

            public static Lines parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Lines) new Lines().mergeFrom(bArr);
            }

            public Lines addDirection(Direction direction) {
                if (direction != null) {
                    if (this.f14295e.isEmpty()) {
                        this.f14295e = new ArrayList();
                    }
                    this.f14295e.add(direction);
                }
                return this;
            }

            public final Lines clear() {
                clearUid();
                clearName();
                clearDirection();
                this.f14296f = -1;
                return this;
            }

            public Lines clearDirection() {
                this.f14295e = Collections.emptyList();
                return this;
            }

            public Lines clearName() {
                this.f14293c = false;
                this.f14294d = "";
                return this;
            }

            public Lines clearUid() {
                this.f14291a = false;
                this.f14292b = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f14296f < 0) {
                    getSerializedSize();
                }
                return this.f14296f;
            }

            public Direction getDirection(int i) {
                return (Direction) this.f14295e.get(i);
            }

            public int getDirectionCount() {
                return this.f14295e.size();
            }

            public List<Direction> getDirectionList() {
                return this.f14295e;
            }

            public String getName() {
                return this.f14294d;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasUid()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUid());
                }
                if (hasName()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getName());
                }
                int i2 = i;
                for (Direction computeMessageSize : getDirectionList()) {
                    i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
                }
                this.f14296f = i2;
                return i2;
            }

            public String getUid() {
                return this.f14292b;
            }

            public boolean hasName() {
                return this.f14293c;
            }

            public boolean hasUid() {
                return this.f14291a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Lines mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                            MessageMicro direction = new Direction();
                            codedInputStreamMicro.readMessage(direction);
                            addDirection(direction);
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

            public Lines setDirection(int i, Direction direction) {
                if (direction != null) {
                    this.f14295e.set(i, direction);
                }
                return this;
            }

            public Lines setName(String str) {
                this.f14293c = true;
                this.f14294d = str;
                return this;
            }

            public Lines setUid(String str) {
                this.f14291a = true;
                this.f14292b = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(1, getUid());
                }
                if (hasName()) {
                    codedOutputStreamMicro.writeString(2, getName());
                }
                for (Direction writeMessage : getDirectionList()) {
                    codedOutputStreamMicro.writeMessage(3, writeMessage);
                }
            }
        }

        public static final class RecommendLines extends MessageMicro {
            public static final int LINE_DIRECTION_FIELD_NUMBER = 3;
            public static final int LINE_NAME_FIELD_NUMBER = 1;
            public static final int LINE_UID_FIELD_NUMBER = 2;
            public static final int STATION_NAME_FIELD_NUMBER = 4;
            public static final int TIP_RTBUS_FIELD_NUMBER = 5;
            /* renamed from: a */
            private boolean f14297a;
            /* renamed from: b */
            private String f14298b = "";
            /* renamed from: c */
            private boolean f14299c;
            /* renamed from: d */
            private String f14300d = "";
            /* renamed from: e */
            private boolean f14301e;
            /* renamed from: f */
            private String f14302f = "";
            /* renamed from: g */
            private boolean f14303g;
            /* renamed from: h */
            private String f14304h = "";
            /* renamed from: i */
            private boolean f14305i;
            /* renamed from: j */
            private String f14306j = "";
            /* renamed from: k */
            private int f14307k = -1;

            public static RecommendLines parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new RecommendLines().mergeFrom(codedInputStreamMicro);
            }

            public static RecommendLines parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (RecommendLines) new RecommendLines().mergeFrom(bArr);
            }

            public final RecommendLines clear() {
                clearLineName();
                clearLineUid();
                clearLineDirection();
                clearStationName();
                clearTipRtbus();
                this.f14307k = -1;
                return this;
            }

            public RecommendLines clearLineDirection() {
                this.f14301e = false;
                this.f14302f = "";
                return this;
            }

            public RecommendLines clearLineName() {
                this.f14297a = false;
                this.f14298b = "";
                return this;
            }

            public RecommendLines clearLineUid() {
                this.f14299c = false;
                this.f14300d = "";
                return this;
            }

            public RecommendLines clearStationName() {
                this.f14303g = false;
                this.f14304h = "";
                return this;
            }

            public RecommendLines clearTipRtbus() {
                this.f14305i = false;
                this.f14306j = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f14307k < 0) {
                    getSerializedSize();
                }
                return this.f14307k;
            }

            public String getLineDirection() {
                return this.f14302f;
            }

            public String getLineName() {
                return this.f14298b;
            }

            public String getLineUid() {
                return this.f14300d;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasLineName()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getLineName());
                }
                if (hasLineUid()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getLineUid());
                }
                if (hasLineDirection()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getLineDirection());
                }
                if (hasStationName()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getStationName());
                }
                if (hasTipRtbus()) {
                    i += CodedOutputStreamMicro.computeStringSize(5, getTipRtbus());
                }
                this.f14307k = i;
                return i;
            }

            public String getStationName() {
                return this.f14304h;
            }

            public String getTipRtbus() {
                return this.f14306j;
            }

            public boolean hasLineDirection() {
                return this.f14301e;
            }

            public boolean hasLineName() {
                return this.f14297a;
            }

            public boolean hasLineUid() {
                return this.f14299c;
            }

            public boolean hasStationName() {
                return this.f14303g;
            }

            public boolean hasTipRtbus() {
                return this.f14305i;
            }

            public final boolean isInitialized() {
                return true;
            }

            public RecommendLines mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setLineName(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setLineUid(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setLineDirection(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setStationName(codedInputStreamMicro.readString());
                            continue;
                        case 42:
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

            public RecommendLines setLineDirection(String str) {
                this.f14301e = true;
                this.f14302f = str;
                return this;
            }

            public RecommendLines setLineName(String str) {
                this.f14297a = true;
                this.f14298b = str;
                return this;
            }

            public RecommendLines setLineUid(String str) {
                this.f14299c = true;
                this.f14300d = str;
                return this;
            }

            public RecommendLines setStationName(String str) {
                this.f14303g = true;
                this.f14304h = str;
                return this;
            }

            public RecommendLines setTipRtbus(String str) {
                this.f14305i = true;
                this.f14306j = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasLineName()) {
                    codedOutputStreamMicro.writeString(1, getLineName());
                }
                if (hasLineUid()) {
                    codedOutputStreamMicro.writeString(2, getLineUid());
                }
                if (hasLineDirection()) {
                    codedOutputStreamMicro.writeString(3, getLineDirection());
                }
                if (hasStationName()) {
                    codedOutputStreamMicro.writeString(4, getStationName());
                }
                if (hasTipRtbus()) {
                    codedOutputStreamMicro.writeString(5, getTipRtbus());
                }
            }
        }

        public static final class Stations extends MessageMicro {
            public static final int DIS_FIELD_NUMBER = 2;
            public static final int LINES_FIELD_NUMBER = 3;
            public static final int NAME_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f14308a;
            /* renamed from: b */
            private String f14309b = "";
            /* renamed from: c */
            private boolean f14310c;
            /* renamed from: d */
            private int f14311d = 0;
            /* renamed from: e */
            private List<Lines> f14312e = Collections.emptyList();
            /* renamed from: f */
            private int f14313f = -1;

            public static Stations parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Stations().mergeFrom(codedInputStreamMicro);
            }

            public static Stations parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Stations) new Stations().mergeFrom(bArr);
            }

            public Stations addLines(Lines lines) {
                if (lines != null) {
                    if (this.f14312e.isEmpty()) {
                        this.f14312e = new ArrayList();
                    }
                    this.f14312e.add(lines);
                }
                return this;
            }

            public final Stations clear() {
                clearName();
                clearDis();
                clearLines();
                this.f14313f = -1;
                return this;
            }

            public Stations clearDis() {
                this.f14310c = false;
                this.f14311d = 0;
                return this;
            }

            public Stations clearLines() {
                this.f14312e = Collections.emptyList();
                return this;
            }

            public Stations clearName() {
                this.f14308a = false;
                this.f14309b = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f14313f < 0) {
                    getSerializedSize();
                }
                return this.f14313f;
            }

            public int getDis() {
                return this.f14311d;
            }

            public Lines getLines(int i) {
                return (Lines) this.f14312e.get(i);
            }

            public int getLinesCount() {
                return this.f14312e.size();
            }

            public List<Lines> getLinesList() {
                return this.f14312e;
            }

            public String getName() {
                return this.f14309b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasName()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
                }
                if (hasDis()) {
                    i += CodedOutputStreamMicro.computeInt32Size(2, getDis());
                }
                int i2 = i;
                for (Lines computeMessageSize : getLinesList()) {
                    i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
                }
                this.f14313f = i2;
                return i2;
            }

            public boolean hasDis() {
                return this.f14310c;
            }

            public boolean hasName() {
                return this.f14308a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Stations mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setName(codedInputStreamMicro.readString());
                            continue;
                        case 16:
                            setDis(codedInputStreamMicro.readInt32());
                            continue;
                        case 26:
                            MessageMicro lines = new Lines();
                            codedInputStreamMicro.readMessage(lines);
                            addLines(lines);
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

            public Stations setDis(int i) {
                this.f14310c = true;
                this.f14311d = i;
                return this;
            }

            public Stations setLines(int i, Lines lines) {
                if (lines != null) {
                    this.f14312e.set(i, lines);
                }
                return this;
            }

            public Stations setName(String str) {
                this.f14308a = true;
                this.f14309b = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasName()) {
                    codedOutputStreamMicro.writeString(1, getName());
                }
                if (hasDis()) {
                    codedOutputStreamMicro.writeInt32(2, getDis());
                }
                for (Lines writeMessage : getLinesList()) {
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

        public Content addLines(Lines lines) {
            if (lines != null) {
                if (this.f14314a.isEmpty()) {
                    this.f14314a = new ArrayList();
                }
                this.f14314a.add(lines);
            }
            return this;
        }

        public Content addRecommendLines(RecommendLines recommendLines) {
            if (recommendLines != null) {
                if (this.f14318e.isEmpty()) {
                    this.f14318e = new ArrayList();
                }
                this.f14318e.add(recommendLines);
            }
            return this;
        }

        public Content addStations(Stations stations) {
            if (stations != null) {
                if (this.f14315b.isEmpty()) {
                    this.f14315b = new ArrayList();
                }
                this.f14315b.add(stations);
            }
            return this;
        }

        public final Content clear() {
            clearLines();
            clearStations();
            clearRecommendUpdateInterval();
            clearRecommendLines();
            this.f14319f = -1;
            return this;
        }

        public Content clearLines() {
            this.f14314a = Collections.emptyList();
            return this;
        }

        public Content clearRecommendLines() {
            this.f14318e = Collections.emptyList();
            return this;
        }

        public Content clearRecommendUpdateInterval() {
            this.f14316c = false;
            this.f14317d = 0;
            return this;
        }

        public Content clearStations() {
            this.f14315b = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f14319f < 0) {
                getSerializedSize();
            }
            return this.f14319f;
        }

        public Lines getLines(int i) {
            return (Lines) this.f14314a.get(i);
        }

        public int getLinesCount() {
            return this.f14314a.size();
        }

        public List<Lines> getLinesList() {
            return this.f14314a;
        }

        public RecommendLines getRecommendLines(int i) {
            return (RecommendLines) this.f14318e.get(i);
        }

        public int getRecommendLinesCount() {
            return this.f14318e.size();
        }

        public List<RecommendLines> getRecommendLinesList() {
            return this.f14318e;
        }

        public int getRecommendUpdateInterval() {
            return this.f14317d;
        }

        public int getSerializedSize() {
            int i = 0;
            for (Lines computeMessageSize : getLinesList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            for (Stations computeMessageSize2 : getStationsList()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize2);
            }
            if (hasRecommendUpdateInterval()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getRecommendUpdateInterval());
            }
            for (RecommendLines computeMessageSize3 : getRecommendLinesList()) {
                i += CodedOutputStreamMicro.computeMessageSize(4, computeMessageSize3);
            }
            this.f14319f = i;
            return i;
        }

        public Stations getStations(int i) {
            return (Stations) this.f14315b.get(i);
        }

        public int getStationsCount() {
            return this.f14315b.size();
        }

        public List<Stations> getStationsList() {
            return this.f14315b;
        }

        public boolean hasRecommendUpdateInterval() {
            return this.f14316c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Content mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro lines;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        lines = new Lines();
                        codedInputStreamMicro.readMessage(lines);
                        addLines(lines);
                        continue;
                    case 18:
                        lines = new Stations();
                        codedInputStreamMicro.readMessage(lines);
                        addStations(lines);
                        continue;
                    case 24:
                        setRecommendUpdateInterval(codedInputStreamMicro.readInt32());
                        continue;
                    case 34:
                        lines = new RecommendLines();
                        codedInputStreamMicro.readMessage(lines);
                        addRecommendLines(lines);
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

        public Content setLines(int i, Lines lines) {
            if (lines != null) {
                this.f14314a.set(i, lines);
            }
            return this;
        }

        public Content setRecommendLines(int i, RecommendLines recommendLines) {
            if (recommendLines != null) {
                this.f14318e.set(i, recommendLines);
            }
            return this;
        }

        public Content setRecommendUpdateInterval(int i) {
            this.f14316c = true;
            this.f14317d = i;
            return this;
        }

        public Content setStations(int i, Stations stations) {
            if (stations != null) {
                this.f14315b.set(i, stations);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (Lines writeMessage : getLinesList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
            for (Stations writeMessage2 : getStationsList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage2);
            }
            if (hasRecommendUpdateInterval()) {
                codedOutputStreamMicro.writeInt32(3, getRecommendUpdateInterval());
            }
            for (RecommendLines writeMessage3 : getRecommendLinesList()) {
                codedOutputStreamMicro.writeMessage(4, writeMessage3);
            }
        }
    }

    public static final class Option extends MessageMicro {
        public static final int ERROR_FIELD_NUMBER = 2;
        public static final int RETURN_ALL_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f14320a;
        /* renamed from: b */
        private int f14321b = 0;
        /* renamed from: c */
        private boolean f14322c;
        /* renamed from: d */
        private int f14323d = 0;
        /* renamed from: e */
        private int f14324e = -1;

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }

        public final Option clear() {
            clearReturnAll();
            clearError();
            this.f14324e = -1;
            return this;
        }

        public Option clearError() {
            this.f14322c = false;
            this.f14323d = 0;
            return this;
        }

        public Option clearReturnAll() {
            this.f14320a = false;
            this.f14321b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f14324e < 0) {
                getSerializedSize();
            }
            return this.f14324e;
        }

        public int getError() {
            return this.f14323d;
        }

        public int getReturnAll() {
            return this.f14321b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasReturnAll()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getReturnAll());
            }
            if (hasError()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getError());
            }
            this.f14324e = i;
            return i;
        }

        public boolean hasError() {
            return this.f14322c;
        }

        public boolean hasReturnAll() {
            return this.f14320a;
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
                        setReturnAll(codedInputStreamMicro.readInt32());
                        continue;
                    case 16:
                        setError(codedInputStreamMicro.readInt32());
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

        public Option setError(int i) {
            this.f14322c = true;
            this.f14323d = i;
            return this;
        }

        public Option setReturnAll(int i) {
            this.f14320a = true;
            this.f14321b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasReturnAll()) {
                codedOutputStreamMicro.writeInt32(1, getReturnAll());
            }
            if (hasError()) {
                codedOutputStreamMicro.writeInt32(2, getError());
            }
        }
    }

    public static Rtbl parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Rtbl().mergeFrom(codedInputStreamMicro);
    }

    public static Rtbl parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Rtbl) new Rtbl().mergeFrom(bArr);
    }

    public final Rtbl clear() {
        clearOption();
        clearContent();
        clearError();
        this.f14331g = -1;
        return this;
    }

    public Rtbl clearContent() {
        this.f14327c = false;
        this.f14328d = null;
        return this;
    }

    public Rtbl clearError() {
        this.f14329e = false;
        this.f14330f = 0;
        return this;
    }

    public Rtbl clearOption() {
        this.f14325a = false;
        this.f14326b = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f14331g < 0) {
            getSerializedSize();
        }
        return this.f14331g;
    }

    public Content getContent() {
        return this.f14328d;
    }

    public int getError() {
        return this.f14330f;
    }

    public Option getOption() {
        return this.f14326b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasOption()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
        }
        if (hasContent()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getContent());
        }
        if (hasError()) {
            i += CodedOutputStreamMicro.computeInt32Size(3, getError());
        }
        this.f14331g = i;
        return i;
    }

    public boolean hasContent() {
        return this.f14327c;
    }

    public boolean hasError() {
        return this.f14329e;
    }

    public boolean hasOption() {
        return this.f14325a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Rtbl mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                case 24:
                    setError(codedInputStreamMicro.readInt32());
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

    public Rtbl setContent(Content content) {
        if (content == null) {
            return clearContent();
        }
        this.f14327c = true;
        this.f14328d = content;
        return this;
    }

    public Rtbl setError(int i) {
        this.f14329e = true;
        this.f14330f = i;
        return this;
    }

    public Rtbl setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f14325a = true;
        this.f14326b = option;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(1, getOption());
        }
        if (hasContent()) {
            codedOutputStreamMicro.writeMessage(2, getContent());
        }
        if (hasError()) {
            codedOutputStreamMicro.writeInt32(3, getError());
        }
    }
}
