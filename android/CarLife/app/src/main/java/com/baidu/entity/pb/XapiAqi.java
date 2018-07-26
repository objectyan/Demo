package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class XapiAqi extends MessageMicro {
    public static final int CONTENTS_FIELD_NUMBER = 1;
    /* renamed from: a */
    private List<Contents> f17199a = Collections.emptyList();
    /* renamed from: b */
    private int f17200b = -1;

    public static final class Contents extends MessageMicro {
        public static final int AQI_FIELD_NUMBER = 4;
        public static final int CID_FIELD_NUMBER = 1;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int POINT_FIELD_NUMBER = 3;
        public static final int POI_LIST_FIELD_NUMBER = 6;
        public static final int UPDATE_TIME_FIELD_NUMBER = 5;
        /* renamed from: a */
        private boolean f17187a;
        /* renamed from: b */
        private Point f17188b = null;
        /* renamed from: c */
        private List<PoiList> f17189c = Collections.emptyList();
        /* renamed from: d */
        private boolean f17190d;
        /* renamed from: e */
        private int f17191e = 0;
        /* renamed from: f */
        private boolean f17192f;
        /* renamed from: g */
        private String f17193g = "";
        /* renamed from: h */
        private boolean f17194h;
        /* renamed from: i */
        private int f17195i = 0;
        /* renamed from: j */
        private boolean f17196j;
        /* renamed from: k */
        private String f17197k = "";
        /* renamed from: l */
        private int f17198l = -1;

        public static final class PoiList extends MessageMicro {
            public static final int AQI_FIELD_NUMBER = 3;
            public static final int NAME_FIELD_NUMBER = 1;
            public static final int POINT_FIELD_NUMBER = 2;
            public static final int UPDATE_TIME_FIELD_NUMBER = 4;
            /* renamed from: a */
            private boolean f17173a;
            /* renamed from: b */
            private Point f17174b = null;
            /* renamed from: c */
            private boolean f17175c;
            /* renamed from: d */
            private String f17176d = "";
            /* renamed from: e */
            private boolean f17177e;
            /* renamed from: f */
            private int f17178f = 0;
            /* renamed from: g */
            private boolean f17179g;
            /* renamed from: h */
            private String f17180h = "";
            /* renamed from: i */
            private int f17181i = -1;

            public static final class Point extends MessageMicro {
                public static final int X_FIELD_NUMBER = 1;
                public static final int Y_FIELD_NUMBER = 2;
                /* renamed from: a */
                private boolean f17168a;
                /* renamed from: b */
                private double f17169b = 0.0d;
                /* renamed from: c */
                private boolean f17170c;
                /* renamed from: d */
                private double f17171d = 0.0d;
                /* renamed from: e */
                private int f17172e = -1;

                public static Point parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Point().mergeFrom(codedInputStreamMicro);
                }

                public static Point parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Point) new Point().mergeFrom(bArr);
                }

                public final Point clear() {
                    clearX();
                    clearY();
                    this.f17172e = -1;
                    return this;
                }

                public Point clearX() {
                    this.f17168a = false;
                    this.f17169b = 0.0d;
                    return this;
                }

                public Point clearY() {
                    this.f17170c = false;
                    this.f17171d = 0.0d;
                    return this;
                }

                public int getCachedSize() {
                    if (this.f17172e < 0) {
                        getSerializedSize();
                    }
                    return this.f17172e;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasX()) {
                        i = 0 + CodedOutputStreamMicro.computeDoubleSize(1, getX());
                    }
                    if (hasY()) {
                        i += CodedOutputStreamMicro.computeDoubleSize(2, getY());
                    }
                    this.f17172e = i;
                    return i;
                }

                public double getX() {
                    return this.f17169b;
                }

                public double getY() {
                    return this.f17171d;
                }

                public boolean hasX() {
                    return this.f17168a;
                }

                public boolean hasY() {
                    return this.f17170c;
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
                    this.f17168a = true;
                    this.f17169b = d;
                    return this;
                }

                public Point setY(double d) {
                    this.f17170c = true;
                    this.f17171d = d;
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

            public static PoiList parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new PoiList().mergeFrom(codedInputStreamMicro);
            }

            public static PoiList parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (PoiList) new PoiList().mergeFrom(bArr);
            }

            public final PoiList clear() {
                clearPoint();
                clearName();
                clearAqi();
                clearUpdateTime();
                this.f17181i = -1;
                return this;
            }

            public PoiList clearAqi() {
                this.f17177e = false;
                this.f17178f = 0;
                return this;
            }

            public PoiList clearName() {
                this.f17175c = false;
                this.f17176d = "";
                return this;
            }

            public PoiList clearPoint() {
                this.f17173a = false;
                this.f17174b = null;
                return this;
            }

            public PoiList clearUpdateTime() {
                this.f17179g = false;
                this.f17180h = "";
                return this;
            }

            public int getAqi() {
                return this.f17178f;
            }

            public int getCachedSize() {
                if (this.f17181i < 0) {
                    getSerializedSize();
                }
                return this.f17181i;
            }

            public String getName() {
                return this.f17176d;
            }

            public Point getPoint() {
                return this.f17174b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasName()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
                }
                if (hasPoint()) {
                    i += CodedOutputStreamMicro.computeMessageSize(2, getPoint());
                }
                if (hasAqi()) {
                    i += CodedOutputStreamMicro.computeInt32Size(3, getAqi());
                }
                if (hasUpdateTime()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getUpdateTime());
                }
                this.f17181i = i;
                return i;
            }

            public String getUpdateTime() {
                return this.f17180h;
            }

            public boolean hasAqi() {
                return this.f17177e;
            }

            public boolean hasName() {
                return this.f17175c;
            }

            public boolean hasPoint() {
                return this.f17173a;
            }

            public boolean hasUpdateTime() {
                return this.f17179g;
            }

            public final boolean isInitialized() {
                return true;
            }

            public PoiList mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setName(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            MessageMicro point = new Point();
                            codedInputStreamMicro.readMessage(point);
                            setPoint(point);
                            continue;
                        case 24:
                            setAqi(codedInputStreamMicro.readInt32());
                            continue;
                        case 34:
                            setUpdateTime(codedInputStreamMicro.readString());
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

            public PoiList setAqi(int i) {
                this.f17177e = true;
                this.f17178f = i;
                return this;
            }

            public PoiList setName(String str) {
                this.f17175c = true;
                this.f17176d = str;
                return this;
            }

            public PoiList setPoint(Point point) {
                if (point == null) {
                    return clearPoint();
                }
                this.f17173a = true;
                this.f17174b = point;
                return this;
            }

            public PoiList setUpdateTime(String str) {
                this.f17179g = true;
                this.f17180h = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasName()) {
                    codedOutputStreamMicro.writeString(1, getName());
                }
                if (hasPoint()) {
                    codedOutputStreamMicro.writeMessage(2, getPoint());
                }
                if (hasAqi()) {
                    codedOutputStreamMicro.writeInt32(3, getAqi());
                }
                if (hasUpdateTime()) {
                    codedOutputStreamMicro.writeString(4, getUpdateTime());
                }
            }
        }

        public static final class Point extends MessageMicro {
            public static final int X_FIELD_NUMBER = 1;
            public static final int Y_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f17182a;
            /* renamed from: b */
            private double f17183b = 0.0d;
            /* renamed from: c */
            private boolean f17184c;
            /* renamed from: d */
            private double f17185d = 0.0d;
            /* renamed from: e */
            private int f17186e = -1;

            public static Point parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Point().mergeFrom(codedInputStreamMicro);
            }

            public static Point parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Point) new Point().mergeFrom(bArr);
            }

            public final Point clear() {
                clearX();
                clearY();
                this.f17186e = -1;
                return this;
            }

            public Point clearX() {
                this.f17182a = false;
                this.f17183b = 0.0d;
                return this;
            }

            public Point clearY() {
                this.f17184c = false;
                this.f17185d = 0.0d;
                return this;
            }

            public int getCachedSize() {
                if (this.f17186e < 0) {
                    getSerializedSize();
                }
                return this.f17186e;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasX()) {
                    i = 0 + CodedOutputStreamMicro.computeDoubleSize(1, getX());
                }
                if (hasY()) {
                    i += CodedOutputStreamMicro.computeDoubleSize(2, getY());
                }
                this.f17186e = i;
                return i;
            }

            public double getX() {
                return this.f17183b;
            }

            public double getY() {
                return this.f17185d;
            }

            public boolean hasX() {
                return this.f17182a;
            }

            public boolean hasY() {
                return this.f17184c;
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
                this.f17182a = true;
                this.f17183b = d;
                return this;
            }

            public Point setY(double d) {
                this.f17184c = true;
                this.f17185d = d;
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

        public static Contents parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Contents().mergeFrom(codedInputStreamMicro);
        }

        public static Contents parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Contents) new Contents().mergeFrom(bArr);
        }

        public Contents addPoiList(PoiList poiList) {
            if (poiList != null) {
                if (this.f17189c.isEmpty()) {
                    this.f17189c = new ArrayList();
                }
                this.f17189c.add(poiList);
            }
            return this;
        }

        public final Contents clear() {
            clearPoint();
            clearPoiList();
            clearCid();
            clearName();
            clearAqi();
            clearUpdateTime();
            this.f17198l = -1;
            return this;
        }

        public Contents clearAqi() {
            this.f17194h = false;
            this.f17195i = 0;
            return this;
        }

        public Contents clearCid() {
            this.f17190d = false;
            this.f17191e = 0;
            return this;
        }

        public Contents clearName() {
            this.f17192f = false;
            this.f17193g = "";
            return this;
        }

        public Contents clearPoiList() {
            this.f17189c = Collections.emptyList();
            return this;
        }

        public Contents clearPoint() {
            this.f17187a = false;
            this.f17188b = null;
            return this;
        }

        public Contents clearUpdateTime() {
            this.f17196j = false;
            this.f17197k = "";
            return this;
        }

        public int getAqi() {
            return this.f17195i;
        }

        public int getCachedSize() {
            if (this.f17198l < 0) {
                getSerializedSize();
            }
            return this.f17198l;
        }

        public int getCid() {
            return this.f17191e;
        }

        public String getName() {
            return this.f17193g;
        }

        public PoiList getPoiList(int i) {
            return (PoiList) this.f17189c.get(i);
        }

        public int getPoiListCount() {
            return this.f17189c.size();
        }

        public List<PoiList> getPoiListList() {
            return this.f17189c;
        }

        public Point getPoint() {
            return this.f17188b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasCid()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCid());
            }
            if (hasName()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getName());
            }
            if (hasPoint()) {
                i += CodedOutputStreamMicro.computeMessageSize(3, getPoint());
            }
            if (hasAqi()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, getAqi());
            }
            if (hasUpdateTime()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getUpdateTime());
            }
            int i2 = i;
            for (PoiList computeMessageSize : getPoiListList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(6, computeMessageSize) + i2;
            }
            this.f17198l = i2;
            return i2;
        }

        public String getUpdateTime() {
            return this.f17197k;
        }

        public boolean hasAqi() {
            return this.f17194h;
        }

        public boolean hasCid() {
            return this.f17190d;
        }

        public boolean hasName() {
            return this.f17192f;
        }

        public boolean hasPoint() {
            return this.f17187a;
        }

        public boolean hasUpdateTime() {
            return this.f17196j;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Contents mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro point;
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setCid(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setName(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        point = new Point();
                        codedInputStreamMicro.readMessage(point);
                        setPoint(point);
                        continue;
                    case 32:
                        setAqi(codedInputStreamMicro.readInt32());
                        continue;
                    case 42:
                        setUpdateTime(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        point = new PoiList();
                        codedInputStreamMicro.readMessage(point);
                        addPoiList(point);
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

        public Contents setAqi(int i) {
            this.f17194h = true;
            this.f17195i = i;
            return this;
        }

        public Contents setCid(int i) {
            this.f17190d = true;
            this.f17191e = i;
            return this;
        }

        public Contents setName(String str) {
            this.f17192f = true;
            this.f17193g = str;
            return this;
        }

        public Contents setPoiList(int i, PoiList poiList) {
            if (poiList != null) {
                this.f17189c.set(i, poiList);
            }
            return this;
        }

        public Contents setPoint(Point point) {
            if (point == null) {
                return clearPoint();
            }
            this.f17187a = true;
            this.f17188b = point;
            return this;
        }

        public Contents setUpdateTime(String str) {
            this.f17196j = true;
            this.f17197k = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasCid()) {
                codedOutputStreamMicro.writeInt32(1, getCid());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(2, getName());
            }
            if (hasPoint()) {
                codedOutputStreamMicro.writeMessage(3, getPoint());
            }
            if (hasAqi()) {
                codedOutputStreamMicro.writeInt32(4, getAqi());
            }
            if (hasUpdateTime()) {
                codedOutputStreamMicro.writeString(5, getUpdateTime());
            }
            for (PoiList writeMessage : getPoiListList()) {
                codedOutputStreamMicro.writeMessage(6, writeMessage);
            }
        }
    }

    public static XapiAqi parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new XapiAqi().mergeFrom(codedInputStreamMicro);
    }

    public static XapiAqi parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (XapiAqi) new XapiAqi().mergeFrom(bArr);
    }

    public XapiAqi addContents(Contents contents) {
        if (contents != null) {
            if (this.f17199a.isEmpty()) {
                this.f17199a = new ArrayList();
            }
            this.f17199a.add(contents);
        }
        return this;
    }

    public final XapiAqi clear() {
        clearContents();
        this.f17200b = -1;
        return this;
    }

    public XapiAqi clearContents() {
        this.f17199a = Collections.emptyList();
        return this;
    }

    public int getCachedSize() {
        if (this.f17200b < 0) {
            getSerializedSize();
        }
        return this.f17200b;
    }

    public Contents getContents(int i) {
        return (Contents) this.f17199a.get(i);
    }

    public int getContentsCount() {
        return this.f17199a.size();
    }

    public List<Contents> getContentsList() {
        return this.f17199a;
    }

    public int getSerializedSize() {
        int i = 0;
        for (Contents computeMessageSize : getContentsList()) {
            i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
        }
        this.f17200b = i;
        return i;
    }

    public final boolean isInitialized() {
        return true;
    }

    public XapiAqi mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    MessageMicro contents = new Contents();
                    codedInputStreamMicro.readMessage(contents);
                    addContents(contents);
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

    public XapiAqi setContents(int i, Contents contents) {
        if (contents != null) {
            this.f17199a.set(i, contents);
        }
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (Contents writeMessage : getContentsList()) {
            codedOutputStreamMicro.writeMessage(1, writeMessage);
        }
    }
}
