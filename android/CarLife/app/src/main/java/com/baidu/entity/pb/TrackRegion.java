package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TrackRegion extends MessageMicro {
    public static final int REGION_LIST_FIELD_NUMBER = 1;
    /* renamed from: a */
    private List<Region> f16349a = Collections.emptyList();
    /* renamed from: b */
    private int f16350b = -1;

    public static final class Point extends MessageMicro {
        public static final int DATA_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f16340a;
        /* renamed from: b */
        private String f16341b = "";
        /* renamed from: c */
        private int f16342c = -1;

        public static Point parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Point().mergeFrom(codedInputStreamMicro);
        }

        public static Point parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Point) new Point().mergeFrom(bArr);
        }

        public final Point clear() {
            clearData();
            this.f16342c = -1;
            return this;
        }

        public Point clearData() {
            this.f16340a = false;
            this.f16341b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f16342c < 0) {
                getSerializedSize();
            }
            return this.f16342c;
        }

        public String getData() {
            return this.f16341b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasData()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getData());
            }
            this.f16342c = i;
            return i;
        }

        public boolean hasData() {
            return this.f16340a;
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
                    case 10:
                        setData(codedInputStreamMicro.readString());
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

        public Point setData(String str) {
            this.f16340a = true;
            this.f16341b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasData()) {
                codedOutputStreamMicro.writeString(1, getData());
            }
        }
    }

    public static final class Region extends MessageMicro {
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int REGION_FIELD_NUMBER = 3;
        public static final int UID_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f16343a;
        /* renamed from: b */
        private String f16344b = "";
        /* renamed from: c */
        private boolean f16345c;
        /* renamed from: d */
        private String f16346d = "";
        /* renamed from: e */
        private List<Point> f16347e = Collections.emptyList();
        /* renamed from: f */
        private int f16348f = -1;

        public static Region parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Region().mergeFrom(codedInputStreamMicro);
        }

        public static Region parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Region) new Region().mergeFrom(bArr);
        }

        public Region addRegion(Point point) {
            if (point != null) {
                if (this.f16347e.isEmpty()) {
                    this.f16347e = new ArrayList();
                }
                this.f16347e.add(point);
            }
            return this;
        }

        public final Region clear() {
            clearName();
            clearUid();
            clearRegion();
            this.f16348f = -1;
            return this;
        }

        public Region clearName() {
            this.f16343a = false;
            this.f16344b = "";
            return this;
        }

        public Region clearRegion() {
            this.f16347e = Collections.emptyList();
            return this;
        }

        public Region clearUid() {
            this.f16345c = false;
            this.f16346d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f16348f < 0) {
                getSerializedSize();
            }
            return this.f16348f;
        }

        public String getName() {
            return this.f16344b;
        }

        public Point getRegion(int i) {
            return (Point) this.f16347e.get(i);
        }

        public int getRegionCount() {
            return this.f16347e.size();
        }

        public List<Point> getRegionList() {
            return this.f16347e;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasName()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
            }
            if (hasUid()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getUid());
            }
            int i2 = i;
            for (Point computeMessageSize : getRegionList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
            }
            this.f16348f = i2;
            return i2;
        }

        public String getUid() {
            return this.f16346d;
        }

        public boolean hasName() {
            return this.f16343a;
        }

        public boolean hasUid() {
            return this.f16345c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Region mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                        MessageMicro point = new Point();
                        codedInputStreamMicro.readMessage(point);
                        addRegion(point);
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

        public Region setName(String str) {
            this.f16343a = true;
            this.f16344b = str;
            return this;
        }

        public Region setRegion(int i, Point point) {
            if (point != null) {
                this.f16347e.set(i, point);
            }
            return this;
        }

        public Region setUid(String str) {
            this.f16345c = true;
            this.f16346d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasName()) {
                codedOutputStreamMicro.writeString(1, getName());
            }
            if (hasUid()) {
                codedOutputStreamMicro.writeString(2, getUid());
            }
            for (Point writeMessage : getRegionList()) {
                codedOutputStreamMicro.writeMessage(3, writeMessage);
            }
        }
    }

    public static TrackRegion parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new TrackRegion().mergeFrom(codedInputStreamMicro);
    }

    public static TrackRegion parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (TrackRegion) new TrackRegion().mergeFrom(bArr);
    }

    public TrackRegion addRegionList(Region region) {
        if (region != null) {
            if (this.f16349a.isEmpty()) {
                this.f16349a = new ArrayList();
            }
            this.f16349a.add(region);
        }
        return this;
    }

    public final TrackRegion clear() {
        clearRegionList();
        this.f16350b = -1;
        return this;
    }

    public TrackRegion clearRegionList() {
        this.f16349a = Collections.emptyList();
        return this;
    }

    public int getCachedSize() {
        if (this.f16350b < 0) {
            getSerializedSize();
        }
        return this.f16350b;
    }

    public Region getRegionList(int i) {
        return (Region) this.f16349a.get(i);
    }

    public int getRegionListCount() {
        return this.f16349a.size();
    }

    public List<Region> getRegionListList() {
        return this.f16349a;
    }

    public int getSerializedSize() {
        int i = 0;
        for (Region computeMessageSize : getRegionListList()) {
            i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
        }
        this.f16350b = i;
        return i;
    }

    public final boolean isInitialized() {
        return true;
    }

    public TrackRegion mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    MessageMicro region = new Region();
                    codedInputStreamMicro.readMessage(region);
                    addRegionList(region);
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

    public TrackRegion setRegionList(int i, Region region) {
        if (region != null) {
            this.f16349a.set(i, region);
        }
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (Region writeMessage : getRegionListList()) {
            codedOutputStreamMicro.writeMessage(1, writeMessage);
        }
    }
}
