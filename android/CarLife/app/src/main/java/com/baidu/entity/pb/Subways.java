package com.baidu.entity.pb;

import com.baidu.baidunavis.model.NavCarInfo;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Subways extends MessageMicro {
    public static final int L_FIELD_NUMBER = 2;
    public static final int SW_XMLATTR_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f14751a;
    /* renamed from: b */
    private SwXmlattr f14752b = null;
    /* renamed from: c */
    private List<C3151L> f14753c = Collections.emptyList();
    /* renamed from: d */
    private int f14754d = -1;

    /* renamed from: com.baidu.entity.pb.Subways$L */
    public static final class C3151L extends MessageMicro {
        public static final int L_XMLATTR_FIELD_NUMBER = 1;
        public static final int P_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f14728a;
        /* renamed from: b */
        private LXmlattr f14729b = null;
        /* renamed from: c */
        private List<C3150P> f14730c = Collections.emptyList();
        /* renamed from: d */
        private int f14731d = -1;

        /* renamed from: com.baidu.entity.pb.Subways$L$LXmlattr */
        public static final class LXmlattr extends MessageMicro {
            public static final int LBR_FIELD_NUMBER = 8;
            public static final int LBX_FIELD_NUMBER = 6;
            public static final int LBY_FIELD_NUMBER = 7;
            public static final int LB_FIELD_NUMBER = 2;
            public static final int LC_FIELD_NUMBER = 9;
            public static final int LID_FIELD_NUMBER = 1;
            public static final int LOOP_FIELD_NUMBER = 5;
            public static final int N_FIELD_NUMBER = 4;
            public static final int SLB_FIELD_NUMBER = 3;
            public static final int UID2_FIELD_NUMBER = 11;
            public static final int UID_FIELD_NUMBER = 10;
            /* renamed from: a */
            private boolean f14671a;
            /* renamed from: b */
            private String f14672b = "";
            /* renamed from: c */
            private boolean f14673c;
            /* renamed from: d */
            private String f14674d = "";
            /* renamed from: e */
            private boolean f14675e;
            /* renamed from: f */
            private String f14676f = "";
            /* renamed from: g */
            private boolean f14677g;
            /* renamed from: h */
            private String f14678h = "";
            /* renamed from: i */
            private boolean f14679i;
            /* renamed from: j */
            private boolean f14680j = false;
            /* renamed from: k */
            private boolean f14681k;
            /* renamed from: l */
            private double f14682l = 0.0d;
            /* renamed from: m */
            private boolean f14683m;
            /* renamed from: n */
            private double f14684n = 0.0d;
            /* renamed from: o */
            private boolean f14685o;
            /* renamed from: p */
            private double f14686p = 0.0d;
            /* renamed from: q */
            private boolean f14687q;
            /* renamed from: r */
            private String f14688r = "";
            /* renamed from: s */
            private boolean f14689s;
            /* renamed from: t */
            private String f14690t = "";
            /* renamed from: u */
            private boolean f14691u;
            /* renamed from: v */
            private String f14692v = "";
            /* renamed from: w */
            private int f14693w = -1;

            public static LXmlattr parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new LXmlattr().mergeFrom(codedInputStreamMicro);
            }

            public static LXmlattr parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (LXmlattr) new LXmlattr().mergeFrom(bArr);
            }

            public final LXmlattr clear() {
                clearLid();
                clearLb();
                clearSlb();
                clearN();
                clearLoop();
                clearLbx();
                clearLby();
                clearLbr();
                clearLc();
                clearUid();
                clearUid2();
                this.f14693w = -1;
                return this;
            }

            public LXmlattr clearLb() {
                this.f14673c = false;
                this.f14674d = "";
                return this;
            }

            public LXmlattr clearLbr() {
                this.f14685o = false;
                this.f14686p = 0.0d;
                return this;
            }

            public LXmlattr clearLbx() {
                this.f14681k = false;
                this.f14682l = 0.0d;
                return this;
            }

            public LXmlattr clearLby() {
                this.f14683m = false;
                this.f14684n = 0.0d;
                return this;
            }

            public LXmlattr clearLc() {
                this.f14687q = false;
                this.f14688r = "";
                return this;
            }

            public LXmlattr clearLid() {
                this.f14671a = false;
                this.f14672b = "";
                return this;
            }

            public LXmlattr clearLoop() {
                this.f14679i = false;
                this.f14680j = false;
                return this;
            }

            public LXmlattr clearN() {
                this.f14677g = false;
                this.f14678h = "";
                return this;
            }

            public LXmlattr clearSlb() {
                this.f14675e = false;
                this.f14676f = "";
                return this;
            }

            public LXmlattr clearUid() {
                this.f14689s = false;
                this.f14690t = "";
                return this;
            }

            public LXmlattr clearUid2() {
                this.f14691u = false;
                this.f14692v = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f14693w < 0) {
                    getSerializedSize();
                }
                return this.f14693w;
            }

            public String getLb() {
                return this.f14674d;
            }

            public double getLbr() {
                return this.f14686p;
            }

            public double getLbx() {
                return this.f14682l;
            }

            public double getLby() {
                return this.f14684n;
            }

            public String getLc() {
                return this.f14688r;
            }

            public String getLid() {
                return this.f14672b;
            }

            public boolean getLoop() {
                return this.f14680j;
            }

            public String getN() {
                return this.f14678h;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasLid()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getLid());
                }
                if (hasLb()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getLb());
                }
                if (hasSlb()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getSlb());
                }
                if (hasN()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getN());
                }
                if (hasLoop()) {
                    i += CodedOutputStreamMicro.computeBoolSize(5, getLoop());
                }
                if (hasLbx()) {
                    i += CodedOutputStreamMicro.computeDoubleSize(6, getLbx());
                }
                if (hasLby()) {
                    i += CodedOutputStreamMicro.computeDoubleSize(7, getLby());
                }
                if (hasLbr()) {
                    i += CodedOutputStreamMicro.computeDoubleSize(8, getLbr());
                }
                if (hasLc()) {
                    i += CodedOutputStreamMicro.computeStringSize(9, getLc());
                }
                if (hasUid()) {
                    i += CodedOutputStreamMicro.computeStringSize(10, getUid());
                }
                if (hasUid2()) {
                    i += CodedOutputStreamMicro.computeStringSize(11, getUid2());
                }
                this.f14693w = i;
                return i;
            }

            public String getSlb() {
                return this.f14676f;
            }

            public String getUid() {
                return this.f14690t;
            }

            public String getUid2() {
                return this.f14692v;
            }

            public boolean hasLb() {
                return this.f14673c;
            }

            public boolean hasLbr() {
                return this.f14685o;
            }

            public boolean hasLbx() {
                return this.f14681k;
            }

            public boolean hasLby() {
                return this.f14683m;
            }

            public boolean hasLc() {
                return this.f14687q;
            }

            public boolean hasLid() {
                return this.f14671a;
            }

            public boolean hasLoop() {
                return this.f14679i;
            }

            public boolean hasN() {
                return this.f14677g;
            }

            public boolean hasSlb() {
                return this.f14675e;
            }

            public boolean hasUid() {
                return this.f14689s;
            }

            public boolean hasUid2() {
                return this.f14691u;
            }

            public final boolean isInitialized() {
                return true;
            }

            public LXmlattr mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setLid(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setLb(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setSlb(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setN(codedInputStreamMicro.readString());
                            continue;
                        case 40:
                            setLoop(codedInputStreamMicro.readBool());
                            continue;
                        case 49:
                            setLbx(codedInputStreamMicro.readDouble());
                            continue;
                        case 57:
                            setLby(codedInputStreamMicro.readDouble());
                            continue;
                        case 65:
                            setLbr(codedInputStreamMicro.readDouble());
                            continue;
                        case 74:
                            setLc(codedInputStreamMicro.readString());
                            continue;
                        case 82:
                            setUid(codedInputStreamMicro.readString());
                            continue;
                        case 90:
                            setUid2(codedInputStreamMicro.readString());
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

            public LXmlattr setLb(String str) {
                this.f14673c = true;
                this.f14674d = str;
                return this;
            }

            public LXmlattr setLbr(double d) {
                this.f14685o = true;
                this.f14686p = d;
                return this;
            }

            public LXmlattr setLbx(double d) {
                this.f14681k = true;
                this.f14682l = d;
                return this;
            }

            public LXmlattr setLby(double d) {
                this.f14683m = true;
                this.f14684n = d;
                return this;
            }

            public LXmlattr setLc(String str) {
                this.f14687q = true;
                this.f14688r = str;
                return this;
            }

            public LXmlattr setLid(String str) {
                this.f14671a = true;
                this.f14672b = str;
                return this;
            }

            public LXmlattr setLoop(boolean z) {
                this.f14679i = true;
                this.f14680j = z;
                return this;
            }

            public LXmlattr setN(String str) {
                this.f14677g = true;
                this.f14678h = str;
                return this;
            }

            public LXmlattr setSlb(String str) {
                this.f14675e = true;
                this.f14676f = str;
                return this;
            }

            public LXmlattr setUid(String str) {
                this.f14689s = true;
                this.f14690t = str;
                return this;
            }

            public LXmlattr setUid2(String str) {
                this.f14691u = true;
                this.f14692v = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasLid()) {
                    codedOutputStreamMicro.writeString(1, getLid());
                }
                if (hasLb()) {
                    codedOutputStreamMicro.writeString(2, getLb());
                }
                if (hasSlb()) {
                    codedOutputStreamMicro.writeString(3, getSlb());
                }
                if (hasN()) {
                    codedOutputStreamMicro.writeString(4, getN());
                }
                if (hasLoop()) {
                    codedOutputStreamMicro.writeBool(5, getLoop());
                }
                if (hasLbx()) {
                    codedOutputStreamMicro.writeDouble(6, getLbx());
                }
                if (hasLby()) {
                    codedOutputStreamMicro.writeDouble(7, getLby());
                }
                if (hasLbr()) {
                    codedOutputStreamMicro.writeDouble(8, getLbr());
                }
                if (hasLc()) {
                    codedOutputStreamMicro.writeString(9, getLc());
                }
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(10, getUid());
                }
                if (hasUid2()) {
                    codedOutputStreamMicro.writeString(11, getUid2());
                }
            }
        }

        /* renamed from: com.baidu.entity.pb.Subways$L$P */
        public static final class C3150P extends MessageMicro {
            public static final int P_XMLATTR_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f14725a;
            /* renamed from: b */
            private PXmlattr f14726b = null;
            /* renamed from: c */
            private int f14727c = -1;

            /* renamed from: com.baidu.entity.pb.Subways$L$P$PXmlattr */
            public static final class PXmlattr extends MessageMicro {
                public static final int BOLD_FIELD_NUMBER = 15;
                public static final int EX_FIELD_NUMBER = 8;
                public static final int IU_FIELD_NUMBER = 9;
                public static final int LB_FIELD_NUMBER = 2;
                public static final int PX_FIELD_NUMBER = 12;
                public static final int PY_FIELD_NUMBER = 13;
                public static final int RC_FIELD_NUMBER = 10;
                public static final int RX_FIELD_NUMBER = 5;
                public static final int RY_FIELD_NUMBER = 6;
                public static final int SID_FIELD_NUMBER = 1;
                public static final int SLB_FIELD_NUMBER = 11;
                public static final int ST_FIELD_NUMBER = 7;
                public static final int UID_FIELD_NUMBER = 14;
                public static final int X_FIELD_NUMBER = 3;
                public static final int Y_FIELD_NUMBER = 4;
                /* renamed from: A */
                private boolean f14694A;
                /* renamed from: B */
                private String f14695B = "";
                /* renamed from: C */
                private boolean f14696C;
                /* renamed from: D */
                private boolean f14697D = false;
                /* renamed from: E */
                private int f14698E = -1;
                /* renamed from: a */
                private boolean f14699a;
                /* renamed from: b */
                private String f14700b = "";
                /* renamed from: c */
                private boolean f14701c;
                /* renamed from: d */
                private String f14702d = "";
                /* renamed from: e */
                private boolean f14703e;
                /* renamed from: f */
                private double f14704f = 0.0d;
                /* renamed from: g */
                private boolean f14705g;
                /* renamed from: h */
                private double f14706h = 0.0d;
                /* renamed from: i */
                private boolean f14707i;
                /* renamed from: j */
                private double f14708j = 0.0d;
                /* renamed from: k */
                private boolean f14709k;
                /* renamed from: l */
                private double f14710l = 0.0d;
                /* renamed from: m */
                private boolean f14711m;
                /* renamed from: n */
                private boolean f14712n = false;
                /* renamed from: o */
                private boolean f14713o;
                /* renamed from: p */
                private boolean f14714p = false;
                /* renamed from: q */
                private boolean f14715q;
                /* renamed from: r */
                private boolean f14716r = false;
                /* renamed from: s */
                private boolean f14717s;
                /* renamed from: t */
                private boolean f14718t = false;
                /* renamed from: u */
                private boolean f14719u;
                /* renamed from: v */
                private boolean f14720v = false;
                /* renamed from: w */
                private boolean f14721w;
                /* renamed from: x */
                private double f14722x = 0.0d;
                /* renamed from: y */
                private boolean f14723y;
                /* renamed from: z */
                private double f14724z = 0.0d;

                public static PXmlattr parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new PXmlattr().mergeFrom(codedInputStreamMicro);
                }

                public static PXmlattr parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (PXmlattr) new PXmlattr().mergeFrom(bArr);
                }

                public final PXmlattr clear() {
                    clearSid();
                    clearLb();
                    clearX();
                    clearY();
                    clearRx();
                    clearRy();
                    clearSt();
                    clearEx();
                    clearIu();
                    clearRc();
                    clearSlb();
                    clearPx();
                    clearPy();
                    clearUid();
                    clearBold();
                    this.f14698E = -1;
                    return this;
                }

                public PXmlattr clearBold() {
                    this.f14696C = false;
                    this.f14697D = false;
                    return this;
                }

                public PXmlattr clearEx() {
                    this.f14713o = false;
                    this.f14714p = false;
                    return this;
                }

                public PXmlattr clearIu() {
                    this.f14715q = false;
                    this.f14716r = false;
                    return this;
                }

                public PXmlattr clearLb() {
                    this.f14701c = false;
                    this.f14702d = "";
                    return this;
                }

                public PXmlattr clearPx() {
                    this.f14721w = false;
                    this.f14722x = 0.0d;
                    return this;
                }

                public PXmlattr clearPy() {
                    this.f14723y = false;
                    this.f14724z = 0.0d;
                    return this;
                }

                public PXmlattr clearRc() {
                    this.f14717s = false;
                    this.f14718t = false;
                    return this;
                }

                public PXmlattr clearRx() {
                    this.f14707i = false;
                    this.f14708j = 0.0d;
                    return this;
                }

                public PXmlattr clearRy() {
                    this.f14709k = false;
                    this.f14710l = 0.0d;
                    return this;
                }

                public PXmlattr clearSid() {
                    this.f14699a = false;
                    this.f14700b = "";
                    return this;
                }

                public PXmlattr clearSlb() {
                    this.f14719u = false;
                    this.f14720v = false;
                    return this;
                }

                public PXmlattr clearSt() {
                    this.f14711m = false;
                    this.f14712n = false;
                    return this;
                }

                public PXmlattr clearUid() {
                    this.f14694A = false;
                    this.f14695B = "";
                    return this;
                }

                public PXmlattr clearX() {
                    this.f14703e = false;
                    this.f14704f = 0.0d;
                    return this;
                }

                public PXmlattr clearY() {
                    this.f14705g = false;
                    this.f14706h = 0.0d;
                    return this;
                }

                public boolean getBold() {
                    return this.f14697D;
                }

                public int getCachedSize() {
                    if (this.f14698E < 0) {
                        getSerializedSize();
                    }
                    return this.f14698E;
                }

                public boolean getEx() {
                    return this.f14714p;
                }

                public boolean getIu() {
                    return this.f14716r;
                }

                public String getLb() {
                    return this.f14702d;
                }

                public double getPx() {
                    return this.f14722x;
                }

                public double getPy() {
                    return this.f14724z;
                }

                public boolean getRc() {
                    return this.f14718t;
                }

                public double getRx() {
                    return this.f14708j;
                }

                public double getRy() {
                    return this.f14710l;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasSid()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getSid());
                    }
                    if (hasLb()) {
                        i += CodedOutputStreamMicro.computeStringSize(2, getLb());
                    }
                    if (hasX()) {
                        i += CodedOutputStreamMicro.computeDoubleSize(3, getX());
                    }
                    if (hasY()) {
                        i += CodedOutputStreamMicro.computeDoubleSize(4, getY());
                    }
                    if (hasRx()) {
                        i += CodedOutputStreamMicro.computeDoubleSize(5, getRx());
                    }
                    if (hasRy()) {
                        i += CodedOutputStreamMicro.computeDoubleSize(6, getRy());
                    }
                    if (hasSt()) {
                        i += CodedOutputStreamMicro.computeBoolSize(7, getSt());
                    }
                    if (hasEx()) {
                        i += CodedOutputStreamMicro.computeBoolSize(8, getEx());
                    }
                    if (hasIu()) {
                        i += CodedOutputStreamMicro.computeBoolSize(9, getIu());
                    }
                    if (hasRc()) {
                        i += CodedOutputStreamMicro.computeBoolSize(10, getRc());
                    }
                    if (hasSlb()) {
                        i += CodedOutputStreamMicro.computeBoolSize(11, getSlb());
                    }
                    if (hasPx()) {
                        i += CodedOutputStreamMicro.computeDoubleSize(12, getPx());
                    }
                    if (hasPy()) {
                        i += CodedOutputStreamMicro.computeDoubleSize(13, getPy());
                    }
                    if (hasUid()) {
                        i += CodedOutputStreamMicro.computeStringSize(14, getUid());
                    }
                    if (hasBold()) {
                        i += CodedOutputStreamMicro.computeBoolSize(15, getBold());
                    }
                    this.f14698E = i;
                    return i;
                }

                public String getSid() {
                    return this.f14700b;
                }

                public boolean getSlb() {
                    return this.f14720v;
                }

                public boolean getSt() {
                    return this.f14712n;
                }

                public String getUid() {
                    return this.f14695B;
                }

                public double getX() {
                    return this.f14704f;
                }

                public double getY() {
                    return this.f14706h;
                }

                public boolean hasBold() {
                    return this.f14696C;
                }

                public boolean hasEx() {
                    return this.f14713o;
                }

                public boolean hasIu() {
                    return this.f14715q;
                }

                public boolean hasLb() {
                    return this.f14701c;
                }

                public boolean hasPx() {
                    return this.f14721w;
                }

                public boolean hasPy() {
                    return this.f14723y;
                }

                public boolean hasRc() {
                    return this.f14717s;
                }

                public boolean hasRx() {
                    return this.f14707i;
                }

                public boolean hasRy() {
                    return this.f14709k;
                }

                public boolean hasSid() {
                    return this.f14699a;
                }

                public boolean hasSlb() {
                    return this.f14719u;
                }

                public boolean hasSt() {
                    return this.f14711m;
                }

                public boolean hasUid() {
                    return this.f14694A;
                }

                public boolean hasX() {
                    return this.f14703e;
                }

                public boolean hasY() {
                    return this.f14705g;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public PXmlattr mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                setSid(codedInputStreamMicro.readString());
                                continue;
                            case 18:
                                setLb(codedInputStreamMicro.readString());
                                continue;
                            case 25:
                                setX(codedInputStreamMicro.readDouble());
                                continue;
                            case 33:
                                setY(codedInputStreamMicro.readDouble());
                                continue;
                            case 41:
                                setRx(codedInputStreamMicro.readDouble());
                                continue;
                            case 49:
                                setRy(codedInputStreamMicro.readDouble());
                                continue;
                            case 56:
                                setSt(codedInputStreamMicro.readBool());
                                continue;
                            case 64:
                                setEx(codedInputStreamMicro.readBool());
                                continue;
                            case NavCarInfo.CarType_57L /*72*/:
                                setIu(codedInputStreamMicro.readBool());
                                continue;
                            case 80:
                                setRc(codedInputStreamMicro.readBool());
                                continue;
                            case 88:
                                setSlb(codedInputStreamMicro.readBool());
                                continue;
                            case 97:
                                setPx(codedInputStreamMicro.readDouble());
                                continue;
                            case 105:
                                setPy(codedInputStreamMicro.readDouble());
                                continue;
                            case 114:
                                setUid(codedInputStreamMicro.readString());
                                continue;
                            case 120:
                                setBold(codedInputStreamMicro.readBool());
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

                public PXmlattr setBold(boolean z) {
                    this.f14696C = true;
                    this.f14697D = z;
                    return this;
                }

                public PXmlattr setEx(boolean z) {
                    this.f14713o = true;
                    this.f14714p = z;
                    return this;
                }

                public PXmlattr setIu(boolean z) {
                    this.f14715q = true;
                    this.f14716r = z;
                    return this;
                }

                public PXmlattr setLb(String str) {
                    this.f14701c = true;
                    this.f14702d = str;
                    return this;
                }

                public PXmlattr setPx(double d) {
                    this.f14721w = true;
                    this.f14722x = d;
                    return this;
                }

                public PXmlattr setPy(double d) {
                    this.f14723y = true;
                    this.f14724z = d;
                    return this;
                }

                public PXmlattr setRc(boolean z) {
                    this.f14717s = true;
                    this.f14718t = z;
                    return this;
                }

                public PXmlattr setRx(double d) {
                    this.f14707i = true;
                    this.f14708j = d;
                    return this;
                }

                public PXmlattr setRy(double d) {
                    this.f14709k = true;
                    this.f14710l = d;
                    return this;
                }

                public PXmlattr setSid(String str) {
                    this.f14699a = true;
                    this.f14700b = str;
                    return this;
                }

                public PXmlattr setSlb(boolean z) {
                    this.f14719u = true;
                    this.f14720v = z;
                    return this;
                }

                public PXmlattr setSt(boolean z) {
                    this.f14711m = true;
                    this.f14712n = z;
                    return this;
                }

                public PXmlattr setUid(String str) {
                    this.f14694A = true;
                    this.f14695B = str;
                    return this;
                }

                public PXmlattr setX(double d) {
                    this.f14703e = true;
                    this.f14704f = d;
                    return this;
                }

                public PXmlattr setY(double d) {
                    this.f14705g = true;
                    this.f14706h = d;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasSid()) {
                        codedOutputStreamMicro.writeString(1, getSid());
                    }
                    if (hasLb()) {
                        codedOutputStreamMicro.writeString(2, getLb());
                    }
                    if (hasX()) {
                        codedOutputStreamMicro.writeDouble(3, getX());
                    }
                    if (hasY()) {
                        codedOutputStreamMicro.writeDouble(4, getY());
                    }
                    if (hasRx()) {
                        codedOutputStreamMicro.writeDouble(5, getRx());
                    }
                    if (hasRy()) {
                        codedOutputStreamMicro.writeDouble(6, getRy());
                    }
                    if (hasSt()) {
                        codedOutputStreamMicro.writeBool(7, getSt());
                    }
                    if (hasEx()) {
                        codedOutputStreamMicro.writeBool(8, getEx());
                    }
                    if (hasIu()) {
                        codedOutputStreamMicro.writeBool(9, getIu());
                    }
                    if (hasRc()) {
                        codedOutputStreamMicro.writeBool(10, getRc());
                    }
                    if (hasSlb()) {
                        codedOutputStreamMicro.writeBool(11, getSlb());
                    }
                    if (hasPx()) {
                        codedOutputStreamMicro.writeDouble(12, getPx());
                    }
                    if (hasPy()) {
                        codedOutputStreamMicro.writeDouble(13, getPy());
                    }
                    if (hasUid()) {
                        codedOutputStreamMicro.writeString(14, getUid());
                    }
                    if (hasBold()) {
                        codedOutputStreamMicro.writeBool(15, getBold());
                    }
                }
            }

            public static C3150P parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new C3150P().mergeFrom(codedInputStreamMicro);
            }

            public static C3150P parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (C3150P) new C3150P().mergeFrom(bArr);
            }

            public final C3150P clear() {
                clearPXmlattr();
                this.f14727c = -1;
                return this;
            }

            public C3150P clearPXmlattr() {
                this.f14725a = false;
                this.f14726b = null;
                return this;
            }

            public int getCachedSize() {
                if (this.f14727c < 0) {
                    getSerializedSize();
                }
                return this.f14727c;
            }

            public PXmlattr getPXmlattr() {
                return this.f14726b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasPXmlattr()) {
                    i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getPXmlattr());
                }
                this.f14727c = i;
                return i;
            }

            public boolean hasPXmlattr() {
                return this.f14725a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public C3150P mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            MessageMicro pXmlattr = new PXmlattr();
                            codedInputStreamMicro.readMessage(pXmlattr);
                            setPXmlattr(pXmlattr);
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

            public C3150P setPXmlattr(PXmlattr pXmlattr) {
                if (pXmlattr == null) {
                    return clearPXmlattr();
                }
                this.f14725a = true;
                this.f14726b = pXmlattr;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasPXmlattr()) {
                    codedOutputStreamMicro.writeMessage(1, getPXmlattr());
                }
            }
        }

        public static C3151L parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new C3151L().mergeFrom(codedInputStreamMicro);
        }

        public static C3151L parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (C3151L) new C3151L().mergeFrom(bArr);
        }

        public C3151L addP(C3150P c3150p) {
            if (c3150p != null) {
                if (this.f14730c.isEmpty()) {
                    this.f14730c = new ArrayList();
                }
                this.f14730c.add(c3150p);
            }
            return this;
        }

        public final C3151L clear() {
            clearLXmlattr();
            clearP();
            this.f14731d = -1;
            return this;
        }

        public C3151L clearLXmlattr() {
            this.f14728a = false;
            this.f14729b = null;
            return this;
        }

        public C3151L clearP() {
            this.f14730c = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f14731d < 0) {
                getSerializedSize();
            }
            return this.f14731d;
        }

        public LXmlattr getLXmlattr() {
            return this.f14729b;
        }

        public C3150P getP(int i) {
            return (C3150P) this.f14730c.get(i);
        }

        public int getPCount() {
            return this.f14730c.size();
        }

        public List<C3150P> getPList() {
            return this.f14730c;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasLXmlattr()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getLXmlattr());
            }
            int i2 = i;
            for (C3150P computeMessageSize : getPList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            this.f14731d = i2;
            return i2;
        }

        public boolean hasLXmlattr() {
            return this.f14728a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public C3151L mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro lXmlattr;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        lXmlattr = new LXmlattr();
                        codedInputStreamMicro.readMessage(lXmlattr);
                        setLXmlattr(lXmlattr);
                        continue;
                    case 18:
                        lXmlattr = new C3150P();
                        codedInputStreamMicro.readMessage(lXmlattr);
                        addP(lXmlattr);
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

        public C3151L setLXmlattr(LXmlattr lXmlattr) {
            if (lXmlattr == null) {
                return clearLXmlattr();
            }
            this.f14728a = true;
            this.f14729b = lXmlattr;
            return this;
        }

        public C3151L setP(int i, C3150P c3150p) {
            if (c3150p != null) {
                this.f14730c.set(i, c3150p);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasLXmlattr()) {
                codedOutputStreamMicro.writeMessage(1, getLXmlattr());
            }
            for (C3150P writeMessage : getPList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
        }
    }

    public static final class SwXmlattr extends MessageMicro {
        public static final int BG_FIELD_NUMBER = 5;
        public static final int CID_FIELD_NUMBER = 1;
        public static final int C_FIELD_NUMBER = 3;
        public static final int HEIGHT_FIELD_NUMBER = 8;
        public static final int ICON_FIELD_NUMBER = 6;
        public static final int N_FIELD_NUMBER = 2;
        public static final int SRC_FIELD_NUMBER = 4;
        public static final int VERSION_FIELD_NUMBER = 9;
        public static final int WIDTH_FIELD_NUMBER = 7;
        /* renamed from: a */
        private boolean f14732a;
        /* renamed from: b */
        private String f14733b = "";
        /* renamed from: c */
        private boolean f14734c;
        /* renamed from: d */
        private int f14735d = 0;
        /* renamed from: e */
        private boolean f14736e;
        /* renamed from: f */
        private String f14737f = "";
        /* renamed from: g */
        private boolean f14738g;
        /* renamed from: h */
        private String f14739h = "";
        /* renamed from: i */
        private boolean f14740i;
        /* renamed from: j */
        private String f14741j = "";
        /* renamed from: k */
        private boolean f14742k;
        /* renamed from: l */
        private String f14743l = "";
        /* renamed from: m */
        private boolean f14744m;
        /* renamed from: n */
        private String f14745n = "";
        /* renamed from: o */
        private boolean f14746o;
        /* renamed from: p */
        private String f14747p = "";
        /* renamed from: q */
        private boolean f14748q;
        /* renamed from: r */
        private String f14749r = "";
        /* renamed from: s */
        private int f14750s = -1;

        public static SwXmlattr parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new SwXmlattr().mergeFrom(codedInputStreamMicro);
        }

        public static SwXmlattr parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (SwXmlattr) new SwXmlattr().mergeFrom(bArr);
        }

        public final SwXmlattr clear() {
            clearCid();
            clearN();
            clearC();
            clearSrc();
            clearBg();
            clearIcon();
            clearWidth();
            clearHeight();
            clearVersion();
            this.f14750s = -1;
            return this;
        }

        public SwXmlattr clearBg() {
            this.f14740i = false;
            this.f14741j = "";
            return this;
        }

        public SwXmlattr clearC() {
            this.f14736e = false;
            this.f14737f = "";
            return this;
        }

        public SwXmlattr clearCid() {
            this.f14732a = false;
            this.f14733b = "";
            return this;
        }

        public SwXmlattr clearHeight() {
            this.f14746o = false;
            this.f14747p = "";
            return this;
        }

        public SwXmlattr clearIcon() {
            this.f14742k = false;
            this.f14743l = "";
            return this;
        }

        public SwXmlattr clearN() {
            this.f14734c = false;
            this.f14735d = 0;
            return this;
        }

        public SwXmlattr clearSrc() {
            this.f14738g = false;
            this.f14739h = "";
            return this;
        }

        public SwXmlattr clearVersion() {
            this.f14748q = false;
            this.f14749r = "";
            return this;
        }

        public SwXmlattr clearWidth() {
            this.f14744m = false;
            this.f14745n = "";
            return this;
        }

        public String getBg() {
            return this.f14741j;
        }

        public String getC() {
            return this.f14737f;
        }

        public int getCachedSize() {
            if (this.f14750s < 0) {
                getSerializedSize();
            }
            return this.f14750s;
        }

        public String getCid() {
            return this.f14733b;
        }

        public String getHeight() {
            return this.f14747p;
        }

        public String getIcon() {
            return this.f14743l;
        }

        public int getN() {
            return this.f14735d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasCid()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCid());
            }
            if (hasN()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getN());
            }
            if (hasC()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getC());
            }
            if (hasSrc()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getSrc());
            }
            if (hasBg()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getBg());
            }
            if (hasIcon()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getIcon());
            }
            if (hasWidth()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getWidth());
            }
            if (hasHeight()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getHeight());
            }
            if (hasVersion()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getVersion());
            }
            this.f14750s = i;
            return i;
        }

        public String getSrc() {
            return this.f14739h;
        }

        public String getVersion() {
            return this.f14749r;
        }

        public String getWidth() {
            return this.f14745n;
        }

        public boolean hasBg() {
            return this.f14740i;
        }

        public boolean hasC() {
            return this.f14736e;
        }

        public boolean hasCid() {
            return this.f14732a;
        }

        public boolean hasHeight() {
            return this.f14746o;
        }

        public boolean hasIcon() {
            return this.f14742k;
        }

        public boolean hasN() {
            return this.f14734c;
        }

        public boolean hasSrc() {
            return this.f14738g;
        }

        public boolean hasVersion() {
            return this.f14748q;
        }

        public boolean hasWidth() {
            return this.f14744m;
        }

        public final boolean isInitialized() {
            return true;
        }

        public SwXmlattr mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setCid(codedInputStreamMicro.readString());
                        continue;
                    case 16:
                        setN(codedInputStreamMicro.readInt32());
                        continue;
                    case 26:
                        setC(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setSrc(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setBg(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setIcon(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setWidth(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setHeight(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setVersion(codedInputStreamMicro.readString());
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

        public SwXmlattr setBg(String str) {
            this.f14740i = true;
            this.f14741j = str;
            return this;
        }

        public SwXmlattr setC(String str) {
            this.f14736e = true;
            this.f14737f = str;
            return this;
        }

        public SwXmlattr setCid(String str) {
            this.f14732a = true;
            this.f14733b = str;
            return this;
        }

        public SwXmlattr setHeight(String str) {
            this.f14746o = true;
            this.f14747p = str;
            return this;
        }

        public SwXmlattr setIcon(String str) {
            this.f14742k = true;
            this.f14743l = str;
            return this;
        }

        public SwXmlattr setN(int i) {
            this.f14734c = true;
            this.f14735d = i;
            return this;
        }

        public SwXmlattr setSrc(String str) {
            this.f14738g = true;
            this.f14739h = str;
            return this;
        }

        public SwXmlattr setVersion(String str) {
            this.f14748q = true;
            this.f14749r = str;
            return this;
        }

        public SwXmlattr setWidth(String str) {
            this.f14744m = true;
            this.f14745n = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasCid()) {
                codedOutputStreamMicro.writeString(1, getCid());
            }
            if (hasN()) {
                codedOutputStreamMicro.writeInt32(2, getN());
            }
            if (hasC()) {
                codedOutputStreamMicro.writeString(3, getC());
            }
            if (hasSrc()) {
                codedOutputStreamMicro.writeString(4, getSrc());
            }
            if (hasBg()) {
                codedOutputStreamMicro.writeString(5, getBg());
            }
            if (hasIcon()) {
                codedOutputStreamMicro.writeString(6, getIcon());
            }
            if (hasWidth()) {
                codedOutputStreamMicro.writeString(7, getWidth());
            }
            if (hasHeight()) {
                codedOutputStreamMicro.writeString(8, getHeight());
            }
            if (hasVersion()) {
                codedOutputStreamMicro.writeString(9, getVersion());
            }
        }
    }

    public static Subways parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Subways().mergeFrom(codedInputStreamMicro);
    }

    public static Subways parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Subways) new Subways().mergeFrom(bArr);
    }

    public Subways addL(C3151L c3151l) {
        if (c3151l != null) {
            if (this.f14753c.isEmpty()) {
                this.f14753c = new ArrayList();
            }
            this.f14753c.add(c3151l);
        }
        return this;
    }

    public final Subways clear() {
        clearSwXmlattr();
        clearL();
        this.f14754d = -1;
        return this;
    }

    public Subways clearL() {
        this.f14753c = Collections.emptyList();
        return this;
    }

    public Subways clearSwXmlattr() {
        this.f14751a = false;
        this.f14752b = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f14754d < 0) {
            getSerializedSize();
        }
        return this.f14754d;
    }

    public C3151L getL(int i) {
        return (C3151L) this.f14753c.get(i);
    }

    public int getLCount() {
        return this.f14753c.size();
    }

    public List<C3151L> getLList() {
        return this.f14753c;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasSwXmlattr()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getSwXmlattr());
        }
        int i2 = i;
        for (C3151L computeMessageSize : getLList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
        }
        this.f14754d = i2;
        return i2;
    }

    public SwXmlattr getSwXmlattr() {
        return this.f14752b;
    }

    public boolean hasSwXmlattr() {
        return this.f14751a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Subways mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro swXmlattr;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    swXmlattr = new SwXmlattr();
                    codedInputStreamMicro.readMessage(swXmlattr);
                    setSwXmlattr(swXmlattr);
                    continue;
                case 18:
                    swXmlattr = new C3151L();
                    codedInputStreamMicro.readMessage(swXmlattr);
                    addL(swXmlattr);
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

    public Subways setL(int i, C3151L c3151l) {
        if (c3151l != null) {
            this.f14753c.set(i, c3151l);
        }
        return this;
    }

    public Subways setSwXmlattr(SwXmlattr swXmlattr) {
        if (swXmlattr == null) {
            return clearSwXmlattr();
        }
        this.f14751a = true;
        this.f14752b = swXmlattr;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasSwXmlattr()) {
            codedOutputStreamMicro.writeMessage(1, getSwXmlattr());
        }
        for (C3151L writeMessage : getLList()) {
            codedOutputStreamMicro.writeMessage(2, writeMessage);
        }
    }
}
