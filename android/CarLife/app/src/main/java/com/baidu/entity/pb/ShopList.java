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

public final class ShopList extends MessageMicro {
    public static final int DISCOUNT_INFO_FIELD_NUMBER = 5;
    public static final int EXIST_ACTIVITY_FIELD_NUMBER = 7;
    public static final int FILTER_FIELD_NUMBER = 4;
    public static final int INVOICE_INFO_FIELD_NUMBER = 6;
    public static final int OPTION_FIELD_NUMBER = 1;
    public static final int SHOP_INFO_FIELD_NUMBER = 2;
    public static final int TOTAL_FIELD_NUMBER = 3;
    /* renamed from: a */
    private boolean f14543a;
    /* renamed from: b */
    private Option f14544b = null;
    /* renamed from: c */
    private boolean f14545c;
    /* renamed from: d */
    private Filter f14546d = null;
    /* renamed from: e */
    private boolean f14547e;
    /* renamed from: f */
    private DiscountInfo f14548f = null;
    /* renamed from: g */
    private boolean f14549g;
    /* renamed from: h */
    private InvoiceInfo f14550h = null;
    /* renamed from: i */
    private List<ShopInfo> f14551i = Collections.emptyList();
    /* renamed from: j */
    private boolean f14552j;
    /* renamed from: k */
    private int f14553k = 0;
    /* renamed from: l */
    private boolean f14554l;
    /* renamed from: m */
    private String f14555m = "";
    /* renamed from: n */
    private int f14556n = -1;

    public static final class DiscountInfo extends MessageMicro {
        public static final int DISCOUNT_FIRST_ORDER_SHOW_FIELD_NUMBER = 4;
        public static final int DISCOUNT_SEND_SHOW_FIELD_NUMBER = 3;
        public static final int IS_DISCOUNT_FIRST_ORDER_FIELD_NUMBER = 2;
        public static final int IS_DISCOUNT_SEND_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f14461a;
        /* renamed from: b */
        private int f14462b = 0;
        /* renamed from: c */
        private boolean f14463c;
        /* renamed from: d */
        private int f14464d = 0;
        /* renamed from: e */
        private boolean f14465e;
        /* renamed from: f */
        private String f14466f = "";
        /* renamed from: g */
        private boolean f14467g;
        /* renamed from: h */
        private String f14468h = "";
        /* renamed from: i */
        private int f14469i = -1;

        public static DiscountInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new DiscountInfo().mergeFrom(codedInputStreamMicro);
        }

