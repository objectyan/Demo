package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Walk extends MessageMicro {
    public static final int CURRENT_CITY_FIELD_NUMBER = 2;
    public static final int OPTION_FIELD_NUMBER = 4;
    public static final int ROUTES_FIELD_NUMBER = 3;
    public static final int TAXI_FIELD_NUMBER = 1;
    public static final int TRAFFIC_FIELD_NUMBER = 5;
    /* renamed from: a */
    private boolean f16825a;
    /* renamed from: b */
    private Taxi f16826b = null;
    /* renamed from: c */
    private boolean f16827c;
    /* renamed from: d */
    private CurrentCity f16828d = null;
    /* renamed from: e */
    private List<Routes> f16829e = Collections.emptyList();
    /* renamed from: f */
    private boolean f16830f;
    /* renamed from: g */
    private Option f16831g = null;
    /* renamed from: h */
    private boolean f16832h;
    /* renamed from: i */
    private Traffic f16833i = null;
    /* renamed from: j */
    private int f16834j = -1;

    public static final class Option extends MessageMicro {
        public static final int AVOID_JAM_FIELD_NUMBER = 6;
        public static final int END_CITY_FIELD_NUMBER = 8;
        public static final int END_FIELD_NUMBER = 5;
        public static final int EXPTIME_FIELD_NUMBER = 2;
        public static final int START_CITY_FIELD_NUMBER = 7;
        public static final int START_FIELD_NUMBER = 4;
        public static final int SY_FIELD_NUMBER = 3;
        public static final int TOTAL_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f16744a;
        /* renamed from: b */
        private int f16745b = 0;
        /* renamed from: c */
        private boolean f16746c;
        /* renamed from: d */
        private String f16747d = "";
        /* renamed from: e */
        private boolean f16748e;
        /* renamed from: f */
        private int f16749f = 0;
        /* renamed from: g */
        private boolean f16750g;
        /* renamed from: h */
        private Start f16751h = null;
        /* renamed from: i */
        private List<End> f16752i = Collections.emptyList();
        /* renamed from: j */
        private boolean f16753j;
        /* renamed from: k */
        private int f16754k = 0;
        /* renamed from: l */
        private boolean f16755l;
        /* renamed from: m */
        private StartCity f16756m = null;
        /* renamed from: n */
        private List<EndCity> f16757n = Collections.emptyList();
        /* renamed from: o */
        private int f16758o = -1;

        public static final class End extends MessageMicro {
            public static final int BUS_STOP_FIELD_NUMBER = 4;
            public static final int PT_FIELD_NUMBER = 1;
            public static final int SPT_FIELD_NUMBER = 5;
            public static final int UID_FIELD_NUMBER = 3;
            public static final int WD_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f16714a;
            /* renamed from: b */
            private String f16715b = "";
            /* renamed from: c */
            private boolean f16716c;
            /* renamed from: d */
            private String f16717d = "";
            /* renamed from: e */
            private boolean f16718e;
            /* renamed from: f */
            private String f16719f = "";
            /* renamed from: g */
            private boolean f16720g;
            /* renamed from: h */
            private boolean f16721h = false;
            /* renamed from: i */
            private List<Integer> f16722i = Collections.emptyList();
            /* renamed from: j */
            private int f16723j = -1;

            public static End parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new End().mergeFrom(codedInputStreamMicro);
            }

            public static End parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (End) new End().mergeFrom(bArr);
            }

            public End addSpt(int i) {
                if (this.f16722i.isEmpty()) {
                    this.f16722i = new ArrayList();
                }
                this.f16722i.add(Integer.valueOf(i));
                return this;
            }

            public final End clear() {
                clearPt();
                clearWd();
                clearUid();
                clearBusStop();
                clearSpt();
                this.f16723j = -1;
                return this;
            }

            public End clearBusStop() {
                this.f16720g = false;
                this.f16721h = false;
                return this;
            }

            public End clearPt() {
                this.f16714a = false;
                this.f16715b = "";
                return this;
            }

            public End clearSpt() {
                this.f16722i = Collections.emptyList();
                return this;
            }

            public End clearUid() {
                this.f16718e = false;
                this.f16719f = "";
                return this;
            }

            public End clearWd() {
                this.f16716c = false;
                this.f16717d = "";
                return this;
            }

            public boolean getBusStop() {
                return this.f16721h;
            }

            public int getCachedSize() {
                if (this.f16723j < 0) {
                    getSerializedSize();
                }
                return this.f16723j;
            }

            public String getPt() {
                return this.f16715b;
            }

            public int getSerializedSize() {
                int i = 0;
                int computeStringSize = hasPt() ? CodedOutputStreamMicro.computeStringSize(1, getPt()) + 0 : 0;
                if (hasWd()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getWd());
                }
                if (hasUid()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getUid());
                }
                int computeBoolSize = hasBusStop() ? computeStringSize + CodedOutputStreamMicro.computeBoolSize(4, getBusStop()) : computeStringSize;
                for (Integer intValue : getSptList()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue());
                }
                computeStringSize = (computeBoolSize + i) + (getSptList().size() * 1);
                this.f16723j = computeStringSize;
                return computeStringSize;
            }

            public int getSpt(int i) {
                return ((Integer) this.f16722i.get(i)).intValue();
            }

            public int getSptCount() {
                return this.f16722i.size();
            }

            public List<Integer> getSptList() {
                return this.f16722i;
            }

            public String getUid() {
                return this.f16719f;
            }

            public String getWd() {
                return this.f16717d;
            }

            public boolean hasBusStop() {
                return this.f16720g;
            }

            public boolean hasPt() {
                return this.f16714a;
            }

            public boolean hasUid() {
                return this.f16718e;
            }

            public boolean hasWd() {
                return this.f16716c;
            }

            public final boolean isInitialized() {
                return true;
            }

            public End mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setPt(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setWd(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setUid(codedInputStreamMicro.readString());
                            continue;
                        case 32:
                            setBusStop(codedInputStreamMicro.readBool());
                            continue;
                        case 40:
                            addSpt(codedInputStreamMicro.readSInt32());
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

            public End setBusStop(boolean z) {
                this.f16720g = true;
                this.f16721h = z;
                return this;
            }

            public End setPt(String str) {
                this.f16714a = true;
                this.f16715b = str;
                return this;
            }

            public End setSpt(int i, int i2) {
                this.f16722i.set(i, Integer.valueOf(i2));
                return this;
            }

            public End setUid(String str) {
                this.f16718e = true;
                this.f16719f = str;
                return this;
            }

            public End setWd(String str) {
                this.f16716c = true;
                this.f16717d = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasPt()) {
                    codedOutputStreamMicro.writeString(1, getPt());
                }
                if (hasWd()) {
                    codedOutputStreamMicro.writeString(2, getWd());
                }
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(3, getUid());
                }
                if (hasBusStop()) {
                    codedOutputStreamMicro.writeBool(4, getBusStop());
                }
                for (Integer intValue : getSptList()) {
                    codedOutputStreamMicro.writeSInt32(5, intValue.intValue());
                }
            }
        }

        public static final class EndCity extends MessageMicro {
            public static final int CNAME_FIELD_NUMBER = 2;
            public static final int CODE_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f16724a;
            /* renamed from: b */
            private int f16725b = 0;
            /* renamed from: c */
            private boolean f16726c;
            /* renamed from: d */
            private String f16727d = "";
            /* renamed from: e */
            private int f16728e = -1;

            public static EndCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new EndCity().mergeFrom(codedInputStreamMicro);
            }

            public static EndCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (EndCity) new EndCity().mergeFrom(bArr);
            }

            public final EndCity clear() {
                clearCode();
                clearCname();
                this.f16728e = -1;
                return this;
            }

            public EndCity clearCname() {
                this.f16726c = false;
                this.f16727d = "";
                return this;
            }

            public EndCity clearCode() {
                this.f16724a = false;
                this.f16725b = 0;
                return this;
            }

            public int getCachedSize() {
                if (this.f16728e < 0) {
                    getSerializedSize();
                }
                return this.f16728e;
            }

            public String getCname() {
                return this.f16727d;
            }

            public int getCode() {
                return this.f16725b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasCode()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
                }
                if (hasCname()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.f16728e = i;
                return i;
            }

            public boolean hasCname() {
                return this.f16726c;
            }

            public boolean hasCode() {
                return this.f16724a;
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
                this.f16726c = true;
                this.f16727d = str;
                return this;
            }

            public EndCity setCode(int i) {
                this.f16724a = true;
                this.f16725b = i;
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

        public static final class Start extends MessageMicro {
            public static final int BUS_STOP_FIELD_NUMBER = 4;
            public static final int PT_FIELD_NUMBER = 1;
            public static final int SPT_FIELD_NUMBER = 5;
            public static final int UID_FIELD_NUMBER = 3;
            public static final int WD_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f16729a;
            /* renamed from: b */
            private String f16730b = "";
            /* renamed from: c */
            private boolean f16731c;
            /* renamed from: d */
            private String f16732d = "";
            /* renamed from: e */
            private boolean f16733e;
            /* renamed from: f */
            private String f16734f = "";
            /* renamed from: g */
            private boolean f16735g;
            /* renamed from: h */
            private boolean f16736h = false;
            /* renamed from: i */
            private List<Integer> f16737i = Collections.emptyList();
            /* renamed from: j */
            private int f16738j = -1;

            public static Start parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Start().mergeFrom(codedInputStreamMicro);
            }

            public static Start parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Start) new Start().mergeFrom(bArr);
            }

            public Start addSpt(int i) {
                if (this.f16737i.isEmpty()) {
                    this.f16737i = new ArrayList();
                }
                this.f16737i.add(Integer.valueOf(i));
                return this;
            }

            public final Start clear() {
                clearPt();
                clearWd();
                clearUid();
                clearBusStop();
                clearSpt();
                this.f16738j = -1;
                return this;
            }

            public Start clearBusStop() {
                this.f16735g = false;
                this.f16736h = false;
                return this;
            }

            public Start clearPt() {
                this.f16729a = false;
                this.f16730b = "";
                return this;
            }

            public Start clearSpt() {
                this.f16737i = Collections.emptyList();
                return this;
            }

            public Start clearUid() {
                this.f16733e = false;
                this.f16734f = "";
                return this;
            }

            public Start clearWd() {
                this.f16731c = false;
                this.f16732d = "";
                return this;
            }

            public boolean getBusStop() {
                return this.f16736h;
            }

            public int getCachedSize() {
                if (this.f16738j < 0) {
                    getSerializedSize();
                }
                return this.f16738j;
            }

            public String getPt() {
                return this.f16730b;
            }

            public int getSerializedSize() {
                int i = 0;
                int computeStringSize = hasPt() ? CodedOutputStreamMicro.computeStringSize(1, getPt()) + 0 : 0;
                if (hasWd()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getWd());
                }
                if (hasUid()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getUid());
                }
                int computeBoolSize = hasBusStop() ? computeStringSize + CodedOutputStreamMicro.computeBoolSize(4, getBusStop()) : computeStringSize;
                for (Integer intValue : getSptList()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue());
                }
                computeStringSize = (computeBoolSize + i) + (getSptList().size() * 1);
                this.f16738j = computeStringSize;
                return computeStringSize;
            }

            public int getSpt(int i) {
                return ((Integer) this.f16737i.get(i)).intValue();
            }

            public int getSptCount() {
                return this.f16737i.size();
            }

            public List<Integer> getSptList() {
                return this.f16737i;
            }

            public String getUid() {
                return this.f16734f;
            }

            public String getWd() {
                return this.f16732d;
            }

            public boolean hasBusStop() {
                return this.f16735g;
            }

            public boolean hasPt() {
                return this.f16729a;
            }

            public boolean hasUid() {
                return this.f16733e;
            }

            public boolean hasWd() {
                return this.f16731c;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Start mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setPt(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setWd(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setUid(codedInputStreamMicro.readString());
                            continue;
                        case 32:
                            setBusStop(codedInputStreamMicro.readBool());
                            continue;
                        case 40:
                            addSpt(codedInputStreamMicro.readSInt32());
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

            public Start setBusStop(boolean z) {
                this.f16735g = true;
                this.f16736h = z;
                return this;
            }

            public Start setPt(String str) {
                this.f16729a = true;
                this.f16730b = str;
                return this;
            }

            public Start setSpt(int i, int i2) {
                this.f16737i.set(i, Integer.valueOf(i2));
                return this;
            }

            public Start setUid(String str) {
                this.f16733e = true;
                this.f16734f = str;
                return this;
            }

            public Start setWd(String str) {
                this.f16731c = true;
                this.f16732d = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasPt()) {
                    codedOutputStreamMicro.writeString(1, getPt());
                }
                if (hasWd()) {
                    codedOutputStreamMicro.writeString(2, getWd());
                }
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(3, getUid());
                }
                if (hasBusStop()) {
                    codedOutputStreamMicro.writeBool(4, getBusStop());
                }
                for (Integer intValue : getSptList()) {
                    codedOutputStreamMicro.writeSInt32(5, intValue.intValue());
                }
            }
        }

        public static final class StartCity extends MessageMicro {
            public static final int CNAME_FIELD_NUMBER = 2;
            public static final int CODE_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f16739a;
            /* renamed from: b */
            private int f16740b = 0;
            /* renamed from: c */
            private boolean f16741c;
            /* renamed from: d */
            private String f16742d = "";
            /* renamed from: e */
            private int f16743e = -1;

            public static StartCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new StartCity().mergeFrom(codedInputStreamMicro);
            }

            public static StartCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (StartCity) new StartCity().mergeFrom(bArr);
            }

            public final StartCity clear() {
                clearCode();
                clearCname();
                this.f16743e = -1;
                return this;
            }

            public StartCity clearCname() {
                this.f16741c = false;
                this.f16742d = "";
                return this;
            }

            public StartCity clearCode() {
                this.f16739a = false;
                this.f16740b = 0;
                return this;
            }

            public int getCachedSize() {
                if (this.f16743e < 0) {
                    getSerializedSize();
                }
                return this.f16743e;
            }

            public String getCname() {
                return this.f16742d;
            }

            public int getCode() {
                return this.f16740b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasCode()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
                }
                if (hasCname()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.f16743e = i;
                return i;
            }

            public boolean hasCname() {
                return this.f16741c;
            }

            public boolean hasCode() {
                return this.f16739a;
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
                this.f16741c = true;
                this.f16742d = str;
                return this;
            }

            public StartCity setCode(int i) {
                this.f16739a = true;
                this.f16740b = i;
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

        public Option addEnd(End end) {
            if (end != null) {
                if (this.f16752i.isEmpty()) {
                    this.f16752i = new ArrayList();
                }
                this.f16752i.add(end);
            }
            return this;
        }

        public Option addEndCity(EndCity endCity) {
            if (endCity != null) {
                if (this.f16757n.isEmpty()) {
                    this.f16757n = new ArrayList();
                }
                this.f16757n.add(endCity);
            }
            return this;
        }

        public final Option clear() {
            clearTotal();
            clearExptime();
            clearSy();
            clearStart();
            clearEnd();
            clearAvoidJam();
            clearStartCity();
            clearEndCity();
            this.f16758o = -1;
            return this;
        }

        public Option clearAvoidJam() {
            this.f16753j = false;
            this.f16754k = 0;
            return this;
        }

        public Option clearEnd() {
            this.f16752i = Collections.emptyList();
            return this;
        }

        public Option clearEndCity() {
            this.f16757n = Collections.emptyList();
            return this;
        }

        public Option clearExptime() {
            this.f16746c = false;
            this.f16747d = "";
            return this;
        }

        public Option clearStart() {
            this.f16750g = false;
            this.f16751h = null;
            return this;
        }

        public Option clearStartCity() {
            this.f16755l = false;
            this.f16756m = null;
            return this;
        }

        public Option clearSy() {
            this.f16748e = false;
            this.f16749f = 0;
            return this;
        }

        public Option clearTotal() {
            this.f16744a = false;
            this.f16745b = 0;
            return this;
        }

        public int getAvoidJam() {
            return this.f16754k;
        }

        public int getCachedSize() {
            if (this.f16758o < 0) {
                getSerializedSize();
            }
            return this.f16758o;
        }

        public End getEnd(int i) {
            return (End) this.f16752i.get(i);
        }

        public EndCity getEndCity(int i) {
            return (EndCity) this.f16757n.get(i);
        }

        public int getEndCityCount() {
            return this.f16757n.size();
        }

        public List<EndCity> getEndCityList() {
            return this.f16757n;
        }

        public int getEndCount() {
            return this.f16752i.size();
        }

        public List<End> getEndList() {
            return this.f16752i;
        }

        public String getExptime() {
            return this.f16747d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTotal()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getTotal());
            }
            if (hasExptime()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getExptime());
            }
            if (hasSy()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getSy());
            }
            if (hasStart()) {
                i += CodedOutputStreamMicro.computeMessageSize(4, getStart());
            }
            int i2 = i;
            for (End computeMessageSize : getEndList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(5, computeMessageSize) + i2;
            }
            if (hasAvoidJam()) {
                i2 += CodedOutputStreamMicro.computeInt32Size(6, getAvoidJam());
            }
            if (hasStartCity()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(7, getStartCity());
            }
            for (EndCity computeMessageSize2 : getEndCityList()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(8, computeMessageSize2);
            }
            this.f16758o = i2;
            return i2;
        }

        public Start getStart() {
            return this.f16751h;
        }

        public StartCity getStartCity() {
            return this.f16756m;
        }

        public int getSy() {
            return this.f16749f;
        }

        public int getTotal() {
            return this.f16745b;
        }

        public boolean hasAvoidJam() {
            return this.f16753j;
        }

        public boolean hasExptime() {
            return this.f16746c;
        }

        public boolean hasStart() {
            return this.f16750g;
        }

        public boolean hasStartCity() {
            return this.f16755l;
        }

        public boolean hasSy() {
            return this.f16748e;
        }

        public boolean hasTotal() {
            return this.f16744a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Option mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro start;
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setTotal(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setExptime(codedInputStreamMicro.readString());
                        continue;
                    case 24:
                        setSy(codedInputStreamMicro.readInt32());
                        continue;
                    case 34:
                        start = new Start();
                        codedInputStreamMicro.readMessage(start);
                        setStart(start);
                        continue;
                    case 42:
                        start = new End();
                        codedInputStreamMicro.readMessage(start);
                        addEnd(start);
                        continue;
                    case 48:
                        setAvoidJam(codedInputStreamMicro.readInt32());
                        continue;
                    case 58:
                        start = new StartCity();
                        codedInputStreamMicro.readMessage(start);
                        setStartCity(start);
                        continue;
                    case 66:
                        start = new EndCity();
                        codedInputStreamMicro.readMessage(start);
                        addEndCity(start);
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

        public Option setAvoidJam(int i) {
            this.f16753j = true;
            this.f16754k = i;
            return this;
        }

        public Option setEnd(int i, End end) {
            if (end != null) {
                this.f16752i.set(i, end);
            }
            return this;
        }

        public Option setEndCity(int i, EndCity endCity) {
            if (endCity != null) {
                this.f16757n.set(i, endCity);
            }
            return this;
        }

        public Option setExptime(String str) {
            this.f16746c = true;
            this.f16747d = str;
            return this;
        }

        public Option setStart(Start start) {
            if (start == null) {
                return clearStart();
            }
            this.f16750g = true;
            this.f16751h = start;
            return this;
        }

        public Option setStartCity(StartCity startCity) {
            if (startCity == null) {
                return clearStartCity();
            }
            this.f16755l = true;
            this.f16756m = startCity;
            return this;
        }

        public Option setSy(int i) {
            this.f16748e = true;
            this.f16749f = i;
            return this;
        }

        public Option setTotal(int i) {
            this.f16744a = true;
            this.f16745b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTotal()) {
                codedOutputStreamMicro.writeInt32(1, getTotal());
            }
            if (hasExptime()) {
                codedOutputStreamMicro.writeString(2, getExptime());
            }
            if (hasSy()) {
                codedOutputStreamMicro.writeInt32(3, getSy());
            }
            if (hasStart()) {
                codedOutputStreamMicro.writeMessage(4, getStart());
            }
            for (End writeMessage : getEndList()) {
                codedOutputStreamMicro.writeMessage(5, writeMessage);
            }
            if (hasAvoidJam()) {
                codedOutputStreamMicro.writeInt32(6, getAvoidJam());
            }
            if (hasStartCity()) {
                codedOutputStreamMicro.writeMessage(7, getStartCity());
            }
            for (EndCity writeMessage2 : getEndCityList()) {
                codedOutputStreamMicro.writeMessage(8, writeMessage2);
            }
        }
    }

    public static final class Routes extends MessageMicro {
        public static final int LEGS_FIELD_NUMBER = 1;
        /* renamed from: a */
        private List<Legs> f16795a = Collections.emptyList();
        /* renamed from: b */
        private int f16796b = -1;

        public static final class Legs extends MessageMicro {
            public static final int DISTANCE_FIELD_NUMBER = 1;
            public static final int DURATION_FIELD_NUMBER = 2;
            public static final int END_LOCATION_FIELD_NUMBER = 3;
            public static final int SEND_LOCATION_FIELD_NUMBER = 6;
            public static final int SSTART_LOCATION_FIELD_NUMBER = 7;
            public static final int START_LOCATION_FIELD_NUMBER = 4;
            public static final int STEPS_FIELD_NUMBER = 5;
            /* renamed from: a */
            private boolean f16783a;
            /* renamed from: b */
            private int f16784b = 0;
            /* renamed from: c */
            private boolean f16785c;
            /* renamed from: d */
            private int f16786d = 0;
            /* renamed from: e */
            private boolean f16787e;
            /* renamed from: f */
            private String f16788f = "";
            /* renamed from: g */
            private boolean f16789g;
            /* renamed from: h */
            private String f16790h = "";
            /* renamed from: i */
            private List<Steps> f16791i = Collections.emptyList();
            /* renamed from: j */
            private List<Integer> f16792j = Collections.emptyList();
            /* renamed from: k */
            private List<Integer> f16793k = Collections.emptyList();
            /* renamed from: l */
            private int f16794l = -1;

            public static final class Steps extends MessageMicro {
                public static final int DIRECTION_FIELD_NUMBER = 7;
                public static final int DISTANCE_FIELD_NUMBER = 1;
                public static final int DURATION_FIELD_NUMBER = 2;
                public static final int END_INSTRUCTIONS_FIELD_NUMBER = 8;
                public static final int END_LOCATION_FIELD_NUMBER = 3;
                public static final int INSTRUCTIONS_FIELD_NUMBER = 5;
                public static final int PATH_FIELD_NUMBER = 6;
                public static final int SEND_LOCATION_FIELD_NUMBER = 11;
                public static final int SPATH_FIELD_NUMBER = 13;
                public static final int SSTART_LOCATION_FIELD_NUMBER = 12;
                public static final int START_INSTRUCTIONS_FIELD_NUMBER = 9;
                public static final int START_LOCATION_FIELD_NUMBER = 4;
                public static final int TURN_FIELD_NUMBER = 10;
                /* renamed from: a */
                private boolean f16759a;
                /* renamed from: b */
                private int f16760b = 0;
                /* renamed from: c */
                private boolean f16761c;
                /* renamed from: d */
                private int f16762d = 0;
                /* renamed from: e */
                private boolean f16763e;
                /* renamed from: f */
                private String f16764f = "";
                /* renamed from: g */
                private boolean f16765g;
                /* renamed from: h */
                private String f16766h = "";
                /* renamed from: i */
                private boolean f16767i;
                /* renamed from: j */
                private String f16768j = "";
                /* renamed from: k */
                private boolean f16769k;
                /* renamed from: l */
                private String f16770l = "";
                /* renamed from: m */
                private boolean f16771m;
                /* renamed from: n */
                private int f16772n = 0;
                /* renamed from: o */
                private boolean f16773o;
                /* renamed from: p */
                private String f16774p = "";
                /* renamed from: q */
                private boolean f16775q;
                /* renamed from: r */
                private String f16776r = "";
                /* renamed from: s */
                private boolean f16777s;
                /* renamed from: t */
                private int f16778t = 0;
                /* renamed from: u */
                private List<Integer> f16779u = Collections.emptyList();
                /* renamed from: v */
                private List<Integer> f16780v = Collections.emptyList();
                /* renamed from: w */
                private List<Integer> f16781w = Collections.emptyList();
                /* renamed from: x */
                private int f16782x = -1;

                public static Steps parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Steps().mergeFrom(codedInputStreamMicro);
                }

                public static Steps parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Steps) new Steps().mergeFrom(bArr);
                }

                public Steps addSendLocation(int i) {
                    if (this.f16779u.isEmpty()) {
                        this.f16779u = new ArrayList();
                    }
                    this.f16779u.add(Integer.valueOf(i));
                    return this;
                }

                public Steps addSpath(int i) {
                    if (this.f16781w.isEmpty()) {
                        this.f16781w = new ArrayList();
                    }
                    this.f16781w.add(Integer.valueOf(i));
                    return this;
                }

                public Steps addSstartLocation(int i) {
                    if (this.f16780v.isEmpty()) {
                        this.f16780v = new ArrayList();
                    }
                    this.f16780v.add(Integer.valueOf(i));
                    return this;
                }

                public final Steps clear() {
                    clearDistance();
                    clearDuration();
                    clearEndLocation();
                    clearStartLocation();
                    clearInstructions();
                    clearPath();
                    clearDirection();
                    clearEndInstructions();
                    clearStartInstructions();
                    clearTurn();
                    clearSendLocation();
                    clearSstartLocation();
                    clearSpath();
                    this.f16782x = -1;
                    return this;
                }

                public Steps clearDirection() {
                    this.f16771m = false;
                    this.f16772n = 0;
                    return this;
                }

                public Steps clearDistance() {
                    this.f16759a = false;
                    this.f16760b = 0;
                    return this;
                }

                public Steps clearDuration() {
                    this.f16761c = false;
                    this.f16762d = 0;
                    return this;
                }

                public Steps clearEndInstructions() {
                    this.f16773o = false;
                    this.f16774p = "";
                    return this;
                }

                public Steps clearEndLocation() {
                    this.f16763e = false;
                    this.f16764f = "";
                    return this;
                }

                public Steps clearInstructions() {
                    this.f16767i = false;
                    this.f16768j = "";
                    return this;
                }

                public Steps clearPath() {
                    this.f16769k = false;
                    this.f16770l = "";
                    return this;
                }

                public Steps clearSendLocation() {
                    this.f16779u = Collections.emptyList();
                    return this;
                }

                public Steps clearSpath() {
                    this.f16781w = Collections.emptyList();
                    return this;
                }

                public Steps clearSstartLocation() {
                    this.f16780v = Collections.emptyList();
                    return this;
                }

                public Steps clearStartInstructions() {
                    this.f16775q = false;
                    this.f16776r = "";
                    return this;
                }

                public Steps clearStartLocation() {
                    this.f16765g = false;
                    this.f16766h = "";
                    return this;
                }

                public Steps clearTurn() {
                    this.f16777s = false;
                    this.f16778t = 0;
                    return this;
                }

                public int getCachedSize() {
                    if (this.f16782x < 0) {
                        getSerializedSize();
                    }
                    return this.f16782x;
                }

                public int getDirection() {
                    return this.f16772n;
                }

                public int getDistance() {
                    return this.f16760b;
                }

                public int getDuration() {
                    return this.f16762d;
                }

                public String getEndInstructions() {
                    return this.f16774p;
                }

                public String getEndLocation() {
                    return this.f16764f;
                }

                public String getInstructions() {
                    return this.f16768j;
                }

                public String getPath() {
                    return this.f16770l;
                }

                public int getSendLocation(int i) {
                    return ((Integer) this.f16779u.get(i)).intValue();
                }

                public int getSendLocationCount() {
                    return this.f16779u.size();
                }

                public List<Integer> getSendLocationList() {
                    return this.f16779u;
                }

                public int getSerializedSize() {
                    int i = 0;
                    int computeInt32Size = hasDistance() ? CodedOutputStreamMicro.computeInt32Size(1, getDistance()) + 0 : 0;
                    if (hasDuration()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getDuration());
                    }
                    if (hasEndLocation()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getEndLocation());
                    }
                    if (hasStartLocation()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getStartLocation());
                    }
                    if (hasInstructions()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(5, getInstructions());
                    }
                    if (hasPath()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(6, getPath());
                    }
                    if (hasDirection()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(7, getDirection());
                    }
                    if (hasEndInstructions()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(8, getEndInstructions());
                    }
                    if (hasStartInstructions()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(9, getStartInstructions());
                    }
                    int computeInt32Size2 = hasTurn() ? computeInt32Size + CodedOutputStreamMicro.computeInt32Size(10, getTurn()) : computeInt32Size;
                    int i2 = 0;
                    for (Integer intValue : getSendLocationList()) {
                        i2 = CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue()) + i2;
                    }
                    i2 = (computeInt32Size2 + i2) + (getSendLocationList().size() * 1);
                    computeInt32Size2 = 0;
                    for (Integer intValue2 : getSstartLocationList()) {
                        computeInt32Size2 = CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue2.intValue()) + computeInt32Size2;
                    }
                    computeInt32Size2 = (getSstartLocationList().size() * 1) + (i2 + computeInt32Size2);
                    for (Integer intValue22 : getSpathList()) {
                        i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue22.intValue());
                    }
                    computeInt32Size = (computeInt32Size2 + i) + (getSpathList().size() * 1);
                    this.f16782x = computeInt32Size;
                    return computeInt32Size;
                }

                public int getSpath(int i) {
                    return ((Integer) this.f16781w.get(i)).intValue();
                }

                public int getSpathCount() {
                    return this.f16781w.size();
                }

                public List<Integer> getSpathList() {
                    return this.f16781w;
                }

                public int getSstartLocation(int i) {
                    return ((Integer) this.f16780v.get(i)).intValue();
                }

                public int getSstartLocationCount() {
                    return this.f16780v.size();
                }

                public List<Integer> getSstartLocationList() {
                    return this.f16780v;
                }

                public String getStartInstructions() {
                    return this.f16776r;
                }

                public String getStartLocation() {
                    return this.f16766h;
                }

                public int getTurn() {
                    return this.f16778t;
                }

                public boolean hasDirection() {
                    return this.f16771m;
                }

                public boolean hasDistance() {
                    return this.f16759a;
                }

                public boolean hasDuration() {
                    return this.f16761c;
                }

                public boolean hasEndInstructions() {
                    return this.f16773o;
                }

                public boolean hasEndLocation() {
                    return this.f16763e;
                }

                public boolean hasInstructions() {
                    return this.f16767i;
                }

                public boolean hasPath() {
                    return this.f16769k;
                }

                public boolean hasStartInstructions() {
                    return this.f16775q;
                }

                public boolean hasStartLocation() {
                    return this.f16765g;
                }

                public boolean hasTurn() {
                    return this.f16777s;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Steps mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                setDistance(codedInputStreamMicro.readInt32());
                                continue;
                            case 16:
                                setDuration(codedInputStreamMicro.readInt32());
                                continue;
                            case 26:
                                setEndLocation(codedInputStreamMicro.readString());
                                continue;
                            case 34:
                                setStartLocation(codedInputStreamMicro.readString());
                                continue;
                            case 42:
                                setInstructions(codedInputStreamMicro.readString());
                                continue;
                            case 50:
                                setPath(codedInputStreamMicro.readString());
                                continue;
                            case 56:
                                setDirection(codedInputStreamMicro.readInt32());
                                continue;
                            case 66:
                                setEndInstructions(codedInputStreamMicro.readString());
                                continue;
                            case 74:
                                setStartInstructions(codedInputStreamMicro.readString());
                                continue;
                            case 80:
                                setTurn(codedInputStreamMicro.readInt32());
                                continue;
                            case 88:
                                addSendLocation(codedInputStreamMicro.readSInt32());
                                continue;
                            case 96:
                                addSstartLocation(codedInputStreamMicro.readSInt32());
                                continue;
                            case 104:
                                addSpath(codedInputStreamMicro.readSInt32());
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

                public Steps setDirection(int i) {
                    this.f16771m = true;
                    this.f16772n = i;
                    return this;
                }

                public Steps setDistance(int i) {
                    this.f16759a = true;
                    this.f16760b = i;
                    return this;
                }

                public Steps setDuration(int i) {
                    this.f16761c = true;
                    this.f16762d = i;
                    return this;
                }

                public Steps setEndInstructions(String str) {
                    this.f16773o = true;
                    this.f16774p = str;
                    return this;
                }

                public Steps setEndLocation(String str) {
                    this.f16763e = true;
                    this.f16764f = str;
                    return this;
                }

                public Steps setInstructions(String str) {
                    this.f16767i = true;
                    this.f16768j = str;
                    return this;
                }

                public Steps setPath(String str) {
                    this.f16769k = true;
                    this.f16770l = str;
                    return this;
                }

                public Steps setSendLocation(int i, int i2) {
                    this.f16779u.set(i, Integer.valueOf(i2));
                    return this;
                }

                public Steps setSpath(int i, int i2) {
                    this.f16781w.set(i, Integer.valueOf(i2));
                    return this;
                }

                public Steps setSstartLocation(int i, int i2) {
                    this.f16780v.set(i, Integer.valueOf(i2));
                    return this;
                }

                public Steps setStartInstructions(String str) {
                    this.f16775q = true;
                    this.f16776r = str;
                    return this;
                }

                public Steps setStartLocation(String str) {
                    this.f16765g = true;
                    this.f16766h = str;
                    return this;
                }

                public Steps setTurn(int i) {
                    this.f16777s = true;
                    this.f16778t = i;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasDistance()) {
                        codedOutputStreamMicro.writeInt32(1, getDistance());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(2, getDuration());
                    }
                    if (hasEndLocation()) {
                        codedOutputStreamMicro.writeString(3, getEndLocation());
                    }
                    if (hasStartLocation()) {
                        codedOutputStreamMicro.writeString(4, getStartLocation());
                    }
                    if (hasInstructions()) {
                        codedOutputStreamMicro.writeString(5, getInstructions());
                    }
                    if (hasPath()) {
                        codedOutputStreamMicro.writeString(6, getPath());
                    }
                    if (hasDirection()) {
                        codedOutputStreamMicro.writeInt32(7, getDirection());
                    }
                    if (hasEndInstructions()) {
                        codedOutputStreamMicro.writeString(8, getEndInstructions());
                    }
                    if (hasStartInstructions()) {
                        codedOutputStreamMicro.writeString(9, getStartInstructions());
                    }
                    if (hasTurn()) {
                        codedOutputStreamMicro.writeInt32(10, getTurn());
                    }
                    for (Integer intValue : getSendLocationList()) {
                        codedOutputStreamMicro.writeSInt32(11, intValue.intValue());
                    }
                    for (Integer intValue2 : getSstartLocationList()) {
                        codedOutputStreamMicro.writeSInt32(12, intValue2.intValue());
                    }
                    for (Integer intValue22 : getSpathList()) {
                        codedOutputStreamMicro.writeSInt32(13, intValue22.intValue());
                    }
                }
            }

            public static Legs parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Legs().mergeFrom(codedInputStreamMicro);
            }

            public static Legs parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Legs) new Legs().mergeFrom(bArr);
            }

            public Legs addSendLocation(int i) {
                if (this.f16792j.isEmpty()) {
                    this.f16792j = new ArrayList();
                }
                this.f16792j.add(Integer.valueOf(i));
                return this;
            }

            public Legs addSstartLocation(int i) {
                if (this.f16793k.isEmpty()) {
                    this.f16793k = new ArrayList();
                }
                this.f16793k.add(Integer.valueOf(i));
                return this;
            }

            public Legs addSteps(Steps steps) {
                if (steps != null) {
                    if (this.f16791i.isEmpty()) {
                        this.f16791i = new ArrayList();
                    }
                    this.f16791i.add(steps);
                }
                return this;
            }

            public final Legs clear() {
                clearDistance();
                clearDuration();
                clearEndLocation();
                clearStartLocation();
                clearSteps();
                clearSendLocation();
                clearSstartLocation();
                this.f16794l = -1;
                return this;
            }

            public Legs clearDistance() {
                this.f16783a = false;
                this.f16784b = 0;
                return this;
            }

            public Legs clearDuration() {
                this.f16785c = false;
                this.f16786d = 0;
                return this;
            }

            public Legs clearEndLocation() {
                this.f16787e = false;
                this.f16788f = "";
                return this;
            }

            public Legs clearSendLocation() {
                this.f16792j = Collections.emptyList();
                return this;
            }

            public Legs clearSstartLocation() {
                this.f16793k = Collections.emptyList();
                return this;
            }

            public Legs clearStartLocation() {
                this.f16789g = false;
                this.f16790h = "";
                return this;
            }

            public Legs clearSteps() {
                this.f16791i = Collections.emptyList();
                return this;
            }

            public int getCachedSize() {
                if (this.f16794l < 0) {
                    getSerializedSize();
                }
                return this.f16794l;
            }

            public int getDistance() {
                return this.f16784b;
            }

            public int getDuration() {
                return this.f16786d;
            }

            public String getEndLocation() {
                return this.f16788f;
            }

            public int getSendLocation(int i) {
                return ((Integer) this.f16792j.get(i)).intValue();
            }

            public int getSendLocationCount() {
                return this.f16792j.size();
            }

            public List<Integer> getSendLocationList() {
                return this.f16792j;
            }

            public int getSerializedSize() {
                int i = 0;
                int computeInt32Size = hasDistance() ? CodedOutputStreamMicro.computeInt32Size(1, getDistance()) + 0 : 0;
                if (hasDuration()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getDuration());
                }
                if (hasEndLocation()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getEndLocation());
                }
                if (hasStartLocation()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getStartLocation());
                }
                int i2 = computeInt32Size;
                for (Steps computeMessageSize : getStepsList()) {
                    i2 = CodedOutputStreamMicro.computeMessageSize(5, computeMessageSize) + i2;
                }
                int i3 = 0;
                for (Integer intValue : getSendLocationList()) {
                    i3 = CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue()) + i3;
                }
                i2 = (getSendLocationList().size() * 1) + (i2 + i3);
                for (Integer intValue2 : getSstartLocationList()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue2.intValue());
                }
                computeInt32Size = (i2 + i) + (getSstartLocationList().size() * 1);
                this.f16794l = computeInt32Size;
                return computeInt32Size;
            }

            public int getSstartLocation(int i) {
                return ((Integer) this.f16793k.get(i)).intValue();
            }

            public int getSstartLocationCount() {
                return this.f16793k.size();
            }

            public List<Integer> getSstartLocationList() {
                return this.f16793k;
            }

            public String getStartLocation() {
                return this.f16790h;
            }

            public Steps getSteps(int i) {
                return (Steps) this.f16791i.get(i);
            }

            public int getStepsCount() {
                return this.f16791i.size();
            }

            public List<Steps> getStepsList() {
                return this.f16791i;
            }

            public boolean hasDistance() {
                return this.f16783a;
            }

            public boolean hasDuration() {
                return this.f16785c;
            }

            public boolean hasEndLocation() {
                return this.f16787e;
            }

            public boolean hasStartLocation() {
                return this.f16789g;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Legs mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            setDistance(codedInputStreamMicro.readInt32());
                            continue;
                        case 16:
                            setDuration(codedInputStreamMicro.readInt32());
                            continue;
                        case 26:
                            setEndLocation(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setStartLocation(codedInputStreamMicro.readString());
                            continue;
                        case 42:
                            MessageMicro steps = new Steps();
                            codedInputStreamMicro.readMessage(steps);
                            addSteps(steps);
                            continue;
                        case 48:
                            addSendLocation(codedInputStreamMicro.readSInt32());
                            continue;
                        case 56:
                            addSstartLocation(codedInputStreamMicro.readSInt32());
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

            public Legs setDistance(int i) {
                this.f16783a = true;
                this.f16784b = i;
                return this;
            }

            public Legs setDuration(int i) {
                this.f16785c = true;
                this.f16786d = i;
                return this;
            }

            public Legs setEndLocation(String str) {
                this.f16787e = true;
                this.f16788f = str;
                return this;
            }

            public Legs setSendLocation(int i, int i2) {
                this.f16792j.set(i, Integer.valueOf(i2));
                return this;
            }

            public Legs setSstartLocation(int i, int i2) {
                this.f16793k.set(i, Integer.valueOf(i2));
                return this;
            }

            public Legs setStartLocation(String str) {
                this.f16789g = true;
                this.f16790h = str;
                return this;
            }

            public Legs setSteps(int i, Steps steps) {
                if (steps != null) {
                    this.f16791i.set(i, steps);
                }
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasDistance()) {
                    codedOutputStreamMicro.writeInt32(1, getDistance());
                }
                if (hasDuration()) {
                    codedOutputStreamMicro.writeInt32(2, getDuration());
                }
                if (hasEndLocation()) {
                    codedOutputStreamMicro.writeString(3, getEndLocation());
                }
                if (hasStartLocation()) {
                    codedOutputStreamMicro.writeString(4, getStartLocation());
                }
                for (Steps writeMessage : getStepsList()) {
                    codedOutputStreamMicro.writeMessage(5, writeMessage);
                }
                for (Integer intValue : getSendLocationList()) {
                    codedOutputStreamMicro.writeSInt32(6, intValue.intValue());
                }
                for (Integer intValue2 : getSstartLocationList()) {
                    codedOutputStreamMicro.writeSInt32(7, intValue2.intValue());
                }
            }
        }

        public static Routes parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Routes().mergeFrom(codedInputStreamMicro);
        }

        public static Routes parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Routes) new Routes().mergeFrom(bArr);
        }

        public Routes addLegs(Legs legs) {
            if (legs != null) {
                if (this.f16795a.isEmpty()) {
                    this.f16795a = new ArrayList();
                }
                this.f16795a.add(legs);
            }
            return this;
        }

        public final Routes clear() {
            clearLegs();
            this.f16796b = -1;
            return this;
        }

        public Routes clearLegs() {
            this.f16795a = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f16796b < 0) {
                getSerializedSize();
            }
            return this.f16796b;
        }

        public Legs getLegs(int i) {
            return (Legs) this.f16795a.get(i);
        }

        public int getLegsCount() {
            return this.f16795a.size();
        }

        public List<Legs> getLegsList() {
            return this.f16795a;
        }

        public int getSerializedSize() {
            int i = 0;
            for (Legs computeMessageSize : getLegsList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            this.f16796b = i;
            return i;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Routes mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        MessageMicro legs = new Legs();
                        codedInputStreamMicro.readMessage(legs);
                        addLegs(legs);
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

        public Routes setLegs(int i, Legs legs) {
            if (legs != null) {
                this.f16795a.set(i, legs);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (Legs writeMessage : getLegsList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
        }
    }

    public static final class Taxi extends MessageMicro {
        public static final int DETAIL_FIELD_NUMBER = 4;
        public static final int DISTANCE_FIELD_NUMBER = 1;
        public static final int DURATION_FIELD_NUMBER = 2;
        public static final int REMARK_FIELD_NUMBER = 3;
        /* renamed from: a */
        private boolean f16806a;
        /* renamed from: b */
        private int f16807b = 0;
        /* renamed from: c */
        private boolean f16808c;
        /* renamed from: d */
        private int f16809d = 0;
        /* renamed from: e */
        private boolean f16810e;
        /* renamed from: f */
        private String f16811f = "";
        /* renamed from: g */
        private List<Detail> f16812g = Collections.emptyList();
        /* renamed from: h */
        private int f16813h = -1;

        public static final class Detail extends MessageMicro {
            public static final int DESC_FIELD_NUMBER = 1;
            public static final int KM_PRICE_FIELD_NUMBER = 2;
            public static final int START_PRICE_FIELD_NUMBER = 3;
            public static final int TOTAL_PRICE_FIELD_NUMBER = 4;
            /* renamed from: a */
            private boolean f16797a;
            /* renamed from: b */
            private String f16798b = "";
            /* renamed from: c */
            private boolean f16799c;
            /* renamed from: d */
            private String f16800d = "";
            /* renamed from: e */
            private boolean f16801e;
            /* renamed from: f */
            private String f16802f = "";
            /* renamed from: g */
            private boolean f16803g;
            /* renamed from: h */
            private String f16804h = "";
            /* renamed from: i */
            private int f16805i = -1;

            public static Detail parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Detail().mergeFrom(codedInputStreamMicro);
            }

            public static Detail parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Detail) new Detail().mergeFrom(bArr);
            }

            public final Detail clear() {
                clearDesc();
                clearKmPrice();
                clearStartPrice();
                clearTotalPrice();
                this.f16805i = -1;
                return this;
            }

            public Detail clearDesc() {
                this.f16797a = false;
                this.f16798b = "";
                return this;
            }

            public Detail clearKmPrice() {
                this.f16799c = false;
                this.f16800d = "";
                return this;
            }

            public Detail clearStartPrice() {
                this.f16801e = false;
                this.f16802f = "";
                return this;
            }

            public Detail clearTotalPrice() {
                this.f16803g = false;
                this.f16804h = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f16805i < 0) {
                    getSerializedSize();
                }
                return this.f16805i;
            }

            public String getDesc() {
                return this.f16798b;
            }

            public String getKmPrice() {
                return this.f16800d;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasDesc()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getDesc());
                }
                if (hasKmPrice()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getKmPrice());
                }
                if (hasStartPrice()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getStartPrice());
                }
                if (hasTotalPrice()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getTotalPrice());
                }
                this.f16805i = i;
                return i;
            }

            public String getStartPrice() {
                return this.f16802f;
            }

            public String getTotalPrice() {
                return this.f16804h;
            }

            public boolean hasDesc() {
                return this.f16797a;
            }

            public boolean hasKmPrice() {
                return this.f16799c;
            }

            public boolean hasStartPrice() {
                return this.f16801e;
            }

            public boolean hasTotalPrice() {
                return this.f16803g;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Detail mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setDesc(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setKmPrice(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setStartPrice(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setTotalPrice(codedInputStreamMicro.readString());
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

            public Detail setDesc(String str) {
                this.f16797a = true;
                this.f16798b = str;
                return this;
            }

            public Detail setKmPrice(String str) {
                this.f16799c = true;
                this.f16800d = str;
                return this;
            }

            public Detail setStartPrice(String str) {
                this.f16801e = true;
                this.f16802f = str;
                return this;
            }

            public Detail setTotalPrice(String str) {
                this.f16803g = true;
                this.f16804h = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasDesc()) {
                    codedOutputStreamMicro.writeString(1, getDesc());
                }
                if (hasKmPrice()) {
                    codedOutputStreamMicro.writeString(2, getKmPrice());
                }
                if (hasStartPrice()) {
                    codedOutputStreamMicro.writeString(3, getStartPrice());
                }
                if (hasTotalPrice()) {
                    codedOutputStreamMicro.writeString(4, getTotalPrice());
                }
            }
        }

        public static Taxi parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Taxi().mergeFrom(codedInputStreamMicro);
        }

        public static Taxi parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Taxi) new Taxi().mergeFrom(bArr);
        }

        public Taxi addDetail(Detail detail) {
            if (detail != null) {
                if (this.f16812g.isEmpty()) {
                    this.f16812g = new ArrayList();
                }
                this.f16812g.add(detail);
            }
            return this;
        }

        public final Taxi clear() {
            clearDistance();
            clearDuration();
            clearRemark();
            clearDetail();
            this.f16813h = -1;
            return this;
        }

        public Taxi clearDetail() {
            this.f16812g = Collections.emptyList();
            return this;
        }

        public Taxi clearDistance() {
            this.f16806a = false;
            this.f16807b = 0;
            return this;
        }

        public Taxi clearDuration() {
            this.f16808c = false;
            this.f16809d = 0;
            return this;
        }

        public Taxi clearRemark() {
            this.f16810e = false;
            this.f16811f = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f16813h < 0) {
                getSerializedSize();
            }
            return this.f16813h;
        }

        public Detail getDetail(int i) {
            return (Detail) this.f16812g.get(i);
        }

        public int getDetailCount() {
            return this.f16812g.size();
        }

        public List<Detail> getDetailList() {
            return this.f16812g;
        }

        public int getDistance() {
            return this.f16807b;
        }

        public int getDuration() {
            return this.f16809d;
        }

        public String getRemark() {
            return this.f16811f;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasDistance()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getDistance());
            }
            if (hasDuration()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getDuration());
            }
            if (hasRemark()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getRemark());
            }
            int i2 = i;
            for (Detail computeMessageSize : getDetailList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(4, computeMessageSize) + i2;
            }
            this.f16813h = i2;
            return i2;
        }

        public boolean hasDistance() {
            return this.f16806a;
        }

        public boolean hasDuration() {
            return this.f16808c;
        }

        public boolean hasRemark() {
            return this.f16810e;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Taxi mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setDistance(codedInputStreamMicro.readInt32());
                        continue;
                    case 16:
                        setDuration(codedInputStreamMicro.readInt32());
                        continue;
                    case 26:
                        setRemark(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        MessageMicro detail = new Detail();
                        codedInputStreamMicro.readMessage(detail);
                        addDetail(detail);
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

        public Taxi setDetail(int i, Detail detail) {
            if (detail != null) {
                this.f16812g.set(i, detail);
            }
            return this;
        }

        public Taxi setDistance(int i) {
            this.f16806a = true;
            this.f16807b = i;
            return this;
        }

        public Taxi setDuration(int i) {
            this.f16808c = true;
            this.f16809d = i;
            return this;
        }

        public Taxi setRemark(String str) {
            this.f16810e = true;
            this.f16811f = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasDistance()) {
                codedOutputStreamMicro.writeInt32(1, getDistance());
            }
            if (hasDuration()) {
                codedOutputStreamMicro.writeInt32(2, getDuration());
            }
            if (hasRemark()) {
                codedOutputStreamMicro.writeString(3, getRemark());
            }
            for (Detail writeMessage : getDetailList()) {
                codedOutputStreamMicro.writeMessage(4, writeMessage);
            }
        }
    }

    public static final class Traffic extends MessageMicro {
        public static final int ROUTES_FIELD_NUMBER = 1;
        /* renamed from: a */
        private List<Routes> f16823a = Collections.emptyList();
        /* renamed from: b */
        private int f16824b = -1;

        public static final class Routes extends MessageMicro {
            public static final int DIGES_FIELD_NUMBER = 1;
            public static final int LEGS_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f16819a;
            /* renamed from: b */
            private String f16820b = "";
            /* renamed from: c */
            private List<Legs> f16821c = Collections.emptyList();
            /* renamed from: d */
            private int f16822d = -1;

            public static final class Legs extends MessageMicro {
                public static final int STEPS_FIELD_NUMBER = 1;
                /* renamed from: a */
                private List<Steps> f16817a = Collections.emptyList();
                /* renamed from: b */
                private int f16818b = -1;

                public static final class Steps extends MessageMicro {
                    public static final int END_FIELD_NUMBER = 1;
                    public static final int STATUS_FIELD_NUMBER = 2;
                    /* renamed from: a */
                    private List<Integer> f16814a = Collections.emptyList();
                    /* renamed from: b */
                    private List<Integer> f16815b = Collections.emptyList();
                    /* renamed from: c */
                    private int f16816c = -1;

                    public static Steps parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Steps().mergeFrom(codedInputStreamMicro);
                    }

                    public static Steps parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Steps) new Steps().mergeFrom(bArr);
                    }

                    public Steps addEnd(int i) {
                        if (this.f16814a.isEmpty()) {
                            this.f16814a = new ArrayList();
                        }
                        this.f16814a.add(Integer.valueOf(i));
                        return this;
                    }

                    public Steps addStatus(int i) {
                        if (this.f16815b.isEmpty()) {
                            this.f16815b = new ArrayList();
                        }
                        this.f16815b.add(Integer.valueOf(i));
                        return this;
                    }

                    public final Steps clear() {
                        clearEnd();
                        clearStatus();
                        this.f16816c = -1;
                        return this;
                    }

                    public Steps clearEnd() {
                        this.f16814a = Collections.emptyList();
                        return this;
                    }

                    public Steps clearStatus() {
                        this.f16815b = Collections.emptyList();
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f16816c < 0) {
                            getSerializedSize();
                        }
                        return this.f16816c;
                    }

                    public int getEnd(int i) {
                        return ((Integer) this.f16814a.get(i)).intValue();
                    }

                    public int getEndCount() {
                        return this.f16814a.size();
                    }

                    public List<Integer> getEndList() {
                        return this.f16814a;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        int i2 = 0;
                        for (Integer intValue : getEndList()) {
                            i2 = CodedOutputStreamMicro.computeInt32SizeNoTag(intValue.intValue()) + i2;
                        }
                        i2 = (getEndList().size() * 1) + (0 + i2);
                        for (Integer intValue2 : getStatusList()) {
                            i += CodedOutputStreamMicro.computeInt32SizeNoTag(intValue2.intValue());
                        }
                        int size = (i2 + i) + (getStatusList().size() * 1);
                        this.f16816c = size;
                        return size;
                    }

                    public int getStatus(int i) {
                        return ((Integer) this.f16815b.get(i)).intValue();
                    }

                    public int getStatusCount() {
                        return this.f16815b.size();
                    }

                    public List<Integer> getStatusList() {
                        return this.f16815b;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Steps mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    addEnd(codedInputStreamMicro.readInt32());
                                    continue;
                                case 16:
                                    addStatus(codedInputStreamMicro.readInt32());
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

                    public Steps setEnd(int i, int i2) {
                        this.f16814a.set(i, Integer.valueOf(i2));
                        return this;
                    }

                    public Steps setStatus(int i, int i2) {
                        this.f16815b.set(i, Integer.valueOf(i2));
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        for (Integer intValue : getEndList()) {
                            codedOutputStreamMicro.writeInt32(1, intValue.intValue());
                        }
                        for (Integer intValue2 : getStatusList()) {
                            codedOutputStreamMicro.writeInt32(2, intValue2.intValue());
                        }
                    }
                }

                public static Legs parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Legs().mergeFrom(codedInputStreamMicro);
                }

                public static Legs parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Legs) new Legs().mergeFrom(bArr);
                }

                public Legs addSteps(Steps steps) {
                    if (steps != null) {
                        if (this.f16817a.isEmpty()) {
                            this.f16817a = new ArrayList();
                        }
                        this.f16817a.add(steps);
                    }
                    return this;
                }

                public final Legs clear() {
                    clearSteps();
                    this.f16818b = -1;
                    return this;
                }

                public Legs clearSteps() {
                    this.f16817a = Collections.emptyList();
                    return this;
                }

                public int getCachedSize() {
                    if (this.f16818b < 0) {
                        getSerializedSize();
                    }
                    return this.f16818b;
                }

                public int getSerializedSize() {
                    int i = 0;
                    for (Steps computeMessageSize : getStepsList()) {
                        i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
                    }
                    this.f16818b = i;
                    return i;
                }

                public Steps getSteps(int i) {
                    return (Steps) this.f16817a.get(i);
                }

                public int getStepsCount() {
                    return this.f16817a.size();
                }

                public List<Steps> getStepsList() {
                    return this.f16817a;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Legs mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                MessageMicro steps = new Steps();
                                codedInputStreamMicro.readMessage(steps);
                                addSteps(steps);
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

                public Legs setSteps(int i, Steps steps) {
                    if (steps != null) {
                        this.f16817a.set(i, steps);
                    }
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    for (Steps writeMessage : getStepsList()) {
                        codedOutputStreamMicro.writeMessage(1, writeMessage);
                    }
                }
            }

            public static Routes parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Routes().mergeFrom(codedInputStreamMicro);
            }

            public static Routes parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Routes) new Routes().mergeFrom(bArr);
            }

            public Routes addLegs(Legs legs) {
                if (legs != null) {
                    if (this.f16821c.isEmpty()) {
                        this.f16821c = new ArrayList();
                    }
                    this.f16821c.add(legs);
                }
                return this;
            }

            public final Routes clear() {
                clearDiges();
                clearLegs();
                this.f16822d = -1;
                return this;
            }

            public Routes clearDiges() {
                this.f16819a = false;
                this.f16820b = "";
                return this;
            }

            public Routes clearLegs() {
                this.f16821c = Collections.emptyList();
                return this;
            }

            public int getCachedSize() {
                if (this.f16822d < 0) {
                    getSerializedSize();
                }
                return this.f16822d;
            }

            public String getDiges() {
                return this.f16820b;
            }

            public Legs getLegs(int i) {
                return (Legs) this.f16821c.get(i);
            }

            public int getLegsCount() {
                return this.f16821c.size();
            }

            public List<Legs> getLegsList() {
                return this.f16821c;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasDiges()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getDiges());
                }
                int i2 = i;
                for (Legs computeMessageSize : getLegsList()) {
                    i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
                }
                this.f16822d = i2;
                return i2;
            }

            public boolean hasDiges() {
                return this.f16819a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Routes mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setDiges(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            MessageMicro legs = new Legs();
                            codedInputStreamMicro.readMessage(legs);
                            addLegs(legs);
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

            public Routes setDiges(String str) {
                this.f16819a = true;
                this.f16820b = str;
                return this;
            }

            public Routes setLegs(int i, Legs legs) {
                if (legs != null) {
                    this.f16821c.set(i, legs);
                }
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasDiges()) {
                    codedOutputStreamMicro.writeString(1, getDiges());
                }
                for (Legs writeMessage : getLegsList()) {
                    codedOutputStreamMicro.writeMessage(2, writeMessage);
                }
            }
        }

        public static Traffic parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Traffic().mergeFrom(codedInputStreamMicro);
        }

        public static Traffic parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Traffic) new Traffic().mergeFrom(bArr);
        }

        public Traffic addRoutes(Routes routes) {
            if (routes != null) {
                if (this.f16823a.isEmpty()) {
                    this.f16823a = new ArrayList();
                }
                this.f16823a.add(routes);
            }
            return this;
        }

        public final Traffic clear() {
            clearRoutes();
            this.f16824b = -1;
            return this;
        }

        public Traffic clearRoutes() {
            this.f16823a = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f16824b < 0) {
                getSerializedSize();
            }
            return this.f16824b;
        }

        public Routes getRoutes(int i) {
            return (Routes) this.f16823a.get(i);
        }

        public int getRoutesCount() {
            return this.f16823a.size();
        }

        public List<Routes> getRoutesList() {
            return this.f16823a;
        }

        public int getSerializedSize() {
            int i = 0;
            for (Routes computeMessageSize : getRoutesList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            this.f16824b = i;
            return i;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Traffic mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        MessageMicro routes = new Routes();
                        codedInputStreamMicro.readMessage(routes);
                        addRoutes(routes);
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

        public Traffic setRoutes(int i, Routes routes) {
            if (routes != null) {
                this.f16823a.set(i, routes);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (Routes writeMessage : getRoutesList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
        }
    }

    public static Walk parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Walk().mergeFrom(codedInputStreamMicro);
    }

    public static Walk parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Walk) new Walk().mergeFrom(bArr);
    }

    public Walk addRoutes(Routes routes) {
        if (routes != null) {
            if (this.f16829e.isEmpty()) {
                this.f16829e = new ArrayList();
            }
            this.f16829e.add(routes);
        }
        return this;
    }

    public final Walk clear() {
        clearTaxi();
        clearCurrentCity();
        clearRoutes();
        clearOption();
        clearTraffic();
        this.f16834j = -1;
        return this;
    }

    public Walk clearCurrentCity() {
        this.f16827c = false;
        this.f16828d = null;
        return this;
    }

    public Walk clearOption() {
        this.f16830f = false;
        this.f16831g = null;
        return this;
    }

    public Walk clearRoutes() {
        this.f16829e = Collections.emptyList();
        return this;
    }

    public Walk clearTaxi() {
        this.f16825a = false;
        this.f16826b = null;
        return this;
    }

    public Walk clearTraffic() {
        this.f16832h = false;
        this.f16833i = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f16834j < 0) {
            getSerializedSize();
        }
        return this.f16834j;
    }

    public CurrentCity getCurrentCity() {
        return this.f16828d;
    }

    public Option getOption() {
        return this.f16831g;
    }

    public Routes getRoutes(int i) {
        return (Routes) this.f16829e.get(i);
    }

    public int getRoutesCount() {
        return this.f16829e.size();
    }

    public List<Routes> getRoutesList() {
        return this.f16829e;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasTaxi()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getTaxi());
        }
        if (hasCurrentCity()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getCurrentCity());
        }
        int i2 = i;
        for (Routes computeMessageSize : getRoutesList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
        }
        if (hasOption()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(4, getOption());
        }
        if (hasTraffic()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(5, getTraffic());
        }
        this.f16834j = i2;
        return i2;
    }

    public Taxi getTaxi() {
        return this.f16826b;
    }

    public Traffic getTraffic() {
        return this.f16833i;
    }

    public boolean hasCurrentCity() {
        return this.f16827c;
    }

    public boolean hasOption() {
        return this.f16830f;
    }

    public boolean hasTaxi() {
        return this.f16825a;
    }

    public boolean hasTraffic() {
        return this.f16832h;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Walk mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro taxi;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    taxi = new Taxi();
                    codedInputStreamMicro.readMessage(taxi);
                    setTaxi(taxi);
                    continue;
                case 18:
                    taxi = new CurrentCity();
                    codedInputStreamMicro.readMessage(taxi);
                    setCurrentCity(taxi);
                    continue;
                case 26:
                    taxi = new Routes();
                    codedInputStreamMicro.readMessage(taxi);
                    addRoutes(taxi);
                    continue;
                case 34:
                    taxi = new Option();
                    codedInputStreamMicro.readMessage(taxi);
                    setOption(taxi);
                    continue;
                case 42:
                    taxi = new Traffic();
                    codedInputStreamMicro.readMessage(taxi);
                    setTraffic(taxi);
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

    public Walk setCurrentCity(CurrentCity currentCity) {
        if (currentCity == null) {
            return clearCurrentCity();
        }
        this.f16827c = true;
        this.f16828d = currentCity;
        return this;
    }

    public Walk setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f16830f = true;
        this.f16831g = option;
        return this;
    }

    public Walk setRoutes(int i, Routes routes) {
        if (routes != null) {
            this.f16829e.set(i, routes);
        }
        return this;
    }

    public Walk setTaxi(Taxi taxi) {
        if (taxi == null) {
            return clearTaxi();
        }
        this.f16825a = true;
        this.f16826b = taxi;
        return this;
    }

    public Walk setTraffic(Traffic traffic) {
        if (traffic == null) {
            return clearTraffic();
        }
        this.f16832h = true;
        this.f16833i = traffic;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasTaxi()) {
            codedOutputStreamMicro.writeMessage(1, getTaxi());
        }
        if (hasCurrentCity()) {
            codedOutputStreamMicro.writeMessage(2, getCurrentCity());
        }
        for (Routes writeMessage : getRoutesList()) {
            codedOutputStreamMicro.writeMessage(3, writeMessage);
        }
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(4, getOption());
        }
        if (hasTraffic()) {
            codedOutputStreamMicro.writeMessage(5, getTraffic());
        }
    }
}
