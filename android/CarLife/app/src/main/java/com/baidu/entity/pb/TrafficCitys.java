package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TrafficCitys extends MessageMicro {
    public static final int CONTENTS_FIELD_NUMBER = 2;
    public static final int CURRENT_CITY_FIELD_NUMBER = 1;
    public static final int SUGGEST_QUERY_FIELD_NUMBER = 3;
    /* renamed from: a */
    private boolean f16407a;
    /* renamed from: b */
    private CurrentCity f16408b = null;
    /* renamed from: c */
    private List<Contents> f16409c = Collections.emptyList();
    /* renamed from: d */
    private List<SuggestQuery> f16410d = Collections.emptyList();
    /* renamed from: e */
    private int f16411e = -1;

    public static final class Contents extends MessageMicro {
        public static final int CODE_FIELD_NUMBER = 1;
        public static final int EXT_INFO_FIELD_NUMBER = 6;
        public static final int NAME_FIELD_NUMBER = 3;
        public static final int NUM_FIELD_NUMBER = 2;
        public static final int POIS_FIELD_NUMBER = 8;
        public static final int POI_NUM_FIELD_NUMBER = 7;
        public static final int SEARCH_QUERY_FIELD_NUMBER = 9;
        public static final int TYPE_FIELD_NUMBER = 4;
        public static final int VIEW_NAME_FIELD_NUMBER = 5;
        /* renamed from: a */
        private boolean f16386a;
        /* renamed from: b */
        private int f16387b = 0;
        /* renamed from: c */
        private boolean f16388c;
        /* renamed from: d */
        private int f16389d = 0;
        /* renamed from: e */
        private boolean f16390e;
        /* renamed from: f */
        private String f16391f = "";
        /* renamed from: g */
        private boolean f16392g;
        /* renamed from: h */
        private int f16393h = 0;
        /* renamed from: i */
        private boolean f16394i;
        /* renamed from: j */
        private String f16395j = "";
        /* renamed from: k */
        private boolean f16396k;
        /* renamed from: l */
        private String f16397l = "";
        /* renamed from: m */
        private boolean f16398m;
        /* renamed from: n */
        private int f16399n = 0;
        /* renamed from: o */
        private List<Pois> f16400o = Collections.emptyList();
        /* renamed from: p */
        private boolean f16401p;
        /* renamed from: q */
        private String f16402q = "";
        /* renamed from: r */
        private int f16403r = -1;

        public static final class Pois extends MessageMicro {
            public static final int ADDR_FIELD_NUMBER = 3;
            public static final int BID_FIELD_NUMBER = 1;
            public static final int NAME_FIELD_NUMBER = 2;
            public static final int POI_QUERY_FIELD_NUMBER = 5;
            public static final int STDTAG_FIELD_NUMBER = 4;
            /* renamed from: a */
            private boolean f16375a;
            /* renamed from: b */
            private String f16376b = "";
            /* renamed from: c */
            private boolean f16377c;
            /* renamed from: d */
            private String f16378d = "";
            /* renamed from: e */
            private boolean f16379e;
            /* renamed from: f */
            private String f16380f = "";
            /* renamed from: g */
            private boolean f16381g;
            /* renamed from: h */
            private String f16382h = "";
            /* renamed from: i */
            private boolean f16383i;
            /* renamed from: j */
            private String f16384j = "";
            /* renamed from: k */
            private int f16385k = -1;

            public static Pois parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Pois().mergeFrom(codedInputStreamMicro);
            }

            public static Pois parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Pois) new Pois().mergeFrom(bArr);
            }

            public final Pois clear() {
                clearBid();
                clearName();
                clearAddr();
                clearStdtag();
                clearPoiQuery();
                this.f16385k = -1;
                return this;
            }

            public Pois clearAddr() {
                this.f16379e = false;
                this.f16380f = "";
                return this;
            }

            public Pois clearBid() {
                this.f16375a = false;
                this.f16376b = "";
                return this;
            }

            public Pois clearName() {
                this.f16377c = false;
                this.f16378d = "";
                return this;
            }

            public Pois clearPoiQuery() {
                this.f16383i = false;
                this.f16384j = "";
                return this;
            }

            public Pois clearStdtag() {
                this.f16381g = false;
                this.f16382h = "";
                return this;
            }

            public String getAddr() {
                return this.f16380f;
            }

            public String getBid() {
                return this.f16376b;
            }

            public int getCachedSize() {
                if (this.f16385k < 0) {
                    getSerializedSize();
                }
                return this.f16385k;
            }

            public String getName() {
                return this.f16378d;
            }

            public String getPoiQuery() {
                return this.f16384j;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasBid()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getBid());
                }
                if (hasName()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getName());
                }
                if (hasAddr()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getAddr());
                }
                if (hasStdtag()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getStdtag());
                }
                if (hasPoiQuery()) {
                    i += CodedOutputStreamMicro.computeStringSize(5, getPoiQuery());
                }
                this.f16385k = i;
                return i;
            }

            public String getStdtag() {
                return this.f16382h;
            }

            public boolean hasAddr() {
                return this.f16379e;
            }

            public boolean hasBid() {
                return this.f16375a;
            }

            public boolean hasName() {
                return this.f16377c;
            }

            public boolean hasPoiQuery() {
                return this.f16383i;
            }

            public boolean hasStdtag() {
                return this.f16381g;
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
                            setBid(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setName(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setAddr(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setStdtag(codedInputStreamMicro.readString());
                            continue;
                        case 42:
                            setPoiQuery(codedInputStreamMicro.readString());
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

            public Pois setAddr(String str) {
                this.f16379e = true;
                this.f16380f = str;
                return this;
            }

            public Pois setBid(String str) {
                this.f16375a = true;
                this.f16376b = str;
                return this;
            }

            public Pois setName(String str) {
                this.f16377c = true;
                this.f16378d = str;
                return this;
            }

            public Pois setPoiQuery(String str) {
                this.f16383i = true;
                this.f16384j = str;
                return this;
            }

            public Pois setStdtag(String str) {
                this.f16381g = true;
                this.f16382h = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasBid()) {
                    codedOutputStreamMicro.writeString(1, getBid());
                }
                if (hasName()) {
                    codedOutputStreamMicro.writeString(2, getName());
                }
                if (hasAddr()) {
                    codedOutputStreamMicro.writeString(3, getAddr());
                }
                if (hasStdtag()) {
                    codedOutputStreamMicro.writeString(4, getStdtag());
                }
                if (hasPoiQuery()) {
                    codedOutputStreamMicro.writeString(5, getPoiQuery());
                }
            }
        }

        public static Contents parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Contents().mergeFrom(codedInputStreamMicro);
        }

        public static Contents parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Contents) new Contents().mergeFrom(bArr);
        }

        public Contents addPois(Pois pois) {
            if (pois != null) {
                if (this.f16400o.isEmpty()) {
                    this.f16400o = new ArrayList();
                }
                this.f16400o.add(pois);
            }
            return this;
        }

        public final Contents clear() {
            clearCode();
            clearNum();
            clearName();
            clearType();
            clearViewName();
            clearExtInfo();
            clearPoiNum();
            clearPois();
            clearSearchQuery();
            this.f16403r = -1;
            return this;
        }

        public Contents clearCode() {
            this.f16386a = false;
            this.f16387b = 0;
            return this;
        }

        public Contents clearExtInfo() {
            this.f16396k = false;
            this.f16397l = "";
            return this;
        }

        public Contents clearName() {
            this.f16390e = false;
            this.f16391f = "";
            return this;
        }

        public Contents clearNum() {
            this.f16388c = false;
            this.f16389d = 0;
            return this;
        }

        public Contents clearPoiNum() {
            this.f16398m = false;
            this.f16399n = 0;
            return this;
        }

        public Contents clearPois() {
            this.f16400o = Collections.emptyList();
            return this;
        }

        public Contents clearSearchQuery() {
            this.f16401p = false;
            this.f16402q = "";
            return this;
        }

        public Contents clearType() {
            this.f16392g = false;
            this.f16393h = 0;
            return this;
        }

        public Contents clearViewName() {
            this.f16394i = false;
            this.f16395j = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f16403r < 0) {
                getSerializedSize();
            }
            return this.f16403r;
        }

        public int getCode() {
            return this.f16387b;
        }

        public String getExtInfo() {
            return this.f16397l;
        }

        public String getName() {
            return this.f16391f;
        }

        public int getNum() {
            return this.f16389d;
        }

        public int getPoiNum() {
            return this.f16399n;
        }

        public Pois getPois(int i) {
            return (Pois) this.f16400o.get(i);
        }

        public int getPoisCount() {
            return this.f16400o.size();
        }

        public List<Pois> getPoisList() {
            return this.f16400o;
        }

        public String getSearchQuery() {
            return this.f16402q;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasCode()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
            }
            if (hasNum()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getNum());
            }
            if (hasName()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getName());
            }
            if (hasType()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, getType());
            }
            if (hasViewName()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getViewName());
            }
            if (hasExtInfo()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getExtInfo());
            }
            if (hasPoiNum()) {
                i += CodedOutputStreamMicro.computeInt32Size(7, getPoiNum());
            }
            int i2 = i;
            for (Pois computeMessageSize : getPoisList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(8, computeMessageSize) + i2;
            }
            if (hasSearchQuery()) {
                i2 += CodedOutputStreamMicro.computeStringSize(9, getSearchQuery());
            }
            this.f16403r = i2;
            return i2;
        }

        public int getType() {
            return this.f16393h;
        }

        public String getViewName() {
            return this.f16395j;
        }

        public boolean hasCode() {
            return this.f16386a;
        }

        public boolean hasExtInfo() {
            return this.f16396k;
        }

        public boolean hasName() {
            return this.f16390e;
        }

        public boolean hasNum() {
            return this.f16388c;
        }

        public boolean hasPoiNum() {
            return this.f16398m;
        }

        public boolean hasSearchQuery() {
            return this.f16401p;
        }

        public boolean hasType() {
            return this.f16392g;
        }

        public boolean hasViewName() {
            return this.f16394i;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Contents mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setCode(codedInputStreamMicro.readInt32());
                        continue;
                    case 16:
                        setNum(codedInputStreamMicro.readInt32());
                        continue;
                    case 26:
                        setName(codedInputStreamMicro.readString());
                        continue;
                    case 32:
                        setType(codedInputStreamMicro.readInt32());
                        continue;
                    case 42:
                        setViewName(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setExtInfo(codedInputStreamMicro.readString());
                        continue;
                    case 56:
                        setPoiNum(codedInputStreamMicro.readInt32());
                        continue;
                    case 66:
                        MessageMicro pois = new Pois();
                        codedInputStreamMicro.readMessage(pois);
                        addPois(pois);
                        continue;
                    case 74:
                        setSearchQuery(codedInputStreamMicro.readString());
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

        public Contents setCode(int i) {
            this.f16386a = true;
            this.f16387b = i;
            return this;
        }

        public Contents setExtInfo(String str) {
            this.f16396k = true;
            this.f16397l = str;
            return this;
        }

        public Contents setName(String str) {
            this.f16390e = true;
            this.f16391f = str;
            return this;
        }

        public Contents setNum(int i) {
            this.f16388c = true;
            this.f16389d = i;
            return this;
        }

        public Contents setPoiNum(int i) {
            this.f16398m = true;
            this.f16399n = i;
            return this;
        }

        public Contents setPois(int i, Pois pois) {
            if (pois != null) {
                this.f16400o.set(i, pois);
            }
            return this;
        }

        public Contents setSearchQuery(String str) {
            this.f16401p = true;
            this.f16402q = str;
            return this;
        }

        public Contents setType(int i) {
            this.f16392g = true;
            this.f16393h = i;
            return this;
        }

        public Contents setViewName(String str) {
            this.f16394i = true;
            this.f16395j = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasCode()) {
                codedOutputStreamMicro.writeInt32(1, getCode());
            }
            if (hasNum()) {
                codedOutputStreamMicro.writeInt32(2, getNum());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(3, getName());
            }
            if (hasType()) {
                codedOutputStreamMicro.writeInt32(4, getType());
            }
            if (hasViewName()) {
                codedOutputStreamMicro.writeString(5, getViewName());
            }
            if (hasExtInfo()) {
                codedOutputStreamMicro.writeString(6, getExtInfo());
            }
            if (hasPoiNum()) {
                codedOutputStreamMicro.writeInt32(7, getPoiNum());
            }
            for (Pois writeMessage : getPoisList()) {
                codedOutputStreamMicro.writeMessage(8, writeMessage);
            }
            if (hasSearchQuery()) {
                codedOutputStreamMicro.writeString(9, getSearchQuery());
            }
        }
    }

    public static final class SuggestQuery extends MessageMicro {
        public static final int QUERY_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f16404a;
        /* renamed from: b */
        private String f16405b = "";
        /* renamed from: c */
        private int f16406c = -1;

        public static SuggestQuery parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new SuggestQuery().mergeFrom(codedInputStreamMicro);
        }

        public static SuggestQuery parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (SuggestQuery) new SuggestQuery().mergeFrom(bArr);
        }

        public final SuggestQuery clear() {
            clearQuery();
            this.f16406c = -1;
            return this;
        }

        public SuggestQuery clearQuery() {
            this.f16404a = false;
            this.f16405b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f16406c < 0) {
                getSerializedSize();
            }
            return this.f16406c;
        }

        public String getQuery() {
            return this.f16405b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasQuery()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getQuery());
            }
            this.f16406c = i;
            return i;
        }

        public boolean hasQuery() {
            return this.f16404a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public SuggestQuery mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setQuery(codedInputStreamMicro.readString());
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

        public SuggestQuery setQuery(String str) {
            this.f16404a = true;
            this.f16405b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasQuery()) {
                codedOutputStreamMicro.writeString(1, getQuery());
            }
        }
    }

    public static TrafficCitys parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new TrafficCitys().mergeFrom(codedInputStreamMicro);
    }

    public static TrafficCitys parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (TrafficCitys) new TrafficCitys().mergeFrom(bArr);
    }

    public TrafficCitys addContents(Contents contents) {
        if (contents != null) {
            if (this.f16409c.isEmpty()) {
                this.f16409c = new ArrayList();
            }
            this.f16409c.add(contents);
        }
        return this;
    }

    public TrafficCitys addSuggestQuery(SuggestQuery suggestQuery) {
        if (suggestQuery != null) {
            if (this.f16410d.isEmpty()) {
                this.f16410d = new ArrayList();
            }
            this.f16410d.add(suggestQuery);
        }
        return this;
    }

    public final TrafficCitys clear() {
        clearCurrentCity();
        clearContents();
        clearSuggestQuery();
        this.f16411e = -1;
        return this;
    }

    public TrafficCitys clearContents() {
        this.f16409c = Collections.emptyList();
        return this;
    }

    public TrafficCitys clearCurrentCity() {
        this.f16407a = false;
        this.f16408b = null;
        return this;
    }

    public TrafficCitys clearSuggestQuery() {
        this.f16410d = Collections.emptyList();
        return this;
    }

    public int getCachedSize() {
        if (this.f16411e < 0) {
            getSerializedSize();
        }
        return this.f16411e;
    }

    public Contents getContents(int i) {
        return (Contents) this.f16409c.get(i);
    }

    public int getContentsCount() {
        return this.f16409c.size();
    }

    public List<Contents> getContentsList() {
        return this.f16409c;
    }

    public CurrentCity getCurrentCity() {
        return this.f16408b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasCurrentCity()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getCurrentCity());
        }
        int i2 = i;
        for (Contents computeMessageSize : getContentsList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
        }
        for (SuggestQuery computeMessageSize2 : getSuggestQueryList()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize2);
        }
        this.f16411e = i2;
        return i2;
    }

    public SuggestQuery getSuggestQuery(int i) {
        return (SuggestQuery) this.f16410d.get(i);
    }

    public int getSuggestQueryCount() {
        return this.f16410d.size();
    }

    public List<SuggestQuery> getSuggestQueryList() {
        return this.f16410d;
    }

    public boolean hasCurrentCity() {
        return this.f16407a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public TrafficCitys mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro currentCity;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    currentCity = new CurrentCity();
                    codedInputStreamMicro.readMessage(currentCity);
                    setCurrentCity(currentCity);
                    continue;
                case 18:
                    currentCity = new Contents();
                    codedInputStreamMicro.readMessage(currentCity);
                    addContents(currentCity);
                    continue;
                case 26:
                    currentCity = new SuggestQuery();
                    codedInputStreamMicro.readMessage(currentCity);
                    addSuggestQuery(currentCity);
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

    public TrafficCitys setContents(int i, Contents contents) {
        if (contents != null) {
            this.f16409c.set(i, contents);
        }
        return this;
    }

    public TrafficCitys setCurrentCity(CurrentCity currentCity) {
        if (currentCity == null) {
            return clearCurrentCity();
        }
        this.f16407a = true;
        this.f16408b = currentCity;
        return this;
    }

    public TrafficCitys setSuggestQuery(int i, SuggestQuery suggestQuery) {
        if (suggestQuery != null) {
            this.f16410d.set(i, suggestQuery);
        }
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasCurrentCity()) {
            codedOutputStreamMicro.writeMessage(1, getCurrentCity());
        }
        for (Contents writeMessage : getContentsList()) {
            codedOutputStreamMicro.writeMessage(2, writeMessage);
        }
        for (SuggestQuery writeMessage2 : getSuggestQueryList()) {
            codedOutputStreamMicro.writeMessage(3, writeMessage2);
        }
    }
}
