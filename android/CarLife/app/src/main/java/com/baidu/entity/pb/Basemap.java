package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Basemap extends MessageMicro {
    public static final int ELEMENTS_FIELD_NUMBER = 1;
    /* renamed from: a */
    private List<Element> f9619a = Collections.emptyList();
    /* renamed from: b */
    private int f9620b = -1;

    public static final class Element extends MessageMicro {
        public static final int FSTYPE_FIELD_NUMBER = 3;
        public static final int INDEX_FIELD_NUMBER = 4;
        public static final int NSTYLE_FIELD_NUMBER = 2;
        public static final int POINTS_FIELD_NUMBER = 5;
        public static final int TYPE_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f9609a;
        /* renamed from: b */
        private int f9610b = 0;
        /* renamed from: c */
        private boolean f9611c;
        /* renamed from: d */
        private int f9612d = 0;
        /* renamed from: e */
        private boolean f9613e;
        /* renamed from: f */
        private int f9614f = 0;
        /* renamed from: g */
        private boolean f9615g;
        /* renamed from: h */
        private int f9616h = 0;
        /* renamed from: i */
        private List<Point> f9617i = Collections.emptyList();
        /* renamed from: j */
        private int f9618j = -1;

        public static final class Point extends MessageMicro {
            public static final int X_FIELD_NUMBER = 1;
            public static final int Y_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f9604a;
            /* renamed from: b */
            private String f9605b = "";
            /* renamed from: c */
            private boolean f9606c;
            /* renamed from: d */
            private String f9607d = "";
            /* renamed from: e */
            private int f9608e = -1;

            public static Point parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Point().mergeFrom(codedInputStreamMicro);
            }

            public static Point parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Point) new Point().mergeFrom(bArr);
            }

            public final Point clear() {
                clearX();
                clearY();
                this.f9608e = -1;
                return this;
            }

            public Point clearX() {
                this.f9604a = false;
                this.f9605b = "";
                return this;
            }

            public Point clearY() {
                this.f9606c = false;
                this.f9607d = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f9608e < 0) {
                    getSerializedSize();
                }
                return this.f9608e;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasX()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getX());
                }
                if (hasY()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getY());
                }
                this.f9608e = i;
                return i;
            }

            public String getX() {
                return this.f9605b;
            }

            public String getY() {
                return this.f9607d;
            }

            public boolean hasX() {
                return this.f9604a;
            }

            public boolean hasY() {
                return this.f9606c;
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
                            setX(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setY(codedInputStreamMicro.readString());
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

            public Point setX(String str) {
                this.f9604a = true;
                this.f9605b = str;
                return this;
            }

            public Point setY(String str) {
                this.f9606c = true;
                this.f9607d = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasX()) {
                    codedOutputStreamMicro.writeString(1, getX());
                }
                if (hasY()) {
                    codedOutputStreamMicro.writeString(2, getY());
                }
            }
        }

        public static Element parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Element().mergeFrom(codedInputStreamMicro);
        }

        public static Element parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Element) new Element().mergeFrom(bArr);
        }

        public Element addPoints(Point point) {
            if (point != null) {
                if (this.f9617i.isEmpty()) {
                    this.f9617i = new ArrayList();
                }
                this.f9617i.add(point);
            }
            return this;
        }

        public final Element clear() {
            clearType();
            clearNstyle();
            clearFstype();
            clearIndex();
            clearPoints();
            this.f9618j = -1;
            return this;
        }

        public Element clearFstype() {
            this.f9613e = false;
            this.f9614f = 0;
            return this;
        }

        public Element clearIndex() {
            this.f9615g = false;
            this.f9616h = 0;
            return this;
        }

        public Element clearNstyle() {
            this.f9611c = false;
            this.f9612d = 0;
            return this;
        }

        public Element clearPoints() {
            this.f9617i = Collections.emptyList();
            return this;
        }

        public Element clearType() {
            this.f9609a = false;
            this.f9610b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f9618j < 0) {
                getSerializedSize();
            }
            return this.f9618j;
        }

        public int getFstype() {
            return this.f9614f;
        }

        public int getIndex() {
            return this.f9616h;
        }

        public int getNstyle() {
            return this.f9612d;
        }

        public Point getPoints(int i) {
            return (Point) this.f9617i.get(i);
        }

        public int getPointsCount() {
            return this.f9617i.size();
        }

        public List<Point> getPointsList() {
            return this.f9617i;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasType()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getType());
            }
            if (hasNstyle()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getNstyle());
            }
            if (hasFstype()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getFstype());
            }
            if (hasIndex()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, getIndex());
            }
            int i2 = i;
            for (Point computeMessageSize : getPointsList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(5, computeMessageSize) + i2;
            }
            this.f9618j = i2;
            return i2;
        }

        public int getType() {
            return this.f9610b;
        }

        public boolean hasFstype() {
            return this.f9613e;
        }

        public boolean hasIndex() {
            return this.f9615g;
        }

        public boolean hasNstyle() {
            return this.f9611c;
        }

        public boolean hasType() {
            return this.f9609a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Element mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setType(codedInputStreamMicro.readInt32());
                        continue;
                    case 16:
                        setNstyle(codedInputStreamMicro.readInt32());
                        continue;
                    case 24:
                        setFstype(codedInputStreamMicro.readInt32());
                        continue;
                    case 32:
                        setIndex(codedInputStreamMicro.readInt32());
                        continue;
                    case 42:
                        MessageMicro point = new Point();
                        codedInputStreamMicro.readMessage(point);
                        addPoints(point);
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

        public Element setFstype(int i) {
            this.f9613e = true;
            this.f9614f = i;
            return this;
        }

        public Element setIndex(int i) {
            this.f9615g = true;
            this.f9616h = i;
            return this;
        }

        public Element setNstyle(int i) {
            this.f9611c = true;
            this.f9612d = i;
            return this;
        }

        public Element setPoints(int i, Point point) {
            if (point != null) {
                this.f9617i.set(i, point);
            }
            return this;
        }

        public Element setType(int i) {
            this.f9609a = true;
            this.f9610b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasType()) {
                codedOutputStreamMicro.writeInt32(1, getType());
            }
            if (hasNstyle()) {
                codedOutputStreamMicro.writeInt32(2, getNstyle());
            }
            if (hasFstype()) {
                codedOutputStreamMicro.writeInt32(3, getFstype());
            }
            if (hasIndex()) {
                codedOutputStreamMicro.writeInt32(4, getIndex());
            }
            for (Point writeMessage : getPointsList()) {
                codedOutputStreamMicro.writeMessage(5, writeMessage);
            }
        }
    }

    public static Basemap parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Basemap().mergeFrom(codedInputStreamMicro);
    }

    public static Basemap parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Basemap) new Basemap().mergeFrom(bArr);
    }

    public Basemap addElements(Element element) {
        if (element != null) {
            if (this.f9619a.isEmpty()) {
                this.f9619a = new ArrayList();
            }
            this.f9619a.add(element);
        }
        return this;
    }

    public final Basemap clear() {
        clearElements();
        this.f9620b = -1;
        return this;
    }

    public Basemap clearElements() {
        this.f9619a = Collections.emptyList();
        return this;
    }

    public int getCachedSize() {
        if (this.f9620b < 0) {
            getSerializedSize();
        }
        return this.f9620b;
    }

    public Element getElements(int i) {
        return (Element) this.f9619a.get(i);
    }

    public int getElementsCount() {
        return this.f9619a.size();
    }

    public List<Element> getElementsList() {
        return this.f9619a;
    }

    public int getSerializedSize() {
        int i = 0;
        for (Element computeMessageSize : getElementsList()) {
            i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
        }
        this.f9620b = i;
        return i;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Basemap mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    MessageMicro element = new Element();
                    codedInputStreamMicro.readMessage(element);
                    addElements(element);
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

    public Basemap setElements(int i, Element element) {
        if (element != null) {
            this.f9619a.set(i, element);
        }
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (Element writeMessage : getElementsList()) {
            codedOutputStreamMicro.writeMessage(1, writeMessage);
        }
    }
}
