package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class IndoorNavi extends MessageMicro {
    public static final int OPTION_FIELD_NUMBER = 1;
    public static final int ROUTES_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f11295a;
    /* renamed from: b */
    private Option f11296b = null;
    /* renamed from: c */
    private List<Routes> f11297c = Collections.emptyList();
    /* renamed from: d */
    private int f11298d = -1;

    public static final class Option extends MessageMicro {
        public static final int ERROR_FIELD_NUMBER = 1;
        public static final int TOTAL_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 3;
        /* renamed from: a */
        private boolean f11247a;
        /* renamed from: b */
        private int f11248b = 0;
        /* renamed from: c */
        private boolean f11249c;
        /* renamed from: d */
        private int f11250d = 0;
        /* renamed from: e */
        private boolean f11251e;
        /* renamed from: f */
        private int f11252f = 0;
        /* renamed from: g */
        private int f11253g = -1;

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }

        public final Option clear() {
            clearError();
            clearTotal();
            clearType();
            this.f11253g = -1;
            return this;
        }

        public Option clearError() {
            this.f11247a = false;
            this.f11248b = 0;
            return this;
        }

        public Option clearTotal() {
            this.f11249c = false;
            this.f11250d = 0;
            return this;
        }

        public Option clearType() {
            this.f11251e = false;
            this.f11252f = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f11253g < 0) {
                getSerializedSize();
            }
            return this.f11253g;
        }

        public int getError() {
            return this.f11248b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasError()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
            }
            if (hasTotal()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getTotal());
            }
            if (hasType()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getType());
            }
            this.f11253g = i;
            return i;
        }

        public int getTotal() {
            return this.f11250d;
        }

        public int getType() {
            return this.f11252f;
        }

        public boolean hasError() {
            return this.f11247a;
        }

        public boolean hasTotal() {
            return this.f11249c;
        }

        public boolean hasType() {
            return this.f11251e;
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
                        setError(codedInputStreamMicro.readInt32());
                        continue;
                    case 16:
                        setTotal(codedInputStreamMicro.readInt32());
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

        public Option setError(int i) {
            this.f11247a = true;
            this.f11248b = i;
            return this;
        }

        public Option setTotal(int i) {
            this.f11249c = true;
            this.f11250d = i;
            return this;
        }

        public Option setType(int i) {
            this.f11251e = true;
            this.f11252f = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasError()) {
                codedOutputStreamMicro.writeInt32(1, getError());
            }
            if (hasTotal()) {
                codedOutputStreamMicro.writeInt32(2, getTotal());
            }
            if (hasType()) {
                codedOutputStreamMicro.writeInt32(3, getType());
            }
        }
    }

    public static final class Routes extends MessageMicro {
        public static final int DISTANCE_FIELD_NUMBER = 1;
        public static final int DURATION_FIELD_NUMBER = 2;
        public static final int LEGS_FIELD_NUMBER = 3;
        public static final int LOC_LEVEL_FIELD_NUMBER = 4;
        /* renamed from: a */
        private boolean f11287a;
        /* renamed from: b */
        private int f11288b = 0;
        /* renamed from: c */
        private boolean f11289c;
        /* renamed from: d */
        private int f11290d = 0;
        /* renamed from: e */
        private List<Legs> f11291e = Collections.emptyList();
        /* renamed from: f */
        private boolean f11292f;
        /* renamed from: g */
        private int f11293g = 0;
        /* renamed from: h */
        private int f11294h = -1;

        public static final class Legs extends MessageMicro {
            public static final int DISTANCE_FIELD_NUMBER = 3;
            public static final int DURATION_FIELD_NUMBER = 4;
            public static final int SEND_LOCATION_FIELD_NUMBER = 2;
            public static final int SSTART_LOCATION_FIELD_NUMBER = 1;
            public static final int STEPS_FIELD_NUMBER = 5;
            /* renamed from: a */
            private List<Double> f11279a = Collections.emptyList();
            /* renamed from: b */
            private List<Double> f11280b = Collections.emptyList();
            /* renamed from: c */
            private boolean f11281c;
            /* renamed from: d */
            private int f11282d = 0;
            /* renamed from: e */
            private boolean f11283e;
            /* renamed from: f */
            private int f11284f = 0;
            /* renamed from: g */
            private List<Steps> f11285g = Collections.emptyList();
            /* renamed from: h */
            private int f11286h = -1;

            public static final class Steps extends MessageMicro {
                public static final int BUILDINGID_FIELD_NUMBER = 10;
                public static final int DISTANCE_FIELD_NUMBER = 3;
                public static final int DURATION_FIELD_NUMBER = 4;
                public static final int FLOORID_FIELD_NUMBER = 7;
                public static final int INSTRUCTIONS_FIELD_NUMBER = 5;
                public static final int POIS_FIELD_NUMBER = 9;
                public static final int SEND_LOCATION_FIELD_NUMBER = 2;
                public static final int SPATH_FIELD_NUMBER = 8;
                public static final int SSTART_LOCATION_FIELD_NUMBER = 1;
                public static final int TYPE_FIELD_NUMBER = 6;
                /* renamed from: a */
                private List<Double> f11262a = Collections.emptyList();
                /* renamed from: b */
                private List<Double> f11263b = Collections.emptyList();
                /* renamed from: c */
                private boolean f11264c;
                /* renamed from: d */
                private int f11265d = 0;
                /* renamed from: e */
                private boolean f11266e;
                /* renamed from: f */
                private int f11267f = 0;
                /* renamed from: g */
                private boolean f11268g;
                /* renamed from: h */
                private String f11269h = "";
                /* renamed from: i */
                private boolean f11270i;
                /* renamed from: j */
                private int f11271j = 0;
                /* renamed from: k */
                private boolean f11272k;
                /* renamed from: l */
                private String f11273l = "";
                /* renamed from: m */
                private List<Double> f11274m = Collections.emptyList();
                /* renamed from: n */
                private List<Pois> f11275n = Collections.emptyList();
                /* renamed from: o */
                private boolean f11276o;
                /* renamed from: p */
                private String f11277p = "";
                /* renamed from: q */
                private int f11278q = -1;

                public static final class Pois extends MessageMicro {
                    public static final int DETAIL_FIELD_NUMBER = 4;
                    public static final int LOCATION_FIELD_NUMBER = 3;
                    public static final int NAME_FIELD_NUMBER = 1;
                    public static final int TYPE_FIELD_NUMBER = 2;
                    /* renamed from: a */
                    private boolean f11254a;
                    /* renamed from: b */
                    private String f11255b = "";
                    /* renamed from: c */
                    private boolean f11256c;
                    /* renamed from: d */
                    private int f11257d = 0;
                    /* renamed from: e */
                    private List<Double> f11258e = Collections.emptyList();
                    /* renamed from: f */
                    private boolean f11259f;
                    /* renamed from: g */
                    private String f11260g = "";
                    /* renamed from: h */
                    private int f11261h = -1;

                    public static Pois parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Pois().mergeFrom(codedInputStreamMicro);
                    }

                    public static Pois parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Pois) new Pois().mergeFrom(bArr);
                    }

                    public Pois addLocation(double d) {
                        if (this.f11258e.isEmpty()) {
                            this.f11258e = new ArrayList();
                        }
                        this.f11258e.add(Double.valueOf(d));
                        return this;
                    }

                    public final Pois clear() {
                        clearName();
                        clearType();
                        clearLocation();
                        clearDetail();
                        this.f11261h = -1;
                        return this;
                    }

                    public Pois clearDetail() {
                        this.f11259f = false;
                        this.f11260g = "";
                        return this;
                    }

                    public Pois clearLocation() {
                        this.f11258e = Collections.emptyList();
                        return this;
                    }

                    public Pois clearName() {
                        this.f11254a = false;
                        this.f11255b = "";
                        return this;
                    }

                    public Pois clearType() {
                        this.f11256c = false;
                        this.f11257d = 0;
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f11261h < 0) {
                            getSerializedSize();
                        }
                        return this.f11261h;
                    }

                    public String getDetail() {
                        return this.f11260g;
                    }

                    public double getLocation(int i) {
                        return ((Double) this.f11258e.get(i)).doubleValue();
                    }

                    public int getLocationCount() {
                        return this.f11258e.size();
                    }

                    public List<Double> getLocationList() {
                        return this.f11258e;
                    }

                    public String getName() {
                        return this.f11255b;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasName()) {
                            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
                        }
                        if (hasType()) {
                            i += CodedOutputStreamMicro.computeInt32Size(2, getType());
                        }
                        i = (i + (getLocationList().size() * 8)) + (getLocationList().size() * 1);
                        if (hasDetail()) {
                            i += CodedOutputStreamMicro.computeStringSize(4, getDetail());
                        }
                        this.f11261h = i;
                        return i;
                    }

                    public int getType() {
                        return this.f11257d;
                    }

                    public boolean hasDetail() {
                        return this.f11259f;
                    }

                    public boolean hasName() {
                        return this.f11254a;
                    }

                    public boolean hasType() {
                        return this.f11256c;
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
                                case 16:
                                    setType(codedInputStreamMicro.readInt32());
                                    continue;
                                case 25:
                                    addLocation(codedInputStreamMicro.readDouble());
                                    continue;
                                case 34:
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

                    public Pois setDetail(String str) {
                        this.f11259f = true;
                        this.f11260g = str;
                        return this;
                    }

                    public Pois setLocation(int i, double d) {
                        this.f11258e.set(i, Double.valueOf(d));
                        return this;
                    }

                    public Pois setName(String str) {
                        this.f11254a = true;
                        this.f11255b = str;
                        return this;
                    }

                    public Pois setType(int i) {
                        this.f11256c = true;
                        this.f11257d = i;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasName()) {
                            codedOutputStreamMicro.writeString(1, getName());
                        }
                        if (hasType()) {
                            codedOutputStreamMicro.writeInt32(2, getType());
                        }
                        for (Double doubleValue : getLocationList()) {
                            codedOutputStreamMicro.writeDouble(3, doubleValue.doubleValue());
                        }
                        if (hasDetail()) {
                            codedOutputStreamMicro.writeString(4, getDetail());
                        }
                    }
                }

                public static Steps parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Steps().mergeFrom(codedInputStreamMicro);
                }

                public static Steps parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Steps) new Steps().mergeFrom(bArr);
                }

                public Steps addPois(Pois pois) {
                    if (pois != null) {
                        if (this.f11275n.isEmpty()) {
                            this.f11275n = new ArrayList();
                        }
                        this.f11275n.add(pois);
                    }
                    return this;
                }

                public Steps addSendLocation(double d) {
                    if (this.f11263b.isEmpty()) {
                        this.f11263b = new ArrayList();
                    }
                    this.f11263b.add(Double.valueOf(d));
                    return this;
                }

                public Steps addSpath(double d) {
                    if (this.f11274m.isEmpty()) {
                        this.f11274m = new ArrayList();
                    }
                    this.f11274m.add(Double.valueOf(d));
                    return this;
                }

                public Steps addSstartLocation(double d) {
                    if (this.f11262a.isEmpty()) {
                        this.f11262a = new ArrayList();
                    }
                    this.f11262a.add(Double.valueOf(d));
                    return this;
                }

                public final Steps clear() {
                    clearSstartLocation();
                    clearSendLocation();
                    clearDistance();
                    clearDuration();
                    clearInstructions();
                    clearType();
                    clearFloorid();
                    clearSpath();
                    clearPois();
                    clearBuildingid();
                    this.f11278q = -1;
                    return this;
                }

                public Steps clearBuildingid() {
                    this.f11276o = false;
                    this.f11277p = "";
                    return this;
                }

                public Steps clearDistance() {
                    this.f11264c = false;
                    this.f11265d = 0;
                    return this;
                }

                public Steps clearDuration() {
                    this.f11266e = false;
                    this.f11267f = 0;
                    return this;
                }

                public Steps clearFloorid() {
                    this.f11272k = false;
                    this.f11273l = "";
                    return this;
                }

                public Steps clearInstructions() {
                    this.f11268g = false;
                    this.f11269h = "";
                    return this;
                }

                public Steps clearPois() {
                    this.f11275n = Collections.emptyList();
                    return this;
                }

                public Steps clearSendLocation() {
                    this.f11263b = Collections.emptyList();
                    return this;
                }

                public Steps clearSpath() {
                    this.f11274m = Collections.emptyList();
                    return this;
                }

                public Steps clearSstartLocation() {
                    this.f11262a = Collections.emptyList();
                    return this;
                }

                public Steps clearType() {
                    this.f11270i = false;
                    this.f11271j = 0;
                    return this;
                }

                public String getBuildingid() {
                    return this.f11277p;
                }

                public int getCachedSize() {
                    if (this.f11278q < 0) {
                        getSerializedSize();
                    }
                    return this.f11278q;
                }

                public int getDistance() {
                    return this.f11265d;
                }

                public int getDuration() {
                    return this.f11267f;
                }

                public String getFloorid() {
                    return this.f11273l;
                }

                public String getInstructions() {
                    return this.f11269h;
                }

                public Pois getPois(int i) {
                    return (Pois) this.f11275n.get(i);
                }

                public int getPoisCount() {
                    return this.f11275n.size();
                }

                public List<Pois> getPoisList() {
                    return this.f11275n;
                }

                public double getSendLocation(int i) {
                    return ((Double) this.f11263b.get(i)).doubleValue();
                }

                public int getSendLocationCount() {
                    return this.f11263b.size();
                }

                public List<Double> getSendLocationList() {
                    return this.f11263b;
                }

                public int getSerializedSize() {
                    int size = (((0 + (getSstartLocationList().size() * 8)) + (getSstartLocationList().size() * 1)) + (getSendLocationList().size() * 8)) + (getSendLocationList().size() * 1);
                    if (hasDistance()) {
                        size += CodedOutputStreamMicro.computeInt32Size(3, getDistance());
                    }
                    if (hasDuration()) {
                        size += CodedOutputStreamMicro.computeInt32Size(4, getDuration());
                    }
                    if (hasInstructions()) {
                        size += CodedOutputStreamMicro.computeStringSize(5, getInstructions());
                    }
                    if (hasType()) {
                        size += CodedOutputStreamMicro.computeInt32Size(6, getType());
                    }
                    if (hasFloorid()) {
                        size += CodedOutputStreamMicro.computeStringSize(7, getFloorid());
                    }
                    size = (size + (getSpathList().size() * 8)) + (getSpathList().size() * 1);
                    int i = size;
                    for (Pois computeMessageSize : getPoisList()) {
                        i = CodedOutputStreamMicro.computeMessageSize(9, computeMessageSize) + i;
                    }
                    if (hasBuildingid()) {
                        i += CodedOutputStreamMicro.computeStringSize(10, getBuildingid());
                    }
                    this.f11278q = i;
                    return i;
                }

                public double getSpath(int i) {
                    return ((Double) this.f11274m.get(i)).doubleValue();
                }

                public int getSpathCount() {
                    return this.f11274m.size();
                }

                public List<Double> getSpathList() {
                    return this.f11274m;
                }

                public double getSstartLocation(int i) {
                    return ((Double) this.f11262a.get(i)).doubleValue();
                }

                public int getSstartLocationCount() {
                    return this.f11262a.size();
                }

                public List<Double> getSstartLocationList() {
                    return this.f11262a;
                }

                public int getType() {
                    return this.f11271j;
                }

                public boolean hasBuildingid() {
                    return this.f11276o;
                }

                public boolean hasDistance() {
                    return this.f11264c;
                }

                public boolean hasDuration() {
                    return this.f11266e;
                }

                public boolean hasFloorid() {
                    return this.f11272k;
                }

                public boolean hasInstructions() {
                    return this.f11268g;
                }

                public boolean hasType() {
                    return this.f11270i;
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
                            case 9:
                                addSstartLocation(codedInputStreamMicro.readDouble());
                                continue;
                            case 17:
                                addSendLocation(codedInputStreamMicro.readDouble());
                                continue;
                            case 24:
                                setDistance(codedInputStreamMicro.readInt32());
                                continue;
                            case 32:
                                setDuration(codedInputStreamMicro.readInt32());
                                continue;
                            case 42:
                                setInstructions(codedInputStreamMicro.readString());
                                continue;
                            case 48:
                                setType(codedInputStreamMicro.readInt32());
                                continue;
                            case 58:
                                setFloorid(codedInputStreamMicro.readString());
                                continue;
                            case 65:
                                addSpath(codedInputStreamMicro.readDouble());
                                continue;
                            case 74:
                                MessageMicro pois = new Pois();
                                codedInputStreamMicro.readMessage(pois);
                                addPois(pois);
                                continue;
                            case 82:
                                setBuildingid(codedInputStreamMicro.readString());
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

                public Steps setBuildingid(String str) {
                    this.f11276o = true;
                    this.f11277p = str;
                    return this;
                }

                public Steps setDistance(int i) {
                    this.f11264c = true;
                    this.f11265d = i;
                    return this;
                }

                public Steps setDuration(int i) {
                    this.f11266e = true;
                    this.f11267f = i;
                    return this;
                }

                public Steps setFloorid(String str) {
                    this.f11272k = true;
                    this.f11273l = str;
                    return this;
                }

                public Steps setInstructions(String str) {
                    this.f11268g = true;
                    this.f11269h = str;
                    return this;
                }

                public Steps setPois(int i, Pois pois) {
                    if (pois != null) {
                        this.f11275n.set(i, pois);
                    }
                    return this;
                }

                public Steps setSendLocation(int i, double d) {
                    this.f11263b.set(i, Double.valueOf(d));
                    return this;
                }

                public Steps setSpath(int i, double d) {
                    this.f11274m.set(i, Double.valueOf(d));
                    return this;
                }

                public Steps setSstartLocation(int i, double d) {
                    this.f11262a.set(i, Double.valueOf(d));
                    return this;
                }

                public Steps setType(int i) {
                    this.f11270i = true;
                    this.f11271j = i;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    for (Double doubleValue : getSstartLocationList()) {
                        codedOutputStreamMicro.writeDouble(1, doubleValue.doubleValue());
                    }
                    for (Double doubleValue2 : getSendLocationList()) {
                        codedOutputStreamMicro.writeDouble(2, doubleValue2.doubleValue());
                    }
                    if (hasDistance()) {
                        codedOutputStreamMicro.writeInt32(3, getDistance());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(4, getDuration());
                    }
                    if (hasInstructions()) {
                        codedOutputStreamMicro.writeString(5, getInstructions());
                    }
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(6, getType());
                    }
                    if (hasFloorid()) {
                        codedOutputStreamMicro.writeString(7, getFloorid());
                    }
                    for (Double doubleValue22 : getSpathList()) {
                        codedOutputStreamMicro.writeDouble(8, doubleValue22.doubleValue());
                    }
                    for (Pois writeMessage : getPoisList()) {
                        codedOutputStreamMicro.writeMessage(9, writeMessage);
                    }
                    if (hasBuildingid()) {
                        codedOutputStreamMicro.writeString(10, getBuildingid());
                    }
                }
            }

            public static Legs parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Legs().mergeFrom(codedInputStreamMicro);
            }

            public static Legs parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Legs) new Legs().mergeFrom(bArr);
            }

            public Legs addSendLocation(double d) {
                if (this.f11280b.isEmpty()) {
                    this.f11280b = new ArrayList();
                }
                this.f11280b.add(Double.valueOf(d));
                return this;
            }

            public Legs addSstartLocation(double d) {
                if (this.f11279a.isEmpty()) {
                    this.f11279a = new ArrayList();
                }
                this.f11279a.add(Double.valueOf(d));
                return this;
            }

            public Legs addSteps(Steps steps) {
                if (steps != null) {
                    if (this.f11285g.isEmpty()) {
                        this.f11285g = new ArrayList();
                    }
                    this.f11285g.add(steps);
                }
                return this;
            }

            public final Legs clear() {
                clearSstartLocation();
                clearSendLocation();
                clearDistance();
                clearDuration();
                clearSteps();
                this.f11286h = -1;
                return this;
            }

            public Legs clearDistance() {
                this.f11281c = false;
                this.f11282d = 0;
                return this;
            }

            public Legs clearDuration() {
                this.f11283e = false;
                this.f11284f = 0;
                return this;
            }

            public Legs clearSendLocation() {
                this.f11280b = Collections.emptyList();
                return this;
            }

            public Legs clearSstartLocation() {
                this.f11279a = Collections.emptyList();
                return this;
            }

            public Legs clearSteps() {
                this.f11285g = Collections.emptyList();
                return this;
            }

            public int getCachedSize() {
                if (this.f11286h < 0) {
                    getSerializedSize();
                }
                return this.f11286h;
            }

            public int getDistance() {
                return this.f11282d;
            }

            public int getDuration() {
                return this.f11284f;
            }

            public double getSendLocation(int i) {
                return ((Double) this.f11280b.get(i)).doubleValue();
            }

            public int getSendLocationCount() {
                return this.f11280b.size();
            }

            public List<Double> getSendLocationList() {
                return this.f11280b;
            }

            public int getSerializedSize() {
                int size = (((0 + (getSstartLocationList().size() * 8)) + (getSstartLocationList().size() * 1)) + (getSendLocationList().size() * 8)) + (getSendLocationList().size() * 1);
                if (hasDistance()) {
                    size += CodedOutputStreamMicro.computeInt32Size(3, getDistance());
                }
                if (hasDuration()) {
                    size += CodedOutputStreamMicro.computeInt32Size(4, getDuration());
                }
                int i = size;
                for (Steps computeMessageSize : getStepsList()) {
                    i = CodedOutputStreamMicro.computeMessageSize(5, computeMessageSize) + i;
                }
                this.f11286h = i;
                return i;
            }

            public double getSstartLocation(int i) {
                return ((Double) this.f11279a.get(i)).doubleValue();
            }

            public int getSstartLocationCount() {
                return this.f11279a.size();
            }

            public List<Double> getSstartLocationList() {
                return this.f11279a;
            }

            public Steps getSteps(int i) {
                return (Steps) this.f11285g.get(i);
            }

            public int getStepsCount() {
                return this.f11285g.size();
            }

            public List<Steps> getStepsList() {
                return this.f11285g;
            }

            public boolean hasDistance() {
                return this.f11281c;
            }

            public boolean hasDuration() {
                return this.f11283e;
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
                        case 9:
                            addSstartLocation(codedInputStreamMicro.readDouble());
                            continue;
                        case 17:
                            addSendLocation(codedInputStreamMicro.readDouble());
                            continue;
                        case 24:
                            setDistance(codedInputStreamMicro.readInt32());
                            continue;
                        case 32:
                            setDuration(codedInputStreamMicro.readInt32());
                            continue;
                        case 42:
                            MessageMicro steps = new Steps();
                            codedInputStreamMicro.readMessage(steps);
                            addSteps(steps);
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
                this.f11281c = true;
                this.f11282d = i;
                return this;
            }

            public Legs setDuration(int i) {
                this.f11283e = true;
                this.f11284f = i;
                return this;
            }

            public Legs setSendLocation(int i, double d) {
                this.f11280b.set(i, Double.valueOf(d));
                return this;
            }

            public Legs setSstartLocation(int i, double d) {
                this.f11279a.set(i, Double.valueOf(d));
                return this;
            }

            public Legs setSteps(int i, Steps steps) {
                if (steps != null) {
                    this.f11285g.set(i, steps);
                }
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                for (Double doubleValue : getSstartLocationList()) {
                    codedOutputStreamMicro.writeDouble(1, doubleValue.doubleValue());
                }
                for (Double doubleValue2 : getSendLocationList()) {
                    codedOutputStreamMicro.writeDouble(2, doubleValue2.doubleValue());
                }
                if (hasDistance()) {
                    codedOutputStreamMicro.writeInt32(3, getDistance());
                }
                if (hasDuration()) {
                    codedOutputStreamMicro.writeInt32(4, getDuration());
                }
                for (Steps writeMessage : getStepsList()) {
                    codedOutputStreamMicro.writeMessage(5, writeMessage);
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
                if (this.f11291e.isEmpty()) {
                    this.f11291e = new ArrayList();
                }
                this.f11291e.add(legs);
            }
            return this;
        }

        public final Routes clear() {
            clearDistance();
            clearDuration();
            clearLegs();
            clearLocLevel();
            this.f11294h = -1;
            return this;
        }

        public Routes clearDistance() {
            this.f11287a = false;
            this.f11288b = 0;
            return this;
        }

        public Routes clearDuration() {
            this.f11289c = false;
            this.f11290d = 0;
            return this;
        }

        public Routes clearLegs() {
            this.f11291e = Collections.emptyList();
            return this;
        }

        public Routes clearLocLevel() {
            this.f11292f = false;
            this.f11293g = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f11294h < 0) {
                getSerializedSize();
            }
            return this.f11294h;
        }

        public int getDistance() {
            return this.f11288b;
        }

        public int getDuration() {
            return this.f11290d;
        }

        public Legs getLegs(int i) {
            return (Legs) this.f11291e.get(i);
        }

        public int getLegsCount() {
            return this.f11291e.size();
        }

        public List<Legs> getLegsList() {
            return this.f11291e;
        }

        public int getLocLevel() {
            return this.f11293g;
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
            for (Legs computeMessageSize : getLegsList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
            }
            if (hasLocLevel()) {
                i2 += CodedOutputStreamMicro.computeInt32Size(4, getLocLevel());
            }
            this.f11294h = i2;
            return i2;
        }

        public boolean hasDistance() {
            return this.f11287a;
        }

        public boolean hasDuration() {
            return this.f11289c;
        }

        public boolean hasLocLevel() {
            return this.f11292f;
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
                    case 8:
                        setDistance(codedInputStreamMicro.readInt32());
                        continue;
                    case 16:
                        setDuration(codedInputStreamMicro.readInt32());
                        continue;
                    case 26:
                        MessageMicro legs = new Legs();
                        codedInputStreamMicro.readMessage(legs);
                        addLegs(legs);
                        continue;
                    case 32:
                        setLocLevel(codedInputStreamMicro.readInt32());
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

        public Routes setDistance(int i) {
            this.f11287a = true;
            this.f11288b = i;
            return this;
        }

        public Routes setDuration(int i) {
            this.f11289c = true;
            this.f11290d = i;
            return this;
        }

        public Routes setLegs(int i, Legs legs) {
            if (legs != null) {
                this.f11291e.set(i, legs);
            }
            return this;
        }

        public Routes setLocLevel(int i) {
            this.f11292f = true;
            this.f11293g = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasDistance()) {
                codedOutputStreamMicro.writeInt32(1, getDistance());
            }
            if (hasDuration()) {
                codedOutputStreamMicro.writeInt32(2, getDuration());
            }
            for (Legs writeMessage : getLegsList()) {
                codedOutputStreamMicro.writeMessage(3, writeMessage);
            }
            if (hasLocLevel()) {
                codedOutputStreamMicro.writeInt32(4, getLocLevel());
            }
        }
    }

    public static IndoorNavi parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new IndoorNavi().mergeFrom(codedInputStreamMicro);
    }

    public static IndoorNavi parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (IndoorNavi) new IndoorNavi().mergeFrom(bArr);
    }

    public IndoorNavi addRoutes(Routes routes) {
        if (routes != null) {
            if (this.f11297c.isEmpty()) {
                this.f11297c = new ArrayList();
            }
            this.f11297c.add(routes);
        }
        return this;
    }

    public final IndoorNavi clear() {
        clearOption();
        clearRoutes();
        this.f11298d = -1;
        return this;
    }

    public IndoorNavi clearOption() {
        this.f11295a = false;
        this.f11296b = null;
        return this;
    }

    public IndoorNavi clearRoutes() {
        this.f11297c = Collections.emptyList();
        return this;
    }

    public int getCachedSize() {
        if (this.f11298d < 0) {
            getSerializedSize();
        }
        return this.f11298d;
    }

    public Option getOption() {
        return this.f11296b;
    }

    public Routes getRoutes(int i) {
        return (Routes) this.f11297c.get(i);
    }

    public int getRoutesCount() {
        return this.f11297c.size();
    }

    public List<Routes> getRoutesList() {
        return this.f11297c;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasOption()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
        }
        int i2 = i;
        for (Routes computeMessageSize : getRoutesList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
        }
        this.f11298d = i2;
        return i2;
    }

    public boolean hasOption() {
        return this.f11295a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public IndoorNavi mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                    option = new Routes();
                    codedInputStreamMicro.readMessage(option);
                    addRoutes(option);
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

    public IndoorNavi setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f11295a = true;
        this.f11296b = option;
        return this;
    }

    public IndoorNavi setRoutes(int i, Routes routes) {
        if (routes != null) {
            this.f11297c.set(i, routes);
        }
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(1, getOption());
        }
        for (Routes writeMessage : getRoutesList()) {
            codedOutputStreamMicro.writeMessage(2, writeMessage);
        }
    }
}
