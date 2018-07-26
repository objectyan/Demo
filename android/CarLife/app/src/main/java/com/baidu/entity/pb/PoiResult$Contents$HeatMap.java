package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PoiResult$Contents$HeatMap extends MessageMicro {
    public static final int POINTS_FIELD_NUMBER = 2;
    public static final int RANKSTR_FIELD_NUMBER = 1;
    public static final int RANK_FIELD_NUMBER = 4;
    public static final int TYPE_FIELD_NUMBER = 3;
    /* renamed from: a */
    private boolean f13963a;
    /* renamed from: b */
    private Points f13964b = null;
    /* renamed from: c */
    private boolean f13965c;
    /* renamed from: d */
    private String f13966d = "";
    /* renamed from: e */
    private boolean f13967e;
    /* renamed from: f */
    private int f13968f = 0;
    /* renamed from: g */
    private boolean f13969g;
    /* renamed from: h */
    private int f13970h = 0;
    /* renamed from: i */
    private int f13971i = -1;

    /* renamed from: com.baidu.entity.pb.PoiResult$Contents$HeatMap$Points */
    public static final class Points extends MessageMicro {
        public static final int BOUND_FIELD_NUMBER = 1;
        public static final int GEO_ELEMENTS_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 2;
        /* renamed from: a */
        private List<Integer> f13958a = Collections.emptyList();
        /* renamed from: b */
        private boolean f13959b;
        /* renamed from: c */
        private int f13960c = 0;
        /* renamed from: d */
        private List<GeoElements> f13961d = Collections.emptyList();
        /* renamed from: e */
        private int f13962e = -1;

        /* renamed from: com.baidu.entity.pb.PoiResult$Contents$HeatMap$Points$GeoElements */
        public static final class GeoElements extends MessageMicro {
            public static final int POINT_FIELD_NUMBER = 1;
            /* renamed from: a */
            private List<Integer> f13956a = Collections.emptyList();
            /* renamed from: b */
            private int f13957b = -1;

            public static GeoElements parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new GeoElements().mergeFrom(codedInputStreamMicro);
            }

            public static GeoElements parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (GeoElements) new GeoElements().mergeFrom(bArr);
            }

            public GeoElements addPoint(int i) {
                if (this.f13956a.isEmpty()) {
                    this.f13956a = new ArrayList();
                }
                this.f13956a.add(Integer.valueOf(i));
                return this;
            }

            public final GeoElements clear() {
                clearPoint();
                this.f13957b = -1;
                return this;
            }

            public GeoElements clearPoint() {
                this.f13956a = Collections.emptyList();
                return this;
            }

            public int getCachedSize() {
                if (this.f13957b < 0) {
                    getSerializedSize();
                }
                return this.f13957b;
            }

            public int getPoint(int i) {
                return ((Integer) this.f13956a.get(i)).intValue();
            }

            public int getPointCount() {
                return this.f13956a.size();
            }

            public List<Integer> getPointList() {
                return this.f13956a;
            }

            public int getSerializedSize() {
                int i = 0;
                for (Integer intValue : getPointList()) {
                    i = CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue()) + i;
                }
                int size = (0 + i) + (getPointList().size() * 1);
                this.f13957b = size;
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
                this.f13956a.set(i, Integer.valueOf(i2));
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
            if (this.f13958a.isEmpty()) {
                this.f13958a = new ArrayList();
            }
            this.f13958a.add(Integer.valueOf(i));
            return this;
        }

        public Points addGeoElements(GeoElements geoElements) {
            if (geoElements != null) {
                if (this.f13961d.isEmpty()) {
                    this.f13961d = new ArrayList();
                }
                this.f13961d.add(geoElements);
            }
            return this;
        }

        public final Points clear() {
            clearBound();
            clearType();
            clearGeoElements();
            this.f13962e = -1;
            return this;
        }

        public Points clearBound() {
            this.f13958a = Collections.emptyList();
            return this;
        }

        public Points clearGeoElements() {
            this.f13961d = Collections.emptyList();
            return this;
        }

        public Points clearType() {
            this.f13959b = false;
            this.f13960c = 0;
            return this;
        }

        public int getBound(int i) {
            return ((Integer) this.f13958a.get(i)).intValue();
        }

        public int getBoundCount() {
            return this.f13958a.size();
        }

        public List<Integer> getBoundList() {
            return this.f13958a;
        }

        public int getCachedSize() {
            if (this.f13962e < 0) {
                getSerializedSize();
            }
            return this.f13962e;
        }

        public GeoElements getGeoElements(int i) {
            return (GeoElements) this.f13961d.get(i);
        }

        public int getGeoElementsCount() {
            return this.f13961d.size();
        }

        public List<GeoElements> getGeoElementsList() {
            return this.f13961d;
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
            this.f13962e = i;
            return i;
        }

        public int getType() {
            return this.f13960c;
        }

        public boolean hasType() {
            return this.f13959b;
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
            this.f13958a.set(i, Integer.valueOf(i2));
            return this;
        }

        public Points setGeoElements(int i, GeoElements geoElements) {
            if (geoElements != null) {
                this.f13961d.set(i, geoElements);
            }
            return this;
        }

        public Points setType(int i) {
            this.f13959b = true;
            this.f13960c = i;
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

    public static PoiResult$Contents$HeatMap parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new PoiResult$Contents$HeatMap().mergeFrom(codedInputStreamMicro);
    }

    public static PoiResult$Contents$HeatMap parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (PoiResult$Contents$HeatMap) new PoiResult$Contents$HeatMap().mergeFrom(bArr);
    }

    public final PoiResult$Contents$HeatMap clear() {
        clearPoints();
        clearRankstr();
        clearType();
        clearRank();
        this.f13971i = -1;
        return this;
    }

    public PoiResult$Contents$HeatMap clearPoints() {
        this.f13963a = false;
        this.f13964b = null;
        return this;
    }

    public PoiResult$Contents$HeatMap clearRank() {
        this.f13969g = false;
        this.f13970h = 0;
        return this;
    }

    public PoiResult$Contents$HeatMap clearRankstr() {
        this.f13965c = false;
        this.f13966d = "";
        return this;
    }

    public PoiResult$Contents$HeatMap clearType() {
        this.f13967e = false;
        this.f13968f = 0;
        return this;
    }

    public int getCachedSize() {
        if (this.f13971i < 0) {
            getSerializedSize();
        }
        return this.f13971i;
    }

    public Points getPoints() {
        return this.f13964b;
    }

    public int getRank() {
        return this.f13970h;
    }

    public String getRankstr() {
        return this.f13966d;
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
        if (hasRank()) {
            i += CodedOutputStreamMicro.computeInt32Size(4, getRank());
        }
        this.f13971i = i;
        return i;
    }

    public int getType() {
        return this.f13968f;
    }

    public boolean hasPoints() {
        return this.f13963a;
    }

    public boolean hasRank() {
        return this.f13969g;
    }

    public boolean hasRankstr() {
        return this.f13965c;
    }

    public boolean hasType() {
        return this.f13967e;
    }

    public final boolean isInitialized() {
        return true;
    }

    public PoiResult$Contents$HeatMap mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                case 32:
                    setRank(codedInputStreamMicro.readInt32());
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

    public PoiResult$Contents$HeatMap setPoints(Points points) {
        if (points == null) {
            return clearPoints();
        }
        this.f13963a = true;
        this.f13964b = points;
        return this;
    }

    public PoiResult$Contents$HeatMap setRank(int i) {
        this.f13969g = true;
        this.f13970h = i;
        return this;
    }

    public PoiResult$Contents$HeatMap setRankstr(String str) {
        this.f13965c = true;
        this.f13966d = str;
        return this;
    }

    public PoiResult$Contents$HeatMap setType(int i) {
        this.f13967e = true;
        this.f13968f = i;
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
        if (hasRank()) {
            codedOutputStreamMicro.writeInt32(4, getRank());
        }
    }
}
