package com.baidu.entity.pb;

import com.baidu.carlife.core.C1253f;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class GeneralRecommend extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 1;
    public static final int COUNT_FIELD_NUMBER = 3;
    public static final int ERROR_FIELD_NUMBER = 4;
    public static final int INDUSTRY_FIELD_NUMBER = 2;
    public static final int LBS_FORWARD_FIELD_NUMBER = 6;
    public static final int MORE_FIELD_NUMBER = 5;
    /* renamed from: a */
    private List<Content> f11213a = Collections.emptyList();
    /* renamed from: b */
    private boolean f11214b;
    /* renamed from: c */
    private String f11215c = "";
    /* renamed from: d */
    private boolean f11216d;
    /* renamed from: e */
    private int f11217e = 0;
    /* renamed from: f */
    private boolean f11218f;
    /* renamed from: g */
    private int f11219g = 0;
    /* renamed from: h */
    private boolean f11220h;
    /* renamed from: i */
    private int f11221i = 0;
    /* renamed from: j */
    private boolean f11222j;
    /* renamed from: k */
    private String f11223k = "";
    /* renamed from: l */
    private int f11224l = -1;

    public static final class Content extends MessageMicro {
        public static final int ADDRESS_FIELD_NUMBER = 4;
        public static final int CITY_FIELD_NUMBER = 5;
        public static final int COMMENT_FIELD_NUMBER = 6;
        public static final int DESCRIPTION_FIELD_NUMBER = 18;
        public static final int DISTANCE_FIELD_NUMBER = 14;
        public static final int OVERALL_RATING_FIELD_NUMBER = 11;
        public static final int PIC_URL_FIELD_NUMBER = 2;
        public static final int POI_INDUSTRY_FIELD_NUMBER = 19;
        public static final int PRICE_FIELD_NUMBER = 10;
        public static final int PX_FIELD_NUMBER = 15;
        public static final int PY_FIELD_NUMBER = 16;
        public static final int REC_REASON_FIELD_NUMBER = 7;
        public static final int SCENE_FIELD_NUMBER = 20;
        public static final int SQ_FIELD_NUMBER = 17;
        public static final int STATE_FIELD_NUMBER = 13;
        public static final int STD_TAG_FIELD_NUMBER = 8;
        public static final int TELEPHONE_FIELD_NUMBER = 3;
        public static final int TITLE_FIELD_NUMBER = 1;
        public static final int UID_FIELD_NUMBER = 12;
        public static final int WEIGHTED_TAG_FIELD_NUMBER = 9;
        /* renamed from: A */
        private boolean f11172A;
        /* renamed from: B */
        private int f11173B = 0;
        /* renamed from: C */
        private boolean f11174C;
        /* renamed from: D */
        private String f11175D = "";
        /* renamed from: E */
        private boolean f11176E;
        /* renamed from: F */
        private String f11177F = "";
        /* renamed from: G */
        private boolean f11178G;
        /* renamed from: H */
        private String f11179H = "";
        /* renamed from: I */
        private boolean f11180I;
        /* renamed from: J */
        private String f11181J = "";
        /* renamed from: K */
        private boolean f11182K;
        /* renamed from: L */
        private String f11183L = "";
        /* renamed from: M */
        private boolean f11184M;
        /* renamed from: N */
        private String f11185N = "";
        /* renamed from: O */
        private int f11186O = -1;
        /* renamed from: a */
        private boolean f11187a;
        /* renamed from: b */
        private String f11188b = "";
        /* renamed from: c */
        private boolean f11189c;
        /* renamed from: d */
        private String f11190d = "";
        /* renamed from: e */
        private boolean f11191e;
        /* renamed from: f */
        private String f11192f = "";
        /* renamed from: g */
        private boolean f11193g;
        /* renamed from: h */
        private String f11194h = "";
        /* renamed from: i */
        private boolean f11195i;
        /* renamed from: j */
        private String f11196j = "";
        /* renamed from: k */
        private boolean f11197k;
        /* renamed from: l */
        private String f11198l = "";
        /* renamed from: m */
        private boolean f11199m;
        /* renamed from: n */
        private String f11200n = "";
        /* renamed from: o */
        private boolean f11201o;
        /* renamed from: p */
        private String f11202p = "";
        /* renamed from: q */
        private boolean f11203q;
        /* renamed from: r */
        private String f11204r = "";
        /* renamed from: s */
        private boolean f11205s;
        /* renamed from: t */
        private String f11206t = "";
        /* renamed from: u */
        private boolean f11207u;
        /* renamed from: v */
        private String f11208v = "";
        /* renamed from: w */
        private boolean f11209w;
        /* renamed from: x */
        private String f11210x = "";
        /* renamed from: y */
        private boolean f11211y;
        /* renamed from: z */
        private String f11212z = "";

        public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Content().mergeFrom(codedInputStreamMicro);
        }

        public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Content) new Content().mergeFrom(bArr);
        }

        public final Content clear() {
            clearTitle();
            clearPicUrl();
            clearTelephone();
            clearAddress();
            clearCity();
            clearComment();
            clearRecReason();
            clearStdTag();
            clearWeightedTag();
            clearPrice();
            clearOverallRating();
            clearUid();
            clearState();
            clearDistance();
            clearPx();
            clearPy();
            clearSq();
            clearDescription();
            clearPoiIndustry();
            clearScene();
            this.f11186O = -1;
            return this;
        }

        public Content clearAddress() {
            this.f11193g = false;
            this.f11194h = "";
            return this;
        }

        public Content clearCity() {
            this.f11195i = false;
            this.f11196j = "";
            return this;
        }

        public Content clearComment() {
            this.f11197k = false;
            this.f11198l = "";
            return this;
        }

        public Content clearDescription() {
            this.f11180I = false;
            this.f11181J = "";
            return this;
        }

        public Content clearDistance() {
            this.f11172A = false;
            this.f11173B = 0;
            return this;
        }

        public Content clearOverallRating() {
            this.f11207u = false;
            this.f11208v = "";
            return this;
        }

        public Content clearPicUrl() {
            this.f11189c = false;
            this.f11190d = "";
            return this;
        }

        public Content clearPoiIndustry() {
            this.f11182K = false;
            this.f11183L = "";
            return this;
        }

        public Content clearPrice() {
            this.f11205s = false;
            this.f11206t = "";
            return this;
        }

        public Content clearPx() {
            this.f11174C = false;
            this.f11175D = "";
            return this;
        }

        public Content clearPy() {
            this.f11176E = false;
            this.f11177F = "";
            return this;
        }

        public Content clearRecReason() {
            this.f11199m = false;
            this.f11200n = "";
            return this;
        }

        public Content clearScene() {
            this.f11184M = false;
            this.f11185N = "";
            return this;
        }

        public Content clearSq() {
            this.f11178G = false;
            this.f11179H = "";
            return this;
        }

        public Content clearState() {
            this.f11211y = false;
            this.f11212z = "";
            return this;
        }

        public Content clearStdTag() {
            this.f11201o = false;
            this.f11202p = "";
            return this;
        }

        public Content clearTelephone() {
            this.f11191e = false;
            this.f11192f = "";
            return this;
        }

        public Content clearTitle() {
            this.f11187a = false;
            this.f11188b = "";
            return this;
        }

        public Content clearUid() {
            this.f11209w = false;
            this.f11210x = "";
            return this;
        }

        public Content clearWeightedTag() {
            this.f11203q = false;
            this.f11204r = "";
            return this;
        }

        public String getAddress() {
            return this.f11194h;
        }

        public int getCachedSize() {
            if (this.f11186O < 0) {
                getSerializedSize();
            }
            return this.f11186O;
        }

        public String getCity() {
            return this.f11196j;
        }

        public String getComment() {
            return this.f11198l;
        }

        public String getDescription() {
            return this.f11181J;
        }

        public int getDistance() {
            return this.f11173B;
        }

        public String getOverallRating() {
            return this.f11208v;
        }

        public String getPicUrl() {
            return this.f11190d;
        }

        public String getPoiIndustry() {
            return this.f11183L;
        }

        public String getPrice() {
            return this.f11206t;
        }

        public String getPx() {
            return this.f11175D;
        }

        public String getPy() {
            return this.f11177F;
        }

        public String getRecReason() {
            return this.f11200n;
        }

        public String getScene() {
            return this.f11185N;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTitle()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
            }
            if (hasPicUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getPicUrl());
            }
            if (hasTelephone()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getTelephone());
            }
            if (hasAddress()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getAddress());
            }
            if (hasCity()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getCity());
            }
            if (hasComment()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getComment());
            }
            if (hasRecReason()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getRecReason());
            }
            if (hasStdTag()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getStdTag());
            }
            if (hasWeightedTag()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getWeightedTag());
            }
            if (hasPrice()) {
                i += CodedOutputStreamMicro.computeStringSize(10, getPrice());
            }
            if (hasOverallRating()) {
                i += CodedOutputStreamMicro.computeStringSize(11, getOverallRating());
            }
            if (hasUid()) {
                i += CodedOutputStreamMicro.computeStringSize(12, getUid());
            }
            if (hasState()) {
                i += CodedOutputStreamMicro.computeStringSize(13, getState());
            }
            if (hasDistance()) {
                i += CodedOutputStreamMicro.computeInt32Size(14, getDistance());
            }
            if (hasPx()) {
                i += CodedOutputStreamMicro.computeStringSize(15, getPx());
            }
            if (hasPy()) {
                i += CodedOutputStreamMicro.computeStringSize(16, getPy());
            }
            if (hasSq()) {
                i += CodedOutputStreamMicro.computeStringSize(17, getSq());
            }
            if (hasDescription()) {
                i += CodedOutputStreamMicro.computeStringSize(18, getDescription());
            }
            if (hasPoiIndustry()) {
                i += CodedOutputStreamMicro.computeStringSize(19, getPoiIndustry());
            }
            if (hasScene()) {
                i += CodedOutputStreamMicro.computeStringSize(20, getScene());
            }
            this.f11186O = i;
            return i;
        }

        public String getSq() {
            return this.f11179H;
        }

        public String getState() {
            return this.f11212z;
        }

        public String getStdTag() {
            return this.f11202p;
        }

        public String getTelephone() {
            return this.f11192f;
        }

        public String getTitle() {
            return this.f11188b;
        }

        public String getUid() {
            return this.f11210x;
        }

        public String getWeightedTag() {
            return this.f11204r;
        }

        public boolean hasAddress() {
            return this.f11193g;
        }

        public boolean hasCity() {
            return this.f11195i;
        }

        public boolean hasComment() {
            return this.f11197k;
        }

        public boolean hasDescription() {
            return this.f11180I;
        }

        public boolean hasDistance() {
            return this.f11172A;
        }

        public boolean hasOverallRating() {
            return this.f11207u;
        }

        public boolean hasPicUrl() {
            return this.f11189c;
        }

        public boolean hasPoiIndustry() {
            return this.f11182K;
        }

        public boolean hasPrice() {
            return this.f11205s;
        }

        public boolean hasPx() {
            return this.f11174C;
        }

        public boolean hasPy() {
            return this.f11176E;
        }

        public boolean hasRecReason() {
            return this.f11199m;
        }

        public boolean hasScene() {
            return this.f11184M;
        }

        public boolean hasSq() {
            return this.f11178G;
        }

        public boolean hasState() {
            return this.f11211y;
        }

        public boolean hasStdTag() {
            return this.f11201o;
        }

        public boolean hasTelephone() {
            return this.f11191e;
        }

        public boolean hasTitle() {
            return this.f11187a;
        }

        public boolean hasUid() {
            return this.f11209w;
        }

        public boolean hasWeightedTag() {
            return this.f11203q;
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
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setPicUrl(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setTelephone(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setAddress(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setCity(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setComment(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setRecReason(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setStdTag(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setWeightedTag(codedInputStreamMicro.readString());
                        continue;
                    case 82:
                        setPrice(codedInputStreamMicro.readString());
                        continue;
                    case 90:
                        setOverallRating(codedInputStreamMicro.readString());
                        continue;
                    case 98:
                        setUid(codedInputStreamMicro.readString());
                        continue;
                    case 106:
                        setState(codedInputStreamMicro.readString());
                        continue;
                    case 112:
                        setDistance(codedInputStreamMicro.readInt32());
                        continue;
                    case C1253f.df /*122*/:
                        setPx(codedInputStreamMicro.readString());
                        continue;
                    case 130:
                        setPy(codedInputStreamMicro.readString());
                        continue;
                    case 138:
                        setSq(codedInputStreamMicro.readString());
                        continue;
                    case 146:
                        setDescription(codedInputStreamMicro.readString());
                        continue;
                    case 154:
                        setPoiIndustry(codedInputStreamMicro.readString());
                        continue;
                    case 162:
                        setScene(codedInputStreamMicro.readString());
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

        public Content setAddress(String str) {
            this.f11193g = true;
            this.f11194h = str;
            return this;
        }

        public Content setCity(String str) {
            this.f11195i = true;
            this.f11196j = str;
            return this;
        }

        public Content setComment(String str) {
            this.f11197k = true;
            this.f11198l = str;
            return this;
        }

        public Content setDescription(String str) {
            this.f11180I = true;
            this.f11181J = str;
            return this;
        }

        public Content setDistance(int i) {
            this.f11172A = true;
            this.f11173B = i;
            return this;
        }

        public Content setOverallRating(String str) {
            this.f11207u = true;
            this.f11208v = str;
            return this;
        }

        public Content setPicUrl(String str) {
            this.f11189c = true;
            this.f11190d = str;
            return this;
        }

        public Content setPoiIndustry(String str) {
            this.f11182K = true;
            this.f11183L = str;
            return this;
        }

        public Content setPrice(String str) {
            this.f11205s = true;
            this.f11206t = str;
            return this;
        }

        public Content setPx(String str) {
            this.f11174C = true;
            this.f11175D = str;
            return this;
        }

        public Content setPy(String str) {
            this.f11176E = true;
            this.f11177F = str;
            return this;
        }

        public Content setRecReason(String str) {
            this.f11199m = true;
            this.f11200n = str;
            return this;
        }

        public Content setScene(String str) {
            this.f11184M = true;
            this.f11185N = str;
            return this;
        }

        public Content setSq(String str) {
            this.f11178G = true;
            this.f11179H = str;
            return this;
        }

        public Content setState(String str) {
            this.f11211y = true;
            this.f11212z = str;
            return this;
        }

        public Content setStdTag(String str) {
            this.f11201o = true;
            this.f11202p = str;
            return this;
        }

        public Content setTelephone(String str) {
            this.f11191e = true;
            this.f11192f = str;
            return this;
        }

        public Content setTitle(String str) {
            this.f11187a = true;
            this.f11188b = str;
            return this;
        }

        public Content setUid(String str) {
            this.f11209w = true;
            this.f11210x = str;
            return this;
        }

        public Content setWeightedTag(String str) {
            this.f11203q = true;
            this.f11204r = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(1, getTitle());
            }
            if (hasPicUrl()) {
                codedOutputStreamMicro.writeString(2, getPicUrl());
            }
            if (hasTelephone()) {
                codedOutputStreamMicro.writeString(3, getTelephone());
            }
            if (hasAddress()) {
                codedOutputStreamMicro.writeString(4, getAddress());
            }
            if (hasCity()) {
                codedOutputStreamMicro.writeString(5, getCity());
            }
            if (hasComment()) {
                codedOutputStreamMicro.writeString(6, getComment());
            }
            if (hasRecReason()) {
                codedOutputStreamMicro.writeString(7, getRecReason());
            }
            if (hasStdTag()) {
                codedOutputStreamMicro.writeString(8, getStdTag());
            }
            if (hasWeightedTag()) {
                codedOutputStreamMicro.writeString(9, getWeightedTag());
            }
            if (hasPrice()) {
                codedOutputStreamMicro.writeString(10, getPrice());
            }
            if (hasOverallRating()) {
                codedOutputStreamMicro.writeString(11, getOverallRating());
            }
            if (hasUid()) {
                codedOutputStreamMicro.writeString(12, getUid());
            }
            if (hasState()) {
                codedOutputStreamMicro.writeString(13, getState());
            }
            if (hasDistance()) {
                codedOutputStreamMicro.writeInt32(14, getDistance());
            }
            if (hasPx()) {
                codedOutputStreamMicro.writeString(15, getPx());
            }
            if (hasPy()) {
                codedOutputStreamMicro.writeString(16, getPy());
            }
            if (hasSq()) {
                codedOutputStreamMicro.writeString(17, getSq());
            }
            if (hasDescription()) {
                codedOutputStreamMicro.writeString(18, getDescription());
            }
            if (hasPoiIndustry()) {
                codedOutputStreamMicro.writeString(19, getPoiIndustry());
            }
            if (hasScene()) {
                codedOutputStreamMicro.writeString(20, getScene());
            }
        }
    }

    public static GeneralRecommend parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new GeneralRecommend().mergeFrom(codedInputStreamMicro);
    }

    public static GeneralRecommend parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (GeneralRecommend) new GeneralRecommend().mergeFrom(bArr);
    }

    public GeneralRecommend addContent(Content content) {
        if (content != null) {
            if (this.f11213a.isEmpty()) {
                this.f11213a = new ArrayList();
            }
            this.f11213a.add(content);
        }
        return this;
    }

    public final GeneralRecommend clear() {
        clearContent();
        clearIndustry();
        clearCount();
        clearError();
        clearMore();
        clearLbsForward();
        this.f11224l = -1;
        return this;
    }

    public GeneralRecommend clearContent() {
        this.f11213a = Collections.emptyList();
        return this;
    }

    public GeneralRecommend clearCount() {
        this.f11216d = false;
        this.f11217e = 0;
        return this;
    }

    public GeneralRecommend clearError() {
        this.f11218f = false;
        this.f11219g = 0;
        return this;
    }

    public GeneralRecommend clearIndustry() {
        this.f11214b = false;
        this.f11215c = "";
        return this;
    }

    public GeneralRecommend clearLbsForward() {
        this.f11222j = false;
        this.f11223k = "";
        return this;
    }

    public GeneralRecommend clearMore() {
        this.f11220h = false;
        this.f11221i = 0;
        return this;
    }

    public int getCachedSize() {
        if (this.f11224l < 0) {
            getSerializedSize();
        }
        return this.f11224l;
    }

    public Content getContent(int i) {
        return (Content) this.f11213a.get(i);
    }

    public int getContentCount() {
        return this.f11213a.size();
    }

    public List<Content> getContentList() {
        return this.f11213a;
    }

    public int getCount() {
        return this.f11217e;
    }

    public int getError() {
        return this.f11219g;
    }

    public String getIndustry() {
        return this.f11215c;
    }

    public String getLbsForward() {
        return this.f11223k;
    }

    public int getMore() {
        return this.f11221i;
    }

    public int getSerializedSize() {
        int i = 0;
        for (Content computeMessageSize : getContentList()) {
            i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
        }
        if (hasIndustry()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getIndustry());
        }
        if (hasCount()) {
            i += CodedOutputStreamMicro.computeInt32Size(3, getCount());
        }
        if (hasError()) {
            i += CodedOutputStreamMicro.computeInt32Size(4, getError());
        }
        if (hasMore()) {
            i += CodedOutputStreamMicro.computeInt32Size(5, getMore());
        }
        if (hasLbsForward()) {
            i += CodedOutputStreamMicro.computeStringSize(6, getLbsForward());
        }
        this.f11224l = i;
        return i;
    }

    public boolean hasCount() {
        return this.f11216d;
    }

    public boolean hasError() {
        return this.f11218f;
    }

    public boolean hasIndustry() {
        return this.f11214b;
    }

    public boolean hasLbsForward() {
        return this.f11222j;
    }

    public boolean hasMore() {
        return this.f11220h;
    }

    public final boolean isInitialized() {
        return true;
    }

    public GeneralRecommend mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                    setIndustry(codedInputStreamMicro.readString());
                    continue;
                case 24:
                    setCount(codedInputStreamMicro.readInt32());
                    continue;
                case 32:
                    setError(codedInputStreamMicro.readInt32());
                    continue;
                case 40:
                    setMore(codedInputStreamMicro.readInt32());
                    continue;
                case 50:
                    setLbsForward(codedInputStreamMicro.readString());
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

    public GeneralRecommend setContent(int i, Content content) {
        if (content != null) {
            this.f11213a.set(i, content);
        }
        return this;
    }

    public GeneralRecommend setCount(int i) {
        this.f11216d = true;
        this.f11217e = i;
        return this;
    }

    public GeneralRecommend setError(int i) {
        this.f11218f = true;
        this.f11219g = i;
        return this;
    }

    public GeneralRecommend setIndustry(String str) {
        this.f11214b = true;
        this.f11215c = str;
        return this;
    }

    public GeneralRecommend setLbsForward(String str) {
        this.f11222j = true;
        this.f11223k = str;
        return this;
    }

    public GeneralRecommend setMore(int i) {
        this.f11220h = true;
        this.f11221i = i;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (Content writeMessage : getContentList()) {
            codedOutputStreamMicro.writeMessage(1, writeMessage);
        }
        if (hasIndustry()) {
            codedOutputStreamMicro.writeString(2, getIndustry());
        }
        if (hasCount()) {
            codedOutputStreamMicro.writeInt32(3, getCount());
        }
        if (hasError()) {
            codedOutputStreamMicro.writeInt32(4, getError());
        }
        if (hasMore()) {
            codedOutputStreamMicro.writeInt32(5, getMore());
        }
        if (hasLbsForward()) {
            codedOutputStreamMicro.writeString(6, getLbsForward());
        }
    }
}
