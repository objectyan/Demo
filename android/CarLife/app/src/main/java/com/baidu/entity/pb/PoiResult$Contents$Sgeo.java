package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PoiResult$Contents$Sgeo extends MessageMicro {
    public static final int BOUND_FIELD_NUMBER = 1;
    public static final int GEO_ELEMENTS_FIELD_NUMBER = 3;
    public static final int TYPE_FIELD_NUMBER = 2;
    /* renamed from: a */
    private List<Integer> f13977a = Collections.emptyList();
    /* renamed from: b */
    private boolean f13978b;
    /* renamed from: c */
    private int f13979c = 0;
    /* renamed from: d */
    private List<GeoElements> f13980d = Collections.emptyList();
    /* renamed from: e */
    private int f13981e = -1;

    /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Sgeo$GeoElements */
    public static final class GeoElements extends MessageMicro {
        public static final int POINT_FIELD_NUMBER = 1;
        /* renamed from: a */
        private List<Integer> f13975a = Collections.emptyList();
        /* renamed from: b */
        private int f13976b = -1;

        public static GeoElements parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new GeoElements().mergeFrom(codedInputStreamMicro);
        }

        public static GeoElements parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (GeoElements) new GeoElements().mergeFrom(bArr);
        }

        public GeoElements addPoint(int i) {
            if (this.f13975a.isEmpty()) {
                this.f13975a = new ArrayList();
            }
            this.f13975a.add(Integer.valueOf(i));
            return this;
        }

        public final GeoElements clear() {
            clearPoint();
            this.f13976b = -1;
            return this;
        }

        public GeoElements clearPoint() {
            this.f13975a = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f13976b < 0) {
                getSerializedSize();
            }
            return this.f13976b;
        }

        public int getPoint(int i) {
            return ((Integer) this.f13975a.get(i)).intValue();
        }

        public int getPointCount() {
            return this.f13975a.size();
        }

        public List<Integer> getPointList() {
            return this.f13975a;
        }

        public int getSerializedSize() {
            int i = 0;
            for (Integer intValue : getPointList()) {
                i = CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue()) + i;
            }
            int size = (0 + i) + (getPointList().size() * 1);
            this.f13976b = size;
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
            this.f13975a.set(i, Integer.valueOf(i2));
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (Integer intValue : getPointList()) {
                codedOutputStreamMicro.writeSInt32(1, intValue.intValue());
            }
        }
    }

    public static PoiResult$Contents$Sgeo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new PoiResult$Contents$Sgeo().mergeFrom(codedInputStreamMicro);
    }

    public static PoiResult$Contents$Sgeo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (PoiResult$Contents$Sgeo) new PoiResult$Contents$Sgeo().mergeFrom(bArr);
    }

    public PoiResult$Contents$Sgeo addBound(int i) {
        if (this.f13977a.isEmpty()) {
            this.f13977a = new ArrayList();
        }
        this.f13977a.add(Integer.valueOf(i));
        return this;
    }

    public PoiResult$Contents$Sgeo addGeoElements(GeoElements geoElements) {
        if (geoElements != null) {
            if (this.f13980d.isEmpty()) {
                this.f13980d = new ArrayList();
            }
            this.f13980d.add(geoElements);
        }
        return this;
    }

    public final PoiResult$Contents$Sgeo clear() {
        clearBound();
        clearType();
        clearGeoElements();
        this.f13981e = -1;
        return this;
    }

    public PoiResult$Contents$Sgeo clearBound() {
        this.f13977a = Collections.emptyList();
        return this;
    }

    public PoiResult$Contents$Sgeo clearGeoElements() {
        this.f13980d = Collections.emptyList();
        return this;
    }

    public PoiResult$Contents$Sgeo clearType() {
        this.f13978b = false;
        this.f13979c = 0;
        return this;
    }

    public int getBound(int i) {
        return ((Integer) this.f13977a.get(i)).intValue();
    }

    public int getBoundCount() {
        return this.f13977a.size();
    }

    public List<Integer> getBoundList() {
        return this.f13977a;
    }

    public int getCachedSize() {
        if (this.f13981e < 0) {
            getSerializedSize();
        }
        return this.f13981e;
    }

    public GeoElements getGeoElements(int i) {
        return (GeoElements) this.f13980d.get(i);
    }

    public int getGeoElementsCount() {
        return this.f13980d.size();
    }

    public List<GeoElements> getGeoElementsList() {
        return this.f13980d;
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
        this.f13981e = i;
        return i;
    }

    public int getType() {
        return this.f13979c;
    }

    public boolean hasType() {
        return this.f13978b;
    }

    public final boolean isInitialized() {
        return true;
    }

    public PoiResult$Contents$Sgeo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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

    public PoiResult$Contents$Sgeo setBound(int i, int i2) {
        this.f13977a.set(i, Integer.valueOf(i2));
        return this;
    }

    public PoiResult$Contents$Sgeo setGeoElements(int i, GeoElements geoElements) {
        if (geoElements != null) {
            this.f13980d.set(i, geoElements);
        }
        return this;
    }

    public PoiResult$Contents$Sgeo setType(int i) {
        this.f13978b = true;
        this.f13979c = i;
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
