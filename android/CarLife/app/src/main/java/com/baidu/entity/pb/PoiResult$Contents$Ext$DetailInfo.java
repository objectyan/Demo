package com.baidu.entity.pb;

import com.baidu.baidunavis.model.NavCarInfo;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PoiResult$Contents$Ext$DetailInfo extends MessageMicro {
    public static final int ACTIVITY_FIELD_NUMBER = 23;
    public static final int ALLCARDEXTENSION_FIELD_NUMBER = 47;
    public static final int AOI_FIELD_NUMBER = 43;
    public static final int BOOK_INFO_FIELD_NUMBER = 18;
    public static final int BUSINESS_SERVICE_FIELD_NUMBER = 37;
    public static final int COMMENT_NUM_FIELD_NUMBER = 11;
    public static final int DISCOUNT_FIELD_NUMBER = 21;
    public static final int DISCOUNT_TOTAL_FIELD_NUMBER = 8;
    public static final int DISPLAY_INFO_COMMENT_LABEL_FIELD_NUMBER = 41;
    public static final int DISPLAY_INFO_REDU_FIELD_NUMBER = 40;
    public static final int DIS_TEXT_FIELD_NUMBER = 33;
    public static final int FLAG_FIELD_NUMBER = 1;
    public static final int FLAG_ON_LEFT_FIELD_NUMBER = 26;
    public static final int GRADE_FIELD_NUMBER = 22;
    public static final int GROUPON_FLAG_FIELD_NUMBER = 14;
    public static final int GROUPON_INFO_FIELD_NUMBER = 15;
    public static final int GROUPON_TOTAL_FIELD_NUMBER = 9;
    public static final int GUIDE_FIELD_NUMBER = 24;
    public static final int HOTEL_SERVICE_FIELD_NUMBER = 46;
    public static final int IMAGE_FIELD_NUMBER = 5;
    public static final int IMPRESSION_FIELD_NUMBER = 27;
    public static final int LBC_BUSINESS_VIP_FIELD_NUMBER = 34;
    public static final int MARKETBIZ_FIELD_NUMBER = 30;
    public static final int MBC_FIELD_NUMBER = 42;
    public static final int MEISHIPAIHAO_FIELD_NUMBER = 28;
    public static final int MOVIE_FILM_COUNT_FIELD_NUMBER = 13;
    public static final int MOVIE_FLAG_FIELD_NUMBER = 12;
    public static final int ORIGIN_PRICE_TEXT_FIELD_NUMBER = 45;
    public static final int ORIL_INFO_FIELD_NUMBER = 16;
    public static final int OVERALL_RATING_FIELD_NUMBER = 2;
    public static final int PREMIUM_FLAG_FIELD_NUMBER = 7;
    public static final int PREMIUM_INFO_FIELD_NUMBER = 10;
    public static final int PRICE_FIELD_NUMBER = 19;
    public static final int PRICE_TEXT_FIELD_NUMBER = 3;
    public static final int RECOMMEND_DISH_FIELD_NUMBER = 36;
    public static final int SHOP_HOURS_FIELD_NUMBER = 48;
    public static final int SHOW_INFO_FIELD_NUMBER = 6;
    public static final int SPECIAL_SERVICE_FIELD_NUMBER = 25;
    public static final int SPECIAL_TAG_FIELD_NUMBER = 44;
    public static final int STATUS_LABEL_FIELD_NUMBER = 38;
    public static final int TAG_FIELD_NUMBER = 4;
    public static final int TRADE_TAG_FIELD_NUMBER = 29;
    public static final int UPPERLEFTCORNER_FIELD_NUMBER = 39;
    public static final int VALIDATE_FIELD_NUMBER = 31;
    public static final int WAP_BOOKABLE_FIELD_NUMBER = 17;
    public static final int WISE_FULLROOM_FIELD_NUMBER = 20;
    public static final int WISE_HOURLY_BOOKABLE_FIELD_NUMBER = 32;
    /* renamed from: A */
    private boolean f13895A;
    /* renamed from: B */
    private String f13896B = "";
    /* renamed from: C */
    private boolean f13897C;
    /* renamed from: D */
    private String f13898D = "";
    /* renamed from: E */
    private boolean f13899E;
    /* renamed from: F */
    private int f13900F = 0;
    /* renamed from: G */
    private boolean f13901G;
    /* renamed from: H */
    private int f13902H = 0;
    /* renamed from: I */
    private boolean f13903I;
    /* renamed from: J */
    private String f13904J = "";
    /* renamed from: K */
    private boolean f13905K;
    /* renamed from: L */
    private String f13906L = "";
    /* renamed from: M */
    private boolean f13907M;
    /* renamed from: N */
    private String f13908N = "";
    /* renamed from: O */
    private boolean f13909O;
    /* renamed from: P */
    private String f13910P = "";
    /* renamed from: Q */
    private boolean f13911Q;
    /* renamed from: R */
    private String f13912R = "";
    /* renamed from: S */
    private boolean f13913S;
    /* renamed from: T */
    private String f13914T = "";
    /* renamed from: U */
    private boolean f13915U;
    /* renamed from: V */
    private String f13916V = "";
    /* renamed from: W */
    private boolean f13917W;
    /* renamed from: X */
    private String f13918X = "";
    /* renamed from: Y */
    private List<Impression> f13919Y = Collections.emptyList();
    /* renamed from: Z */
    private boolean f13920Z;
    /* renamed from: a */
    private boolean f13921a;
    private Mbc aA = null;
    private boolean aB;
    private String aC = "";
    private boolean aD;
    private String aE = "";
    private boolean aF;
    private String aG = "";
    private List<HotelService> aH = Collections.emptyList();
    private boolean aI;
    private Allcardextension aJ = null;
    private boolean aK;
    private String aL = "";
    private int aM = -1;
    private Meishipaihao aa = null;
    private boolean ab;
    private String ac = "";
    private boolean ad;
    private Marketbiz ae = null;
    private boolean af;
    private String ag = "";
    private boolean ah;
    private String ai = "";
    private boolean aj;
    private String ak = "";
    private boolean al;
    private LbcBusinessVip am = null;
    private boolean an;
    private RecommendDish ao = null;
    private boolean ap;
    private BusinessService aq = null;
    private boolean ar;
    private String as = "";
    private boolean at;
    private Upperleftcorner au = null;
    private boolean av;
    private String aw = "";
    private boolean ax;
    private DisplayInfoCommentLabel ay = null;
    private boolean az;
    /* renamed from: b */
    private PremiumInfo f13922b = null;
    /* renamed from: c */
    private boolean f13923c;
    /* renamed from: d */
    private GrouponInfo f13924d = null;
    /* renamed from: e */
    private boolean f13925e;
    /* renamed from: f */
    private OrilInfo f13926f = null;
    /* renamed from: g */
    private boolean f13927g;
    /* renamed from: h */
    private BookInfo f13928h = null;
    /* renamed from: i */
    private List<Activity> f13929i = Collections.emptyList();
    /* renamed from: j */
    private List<String> f13930j = Collections.emptyList();
    /* renamed from: k */
    private boolean f13931k;
    /* renamed from: l */
    private String f13932l = "";
    /* renamed from: m */
    private boolean f13933m;
    /* renamed from: n */
    private String f13934n = "";
    /* renamed from: o */
    private boolean f13935o;
    /* renamed from: p */
    private String f13936p = "";
    /* renamed from: q */
    private boolean f13937q;
    /* renamed from: r */
    private String f13938r = "";
    /* renamed from: s */
    private boolean f13939s;
    /* renamed from: t */
    private String f13940t = "";
    /* renamed from: u */
    private boolean f13941u;
    /* renamed from: v */
    private int f13942v = 0;
    /* renamed from: w */
    private boolean f13943w;
    /* renamed from: x */
    private int f13944x = 0;
    /* renamed from: y */
    private boolean f13945y;
    /* renamed from: z */
    private int f13946z = 0;

    /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Ext$DetailInfo$Activity */
    public static final class Activity extends MessageMicro {
        public static final int ACTIVITY_PRICE_FIELD_NUMBER = 9;
        public static final int BG_COLOR_FIELD_NUMBER = 4;
        public static final int COLOR_FIELD_NUMBER = 3;
        public static final int DESC_FIELD_NUMBER = 5;
        public static final int HREF_FIELD_NUMBER = 6;
        public static final int IMG_URL_FIELD_NUMBER = 7;
        public static final int LEVEL_FIELD_NUMBER = 1;
        public static final int ORIGIN_PRICE_FIELD_NUMBER = 8;
        public static final int TITLE_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f13742a;
        /* renamed from: b */
        private String f13743b = "";
        /* renamed from: c */
        private boolean f13744c;
        /* renamed from: d */
        private String f13745d = "";
        /* renamed from: e */
        private boolean f13746e;
        /* renamed from: f */
        private String f13747f = "";
        /* renamed from: g */
        private boolean f13748g;
        /* renamed from: h */
        private String f13749h = "";
        /* renamed from: i */
        private boolean f13750i;
        /* renamed from: j */
        private String f13751j = "";
        /* renamed from: k */
        private boolean f13752k;
        /* renamed from: l */
        private String f13753l = "";
        /* renamed from: m */
        private boolean f13754m;
        /* renamed from: n */
        private String f13755n = "";
        /* renamed from: o */
        private boolean f13756o;
        /* renamed from: p */
        private String f13757p = "";
        /* renamed from: q */
        private boolean f13758q;
        /* renamed from: r */
        private String f13759r = "";
        /* renamed from: s */
        private int f13760s = -1;

        public static Activity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Activity().mergeFrom(codedInputStreamMicro);
        }

        public static Activity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Activity) new Activity().mergeFrom(bArr);
        }

        public final Activity clear() {
            clearLevel();
            clearTitle();
            clearColor();
            clearBgColor();
            clearDesc();
            clearHref();
            clearImgUrl();
            clearOriginPrice();
            clearActivityPrice();
            this.f13760s = -1;
            return this;
        }

        public Activity clearActivityPrice() {
            this.f13758q = false;
            this.f13759r = "";
            return this;
        }

        public Activity clearBgColor() {
            this.f13748g = false;
            this.f13749h = "";
            return this;
        }

        public Activity clearColor() {
            this.f13746e = false;
            this.f13747f = "";
            return this;
        }

        public Activity clearDesc() {
            this.f13750i = false;
            this.f13751j = "";
            return this;
        }

        public Activity clearHref() {
            this.f13752k = false;
            this.f13753l = "";
            return this;
        }

        public Activity clearImgUrl() {
            this.f13754m = false;
            this.f13755n = "";
            return this;
        }

        public Activity clearLevel() {
            this.f13742a = false;
            this.f13743b = "";
            return this;
        }

        public Activity clearOriginPrice() {
            this.f13756o = false;
            this.f13757p = "";
            return this;
        }

        public Activity clearTitle() {
            this.f13744c = false;
            this.f13745d = "";
            return this;
        }

        public String getActivityPrice() {
            return this.f13759r;
        }

        public String getBgColor() {
            return this.f13749h;
        }

        public int getCachedSize() {
            if (this.f13760s < 0) {
                getSerializedSize();
            }
            return this.f13760s;
        }

        public String getColor() {
            return this.f13747f;
        }

        public String getDesc() {
            return this.f13751j;
        }

        public String getHref() {
            return this.f13753l;
        }

        public String getImgUrl() {
            return this.f13755n;
        }

        public String getLevel() {
            return this.f13743b;
        }

        public String getOriginPrice() {
            return this.f13757p;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasLevel()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getLevel());
            }
            if (hasTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getTitle());
            }
            if (hasColor()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getColor());
            }
            if (hasBgColor()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getBgColor());
            }
            if (hasDesc()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getDesc());
            }
            if (hasHref()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getHref());
            }
            if (hasImgUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getImgUrl());
            }
            if (hasOriginPrice()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getOriginPrice());
            }
            if (hasActivityPrice()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getActivityPrice());
            }
            this.f13760s = i;
            return i;
        }

        public String getTitle() {
            return this.f13745d;
        }

        public boolean hasActivityPrice() {
            return this.f13758q;
        }

        public boolean hasBgColor() {
            return this.f13748g;
        }

        public boolean hasColor() {
            return this.f13746e;
        }

        public boolean hasDesc() {
            return this.f13750i;
        }

        public boolean hasHref() {
            return this.f13752k;
        }

        public boolean hasImgUrl() {
            return this.f13754m;
        }

        public boolean hasLevel() {
            return this.f13742a;
        }

        public boolean hasOriginPrice() {
            return this.f13756o;
        }

        public boolean hasTitle() {
            return this.f13744c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Activity mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setLevel(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setColor(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setBgColor(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setDesc(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setHref(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setImgUrl(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setOriginPrice(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setActivityPrice(codedInputStreamMicro.readString());
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

        public Activity setActivityPrice(String str) {
            this.f13758q = true;
            this.f13759r = str;
            return this;
        }

        public Activity setBgColor(String str) {
            this.f13748g = true;
            this.f13749h = str;
            return this;
        }

        public Activity setColor(String str) {
            this.f13746e = true;
            this.f13747f = str;
            return this;
        }

        public Activity setDesc(String str) {
            this.f13750i = true;
            this.f13751j = str;
            return this;
        }

        public Activity setHref(String str) {
            this.f13752k = true;
            this.f13753l = str;
            return this;
        }

        public Activity setImgUrl(String str) {
            this.f13754m = true;
            this.f13755n = str;
            return this;
        }

        public Activity setLevel(String str) {
            this.f13742a = true;
            this.f13743b = str;
            return this;
        }

        public Activity setOriginPrice(String str) {
            this.f13756o = true;
            this.f13757p = str;
            return this;
        }

        public Activity setTitle(String str) {
            this.f13744c = true;
            this.f13745d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasLevel()) {
                codedOutputStreamMicro.writeString(1, getLevel());
            }
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(2, getTitle());
            }
            if (hasColor()) {
                codedOutputStreamMicro.writeString(3, getColor());
            }
            if (hasBgColor()) {
                codedOutputStreamMicro.writeString(4, getBgColor());
            }
            if (hasDesc()) {
                codedOutputStreamMicro.writeString(5, getDesc());
            }
            if (hasHref()) {
                codedOutputStreamMicro.writeString(6, getHref());
            }
            if (hasImgUrl()) {
                codedOutputStreamMicro.writeString(7, getImgUrl());
            }
            if (hasOriginPrice()) {
                codedOutputStreamMicro.writeString(8, getOriginPrice());
            }
            if (hasActivityPrice()) {
                codedOutputStreamMicro.writeString(9, getActivityPrice());
            }
        }
    }

    /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Ext$DetailInfo$Allcardextension */
    public static final class Allcardextension extends MessageMicro {
        public static final int IMAGE_URL_FIELD_NUMBER = 1;
        public static final int LANDING_URL_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f13761a;
        /* renamed from: b */
        private String f13762b = "";
        /* renamed from: c */
        private boolean f13763c;
        /* renamed from: d */
        private String f13764d = "";
        /* renamed from: e */
        private int f13765e = -1;

        public static Allcardextension parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Allcardextension().mergeFrom(codedInputStreamMicro);
        }

        public static Allcardextension parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Allcardextension) new Allcardextension().mergeFrom(bArr);
        }

        public final Allcardextension clear() {
            clearImageUrl();
            clearLandingUrl();
            this.f13765e = -1;
            return this;
        }

        public Allcardextension clearImageUrl() {
            this.f13761a = false;
            this.f13762b = "";
            return this;
        }

        public Allcardextension clearLandingUrl() {
            this.f13763c = false;
            this.f13764d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f13765e < 0) {
                getSerializedSize();
            }
            return this.f13765e;
        }

        public String getImageUrl() {
            return this.f13762b;
        }

        public String getLandingUrl() {
            return this.f13764d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasImageUrl()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getImageUrl());
            }
            if (hasLandingUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getLandingUrl());
            }
            this.f13765e = i;
            return i;
        }

        public boolean hasImageUrl() {
            return this.f13761a;
        }

        public boolean hasLandingUrl() {
            return this.f13763c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Allcardextension mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setImageUrl(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setLandingUrl(codedInputStreamMicro.readString());
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

        public Allcardextension setImageUrl(String str) {
            this.f13761a = true;
            this.f13762b = str;
            return this;
        }

        public Allcardextension setLandingUrl(String str) {
            this.f13763c = true;
            this.f13764d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasImageUrl()) {
                codedOutputStreamMicro.writeString(1, getImageUrl());
            }
            if (hasLandingUrl()) {
                codedOutputStreamMicro.writeString(2, getLandingUrl());
            }
        }
    }

    /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Ext$DetailInfo$BookInfo */
    public static final class BookInfo extends MessageMicro {
        public static final int COMS_FIELD_NUMBER = 3;
        public static final int TEL_FIELD_NUMBER = 1;
        public static final int WEB_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f13783a;
        /* renamed from: b */
        private Tel f13784b = null;
        /* renamed from: c */
        private boolean f13785c;
        /* renamed from: d */
        private Web f13786d = null;
        /* renamed from: e */
        private boolean f13787e;
        /* renamed from: f */
        private Coms f13788f = null;
        /* renamed from: g */
        private int f13789g = -1;

        /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Ext$DetailInfo$BookInfo$Coms */
        public static final class Coms extends MessageMicro {
            public static final int CONTENT_FIELD_NUMBER = 1;
            public static final int TITLE_FIELD_NUMBER = 2;
            public static final int TYPE_FIELD_NUMBER = 3;
            /* renamed from: a */
            private boolean f13766a;
            /* renamed from: b */
            private String f13767b = "";
            /* renamed from: c */
            private boolean f13768c;
            /* renamed from: d */
            private String f13769d = "";
            /* renamed from: e */
            private boolean f13770e;
            /* renamed from: f */
            private String f13771f = "";
            /* renamed from: g */
            private int f13772g = -1;

            public static Coms parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Coms().mergeFrom(codedInputStreamMicro);
            }

            public static Coms parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Coms) new Coms().mergeFrom(bArr);
            }

            public final Coms clear() {
                clearContent();
                clearTitle();
                clearType();
                this.f13772g = -1;
                return this;
            }

            public Coms clearContent() {
                this.f13766a = false;
                this.f13767b = "";
                return this;
            }

            public Coms clearTitle() {
                this.f13768c = false;
                this.f13769d = "";
                return this;
            }

            public Coms clearType() {
                this.f13770e = false;
                this.f13771f = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f13772g < 0) {
                    getSerializedSize();
                }
                return this.f13772g;
            }

            public String getContent() {
                return this.f13767b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasContent()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getContent());
                }
                if (hasTitle()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getTitle());
                }
                if (hasType()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getType());
                }
                this.f13772g = i;
                return i;
            }

            public String getTitle() {
                return this.f13769d;
            }

            public String getType() {
                return this.f13771f;
            }

            public boolean hasContent() {
                return this.f13766a;
            }

            public boolean hasTitle() {
                return this.f13768c;
            }

            public boolean hasType() {
                return this.f13770e;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Coms mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setContent(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setTitle(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setType(codedInputStreamMicro.readString());
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

            public Coms setContent(String str) {
                this.f13766a = true;
                this.f13767b = str;
                return this;
            }

            public Coms setTitle(String str) {
                this.f13768c = true;
                this.f13769d = str;
                return this;
            }

            public Coms setType(String str) {
                this.f13770e = true;
                this.f13771f = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasContent()) {
                    codedOutputStreamMicro.writeString(1, getContent());
                }
                if (hasTitle()) {
                    codedOutputStreamMicro.writeString(2, getTitle());
                }
                if (hasType()) {
                    codedOutputStreamMicro.writeString(3, getType());
                }
            }
        }

        /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Ext$DetailInfo$BookInfo$Tel */
        public static final class Tel extends MessageMicro {
            public static final int CONTENT_FIELD_NUMBER = 2;
            public static final int TITLE_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f13773a;
            /* renamed from: b */
            private String f13774b = "";
            /* renamed from: c */
            private boolean f13775c;
            /* renamed from: d */
            private String f13776d = "";
            /* renamed from: e */
            private int f13777e = -1;

            public static Tel parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Tel().mergeFrom(codedInputStreamMicro);
            }

            public static Tel parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Tel) new Tel().mergeFrom(bArr);
            }

            public final Tel clear() {
                clearTitle();
                clearContent();
                this.f13777e = -1;
                return this;
            }

            public Tel clearContent() {
                this.f13775c = false;
                this.f13776d = "";
                return this;
            }

            public Tel clearTitle() {
                this.f13773a = false;
                this.f13774b = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f13777e < 0) {
                    getSerializedSize();
                }
                return this.f13777e;
            }

            public String getContent() {
                return this.f13776d;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasTitle()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
                }
                if (hasContent()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getContent());
                }
                this.f13777e = i;
                return i;
            }

            public String getTitle() {
                return this.f13774b;
            }

            public boolean hasContent() {
                return this.f13775c;
            }

            public boolean hasTitle() {
                return this.f13773a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Tel mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setTitle(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setContent(codedInputStreamMicro.readString());
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

            public Tel setContent(String str) {
                this.f13775c = true;
                this.f13776d = str;
                return this;
            }

            public Tel setTitle(String str) {
                this.f13773a = true;
                this.f13774b = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasTitle()) {
                    codedOutputStreamMicro.writeString(1, getTitle());
                }
                if (hasContent()) {
                    codedOutputStreamMicro.writeString(2, getContent());
                }
            }
        }

        /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Ext$DetailInfo$BookInfo$Web */
        public static final class Web extends MessageMicro {
            public static final int CONTENT_FIELD_NUMBER = 2;
            public static final int TITLE_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f13778a;
            /* renamed from: b */
            private String f13779b = "";
            /* renamed from: c */
            private boolean f13780c;
            /* renamed from: d */
            private String f13781d = "";
            /* renamed from: e */
            private int f13782e = -1;

            public static Web parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Web().mergeFrom(codedInputStreamMicro);
            }

            public static Web parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Web) new Web().mergeFrom(bArr);
            }

            public final Web clear() {
                clearTitle();
                clearContent();
                this.f13782e = -1;
                return this;
            }

            public Web clearContent() {
                this.f13780c = false;
                this.f13781d = "";
                return this;
            }

            public Web clearTitle() {
                this.f13778a = false;
                this.f13779b = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f13782e < 0) {
                    getSerializedSize();
                }
                return this.f13782e;
            }

            public String getContent() {
                return this.f13781d;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasTitle()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
                }
                if (hasContent()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getContent());
                }
                this.f13782e = i;
                return i;
            }

            public String getTitle() {
                return this.f13779b;
            }

            public boolean hasContent() {
                return this.f13780c;
            }

            public boolean hasTitle() {
                return this.f13778a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Web mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setTitle(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setContent(codedInputStreamMicro.readString());
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

            public Web setContent(String str) {
                this.f13780c = true;
                this.f13781d = str;
                return this;
            }

            public Web setTitle(String str) {
                this.f13778a = true;
                this.f13779b = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasTitle()) {
                    codedOutputStreamMicro.writeString(1, getTitle());
                }
                if (hasContent()) {
                    codedOutputStreamMicro.writeString(2, getContent());
                }
            }
        }

        public static BookInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new BookInfo().mergeFrom(codedInputStreamMicro);
        }

        public static BookInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (BookInfo) new BookInfo().mergeFrom(bArr);
        }

        public final BookInfo clear() {
            clearTel();
            clearWeb();
            clearComs();
            this.f13789g = -1;
            return this;
        }

        public BookInfo clearComs() {
            this.f13787e = false;
            this.f13788f = null;
            return this;
        }

        public BookInfo clearTel() {
            this.f13783a = false;
            this.f13784b = null;
            return this;
        }

        public BookInfo clearWeb() {
            this.f13785c = false;
            this.f13786d = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f13789g < 0) {
                getSerializedSize();
            }
            return this.f13789g;
        }

        public Coms getComs() {
            return this.f13788f;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTel()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getTel());
            }
            if (hasWeb()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getWeb());
            }
            if (hasComs()) {
                i += CodedOutputStreamMicro.computeMessageSize(3, getComs());
            }
            this.f13789g = i;
            return i;
        }

        public Tel getTel() {
            return this.f13784b;
        }

        public Web getWeb() {
            return this.f13786d;
        }

        public boolean hasComs() {
            return this.f13787e;
        }

        public boolean hasTel() {
            return this.f13783a;
        }

        public boolean hasWeb() {
            return this.f13785c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public BookInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro tel;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        tel = new Tel();
                        codedInputStreamMicro.readMessage(tel);
                        setTel(tel);
                        continue;
                    case 18:
                        tel = new Web();
                        codedInputStreamMicro.readMessage(tel);
                        setWeb(tel);
                        continue;
                    case 26:
                        tel = new Coms();
                        codedInputStreamMicro.readMessage(tel);
                        setComs(tel);
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

        public BookInfo setComs(Coms coms) {
            if (coms == null) {
                return clearComs();
            }
            this.f13787e = true;
            this.f13788f = coms;
            return this;
        }

        public BookInfo setTel(Tel tel) {
            if (tel == null) {
                return clearTel();
            }
            this.f13783a = true;
            this.f13784b = tel;
            return this;
        }

        public BookInfo setWeb(Web web) {
            if (web == null) {
                return clearWeb();
            }
            this.f13785c = true;
            this.f13786d = web;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTel()) {
                codedOutputStreamMicro.writeMessage(1, getTel());
            }
            if (hasWeb()) {
                codedOutputStreamMicro.writeMessage(2, getWeb());
            }
            if (hasComs()) {
                codedOutputStreamMicro.writeMessage(3, getComs());
            }
        }
    }

    /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Ext$DetailInfo$BusinessService */
    public static final class BusinessService extends MessageMicro {
        public static final int NUOMI_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f13793a;
        /* renamed from: b */
        private Nuomi f13794b = null;
        /* renamed from: c */
        private int f13795c = -1;

        /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Ext$DetailInfo$BusinessService$Nuomi */
        public static final class Nuomi extends MessageMicro {
            public static final int DAODIANFU_STATUS_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f13790a;
            /* renamed from: b */
            private int f13791b = 0;
            /* renamed from: c */
            private int f13792c = -1;

            public static Nuomi parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Nuomi().mergeFrom(codedInputStreamMicro);
            }

            public static Nuomi parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Nuomi) new Nuomi().mergeFrom(bArr);
            }

            public final Nuomi clear() {
                clearDaodianfuStatus();
                this.f13792c = -1;
                return this;
            }

            public Nuomi clearDaodianfuStatus() {
                this.f13790a = false;
                this.f13791b = 0;
                return this;
            }

            public int getCachedSize() {
                if (this.f13792c < 0) {
                    getSerializedSize();
                }
                return this.f13792c;
            }

            public int getDaodianfuStatus() {
                return this.f13791b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasDaodianfuStatus()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getDaodianfuStatus());
                }
                this.f13792c = i;
                return i;
            }

            public boolean hasDaodianfuStatus() {
                return this.f13790a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Nuomi mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            setDaodianfuStatus(codedInputStreamMicro.readInt32());
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

            public Nuomi setDaodianfuStatus(int i) {
                this.f13790a = true;
                this.f13791b = i;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasDaodianfuStatus()) {
                    codedOutputStreamMicro.writeInt32(1, getDaodianfuStatus());
                }
            }
        }

        public static BusinessService parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new BusinessService().mergeFrom(codedInputStreamMicro);
        }

        public static BusinessService parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (BusinessService) new BusinessService().mergeFrom(bArr);
        }

        public final BusinessService clear() {
            clearNuomi();
            this.f13795c = -1;
            return this;
        }

        public BusinessService clearNuomi() {
            this.f13793a = false;
            this.f13794b = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f13795c < 0) {
                getSerializedSize();
            }
            return this.f13795c;
        }

        public Nuomi getNuomi() {
            return this.f13794b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasNuomi()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getNuomi());
            }
            this.f13795c = i;
            return i;
        }

        public boolean hasNuomi() {
            return this.f13793a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public BusinessService mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        MessageMicro nuomi = new Nuomi();
                        codedInputStreamMicro.readMessage(nuomi);
                        setNuomi(nuomi);
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

        public BusinessService setNuomi(Nuomi nuomi) {
            if (nuomi == null) {
                return clearNuomi();
            }
            this.f13793a = true;
            this.f13794b = nuomi;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasNuomi()) {
                codedOutputStreamMicro.writeMessage(1, getNuomi());
            }
        }
    }

    /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Ext$DetailInfo$DisplayInfoCommentLabel */
    public static final class DisplayInfoCommentLabel extends MessageMicro {
        public static final int BEAUTY_FIELD_NUMBER = 5;
        public static final int CATER_FIELD_NUMBER = 3;
        public static final int COMMON_FIELD_NUMBER = 2;
        public static final int LIFE_FIELD_NUMBER = 1;
        public static final int SCOPE_FIELD_NUMBER = 4;
        /* renamed from: a */
        private boolean f13796a;
        /* renamed from: b */
        private String f13797b = "";
        /* renamed from: c */
        private boolean f13798c;
        /* renamed from: d */
        private String f13799d = "";
        /* renamed from: e */
        private boolean f13800e;
        /* renamed from: f */
        private String f13801f = "";
        /* renamed from: g */
        private boolean f13802g;
        /* renamed from: h */
        private String f13803h = "";
        /* renamed from: i */
        private boolean f13804i;
        /* renamed from: j */
        private String f13805j = "";
        /* renamed from: k */
        private int f13806k = -1;

        public static DisplayInfoCommentLabel parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new DisplayInfoCommentLabel().mergeFrom(codedInputStreamMicro);
        }

        public static DisplayInfoCommentLabel parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (DisplayInfoCommentLabel) new DisplayInfoCommentLabel().mergeFrom(bArr);
        }

        public final DisplayInfoCommentLabel clear() {
            clearLife();
            clearCommon();
            clearCater();
            clearScope();
            clearBeauty();
            this.f13806k = -1;
            return this;
        }

        public DisplayInfoCommentLabel clearBeauty() {
            this.f13804i = false;
            this.f13805j = "";
            return this;
        }

        public DisplayInfoCommentLabel clearCater() {
            this.f13800e = false;
            this.f13801f = "";
            return this;
        }

        public DisplayInfoCommentLabel clearCommon() {
            this.f13798c = false;
            this.f13799d = "";
            return this;
        }

        public DisplayInfoCommentLabel clearLife() {
            this.f13796a = false;
            this.f13797b = "";
            return this;
        }

        public DisplayInfoCommentLabel clearScope() {
            this.f13802g = false;
            this.f13803h = "";
            return this;
        }

        public String getBeauty() {
            return this.f13805j;
        }

        public int getCachedSize() {
            if (this.f13806k < 0) {
                getSerializedSize();
            }
            return this.f13806k;
        }

        public String getCater() {
            return this.f13801f;
        }

        public String getCommon() {
            return this.f13799d;
        }

        public String getLife() {
            return this.f13797b;
        }

        public String getScope() {
            return this.f13803h;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasLife()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getLife());
            }
            if (hasCommon()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getCommon());
            }
            if (hasCater()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getCater());
            }
            if (hasScope()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getScope());
            }
            if (hasBeauty()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getBeauty());
            }
            this.f13806k = i;
            return i;
        }

        public boolean hasBeauty() {
            return this.f13804i;
        }

        public boolean hasCater() {
            return this.f13800e;
        }

        public boolean hasCommon() {
            return this.f13798c;
        }

        public boolean hasLife() {
            return this.f13796a;
        }

        public boolean hasScope() {
            return this.f13802g;
        }

        public final boolean isInitialized() {
            return true;
        }

        public DisplayInfoCommentLabel mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setLife(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setCommon(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setCater(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setScope(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setBeauty(codedInputStreamMicro.readString());
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

        public DisplayInfoCommentLabel setBeauty(String str) {
            this.f13804i = true;
            this.f13805j = str;
            return this;
        }

        public DisplayInfoCommentLabel setCater(String str) {
            this.f13800e = true;
            this.f13801f = str;
            return this;
        }

        public DisplayInfoCommentLabel setCommon(String str) {
            this.f13798c = true;
            this.f13799d = str;
            return this;
        }

        public DisplayInfoCommentLabel setLife(String str) {
            this.f13796a = true;
            this.f13797b = str;
            return this;
        }

        public DisplayInfoCommentLabel setScope(String str) {
            this.f13802g = true;
            this.f13803h = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasLife()) {
                codedOutputStreamMicro.writeString(1, getLife());
            }
            if (hasCommon()) {
                codedOutputStreamMicro.writeString(2, getCommon());
            }
            if (hasCater()) {
                codedOutputStreamMicro.writeString(3, getCater());
            }
            if (hasScope()) {
                codedOutputStreamMicro.writeString(4, getScope());
            }
            if (hasBeauty()) {
                codedOutputStreamMicro.writeString(5, getBeauty());
            }
        }
    }

    /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Ext$DetailInfo$GrouponInfo */
    public static final class GrouponInfo extends MessageMicro {
        public static final int GROUPON_IMAGE_FIELD_NUMBER = 4;
        public static final int GROUPON_NUM_FIELD_NUMBER = 1;
        public static final int GROUPON_PRICE_FIELD_NUMBER = 2;
        public static final int GROUPON_RESERVATION_FIELD_NUMBER = 8;
        public static final int GROUPON_TITLE_FIELD_NUMBER = 3;
        public static final int GROUPON_URL_MOBILE_FIELD_NUMBER = 6;
        public static final int GROUPON_WEBAPP_URL_FIELD_NUMBER = 7;
        public static final int REGULAR_PRICE_FIELD_NUMBER = 5;
        /* renamed from: a */
        private boolean f13807a;
        /* renamed from: b */
        private String f13808b = "";
        /* renamed from: c */
        private boolean f13809c;
        /* renamed from: d */
        private String f13810d = "";
        /* renamed from: e */
        private boolean f13811e;
        /* renamed from: f */
        private String f13812f = "";
        /* renamed from: g */
        private boolean f13813g;
        /* renamed from: h */
        private String f13814h = "";
        /* renamed from: i */
        private boolean f13815i;
        /* renamed from: j */
        private String f13816j = "";
        /* renamed from: k */
        private boolean f13817k;
        /* renamed from: l */
        private String f13818l = "";
        /* renamed from: m */
        private boolean f13819m;
        /* renamed from: n */
        private String f13820n = "";
        /* renamed from: o */
        private boolean f13821o;
        /* renamed from: p */
        private String f13822p = "";
        /* renamed from: q */
        private int f13823q = -1;

        public static GrouponInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new GrouponInfo().mergeFrom(codedInputStreamMicro);
        }

        public static GrouponInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (GrouponInfo) new GrouponInfo().mergeFrom(bArr);
        }

        public final GrouponInfo clear() {
            clearGrouponNum();
            clearGrouponPrice();
            clearGrouponTitle();
            clearGrouponImage();
            clearRegularPrice();
            clearGrouponUrlMobile();
            clearGrouponWebappUrl();
            clearGrouponReservation();
            this.f13823q = -1;
            return this;
        }

        public GrouponInfo clearGrouponImage() {
            this.f13813g = false;
            this.f13814h = "";
            return this;
        }

        public GrouponInfo clearGrouponNum() {
            this.f13807a = false;
            this.f13808b = "";
            return this;
        }

        public GrouponInfo clearGrouponPrice() {
            this.f13809c = false;
            this.f13810d = "";
            return this;
        }

        public GrouponInfo clearGrouponReservation() {
            this.f13821o = false;
            this.f13822p = "";
            return this;
        }

        public GrouponInfo clearGrouponTitle() {
            this.f13811e = false;
            this.f13812f = "";
            return this;
        }

        public GrouponInfo clearGrouponUrlMobile() {
            this.f13817k = false;
            this.f13818l = "";
            return this;
        }

        public GrouponInfo clearGrouponWebappUrl() {
            this.f13819m = false;
            this.f13820n = "";
            return this;
        }

        public GrouponInfo clearRegularPrice() {
            this.f13815i = false;
            this.f13816j = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f13823q < 0) {
                getSerializedSize();
            }
            return this.f13823q;
        }

        public String getGrouponImage() {
            return this.f13814h;
        }

        public String getGrouponNum() {
            return this.f13808b;
        }

        public String getGrouponPrice() {
            return this.f13810d;
        }

        public String getGrouponReservation() {
            return this.f13822p;
        }

        public String getGrouponTitle() {
            return this.f13812f;
        }

        public String getGrouponUrlMobile() {
            return this.f13818l;
        }

        public String getGrouponWebappUrl() {
            return this.f13820n;
        }

        public String getRegularPrice() {
            return this.f13816j;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasGrouponNum()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getGrouponNum());
            }
            if (hasGrouponPrice()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getGrouponPrice());
            }
            if (hasGrouponTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getGrouponTitle());
            }
            if (hasGrouponImage()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getGrouponImage());
            }
            if (hasRegularPrice()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getRegularPrice());
            }
            if (hasGrouponUrlMobile()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getGrouponUrlMobile());
            }
            if (hasGrouponWebappUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getGrouponWebappUrl());
            }
            if (hasGrouponReservation()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getGrouponReservation());
            }
            this.f13823q = i;
            return i;
        }

        public boolean hasGrouponImage() {
            return this.f13813g;
        }

        public boolean hasGrouponNum() {
            return this.f13807a;
        }

        public boolean hasGrouponPrice() {
            return this.f13809c;
        }

        public boolean hasGrouponReservation() {
            return this.f13821o;
        }

        public boolean hasGrouponTitle() {
            return this.f13811e;
        }

        public boolean hasGrouponUrlMobile() {
            return this.f13817k;
        }

        public boolean hasGrouponWebappUrl() {
            return this.f13819m;
        }

        public boolean hasRegularPrice() {
            return this.f13815i;
        }

        public final boolean isInitialized() {
            return true;
        }

        public GrouponInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setGrouponNum(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setGrouponPrice(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setGrouponTitle(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setGrouponImage(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setRegularPrice(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setGrouponUrlMobile(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setGrouponWebappUrl(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setGrouponReservation(codedInputStreamMicro.readString());
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

        public GrouponInfo setGrouponImage(String str) {
            this.f13813g = true;
            this.f13814h = str;
            return this;
        }

        public GrouponInfo setGrouponNum(String str) {
            this.f13807a = true;
            this.f13808b = str;
            return this;
        }

        public GrouponInfo setGrouponPrice(String str) {
            this.f13809c = true;
            this.f13810d = str;
            return this;
        }

        public GrouponInfo setGrouponReservation(String str) {
            this.f13821o = true;
            this.f13822p = str;
            return this;
        }

        public GrouponInfo setGrouponTitle(String str) {
            this.f13811e = true;
            this.f13812f = str;
            return this;
        }

        public GrouponInfo setGrouponUrlMobile(String str) {
            this.f13817k = true;
            this.f13818l = str;
            return this;
        }

        public GrouponInfo setGrouponWebappUrl(String str) {
            this.f13819m = true;
            this.f13820n = str;
            return this;
        }

        public GrouponInfo setRegularPrice(String str) {
            this.f13815i = true;
            this.f13816j = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasGrouponNum()) {
                codedOutputStreamMicro.writeString(1, getGrouponNum());
            }
            if (hasGrouponPrice()) {
                codedOutputStreamMicro.writeString(2, getGrouponPrice());
            }
            if (hasGrouponTitle()) {
                codedOutputStreamMicro.writeString(3, getGrouponTitle());
            }
            if (hasGrouponImage()) {
                codedOutputStreamMicro.writeString(4, getGrouponImage());
            }
            if (hasRegularPrice()) {
                codedOutputStreamMicro.writeString(5, getRegularPrice());
            }
            if (hasGrouponUrlMobile()) {
                codedOutputStreamMicro.writeString(6, getGrouponUrlMobile());
            }
            if (hasGrouponWebappUrl()) {
                codedOutputStreamMicro.writeString(7, getGrouponWebappUrl());
            }
            if (hasGrouponReservation()) {
                codedOutputStreamMicro.writeString(8, getGrouponReservation());
            }
        }
    }

    /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Ext$DetailInfo$HotelService */
    public static final class HotelService extends MessageMicro {
        public static final int ICON_ID_FIELD_NUMBER = 1;
        public static final int NAME_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f13824a;
        /* renamed from: b */
        private String f13825b = "";
        /* renamed from: c */
        private boolean f13826c;
        /* renamed from: d */
        private String f13827d = "";
        /* renamed from: e */
        private int f13828e = -1;

        public static HotelService parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new HotelService().mergeFrom(codedInputStreamMicro);
        }

        public static HotelService parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (HotelService) new HotelService().mergeFrom(bArr);
        }

        public final HotelService clear() {
            clearIconId();
            clearName();
            this.f13828e = -1;
            return this;
        }

        public HotelService clearIconId() {
            this.f13824a = false;
            this.f13825b = "";
            return this;
        }

        public HotelService clearName() {
            this.f13826c = false;
            this.f13827d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f13828e < 0) {
                getSerializedSize();
            }
            return this.f13828e;
        }

        public String getIconId() {
            return this.f13825b;
        }

        public String getName() {
            return this.f13827d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasIconId()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getIconId());
            }
            if (hasName()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getName());
            }
            this.f13828e = i;
            return i;
        }

        public boolean hasIconId() {
            return this.f13824a;
        }

        public boolean hasName() {
            return this.f13826c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public HotelService mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setIconId(codedInputStreamMicro.readString());
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

        public HotelService setIconId(String str) {
            this.f13824a = true;
            this.f13825b = str;
            return this;
        }

        public HotelService setName(String str) {
            this.f13826c = true;
            this.f13827d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIconId()) {
                codedOutputStreamMicro.writeString(1, getIconId());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(2, getName());
            }
        }
    }

    /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Ext$DetailInfo$Impression */
    public static final class Impression extends MessageMicro {
        public static final int KEYWORD_FIELD_NUMBER = 1;
        public static final int NUM_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f13829a;
        /* renamed from: b */
        private String f13830b = "";
        /* renamed from: c */
        private boolean f13831c;
        /* renamed from: d */
        private int f13832d = 0;
        /* renamed from: e */
        private int f13833e = -1;

        public static Impression parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Impression().mergeFrom(codedInputStreamMicro);
        }

        public static Impression parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Impression) new Impression().mergeFrom(bArr);
        }

        public final Impression clear() {
            clearKeyword();
            clearNum();
            this.f13833e = -1;
            return this;
        }

        public Impression clearKeyword() {
            this.f13829a = false;
            this.f13830b = "";
            return this;
        }

        public Impression clearNum() {
            this.f13831c = false;
            this.f13832d = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f13833e < 0) {
                getSerializedSize();
            }
            return this.f13833e;
        }

        public String getKeyword() {
            return this.f13830b;
        }

        public int getNum() {
            return this.f13832d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasKeyword()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getKeyword());
            }
            if (hasNum()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getNum());
            }
            this.f13833e = i;
            return i;
        }

        public boolean hasKeyword() {
            return this.f13829a;
        }

        public boolean hasNum() {
            return this.f13831c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Impression mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setKeyword(codedInputStreamMicro.readString());
                        continue;
                    case 16:
                        setNum(codedInputStreamMicro.readInt32());
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

        public Impression setKeyword(String str) {
            this.f13829a = true;
            this.f13830b = str;
            return this;
        }

        public Impression setNum(int i) {
            this.f13831c = true;
            this.f13832d = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasKeyword()) {
                codedOutputStreamMicro.writeString(1, getKeyword());
            }
            if (hasNum()) {
                codedOutputStreamMicro.writeInt32(2, getNum());
            }
        }
    }

    /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Ext$DetailInfo$LbcBusinessVip */
    public static final class LbcBusinessVip extends MessageMicro {
        public static final int AMOUNT_FIELD_NUMBER = 3;
        public static final int COMMENT_FIELD_NUMBER = 2;
        public static final int LISTS_FIELD_NUMBER = 4;
        public static final int TYPE_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f13834a;
        /* renamed from: b */
        private int f13835b = 0;
        /* renamed from: c */
        private boolean f13836c;
        /* renamed from: d */
        private String f13837d = "";
        /* renamed from: e */
        private boolean f13838e;
        /* renamed from: f */
        private String f13839f = "";
        /* renamed from: g */
        private boolean f13840g;
        /* renamed from: h */
        private String f13841h = "";
        /* renamed from: i */
        private int f13842i = -1;

        public static LbcBusinessVip parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new LbcBusinessVip().mergeFrom(codedInputStreamMicro);
        }

        public static LbcBusinessVip parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (LbcBusinessVip) new LbcBusinessVip().mergeFrom(bArr);
        }

        public final LbcBusinessVip clear() {
            clearType();
            clearComment();
            clearAmount();
            clearLists();
            this.f13842i = -1;
            return this;
        }

        public LbcBusinessVip clearAmount() {
            this.f13838e = false;
            this.f13839f = "";
            return this;
        }

        public LbcBusinessVip clearComment() {
            this.f13836c = false;
            this.f13837d = "";
            return this;
        }

        public LbcBusinessVip clearLists() {
            this.f13840g = false;
            this.f13841h = "";
            return this;
        }

        public LbcBusinessVip clearType() {
            this.f13834a = false;
            this.f13835b = 0;
            return this;
        }

        public String getAmount() {
            return this.f13839f;
        }

        public int getCachedSize() {
            if (this.f13842i < 0) {
                getSerializedSize();
            }
            return this.f13842i;
        }

        public String getComment() {
            return this.f13837d;
        }

        public String getLists() {
            return this.f13841h;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasType()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getType());
            }
            if (hasComment()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getComment());
            }
            if (hasAmount()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getAmount());
            }
            if (hasLists()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getLists());
            }
            this.f13842i = i;
            return i;
        }

        public int getType() {
            return this.f13835b;
        }

        public boolean hasAmount() {
            return this.f13838e;
        }

        public boolean hasComment() {
            return this.f13836c;
        }

        public boolean hasLists() {
            return this.f13840g;
        }

        public boolean hasType() {
            return this.f13834a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public LbcBusinessVip mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setType(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setComment(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setAmount(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setLists(codedInputStreamMicro.readString());
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

        public LbcBusinessVip setAmount(String str) {
            this.f13838e = true;
            this.f13839f = str;
            return this;
        }

        public LbcBusinessVip setComment(String str) {
            this.f13836c = true;
            this.f13837d = str;
            return this;
        }

        public LbcBusinessVip setLists(String str) {
            this.f13840g = true;
            this.f13841h = str;
            return this;
        }

        public LbcBusinessVip setType(int i) {
            this.f13834a = true;
            this.f13835b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasType()) {
                codedOutputStreamMicro.writeInt32(1, getType());
            }
            if (hasComment()) {
                codedOutputStreamMicro.writeString(2, getComment());
            }
            if (hasAmount()) {
                codedOutputStreamMicro.writeString(3, getAmount());
            }
            if (hasLists()) {
                codedOutputStreamMicro.writeString(4, getLists());
            }
        }
    }

    /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Ext$DetailInfo$Marketbiz */
    public static final class Marketbiz extends MessageMicro {
        public static final int ACT_FIELD_NUMBER = 3;
        public static final int CONTENT_FIELD_NUMBER = 2;
        public static final int DTYPE_FIELD_NUMBER = 5;
        public static final int SRCNAME_FIELD_NUMBER = 1;
        public static final int STYPE_FIELD_NUMBER = 4;
        /* renamed from: a */
        private boolean f13843a;
        /* renamed from: b */
        private String f13844b = "";
        /* renamed from: c */
        private boolean f13845c;
        /* renamed from: d */
        private String f13846d = "";
        /* renamed from: e */
        private boolean f13847e;
        /* renamed from: f */
        private int f13848f = 0;
        /* renamed from: g */
        private boolean f13849g;
        /* renamed from: h */
        private int f13850h = 0;
        /* renamed from: i */
        private boolean f13851i;
        /* renamed from: j */
        private int f13852j = 0;
        /* renamed from: k */
        private int f13853k = -1;

        public static Marketbiz parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Marketbiz().mergeFrom(codedInputStreamMicro);
        }

        public static Marketbiz parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Marketbiz) new Marketbiz().mergeFrom(bArr);
        }

        public final Marketbiz clear() {
            clearSrcname();
            clearContent();
            clearAct();
            clearStype();
            clearDtype();
            this.f13853k = -1;
            return this;
        }

        public Marketbiz clearAct() {
            this.f13847e = false;
            this.f13848f = 0;
            return this;
        }

        public Marketbiz clearContent() {
            this.f13845c = false;
            this.f13846d = "";
            return this;
        }

        public Marketbiz clearDtype() {
            this.f13851i = false;
            this.f13852j = 0;
            return this;
        }

        public Marketbiz clearSrcname() {
            this.f13843a = false;
            this.f13844b = "";
            return this;
        }

        public Marketbiz clearStype() {
            this.f13849g = false;
            this.f13850h = 0;
            return this;
        }

        public int getAct() {
            return this.f13848f;
        }

        public int getCachedSize() {
            if (this.f13853k < 0) {
                getSerializedSize();
            }
            return this.f13853k;
        }

        public String getContent() {
            return this.f13846d;
        }

        public int getDtype() {
            return this.f13852j;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasSrcname()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getSrcname());
            }
            if (hasContent()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getContent());
            }
            if (hasAct()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getAct());
            }
            if (hasStype()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, getStype());
            }
            if (hasDtype()) {
                i += CodedOutputStreamMicro.computeInt32Size(5, getDtype());
            }
            this.f13853k = i;
            return i;
        }

        public String getSrcname() {
            return this.f13844b;
        }

        public int getStype() {
            return this.f13850h;
        }

        public boolean hasAct() {
            return this.f13847e;
        }

        public boolean hasContent() {
            return this.f13845c;
        }

        public boolean hasDtype() {
            return this.f13851i;
        }

        public boolean hasSrcname() {
            return this.f13843a;
        }

        public boolean hasStype() {
            return this.f13849g;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Marketbiz mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setSrcname(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setContent(codedInputStreamMicro.readString());
                        continue;
                    case 24:
                        setAct(codedInputStreamMicro.readInt32());
                        continue;
                    case 32:
                        setStype(codedInputStreamMicro.readInt32());
                        continue;
                    case 40:
                        setDtype(codedInputStreamMicro.readInt32());
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

        public Marketbiz setAct(int i) {
            this.f13847e = true;
            this.f13848f = i;
            return this;
        }

        public Marketbiz setContent(String str) {
            this.f13845c = true;
            this.f13846d = str;
            return this;
        }

        public Marketbiz setDtype(int i) {
            this.f13851i = true;
            this.f13852j = i;
            return this;
        }

        public Marketbiz setSrcname(String str) {
            this.f13843a = true;
            this.f13844b = str;
            return this;
        }

        public Marketbiz setStype(int i) {
            this.f13849g = true;
            this.f13850h = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasSrcname()) {
                codedOutputStreamMicro.writeString(1, getSrcname());
            }
            if (hasContent()) {
                codedOutputStreamMicro.writeString(2, getContent());
            }
            if (hasAct()) {
                codedOutputStreamMicro.writeInt32(3, getAct());
            }
            if (hasStype()) {
                codedOutputStreamMicro.writeInt32(4, getStype());
            }
            if (hasDtype()) {
                codedOutputStreamMicro.writeInt32(5, getDtype());
            }
        }
    }

    /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Ext$DetailInfo$Mbc */
    public static final class Mbc extends MessageMicro {
        public static final int MARKV_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f13854a;
        /* renamed from: b */
        private String f13855b = "";
        /* renamed from: c */
        private int f13856c = -1;

        public static Mbc parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Mbc().mergeFrom(codedInputStreamMicro);
        }

        public static Mbc parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Mbc) new Mbc().mergeFrom(bArr);
        }

        public final Mbc clear() {
            clearMarkv();
            this.f13856c = -1;
            return this;
        }

        public Mbc clearMarkv() {
            this.f13854a = false;
            this.f13855b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f13856c < 0) {
                getSerializedSize();
            }
            return this.f13856c;
        }

        public String getMarkv() {
            return this.f13855b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasMarkv()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getMarkv());
            }
            this.f13856c = i;
            return i;
        }

        public boolean hasMarkv() {
            return this.f13854a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Mbc mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setMarkv(codedInputStreamMicro.readString());
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

        public Mbc setMarkv(String str) {
            this.f13854a = true;
            this.f13855b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasMarkv()) {
                codedOutputStreamMicro.writeString(1, getMarkv());
            }
        }
    }

    /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Ext$DetailInfo$Meishipaihao */
    public static final class Meishipaihao extends MessageMicro {
        public static final int IS_OK_FIELD_NUMBER = 1;
        public static final int MAIN_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f13862a;
        /* renamed from: b */
        private int f13863b = 0;
        /* renamed from: c */
        private boolean f13864c;
        /* renamed from: d */
        private Main f13865d = null;
        /* renamed from: e */
        private int f13866e = -1;

        /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Ext$DetailInfo$Meishipaihao$Main */
        public static final class Main extends MessageMicro {
            public static final int THIRD_FROM_FIELD_NUMBER = 1;
            public static final int THIRD_ID_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f13857a;
            /* renamed from: b */
            private String f13858b = "";
            /* renamed from: c */
            private boolean f13859c;
            /* renamed from: d */
            private String f13860d = "";
            /* renamed from: e */
            private int f13861e = -1;

            public static Main parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Main().mergeFrom(codedInputStreamMicro);
            }

            public static Main parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Main) new Main().mergeFrom(bArr);
            }

            public final Main clear() {
                clearThirdFrom();
                clearThirdId();
                this.f13861e = -1;
                return this;
            }

            public Main clearThirdFrom() {
                this.f13857a = false;
                this.f13858b = "";
                return this;
            }

            public Main clearThirdId() {
                this.f13859c = false;
                this.f13860d = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f13861e < 0) {
                    getSerializedSize();
                }
                return this.f13861e;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasThirdFrom()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getThirdFrom());
                }
                if (hasThirdId()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getThirdId());
                }
                this.f13861e = i;
                return i;
            }

            public String getThirdFrom() {
                return this.f13858b;
            }

            public String getThirdId() {
                return this.f13860d;
            }

            public boolean hasThirdFrom() {
                return this.f13857a;
            }

            public boolean hasThirdId() {
                return this.f13859c;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Main mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setThirdFrom(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setThirdId(codedInputStreamMicro.readString());
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

            public Main setThirdFrom(String str) {
                this.f13857a = true;
                this.f13858b = str;
                return this;
            }

            public Main setThirdId(String str) {
                this.f13859c = true;
                this.f13860d = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasThirdFrom()) {
                    codedOutputStreamMicro.writeString(1, getThirdFrom());
                }
                if (hasThirdId()) {
                    codedOutputStreamMicro.writeString(2, getThirdId());
                }
            }
        }

        public static Meishipaihao parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Meishipaihao().mergeFrom(codedInputStreamMicro);
        }

        public static Meishipaihao parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Meishipaihao) new Meishipaihao().mergeFrom(bArr);
        }

        public final Meishipaihao clear() {
            clearIsOk();
            clearMain();
            this.f13866e = -1;
            return this;
        }

        public Meishipaihao clearIsOk() {
            this.f13862a = false;
            this.f13863b = 0;
            return this;
        }

        public Meishipaihao clearMain() {
            this.f13864c = false;
            this.f13865d = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f13866e < 0) {
                getSerializedSize();
            }
            return this.f13866e;
        }

        public int getIsOk() {
            return this.f13863b;
        }

        public Main getMain() {
            return this.f13865d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasIsOk()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIsOk());
            }
            if (hasMain()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getMain());
            }
            this.f13866e = i;
            return i;
        }

        public boolean hasIsOk() {
            return this.f13862a;
        }

        public boolean hasMain() {
            return this.f13864c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Meishipaihao mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setIsOk(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        MessageMicro main = new Main();
                        codedInputStreamMicro.readMessage(main);
                        setMain(main);
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

        public Meishipaihao setIsOk(int i) {
            this.f13862a = true;
            this.f13863b = i;
            return this;
        }

        public Meishipaihao setMain(Main main) {
            if (main == null) {
                return clearMain();
            }
            this.f13864c = true;
            this.f13865d = main;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIsOk()) {
                codedOutputStreamMicro.writeInt32(1, getIsOk());
            }
            if (hasMain()) {
                codedOutputStreamMicro.writeMessage(2, getMain());
            }
        }
    }

    /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Ext$DetailInfo$OrilInfo */
    public static final class OrilInfo extends MessageMicro {
        public static final int ORIL_DETAIL_FIELD_NUMBER = 1;
        /* renamed from: a */
        private List<OrilDetail> f13872a = Collections.emptyList();
        /* renamed from: b */
        private int f13873b = -1;

        /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Ext$DetailInfo$OrilInfo$OrilDetail */
        public static final class OrilDetail extends MessageMicro {
            public static final int ORIL_PRICE_FIELD_NUMBER = 1;
            public static final int ORIL_TYPE_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f13867a;
            /* renamed from: b */
            private String f13868b = "";
            /* renamed from: c */
            private boolean f13869c;
            /* renamed from: d */
            private String f13870d = "";
            /* renamed from: e */
            private int f13871e = -1;

            public static OrilDetail parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new OrilDetail().mergeFrom(codedInputStreamMicro);
            }

            public static OrilDetail parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (OrilDetail) new OrilDetail().mergeFrom(bArr);
            }

            public final OrilDetail clear() {
                clearOrilPrice();
                clearOrilType();
                this.f13871e = -1;
                return this;
            }

            public OrilDetail clearOrilPrice() {
                this.f13867a = false;
                this.f13868b = "";
                return this;
            }

            public OrilDetail clearOrilType() {
                this.f13869c = false;
                this.f13870d = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f13871e < 0) {
                    getSerializedSize();
                }
                return this.f13871e;
            }

            public String getOrilPrice() {
                return this.f13868b;
            }

            public String getOrilType() {
                return this.f13870d;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasOrilPrice()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getOrilPrice());
                }
                if (hasOrilType()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getOrilType());
                }
                this.f13871e = i;
                return i;
            }

            public boolean hasOrilPrice() {
                return this.f13867a;
            }

            public boolean hasOrilType() {
                return this.f13869c;
            }

            public final boolean isInitialized() {
                return true;
            }

            public OrilDetail mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setOrilPrice(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setOrilType(codedInputStreamMicro.readString());
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

            public OrilDetail setOrilPrice(String str) {
                this.f13867a = true;
                this.f13868b = str;
                return this;
            }

            public OrilDetail setOrilType(String str) {
                this.f13869c = true;
                this.f13870d = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasOrilPrice()) {
                    codedOutputStreamMicro.writeString(1, getOrilPrice());
                }
                if (hasOrilType()) {
                    codedOutputStreamMicro.writeString(2, getOrilType());
                }
            }
        }

        public static OrilInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new OrilInfo().mergeFrom(codedInputStreamMicro);
        }

        public static OrilInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (OrilInfo) new OrilInfo().mergeFrom(bArr);
        }

        public OrilInfo addOrilDetail(OrilDetail orilDetail) {
            if (orilDetail != null) {
                if (this.f13872a.isEmpty()) {
                    this.f13872a = new ArrayList();
                }
                this.f13872a.add(orilDetail);
            }
            return this;
        }

        public final OrilInfo clear() {
            clearOrilDetail();
            this.f13873b = -1;
            return this;
        }

        public OrilInfo clearOrilDetail() {
            this.f13872a = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f13873b < 0) {
                getSerializedSize();
            }
            return this.f13873b;
        }

        public OrilDetail getOrilDetail(int i) {
            return (OrilDetail) this.f13872a.get(i);
        }

        public int getOrilDetailCount() {
            return this.f13872a.size();
        }

        public List<OrilDetail> getOrilDetailList() {
            return this.f13872a;
        }

        public int getSerializedSize() {
            int i = 0;
            for (OrilDetail computeMessageSize : getOrilDetailList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            this.f13873b = i;
            return i;
        }

        public final boolean isInitialized() {
            return true;
        }

        public OrilInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        MessageMicro orilDetail = new OrilDetail();
                        codedInputStreamMicro.readMessage(orilDetail);
                        addOrilDetail(orilDetail);
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

        public OrilInfo setOrilDetail(int i, OrilDetail orilDetail) {
            if (orilDetail != null) {
                this.f13872a.set(i, orilDetail);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (OrilDetail writeMessage : getOrilDetailList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
        }
    }

    /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Ext$DetailInfo$PremiumInfo */
    public static final class PremiumInfo extends MessageMicro {
        public static final int DISCOUNT_CONTENT_FIELD_NUMBER = 1;
        public static final int DISCOUNT_DL_FIELD_NUMBER = 2;
        public static final int DISCOUNT_ID_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 4;
        /* renamed from: a */
        private boolean f13874a;
        /* renamed from: b */
        private String f13875b = "";
        /* renamed from: c */
        private boolean f13876c;
        /* renamed from: d */
        private String f13877d = "";
        /* renamed from: e */
        private boolean f13878e;
        /* renamed from: f */
        private String f13879f = "";
        /* renamed from: g */
        private boolean f13880g;
        /* renamed from: h */
        private String f13881h = "";
        /* renamed from: i */
        private int f13882i = -1;

        public static PremiumInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new PremiumInfo().mergeFrom(codedInputStreamMicro);
        }

        public static PremiumInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (PremiumInfo) new PremiumInfo().mergeFrom(bArr);
        }

        public final PremiumInfo clear() {
            clearDiscountContent();
            clearDiscountDl();
            clearDiscountId();
            clearName();
            this.f13882i = -1;
            return this;
        }

        public PremiumInfo clearDiscountContent() {
            this.f13874a = false;
            this.f13875b = "";
            return this;
        }

        public PremiumInfo clearDiscountDl() {
            this.f13876c = false;
            this.f13877d = "";
            return this;
        }

        public PremiumInfo clearDiscountId() {
            this.f13878e = false;
            this.f13879f = "";
            return this;
        }

        public PremiumInfo clearName() {
            this.f13880g = false;
            this.f13881h = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f13882i < 0) {
                getSerializedSize();
            }
            return this.f13882i;
        }

        public String getDiscountContent() {
            return this.f13875b;
        }

        public String getDiscountDl() {
            return this.f13877d;
        }

        public String getDiscountId() {
            return this.f13879f;
        }

        public String getName() {
            return this.f13881h;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasDiscountContent()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getDiscountContent());
            }
            if (hasDiscountDl()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getDiscountDl());
            }
            if (hasDiscountId()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getDiscountId());
            }
            if (hasName()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getName());
            }
            this.f13882i = i;
            return i;
        }

        public boolean hasDiscountContent() {
            return this.f13874a;
        }

        public boolean hasDiscountDl() {
            return this.f13876c;
        }

        public boolean hasDiscountId() {
            return this.f13878e;
        }

        public boolean hasName() {
            return this.f13880g;
        }

        public final boolean isInitialized() {
            return true;
        }

        public PremiumInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setDiscountContent(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setDiscountDl(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setDiscountId(codedInputStreamMicro.readString());
                        continue;
                    case 34:
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

        public PremiumInfo setDiscountContent(String str) {
            this.f13874a = true;
            this.f13875b = str;
            return this;
        }

        public PremiumInfo setDiscountDl(String str) {
            this.f13876c = true;
            this.f13877d = str;
            return this;
        }

        public PremiumInfo setDiscountId(String str) {
            this.f13878e = true;
            this.f13879f = str;
            return this;
        }

        public PremiumInfo setName(String str) {
            this.f13880g = true;
            this.f13881h = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasDiscountContent()) {
                codedOutputStreamMicro.writeString(1, getDiscountContent());
            }
            if (hasDiscountDl()) {
                codedOutputStreamMicro.writeString(2, getDiscountDl());
            }
            if (hasDiscountId()) {
                codedOutputStreamMicro.writeString(3, getDiscountId());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(4, getName());
            }
        }
    }

    /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Ext$DetailInfo$RecommendDish */
    public static final class RecommendDish extends MessageMicro {
        public static final int COLOR_FIELD_NUMBER = 3;
        public static final int DISH_NAME_FIELD_NUMBER = 2;
        public static final int DISH_NUM_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f13883a;
        /* renamed from: b */
        private int f13884b = 0;
        /* renamed from: c */
        private boolean f13885c;
        /* renamed from: d */
        private String f13886d = "";
        /* renamed from: e */
        private boolean f13887e;
        /* renamed from: f */
        private String f13888f = "";
        /* renamed from: g */
        private int f13889g = -1;

        public static RecommendDish parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new RecommendDish().mergeFrom(codedInputStreamMicro);
        }

        public static RecommendDish parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (RecommendDish) new RecommendDish().mergeFrom(bArr);
        }

        public final RecommendDish clear() {
            clearDishNum();
            clearDishName();
            clearColor();
            this.f13889g = -1;
            return this;
        }

        public RecommendDish clearColor() {
            this.f13887e = false;
            this.f13888f = "";
            return this;
        }

        public RecommendDish clearDishName() {
            this.f13885c = false;
            this.f13886d = "";
            return this;
        }

        public RecommendDish clearDishNum() {
            this.f13883a = false;
            this.f13884b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f13889g < 0) {
                getSerializedSize();
            }
            return this.f13889g;
        }

        public String getColor() {
            return this.f13888f;
        }

        public String getDishName() {
            return this.f13886d;
        }

        public int getDishNum() {
            return this.f13884b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasDishNum()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getDishNum());
            }
            if (hasDishName()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getDishName());
            }
            if (hasColor()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getColor());
            }
            this.f13889g = i;
            return i;
        }

        public boolean hasColor() {
            return this.f13887e;
        }

        public boolean hasDishName() {
            return this.f13885c;
        }

        public boolean hasDishNum() {
            return this.f13883a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public RecommendDish mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setDishNum(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setDishName(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setColor(codedInputStreamMicro.readString());
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

        public RecommendDish setColor(String str) {
            this.f13887e = true;
            this.f13888f = str;
            return this;
        }

        public RecommendDish setDishName(String str) {
            this.f13885c = true;
            this.f13886d = str;
            return this;
        }

        public RecommendDish setDishNum(int i) {
            this.f13883a = true;
            this.f13884b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasDishNum()) {
                codedOutputStreamMicro.writeInt32(1, getDishNum());
            }
            if (hasDishName()) {
                codedOutputStreamMicro.writeString(2, getDishName());
            }
            if (hasColor()) {
                codedOutputStreamMicro.writeString(3, getColor());
            }
        }
    }

    /* renamed from: com.baidu.entity.pb.PoiResult$Contents$Ext$DetailInfo$Upperleftcorner */
    public static final class Upperleftcorner extends MessageMicro {
        public static final int RESOURCE_ID_FIELD_NUMBER = 1;
        public static final int RESOURCE_URL_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f13890a;
        /* renamed from: b */
        private int f13891b = 0;
        /* renamed from: c */
        private boolean f13892c;
        /* renamed from: d */
        private String f13893d = "";
        /* renamed from: e */
        private int f13894e = -1;

        public static Upperleftcorner parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Upperleftcorner().mergeFrom(codedInputStreamMicro);
        }

        public static Upperleftcorner parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Upperleftcorner) new Upperleftcorner().mergeFrom(bArr);
        }

        public final Upperleftcorner clear() {
            clearResourceId();
            clearResourceUrl();
            this.f13894e = -1;
            return this;
        }

        public Upperleftcorner clearResourceId() {
            this.f13890a = false;
            this.f13891b = 0;
            return this;
        }

        public Upperleftcorner clearResourceUrl() {
            this.f13892c = false;
            this.f13893d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f13894e < 0) {
                getSerializedSize();
            }
            return this.f13894e;
        }

        public int getResourceId() {
            return this.f13891b;
        }

        public String getResourceUrl() {
            return this.f13893d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasResourceId()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getResourceId());
            }
            if (hasResourceUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getResourceUrl());
            }
            this.f13894e = i;
            return i;
        }

        public boolean hasResourceId() {
            return this.f13890a;
        }

        public boolean hasResourceUrl() {
            return this.f13892c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Upperleftcorner mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setResourceId(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setResourceUrl(codedInputStreamMicro.readString());
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

        public Upperleftcorner setResourceId(int i) {
            this.f13890a = true;
            this.f13891b = i;
            return this;
        }

        public Upperleftcorner setResourceUrl(String str) {
            this.f13892c = true;
            this.f13893d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasResourceId()) {
                codedOutputStreamMicro.writeInt32(1, getResourceId());
            }
            if (hasResourceUrl()) {
                codedOutputStreamMicro.writeString(2, getResourceUrl());
            }
        }
    }

    public static PoiResult$Contents$Ext$DetailInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new PoiResult$Contents$Ext$DetailInfo().mergeFrom(codedInputStreamMicro);
    }

    public static PoiResult$Contents$Ext$DetailInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (PoiResult$Contents$Ext$DetailInfo) new PoiResult$Contents$Ext$DetailInfo().mergeFrom(bArr);
    }

    public PoiResult$Contents$Ext$DetailInfo addActivity(Activity activity) {
        if (activity != null) {
            if (this.f13929i.isEmpty()) {
                this.f13929i = new ArrayList();
            }
            this.f13929i.add(activity);
        }
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo addFlag(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        if (this.f13930j.isEmpty()) {
            this.f13930j = new ArrayList();
        }
        this.f13930j.add(str);
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo addHotelService(HotelService hotelService) {
        if (hotelService != null) {
            if (this.aH.isEmpty()) {
                this.aH = new ArrayList();
            }
            this.aH.add(hotelService);
        }
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo addImpression(Impression impression) {
        if (impression != null) {
            if (this.f13919Y.isEmpty()) {
                this.f13919Y = new ArrayList();
            }
            this.f13919Y.add(impression);
        }
        return this;
    }

    public final PoiResult$Contents$Ext$DetailInfo clear() {
        clearPremiumInfo();
        clearGrouponInfo();
        clearOrilInfo();
        clearBookInfo();
        clearActivity();
        clearFlag();
        clearOverallRating();
        clearPriceText();
        clearTag();
        clearImage();
        clearShowInfo();
        clearPremiumFlag();
        clearDiscountTotal();
        clearGrouponTotal();
        clearCommentNum();
        clearMovieFlag();
        clearMovieFilmCount();
        clearGrouponFlag();
        clearWapBookable();
        clearPrice();
        clearWiseFullroom();
        clearDiscount();
        clearGrade();
        clearGuide();
        clearSpecialService();
        clearFlagOnLeft();
        clearImpression();
        clearMeishipaihao();
        clearTradeTag();
        clearMarketbiz();
        clearValidate();
        clearWiseHourlyBookable();
        clearDisText();
        clearLbcBusinessVip();
        clearRecommendDish();
        clearBusinessService();
        clearStatusLabel();
        clearUpperleftcorner();
        clearDisplayInfoRedu();
        clearDisplayInfoCommentLabel();
        clearMbc();
        clearAoi();
        clearSpecialTag();
        clearOriginPriceText();
        clearHotelService();
        clearAllcardextension();
        clearShopHours();
        this.aM = -1;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearActivity() {
        this.f13929i = Collections.emptyList();
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearAllcardextension() {
        this.aI = false;
        this.aJ = null;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearAoi() {
        this.aB = false;
        this.aC = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearBookInfo() {
        this.f13927g = false;
        this.f13928h = null;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearBusinessService() {
        this.ap = false;
        this.aq = null;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearCommentNum() {
        this.f13895A = false;
        this.f13896B = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearDisText() {
        this.aj = false;
        this.ak = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearDiscount() {
        this.f13909O = false;
        this.f13910P = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearDiscountTotal() {
        this.f13943w = false;
        this.f13944x = 0;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearDisplayInfoCommentLabel() {
        this.ax = false;
        this.ay = null;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearDisplayInfoRedu() {
        this.av = false;
        this.aw = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearFlag() {
        this.f13930j = Collections.emptyList();
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearFlagOnLeft() {
        this.f13917W = false;
        this.f13918X = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearGrade() {
        this.f13911Q = false;
        this.f13912R = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearGrouponFlag() {
        this.f13901G = false;
        this.f13902H = 0;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearGrouponInfo() {
        this.f13923c = false;
        this.f13924d = null;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearGrouponTotal() {
        this.f13945y = false;
        this.f13946z = 0;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearGuide() {
        this.f13913S = false;
        this.f13914T = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearHotelService() {
        this.aH = Collections.emptyList();
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearImage() {
        this.f13937q = false;
        this.f13938r = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearImpression() {
        this.f13919Y = Collections.emptyList();
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearLbcBusinessVip() {
        this.al = false;
        this.am = null;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearMarketbiz() {
        this.ad = false;
        this.ae = null;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearMbc() {
        this.az = false;
        this.aA = null;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearMeishipaihao() {
        this.f13920Z = false;
        this.aa = null;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearMovieFilmCount() {
        this.f13899E = false;
        this.f13900F = 0;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearMovieFlag() {
        this.f13897C = false;
        this.f13898D = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearOriginPriceText() {
        this.aF = false;
        this.aG = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearOrilInfo() {
        this.f13925e = false;
        this.f13926f = null;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearOverallRating() {
        this.f13931k = false;
        this.f13932l = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearPremiumFlag() {
        this.f13941u = false;
        this.f13942v = 0;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearPremiumInfo() {
        this.f13921a = false;
        this.f13922b = null;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearPrice() {
        this.f13905K = false;
        this.f13906L = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearPriceText() {
        this.f13933m = false;
        this.f13934n = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearRecommendDish() {
        this.an = false;
        this.ao = null;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearShopHours() {
        this.aK = false;
        this.aL = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearShowInfo() {
        this.f13939s = false;
        this.f13940t = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearSpecialService() {
        this.f13915U = false;
        this.f13916V = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearSpecialTag() {
        this.aD = false;
        this.aE = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearStatusLabel() {
        this.ar = false;
        this.as = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearTag() {
        this.f13935o = false;
        this.f13936p = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearTradeTag() {
        this.ab = false;
        this.ac = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearUpperleftcorner() {
        this.at = false;
        this.au = null;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearValidate() {
        this.af = false;
        this.ag = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearWapBookable() {
        this.f13903I = false;
        this.f13904J = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearWiseFullroom() {
        this.f13907M = false;
        this.f13908N = "";
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo clearWiseHourlyBookable() {
        this.ah = false;
        this.ai = "";
        return this;
    }

    public Activity getActivity(int i) {
        return (Activity) this.f13929i.get(i);
    }

    public int getActivityCount() {
        return this.f13929i.size();
    }

    public List<Activity> getActivityList() {
        return this.f13929i;
    }

    public Allcardextension getAllcardextension() {
        return this.aJ;
    }

    public String getAoi() {
        return this.aC;
    }

    public BookInfo getBookInfo() {
        return this.f13928h;
    }

    public BusinessService getBusinessService() {
        return this.aq;
    }

    public int getCachedSize() {
        if (this.aM < 0) {
            getSerializedSize();
        }
        return this.aM;
    }

    public String getCommentNum() {
        return this.f13896B;
    }

    public String getDisText() {
        return this.ak;
    }

    public String getDiscount() {
        return this.f13910P;
    }

    public int getDiscountTotal() {
        return this.f13944x;
    }

    public DisplayInfoCommentLabel getDisplayInfoCommentLabel() {
        return this.ay;
    }

    public String getDisplayInfoRedu() {
        return this.aw;
    }

    public String getFlag(int i) {
        return (String) this.f13930j.get(i);
    }

    public int getFlagCount() {
        return this.f13930j.size();
    }

    public List<String> getFlagList() {
        return this.f13930j;
    }

    public String getFlagOnLeft() {
        return this.f13918X;
    }

    public String getGrade() {
        return this.f13912R;
    }

    public int getGrouponFlag() {
        return this.f13902H;
    }

    public GrouponInfo getGrouponInfo() {
        return this.f13924d;
    }

    public int getGrouponTotal() {
        return this.f13946z;
    }

    public String getGuide() {
        return this.f13914T;
    }

    public HotelService getHotelService(int i) {
        return (HotelService) this.aH.get(i);
    }

    public int getHotelServiceCount() {
        return this.aH.size();
    }

    public List<HotelService> getHotelServiceList() {
        return this.aH;
    }

    public String getImage() {
        return this.f13938r;
    }

    public Impression getImpression(int i) {
        return (Impression) this.f13919Y.get(i);
    }

    public int getImpressionCount() {
        return this.f13919Y.size();
    }

    public List<Impression> getImpressionList() {
        return this.f13919Y;
    }

    public LbcBusinessVip getLbcBusinessVip() {
        return this.am;
    }

    public Marketbiz getMarketbiz() {
        return this.ae;
    }

    public Mbc getMbc() {
        return this.aA;
    }

    public Meishipaihao getMeishipaihao() {
        return this.aa;
    }

    public int getMovieFilmCount() {
        return this.f13900F;
    }

    public String getMovieFlag() {
        return this.f13898D;
    }

    public String getOriginPriceText() {
        return this.aG;
    }

    public OrilInfo getOrilInfo() {
        return this.f13926f;
    }

    public String getOverallRating() {
        return this.f13932l;
    }

    public int getPremiumFlag() {
        return this.f13942v;
    }

    public PremiumInfo getPremiumInfo() {
        return this.f13922b;
    }

    public String getPrice() {
        return this.f13906L;
    }

    public String getPriceText() {
        return this.f13934n;
    }

    public RecommendDish getRecommendDish() {
        return this.ao;
    }

    public int getSerializedSize() {
        int i = 0;
        for (String computeStringSizeNoTag : getFlagList()) {
            i = CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag) + i;
        }
        int size = (0 + i) + (getFlagList().size() * 1);
        if (hasOverallRating()) {
            size += CodedOutputStreamMicro.computeStringSize(2, getOverallRating());
        }
        if (hasPriceText()) {
            size += CodedOutputStreamMicro.computeStringSize(3, getPriceText());
        }
        if (hasTag()) {
            size += CodedOutputStreamMicro.computeStringSize(4, getTag());
        }
        if (hasImage()) {
            size += CodedOutputStreamMicro.computeStringSize(5, getImage());
        }
        if (hasShowInfo()) {
            size += CodedOutputStreamMicro.computeStringSize(6, getShowInfo());
        }
        if (hasPremiumFlag()) {
            size += CodedOutputStreamMicro.computeInt32Size(7, getPremiumFlag());
        }
        if (hasDiscountTotal()) {
            size += CodedOutputStreamMicro.computeInt32Size(8, getDiscountTotal());
        }
        if (hasGrouponTotal()) {
            size += CodedOutputStreamMicro.computeInt32Size(9, getGrouponTotal());
        }
        if (hasPremiumInfo()) {
            size += CodedOutputStreamMicro.computeMessageSize(10, getPremiumInfo());
        }
        if (hasCommentNum()) {
            size += CodedOutputStreamMicro.computeStringSize(11, getCommentNum());
        }
        if (hasMovieFlag()) {
            size += CodedOutputStreamMicro.computeStringSize(12, getMovieFlag());
        }
        if (hasMovieFilmCount()) {
            size += CodedOutputStreamMicro.computeInt32Size(13, getMovieFilmCount());
        }
        if (hasGrouponFlag()) {
            size += CodedOutputStreamMicro.computeInt32Size(14, getGrouponFlag());
        }
        if (hasGrouponInfo()) {
            size += CodedOutputStreamMicro.computeMessageSize(15, getGrouponInfo());
        }
        if (hasOrilInfo()) {
            size += CodedOutputStreamMicro.computeMessageSize(16, getOrilInfo());
        }
        if (hasWapBookable()) {
            size += CodedOutputStreamMicro.computeStringSize(17, getWapBookable());
        }
        if (hasBookInfo()) {
            size += CodedOutputStreamMicro.computeMessageSize(18, getBookInfo());
        }
        if (hasPrice()) {
            size += CodedOutputStreamMicro.computeStringSize(19, getPrice());
        }
        if (hasWiseFullroom()) {
            size += CodedOutputStreamMicro.computeStringSize(20, getWiseFullroom());
        }
        if (hasDiscount()) {
            size += CodedOutputStreamMicro.computeStringSize(21, getDiscount());
        }
        if (hasGrade()) {
            size += CodedOutputStreamMicro.computeStringSize(22, getGrade());
        }
        i = size;
        for (Activity computeMessageSize : getActivityList()) {
            i = CodedOutputStreamMicro.computeMessageSize(23, computeMessageSize) + i;
        }
        if (hasGuide()) {
            i += CodedOutputStreamMicro.computeStringSize(24, getGuide());
        }
        if (hasSpecialService()) {
            i += CodedOutputStreamMicro.computeStringSize(25, getSpecialService());
        }
        if (hasFlagOnLeft()) {
            i += CodedOutputStreamMicro.computeStringSize(26, getFlagOnLeft());
        }
        for (Impression computeMessageSize2 : getImpressionList()) {
            i += CodedOutputStreamMicro.computeMessageSize(27, computeMessageSize2);
        }
        if (hasMeishipaihao()) {
            i += CodedOutputStreamMicro.computeMessageSize(28, getMeishipaihao());
        }
        if (hasTradeTag()) {
            i += CodedOutputStreamMicro.computeStringSize(29, getTradeTag());
        }
        if (hasMarketbiz()) {
            i += CodedOutputStreamMicro.computeMessageSize(30, getMarketbiz());
        }
        if (hasValidate()) {
            i += CodedOutputStreamMicro.computeStringSize(31, getValidate());
        }
        if (hasWiseHourlyBookable()) {
            i += CodedOutputStreamMicro.computeStringSize(32, getWiseHourlyBookable());
        }
        if (hasDisText()) {
            i += CodedOutputStreamMicro.computeStringSize(33, getDisText());
        }
        if (hasLbcBusinessVip()) {
            i += CodedOutputStreamMicro.computeMessageSize(34, getLbcBusinessVip());
        }
        if (hasRecommendDish()) {
            i += CodedOutputStreamMicro.computeMessageSize(36, getRecommendDish());
        }
        if (hasBusinessService()) {
            i += CodedOutputStreamMicro.computeMessageSize(37, getBusinessService());
        }
        if (hasStatusLabel()) {
            i += CodedOutputStreamMicro.computeStringSize(38, getStatusLabel());
        }
        if (hasUpperleftcorner()) {
            i += CodedOutputStreamMicro.computeMessageSize(39, getUpperleftcorner());
        }
        if (hasDisplayInfoRedu()) {
            i += CodedOutputStreamMicro.computeStringSize(40, getDisplayInfoRedu());
        }
        if (hasDisplayInfoCommentLabel()) {
            i += CodedOutputStreamMicro.computeMessageSize(41, getDisplayInfoCommentLabel());
        }
        if (hasMbc()) {
            i += CodedOutputStreamMicro.computeMessageSize(42, getMbc());
        }
        if (hasAoi()) {
            i += CodedOutputStreamMicro.computeStringSize(43, getAoi());
        }
        if (hasSpecialTag()) {
            i += CodedOutputStreamMicro.computeStringSize(44, getSpecialTag());
        }
        if (hasOriginPriceText()) {
            i += CodedOutputStreamMicro.computeStringSize(45, getOriginPriceText());
        }
        for (HotelService computeMessageSize3 : getHotelServiceList()) {
            i += CodedOutputStreamMicro.computeMessageSize(46, computeMessageSize3);
        }
        if (hasAllcardextension()) {
            i += CodedOutputStreamMicro.computeMessageSize(47, getAllcardextension());
        }
        if (hasShopHours()) {
            i += CodedOutputStreamMicro.computeStringSize(48, getShopHours());
        }
        this.aM = i;
        return i;
    }

    public String getShopHours() {
        return this.aL;
    }

    public String getShowInfo() {
        return this.f13940t;
    }

    public String getSpecialService() {
        return this.f13916V;
    }

    public String getSpecialTag() {
        return this.aE;
    }

    public String getStatusLabel() {
        return this.as;
    }

    public String getTag() {
        return this.f13936p;
    }

    public String getTradeTag() {
        return this.ac;
    }

    public Upperleftcorner getUpperleftcorner() {
        return this.au;
    }

    public String getValidate() {
        return this.ag;
    }

    public String getWapBookable() {
        return this.f13904J;
    }

    public String getWiseFullroom() {
        return this.f13908N;
    }

    public String getWiseHourlyBookable() {
        return this.ai;
    }

    public boolean hasAllcardextension() {
        return this.aI;
    }

    public boolean hasAoi() {
        return this.aB;
    }

    public boolean hasBookInfo() {
        return this.f13927g;
    }

    public boolean hasBusinessService() {
        return this.ap;
    }

    public boolean hasCommentNum() {
        return this.f13895A;
    }

    public boolean hasDisText() {
        return this.aj;
    }

    public boolean hasDiscount() {
        return this.f13909O;
    }

    public boolean hasDiscountTotal() {
        return this.f13943w;
    }

    public boolean hasDisplayInfoCommentLabel() {
        return this.ax;
    }

    public boolean hasDisplayInfoRedu() {
        return this.av;
    }

    public boolean hasFlagOnLeft() {
        return this.f13917W;
    }

    public boolean hasGrade() {
        return this.f13911Q;
    }

    public boolean hasGrouponFlag() {
        return this.f13901G;
    }

    public boolean hasGrouponInfo() {
        return this.f13923c;
    }

    public boolean hasGrouponTotal() {
        return this.f13945y;
    }

    public boolean hasGuide() {
        return this.f13913S;
    }

    public boolean hasImage() {
        return this.f13937q;
    }

    public boolean hasLbcBusinessVip() {
        return this.al;
    }

    public boolean hasMarketbiz() {
        return this.ad;
    }

    public boolean hasMbc() {
        return this.az;
    }

    public boolean hasMeishipaihao() {
        return this.f13920Z;
    }

    public boolean hasMovieFilmCount() {
        return this.f13899E;
    }

    public boolean hasMovieFlag() {
        return this.f13897C;
    }

    public boolean hasOriginPriceText() {
        return this.aF;
    }

    public boolean hasOrilInfo() {
        return this.f13925e;
    }

    public boolean hasOverallRating() {
        return this.f13931k;
    }

    public boolean hasPremiumFlag() {
        return this.f13941u;
    }

    public boolean hasPremiumInfo() {
        return this.f13921a;
    }

    public boolean hasPrice() {
        return this.f13905K;
    }

    public boolean hasPriceText() {
        return this.f13933m;
    }

    public boolean hasRecommendDish() {
        return this.an;
    }

    public boolean hasShopHours() {
        return this.aK;
    }

    public boolean hasShowInfo() {
        return this.f13939s;
    }

    public boolean hasSpecialService() {
        return this.f13915U;
    }

    public boolean hasSpecialTag() {
        return this.aD;
    }

    public boolean hasStatusLabel() {
        return this.ar;
    }

    public boolean hasTag() {
        return this.f13935o;
    }

    public boolean hasTradeTag() {
        return this.ab;
    }

    public boolean hasUpperleftcorner() {
        return this.at;
    }

    public boolean hasValidate() {
        return this.af;
    }

    public boolean hasWapBookable() {
        return this.f13903I;
    }

    public boolean hasWiseFullroom() {
        return this.f13907M;
    }

    public boolean hasWiseHourlyBookable() {
        return this.ah;
    }

    public final boolean isInitialized() {
        return true;
    }

    public PoiResult$Contents$Ext$DetailInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro premiumInfo;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    addFlag(codedInputStreamMicro.readString());
                    continue;
                case 18:
                    setOverallRating(codedInputStreamMicro.readString());
                    continue;
                case 26:
                    setPriceText(codedInputStreamMicro.readString());
                    continue;
                case 34:
                    setTag(codedInputStreamMicro.readString());
                    continue;
                case 42:
                    setImage(codedInputStreamMicro.readString());
                    continue;
                case 50:
                    setShowInfo(codedInputStreamMicro.readString());
                    continue;
                case 56:
                    setPremiumFlag(codedInputStreamMicro.readInt32());
                    continue;
                case 64:
                    setDiscountTotal(codedInputStreamMicro.readInt32());
                    continue;
                case NavCarInfo.CarType_57L /*72*/:
                    setGrouponTotal(codedInputStreamMicro.readInt32());
                    continue;
                case 82:
                    premiumInfo = new PremiumInfo();
                    codedInputStreamMicro.readMessage(premiumInfo);
                    setPremiumInfo(premiumInfo);
                    continue;
                case 90:
                    setCommentNum(codedInputStreamMicro.readString());
                    continue;
                case 98:
                    setMovieFlag(codedInputStreamMicro.readString());
                    continue;
                case 104:
                    setMovieFilmCount(codedInputStreamMicro.readInt32());
                    continue;
                case 112:
                    setGrouponFlag(codedInputStreamMicro.readInt32());
                    continue;
                case C1253f.df /*122*/:
                    premiumInfo = new GrouponInfo();
                    codedInputStreamMicro.readMessage(premiumInfo);
                    setGrouponInfo(premiumInfo);
                    continue;
                case 130:
                    premiumInfo = new OrilInfo();
                    codedInputStreamMicro.readMessage(premiumInfo);
                    setOrilInfo(premiumInfo);
                    continue;
                case 138:
                    setWapBookable(codedInputStreamMicro.readString());
                    continue;
                case 146:
                    premiumInfo = new BookInfo();
                    codedInputStreamMicro.readMessage(premiumInfo);
                    setBookInfo(premiumInfo);
                    continue;
                case 154:
                    setPrice(codedInputStreamMicro.readString());
                    continue;
                case 162:
                    setWiseFullroom(codedInputStreamMicro.readString());
                    continue;
                case 170:
                    setDiscount(codedInputStreamMicro.readString());
                    continue;
                case 178:
                    setGrade(codedInputStreamMicro.readString());
                    continue;
                case 186:
                    premiumInfo = new Activity();
                    codedInputStreamMicro.readMessage(premiumInfo);
                    addActivity(premiumInfo);
                    continue;
                case RouteLineResConst.LINE_INTERNAL_NORMAL /*194*/:
                    setGuide(codedInputStreamMicro.readString());
                    continue;
                case 202:
                    setSpecialService(codedInputStreamMicro.readString());
                    continue;
                case C1253f.ds /*210*/:
                    setFlagOnLeft(codedInputStreamMicro.readString());
                    continue;
                case 218:
                    premiumInfo = new Impression();
                    codedInputStreamMicro.readMessage(premiumInfo);
                    addImpression(premiumInfo);
                    continue;
                case C1253f.dG /*226*/:
                    premiumInfo = new Meishipaihao();
                    codedInputStreamMicro.readMessage(premiumInfo);
                    setMeishipaihao(premiumInfo);
                    continue;
                case NaviCmdConstants.ACTION_TYPE_NAVI_TTS_MODE_EXPERT /*234*/:
                    setTradeTag(codedInputStreamMicro.readString());
                    continue;
                case C1253f.dM /*242*/:
                    premiumInfo = new Marketbiz();
                    codedInputStreamMicro.readMessage(premiumInfo);
                    setMarketbiz(premiumInfo);
                    continue;
                case 250:
                    setValidate(codedInputStreamMicro.readString());
                    continue;
                case 258:
                    setWiseHourlyBookable(codedInputStreamMicro.readString());
                    continue;
                case BNOfflineDataObserver.EVENT_UPDATE_PROGRESS /*266*/:
                    setDisText(codedInputStreamMicro.readString());
                    continue;
                case 274:
                    premiumInfo = new LbcBusinessVip();
                    codedInputStreamMicro.readMessage(premiumInfo);
                    setLbcBusinessVip(premiumInfo);
                    continue;
                case 290:
                    premiumInfo = new RecommendDish();
                    codedInputStreamMicro.readMessage(premiumInfo);
                    setRecommendDish(premiumInfo);
                    continue;
                case 298:
                    premiumInfo = new BusinessService();
                    codedInputStreamMicro.readMessage(premiumInfo);
                    setBusinessService(premiumInfo);
                    continue;
                case 306:
                    setStatusLabel(codedInputStreamMicro.readString());
                    continue;
                case C1253f.eb /*314*/:
                    premiumInfo = new Upperleftcorner();
                    codedInputStreamMicro.readMessage(premiumInfo);
                    setUpperleftcorner(premiumInfo);
                    continue;
                case NaviFragmentManager.TYPE_VOICE_SQUARE /*322*/:
                    setDisplayInfoRedu(codedInputStreamMicro.readString());
                    continue;
                case 330:
                    premiumInfo = new DisplayInfoCommentLabel();
                    codedInputStreamMicro.readMessage(premiumInfo);
                    setDisplayInfoCommentLabel(premiumInfo);
                    continue;
                case 338:
                    premiumInfo = new Mbc();
                    codedInputStreamMicro.readMessage(premiumInfo);
                    setMbc(premiumInfo);
                    continue;
                case 346:
                    setAoi(codedInputStreamMicro.readString());
                    continue;
                case BusRouteProvider.START_NODE_STYLE /*354*/:
                    setSpecialTag(codedInputStreamMicro.readString());
                    continue;
                case 362:
                    setOriginPriceText(codedInputStreamMicro.readString());
                    continue;
                case 370:
                    premiumInfo = new HotelService();
                    codedInputStreamMicro.readMessage(premiumInfo);
                    addHotelService(premiumInfo);
                    continue;
                case 378:
                    premiumInfo = new Allcardextension();
                    codedInputStreamMicro.readMessage(premiumInfo);
                    setAllcardextension(premiumInfo);
                    continue;
                case 386:
                    setShopHours(codedInputStreamMicro.readString());
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

    public PoiResult$Contents$Ext$DetailInfo setActivity(int i, Activity activity) {
        if (activity != null) {
            this.f13929i.set(i, activity);
        }
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setAllcardextension(Allcardextension allcardextension) {
        if (allcardextension == null) {
            return clearAllcardextension();
        }
        this.aI = true;
        this.aJ = allcardextension;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setAoi(String str) {
        this.aB = true;
        this.aC = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setBookInfo(BookInfo bookInfo) {
        if (bookInfo == null) {
            return clearBookInfo();
        }
        this.f13927g = true;
        this.f13928h = bookInfo;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setBusinessService(BusinessService businessService) {
        if (businessService == null) {
            return clearBusinessService();
        }
        this.ap = true;
        this.aq = businessService;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setCommentNum(String str) {
        this.f13895A = true;
        this.f13896B = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setDisText(String str) {
        this.aj = true;
        this.ak = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setDiscount(String str) {
        this.f13909O = true;
        this.f13910P = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setDiscountTotal(int i) {
        this.f13943w = true;
        this.f13944x = i;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setDisplayInfoCommentLabel(DisplayInfoCommentLabel displayInfoCommentLabel) {
        if (displayInfoCommentLabel == null) {
            return clearDisplayInfoCommentLabel();
        }
        this.ax = true;
        this.ay = displayInfoCommentLabel;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setDisplayInfoRedu(String str) {
        this.av = true;
        this.aw = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setFlag(int i, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f13930j.set(i, str);
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setFlagOnLeft(String str) {
        this.f13917W = true;
        this.f13918X = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setGrade(String str) {
        this.f13911Q = true;
        this.f13912R = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setGrouponFlag(int i) {
        this.f13901G = true;
        this.f13902H = i;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setGrouponInfo(GrouponInfo grouponInfo) {
        if (grouponInfo == null) {
            return clearGrouponInfo();
        }
        this.f13923c = true;
        this.f13924d = grouponInfo;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setGrouponTotal(int i) {
        this.f13945y = true;
        this.f13946z = i;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setGuide(String str) {
        this.f13913S = true;
        this.f13914T = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setHotelService(int i, HotelService hotelService) {
        if (hotelService != null) {
            this.aH.set(i, hotelService);
        }
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setImage(String str) {
        this.f13937q = true;
        this.f13938r = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setImpression(int i, Impression impression) {
        if (impression != null) {
            this.f13919Y.set(i, impression);
        }
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setLbcBusinessVip(LbcBusinessVip lbcBusinessVip) {
        if (lbcBusinessVip == null) {
            return clearLbcBusinessVip();
        }
        this.al = true;
        this.am = lbcBusinessVip;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setMarketbiz(Marketbiz marketbiz) {
        if (marketbiz == null) {
            return clearMarketbiz();
        }
        this.ad = true;
        this.ae = marketbiz;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setMbc(Mbc mbc) {
        if (mbc == null) {
            return clearMbc();
        }
        this.az = true;
        this.aA = mbc;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setMeishipaihao(Meishipaihao meishipaihao) {
        if (meishipaihao == null) {
            return clearMeishipaihao();
        }
        this.f13920Z = true;
        this.aa = meishipaihao;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setMovieFilmCount(int i) {
        this.f13899E = true;
        this.f13900F = i;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setMovieFlag(String str) {
        this.f13897C = true;
        this.f13898D = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setOriginPriceText(String str) {
        this.aF = true;
        this.aG = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setOrilInfo(OrilInfo orilInfo) {
        if (orilInfo == null) {
            return clearOrilInfo();
        }
        this.f13925e = true;
        this.f13926f = orilInfo;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setOverallRating(String str) {
        this.f13931k = true;
        this.f13932l = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setPremiumFlag(int i) {
        this.f13941u = true;
        this.f13942v = i;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setPremiumInfo(PremiumInfo premiumInfo) {
        if (premiumInfo == null) {
            return clearPremiumInfo();
        }
        this.f13921a = true;
        this.f13922b = premiumInfo;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setPrice(String str) {
        this.f13905K = true;
        this.f13906L = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setPriceText(String str) {
        this.f13933m = true;
        this.f13934n = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setRecommendDish(RecommendDish recommendDish) {
        if (recommendDish == null) {
            return clearRecommendDish();
        }
        this.an = true;
        this.ao = recommendDish;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setShopHours(String str) {
        this.aK = true;
        this.aL = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setShowInfo(String str) {
        this.f13939s = true;
        this.f13940t = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setSpecialService(String str) {
        this.f13915U = true;
        this.f13916V = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setSpecialTag(String str) {
        this.aD = true;
        this.aE = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setStatusLabel(String str) {
        this.ar = true;
        this.as = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setTag(String str) {
        this.f13935o = true;
        this.f13936p = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setTradeTag(String str) {
        this.ab = true;
        this.ac = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setUpperleftcorner(Upperleftcorner upperleftcorner) {
        if (upperleftcorner == null) {
            return clearUpperleftcorner();
        }
        this.at = true;
        this.au = upperleftcorner;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setValidate(String str) {
        this.af = true;
        this.ag = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setWapBookable(String str) {
        this.f13903I = true;
        this.f13904J = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setWiseFullroom(String str) {
        this.f13907M = true;
        this.f13908N = str;
        return this;
    }

    public PoiResult$Contents$Ext$DetailInfo setWiseHourlyBookable(String str) {
        this.ah = true;
        this.ai = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (String writeString : getFlagList()) {
            codedOutputStreamMicro.writeString(1, writeString);
        }
        if (hasOverallRating()) {
            codedOutputStreamMicro.writeString(2, getOverallRating());
        }
        if (hasPriceText()) {
            codedOutputStreamMicro.writeString(3, getPriceText());
        }
        if (hasTag()) {
            codedOutputStreamMicro.writeString(4, getTag());
        }
        if (hasImage()) {
            codedOutputStreamMicro.writeString(5, getImage());
        }
        if (hasShowInfo()) {
            codedOutputStreamMicro.writeString(6, getShowInfo());
        }
        if (hasPremiumFlag()) {
            codedOutputStreamMicro.writeInt32(7, getPremiumFlag());
        }
        if (hasDiscountTotal()) {
            codedOutputStreamMicro.writeInt32(8, getDiscountTotal());
        }
        if (hasGrouponTotal()) {
            codedOutputStreamMicro.writeInt32(9, getGrouponTotal());
        }
        if (hasPremiumInfo()) {
            codedOutputStreamMicro.writeMessage(10, getPremiumInfo());
        }
        if (hasCommentNum()) {
            codedOutputStreamMicro.writeString(11, getCommentNum());
        }
        if (hasMovieFlag()) {
            codedOutputStreamMicro.writeString(12, getMovieFlag());
        }
        if (hasMovieFilmCount()) {
            codedOutputStreamMicro.writeInt32(13, getMovieFilmCount());
        }
        if (hasGrouponFlag()) {
            codedOutputStreamMicro.writeInt32(14, getGrouponFlag());
        }
        if (hasGrouponInfo()) {
            codedOutputStreamMicro.writeMessage(15, getGrouponInfo());
        }
        if (hasOrilInfo()) {
            codedOutputStreamMicro.writeMessage(16, getOrilInfo());
        }
        if (hasWapBookable()) {
            codedOutputStreamMicro.writeString(17, getWapBookable());
        }
        if (hasBookInfo()) {
            codedOutputStreamMicro.writeMessage(18, getBookInfo());
        }
        if (hasPrice()) {
            codedOutputStreamMicro.writeString(19, getPrice());
        }
        if (hasWiseFullroom()) {
            codedOutputStreamMicro.writeString(20, getWiseFullroom());
        }
        if (hasDiscount()) {
            codedOutputStreamMicro.writeString(21, getDiscount());
        }
        if (hasGrade()) {
            codedOutputStreamMicro.writeString(22, getGrade());
        }
        for (Activity writeMessage : getActivityList()) {
            codedOutputStreamMicro.writeMessage(23, writeMessage);
        }
        if (hasGuide()) {
            codedOutputStreamMicro.writeString(24, getGuide());
        }
        if (hasSpecialService()) {
            codedOutputStreamMicro.writeString(25, getSpecialService());
        }
        if (hasFlagOnLeft()) {
            codedOutputStreamMicro.writeString(26, getFlagOnLeft());
        }
        for (Impression writeMessage2 : getImpressionList()) {
            codedOutputStreamMicro.writeMessage(27, writeMessage2);
        }
        if (hasMeishipaihao()) {
            codedOutputStreamMicro.writeMessage(28, getMeishipaihao());
        }
        if (hasTradeTag()) {
            codedOutputStreamMicro.writeString(29, getTradeTag());
        }
        if (hasMarketbiz()) {
            codedOutputStreamMicro.writeMessage(30, getMarketbiz());
        }
        if (hasValidate()) {
            codedOutputStreamMicro.writeString(31, getValidate());
        }
        if (hasWiseHourlyBookable()) {
            codedOutputStreamMicro.writeString(32, getWiseHourlyBookable());
        }
        if (hasDisText()) {
            codedOutputStreamMicro.writeString(33, getDisText());
        }
        if (hasLbcBusinessVip()) {
            codedOutputStreamMicro.writeMessage(34, getLbcBusinessVip());
        }
        if (hasRecommendDish()) {
            codedOutputStreamMicro.writeMessage(36, getRecommendDish());
        }
        if (hasBusinessService()) {
            codedOutputStreamMicro.writeMessage(37, getBusinessService());
        }
        if (hasStatusLabel()) {
            codedOutputStreamMicro.writeString(38, getStatusLabel());
        }
        if (hasUpperleftcorner()) {
            codedOutputStreamMicro.writeMessage(39, getUpperleftcorner());
        }
        if (hasDisplayInfoRedu()) {
            codedOutputStreamMicro.writeString(40, getDisplayInfoRedu());
        }
        if (hasDisplayInfoCommentLabel()) {
            codedOutputStreamMicro.writeMessage(41, getDisplayInfoCommentLabel());
        }
        if (hasMbc()) {
            codedOutputStreamMicro.writeMessage(42, getMbc());
        }
        if (hasAoi()) {
            codedOutputStreamMicro.writeString(43, getAoi());
        }
        if (hasSpecialTag()) {
            codedOutputStreamMicro.writeString(44, getSpecialTag());
        }
        if (hasOriginPriceText()) {
            codedOutputStreamMicro.writeString(45, getOriginPriceText());
        }
        for (HotelService writeMessage3 : getHotelServiceList()) {
            codedOutputStreamMicro.writeMessage(46, writeMessage3);
        }
        if (hasAllcardextension()) {
            codedOutputStreamMicro.writeMessage(47, getAllcardextension());
        }
        if (hasShopHours()) {
            codedOutputStreamMicro.writeString(48, getShopHours());
        }
    }
}
