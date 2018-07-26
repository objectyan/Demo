package com.baidu.entity.pb;

import com.baidu.baidunavis.model.NavCarInfo;
import com.baidu.platform.comapi.map.provider.RouteLineResConst;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class WalkPlan extends MessageMicro {
    public static final int CURRENT_CITY_FIELD_NUMBER = 4;
    public static final int INDOOR_NAVIS_FIELD_NUMBER = 5;
    public static final int OPTION_FIELD_NUMBER = 3;
    public static final int ROUTES_FIELD_NUMBER = 1;
    public static final int TAXI_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f17046a;
    /* renamed from: b */
    private Taxi f17047b = null;
    /* renamed from: c */
    private List<Routes> f17048c = Collections.emptyList();
    /* renamed from: d */
    private boolean f17049d;
    /* renamed from: e */
    private Option f17050e = null;
    /* renamed from: f */
    private boolean f17051f;
    /* renamed from: g */
    private CurrentCity f17052g = null;
    /* renamed from: h */
    private List<IndoorNavi> f17053h = Collections.emptyList();
    /* renamed from: i */
    private int f17054i = -1;

    public static final class Option extends MessageMicro {
        public static final int AVOID_JAM_FIELD_NUMBER = 6;
        public static final int DIS_SY_FIELD_NUMBER = 9;
        public static final int END_CITY_FIELD_NUMBER = 8;
        public static final int END_FIELD_NUMBER = 5;
        public static final int EXPTIME_FIELD_NUMBER = 2;
        public static final int REQ_TM_FIELD_NUMBER = 10;
        public static final int SPATH_TYPE_FIELD_NUMBER = 11;
        public static final int START_CITY_FIELD_NUMBER = 7;
        public static final int START_FIELD_NUMBER = 4;
        public static final int SY_FIELD_NUMBER = 3;
        public static final int TOTAL_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f16901a;
        /* renamed from: b */
        private int f16902b = 0;
        /* renamed from: c */
        private boolean f16903c;
        /* renamed from: d */
        private String f16904d = "";
        /* renamed from: e */
        private boolean f16905e;
        /* renamed from: f */
        private int f16906f = 0;
        /* renamed from: g */
        private boolean f16907g;
        /* renamed from: h */
        private Start f16908h = null;
        /* renamed from: i */
        private List<End> f16909i = Collections.emptyList();
        /* renamed from: j */
        private boolean f16910j;
        /* renamed from: k */
        private int f16911k = 0;
        /* renamed from: l */
        private boolean f16912l;
        /* renamed from: m */
        private StartCity f16913m = null;
        /* renamed from: n */
        private List<EndCity> f16914n = Collections.emptyList();
        /* renamed from: o */
        private boolean f16915o;
        /* renamed from: p */
        private int f16916p = 0;
        /* renamed from: q */
        private boolean f16917q;
        /* renamed from: r */
        private String f16918r = "";
        /* renamed from: s */
        private boolean f16919s;
        /* renamed from: t */
        private int f16920t = 0;
        /* renamed from: u */
        private int f16921u = -1;

        public static final class End extends MessageMicro {
            public static final int BUILDING_FIELD_NUMBER = 7;
            public static final int BUS_STOP_FIELD_NUMBER = 4;
            public static final int FLOOR_FIELD_NUMBER = 6;
            public static final int PT_FIELD_NUMBER = 1;
            public static final int SPT_FIELD_NUMBER = 5;
            public static final int UID_FIELD_NUMBER = 3;
            public static final int WD_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f16863a;
            /* renamed from: b */
            private String f16864b = "";
            /* renamed from: c */
            private boolean f16865c;
            /* renamed from: d */
            private String f16866d = "";
            /* renamed from: e */
            private boolean f16867e;
            /* renamed from: f */
            private String f16868f = "";
            /* renamed from: g */
            private boolean f16869g;
            /* renamed from: h */
            private boolean f16870h = false;
            /* renamed from: i */
            private List<Integer> f16871i = Collections.emptyList();
            /* renamed from: j */
            private boolean f16872j;
            /* renamed from: k */
            private String f16873k = "";
            /* renamed from: l */
            private boolean f16874l;
            /* renamed from: m */
            private String f16875m = "";
            /* renamed from: n */
            private int f16876n = -1;

            public static End parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new End().mergeFrom(codedInputStreamMicro);
            }

            public static End parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (End) new End().mergeFrom(bArr);
            }

            public End addSpt(int i) {
                if (this.f16871i.isEmpty()) {
                    this.f16871i = new ArrayList();
                }
                this.f16871i.add(Integer.valueOf(i));
                return this;
            }

            public final End clear() {
                clearPt();
                clearWd();
                clearUid();
                clearBusStop();
                clearSpt();
                clearFloor();
                clearBuilding();
                this.f16876n = -1;
                return this;
            }

            public End clearBuilding() {
                this.f16874l = false;
                this.f16875m = "";
                return this;
            }

            public End clearBusStop() {
                this.f16869g = false;
                this.f16870h = false;
                return this;
            }

            public End clearFloor() {
                this.f16872j = false;
                this.f16873k = "";
                return this;
            }

            public End clearPt() {
                this.f16863a = false;
                this.f16864b = "";
                return this;
            }

            public End clearSpt() {
                this.f16871i = Collections.emptyList();
                return this;
            }

            public End clearUid() {
                this.f16867e = false;
                this.f16868f = "";
                return this;
            }

            public End clearWd() {
                this.f16865c = false;
                this.f16866d = "";
                return this;
            }

            public String getBuilding() {
                return this.f16875m;
            }

            public boolean getBusStop() {
                return this.f16870h;
            }

            public int getCachedSize() {
                if (this.f16876n < 0) {
                    getSerializedSize();
                }
                return this.f16876n;
            }

            public String getFloor() {
                return this.f16873k;
            }

            public String getPt() {
                return this.f16864b;
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
                if (hasFloor()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(6, getFloor());
                }
                if (hasBuilding()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(7, getBuilding());
                }
                this.f16876n = computeStringSize;
                return computeStringSize;
            }

            public int getSpt(int i) {
                return ((Integer) this.f16871i.get(i)).intValue();
            }

            public int getSptCount() {
                return this.f16871i.size();
            }

            public List<Integer> getSptList() {
                return this.f16871i;
            }

            public String getUid() {
                return this.f16868f;
            }

            public String getWd() {
                return this.f16866d;
            }

            public boolean hasBuilding() {
                return this.f16874l;
            }

            public boolean hasBusStop() {
                return this.f16869g;
            }

            public boolean hasFloor() {
                return this.f16872j;
            }

            public boolean hasPt() {
                return this.f16863a;
            }

            public boolean hasUid() {
                return this.f16867e;
            }

            public boolean hasWd() {
                return this.f16865c;
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
                        case 50:
                            setFloor(codedInputStreamMicro.readString());
                            continue;
                        case 58:
                            setBuilding(codedInputStreamMicro.readString());
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

            public End setBuilding(String str) {
                this.f16874l = true;
                this.f16875m = str;
                return this;
            }

            public End setBusStop(boolean z) {
                this.f16869g = true;
                this.f16870h = z;
                return this;
            }

            public End setFloor(String str) {
                this.f16872j = true;
                this.f16873k = str;
                return this;
            }

            public End setPt(String str) {
                this.f16863a = true;
                this.f16864b = str;
                return this;
            }

            public End setSpt(int i, int i2) {
                this.f16871i.set(i, Integer.valueOf(i2));
                return this;
            }

            public End setUid(String str) {
                this.f16867e = true;
                this.f16868f = str;
                return this;
            }

            public End setWd(String str) {
                this.f16865c = true;
                this.f16866d = str;
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
                if (hasFloor()) {
                    codedOutputStreamMicro.writeString(6, getFloor());
                }
                if (hasBuilding()) {
                    codedOutputStreamMicro.writeString(7, getBuilding());
                }
            }
        }

        public static final class EndCity extends MessageMicro {
            public static final int CNAME_FIELD_NUMBER = 2;
            public static final int CODE_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f16877a;
            /* renamed from: b */
            private int f16878b = 0;
            /* renamed from: c */
            private boolean f16879c;
            /* renamed from: d */
            private String f16880d = "";
            /* renamed from: e */
            private int f16881e = -1;

            public static EndCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new EndCity().mergeFrom(codedInputStreamMicro);
            }

            public static EndCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (EndCity) new EndCity().mergeFrom(bArr);
            }

            public final EndCity clear() {
                clearCode();
                clearCname();
                this.f16881e = -1;
                return this;
            }

            public EndCity clearCname() {
                this.f16879c = false;
                this.f16880d = "";
                return this;
            }

            public EndCity clearCode() {
                this.f16877a = false;
                this.f16878b = 0;
                return this;
            }

            public int getCachedSize() {
                if (this.f16881e < 0) {
                    getSerializedSize();
                }
                return this.f16881e;
            }

            public String getCname() {
                return this.f16880d;
            }

            public int getCode() {
                return this.f16878b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasCode()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
                }
                if (hasCname()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.f16881e = i;
                return i;
            }

            public boolean hasCname() {
                return this.f16879c;
            }

            public boolean hasCode() {
                return this.f16877a;
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
                this.f16879c = true;
                this.f16880d = str;
                return this;
            }

            public EndCity setCode(int i) {
                this.f16877a = true;
                this.f16878b = i;
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
            public static final int BUILDING_FIELD_NUMBER = 7;
            public static final int BUS_STOP_FIELD_NUMBER = 4;
            public static final int FLOOR_FIELD_NUMBER = 6;
            public static final int PT_FIELD_NUMBER = 1;
            public static final int SPT_FIELD_NUMBER = 5;
            public static final int UID_FIELD_NUMBER = 3;
            public static final int WD_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f16882a;
            /* renamed from: b */
            private String f16883b = "";
            /* renamed from: c */
            private boolean f16884c;
            /* renamed from: d */
            private String f16885d = "";
            /* renamed from: e */
            private boolean f16886e;
            /* renamed from: f */
            private String f16887f = "";
            /* renamed from: g */
            private boolean f16888g;
            /* renamed from: h */
            private boolean f16889h = false;
            /* renamed from: i */
            private List<Integer> f16890i = Collections.emptyList();
            /* renamed from: j */
            private boolean f16891j;
            /* renamed from: k */
            private String f16892k = "";
            /* renamed from: l */
            private boolean f16893l;
            /* renamed from: m */
            private String f16894m = "";
            /* renamed from: n */
            private int f16895n = -1;

            public static Start parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Start().mergeFrom(codedInputStreamMicro);
            }

            public static Start parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Start) new Start().mergeFrom(bArr);
            }

            public Start addSpt(int i) {
                if (this.f16890i.isEmpty()) {
                    this.f16890i = new ArrayList();
                }
                this.f16890i.add(Integer.valueOf(i));
                return this;
            }

            public final Start clear() {
                clearPt();
                clearWd();
                clearUid();
                clearBusStop();
                clearSpt();
                clearFloor();
                clearBuilding();
                this.f16895n = -1;
                return this;
            }

            public Start clearBuilding() {
                this.f16893l = false;
                this.f16894m = "";
                return this;
            }

            public Start clearBusStop() {
                this.f16888g = false;
                this.f16889h = false;
                return this;
            }

            public Start clearFloor() {
                this.f16891j = false;
                this.f16892k = "";
                return this;
            }

            public Start clearPt() {
                this.f16882a = false;
                this.f16883b = "";
                return this;
            }

            public Start clearSpt() {
                this.f16890i = Collections.emptyList();
                return this;
            }

            public Start clearUid() {
                this.f16886e = false;
                this.f16887f = "";
                return this;
            }

            public Start clearWd() {
                this.f16884c = false;
                this.f16885d = "";
                return this;
            }

            public String getBuilding() {
                return this.f16894m;
            }

            public boolean getBusStop() {
                return this.f16889h;
            }

            public int getCachedSize() {
                if (this.f16895n < 0) {
                    getSerializedSize();
                }
                return this.f16895n;
            }

            public String getFloor() {
                return this.f16892k;
            }

            public String getPt() {
                return this.f16883b;
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
                if (hasFloor()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(6, getFloor());
                }
                if (hasBuilding()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(7, getBuilding());
                }
                this.f16895n = computeStringSize;
                return computeStringSize;
            }

            public int getSpt(int i) {
                return ((Integer) this.f16890i.get(i)).intValue();
            }

            public int getSptCount() {
                return this.f16890i.size();
            }

            public List<Integer> getSptList() {
                return this.f16890i;
            }

            public String getUid() {
                return this.f16887f;
            }

            public String getWd() {
                return this.f16885d;
            }

            public boolean hasBuilding() {
                return this.f16893l;
            }

            public boolean hasBusStop() {
                return this.f16888g;
            }

            public boolean hasFloor() {
                return this.f16891j;
            }

            public boolean hasPt() {
                return this.f16882a;
            }

            public boolean hasUid() {
                return this.f16886e;
            }

            public boolean hasWd() {
                return this.f16884c;
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
                        case 50:
                            setFloor(codedInputStreamMicro.readString());
                            continue;
                        case 58:
                            setBuilding(codedInputStreamMicro.readString());
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

            public Start setBuilding(String str) {
                this.f16893l = true;
                this.f16894m = str;
                return this;
            }

            public Start setBusStop(boolean z) {
                this.f16888g = true;
                this.f16889h = z;
                return this;
            }

            public Start setFloor(String str) {
                this.f16891j = true;
                this.f16892k = str;
                return this;
            }

            public Start setPt(String str) {
                this.f16882a = true;
                this.f16883b = str;
                return this;
            }

            public Start setSpt(int i, int i2) {
                this.f16890i.set(i, Integer.valueOf(i2));
                return this;
            }

            public Start setUid(String str) {
                this.f16886e = true;
                this.f16887f = str;
                return this;
            }

            public Start setWd(String str) {
                this.f16884c = true;
                this.f16885d = str;
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
                if (hasFloor()) {
                    codedOutputStreamMicro.writeString(6, getFloor());
                }
                if (hasBuilding()) {
                    codedOutputStreamMicro.writeString(7, getBuilding());
                }
            }
        }

        public static final class StartCity extends MessageMicro {
            public static final int CNAME_FIELD_NUMBER = 2;
            public static final int CODE_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f16896a;
            /* renamed from: b */
            private int f16897b = 0;
            /* renamed from: c */
            private boolean f16898c;
            /* renamed from: d */
            private String f16899d = "";
            /* renamed from: e */
            private int f16900e = -1;

            public static StartCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new StartCity().mergeFrom(codedInputStreamMicro);
            }

            public static StartCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (StartCity) new StartCity().mergeFrom(bArr);
            }

            public final StartCity clear() {
                clearCode();
                clearCname();
                this.f16900e = -1;
                return this;
            }

            public StartCity clearCname() {
                this.f16898c = false;
                this.f16899d = "";
                return this;
            }

            public StartCity clearCode() {
                this.f16896a = false;
                this.f16897b = 0;
                return this;
            }

            public int getCachedSize() {
                if (this.f16900e < 0) {
                    getSerializedSize();
                }
                return this.f16900e;
            }

            public String getCname() {
                return this.f16899d;
            }

            public int getCode() {
                return this.f16897b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasCode()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
                }
                if (hasCname()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.f16900e = i;
                return i;
            }

            public boolean hasCname() {
                return this.f16898c;
            }

            public boolean hasCode() {
                return this.f16896a;
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
                this.f16898c = true;
                this.f16899d = str;
                return this;
            }

            public StartCity setCode(int i) {
                this.f16896a = true;
                this.f16897b = i;
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
                if (this.f16909i.isEmpty()) {
                    this.f16909i = new ArrayList();
                }
                this.f16909i.add(end);
            }
            return this;
        }

        public Option addEndCity(EndCity endCity) {
            if (endCity != null) {
                if (this.f16914n.isEmpty()) {
                    this.f16914n = new ArrayList();
                }
                this.f16914n.add(endCity);
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
            clearDisSy();
            clearReqTm();
            clearSpathType();
            this.f16921u = -1;
            return this;
        }

        public Option clearAvoidJam() {
            this.f16910j = false;
            this.f16911k = 0;
            return this;
        }

        public Option clearDisSy() {
            this.f16915o = false;
            this.f16916p = 0;
            return this;
        }

        public Option clearEnd() {
            this.f16909i = Collections.emptyList();
            return this;
        }

        public Option clearEndCity() {
            this.f16914n = Collections.emptyList();
            return this;
        }

        public Option clearExptime() {
            this.f16903c = false;
            this.f16904d = "";
            return this;
        }

        public Option clearReqTm() {
            this.f16917q = false;
            this.f16918r = "";
            return this;
        }

        public Option clearSpathType() {
            this.f16919s = false;
            this.f16920t = 0;
            return this;
        }

        public Option clearStart() {
            this.f16907g = false;
            this.f16908h = null;
            return this;
        }

        public Option clearStartCity() {
            this.f16912l = false;
            this.f16913m = null;
            return this;
        }

        public Option clearSy() {
            this.f16905e = false;
            this.f16906f = 0;
            return this;
        }

        public Option clearTotal() {
            this.f16901a = false;
            this.f16902b = 0;
            return this;
        }

        public int getAvoidJam() {
            return this.f16911k;
        }

        public int getCachedSize() {
            if (this.f16921u < 0) {
                getSerializedSize();
            }
            return this.f16921u;
        }

        public int getDisSy() {
            return this.f16916p;
        }

        public End getEnd(int i) {
            return (End) this.f16909i.get(i);
        }

        public EndCity getEndCity(int i) {
            return (EndCity) this.f16914n.get(i);
        }

        public int getEndCityCount() {
            return this.f16914n.size();
        }

        public List<EndCity> getEndCityList() {
            return this.f16914n;
        }

        public int getEndCount() {
            return this.f16909i.size();
        }

        public List<End> getEndList() {
            return this.f16909i;
        }

        public String getExptime() {
            return this.f16904d;
        }

        public String getReqTm() {
            return this.f16918r;
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
            if (hasDisSy()) {
                i2 += CodedOutputStreamMicro.computeInt32Size(9, getDisSy());
            }
            if (hasReqTm()) {
                i2 += CodedOutputStreamMicro.computeStringSize(10, getReqTm());
            }
            if (hasSpathType()) {
                i2 += CodedOutputStreamMicro.computeInt32Size(11, getSpathType());
            }
            this.f16921u = i2;
            return i2;
        }

        public int getSpathType() {
            return this.f16920t;
        }

        public Start getStart() {
            return this.f16908h;
        }

        public StartCity getStartCity() {
            return this.f16913m;
        }

        public int getSy() {
            return this.f16906f;
        }

        public int getTotal() {
            return this.f16902b;
        }

        public boolean hasAvoidJam() {
            return this.f16910j;
        }

        public boolean hasDisSy() {
            return this.f16915o;
        }

        public boolean hasExptime() {
            return this.f16903c;
        }

        public boolean hasReqTm() {
            return this.f16917q;
        }

        public boolean hasSpathType() {
            return this.f16919s;
        }

        public boolean hasStart() {
            return this.f16907g;
        }

        public boolean hasStartCity() {
            return this.f16912l;
        }

        public boolean hasSy() {
            return this.f16905e;
        }

        public boolean hasTotal() {
            return this.f16901a;
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
                    case NavCarInfo.CarType_57L /*72*/:
                        setDisSy(codedInputStreamMicro.readInt32());
                        continue;
                    case 82:
                        setReqTm(codedInputStreamMicro.readString());
                        continue;
                    case 88:
                        setSpathType(codedInputStreamMicro.readInt32());
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
            this.f16910j = true;
            this.f16911k = i;
            return this;
        }

        public Option setDisSy(int i) {
            this.f16915o = true;
            this.f16916p = i;
            return this;
        }

        public Option setEnd(int i, End end) {
            if (end != null) {
                this.f16909i.set(i, end);
            }
            return this;
        }

        public Option setEndCity(int i, EndCity endCity) {
            if (endCity != null) {
                this.f16914n.set(i, endCity);
            }
            return this;
        }

        public Option setExptime(String str) {
            this.f16903c = true;
            this.f16904d = str;
            return this;
        }

        public Option setReqTm(String str) {
            this.f16917q = true;
            this.f16918r = str;
            return this;
        }

        public Option setSpathType(int i) {
            this.f16919s = true;
            this.f16920t = i;
            return this;
        }

        public Option setStart(Start start) {
            if (start == null) {
                return clearStart();
            }
            this.f16907g = true;
            this.f16908h = start;
            return this;
        }

        public Option setStartCity(StartCity startCity) {
            if (startCity == null) {
                return clearStartCity();
            }
            this.f16912l = true;
            this.f16913m = startCity;
            return this;
        }

        public Option setSy(int i) {
            this.f16905e = true;
            this.f16906f = i;
            return this;
        }

        public Option setTotal(int i) {
            this.f16901a = true;
            this.f16902b = i;
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
            if (hasDisSy()) {
                codedOutputStreamMicro.writeInt32(9, getDisSy());
            }
            if (hasReqTm()) {
                codedOutputStreamMicro.writeString(10, getReqTm());
            }
            if (hasSpathType()) {
                codedOutputStreamMicro.writeInt32(11, getSpathType());
            }
        }
    }

    public static final class Routes extends MessageMicro {
        public static final int CLIMB_FIELD_NUMBER = 2;
        public static final int LEGS_FIELD_NUMBER = 1;
        /* renamed from: a */
        private List<Legs> f17025a = Collections.emptyList();
        /* renamed from: b */
        private boolean f17026b;
        /* renamed from: c */
        private Climb f17027c = null;
        /* renamed from: d */
        private int f17028d = -1;

        public static final class Climb extends MessageMicro {
            public static final int CLIMB_HEIGHT_FIELD_NUMBER = 3;
            public static final int DOWN_DIS_FIELD_NUMBER = 2;
            public static final int UP_DIS_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f16922a;
            /* renamed from: b */
            private int f16923b = 0;
            /* renamed from: c */
            private boolean f16924c;
            /* renamed from: d */
            private int f16925d = 0;
            /* renamed from: e */
            private boolean f16926e;
            /* renamed from: f */
            private int f16927f = 0;
            /* renamed from: g */
            private int f16928g = -1;

            public static Climb parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Climb().mergeFrom(codedInputStreamMicro);
            }

            public static Climb parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Climb) new Climb().mergeFrom(bArr);
            }

            public final Climb clear() {
                clearUpDis();
                clearDownDis();
                clearClimbHeight();
                this.f16928g = -1;
                return this;
            }

            public Climb clearClimbHeight() {
                this.f16926e = false;
                this.f16927f = 0;
                return this;
            }

            public Climb clearDownDis() {
                this.f16924c = false;
                this.f16925d = 0;
                return this;
            }

            public Climb clearUpDis() {
                this.f16922a = false;
                this.f16923b = 0;
                return this;
            }

            public int getCachedSize() {
                if (this.f16928g < 0) {
                    getSerializedSize();
                }
                return this.f16928g;
            }

            public int getClimbHeight() {
                return this.f16927f;
            }

            public int getDownDis() {
                return this.f16925d;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasUpDis()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getUpDis());
                }
                if (hasDownDis()) {
                    i += CodedOutputStreamMicro.computeInt32Size(2, getDownDis());
                }
                if (hasClimbHeight()) {
                    i += CodedOutputStreamMicro.computeInt32Size(3, getClimbHeight());
                }
                this.f16928g = i;
                return i;
            }

            public int getUpDis() {
                return this.f16923b;
            }

            public boolean hasClimbHeight() {
                return this.f16926e;
            }

            public boolean hasDownDis() {
                return this.f16924c;
            }

            public boolean hasUpDis() {
                return this.f16922a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Climb mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            setUpDis(codedInputStreamMicro.readInt32());
                            continue;
                        case 16:
                            setDownDis(codedInputStreamMicro.readInt32());
                            continue;
                        case 24:
                            setClimbHeight(codedInputStreamMicro.readInt32());
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

            public Climb setClimbHeight(int i) {
                this.f16926e = true;
                this.f16927f = i;
                return this;
            }

            public Climb setDownDis(int i) {
                this.f16924c = true;
                this.f16925d = i;
                return this;
            }

            public Climb setUpDis(int i) {
                this.f16922a = true;
                this.f16923b = i;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasUpDis()) {
                    codedOutputStreamMicro.writeInt32(1, getUpDis());
                }
                if (hasDownDis()) {
                    codedOutputStreamMicro.writeInt32(2, getDownDis());
                }
                if (hasClimbHeight()) {
                    codedOutputStreamMicro.writeInt32(3, getClimbHeight());
                }
            }
        }

        public static final class Legs extends MessageMicro {
            public static final int CONNECTED_POIS_FIELD_NUMBER = 11;
            public static final int DISTANCE_FIELD_NUMBER = 5;
            public static final int DURATION_FIELD_NUMBER = 6;
            public static final int END_ADDRESS_FIELD_NUMBER = 4;
            public static final int END_DIST_FIELD_NUMBER = 9;
            public static final int LEG_LINKED_FIELD_NUMBER = 12;
            public static final int SEND_LOCATION_FIELD_NUMBER = 2;
            public static final int SIDE_FIELD_NUMBER = 7;
            public static final int SSTART_LOCATION_FIELD_NUMBER = 1;
            public static final int START_ADDRESS_FIELD_NUMBER = 3;
            public static final int START_DIST_FIELD_NUMBER = 8;
            public static final int STEPS_FIELD_NUMBER = 10;
            /* renamed from: a */
            private List<Steps> f17004a = Collections.emptyList();
            /* renamed from: b */
            private List<Integer> f17005b = Collections.emptyList();
            /* renamed from: c */
            private List<Integer> f17006c = Collections.emptyList();
            /* renamed from: d */
            private boolean f17007d;
            /* renamed from: e */
            private String f17008e = "";
            /* renamed from: f */
            private boolean f17009f;
            /* renamed from: g */
            private String f17010g = "";
            /* renamed from: h */
            private boolean f17011h;
            /* renamed from: i */
            private int f17012i = 0;
            /* renamed from: j */
            private boolean f17013j;
            /* renamed from: k */
            private int f17014k = 0;
            /* renamed from: l */
            private boolean f17015l;
            /* renamed from: m */
            private int f17016m = 0;
            /* renamed from: n */
            private boolean f17017n;
            /* renamed from: o */
            private int f17018o = 0;
            /* renamed from: p */
            private boolean f17019p;
            /* renamed from: q */
            private int f17020q = 0;
            /* renamed from: r */
            private List<ConnectedPois> f17021r = Collections.emptyList();
            /* renamed from: s */
            private boolean f17022s;
            /* renamed from: t */
            private LegLinked f17023t = null;
            /* renamed from: u */
            private int f17024u = -1;

            public static final class ConnectedPois extends MessageMicro {
                public static final int BUILDING_FIELD_NUMBER = 6;
                public static final int FLOOR_FIELD_NUMBER = 5;
                public static final int INFO_FIELD_NUMBER = 3;
                public static final int LOCATION_FIELD_NUMBER = 4;
                public static final int TYPE_DIR_FIELD_NUMBER = 2;
                public static final int TYPE_FIELD_NUMBER = 1;
                /* renamed from: a */
                private boolean f16929a;
                /* renamed from: b */
                private int f16930b = 0;
                /* renamed from: c */
                private boolean f16931c;
                /* renamed from: d */
                private int f16932d = 0;
                /* renamed from: e */
                private boolean f16933e;
                /* renamed from: f */
                private String f16934f = "";
                /* renamed from: g */
                private List<Integer> f16935g = Collections.emptyList();
                /* renamed from: h */
                private boolean f16936h;
                /* renamed from: i */
                private String f16937i = "";
                /* renamed from: j */
                private boolean f16938j;
                /* renamed from: k */
                private String f16939k = "";
                /* renamed from: l */
                private int f16940l = -1;

                public static ConnectedPois parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new ConnectedPois().mergeFrom(codedInputStreamMicro);
                }

                public static ConnectedPois parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (ConnectedPois) new ConnectedPois().mergeFrom(bArr);
                }

                public ConnectedPois addLocation(int i) {
                    if (this.f16935g.isEmpty()) {
                        this.f16935g = new ArrayList();
                    }
                    this.f16935g.add(Integer.valueOf(i));
                    return this;
                }

                public final ConnectedPois clear() {
                    clearType();
                    clearTypeDir();
                    clearInfo();
                    clearLocation();
                    clearFloor();
                    clearBuilding();
                    this.f16940l = -1;
                    return this;
                }

                public ConnectedPois clearBuilding() {
                    this.f16938j = false;
                    this.f16939k = "";
                    return this;
                }

                public ConnectedPois clearFloor() {
                    this.f16936h = false;
                    this.f16937i = "";
                    return this;
                }

                public ConnectedPois clearInfo() {
                    this.f16933e = false;
                    this.f16934f = "";
                    return this;
                }

                public ConnectedPois clearLocation() {
                    this.f16935g = Collections.emptyList();
                    return this;
                }

                public ConnectedPois clearType() {
                    this.f16929a = false;
                    this.f16930b = 0;
                    return this;
                }

                public ConnectedPois clearTypeDir() {
                    this.f16931c = false;
                    this.f16932d = 0;
                    return this;
                }

                public String getBuilding() {
                    return this.f16939k;
                }

                public int getCachedSize() {
                    if (this.f16940l < 0) {
                        getSerializedSize();
                    }
                    return this.f16940l;
                }

                public String getFloor() {
                    return this.f16937i;
                }

                public String getInfo() {
                    return this.f16934f;
                }

                public int getLocation(int i) {
                    return ((Integer) this.f16935g.get(i)).intValue();
                }

                public int getLocationCount() {
                    return this.f16935g.size();
                }

                public List<Integer> getLocationList() {
                    return this.f16935g;
                }

                public int getSerializedSize() {
                    int i = 0;
                    int computeInt32Size = hasType() ? CodedOutputStreamMicro.computeInt32Size(1, getType()) + 0 : 0;
                    if (hasTypeDir()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getTypeDir());
                    }
                    int computeStringSize = hasInfo() ? computeInt32Size + CodedOutputStreamMicro.computeStringSize(3, getInfo()) : computeInt32Size;
                    for (Integer intValue : getLocationList()) {
                        i += CodedOutputStreamMicro.computeInt32SizeNoTag(intValue.intValue());
                    }
                    computeInt32Size = (computeStringSize + i) + (getLocationList().size() * 1);
                    if (hasFloor()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(5, getFloor());
                    }
                    if (hasBuilding()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(6, getBuilding());
                    }
                    this.f16940l = computeInt32Size;
                    return computeInt32Size;
                }

                public int getType() {
                    return this.f16930b;
                }

                public int getTypeDir() {
                    return this.f16932d;
                }

                public boolean hasBuilding() {
                    return this.f16938j;
                }

                public boolean hasFloor() {
                    return this.f16936h;
                }

                public boolean hasInfo() {
                    return this.f16933e;
                }

                public boolean hasType() {
                    return this.f16929a;
                }

                public boolean hasTypeDir() {
                    return this.f16931c;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public ConnectedPois mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                setType(codedInputStreamMicro.readInt32());
                                continue;
                            case 16:
                                setTypeDir(codedInputStreamMicro.readInt32());
                                continue;
                            case 26:
                                setInfo(codedInputStreamMicro.readString());
                                continue;
                            case 32:
                                addLocation(codedInputStreamMicro.readInt32());
                                continue;
                            case 42:
                                setFloor(codedInputStreamMicro.readString());
                                continue;
                            case 50:
                                setBuilding(codedInputStreamMicro.readString());
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

                public ConnectedPois setBuilding(String str) {
                    this.f16938j = true;
                    this.f16939k = str;
                    return this;
                }

                public ConnectedPois setFloor(String str) {
                    this.f16936h = true;
                    this.f16937i = str;
                    return this;
                }

                public ConnectedPois setInfo(String str) {
                    this.f16933e = true;
                    this.f16934f = str;
                    return this;
                }

                public ConnectedPois setLocation(int i, int i2) {
                    this.f16935g.set(i, Integer.valueOf(i2));
                    return this;
                }

                public ConnectedPois setType(int i) {
                    this.f16929a = true;
                    this.f16930b = i;
                    return this;
                }

                public ConnectedPois setTypeDir(int i) {
                    this.f16931c = true;
                    this.f16932d = i;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(1, getType());
                    }
                    if (hasTypeDir()) {
                        codedOutputStreamMicro.writeInt32(2, getTypeDir());
                    }
                    if (hasInfo()) {
                        codedOutputStreamMicro.writeString(3, getInfo());
                    }
                    for (Integer intValue : getLocationList()) {
                        codedOutputStreamMicro.writeInt32(4, intValue.intValue());
                    }
                    if (hasFloor()) {
                        codedOutputStreamMicro.writeString(5, getFloor());
                    }
                    if (hasBuilding()) {
                        codedOutputStreamMicro.writeString(6, getBuilding());
                    }
                }
            }

            public static final class LegLinked extends MessageMicro {
                public static final int NEXT_FIELD_NUMBER = 2;
                public static final int PREV_FIELD_NUMBER = 1;
                /* renamed from: a */
                private boolean f16941a;
                /* renamed from: b */
                private int f16942b = 0;
                /* renamed from: c */
                private boolean f16943c;
                /* renamed from: d */
                private int f16944d = 0;
                /* renamed from: e */
                private int f16945e = -1;

                public static LegLinked parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new LegLinked().mergeFrom(codedInputStreamMicro);
                }

                public static LegLinked parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (LegLinked) new LegLinked().mergeFrom(bArr);
                }

                public final LegLinked clear() {
                    clearPrev();
                    clearNext();
                    this.f16945e = -1;
                    return this;
                }

                public LegLinked clearNext() {
                    this.f16943c = false;
                    this.f16944d = 0;
                    return this;
                }

                public LegLinked clearPrev() {
                    this.f16941a = false;
                    this.f16942b = 0;
                    return this;
                }

                public int getCachedSize() {
                    if (this.f16945e < 0) {
                        getSerializedSize();
                    }
                    return this.f16945e;
                }

                public int getNext() {
                    return this.f16944d;
                }

                public int getPrev() {
                    return this.f16942b;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasPrev()) {
                        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getPrev());
                    }
                    if (hasNext()) {
                        i += CodedOutputStreamMicro.computeInt32Size(2, getNext());
                    }
                    this.f16945e = i;
                    return i;
                }

                public boolean hasNext() {
                    return this.f16943c;
                }

                public boolean hasPrev() {
                    return this.f16941a;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public LegLinked mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                setPrev(codedInputStreamMicro.readInt32());
                                continue;
                            case 16:
                                setNext(codedInputStreamMicro.readInt32());
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

                public LegLinked setNext(int i) {
                    this.f16943c = true;
                    this.f16944d = i;
                    return this;
                }

                public LegLinked setPrev(int i) {
                    this.f16941a = true;
                    this.f16942b = i;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasPrev()) {
                        codedOutputStreamMicro.writeInt32(1, getPrev());
                    }
                    if (hasNext()) {
                        codedOutputStreamMicro.writeInt32(2, getNext());
                    }
                }
            }

            public static final class Steps extends MessageMicro {
                public static final int CIRCLE_ROAD_FIELD_NUMBER = 9;
                public static final int DIRECTION_FIELD_NUMBER = 15;
                public static final int DISTANCE_FIELD_NUMBER = 11;
                public static final int DURATION_FIELD_NUMBER = 12;
                public static final int FIRST_LINK_END_INDEX_FIELD_NUMBER = 5;
                public static final int HAS_PANID_FIELD_NUMBER = 16;
                public static final int INSTRUCTIONS_FIELD_NUMBER = 2;
                public static final int LIGHT_FIELD_NUMBER = 8;
                public static final int LINKS_FIELD_NUMBER = 13;
                public static final int NAME_FIELD_NUMBER = 4;
                public static final int POIS_FIELD_NUMBER = 14;
                public static final int ROAD_WIDTH_FIELD_NUMBER = 10;
                public static final int SEND_LOCATION_FIELD_NUMBER = 18;
                public static final int SPATH_FIELD_NUMBER = 1;
                public static final int SSTART_LOCATION_FIELD_NUMBER = 17;
                public static final int STRAFFICMARK_LOC_FIELD_NUMBER = 19;
                public static final int TRAFFIC_TYPE_FIELD_NUMBER = 20;
                public static final int TURN_TYPE_FIELD_NUMBER = 6;
                public static final int TYPE_FIELD_NUMBER = 3;
                public static final int WALK_TYPE_FIELD_NUMBER = 7;
                /* renamed from: A */
                private int f16969A = 0;
                /* renamed from: B */
                private boolean f16970B;
                /* renamed from: C */
                private int f16971C = 0;
                /* renamed from: D */
                private List<Integer> f16972D = Collections.emptyList();
                /* renamed from: E */
                private List<Integer> f16973E = Collections.emptyList();
                /* renamed from: F */
                private List<Integer> f16974F = Collections.emptyList();
                /* renamed from: G */
                private boolean f16975G;
                /* renamed from: H */
                private int f16976H = 0;
                /* renamed from: I */
                private int f16977I = -1;
                /* renamed from: a */
                private List<Links> f16978a = Collections.emptyList();
                /* renamed from: b */
                private List<Pois> f16979b = Collections.emptyList();
                /* renamed from: c */
                private List<Integer> f16980c = Collections.emptyList();
                /* renamed from: d */
                private boolean f16981d;
                /* renamed from: e */
                private String f16982e = "";
                /* renamed from: f */
                private boolean f16983f;
                /* renamed from: g */
                private int f16984g = 0;
                /* renamed from: h */
                private boolean f16985h;
                /* renamed from: i */
                private String f16986i = "";
                /* renamed from: j */
                private boolean f16987j;
                /* renamed from: k */
                private int f16988k = 0;
                /* renamed from: l */
                private boolean f16989l;
                /* renamed from: m */
                private int f16990m = 0;
                /* renamed from: n */
                private boolean f16991n;
                /* renamed from: o */
                private int f16992o = 0;
                /* renamed from: p */
                private boolean f16993p;
                /* renamed from: q */
                private int f16994q = 0;
                /* renamed from: r */
                private boolean f16995r;
                /* renamed from: s */
                private int f16996s = 0;
                /* renamed from: t */
                private boolean f16997t;
                /* renamed from: u */
                private int f16998u = 0;
                /* renamed from: v */
                private boolean f16999v;
                /* renamed from: w */
                private int f17000w = 0;
                /* renamed from: x */
                private boolean f17001x;
                /* renamed from: y */
                private int f17002y = 0;
                /* renamed from: z */
                private boolean f17003z;

                public static final class Links extends MessageMicro {
                    public static final int HAS_PANID_FIELD_NUMBER = 4;
                    public static final int IDX_FIELD_NUMBER = 2;
                    public static final int ID_FIELD_NUMBER = 1;
                    public static final int LENGTH_FIELD_NUMBER = 3;
                    public static final int LINK_TYPE_FIELD_NUMBER = 5;
                    /* renamed from: a */
                    private boolean f16946a;
                    /* renamed from: b */
                    private String f16947b = "";
                    /* renamed from: c */
                    private boolean f16948c;
                    /* renamed from: d */
                    private int f16949d = 0;
                    /* renamed from: e */
                    private boolean f16950e;
                    /* renamed from: f */
                    private int f16951f = 0;
                    /* renamed from: g */
                    private boolean f16952g;
                    /* renamed from: h */
                    private int f16953h = 0;
                    /* renamed from: i */
                    private boolean f16954i;
                    /* renamed from: j */
                    private int f16955j = 0;
                    /* renamed from: k */
                    private int f16956k = -1;

                    public static Links parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Links().mergeFrom(codedInputStreamMicro);
                    }

                    public static Links parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Links) new Links().mergeFrom(bArr);
                    }

                    public final Links clear() {
                        clearId();
                        clearIdx();
                        clearLength();
                        clearHasPanid();
                        clearLinkType();
                        this.f16956k = -1;
                        return this;
                    }

                    public Links clearHasPanid() {
                        this.f16952g = false;
                        this.f16953h = 0;
                        return this;
                    }

                    public Links clearId() {
                        this.f16946a = false;
                        this.f16947b = "";
                        return this;
                    }

                    public Links clearIdx() {
                        this.f16948c = false;
                        this.f16949d = 0;
                        return this;
                    }

                    public Links clearLength() {
                        this.f16950e = false;
                        this.f16951f = 0;
                        return this;
                    }

                    public Links clearLinkType() {
                        this.f16954i = false;
                        this.f16955j = 0;
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f16956k < 0) {
                            getSerializedSize();
                        }
                        return this.f16956k;
                    }

                    public int getHasPanid() {
                        return this.f16953h;
                    }

                    public String getId() {
                        return this.f16947b;
                    }

                    public int getIdx() {
                        return this.f16949d;
                    }

                    public int getLength() {
                        return this.f16951f;
                    }

                    public int getLinkType() {
                        return this.f16955j;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasId()) {
                            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getId());
                        }
                        if (hasIdx()) {
                            i += CodedOutputStreamMicro.computeInt32Size(2, getIdx());
                        }
                        if (hasLength()) {
                            i += CodedOutputStreamMicro.computeInt32Size(3, getLength());
                        }
                        if (hasHasPanid()) {
                            i += CodedOutputStreamMicro.computeInt32Size(4, getHasPanid());
                        }
                        if (hasLinkType()) {
                            i += CodedOutputStreamMicro.computeInt32Size(5, getLinkType());
                        }
                        this.f16956k = i;
                        return i;
                    }

                    public boolean hasHasPanid() {
                        return this.f16952g;
                    }

                    public boolean hasId() {
                        return this.f16946a;
                    }

                    public boolean hasIdx() {
                        return this.f16948c;
                    }

                    public boolean hasLength() {
                        return this.f16950e;
                    }

                    public boolean hasLinkType() {
                        return this.f16954i;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Links mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    setId(codedInputStreamMicro.readString());
                                    continue;
                                case 16:
                                    setIdx(codedInputStreamMicro.readInt32());
                                    continue;
                                case 24:
                                    setLength(codedInputStreamMicro.readInt32());
                                    continue;
                                case 32:
                                    setHasPanid(codedInputStreamMicro.readInt32());
                                    continue;
                                case 40:
                                    setLinkType(codedInputStreamMicro.readInt32());
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

                    public Links setHasPanid(int i) {
                        this.f16952g = true;
                        this.f16953h = i;
                        return this;
                    }

                    public Links setId(String str) {
                        this.f16946a = true;
                        this.f16947b = str;
                        return this;
                    }

                    public Links setIdx(int i) {
                        this.f16948c = true;
                        this.f16949d = i;
                        return this;
                    }

                    public Links setLength(int i) {
                        this.f16950e = true;
                        this.f16951f = i;
                        return this;
                    }

                    public Links setLinkType(int i) {
                        this.f16954i = true;
                        this.f16955j = i;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasId()) {
                            codedOutputStreamMicro.writeString(1, getId());
                        }
                        if (hasIdx()) {
                            codedOutputStreamMicro.writeInt32(2, getIdx());
                        }
                        if (hasLength()) {
                            codedOutputStreamMicro.writeInt32(3, getLength());
                        }
                        if (hasHasPanid()) {
                            codedOutputStreamMicro.writeInt32(4, getHasPanid());
                        }
                        if (hasLinkType()) {
                            codedOutputStreamMicro.writeInt32(5, getLinkType());
                        }
                    }
                }

                public static final class Pois extends MessageMicro {
                    public static final int HEADING_FIELD_NUMBER = 4;
                    public static final int NAME_FIELD_NUMBER = 1;
                    public static final int PANOID_FIELD_NUMBER = 6;
                    public static final int PITCH_FIELD_NUMBER = 5;
                    public static final int SIDE_FIELD_NUMBER = 3;
                    public static final int SLOCATION_FIELD_NUMBER = 2;
                    /* renamed from: a */
                    private boolean f16957a;
                    /* renamed from: b */
                    private String f16958b = "";
                    /* renamed from: c */
                    private List<Integer> f16959c = Collections.emptyList();
                    /* renamed from: d */
                    private boolean f16960d;
                    /* renamed from: e */
                    private int f16961e = 0;
                    /* renamed from: f */
                    private boolean f16962f;
                    /* renamed from: g */
                    private String f16963g = "";
                    /* renamed from: h */
                    private boolean f16964h;
                    /* renamed from: i */
                    private String f16965i = "";
                    /* renamed from: j */
                    private boolean f16966j;
                    /* renamed from: k */
                    private String f16967k = "";
                    /* renamed from: l */
                    private int f16968l = -1;

                    public static Pois parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Pois().mergeFrom(codedInputStreamMicro);
                    }

                    public static Pois parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Pois) new Pois().mergeFrom(bArr);
                    }

                    public Pois addSlocation(int i) {
                        if (this.f16959c.isEmpty()) {
                            this.f16959c = new ArrayList();
                        }
                        this.f16959c.add(Integer.valueOf(i));
                        return this;
                    }

                    public final Pois clear() {
                        clearName();
                        clearSlocation();
                        clearSide();
                        clearHeading();
                        clearPitch();
                        clearPanoid();
                        this.f16968l = -1;
                        return this;
                    }

                    public Pois clearHeading() {
                        this.f16962f = false;
                        this.f16963g = "";
                        return this;
                    }

                    public Pois clearName() {
                        this.f16957a = false;
                        this.f16958b = "";
                        return this;
                    }

                    public Pois clearPanoid() {
                        this.f16966j = false;
                        this.f16967k = "";
                        return this;
                    }

                    public Pois clearPitch() {
                        this.f16964h = false;
                        this.f16965i = "";
                        return this;
                    }

                    public Pois clearSide() {
                        this.f16960d = false;
                        this.f16961e = 0;
                        return this;
                    }

                    public Pois clearSlocation() {
                        this.f16959c = Collections.emptyList();
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f16968l < 0) {
                            getSerializedSize();
                        }
                        return this.f16968l;
                    }

                    public String getHeading() {
                        return this.f16963g;
                    }

                    public String getName() {
                        return this.f16958b;
                    }

                    public String getPanoid() {
                        return this.f16967k;
                    }

                    public String getPitch() {
                        return this.f16965i;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        int computeStringSize = hasName() ? CodedOutputStreamMicro.computeStringSize(1, getName()) + 0 : 0;
                        for (Integer intValue : getSlocationList()) {
                            i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue());
                        }
                        int size = (computeStringSize + i) + (getSlocationList().size() * 1);
                        if (hasSide()) {
                            size += CodedOutputStreamMicro.computeInt32Size(3, getSide());
                        }
                        if (hasHeading()) {
                            size += CodedOutputStreamMicro.computeStringSize(4, getHeading());
                        }
                        if (hasPitch()) {
                            size += CodedOutputStreamMicro.computeStringSize(5, getPitch());
                        }
                        if (hasPanoid()) {
                            size += CodedOutputStreamMicro.computeStringSize(6, getPanoid());
                        }
                        this.f16968l = size;
                        return size;
                    }

                    public int getSide() {
                        return this.f16961e;
                    }

                    public int getSlocation(int i) {
                        return ((Integer) this.f16959c.get(i)).intValue();
                    }

                    public int getSlocationCount() {
                        return this.f16959c.size();
                    }

                    public List<Integer> getSlocationList() {
                        return this.f16959c;
                    }

                    public boolean hasHeading() {
                        return this.f16962f;
                    }

                    public boolean hasName() {
                        return this.f16957a;
                    }

                    public boolean hasPanoid() {
                        return this.f16966j;
                    }

                    public boolean hasPitch() {
                        return this.f16964h;
                    }

                    public boolean hasSide() {
                        return this.f16960d;
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
                                    setName(codedInputStreamMicro.readString());
                                    continue;
                                case 16:
                                    addSlocation(codedInputStreamMicro.readSInt32());
                                    continue;
                                case 24:
                                    setSide(codedInputStreamMicro.readInt32());
                                    continue;
                                case 34:
                                    setHeading(codedInputStreamMicro.readString());
                                    continue;
                                case 42:
                                    setPitch(codedInputStreamMicro.readString());
                                    continue;
                                case 50:
                                    setPanoid(codedInputStreamMicro.readString());
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

                    public Pois setHeading(String str) {
                        this.f16962f = true;
                        this.f16963g = str;
                        return this;
                    }

                    public Pois setName(String str) {
                        this.f16957a = true;
                        this.f16958b = str;
                        return this;
                    }

                    public Pois setPanoid(String str) {
                        this.f16966j = true;
                        this.f16967k = str;
                        return this;
                    }

                    public Pois setPitch(String str) {
                        this.f16964h = true;
                        this.f16965i = str;
                        return this;
                    }

                    public Pois setSide(int i) {
                        this.f16960d = true;
                        this.f16961e = i;
                        return this;
                    }

                    public Pois setSlocation(int i, int i2) {
                        this.f16959c.set(i, Integer.valueOf(i2));
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasName()) {
                            codedOutputStreamMicro.writeString(1, getName());
                        }
                        for (Integer intValue : getSlocationList()) {
                            codedOutputStreamMicro.writeSInt32(2, intValue.intValue());
                        }
                        if (hasSide()) {
                            codedOutputStreamMicro.writeInt32(3, getSide());
                        }
                        if (hasHeading()) {
                            codedOutputStreamMicro.writeString(4, getHeading());
                        }
                        if (hasPitch()) {
                            codedOutputStreamMicro.writeString(5, getPitch());
                        }
                        if (hasPanoid()) {
                            codedOutputStreamMicro.writeString(6, getPanoid());
                        }
                    }
                }

                public static Steps parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Steps().mergeFrom(codedInputStreamMicro);
                }

                public static Steps parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Steps) new Steps().mergeFrom(bArr);
                }

                public Steps addLinks(Links links) {
                    if (links != null) {
                        if (this.f16978a.isEmpty()) {
                            this.f16978a = new ArrayList();
                        }
                        this.f16978a.add(links);
                    }
                    return this;
                }

                public Steps addPois(Pois pois) {
                    if (pois != null) {
                        if (this.f16979b.isEmpty()) {
                            this.f16979b = new ArrayList();
                        }
                        this.f16979b.add(pois);
                    }
                    return this;
                }

                public Steps addSendLocation(int i) {
                    if (this.f16973E.isEmpty()) {
                        this.f16973E = new ArrayList();
                    }
                    this.f16973E.add(Integer.valueOf(i));
                    return this;
                }

                public Steps addSpath(int i) {
                    if (this.f16980c.isEmpty()) {
                        this.f16980c = new ArrayList();
                    }
                    this.f16980c.add(Integer.valueOf(i));
                    return this;
                }

                public Steps addSstartLocation(int i) {
                    if (this.f16972D.isEmpty()) {
                        this.f16972D = new ArrayList();
                    }
                    this.f16972D.add(Integer.valueOf(i));
                    return this;
                }

                public Steps addStrafficmarkLoc(int i) {
                    if (this.f16974F.isEmpty()) {
                        this.f16974F = new ArrayList();
                    }
                    this.f16974F.add(Integer.valueOf(i));
                    return this;
                }

                public final Steps clear() {
                    clearLinks();
                    clearPois();
                    clearSpath();
                    clearInstructions();
                    clearType();
                    clearName();
                    clearFirstLinkEndIndex();
                    clearTurnType();
                    clearWalkType();
                    clearLight();
                    clearCircleRoad();
                    clearRoadWidth();
                    clearDistance();
                    clearDuration();
                    clearDirection();
                    clearHasPanid();
                    clearSstartLocation();
                    clearSendLocation();
                    clearStrafficmarkLoc();
                    clearTrafficType();
                    this.f16977I = -1;
                    return this;
                }

                public Steps clearCircleRoad() {
                    this.f16995r = false;
                    this.f16996s = 0;
                    return this;
                }

                public Steps clearDirection() {
                    this.f17003z = false;
                    this.f16969A = 0;
                    return this;
                }

                public Steps clearDistance() {
                    this.f16999v = false;
                    this.f17000w = 0;
                    return this;
                }

                public Steps clearDuration() {
                    this.f17001x = false;
                    this.f17002y = 0;
                    return this;
                }

                public Steps clearFirstLinkEndIndex() {
                    this.f16987j = false;
                    this.f16988k = 0;
                    return this;
                }

                public Steps clearHasPanid() {
                    this.f16970B = false;
                    this.f16971C = 0;
                    return this;
                }

                public Steps clearInstructions() {
                    this.f16981d = false;
                    this.f16982e = "";
                    return this;
                }

                public Steps clearLight() {
                    this.f16993p = false;
                    this.f16994q = 0;
                    return this;
                }

                public Steps clearLinks() {
                    this.f16978a = Collections.emptyList();
                    return this;
                }

                public Steps clearName() {
                    this.f16985h = false;
                    this.f16986i = "";
                    return this;
                }

                public Steps clearPois() {
                    this.f16979b = Collections.emptyList();
                    return this;
                }

                public Steps clearRoadWidth() {
                    this.f16997t = false;
                    this.f16998u = 0;
                    return this;
                }

                public Steps clearSendLocation() {
                    this.f16973E = Collections.emptyList();
                    return this;
                }

                public Steps clearSpath() {
                    this.f16980c = Collections.emptyList();
                    return this;
                }

                public Steps clearSstartLocation() {
                    this.f16972D = Collections.emptyList();
                    return this;
                }

                public Steps clearStrafficmarkLoc() {
                    this.f16974F = Collections.emptyList();
                    return this;
                }

                public Steps clearTrafficType() {
                    this.f16975G = false;
                    this.f16976H = 0;
                    return this;
                }

                public Steps clearTurnType() {
                    this.f16989l = false;
                    this.f16990m = 0;
                    return this;
                }

                public Steps clearType() {
                    this.f16983f = false;
                    this.f16984g = 0;
                    return this;
                }

                public Steps clearWalkType() {
                    this.f16991n = false;
                    this.f16992o = 0;
                    return this;
                }

                public int getCachedSize() {
                    if (this.f16977I < 0) {
                        getSerializedSize();
                    }
                    return this.f16977I;
                }

                public int getCircleRoad() {
                    return this.f16996s;
                }

                public int getDirection() {
                    return this.f16969A;
                }

                public int getDistance() {
                    return this.f17000w;
                }

                public int getDuration() {
                    return this.f17002y;
                }

                public int getFirstLinkEndIndex() {
                    return this.f16988k;
                }

                public int getHasPanid() {
                    return this.f16971C;
                }

                public String getInstructions() {
                    return this.f16982e;
                }

                public int getLight() {
                    return this.f16994q;
                }

                public Links getLinks(int i) {
                    return (Links) this.f16978a.get(i);
                }

                public int getLinksCount() {
                    return this.f16978a.size();
                }

                public List<Links> getLinksList() {
                    return this.f16978a;
                }

                public String getName() {
                    return this.f16986i;
                }

                public Pois getPois(int i) {
                    return (Pois) this.f16979b.get(i);
                }

                public int getPoisCount() {
                    return this.f16979b.size();
                }

                public List<Pois> getPoisList() {
                    return this.f16979b;
                }

                public int getRoadWidth() {
                    return this.f16998u;
                }

                public int getSendLocation(int i) {
                    return ((Integer) this.f16973E.get(i)).intValue();
                }

                public int getSendLocationCount() {
                    return this.f16973E.size();
                }

                public List<Integer> getSendLocationList() {
                    return this.f16973E;
                }

                public int getSerializedSize() {
                    int i = 0;
                    int i2 = 0;
                    for (Integer intValue : getSpathList()) {
                        i2 = CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue()) + i2;
                    }
                    int size = (0 + i2) + (getSpathList().size() * 1);
                    if (hasInstructions()) {
                        size += CodedOutputStreamMicro.computeStringSize(2, getInstructions());
                    }
                    if (hasType()) {
                        size += CodedOutputStreamMicro.computeInt32Size(3, getType());
                    }
                    if (hasName()) {
                        size += CodedOutputStreamMicro.computeStringSize(4, getName());
                    }
                    if (hasFirstLinkEndIndex()) {
                        size += CodedOutputStreamMicro.computeInt32Size(5, getFirstLinkEndIndex());
                    }
                    if (hasTurnType()) {
                        size += CodedOutputStreamMicro.computeInt32Size(6, getTurnType());
                    }
                    if (hasWalkType()) {
                        size += CodedOutputStreamMicro.computeInt32Size(7, getWalkType());
                    }
                    if (hasLight()) {
                        size += CodedOutputStreamMicro.computeInt32Size(8, getLight());
                    }
                    if (hasCircleRoad()) {
                        size += CodedOutputStreamMicro.computeInt32Size(9, getCircleRoad());
                    }
                    if (hasRoadWidth()) {
                        size += CodedOutputStreamMicro.computeInt32Size(10, getRoadWidth());
                    }
                    if (hasDistance()) {
                        size += CodedOutputStreamMicro.computeInt32Size(11, getDistance());
                    }
                    if (hasDuration()) {
                        size += CodedOutputStreamMicro.computeInt32Size(12, getDuration());
                    }
                    i2 = size;
                    for (Links computeMessageSize : getLinksList()) {
                        i2 = CodedOutputStreamMicro.computeMessageSize(13, computeMessageSize) + i2;
                    }
                    for (Pois computeMessageSize2 : getPoisList()) {
                        i2 += CodedOutputStreamMicro.computeMessageSize(14, computeMessageSize2);
                    }
                    if (hasDirection()) {
                        i2 += CodedOutputStreamMicro.computeInt32Size(15, getDirection());
                    }
                    if (hasHasPanid()) {
                        i2 += CodedOutputStreamMicro.computeInt32Size(16, getHasPanid());
                    }
                    int i3 = 0;
                    for (Integer intValue2 : getSstartLocationList()) {
                        i3 = CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue2.intValue()) + i3;
                    }
                    i3 = (i2 + i3) + (getSstartLocationList().size() * 2);
                    i2 = 0;
                    for (Integer intValue22 : getSendLocationList()) {
                        i2 = CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue22.intValue()) + i2;
                    }
                    i2 = (getSendLocationList().size() * 2) + (i3 + i2);
                    for (Integer intValue222 : getStrafficmarkLocList()) {
                        i += CodedOutputStreamMicro.computeInt32SizeNoTag(intValue222.intValue());
                    }
                    size = (i2 + i) + (getStrafficmarkLocList().size() * 2);
                    if (hasTrafficType()) {
                        size += CodedOutputStreamMicro.computeInt32Size(20, getTrafficType());
                    }
                    this.f16977I = size;
                    return size;
                }

                public int getSpath(int i) {
                    return ((Integer) this.f16980c.get(i)).intValue();
                }

                public int getSpathCount() {
                    return this.f16980c.size();
                }

                public List<Integer> getSpathList() {
                    return this.f16980c;
                }

                public int getSstartLocation(int i) {
                    return ((Integer) this.f16972D.get(i)).intValue();
                }

                public int getSstartLocationCount() {
                    return this.f16972D.size();
                }

                public List<Integer> getSstartLocationList() {
                    return this.f16972D;
                }

                public int getStrafficmarkLoc(int i) {
                    return ((Integer) this.f16974F.get(i)).intValue();
                }

                public int getStrafficmarkLocCount() {
                    return this.f16974F.size();
                }

                public List<Integer> getStrafficmarkLocList() {
                    return this.f16974F;
                }

                public int getTrafficType() {
                    return this.f16976H;
                }

                public int getTurnType() {
                    return this.f16990m;
                }

                public int getType() {
                    return this.f16984g;
                }

                public int getWalkType() {
                    return this.f16992o;
                }

                public boolean hasCircleRoad() {
                    return this.f16995r;
                }

                public boolean hasDirection() {
                    return this.f17003z;
                }

                public boolean hasDistance() {
                    return this.f16999v;
                }

                public boolean hasDuration() {
                    return this.f17001x;
                }

                public boolean hasFirstLinkEndIndex() {
                    return this.f16987j;
                }

                public boolean hasHasPanid() {
                    return this.f16970B;
                }

                public boolean hasInstructions() {
                    return this.f16981d;
                }

                public boolean hasLight() {
                    return this.f16993p;
                }

                public boolean hasName() {
                    return this.f16985h;
                }

                public boolean hasRoadWidth() {
                    return this.f16997t;
                }

                public boolean hasTrafficType() {
                    return this.f16975G;
                }

                public boolean hasTurnType() {
                    return this.f16989l;
                }

                public boolean hasType() {
                    return this.f16983f;
                }

                public boolean hasWalkType() {
                    return this.f16991n;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Steps mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        MessageMicro links;
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                addSpath(codedInputStreamMicro.readSInt32());
                                continue;
                            case 18:
                                setInstructions(codedInputStreamMicro.readString());
                                continue;
                            case 24:
                                setType(codedInputStreamMicro.readInt32());
                                continue;
                            case 34:
                                setName(codedInputStreamMicro.readString());
                                continue;
                            case 40:
                                setFirstLinkEndIndex(codedInputStreamMicro.readInt32());
                                continue;
                            case 48:
                                setTurnType(codedInputStreamMicro.readInt32());
                                continue;
                            case 56:
                                setWalkType(codedInputStreamMicro.readInt32());
                                continue;
                            case 64:
                                setLight(codedInputStreamMicro.readInt32());
                                continue;
                            case NavCarInfo.CarType_57L /*72*/:
                                setCircleRoad(codedInputStreamMicro.readInt32());
                                continue;
                            case 80:
                                setRoadWidth(codedInputStreamMicro.readInt32());
                                continue;
                            case 88:
                                setDistance(codedInputStreamMicro.readInt32());
                                continue;
                            case 96:
                                setDuration(codedInputStreamMicro.readInt32());
                                continue;
                            case 106:
                                links = new Links();
                                codedInputStreamMicro.readMessage(links);
                                addLinks(links);
                                continue;
                            case 114:
                                links = new Pois();
                                codedInputStreamMicro.readMessage(links);
                                addPois(links);
                                continue;
                            case 120:
                                setDirection(codedInputStreamMicro.readInt32());
                                continue;
                            case 128:
                                setHasPanid(codedInputStreamMicro.readInt32());
                                continue;
                            case RouteLineResConst.LINE_DARK_RED_NORMAL /*136*/:
                                addSstartLocation(codedInputStreamMicro.readSInt32());
                                continue;
                            case 144:
                                addSendLocation(codedInputStreamMicro.readSInt32());
                                continue;
                            case 152:
                                addStrafficmarkLoc(codedInputStreamMicro.readInt32());
                                continue;
                            case 160:
                                setTrafficType(codedInputStreamMicro.readInt32());
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

                public Steps setCircleRoad(int i) {
                    this.f16995r = true;
                    this.f16996s = i;
                    return this;
                }

                public Steps setDirection(int i) {
                    this.f17003z = true;
                    this.f16969A = i;
                    return this;
                }

                public Steps setDistance(int i) {
                    this.f16999v = true;
                    this.f17000w = i;
                    return this;
                }

                public Steps setDuration(int i) {
                    this.f17001x = true;
                    this.f17002y = i;
                    return this;
                }

                public Steps setFirstLinkEndIndex(int i) {
                    this.f16987j = true;
                    this.f16988k = i;
                    return this;
                }

                public Steps setHasPanid(int i) {
                    this.f16970B = true;
                    this.f16971C = i;
                    return this;
                }

                public Steps setInstructions(String str) {
                    this.f16981d = true;
                    this.f16982e = str;
                    return this;
                }

                public Steps setLight(int i) {
                    this.f16993p = true;
                    this.f16994q = i;
                    return this;
                }

                public Steps setLinks(int i, Links links) {
                    if (links != null) {
                        this.f16978a.set(i, links);
                    }
                    return this;
                }

                public Steps setName(String str) {
                    this.f16985h = true;
                    this.f16986i = str;
                    return this;
                }

                public Steps setPois(int i, Pois pois) {
                    if (pois != null) {
                        this.f16979b.set(i, pois);
                    }
                    return this;
                }

                public Steps setRoadWidth(int i) {
                    this.f16997t = true;
                    this.f16998u = i;
                    return this;
                }

                public Steps setSendLocation(int i, int i2) {
                    this.f16973E.set(i, Integer.valueOf(i2));
                    return this;
                }

                public Steps setSpath(int i, int i2) {
                    this.f16980c.set(i, Integer.valueOf(i2));
                    return this;
                }

                public Steps setSstartLocation(int i, int i2) {
                    this.f16972D.set(i, Integer.valueOf(i2));
                    return this;
                }

                public Steps setStrafficmarkLoc(int i, int i2) {
                    this.f16974F.set(i, Integer.valueOf(i2));
                    return this;
                }

                public Steps setTrafficType(int i) {
                    this.f16975G = true;
                    this.f16976H = i;
                    return this;
                }

                public Steps setTurnType(int i) {
                    this.f16989l = true;
                    this.f16990m = i;
                    return this;
                }

                public Steps setType(int i) {
                    this.f16983f = true;
                    this.f16984g = i;
                    return this;
                }

                public Steps setWalkType(int i) {
                    this.f16991n = true;
                    this.f16992o = i;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    for (Integer intValue : getSpathList()) {
                        codedOutputStreamMicro.writeSInt32(1, intValue.intValue());
                    }
                    if (hasInstructions()) {
                        codedOutputStreamMicro.writeString(2, getInstructions());
                    }
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(3, getType());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(4, getName());
                    }
                    if (hasFirstLinkEndIndex()) {
                        codedOutputStreamMicro.writeInt32(5, getFirstLinkEndIndex());
                    }
                    if (hasTurnType()) {
                        codedOutputStreamMicro.writeInt32(6, getTurnType());
                    }
                    if (hasWalkType()) {
                        codedOutputStreamMicro.writeInt32(7, getWalkType());
                    }
                    if (hasLight()) {
                        codedOutputStreamMicro.writeInt32(8, getLight());
                    }
                    if (hasCircleRoad()) {
                        codedOutputStreamMicro.writeInt32(9, getCircleRoad());
                    }
                    if (hasRoadWidth()) {
                        codedOutputStreamMicro.writeInt32(10, getRoadWidth());
                    }
                    if (hasDistance()) {
                        codedOutputStreamMicro.writeInt32(11, getDistance());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(12, getDuration());
                    }
                    for (Links writeMessage : getLinksList()) {
                        codedOutputStreamMicro.writeMessage(13, writeMessage);
                    }
                    for (Pois writeMessage2 : getPoisList()) {
                        codedOutputStreamMicro.writeMessage(14, writeMessage2);
                    }
                    if (hasDirection()) {
                        codedOutputStreamMicro.writeInt32(15, getDirection());
                    }
                    if (hasHasPanid()) {
                        codedOutputStreamMicro.writeInt32(16, getHasPanid());
                    }
                    for (Integer intValue2 : getSstartLocationList()) {
                        codedOutputStreamMicro.writeSInt32(17, intValue2.intValue());
                    }
                    for (Integer intValue22 : getSendLocationList()) {
                        codedOutputStreamMicro.writeSInt32(18, intValue22.intValue());
                    }
                    for (Integer intValue222 : getStrafficmarkLocList()) {
                        codedOutputStreamMicro.writeInt32(19, intValue222.intValue());
                    }
                    if (hasTrafficType()) {
                        codedOutputStreamMicro.writeInt32(20, getTrafficType());
                    }
                }
            }

            public static Legs parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Legs().mergeFrom(codedInputStreamMicro);
            }

            public static Legs parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Legs) new Legs().mergeFrom(bArr);
            }

            public Legs addConnectedPois(ConnectedPois connectedPois) {
                if (connectedPois != null) {
                    if (this.f17021r.isEmpty()) {
                        this.f17021r = new ArrayList();
                    }
                    this.f17021r.add(connectedPois);
                }
                return this;
            }

            public Legs addSendLocation(int i) {
                if (this.f17006c.isEmpty()) {
                    this.f17006c = new ArrayList();
                }
                this.f17006c.add(Integer.valueOf(i));
                return this;
            }

            public Legs addSstartLocation(int i) {
                if (this.f17005b.isEmpty()) {
                    this.f17005b = new ArrayList();
                }
                this.f17005b.add(Integer.valueOf(i));
                return this;
            }

            public Legs addSteps(Steps steps) {
                if (steps != null) {
                    if (this.f17004a.isEmpty()) {
                        this.f17004a = new ArrayList();
                    }
                    this.f17004a.add(steps);
                }
                return this;
            }

            public final Legs clear() {
                clearSteps();
                clearSstartLocation();
                clearSendLocation();
                clearStartAddress();
                clearEndAddress();
                clearDistance();
                clearDuration();
                clearSide();
                clearStartDist();
                clearEndDist();
                clearConnectedPois();
                clearLegLinked();
                this.f17024u = -1;
                return this;
            }

            public Legs clearConnectedPois() {
                this.f17021r = Collections.emptyList();
                return this;
            }

            public Legs clearDistance() {
                this.f17011h = false;
                this.f17012i = 0;
                return this;
            }

            public Legs clearDuration() {
                this.f17013j = false;
                this.f17014k = 0;
                return this;
            }

            public Legs clearEndAddress() {
                this.f17009f = false;
                this.f17010g = "";
                return this;
            }

            public Legs clearEndDist() {
                this.f17019p = false;
                this.f17020q = 0;
                return this;
            }

            public Legs clearLegLinked() {
                this.f17022s = false;
                this.f17023t = null;
                return this;
            }

            public Legs clearSendLocation() {
                this.f17006c = Collections.emptyList();
                return this;
            }

            public Legs clearSide() {
                this.f17015l = false;
                this.f17016m = 0;
                return this;
            }

            public Legs clearSstartLocation() {
                this.f17005b = Collections.emptyList();
                return this;
            }

            public Legs clearStartAddress() {
                this.f17007d = false;
                this.f17008e = "";
                return this;
            }

            public Legs clearStartDist() {
                this.f17017n = false;
                this.f17018o = 0;
                return this;
            }

            public Legs clearSteps() {
                this.f17004a = Collections.emptyList();
                return this;
            }

            public int getCachedSize() {
                if (this.f17024u < 0) {
                    getSerializedSize();
                }
                return this.f17024u;
            }

            public ConnectedPois getConnectedPois(int i) {
                return (ConnectedPois) this.f17021r.get(i);
            }

            public int getConnectedPoisCount() {
                return this.f17021r.size();
            }

            public List<ConnectedPois> getConnectedPoisList() {
                return this.f17021r;
            }

            public int getDistance() {
                return this.f17012i;
            }

            public int getDuration() {
                return this.f17014k;
            }

            public String getEndAddress() {
                return this.f17010g;
            }

            public int getEndDist() {
                return this.f17020q;
            }

            public LegLinked getLegLinked() {
                return this.f17023t;
            }

            public int getSendLocation(int i) {
                return ((Integer) this.f17006c.get(i)).intValue();
            }

            public int getSendLocationCount() {
                return this.f17006c.size();
            }

            public List<Integer> getSendLocationList() {
                return this.f17006c;
            }

            public int getSerializedSize() {
                int i = 0;
                int i2 = 0;
                for (Integer intValue : getSstartLocationList()) {
                    i2 = CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue.intValue()) + i2;
                }
                i2 = (getSstartLocationList().size() * 1) + (0 + i2);
                for (Integer intValue2 : getSendLocationList()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(intValue2.intValue());
                }
                int size = (i2 + i) + (getSendLocationList().size() * 1);
                if (hasStartAddress()) {
                    size += CodedOutputStreamMicro.computeStringSize(3, getStartAddress());
                }
                if (hasEndAddress()) {
                    size += CodedOutputStreamMicro.computeStringSize(4, getEndAddress());
                }
                if (hasDistance()) {
                    size += CodedOutputStreamMicro.computeInt32Size(5, getDistance());
                }
                if (hasDuration()) {
                    size += CodedOutputStreamMicro.computeInt32Size(6, getDuration());
                }
                if (hasSide()) {
                    size += CodedOutputStreamMicro.computeInt32Size(7, getSide());
                }
                if (hasStartDist()) {
                    size += CodedOutputStreamMicro.computeInt32Size(8, getStartDist());
                }
                if (hasEndDist()) {
                    size += CodedOutputStreamMicro.computeInt32Size(9, getEndDist());
                }
                i2 = size;
                for (Steps computeMessageSize : getStepsList()) {
                    i2 = CodedOutputStreamMicro.computeMessageSize(10, computeMessageSize) + i2;
                }
                for (ConnectedPois computeMessageSize2 : getConnectedPoisList()) {
                    i2 += CodedOutputStreamMicro.computeMessageSize(11, computeMessageSize2);
                }
                if (hasLegLinked()) {
                    i2 += CodedOutputStreamMicro.computeMessageSize(12, getLegLinked());
                }
                this.f17024u = i2;
                return i2;
            }

            public int getSide() {
                return this.f17016m;
            }

            public int getSstartLocation(int i) {
                return ((Integer) this.f17005b.get(i)).intValue();
            }

            public int getSstartLocationCount() {
                return this.f17005b.size();
            }

            public List<Integer> getSstartLocationList() {
                return this.f17005b;
            }

            public String getStartAddress() {
                return this.f17008e;
            }

            public int getStartDist() {
                return this.f17018o;
            }

            public Steps getSteps(int i) {
                return (Steps) this.f17004a.get(i);
            }

            public int getStepsCount() {
                return this.f17004a.size();
            }

            public List<Steps> getStepsList() {
                return this.f17004a;
            }

            public boolean hasDistance() {
                return this.f17011h;
            }

            public boolean hasDuration() {
                return this.f17013j;
            }

            public boolean hasEndAddress() {
                return this.f17009f;
            }

            public boolean hasEndDist() {
                return this.f17019p;
            }

            public boolean hasLegLinked() {
                return this.f17022s;
            }

            public boolean hasSide() {
                return this.f17015l;
            }

            public boolean hasStartAddress() {
                return this.f17007d;
            }

            public boolean hasStartDist() {
                return this.f17017n;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Legs mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    MessageMicro steps;
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            addSstartLocation(codedInputStreamMicro.readSInt32());
                            continue;
                        case 16:
                            addSendLocation(codedInputStreamMicro.readSInt32());
                            continue;
                        case 26:
                            setStartAddress(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setEndAddress(codedInputStreamMicro.readString());
                            continue;
                        case 40:
                            setDistance(codedInputStreamMicro.readInt32());
                            continue;
                        case 48:
                            setDuration(codedInputStreamMicro.readInt32());
                            continue;
                        case 56:
                            setSide(codedInputStreamMicro.readInt32());
                            continue;
                        case 64:
                            setStartDist(codedInputStreamMicro.readInt32());
                            continue;
                        case NavCarInfo.CarType_57L /*72*/:
                            setEndDist(codedInputStreamMicro.readInt32());
                            continue;
                        case 82:
                            steps = new Steps();
                            codedInputStreamMicro.readMessage(steps);
                            addSteps(steps);
                            continue;
                        case 90:
                            steps = new ConnectedPois();
                            codedInputStreamMicro.readMessage(steps);
                            addConnectedPois(steps);
                            continue;
                        case 98:
                            steps = new LegLinked();
                            codedInputStreamMicro.readMessage(steps);
                            setLegLinked(steps);
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

            public Legs setConnectedPois(int i, ConnectedPois connectedPois) {
                if (connectedPois != null) {
                    this.f17021r.set(i, connectedPois);
                }
                return this;
            }

            public Legs setDistance(int i) {
                this.f17011h = true;
                this.f17012i = i;
                return this;
            }

            public Legs setDuration(int i) {
                this.f17013j = true;
                this.f17014k = i;
                return this;
            }

            public Legs setEndAddress(String str) {
                this.f17009f = true;
                this.f17010g = str;
                return this;
            }

            public Legs setEndDist(int i) {
                this.f17019p = true;
                this.f17020q = i;
                return this;
            }

            public Legs setLegLinked(LegLinked legLinked) {
                if (legLinked == null) {
                    return clearLegLinked();
                }
                this.f17022s = true;
                this.f17023t = legLinked;
                return this;
            }

            public Legs setSendLocation(int i, int i2) {
                this.f17006c.set(i, Integer.valueOf(i2));
                return this;
            }

            public Legs setSide(int i) {
                this.f17015l = true;
                this.f17016m = i;
                return this;
            }

            public Legs setSstartLocation(int i, int i2) {
                this.f17005b.set(i, Integer.valueOf(i2));
                return this;
            }

            public Legs setStartAddress(String str) {
                this.f17007d = true;
                this.f17008e = str;
                return this;
            }

            public Legs setStartDist(int i) {
                this.f17017n = true;
                this.f17018o = i;
                return this;
            }

            public Legs setSteps(int i, Steps steps) {
                if (steps != null) {
                    this.f17004a.set(i, steps);
                }
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                for (Integer intValue : getSstartLocationList()) {
                    codedOutputStreamMicro.writeSInt32(1, intValue.intValue());
                }
                for (Integer intValue2 : getSendLocationList()) {
                    codedOutputStreamMicro.writeSInt32(2, intValue2.intValue());
                }
                if (hasStartAddress()) {
                    codedOutputStreamMicro.writeString(3, getStartAddress());
                }
                if (hasEndAddress()) {
                    codedOutputStreamMicro.writeString(4, getEndAddress());
                }
                if (hasDistance()) {
                    codedOutputStreamMicro.writeInt32(5, getDistance());
                }
                if (hasDuration()) {
                    codedOutputStreamMicro.writeInt32(6, getDuration());
                }
                if (hasSide()) {
                    codedOutputStreamMicro.writeInt32(7, getSide());
                }
                if (hasStartDist()) {
                    codedOutputStreamMicro.writeInt32(8, getStartDist());
                }
                if (hasEndDist()) {
                    codedOutputStreamMicro.writeInt32(9, getEndDist());
                }
                for (Steps writeMessage : getStepsList()) {
                    codedOutputStreamMicro.writeMessage(10, writeMessage);
                }
                for (ConnectedPois writeMessage2 : getConnectedPoisList()) {
                    codedOutputStreamMicro.writeMessage(11, writeMessage2);
                }
                if (hasLegLinked()) {
                    codedOutputStreamMicro.writeMessage(12, getLegLinked());
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
                if (this.f17025a.isEmpty()) {
                    this.f17025a = new ArrayList();
                }
                this.f17025a.add(legs);
            }
            return this;
        }

        public final Routes clear() {
            clearLegs();
            clearClimb();
            this.f17028d = -1;
            return this;
        }

        public Routes clearClimb() {
            this.f17026b = false;
            this.f17027c = null;
            return this;
        }

        public Routes clearLegs() {
            this.f17025a = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f17028d < 0) {
                getSerializedSize();
            }
            return this.f17028d;
        }

        public Climb getClimb() {
            return this.f17027c;
        }

        public Legs getLegs(int i) {
            return (Legs) this.f17025a.get(i);
        }

        public int getLegsCount() {
            return this.f17025a.size();
        }

        public List<Legs> getLegsList() {
            return this.f17025a;
        }

        public int getSerializedSize() {
            int i = 0;
            for (Legs computeMessageSize : getLegsList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            if (hasClimb()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getClimb());
            }
            this.f17028d = i;
            return i;
        }

        public boolean hasClimb() {
            return this.f17026b;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Routes mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro legs;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        legs = new Legs();
                        codedInputStreamMicro.readMessage(legs);
                        addLegs(legs);
                        continue;
                    case 18:
                        legs = new Climb();
                        codedInputStreamMicro.readMessage(legs);
                        setClimb(legs);
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

        public Routes setClimb(Climb climb) {
            if (climb == null) {
                return clearClimb();
            }
            this.f17026b = true;
            this.f17027c = climb;
            return this;
        }

        public Routes setLegs(int i, Legs legs) {
            if (legs != null) {
                this.f17025a.set(i, legs);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (Legs writeMessage : getLegsList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
            if (hasClimb()) {
                codedOutputStreamMicro.writeMessage(2, getClimb());
            }
        }
    }

    public static final class Taxi extends MessageMicro {
        public static final int DETAIL_FIELD_NUMBER = 4;
        public static final int DISTANCE_FIELD_NUMBER = 1;
        public static final int DURATION_FIELD_NUMBER = 2;
        public static final int REMARK_FIELD_NUMBER = 3;
        /* renamed from: a */
        private boolean f17038a;
        /* renamed from: b */
        private String f17039b = "";
        /* renamed from: c */
        private boolean f17040c;
        /* renamed from: d */
        private String f17041d = "";
        /* renamed from: e */
        private boolean f17042e;
        /* renamed from: f */
        private String f17043f = "";
        /* renamed from: g */
        private List<Detail> f17044g = Collections.emptyList();
        /* renamed from: h */
        private int f17045h = -1;

        public static final class Detail extends MessageMicro {
            public static final int DESC_FIELD_NUMBER = 4;
            public static final int KM_PRICE_FIELD_NUMBER = 1;
            public static final int START_PRICE_FIELD_NUMBER = 2;
            public static final int TOTAL_PRICE_FIELD_NUMBER = 3;
            /* renamed from: a */
            private boolean f17029a;
            /* renamed from: b */
            private String f17030b = "";
            /* renamed from: c */
            private boolean f17031c;
            /* renamed from: d */
            private String f17032d = "";
            /* renamed from: e */
            private boolean f17033e;
            /* renamed from: f */
            private String f17034f = "";
            /* renamed from: g */
            private boolean f17035g;
            /* renamed from: h */
            private String f17036h = "";
            /* renamed from: i */
            private int f17037i = -1;

            public static Detail parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Detail().mergeFrom(codedInputStreamMicro);
            }

            public static Detail parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Detail) new Detail().mergeFrom(bArr);
            }

            public final Detail clear() {
                clearKmPrice();
                clearStartPrice();
                clearTotalPrice();
                clearDesc();
                this.f17037i = -1;
                return this;
            }

            public Detail clearDesc() {
                this.f17035g = false;
                this.f17036h = "";
                return this;
            }

            public Detail clearKmPrice() {
                this.f17029a = false;
                this.f17030b = "";
                return this;
            }

            public Detail clearStartPrice() {
                this.f17031c = false;
                this.f17032d = "";
                return this;
            }

            public Detail clearTotalPrice() {
                this.f17033e = false;
                this.f17034f = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f17037i < 0) {
                    getSerializedSize();
                }
                return this.f17037i;
            }

            public String getDesc() {
                return this.f17036h;
            }

            public String getKmPrice() {
                return this.f17030b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasKmPrice()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getKmPrice());
                }
                if (hasStartPrice()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getStartPrice());
                }
                if (hasTotalPrice()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getTotalPrice());
                }
                if (hasDesc()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getDesc());
                }
                this.f17037i = i;
                return i;
            }

            public String getStartPrice() {
                return this.f17032d;
            }

            public String getTotalPrice() {
                return this.f17034f;
            }

            public boolean hasDesc() {
                return this.f17035g;
            }

            public boolean hasKmPrice() {
                return this.f17029a;
            }

            public boolean hasStartPrice() {
                return this.f17031c;
            }

            public boolean hasTotalPrice() {
                return this.f17033e;
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
                            setKmPrice(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setStartPrice(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setTotalPrice(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setDesc(codedInputStreamMicro.readString());
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
                this.f17035g = true;
                this.f17036h = str;
                return this;
            }

            public Detail setKmPrice(String str) {
                this.f17029a = true;
                this.f17030b = str;
                return this;
            }

            public Detail setStartPrice(String str) {
                this.f17031c = true;
                this.f17032d = str;
                return this;
            }

            public Detail setTotalPrice(String str) {
                this.f17033e = true;
                this.f17034f = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasKmPrice()) {
                    codedOutputStreamMicro.writeString(1, getKmPrice());
                }
                if (hasStartPrice()) {
                    codedOutputStreamMicro.writeString(2, getStartPrice());
                }
                if (hasTotalPrice()) {
                    codedOutputStreamMicro.writeString(3, getTotalPrice());
                }
                if (hasDesc()) {
                    codedOutputStreamMicro.writeString(4, getDesc());
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
                if (this.f17044g.isEmpty()) {
                    this.f17044g = new ArrayList();
                }
                this.f17044g.add(detail);
            }
            return this;
        }

        public final Taxi clear() {
            clearDistance();
            clearDuration();
            clearRemark();
            clearDetail();
            this.f17045h = -1;
            return this;
        }

        public Taxi clearDetail() {
            this.f17044g = Collections.emptyList();
            return this;
        }

        public Taxi clearDistance() {
            this.f17038a = false;
            this.f17039b = "";
            return this;
        }

        public Taxi clearDuration() {
            this.f17040c = false;
            this.f17041d = "";
            return this;
        }

        public Taxi clearRemark() {
            this.f17042e = false;
            this.f17043f = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f17045h < 0) {
                getSerializedSize();
            }
            return this.f17045h;
        }

        public Detail getDetail(int i) {
            return (Detail) this.f17044g.get(i);
        }

        public int getDetailCount() {
            return this.f17044g.size();
        }

        public List<Detail> getDetailList() {
            return this.f17044g;
        }

        public String getDistance() {
            return this.f17039b;
        }

        public String getDuration() {
            return this.f17041d;
        }

        public String getRemark() {
            return this.f17043f;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasDistance()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getDistance());
            }
            if (hasDuration()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getDuration());
            }
            if (hasRemark()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getRemark());
            }
            int i2 = i;
            for (Detail computeMessageSize : getDetailList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(4, computeMessageSize) + i2;
            }
            this.f17045h = i2;
            return i2;
        }

        public boolean hasDistance() {
            return this.f17038a;
        }

        public boolean hasDuration() {
            return this.f17040c;
        }

        public boolean hasRemark() {
            return this.f17042e;
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
                    case 10:
                        setDistance(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setDuration(codedInputStreamMicro.readString());
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
                this.f17044g.set(i, detail);
            }
            return this;
        }

        public Taxi setDistance(String str) {
            this.f17038a = true;
            this.f17039b = str;
            return this;
        }

        public Taxi setDuration(String str) {
            this.f17040c = true;
            this.f17041d = str;
            return this;
        }

        public Taxi setRemark(String str) {
            this.f17042e = true;
            this.f17043f = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasDistance()) {
                codedOutputStreamMicro.writeString(1, getDistance());
            }
            if (hasDuration()) {
                codedOutputStreamMicro.writeString(2, getDuration());
            }
            if (hasRemark()) {
                codedOutputStreamMicro.writeString(3, getRemark());
            }
            for (Detail writeMessage : getDetailList()) {
                codedOutputStreamMicro.writeMessage(4, writeMessage);
            }
        }
    }

    public static WalkPlan parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new WalkPlan().mergeFrom(codedInputStreamMicro);
    }

    public static WalkPlan parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (WalkPlan) new WalkPlan().mergeFrom(bArr);
    }

    public WalkPlan addIndoorNavis(IndoorNavi indoorNavi) {
        if (indoorNavi != null) {
            if (this.f17053h.isEmpty()) {
                this.f17053h = new ArrayList();
            }
            this.f17053h.add(indoorNavi);
        }
        return this;
    }

    public WalkPlan addRoutes(Routes routes) {
        if (routes != null) {
            if (this.f17048c.isEmpty()) {
                this.f17048c = new ArrayList();
            }
            this.f17048c.add(routes);
        }
        return this;
    }

    public final WalkPlan clear() {
        clearTaxi();
        clearRoutes();
        clearOption();
        clearCurrentCity();
        clearIndoorNavis();
        this.f17054i = -1;
        return this;
    }

    public WalkPlan clearCurrentCity() {
        this.f17051f = false;
        this.f17052g = null;
        return this;
    }

    public WalkPlan clearIndoorNavis() {
        this.f17053h = Collections.emptyList();
        return this;
    }

    public WalkPlan clearOption() {
        this.f17049d = false;
        this.f17050e = null;
        return this;
    }

    public WalkPlan clearRoutes() {
        this.f17048c = Collections.emptyList();
        return this;
    }

    public WalkPlan clearTaxi() {
        this.f17046a = false;
        this.f17047b = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f17054i < 0) {
            getSerializedSize();
        }
        return this.f17054i;
    }

    public CurrentCity getCurrentCity() {
        return this.f17052g;
    }

    public IndoorNavi getIndoorNavis(int i) {
        return (IndoorNavi) this.f17053h.get(i);
    }

    public int getIndoorNavisCount() {
        return this.f17053h.size();
    }

    public List<IndoorNavi> getIndoorNavisList() {
        return this.f17053h;
    }

    public Option getOption() {
        return this.f17050e;
    }

    public Routes getRoutes(int i) {
        return (Routes) this.f17048c.get(i);
    }

    public int getRoutesCount() {
        return this.f17048c.size();
    }

    public List<Routes> getRoutesList() {
        return this.f17048c;
    }

    public int getSerializedSize() {
        int i = 0;
        for (Routes computeMessageSize : getRoutesList()) {
            i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
        }
        if (hasTaxi()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getTaxi());
        }
        if (hasOption()) {
            i += CodedOutputStreamMicro.computeMessageSize(3, getOption());
        }
        if (hasCurrentCity()) {
            i += CodedOutputStreamMicro.computeMessageSize(4, getCurrentCity());
        }
        for (IndoorNavi computeMessageSize2 : getIndoorNavisList()) {
            i += CodedOutputStreamMicro.computeMessageSize(5, computeMessageSize2);
        }
        this.f17054i = i;
        return i;
    }

    public Taxi getTaxi() {
        return this.f17047b;
    }

    public boolean hasCurrentCity() {
        return this.f17051f;
    }

    public boolean hasOption() {
        return this.f17049d;
    }

    public boolean hasTaxi() {
        return this.f17046a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public WalkPlan mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro routes;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    routes = new Routes();
                    codedInputStreamMicro.readMessage(routes);
                    addRoutes(routes);
                    continue;
                case 18:
                    routes = new Taxi();
                    codedInputStreamMicro.readMessage(routes);
                    setTaxi(routes);
                    continue;
                case 26:
                    routes = new Option();
                    codedInputStreamMicro.readMessage(routes);
                    setOption(routes);
                    continue;
                case 34:
                    routes = new CurrentCity();
                    codedInputStreamMicro.readMessage(routes);
                    setCurrentCity(routes);
                    continue;
                case 42:
                    routes = new IndoorNavi();
                    codedInputStreamMicro.readMessage(routes);
                    addIndoorNavis(routes);
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

    public WalkPlan setCurrentCity(CurrentCity currentCity) {
        if (currentCity == null) {
            return clearCurrentCity();
        }
        this.f17051f = true;
        this.f17052g = currentCity;
        return this;
    }

    public WalkPlan setIndoorNavis(int i, IndoorNavi indoorNavi) {
        if (indoorNavi != null) {
            this.f17053h.set(i, indoorNavi);
        }
        return this;
    }

    public WalkPlan setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f17049d = true;
        this.f17050e = option;
        return this;
    }

    public WalkPlan setRoutes(int i, Routes routes) {
        if (routes != null) {
            this.f17048c.set(i, routes);
        }
        return this;
    }

    public WalkPlan setTaxi(Taxi taxi) {
        if (taxi == null) {
            return clearTaxi();
        }
        this.f17046a = true;
        this.f17047b = taxi;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (Routes writeMessage : getRoutesList()) {
            codedOutputStreamMicro.writeMessage(1, writeMessage);
        }
        if (hasTaxi()) {
            codedOutputStreamMicro.writeMessage(2, getTaxi());
        }
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(3, getOption());
        }
        if (hasCurrentCity()) {
            codedOutputStreamMicro.writeMessage(4, getCurrentCity());
        }
        for (IndoorNavi writeMessage2 : getIndoorNavisList()) {
            codedOutputStreamMicro.writeMessage(5, writeMessage2);
        }
    }
}
