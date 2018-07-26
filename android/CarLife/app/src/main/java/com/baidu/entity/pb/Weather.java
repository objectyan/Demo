package com.baidu.entity.pb;

import com.baidu.carlife.core.C1253f;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver;
import com.baidu.platform.comapi.map.provider.BusRouteProvider;
import com.baidu.platform.comapi.map.provider.RouteLineResConst;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class Weather extends MessageMicro {
    public static final int CONTENTS_FIELD_NUMBER = 2;
    public static final int OPTION_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f17163a;
    /* renamed from: b */
    private Option f17164b = null;
    /* renamed from: c */
    private boolean f17165c;
    /* renamed from: d */
    private Contents f17166d = null;
    /* renamed from: e */
    private int f17167e = -1;

    public static final class Contents extends MessageMicro {
        public static final int CNAME_FIELD_NUMBER = 1;
        public static final int PIC01_FIELD_NUMBER = 11;
        public static final int PIC02_FIELD_NUMBER = 12;
        public static final int PIC0T_FIELD_NUMBER = 7;
        public static final int PIC0_FIELD_NUMBER = 6;
        public static final int PIC11_FIELD_NUMBER = 19;
        public static final int PIC12_FIELD_NUMBER = 20;
        public static final int PIC1_FIELD_NUMBER = 18;
        public static final int PIC21_FIELD_NUMBER = 27;
        public static final int PIC22_FIELD_NUMBER = 28;
        public static final int PIC2_FIELD_NUMBER = 26;
        public static final int PIC31_FIELD_NUMBER = 35;
        public static final int PIC32_FIELD_NUMBER = 36;
        public static final int PIC3_FIELD_NUMBER = 34;
        public static final int PIC41_FIELD_NUMBER = 43;
        public static final int PIC42_FIELD_NUMBER = 44;
        public static final int PIC4_FIELD_NUMBER = 42;
        public static final int PICNAME0_FIELD_NUMBER = 8;
        public static final int PICNAME1_FIELD_NUMBER = 17;
        public static final int PICNAME2_FIELD_NUMBER = 25;
        public static final int PICNAME3_FIELD_NUMBER = 33;
        public static final int PICNAME4_FIELD_NUMBER = 41;
        public static final int PM25T_FIELD_NUMBER = 5;
        public static final int PM25_FIELD_NUMBER = 4;
        public static final int TEMP0_FIELD_NUMBER = 3;
        public static final int TEMP1_FIELD_NUMBER = 15;
        public static final int TEMP2_FIELD_NUMBER = 23;
        public static final int TEMP3_FIELD_NUMBER = 31;
        public static final int TEMP4_FIELD_NUMBER = 39;
        public static final int TIME0_FIELD_NUMBER = 9;
        public static final int TIME1_FIELD_NUMBER = 13;
        public static final int TIME2_FIELD_NUMBER = 21;
        public static final int TIME3_FIELD_NUMBER = 29;
        public static final int TIME4_FIELD_NUMBER = 37;
        public static final int WEATHER0_FIELD_NUMBER = 2;
        public static final int WEATHER1_FIELD_NUMBER = 14;
        public static final int WEATHER2_FIELD_NUMBER = 22;
        public static final int WEATHER3_FIELD_NUMBER = 30;
        public static final int WEATHER4_FIELD_NUMBER = 38;
        public static final int WIND0_FIELD_NUMBER = 10;
        public static final int WIND1_FIELD_NUMBER = 16;
        public static final int WIND2_FIELD_NUMBER = 24;
        public static final int WIND3_FIELD_NUMBER = 32;
        public static final int WIND4_FIELD_NUMBER = 40;
        /* renamed from: A */
        private boolean f17106A;
        /* renamed from: B */
        private String f17107B = "";
        /* renamed from: C */
        private boolean f17108C;
        /* renamed from: D */
        private String f17109D = "";
        /* renamed from: E */
        private boolean f17110E;
        /* renamed from: F */
        private String f17111F = "";
        /* renamed from: G */
        private boolean f17112G;
        /* renamed from: H */
        private String f17113H = "";
        /* renamed from: I */
        private boolean f17114I;
        /* renamed from: J */
        private String f17115J = "";
        /* renamed from: K */
        private boolean f17116K;
        /* renamed from: L */
        private String f17117L = "";
        /* renamed from: M */
        private boolean f17118M;
        /* renamed from: N */
        private String f17119N = "";
        /* renamed from: O */
        private boolean f17120O;
        /* renamed from: P */
        private String f17121P = "";
        /* renamed from: Q */
        private boolean f17122Q;
        /* renamed from: R */
        private String f17123R = "";
        /* renamed from: S */
        private boolean f17124S;
        /* renamed from: T */
        private String f17125T = "";
        /* renamed from: U */
        private boolean f17126U;
        /* renamed from: V */
        private String f17127V = "";
        /* renamed from: W */
        private boolean f17128W;
        /* renamed from: X */
        private String f17129X = "";
        /* renamed from: Y */
        private boolean f17130Y;
        /* renamed from: Z */
        private String f17131Z = "";
        /* renamed from: a */
        private boolean f17132a;
        private boolean aA;
        private String aB = "";
        private boolean aC;
        private String aD = "";
        private boolean aE;
        private String aF = "";
        private boolean aG;
        private String aH = "";
        private boolean aI;
        private String aJ = "";
        private int aK = -1;
        private boolean aa;
        private String ab = "";
        private boolean ac;
        private String ad = "";
        private boolean ae;
        private String af = "";
        private boolean ag;
        private String ah = "";
        private boolean ai;
        private String aj = "";
        private boolean ak;
        private String al = "";
        private boolean am;
        private String an = "";
        private boolean ao;
        private String ap = "";
        private boolean aq;
        private String ar = "";
        private boolean as;
        private String at = "";
        private boolean au;
        private String av = "";
        private boolean aw;
        private String ax = "";
        private boolean ay;
        private String az = "";
        /* renamed from: b */
        private String f17133b = "";
        /* renamed from: c */
        private boolean f17134c;
        /* renamed from: d */
        private String f17135d = "";
        /* renamed from: e */
        private boolean f17136e;
        /* renamed from: f */
        private String f17137f = "";
        /* renamed from: g */
        private boolean f17138g;
        /* renamed from: h */
        private int f17139h = 0;
        /* renamed from: i */
        private boolean f17140i;
        /* renamed from: j */
        private String f17141j = "";
        /* renamed from: k */
        private boolean f17142k;
        /* renamed from: l */
        private String f17143l = "";
        /* renamed from: m */
        private boolean f17144m;
        /* renamed from: n */
        private int f17145n = 0;
        /* renamed from: o */
        private boolean f17146o;
        /* renamed from: p */
        private String f17147p = "";
        /* renamed from: q */
        private boolean f17148q;
        /* renamed from: r */
        private String f17149r = "";
        /* renamed from: s */
        private boolean f17150s;
        /* renamed from: t */
        private String f17151t = "";
        /* renamed from: u */
        private boolean f17152u;
        /* renamed from: v */
        private String f17153v = "";
        /* renamed from: w */
        private boolean f17154w;
        /* renamed from: x */
        private String f17155x = "";
        /* renamed from: y */
        private boolean f17156y;
        /* renamed from: z */
        private String f17157z = "";

        public static Contents parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Contents().mergeFrom(codedInputStreamMicro);
        }

        public static Contents parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Contents) new Contents().mergeFrom(bArr);
        }

        public final Contents clear() {
            clearCname();
            clearWeather0();
            clearTemp0();
            clearPm25();
            clearPm25T();
            clearPic0();
            clearPic0T();
            clearPicName0();
            clearTime0();
            clearWind0();
            clearPic01();
            clearPic02();
            clearTime1();
            clearWeather1();
            clearTemp1();
            clearWind1();
            clearPicName1();
            clearPic1();
            clearPic11();
            clearPic12();
            clearTime2();
            clearWeather2();
            clearTemp2();
            clearWind2();
            clearPicName2();
            clearPic2();
            clearPic21();
            clearPic22();
            clearTime3();
            clearWeather3();
            clearTemp3();
            clearWind3();
            clearPicName3();
            clearPic3();
            clearPic31();
            clearPic32();
            clearTime4();
            clearWeather4();
            clearTemp4();
            clearWind4();
            clearPicName4();
            clearPic4();
            clearPic41();
            clearPic42();
            this.aK = -1;
            return this;
        }

        public Contents clearCname() {
            this.f17132a = false;
            this.f17133b = "";
            return this;
        }

        public Contents clearPic0() {
            this.f17142k = false;
            this.f17143l = "";
            return this;
        }

        public Contents clearPic01() {
            this.f17152u = false;
            this.f17153v = "";
            return this;
        }

        public Contents clearPic02() {
            this.f17154w = false;
            this.f17155x = "";
            return this;
        }

        public Contents clearPic0T() {
            this.f17144m = false;
            this.f17145n = 0;
            return this;
        }

        public Contents clearPic1() {
            this.f17114I = false;
            this.f17115J = "";
            return this;
        }

        public Contents clearPic11() {
            this.f17116K = false;
            this.f17117L = "";
            return this;
        }

        public Contents clearPic12() {
            this.f17118M = false;
            this.f17119N = "";
            return this;
        }

        public Contents clearPic2() {
            this.f17130Y = false;
            this.f17131Z = "";
            return this;
        }

        public Contents clearPic21() {
            this.aa = false;
            this.ab = "";
            return this;
        }

        public Contents clearPic22() {
            this.ac = false;
            this.ad = "";
            return this;
        }

        public Contents clearPic3() {
            this.ao = false;
            this.ap = "";
            return this;
        }

        public Contents clearPic31() {
            this.aq = false;
            this.ar = "";
            return this;
        }

        public Contents clearPic32() {
            this.as = false;
            this.at = "";
            return this;
        }

        public Contents clearPic4() {
            this.aE = false;
            this.aF = "";
            return this;
        }

        public Contents clearPic41() {
            this.aG = false;
            this.aH = "";
            return this;
        }

        public Contents clearPic42() {
            this.aI = false;
            this.aJ = "";
            return this;
        }

        public Contents clearPicName0() {
            this.f17146o = false;
            this.f17147p = "";
            return this;
        }

        public Contents clearPicName1() {
            this.f17112G = false;
            this.f17113H = "";
            return this;
        }

        public Contents clearPicName2() {
            this.f17128W = false;
            this.f17129X = "";
            return this;
        }

        public Contents clearPicName3() {
            this.am = false;
            this.an = "";
            return this;
        }

        public Contents clearPicName4() {
            this.aC = false;
            this.aD = "";
            return this;
        }

        public Contents clearPm25() {
            this.f17138g = false;
            this.f17139h = 0;
            return this;
        }

        public Contents clearPm25T() {
            this.f17140i = false;
            this.f17141j = "";
            return this;
        }

        public Contents clearTemp0() {
            this.f17136e = false;
            this.f17137f = "";
            return this;
        }

        public Contents clearTemp1() {
            this.f17108C = false;
            this.f17109D = "";
            return this;
        }

        public Contents clearTemp2() {
            this.f17124S = false;
            this.f17125T = "";
            return this;
        }

        public Contents clearTemp3() {
            this.ai = false;
            this.aj = "";
            return this;
        }

        public Contents clearTemp4() {
            this.ay = false;
            this.az = "";
            return this;
        }

        public Contents clearTime0() {
            this.f17148q = false;
            this.f17149r = "";
            return this;
        }

        public Contents clearTime1() {
            this.f17156y = false;
            this.f17157z = "";
            return this;
        }

        public Contents clearTime2() {
            this.f17120O = false;
            this.f17121P = "";
            return this;
        }

        public Contents clearTime3() {
            this.ae = false;
            this.af = "";
            return this;
        }

        public Contents clearTime4() {
            this.au = false;
            this.av = "";
            return this;
        }

        public Contents clearWeather0() {
            this.f17134c = false;
            this.f17135d = "";
            return this;
        }

        public Contents clearWeather1() {
            this.f17106A = false;
            this.f17107B = "";
            return this;
        }

        public Contents clearWeather2() {
            this.f17122Q = false;
            this.f17123R = "";
            return this;
        }

        public Contents clearWeather3() {
            this.ag = false;
            this.ah = "";
            return this;
        }

        public Contents clearWeather4() {
            this.aw = false;
            this.ax = "";
            return this;
        }

        public Contents clearWind0() {
            this.f17150s = false;
            this.f17151t = "";
            return this;
        }

        public Contents clearWind1() {
            this.f17110E = false;
            this.f17111F = "";
            return this;
        }

        public Contents clearWind2() {
            this.f17126U = false;
            this.f17127V = "";
            return this;
        }

        public Contents clearWind3() {
            this.ak = false;
            this.al = "";
            return this;
        }

        public Contents clearWind4() {
            this.aA = false;
            this.aB = "";
            return this;
        }

        public int getCachedSize() {
            if (this.aK < 0) {
                getSerializedSize();
            }
            return this.aK;
        }

        public String getCname() {
            return this.f17133b;
        }

        public String getPic0() {
            return this.f17143l;
        }

        public String getPic01() {
            return this.f17153v;
        }

        public String getPic02() {
            return this.f17155x;
        }

        public int getPic0T() {
            return this.f17145n;
        }

        public String getPic1() {
            return this.f17115J;
        }

        public String getPic11() {
            return this.f17117L;
        }

        public String getPic12() {
            return this.f17119N;
        }

        public String getPic2() {
            return this.f17131Z;
        }

        public String getPic21() {
            return this.ab;
        }

        public String getPic22() {
            return this.ad;
        }

        public String getPic3() {
            return this.ap;
        }

        public String getPic31() {
            return this.ar;
        }

        public String getPic32() {
            return this.at;
        }

        public String getPic4() {
            return this.aF;
        }

        public String getPic41() {
            return this.aH;
        }

        public String getPic42() {
            return this.aJ;
        }

        public String getPicName0() {
            return this.f17147p;
        }

        public String getPicName1() {
            return this.f17113H;
        }

        public String getPicName2() {
            return this.f17129X;
        }

        public String getPicName3() {
            return this.an;
        }

        public String getPicName4() {
            return this.aD;
        }

        public int getPm25() {
            return this.f17139h;
        }

        public String getPm25T() {
            return this.f17141j;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasCname()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCname());
            }
            if (hasWeather0()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getWeather0());
            }
            if (hasTemp0()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getTemp0());
            }
            if (hasPm25()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, getPm25());
            }
            if (hasPm25T()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getPm25T());
            }
            if (hasPic0()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getPic0());
            }
            if (hasPic0T()) {
                i += CodedOutputStreamMicro.computeInt32Size(7, getPic0T());
            }
            if (hasPicName0()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getPicName0());
            }
            if (hasTime0()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getTime0());
            }
            if (hasWind0()) {
                i += CodedOutputStreamMicro.computeStringSize(10, getWind0());
            }
            if (hasPic01()) {
                i += CodedOutputStreamMicro.computeStringSize(11, getPic01());
            }
            if (hasPic02()) {
                i += CodedOutputStreamMicro.computeStringSize(12, getPic02());
            }
            if (hasTime1()) {
                i += CodedOutputStreamMicro.computeStringSize(13, getTime1());
            }
            if (hasWeather1()) {
                i += CodedOutputStreamMicro.computeStringSize(14, getWeather1());
            }
            if (hasTemp1()) {
                i += CodedOutputStreamMicro.computeStringSize(15, getTemp1());
            }
            if (hasWind1()) {
                i += CodedOutputStreamMicro.computeStringSize(16, getWind1());
            }
            if (hasPicName1()) {
                i += CodedOutputStreamMicro.computeStringSize(17, getPicName1());
            }
            if (hasPic1()) {
                i += CodedOutputStreamMicro.computeStringSize(18, getPic1());
            }
            if (hasPic11()) {
                i += CodedOutputStreamMicro.computeStringSize(19, getPic11());
            }
            if (hasPic12()) {
                i += CodedOutputStreamMicro.computeStringSize(20, getPic12());
            }
            if (hasTime2()) {
                i += CodedOutputStreamMicro.computeStringSize(21, getTime2());
            }
            if (hasWeather2()) {
                i += CodedOutputStreamMicro.computeStringSize(22, getWeather2());
            }
            if (hasTemp2()) {
                i += CodedOutputStreamMicro.computeStringSize(23, getTemp2());
            }
            if (hasWind2()) {
                i += CodedOutputStreamMicro.computeStringSize(24, getWind2());
            }
            if (hasPicName2()) {
                i += CodedOutputStreamMicro.computeStringSize(25, getPicName2());
            }
            if (hasPic2()) {
                i += CodedOutputStreamMicro.computeStringSize(26, getPic2());
            }
            if (hasPic21()) {
                i += CodedOutputStreamMicro.computeStringSize(27, getPic21());
            }
            if (hasPic22()) {
                i += CodedOutputStreamMicro.computeStringSize(28, getPic22());
            }
            if (hasTime3()) {
                i += CodedOutputStreamMicro.computeStringSize(29, getTime3());
            }
            if (hasWeather3()) {
                i += CodedOutputStreamMicro.computeStringSize(30, getWeather3());
            }
            if (hasTemp3()) {
                i += CodedOutputStreamMicro.computeStringSize(31, getTemp3());
            }
            if (hasWind3()) {
                i += CodedOutputStreamMicro.computeStringSize(32, getWind3());
            }
            if (hasPicName3()) {
                i += CodedOutputStreamMicro.computeStringSize(33, getPicName3());
            }
            if (hasPic3()) {
                i += CodedOutputStreamMicro.computeStringSize(34, getPic3());
            }
            if (hasPic31()) {
                i += CodedOutputStreamMicro.computeStringSize(35, getPic31());
            }
            if (hasPic32()) {
                i += CodedOutputStreamMicro.computeStringSize(36, getPic32());
            }
            if (hasTime4()) {
                i += CodedOutputStreamMicro.computeStringSize(37, getTime4());
            }
            if (hasWeather4()) {
                i += CodedOutputStreamMicro.computeStringSize(38, getWeather4());
            }
            if (hasTemp4()) {
                i += CodedOutputStreamMicro.computeStringSize(39, getTemp4());
            }
            if (hasWind4()) {
                i += CodedOutputStreamMicro.computeStringSize(40, getWind4());
            }
            if (hasPicName4()) {
                i += CodedOutputStreamMicro.computeStringSize(41, getPicName4());
            }
            if (hasPic4()) {
                i += CodedOutputStreamMicro.computeStringSize(42, getPic4());
            }
            if (hasPic41()) {
                i += CodedOutputStreamMicro.computeStringSize(43, getPic41());
            }
            if (hasPic42()) {
                i += CodedOutputStreamMicro.computeStringSize(44, getPic42());
            }
            this.aK = i;
            return i;
        }

        public String getTemp0() {
            return this.f17137f;
        }

        public String getTemp1() {
            return this.f17109D;
        }

        public String getTemp2() {
            return this.f17125T;
        }

        public String getTemp3() {
            return this.aj;
        }

        public String getTemp4() {
            return this.az;
        }

        public String getTime0() {
            return this.f17149r;
        }

        public String getTime1() {
            return this.f17157z;
        }

        public String getTime2() {
            return this.f17121P;
        }

        public String getTime3() {
            return this.af;
        }

        public String getTime4() {
            return this.av;
        }

        public String getWeather0() {
            return this.f17135d;
        }

        public String getWeather1() {
            return this.f17107B;
        }

        public String getWeather2() {
            return this.f17123R;
        }

        public String getWeather3() {
            return this.ah;
        }

        public String getWeather4() {
            return this.ax;
        }

        public String getWind0() {
            return this.f17151t;
        }

        public String getWind1() {
            return this.f17111F;
        }

        public String getWind2() {
            return this.f17127V;
        }

        public String getWind3() {
            return this.al;
        }

        public String getWind4() {
            return this.aB;
        }

        public boolean hasCname() {
            return this.f17132a;
        }

        public boolean hasPic0() {
            return this.f17142k;
        }

        public boolean hasPic01() {
            return this.f17152u;
        }

        public boolean hasPic02() {
            return this.f17154w;
        }

        public boolean hasPic0T() {
            return this.f17144m;
        }

        public boolean hasPic1() {
            return this.f17114I;
        }

        public boolean hasPic11() {
            return this.f17116K;
        }

        public boolean hasPic12() {
            return this.f17118M;
        }

        public boolean hasPic2() {
            return this.f17130Y;
        }

        public boolean hasPic21() {
            return this.aa;
        }

        public boolean hasPic22() {
            return this.ac;
        }

        public boolean hasPic3() {
            return this.ao;
        }

        public boolean hasPic31() {
            return this.aq;
        }

        public boolean hasPic32() {
            return this.as;
        }

        public boolean hasPic4() {
            return this.aE;
        }

        public boolean hasPic41() {
            return this.aG;
        }

        public boolean hasPic42() {
            return this.aI;
        }

        public boolean hasPicName0() {
            return this.f17146o;
        }

        public boolean hasPicName1() {
            return this.f17112G;
        }

        public boolean hasPicName2() {
            return this.f17128W;
        }

        public boolean hasPicName3() {
            return this.am;
        }

        public boolean hasPicName4() {
            return this.aC;
        }

        public boolean hasPm25() {
            return this.f17138g;
        }

        public boolean hasPm25T() {
            return this.f17140i;
        }

        public boolean hasTemp0() {
            return this.f17136e;
        }

        public boolean hasTemp1() {
            return this.f17108C;
        }

        public boolean hasTemp2() {
            return this.f17124S;
        }

        public boolean hasTemp3() {
            return this.ai;
        }

        public boolean hasTemp4() {
            return this.ay;
        }

        public boolean hasTime0() {
            return this.f17148q;
        }

        public boolean hasTime1() {
            return this.f17156y;
        }

        public boolean hasTime2() {
            return this.f17120O;
        }

        public boolean hasTime3() {
            return this.ae;
        }

        public boolean hasTime4() {
            return this.au;
        }

        public boolean hasWeather0() {
            return this.f17134c;
        }

        public boolean hasWeather1() {
            return this.f17106A;
        }

        public boolean hasWeather2() {
            return this.f17122Q;
        }

        public boolean hasWeather3() {
            return this.ag;
        }

        public boolean hasWeather4() {
            return this.aw;
        }

        public boolean hasWind0() {
            return this.f17150s;
        }

        public boolean hasWind1() {
            return this.f17110E;
        }

        public boolean hasWind2() {
            return this.f17126U;
        }

        public boolean hasWind3() {
            return this.ak;
        }

        public boolean hasWind4() {
            return this.aA;
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
                    case 10:
                        setCname(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setWeather0(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setTemp0(codedInputStreamMicro.readString());
                        continue;
                    case 32:
                        setPm25(codedInputStreamMicro.readInt32());
                        continue;
                    case 42:
                        setPm25T(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setPic0(codedInputStreamMicro.readString());
                        continue;
                    case 56:
                        setPic0T(codedInputStreamMicro.readInt32());
                        continue;
                    case 66:
                        setPicName0(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setTime0(codedInputStreamMicro.readString());
                        continue;
                    case 82:
                        setWind0(codedInputStreamMicro.readString());
                        continue;
                    case 90:
                        setPic01(codedInputStreamMicro.readString());
                        continue;
                    case 98:
                        setPic02(codedInputStreamMicro.readString());
                        continue;
                    case 106:
                        setTime1(codedInputStreamMicro.readString());
                        continue;
                    case 114:
                        setWeather1(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.df /*122*/:
                        setTemp1(codedInputStreamMicro.readString());
                        continue;
                    case 130:
                        setWind1(codedInputStreamMicro.readString());
                        continue;
                    case 138:
                        setPicName1(codedInputStreamMicro.readString());
                        continue;
                    case 146:
                        setPic1(codedInputStreamMicro.readString());
                        continue;
                    case 154:
                        setPic11(codedInputStreamMicro.readString());
                        continue;
                    case 162:
                        setPic12(codedInputStreamMicro.readString());
                        continue;
                    case 170:
                        setTime2(codedInputStreamMicro.readString());
                        continue;
                    case 178:
                        setWeather2(codedInputStreamMicro.readString());
                        continue;
                    case 186:
                        setTemp2(codedInputStreamMicro.readString());
                        continue;
                    case RouteLineResConst.LINE_INTERNAL_NORMAL /*194*/:
                        setWind2(codedInputStreamMicro.readString());
                        continue;
                    case 202:
                        setPicName2(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.ds /*210*/:
                        setPic2(codedInputStreamMicro.readString());
                        continue;
                    case 218:
                        setPic21(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.dG /*226*/:
                        setPic22(codedInputStreamMicro.readString());
                        continue;
                    case NaviCmdConstants.ACTION_TYPE_NAVI_TTS_MODE_EXPERT /*234*/:
                        setTime3(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.dM /*242*/:
                        setWeather3(codedInputStreamMicro.readString());
                        continue;
                    case 250:
                        setTemp3(codedInputStreamMicro.readString());
                        continue;
                    case 258:
                        setWind3(codedInputStreamMicro.readString());
                        continue;
                    case BNOfflineDataObserver.EVENT_UPDATE_PROGRESS /*266*/:
                        setPicName3(codedInputStreamMicro.readString());
                        continue;
                    case 274:
                        setPic3(codedInputStreamMicro.readString());
                        continue;
                    case 282:
                        setPic31(codedInputStreamMicro.readString());
                        continue;
                    case 290:
                        setPic32(codedInputStreamMicro.readString());
                        continue;
                    case 298:
                        setTime4(codedInputStreamMicro.readString());
                        continue;
                    case 306:
                        setWeather4(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.eb /*314*/:
                        setTemp4(codedInputStreamMicro.readString());
                        continue;
                    case NaviFragmentManager.TYPE_VOICE_SQUARE /*322*/:
                        setWind4(codedInputStreamMicro.readString());
                        continue;
                    case 330:
                        setPicName4(codedInputStreamMicro.readString());
                        continue;
                    case 338:
                        setPic4(codedInputStreamMicro.readString());
                        continue;
                    case 346:
                        setPic41(codedInputStreamMicro.readString());
                        continue;
                    case BusRouteProvider.START_NODE_STYLE /*354*/:
                        setPic42(codedInputStreamMicro.readString());
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

        public Contents setCname(String str) {
            this.f17132a = true;
            this.f17133b = str;
            return this;
        }

        public Contents setPic0(String str) {
            this.f17142k = true;
            this.f17143l = str;
            return this;
        }

        public Contents setPic01(String str) {
            this.f17152u = true;
            this.f17153v = str;
            return this;
        }

        public Contents setPic02(String str) {
            this.f17154w = true;
            this.f17155x = str;
            return this;
        }

        public Contents setPic0T(int i) {
            this.f17144m = true;
            this.f17145n = i;
            return this;
        }

        public Contents setPic1(String str) {
            this.f17114I = true;
            this.f17115J = str;
            return this;
        }

        public Contents setPic11(String str) {
            this.f17116K = true;
            this.f17117L = str;
            return this;
        }

        public Contents setPic12(String str) {
            this.f17118M = true;
            this.f17119N = str;
            return this;
        }

        public Contents setPic2(String str) {
            this.f17130Y = true;
            this.f17131Z = str;
            return this;
        }

        public Contents setPic21(String str) {
            this.aa = true;
            this.ab = str;
            return this;
        }

        public Contents setPic22(String str) {
            this.ac = true;
            this.ad = str;
            return this;
        }

        public Contents setPic3(String str) {
            this.ao = true;
            this.ap = str;
            return this;
        }

        public Contents setPic31(String str) {
            this.aq = true;
            this.ar = str;
            return this;
        }

        public Contents setPic32(String str) {
            this.as = true;
            this.at = str;
            return this;
        }

        public Contents setPic4(String str) {
            this.aE = true;
            this.aF = str;
            return this;
        }

        public Contents setPic41(String str) {
            this.aG = true;
            this.aH = str;
            return this;
        }

        public Contents setPic42(String str) {
            this.aI = true;
            this.aJ = str;
            return this;
        }

        public Contents setPicName0(String str) {
            this.f17146o = true;
            this.f17147p = str;
            return this;
        }

        public Contents setPicName1(String str) {
            this.f17112G = true;
            this.f17113H = str;
            return this;
        }

        public Contents setPicName2(String str) {
            this.f17128W = true;
            this.f17129X = str;
            return this;
        }

        public Contents setPicName3(String str) {
            this.am = true;
            this.an = str;
            return this;
        }

        public Contents setPicName4(String str) {
            this.aC = true;
            this.aD = str;
            return this;
        }

        public Contents setPm25(int i) {
            this.f17138g = true;
            this.f17139h = i;
            return this;
        }

        public Contents setPm25T(String str) {
            this.f17140i = true;
            this.f17141j = str;
            return this;
        }

        public Contents setTemp0(String str) {
            this.f17136e = true;
            this.f17137f = str;
            return this;
        }

        public Contents setTemp1(String str) {
            this.f17108C = true;
            this.f17109D = str;
            return this;
        }

        public Contents setTemp2(String str) {
            this.f17124S = true;
            this.f17125T = str;
            return this;
        }

        public Contents setTemp3(String str) {
            this.ai = true;
            this.aj = str;
            return this;
        }

        public Contents setTemp4(String str) {
            this.ay = true;
            this.az = str;
            return this;
        }

        public Contents setTime0(String str) {
            this.f17148q = true;
            this.f17149r = str;
            return this;
        }

        public Contents setTime1(String str) {
            this.f17156y = true;
            this.f17157z = str;
            return this;
        }

        public Contents setTime2(String str) {
            this.f17120O = true;
            this.f17121P = str;
            return this;
        }

        public Contents setTime3(String str) {
            this.ae = true;
            this.af = str;
            return this;
        }

        public Contents setTime4(String str) {
            this.au = true;
            this.av = str;
            return this;
        }

        public Contents setWeather0(String str) {
            this.f17134c = true;
            this.f17135d = str;
            return this;
        }

        public Contents setWeather1(String str) {
            this.f17106A = true;
            this.f17107B = str;
            return this;
        }

        public Contents setWeather2(String str) {
            this.f17122Q = true;
            this.f17123R = str;
            return this;
        }

        public Contents setWeather3(String str) {
            this.ag = true;
            this.ah = str;
            return this;
        }

        public Contents setWeather4(String str) {
            this.aw = true;
            this.ax = str;
            return this;
        }

        public Contents setWind0(String str) {
            this.f17150s = true;
            this.f17151t = str;
            return this;
        }

        public Contents setWind1(String str) {
            this.f17110E = true;
            this.f17111F = str;
            return this;
        }

        public Contents setWind2(String str) {
            this.f17126U = true;
            this.f17127V = str;
            return this;
        }

        public Contents setWind3(String str) {
            this.ak = true;
            this.al = str;
            return this;
        }

        public Contents setWind4(String str) {
            this.aA = true;
            this.aB = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasCname()) {
                codedOutputStreamMicro.writeString(1, getCname());
            }
            if (hasWeather0()) {
                codedOutputStreamMicro.writeString(2, getWeather0());
            }
            if (hasTemp0()) {
                codedOutputStreamMicro.writeString(3, getTemp0());
            }
            if (hasPm25()) {
                codedOutputStreamMicro.writeInt32(4, getPm25());
            }
            if (hasPm25T()) {
                codedOutputStreamMicro.writeString(5, getPm25T());
            }
            if (hasPic0()) {
                codedOutputStreamMicro.writeString(6, getPic0());
            }
            if (hasPic0T()) {
                codedOutputStreamMicro.writeInt32(7, getPic0T());
            }
            if (hasPicName0()) {
                codedOutputStreamMicro.writeString(8, getPicName0());
            }
            if (hasTime0()) {
                codedOutputStreamMicro.writeString(9, getTime0());
            }
            if (hasWind0()) {
                codedOutputStreamMicro.writeString(10, getWind0());
            }
            if (hasPic01()) {
                codedOutputStreamMicro.writeString(11, getPic01());
            }
            if (hasPic02()) {
                codedOutputStreamMicro.writeString(12, getPic02());
            }
            if (hasTime1()) {
                codedOutputStreamMicro.writeString(13, getTime1());
            }
            if (hasWeather1()) {
                codedOutputStreamMicro.writeString(14, getWeather1());
            }
            if (hasTemp1()) {
                codedOutputStreamMicro.writeString(15, getTemp1());
            }
            if (hasWind1()) {
                codedOutputStreamMicro.writeString(16, getWind1());
            }
            if (hasPicName1()) {
                codedOutputStreamMicro.writeString(17, getPicName1());
            }
            if (hasPic1()) {
                codedOutputStreamMicro.writeString(18, getPic1());
            }
            if (hasPic11()) {
                codedOutputStreamMicro.writeString(19, getPic11());
            }
            if (hasPic12()) {
                codedOutputStreamMicro.writeString(20, getPic12());
            }
            if (hasTime2()) {
                codedOutputStreamMicro.writeString(21, getTime2());
            }
            if (hasWeather2()) {
                codedOutputStreamMicro.writeString(22, getWeather2());
            }
            if (hasTemp2()) {
                codedOutputStreamMicro.writeString(23, getTemp2());
            }
            if (hasWind2()) {
                codedOutputStreamMicro.writeString(24, getWind2());
            }
            if (hasPicName2()) {
                codedOutputStreamMicro.writeString(25, getPicName2());
            }
            if (hasPic2()) {
                codedOutputStreamMicro.writeString(26, getPic2());
            }
            if (hasPic21()) {
                codedOutputStreamMicro.writeString(27, getPic21());
            }
            if (hasPic22()) {
                codedOutputStreamMicro.writeString(28, getPic22());
            }
            if (hasTime3()) {
                codedOutputStreamMicro.writeString(29, getTime3());
            }
            if (hasWeather3()) {
                codedOutputStreamMicro.writeString(30, getWeather3());
            }
            if (hasTemp3()) {
                codedOutputStreamMicro.writeString(31, getTemp3());
            }
            if (hasWind3()) {
                codedOutputStreamMicro.writeString(32, getWind3());
            }
            if (hasPicName3()) {
                codedOutputStreamMicro.writeString(33, getPicName3());
            }
            if (hasPic3()) {
                codedOutputStreamMicro.writeString(34, getPic3());
            }
            if (hasPic31()) {
                codedOutputStreamMicro.writeString(35, getPic31());
            }
            if (hasPic32()) {
                codedOutputStreamMicro.writeString(36, getPic32());
            }
            if (hasTime4()) {
                codedOutputStreamMicro.writeString(37, getTime4());
            }
            if (hasWeather4()) {
                codedOutputStreamMicro.writeString(38, getWeather4());
            }
            if (hasTemp4()) {
                codedOutputStreamMicro.writeString(39, getTemp4());
            }
            if (hasWind4()) {
                codedOutputStreamMicro.writeString(40, getWind4());
            }
            if (hasPicName4()) {
                codedOutputStreamMicro.writeString(41, getPicName4());
            }
            if (hasPic4()) {
                codedOutputStreamMicro.writeString(42, getPic4());
            }
            if (hasPic41()) {
                codedOutputStreamMicro.writeString(43, getPic41());
            }
            if (hasPic42()) {
                codedOutputStreamMicro.writeString(44, getPic42());
            }
        }
    }

    public static final class Option extends MessageMicro {
        public static final int STATUS_FIELD_NUMBER = 1;
        public static final int T_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f17158a;
        /* renamed from: b */
        private int f17159b = 0;
        /* renamed from: c */
        private boolean f17160c;
        /* renamed from: d */
        private String f17161d = "";
        /* renamed from: e */
        private int f17162e = -1;

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }

        public final Option clear() {
            clearStatus();
            clearT();
            this.f17162e = -1;
            return this;
        }

        public Option clearStatus() {
            this.f17158a = false;
            this.f17159b = 0;
            return this;
        }

        public Option clearT() {
            this.f17160c = false;
            this.f17161d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f17162e < 0) {
                getSerializedSize();
            }
            return this.f17162e;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasStatus()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getStatus());
            }
            if (hasT()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getT());
            }
            this.f17162e = i;
            return i;
        }

        public int getStatus() {
            return this.f17159b;
        }

        public String getT() {
            return this.f17161d;
        }

        public boolean hasStatus() {
            return this.f17158a;
        }

        public boolean hasT() {
            return this.f17160c;
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
                        setStatus(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setT(codedInputStreamMicro.readString());
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

        public Option setStatus(int i) {
            this.f17158a = true;
            this.f17159b = i;
            return this;
        }

        public Option setT(String str) {
            this.f17160c = true;
            this.f17161d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasStatus()) {
                codedOutputStreamMicro.writeInt32(1, getStatus());
            }
            if (hasT()) {
                codedOutputStreamMicro.writeString(2, getT());
            }
        }
    }

    public static Weather parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Weather().mergeFrom(codedInputStreamMicro);
    }

    public static Weather parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Weather) new Weather().mergeFrom(bArr);
    }

    public final Weather clear() {
        clearOption();
        clearContents();
        this.f17167e = -1;
        return this;
    }

    public Weather clearContents() {
        this.f17165c = false;
        this.f17166d = null;
        return this;
    }

    public Weather clearOption() {
        this.f17163a = false;
        this.f17164b = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f17167e < 0) {
            getSerializedSize();
        }
        return this.f17167e;
    }

    public Contents getContents() {
        return this.f17166d;
    }

    public Option getOption() {
        return this.f17164b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasOption()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
        }
        if (hasContents()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getContents());
        }
        this.f17167e = i;
        return i;
    }

    public boolean hasContents() {
        return this.f17165c;
    }

    public boolean hasOption() {
        return this.f17163a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Weather mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                    option = new Contents();
                    codedInputStreamMicro.readMessage(option);
                    setContents(option);
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

    public Weather setContents(Contents contents) {
        if (contents == null) {
            return clearContents();
        }
        this.f17165c = true;
        this.f17166d = contents;
        return this;
    }

    public Weather setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f17163a = true;
        this.f17164b = option;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(1, getOption());
        }
        if (hasContents()) {
            codedOutputStreamMicro.writeMessage(2, getContents());
        }
    }
}