        public static DiscountInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (DiscountInfo) new DiscountInfo().mergeFrom(bArr);
        }

        public final DiscountInfo clear() {
            clearIsDiscountSend();
            clearIsDiscountFirstOrder();
            clearDiscountSendShow();
            clearDiscountFirstOrderShow();
            this.f14469i = -1;
            return this;
        }

        public DiscountInfo clearDiscountFirstOrderShow() {
            this.f14467g = false;
            this.f14468h = "";
            return this;
        }

        public DiscountInfo clearDiscountSendShow() {
            this.f14465e = false;
            this.f14466f = "";
            return this;
        }

        public DiscountInfo clearIsDiscountFirstOrder() {
            this.f14463c = false;
            this.f14464d = 0;
            return this;
        }

        public DiscountInfo clearIsDiscountSend() {
            this.f14461a = false;
            this.f14462b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f14469i < 0) {
                getSerializedSize();
            }
            return this.f14469i;
        }

        public String getDiscountFirstOrderShow() {
            return this.f14468h;
        }

        public String getDiscountSendShow() {
            return this.f14466f;
        }

        public int getIsDiscountFirstOrder() {
            return this.f14464d;
        }

        public int getIsDiscountSend() {
            return this.f14462b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasIsDiscountSend()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIsDiscountSend());
            }
            if (hasIsDiscountFirstOrder()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getIsDiscountFirstOrder());
            }
            if (hasDiscountSendShow()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getDiscountSendShow());
            }
            if (hasDiscountFirstOrderShow()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getDiscountFirstOrderShow());
            }
            this.f14469i = i;
            return i;
        }

        public boolean hasDiscountFirstOrderShow() {
            return this.f14467g;
        }

        public boolean hasDiscountSendShow() {
            return this.f14465e;
        }

        public boolean hasIsDiscountFirstOrder() {
            return this.f14463c;
        }

        public boolean hasIsDiscountSend() {
            return this.f14461a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public DiscountInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setIsDiscountSend(codedInputStreamMicro.readInt32());
                        continue;
                    case 16:
                        setIsDiscountFirstOrder(codedInputStreamMicro.readInt32());
                        continue;
                    case 26:
                        setDiscountSendShow(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setDiscountFirstOrderShow(codedInputStreamMicro.readString());
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

        public DiscountInfo setDiscountFirstOrderShow(String str) {
            this.f14467g = true;
            this.f14468h = str;
            return this;
        }

        public DiscountInfo setDiscountSendShow(String str) {
            this.f14465e = true;
            this.f14466f = str;
            return this;
        }

        public DiscountInfo setIsDiscountFirstOrder(int i) {
            this.f14463c = true;
            this.f14464d = i;
            return this;
        }

        public DiscountInfo setIsDiscountSend(int i) {
            this.f14461a = true;
            this.f14462b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIsDiscountSend()) {
                codedOutputStreamMicro.writeInt32(1, getIsDiscountSend());
            }
            if (hasIsDiscountFirstOrder()) {
                codedOutputStreamMicro.writeInt32(2, getIsDiscountFirstOrder());
            }
            if (hasDiscountSendShow()) {
                codedOutputStreamMicro.writeString(3, getDiscountSendShow());
            }
            if (hasDiscountFirstOrderShow()) {
                codedOutputStreamMicro.writeString(4, getDiscountFirstOrderShow());
            }
        }
    }

    public static final class Filter extends MessageMicro {
        public static final int PROMOTION_FIELD_NUMBER = 3;
        public static final int SORTBY_FIELD_NUMBER = 1;
        public static final int TASTE_FIELD_NUMBER = 4;
        public static final int WD_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f14470a;
        /* renamed from: b */
        private String f14471b = "";
        /* renamed from: c */
        private boolean f14472c;
        /* renamed from: d */
        private String f14473d = "";
        /* renamed from: e */
        private boolean f14474e;
        /* renamed from: f */
        private String f14475f = "";
        /* renamed from: g */
        private boolean f14476g;
        /* renamed from: h */
        private String f14477h = "";
        /* renamed from: i */
        private int f14478i = -1;

        public static Filter parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Filter().mergeFrom(codedInputStreamMicro);
        }

        public static Filter parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Filter) new Filter().mergeFrom(bArr);
        }

        public final Filter clear() {
            clearSortby();
            clearWd();
            clearPromotion();
            clearTaste();
            this.f14478i = -1;
            return this;
        }

        public Filter clearPromotion() {
            this.f14474e = false;
            this.f14475f = "";
            return this;
        }

        public Filter clearSortby() {
            this.f14470a = false;
            this.f14471b = "";
            return this;
        }

        public Filter clearTaste() {
            this.f14476g = false;
            this.f14477h = "";
            return this;
        }

        public Filter clearWd() {
            this.f14472c = false;
            this.f14473d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f14478i < 0) {
                getSerializedSize();
            }
            return this.f14478i;
        }

        public String getPromotion() {
            return this.f14475f;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasSortby()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getSortby());
            }
            if (hasWd()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getWd());
            }
            if (hasPromotion()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getPromotion());
            }
            if (hasTaste()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getTaste());
            }
            this.f14478i = i;
            return i;
        }

        public String getSortby() {
            return this.f14471b;
        }

        public String getTaste() {
            return this.f14477h;
        }

        public String getWd() {
            return this.f14473d;
        }

        public boolean hasPromotion() {
            return this.f14474e;
        }

        public boolean hasSortby() {
            return this.f14470a;
        }

        public boolean hasTaste() {
            return this.f14476g;
        }

        public boolean hasWd() {
            return this.f14472c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Filter mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setSortby(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setWd(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setPromotion(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setTaste(codedInputStreamMicro.readString());
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

        public Filter setPromotion(String str) {
            this.f14474e = true;
            this.f14475f = str;
            return this;
        }

        public Filter setSortby(String str) {
            this.f14470a = true;
            this.f14471b = str;
            return this;
        }

        public Filter setTaste(String str) {
            this.f14476g = true;
            this.f14477h = str;
            return this;
        }

        public Filter setWd(String str) {
            this.f14472c = true;
            this.f14473d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasSortby()) {
                codedOutputStreamMicro.writeString(1, getSortby());
            }
            if (hasWd()) {
                codedOutputStreamMicro.writeString(2, getWd());
            }
            if (hasPromotion()) {
                codedOutputStreamMicro.writeString(3, getPromotion());
            }
            if (hasTaste()) {
                codedOutputStreamMicro.writeString(4, getTaste());
            }
        }
    }

    public static final class InvoiceInfo extends MessageMicro {
        public static final int IS_SUPPORT_INVOICE_FIELD_NUMBER = 1;
        public static final int SUPPORT_INVOICE_SHOW_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f14479a;
        /* renamed from: b */
        private int f14480b = 0;
        /* renamed from: c */
        private boolean f14481c;
        /* renamed from: d */
        private String f14482d = "";
        /* renamed from: e */
        private int f14483e = -1;

        public static InvoiceInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new InvoiceInfo().mergeFrom(codedInputStreamMicro);
        }

        public static InvoiceInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (InvoiceInfo) new InvoiceInfo().mergeFrom(bArr);
        }

        public final InvoiceInfo clear() {
            clearIsSupportInvoice();
            clearSupportInvoiceShow();
            this.f14483e = -1;
            return this;
        }

        public InvoiceInfo clearIsSupportInvoice() {
            this.f14479a = false;
            this.f14480b = 0;
            return this;
        }

        public InvoiceInfo clearSupportInvoiceShow() {
            this.f14481c = false;
            this.f14482d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f14483e < 0) {
                getSerializedSize();
            }
            return this.f14483e;
        }

        public int getIsSupportInvoice() {
            return this.f14480b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasIsSupportInvoice()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIsSupportInvoice());
            }
            if (hasSupportInvoiceShow()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getSupportInvoiceShow());
            }
            this.f14483e = i;
            return i;
        }

        public String getSupportInvoiceShow() {
            return this.f14482d;
        }

        public boolean hasIsSupportInvoice() {
            return this.f14479a;
        }

        public boolean hasSupportInvoiceShow() {
            return this.f14481c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public InvoiceInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setIsSupportInvoice(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setSupportInvoiceShow(codedInputStreamMicro.readString());
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

        public InvoiceInfo setIsSupportInvoice(int i) {
            this.f14479a = true;
            this.f14480b = i;
            return this;
        }

        public InvoiceInfo setSupportInvoiceShow(String str) {
            this.f14481c = true;
            this.f14482d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIsSupportInvoice()) {
                codedOutputStreamMicro.writeInt32(1, getIsSupportInvoice());
            }
            if (hasSupportInvoiceShow()) {
                codedOutputStreamMicro.writeString(2, getSupportInvoiceShow());
            }
        }
    }

    public static final class Option extends MessageMicro {
        public static final int ERROR_MSG_FIELD_NUMBER = 2;
        public static final int ERROR_NO_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f14484a;
        /* renamed from: b */
        private int f14485b = 0;
        /* renamed from: c */
        private boolean f14486c;
        /* renamed from: d */
        private String f14487d = "";
        /* renamed from: e */
        private int f14488e = -1;

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }

        public final Option clear() {
            clearErrorNo();
            clearErrorMsg();
            this.f14488e = -1;
            return this;
        }

        public Option clearErrorMsg() {
            this.f14486c = false;
            this.f14487d = "";
            return this;
        }

        public Option clearErrorNo() {
            this.f14484a = false;
            this.f14485b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f14488e < 0) {
                getSerializedSize();
            }
            return this.f14488e;
        }

        public String getErrorMsg() {
            return this.f14487d;
        }

        public int getErrorNo() {
            return this.f14485b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasErrorNo()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getErrorNo());
            }
            if (hasErrorMsg()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getErrorMsg());
            }
            this.f14488e = i;
            return i;
        }

        public boolean hasErrorMsg() {
            return this.f14486c;
        }

        public boolean hasErrorNo() {
            return this.f14484a;
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
                        setErrorNo(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setErrorMsg(codedInputStreamMicro.readString());
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

        public Option setErrorMsg(String str) {
            this.f14486c = true;
            this.f14487d = str;
            return this;
        }

        public Option setErrorNo(int i) {
            this.f14484a = true;
            this.f14485b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasErrorNo()) {
                codedOutputStreamMicro.writeInt32(1, getErrorNo());
            }
            if (hasErrorMsg()) {
                codedOutputStreamMicro.writeString(2, getErrorMsg());
            }
        }
    }

    public static final class ShopInfo extends MessageMicro {
        public static final int BUSSINESS_STATUS_FIELD_NUMBER = 7;
        public static final int COUPON_INFO_FIELD_NUMBER = 17;
        public static final int DELIVERY_REGIONS_FIELD_NUMBER = 15;
        public static final int DELIVERY_TIME_FIELD_NUMBER = 5;
        public static final int DISCOUNT_INFO_FIELD_NUMBER = 10;
        public static final int DISTANCE_FIELD_NUMBER = 13;
        public static final int END_TIME_FIELD_NUMBER = 11;
        public static final int INVOICE_INFO_FIELD_NUMBER = 16;
        public static final int IS_ONLINE_FIELD_NUMBER = 12;
        public static final int LOGO_URL_FIELD_NUMBER = 2;
        public static final int RELEASE_ID_FIELD_NUMBER = 8;
        public static final int SALED_FIELD_NUMBER = 9;
        public static final int SHOP_ID_FIELD_NUMBER = 14;
        public static final int SHOP_NAME_FIELD_NUMBER = 1;
        public static final int START_TIME_FIELD_NUMBER = 6;
        public static final int TAKEOUT_COST_FIELD_NUMBER = 4;
        public static final int TAKEOUT_PRICE_FIELD_NUMBER = 3;
        /* renamed from: A */
        private boolean f14508A;
        /* renamed from: B */
        private int f14509B = 0;
        /* renamed from: C */
        private boolean f14510C;
        /* renamed from: D */
        private String f14511D = "";
        /* renamed from: E */
        private boolean f14512E;
        /* renamed from: F */
        private String f14513F = "";
        /* renamed from: G */
        private boolean f14514G;
        /* renamed from: H */
        private String f14515H = "";
        /* renamed from: I */
        private int f14516I = -1;
        /* renamed from: a */
        private boolean f14517a;
        /* renamed from: b */
        private DiscountInfo f14518b = null;
        /* renamed from: c */
        private boolean f14519c;
        /* renamed from: d */
        private InvoiceInfo f14520d = null;
        /* renamed from: e */
        private boolean f14521e;
        /* renamed from: f */
        private CouponInfo f14522f = null;
        /* renamed from: g */
        private boolean f14523g;
        /* renamed from: h */
        private String f14524h = "";
        /* renamed from: i */
        private boolean f14525i;
        /* renamed from: j */
        private String f14526j = "";
        /* renamed from: k */
        private boolean f14527k;
        /* renamed from: l */
        private String f14528l = "";
        /* renamed from: m */
        private boolean f14529m;
        /* renamed from: n */
        private String f14530n = "";
        /* renamed from: o */
        private boolean f14531o;
        /* renamed from: p */
        private String f14532p = "";
        /* renamed from: q */
        private boolean f14533q;
        /* renamed from: r */
        private String f14534r = "";
        /* renamed from: s */
        private boolean f14535s;
        /* renamed from: t */
        private int f14536t = 0;
        /* renamed from: u */
        private boolean f14537u;
        /* renamed from: v */
        private String f14538v = "";
        /* renamed from: w */
        private boolean f14539w;
        /* renamed from: x */
        private int f14540x = 0;
        /* renamed from: y */
        private boolean f14541y;
        /* renamed from: z */
        private String f14542z = "";

        public static final class CouponInfo extends MessageMicro {
            public static final int COUPON_MSG_FIELD_NUMBER = 2;
            public static final int SUPPORT_COUPON_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f14489a;
            /* renamed from: b */
            private int f14490b = 0;
            /* renamed from: c */
            private boolean f14491c;
            /* renamed from: d */
            private String f14492d = "";
            /* renamed from: e */
            private int f14493e = -1;

            public static CouponInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new CouponInfo().mergeFrom(codedInputStreamMicro);
            }

            public static CouponInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (CouponInfo) new CouponInfo().mergeFrom(bArr);
            }

            public final CouponInfo clear() {
                clearSupportCoupon();
                clearCouponMsg();
                this.f14493e = -1;
                return this;
            }

            public CouponInfo clearCouponMsg() {
                this.f14491c = false;
                this.f14492d = "";
                return this;
            }

            public CouponInfo clearSupportCoupon() {
                this.f14489a = false;
                this.f14490b = 0;
                return this;
            }

            public int getCachedSize() {
                if (this.f14493e < 0) {
                    getSerializedSize();
                }
                return this.f14493e;
            }

            public String getCouponMsg() {
                return this.f14492d;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasSupportCoupon()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getSupportCoupon());
                }
                if (hasCouponMsg()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getCouponMsg());
                }
                this.f14493e = i;
                return i;
            }

            public int getSupportCoupon() {
                return this.f14490b;
            }

            public boolean hasCouponMsg() {
                return this.f14491c;
            }

            public boolean hasSupportCoupon() {
                return this.f14489a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public CouponInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            setSupportCoupon(codedInputStreamMicro.readInt32());
                            continue;
                        case 18:
                            setCouponMsg(codedInputStreamMicro.readString());
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

            public CouponInfo setCouponMsg(String str) {
                this.f14491c = true;
                this.f14492d = str;
                return this;
            }

            public CouponInfo setSupportCoupon(int i) {
                this.f14489a = true;
                this.f14490b = i;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasSupportCoupon()) {
                    codedOutputStreamMicro.writeInt32(1, getSupportCoupon());
                }
                if (hasCouponMsg()) {
                    codedOutputStreamMicro.writeString(2, getCouponMsg());
                }
            }
        }

        public static final class DiscountInfo extends MessageMicro {
            public static final int DISCOUNT_FIRST_ORDER_SHOW_FIELD_NUMBER = 4;
            public static final int DISCOUNT_SEND_SHOW_FIELD_NUMBER = 3;
            public static final int IS_DISCOUNT_FIRST_ORDER_FIELD_NUMBER = 2;
            public static final int IS_DISCOUNT_SEND_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f14494a;
            /* renamed from: b */
            private int f14495b = 0;
            /* renamed from: c */
            private boolean f14496c;
            /* renamed from: d */
            private int f14497d = 0;
            /* renamed from: e */
            private boolean f14498e;
            /* renamed from: f */
            private String f14499f = "";
            /* renamed from: g */
            private boolean f14500g;
            /* renamed from: h */
            private String f14501h = "";
            /* renamed from: i */
            private int f14502i = -1;

            public static DiscountInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new DiscountInfo().mergeFrom(codedInputStreamMicro);
            }

            public static DiscountInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (DiscountInfo) new DiscountInfo().mergeFrom(bArr);
            }

            public final DiscountInfo clear() {
                clearIsDiscountSend();
                clearIsDiscountFirstOrder();
                clearDiscountSendShow();
                clearDiscountFirstOrderShow();
                this.f14502i = -1;
                return this;
            }

            public DiscountInfo clearDiscountFirstOrderShow() {
                this.f14500g = false;
                this.f14501h = "";
                return this;
            }

            public DiscountInfo clearDiscountSendShow() {
                this.f14498e = false;
                this.f14499f = "";
                return this;
            }

            public DiscountInfo clearIsDiscountFirstOrder() {
                this.f14496c = false;
                this.f14497d = 0;
                return this;
            }

            public DiscountInfo clearIsDiscountSend() {
                this.f14494a = false;
                this.f14495b = 0;
                return this;
            }

            public int getCachedSize() {
                if (this.f14502i < 0) {
                    getSerializedSize();
                }
                return this.f14502i;
            }

            public String getDiscountFirstOrderShow() {
                return this.f14501h;
            }

            public String getDiscountSendShow() {
                return this.f14499f;
            }

            public int getIsDiscountFirstOrder() {
                return this.f14497d;
            }

            public int getIsDiscountSend() {
                return this.f14495b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasIsDiscountSend()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIsDiscountSend());
                }
                if (hasIsDiscountFirstOrder()) {
                    i += CodedOutputStreamMicro.computeInt32Size(2, getIsDiscountFirstOrder());
                }
                if (hasDiscountSendShow()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getDiscountSendShow());
                }
                if (hasDiscountFirstOrderShow()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getDiscountFirstOrderShow());
                }
                this.f14502i = i;
                return i;
            }

            public boolean hasDiscountFirstOrderShow() {
                return this.f14500g;
            }

            public boolean hasDiscountSendShow() {
                return this.f14498e;
            }

            public boolean hasIsDiscountFirstOrder() {
                return this.f14496c;
            }

            public boolean hasIsDiscountSend() {
                return this.f14494a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public DiscountInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            setIsDiscountSend(codedInputStreamMicro.readInt32());
                            continue;
                        case 16:
                            setIsDiscountFirstOrder(codedInputStreamMicro.readInt32());
                            continue;
                        case 26:
                            setDiscountSendShow(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setDiscountFirstOrderShow(codedInputStreamMicro.readString());
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

            public DiscountInfo setDiscountFirstOrderShow(String str) {
                this.f14500g = true;
                this.f14501h = str;
                return this;
            }

            public DiscountInfo setDiscountSendShow(String str) {
                this.f14498e = true;
                this.f14499f = str;
                return this;
            }

            public DiscountInfo setIsDiscountFirstOrder(int i) {
                this.f14496c = true;
                this.f14497d = i;
                return this;
            }

            public DiscountInfo setIsDiscountSend(int i) {
                this.f14494a = true;
                this.f14495b = i;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasIsDiscountSend()) {
                    codedOutputStreamMicro.writeInt32(1, getIsDiscountSend());
                }
                if (hasIsDiscountFirstOrder()) {
                    codedOutputStreamMicro.writeInt32(2, getIsDiscountFirstOrder());
                }
                if (hasDiscountSendShow()) {
                    codedOutputStreamMicro.writeString(3, getDiscountSendShow());
                }
                if (hasDiscountFirstOrderShow()) {
                    codedOutputStreamMicro.writeString(4, getDiscountFirstOrderShow());
                }
            }
        }

        public static final class InvoiceInfo extends MessageMicro {
            public static final int IS_SUPPORT_INVOICE_FIELD_NUMBER = 1;
            public static final int SUPPORT_INVOICE_SHOW_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f14503a;
            /* renamed from: b */
            private int f14504b = 0;
            /* renamed from: c */
            private boolean f14505c;
            /* renamed from: d */
            private String f14506d = "";
            /* renamed from: e */
            private int f14507e = -1;

            public static InvoiceInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new InvoiceInfo().mergeFrom(codedInputStreamMicro);
            }

            public static InvoiceInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (InvoiceInfo) new InvoiceInfo().mergeFrom(bArr);
            }

            public final InvoiceInfo clear() {
                clearIsSupportInvoice();
                clearSupportInvoiceShow();
                this.f14507e = -1;
                return this;
            }

            public InvoiceInfo clearIsSupportInvoice() {
                this.f14503a = false;
                this.f14504b = 0;
                return this;
            }

            public InvoiceInfo clearSupportInvoiceShow() {
                this.f14505c = false;
                this.f14506d = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f14507e < 0) {
                    getSerializedSize();
                }
                return this.f14507e;
            }

            public int getIsSupportInvoice() {
                return this.f14504b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasIsSupportInvoice()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIsSupportInvoice());
                }
                if (hasSupportInvoiceShow()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getSupportInvoiceShow());
                }
                this.f14507e = i;
                return i;
            }

            public String getSupportInvoiceShow() {
                return this.f14506d;
            }

            public boolean hasIsSupportInvoice() {
                return this.f14503a;
            }

            public boolean hasSupportInvoiceShow() {
                return this.f14505c;
            }

            public final boolean isInitialized() {
                return true;
            }

            public InvoiceInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            setIsSupportInvoice(codedInputStreamMicro.readInt32());
                            continue;
                        case 18:
                            setSupportInvoiceShow(codedInputStreamMicro.readString());
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

            public InvoiceInfo setIsSupportInvoice(int i) {
                this.f14503a = true;
                this.f14504b = i;
                return this;
            }

            public InvoiceInfo setSupportInvoiceShow(String str) {
                this.f14505c = true;
                this.f14506d = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasIsSupportInvoice()) {
                    codedOutputStreamMicro.writeInt32(1, getIsSupportInvoice());
                }
                if (hasSupportInvoiceShow()) {
                    codedOutputStreamMicro.writeString(2, getSupportInvoiceShow());
                }
            }
        }

        public static ShopInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ShopInfo().mergeFrom(codedInputStreamMicro);
        }

        public static ShopInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ShopInfo) new ShopInfo().mergeFrom(bArr);
        }

        public final ShopInfo clear() {
            clearDiscountInfo();
            clearInvoiceInfo();
            clearCouponInfo();
            clearShopName();
            clearLogoUrl();
            clearTakeoutPrice();
            clearTakeoutCost();
            clearDeliveryTime();
            clearStartTime();
            clearBussinessStatus();
            clearReleaseId();
            clearSaled();
            clearEndTime();
            clearIsOnline();
            clearDistance();
            clearShopId();
            clearDeliveryRegions();
            this.f14516I = -1;
            return this;
        }

        public ShopInfo clearBussinessStatus() {
            this.f14535s = false;
            this.f14536t = 0;
            return this;
        }

        public ShopInfo clearCouponInfo() {
            this.f14521e = false;
            this.f14522f = null;
            return this;
        }

        public ShopInfo clearDeliveryRegions() {
            this.f14514G = false;
            this.f14515H = "";
            return this;
        }

        public ShopInfo clearDeliveryTime() {
            this.f14531o = false;
            this.f14532p = "";
            return this;
        }

        public ShopInfo clearDiscountInfo() {
            this.f14517a = false;
            this.f14518b = null;
            return this;
        }

        public ShopInfo clearDistance() {
            this.f14510C = false;
            this.f14511D = "";
            return this;
        }

        public ShopInfo clearEndTime() {
            this.f14541y = false;
            this.f14542z = "";
            return this;
        }

        public ShopInfo clearInvoiceInfo() {
            this.f14519c = false;
            this.f14520d = null;
            return this;
        }

        public ShopInfo clearIsOnline() {
            this.f14508A = false;
            this.f14509B = 0;
            return this;
        }

        public ShopInfo clearLogoUrl() {
            this.f14525i = false;
            this.f14526j = "";
            return this;
        }

        public ShopInfo clearReleaseId() {
            this.f14537u = false;
            this.f14538v = "";
            return this;
        }

        public ShopInfo clearSaled() {
            this.f14539w = false;
            this.f14540x = 0;
            return this;
        }

        public ShopInfo clearShopId() {
            this.f14512E = false;
            this.f14513F = "";
            return this;
        }

        public ShopInfo clearShopName() {
            this.f14523g = false;
            this.f14524h = "";
            return this;
        }

        public ShopInfo clearStartTime() {
            this.f14533q = false;
            this.f14534r = "";
            return this;
        }

        public ShopInfo clearTakeoutCost() {
            this.f14529m = false;
            this.f14530n = "";
            return this;
        }

        public ShopInfo clearTakeoutPrice() {
            this.f14527k = false;
            this.f14528l = "";
            return this;
        }

        public int getBussinessStatus() {
            return this.f14536t;
        }

        public int getCachedSize() {
            if (this.f14516I < 0) {
                getSerializedSize();
            }
            return this.f14516I;
        }

        public CouponInfo getCouponInfo() {
            return this.f14522f;
        }

        public String getDeliveryRegions() {
            return this.f14515H;
        }

        public String getDeliveryTime() {
            return this.f14532p;
        }

        public DiscountInfo getDiscountInfo() {
            return this.f14518b;
        }

        public String getDistance() {
            return this.f14511D;
        }

        public String getEndTime() {
            return this.f14542z;
        }

        public InvoiceInfo getInvoiceInfo() {
            return this.f14520d;
        }

        public int getIsOnline() {
            return this.f14509B;
        }

        public String getLogoUrl() {
            return this.f14526j;
        }

        public String getReleaseId() {
            return this.f14538v;
        }

        public int getSaled() {
            return this.f14540x;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasShopName()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getShopName());
            }
            if (hasLogoUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getLogoUrl());
            }
            if (hasTakeoutPrice()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getTakeoutPrice());
            }
            if (hasTakeoutCost()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getTakeoutCost());
            }
            if (hasDeliveryTime()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getDeliveryTime());
            }
            if (hasStartTime()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getStartTime());
            }
            if (hasBussinessStatus()) {
                i += CodedOutputStreamMicro.computeInt32Size(7, getBussinessStatus());
            }
            if (hasReleaseId()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getReleaseId());
            }
            if (hasSaled()) {
                i += CodedOutputStreamMicro.computeInt32Size(9, getSaled());
            }
            if (hasDiscountInfo()) {
                i += CodedOutputStreamMicro.computeMessageSize(10, getDiscountInfo());
            }
            if (hasEndTime()) {
                i += CodedOutputStreamMicro.computeStringSize(11, getEndTime());
            }
            if (hasIsOnline()) {
                i += CodedOutputStreamMicro.computeInt32Size(12, getIsOnline());
            }
            if (hasDistance()) {
                i += CodedOutputStreamMicro.computeStringSize(13, getDistance());
            }
            if (hasShopId()) {
                i += CodedOutputStreamMicro.computeStringSize(14, getShopId());
            }
            if (hasDeliveryRegions()) {
                i += CodedOutputStreamMicro.computeStringSize(15, getDeliveryRegions());
            }
            if (hasInvoiceInfo()) {
                i += CodedOutputStreamMicro.computeMessageSize(16, getInvoiceInfo());
            }
            if (hasCouponInfo()) {
                i += CodedOutputStreamMicro.computeMessageSize(17, getCouponInfo());
            }
            this.f14516I = i;
            return i;
        }

        public String getShopId() {
            return this.f14513F;
        }

        public String getShopName() {
            return this.f14524h;
        }

        public String getStartTime() {
            return this.f14534r;
        }

        public String getTakeoutCost() {
            return this.f14530n;
        }

        public String getTakeoutPrice() {
            return this.f14528l;
        }

        public boolean hasBussinessStatus() {
            return this.f14535s;
        }

        public boolean hasCouponInfo() {
            return this.f14521e;
        }

        public boolean hasDeliveryRegions() {
            return this.f14514G;
        }

        public boolean hasDeliveryTime() {
            return this.f14531o;
        }

        public boolean hasDiscountInfo() {
            return this.f14517a;
        }

        public boolean hasDistance() {
            return this.f14510C;
        }

        public boolean hasEndTime() {
            return this.f14541y;
        }

        public boolean hasInvoiceInfo() {
            return this.f14519c;
        }

        public boolean hasIsOnline() {
            return this.f14508A;
        }

        public boolean hasLogoUrl() {
            return this.f14525i;
        }

        public boolean hasReleaseId() {
            return this.f14537u;
        }

        public boolean hasSaled() {
            return this.f14539w;
        }

        public boolean hasShopId() {
            return this.f14512E;
        }

        public boolean hasShopName() {
            return this.f14523g;
        }

        public boolean hasStartTime() {
            return this.f14533q;
        }

        public boolean hasTakeoutCost() {
            return this.f14529m;
        }

        public boolean hasTakeoutPrice() {
            return this.f14527k;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ShopInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro discountInfo;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setShopName(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setLogoUrl(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setTakeoutPrice(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setTakeoutCost(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setDeliveryTime(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setStartTime(codedInputStreamMicro.readString());
                        continue;
                    case 56:
                        setBussinessStatus(codedInputStreamMicro.readInt32());
                        continue;
                    case 66:
                        setReleaseId(codedInputStreamMicro.readString());
                        continue;
                    case NavCarInfo.CarType_57L /*72*/:
                        setSaled(codedInputStreamMicro.readInt32());
                        continue;
                    case 82:
                        discountInfo = new DiscountInfo();
                        codedInputStreamMicro.readMessage(discountInfo);
                        setDiscountInfo(discountInfo);
                        continue;
                    case 90:
                        setEndTime(codedInputStreamMicro.readString());
                        continue;
                    case 96:
                        setIsOnline(codedInputStreamMicro.readInt32());
                        continue;
                    case 106:
                        setDistance(codedInputStreamMicro.readString());
                        continue;
                    case 114:
                        setShopId(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.df /*122*/:
                        setDeliveryRegions(codedInputStreamMicro.readString());
                        continue;
                    case 130:
                        discountInfo = new InvoiceInfo();
                        codedInputStreamMicro.readMessage(discountInfo);
                        setInvoiceInfo(discountInfo);
                        continue;
                    case 138:
                        discountInfo = new CouponInfo();
                        codedInputStreamMicro.readMessage(discountInfo);
                        setCouponInfo(discountInfo);
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

        public ShopInfo setBussinessStatus(int i) {
            this.f14535s = true;
            this.f14536t = i;
            return this;
        }

        public ShopInfo setCouponInfo(CouponInfo couponInfo) {
            if (couponInfo == null) {
                return clearCouponInfo();
            }
            this.f14521e = true;
            this.f14522f = couponInfo;
            return this;
        }

        public ShopInfo setDeliveryRegions(String str) {
            this.f14514G = true;
            this.f14515H = str;
            return this;
        }

        public ShopInfo setDeliveryTime(String str) {
            this.f14531o = true;
            this.f14532p = str;
            return this;
        }

        public ShopInfo setDiscountInfo(DiscountInfo discountInfo) {
            if (discountInfo == null) {
                return clearDiscountInfo();
            }
            this.f14517a = true;
            this.f14518b = discountInfo;
            return this;
        }

        public ShopInfo setDistance(String str) {
            this.f14510C = true;
            this.f14511D = str;
            return this;
        }

        public ShopInfo setEndTime(String str) {
            this.f14541y = true;
            this.f14542z = str;
            return this;
        }

        public ShopInfo setInvoiceInfo(InvoiceInfo invoiceInfo) {
            if (invoiceInfo == null) {
                return clearInvoiceInfo();
            }
            this.f14519c = true;
            this.f14520d = invoiceInfo;
            return this;
        }

        public ShopInfo setIsOnline(int i) {
            this.f14508A = true;
            this.f14509B = i;
            return this;
        }

        public ShopInfo setLogoUrl(String str) {
            this.f14525i = true;
            this.f14526j = str;
            return this;
        }

        public ShopInfo setReleaseId(String str) {
            this.f14537u = true;
            this.f14538v = str;
            return this;
        }

        public ShopInfo setSaled(int i) {
            this.f14539w = true;
            this.f14540x = i;
            return this;
        }

        public ShopInfo setShopId(String str) {
            this.f14512E = true;
            this.f14513F = str;
            return this;
        }

        public ShopInfo setShopName(String str) {
            this.f14523g = true;
            this.f14524h = str;
            return this;
        }

        public ShopInfo setStartTime(String str) {
            this.f14533q = true;
            this.f14534r = str;
            return this;
        }

        public ShopInfo setTakeoutCost(String str) {
            this.f14529m = true;
            this.f14530n = str;
            return this;
        }

        public ShopInfo setTakeoutPrice(String str) {
            this.f14527k = true;
            this.f14528l = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasShopName()) {
                codedOutputStreamMicro.writeString(1, getShopName());
            }
            if (hasLogoUrl()) {
                codedOutputStreamMicro.writeString(2, getLogoUrl());
            }
            if (hasTakeoutPrice()) {
                codedOutputStreamMicro.writeString(3, getTakeoutPrice());
            }
            if (hasTakeoutCost()) {
                codedOutputStreamMicro.writeString(4, getTakeoutCost());
            }
            if (hasDeliveryTime()) {
                codedOutputStreamMicro.writeString(5, getDeliveryTime());
            }
            if (hasStartTime()) {
                codedOutputStreamMicro.writeString(6, getStartTime());
            }
            if (hasBussinessStatus()) {
                codedOutputStreamMicro.writeInt32(7, getBussinessStatus());
            }
            if (hasReleaseId()) {
                codedOutputStreamMicro.writeString(8, getReleaseId());
            }
            if (hasSaled()) {
                codedOutputStreamMicro.writeInt32(9, getSaled());
            }
            if (hasDiscountInfo()) {
                codedOutputStreamMicro.writeMessage(10, getDiscountInfo());
            }
            if (hasEndTime()) {
                codedOutputStreamMicro.writeString(11, getEndTime());
            }
            if (hasIsOnline()) {
                codedOutputStreamMicro.writeInt32(12, getIsOnline());
            }
            if (hasDistance()) {
                codedOutputStreamMicro.writeString(13, getDistance());
            }
            if (hasShopId()) {
                codedOutputStreamMicro.writeString(14, getShopId());
            }
            if (hasDeliveryRegions()) {
                codedOutputStreamMicro.writeString(15, getDeliveryRegions());
            }
            if (hasInvoiceInfo()) {
                codedOutputStreamMicro.writeMessage(16, getInvoiceInfo());
            }
            if (hasCouponInfo()) {
                codedOutputStreamMicro.writeMessage(17, getCouponInfo());
            }
        }
    }

    public static ShopList parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new ShopList().mergeFrom(codedInputStreamMicro);
    }

    public static ShopList parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (ShopList) new ShopList().mergeFrom(bArr);
    }

    public ShopList addShopInfo(ShopInfo shopInfo) {
        if (shopInfo != null) {
            if (this.f14551i.isEmpty()) {
                this.f14551i = new ArrayList();
            }
            this.f14551i.add(shopInfo);
        }
        return this;
    }

    public final ShopList clear() {
        clearOption();
        clearFilter();
        clearDiscountInfo();
        clearInvoiceInfo();
        clearShopInfo();
        clearTotal();
        clearExistActivity();
        this.f14556n = -1;
        return this;
    }

    public ShopList clearDiscountInfo() {
        this.f14547e = false;
        this.f14548f = null;
        return this;
    }

    public ShopList clearExistActivity() {
        this.f14554l = false;
        this.f14555m = "";
        return this;
    }

    public ShopList clearFilter() {
        this.f14545c = false;
        this.f14546d = null;
        return this;
    }

    public ShopList clearInvoiceInfo() {
        this.f14549g = false;
        this.f14550h = null;
        return this;
    }

    public ShopList clearOption() {
        this.f14543a = false;
        this.f14544b = null;
        return this;
    }

    public ShopList clearShopInfo() {
        this.f14551i = Collections.emptyList();
        return this;
    }

    public ShopList clearTotal() {
        this.f14552j = false;
        this.f14553k = 0;
        return this;
    }

    public int getCachedSize() {
        if (this.f14556n < 0) {
            getSerializedSize();
        }
        return this.f14556n;
    }

    public DiscountInfo getDiscountInfo() {
        return this.f14548f;
    }

    public String getExistActivity() {
        return this.f14555m;
    }

    public Filter getFilter() {
        return this.f14546d;
    }

    public InvoiceInfo getInvoiceInfo() {
        return this.f14550h;
    }

    public Option getOption() {
        return this.f14544b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasOption()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
        }
        int i2 = i;
        for (ShopInfo computeMessageSize : getShopInfoList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
        }
        if (hasTotal()) {
            i2 += CodedOutputStreamMicro.computeInt32Size(3, getTotal());
        }
        if (hasFilter()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(4, getFilter());
        }
        if (hasDiscountInfo()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(5, getDiscountInfo());
        }
        if (hasInvoiceInfo()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(6, getInvoiceInfo());
        }
        if (hasExistActivity()) {
            i2 += CodedOutputStreamMicro.computeStringSize(7, getExistActivity());
        }
        this.f14556n = i2;
        return i2;
    }

    public ShopInfo getShopInfo(int i) {
        return (ShopInfo) this.f14551i.get(i);
    }

    public int getShopInfoCount() {
        return this.f14551i.size();
    }

    public List<ShopInfo> getShopInfoList() {
        return this.f14551i;
    }

    public int getTotal() {
        return this.f14553k;
    }

    public boolean hasDiscountInfo() {
        return this.f14547e;
    }

    public boolean hasExistActivity() {
        return this.f14554l;
    }

    public boolean hasFilter() {
        return this.f14545c;
    }

    public boolean hasInvoiceInfo() {
        return this.f14549g;
    }

    public boolean hasOption() {
        return this.f14543a;
    }

    public boolean hasTotal() {
        return this.f14552j;
    }

    public final boolean isInitialized() {
        return true;
    }

    public ShopList mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                    option = new ShopInfo();
                    codedInputStreamMicro.readMessage(option);
                    addShopInfo(option);
                    continue;
                case 24:
                    setTotal(codedInputStreamMicro.readInt32());
                    continue;
                case 34:
                    option = new Filter();
                    codedInputStreamMicro.readMessage(option);
                    setFilter(option);
                    continue;
                case 42:
                    option = new DiscountInfo();
                    codedInputStreamMicro.readMessage(option);
                    setDiscountInfo(option);
                    continue;
                case 50:
                    option = new InvoiceInfo();
                    codedInputStreamMicro.readMessage(option);
                    setInvoiceInfo(option);
                    continue;
                case 58:
                    setExistActivity(codedInputStreamMicro.readString());
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

    public ShopList setDiscountInfo(DiscountInfo discountInfo) {
        if (discountInfo == null) {
            return clearDiscountInfo();
        }
        this.f14547e = true;
        this.f14548f = discountInfo;
        return this;
    }

    public ShopList setExistActivity(String str) {
        this.f14554l = true;
        this.f14555m = str;
        return this;
    }

    public ShopList setFilter(Filter filter) {
        if (filter == null) {
            return clearFilter();
        }
        this.f14545c = true;
        this.f14546d = filter;
        return this;
    }

    public ShopList setInvoiceInfo(InvoiceInfo invoiceInfo) {
        if (invoiceInfo == null) {
            return clearInvoiceInfo();
        }
        this.f14549g = true;
        this.f14550h = invoiceInfo;
        return this;
    }

    public ShopList setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f14543a = true;
        this.f14544b = option;
        return this;
    }

    public ShopList setShopInfo(int i, ShopInfo shopInfo) {
        if (shopInfo != null) {
            this.f14551i.set(i, shopInfo);
        }
        return this;
    }

    public ShopList setTotal(int i) {
        this.f14552j = true;
        this.f14553k = i;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(1, getOption());
        }
        for (ShopInfo writeMessage : getShopInfoList()) {
            codedOutputStreamMicro.writeMessage(2, writeMessage);
        }
        if (hasTotal()) {
            codedOutputStreamMicro.writeInt32(3, getTotal());
        }
        if (hasFilter()) {
            codedOutputStreamMicro.writeMessage(4, getFilter());
        }
        if (hasDiscountInfo()) {
            codedOutputStreamMicro.writeMessage(5, getDiscountInfo());
        }
        if (hasInvoiceInfo()) {
            codedOutputStreamMicro.writeMessage(6, getInvoiceInfo());
        }
        if (hasExistActivity()) {
            codedOutputStreamMicro.writeString(7, getExistActivity());
        }
    }
}
