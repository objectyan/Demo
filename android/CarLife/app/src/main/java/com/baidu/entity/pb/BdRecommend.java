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

public final class BdRecommend extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 1;
    public static final int ERROR_FIELD_NUMBER = 8;
    public static final int INDUSTRY_FIELD_NUMBER = 10;
    public static final int LBS_FORWARD_FIELD_NUMBER = 11;
    public static final int LDATA_FIELD_NUMBER = 13;
    public static final int MORE_FIELD_NUMBER = 9;
    public static final int QID_FIELD_NUMBER = 12;
    /* renamed from: a */
    private List<Content> f9681a = Collections.emptyList();
    /* renamed from: b */
    private boolean f9682b;
    /* renamed from: c */
    private int f9683c = 0;
    /* renamed from: d */
    private boolean f9684d;
    /* renamed from: e */
    private int f9685e = 0;
    /* renamed from: f */
    private boolean f9686f;
    /* renamed from: g */
    private String f9687g = "";
    /* renamed from: h */
    private boolean f9688h;
    /* renamed from: i */
    private String f9689i = "";
    /* renamed from: j */
    private boolean f9690j;
    /* renamed from: k */
    private String f9691k = "";
    /* renamed from: l */
    private boolean f9692l;
    /* renamed from: m */
    private String f9693m = "";
    /* renamed from: n */
    private int f9694n = -1;

    public static final class Content extends MessageMicro {
        public static final int GROUPON_ID_FIELD_NUMBER = 9;
        public static final int LIKE_PARAM_FIELD_NUMBER = 7;
        public static final int ORIGINAL_PRICE_FIELD_NUMBER = 11;
        public static final int PIC_URL_FIELD_NUMBER = 2;
        public static final int POI_INDUSTRY_FIELD_NUMBER = 1;
        public static final int PX_FIELD_NUMBER = 4;
        public static final int PY_FIELD_NUMBER = 5;
        public static final int SCENE_FIELD_NUMBER = 6;
        public static final int TUAN_PRICE_FIELD_NUMBER = 10;
        public static final int UID_FIELD_NUMBER = 3;
        public static final int UI_DATA_FIELD_NUMBER = 8;
        /* renamed from: a */
        private boolean f9658a;
        /* renamed from: b */
        private String f9659b = "";
        /* renamed from: c */
        private boolean f9660c;
        /* renamed from: d */
        private String f9661d = "";
        /* renamed from: e */
        private boolean f9662e;
        /* renamed from: f */
        private String f9663f = "";
        /* renamed from: g */
        private boolean f9664g;
        /* renamed from: h */
        private String f9665h = "";
        /* renamed from: i */
        private boolean f9666i;
        /* renamed from: j */
        private String f9667j = "";
        /* renamed from: k */
        private boolean f9668k;
        /* renamed from: l */
        private String f9669l = "";
        /* renamed from: m */
        private boolean f9670m;
        /* renamed from: n */
        private LikeParam f9671n = null;
        /* renamed from: o */
        private boolean f9672o;
        /* renamed from: p */
        private UiData f9673p = null;
        /* renamed from: q */
        private boolean f9674q;
        /* renamed from: r */
        private String f9675r = "";
        /* renamed from: s */
        private boolean f9676s;
        /* renamed from: t */
        private String f9677t = "";
        /* renamed from: u */
        private boolean f9678u;
        /* renamed from: v */
        private String f9679v = "";
        /* renamed from: w */
        private int f9680w = -1;

        public static final class LikeParam extends MessageMicro {
            public static final int KEY_FIELD_NUMBER = 1;
            public static final int SUBKEY_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f9628a;
            /* renamed from: b */
            private String f9629b = "";
            /* renamed from: c */
            private boolean f9630c;
            /* renamed from: d */
            private String f9631d = "";
            /* renamed from: e */
            private int f9632e = -1;

            public static LikeParam parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new LikeParam().mergeFrom(codedInputStreamMicro);
            }

            public static LikeParam parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (LikeParam) new LikeParam().mergeFrom(bArr);
            }

            public final LikeParam clear() {
                clearKey();
                clearSubkey();
                this.f9632e = -1;
                return this;
            }

            public LikeParam clearKey() {
                this.f9628a = false;
                this.f9629b = "";
                return this;
            }

            public LikeParam clearSubkey() {
                this.f9630c = false;
                this.f9631d = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f9632e < 0) {
                    getSerializedSize();
                }
                return this.f9632e;
            }

            public String getKey() {
                return this.f9629b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasKey()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getKey());
                }
                if (hasSubkey()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getSubkey());
                }
                this.f9632e = i;
                return i;
            }

            public String getSubkey() {
                return this.f9631d;
            }

            public boolean hasKey() {
                return this.f9628a;
            }

            public boolean hasSubkey() {
                return this.f9630c;
            }

            public final boolean isInitialized() {
                return true;
            }

            public LikeParam mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setKey(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setSubkey(codedInputStreamMicro.readString());
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

            public LikeParam setKey(String str) {
                this.f9628a = true;
                this.f9629b = str;
                return this;
            }

            public LikeParam setSubkey(String str) {
                this.f9630c = true;
                this.f9631d = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasKey()) {
                    codedOutputStreamMicro.writeString(1, getKey());
                }
                if (hasSubkey()) {
                    codedOutputStreamMicro.writeString(2, getSubkey());
                }
            }
        }

        public static final class UiData extends MessageMicro {
            public static final int SECTION10_FIELD_NUMBER = 10;
            public static final int SECTION11_FIELD_NUMBER = 11;
            public static final int SECTION12_FIELD_NUMBER = 12;
            public static final int SECTION1_FIELD_NUMBER = 1;
            public static final int SECTION2_FIELD_NUMBER = 2;
            public static final int SECTION3_FIELD_NUMBER = 3;
            public static final int SECTION4_FIELD_NUMBER = 4;
            public static final int SECTION5_FIELD_NUMBER = 5;
            public static final int SECTION6_FIELD_NUMBER = 6;
            public static final int SECTION7_FIELD_NUMBER = 7;
            public static final int SECTION8_FIELD_NUMBER = 8;
            public static final int SECTION9_FIELD_NUMBER = 9;
            /* renamed from: a */
            private boolean f9633a;
            /* renamed from: b */
            private String f9634b = "";
            /* renamed from: c */
            private boolean f9635c;
            /* renamed from: d */
            private String f9636d = "";
            /* renamed from: e */
            private boolean f9637e;
            /* renamed from: f */
            private String f9638f = "";
            /* renamed from: g */
            private boolean f9639g;
            /* renamed from: h */
            private String f9640h = "";
            /* renamed from: i */
            private boolean f9641i;
            /* renamed from: j */
            private String f9642j = "";
            /* renamed from: k */
            private boolean f9643k;
            /* renamed from: l */
            private String f9644l = "";
            /* renamed from: m */
            private boolean f9645m;
            /* renamed from: n */
            private String f9646n = "";
            /* renamed from: o */
            private boolean f9647o;
            /* renamed from: p */
            private String f9648p = "";
            /* renamed from: q */
            private boolean f9649q;
            /* renamed from: r */
            private String f9650r = "";
            /* renamed from: s */
            private boolean f9651s;
            /* renamed from: t */
            private String f9652t = "";
            /* renamed from: u */
            private boolean f9653u;
            /* renamed from: v */
            private String f9654v = "";
            /* renamed from: w */
            private boolean f9655w;
            /* renamed from: x */
            private String f9656x = "";
            /* renamed from: y */
            private int f9657y = -1;

            public static UiData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new UiData().mergeFrom(codedInputStreamMicro);
            }

            public static UiData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (UiData) new UiData().mergeFrom(bArr);
            }

            public final UiData clear() {
                clearSection1();
                clearSection2();
                clearSection3();
                clearSection4();
                clearSection5();
                clearSection6();
                clearSection7();
                clearSection8();
                clearSection9();
                clearSection10();
                clearSection11();
                clearSection12();
                this.f9657y = -1;
                return this;
            }

            public UiData clearSection1() {
                this.f9633a = false;
                this.f9634b = "";
                return this;
            }

            public UiData clearSection10() {
                this.f9651s = false;
                this.f9652t = "";
                return this;
            }

            public UiData clearSection11() {
                this.f9653u = false;
                this.f9654v = "";
                return this;
            }

            public UiData clearSection12() {
                this.f9655w = false;
                this.f9656x = "";
                return this;
            }

            public UiData clearSection2() {
                this.f9635c = false;
                this.f9636d = "";
                return this;
            }

            public UiData clearSection3() {
                this.f9637e = false;
                this.f9638f = "";
                return this;
            }

            public UiData clearSection4() {
                this.f9639g = false;
                this.f9640h = "";
                return this;
            }

            public UiData clearSection5() {
                this.f9641i = false;
                this.f9642j = "";
                return this;
            }

            public UiData clearSection6() {
                this.f9643k = false;
                this.f9644l = "";
                return this;
            }

            public UiData clearSection7() {
                this.f9645m = false;
                this.f9646n = "";
                return this;
            }

            public UiData clearSection8() {
                this.f9647o = false;
                this.f9648p = "";
                return this;
            }

            public UiData clearSection9() {
                this.f9649q = false;
                this.f9650r = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f9657y < 0) {
                    getSerializedSize();
                }
                return this.f9657y;
            }

            public String getSection1() {
                return this.f9634b;
            }

            public String getSection10() {
                return this.f9652t;
            }

            public String getSection11() {
                return this.f9654v;
            }

            public String getSection12() {
                return this.f9656x;
            }

            public String getSection2() {
                return this.f9636d;
            }

            public String getSection3() {
                return this.f9638f;
            }

            public String getSection4() {
                return this.f9640h;
            }

            public String getSection5() {
                return this.f9642j;
            }

            public String getSection6() {
                return this.f9644l;
            }

            public String getSection7() {
                return this.f9646n;
            }

            public String getSection8() {
                return this.f9648p;
            }

            public String getSection9() {
                return this.f9650r;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasSection1()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getSection1());
                }
                if (hasSection2()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getSection2());
                }
                if (hasSection3()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getSection3());
                }
                if (hasSection4()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getSection4());
                }
                if (hasSection5()) {
                    i += CodedOutputStreamMicro.computeStringSize(5, getSection5());
                }
                if (hasSection6()) {
                    i += CodedOutputStreamMicro.computeStringSize(6, getSection6());
                }
                if (hasSection7()) {
                    i += CodedOutputStreamMicro.computeStringSize(7, getSection7());
                }
                if (hasSection8()) {
                    i += CodedOutputStreamMicro.computeStringSize(8, getSection8());
                }
                if (hasSection9()) {
                    i += CodedOutputStreamMicro.computeStringSize(9, getSection9());
                }
                if (hasSection10()) {
                    i += CodedOutputStreamMicro.computeStringSize(10, getSection10());
                }
                if (hasSection11()) {
                    i += CodedOutputStreamMicro.computeStringSize(11, getSection11());
                }
                if (hasSection12()) {
                    i += CodedOutputStreamMicro.computeStringSize(12, getSection12());
                }
                this.f9657y = i;
                return i;
            }

            public boolean hasSection1() {
                return this.f9633a;
            }

            public boolean hasSection10() {
                return this.f9651s;
            }

            public boolean hasSection11() {
                return this.f9653u;
            }

            public boolean hasSection12() {
                return this.f9655w;
            }

            public boolean hasSection2() {
                return this.f9635c;
            }

            public boolean hasSection3() {
                return this.f9637e;
            }

            public boolean hasSection4() {
                return this.f9639g;
            }

            public boolean hasSection5() {
                return this.f9641i;
            }

            public boolean hasSection6() {
                return this.f9643k;
            }

            public boolean hasSection7() {
                return this.f9645m;
            }

            public boolean hasSection8() {
                return this.f9647o;
            }

            public boolean hasSection9() {
                return this.f9649q;
            }

            public final boolean isInitialized() {
                return true;
            }

            public UiData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setSection1(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setSection2(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setSection3(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setSection4(codedInputStreamMicro.readString());
                            continue;
                        case 42:
                            setSection5(codedInputStreamMicro.readString());
                            continue;
                        case 50:
                            setSection6(codedInputStreamMicro.readString());
                            continue;
                        case 58:
                            setSection7(codedInputStreamMicro.readString());
                            continue;
                        case 66:
                            setSection8(codedInputStreamMicro.readString());
                            continue;
                        case 74:
                            setSection9(codedInputStreamMicro.readString());
                            continue;
                        case 82:
                            setSection10(codedInputStreamMicro.readString());
                            continue;
                        case 90:
                            setSection11(codedInputStreamMicro.readString());
                            continue;
                        case 98:
                            setSection12(codedInputStreamMicro.readString());
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

            public UiData setSection1(String str) {
                this.f9633a = true;
                this.f9634b = str;
                return this;
            }

            public UiData setSection10(String str) {
                this.f9651s = true;
                this.f9652t = str;
                return this;
            }

            public UiData setSection11(String str) {
                this.f9653u = true;
                this.f9654v = str;
                return this;
            }

            public UiData setSection12(String str) {
                this.f9655w = true;
                this.f9656x = str;
                return this;
            }

            public UiData setSection2(String str) {
                this.f9635c = true;
                this.f9636d = str;
                return this;
            }

            public UiData setSection3(String str) {
                this.f9637e = true;
                this.f9638f = str;
                return this;
            }

            public UiData setSection4(String str) {
                this.f9639g = true;
                this.f9640h = str;
                return this;
            }

            public UiData setSection5(String str) {
                this.f9641i = true;
                this.f9642j = str;
                return this;
            }

            public UiData setSection6(String str) {
                this.f9643k = true;
                this.f9644l = str;
                return this;
            }

            public UiData setSection7(String str) {
                this.f9645m = true;
                this.f9646n = str;
                return this;
            }

            public UiData setSection8(String str) {
                this.f9647o = true;
                this.f9648p = str;
                return this;
            }

            public UiData setSection9(String str) {
                this.f9649q = true;
                this.f9650r = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasSection1()) {
                    codedOutputStreamMicro.writeString(1, getSection1());
                }
                if (hasSection2()) {
                    codedOutputStreamMicro.writeString(2, getSection2());
                }
                if (hasSection3()) {
                    codedOutputStreamMicro.writeString(3, getSection3());
                }
                if (hasSection4()) {
                    codedOutputStreamMicro.writeString(4, getSection4());
                }
                if (hasSection5()) {
                    codedOutputStreamMicro.writeString(5, getSection5());
                }
                if (hasSection6()) {
                    codedOutputStreamMicro.writeString(6, getSection6());
                }
                if (hasSection7()) {
                    codedOutputStreamMicro.writeString(7, getSection7());
                }
                if (hasSection8()) {
                    codedOutputStreamMicro.writeString(8, getSection8());
                }
                if (hasSection9()) {
                    codedOutputStreamMicro.writeString(9, getSection9());
                }
                if (hasSection10()) {
                    codedOutputStreamMicro.writeString(10, getSection10());
                }
                if (hasSection11()) {
                    codedOutputStreamMicro.writeString(11, getSection11());
                }
                if (hasSection12()) {
                    codedOutputStreamMicro.writeString(12, getSection12());
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
            clearPoiIndustry();
            clearPicUrl();
            clearUid();
            clearPx();
            clearPy();
            clearScene();
            clearLikeParam();
            clearUiData();
            clearGrouponId();
            clearTuanPrice();
            clearOriginalPrice();
            this.f9680w = -1;
            return this;
        }

        public Content clearGrouponId() {
            this.f9674q = false;
            this.f9675r = "";
            return this;
        }

        public Content clearLikeParam() {
            this.f9670m = false;
            this.f9671n = null;
            return this;
        }

        public Content clearOriginalPrice() {
            this.f9678u = false;
            this.f9679v = "";
            return this;
        }

        public Content clearPicUrl() {
            this.f9660c = false;
            this.f9661d = "";
            return this;
        }

        public Content clearPoiIndustry() {
            this.f9658a = false;
            this.f9659b = "";
            return this;
        }

        public Content clearPx() {
            this.f9664g = false;
            this.f9665h = "";
            return this;
        }

        public Content clearPy() {
            this.f9666i = false;
            this.f9667j = "";
            return this;
        }

        public Content clearScene() {
            this.f9668k = false;
            this.f9669l = "";
            return this;
        }

        public Content clearTuanPrice() {
            this.f9676s = false;
            this.f9677t = "";
            return this;
        }

        public Content clearUiData() {
            this.f9672o = false;
            this.f9673p = null;
            return this;
        }

        public Content clearUid() {
            this.f9662e = false;
            this.f9663f = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f9680w < 0) {
                getSerializedSize();
            }
            return this.f9680w;
        }

        public String getGrouponId() {
            return this.f9675r;
        }

        public LikeParam getLikeParam() {
            return this.f9671n;
        }

        public String getOriginalPrice() {
            return this.f9679v;
        }

        public String getPicUrl() {
            return this.f9661d;
        }

        public String getPoiIndustry() {
            return this.f9659b;
        }

        public String getPx() {
            return this.f9665h;
        }

        public String getPy() {
            return this.f9667j;
        }

        public String getScene() {
            return this.f9669l;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasPoiIndustry()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getPoiIndustry());
            }
            if (hasPicUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getPicUrl());
            }
            if (hasUid()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getUid());
            }
            if (hasPx()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getPx());
            }
            if (hasPy()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getPy());
            }
            if (hasScene()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getScene());
            }
            if (hasLikeParam()) {
                i += CodedOutputStreamMicro.computeMessageSize(7, getLikeParam());
            }
            if (hasUiData()) {
                i += CodedOutputStreamMicro.computeMessageSize(8, getUiData());
            }
            if (hasGrouponId()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getGrouponId());
            }
            if (hasTuanPrice()) {
                i += CodedOutputStreamMicro.computeStringSize(10, getTuanPrice());
            }
            if (hasOriginalPrice()) {
                i += CodedOutputStreamMicro.computeStringSize(11, getOriginalPrice());
            }
            this.f9680w = i;
            return i;
        }

        public String getTuanPrice() {
            return this.f9677t;
        }

        public UiData getUiData() {
            return this.f9673p;
        }

        public String getUid() {
            return this.f9663f;
        }

        public boolean hasGrouponId() {
            return this.f9674q;
        }

        public boolean hasLikeParam() {
            return this.f9670m;
        }

        public boolean hasOriginalPrice() {
            return this.f9678u;
        }

        public boolean hasPicUrl() {
            return this.f9660c;
        }

        public boolean hasPoiIndustry() {
            return this.f9658a;
        }

        public boolean hasPx() {
            return this.f9664g;
        }

        public boolean hasPy() {
            return this.f9666i;
        }

        public boolean hasScene() {
            return this.f9668k;
        }

        public boolean hasTuanPrice() {
            return this.f9676s;
        }

        public boolean hasUiData() {
            return this.f9672o;
        }

        public boolean hasUid() {
            return this.f9662e;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Content mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro likeParam;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setPoiIndustry(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setPicUrl(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setUid(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setPx(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setPy(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setScene(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        likeParam = new LikeParam();
                        codedInputStreamMicro.readMessage(likeParam);
                        setLikeParam(likeParam);
                        continue;
                    case 66:
                        likeParam = new UiData();
                        codedInputStreamMicro.readMessage(likeParam);
                        setUiData(likeParam);
                        continue;
                    case 74:
                        setGrouponId(codedInputStreamMicro.readString());
                        continue;
                    case 82:
                        setTuanPrice(codedInputStreamMicro.readString());
                        continue;
                    case 90:
                        setOriginalPrice(codedInputStreamMicro.readString());
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

        public Content setGrouponId(String str) {
            this.f9674q = true;
            this.f9675r = str;
            return this;
        }

        public Content setLikeParam(LikeParam likeParam) {
            if (likeParam == null) {
                return clearLikeParam();
            }
            this.f9670m = true;
            this.f9671n = likeParam;
            return this;
        }

        public Content setOriginalPrice(String str) {
            this.f9678u = true;
            this.f9679v = str;
            return this;
        }

        public Content setPicUrl(String str) {
            this.f9660c = true;
            this.f9661d = str;
            return this;
        }

        public Content setPoiIndustry(String str) {
            this.f9658a = true;
            this.f9659b = str;
            return this;
        }

        public Content setPx(String str) {
            this.f9664g = true;
            this.f9665h = str;
            return this;
        }

        public Content setPy(String str) {
            this.f9666i = true;
            this.f9667j = str;
            return this;
        }

        public Content setScene(String str) {
            this.f9668k = true;
            this.f9669l = str;
            return this;
        }

        public Content setTuanPrice(String str) {
            this.f9676s = true;
            this.f9677t = str;
            return this;
        }

        public Content setUiData(UiData uiData) {
            if (uiData == null) {
                return clearUiData();
            }
            this.f9672o = true;
            this.f9673p = uiData;
            return this;
        }

        public Content setUid(String str) {
            this.f9662e = true;
            this.f9663f = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasPoiIndustry()) {
                codedOutputStreamMicro.writeString(1, getPoiIndustry());
            }
            if (hasPicUrl()) {
                codedOutputStreamMicro.writeString(2, getPicUrl());
            }
            if (hasUid()) {
                codedOutputStreamMicro.writeString(3, getUid());
            }
            if (hasPx()) {
                codedOutputStreamMicro.writeString(4, getPx());
            }
            if (hasPy()) {
                codedOutputStreamMicro.writeString(5, getPy());
            }
            if (hasScene()) {
                codedOutputStreamMicro.writeString(6, getScene());
            }
            if (hasLikeParam()) {
                codedOutputStreamMicro.writeMessage(7, getLikeParam());
            }
            if (hasUiData()) {
                codedOutputStreamMicro.writeMessage(8, getUiData());
            }
            if (hasGrouponId()) {
                codedOutputStreamMicro.writeString(9, getGrouponId());
            }
            if (hasTuanPrice()) {
                codedOutputStreamMicro.writeString(10, getTuanPrice());
            }
            if (hasOriginalPrice()) {
                codedOutputStreamMicro.writeString(11, getOriginalPrice());
            }
        }
    }

    public static BdRecommend parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new BdRecommend().mergeFrom(codedInputStreamMicro);
    }

    public static BdRecommend parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (BdRecommend) new BdRecommend().mergeFrom(bArr);
    }

    public BdRecommend addContent(Content content) {
        if (content != null) {
            if (this.f9681a.isEmpty()) {
                this.f9681a = new ArrayList();
            }
            this.f9681a.add(content);
        }
        return this;
    }

    public final BdRecommend clear() {
        clearContent();
        clearError();
        clearMore();
        clearIndustry();
        clearLbsForward();
        clearQid();
        clearLdata();
        this.f9694n = -1;
        return this;
    }

    public BdRecommend clearContent() {
        this.f9681a = Collections.emptyList();
        return this;
    }

    public BdRecommend clearError() {
        this.f9682b = false;
        this.f9683c = 0;
        return this;
    }

    public BdRecommend clearIndustry() {
        this.f9686f = false;
        this.f9687g = "";
        return this;
    }

    public BdRecommend clearLbsForward() {
        this.f9688h = false;
        this.f9689i = "";
        return this;
    }

    public BdRecommend clearLdata() {
        this.f9692l = false;
        this.f9693m = "";
        return this;
    }

    public BdRecommend clearMore() {
        this.f9684d = false;
        this.f9685e = 0;
        return this;
    }

    public BdRecommend clearQid() {
        this.f9690j = false;
        this.f9691k = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f9694n < 0) {
            getSerializedSize();
        }
        return this.f9694n;
    }

    public Content getContent(int i) {
        return (Content) this.f9681a.get(i);
    }

    public int getContentCount() {
        return this.f9681a.size();
    }

    public List<Content> getContentList() {
        return this.f9681a;
    }

    public int getError() {
        return this.f9683c;
    }

    public String getIndustry() {
        return this.f9687g;
    }

    public String getLbsForward() {
        return this.f9689i;
    }

    public String getLdata() {
        return this.f9693m;
    }

    public int getMore() {
        return this.f9685e;
    }

    public String getQid() {
        return this.f9691k;
    }

    public int getSerializedSize() {
        int i = 0;
        for (Content computeMessageSize : getContentList()) {
            i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
        }
        if (hasError()) {
            i += CodedOutputStreamMicro.computeInt32Size(8, getError());
        }
        if (hasMore()) {
            i += CodedOutputStreamMicro.computeInt32Size(9, getMore());
        }
        if (hasIndustry()) {
            i += CodedOutputStreamMicro.computeStringSize(10, getIndustry());
        }
        if (hasLbsForward()) {
            i += CodedOutputStreamMicro.computeStringSize(11, getLbsForward());
        }
        if (hasQid()) {
            i += CodedOutputStreamMicro.computeStringSize(12, getQid());
        }
        if (hasLdata()) {
            i += CodedOutputStreamMicro.computeStringSize(13, getLdata());
        }
        this.f9694n = i;
        return i;
    }

    public boolean hasError() {
        return this.f9682b;
    }

    public boolean hasIndustry() {
        return this.f9686f;
    }

    public boolean hasLbsForward() {
        return this.f9688h;
    }

    public boolean hasLdata() {
        return this.f9692l;
    }

    public boolean hasMore() {
        return this.f9684d;
    }

    public boolean hasQid() {
        return this.f9690j;
    }

    public final boolean isInitialized() {
        return true;
    }

    public BdRecommend mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    MessageMicro content = new Content();
                    codedInputStreamMicro.readMessage(content);
                    addContent(content);
                    continue;
                case 64:
                    setError(codedInputStreamMicro.readInt32());
                    continue;
                case NavCarInfo.CarType_57L /*72*/:
                    setMore(codedInputStreamMicro.readInt32());
                    continue;
                case 82:
                    setIndustry(codedInputStreamMicro.readString());
                    continue;
                case 90:
                    setLbsForward(codedInputStreamMicro.readString());
                    continue;
                case 98:
                    setQid(codedInputStreamMicro.readString());
                    continue;
                case 106:
                    setLdata(codedInputStreamMicro.readString());
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

    public BdRecommend setContent(int i, Content content) {
        if (content != null) {
            this.f9681a.set(i, content);
        }
        return this;
    }

    public BdRecommend setError(int i) {
        this.f9682b = true;
        this.f9683c = i;
        return this;
    }

    public BdRecommend setIndustry(String str) {
        this.f9686f = true;
        this.f9687g = str;
        return this;
    }

    public BdRecommend setLbsForward(String str) {
        this.f9688h = true;
        this.f9689i = str;
        return this;
    }

    public BdRecommend setLdata(String str) {
        this.f9692l = true;
        this.f9693m = str;
        return this;
    }

    public BdRecommend setMore(int i) {
        this.f9684d = true;
        this.f9685e = i;
        return this;
    }

    public BdRecommend setQid(String str) {
        this.f9690j = true;
        this.f9691k = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (Content writeMessage : getContentList()) {
            codedOutputStreamMicro.writeMessage(1, writeMessage);
        }
        if (hasError()) {
            codedOutputStreamMicro.writeInt32(8, getError());
        }
        if (hasMore()) {
            codedOutputStreamMicro.writeInt32(9, getMore());
        }
        if (hasIndustry()) {
            codedOutputStreamMicro.writeString(10, getIndustry());
        }
        if (hasLbsForward()) {
            codedOutputStreamMicro.writeString(11, getLbsForward());
        }
        if (hasQid()) {
            codedOutputStreamMicro.writeString(12, getQid());
        }
        if (hasLdata()) {
            codedOutputStreamMicro.writeString(13, getLdata());
        }
    }
}
