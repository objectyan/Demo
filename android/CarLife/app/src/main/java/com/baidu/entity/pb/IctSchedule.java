package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class IctSchedule extends MessageMicro {
    public static final int ERROR_FIELD_NUMBER = 1;
    public static final int LINE_INFO_LIST_FIELD_NUMBER = 2;
    public static final int TICKET_ORDER_INFO_FIELD_NUMBER = 3;
    /* renamed from: a */
    private boolean f11241a;
    /* renamed from: b */
    private int f11242b = 0;
    /* renamed from: c */
    private List<LineInfoList> f11243c = Collections.emptyList();
    /* renamed from: d */
    private boolean f11244d;
    /* renamed from: e */
    private TicketOrderInfo f11245e = null;
    /* renamed from: f */
    private int f11246f = -1;

    public static final class LineInfoList extends MessageMicro {
        public static final int LINE_INFO_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f11233a;
        /* renamed from: b */
        private LineInfo f11234b = null;
        /* renamed from: c */
        private int f11235c = -1;

        public static final class LineInfo extends MessageMicro {
            public static final int FROM_TIME_FIELD_NUMBER = 1;
            public static final int GEO_FIELD_NUMBER = 4;
            public static final int MILEAGE_FIELD_NUMBER = 3;
            public static final int PRICE_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f11225a;
            /* renamed from: b */
            private String f11226b = "";
            /* renamed from: c */
            private List<Double> f11227c = Collections.emptyList();
            /* renamed from: d */
            private boolean f11228d;
            /* renamed from: e */
            private int f11229e = 0;
            /* renamed from: f */
            private boolean f11230f;
            /* renamed from: g */
            private String f11231g = "";
            /* renamed from: h */
            private int f11232h = -1;

            public static LineInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new LineInfo().mergeFrom(codedInputStreamMicro);
            }

            public static LineInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (LineInfo) new LineInfo().mergeFrom(bArr);
            }

            public LineInfo addPrice(double d) {
                if (this.f11227c.isEmpty()) {
                    this.f11227c = new ArrayList();
                }
                this.f11227c.add(Double.valueOf(d));
                return this;
            }

            public final LineInfo clear() {
                clearFromTime();
                clearPrice();
                clearMileage();
                clearGeo();
                this.f11232h = -1;
                return this;
            }

            public LineInfo clearFromTime() {
                this.f11225a = false;
                this.f11226b = "";
                return this;
            }

            public LineInfo clearGeo() {
                this.f11230f = false;
                this.f11231g = "";
                return this;
            }

            public LineInfo clearMileage() {
                this.f11228d = false;
                this.f11229e = 0;
                return this;
            }

            public LineInfo clearPrice() {
                this.f11227c = Collections.emptyList();
                return this;
            }

            public int getCachedSize() {
                if (this.f11232h < 0) {
                    getSerializedSize();
                }
                return this.f11232h;
            }

            public String getFromTime() {
                return this.f11226b;
            }

            public String getGeo() {
                return this.f11231g;
            }

            public int getMileage() {
                return this.f11229e;
            }

            public double getPrice(int i) {
                return ((Double) this.f11227c.get(i)).doubleValue();
            }

            public int getPriceCount() {
                return this.f11227c.size();
            }

            public List<Double> getPriceList() {
                return this.f11227c;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasFromTime()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getFromTime());
                }
                i = (i + (getPriceList().size() * 8)) + (getPriceList().size() * 1);
                if (hasMileage()) {
                    i += CodedOutputStreamMicro.computeInt32Size(3, getMileage());
                }
                if (hasGeo()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getGeo());
                }
                this.f11232h = i;
                return i;
            }

            public boolean hasFromTime() {
                return this.f11225a;
            }

            public boolean hasGeo() {
                return this.f11230f;
            }

            public boolean hasMileage() {
                return this.f11228d;
            }

            public final boolean isInitialized() {
                return true;
            }

            public LineInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setFromTime(codedInputStreamMicro.readString());
                            continue;
                        case 17:
                            addPrice(codedInputStreamMicro.readDouble());
                            continue;
                        case 24:
                            setMileage(codedInputStreamMicro.readInt32());
                            continue;
                        case 34:
                            setGeo(codedInputStreamMicro.readString());
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

            public LineInfo setFromTime(String str) {
                this.f11225a = true;
                this.f11226b = str;
                return this;
            }

            public LineInfo setGeo(String str) {
                this.f11230f = true;
                this.f11231g = str;
                return this;
            }

            public LineInfo setMileage(int i) {
                this.f11228d = true;
                this.f11229e = i;
                return this;
            }

            public LineInfo setPrice(int i, double d) {
                this.f11227c.set(i, Double.valueOf(d));
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasFromTime()) {
                    codedOutputStreamMicro.writeString(1, getFromTime());
                }
                for (Double doubleValue : getPriceList()) {
                    codedOutputStreamMicro.writeDouble(2, doubleValue.doubleValue());
                }
                if (hasMileage()) {
                    codedOutputStreamMicro.writeInt32(3, getMileage());
                }
                if (hasGeo()) {
                    codedOutputStreamMicro.writeString(4, getGeo());
                }
            }
        }

        public static LineInfoList parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new LineInfoList().mergeFrom(codedInputStreamMicro);
        }

        public static LineInfoList parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (LineInfoList) new LineInfoList().mergeFrom(bArr);
        }

        public final LineInfoList clear() {
            clearLineInfo();
            this.f11235c = -1;
            return this;
        }

        public LineInfoList clearLineInfo() {
            this.f11233a = false;
            this.f11234b = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f11235c < 0) {
                getSerializedSize();
            }
            return this.f11235c;
        }

        public LineInfo getLineInfo() {
            return this.f11234b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasLineInfo()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getLineInfo());
            }
            this.f11235c = i;
            return i;
        }

        public boolean hasLineInfo() {
            return this.f11233a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public LineInfoList mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        MessageMicro lineInfo = new LineInfo();
                        codedInputStreamMicro.readMessage(lineInfo);
                        setLineInfo(lineInfo);
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

        public LineInfoList setLineInfo(LineInfo lineInfo) {
            if (lineInfo == null) {
                return clearLineInfo();
            }
            this.f11233a = true;
            this.f11234b = lineInfo;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasLineInfo()) {
                codedOutputStreamMicro.writeMessage(1, getLineInfo());
            }
        }
    }

    public static final class TicketOrderInfo extends MessageMicro {
        public static final int IS_SUPPORTED_FIELD_NUMBER = 1;
        public static final int URL_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f11236a;
        /* renamed from: b */
        private int f11237b = 0;
        /* renamed from: c */
        private boolean f11238c;
        /* renamed from: d */
        private String f11239d = "";
        /* renamed from: e */
        private int f11240e = -1;

        public static TicketOrderInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new TicketOrderInfo().mergeFrom(codedInputStreamMicro);
        }

        public static TicketOrderInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (TicketOrderInfo) new TicketOrderInfo().mergeFrom(bArr);
        }

        public final TicketOrderInfo clear() {
            clearIsSupported();
            clearUrl();
            this.f11240e = -1;
            return this;
        }

        public TicketOrderInfo clearIsSupported() {
            this.f11236a = false;
            this.f11237b = 0;
            return this;
        }

        public TicketOrderInfo clearUrl() {
            this.f11238c = false;
            this.f11239d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f11240e < 0) {
                getSerializedSize();
            }
            return this.f11240e;
        }

        public int getIsSupported() {
            return this.f11237b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasIsSupported()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIsSupported());
            }
            if (hasUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getUrl());
            }
            this.f11240e = i;
            return i;
        }

        public String getUrl() {
            return this.f11239d;
        }

        public boolean hasIsSupported() {
            return this.f11236a;
        }

        public boolean hasUrl() {
            return this.f11238c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public TicketOrderInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setIsSupported(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
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

        public TicketOrderInfo setIsSupported(int i) {
            this.f11236a = true;
            this.f11237b = i;
            return this;
        }

        public TicketOrderInfo setUrl(String str) {
            this.f11238c = true;
            this.f11239d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIsSupported()) {
                codedOutputStreamMicro.writeInt32(1, getIsSupported());
            }
            if (hasUrl()) {
                codedOutputStreamMicro.writeString(2, getUrl());
            }
        }
    }

    public static IctSchedule parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new IctSchedule().mergeFrom(codedInputStreamMicro);
    }

    public static IctSchedule parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (IctSchedule) new IctSchedule().mergeFrom(bArr);
    }

    public IctSchedule addLineInfoList(LineInfoList lineInfoList) {
        if (lineInfoList != null) {
            if (this.f11243c.isEmpty()) {
                this.f11243c = new ArrayList();
            }
            this.f11243c.add(lineInfoList);
        }
        return this;
    }

    public final IctSchedule clear() {
        clearError();
        clearLineInfoList();
        clearTicketOrderInfo();
        this.f11246f = -1;
        return this;
    }

    public IctSchedule clearError() {
        this.f11241a = false;
        this.f11242b = 0;
        return this;
    }

    public IctSchedule clearLineInfoList() {
        this.f11243c = Collections.emptyList();
        return this;
    }

    public IctSchedule clearTicketOrderInfo() {
        this.f11244d = false;
        this.f11245e = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f11246f < 0) {
            getSerializedSize();
        }
        return this.f11246f;
    }

    public int getError() {
        return this.f11242b;
    }

    public LineInfoList getLineInfoList(int i) {
        return (LineInfoList) this.f11243c.get(i);
    }

    public int getLineInfoListCount() {
        return this.f11243c.size();
    }

    public List<LineInfoList> getLineInfoListList() {
        return this.f11243c;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasError()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
        }
        int i2 = i;
        for (LineInfoList computeMessageSize : getLineInfoListList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
        }
        if (hasTicketOrderInfo()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(3, getTicketOrderInfo());
        }
        this.f11246f = i2;
        return i2;
    }

    public TicketOrderInfo getTicketOrderInfo() {
        return this.f11245e;
    }

    public boolean hasError() {
        return this.f11241a;
    }

    public boolean hasTicketOrderInfo() {
        return this.f11244d;
    }

    public final boolean isInitialized() {
        return true;
    }

    public IctSchedule mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro lineInfoList;
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    setError(codedInputStreamMicro.readInt32());
                    continue;
                case 18:
                    lineInfoList = new LineInfoList();
                    codedInputStreamMicro.readMessage(lineInfoList);
                    addLineInfoList(lineInfoList);
                    continue;
                case 26:
                    lineInfoList = new TicketOrderInfo();
                    codedInputStreamMicro.readMessage(lineInfoList);
                    setTicketOrderInfo(lineInfoList);
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

    public IctSchedule setError(int i) {
        this.f11241a = true;
        this.f11242b = i;
        return this;
    }

    public IctSchedule setLineInfoList(int i, LineInfoList lineInfoList) {
        if (lineInfoList != null) {
            this.f11243c.set(i, lineInfoList);
        }
        return this;
    }

    public IctSchedule setTicketOrderInfo(TicketOrderInfo ticketOrderInfo) {
        if (ticketOrderInfo == null) {
            return clearTicketOrderInfo();
        }
        this.f11244d = true;
        this.f11245e = ticketOrderInfo;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasError()) {
            codedOutputStreamMicro.writeInt32(1, getError());
        }
        for (LineInfoList writeMessage : getLineInfoListList()) {
            codedOutputStreamMicro.writeMessage(2, writeMessage);
        }
        if (hasTicketOrderInfo()) {
            codedOutputStreamMicro.writeMessage(3, getTicketOrderInfo());
        }
    }
}
