package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Car extends MessageMicro {
    public static final int CURRENT_CITY_FIELD_NUMBER = 2;
    public static final int OPTION_FIELD_NUMBER = 4;
    public static final int ROUTES_FIELD_NUMBER = 3;
    public static final int TAXI_FIELD_NUMBER = 1;
    public static final int TRAFFIC_FIELD_NUMBER = 5;
    /* renamed from: a */
    private boolean f10616a;
    /* renamed from: b */
    private Taxi f10617b = null;
    /* renamed from: c */
    private boolean f10618c;
    /* renamed from: d */
    private CurrentCity f10619d = null;
    /* renamed from: e */
    private List<Routes> f10620e = Collections.emptyList();
    /* renamed from: f */
    private boolean f10621f;
    /* renamed from: g */
    private Option f10622g = null;
    /* renamed from: h */
    private boolean f10623h;
    /* renamed from: i */
    private Traffic f10624i = null;
    /* renamed from: j */
    private int f10625j = -1;

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
        private boolean f10523a;
        /* renamed from: b */
        private int f10524b = 0;
        /* renamed from: c */
        private boolean f10525c;
        /* renamed from: d */
        private String f10526d = "";
        /* renamed from: e */
        private boolean f10527e;
        /* renamed from: f */
        private int f10528f = 0;
        /* renamed from: g */
        private boolean f10529g;
        /* renamed from: h */
        private Start f10530h = null;
        /* renamed from: i */
        private boolean f10531i;
        /* renamed from: j */
        private End f10532j = null;
        /* renamed from: k */
        private boolean f10533k;
        /* renamed from: l */
        private int f10534l = 0;
        /* renamed from: m */
        private boolean f10535m;
        /* renamed from: n */
        private StartCity f10536n = null;
        /* renamed from: o */
        private boolean f10537o;
        /* renamed from: p */
        private EndCity f10538p = null;
        /* renamed from: q */
        private int f10539q = -1;

        public static final class End extends MessageMicro {
            public static final int BUSSTOP_FIELD_NUMBER = 4;
            public static final int PT_FIELD_NUMBER = 1;
            public static final int SPT_FIELD_NUMBER = 5;
            public static final int UID_FIELD_NUMBER = 3;
            public static final int WD_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f10493a;
            /* renamed from: b */
            private String f10494b = "";
            /* renamed from: c */
            private boolean f10495c;
            /* renamed from: d */
            private String f10496d = "";
            /* renamed from: e */
            private boolean f10497e;
            /* renamed from: f */
            private String f10498f = "";
            /* renamed from: g */
            private boolean f10499g;
            /* renamed from: h */
            private boolean f10500h = false;
            /* renamed from: i */
            private List<Integer> f10501i = Collections.emptyList();
            /* renamed from: j */
            private int f10502j = -1;

            public static End parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new End().mergeFrom(codedInputStreamMicro);
            }

            public static End parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (End) new End().mergeFrom(bArr);
            }

            public End addSpt(int i) {
                if (this.f10501i.isEmpty()) {
                    this.f10501i = new ArrayList();
                }
                this.f10501i.add(Integer.valueOf(i));
                return this;
            }

            public final End clear() {
                clearPt();
                clearWd();
                clearUid();
                clearBusstop();
                clearSpt();
                this.f10502j = -1;
                return this;
            }

            public End clearBusstop() {
                this.f10499g = false;
                this.f10500h = false;
                return this;
            }

            public End clearPt() {
                this.f10493a = false;
                this.f10494b = "";
                return this;
            }

            public End clearSpt() {
                this.f10501i = Collections.emptyList();
                return this;
            }

            public End clearUid() {
                this.f10497e = false;
                this.f10498f = "";
                return this;
            }

            public End clearWd() {
                this.f10495c = false;
                this.f10496d = "";
                return this;
            }

            public boolean getBusstop() {
                return this.f10500h;
            }

            public int getCachedSize() {
                if (this.f10502j < 0) {
                    getSerializedSize();
                }
                return this.f10502j;
            }

            public String getPt() {
                return this.f10494b;
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
                int computeBoolSize = hasBusstop() ? computeStringSize + CodedOutputStreamMicro.computeBoolSize(4, getBusstop()) : computeStringSize;
                for (Integer intValue : getSptList()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue());
                }
                computeStringSize = (computeBoolSize + i) + (getSptList().size() * 1);
                this.f10502j = computeStringSize;
                return computeStringSize;
            }

            public int getSpt(int i) {
                return ((Integer) this.f10501i.get(i)).intValue();
            }

            public int getSptCount() {
                return this.f10501i.size();
            }

            public List<Integer> getSptList() {
                return this.f10501i;
            }

            public String getUid() {
                return this.f10498f;
            }

            public String getWd() {
                return this.f10496d;
            }

            public boolean hasBusstop() {
                return this.f10499g;
            }

            public boolean hasPt() {
                return this.f10493a;
            }

            public boolean hasUid() {
                return this.f10497e;
            }

            public boolean hasWd() {
                return this.f10495c;
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
                            setBusstop(codedInputStreamMicro.readBool());
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

            public End setBusstop(boolean z) {
                this.f10499g = true;
                this.f10500h = z;
                return this;
            }

            public End setPt(String str) {
                this.f10493a = true;
                this.f10494b = str;
                return this;
            }

            public End setSpt(int i, int i2) {
                this.f10501i.set(i, Integer.valueOf(i2));
                return this;
            }

            public End setUid(String str) {
                this.f10497e = true;
                this.f10498f = str;
                return this;
            }

            public End setWd(String str) {
                this.f10495c = true;
                this.f10496d = str;
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
                if (hasBusstop()) {
                    codedOutputStreamMicro.writeBool(4, getBusstop());
                }
                for (Integer intValue : getSptList()) {
                    codedOutputStreamMicro.writeSInt32(5, intValue.intValue());
                }
            }
        }

        public static final class EndCity extends MessageMicro {
            public static final int CODE_FIELD_NUMBER = 1;
            public static final int NAME_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f10503a;
            /* renamed from: b */
            private int f10504b = 0;
            /* renamed from: c */
            private boolean f10505c;
            /* renamed from: d */
            private String f10506d = "";
            /* renamed from: e */
            private int f10507e = -1;

            public static EndCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new EndCity().mergeFrom(codedInputStreamMicro);
            }

            public static EndCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (EndCity) new EndCity().mergeFrom(bArr);
            }

            public final EndCity clear() {
                clearCode();
                clearName();
                this.f10507e = -1;
                return this;
            }

            public EndCity clearCode() {
                this.f10503a = false;
                this.f10504b = 0;
                return this;
            }

            public EndCity clearName() {
                this.f10505c = false;
                this.f10506d = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f10507e < 0) {
                    getSerializedSize();
                }
                return this.f10507e;
            }

            public int getCode() {
                return this.f10504b;
            }

            public String getName() {
                return this.f10506d;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasCode()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
                }
                if (hasName()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getName());
                }
                this.f10507e = i;
                return i;
            }

            public boolean hasCode() {
                return this.f10503a;
            }

            public boolean hasName() {
                return this.f10505c;
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
                            setName(codedInputStreamMicro.readString());
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

            public EndCity setCode(int i) {
                this.f10503a = true;
                this.f10504b = i;
                return this;
            }

            public EndCity setName(String str) {
                this.f10505c = true;
                this.f10506d = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasCode()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (hasName()) {
                    codedOutputStreamMicro.writeString(2, getName());
                }
            }
        }

        public static final class Start extends MessageMicro {
            public static final int BUSSTOP_FIELD_NUMBER = 4;
            public static final int PT_FIELD_NUMBER = 1;
            public static final int SPT_FIELD_NUMBER = 5;
            public static final int UID_FIELD_NUMBER = 3;
            public static final int WD_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f10508a;
            /* renamed from: b */
            private String f10509b = "";
            /* renamed from: c */
            private boolean f10510c;
            /* renamed from: d */
            private String f10511d = "";
            /* renamed from: e */
            private boolean f10512e;
            /* renamed from: f */
            private String f10513f = "";
            /* renamed from: g */
            private boolean f10514g;
            /* renamed from: h */
            private boolean f10515h = false;
            /* renamed from: i */
            private List<Integer> f10516i = Collections.emptyList();
            /* renamed from: j */
            private int f10517j = -1;

            public static Start parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Start().mergeFrom(codedInputStreamMicro);
            }

            public static Start parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Start) new Start().mergeFrom(bArr);
            }

            public Start addSpt(int i) {
                if (this.f10516i.isEmpty()) {
                    this.f10516i = new ArrayList();
                }
                this.f10516i.add(Integer.valueOf(i));
                return this;
            }

            public final Start clear() {
                clearPt();
                clearWd();
                clearUid();
                clearBusstop();
                clearSpt();
                this.f10517j = -1;
                return this;
            }

            public Start clearBusstop() {
                this.f10514g = false;
                this.f10515h = false;
                return this;
            }

            public Start clearPt() {
                this.f10508a = false;
                this.f10509b = "";
                return this;
            }

            public Start clearSpt() {
                this.f10516i = Collections.emptyList();
                return this;
            }

            public Start clearUid() {
                this.f10512e = false;
                this.f10513f = "";
                return this;
            }

            public Start clearWd() {
                this.f10510c = false;
                this.f10511d = "";
                return this;
            }

            public boolean getBusstop() {
                return this.f10515h;
            }

            public int getCachedSize() {
                if (this.f10517j < 0) {
                    getSerializedSize();
                }
                return this.f10517j;
            }

            public String getPt() {
                return this.f10509b;
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
                int computeBoolSize = hasBusstop() ? computeStringSize + CodedOutputStreamMicro.computeBoolSize(4, getBusstop()) : computeStringSize;
                for (Integer intValue : getSptList()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue());
                }
                computeStringSize = (computeBoolSize + i) + (getSptList().size() * 1);
                this.f10517j = computeStringSize;
                return computeStringSize;
            }

            public int getSpt(int i) {
                return ((Integer) this.f10516i.get(i)).intValue();
            }

            public int getSptCount() {
                return this.f10516i.size();
            }

            public List<Integer> getSptList() {
                return this.f10516i;
            }

            public String getUid() {
                return this.f10513f;
            }

            public String getWd() {
                return this.f10511d;
            }

            public boolean hasBusstop() {
                return this.f10514g;
            }

            public boolean hasPt() {
                return this.f10508a;
            }

            public boolean hasUid() {
                return this.f10512e;
            }

            public boolean hasWd() {
                return this.f10510c;
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
                            setBusstop(codedInputStreamMicro.readBool());
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

            public Start setBusstop(boolean z) {
                this.f10514g = true;
                this.f10515h = z;
                return this;
            }

            public Start setPt(String str) {
                this.f10508a = true;
                this.f10509b = str;
                return this;
            }

            public Start setSpt(int i, int i2) {
                this.f10516i.set(i, Integer.valueOf(i2));
                return this;
            }

            public Start setUid(String str) {
                this.f10512e = true;
                this.f10513f = str;
                return this;
            }

            public Start setWd(String str) {
                this.f10510c = true;
                this.f10511d = str;
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
                if (hasBusstop()) {
                    codedOutputStreamMicro.writeBool(4, getBusstop());
                }
                for (Integer intValue : getSptList()) {
                    codedOutputStreamMicro.writeSInt32(5, intValue.intValue());
                }
            }
        }

        public static final class StartCity extends MessageMicro {
            public static final int CODE_FIELD_NUMBER = 1;
            public static final int NAME_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f10518a;
            /* renamed from: b */
            private int f10519b = 0;
            /* renamed from: c */
            private boolean f10520c;
            /* renamed from: d */
            private String f10521d = "";
            /* renamed from: e */
            private int f10522e = -1;

            public static StartCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new StartCity().mergeFrom(codedInputStreamMicro);
            }

            public static StartCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (StartCity) new StartCity().mergeFrom(bArr);
            }

            public final StartCity clear() {
                clearCode();
                clearName();
                this.f10522e = -1;
                return this;
            }

            public StartCity clearCode() {
                this.f10518a = false;
                this.f10519b = 0;
                return this;
            }

            public StartCity clearName() {
                this.f10520c = false;
                this.f10521d = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f10522e < 0) {
                    getSerializedSize();
                }
                return this.f10522e;
            }

            public int getCode() {
                return this.f10519b;
            }

            public String getName() {
                return this.f10521d;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasCode()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
                }
                if (hasName()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getName());
                }
                this.f10522e = i;
                return i;
            }

            public boolean hasCode() {
                return this.f10518a;
            }

            public boolean hasName() {
                return this.f10520c;
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
                            setName(codedInputStreamMicro.readString());
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

            public StartCity setCode(int i) {
                this.f10518a = true;
                this.f10519b = i;
                return this;
            }

            public StartCity setName(String str) {
                this.f10520c = true;
                this.f10521d = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasCode()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (hasName()) {
                    codedOutputStreamMicro.writeString(2, getName());
                }
            }
        }

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
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
            this.f10539q = -1;
            return this;
        }

        public Option clearAvoidJam() {
            this.f10533k = false;
            this.f10534l = 0;
            return this;
        }

        public Option clearEnd() {
            this.f10531i = false;
            this.f10532j = null;
            return this;
        }

        public Option clearEndCity() {
            this.f10537o = false;
            this.f10538p = null;
            return this;
        }

        public Option clearExptime() {
            this.f10525c = false;
            this.f10526d = "";
            return this;
        }

        public Option clearStart() {
            this.f10529g = false;
            this.f10530h = null;
            return this;
        }

        public Option clearStartCity() {
            this.f10535m = false;
            this.f10536n = null;
            return this;
        }

        public Option clearSy() {
            this.f10527e = false;
            this.f10528f = 0;
            return this;
        }

        public Option clearTotal() {
            this.f10523a = false;
            this.f10524b = 0;
            return this;
        }

        public int getAvoidJam() {
            return this.f10534l;
        }

        public int getCachedSize() {
            if (this.f10539q < 0) {
                getSerializedSize();
            }
            return this.f10539q;
        }

        public End getEnd() {
            return this.f10532j;
        }

        public EndCity getEndCity() {
            return this.f10538p;
        }

        public String getExptime() {
            return this.f10526d;
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
            if (hasEnd()) {
                i += CodedOutputStreamMicro.computeMessageSize(5, getEnd());
            }
            if (hasAvoidJam()) {
                i += CodedOutputStreamMicro.computeInt32Size(6, getAvoidJam());
            }
            if (hasStartCity()) {
                i += CodedOutputStreamMicro.computeMessageSize(7, getStartCity());
            }
            if (hasEndCity()) {
                i += CodedOutputStreamMicro.computeMessageSize(8, getEndCity());
            }
            this.f10539q = i;
            return i;
        }

        public Start getStart() {
            return this.f10530h;
        }

        public StartCity getStartCity() {
            return this.f10536n;
        }

        public int getSy() {
            return this.f10528f;
        }

        public int getTotal() {
            return this.f10524b;
        }

        public boolean hasAvoidJam() {
            return this.f10533k;
        }

        public boolean hasEnd() {
            return this.f10531i;
        }

        public boolean hasEndCity() {
            return this.f10537o;
        }

        public boolean hasExptime() {
            return this.f10525c;
        }

        public boolean hasStart() {
            return this.f10529g;
        }

        public boolean hasStartCity() {
            return this.f10535m;
        }

        public boolean hasSy() {
            return this.f10527e;
        }

        public boolean hasTotal() {
            return this.f10523a;
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
                        setEnd(start);
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
                        setEndCity(start);
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
            this.f10533k = true;
            this.f10534l = i;
            return this;
        }

        public Option setEnd(End end) {
            if (end == null) {
                return clearEnd();
            }
            this.f10531i = true;
            this.f10532j = end;
            return this;
        }

        public Option setEndCity(EndCity endCity) {
            if (endCity == null) {
                return clearEndCity();
            }
            this.f10537o = true;
            this.f10538p = endCity;
            return this;
        }

        public Option setExptime(String str) {
            this.f10525c = true;
            this.f10526d = str;
            return this;
        }

        public Option setStart(Start start) {
            if (start == null) {
                return clearStart();
            }
            this.f10529g = true;
            this.f10530h = start;
            return this;
        }

        public Option setStartCity(StartCity startCity) {
            if (startCity == null) {
                return clearStartCity();
            }
            this.f10535m = true;
            this.f10536n = startCity;
            return this;
        }

        public Option setSy(int i) {
            this.f10527e = true;
            this.f10528f = i;
            return this;
        }

        public Option setTotal(int i) {
            this.f10523a = true;
            this.f10524b = i;
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
            if (hasEnd()) {
                codedOutputStreamMicro.writeMessage(5, getEnd());
            }
            if (hasAvoidJam()) {
                codedOutputStreamMicro.writeInt32(6, getAvoidJam());
            }
            if (hasStartCity()) {
                codedOutputStreamMicro.writeMessage(7, getStartCity());
            }
            if (hasEndCity()) {
                codedOutputStreamMicro.writeMessage(8, getEndCity());
            }
        }
    }

    public static final class Routes extends MessageMicro {
        public static final int LEGS_FIELD_NUMBER = 1;
        /* renamed from: a */
        private List<Legs> f10586a = Collections.emptyList();
        /* renamed from: b */
        private int f10587b = -1;

        public static final class Legs extends MessageMicro {
            public static final int DISTANCE_FIELD_NUMBER = 1;
            public static final int DURATION_FIELD_NUMBER = 2;
            public static final int END_LOCATION_FIELD_NUMBER = 3;
            public static final int SEND_LOCATION_FIELD_NUMBER = 6;
            public static final int SSTART_LOCATION_FIELD_NUMBER = 7;
            public static final int START_LOCATION_FIELD_NUMBER = 4;
            public static final int STEPS_FIELD_NUMBER = 5;
            /* renamed from: a */
            private boolean f10574a;
            /* renamed from: b */
            private int f10575b = 0;
            /* renamed from: c */
            private boolean f10576c;
            /* renamed from: d */
            private int f10577d = 0;
            /* renamed from: e */
            private boolean f10578e;
            /* renamed from: f */
            private String f10579f = "";
            /* renamed from: g */
            private boolean f10580g;
            /* renamed from: h */
            private String f10581h = "";
            /* renamed from: i */
            private List<Steps> f10582i = Collections.emptyList();
            /* renamed from: j */
            private List<Integer> f10583j = Collections.emptyList();
            /* renamed from: k */
            private List<Integer> f10584k = Collections.emptyList();
            /* renamed from: l */
            private int f10585l = -1;

            public static final class Steps extends MessageMicro {
                public static final int DIRECTION_FIELD_NUMBER = 7;
                public static final int DISTANCE_FIELD_NUMBER = 1;
                public static final int DURATION_FIELD_NUMBER = 2;
                public static final int END_INSTRUCTIONS_FIELD_NUMBER = 8;
                public static final int END_LOCATION_FIELD_NUMBER = 3;
                public static final int INSTRUCTIONS_FIELD_NUMBER = 5;
                public static final int LEVEL_FIELD_NUMBER = 15;
                public static final int PATH_FIELD_NUMBER = 6;
                public static final int SEND_LOCATION_FIELD_NUMBER = 11;
                public static final int SPATH_FIELD_NUMBER = 13;
                public static final int SSTART_LOCATION_FIELD_NUMBER = 12;
                public static final int START_INSTRUCTIONS_FIELD_NUMBER = 9;
                public static final int START_LOCATION_FIELD_NUMBER = 4;
                public static final int STEPRCS_FIELD_NUMBER = 16;
                public static final int TURN_FIELD_NUMBER = 10;
                public static final int USROADNAME_FIELD_NUMBER = 14;
                /* renamed from: A */
                private int f10545A = 0;
                /* renamed from: B */
                private List<Steprcs> f10546B = Collections.emptyList();
                /* renamed from: C */
                private int f10547C = -1;
                /* renamed from: a */
                private boolean f10548a;
                /* renamed from: b */
                private int f10549b = 0;
                /* renamed from: c */
                private boolean f10550c;
                /* renamed from: d */
                private int f10551d = 0;
                /* renamed from: e */
                private boolean f10552e;
                /* renamed from: f */
                private String f10553f = "";
                /* renamed from: g */
                private boolean f10554g;
                /* renamed from: h */
                private String f10555h = "";
                /* renamed from: i */
                private boolean f10556i;
                /* renamed from: j */
                private String f10557j = "";
                /* renamed from: k */
                private boolean f10558k;
                /* renamed from: l */
                private String f10559l = "";
                /* renamed from: m */
                private boolean f10560m;
                /* renamed from: n */
                private int f10561n = 0;
                /* renamed from: o */
                private boolean f10562o;
                /* renamed from: p */
                private String f10563p = "";
                /* renamed from: q */
                private boolean f10564q;
                /* renamed from: r */
                private String f10565r = "";
                /* renamed from: s */
                private boolean f10566s;
                /* renamed from: t */
                private int f10567t = 0;
                /* renamed from: u */
                private List<Integer> f10568u = Collections.emptyList();
                /* renamed from: v */
                private List<Integer> f10569v = Collections.emptyList();
                /* renamed from: w */
                private List<Integer> f10570w = Collections.emptyList();
                /* renamed from: x */
                private boolean f10571x;
                /* renamed from: y */
                private String f10572y = "";
                /* renamed from: z */
                private boolean f10573z;

                public static final class Steprcs extends MessageMicro {
                    public static final int END_FIELD_NUMBER = 1;
                    public static final int STATUS_FIELD_NUMBER = 2;
                    /* renamed from: a */
                    private boolean f10540a;
                    /* renamed from: b */
                    private int f10541b = 0;
                    /* renamed from: c */
                    private boolean f10542c;
                    /* renamed from: d */
                    private int f10543d = 0;
                    /* renamed from: e */
                    private int f10544e = -1;

                    public static Steprcs parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Steprcs().mergeFrom(codedInputStreamMicro);
                    }

                    public static Steprcs parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Steprcs) new Steprcs().mergeFrom(bArr);
                    }

                    public final Steprcs clear() {
                        clearEnd();
                        clearStatus();
                        this.f10544e = -1;
                        return this;
                    }

                    public Steprcs clearEnd() {
                        this.f10540a = false;
                        this.f10541b = 0;
                        return this;
                    }

                    public Steprcs clearStatus() {
                        this.f10542c = false;
                        this.f10543d = 0;
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f10544e < 0) {
                            getSerializedSize();
                        }
                        return this.f10544e;
                    }

                    public int getEnd() {
                        return this.f10541b;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasEnd()) {
                            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getEnd());
                        }
                        if (hasStatus()) {
                            i += CodedOutputStreamMicro.computeInt32Size(2, getStatus());
                        }
                        this.f10544e = i;
                        return i;
                    }

                    public int getStatus() {
                        return this.f10543d;
                    }

                    public boolean hasEnd() {
                        return this.f10540a;
                    }

                    public boolean hasStatus() {
                        return this.f10542c;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Steprcs mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    setEnd(codedInputStreamMicro.readInt32());
                                    continue;
                                case 16:
                                    setStatus(codedInputStreamMicro.readInt32());
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

                    public Steprcs setEnd(int i) {
                        this.f10540a = true;
                        this.f10541b = i;
                        return this;
                    }

                    public Steprcs setStatus(int i) {
                        this.f10542c = true;
                        this.f10543d = i;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasEnd()) {
                            codedOutputStreamMicro.writeInt32(1, getEnd());
                        }
                        if (hasStatus()) {
                            codedOutputStreamMicro.writeInt32(2, getStatus());
                        }
                    }
                }

                public static Steps parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Steps().mergeFrom(codedInputStreamMicro);
                }

                public static Steps parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Steps) new Steps().mergeFrom(bArr);
                }

                public Steps addSendLocation(int i) {
                    if (this.f10568u.isEmpty()) {
                        this.f10568u = new ArrayList();
                    }
                    this.f10568u.add(Integer.valueOf(i));
                    return this;
                }

                public Steps addSpath(int i) {
                    if (this.f10570w.isEmpty()) {
                        this.f10570w = new ArrayList();
                    }
                    this.f10570w.add(Integer.valueOf(i));
                    return this;
                }

                public Steps addSstartLocation(int i) {
                    if (this.f10569v.isEmpty()) {
                        this.f10569v = new ArrayList();
                    }
                    this.f10569v.add(Integer.valueOf(i));
                    return this;
                }

                public Steps addSteprcs(Steprcs steprcs) {
                    if (steprcs != null) {
                        if (this.f10546B.isEmpty()) {
                            this.f10546B = new ArrayList();
                        }
                        this.f10546B.add(steprcs);
                    }
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
                    clearUsroadname();
                    clearLevel();
                    clearSteprcs();
                    this.f10547C = -1;
                    return this;
                }

                public Steps clearDirection() {
                    this.f10560m = false;
                    this.f10561n = 0;
                    return this;
                }

                public Steps clearDistance() {
                    this.f10548a = false;
                    this.f10549b = 0;
                    return this;
                }

                public Steps clearDuration() {
                    this.f10550c = false;
                    this.f10551d = 0;
                    return this;
                }

                public Steps clearEndInstructions() {
                    this.f10562o = false;
                    this.f10563p = "";
                    return this;
                }

                public Steps clearEndLocation() {
                    this.f10552e = false;
                    this.f10553f = "";
                    return this;
                }

                public Steps clearInstructions() {
                    this.f10556i = false;
                    this.f10557j = "";
                    return this;
                }

                public Steps clearLevel() {
                    this.f10573z = false;
                    this.f10545A = 0;
                    return this;
                }

                public Steps clearPath() {
                    this.f10558k = false;
                    this.f10559l = "";
                    return this;
                }

                public Steps clearSendLocation() {
                    this.f10568u = Collections.emptyList();
                    return this;
                }

                public Steps clearSpath() {
                    this.f10570w = Collections.emptyList();
                    return this;
                }

                public Steps clearSstartLocation() {
                    this.f10569v = Collections.emptyList();
                    return this;
                }

                public Steps clearStartInstructions() {
                    this.f10564q = false;
                    this.f10565r = "";
                    return this;
                }

                public Steps clearStartLocation() {
                    this.f10554g = false;
                    this.f10555h = "";
                    return this;
                }

                public Steps clearSteprcs() {
                    this.f10546B = Collections.emptyList();
                    return this;
                }

                public Steps clearTurn() {
                    this.f10566s = false;
                    this.f10567t = 0;
                    return this;
                }

                public Steps clearUsroadname() {
                    this.f10571x = false;
                    this.f10572y = "";
                    return this;
                }

                public int getCachedSize() {
                    if (this.f10547C < 0) {
                        getSerializedSize();
                    }
                    return this.f10547C;
                }

                public int getDirection() {
                    return this.f10561n;
                }

                public int getDistance() {
                    return this.f10549b;
                }

                public int getDuration() {
                    return this.f10551d;
                }

                public String getEndInstructions() {
                    return this.f10563p;
                }

                public String getEndLocation() {
                    return this.f10553f;
                }

                public String getInstructions() {
                    return this.f10557j;
                }

                public int getLevel() {
                    return this.f10545A;
                }

                public String getPath() {
                    return this.f10559l;
                }

                public int getSendLocation(int i) {
                    return ((Integer) this.f10568u.get(i)).intValue();
                }

                public int getSendLocationCount() {
                    return this.f10568u.size();
                }

                public List<Integer> getSendLocationList() {
                    return this.f10568u;
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
                    if (hasUsroadname()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(14, getUsroadname());
                    }
                    if (hasLevel()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(15, getLevel());
                    }
                    i = computeInt32Size;
                    for (Steprcs computeMessageSize : getSteprcsList()) {
                        i = CodedOutputStreamMicro.computeMessageSize(16, computeMessageSize) + i;
                    }
                    this.f10547C = i;
                    return i;
                }

                public int getSpath(int i) {
                    return ((Integer) this.f10570w.get(i)).intValue();
                }

                public int getSpathCount() {
                    return this.f10570w.size();
                }

                public List<Integer> getSpathList() {
                    return this.f10570w;
                }

                public int getSstartLocation(int i) {
                    return ((Integer) this.f10569v.get(i)).intValue();
                }

                public int getSstartLocationCount() {
                    return this.f10569v.size();
                }

                public List<Integer> getSstartLocationList() {
                    return this.f10569v;
                }

                public String getStartInstructions() {
                    return this.f10565r;
                }

                public String getStartLocation() {
                    return this.f10555h;
                }

                public Steprcs getSteprcs(int i) {
                    return (Steprcs) this.f10546B.get(i);
                }

                public int getSteprcsCount() {
                    return this.f10546B.size();
                }

                public List<Steprcs> getSteprcsList() {
                    return this.f10546B;
                }

                public int getTurn() {
                    return this.f10567t;
                }

                public String getUsroadname() {
                    return this.f10572y;
                }

                public boolean hasDirection() {
                    return this.f10560m;
                }

                public boolean hasDistance() {
                    return this.f10548a;
                }

                public boolean hasDuration() {
                    return this.f10550c;
                }

                public boolean hasEndInstructions() {
                    return this.f10562o;
                }

                public boolean hasEndLocation() {
                    return this.f10552e;
                }

                public boolean hasInstructions() {
                    return this.f10556i;
                }

                public boolean hasLevel() {
                    return this.f10573z;
                }

                public boolean hasPath() {
                    return this.f10558k;
                }

                public boolean hasStartInstructions() {
                    return this.f10564q;
                }

                public boolean hasStartLocation() {
                    return this.f10554g;
                }

                public boolean hasTurn() {
                    return this.f10566s;
                }

                public boolean hasUsroadname() {
                    return this.f10571x;
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
                            case 114:
                                setUsroadname(codedInputStreamMicro.readString());
                                continue;
                            case 120:
                                setLevel(codedInputStreamMicro.readInt32());
                                continue;
                            case 130:
                                MessageMicro steprcs = new Steprcs();
                                codedInputStreamMicro.readMessage(steprcs);
                                addSteprcs(steprcs);
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
                    this.f10560m = true;
                    this.f10561n = i;
                    return this;
                }

                public Steps setDistance(int i) {
                    this.f10548a = true;
                    this.f10549b = i;
                    return this;
                }

                public Steps setDuration(int i) {
                    this.f10550c = true;
                    this.f10551d = i;
                    return this;
                }

                public Steps setEndInstructions(String str) {
                    this.f10562o = true;
                    this.f10563p = str;
                    return this;
                }

                public Steps setEndLocation(String str) {
                    this.f10552e = true;
                    this.f10553f = str;
                    return this;
                }

                public Steps setInstructions(String str) {
                    this.f10556i = true;
                    this.f10557j = str;
                    return this;
                }

                public Steps setLevel(int i) {
                    this.f10573z = true;
                    this.f10545A = i;
                    return this;
                }

                public Steps setPath(String str) {
                    this.f10558k = true;
                    this.f10559l = str;
                    return this;
                }

                public Steps setSendLocation(int i, int i2) {
                    this.f10568u.set(i, Integer.valueOf(i2));
                    return this;
                }

                public Steps setSpath(int i, int i2) {
                    this.f10570w.set(i, Integer.valueOf(i2));
                    return this;
                }

                public Steps setSstartLocation(int i, int i2) {
                    this.f10569v.set(i, Integer.valueOf(i2));
                    return this;
                }

                public Steps setStartInstructions(String str) {
                    this.f10564q = true;
                    this.f10565r = str;
                    return this;
                }

                public Steps setStartLocation(String str) {
                    this.f10554g = true;
                    this.f10555h = str;
                    return this;
                }

                public Steps setSteprcs(int i, Steprcs steprcs) {
                    if (steprcs != null) {
                        this.f10546B.set(i, steprcs);
                    }
                    return this;
                }

                public Steps setTurn(int i) {
                    this.f10566s = true;
                    this.f10567t = i;
                    return this;
                }

                public Steps setUsroadname(String str) {
                    this.f10571x = true;
                    this.f10572y = str;
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
                    if (hasUsroadname()) {
                        codedOutputStreamMicro.writeString(14, getUsroadname());
                    }
                    if (hasLevel()) {
                        codedOutputStreamMicro.writeInt32(15, getLevel());
                    }
                    for (Steprcs writeMessage : getSteprcsList()) {
                        codedOutputStreamMicro.writeMessage(16, writeMessage);
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
                if (this.f10583j.isEmpty()) {
                    this.f10583j = new ArrayList();
                }
                this.f10583j.add(Integer.valueOf(i));
                return this;
            }

            public Legs addSstartLocation(int i) {
                if (this.f10584k.isEmpty()) {
                    this.f10584k = new ArrayList();
                }
                this.f10584k.add(Integer.valueOf(i));
                return this;
            }

            public Legs addSteps(Steps steps) {
                if (steps != null) {
                    if (this.f10582i.isEmpty()) {
                        this.f10582i = new ArrayList();
                    }
                    this.f10582i.add(steps);
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
                this.f10585l = -1;
                return this;
            }

            public Legs clearDistance() {
                this.f10574a = false;
                this.f10575b = 0;
                return this;
            }

            public Legs clearDuration() {
                this.f10576c = false;
                this.f10577d = 0;
                return this;
            }

            public Legs clearEndLocation() {
                this.f10578e = false;
                this.f10579f = "";
                return this;
            }

            public Legs clearSendLocation() {
                this.f10583j = Collections.emptyList();
                return this;
            }

            public Legs clearSstartLocation() {
                this.f10584k = Collections.emptyList();
                return this;
            }

            public Legs clearStartLocation() {
                this.f10580g = false;
                this.f10581h = "";
                return this;
            }

            public Legs clearSteps() {
                this.f10582i = Collections.emptyList();
                return this;
            }

            public int getCachedSize() {
                if (this.f10585l < 0) {
                    getSerializedSize();
                }
                return this.f10585l;
            }

            public int getDistance() {
                return this.f10575b;
            }

            public int getDuration() {
                return this.f10577d;
            }

            public String getEndLocation() {
                return this.f10579f;
            }

            public int getSendLocation(int i) {
                return ((Integer) this.f10583j.get(i)).intValue();
            }

            public int getSendLocationCount() {
                return this.f10583j.size();
            }

            public List<Integer> getSendLocationList() {
                return this.f10583j;
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
                this.f10585l = computeInt32Size;
                return computeInt32Size;
            }

            public int getSstartLocation(int i) {
                return ((Integer) this.f10584k.get(i)).intValue();
            }

            public int getSstartLocationCount() {
                return this.f10584k.size();
            }

            public List<Integer> getSstartLocationList() {
                return this.f10584k;
            }

            public String getStartLocation() {
                return this.f10581h;
            }

            public Steps getSteps(int i) {
                return (Steps) this.f10582i.get(i);
            }

            public int getStepsCount() {
                return this.f10582i.size();
            }

            public List<Steps> getStepsList() {
                return this.f10582i;
            }

            public boolean hasDistance() {
                return this.f10574a;
            }

            public boolean hasDuration() {
                return this.f10576c;
            }

            public boolean hasEndLocation() {
                return this.f10578e;
            }

            public boolean hasStartLocation() {
                return this.f10580g;
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
                this.f10574a = true;
                this.f10575b = i;
                return this;
            }

            public Legs setDuration(int i) {
                this.f10576c = true;
                this.f10577d = i;
                return this;
            }

            public Legs setEndLocation(String str) {
                this.f10578e = true;
                this.f10579f = str;
                return this;
            }

            public Legs setSendLocation(int i, int i2) {
                this.f10583j.set(i, Integer.valueOf(i2));
                return this;
            }

            public Legs setSstartLocation(int i, int i2) {
                this.f10584k.set(i, Integer.valueOf(i2));
                return this;
            }

            public Legs setStartLocation(String str) {
                this.f10580g = true;
                this.f10581h = str;
                return this;
            }

            public Legs setSteps(int i, Steps steps) {
                if (steps != null) {
                    this.f10582i.set(i, steps);
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
                if (this.f10586a.isEmpty()) {
                    this.f10586a = new ArrayList();
                }
                this.f10586a.add(legs);
            }
            return this;
        }

        public final Routes clear() {
            clearLegs();
            this.f10587b = -1;
            return this;
        }

        public Routes clearLegs() {
            this.f10586a = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f10587b < 0) {
                getSerializedSize();
            }
            return this.f10587b;
        }

        public Legs getLegs(int i) {
            return (Legs) this.f10586a.get(i);
        }

        public int getLegsCount() {
            return this.f10586a.size();
        }

        public List<Legs> getLegsList() {
            return this.f10586a;
        }

        public int getSerializedSize() {
            int i = 0;
            for (Legs computeMessageSize : getLegsList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            this.f10587b = i;
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
                this.f10586a.set(i, legs);
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
        private boolean f10597a;
        /* renamed from: b */
        private int f10598b = 0;
        /* renamed from: c */
        private boolean f10599c;
        /* renamed from: d */
        private int f10600d = 0;
        /* renamed from: e */
        private boolean f10601e;
        /* renamed from: f */
        private String f10602f = "";
        /* renamed from: g */
        private List<Detail> f10603g = Collections.emptyList();
        /* renamed from: h */
        private int f10604h = -1;

        public static final class Detail extends MessageMicro {
            public static final int DESC_FIELD_NUMBER = 1;
            public static final int KM_PRICE_FIELD_NUMBER = 2;
            public static final int START_PRICE_FIELD_NUMBER = 3;
            public static final int TOTAL_PRICE_FIELD_NUMBER = 4;
            /* renamed from: a */
            private boolean f10588a;
            /* renamed from: b */
            private String f10589b = "";
            /* renamed from: c */
            private boolean f10590c;
            /* renamed from: d */
            private String f10591d = "";
            /* renamed from: e */
            private boolean f10592e;
            /* renamed from: f */
            private String f10593f = "";
            /* renamed from: g */
            private boolean f10594g;
            /* renamed from: h */
            private String f10595h = "";
            /* renamed from: i */
            private int f10596i = -1;

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
                this.f10596i = -1;
                return this;
            }

            public Detail clearDesc() {
                this.f10588a = false;
                this.f10589b = "";
                return this;
            }

            public Detail clearKmPrice() {
                this.f10590c = false;
                this.f10591d = "";
                return this;
            }

            public Detail clearStartPrice() {
                this.f10592e = false;
                this.f10593f = "";
                return this;
            }

            public Detail clearTotalPrice() {
                this.f10594g = false;
                this.f10595h = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f10596i < 0) {
                    getSerializedSize();
                }
                return this.f10596i;
            }

            public String getDesc() {
                return this.f10589b;
            }

            public String getKmPrice() {
                return this.f10591d;
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
                this.f10596i = i;
                return i;
            }

            public String getStartPrice() {
                return this.f10593f;
            }

            public String getTotalPrice() {
                return this.f10595h;
            }

            public boolean hasDesc() {
                return this.f10588a;
            }

            public boolean hasKmPrice() {
                return this.f10590c;
            }

            public boolean hasStartPrice() {
                return this.f10592e;
            }

            public boolean hasTotalPrice() {
                return this.f10594g;
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
                this.f10588a = true;
                this.f10589b = str;
                return this;
            }

            public Detail setKmPrice(String str) {
                this.f10590c = true;
                this.f10591d = str;
                return this;
            }

            public Detail setStartPrice(String str) {
                this.f10592e = true;
                this.f10593f = str;
                return this;
            }

            public Detail setTotalPrice(String str) {
                this.f10594g = true;
                this.f10595h = str;
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
                if (this.f10603g.isEmpty()) {
                    this.f10603g = new ArrayList();
                }
                this.f10603g.add(detail);
            }
            return this;
        }

        public final Taxi clear() {
            clearDistance();
            clearDuration();
            clearRemark();
            clearDetail();
            this.f10604h = -1;
            return this;
        }

        public Taxi clearDetail() {
            this.f10603g = Collections.emptyList();
            return this;
        }

        public Taxi clearDistance() {
            this.f10597a = false;
            this.f10598b = 0;
            return this;
        }

        public Taxi clearDuration() {
            this.f10599c = false;
            this.f10600d = 0;
            return this;
        }

        public Taxi clearRemark() {
            this.f10601e = false;
            this.f10602f = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f10604h < 0) {
                getSerializedSize();
            }
            return this.f10604h;
        }

        public Detail getDetail(int i) {
            return (Detail) this.f10603g.get(i);
        }

        public int getDetailCount() {
            return this.f10603g.size();
        }

        public List<Detail> getDetailList() {
            return this.f10603g;
        }

        public int getDistance() {
            return this.f10598b;
        }

        public int getDuration() {
            return this.f10600d;
        }

        public String getRemark() {
            return this.f10602f;
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
            this.f10604h = i2;
            return i2;
        }

        public boolean hasDistance() {
            return this.f10597a;
        }

        public boolean hasDuration() {
            return this.f10599c;
        }

        public boolean hasRemark() {
            return this.f10601e;
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
                this.f10603g.set(i, detail);
            }
            return this;
        }

        public Taxi setDistance(int i) {
            this.f10597a = true;
            this.f10598b = i;
            return this;
        }

        public Taxi setDuration(int i) {
            this.f10599c = true;
            this.f10600d = i;
            return this;
        }

        public Taxi setRemark(String str) {
            this.f10601e = true;
            this.f10602f = str;
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
        private List<Routes> f10614a = Collections.emptyList();
        /* renamed from: b */
        private int f10615b = -1;

        public static final class Routes extends MessageMicro {
            public static final int DIGES_FIELD_NUMBER = 1;
            public static final int LEGS_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f10610a;
            /* renamed from: b */
            private String f10611b = "";
            /* renamed from: c */
            private List<Legs> f10612c = Collections.emptyList();
            /* renamed from: d */
            private int f10613d = -1;

            public static final class Legs extends MessageMicro {
                public static final int STEPS_FIELD_NUMBER = 1;
                /* renamed from: a */
                private List<Steps> f10608a = Collections.emptyList();
                /* renamed from: b */
                private int f10609b = -1;

                public static final class Steps extends MessageMicro {
                    public static final int END_FIELD_NUMBER = 1;
                    public static final int STATUS_FIELD_NUMBER = 2;
                    /* renamed from: a */
                    private List<Integer> f10605a = Collections.emptyList();
                    /* renamed from: b */
                    private List<Integer> f10606b = Collections.emptyList();
                    /* renamed from: c */
                    private int f10607c = -1;

                    public static Steps parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Steps().mergeFrom(codedInputStreamMicro);
                    }

                    public static Steps parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Steps) new Steps().mergeFrom(bArr);
                    }

                    public Steps addEnd(int i) {
                        if (this.f10605a.isEmpty()) {
                            this.f10605a = new ArrayList();
                        }
                        this.f10605a.add(Integer.valueOf(i));
                        return this;
                    }

                    public Steps addStatus(int i) {
                        if (this.f10606b.isEmpty()) {
                            this.f10606b = new ArrayList();
                        }
                        this.f10606b.add(Integer.valueOf(i));
                        return this;
                    }

                    public final Steps clear() {
                        clearEnd();
                        clearStatus();
                        this.f10607c = -1;
                        return this;
                    }

                    public Steps clearEnd() {
                        this.f10605a = Collections.emptyList();
                        return this;
                    }

                    public Steps clearStatus() {
                        this.f10606b = Collections.emptyList();
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f10607c < 0) {
                            getSerializedSize();
                        }
                        return this.f10607c;
                    }

                    public int getEnd(int i) {
                        return ((Integer) this.f10605a.get(i)).intValue();
                    }

                    public int getEndCount() {
                        return this.f10605a.size();
                    }

                    public List<Integer> getEndList() {
                        return this.f10605a;
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
                        this.f10607c = size;
                        return size;
                    }

                    public int getStatus(int i) {
                        return ((Integer) this.f10606b.get(i)).intValue();
                    }

                    public int getStatusCount() {
                        return this.f10606b.size();
                    }

                    public List<Integer> getStatusList() {
                        return this.f10606b;
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
                        this.f10605a.set(i, Integer.valueOf(i2));
                        return this;
                    }

                    public Steps setStatus(int i, int i2) {
                        this.f10606b.set(i, Integer.valueOf(i2));
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
                        if (this.f10608a.isEmpty()) {
                            this.f10608a = new ArrayList();
                        }
                        this.f10608a.add(steps);
                    }
                    return this;
                }

                public final Legs clear() {
                    clearSteps();
                    this.f10609b = -1;
                    return this;
                }

                public Legs clearSteps() {
                    this.f10608a = Collections.emptyList();
                    return this;
                }

                public int getCachedSize() {
                    if (this.f10609b < 0) {
                        getSerializedSize();
                    }
                    return this.f10609b;
                }

                public int getSerializedSize() {
                    int i = 0;
                    for (Steps computeMessageSize : getStepsList()) {
                        i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
                    }
                    this.f10609b = i;
                    return i;
                }

                public Steps getSteps(int i) {
                    return (Steps) this.f10608a.get(i);
                }

                public int getStepsCount() {
                    return this.f10608a.size();
                }

                public List<Steps> getStepsList() {
                    return this.f10608a;
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
                        this.f10608a.set(i, steps);
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
                    if (this.f10612c.isEmpty()) {
                        this.f10612c = new ArrayList();
                    }
                    this.f10612c.add(legs);
                }
                return this;
            }

            public final Routes clear() {
                clearDiges();
                clearLegs();
                this.f10613d = -1;
                return this;
            }

            public Routes clearDiges() {
                this.f10610a = false;
                this.f10611b = "";
                return this;
            }

            public Routes clearLegs() {
                this.f10612c = Collections.emptyList();
                return this;
            }

            public int getCachedSize() {
                if (this.f10613d < 0) {
                    getSerializedSize();
                }
                return this.f10613d;
            }

            public String getDiges() {
                return this.f10611b;
            }

            public Legs getLegs(int i) {
                return (Legs) this.f10612c.get(i);
            }

            public int getLegsCount() {
                return this.f10612c.size();
            }

            public List<Legs> getLegsList() {
                return this.f10612c;
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
                this.f10613d = i2;
                return i2;
            }

            public boolean hasDiges() {
                return this.f10610a;
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
                this.f10610a = true;
                this.f10611b = str;
                return this;
            }

            public Routes setLegs(int i, Legs legs) {
                if (legs != null) {
                    this.f10612c.set(i, legs);
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
                if (this.f10614a.isEmpty()) {
                    this.f10614a = new ArrayList();
                }
                this.f10614a.add(routes);
            }
            return this;
        }

        public final Traffic clear() {
            clearRoutes();
            this.f10615b = -1;
            return this;
        }

        public Traffic clearRoutes() {
            this.f10614a = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f10615b < 0) {
                getSerializedSize();
            }
            return this.f10615b;
        }

        public Routes getRoutes(int i) {
            return (Routes) this.f10614a.get(i);
        }

        public int getRoutesCount() {
            return this.f10614a.size();
        }

        public List<Routes> getRoutesList() {
            return this.f10614a;
        }

        public int getSerializedSize() {
            int i = 0;
            for (Routes computeMessageSize : getRoutesList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            this.f10615b = i;
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
                this.f10614a.set(i, routes);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (Routes writeMessage : getRoutesList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
        }
    }

    public static Car parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Car().mergeFrom(codedInputStreamMicro);
    }

    public static Car parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Car) new Car().mergeFrom(bArr);
    }

    public Car addRoutes(Routes routes) {
        if (routes != null) {
            if (this.f10620e.isEmpty()) {
                this.f10620e = new ArrayList();
            }
            this.f10620e.add(routes);
        }
        return this;
    }

    public final Car clear() {
        clearTaxi();
        clearCurrentCity();
        clearRoutes();
        clearOption();
        clearTraffic();
        this.f10625j = -1;
        return this;
    }

    public Car clearCurrentCity() {
        this.f10618c = false;
        this.f10619d = null;
        return this;
    }

    public Car clearOption() {
        this.f10621f = false;
        this.f10622g = null;
        return this;
    }

    public Car clearRoutes() {
        this.f10620e = Collections.emptyList();
        return this;
    }

    public Car clearTaxi() {
        this.f10616a = false;
        this.f10617b = null;
        return this;
    }

    public Car clearTraffic() {
        this.f10623h = false;
        this.f10624i = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f10625j < 0) {
            getSerializedSize();
        }
        return this.f10625j;
    }

    public CurrentCity getCurrentCity() {
        return this.f10619d;
    }

    public Option getOption() {
        return this.f10622g;
    }

    public Routes getRoutes(int i) {
        return (Routes) this.f10620e.get(i);
    }

    public int getRoutesCount() {
        return this.f10620e.size();
    }

    public List<Routes> getRoutesList() {
        return this.f10620e;
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
        this.f10625j = i2;
        return i2;
    }

    public Taxi getTaxi() {
        return this.f10617b;
    }

    public Traffic getTraffic() {
        return this.f10624i;
    }

    public boolean hasCurrentCity() {
        return this.f10618c;
    }

    public boolean hasOption() {
        return this.f10621f;
    }

    public boolean hasTaxi() {
        return this.f10616a;
    }

    public boolean hasTraffic() {
        return this.f10623h;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Car mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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

    public Car setCurrentCity(CurrentCity currentCity) {
        if (currentCity == null) {
            return clearCurrentCity();
        }
        this.f10618c = true;
        this.f10619d = currentCity;
        return this;
    }

    public Car setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f10621f = true;
        this.f10622g = option;
        return this;
    }

    public Car setRoutes(int i, Routes routes) {
        if (routes != null) {
            this.f10620e.set(i, routes);
        }
        return this;
    }

    public Car setTaxi(Taxi taxi) {
        if (taxi == null) {
            return clearTaxi();
        }
        this.f10616a = true;
        this.f10617b = taxi;
        return this;
    }

    public Car setTraffic(Traffic traffic) {
        if (traffic == null) {
            return clearTraffic();
        }
        this.f10623h = true;
        this.f10624i = traffic;
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
