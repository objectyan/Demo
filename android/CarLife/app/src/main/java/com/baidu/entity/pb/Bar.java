package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Bar extends MessageMicro {
    public static final int BLOCKINFOS_FIELD_NUMBER = 2;
    public static final int POIINFOS_FIELD_NUMBER = 3;
    public static final int VERSION_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f9576a;
    /* renamed from: b */
    private String f9577b = "";
    /* renamed from: c */
    private List<Blockinfo> f9578c = Collections.emptyList();
    /* renamed from: d */
    private List<Poiinfo> f9579d = Collections.emptyList();
    /* renamed from: e */
    private int f9580e = -1;

    public static final class Blockinfo extends MessageMicro {
        public static final int BLOCK_ID_FIELD_NUMBER = 1;
        public static final int UIDS_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f9551a;
        /* renamed from: b */
        private String f9552b = "";
        /* renamed from: c */
        private List<String> f9553c = Collections.emptyList();
        /* renamed from: d */
        private int f9554d = -1;

        public static Blockinfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Blockinfo().mergeFrom(codedInputStreamMicro);
        }

        public static Blockinfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Blockinfo) new Blockinfo().mergeFrom(bArr);
        }

        public Blockinfo addUids(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f9553c.isEmpty()) {
                this.f9553c = new ArrayList();
            }
            this.f9553c.add(str);
            return this;
        }

        public final Blockinfo clear() {
            clearBlockId();
            clearUids();
            this.f9554d = -1;
            return this;
        }

        public Blockinfo clearBlockId() {
            this.f9551a = false;
            this.f9552b = "";
            return this;
        }

        public Blockinfo clearUids() {
            this.f9553c = Collections.emptyList();
            return this;
        }

        public String getBlockId() {
            return this.f9552b;
        }

        public int getCachedSize() {
            if (this.f9554d < 0) {
                getSerializedSize();
            }
            return this.f9554d;
        }

        public int getSerializedSize() {
            int i = 0;
            int computeStringSize = hasBlockId() ? CodedOutputStreamMicro.computeStringSize(1, getBlockId()) + 0 : 0;
            for (String computeStringSizeNoTag : getUidsList()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag);
            }
            int size = (computeStringSize + i) + (getUidsList().size() * 1);
            this.f9554d = size;
            return size;
        }

        public String getUids(int i) {
            return (String) this.f9553c.get(i);
        }

        public int getUidsCount() {
            return this.f9553c.size();
        }

        public List<String> getUidsList() {
            return this.f9553c;
        }

        public boolean hasBlockId() {
            return this.f9551a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Blockinfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setBlockId(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        addUids(codedInputStreamMicro.readString());
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

        public Blockinfo setBlockId(String str) {
            this.f9551a = true;
            this.f9552b = str;
            return this;
        }

        public Blockinfo setUids(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f9553c.set(i, str);
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasBlockId()) {
                codedOutputStreamMicro.writeString(1, getBlockId());
            }
            for (String writeString : getUidsList()) {
                codedOutputStreamMicro.writeString(2, writeString);
            }
        }
    }

    public static final class Poiinfo extends MessageMicro {
        public static final int LDOWN_FIELD_NUMBER = 5;
        public static final int LUP_FIELD_NUMBER = 4;
        public static final int POIBARINFO_FIELD_NUMBER = 6;
        public static final int PRIORITY_FIELD_NUMBER = 3;
        public static final int SEARCHBOUND_FIELD_NUMBER = 7;
        public static final int SURFACE_FIELD_NUMBER = 2;
        public static final int UID_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f9562a;
        /* renamed from: b */
        private String f9563b = "";
        /* renamed from: c */
        private List<Surface> f9564c = Collections.emptyList();
        /* renamed from: d */
        private boolean f9565d;
        /* renamed from: e */
        private int f9566e = 0;
        /* renamed from: f */
        private boolean f9567f;
        /* renamed from: g */
        private int f9568g = 0;
        /* renamed from: h */
        private boolean f9569h;
        /* renamed from: i */
        private int f9570i = 0;
        /* renamed from: j */
        private boolean f9571j;
        /* renamed from: k */
        private ByteStringMicro f9572k = ByteStringMicro.EMPTY;
        /* renamed from: l */
        private boolean f9573l;
        /* renamed from: m */
        private String f9574m = "";
        /* renamed from: n */
        private int f9575n = -1;

        public static final class Surface extends MessageMicro {
            public static final int POINT_FIELD_NUMBER = 1;
            /* renamed from: a */
            private List<Point> f9560a = Collections.emptyList();
            /* renamed from: b */
            private int f9561b = -1;

            public static final class Point extends MessageMicro {
                public static final int X_FIELD_NUMBER = 1;
                public static final int Y_FIELD_NUMBER = 2;
                /* renamed from: a */
                private boolean f9555a;
                /* renamed from: b */
                private double f9556b = 0.0d;
                /* renamed from: c */
                private boolean f9557c;
                /* renamed from: d */
                private double f9558d = 0.0d;
                /* renamed from: e */
                private int f9559e = -1;

                public static Point parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Point().mergeFrom(codedInputStreamMicro);
                }

                public static Point parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Point) new Point().mergeFrom(bArr);
                }

                public final Point clear() {
                    clearX();
                    clearY();
                    this.f9559e = -1;
                    return this;
                }

                public Point clearX() {
                    this.f9555a = false;
                    this.f9556b = 0.0d;
                    return this;
                }

                public Point clearY() {
                    this.f9557c = false;
                    this.f9558d = 0.0d;
                    return this;
                }

                public int getCachedSize() {
                    if (this.f9559e < 0) {
                        getSerializedSize();
                    }
                    return this.f9559e;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasX()) {
                        i = 0 + CodedOutputStreamMicro.computeDoubleSize(1, getX());
                    }
                    if (hasY()) {
                        i += CodedOutputStreamMicro.computeDoubleSize(2, getY());
                    }
                    this.f9559e = i;
                    return i;
                }

                public double getX() {
                    return this.f9556b;
                }

                public double getY() {
                    return this.f9558d;
                }

                public boolean hasX() {
                    return this.f9555a;
                }

                public boolean hasY() {
                    return this.f9557c;
                }

                public final boolean isInitialized() {
                    return true;
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
                    this.f9555a = true;
                    this.f9556b = d;
                    return this;
                }

                public Point setY(double d) {
                    this.f9557c = true;
                    this.f9558d = d;
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

            public static Surface parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Surface().mergeFrom(codedInputStreamMicro);
            }

            public static Surface parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Surface) new Surface().mergeFrom(bArr);
            }

            public Surface addPoint(Point point) {
                if (point != null) {
                    if (this.f9560a.isEmpty()) {
                        this.f9560a = new ArrayList();
                    }
                    this.f9560a.add(point);
                }
                return this;
            }

            public final Surface clear() {
                clearPoint();
                this.f9561b = -1;
                return this;
            }

            public Surface clearPoint() {
                this.f9560a = Collections.emptyList();
                return this;
            }

            public int getCachedSize() {
                if (this.f9561b < 0) {
                    getSerializedSize();
                }
                return this.f9561b;
            }

            public Point getPoint(int i) {
                return (Point) this.f9560a.get(i);
            }

            public int getPointCount() {
                return this.f9560a.size();
            }

            public List<Point> getPointList() {
                return this.f9560a;
            }

            public int getSerializedSize() {
                int i = 0;
                for (Point computeMessageSize : getPointList()) {
                    i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
                }
                this.f9561b = i;
                return i;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Surface mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            MessageMicro point = new Point();
                            codedInputStreamMicro.readMessage(point);
                            addPoint(point);
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

            public Surface setPoint(int i, Point point) {
                if (point != null) {
                    this.f9560a.set(i, point);
                }
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                for (Point writeMessage : getPointList()) {
                    codedOutputStreamMicro.writeMessage(1, writeMessage);
                }
            }
        }

        public static Poiinfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Poiinfo().mergeFrom(codedInputStreamMicro);
        }

        public static Poiinfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Poiinfo) new Poiinfo().mergeFrom(bArr);
        }

        public Poiinfo addSurface(Surface surface) {
            if (surface != null) {
                if (this.f9564c.isEmpty()) {
                    this.f9564c = new ArrayList();
                }
                this.f9564c.add(surface);
            }
            return this;
        }

        public final Poiinfo clear() {
            clearUid();
            clearSurface();
            clearPriority();
            clearLup();
            clearLdown();
            clearPoibarinfo();
            clearSearchbound();
            this.f9575n = -1;
            return this;
        }

        public Poiinfo clearLdown() {
            this.f9569h = false;
            this.f9570i = 0;
            return this;
        }

        public Poiinfo clearLup() {
            this.f9567f = false;
            this.f9568g = 0;
            return this;
        }

        public Poiinfo clearPoibarinfo() {
            this.f9571j = false;
            this.f9572k = ByteStringMicro.EMPTY;
            return this;
        }

        public Poiinfo clearPriority() {
            this.f9565d = false;
            this.f9566e = 0;
            return this;
        }

        public Poiinfo clearSearchbound() {
            this.f9573l = false;
            this.f9574m = "";
            return this;
        }

        public Poiinfo clearSurface() {
            this.f9564c = Collections.emptyList();
            return this;
        }

        public Poiinfo clearUid() {
            this.f9562a = false;
            this.f9563b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f9575n < 0) {
                getSerializedSize();
            }
            return this.f9575n;
        }

        public int getLdown() {
            return this.f9570i;
        }

        public int getLup() {
            return this.f9568g;
        }

        public ByteStringMicro getPoibarinfo() {
            return this.f9572k;
        }

        public int getPriority() {
            return this.f9566e;
        }

        public String getSearchbound() {
            return this.f9574m;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasUid()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUid());
            }
            int i2 = i;
            for (Surface computeMessageSize : getSurfaceList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            if (hasPriority()) {
                i2 += CodedOutputStreamMicro.computeInt32Size(3, getPriority());
            }
            if (hasLup()) {
                i2 += CodedOutputStreamMicro.computeInt32Size(4, getLup());
            }
            if (hasLdown()) {
                i2 += CodedOutputStreamMicro.computeInt32Size(5, getLdown());
            }
            if (hasPoibarinfo()) {
                i2 += CodedOutputStreamMicro.computeBytesSize(6, getPoibarinfo());
            }
            if (hasSearchbound()) {
                i2 += CodedOutputStreamMicro.computeStringSize(7, getSearchbound());
            }
            this.f9575n = i2;
            return i2;
        }

        public Surface getSurface(int i) {
            return (Surface) this.f9564c.get(i);
        }

        public int getSurfaceCount() {
            return this.f9564c.size();
        }

        public List<Surface> getSurfaceList() {
            return this.f9564c;
        }

        public String getUid() {
            return this.f9563b;
        }

        public boolean hasLdown() {
            return this.f9569h;
        }

        public boolean hasLup() {
            return this.f9567f;
        }

        public boolean hasPoibarinfo() {
            return this.f9571j;
        }

        public boolean hasPriority() {
            return this.f9565d;
        }

        public boolean hasSearchbound() {
            return this.f9573l;
        }

        public boolean hasUid() {
            return this.f9562a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Poiinfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setUid(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        MessageMicro surface = new Surface();
                        codedInputStreamMicro.readMessage(surface);
                        addSurface(surface);
                        continue;
                    case 24:
                        setPriority(codedInputStreamMicro.readInt32());
                        continue;
                    case 32:
                        setLup(codedInputStreamMicro.readInt32());
                        continue;
                    case 40:
                        setLdown(codedInputStreamMicro.readInt32());
                        continue;
                    case 50:
                        setPoibarinfo(codedInputStreamMicro.readBytes());
                        continue;
                    case 58:
                        setSearchbound(codedInputStreamMicro.readString());
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

        public Poiinfo setLdown(int i) {
            this.f9569h = true;
            this.f9570i = i;
            return this;
        }

        public Poiinfo setLup(int i) {
            this.f9567f = true;
            this.f9568g = i;
            return this;
        }

        public Poiinfo setPoibarinfo(ByteStringMicro byteStringMicro) {
            this.f9571j = true;
            this.f9572k = byteStringMicro;
            return this;
        }

        public Poiinfo setPriority(int i) {
            this.f9565d = true;
            this.f9566e = i;
            return this;
        }

        public Poiinfo setSearchbound(String str) {
            this.f9573l = true;
            this.f9574m = str;
            return this;
        }

        public Poiinfo setSurface(int i, Surface surface) {
            if (surface != null) {
                this.f9564c.set(i, surface);
            }
            return this;
        }

        public Poiinfo setUid(String str) {
            this.f9562a = true;
            this.f9563b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasUid()) {
                codedOutputStreamMicro.writeString(1, getUid());
            }
            for (Surface writeMessage : getSurfaceList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
            if (hasPriority()) {
                codedOutputStreamMicro.writeInt32(3, getPriority());
            }
            if (hasLup()) {
                codedOutputStreamMicro.writeInt32(4, getLup());
            }
            if (hasLdown()) {
                codedOutputStreamMicro.writeInt32(5, getLdown());
            }
            if (hasPoibarinfo()) {
                codedOutputStreamMicro.writeBytes(6, getPoibarinfo());
            }
            if (hasSearchbound()) {
                codedOutputStreamMicro.writeString(7, getSearchbound());
            }
        }
    }

    public static Bar parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Bar().mergeFrom(codedInputStreamMicro);
    }

    public static Bar parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Bar) new Bar().mergeFrom(bArr);
    }

    public Bar addBlockinfos(Blockinfo blockinfo) {
        if (blockinfo != null) {
            if (this.f9578c.isEmpty()) {
                this.f9578c = new ArrayList();
            }
            this.f9578c.add(blockinfo);
        }
        return this;
    }

    public Bar addPoiinfos(Poiinfo poiinfo) {
        if (poiinfo != null) {
            if (this.f9579d.isEmpty()) {
                this.f9579d = new ArrayList();
            }
            this.f9579d.add(poiinfo);
        }
        return this;
    }

    public final Bar clear() {
        clearVersion();
        clearBlockinfos();
        clearPoiinfos();
        this.f9580e = -1;
        return this;
    }

    public Bar clearBlockinfos() {
        this.f9578c = Collections.emptyList();
        return this;
    }

    public Bar clearPoiinfos() {
        this.f9579d = Collections.emptyList();
        return this;
    }

    public Bar clearVersion() {
        this.f9576a = false;
        this.f9577b = "";
        return this;
    }

    public Blockinfo getBlockinfos(int i) {
        return (Blockinfo) this.f9578c.get(i);
    }

    public int getBlockinfosCount() {
        return this.f9578c.size();
    }

    public List<Blockinfo> getBlockinfosList() {
        return this.f9578c;
    }

    public int getCachedSize() {
        if (this.f9580e < 0) {
            getSerializedSize();
        }
        return this.f9580e;
    }

    public Poiinfo getPoiinfos(int i) {
        return (Poiinfo) this.f9579d.get(i);
    }

    public int getPoiinfosCount() {
        return this.f9579d.size();
    }

    public List<Poiinfo> getPoiinfosList() {
        return this.f9579d;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasVersion()) {
            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getVersion());
        }
        int i2 = i;
        for (Blockinfo computeMessageSize : getBlockinfosList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
        }
        for (Poiinfo computeMessageSize2 : getPoiinfosList()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize2);
        }
        this.f9580e = i2;
        return i2;
    }

    public String getVersion() {
        return this.f9577b;
    }

    public boolean hasVersion() {
        return this.f9576a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Bar mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro blockinfo;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    setVersion(codedInputStreamMicro.readString());
                    continue;
                case 18:
                    blockinfo = new Blockinfo();
                    codedInputStreamMicro.readMessage(blockinfo);
                    addBlockinfos(blockinfo);
                    continue;
                case 26:
                    blockinfo = new Poiinfo();
                    codedInputStreamMicro.readMessage(blockinfo);
                    addPoiinfos(blockinfo);
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

    public Bar setBlockinfos(int i, Blockinfo blockinfo) {
        if (blockinfo != null) {
            this.f9578c.set(i, blockinfo);
        }
        return this;
    }

    public Bar setPoiinfos(int i, Poiinfo poiinfo) {
        if (poiinfo != null) {
            this.f9579d.set(i, poiinfo);
        }
        return this;
    }

    public Bar setVersion(String str) {
        this.f9576a = true;
        this.f9577b = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasVersion()) {
            codedOutputStreamMicro.writeString(1, getVersion());
        }
        for (Blockinfo writeMessage : getBlockinfosList()) {
            codedOutputStreamMicro.writeMessage(2, writeMessage);
        }
        for (Poiinfo writeMessage2 : getPoiinfosList()) {
            codedOutputStreamMicro.writeMessage(3, writeMessage2);
        }
    }
}
