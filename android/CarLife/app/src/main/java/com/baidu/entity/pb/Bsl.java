package com.baidu.entity.pb;

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

public final class Bsl extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 3;
    public static final int CURRENT_CITY_FIELD_NUMBER = 2;
    public static final int OPTION_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f9822a;
    /* renamed from: b */
    private Option f9823b = null;
    /* renamed from: c */
    private boolean f9824c;
    /* renamed from: d */
    private CurrentCity f9825d = null;
    /* renamed from: e */
    private List<Content> f9826e = Collections.emptyList();
    /* renamed from: f */
    private int f9827f = -1;

    public static final class Content extends MessageMicro {
        public static final int ENDTIME_FIELD_NUMBER = 9;
        public static final int GEO_FIELD_NUMBER = 2;
        public static final int HEADWAY_FIELD_NUMBER = 16;
        public static final int IMAGE_FIELD_NUMBER = 22;
        public static final int ISMONTICKET_FIELD_NUMBER = 3;
        public static final int IS_DISPLAY_FIELD_NUMBER = 4;
        public static final int KINDTYPE_FIELD_NUMBER = 6;
        public static final int LINE_DIRECTION_FIELD_NUMBER = 17;
        public static final int MAXPRICE_FIELD_NUMBER = 5;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NEAREST_STATION_IDX_FIELD_NUMBER = 13;
        public static final int PAIR_LINE_FIELD_NUMBER = 18;
        public static final int RTBUS_NU_FIELD_NUMBER = 14;
        public static final int RTBUS_UPDATE_INTERVAL_FIELD_NUMBER = 12;
        public static final int RTBUS_UPDATE_TIME_FIELD_NUMBER = 11;
        public static final int RUN_STATE_FIELD_NUMBER = 23;
        public static final int STARTTIME_FIELD_NUMBER = 8;
        public static final int STATIONS_FIELD_NUMBER = 19;
        public static final int TICKETPRICE_FIELD_NUMBER = 10;
        public static final int TRI_RTBUS_TIP_FIELD_NUMBER = 15;
        public static final int UGCINFO_FIELD_NUMBER = 21;
        public static final int UID_FIELD_NUMBER = 20;
        public static final int WORKINGTIMEDESC_FIELD_NUMBER = 7;
        /* renamed from: A */
        private int f9765A = 0;
        /* renamed from: B */
        private boolean f9766B;
        /* renamed from: C */
        private String f9767C = "";
        /* renamed from: D */
        private boolean f9768D;
        /* renamed from: E */
        private String f9769E = "";
        /* renamed from: F */
        private boolean f9770F;
        /* renamed from: G */
        private String f9771G = "";
        /* renamed from: H */
        private boolean f9772H;
        /* renamed from: I */
        private PairLine f9773I = null;
        /* renamed from: J */
        private List<Stations> f9774J = Collections.emptyList();
        /* renamed from: K */
        private boolean f9775K;
        /* renamed from: L */
        private String f9776L = "";
        /* renamed from: M */
        private List<UgcInfo> f9777M = Collections.emptyList();
        /* renamed from: N */
        private boolean f9778N;
        /* renamed from: O */
        private ByteStringMicro f9779O = ByteStringMicro.EMPTY;
        /* renamed from: P */
        private boolean f9780P;
        /* renamed from: Q */
        private int f9781Q = 0;
        /* renamed from: R */
        private int f9782R = -1;
        /* renamed from: a */
        private boolean f9783a;
        /* renamed from: b */
        private String f9784b = "";
        /* renamed from: c */
        private boolean f9785c;
        /* renamed from: d */
        private String f9786d = "";
        /* renamed from: e */
        private boolean f9787e;
        /* renamed from: f */
        private int f9788f = 0;
        /* renamed from: g */
        private boolean f9789g;
        /* renamed from: h */
        private int f9790h = 0;
        /* renamed from: i */
        private boolean f9791i;
        /* renamed from: j */
        private int f9792j = 0;
        /* renamed from: k */
        private boolean f9793k;
        /* renamed from: l */
        private int f9794l = 0;
        /* renamed from: m */
        private List<String> f9795m = Collections.emptyList();
        /* renamed from: n */
        private boolean f9796n;
        /* renamed from: o */
        private String f9797o = "";
        /* renamed from: p */
        private boolean f9798p;
        /* renamed from: q */
        private String f9799q = "";
        /* renamed from: r */
        private boolean f9800r;
        /* renamed from: s */
        private int f9801s = 0;
        /* renamed from: t */
        private boolean f9802t;
        /* renamed from: u */
        private int f9803u = 0;
        /* renamed from: v */
        private boolean f9804v;
        /* renamed from: w */
        private int f9805w = 0;
        /* renamed from: x */
        private boolean f9806x;
        /* renamed from: y */
        private int f9807y = 0;
        /* renamed from: z */
        private boolean f9808z;

        public static final class PairLine extends MessageMicro {
            public static final int DIRECTION_FIELD_NUMBER = 3;
            public static final int ENDTIME_FIELD_NUMBER = 5;
            public static final int KINDTYPE_FIELD_NUMBER = 6;
            public static final int NAME_FIELD_NUMBER = 1;
            public static final int STARTTIME_FIELD_NUMBER = 4;
            public static final int UID_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f9695a;
            /* renamed from: b */
            private String f9696b = "";
            /* renamed from: c */
            private boolean f9697c;
            /* renamed from: d */
            private String f9698d = "";
            /* renamed from: e */
            private boolean f9699e;
            /* renamed from: f */
            private String f9700f = "";
            /* renamed from: g */
            private boolean f9701g;
            /* renamed from: h */
            private String f9702h = "";
            /* renamed from: i */
            private boolean f9703i;
            /* renamed from: j */
            private String f9704j = "";
            /* renamed from: k */
            private boolean f9705k;
            /* renamed from: l */
            private int f9706l = 0;
            /* renamed from: m */
            private int f9707m = -1;

            public static PairLine parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new PairLine().mergeFrom(codedInputStreamMicro);
            }

            public static PairLine parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (PairLine) new PairLine().mergeFrom(bArr);
            }

            public final PairLine clear() {
                clearName();
                clearUid();
                clearDirection();
                clearStartTime();
                clearEndTime();
                clearKindtype();
                this.f9707m = -1;
                return this;
            }

            public PairLine clearDirection() {
                this.f9699e = false;
                this.f9700f = "";
                return this;
            }

            public PairLine clearEndTime() {
                this.f9703i = false;
                this.f9704j = "";
                return this;
            }

            public PairLine clearKindtype() {
                this.f9705k = false;
                this.f9706l = 0;
                return this;
            }

            public PairLine clearName() {
                this.f9695a = false;
                this.f9696b = "";
                return this;
            }

            public PairLine clearStartTime() {
                this.f9701g = false;
                this.f9702h = "";
                return this;
            }

            public PairLine clearUid() {
                this.f9697c = false;
                this.f9698d = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f9707m < 0) {
                    getSerializedSize();
                }
                return this.f9707m;
            }

            public String getDirection() {
                return this.f9700f;
            }

            public String getEndTime() {
                return this.f9704j;
            }

            public int getKindtype() {
                return this.f9706l;
            }

            public String getName() {
                return this.f9696b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasName()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
                }
                if (hasUid()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getUid());
                }
                if (hasDirection()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getDirection());
                }
                if (hasStartTime()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getStartTime());
                }
                if (hasEndTime()) {
                    i += CodedOutputStreamMicro.computeStringSize(5, getEndTime());
                }
                if (hasKindtype()) {
                    i += CodedOutputStreamMicro.computeInt32Size(6, getKindtype());
                }
                this.f9707m = i;
                return i;
            }

            public String getStartTime() {
                return this.f9702h;
            }

            public String getUid() {
                return this.f9698d;
            }

            public boolean hasDirection() {
                return this.f9699e;
            }

            public boolean hasEndTime() {
                return this.f9703i;
            }

            public boolean hasKindtype() {
                return this.f9705k;
            }

            public boolean hasName() {
                return this.f9695a;
            }

            public boolean hasStartTime() {
                return this.f9701g;
            }

            public boolean hasUid() {
                return this.f9697c;
            }

            public final boolean isInitialized() {
                return true;
            }

            public PairLine mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setName(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setUid(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setDirection(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setStartTime(codedInputStreamMicro.readString());
                            continue;
                        case 42:
                            setEndTime(codedInputStreamMicro.readString());
                            continue;
                        case 48:
                            setKindtype(codedInputStreamMicro.readInt32());
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

            public PairLine setDirection(String str) {
                this.f9699e = true;
                this.f9700f = str;
                return this;
            }

            public PairLine setEndTime(String str) {
                this.f9703i = true;
                this.f9704j = str;
                return this;
            }

            public PairLine setKindtype(int i) {
                this.f9705k = true;
                this.f9706l = i;
                return this;
            }

            public PairLine setName(String str) {
                this.f9695a = true;
                this.f9696b = str;
                return this;
            }

            public PairLine setStartTime(String str) {
                this.f9701g = true;
                this.f9702h = str;
                return this;
            }

            public PairLine setUid(String str) {
                this.f9697c = true;
                this.f9698d = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasName()) {
                    codedOutputStreamMicro.writeString(1, getName());
                }
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(2, getUid());
                }
                if (hasDirection()) {
                    codedOutputStreamMicro.writeString(3, getDirection());
                }
                if (hasStartTime()) {
                    codedOutputStreamMicro.writeString(4, getStartTime());
                }
                if (hasEndTime()) {
                    codedOutputStreamMicro.writeString(5, getEndTime());
                }
                if (hasKindtype()) {
                    codedOutputStreamMicro.writeInt32(6, getKindtype());
                }
            }
        }

        public static final class Stations extends MessageMicro {
            public static final int GEO_FIELD_NUMBER = 1;
            public static final int NAME_FIELD_NUMBER = 2;
            public static final int RT_INFO_FIELD_NUMBER = 5;
            public static final int SUBWAYS_FIELD_NUMBER = 4;
            public static final int TRI_RT_INFO_FIELD_NUMBER = 6;
            public static final int UID_FIELD_NUMBER = 3;
            /* renamed from: a */
            private boolean f9746a;
            /* renamed from: b */
            private String f9747b = "";
            /* renamed from: c */
            private boolean f9748c;
            /* renamed from: d */
            private String f9749d = "";
            /* renamed from: e */
            private boolean f9750e;
            /* renamed from: f */
            private String f9751f = "";
            /* renamed from: g */
            private List<Subways> f9752g = Collections.emptyList();
            /* renamed from: h */
            private boolean f9753h;
            /* renamed from: i */
            private RtInfo f9754i = null;
            /* renamed from: j */
            private boolean f9755j;
            /* renamed from: k */
            private TriRtInfo f9756k = null;
            /* renamed from: l */
            private int f9757l = -1;

            public static final class RtInfo extends MessageMicro {
                public static final int NEXT_VEHICLE_FIELD_NUMBER = 1;
                /* renamed from: a */
                private boolean f9723a;
                /* renamed from: b */
                private NextVehicle f9724b = null;
                /* renamed from: c */
                private int f9725c = -1;

                public static final class NextVehicle extends MessageMicro {
                    public static final int HAS_NEXT_VEHICLE_FIELD_NUMBER = 1;
                    public static final int REMAIN_DIST_FIELD_NUMBER = 2;
                    public static final int REMAIN_STOPS_FIELD_NUMBER = 3;
                    public static final int REMAIN_TIME_FIELD_NUMBER = 4;
                    public static final int TIMESTAMP_FIELD_NUMBER = 5;
                    public static final int VEHICLE_X_FIELD_NUMBER = 6;
                    public static final int VEHICLE_Y_FIELD_NUMBER = 7;
                    /* renamed from: a */
                    private boolean f9708a;
                    /* renamed from: b */
                    private int f9709b = 0;
                    /* renamed from: c */
                    private boolean f9710c;
                    /* renamed from: d */
                    private int f9711d = 0;
                    /* renamed from: e */
                    private boolean f9712e;
                    /* renamed from: f */
                    private int f9713f = 0;
                    /* renamed from: g */
                    private boolean f9714g;
                    /* renamed from: h */
                    private int f9715h = 0;
                    /* renamed from: i */
                    private boolean f9716i;
                    /* renamed from: j */
                    private int f9717j = 0;
                    /* renamed from: k */
                    private boolean f9718k;
                    /* renamed from: l */
                    private double f9719l = 0.0d;
                    /* renamed from: m */
                    private boolean f9720m;
                    /* renamed from: n */
                    private double f9721n = 0.0d;
                    /* renamed from: o */
                    private int f9722o = -1;

                    public static NextVehicle parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new NextVehicle().mergeFrom(codedInputStreamMicro);
                    }

                    public static NextVehicle parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (NextVehicle) new NextVehicle().mergeFrom(bArr);
                    }

                    public final NextVehicle clear() {
                        clearHasNextVehicle();
                        clearRemainDist();
                        clearRemainStops();
                        clearRemainTime();
                        clearTimestamp();
                        clearVehicleX();
                        clearVehicleY();
                        this.f9722o = -1;
                        return this;
                    }

                    public NextVehicle clearHasNextVehicle() {
                        this.f9708a = false;
                        this.f9709b = 0;
                        return this;
                    }

                    public NextVehicle clearRemainDist() {
                        this.f9710c = false;
                        this.f9711d = 0;
                        return this;
                    }

                    public NextVehicle clearRemainStops() {
                        this.f9712e = false;
                        this.f9713f = 0;
                        return this;
                    }

                    public NextVehicle clearRemainTime() {
                        this.f9714g = false;
                        this.f9715h = 0;
                        return this;
                    }

                    public NextVehicle clearTimestamp() {
                        this.f9716i = false;
                        this.f9717j = 0;
                        return this;
                    }

                    public NextVehicle clearVehicleX() {
                        this.f9718k = false;
                        this.f9719l = 0.0d;
                        return this;
                    }

                    public NextVehicle clearVehicleY() {
                        this.f9720m = false;
                        this.f9721n = 0.0d;
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f9722o < 0) {
                            getSerializedSize();
                        }
                        return this.f9722o;
                    }

                    public int getHasNextVehicle() {
                        return this.f9709b;
                    }

                    public int getRemainDist() {
                        return this.f9711d;
                    }

                    public int getRemainStops() {
                        return this.f9713f;
                    }

                    public int getRemainTime() {
                        return this.f9715h;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasHasNextVehicle()) {
                            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getHasNextVehicle());
                        }
                        if (hasRemainDist()) {
                            i += CodedOutputStreamMicro.computeInt32Size(2, getRemainDist());
                        }
                        if (hasRemainStops()) {
                            i += CodedOutputStreamMicro.computeInt32Size(3, getRemainStops());
                        }
                        if (hasRemainTime()) {
                            i += CodedOutputStreamMicro.computeInt32Size(4, getRemainTime());
                        }
                        if (hasTimestamp()) {
                            i += CodedOutputStreamMicro.computeInt32Size(5, getTimestamp());
                        }
                        if (hasVehicleX()) {
                            i += CodedOutputStreamMicro.computeDoubleSize(6, getVehicleX());
                        }
                        if (hasVehicleY()) {
                            i += CodedOutputStreamMicro.computeDoubleSize(7, getVehicleY());
                        }
                        this.f9722o = i;
                        return i;
                    }

                    public int getTimestamp() {
                        return this.f9717j;
                    }

                    public double getVehicleX() {
                        return this.f9719l;
                    }

                    public double getVehicleY() {
                        return this.f9721n;
                    }

                    public boolean hasHasNextVehicle() {
                        return this.f9708a;
                    }

                    public boolean hasRemainDist() {
                        return this.f9710c;
                    }

                    public boolean hasRemainStops() {
                        return this.f9712e;
                    }

                    public boolean hasRemainTime() {
                        return this.f9714g;
                    }

                    public boolean hasTimestamp() {
                        return this.f9716i;
                    }

                    public boolean hasVehicleX() {
                        return this.f9718k;
                    }

                    public boolean hasVehicleY() {
                        return this.f9720m;
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
                                    setHasNextVehicle(codedInputStreamMicro.readInt32());
                                    continue;
                                case 16:
                                    setRemainDist(codedInputStreamMicro.readInt32());
                                    continue;
                                case 24:
                                    setRemainStops(codedInputStreamMicro.readInt32());
                                    continue;
                                case 32:
                                    setRemainTime(codedInputStreamMicro.readInt32());
                                    continue;
                                case 40:
                                    setTimestamp(codedInputStreamMicro.readInt32());
                                    continue;
                                case 49:
                                    setVehicleX(codedInputStreamMicro.readDouble());
                                    continue;
                                case 57:
                                    setVehicleY(codedInputStreamMicro.readDouble());
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

                    public NextVehicle setHasNextVehicle(int i) {
                        this.f9708a = true;
                        this.f9709b = i;
                        return this;
                    }

                    public NextVehicle setRemainDist(int i) {
                        this.f9710c = true;
                        this.f9711d = i;
                        return this;
                    }

                    public NextVehicle setRemainStops(int i) {
                        this.f9712e = true;
                        this.f9713f = i;
                        return this;
                    }

                    public NextVehicle setRemainTime(int i) {
                        this.f9714g = true;
                        this.f9715h = i;
                        return this;
                    }

                    public NextVehicle setTimestamp(int i) {
                        this.f9716i = true;
                        this.f9717j = i;
                        return this;
                    }

                    public NextVehicle setVehicleX(double d) {
                        this.f9718k = true;
                        this.f9719l = d;
                        return this;
                    }

                    public NextVehicle setVehicleY(double d) {
                        this.f9720m = true;
                        this.f9721n = d;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasHasNextVehicle()) {
                            codedOutputStreamMicro.writeInt32(1, getHasNextVehicle());
                        }
                        if (hasRemainDist()) {
                            codedOutputStreamMicro.writeInt32(2, getRemainDist());
                        }
                        if (hasRemainStops()) {
                            codedOutputStreamMicro.writeInt32(3, getRemainStops());
                        }
                        if (hasRemainTime()) {
                            codedOutputStreamMicro.writeInt32(4, getRemainTime());
                        }
                        if (hasTimestamp()) {
                            codedOutputStreamMicro.writeInt32(5, getTimestamp());
                        }
                        if (hasVehicleX()) {
                            codedOutputStreamMicro.writeDouble(6, getVehicleX());
                        }
                        if (hasVehicleY()) {
                            codedOutputStreamMicro.writeDouble(7, getVehicleY());
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
                    this.f9725c = -1;
                    return this;
                }

                public RtInfo clearNextVehicle() {
                    this.f9723a = false;
                    this.f9724b = null;
                    return this;
                }

                public int getCachedSize() {
                    if (this.f9725c < 0) {
                        getSerializedSize();
                    }
                    return this.f9725c;
                }

                public NextVehicle getNextVehicle() {
                    return this.f9724b;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasNextVehicle()) {
                        i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getNextVehicle());
                    }
                    this.f9725c = i;
                    return i;
                }

                public boolean hasNextVehicle() {
                    return this.f9723a;
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
                    this.f9723a = true;
                    this.f9724b = nextVehicle;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasNextVehicle()) {
                        codedOutputStreamMicro.writeMessage(1, getNextVehicle());
                    }
                }
            }

            public static final class Subways extends MessageMicro {
                public static final int BACKGROUND_COLOR_FIELD_NUMBER = 2;
                public static final int NAME_FIELD_NUMBER = 1;
                /* renamed from: a */
                private boolean f9726a;
                /* renamed from: b */
                private String f9727b = "";
                /* renamed from: c */
                private boolean f9728c;
                /* renamed from: d */
                private String f9729d = "";
                /* renamed from: e */
                private int f9730e = -1;

                public static Subways parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Subways().mergeFrom(codedInputStreamMicro);
                }

                public static Subways parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Subways) new Subways().mergeFrom(bArr);
                }

                public final Subways clear() {
                    clearName();
                    clearBackgroundColor();
                    this.f9730e = -1;
                    return this;
                }

                public Subways clearBackgroundColor() {
                    this.f9728c = false;
                    this.f9729d = "";
                    return this;
                }

                public Subways clearName() {
                    this.f9726a = false;
                    this.f9727b = "";
                    return this;
                }

                public String getBackgroundColor() {
                    return this.f9729d;
                }

                public int getCachedSize() {
                    if (this.f9730e < 0) {
                        getSerializedSize();
                    }
                    return this.f9730e;
                }

                public String getName() {
                    return this.f9727b;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasName()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
                    }
                    if (hasBackgroundColor()) {
                        i += CodedOutputStreamMicro.computeStringSize(2, getBackgroundColor());
                    }
                    this.f9730e = i;
                    return i;
                }

                public boolean hasBackgroundColor() {
                    return this.f9728c;
                }

                public boolean hasName() {
                    return this.f9726a;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Subways mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                setName(codedInputStreamMicro.readString());
                                continue;
                            case 18:
                                setBackgroundColor(codedInputStreamMicro.readString());
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

                public Subways setBackgroundColor(String str) {
                    this.f9728c = true;
                    this.f9729d = str;
                    return this;
                }

                public Subways setName(String str) {
                    this.f9726a = true;
                    this.f9727b = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(1, getName());
                    }
                    if (hasBackgroundColor()) {
                        codedOutputStreamMicro.writeString(2, getBackgroundColor());
                    }
                }
            }

            public static final class TriRtInfo extends MessageMicro {
                public static final int VEHICLE_INFO_FIELD_NUMBER = 1;
                /* renamed from: a */
                private List<VehicleInfo> f9744a = Collections.emptyList();
                /* renamed from: b */
                private int f9745b = -1;

                public static final class VehicleInfo extends MessageMicro {
                    public static final int REMAIN_DISTANCE_FIELD_NUMBER = 3;
                    public static final int REMAIN_STOP_FIELD_NUMBER = 4;
                    public static final int REMAIN_TIME_FIELD_NUMBER = 2;
                    public static final int REMAIN_TIP_FIELD_NUMBER = 1;
                    public static final int VEHICLE_X_FIELD_NUMBER = 5;
                    public static final int VEHICLE_Y_FIELD_NUMBER = 6;
                    /* renamed from: a */
                    private boolean f9731a;
                    /* renamed from: b */
                    private String f9732b = "";
                    /* renamed from: c */
                    private boolean f9733c;
                    /* renamed from: d */
                    private int f9734d = 0;
                    /* renamed from: e */
                    private boolean f9735e;
                    /* renamed from: f */
                    private int f9736f = 0;
                    /* renamed from: g */
                    private boolean f9737g;
                    /* renamed from: h */
                    private int f9738h = 0;
                    /* renamed from: i */
                    private boolean f9739i;
                    /* renamed from: j */
                    private double f9740j = 0.0d;
                    /* renamed from: k */
                    private boolean f9741k;
                    /* renamed from: l */
                    private double f9742l = 0.0d;
                    /* renamed from: m */
                    private int f9743m = -1;

                    public static VehicleInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new VehicleInfo().mergeFrom(codedInputStreamMicro);
                    }

                    public static VehicleInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (VehicleInfo) new VehicleInfo().mergeFrom(bArr);
                    }

                    public final VehicleInfo clear() {
                        clearRemainTip();
                        clearRemainTime();
                        clearRemainDistance();
                        clearRemainStop();
                        clearVehicleX();
                        clearVehicleY();
                        this.f9743m = -1;
                        return this;
                    }

                    public VehicleInfo clearRemainDistance() {
                        this.f9735e = false;
                        this.f9736f = 0;
                        return this;
                    }

                    public VehicleInfo clearRemainStop() {
                        this.f9737g = false;
                        this.f9738h = 0;
                        return this;
                    }

                    public VehicleInfo clearRemainTime() {
                        this.f9733c = false;
                        this.f9734d = 0;
                        return this;
                    }

                    public VehicleInfo clearRemainTip() {
                        this.f9731a = false;
                        this.f9732b = "";
                        return this;
                    }

                    public VehicleInfo clearVehicleX() {
                        this.f9739i = false;
                        this.f9740j = 0.0d;
                        return this;
                    }

                    public VehicleInfo clearVehicleY() {
                        this.f9741k = false;
                        this.f9742l = 0.0d;
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f9743m < 0) {
                            getSerializedSize();
                        }
                        return this.f9743m;
                    }

                    public int getRemainDistance() {
                        return this.f9736f;
                    }

                    public int getRemainStop() {
                        return this.f9738h;
                    }

                    public int getRemainTime() {
                        return this.f9734d;
                    }

                    public String getRemainTip() {
                        return this.f9732b;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasRemainTip()) {
                            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getRemainTip());
                        }
                        if (hasRemainTime()) {
                            i += CodedOutputStreamMicro.computeInt32Size(2, getRemainTime());
                        }
                        if (hasRemainDistance()) {
                            i += CodedOutputStreamMicro.computeInt32Size(3, getRemainDistance());
                        }
                        if (hasRemainStop()) {
                            i += CodedOutputStreamMicro.computeInt32Size(4, getRemainStop());
                        }
                        if (hasVehicleX()) {
                            i += CodedOutputStreamMicro.computeDoubleSize(5, getVehicleX());
                        }
                        if (hasVehicleY()) {
                            i += CodedOutputStreamMicro.computeDoubleSize(6, getVehicleY());
                        }
                        this.f9743m = i;
                        return i;
                    }

                    public double getVehicleX() {
                        return this.f9740j;
                    }

                    public double getVehicleY() {
                        return this.f9742l;
                    }

                    public boolean hasRemainDistance() {
                        return this.f9735e;
                    }

                    public boolean hasRemainStop() {
                        return this.f9737g;
                    }

                    public boolean hasRemainTime() {
                        return this.f9733c;
                    }

                    public boolean hasRemainTip() {
                        return this.f9731a;
                    }

                    public boolean hasVehicleX() {
                        return this.f9739i;
                    }

                    public boolean hasVehicleY() {
                        return this.f9741k;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public VehicleInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    setRemainTip(codedInputStreamMicro.readString());
                                    continue;
                                case 16:
                                    setRemainTime(codedInputStreamMicro.readInt32());
                                    continue;
                                case 24:
                                    setRemainDistance(codedInputStreamMicro.readInt32());
                                    continue;
                                case 32:
                                    setRemainStop(codedInputStreamMicro.readInt32());
                                    continue;
                                case 41:
                                    setVehicleX(codedInputStreamMicro.readDouble());
                                    continue;
                                case 49:
                                    setVehicleY(codedInputStreamMicro.readDouble());
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

                    public VehicleInfo setRemainDistance(int i) {
                        this.f9735e = true;
                        this.f9736f = i;
                        return this;
                    }

                    public VehicleInfo setRemainStop(int i) {
                        this.f9737g = true;
                        this.f9738h = i;
                        return this;
                    }

                    public VehicleInfo setRemainTime(int i) {
                        this.f9733c = true;
                        this.f9734d = i;
                        return this;
                    }

                    public VehicleInfo setRemainTip(String str) {
                        this.f9731a = true;
                        this.f9732b = str;
                        return this;
                    }

                    public VehicleInfo setVehicleX(double d) {
                        this.f9739i = true;
                        this.f9740j = d;
                        return this;
                    }

                    public VehicleInfo setVehicleY(double d) {
                        this.f9741k = true;
                        this.f9742l = d;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasRemainTip()) {
                            codedOutputStreamMicro.writeString(1, getRemainTip());
                        }
                        if (hasRemainTime()) {
                            codedOutputStreamMicro.writeInt32(2, getRemainTime());
                        }
                        if (hasRemainDistance()) {
                            codedOutputStreamMicro.writeInt32(3, getRemainDistance());
                        }
                        if (hasRemainStop()) {
                            codedOutputStreamMicro.writeInt32(4, getRemainStop());
                        }
                        if (hasVehicleX()) {
                            codedOutputStreamMicro.writeDouble(5, getVehicleX());
                        }
                        if (hasVehicleY()) {
                            codedOutputStreamMicro.writeDouble(6, getVehicleY());
                        }
                    }
                }

                public static TriRtInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new TriRtInfo().mergeFrom(codedInputStreamMicro);
                }

                public static TriRtInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (TriRtInfo) new TriRtInfo().mergeFrom(bArr);
                }

                public TriRtInfo addVehicleInfo(VehicleInfo vehicleInfo) {
                    if (vehicleInfo != null) {
                        if (this.f9744a.isEmpty()) {
                            this.f9744a = new ArrayList();
                        }
                        this.f9744a.add(vehicleInfo);
                    }
                    return this;
                }

                public final TriRtInfo clear() {
                    clearVehicleInfo();
                    this.f9745b = -1;
                    return this;
                }

                public TriRtInfo clearVehicleInfo() {
                    this.f9744a = Collections.emptyList();
                    return this;
                }

                public int getCachedSize() {
                    if (this.f9745b < 0) {
                        getSerializedSize();
                    }
                    return this.f9745b;
                }

                public int getSerializedSize() {
                    int i = 0;
                    for (VehicleInfo computeMessageSize : getVehicleInfoList()) {
                        i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
                    }
                    this.f9745b = i;
                    return i;
                }

                public VehicleInfo getVehicleInfo(int i) {
                    return (VehicleInfo) this.f9744a.get(i);
                }

                public int getVehicleInfoCount() {
                    return this.f9744a.size();
                }

                public List<VehicleInfo> getVehicleInfoList() {
                    return this.f9744a;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public TriRtInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                MessageMicro vehicleInfo = new VehicleInfo();
                                codedInputStreamMicro.readMessage(vehicleInfo);
                                addVehicleInfo(vehicleInfo);
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

                public TriRtInfo setVehicleInfo(int i, VehicleInfo vehicleInfo) {
                    if (vehicleInfo != null) {
                        this.f9744a.set(i, vehicleInfo);
                    }
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    for (VehicleInfo writeMessage : getVehicleInfoList()) {
                        codedOutputStreamMicro.writeMessage(1, writeMessage);
                    }
                }
            }

            public static Stations parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Stations().mergeFrom(codedInputStreamMicro);
            }

            public static Stations parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Stations) new Stations().mergeFrom(bArr);
            }

            public Stations addSubways(Subways subways) {
                if (subways != null) {
                    if (this.f9752g.isEmpty()) {
                        this.f9752g = new ArrayList();
                    }
                    this.f9752g.add(subways);
                }
                return this;
            }

            public final Stations clear() {
                clearGeo();
                clearName();
                clearUid();
                clearSubways();
                clearRtInfo();
                clearTriRtInfo();
                this.f9757l = -1;
                return this;
            }

            public Stations clearGeo() {
                this.f9746a = false;
                this.f9747b = "";
                return this;
            }

            public Stations clearName() {
                this.f9748c = false;
                this.f9749d = "";
                return this;
            }

            public Stations clearRtInfo() {
                this.f9753h = false;
                this.f9754i = null;
                return this;
            }

            public Stations clearSubways() {
                this.f9752g = Collections.emptyList();
                return this;
            }

            public Stations clearTriRtInfo() {
                this.f9755j = false;
                this.f9756k = null;
                return this;
            }

            public Stations clearUid() {
                this.f9750e = false;
                this.f9751f = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f9757l < 0) {
                    getSerializedSize();
                }
                return this.f9757l;
            }

            public String getGeo() {
                return this.f9747b;
            }

            public String getName() {
                return this.f9749d;
            }

            public RtInfo getRtInfo() {
                return this.f9754i;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasGeo()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getGeo());
                }
                if (hasName()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getName());
                }
                if (hasUid()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getUid());
                }
                int i2 = i;
                for (Subways computeMessageSize : getSubwaysList()) {
                    i2 = CodedOutputStreamMicro.computeMessageSize(4, computeMessageSize) + i2;
                }
                if (hasRtInfo()) {
                    i2 += CodedOutputStreamMicro.computeMessageSize(5, getRtInfo());
                }
                if (hasTriRtInfo()) {
                    i2 += CodedOutputStreamMicro.computeMessageSize(6, getTriRtInfo());
                }
                this.f9757l = i2;
                return i2;
            }

            public Subways getSubways(int i) {
                return (Subways) this.f9752g.get(i);
            }

            public int getSubwaysCount() {
                return this.f9752g.size();
            }

            public List<Subways> getSubwaysList() {
                return this.f9752g;
            }

            public TriRtInfo getTriRtInfo() {
                return this.f9756k;
            }

            public String getUid() {
                return this.f9751f;
            }

            public boolean hasGeo() {
                return this.f9746a;
            }

            public boolean hasName() {
                return this.f9748c;
            }

            public boolean hasRtInfo() {
                return this.f9753h;
            }

            public boolean hasTriRtInfo() {
                return this.f9755j;
            }

            public boolean hasUid() {
                return this.f9750e;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Stations mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    MessageMicro subways;
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
                        case 34:
                            subways = new Subways();
                            codedInputStreamMicro.readMessage(subways);
                            addSubways(subways);
                            continue;
                        case 42:
                            subways = new RtInfo();
                            codedInputStreamMicro.readMessage(subways);
                            setRtInfo(subways);
                            continue;
                        case 50:
                            subways = new TriRtInfo();
                            codedInputStreamMicro.readMessage(subways);
                            setTriRtInfo(subways);
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

            public Stations setGeo(String str) {
                this.f9746a = true;
                this.f9747b = str;
                return this;
            }

            public Stations setName(String str) {
                this.f9748c = true;
                this.f9749d = str;
                return this;
            }

            public Stations setRtInfo(RtInfo rtInfo) {
                if (rtInfo == null) {
                    return clearRtInfo();
                }
                this.f9753h = true;
                this.f9754i = rtInfo;
                return this;
            }

            public Stations setSubways(int i, Subways subways) {
                if (subways != null) {
                    this.f9752g.set(i, subways);
                }
                return this;
            }

            public Stations setTriRtInfo(TriRtInfo triRtInfo) {
                if (triRtInfo == null) {
                    return clearTriRtInfo();
                }
                this.f9755j = true;
                this.f9756k = triRtInfo;
                return this;
            }

            public Stations setUid(String str) {
                this.f9750e = true;
                this.f9751f = str;
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
                for (Subways writeMessage : getSubwaysList()) {
                    codedOutputStreamMicro.writeMessage(4, writeMessage);
                }
                if (hasRtInfo()) {
                    codedOutputStreamMicro.writeMessage(5, getRtInfo());
                }
                if (hasTriRtInfo()) {
                    codedOutputStreamMicro.writeMessage(6, getTriRtInfo());
                }
            }
        }

        public static final class UgcInfo extends MessageMicro {
            public static final int TIME_FIELD_NUMBER = 1;
            public static final int TYPE_FIELD_NUMBER = 2;
            public static final int USER_FIELD_NUMBER = 3;
            /* renamed from: a */
            private boolean f9758a;
            /* renamed from: b */
            private String f9759b = "";
            /* renamed from: c */
            private boolean f9760c;
            /* renamed from: d */
            private int f9761d = 0;
            /* renamed from: e */
            private boolean f9762e;
            /* renamed from: f */
            private String f9763f = "";
            /* renamed from: g */
            private int f9764g = -1;

            public static UgcInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new UgcInfo().mergeFrom(codedInputStreamMicro);
            }

            public static UgcInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (UgcInfo) new UgcInfo().mergeFrom(bArr);
            }

            public final UgcInfo clear() {
                clearTime();
                clearType();
                clearUser();
                this.f9764g = -1;
                return this;
            }

            public UgcInfo clearTime() {
                this.f9758a = false;
                this.f9759b = "";
                return this;
            }

            public UgcInfo clearType() {
                this.f9760c = false;
                this.f9761d = 0;
                return this;
            }

            public UgcInfo clearUser() {
                this.f9762e = false;
                this.f9763f = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f9764g < 0) {
                    getSerializedSize();
                }
                return this.f9764g;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasTime()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTime());
                }
                if (hasType()) {
                    i += CodedOutputStreamMicro.computeInt32Size(2, getType());
                }
                if (hasUser()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getUser());
                }
                this.f9764g = i;
                return i;
            }

            public String getTime() {
                return this.f9759b;
            }

            public int getType() {
                return this.f9761d;
            }

            public String getUser() {
                return this.f9763f;
            }

            public boolean hasTime() {
                return this.f9758a;
            }

            public boolean hasType() {
                return this.f9760c;
            }

            public boolean hasUser() {
                return this.f9762e;
            }

            public final boolean isInitialized() {
                return true;
            }

            public UgcInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setTime(codedInputStreamMicro.readString());
                            continue;
                        case 16:
                            setType(codedInputStreamMicro.readInt32());
                            continue;
                        case 26:
                            setUser(codedInputStreamMicro.readString());
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

            public UgcInfo setTime(String str) {
                this.f9758a = true;
                this.f9759b = str;
                return this;
            }

            public UgcInfo setType(int i) {
                this.f9760c = true;
                this.f9761d = i;
                return this;
            }

            public UgcInfo setUser(String str) {
                this.f9762e = true;
                this.f9763f = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasTime()) {
                    codedOutputStreamMicro.writeString(1, getTime());
                }
                if (hasType()) {
                    codedOutputStreamMicro.writeInt32(2, getType());
                }
                if (hasUser()) {
                    codedOutputStreamMicro.writeString(3, getUser());
                }
            }
        }

        public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Content().mergeFrom(codedInputStreamMicro);
        }

        public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Content) new Content().mergeFrom(bArr);
        }

        public Content addStations(Stations stations) {
            if (stations != null) {
                if (this.f9774J.isEmpty()) {
                    this.f9774J = new ArrayList();
                }
                this.f9774J.add(stations);
            }
            return this;
        }

        public Content addUgcinfo(UgcInfo ugcInfo) {
            if (ugcInfo != null) {
                if (this.f9777M.isEmpty()) {
                    this.f9777M = new ArrayList();
                }
                this.f9777M.add(ugcInfo);
            }
            return this;
        }

        public Content addWorkingTimeDesc(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f9795m.isEmpty()) {
                this.f9795m = new ArrayList();
            }
            this.f9795m.add(str);
            return this;
        }

        public final Content clear() {
            clearName();
            clearGeo();
            clearIsMonTicket();
            clearIsDisplay();
            clearMaxPrice();
            clearKindtype();
            clearWorkingTimeDesc();
            clearStartTime();
            clearEndTime();
            clearTicketPrice();
            clearRtbusUpdateTime();
            clearRtbusUpdateInterval();
            clearNearestStationIdx();
            clearRtbusNu();
            clearTriRtbusTip();
            clearHeadway();
            clearLineDirection();
            clearPairLine();
            clearStations();
            clearUid();
            clearUgcinfo();
            clearImage();
            clearRunState();
            this.f9782R = -1;
            return this;
        }

        public Content clearEndTime() {
            this.f9798p = false;
            this.f9799q = "";
            return this;
        }

        public Content clearGeo() {
            this.f9785c = false;
            this.f9786d = "";
            return this;
        }

        public Content clearHeadway() {
            this.f9768D = false;
            this.f9769E = "";
            return this;
        }

        public Content clearImage() {
            this.f9778N = false;
            this.f9779O = ByteStringMicro.EMPTY;
            return this;
        }

        public Content clearIsDisplay() {
            this.f9789g = false;
            this.f9790h = 0;
            return this;
        }

        public Content clearIsMonTicket() {
            this.f9787e = false;
            this.f9788f = 0;
            return this;
        }

        public Content clearKindtype() {
            this.f9793k = false;
            this.f9794l = 0;
            return this;
        }

        public Content clearLineDirection() {
            this.f9770F = false;
            this.f9771G = "";
            return this;
        }

        public Content clearMaxPrice() {
            this.f9791i = false;
            this.f9792j = 0;
            return this;
        }

        public Content clearName() {
            this.f9783a = false;
            this.f9784b = "";
            return this;
        }

        public Content clearNearestStationIdx() {
            this.f9806x = false;
            this.f9807y = 0;
            return this;
        }

        public Content clearPairLine() {
            this.f9772H = false;
            this.f9773I = null;
            return this;
        }

        public Content clearRtbusNu() {
            this.f9808z = false;
            this.f9765A = 0;
            return this;
        }

        public Content clearRtbusUpdateInterval() {
            this.f9804v = false;
            this.f9805w = 0;
            return this;
        }

        public Content clearRtbusUpdateTime() {
            this.f9802t = false;
            this.f9803u = 0;
            return this;
        }

        public Content clearRunState() {
            this.f9780P = false;
            this.f9781Q = 0;
            return this;
        }

        public Content clearStartTime() {
            this.f9796n = false;
            this.f9797o = "";
            return this;
        }

        public Content clearStations() {
            this.f9774J = Collections.emptyList();
            return this;
        }

        public Content clearTicketPrice() {
            this.f9800r = false;
            this.f9801s = 0;
            return this;
        }

        public Content clearTriRtbusTip() {
            this.f9766B = false;
            this.f9767C = "";
            return this;
        }

        public Content clearUgcinfo() {
            this.f9777M = Collections.emptyList();
            return this;
        }

        public Content clearUid() {
            this.f9775K = false;
            this.f9776L = "";
            return this;
        }

        public Content clearWorkingTimeDesc() {
            this.f9795m = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f9782R < 0) {
                getSerializedSize();
            }
            return this.f9782R;
        }

        public String getEndTime() {
            return this.f9799q;
        }

        public String getGeo() {
            return this.f9786d;
        }

        public String getHeadway() {
            return this.f9769E;
        }

        public ByteStringMicro getImage() {
            return this.f9779O;
        }

        public int getIsDisplay() {
            return this.f9790h;
        }

        public int getIsMonTicket() {
            return this.f9788f;
        }

        public int getKindtype() {
            return this.f9794l;
        }

        public String getLineDirection() {
            return this.f9771G;
        }

        public int getMaxPrice() {
            return this.f9792j;
        }

        public String getName() {
            return this.f9784b;
        }

        public int getNearestStationIdx() {
            return this.f9807y;
        }

        public PairLine getPairLine() {
            return this.f9773I;
        }

        public int getRtbusNu() {
            return this.f9765A;
        }

        public int getRtbusUpdateInterval() {
            return this.f9805w;
        }

        public int getRtbusUpdateTime() {
            return this.f9803u;
        }

        public int getRunState() {
            return this.f9781Q;
        }

        public int getSerializedSize() {
            int i = 0;
            int computeStringSize = hasName() ? CodedOutputStreamMicro.computeStringSize(1, getName()) + 0 : 0;
            if (hasGeo()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getGeo());
            }
            if (hasIsMonTicket()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(3, getIsMonTicket());
            }
            if (hasIsDisplay()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, getIsDisplay());
            }
            if (hasMaxPrice()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(5, getMaxPrice());
            }
            int computeInt32Size = hasKindtype() ? computeStringSize + CodedOutputStreamMicro.computeInt32Size(6, getKindtype()) : computeStringSize;
            for (String computeStringSizeNoTag : getWorkingTimeDescList()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag);
            }
            computeStringSize = (computeInt32Size + i) + (getWorkingTimeDescList().size() * 1);
            if (hasStartTime()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(8, getStartTime());
            }
            if (hasEndTime()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(9, getEndTime());
            }
            if (hasTicketPrice()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(10, getTicketPrice());
            }
            if (hasRtbusUpdateTime()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(11, getRtbusUpdateTime());
            }
            if (hasRtbusUpdateInterval()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(12, getRtbusUpdateInterval());
            }
            if (hasNearestStationIdx()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(13, getNearestStationIdx());
            }
            if (hasRtbusNu()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(14, getRtbusNu());
            }
            if (hasTriRtbusTip()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(15, getTriRtbusTip());
            }
            if (hasHeadway()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(16, getHeadway());
            }
            if (hasLineDirection()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(17, getLineDirection());
            }
            if (hasPairLine()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(18, getPairLine());
            }
            i = computeStringSize;
            for (Stations computeMessageSize : getStationsList()) {
                i = CodedOutputStreamMicro.computeMessageSize(19, computeMessageSize) + i;
            }
            if (hasUid()) {
                i += CodedOutputStreamMicro.computeStringSize(20, getUid());
            }
            for (UgcInfo computeMessageSize2 : getUgcinfoList()) {
                i += CodedOutputStreamMicro.computeMessageSize(21, computeMessageSize2);
            }
            if (hasImage()) {
                i += CodedOutputStreamMicro.computeBytesSize(22, getImage());
            }
            if (hasRunState()) {
                i += CodedOutputStreamMicro.computeInt32Size(23, getRunState());
            }
            this.f9782R = i;
            return i;
        }

        public String getStartTime() {
            return this.f9797o;
        }

        public Stations getStations(int i) {
            return (Stations) this.f9774J.get(i);
        }

        public int getStationsCount() {
            return this.f9774J.size();
        }

        public List<Stations> getStationsList() {
            return this.f9774J;
        }

        public int getTicketPrice() {
            return this.f9801s;
        }

        public String getTriRtbusTip() {
            return this.f9767C;
        }

        public UgcInfo getUgcinfo(int i) {
            return (UgcInfo) this.f9777M.get(i);
        }

        public int getUgcinfoCount() {
            return this.f9777M.size();
        }

        public List<UgcInfo> getUgcinfoList() {
            return this.f9777M;
        }

        public String getUid() {
            return this.f9776L;
        }

        public String getWorkingTimeDesc(int i) {
            return (String) this.f9795m.get(i);
        }

        public int getWorkingTimeDescCount() {
            return this.f9795m.size();
        }

        public List<String> getWorkingTimeDescList() {
            return this.f9795m;
        }

        public boolean hasEndTime() {
            return this.f9798p;
        }

        public boolean hasGeo() {
            return this.f9785c;
        }

        public boolean hasHeadway() {
            return this.f9768D;
        }

        public boolean hasImage() {
            return this.f9778N;
        }

        public boolean hasIsDisplay() {
            return this.f9789g;
        }

        public boolean hasIsMonTicket() {
            return this.f9787e;
        }

        public boolean hasKindtype() {
            return this.f9793k;
        }

        public boolean hasLineDirection() {
            return this.f9770F;
        }

        public boolean hasMaxPrice() {
            return this.f9791i;
        }

        public boolean hasName() {
            return this.f9783a;
        }

        public boolean hasNearestStationIdx() {
            return this.f9806x;
        }

        public boolean hasPairLine() {
            return this.f9772H;
        }

        public boolean hasRtbusNu() {
            return this.f9808z;
        }

        public boolean hasRtbusUpdateInterval() {
            return this.f9804v;
        }

        public boolean hasRtbusUpdateTime() {
            return this.f9802t;
        }

        public boolean hasRunState() {
            return this.f9780P;
        }

        public boolean hasStartTime() {
            return this.f9796n;
        }

        public boolean hasTicketPrice() {
            return this.f9800r;
        }

        public boolean hasTriRtbusTip() {
            return this.f9766B;
        }

        public boolean hasUid() {
            return this.f9775K;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Content mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro pairLine;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setName(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setGeo(codedInputStreamMicro.readString());
                        continue;
                    case 24:
                        setIsMonTicket(codedInputStreamMicro.readInt32());
                        continue;
                    case 32:
                        setIsDisplay(codedInputStreamMicro.readInt32());
                        continue;
                    case 40:
                        setMaxPrice(codedInputStreamMicro.readInt32());
                        continue;
                    case 48:
                        setKindtype(codedInputStreamMicro.readInt32());
                        continue;
                    case 58:
                        addWorkingTimeDesc(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setStartTime(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setEndTime(codedInputStreamMicro.readString());
                        continue;
                    case 80:
                        setTicketPrice(codedInputStreamMicro.readInt32());
                        continue;
                    case 88:
                        setRtbusUpdateTime(codedInputStreamMicro.readInt32());
                        continue;
                    case 96:
                        setRtbusUpdateInterval(codedInputStreamMicro.readInt32());
                        continue;
                    case 104:
                        setNearestStationIdx(codedInputStreamMicro.readInt32());
                        continue;
                    case 112:
                        setRtbusNu(codedInputStreamMicro.readInt32());
                        continue;
                    case C1253f.df /*122*/:
                        setTriRtbusTip(codedInputStreamMicro.readString());
                        continue;
                    case 130:
                        setHeadway(codedInputStreamMicro.readString());
                        continue;
                    case 138:
                        setLineDirection(codedInputStreamMicro.readString());
                        continue;
                    case 146:
                        pairLine = new PairLine();
                        codedInputStreamMicro.readMessage(pairLine);
                        setPairLine(pairLine);
                        continue;
                    case 154:
                        pairLine = new Stations();
                        codedInputStreamMicro.readMessage(pairLine);
                        addStations(pairLine);
                        continue;
                    case 162:
                        setUid(codedInputStreamMicro.readString());
                        continue;
                    case 170:
                        pairLine = new UgcInfo();
                        codedInputStreamMicro.readMessage(pairLine);
                        addUgcinfo(pairLine);
                        continue;
                    case 178:
                        setImage(codedInputStreamMicro.readBytes());
                        continue;
                    case 184:
                        setRunState(codedInputStreamMicro.readInt32());
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

        public Content setEndTime(String str) {
            this.f9798p = true;
            this.f9799q = str;
            return this;
        }

        public Content setGeo(String str) {
            this.f9785c = true;
            this.f9786d = str;
            return this;
        }

        public Content setHeadway(String str) {
            this.f9768D = true;
            this.f9769E = str;
            return this;
        }

        public Content setImage(ByteStringMicro byteStringMicro) {
            this.f9778N = true;
            this.f9779O = byteStringMicro;
            return this;
        }

        public Content setIsDisplay(int i) {
            this.f9789g = true;
            this.f9790h = i;
            return this;
        }

        public Content setIsMonTicket(int i) {
            this.f9787e = true;
            this.f9788f = i;
            return this;
        }

        public Content setKindtype(int i) {
            this.f9793k = true;
            this.f9794l = i;
            return this;
        }

        public Content setLineDirection(String str) {
            this.f9770F = true;
            this.f9771G = str;
            return this;
        }

        public Content setMaxPrice(int i) {
            this.f9791i = true;
            this.f9792j = i;
            return this;
        }

        public Content setName(String str) {
            this.f9783a = true;
            this.f9784b = str;
            return this;
        }

        public Content setNearestStationIdx(int i) {
            this.f9806x = true;
            this.f9807y = i;
            return this;
        }

        public Content setPairLine(PairLine pairLine) {
            if (pairLine == null) {
                return clearPairLine();
            }
            this.f9772H = true;
            this.f9773I = pairLine;
            return this;
        }

        public Content setRtbusNu(int i) {
            this.f9808z = true;
            this.f9765A = i;
            return this;
        }

        public Content setRtbusUpdateInterval(int i) {
            this.f9804v = true;
            this.f9805w = i;
            return this;
        }

        public Content setRtbusUpdateTime(int i) {
            this.f9802t = true;
            this.f9803u = i;
            return this;
        }

        public Content setRunState(int i) {
            this.f9780P = true;
            this.f9781Q = i;
            return this;
        }

        public Content setStartTime(String str) {
            this.f9796n = true;
            this.f9797o = str;
            return this;
        }

        public Content setStations(int i, Stations stations) {
            if (stations != null) {
                this.f9774J.set(i, stations);
            }
            return this;
        }

        public Content setTicketPrice(int i) {
            this.f9800r = true;
            this.f9801s = i;
            return this;
        }

        public Content setTriRtbusTip(String str) {
            this.f9766B = true;
            this.f9767C = str;
            return this;
        }

        public Content setUgcinfo(int i, UgcInfo ugcInfo) {
            if (ugcInfo != null) {
                this.f9777M.set(i, ugcInfo);
            }
            return this;
        }

        public Content setUid(String str) {
            this.f9775K = true;
            this.f9776L = str;
            return this;
        }

        public Content setWorkingTimeDesc(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f9795m.set(i, str);
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasName()) {
                codedOutputStreamMicro.writeString(1, getName());
            }
            if (hasGeo()) {
                codedOutputStreamMicro.writeString(2, getGeo());
            }
            if (hasIsMonTicket()) {
                codedOutputStreamMicro.writeInt32(3, getIsMonTicket());
            }
            if (hasIsDisplay()) {
                codedOutputStreamMicro.writeInt32(4, getIsDisplay());
            }
            if (hasMaxPrice()) {
                codedOutputStreamMicro.writeInt32(5, getMaxPrice());
            }
            if (hasKindtype()) {
                codedOutputStreamMicro.writeInt32(6, getKindtype());
            }
            for (String writeString : getWorkingTimeDescList()) {
                codedOutputStreamMicro.writeString(7, writeString);
            }
            if (hasStartTime()) {
                codedOutputStreamMicro.writeString(8, getStartTime());
            }
            if (hasEndTime()) {
                codedOutputStreamMicro.writeString(9, getEndTime());
            }
            if (hasTicketPrice()) {
                codedOutputStreamMicro.writeInt32(10, getTicketPrice());
            }
            if (hasRtbusUpdateTime()) {
                codedOutputStreamMicro.writeInt32(11, getRtbusUpdateTime());
            }
            if (hasRtbusUpdateInterval()) {
                codedOutputStreamMicro.writeInt32(12, getRtbusUpdateInterval());
            }
            if (hasNearestStationIdx()) {
                codedOutputStreamMicro.writeInt32(13, getNearestStationIdx());
            }
            if (hasRtbusNu()) {
                codedOutputStreamMicro.writeInt32(14, getRtbusNu());
            }
            if (hasTriRtbusTip()) {
                codedOutputStreamMicro.writeString(15, getTriRtbusTip());
            }
            if (hasHeadway()) {
                codedOutputStreamMicro.writeString(16, getHeadway());
            }
            if (hasLineDirection()) {
                codedOutputStreamMicro.writeString(17, getLineDirection());
            }
            if (hasPairLine()) {
                codedOutputStreamMicro.writeMessage(18, getPairLine());
            }
            for (Stations writeMessage : getStationsList()) {
                codedOutputStreamMicro.writeMessage(19, writeMessage);
            }
            if (hasUid()) {
                codedOutputStreamMicro.writeString(20, getUid());
            }
            for (UgcInfo writeMessage2 : getUgcinfoList()) {
                codedOutputStreamMicro.writeMessage(21, writeMessage2);
            }
            if (hasImage()) {
                codedOutputStreamMicro.writeBytes(22, getImage());
            }
            if (hasRunState()) {
                codedOutputStreamMicro.writeInt32(23, getRunState());
            }
        }
    }

    public static final class Option extends MessageMicro {
        public static final int COUNT_FIELD_NUMBER = 2;
        public static final int HAS_RTBUS_FIELD_NUMBER = 4;
        public static final int LINETYPE_FIELD_NUMBER = 5;
        public static final int RTINFO_SY_FIELD_NUMBER = 3;
        public static final int TIME_FIELD_NUMBER = 6;
        public static final int TOTAL_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f9809a;
        /* renamed from: b */
        private int f9810b = 0;
        /* renamed from: c */
        private boolean f9811c;
        /* renamed from: d */
        private int f9812d = 0;
        /* renamed from: e */
        private boolean f9813e;
        /* renamed from: f */
        private int f9814f = 0;
        /* renamed from: g */
        private boolean f9815g;
        /* renamed from: h */
        private int f9816h = 0;
        /* renamed from: i */
        private boolean f9817i;
        /* renamed from: j */
        private int f9818j = 0;
        /* renamed from: k */
        private boolean f9819k;
        /* renamed from: l */
        private int f9820l = 0;
        /* renamed from: m */
        private int f9821m = -1;

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }

        public final Option clear() {
            clearTotal();
            clearCount();
            clearRtinfoSy();
            clearHasRtbus();
            clearLinetype();
            clearTime();
            this.f9821m = -1;
            return this;
        }

        public Option clearCount() {
            this.f9811c = false;
            this.f9812d = 0;
            return this;
        }

        public Option clearHasRtbus() {
            this.f9815g = false;
            this.f9816h = 0;
            return this;
        }

        public Option clearLinetype() {
            this.f9817i = false;
            this.f9818j = 0;
            return this;
        }

        public Option clearRtinfoSy() {
            this.f9813e = false;
            this.f9814f = 0;
            return this;
        }

        public Option clearTime() {
            this.f9819k = false;
            this.f9820l = 0;
            return this;
        }

        public Option clearTotal() {
            this.f9809a = false;
            this.f9810b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f9821m < 0) {
                getSerializedSize();
            }
            return this.f9821m;
        }

        public int getCount() {
            return this.f9812d;
        }

        public int getHasRtbus() {
            return this.f9816h;
        }

        public int getLinetype() {
            return this.f9818j;
        }

        public int getRtinfoSy() {
            return this.f9814f;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTotal()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getTotal());
            }
            if (hasCount()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getCount());
            }
            if (hasRtinfoSy()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getRtinfoSy());
            }
            if (hasHasRtbus()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, getHasRtbus());
            }
            if (hasLinetype()) {
                i += CodedOutputStreamMicro.computeInt32Size(5, getLinetype());
            }
            if (hasTime()) {
                i += CodedOutputStreamMicro.computeInt32Size(6, getTime());
            }
            this.f9821m = i;
            return i;
        }

        public int getTime() {
            return this.f9820l;
        }

        public int getTotal() {
            return this.f9810b;
        }

        public boolean hasCount() {
            return this.f9811c;
        }

        public boolean hasHasRtbus() {
            return this.f9815g;
        }

        public boolean hasLinetype() {
            return this.f9817i;
        }

        public boolean hasRtinfoSy() {
            return this.f9813e;
        }

        public boolean hasTime() {
            return this.f9819k;
        }

        public boolean hasTotal() {
            return this.f9809a;
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
                        setTotal(codedInputStreamMicro.readInt32());
                        continue;
                    case 16:
                        setCount(codedInputStreamMicro.readInt32());
                        continue;
                    case 24:
                        setRtinfoSy(codedInputStreamMicro.readInt32());
                        continue;
                    case 32:
                        setHasRtbus(codedInputStreamMicro.readInt32());
                        continue;
                    case 40:
                        setLinetype(codedInputStreamMicro.readInt32());
                        continue;
                    case 48:
                        setTime(codedInputStreamMicro.readInt32());
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

        public Option setCount(int i) {
            this.f9811c = true;
            this.f9812d = i;
            return this;
        }

        public Option setHasRtbus(int i) {
            this.f9815g = true;
            this.f9816h = i;
            return this;
        }

        public Option setLinetype(int i) {
            this.f9817i = true;
            this.f9818j = i;
            return this;
        }

        public Option setRtinfoSy(int i) {
            this.f9813e = true;
            this.f9814f = i;
            return this;
        }

        public Option setTime(int i) {
            this.f9819k = true;
            this.f9820l = i;
            return this;
        }

        public Option setTotal(int i) {
            this.f9809a = true;
            this.f9810b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTotal()) {
                codedOutputStreamMicro.writeInt32(1, getTotal());
            }
            if (hasCount()) {
                codedOutputStreamMicro.writeInt32(2, getCount());
            }
            if (hasRtinfoSy()) {
                codedOutputStreamMicro.writeInt32(3, getRtinfoSy());
            }
            if (hasHasRtbus()) {
                codedOutputStreamMicro.writeInt32(4, getHasRtbus());
            }
            if (hasLinetype()) {
                codedOutputStreamMicro.writeInt32(5, getLinetype());
            }
            if (hasTime()) {
                codedOutputStreamMicro.writeInt32(6, getTime());
            }
        }
    }

    public static Bsl parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Bsl().mergeFrom(codedInputStreamMicro);
    }

    public static Bsl parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Bsl) new Bsl().mergeFrom(bArr);
    }

    public Bsl addContent(Content content) {
        if (content != null) {
            if (this.f9826e.isEmpty()) {
                this.f9826e = new ArrayList();
            }
            this.f9826e.add(content);
        }
        return this;
    }

    public final Bsl clear() {
        clearOption();
        clearCurrentCity();
        clearContent();
        this.f9827f = -1;
        return this;
    }

    public Bsl clearContent() {
        this.f9826e = Collections.emptyList();
        return this;
    }

    public Bsl clearCurrentCity() {
        this.f9824c = false;
        this.f9825d = null;
        return this;
    }

    public Bsl clearOption() {
        this.f9822a = false;
        this.f9823b = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f9827f < 0) {
            getSerializedSize();
        }
        return this.f9827f;
    }

    public Content getContent(int i) {
        return (Content) this.f9826e.get(i);
    }

    public int getContentCount() {
        return this.f9826e.size();
    }

    public List<Content> getContentList() {
        return this.f9826e;
    }

    public CurrentCity getCurrentCity() {
        return this.f9825d;
    }

    public Option getOption() {
        return this.f9823b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasOption()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
        }
        if (hasCurrentCity()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getCurrentCity());
        }
        int i2 = i;
        for (Content computeMessageSize : getContentList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
        }
        this.f9827f = i2;
        return i2;
    }

    public boolean hasCurrentCity() {
        return this.f9824c;
    }

    public boolean hasOption() {
        return this.f9822a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Bsl mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                    addContent(option);
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

    public Bsl setContent(int i, Content content) {
        if (content != null) {
            this.f9826e.set(i, content);
        }
        return this;
    }

    public Bsl setCurrentCity(CurrentCity currentCity) {
        if (currentCity == null) {
            return clearCurrentCity();
        }
        this.f9824c = true;
        this.f9825d = currentCity;
        return this;
    }

    public Bsl setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f9822a = true;
        this.f9823b = option;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(1, getOption());
        }
        if (hasCurrentCity()) {
            codedOutputStreamMicro.writeMessage(2, getCurrentCity());
        }
        for (Content writeMessage : getContentList()) {
            codedOutputStreamMicro.writeMessage(3, writeMessage);
        }
    }
}
