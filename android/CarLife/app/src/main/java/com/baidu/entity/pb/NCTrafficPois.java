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

public final class NCTrafficPois extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 3;
    public static final int CURRENT_CITY_FIELD_NUMBER = 2;
    public static final int IMGE_SHOW_FIELD_NUMBER = 6;
    public static final int OPTION_FIELD_NUMBER = 1;
    public static final int SUGGEST_QUERY_FIELD_NUMBER = 4;
    public static final int SUGGEST_QUERY_FLAG_FIELD_NUMBER = 5;
    /* renamed from: a */
    private boolean f12201a;
    /* renamed from: b */
    private Option f12202b = null;
    /* renamed from: c */
    private boolean f12203c;
    /* renamed from: d */
    private CurrentCity f12204d = null;
    /* renamed from: e */
    private boolean f12205e;
    /* renamed from: f */
    private Content f12206f = null;
    /* renamed from: g */
    private List<SuggestQuery> f12207g = Collections.emptyList();
    /* renamed from: h */
    private boolean f12208h;
    /* renamed from: i */
    private int f12209i = 0;
    /* renamed from: j */
    private boolean f12210j;
    /* renamed from: k */
    private ImgeShow f12211k = null;
    /* renamed from: l */
    private int f12212l = -1;

    public static final class Content extends MessageMicro {
        public static final int END_FIELD_NUMBER = 2;
        public static final int START_FIELD_NUMBER = 1;
        public static final int WAY_POINTS_FIELD_NUMBER = 3;
        /* renamed from: a */
        private List<Start> f12144a = Collections.emptyList();
        /* renamed from: b */
        private List<End> f12145b = Collections.emptyList();
        /* renamed from: c */
        private List<WayPoints> f12146c = Collections.emptyList();
        /* renamed from: d */
        private int f12147d = -1;

        public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Content().mergeFrom(codedInputStreamMicro);
        }

        public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Content) new Content().mergeFrom(bArr);
        }

        public Content addEnd(End end) {
            if (end != null) {
                if (this.f12145b.isEmpty()) {
                    this.f12145b = new ArrayList();
                }
                this.f12145b.add(end);
            }
            return this;
        }

        public Content addStart(Start start) {
            if (start != null) {
                if (this.f12144a.isEmpty()) {
                    this.f12144a = new ArrayList();
                }
                this.f12144a.add(start);
            }
            return this;
        }

        public Content addWayPoints(WayPoints wayPoints) {
            if (wayPoints != null) {
                if (this.f12146c.isEmpty()) {
                    this.f12146c = new ArrayList();
                }
                this.f12146c.add(wayPoints);
            }
            return this;
        }

        public final Content clear() {
            clearStart();
            clearEnd();
            clearWayPoints();
            this.f12147d = -1;
            return this;
        }

        public Content clearEnd() {
            this.f12145b = Collections.emptyList();
            return this;
        }

        public Content clearStart() {
            this.f12144a = Collections.emptyList();
            return this;
        }

        public Content clearWayPoints() {
            this.f12146c = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f12147d < 0) {
                getSerializedSize();
            }
            return this.f12147d;
        }

        public End getEnd(int i) {
            return (End) this.f12145b.get(i);
        }

        public int getEndCount() {
            return this.f12145b.size();
        }

        public List<End> getEndList() {
            return this.f12145b;
        }

        public int getSerializedSize() {
            int i = 0;
            for (Start computeMessageSize : getStartList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            for (End computeMessageSize2 : getEndList()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize2);
            }
            for (WayPoints computeMessageSize3 : getWayPointsList()) {
                i += CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize3);
            }
            this.f12147d = i;
            return i;
        }

        public Start getStart(int i) {
            return (Start) this.f12144a.get(i);
        }

        public int getStartCount() {
            return this.f12144a.size();
        }

        public List<Start> getStartList() {
            return this.f12144a;
        }

        public WayPoints getWayPoints(int i) {
            return (WayPoints) this.f12146c.get(i);
        }

        public int getWayPointsCount() {
            return this.f12146c.size();
        }

        public List<WayPoints> getWayPointsList() {
            return this.f12146c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Content mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro start;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        start = new Start();
                        codedInputStreamMicro.readMessage(start);
                        addStart(start);
                        continue;
                    case 18:
                        start = new End();
                        codedInputStreamMicro.readMessage(start);
                        addEnd(start);
                        continue;
                    case 26:
                        start = new WayPoints();
                        codedInputStreamMicro.readMessage(start);
                        addWayPoints(start);
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

        public Content setEnd(int i, End end) {
            if (end != null) {
                this.f12145b.set(i, end);
            }
            return this;
        }

        public Content setStart(int i, Start start) {
            if (start != null) {
                this.f12144a.set(i, start);
            }
            return this;
        }

        public Content setWayPoints(int i, WayPoints wayPoints) {
            if (wayPoints != null) {
                this.f12146c.set(i, wayPoints);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (Start writeMessage : getStartList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
            for (End writeMessage2 : getEndList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage2);
            }
            for (WayPoints writeMessage3 : getWayPointsList()) {
                codedOutputStreamMicro.writeMessage(3, writeMessage3);
            }
        }
    }

    public static final class CurrentCity extends MessageMicro {
        public static final int CODE_FIELD_NUMBER = 1;
        public static final int GEO_FIELD_NUMBER = 2;
        public static final int LEVEL_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 4;
        public static final int SGEO_FIELD_NUMBER = 8;
        public static final int SUP_LUKUANG_FIELD_NUMBER = 6;
        public static final int SUP_SUBWAY_FIELD_NUMBER = 5;
        public static final int UID_FIELD_NUMBER = 7;
        /* renamed from: a */
        private boolean f12148a;
        /* renamed from: b */
        private int f12149b = 0;
        /* renamed from: c */
        private boolean f12150c;
        /* renamed from: d */
        private String f12151d = "";
        /* renamed from: e */
        private boolean f12152e;
        /* renamed from: f */
        private int f12153f = 0;
        /* renamed from: g */
        private boolean f12154g;
        /* renamed from: h */
        private String f12155h = "";
        /* renamed from: i */
        private boolean f12156i;
        /* renamed from: j */
        private boolean f12157j = false;
        /* renamed from: k */
        private boolean f12158k;
        /* renamed from: l */
        private boolean f12159l = false;
        /* renamed from: m */
        private boolean f12160m;
        /* renamed from: n */
        private String f12161n = "";
        /* renamed from: o */
        private List<Integer> f12162o = Collections.emptyList();
        /* renamed from: p */
        private int f12163p = -1;

        public static CurrentCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new CurrentCity().mergeFrom(codedInputStreamMicro);
        }

        public static CurrentCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (CurrentCity) new CurrentCity().mergeFrom(bArr);
        }

        public CurrentCity addSgeo(int i) {
            if (this.f12162o.isEmpty()) {
                this.f12162o = new ArrayList();
            }
            this.f12162o.add(Integer.valueOf(i));
            return this;
        }

        public final CurrentCity clear() {
            clearCode();
            clearGeo();
            clearLevel();
            clearName();
            clearSupSubway();
            clearSupLukuang();
            clearUid();
            clearSgeo();
            this.f12163p = -1;
            return this;
        }

        public CurrentCity clearCode() {
            this.f12148a = false;
            this.f12149b = 0;
            return this;
        }

        public CurrentCity clearGeo() {
            this.f12150c = false;
            this.f12151d = "";
            return this;
        }

        public CurrentCity clearLevel() {
            this.f12152e = false;
            this.f12153f = 0;
            return this;
        }

        public CurrentCity clearName() {
            this.f12154g = false;
            this.f12155h = "";
            return this;
        }

        public CurrentCity clearSgeo() {
            this.f12162o = Collections.emptyList();
            return this;
        }

        public CurrentCity clearSupLukuang() {
            this.f12158k = false;
            this.f12159l = false;
            return this;
        }

        public CurrentCity clearSupSubway() {
            this.f12156i = false;
            this.f12157j = false;
            return this;
        }

        public CurrentCity clearUid() {
            this.f12160m = false;
            this.f12161n = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f12163p < 0) {
                getSerializedSize();
            }
            return this.f12163p;
        }

        public int getCode() {
            return this.f12149b;
        }

        public String getGeo() {
            return this.f12151d;
        }

        public int getLevel() {
            return this.f12153f;
        }

        public String getName() {
            return this.f12155h;
        }

        public int getSerializedSize() {
            int i = 0;
            int computeInt32Size = hasCode() ? CodedOutputStreamMicro.computeInt32Size(1, getCode()) + 0 : 0;
            if (hasGeo()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getGeo());
            }
            if (hasLevel()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getLevel());
            }
            if (hasName()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getName());
            }
            if (hasSupSubway()) {
                computeInt32Size += CodedOutputStreamMicro.computeBoolSize(5, getSupSubway());
            }
            if (hasSupLukuang()) {
                computeInt32Size += CodedOutputStreamMicro.computeBoolSize(6, getSupLukuang());
            }
            int computeStringSize = hasUid() ? computeInt32Size + CodedOutputStreamMicro.computeStringSize(7, getUid()) : computeInt32Size;
            for (Integer intValue : getSgeoList()) {
                i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue());
            }
            computeInt32Size = (computeStringSize + i) + (getSgeoList().size() * 1);
            this.f12163p = computeInt32Size;
            return computeInt32Size;
        }

        public int getSgeo(int i) {
            return ((Integer) this.f12162o.get(i)).intValue();
        }

        public int getSgeoCount() {
            return this.f12162o.size();
        }

        public List<Integer> getSgeoList() {
            return this.f12162o;
        }

        public boolean getSupLukuang() {
            return this.f12159l;
        }

        public boolean getSupSubway() {
            return this.f12157j;
        }

        public String getUid() {
            return this.f12161n;
        }

        public boolean hasCode() {
            return this.f12148a;
        }

        public boolean hasGeo() {
            return this.f12150c;
        }

        public boolean hasLevel() {
            return this.f12152e;
        }

        public boolean hasName() {
            return this.f12154g;
        }

        public boolean hasSupLukuang() {
            return this.f12158k;
        }

        public boolean hasSupSubway() {
            return this.f12156i;
        }

        public boolean hasUid() {
            return this.f12160m;
        }

        public final boolean isInitialized() {
            return true;
        }

        public CurrentCity mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setCode(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setGeo(codedInputStreamMicro.readString());
                        continue;
                    case 24:
                        setLevel(codedInputStreamMicro.readInt32());
                        continue;
                    case 34:
                        setName(codedInputStreamMicro.readString());
                        continue;
                    case 40:
                        setSupSubway(codedInputStreamMicro.readBool());
                        continue;
                    case 48:
                        setSupLukuang(codedInputStreamMicro.readBool());
                        continue;
                    case 58:
                        setUid(codedInputStreamMicro.readString());
                        continue;
                    case 64:
                        addSgeo(codedInputStreamMicro.readSInt32());
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

        public CurrentCity setCode(int i) {
            this.f12148a = true;
            this.f12149b = i;
            return this;
        }

        public CurrentCity setGeo(String str) {
            this.f12150c = true;
            this.f12151d = str;
            return this;
        }

        public CurrentCity setLevel(int i) {
            this.f12152e = true;
            this.f12153f = i;
            return this;
        }

        public CurrentCity setName(String str) {
            this.f12154g = true;
            this.f12155h = str;
            return this;
        }

        public CurrentCity setSgeo(int i, int i2) {
            this.f12162o.set(i, Integer.valueOf(i2));
            return this;
        }

        public CurrentCity setSupLukuang(boolean z) {
            this.f12158k = true;
            this.f12159l = z;
            return this;
        }

        public CurrentCity setSupSubway(boolean z) {
            this.f12156i = true;
            this.f12157j = z;
            return this;
        }

        public CurrentCity setUid(String str) {
            this.f12160m = true;
            this.f12161n = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasCode()) {
                codedOutputStreamMicro.writeInt32(1, getCode());
            }
            if (hasGeo()) {
                codedOutputStreamMicro.writeString(2, getGeo());
            }
            if (hasLevel()) {
                codedOutputStreamMicro.writeInt32(3, getLevel());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(4, getName());
            }
            if (hasSupSubway()) {
                codedOutputStreamMicro.writeBool(5, getSupSubway());
            }
            if (hasSupLukuang()) {
                codedOutputStreamMicro.writeBool(6, getSupLukuang());
            }
            if (hasUid()) {
                codedOutputStreamMicro.writeString(7, getUid());
            }
            for (Integer intValue : getSgeoList()) {
                codedOutputStreamMicro.writeSInt32(8, intValue.intValue());
            }
        }
    }

    public static final class ImgeShow extends MessageMicro {
        public static final int IMGE_EXT_FIELD_NUMBER = 1;
        public static final int RES_BOUND_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f12164a;
        /* renamed from: b */
        private ByteStringMicro f12165b = ByteStringMicro.EMPTY;
        /* renamed from: c */
        private boolean f12166c;
        /* renamed from: d */
        private String f12167d = "";
        /* renamed from: e */
        private int f12168e = -1;

        public static ImgeShow parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ImgeShow().mergeFrom(codedInputStreamMicro);
        }

        public static ImgeShow parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ImgeShow) new ImgeShow().mergeFrom(bArr);
        }

        public final ImgeShow clear() {
            clearImgeExt();
            clearResBound();
            this.f12168e = -1;
            return this;
        }

        public ImgeShow clearImgeExt() {
            this.f12164a = false;
            this.f12165b = ByteStringMicro.EMPTY;
            return this;
        }

        public ImgeShow clearResBound() {
            this.f12166c = false;
            this.f12167d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f12168e < 0) {
                getSerializedSize();
            }
            return this.f12168e;
        }

        public ByteStringMicro getImgeExt() {
            return this.f12165b;
        }

        public String getResBound() {
            return this.f12167d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasImgeExt()) {
                i = 0 + CodedOutputStreamMicro.computeBytesSize(1, getImgeExt());
            }
            if (hasResBound()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getResBound());
            }
            this.f12168e = i;
            return i;
        }

        public boolean hasImgeExt() {
            return this.f12164a;
        }

        public boolean hasResBound() {
            return this.f12166c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ImgeShow mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setImgeExt(codedInputStreamMicro.readBytes());
                        continue;
                    case 18:
                        setResBound(codedInputStreamMicro.readString());
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

        public ImgeShow setImgeExt(ByteStringMicro byteStringMicro) {
            this.f12164a = true;
            this.f12165b = byteStringMicro;
            return this;
        }

        public ImgeShow setResBound(String str) {
            this.f12166c = true;
            this.f12167d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasImgeExt()) {
                codedOutputStreamMicro.writeBytes(1, getImgeExt());
            }
            if (hasResBound()) {
                codedOutputStreamMicro.writeString(2, getResBound());
            }
        }
    }

    public static final class Option extends MessageMicro {
        public static final int CITY_LIST_FIELD_NUMBER = 1;
        public static final int END_CITY_FIELD_NUMBER = 8;
        public static final int E_WD_FIELD_NUMBER = 5;
        public static final int IF_NAV_FIELD_NUMBER = 6;
        public static final int PRIO_FLAG_FIELD_NUMBER = 2;
        public static final int START_CITY_FIELD_NUMBER = 7;
        public static final int S_WD_FIELD_NUMBER = 4;
        public static final int VIA_CITY_FIELD_NUMBER = 10;
        public static final int V_WD_FIELD_NUMBER = 9;
        public static final int WP_WD_FIELD_NUMBER = 3;
        /* renamed from: a */
        private List<String> f12184a = Collections.emptyList();
        /* renamed from: b */
        private List<String> f12185b = Collections.emptyList();
        /* renamed from: c */
        private List<String> f12186c = Collections.emptyList();
        /* renamed from: d */
        private boolean f12187d;
        /* renamed from: e */
        private String f12188e = "";
        /* renamed from: f */
        private List<String> f12189f = Collections.emptyList();
        /* renamed from: g */
        private boolean f12190g;
        /* renamed from: h */
        private boolean f12191h = false;
        /* renamed from: i */
        private boolean f12192i;
        /* renamed from: j */
        private StartCity f12193j = null;
        /* renamed from: k */
        private List<EndCity> f12194k = Collections.emptyList();
        /* renamed from: l */
        private List<String> f12195l = Collections.emptyList();
        /* renamed from: m */
        private List<ViaCity> f12196m = Collections.emptyList();
        /* renamed from: n */
        private int f12197n = -1;

        public static final class EndCity extends MessageMicro {
            public static final int CNAME_FIELD_NUMBER = 2;
            public static final int CODE_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f12169a;
            /* renamed from: b */
            private int f12170b = 0;
            /* renamed from: c */
            private boolean f12171c;
            /* renamed from: d */
            private String f12172d = "";
            /* renamed from: e */
            private int f12173e = -1;

            public static EndCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new EndCity().mergeFrom(codedInputStreamMicro);
            }

            public static EndCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (EndCity) new EndCity().mergeFrom(bArr);
            }

            public final EndCity clear() {
                clearCode();
                clearCname();
                this.f12173e = -1;
                return this;
            }

            public EndCity clearCname() {
                this.f12171c = false;
                this.f12172d = "";
                return this;
            }

            public EndCity clearCode() {
                this.f12169a = false;
                this.f12170b = 0;
                return this;
            }

            public int getCachedSize() {
                if (this.f12173e < 0) {
                    getSerializedSize();
                }
                return this.f12173e;
            }

            public String getCname() {
                return this.f12172d;
            }

            public int getCode() {
                return this.f12170b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasCode()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
                }
                if (hasCname()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.f12173e = i;
                return i;
            }

            public boolean hasCname() {
                return this.f12171c;
            }

            public boolean hasCode() {
                return this.f12169a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public EndCity mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            setCode(codedInputStreamMicro.readInt32());
                            continue;
                        case 18:
                            setCname(codedInputStreamMicro.readString());
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

            public EndCity setCname(String str) {
                this.f12171c = true;
                this.f12172d = str;
                return this;
            }

            public EndCity setCode(int i) {
                this.f12169a = true;
                this.f12170b = i;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasCode()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (hasCname()) {
                    codedOutputStreamMicro.writeString(2, getCname());
                }
            }
        }

        public static final class StartCity extends MessageMicro {
            public static final int CNAME_FIELD_NUMBER = 2;
            public static final int CODE_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f12174a;
            /* renamed from: b */
            private int f12175b = 0;
            /* renamed from: c */
            private boolean f12176c;
            /* renamed from: d */
            private String f12177d = "";
            /* renamed from: e */
            private int f12178e = -1;

            public static StartCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new StartCity().mergeFrom(codedInputStreamMicro);
            }

            public static StartCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (StartCity) new StartCity().mergeFrom(bArr);
            }

            public final StartCity clear() {
                clearCode();
                clearCname();
                this.f12178e = -1;
                return this;
            }

            public StartCity clearCname() {
                this.f12176c = false;
                this.f12177d = "";
                return this;
            }

            public StartCity clearCode() {
                this.f12174a = false;
                this.f12175b = 0;
                return this;
            }

            public int getCachedSize() {
                if (this.f12178e < 0) {
                    getSerializedSize();
                }
                return this.f12178e;
            }

            public String getCname() {
                return this.f12177d;
            }

            public int getCode() {
                return this.f12175b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasCode()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
                }
                if (hasCname()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.f12178e = i;
                return i;
            }

            public boolean hasCname() {
                return this.f12176c;
            }

            public boolean hasCode() {
                return this.f12174a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public StartCity mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            setCode(codedInputStreamMicro.readInt32());
                            continue;
                        case 18:
                            setCname(codedInputStreamMicro.readString());
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

            public StartCity setCname(String str) {
                this.f12176c = true;
                this.f12177d = str;
                return this;
            }

            public StartCity setCode(int i) {
                this.f12174a = true;
                this.f12175b = i;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasCode()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (hasCname()) {
                    codedOutputStreamMicro.writeString(2, getCname());
                }
            }
        }

        public static final class ViaCity extends MessageMicro {
            public static final int CNAME_FIELD_NUMBER = 2;
            public static final int CODE_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f12179a;
            /* renamed from: b */
            private int f12180b = 0;
            /* renamed from: c */
            private boolean f12181c;
            /* renamed from: d */
            private String f12182d = "";
            /* renamed from: e */
            private int f12183e = -1;

            public static ViaCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new ViaCity().mergeFrom(codedInputStreamMicro);
            }

            public static ViaCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (ViaCity) new ViaCity().mergeFrom(bArr);
            }

            public final ViaCity clear() {
                clearCode();
                clearCname();
                this.f12183e = -1;
                return this;
            }

            public ViaCity clearCname() {
                this.f12181c = false;
                this.f12182d = "";
                return this;
            }

            public ViaCity clearCode() {
                this.f12179a = false;
                this.f12180b = 0;
                return this;
            }

            public int getCachedSize() {
                if (this.f12183e < 0) {
                    getSerializedSize();
                }
                return this.f12183e;
            }

            public String getCname() {
                return this.f12182d;
            }

            public int getCode() {
                return this.f12180b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasCode()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
                }
                if (hasCname()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.f12183e = i;
                return i;
            }

            public boolean hasCname() {
                return this.f12181c;
            }

            public boolean hasCode() {
                return this.f12179a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public ViaCity mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            setCode(codedInputStreamMicro.readInt32());
                            continue;
                        case 18:
                            setCname(codedInputStreamMicro.readString());
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

            public ViaCity setCname(String str) {
                this.f12181c = true;
                this.f12182d = str;
                return this;
            }

            public ViaCity setCode(int i) {
                this.f12179a = true;
                this.f12180b = i;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasCode()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (hasCname()) {
                    codedOutputStreamMicro.writeString(2, getCname());
                }
            }
        }

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }

        public Option addCityList(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f12184a.isEmpty()) {
                this.f12184a = new ArrayList();
            }
            this.f12184a.add(str);
            return this;
        }

        public Option addEWd(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f12189f.isEmpty()) {
                this.f12189f = new ArrayList();
            }
            this.f12189f.add(str);
            return this;
        }

        public Option addEndCity(EndCity endCity) {
            if (endCity != null) {
                if (this.f12194k.isEmpty()) {
                    this.f12194k = new ArrayList();
                }
                this.f12194k.add(endCity);
            }
            return this;
        }

        public Option addPrioFlag(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f12185b.isEmpty()) {
                this.f12185b = new ArrayList();
            }
            this.f12185b.add(str);
            return this;
        }

        public Option addVWd(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f12195l.isEmpty()) {
                this.f12195l = new ArrayList();
            }
            this.f12195l.add(str);
            return this;
        }

        public Option addViaCity(ViaCity viaCity) {
            if (viaCity != null) {
                if (this.f12196m.isEmpty()) {
                    this.f12196m = new ArrayList();
                }
                this.f12196m.add(viaCity);
            }
            return this;
        }

        public Option addWpWd(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f12186c.isEmpty()) {
                this.f12186c = new ArrayList();
            }
            this.f12186c.add(str);
            return this;
        }

        public final Option clear() {
            clearCityList();
            clearPrioFlag();
            clearWpWd();
            clearSWd();
            clearEWd();
            clearIfNav();
            clearStartCity();
            clearEndCity();
            clearVWd();
            clearViaCity();
            this.f12197n = -1;
            return this;
        }

        public Option clearCityList() {
            this.f12184a = Collections.emptyList();
            return this;
        }

        public Option clearEWd() {
            this.f12189f = Collections.emptyList();
            return this;
        }

        public Option clearEndCity() {
            this.f12194k = Collections.emptyList();
            return this;
        }

        public Option clearIfNav() {
            this.f12190g = false;
            this.f12191h = false;
            return this;
        }

        public Option clearPrioFlag() {
            this.f12185b = Collections.emptyList();
            return this;
        }

        public Option clearSWd() {
            this.f12187d = false;
            this.f12188e = "";
            return this;
        }

        public Option clearStartCity() {
            this.f12192i = false;
            this.f12193j = null;
            return this;
        }

        public Option clearVWd() {
            this.f12195l = Collections.emptyList();
            return this;
        }

        public Option clearViaCity() {
            this.f12196m = Collections.emptyList();
            return this;
        }

        public Option clearWpWd() {
            this.f12186c = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f12197n < 0) {
                getSerializedSize();
            }
            return this.f12197n;
        }

        public String getCityList(int i) {
            return (String) this.f12184a.get(i);
        }

        public int getCityListCount() {
            return this.f12184a.size();
        }

        public List<String> getCityListList() {
            return this.f12184a;
        }

        public String getEWd(int i) {
            return (String) this.f12189f.get(i);
        }

        public int getEWdCount() {
            return this.f12189f.size();
        }

        public List<String> getEWdList() {
            return this.f12189f;
        }

        public EndCity getEndCity(int i) {
            return (EndCity) this.f12194k.get(i);
        }

        public int getEndCityCount() {
            return this.f12194k.size();
        }

        public List<EndCity> getEndCityList() {
            return this.f12194k;
        }

        public boolean getIfNav() {
            return this.f12191h;
        }

        public String getPrioFlag(int i) {
            return (String) this.f12185b.get(i);
        }

        public int getPrioFlagCount() {
            return this.f12185b.size();
        }

        public List<String> getPrioFlagList() {
            return this.f12185b;
        }

        public String getSWd() {
            return this.f12188e;
        }

        public int getSerializedSize() {
            int i = 0;
            int i2 = 0;
            for (String computeStringSizeNoTag : getCityListList()) {
                i2 = CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag) + i2;
            }
            int size = (0 + i2) + (getCityListList().size() * 1);
            i2 = 0;
            for (String computeStringSizeNoTag2 : getPrioFlagList()) {
                i2 = CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag2) + i2;
            }
            size = (size + i2) + (getPrioFlagList().size() * 1);
            i2 = 0;
            for (String computeStringSizeNoTag22 : getWpWdList()) {
                i2 = CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag22) + i2;
            }
            int size2 = (size + i2) + (getWpWdList().size() * 1);
            i2 = hasSWd() ? size2 + CodedOutputStreamMicro.computeStringSize(4, getSWd()) : size2;
            size = 0;
            for (String computeStringSizeNoTag222 : getEWdList()) {
                size = CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag222) + size;
            }
            size2 = (i2 + size) + (getEWdList().size() * 1);
            if (hasIfNav()) {
                size2 += CodedOutputStreamMicro.computeBoolSize(6, getIfNav());
            }
            if (hasStartCity()) {
                size2 += CodedOutputStreamMicro.computeMessageSize(7, getStartCity());
            }
            i2 = size2;
            for (EndCity computeMessageSize : getEndCityList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(8, computeMessageSize) + i2;
            }
            for (String computeStringSizeNoTag2222 : getVWdList()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag2222);
            }
            size2 = (i2 + i) + (getVWdList().size() * 1);
            i2 = size2;
            for (ViaCity computeMessageSize2 : getViaCityList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(10, computeMessageSize2) + i2;
            }
            this.f12197n = i2;
            return i2;
        }

        public StartCity getStartCity() {
            return this.f12193j;
        }

        public String getVWd(int i) {
            return (String) this.f12195l.get(i);
        }

        public int getVWdCount() {
            return this.f12195l.size();
        }

        public List<String> getVWdList() {
            return this.f12195l;
        }

        public ViaCity getViaCity(int i) {
            return (ViaCity) this.f12196m.get(i);
        }

        public int getViaCityCount() {
            return this.f12196m.size();
        }

        public List<ViaCity> getViaCityList() {
            return this.f12196m;
        }

        public String getWpWd(int i) {
            return (String) this.f12186c.get(i);
        }

        public int getWpWdCount() {
            return this.f12186c.size();
        }

        public List<String> getWpWdList() {
            return this.f12186c;
        }

        public boolean hasIfNav() {
            return this.f12190g;
        }

        public boolean hasSWd() {
            return this.f12187d;
        }

        public boolean hasStartCity() {
            return this.f12192i;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Option mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro startCity;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        addCityList(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        addPrioFlag(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        addWpWd(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setSWd(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        addEWd(codedInputStreamMicro.readString());
                        continue;
                    case 48:
                        setIfNav(codedInputStreamMicro.readBool());
                        continue;
                    case 58:
                        startCity = new StartCity();
                        codedInputStreamMicro.readMessage(startCity);
                        setStartCity(startCity);
                        continue;
                    case 66:
                        startCity = new EndCity();
                        codedInputStreamMicro.readMessage(startCity);
                        addEndCity(startCity);
                        continue;
                    case 74:
                        addVWd(codedInputStreamMicro.readString());
                        continue;
                    case 82:
                        startCity = new ViaCity();
                        codedInputStreamMicro.readMessage(startCity);
                        addViaCity(startCity);
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

        public Option setCityList(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f12184a.set(i, str);
            return this;
        }

        public Option setEWd(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f12189f.set(i, str);
            return this;
        }

        public Option setEndCity(int i, EndCity endCity) {
            if (endCity != null) {
                this.f12194k.set(i, endCity);
            }
            return this;
        }

        public Option setIfNav(boolean z) {
            this.f12190g = true;
            this.f12191h = z;
            return this;
        }

        public Option setPrioFlag(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f12185b.set(i, str);
            return this;
        }

        public Option setSWd(String str) {
            this.f12187d = true;
            this.f12188e = str;
            return this;
        }

        public Option setStartCity(StartCity startCity) {
            if (startCity == null) {
                return clearStartCity();
            }
            this.f12192i = true;
            this.f12193j = startCity;
            return this;
        }

        public Option setVWd(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f12195l.set(i, str);
            return this;
        }

        public Option setViaCity(int i, ViaCity viaCity) {
            if (viaCity != null) {
                this.f12196m.set(i, viaCity);
            }
            return this;
        }

        public Option setWpWd(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f12186c.set(i, str);
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (String writeString : getCityListList()) {
                codedOutputStreamMicro.writeString(1, writeString);
            }
            for (String writeString2 : getPrioFlagList()) {
                codedOutputStreamMicro.writeString(2, writeString2);
            }
            for (String writeString22 : getWpWdList()) {
                codedOutputStreamMicro.writeString(3, writeString22);
            }
            if (hasSWd()) {
                codedOutputStreamMicro.writeString(4, getSWd());
            }
            for (String writeString222 : getEWdList()) {
                codedOutputStreamMicro.writeString(5, writeString222);
            }
            if (hasIfNav()) {
                codedOutputStreamMicro.writeBool(6, getIfNav());
            }
            if (hasStartCity()) {
                codedOutputStreamMicro.writeMessage(7, getStartCity());
            }
            for (EndCity writeMessage : getEndCityList()) {
                codedOutputStreamMicro.writeMessage(8, writeMessage);
            }
            for (String writeString2222 : getVWdList()) {
                codedOutputStreamMicro.writeString(9, writeString2222);
            }
            for (ViaCity writeMessage2 : getViaCityList()) {
                codedOutputStreamMicro.writeMessage(10, writeMessage2);
            }
        }
    }

    public static final class SuggestQuery extends MessageMicro {
        public static final int QUERY_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f12198a;
        /* renamed from: b */
        private String f12199b = "";
        /* renamed from: c */
        private int f12200c = -1;

        public static SuggestQuery parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new SuggestQuery().mergeFrom(codedInputStreamMicro);
        }

        public static SuggestQuery parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (SuggestQuery) new SuggestQuery().mergeFrom(bArr);
        }

        public final SuggestQuery clear() {
            clearQuery();
            this.f12200c = -1;
            return this;
        }

        public SuggestQuery clearQuery() {
            this.f12198a = false;
            this.f12199b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f12200c < 0) {
                getSerializedSize();
            }
            return this.f12200c;
        }

        public String getQuery() {
            return this.f12199b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasQuery()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getQuery());
            }
            this.f12200c = i;
            return i;
        }

        public boolean hasQuery() {
            return this.f12198a;
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
            this.f12198a = true;
            this.f12199b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasQuery()) {
                codedOutputStreamMicro.writeString(1, getQuery());
            }
        }
    }

    public static NCTrafficPois parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new NCTrafficPois().mergeFrom(codedInputStreamMicro);
    }

    public static NCTrafficPois parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (NCTrafficPois) new NCTrafficPois().mergeFrom(bArr);
    }

    public NCTrafficPois addSuggestQuery(SuggestQuery suggestQuery) {
        if (suggestQuery != null) {
            if (this.f12207g.isEmpty()) {
                this.f12207g = new ArrayList();
            }
            this.f12207g.add(suggestQuery);
        }
        return this;
    }

    public final NCTrafficPois clear() {
        clearOption();
        clearCurrentCity();
        clearContent();
        clearSuggestQuery();
        clearSuggestQueryFlag();
        clearImgeShow();
        this.f12212l = -1;
        return this;
    }

    public NCTrafficPois clearContent() {
        this.f12205e = false;
        this.f12206f = null;
        return this;
    }

    public NCTrafficPois clearCurrentCity() {
        this.f12203c = false;
        this.f12204d = null;
        return this;
    }

    public NCTrafficPois clearImgeShow() {
        this.f12210j = false;
        this.f12211k = null;
        return this;
    }

    public NCTrafficPois clearOption() {
        this.f12201a = false;
        this.f12202b = null;
        return this;
    }

    public NCTrafficPois clearSuggestQuery() {
        this.f12207g = Collections.emptyList();
        return this;
    }

    public NCTrafficPois clearSuggestQueryFlag() {
        this.f12208h = false;
        this.f12209i = 0;
        return this;
    }

    public int getCachedSize() {
        if (this.f12212l < 0) {
            getSerializedSize();
        }
        return this.f12212l;
    }

    public Content getContent() {
        return this.f12206f;
    }

    public CurrentCity getCurrentCity() {
        return this.f12204d;
    }

    public ImgeShow getImgeShow() {
        return this.f12211k;
    }

    public Option getOption() {
        return this.f12202b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasOption()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
        }
        if (hasCurrentCity()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getCurrentCity());
        }
        if (hasContent()) {
            i += CodedOutputStreamMicro.computeMessageSize(3, getContent());
        }
        int i2 = i;
        for (SuggestQuery computeMessageSize : getSuggestQueryList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(4, computeMessageSize) + i2;
        }
        if (hasSuggestQueryFlag()) {
            i2 += CodedOutputStreamMicro.computeInt32Size(5, getSuggestQueryFlag());
        }
        if (hasImgeShow()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(6, getImgeShow());
        }
        this.f12212l = i2;
        return i2;
    }

    public SuggestQuery getSuggestQuery(int i) {
        return (SuggestQuery) this.f12207g.get(i);
    }

    public int getSuggestQueryCount() {
        return this.f12207g.size();
    }

    public int getSuggestQueryFlag() {
        return this.f12209i;
    }

    public List<SuggestQuery> getSuggestQueryList() {
        return this.f12207g;
    }

    public boolean hasContent() {
        return this.f12205e;
    }

    public boolean hasCurrentCity() {
        return this.f12203c;
    }

    public boolean hasImgeShow() {
        return this.f12210j;
    }

    public boolean hasOption() {
        return this.f12201a;
    }

    public boolean hasSuggestQueryFlag() {
        return this.f12208h;
    }

    public final boolean isInitialized() {
        return true;
    }

    public NCTrafficPois mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                    option = new CurrentCity();
                    codedInputStreamMicro.readMessage(option);
                    setCurrentCity(option);
                    continue;
                case 26:
                    option = new Content();
                    codedInputStreamMicro.readMessage(option);
                    setContent(option);
                    continue;
                case 34:
                    option = new SuggestQuery();
                    codedInputStreamMicro.readMessage(option);
                    addSuggestQuery(option);
                    continue;
                case 40:
                    setSuggestQueryFlag(codedInputStreamMicro.readInt32());
                    continue;
                case 50:
                    option = new ImgeShow();
                    codedInputStreamMicro.readMessage(option);
                    setImgeShow(option);
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

    public NCTrafficPois setContent(Content content) {
        if (content == null) {
            return clearContent();
        }
        this.f12205e = true;
        this.f12206f = content;
        return this;
    }

    public NCTrafficPois setCurrentCity(CurrentCity currentCity) {
        if (currentCity == null) {
            return clearCurrentCity();
        }
        this.f12203c = true;
        this.f12204d = currentCity;
        return this;
    }

    public NCTrafficPois setImgeShow(ImgeShow imgeShow) {
        if (imgeShow == null) {
            return clearImgeShow();
        }
        this.f12210j = true;
        this.f12211k = imgeShow;
        return this;
    }

    public NCTrafficPois setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f12201a = true;
        this.f12202b = option;
        return this;
    }

    public NCTrafficPois setSuggestQuery(int i, SuggestQuery suggestQuery) {
        if (suggestQuery != null) {
            this.f12207g.set(i, suggestQuery);
        }
        return this;
    }

    public NCTrafficPois setSuggestQueryFlag(int i) {
        this.f12208h = true;
        this.f12209i = i;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(1, getOption());
        }
        if (hasCurrentCity()) {
            codedOutputStreamMicro.writeMessage(2, getCurrentCity());
        }
        if (hasContent()) {
            codedOutputStreamMicro.writeMessage(3, getContent());
        }
        for (SuggestQuery writeMessage : getSuggestQueryList()) {
            codedOutputStreamMicro.writeMessage(4, writeMessage);
        }
        if (hasSuggestQueryFlag()) {
            codedOutputStreamMicro.writeInt32(5, getSuggestQueryFlag());
        }
        if (hasImgeShow()) {
            codedOutputStreamMicro.writeMessage(6, getImgeShow());
        }
    }
}
