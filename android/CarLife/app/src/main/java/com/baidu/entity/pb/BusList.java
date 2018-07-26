package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BusList extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 3;
    public static final int ERROR_FIELD_NUMBER = 1;
    public static final int OPTION_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f10402a;
    /* renamed from: b */
    private Option f10403b = null;
    /* renamed from: c */
    private List<Content> f10404c = Collections.emptyList();
    /* renamed from: d */
    private boolean f10405d;
    /* renamed from: e */
    private int f10406e = 0;
    /* renamed from: f */
    private int f10407f = -1;

    public static final class Content extends MessageMicro {
        public static final int ENDTIME_FIELD_NUMBER = 6;
        public static final int HAS_RTBUS_FIELD_NUMBER = 10;
        public static final int HEADWAY_FIELD_NUMBER = 13;
        public static final int ISMONTICKET_FIELD_NUMBER = 2;
        public static final int KINDTYPE_FIELD_NUMBER = 4;
        public static final int MAXPRICE_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NEAREST_STATION_FIELD_NUMBER = 12;
        public static final int PRIMARY_UID_FIELD_NUMBER = 9;
        public static final int RTBUS_UPDATE_TIME_FIELD_NUMBER = 11;
        public static final int STARTTIME_FIELD_NUMBER = 5;
        public static final int TICKETPRICE_FIELD_NUMBER = 7;
        public static final int UID_FIELD_NUMBER = 8;
        /* renamed from: A */
        private int f10366A = -1;
        /* renamed from: a */
        private boolean f10367a;
        /* renamed from: b */
        private String f10368b = "";
        /* renamed from: c */
        private boolean f10369c;
        /* renamed from: d */
        private int f10370d = 0;
        /* renamed from: e */
        private boolean f10371e;
        /* renamed from: f */
        private int f10372f = 0;
        /* renamed from: g */
        private boolean f10373g;
        /* renamed from: h */
        private int f10374h = 0;
        /* renamed from: i */
        private boolean f10375i;
        /* renamed from: j */
        private String f10376j = "";
        /* renamed from: k */
        private boolean f10377k;
        /* renamed from: l */
        private String f10378l = "";
        /* renamed from: m */
        private boolean f10379m;
        /* renamed from: n */
        private int f10380n = 0;
        /* renamed from: o */
        private boolean f10381o;
        /* renamed from: p */
        private String f10382p = "";
        /* renamed from: q */
        private boolean f10383q;
        /* renamed from: r */
        private String f10384r = "";
        /* renamed from: s */
        private boolean f10385s;
        /* renamed from: t */
        private int f10386t = 0;
        /* renamed from: u */
        private boolean f10387u;
        /* renamed from: v */
        private int f10388v = 0;
        /* renamed from: w */
        private boolean f10389w;
        /* renamed from: x */
        private NearestStation f10390x = null;
        /* renamed from: y */
        private boolean f10391y;
        /* renamed from: z */
        private String f10392z = "";

        public static final class NearestStation extends MessageMicro {
            public static final int NAME_FIELD_NUMBER = 1;
            public static final int TIP_RTBUS_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f10361a;
            /* renamed from: b */
            private String f10362b = "";
            /* renamed from: c */
            private boolean f10363c;
            /* renamed from: d */
            private String f10364d = "";
            /* renamed from: e */
            private int f10365e = -1;

            public static NearestStation parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new NearestStation().mergeFrom(codedInputStreamMicro);
            }

            public static NearestStation parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (NearestStation) new NearestStation().mergeFrom(bArr);
            }

            public final NearestStation clear() {
                clearName();
                clearTipRtbus();
                this.f10365e = -1;
                return this;
            }

            public NearestStation clearName() {
                this.f10361a = false;
                this.f10362b = "";
                return this;
            }

            public NearestStation clearTipRtbus() {
                this.f10363c = false;
                this.f10364d = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f10365e < 0) {
                    getSerializedSize();
                }
                return this.f10365e;
            }

            public String getName() {
                return this.f10362b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasName()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
                }
                if (hasTipRtbus()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getTipRtbus());
                }
                this.f10365e = i;
                return i;
            }

            public String getTipRtbus() {
                return this.f10364d;
            }

            public boolean hasName() {
                return this.f10361a;
            }

            public boolean hasTipRtbus() {
                return this.f10363c;
            }

            public final boolean isInitialized() {
                return true;
            }

            public NearestStation mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setName(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setTipRtbus(codedInputStreamMicro.readString());
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

            public NearestStation setName(String str) {
                this.f10361a = true;
                this.f10362b = str;
                return this;
            }

            public NearestStation setTipRtbus(String str) {
                this.f10363c = true;
                this.f10364d = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasName()) {
                    codedOutputStreamMicro.writeString(1, getName());
                }
                if (hasTipRtbus()) {
                    codedOutputStreamMicro.writeString(2, getTipRtbus());
                }
            }
        }

        public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Content().mergeFrom(codedInputStreamMicro);
        }

        public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Content) new Content().mergeFrom(bArr);
        }

        public final Content clear() {
            clearName();
            clearIsMonTicket();
            clearMaxPrice();
            clearKindtype();
            clearStartTime();
            clearEndTime();
            clearTicketPrice();
            clearUid();
            clearPrimaryUid();
            clearHasRtbus();
            clearRtbusUpdateTime();
            clearNearestStation();
            clearHeadway();
            this.f10366A = -1;
            return this;
        }

        public Content clearEndTime() {
            this.f10377k = false;
            this.f10378l = "";
            return this;
        }

        public Content clearHasRtbus() {
            this.f10385s = false;
            this.f10386t = 0;
            return this;
        }

        public Content clearHeadway() {
            this.f10391y = false;
            this.f10392z = "";
            return this;
        }

        public Content clearIsMonTicket() {
            this.f10369c = false;
            this.f10370d = 0;
            return this;
        }

        public Content clearKindtype() {
            this.f10373g = false;
            this.f10374h = 0;
            return this;
        }

        public Content clearMaxPrice() {
            this.f10371e = false;
            this.f10372f = 0;
            return this;
        }

        public Content clearName() {
            this.f10367a = false;
            this.f10368b = "";
            return this;
        }

        public Content clearNearestStation() {
            this.f10389w = false;
            this.f10390x = null;
            return this;
        }

        public Content clearPrimaryUid() {
            this.f10383q = false;
            this.f10384r = "";
            return this;
        }

        public Content clearRtbusUpdateTime() {
            this.f10387u = false;
            this.f10388v = 0;
            return this;
        }

        public Content clearStartTime() {
            this.f10375i = false;
            this.f10376j = "";
            return this;
        }

        public Content clearTicketPrice() {
            this.f10379m = false;
            this.f10380n = 0;
            return this;
        }

        public Content clearUid() {
            this.f10381o = false;
            this.f10382p = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f10366A < 0) {
                getSerializedSize();
            }
            return this.f10366A;
        }

        public String getEndTime() {
            return this.f10378l;
        }

        public int getHasRtbus() {
            return this.f10386t;
        }

        public String getHeadway() {
            return this.f10392z;
        }

        public int getIsMonTicket() {
            return this.f10370d;
        }

        public int getKindtype() {
            return this.f10374h;
        }

        public int getMaxPrice() {
            return this.f10372f;
        }

        public String getName() {
            return this.f10368b;
        }

        public NearestStation getNearestStation() {
            return this.f10390x;
        }

        public String getPrimaryUid() {
            return this.f10384r;
        }

        public int getRtbusUpdateTime() {
            return this.f10388v;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasName()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
            }
            if (hasIsMonTicket()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getIsMonTicket());
            }
            if (hasMaxPrice()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getMaxPrice());
            }
            if (hasKindtype()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, getKindtype());
            }
            if (hasStartTime()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getStartTime());
            }
            if (hasEndTime()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getEndTime());
            }
            if (hasTicketPrice()) {
                i += CodedOutputStreamMicro.computeInt32Size(7, getTicketPrice());
            }
            if (hasUid()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getUid());
            }
            if (hasPrimaryUid()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getPrimaryUid());
            }
            if (hasHasRtbus()) {
                i += CodedOutputStreamMicro.computeInt32Size(10, getHasRtbus());
            }
            if (hasRtbusUpdateTime()) {
                i += CodedOutputStreamMicro.computeInt32Size(11, getRtbusUpdateTime());
            }
            if (hasNearestStation()) {
                i += CodedOutputStreamMicro.computeMessageSize(12, getNearestStation());
            }
            if (hasHeadway()) {
                i += CodedOutputStreamMicro.computeStringSize(13, getHeadway());
            }
            this.f10366A = i;
            return i;
        }

        public String getStartTime() {
            return this.f10376j;
        }

        public int getTicketPrice() {
            return this.f10380n;
        }

        public String getUid() {
            return this.f10382p;
        }

        public boolean hasEndTime() {
            return this.f10377k;
        }

        public boolean hasHasRtbus() {
            return this.f10385s;
        }

        public boolean hasHeadway() {
            return this.f10391y;
        }

        public boolean hasIsMonTicket() {
            return this.f10369c;
        }

        public boolean hasKindtype() {
            return this.f10373g;
        }

        public boolean hasMaxPrice() {
            return this.f10371e;
        }

        public boolean hasName() {
            return this.f10367a;
        }

        public boolean hasNearestStation() {
            return this.f10389w;
        }

        public boolean hasPrimaryUid() {
            return this.f10383q;
        }

        public boolean hasRtbusUpdateTime() {
            return this.f10387u;
        }

        public boolean hasStartTime() {
            return this.f10375i;
        }

        public boolean hasTicketPrice() {
            return this.f10379m;
        }

        public boolean hasUid() {
            return this.f10381o;
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
                        setName(codedInputStreamMicro.readString());
                        continue;
                    case 16:
                        setIsMonTicket(codedInputStreamMicro.readInt32());
                        continue;
                    case 24:
                        setMaxPrice(codedInputStreamMicro.readInt32());
                        continue;
                    case 32:
                        setKindtype(codedInputStreamMicro.readInt32());
                        continue;
                    case 42:
                        setStartTime(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setEndTime(codedInputStreamMicro.readString());
                        continue;
                    case 56:
                        setTicketPrice(codedInputStreamMicro.readInt32());
                        continue;
                    case 66:
                        setUid(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setPrimaryUid(codedInputStreamMicro.readString());
                        continue;
                    case 80:
                        setHasRtbus(codedInputStreamMicro.readInt32());
                        continue;
                    case 88:
                        setRtbusUpdateTime(codedInputStreamMicro.readInt32());
                        continue;
                    case 98:
                        MessageMicro nearestStation = new NearestStation();
                        codedInputStreamMicro.readMessage(nearestStation);
                        setNearestStation(nearestStation);
                        continue;
                    case 106:
                        setHeadway(codedInputStreamMicro.readString());
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
            this.f10377k = true;
            this.f10378l = str;
            return this;
        }

        public Content setHasRtbus(int i) {
            this.f10385s = true;
            this.f10386t = i;
            return this;
        }

        public Content setHeadway(String str) {
            this.f10391y = true;
            this.f10392z = str;
            return this;
        }

        public Content setIsMonTicket(int i) {
            this.f10369c = true;
            this.f10370d = i;
            return this;
        }

        public Content setKindtype(int i) {
            this.f10373g = true;
            this.f10374h = i;
            return this;
        }

        public Content setMaxPrice(int i) {
            this.f10371e = true;
            this.f10372f = i;
            return this;
        }

        public Content setName(String str) {
            this.f10367a = true;
            this.f10368b = str;
            return this;
        }

        public Content setNearestStation(NearestStation nearestStation) {
            if (nearestStation == null) {
                return clearNearestStation();
            }
            this.f10389w = true;
            this.f10390x = nearestStation;
            return this;
        }

        public Content setPrimaryUid(String str) {
            this.f10383q = true;
            this.f10384r = str;
            return this;
        }

        public Content setRtbusUpdateTime(int i) {
            this.f10387u = true;
            this.f10388v = i;
            return this;
        }

        public Content setStartTime(String str) {
            this.f10375i = true;
            this.f10376j = str;
            return this;
        }

        public Content setTicketPrice(int i) {
            this.f10379m = true;
            this.f10380n = i;
            return this;
        }

        public Content setUid(String str) {
            this.f10381o = true;
            this.f10382p = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasName()) {
                codedOutputStreamMicro.writeString(1, getName());
            }
            if (hasIsMonTicket()) {
                codedOutputStreamMicro.writeInt32(2, getIsMonTicket());
            }
            if (hasMaxPrice()) {
                codedOutputStreamMicro.writeInt32(3, getMaxPrice());
            }
            if (hasKindtype()) {
                codedOutputStreamMicro.writeInt32(4, getKindtype());
            }
            if (hasStartTime()) {
                codedOutputStreamMicro.writeString(5, getStartTime());
            }
            if (hasEndTime()) {
                codedOutputStreamMicro.writeString(6, getEndTime());
            }
            if (hasTicketPrice()) {
                codedOutputStreamMicro.writeInt32(7, getTicketPrice());
            }
            if (hasUid()) {
                codedOutputStreamMicro.writeString(8, getUid());
            }
            if (hasPrimaryUid()) {
                codedOutputStreamMicro.writeString(9, getPrimaryUid());
            }
            if (hasHasRtbus()) {
                codedOutputStreamMicro.writeInt32(10, getHasRtbus());
            }
            if (hasRtbusUpdateTime()) {
                codedOutputStreamMicro.writeInt32(11, getRtbusUpdateTime());
            }
            if (hasNearestStation()) {
                codedOutputStreamMicro.writeMessage(12, getNearestStation());
            }
            if (hasHeadway()) {
                codedOutputStreamMicro.writeString(13, getHeadway());
            }
        }
    }

    public static final class Option extends MessageMicro {
        public static final int AREAID_FIELD_NUMBER = 4;
        public static final int COUNT_FIELD_NUMBER = 2;
        public static final int TOTAL_BUSLINE_NUM_FIELD_NUMBER = 3;
        public static final int TOTAL_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f10393a;
        /* renamed from: b */
        private int f10394b = 0;
        /* renamed from: c */
        private boolean f10395c;
        /* renamed from: d */
        private int f10396d = 0;
        /* renamed from: e */
        private boolean f10397e;
        /* renamed from: f */
        private int f10398f = 0;
        /* renamed from: g */
        private boolean f10399g;
        /* renamed from: h */
        private int f10400h = 0;
        /* renamed from: i */
        private int f10401i = -1;

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }

        public final Option clear() {
            clearTotal();
            clearCount();
            clearTotalBuslineNum();
            clearAreaID();
            this.f10401i = -1;
            return this;
        }

        public Option clearAreaID() {
            this.f10399g = false;
            this.f10400h = 0;
            return this;
        }

        public Option clearCount() {
            this.f10395c = false;
            this.f10396d = 0;
            return this;
        }

        public Option clearTotal() {
            this.f10393a = false;
            this.f10394b = 0;
            return this;
        }

        public Option clearTotalBuslineNum() {
            this.f10397e = false;
            this.f10398f = 0;
            return this;
        }

        public int getAreaID() {
            return this.f10400h;
        }

        public int getCachedSize() {
            if (this.f10401i < 0) {
                getSerializedSize();
            }
            return this.f10401i;
        }

        public int getCount() {
            return this.f10396d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTotal()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getTotal());
            }
            if (hasCount()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getCount());
            }
            if (hasTotalBuslineNum()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getTotalBuslineNum());
            }
            if (hasAreaID()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, getAreaID());
            }
            this.f10401i = i;
            return i;
        }

        public int getTotal() {
            return this.f10394b;
        }

        public int getTotalBuslineNum() {
            return this.f10398f;
        }

        public boolean hasAreaID() {
            return this.f10399g;
        }

        public boolean hasCount() {
            return this.f10395c;
        }

        public boolean hasTotal() {
            return this.f10393a;
        }

        public boolean hasTotalBuslineNum() {
            return this.f10397e;
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
                        setTotalBuslineNum(codedInputStreamMicro.readInt32());
                        continue;
                    case 32:
                        setAreaID(codedInputStreamMicro.readInt32());
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

        public Option setAreaID(int i) {
            this.f10399g = true;
            this.f10400h = i;
            return this;
        }

        public Option setCount(int i) {
            this.f10395c = true;
            this.f10396d = i;
            return this;
        }

        public Option setTotal(int i) {
            this.f10393a = true;
            this.f10394b = i;
            return this;
        }

        public Option setTotalBuslineNum(int i) {
            this.f10397e = true;
            this.f10398f = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTotal()) {
                codedOutputStreamMicro.writeInt32(1, getTotal());
            }
            if (hasCount()) {
                codedOutputStreamMicro.writeInt32(2, getCount());
            }
            if (hasTotalBuslineNum()) {
                codedOutputStreamMicro.writeInt32(3, getTotalBuslineNum());
            }
            if (hasAreaID()) {
                codedOutputStreamMicro.writeInt32(4, getAreaID());
            }
        }
    }

    public static BusList parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new BusList().mergeFrom(codedInputStreamMicro);
    }

    public static BusList parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (BusList) new BusList().mergeFrom(bArr);
    }

    public BusList addContent(Content content) {
        if (content != null) {
            if (this.f10404c.isEmpty()) {
                this.f10404c = new ArrayList();
            }
            this.f10404c.add(content);
        }
        return this;
    }

    public final BusList clear() {
        clearOption();
        clearContent();
        clearError();
        this.f10407f = -1;
        return this;
    }

    public BusList clearContent() {
        this.f10404c = Collections.emptyList();
        return this;
    }

    public BusList clearError() {
        this.f10405d = false;
        this.f10406e = 0;
        return this;
    }

    public BusList clearOption() {
        this.f10402a = false;
        this.f10403b = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f10407f < 0) {
            getSerializedSize();
        }
        return this.f10407f;
    }

    public Content getContent(int i) {
        return (Content) this.f10404c.get(i);
    }

    public int getContentCount() {
        return this.f10404c.size();
    }

    public List<Content> getContentList() {
        return this.f10404c;
    }

    public int getError() {
        return this.f10406e;
    }

    public Option getOption() {
        return this.f10403b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasError()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
        }
        if (hasOption()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getOption());
        }
        int i2 = i;
        for (Content computeMessageSize : getContentList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
        }
        this.f10407f = i2;
        return i2;
    }

    public boolean hasError() {
        return this.f10405d;
    }

    public boolean hasOption() {
        return this.f10402a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public BusList mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro option;
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    setError(codedInputStreamMicro.readInt32());
                    continue;
                case 18:
                    option = new Option();
                    codedInputStreamMicro.readMessage(option);
                    setOption(option);
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

    public BusList setContent(int i, Content content) {
        if (content != null) {
            this.f10404c.set(i, content);
        }
        return this;
    }

    public BusList setError(int i) {
        this.f10405d = true;
        this.f10406e = i;
        return this;
    }

    public BusList setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f10402a = true;
        this.f10403b = option;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasError()) {
            codedOutputStreamMicro.writeInt32(1, getError());
        }
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(2, getOption());
        }
        for (Content writeMessage : getContentList()) {
            codedOutputStreamMicro.writeMessage(3, writeMessage);
        }
    }
}
