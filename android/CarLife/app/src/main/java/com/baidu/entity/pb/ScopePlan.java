package com.baidu.entity.pb;

import com.baidu.carlife.core.C1253f;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ScopePlan extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 2;
    public static final int OPTION_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f14426a;
    /* renamed from: b */
    private Option f14427b = null;
    /* renamed from: c */
    private boolean f14428c;
    /* renamed from: d */
    private Content f14429d = null;
    /* renamed from: e */
    private int f14430e = -1;

    public static final class Content extends MessageMicro {
        public static final int ROUTES_FIELD_NUMBER = 1;
        /* renamed from: a */
        private List<Routes> f14413a = Collections.emptyList();
        /* renamed from: b */
        private int f14414b = -1;

        public static final class Routes extends MessageMicro {
            public static final int LEGS_FIELD_NUMBER = 1;
            public static final int ROUTE_EXT_FIELD_NUMBER = 3;
            public static final int TAGS_FIELD_NUMBER = 2;
            /* renamed from: a */
            private List<Legs> f14408a = Collections.emptyList();
            /* renamed from: b */
            private List<String> f14409b = Collections.emptyList();
            /* renamed from: c */
            private boolean f14410c;
            /* renamed from: d */
            private String f14411d = "";
            /* renamed from: e */
            private int f14412e = -1;

            public static final class Legs extends MessageMicro {
                public static final int AUDIO_URL_FIELD_NUMBER = 12;
                public static final int COLOR_FIELD_NUMBER = 14;
                public static final int DESCRIPTION_FIELD_NUMBER = 9;
                public static final int DISTANCE_FIELD_NUMBER = 5;
                public static final int DURATION_FIELD_NUMBER = 6;
                public static final int END_LOCATION_FIELD_NUMBER = 2;
                public static final int END_NAME_FIELD_NUMBER = 4;
                public static final int PRIORITY_FIELD_NUMBER = 8;
                public static final int SCENE_EXT_FIELD_NUMBER = 15;
                public static final int SPATH_FIELD_NUMBER = 11;
                public static final int START_LOCATION_FIELD_NUMBER = 1;
                public static final int START_NAME_FIELD_NUMBER = 3;
                public static final int TEXT_FIELD_NUMBER = 13;
                public static final int TYPE_FIELD_NUMBER = 10;
                public static final int UID_FIELD_NUMBER = 7;
                /* renamed from: A */
                private String f14380A = "";
                /* renamed from: B */
                private int f14381B = -1;
                /* renamed from: a */
                private List<Double> f14382a = Collections.emptyList();
                /* renamed from: b */
                private List<Double> f14383b = Collections.emptyList();
                /* renamed from: c */
                private boolean f14384c;
                /* renamed from: d */
                private String f14385d = "";
                /* renamed from: e */
                private boolean f14386e;
                /* renamed from: f */
                private String f14387f = "";
                /* renamed from: g */
                private boolean f14388g;
                /* renamed from: h */
                private int f14389h = 0;
                /* renamed from: i */
                private boolean f14390i;
                /* renamed from: j */
                private int f14391j = 0;
                /* renamed from: k */
                private boolean f14392k;
                /* renamed from: l */
                private String f14393l = "";
                /* renamed from: m */
                private boolean f14394m;
                /* renamed from: n */
                private int f14395n = 0;
                /* renamed from: o */
                private boolean f14396o;
                /* renamed from: p */
                private String f14397p = "";
                /* renamed from: q */
                private boolean f14398q;
                /* renamed from: r */
                private int f14399r = 0;
                /* renamed from: s */
                private List<Double> f14400s = Collections.emptyList();
                /* renamed from: t */
                private boolean f14401t;
                /* renamed from: u */
                private String f14402u = "";
                /* renamed from: v */
                private boolean f14403v;
                /* renamed from: w */
                private String f14404w = "";
                /* renamed from: x */
                private boolean f14405x;
                /* renamed from: y */
                private String f14406y = "";
                /* renamed from: z */
                private boolean f14407z;

                public static Legs parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Legs().mergeFrom(codedInputStreamMicro);
                }

                public static Legs parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Legs) new Legs().mergeFrom(bArr);
                }

                public Legs addEndLocation(double d) {
                    if (this.f14383b.isEmpty()) {
                        this.f14383b = new ArrayList();
                    }
                    this.f14383b.add(Double.valueOf(d));
                    return this;
                }

                public Legs addSpath(double d) {
                    if (this.f14400s.isEmpty()) {
                        this.f14400s = new ArrayList();
                    }
                    this.f14400s.add(Double.valueOf(d));
                    return this;
                }

                public Legs addStartLocation(double d) {
                    if (this.f14382a.isEmpty()) {
                        this.f14382a = new ArrayList();
                    }
                    this.f14382a.add(Double.valueOf(d));
                    return this;
                }

                public final Legs clear() {
                    clearStartLocation();
                    clearEndLocation();
                    clearStartName();
                    clearEndName();
                    clearDistance();
                    clearDuration();
                    clearUid();
                    clearPriority();
                    clearDescription();
                    clearType();
                    clearSpath();
                    clearAudioUrl();
                    clearText();
                    clearColor();
                    clearSceneExt();
                    this.f14381B = -1;
                    return this;
                }

                public Legs clearAudioUrl() {
                    this.f14401t = false;
                    this.f14402u = "";
                    return this;
                }

                public Legs clearColor() {
                    this.f14405x = false;
                    this.f14406y = "";
                    return this;
                }

                public Legs clearDescription() {
                    this.f14396o = false;
                    this.f14397p = "";
                    return this;
                }

                public Legs clearDistance() {
                    this.f14388g = false;
                    this.f14389h = 0;
                    return this;
                }

                public Legs clearDuration() {
                    this.f14390i = false;
                    this.f14391j = 0;
                    return this;
                }

                public Legs clearEndLocation() {
                    this.f14383b = Collections.emptyList();
                    return this;
                }

                public Legs clearEndName() {
                    this.f14386e = false;
                    this.f14387f = "";
                    return this;
                }

                public Legs clearPriority() {
                    this.f14394m = false;
                    this.f14395n = 0;
                    return this;
                }

                public Legs clearSceneExt() {
                    this.f14407z = false;
                    this.f14380A = "";
                    return this;
                }

                public Legs clearSpath() {
                    this.f14400s = Collections.emptyList();
                    return this;
                }

                public Legs clearStartLocation() {
                    this.f14382a = Collections.emptyList();
                    return this;
                }

                public Legs clearStartName() {
                    this.f14384c = false;
                    this.f14385d = "";
                    return this;
                }

                public Legs clearText() {
                    this.f14403v = false;
                    this.f14404w = "";
                    return this;
                }

                public Legs clearType() {
                    this.f14398q = false;
                    this.f14399r = 0;
                    return this;
                }

                public Legs clearUid() {
                    this.f14392k = false;
                    this.f14393l = "";
                    return this;
                }

                public String getAudioUrl() {
                    return this.f14402u;
                }

                public int getCachedSize() {
                    if (this.f14381B < 0) {
                        getSerializedSize();
                    }
                    return this.f14381B;
                }

                public String getColor() {
                    return this.f14406y;
                }

                public String getDescription() {
                    return this.f14397p;
                }

                public int getDistance() {
                    return this.f14389h;
                }

                public int getDuration() {
                    return this.f14391j;
                }

                public double getEndLocation(int i) {
                    return ((Double) this.f14383b.get(i)).doubleValue();
                }

                public int getEndLocationCount() {
                    return this.f14383b.size();
                }

                public List<Double> getEndLocationList() {
                    return this.f14383b;
                }

                public String getEndName() {
                    return this.f14387f;
                }

                public int getPriority() {
                    return this.f14395n;
                }

                public String getSceneExt() {
                    return this.f14380A;
                }

                public int getSerializedSize() {
                    int size = (((0 + (getStartLocationList().size() * 8)) + (getStartLocationList().size() * 1)) + (getEndLocationList().size() * 8)) + (getEndLocationList().size() * 1);
                    if (hasStartName()) {
                        size += CodedOutputStreamMicro.computeStringSize(3, getStartName());
                    }
                    if (hasEndName()) {
                        size += CodedOutputStreamMicro.computeStringSize(4, getEndName());
                    }
                    if (hasDistance()) {
                        size += CodedOutputStreamMicro.computeInt32Size(5, getDistance());
                    }
                    if (hasDuration()) {
                        size += CodedOutputStreamMicro.computeInt32Size(6, getDuration());
                    }
                    if (hasUid()) {
                        size += CodedOutputStreamMicro.computeStringSize(7, getUid());
                    }
                    if (hasPriority()) {
                        size += CodedOutputStreamMicro.computeInt32Size(8, getPriority());
                    }
                    if (hasDescription()) {
                        size += CodedOutputStreamMicro.computeStringSize(9, getDescription());
                    }
                    if (hasType()) {
                        size += CodedOutputStreamMicro.computeInt32Size(10, getType());
                    }
                    size = (size + (getSpathList().size() * 8)) + (getSpathList().size() * 1);
                    if (hasAudioUrl()) {
                        size += CodedOutputStreamMicro.computeStringSize(12, getAudioUrl());
                    }
                    if (hasText()) {
                        size += CodedOutputStreamMicro.computeStringSize(13, getText());
                    }
                    if (hasColor()) {
                        size += CodedOutputStreamMicro.computeStringSize(14, getColor());
                    }
                    if (hasSceneExt()) {
                        size += CodedOutputStreamMicro.computeStringSize(15, getSceneExt());
                    }
                    this.f14381B = size;
                    return size;
                }

                public double getSpath(int i) {
                    return ((Double) this.f14400s.get(i)).doubleValue();
                }

                public int getSpathCount() {
                    return this.f14400s.size();
                }

                public List<Double> getSpathList() {
                    return this.f14400s;
                }

                public double getStartLocation(int i) {
                    return ((Double) this.f14382a.get(i)).doubleValue();
                }

                public int getStartLocationCount() {
                    return this.f14382a.size();
                }

                public List<Double> getStartLocationList() {
                    return this.f14382a;
                }

                public String getStartName() {
                    return this.f14385d;
                }

                public String getText() {
                    return this.f14404w;
                }

                public int getType() {
                    return this.f14399r;
                }

                public String getUid() {
                    return this.f14393l;
                }

                public boolean hasAudioUrl() {
                    return this.f14401t;
                }

                public boolean hasColor() {
                    return this.f14405x;
                }

                public boolean hasDescription() {
                    return this.f14396o;
                }

                public boolean hasDistance() {
                    return this.f14388g;
                }

                public boolean hasDuration() {
                    return this.f14390i;
                }

                public boolean hasEndName() {
                    return this.f14386e;
                }

                public boolean hasPriority() {
                    return this.f14394m;
                }

                public boolean hasSceneExt() {
                    return this.f14407z;
                }

                public boolean hasStartName() {
                    return this.f14384c;
                }

                public boolean hasText() {
                    return this.f14403v;
                }

                public boolean hasType() {
                    return this.f14398q;
                }

                public boolean hasUid() {
                    return this.f14392k;
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
                                addStartLocation(codedInputStreamMicro.readDouble());
                                continue;
                            case 17:
                                addEndLocation(codedInputStreamMicro.readDouble());
                                continue;
                            case 26:
                                setStartName(codedInputStreamMicro.readString());
                                continue;
                            case 34:
                                setEndName(codedInputStreamMicro.readString());
                                continue;
                            case 40:
                                setDistance(codedInputStreamMicro.readInt32());
                                continue;
                            case 48:
                                setDuration(codedInputStreamMicro.readInt32());
                                continue;
                            case 58:
                                setUid(codedInputStreamMicro.readString());
                                continue;
                            case 64:
                                setPriority(codedInputStreamMicro.readInt32());
                                continue;
                            case 74:
                                setDescription(codedInputStreamMicro.readString());
                                continue;
                            case 80:
                                setType(codedInputStreamMicro.readInt32());
                                continue;
                            case 89:
                                addSpath(codedInputStreamMicro.readDouble());
                                continue;
                            case 98:
                                setAudioUrl(codedInputStreamMicro.readString());
                                continue;
                            case 106:
                                setText(codedInputStreamMicro.readString());
                                continue;
                            case 114:
                                setColor(codedInputStreamMicro.readString());
                                continue;
                            case C1253f.df /*122*/:
                                setSceneExt(codedInputStreamMicro.readString());
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

                public Legs setAudioUrl(String str) {
                    this.f14401t = true;
                    this.f14402u = str;
                    return this;
                }

                public Legs setColor(String str) {
                    this.f14405x = true;
                    this.f14406y = str;
                    return this;
                }

                public Legs setDescription(String str) {
                    this.f14396o = true;
                    this.f14397p = str;
                    return this;
                }

                public Legs setDistance(int i) {
                    this.f14388g = true;
                    this.f14389h = i;
                    return this;
                }

                public Legs setDuration(int i) {
                    this.f14390i = true;
                    this.f14391j = i;
                    return this;
                }

                public Legs setEndLocation(int i, double d) {
                    this.f14383b.set(i, Double.valueOf(d));
                    return this;
                }

                public Legs setEndName(String str) {
                    this.f14386e = true;
                    this.f14387f = str;
                    return this;
                }

                public Legs setPriority(int i) {
                    this.f14394m = true;
                    this.f14395n = i;
                    return this;
                }

                public Legs setSceneExt(String str) {
                    this.f14407z = true;
                    this.f14380A = str;
                    return this;
                }

                public Legs setSpath(int i, double d) {
                    this.f14400s.set(i, Double.valueOf(d));
                    return this;
                }

                public Legs setStartLocation(int i, double d) {
                    this.f14382a.set(i, Double.valueOf(d));
                    return this;
                }

                public Legs setStartName(String str) {
                    this.f14384c = true;
                    this.f14385d = str;
                    return this;
                }

                public Legs setText(String str) {
                    this.f14403v = true;
                    this.f14404w = str;
                    return this;
                }

                public Legs setType(int i) {
                    this.f14398q = true;
                    this.f14399r = i;
                    return this;
                }

                public Legs setUid(String str) {
                    this.f14392k = true;
                    this.f14393l = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    for (Double doubleValue : getStartLocationList()) {
                        codedOutputStreamMicro.writeDouble(1, doubleValue.doubleValue());
                    }
                    for (Double doubleValue2 : getEndLocationList()) {
                        codedOutputStreamMicro.writeDouble(2, doubleValue2.doubleValue());
                    }
                    if (hasStartName()) {
                        codedOutputStreamMicro.writeString(3, getStartName());
                    }
                    if (hasEndName()) {
                        codedOutputStreamMicro.writeString(4, getEndName());
                    }
                    if (hasDistance()) {
                        codedOutputStreamMicro.writeInt32(5, getDistance());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(6, getDuration());
                    }
                    if (hasUid()) {
                        codedOutputStreamMicro.writeString(7, getUid());
                    }
                    if (hasPriority()) {
                        codedOutputStreamMicro.writeInt32(8, getPriority());
                    }
                    if (hasDescription()) {
                        codedOutputStreamMicro.writeString(9, getDescription());
                    }
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(10, getType());
                    }
                    for (Double doubleValue22 : getSpathList()) {
                        codedOutputStreamMicro.writeDouble(11, doubleValue22.doubleValue());
                    }
                    if (hasAudioUrl()) {
                        codedOutputStreamMicro.writeString(12, getAudioUrl());
                    }
                    if (hasText()) {
                        codedOutputStreamMicro.writeString(13, getText());
                    }
                    if (hasColor()) {
                        codedOutputStreamMicro.writeString(14, getColor());
                    }
                    if (hasSceneExt()) {
                        codedOutputStreamMicro.writeString(15, getSceneExt());
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
                    if (this.f14408a.isEmpty()) {
                        this.f14408a = new ArrayList();
                    }
                    this.f14408a.add(legs);
                }
                return this;
            }

            public Routes addTags(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                if (this.f14409b.isEmpty()) {
                    this.f14409b = new ArrayList();
                }
                this.f14409b.add(str);
                return this;
            }

            public final Routes clear() {
                clearLegs();
                clearTags();
                clearRouteExt();
                this.f14412e = -1;
                return this;
            }

            public Routes clearLegs() {
                this.f14408a = Collections.emptyList();
                return this;
            }

            public Routes clearRouteExt() {
                this.f14410c = false;
                this.f14411d = "";
                return this;
            }

            public Routes clearTags() {
                this.f14409b = Collections.emptyList();
                return this;
            }

            public int getCachedSize() {
                if (this.f14412e < 0) {
                    getSerializedSize();
                }
                return this.f14412e;
            }

            public Legs getLegs(int i) {
                return (Legs) this.f14408a.get(i);
            }

            public int getLegsCount() {
                return this.f14408a.size();
            }

            public List<Legs> getLegsList() {
                return this.f14408a;
            }

            public String getRouteExt() {
                return this.f14411d;
            }

            public int getSerializedSize() {
                int i = 0;
                int i2 = 0;
                for (Legs computeMessageSize : getLegsList()) {
                    i2 = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i2;
                }
                for (String computeStringSizeNoTag : getTagsList()) {
                    i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag);
                }
                int size = (i2 + i) + (getTagsList().size() * 1);
                if (hasRouteExt()) {
                    size += CodedOutputStreamMicro.computeStringSize(3, getRouteExt());
                }
                this.f14412e = size;
                return size;
            }

            public String getTags(int i) {
                return (String) this.f14409b.get(i);
            }

            public int getTagsCount() {
                return this.f14409b.size();
            }

            public List<String> getTagsList() {
                return this.f14409b;
            }

            public boolean hasRouteExt() {
                return this.f14410c;
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
                        case 18:
                            addTags(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setRouteExt(codedInputStreamMicro.readString());
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
                    this.f14408a.set(i, legs);
                }
                return this;
            }

            public Routes setRouteExt(String str) {
                this.f14410c = true;
                this.f14411d = str;
                return this;
            }

            public Routes setTags(int i, String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f14409b.set(i, str);
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                for (Legs writeMessage : getLegsList()) {
                    codedOutputStreamMicro.writeMessage(1, writeMessage);
                }
                for (String writeString : getTagsList()) {
                    codedOutputStreamMicro.writeString(2, writeString);
                }
                if (hasRouteExt()) {
                    codedOutputStreamMicro.writeString(3, getRouteExt());
                }
            }
        }

        public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Content().mergeFrom(codedInputStreamMicro);
        }

        public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Content) new Content().mergeFrom(bArr);
        }

        public Content addRoutes(Routes routes) {
            if (routes != null) {
                if (this.f14413a.isEmpty()) {
                    this.f14413a = new ArrayList();
                }
                this.f14413a.add(routes);
            }
            return this;
        }

        public final Content clear() {
            clearRoutes();
            this.f14414b = -1;
            return this;
        }

        public Content clearRoutes() {
            this.f14413a = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f14414b < 0) {
                getSerializedSize();
            }
            return this.f14414b;
        }

        public Routes getRoutes(int i) {
            return (Routes) this.f14413a.get(i);
        }

        public int getRoutesCount() {
            return this.f14413a.size();
        }

        public List<Routes> getRoutesList() {
            return this.f14413a;
        }

        public int getSerializedSize() {
            int i = 0;
            for (Routes computeMessageSize : getRoutesList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            this.f14414b = i;
            return i;
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
                    case 10:
                        MessageMicro routes = new Routes();
                        codedInputStreamMicro.readMessage(routes);
                        addRoutes(routes);
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

        public Content setRoutes(int i, Routes routes) {
            if (routes != null) {
                this.f14413a.set(i, routes);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (Routes writeMessage : getRoutesList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
        }
    }

    public static final class Option extends MessageMicro {
        public static final int ERROR_FIELD_NUMBER = 1;
        public static final int PN_FIELD_NUMBER = 3;
        public static final int RN_FIELD_NUMBER = 4;
        public static final int SY_FIELD_NUMBER = 5;
        public static final int TOTAL_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f14415a;
        /* renamed from: b */
        private int f14416b = 0;
        /* renamed from: c */
        private boolean f14417c;
        /* renamed from: d */
        private int f14418d = 0;
        /* renamed from: e */
        private boolean f14419e;
        /* renamed from: f */
        private int f14420f = 0;
        /* renamed from: g */
        private boolean f14421g;
        /* renamed from: h */
        private int f14422h = 0;
        /* renamed from: i */
        private boolean f14423i;
        /* renamed from: j */
        private int f14424j = 0;
        /* renamed from: k */
        private int f14425k = -1;

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }

        public final Option clear() {
            clearError();
            clearTotal();
            clearPn();
            clearRn();
            clearSy();
            this.f14425k = -1;
            return this;
        }

        public Option clearError() {
            this.f14415a = false;
            this.f14416b = 0;
            return this;
        }

        public Option clearPn() {
            this.f14419e = false;
            this.f14420f = 0;
            return this;
        }

        public Option clearRn() {
            this.f14421g = false;
            this.f14422h = 0;
            return this;
        }

        public Option clearSy() {
            this.f14423i = false;
            this.f14424j = 0;
            return this;
        }

        public Option clearTotal() {
            this.f14417c = false;
            this.f14418d = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f14425k < 0) {
                getSerializedSize();
            }
            return this.f14425k;
        }

        public int getError() {
            return this.f14416b;
        }

        public int getPn() {
            return this.f14420f;
        }

        public int getRn() {
            return this.f14422h;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasError()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
            }
            if (hasTotal()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getTotal());
            }
            if (hasPn()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getPn());
            }
            if (hasRn()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, getRn());
            }
            if (hasSy()) {
                i += CodedOutputStreamMicro.computeInt32Size(5, getSy());
            }
            this.f14425k = i;
            return i;
        }

        public int getSy() {
            return this.f14424j;
        }

        public int getTotal() {
            return this.f14418d;
        }

        public boolean hasError() {
            return this.f14415a;
        }

        public boolean hasPn() {
            return this.f14419e;
        }

        public boolean hasRn() {
            return this.f14421g;
        }

        public boolean hasSy() {
            return this.f14423i;
        }

        public boolean hasTotal() {
            return this.f14417c;
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
                        setPn(codedInputStreamMicro.readInt32());
                        continue;
                    case 32:
                        setRn(codedInputStreamMicro.readInt32());
                        continue;
                    case 40:
                        setSy(codedInputStreamMicro.readInt32());
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
            this.f14415a = true;
            this.f14416b = i;
            return this;
        }

        public Option setPn(int i) {
            this.f14419e = true;
            this.f14420f = i;
            return this;
        }

        public Option setRn(int i) {
            this.f14421g = true;
            this.f14422h = i;
            return this;
        }

        public Option setSy(int i) {
            this.f14423i = true;
            this.f14424j = i;
            return this;
        }

        public Option setTotal(int i) {
            this.f14417c = true;
            this.f14418d = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasError()) {
                codedOutputStreamMicro.writeInt32(1, getError());
            }
            if (hasTotal()) {
                codedOutputStreamMicro.writeInt32(2, getTotal());
            }
            if (hasPn()) {
                codedOutputStreamMicro.writeInt32(3, getPn());
            }
            if (hasRn()) {
                codedOutputStreamMicro.writeInt32(4, getRn());
            }
            if (hasSy()) {
                codedOutputStreamMicro.writeInt32(5, getSy());
            }
        }
    }

    public static ScopePlan parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new ScopePlan().mergeFrom(codedInputStreamMicro);
    }

    public static ScopePlan parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (ScopePlan) new ScopePlan().mergeFrom(bArr);
    }

    public final ScopePlan clear() {
        clearOption();
        clearContent();
        this.f14430e = -1;
        return this;
    }

    public ScopePlan clearContent() {
        this.f14428c = false;
        this.f14429d = null;
        return this;
    }

    public ScopePlan clearOption() {
        this.f14426a = false;
        this.f14427b = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f14430e < 0) {
            getSerializedSize();
        }
        return this.f14430e;
    }

    public Content getContent() {
        return this.f14429d;
    }

    public Option getOption() {
        return this.f14427b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasOption()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
        }
        if (hasContent()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getContent());
        }
        this.f14430e = i;
        return i;
    }

    public boolean hasContent() {
        return this.f14428c;
    }

    public boolean hasOption() {
        return this.f14426a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public ScopePlan mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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

    public ScopePlan setContent(Content content) {
        if (content == null) {
            return clearContent();
        }
        this.f14428c = true;
        this.f14429d = content;
        return this;
    }

    public ScopePlan setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f14426a = true;
        this.f14427b = option;
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
