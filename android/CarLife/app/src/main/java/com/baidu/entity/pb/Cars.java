package com.baidu.entity.pb;

import com.baidu.baidunavis.model.NavCarInfo;
import com.baidu.carlife.core.C1253f;
import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Cars extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 2;
    public static final int OPTION_FIELD_NUMBER = 1;
    public static final int TEST_FIELD_NUMBER = 3;
    /* renamed from: a */
    private boolean f10932a;
    /* renamed from: b */
    private Option f10933b = null;
    /* renamed from: c */
    private boolean f10934c;
    /* renamed from: d */
    private Content f10935d = null;
    /* renamed from: e */
    private boolean f10936e;
    /* renamed from: f */
    private String f10937f = "";
    /* renamed from: g */
    private int f10938g = -1;

    public static final class Content extends MessageMicro {
        public static final int ACCI_INFOS_FIELD_NUMBER = 6;
        public static final int LOCAL_INFO_TIPS_FIELD_NUMBER = 8;
        public static final int LONG_DISTANCE_INFO_FIELD_NUMBER = 11;
        public static final int ROUTEALL = 1;
        public static final int ROUTEPART = 2;
        public static final int ROUTESTATUS_FIELD_NUMBER = 7;
        public static final int ROUTES_FIELD_NUMBER = 1;
        public static final int SESSIONID_FIELD_NUMBER = 9;
        public static final int STEPS_FIELD_NUMBER = 2;
        public static final int STEPTS_FIELD_NUMBER = 3;
        public static final int TAXIS_FIELD_NUMBER = 4;
        public static final int TRAFFICS_FIELD_NUMBER = 5;
        public static final int WALKINF_FIELD_NUMBER = 10;
        public static final int YELLOW_TIPS_LIST_FIELD_NUMBER = 12;
        /* renamed from: a */
        private List<Routes> f10854a = Collections.emptyList();
        /* renamed from: b */
        private List<Steps> f10855b = Collections.emptyList();
        /* renamed from: c */
        private List<Stepts> f10856c = Collections.emptyList();
        /* renamed from: d */
        private List<Taxis> f10857d = Collections.emptyList();
        /* renamed from: e */
        private List<Traffics> f10858e = Collections.emptyList();
        /* renamed from: f */
        private List<AcciInfos> f10859f = Collections.emptyList();
        /* renamed from: g */
        private boolean f10860g;
        /* renamed from: h */
        private int f10861h = 1;
        /* renamed from: i */
        private boolean f10862i;
        /* renamed from: j */
        private String f10863j = "";
        /* renamed from: k */
        private boolean f10864k;
        /* renamed from: l */
        private String f10865l = "";
        /* renamed from: m */
        private boolean f10866m;
        /* renamed from: n */
        private WalkInfoT f10867n = null;
        /* renamed from: o */
        private List<LongDistanceInfo> f10868o = Collections.emptyList();
        /* renamed from: p */
        private List<YellowTipsList> f10869p = Collections.emptyList();
        /* renamed from: q */
        private int f10870q = -1;

        public static final class AcciInfos extends MessageMicro {
            public static final int PATH_FIELD_NUMBER = 2;
            public static final int TIPS_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f10636a;
            /* renamed from: b */
            private String f10637b = "";
            /* renamed from: c */
            private boolean f10638c;
            /* renamed from: d */
            private String f10639d = "";
            /* renamed from: e */
            private int f10640e = -1;

            public static AcciInfos parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new AcciInfos().mergeFrom(codedInputStreamMicro);
            }

            public static AcciInfos parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (AcciInfos) new AcciInfos().mergeFrom(bArr);
            }

            public final AcciInfos clear() {
                clearTips();
                clearPath();
                this.f10640e = -1;
                return this;
            }

            public AcciInfos clearPath() {
                this.f10638c = false;
                this.f10639d = "";
                return this;
            }

            public AcciInfos clearTips() {
                this.f10636a = false;
                this.f10637b = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f10640e < 0) {
                    getSerializedSize();
                }
                return this.f10640e;
            }

            public String getPath() {
                return this.f10639d;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasTips()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTips());
                }
                if (hasPath()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getPath());
                }
                this.f10640e = i;
                return i;
            }

            public String getTips() {
                return this.f10637b;
            }

            public boolean hasPath() {
                return this.f10638c;
            }

            public boolean hasTips() {
                return this.f10636a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public AcciInfos mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setTips(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setPath(codedInputStreamMicro.readString());
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

            public AcciInfos setPath(String str) {
                this.f10638c = true;
                this.f10639d = str;
                return this;
            }

            public AcciInfos setTips(String str) {
                this.f10636a = true;
                this.f10637b = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasTips()) {
                    codedOutputStreamMicro.writeString(1, getTips());
                }
                if (hasPath()) {
                    codedOutputStreamMicro.writeString(2, getPath());
                }
            }
        }

        public static final class LongDistanceInfo extends MessageMicro {
            public static final int VIA_CITY_INFO_FIELD_NUMBER = 1;
            public static final int VIA_MAIN_ROAD_FIELD_NUMBER = 2;
            public static final int VIA_SERVICE_FIELD_NUMBER = 3;
            /* renamed from: a */
            private List<ViaCityInfo> f10687a = Collections.emptyList();
            /* renamed from: b */
            private List<ViaMainRoad> f10688b = Collections.emptyList();
            /* renamed from: c */
            private List<ViaService> f10689c = Collections.emptyList();
            /* renamed from: d */
            private int f10690d = -1;

            public static final class Point extends MessageMicro {
                public static final int X_FIELD_NUMBER = 1;
                public static final int Y_FIELD_NUMBER = 2;
                /* renamed from: a */
                private boolean f10641a;
                /* renamed from: b */
                private double f10642b = 0.0d;
                /* renamed from: c */
                private boolean f10643c;
                /* renamed from: d */
                private double f10644d = 0.0d;
                /* renamed from: e */
                private int f10645e = -1;

                public static Point parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Point().mergeFrom(codedInputStreamMicro);
                }

                public static Point parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Point) new Point().mergeFrom(bArr);
                }

                public final Point clear() {
                    clearX();
                    clearY();
                    this.f10645e = -1;
                    return this;
                }

                public Point clearX() {
                    this.f10641a = false;
                    this.f10642b = 0.0d;
                    return this;
                }

                public Point clearY() {
                    this.f10643c = false;
                    this.f10644d = 0.0d;
                    return this;
                }

                public int getCachedSize() {
                    if (this.f10645e < 0) {
                        getSerializedSize();
                    }
                    return this.f10645e;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasX()) {
                        i = 0 + CodedOutputStreamMicro.computeDoubleSize(1, getX());
                    }
                    if (hasY()) {
                        i += CodedOutputStreamMicro.computeDoubleSize(2, getY());
                    }
                    this.f10645e = i;
                    return i;
                }

                public double getX() {
                    return this.f10642b;
                }

                public double getY() {
                    return this.f10644d;
                }

                public boolean hasX() {
                    return this.f10641a;
                }

                public boolean hasY() {
                    return this.f10643c;
                }

                public final boolean isInitialized() {
                    return this.f10641a && this.f10643c;
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
                    this.f10641a = true;
                    this.f10642b = d;
                    return this;
                }

                public Point setY(double d) {
                    this.f10643c = true;
                    this.f10644d = d;
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

            public static final class ViaCityInfo extends MessageMicro {
                public static final int CITY_DISTANCE_FROM_START_FIELD_NUMBER = 3;
                public static final int CITY_ID_FIELD_NUMBER = 2;
                public static final int CITY_NAME_FIELD_NUMBER = 1;
                public static final int DURATION_FIELD_NUMBER = 4;
                public static final int POINT_FIELD_NUMBER = 6;
                public static final int PRIORITY_FIELD_NUMBER = 5;
                /* renamed from: a */
                private boolean f10646a;
                /* renamed from: b */
                private String f10647b = "";
                /* renamed from: c */
                private boolean f10648c;
                /* renamed from: d */
                private int f10649d = 0;
                /* renamed from: e */
                private boolean f10650e;
                /* renamed from: f */
                private int f10651f = 0;
                /* renamed from: g */
                private boolean f10652g;
                /* renamed from: h */
                private int f10653h = 0;
                /* renamed from: i */
                private boolean f10654i;
                /* renamed from: j */
                private int f10655j = 0;
                /* renamed from: k */
                private boolean f10656k;
                /* renamed from: l */
                private Point f10657l = null;
                /* renamed from: m */
                private int f10658m = -1;

                public static ViaCityInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new ViaCityInfo().mergeFrom(codedInputStreamMicro);
                }

                public static ViaCityInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (ViaCityInfo) new ViaCityInfo().mergeFrom(bArr);
                }

                public final ViaCityInfo clear() {
                    clearCityName();
                    clearCityId();
                    clearCityDistanceFromStart();
                    clearDuration();
                    clearPriority();
                    clearPoint();
                    this.f10658m = -1;
                    return this;
                }

                public ViaCityInfo clearCityDistanceFromStart() {
                    this.f10650e = false;
                    this.f10651f = 0;
                    return this;
                }

                public ViaCityInfo clearCityId() {
                    this.f10648c = false;
                    this.f10649d = 0;
                    return this;
                }

                public ViaCityInfo clearCityName() {
                    this.f10646a = false;
                    this.f10647b = "";
                    return this;
                }

                public ViaCityInfo clearDuration() {
                    this.f10652g = false;
                    this.f10653h = 0;
                    return this;
                }

                public ViaCityInfo clearPoint() {
                    this.f10656k = false;
                    this.f10657l = null;
                    return this;
                }

                public ViaCityInfo clearPriority() {
                    this.f10654i = false;
                    this.f10655j = 0;
                    return this;
                }

                public int getCachedSize() {
                    if (this.f10658m < 0) {
                        getSerializedSize();
                    }
                    return this.f10658m;
                }

                public int getCityDistanceFromStart() {
                    return this.f10651f;
                }

                public int getCityId() {
                    return this.f10649d;
                }

                public String getCityName() {
                    return this.f10647b;
                }

                public int getDuration() {
                    return this.f10653h;
                }

                public Point getPoint() {
                    return this.f10657l;
                }

                public int getPriority() {
                    return this.f10655j;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasCityName()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCityName());
                    }
                    if (hasCityId()) {
                        i += CodedOutputStreamMicro.computeInt32Size(2, getCityId());
                    }
                    if (hasCityDistanceFromStart()) {
                        i += CodedOutputStreamMicro.computeInt32Size(3, getCityDistanceFromStart());
                    }
                    if (hasDuration()) {
                        i += CodedOutputStreamMicro.computeInt32Size(4, getDuration());
                    }
                    if (hasPriority()) {
                        i += CodedOutputStreamMicro.computeInt32Size(5, getPriority());
                    }
                    if (hasPoint()) {
                        i += CodedOutputStreamMicro.computeMessageSize(6, getPoint());
                    }
                    this.f10658m = i;
                    return i;
                }

                public boolean hasCityDistanceFromStart() {
                    return this.f10650e;
                }

                public boolean hasCityId() {
                    return this.f10648c;
                }

                public boolean hasCityName() {
                    return this.f10646a;
                }

                public boolean hasDuration() {
                    return this.f10652g;
                }

                public boolean hasPoint() {
                    return this.f10656k;
                }

                public boolean hasPriority() {
                    return this.f10654i;
                }

                public final boolean isInitialized() {
                    return this.f10646a && this.f10648c && this.f10650e && this.f10652g && this.f10656k && getPoint().isInitialized();
                }

                public ViaCityInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                setCityName(codedInputStreamMicro.readString());
                                continue;
                            case 16:
                                setCityId(codedInputStreamMicro.readInt32());
                                continue;
                            case 24:
                                setCityDistanceFromStart(codedInputStreamMicro.readInt32());
                                continue;
                            case 32:
                                setDuration(codedInputStreamMicro.readInt32());
                                continue;
                            case 40:
                                setPriority(codedInputStreamMicro.readInt32());
                                continue;
                            case 50:
                                MessageMicro point = new Point();
                                codedInputStreamMicro.readMessage(point);
                                setPoint(point);
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

                public ViaCityInfo setCityDistanceFromStart(int i) {
                    this.f10650e = true;
                    this.f10651f = i;
                    return this;
                }

                public ViaCityInfo setCityId(int i) {
                    this.f10648c = true;
                    this.f10649d = i;
                    return this;
                }

                public ViaCityInfo setCityName(String str) {
                    this.f10646a = true;
                    this.f10647b = str;
                    return this;
                }

                public ViaCityInfo setDuration(int i) {
                    this.f10652g = true;
                    this.f10653h = i;
                    return this;
                }

                public ViaCityInfo setPoint(Point point) {
                    if (point == null) {
                        return clearPoint();
                    }
                    this.f10656k = true;
                    this.f10657l = point;
                    return this;
                }

                public ViaCityInfo setPriority(int i) {
                    this.f10654i = true;
                    this.f10655j = i;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasCityName()) {
                        codedOutputStreamMicro.writeString(1, getCityName());
                    }
                    if (hasCityId()) {
                        codedOutputStreamMicro.writeInt32(2, getCityId());
                    }
                    if (hasCityDistanceFromStart()) {
                        codedOutputStreamMicro.writeInt32(3, getCityDistanceFromStart());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(4, getDuration());
                    }
                    if (hasPriority()) {
                        codedOutputStreamMicro.writeInt32(5, getPriority());
                    }
                    if (hasPoint()) {
                        codedOutputStreamMicro.writeMessage(6, getPoint());
                    }
                }
            }

            public static final class ViaMainRoad extends MessageMicro {
                public static final int DISTANCE_FIELD_NUMBER = 5;
                public static final int END_FIELD_NUMBER = 8;
                public static final int LABEL_POINT_FIELD_NUMBER = 6;
                public static final int LANE_COUNT_FIELD_NUMBER = 3;
                public static final int MAIN_ROAD_NAME_FIELD_NUMBER = 1;
                public static final int MAIN_ROAD_TYPE_FIELD_NUMBER = 2;
                public static final int SPEED_LIMIT_FIELD_NUMBER = 4;
                public static final int START_FIELD_NUMBER = 7;
                /* renamed from: a */
                private boolean f10659a;
                /* renamed from: b */
                private String f10660b = "";
                /* renamed from: c */
                private boolean f10661c;
                /* renamed from: d */
                private int f10662d = 0;
                /* renamed from: e */
                private boolean f10663e;
                /* renamed from: f */
                private String f10664f = "";
                /* renamed from: g */
                private boolean f10665g;
                /* renamed from: h */
                private String f10666h = "";
                /* renamed from: i */
                private boolean f10667i;
                /* renamed from: j */
                private int f10668j = 0;
                /* renamed from: k */
                private boolean f10669k;
                /* renamed from: l */
                private Point f10670l = null;
                /* renamed from: m */
                private boolean f10671m;
                /* renamed from: n */
                private Point f10672n = null;
                /* renamed from: o */
                private boolean f10673o;
                /* renamed from: p */
                private Point f10674p = null;
                /* renamed from: q */
                private int f10675q = -1;

                public static ViaMainRoad parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new ViaMainRoad().mergeFrom(codedInputStreamMicro);
                }

                public static ViaMainRoad parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (ViaMainRoad) new ViaMainRoad().mergeFrom(bArr);
                }

                public final ViaMainRoad clear() {
                    clearMainRoadName();
                    clearMainRoadType();
                    clearLaneCount();
                    clearSpeedLimit();
                    clearDistance();
                    clearLabelPoint();
                    clearStart();
                    clearEnd();
                    this.f10675q = -1;
                    return this;
                }

                public ViaMainRoad clearDistance() {
                    this.f10667i = false;
                    this.f10668j = 0;
                    return this;
                }

                public ViaMainRoad clearEnd() {
                    this.f10673o = false;
                    this.f10674p = null;
                    return this;
                }

                public ViaMainRoad clearLabelPoint() {
                    this.f10669k = false;
                    this.f10670l = null;
                    return this;
                }

                public ViaMainRoad clearLaneCount() {
                    this.f10663e = false;
                    this.f10664f = "";
                    return this;
                }

                public ViaMainRoad clearMainRoadName() {
                    this.f10659a = false;
                    this.f10660b = "";
                    return this;
                }

                public ViaMainRoad clearMainRoadType() {
                    this.f10661c = false;
                    this.f10662d = 0;
                    return this;
                }

                public ViaMainRoad clearSpeedLimit() {
                    this.f10665g = false;
                    this.f10666h = "";
                    return this;
                }

                public ViaMainRoad clearStart() {
                    this.f10671m = false;
                    this.f10672n = null;
                    return this;
                }

                public int getCachedSize() {
                    if (this.f10675q < 0) {
                        getSerializedSize();
                    }
                    return this.f10675q;
                }

                public int getDistance() {
                    return this.f10668j;
                }

                public Point getEnd() {
                    return this.f10674p;
                }

                public Point getLabelPoint() {
                    return this.f10670l;
                }

                public String getLaneCount() {
                    return this.f10664f;
                }

                public String getMainRoadName() {
                    return this.f10660b;
                }

                public int getMainRoadType() {
                    return this.f10662d;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasMainRoadName()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getMainRoadName());
                    }
                    if (hasMainRoadType()) {
                        i += CodedOutputStreamMicro.computeInt32Size(2, getMainRoadType());
                    }
                    if (hasLaneCount()) {
                        i += CodedOutputStreamMicro.computeStringSize(3, getLaneCount());
                    }
                    if (hasSpeedLimit()) {
                        i += CodedOutputStreamMicro.computeStringSize(4, getSpeedLimit());
                    }
                    if (hasDistance()) {
                        i += CodedOutputStreamMicro.computeInt32Size(5, getDistance());
                    }
                    if (hasLabelPoint()) {
                        i += CodedOutputStreamMicro.computeMessageSize(6, getLabelPoint());
                    }
                    if (hasStart()) {
                        i += CodedOutputStreamMicro.computeMessageSize(7, getStart());
                    }
                    if (hasEnd()) {
                        i += CodedOutputStreamMicro.computeMessageSize(8, getEnd());
                    }
                    this.f10675q = i;
                    return i;
                }

                public String getSpeedLimit() {
                    return this.f10666h;
                }

                public Point getStart() {
                    return this.f10672n;
                }

                public boolean hasDistance() {
                    return this.f10667i;
                }

                public boolean hasEnd() {
                    return this.f10673o;
                }

                public boolean hasLabelPoint() {
                    return this.f10669k;
                }

                public boolean hasLaneCount() {
                    return this.f10663e;
                }

                public boolean hasMainRoadName() {
                    return this.f10659a;
                }

                public boolean hasMainRoadType() {
                    return this.f10661c;
                }

                public boolean hasSpeedLimit() {
                    return this.f10665g;
                }

                public boolean hasStart() {
                    return this.f10671m;
                }

                public final boolean isInitialized() {
                    return this.f10659a && this.f10661c && this.f10667i && this.f10669k && this.f10671m && this.f10673o && getLabelPoint().isInitialized() && getStart().isInitialized() && getEnd().isInitialized();
                }

                public ViaMainRoad mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        MessageMicro point;
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                setMainRoadName(codedInputStreamMicro.readString());
                                continue;
                            case 16:
                                setMainRoadType(codedInputStreamMicro.readInt32());
                                continue;
                            case 26:
                                setLaneCount(codedInputStreamMicro.readString());
                                continue;
                            case 34:
                                setSpeedLimit(codedInputStreamMicro.readString());
                                continue;
                            case 40:
                                setDistance(codedInputStreamMicro.readInt32());
                                continue;
                            case 50:
                                point = new Point();
                                codedInputStreamMicro.readMessage(point);
                                setLabelPoint(point);
                                continue;
                            case 58:
                                point = new Point();
                                codedInputStreamMicro.readMessage(point);
                                setStart(point);
                                continue;
                            case 66:
                                point = new Point();
                                codedInputStreamMicro.readMessage(point);
                                setEnd(point);
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

                public ViaMainRoad setDistance(int i) {
                    this.f10667i = true;
                    this.f10668j = i;
                    return this;
                }

                public ViaMainRoad setEnd(Point point) {
                    if (point == null) {
                        return clearEnd();
                    }
                    this.f10673o = true;
                    this.f10674p = point;
                    return this;
                }

                public ViaMainRoad setLabelPoint(Point point) {
                    if (point == null) {
                        return clearLabelPoint();
                    }
                    this.f10669k = true;
                    this.f10670l = point;
                    return this;
                }

                public ViaMainRoad setLaneCount(String str) {
                    this.f10663e = true;
                    this.f10664f = str;
                    return this;
                }

                public ViaMainRoad setMainRoadName(String str) {
                    this.f10659a = true;
                    this.f10660b = str;
                    return this;
                }

                public ViaMainRoad setMainRoadType(int i) {
                    this.f10661c = true;
                    this.f10662d = i;
                    return this;
                }

                public ViaMainRoad setSpeedLimit(String str) {
                    this.f10665g = true;
                    this.f10666h = str;
                    return this;
                }

                public ViaMainRoad setStart(Point point) {
                    if (point == null) {
                        return clearStart();
                    }
                    this.f10671m = true;
                    this.f10672n = point;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasMainRoadName()) {
                        codedOutputStreamMicro.writeString(1, getMainRoadName());
                    }
                    if (hasMainRoadType()) {
                        codedOutputStreamMicro.writeInt32(2, getMainRoadType());
                    }
                    if (hasLaneCount()) {
                        codedOutputStreamMicro.writeString(3, getLaneCount());
                    }
                    if (hasSpeedLimit()) {
                        codedOutputStreamMicro.writeString(4, getSpeedLimit());
                    }
                    if (hasDistance()) {
                        codedOutputStreamMicro.writeInt32(5, getDistance());
                    }
                    if (hasLabelPoint()) {
                        codedOutputStreamMicro.writeMessage(6, getLabelPoint());
                    }
                    if (hasStart()) {
                        codedOutputStreamMicro.writeMessage(7, getStart());
                    }
                    if (hasEnd()) {
                        codedOutputStreamMicro.writeMessage(8, getEnd());
                    }
                }
            }

            public static final class ViaService extends MessageMicro {
                public static final int CAN_BE_VIA_NODE_FIELD_NUMBER = 5;
                public static final int DURATION_FIELD_NUMBER = 3;
                public static final int LABEL_POINT_FIELD_NUMBER = 4;
                public static final int SERVICE_DISTANCE_FROM_START_FIELD_NUMBER = 2;
                public static final int SERVICE_NAME_FIELD_NUMBER = 1;
                /* renamed from: a */
                private boolean f10676a;
                /* renamed from: b */
                private String f10677b = "";
                /* renamed from: c */
                private boolean f10678c;
                /* renamed from: d */
                private int f10679d = 0;
                /* renamed from: e */
                private boolean f10680e;
                /* renamed from: f */
                private int f10681f = 0;
                /* renamed from: g */
                private boolean f10682g;
                /* renamed from: h */
                private Point f10683h = null;
                /* renamed from: i */
                private boolean f10684i;
                /* renamed from: j */
                private int f10685j = 0;
                /* renamed from: k */
                private int f10686k = -1;

                public static ViaService parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new ViaService().mergeFrom(codedInputStreamMicro);
                }

                public static ViaService parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (ViaService) new ViaService().mergeFrom(bArr);
                }

                public final ViaService clear() {
                    clearServiceName();
                    clearServiceDistanceFromStart();
                    clearDuration();
                    clearLabelPoint();
                    clearCanBeViaNode();
                    this.f10686k = -1;
                    return this;
                }

                public ViaService clearCanBeViaNode() {
                    this.f10684i = false;
                    this.f10685j = 0;
                    return this;
                }

                public ViaService clearDuration() {
                    this.f10680e = false;
                    this.f10681f = 0;
                    return this;
                }

                public ViaService clearLabelPoint() {
                    this.f10682g = false;
                    this.f10683h = null;
                    return this;
                }

                public ViaService clearServiceDistanceFromStart() {
                    this.f10678c = false;
                    this.f10679d = 0;
                    return this;
                }

                public ViaService clearServiceName() {
                    this.f10676a = false;
                    this.f10677b = "";
                    return this;
                }

                public int getCachedSize() {
                    if (this.f10686k < 0) {
                        getSerializedSize();
                    }
                    return this.f10686k;
                }

                public int getCanBeViaNode() {
                    return this.f10685j;
                }

                public int getDuration() {
                    return this.f10681f;
                }

                public Point getLabelPoint() {
                    return this.f10683h;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasServiceName()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getServiceName());
                    }
                    if (hasServiceDistanceFromStart()) {
                        i += CodedOutputStreamMicro.computeInt32Size(2, getServiceDistanceFromStart());
                    }
                    if (hasDuration()) {
                        i += CodedOutputStreamMicro.computeInt32Size(3, getDuration());
                    }
                    if (hasLabelPoint()) {
                        i += CodedOutputStreamMicro.computeMessageSize(4, getLabelPoint());
                    }
                    if (hasCanBeViaNode()) {
                        i += CodedOutputStreamMicro.computeInt32Size(5, getCanBeViaNode());
                    }
                    this.f10686k = i;
                    return i;
                }

                public int getServiceDistanceFromStart() {
                    return this.f10679d;
                }

                public String getServiceName() {
                    return this.f10677b;
                }

                public boolean hasCanBeViaNode() {
                    return this.f10684i;
                }

                public boolean hasDuration() {
                    return this.f10680e;
                }

                public boolean hasLabelPoint() {
                    return this.f10682g;
                }

                public boolean hasServiceDistanceFromStart() {
                    return this.f10678c;
                }

                public boolean hasServiceName() {
                    return this.f10676a;
                }

                public final boolean isInitialized() {
                    return this.f10676a && this.f10678c && this.f10680e && this.f10682g && this.f10684i && getLabelPoint().isInitialized();
                }

                public ViaService mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                setServiceName(codedInputStreamMicro.readString());
                                continue;
                            case 16:
                                setServiceDistanceFromStart(codedInputStreamMicro.readInt32());
                                continue;
                            case 24:
                                setDuration(codedInputStreamMicro.readInt32());
                                continue;
                            case 34:
                                MessageMicro point = new Point();
                                codedInputStreamMicro.readMessage(point);
                                setLabelPoint(point);
                                continue;
                            case 40:
                                setCanBeViaNode(codedInputStreamMicro.readInt32());
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

                public ViaService setCanBeViaNode(int i) {
                    this.f10684i = true;
                    this.f10685j = i;
                    return this;
                }

                public ViaService setDuration(int i) {
                    this.f10680e = true;
                    this.f10681f = i;
                    return this;
                }

                public ViaService setLabelPoint(Point point) {
                    if (point == null) {
                        return clearLabelPoint();
                    }
                    this.f10682g = true;
                    this.f10683h = point;
                    return this;
                }

                public ViaService setServiceDistanceFromStart(int i) {
                    this.f10678c = true;
                    this.f10679d = i;
                    return this;
                }

                public ViaService setServiceName(String str) {
                    this.f10676a = true;
                    this.f10677b = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasServiceName()) {
                        codedOutputStreamMicro.writeString(1, getServiceName());
                    }
                    if (hasServiceDistanceFromStart()) {
                        codedOutputStreamMicro.writeInt32(2, getServiceDistanceFromStart());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(3, getDuration());
                    }
                    if (hasLabelPoint()) {
                        codedOutputStreamMicro.writeMessage(4, getLabelPoint());
                    }
                    if (hasCanBeViaNode()) {
                        codedOutputStreamMicro.writeInt32(5, getCanBeViaNode());
                    }
                }
            }

            public static LongDistanceInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new LongDistanceInfo().mergeFrom(codedInputStreamMicro);
            }

            public static LongDistanceInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (LongDistanceInfo) new LongDistanceInfo().mergeFrom(bArr);
            }

            public LongDistanceInfo addViaCityInfo(ViaCityInfo viaCityInfo) {
                if (viaCityInfo != null) {
                    if (this.f10687a.isEmpty()) {
                        this.f10687a = new ArrayList();
                    }
                    this.f10687a.add(viaCityInfo);
                }
                return this;
            }

            public LongDistanceInfo addViaMainRoad(ViaMainRoad viaMainRoad) {
                if (viaMainRoad != null) {
                    if (this.f10688b.isEmpty()) {
                        this.f10688b = new ArrayList();
                    }
                    this.f10688b.add(viaMainRoad);
                }
                return this;
            }

            public LongDistanceInfo addViaService(ViaService viaService) {
                if (viaService != null) {
                    if (this.f10689c.isEmpty()) {
                        this.f10689c = new ArrayList();
                    }
                    this.f10689c.add(viaService);
                }
                return this;
            }

            public final LongDistanceInfo clear() {
                clearViaCityInfo();
                clearViaMainRoad();
                clearViaService();
                this.f10690d = -1;
                return this;
            }

            public LongDistanceInfo clearViaCityInfo() {
                this.f10687a = Collections.emptyList();
                return this;
            }

            public LongDistanceInfo clearViaMainRoad() {
                this.f10688b = Collections.emptyList();
                return this;
            }

            public LongDistanceInfo clearViaService() {
                this.f10689c = Collections.emptyList();
                return this;
            }

            public int getCachedSize() {
                if (this.f10690d < 0) {
                    getSerializedSize();
                }
                return this.f10690d;
            }

            public int getSerializedSize() {
                int i = 0;
                for (ViaCityInfo computeMessageSize : getViaCityInfoList()) {
                    i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
                }
                for (ViaMainRoad computeMessageSize2 : getViaMainRoadList()) {
                    i += CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize2);
                }
                for (ViaService computeMessageSize3 : getViaServiceList()) {
                    i += CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize3);
                }
                this.f10690d = i;
                return i;
            }

            public ViaCityInfo getViaCityInfo(int i) {
                return (ViaCityInfo) this.f10687a.get(i);
            }

            public int getViaCityInfoCount() {
                return this.f10687a.size();
            }

            public List<ViaCityInfo> getViaCityInfoList() {
                return this.f10687a;
            }

            public ViaMainRoad getViaMainRoad(int i) {
                return (ViaMainRoad) this.f10688b.get(i);
            }

            public int getViaMainRoadCount() {
                return this.f10688b.size();
            }

            public List<ViaMainRoad> getViaMainRoadList() {
                return this.f10688b;
            }

            public ViaService getViaService(int i) {
                return (ViaService) this.f10689c.get(i);
            }

            public int getViaServiceCount() {
                return this.f10689c.size();
            }

            public List<ViaService> getViaServiceList() {
                return this.f10689c;
            }

            public final boolean isInitialized() {
                for (ViaCityInfo isInitialized : getViaCityInfoList()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
                for (ViaMainRoad isInitialized2 : getViaMainRoadList()) {
                    if (!isInitialized2.isInitialized()) {
                        return false;
                    }
                }
                for (ViaService isInitialized3 : getViaServiceList()) {
                    if (!isInitialized3.isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public LongDistanceInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    MessageMicro viaCityInfo;
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            viaCityInfo = new ViaCityInfo();
                            codedInputStreamMicro.readMessage(viaCityInfo);
                            addViaCityInfo(viaCityInfo);
                            continue;
                        case 18:
                            viaCityInfo = new ViaMainRoad();
                            codedInputStreamMicro.readMessage(viaCityInfo);
                            addViaMainRoad(viaCityInfo);
                            continue;
                        case 26:
                            viaCityInfo = new ViaService();
                            codedInputStreamMicro.readMessage(viaCityInfo);
                            addViaService(viaCityInfo);
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

            public LongDistanceInfo setViaCityInfo(int i, ViaCityInfo viaCityInfo) {
                if (viaCityInfo != null) {
                    this.f10687a.set(i, viaCityInfo);
                }
                return this;
            }

            public LongDistanceInfo setViaMainRoad(int i, ViaMainRoad viaMainRoad) {
                if (viaMainRoad != null) {
                    this.f10688b.set(i, viaMainRoad);
                }
                return this;
            }

            public LongDistanceInfo setViaService(int i, ViaService viaService) {
                if (viaService != null) {
                    this.f10689c.set(i, viaService);
                }
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                for (ViaCityInfo writeMessage : getViaCityInfoList()) {
                    codedOutputStreamMicro.writeMessage(1, writeMessage);
                }
                for (ViaMainRoad writeMessage2 : getViaMainRoadList()) {
                    codedOutputStreamMicro.writeMessage(2, writeMessage2);
                }
                for (ViaService writeMessage3 : getViaServiceList()) {
                    codedOutputStreamMicro.writeMessage(3, writeMessage3);
                }
            }
        }

        public static final class Routes extends MessageMicro {
            public static final int CARROUTEPLANPREFERAVOIDJAM = 16;
            public static final int CARROUTEPLANPREFERCARNUM = 32;
            public static final int CARROUTEPLANPREFERDEFAULT = 1;
            public static final int CARROUTEPLANPREFERHIGHWAY = 2;
            public static final int CARROUTEPLANPREFERINVALID = 0;
            public static final int CARROUTEPLANPREFERNOHIGHWAY = 4;
            public static final int CARROUTEPLANPREFERNOTOLL = 8;
            public static final int CAR_PREFER_ARRAY_FIELD_NUMBER = 12;
            public static final int CONGESTION_LENGTH_FIELD_NUMBER = 9;
            public static final int DESC_FIELD_NUMBER = 1;
            public static final int LEGS_FIELD_NUMBER = 3;
            public static final int LIGHT_NUM_FIELD_NUMBER = 7;
            public static final int MAIN_ROADS_FIELD_NUMBER = 5;
            public static final int MRSL_FIELD_NUMBER = 2;
            public static final int ROUTE_DESC_FIELD_NUMBER = 16;
            public static final int ROUTE_LABEL_NAME_FIELD_NUMBER = 13;
            public static final int ROUTE_LABEL_TIPS_FIELD_NUMBER = 14;
            public static final int TAB_FIELD_NUMBER = 10;
            public static final int TOLL_FIELD_NUMBER = 6;
            public static final int TRAFFIC_CONDITION_FIELD_NUMBER = 4;
            public static final int UGC_TIPS_FIELD_NUMBER = 15;
            public static final int WAITING_TIME_FIELD_NUMBER = 8;
            public static final int WHOLE_CONDITION_FIELD_NUMBER = 11;
            /* renamed from: A */
            private String f10746A = "";
            /* renamed from: B */
            private boolean f10747B;
            /* renamed from: C */
            private String f10748C = "";
            /* renamed from: D */
            private boolean f10749D;
            /* renamed from: E */
            private String f10750E = "";
            /* renamed from: F */
            private int f10751F = -1;
            /* renamed from: a */
            private boolean f10752a;
            /* renamed from: b */
            private String f10753b = "";
            /* renamed from: c */
            private boolean f10754c;
            /* renamed from: d */
            private String f10755d = "";
            /* renamed from: e */
            private List<Legs> f10756e = Collections.emptyList();
            /* renamed from: f */
            private boolean f10757f;
            /* renamed from: g */
            private int f10758g = 0;
            /* renamed from: h */
            private boolean f10759h;
            /* renamed from: i */
            private String f10760i = "";
            /* renamed from: j */
            private boolean f10761j;
            /* renamed from: k */
            private int f10762k = 0;
            /* renamed from: l */
            private boolean f10763l;
            /* renamed from: m */
            private int f10764m = 0;
            /* renamed from: n */
            private boolean f10765n;
            /* renamed from: o */
            private String f10766o = "";
            /* renamed from: p */
            private boolean f10767p;
            /* renamed from: q */
            private int f10768q = 0;
            /* renamed from: r */
            private boolean f10769r;
            /* renamed from: s */
            private String f10770s = "";
            /* renamed from: t */
            private boolean f10771t;
            /* renamed from: u */
            private WholeCondition f10772u = null;
            /* renamed from: v */
            private boolean f10773v;
            /* renamed from: w */
            private CarPreferInfoArray f10774w = null;
            /* renamed from: x */
            private boolean f10775x;
            /* renamed from: y */
            private String f10776y = "";
            /* renamed from: z */
            private boolean f10777z;

            public static final class CarPreferInfo extends MessageMicro {
                public static final int CAR_PREFER_TAB_FIELD_NUMBER = 2;
                public static final int CAR_PREFER_VAL_FIELD_NUMBER = 1;
                /* renamed from: a */
                private boolean f10691a;
                /* renamed from: b */
                private int f10692b = 0;
                /* renamed from: c */
                private boolean f10693c;
                /* renamed from: d */
                private ByteStringMicro f10694d = ByteStringMicro.EMPTY;
                /* renamed from: e */
                private int f10695e = -1;

                public static CarPreferInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new CarPreferInfo().mergeFrom(codedInputStreamMicro);
                }

                public static CarPreferInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (CarPreferInfo) new CarPreferInfo().mergeFrom(bArr);
                }

                public final CarPreferInfo clear() {
                    clearCarPreferVal();
                    clearCarPreferTab();
                    this.f10695e = -1;
                    return this;
                }

                public CarPreferInfo clearCarPreferTab() {
                    this.f10693c = false;
                    this.f10694d = ByteStringMicro.EMPTY;
                    return this;
                }

                public CarPreferInfo clearCarPreferVal() {
                    this.f10691a = false;
                    this.f10692b = 0;
                    return this;
                }

                public int getCachedSize() {
                    if (this.f10695e < 0) {
                        getSerializedSize();
                    }
                    return this.f10695e;
                }

                public ByteStringMicro getCarPreferTab() {
                    return this.f10694d;
                }

                public int getCarPreferVal() {
                    return this.f10692b;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasCarPreferVal()) {
                        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCarPreferVal());
                    }
                    if (hasCarPreferTab()) {
                        i += CodedOutputStreamMicro.computeBytesSize(2, getCarPreferTab());
                    }
                    this.f10695e = i;
                    return i;
                }

                public boolean hasCarPreferTab() {
                    return this.f10693c;
                }

                public boolean hasCarPreferVal() {
                    return this.f10691a;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public CarPreferInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                setCarPreferVal(codedInputStreamMicro.readInt32());
                                continue;
                            case 18:
                                setCarPreferTab(codedInputStreamMicro.readBytes());
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

                public CarPreferInfo setCarPreferTab(ByteStringMicro byteStringMicro) {
                    this.f10693c = true;
                    this.f10694d = byteStringMicro;
                    return this;
                }

                public CarPreferInfo setCarPreferVal(int i) {
                    this.f10691a = true;
                    this.f10692b = i;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasCarPreferVal()) {
                        codedOutputStreamMicro.writeInt32(1, getCarPreferVal());
                    }
                    if (hasCarPreferTab()) {
                        codedOutputStreamMicro.writeBytes(2, getCarPreferTab());
                    }
                }
            }

            public static final class CarPreferInfoArray extends MessageMicro {
                public static final int CAR_CITY_CODE_FIELD_NUMBER = 2;
                public static final int CAR_INFO_ARRAY_FIELD_NUMBER = 1;
                public static final int LOCAL_ENABLE_TIPS_FIELD_NUMBER = 3;
                /* renamed from: a */
                private List<CarPreferInfo> f10696a = Collections.emptyList();
                /* renamed from: b */
                private boolean f10697b;
                /* renamed from: c */
                private int f10698c = -1;
                /* renamed from: d */
                private boolean f10699d;
                /* renamed from: e */
                private ByteStringMicro f10700e = ByteStringMicro.EMPTY;
                /* renamed from: f */
                private int f10701f = -1;

                public static CarPreferInfoArray parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new CarPreferInfoArray().mergeFrom(codedInputStreamMicro);
                }

                public static CarPreferInfoArray parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (CarPreferInfoArray) new CarPreferInfoArray().mergeFrom(bArr);
                }

                public CarPreferInfoArray addCarInfoArray(CarPreferInfo carPreferInfo) {
                    if (carPreferInfo != null) {
                        if (this.f10696a.isEmpty()) {
                            this.f10696a = new ArrayList();
                        }
                        this.f10696a.add(carPreferInfo);
                    }
                    return this;
                }

                public final CarPreferInfoArray clear() {
                    clearCarInfoArray();
                    clearCarCityCode();
                    clearLocalEnableTips();
                    this.f10701f = -1;
                    return this;
                }

                public CarPreferInfoArray clearCarCityCode() {
                    this.f10697b = false;
                    this.f10698c = -1;
                    return this;
                }

                public CarPreferInfoArray clearCarInfoArray() {
                    this.f10696a = Collections.emptyList();
                    return this;
                }

                public CarPreferInfoArray clearLocalEnableTips() {
                    this.f10699d = false;
                    this.f10700e = ByteStringMicro.EMPTY;
                    return this;
                }

                public int getCachedSize() {
                    if (this.f10701f < 0) {
                        getSerializedSize();
                    }
                    return this.f10701f;
                }

                public int getCarCityCode() {
                    return this.f10698c;
                }

                public CarPreferInfo getCarInfoArray(int i) {
                    return (CarPreferInfo) this.f10696a.get(i);
                }

                public int getCarInfoArrayCount() {
                    return this.f10696a.size();
                }

                public List<CarPreferInfo> getCarInfoArrayList() {
                    return this.f10696a;
                }

                public ByteStringMicro getLocalEnableTips() {
                    return this.f10700e;
                }

                public int getSerializedSize() {
                    int i = 0;
                    for (CarPreferInfo computeMessageSize : getCarInfoArrayList()) {
                        i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
                    }
                    if (hasCarCityCode()) {
                        i += CodedOutputStreamMicro.computeInt32Size(2, getCarCityCode());
                    }
                    if (hasLocalEnableTips()) {
                        i += CodedOutputStreamMicro.computeBytesSize(3, getLocalEnableTips());
                    }
                    this.f10701f = i;
                    return i;
                }

                public boolean hasCarCityCode() {
                    return this.f10697b;
                }

                public boolean hasLocalEnableTips() {
                    return this.f10699d;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public CarPreferInfoArray mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                MessageMicro carPreferInfo = new CarPreferInfo();
                                codedInputStreamMicro.readMessage(carPreferInfo);
                                addCarInfoArray(carPreferInfo);
                                continue;
                            case 16:
                                setCarCityCode(codedInputStreamMicro.readInt32());
                                continue;
                            case 26:
                                setLocalEnableTips(codedInputStreamMicro.readBytes());
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

                public CarPreferInfoArray setCarCityCode(int i) {
                    this.f10697b = true;
                    this.f10698c = i;
                    return this;
                }

                public CarPreferInfoArray setCarInfoArray(int i, CarPreferInfo carPreferInfo) {
                    if (carPreferInfo != null) {
                        this.f10696a.set(i, carPreferInfo);
                    }
                    return this;
                }

                public CarPreferInfoArray setLocalEnableTips(ByteStringMicro byteStringMicro) {
                    this.f10699d = true;
                    this.f10700e = byteStringMicro;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    for (CarPreferInfo writeMessage : getCarInfoArrayList()) {
                        codedOutputStreamMicro.writeMessage(1, writeMessage);
                    }
                    if (hasCarCityCode()) {
                        codedOutputStreamMicro.writeInt32(2, getCarCityCode());
                    }
                    if (hasLocalEnableTips()) {
                        codedOutputStreamMicro.writeBytes(3, getLocalEnableTips());
                    }
                }
            }

            public static final class Legs extends MessageMicro {
                public static final int DISTANCE_FIELD_NUMBER = 1;
                public static final int DURATION_FIELD_NUMBER = 2;
                public static final int DURATION_INFO_FIELD_NUMBER = 5;
                public static final int DURATION_WHOLEDAY_FIELD_NUMBER = 6;
                public static final int MRSL_FIELD_NUMBER = 4;
                public static final int STEPIS_FIELD_NUMBER = 3;
                /* renamed from: a */
                private boolean f10729a;
                /* renamed from: b */
                private int f10730b = 0;
                /* renamed from: c */
                private boolean f10731c;
                /* renamed from: d */
                private int f10732d = 0;
                /* renamed from: e */
                private List<Stepis> f10733e = Collections.emptyList();
                /* renamed from: f */
                private boolean f10734f;
                /* renamed from: g */
                private String f10735g = "";
                /* renamed from: h */
                private boolean f10736h;
                /* renamed from: i */
                private DurationInfo f10737i = null;
                /* renamed from: j */
                private boolean f10738j;
                /* renamed from: k */
                private DurationWholeday f10739k = null;
                /* renamed from: l */
                private int f10740l = -1;

                public static final class DurationInfo extends MessageMicro {
                    public static final int INFOS_FIELD_NUMBER = 3;
                    public static final int INTERVAL_FIELD_NUMBER = 1;
                    public static final int TIMESTAMP_FIELD_NUMBER = 2;
                    /* renamed from: a */
                    private List<Infos> f10707a = Collections.emptyList();
                    /* renamed from: b */
                    private boolean f10708b;
                    /* renamed from: c */
                    private int f10709c = 0;
                    /* renamed from: d */
                    private boolean f10710d;
                    /* renamed from: e */
                    private String f10711e = "";
                    /* renamed from: f */
                    private int f10712f = -1;

                    public static final class Infos extends MessageMicro {
                        public static final int DURATION_FIELD_NUMBER = 2;
                        public static final int INDEX_FIELD_NUMBER = 1;
                        /* renamed from: a */
                        private boolean f10702a;
                        /* renamed from: b */
                        private int f10703b = 0;
                        /* renamed from: c */
                        private boolean f10704c;
                        /* renamed from: d */
                        private int f10705d = 0;
                        /* renamed from: e */
                        private int f10706e = -1;

                        public static Infos parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new Infos().mergeFrom(codedInputStreamMicro);
                        }

                        public static Infos parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (Infos) new Infos().mergeFrom(bArr);
                        }

                        public final Infos clear() {
                            clearIndex();
                            clearDuration();
                            this.f10706e = -1;
                            return this;
                        }

                        public Infos clearDuration() {
                            this.f10704c = false;
                            this.f10705d = 0;
                            return this;
                        }

                        public Infos clearIndex() {
                            this.f10702a = false;
                            this.f10703b = 0;
                            return this;
                        }

                        public int getCachedSize() {
                            if (this.f10706e < 0) {
                                getSerializedSize();
                            }
                            return this.f10706e;
                        }

                        public int getDuration() {
                            return this.f10705d;
                        }

                        public int getIndex() {
                            return this.f10703b;
                        }

                        public int getSerializedSize() {
                            int i = 0;
                            if (hasIndex()) {
                                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIndex());
                            }
                            if (hasDuration()) {
                                i += CodedOutputStreamMicro.computeInt32Size(2, getDuration());
                            }
                            this.f10706e = i;
                            return i;
                        }

                        public boolean hasDuration() {
                            return this.f10704c;
                        }

                        public boolean hasIndex() {
                            return this.f10702a;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public Infos mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                switch (readTag) {
                                    case 0:
                                        break;
                                    case 8:
                                        setIndex(codedInputStreamMicro.readInt32());
                                        continue;
                                    case 16:
                                        setDuration(codedInputStreamMicro.readInt32());
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

                        public Infos setDuration(int i) {
                            this.f10704c = true;
                            this.f10705d = i;
                            return this;
                        }

                        public Infos setIndex(int i) {
                            this.f10702a = true;
                            this.f10703b = i;
                            return this;
                        }

                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasIndex()) {
                                codedOutputStreamMicro.writeInt32(1, getIndex());
                            }
                            if (hasDuration()) {
                                codedOutputStreamMicro.writeInt32(2, getDuration());
                            }
                        }
                    }

                    public static DurationInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new DurationInfo().mergeFrom(codedInputStreamMicro);
                    }

                    public static DurationInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (DurationInfo) new DurationInfo().mergeFrom(bArr);
                    }

                    public DurationInfo addInfos(Infos infos) {
                        if (infos != null) {
                            if (this.f10707a.isEmpty()) {
                                this.f10707a = new ArrayList();
                            }
                            this.f10707a.add(infos);
                        }
                        return this;
                    }

                    public final DurationInfo clear() {
                        clearInfos();
                        clearInterval();
                        clearTimestamp();
                        this.f10712f = -1;
                        return this;
                    }

                    public DurationInfo clearInfos() {
                        this.f10707a = Collections.emptyList();
                        return this;
                    }

                    public DurationInfo clearInterval() {
                        this.f10708b = false;
                        this.f10709c = 0;
                        return this;
                    }

                    public DurationInfo clearTimestamp() {
                        this.f10710d = false;
                        this.f10711e = "";
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f10712f < 0) {
                            getSerializedSize();
                        }
                        return this.f10712f;
                    }

                    public Infos getInfos(int i) {
                        return (Infos) this.f10707a.get(i);
                    }

                    public int getInfosCount() {
                        return this.f10707a.size();
                    }

                    public List<Infos> getInfosList() {
                        return this.f10707a;
                    }

                    public int getInterval() {
                        return this.f10709c;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasInterval()) {
                            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getInterval());
                        }
                        if (hasTimestamp()) {
                            i += CodedOutputStreamMicro.computeStringSize(2, getTimestamp());
                        }
                        int i2 = i;
                        for (Infos computeMessageSize : getInfosList()) {
                            i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
                        }
                        this.f10712f = i2;
                        return i2;
                    }

                    public String getTimestamp() {
                        return this.f10711e;
                    }

                    public boolean hasInterval() {
                        return this.f10708b;
                    }

                    public boolean hasTimestamp() {
                        return this.f10710d;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public DurationInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    setInterval(codedInputStreamMicro.readInt32());
                                    continue;
                                case 18:
                                    setTimestamp(codedInputStreamMicro.readString());
                                    continue;
                                case 26:
                                    MessageMicro infos = new Infos();
                                    codedInputStreamMicro.readMessage(infos);
                                    addInfos(infos);
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

                    public DurationInfo setInfos(int i, Infos infos) {
                        if (infos != null) {
                            this.f10707a.set(i, infos);
                        }
                        return this;
                    }

                    public DurationInfo setInterval(int i) {
                        this.f10708b = true;
                        this.f10709c = i;
                        return this;
                    }

                    public DurationInfo setTimestamp(String str) {
                        this.f10710d = true;
                        this.f10711e = str;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasInterval()) {
                            codedOutputStreamMicro.writeInt32(1, getInterval());
                        }
                        if (hasTimestamp()) {
                            codedOutputStreamMicro.writeString(2, getTimestamp());
                        }
                        for (Infos writeMessage : getInfosList()) {
                            codedOutputStreamMicro.writeMessage(3, writeMessage);
                        }
                    }
                }

                public static final class DurationWholeday extends MessageMicro {
                    public static final int INFOS_FIELD_NUMBER = 3;
                    public static final int INTERVAL_FIELD_NUMBER = 1;
                    public static final int TIMESTAMP_FIELD_NUMBER = 2;
                    /* renamed from: a */
                    private List<Infos> f10718a = Collections.emptyList();
                    /* renamed from: b */
                    private boolean f10719b;
                    /* renamed from: c */
                    private int f10720c = 0;
                    /* renamed from: d */
                    private boolean f10721d;
                    /* renamed from: e */
                    private String f10722e = "";
                    /* renamed from: f */
                    private int f10723f = -1;

                    public static final class Infos extends MessageMicro {
                        public static final int DURATION_FIELD_NUMBER = 2;
                        public static final int INDEX_FIELD_NUMBER = 1;
                        /* renamed from: a */
                        private boolean f10713a;
                        /* renamed from: b */
                        private int f10714b = 0;
                        /* renamed from: c */
                        private boolean f10715c;
                        /* renamed from: d */
                        private int f10716d = 0;
                        /* renamed from: e */
                        private int f10717e = -1;

                        public static Infos parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new Infos().mergeFrom(codedInputStreamMicro);
                        }

                        public static Infos parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (Infos) new Infos().mergeFrom(bArr);
                        }

                        public final Infos clear() {
                            clearIndex();
                            clearDuration();
                            this.f10717e = -1;
                            return this;
                        }

                        public Infos clearDuration() {
                            this.f10715c = false;
                            this.f10716d = 0;
                            return this;
                        }

                        public Infos clearIndex() {
                            this.f10713a = false;
                            this.f10714b = 0;
                            return this;
                        }

                        public int getCachedSize() {
                            if (this.f10717e < 0) {
                                getSerializedSize();
                            }
                            return this.f10717e;
                        }

                        public int getDuration() {
                            return this.f10716d;
                        }

                        public int getIndex() {
                            return this.f10714b;
                        }

                        public int getSerializedSize() {
                            int i = 0;
                            if (hasIndex()) {
                                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIndex());
                            }
                            if (hasDuration()) {
                                i += CodedOutputStreamMicro.computeInt32Size(2, getDuration());
                            }
                            this.f10717e = i;
                            return i;
                        }

                        public boolean hasDuration() {
                            return this.f10715c;
                        }

                        public boolean hasIndex() {
                            return this.f10713a;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public Infos mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                switch (readTag) {
                                    case 0:
                                        break;
                                    case 8:
                                        setIndex(codedInputStreamMicro.readInt32());
                                        continue;
                                    case 16:
                                        setDuration(codedInputStreamMicro.readInt32());
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

                        public Infos setDuration(int i) {
                            this.f10715c = true;
                            this.f10716d = i;
                            return this;
                        }

                        public Infos setIndex(int i) {
                            this.f10713a = true;
                            this.f10714b = i;
                            return this;
                        }

                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasIndex()) {
                                codedOutputStreamMicro.writeInt32(1, getIndex());
                            }
                            if (hasDuration()) {
                                codedOutputStreamMicro.writeInt32(2, getDuration());
                            }
                        }
                    }

                    public static DurationWholeday parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new DurationWholeday().mergeFrom(codedInputStreamMicro);
                    }

                    public static DurationWholeday parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (DurationWholeday) new DurationWholeday().mergeFrom(bArr);
                    }

                    public DurationWholeday addInfos(Infos infos) {
                        if (infos != null) {
                            if (this.f10718a.isEmpty()) {
                                this.f10718a = new ArrayList();
                            }
                            this.f10718a.add(infos);
                        }
                        return this;
                    }

                    public final DurationWholeday clear() {
                        clearInfos();
                        clearInterval();
                        clearTimestamp();
                        this.f10723f = -1;
                        return this;
                    }

                    public DurationWholeday clearInfos() {
                        this.f10718a = Collections.emptyList();
                        return this;
                    }

                    public DurationWholeday clearInterval() {
                        this.f10719b = false;
                        this.f10720c = 0;
                        return this;
                    }

                    public DurationWholeday clearTimestamp() {
                        this.f10721d = false;
                        this.f10722e = "";
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f10723f < 0) {
                            getSerializedSize();
                        }
                        return this.f10723f;
                    }

                    public Infos getInfos(int i) {
                        return (Infos) this.f10718a.get(i);
                    }

                    public int getInfosCount() {
                        return this.f10718a.size();
                    }

                    public List<Infos> getInfosList() {
                        return this.f10718a;
                    }

                    public int getInterval() {
                        return this.f10720c;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasInterval()) {
                            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getInterval());
                        }
                        if (hasTimestamp()) {
                            i += CodedOutputStreamMicro.computeStringSize(2, getTimestamp());
                        }
                        int i2 = i;
                        for (Infos computeMessageSize : getInfosList()) {
                            i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
                        }
                        this.f10723f = i2;
                        return i2;
                    }

                    public String getTimestamp() {
                        return this.f10722e;
                    }

                    public boolean hasInterval() {
                        return this.f10719b;
                    }

                    public boolean hasTimestamp() {
                        return this.f10721d;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public DurationWholeday mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    setInterval(codedInputStreamMicro.readInt32());
                                    continue;
                                case 18:
                                    setTimestamp(codedInputStreamMicro.readString());
                                    continue;
                                case 26:
                                    MessageMicro infos = new Infos();
                                    codedInputStreamMicro.readMessage(infos);
                                    addInfos(infos);
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

                    public DurationWholeday setInfos(int i, Infos infos) {
                        if (infos != null) {
                            this.f10718a.set(i, infos);
                        }
                        return this;
                    }

                    public DurationWholeday setInterval(int i) {
                        this.f10719b = true;
                        this.f10720c = i;
                        return this;
                    }

                    public DurationWholeday setTimestamp(String str) {
                        this.f10721d = true;
                        this.f10722e = str;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasInterval()) {
                            codedOutputStreamMicro.writeInt32(1, getInterval());
                        }
                        if (hasTimestamp()) {
                            codedOutputStreamMicro.writeString(2, getTimestamp());
                        }
                        for (Infos writeMessage : getInfosList()) {
                            codedOutputStreamMicro.writeMessage(3, writeMessage);
                        }
                    }
                }

                public static final class Stepis extends MessageMicro {
                    public static final int N_FIELD_NUMBER = 1;
                    public static final int S_FIELD_NUMBER = 2;
                    /* renamed from: a */
                    private boolean f10724a;
                    /* renamed from: b */
                    private int f10725b = 0;
                    /* renamed from: c */
                    private boolean f10726c;
                    /* renamed from: d */
                    private int f10727d = 0;
                    /* renamed from: e */
                    private int f10728e = -1;

                    public static Stepis parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Stepis().mergeFrom(codedInputStreamMicro);
                    }

                    public static Stepis parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Stepis) new Stepis().mergeFrom(bArr);
                    }

                    public final Stepis clear() {
                        clearN();
                        clearS();
                        this.f10728e = -1;
                        return this;
                    }

                    public Stepis clearN() {
                        this.f10724a = false;
                        this.f10725b = 0;
                        return this;
                    }

                    public Stepis clearS() {
                        this.f10726c = false;
                        this.f10727d = 0;
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f10728e < 0) {
                            getSerializedSize();
                        }
                        return this.f10728e;
                    }

                    public int getN() {
                        return this.f10725b;
                    }

                    public int getS() {
                        return this.f10727d;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasN()) {
                            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getN());
                        }
                        if (hasS()) {
                            i += CodedOutputStreamMicro.computeInt32Size(2, getS());
                        }
                        this.f10728e = i;
                        return i;
                    }

                    public boolean hasN() {
                        return this.f10724a;
                    }

                    public boolean hasS() {
                        return this.f10726c;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Stepis mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    setN(codedInputStreamMicro.readInt32());
                                    continue;
                                case 16:
                                    setS(codedInputStreamMicro.readInt32());
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

                    public Stepis setN(int i) {
                        this.f10724a = true;
                        this.f10725b = i;
                        return this;
                    }

                    public Stepis setS(int i) {
                        this.f10726c = true;
                        this.f10727d = i;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasN()) {
                            codedOutputStreamMicro.writeInt32(1, getN());
                        }
                        if (hasS()) {
                            codedOutputStreamMicro.writeInt32(2, getS());
                        }
                    }
                }

                public static Legs parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Legs().mergeFrom(codedInputStreamMicro);
                }

                public static Legs parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Legs) new Legs().mergeFrom(bArr);
                }

                public Legs addStepis(Stepis stepis) {
                    if (stepis != null) {
                        if (this.f10733e.isEmpty()) {
                            this.f10733e = new ArrayList();
                        }
                        this.f10733e.add(stepis);
                    }
                    return this;
                }

                public final Legs clear() {
                    clearDistance();
                    clearDuration();
                    clearStepis();
                    clearMrsl();
                    clearDurationInfo();
                    clearDurationWholeday();
                    this.f10740l = -1;
                    return this;
                }

                public Legs clearDistance() {
                    this.f10729a = false;
                    this.f10730b = 0;
                    return this;
                }

                public Legs clearDuration() {
                    this.f10731c = false;
                    this.f10732d = 0;
                    return this;
                }

                public Legs clearDurationInfo() {
                    this.f10736h = false;
                    this.f10737i = null;
                    return this;
                }

                public Legs clearDurationWholeday() {
                    this.f10738j = false;
                    this.f10739k = null;
                    return this;
                }

                public Legs clearMrsl() {
                    this.f10734f = false;
                    this.f10735g = "";
                    return this;
                }

                public Legs clearStepis() {
                    this.f10733e = Collections.emptyList();
                    return this;
                }

                public int getCachedSize() {
                    if (this.f10740l < 0) {
                        getSerializedSize();
                    }
                    return this.f10740l;
                }

                public int getDistance() {
                    return this.f10730b;
                }

                public int getDuration() {
                    return this.f10732d;
                }

                public DurationInfo getDurationInfo() {
                    return this.f10737i;
                }

                public DurationWholeday getDurationWholeday() {
                    return this.f10739k;
                }

                public String getMrsl() {
                    return this.f10735g;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasDistance()) {
                        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getDistance());
                    }
                    if (hasDuration()) {
                        i += CodedOutputStreamMicro.computeInt32Size(2, getDuration());
                    }
                    int i2 = i;
                    for (Stepis computeMessageSize : getStepisList()) {
                        i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
                    }
                    if (hasMrsl()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(4, getMrsl());
                    }
                    if (hasDurationInfo()) {
                        i2 += CodedOutputStreamMicro.computeMessageSize(5, getDurationInfo());
                    }
                    if (hasDurationWholeday()) {
                        i2 += CodedOutputStreamMicro.computeMessageSize(6, getDurationWholeday());
                    }
                    this.f10740l = i2;
                    return i2;
                }

                public Stepis getStepis(int i) {
                    return (Stepis) this.f10733e.get(i);
                }

                public int getStepisCount() {
                    return this.f10733e.size();
                }

                public List<Stepis> getStepisList() {
                    return this.f10733e;
                }

                public boolean hasDistance() {
                    return this.f10729a;
                }

                public boolean hasDuration() {
                    return this.f10731c;
                }

                public boolean hasDurationInfo() {
                    return this.f10736h;
                }

                public boolean hasDurationWholeday() {
                    return this.f10738j;
                }

                public boolean hasMrsl() {
                    return this.f10734f;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Legs mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        MessageMicro stepis;
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
                                stepis = new Stepis();
                                codedInputStreamMicro.readMessage(stepis);
                                addStepis(stepis);
                                continue;
                            case 34:
                                setMrsl(codedInputStreamMicro.readString());
                                continue;
                            case 42:
                                stepis = new DurationInfo();
                                codedInputStreamMicro.readMessage(stepis);
                                setDurationInfo(stepis);
                                continue;
                            case 50:
                                stepis = new DurationWholeday();
                                codedInputStreamMicro.readMessage(stepis);
                                setDurationWholeday(stepis);
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

                public Legs setDistance(int i) {
                    this.f10729a = true;
                    this.f10730b = i;
                    return this;
                }

                public Legs setDuration(int i) {
                    this.f10731c = true;
                    this.f10732d = i;
                    return this;
                }

                public Legs setDurationInfo(DurationInfo durationInfo) {
                    if (durationInfo == null) {
                        return clearDurationInfo();
                    }
                    this.f10736h = true;
                    this.f10737i = durationInfo;
                    return this;
                }

                public Legs setDurationWholeday(DurationWholeday durationWholeday) {
                    if (durationWholeday == null) {
                        return clearDurationWholeday();
                    }
                    this.f10738j = true;
                    this.f10739k = durationWholeday;
                    return this;
                }

                public Legs setMrsl(String str) {
                    this.f10734f = true;
                    this.f10735g = str;
                    return this;
                }

                public Legs setStepis(int i, Stepis stepis) {
                    if (stepis != null) {
                        this.f10733e.set(i, stepis);
                    }
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasDistance()) {
                        codedOutputStreamMicro.writeInt32(1, getDistance());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(2, getDuration());
                    }
                    for (Stepis writeMessage : getStepisList()) {
                        codedOutputStreamMicro.writeMessage(3, writeMessage);
                    }
                    if (hasMrsl()) {
                        codedOutputStreamMicro.writeString(4, getMrsl());
                    }
                    if (hasDurationInfo()) {
                        codedOutputStreamMicro.writeMessage(5, getDurationInfo());
                    }
                    if (hasDurationWholeday()) {
                        codedOutputStreamMicro.writeMessage(6, getDurationWholeday());
                    }
                }
            }

            public static final class WholeCondition extends MessageMicro {
                public static final int LENGTH_FIELD_NUMBER = 2;
                public static final int TYPE_FIELD_NUMBER = 1;
                /* renamed from: a */
                private boolean f10741a;
                /* renamed from: b */
                private int f10742b = 0;
                /* renamed from: c */
                private boolean f10743c;
                /* renamed from: d */
                private int f10744d = 0;
                /* renamed from: e */
                private int f10745e = -1;

                public static WholeCondition parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new WholeCondition().mergeFrom(codedInputStreamMicro);
                }

                public static WholeCondition parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (WholeCondition) new WholeCondition().mergeFrom(bArr);
                }

                public final WholeCondition clear() {
                    clearType();
                    clearLength();
                    this.f10745e = -1;
                    return this;
                }

                public WholeCondition clearLength() {
                    this.f10743c = false;
                    this.f10744d = 0;
                    return this;
                }

                public WholeCondition clearType() {
                    this.f10741a = false;
                    this.f10742b = 0;
                    return this;
                }

                public int getCachedSize() {
                    if (this.f10745e < 0) {
                        getSerializedSize();
                    }
                    return this.f10745e;
                }

                public int getLength() {
                    return this.f10744d;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasType()) {
                        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getType());
                    }
                    if (hasLength()) {
                        i += CodedOutputStreamMicro.computeInt32Size(2, getLength());
                    }
                    this.f10745e = i;
                    return i;
                }

                public int getType() {
                    return this.f10742b;
                }

                public boolean hasLength() {
                    return this.f10743c;
                }

                public boolean hasType() {
                    return this.f10741a;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public WholeCondition mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                setType(codedInputStreamMicro.readInt32());
                                continue;
                            case 16:
                                setLength(codedInputStreamMicro.readInt32());
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

                public WholeCondition setLength(int i) {
                    this.f10743c = true;
                    this.f10744d = i;
                    return this;
                }

                public WholeCondition setType(int i) {
                    this.f10741a = true;
                    this.f10742b = i;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(1, getType());
                    }
                    if (hasLength()) {
                        codedOutputStreamMicro.writeInt32(2, getLength());
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
                    if (this.f10756e.isEmpty()) {
                        this.f10756e = new ArrayList();
                    }
                    this.f10756e.add(legs);
                }
                return this;
            }

            public final Routes clear() {
                clearDesc();
                clearMrsl();
                clearLegs();
                clearTrafficCondition();
                clearMainRoads();
                clearToll();
                clearLightNum();
                clearWaitingTime();
                clearCongestionLength();
                clearTab();
                clearWholeCondition();
                clearCarPreferArray();
                clearRouteLabelName();
                clearRouteLabelTips();
                clearUgcTips();
                clearRouteDesc();
                this.f10751F = -1;
                return this;
            }

            public Routes clearCarPreferArray() {
                this.f10773v = false;
                this.f10774w = null;
                return this;
            }

            public Routes clearCongestionLength() {
                this.f10767p = false;
                this.f10768q = 0;
                return this;
            }

            public Routes clearDesc() {
                this.f10752a = false;
                this.f10753b = "";
                return this;
            }

            public Routes clearLegs() {
                this.f10756e = Collections.emptyList();
                return this;
            }

            public Routes clearLightNum() {
                this.f10763l = false;
                this.f10764m = 0;
                return this;
            }

            public Routes clearMainRoads() {
                this.f10759h = false;
                this.f10760i = "";
                return this;
            }

            public Routes clearMrsl() {
                this.f10754c = false;
                this.f10755d = "";
                return this;
            }

            public Routes clearRouteDesc() {
                this.f10749D = false;
                this.f10750E = "";
                return this;
            }

            public Routes clearRouteLabelName() {
                this.f10775x = false;
                this.f10776y = "";
                return this;
            }

            public Routes clearRouteLabelTips() {
                this.f10777z = false;
                this.f10746A = "";
                return this;
            }

            public Routes clearTab() {
                this.f10769r = false;
                this.f10770s = "";
                return this;
            }

            public Routes clearToll() {
                this.f10761j = false;
                this.f10762k = 0;
                return this;
            }

            public Routes clearTrafficCondition() {
                this.f10757f = false;
                this.f10758g = 0;
                return this;
            }

            public Routes clearUgcTips() {
                this.f10747B = false;
                this.f10748C = "";
                return this;
            }

            public Routes clearWaitingTime() {
                this.f10765n = false;
                this.f10766o = "";
                return this;
            }

            public Routes clearWholeCondition() {
                this.f10771t = false;
                this.f10772u = null;
                return this;
            }

            public int getCachedSize() {
                if (this.f10751F < 0) {
                    getSerializedSize();
                }
                return this.f10751F;
            }

            public CarPreferInfoArray getCarPreferArray() {
                return this.f10774w;
            }

            public int getCongestionLength() {
                return this.f10768q;
            }

            public String getDesc() {
                return this.f10753b;
            }

            public Legs getLegs(int i) {
                return (Legs) this.f10756e.get(i);
            }

            public int getLegsCount() {
                return this.f10756e.size();
            }

            public List<Legs> getLegsList() {
                return this.f10756e;
            }

            public int getLightNum() {
                return this.f10764m;
            }

            public String getMainRoads() {
                return this.f10760i;
            }

            public String getMrsl() {
                return this.f10755d;
            }

            public String getRouteDesc() {
                return this.f10750E;
            }

            public String getRouteLabelName() {
                return this.f10776y;
            }

            public String getRouteLabelTips() {
                return this.f10746A;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasDesc()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getDesc());
                }
                if (hasMrsl()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getMrsl());
                }
                int i2 = i;
                for (Legs computeMessageSize : getLegsList()) {
                    i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
                }
                if (hasTrafficCondition()) {
                    i2 += CodedOutputStreamMicro.computeInt32Size(4, getTrafficCondition());
                }
                if (hasMainRoads()) {
                    i2 += CodedOutputStreamMicro.computeStringSize(5, getMainRoads());
                }
                if (hasToll()) {
                    i2 += CodedOutputStreamMicro.computeInt32Size(6, getToll());
                }
                if (hasLightNum()) {
                    i2 += CodedOutputStreamMicro.computeInt32Size(7, getLightNum());
                }
                if (hasWaitingTime()) {
                    i2 += CodedOutputStreamMicro.computeStringSize(8, getWaitingTime());
                }
                if (hasCongestionLength()) {
                    i2 += CodedOutputStreamMicro.computeInt32Size(9, getCongestionLength());
                }
                if (hasTab()) {
                    i2 += CodedOutputStreamMicro.computeStringSize(10, getTab());
                }
                if (hasWholeCondition()) {
                    i2 += CodedOutputStreamMicro.computeMessageSize(11, getWholeCondition());
                }
                if (hasCarPreferArray()) {
                    i2 += CodedOutputStreamMicro.computeMessageSize(12, getCarPreferArray());
                }
                if (hasRouteLabelName()) {
                    i2 += CodedOutputStreamMicro.computeStringSize(13, getRouteLabelName());
                }
                if (hasRouteLabelTips()) {
                    i2 += CodedOutputStreamMicro.computeStringSize(14, getRouteLabelTips());
                }
                if (hasUgcTips()) {
                    i2 += CodedOutputStreamMicro.computeStringSize(15, getUgcTips());
                }
                if (hasRouteDesc()) {
                    i2 += CodedOutputStreamMicro.computeStringSize(16, getRouteDesc());
                }
                this.f10751F = i2;
                return i2;
            }

            public String getTab() {
                return this.f10770s;
            }

            public int getToll() {
                return this.f10762k;
            }

            public int getTrafficCondition() {
                return this.f10758g;
            }

            public String getUgcTips() {
                return this.f10748C;
            }

            public String getWaitingTime() {
                return this.f10766o;
            }

            public WholeCondition getWholeCondition() {
                return this.f10772u;
            }

            public boolean hasCarPreferArray() {
                return this.f10773v;
            }

            public boolean hasCongestionLength() {
                return this.f10767p;
            }

            public boolean hasDesc() {
                return this.f10752a;
            }

            public boolean hasLightNum() {
                return this.f10763l;
            }

            public boolean hasMainRoads() {
                return this.f10759h;
            }

            public boolean hasMrsl() {
                return this.f10754c;
            }

            public boolean hasRouteDesc() {
                return this.f10749D;
            }

            public boolean hasRouteLabelName() {
                return this.f10775x;
            }

            public boolean hasRouteLabelTips() {
                return this.f10777z;
            }

            public boolean hasTab() {
                return this.f10769r;
            }

            public boolean hasToll() {
                return this.f10761j;
            }

            public boolean hasTrafficCondition() {
                return this.f10757f;
            }

            public boolean hasUgcTips() {
                return this.f10747B;
            }

            public boolean hasWaitingTime() {
                return this.f10765n;
            }

            public boolean hasWholeCondition() {
                return this.f10771t;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Routes mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    MessageMicro legs;
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setDesc(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setMrsl(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            legs = new Legs();
                            codedInputStreamMicro.readMessage(legs);
                            addLegs(legs);
                            continue;
                        case 32:
                            setTrafficCondition(codedInputStreamMicro.readInt32());
                            continue;
                        case 42:
                            setMainRoads(codedInputStreamMicro.readString());
                            continue;
                        case 48:
                            setToll(codedInputStreamMicro.readInt32());
                            continue;
                        case 56:
                            setLightNum(codedInputStreamMicro.readInt32());
                            continue;
                        case 66:
                            setWaitingTime(codedInputStreamMicro.readString());
                            continue;
                        case NavCarInfo.CarType_57L /*72*/:
                            setCongestionLength(codedInputStreamMicro.readInt32());
                            continue;
                        case 82:
                            setTab(codedInputStreamMicro.readString());
                            continue;
                        case 90:
                            legs = new WholeCondition();
                            codedInputStreamMicro.readMessage(legs);
                            setWholeCondition(legs);
                            continue;
                        case 98:
                            legs = new CarPreferInfoArray();
                            codedInputStreamMicro.readMessage(legs);
                            setCarPreferArray(legs);
                            continue;
                        case 106:
                            setRouteLabelName(codedInputStreamMicro.readString());
                            continue;
                        case 114:
                            setRouteLabelTips(codedInputStreamMicro.readString());
                            continue;
                        case C1253f.df /*122*/:
                            setUgcTips(codedInputStreamMicro.readString());
                            continue;
                        case 130:
                            setRouteDesc(codedInputStreamMicro.readString());
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

            public Routes setCarPreferArray(CarPreferInfoArray carPreferInfoArray) {
                if (carPreferInfoArray == null) {
                    return clearCarPreferArray();
                }
                this.f10773v = true;
                this.f10774w = carPreferInfoArray;
                return this;
            }

            public Routes setCongestionLength(int i) {
                this.f10767p = true;
                this.f10768q = i;
                return this;
            }

            public Routes setDesc(String str) {
                this.f10752a = true;
                this.f10753b = str;
                return this;
            }

            public Routes setLegs(int i, Legs legs) {
                if (legs != null) {
                    this.f10756e.set(i, legs);
                }
                return this;
            }

            public Routes setLightNum(int i) {
                this.f10763l = true;
                this.f10764m = i;
                return this;
            }

            public Routes setMainRoads(String str) {
                this.f10759h = true;
                this.f10760i = str;
                return this;
            }

            public Routes setMrsl(String str) {
                this.f10754c = true;
                this.f10755d = str;
                return this;
            }

            public Routes setRouteDesc(String str) {
                this.f10749D = true;
                this.f10750E = str;
                return this;
            }

            public Routes setRouteLabelName(String str) {
                this.f10775x = true;
                this.f10776y = str;
                return this;
            }

            public Routes setRouteLabelTips(String str) {
                this.f10777z = true;
                this.f10746A = str;
                return this;
            }

            public Routes setTab(String str) {
                this.f10769r = true;
                this.f10770s = str;
                return this;
            }

            public Routes setToll(int i) {
                this.f10761j = true;
                this.f10762k = i;
                return this;
            }

            public Routes setTrafficCondition(int i) {
                this.f10757f = true;
                this.f10758g = i;
                return this;
            }

            public Routes setUgcTips(String str) {
                this.f10747B = true;
                this.f10748C = str;
                return this;
            }

            public Routes setWaitingTime(String str) {
                this.f10765n = true;
                this.f10766o = str;
                return this;
            }

            public Routes setWholeCondition(WholeCondition wholeCondition) {
                if (wholeCondition == null) {
                    return clearWholeCondition();
                }
                this.f10771t = true;
                this.f10772u = wholeCondition;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasDesc()) {
                    codedOutputStreamMicro.writeString(1, getDesc());
                }
                if (hasMrsl()) {
                    codedOutputStreamMicro.writeString(2, getMrsl());
                }
                for (Legs writeMessage : getLegsList()) {
                    codedOutputStreamMicro.writeMessage(3, writeMessage);
                }
                if (hasTrafficCondition()) {
                    codedOutputStreamMicro.writeInt32(4, getTrafficCondition());
                }
                if (hasMainRoads()) {
                    codedOutputStreamMicro.writeString(5, getMainRoads());
                }
                if (hasToll()) {
                    codedOutputStreamMicro.writeInt32(6, getToll());
                }
                if (hasLightNum()) {
                    codedOutputStreamMicro.writeInt32(7, getLightNum());
                }
                if (hasWaitingTime()) {
                    codedOutputStreamMicro.writeString(8, getWaitingTime());
                }
                if (hasCongestionLength()) {
                    codedOutputStreamMicro.writeInt32(9, getCongestionLength());
                }
                if (hasTab()) {
                    codedOutputStreamMicro.writeString(10, getTab());
                }
                if (hasWholeCondition()) {
                    codedOutputStreamMicro.writeMessage(11, getWholeCondition());
                }
                if (hasCarPreferArray()) {
                    codedOutputStreamMicro.writeMessage(12, getCarPreferArray());
                }
                if (hasRouteLabelName()) {
                    codedOutputStreamMicro.writeString(13, getRouteLabelName());
                }
                if (hasRouteLabelTips()) {
                    codedOutputStreamMicro.writeString(14, getRouteLabelTips());
                }
                if (hasUgcTips()) {
                    codedOutputStreamMicro.writeString(15, getUgcTips());
                }
                if (hasRouteDesc()) {
                    codedOutputStreamMicro.writeString(16, getRouteDesc());
                }
            }
        }

        public static final class Steps extends MessageMicro {
            public static final int DIRECTION_FIELD_NUMBER = 1;
            public static final int DISTANCE_FIELD_NUMBER = 2;
            public static final int END_INSTRUCTIONS_FIELD_NUMBER = 7;
            public static final int INSTRUCTIONS_FIELD_NUMBER = 3;
            public static final int LEVEL_FIELD_NUMBER = 10;
            public static final int PATH_FIELD_NUMBER = 4;
            public static final int ROAD_TYPE_FIELD_NUMBER = 12;
            public static final int SPATH_FIELD_NUMBER = 8;
            public static final int START_INSTRUCTIONS_FIELD_NUMBER = 6;
            public static final int STEPRCS_FIELD_NUMBER = 11;
            public static final int TURN_FIELD_NUMBER = 5;
            public static final int USROADNAME_FIELD_NUMBER = 9;
            /* renamed from: a */
            private boolean f10783a;
            /* renamed from: b */
            private int f10784b = 0;
            /* renamed from: c */
            private boolean f10785c;
            /* renamed from: d */
            private int f10786d = 0;
            /* renamed from: e */
            private boolean f10787e;
            /* renamed from: f */
            private String f10788f = "";
            /* renamed from: g */
            private boolean f10789g;
            /* renamed from: h */
            private String f10790h = "";
            /* renamed from: i */
            private boolean f10791i;
            /* renamed from: j */
            private int f10792j = 0;
            /* renamed from: k */
            private boolean f10793k;
            /* renamed from: l */
            private String f10794l = "";
            /* renamed from: m */
            private boolean f10795m;
            /* renamed from: n */
            private String f10796n = "";
            /* renamed from: o */
            private List<Integer> f10797o = Collections.emptyList();
            /* renamed from: p */
            private boolean f10798p;
            /* renamed from: q */
            private String f10799q = "";
            /* renamed from: r */
            private boolean f10800r;
            /* renamed from: s */
            private int f10801s = 0;
            /* renamed from: t */
            private List<Steprcs> f10802t = Collections.emptyList();
            /* renamed from: u */
            private boolean f10803u;
            /* renamed from: v */
            private int f10804v = 0;
            /* renamed from: w */
            private int f10805w = -1;

            public static final class Steprcs extends MessageMicro {
                public static final int END_FIELD_NUMBER = 1;
                public static final int STATUS_FIELD_NUMBER = 2;
                /* renamed from: a */
                private boolean f10778a;
                /* renamed from: b */
                private int f10779b = 0;
                /* renamed from: c */
                private boolean f10780c;
                /* renamed from: d */
                private int f10781d = 0;
                /* renamed from: e */
                private int f10782e = -1;

                public static Steprcs parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Steprcs().mergeFrom(codedInputStreamMicro);
                }

                public static Steprcs parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Steprcs) new Steprcs().mergeFrom(bArr);
                }

                public final Steprcs clear() {
                    clearEnd();
                    clearStatus();
                    this.f10782e = -1;
                    return this;
                }

                public Steprcs clearEnd() {
                    this.f10778a = false;
                    this.f10779b = 0;
                    return this;
                }

                public Steprcs clearStatus() {
                    this.f10780c = false;
                    this.f10781d = 0;
                    return this;
                }

                public int getCachedSize() {
                    if (this.f10782e < 0) {
                        getSerializedSize();
                    }
                    return this.f10782e;
                }

                public int getEnd() {
                    return this.f10779b;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasEnd()) {
                        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getEnd());
                    }
                    if (hasStatus()) {
                        i += CodedOutputStreamMicro.computeInt32Size(2, getStatus());
                    }
                    this.f10782e = i;
                    return i;
                }

                public int getStatus() {
                    return this.f10781d;
                }

                public boolean hasEnd() {
                    return this.f10778a;
                }

                public boolean hasStatus() {
                    return this.f10780c;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Steprcs mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                setEnd(codedInputStreamMicro.readInt32());
                                continue;
                            case 16:
                                setStatus(codedInputStreamMicro.readInt32());
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

                public Steprcs setEnd(int i) {
                    this.f10778a = true;
                    this.f10779b = i;
                    return this;
                }

                public Steprcs setStatus(int i) {
                    this.f10780c = true;
                    this.f10781d = i;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasEnd()) {
                        codedOutputStreamMicro.writeInt32(1, getEnd());
                    }
                    if (hasStatus()) {
                        codedOutputStreamMicro.writeInt32(2, getStatus());
                    }
                }
            }

            public static Steps parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Steps().mergeFrom(codedInputStreamMicro);
            }

            public static Steps parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Steps) new Steps().mergeFrom(bArr);
            }

            public Steps addSpath(int i) {
                if (this.f10797o.isEmpty()) {
                    this.f10797o = new ArrayList();
                }
                this.f10797o.add(Integer.valueOf(i));
                return this;
            }

            public Steps addSteprcs(Steprcs steprcs) {
                if (steprcs != null) {
                    if (this.f10802t.isEmpty()) {
                        this.f10802t = new ArrayList();
                    }
                    this.f10802t.add(steprcs);
                }
                return this;
            }

            public final Steps clear() {
                clearDirection();
                clearDistance();
                clearInstructions();
                clearPath();
                clearTurn();
                clearStartInstructions();
                clearEndInstructions();
                clearSpath();
                clearUsroadname();
                clearLevel();
                clearSteprcs();
                clearRoadType();
                this.f10805w = -1;
                return this;
            }

            public Steps clearDirection() {
                this.f10783a = false;
                this.f10784b = 0;
                return this;
            }

            public Steps clearDistance() {
                this.f10785c = false;
                this.f10786d = 0;
                return this;
            }

            public Steps clearEndInstructions() {
                this.f10795m = false;
                this.f10796n = "";
                return this;
            }

            public Steps clearInstructions() {
                this.f10787e = false;
                this.f10788f = "";
                return this;
            }

            public Steps clearLevel() {
                this.f10800r = false;
                this.f10801s = 0;
                return this;
            }

            public Steps clearPath() {
                this.f10789g = false;
                this.f10790h = "";
                return this;
            }

            public Steps clearRoadType() {
                this.f10803u = false;
                this.f10804v = 0;
                return this;
            }

            public Steps clearSpath() {
                this.f10797o = Collections.emptyList();
                return this;
            }

            public Steps clearStartInstructions() {
                this.f10793k = false;
                this.f10794l = "";
                return this;
            }

            public Steps clearSteprcs() {
                this.f10802t = Collections.emptyList();
                return this;
            }

            public Steps clearTurn() {
                this.f10791i = false;
                this.f10792j = 0;
                return this;
            }

            public Steps clearUsroadname() {
                this.f10798p = false;
                this.f10799q = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f10805w < 0) {
                    getSerializedSize();
                }
                return this.f10805w;
            }

            public int getDirection() {
                return this.f10784b;
            }

            public int getDistance() {
                return this.f10786d;
            }

            public String getEndInstructions() {
                return this.f10796n;
            }

            public String getInstructions() {
                return this.f10788f;
            }

            public int getLevel() {
                return this.f10801s;
            }

            public String getPath() {
                return this.f10790h;
            }

            public int getRoadType() {
                return this.f10804v;
            }

            public int getSerializedSize() {
                int i = 0;
                int computeInt32Size = hasDirection() ? CodedOutputStreamMicro.computeInt32Size(1, getDirection()) + 0 : 0;
                if (hasDistance()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getDistance());
                }
                if (hasInstructions()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getInstructions());
                }
                if (hasPath()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getPath());
                }
                if (hasTurn()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(5, getTurn());
                }
                if (hasStartInstructions()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(6, getStartInstructions());
                }
                int computeStringSize = hasEndInstructions() ? computeInt32Size + CodedOutputStreamMicro.computeStringSize(7, getEndInstructions()) : computeInt32Size;
                for (Integer intValue : getSpathList()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue());
                }
                computeInt32Size = (computeStringSize + i) + (getSpathList().size() * 1);
                if (hasUsroadname()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(9, getUsroadname());
                }
                if (hasLevel()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(10, getLevel());
                }
                i = computeInt32Size;
                for (Steprcs computeMessageSize : getSteprcsList()) {
                    i = CodedOutputStreamMicro.computeMessageSize(11, computeMessageSize) + i;
                }
                if (hasRoadType()) {
                    i += CodedOutputStreamMicro.computeInt32Size(12, getRoadType());
                }
                this.f10805w = i;
                return i;
            }

            public int getSpath(int i) {
                return ((Integer) this.f10797o.get(i)).intValue();
            }

            public int getSpathCount() {
                return this.f10797o.size();
            }

            public List<Integer> getSpathList() {
                return this.f10797o;
            }

            public String getStartInstructions() {
                return this.f10794l;
            }

            public Steprcs getSteprcs(int i) {
                return (Steprcs) this.f10802t.get(i);
            }

            public int getSteprcsCount() {
                return this.f10802t.size();
            }

            public List<Steprcs> getSteprcsList() {
                return this.f10802t;
            }

            public int getTurn() {
                return this.f10792j;
            }

            public String getUsroadname() {
                return this.f10799q;
            }

            public boolean hasDirection() {
                return this.f10783a;
            }

            public boolean hasDistance() {
                return this.f10785c;
            }

            public boolean hasEndInstructions() {
                return this.f10795m;
            }

            public boolean hasInstructions() {
                return this.f10787e;
            }

            public boolean hasLevel() {
                return this.f10800r;
            }

            public boolean hasPath() {
                return this.f10789g;
            }

            public boolean hasRoadType() {
                return this.f10803u;
            }

            public boolean hasStartInstructions() {
                return this.f10793k;
            }

            public boolean hasTurn() {
                return this.f10791i;
            }

            public boolean hasUsroadname() {
                return this.f10798p;
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
                        case 8:
                            setDirection(codedInputStreamMicro.readInt32());
                            continue;
                        case 16:
                            setDistance(codedInputStreamMicro.readInt32());
                            continue;
                        case 26:
                            setInstructions(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setPath(codedInputStreamMicro.readString());
                            continue;
                        case 40:
                            setTurn(codedInputStreamMicro.readInt32());
                            continue;
                        case 50:
                            setStartInstructions(codedInputStreamMicro.readString());
                            continue;
                        case 58:
                            setEndInstructions(codedInputStreamMicro.readString());
                            continue;
                        case 64:
                            addSpath(codedInputStreamMicro.readSInt32());
                            continue;
                        case 74:
                            setUsroadname(codedInputStreamMicro.readString());
                            continue;
                        case 80:
                            setLevel(codedInputStreamMicro.readInt32());
                            continue;
                        case 90:
                            MessageMicro steprcs = new Steprcs();
                            codedInputStreamMicro.readMessage(steprcs);
                            addSteprcs(steprcs);
                            continue;
                        case 96:
                            setRoadType(codedInputStreamMicro.readInt32());
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

            public Steps setDirection(int i) {
                this.f10783a = true;
                this.f10784b = i;
                return this;
            }

            public Steps setDistance(int i) {
                this.f10785c = true;
                this.f10786d = i;
                return this;
            }

            public Steps setEndInstructions(String str) {
                this.f10795m = true;
                this.f10796n = str;
                return this;
            }

            public Steps setInstructions(String str) {
                this.f10787e = true;
                this.f10788f = str;
                return this;
            }

            public Steps setLevel(int i) {
                this.f10800r = true;
                this.f10801s = i;
                return this;
            }

            public Steps setPath(String str) {
                this.f10789g = true;
                this.f10790h = str;
                return this;
            }

            public Steps setRoadType(int i) {
                this.f10803u = true;
                this.f10804v = i;
                return this;
            }

            public Steps setSpath(int i, int i2) {
                this.f10797o.set(i, Integer.valueOf(i2));
                return this;
            }

            public Steps setStartInstructions(String str) {
                this.f10793k = true;
                this.f10794l = str;
                return this;
            }

            public Steps setSteprcs(int i, Steprcs steprcs) {
                if (steprcs != null) {
                    this.f10802t.set(i, steprcs);
                }
                return this;
            }

            public Steps setTurn(int i) {
                this.f10791i = true;
                this.f10792j = i;
                return this;
            }

            public Steps setUsroadname(String str) {
                this.f10798p = true;
                this.f10799q = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasDirection()) {
                    codedOutputStreamMicro.writeInt32(1, getDirection());
                }
                if (hasDistance()) {
                    codedOutputStreamMicro.writeInt32(2, getDistance());
                }
                if (hasInstructions()) {
                    codedOutputStreamMicro.writeString(3, getInstructions());
                }
                if (hasPath()) {
                    codedOutputStreamMicro.writeString(4, getPath());
                }
                if (hasTurn()) {
                    codedOutputStreamMicro.writeInt32(5, getTurn());
                }
                if (hasStartInstructions()) {
                    codedOutputStreamMicro.writeString(6, getStartInstructions());
                }
                if (hasEndInstructions()) {
                    codedOutputStreamMicro.writeString(7, getEndInstructions());
                }
                for (Integer intValue : getSpathList()) {
                    codedOutputStreamMicro.writeSInt32(8, intValue.intValue());
                }
                if (hasUsroadname()) {
                    codedOutputStreamMicro.writeString(9, getUsroadname());
                }
                if (hasLevel()) {
                    codedOutputStreamMicro.writeInt32(10, getLevel());
                }
                for (Steprcs writeMessage : getSteprcsList()) {
                    codedOutputStreamMicro.writeMessage(11, writeMessage);
                }
                if (hasRoadType()) {
                    codedOutputStreamMicro.writeInt32(12, getRoadType());
                }
            }
        }

        public static final class Stepts extends MessageMicro {
            public static final int END_FIELD_NUMBER = 1;
            public static final int STATUS_FIELD_NUMBER = 2;
            /* renamed from: a */
            private List<Integer> f10806a = Collections.emptyList();
            /* renamed from: b */
            private List<Integer> f10807b = Collections.emptyList();
            /* renamed from: c */
            private int f10808c = -1;

            public static Stepts parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Stepts().mergeFrom(codedInputStreamMicro);
            }

            public static Stepts parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Stepts) new Stepts().mergeFrom(bArr);
            }

            public Stepts addEnd(int i) {
                if (this.f10806a.isEmpty()) {
                    this.f10806a = new ArrayList();
                }
                this.f10806a.add(Integer.valueOf(i));
                return this;
            }

            public Stepts addStatus(int i) {
                if (this.f10807b.isEmpty()) {
                    this.f10807b = new ArrayList();
                }
                this.f10807b.add(Integer.valueOf(i));
                return this;
            }

            public final Stepts clear() {
                clearEnd();
                clearStatus();
                this.f10808c = -1;
                return this;
            }

            public Stepts clearEnd() {
                this.f10806a = Collections.emptyList();
                return this;
            }

            public Stepts clearStatus() {
                this.f10807b = Collections.emptyList();
                return this;
            }

            public int getCachedSize() {
                if (this.f10808c < 0) {
                    getSerializedSize();
                }
                return this.f10808c;
            }

            public int getEnd(int i) {
                return ((Integer) this.f10806a.get(i)).intValue();
            }

            public int getEndCount() {
                return this.f10806a.size();
            }

            public List<Integer> getEndList() {
                return this.f10806a;
            }

            public int getSerializedSize() {
                int i = 0;
                int i2 = 0;
                for (Integer intValue : getEndList()) {
                    i2 = CodedOutputStreamMicro.computeInt32SizeNoTag(intValue.intValue()) + i2;
                }
                i2 = (getEndList().size() * 1) + (0 + i2);
                for (Integer intValue2 : getStatusList()) {
                    i += CodedOutputStreamMicro.computeInt32SizeNoTag(intValue2.intValue());
                }
                int size = (i2 + i) + (getStatusList().size() * 1);
                this.f10808c = size;
                return size;
            }

            public int getStatus(int i) {
                return ((Integer) this.f10807b.get(i)).intValue();
            }

            public int getStatusCount() {
                return this.f10807b.size();
            }

            public List<Integer> getStatusList() {
                return this.f10807b;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Stepts mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            addEnd(codedInputStreamMicro.readInt32());
                            continue;
                        case 16:
                            addStatus(codedInputStreamMicro.readInt32());
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

            public Stepts setEnd(int i, int i2) {
                this.f10806a.set(i, Integer.valueOf(i2));
                return this;
            }

            public Stepts setStatus(int i, int i2) {
                this.f10807b.set(i, Integer.valueOf(i2));
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                for (Integer intValue : getEndList()) {
                    codedOutputStreamMicro.writeInt32(1, intValue.intValue());
                }
                for (Integer intValue2 : getStatusList()) {
                    codedOutputStreamMicro.writeInt32(2, intValue2.intValue());
                }
            }
        }

        public static final class Taxis extends MessageMicro {
            public static final int TOTAL_PRICE_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f10809a;
            /* renamed from: b */
            private String f10810b = "";
            /* renamed from: c */
            private int f10811c = -1;

            public static Taxis parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Taxis().mergeFrom(codedInputStreamMicro);
            }

            public static Taxis parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Taxis) new Taxis().mergeFrom(bArr);
            }

            public final Taxis clear() {
                clearTotalPrice();
                this.f10811c = -1;
                return this;
            }

            public Taxis clearTotalPrice() {
                this.f10809a = false;
                this.f10810b = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f10811c < 0) {
                    getSerializedSize();
                }
                return this.f10811c;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasTotalPrice()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTotalPrice());
                }
                this.f10811c = i;
                return i;
            }

            public String getTotalPrice() {
                return this.f10810b;
            }

            public boolean hasTotalPrice() {
                return this.f10809a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Taxis mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
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

            public Taxis setTotalPrice(String str) {
                this.f10809a = true;
                this.f10810b = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasTotalPrice()) {
                    codedOutputStreamMicro.writeString(1, getTotalPrice());
                }
            }
        }

        public static final class Traffics extends MessageMicro {
            public static final int CONGESTION_LENGTH_FIELD_NUMBER = 3;
            public static final int DIGEST_FIELD_NUMBER = 1;
            public static final int LEGS_FIELD_NUMBER = 2;
            public static final int UGC_TIPS_FIELD_NUMBER = 4;
            /* renamed from: a */
            private boolean f10825a;
            /* renamed from: b */
            private String f10826b = "";
            /* renamed from: c */
            private List<Legs> f10827c = Collections.emptyList();
            /* renamed from: d */
            private boolean f10828d;
            /* renamed from: e */
            private int f10829e = 0;
            /* renamed from: f */
            private boolean f10830f;
            /* renamed from: g */
            private String f10831g = "";
            /* renamed from: h */
            private int f10832h = -1;

            public static final class Legs extends MessageMicro {
                public static final int DISTANCE_FIELD_NUMBER = 1;
                public static final int DURATION_FIELD_NUMBER = 2;
                public static final int MRSL_FIELD_NUMBER = 4;
                public static final int STEPTIS_FIELD_NUMBER = 3;
                /* renamed from: a */
                private boolean f10817a;
                /* renamed from: b */
                private int f10818b = 0;
                /* renamed from: c */
                private boolean f10819c;
                /* renamed from: d */
                private int f10820d = 0;
                /* renamed from: e */
                private List<Steptis> f10821e = Collections.emptyList();
                /* renamed from: f */
                private boolean f10822f;
                /* renamed from: g */
                private String f10823g = "";
                /* renamed from: h */
                private int f10824h = -1;

                public static final class Steptis extends MessageMicro {
                    public static final int N_FIELD_NUMBER = 1;
                    public static final int S_FIELD_NUMBER = 2;
                    /* renamed from: a */
                    private boolean f10812a;
                    /* renamed from: b */
                    private int f10813b = 0;
                    /* renamed from: c */
                    private boolean f10814c;
                    /* renamed from: d */
                    private int f10815d = 0;
                    /* renamed from: e */
                    private int f10816e = -1;

                    public static Steptis parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Steptis().mergeFrom(codedInputStreamMicro);
                    }

                    public static Steptis parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Steptis) new Steptis().mergeFrom(bArr);
                    }

                    public final Steptis clear() {
                        clearN();
                        clearS();
                        this.f10816e = -1;
                        return this;
                    }

                    public Steptis clearN() {
                        this.f10812a = false;
                        this.f10813b = 0;
                        return this;
                    }

                    public Steptis clearS() {
                        this.f10814c = false;
                        this.f10815d = 0;
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f10816e < 0) {
                            getSerializedSize();
                        }
                        return this.f10816e;
                    }

                    public int getN() {
                        return this.f10813b;
                    }

                    public int getS() {
                        return this.f10815d;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasN()) {
                            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getN());
                        }
                        if (hasS()) {
                            i += CodedOutputStreamMicro.computeInt32Size(2, getS());
                        }
                        this.f10816e = i;
                        return i;
                    }

                    public boolean hasN() {
                        return this.f10812a;
                    }

                    public boolean hasS() {
                        return this.f10814c;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Steptis mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    setN(codedInputStreamMicro.readInt32());
                                    continue;
                                case 16:
                                    setS(codedInputStreamMicro.readInt32());
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

                    public Steptis setN(int i) {
                        this.f10812a = true;
                        this.f10813b = i;
                        return this;
                    }

                    public Steptis setS(int i) {
                        this.f10814c = true;
                        this.f10815d = i;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasN()) {
                            codedOutputStreamMicro.writeInt32(1, getN());
                        }
                        if (hasS()) {
                            codedOutputStreamMicro.writeInt32(2, getS());
                        }
                    }
                }

                public static Legs parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Legs().mergeFrom(codedInputStreamMicro);
                }

                public static Legs parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Legs) new Legs().mergeFrom(bArr);
                }

                public Legs addSteptis(Steptis steptis) {
                    if (steptis != null) {
                        if (this.f10821e.isEmpty()) {
                            this.f10821e = new ArrayList();
                        }
                        this.f10821e.add(steptis);
                    }
                    return this;
                }

                public final Legs clear() {
                    clearDistance();
                    clearDuration();
                    clearSteptis();
                    clearMrsl();
                    this.f10824h = -1;
                    return this;
                }

                public Legs clearDistance() {
                    this.f10817a = false;
                    this.f10818b = 0;
                    return this;
                }

                public Legs clearDuration() {
                    this.f10819c = false;
                    this.f10820d = 0;
                    return this;
                }

                public Legs clearMrsl() {
                    this.f10822f = false;
                    this.f10823g = "";
                    return this;
                }

                public Legs clearSteptis() {
                    this.f10821e = Collections.emptyList();
                    return this;
                }

                public int getCachedSize() {
                    if (this.f10824h < 0) {
                        getSerializedSize();
                    }
                    return this.f10824h;
                }

                public int getDistance() {
                    return this.f10818b;
                }

                public int getDuration() {
                    return this.f10820d;
                }

                public String getMrsl() {
                    return this.f10823g;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasDistance()) {
                        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getDistance());
                    }
                    if (hasDuration()) {
                        i += CodedOutputStreamMicro.computeInt32Size(2, getDuration());
                    }
                    int i2 = i;
                    for (Steptis computeMessageSize : getSteptisList()) {
                        i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
                    }
                    if (hasMrsl()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(4, getMrsl());
                    }
                    this.f10824h = i2;
                    return i2;
                }

                public Steptis getSteptis(int i) {
                    return (Steptis) this.f10821e.get(i);
                }

                public int getSteptisCount() {
                    return this.f10821e.size();
                }

                public List<Steptis> getSteptisList() {
                    return this.f10821e;
                }

                public boolean hasDistance() {
                    return this.f10817a;
                }

                public boolean hasDuration() {
                    return this.f10819c;
                }

                public boolean hasMrsl() {
                    return this.f10822f;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Legs mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                                MessageMicro steptis = new Steptis();
                                codedInputStreamMicro.readMessage(steptis);
                                addSteptis(steptis);
                                continue;
                            case 34:
                                setMrsl(codedInputStreamMicro.readString());
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

                public Legs setDistance(int i) {
                    this.f10817a = true;
                    this.f10818b = i;
                    return this;
                }

                public Legs setDuration(int i) {
                    this.f10819c = true;
                    this.f10820d = i;
                    return this;
                }

                public Legs setMrsl(String str) {
                    this.f10822f = true;
                    this.f10823g = str;
                    return this;
                }

                public Legs setSteptis(int i, Steptis steptis) {
                    if (steptis != null) {
                        this.f10821e.set(i, steptis);
                    }
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasDistance()) {
                        codedOutputStreamMicro.writeInt32(1, getDistance());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(2, getDuration());
                    }
                    for (Steptis writeMessage : getSteptisList()) {
                        codedOutputStreamMicro.writeMessage(3, writeMessage);
                    }
                    if (hasMrsl()) {
                        codedOutputStreamMicro.writeString(4, getMrsl());
                    }
                }
            }

            public static Traffics parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Traffics().mergeFrom(codedInputStreamMicro);
            }

            public static Traffics parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Traffics) new Traffics().mergeFrom(bArr);
            }

            public Traffics addLegs(Legs legs) {
                if (legs != null) {
                    if (this.f10827c.isEmpty()) {
                        this.f10827c = new ArrayList();
                    }
                    this.f10827c.add(legs);
                }
                return this;
            }

            public final Traffics clear() {
                clearDigest();
                clearLegs();
                clearCongestionLength();
                clearUgcTips();
                this.f10832h = -1;
                return this;
            }

            public Traffics clearCongestionLength() {
                this.f10828d = false;
                this.f10829e = 0;
                return this;
            }

            public Traffics clearDigest() {
                this.f10825a = false;
                this.f10826b = "";
                return this;
            }

            public Traffics clearLegs() {
                this.f10827c = Collections.emptyList();
                return this;
            }

            public Traffics clearUgcTips() {
                this.f10830f = false;
                this.f10831g = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f10832h < 0) {
                    getSerializedSize();
                }
                return this.f10832h;
            }

            public int getCongestionLength() {
                return this.f10829e;
            }

            public String getDigest() {
                return this.f10826b;
            }

            public Legs getLegs(int i) {
                return (Legs) this.f10827c.get(i);
            }

            public int getLegsCount() {
                return this.f10827c.size();
            }

            public List<Legs> getLegsList() {
                return this.f10827c;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasDigest()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getDigest());
                }
                int i2 = i;
                for (Legs computeMessageSize : getLegsList()) {
                    i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
                }
                if (hasCongestionLength()) {
                    i2 += CodedOutputStreamMicro.computeInt32Size(3, getCongestionLength());
                }
                if (hasUgcTips()) {
                    i2 += CodedOutputStreamMicro.computeStringSize(4, getUgcTips());
                }
                this.f10832h = i2;
                return i2;
            }

            public String getUgcTips() {
                return this.f10831g;
            }

            public boolean hasCongestionLength() {
                return this.f10828d;
            }

            public boolean hasDigest() {
                return this.f10825a;
            }

            public boolean hasUgcTips() {
                return this.f10830f;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Traffics mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setDigest(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            MessageMicro legs = new Legs();
                            codedInputStreamMicro.readMessage(legs);
                            addLegs(legs);
                            continue;
                        case 24:
                            setCongestionLength(codedInputStreamMicro.readInt32());
                            continue;
                        case 34:
                            setUgcTips(codedInputStreamMicro.readString());
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

            public Traffics setCongestionLength(int i) {
                this.f10828d = true;
                this.f10829e = i;
                return this;
            }

            public Traffics setDigest(String str) {
                this.f10825a = true;
                this.f10826b = str;
                return this;
            }

            public Traffics setLegs(int i, Legs legs) {
                if (legs != null) {
                    this.f10827c.set(i, legs);
                }
                return this;
            }

            public Traffics setUgcTips(String str) {
                this.f10830f = true;
                this.f10831g = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasDigest()) {
                    codedOutputStreamMicro.writeString(1, getDigest());
                }
                for (Legs writeMessage : getLegsList()) {
                    codedOutputStreamMicro.writeMessage(2, writeMessage);
                }
                if (hasCongestionLength()) {
                    codedOutputStreamMicro.writeInt32(3, getCongestionLength());
                }
                if (hasUgcTips()) {
                    codedOutputStreamMicro.writeString(4, getUgcTips());
                }
            }
        }

        public static final class WalkInfoT extends MessageMicro {
            public static final int DIST_FIELD_NUMBER = 1;
            public static final int PT_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f10833a;
            /* renamed from: b */
            private int f10834b = 0;
            /* renamed from: c */
            private List<Integer> f10835c = Collections.emptyList();
            /* renamed from: d */
            private int f10836d = -1;

            public static WalkInfoT parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new WalkInfoT().mergeFrom(codedInputStreamMicro);
            }

            public static WalkInfoT parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (WalkInfoT) new WalkInfoT().mergeFrom(bArr);
            }

            public WalkInfoT addPt(int i) {
                if (this.f10835c.isEmpty()) {
                    this.f10835c = new ArrayList();
                }
                this.f10835c.add(Integer.valueOf(i));
                return this;
            }

            public final WalkInfoT clear() {
                clearDist();
                clearPt();
                this.f10836d = -1;
                return this;
            }

            public WalkInfoT clearDist() {
                this.f10833a = false;
                this.f10834b = 0;
                return this;
            }

            public WalkInfoT clearPt() {
                this.f10835c = Collections.emptyList();
                return this;
            }

            public int getCachedSize() {
                if (this.f10836d < 0) {
                    getSerializedSize();
                }
                return this.f10836d;
            }

            public int getDist() {
                return this.f10834b;
            }

            public int getPt(int i) {
                return ((Integer) this.f10835c.get(i)).intValue();
            }

            public int getPtCount() {
                return this.f10835c.size();
            }

            public List<Integer> getPtList() {
                return this.f10835c;
            }

            public int getSerializedSize() {
                int i = 0;
                int computeInt32Size = hasDist() ? CodedOutputStreamMicro.computeInt32Size(1, getDist()) + 0 : 0;
                for (Integer intValue : getPtList()) {
                    i += CodedOutputStreamMicro.computeInt32SizeNoTag(intValue.intValue());
                }
                int size = (computeInt32Size + i) + (getPtList().size() * 1);
                this.f10836d = size;
                return size;
            }

            public boolean hasDist() {
                return this.f10833a;
            }

            public final boolean isInitialized() {
                return this.f10833a;
            }

            public WalkInfoT mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            setDist(codedInputStreamMicro.readInt32());
                            continue;
                        case 16:
                            addPt(codedInputStreamMicro.readInt32());
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

            public WalkInfoT setDist(int i) {
                this.f10833a = true;
                this.f10834b = i;
                return this;
            }

            public WalkInfoT setPt(int i, int i2) {
                this.f10835c.set(i, Integer.valueOf(i2));
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasDist()) {
                    codedOutputStreamMicro.writeInt32(1, getDist());
                }
                for (Integer intValue : getPtList()) {
                    codedOutputStreamMicro.writeInt32(2, intValue.intValue());
                }
            }
        }

        public static final class YellowTipsList extends MessageMicro {
            public static final int MRSL_FIELD_NUMBER = 2;
            public static final int YELLOW_TIPS_INFO_FIELD_NUMBER = 1;
            /* renamed from: a */
            private List<YellowTipsInfo> f10850a = Collections.emptyList();
            /* renamed from: b */
            private boolean f10851b;
            /* renamed from: c */
            private String f10852c = "";
            /* renamed from: d */
            private int f10853d = -1;

            public static final class YellowTipsInfo extends MessageMicro {
                public static final int ASSIST_INFO_FIELD_NUMBER = 3;
                public static final int BACK_COLOR_ID_FIELD_NUMBER = 6;
                public static final int ICON_ID_FIELD_NUMBER = 5;
                public static final int SUB_TITLE_FIELD_NUMBER = 2;
                public static final int TIP_ID_FIELD_NUMBER = 4;
                public static final int TITLE_FIELD_NUMBER = 1;
                /* renamed from: a */
                private boolean f10837a;
                /* renamed from: b */
                private String f10838b = "";
                /* renamed from: c */
                private boolean f10839c;
                /* renamed from: d */
                private String f10840d = "";
                /* renamed from: e */
                private boolean f10841e;
                /* renamed from: f */
                private String f10842f = "";
                /* renamed from: g */
                private boolean f10843g;
                /* renamed from: h */
                private int f10844h = 0;
                /* renamed from: i */
                private boolean f10845i;
                /* renamed from: j */
                private int f10846j = 0;
                /* renamed from: k */
                private boolean f10847k;
                /* renamed from: l */
                private int f10848l = 0;
                /* renamed from: m */
                private int f10849m = -1;

                public static YellowTipsInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new YellowTipsInfo().mergeFrom(codedInputStreamMicro);
                }

                public static YellowTipsInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (YellowTipsInfo) new YellowTipsInfo().mergeFrom(bArr);
                }

                public final YellowTipsInfo clear() {
                    clearTitle();
                    clearSubTitle();
                    clearAssistInfo();
                    clearTipId();
                    clearIconId();
                    clearBackColorId();
                    this.f10849m = -1;
                    return this;
                }

                public YellowTipsInfo clearAssistInfo() {
                    this.f10841e = false;
                    this.f10842f = "";
                    return this;
                }

                public YellowTipsInfo clearBackColorId() {
                    this.f10847k = false;
                    this.f10848l = 0;
                    return this;
                }

                public YellowTipsInfo clearIconId() {
                    this.f10845i = false;
                    this.f10846j = 0;
                    return this;
                }

                public YellowTipsInfo clearSubTitle() {
                    this.f10839c = false;
                    this.f10840d = "";
                    return this;
                }

                public YellowTipsInfo clearTipId() {
                    this.f10843g = false;
                    this.f10844h = 0;
                    return this;
                }

                public YellowTipsInfo clearTitle() {
                    this.f10837a = false;
                    this.f10838b = "";
                    return this;
                }

                public String getAssistInfo() {
                    return this.f10842f;
                }

                public int getBackColorId() {
                    return this.f10848l;
                }

                public int getCachedSize() {
                    if (this.f10849m < 0) {
                        getSerializedSize();
                    }
                    return this.f10849m;
                }

                public int getIconId() {
                    return this.f10846j;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasTitle()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
                    }
                    if (hasSubTitle()) {
                        i += CodedOutputStreamMicro.computeStringSize(2, getSubTitle());
                    }
                    if (hasAssistInfo()) {
                        i += CodedOutputStreamMicro.computeStringSize(3, getAssistInfo());
                    }
                    if (hasTipId()) {
                        i += CodedOutputStreamMicro.computeInt32Size(4, getTipId());
                    }
                    if (hasIconId()) {
                        i += CodedOutputStreamMicro.computeInt32Size(5, getIconId());
                    }
                    if (hasBackColorId()) {
                        i += CodedOutputStreamMicro.computeInt32Size(6, getBackColorId());
                    }
                    this.f10849m = i;
                    return i;
                }

                public String getSubTitle() {
                    return this.f10840d;
                }

                public int getTipId() {
                    return this.f10844h;
                }

                public String getTitle() {
                    return this.f10838b;
                }

                public boolean hasAssistInfo() {
                    return this.f10841e;
                }

                public boolean hasBackColorId() {
                    return this.f10847k;
                }

                public boolean hasIconId() {
                    return this.f10845i;
                }

                public boolean hasSubTitle() {
                    return this.f10839c;
                }

                public boolean hasTipId() {
                    return this.f10843g;
                }

                public boolean hasTitle() {
                    return this.f10837a;
                }

                public final boolean isInitialized() {
                    return this.f10837a && this.f10843g;
                }

                public YellowTipsInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                setTitle(codedInputStreamMicro.readString());
                                continue;
                            case 18:
                                setSubTitle(codedInputStreamMicro.readString());
                                continue;
                            case 26:
                                setAssistInfo(codedInputStreamMicro.readString());
                                continue;
                            case 32:
                                setTipId(codedInputStreamMicro.readInt32());
                                continue;
                            case 40:
                                setIconId(codedInputStreamMicro.readInt32());
                                continue;
                            case 48:
                                setBackColorId(codedInputStreamMicro.readInt32());
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

                public YellowTipsInfo setAssistInfo(String str) {
                    this.f10841e = true;
                    this.f10842f = str;
                    return this;
                }

                public YellowTipsInfo setBackColorId(int i) {
                    this.f10847k = true;
                    this.f10848l = i;
                    return this;
                }

                public YellowTipsInfo setIconId(int i) {
                    this.f10845i = true;
                    this.f10846j = i;
                    return this;
                }

                public YellowTipsInfo setSubTitle(String str) {
                    this.f10839c = true;
                    this.f10840d = str;
                    return this;
                }

                public YellowTipsInfo setTipId(int i) {
                    this.f10843g = true;
                    this.f10844h = i;
                    return this;
                }

                public YellowTipsInfo setTitle(String str) {
                    this.f10837a = true;
                    this.f10838b = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasTitle()) {
                        codedOutputStreamMicro.writeString(1, getTitle());
                    }
                    if (hasSubTitle()) {
                        codedOutputStreamMicro.writeString(2, getSubTitle());
                    }
                    if (hasAssistInfo()) {
                        codedOutputStreamMicro.writeString(3, getAssistInfo());
                    }
                    if (hasTipId()) {
                        codedOutputStreamMicro.writeInt32(4, getTipId());
                    }
                    if (hasIconId()) {
                        codedOutputStreamMicro.writeInt32(5, getIconId());
                    }
                    if (hasBackColorId()) {
                        codedOutputStreamMicro.writeInt32(6, getBackColorId());
                    }
                }
            }

            public static YellowTipsList parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new YellowTipsList().mergeFrom(codedInputStreamMicro);
            }

            public static YellowTipsList parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (YellowTipsList) new YellowTipsList().mergeFrom(bArr);
            }

            public YellowTipsList addYellowTipsInfo(YellowTipsInfo yellowTipsInfo) {
                if (yellowTipsInfo != null) {
                    if (this.f10850a.isEmpty()) {
                        this.f10850a = new ArrayList();
                    }
                    this.f10850a.add(yellowTipsInfo);
                }
                return this;
            }

            public final YellowTipsList clear() {
                clearYellowTipsInfo();
                clearMrsl();
                this.f10853d = -1;
                return this;
            }

            public YellowTipsList clearMrsl() {
                this.f10851b = false;
                this.f10852c = "";
                return this;
            }

            public YellowTipsList clearYellowTipsInfo() {
                this.f10850a = Collections.emptyList();
                return this;
            }

            public int getCachedSize() {
                if (this.f10853d < 0) {
                    getSerializedSize();
                }
                return this.f10853d;
            }

            public String getMrsl() {
                return this.f10852c;
            }

            public int getSerializedSize() {
                int i = 0;
                for (YellowTipsInfo computeMessageSize : getYellowTipsInfoList()) {
                    i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
                }
                if (hasMrsl()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getMrsl());
                }
                this.f10853d = i;
                return i;
            }

            public YellowTipsInfo getYellowTipsInfo(int i) {
                return (YellowTipsInfo) this.f10850a.get(i);
            }

            public int getYellowTipsInfoCount() {
                return this.f10850a.size();
            }

            public List<YellowTipsInfo> getYellowTipsInfoList() {
                return this.f10850a;
            }

            public boolean hasMrsl() {
                return this.f10851b;
            }

            public final boolean isInitialized() {
                for (YellowTipsInfo isInitialized : getYellowTipsInfoList()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public YellowTipsList mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            MessageMicro yellowTipsInfo = new YellowTipsInfo();
                            codedInputStreamMicro.readMessage(yellowTipsInfo);
                            addYellowTipsInfo(yellowTipsInfo);
                            continue;
                        case 18:
                            setMrsl(codedInputStreamMicro.readString());
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

            public YellowTipsList setMrsl(String str) {
                this.f10851b = true;
                this.f10852c = str;
                return this;
            }

            public YellowTipsList setYellowTipsInfo(int i, YellowTipsInfo yellowTipsInfo) {
                if (yellowTipsInfo != null) {
                    this.f10850a.set(i, yellowTipsInfo);
                }
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                for (YellowTipsInfo writeMessage : getYellowTipsInfoList()) {
                    codedOutputStreamMicro.writeMessage(1, writeMessage);
                }
                if (hasMrsl()) {
                    codedOutputStreamMicro.writeString(2, getMrsl());
                }
            }
        }

        public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Content().mergeFrom(codedInputStreamMicro);
        }

        public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Content) new Content().mergeFrom(bArr);
        }

        public Content addAcciInfos(AcciInfos acciInfos) {
            if (acciInfos != null) {
                if (this.f10859f.isEmpty()) {
                    this.f10859f = new ArrayList();
                }
                this.f10859f.add(acciInfos);
            }
            return this;
        }

        public Content addLongDistanceInfo(LongDistanceInfo longDistanceInfo) {
            if (longDistanceInfo != null) {
                if (this.f10868o.isEmpty()) {
                    this.f10868o = new ArrayList();
                }
                this.f10868o.add(longDistanceInfo);
            }
            return this;
        }

        public Content addRoutes(Routes routes) {
            if (routes != null) {
                if (this.f10854a.isEmpty()) {
                    this.f10854a = new ArrayList();
                }
                this.f10854a.add(routes);
            }
            return this;
        }

        public Content addSteps(Steps steps) {
            if (steps != null) {
                if (this.f10855b.isEmpty()) {
                    this.f10855b = new ArrayList();
                }
                this.f10855b.add(steps);
            }
            return this;
        }

        public Content addStepts(Stepts stepts) {
            if (stepts != null) {
                if (this.f10856c.isEmpty()) {
                    this.f10856c = new ArrayList();
                }
                this.f10856c.add(stepts);
            }
            return this;
        }

        public Content addTaxis(Taxis taxis) {
            if (taxis != null) {
                if (this.f10857d.isEmpty()) {
                    this.f10857d = new ArrayList();
                }
                this.f10857d.add(taxis);
            }
            return this;
        }

        public Content addTraffics(Traffics traffics) {
            if (traffics != null) {
                if (this.f10858e.isEmpty()) {
                    this.f10858e = new ArrayList();
                }
                this.f10858e.add(traffics);
            }
            return this;
        }

        public Content addYellowTipsList(YellowTipsList yellowTipsList) {
            if (yellowTipsList != null) {
                if (this.f10869p.isEmpty()) {
                    this.f10869p = new ArrayList();
                }
                this.f10869p.add(yellowTipsList);
            }
            return this;
        }

        public final Content clear() {
            clearRoutes();
            clearSteps();
            clearStepts();
            clearTaxis();
            clearTraffics();
            clearAcciInfos();
            clearRouteStatus();
            clearLocalInfoTips();
            clearSessionid();
            clearWalkinf();
            clearLongDistanceInfo();
            clearYellowTipsList();
            this.f10870q = -1;
            return this;
        }

        public Content clearAcciInfos() {
            this.f10859f = Collections.emptyList();
            return this;
        }

        public Content clearLocalInfoTips() {
            this.f10862i = false;
            this.f10863j = "";
            return this;
        }

        public Content clearLongDistanceInfo() {
            this.f10868o = Collections.emptyList();
            return this;
        }

        public Content clearRouteStatus() {
            this.f10860g = false;
            this.f10861h = 1;
            return this;
        }

        public Content clearRoutes() {
            this.f10854a = Collections.emptyList();
            return this;
        }

        public Content clearSessionid() {
            this.f10864k = false;
            this.f10865l = "";
            return this;
        }

        public Content clearSteps() {
            this.f10855b = Collections.emptyList();
            return this;
        }

        public Content clearStepts() {
            this.f10856c = Collections.emptyList();
            return this;
        }

        public Content clearTaxis() {
            this.f10857d = Collections.emptyList();
            return this;
        }

        public Content clearTraffics() {
            this.f10858e = Collections.emptyList();
            return this;
        }

        public Content clearWalkinf() {
            this.f10866m = false;
            this.f10867n = null;
            return this;
        }

        public Content clearYellowTipsList() {
            this.f10869p = Collections.emptyList();
            return this;
        }

        public AcciInfos getAcciInfos(int i) {
            return (AcciInfos) this.f10859f.get(i);
        }

        public int getAcciInfosCount() {
            return this.f10859f.size();
        }

        public List<AcciInfos> getAcciInfosList() {
            return this.f10859f;
        }

        public int getCachedSize() {
            if (this.f10870q < 0) {
                getSerializedSize();
            }
            return this.f10870q;
        }

        public String getLocalInfoTips() {
            return this.f10863j;
        }

        public LongDistanceInfo getLongDistanceInfo(int i) {
            return (LongDistanceInfo) this.f10868o.get(i);
        }

        public int getLongDistanceInfoCount() {
            return this.f10868o.size();
        }

        public List<LongDistanceInfo> getLongDistanceInfoList() {
            return this.f10868o;
        }

        public int getRouteStatus() {
            return this.f10861h;
        }

        public Routes getRoutes(int i) {
            return (Routes) this.f10854a.get(i);
        }

        public int getRoutesCount() {
            return this.f10854a.size();
        }

        public List<Routes> getRoutesList() {
            return this.f10854a;
        }

        public int getSerializedSize() {
            int i = 0;
            for (Routes computeMessageSize : getRoutesList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            for (Steps computeMessageSize2 : getStepsList()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize2);
            }
            for (Stepts computeMessageSize3 : getSteptsList()) {
                i += CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize3);
            }
            for (Taxis computeMessageSize4 : getTaxisList()) {
                i += CodedOutputStreamMicro.computeMessageSize(4, computeMessageSize4);
            }
            for (Traffics computeMessageSize5 : getTrafficsList()) {
                i += CodedOutputStreamMicro.computeMessageSize(5, computeMessageSize5);
            }
            for (AcciInfos computeMessageSize6 : getAcciInfosList()) {
                i += CodedOutputStreamMicro.computeMessageSize(6, computeMessageSize6);
            }
            if (hasRouteStatus()) {
                i += CodedOutputStreamMicro.computeInt32Size(7, getRouteStatus());
            }
            if (hasLocalInfoTips()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getLocalInfoTips());
            }
            if (hasSessionid()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getSessionid());
            }
            if (hasWalkinf()) {
                i += CodedOutputStreamMicro.computeMessageSize(10, getWalkinf());
            }
            for (LongDistanceInfo computeMessageSize7 : getLongDistanceInfoList()) {
                i += CodedOutputStreamMicro.computeMessageSize(11, computeMessageSize7);
            }
            for (YellowTipsList computeMessageSize8 : getYellowTipsListList()) {
                i += CodedOutputStreamMicro.computeMessageSize(12, computeMessageSize8);
            }
            this.f10870q = i;
            return i;
        }

        public String getSessionid() {
            return this.f10865l;
        }

        public Steps getSteps(int i) {
            return (Steps) this.f10855b.get(i);
        }

        public int getStepsCount() {
            return this.f10855b.size();
        }

        public List<Steps> getStepsList() {
            return this.f10855b;
        }

        public Stepts getStepts(int i) {
            return (Stepts) this.f10856c.get(i);
        }

        public int getSteptsCount() {
            return this.f10856c.size();
        }

        public List<Stepts> getSteptsList() {
            return this.f10856c;
        }

        public Taxis getTaxis(int i) {
            return (Taxis) this.f10857d.get(i);
        }

        public int getTaxisCount() {
            return this.f10857d.size();
        }

        public List<Taxis> getTaxisList() {
            return this.f10857d;
        }

        public Traffics getTraffics(int i) {
            return (Traffics) this.f10858e.get(i);
        }

        public int getTrafficsCount() {
            return this.f10858e.size();
        }

        public List<Traffics> getTrafficsList() {
            return this.f10858e;
        }

        public WalkInfoT getWalkinf() {
            return this.f10867n;
        }

        public YellowTipsList getYellowTipsList(int i) {
            return (YellowTipsList) this.f10869p.get(i);
        }

        public int getYellowTipsListCount() {
            return this.f10869p.size();
        }

        public List<YellowTipsList> getYellowTipsListList() {
            return this.f10869p;
        }

        public boolean hasLocalInfoTips() {
            return this.f10862i;
        }

        public boolean hasRouteStatus() {
            return this.f10860g;
        }

        public boolean hasSessionid() {
            return this.f10864k;
        }

        public boolean hasWalkinf() {
            return this.f10866m;
        }

        public final boolean isInitialized() {
            if (hasWalkinf() && !getWalkinf().isInitialized()) {
                return false;
            }
            for (LongDistanceInfo isInitialized : getLongDistanceInfoList()) {
                if (!isInitialized.isInitialized()) {
                    return false;
                }
            }
            for (YellowTipsList isInitialized2 : getYellowTipsListList()) {
                if (!isInitialized2.isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        public Content mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro routes;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        routes = new Routes();
                        codedInputStreamMicro.readMessage(routes);
                        addRoutes(routes);
                        continue;
                    case 18:
                        routes = new Steps();
                        codedInputStreamMicro.readMessage(routes);
                        addSteps(routes);
                        continue;
                    case 26:
                        routes = new Stepts();
                        codedInputStreamMicro.readMessage(routes);
                        addStepts(routes);
                        continue;
                    case 34:
                        routes = new Taxis();
                        codedInputStreamMicro.readMessage(routes);
                        addTaxis(routes);
                        continue;
                    case 42:
                        routes = new Traffics();
                        codedInputStreamMicro.readMessage(routes);
                        addTraffics(routes);
                        continue;
                    case 50:
                        routes = new AcciInfos();
                        codedInputStreamMicro.readMessage(routes);
                        addAcciInfos(routes);
                        continue;
                    case 56:
                        setRouteStatus(codedInputStreamMicro.readInt32());
                        continue;
                    case 66:
                        setLocalInfoTips(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setSessionid(codedInputStreamMicro.readString());
                        continue;
                    case 82:
                        routes = new WalkInfoT();
                        codedInputStreamMicro.readMessage(routes);
                        setWalkinf(routes);
                        continue;
                    case 90:
                        routes = new LongDistanceInfo();
                        codedInputStreamMicro.readMessage(routes);
                        addLongDistanceInfo(routes);
                        continue;
                    case 98:
                        routes = new YellowTipsList();
                        codedInputStreamMicro.readMessage(routes);
                        addYellowTipsList(routes);
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

        public Content setAcciInfos(int i, AcciInfos acciInfos) {
            if (acciInfos != null) {
                this.f10859f.set(i, acciInfos);
            }
            return this;
        }

        public Content setLocalInfoTips(String str) {
            this.f10862i = true;
            this.f10863j = str;
            return this;
        }

        public Content setLongDistanceInfo(int i, LongDistanceInfo longDistanceInfo) {
            if (longDistanceInfo != null) {
                this.f10868o.set(i, longDistanceInfo);
            }
            return this;
        }

        public Content setRouteStatus(int i) {
            this.f10860g = true;
            this.f10861h = i;
            return this;
        }

        public Content setRoutes(int i, Routes routes) {
            if (routes != null) {
                this.f10854a.set(i, routes);
            }
            return this;
        }

        public Content setSessionid(String str) {
            this.f10864k = true;
            this.f10865l = str;
            return this;
        }

        public Content setSteps(int i, Steps steps) {
            if (steps != null) {
                this.f10855b.set(i, steps);
            }
            return this;
        }

        public Content setStepts(int i, Stepts stepts) {
            if (stepts != null) {
                this.f10856c.set(i, stepts);
            }
            return this;
        }

        public Content setTaxis(int i, Taxis taxis) {
            if (taxis != null) {
                this.f10857d.set(i, taxis);
            }
            return this;
        }

        public Content setTraffics(int i, Traffics traffics) {
            if (traffics != null) {
                this.f10858e.set(i, traffics);
            }
            return this;
        }

        public Content setWalkinf(WalkInfoT walkInfoT) {
            if (walkInfoT == null) {
                return clearWalkinf();
            }
            this.f10866m = true;
            this.f10867n = walkInfoT;
            return this;
        }

        public Content setYellowTipsList(int i, YellowTipsList yellowTipsList) {
            if (yellowTipsList != null) {
                this.f10869p.set(i, yellowTipsList);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (Routes writeMessage : getRoutesList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
            for (Steps writeMessage2 : getStepsList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage2);
            }
            for (Stepts writeMessage3 : getSteptsList()) {
                codedOutputStreamMicro.writeMessage(3, writeMessage3);
            }
            for (Taxis writeMessage4 : getTaxisList()) {
                codedOutputStreamMicro.writeMessage(4, writeMessage4);
            }
            for (Traffics writeMessage5 : getTrafficsList()) {
                codedOutputStreamMicro.writeMessage(5, writeMessage5);
            }
            for (AcciInfos writeMessage6 : getAcciInfosList()) {
                codedOutputStreamMicro.writeMessage(6, writeMessage6);
            }
            if (hasRouteStatus()) {
                codedOutputStreamMicro.writeInt32(7, getRouteStatus());
            }
            if (hasLocalInfoTips()) {
                codedOutputStreamMicro.writeString(8, getLocalInfoTips());
            }
            if (hasSessionid()) {
                codedOutputStreamMicro.writeString(9, getSessionid());
            }
            if (hasWalkinf()) {
                codedOutputStreamMicro.writeMessage(10, getWalkinf());
            }
            for (LongDistanceInfo writeMessage7 : getLongDistanceInfoList()) {
                codedOutputStreamMicro.writeMessage(11, writeMessage7);
            }
            for (YellowTipsList writeMessage8 : getYellowTipsListList()) {
                codedOutputStreamMicro.writeMessage(12, writeMessage8);
            }
        }
    }

    public static final class Option extends MessageMicro {
        public static final int AVOID_JAM_FIELD_NUMBER = 1;
        public static final int END_BID_FIELD_NUMBER = 15;
        public static final int END_FIELD_NUMBER = 6;
        public static final int END_NAME_FIELD_NUMBER = 4;
        public static final int IS_LONG_DISTANCE_FIELD_NUMBER = 12;
        public static final int LOCAL_INFO_URL_FIELD_NUMBER = 11;
        public static final int NAVI_TYPE_FIELD_NUMBER = 13;
        public static final int PREFER_FIELD_NUMBER = 8;
        public static final int ROUTE_PLAN_NET_MODE_FIELD_NUMBER = 10;
        public static final int Route_Plan_Net_Mode_Offline = 1;
        public static final int Route_Plan_Net_Mode_Offline2Online = 3;
        public static final int Route_Plan_Net_Mode_Online = 0;
        public static final int Route_Plan_Net_Mode_Online2Offline = 2;
        public static final int START_BID_FIELD_NUMBER = 14;
        public static final int START_FIELD_NUMBER = 5;
        public static final int START_NAME_FIELD_NUMBER = 3;
        public static final int SY_FIELD_NUMBER = 7;
        public static final int TOTAL_FIELD_NUMBER = 2;
        public static final int VIA_NAME_FIELD_NUMBER = 9;
        /* renamed from: A */
        private List<String> f10904A = Collections.emptyList();
        /* renamed from: B */
        private int f10905B = -1;
        /* renamed from: a */
        private boolean f10906a;
        /* renamed from: b */
        private int f10907b = 0;
        /* renamed from: c */
        private boolean f10908c;
        /* renamed from: d */
        private int f10909d = 0;
        /* renamed from: e */
        private boolean f10910e;
        /* renamed from: f */
        private String f10911f = "";
        /* renamed from: g */
        private boolean f10912g;
        /* renamed from: h */
        private String f10913h = "";
        /* renamed from: i */
        private boolean f10914i;
        /* renamed from: j */
        private Start f10915j = null;
        /* renamed from: k */
        private List<End> f10916k = Collections.emptyList();
        /* renamed from: l */
        private boolean f10917l;
        /* renamed from: m */
        private int f10918m = 0;
        /* renamed from: n */
        private boolean f10919n;
        /* renamed from: o */
        private int f10920o = 0;
        /* renamed from: p */
        private List<String> f10921p = Collections.emptyList();
        /* renamed from: q */
        private boolean f10922q;
        /* renamed from: r */
        private int f10923r = 0;
        /* renamed from: s */
        private boolean f10924s;
        /* renamed from: t */
        private LocalInfoUrl f10925t = null;
        /* renamed from: u */
        private boolean f10926u;
        /* renamed from: v */
        private int f10927v = 0;
        /* renamed from: w */
        private boolean f10928w;
        /* renamed from: x */
        private int f10929x = 0;
        /* renamed from: y */
        private boolean f10930y;
        /* renamed from: z */
        private String f10931z = "";

        public static final class End extends MessageMicro {
            public static final int BUS_STOP_FIELD_NUMBER = 4;
            public static final int BWANDA_FIELD_NUMBER = 6;
            public static final int CITYID_FIELD_NUMBER = 7;
            public static final int CITYNAME_FIELD_NUMBER = 8;
            public static final int PT_FIELD_NUMBER = 1;
            public static final int SPT_FIELD_NUMBER = 5;
            public static final int UID_FIELD_NUMBER = 2;
            public static final int WD_FIELD_NUMBER = 3;
            /* renamed from: a */
            private boolean f10871a;
            /* renamed from: b */
            private String f10872b = "";
            /* renamed from: c */
            private boolean f10873c;
            /* renamed from: d */
            private String f10874d = "";
            /* renamed from: e */
            private boolean f10875e;
            /* renamed from: f */
            private String f10876f = "";
            /* renamed from: g */
            private boolean f10877g;
            /* renamed from: h */
            private int f10878h = 0;
            /* renamed from: i */
            private List<Integer> f10879i = Collections.emptyList();
            /* renamed from: j */
            private boolean f10880j;
            /* renamed from: k */
            private int f10881k = 0;
            /* renamed from: l */
            private boolean f10882l;
            /* renamed from: m */
            private int f10883m = 0;
            /* renamed from: n */
            private boolean f10884n;
            /* renamed from: o */
            private String f10885o = "";
            /* renamed from: p */
            private int f10886p = -1;

            public static End parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new End().mergeFrom(codedInputStreamMicro);
            }

            public static End parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (End) new End().mergeFrom(bArr);
            }

            public End addSpt(int i) {
                if (this.f10879i.isEmpty()) {
                    this.f10879i = new ArrayList();
                }
                this.f10879i.add(Integer.valueOf(i));
                return this;
            }

            public final End clear() {
                clearPt();
                clearUid();
                clearWd();
                clearBusStop();
                clearSpt();
                clearBwanda();
                clearCityid();
                clearCityname();
                this.f10886p = -1;
                return this;
            }

            public End clearBusStop() {
                this.f10877g = false;
                this.f10878h = 0;
                return this;
            }

            public End clearBwanda() {
                this.f10880j = false;
                this.f10881k = 0;
                return this;
            }

            public End clearCityid() {
                this.f10882l = false;
                this.f10883m = 0;
                return this;
            }

            public End clearCityname() {
                this.f10884n = false;
                this.f10885o = "";
                return this;
            }

            public End clearPt() {
                this.f10871a = false;
                this.f10872b = "";
                return this;
            }

            public End clearSpt() {
                this.f10879i = Collections.emptyList();
                return this;
            }

            public End clearUid() {
                this.f10873c = false;
                this.f10874d = "";
                return this;
            }

            public End clearWd() {
                this.f10875e = false;
                this.f10876f = "";
                return this;
            }

            public int getBusStop() {
                return this.f10878h;
            }

            public int getBwanda() {
                return this.f10881k;
            }

            public int getCachedSize() {
                if (this.f10886p < 0) {
                    getSerializedSize();
                }
                return this.f10886p;
            }

            public int getCityid() {
                return this.f10883m;
            }

            public String getCityname() {
                return this.f10885o;
            }

            public String getPt() {
                return this.f10872b;
            }

            public int getSerializedSize() {
                int i = 0;
                int computeStringSize = hasPt() ? CodedOutputStreamMicro.computeStringSize(1, getPt()) + 0 : 0;
                if (hasUid()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getUid());
                }
                if (hasWd()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getWd());
                }
                int computeInt32Size = hasBusStop() ? computeStringSize + CodedOutputStreamMicro.computeInt32Size(4, getBusStop()) : computeStringSize;
                for (Integer intValue : getSptList()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue());
                }
                computeStringSize = (computeInt32Size + i) + (getSptList().size() * 1);
                if (hasBwanda()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(6, getBwanda());
                }
                if (hasCityid()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(7, getCityid());
                }
                if (hasCityname()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(8, getCityname());
                }
                this.f10886p = computeStringSize;
                return computeStringSize;
            }

            public int getSpt(int i) {
                return ((Integer) this.f10879i.get(i)).intValue();
            }

            public int getSptCount() {
                return this.f10879i.size();
            }

            public List<Integer> getSptList() {
                return this.f10879i;
            }

            public String getUid() {
                return this.f10874d;
            }

            public String getWd() {
                return this.f10876f;
            }

            public boolean hasBusStop() {
                return this.f10877g;
            }

            public boolean hasBwanda() {
                return this.f10880j;
            }

            public boolean hasCityid() {
                return this.f10882l;
            }

            public boolean hasCityname() {
                return this.f10884n;
            }

            public boolean hasPt() {
                return this.f10871a;
            }

            public boolean hasUid() {
                return this.f10873c;
            }

            public boolean hasWd() {
                return this.f10875e;
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
                            setUid(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setWd(codedInputStreamMicro.readString());
                            continue;
                        case 32:
                            setBusStop(codedInputStreamMicro.readInt32());
                            continue;
                        case 40:
                            addSpt(codedInputStreamMicro.readSInt32());
                            continue;
                        case 48:
                            setBwanda(codedInputStreamMicro.readInt32());
                            continue;
                        case 56:
                            setCityid(codedInputStreamMicro.readInt32());
                            continue;
                        case 66:
                            setCityname(codedInputStreamMicro.readString());
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

            public End setBusStop(int i) {
                this.f10877g = true;
                this.f10878h = i;
                return this;
            }

            public End setBwanda(int i) {
                this.f10880j = true;
                this.f10881k = i;
                return this;
            }

            public End setCityid(int i) {
                this.f10882l = true;
                this.f10883m = i;
                return this;
            }

            public End setCityname(String str) {
                this.f10884n = true;
                this.f10885o = str;
                return this;
            }

            public End setPt(String str) {
                this.f10871a = true;
                this.f10872b = str;
                return this;
            }

            public End setSpt(int i, int i2) {
                this.f10879i.set(i, Integer.valueOf(i2));
                return this;
            }

            public End setUid(String str) {
                this.f10873c = true;
                this.f10874d = str;
                return this;
            }

            public End setWd(String str) {
                this.f10875e = true;
                this.f10876f = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasPt()) {
                    codedOutputStreamMicro.writeString(1, getPt());
                }
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(2, getUid());
                }
                if (hasWd()) {
                    codedOutputStreamMicro.writeString(3, getWd());
                }
                if (hasBusStop()) {
                    codedOutputStreamMicro.writeInt32(4, getBusStop());
                }
                for (Integer intValue : getSptList()) {
                    codedOutputStreamMicro.writeSInt32(5, intValue.intValue());
                }
                if (hasBwanda()) {
                    codedOutputStreamMicro.writeInt32(6, getBwanda());
                }
                if (hasCityid()) {
                    codedOutputStreamMicro.writeInt32(7, getCityid());
                }
                if (hasCityname()) {
                    codedOutputStreamMicro.writeString(8, getCityname());
                }
            }
        }

        public static final class LocalInfoUrl extends MessageMicro {
            public static final int URL_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f10887a;
            /* renamed from: b */
            private String f10888b = "";
            /* renamed from: c */
            private int f10889c = -1;

            public static LocalInfoUrl parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new LocalInfoUrl().mergeFrom(codedInputStreamMicro);
            }

            public static LocalInfoUrl parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (LocalInfoUrl) new LocalInfoUrl().mergeFrom(bArr);
            }

            public final LocalInfoUrl clear() {
                clearUrl();
                this.f10889c = -1;
                return this;
            }

            public LocalInfoUrl clearUrl() {
                this.f10887a = false;
                this.f10888b = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f10889c < 0) {
                    getSerializedSize();
                }
                return this.f10889c;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasUrl()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUrl());
                }
                this.f10889c = i;
                return i;
            }

            public String getUrl() {
                return this.f10888b;
            }

            public boolean hasUrl() {
                return this.f10887a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public LocalInfoUrl mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
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

            public LocalInfoUrl setUrl(String str) {
                this.f10887a = true;
                this.f10888b = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasUrl()) {
                    codedOutputStreamMicro.writeString(1, getUrl());
                }
            }
        }

        public static final class Start extends MessageMicro {
            public static final int BUS_STOP_FIELD_NUMBER = 4;
            public static final int CITYID_FIELD_NUMBER = 6;
            public static final int CITYNAME_FIELD_NUMBER = 7;
            public static final int PT_FIELD_NUMBER = 1;
            public static final int SPT_FIELD_NUMBER = 5;
            public static final int UID_FIELD_NUMBER = 2;
            public static final int WD_FIELD_NUMBER = 3;
            /* renamed from: a */
            private boolean f10890a;
            /* renamed from: b */
            private String f10891b = "";
            /* renamed from: c */
            private boolean f10892c;
            /* renamed from: d */
            private String f10893d = "";
            /* renamed from: e */
            private boolean f10894e;
            /* renamed from: f */
            private String f10895f = "";
            /* renamed from: g */
            private boolean f10896g;
            /* renamed from: h */
            private int f10897h = 0;
            /* renamed from: i */
            private List<Integer> f10898i = Collections.emptyList();
            /* renamed from: j */
            private boolean f10899j;
            /* renamed from: k */
            private int f10900k = 0;
            /* renamed from: l */
            private boolean f10901l;
            /* renamed from: m */
            private String f10902m = "";
            /* renamed from: n */
            private int f10903n = -1;

            public static Start parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Start().mergeFrom(codedInputStreamMicro);
            }

            public static Start parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Start) new Start().mergeFrom(bArr);
            }

            public Start addSpt(int i) {
                if (this.f10898i.isEmpty()) {
                    this.f10898i = new ArrayList();
                }
                this.f10898i.add(Integer.valueOf(i));
                return this;
            }

            public final Start clear() {
                clearPt();
                clearUid();
                clearWd();
                clearBusStop();
                clearSpt();
                clearCityid();
                clearCityname();
                this.f10903n = -1;
                return this;
            }

            public Start clearBusStop() {
                this.f10896g = false;
                this.f10897h = 0;
                return this;
            }

            public Start clearCityid() {
                this.f10899j = false;
                this.f10900k = 0;
                return this;
            }

            public Start clearCityname() {
                this.f10901l = false;
                this.f10902m = "";
                return this;
            }

            public Start clearPt() {
                this.f10890a = false;
                this.f10891b = "";
                return this;
            }

            public Start clearSpt() {
                this.f10898i = Collections.emptyList();
                return this;
            }

            public Start clearUid() {
                this.f10892c = false;
                this.f10893d = "";
                return this;
            }

            public Start clearWd() {
                this.f10894e = false;
                this.f10895f = "";
                return this;
            }

            public int getBusStop() {
                return this.f10897h;
            }

            public int getCachedSize() {
                if (this.f10903n < 0) {
                    getSerializedSize();
                }
                return this.f10903n;
            }

            public int getCityid() {
                return this.f10900k;
            }

            public String getCityname() {
                return this.f10902m;
            }

            public String getPt() {
                return this.f10891b;
            }

            public int getSerializedSize() {
                int i = 0;
                int computeStringSize = hasPt() ? CodedOutputStreamMicro.computeStringSize(1, getPt()) + 0 : 0;
                if (hasUid()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getUid());
                }
                if (hasWd()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getWd());
                }
                int computeInt32Size = hasBusStop() ? computeStringSize + CodedOutputStreamMicro.computeInt32Size(4, getBusStop()) : computeStringSize;
                for (Integer intValue : getSptList()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue());
                }
                computeStringSize = (computeInt32Size + i) + (getSptList().size() * 1);
                if (hasCityid()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(6, getCityid());
                }
                if (hasCityname()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(7, getCityname());
                }
                this.f10903n = computeStringSize;
                return computeStringSize;
            }

            public int getSpt(int i) {
                return ((Integer) this.f10898i.get(i)).intValue();
            }

            public int getSptCount() {
                return this.f10898i.size();
            }

            public List<Integer> getSptList() {
                return this.f10898i;
            }

            public String getUid() {
                return this.f10893d;
            }

            public String getWd() {
                return this.f10895f;
            }

            public boolean hasBusStop() {
                return this.f10896g;
            }

            public boolean hasCityid() {
                return this.f10899j;
            }

            public boolean hasCityname() {
                return this.f10901l;
            }

            public boolean hasPt() {
                return this.f10890a;
            }

            public boolean hasUid() {
                return this.f10892c;
            }

            public boolean hasWd() {
                return this.f10894e;
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
                            setUid(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setWd(codedInputStreamMicro.readString());
                            continue;
                        case 32:
                            setBusStop(codedInputStreamMicro.readInt32());
                            continue;
                        case 40:
                            addSpt(codedInputStreamMicro.readSInt32());
                            continue;
                        case 48:
                            setCityid(codedInputStreamMicro.readInt32());
                            continue;
                        case 58:
                            setCityname(codedInputStreamMicro.readString());
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

            public Start setBusStop(int i) {
                this.f10896g = true;
                this.f10897h = i;
                return this;
            }

            public Start setCityid(int i) {
                this.f10899j = true;
                this.f10900k = i;
                return this;
            }

            public Start setCityname(String str) {
                this.f10901l = true;
                this.f10902m = str;
                return this;
            }

            public Start setPt(String str) {
                this.f10890a = true;
                this.f10891b = str;
                return this;
            }

            public Start setSpt(int i, int i2) {
                this.f10898i.set(i, Integer.valueOf(i2));
                return this;
            }

            public Start setUid(String str) {
                this.f10892c = true;
                this.f10893d = str;
                return this;
            }

            public Start setWd(String str) {
                this.f10894e = true;
                this.f10895f = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasPt()) {
                    codedOutputStreamMicro.writeString(1, getPt());
                }
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(2, getUid());
                }
                if (hasWd()) {
                    codedOutputStreamMicro.writeString(3, getWd());
                }
                if (hasBusStop()) {
                    codedOutputStreamMicro.writeInt32(4, getBusStop());
                }
                for (Integer intValue : getSptList()) {
                    codedOutputStreamMicro.writeSInt32(5, intValue.intValue());
                }
                if (hasCityid()) {
                    codedOutputStreamMicro.writeInt32(6, getCityid());
                }
                if (hasCityname()) {
                    codedOutputStreamMicro.writeString(7, getCityname());
                }
            }
        }

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }

        public Option addEnd(End end) {
            if (end != null) {
                if (this.f10916k.isEmpty()) {
                    this.f10916k = new ArrayList();
                }
                this.f10916k.add(end);
            }
            return this;
        }

        public Option addEndBid(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f10904A.isEmpty()) {
                this.f10904A = new ArrayList();
            }
            this.f10904A.add(str);
            return this;
        }

        public Option addViaName(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f10921p.isEmpty()) {
                this.f10921p = new ArrayList();
            }
            this.f10921p.add(str);
            return this;
        }

        public final Option clear() {
            clearAvoidJam();
            clearTotal();
            clearStartName();
            clearEndName();
            clearStart();
            clearEnd();
            clearSy();
            clearPrefer();
            clearViaName();
            clearRoutePlanNetMode();
            clearLocalInfoUrl();
            clearIsLongDistance();
            clearNaviType();
            clearStartBid();
            clearEndBid();
            this.f10905B = -1;
            return this;
        }

        public Option clearAvoidJam() {
            this.f10906a = false;
            this.f10907b = 0;
            return this;
        }

        public Option clearEnd() {
            this.f10916k = Collections.emptyList();
            return this;
        }

        public Option clearEndBid() {
            this.f10904A = Collections.emptyList();
            return this;
        }

        public Option clearEndName() {
            this.f10912g = false;
            this.f10913h = "";
            return this;
        }

        public Option clearIsLongDistance() {
            this.f10926u = false;
            this.f10927v = 0;
            return this;
        }

        public Option clearLocalInfoUrl() {
            this.f10924s = false;
            this.f10925t = null;
            return this;
        }

        public Option clearNaviType() {
            this.f10928w = false;
            this.f10929x = 0;
            return this;
        }

        public Option clearPrefer() {
            this.f10919n = false;
            this.f10920o = 0;
            return this;
        }

        public Option clearRoutePlanNetMode() {
            this.f10922q = false;
            this.f10923r = 0;
            return this;
        }

        public Option clearStart() {
            this.f10914i = false;
            this.f10915j = null;
            return this;
        }

        public Option clearStartBid() {
            this.f10930y = false;
            this.f10931z = "";
            return this;
        }

        public Option clearStartName() {
            this.f10910e = false;
            this.f10911f = "";
            return this;
        }

        public Option clearSy() {
            this.f10917l = false;
            this.f10918m = 0;
            return this;
        }

        public Option clearTotal() {
            this.f10908c = false;
            this.f10909d = 0;
            return this;
        }

        public Option clearViaName() {
            this.f10921p = Collections.emptyList();
            return this;
        }

        public int getAvoidJam() {
            return this.f10907b;
        }

        public int getCachedSize() {
            if (this.f10905B < 0) {
                getSerializedSize();
            }
            return this.f10905B;
        }

        public End getEnd(int i) {
            return (End) this.f10916k.get(i);
        }

        public String getEndBid(int i) {
            return (String) this.f10904A.get(i);
        }

        public int getEndBidCount() {
            return this.f10904A.size();
        }

        public List<String> getEndBidList() {
            return this.f10904A;
        }

        public int getEndCount() {
            return this.f10916k.size();
        }

        public List<End> getEndList() {
            return this.f10916k;
        }

        public String getEndName() {
            return this.f10913h;
        }

        public int getIsLongDistance() {
            return this.f10927v;
        }

        public LocalInfoUrl getLocalInfoUrl() {
            return this.f10925t;
        }

        public int getNaviType() {
            return this.f10929x;
        }

        public int getPrefer() {
            return this.f10920o;
        }

        public int getRoutePlanNetMode() {
            return this.f10923r;
        }

        public int getSerializedSize() {
            int i = 0;
            int computeInt32Size = hasAvoidJam() ? CodedOutputStreamMicro.computeInt32Size(1, getAvoidJam()) + 0 : 0;
            if (hasTotal()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getTotal());
            }
            if (hasStartName()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getStartName());
            }
            if (hasEndName()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getEndName());
            }
            if (hasStart()) {
                computeInt32Size += CodedOutputStreamMicro.computeMessageSize(5, getStart());
            }
            int i2 = computeInt32Size;
            for (End computeMessageSize : getEndList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(6, computeMessageSize) + i2;
            }
            if (hasSy()) {
                i2 += CodedOutputStreamMicro.computeInt32Size(7, getSy());
            }
            if (hasPrefer()) {
                i2 += CodedOutputStreamMicro.computeInt32Size(8, getPrefer());
            }
            int i3 = 0;
            for (String computeStringSizeNoTag : getViaNameList()) {
                i3 = CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag) + i3;
            }
            computeInt32Size = (i2 + i3) + (getViaNameList().size() * 1);
            if (hasRoutePlanNetMode()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(10, getRoutePlanNetMode());
            }
            if (hasLocalInfoUrl()) {
                computeInt32Size += CodedOutputStreamMicro.computeMessageSize(11, getLocalInfoUrl());
            }
            if (hasIsLongDistance()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(12, getIsLongDistance());
            }
            if (hasNaviType()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(13, getNaviType());
            }
            i2 = hasStartBid() ? computeInt32Size + CodedOutputStreamMicro.computeStringSize(14, getStartBid()) : computeInt32Size;
            for (String computeStringSizeNoTag2 : getEndBidList()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag2);
            }
            computeInt32Size = (i2 + i) + (getEndBidList().size() * 1);
            this.f10905B = computeInt32Size;
            return computeInt32Size;
        }

        public Start getStart() {
            return this.f10915j;
        }

        public String getStartBid() {
            return this.f10931z;
        }

        public String getStartName() {
            return this.f10911f;
        }

        public int getSy() {
            return this.f10918m;
        }

        public int getTotal() {
            return this.f10909d;
        }

        public String getViaName(int i) {
            return (String) this.f10921p.get(i);
        }

        public int getViaNameCount() {
            return this.f10921p.size();
        }

        public List<String> getViaNameList() {
            return this.f10921p;
        }

        public boolean hasAvoidJam() {
            return this.f10906a;
        }

        public boolean hasEndName() {
            return this.f10912g;
        }

        public boolean hasIsLongDistance() {
            return this.f10926u;
        }

        public boolean hasLocalInfoUrl() {
            return this.f10924s;
        }

        public boolean hasNaviType() {
            return this.f10928w;
        }

        public boolean hasPrefer() {
            return this.f10919n;
        }

        public boolean hasRoutePlanNetMode() {
            return this.f10922q;
        }

        public boolean hasStart() {
            return this.f10914i;
        }

        public boolean hasStartBid() {
            return this.f10930y;
        }

        public boolean hasStartName() {
            return this.f10910e;
        }

        public boolean hasSy() {
            return this.f10917l;
        }

        public boolean hasTotal() {
            return this.f10908c;
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
                        setAvoidJam(codedInputStreamMicro.readInt32());
                        continue;
                    case 16:
                        setTotal(codedInputStreamMicro.readInt32());
                        continue;
                    case 26:
                        setStartName(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setEndName(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        start = new Start();
                        codedInputStreamMicro.readMessage(start);
                        setStart(start);
                        continue;
                    case 50:
                        start = new End();
                        codedInputStreamMicro.readMessage(start);
                        addEnd(start);
                        continue;
                    case 56:
                        setSy(codedInputStreamMicro.readInt32());
                        continue;
                    case 64:
                        setPrefer(codedInputStreamMicro.readInt32());
                        continue;
                    case 74:
                        addViaName(codedInputStreamMicro.readString());
                        continue;
                    case 80:
                        setRoutePlanNetMode(codedInputStreamMicro.readInt32());
                        continue;
                    case 90:
                        start = new LocalInfoUrl();
                        codedInputStreamMicro.readMessage(start);
                        setLocalInfoUrl(start);
                        continue;
                    case 96:
                        setIsLongDistance(codedInputStreamMicro.readInt32());
                        continue;
                    case 104:
                        setNaviType(codedInputStreamMicro.readInt32());
                        continue;
                    case 114:
                        setStartBid(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.df /*122*/:
                        addEndBid(codedInputStreamMicro.readString());
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

        public Option setAvoidJam(int i) {
            this.f10906a = true;
            this.f10907b = i;
            return this;
        }

        public Option setEnd(int i, End end) {
            if (end != null) {
                this.f10916k.set(i, end);
            }
            return this;
        }

        public Option setEndBid(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f10904A.set(i, str);
            return this;
        }

        public Option setEndName(String str) {
            this.f10912g = true;
            this.f10913h = str;
            return this;
        }

        public Option setIsLongDistance(int i) {
            this.f10926u = true;
            this.f10927v = i;
            return this;
        }

        public Option setLocalInfoUrl(LocalInfoUrl localInfoUrl) {
            if (localInfoUrl == null) {
                return clearLocalInfoUrl();
            }
            this.f10924s = true;
            this.f10925t = localInfoUrl;
            return this;
        }

        public Option setNaviType(int i) {
            this.f10928w = true;
            this.f10929x = i;
            return this;
        }

        public Option setPrefer(int i) {
            this.f10919n = true;
            this.f10920o = i;
            return this;
        }

        public Option setRoutePlanNetMode(int i) {
            this.f10922q = true;
            this.f10923r = i;
            return this;
        }

        public Option setStart(Start start) {
            if (start == null) {
                return clearStart();
            }
            this.f10914i = true;
            this.f10915j = start;
            return this;
        }

        public Option setStartBid(String str) {
            this.f10930y = true;
            this.f10931z = str;
            return this;
        }

        public Option setStartName(String str) {
            this.f10910e = true;
            this.f10911f = str;
            return this;
        }

        public Option setSy(int i) {
            this.f10917l = true;
            this.f10918m = i;
            return this;
        }

        public Option setTotal(int i) {
            this.f10908c = true;
            this.f10909d = i;
            return this;
        }

        public Option setViaName(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f10921p.set(i, str);
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasAvoidJam()) {
                codedOutputStreamMicro.writeInt32(1, getAvoidJam());
            }
            if (hasTotal()) {
                codedOutputStreamMicro.writeInt32(2, getTotal());
            }
            if (hasStartName()) {
                codedOutputStreamMicro.writeString(3, getStartName());
            }
            if (hasEndName()) {
                codedOutputStreamMicro.writeString(4, getEndName());
            }
            if (hasStart()) {
                codedOutputStreamMicro.writeMessage(5, getStart());
            }
            for (End writeMessage : getEndList()) {
                codedOutputStreamMicro.writeMessage(6, writeMessage);
            }
            if (hasSy()) {
                codedOutputStreamMicro.writeInt32(7, getSy());
            }
            if (hasPrefer()) {
                codedOutputStreamMicro.writeInt32(8, getPrefer());
            }
            for (String writeString : getViaNameList()) {
                codedOutputStreamMicro.writeString(9, writeString);
            }
            if (hasRoutePlanNetMode()) {
                codedOutputStreamMicro.writeInt32(10, getRoutePlanNetMode());
            }
            if (hasLocalInfoUrl()) {
                codedOutputStreamMicro.writeMessage(11, getLocalInfoUrl());
            }
            if (hasIsLongDistance()) {
                codedOutputStreamMicro.writeInt32(12, getIsLongDistance());
            }
            if (hasNaviType()) {
                codedOutputStreamMicro.writeInt32(13, getNaviType());
            }
            if (hasStartBid()) {
                codedOutputStreamMicro.writeString(14, getStartBid());
            }
            for (String writeString2 : getEndBidList()) {
                codedOutputStreamMicro.writeString(15, writeString2);
            }
        }
    }

    public static Cars parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Cars().mergeFrom(codedInputStreamMicro);
    }

    public static Cars parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Cars) new Cars().mergeFrom(bArr);
    }

    public final Cars clear() {
        clearOption();
        clearContent();
        clearTest();
        this.f10938g = -1;
        return this;
    }

    public Cars clearContent() {
        this.f10934c = false;
        this.f10935d = null;
        return this;
    }

    public Cars clearOption() {
        this.f10932a = false;
        this.f10933b = null;
        return this;
    }

    public Cars clearTest() {
        this.f10936e = false;
        this.f10937f = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f10938g < 0) {
            getSerializedSize();
        }
        return this.f10938g;
    }

    public Content getContent() {
        return this.f10935d;
    }

    public Option getOption() {
        return this.f10933b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasOption()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
        }
        if (hasContent()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getContent());
        }
        if (hasTest()) {
            i += CodedOutputStreamMicro.computeStringSize(3, getTest());
        }
        this.f10938g = i;
        return i;
    }

    public String getTest() {
        return this.f10937f;
    }

    public boolean hasContent() {
        return this.f10934c;
    }

    public boolean hasOption() {
        return this.f10932a;
    }

    public boolean hasTest() {
        return this.f10936e;
    }

    public final boolean isInitialized() {
        return !hasContent() || getContent().isInitialized();
    }

    public Cars mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                    setTest(codedInputStreamMicro.readString());
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

    public Cars setContent(Content content) {
        if (content == null) {
            return clearContent();
        }
        this.f10934c = true;
        this.f10935d = content;
        return this;
    }

    public Cars setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f10932a = true;
        this.f10933b = option;
        return this;
    }

    public Cars setTest(String str) {
        this.f10936e = true;
        this.f10937f = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(1, getOption());
        }
        if (hasContent()) {
            codedOutputStreamMicro.writeMessage(2, getContent());
        }
        if (hasTest()) {
            codedOutputStreamMicro.writeString(3, getTest());
        }
    }
}
