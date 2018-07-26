package com.baidu.entity.pb;

import com.baidu.baidunavis.model.NavCarInfo;
import com.baidu.carlife.core.C1253f;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BzList extends MessageMicro {
    public static final int CATER_FIELD_NUMBER = 3;
    public static final int CIRCLE_NAME_FIELD_NUMBER = 4;
    public static final int CIRCLE_NAME_RECOMMEND_FIELD_NUMBER = 5;
    public static final int CONTENT_FIELD_NUMBER = 1;
    public static final int C_FIELD_NUMBER = 2;
    public static final int ERROR_FIELD_NUMBER = 8;
    public static final int INDUSTRY_FIELD_NUMBER = 10;
    public static final int MORE_FIELD_NUMBER = 9;
    public static final int PX_FIELD_NUMBER = 6;
    public static final int PY_FIELD_NUMBER = 7;
    public static final int TOTAL_COUNT_FIELD_NUMBER = 12;
    /* renamed from: a */
    private List<Content> f10471a = Collections.emptyList();
    /* renamed from: b */
    private boolean f10472b;
    /* renamed from: c */
    private String f10473c = "";
    /* renamed from: d */
    private boolean f10474d;
    /* renamed from: e */
    private String f10475e = "";
    /* renamed from: f */
    private boolean f10476f;
    /* renamed from: g */
    private String f10477g = "";
    /* renamed from: h */
    private boolean f10478h;
    /* renamed from: i */
    private String f10479i = "";
    /* renamed from: j */
    private boolean f10480j;
    /* renamed from: k */
    private String f10481k = "";
    /* renamed from: l */
    private boolean f10482l;
    /* renamed from: m */
    private String f10483m = "";
    /* renamed from: n */
    private boolean f10484n;
    /* renamed from: o */
    private int f10485o = 0;
    /* renamed from: p */
    private boolean f10486p;
    /* renamed from: q */
    private int f10487q = 0;
    /* renamed from: r */
    private boolean f10488r;
    /* renamed from: s */
    private String f10489s = "";
    /* renamed from: t */
    private boolean f10490t;
    /* renamed from: u */
    private int f10491u = 0;
    /* renamed from: v */
    private int f10492v = -1;

    public static final class Content extends MessageMicro {
        public static final int CIRCLE_NAME_FIELD_NUMBER = 4;
        public static final int DIS_FIELD_NUMBER = 15;
        public static final int FLAG_ON_LEFT_FIELD_NUMBER = 16;
        public static final int ID_FIELD_NUMBER = 11;
        public static final int PIC_URL_FIELD_NUMBER = 5;
        public static final int POI_INDUSTRY_FIELD_NUMBER = 1;
        public static final int PRICE_FIELD_NUMBER = 8;
        public static final int PRICE_TEXT_FIELD_NUMBER = 17;
        public static final int PX_FIELD_NUMBER = 9;
        public static final int PY_FIELD_NUMBER = 10;
        public static final int REC_REASON_FIELD_NUMBER = 13;
        public static final int SCENE_FIELD_NUMBER = 14;
        public static final int SCORE_FIELD_NUMBER = 6;
        public static final int STATE_FIELD_NUMBER = 3;
        public static final int TAG_FIELD_NUMBER = 7;
        public static final int TITLE_FIELD_NUMBER = 2;
        public static final int UID_FIELD_NUMBER = 12;
        /* renamed from: A */
        private boolean f10436A;
        /* renamed from: B */
        private String f10437B = "";
        /* renamed from: C */
        private boolean f10438C;
        /* renamed from: D */
        private String f10439D = "";
        /* renamed from: E */
        private boolean f10440E;
        /* renamed from: F */
        private String f10441F = "";
        /* renamed from: G */
        private boolean f10442G;
        /* renamed from: H */
        private String f10443H = "";
        /* renamed from: I */
        private int f10444I = -1;
        /* renamed from: a */
        private boolean f10445a;
        /* renamed from: b */
        private String f10446b = "";
        /* renamed from: c */
        private boolean f10447c;
        /* renamed from: d */
        private String f10448d = "";
        /* renamed from: e */
        private boolean f10449e;
        /* renamed from: f */
        private String f10450f = "";
        /* renamed from: g */
        private boolean f10451g;
        /* renamed from: h */
        private String f10452h = "";
        /* renamed from: i */
        private boolean f10453i;
        /* renamed from: j */
        private String f10454j = "";
        /* renamed from: k */
        private boolean f10455k;
        /* renamed from: l */
        private String f10456l = "";
        /* renamed from: m */
        private boolean f10457m;
        /* renamed from: n */
        private String f10458n = "";
        /* renamed from: o */
        private boolean f10459o;
        /* renamed from: p */
        private String f10460p = "";
        /* renamed from: q */
        private boolean f10461q;
        /* renamed from: r */
        private String f10462r = "";
        /* renamed from: s */
        private boolean f10463s;
        /* renamed from: t */
        private String f10464t = "";
        /* renamed from: u */
        private boolean f10465u;
        /* renamed from: v */
        private String f10466v = "";
        /* renamed from: w */
        private boolean f10467w;
        /* renamed from: x */
        private String f10468x = "";
        /* renamed from: y */
        private boolean f10469y;
        /* renamed from: z */
        private String f10470z = "";

        public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Content().mergeFrom(codedInputStreamMicro);
        }

        public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Content) new Content().mergeFrom(bArr);
        }

        public final Content clear() {
            clearPoiIndustry();
            clearTitle();
            clearState();
            clearCircleName();
            clearPicUrl();
            clearScore();
            clearTag();
            clearPrice();
            clearPx();
            clearPy();
            clearId();
            clearUid();
            clearRecReason();
            clearScene();
            clearDis();
            clearFlagOnLeft();
            clearPriceText();
            this.f10444I = -1;
            return this;
        }

        public Content clearCircleName() {
            this.f10451g = false;
            this.f10452h = "";
            return this;
        }

        public Content clearDis() {
            this.f10438C = false;
            this.f10439D = "";
            return this;
        }

        public Content clearFlagOnLeft() {
            this.f10440E = false;
            this.f10441F = "";
            return this;
        }

        public Content clearId() {
            this.f10465u = false;
            this.f10466v = "";
            return this;
        }

        public Content clearPicUrl() {
            this.f10453i = false;
            this.f10454j = "";
            return this;
        }

        public Content clearPoiIndustry() {
            this.f10445a = false;
            this.f10446b = "";
            return this;
        }

        public Content clearPrice() {
            this.f10459o = false;
            this.f10460p = "";
            return this;
        }

        public Content clearPriceText() {
            this.f10442G = false;
            this.f10443H = "";
            return this;
        }

        public Content clearPx() {
            this.f10461q = false;
            this.f10462r = "";
            return this;
        }

        public Content clearPy() {
            this.f10463s = false;
            this.f10464t = "";
            return this;
        }

        public Content clearRecReason() {
            this.f10469y = false;
            this.f10470z = "";
            return this;
        }

        public Content clearScene() {
            this.f10436A = false;
            this.f10437B = "";
            return this;
        }

        public Content clearScore() {
            this.f10455k = false;
            this.f10456l = "";
            return this;
        }

        public Content clearState() {
            this.f10449e = false;
            this.f10450f = "";
            return this;
        }

        public Content clearTag() {
            this.f10457m = false;
            this.f10458n = "";
            return this;
        }

        public Content clearTitle() {
            this.f10447c = false;
            this.f10448d = "";
            return this;
        }

        public Content clearUid() {
            this.f10467w = false;
            this.f10468x = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f10444I < 0) {
                getSerializedSize();
            }
            return this.f10444I;
        }

        public String getCircleName() {
            return this.f10452h;
        }

        public String getDis() {
            return this.f10439D;
        }

        public String getFlagOnLeft() {
            return this.f10441F;
        }

        public String getId() {
            return this.f10466v;
        }

        public String getPicUrl() {
            return this.f10454j;
        }

        public String getPoiIndustry() {
            return this.f10446b;
        }

        public String getPrice() {
            return this.f10460p;
        }

        public String getPriceText() {
            return this.f10443H;
        }

        public String getPx() {
            return this.f10462r;
        }

        public String getPy() {
            return this.f10464t;
        }

        public String getRecReason() {
            return this.f10470z;
        }

        public String getScene() {
            return this.f10437B;
        }

        public String getScore() {
            return this.f10456l;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasPoiIndustry()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getPoiIndustry());
            }
            if (hasTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getTitle());
            }
            if (hasState()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getState());
            }
            if (hasCircleName()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getCircleName());
            }
            if (hasPicUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getPicUrl());
            }
            if (hasScore()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getScore());
            }
            if (hasTag()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getTag());
            }
            if (hasPrice()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getPrice());
            }
            if (hasPx()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getPx());
            }
            if (hasPy()) {
                i += CodedOutputStreamMicro.computeStringSize(10, getPy());
            }
            if (hasId()) {
                i += CodedOutputStreamMicro.computeStringSize(11, getId());
            }
            if (hasUid()) {
                i += CodedOutputStreamMicro.computeStringSize(12, getUid());
            }
            if (hasRecReason()) {
                i += CodedOutputStreamMicro.computeStringSize(13, getRecReason());
            }
            if (hasScene()) {
                i += CodedOutputStreamMicro.computeStringSize(14, getScene());
            }
            if (hasDis()) {
                i += CodedOutputStreamMicro.computeStringSize(15, getDis());
            }
            if (hasFlagOnLeft()) {
                i += CodedOutputStreamMicro.computeStringSize(16, getFlagOnLeft());
            }
            if (hasPriceText()) {
                i += CodedOutputStreamMicro.computeStringSize(17, getPriceText());
            }
            this.f10444I = i;
            return i;
        }

        public String getState() {
            return this.f10450f;
        }

        public String getTag() {
            return this.f10458n;
        }

        public String getTitle() {
            return this.f10448d;
        }

        public String getUid() {
            return this.f10468x;
        }

        public boolean hasCircleName() {
            return this.f10451g;
        }

        public boolean hasDis() {
            return this.f10438C;
        }

        public boolean hasFlagOnLeft() {
            return this.f10440E;
        }

        public boolean hasId() {
            return this.f10465u;
        }

        public boolean hasPicUrl() {
            return this.f10453i;
        }

        public boolean hasPoiIndustry() {
            return this.f10445a;
        }

        public boolean hasPrice() {
            return this.f10459o;
        }

        public boolean hasPriceText() {
            return this.f10442G;
        }

        public boolean hasPx() {
            return this.f10461q;
        }

        public boolean hasPy() {
            return this.f10463s;
        }

        public boolean hasRecReason() {
            return this.f10469y;
        }

        public boolean hasScene() {
            return this.f10436A;
        }

        public boolean hasScore() {
            return this.f10455k;
        }

        public boolean hasState() {
            return this.f10449e;
        }

        public boolean hasTag() {
            return this.f10457m;
        }

        public boolean hasTitle() {
            return this.f10447c;
        }

        public boolean hasUid() {
            return this.f10467w;
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
                        setPoiIndustry(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setState(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setCircleName(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setPicUrl(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setScore(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setTag(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setPrice(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setPx(codedInputStreamMicro.readString());
                        continue;
                    case 82:
                        setPy(codedInputStreamMicro.readString());
                        continue;
                    case 90:
                        setId(codedInputStreamMicro.readString());
                        continue;
                    case 98:
                        setUid(codedInputStreamMicro.readString());
                        continue;
                    case 106:
                        setRecReason(codedInputStreamMicro.readString());
                        continue;
                    case 114:
                        setScene(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.df /*122*/:
                        setDis(codedInputStreamMicro.readString());
                        continue;
                    case 130:
                        setFlagOnLeft(codedInputStreamMicro.readString());
                        continue;
                    case 138:
                        setPriceText(codedInputStreamMicro.readString());
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

        public Content setCircleName(String str) {
            this.f10451g = true;
            this.f10452h = str;
            return this;
        }

        public Content setDis(String str) {
            this.f10438C = true;
            this.f10439D = str;
            return this;
        }

        public Content setFlagOnLeft(String str) {
            this.f10440E = true;
            this.f10441F = str;
            return this;
        }

        public Content setId(String str) {
            this.f10465u = true;
            this.f10466v = str;
            return this;
        }

        public Content setPicUrl(String str) {
            this.f10453i = true;
            this.f10454j = str;
            return this;
        }

        public Content setPoiIndustry(String str) {
            this.f10445a = true;
            this.f10446b = str;
            return this;
        }

        public Content setPrice(String str) {
            this.f10459o = true;
            this.f10460p = str;
            return this;
        }

        public Content setPriceText(String str) {
            this.f10442G = true;
            this.f10443H = str;
            return this;
        }

        public Content setPx(String str) {
            this.f10461q = true;
            this.f10462r = str;
            return this;
        }

        public Content setPy(String str) {
            this.f10463s = true;
            this.f10464t = str;
            return this;
        }

        public Content setRecReason(String str) {
            this.f10469y = true;
            this.f10470z = str;
            return this;
        }

        public Content setScene(String str) {
            this.f10436A = true;
            this.f10437B = str;
            return this;
        }

        public Content setScore(String str) {
            this.f10455k = true;
            this.f10456l = str;
            return this;
        }

        public Content setState(String str) {
            this.f10449e = true;
            this.f10450f = str;
            return this;
        }

        public Content setTag(String str) {
            this.f10457m = true;
            this.f10458n = str;
            return this;
        }

        public Content setTitle(String str) {
            this.f10447c = true;
            this.f10448d = str;
            return this;
        }

        public Content setUid(String str) {
            this.f10467w = true;
            this.f10468x = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasPoiIndustry()) {
                codedOutputStreamMicro.writeString(1, getPoiIndustry());
            }
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(2, getTitle());
            }
            if (hasState()) {
                codedOutputStreamMicro.writeString(3, getState());
            }
            if (hasCircleName()) {
                codedOutputStreamMicro.writeString(4, getCircleName());
            }
            if (hasPicUrl()) {
                codedOutputStreamMicro.writeString(5, getPicUrl());
            }
            if (hasScore()) {
                codedOutputStreamMicro.writeString(6, getScore());
            }
            if (hasTag()) {
                codedOutputStreamMicro.writeString(7, getTag());
            }
            if (hasPrice()) {
                codedOutputStreamMicro.writeString(8, getPrice());
            }
            if (hasPx()) {
                codedOutputStreamMicro.writeString(9, getPx());
            }
            if (hasPy()) {
                codedOutputStreamMicro.writeString(10, getPy());
            }
            if (hasId()) {
                codedOutputStreamMicro.writeString(11, getId());
            }
            if (hasUid()) {
                codedOutputStreamMicro.writeString(12, getUid());
            }
            if (hasRecReason()) {
                codedOutputStreamMicro.writeString(13, getRecReason());
            }
            if (hasScene()) {
                codedOutputStreamMicro.writeString(14, getScene());
            }
            if (hasDis()) {
                codedOutputStreamMicro.writeString(15, getDis());
            }
            if (hasFlagOnLeft()) {
                codedOutputStreamMicro.writeString(16, getFlagOnLeft());
            }
            if (hasPriceText()) {
                codedOutputStreamMicro.writeString(17, getPriceText());
            }
        }
    }

    public static BzList parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new BzList().mergeFrom(codedInputStreamMicro);
    }

    public static BzList parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (BzList) new BzList().mergeFrom(bArr);
    }

    public BzList addContent(Content content) {
        if (content != null) {
            if (this.f10471a.isEmpty()) {
                this.f10471a = new ArrayList();
            }
            this.f10471a.add(content);
        }
        return this;
    }

    public final BzList clear() {
        clearContent();
        clearC();
        clearCater();
        clearCircleName();
        clearCircleNameRecommend();
        clearPx();
        clearPy();
        clearError();
        clearMore();
        clearIndustry();
        clearTotalCount();
        this.f10492v = -1;
        return this;
    }

    public BzList clearC() {
        this.f10472b = false;
        this.f10473c = "";
        return this;
    }

    public BzList clearCater() {
        this.f10474d = false;
        this.f10475e = "";
        return this;
    }

    public BzList clearCircleName() {
        this.f10476f = false;
        this.f10477g = "";
        return this;
    }

    public BzList clearCircleNameRecommend() {
        this.f10478h = false;
        this.f10479i = "";
        return this;
    }

    public BzList clearContent() {
        this.f10471a = Collections.emptyList();
        return this;
    }

    public BzList clearError() {
        this.f10484n = false;
        this.f10485o = 0;
        return this;
    }

    public BzList clearIndustry() {
        this.f10488r = false;
        this.f10489s = "";
        return this;
    }

    public BzList clearMore() {
        this.f10486p = false;
        this.f10487q = 0;
        return this;
    }

    public BzList clearPx() {
        this.f10480j = false;
        this.f10481k = "";
        return this;
    }

    public BzList clearPy() {
        this.f10482l = false;
        this.f10483m = "";
        return this;
    }

    public BzList clearTotalCount() {
        this.f10490t = false;
        this.f10491u = 0;
        return this;
    }

    public String getC() {
        return this.f10473c;
    }

    public int getCachedSize() {
        if (this.f10492v < 0) {
            getSerializedSize();
        }
        return this.f10492v;
    }

    public String getCater() {
        return this.f10475e;
    }

    public String getCircleName() {
        return this.f10477g;
    }

    public String getCircleNameRecommend() {
        return this.f10479i;
    }

    public Content getContent(int i) {
        return (Content) this.f10471a.get(i);
    }

    public int getContentCount() {
        return this.f10471a.size();
    }

    public List<Content> getContentList() {
        return this.f10471a;
    }

    public int getError() {
        return this.f10485o;
    }

    public String getIndustry() {
        return this.f10489s;
    }

    public int getMore() {
        return this.f10487q;
    }

    public String getPx() {
        return this.f10481k;
    }

    public String getPy() {
        return this.f10483m;
    }

    public int getSerializedSize() {
        int i = 0;
        for (Content computeMessageSize : getContentList()) {
            i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
        }
        if (hasC()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getC());
        }
        if (hasCater()) {
            i += CodedOutputStreamMicro.computeStringSize(3, getCater());
        }
        if (hasCircleName()) {
            i += CodedOutputStreamMicro.computeStringSize(4, getCircleName());
        }
        if (hasCircleNameRecommend()) {
            i += CodedOutputStreamMicro.computeStringSize(5, getCircleNameRecommend());
        }
        if (hasPx()) {
            i += CodedOutputStreamMicro.computeStringSize(6, getPx());
        }
        if (hasPy()) {
            i += CodedOutputStreamMicro.computeStringSize(7, getPy());
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
        if (hasTotalCount()) {
            i += CodedOutputStreamMicro.computeInt32Size(12, getTotalCount());
        }
        this.f10492v = i;
        return i;
    }

    public int getTotalCount() {
        return this.f10491u;
    }

    public boolean hasC() {
        return this.f10472b;
    }

    public boolean hasCater() {
        return this.f10474d;
    }

    public boolean hasCircleName() {
        return this.f10476f;
    }

    public boolean hasCircleNameRecommend() {
        return this.f10478h;
    }

    public boolean hasError() {
        return this.f10484n;
    }

    public boolean hasIndustry() {
        return this.f10488r;
    }

    public boolean hasMore() {
        return this.f10486p;
    }

    public boolean hasPx() {
        return this.f10480j;
    }

    public boolean hasPy() {
        return this.f10482l;
    }

    public boolean hasTotalCount() {
        return this.f10490t;
    }

    public final boolean isInitialized() {
        return true;
    }

    public BzList mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                case 18:
                    setC(codedInputStreamMicro.readString());
                    continue;
                case 26:
                    setCater(codedInputStreamMicro.readString());
                    continue;
                case 34:
                    setCircleName(codedInputStreamMicro.readString());
                    continue;
                case 42:
                    setCircleNameRecommend(codedInputStreamMicro.readString());
                    continue;
                case 50:
                    setPx(codedInputStreamMicro.readString());
                    continue;
                case 58:
                    setPy(codedInputStreamMicro.readString());
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
                case 96:
                    setTotalCount(codedInputStreamMicro.readInt32());
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

    public BzList setC(String str) {
        this.f10472b = true;
        this.f10473c = str;
        return this;
    }

    public BzList setCater(String str) {
        this.f10474d = true;
        this.f10475e = str;
        return this;
    }

    public BzList setCircleName(String str) {
        this.f10476f = true;
        this.f10477g = str;
        return this;
    }

    public BzList setCircleNameRecommend(String str) {
        this.f10478h = true;
        this.f10479i = str;
        return this;
    }

    public BzList setContent(int i, Content content) {
        if (content != null) {
            this.f10471a.set(i, content);
        }
        return this;
    }

    public BzList setError(int i) {
        this.f10484n = true;
        this.f10485o = i;
        return this;
    }

    public BzList setIndustry(String str) {
        this.f10488r = true;
        this.f10489s = str;
        return this;
    }

    public BzList setMore(int i) {
        this.f10486p = true;
        this.f10487q = i;
        return this;
    }

    public BzList setPx(String str) {
        this.f10480j = true;
        this.f10481k = str;
        return this;
    }

    public BzList setPy(String str) {
        this.f10482l = true;
        this.f10483m = str;
        return this;
    }

    public BzList setTotalCount(int i) {
        this.f10490t = true;
        this.f10491u = i;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (Content writeMessage : getContentList()) {
            codedOutputStreamMicro.writeMessage(1, writeMessage);
        }
        if (hasC()) {
            codedOutputStreamMicro.writeString(2, getC());
        }
        if (hasCater()) {
            codedOutputStreamMicro.writeString(3, getCater());
        }
        if (hasCircleName()) {
            codedOutputStreamMicro.writeString(4, getCircleName());
        }
        if (hasCircleNameRecommend()) {
            codedOutputStreamMicro.writeString(5, getCircleNameRecommend());
        }
        if (hasPx()) {
            codedOutputStreamMicro.writeString(6, getPx());
        }
        if (hasPy()) {
            codedOutputStreamMicro.writeString(7, getPy());
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
        if (hasTotalCount()) {
            codedOutputStreamMicro.writeInt32(12, getTotalCount());
        }
    }
}
